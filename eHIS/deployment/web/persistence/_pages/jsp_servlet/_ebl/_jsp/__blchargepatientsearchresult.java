package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.Date;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import java.math.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __blchargepatientsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientSearchResult.jsp", 1741078149918L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n23-Oct-2012      100           \tKarthikeyan.K       created\n---------------------------------------------------------------------------------------------------------------\nSr No        Version           TFS/Incident        SCF/CRF            \t\t Developer Name\n--------------------------------------------------------------------------------------------------------\n1            V210129            13523         \tMOHE-CRF-0060       \t\t   Shikha Seth\n2            V220412            30399          MMS-ME-SCF-0064-TF               Mohanapriya K\n3\t\t\t V220801\t\t34676   \tBL-Deposit Receipt/Refund\t       Mohanapriya K\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\"javascript\" src=\"../../eBL/js/PkgDef.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BLChargePatient.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"> </script>\n<script language=\"javascript\" src=\"../../eBL/js/BLChargePatient.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BLChargePatientSearch.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\n\n<script>\n\nasync function callEncWin(encounter_date,encounter_id,patient_id,blng_grp_id,episode_id,visit_id,episode_type,payer_group,payer,policy,policyNum,acctSeq,encounterFacilityId,encPatID,encEncID) //V220412\n{  \n\tvar funct_name = parent.search_frame.document.report_form.funct_name.value;\n\tvar destPage = \"\";\n\tvar status=true;\n\tif(funct_name == \'BillGeneration\'){\n\t\tvar facility_id=$(\"#facility_id\").val();\n\t\tvar result = \'\';\n\t\tvar params = \'facilityId=\'+facility_id+\n\t\t\t\t\t\t\'&episodeType=\'+episode_type+\n\t\t\t\t\t\t\'&patientId=\'+patient_id+\n\t\t\t\t\t\t\'&episodeId=\'+episode_id+\n\t\t\t\t\t\t\'&visitId=\'+visit_id;\n\t\t//V220412\n\t\t$.ajax({\n\t\t\ttype:\"POST\",\n\t\t\turl:\"../jsp/BillReceiptAjax.jsp?calledFrom=validateCashCounter\",\n\t\t\tdata:params,\n\t\t\tdataType:\"json\",\n\t\t\tasync:false,\n\t\t\tsuccess: function(data){\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\tif(data.errorId != \'\'){\n\t\t\t\t\talert(getMessage(data.errorId,\'BL\'));\n\t\t\t\t\tstatus = false;\n\t\t\t\t}\n\t\t\t\tif(status && data.errorText != \'\'){\n\t\t\t\t\talert(data.errorText);\n\t\t\t\t\tstatus = false;\n\t\t\t\t}\n\t\t\t\tif(status && data.ipFlag == \'Y\'){\n\t\t\t\t\talert(getMessage(\'BL00942\',\'BL\'));\n\t\t\t\t}\t\t\n\t\t\t\tif(status && data.deceasedYn == \'Y\'){\n\t\t\t\t\talert(getMessage(\'BL00943\',\'BL\'));\n\t\t\t\t}\n\t\t\t\t\n\t\t\t},\n\t\t\t error: function(data){\n\t\t\t\t// alert(data);\t\t \n\t\t      }\n\t\t});\n\t\tdestPage = \"../../eBL/jsp/BillReceiptMainFrame.jsp?\";\n\t}\n\telse if(funct_name == \'depositandrefund\'){\n\t\tvar facility_id=$(\"#facility_id\").val();\n\t\tvar pat_id=patient_id;\n\t\t\n\t\tvar check=\"\";\n\t\t$.ajax({\n\t\t\t\ttype : \'POST\',\n\t\t\t\turl : \"../jsp/BlDepositremarks.jsp?&func_mode=dischargecheck&facility_id=\"\n\t\t\t\t\t+ facility_id\n\t\t\t\t\t+ \"&episode_id=\"\n\t\t\t\t\t+episode_id\n\t\t\t\t\t+\"&episode_type=\"\n\t\t\t\t\t+episode_type\n\t\t\t\t\t+ \"&pat_id=\"\n\t\t\t\t\t+pat_id,\n\t\t\t\t\tasync : false,\n\t\t\t\t\tdataType : \"text\",\n\t\t\t\t\tsuccess : function(data) {\n\t\t\t\t\t\tcheck=trimString(data);\n\t\t\t\t\t\tif(check==\"Y\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\talert(getMessage(\"BL2205\",\"BL\"));\n\t\t\t\t\t\t\t\tstatus=false;\n\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tstatus=true;\n\t\t\t\t\t\t\t\t\tdestPage = \"../../eBL/jsp/BLDepositRefundFrame.jsp?\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t});\t\t\n\t\t//destPage = \"../../eBL/jsp/BLDepositRefundFrame.jsp?\";\n\t}\n\telse{\n\t\tvar facility_id=$(\"#facility_id\").val();\n\t$.ajax({\n\t\t\ttype:\"POST\",\n\t\t\turl:\"../jsp/BLFutureOrder.jsp\",\n\t\t\tdata:\" &patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&episode_type=\"+episode_type+\"&facility_id=\"+facility_id,\t\n\t\t\tsuccess: function(data){\n\t\t\t\n\t\t\t\tvar data1=$.trim(data);\n\t\t\t\n\t\t\t\t\tif(data1==\'Y\'){\n\t\t\t\t\talert(getMessage(\'BL9859\',\'BL\'));\n\t\t\t\t}\n\t\t\t},\n\t\t\t error: function(data){\n\t\t\talert(\"error\");\n\t\t     }\n\t\t});\n\t\t\n\t\tdestPage = \"../../eBL/jsp/BLChargePatientEncounterFrame.jsp?\";\n\t}\n\t\n\tif(status)\n\t{\n\t\tvar url= destPage+\"encounter_date=\"+encounter_date+\"&blng_grp_id=\"+blng_grp_id+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&episode_type=\"+episode_type+\"&payerGroup=\"+payer_group+\"&payer=\"+encodeURIComponent(payer)+\"&policy=\"+policy+\"&policyNum=\"+policyNum+\"&acctSeqNum=\"+acctSeq+\"&encounterFacilityId=\"+encounterFacilityId+\"&patient_id=\"+encPatID+\"&encounter_id=\"+encEncID+\"&encoded=Y\";//V220412 //38842\n\t\tvar dialogHeight= \"94vh\" ;\n\t\tvar dialogWidth\t= \"85vw\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status: \" + status + \"; scroll=auto; center:yes\";\n\t\tvar popupWindow;\n\t\t\n\t\tpopupWindow = await top.window.showModalDialog(url,null,features);\n\t\t\n\t\tif(funct_name == \'BillGeneration\'){\n\t\t\t\n\n\t\t\tif(popupWindow != undefined && popupWindow != \'undefined\' ){\n\t\t\t\tvar retValArr = popupWindow.split(\':::\');\n\t\t\t\tif(retValArr[0] == \'Y\'){\n\t\t\t\t\t//if(parseInt(retValArr[3]) > 0){\n\t\t\t\t\t\tvar center=\'1\';\n\t\t\t\t\t\tvar dialogTop = \"0vh\";//220\n\t\t\t\t\t\tvar dialogHeight = \"92vh\" ;//100\n\t\t\t\t\t\tvar dialogWidth = \"90vw\" ;//70\n\t\t\t\t\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\t\t\t\tvar title=getLabel(\"eBL.BILL_SLMT_DTL.label\",\"BL\");\n\t\t\t\t\t\ttitle=encodeURIComponent(title);\t\n\t\t\t\t\t\tvar arguments = \"\" ;\n\t\t\t\t\t\tvar column_sizes = escape(\"\");               \n\t\t\t\t\t\tvar column_descriptions =\"\";\n\t\t\t\t\t\tvar param = \"title=\"+title+\n\t\t\t\t\t\t\t\t\t\"&\"+\"column_sizes=\"+column_sizes+\n\t\t\t\t\t\t\t\t\t\"&\"+\"column_descriptions=\"+column_descriptions+\n\t\t\t\t\t\t\t\t\t\"&\"+\"billdoctypecode=\"+retValArr[1]+\n\t\t\t\t\t\t\t\t\t\"&\"+\"billdocnum=\"+retValArr[2]+\n\t\t\t\t\t\t\t\t\t\"&\"+\"blnggrp=\"+blng_grp_id+\n\t\t\t\t\t\t\t\t\t\"&episode_type=\"+episode_type+\n\t\t\t\t\t\t\t\t\t\"&fromBillGen=Y\"+\n\t\t\t\t\t\t\t\t\t\"&userSlmtAmt=\"+retValArr[3]+\n\t\t\t\t\t\t\t\t\t\"&encounterFacilityId=\"+encounterFacilityId;\t//V210129 \n\t\t\t\t\t\tretVal= await top.window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMainIRB.jsp?\"+param,arguments,features);\n\t\t\t\t\t\t\n\t\t\t\t\t//}\n\t\t\t\t\t/* Commenting the old Settlement part \n\t\t\t\t\telse{\n\t\t\t\t\t\tvar dialogHeight    = \'40\' ;\n\t\t\t\t\t\t var dialogWidth = \'70\' ;\t\n\t\t\t\t\t\t var dialogTop = \'100\' ;\t \n\t\t\t\t\t\t var center    = \'1\'  ;\t\n\t\t\t\t\t\t var arguments =   \'\';\n\t\t\t\t\t\t var features    = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; center:\' + center +\'; dialogTop:\' + dialogTop +\'; status=no;\';\t\n\n\t\t\t\t\t\t var doctype = retValArr[1];\n\t\t\t\t\t\t var docnum = retValArr[2];\n\t\t\t\t\t\t var blnggrp = blng_grp_id;\n\t\t\t\t\t\t var genlater = \'Y\';\n\t\t\t\t\t\t var param=\"billdoctypecode=\"+doctype+\"&\"+\"billdocnum=\"+docnum+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"billgenlater=\"+genlater;\n\t\t\t\t\t\t //alert(param)\n\t\t\t\t\t\t var getUrl1  = \"../../eBL/jsp/BLReprintPopupPage.jsp?\"+param\n\t\t\t\t\t\t //var getUrl1 = \"../../eBL/jsp/BLChargePatientEncounterFrame.jsp?encounter_date=21/04/2014&encounter_id=101079180001&patient_id=DU00003900&blng_grp_id=CASH&episode_id=10107918&visit_id=1&episode_type=O&payerGroup=null&payer=null&policy=null&policyNum=null&acctSeqNum=1\";\n\n\t\t\t\t\t\t retVal = window.showModalDialog(getUrl1,arguments,features)\n\t\t\t\t\t} */\n\t\t\t\t}\n\t\t\t\t//$(parent.search_frame.document).find(\'#search_button\').trigger(\'click\');\n\t\t\t}\n\t\t\tparent.search_frame.document.getElementById(\'search_button\').click();\t\t\t\n\t\t}\n\t} \t\t\n} \n\n$(document).ready(function(){\n\tvar functName =  parent.search_frame.document.report_form.funct_name.value;\n\tparent.parent.dummyFrame.location.href= \'../../eCommon/html/blank.html\';\n\tif(functName != \'BillGeneration\'){\n\t\t//added by Vijay for bill generation patient deposit collection\t\t\n\t\t$(\'#depositcallhdr\').hide();\n\t\t$(\'td[id^=depositcall]\').each(function(){\n\t\t$(this).hide();\n\t\t});\n\t\t//ends ----\n\t\t\n\t\t$(\'td[id^=billGen]\').each(function(){\n\t\t\t$(this).hide();\n\t\t});\n\t}\n\telse{\n\t\tvar noOfDecimals = $(\'#noOfDecimals\').val();\n\t\t$(\'td[id^=billGenC]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\tif($(\'#episodeType\').val() == \'R\'){\n\t\t\t$(\'#depositcallhdr\').hide();\n\t\t\t$(\'td[id^=depositcall]\').each(function(){\n\t\t\t\t$(this).hide();\n\t\t\t});\n\t\t}\n\t}\n});\n\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'searchresult\' id=\'searchresult\' id=\'searchresult\' method=\'post\'>\n<!-- Next and Previous Link -->\n\t<table width=\"100%\" >\n\t\t<tr>\n\t\t\t<td align=\"right\">\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<A id=\'prevvalue\' HREF=\"javascript:loadSearchResults(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\n\t\t\t\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\" text-decoration=\'none\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<A id=\'nextvalue\' HREF=\"javascript:loadSearchResults(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\"  text-decoration=\'none\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\n\t<!-- Displays Data  -->\n\t<table border=\"2\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' class=\"grid\">\n\t<tr>\n<th class=\'columnheadercenter\' width=\'7.5%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n<td class=\'COLUMNHEADERCENTER\' width=\'10%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n<td class=\'COLUMNHEADERCENTER\' width=\'10%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n<td class=\'COLUMNHEADERCENTER\' width=\'15%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n<td class=\'COLUMNHEADERCENTER\' width=\'5%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\t\t\t\n<td class=\'COLUMNHEADERCENTER\' width=\'7%\' style = \"display:none\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\t\t\t\n<td class=\'COLUMNHEADERCENTER\' width=\'5%\' id=\'billGenH1\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n<td class=\'COLUMNHEADERCENTER\' width=\'5%\' id=\'billGenH2\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n<td class=\'COLUMNHEADERCENTER\' width=\'5.5%\' style = \"display:none\">Unadj Deposit</td>\n<td class=\'COLUMNHEADERCENTER\' width=\'5%\' style = \"display:none\">Payer Approval amount</td>\n<td class=\'COLUMNHEADERCENTER\' width=\'5%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n<td class=\'COLUMNHEADERCENTER\' width=\'3%\' id=\'billGenH3\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td> <!--added against MOHE-CRF-0039--> \n<td class=\'COLUMNHEADERCENTER\' width=\'3%\' id=\'depositcallhdr\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td> <!--added against MOHE-CRF-0039--> \n</tr>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<tr>\n\t<td nowrap class=\"QRYODD\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t<td nowrap class=\"QRYEVEN\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t<td nowrap class=\"QRYODD\"><a href=\"javascript:callEncWin(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\');\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a></td> <!--V220412--> \n\t<td nowrap class=\"QRYEVEN\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t<td nowrap class=\"QRYODD\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t<td nowrap class=\"QRYODD\" style = \"display:none\" >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t<td nowrap class=\"QRYODD\" id=\'billGenC1";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' style=\"text-align: right;\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t<td nowrap class=\"QRYODD\" id=\'billGenC2";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t<td nowrap class=\"QRYODD\" style = \"display:none\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t<td nowrap class=\"QRYODD\" id=\'billGenS";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'style=\"text-align: center;\"  >\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<img src=\'../../eBL/images/SelectSplClinic.png\'></img>\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<img src=\'../../eBL/images/UnSelectSplClinic.png\'></img>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t</td>\n\t<td nowrap class=\"QRYODD\" id=\'depositcall\' ><a href=\"javascript:deposit_call(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\">Collect</a>\n\t</td><!--V220412--> \n\t</tr>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<script>\t\n\tsetTimeout(function(){alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"))}, 100);\n\t</script>\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\'hidden\' name=\'noOfDecimals\' id=\'noOfDecimals\'  value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\'  value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\'  value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\t\n\n</form>\n</table>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n</BODY>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

public int returnInt(Object number){
	if(number==null|| number.equals("")){
		return 0;
	}
	else{
		return Integer.parseInt((String)number);
	}	
}

public double returnDouble(Object number){
	if(number==null|| number.equals("")){
		return 0;
	}
	else{
		return Double.parseDouble((String)number);
	}	
}

public String returnDateString(Object encounterDateValue) {	
	String eff_from_date="";
	if(encounterDateValue==null){
		return eff_from_date;
	}else{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Timestamp inputTimeStamp = Timestamp.valueOf(encounterDateValue.toString());
	long longTimeStamp = inputTimeStamp.getTime();
	eff_from_date=sdf.format(longTimeStamp);
	return eff_from_date;
	}
}

	
	private String checkForNull(String inputString)
	{
		if (inputString == null) return "";
		if(inputString.equals("null")) return "";
		
		return  inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

				session.removeAttribute("pkgClosedYN");
				session.removeAttribute("pkgSeqNum");
				if(session.getAttribute("pkgClosedYN")==null){
				session.setAttribute("pkgClosedYN","");
				session.setAttribute("pkgSeqNum","");
				}
				  
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null; 
	CallableStatement stmtBulk = null;

	String p_error_code = null;
	String p_error_text = null;
	String psysmessageid = null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	
 	int recordsPerPage=14;	
 	int totalRecord =0;
	int chunk_id = request.getParameter("chunk_id") == null ? 1	: Integer.parseInt(request.getParameter("chunk_id"));
		
	String facility_id = (String) session.getValue("facility_id");
	String p_dflt_type="A";
	String p_dflt_code="B";
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String patient_name =checkForNull(request.getParameter("patient_name"));
	String patient_name_cond = checkForNull(request.getParameter("patient_name_cond"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));//102343567	
	System.out.println("encounter_id "+encounter_id);
	String encounter_period_type = checkForNull(request.getParameter("encounter_period_type"));
	String encounter_from_date_str = checkForNull(request.getParameter("encounter_from_date"));
	String encounter_to_date_str = checkForNull(request.getParameter("encounter_to_date"));
	
	java.sql.Date encounter_from_date = null;
	java.sql.Date encounter_to_date = null;	
	String contact_no = checkForNull(request.getParameter("contact_no"));
	String contact_no_cond = checkForNull(request.getParameter("contact_no_cond"));
	System.out.println("contact_no_cond "+contact_no_cond);
	int age_from = returnInt(request.getParameter("age_from"));
	int age_to = returnInt(request.getParameter("age_to"));
	System.out.println("age_to after int "+age_to);
	String gender = checkForNull(request.getParameter("gender"));
	String location_type = checkForNull(request.getParameter("location_type"));
	String location_code = checkForNull(request.getParameter("location_code"));
	String doctor_name = checkForNull(request.getParameter("doctor_name"));
	String doctor_name_cond = checkForNull(request.getParameter("doctor_name_cond"));
	String payer_group = checkForNull(request.getParameter("payer_group"));
	String payer = checkForNull(request.getParameter("payer"));
	String payer_cond = checkForNull(request.getParameter("payer_cond"));
	String policy= checkForNull(request.getParameter("policy"));
	String policy_cond= checkForNull(request.getParameter("policy_cond"));
	String patient_type = checkForNull(request.getParameter("patient_type"));
	String episode_type = checkForNull(request.getParameter("episode_type"));
	if("A".equals(episode_type)){
		episode_type = "";
	}
	System.out.println("episode_type "+episode_type);
	int session_start_index=(chunk_id - 1)* recordsPerPage;
	int session_end_index=(chunk_id)* recordsPerPage;

	String encounter_period = checkForNull(request.getParameter("encounter_period"));
	String episode_status = checkForNull(request.getParameter("episode_status"));
	String sort_by=null;
	String addedById =(String)session.getValue("login_user");
	String modifiedById =(String)session.getValue("login_user");
	String addedAtWsno =p.getProperty("client_ip_address"); 
	String addedFacilityId =(String)session.getValue("facility_id");
	String modifiedAtWsno =p.getProperty("client_ip_address"); 
	String modifiedFacilityid =(String)session.getValue("facility_id");	
	String makeDefault =null;
	String nric = checkForNull(request.getParameter("nric"));
	String optionList = checkForNull(request.getParameter("optionList"));
	String facilityid = checkForNull(request.getParameter("facilityid")); //V210129 

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	Array tempArray = null;
	Timestamp[] encounterDateValues = null;
	BigDecimal[] encounterIdValues = null;
	String[] patientIdValues = null;
	String[] patientNameValues = null;
	String[] patientSexValues = null;
	String[] patientLocationValues = null;
	String[] doctorNameValues = null;
	String[] blngGroupIdValues = null;
	BigDecimal[] unbilledAmtValues = null;
	BigDecimal[] outstAmtValues = null; 
	BigDecimal[] totUnadjValues = null; 
	String[] payerNameValues = null;
	BigDecimal[] payerApprovalAmtValues = null;
	BigDecimal[]  episodeIdValues = null;
	BigDecimal[] visitIdValues =  null;
	String[] episodeTypeValues = null;
	
	String[] payerGroup = null;
	String[] policyCode = null;
	String[] policyNumber = null;
	String[] blngGrpDesc = null;
	BigDecimal[] acctSeqNo = null;
	BigDecimal[]  priorityNo = null;
	String[] specialClinic = new String[14];
	String[] encounterFacilityId = new String[2];	//V210129 
	String locale = (String)session.getAttribute("LOCALE"); //V210129 
	Calendar cal = Calendar.getInstance();	 
    	String noOfDecimals = "";

 	try{
 		con = ConnectionManager.getConnection(request);
 		noOfDecimals = BLHelper.getNoOfDecimals(con);
		stmtBulk = (CallableStatement) con.prepareCall("begin blpatsearch.search(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;"); //V210129 
		//stmtBulk.setString(1,facility_id); //V210129 Commented
		stmtBulk.setString(1,facilityid); //V210129 Added
		stmtBulk.setString(2,p_dflt_type);
		stmtBulk.setString(3,p_dflt_code);
		stmtBulk.setString(4,patient_id);
		stmtBulk.setString(5,patient_name);
		stmtBulk.setString(6,patient_name_cond);
		stmtBulk.setString(7,encounter_id);
		stmtBulk.setString(8,encounter_period);	
	if ("P".equals(encounter_period)) {
		if(encounter_from_date_str == null || "".equals(encounter_from_date_str)){
			stmtBulk.setString(9,null);
		}
		else{
			stmtBulk.setDate(9, new Date(format.parse(encounter_from_date_str).getTime()));
		}
		if(encounter_to_date_str == null || "".equals(encounter_to_date_str)){
			stmtBulk.setString(10,null);
		}
		else{
			stmtBulk.setDate(10, new Date(format.parse(encounter_to_date_str).getTime()));
		}
	} 	
	else{
		stmtBulk.setString(9,null);
		stmtBulk.setString(10,null);
	}
	stmtBulk.setString(11,contact_no);
	stmtBulk.setString(12,contact_no_cond);
	if(age_from == 0){
		stmtBulk.setString(13,null);
	}
	else{
		stmtBulk.setInt   (13,age_from);		
	}
	if(age_to == 0){
		stmtBulk.setString(14,null);
	}
	else{
		stmtBulk.setInt   (14,age_to);
	}
	stmtBulk.setString(15,gender);
	stmtBulk.setString(16,location_type);
	stmtBulk.setString(17,location_code);
	stmtBulk.setString(18,doctor_name);
	stmtBulk.setString(19,doctor_name_cond);
	stmtBulk.setString(20,payer_group);
	stmtBulk.setString(21,payer);
	stmtBulk.setString(22,payer_cond);
	stmtBulk.setString(23,policy);
	stmtBulk.setString(24,policy_cond);
	stmtBulk.setString(25,patient_type);
	stmtBulk.setString(26,episode_type);
	stmtBulk.setInt   (27,session_start_index);
	stmtBulk.setInt   (28,session_end_index);
	stmtBulk.setString(29,encounter_period);
	stmtBulk.setString(30,episode_status);
	stmtBulk.setString(31,sort_by);
	stmtBulk.setString(32,addedById);
	stmtBulk.setString(33,modifiedById);
	stmtBulk.setString(34,addedAtWsno);
	stmtBulk.setString(35,addedFacilityId);
	stmtBulk.setString(36,modifiedAtWsno);
	stmtBulk.setString(37,modifiedFacilityid);
	stmtBulk.setString(38,makeDefault);
	stmtBulk.setString(39,nric);
	stmtBulk.setString(40,optionList);	
	stmtBulk.registerOutParameter(41, Types.VARCHAR);
	stmtBulk.registerOutParameter(42, Types.VARCHAR);
	stmtBulk.registerOutParameter(43, Types.VARCHAR);
	stmtBulk.registerOutParameter(44, Types.ARRAY,"BL_ENCOUNTER_DATE_TYPE");
	stmtBulk.registerOutParameter(45, Types.ARRAY,"BL_ENCOUNTER_ID_TYPE");
	stmtBulk.registerOutParameter(46, Types.ARRAY,"BL_PATIENT_ID_TYPE");
	stmtBulk.registerOutParameter(47, Types.ARRAY,"BL_PATIENT_NAME_TYPE");
	stmtBulk.registerOutParameter(48, Types.ARRAY,"BL_SEX_TYPE");
	stmtBulk.registerOutParameter(49, Types.ARRAY,"BL_PATIENT_LOCATION_TYPE");
	stmtBulk.registerOutParameter(50, Types.ARRAY,"BL_DOCTOR_NAME_TYPE");
	stmtBulk.registerOutParameter(51, Types.ARRAY,"BL_BLNG_GRP_ID_TYPE");
	stmtBulk.registerOutParameter(52, Types.ARRAY,"BL_UNBILLED_AMOUNT_TYPE");
	stmtBulk.registerOutParameter(53, Types.ARRAY,"BL_OUTSTANDING_AMT_TYPE");
	stmtBulk.registerOutParameter(54, Types.ARRAY,"BL_UNADJ_DEPOSIT_AMT_TYPE");
	stmtBulk.registerOutParameter(55, Types.ARRAY,"BL_PAYER_NAME_TYPE");
	stmtBulk.registerOutParameter(56, Types.ARRAY,"BL_PAYER_APPROVAL_AMT_TYPE");
	stmtBulk.registerOutParameter(57, Types.ARRAY,"BL_CMN_TYPE_NUMBER");
	stmtBulk.registerOutParameter(58, Types.ARRAY,"BL_CMN_TYPE_NUMBER");
	stmtBulk.registerOutParameter(59, Types.ARRAY,"BL_CMN_TYPE_VARCHAR10");
	stmtBulk.registerOutParameter(60, Types.ARRAY,"BL_CMN_TYPE_VARCHAR10");
	stmtBulk.registerOutParameter(61, Types.ARRAY,"BL_CMN_TYPE_VARCHAR100");
	stmtBulk.registerOutParameter(62, Types.ARRAY,"BL_CMN_TYPE_VARCHAR100");
	stmtBulk.registerOutParameter(63, Types.ARRAY,"BL_CMN_TYPE_NUMBER");
	stmtBulk.registerOutParameter(64, Types.ARRAY,"BL_CMN_TYPE_NUMBER");
	stmtBulk.registerOutParameter(65, Types.ARRAY,"BL_BLNG_GRP_ID_TYPE");	
	stmtBulk.registerOutParameter(66, java.sql.Types.INTEGER);
	stmtBulk.registerOutParameter(67, Types.ARRAY,"BL_CMN_TYPE_VARCHAR10");
	stmtBulk.registerOutParameter(68, Types.ARRAY,"BL_CMN_TYPE_VARCHAR10"); //V210129 
	
	stmtBulk.executeUpdate();

	p_error_code = stmtBulk.getString(41);
	psysmessageid = stmtBulk.getString(42);
	p_error_text = stmtBulk.getString(43);
	
	tempArray = stmtBulk.getArray(44);
	if(tempArray != null){		
		try{
			encounterDateValues = (Timestamp[]) tempArray.getArray();
		}
		catch(Exception e){
			encounterDateValues = new Timestamp[1];
			e.printStackTrace();
		}
	}
	else{
		
		encounterDateValues = new Timestamp[1];
	}
	
	tempArray = stmtBulk.getArray(45);
	if(tempArray != null){
		
		try{
			encounterIdValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			encounterIdValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		encounterIdValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(46);
	if(tempArray != null){
		
		try{
			patientIdValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			patientIdValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		patientIdValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(47);
	if(tempArray != null){
		
		try{
			patientNameValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			patientNameValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		patientNameValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(48);
	if(tempArray != null){
		
		try{
			patientSexValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			patientSexValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		patientSexValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(49);
	if(tempArray != null){
		
		try{
			patientLocationValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			patientLocationValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		patientLocationValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(50);
	if(tempArray != null){
		
		try{
			doctorNameValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			doctorNameValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		doctorNameValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(51);
	if(tempArray != null){
		
		try{
			blngGroupIdValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			blngGroupIdValues = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		blngGroupIdValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(52);
	if(tempArray != null){
		
		try{
			unbilledAmtValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			unbilledAmtValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		unbilledAmtValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(53);
	if(tempArray != null  ){
		
		try{
			outstAmtValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			outstAmtValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{		
		outstAmtValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(54);
	if(tempArray != null){		
		try{
			totUnadjValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			totUnadjValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{		
		totUnadjValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(55);
	if(tempArray != null){
		
		try{
			payerNameValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			payerNameValues = new String[1];
			e.printStackTrace();
		}
	}
	else{		
		payerNameValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(56);
	if(tempArray != null){
		
		try{
			payerApprovalAmtValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			payerApprovalAmtValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{		
		payerApprovalAmtValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(57);
	if(tempArray != null){
		
		try{
			episodeIdValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			episodeIdValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		 episodeIdValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(58);
	if(tempArray != null){
		
		try{
			visitIdValues = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			visitIdValues = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		visitIdValues = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(59);
	if(tempArray != null){
		
		try{
			episodeTypeValues = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			episodeTypeValues = new String[1];
			e.printStackTrace();
		}
	}
	else{		
		episodeTypeValues = new String[1];
	}
	
	tempArray = stmtBulk.getArray(60);
	if(tempArray != null){
		
		try{
			payerGroup = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			payerGroup = new String[1];
			e.printStackTrace();
		}
	}
	else{		
		payerGroup = new String[1];
	}
	
	tempArray = stmtBulk.getArray(61);
	if(tempArray != null){
		
		try{
			policyCode = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			policyCode = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		policyCode = new String[1];
	}
	
	tempArray = stmtBulk.getArray(62);
	if(tempArray != null){
		
		try{
			policyNumber = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			policyNumber = new String[1];
			e.printStackTrace();
		}
	}
	else{
		
		policyNumber = new String[1];
	}
	
	tempArray = stmtBulk.getArray(63);
	if(tempArray != null){
		
		try{
			priorityNo = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			priorityNo = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		priorityNo = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(64);
	if(tempArray != null){
		
		try{
			acctSeqNo = (BigDecimal[]) tempArray.getArray();
		}
		catch(Exception e){
			acctSeqNo = new BigDecimal[1];
			e.printStackTrace();
		}
	}
	else{
		
		acctSeqNo = new BigDecimal[1];
	}
	
	tempArray = stmtBulk.getArray(65);
	if(tempArray != null){
		
		try{
			blngGrpDesc = (String[]) tempArray.getArray();
		}
		catch(Exception e){
			blngGrpDesc = new String[1];
			e.printStackTrace();
		}
	}
	else{		
		blngGrpDesc = new String[1];
	}		
	
	 totalRecord = stmtBulk.getInt(66);
	 
	 tempArray = stmtBulk.getArray(67);
		if(tempArray != null){
			
			try{
				specialClinic = (String[]) tempArray.getArray();
			}
			catch(Exception e){
				specialClinic = new String[1];
				e.printStackTrace();
			}
		}
		else{			
			specialClinic = new String[1];
		}
		//V210129 start		
		tempArray = stmtBulk.getArray(68);
		if(tempArray != null){			
			try{
				encounterFacilityId = (String[]) tempArray.getArray();
			}
			catch(Exception e){
				encounterFacilityId = new String[1];
				e.printStackTrace();
			}
		}
		else{			
			encounterFacilityId = new String[1];
		}
		//V210129 end			
 	}
 	catch(Exception e){
 		System.err.println("Exception in Search Result is ->"+e);
		e.printStackTrace();
 	}
 	finally{
 		ConnectionManager.returnConnection(con);
 	}

            _bw.write(_wl_block9Bytes, _wl_block9);

				if (chunk_id > 1) {
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_period ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_from_date_str ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_to_date_str ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_name ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_name_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(contact_no ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(contact_no_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(age_from ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(age_to ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(location_type ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(location_code ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(gender ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(doctor_name ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(doctor_name_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(payer_group ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(payer ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(payer_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(policy ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(policy_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_type ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_status ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(chunk_id - 1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(optionList ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nric ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facilityid ));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
				if(encounterIdValues.length==recordsPerPage && (chunk_id*recordsPerPage)!=totalRecord ){	
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_period ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_from_date_str ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_to_date_str ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_name ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_name_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(contact_no ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(contact_no_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(age_from ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(age_to ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(location_type ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(location_code ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(gender ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(doctor_name ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(doctor_name_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(payer_group ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(payer ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(payer_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(policy ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(policy_cond ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_type ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_status ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(chunk_id + 1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(optionList ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nric ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facilityid ));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	
				} 
			
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

	int sNo = 0;
	for (int k = 0; k < encounterIdValues.length; k++) {	
		String encounterDateValue=returnDateString(encounterDateValues[k]);	
		//V220801 starts
		String encEncID ="";
		System.err.println("BLChargePatientSearchResult.jsp ,enc_id "+encounterIdValues[k]);
		System.err.println("episode_type "+episode_type);
		if(episode_type.equalsIgnoreCase("R"))
			encEncID ="";
		else
			encEncID = new String(Base64.encodeBase64((encounterIdValues[k].toString()).getBytes()));
		//V220801 ends
		//V220412 Starts
		//String encEncID = new String(Base64.encodeBase64((encounterIdValues[k].toString()).getBytes()));//V220801
		String encPatID=new String(Base64.encodeBase64((patientIdValues[k].getBytes())));

		//V220412 Ends
		sNo++;
	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounterDateValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounterIdValues[k] == null ? "0": encounterIdValues[k]));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounterFacilityId[k] == null ? "": encounterFacilityId[k]));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounterDateValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounterIdValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientIdValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(blngGroupIdValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episodeIdValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(visitIdValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episodeTypeValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(payerGroup[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(payerNameValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(policyCode[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(policyNumber[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(acctSeqNo[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounterFacilityId[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encPatID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encEncID));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patientIdValues[k] == null ? "" : patientIdValues[k]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patientNameValues[k] == null ? ""	: patientNameValues[k]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patientSexValues[k] == null ? "": patientSexValues[k]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patientLocationValues[k] == null ? "": patientLocationValues[k]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(doctorNameValues[k] == null ? "": doctorNameValues[k]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(blngGroupIdValues[k] == null ? "": blngGroupIdValues[k]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(payerNameValues[k] == null ? "" : payerNameValues[k]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(unbilledAmtValues[k] == null ? ""	: unbilledAmtValues[k]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(outstAmtValues[k] == null ? "" : outstAmtValues[k]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totUnadjValues[k] == null ? "" : totUnadjValues[k]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(payerApprovalAmtValues[k] == null ? "": payerApprovalAmtValues[k]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(episodeIdValues[k] == null ? "": episodeIdValues[k]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(visitIdValues[k] == null ? "": visitIdValues[k]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block41Bytes, _wl_block41);
if("Y".equals(specialClinic[k])){ 
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{ 
            _bw.write(_wl_block43Bytes, _wl_block43);
} 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(episodeIdValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(visitIdValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( patientIdValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounterIdValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episodeTypeValues[k]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encPatID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encEncID));
            _bw.write(_wl_block45Bytes, _wl_block45);

		}
	if(sNo==0){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
	
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(noOfDecimals));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block51Bytes, _wl_block51);
            _bw.write(_wl_block52Bytes, _wl_block52);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Facility.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOCTOR_NAME.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_NAME.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNBILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitID.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Special_Clinic.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PatientDeposit.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
