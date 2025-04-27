package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import eBL.PreApprovalRequestDetailsBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __billingpreapprovalrequeststatusdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillingPreApprovalRequestStatusDetails.jsp", 1737913045604L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n-----------------------------------------------------------------------------------------------\nDate       \tEdit History   \t\tName        Description\n-----------------------------------------------------------------------------------------------\n16/04/2018      100         Subha Sundari M  created\n\nSr No       Version             Incident              SCF/CRF                        Developer Name\n1 \t\t\tV201013             IN73702            NMC-JD-CRF-0042.1         \t\t\tShikha Seth\n2 \t\t\tV201024             IN73702            NMC-JD-CRF-0042.1         \t\t\tShikha Seth\n-----------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n<html>\n<head>\n<style>\n\t.billApproved{\n\t\twidth: 12.5px;\n\t\theight: 12.5px;\n\t\tbackground: red;\n\t}\n</style>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\t\n<script language=\"JavaScript\" src=\"../../eBL/js/BillingRecordApprovalScript.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\tvar ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\tvar PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\n\tvar PAYER_LOOKUP_RECORD_PREAPPROVAL\t\t\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\t\n\tvar POLICY_LOOKUP_RECORD_PREAPPROVAL\t\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\t\n\tvar PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP\t\t\t\t\t=\t\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\tvar PRE_APPROVAL_REQUEST_BILLINGSERVICECODE_LOOKUP\t\t\t=\t\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\tvar headTop = -1;\n\tvar FloatHead1;\nfunction processScroll()\n{\n\tif (headTop < 0)\n\t{\n\t\tsaveHeadPos();\t\t\n\t}\n\tif (headTop>0)\n\t{\n\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\ttheTop = document.documentElement.scrollTop;\n\t\telse if (document.body)\n\t\t\ttheTop = document.body.scrollTop;\n\n\t\tif (theTop>headTop)\n\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\telse\n\t\t\tFloatHead1.style.top = \'0px\';\n\t}\n}\n\nfunction saveHeadPos()\n{\n\tparTable = document.getElementById(\"divHeadSep\");\n\tif (parTable != null)\n\t{\n\t\theadTop = parTable.offsetTop + 3;\n\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\tFloatHead1.style.position = \"relative\";\n\t}\n}\n\nfunction lockKey()\n{\t \n\tif(event.keyCode == 93)\n\talert(\"Welcome to eHIS\");\n}\n</script>\n</head>\n<style>\n\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 160px; \t/* must be greater than tbody*/\n\t\toverflow: auto;\n\t\tmargin: 0 auto;\n\t}\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\t\t\n</style>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n<body onScroll=\"processScroll()\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\">\n\t<form id=\"BillingPreApprovalRequestDetailsForm\" name=\"BillingPreApprovalRequestDetailsForm\" id=\"BillingPreApprovalRequestDetailsForm\">\t\n\t<table align=\'center\'  cellpadding=3 cellspacing=0  width=\'100%\' id=\"record_approval_details_table\" name=\"record_approval_details_table\" id=\"record_approval_details_table\" border=\"1\">\t\t \n\t<div id=\"tableContainer\">\n\t<thead>\n\t<tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t \n \t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap  width=\"3%\"  align=\"left\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \t\n\t<th class=\'CAFLOWSHEETLEVEL1\'\tnowrap\twidth=\"9%\"\talign=\"left\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"7%\" \talign=\"left\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"7%\" \talign=\"left\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>  \n\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"8%\" \talign=\"left\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"6%\" \talign=\"left\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"5%\" \talign=\"left\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>  \n\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"7%\" \talign=\"left\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t<th class=\'CAFLOWSHEETLEVEL1\' \tnowrap\twidth=\"4%\" \talign=\"left\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t</tr>\n\t<!-- Added by Aravindh/11-05-2018/MMS-DM-CRF-0125 -->\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td><input type=\'text\' name=\'encounterIdFilter\' id=\'encounterIdFilter\' id=\'encounterIdFilter\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'></td>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<td  nowrap>\n\t\t\t<select name=\'criteriaFilter\' id=\'criteriaFilter\' style=\"width: 120px;\">\t\t\n\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' selected>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t</select>\n\t\t</td>\n\t\t<td  nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'bg_code_filter\' name=\'bg_code_filter\' id=\'bg_code_filter\' size=\'10\'   value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onblur=\"if(this.value!=\'\'){ callBGDescCode(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_desc_filter); } \" >\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'bg_desc_filter\' name=\'bg_desc_filter\' id=\'bg_desc_filter\'  size=\'10\'  value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' onblur=\"if(this.value!=\'\'){ callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_code_filter); }\">\n\t\t\t<input type=\'button\' id=\'bg_but_filter\' value=\'?\'  onclick=\'callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter)\' >\t\t\t\t\t\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'serviceDate_filter\' name=\'serviceDate_filter\' id=\'serviceDate_filter\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' size=\'8\' onblur=\'isValidDate(this);\'>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'serviceDate_ctrl_filter\' onClick=\'return showCalendar(\"serviceDate_filter\")\' />\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<td nowrap align=\"left\">\n\t\t\t \t<input type=\'text\' id=\'orderStatusFilter\' name=\'orderStatusFilter\' id=\'orderStatusFilter\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' size=\'8\' onblur=\'\'>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'serviceAmount_filter\' name=\'serviceAmount_filter\' id=\'serviceAmount_filter\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'serviceQuantity_filter\' name=\'serviceQuantity_filter\' id=\'serviceQuantity_filter\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprReqDate_filter\' name=\'apprReqDate_filter\' id=\'apprReqDate_filter\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' size=\'8\' onblur=\'isValidDate(this);\'>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'apprReqDate_ctrl_filter\' onClick=\'return showCalendar(\"apprReqDate_filter\")\' />\t\t\t\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprGvnDate_filter\' name=\'apprGvnDate_filter\' id=\'apprGvnDate_filter\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' size=\'8\' onblur=\'isValidDate(this);\'>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'apprGvnDate_ctrl_filter\' onClick=\'return showCalendar(\"apprGvnDate_filter\")\' />\t\t\t\t\t\t\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprNo_filter\' name=\'apprNo_filter\' id=\'apprNo_filter\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap>\n\t\t\t<select id=\"approval_status_filter\"\tname=\"approval_status_filter\" id=\"approval_status_filter\" style=\"width: 60px;\">\n\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t\t<option value=\"A\"  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" >Approved</option>\n\t\t\t\t<option value=\"R\" ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" >Rejected</option>\n\t\t\t\t<option value=\"P\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" >Pending</option>\n\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" >Send to Insurance</option>\n\t\t\t\t<option value=\"H\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" >Hold</option>\n\t\t\t\t<option value=\"C\" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" >Clarification</option>\t\t\t\t\n\t\t\t</select>\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprQty_filter\' name=\'apprQty_filter\' id=\'apprQty_filter\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap align=\"left\">\n\t\t\t<input type=\'text\' id=\'apprAmt_filter\' name=\'apprAmt_filter\' id=\'apprAmt_filter\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' size=\'10\' >\n\t\t</td>\n\t\t<td nowrap>\n\t\t\t<input type=\'text\' id=\'reason_filter\' name=\'reason_filter\' id=\'reason_filter\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' size=\'10\' >\n\t\t\t<input type=\'hidden\' id=\'reason_hdn_filter\' name=\'reason_hdn_filter\' id=\'reason_hdn_filter\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' >\n\t\t\t&nbsp;\n\t\t\t<input type=\'button\' class=\'button\' name=\"reason_lookup_filter\" id=\"reason_lookup_filter\" id=\"reason_lookup_filter\" value=\'?\' onClick=\"reasonCodeLookupFilter(reason_filter,reason_hdn_filter)\" \t/>\n\t\t</td>\n\t\t<td nowrap>\n\t\t\t<input type=\'text\' id=\'remarks_filter\' name=\'remarks_filter\' id=\'remarks_filter\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' size=\'10\' >\n\t\t</td>\n\t</tr>\n\t</thead>\n\t\n\t<TBODY style=\"height: 20px;\">\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t<tr> \n\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t<td nowrap class=\"fields\" \twidth=\"10%\"\t><label name=\"encounter_id";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"encounter_id";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" title=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"  >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</label></td>\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\n\t\t<td  nowrap class=\"fields\" \twidth=\"10%\"\t\t>\n\t\t\t<label id=\"included_excluded";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"\tname=\"included_excluded";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" style=\"width: 120px;\" title=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</label>\n\t\t</td>\n\t\t<td nowrap class=\"fields\"\twidth=\"7%\" \t\t>\t\t\t\t\n\t\t<input type=\"hidden\"\tid=\"billing_service_code";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"\t\t\t\tname=\"billing_service_code";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"\t\ttitle=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" \t\tvalue=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"  />\n\t\t<label\tid=\"billing_service_display";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"\t\t\t\tname=\"billing_service_display";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&nbsp;</label>\n\t\t</td>\n\t\t<td nowrap class=\"fields\"\twidth=\"7%\" \t\t><label id=\"billing_service_desc";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"\t\t\t\tname=\"billing_service_desc";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" \t\ttitle=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="&nbsp;</label></td>\n\t\t<td nowrap class=\"fields\" \twidth=\"8%\"\t\t>\n\t\t<input type=\"hidden\" name=\"p_service_date";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"p_service_date";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"  value =\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\n\t\t<label id=\"service_date";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"\t\t\t\t\t\tname=\"service_date";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"\t\t  \t\ttitle=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" \t\t>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</label></td> \n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t<td nowrap class=\"fields\" \twidth=\"8%\"><label id=\"order_status";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"\t\t\t\t\t\tname=\"order_status";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</label></td> \t\t\t\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t<td nowrap class=\"fields\" \twidth=\"7%\"\tstyle=\"text-align: right\"><label id=\"available_service_amount";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"\t\t\tname=\"available_service_amount";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"\ttitle=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" \t >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</label></td>\n\t\t <td nowrap class=\"fields\" \twidth=\"7%\"\tstyle=\"text-align: right\"><label id=\"available_service_qty";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"\t\t\tname=\"available_service_qty";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</label></td>\n\t\t<td nowrap class=\"fields\" \twidth=\"8%\"\t\t>\n\t\t<input type=\"hidden\" name=\"p_app_req_date";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"p_app_req_date";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\n\t\t<label id=\"app_req_date";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"\t name=\"app_req_date";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"\t\t\t\ttitle=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" \t\t >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</label>\n\t\t</td>\n\t\t<td nowrap class=\"fields\" \twidth=\"8%\"\t\t>\n\t\t<input type=\"hidden\" name=\"p_approved_date";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"p_approved_date";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t<label id=\"approved_date";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"\t\t\t\t\tname=\"approved_date";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"\t\t\t\ttitle=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' \t\t>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</label>\n\t\t</td>\n\t\t<td nowrap class=\"fields\" \twidth=\"6%\"\t\t>\n\t\t<input type=\"hidden\" name=\"p_approval_number";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" id=\"p_approval_number";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t<label id=\"approval_number";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"\t\t\t\t\tname=\"approval_number";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"\t\t\ttitle=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</label></td>\n\t\t\n\t\t<td nowrap class=\"fields\" \twidth=\"5%\"\t\t>\n\t\t<input type=\"hidden\" name=\"p_approval_status";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" id=\"p_approval_status";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t<label ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" id=\"pp_approval_status";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" name=\"pp_approval_status";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" >Pending</label>\n\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" >Approved</label>\n\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >Rejected</label>\n\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" >Send to Insurance</label>\n\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" >Hold</label>\n\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" >Clarification</label>\n\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >&nbsp;</label>\n\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\n\t\t<input type=\"hidden\" name=\"approvalstatus_hdn";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"approvalstatus_hdn";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t\t</td>\n\t\t\n\t\t<td nowrap class=\"fields\" \twidth=\"6%\"\t\t><input type=\"hidden\" name=\"p_approvedQty";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" id=\"p_approvedQty";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t<label id=\"approvedQty";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"\t\t\t\t\tname=\"approvedQty";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</label></td>\n\t\t<td nowrap class=\"fields\" \twidth=\"7%\"\t\t><input type=\"hidden\" name=\"p_approvedAmount";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"p_approvedAmount";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t<label id=\"approvedAmount";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"\t\t\t\t\tname=\"approvedAmount";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</label></td>\t\t\t\t \n\t\t<td nowrap class=\"fields\" \twidth=\"7%\"\t\t><input type=\"hidden\" name=\"p_reason";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" id=\"p_reason";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t<label id=\"reason";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"\t\t\t\t\t\t\tname=\"reason";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"\t\t\t\t\t\ttitle=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</label></td>\n\t\t<td nowrap class=\"fields\" \twidth=\"4%\"\t\t><input type=\"hidden\" name=\"p_approval_remarks";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" id=\"p_approval_remarks";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t<label id=\"approval_remarks";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"\t\t\t\t\tname=\"approval_remarks";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</label></td> \n\t\t\t\t \n\t\t <input type=\"hidden\"   id=\"effective_from";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" \t\t\t\tname=\"effective_from";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"  \t\t\tvalue=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" />\n\t\t <input type=\"hidden\"   id=\"effective_to";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" \t\t\t\tname=\"effective_to";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"  \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" />\n\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t <input type=\"hidden\"   id=\"patient_class";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" \t\t\t\tname=\"patient_class";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" />\n\t\t <input type=\"hidden\"   id=\"episode_encounter_flag";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"\t\tname=\"episode_encounter_flag";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\"  \tvalue=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" />\n\t\t <input type=\"hidden\"   id=\"clinic_nursing_ind";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" \t\t\tname=\"clinic_nursing_ind";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\"  \t\tvalue=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" />\n\t\t <input type=\"hidden\"   id=\"clinic_nursing_code";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" \t\t\tname=\"clinic_nursing_code";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" />\n\t\t <input type=\"hidden\"   id=\"specilaity_code";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" \t\t\t\tname=\"specilaity_code";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" />\n\t\t <input type=\"hidden\"   id=\"preapproval_amt_capping";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" \t\tname=\"preapproval_amt_capping";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" />\n\t\t <input type=\"hidden\"   id=\"preapproval_qty_capping";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" \t\tname=\"preapproval_qty_capping";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" />\n\t\t <input type=\"hidden\"   id=\"service_level_approval";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" \t\tname=\"service_level_approval";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" />\n\t\t <input type=\"hidden\"   id=\"preapproval_amt_gross_net";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\"\tname=\"preapproval_amt_gross_net";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\"  value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" />\n\t\t <input type=\"hidden\"   id=\"utilized_qty";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" \t\t\t\tname=\"utilized_qty";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" />\n\t\t <input type=\"hidden\"   id=\"sex";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" \t\t\t\t\t\t\tname=\"sex";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\"  \t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" />\n\t\t <input type=\"hidden\"   id=\"age_group_code";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" \t\t\t\tname=\"age_group_code";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" />\n\t\t <input type=\"hidden\"   id=\"primary_key_facility_id";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" \t\tname=\"primary_key_facility_id";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" />\n\t\t <input type=\"hidden\"   id=\"primary_key_module_id";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" \t\tname=\"primary_key_module_id";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" />\n\t\t <input type=\"hidden\"   id=\"primary_key_main";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" \t\t\tname=\"primary_key_main";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" />\n\t\t <input type=\"hidden\"   id=\"primary_key_line_no";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" \t\t\tname=\"primary_key_line_no";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" />\n\t\t <input type=\"hidden\"   id=\"primary_key_bling_service_code";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" name=\"primary_key_bling_service_code";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" />\n\t\t <input type=\"hidden\"   id=\"primary_key_service_item_code";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" name=\"primary_key_service_item_code";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\"   value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" />\n\t\t <input type=\"hidden\"   id=\"billApprovedYn";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" name=\"billApprovedYn";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" />\t\n \n\n\t\t ";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\t\t\n\t\t\t</tr> \n\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\t\n\t<!-- </div>  -->\t\n</table>\n<input type=\'hidden\' name=\'authorisecheck\' id=\'authorisecheck\'\tid=\'authorisecheck\' value=\"\" >\n<input type=\'hidden\' name=\'locale\' id=\'locale\'\tid=\'locale\' value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" >\n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\'\tid=\'facilityId\' value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" >\n<input type=\'hidden\' name=\'mode\' id=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" >\n<input type=\'hidden\' name=\'isUserCanAcess\' id=\'isUserCanAcess\' \tid=\'isUserCanAcess\'\tvalue=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" />\n<input type=\'hidden\' name=\'authorized\' id=\'authorized\' \tid=\'authorized\'\t value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" />\n<input type=\'hidden\' name=\'patinetId\' id=\'patinetId\' \tid=\'patinetId\'\tvalue=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" >\n<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' id=\'episodeType\'\tvalue=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" >\n<input type=\'hidden\' name=\'visitId\' id=\'visitId\'  id=\'visitId\'\t\tvalue=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\" >\n<input type=\'hidden\' name=\'priority\' id=\'priority\' \tid=\'priority\'\tvalue=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" />\n<input type=\'hidden\' name=\'acctSeqNo\' id=\'acctSeqNo\' \tid=\'acctSeqNo\'\tvalue=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" />\n<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' id=\'encounterId\' value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" >\n<input type=\'hidden\' name=\'policyTypeCode\' id=\'policyTypeCode\' id=\'policyTypeCode\' value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" >\n<input type=\'hidden\' name=\'custGroupCode\' id=\'custGroupCode\' id=\'custGroupCode\' value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" >\n<input type=\'hidden\' name=\'custCode\' id=\'custCode\' id=\'custCode\'\tvalue=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" />\n<input type=\'hidden\' name=\'policyNumber\' id=\'policyNumber\' id=\'policyNumber\' value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\" />\n<input type=\'hidden\' name=\'episodeId\' id=\'episodeId\' \tid=\'episodeId\'\tvalue=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" />\n<input type=\'hidden\' name=\'copyIndex\' id=\'copyIndex\' id=\'copyIndex\' value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\"\t/ >\n<input type=\'hidden\' name=\'approvedAmount\' id=\'approvedAmount\' id=\'approvedAmount\' value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\"\t/ >\n<input type=\'hidden\' name=\'requestStatus\' id=\'requestStatus\' id=\'requestStatus\' value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\"\t/ >\n<input type=\'hidden\' name=\'rowCount\' id=\'rowCount\' id=\'rowCount\' / >\n<input type=\'hidden\' name=\'prevRow\' id=\'prevRow\'\tid=\'prevRow\' / >\n<input type=\'hidden\' name=\'recalc_charges\' id=\'recalc_charges\'\tid=\'prevRow\' / >\n<input type=\'hidden\'  name =\'sys_date\'\tvalue = \"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\" />\n<input type=\'hidden\' name=\'siteId\' id=\'siteId\' id =\'siteId\' value=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\' />\n<input type=\'hidden\' name=\'expiryDate\' id=\'expiryDate\' id =\'expiryDate\' value=\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\' />\t <!--Karthik Record approval   -  MMS-QH-CRF-0165 - Starts  -->\n<input type=\'hidden\' name=\'effectiveTo\' id=\'effectiveTo\' id =\'effectiveTo\' value=\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\' />\t \n<!-- Record approval   -  MMS-QH-CRF-0165 - Starts -->\n<input type=\'hidden\' name=\'disableVal\' id=\'disableVal\' id=\'disableVal\' value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\"\t/ >\n<input type=\'hidden\' name=\'effectiveToModified\' id=\'effectiveToModified\' id=\'effectiveToModified\' value=\'\'\t/ >\n<input type=\'hidden\' name=\'sysDateTime\' id=\'sysDateTime\' id=\'sysDateTime\' value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\' />\n<input type=\'hidden\' name=\'authorise_check_billed\' id=\'authorise_check_billed\' id=\'authorise_check_billed\' value=\'N\' />\n<input type=\'hidden\' name=\'user_id\' id=\'user_id\' id=\'user_id\' value=\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\' />\n<input type=\'hidden\' name=\'approvalstatus_hdn\' id=\'approvalstatus_hdn\' id=\'approvalstatus_hdn\' value=\'\' />\n<input type=\'hidden\' name=\'site_spec\' id=\'site_spec\' id=\'site_spec\' value=\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'/>\n<input type=\'hidden\' name=\'authorizedUserId\' id=\'authorizedUserId\' id=\'authorizedUserId\' value=\'\'>\n<input type=\'hidden\' name=\'site3TierAlmoFeatureYN\' id=\'site3TierAlmoFeatureYN\' id=\'site3TierAlmoFeatureYN\' value=\'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\'/>\n<input type=\'hidden\' name=\'siteApprovalStatusColorCodeYN\' id=\'siteApprovalStatusColorCodeYN\' id=\'siteApprovalStatusColorCodeYN\' value=\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\'/>\n\t\t \n";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t<script>initiateAuthorization();</script>\n";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\n</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\t\n</body>\n</TBODY>\n</div>\n</body>\n";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n</html>\n\n";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            out.print( String.valueOf(BlRepository.getBlKeyValue("PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PRE_APPROVAL_REQUEST_BILLINGSERVICECODE_LOOKUP")));
            _bw.write(_wl_block13Bytes, _wl_block13);

	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	//String applyMode=	new String();
	String locale		=	"";
	String facilityId	=	"";
	String mode		=	"";
	mode			=	"";
	String isUserCanAcess	=	"";
	String bean_id	=	"";
	String bean_name=	"";
	//String modifyStatus   =	"";
	String patinetId=	"";
	String episodeType=	"";
	String episodeId=	"";
	String visitId	=	"";
	String priority	=	"";
	String acctSeqNo=	"";
	//String authorized=	"";
	String encounterId=	"";
	//String billingGrpId=	"";
	String policyTypeCode	=	"";
	String custGroupCode   	=	"";
	String custCode   =	"";
	String policyNumber=	"";
	String copyIndex=	"";
	String requestStatus	=	"";
	String approvedAmount	=	"";
	String disable	=	"DISABLED";

	String criteriaFilter = "";
	String bg_code_filter = "";
	String bg_desc_filter = "";
	String serviceDate_filter = "";
	String serviceAmount_filter = "";
	String serviceQuantity_filter = "";
	String apprReqDate_filter = "";
	String apprGvnDate_filter = "";
	String apprNo_filter = "";
	String approval_status_filter = "";
	String apprQty_filter = "";
	String apprAmt_filter = "";
	String reason_filter = "";
	String reason_hdn_filter = "";
	String remarks_filter = "";
	String userAuthorization = "";
	String encounterIdFilter=""; // Added by Vijay for mms crf 0077
	String orderStatusFilter=""; // Added by Vijay for mms crf 0077
	String siteId = "";
	String enabValue=""; 		//pradeepa - CRF 0165 Record approval
	String siteSpec="";		

	LinkedHashMap preApprovalRequestDetailsDataMap				=	null;
	//ArrayList<String[]>		preApprovalRequestDetailsList		=	null;

	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
	String calledForm = "";
	String servGrpCode = "";
	String servClsfctnCode = "";
	String orderStatus = "";
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */

	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	String sysDateTime = "";

	String	strLoggedUser	=  "";
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "N";
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	
	//Added V200807 SHIKHA against NMC-JD-CRF-0042
	String Acolor = "";
	String Pcolor = "";
	String Hcolor = "";
	String Scolor = "";
	String Rcolor = "";
	String Ccolor = "";
	String AtimeLimit = "0";//V201014
	String PtimeLimit = "0";//V201014
	String HtimeLimit = "0";//V201014
	String StimeLimit = "0";//V201014
	String RtimeLimit = "0";//V201014
	String CtimeLimit = "0";//V201014
	boolean siteApprovalStatusColorCode = false;
	String siteApprovalStatusColorCodeYN = "N";
	//Ended V200807 SHIKHA against NMC-JD-CRF-0042
try  
{ 
	sStyle 		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 		= 	(String)session.getAttribute("LOCALE");
	strLoggedUser=	(String) session.getValue("login_user");	
	if (strLoggedUser==null) strLoggedUser = "";

	facilityId	=   (String) session.getValue( "facility_id" ) ;
	patinetId	=	checkForNull(request.getParameter("patinetId"));
	episodeType	=	checkForNull(request.getParameter("episodeType"));
	episodeId	=	checkForNull(request.getParameter("episodeId"));
	visitId		=	checkForNull(request.getParameter("visitId"));
	priority	=	checkForNull(request.getParameter("priority"));
	acctSeqNo	=	checkForNull(request.getParameter("acctSeqNo"));
	encounterId	=	java.net.URLDecoder.decode(checkForNull(request.getParameter("encounterId")));
	//billingGrpId=	checkForNull(request.getParameter("billingGrpId"));
	policyTypeCode=	checkForNull(request.getParameter("policyTypeCode"));
	custGroupCode=	checkForNull(request.getParameter("custGroupCode"));
	custCode	=	checkForNull(request.getParameter("custCode"));
	policyNumber=	checkForNull(request.getParameter("policyNumber"));
	requestStatus=	checkForNull(request.getParameter("requestStatus"));
	
	criteriaFilter = checkForNull(request.getParameter("criteriaFilter"));
	bg_code_filter = checkForNull(request.getParameter("bg_code_filter"));
	bg_desc_filter = checkForNull(request.getParameter("bg_desc_filter"));
	serviceDate_filter = checkForNull(request.getParameter("serviceDate_filter"));
	serviceAmount_filter = checkForNull(request.getParameter("serviceAmount_filter"));
	serviceQuantity_filter = checkForNull(request.getParameter("serviceQuantity_filter"));
	apprReqDate_filter = checkForNull(request.getParameter("apprReqDate_filter"));
	apprGvnDate_filter = checkForNull(request.getParameter("apprGvnDate_filter"));
	apprNo_filter = checkForNull(request.getParameter("apprNo_filter"));
	approval_status_filter = checkForNull(request.getParameter("approval_status_filter"));
	apprQty_filter = checkForNull(request.getParameter("apprQty_filter"));
	apprAmt_filter = checkForNull(request.getParameter("apprAmt_filter"));
	reason_filter = checkForNull(request.getParameter("reason_filter"));
	reason_hdn_filter = checkForNull(request.getParameter("reason_hdn_filter"));
	remarks_filter = checkForNull(request.getParameter("remarks_filter"));
	userAuthorization = checkForNull(request.getParameter("userAuthorization"));
	encounterIdFilter= checkForNull(request.getParameter("encounterIdFilter"));
	orderStatusFilter= checkForNull(request.getParameter("orderStatusFilter"));
	siteSpec=checkForNull(request.getParameter("site_spec"));
	siteId = BLReportIdMapper.getCustomerId();
	
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
	calledForm =	checkForNull(request.getParameter("calledForm"));
	servGrpCode =	checkForNull(request.getParameter("servGrpCode"));
	servClsfctnCode =	checkForNull(request.getParameter("servClsfctnCode"));
	orderStatus =	checkForNull(request.getParameter("orderStatus"));
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */
	
	preApprovalRequestDetailsDataMap =	new LinkedHashMap();
	
	bean_id	= 	"PreApprovalRequestDetailsBean" ;
	bean_name = 	"eBL.PreApprovalRequestDetailsBean";
	PreApprovalRequestDetailsBean preApprovalRequestDetailsBean= 	(PreApprovalRequestDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess	= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	preApprovalRequestDetailsDataMap =	preApprovalRequestDetailsBean.getPreApprovalRequestDetailsData(patinetId, episodeType, episodeId, visitId, priority,requestStatus,acctSeqNo, facilityId, locale,custGroupCode,custCode,policyTypeCode,
			criteriaFilter,bg_code_filter,serviceDate_filter,serviceAmount_filter,serviceQuantity_filter,apprReqDate_filter,
			apprGvnDate_filter,apprNo_filter,approval_status_filter,apprQty_filter,apprAmt_filter,reason_hdn_filter,remarks_filter,encounterId,encounterIdFilter,orderStatusFilter, servGrpCode, servClsfctnCode, orderStatus);		
	con = ConnectionManager.getConnection(request); 
	String sqlBillingService = "SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) description FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = 'BL' AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = 'L_SERV_INC_EXC_CR' AND B.LANGUAGE_ID (+) = ? and A.LIST_ELMT_VALUE = ? ";
	String blngServDesc = "";	
	String sys_date = "";
	
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try {
			//con	=	ConnectionManager.getConnection(request); checklist
			site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
			if (site3TierAlmoFeature) {
				site3TierAlmoFeatureYN = "Y";
			}else {
				site3TierAlmoFeatureYN = "N";
			}
			} catch(Exception ex) {
				System.err.println("Error in BillingPreApprovalRequestStatusDetails.jsp for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
		}
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	
	try
	{
		//Query Modified for MMS-CRF-0198.1
		String query_date="select to_char(sysdate,'dd/mm/yyyy'), to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') curr_time from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date) ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  				
				sys_date = rs.getString(1); 
				sysDateTime = rs.getString("curr_time");
			}
		}
		if(rs !=null) rs.close();
		stmt.close();
		
		String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
		pstmt = con.prepareStatement(inclExclSql);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();
		
		if(rst!=null){
			while(rst.next()){
				criteriaMap.put(rst.getString("code"),rst.getString("description"));
			}	
		}		
		pstmt = null;
		rst = null;
	}
	catch(Exception e)
	{
		out.println("Exception @ sys_date_wht_sec"+e);
		e.printStackTrace();
	}
	//Added V200807 SHIKHA against NMC-JD-CRF-0042
	try
	{
		String sqlRecordColor = "SELECT REQUEST_STATUS,SUBSTR(TIME_LIMIT,0,INSTR(TIME_LIMIT,':')-1)*60 + SUBSTR(TIME_LIMIT,INSTR(TIME_LIMIT,':')+1),COLOR_CODE FROM BL_COLOR_INDICATOR_RULE_STATUS WHERE facility_id = '"+facilityId+"'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlRecordColor) ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  				
				if (rs.getString(1).equals("A")){
					Acolor = rs.getString(3); 
					AtimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("P")){
					Pcolor = rs.getString(3); 
					PtimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("S")){
					Scolor = rs.getString(3); 
					StimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("R")){
					Rcolor = rs.getString(3); 
					RtimeLimit = rs.getString(2);
				}else if (rs.getString(1).equals("H")){
					Hcolor = rs.getString(3); 
					HtimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("C")){
					Ccolor = rs.getString(3); 
					CtimeLimit = rs.getString(2);
				}				
			}
		}		
		if(rs !=null) rs.close();
		stmt.close();						
	}
	catch(Exception e)
	{
		out.println("Exception @ BL_COLOR_INDICATOR_RULE_STATUS"+e);
		e.printStackTrace();
	}
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
	//Ended V200807 SHIKHA against NMC-JD-CRF-0042
	
	pstmt = con.prepareStatement(sqlBillingService);

            _bw.write(_wl_block14Bytes, _wl_block14);
 if(siteSpec.equals("true")){  
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
} 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounterIdFilter));
            _bw.write(_wl_block28Bytes, _wl_block28);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

			for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				if(type.equals(criteriaFilter)) {
				
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(criteriaMap.get(type) ));
            _bw.write(_wl_block34Bytes, _wl_block34);
} else { 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(criteriaMap.get(type) ));
            _bw.write(_wl_block37Bytes, _wl_block37);
 }
			}
			
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bg_code_filter ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bg_desc_filter ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(serviceDate_filter ));
            _bw.write(_wl_block41Bytes, _wl_block41);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(orderStatusFilter ));
            _bw.write(_wl_block43Bytes, _wl_block43);
} 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(serviceAmount_filter ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(serviceQuantity_filter ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(apprReqDate_filter ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(apprGvnDate_filter ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(apprNo_filter ));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(("A".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(("R".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(("P".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(("S".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(("H".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(("C".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(apprQty_filter ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(apprAmt_filter ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(reason_filter ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(reason_hdn_filter ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(remarks_filter ));
            _bw.write(_wl_block61Bytes, _wl_block61);
 
		Iterator iterator= preApprovalRequestDetailsDataMap.keySet().iterator();
		while(iterator.hasNext())
		{		
			int index =    (Integer)iterator.next();
			preApprovalRequestDetailsBean = (PreApprovalRequestDetailsBean) preApprovalRequestDetailsDataMap.get(index);	
	
            _bw.write(_wl_block62Bytes, _wl_block62);

		pstmt.setString(1,locale);
		pstmt.setString(2,preApprovalRequestDetailsBean.getIncludedExcluded());
		rst = pstmt.executeQuery();
		if(rst != null){
			while(rst.next()){
				blngServDesc = rst.getString("description");
			}
		}
		//pstmt = null;
		rst = null;
		
		//Added V200807 SHIKHA against NMC-JD-CRF-0042					
		//  int preAppStatusMaxDateTime =0;//V201013//checklist
		  String bgcolor = "";				
		if ( siteApprovalStatusColorCode) {
		//V201024 commented try & catch	
			/*
		  try {
			  String preApprStatusStr = "select NVL(cast ((sysdate - max(PRE_APP_STATUS_DATE)) * 24 * 60 as int),0) from bl_ins_preappr_ser_lvl_dtlslog where OPERATING_FACILITY_ID= '"+facilityId+"' and patient_id ='"+patinetId +"' and episode_type ='"+episodeType+"' and  episode_id ='"+episodeId+"' and visit_id = '"+visitId
					  +"' and acct_seq_no='"+acctSeqNo+"'  and priority='"+priority+"' and PRIMARY_KEY_BLNG_SERV_CODE = '"+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode()+"' and PRIMARY_KEY_MAIN='"+preApprovalRequestDetailsBean.getPrimaryKeyMain()+"' and PRIMARY_KEY_LINE_NO='"+preApprovalRequestDetailsBean.getPrimaryKeyLineNo()+"'";
			  stmt = con.createStatement();		
			  rs = stmt.executeQuery(preApprStatusStr) ;
						
			  if( rs != null ) 
				{
					while( rs.next() )
					{  				
						preAppStatusMaxDateTime = rs.getInt(1);
					}
				}		
				if(rs !=null) rs.close();
				stmt.close();						  
		  } catch(Exception e) {
			e.printStackTrace();  
		  }		  	*/
		  if(preApprovalRequestDetailsBean.getColorStatus().equals("Y")) { //V201024 added
			  if (preApprovalRequestDetailsBean.getStatus().equals("P")) {
				  //if (preAppStatusMaxDateTime > Integer.parseInt(PtimeLimit)) { //V201024 commented
					  bgcolor = "style=background-color:"+Pcolor;
					//  }  //V201024 commented
			  } else if (preApprovalRequestDetailsBean.getStatus().equals("A")) {
				  if ( !preApprovalRequestDetailsBean.getApprovalNumber().equals("Default Approved")) {			  
					  //if (preAppStatusMaxDateTime > Integer.parseInt(AtimeLimit)) { //V201024 commented
							bgcolor = "style=background-color:"+Acolor;
						//  }  //V201024 commented
				  }
			  }else if (preApprovalRequestDetailsBean.getStatus().equals("H")) {		  
				  //if (preAppStatusMaxDateTime > Integer.parseInt(HtimeLimit)) { //V201024 commented
						bgcolor = "style=background-color:"+Hcolor;
					//  }  //V201024 commented
			  }else if (preApprovalRequestDetailsBean.getStatus().equals("C")) {			
				  //if (preAppStatusMaxDateTime > Integer.parseInt(CtimeLimit)) { //V201024 commented				
						bgcolor = "style=background-color:"+Ccolor;
					//  }  //V201024 commented
			  }else if (preApprovalRequestDetailsBean.getStatus().equals("S")) {
				  //if (preAppStatusMaxDateTime > Integer.parseInt(StimeLimit)) { //V201024 commented				
						bgcolor = "style=background-color:"+Scolor;
					//  }  //V201024 commented
			  }else if (preApprovalRequestDetailsBean.getStatus().equals("R")) {
				  //if (preAppStatusMaxDateTime > Integer.parseInt(RtimeLimit)) { //V201024 commented			
					bgcolor = "style=background-color:"+Rcolor;
				  //}  //V201024 commented
			  }					  
		  }					  
		  }					  
		//Ended V200807 SHIKHA against NMC-JD-CRF-0042
	
            _bw.write(_wl_block63Bytes, _wl_block63);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(index));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEncounterId()			!=	null	?	preApprovalRequestDetailsBean.getEncounterId()		:	""	 ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEncounterId()			!=	null	?	preApprovalRequestDetailsBean.getEncounterId()		:	""	 ));
            _bw.write(_wl_block68Bytes, _wl_block68);
} 
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(index));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(index));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(blngServDesc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(blngServDesc ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(index));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceCode()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceCode()		:	""	 ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceCode()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceCode()		:	""	 ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(index));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(index));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceDisplay()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDisplay()		:	""	 ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceDisplay()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDisplay()		:	""	 ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(index));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceDesc()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDesc()		:	""	 ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillingServiceDesc()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDesc()		:	""	 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(index));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceDate()	));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(index));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(index));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceDate()				!=	null	?	preApprovalRequestDetailsBean.getServiceDate()				:	""	 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceDate()				!=	null	?	preApprovalRequestDetailsBean.getServiceDate()				:	""	 ));
            _bw.write(_wl_block89Bytes, _wl_block89);
 if(siteSpec.equals("true")){ 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(index));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(index));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getOrderStatus()				!=	null	?	preApprovalRequestDetailsBean.getOrderStatus()				:	""	 ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getOrderStatus()				!=	null	?	preApprovalRequestDetailsBean.getOrderStatus()				:	""	 ));
            _bw.write(_wl_block92Bytes, _wl_block92);
} 
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(index));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getUtilizedAmount()				!=	null	?	preApprovalRequestDetailsBean.getUtilizedAmount()			:	""	 ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getUtilizedAmount()				!=	null	?	preApprovalRequestDetailsBean.getUtilizedAmount()			:	""	 ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(index));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(index));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceQty()				!=	null	?	preApprovalRequestDetailsBean.getServiceQty()			:	""	 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceQty()				!=	null	?	preApprovalRequestDetailsBean.getServiceQty()			:	""	 ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalRequiredDate()	));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(index));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(index));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalRequiredDate()			!=	null	?	preApprovalRequestDetailsBean.getApprovalRequiredDate()		:	""	 ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalRequiredDate()		!=	null	?	preApprovalRequestDetailsBean.getApprovalRequiredDate()		:	""	 ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(index));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 	?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	sys_date	 ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(index));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(index));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 ?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	""	 ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf( preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 	?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	""	 ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(index));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(index));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(index));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(index));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus() !=null ? preApprovalRequestDetailsBean.getStatus() : "P" ));
            _bw.write(_wl_block118Bytes, _wl_block118);

		if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("P")) {
		
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 ));
            _bw.write(_wl_block122Bytes, _wl_block122);

		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("A")) {
		
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 ));
            _bw.write(_wl_block123Bytes, _wl_block123);

		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("R")) {
		
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 ));
            _bw.write(_wl_block124Bytes, _wl_block124);

		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("S")) {
		
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 ));
            _bw.write(_wl_block125Bytes, _wl_block125);

		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("H")) {
		
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 ));
            _bw.write(_wl_block126Bytes, _wl_block126);

		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("C")) {
		
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 ));
            _bw.write(_wl_block127Bytes, _wl_block127);

		}else {
		
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 ));
            _bw.write(_wl_block128Bytes, _wl_block128);

		}
		
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(index));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(index));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(index));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getStatus() != null ? preApprovalRequestDetailsBean.getStatus():""  ));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(index));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 ));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(index));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(index));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 ));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(index));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 ));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(index));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(index));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 ));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(index));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(index));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(index));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(index));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 ));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(index));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(index));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 ));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(index));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(index));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEffectiveFrom()  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveFrom()			: 	"" 	 ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(index));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(index));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEffectiveTo()	  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveTo()				: 	"" 	 ));
            _bw.write(_wl_block155Bytes, _wl_block155);
            _bw.write(_wl_block156Bytes, _wl_block156);
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(index));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(index));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPatientClass()				!=null 		? 	preApprovalRequestDetailsBean.getPatientClass()				: 	"" 	 ));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(index));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getEpisodeEncounterFlag()		!=null 		? 	preApprovalRequestDetailsBean.getEpisodeEncounterFlag()		: 	"" 	 ));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(index));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(index));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getClinicNursingIndicator()		!=null 		? 	preApprovalRequestDetailsBean.getClinicNursingIndicator()	: 	"" 	 ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(index));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(index));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getClinicNursingCode()			!=null 		? 	preApprovalRequestDetailsBean.getClinicNursingCode()		: 	"" 	 ));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(index));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(index));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getSpecialiltyCode()			!=null 		? 	preApprovalRequestDetailsBean.getSpecialiltyCode()			: 	"" 	 ));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(index));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalAmountCapping()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalAmountCapping()	: 	"" 	 ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(index));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalQuantityCapping()	!=null 		? 	preApprovalRequestDetailsBean.getApprovalQuantityCapping()	: 	"" 	 ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(index));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getServiceLevelApprovalFlag()	!=null 		? 	preApprovalRequestDetailsBean.getServiceLevelApprovalFlag()	: 	"" 	 ));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(index));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(index));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getApprovalGrossNetAmount()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalGrossNetAmount()	: 	"" 	 ));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(index));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(index));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getUtilizedQuantity()			!=null 		? 	preApprovalRequestDetailsBean.getUtilizedQuantity()			: 	"" 	 ));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(index));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(index));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getSex()						!=null 		? 	preApprovalRequestDetailsBean.getSex()						: 	"" 	 ));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(index));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(index));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getAgeGroupCode()				!=null 		? 	preApprovalRequestDetailsBean.getAgeGroupCode()				: 	"" 	 ));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(index));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyFacilityId()		!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyFacilityId()		: 	"" 	 ));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(index));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(index));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyModuleId()			!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyModuleId()		: 	"" 	 ));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(index));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(index));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyMain()				!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyMain()			: 	"" 	 ));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(index));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(index));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyLineNo()			!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyLineNo()			: 	"" 	 ));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(index));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(index));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode()!=null 	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode():"" 	 ));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(index));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(index));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode()!=null	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode():"" ));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(index));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(index));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(preApprovalRequestDetailsBean.getBillApprovedYN()!=null	? 	preApprovalRequestDetailsBean.getBillApprovedYN():"" ));
            _bw.write(_wl_block200Bytes, _wl_block200);
            _bw.write(_wl_block156Bytes, _wl_block156);
            _bw.write(_wl_block201Bytes, _wl_block201);

		}	
	
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(isUserCanAcess));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(enabValue));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(patinetId));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(acctSeqNo));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(policyTypeCode));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(custGroupCode));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(custCode));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(policyNumber));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(copyIndex));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(approvedAmount));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(requestStatus));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(sys_date ));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(siteId ));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(request.getParameter("expiryDate")));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(request.getParameter("effectiveTo")));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(sysDateTime ));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf( strLoggedUser));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(siteSpec ));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(site3TierAlmoFeatureYN ));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(siteApprovalStatusColorCodeYN ));
            _bw.write(_wl_block231Bytes, _wl_block231);
if("Y".equals(userAuthorization)){ 
            _bw.write(_wl_block232Bytes, _wl_block232);
} 
            _bw.write(_wl_block233Bytes, _wl_block233);

	}
	catch(Exception e)
	{
		System.err.println("Exception in BillingRecordApprovalPatientDataDeatils.jsp::"+e);
		e.printStackTrace();
	}
	finally{
		ConnectionManager.returnConnection(con);
		pstmt = null;
		rst = null;
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block234Bytes, _wl_block234);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLNG_SERV_CODE.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingServiceDesc.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_DATE.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderStatus.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceAmount.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceQuantity.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprovalRequiredDate.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprovalGivenDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprovalNumber.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_QTY.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
}
