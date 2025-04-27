package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import eOT.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __anesthesiaregistryreports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AnesthesiaRegistryReports.jsp", 1709120144000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script>\nfunction assignRepParam()\n{\n//alert(document.forms[0].param3.value);\n}\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head><title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script src=\"../../eOT/js/OtReports.js\" ></script>\n\t<script src=\"../../eOT/js/OTReportsLkupSQL.js\" ></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n    <script language=\"javascript\">\n\tfunction decodeLower(obj)\n   {\n            if ( (obj.value==null)||(obj.value==\"\")||(obj.value==\"undefined\") )\n             {\n                 return(\"LOWEST\");\n             }\n            else\n             {\n                 return(obj.value);\n             }\n   }\n\n   function decodeHigher(obj)\n     {\n            if ( (obj.value==null)||(obj.value==\"\")||(obj.value==\"undefined\") )\n             {\n                 return(\"HIGHEST\");\n             }\n            else\n             {\n                 return(obj.value);\n             }\n   }\n\tfunction callExcelDisplay(){\n\tvar frm=window.parent.frames[1];\n\tformObj=document.OtReportOptionsForm;\n\t\n    var male=getLabel(\"Common.male.label\",\"common\");\n\tvar female=getLabel(\"Common.female.label\",\"common\");\n\tvar qryStr = \"SELECT  B.OPERATING_FACILITY_ID,B.OPER_NUM, TO_CHAR(B.OPER_DATE, \'DD/MM/YYYY\'),  A.PATIENT_ID, decode (\'\"+locale+\"\',\'en\',H.PATIENT_NAME, NVL(H.PATIENT_NAME_LOC_LANG,H.PATIENT_NAME)),  DECODE(H.SEX, \'M\', \'\"+male+\"\', \'\"+female+\"\', \'Female\')  SEX,  GET_AGE(H.DATE_OF_BIRTH) AGE, H.NATIONAL_ID_NO  NRIC, B.REF_SOURCE_CODE, G.SHORT_DESC ANESTH_DESC,  C.OPER_NUM DTLS_OPER_NUM, D.SHORT_DESC OPER_DESC ,  to_char(A.START_TIME, \'hh24:mi\') start_time , to_char(A.END_TIME, \'hh24:mi\') end_time   FROM  AT_ANAESTHESIA_RECORD_HDR  A, OT_POST_OPER_HDR B, OT_POST_OPER_DTLS C  , OT_OPER_MAST D ,  MP_PATIENT H , AM_ANAESTHESIA_LANG_VW G WHERE G.LANGUAGE_ID=\'\"+locale+\"\' AND A.OPERATING_FACILITY_ID  =  \'\"+formObj.p_facility_id.value+\"\'  AND  A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID   AND A.ACCESSION_NUM = B.OPER_NUM AND B.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID  AND B.OPER_NUM = C.OPER_NUM AND C.OPER_CODE = D.OPER_CODE AND A.PATIENT_ID = H.PATIENT_ID AND  A.ANAESTHESIA_CODE = G.ANAESTHESIA_CODE(+)  AND B.OPER_DATE   BETWEEN   TO_DATE(\'\"+formObj.param1.value+\"\'||\' 00:00\', \'DD/MM/YYYY HH24:MI\')   AND   TO_DATE(\'\"+formObj.param2.value+\"\'||\' 23:59\' , \'DD/MM/YYYY HH24:MI\')  AND  B.ANESTHESIA_CODE  =  NVL(\'\"+formObj.param5.value+\"\', B.ANESTHESIA_CODE) AND  ( ( (\'\"+formObj.param3.value+\"\' IS NOT NULL OR \'\"+formObj.param4.value+\"\' IS NOT NULL)  AND  (A.OPERATING_FACILITY_ID, A.ACCESSION_NUM) IN (SELECT  OPERATING_FACILITY_ID , OPER_NUM FROM    OT_POST_OPER_PERSONNEL WHERE  (PRACTITIONER_ID = NVL(\'\"+formObj.param3.value+\"\', PRACTITIONER_ID)  AND ROLE_TYPE = \'MA\') AND        (PRACTITIONER_ID = NVL(\'\"+formObj.param4.value+\"\', PRACTITIONER_ID)  AND ROLE_TYPE = \'OS\') )  ) or  (\'\"+formObj.param3.value+\"\' IS NULL OR \'\"+formObj.param4.value+\"\' IS NULL) )     ORDER BY  TO_CHAR(B.OPER_DATE, \'DD/MM/YYYY\'), B.OPER_NUM, C.OPER_NUM , A.PATIENT_ID\";\n\n\t//var sql_site_name=\"SELECT SITE_NAME  FROM SM_SITE_PARAM\";\n\tvar sql_site_name=\"SELECT SITE_NAME  FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID = \'\"+locale+\"\' \";\n\tvar sql_facility_name=\"SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE  FACILITY_ID =\'\"+formObj.p_facility_id.value+\"\' \";\n\tvar sql_report_desc=\"SELECT REPORT_DESC FROM SM_REPORT WHERE  REPORT_ID = \'\"+formObj.p_report_id.value+\"\' AND  MODULE_ID  = \'\"+formObj.p_module_id.value+\"\' \";\n\n\tif(formObj.param5.value==null || formObj.param5.value==\"\")\n        formObj.param5.value=\"All\";\n    if(formObj.param4.value==null || formObj.param4.value==\"\")\n        formObj.param4.value=\"All\";\n\tif(formObj.param3.value==null || formObj.param3.value==\"\")\n        formObj.param3.value=\"All\";\n\tvar\t\tFromOperationDate_title = getLabel(\"eOT.FromOperationDate.Label\",\"OT\");\n\tvar\t\tToOperationDate_title   = getLabel(\"eOT.ToOperationDate.Label\",\"OT\");\n\tvar\t\tAnaesthesiaType_title   = getLabel(\"eOT.AnaesthesiaType.Label\",\"OT\");\n\tvar\t\tSurgeon_title\t\t= getLabel(\"Common.Surgeon.label\",\"Common\");\n\tvar\t\tAnaesthetist_title\t\t= getLabel(\"Common.Anaesthetist.label\",\"Common\");\n\t\n\tvar header_Details = FromOperationDate_title +\"*\"+formObj.param1.value+\"*\"+ToOperationDate_title  +\"*\"+formObj.param2.value+\"*\"+AnaesthesiaType_title+\"*\"+formObj.param5.value+\"#\"+Surgeon_title+\"*\"+formObj.param4.value+\"*\"+Anaesthetist_title+\"*\"+formObj.param3.value;\n\n   \n    formObj.header_Details.value=header_Details;\n\n\tformObj.sql_site_name.value=sql_site_name;\n\tformObj.sql_facility_name.value=sql_facility_name;\n\tformObj.sql_report_desc.value=sql_report_desc;\t\n\n    formObj.qryStr.value = qryStr;\n\tformObj.noOfCols.value = \"13\";\n\tformObj.method = \'POST\';\n\tformObj.action=\'../../servlet/eOT.OtRegistryReportsServlet\';\n\tformObj.target = \'f_query_add_mod\';\n\tformObj.submit();\n\tfrm.location.reload();\n\t\n}\n    </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<!-- <form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eCommon/jsp/report_options.jsp\"  target=\"messageFrame\">\n -->\n <form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eOT/jsp/OTReportsIntermediate.jsp\"  target=\"messageFrame\">\n<table border=\'0\' cellpadding=3 cellspacing=\'0\' width=\'100%\'>\n<tr> \n\t  <td class=\'label\' width=\"25%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n\t  </td>\n\t  <td class=\'fields\' width=\"25%\">\n\t\t  <input type=\'text\' name=\'param1\' id=\'param1\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' onBlur=\"CheckDate(this);\"> <img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param1\');\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t </td>\n\t  <td class=\'label\' width=\"25%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t  </td>\n\t  <td class=\'fields\' width=\"25%\">\n\t\t  <input type=\'text\' name=\'param2\' id=\'param2\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onBlur=\"CheckDate(this);\"> <image src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param2\');\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t </td>\n </tr>\n <tr>\n\t<td class=\'label\'>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</td>\n     <td class=\'fields\'>\n\t\t<input type=\'hidden\' name=\'param4\' id=\'param4\' value=\"\"> \n\t\t<input type=\'hidden\' name=\"param3\" id=\"param3\" value=\"\"> \n\t\t<input type=\'text\' name=\'param3_desc\' id=\'param3_desc\' size=\'20\'  onBlur=\"if(this.value!=\'\')srchCommonCode(param3,param3_desc, param4, \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\', document.forms[0].sql_text_6.value );else param3.value=\'\' \"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperCodeLookUp\' id=\'OperCodeLookUp\' onClick=\"srchCommonCode(param3,param3_desc, param4, \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\', document.forms[0].sql_text_6.value );\" >\n\t</td>\n\n\t<td class=\'label\'>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</td>\n     <td class=\'fields\'>\n\t\t<input type=\'hidden\' name=\'param6\' id=\'param6\' value=\"\"> \n\t\t<input type=\'hidden\' name=\"param5\" id=\"param5\" value=\"\"> \n\t\t<input type=\'text\' name=\'param5_desc\' id=\'param5_desc\' size=\'20\'  onBlur=\"if(this.value!=\'\')srchCommonCode(param5,param5_desc, param6, \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\', document.forms[0].sql_text_6.value );else param5.value=\'\' \"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperCodeLookUp\' id=\'OperCodeLookUp\' onClick=\"srchCommonCode(param5,param5_desc, param6, \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\', document.forms[0].sql_text_6.value );\" >\n\t</td>\n </tr>\n<tr>\n\t<td class=\'label\' width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n     <td class=\'fields\' width=\'25%\'>\n\t\t<select name=\"param7\" id=\"param7\" >  \n\t\t\t<option value= \"\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t  <option value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </option>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</select>\n\t</td>\t\n</tr>\n<tr>\n\t\n\t<td class=\'label\' width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</td>\n    <td class=\'fields\' width=\'25%\'>\n\t    <input type=\'hidden\' name=\'param9\' id=\'param9\'>\n\t\t<input type=\'hidden\' name=\'param8\' id=\'param8\'> \n\t\t<input type=\'text\' name=\'param8_desc\' id=\'param8_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' param1 = \'param8\'  param2 = \'param9\' key =\'SURGEON\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param8.value=\'\',param9.value=\'\' \" maxlength=\'70\' onkeypress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'SurgeonLookUp\' id=\'SurgeonLookUp\' onClick=\"callCommonLookup(param8_desc);\" >\n\t</td>\n\n\t<td class=\'label\'>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t</td>\n    <td class=\'fields\'>\n\t\t<input type=\'hidden\' name=\'param11\' id=\'param11\'> \n\t\t<input type=\'hidden\' name=\'param10\' id=\'param10\'> \n\t\t<input type=\'text\' name=\'param10_desc\' id=\'param10_desc\' size=\'20\'   onBlur=\"if(this.value!=\'\')srchCommonCode(param10,param10_desc,param11,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',document.forms[0].sql_text_2.value)\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'SpecialityLookUp\' id=\'SpecialityLookUp\' onClick=\"srchCommonCode(param10,param10_desc,param11,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',document.forms[0].sql_text_2.value);\" >\n\t</td>\n</tr>\n<tr>\n\t\n\t\t\t\n<tr>\n\t<td class=\'label\' width =\"25%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t</td>\n    <td class=\'fields\' width =\"25%\">\n\t\t<input type=\'hidden\' name=\'param13\' id=\'param13\' >\n\t\t<input type=\'hidden\' name=\'param12\' id=\'param12\'> \n\t\t<input type=\'text\' name=\'param12_desc\' id=\'param12_desc\' size=\'15\' onBlur=\"if(this.value!=\'\')searchCode(param12,param12_desc,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',document.forms[0].sql_text_1.value)\">  \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperTypeLookUp\' id=\'OperTypeLookUp\' onClick=\"searchCode(param12,param12_desc,\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\', document.forms[0].sql_text_1.value );\" >\n\t</td>\n</tr>\n\t\n\n\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\"\tvalue=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n    <input type=\"hidden\" name=\"header_Details\" id=\"header_Details\"\tvalue=\"\">\n\t<input type=\"hidden\" name=\"sql_site_name\" id=\"sql_site_name\" value=\"\">\n\t<input type=\"hidden\" name=\"sql_facility_name\" id=\"sql_facility_name\" value=\"\">\n\t<input type=\"hidden\" name=\"sql_report_desc\" id=\"sql_report_desc\" value=\"\">\n\t<input type=\"hidden\" name=\"qryStr\" id=\"qryStr\" value=\"\">\n\t<input type=\"hidden\" name=\"noOfCols\" id=\"noOfCols\" value=\"\">\n\t<input type=\"hidden\" name=\"p_user_id\" id=\"p_user_id\"\tvalue=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"  value=\"OT\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"ATRANREG\">\n\t<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" value=\"ATRANREG\">\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\"\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\" name=\"sql_text_1\" id=\"sql_text_1\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_6\" id=\"sql_text_6\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_4\" id=\"sql_text_4\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" disabled>\n    <input type=\"hidden\" name=\"sql_text_5\" id=\"sql_text_5\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_2\" id=\"sql_text_2\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" disabled>\n\t\n\t\n\t<input type=\"hidden\" name=\"no_of_mandatory_fields\" id=\"no_of_mandatory_fields\" value=\"2\" disabled>\n\t<input type=\"hidden\" name=\"mandatory_fm_1\" id=\"mandatory_fm_1\" value=\"param1##";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" disabled>\n    <input type=\"hidden\" name=\"mandatory_fm_2\" id=\"mandatory_fm_2\" value=\"param2##";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" disabled>\n\t\n\t<input type=\"hidden\" name=\"no_of_compare_date_fields\" id=\"no_of_compare_date_fields\" value=\"1\" disabled>\n\t<input type=\"hidden\" name=\"compare_date_fm_1\" id=\"compare_date_fm_1\" value=\"param1##Operation Date\" disabled>\n    <input type=\"hidden\" name=\"compare_date_to_1\" id=\"compare_date_to_1\" value=\"param2\" disabled>\n\t<input type=\"hidden\" name=\"no_of_comparison_fields\" id=\"no_of_comparison_fields\" value=\"0\" disabled>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'reportParams\' id=\'reportParams\' value=\"param1#param2#param4#param3#param5#param6#param7#param8#param9#param10#param11#param12#param13#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id\">\n</form>\n<script>assignRepParam();</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block5Bytes, _wl_block5);

	
//	String anaesthetist_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Anaesthetist.Label","ot_labels")+",";
//	String surgeon_title  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels")+",";
//	String anaesthesiaType_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AnaesthesiaType.Label","ot_labels")+",";
	
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String anaesthetist_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthetist.label","common_labels");
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	

	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String  sql_anesth = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"'  AND PRACT_TYPE IN ('AN') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";

	String sql_procedure="SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  AND  UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";


	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"'  AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	String  sql_anes_type = "SELECT ANAESTHESIA_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_ANAESTHESIA_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ANAESTHESIA_CODE) LIKE UPPER(?) ORDER BY 2";
	
	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
  
	Connection con = null;
	PreparedStatement	 pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//surgery_date = rst.getString("CURRENT_DATE");
			surgery_date = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		String sql_anest_type = "SELECT ANAESTHESIA_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_ANAESTHESIA_LANG_VW  WHERE LANGUAGE_ID = ? ORDER BY 2";

		pstmt = con.prepareStatement(sql_anest_type);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();


	

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(procedure_title));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(procedure_title));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(procedure_title));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(procedure_title));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 while(rst.next()){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rst.getString(1)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rst.getString(2)));
            _bw.write(_wl_block23Bytes, _wl_block23);
   }//end of while-loop
            }catch(Exception e){
				System.err.println("Err Msg AnesthesiaRegistryReports.jsp "+e.getMessage());
			}finally{
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)
				ConnectionManager.returnConnection(con,request);
		 }
		
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(surgeon_title));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(speciality_title));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(speciality_title));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(anaesthetist_title));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(anaesthetist_title));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sql_anesth));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sql_procedure));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sql_anes_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sql_surgeon));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sql_speciality));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(fromoperationdate));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(tooperationdate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FromOperationDate.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ToOperationDate.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FromProcedure.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ToProcedure.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaType.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthetist.label", java.lang.String .class,"key"));
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
}
