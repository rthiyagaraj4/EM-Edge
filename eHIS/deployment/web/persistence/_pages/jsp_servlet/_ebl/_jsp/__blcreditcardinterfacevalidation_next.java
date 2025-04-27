package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import eXH.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcreditcardinterfacevalidation_next extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCreditCardInterfaceValidation_NEXT.jsp", 1742750368656L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n1-Dec-2014     100           \tKarthikeyan.K       GHL-CRF-0366.1 Karthik Created this File code for Credit Card Integration   \n---------------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\"src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\n\n<script>\n\t/*\n\tfunction window.confirm(str) {\n\t    execScript(\'n = msgbox(\"\' + str + \'\",\"4132\")\', \"vbscript\");\n\t    return (n == 6);\n\t}\n\t*/\n\n\t$(document).ready(function () {\n\t\talert(\"Inside Validate \");\n\t\tvalidate();\n\t});\n\t\n\n \tfunction validate()\n\t{\n\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp\';\t\n\t\t\n\t\tvar formName= parent.frames[0].document.forms[0];\n\t\tvar dataElements=\"\";\n\t\tdataElements+=\"P_patient_id=\"+formName.patientid.value;\n\t\tdataElements+=\"&P_episode_ID=\"+formName.episodeid.value;\n\t\tdataElements+=\"&P_settlement_type=\"+(formName.slmttype.value).substring(0,2);\n\t\tdataElements+=\"&P_trn_type=\"+formName.trn_type.value;\n\t\tdataElements+=\"&p_doc_date=\"+formName.p_doc_date.value;\n\t\tdataElements+=\"&P_Bill_Doc_Type=\"+formName.billdoctypecode.value;\n\t\tdataElements+=\"&P_Bill_Doc_Num=\"+formName.billdocnum.value;\n\t\t//dataElements+=\"&P_Total_Bill_Amount=\"+formName.total_amt_payable.value;// Commented by Sethu for NMC-JD-SCF-0044 ON 13/05/2020\n\t\tdataElements+=\"&P_Total_Bill_Amount=\"+formName.billslmtamt.value; // Added by Sethu for NMC-JD-SCF-0044 ON 13/05/2020\n\t\tdataElements+=\"&P_doc_amt=\"+formName.total_amt_payable.value;\n\t\tdataElements+=\"&P_Preapaid_Card_Number=\"+formName.prepaid_card_number.value;\n\t\tdataElements+=\"&P_Reciept_Date=\"+formName.p_doc_date.value;\n\t\tdataElements+=\"&P_USER_ID=\"+formName.loggeduser.value;\n\t\tdataElements+=\"&P_RESP_ID=\"+formName.responsibility_id.value;\n\t\tdataElements+=\"&P_FACILITY_ID=\"+formName.facilityid.value;\n\t\tdataElements+=\"&P_MODULE_ID=\"+formName.moduleid.value;\n\t\tdataElements+=\"&P_FUNCTION_ID=\"+formName.function_id.value;\n\t\tdataElements+=\"&P_LANGUAGE_ID=\"+formName.locale.value;\n\t\tdataElements+=\"&P_WS_NO=\"+formName.strclientip.value;\n\t\tdataElements+=\"&P_Trx_No=\"+formName.trn_number.value;\n\t\tdataElements+=\"&P_Ext_Input_Key=\"+formName.ext_input_key.value;\n\t\tdataElements+=\"&P_Ext_Application_ID=\"+formName.ext_application_id.value;\n\t\tdataElements+=\"&P_Ext_Function=\"+formName.ext_function.value;\n\t\tdataElements+=\"&P_PATIENT_NAME=\"+formName.slmtpayername.value;\n\t\tdataElements+=\"&P_Reciept_number=\"+formName.receipt_number.value;// changed\n\n\t\t//Added by Sethu for KDAH-CRF-0504.3 on 14/08/2019\n\n\t\tvar creditCardForm=\tparent.frames[1].document.forms[0];\n\n\t\tdataElements+=\"&P_Card_Status_YN=\"+creditCardForm.credit_card_status_yn.value;// changed\n\t\tdataElements+=\"&P_Card_Batch_ID=\"+creditCardForm.credit_card_batch_id.value;// changed\n\t\tdataElements+=\"&P_Card_Roc_No=\"+creditCardForm.credit_card_roc_no.value;// changed\n\t\tdataElements+=\"&P_Card_Trn_No=\"+creditCardForm.credit_card_trn_no.value;// changed\n\t\tdataElements+=\"&P_Trn_Status=\"+creditCardForm.credit_trn_status.value;// changed\n\t\t\n\t\t//Code ends for KDAH-CRF-0504.3 on 14/08/2019\n\n\t\tvar ccAutoPluginFlag = this.document.forms[0].ccAutoEnabled.value;\n\t\tvar outTimeVal = 100;\n\n\t\tif(ccAutoPluginFlag == \"true\")\n\t\t{\n\t\t\toutTimeVal = 12000;\n\t\t\tcreditcardInterface2();\n\t\t}\n\t\telse\n\t\t{\n\t\t   outTimeVal = 100;\n\t\t} \n\t\t\n\t\t//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic\t\n\t\tvar ccAppletFlag = this.document.forms[0].ccAppletEnabled.value;\n\t\tvar applicationId = this.document.forms[0].applicationID.value;\n\t\tdataElements+=\"&P_CCAppletEnabled=\"+ccAppletFlag;// changed\n\n\t\t//Added by Sethu for KDAH-CRF-0535 on 07/01/2020 Request Type Variable\t\n\t\tdataElements+=\"&P_Request_Type=\"+creditCardForm.cc_request_type.value;// changed\n\t\tdataElements+=\"&P_Card_Urn_No=\"+creditCardForm.credit_card_urn_no.value;// changed\n\n\t\tsetTimeout(function() \n\t\t{ \n\t\t\n\t\t\t//alert(\"**** ALERT FOR TESTING PURPOSE **** \\n Input Parameters \"+dataElements);\n\n\t\t\tvar retVal = \"\";\n\t\t\tvar arr = \"\";\n\t\t\tvar ccResponse = \"\";\n\n\t\t\tvar errMess = \"<H5 style=\'color:blue\'>Processing please wait...</H5>\" +\"<br>\" ;\n\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\n\t\t\tretVal = dispExtApp(dataElements);\n\n\t\t\tif (ccAppletFlag > 0)\n\t\t\t{\n\t\t\t\tccResponse = creditCardApplet(retVal);\n\n\t\t\t\tif (applicationId == \"SPECTRA\")\n\t\t\t\t{\n\t\t\t\t\tretVal = ccResponse;\n\t\t\t\t}\n\n\t\t\t\tif (ccResponse!=\'\' && ccResponse!=null && applicationId != \"SPECTRA\")\n\t\t\t\t{\n\t\t\t\t\tretVal = \"\";\n\t\t\t\t\tdataElements+=\"&RESPONSE_TEXT=\"+ccResponse+\"&requestGUIType=AJAX\";\n\t\t\t\t\tretVal = CreditCardResponse(dataElements);\n\t\t\t\t}\n\t\t\t}\n\t\t\n\t\t\t//var retVal = \'S$|#$|#Amount deducted$|#Test Payer$|#992836$|#7777801$|#XXXXXX$|#VISA$|#104793$|#15/12/2014$|#1234001$|#$|#$|#$|#HDFC\';\n\t\t\t//var retVal =\'S$|#Card has sufficient balance, Do you want  to proceed for Deduction of the amount?$|#$|#Mr. Sudhish Chandra Gupta$|#365$|#365$|#AA$|#WC$|#100033$|#01/01/2099$|#365$|#06/01/2015$|#113511$|#$|#WC\';\n\t\t\t//alert(\"**** ALERT FOR TESTING PURPOSE **** \\n Response \"+ retVal );\n\n\t\t\t//S$|#Transaction Completed Succesfully...$|#$|#$|#107$|#14005$|#AA$|#WALLET$|#******2889$|#01/01/2099$|#9065$|#18/05/2019$|#101731$|#$|#105\n\t\t\t//S$|#Transaction Completed Succesfully...$|#$|#MANU PRAKASH DEEP        / $|#44 $|#24242421 $|#AA$|#$|#461786******2913 $|#$|#0 $|#18/08/2015$|#170509$|#$|#01 \n\t\t\t//setTimeout(function() { \n\n\t\t\t//retVal = \"E$|#TRANSACTION INITIATED - CHECK GET STATUS$|#$|#$|#101$|#14005$|#AE$|#$|#******2889$|#01/01/2099$|#9065$|#18/05/2019$|#094425$|#$|#105$|#13278492\";\n\n\t\t\t//retVal = \"S$|#Transaction Completed Succesfully...$|#$|#$|#107$|#14005$|#003439$|#WALLET$|#******2889$|#01/01/2099$|#9065$|#18/05/2019$|#101731$|#$|#105$|#13278490!!\";\n\n\t\t\t/*\n\t\t\t\tFields\n\t\t\t\t1 - Process Status(response status from Walletree)\n\t\t\t\t2 - Process remarks(Error if any from Walletree)\n\t\t\t\t3 - Error Message while processing\n\t\t\t\t4 - Payer Name\t\t\t\t\n\t\t\t\t5 - Sale Draft No\n\t\t\t\t6 - Retrieval Reference Number\n\t\t\t\t7 - Approval Code\n\t\t\t\t8 - Card Issuer Name/Card Type\n\t\t\t\t9 - CC No\n\t\t\t\t10 - Expiry Date (YYYYMMDD)\n\t\t\t\t11- Batch Number\t\n\t\t\t\t12- Transaction Date(YYYYMMDD)\n\t\t\t\t13- Transaction Time(HH24MISS)\n\t\t\t\t14- NULL field\n\t\t\t\t15- Card Issued bank\t\n\t\t\t\t16- Tracking ID\n\t\t\t\t17- Terminal ID\t\n\t\t\t*/\n\t\t\t/* MMS Credit Card */\n\t\t\t//retVal = \"S$|#Approved $|#$|#$|#400308022011   $|#632613221071$|#001322$|#SPAN$|#428331******6605$|#$|#00238$|#21-11-2016 13:22:43$|#$|#$|#$|#$|#$|#5675678\";\n\t\t\t/* AMS Pine Labs Plutus Credit Card */\n\t\t\t//retVal = \"S$|#Transaction Completed Succesfully...$|#$|#$|#15968$|#000000016763$|#002129$|#VISA$|#436389******2935$|#01/01/2099$|#714$|#09/11/2020$|#16:39:31$|#$|#01$|#21000108$|#41350447$|#\";\n\t\t\t//retVal = \"S$|#Transaction Completed Succesfully...$|#$|#$|#18291$|#000000019172$|#007976$|#VISA$|#436389******2935$|#01/01/2099$|#855$|#09/11/2020$|#161402$|#$|#01$|#21112614$|#41350440$|#\";\n\t\t\t//retVal = \"E$|#Read timed out$|#$|#$|#$|#$|#AE$|#$|#$|#01/01/2099$|#$|#$|#$|#$|#OTH\";\n\t\t\t/* GHL Pine Labs Plutus Credit Card */\n\t\t\t//retVal = \"S$|#Transaction Completed Succesfully...$|#$|#RAJINDER SINGH           /$|#000000000020$|#12856978$|#AA$|#MASTER$|#531849******1497$|#01/01/2099$|#4$|#14/06/2019$|#101412$|#$|#01\";\n\t\t\t/* AMRI Error */\n\t\t\t//retVal = \"E$|#Communication With EDC Failed - Check EDC Connectiom$|#$|#$|#$|#$|#AE$|#$|#$|#01/01/2099$|#$|#$|#$|#$|#OTH\";\n\t\t\t//retVal = \"S$|#Transaction Completed Succesfully...$|#$|#TMW FB MASTERCARD/$|#156579330974$|#SB8I9910$|#005644$|#MASTERCARD PIN@POS$|#531829xxxxxx4920$|#01/01/2099$|#000002$|#14/08/2019$|#200509$|#$|#OTH\";\n\t\t\t\n\t\t\tif(retVal!=\'\' && retVal!=null)\n\t\t\t{\t\t\t\n\t\t\t\tarr = retVal.split(\"$|#\");\n\n\t\t\t\tif (applicationId != \"SPECTRA\")\n\t\t\t\t{\n\n\t\t\t\t\t//Added by Sethu for KDAH-CRF-0504.4 on 14/08/2019\n\n\t\t\t\t\tvar trn_no = arr[15];\n\t\t\t\t\tvar batch_id = arr[10];\n\t\t\t\t\tvar roc_no = arr[4];\n\t\t\t\t\tvar trn_status = arr[1];\n\t\t\t\t\tvar urn_no = \"\";\n\t\t\t\t\t\n\t\t\t\t\tcreditCardForm=\tparent.frames[1].document.forms[0];\n\t\t\t\t\t\n\t\t\t\t\t//Code Modified for KDAH-CRF-0535 on 07/01/2020\n\t\t\t\t\tvar credit_card_status_yn = creditCardForm.credit_card_status_yn.value;\n\t\t\t\t\tif (applicationId == \"WLCR\")\n\t\t\t\t\t{\n\t\t\t\t\t\turn_no = arr[17];\t\t\t\t\t\t\n\t\t\t\t\t}\n\n\t\t\t\t\tvar status_btn = parent.frames[0].document.getElementById(\'validate_cc_status\');\n\n\t\t\t\t\tif (status_btn)\n\t\t\t\t\t\tstatus_btn.disabled = true;\n\n\t\t\t\t\tparent.frames[0].document.getElementById(\'show_button_status\').style.display=\'inline\';\n\n\t\t\t\t\tcreditCardForm.credit_card_batch_id.value=\"\";\n\t\t\t\t\tcreditCardForm.credit_card_roc_no.value=\"\";\n\t\t\t\t\tcreditCardForm.credit_trn_status.value=\"N\";\n\n\t\t\t\t\t//Code Modified for KDAH-CRF-0535 on 07/01/2020\n\n\t\t\t\t\tif (credit_card_status_yn == \'Y\') \n\t\t\t\t\t{\n\t\t\t\t\t\tif (applicationId == \"PHONEPE\")\n\t\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\t\tif (trn_status == \"TRANSACTION INITIATED - CHECK GET STATUS\") \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tcreditCardForm.credit_card_batch_id.value=batch_id;\n\t\t\t\t\t\t\t\tcreditCardForm.credit_card_roc_no.value=roc_no;\n\t\t\t\t\t\t\t\tcreditCardForm.credit_trn_status.value=\"Y\";\n\t\t\t\t\t\t\t\tif (status_btn)\n\t\t\t\t\t\t\t\t\tstatus_btn.disabled = false;\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if (applicationId == \"WLCR\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif (urn_no != null && urn_no != \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tcreditCardForm.credit_card_urn_no.value = urn_no;\n\t\t\t\t\t\t\t\tcreditCardForm.credit_trn_status.value=\"Y\";\n\t\t\t\t\t\t\t\tif (status_btn)\n\t\t\t\t\t\t\t\t\tstatus_btn.disabled = false;\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tcreditCardForm.credit_trn_status.value=\"Y\";\n\t\t\t\t\t\t\tif (status_btn)\n\t\t\t\t\t\t\t\tstatus_btn.disabled = false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tcreditCardForm.credit_card_trn_no.value=trn_no;\n\n\t\t\t\t\t//Code ends for KDAH-CRF-0504.4 on 14/08/2019\n\t\t\t\t}\n\n\t\t\t\tvar errMess = \"\" ;\n\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\n\t\t\t\tif (retVal.charAt(0)==\'S\' && arr[8] != null && arr[8] != \"\") \n\t\t\t\t{\t\n\t\t\t\t\t\n\t\t\t\t\tvar card_no=arr[8]; \n\t\t\t\t\t//expiry_date Commented by Sethu for GHL-SCF-1545 on 11/01/2021\n\t\t\t\t\t//var expiry_date=arr[11];\n\t\t\t\t\t//card_Transaction_date Added by Sethu for GHL-SCF-1545 on 11/01/2021\n\t\t\t\t\tvar cc_trx_date=arr[11];\n\t\t\t\t\tvar card_Transaction_date=arr[11]+\" \"+arr[12];\n\t\t\t\t\tvar card_issued_bank=arr[14];\n\t\t\t\t\tvar card_type=arr[7];\n\t\t\t\t\tvar online_approval_batch_no=arr[10];\n\t\t\t\t\tvar approval_code=arr[6];\n\t\t\t\t\tvar sale_draft_no=arr[4];\n\t\t\t\t\tvar tid_no=arr[16]; //var tid_no=arr[5];\n\t\t\t\t\tvar payer_name=arr[3];\t\n\n\t\t\t\t\tvar rr_no = arr[5];\n\n\t\t\t\t\tcreditCardForm =\tparent.frames[1].document.forms[0];\n\n\t\t\t\t\tcreditCardForm.credit_card_batch_id.value=\"\";\n\t\t\t\t\tcreditCardForm.credit_card_roc_no.value=\"\";\n\n\t\t\t\t\tcreditCardForm.instref.value=card_no;\n\t\t\t\t\t//expiry_date Commented by Sethu for GHL-SCF-1545 on 11/01/2021\n\t\t\t\t\t//creditCardForm.instdate.value=expiry_date;\n\t\t\t\t\t//card_Transaction_date Added by Sethu for GHL-SCF-1545 on 11/01/2021\n\t\t\t\t\tcreditCardForm.instdate.value=cc_trx_date;\n\t\t\t\t\tcreditCardForm.instremark.value=card_type;\n\t\t\t\t\tcreditCardForm.instremarkcode.value=card_type;\n\t\t\t\t\tcreditCardForm.batchno.value=online_approval_batch_no;\n\t\t\t\t\tcreditCardForm.instbranch.value=card_issued_bank;\t\t\n\t\t\t\t\tcreditCardForm.payername.value=payer_name;\t\t\t\t\n\t\t\t\t\tcreditCardForm.recrefidno.value=rr_no;\t//tid_no\t\t\n\t\t\t\t\tcreditCardForm.apprrefno.value=approval_code;\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="\t\t\tcreditCardForm.saledraftno.value=sale_draft_no;\t\n\t\t\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021\n\t\t\t\t\tcreditCardForm.cc_term_id_num.value=tid_no;\t\t\t\t\n\t\t\t\t\tcreditCardForm.cc_trx_date_time.value=card_Transaction_date;\n\n\t\t\t\t\tparent.frames[3].document.forms[0].cancel_button.disabled=true;\t\n\t\t\t\t\t\n\t\t\t\t\t$.ajax({\n\t\t\t\t\t   url:\"../../eBL/jsp/BLCreditCardDetailsStorage.jsp\",\n\t\t\t\t\t   type:\'post\',\n\t\t\t\t\t   data: {\n\t\t\t\t\t\t\tcardOperation: \"storedata\",\n\t\t\t\t\t\t\tP_patient_id:  formName.patientid.value ,\n\t\t\t\t\t\t\tP_episode_ID:  formName.episodeid.value ,\n\t\t\t\t\t\t\tP_settlement_type:  (formName.slmttype.value).substring(0,2) ,\n\t\t\t\t\t\t\tP_trn_type:  formName.trn_type.value ,\n\t\t\t\t\t\t\tp_doc_date:  formName.p_doc_date.value ,\n\t\t\t\t\t\t\tP_Bill_Doc_Type:  formName.billdoctypecode.value ,\n\t\t\t\t\t\t\tP_Bill_Doc_Num:  formName.billdocnum.value ,\n\t\t\t\t\t\t\tP_Total_Bill_Amount:  formName.total_amt_payable.value ,\n\t\t\t\t\t\t\tP_doc_amt:  formName.total_amt_payable.value ,\n\t\t\t\t\t\t\tP_Preapaid_Card_Number:  formName.prepaid_card_number.value ,\n\t\t\t\t\t\t\tP_Reciept_Date:  formName.p_doc_date.value ,\n\t\t\t\t\t\t\tP_USER_ID:  formName.loggeduser.value ,\n\t\t\t\t\t\t\tP_RESP_ID:  formName.responsibility_id.value ,\n\t\t\t\t\t\t\tP_FACILITY_ID:  formName.facilityid.value ,\n\t\t\t\t\t\t\tP_MODULE_ID:  formName.moduleid.value ,\n\t\t\t\t\t\t\tP_FUNCTION_ID:  formName.function_id.value ,\n\t\t\t\t\t\t\tP_LANGUAGE_ID:  formName.locale.value ,\n\t\t\t\t\t\t\tP_WS_NO:  formName.strclientip.value ,\n\t\t\t\t\t\t\tP_Trx_No:  formName.trn_number.value ,\n\t\t\t\t\t\t\tP_Ext_Input_Key:  formName.ext_input_key.value ,\n\t\t\t\t\t\t\tP_Ext_Application_ID:  formName.ext_application_id.value ,\n\t\t\t\t\t\t\tP_Ext_Function:  formName.ext_function.value ,\n\t\t\t\t\t\t\tP_PATIENT_NAME:  formName.slmtpayername.value , \n\t\t\t\t\t\t\t//expiry_date Commented by Sethu for GHL-SCF-1545 on 11/01/2021\n\t\t\t\t\t\t\t//cardData : card_no +\'|\'+ expiry_date+\'|\'+card_issued_bank+\'|\'+ card_type+\'|\' +online_approval_batch_no+\'|\' +approval_code+\'|\' +sale_draft_no+\'|\' +rr_no+\'|\'+payer_name\n\t\t\t\t\t\t\t//card_Transaction_date Added by Sethu for GHL-SCF-1545 on 11/01/2021\n\t\t\t\t\t\t\tcardData : card_no +\'|\'+ card_Transaction_date+\'|\'+card_issued_bank+\'|\'+ card_type+\'|\' +online_approval_batch_no+\'|\' +approval_code+\'|\' +sale_draft_no+\'|\' +rr_no+\'|\'+payer_name+\'|\'+tid_no\n\t\t\t\t\t\t},\n\t\t\t\t\t\tsuccess: function(data) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar tmpSlmtType = formName.slmttype.value;\n\t\t\t\t\t\t\tvar tmpSlmtTypeSub = tmpSlmtType.substring(0,2);\n\t\t\t\t\t\t\tif(tmpSlmtTypeSub == \'WC\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif (confirm(arr[1]) == true) \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\telse \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tcreditCardForm.instref.value=\'\';\n\t\t\t\t\t\t\t\t\tcreditCardForm.instdate.value=\'\';\n\t\t\t\t\t\t\t\t\tcreditCardForm.instremark.value=\'\';\n\t\t\t\t\t\t\t\t\tcreditCardForm.instremarkcode.value=\'\';\n\t\t\t\t\t\t\t\t\tcreditCardForm.batchno.value=\'\';\n\t\t\t\t\t\t\t\t\tcreditCardForm.instbranch.value=\'\';\t\t\n\t\t\t\t\t\t\t\t\tcreditCardForm.payername.value=\'\';\t\t\t\t\n\t\t\t\t\t\t\t\t\tcreditCardForm.recrefidno.value=\'\';\t\t\t\t\n\t\t\t\t\t\t\t\t\tcreditCardForm.apprrefno.value=\'\';\t\t\t\t\n\t\t\t\t\t\t\t\t\tcreditCardForm.saledraftno.value=\'\';\n\t\t\t\t\t\t\t\t\t//card_Transaction_date Added by Sethu for GHL-SCF-1545 on 11/01/2021\n\t\t\t\t\t\t\t\t\tcreditCardForm.cc_term_id_num.value=\'\';\t\t\t\t\n\t\t\t\t\t\t\t\t\tcreditCardForm.cc_trx_date_time.value=\'\';\n\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].cancel_button.disabled=false;\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t$.ajax({\n\t\t\t\t\t\t\t\t\t\turl:\"../../eBL/jsp/BLCreditCardDetailsStorage.jsp\",\n\t\t\t\t\t\t\t\t\t\ttype:\'post\',\n\t\t\t\t\t\t\t\t\t\tdata: { cardOperation: \"removedata\"}\n\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t });\t\t\t\n\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\t\n\t\t\t\t\tvar errMess = \"<H5 style=\'color:red\'>\"+arr[1]+\"</H5>\" +\"<br>\" ;\n\t\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\t\treturn false;\t\t\t\n\t\t\t\t}\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar errMess = \"<H5 style=\'color:red\'>Credit Card Transaction Declined.</H5>\" +\"<br>\" ;\n\t\t\t\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errMess;\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}, outTimeVal );\n\n\t} \n\n\t\n</script>\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"bl_creditcard_form\" id=\"bl_creditcard_form\" >\n<input type=\"hidden\" name=\"ccAutoEnabled\" id=\"ccAutoEnabled\" value=\'";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\'>\n<!--Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic\t-->\n<input type=\"hidden\" name=\"ccAppletEnabled\" id=\"ccAppletEnabled\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=\"hidden\" name=\"applicationID\" id=\"applicationID\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);


	request.setCharacterEncoding("UTF-8");   

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
        
	//Added by prithivi on 28/02/2017 for MMS-DM-SCF-INT-0004/63556 CC-auto
	Connection conn = null;	
	Boolean ccAutoPluginFlag=false;
	String ccAutoEnabled="false";
	boolean isDebugYN = false; 

	try
	{
		isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN,'N') DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		conn = ConnectionManager.getConnection();	
		ccAutoPluginFlag = eCommon.Common.CommonBean.isSiteSpecific(conn, "XH","CC_AUTO_PLUGIN_ENABLED");
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Auto Plugin Flag..."+ccAutoPluginFlag);

		if(ccAutoPluginFlag)
		{
			ccAutoEnabled = "true";
		}
		else
		{
            ccAutoEnabled = "false";
		}
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Auto Enabled..."+ccAutoEnabled);

	}catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("***Inside Credit Card Interface Validation - Exception while checking Auto Plugin Flag... "+e);
	}
	finally{
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Conection closed");
	}
	
	//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	
	
	System.out.println("*****************************************");

	String sqlStatement = "";
	int ccAppletCount = 0;
	String slmttype = request.getParameter("slmttype").substring(0,2);
	
	System.out.println("***Inside Credit Card Interface Validation - Settlement Type... "+isDebugYN);

	if(isDebugYN)
		System.out.println("***Inside Credit Card Interface Validation - Settlement Type... "+slmttype );

	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	try {

		conn = ConnectionManager.getConnection();

		sqlStatement = "select count(*) applet_count from SM_FUNCTION_CONTROL a, sm_site_param b "
							+ "	where a.MODULE_ID = ? and a.FUNCTIONALITY_ID like '%CREDITCARD%' and a.SITE_ID = b.customer_id "
							+ "	and a.KEY_1 = ? AND VALUE_1 = 'Y' ";
		pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1,"XH");
		pstmt.setString(2,slmttype);

		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				ccAppletCount = rs.getInt("applet_count");
			}
		}
		
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - SQL... "+sqlStatement+" ***Applet Count  : "+ccAppletCount);
	}
	catch (Exception e){
		System.out.println("***Inside Credit Card Interface Validation - Exception in fetching CC Applet "+e );
	}
	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();	
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Conection closed");		
	}


	sqlStatement = "";

	pstmt		= null;
	rs			= null;

	String loggedInUser = XHDBAdapter.isNullReplace(request.getParameter("loggeduser"),"*");
	String respID = XHDBAdapter.isNullReplace(request.getParameter("responsibility_id"),"*");
	String funcID = XHDBAdapter.isNullReplace(request.getParameter("function_id"),"*");

	String strApplicationId = "";
	
	if(isDebugYN)
		System.out.println(" ***Inside Credit Card Interface Validation - Settlement Type... "+slmttype+" ***Logged in User "+loggedInUser+" ***Responsibility ID... "+respID+" ***Function ID... "+funcID );


	try {

		conn = ConnectionManager.getConnection();

		sqlStatement = "SELECT external_application,key_2 FROM xh_filter_dms_vw WHERE "
						+ " login_user = (decode(login_user, '*', login_user, ?)) "
						+ " AND responsibility = (decode(responsibility, '*', responsibility, ?)) "
						+ " AND login_function = (decode(login_function, '*', login_function, ?)) "
						+ " AND key_1 = (decode(key_1, '*', key_1, ?)) ";

		pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, loggedInUser);
		pstmt.setString(2, respID);
		pstmt.setString(3, funcID);
		pstmt.setString(4, slmttype);

		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				strApplicationId = rs.getString("external_application");
			}
		}

		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Validation - Credit Card Application query... "+sqlStatement+" ***Application ID... "+strApplicationId);
	}
	catch (Exception e){
		System.out.println("***Inside Credit Card Interface Validation - Exception in Fetching CC Application ID... "+e);
	}
	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();	
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Credit Card Interface Sethu Validation - Conection closed");		
	}
		
	//Added by Sethu for GHL-CRF-0373 on 04/06/2019 Credit Card Applet Logic	

	
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);



            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            out.print( String.valueOf(ccAutoEnabled));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ccAppletCount));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strApplicationId));
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
