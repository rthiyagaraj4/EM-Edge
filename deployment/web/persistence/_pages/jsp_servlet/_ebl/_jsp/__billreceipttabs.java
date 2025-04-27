package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.util.*;
import java.text.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __billreceipttabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptTabs.jsp", 1740492195400L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<title>Charge Patient</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/></link>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<script>\n function callOnMouseOver(obj){\n\t\tcurrClass = obj.className ;\n\t\t\tobj.className = \'CASECONDSELECTHORZ\';\n\t}\n\n\tfunction callOnMouseOut(obj){\n\t\tobj.className = currClass;\n\t}\n\n\tfunction changeColor(obj,from_name)\n\t{\n\t\tif(from_name==\"OR_BUTTONS\")\n\t\t\tcellref = criteriaCategoryButtonFrame.document.getElementById(\"tab\").rows[0].cells\n\t\telse if(from_name==\"COMMON\")\n\t\t\tcellref = document.getElementById(\"tab\").rows[0].cells\n\t\tfor(i=0; i<cellref.length; i++)\n\t\t{\n\t\t\t//if(i!=2 && i!=3)\n\t\t\t cellref[i].className = \'CAFIRSTSELECTHORZ\'\n\t\t}\n\t\tobj.className = \"CASECONDSELECTHORZ\"\n\t\tcurrClass =\"CASECONDSELECTHORZ\";\n\t}\n\t\n\tfunction billCumReceipt(){\n\t\t//alert(\"2\");\n\t\tchangeColor(this,\'COMMON\');\t\t\n\t\tvar queryString = $(\'#queryString\').val();\n\t\t//parent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesExisting\').value;\n\t\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'4vh\';\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'25vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'18vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'20vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'16vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\tparent.BillReceiptExisOrderSearch.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t\n\t\tparent.messageFrame1.location.href = \'../../eCommon/jsp/error.jsp\';\n\t\tparent.BillReceiptInfo.location.href=\'BillReceiptInfo.jsp?\'+queryString;\t\t\n\t\t//parent.BillReceiptWindow.location.href = \'BillReceiptEncBillDetails.jsp?\'+queryString;\n\t}\n\t\n\tfunction otherOutStanding(){\n\t\t//alert(\"1\");\n\t\tchangeColor(this,\'COMMON\');\t\n\t\tvar queryString = $(\'#queryString\').val();\n\t\tvar unBilled = $.trim($(parent.BillReceiptInfo.document).find(\'#unBillAmt\').text());\n\t\tvar outStCash = $.trim($(parent.BillReceiptInfo.document).find(\'#outstCash\').text());\n\t\tvar outStCredit = $.trim($(parent.BillReceiptInfo.document).find(\'#outstCredit\').text());\n\t\tvar totOutSt = parseInt(outStCash)+parseInt(outStCredit);\n\t\t\t//parent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesOtherOut\').value;\n\t\t\n\t\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'6vh\';\t\t\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'7vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'60vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'7vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\tparent.BillReceiptExisOrderSearch.location.href=\'BillReceiptOtherOutStandingTab.jsp?\'+queryString;\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'BillReceiptTotOutstUnBilled.jsp?\'+queryString;\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.BillReceiptWindow.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.messageFrame1.location.href=\'../../eCommon/jsp/error.jsp\';\t\n\t}\n\t\n\tfunction unConfirmedServices(){\n\t\tchangeColor(this,\'COMMON\');\n\t\t//parent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesUnConfirmed\').value;\n\t\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'72vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\tparent.BillReceiptExisOrderSearch.location.href=\'BLChargePatientExisOrderServDetails.jsp?\'+\n\t\t\'&patientId=\'+$(\'#patient_id\').val()+\n\t\t\'&episodeType=\'+$(\'#episode_type\').val()+\n\t\t\'&episodeId=\'+$(\'#episode_id\').val()+\n\t\t\'&visitId=\'+$(\'#visit_id\').val()+\n\t\t\'&locale=\'+$(\'#locale\').val()+\n\t\t\'&processed=UC&groupLineService=D&reSize=UC\';\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.BillReceiptWindow.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\t\n\t}\n\t\n\tfunction fnInterface(){\n\t\tchangeColor(this,\'COMMON\');\t\n\t\t//parent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesUnConfirmed\').value;\n\t\t\n\t\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'68vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\tparent.BillReceiptExisOrderSearch.location.href=\"BLBillGenInterfaceMainFrame.jsp?\"+\n\t\t\'&patient_id=\'+$(\'#patient_id\').val()+\n\t\t\'&episode_type=\'+$(\'#episode_type\').val()+\n\t\t\'&episode_id=\'+$(\'#episode_id\').val()+\n\t\t\'&visit_id=\'+$(\'#visit_id\').val()+\n\t\t\'&patient_name=\'+$(\'#patient_name\').val()+\n\t\t\'&futureYN=N\';\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.BillReceiptWindow.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\t\n\t}\n\t\n\tfunction futureOrders(){\n\t\tchangeColor(this,\'COMMON\');\t\n\t//\tparent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesUnConfirmed\').value;\n\t\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'68vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\tparent.BillReceiptExisOrderSearch.location.href=\"BLBillGenInterfaceMainFrame.jsp?\"+\n\t\t\'&patient_id=\'+$(\'#patient_id\').val()+\n\t\t\'&episode_type=\'+$(\'#episode_type\').val()+\n\t\t\'&episode_id=\'+$(\'#episode_id\').val()+\n\t\t\'&visit_id=\'+$(\'#visit_id\').val()+\n\t\t\'&patient_name=\'+$(\'#patient_name\').val()+\n\t\t\'&futureYN=Y\';\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.BillReceiptWindow.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\t\n\t}\n\t\n\tfunction fnEncBillDtls(){\n\t\tchangeColor(this,\'COMMON\');\t\n\t//\tparent.document.getElementById(\'BL_mainFrame\').rows = parent.document.getElementById(\'allFramesUnConfirmed\').value;\n\t\t\n\t\tparent.document.getElementById(\'pline\').style.height=\'8vh\';\n\t\tparent.document.getElementById(\'BillReceiptTab\').style.height=\'6vh\';\n\t\tparent.document.getElementById(\'BillReceiptInfo\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSearch\').style.height=\'68vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderDetails\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'BillReceiptExisOrderSummary\').style.height=\'0vh\';\n\t\tparent.document.getElementById(\'messageFrame1\').style.height=\'6vh\';\n\t\t\n\t\tparent.BillReceiptExisOrderSearch.location.href=\'BillReceiptEncBillDetails.jsp?\'+$(\'#queryString\').val();\n\t\tparent.BillReceiptExisOrderDetails.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.BillReceiptExisOrderSummary.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.BillReceiptWindow.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t}\n\n </script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!-- Selected stuff should be highlighted in black use:CASECONDSELECTHORZ-->\n<form name=\"ChargePatientEncounterTabsForm\" id=\"ChargePatientEncounterTabsForm\">\n\t<table id=\"tab\" cellspacing=0 cellpadding=\"3\" border=\"0\" width=\"40%\">\n\t\t<tr>\n\t\t\t<td id=\"billCumReceipt\"  width=\"5%\"\tclass=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"billCumReceipt();\" nowrap>\n\t\t\t<a style=\'color:white;cursor:pointer\' href=\"#\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a>\n\t\t\t</td>\n\t\t\t<td id=\"unBilledOutStanding\" width=\"5%\"\tclass=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" style=\"display:\'\'\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"otherOutStanding();\" nowrap>\n\t\t\t<a  style=\'color:white;cursor:pointer\' href=\"#\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a>\n\t\t\t</td>\n\t\t\t<td id=\"unConfirmedServices\" width=\"5%\"\tclass=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\"display:\'\'\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"unConfirmedServices();\" nowrap>\n\t\t\t<a  style=\'color:white;cursor:pointer\' href=\"#\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t\t</td>\n\t\t\t<td id=\"interface\" width=\"5%\"\tclass=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" style=\"display:\'\'\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"fnInterface();\" nowrap>\n\t\t\t<a  style=\'color:white;cursor:pointer\' href=\"#\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t\t</td>\n\t\t\t<td id=\"futureOrder\" width=\"5%\"\tclass=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" style=\"display:\'\'\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"futureOrders();\" nowrap>\n\t\t\t<a  style=\'color:white;cursor:pointer\' href=\"#\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t\t\t</td>\n\t\t\t<td id=\"encBillDetails\" width=\"5%\"\tclass=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\"display:\'\'\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"fnEncBillDtls();\" nowrap>\n\t\t\t<a  style=\'color:white;cursor:pointer\' href=\"#\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a>\n\t\t\t</td>\n\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'queryString\' id=\'queryString\'  value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\'  value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\'  value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' >\n\t<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\'  value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'  value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' >\n\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\'  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' >\n\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\'  value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' >\n\t<input type=\'hidden\' name=\'privForIndirect\'  id=\'privForIndirect\' value=\'\'>\n\t<input type=\'hidden\' name=\'chargeLogicYN\'  id=\'chargeLogicYN\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t<input type=\'hidden\' name=\'ipChkOutBasisInd\'  id=\'ipChkOutBasisInd\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t<input type=\'hidden\' name=\'noOfDecimal\'  id=\'noOfDecimal\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<input type=\'hidden\' name=\'unBilled\'  id=\'unBilled\' value=\'\'>\n\t<input type=\'hidden\' name=\'totOutSt\'  id=\'totOutSt\' value=\'\'>\n\t<input type=\'hidden\' name=\'pkgSeqNo\'  id=\'pkgSeqNo\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t<input type=\'hidden\' name=\'pkgClosedYn\'  id=\'pkgClosedYn\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t<input type=\'hidden\' name=\'depChk\'  id=\'depChk\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type=\'hidden\' name=\'prePayChk\'  id=\'prePayChk\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t<input type=\'hidden\' name=\'blngGrpId\'  id=\'blngGrpId\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t<input type=\'hidden\' name=\'pkgAlrdPop\'  id=\'pkgAlrdPop\' value=\'N\'>\n\t<input type=\'hidden\' name=\'warnAlrdPop\'  id=\'warnAlrdPop\' value=\'N\'>\n\t<input type=\'hidden\' name=\'billCashBlngServSeparately\'  id=\'billCashBlngServSeparately\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t<input type=\'hidden\' name=\'default_disc_bill_ind\'  id=\'default_disc_bill_ind\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\n\t<input type=\'hidden\' name=\'allow_locn_based_bill_yn\'  id=\'allow_locn_based_bill_yn\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t<input type=\'hidden\' name=\'allow_service_selection_yn\'  id=\'allow_service_selection_yn\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t<input type=\'hidden\' name=\'dflt_adj_dep_dur_bill_yn\'  id=\'dflt_adj_dep_dur_bill_yn\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t<input type=\'hidden\' name=\'dflt_adj_prepay_dur_bill_yn\'  id=\'dflt_adj_prepay_dur_bill_yn\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t<input type=\'hidden\' name=\'all_payers_bill_together_yn\'  id=\'all_payers_bill_together_yn\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t<input type=\'hidden\' name=\'adhoc_discount_allowed_yn\'  id=\'adhoc_discount_allowed_yn\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t<input type=\'hidden\' name=\'capt_addl_id_proof_for_bill_yn\'  id=\'capt_addl_id_proof_for_bill_yn\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t<input type=\'hidden\' name=\'addl_id_mand_for_payer_bill_yn\'  id=\'addl_id_mand_for_payer_bill_yn\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t<input type=\'hidden\' name=\'dflt_addl_id_type\' id=\'dflt_addl_id_type\'  value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t<input type=\'hidden\' name=\'drug_penalty_yn\' id=\'drug_penalty_yn\'  value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\n\t<input type=\'hidden\' name=\'adj_pat_prepay_in_enc_pre_yn\'  id=\'adj_pat_prepay_in_enc_pre_yn\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t<input type=\'hidden\' name=\'count\' id=\'count\'  value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\n\t<input type=\'hidden\' name=\'interfaceYn\'  id=\'interfaceYn\' value=\'\'>\n\t<input type=\'hidden\' name=\'futureOrderYn\'  id=\'futureOrderYn\' value=\'\'>\n\t<input type=\'hidden\' name=\'totalCount\'  id=\'totalCount\' value=\'\' >\n\t<input type=\'hidden\' name=\'packageCode\'  id=\'packageCode\' value=\'\' >\n\t\n</form>\n</body>\n</html> \n\n \n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
  
request.setCharacterEncoding("UTF-8");
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String episodeType = replaceNull(request.getParameter("episode_type"));
String episodeId = replaceNull(request.getParameter("episode_id"));
String visitId = replaceNull(request.getParameter("visit_id"));
//V220512
/*
String patientId = replaceNull(request.getParameter("patient_id"));
String encounterId = replaceNull(request.getParameter("encounter_id"));
*/
String patientId	="";
String encounterId	="";

if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
	patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	encounterId	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
}else{
	patientId	= replaceNull(request.getParameter("patient_id"));
	encounterId	= replaceNull(request.getParameter("encounter_id"));
}
//V220512
String locale = (String) (session.getValue("LOCALE"));
String facilityId = (String) (session.getValue("facility_id"));
String blngGrpId = replaceNull(request.getParameter("blng_grp_id"));
String loginUser = (String) session.getValue("login_user");
String pkgClosedYn=(String) session.getAttribute("pkgClosedYN");
String pkgSeqNum=(String) session.getAttribute("pkgSeqNum");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String existing_order_class="";
String new_order_class="";
String queryString = (String) request.getQueryString();
String selectedTab=(String)request.getParameter("selectedTab");
if(selectedTab == null) selectedTab="billCumReceipt";

if(selectedTab.equalsIgnoreCase("billCumReceipt")){
	existing_order_class="CASECONDSELECTHORZ";
	new_order_class="CAFIRSTSELECTHORZ";
}else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}
else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}
else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}

String chargeLogicYN = "";
String ipChkOutBasisInd = "";
String prePayChk = "";
String depChk = "";
String billCashBlngServSeparately = "";
String default_disc_bill_ind="";
String noOfDecimal = "";
String allow_locn_based_bill_yn="";
String allow_service_selection_yn="";
String dflt_adj_dep_dur_bill_yn="";
String dflt_adj_prepay_dur_bill_yn="";
String all_payers_bill_together_yn="";
String adhoc_discount_allowed_yn="";
String drug_penalty_yn ="";
String adj_pat_prepay_in_enc_pre_yn="";
String capt_addl_id_proof_for_bill_yn ="";
String addl_id_mand_for_payer_bill_yn="";
String dflt_addl_id_type ="";
String l_accept_national_id_no_yn ="";
int count=0;


Connection con = null;
PreparedStatement pstmt = null;
ResultSet rst = null;

try{
	con = ConnectionManager.getConnection();
	pstmt = con.prepareStatement("Select charge_logic_yn,ip_check_out_basis_ind,NVL (adjust_full_pr_amt_yn, 'N') adjust_full_pr_amt_yn,NVL (adjust_full_ad_amt_yn, 'N') adjust_full_ad_amt_yn, NVL(bill_cash_blng_serv_separately,'N') bill_cash_blng_serv_separately,NVL(default_disc_bill_ind,'N') default_disc_bill_ind,NVL (allow_locn_based_bill_yn, 'N') allow_locn_based_bill_yn,NVL (allow_service_selection_yn, 'N') allow_service_selection_yn,NVL (dflt_adj_dep_dur_bill_yn, 'N') dflt_adj_dep_dur_bill_yn,NVL (dflt_adj_prepay_dur_bill_yn, 'N') dflt_adj_prepay_dur_bill_yn,NVL (all_payers_bill_together_yn, 'N') all_payers_bill_together_yn,NVL (adhoc_discount_allowed_yn, 'N') adhoc_discount_allowed_yn,NVL (drug_penalty_yn, 'N') drug_penalty_yn,NVL(adj_pat_prepay_in_enc_pre_yn,'N') adj_pat_prepay_in_enc_pre_yn,capt_addl_id_proof_for_bill_yn,addl_id_mand_for_payer_bill_yn,dflt_addl_id_type from bl_parameters where operating_facility_id = ?");
	pstmt.setString(1, facilityId);
	rst = pstmt.executeQuery();
	
	if(rst != null && rst.next()){
		chargeLogicYN = rst.getString("charge_logic_yn");
		ipChkOutBasisInd = rst.getString("ip_check_out_basis_ind");
		depChk = rst.getString("adjust_full_ad_amt_yn");
		prePayChk = rst.getString("adjust_full_pr_amt_yn");
		billCashBlngServSeparately = rst.getString("bill_cash_blng_serv_separately");
		default_disc_bill_ind= rst.getString("default_disc_bill_ind"); 
		allow_locn_based_bill_yn= rst.getString("allow_locn_based_bill_yn");
		allow_service_selection_yn= rst.getString("allow_service_selection_yn");
		dflt_adj_dep_dur_bill_yn= rst.getString("dflt_adj_dep_dur_bill_yn");
		dflt_adj_prepay_dur_bill_yn= rst.getString("dflt_adj_prepay_dur_bill_yn");
		all_payers_bill_together_yn= rst.getString("all_payers_bill_together_yn");
		adhoc_discount_allowed_yn= rst.getString("adhoc_discount_allowed_yn");
		drug_penalty_yn= rst.getString("drug_penalty_yn");
		adj_pat_prepay_in_enc_pre_yn =rst.getString("adj_pat_prepay_in_enc_pre_yn");
		capt_addl_id_proof_for_bill_yn =rst.getString("capt_addl_id_proof_for_bill_yn");
		addl_id_mand_for_payer_bill_yn =rst.getString("addl_id_mand_for_payer_bill_yn");
		dflt_addl_id_type =rst.getString("dflt_addl_id_type");
	}
	
	pstmt = null;
	rst = null;

	pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) no_of_decimal from  sm_acc_entity_param");
	rst = pstmt.executeQuery();
	if(rst != null && rst.next()){
		noOfDecimal = rst.getString("no_of_decimal");
	}
	pstmt = null;
	rst = null;
	pstmt = con.prepareStatement( "SELECT COUNT (*)  FROM bl_users_for_credit_auth WHERE operating_facility_id = '"+facilityId+"' AND credit_auth_user_id = '"+loginUser+"' AND bill_exempt_auth_yn = 'Y' AND NVL (status, 'X') <> 'S'");	
	rst = pstmt.executeQuery();
	if(rst != null && rst.next()){
		count = rst.getInt(1);
	}
	
  }catch(Exception eX){	
	noOfDecimal = "2";
	System.err.println("Exception in getting Charge Logic YN ->"+eX);
}
finally{
	pstmt = null;
	rst = null;
	ConnectionManager.returnConnection(con);
}


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(existing_order_class));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(new_order_class));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(new_order_class));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(new_order_class));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(new_order_class));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(new_order_class));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(queryString ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(episodeType ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(visitId ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(chargeLogicYN ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ipChkOutBasisInd ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(noOfDecimal ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(pkgSeqNum));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pkgClosedYn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(depChk ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(prePayChk ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(blngGrpId ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(billCashBlngServSeparately ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(default_disc_bill_ind ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(allow_locn_based_bill_yn ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(allow_service_selection_yn ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dflt_adj_dep_dur_bill_yn ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dflt_adj_prepay_dur_bill_yn ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(all_payers_bill_together_yn ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(adhoc_discount_allowed_yn ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(capt_addl_id_proof_for_bill_yn ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(addl_id_mand_for_payer_bill_yn ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dflt_addl_id_type ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drug_penalty_yn ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(adj_pat_prepay_in_enc_pre_yn ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(count));
            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GenerateBillCumReceipt.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OtherUnbilledOutstanding.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UnConfirmedServices.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Interface.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FutureOrder.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EncounterBillingDetails.label", java.lang.String .class,"key"));
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
}
