package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __workplacerequirementresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/WorkplaceRequirementResult.jsp", 1709121672824L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- /**\n\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\t\n*\tModified By\t\t:\tSuresh.S\n*\tModified On\t\t:\t20 October 2004.\n*/ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n<!-- <script language=\"javascript\" src=\"../js/RSMessages.js\"></script> -->\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../js/WorkplaceRequirement.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<script>\n\t\t\t\tparent.frameWorkPlaceHdr.document.location.href=\"../../eCommon/html/blank.html\"\n\t\t\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));history.go(-1);\n\t</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t <form name=\'form_WrkPlaceReqdResult\' id=\'form_WrkPlaceReqdResult\' action=\'../../servlet/eRS.WorkplaceRequirementServlet\' method=\'POST\' target=\'messageFrame\'> \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<table cellpadding=0 cellspacing=0 border=1 align=center width=\"98%\" id=\'\' >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!--------shift data -------------->\n\t\t\t\t\t\t<td colspan=\'13\' align=left class=\'CAGROUPHEADING\' style=\"font-ssize:6pt;\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<tr>\n\t\t\t\t<!--------Position data -------------->\n\t\t\t\t\t<td rowspan=\'3\' align=left  valign=\'top\' class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' width=\'35%\'  >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\n\t\t\t\t<!--------fixed data --Wday-------------->\n\t\t\t\t<td  Align=\'left\' class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' width=\'9%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' width=\'6%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\n\t\t\t\t<!------- By ratio --Wday------------>\n\t\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' width=\'13%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =":";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\n\t\t\t\t<!------- By FTE --Wday------------>\n\t\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\n\t\t\t\t<tr>\n\t\t\t\t<!--------fixed data --NWday-------------->\n\t\t\t\t<td  Align=\'left\' class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\n\n\t\t\t\t<!------- By ratio --NWday------------>\n\t\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\n\t\t\t\t<!------- By FTE --NWday------------>\n\t\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' width=\'6%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<!--------fixed data --Hday-------------->\n\t\t\t\t<td  Align=\'left\' class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\n\n\t\t\t\t<!------- By ratio --Hday------------>\n\t\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\n\t\t\t\t<!------- By FTE --Hday------------>\n\t\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<form name=\'form_WrkPlaceReqdResult\' id=\'form_WrkPlaceReqdResult\' action=\'../../servlet/eRS.WorkplaceRequirementServlet\' method=\'POST\' target=\'messageFrame\'> \n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<table cellpadding=0 cellspacing=0 border=1 align=center width=\"98%\" id=\'\'>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<!--------shift data -------------->\n\t\t\t\t\t<td colspan=\'13\' align=left class=\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<input type=\'hidden\' name=shift_code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t<tr>\n\t\t\t<!--------Position data -------------->\n\t\t\t\t<td rowspan=\'3\' align=left  valign=\'top\' class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t <input type=\'hidden\' name=\'posiCode";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'posiCode";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\n\t\t\t<!--------fixed data --Wday-------------->\n\t\t\t<td  Align=\'left\' class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' width=\'6%\'><input type=text name=\"wday_min";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"wday_min";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" size=\"1\"  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' width=\'6%\'><input type=text name=\"wday_opt";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"wday_opt";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" size=\"1\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' width=\'6%\'><input type=text name=\"wday_max";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"wday_max";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="  onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\n\t\t\t<!------- By ratio --Wday------------>\n\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'  width=\'10%\'><input type=text name=\"wday_sb1";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"wday_sb1";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" size=\"1\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="  onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'>:<input type=text name=\"wday_sb2";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"wday_sb2";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' width=\'10%\'><input type=text name=\"wday_sp1";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"wday_sp1";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'>:<input type=text name=\"wday_sp2";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"wday_sp2";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\n\t\t\t<!------- By FTE --Wday------------>\n\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' width=\'6%\'><input type=text name=\"wday_fte";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"wday_fte";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' width=\'6%\'><input type=text name=\"wday_hrs";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"wday_hrs";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\n\t\t\t<!------- select------------>\n\t\t\t<td  Align=\'center\' class=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' rowspan=\'3\' width=\'6%\'><input type=checkbox name=\'select";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'select";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'  value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" ></td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t<!--------fixed data --NWday-------------->\n\t\t\t<td  Align=\'left\' class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'  width=\'6%\'><input type=text name=\"nwday_min";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"nwday_min";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'  width=\'6%\'><input type=text name=\"nwday_opt";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"nwday_opt";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'  width=\'6%\'><input type=text name=\"nwday_max";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"nwday_max";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\n\t\t\t<!------- By ratio --NWday------------>\n\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'  width=\'10%\'><input type=text name=\"nwday_sb1";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"nwday_sb1";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"size=\"1\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'>:<input type=text name=\"nwday_sb2";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"nwday_sb2";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'  width=\'10%\'><input type=text name=\"nwday_sp1";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"nwday_sp1";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'>:<input type=text name=\"nwday_sp2";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"nwday_sp2";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\n\t\t\t<!------- By FTE --NWday------------>\n\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'  width=\'6%\'><input type=text name=\"nwday_fte";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"nwday_fte";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' width=\'6%\'><input type=text name=\"nwday_hrs";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"nwday_hrs";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" value=\"\n\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<!--------fixed data --Hday-------------->\n\t\t\t<td  Align=\'left\' class=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' width=\'6%\'><input type=text name=\"hday_min";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"hday_min";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' width=\'6%\'><input type=text name=\"hday_opt";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"hday_opt";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' width=\'6%\'><input type=text name=\"hday_max";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"hday_max";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\n\t\t\t<!------- By ratio --Hday------------>\n\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'><input type=text name=\"hday_sb1";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" id=\"hday_sb1";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\' width=\'10%\'>:<input type=text name=\"hday_sb2";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id=\"hday_sb2";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' width=\'10%\'><input type=text name=\"hday_sp1";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" id=\"hday_sp1";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'>:<input type=text name=\"hday_sp2";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" id=\"hday_sp2";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\n\t\t\t<!------- By FTE --Hday------------>\n\t\t\t<td  Align=\'center\'  class=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' width=\'6%\'><input type=text name=\"hday_fte";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" id=\"hday_fte";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' width=\'6%\'><input type=text name=\"hday_hrs";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" id=\"hday_hrs";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" onKeyPress=\'return NumberFormat()\' maxlength=\'3\' onblur=\'checkForNull(this);\'></td>\n\n\t\t\t</tr>\n\t\t\t<input type=\'hidden\' name=dbAction";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t</table>\n\t<input type=\'hidden\' name=fac_id value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t<input type=\'hidden\' name=workplace_code value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t<input type=\'hidden\' name=req_id  value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" > \n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" > \n\t<input type=\"hidden\" name=\"frm_dt\" id=\"frm_dt\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" > \n\t<input type=\"hidden\" name=\"to_dt\" id=\"to_dt\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" > \n\t<input type=\"hidden\" name=\"reqd_desc\" id=\"reqd_desc\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" > \t\t\n\t<input type=\"hidden\" name=\"constCount\" id=\"constCount\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" > \t\t\n\t</form>\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n</body>\t\n</html>\n\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;

	String facility_id  = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String reqd_id		= request.getParameter("reqd_id")==null?"":request.getParameter("reqd_id");
	String wrkplace_code= request.getParameter("wrkplace_code")==null?"":request.getParameter("wrkplace_code");
	String mode			= request.getParameter("mode")==null?"":request.getParameter("mode");
	String frm_dt		= request.getParameter("frm_dt")==null?"":request.getParameter("frm_dt");
	String to_dt		= request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	String reqd_desc	= request.getParameter("reqd_desc")==null?"":request.getParameter("reqd_desc");

	String slClassValue		="";
	String Sql				="";
	String countSql			="";
	int count				=0;
	ArrayList ResultData	= new ArrayList();
	String[] record			= null;
	String readOnly			="";
	String chk_shift_flag	="";
	//out.println("mode----->" +mode);	
	try{
		Con=ConnectionManager.getConnection(request);
		
		countSql="select count(*) count from rs_workplace_requirement where facility_id= ? and workplace_code = ? and requirement_date_fm is null and requirement_date_to is null and (? is null or to_date(?,'dd/mm/yyyy') between requirement_date_fm and requirement_date_to)";

		pstmt=Con.prepareStatement(countSql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,wrkplace_code);
		pstmt.setString(3,frm_dt);
		pstmt.setString(4,frm_dt);

		rslRst = pstmt.executeQuery();
		while(rslRst.next()){
			count=rslRst.getInt("count");
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst !=null)
			rslRst.close();

		//Sql="SELECT 'U' db_action,a.facility_id facility_id,a.workplace_code workplace_code,a.requirement_id requirement_id,a.shift_code shift_code,c.short_desc shift_desc,a.position_code position_code,	b.position_desc position_desc,a.fr_wday_min fr_wday_min,a.fr_wday_opt fr_wday_opt,a.fr_wday_max fr_wday_max,a.fr_nwday_min fr_nwday_min,a.fr_nwday_opt fr_nwday_opt,a.fr_nwday_max fr_nwday_max,	a.fr_hday_min fr_hday_min,a.fr_hday_opt fr_hday_opt,a.fr_hday_max fr_hday_max,a.fr_sbr_staff_wday fr_sbr_staff_wday,a.fr_sbr_bed_wday fr_sbr_bed_wday,a.fr_sbr_staff_nwday fr_sbr_staff_nwday,	a.fr_sbr_bed_nwday fr_sbr_bed_nwday,a.fr_sbr_staff_hday fr_sbr_staff_hday,a.fr_sbr_bed_hday fr_sbr_bed_hday,a.vr_spr_staff_wday vr_spr_staff_wday,a.vr_spr_patient_wday vr_spr_patient_wday,	a.vr_spr_staff_nwday vr_spr_staff_nwday,a.vr_spr_patient_nwday vr_spr_patient_nwday,	a.vr_spr_staff_hday vr_spr_staff_hday,a.vr_spr_patient_hwday vr_spr_patient_hwday,a.vr_fte_wday vr_fte_wday,a.vr_fte_hours_wday vr_fte_hours_wday,a.vr_fte_nwday vr_fte_nwday,a.vr_fte_hours_nwday vr_fte_hours_nwday,a.vr_fte_hday vr_fte_hday,a.vr_fte_hours_hday vr_fte_hours_hday FROM 	rs_workplace_requirement_dtl a, am_position b, am_shift c WHERE 	a.facility_id = (?) AND 	a.workplace_code = (?) AND	a.requirement_id = (?) AND 	a.position_code = b.position_code AND	c.shift_code = a.shift_code UNION ALL SELECT 'I' db_action,m.facility_id facility_id,m.workplace_code workplace_code,(?) reqirement_id, m.shift_code shift_code, p.short_desc shift_desc,n.position_code position_code, o.position_desc position_desc ,0 fr_wday_min,0  fr_wday_opt,0 fr_wday_max,0 fr_nwday_min,0 fr_nwday_opt,0 fr_nwday_max ,0 fr_hday_min,0 fr_hday_opt,0 fr_hday_max,0 fr_sbr_staff_wday,0 fr_sbr_bed_wday,0 fr_sbr_staff_nwday,0 fr_sbr_bed_nwday,0 fr_sbr_staff_hday,0 fr_sbr_bed_hday,0 vr_spr_staff_wday,0 vr_spr_patient_wday,0 vr_spr_staff_nwday,0 vr_spr_patient_nwday,0 vr_spr_staff_hday,0 vr_spr_patient_hwday,0 vr_fte_wday,0 vr_fte_hours_wday 	,0 vr_fte_nwday,0 vr_fte_hours_nwday,0 vr_fte_hday,0 vr_fte_hours_hday FROM rs_shift_for_workplace m, am_shift_for_position n, am_position o, am_shift p WHERE 	m.facility_id = (?) AND 	m.workplace_code =(?) AND 	m.shift_code = n.shift_code AND 	n.position_code = o.position_code AND 	(n.shift_code, n.position_code) NOT IN 	(SELECT 	shift_code, position_code FROM rs_workplace_requirement_dtl WHERE 	facility_id =(?) AND 	workplace_code =(?) AND	requirement_id =(?)) AND	p.shift_code = m.shift_code and p.shift_indicator = 'P' ORDER BY shift_code, position_desc";
		Sql="SELECT 'U' db_action,a.facility_id facility_id,a.workplace_code workplace_code,a.requirement_id requirement_id,a.shift_code shift_code,c.short_desc shift_desc,a.position_code position_code, b.position_desc position_desc,a.fr_wday_min fr_wday_min,a.fr_wday_opt fr_wday_opt,a.fr_wday_max fr_wday_max,a.fr_nwday_min fr_nwday_min,a.fr_nwday_opt fr_nwday_opt,a.fr_nwday_max fr_nwday_max, a.fr_hday_min fr_hday_min,a.fr_hday_opt fr_hday_opt,a.fr_hday_max fr_hday_max,a.fr_sbr_staff_wday fr_sbr_staff_wday,a.fr_sbr_bed_wday fr_sbr_bed_wday,a.fr_sbr_staff_nwday fr_sbr_staff_nwday, a.fr_sbr_bed_nwday fr_sbr_bed_nwday,a.fr_sbr_staff_hday fr_sbr_staff_hday,a.fr_sbr_bed_hday fr_sbr_bed_hday,a.vr_spr_staff_wday vr_spr_staff_wday,a.vr_spr_patient_wday vr_spr_patient_wday, a.vr_spr_staff_nwday vr_spr_staff_nwday,a.vr_spr_patient_nwday vr_spr_patient_nwday, a.vr_spr_staff_hday vr_spr_staff_hday,a.vr_spr_patient_hwday vr_spr_patient_hwday,a.vr_fte_wday vr_fte_wday,a.vr_fte_hours_wday vr_fte_hours_wday,a.vr_fte_nwday vr_fte_nwday,a.vr_fte_hours_nwday vr_fte_hours_nwday,a.vr_fte_hday vr_fte_hday,a.vr_fte_hours_hday vr_fte_hours_hday FROM  rs_workplace_requirement_dtl a, am_position_lang_vw b, am_shift_lang_vw c WHERE  a.facility_id = (?) AND  a.workplace_code = (?) AND a.requirement_id = (?) AND  a.position_code = b.position_code AND c.shift_code = a.shift_code and b.language_id = ? and c.language_id = b.language_id UNION ALL SELECT 'I' db_action,m.facility_id facility_id,m.workplace_code workplace_code,(?) reqirement_id, m.shift_code shift_code, p.short_desc shift_desc,n.position_code position_code, o.position_desc position_desc ,0 fr_wday_min,0  fr_wday_opt,0 fr_wday_max,0 fr_nwday_min,0 fr_nwday_opt,0 fr_nwday_max ,0 fr_hday_min,0 fr_hday_opt,0 fr_hday_max,0 fr_sbr_staff_wday,0 fr_sbr_bed_wday,0 fr_sbr_staff_nwday,0 fr_sbr_bed_nwday,0 fr_sbr_staff_hday,0 fr_sbr_bed_hday,0 vr_spr_staff_wday,0 vr_spr_patient_wday,0 vr_spr_staff_nwday,0 vr_spr_patient_nwday,0 vr_spr_staff_hday,0 vr_spr_patient_hwday,0 vr_fte_wday,0 vr_fte_hours_wday  ,0 vr_fte_nwday,0 vr_fte_hours_nwday,0 vr_fte_hday,0 vr_fte_hours_hday FROM rs_shift_for_workplace m, am_shift_for_position n, am_position_lang_vw o, am_shift_lang_vw p WHERE  m.facility_id = (?) AND  m.workplace_code =(?) AND  m.shift_code = n.shift_code AND  n.position_code = o.position_code AND  (n.shift_code, n.position_code) NOT IN  (SELECT  shift_code, position_code FROM rs_workplace_requirement_dtl WHERE  facility_id =(?) AND  workplace_code =(?) AND requirement_id =(?)) AND p.shift_code = m.shift_code and p.shift_indicator = 'P' and o.language_id = ? and p.language_id = o.language_id ORDER BY shift_code, position_desc";

		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,wrkplace_code);
		pstmt.setString(3,reqd_id);
		pstmt.setString(4,locale);
		pstmt.setString(5,reqd_id);
		pstmt.setString(6,facility_id);
		pstmt.setString(7,wrkplace_code);
		pstmt.setString(8,facility_id);
		pstmt.setString(9,wrkplace_code);
		pstmt.setString(10,reqd_id);
		pstmt.setString(11,locale);
		rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			record = new String[35];
			
			record[0]			=rslRst.getString("db_action");
			record[1]			=rslRst.getString("facility_id");
			record[2]			=rslRst.getString("workplace_code");
			record[3]			=rslRst.getString("requirement_id");
			record[4]			=rslRst.getString("shift_code");
			record[5]			=rslRst.getString("shift_desc");
			record[6]			=rslRst.getString("position_code");
			record[7]			=rslRst.getString("position_desc");
			record[8]			=rslRst.getString("fr_wday_min");
			record[9]			=rslRst.getString("fr_wday_opt");
			record[10]			=rslRst.getString("fr_wday_max");
			record[11]			=rslRst.getString("fr_nwday_min");
			record[12]			=rslRst.getString("fr_nwday_opt");
			record[13]			=rslRst.getString("fr_nwday_max");
			record[14]			=rslRst.getString("fr_hday_min");
			record[15]			=rslRst.getString("fr_hday_opt");
			record[16]			=rslRst.getString("fr_hday_max");
			record[17]			=rslRst.getString("fr_sbr_staff_wday");
			record[18]			=rslRst.getString("fr_sbr_bed_wday");
			record[19]			=rslRst.getString("fr_sbr_staff_nwday");
			record[20]			=rslRst.getString("fr_sbr_bed_nwday");
			record[21]			=rslRst.getString("fr_sbr_staff_hday");
			record[22]			=rslRst.getString("fr_sbr_bed_hday");
			record[23]			=rslRst.getString("vr_spr_staff_wday");
			record[24]			=rslRst.getString("vr_spr_patient_wday");
			record[25]			=rslRst.getString("vr_spr_staff_nwday");
			record[26]			=rslRst.getString("vr_spr_patient_nwday");
			record[27]			=rslRst.getString("vr_spr_staff_hday");
			record[28]			=rslRst.getString("vr_spr_patient_hwday");
			record[29]			=rslRst.getString("vr_fte_wday");
			record[30]			=rslRst.getString("vr_fte_hours_wday");
			record[31]			=rslRst.getString("vr_fte_nwday");
			record[32]			=rslRst.getString("vr_fte_hours_nwday");
			record[33]			=rslRst.getString("vr_fte_hday");
			record[34]			=rslRst.getString("vr_fte_hours_hday");

			ResultData.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst !=null)
			rslRst.close();
		if(ResultData.size()<= 0){

            _bw.write(_wl_block7Bytes, _wl_block7);

			
            _bw.write(_wl_block8Bytes, _wl_block8);

			
		}
		if(mode.equals("edit")){
			readOnly="readonly";

            _bw.write(_wl_block9Bytes, _wl_block9);

			 for( int i=0 ; i<ResultData.size(); i++ ) {
				if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}

				String[] record1 = (String[])ResultData.get(i);

//				String dbAction				=	record1[0]==null?"":record1[0];
				String shift_code			=	record1[4]==null?"":record1[4];
				String shift_desc			=	record1[5]==null?"":record1[5];
				String posiDesc				=	record1[7]==null?"":record1[7];
				String fr_Wday_min			=	record1[8]==null?"":record1[8];
				String fr_Wday_opt			=	record1[9]==null?"":record1[9];
				String fr_Wday_max			=	record1[10]==null?"":record1[10];
				String fr_NWday_min			=	record1[11]==null?"":record1[11];
				String fr_NWday_opt			=	record1[12]==null?"":record1[12];
				String fr_NWday_max			=	record1[13]==null?"":record1[13];
				String fr_Hday_min			=	record1[14]==null?"":record1[14];
				String fr_Hday_opt			=	record1[15]==null?"":record1[15];
				String fr_Hday_max			=	record1[16]==null?"":record1[16];
				String fr_SBR_staff_wday	=	record1[17]==null?"":record1[17];
				String fr_SBR_bed_wday		=	record1[18]==null?"":record1[18];
				String fr_SBR_staff_nwday	=	record1[19]==null?"":record1[19];
				String fr_SBR_bed_nwday		=	record1[20]==null?"":record1[20];
				String fr_SBR_staff_hday	=	record1[21]==null?"":record1[21];
				String fr_SBR_bed_hday		=	record1[22]==null?"":record1[22];
				String vr_spr_staff_wday	=	record1[23]==null?"":record1[23];
				String vr_spr_patient_wday	=	record1[24]==null?"":record1[24];
				String vr_spr_staff_nwday	=	record1[25]==null?"":record1[25];
				String vr_spr_patient_nwday	=	record1[26]==null?"":record1[26];
				String vr_spr_staff_hday	=	record1[27]==null?"":record1[27];
				String vr_spr_patient_hday	=	record1[28]==null?"":record1[28];
				String vr_FTE_wday			=	record1[29]==null?"":record1[29];
				String vr_FTE_hours_wday	=	record1[30]==null?"":record1[30];
				String vr_FTE_nwday			=	record1[31]==null?"":record1[31];
				String vr_FTE_hours_nwday	=	record1[32]==null?"":record1[32];
				String vr_FTE_hday			=	record1[33]==null?"":record1[33];
				String vr_FTE_hours_hday	=	record1[34]==null?"":record1[34];

				if(shift_code == null ) 
					shift_code =""; 
				else 
					shift_code = shift_code.trim();

            _bw.write(_wl_block10Bytes, _wl_block10);

				if((chk_shift_flag.equals("")) || !(chk_shift_flag.equals(shift_code))){

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);

					chk_shift_flag=shift_code;
				}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(posiDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fr_Wday_min));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fr_Wday_opt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fr_Wday_max));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(fr_SBR_staff_wday));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fr_SBR_bed_wday));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(vr_spr_staff_wday));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(vr_spr_patient_wday));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(vr_FTE_wday));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(vr_FTE_hours_wday));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fr_NWday_min));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fr_NWday_opt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fr_NWday_max));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(fr_SBR_staff_nwday));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fr_SBR_bed_nwday));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(vr_spr_staff_nwday));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(vr_spr_patient_nwday));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(vr_FTE_nwday));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(vr_FTE_hours_nwday));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fr_Hday_min));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fr_Hday_opt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fr_Hday_max));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(fr_SBR_staff_hday));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fr_SBR_bed_hday));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(vr_spr_staff_hday));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(vr_spr_patient_hday));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(vr_FTE_hday));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(vr_FTE_hours_hday));
            _bw.write(_wl_block30Bytes, _wl_block30);

				/***************************************************/
			}
		}
		else{

            _bw.write(_wl_block31Bytes, _wl_block31);

		 for( int i=0 ; i<ResultData.size(); i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}

			String[] record1 = (String[])ResultData.get(i);

			String dbAction				=	record1[0]==null?"":record1[0];
			String shift_code			=	record1[4]==null?"":record1[4];
			String shift_desc			=	record1[5]==null?"":record1[5];
			String posiCode				=	record1[6]==null?"":record1[6];
			String posiDesc				=	record1[7]==null?"":record1[7];
			String fr_Wday_min			=	record1[8]==null?"":record1[8];
			String fr_Wday_opt			=	record1[9]==null?"":record1[9];
			String fr_Wday_max			=	record1[10]==null?"":record1[10];
			String fr_NWday_min			=	record1[11]==null?"":record1[11];
			String fr_NWday_opt			=	record1[12]==null?"":record1[12];
			String fr_NWday_max			=	record1[13]==null?"":record1[13];
			String fr_Hday_min			=	record1[14]==null?"":record1[14];
			String fr_Hday_opt			=	record1[15]==null?"":record1[15];
			String fr_Hday_max			=	record1[16]==null?"":record1[16];
			String fr_SBR_staff_wday	=	record1[17]==null?"":record1[17];
			String fr_SBR_bed_wday		=	record1[18]==null?"":record1[18];
			String fr_SBR_staff_nwday	=	record1[19]==null?"":record1[19];
			String fr_SBR_bed_nwday		=	record1[20]==null?"":record1[20];
			String fr_SBR_staff_hday	=	record1[21]==null?"":record1[21];
			String fr_SBR_bed_hday		=	record1[22]==null?"":record1[22];
			String vr_spr_staff_wday	=	record1[23]==null?"":record1[23];
			String vr_spr_patient_wday	=	record1[24]==null?"":record1[24];
			String vr_spr_staff_nwday	=	record1[25]==null?"":record1[25];
			String vr_spr_patient_nwday	=	record1[26]==null?"":record1[26];
			String vr_spr_staff_hday	=	record1[27]==null?"":record1[27];
			String vr_spr_patient_hday	=	record1[28]==null?"":record1[28];
			String vr_FTE_wday			=	record1[29]==null?"":record1[29];
			String vr_FTE_hours_wday	=	record1[30]==null?"":record1[30];
			String vr_FTE_nwday			=	record1[31]==null?"":record1[31];
			String vr_FTE_hours_nwday	=	record1[32]==null?"":record1[32];
			String vr_FTE_hday			=	record1[33]==null?"":record1[33];
			String vr_FTE_hours_hday	=	record1[34]==null?"":record1[34];
			String Check="";
			String Chkvalue="";
			if(dbAction.equals("U")){
				Check="Checked";
				Chkvalue="Y";
			}else{
				Check="";
				Chkvalue="";
			}
			if(shift_code == null ) shift_code =""; else shift_code = shift_code.trim();

            _bw.write(_wl_block32Bytes, _wl_block32);

			if((chk_shift_flag.equals("")) || !(chk_shift_flag.equals(shift_code))){

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(shift_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);

				chk_shift_flag=shift_code;
			}

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(shift_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(posiDesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(posiCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_Wday_min));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_Wday_opt));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_Wday_max));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_SBR_staff_wday));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_SBR_bed_wday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_spr_staff_wday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_spr_patient_wday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_FTE_wday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_FTE_hours_wday));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(Chkvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Check));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_NWday_min));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_NWday_opt));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_NWday_max));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_SBR_staff_nwday));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_SBR_bed_nwday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_spr_staff_nwday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_spr_patient_nwday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_FTE_nwday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(vr_FTE_hours_nwday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_Hday_min));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_Hday_opt));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_Hday_max));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_SBR_staff_hday));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fr_SBR_bed_hday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_spr_staff_hday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_spr_patient_hday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(vr_FTE_hday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(vr_FTE_hours_hday));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dbAction));
            _bw.write(_wl_block118Bytes, _wl_block118);

		}
	}

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(wrkplace_code));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(reqd_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(ResultData.size()));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(frm_dt));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(to_dt));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(reqd_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(count));
            _bw.write(_wl_block128Bytes, _wl_block128);

	}
	catch(Exception e){
		out.println("Exception in try of WrkPlaceReqdNewStaffDtl.jsp : "+e);
	}
	finally {
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		if(Con!=null) ConnectionManager.returnConnection(Con,request);
	}

            _bw.write(_wl_block129Bytes, _wl_block129);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WDay.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.NWDay.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Holiday.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WDay.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.NWDay.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Holiday.label", java.lang.String .class,"key"));
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
}
