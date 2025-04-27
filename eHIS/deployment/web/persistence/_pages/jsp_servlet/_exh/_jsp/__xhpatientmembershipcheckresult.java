package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import com.ehis.util.DateUtils;
import java.util.Map;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHQueryRender;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __xhpatientmembershipcheckresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/XHPatientMembershipCheckResult.jsp", 1729055896016L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\t\t      \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/ViewEvents.css\' type=\'text/css\'></link>\n\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n<script language=\"javascript\">\n\nfunction funSubmit()\n{\n\tparent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.action = \'../../eXH/jsp/XHPatientMembershipCheckResult.jsp\';\n\tparent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.target=\"resultFrame\";\n\tparent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.submit();\n}\n\nfunction funAction(typ)\n{  \n\tparent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.action_type.value = typ;\n\tfunSubmit();\n}\n\n//function callForOrderBy\nfunction callForOrderBy(obj,order)\n{\t\n\tif(order == \'A\') obj = obj + \' asc\';\n\tif(order == \'D\') obj = obj + \' desc\';\n\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\n\tthis.document.forms[0].action_type.value = \"\";\n\tthis.document.forms[0].action = \"../../eXH/jsp/XHPatientMembershipCheckResult.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n}\n\nasync function checkEligibility(obj)\n{\n\tvar patient_id = obj.getAttribute(\'patient_id\');\n\tvar encounter_id = obj.getAttribute(\'encounter_id\');\n\tvar pat_name = obj.getAttribute(\'pat_name\');\n\tvar national_id = obj.getAttribute(\'national_id\');\n\tvar pat_dob = obj.getAttribute(\'pat_dob\');\n\tvar pat_contactno = obj.getAttribute(\'pat_contactno\');\n\tvar membership_no = obj.getAttribute(\'membership_no\');\n\tvar policy_holder_name = obj.getAttribute(\'policy_holder_name\');\n\tvar policy_number = obj.getAttribute(\'policy_number\');\n\tvar pStartDate = obj.getAttribute(\'pStartDate\');\n\tvar pEndDate = obj.getAttribute(\'pEndDate\');\n\tvar provider_code = obj.getAttribute(\'provider_code\');\n\tvar service_code = obj.getAttribute(\'service_code\');\n\tvar payer_code = obj.getAttribute(\'payer_code\');\n\tvar policy_type_code = obj.getAttribute(\'policy_type_code\');\n\tvar billing_group_id = obj.getAttribute(\'billing_group_id\');\n\tvar p_g_desc = obj.getAttribute(\'p_g_desc\');\n\tvar priority = obj.getAttribute(\'priority\');\n\tvar payerName = obj.getAttribute(\'payerName\');\n\tvar nursing_unit_code = obj.getAttribute(\'nursing_unit_code\');\n\tvar visit_adm_date_time = obj.getAttribute(\'visit_adm_date_time\');\n\tvar effectiveFrom = obj.getAttribute(\'effectiveFrom\');\n\tvar effectiveTo = obj.getAttribute(\'effectiveTo\');\n\tvar billing_group_desc = obj.getAttribute(\'bl_g_desc\');\n\n\tvar policy_type_desc = obj.getAttribute(\'policy_type_desc\');\n\n\tvar operating_facility_id = obj.getAttribute(\'operating_facility_id\');\n\tvar episode_id = obj.getAttribute(\'episode_id\');\n\tvar visit_id = obj.getAttribute(\'visit_id\');\n\tvar episode_type = obj.getAttribute(\'eptype\');\n\tvar asno = obj.getAttribute(\'asno\');\n\tvar slid = obj.getAttribute(\'settlement_ind\');\n\n\tvar trans_id = obj.getAttribute(\'trans_id\');\n\tvar respDTime = obj.getAttribute(\'respDTime\');\n\tvar resp_code = obj.getAttribute(\'resp_code\');\n\tvar elg_code = obj.getAttribute(\'elgCode\');\n\tvar err_msg = obj.getAttribute(\'err_msg\');\n\tvar remarks = obj.getAttribute(\'remarks\');\n\tvar validity_type = obj.getAttribute(\'validity_type\');\n\tvar validity_until = obj.getAttribute(\'validity_until\');\n\n\n\tvar dialogHeight = \"65vh\";\t\t\t    \n\tvar dialogWidth  = \"55vw\";\n\tvar dialogTop    = \"0vh\";\n\tvar title=getLabel(\"eBL.ADD_PAYER.label\",\"BL\");\n\ttitle=encodeURIComponent(title);\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\tpolicy_type_desc = encodeURIComponent(policy_type_desc);\n\tbilling_group_desc = encodeURIComponent(billing_group_desc);\n\tpayerName = encodeURIComponent(payerName);\n\n\t/* var params= \"title=\"+title+\"&pid=\"+patient_id+\"&eid=\"+encounter_id+\"&nuc=\"+nursing_unit_code+\"&pst=\"+pStartDate+\"&ped=\"+pEndDate+\"&pn=\"+pat_name+\"&pdob=\"+pat_dob+\"&ni=\"+national_id+\"&pcn=\"+pat_contactno+\"&mcn=\"+membership_no+\"&phn=\"+policy_holder_name+\"&pln=\"+policy_number+\"&pdc=\"+provider_code+\"&sc=\"+service_code+\"&pyc=\"+payer_code+\"&ptc=\"+policy_type_code+\"&bgi=\"+billing_group_id+\"&pgd=\"+p_g_desc+\"&prio=\"+priority+\"&pyname=\"+payerName+\"&vdt=\"+visit_adm_date_time+\"&eff=\"+effectiveFrom+\"&eft=\"+effectiveTo+\"&bgd=\"+billing_group_desc+\"&ofd=\"+operating_facility_id+\"&epid=\"+episode_id+\"&vsid=\"+visit_id;  */\n\n\tvar params= \"title=\"+title+\"&pid=\"+patient_id+\"&eid=\"+encounter_id+\"&pst=\"+pStartDate+\"&ped=\"+pEndDate+\"&pn=\"+pat_name+\"&mcn=\"+membership_no+\"&phn=\"+policy_holder_name+\"&pln=\"+policy_number+\"&pdc=\"+provider_code+\"&sc=\"+service_code+\"&pyc=\"+payer_code+\"&ptc=\"+policy_type_code+\"&bgi=\"+billing_group_id+\"&pgd=\"+p_g_desc+\"&prio=\"+priority+\"&pyname=\"+payerName+\"&vdt=\"+visit_adm_date_time+\"&eff=\"+effectiveFrom+\"&eft=\"+effectiveTo+\"&bgd=\"+billing_group_desc+\"&ofd=\"+operating_facility_id+\"&epid=\"+episode_id+\"&vsid=\"+visit_id+\"&eptype=\"+episode_type+\"&asno=\"+asno+\"&slid=\"+slid+\"&ptydesc=\"+policy_type_desc+\"&transId=\"+trans_id+\"&respDTime=\"+respDTime+\"&respCode=\"+resp_code+\"&elgCode=\"+elg_code+\"&errMsg=\"+err_msg+\"&remarks=\"+remarks+\"&validityType=\"+validity_type+\"&validity_until=\"+validity_until;\n\t//var act = \'../../eXH/jsp/XHPatientMembershipEligibilityCheck.jsp\';\n\t\n\tvar arguments = new Array();\n\tvar url = \"../../eXH/jsp/XHPatientMembershipEligibilityCheck.jsp?\" +params;\n\t\n\tvar retVal = await window.showModalDialog(url,arguments,features);\n\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\t\n\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown=\'\' >\n<form name=\"PAYER_CHECK_ELIGIBILITY_FORM\" id=\"PAYER_CHECK_ELIGIBILITY_FORM\" method=\"POST\" action=\'\'  >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\t\t     <input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\n\t\t    <input type=\'hidden\' name=\'function_id\' id=\'function_id\' id=\"function_id\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>   \t\n\n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" >\n\t\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">\n\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t\t\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n\t\t\t<input type=\'hidden\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t\t\t<input type=\'hidden\' name=\'period_dt1\' id=\'period_dt1\' value=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n\t\t\t<input type=\'hidden\' name=\'period_dt2\' id=\'period_dt2\' value=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n\t\t\t<input type=\'hidden\' name=\'cust_id\' id=\'cust_id\' value=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">  \n\t\t\t<input type=\'hidden\' name=\'eligibility_check\' id=\'eligibility_check\' value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t<input type=\'hidden\' name=\'cust_group_id\' id=\'cust_group_id\' value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">  \n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'pat_name\' id=\'pat_name\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'pat_dob\' id=\'pat_dob\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'national_id\' id=\'national_id\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'pat_contactno\' id=\'pat_contactno\' value=\"\">\t\t  \n\t\t\t<input type=\'hidden\' name=\'membership_no\' id=\'membership_no\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'policy_holder_name\' id=\'policy_holder_name\' value=\"\">\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'provider_code\' id=\'provider_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'payer_code\' id=\'payer_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'settlement_ind\' id=\'settlement_ind\' value=\"\">\n\n\t\t\t<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'cust_name\' id=\'cust_name\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'visit_adm_date_time\' id=\'visit_adm_date_time\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'sex\' id=\'sex\' value=\"\">  \n\n\t\t   <input type=\'hidden\' name=\'bl_g_code\' id=\'bl_g_code\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'bl_g_desc\' id=\'bl_g_desc\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'p_g_desc\' id=\'p_g_desc\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'payerName\' id=\'payerName\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'priority\' id=\'priority\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'policy_number\' id=\'policy_number\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'policy_type_code\' id=\'policy_type_code\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'policy_type_desc\' id=\'policy_type_desc\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'pStartDate\' id=\'pStartDate\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'pEndDate\' id=\'pEndDate\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'effectiveFrom\' id=\'effectiveFrom\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'effectiveTo\' id=\'effectiveTo\' value=\"\">\n\n\t\t   <input type=\'hidden\' name=\'operating_facility_id\' id=\'operating_facility_id\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'eptype\' id=\'eptype\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'asno\' id=\'asno\' value=\"\">\n\n\t\t   <input type=\'hidden\' name=\'trans_id\' id=\'trans_id\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'respDTime\' id=\'respDTime\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'resp_code\' id=\'resp_code\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'elgCode\' id=\'elgCode\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'validity_type\' id=\'validity_type\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'err_msg\' id=\'err_msg\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'validity_until\' id=\'validity_until\' value=\"\">\n\t\t   <input type=\'hidden\' name=\'userId\' id=\'userId\' value=\"\">\n\n\t ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n\t\t\t<script>\n\t\t\t//\tparent.f_query_footer.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\talert(getMessage(\'XH1021\',\'XH\'));\n\t\t\t\thistory.go(-1);\n\t\t\t\t/*var function_id=parent.document.getElementById(\"function_id\").value;\n\t\t\t\tparent.f_query_add_mod.location.href=\'../../eXH/jsp/ViewEventsOutboundHeader.jsp?function_id=\'+function_id;\n\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\t   */\n\t\t\t\tparent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n\n\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\n\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=center border=1>\n\t<tr>\n\t\t<td colspan=\"27\" class=\"COLUMNHEADER\" align=\'center\'>Patient Eligibility Check</td>\n\t</tr>\n\t<tr>\t   \n\t\t<td align=\"right\" class=\"CAGROUP\" > \n\t\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</A>\n\t\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</A>\n\t\t</td>\n\t</tr>\n\t</table>\n\t<div id=\"left_child\" style=\"display:inline;\">\n\t<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' border=1 align=center>\t\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'12%\'>\n\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font>\n\t\t\t</td>\n\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\t\t<tr>\n\t\t<td  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" align=\"left\" >\n\n         <font size=1>&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t\t</td>\n\t\t<td ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" align=\"left\"> \n\t\t    <font size=1>&nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</td>\n\t\t<td ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" align=\"left\">\n\t\t\t<font size=1>&nbsp;";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t</td>\n\n\n\t\t<td ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" align=\"center\" >\n\t\t<img src=\"../../eXH/images/ViewDetails.gif\" alt=\"Check Details\" align=\'middle\' onClick=\"checkEligibility(this)\" patient_id=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' encounter_id=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' eptype=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' pat_name=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'  national_id=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' pat_dob=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' pat_contactno=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' membership_no=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' policy_holder_name=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' policy_number=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' pStartDate=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' pEndDate=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' effectiveFrom=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' effectiveTo=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' provider_code=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' service_code=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' payer_code=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' policy_type_code=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' policy_type_desc=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' billing_group_id=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' p_g_desc=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' priority=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' payerName=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' visit_adm_date_time=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' nursing_unit_code=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' bl_g_desc=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' operating_facility_id=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' episode_id=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' visit_id=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' asno=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' settlement_ind=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' trans_id=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' respDTime=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' resp_code=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' elgCode=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' validity_type=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' err_msg=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' remarks=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' validity_until=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' userId=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t<!--\n\t\t<input type=\"button\" value=\"Check Eligibility\" onClick=\'checkEligibility(this)\' patient_id=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>-->\n\t\t\n\t\t</b>\n\t\t</td>\n\t\t</tr>\n\n\t\t \n\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
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
HttpSession httpSession = request.getSession(false);
String facilityId = (String)httpSession.getValue("facility_id");
String patient_id= XHDBAdapter.checkNull(request.getParameter("patient_id"));
String encounter_id = XHDBAdapter.checkNull(request.getParameter("encounter_id"));
String practitioner_id = XHDBAdapter.checkNull(request.getParameter("practitioner_id"));
String patient_class = XHDBAdapter.checkNull(request.getParameter("patient_class"));
String nursing_unit_code = XHDBAdapter.checkNull(request.getParameter("nursing_unit_code"));
String period_dt1 = XHDBAdapter.checkNull(request.getParameter("period_dt1"));
if(period_dt1!="" && period_dt1!=null)
{
   period_dt1 = period_dt1+ " 00:00:00";
}

String period_dt2 = XHDBAdapter.checkNull(request.getParameter("period_dt2"));
if(period_dt2!="" && period_dt2!=null)
{
   period_dt2 =period_dt2 + " 23:59:59";
}
String cust_id = XHDBAdapter.checkNull(request.getParameter("cust_id"));
String function_id = XHDBAdapter.checkNull(request.getParameter("function_id"));

String eligibility_check = XHDBAdapter.checkNull(request.getParameter("eligibility_check"));

String cust_group_code = XHDBAdapter.checkNull(request.getParameter("cust_group_code"));

String application_id = XHDBAdapter.checkNull(request.getParameter("application_id"));

System.out.println("XHPatientMembershipCheckResult.jsp:::cust_group_code....."+cust_group_code);
System.out.println("XHPatientMembershipCheckResult.jsp:::eligibility_check....."+eligibility_check);
System.out.println("XHPatientMembershipCheckResult.jsp:::application_id....."+application_id);
System.out.println("XHPatientMembershipCheckResult.jsp:::period_dt1....."+period_dt1+" period_dt2 :::: "+period_dt2);

/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

action_type = XHDBAdapter.checkNull(request.getParameter("action_type"));

boolean  boolToggle = true;
String strTDClass = "";
String whereClause = "";
try
{ 
    conn = ConnectionManager.getConnection(request);

	/* whereClause = "WHERE a.cust_code = b.cust_code AND a.SETTLEMENT_IND = 'X' AND a.patient_id = c.patient_id and a.CUST_GROUP_CODE = d.CUST_GROUP_CODE and a.patient_id = e.patient_id and a.encounter_id = e.encounter_id AND E.SERVICE_CODE = F.SERVICE_CODE AND A.POLICY_TYPE_CODE = G.POLICY_TYPE_CODE AND A.BLNG_GRP_ID = H.BLNG_GRP_ID"; */

    
	/* WHERE OPERATING_FACILITY_ID = '02' 
and ENC_REGN_DATE_TIME BETWEEN TO_DATE('01/01/2017 00:00:00', 'DD/MM/YYYY HH24:MI:SS') AND TO_DATE('21/03/2017 23:59:59', 'DD/MM/YYYY HH24:MI:SS')
and int_response_code IN (SELECT TO_NUMBER(LIST_ELMT_VALUE) FROM SM_LIST_ITEM WHERE LIST_REF = 'HSELIGIFL' AND  MODULE_ID = 'XH')  */

    whereClause = "WHERE OPERATING_FACILITY_ID ='"+facilityId+"'";

    if( (period_dt1!="" && period_dt1!=null) && (period_dt2!="" && period_dt2!=null))
	{
	   whereClause=whereClause+" AND ENC_REGN_DATE_TIME BETWEEN TO_DATE('"+period_dt1+"', 'DD/MM/YYYY HH24:MI:SS') AND TO_DATE('"+period_dt2+"', 'DD/MM/YYYY HH24:MI:SS')";
	}

	if(application_id!=null && application_id!="")
	{ 
       whereClause=whereClause+" AND application_id = NVL('"+application_id+"',application_id)";
	}
	
	if(eligibility_check!=null && eligibility_check!="")
	{ 
       whereClause=whereClause+" AND INT_RESPONSE_CODE = NVL('"+eligibility_check+"',INT_RESPONSE_CODE)";
	}
	else
	{
		whereClause=whereClause+" AND int_response_code IN (SELECT TO_NUMBER(LIST_ELMT_VALUE) FROM SM_LIST_ITEM WHERE LIST_REF = 'HSELIGIFL' AND  MODULE_ID = 'XH')";
	}

    if(patient_id!=null && patient_id!="")
	{
	   whereClause=whereClause+" AND patient_id = NVL('#patient_id',patient_id)";
	}

	if(encounter_id!=null && encounter_id!="")
	{
	   whereClause=whereClause+" AND encounter_id = NVL('#encounter_id',encounter_id)";
	}

	if(cust_id!="" && cust_id!=null)
	{
	   whereClause=whereClause+" AND CUST_CODE = NVL('#cust_id',CUST_CODE)";
	}

	if(cust_group_code!="" && cust_group_code!=null)
	{
	   whereClause=whereClause+" AND CUST_GROUP_CODE = NVL('"+cust_group_code+"',CUST_GROUP_CODE)";
	}


	if(practitioner_id!="" && practitioner_id!=null)
	{
	   whereClause=whereClause+" AND NVL(attend_practitioner_id,admit_practitioner_id) = NVL('#practitioner_id',NVL(attend_practitioner_id,admit_practitioner_id))";
	}

	if(patient_class!="" && patient_class!=null)
	{
	   whereClause=whereClause+" AND EPISODE_TYPE = NVL(DECODE('#patient_class','IP','I','OP','O','EM','E','DC','D'),EPISODE_TYPE)";
	}

	if(nursing_unit_code!="" && nursing_unit_code!=null)
	{
	   whereClause=whereClause+" AND ASSIGN_CARE_LOCN_CODE = NVL('#nursing_unit_code',ASSIGN_CARE_LOCN_CODE)";
	}

	
	if(whereClause.length()<=7)
	{
		if(orderBy.equals("")||orderBy==null)
		{
					whereClause="";
		}
		else
		{
		   whereClause=whereClause+" order  By patient_id";	 
		}
	}
			
    else
	{
		 whereClause=whereClause +" order  By patient_id";
	}

	      
    System.out.println("whereClause....."+whereClause);
    request.setAttribute(XHQueryRender.strQueryId,"PAYERELIGIBILITYCHECK");		
	request.setAttribute(XHQueryRender.col,"47"); 
	request.setAttribute(XHQueryRender.maxRec,"10");
	request.setAttribute(XHQueryRender.whereClause,whereClause);
    HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	System.out.println("boolPrevious...."+boolPrevious);
	System.out.println("boolNext...."+boolNext);
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
      System.out.println("action_type in jsp...."+action_type);

	 Map<String,String> responseStatusMap = new HashMap<String,String>();
	 try															    
		{  
			String queryApplication = "SELECT list_elmt_value, list_elmt_label FROM sm_list_item WHERE module_id='XH' AND list_ref='HSELIGIFL'";
			stmt = conn.createStatement();
			rset =	stmt.executeQuery(queryApplication);			
			
			while(rset.next())
			{				
				responseStatusMap.put(rset.getString(1).toString().trim(),rset.getString(2));
			}
		}
		catch(Exception e1)
		{
			System.out.println("(XHPatientMembershipCheckResult.jsp:Exception-1) "+e1.toString());
		}
		finally{

             try{
				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
				}
				catch(Exception e)
				{

				}
		}
     
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_class ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nursing_unit_code ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(period_dt1 ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(period_dt2 ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cust_id ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(eligibility_check ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cust_group_code ));
            _bw.write(_wl_block19Bytes, _wl_block19);


		if(arrRow.size()==0)
		{
		
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		else
		{
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

		for (int j=0; j<arrRow.size();j++)
		{
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
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(((String)arrCol.get(3)).equals("null")?"":arrCol.get(3)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(((String)arrCol.get(1)).equals("null")?"":arrCol.get(1)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((String)arrCol.get(0)).equals("null")?"":arrCol.get(0)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((String)arrCol.get(9)).equals("null")?"":arrCol.get(9)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((String)arrCol.get(30)).equals("null")?"":arrCol.get(30)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((String)arrCol.get(7)).equals("null")?"":arrCol.get(7)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((String)arrCol.get(31)).equals("null")?"":arrCol.get(31)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((String)arrCol.get(26)).equals("null")?"":arrCol.get(26)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((String)arrCol.get(45)).equals("null")?"":arrCol.get(45)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((String)arrCol.get(38)).equals("null")?"":arrCol.get(38)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((responseStatusMap.get(arrCol.get(39))).equals("null")?"":responseStatusMap.get(arrCol.get(39))));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(arrCol.get(2)+""));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(arrCol.get(9)+""));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(arrCol.get(10)+""));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(arrCol.get(11)+""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(arrCol.get(12)+""));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(arrCol.get(13)+""));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(arrCol.get(14)+""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(arrCol.get(15)+""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(arrCol.get(16)+""));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(arrCol.get(17)+""));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(arrCol.get(18)+""));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(arrCol.get(19)+""));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(arrCol.get(20)+""));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(arrCol.get(6)+""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(arrCol.get(21)+""));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(arrCol.get(24)+""));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(arrCol.get(32)+""));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(arrCol.get(25)+""));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(arrCol.get(27)+""));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(arrCol.get(22)+""));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(arrCol.get(26)+""));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(arrCol.get(3)+""));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(arrCol.get(6)+""));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(arrCol.get(33)+""));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(arrCol.get(34)+""));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(arrCol.get(35)+""));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(arrCol.get(36)+""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(arrCol.get(8)+""));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(arrCol.get(23)+""));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(arrCol.get(37)+""));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(arrCol.get(38)+""));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(arrCol.get(39)+""));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(arrCol.get(40)+""));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(arrCol.get(41)+""));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(arrCol.get(42)+""));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(arrCol.get(43)+""));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(arrCol.get(44)+""));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(arrCol.get(45)+""));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(arrCol.get(2)+""));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(arrCol.get(9)+""));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(arrCol.get(10)+""));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(arrCol.get(11)+""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(arrCol.get(12)+""));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(arrCol.get(13)+""));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(arrCol.get(14)+""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(arrCol.get(15)+""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(arrCol.get(16)+""));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(arrCol.get(17)+""));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(arrCol.get(18)+""));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(arrCol.get(19)+""));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(arrCol.get(20)+""));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(arrCol.get(6)+""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(arrCol.get(21)+""));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(arrCol.get(24)+""));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(arrCol.get(32)+""));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(arrCol.get(25)+""));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(arrCol.get(27)+""));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(arrCol.get(22)+""));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(arrCol.get(26)+""));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(arrCol.get(3)+""));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(arrCol.get(6)+""));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(arrCol.get(33)+""));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(arrCol.get(34)+""));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(arrCol.get(35)+""));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(arrCol.get(36)+""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(arrCol.get(8)+""));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(arrCol.get(23)+""));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(arrCol.get(37)+""));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(arrCol.get(38)+""));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(arrCol.get(39)+""));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(arrCol.get(40)+""));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(arrCol.get(41)+""));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(arrCol.get(42)+""));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(arrCol.get(43)+""));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(arrCol.get(44)+""));
            _bw.write(_wl_block79Bytes, _wl_block79);

		}
			}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

 }catch(Exception e1)
			{
			 out.println("(XHPatientMembershipCheckResult.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}

            _bw.write(_wl_block80Bytes, _wl_block80);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CompanyName.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ByUser.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.requesteddate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Response.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.CHECK_ELIGI_DETAILS.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
