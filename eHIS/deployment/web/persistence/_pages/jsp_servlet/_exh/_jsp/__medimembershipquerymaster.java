package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eXH.XHUtil;
import java.util.*;
import com.ehis.util.*;

public final class __medimembershipquerymaster extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/MediMembershipQueryMaster.jsp", 1742540073667L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 ="\t\n\n<HEAD>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\t\t      \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t    \n\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../OP/js/messages.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/ViewEvents.js\"></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/jquery-3.6.3.js\' language=\'javascript\'></script>\n\n\n<script language=\"javascript\">\n\nfunction Query()\n{    \t\n\tparent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n\n\tvar customer_group=document.getElementById(\"customer_group_id\").value;\n\tvar customer_id = document.getElementById(\"customer_id\").value;\n\tvar patient_id = document.getElementById(\"patient_id\").value;\n\tvar episode_type = document.getElementById(\"patient_class_episode\").value;\n\tvar episode_id=document.getElementById(\"episode_name\").value;\n\n    var bill_from = document.getElementById(\"from_bill_id\").value\n\tvar bill_to = document.getElementById(\"to_bill_id\").value\n\t\n\tvar trans_from_dt =  document.getElementById(\"trans_from_dt\").value;\n\tvar trans_to_dt =  document.getElementById(\"trans_to_dt\").value;\n\tvar event =  document.getElementById(\"event\").value;\n\tvar type =  document.getElementById(\"type\").value;\n\n    var eligibility_status_type = document.getElementById(\"eligibility_status_type\").value;\n\n\tvar patient_class_episode = \"\";\n\tif(episode_type == \"O\"){\n        patient_class_episode =\"OP\";\n\t}\n\tif(episode_type == \"I\"){\n        patient_class_episode =\"IP\";\n\t}\n\tif(episode_type == \"E\"){\n        patient_class_episode =\"EM\";\n\t}\n\tif(episode_type == \"D\"){\n        patient_class_episode =\"DC\";\n\t}\n\n\t//var patient_class_orderby = document.forms[0].patient_class_orderby.value;\n\t//var admType = document.getElementById(\"admission_type\").value;\n\n\t/*if(!(patient_id != null && patient_id != \"\" && patient_id != \" \"))\n\t{ \n\t\talert(\"APP-XH0068 Patient ID Should not be Empty\");\n\t\tdocument.forms[0].patient_id.focus();\n\t\treturn;\n\t} \n\telse if(!(customer_id != null && customer_id != \"\" && customer_id != \" \"))\n\t{ \n\t\talert(\"APP-XH0068 Payer Information should not be Empty\");\n\t\tdocument.forms[0].customer_id.focus();\n\t\treturn;\n\t} \n\n\t\n\t/*var params= \"patient_id=\"+patient_id+\"&encounter_id=\"+encounter_id+\"&practitioner_id=\"+practitioner_id+\"&patient_class=\"+patient_class+\"&nursing_unit_code=\"+nursing_unit_code+\"&admission_from_dt=\"+admission_from_dt+\"&admission_to_dt=\"+admission_to_dt+\"&cust_id=\"+cust_id+\"&eligibility_check=\"+eligibility_check+\"&cust_group_code=\"+cust_group_code; \n  \n\telse \n\t{\n\t*/\t\n\t\tvar params = \"customer_group=\"+customer_group+\"&customer_id=\"+customer_id+\"&patient_id=\"+patient_id+\"&patient_class_episode=\"+patient_class_episode+\"&episode_id=\"+episode_id+\"&trans_from_dt=\"+trans_from_dt+\"&trans_to_dt=\"+trans_to_dt+\"&bill_from=\"+bill_from+\"&bill_to=\"+bill_to+\"&eligibility_status_type=\"+eligibility_status_type+\"&event_type=\"+event+\"&check_type=\"+type;\n\n\t\tparent.resultFrame.document.location.href=\"../../eXH/jsp/MediMembershipQueryResult.jsp?\"+params;\n\t\n}\nfunction Report(){\n\n\t\tvar event = \"\";\n\t\tvar checkBoxes = document.getElementsByName(\'checkbox\');\n\n\t\tfor(var i = 0; i < checkBoxes.length; i++)\n\t\t{\n\t\t\tif(checkBoxes[i].checked)\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"p_line_level_reqd_yn\").value = \"Y\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"p_line_level_reqd_yn\").value = \"N\";\n\t\t\t}\n\t\t}\n\t\tvar event =  document.getElementById(\"event\").value;\n\t    var report_id =  document.getElementById(\"p_report_id\").value;\n        if(!(event !=null && event != \"\" && event != \" \" && report_id !=null && report_id != \"\" && report_id != \" \" )){\n            alert(\"APP-XH0068 Please Select the Transaction Type and Event.\");\n\t\t\treturn;\n\t\t}\n\t\tparent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.action = \'../../eCommon/jsp/report_options.jsp\';\n\t    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target=\"messageFrame\";\n\t    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.submit();\n\t\t//document.PAYER_CHECK_QUERY_FORM.submit();\n   /* parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.action = \'../../eXH/jsp/PatientMembershipReports.jsp\';\n\tparent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target=\"f_query_add_mod\";\n\n\t//parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target=\"f_query_add_mod\";\n\tparent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.submit();*/\n}\nfunction clearSearch()\n{\n   \n   parent.f_query_add_mod.location.reload();\n   parent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\t\n}\n\n\nfunction clearSearchResult()\n{\n   parent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n}\n\nfunction getPatID()\n{\t\t\t\t\t  \n\tvar pat_id=PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'VIEW\');\n\tif( pat_id != null )\t\t\t\t\t\t\n\t\tdocument.forms[0].patient_id.value = pat_id ;\t\t\t\t\t\n}\n\nasync function searchCustomerId(){\n   \n\t\t\tvar tdesc=\"\";\n            var tcode=\"\";\n\t\t\tvar tdestcode = \"\";\n\n\t\t\tclearSearchResult();\n\n            var retVal =new String();\n            var argumentArray  = new Array() ;\n            var dataNameArray  = new Array() ;\n            var dataValueArray = new Array() ;\n            var dataTypeArray  = new Array() ;\n            var tit=\"Payer\";\t\n\t\t\tvar customer_grp_id = this.document.getElementById(\"customer_group_id\").value;\n            var target=this.document.getElementById(\"customer_desc\");\n            var customer_id=this.document.getElementById(\"customer_id\"); \n\t\t\tvar dest_code=this.document.getElementById(\"dest_code\"); \n\n\t\t\tsql=\"SELECT CUST_CODE code, SHORT_NAME description FROM AR_CUSTOMER WHERE UPPER(CUST_CODE) LIKE UPPER(?) AND UPPER(SHORT_NAME) LIKE UPPER(?) \";\n\n\t\t\tif(customer_grp_id!=\"\" && customer_grp_id!=null)\n\t        {\n\t\t\t\tsql= sql + \" AND CUST_GROUP_CODE =\'\"+customer_grp_id+\"\'\" ;\n\t\t\t}\n\n\t\t\tsql= sql + \"  ORDER BY 1 \";\n\n            argumentArray[0] = sql;\n            argumentArray[1] = dataNameArray ;\n            argumentArray[2] = dataValueArray ;\n            argumentArray[3] = dataTypeArray ;\n//            argumentArray[4] = \"2,1\";\n\t\t    argumentArray[4] = \"1,2\";\n            argumentArray[5] = target.value;\n            argumentArray[6] = DESC_LINK  ;\n            argumentArray[7] = DESC_CODE ;\n\n            retVal = await CommonLookup( tit, argumentArray );\n\n            if(retVal != null && retVal != \"\" ){\n\t            var ret1=unescape(retVal);\n                arr=ret1.split(\",\");\n                customer_id.value=arr[0];\n                target.value=arr[1];\n            }\n            else{\n                target.value=tdesc;\n                customer_id.value=tcode;\n            }\n\t\t\t\n}// End of searchCustomerId\n\n\nasync function searchPayerGroupId(){\n\t\t\tvar tdesc=\"\";\n            var tcode=\"\";\n\n\t\t\tclearSearchResult();\n\t\t\t\n\t\t\tvar retVal =new String();\n            var argumentArray  = new Array() ;\n            var dataNameArray  = new Array() ;\n            var dataValueArray = new Array() ;\n            var dataTypeArray  = new Array() ;\n            var tit= \"Payer Group\";\t\t\t\n            var target=this.document.getElementById(\"customer_group_id\");\n            var customer_group_desc=this.document.getElementById(\"customer_group_desc\");\n\n\t\t\tsql=\"SELECT CUST_GROUP_CODE code, SHORT_DESC description FROM AR_CUST_GROUP WHERE UPPER(CUST_GROUP_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1 \";\n\n            argumentArray[0] = sql;\n            argumentArray[1] = dataNameArray ;\n            argumentArray[2] = dataValueArray ;\n            argumentArray[3] = dataTypeArray ;\n//            argumentArray[4] = \"2,1\";\n\t\t    argumentArray[4] = \"1,2\";\n            argumentArray[5] = target.value;\n            argumentArray[6] = DESC_LINK  ;\n            argumentArray[7] = DESC_CODE ;\n            retVal = await CommonLookup( tit, argumentArray );\n\n            if(retVal != null && retVal != \"\" ){\n\t            var ret1=unescape(retVal);\n                arr=ret1.split(\",\");\n                customer_group_desc.value=arr[1];\n                target.value=arr[0];\n            }\n            else{\n                target.value=tdesc;\n                customer_group_desc.value=tcode;\n            }\n\n\t\t\t\t\t\t\n}// End of searchPayerGroupId\n\nasync function searchEpisodeId(){\n\n\t\t\tvar tdesc=\"\";\n            var tcode=\"\";\n\n\t\t\tclearSearchResult();\n\n            var retVal =new String();\n            var argumentArray  = new Array() ;\n            var dataNameArray  = new Array() ;\n            var dataValueArray = new Array() ;\n            var dataTypeArray  = new Array() ;\n            var tit= \"Episode Id\";\t\t\t\n            var target=document.getElementById(\"episode_name\");\n\t\t\tvar episode_id=document.getElementById(\"episode_id\");\n        \n            var episode_type = this.document.getElementById(\"episode_type\").value;\n\t\t\tvar patient_class_episode = \"\";\n\n\t\t\tif(episode_type == \"O\"){\n\t\t\t\tpatient_class_episode =\"OP\";\n\t\t\t}\n\t\t\tif(episode_type == \"I\"){\n\t\t\t\tpatient_class_episode =\"IP\";\n\t\t\t}\n\t\t\tif(episode_type == \"E\"){\n\t\t\t\tpatient_class_episode =\"EM\";\n\t\t\t}\n\t\t\tif(episode_type == \"D\"){\n\t\t\t\tpatient_class_episode =\"DC\";\n\t\t\t}\n\n\t\t\tsql=\"SELECT ENCOUNTER_ID code, EPISODE_ID description FROM pr_encounter WHERE  UPPER(ENCOUNTER_ID) LIKE UPPER(?) AND UPPER(EPISODE_ID) LIKE UPPER(?) \";\n\n\t\t\tif(patient_class_episode!=\"\" && patient_class_episode!=null)\n\t        {\n\t\t\t\tsql= sql + \" AND PATIENT_CLASS=\'\"+patient_class_episode+\"\'\" ;\n\t\t\t}\n\n \n\t\t\tsql= sql + \" ORDER BY 1 \";\n            argumentArray[0] = sql;\n            argumentArray[1] = dataNameArray ;\n            argumentArray[2] = dataValueArray ;\n            argumentArray[3] = dataTypeArray ;\n//          argumentArray[4] = \"2,1\";\n\t\t    argumentArray[4] = \"1,2\";\n            argumentArray[5] = target.value;\n            argumentArray[6] = DESC_LINK  ;\n            argumentArray[7] = DESC_CODE ;\n\n            retVal = await CommonLookup( tit, argumentArray );\n\n            if(retVal != null && retVal != \"\" ){\n\t            var ret1=unescape(retVal);\n                arr=ret1.split(\",\");\n                target.value=arr[1];\n                episode_id.value=arr[0];\n\t\t\t\tthis.document.forms[0].p_visit_id.value = arr[0].substring(11,12);\n\t\t\t\t\n            }\n            else{\n                target.value=tdesc;\n                episode_id.value=tcode;\n            }\n\t\t\t\n}// End of searchEpisodeId\n\nasync function getFromBillID(){\n\n\tvar tdesc=\"\";\n\tvar tcode=\"\";\n\n\tclearSearchResult();\n\n\tvar retVal =new String();\n\tvar argumentArray  = new Array() ;\n\tvar dataNameArray  = new Array() ;\n\tvar dataValueArray = new Array() ;\n\tvar dataTypeArray  = new Array() ;\n\tvar tit= \"From.\";\t\t\t\n\tvar target=this.document.getElementById(\"from_bill_id\");\n    var from_bill_desc=this.document.getElementById(\"from_bill_desc\");\n\tsql=\"SELECT DOC_TYPE_CODE code,DOC_NUM description FROM bl_bill_hdr WHERE  UPPER(DOC_TYPE_CODE) LIKE UPPER(?) AND UPPER(DOC_NUM) LIKE UPPER(?) ORDER BY 1 \";\n\n\targumentArray[0] = sql;\n\targumentArray[1] = dataNameArray ;\n\targumentArray[2] = dataValueArray ;\n\targumentArray[3] = dataTypeArray ;\n//          argumentArray[4] = \"2,1\";\n\targumentArray[4] = \"1,2\";\n\targumentArray[5] = target.value;\n\targumentArray[6] = DESC_LINK  ;\n\targumentArray[7] = DESC_CODE ;\n\n\tretVal = await CommonLookup( tit, argumentArray );\n\n\tif(retVal != null && retVal != \"\" ){\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\ttarget.value=arr[1];\n\t\tfrom_bill_desc.value=arr[0];\n\t}\n\telse{\n\t\ttarget.value=tdesc;\n\t\tfrom_bill_desc.value=tcode;\n\t}\n}\nasync function getToBillID(){\n\n\tvar tdesc=\"\";\n\tvar tcode=\"\";\n\n\tclearSearchResult();\n\n\tvar retVal =new String();\n\tvar argumentArray  = new Array() ;\n\tvar dataNameArray  = new Array() ;\n\tvar dataValueArray = new Array() ;\n\tvar dataTypeArray  = new Array() ;\n\tvar tit= \"To\";\t\t\t\n\tvar target=this.document.getElementById(\"to_bill_id\");\n    var to_bill_desc=this.document.getElementById(\"to_bill_desc\");\n\tsql=\"SELECT DOC_TYPE_CODE code,DOC_NUM description FROM bl_bill_hdr WHERE  UPPER(DOC_TYPE_CODE) LIKE UPPER(?) AND UPPER(DOC_NUM) LIKE UPPER(?) ORDER BY 1 \";\n\n\targumentArray[0] = sql;\n\targumentArray[1] = dataNameArray ;\n\targumentArray[2] = dataValueArray ;\n\targumentArray[3] = dataTypeArray ;\n//          argumentArray[4] = \"2,1\";\n\targumentArray[4] = \"1,2\";\n\targumentArray[5] = target.value;\n\targumentArray[6] = DESC_LINK  ;\n\targumentArray[7] = DESC_CODE ;\n\n\tretVal = await CommonLookup( tit, argumentArray );\n\n\tif(retVal != null && retVal != \"\" ){\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\ttarget.value=arr[1];\n\t\tto_bill_desc.value=arr[0];\n\t}\n\telse{\n\t\ttarget.value=tdesc;\n\t\tto_bill_desc.value=tcode;\n\t}\n}\n\nfunction selectStatus(){\n\n\tclearSearchResult();\n\tvar type = document.getElementById(\"type\").value;\n\n\tif(type == \"\" )\n\t{\n\t\tvar selectbox = document.getElementById(\"eligibility_status_type\");\n\t\tselectbox.options.length = 0;\t \n\t\taddOption(selectbox,\"------Select-------\",\"\");\n\t}\n\n\tif(type == \"IDC\" || type == \"FAM\" || type == \"UEC\" || type == \"IEC\"){\n\t\tvar selectbox = document.getElementById(\"eligibility_status_type\");\n\t\tselectbox.options.length = 0;\n\t\taddOption(selectbox,\"------Select-------\",\"\");\n\t\taddOption(selectbox,\"Response Success\",\"01\");\n\t\taddOption(selectbox,\"Response Rejected\",\"02\");\n\t\taddOption(selectbox,\"Response Failed\",\"03\");\n\t\taddOption(selectbox,\"Network Error\",\"04\");\n\t}\n\t\n\tif(type == \"CLM\" ){\n\t\tvar selectbox = document.getElementById(\"eligibility_status_type\");\n\t\tselectbox.options.length = 0;\t \n\t\taddOption(selectbox,\"------Select-------\",\"\");\n\t\taddOption(selectbox,\"Processed\",\"Processed\");\n\t\taddOption(selectbox,\"Rejected\",\"Rej\");\n\t\taddOption(selectbox,\"Duplicate \",\"Duplcate\");\n\t\taddOption(selectbox,\"Warning\",\"Warning\");\n\t}\n\t\n\tif(type == \"REV\" || type == \"EOC\")\n\t{\n\t\tvar selectbox = document.getElementById(\"eligibility_status_type\");\n\t\tselectbox.options.length = 0;\n\t\taddOption(selectbox,\"------Select-------\",\"\");\n\t\taddOption(selectbox,\"Authorised\",\"Auth\");\n\t\taddOption(selectbox,\"Rejected\",\"Rej\");\n\t}\n}\nfunction popup(){\n  var optn =\"\";\n  var event=document.getElementById(\"event\").value;\n  var type=\"\";\n  var option=\"\";\n   if(event == \"\"){\n\t  var selectbox = document.getElementById(\"type\");\n\t  selectbox.options.length = 0;\n\t  addOption(selectbox,\"------Select-------\",\"\");\n\t  selectbox = document.getElementById(\"eligibility_status_type\");\n\t  selectbox.options.length = 0;\t \n\t  addOption(selectbox,\"------Select-------\",\"\");\n   }\n  if(event == \"ELC\"){\n\t document.getElementById(\"p_report_id\").value = \"XFENCWES\";\n\t var selectbox = document.getElementById(\"eligibility_status_type\");\n\t selectbox.options.length = 0;\t \n\t addOption(selectbox,\"------Select-------\",\"\");\n\t selectbox = document.getElementById(\"type\");\n\t selectbox.options.length = 0;\n\t addOption(selectbox,\"------Select-------\",\"\");\n     addOption(selectbox,\"ID Check\",\"IDC\");\n\t addOption(selectbox,\"FAM Check\",\"FAM\");\n     addOption(selectbox,\"UnInsured Eligiblity Check\",\"UEC\");\n     addOption(selectbox,\"Insured Eligiblity Check\",\"IEC\");\n\n  }\n  if(event == \"ECL\"){\n\t document.getElementById(\"p_report_id\").value = \"XFECLWES\";\n\t var selectbox = document.getElementById(\"eligibility_status_type\");\n\t selectbox.options.length = 0;\t \n     addOption(selectbox,\"------Select-------\",\"\");\n\t selectbox = document.getElementById(\"type\");\n     selectbox.options.length = 0;\n\t addOption(selectbox,\"------Select-------\",\"\");\n     addOption(selectbox,\"Claims Transactions\",\"CLA\");\n\t addOption(selectbox,\"Claims with End of Case Transactions\",\"CLE\");\n\t addOption(selectbox,\"Reversal Transactions\",\"REV\");\n     addOption(selectbox,\"EOC Transactions\",\"EOC\");\n  }\n}\nfunction addOption(selectbox,text,value){\n     optn = document.createElement(\"OPTION\");\n     optn.text = text;\n     optn.value = value;\n     selectbox.options.add(optn);\n}\nfunction popupType(){\n\n\tvar dataElements=\"\";\n    var response = \"\";\n\tvar event = \"\";\n\tvar type = \"\";\n\tvar response =\"\";\n\tvar responseTxt=\"\";\n\tvar select = \"\";\n\tvar l_type_code = \"\";\n\tvar\tl_type_desc = \"\";\n\tevent=document.getElementById(\"event\").value;\n\ttype=document.getElementById(\"type\").value;\n\tif(type == \"\"){\n\t\tselectbox = document.getElementById(\"eligibility_status_type\");\n\t\tselectbox.options.length = 0;\t \n\t\taddOption(selectbox,\"------Select-------\",\"\");\n\t\t}\n\telse\n\t{\n\t   var selectbox = document.getElementById(\"eligibility_status_type\");\n\t   selectbox.options.length = 0;\n\t   addOption(selectbox,\"------Select-------\",\"\");\n\t   dataElements =\"<EVENT>\"+event+\"$!^<TYPE>\"+type+\"$!^\";\n\t   response= getStatus(dataElements);\n\t   responseTxt = response.split(\"$!^\");\n\t   for (i = 0; i <responseTxt.length-1; i++) {\n\t\t\tresponseMsg=responseTxt[i].split(\"##\");\n\t\t\tl_type_code=responseMsg[0];\n\t\t\tl_type_desc=responseMsg[1];\n\t\t\taddOption(selectbox,l_type_desc,l_type_code);\n\n\t\t}\n\n\t}\n\n}\nfunction getStatus(dataElements)\n{\n    var responseMsg=\"\";\n\tvar data1=true;\n\t$.ajax({\n\t\turl: \'../../servlet/eXH.GetStatusServlet\',\n\t\ttype: \'POST\',\n\t\tcache: false,\n\t\t\n\t\tdata: {\n\t\t\t\tcallType: \'ECLAIMS\',\n\t\t\t\tparamString: dataElements\n\t\t},\n\t\tsuccess: function (data1) {\n\t\t\tresponseMsg = data1;\n\t\t},\t\t\n\t\tdataType: \'text\',\n\t\tasync: false\n\t});\n\t\nreturn responseMsg;\n} \n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\t\n\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" >\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<form name=\"PAYER_CHECK_QUERY_FORM\" id=\"PAYER_CHECK_QUERY_FORM\" method=\"get\" action=\"\">\n<fieldset style=\" border-color:grey;\">\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\n\t<td class=label width=\"10%\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t<td class=\'fields\'>\n\t    <input type=\"hidden\" id=\"customer_group_desc\" >\n\t\t<INPUT TYPE=\"text\" id=\"customer_group_id\" name=\"p_cust_group_code\" id=\"p_cust_group_code\" onBlur=\'searchPayerGroupId()\'  value=\"\">\n\t\t<input class=\"BUTTON\" type=\"button\"  name=customerGroupIDSearch id=customerGroupIDSearch value=\'?\' onClick=\"searchPayerGroupId()\">\n\t</td>\n\t\n\t<td class=label width=\"10%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td class=\'fields\'>\n\t    <input type=\"hidden\" id=\"customer_id\" >\n\t\t<input type=\"hidden\" id=\"dest_code\" >\n\t\t<INPUT TYPE=\"text\" id=\"customer_desc\" name=\"p_cust_code\" id=\"p_cust_code\" onBlur=\'searchCustomerId()\'  value=\"\">\n\t\t<input class=\"BUTTON\" type=\"button\"  name=customerIDSearch id=customerIDSearch value=\'?\' onClick=\"searchCustomerId()\">\n\t</td>\n\t<td></td>\n\t<td></td>\n\t<td></td>\n</tr>\n<tr>\n\n\t<td class=label width=\"10%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\n\t<td class=\'fields\'>\n\t\t<INPUT TYPE=\"text\" id=\"patient_id\" name=\"p_patient_id\" id=\"p_patient_id\" align=\"left\" size=\'20\' maxlength=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'  value=\"\" onBlur=\"ChangeUpperCase(this);\" >\n\t\t<input type=\"button\" value=\"?\" class=\"button\" name=\'pat_search\' id=\'pat_search\' onClick=\"getPatID()\">\n\n\t</td>\n\t<td class=label width=\"10%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'fields\'>\n\t\t<select name=\"patient_class_episode\" id=\"patient_class_episode\" id=\"patient_class_episode\" style=\"width: 100px\">\n\t\t\t<option value = \'\'>----";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="----</option>\n\t\t\t<option value=\"OP\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\n\t\t\t<option value=\"EM\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t<option value=\"IP\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t<option value=\"DC\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t</select>\n\t\t</select>\n\t\t\t<input type=\"hidden\" id=\"episode_id\" >\n\t\t\t<INPUT TYPE=\"text\" id=\"episode_name\" name=\"p_episode_id\" id=\"p_episode_id\" onBlur=\'searchEpisodeId()\' >\n\t\t\t<input class=\"BUTTON\" type=\"button\"  name=episodeIDSearch id=\"episodeIDSearch\" value=\'?\' onClick=\"searchEpisodeId()\">\n\t</td>\n\t<td></td>\n\t<td></td>\n\t<td></td>\n </tr>\n<tr>\n\t<td class=label width=\"15%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\n\t\t<td class=\'fields\'>\n\t\t\t<input type=text name=p_fr_tran_date id=\"p_fr_tran_date\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" size=11  > <input type=\'image\' id=\"trans_from_dt_img\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'trans_from_dt\',\'dd/mm/y\');\"  >\n\t\t\t<input type=text name=p_to_tran_date id=\"p_to_tran_date\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" size=11  > <input type=\'image\' id=\"trans_to_dt_img\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'trans_to_dt\',\'dd/mm/y\');\">\n\t\t</td>\t\t\t\n\t<td class=label width=\"10%\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<td class=\'fields\'>\n\t    <input type=\"hidden\" id=\"from_bill_desc\" >\n\t\t<INPUT TYPE=\"text\" id=\"from_bill_id\"  align=\"left\" size=\'20\'  value=\"\" style=\"width: 100px\" onBlur=\'getFromBillID()\' >\n\t\t<input type=\"button\" value=\"?\" class=\"button\"  onClick=\"getFromBillID()\">\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<input type=\"hidden\" id=\"to_bill_desc\" >\n        <INPUT TYPE=\"text\" id=\"to_bill_id\"  align=\"left\" size=\'20\'  value=\"\"  style=\"width: 110px\" onBlur=\'getToBillID()\'>\n\t\t<input type=\"button\" value=\"?\" class=\"button\"  onClick=\"getToBillID()\">\n\t</td>\n\t<td></td>\n\t<td></td>\n\t<td></td>\n</tr>\n<tr>\n\t<td class=label width=\"10%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\n\t\t<td class=\'fields\'>\n\t\t\t<select  id=\"event\" style=\"width: 150px\" onChange=\"popup();\">\n\t\t\t\t<option value = \'\'>----";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="----</option>\n\t\t\t\t<option value = \'ELC\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t\t\t<option value = \'ECL\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t    </select>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<select id=\"type\" name=\"p_trans_type\" id=\"p_trans_type\" style=\"width:170px\" onChange=\"popupType();\">\n\t\t\t<option value = \'\'>----";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="----</option>\n           </select>\n\t\t</select>\n\t\t</td>\t\t\t\n      <td class=label width=\"10%\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t  <td class=\'fields\'>\n\t    <select id=\'eligibility_status_type\' name=\"p_trans_status\" id=\"p_trans_status\" style=\"width:150px\">\n\t\t   <option value = \'\'>---- Select ----</option>\n\t    </select>\n\t</td>\n\t<td></td>\n\t<td></td>\n\t<td></td>\n</tr>\n<tr>\n\t<td class=label width=\"10%\" >Show Item Details</td>\n\t<td><input type=\'checkbox\' id=\'checkbox\' value = \'N\'> </td>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n\t<td></td>\n\t<td></td>\n\t<td></td>\n</tr>\n\n</table>\n\n<table width=\'100%\' cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t<tr align=\"right\">\n\t\t<td colspan=4 class=\'BUTTON\'>\n\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"query\" name=\"query\" id=\"query\" value=\'Search\' onClick=\"Query()\">\n\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"report\" name=\"report\" id=\"report\" value=\'Report\' onClick=\"Report()\">\n\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"clear\" name=clear value=\'Clear\' onClick=\"clearSearch()\">\n\t\t</td>\n\t</tr>\n</table>\n<input type=\"hidden\" name=\"p_visit_id\" id=\"p_visit_id\"          value=\"\">\n<input type=\"hidden\" name=\"p_healthcare_transaction_ref\" id=\"p_healthcare_transaction_ref\" value=\"\">\n<input type=\"hidden\" name=\"p_history_yn\" id=\"p_history_yn\"         value=\"N\">\n<input type=\"hidden\" name=\"p_case_no\" id=\"p_case_no\"            value=\"\">\n<input type=\"hidden\" name=\"p_with_out_eligibility_yn\" id=\"p_with_out_eligibility_yn\"         value=\"N\">\n<input type=\"hidden\" name=\"p_with_out_claim_submission_yn\" id=\"p_with_out_claim_submission_yn\"         value=\"N\">\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"       value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\"hidden\" name=\"p_line_level_reqd_yn\" id=\"p_line_level_reqd_yn\" id=\"p_line_level_reqd_yn\"   value=\"N\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"         value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" id=\"p_report_id\"         value=\"\">\n<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\" id=\"p_language_id\"         value=\"en\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"         value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n</fieldset>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;");
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
 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);


String trans_from_dt = "";
String trans_to_dt = "";
String status_code = "",status_desc = "";
String str = "";
String p_module_id      = "XF" ;
String p_facility_id    = (String) session.getValue( "facility_id" ) ;
String p_user_name      = (String) session.getValue( "login_user" ) ;
SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
java.util.Date da = new java.util.Date();
Calendar cal = Calendar.getInstance();
cal.setTime(da);
cal.add(Calendar.MONTH, -1);
da = cal.getTime();
trans_from_dt =dateFormat.format(da) ;
trans_to_dt = dateFormat.format(new java.util.Date()) ;

String pid_length="10";
Connection conn = null;
	try
	{ 
		pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));		
	
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pid_length));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(trans_from_dt ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(trans_to_dt ));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_module_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block33Bytes, _wl_block33);

}catch(Exception e1)
			{
			 out.println("(MediMembershipQueryMaster.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}

            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.PAYER_GROUP.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Outpatient.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.inpatient.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daycare.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransactionDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_DOC_NO.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Transaction.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Eligiblitycheck.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Claims.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
}
