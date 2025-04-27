package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
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

public final class __blinterimbilldetals extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInterimBillDetals.jsp", 1737916048135L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No              Version                Incident              SCF/CRF                        Developer Name\n1                  V201218                IN73702            MMS-DM-CRF-0100.1         \t\t\tPalani Narayanan\n2                  V210228                 15239             MMS-DM-CRF-0100.1         \t\t\tRam kumar S\n3\t\t\t\t   V211020\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tMohanapriya K\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/BillingInterimBillScript.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nvar ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL\t=\t\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\nvar PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL\t=\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\t\nvar PAYER_LOOKUP_RECORD_PREAPPROVAL\t\t\t=\t\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\nvar POLICY_LOOKUP_RECORD_PREAPPROVAL\t\t=\t\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10_0 ="\";\n\tvar headTop = -1;\n\tvar FloatHead1;\n\tvar arrPageURL;\n\tvar myArray = new Array();\n\tfunction processScroll() {\n\t\tif (headTop < 0) {\n\t\t\tsaveHeadPos();\n\t\t}\n\t\tif (headTop > 0) {\n\t\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\t\ttheTop = document.documentElement.scrollTop;\n\t\t\telse if (document.body)\n\t\t\t\ttheTop = document.body.scrollTop;\n\n\t\t\tif (theTop > headTop)\n\t\t\t\tFloatHead1.style.top = (theTop - headTop) + \'px\';\n\t\t\telse\n\t\t\t\tFloatHead1.style.top = \'0px\';\n\t\t}\n\t}\n\n\tfunction saveHeadPos() {\n\t\tparTable = document.getElementById(\"divHeadSep\");\n\t\tif (parTable != null) {\n\t\t\theadTop = parTable.offsetTop + 3;\n\t\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\t\tFloatHead1.style.position = \"relative\";\n\t\t}\n\t}\n\n\tfunction lockKey() {\n\t\tif (event.keyCode == 93)\n\t\t\talert(\"Welcome to eHIS\");\n\t}\n\n\tfunction lockbackSpace() {\n\t\tvar mode = document.mode.value;\n\t\tif (mode == \'modify\' && window.event.keyCode == 8) {\n\n\t\t}\n\t}\n\n\tvar objFinal = {};\n\tvar objunSelectFinal = [];\n\n\tfunction checkBoxValidate(index, start, end) {\n\n\t\tvar table = document.getElementById(\"interim_Bill_Details_table\");\n\t\tvar rowCount = table.rows.length;\n\t\tvar totalCount = document.getElementById(\"rowCount\").value;\n\t\tvar totalSize = document.getElementById(\"totalrowcount\").value;\n\t\tstart = start - 1;\n\t\tvar count = 0;\n\t\tvar i = 0;\n\t\tvar checkObj = document.getElementById(\'select_all\' + index);\n\t\tvar selectArrFlag = parent.frames[1].document.getElementById(\"selectArrFlag\").value;\n\t\tvar selectArrUnSlectFlag = parent.frames[1].document.getElementById(\"selectArrUnSlectFlag\").value;\n\t\tvar selectJsonArrFlag = parent.frames[1].document.getElementById(\"selectJsonArrFlag\").value;\n\t\tvar selectAllFlag = parent.frames[1].document.getElementById(\"selectAllFlag\").value;\n\t\tvar selectAllPrevFlag=parent.frames[1].document.getElementById(\"selectAllPrevFlag\").value;\n\t\tif (checkObj.checked) {\n\t\t\tif(selectAllPrevFlag!=\"Y\"){\n\t\t\tdocument.getElementById(\'select_all\' + index).value = \'Y\';\n\t\t\tselectArrFlag = selectArrFlag + index + \",\";\n\t\t\tparent.frames[1].document.getElementById(\"selectArrFlag\").value = selectArrFlag;\n\t\t\tif (selectJsonArrFlag != null && selectJsonArrFlag != \"\")\n\t\t\t\tobjFinal = JSON.parse(selectJsonArrFlag);\n\t\t\tvar newNum = \"\";\n\t\t\tvar newVal = \"\";\n\t\t\tnewNum = index;\n\t\t\tvar srl_no = document.getElementById(\"srl_no\" + index).value;\n\t\t\tvar patId = document.getElementById(\"patient_id\" + index).value;\n\t\t\tvar pName = document.getElementById(\"patient_name\" + index).value;\n\t\t\tvar epdId = document.getElementById(\"episode_id\" + index).value;\n\t\t\tvar admDate = document.getElementById(\"admissiondate\" + index).value;\n\t\t\tadmDate = admDate.split(\"/\").reverse().join(\"-\");\n\t\t\tvar payerGroup = document.getElementById(\"payer_group\" + index).value;\n\t\t\tvar payer = document.getElementById(\"payer\" + index).value;\n\t\t\tvar policy = document.getElementById(\"policy\" + index).value;\n\t\t\tvar unbuiledAmount = document.getElementById(\"unbuiledamount\"+ index).value;\n\t\t\tvar billNumber = document.getElementById(\"billnumber\" + index).value;\n\t\t\tvar billDate = document.getElementById(\"billdate\" + index).value;\n\t\t\tbillDate = billDate.split(\"/\").reverse().join(\"-\");\n\t\t\tvar selectall = document.getElementById(\"select_all\" + index).value;\n\t\t\tnewVal = srl_no + \"~\" + patId + \"~\" + pName + \"~\" + epdId + \"~\"\n\t\t\t\t\t+ admDate + \"~\" + payerGroup + \"~\" + payer + \"~\" + policy\n\t\t\t\t\t+ \"~\" + unbuiledAmount + \"~\" + billNumber + \"~\" + billDate\n\t\t\t\t\t+ \"~\" + selectall;\n\t\t\tobjFinal[newNum] = newVal;\n\t\t\tparent.frames[1].document.getElementById(\"selectJsonArrFlag\").value = JSON.stringify(objFinal);\n\t\t\t}else{\n\t\t\t\tif(selectArrUnSlectFlag.indexOf(index)!=-1){\n\t\t\t\t\tselectArrUnSlectFlag = selectArrUnSlectFlag.replace(index + \",\", \"\");\n\t\t\t\t\tparent.frames[1].document.getElementById(\"selectArrUnSlectFlag\").value = selectArrUnSlectFlag;\n\t\t\t\t\tdocument.getElementById(\"finalUnselectindex\").value=selectArrUnSlectFlag;\n\t\t\t\t}\n\t\t\t}\n\t\t} else {\n\t\t\tif (selectAllFlag == \"Y\" || selectAllPrevFlag==\"Y\") {\n\t\t\t\tdocument.getElementById(\"Header_select_all\").checked = false;\n\t\t\t\tdocument.getElementById(\"Header_select_all\").value = \"N\";\n\t\t\t\tparent.frames[1].document.getElementById(\"selectAllFlag\").value = \"N\";\n\t\t\t\tparent.frames[1].document.getElementById(\"selectAllPrevFlag\").value = \"Y\";\n\t\t\t\tselectArrUnSlectFlag=selectArrUnSlectFlag + index + \",\";\n\t\t\t\tparent.frames[1].document.getElementById(\"selectArrUnSlectFlag\").value = selectArrUnSlectFlag;\n\t\t\t\tdocument.getElementById(\"finalUnselectindex\").value=selectArrUnSlectFlag;\n\t\t\t} else {\n\t\t\t\tparent.frames[1].document.getElementById(\"selectAllPrevFlag\").value = \"N\";\n\t\t\t\tselectArrFlag = selectArrFlag.replace(index + \",\", \"\");\n\t\t\t\tdelete objFinal[index];\n\t\t\t\tparent.frames[1].document.getElementById(\"selectJsonArrFlag\").value = JSON.stringify(objFinal);\n\t\t\t\tparent.frames[1].document.getElementById(\"selectArrFlag\").value = selectArrFlag;\n\t\t\t}\n\t\t\t\n\t\t}\n\t}\n\n\tfunction checkBoxValidate1(start, end) {\n\t\tvar checkObj = document.getElementById(\"Header_select_all\");\n\t\tvar table = document.getElementById(\"interim_Bill_Details_table\");\n\t\tparent.frames[1].document.getElementById(\"selectJsonArrFlag\").value=\"\";\n\t\tparent.frames[1].document.getElementById(\"selectArrFlag\").value=\"\";\n\t\tparent.frames[1].document.getElementById(\"selectArrUnSlectFlag\").value =\"\";\n\t\tdocument.getElementById(\"finalUnselectindex\").value=\"\";\n\t\tdocument.getElementById(\"finalIndexArr\").value=\"\";\n\t\tvar totalhashSize=document.getElementById(\"totalrowCount\").value;//V210228\n\t\tobjFinal = {};\n\t\tvar rowCount = table.rows.length;\n\t\t//V210228 Starts\n\t\tif(totalhashSize<16){\n\t\t\tend=totalhashSize;\n\t\t}\n\t\t//V210228 Ends\n\t\tstart = start - 1;\n\t\tvar i = 0;\n\t\tif (checkObj.checked == true) {\n\t\t\tparent.frames[1].document.getElementById(\"selectAllFlag\").value = \"Y\";\n\t\t\tparent.frames[1].document.getElementById(\"selectAllPrevFlag\").value=\"\";\n\t\t\tdocument.getElementById(\"Header_select_all\").value = \"Y\";\n\t\t\tfor (i = start; i < end; i++) {\n\t\t\t\tif(!document.getElementById(\"select_all\" + i).disabled){\n\t\t\t\tdocument.getElementById(\"select_all\" + i).checked = true;\n\t\t\t\tdocument.getElementById(\"select_all\" + i).value = \"Y\";\n\t\t\t\t}\n\n\t\t\t}\n\t\t} else {\n\t\t\tparent.frames[1].document.getElementById(\"selectAllFlag\").value = \"N\";\n\t\t\tparent.frames[1].document.getElementById(\"selectAllPrevFlag\").value=\"\";\n\t\t\tdocument.getElementById(\"Header_select_all\").value = \"N\";\n\t\t\tfor (i = start; i < end; i++) {\n\t\t\t\tif(!document.getElementById(\"select_all\" + i).disabled){\n\t\t\t\tdocument.getElementById(\"select_all\" + i).checked = false;\n\t\t\t\tdocument.getElementById(\"select_all\" + i).value = \"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction validateDynamicChk() {\n\t\tvar authorizedUserId = parent.frames[1].document.getElementById(\"authorizedUserId\").value;\n\t\tvar privilegeYN = parent.frames[1].document.getElementById(\"privilegeYN\").value;\n\t\tvar selectAllPrevFlag = parent.frames[1].document.getElementById(\"selectAllPrevFlag\").value;\n\t\tvar selectFlag = parent.frames[1].document.getElementById(\"selectAllFlag\").value;\n\t\tvar selectArrFlag = parent.frames[1].document.getElementById(\"selectArrFlag\").value;\n\t\tvar rowCount = document.getElementById(\"rowCount\").value;\n\t\tvar startVal = document.getElementById(\"start\").value;\n\t\tdocument.getElementById(\"authorizedUserId\").value=parent.frames[1].document.getElementById(\"authorizedUserName\").value;\n\t\tdocument.getElementById(\"finalIndexArr\").value=parent.frames[1].document.getElementById(\"selectArrFlag\").value;\n\t\tdocument.getElementById(\"finalUnselectindex\").value=parent.frames[1].document.getElementById(\"selectArrUnSlectFlag\").value;\n\t\tstartVal = startVal - 1;\n\t\tif (authorizedUserId == \"Y\" && privilegeYN==\"YY\") {\n\t\t\tif (selectFlag == \"Y\") {\n\t\t\t\tdocument.getElementById(\"Header_select_all\").checked = true;\n\t\t\t\tdocument.getElementById(\"Header_select_all\").disabled = false;\n\t\t\t\tdocument.getElementById(\"Header_select_all\").value = \"Y\";\n\t\t\t\tfor (var i = startVal; i < rowCount; i++) {\n\t\t\t\t\tif(!document.getElementById(\"select_all\" + i).disabled){\n\t\t\t\t\tdocument.getElementById(\"select_all\" + i).checked = true;\n\t\t\t\t\tdocument.getElementById(\"select_all\" + i).value = \"Y\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t} else if (selectFlag == \"N\") {\n\t\t\t\tdocument.getElementById(\"Header_select_all\").checked = false;\n\t\t\t\tdocument.getElementById(\"Header_select_all\").disabled = false;\n\t\t\t\tdocument.getElementById(\"Header_select_all\").value = \"N\";\n\t\t\t\tfor (var i = startVal; i < rowCount; i++) {\n\t\t\t\t\tif(!document.getElementById(\"select_all\" + i).disabled){\n\t\t\t\t\tdocument.getElementById(\"select_all\" + i).checked = false;\n\t\t\t\t\tdocument.getElementById(\"select_all\" + i).value = \"N\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tvar res = selectArrFlag.split(\",\");\n\t\t\t\tfor (var index = 0; index < res.length; index++) {\n\t\t\t\t\tvar valueToCheck = trimString(res[index]);\n\t\t\t\t\ttry {\n\t\t\t\t\t\tif (parseInt(valueToCheck) >= parseInt(startVal)\n\t\t\t\t\t\t\t\t&& parseInt(valueToCheck) < parseInt(rowCount) && valueToCheck!=null && valueToCheck!=\"\") {\n\t\t\t\t\t\t\tdocument.getElementById(\"select_all\" + valueToCheck).checked = true;\n\t\t\t\t\t\t\tdocument.getElementById(\'select_all\' + valueToCheck).value = \"Y\";\n\t\t\t\t\t\t}\n\t\t\t\t\t} catch (e) {\n\t\t\t\t\t\talert(\"Exception \" + e);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif (selectAllPrevFlag == \"Y\") {\n\t\t\t\t\tvar selectArrUnSlectFlag = parent.frames[1].document.getElementById(\"selectArrUnSlectFlag\").value;\n\t\t\t\t\tfor (var i = startVal; i < rowCount; i++) {\n\t\t\t\t\t\tif(selectArrUnSlectFlag.indexOf(i)==-1 &&parseInt(i) >= parseInt(startVal)\n\t\t\t\t\t\t\t\t&& parseInt(i) < parseInt(rowCount)){\n\t\t\t\t\t\t\tdocument.getElementById(\"select_all\" + i).checked = true;\n\t\t\t\t\t\t\tdocument.getElementById(\"select_all\" + i).disabled = false;\n\t\t\t\t\t\t\tdocument.getElementById(\"select_all\" + i).value = \"Y\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t}\n\t\t} else {\n\t\t\tdocument.getElementById(\"Header_select_all\").checked = false;\n\t\t\tdocument.getElementById(\"Header_select_all\").disabled = true;\n\t\t\tdocument.getElementById(\"Header_select_all\").value = \"N\";\n\t\t\tfor (var i = startVal; i < rowCount; i++) {\n\t\t\t\tdocument.getElementById(\"select_all\" + i).checked = false;\n\t\t\t\tdocument.getElementById(\"select_all\" + i).disabled = true;\n\t\t\t\tdocument.getElementById(\"select_all\" + i).value = \"N\";\n\t\t\t}\n\t\t  }\t\n\t\t//V210228 Starts\n\t\t//Disabling the header slect all\n\t\tvar disFlag=\"N\";\n\t\tfor (i = startVal; i < rowCount; i++) {\n\t\t\t\tif(!document.getElementById(\"select_all\" + i).disabled){\n\t\t\t\t\tdisFlag=\"Y\";\n\t\t\t\t}\n\t\t\t}\n\t\tif(disFlag==\"N\"){\n\t\t\tdocument.getElementById(\"Header_select_all\").checked = false;\n\t\t\tdocument.getElementById(\"Header_select_all\").disabled = true;\n\t\t\tdocument.getElementById(\"Header_select_all\").value = \"N\";\n\t\t}\n\t\t//Ends\n}\n\t\t  \n\n</script>\n</head>\n<style>\ndiv.tableContainer {\n\twidth: 100%; /* table width will be 99% of this*/\n\theight: 160px; /* must be greater than tbody*/\n\toverflow: auto;\n\tmargin: 0 auto;\n}\n\ntable {\n\twidth: 100%; /*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tb";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 ="ackground-color: #f7f7f7;\n}\n\ntable>tbody {\n\t/* child selector syntax which IE6 and older do not support*/\n\toverflow: auto;\n\theight: 120x;\n\toverflow-x: hidden;\n}\n\nthead tr {\n\tposition: relative;\n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n}\n\nTD.YELLOW {\n\tBACKGROUND-COLOR: yellow;\n\tFONT-SIZE: 8pt;\n\tborder-style: dashed;\n\tborder-left-color: #D5E2E5;\n\tborder-right-color: #D5E2E5;\n\tborder-top-color: #D5E2E5;\n\tborder-bottom-color: #D5E2E5;\n}\n\nTD.RED {\n\tbackground-color: #FFFFFF;\n\tCOLOR: red;\n\tFONT-SIZE: 8pt;\n\tTEXT-ALIGN: LEFT\n}\n</style>\n\n";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block11 ="\n<body onScroll=\"processScroll()\" onKeyDown=\"lockKey();\"\n\tonMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\"\n\tonload=\'validateDynamicChk();\'>\n\t<form id=\"recordApprovalPatientData\" name=\"recordApprovalPatientData\" id=\"recordApprovalPatientData\">\n\t\t<div align=\"right\">\n\t\t\t<td>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</td>\n\t\t</div>\n\n\t\t<table cellpadding=3 cellspacing=0 width=\"100%\"\n\t\t\tid=\"interim_Bill_Details_table\" name=\"interim_Bill_Details_table\" id=\"interim_Bill_Details_table\"\n\t\t\tborder=\"1\">\n\t\t\t<div id=\"tableContainer\">\n\t\t\t\t<THEAD>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'16\' class=\"columnheader\" align=\"left\">Patient\n\t\t\t\t\t\t\tData</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<td class=\'columnheader\' nowrap width=\'5%\' align=\"center\" nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t<td class=\'columnheader\' width=\'6%\' align=\"center\" nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t<td class=\'columnheader\' width=\'8%\' align=\"center\" nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t<td class=\'columnheader\' width=\'5%\' align=\"center\" nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t<td class=\'columnheader\' width=\'6%\' align=\"center\" nowrap>\n\t\t\t\t\t\t<input \ttype=\'Checkbox\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" id=\"Header_select_all\"\tname=\"Header_select_all\"\n\t\t\t\t\t\t\tonclick=\"checkBoxValidate1(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\"  value=\"N\"/>&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</TR>\n\t\t\t\t</THEAD>\n\t\t\t\t<TBODY style=\"height: 20px;\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'5%\' nowrap id=\"srl_no";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" name=\"srl_no";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'6%\' nowrap id=\"patient_id";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"\n\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"\n\t\t\t\t\t\t\tname=\"patient_id";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:left;\" width=\'15%\' nowrap id=\"patient_name";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"\n\t\t\t\t\t\t\tname=\"patient_name";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'6%\' nowrap id=\"episode_id";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\n\t\t\t\t\t\t\tname=\"episode_id";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'8%\' nowrap id=\"admissiondate";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" name=\"admissiondate";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'5%\' nowrap id=\"payer_group";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"\n\t\t\t\t\t\t\tname=\"payer_group";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'6%\' nowrap id=\"payer";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"\n\t\t\t\t\t\t\tname=\"payer";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'8%\' nowrap id=\"policy";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"\n\t\t\t\t\t\t\tname=\"policy";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'8%\' nowrap id=\"unbuiledamount";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"\n\t\t\t\t\t\t\tname=\"unbuiledamount";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'8%\' nowrap id=\"billnumber";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\n\t\t\t\t\t\t\tname=\"billnumber";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"fields\" style=\"text-align:center;\" width=\'8%\' nowrap id=\"billdate";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" name=\"billdate";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\"3%\" align=\"center\"  >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t<input type=\'Checkbox\' id=\"select_all";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" name=\"select_all\" value=\"select_all\" align=\"center\"\n\t\t\t\t\t\t\tonclick=\"checkBoxValidate(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\"   >\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t<input type=\'Checkbox\' id=\"select_all";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\');\"  disabled  >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\n\t\t\t\t</TBODY>\n\n\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t</table>\n\t\t<br> <br>\n\t\t<div id=\'comment\'>\n\t\t\t<h5>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t</h5>\n\t\t</div>\n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<input type=\'hidden\' name=\'rowCount\' id=\'rowCount\' id=\'rowCount\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\'hidden\' name=\'lastIndex\' id=\'lastIndex\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"> \n\t\t<input type=\'hidden\' name=\'start\' id=\'start\' id=\'start\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"> \n\t\t<input type=\'hidden\' name=\'finalIndexArr\' id=\'finalIndexArr\' id=\'finalIndexArr\' value=\"\"> \n\t\t<input type=\'hidden\' name=\'finalJSONArr\' id=\'finalJSONArr\' id=\'finalJSONArr\' value=\"\">\n\t\t<input type=\'hidden\' name=\'finalUnselectindex\' id=\'finalUnselectindex\' id=\'finalUnselectindex\' value=\"\">\n\t\t<input type=\'hidden\' name=\'totalrowCount\' id=\'totalrowCount\' id=\'totalrowCount\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"> \n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"> \n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"> \n\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\'patientId\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"> \n\t\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' id=\'episodeType\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\'hidden\' name=\'patientName\' id=\'patientName\' id=\'patientName\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' id=\'encounterId\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"> \n\t\t<input type=\'hidden\' name=\'customerGroupCode\' id=\'customerGroupCode\' id=\'customerGroupCode\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"> \n\t\t<input type=\'hidden\' name=\'customerCode\' id=\'customerCode\' id=\'customerCode\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t<input type=\'hidden\' name=\'policyTypecode\' id=\'policyTypecode\' id=\'policyTypecode\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"> \n\t\t<input type=\'hidden\' name=\'speciality\' id=\'speciality\' id=\'speciality\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t<input type=\'hidden\' name=\'authorizedUserId\' id=\'authorizedUserId\' id=\"authorizedUserId\" value=\"\">\n\t</form>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\'\n\t\tstyle=\'position: absolute; width: 30%; visibility: hidden;\'\n\t\tbgcolor=\'blue\'></div>\n</body>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n</html>\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );
	
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

public String UnbilledpriceFormat(String str) {
		if (str == null || str.equals("")) {
			str = "0.00";
		} else {
			str = String.format("%.2f", Float.parseFloat(str));
		}
		return str;
	}
private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);

	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1   
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0   
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
	String locale = "";
	String facilityId = "";
	String mode = checkForNull(request.getParameter("mode"));
	String isUserCanAcess = "";
	String bean_id = "";
	String bean_name = "";
	String patientId = "";
	String episodeType = "";
	String patientName = "";
	String encounterId = "";
	String customerGroupCode = "";
	String encounterFromDate = "";
	String encounterToDate = "";
	String customerCode = "";
	String policyTypecode = "";
	String requestStatus = "";
	String speciality = "";
	String authorizedUserId = "";
	StringBuffer sql = null;
	LinkedHashMap recordPreApprovalDataMap = null;
	String disable = "DISABLED";
	String mainAuth=checkForNull(request.getParameter("mainAuth"));
	String privilegeYN=checkForNull(request.getParameter("privilegeYN"));
	String authorizedUserName=checkForNull(request.getParameter("authorizedUserName"));
	System.out.println("mainAuth  "+mainAuth);
	System.out.println("privilegeYN  "+privilegeYN);
	System.out.println("authorizedUserName  "+authorizedUserName);
	Boolean siteSpec = false;
	int rowcount = 0;
	int start = 0;
	int end = 0;
	int i = 1;
	String endOfRes = "1";
	int count = 0;
	boolean flage = true;
	int noofdecimal = 0;
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	int index = 0;
	int lastIndex = 0;
	int totalrowcount = 0;

	if (from == null)
		start = 1;
	else
		start = Integer.parseInt(from);

	if (to == null)
		end = 16;
	else
		end = Integer.parseInt(to);

	try {
		//Connection con = ConnectionManager.getConnection(request); //V211020
		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "")
						? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		locale = (String) session.getAttribute("LOCALE");
		facilityId = (String) session.getValue("facility_id");
		patientId = checkForNull(request.getParameter("patinetId"));
		episodeType = checkForNull(request.getParameter("episodeType"));
		patientName = checkForNull(request.getParameter("patientName"));
		encounterId = checkForNull(request.getParameter("encounterId"));
		customerGroupCode = checkForNull(request.getParameter("customerGroupCode"));
		customerCode = checkForNull(request.getParameter("customerCode"));
		policyTypecode = checkForNull(request.getParameter("policyCode"));
		speciality = checkForNull(request.getParameter("speciality"));

		bean_id = "RecordApprovalPatientDataBean";
		bean_name = "eBL.RecordApprovalPatientDataBean";
		RecordApprovalPatientDataBean recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) getBeanObject(
				bean_id, bean_name, request);
		isUserCanAcess = (String) (session.getValue("isUserCanAcess") == null ? "Y"
				: (session.getValue("isUserCanAcess")));
		if (request.getParameter("from") == null || mode.equals("search")) {
			recordApprovalPatientDataBean.clearBean();//V210228
			recordPreApprovalDataMap = recordApprovalPatientDataBean.getInterimBillApprovalData(facilityId,
					patientId, patientName, episodeType, encounterId, speciality, customerGroupCode,
					customerCode, policyTypecode);
			System.err.println("Firtst time  "+ recordPreApprovalDataMap.size());
		} else {
			recordPreApprovalDataMap = recordApprovalPatientDataBean.getrPatSearchValues();
			System.err.println("Second time  "+ recordPreApprovalDataMap.size());
		}
		rowcount = recordPreApprovalDataMap.size();
		System.err.println("Row Count "+rowcount);
		totalrowcount = rowcount;
		int cnt = 0;
		int previous = 0;

            _bw.write(_wl_block11Bytes, _wl_block11);

					if (cnt == 0) {

							if (!(start <= i)) {

								out.println("<A HREF='../../eBL/jsp/BLInterimBillDetals.jsp?from=" + (start - 16) + "&to="
										+ (end - 16) + "&patinetId=" + "&patinetId=" + patientId + "&episodeType=" + episodeType
										+ "&customerGroupCode=" + customerGroupCode + "&facility_id=" + facilityId
										+ "&patientName=" + patientName + "&encounterId=" + encounterId + "&speciality="
										+ speciality + "&customerGroupCode=" + customerGroupCode + "&customerCode="
										+ customerCode + "&customerGroupCode=" + customerGroupCode + "&policyCode="
										+ policyTypecode + "&mainAuth="+mainAuth+"&privilegeYN="+privilegeYN+"&authorizedUserName="+authorizedUserName+"' text-decoration='none'>" + com.ehis.util.BundleMessage
												.getBundleMessage(pageContext, "Common.previous.label", "common_labels")
										+ "</A>");

							}
							if (endOfRes.equals("1") && rowcount > end) {
								out.println(
										"<A id='nextval' HREF='../../eBL/jsp/BLInterimBillDetals.jsp?from=" + (start + 16)
												+ "&to=" + (end + 16) + "&patinetId=" + patientId + "&episodeType="
												+ episodeType + "&customerGroupCode=" + customerGroupCode + "&facility_id="
												+ facilityId + "&patientName=" + patientName + "&encounterId=" + encounterId
												+ "&speciality=" + speciality + "&customerGroupCode=" + customerGroupCode
												+ "&customerCode=" + customerCode + "&customerGroupCode=" + customerGroupCode
												+ "&policyCode="
												+ policyTypecode +"&mainAuth="+mainAuth+"&privilegeYN="+privilegeYN+"&authorizedUserName="+authorizedUserName+"' text-decoration='none'>" + com.ehis.util.BundleMessage
														.getBundleMessage(pageContext, "Common.next.label", "common_labels")
												+ "</A>");

							}
						}
				
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(start));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(end));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

						Iterator iterator = recordPreApprovalDataMap.keySet().iterator();
							String isDisabled = "disabled";
							String isReadOnly = "readonly onfocus='this.blur()'";
							if (recordPreApprovalDataMap.size() <= 0) {
								out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
							} else {	
								if (!(start == 1)) {
									for (int j = 1; j < start; i++, j++) {
										iterator.next();
									}

								}
								while (i <= end && iterator.hasNext()) {
									lastIndex = index;
									index = (Integer) iterator.next();
									int sNo = index + 1;
									rowcount = sNo;
									recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) recordPreApprovalDataMap.get(index);

									String BilledDate = "";
									String AdmissionDate = "";

									BilledDate = recordApprovalPatientDataBean.getBillDate();
									System.err.println("Billed Date  "+BilledDate);
									if (BilledDate != null && !(BilledDate.equals(""))) {
										SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
										BilledDate = sdf2.format(sdf1.parse(BilledDate));
									}
									AdmissionDate = recordApprovalPatientDataBean.getAdmissionDate();
									System.err.println("AdmissionDate   "+AdmissionDate);
									if (AdmissionDate != null && !(AdmissionDate.equals(""))) {
										SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
										AdmissionDate = sdf2.format(sdf1.parse(AdmissionDate));
									}
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(index));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPatientId() != null
								? recordApprovalPatientDataBean.getPatientId() : ""));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPatientId() != null
								? recordApprovalPatientDataBean.getPatientId() : ""));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPatientName() != null
								? recordApprovalPatientDataBean.getPatientName() : ""));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPatientName() != null
								? recordApprovalPatientDataBean.getPatientName() : ""));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recordApprovalPatientDataBean.getEpisodeId() != null
								? recordApprovalPatientDataBean.getEpisodeId() : ""));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recordApprovalPatientDataBean.getEpisodeId() != null
								? recordApprovalPatientDataBean.getEpisodeId() : ""));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(AdmissionDate));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(AdmissionDate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayerGroup() != null
								? recordApprovalPatientDataBean.getPayerGroup() : ""));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayerGroup() != null
								? recordApprovalPatientDataBean.getPayerGroup() : ""));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayer() != null
								? recordApprovalPatientDataBean.getPayer() : ""));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPayer() != null
								? recordApprovalPatientDataBean.getPayer() : ""));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicy() != null
								? recordApprovalPatientDataBean.getPolicy() : ""));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recordApprovalPatientDataBean.getPolicy() != null
								? recordApprovalPatientDataBean.getPolicy() : ""));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(UnbilledpriceFormat(recordApprovalPatientDataBean.getUnBuiledAmount())));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(UnbilledpriceFormat(recordApprovalPatientDataBean.getUnBuiledAmount())));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recordApprovalPatientDataBean.getBillNumber() != null
								? recordApprovalPatientDataBean.getBillNumber() : ""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recordApprovalPatientDataBean.getBillNumber() != null
								? recordApprovalPatientDataBean.getBillNumber() : " "));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(BilledDate));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(BilledDate));
            _bw.write(_wl_block47Bytes, _wl_block47);

							System.out.println("mainAuth check"+mainAuth+"::"+privilegeYN);
							if(mainAuth.equals("YY") && privilegeYN.equals("YY")){
								System.err.println("Inside Iff ");
							String  p_privilege_val="";
							String  p_allowed_yn="";
							CallableStatement cstmt=null;
							Connection	connection 	= ConnectionManager.getConnection();
							try{
							System.out.println("Inside Try");
							cstmt = connection.prepareCall("{ call blpolicyuseraccessdtls.get_bl_policy_privlege_yn(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?)}");
							System.out.println("After Callable Try");
							cstmt.setString(1, facilityId);
							cstmt.setString(2, authorizedUserName);
							cstmt.setString(3, "");
							cstmt.setString(4, "INTERIM_BILL_AUTH");
							cstmt.setString(5, recordApprovalPatientDataBean.getPayerGroup());
							cstmt.setString(6, recordApprovalPatientDataBean.getPayer());
							cstmt.setString(7, recordApprovalPatientDataBean.getPolicy());
							cstmt.setString(8, "BILL_AUTHORIZATION");
							cstmt.setString(9, new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
							cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
							cstmt.execute();	
							p_privilege_val = cstmt.getString(10);
							p_allowed_yn = cstmt.getString(11);
							System.out.println("password check"+p_privilege_val+"::"+p_allowed_yn);
							if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y")){
								disable="";
								System.out.println("disable check   "+disable);
							}else{
								disable="disabled";
								System.out.println("disable check   "+disable);
							}
							}
							catch(Exception ee)
							{
								//cstmt.close(); //V211020
								//connection.close();//V211020
								ee.printStackTrace();
							}finally{
								cstmt.close();
								connection.close();
							}
							
							}	
							
            _bw.write(_wl_block48Bytes, _wl_block48);
if(!disable.equals("disabled")){
							
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(index));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(index));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(start));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(end));
            _bw.write(_wl_block51Bytes, _wl_block51);
 	System.out.println("disable Applied   "+disable);}else{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(index));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(start));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(end));
            _bw.write(_wl_block53Bytes, _wl_block53);
 System.out.println("disable Applied   "+disable);}
            _bw.write(_wl_block54Bytes, _wl_block54);
	
					System.err.println(i);
						i++;
								}
					
            _bw.write(_wl_block55Bytes, _wl_block55);

				cnt++;
					}
					if (!iterator.hasNext() && cnt != 0) {
						endOfRes = "0";
					}
				} catch (Exception e) {
					System.out.println("Exception in BillingRecordApprovalPatientDataDeatils.jsp::" + e);
					e.printStackTrace();

				}
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(lastIndex));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(start));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(totalrowcount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(customerGroupCode));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rowcount));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(policyTypecode));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block72Bytes, _wl_block72);
            _bw.write(_wl_block73Bytes, _wl_block73);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SrlNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PayerGroup.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UnBilledAmount.Label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PreviousInterimBillDocNo.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BilledDate.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SelectAll.Label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL. AfterBillApproval.label", java.lang.String .class,"key"));
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
}
