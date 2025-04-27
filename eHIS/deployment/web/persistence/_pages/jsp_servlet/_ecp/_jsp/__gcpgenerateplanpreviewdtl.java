package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __gcpgenerateplanpreviewdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/GCPGeneratePlanPreviewDtl.jsp", 1739774596178L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- \n-----------------------------------------------------------------------\nDate       Edit History      Name        \t\tDescription\n-----------------------------------------------------------------------\n?             100            ?           \t\tcreated\n23/05/2012    IN031808       Menaka V     \t\tAll the interventions has been attached to the respective frequencies in the function\n\t\t\t\t\t\t\t\t\t\t\t\t�Frequency For Interventions� in CA . However in the Generate Care Plan function , all the frequencies are displaying double .\n-----------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</title>\n<script language=\"javascript\">\n\nvar headTop = -1;\nvar FloatHead1;\n\nfunction processScroll()\n{\nif (headTop < 0)\n{\n saveHeadPos();\n}\nif (headTop>0)\n{\nif (document.documentElement && document.documentElement.scrollTop)\ntheTop = document.documentElement.scrollTop;\nelse if (document.body)\ntheTop = document.body.scrollTop;\n\nif (theTop>headTop)\nFloatHead1.style.top = (theTop-headTop) + \'px\';\nelse\nFloatHead1.style.top = \'0px\';\n}\n}\n\nfunction saveHeadPos()\n{\nparTable = document.getElementById(\"headStart\");\nif (parTable != null)\n{\nheadTop = parTable.offsetTop + 3;\nFloatHead1 = document.getElementById(\"head1\");\nFloatHead1.style.position = \"relative\";\n}\n}\nwindow.onscroll = processScroll;\n</script>\n<head>\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script language=\"Javascript\" src=\"../../eCP/js/GCPGeneratePlanMenu.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<Script language =\"JavaScript\" src =\"../../eCommon/js/common.js\"></Script>\n<Script language =\"JavaScript\" src =\"../../eCommon/js/ValidateControl.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eCP/js/GCPGenerateCarePlan.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n</head>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<script language=\'javascript\'>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\"gen_preview_details\" id=\"gen_preview_details\"  method =\'post\' target=\'messageFrame\' action=\'../../servlet/eCP.GCPGeneratePlanServlet\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<input type =\'hidden\' name=\'outcome_code";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' id=\'outcome_code";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\t\n\t\t\t\t<input type =\'hidden\' name=\'out_group_id";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'out_group_id";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\t\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<input type =\'hidden\' name=\'intervent_code";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'intervent_code";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\t<input type =\'hidden\' name=\'int_group_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'int_group_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<input type =\'hidden\' name=\'library_id";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'library_id";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\t\n\t\t\t<input type =\'hidden\' name=\'version_no";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'version_no";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t<input type =\'hidden\' name=\'term_set_id";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'term_set_id";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type =\'hidden\' name=\'term_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'term_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type =\'hidden\' name=\'goal_code";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'goal_code";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type =\'hidden\' name=\'target_date";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'target_date";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t<input type =\'hidden\' name=\'out_cnt";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'out_cnt";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\t\n\t\t\t<input type =\'hidden\' name=\'intv_cnt";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'intv_cnt";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t<input type =\'hidden\' name=\'tcode_cnt\' id=\'tcode_cnt\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t<div id=\"headStart\" style=\"position: absolute;\">\t\n\t<table border=\'0\' cellspacing=\'0\' cellpadding=\'3\' width=\'132%\' height=\'\' align=\'center\' id=\"partTable\">\n\t<tr id=\"head1\">\n\t\t\t\n\t\t\t<th height=\'1%\' width=\'3%\' class=\'PLANSUBHEAD1\'><font size=\"1\" color=\"\">&nbsp;</font></th>\n\t\t\t<th height=\'1%\' width=\'21%\' class=\'PLANSUBHEAD1\'><font size=\"1\" color=\"\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</font></th> \n\t\t\t<th height=\'1%\' width=\'15%\' class=\'PLANSUBHEAD1\'><font size=\"1\" color=\"\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font></th>\n\t\t\t<th height=\'1%\' width=\'7%\' class=\'PLANSUBHEAD1\'><font size=\"1\" color=\"\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</font></th>\n\t\t\t<th height=\'1%\' width=\'14%\' class=\'PLANSUBHEAD1\'><font size=\"1\" color=\"\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</font></th>\n\t\t\t<th height=\'1%\' width=\'15%\' class=\'PLANSUBHEAD1\'><font size=\"1\" color=\"\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</font></th>\n\t\t\t<th height=\'1%\' width=\'10%\' class=\'PLANSUBHEAD1\'><font size=\"1\" color=\"\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</font></th> \n\t\t\t<th height=\'1%\' width=\'8%\' class=\'PLANSUBHEAD1\'><font size=\"1\" color=\"\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</font></th>\n\t\t\t<th height=\'1%\' width=\'11%\' class=\'PLANSUBHEAD1\'><font size=\"1\" color=\"\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</font></th>\n\t</tr>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t<tr>\n\t\t<td class=\'GRPEVEN1\' height=\'1%\' width = \'\' colspan=\'10\'>\n\t\t<font size=\"1\"><B>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</B></font></td>\n    </tr>\n\t\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\n\t<tr>\n\t\t<td class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' height=\'1%\' width = \'\' align=\'center\'><FONT SIZE=\"3\" class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' >&nbsp;&nbsp;</FONT></td>\t\n\t\t<td class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' height=\'1%\' width = \'\' colspan=\'\'><font size=\"1\"  color=\"\"> <B> ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</B></font></td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' height=\'1%\' width = \'\' align=\'center\' ><font size=\"1\" color=\"\">\n\t\t\t<input type=\"text\" name=\"st_date";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"st_date";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'  size=\'15\' onBlur=\'checkValidDateTime(this);chkDate(this,";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =");calculateEndDt(\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\",true,\"dur_type\");\'\' style=\'font-size:7pt\'>\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\'return showCalendar(\"st_date";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\",null,\"hh:mm\",true);\'  onBlur=\'retFocus(\"st_date\",\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\")\' ></font></td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' height=\'1%\' width = \'\' align=\'left\'><font size=\"1\" color=\"\">\n\t\t<select name=\"freq_select";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"freq_select";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" onChange=\'chkDuration(";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =",true);\' style=\'font-size:7pt;\'>\n\t\t\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' style=\'background-color:#FFA8A8;color:";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</option>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' style=\'color:#990000\' ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<BR><label id=\'other_freq";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' class=\'label\' style=\'font-size:7pt\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</label>\n\t\t</font></td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' height=\'1%\' width = \'\' align=\'center\' class=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'chk_durn";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t\t<input type=\"text\" name=\"durn_value";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"durn_value";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' size=\'1\'  maxlength=\'2\' onBlur=\'CheckNum(this);calculateEndDt(\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\",true,\"dur_type\");\' style=\'font-size:7pt\' ><font size=\"1\" >\n\t\t\t<label class=\'label\' id=\'durn";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' style=\'font-size:7pt\'><!-- ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" -->\n\t\t\t</label></font>\n\t\t\t<select name=\"dur_type";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"dur_type";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" onChange=\'calculateEndDt(\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\",true,\"dur_type\")\' style=\'font-size:7pt\'>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t<option value=\"M\" style=\"color:";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t<option value=\"H\" style=\"color:";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t<option value=\"D\" style=\"color:";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</option>\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t<option value=\"W\" style=\"color:";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t<option value=\"L\" style=\"color:";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</option>\n\t\t\t\t\t\t<option value=\"H\" style=\"color:";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" </option>\n\t\t\t\t\t\t<option value=\"D\" style=\"color:";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" </option>\n\t\t\t\t\t\t<option value=\"W\" style=\"color:";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" </option>\n\t\t\t\t\t\t<option value=\"L\" style=\"color:";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t</select>\n\t\t</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' height=\'1%\' width = \'\' align=\'center\'><font size=\"1\">\n\t\t\t<input type=\"text\" name=\"end_date";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"end_date";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'  size=\'15\' onBlur=\'checkValidDateTime(this);checkGRDate(st_date";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =",this);chkEndDate(\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\")\' style=\'font-size:7pt\'>\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\'return showCalendar(\"end_date";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\",null,\"hh:mm\",true);\'  onBlur=\'retFocus(\"end_date\",\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\")\'></font>\n\t\t</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' height=\'1%\' width = \'\' align=\'left\' colspan=\'\'><font size=\"1\"> <!-- <B>Stage:</B></font>&nbsp; -->\n\t\t\t<select name=\"intvn_stage";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" id=\"intvn_stage";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" style=\'font-size:7pt\'>\n\t\t\t<option value=\"*A\" ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" >--- ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" ---</option>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' style=\"color:";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</option>\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t</select></td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' height=\'1%\' width = \'\' colspan=\'\' align=\'center\'><font size=\"1\" >\n\t\t\t<select name=\"prior";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" id=\"prior";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" style=\'font-size:7pt\'>\n\t\t\t\t<option value=\"N\" style=\"color:";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="  </option>\n\t\t\t\t<option value=\"H\" style=\"color:";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="    </option>\n\t\t\t\t<option value=\"C\" style=\"color:";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</option>\n\t\t\t</select>\n\t\t</td> \n\t\t\n\t\t<td class=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' height=\'1%\' width = \'\' align=\'left\'>\n\t\t\t<select name=\"postn";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"postn";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" style=\'font-size:7pt\'>\n\t\t\t<option value=\" \">---";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="---</option>\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</option>\n\t\t\t   \t\t\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t</select>\n\t\t</td>\n\t</tr>\t\n\t\n\t<input type =\'hidden\' name=\'temp_inter_val";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' id=\'temp_inter_val";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'> \n\t<input type =\'hidden\' name=\'inter_code";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' id=\'inter_code";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n\t<input type =\'hidden\' name=\'intervention_type";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' id=\'intervention_type";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\t<input type =\'hidden\' name=\'freq_code";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' id=\'freq_code";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n\t<input type =\'hidden\' name=\'duration";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' id=\'duration";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t<input type =\'hidden\' name=\'durn_type";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' id=\'durn_type";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n\t<input type =\'hidden\' name=\'start_date";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' id=\'start_date";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n\t<input type =\'hidden\' name=\'rel_start_prd";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' id=\'rel_start_prd";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t<input type =\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n\t<input type =\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\t\n\t<input type =\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'>\n\t<input type =\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n\t<input type =\'hidden\' name=\'goal_stmt\' id=\'goal_stmt\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n\t<input type =\'hidden\' name=\'care_plan_start_date\' id=\'care_plan_start_date\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n\t<input type =\'hidden\' name=\'care_plan_end_date\' id=\'care_plan_end_date\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t<input type =\'hidden\' name=\'target_date\' id=\'target_date\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t<input type =\'hidden\' name=\'selected_diagnosis\' id=\'selected_diagnosis\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n\t<input type =\'hidden\' name=\'curr_care_manager\' id=\'curr_care_manager\' value=\'\'>\t\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t<input type =\'hidden\' name=\'finalStr\' id=\'finalStr\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\t<input type =\'hidden\' name=\'freq_sql\' id=\'freq_sql\' value=\"select freq_code code,freq_desc description,repeat_durn_type from am_frequency where eff_status = \'E\' and upper(freq_code) like upper(?) and upper(freq_desc) like  upper(?)\">\n</table>\t\n</div>\n\n";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n<script>\n//to set the default value to the duration type list\nvar i = parseInt(document.gen_preview_details.count.value);\nvar plan_start_dt =parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value\nfor(var tmp=0;tmp<i;tmp++){\n\tvar tmp_value=\"\";\n\tvar freq_durn_value=\"\";var freq_durn_unit=\"\";var st_date =\"\";\n\tvar durnUnit;\n\tif(eval(\"document.gen_preview_details.st_date\"+tmp)!= undefined)\n\t\tst_date = eval(\"document.gen_preview_details.st_date\"+tmp).value;\n\tst_date = plan_start_dt ;\n\tif(eval(\"document.gen_preview_details.rel_start_prd\"+tmp)!= undefined)\n\t\tvar rel_start_prd = eval(\"document.gen_preview_details.rel_start_prd\"+tmp).value;\n\tvar fromarray;\n\tvar fromDt;\n\tvar timarray;\n\tvar finalDt=\"\";\n\tif(st_date.length > 0)\n\t{\n\t\tfromDt = st_date.split(\" \");\n\t\tfromarray = fromDt[0].split(\"/\");\n\t\t\t\t\n\t\ttimarray = fromDt[1].split(\":\");\n\t\tvar dt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);\n\t\tdt.setHours(timarray[0], timarray[1]);\n\t\ttimarray[1]=dt.getMinutes()+parseInt(rel_start_prd);\n\t\tdt.setHours(timarray[0], timarray[1]);\n\t\tvar date= \"\"+dt.getDate()+\"\";\n\t\tvar month= \"\"+parseInt(dt.getMonth()+1)+\"\";\n\t\tvar hours= \"\"+dt.getHours()+\"\";\n\t\tvar minutes= \"\"+dt.getMinutes()+\"\";\n\t\tif(date.length == 1)\n\t\t\tdate=\"0\"+date;\n\t\tif(month.length == 1)\n\t\t\tmonth=\"0\"+month;\n\t\tif(hours.length == 1)\n\t\t\thours=\"0\"+hours;\n\t\tif(minutes.length == 1)\n\t\t\tminutes=\"0\"+minutes;\n\t\tfinalDt = finalDt +date + \"/\";\n\t\tfinalDt = finalDt +month + \"/\";\n\t\tfinalDt = finalDt +dt.getFullYear() + \" \";\n\t\tfinalDt = finalDt +hours + \":\";\n\t\tfinalDt = finalDt +minutes ;\n\t\tif(eval(\"document.gen_preview_details.st_date\"+tmp)!= undefined)\n\t\t\teval(\"document.gen_preview_details.st_date\"+tmp).value = finalDt;\n\t}\n\tif(eval(\"document.gen_preview_details.temp_inter_val\"+tmp)!= undefined)\n\t{\n\t\tif(eval(\"document.gen_preview_details.temp_inter_val\"+tmp).value == \"null\")\n\t\t{\n\t\t\tif(eval(\"document.gen_preview_details.freq_select\"+tmp)!= undefined)\n\t\t\t\tvar tmp_value=eval(\"document.gen_preview_details.freq_select\"+tmp).options[0].value;\n\t\t\tdurnUnit = tmp_value.split(\",\");\n\t\t\tif(durnUnit.length>0){\n\t\t\t\tif(eval(\"document.gen_preview_details.durn_value\"+tmp)!= undefined)\n\t\t\t\t\teval(\"document.gen_preview_details.durn_value\"+tmp).value =durnUnit[1];\n\t\t\t\tfreq_durn_unit = durnUnit[2];\n\t\t\t\tif(eval(\"document.gen_preview_details.dur_type\"+tmp)!= undefined)\n\t\t\t\t{\n\t\t\t\t\tvar freq_unit_length=eval(\"document.gen_preview_details.dur_type\"+tmp).length;\n\t\t\t\t\tfor(i1=0;i1<freq_unit_length;i1++){\n\t\t\t\t\t\tvar val=eval(\"document.gen_preview_details.dur_type\"+tmp).options[i1].value;\n\t\t\t\t\t\tif(freq_durn_unit == val){\n\t\t\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[0].selected = true ;\n\t\t\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[0].style.color = \"#990000\" ;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t/*\tif(freq_durn_unit == \'M\'){\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[0].selected = true ;\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[0].style.color = \"#990000\" ;\n\t\t\t\t}else if(freq_durn_unit == \'H\'){\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[1].selected = true ;\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[1].style.color = \"#990000\" ;\n\t\t\t\t}else if(freq_durn_unit == \'D\'){\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[2].selected = true ;\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[2].style.color = \"#990000\" ;\n\t\t\t\t}else if(freq_durn_unit == \'W\'){\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[3].selected = true ;\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[3].style.color = \"#990000\" ;\n\t\t\t\t}else if(freq_durn_unit == \'L\'){\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[4].selected = true ;\n\t\t\t\t\teval(\"document.gen_preview_details.dur_type\"+tmp).options[4].style.color = \"#990000\" ;\n\t\t\t\t}else if(freq_durn_unit == \"null\" || freq_durn_unit == \'\' ){\n\t\t\t\t}*/\n\t\t\t\t//eval(\"document.gen_preview_details.freq_select\"+tmp).options[1].selected = true ;\n\t\t\t\t//eval(\"document.gen_preview_details.freq_select\"+tmp).options[1].style.color = \"#FFFFFF\" ;\n\t\t\t\t//eval(\"document.gen_preview_details.freq_select\"+tmp).options[1].style.backgroundColor = \"#FFA8A8\" ;\n\t\t\t\tif(eval(\"document.gen_preview_details.freq_code\"+tmp)!= undefined)\n\t\t\t\t\teval(\"document.gen_preview_details.freq_code\"+tmp).value = durnUnit[0];\n\t\t\t}\n\t\t}\n\t}\ncalculateEndDt(tmp,\'true\',\'dur_type\');\nchkStage(\"gen_preview_details\");\n\t\n}\n</script>\n\n";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

	String select(String str1, String str2){
			if(str1.trim().equalsIgnoreCase(str2.trim()))
			return "selected";
			else
			return "";
	}
	String select_color(String str1, String str2,String color){
			if(str1.trim().equalsIgnoreCase(str2.trim()))
				return color;
			else
				return "";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);

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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            eCP.GCPGeneratePlanBean GCPGenerateBean= null;synchronized(session){
                GCPGenerateBean=(eCP.GCPGeneratePlanBean)pageContext.getAttribute("GCPGenerateBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(GCPGenerateBean==null){
                    GCPGenerateBean=new eCP.GCPGeneratePlanBean();
                    pageContext.setAttribute("GCPGenerateBean",GCPGenerateBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

String mode			 = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
mode = "insert";
String patient_id	 = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String encounter_id	 = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");	
String goal_stmt	 = request.getParameter("goal_st")==null?"":request.getParameter("goal_st");
String selected_diagnosis = request.getParameter("selected_diag")==null?"":request.getParameter("selected_diag");
eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
java.util.Date date_time	 	= new java.util.Date();
String dateString 				= com.ehis.util.DateUtils.convertDate(dtSystemFormat.format(date_time),"DMYHM","en",locale);
boolean lib_flag=false;

StringBuffer sql		= new StringBuffer() ;
StringBuffer sql_select = new StringBuffer() ;
//StringBuffer sqlFrequency = new StringBuffer() ;

String sql_stage="",sql_posn="";
String classValue ="";
String intrvn_code_set="";
String interven_code="",tmp_interven_code="",group_id="";
String library_id="",term_set_id="",term_code="",goal_code="",intervention_code="",outcome_code="",target_date="";
String place_holder_val="";
String tmp_sel_diag ="",tmp_sel_diag1="";
String dayslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
String monthslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Months.label","cp_labels");
String minuteslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minutes.label","common_labels");
String weekslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Weeks.label","cp_labels");
String hourslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
int version_no=0;
Connection con = null;
PreparedStatement ps = null,ps1 = null,pstmt = null,ps2=null;
ResultSet rs = null,rs1 = null,rs2 = null,rs3=null;
int i=0;
if(patient_id.equals("")){
	patient_id = bean.getPatientId();
}
goal_stmt = bean.getGoalStmt();
	
if(selected_diagnosis.equals("")){
	HashMap codeKeyValue = new HashMap();
	codeKeyValue =  bean.getSelectedIntvn();
	Set s=codeKeyValue.keySet();
	Object[] record =  s.toArray();
	ArrayList keyList=new ArrayList();
	for(int k=0;k<record.length;k++)
		keyList.add(record[k].toString());
	String record1= "";
	for(int c=0;c<keyList.size();c++){
		record1 = (String)keyList.get(c);
	if(record1.indexOf("#")==-1){
		tmp_sel_diag = (String)codeKeyValue.get(record1);
		if(keyList.contains("#"+record1)){
			tmp_sel_diag1 = (String)codeKeyValue.get("#"+record1);
			if(tmp_sel_diag1!= null){
				tmp_sel_diag1=tmp_sel_diag1.substring(0,tmp_sel_diag1.indexOf("~"));
				tmp_sel_diag = tmp_sel_diag.substring(0,tmp_sel_diag.indexOf("|,")+1)+tmp_sel_diag1+tmp_sel_diag.substring(tmp_sel_diag.indexOf("|,")+1);
			}
		}
		if(tmp_sel_diag!= null)
			selected_diagnosis =selected_diagnosis +  record1+tmp_sel_diag;                
	}
	}
}

            _bw.write(_wl_block12Bytes, _wl_block12);

try{
	if(!selected_diagnosis.equals("")){
		
		String values="";int tcnt=0,outcnt=0,intvcnt=0;
		StringTokenizer stk= new StringTokenizer(selected_diagnosis,"~");
		//int cnt = stk.countTokens();
		while(stk.hasMoreTokens()){
			values= stk.nextToken();
			StringTokenizer stk1= new StringTokenizer(values,",");
			while(stk1.hasMoreTokens()){
				library_id=stk1.nextToken();
				if(stk1.hasMoreTokens())
					version_no=Integer.parseInt(stk1.nextToken());
				if(stk1.hasMoreTokens())
					term_set_id=stk1.nextToken();
				if(stk1.hasMoreTokens())
					term_code=stk1.nextToken();
				if(stk1.hasMoreTokens())
					goal_code=stk1.nextToken();
				if(stk1.hasMoreTokens())
					target_date=stk1.nextToken();
				if(stk1.hasMoreTokens())
					intervention_code=stk1.nextToken();
				if(stk1.hasMoreTokens())
					outcome_code=stk1.nextToken();

				place_holder_val =place_holder_val + "('"+(library_id)+ "',"+(version_no)+",'"+(term_set_id)+ "','"+(term_code)+ "','"+(goal_code)+ "')," ;  ;
			
				outcnt=0;	
				StringTokenizer stk2= new StringTokenizer(outcome_code,"|");
				while(stk2.hasMoreTokens()){
					outcome_code=stk2.nextToken();
					group_id = outcome_code.substring((outcome_code.indexOf("*")+1),outcome_code.length());
					outcome_code=outcome_code.substring(0,(outcome_code.indexOf("*")));

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(outcnt));
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(outcnt));
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(outcome_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(outcnt));
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(outcnt));
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

					outcnt++;
				}
				intvcnt=0;
			StringTokenizer stk3= new StringTokenizer(intervention_code,"|");
				while(stk3.hasMoreTokens()){
					intervention_code=stk3.nextToken();
					group_id =intervention_code.substring((intervention_code.indexOf("*")+1),intervention_code.length());
					intervention_code=intervention_code.substring(0,(intervention_code.indexOf("*")));
				if(intrvn_code_set.equals(""))
					intrvn_code_set ="\'"+intervention_code+"\'";
				else
					intrvn_code_set=intrvn_code_set+",\'"+intervention_code+"\'";
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(intvcnt));
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(intvcnt));
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(intervention_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(intvcnt));
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(intvcnt));
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
		
					intvcnt++;
				}	
								
			}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(library_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(goal_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(target_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(outcnt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(intvcnt));
            _bw.write(_wl_block18Bytes, _wl_block18);
	
		if(lib_flag){
			lib_flag=false;
		}
		else
			tcnt++;	
		}

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tcnt));
            _bw.write(_wl_block40Bytes, _wl_block40);
 
	}
	if(place_holder_val	.length()>0){
		place_holder_val	= place_holder_val.substring(0,place_holder_val.length()-1);
		
	}else{
		place_holder_val = "('','','','','')";
	}

HashMap inter_details = null;
String sel_inter_code=intrvn_code_set;
if(sel_inter_code.equals(""))
	sel_inter_code = "''";
	inter_details =bean.getInterDetail();
	con = ConnectionManager.getConnection(request);

/*	sql.append("SELECT A.INTERVENTION_CODE,A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC ,A.SHORT_DESC Intervention_Desc FROM CA_INTERVENTION A, CA_INTERVENTION_TYPE B WHERE A.INTERVENTION_TYPE=B.INTERVENTION_TYPE AND A.INTERVENTION_CODE IN(");
	sql.append(sel_inter_code);
	sql.append(")AND A.EFF_STATUS='E' AND B.EFF_STATUS='E' order by 3,4 "); */
	sql.append("SELECT A.INTERVENTION_CODE,A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC ,A.SHORT_DESC Intervention_Desc FROM CA_INTERVENTION_LANG_VW A, CA_INTERVENTION_TYPE_LANG_VW B WHERE A.INTERVENTION_TYPE=B.INTERVENTION_TYPE AND A.INTERVENTION_CODE IN(");
	sql.append(sel_inter_code);
	sql.append(")AND A.EFF_STATUS='E' AND B.EFF_STATUS='E' AND A.LANGUAGE_ID ='");
	sql.append(locale);
	sql.append("' AND B.LANGUAGE_ID = A.LANGUAGE_ID order by 3,4 ");
	/*
	sql_select.append("SELECT   a.freq_code code, b.freq_desc description, d.freq_durn, d.freq_durn_unit, DECODE (d.freq_durn_unit, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)',  '' ) freq_durn_unit_legend, DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI' ),  'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, MIN (  NVL (rel_start_period, 0) * DECODE (rel_start_period_unit,  'M', 1, 'H', 60, 'D', 1440, 'W', 10080, 'L', 43200, 0) ) rel_start_min, 'Y' default_yn FROM ca_intervention_freq a, am_frequency b, am_duration_type c, (SELECT a.freq_code, freq_durn_unit, a.freq_durn, rel_start_period, rel_start_period_unit FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");
	sql_select.append(place_holder_val);
	sql_select.append(") AND a.intervention_code = ?) d WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND d.freq_code = a.freq_code AND d.freq_durn_unit = c.durn_type(+) GROUP BY a.freq_code, b.freq_desc,  d.freq_durn, d.freq_durn_unit, DECODE (d.freq_durn_unit, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)', ''  ), DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'),  'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI'), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI'), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), 0 ) UNION ALL SELECT   a.freq_code code, b.freq_desc description, b.repeat_value freq_durn, b.repeat_durn_type  freq_durn_unit, DECODE (b.repeat_durn_type, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)', '' ) freq_durn_unit_legend,  DECODE (b.repeat_durn_type, 'D', TO_CHAR (SYSDATE + b.repeat_value, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + b.repeat_value / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (b.repeat_value / (24 * 60)), 'DD/MM/YYYY HH24:MI' ), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, b.repeat_value), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + b.repeat_value * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, 0 rel_start_min, 'N' default_yn FROM ca_intervention_freq a, am_frequency b WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND NOT EXISTS ( SELECT a.freq_code FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");
	sql_select.append(place_holder_val);
	sql_select.append(") AND a.intervention_code = ? AND b.freq_code = a.freq_code) ORDER BY 8 desc, 2");
	*/
	sql_select.append("SELECT   a.freq_code code, b.freq_desc description, d.freq_durn, d.freq_durn_unit,d.freq_durn_unit freq_durn_unit_legend, DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI' ),  'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, MIN (  NVL (rel_start_period, 0) * DECODE (rel_start_period_unit,  'M', 1, 'H', 60, 'D', 1440, 'W', 10080, 'L', 43200, 0) ) rel_start_min, 'Y' default_yn FROM ca_intervention_freq a, am_frequency_lang_vw b, am_duration_type c, (SELECT a.freq_code, freq_durn_unit, a.freq_durn, rel_start_period, rel_start_period_unit FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");
	sql_select.append(place_holder_val);
	//sql_select.append(") AND a.intervention_code = ?) d WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND d.freq_code = a.freq_code AND d.freq_durn_unit = c.durn_type(+) and b.language_id = ? GROUP BY a.freq_code, b.freq_desc,  d.freq_durn, d.freq_durn_unit,DECODE (d.freq_durn_unit, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)', ''  ),DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'),  'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI'), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI'), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), 0 ) UNION ALL SELECT   a.freq_code code, b.freq_desc description, b.repeat_value freq_durn, b.repeat_durn_type  freq_durn_unit,b.repeat_durn_type freq_durn_unit_legend,  DECODE (b.repeat_durn_type, 'D', TO_CHAR (SYSDATE + b.repeat_value, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + b.repeat_value / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (b.repeat_value / (24 * 60)), 'DD/MM/YYYY HH24:MI' ), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, b.repeat_value), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + b.repeat_value * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, 0 rel_start_min, 'N' default_yn FROM ca_intervention_freq a, am_frequency_lang_vw b WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND NOT EXISTS ( SELECT a.freq_code FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");//IN031808
	sql_select.append(") AND a.intervention_code = ?) d WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? AND d.freq_code = a.freq_code AND d.freq_durn_unit = c.durn_type(+) and b.language_id = ? GROUP BY a.freq_code, b.freq_desc,  d.freq_durn, d.freq_durn_unit,DECODE (d.freq_durn_unit, 'D', 'Day(s)', 'H', 'Hour(s)', 'M', 'Minute(s)', 'L', 'Month(s)', 'W', 'Week(s)', ''  ),DECODE (d.freq_durn_unit, 'D', TO_CHAR (SYSDATE + d.freq_durn, 'DD/MM/YYYY HH24:MI'),  'H', TO_CHAR (SYSDATE + d.freq_durn / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (d.freq_durn / (24 * 60)), 'DD/MM/YYYY HH24:MI'), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, d.freq_durn), 'DD/MM/YYYY HH24:MI'), 'W', TO_CHAR (SYSDATE + d.freq_durn * 7, 'DD/MM/YYYY HH24:MI'), 0 ) UNION ALL SELECT   a.freq_code code, b.freq_desc description, b.repeat_value freq_durn, b.repeat_durn_type  freq_durn_unit,b.repeat_durn_type freq_durn_unit_legend,  DECODE (b.repeat_durn_type, 'D', TO_CHAR (SYSDATE + b.repeat_value, 'DD/MM/YYYY HH24:MI'), 'H', TO_CHAR (SYSDATE + b.repeat_value / 24, 'DD/MM/YYYY HH24:MI' ), 'M', TO_CHAR (SYSDATE + (b.repeat_value / (24 * 60)), 'DD/MM/YYYY HH24:MI' ), 'L', TO_CHAR (ADD_MONTHS (SYSDATE, b.repeat_value), 'DD/MM/YYYY HH24:MI' ), 'W', TO_CHAR (SYSDATE + b.repeat_value * 7, 'DD/MM/YYYY HH24:MI'), '' ) end_date, 0 rel_start_min, 'N' default_yn FROM ca_intervention_freq a, am_frequency_lang_vw b WHERE eff_status = 'E' AND a.freq_code = b.freq_code AND a.intervention_code = ? and b.language_id = ? AND NOT EXISTS ( SELECT a.freq_code FROM cp_library_intervention a WHERE (a.library_id, a.version_no, a.term_set_id, a.term_code, a.goal_code ) IN (");//IN031808
	sql_select.append(place_holder_val);
	sql_select.append(") AND a.intervention_code = ? AND b.freq_code = a.freq_code  and b.language_id = ?) ORDER BY 8 desc, 2");

//	sql_stage = "SELECT DISTINCT CP_STAGE.STAGE_CODE,SHORT_DESC CARE_PLAN_STAGE FROM CP_STAGE ,CP_LIBRARY_INTERVENTION A WHERE EFF_STATUS='E' AND (A.LIBRARY_ID,A.VERSION_NO,A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE) IN ("+place_holder_val+") AND   A.INTERVENTION_CODE = ? ORDER BY 2 ";
	sql_stage = "SELECT DISTINCT CP_STAGE.STAGE_CODE,SHORT_DESC CARE_PLAN_STAGE FROM CP_STAGE_lang_vw CP_STAGE,CP_LIBRARY_INTERVENTION A WHERE EFF_STATUS='E' AND (A.LIBRARY_ID,A.VERSION_NO,A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE) IN ("+place_holder_val+") AND   A.INTERVENTION_CODE = ? AND CP_STAGE.LANGUAGE_ID = ? ORDER BY 2";
	
//	sql_posn = "SELECT POSITION_CODE,POSITION_DESC FROM AM_POSITION WHERE EFF_STATUS='E' AND EXISTS(SELECT 1 FROM CA_INTERVENTION_FOR_POSN WHERE POSITION_CODE=AM_POSITION.POSITION_CODE AND INTERVENTION_CODE= ?) ORDER BY 2";
	sql_posn = "SELECT POSITION_CODE,POSITION_DESC FROM AM_POSITION_LANG_VW AM_POSITION WHERE EFF_STATUS='E' AND EXISTS(SELECT 1 FROM CA_INTERVENTION_FOR_POSN WHERE POSITION_CODE=AM_POSITION.POSITION_CODE AND INTERVENTION_CODE= ?) AND LANGUAGE_ID = ? ORDER BY 2";
//System.err.println("@@@PLACE : "+place_holder_val);
	ps = con.prepareStatement(sql.toString());
	rs = ps.executeQuery();
	pstmt = con.prepareStatement(sql_select.toString());
	ps1 = con.prepareStatement(sql_stage);
	ps2 = con.prepareStatement(sql_posn);

            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

		while(rs.next()){
			String inter_type="";
			
			if ( i % 2 == 0 )
				classValue = "GRPEVEN" ;
			else
				classValue = "GRPEVEN" ;

			/********************/
			String freq_cd="",dur="",dur_unit="",dur_unit_legd="";
						
			String  selected = "",tmp_value="";
			String temp_inter_val="";
			String tmp_st_date="", tmp_stage="*A", tmp_postn=" ",tmp_prior="", tmp_date="",tmp_fre_cd="",tmp_dur="",tmp_other_freq="",tmp_dur_unit="",tmp_dur_unit1="";
			temp_inter_val = (String)inter_details.get(rs.getString(1));
			if(temp_inter_val!= null){
				StringTokenizer stk=new StringTokenizer(temp_inter_val,",");
				while(stk.hasMoreTokens()){
					tmp_stage=stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_prior=stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_postn=stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_st_date= com.ehis.util.DateUtils.convertDate(stk.nextToken(),"DMYHM","en",locale);
					if(stk.hasMoreTokens())
						tmp_fre_cd= stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_dur= stk.nextToken();
					if(stk.hasMoreTokens())
						tmp_dur_unit1= stk.nextToken();
					
					if(tmp_dur_unit1.equals("D"))
						tmp_dur_unit = dayslegend;
					else if(tmp_dur_unit1.equals("H"))
						tmp_dur_unit = hourslegend;
					else if(tmp_dur_unit1.equals("M"))
						tmp_dur_unit = minuteslegend;
					else if(tmp_dur_unit1.equals("L"))
						tmp_dur_unit = monthslegend;
					else if(tmp_dur_unit1.equals("W"))
						tmp_dur_unit = weekslegend;
					if(stk.hasMoreTokens())
						tmp_date= com.ehis.util.DateUtils.convertDate(stk.nextToken(),"DMYHM","en",locale);
					if(stk.hasMoreTokens())
						tmp_other_freq= stk.nextToken();
				}
			}
			
			/*********************/
			interven_code=rs.getString(1);inter_type=rs.getString(2);
			if(!tmp_interven_code.equals(inter_type.trim()))	{	

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rs.getString(3)));
            _bw.write(_wl_block51Bytes, _wl_block51);

		tmp_interven_code = inter_type;//inter_type="O";
	}
	String classValue1="";
	if(inter_type.equals("O"))
		classValue1= "ORDERS";
	else
		classValue1=classValue;

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tmp_st_date==""?dateString:tmp_st_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
 
	//System.err.println("@@@INTVN : "+interven_code);
		pstmt.setString(1,interven_code);
		pstmt.setString(2,interven_code);
		pstmt.setString(3,locale);
		pstmt.setString(4,interven_code);
		pstmt.setString(5,locale);//IN031808
		pstmt.setString(6,interven_code);
		pstmt.setString(7,locale);
		String end_dt="";
		String rel_prd="";
		String default_yn="";
		int rel_start_prd=0,rel_start_prd1=0;
		rs1 = pstmt.executeQuery();
		dur="";
		dur_unit="";
		dur_unit_legd="";
		end_dt="";
		while(rs1.next())
		{  
				freq_cd = rs1.getString(1)==null?"0":rs1.getString(1);
				tmp_value = rs1.getString(1)+","+rs1.getString(3)+","+rs1.getString(4);
				if(rel_prd.equals("")){
					rel_prd = rs1.getString(7)==null?"0":rs1.getString(7);
					rel_start_prd1 = Integer.parseInt(rel_prd);
				}else{
					if(rs1.getString(7) != null){
						if(!(rel_start_prd1 >rs1.getInt(7))){
							rel_start_prd =rs1.getInt(7);
							rel_start_prd1=rs1.getInt(7);
						}
					}
					else{
						rel_start_prd =0;
						rel_start_prd1=0;
					}
				}
				selected = "";
			default_yn=rs1.getString("default_yn")==null?"":rs1.getString("default_yn");
			if(default_yn.equalsIgnoreCase("Y")){
				dur = rs1.getString(3)==null?"0":rs1.getString(3);
				dur_unit = rs1.getString(4)==null?"":rs1.getString(4);
				dur_unit_legd = rs1.getString(5)==null?"":rs1.getString(5);
				end_dt = rs1.getString(6)==null?"":com.ehis.util.DateUtils.convertDate(rs1.getString(6),"DMYHM","en",locale);
				selected="selected";

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(tmp_value));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(select_color(rs1.getString(1),tmp_fre_cd,"#FFFFFF")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(select(rs1.getString(1),tmp_fre_cd)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rs1.getString(2).trim()));
            _bw.write(_wl_block73Bytes, _wl_block73);
   		
			}
			else{
				selected="";
				if(dur.equals(""))
					dur = rs1.getString(3)==null?"0":rs1.getString(3);
				if(dur_unit.equals("")){
					dur_unit = rs1.getString(4)==null?"":rs1.getString(4);
				}
				else{
					if((rs1.getString(4)!=null)&&(tmp_fre_cd.equals(freq_cd))){
						if(!tmp_dur_unit1.equals("")){
							dur_unit=rs1.getString(4);
						}
					}
				}
				if(dur_unit_legd.equals(""))
					dur_unit_legd = rs1.getString(5)==null?"":rs1.getString(5);
				if(dur_unit_legd.equals("")) 
					dur_unit_legd="";
				if(dur_unit_legd.equals("D")) 
					dur_unit_legd =dayslegend;
				if(dur_unit_legd.equals("H"))
					dur_unit_legd=hourslegend;
				if(dur_unit_legd.equals("M")) 
					dur_unit_legd= minuteslegend;
				if(dur_unit_legd.equals("L")) 
					dur_unit_legd= monthslegend;
				if(dur_unit_legd.equals("W")) 
					dur_unit_legd=weekslegend;

				if(end_dt.equals(""))
					end_dt = rs1.getString(6)==null?"":com.ehis.util.DateUtils.convertDate(rs1.getString(6),"DMYHM","en",locale);

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(tmp_value));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(select(rs1.getString(1),tmp_fre_cd)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rs1.getString(2).trim()));
            _bw.write(_wl_block73Bytes, _wl_block73);

			}
		} 

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_other_freq));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tmp_dur==""?dur:tmp_dur));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(tmp_dur_unit==""?dur_unit_legd:tmp_dur_unit));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
	
				char ch_durn_unit=' ';
				if(tmp_dur_unit1.equals(""))
					tmp_dur_unit1 = dur_unit;
				if(!dur_unit.equals(""))
					ch_durn_unit=dur_unit.charAt(0);
				else if(!tmp_dur_unit1.equals(""))
					ch_durn_unit=tmp_dur_unit1.charAt(0);

				switch(ch_durn_unit){
					case 'M' :

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"M","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"M")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
			
					case 'H':

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"H","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"H")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

					case 'D':

            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"D","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"D")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

					case 'W':

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"W","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"W")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

					case 'L':

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"L","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"L")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

							break;
					default:

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"M","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"M")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"H","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"H")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"D","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"D")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"W","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"W")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(select_color(tmp_dur_unit1,"L","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_dur_unit1,"L")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

				}

            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tmp_date==""?end_dt:tmp_date));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(select(tmp_stage,"*A")));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

			ps1.setString(1,interven_code);
			ps1.setString(2,locale);
			rs2 =ps1.executeQuery();
			while(rs2.next()){

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rs2.getString(1)));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(select_color(rs2.getString(1),tmp_stage,"#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(rs2.getString(1),tmp_stage)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rs2.getString(2).trim()));
            _bw.write(_wl_block114Bytes, _wl_block114);

			}

            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(select_color(tmp_prior,"N","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_prior,"N")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(select_color(tmp_prior,"H","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_prior,"H")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(select_color(tmp_prior,"C","#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(tmp_prior,"C")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

			ps2.setString(1,interven_code);
			ps2.setString(2,locale);
			rs3 =ps2.executeQuery();
			while(rs3.next()){  

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rs3.getString(1)));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(select_color(rs3.getString(1),tmp_postn,"#990000")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(select(rs3.getString(1),tmp_postn)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rs3.getString(2).trim()));
            _bw.write(_wl_block126Bytes, _wl_block126);
	
			}

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(temp_inter_val));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tmp_fre_cd==""?freq_cd:tmp_fre_cd));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tmp_dur==""?dur:tmp_dur));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tmp_dur_unit1==""?dur_unit:tmp_dur_unit1));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dateString));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rel_start_prd));
            _bw.write(_wl_block143Bytes, _wl_block143);

		i++;	
	}

            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(goal_stmt));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(dateString));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(dateString));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(dateString));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(selected_diagnosis));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block155Bytes, _wl_block155);

	if(selected_diagnosis.equals("") && i==0){
			out.println("<script>alert(getMessage('NO_INTERVENTION_SELECTED','CP'));</script>");

		}

	}
	catch(Exception ee)
	{
		//out.println("Exception in Generate Preview "+ee.toString());//common-icn-0181
		ee.printStackTrace();
	}
	finally
	{
		try{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(ps1 != null) ps1.close();
				if(ps2 != null) ps2.close();
				if(rs1 != null) rs1.close();
				if(pstmt != null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){out.println(e);}
	}


            _bw.write(_wl_block156Bytes, _wl_block156);
            _bw.write(_wl_block157Bytes, _wl_block157);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.GeneratePlanDetail.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Interventions.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stage.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minutes.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Weeks.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Months.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Weeks.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Months.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.High.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Critical.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
