package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;

public final class __viewbirthregmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ViewBirthRegMain.jsp", 1742452382961L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n \n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t<html>\n\t\t<head>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t<Script src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></Script>\n\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t\t<script src=\'../../eMP/js/NewbornRegistration.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eMP/js/NewbornRegistration1.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eMP/js/NewbornRegistration2.js\' language=\'javascript\'></script>\n\t\t\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t\t<Script src=\"../../eCommon/js/calScript/hj/calendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t<style type = \'text/css\'>\n\n\t\t\t\tdiv#mother_dtls {\t\t\t\t\t\n\t\t\t\t\tdisplay:inline;\n\t\t\t\t}\t\t\t\n\n\t\t\t\tdiv#father_dtls {\t\n\t\t\t\t\tdisplay:inline;\n\t\t\t\t} \t\t\t\n\n\t\t\t\tdiv#newborn_dtls {\t\t\t\t\t\n\t\t\t\t\tdisplay:inline;\n\t\t\t\t}\n\n\t\t\t\tdiv#vaccin_dtls {\t\t\t\t\t\n\t\t\t\t\tdisplay:inline;\n\t\t\t\t}\n\n\t\t\t\tspan#mother_dtls_link {\t\t\t\t\t\n\t\t\t\t\tcursor:pointer;\n\t\t\t\t\tcolor:white;\n\t\t\t\t\tfont-size:15px;\n\t\t\t\t\tfont-weight:bold;\n\t\t\t\t}\n\n\t\t\t\tspan#father_dtls_link {\t\t\t\t\t\n\t\t\t\t\tcursor:pointer;\n\t\t\t\t\tcolor:white;\n\t\t\t\t\tfont-size:15px;\n\t\t\t\t\tfont-weight:bold;\n\t\t\t\t} \n\t\t\t\t\n\t\t\t\tspan#newborn_dtls_link {\t\t\t\t\t\n\t\t\t\t\tcursor:pointer;\n\t\t\t\t\tcolor:white;\n\t\t\t\t\tfont-size:15px;\n\t\t\t\t\tfont-weight:bold;\n\t\t\t\t}\n\n\t\t\t\tspan#vaccin_dtls_link {\t\t\t\t\t\n\t\t\t\t\tcursor:pointer;\n\t\t\t\t\tcolor:white;\n\t\t\t\t\tfont-size:15px;\n\t\t\t\t\tfont-weight:bold;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t</style>\n\t\t\t<script>\n\n\t\t\tfunction apgarLink(obj)\n\t\t\t{\n\t\t\t\tvar apgarLinkValue=document.getElementById(\"apgar_dtls_name\").value;\n\t\t\t\tif(obj.value==\"+\"){\n\t\t\t\t\tobj.value=\"-\";\n\t\t\t\t\tdocument.getElementById(\'apgarDivID\').style.visibility=\"visible\";\n\t\t\t\t\tdocument.getElementById(\'apgarDivID\').style.display=\"\";\n\t\t\t\t\tdocument.getElementById(\'apgarDivID\').style.display=\"inline\";\n\t\t\t\t}else{\n\t\t\t\t\tobj.value=\"+\";\n\t\t\t\t\tdocument.getElementById(\'apgarDivID\').style.visibility=\"hidden\";\n\t\t\t\t\tdocument.getElementById(\'apgarDivID\').style.display=\"None\";\n\t\t\t\t}\n\t\t\t}\n\t\t\t</script>\n\n\t\t\t<script>\n\t\t\t\tfunction tab_click1(id,id1){\n\t\t\t\t\ttab_click(id);\n\t\t\t\t}\n\n\t\t\t\tfunction expandCollapse(calledFrom) {\t\t\t\t\t\n\n\t\t\t\t\tif(calledFrom == \'MD\') {\n\n\t\t\t\t\t\tif(document.getElementById(\'mother_dtls\').style.display == \'\')\n\t\t\t\t\t\t\tdocument.getElementById(\'mother_dtls\').style.display=\'inline\';\n\n\t\t\t\t\t\tif(document.getElementById(\'mother_dtls\').style.display == \'inline\') {\n\t\t\t\t\t\t\tdocument.getElementById(\'mother_dtls\').style.display=\'none\';\t\n\t\t\t\t\t\t\tdocument.getElementById(\'mother_dtls_link\').innerHTML=\"<input type=\'button\' class=\'button\' value=\'+\'>\";\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tdocument.getElementById(\'mother_dtls\').style.display=\'inline\';\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\'mother_dtls_link\').innerHTML=\"<input type=\'button\' class=\'button\' value=\'-\'>\"; \t\t\t\t\t\t\t\n\t\t\t\t\t\t} \t\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'FD\') {\n \n\t\t\t\t\t\tif(document.getElementById(\'father_dtls\').style.display == \'\')\n\t\t\t\t\t\t\tdocument.getElementById(\'father_dtls\').style.display=\'inline\';\n\n\t\t\t\t\t\tif(document.getElementById(\'father_dtls\').style.display == \'inline\') {\n\t\t\t\t\t\t\tdocument.getElementById(\'father_dtls\').style.display=\'none\';\n\t\t\t\t\t\t\tdocument.getElementById(\'father_dtls_link\').innerHTML=\"<input type=\'button\' class=\'button\' value=\'+\'>\";\t\t\t\t\t\t\t\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tdocument.getElementById(\'father_dtls\').style.display=\'inline\';\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\'father_dtls_link\').innerHTML=\"<input type=\'button\' class=\'button\' value=\'-\'>\";\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\t\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'ND\') {\n\n\t\t\t\t\t\tif(document.getElementById(\'newborn_dtls\').style.display == \'\')\n\t\t\t\t\t\t\tdocument.getElementById(\'newborn_dtls\').style.display=\'inline\';\n\n\t\t\t\t\t\tif(document.getElementById(\'newborn_dtls\').style.display == \'inline\') {\n\t\t\t\t\t\t\tdocument.getElementById(\'newborn_dtls\').style.display=\'none\';\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\'newborn_dtls_link\').innerHTML=\"<input type=\'button\' class=\'button\' value=\'+\'>\"; \t\t\t\t\t\t\t\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tdocument.getElementById(\'newborn_dtls\').style.display=\'inline\';\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\'newborn_dtls_link\').innerHTML=\"<input type=\'button\' class=\'button\' value=\'-\'>\"; \t\t\t\t\t\t\t\n\t\t\t\t\t\t} \t\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'VD\') {\n\n\t\t\t\t\t\tif(document.getElementById(\'vaccin_dtls\').style.display == \'\')\n\t\t\t\t\t\t\tdocument.getElementById(\'vaccin_dtls\').style.display=\'inline\';  \n\n\t\t\t\t\t\tif(document.getElementById(\'vaccin_dtls\').style.display == \'inline\') {\n\t\t\t\t\t\t\tdocument.getElementById(\'vaccin_dtls\').style.display=\'none\';\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\'vaccin_dtls_link\').innerHTML=\"<input type=\'button\' class=\'button\' value=\'+\'>\";\t\t\t\t\t\t\t\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tdocument.getElementById(\'vaccin_dtls\').style.display=\'inline\';\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\'vaccin_dtls_link\').innerHTML=\"<input type=\'button\' class=\'button\' value=\'-\'>\"; \t\t\t\t\t\t\t\n\t\t\t\t\t\t} \t\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t</script>\n\n\t<body  OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\t<form name=\'NewbornRegistration_form\' id=\'NewbornRegistration_form\' action=\'../../servlet/eMP.NewbornRegistrationServlet\' method=\'post\' target=\'messageFrame\' onSubmit=\"return getNewBornRegnValues(\'pat_id\')\">\n\n\t\t\t<table width=\"100%\" cellpadding=\'3\' cellspacing=0 border=\'0\'>\n\t\t\t\t<tr><td>\n\t\t\t\t\t<table id=\'mother_tab\' width=\"100%\" cellpadding=\'3\' cellspacing=0 border=\'0\'>\n\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t\t<td colspan=\'4\' class=\'COLUMNHEADER\'><span id=\'mother_dtls_link\' onClick=\'javascript:expandCollapse(\"MD\")\'><input type=\'button\' class=\'button\' value=\'-\' name=\'mother_button\' id=\'mother_button\'></span>&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td></tr>\n\t\t\t\t<tr><td>\n\t\t\t\t<div id=\'mother_dtls\'>\n\t\t\t\t\t<table width=\"100%\" cellpadding=\'3\' cellspacing=0 border=\'0\'>\n\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\t\n          <tr>\t\t       \n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t  <td class=\'label\' height=\"25\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;</td>\n\t\t\t\t\t  <td class=\'QUERYDATA\' height=\"25\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;</td>\n    ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t          <td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t  <td class=\'QUERYDATA\' >&nbsp;</td>\n\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t      <td class=\'label\'>&nbsp;</td>\n\t\t\t\t      <td class=\'QUERYDATA\'>&nbsp;</td>  \t\t\t\t\n\t\t\t</tr> \n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\n<tr>\t\t\t     \n\t\t\t<td class=\'label\' height=\"25\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td><input type = \'hidden\' name =\'alt_id_type_desc\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'> ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t <td class=\'QUERYDATA\' height=\"25\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;</td>\n            ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t  <td  class=\"label\"  height=\"25\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t  <td class=\'QUERYDATA\'  height=\"25\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;</td>\n\t\t\t          \n\t\t\t   ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t   \n\t\t\t   <tr> \n\t\t\t\n\t\t\t   ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t   <td class=\'label\' height=\"25\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" </td>\n\t\t\t\t\t  <td class=\'QUERYDATA\' height=\"25\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;</td>\n\t\t\t   ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t   </tr>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nbsp;";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t\t<td class=\'querydata\' width=\'75%\' colspan=3><b>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t<tr> \n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" </td>\n\t\t\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</b></td> \n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</b></td> \n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr> \n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</b></td> \n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</b></td> \n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="<b></b></td>\n\t\t\t\t\t<td class=\'label\'   width=\'25%\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b></td>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" </td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n\t\t\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;</b>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;\n\t\t\t\t\t</b>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="<!--Added by Rameswar on 07th July 2015 against HSA-CRF-0223 IN050565-->\n\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</b></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<!--Added by Rameswar on 07th July 2015 against HSA-CRF-0223 IN050565-->\n\t\t\t\t\t<td class=\'label\'   width=\'25%\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t<td class=\'label\'   width=\'25%\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" &nbsp; ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<!--Modified by Ashwini on 11-Jul-2018 for ML-MMOH-CRF-0898.2-->\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</b></td>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t\t\t<td class=\'querydata\' width=\'25%\' style=\'word-wrap:break-word;width:300px\'><b>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t<!--End ML-MMOH-CRF-0898.2-->\n\t\t\t\t\t<!--Below line added for this CRF ML-MMOH-CRF-0621-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="&nbsp;\n\t\t\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&nbsp;</b></td>\n\t\t\t\t\t<td class=\'label\' width=\'25%\' >&nbsp;</td>\n\t\t\t\t\t<td class=\'querydata\' width=\'25%\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n                    ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t\t\t\t\t\n\t\t\t\t\t<!--End ML-MMOH-CRF-0621-->\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t<!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t<td class=\'querydata\' width=\'25%\' style=\'word-wrap:break-word;width:300px;\'><b>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</b></td>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t <tr>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</b></td>\n\t\t\t\t\t<!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t <tr>\n\t\t\t\t\t<!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<!--Added by Ashwini on 11-Jul-2018 for ML-MMOH-CRF-0898.2-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<!--End ML-MMOH-CRF-0898.2-->\n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t</td></tr> \n\t\t\t\n\t\t\t<tr><td>\t\t\n\t\t\t<table id=\'father_tab\' width=\"100%\" cellpadding=\'3\' cellspacing=0 border=0 >\t\n\t\t\t\t<tr><td colspan=\'4\' class=\'COLUMNHEADER\'><span id=\'father_dtls_link\' onClick=\'javascript:expandCollapse(\"FD\")\'><input type=\'button\' class=\'button\' value=\'-\' name=\'father_button\' id=\'father_button\'></span>&nbsp;";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td></tr>\n\t\t\t</table>\n\t\t\t<tr><td>\n\t\t\t<div id=\'father_dtls\'>\n\t\t\t<table width=\"100%\" cellpadding=\'3\' cellspacing=0 border=0 >\t\n\t\t\t <tr>\n\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</b></td>\n\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</b></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td colspan=4 align=\"left\">\n\t\t\t<table border=0 cellpadding=\'1\' cellspacing=0 width=\"100%\" align=\"left\">\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\t\n\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<tr>\n\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\t\t<td class=\'querydata\' width=\'75%\' colspan=3><b>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t</tr>\n\t\t\t<tr> \n\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</b></td> \n\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</b></td> \n\t\t\t</tr>\n\t\t\t<tr> \n\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</b></td> \n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</b></td> \n\t\t\t<!--<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" </td> \n\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</b></td>-->\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td  class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\n\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</b></td>\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" </td>\n\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</b></td> \n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" </td>\n\t\t\t<td class=\'querydata\'width=\'25%\' ><b>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</b></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="  </td>\n\t\t\t<td class=\'querydata\' width=\'25%\'>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n\t\t\t</tr>\n\t\t\t <tr>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'  >";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t</tr>\t\t\t\t\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\n\t\t\t</div>\n\t\t\t</td></tr>\n\t\t\t<tr><td colspan=4>\t\t\n\t\t\t<table id=\'nb_tab\' width=\"100%\" cellpadding=\'3\' cellspacing=0 border=1 >\t\n\t\t\t\t<tr><td colspan=\'4\' class=\'COLUMNHEADER\'><span id = \'newborn_dtls_link\' onClick=\'javascript:expandCollapse(\"ND\")\'><input type=\'button\' class=\'button\' value=\'-\' name=\'nb_button\' id=\'nb_button\'></span>&nbsp;";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td></tr>\n\t\t\t</table>\n\t\t\t<tr><td colspan=4>\n\t\t\t<div id=\'newborn_dtls\'>\n\t\t\t<table width=\"100%\" cellpadding=\'3\' cellspacing=0 border=0 >\t\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</b></td>\n\t\t\t</tr>\t\n\t\t\t\t\t\t<tr>\n\t\t\t<td colspan=6 align=\"left\">\n\t\t\t<table border=0 cellpadding=\'1\' cellspacing=0 width=\"100%\" align=\"left\">\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<tr>\n\t\t\t<!-- <td colspan=4> <table border=1 cellpadding=\'3\' cellspacing=0 width=\"100%\">\n\t\t\t<tr> -->\n\t\t\t<!-- Below line modified for this CRF MMS-QH-CRF-0145.1 [IN:047497] -->\n\t\t\t<td class=\'label\'  width=\'18%\'  >";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t\t\t<td class=\'querydata\' width=\'18%\'><b>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</b></td>\n\t\t\t<td class=\'label\' width=\'18%\'>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="  </td>\n\t\t\t<td class=\"label\" width=\'46%\' colspan=\'3\'><b>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="&nbsp;&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="&nbsp;&nbsp;&nbsp;<b><span id=\"hiji_date_display\">";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</span></b>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\n\t\t\t\n\t\t\t</tr>\n\t\t\t<!-- </table>\n\t\t\t</td>\n\t\t\t</tr> -->\n\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t\t\t<td class=\'querydata\'  width=\'25%\'><b>";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</b></td>\n\t\t\t<td class=\"label\"  width=\'25%\' >";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</b></td>\n\t\t\t</tr>\n\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t\t<!-- <td class=\'querydata\'  width=\'25%\'><b>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</b> -->\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t<td class=\'label\'  width=\'10%\' ><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' name=\'still_birth_dtl\' onClick=\'javascript:stillBirthWindowQuery()\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t<td class=\'querydata\'  width=\'25%\'><b>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</b></td> <!--Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565 -->\n\t\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</b></td>\n\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t</tr>\n            \n\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</b></td>\n\t\t\t<td class=\"label\"   width=\'25%\'>";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</b></td>\n\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</b></td>\n            ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t<td class=\'querydata\'  width=\'25%\'><b>&nbsp;</b></td>\n\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\n\n\t\t\t<td class=\"label\"   width=\'25%\'>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</b></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</b></td>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</b>";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</td>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</td>\n\t\t\t</tr>\n\t\t\t<!-- <tr>\n\t\t\t<td colspan=4>\n\t\t\t<table border=0 cellpadding=\'3\' cellspacing=0 width=\"100%\"> -->\n\t\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="<span id = \'apgar_dtls_link\' ><input type=\'button\' class=\'button\' value=\"+\" name=\"apgar_dtls_name\" id=\"apgar_dtls_name\" onClick=\'javascript:apgarLink(this)\'></span></td>\n\t\t\t<td class=\'querydata\' ><b>";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</b><!-- </td>\n\t\t\t\t\n\t\t\t<td class=\"label\"> --><span class=\'label\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</span></td>\n\t\t\t\t\n\t\t\t<td class=\'querydata\' ><b>&nbsp;";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</span></td>\n\t\t\t\t\n\t\t\t<td class=\'querydata\' ><b>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</span></td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tbody id=\'apgarDivID\' style=\"visibility:hidden;display:none\">\n\t\t\t<tr>\n\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</b></td>\n\t\t\t<td class=\'querydata\' width=\'25%\'><b>&nbsp;";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</b></td>\n\t\t\t<td class=\'querydata\' width=\'25%\'><b>";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</b></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t\t\t<td class=\'querydata\' width=\'25%\' ><b>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</b></td>\n\t\t\t<td class=\'querydata\' width=\'25%\' ><b>&nbsp;";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</b></td>\t\t\t\t\n\t\t\t</tr>\n\t\t\t</tbody>\n\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\n\t\t\t<td class=\'querydata\'  width=\'25%\' nowrap><b>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</b></td>\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t<td class=\'querydata\'  width=\'25%\'><b>&nbsp;</b></td>\n\t\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</b></td>            \n\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</td>\n\t\t\t<td class=\'querydata\'  width=\'25%\' style=\'word-wrap:break-word;width:300px;\'><b>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</b></td>\n\t\t\t<!--Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382-->\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</b></td> \n\t\t\t<!--Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382-->\n\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="<td></td>";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</td>\n\t\t\t<!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->\n\t\t\t<td class=\'querydata\'  width=\'25%\' style=\'word-wrap:break-word;width:300px;\'><b>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</b></td>\n\t\t\t</tr>\n\t\t\t  ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</td>\t\t\t\n\t\t\t\t<td class=\'querydata\'  width=\'25%\'><b>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</b></td>\t\t\t\n\t\t\t<td class=\"label\"  width=\'25%\'>&nbsp;</td>\n\t\t\t<td class=\'querydata\'  width=\'25%\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t</table>\n\t\t\t</td></tr> \n\n\t\t\t<tr><td colspan=4>\t\t\n\t\t\t<table id=\'vcc_tab\' width=\"100%\" cellpadding=\'3\' cellspacing=0 border=0 >\t\n\t\t\t\t<tr><td colspan=\'4\' class=\'COLUMNHEADER\'><span id = \'vaccin_dtls_link\' onClick=\'javascript:expandCollapse(\"VD\")\'><input type=\'button\' class=\'button\' value=\'-\' name=\'vacc_button\' id=\'vacc_button\'></span>&nbsp";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</td></tr>\n\t\t\t</table>\n\t\t\t<div>\n\t\t\t<tr><td colspan=4>\n\t\t\t<div id=\'vaccin_dtls\'>\n\t\t\t<table width=\"100%\" cellpadding=\'3\' cellspacing=0 border=0 >\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'   width=\'15%\'></td>\n\t\t\t\t<td class=\'label\'   width=\'5%\'></td>\n\t\t\t\t<td class=\'label\'   width=\'20%\'>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</td>\n\t\t\t\t<td class=\'label\'   width=\'20%\'>";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</td>\n\t\t\t\t<td class=\'label\'  width=\'20%\'>";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'     width=\'15%\'>";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</td>\n\t\t\t\t\t<td class=\'querydata\'  width=\'5%\'><b>";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</b></td>\n\t\t\t\t\t<td class=\'querydata\'  width=\'20%\'><b>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="</b></td>\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'      width=\'15%\'>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</b></td>\n\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  width=\'15%\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td>\n\t\t\t\t\t<td class=\'querydata\' width=\'5%\'><b>";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</b></td>\n\t\t\t\t<td class=\'querydata\'  width=\'20%\'><b>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</b></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</div>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</div>\n\t\t\t</td></tr>\n\t\t\t</table>\n\t    <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\n<!--Added for MMS-QH-CRF-0145.1-->\n<script>\t\t\nif(";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="&&\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'==\"\"){ \nvar hijDay=convertToHij(\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'); \ndocument.getElementById(\'hiji_date_display\').innerHTML=hijDay;\n}\nif(\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\"==\"true\" && document.getElementById(\'father_dtls_link\')!=null){\n\t     document.getElementById(\'father_dtls_link\').onclick();          \n\t}\n</script>\n<!--MMS-QH-CRF-0145.1 -->\n      </form>\n\t</body>\n</html>\n\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

	public static String checkForNull1(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null")) || (inputString.equals(""))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	//Properties p		= (java.util.Properties) session.getValue("jdbc");
	
    request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	String patient_id				= checkForNull(request.getParameter("Patient_ID"));//mother Patient ID
	//String outcome					= checkForNull(request.getParameter("outcome"));

	PreparedStatement pstmt=null;
	ResultSet rs=null,rs1=null;
	//String sql1 = "";
	//String facilityId       = (String) session.getValue("facility_id");

	//Below line added for this CRF ML-MMOH-CRF-0621	
	ResultSet rset			= null;
	PreparedStatement stmt	= null;
	String national_id="",  other_alter_id ="", nat_other_alter_id="", nat_other_alter_legend="", national_id_no="";
	//End ML-MMOH-CRF-0621
	    
	HashMap hashMap_param				= new HashMap();
    HashMap hashMap_detls				= new HashMap();
	String locale			= (String)session.getAttribute("LOCALE"); 


	/*String mp_param_sql="select NAME_PREFIX_ACCEPT_YN, FIRST_NAME_ACCEPT_YN, SECOND_NAME_ACCEPT_YN, THIRD_NAME_ACCEPT_YN, FAMILY_NAME_ACCEPT_YN, NAME_SUFFIX_ACCEPT_YN,NAME_PREFIX_PROMPT, FIRST_NAME_PROMPT, SECOND_NAME_PROMPT, THIRD_NAME_PROMPT, FAMILY_NAME_PROMPT, NAME_SUFFIX_PROMPT,NAMES_IN_OTH_LANG_YN,NAME_PREFIX_LOC_LANG_PROMPT, FIRST_NAME_LOC_LANG_PROMPT, SECOND_NAME_LOC_LANG_PROMPT, THIRD_NAME_LOC_LANG_PROMPT, FAMILY_NAME_LOC_LANG_PROMPT, NAME_SUFFIX_LOC_LANG_PROMPT,ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_PROMPT,ALT_ID1_TYPE, DECODE (UNIT_OF_WT_NB, 'K', 'Kg', 'L', 'Lb') UNIT_OF_WT_NB, DECODE (UNIT_OF_CIRCUM_NB, 'C', 'Cm', 'I', 'In' ) UNIT_OF_CIRCUM_NB, DECODE (UNIT_OF_CHEST_CIRCUM_NB, 'C', 'Cm', 'I', 'In' ) UNIT_OF_CHEST_CIRCUM_NB, DECODE (UNIT_OF_LENGTH_NB, 'C', 'Cm', 'I', 'In') UNIT_OF_LENGTH_NB, UNIT_OF_GEST_NB  from mp_param "; 	*/
	
	/*Above line commented and below line added for this CRF ML-MMOH-CRF-0621*/
	String mp_param_sql="select NAME_PREFIX_ACCEPT_YN, FIRST_NAME_ACCEPT_YN, SECOND_NAME_ACCEPT_YN, THIRD_NAME_ACCEPT_YN, FAMILY_NAME_ACCEPT_YN, NAME_SUFFIX_ACCEPT_YN,NAME_PREFIX_PROMPT, FIRST_NAME_PROMPT, SECOND_NAME_PROMPT, THIRD_NAME_PROMPT, FAMILY_NAME_PROMPT, NAME_SUFFIX_PROMPT,NAMES_IN_OTH_LANG_YN,NAME_PREFIX_LOC_LANG_PROMPT, FIRST_NAME_LOC_LANG_PROMPT, SECOND_NAME_LOC_LANG_PROMPT, THIRD_NAME_LOC_LANG_PROMPT, FAMILY_NAME_LOC_LANG_PROMPT, NAME_SUFFIX_LOC_LANG_PROMPT,ACCEPT_NATIONAL_ID_NO_YN,NAT_ID_PROMPT,ALT_ID1_TYPE, DECODE (UNIT_OF_WT_NB, 'K', 'Kg', 'L', 'Lb') UNIT_OF_WT_NB, DECODE (UNIT_OF_CIRCUM_NB, 'C', 'Cm', 'I', 'In' ) UNIT_OF_CIRCUM_NB, DECODE (UNIT_OF_CHEST_CIRCUM_NB, 'C', 'Cm', 'I', 'In' ) UNIT_OF_CHEST_CIRCUM_NB, DECODE (UNIT_OF_LENGTH_NB, 'C', 'Cm', 'I', 'In') UNIT_OF_LENGTH_NB, UNIT_OF_GEST_NB, mp_get_desc.mp_alternate_id_type(alt_id1_type,'"+locale+"',1) alt_id1_type_desc, mp_get_desc.mp_alternate_id_type(alt_id2_type,'"+locale+"',1) alt_id2_type_desc, mp_get_desc.mp_alternate_id_type(alt_id3_type,'"+locale+"',1) alt_id3_type_desc, mp_get_desc.mp_alternate_id_type(alt_id4_type,'"+locale+"',1) alt_id4_type_desc,accept_oth_alt_id_yn from mp_param_lang_vw where module_id = 'MP' and language_id ='"+locale+"'"; 
	
	

	//String dtls_sql="select MOTHER_PATIENT_ID,MOTHER_PATIENT_NAME,MOTHER_NATIONAL_ID_NO,DELIVERY_TYPE,GESTATIONAL_PERIOD,GESTATIONAL_UNIT,GESTATIONAL_PERIOD_IN_DAYS,PHYSICIAN_NAME ,UMB_CORD_CUT_BY_NAME,NVL(UMB_CORD_CUT_BY_NAME, UMB_CORD_CUT_BY)UMB_CORD_CUT_BY,CONG_ANOM_DESC,ADMINISTERED_BY,ADMINISTERED_DESIGNATION,to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') BCG_VACC_ADMN_DATE,NB_SEX,NB_BIRTH_DATE,NB_BIRTH_TIME,OUTCOME,WEIGHT,WEIGHT_UNIT,HEAD_CIRCUMFERENCE,CIRCUMFERENCE_UNIT,CHEST_CIRCUMFERENCE,CHEST_CIRCUM_UNIT,LENGTH,LENGTH_UNIT,APGAR_SCORE_IN_1_MIN,APGAR_SCORE_IN_5_MINS,APGAR_SCORE_IN_10_MINS,decode(PATENCY_OF_ANUS_YN,'Yes','Patent','No','Not Patent') PATENCY_OF_ANUS_YN,BORN_WHERE,VITAMIN_K_YN VITK_N_HEPB_GIVEN_YN,HEPB_YN,BCG_YN,HEPB_YN,HEPB_YN,GRAVIDA,PARITY,FEEDING,STOOLS,COMPLN_DELY_DESC,UMBILICAL_CORD_STATUS,INDICATOR_MARK, BORN_AT_LOCN_TYPE_DESC BORN_AT, decode(MULTIPLE_BIRTH_YN,'Y','Yes','N','No') MULTIPLE_BIRTH_YN, POLIO_N_BCG_GIVEN_YN,NAME_SUFFIX,REMARKS,BIRTH_CERTIFICATE_NO,BIRTH_PLACE_DESC,VAGINAL_DELY_TYPE_DESC,DELY_IND_DESC,VACCINATION_SITE,VITAK_VACC_SITE,VITAK_ADMINISTERED_BY,VITAK_ADMINISTERED_DESIG, to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') VITK_VACC_ADMN_DATE,HEPB_VACC_SITE,HEPB_ADMINISTERED_BY,HEPB_ADMINISTERED_DESIG,to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') HEPB_VACC_ADMN_DATE,NB_COMPLN_DELY_DESC,NO_OF_BIRTHS,FATHER_PATIENT_ID,FATHER_PATIENT_NAME,FATHER_NATIONAL_ID_NO,FATHER_ALT_ID1_TYPE_DESC FATHER_ALT_ID1_TYPE ,FATHER_ALT_ID1_NO,FATHER_NAT_DESC,ETH_GRP_DESC FATHER_RACE_DESC,OTH_ALT_ID_DESC,FATHER_OTH_ALT_ID_NO,RELGN_DESC, decode(FATHER_GOVE_EMPLOYEE_YN,'Y','Yes','N','No') FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC,OCPN_DESC,FATHER_OCPN_DESC,NAME_PREFIX_LOC_LANG,NAME_SUFFIX_LOC_LANG,FATHER_PATIENT_NAME_LOC_LANG,MOTHER_PATIENT_NAME_LOC_LANG,NB_PATIENT_NAME_LOC_LANG,COMPLNS_1ST_STAGE_LABOUR_CODE, COMPLNS_2ND_STAGE_LABOUR_CODE, COMPLNS_3RD_STAGE_LABOUR_CODE, COMPLN_PREGNANCY_CODE, COMPLN_PREGNANCY_DESC, COMPLN_NR_PREGNANCY_CODE, COMPLN_NR_PREGNANCY_DESC,decode( HEART_RATE_IN_1_MIN,'0','Absent (0)','1','Below 100 bpm (1)','2','Above 100 bpm (2)')HEART_RATE_IN_1_MIN, decode( HEART_RATE_IN_5_MIN,'0','Absent (0)','1','Below 100 bpm (1)','2','Above 100 bpm (2)')HEART_RATE_IN_5_MIN,decode( HEART_RATE_IN_10_MIN,'0','Absent (0)','1','Below 100 bpm (1)','2','Above 100 bpm (2)')HEART_RATE_IN_10_MIN, decode( BREATHING_IN_1_MIN,'0','Absent (0)','1','Slow,irregular (1)','2','Good,crying (2)') BREATHING_IN_1_MIN, decode( BREATHING_IN_5_MIN,'0','Absent (0) ','1','Slow,irregular (1) ','2','Good,crying (2)') BREATHING_IN_5_MIN, decode( BREATHING_IN_10_MIN,'0','Absent (0)','1','Slow,irregular (1) ','2','Good,crying (2)') BREATHING_IN_10_MIN, decode( GRIMACE_IN_1_MIN,'0','No Grimace (0)','1','Facial Grimace (1) ','2','Sneeze, cough, pulls away (2)')  GRIMACE_IN_1_MIN, decode( GRIMACE_IN_5_MIN,'0','No Grimace (0)','1','Facial Grimace (1)','2','Sneeze, cough, pulls away (2)')  GRIMACE_IN_5_MIN, decode( GRIMACE_IN_10_MIN,'0','No Grimace (0)','1','Facial Grimace (1)','2','Sneeze, cough, pulls away(2)') GRIMACE_IN_10_MIN, decode( ACTIVITY_IN_1_MIN,'0','Absent (0)','1','Arms & legs extended (1)','2','Active movement with flexed arms & legs (2)')  ACTIVITY_IN_1_MIN, decode( ACTIVITY_IN_5_MIN,'0','Absent (0)','1','Arms & legs extended (1)','2','Active movement with flexed arms & legs (2)')  ACTIVITY_IN_5_MIN, decode( ACTIVITY_IN_10_MIN,'0','Absent (0)','1','Arms & legs extended (1)','2','Active movement with flexed arms & legs (2)')  ACTIVITY_IN_10_MIN, decode( APPEARANCE_IN_1_MIN,'0','Blue-gray pale all over (0)','1','Pink body and blue extremities (1)','2','Normal over entire body - Completely pink (2)')  APPEARANCE_IN_1_MIN,decode( APPEARANCE_IN_5_MIN,'0','Blue-gray pale all over (0)','1','Pink body and blue extremities (1)','2','Normal over entire body - Completely pink (2)')   APPEARANCE_IN_5_MIN, decode( APPEARANCE_IN_10_MIN,'0','Blue-gray pale all over (0)','1','Pink body and blue extremities (1)','2','Normal over entire body - Completely pink (2)')  APPEARANCE_IN_10_MIN, NB_NAME_PREFIX, NB_FIRST_NAME, NB_SECOND_NAME, NB_THIRD_NAME, NB_FAMILY_NAME_PREFIX, NB_FAMILY_NAME, NB_NAME_SUFFIX, NB_NAME_PREFIX_LOC_LANG, NB_FIRST_NAME_LOC_LANG, NB_SECOND_NAME_LOC_LANG, NB_THIRD_NAME_LOC_LANG, NB_FAMILY_NAME_LOC_LANG, NB_NAME_SUFFIX_LOC_LANG, FATHER_NAME_PREFIX, FATHER_FIRST_NAME, FATHER_SECOND_NAME, FATHER_THIRD_NAME, FATHER_FAMILY_NAME_PREFIX, FATHER_FAMILY_NAME, FATHER_NAME_SUFFIX, FATHER_NAME_PREFIX_LOC_LANG, FATHER_FIRST_NAME_LOC_LANG, FATHER_SECOND_NAME_LOC_LANG, FATHER_THIRD_NAME_LOC_LANG, FATHER_FAMILY_NAME_LOC_LANG, FATHER_NAME_SUFFIX_LOC_LANG,MIDWIFE_NAME,COMPLNS_1ST_STAGE_LABOUR_DESC,COMPLNS_2ND_STAGE_LABOUR_DESC,COMPLNS_3RD_STAGE_LABOUR_DESC,PROC_CLASS_DESC,DELY_SURG_CLASS_DESC,NB_PATIENT_NAME,FATHER_REMARKS,NB_RELATION_TO_HEAD,OUTCOME,BORN_AT_LOCN_DESC ANT_CARE_LOCN_DESC,NB_BLOOD_GRP_DESC NB_BLOOD_GRP,NB_RH_FACTOR_DESC NB_RH_FACTOR,NB_COMPLN_DELY_DESC from mp_birth_register_vw where PATIENT_ID  ='"+patient_id+"'";
	//String dtls_sql="select MOTHER_PATIENT_ID,MOTHER_PATIENT_NAME,MOTHER_NATIONAL_ID_NO,DELIVERY_TYPE,GESTATIONAL_PERIOD,GESTATIONAL_UNIT,GESTATIONAL_PERIOD_IN_DAYS,PHYSICIAN_NAME ,UMB_CORD_CUT_BY_NAME,NVL(UMB_CORD_CUT_BY_NAME, UMB_CORD_CUT_BY)UMB_CORD_CUT_BY,CONG_ANOM_DESC,ADMINISTERED_BY,ADMINISTERED_DESIGNATION,to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') BCG_VACC_ADMN_DATE,NB_SEX,NB_BIRTH_DATE,NB_BIRTH_TIME,OUTCOME,WEIGHT,WEIGHT_UNIT,HEAD_CIRCUMFERENCE,CIRCUMFERENCE_UNIT,CHEST_CIRCUMFERENCE,CHEST_CIRCUM_UNIT,LENGTH,LENGTH_UNIT,APGAR_SCORE_IN_1_MIN,APGAR_SCORE_IN_5_MINS,APGAR_SCORE_IN_10_MINS,decode(PATENCY_OF_ANUS_YN,'Yes','Patent','No','Not Patent') PATENCY_OF_ANUS_YN,BORN_WHERE,VITAMIN_K_YN VITK_N_HEPB_GIVEN_YN,HEPB_YN,BCG_YN,HEPB_YN,HEPB_YN,GRAVIDA,PARITY,FEEDING,STOOLS,COMPLN_DELY_DESC,UMBILICAL_CORD_STATUS,INDICATOR_MARK, BORN_AT_LOCN_TYPE_DESC BORN_AT, decode(MULTIPLE_BIRTH_YN,'Y','Yes','N','No') MULTIPLE_BIRTH_YN, POLIO_N_BCG_GIVEN_YN,NAME_SUFFIX,REMARKS,BIRTH_CERTIFICATE_NO,BIRTH_PLACE_DESC,VAGINAL_DELY_TYPE_DESC,DELY_IND_DESC,VACCINATION_SITE,VITAK_VACC_SITE,VITAK_ADMINISTERED_BY,VITAK_ADMINISTERED_DESIG, to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') VITK_VACC_ADMN_DATE,HEPB_VACC_SITE,HEPB_ADMINISTERED_BY,HEPB_ADMINISTERED_DESIG,to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') HEPB_VACC_ADMN_DATE,NB_COMPLN_DELY_DESC,NO_OF_BIRTHS,FATHER_PATIENT_ID,FATHER_PATIENT_NAME,FATHER_NATIONAL_ID_NO,FATHER_ALT_ID1_TYPE_DESC FATHER_ALT_ID1_TYPE ,FATHER_ALT_ID1_NO,FATHER_NAT_DESC,ETH_GRP_DESC FATHER_RACE_DESC,OTH_ALT_ID_DESC,FATHER_OTH_ALT_ID_NO,RELGN_DESC, decode(FATHER_GOVE_EMPLOYEE_YN,'Y','Yes','N','No') FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC,OCPN_DESC,FATHER_OCPN_DESC,NAME_PREFIX_LOC_LANG,NAME_SUFFIX_LOC_LANG,FATHER_PATIENT_NAME_LOC_LANG,MOTHER_PATIENT_NAME_LOC_LANG,NB_PATIENT_NAME_LOC_LANG,COMPLNS_1ST_STAGE_LABOUR_CODE, COMPLNS_2ND_STAGE_LABOUR_CODE, COMPLNS_3RD_STAGE_LABOUR_CODE, COMPLN_PREGNANCY_CODE, COMPLN_PREGNANCY_DESC, COMPLN_NR_PREGNANCY_CODE, COMPLN_NR_PREGNANCY_DESC,HEART_RATE_IN_1_MIN,HEART_RATE_IN_5_MIN,HEART_RATE_IN_10_MIN,BREATHING_IN_1_MIN,BREATHING_IN_5_MIN,BREATHING_IN_10_MIN,GRIMACE_IN_1_MIN,GRIMACE_IN_5_MIN,GRIMACE_IN_10_MIN,ACTIVITY_IN_1_MIN,ACTIVITY_IN_5_MIN,ACTIVITY_IN_10_MIN,APPEARANCE_IN_1_MIN,APPEARANCE_IN_5_MIN,APPEARANCE_IN_10_MIN, NB_NAME_PREFIX, NB_FIRST_NAME, NB_SECOND_NAME, NB_THIRD_NAME, NB_FAMILY_NAME_PREFIX, NB_FAMILY_NAME, NB_NAME_SUFFIX, NB_NAME_PREFIX_LOC_LANG, NB_FIRST_NAME_LOC_LANG, NB_SECOND_NAME_LOC_LANG, NB_THIRD_NAME_LOC_LANG, NB_FAMILY_NAME_LOC_LANG, NB_NAME_SUFFIX_LOC_LANG, FATHER_NAME_PREFIX, FATHER_FIRST_NAME, FATHER_SECOND_NAME, FATHER_THIRD_NAME, FATHER_FAMILY_NAME_PREFIX, FATHER_FAMILY_NAME, FATHER_NAME_SUFFIX, FATHER_NAME_PREFIX_LOC_LANG, FATHER_FIRST_NAME_LOC_LANG, FATHER_SECOND_NAME_LOC_LANG, FATHER_THIRD_NAME_LOC_LANG, FATHER_FAMILY_NAME_LOC_LANG, FATHER_NAME_SUFFIX_LOC_LANG,MIDWIFE_NAME,COMPLNS_1ST_STAGE_LABOUR_DESC,COMPLNS_2ND_STAGE_LABOUR_DESC,COMPLNS_3RD_STAGE_LABOUR_DESC,PROC_CLASS_DESC,DELY_SURG_CLASS_DESC,NB_PATIENT_NAME,FATHER_REMARKS,NB_RELATION_TO_HEAD,OUTCOME,BORN_AT_LOCN_DESC ANT_CARE_LOCN_DESC,NB_BLOOD_GRP_DESC NB_BLOOD_GRP,NB_RH_FACTOR_DESC NB_RH_FACTOR,NB_COMPLN_DELY_DESC from mp_birth_register_vw where PATIENT_ID  ='"+patient_id+"'";
	/*Below query modofied for this CRF  MMS-QH-CRF-0145.1 [IN:047497]*/
    /*Below query modified for this CRF ML-MMOH-CRF-0621*/	
	String dtls_sql="select MOTHER_PATIENT_ID,MOTHER_PATIENT_NAME,MOTHER_NATIONAL_ID_NO,alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,mother_alt_id1_no,mother_alt_id2_no,mother_alt_id3_no,mother_alt_id4_no,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1')m_alt_id1_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1')m_alt_id2_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1')m_alt_id3_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1')m_alt_id4_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_alt_id1_type,'"+locale+"','1')mother_alt_id1_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_alt_id2_type,'"+locale+"','1')mother_alt_id2_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_alt_id3_type,'"+locale+"','1')mother_alt_id3_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_alt_id4_type,'"+locale+"','1')mother_alt_id4_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(mother_oth_alt_id_type,'"+locale+"','1')mother_oth_alt_id_type,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(oth_alt_id_type,'"+locale+"','1')m_oth_alt_id_type,oth_alt_id_no m_oth_alt_id_no,mother_oth_alt_id_no,DELIVERY_TYPE,GESTATIONAL_PERIOD,GESTATIONAL_UNIT,GESTATIONAL_PERIOD_IN_DAYS,PHYSICIAN_NAME ,UMB_CORD_CUT_BY_NAME,NVL(UMB_CORD_CUT_BY_NAME, UMB_CORD_CUT_BY)UMB_CORD_CUT_BY,CONG_ANOM_DESC,ADMINISTERED_BY,ADMINISTERED_DESIGNATION,to_char(BCG_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') BCG_VACC_ADMN_DATE,NB_SEX,NB_BIRTH_DATE,NB_BIRTH_TIME,OUTCOME,WEIGHT,WEIGHT_UNIT,HEAD_CIRCUMFERENCE,CIRCUMFERENCE_UNIT,CHEST_CIRCUMFERENCE,CHEST_CIRCUM_UNIT,LENGTH,LENGTH_UNIT,APGAR_SCORE_IN_1_MIN,APGAR_SCORE_IN_5_MINS,APGAR_SCORE_IN_10_MINS,decode(PATENCY_OF_ANUS_YN,'Yes','Patent','No','Not Patent') PATENCY_OF_ANUS_YN,BORN_WHERE,VITAMIN_K_YN VITK_N_HEPB_GIVEN_YN,HEPB_YN,BCG_YN,HEPB_YN,HEPB_YN,GRAVIDA,PARITY,FEEDING,STOOLS,COMPLN_DELY_DESC,UMBILICAL_CORD_STATUS,INDICATOR_MARK, BORN_AT_LOCN_TYPE_DESC BORN_AT, decode(MULTIPLE_BIRTH_YN,'Y','Yes','N','No') MULTIPLE_BIRTH_YN, POLIO_N_BCG_GIVEN_YN,NAME_SUFFIX,REMARKS,BIRTH_CERTIFICATE_NO,BIRTH_PLACE_DESC,VAGINAL_DELY_TYPE_DESC,DELY_IND_DESC,VACCINATION_SITE,VITAK_VACC_SITE,VITAK_ADMINISTERED_BY,VITAK_ADMINISTERED_DESIG, to_char(VITK_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') VITK_VACC_ADMN_DATE,HEPB_VACC_SITE,HEPB_ADMINISTERED_BY,HEPB_ADMINISTERED_DESIG,to_char(HEPB_VACC_ADMN_DATE,'dd/mm/yyyy hh24:mi') HEPB_VACC_ADMN_DATE,NB_COMPLN_DELY_DESC,NO_OF_BIRTHS,FATHER_PATIENT_ID,FATHER_PATIENT_NAME,FATHER_NATIONAL_ID_NO, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_alt_id1_type,'"+locale+"','1')FATHER_ALT_ID1_TYPE,FATHER_ALT_ID1_NO,FATHER_ALT_ID2_NO,FATHER_ALT_ID3_NO,FATHER_ALT_ID4_NO,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_alt_id2_type,'"+locale+"','1')FATHER_ALT_ID2_TYPE,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_alt_id3_type,'"+locale+"','1')FATHER_ALT_ID3_TYPE,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_alt_id4_type,'"+locale+"','1')FATHER_ALT_ID4_TYPE,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(father_oth_alt_id_type,'"+locale+"','1')father_oth_alt_id_type,FATHER_NAT_DESC,ETH_GRP_DESC FATHER_RACE_DESC,FATHER_OTH_ALT_ID_NO,RELGN_DESC, decode(FATHER_GOVE_EMPLOYEE_YN,'Y','Yes','N','No') FATHER_GOVE_EMPLOYEE_YN, OCPN_CLASS_DESC,OCPN_DESC,FATHER_OCPN_DESC,NAME_PREFIX_LOC_LANG,NAME_SUFFIX_LOC_LANG,FATHER_PATIENT_NAME_LOC_LANG,MOTHER_PATIENT_NAME_LOC_LANG,NB_PATIENT_NAME_LOC_LANG,COMPLNS_1ST_STAGE_LABOUR_CODE, COMPLNS_2ND_STAGE_LABOUR_CODE, COMPLNS_3RD_STAGE_LABOUR_CODE, COMPLN_PREGNANCY_CODE, COMPLN_PREGNANCY_DESC, COMPLN_NR_PREGNANCY_CODE, COMPLN_NR_PREGNANCY_DESC,HEART_RATE_IN_1_MIN,HEART_RATE_IN_5_MIN,HEART_RATE_IN_10_MIN,BREATHING_IN_1_MIN,BREATHING_IN_5_MIN,BREATHING_IN_10_MIN,GRIMACE_IN_1_MIN,GRIMACE_IN_5_MIN,GRIMACE_IN_10_MIN,ACTIVITY_IN_1_MIN,ACTIVITY_IN_5_MIN,ACTIVITY_IN_10_MIN,APPEARANCE_IN_1_MIN,APPEARANCE_IN_5_MIN,APPEARANCE_IN_10_MIN, NB_NAME_PREFIX, NB_FIRST_NAME, NB_SECOND_NAME, NB_THIRD_NAME, NB_FAMILY_NAME_PREFIX, NB_FAMILY_NAME, NB_NAME_SUFFIX, NB_NAME_PREFIX_LOC_LANG, NB_FIRST_NAME_LOC_LANG, NB_SECOND_NAME_LOC_LANG, NB_THIRD_NAME_LOC_LANG, NB_FAMILY_NAME_LOC_LANG, NB_NAME_SUFFIX_LOC_LANG, FATHER_NAME_PREFIX, FATHER_FIRST_NAME, FATHER_SECOND_NAME, FATHER_THIRD_NAME, FATHER_FAMILY_NAME_PREFIX, FATHER_FAMILY_NAME, FATHER_NAME_SUFFIX, FATHER_NAME_PREFIX_LOC_LANG, FATHER_FIRST_NAME_LOC_LANG, FATHER_SECOND_NAME_LOC_LANG, FATHER_THIRD_NAME_LOC_LANG, FATHER_FAMILY_NAME_LOC_LANG, FATHER_NAME_SUFFIX_LOC_LANG,MIDWIFE_NAME,COMPLNS_1ST_STAGE_LABOUR_DESC,COMPLNS_2ND_STAGE_LABOUR_DESC,COMPLNS_3RD_STAGE_LABOUR_DESC,PROC_CLASS_DESC,DELY_SURG_CLASS_DESC,NB_PATIENT_NAME,FATHER_REMARKS,NB_RELATION_TO_HEAD,OUTCOME,BORN_AT_LOCN_DESC ANT_CARE_LOCN_DESC,NB_BLOOD_GRP_DESC NB_BLOOD_GRP,NB_RH_FACTOR_DESC NB_RH_FACTOR,NB_COMPLN_DELY_DESC,hijri_birth_date, AM_GET_DESC.AM_PRACTITIONER(PATENCY_OF_ANUS_CHECKED_BY,'"+locale+"',1) PATENCY_OF_ANUS_CHECKED_BY,parity_on_admission,resuscitated_pract_id,am_get_desc.am_practitioner(resuscitated_pract_id,'"+locale+"',1) resuscitated_pract_desc,attend_physician_id,MOTHER_WITNESSED_BY1,MOTHER_WITNESSED_BY2,MOTHER_ALIVE_YN, COMPLN_PREGNANCY_LONG_DESC, COMPLN_NR_PREGNANCY_LONG_DESC, COMPLNS_1ST_STAGE_LONG_DESC, COMPLNS_2ND_STAGE_LONG_DESC, COMPLNS_3RD_STAGE_LONG_DESC, COMPLN_DELY_LONG_DESC, NB_COMPLN_DEL_LONG_DESC, DELY_IND_LONG_DESC, PROC_CLASS_LONG_DESC, VAGINAL_DEL_TYPE_LONG_DESC, DELY_SURG_CLASS_LONG_DESC, CONG_ANOMALIES_LONG_DESC from mp_birth_register_lang_vw where PATIENT_ID  ='"+patient_id+"' AND language_id = '"+locale+"'"; 
	/*Modified by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382*/
	//Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
//out.println(mp_param_sql);

	try{
		con = ConnectionManager.getConnection(request);
//below line added for this CRF Hijri MMS-QH-CRF-0145.1
String hijri_birth_date=""; String Date_Of_Birth="";  
Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(con, "MP","CAL_HIJ_APP");	
//End MMS-QH-CRF-0145.1

Boolean isLabelChangeApplicable = CommonBean.isSiteSpecific(con, "IP","GRAVIDA_PARITY_LEGEND_CHG");//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565

Boolean isNewBornChngsAppl = CommonBean.isSiteSpecific(con, "IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");//Added by Ashwini on 11-Jul-2018 for ML-MMOH-CRF-0898.2

Boolean isMotherAliveAppl = CommonBean.isSiteSpecific(con, "MP","MOTHER_ALIVE_APPL");

Boolean isModifyLongShortDescAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109

    //Below line added for this CRF ML-MMOH-CRF-0621
	 Boolean isRegNewbornApplicable = CommonBean.isSiteSpecific(con, "MP","REG_NEWBORN_FOR_IP");
	 String attend_physician_id="";
	 //End ML-MMOH-CRF-0621

		pstmt = con.prepareStatement(mp_param_sql);
		rs=pstmt.executeQuery();


		while(rs.next()){
			hashMap_param.put("NAME_PREFIX_ACCEPT_YN",checkForNull(rs.getString("NAME_PREFIX_ACCEPT_YN")));
			hashMap_param.put("FIRST_NAME_ACCEPT_YN",checkForNull(rs.getString("FIRST_NAME_ACCEPT_YN")));
			hashMap_param.put("SECOND_NAME_ACCEPT_YN",checkForNull(rs.getString("SECOND_NAME_ACCEPT_YN")));
			hashMap_param.put("THIRD_NAME_ACCEPT_YN",checkForNull(rs.getString("THIRD_NAME_ACCEPT_YN")));
			hashMap_param.put("FAMILY_NAME_ACCEPT_YN",checkForNull(rs.getString("FAMILY_NAME_ACCEPT_YN")));
			hashMap_param.put("NAME_SUFFIX_ACCEPT_YN",checkForNull(rs.getString("NAME_SUFFIX_ACCEPT_YN")));
			hashMap_param.put("NAME_PREFIX_PROMPT",checkForNull(rs.getString("NAME_PREFIX_PROMPT")));
			hashMap_param.put("FIRST_NAME_PROMPT",checkForNull(rs.getString("FIRST_NAME_PROMPT")));
			hashMap_param.put("SECOND_NAME_PROMPT",checkForNull(rs.getString("SECOND_NAME_PROMPT")));
			hashMap_param.put("THIRD_NAME_PROMPT",checkForNull(rs.getString("THIRD_NAME_PROMPT")));
			hashMap_param.put("FAMILY_NAME_PROMPT",checkForNull(rs.getString("FAMILY_NAME_PROMPT")));
			hashMap_param.put("NAME_SUFFIX_PROMPT",checkForNull(rs.getString("NAME_SUFFIX_PROMPT")));
			hashMap_param.put("NAMES_IN_OTH_LANG_YN",checkForNull(rs.getString("NAMES_IN_OTH_LANG_YN")));
			hashMap_param.put("NAME_PREFIX_LOC_LANG_PROMPT",checkForNull(rs.getString("NAME_PREFIX_LOC_LANG_PROMPT")));
			hashMap_param.put("FIRST_NAME_LOC_LANG_PROMPT",checkForNull(rs.getString("FIRST_NAME_LOC_LANG_PROMPT")));
			hashMap_param.put("SECOND_NAME_LOC_LANG_PROMPT",checkForNull(rs.getString("SECOND_NAME_LOC_LANG_PROMPT")));
			hashMap_param.put("THIRD_NAME_LOC_LANG_PROMPT",checkForNull(rs.getString("THIRD_NAME_LOC_LANG_PROMPT")));
			hashMap_param.put("FAMILY_NAME_LOC_LANG_PROMPT",checkForNull(rs.getString("FAMILY_NAME_LOC_LANG_PROMPT")));
			hashMap_param.put("NAME_SUFFIX_LOC_LANG_PROMPT",checkForNull(rs.getString("NAME_SUFFIX_LOC_LANG_PROMPT")));
			hashMap_param.put("ACCEPT_NATIONAL_ID_NO_YN",checkForNull(rs.getString("ACCEPT_NATIONAL_ID_NO_YN")));
			hashMap_param.put("NAT_ID_PROMPT",checkForNull(rs.getString("NAT_ID_PROMPT")));
			hashMap_param.put("ALT_ID1_TYPE",checkForNull(rs.getString("ALT_ID1_TYPE")));

			hashMap_param.put("UNIT_OF_WT_NB",checkForNull(rs.getString("UNIT_OF_WT_NB")));
			hashMap_param.put("UNIT_OF_CIRCUM_NB",checkForNull(rs.getString("UNIT_OF_CIRCUM_NB")));
			hashMap_param.put("UNIT_OF_CHEST_CIRCUM_NB",checkForNull(rs.getString("UNIT_OF_CHEST_CIRCUM_NB")));
			hashMap_param.put("UNIT_OF_LENGTH_NB",checkForNull(rs.getString("UNIT_OF_LENGTH_NB")));
			hashMap_param.put("UNIT_OF_GEST_NB",checkForNull(rs.getString("UNIT_OF_GEST_NB")));
			
			/*Below line added for this CRF ML-MMOH-CRF-0621*/
			hashMap_param.put("alt_id1_type_desc",checkForNull(rs.getString("alt_id1_type_desc")));
			hashMap_param.put("alt_id2_type_desc",checkForNull(rs.getString("alt_id2_type_desc")));
			hashMap_param.put("alt_id3_type_desc",checkForNull(rs.getString("alt_id3_type_desc")));
			hashMap_param.put("alt_id4_type_desc",checkForNull(rs.getString("alt_id4_type_desc")));
			hashMap_param.put("accept_oth_alt_id_yn",checkForNull(rs.getString("accept_oth_alt_id_yn")));
           //End ML-MMOH-CRF-0621			
			
		}
		
		//out.println(hashMap_param.size());
		
		pstmt.close();
		//out.println(dtls_sql);
		
		
 
		pstmt = con.prepareStatement(dtls_sql);
		rs1=pstmt.executeQuery();

    if (rs1 !=null && rs1.next()){
      
			
			hashMap_detls.put("MOTHER_PATIENT_ID",checkForNull(rs1.getString("MOTHER_PATIENT_ID")));
			hashMap_detls.put("MOTHER_PATIENT_NAME",checkForNull(rs1.getString("MOTHER_PATIENT_NAME")));
			hashMap_detls.put("MOTHER_NATIONAL_ID_NO",checkForNull(rs1.getString("MOTHER_NATIONAL_ID_NO")));
			hashMap_detls.put("m_alt_id1_no",checkForNull(rs1.getString("alt_id1_no")));
			hashMap_detls.put("m_alt_id2_no",checkForNull(rs1.getString("alt_id2_no")));
			hashMap_detls.put("m_alt_id3_no",checkForNull(rs1.getString("alt_id3_no")));
			hashMap_detls.put("m_alt_id4_no",checkForNull(rs1.getString("alt_id4_no")));
			hashMap_detls.put("mother_alt_id1_no",checkForNull(rs1.getString("mother_alt_id1_no")));
			hashMap_detls.put("mother_alt_id2_no",checkForNull(rs1.getString("mother_alt_id2_no")));
			hashMap_detls.put("mother_alt_id3_no",checkForNull(rs1.getString("mother_alt_id3_no")));
			hashMap_detls.put("mother_alt_id4_no",checkForNull(rs1.getString("mother_alt_id4_no")));
			hashMap_detls.put("m_alt_id1_type",checkForNull(rs1.getString("m_alt_id1_type")));
			hashMap_detls.put("m_alt_id2_type",checkForNull(rs1.getString("m_alt_id2_type")));
			hashMap_detls.put("m_alt_id3_type",checkForNull(rs1.getString("m_alt_id3_type")));
			hashMap_detls.put("m_alt_id4_type",checkForNull(rs1.getString("m_alt_id4_type")));
			hashMap_detls.put("mother_alt_id1_type",checkForNull(rs1.getString("mother_alt_id1_type")));
			hashMap_detls.put("mother_alt_id2_type",checkForNull(rs1.getString("mother_alt_id2_type")));
			hashMap_detls.put("mother_alt_id3_type",checkForNull(rs1.getString("mother_alt_id3_type")));
			hashMap_detls.put("mother_alt_id4_type",checkForNull(rs1.getString("mother_alt_id4_type")));
			hashMap_detls.put("mother_oth_alt_id_no",checkForNull(rs1.getString("mother_oth_alt_id_no")));
			hashMap_detls.put("mother_oth_alt_id_type",checkForNull(rs1.getString("mother_oth_alt_id_type")));
			hashMap_detls.put("m_oth_alt_id_no",checkForNull(rs1.getString("m_oth_alt_id_no")));
			hashMap_detls.put("m_oth_alt_id_type",checkForNull(rs1.getString("m_oth_alt_id_type")));
			
			hashMap_detls.put("DELIVERY_TYPE",checkForNull(rs1.getString("DELIVERY_TYPE")));
			hashMap_detls.put("GESTATIONAL_PERIOD",checkForNull(rs1.getString("GESTATIONAL_PERIOD")));
			hashMap_detls.put("GESTATIONAL_UNIT",checkForNull(rs1.getString("GESTATIONAL_UNIT")));
			hashMap_detls.put("GESTATIONAL_PERIOD_IN_DAYS",checkForNull(rs1.getString("GESTATIONAL_PERIOD_IN_DAYS")));
			hashMap_detls.put("PHYSICIAN_NAME",checkForNull(rs1.getString("PHYSICIAN_NAME")));
			hashMap_detls.put("UMB_CORD_CUT_BY",checkForNull(rs1.getString("UMB_CORD_CUT_BY")));
			/*Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382*/
			hashMap_detls.put("PATENCY_OF_ANUS_CHECKED_BY",checkForNull(rs1.getString("PATENCY_OF_ANUS_CHECKED_BY")));
			
			hashMap_detls.put("CONG_ANOM_DESC",checkForNull(rs1.getString("CONG_ANOM_DESC")));
			hashMap_detls.put("ADMINISTERED_BY",checkForNull(rs1.getString("ADMINISTERED_BY")));
			hashMap_detls.put("ADMINISTERED_DESIGNATION",checkForNull(rs1.getString("ADMINISTERED_DESIGNATION")));
			
			//hashMap_detls.put("BCG_VACC_ADMN_DATE",checkForNull(rs1.getString("BCG_VACC_ADMN_DATE")));Commented by Rameswar on 30-Sep-15
			hashMap_detls.put("BCG_VACC_ADMN_DATE",DateUtils.convertDate(checkForNull(rs1.getString("BCG_VACC_ADMN_DATE")),"DMYHM","en",locale));//Modified by Rameswar on 30-Sep-15 for Leap Year Issue 
			

			hashMap_detls.put("NB_SEX",checkForNull(rs1.getString("NB_SEX")));
			//hashMap_detls.put("NB_BIRTH_DATE",checkForNull(rs1.getString("NB_BIRTH_DATE")));
			Date_Of_Birth=checkForNull(rs1.getString("NB_BIRTH_DATE"));
			Date_Of_Birth=DateUtils.convertDate(Date_Of_Birth,"DMY","en",locale);//Added by Rameswar on 30-Sep-15 for Leap Year Issue 
			
			hashMap_detls.put("NB_BIRTH_DATE",Date_Of_Birth);
			
			hashMap_detls.put("NB_BIRTH_TIME",checkForNull(rs1.getString("NB_BIRTH_TIME")));
			hashMap_detls.put("OUTCOME",checkForNull(rs1.getString("OUTCOME")));
			hashMap_detls.put("WEIGHT",checkForNull(rs1.getString("WEIGHT")));
			hashMap_detls.put("ANT_CARE_LOCN_DESC",checkForNull(rs1.getString("ANT_CARE_LOCN_DESC")));
			hashMap_detls.put("NB_BLOOD_GRP",checkForNull(rs1.getString("NB_BLOOD_GRP")));
			hashMap_detls.put("NB_RH_FACTOR",checkForNull(rs1.getString("NB_RH_FACTOR")));

			hashMap_detls.put("WEIGHT_UNIT",checkForNull(rs1.getString("WEIGHT_UNIT")));
			hashMap_detls.put("HEAD_CIRCUMFERENCE",checkForNull(rs1.getString("HEAD_CIRCUMFERENCE")));
			hashMap_detls.put("CIRCUMFERENCE_UNIT",checkForNull(rs1.getString("CIRCUMFERENCE_UNIT")));
			hashMap_detls.put("CHEST_CIRCUMFERENCE",checkForNull(rs1.getString("CHEST_CIRCUMFERENCE")));
			hashMap_detls.put("CHEST_CIRCUM_UNIT",checkForNull(rs1.getString("CHEST_CIRCUM_UNIT")));
			hashMap_detls.put("LENGTH",checkForNull(rs1.getString("LENGTH")));
			hashMap_detls.put("LENGTH_UNIT",checkForNull(rs1.getString("LENGTH_UNIT")));

			hashMap_detls.put("APGAR_SCORE_IN_1_MIN",checkForNull(rs1.getString("APGAR_SCORE_IN_1_MIN")));
			hashMap_detls.put("APGAR_SCORE_IN_5_MINS",checkForNull(rs1.getString("APGAR_SCORE_IN_5_MINS")));
			hashMap_detls.put("APGAR_SCORE_IN_10_MINS",checkForNull(rs1.getString("APGAR_SCORE_IN_10_MINS")));
			hashMap_detls.put("PATENCY_OF_ANUS_YN",checkForNull(rs1.getString("PATENCY_OF_ANUS_YN")));
			hashMap_detls.put("BORN_WHERE",checkForNull(rs1.getString("BORN_WHERE")));
			hashMap_detls.put("VITK_N_HEPB_GIVEN_YN",checkForNull(rs1.getString("VITK_N_HEPB_GIVEN_YN")));
			hashMap_detls.put("HEPB_YN",checkForNull(rs1.getString("HEPB_YN")));
			hashMap_detls.put("BCG_YN",checkForNull(rs1.getString("BCG_YN")));
			hashMap_detls.put("GRAVIDA",checkForNull(rs1.getString("GRAVIDA")));
			hashMap_detls.put("PARITY",checkForNull(rs1.getString("PARITY")));
			hashMap_detls.put("FEEDING",checkForNull(rs1.getString("FEEDING")));
			hashMap_detls.put("STOOLS",checkForNull(rs1.getString("STOOLS")));
			hashMap_detls.put("COMPLN_DELY_DESC",checkForNull(rs1.getString("COMPLN_DELY_DESC")));
			hashMap_detls.put("UMBILICAL_CORD_STATUS",checkForNull(rs1.getString("UMBILICAL_CORD_STATUS")));
			hashMap_detls.put("INDICATOR_MARK",checkForNull(rs1.getString("INDICATOR_MARK")));
			hashMap_detls.put("BORN_AT",checkForNull(rs1.getString("BORN_AT")));
			hashMap_detls.put("MULTIPLE_BIRTH_YN",checkForNull(rs1.getString("MULTIPLE_BIRTH_YN")));
			hashMap_detls.put("POLIO_N_BCG_GIVEN_YN",checkForNull(rs1.getString("POLIO_N_BCG_GIVEN_YN")));
			hashMap_detls.put("NAME_SUFFIX",checkForNull(rs1.getString("NAME_SUFFIX")));
			hashMap_detls.put("REMARKS",checkForNull(rs1.getString("REMARKS")));
			hashMap_detls.put("BIRTH_CERTIFICATE_NO",checkForNull(rs1.getString("BIRTH_CERTIFICATE_NO")));
			hashMap_detls.put("BIRTH_PLACE_DESC",checkForNull(rs1.getString("BIRTH_PLACE_DESC")));
			hashMap_detls.put("VAGINAL_DELY_TYPE_DESC",checkForNull(rs1.getString("VAGINAL_DELY_TYPE_DESC")));
			hashMap_detls.put("DELY_IND_DESC",checkForNull(rs1.getString("DELY_IND_DESC")));
			hashMap_detls.put("VACCINATION_SITE",checkForNull(rs1.getString("VACCINATION_SITE")));
			hashMap_detls.put("VITAK_VACC_SITE",checkForNull(rs1.getString("VITAK_VACC_SITE")));
			hashMap_detls.put("VITAK_ADMINISTERED_BY",checkForNull(rs1.getString("VITAK_ADMINISTERED_BY")));
			hashMap_detls.put("VITAK_ADMINISTERED_DESIG",checkForNull(rs1.getString("VITAK_ADMINISTERED_DESIG")));

			//hashMap_detls.put("VITK_VACC_ADMN_DATE",checkForNull(rs1.getString("VITK_VACC_ADMN_DATE")));Commented by Rameswar on 30-Sep-15
			hashMap_detls.put("VITK_VACC_ADMN_DATE",DateUtils.convertDate(checkForNull(rs1.getString("VITK_VACC_ADMN_DATE")),"DMYHM","en",locale));//Modified by Rameswar on 30-Sep-15 for Leap Year Issue

			hashMap_detls.put("HEPB_VACC_SITE",checkForNull(rs1.getString("HEPB_VACC_SITE")));
			hashMap_detls.put("HEPB_ADMINISTERED_BY",checkForNull(rs1.getString("HEPB_ADMINISTERED_BY")));
			hashMap_detls.put("HEPB_ADMINISTERED_DESIG",checkForNull(rs1.getString("HEPB_ADMINISTERED_DESIG")));

			//hashMap_detls.put("HEPB_VACC_ADMN_DATE",checkForNull(rs1.getString("HEPB_VACC_ADMN_DATE"))); Commented by Rameswar on 30-Sep-15
			hashMap_detls.put("HEPB_VACC_ADMN_DATE",DateUtils.convertDate(checkForNull(rs1.getString("HEPB_VACC_ADMN_DATE")),"DMYHM","en",locale));//Modified by Rameswar on 30-Sep-15 for Leap Year Issue
			//Added by Ashwini on 11-Jul-2018 for ML-MMOH-CRF-0898.2
			hashMap_detls.put("MOTHER_WITNESSED_BY1",checkForNull(rs1.getString("MOTHER_WITNESSED_BY1")));
			hashMap_detls.put("MOTHER_WITNESSED_BY2",checkForNull(rs1.getString("MOTHER_WITNESSED_BY2")));
			String mother_alive_yn = checkForNull(rs1.getString("MOTHER_ALIVE_YN"));

			hashMap_detls.put("NB_COMPLN_DELY_DESC",checkForNull(rs1.getString("NB_COMPLN_DELY_DESC")));
			hashMap_detls.put("NO_OF_BIRTHS",checkForNull(rs1.getString("NO_OF_BIRTHS")));
			hashMap_detls.put("FATHER_PATIENT_ID",checkForNull(rs1.getString("FATHER_PATIENT_ID")));
			hashMap_detls.put("FATHER_PATIENT_NAME",checkForNull(rs1.getString("FATHER_PATIENT_NAME")));
			hashMap_detls.put("FATHER_NATIONAL_ID_NO",checkForNull(rs1.getString("FATHER_NATIONAL_ID_NO")));
			hashMap_detls.put("FATHER_ALT_ID1_TYPE",checkForNull(rs1.getString("FATHER_ALT_ID1_TYPE")));
			hashMap_detls.put("FATHER_ALT_ID2_TYPE",checkForNull(rs1.getString("FATHER_ALT_ID2_TYPE")));
			hashMap_detls.put("FATHER_ALT_ID3_TYPE",checkForNull(rs1.getString("FATHER_ALT_ID3_TYPE")));
			hashMap_detls.put("FATHER_ALT_ID4_TYPE",checkForNull(rs1.getString("FATHER_ALT_ID4_TYPE")));
			hashMap_detls.put("FATHER_ALT_ID1_NO",checkForNull(rs1.getString("FATHER_ALT_ID1_NO")));
			hashMap_detls.put("FATHER_ALT_ID2_NO",checkForNull(rs1.getString("FATHER_ALT_ID2_NO")));
			hashMap_detls.put("FATHER_ALT_ID3_NO",checkForNull(rs1.getString("FATHER_ALT_ID3_NO")));
			hashMap_detls.put("FATHER_ALT_ID4_NO",checkForNull(rs1.getString("FATHER_ALT_ID4_NO")));
			hashMap_detls.put("FATHER_NAT_DESC",checkForNull(rs1.getString("FATHER_NAT_DESC")));
			hashMap_detls.put("father_oth_alt_id_type",checkForNull(rs1.getString("father_oth_alt_id_type")));
			hashMap_detls.put("FATHER_RACE_DESC",checkForNull(rs1.getString("FATHER_RACE_DESC")));
			//hashMap_detls.put("OTH_ALT_ID_DESC",checkForNull(rs1.getString("OTH_ALT_ID_DESC")));
			hashMap_detls.put("FATHER_OTH_ALT_ID_NO",checkForNull(rs1.getString("FATHER_OTH_ALT_ID_NO")));
			hashMap_detls.put("RELGN_DESC",checkForNull(rs1.getString("RELGN_DESC")));
			hashMap_detls.put("FATHER_GOVE_EMPLOYEE_YN",checkForNull(rs1.getString("FATHER_GOVE_EMPLOYEE_YN")));
			hashMap_detls.put("OCPN_CLASS_DESC",checkForNull(rs1.getString("OCPN_CLASS_DESC")));
			hashMap_detls.put("OCPN_DESC",checkForNull(rs1.getString("OCPN_DESC")));
			hashMap_detls.put("FATHER_OCPN_DESC",checkForNull(rs1.getString("FATHER_OCPN_DESC")));
			hashMap_detls.put("NAME_PREFIX_LOC_LANG",checkForNull(rs1.getString("NAME_PREFIX_LOC_LANG")));
			hashMap_detls.put("NAME_SUFFIX_LOC_LANG",checkForNull(rs1.getString("NAME_SUFFIX_LOC_LANG")));
			hashMap_detls.put("FATHER_PATIENT_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_PATIENT_NAME_LOC_LANG")));
			hashMap_detls.put("MOTHER_PATIENT_NAME_LOC_LANG",checkForNull(rs1.getString("MOTHER_PATIENT_NAME_LOC_LANG")));
			hashMap_detls.put("NB_PATIENT_NAME_LOC_LANG",checkForNull(rs1.getString("NB_PATIENT_NAME_LOC_LANG")));
			hashMap_detls.put("COMPLNS_1ST_STAGE_LABOUR_CODE",checkForNull(rs1.getString("COMPLNS_1ST_STAGE_LABOUR_CODE")));
			hashMap_detls.put("COMPLNS_2ND_STAGE_LABOUR_CODE",checkForNull(rs1.getString("COMPLNS_2ND_STAGE_LABOUR_CODE")));
			hashMap_detls.put("COMPLNS_3RD_STAGE_LABOUR_CODE",checkForNull(rs1.getString("COMPLNS_3RD_STAGE_LABOUR_CODE")));
			hashMap_detls.put("COMPLN_PREGNANCY_CODE",checkForNull(rs1.getString("COMPLN_PREGNANCY_CODE")));
			hashMap_detls.put("COMPLN_PREGNANCY_DESC",checkForNull(rs1.getString("COMPLN_PREGNANCY_DESC")));
			hashMap_detls.put("COMPLN_NR_PREGNANCY_CODE",checkForNull(rs1.getString("COMPLN_NR_PREGNANCY_CODE")));
			hashMap_detls.put("COMPLN_NR_PREGNANCY_DESC",checkForNull(rs1.getString("COMPLN_NR_PREGNANCY_DESC")));
			/*Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109*/
			hashMap_detls.put("COMPLN_PREGNANCY_LONG_DESC",checkForNull(rs1.getString("COMPLN_PREGNANCY_LONG_DESC")));
			hashMap_detls.put("COMPLN_NR_PREGNANCY_LONG_DESC",checkForNull(rs1.getString("COMPLN_NR_PREGNANCY_LONG_DESC")));
			hashMap_detls.put("COMPLNS_1ST_STAGE_LONG_DESC",checkForNull(rs1.getString("COMPLNS_1ST_STAGE_LONG_DESC")));
			hashMap_detls.put("COMPLNS_2ND_STAGE_LONG_DESC",checkForNull(rs1.getString("COMPLNS_2ND_STAGE_LONG_DESC")));
			hashMap_detls.put("COMPLNS_3RD_STAGE_LONG_DESC",checkForNull(rs1.getString("COMPLNS_3RD_STAGE_LONG_DESC")));
			hashMap_detls.put("COMPLN_DELY_LONG_DESC",checkForNull(rs1.getString("COMPLN_DELY_LONG_DESC")));
			hashMap_detls.put("NB_COMPLN_DEL_LONG_DESC",checkForNull(rs1.getString("NB_COMPLN_DEL_LONG_DESC")));
			hashMap_detls.put("DELY_IND_LONG_DESC",checkForNull(rs1.getString("DELY_IND_LONG_DESC")));
			hashMap_detls.put("PROC_CLASS_LONG_DESC",checkForNull(rs1.getString("PROC_CLASS_LONG_DESC")));
			hashMap_detls.put("VAGINAL_DEL_TYPE_LONG_DESC",checkForNull(rs1.getString("VAGINAL_DEL_TYPE_LONG_DESC")));
			hashMap_detls.put("DELY_SURG_CLASS_LONG_DESC",checkForNull(rs1.getString("DELY_SURG_CLASS_LONG_DESC")));
			hashMap_detls.put("CONG_ANOMALIES_LONG_DESC",checkForNull(rs1.getString("CONG_ANOMALIES_LONG_DESC")));
			/*End ML-MMOH-CRF-1109*/

			String heart_rate_in_1_min=checkForNull(rs1.getString("HEART_RATE_IN_1_MIN"));
			if(heart_rate_in_1_min.equals("0")){
				heart_rate_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(heart_rate_in_1_min.equals("1")){
				heart_rate_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Below100bpm.label","mp_labels")+"(1)";
			}else if(heart_rate_in_1_min.equals("2")){
				heart_rate_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Above100bpm.label","mp_labels")+"(2)";
			}
			String heart_rate_in_5_min=checkForNull(rs1.getString("HEART_RATE_IN_5_MIN"));
			if(heart_rate_in_5_min.equals("0")){
				heart_rate_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(heart_rate_in_5_min.equals("1")){
				heart_rate_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Below100bpm.label","mp_labels")+"(1)";
			}else if(heart_rate_in_5_min.equals("2")){
				heart_rate_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Above100bpm.label","mp_labels")+"(2)";
			}
			String heart_rate_in_10_min=checkForNull(rs1.getString("HEART_RATE_IN_10_MIN"));
			if(!heart_rate_in_10_min.equals("")){
				if(heart_rate_in_10_min.equals("0")){
					heart_rate_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
				}else if(heart_rate_in_10_min.equals("1")){
					heart_rate_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Below100bpm.label","mp_labels")+"(1)";
				}else if(heart_rate_in_10_min.equals("2")){
					heart_rate_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Above100bpm.label","mp_labels")+"(2)";
				}
			}


			String breathing_in_1_min=checkForNull(rs1.getString("BREATHING_IN_1_MIN"));
			if(breathing_in_1_min.equals("0")){
				breathing_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(breathing_in_1_min.equals("1")){
				breathing_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Slowirregular.label","mp_labels")+"(1)";
			}else if(breathing_in_1_min.equals("2")){
				breathing_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GoodCrying.label","mp_labels")+"(2)";
			}
			String breathing_in_5_min=checkForNull(rs1.getString("BREATHING_IN_5_MIN"));
			if(breathing_in_5_min.equals("0")){
				breathing_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(breathing_in_5_min.equals("1")){
				breathing_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Slowirregular.label","mp_labels")+"(1)";
			}else if(breathing_in_5_min.equals("2")){
				breathing_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GoodCrying.label","mp_labels")+"(2)";
			}
			String breathing_in_10_min=checkForNull(rs1.getString("BREATHING_IN_10_MIN"));
			if(!breathing_in_10_min.equals("")){
				if(breathing_in_10_min.equals("0")){
					breathing_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
				}else if(breathing_in_10_min.equals("1")){
					breathing_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Slowirregular.label","mp_labels")+"(1)";
				}else if(breathing_in_10_min.equals("2")){
					breathing_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GoodCrying.label","mp_labels")+"(2)";
				}
			}

			String grimace_in_1_min=checkForNull(rs1.getString("GRIMACE_IN_1_MIN"));
			if(grimace_in_1_min.equals("0")){
				grimace_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NoResponse.label","mp_labels")+"(0)";
			}else if(grimace_in_1_min.equals("1")){
				grimace_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Facialgrimace.label","mp_labels")+"(1)";
			}else if(grimace_in_1_min.equals("2")){
				grimace_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Sneezecoughpullsaway.label","mp_labels")+"(2)";
			}
			String grimace_in_5_min=checkForNull(rs1.getString("GRIMACE_IN_5_MIN"));
			if(grimace_in_5_min.equals("0")){
				grimace_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NoResponse.label","mp_labels")+"(0)";
			}else if(grimace_in_5_min.equals("1")){
				grimace_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Facialgrimace.label","mp_labels")+"(1)";
			}else if(grimace_in_5_min.equals("2")){
				grimace_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Sneezecoughpullsaway.label","mp_labels")+"(2)";
			}
			String grimace_in_10_min=checkForNull(rs1.getString("GRIMACE_IN_10_MIN"));
			if(!grimace_in_10_min.equals("")){
				if(grimace_in_10_min.equals("0")){
					grimace_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NoResponse.label","mp_labels")+"(0)";
				}else if(grimace_in_10_min.equals("1")){
					grimace_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Facialgrimace.label","mp_labels")+"(1)";
				}else if(grimace_in_10_min.equals("2")){
					grimace_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Sneezecoughpullsaway.label","mp_labels")+"(2)";
				}
			}

			String activity_in_1_min=checkForNull(rs1.getString("ACTIVITY_IN_1_MIN"));
			if(activity_in_1_min.equals("0")){
				activity_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(activity_in_1_min.equals("1")){
				activity_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Armslegsextended.label","mp_labels")+"(1)";
			}else if(activity_in_1_min.equals("2")){
				activity_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Activemovementwithflexedarmslegs.label","mp_labels")+"(2)";
			}
			String activity_in_5_min=checkForNull(rs1.getString("ACTIVITY_IN_5_MIN"));
			if(activity_in_5_min.equals("0")){
				activity_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
			}else if(activity_in_5_min.equals("1")){
				activity_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Armslegsextended.label","mp_labels")+"(1)";
			}else if(activity_in_5_min.equals("2")){
				activity_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Activemovementwithflexedarmslegs.label","mp_labels")+"(2)";
			}
			String activity_in_10_min=checkForNull(rs1.getString("ACTIVITY_IN_10_MIN"));
			if(!activity_in_10_min.equals("")){
				if(activity_in_10_min.equals("0")){
					activity_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Absent.label","mp_labels")+"(0)";
				}else if(activity_in_10_min.equals("1")){
					activity_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Armslegsextended.label","mp_labels")+"(1)";
				}else if(activity_in_10_min.equals("2")){
					activity_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Activemovementwithflexedarmslegs.label","mp_labels")+"(2)";
				}
			}

			String appearance_in_1_min=checkForNull(rs1.getString("APPEARANCE_IN_1_MIN"));
			if(appearance_in_1_min.equals("0")){
				appearance_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Blue-graypaleallover.label","mp_labels")+"(0)";
			}else if(appearance_in_1_min.equals("1")){
				appearance_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Pinkbodyandblueextremities.label","mp_labels")+"(1)";
			}else if(appearance_in_1_min.equals("2")){
				appearance_in_1_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Normaloverentirebody-completelypink.label","mp_labels")+"(2)";
			}
			String appearance_in_5_min=checkForNull(rs1.getString("APPEARANCE_IN_5_MIN"));
			if(appearance_in_5_min.equals("0")){
				appearance_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Blue-graypaleallover.label","mp_labels")+"(0)";
			}else if(appearance_in_5_min.equals("1")){
				appearance_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Pinkbodyandblueextremities.label","mp_labels")+"(1)";
			}else if(appearance_in_5_min.equals("2")){
				appearance_in_5_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Normaloverentirebody-completelypink.label","mp_labels")+"(2)";
			}
			String appearance_in_10_min=checkForNull(rs1.getString("APPEARANCE_IN_10_MIN"));
			if(!appearance_in_10_min.equals("")){
				if(appearance_in_10_min.equals("0")){
					appearance_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Blue-graypaleallover.label","mp_labels")+"(0)";
				}else if(appearance_in_10_min.equals("1")){
					appearance_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Pinkbodyandblueextremities.label","mp_labels")+"(1)";
				}else if(appearance_in_10_min.equals("2")){
					appearance_in_10_min=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Normaloverentirebody-completelypink.label","mp_labels")+"(2)";
				}
			}

			hashMap_detls.put("HEART_RATE_IN_1_MIN",heart_rate_in_1_min);
			hashMap_detls.put("HEART_RATE_IN_5_MIN",heart_rate_in_5_min);
			hashMap_detls.put("HEART_RATE_IN_10_MIN",heart_rate_in_10_min);
			hashMap_detls.put("BREATHING_IN_1_MIN",breathing_in_1_min);
			hashMap_detls.put("BREATHING_IN_5_MIN",breathing_in_5_min);
			hashMap_detls.put("BREATHING_IN_10_MIN",breathing_in_10_min);
			hashMap_detls.put("GRIMACE_IN_1_MIN",grimace_in_1_min);
			hashMap_detls.put("GRIMACE_IN_5_MIN",grimace_in_5_min);
			hashMap_detls.put("GRIMACE_IN_10_MIN",grimace_in_10_min);
			hashMap_detls.put("ACTIVITY_IN_1_MIN",activity_in_1_min);
			hashMap_detls.put("ACTIVITY_IN_5_MIN",activity_in_5_min);
			hashMap_detls.put("ACTIVITY_IN_10_MIN",activity_in_10_min);
			hashMap_detls.put("APPEARANCE_IN_1_MIN",appearance_in_1_min);
			hashMap_detls.put("APPEARANCE_IN_5_MIN",appearance_in_5_min);
			hashMap_detls.put("APPEARANCE_IN_10_MIN",appearance_in_10_min);
			hashMap_detls.put("NB_NAME_PREFIX",checkForNull(rs1.getString("NB_NAME_PREFIX")));
			hashMap_detls.put("NB_FIRST_NAME",checkForNull(rs1.getString("NB_FIRST_NAME")));
			hashMap_detls.put("NB_SECOND_NAME",checkForNull(rs1.getString("NB_SECOND_NAME"))); 
			hashMap_detls.put("NB_THIRD_NAME",checkForNull(rs1.getString("NB_THIRD_NAME")));
			hashMap_detls.put("NB_FAMILY_NAME_PREFIX",checkForNull(rs1.getString("NB_FAMILY_NAME_PREFIX")));
			hashMap_detls.put("NB_FAMILY_NAME",checkForNull(rs1.getString("NB_FAMILY_NAME")));
			hashMap_detls.put("NB_NAME_SUFFIX",checkForNull(rs1.getString("NB_NAME_SUFFIX")));
			hashMap_detls.put("NB_NAME_PREFIX_LOC_LANG",checkForNull(rs1.getString("NB_NAME_PREFIX_LOC_LANG")));
			hashMap_detls.put("NB_FIRST_NAME_LOC_LANG",checkForNull(rs1.getString("NB_FIRST_NAME_LOC_LANG")));
			hashMap_detls.put("NB_SECOND_NAME_LOC_LANG",checkForNull(rs1.getString("NB_SECOND_NAME_LOC_LANG")));
			hashMap_detls.put("NB_THIRD_NAME_LOC_LANG",checkForNull(rs1.getString("NB_THIRD_NAME_LOC_LANG")));
			hashMap_detls.put("NB_FAMILY_NAME_LOC_LANG",checkForNull(rs1.getString("NB_FAMILY_NAME_LOC_LANG")));
			hashMap_detls.put("NB_NAME_SUFFIX_LOC_LANG",checkForNull(rs1.getString("NB_NAME_SUFFIX_LOC_LANG")));
			hashMap_detls.put("FATHER_NAME_PREFIX",checkForNull(rs1.getString("FATHER_NAME_PREFIX")));
			hashMap_detls.put("FATHER_FIRST_NAME",checkForNull(rs1.getString("FATHER_FIRST_NAME")));
			hashMap_detls.put("FATHER_SECOND_NAME",checkForNull(rs1.getString("FATHER_SECOND_NAME")));
			hashMap_detls.put("FATHER_THIRD_NAME",checkForNull(rs1.getString("FATHER_THIRD_NAME")));
			hashMap_detls.put("FATHER_FAMILY_NAME_PREFIX",checkForNull(rs1.getString("FATHER_FAMILY_NAME_PREFIX")));
			hashMap_detls.put("FATHER_FAMILY_NAME",checkForNull(rs1.getString("FATHER_FAMILY_NAME")));
			hashMap_detls.put("FATHER_NAME_SUFFIX",checkForNull(rs1.getString("FATHER_NAME_SUFFIX")));
			hashMap_detls.put("FATHER_NAME_PREFIX_LOC_LANG",checkForNull(rs1.getString("FATHER_NAME_PREFIX_LOC_LANG")));
			hashMap_detls.put("FATHER_FIRST_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_FIRST_NAME_LOC_LANG")));
			hashMap_detls.put("FATHER_SECOND_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_SECOND_NAME_LOC_LANG")));
			hashMap_detls.put("FATHER_THIRD_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_THIRD_NAME_LOC_LANG")));
			hashMap_detls.put("FATHER_FAMILY_NAME_LOC_LANG",checkForNull(rs1.getString("FATHER_FAMILY_NAME_LOC_LANG")));
			hashMap_detls.put("FATHER_NAME_SUFFIX_LOC_LANG",checkForNull(rs1.getString("FATHER_NAME_SUFFIX_LOC_LANG")));
			hashMap_detls.put("MIDWIFE_NAME",checkForNull(rs1.getString("MIDWIFE_NAME")));
			hashMap_detls.put("COMPLNS_1ST_STAGE_LABOUR_DESC",checkForNull(rs1.getString("COMPLNS_1ST_STAGE_LABOUR_DESC")));
			hashMap_detls.put("COMPLNS_2ND_STAGE_LABOUR_DESC",checkForNull(rs1.getString("COMPLNS_2ND_STAGE_LABOUR_DESC")));
			hashMap_detls.put("COMPLNS_3RD_STAGE_LABOUR_DESC",checkForNull(rs1.getString("COMPLNS_3RD_STAGE_LABOUR_DESC")));
			hashMap_detls.put("PROC_CLASS_DESC",checkForNull(rs1.getString("PROC_CLASS_DESC")));
			hashMap_detls.put("DELY_SURG_CLASS_DESC",checkForNull(rs1.getString("DELY_SURG_CLASS_DESC")));
			hashMap_detls.put("NB_PATIENT_NAME",checkForNull(rs1.getString("NB_PATIENT_NAME")));
			hashMap_detls.put("FATHER_REMARKS",checkForNull(rs1.getString("FATHER_REMARKS")));
			hashMap_detls.put("NB_RELATION_TO_HEAD",checkForNull(rs1.getString("NB_RELATION_TO_HEAD")));
			hashMap_detls.put("OUTCOME",checkForNull(rs1.getString("OUTCOME")));
			hashMap_detls.put("NB_COMPLN_DELY_DESC",checkForNull(rs1.getString("NB_COMPLN_DELY_DESC")));
			
			//below line added for this CRFCRF MMS-QH-CRF-0145.1 [IN:047497]
            hijri_birth_date	=checkForNull(rs1.getString("hijri_birth_date"));		
			hashMap_detls.put("hijri_birth_date",hijri_birth_date);
			
			//Below line added for this CRF ML-MMOH-CRF-0621
			hashMap_detls.put("parity_on_admission",checkForNull(rs1.getString("parity_on_admission")));
			hashMap_detls.put("resuscitated_pract_id",checkForNull(rs1.getString("resuscitated_pract_id")));
			hashMap_detls.put("resuscitated_pract_desc",checkForNull(rs1.getString("resuscitated_pract_desc"))); 
			attend_physician_id=checkForNull(rs1.getString("attend_physician_id")); 			
		if(!attend_physician_id.equals("") && isRegNewbornApplicable){			
			national_id_no=(String)hashMap_param.get("NAT_ID_PROMPT");
			StringBuffer natstrBuffer=new StringBuffer("select national_id_num, oth_alt_id_no from am_practitioner where practitioner_id ='");	
			natstrBuffer.append(attend_physician_id).append("'");		    
			stmt = con.prepareStatement(natstrBuffer.toString());			
			rset = stmt.executeQuery();			
			if(rset!=null && rset.next()){		
				national_id=rset.getString("national_id_num")==null?"":rset.getString("national_id_num");
				other_alter_id=rset.getString("oth_alt_id_no")==null?"":rset.getString("oth_alt_id_no"); 
			}			
		 if(!national_id.equals("")){
				if(national_id_no.equals("")){
						nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
				}else{
						nat_other_alter_legend=national_id_no;	
				 }
				 
				nat_other_alter_id=national_id;					 
		 }else if(national_id.equals("") && !other_alter_id.equals("")){
					   nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels"); 
					   nat_other_alter_id=other_alter_id;
					 
		}
		  if(rset!=null) rset.close();
		  if(stmt!=null) stmt.close();
}	
				
//End this CRF ML-MMOH-CRF-0621
			
			


			
		
		//out.println(hashMap_detls.size());

		
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)hashMap_detls.get("MOTHER_PATIENT_ID")));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)hashMap_detls.get("MOTHER_PATIENT_NAME")));
            _bw.write(_wl_block13Bytes, _wl_block13);

/*Below line added for this CRF ML-MMOH-CRF-0621*/
if(isRegNewbornApplicable){			
String alt_id1_type_desc=checkForNull((String) hashMap_param.get("alt_id1_type_desc"));
String alt_id2_type_desc=checkForNull((String) hashMap_param.get("alt_id2_type_desc"));
String alt_id3_type_desc=checkForNull((String) hashMap_param.get("alt_id3_type_desc"));
String alt_id4_type_desc=checkForNull((String) hashMap_param.get("alt_id4_type_desc"));
String accept_oth_alt_id_yn=checkForNull((String) hashMap_param.get("accept_oth_alt_id_yn"));
String accept_national_id_no_yn=checkForNull((String) hashMap_param.get("ACCEPT_NATIONAL_ID_NO_YN"));
String nat_id_prompt=checkForNull((String) hashMap_param.get("NAT_ID_PROMPT"));

/*String alt_id1_no =checkForNull((String)hashMap_detls.get("mother_alt_id1_no"));
String alt_id2_no =checkForNull((String)hashMap_detls.get("mother_alt_id2_no")); 
String alt_id3_no =checkForNull((String)hashMap_detls.get("mother_alt_id3_no"));  
String alt_id4_no =checkForNull((String)hashMap_detls.get("alt_id4_no"));  
String m_oth_alt_id_no =checkForNull((String)hashMap_detls.get("mother_oth_alt_id_no"));  */

String alt_id1_no =checkForNull((String)hashMap_detls.get("m_alt_id1_no"));
String alt_id2_no =checkForNull((String)hashMap_detls.get("m_alt_id2_no")); 
String alt_id3_no =checkForNull((String)hashMap_detls.get("m_alt_id3_no"));
String m_oth_alt_id_no =checkForNull((String)hashMap_detls.get("m_oth_alt_id_no"));  


if(accept_national_id_no_yn.equals("Y")){		

            _bw.write(_wl_block14Bytes, _wl_block14);
 if(!nat_id_prompt.equals("")){  
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)hashMap_detls.get("MOTHER_NATIONAL_ID_NO")));
            _bw.write(_wl_block17Bytes, _wl_block17);
 }else {
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
if(!alt_id1_type_desc.equals("")){

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
}if(alt_id1_type_desc.equals("")&&!alt_id2_type_desc.equals("")){
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
} if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){
            out.print( String.valueOf(alt_id3_type_desc));
}if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
if(!alt_id1_type_desc.equals("")){
            out.print( String.valueOf(alt_id1_no));
}if(alt_id1_type_desc.equals("")&&!alt_id2_type_desc.equals("")){
            out.print( String.valueOf(alt_id2_no));
}if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){
            out.print( String.valueOf(alt_id3_no));
} if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){
            out.print( String.valueOf(m_oth_alt_id_no));
}
            _bw.write(_wl_block25Bytes, _wl_block25);

			  if((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && (accept_oth_alt_id_yn.equals("N") || accept_oth_alt_id_yn.equals("Y"))) && (alt_id3_type_desc.equals("") || !alt_id3_type_desc.equals("") ) ){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
 }
			if((!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") &&!alt_id3_type_desc.equals("") && (accept_oth_alt_id_yn.equals("N") ||accept_oth_alt_id_yn.equals("Y")) )){
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(alt_id3_type_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
 } if((!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) ){
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(m_oth_alt_id_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
 } 
            _bw.write(_wl_block30Bytes, _wl_block30);
 
                if((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")) || ((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && !!alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) ) ){   
               
			   
            _bw.write(_wl_block31Bytes, _wl_block31);
if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){
            out.print( String.valueOf(alt_id3_type_desc));
}else {

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){
            out.print( String.valueOf(alt_id3_no));
}else{
            out.print( String.valueOf(m_oth_alt_id_no));
}
            _bw.write(_wl_block33Bytes, _wl_block33);
 } if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(m_oth_alt_id_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
 } 
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((String)hashMap_param.get("NAT_ID_PROMPT")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)hashMap_detls.get("MOTHER_NATIONAL_ID_NO")));
            _bw.write(_wl_block38Bytes, _wl_block38);
if((String)hashMap_detls.get("mother_alt_id1_type")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_alt_id1_type")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_alt_id1_type")));
            _bw.write(_wl_block39Bytes, _wl_block39);
if((String)hashMap_detls.get("mother_alt_id1_no")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_alt_id1_no")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_alt_id1_no")));
            _bw.write(_wl_block40Bytes, _wl_block40);
if((String)hashMap_detls.get("mother_alt_id2_type")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_alt_id2_type")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_alt_id2_type")));
            _bw.write(_wl_block11Bytes, _wl_block11);
if((String)hashMap_detls.get("mother_alt_id2_no")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_alt_id2_no")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_alt_id2_no")));
            _bw.write(_wl_block41Bytes, _wl_block41);
if((String)hashMap_detls.get("mother_alt_id3_type")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_alt_id3_type")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_alt_id3_type")));
            _bw.write(_wl_block11Bytes, _wl_block11);
if((String)hashMap_detls.get("mother_alt_id3_no")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_alt_id3_no")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_alt_id3_no")));
            _bw.write(_wl_block40Bytes, _wl_block40);
if((String)hashMap_detls.get("mother_alt_id4_type")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_alt_id4_type")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_alt_id4_type")));
            _bw.write(_wl_block11Bytes, _wl_block11);
if((String)hashMap_detls.get("mother_alt_id4_no")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_alt_id4_no")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_alt_id4_no")));
            _bw.write(_wl_block42Bytes, _wl_block42);
if((String)hashMap_detls.get("mother_oth_alt_id_type")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_oth_alt_id_type")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_oth_alt_id_type")));
            _bw.write(_wl_block11Bytes, _wl_block11);
if((String)hashMap_detls.get("mother_oth_alt_id_no")!="")
            out.print( String.valueOf((String)hashMap_detls.get("mother_oth_alt_id_no")));
else
            out.print( String.valueOf((String)hashMap_detls.get("m_oth_alt_id_no")));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
					  //End this CRF ML-MMOH-CRF-0621
					
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)hashMap_detls.get("MULTIPLE_BIRTH_YN")));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)hashMap_detls.get("NO_OF_BIRTHS")));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

						if(((String)hashMap_param.get("UNIT_OF_GEST_NB")).equals("W")) {
						
					
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(checkForNull1(((String)hashMap_detls.get("GESTATIONAL_PERIOD")),"0")));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(checkForNull1(((String)hashMap_detls.get("GESTATIONAL_PERIOD_IN_DAYS")),"0")));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
 } else if(((String)hashMap_param.get("UNIT_OF_GEST_NB")).equals("D")) {
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(checkForNull1(((String)hashMap_detls.get("GESTATIONAL_PERIOD")),"0")));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

					
						}						
					
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)hashMap_detls.get("DELIVERY_TYPE")));
            _bw.write(_wl_block54Bytes, _wl_block54);

					/*Below line modified for this CRF ML-MMOH-CRF-0621*/
					if(isLabelChangeApplicable || isRegNewbornApplicable){
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
}else{
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)hashMap_detls.get("GRAVIDA")));
            _bw.write(_wl_block59Bytes, _wl_block59);
if(isLabelChangeApplicable || isRegNewbornApplicable){
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((String)hashMap_detls.get("PARITY")));
            _bw.write(_wl_block62Bytes, _wl_block62);
if(isRegNewbornApplicable){
            out.print( String.valueOf((String)hashMap_detls.get("parity_on_admission")));
}
					//End this CRF ML-MMOH-CRF-0621
					
            _bw.write(_wl_block63Bytes, _wl_block63);
if(isNewBornChngsAppl){

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)hashMap_detls.get("PHYSICIAN_NAME")));
            _bw.write(_wl_block64Bytes, _wl_block64);
if(isNewBornChngsAppl){

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)hashMap_detls.get("MIDWIFE_NAME")));
            _bw.write(_wl_block65Bytes, _wl_block65);
if(isNewBornChngsAppl){
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf((String)hashMap_detls.get("MOTHER_WITNESSED_BY1")));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf((String)hashMap_detls.get("MOTHER_WITNESSED_BY2")));
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
if(isRegNewbornApplicable){
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(nat_other_alter_legend));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(nat_other_alter_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("COMPLN_PREGNANCY_LONG_DESC")));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("COMPLN_NR_PREGNANCY_LONG_DESC")));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("COMPLNS_1ST_STAGE_LONG_DESC")));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("COMPLNS_2ND_STAGE_LONG_DESC")));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("COMPLNS_3RD_STAGE_LONG_DESC")));
            _bw.write(_wl_block75Bytes, _wl_block75);
if(isModifyLongShortDescAppl){

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("COMPLN_DELY_LONG_DESC")));
            _bw.write(_wl_block76Bytes, _wl_block76);
if(isModifyLongShortDescAppl){

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("DELY_IND_LONG_DESC")));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("PROC_CLASS_LONG_DESC")));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("VAGINAL_DEL_TYPE_LONG_DESC")));
            _bw.write(_wl_block75Bytes, _wl_block75);
if(isModifyLongShortDescAppl){

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)hashMap_detls.get("DELY_SURG_CLASS_LONG_DESC")));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)hashMap_detls.get("REMARKS")));
            _bw.write(_wl_block77Bytes, _wl_block77);
if(isNewBornChngsAppl || isMotherAliveAppl){
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if("Y".equals(mother_alive_yn)){

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
}else if("N".equals(mother_alive_yn)){

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_PATIENT_ID")));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_PATIENT_NAME")));
            _bw.write(_wl_block82Bytes, _wl_block82);

			String a1=	(String) hashMap_param.get("NAME_PREFIX_ACCEPT_YN");	
			String a2=	(String) hashMap_param.get("FIRST_NAME_ACCEPT_YN");		
			String a3=	(String) hashMap_param.get("SECOND_NAME_ACCEPT_YN");		
			String a4=	(String) hashMap_param.get("THIRD_NAME_ACCEPT_YN");		
			String a5=	(String) hashMap_param.get("FAMILY_NAME_ACCEPT_YN");		
			String a6=	(String) hashMap_param.get("NAME_SUFFIX_ACCEPT_YN");		
			String p1=	(String) hashMap_param.get("NAME_PREFIX_PROMPT");		
			String p2=	(String) hashMap_param.get("FIRST_NAME_PROMPT");		
			String p3=	(String) hashMap_param.get("SECOND_NAME_PROMPT");		
			String p4=	(String) hashMap_param.get("THIRD_NAME_PROMPT");		
			String p5=	(String) hashMap_param.get("FAMILY_NAME_PROMPT");	
			String p6=	(String) hashMap_param.get("NAME_SUFFIX_PROMPT");		
			String oth1=(String) hashMap_param.get("NAMES_IN_OTH_LANG_YN");		
			String op1=	(String) hashMap_param.get("NAME_PREFIX_LOC_LANG_PROMPT");		
			String op2=	(String) hashMap_param.get("FIRST_NAME_LOC_LANG_PROMPT");	
			String op3=	(String) hashMap_param.get("SECOND_NAME_LOC_LANG_PROMPT");		
			String op4=	(String) hashMap_param.get("THIRD_NAME_LOC_LANG_PROMPT");		
			String op5=	(String) hashMap_param.get("FAMILY_NAME_LOC_LANG_PROMPT");		
			String op6=	(String) hashMap_param.get("NAME_SUFFIX_LOC_LANG_PROMPT");		


			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a1.equals("Y")){
				out.println(p1);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a2.equals("Y")){
				out.println(p2);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a3.equals("Y")){
				out.println(p3);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a4.equals("Y")){
				out.println(p4);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a5.equals("Y")){
				out.println(p5);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a6.equals("Y")){
				out.println(p6);
			}
			out.println("</td>");
				
			
            _bw.write(_wl_block83Bytes, _wl_block83);

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a1.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_NAME_PREFIX"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a2.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_FIRST_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a3.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_SECOND_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a4.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_THIRD_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a5.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_FAMILY_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a6.equals("Y")){
				out.println((String)hashMap_detls.get("FATHER_NAME_SUFFIX"));
			}
			out.println("</td>");

			
            _bw.write(_wl_block84Bytes, _wl_block84);

			if(oth1.equals("Y")){
				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a1.equals("Y")){
					out.println(op1);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a2.equals("Y")){
					out.println(op2);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a3.equals("Y")){
					out.println(op3);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a4.equals("Y")){
					out.println(op4);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a5.equals("Y")){
					out.println(op5);
				}
				out.println("</td>");

				out.println("<td class='label'   width='15%''>&nbsp;");
				if(a6.equals("Y")){
					out.println(op6);
				}
				out.println("</td>");
			}
			
            _bw.write(_wl_block85Bytes, _wl_block85);

			if(oth1.equals("Y")){
				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a1.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_NAME_PREFIX_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a2.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_FIRST_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a3.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_SECOND_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a4.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_THIRD_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a5.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_FAMILY_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a6.equals("Y")){
					out.println((String)hashMap_detls.get("FATHER_NAME_SUFFIX_LOC_LANG"));
				}
				out.println("</td>");
				
				
			}
			
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf((String)hashMap_param.get("NAT_ID_PROMPT")));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_NATIONAL_ID_NO")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_ALT_ID1_TYPE")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_ALT_ID1_NO")));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_ALT_ID2_TYPE")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_ALT_ID2_NO")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_ALT_ID3_TYPE")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_ALT_ID3_NO")));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_ALT_ID4_TYPE")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_ALT_ID4_NO")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((String)hashMap_detls.get("father_oth_alt_id_type")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_OTH_ALT_ID_NO")));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf((String)hashMap_detls.get("OTH_ALT_ID_DESC")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_OTH_ALT_ID_NO")));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_NAT_DESC")));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_RACE_DESC")));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_GOVE_EMPLOYEE_YN")));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf((String)hashMap_detls.get("RELGN_DESC")));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("OCPN_CLASS_DESC")));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf((String)hashMap_detls.get("OCPN_DESC")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_OCPN_DESC")));
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)hashMap_detls.get("FATHER_REMARKS")));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)hashMap_detls.get("NB_PATIENT_NAME")));
            _bw.write(_wl_block106Bytes, _wl_block106);

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a1.equals("Y")){
				out.println(p1);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a2.equals("Y")){
				out.println(p2);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a3.equals("Y")){
				out.println(p3);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a4.equals("Y")){
				out.println(p4);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a5.equals("Y")){
				out.println(p5);
			}
			out.println("</td>");

			out.println("<td class='label'  width='15%'>&nbsp;");
			if(a6.equals("Y")){
				out.println(p6);
			}
			out.println("</td>");
				
			
            _bw.write(_wl_block83Bytes, _wl_block83);

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a1.equals("Y")){
				out.println((String)hashMap_detls.get("NB_NAME_PREFIX"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a2.equals("Y")){
				out.println((String)hashMap_detls.get("NB_FIRST_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a3.equals("Y")){
				out.println((String)hashMap_detls.get("NB_SECOND_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a4.equals("Y")){
				out.println((String)hashMap_detls.get("NB_THIRD_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a5.equals("Y")){
				out.println((String)hashMap_detls.get("NB_FAMILY_NAME"));
			}
			out.println("</td>");

			out.println("<td class='querydata'  width='15%'>&nbsp;");
			if(a6.equals("Y")){
				out.println((String)hashMap_detls.get("NB_NAME_SUFFIX"));
			}
			out.println("</td>");

			
            _bw.write(_wl_block84Bytes, _wl_block84);

			if(oth1.equals("Y")){
				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a1.equals("Y")){
					out.println(op1);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a2.equals("Y")){
					out.println(op2);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a3.equals("Y")){
					out.println(op3);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a4.equals("Y")){
					out.println(op4);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a5.equals("Y")){
					out.println(op5);
				}
				out.println("</td>");

				out.println("<td class='label'  width='15%'>&nbsp;");
				if(a6.equals("Y")){
					out.println(op6);
				}
				out.println("</td>");
			}
			
            _bw.write(_wl_block85Bytes, _wl_block85);

			if(oth1.equals("Y")){
				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a1.equals("Y")){
					out.println((String)hashMap_detls.get("NB_NAME_PREFIX_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a2.equals("Y")){
					out.println((String)hashMap_detls.get("NB_FIRST_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a3.equals("Y")){
					out.println((String)hashMap_detls.get("NB_SECOND_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a4.equals("Y")){
					out.println((String)hashMap_detls.get("NB_THIRD_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a5.equals("Y")){
					out.println((String)hashMap_detls.get("NB_FAMILY_NAME_LOC_LANG"));
				}
				out.println("</td>");

				out.println("<td class='querydata'  width='15%'>&nbsp;");
				if(a6.equals("Y")){
					out.println((String)hashMap_detls.get("NB_NAME_SUFFIX_LOC_LANG"));
				}
				out.println("</td>");
				
				
			}
			
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf((String)hashMap_detls.get("NB_SEX")));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf((String)hashMap_detls.get("NB_BIRTH_DATE")));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf((String)hashMap_detls.get("NB_BIRTH_TIME")));
            _bw.write(_wl_block111Bytes, _wl_block111);
if(hijirisitespecifApplicable){

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf((String)hashMap_detls.get("hijri_birth_date")));
            _bw.write(_wl_block114Bytes, _wl_block114);
}
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("NB_BLOOD_GRP")));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("NB_RH_FACTOR")));
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("NB_RELATION_TO_HEAD")));
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf((String)hashMap_detls.get("OUTCOME")));
            _bw.write(_wl_block120Bytes, _wl_block120);

			String outcome1=	(String)hashMap_detls.get("OUTCOME");	
				if(outcome1.equals("Still Born"))
				{
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.StillBirthDtls.label","mp_labels")));
            _bw.write(_wl_block122Bytes, _wl_block122);
}else{ if(isLabelChangeApplicable){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
}else{
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
}}
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("INDICATOR_MARK")));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 String born_where=(String)hashMap_detls.get("BORN_WHERE");			
			if(born_where.equals("In Facility")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
} else if(born_where.equals("Home")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
} else if(born_where.equals("Ambulance")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else if(born_where.equals("Other Mode of Transport")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else if(born_where.equals("Born Before Arrival")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
}else{
            _bw.write(_wl_block130Bytes, _wl_block130);
}
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 String born_at=(String)hashMap_detls.get("BORN_AT");			
			if(born_at.equals("Clinic")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
} else if(born_at.equals("Nursing Unit")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
} else if(born_at.equals("DayCare Unit")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else if(born_at.equals("Emergency")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}
			/*Added by Ashwini on 27-Jun-2018 for ML-MMOH-CRF-0833*/
			else if(born_at.equals("OT Specific")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else if(born_at.equals("Procedure Unit")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else if(born_at.equals("Radiology Wing")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else if(born_at.equals("Room")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block130Bytes, _wl_block130);
}
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("ANT_CARE_LOCN_DESC")));
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("BIRTH_PLACE_DESC")));
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("BIRTH_CERTIFICATE_NO")));
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("WEIGHT")));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf((String)hashMap_param.get("UNIT_OF_WT_NB")));
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("LENGTH")));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf((String)hashMap_param.get("UNIT_OF_LENGTH_NB")));
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf((String)hashMap_detls.get("HEAD_CIRCUMFERENCE")));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf((String)hashMap_param.get("UNIT_OF_CIRCUM_NB")));
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("CHEST_CIRCUMFERENCE")));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf((String)hashMap_param.get("UNIT_OF_CHEST_CIRCUM_NB")));
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf((String)hashMap_detls.get("APGAR_SCORE_IN_1_MIN")));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf((String)hashMap_detls.get("APGAR_SCORE_IN_5_MINS")));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)hashMap_detls.get("APGAR_SCORE_IN_10_MINS")));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("ACTIVITY_IN_1_MIN")));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((String)hashMap_detls.get("ACTIVITY_IN_5_MIN")));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf((String)hashMap_detls.get("ACTIVITY_IN_10_MIN")));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("HEART_RATE_IN_1_MIN")));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((String)hashMap_detls.get("HEART_RATE_IN_5_MIN")));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf((String)hashMap_detls.get("HEART_RATE_IN_10_MIN")));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf((String)hashMap_detls.get("GRIMACE_IN_1_MIN")));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf((String)hashMap_detls.get("GRIMACE_IN_5_MIN")));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf((String)hashMap_detls.get("GRIMACE_IN_10_MIN")));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("APPEARANCE_IN_1_MIN")));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((String)hashMap_detls.get("APPEARANCE_IN_5_MIN")));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf((String)hashMap_detls.get("APPEARANCE_IN_10_MIN")));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)hashMap_detls.get("BREATHING_IN_1_MIN")));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((String)hashMap_detls.get("BREATHING_IN_5_MIN")));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf((String)hashMap_detls.get("BREATHING_IN_10_MIN")));
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
 String umbilical_cord_status=(String)hashMap_detls.get("UMBILICAL_CORD_STATUS");
			if(umbilical_cord_status.equals("Normal")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
} else if(umbilical_cord_status.equals("Stump")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
} else if(umbilical_cord_status.equals("Other")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block130Bytes, _wl_block130);
}
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf((String)hashMap_detls.get("UMB_CORD_CUT_BY")));
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
String feeding = (String)hashMap_detls.get("FEEDING");
			if(feeding.equals("T")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
} else if(feeding.equals("B")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
} else if(feeding.equals("O")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block154Bytes, _wl_block154);
}
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
String patency_of_anus_yn = (String)hashMap_detls.get("PATENCY_OF_ANUS_YN");			
			if(patency_of_anus_yn.equals("Patent")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
} else if(patency_of_anus_yn.equals("Not Patent")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
}else{
            _bw.write(_wl_block130Bytes, _wl_block130);
}
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf((String)hashMap_detls.get("CONG_ANOMALIES_LONG_DESC")));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf((String)hashMap_detls.get("PATENCY_OF_ANUS_CHECKED_BY")));
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
String stools = (String)hashMap_detls.get("STOOLS");
			if(stools.equals("M")){
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
} else if(stools.equals("Y")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
} else if(stools.equals("O")){	
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block161Bytes, _wl_block161);
}
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf((String)hashMap_detls.get("NB_COMPLN_DEL_LONG_DESC")));
            _bw.write(_wl_block164Bytes, _wl_block164);
/*Below line added for this CRF ML-MMOH-CRF-0621*/
			  if(isRegNewbornApplicable){
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf((String)hashMap_detls.get("resuscitated_pract_desc")));
            _bw.write(_wl_block167Bytes, _wl_block167);
}
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf((String)hashMap_detls.get("BCG_YN")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("VACCINATION_SITE")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("ADMINISTERED_BY")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("ADMINISTERED_DESIGNATION")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("BCG_VACC_ADMN_DATE")));
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf((String)hashMap_detls.get("VITK_N_HEPB_GIVEN_YN")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("VITAK_VACC_SITE")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("VITAK_ADMINISTERED_BY")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("VITAK_ADMINISTERED_DESIG")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("VITK_VACC_ADMN_DATE")));
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf((String)hashMap_detls.get("HEPB_YN")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("HEPB_VACC_SITE")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("HEPB_ADMINISTERED_BY")));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf((String)hashMap_detls.get("HEPB_ADMINISTERED_DESIG")));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf((String)hashMap_detls.get("HEPB_VACC_ADMN_DATE")));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(hijirisitespecifApplicable));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(hijri_birth_date));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(Date_Of_Birth));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(isRegNewbornApplicable));
            _bw.write(_wl_block184Bytes, _wl_block184);

	}else{
				out.println("<script>alert(getMessage('BIRTH_REG_NOT_APPLICABLE','MP'));</script>");
	}
	}
	catch(Exception e)
	{
		out.println("Exception in main"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	} 

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.viewbirthregdtls.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.motherdetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mothers.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mothers.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MultipleBirth.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoofBirths.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Gestation.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliveryType.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.GravidaOnAdmission.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Gravida.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ParityOnAdmission.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Parity.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConductedBy.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AssistedBy.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AttendingNurse.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.WitnessedBy1.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.WitnessedBy2.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ComplicationsRelatedPregnancy.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ComplicationsNotRelatedPregnancy.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin1stStage.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin2ndStage.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Complicationsin3rdStage.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OperativeComplications.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CompofDelivery.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.IndicationsForOperativeDelivery.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliveryIndication.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ProcedureClassification.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VaginalDeliveryType.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliverySurgClass.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DeliverySurgicalClassification.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Alive.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.fatherdetails.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.GovtEmployee.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.religion.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OccupationClass.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.occupation.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.newborndetails.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Birth.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Hijri.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bloodgroup.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RHDFactor.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outcome.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Alive.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Live.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.IndicatorMark.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BornWhere.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.InFacility.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.home.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Ambulance.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherModesofTpt.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BornBeforeArrival.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Bornat.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DaycareUnit.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.OTSpecific.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcedureUnit.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RadiologyWing.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthCertificateNo.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BirthWeight.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.LengthofBaby.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HeadCircumference.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ChestCirumference.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApgarScore.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.in1Min.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.in5Min.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.in10Min.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Activity.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Pulse.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Grimace.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Appearance.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Respiration.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UmbilicalCord.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Stump.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.UmbCordCutBy.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Feeding.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Breast.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Bottle.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatencyofAnus.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }

    private boolean _jsp__tag110(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag110 = null ;
        int __result__tag110 = 0 ;

        if (__tag110 == null ){
            __tag110 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag110);
        }
        __tag110.setPageContext(pageContext);
        __tag110.setParent(null);
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Patent.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag110;
        __result__tag110 = __tag110.doStartTag();

        if (__result__tag110!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag110== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag110.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag110);
            return true;
        }
        _activeTag=__tag110.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag110);
        __tag110.release();
        return false;
    }

    private boolean _jsp__tag111(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag111 = null ;
        int __result__tag111 = 0 ;

        if (__tag111 == null ){
            __tag111 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag111);
        }
        __tag111.setPageContext(pageContext);
        __tag111.setParent(null);
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NotPatent.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag111;
        __result__tag111 = __tag111.doStartTag();

        if (__result__tag111!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag111== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag111.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag111);
            return true;
        }
        _activeTag=__tag111.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag111);
        __tag111.release();
        return false;
    }

    private boolean _jsp__tag112(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag112 = null ;
        int __result__tag112 = 0 ;

        if (__tag112 == null ){
            __tag112 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag112);
        }
        __tag112.setPageContext(pageContext);
        __tag112.setParent(null);
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CongenitalAnomalies.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag112;
        __result__tag112 = __tag112.doStartTag();

        if (__result__tag112!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag112== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag112.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag112);
            return true;
        }
        _activeTag=__tag112.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag112);
        __tag112.release();
        return false;
    }

    private boolean _jsp__tag113(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag113 = null ;
        int __result__tag113 = 0 ;

        if (__tag113 == null ){
            __tag113 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag113);
        }
        __tag113.setPageContext(pageContext);
        __tag113.setParent(null);
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatencyofAnusCheckedBy.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag113;
        __result__tag113 = __tag113.doStartTag();

        if (__result__tag113!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag113== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag113.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag113);
            return true;
        }
        _activeTag=__tag113.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag113);
        __tag113.release();
        return false;
    }

    private boolean _jsp__tag114(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag114 = null ;
        int __result__tag114 = 0 ;

        if (__tag114 == null ){
            __tag114 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag114);
        }
        __tag114.setPageContext(pageContext);
        __tag114.setParent(null);
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Stools.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag114;
        __result__tag114 = __tag114.doStartTag();

        if (__result__tag114!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag114== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag114.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag114);
            return true;
        }
        _activeTag=__tag114.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag114);
        __tag114.release();
        return false;
    }

    private boolean _jsp__tag115(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag115 = null ;
        int __result__tag115 = 0 ;

        if (__tag115 == null ){
            __tag115 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag115);
        }
        __tag115.setPageContext(pageContext);
        __tag115.setParent(null);
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Meconium.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag115;
        __result__tag115 = __tag115.doStartTag();

        if (__result__tag115!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag115== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag115.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag115);
            return true;
        }
        _activeTag=__tag115.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag115);
        __tag115.release();
        return false;
    }

    private boolean _jsp__tag116(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag116 = null ;
        int __result__tag116 = 0 ;

        if (__tag116 == null ){
            __tag116 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag116);
        }
        __tag116.setPageContext(pageContext);
        __tag116.setParent(null);
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.YellowSoft.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag116;
        __result__tag116 = __tag116.doStartTag();

        if (__result__tag116!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag116== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag116.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag116);
            return true;
        }
        _activeTag=__tag116.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag116);
        __tag116.release();
        return false;
    }

    private boolean _jsp__tag117(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag117 = null ;
        int __result__tag117 = 0 ;

        if (__tag117 == null ){
            __tag117 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag117);
        }
        __tag117.setPageContext(pageContext);
        __tag117.setParent(null);
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag117;
        __result__tag117 = __tag117.doStartTag();

        if (__result__tag117!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag117== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag117.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag117);
            return true;
        }
        _activeTag=__tag117.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag117);
        __tag117.release();
        return false;
    }

    private boolean _jsp__tag118(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag118 = null ;
        int __result__tag118 = 0 ;

        if (__tag118 == null ){
            __tag118 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag118);
        }
        __tag118.setPageContext(pageContext);
        __tag118.setParent(null);
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FetusCompofDelivery.label", java.lang.String .class,"key"));
        __tag118.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag118;
        __result__tag118 = __tag118.doStartTag();

        if (__result__tag118!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag118== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag118.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag118);
            return true;
        }
        _activeTag=__tag118.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag118);
        __tag118.release();
        return false;
    }

    private boolean _jsp__tag119(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag119 = null ;
        int __result__tag119 = 0 ;

        if (__tag119 == null ){
            __tag119 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag119);
        }
        __tag119.setPageContext(pageContext);
        __tag119.setParent(null);
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Resuscitated.label", java.lang.String .class,"key"));
        __tag119.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag119;
        __result__tag119 = __tag119.doStartTag();

        if (__result__tag119!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag119== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag119.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag119);
            return true;
        }
        _activeTag=__tag119.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag119);
        __tag119.release();
        return false;
    }

    private boolean _jsp__tag120(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag120 = null ;
        int __result__tag120 = 0 ;

        if (__tag120 == null ){
            __tag120 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag120);
        }
        __tag120.setPageContext(pageContext);
        __tag120.setParent(null);
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.vaccinationdetails.label", java.lang.String .class,"key"));
        __tag120.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag120;
        __result__tag120 = __tag120.doStartTag();

        if (__result__tag120!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag120== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag120.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag120);
            return true;
        }
        _activeTag=__tag120.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag120);
        __tag120.release();
        return false;
    }

    private boolean _jsp__tag121(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag121 = null ;
        int __result__tag121 = 0 ;

        if (__tag121 == null ){
            __tag121 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag121);
        }
        __tag121.setPageContext(pageContext);
        __tag121.setParent(null);
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VaccSite.label", java.lang.String .class,"key"));
        __tag121.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag121;
        __result__tag121 = __tag121.doStartTag();

        if (__result__tag121!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag121== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag121.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag121);
            return true;
        }
        _activeTag=__tag121.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag121);
        __tag121.release();
        return false;
    }

    private boolean _jsp__tag122(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag122 = null ;
        int __result__tag122 = 0 ;

        if (__tag122 == null ){
            __tag122 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag122);
        }
        __tag122.setPageContext(pageContext);
        __tag122.setParent(null);
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdministeredBy.label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag122;
        __result__tag122 = __tag122.doStartTag();

        if (__result__tag122!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag122== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag122.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag122);
            return true;
        }
        _activeTag=__tag122.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag122);
        __tag122.release();
        return false;
    }

    private boolean _jsp__tag123(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag123 = null ;
        int __result__tag123 = 0 ;

        if (__tag123 == null ){
            __tag123 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag123);
        }
        __tag123.setPageContext(pageContext);
        __tag123.setParent(null);
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.designation.label", java.lang.String .class,"key"));
        __tag123.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag123;
        __result__tag123 = __tag123.doStartTag();

        if (__result__tag123!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag123== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag123.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag123);
            return true;
        }
        _activeTag=__tag123.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag123);
        __tag123.release();
        return false;
    }

    private boolean _jsp__tag124(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag124 = null ;
        int __result__tag124 = 0 ;

        if (__tag124 == null ){
            __tag124 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag124);
        }
        __tag124.setPageContext(pageContext);
        __tag124.setParent(null);
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
        __tag124.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag124;
        __result__tag124 = __tag124.doStartTag();

        if (__result__tag124!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag124== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag124.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag124);
            return true;
        }
        _activeTag=__tag124.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag124);
        __tag124.release();
        return false;
    }

    private boolean _jsp__tag125(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag125 = null ;
        int __result__tag125 = 0 ;

        if (__tag125 == null ){
            __tag125 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag125);
        }
        __tag125.setPageContext(pageContext);
        __tag125.setParent(null);
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BCG.label", java.lang.String .class,"key"));
        __tag125.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag125;
        __result__tag125 = __tag125.doStartTag();

        if (__result__tag125!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag125== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag125.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag125);
            return true;
        }
        _activeTag=__tag125.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag125);
        __tag125.release();
        return false;
    }

    private boolean _jsp__tag126(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag126 = null ;
        int __result__tag126 = 0 ;

        if (__tag126 == null ){
            __tag126 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag126);
        }
        __tag126.setPageContext(pageContext);
        __tag126.setParent(null);
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.VitaminK.label", java.lang.String .class,"key"));
        __tag126.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag126;
        __result__tag126 = __tag126.doStartTag();

        if (__result__tag126!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag126== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag126.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag126);
            return true;
        }
        _activeTag=__tag126.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag126);
        __tag126.release();
        return false;
    }

    private boolean _jsp__tag127(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag127 = null ;
        int __result__tag127 = 0 ;

        if (__tag127 == null ){
            __tag127 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag127);
        }
        __tag127.setPageContext(pageContext);
        __tag127.setParent(null);
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HepatitisB.label", java.lang.String .class,"key"));
        __tag127.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag127;
        __result__tag127 = __tag127.doStartTag();

        if (__result__tag127!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag127== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag127.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag127);
            return true;
        }
        _activeTag=__tag127.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag127);
        __tag127.release();
        return false;
    }
}
