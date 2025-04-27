package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHQueryRender;
import eXH.XHDBAdapter;
import eXH.XHUtil;

public final class __medimembershipeligibilityresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/MediMembershipEligibilityResult.jsp", 1743587005620L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
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

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\t\t      \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t    \n\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/jquery-3.6.3.js\' language=\'javascript\'></script>\n\n<script language=\"javascript\">\n\nfunction funSubmit()\n{\n\tparent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.action = \'../../eXH/jsp/MediMembershipEligibilityResult.jsp\';\n\tparent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.target=\"resultFrame\";\n\tparent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.submit();\n}\n\nfunction funAction(typ)\n{  \n\tparent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.action_type.value = typ;\n\tfunSubmit();\n}\n\n//function callForOrderBy\nfunction callForOrderBy(obj,order)\n{\t\n\tif(order == \'A\') obj = obj + \' asc\';\n\tif(order == \'D\') obj = obj + \' desc\';\n\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\n\tthis.document.forms[0].action_type.value = \"\";\n\tthis.document.forms[0].action = \"../../eXH/jsp/MediMembershipEligibilityResult.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n}\n\nasync function checkEligibility(obj)\n{\t\n\t//alert(obj);\n\t//var checkType = \"\";\n\t\n\t//var checkTypeButtons = document.getElementsByName(\'CheckType\');\n\t\n\t//for(var i = 0; i < checkTypeButtons.length; i++){\n\t//\tif(checkTypeButtons[i].checked){\n\t\t//\tcheckType = checkTypeButtons[i].value;\n\t\t//}\n\t/*}\n\n\tvar patient_name = obj.getAttribute(\'pat_name\');\n\tvar patient_id = obj.getAttribute(\'patient_id\');\n\tvar encounterId = obj.getAttribute(\'encounterId\');\n\tvar pat_cls_episode = obj.getAttribute(\'patient_class_episode\');\n\tvar episode_id = obj.getAttribute(\'episode_id\');\n\n\tvar pat_dob = obj.getAttribute(\'pat_dob\');\n\tvar national_id = obj.getAttribute(\'national_id\');\n\tvar sex = obj.getAttribute(\'sex\');\n\tvar visit_adm_dt_time = obj.getAttribute(\'visit_adm_dt_time\');\n\tvar locationType = obj.getAttribute(\'location_type\');\n\tvar locationCode = obj.getAttribute(\'location_code\');\n\tvar service_code = obj.getAttribute(\'service_code\');\n\tvar speciality_code = obj.getAttribute(\'speciality_code\');\n\tvar cust_code = obj.getAttribute(\'cust_code\');\n\tvar facilityId = obj.getAttribute(\'facility_id\');\n\tvar firstName = obj.getAttribute(\'first_name\');\n\tvar secondName = obj.getAttribute(\'second_name\');\n\tvar initial = obj.getAttribute(\'initial\');\n\tvar familyName=obj.getAttribute(\'familyName\');\n\tvar membership_no = obj.getAttribute(\'membership_no\');\n\n\tvar wca_no = obj.getAttribute(\'wca_number\');\n\tvar dependant_number = obj.getAttribute(\'dependant_number\');\n\tvar dependant_relationship = obj.getAttribute(\'dependant_relationship\');\n\tvar destination_code = obj.getAttribute(\'destCode\');\n\n\tvar visit_id = obj.getAttribute(\'visitId\');\n\tvar episode_type = obj.getAttribute(\'episodeType\');\n\n\n\tvar request_status = obj.getAttribute(\'request_status\');\n\tvar auth_num = obj.getAttribute(\'auth_num\');\n\tvar approval_status = obj.getAttribute(\'approval_status\');\n\tvar warn_code = obj.getAttribute(\'warn_code\');\n\tvar warn_desc = obj.getAttribute(\'warn_desc\');\n*/\n    var admission_type = document.forms[0].admission_type.value;\n\t//var destination_code = document.forms[0].dest_code.value;\n\n    var checkType = \"\";\n\tvar patientData=\"\";\n\tvar checkedValue = null; \n\tvar checkBoxes = document.getElementsByName(\'checkbox\');\n\tvar selectedIndex = 0;\n\tvar count = 0;\n\n\tvar authnumname = \"\";\n\tvar destcodename = \"\";\n\t\n\tvar authnum = \"\";\n\tvar destcode = \"\";\n\n\t\n\tvar event_type = \"\";\n\tvar approval_status = \"\";\n\n\tvar national_id = \"\";\n\t//var destcode = \"\";\n\n\tvar responseMessage = \"\";\n\t\n\tfor(var i = 0; i < checkBoxes.length; i++){\n\t\tif(checkBoxes[i].checked){\n\t\t\tcheckedValue = checkBoxes[i].value;\n\t\t\tselectedIndex = i;\n\t\t\tcount++;\n\t\t}\n\t}\n\tvar national_id_obj = eval (\"document.PAYER_CHECK_ELIGIBILITY_FORM.national_id\"+selectedIndex);\n\tvar destination_code_obj = eval (\"document.PAYER_CHECK_ELIGIBILITY_FORM.dest_code\"+selectedIndex);\n\n\tnational_id = national_id_obj.value;\n\tdestcode = destination_code_obj.value;\n\n\tvar event_type_obj = eval (\"document.PAYER_CHECK_ELIGIBILITY_FORM.event_type\"+selectedIndex);\n\tvar approval_status_obj = eval (\"document.PAYER_CHECK_ELIGIBILITY_FORM.approval_status\"+selectedIndex);\n\n\tevent_type = event_type_obj.value;\n\tapproval_status = approval_status_obj.value;\n    \n    if(count == 0 || checkedValue == null)\n\t{\n         alert(\"APP-XH0071 Please select at least one Patient.\");\n\t\t return;\n\t}\n\tif(count > 1)\n\t{\n         alert(\"APP-XH0072 More than one Patient cannot be processed, please select only one Patient.\");\n\t\t return;\n\t}\n   /*if(!((event_type != \"IEC\") && (event_type != \"UEC\"))){\n\t\tif(!(approval_status != \"A\"))\n\t\t{ \n\t\t\talert(\"APP-XH0069 Eligiblity Check Has been Successfully done for this Patient.\");\n\t\t\treturn;\n\t\t}\n\t}*/\n\tif(!(obj != \"IDC\")){\n\t\tif(!(national_id != null && national_id != \"\" && national_id != \" \"))\n\t\t{ \n\t\t\talert(\"APP-XH0073 National ID number is not available for this Patient, Kindly update the National ID number in the Change Patient Details, before you proceed with ID Check.\");\n\t\t\treturn;\n\t\t}\n\t}\n\n   var settlement_ind_obj = eval (\"document.PAYER_CHECK_ELIGIBILITY_FORM.settlement_ind\"+selectedIndex);\n   var settlement_ind = settlement_ind_obj.value;\n\n   var billing_grp_obj = eval (\"document.PAYER_CHECK_ELIGIBILITY_FORM.billing_grp\"+selectedIndex);\n   var billing_grp = billing_grp_obj.value;\n\n   var cust_code_obj = eval (\"document.PAYER_CHECK_ELIGIBILITY_FORM.cust_code\"+selectedIndex);\n   var cust_code = cust_code_obj.value;\n\n   var visit_date_obj = eval (\"document.PAYER_CHECK_ELIGIBILITY_FORM.this_date\"+selectedIndex);\n   var visit_date = visit_date_obj.value;\n\n   var destAlertMessage = \"\";\n   var eventName = \"\";\n\n   if (obj == \"IDC\")\n\t\t eventName = \"ID Check\";\n\n   if (obj == \"FAM\")\n\t\t eventName = \"FAM Check\";\n\n   if (obj == \"UEC\")\n\t\t eventName = \"Un-Insured Eligibility Check\";\n\n   if (obj == \"IEC\")\n\t\t eventName = \"Insured Eligibility Check\";\n\n\tif(!(destcode != null && destcode != \"\" && destcode != \" \"))\n\t{ \n\t\tif (settlement_ind == \"C\")\n\t\t{\n\t\t\tdestAlertMessage = \"APP-XH0074 Billing Group \"+billing_grp+\" is not mapped to Destination Code pertaining to process \"+eventName+\" dated \"+visit_date;\n\t\t}\n\t\tif ((settlement_ind == \"X\") || (settlement_ind == \"R\"))\n\t\t{\n\t\t\tdestAlertMessage = \"APP-XH0074 Customer Code \"+cust_code+\" is not mapped to Destination Code pertaining to process \"+eventName+\" dated \"+visit_date;\n\t\t}\n\t\talert(destAlertMessage);\n\t\treturn;\n\t}\n    checkedValue = checkedValue.replace(\"#checkType#\",obj);\n\tcheckedValue = checkedValue.replace(\"#admission_type#\",admission_type);\n\n\tvar dialogHeight = \"55vh\";    // have to remove \n\tvar dialogWidth  = \"75vw\";\n\tvar dialogTop    = \"130\";\n\tvar title=\"Patient Eligibility Check \";\n\ttitle=encodeURIComponent(title);\n    checkedValue = checkedValue.replace(\"#title#\",title);\n\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\t/* var params= \"title=\"+title+\"&pid=\"+patient_id+\"&eid=\"+encounter_id+\"&nuc=\"+nursing_unit_code+\"&pst=\"+pStartDate+\"&ped=\"+pEndDate+\"&pn=\"+pat_name+\"&pdob=\"+pat_dob+\"&ni=\"+national_id+\"&pcn=\"+pat_contactno+\"&mcn=\"+membership_no+\"&phn=\"+policy_holder_name+\"&pln=\"+policy_number+\"&pdc=\"+provider_code+\"&sc=\"+service_code+\"&pyc=\"+payer_code+\"&ptc=\"+policy_type_code+\"&bgi=\"+billing_group_id+\"&pgd=\"+p_g_desc+\"&prio=\"+priority+\"&pyname=\"+payerName+\"&vdt=\"+visit_adm_date_time+\"&eff=\"+effectiveFrom+\"&eft=\"+effectiveTo+\"&bgd=\"+billing_group_desc+\"&ofd=\"+operating_facility_id+\"&epid=\"+episode_id+\"&vsid=\"+visit_id;  */\n     \n\tvar params=checkedValue; /*\"title=\"+title+\"&pname=\"+patient_name+\"&pcepisode=\"+pat_cls_episode+\"&epid=\"+episode_id+\"&pdob=\"+pat_dob+\"&nid=\"+national_id+\"&sex=\"+sex+\"&vadmitdt=\"+visit_adm_dt_time+\"&locType=\"+locationType+\"&loccd=\"+locationCode+\"&fcid=\"+facilityId+\"&fname=\"+firstName+\"&sname=\"+secondName+\"&initial=\"+initial+\"&familyName=\"+familyName+\"&memno=\"+membership_no+\"&wca=\"+wca_no+\"&depNum=\"+dependant_number+\"&depRel=\"+dependant_relationship+\"&checkType=\"+checkType+\"&pid=\"+patient_id+\"&scode=\"+service_code+\"&encounterId=\"+encounterId+\"&speciality_code=\"+speciality_code+\"&destCode=\"+destination_code+\"&custCode=\"+cust_code+\"&admission_type=\"+admission_type+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&request_status=\"+request_status+\"&auth_num=\"+auth_num+\"&approval_status=\"+approval_status+\"&warn_code=\"+warn_code+\"&warn_desc=\"+warn_desc; \n\t*/\t\n\n\tvar arguments = new Array();\n\tvar url = \"../../eXH/jsp/MediClaimsEligibilityPopUp.jsp?\" +params;\n\t\n\tvar retVal = await window.showModalDialog(url,arguments,features);\n\tparent.resultFrame.location.reload();\n}\n\nfunction includeBoxChecked() {\n\n\tif (document.forms[0].includeMastercheckbox.checked == true) {\n\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = true;\n\t\t\t}\n\t\t} else if (document.forms[0].gatewayservers.length == undefined) {\n\t\t\tdocument.forms[0].includeCheckbox.checked = true;\n\t\t}\n\t}\n\telse {\n\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = false;\n\t\t\t}\n\t\t} else if (document.forms[0].includeCheckbox.length == undefined) {\n\t\t\tdocument.forms[0].includeCheckbox.checked = false;\n\t\t}\n\t}\n\treturn true;\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\t\n\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" >\n<form name=\"PAYER_CHECK_ELIGIBILITY_FORM\" id=\"PAYER_CHECK_ELIGIBILITY_FORM\" method=\"POST\" action=\'\'  >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\t\t    <input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\t\t     \n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" >\t\t\t\n\t\t\t<input type=\'hidden\' name=\'patient_class_episode\' id=\'patient_class_episode\' value=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n\t\t\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">\n\t\t \t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t\t\t<input type=\'hidden\' name=\'admission_from_dt\' id=\'admission_from_dt\' value=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n\t\t\t<input type=\'hidden\' name=\'admission_to_dt\' id=\'admission_to_dt\' value=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'admission_type\' id=\'admission_type\' value=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n\n\t\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'pat_name\' id=\'pat_name\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'pat_dob\' id=\'pat_dob\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'national_id\' id=\'national_id\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'sex\' id=\'sex\' value=\"\"> \n\t\t\t \n\t\t\t<input type=\'hidden\' name=\'visit_adm_dt_time\' id=\'visit_adm_dt_time\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\"\">\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'location_code\' id=\'location_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'cust_code\' id=\'cust_code\' value=\"\">\n\t\t\t \n\t\t   <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'second_name\' id=\'second_name\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'initial\' id=\'initial\' value=\"\">\n\t\t\t   \n\t\t   <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'second_name\' id=\'second_name\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'initial\' id=\'initial\' value=\"\">\n\n\t\t   <input type=\'hidden\' name=\'membership_no\' id=\'membership_no\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'wca_number\' id=\'wca_number\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'dependant_number\' id=\'dependant_number\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'dependant_relationship\' id=\'dependant_relationship\' value=\"\">\n\n\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t\t<script>\n\t\t\t//\tparent.f_query_footer.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\talert(\'APP-002415 Query caused no records to be retrieved\');\n\t\t\t\thistory.go(-1);\n\t\t\t\t/*var function_id=parent.document.getElementById(\"function_id\").value;\n\t\t\t\tparent.f_query_add_mod.location.href=\'../../eXH/jsp/ViewEventsOutboundHeader.jsp?function_id=\'+function_id;\n\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\t   */\n\t\t\t\tparent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n\n\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\n\t<fieldset>\n\t\t<table cellspacing=0 cellpadding=5 width=\'100%\' align=right border=0>\n\t\t\t<tr>\n\t\t\t\t<td>\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td>\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\t\t\n\t\t\t<tr>\n\t\t\t\t<td align=center>\n\t\t       \n\t\t\t\t\t<!--<input type=\"radio\" name=\"CheckType\" id=\"CheckType\" id=\"CheckType\" value=\"IDC\" checked> ID Check\t\t\t\t\t\n\t\t\t\t\t<input type=\"radio\" name=\"CheckType\" id=\"CheckType\" id=\"CheckType\" value=\"FAM\" > Fam Check\n\t\t\t\t\t<input type=\"radio\" name=\"CheckType\" id=\"CheckType\" id=\"CheckType\" value=\"UEC\"> Uninsured Eligibility Check\n\t\t\t\t\t<input type=\"radio\" name=\"CheckType\" id=\"CheckType\" id=\"CheckType\" value=\"IEC\"> Eligibility Check\n\t\t\t\t\t-->\n\t\t\t\t</td>\n\t\t\t\t<td align=right>\n\t\t\t\t\t<!-- <input class=\'BUTTON\' type=\"button\"  ID=\"eligibility_check\" name=eligibility_check value=\'Eligibility Check\' onClick=\"eligibilityCheck()\">\t -->\t\n\t\t\t\t</td>\n\t\t\t</tr>\t\t\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t</td>\n\t\t\t</tr>\t\t\n\t\t</table>\t\n\t</fieldset>\n\t\n\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=center border=1>\n\t<tr>\n\t\t<td colspan=\"27\" class=\"COLUMNHEADER\" align=\'center\'>Membership Eligibility Check</td>\n\t</tr>\n\t<tr>\t   \n\t\t<td align=\"right\" class=\"CAGROUP\" > \n\t\t <input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'ID Check\' onClick=\"checkEligibility(\'IDC\')\">\n\t\t        <input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'FAM Check\' onClick=\"checkEligibility(\'FAM\')\">\n\t\t        <input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'UnInsured Check\' onClick=\"checkEligibility(\'UEC\')\">\n\t\t        <input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'Insured Check\' onClick=\"checkEligibility(\'IEC\')\">\n\t\t</td>\n         <td align=\"right\" class=\"CAGROUP\" > \n\t\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</A>\n\t\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</A>\n\t\t</td>\n\t</tr>\n\t</table>\n\n\t<div id=\"left_child\" style=\"display:inline;\">\n\t<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' border=1 align=center>\t\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font>\n\t\t\t</td>\n\n\t\t\t<td class=\'COLUMNHEADER\' width=\'16%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font>\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'>\n\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font>\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'9%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font>\n\t\t\t</td>\n\t\t\t\n\t\t\t<!--\n\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t<font color=white>Location Type </font>\n\t\t\t</td>\n\t\t\t-->\n\n\t\t\t<td class=\'COLUMNHEADER\' width=\'9%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'12%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'12%\'>\n\t\t\t\t<font color=white>Eligiblity Type</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" </font>\n\t\t\t</td>\n\n\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'>\n\t\t\t</td>\n\t\t\t\n\t\t <!--\t<td class=\'COLUMNHEADER\' width=\'3%\' align=\"center\">\n\t\t\t\t<input type=\"checkbox\" onchange=\"includeBoxChecked()\" onclick=\"includeBoxChecked()\" id=\"includeMastercheckbox\" name=\"includeMastercheckbox\" id=\"includeMastercheckbox\">\n\t\t\t</td>  -->\n\t\t\t\t\t\t\n\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\t\t<tr>\n\t\t<td  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" align=\"left\" >\n\t\t ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n         <font size=2>&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t <input type=\'hidden\' name=\'p_patientId\' id=\'p_patientId\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n\t\t</td>\n\n\t\t<td ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" align=\"left\">\n\t\t\t ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<font size=2>&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<input type=\'hidden\' name=\'p_patientName\' id=\'p_patientName\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\n\t\t\t<input type=\'hidden\' name=\'p_firstName\' id=\'p_firstName\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t\t\t<input type=\'hidden\' name=\'p_secondName\' id=\'p_secondName\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t\t\t<input type=\'hidden\' name=\'p_intial\' id=\'p_intial\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t\t\t<input type=\'hidden\' name=\'p_dob\' id=\'p_dob\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t\t\t<input type=\'hidden\' name=\'p_familyName\' id=\'p_familyName\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n    \t\t ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t    <font size=2>&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<input type=\'hidden\' name=\'p_episodeId\' id=\'p_episodeId\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t\t</td>\n\t\t\n\t\t<td ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t<font size=2>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t <input type=\'hidden\' name=\'p_sex\' id=\'p_sex\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n\t\t</td>\n\t\t<td ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" align=\"left\">\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<input type=\'hidden\' name=\'p_nationalId\' id=\'p_nationalId\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<input type=\'hidden\' name=\'p_patientClass\' id=\'p_patientClass\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<input type=\'hidden\' name=\'p_visitAdmissionDate\' id=\'p_visitAdmissionDate\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t</td>\n\t\t<!--\n\t\t<td ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<input type=\'hidden\' name=\'p_locationType\' id=\'p_locationType\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t\t</td>\n\t\t-->\n\t\t<td ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<input type=\'hidden\' name=\'p_serviceCode\' id=\'p_serviceCode\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t<input type=\'hidden\' name=\'p_specialityCode\' id=\'p_specialityCode\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t<input type=\'hidden\' name=\'p_custCode\' id=\'p_custCode\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n\t\t\t<input type=\'hidden\' name=\'p_destCode\' id=\'p_destCode\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" align=\"left\">\n\t\t\t<font size=2>&nbsp;";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t<input type=\'hidden\' name=\'p_event_type\' id=\'p_event_type\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t\t</td>\n\t  <!-- \t<td  align=\"center\">\t\t\t\n\t\t\t <input type=\"checkbox\"  id=\"includeCheckbox\" name=\"includeCheckbox\" id=\"includeCheckbox\">\n\t\t</td>  -->\n\n\t\t<td  ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" align=\"center\">\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t <font size=2>&nbsp;";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t<input type=\'hidden\' name=\'dest_code";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'dest_code";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t    <input type=\'hidden\' name=\'national_id";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\'national_id";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t\t<input type=\'hidden\' name=\'event_type";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'event_type";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t\t<input type=\'hidden\' name=\'approval_status";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' id=\'approval_status";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t\t<input type=\'hidden\' name=\'settlement_ind";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'settlement_ind";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t\t<input type=\'hidden\' name=\'billing_grp";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'billing_grp";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t\t\t<input type=\'hidden\' name=\'cust_code";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'cust_code";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t\t\t<input type=\'hidden\' name=\'this_date";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'this_date";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t\t</td> \n        ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t<td ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" align=\"center\" >\n          <input type=\'checkbox\'  name=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' id=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' > \n\t\t\t\n\n\t\t</td>\n\t\t </tr>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\n</table>\n<input type=\'hidden\' name=\'dest_code\' id=\'dest_code\' value=";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

	public String getDestinationCode(String settlementInd, String custCode, String billGrpId)
	{

		Connection dbConn = null;
		ResultSet rsdest=null;
		PreparedStatement pstmt = null;

		String query = "", l_where_values = "", l_destination_code = "", l_app_msg = "";

		l_app_msg = " ::: Inside getDestinationCode ::: ";
		System.out.println(l_app_msg);
		
		try
		{
			dbConn =  ConnectionManager.getConnection();

			if (settlementInd.equals("X") || settlementInd.equals("R"))
			{	
				l_app_msg = " ::: Inside BL_CUST_DEST_MST ::: ";
				System.out.println(l_app_msg);	

				query = "select DESTINATION_CODE_SAP from BL_CUST_DEST_MST "
							+" where "
							+"	 CUST_CODE = ? and trunc(SYSDATE) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE) ";

				l_where_values = custCode;

			}
			else if (settlementInd.equals("C"))
			{
				l_app_msg = " ::: Inside BL_BLNG_GRP_DEST_MST ::: ";
				System.out.println(l_app_msg);	

				query = "select DESTINATION_CODE_SAP from BL_BLNG_GRP_DEST_MST "
							+" where "
							+"	 BLNG_GRP_ID = ? and trunc(SYSDATE) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE) ";

				l_where_values = billGrpId;
			}

			l_app_msg = " ::: Inside GETDESTINATIONCODE Query ::: "+query+ " ::: L_WHERE_VALUES ::: "+l_where_values;
			System.out.println(l_app_msg);
			
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_where_values);
			rsdest = pstmt.executeQuery();
			while(rsdest.next())
			{
			   l_destination_code = rsdest.getString("DESTINATION_CODE_SAP");
			}
			
		}
		catch(Exception e)
		{
			l_destination_code = "Error in "+ l_app_msg + " : " +  e.getMessage();

			return l_destination_code;
		}
		finally
		{			
			XHUtil.closeDBResources(rsdest, pstmt, dbConn);
		}	
		
		l_app_msg = " ::: L_DESTINATION_CODE ::: "+l_destination_code;
		System.out.println(l_app_msg);

		return l_destination_code;

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String order = "";
	String orderBy = "";
	String action_type=null;
	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null ;
	String rs_patientId="",rs_episodeId = "",rs_encounter_id = "", rs_billNumber = "", rs_sex = "", rs_nationalId = "", rs_visitAdmissionDate = "", rs_patientName = "", rs_encounterId = "", rs_episodeType = "", rs_visitId = "";
	String rs_memberId = "", rs_serviceCode = "", rs_specialityCode = "", rs_custCode = "", rs_patientClass = "", rs_locationType = "", rs_destCode = "", rs_billGrpId = "", rs_settleInd = "", rs_thisDate = "";
	String rs_firstName = "", rs_secondName = "", rs_intial = "", rs_dob = "",rs_familyName="", rs_event_type = "" ,rs_event_type_desc = "";

	String checkboxvalue ="",checkboxname ="";

	HttpSession httpSession = request.getSession(false);
	String customer_id = XHDBAdapter.checkNull(request.getParameter("customer_id"));
	String patient_id= XHDBAdapter.checkNull(request.getParameter("patient_id"));
	String patient_class_episode = XHDBAdapter.checkNull(request.getParameter("patient_class_episode"));
	String episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
	String customer_group = XHDBAdapter.checkNull(request.getParameter("customer_group"));
	String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
	String encounter_id = XHDBAdapter.checkNull(request.getParameter("encounter_id"));

	String admission_from_dt = XHDBAdapter.checkNull(request.getParameter("admission_from_dt"));

	String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

	String rs_approval_status = "", rs_approval_status_desc= "";

	if(admission_from_dt!="" && admission_from_dt!=null)
	{
	   admission_from_dt = admission_from_dt+ " 00:00:00";
	}

	String admission_to_dt = XHDBAdapter.checkNull(request.getParameter("admission_to_dt"));
	if(admission_to_dt!="" && admission_to_dt!=null)
	{
	   admission_to_dt =admission_to_dt + " 23:59:59";
	}

	//String patient_class_orderby = XHDBAdapter.checkNull(request.getParameter("patient_class_orderby"));
	String eligibility_action_type = XHDBAdapter.checkNull(request.getParameter("eligibility_action_type"));
	String eligibility_status_type = XHDBAdapter.checkNull(request.getParameter("eligibility_status_type"));

	String admission_type = XHDBAdapter.checkNull(request.getParameter("admission_type"));

	String dest_code = "";

	if(isDebugYN.equals("Y")){
	System.out.println("MediClaimsEligibilityPopUp.jsp:::customer_id....."+customer_id);
	System.out.println("MediClaimsEligibilityPopUp.jsp:::patient_id....."+patient_id);
	System.out.println("MediClaimsEligibilityPopUp.jsp:::admission_from_dt....."+admission_from_dt+" admission_to_dt :::: "+admission_to_dt );
	System.out.println("MediClaimsEligibilityPopUp.jsp:::admission_type....."+admission_type +" eligibility_status_type ::: "+eligibility_status_type);
	System.out.println("MediClaimsEligibilityPopUp.jsp:::EpisodeID....."+episode_id +" EpisodeType ::: "+episode_type);
    }
	/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

	boolean  boolToggle = true;
	String strTDClass = "";
	String whereClause = "";
	int totalRecords=0;

	Connection dbConn = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;

	try
	{ 
		conn = ConnectionManager.getConnection(request);

				
		if("1".equalsIgnoreCase(admission_type))
		{
			
			if(isDebugYN.equals("Y")){
				System.out.println("preadmission.. patient id..."+patient_id);
			}
                        whereClause = " where NVL(TRANS_TYPE,'ELCREQ') = 'ELCREQ' ";
			if(patient_id != null && patient_id != "" && patient_id != " ")
			{
				whereClause = whereClause + " AND PATIENT_ID =  '#patient_id' ";
			}
			if(customer_group != null && customer_group != "" && customer_group != " ")
			{
				whereClause = whereClause + " AND CUST_GROUP_CODE =  '#customer_group' ";
			}
			if(customer_id != null && customer_id != "" && customer_id != " ")
			{
				whereClause = whereClause + " AND CUST_CODE =  '#customer_id' ";  
			}
			if(eligibility_status_type != null && eligibility_status_type != "" && eligibility_status_type != " ")
			{
				whereClause = whereClause + " AND APPROVAL_STATUS = '#eligibility_status_type' ";  
			}
			request.setAttribute(XHQueryRender.strQueryId,"PREADMISSIONELIGIBILITYCHECK");	
		}
		else
		{
			whereClause = " where NVL(TRANS_TYPE,'ELCREQ') = 'ELCREQ' ";
			if(isDebugYN.equals("Y")){
				System.out.println("on admission.. patient id..."+patient_id);
			}

			if(patient_id != null && patient_id != "" && patient_id != " ")
			{
				whereClause = whereClause + " AND PATIENT_ID =  '#patient_id' ";
			}
			if(customer_id != null && customer_id != "" && customer_id != " ")
			{
				whereClause = whereClause + " AND CUST_CODE =  '#customer_id' ";
			}
			if(customer_group != null && customer_group != "" && customer_group != " ")
			{
				whereClause = whereClause + " AND CUST_GROUP_CODE =  '#customer_group' ";
			}
			if(episode_id != null && episode_id != "" && episode_id != " ")
			{
				whereClause = whereClause + " AND episode_id=  '#episode_id' ";
			}
			
			if(admission_from_dt!="" && admission_from_dt!=null && admission_to_dt!="" && admission_to_dt!=null){
				
			//whereClause = whereClause + " And TO_Date(VISIT_ADM_DATE_TIME,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('#admission_from_dt','DD/MM/YYYY HH24:MI:SS') AND TO_Date('#admission_to_dt', 'DD/MM/YYYY HH24:MI:SS')";

			whereClause = whereClause + " And TO_Date(VISIT_ADM_DATE_TIME,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+admission_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+admission_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
			}
			
			if(eligibility_status_type != null && eligibility_status_type != "" && eligibility_status_type != " ")
			{
				whereClause = whereClause + " AND APPROVAL_STATUS =  '#eligibility_status_type' ";  
			}
			/*if(patient_class_orderby != null && patient_class_orderby != "" && patient_class_orderby != " ")
			{
				whereClause = whereClause + " Order by "+patient_class_orderby;
			}*/
			request.setAttribute(XHQueryRender.strQueryId,"ONADMISSIONELIGIBILITYCHECK");
		}
		
		if(isDebugYN.equals("Y")){
			System.out.println("whereClause....."+whereClause);
		}
		request.setAttribute(XHQueryRender.col,"43"); 
		request.setAttribute(XHQueryRender.maxRec,"7");
		request.setAttribute(XHQueryRender.whereClause,whereClause);
		HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");	
		//String sqlQuery= XHQueryRender.sqlQuery;	
		//System.out.println("sqlQuery... "+sqlQuery);
		ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
		
		ArrayList arrCol = null;
		boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
		boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
		if(isDebugYN.equals("Y")) System.out.println("boolPrevious...."+String.valueOf(boolPrevious));
		if(isDebugYN.equals("Y")) System.out.println("boolNext...."+String.valueOf(boolNext));
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
			System.out.println("action_type in jsp...."+action_type);
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
            out.print( String.valueOf(admission_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);


		if(arrRow.size()==0)
		{
		
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		else
		{
			
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

		totalRecords=0;

		for (int j=0; j<arrRow.size();j++)
		{
            rs_event_type_desc = "";
			rs_approval_status_desc = "";

			arrCol = (ArrayList)arrRow.get(j);
			if (boolToggle == true)
			{
				strTDClass = "class='QRYEVEN'";
				boolToggle =  false;
			}
			else
			{
				strTDClass = "class='QRYODD'";
				boolToggle =  true;
			}

			rs_custCode = arrCol.get(12).equals("null")?"":(String)arrCol.get(12); 

			rs_billGrpId = arrCol.get(39).equals("null")?"":(String)arrCol.get(39);

			rs_settleInd = arrCol.get(40).equals("null")?"":(String)arrCol.get(40);

			if(isDebugYN.equals("Y")){
				System.out.println(" ::: RS_CUSTCODE ::: "+rs_custCode);
				System.out.println(" ::: RS_BILLGRPID ::: "+rs_billGrpId);
				System.out.println(" ::: RS_SETTLEIND ::: "+rs_settleInd);
			}

			rs_destCode = getDestinationCode(rs_settleInd, rs_custCode, rs_billGrpId );

			if(isDebugYN.equals("Y")){
				System.out.println(" ::: RS_DESTCODE ::: "+rs_destCode);
			}
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block32Bytes, _wl_block32);
 rs_patientId = arrCol.get(1).equals("null")?"":(String)arrCol.get(1); 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs_patientId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rs_patientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
 
			
				rs_patientName = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);
				
				rs_firstName = arrCol.get(13).equals("null")?"":(String)arrCol.get(13);
				rs_secondName = arrCol.get(14).equals("null")?"":(String)arrCol.get(14);
				rs_intial = arrCol.get(15).equals("null")?"":(String)arrCol.get(15);
				rs_dob = arrCol.get(16).equals("null")?"":(String)arrCol.get(16);
				rs_familyName = arrCol.get(20).equals("null")?"":(String)arrCol.get(20);
				rs_thisDate = arrCol.get(41).equals("null")?"":(String)arrCol.get(41);
		
			
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs_patientName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs_patientName));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rs_firstName));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rs_secondName));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rs_intial));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rs_dob));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rs_familyName));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
 rs_episodeId = arrCol.get(2).equals("null")?"":(String)arrCol.get(2); 
            _bw.write(_wl_block44Bytes, _wl_block44);
 rs_visitId = arrCol.get(27).equals("null")?"":(String)arrCol.get(27); 
            _bw.write(_wl_block44Bytes, _wl_block44);
 rs_episodeType = arrCol.get(26).equals("null")?"":(String)arrCol.get(26); 
            _bw.write(_wl_block45Bytes, _wl_block45);
 rs_encounter_id = arrCol.get(42).equals("null")?"":(String)arrCol.get(42); 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(rs_episodeId));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rs_episodeId));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
 rs_sex = arrCol.get(4).equals("null")?"":(String)arrCol.get(4); 
		     if(rs_sex.equals("F")){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}
			 if(rs_sex.equals("M")){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rs_sex));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block52Bytes, _wl_block52);
 rs_nationalId = arrCol.get(5).equals("null")?"":(String)arrCol.get(5); 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs_nationalId));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rs_nationalId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block52Bytes, _wl_block52);
 rs_patientClass = arrCol.get(6).equals("null")?"":(String)arrCol.get(6);
			 if(rs_patientClass.equals("OP")){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}
			 if(rs_patientClass.equals("IP")){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}
			 if(rs_patientClass.equals("EM")){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}
			 if(rs_patientClass.equals("DC")){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}
			 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rs_patientClass));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block52Bytes, _wl_block52);
 rs_visitAdmissionDate = arrCol.get(7).equals("null")?"":(String)arrCol.get(7); 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs_visitAdmissionDate));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rs_visitAdmissionDate));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
 rs_locationType = arrCol.get(8).equals("null")?"":(String)arrCol.get(8); 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs_locationType));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(rs_locationType));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
 rs_serviceCode = arrCol.get(10).equals("null")?"":(String)arrCol.get(10); 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(arrCol.get(23).equals("null")?"":(String)arrCol.get(23)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rs_serviceCode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
 rs_specialityCode = arrCol.get(11).equals("null")?"":(String)arrCol.get(11); 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(arrCol.get(22).equals("null")?"":(String)arrCol.get(22)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(rs_specialityCode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
 
				System.out.println(" ::: Customer Code ::: "+arrCol.size());
				rs_custCode = arrCol.get(12).equals("null")?"":(String)arrCol.get(12); 
				System.out.println(" ::: Customer Code ::: "+rs_custCode);
				
            _bw.write(_wl_block44Bytes, _wl_block44);
 
				//rs_destCode = arrCol.get(25).equals("null")?"":(String)arrCol.get(25); 
				//System.out.println(" ::: Destination Code ::: "+rs_destCode);
				
            _bw.write(_wl_block61Bytes, _wl_block61);
 
				rs_event_type = arrCol.get(34).equals("null")?"":(String)arrCol.get(34); 
				System.out.println(" ::: Event Type ::: "+rs_event_type);
                if(rs_event_type.equals("IDC"))rs_event_type_desc = "ID Check";
				if(rs_event_type.equals("FAM"))rs_event_type_desc = "FAM Check";
                if(rs_event_type.equals("UEC"))rs_event_type_desc = "UnInsured Check";
                if(rs_event_type.equals("IEC"))rs_event_type_desc = "Insured Check";

				
			
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(arrCol.get(24).equals("null")?"":(String)arrCol.get(24)));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rs_custCode));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rs_destCode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rs_event_type_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rs_event_type));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block67Bytes, _wl_block67);
 
				rs_approval_status = arrCol.get(30).equals("null")?"":(String)arrCol.get(30);

				if (rs_approval_status.equals("A"))
					rs_approval_status_desc = "Authorized";
				if (rs_approval_status.equals("R"))
					rs_approval_status_desc = "Rejected";
				if (rs_approval_status.equals("99"))
					rs_approval_status_desc = "Network Error - No response File";
				if (rs_approval_status.equals("F"))
					rs_approval_status_desc = "Failed";
				if (!(rs_approval_status.length()>0))
					rs_approval_status_desc = "";
			
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rs_approval_status_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(j));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rs_destCode));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rs_nationalId));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(j));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(arrCol.get(34)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(j));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rs_approval_status));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(j));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rs_settleInd));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rs_billGrpId));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(j));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rs_custCode));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(j));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rs_thisDate));
            _bw.write(_wl_block86Bytes, _wl_block86);

			checkboxvalue = "title=#title#&pname="+rs_patientName+"&pcepisode="+arrCol.get(2)+"&epid="+rs_episodeId+"&pdob="+rs_dob+"&nid="+rs_nationalId+"&sex="+rs_sex+"&vadmitdt="+rs_visitAdmissionDate+"&locType="+rs_locationType+"&loccd="+arrCol.get(9)+""+"&fcid="+arrCol.get(0)+""+"&fname="+rs_firstName+"&sname="+rs_secondName+"&initial="+rs_intial+"&familyName="+rs_familyName+"&memno="+arrCol.get(17)+"&wca="+arrCol.get(18)+"&depNum="+arrCol.get(19)+"&depRel="+arrCol.get(20)+"&checkType=#checkType#&pid="+rs_patientId+"&scode="+rs_serviceCode+"&encounterId="+rs_encounter_id+"&speciality_code="+rs_specialityCode+"&destCode="+rs_destCode+"&custCode="+rs_custCode+"&admission_type=#admission_type#&episode_type="+rs_episodeType+"&visit_id="+rs_visitId+"&request_status="+arrCol.get(28)+"&auth_num="+arrCol.get(29)+"&approval_status="+arrCol.get(30)+"&warn_code="+arrCol.get(31)+"&warn_desc="+arrCol.get(32)+"&event_type="+arrCol.get(34)+"&m_surname="+arrCol.get(37)+"&m_initial="+arrCol.get(38)+"&blng_grp_id="+rs_billGrpId+"&settlement_ind="+rs_settleInd;
			checkboxname = "secChk"+j;
		
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(checkboxname));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(checkboxname));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(checkboxvalue));
            _bw.write(_wl_block90Bytes, _wl_block90);

			totalRecords++;
		}
			}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

 }catch(Exception e1)
			{
			 out.println("(MediMembershipEligibilityResult.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rs_destCode));
            _bw.write(_wl_block92Bytes, _wl_block92);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NationalID.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDateTime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Transaction.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Outpatient.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.inpatient.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daycare.label", java.lang.String .class,"key"));
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
