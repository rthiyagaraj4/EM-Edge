package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.itextpdf.text.log.SysoLogger;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __gcpgenerateplanshowlibrary extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/GCPGeneratePlanShowLibrary.jsp", 1742798083680L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t</title>\n<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link>\t\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n  \t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCP/js/GCPGenerateCarePlan.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t<!--\n\t \n\t function scrollTitle()\n\t{\n\t\t  var scrollXY = document.body.scrollTop;\n\t\t  if(scrollXY == 0)\n\t\t  {\n\t\t\t\t\t\tdocument.getElementById(\'showLibrary\').style.position = \'static\';\n\t\t\t\t\t\tdocument.getElementById(\'showLibrary\').style.posTop  = 0;\n\t\t  }\n\t\t  else\n\t\t  {\n\t\t\t\t\tdocument.getElementById(\'showLibrary\').style.position = \'relative\';\n\t\t\t\t\tdocument.getElementById(\'showLibrary\').style.posTop  = scrollXY;\n\t\t  }\n\t}\n\t//-->\n\n\t</SCRIPT>\t\n\t\n</head>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\'>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<form name=\'generate_summary\' id=\'generate_summary\' target=\'messageFrame\' >\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=center >\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\'\' class=\'CAGROUPHEADING\' wrap width=\'2%\' align=\'center\'><font size=\"4\" height=\'\' class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>&nbsp;&nbsp;</font></td>\n\t\t\t\t\t\t\t<td colspan=\'\' class=\'CAGROUPHEADING\' wrap width=\'35%\'><!-- <font size=\"4\" height=\'\' class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>&nbsp;&nbsp;</font>&nbsp;--> \n\t\t\t\t\t\t\t\t<font size=\"1\">\n\t\t\t\t\t\t\t\t\t<a href=\"#\"  onClick=\'javascript:showDescription(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\")\'><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =":";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></a>\n\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'CAGROUPHEADING\' align=\'center\'><font size=\"1\"><b>&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;<input type=\"textbox\" name=\'start_date";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'start_date";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' size=\'14\'onBlur=\'checkValidDateTime(this,locale);calcDiagTrgDate(";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =",\"\");setDatesToBean();\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\'return showCalendar(\"start_date";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\",null,\"hh:mm\",true);\' onBlur=\'callFocus(\"st_date\",\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\")\' >&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;<input type=\"textbox\" name=\"target_pd";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"target_pd";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' size=\'1\'  maxlength=\'2\' onBlur=\'CheckNum(this);calToDate(this,\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\",\"generate_summary\");setDatesToBean()\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;<input type=\"textbox\" name=\'target_date";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'target_date";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' size=\'14\' onBlur=\'checkValidDateTime(this);checkGRDate(start_date";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =",this);setToDate(\"dtarget_date\",\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\",\"generate_summary\");setDatesToBean()\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\'return showCalendar(\"target_date";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\",null,\"hh:mm\",true);\'  onBlur=\'callFocus(\"trg_date\",\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\")\'></font></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\n\t\t\t\t\t\t<input type =\'hidden\' name=\'dgroup_cnt";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'dgroup_cnt";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\t\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t\t\t\t\t<input type =\'hidden\' name=\'library_id";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'library_id";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t\t<input type =\'hidden\' name=\'version_no";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'version_no";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t\t\t<input type =\'hidden\' name=\'term_set_id";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'term_set_id";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t\t<input type =\'hidden\' name=\'term_code";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'term_code";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'GRPNONE\' colspan=\'3\'>\n\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"95%\" align=center >\n\t\t\t\t\t\t\t<tr>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<td class=\'GRPNONE\' align=\'left\' width=\'60%\'><input type=\"checkbox\" name=\"chk_goal";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"chk_goal";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" onClick=\"chkValid(";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =")\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="><font size=\"1\"><b>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" :&nbsp;";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</b></font></td>\n\t\t\t\t\t\t\t\t<td class=\'GRPNONE\' align=\'right\' width=\'40%\'><font size=\"1\"><b>&nbsp;";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&nbsp;</b></font><input type=\"text\" name=\"dtarget_date";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"dtarget_date";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' size=\'15\' onBlur=\'checkValidDateTime(this);CalDiagnosisTargDt(";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =");\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\'return showCalendar(\"dtarget_date";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\",null,\"hh:mm\",true);\' onBlur=\'callFocus(\"dtarget_date\",\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\")\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<input type =\'hidden\' name=\'goal";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'goal";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t\t\t\t\t\t<input type =\'hidden\' name=\'tar_prd";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'tar_prd";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\t\n\t\t\t\t\t\t\t<input type =\'hidden\' name=\'tar_prd_unt";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'tar_prd_unt";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\t\t\n\t\t\t\t\t\t\t<input type =\'hidden\' name=\'gl_tar_dt";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'gl_tar_dt";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\t\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'3\' class=\'GRPNONE\' >\n\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"85%\" align=center bgcolor=\'\'>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\'50%\' valign=\'top\' >\t\n\t\t\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=center >\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td align=\'left\'class=\'GRPINTERHEAD\' width=\'50%\'>\n\t\t\t\t\t\t\t\t\t\t\t<font size=\"1\"><B>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</B> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\'#\'  onclick=\'javascript:addInterventions(\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\");\' >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td align=\'left\'class=\'GRPINTERHEAD\' width=\'50%\'>\n\t\t\t\t\t\t\t\t\t\t\t<font size=\"1\"><B>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</B>\n\t\t\t\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td valign=\'top\' class=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t\t\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=center >\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' align=\'center\'  width=\'5%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk_inter";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"chk_inter";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" onClick=\'chkValidate(\"Inter\",";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =",";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =")\' ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =">\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' align=\'left\' wrap>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<font size=\"1\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</font>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'inter_code";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' id=\'inter_code";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'int_group_id";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' id=\'int_group_id";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'gint_cnt";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' id=\'gint_cnt";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\t\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td valign=\'top\' class=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t\t\t\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=center>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' align=\'center\' width=\'5%\'><input type=\"checkbox\" name=\"chk_outcome";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"chk_outcome";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" onClick=\'chkValidate(\"Outer\",";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =">\n\t\t\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' align=\'left\' wrap><font size=\"1\">";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</font>\n\t\t\t\t\t\t\t\t\t\t\t\t</td >\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'outcome_code";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' id=\'outcome_code";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\t\n\t\t\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'out_group_id";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' id=\'out_group_id";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'gout_cnt";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'gout_cnt";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\t\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'gcnt";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' id=\'gcnt";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\t\n\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'inter_cnt";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' id=\'inter_cnt";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\t\n\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'outcome_cnt";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' id=\'outcome_cnt";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\t\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t </tr>\t\n\t\t\t\t\t\t\t </table>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'GRPNONE\' align=\'center\'>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'GRPNONE\'  align=\'center\'>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'GRPNONE\'  align=\'center\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n<input type =\'hidden\' name=\'dgroup_cnt";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\t\n<input type =\'hidden\' name=\'dgroup_count\' id=\'dgroup_count\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n<input type =\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\t\n<input type =\'hidden\' name=\'goal_st\' id=\'goal_st\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\t\n<input type =\'hidden\' name=\'goal_stmt\' id=\'goal_stmt\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n<input type =\'hidden\' name=\'value_str\' id=\'value_str\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n<input type =\'hidden\' name=\'finalStr\' id=\'finalStr\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n<input type =\'hidden\' name=\'st_date\' id=\'st_date\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n<input type =\'hidden\' name=\'sel_lib_ids\' id=\'sel_lib_ids\' value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n<input type =\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n</table>\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\n</form>\n<script >\n//alert(document.generate_summary.goal_stmt.value);\ntry\n{\n\tparent.parent.GeneratePlanManager.document.care_planmanager.goal_statement.value = document.generate_summary.goal_stmt.value;\n}\ncatch(e){}\nif(\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" != \"\")\n{\t\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\tparent.parent.GeneratePlanManager.document.care_planmanager.start_date.value = \"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\";\n\t\tparent.parent.GeneratePlanManager.document.care_planmanager.target_date.value = \"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\";\n\n\t\t//parent.parent.GeneratePlanManager.document.care_planmanager.target_value.focus();\n}\nelse\n{\n\t\tparent.parent.GeneratePlanManager.document.care_planmanager.start_date.value = document.generate_summary.st_date.value;\n}\n\nparent.parent.GeneratePlanManager.document.care_planmanager.start_date.focus();\nparent.parent.GeneratePlanManager.document.care_planmanager.goal_statement.focus();\n//eval(\"document.generate_summary.chk_goal\"+0).focus();\n//alert(\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\")\n//alert(document.generate_summary.i.value)\ncalculatePlanDiagTargetDate(\"generate_summary\");\nsetDatesToBean();\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\t\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

	String replaceString(String sourceString,String str,String replaceWith)
	{
		int index=0;
		StringBuffer sourceBuffer = new StringBuffer(sourceString);
		while((index=sourceBuffer.toString().indexOf(str))!=-1)
		{
			sourceBuffer=sourceBuffer.replace(index,index+1,replaceWith);

		}
		return sourceBuffer.toString();
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

/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
05/06/2024   60772      Twinkle Shah    05/06/2024	    Ramesh Goli      MMS-JU-SCF-0267
--------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCP.GCPGeneratePlanBean GCPGenerateBean= null;synchronized(session){
                GCPGenerateBean=(eCP.GCPGeneratePlanBean)pageContext.getAttribute("GCPGenerateBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(GCPGenerateBean==null){
                    GCPGenerateBean=new eCP.GCPGeneratePlanBean();
                    pageContext.setAttribute("GCPGenerateBean",GCPGenerateBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	//This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locale=(String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

String obj				= request.getParameter("obj")==null?"":request.getParameter("obj"); //60772
String value_str				= request.getParameter("value_str")==null?"":request.getParameter("value_str");
String encounterId				= request.getParameter("encounterId")==null?"":request.getParameter("encounterId"); //60772
String[] encounterIds = encounterId.split(",");//60772
eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
//String pract_desc				= bean.getCareManagerDesc();
SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");
java.util.Date date_time	 	= new java.util.Date();
String dateString 				= com.ehis.util.DateUtils.convertDate(dtSystemFormat.format(date_time),"DMYHM","en",locale);
String tmp_st_date				= dateString;
String patient_id				= bean.getPatientId();
String encounter_id			= (String)request.getParameter("encounter_id"); //60772
String sel_lib_ids				= "";
HashMap codeKeyValue			= new HashMap();	
if(value_str.equals(""))
{
	codeKeyValue		=	bean.getSelectedLib();			
	Set s				=	codeKeyValue.keySet();	
	Object[] record		=	s.toArray();
	for(int c=0;c<record.length;c++)
	{
		value_str		=	value_str +record[c].toString();
	}
	
}

//out.println("<script>alert('value_str::"+bean.getSelectedLib()+"')</script>");
String sql			= "";
String sql1			= "";
String sql2			= "";
String sql3			= "";
String classValue	="";
int first_time		= 0;
int group_id		= 0;
int dgroup_cnt		= 0;
int dgroup_count	= 0;
first_time			= bean.getPageFirst();
boolean chk_flag	= false;
//out.println("<script>alert('first_time::"+first_time+"')</script>");
Connection con		= null;
PreparedStatement ps= null,ps1 = null,ps2 = null,ps3 = null;
ResultSet rs		= null,rs1 = null,rs2 = null,rs3 = null;


            _bw.write(_wl_block11Bytes, _wl_block11);

try{

con =ConnectionManager.getConnection(request);
//sql ="select A.TERM_SET_ID ,B.TERM_SET_DESC ,A.TERM_CODE ,C.SHORT_DESC TERM_CODE_SHORT_DESC ,A.GOAL_CODE ,D.SHORT_DESC GOAL_SHORT_DESC ,A.GOAL_TARGET_DURN ,A.GOAL_TARGET_DURN_UNIT ,Decode(A.GOAL_TARGET_DURN_UNIT,'D',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN,'DD/MM/YYYY HH24:MI'),'H',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN/24 , 'DD/MM/YYYY HH24:MI'),'M',TO_CHAR(SYSDATE+(A.GOAL_TARGET_DURN/(24*60)),'DD/MM/YYYY HH24:MI'),'L',TO_CHAR(ADD_MONTHS(SYSDATE,A.GOAL_TARGET_DURN) , 'DD/MM/YYYY HH24:MI'),'W',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN*7 , 'DD/MM/YYYY HH24:MI'),'')GOAL_TARGET_DATE,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')GOAL_START_DATE, E.CURR_PRIORITY  FROM CP_LIBRARY_GOAL A ,MR_TERM_SET  B ,MR_TERM_CODE C ,CP_OUTCOME D,PR_DIAGNOSIS E  WHERE    A.LIBRARY_ID = ? AND A.VERSION_NO = ? AND A.TERM_SET_ID  = ? AND A.TERM_CODE  = ? AND  B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE=A.TERM_CODE AND D.OUTCOME_CODE=A.GOAL_CODE AND E.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_CODE=A.TERM_CODE AND E.PATIENT_ID = ? AND E.CURR_STATUS = 'A' ORDER BY E.CURR_PRIORITY,3 ";
//sql ="SELECT A.TERM_SET_ID ,B.TERM_SET_DESC ,A.TERM_CODE ,C.SHORT_DESC TERM_CODE_SHORT_DESC ,A.GOAL_CODE ,D.SHORT_DESC GOAL_SHORT_DESC ,A.GOAL_TARGET_DURN ,A.GOAL_TARGET_DURN_UNIT ,DECODE(A.GOAL_TARGET_DURN_UNIT,'D',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN,'DD/MM/YYYY HH24:MI'),'H',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN/24 , 'DD/MM/YYYY HH24:MI'),'M',TO_CHAR(SYSDATE+(A.GOAL_TARGET_DURN/(24*60)),'DD/MM/YYYY HH24:MI'),'L',TO_CHAR(ADD_MONTHS(SYSDATE,A.GOAL_TARGET_DURN) , 'DD/MM/YYYY HH24:MI'),'W',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN*7 , 'DD/MM/YYYY HH24:MI'),'')GOAL_TARGET_DATE,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')GOAL_START_DATE, E.CURR_PRIORITY  FROM CP_LIBRARY_GOAL A ,MR_TERM_SET  B ,MR_TERM_CODE C ,CP_OUTCOME_LANG_VW D,PR_DIAGNOSIS E  WHERE    A.LIBRARY_ID = ? AND A.VERSION_NO = ? AND A.TERM_SET_ID  = ? AND A.TERM_CODE  = ? AND  B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE=A.TERM_CODE AND D.OUTCOME_CODE=A.GOAL_CODE AND E.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_CODE=A.TERM_CODE AND E.PATIENT_ID = ? AND E.CURR_STATUS = 'A' AND D.LANGUAGE_ID = ? ORDER BY E.CURR_PRIORITY,3 ";//60772

// start 60772
sql ="SELECT A.TERM_SET_ID ,B.TERM_SET_DESC ,A.TERM_CODE ,C.SHORT_DESC TERM_CODE_SHORT_DESC ,A.GOAL_CODE ,D.SHORT_DESC GOAL_SHORT_DESC ,A.GOAL_TARGET_DURN ,A.GOAL_TARGET_DURN_UNIT ,DECODE(A.GOAL_TARGET_DURN_UNIT,'D',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN,'DD/MM/YYYY HH24:MI'),'H',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN/24 , 'DD/MM/YYYY HH24:MI'),'M',TO_CHAR(SYSDATE+(A.GOAL_TARGET_DURN/(24*60)),'DD/MM/YYYY HH24:MI'),'L',TO_CHAR(ADD_MONTHS(SYSDATE,A.GOAL_TARGET_DURN) , 'DD/MM/YYYY HH24:MI'),'W',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN*7 , 'DD/MM/YYYY HH24:MI'),'')GOAL_TARGET_DATE,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')GOAL_START_DATE, E.CURR_PRIORITY  FROM CP_LIBRARY_GOAL A ,MR_TERM_SET  B ,MR_TERM_CODE C ,CP_OUTCOME_LANG_VW D,PR_DIAGNOSIS E  WHERE    A.LIBRARY_ID = ? AND A.VERSION_NO = ? AND A.TERM_SET_ID  = ? AND A.TERM_CODE  = ? AND  B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE=A.TERM_CODE AND D.OUTCOME_CODE=A.GOAL_CODE AND E.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_CODE=A.TERM_CODE AND E.PATIENT_ID = ? AND E.CURR_STATUS = 'A' AND D.LANGUAGE_ID = ? AND e.onset_encounter_id IN (";

	   for (int j = 0; j < encounterIds.length;j++)
	    {
		sql += "?, ";
		}
		sql = sql.substring(0, sql.length() - 2);
		sql += ") ORDER BY E.CURR_PRIORITY, 3";

		// end 60772	
		
//sql1 = "SELECT A.INTERVENTION_CODE ,B.SHORT_DESC INTERVENTION_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_INTERVENTION A ,  CA_INTERVENTION B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     =? AND A.TERM_SET_ID    =? AND A.TERM_CODE      =?  AND A.GOAL_CODE     = ? AND B.INTERVENTION_CODE= A.INTERVENTION_CODE AND A.GROUP_ID = ?" ;
  sql1 = "SELECT A.INTERVENTION_CODE ,B.SHORT_DESC INTERVENTION_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_INTERVENTION A ,  CA_INTERVENTION_LANG_VW B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     =? AND A.TERM_SET_ID    =? AND A.TERM_CODE      =?  AND A.GOAL_CODE     = ? AND B.INTERVENTION_CODE= A.INTERVENTION_CODE AND A.GROUP_ID = ? AND B.LANGUAGE_ID = ?" ;

//sql2="SELECT A.OUTCOME_CODE ,B.SHORT_DESC OUTCOME_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_OUTCOME A , CP_OUTCOME B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     = ? AND A.TERM_SET_ID    = ? AND A.TERM_CODE       = ? AND A.GOAL_CODE      = ?  AND B.OUTCOME_CODE= A.OUTCOME_CODE AND A.GROUP_ID = ?  " ;
sql2="SELECT A.OUTCOME_CODE ,B.SHORT_DESC OUTCOME_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_OUTCOME A , CP_OUTCOME_LANG_VW B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     = ? AND A.TERM_SET_ID    = ? AND A.TERM_CODE       = ? AND A.GOAL_CODE      = ?  AND B.OUTCOME_CODE= A.OUTCOME_CODE AND A.GROUP_ID = ? AND B.LANGUAGE_ID = ?  " ;

sql3 = "SELECT DISTINCT GROUP_ID FROM CP_LIBRARY_INTERVENTION A WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     = ? AND A.TERM_SET_ID    = ? AND A.TERM_CODE       = ? AND A.GOAL_CODE      = ? ";

StringBuffer goal_stmt		=	new StringBuffer();
String goal_st				=	"";
int i						=	0;
boolean goal_chk			=	false;
//boolean rep_flag			=	false;

if(!value_str.equals(""))
{
	String Library_id		=	"";
	int version_no			=	0;
	int i1					=   0;
	int	i2					=	0;
	String term_set_id		=	"";
	String term_code		=	"";
	String tmp_term_code	=	"";
	String tmp_term_code1	=	"";
	String goal_code		=	"";
	String checked			=	"checked";
	String checked1			=	"checked";
	String checked2			=	"checked";
	String values			=	"";
	String intervention_code=	"";
	String temp_code		=	"";
	String temp_intercode	=	"";
	String temp_outcode		=	"";
	String out_code			=	"";
	String selected_intvn	=	"";
	String tmp_target_date	=	"";
	String selected_intvn_value="";
	String temp_chk			=	"";
	String temp_inter_code	=	"";
	String tmp_hashval		=	"";
	String ex_selected_intvn=	"";
	String ex_selected_intvn_value= "";
	String patient_class	=	"";
	String target_date		=	"";
	String selected_dates	=	"";
/***********/
	String dstart_dt		=	"";
	String dtar_prd			=	"";
	String dtarget_dt		=	"";
	String gtarget_dt		=	"";
	String record4[]		=	null;
	String temp_prior		=	"";
/************/
	patient_class			=	bean.getPatientClass();
	HashMap select_intvn	=	null;
	HashMap selected_dts	=	null;
	String tmp_key			=	"";
	HashMap select_intvn1	=	new HashMap();
	HashMap select_intvn2	=	new HashMap();
	select_intvn			=	bean.getSelectedIntvn();
	selected_dts			=	bean.getDateValues();	
	int	ii					=	0;
	int gcnt				=	0;
	int incnt				=	0;
	int outcnt				=	0;
	//tmp_target_date = dateString;
	String record_termcd[]	=	null;
	StringTokenizer stk		=	new StringTokenizer(value_str,"~");
	//int cnt = stk.countTokens();
	while(stk.hasMoreTokens())
	{
		values					=	stk.nextToken();
		StringTokenizer stk1	=	new StringTokenizer(values,",");
		while(stk1.hasMoreTokens())
		{
			Library_id			=	stk1.nextToken();
			if(stk1.hasMoreTokens())
				version_no			=	Integer.parseInt(stk1.nextToken());
			if(sel_lib_ids.equals(""))
				sel_lib_ids="~"+Library_id+version_no+"~";
			else
				sel_lib_ids=sel_lib_ids+",~"+Library_id+version_no+"~";
			if(stk1.hasMoreTokens())
				term_set_id			=	stk1.nextToken();
			if(stk1.hasMoreTokens())
				term_code			=	stk1.nextToken();			
			StringTokenizer s_tk=	new StringTokenizer(term_code,"|");
			int cnt				=	s_tk.countTokens();
			record_termcd		=	new String[cnt];cnt=0;
			while(s_tk.hasMoreTokens())
			{
				record_termcd[cnt] = s_tk.nextToken();	
				cnt++;
			}
			/*term_code = replaceString(term_code,"|","','");
			int ind= term_code.lastIndexOf(",");
			term_code = term_code.substring(0,ind);
			term_code = "'"+term_code;
			//term_code = term_code.replace('|',',');*/
			
			ps = con.prepareStatement(sql);
			ps.setString(1,Library_id);
			ps.setInt(2, version_no);
			ps.setString(3, term_set_id);
			ps.setString(6, locale);
			// start 60772
		    for (int j = 0; j < encounterIds.length; j++) {
		        ps.setString(7 + j, encounterIds[j]);
		    }
		    // end 60772
		    
			ps1 = con.prepareStatement(sql1);
			ps2 = con.prepareStatement(sql2);
			ps3 = con.prepareStatement(sql3);

			for(int tmp=0;tmp<record_termcd.length;tmp++)
			{
				term_code= record_termcd[tmp];
				ps.setString(4, term_code);
				ps.setString(5, patient_id);
				//out.println("<script>alert('Library_id::"+Library_id+"-version_no::"+version_no+"-term_set_id-"+term_set_id+"--term_code--"+term_code+"-patient_id---"+patient_id+"---')</script>");
				try
				{
				rs = ps.executeQuery();
				}
				catch(Exception e)
				{
				 //out.println("sql    error here---------"+e.toString());//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
				}

				while(rs.next())
				{
					intervention_code	=	"";
					out_code			=	"";
					//selected_intvn="";selected_intvn_value="";
					tmp_term_code		=	rs.getString(3);
					goal_code			=	rs.getString(5);
					//Set s=select_intvn.keySet();
					//Collection ccc = select_intvn.values();
					//	out.println("<script>alert('s::--"+s+"--ccc::"+ccc+"-')</script>");
					tmp_key				=	Library_id+","+version_no+","+term_set_id+","+term_code;					
					temp_inter_code		=	tmp_key+","+goal_code+",";
					temp_code			=	(String)select_intvn.get(temp_inter_code)== null?"":(String)select_intvn.get(temp_inter_code);
					//out.println("<script>alert('temp_code::"+temp_code+"-')</script>");	
					//out.println("<script>alert('temp_code::"+temp_code+"-ii-"+ii+"-i"+i+"-checked:-"+checked+"-')</script>");			
					if(select_intvn.containsKey(temp_inter_code))
					{
						//out.println("<script>alert('key exists-')</script>");
						chk_flag		=	true;
						tmp_hashval		=	(String)select_intvn.get(temp_inter_code);
						//out.println("<script>alert('tmp_hashval---"+tmp_hashval+"---')</script>");
						if(tmp_hashval!= null)
							goal_chk = false;	
						else
							goal_chk = true;

					}
					else
					{
						chk_flag = false;
						//out.println("<script>alert('key donot exists-')</script>");
					}
					//out.println("<script>alert('key goal_chk-"+goal_chk+"--')</script>");	
					if(chk_flag == false || goal_chk == false)
						checked = "checked";
					else
						checked = "";
					StringTokenizer stk2=	new StringTokenizer(temp_code,",");
					tmp_target_date		=	"";
					while(stk2.hasMoreTokens())
					{
						tmp_target_date		= com.ehis.util.DateUtils.convertDate(stk2.nextToken(),"DMYHM","en",locale);
						if(stk2.hasMoreTokens())
							temp_intercode		= stk2.nextToken();
						if(stk2.hasMoreTokens())
							temp_outcode		= stk2.nextToken();
						temp_outcode		= temp_outcode.substring(0,temp_outcode.length()-1);
						//out.println("<script>alert('temp_chk::"+tmp_target_date+"--')</script>");
					}
					StringTokenizer stk3	= new StringTokenizer(temp_intercode,"|");
					int cnt1				= stk3.countTokens();int j =0;
					//out.println("<script>alert('cnt::"+cnt1+"')</script>");
					String record1[]		= null ;
					record1					= new String[cnt1] ;
					while(stk3.hasMoreTokens())
					{
						record1[j]			= stk3.nextToken();
						record1[j]			= record1[j].substring(0,(record1[j].indexOf("*")));
						//out.println("<script>alert('record1::"+record1[j]+"-')</script>");
						j++;
					}	
					StringTokenizer stk4	= new StringTokenizer(temp_outcode,"|");
					int cnt2				= stk4.countTokens();
					int j1					= 0;
					//out.println("<script>alert('cnt::"+cnt1+"')</script>");
					String record2[]		= null;
					record2					= new String[cnt2];
					while(stk4.hasMoreTokens())
					{
						record2[j1]			= stk4.nextToken();
						record2[j1]			= record2[j1].substring(0,(record2[j1].indexOf("*")));
						j1++;
					}	
					//out.println("<script>alert('length::"+record2.length+"-')</script>");
						//out.println("<script>alert('goal_code::"+goal_code+"')</script>");	
					String record3[]		= null ;
					
					if(!tmp_term_code1.equals(tmp_term_code))
					{

						selected_dates		= (String)selected_dts.get(tmp_key);
					//out.println("<script>alert('s::--"+selected_dates+"---')</script>");
						if(selected_dates != null)
						{
							stk3			=	new StringTokenizer(selected_dates,",");
							int cnt3		=	stk3.countTokens();
							int k			=	0;
						//out.println("<script>alert('cnt::"+cnt3+"')</script>");
						
							record3			=	new String[cnt3] ;
							while(stk3.hasMoreTokens())
							{
								record3[k]	=	stk3.nextToken();
								//out.println("<script>alert('record3::"+record3[k]+"-')</script>");
								k++;
							}											
							dstart_dt	= com.ehis.util.DateUtils.convertDate(record3[0],"DMYHM","en",locale);
							dtar_prd	= record3[1];
							dtarget_dt	= com.ehis.util.DateUtils.convertDate(record3[2],"DMYHM","en",locale) ;

							stk3		= new StringTokenizer(record3[3],"$");
							cnt3		= stk3.countTokens();k =0;
							//out.println("<script>alert('cnt::"+cnt3+"')</script>");
						
							record4		= new String[cnt3] ;
							while(stk3.hasMoreTokens())
							{
								record4[k]= stk3.nextToken();
								//out.println("<script>alert('record3::"+record4[k]+"-')</script>");
								k++;
							}	
						}
						else
						{
							dstart_dt	= "";
							dtar_prd	= "";
							dtarget_dt	= "";
						}
						temp_prior		= rs.getString(11)==null?"":rs.getString(11);
						if(temp_prior.equals("C"))
						{
							classValue	= "PRIORCRIC";
							
						}
						else if(temp_prior.equals("H"))
						{
							classValue	= "PRIORHIGH";
							
						}
						else if(temp_prior.equals("N"))
						{
							classValue	= "PRIORNORM";
							
						}
						else if(temp_prior == "" )
						{
							classValue	= "";
							
						}
						//out.println("<script>alert('dtar_prd::"+dtar_prd+"-')</script>");	
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(3)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Library_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dstart_dt==""?(rs.getString(10)==null?dateString:com.ehis.util.DateUtils.convertDate(rs.getString(10),"DMYHM","en",locale)):dstart_dt));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dtar_prd==""?rs.getString(7):dtar_prd));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dtarget_dt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
	
						tmp_term_code1= tmp_term_code;
						if(!(dgroup_cnt ==0 && dgroup_count ==0))
						{	
							//out.println("<script>alert('dgroup_cnt::"+dgroup_cnt+"--i-"+i+"- dgroup_count-"+dgroup_count+"-')</script>");
				
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dgroup_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dgroup_count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dgroup_cnt));
            _bw.write(_wl_block41Bytes, _wl_block41);

						}
						dgroup_count=	i;
						//dgroup_count++;					
						dgroup_cnt	=	0;
					
					}
					tmp_st_date=com.ehis.util.DateUtils.convertDate(rs.getString(10),"DMYHM","en",locale);
					target_date=(rs.getString(9)==null?dateString:com.ehis.util.DateUtils.convertDate(rs.getString(9),"DMYHM","en",locale));
					tmp_target_date=(tmp_target_date==""?target_date:tmp_target_date);
					//out.println("<script>alert('dgroup_cnt::"+dgroup_cnt+"--i-"+i+"- dgroup_count-"+dgroup_count+"-')</script>");
					if(selected_dates !=null)
					{						
						gtarget_dt = com.ehis.util.DateUtils.convertDate(record4[dgroup_cnt],"DMYHM","en",locale);
						//out.println("<script>alert('gtarget_dt::"+gtarget_dt+"---')</script>");
					}
					//out.println("<script>alert('gtarget_dt::"+gtarget_dt+"--tmp_target_date-"+tmp_target_date+"---')</script>");
					
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Library_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tmp_term_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
goal_stmt.append(rs.getString(6));goal_stmt.append("\n");
							goal_st = goal_st +rs.getString(6)+" ";
							
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(rs.getString(6)));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(gtarget_dt==""?tmp_target_date:gtarget_dt));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(7)==null?"0":rs.getString(7)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(8)==null?"":rs.getString(8)));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(gtarget_dt==""?tmp_target_date:gtarget_dt));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rs.getString(3)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Library_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(gtarget_dt==""?tmp_target_date:gtarget_dt));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
i1=0;i2=0;gcnt=0;																				
									ps3.setString(1,Library_id);
									ps3.setInt(2, version_no);
									ps3.setString(3, term_set_id);
									ps3.setString(4, term_code);
									ps3.setString(5, goal_code);
									//out.println("<script>alert('Library_id::"+Library_id+"-version_no::"+version_no+"-term_set_id-"+term_set_id+"--term_code--"+term_code+"-goal_code---"+goal_code+"---')</script>");
									try
									{
										rs3 = ps3.executeQuery();
									}
									catch(Exception e)
									{
										//out.println("sql  111111  error here---------"+e.toString());//common-icn-0181
								               e.printStackTrace();//COMMON-ICN-0181
									}
									while(rs3.next())
									{	
										group_id = rs3.getInt(1);									
										//out.println("<script>alert('group_id::"+i+"--')</script>");
										if ( gcnt % 2 == 0 )
											classValue = "GRPEVEN" ;
										else
											classValue = "GRPOD" ;
									
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block77Bytes, _wl_block77);

									
											ps1.setString(1,Library_id);
											ps1.setInt(2, version_no);
											ps1.setString(3, term_set_id);
											ps1.setString(4, term_code);
											ps1.setString(5, goal_code);
											ps1.setInt(6, group_id);
											ps1.setString(7, locale);
											//out.println("<script>alert('Library_id::"+Library_id+"-version_no::"+version_no+"-term_set_id-"+term_set_id+"--term_code--"+term_code+"-goal_code---"+goal_code+"-group_id--"+group_id+"--')</script>");
											try
											{
												rs1 = ps1.executeQuery();}catch(Exception e){
												out.println("sql  3333333  error here---------"+e.toString());
											}
											incnt=0;
											//i1=0;
											temp_chk = "";	
											//out.println("<script>alert('first_time::"+first_time+"--')</script>");
											while(rs1.next())
											{
												/*if ( i1 % 2 == 0 )
													classValue = "QRYEVEN" ;
												else
													classValue = "QRYODD" ;*/
										
												if(chk_flag == false)
													checked1 = "checked";
												else
												{
													for(int c=0;c<record1.length;c++)
													{
														temp_chk = rs1.getString(1);
														if(temp_chk.equals(record1[c]))
														{
															checked1 = "checked";
															break;
														}
														else
															checked1 = "";
													}														
													if(record1.length == 0 || goal_chk == true)
															checked1 = "";
													/*if(temp_chk.equals(rs1.getString(1)) && !temp_chk.equals(""))
														checked1 = "checked";
													else
														checked1 = "";*/
												}
												//out.println("<script>alert('temp_chk::"+temp_chk+"-rs1.getString(1)--"+rs1.getString(1)+"-checked1-"+checked1+"-')</script>");						
									
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i1));
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i1));
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(checked1));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(rs1.getString(2)==null?"&nbsp;":rs1.getString(2)));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i1));
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i1));
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs1.getString(1)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i1));
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i1));
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block90Bytes, _wl_block90);
	
												i1++;incnt++;
												intervention_code =intervention_code +rs1.getString(1)+"*"+group_id+"|";	
										
											}
											//	out.println("<script>alert('"+gcnt+"-i-"+i+"-incnt-"+incnt+"-i1-"+i1+"--')</script>");
									
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(gcnt));
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(gcnt));
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(incnt));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block94Bytes, _wl_block94);

									
										ps2.setString(1,Library_id);
										ps2.setInt(2, version_no);
										ps2.setString(3, term_set_id);
										ps2.setString(4, term_code);
										ps2.setString(5, goal_code);
										ps2.setInt(6, group_id);
										ps2.setString(7, locale);
										rs2		=	ps2.executeQuery();
										outcnt	=	0;
									//	i1		=	0;
									
										temp_chk =	"";	
										while(rs2.next())
										{	

												if(chk_flag == false)
													checked2 = "checked";
												else
												{
												//	if(goal_chk == false){
													for(int c=0;c<record2.length;c++)
													{
														temp_chk = rs2.getString(1);
														if(temp_chk.equals(record2[c]))
														{
															checked2 = "checked";
															break;
														}
														else
															checked2 = "";
													}
													//}else
													//	checked2 = "";
													if(record2.length == 0 || goal_chk == true)
														checked2 = "";
												}										
												//out.println("<script>alert('temp_chk::"+temp_chk+"-rs1.getString(1)--"+rs1.getString(1)+"-checked1-"+checked1+"-')</script>");						
											
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i2));
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i2));
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i2));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(checked2));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(rs2.getString(2)==null?"&nbsp;":rs2.getString(2)));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i2));
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i2));
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs2.getString(1)));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i2));
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i2));
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
	
											i2++;outcnt++;
											out_code = out_code +rs2.getString(1)+"*"+group_id+"|";	
										 }
											
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(gcnt));
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(gcnt));
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(outcnt));
            _bw.write(_wl_block108Bytes, _wl_block108);

										gcnt++;
									}	
							
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(gcnt));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i1));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i2));
            _bw.write(_wl_block115Bytes, _wl_block115);

					i++;dgroup_cnt++;
					selected_intvn = Library_id+","+version_no+","+term_set_id+","+term_code+","+goal_code+",";
						//out.println("<script>alert('intervention_code---"+intervention_code+"---out_code--"+out_code+"--')</script>");
					if(intervention_code.equals(""))
						intervention_code = " *";
					if(out_code.equals(""))
						out_code = " *";
					selected_intvn_value = (gtarget_dt==""?tmp_target_date:gtarget_dt)+","+intervention_code+","+out_code+"~";

					if(select_intvn.containsKey(selected_intvn))
					{
							//out.println("<script>alert('key exists-')</script>");
						ex_selected_intvn=selected_intvn;
						ex_selected_intvn_value=(String)select_intvn.get(ex_selected_intvn);
				//out.println("<script>alert('ex_selected_intvn_value--"+ex_selected_intvn_value+"-ex_selected_intvn-"+ex_selected_intvn+"-')</script>");
						select_intvn2.put(ex_selected_intvn,ex_selected_intvn_value);
							
					}
					else
					{
						//rep_flag= true;
						//out.println("<script>alert('key doesnot exists-')</script>");
						select_intvn1.put(selected_intvn,selected_intvn_value);
					}
				}
			}
			//	out.println("<script>alert('dgroup_cnt::"+dgroup_cnt+"--i-"+i+"- dgroup_count-"+dgroup_count+"-')</script>");
			//out.println("<script>alert('"+bean.getSelectedIntvn()+"')</script>");			
		}
		//out.println("<script>alert('i::"+i+"')</script>");
		ii = i;
		//out.println("<script>alert('ii::"+ii+"')</script>");				
	}
	//	out.println("<script>alert(' bean.getSelectedIntvn()-----"+ bean.getSelectedIntvn()+"------')</script>");
	if(first_time != ii)
	{
		if(first_time > ii)
		{
			bean.setSelectedIntvn(select_intvn2);
		}
		else
		{
			select_intvn.putAll(select_intvn1);
			bean.setSelectedIntvn(select_intvn);
		}
		bean.setPageFirst(ii);
		//out.println("<script>alert(' bean.getSelectedIntvn()-----"+ bean.getSelectedIntvn()+"------')</script>");
		//	bean.setGoalStmt(goal_stmt.toString());
		bean.setGoalStmt(goal_st);
		//out.println("<script>alert(\"goal_stmt::escape("+bean.getGoalStmt()+")\")</script>");		
		//	out.println("<script>alert('iin the set fun')</script>");
		
	}
	
	//	if((first_time == ii || first_time < ii) && rep_flag== true){
	//	bean.setSelectedIntvn(select_intvn1);	out.println("<script>alert('first_time-"+first_time+"---ii::"+ii+"-rep_flag-"+rep_flag+"-')</script>");
	//	}

}
//if(i ==0 || value_str.equals(""))  //60772
	if((i ==0 || value_str.equals("")) && !obj.equals("summary"))  //60772
	out.println("<script>alert(getMessage('NO_RECORD_FOUND','CP'));</script>");

//dgroup_count=i;
//out.println("<script>alert('dgroup_cnt:111:"+dgroup_cnt+"--i-"+i+"- dgroup_count-"+dgroup_count+"-')</script>");
//out.println("<script>alert(\"goal_stmt::escape("+goal_stmt.toString()+")\")</script>");		

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(dgroup_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dgroup_count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(dgroup_count));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(goal_st));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(goal_stmt));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(value_str));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(tmp_st_date));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(sel_lib_ids));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block126Bytes, _wl_block126);

}
catch(Exception ee)
{
	//out.println("Exception while populating the values for summary------- "+ee.toString());//common-icn-0181
	System.out.println("Exception while populating the values for summary "+ee.toString());
	ee.printStackTrace();
}
finally
{
	try
	{
			if(rs != null) rs.close();if(rs1 != null) rs1.close();if(rs2 != null) rs2.close();
			if(rs3 != null) rs3.close();
			if(ps3 != null) ps3.close();
			if(ps1 != null) ps1.close();
			if(ps2 != null) ps2.close();
			if(ps != null) ps.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e)
	{
		out.println(e);
		System.out.println("Exception while populating the values for summary "+e.toString());
		e.printStackTrace();
	}
}

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bean.getPlanStart()));
            _bw.write(_wl_block128Bytes, _wl_block128);

		String tstdt=com.ehis.util.DateUtils.convertDate(bean.getPlanStart(),"DMYHM","en",locale);
		String teddt=com.ehis.util.DateUtils.convertDate(bean.getPlanEnd(),"DMYHM","en",locale);

            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(tstdt));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(teddt));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(bean.getPlanStart()));
            _bw.write(_wl_block132Bytes, _wl_block132);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.for.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.TargetDate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Goal.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.TargetDate.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Interventions.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.ExpectedOutcome.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
