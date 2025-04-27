package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHQueryRender;
import eXH.XHDBAdapter;
import eXH.XHUtil;
import java.util.*;
import com.ehis.util.*;

public final class __medimembershipclaimsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/MediMembershipClaimsResult.jsp", 1743586983006L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\n<HEAD>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\' type=\'text/css\'></link>\t\t      \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t    \n<style>\n.left_child{\n\toverflow-y:auto;\n }\n</style>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/jquery-3.6.3.js\' language=\'javascript\'></script>\n\n<script language=\"javascript\">\nvar j = 0;\nfunction funSubmit()\n{\n\tparent.resultFrame.PAYER_CHECK_CLAIMS_FORM.action = \'../../eXH/jsp/MediMembershipClaimsResult.jsp\';\n\tparent.resultFrame.PAYER_CHECK_CLAIMS_FORM.target=\"resultFrame\";\n\tparent.resultFrame.PAYER_CHECK_CLAIMS_FORM.submit();\n}\n\nfunction funAction(typ)\n{  \n\tparent.resultFrame.PAYER_CHECK_CLAIMS_FORM.action_type.value = typ;\n\tfunSubmit();\n}\n\n//function callForOrderBy\nfunction callForOrderBy(obj,order)\n{\t\n\tif(order == \'A\') obj = obj + \' asc\';\n\tif(order == \'D\') obj = obj + \' desc\';\n\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\n\tthis.document.forms[0].action_type.value = \"\";\n\tthis.document.forms[0].action = \"../../eXH/jsp/MediMembershipClaimsResult.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n}\nfunction EclaimsTrx(obj)\n{\t\n\tvar checkType = \"\";\n\tvar patientData=\"\";\n\tvar checkedValue = null; \n\tvar checkBoxes = document.getElementsByName(\'checkbox\');\n\tvar selectedIndex = 0;\n\tvar count = 0;\n\n\tvar authnumname = \"\";\n\tvar destcodename = \"\";\n\t\n\tvar authnum = \"\";\n\tvar destcode = \"\";\n\n\tvar val_func = \"\";\n\n\tvar responseMessage = \"\", validate = \"\";\n\t\n\tfor(var i = 0; i < checkBoxes.length; i++){\n\t\tif(checkBoxes[i].checked){\n\t\t\tcheckedValue = checkBoxes[i].value;\n\t\t\tselectedIndex = i;\n\t\t\tj=i;\n\t\t\tcount++;\n\t\t}\n\t} \n\n\tif(count == 0 || checkedValue == null)\n\t{\n         alert(\"APP-XH0070 Please select at least one Bill Number.\");\n\t\t return;\n\t}\n\tif(count > 1)\n\t{\n         alert(\"APP-XH0070 More than one Bill numbers cannot be processed, please select only one bill number.\");\n\t\t return;\n\t}\n\n\n\tvar authnumobj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.authnum\"+selectedIndex);\n\tvar destcodeobj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.destcode\"+selectedIndex);\n\tvar val_func_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.val_func\");\n\n\tauthnum = authnumobj.value;\n\tdestcode = destcodeobj.value;\n\tval_func = val_func_obj.value;\n\n\tvar event_type_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.event_type\"+selectedIndex);\n\tvar event_type = event_type_obj.value;\n\n\tvar settlement_ind_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.settlement_ind\"+selectedIndex);\n\tvar settlement_ind = settlement_ind_obj.value;\n\n\tvar billing_grp_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.billing_grp\"+selectedIndex);\n\tvar billing_grp = billing_grp_obj.value;\n\n\tvar cust_code_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.cust_code\"+selectedIndex);\n\tvar cust_code = cust_code_obj.value;\n\n\tvar visit_date_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.visit_date\"+selectedIndex);\n\tvar visit_date = visit_date_obj.value;\n\n\tvar destAlertMessage = \"\";\n\tvar eventName = \"\";\n\n\tif (obj == \"CLA\")\n\t\t eventName = \"Claims\";\n\n\tif (obj == \"CLE\")\n\t\t eventName = \"Claims EOC\";\n\n\tif (obj == \"EOC\")\n\t\t eventName = \"End of Case\";\n\n\tif (obj == \"REV\")\n\t\t eventName = \"Reversal\";\n\n\tif (destcode == null || destcode == \"\" || destcode == \" \")\n\t{ \n\t\tif (settlement_ind == \"C\")\n\t\t{\n\t\t\tdestAlertMessage = \"APP-XH0074 Billing Group \"+billing_grp+\" is not mapped to Destination Code pertaining to process \"+eventName+\" dated \"+visit_date;\n\t\t}\n\t\tif ((settlement_ind == \"X\") || (settlement_ind == \"R\"))\n\t\t{\n\t\t\tdestAlertMessage = \"APP-XH0074 Customer Code \"+cust_code+\" is not mapped to Destination Code pertaining to process \"+eventName+\" dated \"+visit_date;\n\t\t}\n\t\talert(destAlertMessage);\n\t\treturn;\n\t}\n\n\t/*\n\n\tif(destcode == null || destcode == \"\" || destcode == \" \")\n\t{ \n\t\talert(\"APP-XH0070 Destination Code for the Customer has not been configured, Please configure and try again\");\n\t\treturn;\n\t} \n\t*/\n\n\tif(authnum == null || authnum == \"\" || authnum == \" \")\n\t{ \n\t\tif(val_func == \"E\"){\n\t\t\talert(\"APP-XH0070 Eligibility Check verification is not obtained for the Encounter. Please complete Eligibility verification before claim submission.\");\n\t\t\treturn;\n\t\t}\n\t\tif(val_func == \"A\"){\n            var retVal = confirm(\"APP-XH0070 Eligibility Check verification is not obtained for the Encounter. Press \'Ok\' to proceed generating Claim.?\");\n\t\t\tif(retVal == false){\n\t\t\t  return;\n\t\t    }\n\t\t}\n\t} \n\t\n\tcheckedValue = checkedValue.replace(\"#REQUEST#\",obj);\n\t\n\n\t//document.forms[0].dataElements.value = checkedValue;\n\n\tvalidate = ValidateTransaction(obj,selectedIndex);\n\t//validate = ValidateTransaction(checkedValue);\n\t//alert(validate);\n\tvar responseData = \"\";\n\tresponseData = validate.split(\"$!^\");\n\n\tif (responseData.length > 0)\n\t{\n\t\tif (responseData[0] == \"False\")\n\t\t{\n\t\t\talert(responseData[1]);\n\t\t\treturn;\n\t\t}\n\t}\n\n    checkedValue = checkedValue.replace(\"#EventType#\",responseData[1]);\n\n\tresponseMessage = EClaimsTransaction(checkedValue);\t\n\n\tParseCheckResponse(responseMessage,obj);\n}\nasync function ViewTransDetails(obj){\n\n\t\tvar Patient_id = obj.getAttribute(\'patient_id\');\n\t    var Episode_id = obj.getAttribute(\'episode_id\');\n\t\tvar Visit_id = obj.getAttribute(\'visit_id\');\n\t\tvar doc_num = obj.getAttribute(\'doc_num\');\n\t\tvar trans_type = \"ECLREQ\";\n\t\tvar bill_doc_code = obj.getAttribute(\'bill_doc_code\');\n\t\tdialogHeight = \"35vh\";    // have to remove \n\t\tdialogWidth  = \"55vw\";\n\t\tdialogTop    = \"50\";\t\n\t\t\n\t\tvar title=\"Previous Transaction Details \";\n\t\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:yes\" ;\n\n\t\t// we need to send required values which is need to be compared from existing and responseMsg\n\t\tif(Patient_id != null && Patient_id != \"\" && Patient_id != \" \")\n\t\t{\n\t\t\tvar arguments = new Array();\n\t\t\tvar url = \"../../eXH/jsp/MediClaimsTransDetailsPopup.jsp?Patient_id=\"+Patient_id+\"&Episode_id=\"+Episode_id+\"&Visit_id=\"+Visit_id+\"&doc_num=\"+doc_num+\"&bill_doc_code=\"+bill_doc_code+\"&trans_type=\"+trans_type;\n\t\t\tvar retVal = await window.showModalDialog(url,arguments,features);\n\t\t}\n\t\telse\n\t\t{\n\t\t\talert(\"APP-XH0070 Response is not available\");\n\t\t}\n}\n\nfunction ValidateTransaction(obj,selectedIndex)\n{\n\n\tvar event_type_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.event_type\"+selectedIndex);\n\tvar event_type = event_type_obj.value;\n\n\tvar approval_status_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.approval_status\"+selectedIndex);\n\tvar approval_status = approval_status_obj.value;\n    \n\tvar trans_ref_no_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.transrefno\"+selectedIndex);\n\tvar trans_ref_no = trans_ref_no_obj.value;\n\n\t//var rev_event_type_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.rev_event_type\"+selectedIndex);\n\t//var rev_event_type = rev_event_type_obj.value;\n\n\tif ((obj == \"CLA\" ) || (obj == \"CLE\"))\n\t{\n\t\tif(!(event_type.length > 0))\n\t\t{\n           return \"True$!^\";\n\t\t}\n\t\tif ((event_type == \"CLA\") || (event_type == \"CLE\"))\n\t\t{\n\t\t   if ((approval_status == \"P\") || (approval_status == \"D\") || (approval_status == \"W\"))\n\t\t\t\treturn \"False$!^Claims has already been processed for this bill number, Claims cannot be processed again.\";\n\t\t   /* For LMP5038-SCF-0232 on 25/10/2018 - Condition 99 commented\n\t\t   else if (approval_status == \"99\")\n\t\t\t\treturn \"False$!^Claims has already been submitted for this bill number, Claims cannot be processed again.\";\n\t\t   */\n\t\t   else\n\t\t\t\treturn \"True$!^\";\n\t\t}\n\t \n\t\tif ((event_type == \"REV\") && (approval_status == \"A\"))\n\t\t{\n\t\t    /*if(!(trans_ref_no != \"0\") || !(trans_ref_no.length>0))\n\t\t\t\treturn \"True$!^\";\n\t\t\telse \n\t\t\t\treturn \"False$!^Claims has already been processed from this bill number, Claims cannot be processed again.\";*/\n\t\t\treturn \"True$!^\";\n\t\t}\n\t\tif ((event_type == \"EOC\") && ((approval_status == \"P\") || (approval_status == \"A\")))\n\t\t\treturn \"False$!^Case has been approved for this bill number, Claims cannot be processed again\";\n\t\n\t\t/* For LMP5038-SCF-0232 on 25/10/2018 - Condition 99 commented\n\t\tif ((event_type == \"EOC\") && (approval_status == \"99\"))\n\t\t\treturn \"False$!^Case has been submitted for this bill number, Claims cannot be processed again\";\n\t\t*/\n\t   \n\t}\n\telse if (obj == \"REV\")\n\t{\n\t\tif (!(event_type.length > 0))\n\t\t{\n\t\t\treturn \"False$!^Claims has not been processed / Rejected for this bill number, Reversal cannot be processed.\";\n\t\t}\n\t\tif ((event_type == \"CLA\") || (event_type == \"CLE\"))\n\t\t{\n\t\t\t//  LMP5038-SCF-0232 on 25/10/2018  Condition (approval_status == \"99\") removed\n\t\t\tif ((approval_status == \"W\") ||(approval_status == \"A\") || (approval_status == \"P\"))\n\t\t\t{\n\t\t\t\treturn \"True$!^\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn \"False$!^Claims has not been processed / Rejected for this bill number, Reversal cannot be processed.\";\n\t\t\t}\n\t\t}\n\t\tif (event_type == \"REV\")\n\t\t{\n\t\t   /* if(!(trans_ref_no != \"0\"))\n\t\t\t\treturn \"False$!^Claims Reversal has already been processed from this bill number, Reversal cannot be processed again\";\n\t\t\telse \n\t\t\t    return \"True$!^\";*/\n\t\t\tif (approval_status == \"A\")\n\t\t\t\treturn \"False$!^Reversal has already been processed for this bill number, Reversal cannot be processed again\";\n\t\t\t/* For LMP5038-SCF-0232 on 25/10/2018 - Condition 99 commented\n\t\t\telse if (approval_status == \"99\")\n\t\t\t\treturn \"False$!^Reversal has been submitted for this bill number, Reversal cannot be processed again\";\n\t\t\t*/\n\t\t\telse \n\t\t\t\treturn \"True$!^\";\n\n\t   }\n\t   if (event_type == \"EOC\")\n\t   {\n\t\t   return \"True$!^\";\n\t   }\n\t   \n\t}\n\telse if (obj == \"EOC\")\n\t{\n\t   if (!(event_type.length > 0)){\n           return \"False$!^Claims has not been processed / Rejected for this bill number, End of Case cannot be processed.\";\n\t   }\n\t   if (event_type == \"CLA\")\n\t   {\n\t\t\tif ((approval_status == \"P\") || (approval_status == \"A\") || (approval_status == \"W\"))\n\t\t\t\treturn \"True$!^\";\n\t\t\t/* For LMP5038-SCF-0232 on 25/10/2018 - Condition 99 commented\n\t\t    else if (approval_status == \"99\")\n\t\t\t\treturn \"False$!^Claims has been submitted for this bill number, EOC cannot be processed.\";\n\t\t\t*/\n\t\t\telse\n\t\t\t\treturn \"False$!^Claims has not been processed for this bill number, EOC cannot be processed.\";\n\t   }\n\t   if (event_type == \"CLE\")\n\t   {\n\t\t   if ((approval_status == \"P\") || (approval_status == \"A\")  || (approval_status == \"W\"))\n\t\t\t\treturn \"False$!^Claims End of Case has been processed for this bill number, EOC cannot be processed again.\";\n\t\t   /* For LMP5038-SCF-0232 on 25/10/2018 - Condition 99 commented\n\t\t  ";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 =" else if (approval_status == \"99\")\n\t\t\t\treturn \"False$!^Claims End of Case has been submitted for this bill number, EOC cannot be processed.\";\n\t\t   */\n\t\t   else\n\t\t\t\treturn \"False$!^Claims not been processed for this bill number, EOC cannot be processed.\";\n\t   }\n\t   if (event_type == \"REV\")\n\t   {\n\t\t\tif ((approval_status == \"P\") || (approval_status == \"A\"))\n\t\t\t\treturn \"False$!^Reversal has already been processed for this bill number, EOC cannot be processed again.\";\n\t\t\telse\n\t\t\t\treturn \"True$!^\";\n\n\t\t\t/* For LMP5038-SCF-0232 on 25/10/2018 - Condition 99 commented\n\t\t\tif (approval_status == \"99\")\n\t\t\t\treturn \"False$!^Reversal has been submitted for this bill number, EOC cannot be processed again.\";\n\t\t\t*/\n\n\t   }\n\t   if ((event_type == \"EOC\") && ((approval_status == \"P\") || (approval_status == \"A\")))\n\t   {\n\t\t\treturn \"False$!^End of Case has already been processed for this bill number, EOC cannot be processed again.\";\n\t   }\n\t   /* For LMP5038-SCF-0232 on 25/10/2018 - Condition 99 commented\n\t   if ((event_type == \"EOC\") && (approval_status == \"99\"))\n\t   {\n\t\t\treturn \"False$!^End of Case has been submitted for this bill number, EOC cannot be processed again.\";\n\t   }\n\t   */\n\t   if ((event_type == \"EOC\") && ((approval_status == \"F\") || (approval_status == \"R\") || (approval_status == \"99\"))) //(approval_status == \"99\") Added for LMP5038-SCF-0232 on 25/10/2018\n\t   {\n\t\t\treturn \"True$!^\";\n\t   }\n\t   \n\t}\n\t//return \"False$!^Cliams has not been processed from this bill number.\";\n}\nfunction EClaimsTransaction(dataElements)\n{\n    var responseMsg=\"\";\n\tvar data1=true;\n\t$.ajax({\n\t\turl: \'../../servlet/eXH.InvokeMedikreditApplication\',\n\t\ttype: \'POST\',\n\t\tcache: false,\n\t\t\n\t\tdata: {\n\t\t\t\tcallType: \'ECLAIMSCL\',\n\t\t\t\tparamString: dataElements\n\t\t},\n\t\tsuccess: function (data1) {\n\t\t\tresponseMsg = data1;\n\t\t},\t\t\n\t\tdataType: \'text\',\n\t\tasync: false\n\t});\n\t\n\treturn responseMsg;\n\n} \n\nfunction ParseCheckResponse(responseMsg,request){\n\n\tvar responseData = \"\";\n\tvar existingData = \"\";\n\tresponseData = responseMsg.split(\"$!^\");\n\n\tif (responseData.length > 0)\n\t{\n\t\n\t\tif(responseData[0] == \"E\")\n\t\t{\n\t\t\tif(responseData[3] != null && responseData[3] != \"\" && responseData[3] != \" \"){\n\t\t\t\talert(\"APP-XH0070 \"+responseData[3]);\n\t\t\t}\n\t\t\telse{\n\t\t\t\t alert(\"APP-XH0070 Error Occured.\");\n\t\t\t}\n\t\t}\n\t\tif(responseData[0] == \"S\")\n\t\t{\n\t\t\tDetailsPopUp(responseData[1],request);\n\t\t}\n\t}\n\tparent.resultFrame.location.reload();\n\n}\n\nasync function DetailsPopUp(transID,request)\n{\n\n\tvar dialogHeight = \"30vh\";    // have to remove \n\tvar dialogWidth  = \"55vw\";\n\tvar dialogTop    = \"50\";\n    \n    if((request ==\"CLA\") || (request ==\"CLE\")){\n\t\tdialogHeight = \"45vh\";    // have to remove \n\t\tdialogWidth  = \"75vw\";\n\t\tdialogTop    = \"50\";\n\t}\n    \n\tvar title=\"Patient EClaims Response \";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:yes\" ;\n\n\t// we need to send required values which is need to be compared from existing and responseMsg\n\tif (transID != null && transID != \"\" && transID != \" \")\n    {\n\t\tvar arguments = new Array();\n\t\targuments[0]=transID;\n\t\tvar url = \"../../eXH/jsp/MediQueryResponsePopUp.jsp?trans_num=\"+transID; \n\t\tvar retVal = window.showModalDialog(url,arguments,features);\n\t}\n\telse\n\t{\n\t\talert(\"APP-XH0070 Response is not available\");\n\t}\n}\n\nfunction FetchResponse(){\n\t\n\t//DetailsPopUp(\"55\");\n\t//return;\n  \n\tvar checkedValue = \"\"; \n\tvar checkBoxes = document.getElementsByName(\'checkbox\');\n\tvar transid = \"\";\n\tvar request = \"\";\n\tvar count = 0;\n\tfor(var i = 0; i < checkBoxes.length; i++){\n\t\tif(checkBoxes[i].checked){\n\t\t\tcheckedValue = checkBoxes[i].value;\n\t\t\tvar transidobj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.trans_Id\"+i);\n\t\t\ttransid = transidobj.value;\n\t\t\tvar request_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.eventType\"+i);\n\t        request = request_obj.value;\n\t\t\tvar approval_status_obj = eval (\"document.PAYER_CHECK_CLAIMS_FORM.approvalStatus\"+i);\n\t        approval_status = approval_status_obj.value;\n\t\t\tcount++;\n\t\t}\n\t}\n\tif (count == 0 || checkedValue == null)\n\t{\n\t\talert(\"APP-XH0070 Select a bill to fetch the transaction\");\n\t\t return;\n\t}\n\tif (count > 1)\n\t{\n\t\t alert(\"APP-XH0070 More than one Bill numbers  cannot be processed, please select only one bill number.\");\n\t\t return;\n\t}\n\tif (approval_status == \"99\")\n\t{\n\t\tcheckedValue = checkedValue.replace(\"#REQUEST#\",request);\n\t\tif(!(transid != null && transid != \"\" && transid != \" \"))\n\t\t{ \n\t\t\talert(\"APP-XH0070 For this bill, no transaction has been processed.\");\n\t\t\treturn;\n\t\t}\n\t\n\t\n\t//checkedValue = document.forms[0].dataElements.value;\n\n\t\tcheckedValue = checkedValue.replace(\"ECLREQ\",\"ECLRES\");\n\n\t\t\n\n\t\tcheckedValue = checkedValue.replace(\"<TRANS_ID>XXX\",\"<TRANS_ID>\"+transid);\n\n\t\tresponseMessage = EClaimsTransaction(checkedValue);\t\n\t\tParseCheckResponse(responseMessage,request);\n\t}\n\t\n}\n\nfunction includeBoxChecked() {\n\n\tif (document.forms[0].includeMastercheckbox.checked == true) {\n\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = true;\n\t\t\t}\n\t\t} else if (document.forms[0].gatewayservers.length == undefined) {\n\t\t\tdocument.forms[0].includeCheckbox.checked = true;\n\t\t}\n\t}\n\telse {\n\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = false;\n\t\t\t}\n\t\t} else if (document.forms[0].includeCheckbox.length == undefined) {\n\t\t\tdocument.forms[0].includeCheckbox.checked = false;\n\t\t}\n\t}\n\treturn true;\n}\nfunction toggle(doc_num)\n{\n\t if( document.getElementById(\"hidethis\"+doc_num).style.display==\'none\' ){\n\t   document.getElementById(\"hidethis\"+doc_num).style.display = \'table\'; // set to table-row instead of an empty string\n\t }else{\n\t   document.getElementById(\"hidethis\"+doc_num).style.display = \'none\';\n\t }\n}\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n</head>\t\n\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" >\n<form name=\"PAYER_CHECK_CLAIMS_FORM\" id=\"PAYER_CHECK_CLAIMS_FORM\" method=\"POST\" action=\'\'  >\n";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 =" \n\t\t<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\t\t     \n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" >\t\t\t\n\t\t<input type=\'hidden\' name=\'patient_class_episode\' id=\'patient_class_episode\' value=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n\t\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">\n\t\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t\t<input type=\'hidden\' name=\'admission_from_dt\' id=\'admission_from_dt\' value=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n\t\t<input type=\'hidden\' name=\'admission_to_dt\' id=\'admission_to_dt\' value=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t\t<input type=\'hidden\' name=\'val_func\' id=\'val_func\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\t\t     \n\t\t\t\t\n\t\t<input type=\'hidden\' name=\'pat_name\' id=\'pat_name\' value=\"\">\n\t\t<input type=\'hidden\' name=\'pat_dob\' id=\'pat_dob\' value=\"\">\n\t\t<input type=\'hidden\' name=\'national_id\' id=\'national_id\' value=\"\">\n\t\t<input type=\'hidden\' name=\'sex\' id=\'sex\' value=\"\"> \n\t\t \n\t\t<input type=\'hidden\' name=\'visit_adm_dt_time\' id=\'visit_adm_dt_time\' value=\"\">\n\t\t<input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\"\">\n\t\t\n\t\t<input type=\'hidden\' name=\'location_code\' id=\'location_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'cust_code\' id=\'cust_code\' value=\"\">\n\t\t \n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"\">\n\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"\">\n\t\t<input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\"\">\n\t\t<input type=\'hidden\' name=\'second_name\' id=\'second_name\' value=\"\">\n\t\t<input type=\'hidden\' name=\'initial\' id=\'initial\' value=\"\">\n\t\t   \n\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"\">\n\t\t<input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\"\">\n\t\t<input type=\'hidden\' name=\'second_name\' id=\'second_name\' value=\"\">\n\t\t<input type=\'hidden\' name=\'initial\' id=\'initial\' value=\"\">\n\n\t\t<input type=\'hidden\' name=\'membership_no\' id=\'membership_no\' value=\"\">\n\t\t<input type=\'hidden\' name=\'wca_number\' id=\'wca_number\' value=\"\">\n\t\t<input type=\'hidden\' name=\'dependant_number\' id=\'dependant_number\' value=\"\">\n\t\t<input type=\'hidden\' name=\'dependant_relationship\' id=\'dependant_relationship\' value=\"\">\n\t\t<input type=\'hidden\' name=\'dataElements\' id=\'dataElements\' value=\"\">\n\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t<script>\n\t\t\t\talert(\'APP-002415 Query caused no records to be retrieved\');\n\t\t\t\thistory.go(-1);\n\t\t\t\tparent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n\n\t\t<fieldset>\n\t\t\t<table cellspacing=0 cellpadding=5 width=\'100%\' align=right border=0>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t<td align=right>\n\t\t\t\t\t\t<!-- <input class=\'BUTTON\' type=\"button\"  ID=\"eligibility_check\" name=eligibility_check value=\'Eligibility Check\' onClick=\"eligibilityCheck()\">\t -->\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\n\t\t\t</table>\t\n\t\t</fieldset>\n\t\n\t\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=center border=1>\n\t\t<tr>\n\t\t\t<td colspan=\"27\" class=\"COLUMNHEADER\" align=\'center\'>EClaims Transactions</td>\n\t\t</tr>\n\t\t<tr>\t   \n\t\t\t<td align=\"right\" class=\"CAGROUP\" width=\"80%\" >\n\t\t\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'Claims Trx\' onClick=\"EclaimsTrx(\'CLA\')\">\n\t\t\t    <input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'Claims EOC Trx\' onClick=\"EclaimsTrx(\'CLE\')\">\n\t\t\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'Reversal Trx\' onClick=\"EclaimsTrx(\'REV\')\">\t\t\t\n\t\t\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'EOC Trx\' onClick=\"EclaimsTrx(\'EOC\')\">\n\t\t\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'Fetch Response\' onClick=\"FetchResponse()\">\n\t\t\t</td>\n\t\t\t<td align=\"right\" class=\"CAGROUP\" width=\"20%\" >\n\t\t\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</A>\n\t\t\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</A>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\n\t\t<div id=\"left_child\" class=\"left_child\">\n\t\t<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' border=1 align=center>\t\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>\n\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font>\n\t\t\t\t</td>\n\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>\n\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>\n\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>\n\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>\n\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font>\n\t\t\t\t</td>\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>\n\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font>\n\t\t\t\t</td>\n\n\t\t\t</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<tr width=\'100%\' id = \'trGrpHeader";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' >\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td width=\'300\' style=\'display:block\' class=\'CAGROUP\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t<td width=\'300\' style=\'display:block\' class=\'CAGROUP\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t<td width=\'300\' style=\'display:block\' class=\'CAGROUP\'> ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" </td>\n\t\t\t\t\t<td width=\'300\' style=\'display:block\' class=\'CAGROUP\'> ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" </td>\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td colspan = \"7\">\n\t\t\t\t\t<table  cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"1\" align=\"center\" style=\"height:10px;overflow-y:scroll;\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\' style=\"font-size:11px;\" width=\'8%\' align=\"center\">\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\' style=\"font-size:11px;\" width=\'8%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'10%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'12%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'15%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'15%\'>\n\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</font>\n\t\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'10%\'>\n\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</font>\n\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'15%\'>\n\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</font>\n\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'gridData\' align=\'center\' width=\'8%\'> <input type=\'checkbox\' id=\'checkbox\' name=\'secChk";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'secChk";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' > </td>\n\t\t\t\t\t<td  class=\'gridData\' width=\'8%\'> ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" </td>\n\t\t\t\t\t<td  class=\'gridData\' width=\'10%\'> ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" </td>\n\t\t\t\t\t<td  class=\'gridData\' width=\'15%\'> ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" </td>\n\t\t\t\t\t<td  class=\'gridNumericData\' align=\"right\" width=\'10%\'> ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" </td>\n\t\t\t\t\t<td  class=\'gridData\' width=\'8%\'> ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;</td>\n\t\t\t\t\t<td  class=\'gridData\' width=\'8%\'> ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'authnum";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'authnum";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\t\n\t\t\t\t\t<input type=\'hidden\' name=\'destcode";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'destcode";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\t\n\t\t\t\t\t<input type=\'hidden\' name=\'transID";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'transID";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\t\n\t\t\t\t\t<input type=\'hidden\' name=\'event_type";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'event_type";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'approval_status";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'approval_status";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'settlement_ind";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'settlement_ind";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'> \n\t\t\t\t\t<input type=\'hidden\' name=\'billing_grp";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'billing_grp";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'> \n\t\t\t\t\t<input type=\'hidden\' name=\'cust_code";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'cust_code";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'visit_date";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'visit_date";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'trans_Id";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'trans_Id";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'approvalStatus";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'approvalStatus";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'eventType";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' id=\'eventType";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'transrefno";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'transrefno";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'rev_event_type";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' id=\'rev_event_type";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'rev_approval_status";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' id=\'rev_approval_status";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="<tr id = \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =">\n\t\t\t\t    <td colspan = \"9\">\n\t\t\t\t\t\t<table  cellspacing=\"0\" cellpadding=\"3\" width=\"95%\" border=\"1\" align=\"right\" style=\"height:10px;overflow-y:scroll;\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\' style=\"font-size:11px;\" width=\'10%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\' style=\"font-size:11px;\" width=\'4%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'8%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'6%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'6%\'>\n\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</font>\n\t\t\t\t\t\t\t</td>\t\t\n\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'8%\'>\n\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</font>\n\t\t\t\t\t\t\t</td>\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="  \n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td  class=\'gridData\'> ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" </td>\n\t\t\t\t\t\t\t<td  class=\'gridData\'> ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" </td>\n\t\t\t\t\t\t\t<td  class=\'gridData\' > ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" </td>\n\t\t\t\t\t\t\t<td  class=\'gridNumericData\' align=\"right\"> ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" </td>\n\t\t\t\t\t\t\t<td  class=\'gridData\' align=\"center\"> ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" </td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\t\n\t\t\t   ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t</table>\n\t\t</div>\n\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

System.out.println(" ::: sStyle ::: "+sStyle);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);

	String order = "";
	String orderBy = "";
	String action_type=null;
	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null ;
    ArrayList group= new ArrayList();

	String rs_patient_id ="",rs_first_name = "", rs_family_name = "", rs_sex = "", rs_episode_id = "", rs_encounter_id = "", rs_patient_class = ""; 
	String rs_visit_adm_date_time="",rs_visit_adm_type = "", rs_service_code = "", rs_discharge_date_time = "", rs_operating_facility_id = "", rs_doc_type_code = "" ; 
	String rs_doc_num = "", rs_doc_date = "", rs_bill_from_date = "", rs_bill_to_date = "", rs_visit_id = "", rs_cust_code = "", rs_blng_grp_id = "", rs_cust_name = "",  rs_bill_amount = "", rs_settleInd = "", rs_billGrpId = "", l_where_values = "", rs_visit_date = "", l_app_msg = "";

	String rs_credit_auth_ref = "", rs_credit_auth_date = "", rs_membership_num_sap = "", rs_dependant_num_sap = "", rs_dependant_relation_sap = "", rs_wca_number_sap = "",rs_membership_surname = "",rs_membership_initial = "";

	String rs_claim_type = "";

	String rs_memberId = "", rs_serviceCode = "", rs_specialityCode = "", rs_custCode = "", rs_patientClass = "", rs_locationType = "", rs_destCode = "" ;
	String rs_firstName = "", rs_secondName = "", rs_intial = "", rs_dob = "",rs_familyName="", rs_patient_idnum = "";

	String l_event_trans_query = "",l_event_trans_type = "", l_case_trans_no = "",l_approval_trans_status = "";
	String l_rev_event_type = "", l_rev_case_no = "",l_rev_approval_status = "",l_rev_claim_no = "";
	String l_episode_type = "";
	String checkboxvalue = "";
	String l_item_line_query = "";
	HttpSession httpSession = request.getSession(false);
	int l_rev_srl_no = 0;

	String loginfacility = (String) session.getValue("facility_id");
	String user_id	= (String)session.getValue("login_user") ;
	Properties p=( java.util.Properties ) session.getValue( "jdbc" ) ;
	String AddedAtWsNo     =  p.getProperty("client_ip_address");

	int billDetailsRowCount = 0;

    String patient_group_flag = "" , episode_group_flag = "",currentSubGroup ="",prevSubGroup ="",emptySubGroup="";
    String customer_group = XHDBAdapter.checkNull(request.getParameter("customer_group"));
	String customer_id = XHDBAdapter.checkNull(request.getParameter("customer_id"));
	String patient_id= XHDBAdapter.checkNull(request.getParameter("patient_id"));
	String patient_class_episode = XHDBAdapter.checkNull(request.getParameter("patient_class_episode"));
	String episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
	String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));

	String admission_from_dt = XHDBAdapter.checkNull(request.getParameter("admission_from_dt"));

	//String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

    String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));


    String val_func = (XHUtil.singleParamExeQry("SELECT DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG where  ELEMENT_ID = 'VAL_FUNCTION' and SEGMENT_ID = 'ECL'"));


	if(admission_from_dt!="" && admission_from_dt!=null)
	{
	   admission_from_dt = admission_from_dt+ " 00:00:00";
	}

	String admission_to_dt = XHDBAdapter.checkNull(request.getParameter("admission_to_dt"));
	if(admission_to_dt!="" && admission_to_dt!=null)
	{
	   admission_to_dt =admission_to_dt + " 23:59:59";
	}
     String bill_from = XHDBAdapter.checkNull(request.getParameter("bill_from"));
	String bill_to = XHDBAdapter.checkNull(request.getParameter("bill_to"));

	//String patient_class_orderby = XHDBAdapter.checkNull(request.getParameter("patient_class_orderby"));
	//String eligibility_action_type = XHDBAdapter.checkNull(request.getParameter("eligibility_action_type"));
	String event_type = XHDBAdapter.checkNull(request.getParameter("event_type"));
	String eligibility_status_type = XHDBAdapter.checkNull(request.getParameter("eligibility_status_type"));
    
	//String admission_type = XHDBAdapter.checkNull(request.getParameter("admission_type"));


	String dest_code = "";
    String Checkboxname = "";
	System.out.println("XHPatientMembershipCheckResult.jsp:::isDebugYN....."+isDebugYN);

	if(isDebugYN.equals("Y")){
	System.out.println("XHPatientMembershipCheckResult.jsp:::customer_id....."+customer_id);
	System.out.println("XHPatientMembershipCheckResult.jsp:::patient_id....."+patient_id);
	System.out.println("XHPatientMembershipCheckResult.jsp:::admission_from_dt....."+admission_from_dt+" admission_to_dt :::: "+admission_to_dt );
	System.out.println("XHPatientMembershipCheckResult.jsp:::bill_from....."+bill_from+" bill_to :::: "+bill_to );
	System.out.println("XHPatientMembershipCheckResult.jsp:: event_type ::: "+event_type);
	System.out.println("XHPatientMembershipCheckResult.jsp:: eligibility_status_type ::: "+eligibility_status_type);
	System.out.println("XHPatientMembershipCheckResult.jsp:: val_func ::: "+val_func);

    }
	/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

	boolean  boolToggle = true;
	String strTDClass = "";
	String whereClause = "";
	int totalRecords=0;

	Connection dbConn = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;

	ResultSet rsevent=null;
	ResultSet rsdest=null;
	String l_event_query = "", l_cla_image_str = "", l_rev_image_str = "", l_eoc_image_str = "", l_event_type = "", l_image_str = "", query = "",l_img_vw_dtl_str = "";

	int l_claims_count = 0, l_reversal_count = 0, l_eoc_count = 0;
	int l_srl_no = 0 , l_srl_trans_no = 0;

	String l_case_no = "",l_trans_ref_no = "0", l_approval_status = "", l_claim_no = "", l_approval_status_desc = "",l_approval_trans_status_desc = "";

	String l_rej_image_str = "";

	try
	{ 
		conn = ConnectionManager.getConnection(request);

		whereClause = "";
		int where_flag = 0;
		if(isDebugYN.equals("Y")){
			System.out.println("on admission.. patient id..."+patient_id);
		}

		if(patient_id != null && patient_id != "" && patient_id != " ")
		{
			if(where_flag>0){
			whereClause = whereClause + " and PATIENT_ID =  '#patient_id' ";
			}
			else
			{
			 whereClause = whereClause + "  where PATIENT_ID =  '#patient_id' ";
			}
            where_flag=where_flag+1;

		}
		if(customer_id != null && customer_id != "" && customer_id != " ")
		{
			if(where_flag>0)whereClause = whereClause + " and CUST_CODE = '#customer_id' ";
			else whereClause = whereClause + " where CUST_CODE = '#customer_id' ";
			where_flag=where_flag+1;

		}
		if(episode_id != null && episode_id != "" && episode_id != " ")
		{
			if(where_flag>0)whereClause = whereClause + " and episode_id = '#episode_id' ";
			else whereClause = whereClause + " where episode_id = '#episode_id' ";
			where_flag=where_flag+1;

		}
		if(admission_from_dt!="" && admission_from_dt!=null && admission_to_dt!="" && admission_to_dt!=null){
				
		    if(where_flag>0)whereClause = whereClause + " and TO_Date(VISIT_ADM_DATE_TIME,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+admission_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+admission_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
			else whereClause = whereClause + " where TO_Date(VISIT_ADM_DATE_TIME,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+admission_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+admission_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
			where_flag=where_flag+1;

		}
		if(bill_from!="" && bill_from!=null && bill_to!="" && bill_to!=null){
				
		    if(where_flag>0) whereClause = whereClause + " and DOC_NUM BETWEEN '#bill_from' AND '#bill_to' ";
			else whereClause = whereClause + "  where DOC_NUM BETWEEN '#bill_from' AND '#bill_to' ";
			where_flag=where_flag+1;

		}

		whereClause = whereClause + " order by PATIENT_ID, PATIENT_NAME, SEX, EPISODE_ID, VISIT_ADM_DATE_TIME ";
		/*if(eligibility_status_type != null && eligibility_status_type != "" && eligibility_status_type != " ")
		{
			if(where_flag>0)whereClause = whereClause + " AND APPROVAL_STATUS =  NVL('#eligibility_status_type',APPROVAL_STATUS)";
			else whereClause = whereClause + " APPROVAL_STATUS =  NVL('#eligibility_status_type',APPROVAL_STATUS)";
			where_flag=where_flag+1;

		}
		*/
        currentSubGroup = patient_group_flag +""+episode_group_flag;
		request.setAttribute(XHQueryRender.strQueryId,"MEDICLAIMSCHECK");
		if(isDebugYN.equals("Y")){
			System.out.println("currentSubGroup....."+currentSubGroup);
		}
		
		if(isDebugYN.equals("Y")){
			System.out.println("whereClause....."+whereClause);
		}
		request.setAttribute(XHQueryRender.col,"34"); 
		request.setAttribute(XHQueryRender.maxRec,"5");
		request.setAttribute(XHQueryRender.whereClause,whereClause);
		HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");	
		//String sqlQuery= XHQueryRender.sqlQuery;	
		//System.out.println("sqlQuery... "+sqlQuery);
		ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
		
		ArrayList arrCol = null;
		boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
		boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
		//if(isDebugYN)System.out.println("boolPrevious...."+boolPrevious);
		//if(isDebugYN)System.out.println("boolNext...."+boolNext);
		String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
		String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
		if (boolPrevious == true)
		{
			strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
		}
		else
		{
			strPrevious = " ";
		}
		if (boolNext== true)
		{
			strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
		}
		else
		{
			strNext  = " ";
		}
		if(isDebugYN.equals("Y")){
			System.out.println("whereClause....."+whereClause);
		}
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_class_episode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(episode_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(admission_from_dt ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(admission_to_dt ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(val_func));
            _bw.write(_wl_block15Bytes, _wl_block15);


		if(arrRow.size()==0)
		{
		
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
		else
		{
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

			System.out.println("Before getting details....."+arrRow.size());
			Map cmp = new HashMap();

			totalRecords=0;

			billDetailsRowCount = arrRow.size();
			int j = 0;
            String hideTable = "style='display:none;'";

			dbConn = ConnectionManager.getConnection();

			for (j=0; j<arrRow.size();j++)
			{
				l_image_str = "";
				arrCol = (ArrayList)arrRow.get(j);
				rs_patient_id = arrCol.get(0).equals("null")?"":(String)arrCol.get(0);				
				rs_first_name = arrCol.get(1).equals("null")?"":(String)arrCol.get(1);
				rs_family_name = arrCol.get(2).equals("null")?"":(String)arrCol.get(2);
				rs_sex = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);
				rs_episode_id= arrCol.get(4).equals("null")?"":(String)arrCol.get(4);
				rs_encounter_id = arrCol.get(5).equals("null")?"":(String)arrCol.get(5);
				rs_patient_class= arrCol.get(6).equals("null")?"":(String)arrCol.get(6);
				rs_visit_adm_date_time = arrCol.get(7).equals("null")?"":(String)arrCol.get(7);
				rs_visit_adm_type = arrCol.get(8).equals("null")?"":(String)arrCol.get(8);				
				rs_service_code = arrCol.get(9).equals("null")?"":(String)arrCol.get(9);
				rs_discharge_date_time = arrCol.get(10).equals("null")?"":(String)arrCol.get(10);
				rs_operating_facility_id= arrCol.get(11).equals("null")?"":(String)arrCol.get(11);

				rs_doc_type_code= arrCol.get(12).equals("null")?"":(String)arrCol.get(12);
				rs_doc_num = arrCol.get(13).equals("null")?"":(String)arrCol.get(13);
				rs_doc_date = arrCol.get(14).equals("null")?"":(String)arrCol.get(14);
				rs_bill_from_date= arrCol.get(15).equals("null")?"":(String)arrCol.get(15);				
				rs_bill_to_date = arrCol.get(16).equals("null")?"":(String)arrCol.get(16);
				rs_visit_id = arrCol.get(17).equals("null")?"":(String)arrCol.get(17);
				rs_cust_code= arrCol.get(18).equals("null")?"":(String)arrCol.get(18);
				rs_blng_grp_id= arrCol.get(19).equals("null")?"":(String)arrCol.get(19);

				rs_credit_auth_ref = arrCol.get(20).equals("null")?"":(String)arrCol.get(20);
				rs_credit_auth_date= arrCol.get(21).equals("null")?"":(String)arrCol.get(21);				
				rs_membership_num_sap = arrCol.get(22).equals("null")?"":(String)arrCol.get(22);
				rs_dependant_num_sap = arrCol.get(23).equals("null")?"":(String)arrCol.get(23);
				rs_dependant_relation_sap= arrCol.get(24).equals("null")?"":(String)arrCol.get(24);
				rs_wca_number_sap= arrCol.get(25).equals("null")?"":(String)arrCol.get(25);
				//rs_destCode = arrCol.get(26).equals("null")?"":(String)arrCol.get(26);
				rs_cust_name = arrCol.get(27).equals("null")?"":(String)arrCol.get(27);
				rs_bill_amount = arrCol.get(28).equals("null")?"":(String)arrCol.get(28);
				rs_patient_idnum = arrCol.get(29).equals("null")?"":(String)arrCol.get(29);
				rs_membership_surname = arrCol.get(30).equals("null")?"":(String)arrCol.get(30);
				rs_membership_initial = arrCol.get(31).equals("null")?"":(String)arrCol.get(31);
				rs_settleInd = arrCol.get(32).equals("null")?"":(String)arrCol.get(32);
				rs_visit_date = arrCol.get(33).equals("null")?"":(String)arrCol.get(33);

				if (rs_patient_class.equals("OP")) {
					l_episode_type = "O";
				}
				if (rs_patient_class.equals("EM")) {
					l_episode_type = "E";
				}
				if (rs_patient_class.equals("IP")) {
					l_episode_type = "I";
				}
				if (rs_patient_class.equals("DC")) {
					l_episode_type = "D";
				}
				if (rs_patient_class.equals("")) {
					l_episode_type = "X";
				}

				if (rs_settleInd.equals("X") || rs_settleInd.equals("R"))
				{	
					l_app_msg = " ::: Inside BL_CUST_DEST_MST ::: ";
					System.out.println(l_app_msg);	

					query = "select DESTINATION_CODE_SAP, CLAIM_TYPE from BL_CUST_DEST_MST a, pr_encounter b"
								+" where "
								+"	 B.PATIENT_ID = ? and B.EPISODE_ID = ? and  CUST_CODE = ? and  trunc(VISIT_ADM_DATE_TIME) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE) ";

					l_where_values = rs_cust_code;

				}
				else if (rs_settleInd.equals("C"))
				{
					l_app_msg = " ::: Inside BL_BLNG_GRP_DEST_MST ::: ";
					System.out.println(l_app_msg);	

					query = "select DESTINATION_CODE_SAP, CLAIM_TYPE from BL_BLNG_GRP_DEST_MST a, pr_encounter b"
								+" where "
								+"	 B.PATIENT_ID = ? and B.EPISODE_ID = ? and  BLNG_GRP_ID = ? and  trunc(VISIT_ADM_DATE_TIME) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE) ";

					l_where_values = rs_blng_grp_id;
				}

				l_app_msg = " ::: Inside GETDESTINATIONCODE Query ::: "+query+ " ::: RS_PATIENT_ID ::: "+rs_patient_id+ " ::: RS_EPISODE_ID ::: "+rs_episode_id+ " ::: L_WHERE_VALUES ::: "+l_where_values;
				System.out.println(l_app_msg);				
				
				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, rs_patient_id);
				pstmt.setString(2, rs_episode_id);
				pstmt.setString(3, l_where_values);
				rsdest = pstmt.executeQuery();
				while(rsdest.next())
				{
				   rs_destCode = rsdest.getString("DESTINATION_CODE_SAP");
				   rs_claim_type = rsdest.getString("CLAIM_TYPE");
				}

				l_app_msg = " ::: Inside RS_DESTCODE ::: "+rs_destCode+" ::: RS_CLAIM_TYPE ::: "+rs_claim_type;
				System.out.println(l_app_msg);
				
				l_event_type = "";l_srl_no = 0; l_case_no = ""; l_approval_status = ""; l_claim_no = ""; l_approval_status_desc = "" ;
				
				// For LMP5038-SCF-0232 Condition 99 was removed APPROVAL_STATUS in ('P','W','A', '99')
				l_event_query = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, trans_type, event_type, srl_no, case_num, claim_num, approval_status "
								+"  from xf_eclaims_trx_hdr "
								+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
								+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
								+"							and DOC_TYPE_CODE = ? and DOC_NUM = ? and APPROVAL_STATUS in ('P','W','A'))";

				System.out.println("l_event_query...."+l_event_query);

				pstmt = dbConn.prepareStatement(l_event_query);
				pstmt.setString(1, rs_operating_facility_id);
				pstmt.setString(2, rs_patient_id);
				pstmt.setString(3, rs_episode_id);
				pstmt.setString(4, rs_visit_id);
				pstmt.setString(5, rs_doc_type_code);
				pstmt.setInt(6, Integer.parseInt(rs_doc_num));

				rsevent = pstmt.executeQuery();

				while(rsevent.next())
				{
				   l_event_type = rsevent.getString("EVENT_TYPE")==null?"":rsevent.getString("EVENT_TYPE"); 
				   l_srl_no =  rsevent.getInt("SRL_NO");
				   l_case_no = rsevent.getString("CASE_NUM")==null?"":rsevent.getString("CASE_NUM"); 
				   l_approval_status = rsevent.getString("APPROVAL_STATUS")==null?"":rsevent.getString("APPROVAL_STATUS"); 
				   l_claim_no = rsevent.getString("CLAIM_NUM")==null?"":rsevent.getString("CLAIM_NUM"); 
				}
				l_trans_ref_no = String.valueOf(l_srl_no);

				System.out.println("l_event_type...."+l_event_type+"..l_srl_no.."+l_srl_no+"..l_case_no.."+l_case_no+"..l_approval_status.."+l_approval_status+"..l_claim_no.."+l_claim_no+"..l_trans_ref_no.."+l_trans_ref_no);

				System.out.println("l_trans_ref_no...."+l_trans_ref_no);

				rs = null;				

				l_event_trans_query = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, TRANS_TYPE, EVENT_TYPE, SRL_NO, CASE_NUM, "
										+"  nvl(APPROVAL_STATUS,'N') APPROVAL_STATUS "
										+"  from xf_eclaims_trx_hdr "
										+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
										+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
										+"								and DOC_TYPE_CODE = ? and DOC_NUM = ?) ";
										
				System.out.println("l_event_trans_query...."+l_event_trans_query);

				pstmt = dbConn.prepareStatement(l_event_trans_query);
				pstmt.setString(1, rs_operating_facility_id);
				pstmt.setString(2, rs_patient_id);
				pstmt.setString(3, rs_episode_id);
				pstmt.setString(4, rs_visit_id);
				pstmt.setString(5, rs_doc_type_code);
				pstmt.setInt(6, Integer.parseInt(rs_doc_num));

				rsevent = pstmt.executeQuery();

                l_event_trans_type = ""; l_srl_trans_no = 0; l_case_trans_no = ""; l_approval_trans_status ="";

				while(rsevent.next())
				{
				   l_event_trans_type = rsevent.getString("EVENT_TYPE")==null?"":rsevent.getString("EVENT_TYPE");  
				   l_srl_trans_no = rsevent.getInt("SRL_NO");
				   l_case_trans_no = rsevent.getString("CASE_NUM")==null?"":rsevent.getString("CASE_NUM"); 
				   l_approval_trans_status = rsevent.getString("APPROVAL_STATUS")==null?"":rsevent.getString("APPROVAL_STATUS"); 
				}
				
				if (!(l_event_type.length()>0))
				{
					l_event_type = l_event_trans_type;
					l_srl_no = l_srl_trans_no;
					l_approval_status = l_approval_trans_status; 
					l_claim_no = l_case_trans_no;
				}


				String l_status_code = "N", l_status_type = "CLA", l_trans_event = "ECL";

				if (l_event_trans_type.equals("CLA"))
				{
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") added
					if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F") || l_approval_trans_status.equals("99"))
					{
						l_status_code = "N";
						l_status_type = "CLA";
					}
					
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") commented
					/*
					if (l_approval_trans_status.equals("99"))
					{
						l_status_code = "S";
						l_status_type = "CLA";
					}
					*/
					
					if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P") || l_approval_trans_status.equals("W"))
					{
						l_status_code = "P";
						l_status_type = "CLA";
					}

					if (l_approval_trans_status.equals("0") || l_approval_trans_status.equals("1") || l_approval_trans_status.equals("2") || l_approval_trans_status.equals("3") || l_approval_trans_status.equals("4"))
					{
						l_status_code = l_approval_trans_status;
						l_status_type = "CLA";
						l_trans_event = "ERA";
					}
				}

				if (l_event_trans_type.equals("REV"))
				{
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") commented
					/*
					if (l_approval_trans_status.equals("99"))
					{
						l_status_code = "S";
						l_status_type = "CLA";
					}
					*/

					if (l_approval_trans_status.equals("A"))
					{
						l_status_code = "N";
						l_status_type = "CLA";
					}
					
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") added
					if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F") || l_approval_trans_status.equals("99"))
					{
						l_status_code = "P";
						l_status_type = "CLA";
					}
				}

				if (l_event_trans_type.equals("EOC"))
				{
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") commented
					/*
					if (l_approval_trans_status.equals("99"))
					{
						l_status_code = "S";
						l_status_type = "EOC";
					}
					*/

					if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P"))
					{
						l_status_code = "P";
						l_status_type = "EOC";
					}
					
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") added
					if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F") || l_approval_trans_status.equals("99"))
					{
						l_status_code = "P";
						l_status_type = "CLA";
					}
				}

				if (l_event_trans_type.equals("CLE"))
				{
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") added
					if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F") || l_approval_trans_status.equals("99"))
					{
						l_status_code = "N";
						l_status_type = "CLA";
					}
					
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") commented
					/*
					if (l_approval_trans_status.equals("99"))
					{
						l_status_code = "S";
						l_status_type = "EOC";
					}
					*/
					
					if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P") || l_approval_trans_status.equals("W"))
					{
						l_status_code = "P";
						l_status_type = "EOC";
					}

					if (l_approval_trans_status.equals("0") || l_approval_trans_status.equals("1") || l_approval_trans_status.equals("2") || l_approval_trans_status.equals("3") || l_approval_trans_status.equals("4"))
					{
						l_status_code = l_approval_trans_status;
						l_status_type = "CLA";
						l_trans_event = "ERA";
					}
				}

				rsevent = null;
				
				String l_status_query = "";

				l_status_query = "Select STATUS_DESC from  XH_TRANS_STATUS "										
										+"	where TRANS_EVENT = ? AND TRANS_TYPE = ? AND STATUS_CODE = ? ";
										
				System.out.println("l_event_trans_query...."+l_event_trans_query);

				pstmt = dbConn.prepareStatement(l_status_query);
				pstmt.setString(1, l_trans_event);
				pstmt.setString(2, l_status_type);
				pstmt.setString(3, l_status_code);				

				rsevent = pstmt.executeQuery();

				l_approval_status_desc ="";

				while(rsevent.next())
				{				   
				   l_approval_status_desc = rsevent.getString("STATUS_DESC")==null?"":rsevent.getString("STATUS_DESC"); 
				}              
				
				rs = null;

				System.out.println("rs_operating_facility_id...."+rs_operating_facility_id+"  rs_doc_type_code...."+rs_doc_type_code+"  rs_doc_num...."+rs_doc_num);

				/*

				l_item_line_query = "Select a.operating_facility_id, a.PATIENT_ID, a.EPISODE_ID, a.EPISODE_TYPE, a.VISIT_ID, NULL CLINICIAN, "
									+"			c.BILL_DOC_TYPE_CODE, c.BILL_DOC_NUM, rownum, "
									+"			c.SERV_QTY, c.BLNG_SERV_CODE, d.long_desc, c.SERV_ITEM_CODE, c.SERV_ITEM_DESC,TO_CHAR (c.SERVICE_DATE,'DD/MM/YYYY hh24:mi:ss') SERVICE_DATE, "
									+"			TO_CHAR (c.org_gross_charge_amt, 9999990.99) org_gross_charge_amt,TO_CHAR (c.org_disc_amt, 9999990.99) org_disc_amt,TO_CHAR (c.org_net_charge_amt, 9999990.99) org_net_charge_amt,TO_CHAR (c.ADJ_GROSS_CHARGE_AMT, 9999990.99) ADJ_GROSS_CHARGE_AMT,TO_CHAR (c.ADJ_DISC_AMT, 9999990.99) ADJ_DISC_AMT,TO_CHAR (c.ADJ_NET_CHARGE_AMT, 9999990.99) ADJ_NET_CHARGE_AMT, "
									+"			c.TRX_DOC_REF, c.TRX_DOC_REF_LINE_NUM, c.TRX_DOC_REF_SEQ_NUM, TO_CHAR (c.BASE_CHARGE_AMT, 9999990.99) BASE_CHARGE_AMT, c.TRX_DATE, NULL UPFS_CODE "
									+"	from    bl_bill_hdr a, bl_patient_charges_folio c, bl_blng_serv d "
									+"	WHERE a.operating_facility_id = c.operating_facility_id "
									+"			AND a.doc_type_code = c.bill_doc_type_code "
									+"			AND a.doc_num = c.bill_doc_num "
									+"			AND a.patient_id = c.patient_id "
									+"			AND a.episode_id = c.episode_id "
									+"			AND a.episode_type = c.episode_type "
									+" 			AND c.blng_serv_code = d.blng_serv_code "
									+"			AND c.trx_status IS NULL "
									+"			and a.operating_facility_id = ? "
									+"			and c.BILL_DOC_TYPE_CODE = ? "
									+"			and c.BILL_DOC_NUM = ? ";	
									
				*/

				l_item_line_query = "Select operating_facility_id, PATIENT_ID, EPISODE_ID, EPISODE_TYPE, VISIT_ID, NULL CLINICIAN, BILL_DOC_TYPE_CODE, "
									+"	BILL_DOC_NUM, rownum, SERV_QTY, BLNG_SERV_CODE, SERV_DESC, SERV_ITEM_CODE, SERV_ITEM_DESC, "
									+"	TO_CHAR (SERVICE_DATE,'DD/MM/YYYY hh24:mi:ss') SERVICE_DATE, "			
									+"	TO_CHAR (org_gross_charge_amt, 9999990.99) org_gross_charge_amt, "
									+"	TO_CHAR (org_disc_amt, 9999990.99) org_disc_amt, "
									+"	TO_CHAR (org_net_charge_amt, 9999990.99) org_net_charge_amt, "
									+"	TO_CHAR (ADJ_GROSS_CHARGE_AMT, 9999990.99) ADJ_GROSS_CHARGE_AMT, "
									+"	TO_CHAR (ADJ_DISC_AMT, 9999990.99) ADJ_DISC_AMT, "
									+"	TO_CHAR (ADJ_NET_CHARGE_AMT, 9999990.99) ADJ_NET_CHARGE_AMT, 	"		
									+"	TRX_DOC_REF, TRX_DOC_REF_LINE_NUM, TRX_DOC_REF_SEQ_NUM, "
									+"	TO_CHAR (BASE_CHARGE_AMT, 9999990.99) BASE_CHARGE_AMT, TRX_DATE, NULL UPFS_CODE "
									+"	from   XF_ECLAIMS_BILL_DETAILS_VW "
									+" WHERE  operating_facility_id = ? 	"		
									+"		and BILL_DOC_TYPE_CODE = ? 		"	
									+"		and BILL_DOC_NUM = ?			";

		
			    System.out.println("l_item_line_query..."+l_item_line_query);
				pstmt = dbConn.prepareStatement(l_item_line_query);
				pstmt.setString(1, rs_operating_facility_id);
				pstmt.setString(2, rs_doc_type_code);
				pstmt.setInt(3, Integer.parseInt(rs_doc_num));
				rs = pstmt.executeQuery();	

				
				System.out.println("l_event_type...."+l_event_type+"  l_approval_status...."+l_approval_status);	
				if ((l_status_type.equals("CLA") || l_event_type.equals("CLE")) && l_status_code.equals("S"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsClaims_Submit.png' alt='"+l_approval_status_desc+"'> ";

				if ((l_status_type.equals("CLA") || l_event_type.equals("CLE")) && l_status_code.equals("N"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsClaims_Pending.PNG' alt='"+l_approval_status_desc+"'> ";

				if ((l_status_type.equals("CLA") || l_status_type.equals("CLE")) && l_status_code.equals("P"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsClaims_Success.PNG' alt='"+l_approval_status_desc+"'> ";

				if (l_status_type.equals("EOC") && l_status_code.equals("P"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsEOC_Success.PNG' alt='"+l_approval_status_desc+"'> ";

				if (l_trans_event.equals("ERA") && l_status_type.equals("CLA"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsERA_Success.PNG' alt='"+l_approval_status_desc+"'> ";
					
				l_img_vw_dtl_str = "<input type='image' id='claims_img' src='../../eXH/images/blist.gif' alt='View History' style='width:20px; height: 20px;' onClick='ViewTransDetails(this)'   patient_id='"+rs_patient_id+"' episode_id='"+rs_episode_id+"'  visit_id='"+rs_visit_id+"' doc_num='"+rs_doc_num+"'  bill_doc_code='"+rs_doc_type_code+"'> ";

				System.out.println("Group...."+group.size());
				currentSubGroup =rs_patient_id+"@"+rs_first_name+"@"+rs_sex+"@"+rs_episode_id+"@"+rs_visit_adm_date_time;
				System.out.println("currentSubGroup...."+currentSubGroup);			
					
				if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){
					if (j>0) {
						out.println("</table>");
						out.println("</td>");
						out.println("</tr>");
					}
					String str="";							
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(j));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs_patient_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs_first_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs_sex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs_episode_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rs_visit_adm_date_time));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs_cust_name));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

					}
					else
					{
					  
            _bw.write(_wl_block41Bytes, _wl_block41);

					}

					checkboxvalue = "<PATIENT_ID>"+rs_patient_id+"$!^<ENCOUNTER_ID>"+rs_encounter_id+"$!^<EPISODE_ID>"+rs_episode_id+"$!^<VISIT_ID>"+rs_visit_id+"$!^<EPISODE_TYPE>"+l_episode_type+"$!^<REQUEST>#REQUEST#$!^<REQUEST_TYPE>ECLREQ$!^<MEMBER_ID>"+rs_membership_num_sap+"$!^<DEPD_CODE>"+rs_dependant_num_sap+"$!^<DEPD_RELN>"+rs_dependant_relation_sap+"$!^<CUST_CD>"+rs_cust_code+"$!^<DEST_CD>"+rs_destCode+"$!^<USER>"+user_id+"$!^<FACILITY_ID>"+rs_operating_facility_id+"$!^<TRANS_ID>XXX$!^<WCA_NUM>"+rs_wca_number_sap+"$!^<WS_NO>"+AddedAtWsNo+"$!^<BILL_DOC_TYPE_CODE>"+rs_doc_type_code+"$!^<BILL_DOC_NO>"+rs_doc_num+"$!^<AUTHORIZATION_NUM>"+rs_credit_auth_ref+"$!^<BILL_DATE>"+rs_doc_date+"$!^<TRANS_REF_ID>"+l_trans_ref_no+"$!^<PATIENT_ID_NUM>"+rs_patient_idnum+"$!^<EVENT_TYPE>"+l_event_type+"$!^<MEMBER_SURNAME>"+rs_membership_surname+"$!^<MEMBER_INITIAL>"+rs_membership_initial+"$!^<BLNG_GRP_ID>"+rs_blng_grp_id+"$!^<SETTLEMENT_IND>"+rs_settleInd+"$!^<CLAIM_TYPE>"+rs_claim_type+"$!^";
					l_rej_image_str = "<img src='../../eXH/images/ViewDetails.gif' style='width:15px; height: 15px;margin-top :-15px;' alt='View Line Details' align='right' onClick=\"toggle('"+rs_doc_num+"')\"/>";

					Checkboxname = "Check"+j;
					
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(checkboxvalue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rs_doc_num));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(l_rej_image_str));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(rs_doc_type_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rs_doc_date));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rs_bill_from_date));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rs_bill_to_date));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rs_bill_amount));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(l_image_str));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(l_img_vw_dtl_str));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(j));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rs_credit_auth_ref));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rs_destCode));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(j));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(l_srl_no));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(l_event_type));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(l_approval_status));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(j));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rs_settleInd));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(j));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rs_blng_grp_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rs_cust_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(j));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rs_visit_date));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(j));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(l_srl_trans_no));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(j));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(l_approval_trans_status));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(j));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(l_event_trans_type));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(l_trans_ref_no));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(l_rev_event_type));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(l_rev_approval_status));
            _bw.write(_wl_block81Bytes, _wl_block81);

					String id="hidethis"+rs_doc_num;

					
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(hideTable));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

						while(rs.next())
				        {
						  
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rs.getString(22)));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(rs.getString(23)));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(rs.getString(11)));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(rs.getString(12)));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rs.getString(16)));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rs.getString(17)));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rs.getString(18)));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(rs.getString(15)));
            _bw.write(_wl_block96Bytes, _wl_block96);

						}

						try {
							if (rs != null) {
								rs.close();
								System.out.println(" ::: Closing rs :::"); 	
							}
						}
						catch(Exception exp) {
							System.out.println(" Error in closing rs ::: "+exp.getMessage());	
						}
						
            _bw.write(_wl_block97Bytes, _wl_block97);


				if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){

				}
				prevSubGroup = currentSubGroup; 
				System.out.println("prevSubGroup...."+prevSubGroup);
				l_event_type = "";l_srl_no = 0; l_case_no = ""; l_approval_status = ""; l_claim_no = "";
				l_event_trans_type = "";l_srl_trans_no = 0;l_case_trans_no = "";l_approval_trans_status ="";
			}
			if ((j>0) && (j==billDetailsRowCount)){
				
            _bw.write(_wl_block98Bytes, _wl_block98);

			}
			
		
            _bw.write(_wl_block99Bytes, _wl_block99);


	}
	if(arrRow!=null) arrRow.clear();
	if(arrCol!=null) arrCol.clear();
	if(resultsQry!=null) resultsQry.clear();
		
	}
	catch(Exception e1)
	{
	  System.out.println("(MediMembershipClaimsResult.jsp:Exception) "+e1);
	  e1.printStackTrace(System.err);
	}
	finally
	{
	  ConnectionManager.returnConnection(dbConn);
	  ConnectionManager.returnConnection(conn);
	}

            _bw.write(_wl_block100Bytes, _wl_block100);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDateTime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_NO.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_DOC_TYPE.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_DATE.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.billfromdate.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.billtodate.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.History.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DOC_REF.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBDocLineNo.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ServiceCode.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ServiceDescription.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISCOUNT_AMT.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NET_CHARGE.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_DATE.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }
}
