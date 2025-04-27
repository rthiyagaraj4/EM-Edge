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
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __blviewpatencounterdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLViewPatEncounterDtls.jsp", 1730119242257L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nSr No        Version           TFS/Incident        SCF/CRF            \t\tDeveloper Name\n----------------------------------------------------------------------------------------------\n1\t\t\tV210517\t\t\t\t17598\t\t\tCommon-ICN-0034\t\t\t\tMohana Priya K\n----------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n</HEAD>\n<script>\n\nasync function funSurgeryAddlCharges(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)\n\t{\n\t\tvar params = document.forms[0].params.value;\n\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"70\";\n\t\tvar dialogHeight = \"42\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\n\t\tvar param=\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&patient_id=SD00000866\"+\"&episode_type=I\"+\"&episode_id=10002544\"+\"&visit_id=\"+\"&encounter_id=10002544\"+\"&pract_id=KATHRINA\"+\"&locn_code=IBA3\"+\"&role_pract_id=OPRSURG1||KATHRINA@@AMR1||DRANITA@@\"+\"&sec_key_main_oper_num=I080912001\"+\"&sec_key_main_order_id=OTIP00000014409\"+\"&str_order_catalog_code=0DTJ4ZZ|\";\t\n\t\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLSurgeryAddlChargeFrame.jsp?\"+param,arguments,features);\n\t\tvar str =unescape(retVal);\n\t\tvar arr = str.split(\",\");\n\t\talert(arr[0]);\n\t}\n\nasync function funEnterReceiptRefund(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)\n\t{\n\t\tstrPatientId=\"HC00004262\";\n\t\tstrEpisodeType=\"I\";\n\t\tstrEpisodeId=\"10019075\";\n\t\tstrEncounterId=\"10019075\";\n\t\tstrLocnCode=\"CCU\";\n\n\t\tvar params = document.forms[0].params.value;\n\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"70\";\n\t\tvar dialogHeight = \"42\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param=\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&patient_id=\"+strPatientId+\"&encounter_id=\"+strEncounterId+\"&episode_type=\"+strEpisodeType+\"&episode_id=\"+strEpisodeId+\"&nursing_unit_code=\"+strLocnCode;\t\n\n\t\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?\"+param,arguments,features);\n\t}\n\t\nasync function funAdhocDisc(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)\n\t{\n\t\tvar params = document.forms[0].params.value;\n\t\tstrPatientId = \"HC00011186\";\n\t\tstrEpisodeType = \"O\";\n\t\tstrEpisodeId = \"10083669\";\n\t\tstrVisitId = \"1\";\n\t\tstrEncounterId = \"100836690001\";\n\t\tstrPractId = \"AZWAN\";\n\t\tstrLocnCode = \"\";\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"10\";\n\t\tvar dialogHeight = \"90vh\" ;\n\t\tvar dialogWidth = \"90vw\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param=\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&patient_id=\"+strPatientId+\"&episode_type=\"+strEpisodeType+\"&episode_id=\"+strEpisodeId+\"&visit_id=\"+strVisitId+\"&encounter_id=\"+strEncounterId+\"&pract_id=\"+strPractId+\"&locn_code=\"+strLocnCode;\t\n\t\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLAdhocDiscFrame.jsp?\"+param,arguments,features);\n\t}\t\n\n/*\tfunction funEnterServiceRequest(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)\n\t{\n\t\tvar params = document.forms[0].params.value;\n\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"70\";\n\t\tvar dialogHeight = \"42\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar title=\"Enter Service Request\";\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&patient_id=\"+strPatientId+\"&episode_type=\"+strEpisodeType+\"&episode_id=\"+strEpisodeId+\"&visit_id=\"+strVisitId+\"&encounter_id=\"+strEncounterId+\"&pract_id=\"+strPractId+\"&locn_code=\"+strLocnCode;\n\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLEnterServiceRequestSearchMain.jsp?\"+param,arguments,features);\n\t}\t\n*/\n/*\n\tfunction funViewEncounterDet(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strLocnCode)\n\t{\n\t\talert(\"ram\");\n\t\tvar visit_id = strVisitId;\t\n\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"220\";\n\t\tvar dialogHeight = \"100\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar title=\"\";\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\t//var param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"visit_id=\"+visit_id+\"&patient_id=\"+strPatientId+\"&episode_type=\"+strEpisodeType+\"&episode_id=\"+strEpisodeId+\"&visit_id=\"+visit_id+\"&encounter_id=\"+strEncounterId;\n\t\tvar billdoctypecode=\"HSBLOP\";\n\t\tvar strbilldocnum=\"50005306\";\n\t\tvar strblnggrpid=\"2C\";\n\n\t\tvar param=\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billdoctypecode=\"+billdoctypecode+\"&\"+\"billdocnum=\"+strbilldocnum+\"&\"+\"blnggrp=\"+strblnggrpid+\"&episode_id=\"+strEpisodeId+\"&visit_id=\"+visit_id+\"&encounter_id=\"+strEncounterId;\t\n\t\talert(param);\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMain.jsp?\"+param,arguments,features);\n\n\t\talert(retVal);\n\t}\n*/\n\n\n\tasync function funViewEncounterDet(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strLocnCode)\n\t{\n\t\t//var episode_type =strEpisodeType;\n\t\t//var patient_id = strPatientId;\t\n\t\tvar visit_id = strVisitId;\t\n\t\t//var episode_id = strEpisodeId;\t\n\t\t//var encounterid = strEncounterId;\t\t\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"10px\";\n\t\tvar dialogHeight = \"400px\" ;\n\t\tvar dialogWidth = \"1100px\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar title=\"\";\n\t\ttitle=encodeURIComponent(title);\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"visit_id=\"+visit_id+\"&patient_id=\"+strPatientId+\"&episode_type=\"+strEpisodeType+\"&episode_id=\"+strEpisodeId+\"&visit_id=\"+visit_id+\"&encounter_id=\"+strEncounterId;\n\t\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLViewEncounterBillDetMain.jsp?\"+param,arguments,features);\n\t}\n\nasync function funVwEditVisitRegOrders(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)\n\t{\n\t\tvar params = document.forms[0].params.value;\n\t\tvar patient_class=\"\";\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"70\";\n\t\tvar dialogHeight = \"42\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param=\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&patient_id=\"+strPatientId+\"&episode_type=\"+strEpisodeType+\"&episode_id=\"+strEpisodeId+\"&visit_id=\"+strVisitId+\"&encounter_id=\"+strEncounterId+\"&pract_id=\"+strPractId+\"&locn_code=\"+strLocnCode+\"&patient_class=\"+patient_class;\t\n\t\tretVal= await window.showModalDialog(\"../../eBL/jsp/OrderEntryBillingFrameset.jsp?\"+param,arguments,features);\n\t\tif(retVal==\"undefined\" || retVal==\"2\" || retVal==null)\n\t\t{\n\t\t\talert(\"Cancelled\");\n\t\t}\n\t\telse\n\t\t{\n\t\t\talert(\"Success\");\n\t\t}\n\t}\t\n\n\tasync function funVwEditBillReimburseAmt(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId,strPractId,strLocnCode)\n\t{\n\t\tvar params = document.forms[0].params.value;\n\t\tvar patient_class=\"\";\n\t\tvar center=\'1px\';\n\t\tvar dialogTop = \"0px\";\n\t\tvar dialogHeight = \"95vh\" ;\n\t\tvar dialogWidth = \"95vw\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\t\tvar param=\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&patient_id=\"+strPatientId+\"&episode_type=\"+strEpisodeType+\"&episode_id=\"+strEpisodeId+\"&visit_id=\"+strVisitId+\"&encounter_id=\"+strEncounterId+\"&pract_id=\"+strPractId+\"&locn_code=\"+strLocnCode+\"&patient_class=\"+patient_class+\"&\"+params;\t\n\t\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLBillReimburseAmtCall.jsp?\"+param,arguments,features);\n\t\tif(retVal == null || retVal == \"null\" || retVal == undefined || retVal == \"undefined\")\n\t\t{\n\t\t\tretVal == \"\";\n\t\t}\n\n\t\tif(retVal == \"Y\")\n\t\t{\n\t\t\talert(getMessage(\"BL7356\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t}\n\n\tfunction no_record_check()\n\t{\t\n\t\tvar total_records=document.forms[0].total_records.value;\t\t\t\n\t\tif(total_records==0)\n\t\t{\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t}\t\t\t\n\t}\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLPatientEncounters.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\n\t\t<style>\n\t\tthead td, thead td.locked\t{\n\t\tbackground-color: navy;\n\t\tcolor: white;\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-2); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\t</style>\n\n\n<body onLoad=\"no_record_check();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n<form name=\'view_enctr_bill_det\' id=\'view_enctr_bill_det\' method=\'post\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<div>\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align = \'center\' id=\'\' width=\'100%\'>\t\t\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'10\'><div align=\'left\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="--";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</div> </td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\n\t\t\t\t<td width=\"80%\" class=\'label\'>&nbsp;</td>\t\t\t\n\t\t\t\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</div>\n\t\t<div id=\"tbl-container\" STYLE=\"overflow: auto; width: 100%; height: 480px;   padding:3px; margin: 0px\">\n\t\t<table border=\'\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\t\n\t\t<thead>\n\t\t\t<tr>\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'12%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\t\t\t\n\t\t\t</tr>\n\t\t</thead>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<tbody>\n\t\t\t<tr id=row";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">\t\t\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" width=\'10%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" width=\'10%\'><a name=\'doc_num";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' href=\"#\" onClick=\"javascript:funViewEncounterDet(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</a></td>\t \n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' href=\"#\" onClick=\"javascript:funEnterServiceRequest(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' href=\"#\" onClick=\"javascript:funEnterReceiptRefund(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' href=\"#\" onClick=\"javascript:funAdhocDisc(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' href=\"#\" onClick=\"javascript:funSurgeryAddlCharges(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' href=\"#\" onClick=\"javascript:funVwEditVisitRegOrders(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' href=\"#\"\t onClick=\"javascript:funVwEditBillReimburseAmt(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</a></td> \n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' href=\"#\" onClick=\"javascript:funVwEditBillReimburseAmt(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" width=\"15%\" >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" width=\'15%\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" width=\"12%\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\t\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" width=\"10%\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\t\t\t\t\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" width=\"6%\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td> \t\t\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" width=\"5%\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t</tbody>\n\t\t</table>\n\t\t</div>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t<script></script>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\t\n\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\t\n\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\t\n\t\n</form>\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt = null; 
	ResultSet rsdt=null;
	ResultSet rs1	=null;ResultSet rs2=null;ResultSet rs3=null;	
	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";	
	String classval=""; String strFacilityId=""; int total_records=0;
	String strPatientId="";String p_episode_id="";String p_visit_id="";String p_episode_type="";
	String p_encntr_to_date="";String p_encntr_from_date="";
	String strEpisodeType="";String strEpisodeId="";String strVisitId="";String strEncounterId="";String strAdmVstDate="";
	String strDischargeDate="";	String strAdmVstStatus="";String strCurrRoomNo="";String strCurrBedNo="",strPractId="",strLocnCode="";
	String strLocationDesc="";	String strPayerName="";
	String strPriviledge=""; String patln="";  String epsode_type_leb="";String system_date="";String function_id="",params="",p_ward_clinic_code="";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
	String strTitle=(String) common_labels.getString("Common.PatientDetails.label");

	Properties p = (Properties)httpSession.getValue("jdbc");
	String ws_no = p.getProperty("client_ip_address");
	try
	{
		con	=	ConnectionManager.getConnection(request);

		strFacilityId = (String)httpSession.getValue("facility_id");
		if(strFacilityId==null) strFacilityId="";

		strPatientId = request.getParameter("sel_patient_id");
		if(strPatientId==null) strPatientId="";	
		
		p_episode_type = request.getParameter("sel_episode_type");
		if(p_episode_type==null) p_episode_type="";	
		
		p_episode_id = request.getParameter("sel_episode_id");
		if(p_episode_id==null) p_episode_id="";	
		
		p_visit_id = request.getParameter("sel_visit_id");
		if(p_visit_id==null) p_visit_id="";	
		
		p_encntr_to_date = request.getParameter("sel_encounter_to_date");
		if(p_encntr_to_date==null) p_encntr_to_date="";	
		
		p_encntr_from_date = request.getParameter("sel_encounter_from_date");
		if(p_encntr_from_date==null) p_encntr_from_date="";	
		
		function_id = request.getParameter("function_id");
		if(function_id==null) function_id="";

//		function_id = "EBL_ENTER_RECEIPT_REFUND";

		p_ward_clinic_code = request.getParameter("sel_ward_clinic_code");
		if(p_ward_clinic_code==null) p_ward_clinic_code="";	
		
		params = request.getQueryString();
		if(params==null) params="";	
		
		try
		{
			CallableStatement call = con.prepareCall("{ ? = call  get_patient_line(?,?)}");	
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.setString(2,strPatientId);
			call.setString(3,locale);
			call.execute();							
			patln = call.getString(1);				
			call.close();
			if ( patln == null ) patln = "";
			int ind=patln.indexOf("#");
			patln=patln.substring(0,ind);
			if ( patln == null ) patln = "";

			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			stmt = con.createStatement();
			rsdt = stmt.executeQuery(query_date) ;
			if( rsdt != null ) 
			{
				while( rsdt.next() )
				{  
					system_date = rsdt.getString(1);
				}
			}
			if (stmt != null) stmt.close(); //V210517
			if (rsdt != null) rsdt.close(); //V210517
			//stmt.close();
			//rsdt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in Sys Date :"+e);
			e.printStackTrace();
		}

            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		try
		{	
			if(!p_encntr_from_date.equals(""))
			{
				p_encntr_from_date = p_encntr_from_date+" 00:00:00";
			}
			else
			{	
				p_encntr_from_date = "01/01/1800 00:00:00";
			}

			if(!p_encntr_to_date.equals(""))
			{
				p_encntr_to_date = p_encntr_to_date+" 23:59:59";
			}
			else
			{
				p_encntr_to_date = system_date;
			}
			String sqlPatEncDet="Select EPISODE_TYPE, EPISODE_ID||'/'||VISIT_ID ENCOUNTER_ID, to_char(ADM_VISIT_DATE,'DD/MM/YYYY HH24:MI:SS') ADM_VISIT_DATE1, to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') DISCHR_DATE_TIME, ADM_VISIT_STATUS, CUR_ROOM_NUM, CUR_BED_NUM,LOCN_DESC,EPISODE_ID,VISIT_ID,PHYSICIAN_ID, LOCN_CODE from BL_ENCOUNTER_FOR_QRY_VW where NVL(LANGUAGE_ID,'"+locale+"') ='"+locale+"'   and FACILITY_ID = '"+strFacilityId+"' and PATIENT_ID  =  '"+strPatientId+"' and  ADM_VISIT_DATE between to_date('"+p_encntr_from_date+"','dd/mm/yyyy HH24:MI:SS') and to_date('"+p_encntr_to_date+"','dd/mm/yyyy HH24:MI:SS')";
			
			if(!p_episode_type.equals(""))
			{
				sqlPatEncDet=sqlPatEncDet+ " and EPISODE_TYPE='"+p_episode_type+"' ";
			}
			if(!p_episode_id.equals(""))
			{
				sqlPatEncDet=sqlPatEncDet+ " and EPISODE_ID='"+p_episode_id+"' ";
			}
			if(!p_visit_id.equals(""))
			{
				sqlPatEncDet=sqlPatEncDet+ " and VISIT_ID='"+p_visit_id+"' ";
			}

			if(!p_ward_clinic_code.equals(""))
			{
				sqlPatEncDet=sqlPatEncDet+ " and LOCN_CODE='"+p_ward_clinic_code+"' ";
			}

			if(p_episode_type.equals("R"))
			{
				sqlPatEncDet=sqlPatEncDet+ " UNION select 'R' EPISODE_TYPE, PATIENT_ID ENCOUNTER_ID, NULL ADM_VISIT_DATE, NULL DISCHR_DATE_TIME, NULL ADM_VISIT_STATUS, NULL CUR_ROOM_NUM, NULL CUR_BED_NUM, NULL LOCN_DESC, NULL EPISODE_ID, NULL VISIT_ID, NULL PHYSICIAN_ID, NULL LOCN_CODE from bl_patient_fin_dtls where patient_id='"+strPatientId+"'";
			}
			else
			{
				sqlPatEncDet=sqlPatEncDet+ " order by ADM_VISIT_DATE desc";
			}

//			sqlPatEncDet=sqlPatEncDet+ " order by to_date(ADM_VISIT_DATE,'dd/mm/yyyy HH24:MI:SS') desc";

//			System.out.println("sqlPatEncDet 1: "+sqlPatEncDet);
			HashMap sqlMap = new HashMap();
			sqlMap.put("sqlData",sqlPatEncDet);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("EPISODE_TYPE");
			displayFields.add("ENCOUNTER_ID");
			displayFields.add("ADM_VISIT_DATE1");
			displayFields.add("DISCHR_DATE_TIME");
			displayFields.add("ADM_VISIT_STATUS");
			displayFields.add("CUR_ROOM_NUM");
			displayFields.add("CUR_BED_NUM");
			displayFields.add("LOCN_DESC");
			displayFields.add("EPISODE_ID");
			displayFields.add("VISIT_ID");
			displayFields.add("PHYSICIAN_ID");
			displayFields.add("LOCN_CODE");
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

			//out.println("resutl==>"+result.size());
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strTitle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patln));
            _bw.write(_wl_block11Bytes, _wl_block11);
			
				out.println(result.get(1));

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			if(p_episode_type.equals("R"))
			{

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
			else
			{

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			}

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			int i=0;	
			ArrayList records=new ArrayList();
			for(int j=2; j<result.size(); j++)
			{
   				if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
				records=(ArrayList) result.get(j);		
				
				strEpisodeType = (String)records.get(0);
				if(strEpisodeType==null) strEpisodeType="";
				
				if(strEpisodeType.equals("R"))
				{
					strPatientId = (String)records.get(1);
					if(strPatientId==null) strPatientId="";
				}
				else
				{
					strEncounterId = (String)records.get(1);
					if(strEncounterId==null) strEncounterId="";
				}
				
				strAdmVstDate = (String)records.get(2);
				if(strAdmVstDate==null) strAdmVstDate="";
				
				strDischargeDate = (String)records.get(3);
				if(strDischargeDate==null) strDischargeDate="";
				
				strAdmVstStatus = (String)records.get(4);
				if(strAdmVstStatus==null) strAdmVstStatus="";
				
				strCurrRoomNo = (String)records.get(5);
				if(strCurrRoomNo==null) strCurrRoomNo="";
				
				strCurrBedNo = (String)records.get(6);
				if(strCurrBedNo==null) strCurrBedNo="";
				
				strLocationDesc = (String)records.get(7);
				if(strLocationDesc==null) strLocationDesc="";
				
				strEpisodeId = (String)records.get(8);
				if(strEpisodeId==null) strEpisodeId="";
				
				strVisitId = (String)records.get(9);
				if(strVisitId==null) strVisitId="";
				
				strPractId = (String)records.get(10);
				if(strPractId==null) strPractId="";

				strLocnCode = (String) records.get(11);
				if(strLocnCode==null) strLocnCode="";
				
				if(strEpisodeType.equals("I"))
				{																
					epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				}
				else if(strEpisodeType.equals("D"))
				{
					epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
				}
				else if(strEpisodeType.equals("O"))
				{
					epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				}
				 else if(strEpisodeType.equals("R"))
				{
					 epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
				}
				 else if(strEpisodeType.equals("E"))
				{
					 epsode_type_leb=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				}

				if(!strEpisodeId.equals(""))
				{
					String sqlEncounterId="select encounter_id from pr_encounter where episode_id='"+strEpisodeId+"' and facility_id='"+strFacilityId+"'";

					if(!strVisitId.equals("") && !strVisitId.equals("0"))
					{
						sqlEncounterId=sqlEncounterId+" and OP_EPISODE_VISIT_NUM='"+strVisitId+"'";
					}
					pstmt = con.prepareStatement(sqlEncounterId);
					rs1 = pstmt.executeQuery();	
					while(rs1.next())
					{
						strEncounterId= rs1.getString(1);
						if(strEncounterId==null) strEncounterId="";
					}
					if (rs1 != null)   rs1.close();
					if (pstmt != null) pstmt.close();
				}
				
				if(strEpisodeType.equals("R"))
				{						 
					String sqlPriviledge="Select LONG_DESC Priviledge, SHORT_NAME Payer_name From bl_patient_fin_dtls a, bl_blng_grp_lang_vw b, ar_customer_lang_vw c Where patient_id = '"+strPatientId+"' And a.blng_grp_id = b.blng_grp_id and b.language_id = '"+locale+"' and a.cust_code = c.cust_code and c.language_id = '"+locale+"' ";
				
					pstmt = con.prepareStatement(sqlPriviledge);
				    rs1 = pstmt.executeQuery();	
					while(rs1.next())
					{
						strPriviledge = rs1.getString(1);
						if(strPriviledge==null) strPriviledge="";
						 strPayerName = rs1.getString(2);
						 if(strPayerName==null) strPayerName="";
						}
						if (rs1 != null)   rs1.close();
						if (pstmt != null) pstmt.close();	
				}
				else if(strEpisodeType.equals("I")||strEpisodeType.equals("D"))
				{
					String sqlPriviledge1=" Select LONG_DESC Priviledge, SHORT_NAME Payer_name From bl_episode_fin_dtls a, bl_blng_grp_lang_vw b, ar_customer_lang_vw c Where patient_id = '"+strPatientId+"' And a.episode_type = '"+strEpisodeType+"' And a.episode_id ='"+strEpisodeId+"' And a.blng_grp_id = b.blng_grp_id and b.language_id = '"+locale+"'  and a.cust_code = c.cust_code and c.language_id = '"+locale+"' ";
					pstmt = con.prepareStatement(sqlPriviledge1);
					rs2 = pstmt.executeQuery();	
					while(rs2.next())
					{
						strPriviledge = rs2.getString(1);
						if(strPriviledge==null) strPriviledge="";
						strPayerName = rs2.getString(2);
						if(strPayerName==null) strPayerName="";
					}
					if (rs2 != null)   rs2.close();
					if (pstmt != null) pstmt.close();	
				}
				else if(strEpisodeType.equals("O")||strEpisodeType.equals("E"))
				{
					String sqlPriviledge2="Select LONG_DESC Priviledge, SHORT_NAME Payer_name From bl_visit_fin_dtls a, bl_blng_grp_lang_vw b, ar_customer_lang_vw c Where patient_id = '"+strPatientId+"' And a.episode_type ='"+strEpisodeType+"' And a.episode_id='"+strEpisodeId+"'  And a.visit_id = '"+strVisitId+"' And a.blng_grp_id = b.blng_grp_id and b.language_id = '"+locale+"' and a.cust_code = c.cust_code and c.language_id = '"+locale+"' ";

					pstmt = con.prepareStatement(sqlPriviledge2);
					rs3 = pstmt.executeQuery();	
					while(rs3.next())
					{
						strPriviledge = rs3.getString(1);
						if(strPriviledge==null) strPriviledge="";
						strPayerName = rs3.getString(2);
						if(strPayerName==null) strPayerName="";
					}
					if (rs3 != null)   rs3.close();
					if (pstmt != null) pstmt.close();	
				}

				strAdmVstDate = com.ehis.util.DateUtils.convertDate(strAdmVstDate,"DMYHMS","en",locale);
				strDischargeDate = com.ehis.util.DateUtils.convertDate(strDischargeDate,"DMYHMS","en",locale);

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(epsode_type_leb));
            _bw.write(_wl_block26Bytes, _wl_block26);

				if(function_id.equals("EBL_QRY_PAT_ENCNTR"))
				{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strLocnCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block32Bytes, _wl_block32);

				}
			//	if(function_id.equals("EBL_ENTER_SERV_REQ"))
			if(function_id.equals("Serivice_Request"))
				{

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPractId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strLocnCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block32Bytes, _wl_block32);

				}

				if(function_id.equals("EBL_ENTER_RECEIPT_REFUND"))
				{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPractId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strLocnCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block32Bytes, _wl_block32);

				}

				if(function_id.equals("EBL_TEMP_DISC_FUN"))
				{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPractId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strLocnCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block32Bytes, _wl_block32);

				}

				if(function_id.equals("SURGERY_ADDL_CHARGE_DTLS"))
				{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPractId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strLocnCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block32Bytes, _wl_block32);

				}
				if(function_id.equals("EBL_VW_EDIT_OP_ORDERS"))
				{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPractId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strLocnCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block32Bytes, _wl_block32);

				}
				if(function_id.equals("EBL_OP_OVERRIDE_REIM_DTLS") || function_id.equals("EBL_IP_OVERRIDE_REIM_DTLS") ||  function_id.equals("EBL_OP_OVERIDE_UNBLD_REIM_DTLS") || function_id.equals("EBL_IP_OVERIDE_UNBLD_REIM_DTLS"))
				{
					if(strEpisodeType.equals("R"))
					{

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPractId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strLocnCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block41Bytes, _wl_block41);

					}
					else
					{

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPractId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strLocnCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block41Bytes, _wl_block41);

					}
				}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((strAdmVstDate==null || strAdmVstDate.equals(""))?"&nbsp;":strAdmVstDate));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((strDischargeDate==null || strDischargeDate.equals(""))?"&nbsp;":strDischargeDate));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((strPriviledge==null || strPriviledge.equals(""))?"&nbsp;":strPriviledge));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((strPayerName==null || strPayerName.equals(""))?"&nbsp;":strPayerName));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((strLocationDesc==null || strLocationDesc.equals(""))?"&nbsp;":strLocationDesc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf((strAdmVstStatus==null || strAdmVstStatus.equals(""))?"&nbsp;":strAdmVstStatus));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf((strCurrRoomNo==null || strCurrRoomNo.equals(""))?"&nbsp;":strCurrRoomNo));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf((strCurrBedNo==null || strCurrBedNo.equals(""))?"&nbsp;":strCurrBedNo));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strPractId));
            _bw.write(_wl_block55Bytes, _wl_block55);

				i++;
				total_records++; 
			}//for loop

            _bw.write(_wl_block56Bytes, _wl_block56);

				out.flush();
			}
			else
			{


            _bw.write(_wl_block57Bytes, _wl_block57);

			 }
		}
		catch(Exception ee)
		{
			System.out.println("Exception in pat Enctr qry" +ee);
			ee.printStackTrace();
		}

	}
	catch(Exception eee)
	{
		System.out.println("Exception main"+ eee);
		eee.printStackTrace();
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(params));
            _bw.write(_wl_block61Bytes, _wl_block61);
out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLViewPatEncounterDtls.jsp",searched));
            _bw.write(_wl_block62Bytes, _wl_block62);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRIMARY_PRIVILEGE.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRIMARY_PAYER.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
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
}
