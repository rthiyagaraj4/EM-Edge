package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import eBL.RecordApprovalPatientDataBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blserviceapprovalpatientdatadetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLServiceApprovalPatientDataDetails.jsp", 1742752988201L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n-----------------------------------------------------------------------------------------------\nDate       Edit History   Name        Description\n-----------------------------------------------------------------------------------------------\n19/18/18      100         Aravindh\t\tCreated\n-----------------------------------------------------------------------------------------------\nSr No       Version             Incident              SCF/CRF                        Developer Name\n1 \t\t\tV201013             IN73702            NMC-JD-CRF-0042.1         \t\t\tShikha Seth\n2 \t\t\tV201024             IN73702            NMC-JD-CRF-0042.1         \t\t\tShikha Seth\n-----------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/BillingRecordApprovalScript.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nvar ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL\t=\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\nvar PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL\t=\t\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\nvar PAYER_LOOKUP_RECORD_PREAPPROVAL\t\t\t=\t\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\t\nvar POLICY_LOOKUP_RECORD_PREAPPROVAL\t\t=\t\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\t\nvar headTop = -1;\nvar FloatHead1;\nfunction processScroll()\n\t{\n\t\tif (headTop < 0)\n\t\t{\n\t\t\tsaveHeadPos();\n\t\t\t\n\t\t}\n\t\tif (headTop>0)\n\t\t{\n\t\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\t\ttheTop = document.documentElement.scrollTop;\n\t\t\telse if (document.body)\n\t\t\t\ttheTop = document.body.scrollTop;\n\n\t\t\tif (theTop>headTop)\n\t\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\t\telse\n\t\t\t\tFloatHead1.style.top = \'0px\';\n\t\t}\n\t}\n\n\tfunction saveHeadPos()\n\t{\n\t\tparTable = document.getElementById(\"divHeadSep\");\n\t\tif (parTable != null)\n\t\t{\n\t\t\theadTop = parTable.offsetTop + 3;\n\t\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\t\tFloatHead1.style.position = \"relative\";\n\t\t}\n\t}\n\t\n\tfunction lockKey()\n\t  {\n\t\t \t \n\t\tif(event.keyCode == 93)\n\t\t\talert(\"Welcome to eHIS\");\n\t  }\n\n\t  function lockbackSpace()\n\t  {\n\t\t   var mode = document.mode.value;\n\t\t if(mode==\'modify\' && window.event.keyCode==8)\n\t\t  {\n           //return false;\n\t\t  }\n\t  }\n</script>\n</head>\n<style>\n\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 160px; \t/* must be greater than tbody*/\n\t\toverflow: auto;\n\t\tmargin: 0 auto;\n\t}\n\ttable {\n\t\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\t\tborder: none;\n\t\tbackground-color: #f7f7f7;\n\t}\n\ttable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\t\toverflow: auto; \n\t\theight: 120x;\n\t\toverflow-x: hidden;\n\t}\n\tthead tr {\n\t\tposition:relative; \n\t\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\tTD.YELLOW {\n\t\tBACKGROUND-COLOR: yellow ;\n\t\tFONT-SIZE: 8pt ;\n\t\tborder-style: dashed;\n\t\tborder-left-color: #D5E2E5;\n\t\tborder-right-color: #D5E2E5;\n\t\tborder-top-color: #D5E2E5;\n\t\tborder-bottom-color: #D5E2E5; \n\t}\n/*V201013 start*/\t\nTD.RED \n{\n  background-color:#FFFFFF;\n  COLOR:red;\n  FONT-SIZE: 8pt;\n  TEXT-ALIGN: LEFT\n}\t\n/*V201013 end*/\n</style>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body onScroll=\"processScroll()\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\">\n\t<form id=\"recordApprovalPatientData\" name=\"recordApprovalPatientData\" id=\"recordApprovalPatientData\">\t\n\t<table cellpadding=3 cellspacing=0  width=\"100%\" id=\"panel_categories_header_table\" name=\"panel_categories_header_table\" id=\"panel_categories_header_table\" border=\"1\"  >\t \n\t\t<div id=\"tableContainer\">\n\t\t<THEAD>\n\t\t<tr >\n\t\t\t<td  colspan=\'16\' class=\"columnheader\" align=\"left\">Patient Data</td>\n\t\t</tr>\n\t\t<tr style=\"background-color: white; border: none;\" id=\'trProgress\'>\n\t\t\t<td colspan=\'5\' nowrap=\"nowrap\">&nbsp;</td>\n\t\t\t<td nowrap=\"nowrap\">\n\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;cursor:pointer \">\n\t\t\t\t\t<span id=\'previousSpan\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n\t\t\t\t</span>\n\t\t\t</td>\n\t\t\t<td nowrap=\"nowrap\">\n\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;cursor:pointer \">\n\t\t\t\t\t<span id=\'nextSpan\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t</span>\n\t\t\t</td>\n\t\t\t<td colspan=\'5\' nowrap=\"nowrap\">&nbsp;</td>\n\t\t</tr>\n\t\t<TR>\t\n\t\t\t<td class=\'columnheader\'\tnowrap width=\'5%\'\talign=\"left\"\tnowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td class=\'columnheader\' \twidth=\'10%\'\talign=\"left\"\tnowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td class=\'columnheader\' \twidth=\'15%\'\talign=\"left\"\tnowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td class=\'columnheader\' \twidth=\'8%\'\talign=\"left\"\tnowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<td class=\'columnheader\' \twidth=\'8%\'\talign=\"left\"\tnowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td> \n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<td class=\'columnheader\' \twidth=\'10%\'\talign=\"left\"\tnowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td class=\'columnheader\' \twidth=\'5%\'\talign=\"left\"\tnowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td class=\'columnheader\' \twidth=\'6%\'\talign=\"left\"\tnowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t</TR>\n\t</THEAD>\n\t<TBODY style=\"height: 20px;\">\n \t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<tr onclick=\"changeFieldColor(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'); showRecordApprovalRequestDetails(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\" >\n\t\t\t<td class=\"RED\"\t width=\'5%\' nowrap id=\"srl_no";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"\t\t\t\t\tname=\"srl_no";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"\t> \t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td> \n\t\t\t<td class=\"RED\"   width=\'10%\' nowrap id=\"patient_id";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\t\t\t\tname=\"patient_id";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \t </td> \n\t\t\t<td class=\"RED\"\t width=\'15%\'  nowrap id=\"patient_name";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"\t\t\tname=\"patient_name";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </td>\n\t\t\t<td class=\"RED\"\t width=\'8%\'  nowrap id=\"episode_id";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"\t\t\t\tname=\"episode_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" </td> \n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\n\t\t\t<td class=\"RED\"\t width=\'8%\'  nowrap id=\"visitId";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"\t\t\tname=\"visitId";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\t \t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" </td>\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<td class=\"RED\"\t width=\'10%\'  nowrap id=\"age";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\t\t \t\t\t\tname=\"age";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\t \t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" </td>\n\t\t\t<td class=\"RED\"\t width=\'8%\'  nowrap id=\"mobile_number";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"\t\t\tname=\"mobile_number";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">&nbsp;\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" </td> \n\t\t\t<td class=\"RED\"\t width=\'5%\'  nowrap id=\"payer_group";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"\t\t \t\tname=\"payer_group";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td> \n\t\t\t<td class=\"RED\"\t width=\'5%\'  nowrap id=\"payer";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"\t\t \t\t\tname=\"payer";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"\t>\t    \t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t<td class=\"RED\"\t width=\'5%\'  nowrap id=\"policy";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"\t\t \t\t\tname=\"policy";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\t    \t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t<td class=\"RED\"\t width=\'6%\'  nowrap id=\"policy_effective_from";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"\tname=\"policy_effective_from";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\t    ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td> \t\t\t\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<td class=\"RED\"\twidth=\'6%\'  nowrap id=\"effective_to_fld";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" >\n\t\t\t\t<label>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</label>\n\t\t\t\t<input \ttype=\'hidden\' name=\"effective_to";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" size=\"7\" id=\"effective_to";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t\t\t\t<input  type=\'hidden\'\tname=\"effective_to_org";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" size=\"7\" id=\"effective_to_org";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"    value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\t\t\t\t\n\t\t\t\t<input type=\'hidden\'  name=\"encounterId";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"encounterId";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"> \t\t\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" >\t\t\t\t\n\t\t\t\t<input \ttype=\'text\' name=\"effective_to";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"    onBlur=\"assignEffectDate(";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="); validDateChk(this); \"  value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"  ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =">\n\t\t\t\t<input  type=\'hidden\'\tname=\"effective_to_org";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"> \t\t\t\t\t\t\t\n\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" id=\"eff__to_img";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" onClick=\"return setModifiedEffectiveToDate(";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =");\"     onKeyPress=\"return lockbackSpace();\" ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =">\t\t\t\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t\t\t\n\t\t\t<td class=\"RED\"\twidth=\'6%\'  nowrap id=\"approved_amount";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"\t\t\tname=\"approved_amount";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">&nbsp;    \t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t\t<input type=\"hidden\" name=\"expiry_date";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"expiry_date";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" size=\"7\"  value=\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="   > \t\t\t\n\t\t\t<input type=\"hidden\" \tid=\"visit_id";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" \t\t\tname=\"visit_id";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" \t \t value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" />\n\t\t\t<input type=\"hidden\" \tid=\"episode_type";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" \t\tname=\"episode_type";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" \t value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" />\n\t\t\t<input type=\"hidden\" \tid=\"priority";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" \t\t\tname=\"priority";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" />\n\t\t\t<input type=\"hidden\" \tid=\"acct_seq_no";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" \t\t\tname=\"acct_seq_no";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" />\n\t\t\t<input type=\"hidden\" \tid=\"policy_number";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" \t\tname=\"policy_number";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" \"  value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" />\t\t\t\n\t\t\t<input type=\"hidden\" \tid=\"p_payer_group";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" \t\tname=\"p_payer_group";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" />\n\t\t\t<input type=\"hidden\" \tid=\"p_payer";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" \t\t\t\tname=\"p_payer";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" />\n\t\t\t<input type=\"hidden\" \tid=\"p_policy";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" \t\t\tname=\"p_policy";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" />\n\t\t\t<input type=\"hidden\" \tid=\"rowbgColorYN";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" \t\tname=\"rowbgColorYN";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" />\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\');\" >\n\t\t\t<td class=\"fields\"\t width=\'5%\' nowrap id=\"srl_no";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td> \n\t\t\t<td class=\"fields\"   width=\'10%\' nowrap id=\"patient_id";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" \t </td> \n\t\t\t<td class=\"fields\"\t width=\'15%\'  nowrap id=\"patient_name";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" </td>\n\t\t\t<td class=\"fields\"\t width=\'8%\'  nowrap id=\"episode_id";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" </td> \n\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\n\t\t\t<td class=\"fields\"\t width=\'8%\'  nowrap id=\"visitId";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t<td class=\"fields\"\t width=\'10%\'  nowrap id=\"age";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" </td>\n\t\t\t<td class=\"fields\"\t width=\'8%\'  nowrap id=\"mobile_number";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" </td> \n\t\t\t<td class=\"fields\"\t width=\'5%\'  nowrap id=\"payer_group";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td> \n\t\t\t<td class=\"fields\"\t width=\'5%\'  nowrap id=\"payer";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t\t<td class=\"fields\"\t width=\'5%\'  nowrap id=\"policy";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t\t\t<td class=\"fields\"\t width=\'6%\'  nowrap id=\"policy_effective_from";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td> \n\t\t\t<!-- Karthik Record approval   -  MMS-QH-CRF-0165 - Starts-->\n\t\t\t\t\n\t\t\t<!-- Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if-else Starts -->\n\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t<td class=\"fields\"\twidth=\'6%\'  nowrap id=\"effective_to_fld";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >\n\t\t\t\t\n\t\t\t\t<input type=\'hidden\'  name=\"encounterId";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"> \t\t\t\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" >\n\t\t\t\t\n\t\t\t\t<input \ttype=\'text\' name=\"effective_to";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =">\n\t\t\t\t\n\t\t\t\t<input  type=\'hidden\'\tname=\"effective_to_org";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"> \t\t\t\n\t\t\t\t\n\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" id=\"eff__to_img";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =">\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t<!-- Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if-else ends -->\n\t\t\t<td class=\"fields\"\twidth=\'6%\'  nowrap id=\"approved_amount";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="   > \n\t\t\t<!-- Karthik Record approval   -  MMS-QH-CRF-0165\t-->\n\t\t\t<input type=\"hidden\" \tid=\"visit_id";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" />\n\t\t\t<input type=\"hidden\" \tid=\"p_payer_group";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" /> ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t</TBODY>\n\t\t</div>\n\t</table>\n\t\n\t\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' value=\"\" />\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" >\n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" >\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" >\n\t\t<input type=\'hidden\' name=\'requestStatus\' id=\'requestStatus\'\tid=\'requestStatus\'\t value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" >\n\t\t<input type=\'hidden\' name=\'printUCAFIndex\' id=\'printUCAFIndex\'\tid=\'printUCAFIndex\'\t value=\"-1\" >\n\t\t<input type=\'hidden\' name=\'prevIndex\' id=\'prevIndex\'\tid=\'prevIndex\'\t value=\"-1\" >\t\t\n\t\t<input type=\'hidden\' name=\'siteSpec\' id=\'siteSpec\' id=\'siteSpec\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'/>\n\t\t<!-- Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts -->\n\t\t<input type=\'hidden\' name=\'calledForm\' id=\'calledForm\'\tid=\'calledForm\'\t value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" >\n\t\t<input type=\'hidden\' name=\'service_group\' id=\'service_group\'\tid=\'service_group\'\t value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" >\n\t\t<input type=\'hidden\' name=\'service_classification\' id=\'service_classification\'\tid=\'service_classification\'\t value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" >\n\t\t<input type=\'hidden\' name=\'order_status\' id=\'order_status\'\tid=\'order_status\'\t value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" >\n\t\t<!-- Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends -->\n\t\t<input type=\'hidden\' name=\'localSessionId\' id=\'localSessionId\'\tid=\'localSessionId\'\t value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" >\n\t\t<input type=\'hidden\' name=\'patinetId\' id=\'patinetId\'\tid=\'patinetId\'\t value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" >\n\t\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\'\tid=\'episodeType\'\t value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" >\n\t\t<input type=\'hidden\' name=\'patientName\' id=\'patientName\'\tid=\'patientName\'\t value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" >\n\t\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\'\tid=\'encounterId\'\t value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" >\n\t\t<input type=\'hidden\' name=\'customerGroupCode\' id=\'customerGroupCode\'\tid=\'customerGroupCode\'\t value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" >\n\t\t<input type=\'hidden\' name=\'encounterFromDate\' id=\'encounterFromDate\'\tid=\'encounterFromDate\'\t value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" >\n\t\t<input type=\'hidden\' name=\'encounterToDate\' id=\'encounterToDate\'\tid=\'encounterToDate\'\t value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" >\n\t\t<input type=\'hidden\' name=\'customerCode\' id=\'customerCode\'\tid=\'customerCode\'\t value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" >\n\t\t<input type=\'hidden\' name=\'policyCode\' id=\'policyCode\'\tid=\'policyCode\'\t value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" >\n\t\t<input type=\'hidden\' name=\'speciality\' id=\'speciality\'\tid=\'speciality\'\t value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" >\n\t\t<input type=\'hidden\' name=\'totalMapSize\' id=\'totalMapSize\'\tid=\'totalMapSize\'\t value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" >\n\t\t<input type=\'hidden\' name=\'fromRcrd\' id=\'fromRcrd\' id=\'fromRcrd\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n\t\t<input type=\'hidden\' name=\'toRcrd\' id=\'toRcrd\' id=\'toRcrd\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'>\n\t\t<input type=\'hidden\' name=\'constCount\' id=\'constCount\' id=\'constCount\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n\t\t<input type=\'hidden\' name=\'hdnNextSpan\' id=\'hdnNextSpan\' id=\'hdnNextSpan\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'>\n\t\t<input type=\'hidden\' name=\'prevSpan\' id=\'prevSpan\' id=\'prevSpan\' value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'>\n\t\t<input type=\'hidden\' name=\'traverse\' id=\'traverse\' id=\'traverse\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>\n\t\t<input type=\'hidden\' name=\'siteApprovalStatusColorCodeYN\' id=\'siteApprovalStatusColorCodeYN\' id=\'siteApprovalStatusColorCodeYN\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'/> <!-- V201024 added -->\n</form>\t\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\t\n<script>\nparent.recordApprovalSearch.recordApproval.add_mod.disabled = false;\n\t$(document).ready(function(event){\n\t\tif($(\'#traverse\').val() == \'Y\'){\n\t\t\t$(\'#trProgress\').show();\n\t\t}else{\n\t\t\t$(\'#trProgress\').hide();\n\t\t}\n\t\t\n\t\tif($(\'#hdnNextSpan\').val() == \'Y\'){\n\t\t\t$(\'#nextSpan\').show();\n\t\t}else{\n\t\t\t$(\'#nextSpan\').hide();\n\t\t}\n\t\t\t\n\t\tif($(\'#prevSpan\').val() == \'Y\'){\n\t\t\t$(\'#previousSpan\').show();\n\t\t}else{\n\t\t\t$(\'#previousSpan\').hide();\n\t\t}\n\t\t\t\n\t\t$(\'#nextSpan\').click(function(){\n\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\tdocument.location.href = \"../../eBL/jsp/BLServiceApprovalPatientDataDetails.jsp?patinetId=\"+$(\'#patinetId\').val()+\n\t\t\t\t\t\"&episodeType=\"+$(\'#episodeType\').val()+\"&patientName=\"+$(\'#patientName\').val()+\"&encounterId=\"+$(\'#encounterId\').val()+\n\t\t\t\t\t\"&customerGroupCode=\"+$(\'#customerGroupCode\').val()+\"&encounterFromDate=\"+$(\'#encounterFromDate\').val()+\n\t\t\t\t\t\"&encounterToDate=\"+$(\'#encounterToDate\').val()+\"&customerCode=\"+$(\'#customerCode\').val()+\"&policyCode=\"+$(\'#policyCode\').val()+\n\t\t\t\t\t\"&requestStatus=\"+$(\'#requestStatus\').val()+\"&speciality=\"+$(\'#speciality\').val()+\"&servGrpCode=\"+$(\'#service_group\').val()+\n\t\t\t\t\t\"&servClsfctnCode=\"+$(\'#service_classification\').val()+\"&orderStatus=\"+$(\'#order_status\').val()+\"&calledForm=\"+$(\'#calledForm\').val()+\n\t\t\t\t\t\"&fromRcrd=\"+startFrom+\"&toRcrd=\"+endWith+\"&localSessionId=\"+$(\'#localSessionId\').val();\n\t\t});\n\t\t\n\t\t$(\'#previousSpan\').click(function(){\n\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\tvar endWith = \"\";\n\t\t\tif($(\'#toRcrd\').val() == $(\'#totalMapSize\').val()) {\n\t\t\t\tendWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#totalMapSize\').val()%$(\'#constCount\').val());\n\t\t\t} else {\n\t\t\t\tendWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\t}\n\t\t\tdocument.location.href = \"../../eBL/jsp/BLServiceApprovalPatientDataDetails.jsp?patinetId=\"+$(\'#patinetId\').val()+\n\t\t\t\t\t\"&episodeType=\"+$(\'#episodeType\').val()+\"&patientName=\"+$(\'#patientName\').val()+\"&encounterId=\"+$(\'#encounterId\').val()+\n\t\t\t\t\t\"&customerGroupCode=\"+$(\'#customerGroupCode\').val()+\"&encounterFromDate=\"+$(\'#encounterFromDate\').val()+\n\t\t\t\t\t\"&encounterToDate=\"+$(\'#encounterToDate\').val()+\"&customerCode=\"+$(\'#customerCode\').val()+\"&policyCode=\"+$(\'#policyCode\').val()+\n\t\t\t\t\t\"&requestStatus=\"+$(\'#requestStatus\').val()+\"&speciality=\"+$(\'#speciality\').val()+\"&servGrpCode=\"+$(\'#service_group\').val()+\n\t\t\t\t\t\"&servClsfctnCode=\"+$(\'#service_classification\').val()+\"&orderStatus=\"+$(\'#order_status\').val()+\"&calledForm=\"+$(\'#calledForm\').val()+\n\t\t\t\t\t\"&fromRcrd=\"+startFrom+\"&toRcrd=\"+endWith+\"&localSessionId=\"+$(\'#localSessionId\').val();\n\t\t});\n\t});\n</script>\n</body>\n";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n</html>\n\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );
	
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

	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block11Bytes, _wl_block11);

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String locale																				=	"";
String facilityId																			=	"";
String mode																					=	"";
mode																						=	"";
String isUserCanAcess																		=	"";
String bean_id																				=	"";
String bean_name																			=	"";
String patinetId																			=	"";
String episodeType																			=	"";
String patientName																			=	"";
String encounterId																			=	"";
String customerGroupCode																	=	"";
String encounterFromDate																	=	"";
String encounterToDate																		=	"";
String customerCode																			=	"";
String policyCode																			=	"";
String requestStatus																		=	"";
String speciality																			=	"";
StringBuffer sql																			=	null;
LinkedHashMap							recordPreApprovalDataMap							=	null;
Boolean siteSpec=false;

/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
String calledForm = "";
String servGrpCode = "";
String servClsfctnCode = "";
String orderStatus = "";
int totalMapSize = 0;
/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */
String operationMode = "";
String localSessionId = "";
//For Traversal
int constCount = 500;
String nextYn = "N";
String prevYn = "N";
String traversal = "N";
String fromRcrd = "";
String toRcrd = "";
int startIndex = 0;
int startRcrd = 0;
int endRcrd = 0;
int totalRecord=0;
//V201024 start
boolean siteApprovalStatusColorCode = false;
String siteApprovalStatusColorCodeYN = "N";
//V201024 end
try  
{
 	Connection con	=	ConnectionManager.getConnection(request); 
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	patinetId																				=	checkForNull(request.getParameter("patinetId"));
	episodeType																				=	checkForNull(request.getParameter("episodeType"));
	patientName																				=	checkForNull(request.getParameter("patientName"));
	encounterId																				=	checkForNull(request.getParameter("encounterId"));
	customerGroupCode																		=	checkForNull(request.getParameter("customerGroupCode"));
	encounterFromDate																		=	checkForNull(request.getParameter("encounterFromDate"));
	encounterToDate																			=	checkForNull(request.getParameter("encounterToDate"));
	customerCode																			=	checkForNull(request.getParameter("customerCode"));
	policyCode																				=	checkForNull(request.getParameter("policyCode"));
	requestStatus																			=	checkForNull(request.getParameter("requestStatus"));
	speciality																				=	checkForNull(request.getParameter("speciality"));
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
	calledForm =	checkForNull(request.getParameter("calledForm"));
	servGrpCode =	checkForNull(request.getParameter("servGrpCode"));
	servClsfctnCode =	checkForNull(request.getParameter("servClsfctnCode"));
	orderStatus =	checkForNull(request.getParameter("orderStatus"));
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */
	operationMode =	checkForNull(request.getParameter("operationMode"));
	
	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));
	
	if(!("".equals(servGrpCode)) || !("".equals(servClsfctnCode))) {
		constCount = 50;
	}
	
	if(fromRcrd == null || "".equals(fromRcrd)){
		startRcrd = 1;
	} else{
		startRcrd = Integer.parseInt(fromRcrd);
	}
		
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	} else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;
	
	sql																						=	new StringBuffer();
	recordPreApprovalDataMap																=   new LinkedHashMap();
	System.out.println("patinetId IN BLServiceApprovalPatientDataDetails:::: "+patinetId);
	System.out.println("episodeType IN BLServiceApprovalPatientDataDetails:::: "+episodeType);
	
	
	//Added By Vijay For AAKH SCF 318
	try
	{
		con = ConnectionManager.getConnection();	
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","RECAPPR_SHW_ALL_WEN_LMT_CROSD");
		System.out.println("BLServiceApprovalPatientDataDetails.jsp->SiteSpec "+siteSpec);
	} catch(Exception e) {
		System.out.println("BLServiceApprovalPatientDataDetails.jsp->Exception in site specific "+e);
		e.printStackTrace();
	}
	//V201024 start
	try {		
		siteApprovalStatusColorCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","APPROVAL_STATUS_COLORCODE");
		if(siteApprovalStatusColorCode){
			siteApprovalStatusColorCodeYN ="Y";
		} else{
			siteApprovalStatusColorCodeYN ="N";
		}		
	} catch(Exception ex) {
		ex.printStackTrace();
	}
	//V201024 end
	if("search".equals(operationMode)) {
		String sqlQuery = "SELECT Sys_Context('USERENV', 'SESSIONID') FROM DUAL";
		Statement stmt = con.createStatement();
		ResultSet rst = stmt.executeQuery(sqlQuery);
		if(rst.next()) {
			localSessionId = rst.getString(1);
		}
	} else {
		localSessionId = checkForNull(request.getParameter("localSessionId"));
	}
	
	bean_id																					= 	"RecordApprovalPatientDataBean" ;
	bean_name																				= 	"eBL.RecordApprovalPatientDataBean";
	RecordApprovalPatientDataBean recordApprovalPatientDataBean								= 	(RecordApprovalPatientDataBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	System.out.println("facilityId IN BLServiceApprovalPatientDataDetails:::: "+facilityId);
	recordPreApprovalDataMap																=	recordApprovalPatientDataBean.getRecordPreApprovalData(patinetId,patientName,speciality,policyCode,encounterToDate,encounterFromDate,customerCode,customerGroupCode,encounterId, episodeType,requestStatus,facilityId, locale, servGrpCode, servClsfctnCode, orderStatus, calledForm, operationMode, localSessionId, startRcrd, endRcrd);		
	 
	//totalRecord = recordPreApprovalDataMap.size();
	
	String sqlTotalCount = "select count(*) from bl_service_status_screen_tmp where SESSION_ID = "+localSessionId;
	Statement stmt = con.createStatement();
	ResultSet rst = stmt.executeQuery(sqlTotalCount);
	if(rst.next()) {
		totalRecord = rst.getInt(1);
	}
	
	if(startRcrd>1){
		prevYn = "Y";
		traversal = "Y";
	}
	
	if((startRcrd+constCount) <= totalRecord){
		nextYn = "Y";
		traversal = "Y";
	}	

	//For Traversal

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 
			if(!siteSpec){
			
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

	
		//Iterator iterator= recordPreApprovalDataMap.keySet().iterator();
 		Set<String> mapKeySet = recordPreApprovalDataMap.keySet();
		String isDisabled="disabled";
		String isReadOnly="readonly onfocus='this.blur()'";

		//Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if condition
		totalMapSize = recordPreApprovalDataMap.keySet().size();
		if(totalMapSize <= 0) {
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
		}
		
		//while(iterator.hasNext())
		if(endRcrd > totalRecord) {
			endRcrd = totalRecord;
		}
		System.out.println("BLServiceApprovalPatientDataDetails.jsp-> startRcrd: "+startRcrd+", endRcrd: "+endRcrd);
		
		for(int i = 0; i < totalMapSize; i++)
		{
			//int index =    (Integer)iterator.next();
			int index =		i;
			int sNo	  =		startRcrd + index;
			recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) recordPreApprovalDataMap.get(index);  
			
			/* Karthik Record approval   -  MMS-QH-CRF-0165 - Starts */
			String policyExpiryDate="";
			PreparedStatement pstmtChrg = con.prepareStatement(
			"  select to_char(POLICY_EXPIRY_DATE,'dd/mm/yyyy') from BL_ENCOUNTER_PAYER_PRIORITY "+
										 " WHERE patient_id = ? "+
										 " AND operating_facility_id = ? "+
										 " AND acct_seq_no = ? "+
										 " AND policy_type_code = ? "+
										 " AND policy_number = ? "+
										 " AND cust_code = ? "+
										 " AND cust_group_code = ?  "
										);

			pstmtChrg.setString(1,recordApprovalPatientDataBean.getPatientId()!=null?recordApprovalPatientDataBean.getPatientId():"");
			pstmtChrg.setString(2,(String) session.getValue("facility_id"));
			pstmtChrg.setString(3,recordApprovalPatientDataBean.getAccountSequenceNO()!=null?recordApprovalPatientDataBean.getAccountSequenceNO():"");
			pstmtChrg.setString(4,recordApprovalPatientDataBean.getPolicy()!=null?recordApprovalPatientDataBean.getPolicy():"");
			pstmtChrg.setString(5,recordApprovalPatientDataBean.getPolicyNumber()!=null?recordApprovalPatientDataBean.getPolicyNumber():"");
			pstmtChrg.setString(6,recordApprovalPatientDataBean.getPayer()!=null?recordApprovalPatientDataBean.getPayer():"");
			pstmtChrg.setString(7,recordApprovalPatientDataBean.getPayerGroup()!=null?recordApprovalPatientDataBean.getPayerGroup():"");
			ResultSet rsChrg = pstmtChrg.executeQuery() ;
			if( rsChrg != null ) 
			{	
				if( rsChrg.next() )
				{  
					policyExpiryDate = rsChrg.getString(1);
					if(policyExpiryDate==null) policyExpiryDate="";
				}
			}
			if (rsChrg != null) rsChrg.close();
			if (pstmtChrg != null)  pstmtChrg.close();
			/* Karthik Record approval   -  MMS-QH-CRF-0165 - Ends*/
		/*V201014 start*/
			String 	rowbgColorYN = recordApprovalPatientDataBean.getColorStatus();	//shikha
			if (!siteApprovalStatusColorCode)  rowbgColorYN = "N"; //V201024 added
	
            _bw.write(_wl_block25Bytes, _wl_block25);
if(rowbgColorYN.equals("Y")) { 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(index+1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(index));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(index));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPatientId()					!=null ? recordApprovalPatientDataBean.getPatientId()				: 	"" ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPatientName()	 			!=null 	? 	recordApprovalPatientDataBean.getPatientName()			: 	"" ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordApprovalPatientDataBean.getEpisodeId() 					!=null 	? 	recordApprovalPatientDataBean.getEpisodeId()			: 	"" ));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(!siteSpec){ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(index));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(index));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recordApprovalPatientDataBean.getVisitId()				!=null 	? 	recordApprovalPatientDataBean.getVisitId()			: 	"" ));
            _bw.write(_wl_block42Bytes, _wl_block42);
} 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recordApprovalPatientDataBean.getAge()						!=null 	? 	recordApprovalPatientDataBean.getAge		()			: 	"" ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(index));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(recordApprovalPatientDataBean.getMobileNumber()				!=null 	? 	recordApprovalPatientDataBean.getMobileNumber()			: 	"" ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(index));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayerGroupShortName()  			!=null 	? 	recordApprovalPatientDataBean.getPayerGroupShortName()			: 	"" ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayerShortName()						!=null 	? 	recordApprovalPatientDataBean.getPayerShortName()				: 	"" ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(index));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyShortName()						!=null 	? 	recordApprovalPatientDataBean.getPolicyShortName()				: 	"" ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(index));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(index));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveFrom()		!=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveFrom()	: 	"" ));
            _bw.write(_wl_block60Bytes, _wl_block60);
if(calledForm.equals("serviceApprStatus")) { 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(isReadOnly));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(index));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(index));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(index));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(index));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordApprovalPatientDataBean.getEncounterId() !=null 	? 	recordApprovalPatientDataBean.getEncounterId(): "" ));
            _bw.write(_wl_block72Bytes, _wl_block72);

			} else {
			
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(isReadOnly));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(index));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(isDisabled));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(index));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(index));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(index));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordApprovalPatientDataBean.getEncounterId() !=null 	? 	recordApprovalPatientDataBean.getEncounterId(): "" ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(isDisabled));
            _bw.write(_wl_block81Bytes, _wl_block81);
} 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(index));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(recordApprovalPatientDataBean.getApprovedAmount()				!=null 	? 	recordApprovalPatientDataBean.getApprovedAmount()		: 	"" ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(index));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(index));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyExpDate() !=null 	? 	recordApprovalPatientDataBean.getPolicyExpDate(): "" ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(index));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(index));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recordApprovalPatientDataBean.getVisitId()					!=null 	? 	recordApprovalPatientDataBean.getVisitId()				: 	"" ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(index));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(index));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(episodeType					 								!=null 	? 	episodeType												: 	"" ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(index));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(index));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPriority()					!=null 	? 	recordApprovalPatientDataBean.getPriority()				: 	"" ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(index));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(index));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(recordApprovalPatientDataBean.getAccountSequenceNO() 		!=null 	? 	recordApprovalPatientDataBean.getAccountSequenceNO()	: 	"" ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(index));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyNumber()				!=null 	? 	recordApprovalPatientDataBean.getPolicyNumber()			: 	"" ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(index));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayerGroup()				!=null 	? 	recordApprovalPatientDataBean.getPayerGroup()			: 	"" ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(index));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayer()				!=null 	? 	recordApprovalPatientDataBean.getPayer()			: 	"" ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(index));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicy()				!=null 	? 	recordApprovalPatientDataBean.getPolicy()			: 	"" ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(index));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(rowbgColorYN ));
            _bw.write(_wl_block109Bytes, _wl_block109);
} else { /*V201013 end*/
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(index+1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(index));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(index));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(index));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPatientId()					!=null ? recordApprovalPatientDataBean.getPatientId()				: 	"" ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(index));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPatientName()	 			!=null 	? 	recordApprovalPatientDataBean.getPatientName()			: 	"" ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordApprovalPatientDataBean.getEpisodeId() 					!=null 	? 	recordApprovalPatientDataBean.getEpisodeId()			: 	"" ));
            _bw.write(_wl_block114Bytes, _wl_block114);
if(!siteSpec){ 
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(index));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(index));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recordApprovalPatientDataBean.getVisitId()				!=null 	? 	recordApprovalPatientDataBean.getVisitId()			: 	"" ));
            _bw.write(_wl_block42Bytes, _wl_block42);
} 
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(index));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recordApprovalPatientDataBean.getAge()						!=null 	? 	recordApprovalPatientDataBean.getAge		()			: 	"" ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(index));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(recordApprovalPatientDataBean.getMobileNumber()				!=null 	? 	recordApprovalPatientDataBean.getMobileNumber()			: 	"" ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(index));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(index));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayerGroupShortName()  			!=null 	? 	recordApprovalPatientDataBean.getPayerGroupShortName()			: 	"" ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayerShortName()						!=null 	? 	recordApprovalPatientDataBean.getPayerShortName()				: 	"" ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyShortName()						!=null 	? 	recordApprovalPatientDataBean.getPolicyShortName()				: 	"" ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(index));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveFrom()		!=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveFrom()	: 	"" ));
            _bw.write(_wl_block122Bytes, _wl_block122);
if(calledForm.equals("serviceApprStatus")) { 
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(isReadOnly));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(index));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(index));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(index));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(index));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordApprovalPatientDataBean.getEncounterId() !=null 	? 	recordApprovalPatientDataBean.getEncounterId(): "" ));
            _bw.write(_wl_block125Bytes, _wl_block125);

			} else {
			
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(index));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(isReadOnly));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(index));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(isDisabled));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(index));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(index));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" ));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(index));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordApprovalPatientDataBean.getEncounterId() !=null 	? 	recordApprovalPatientDataBean.getEncounterId(): "" ));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(isDisabled));
            _bw.write(_wl_block129Bytes, _wl_block129);
} 
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(index));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(recordApprovalPatientDataBean.getApprovedAmount()				!=null 	? 	recordApprovalPatientDataBean.getApprovedAmount()		: 	"" ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(index));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(index));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyExpDate() !=null 	? 	recordApprovalPatientDataBean.getPolicyExpDate(): "" ));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(index));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(index));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recordApprovalPatientDataBean.getVisitId()					!=null 	? 	recordApprovalPatientDataBean.getVisitId()				: 	"" ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(index));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(index));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(episodeType					 								!=null 	? 	episodeType												: 	"" ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(index));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(index));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPriority()					!=null 	? 	recordApprovalPatientDataBean.getPriority()				: 	"" ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(index));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(index));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(recordApprovalPatientDataBean.getAccountSequenceNO() 		!=null 	? 	recordApprovalPatientDataBean.getAccountSequenceNO()	: 	"" ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(index));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicyNumber()				!=null 	? 	recordApprovalPatientDataBean.getPolicyNumber()			: 	"" ));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(index));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayerGroup()				!=null 	? 	recordApprovalPatientDataBean.getPayerGroup()			: 	"" ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(index));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayer()				!=null 	? 	recordApprovalPatientDataBean.getPayer()			: 	"" ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(index));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicy()				!=null 	? 	recordApprovalPatientDataBean.getPolicy()			: 	"" ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(index));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(rowbgColorYN ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            _bw.write(_wl_block134Bytes, _wl_block134);

		} /*V201013 added*/
		}		
		
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(requestStatus));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(siteSpec ));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(calledForm ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(servGrpCode ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(servClsfctnCode ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(orderStatus ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(localSessionId ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(patinetId ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(episodeType ));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(patientName ));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(customerGroupCode ));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(encounterFromDate ));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(encounterToDate ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(customerCode ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(policyCode ));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(requestStatus ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(speciality ));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(totalRecord ));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(startRcrd ));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(endRcrd ));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(constCount ));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(nextYn ));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(prevYn ));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(traversal));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(siteApprovalStatusColorCodeYN ));
            _bw.write(_wl_block163Bytes, _wl_block163);

}
catch(Exception e)
{
	System.err.println("Exception in BLServiceApprovalPatientDataDetails.jsp:: "+e);
	e.printStackTrace();
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block164Bytes, _wl_block164);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SrlNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitID.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PayerGroup.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveFrom.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveTo.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
