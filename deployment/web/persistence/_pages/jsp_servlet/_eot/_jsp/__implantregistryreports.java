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

public final class __implantregistryreports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ImplantRegistryReports.jsp", 1709120230000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="            \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head><title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/OtReports.js\" ></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/OTReportsLkupSQL.js\"> </script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<!--<script language=\"JavaScript\" src=\"../../eOT/js/OTMessages.js\"></script>-->\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script>\n\t\tvar speciality_title=getLabel(\"Common.speciality.label\",\"common\");\n\t\tvar surgeon_title=getLabel(\"Common.Surgeon.label\",\"Common\");\n\t\tvar implantType_title=getLabel(\"eOT.ImplantType.Label\",\"OT\");\n\t\tvar procedure_title=getLabel(\"Common.Procedures.label\",\"Common\");\n\t\t\n\t\t\n\t</script>\n\n\n<script language=\'javascript\'>\nfunction checkProcess(obj)\n{\n\tvar frmObj=document.forms[0];\n\tif(obj.checked==true)\n\t\t frmObj.param12.value=\'Y\'\n\telse\n\t\t frmObj.param12.value=\'N\'\n\t\t \n}\nfunction decodeLower(obj)\n   {\n            if ( (obj.value==null)||(obj.value==\"\")||(obj.value==\"undefined\") )\n             {\n                 return(\"LOWEST\");\n             }\n            else\n             {\n                 return(obj.value);\n             }\n   }\n\n   function decodeHigher(obj)\n     {\n            if ( (obj.value==null)||(obj.value==\"\")||(obj.value==\"undefined\") )\n             {\n                 return(\"HIGHEST\");\n             }\n            else\n             {\n                 return(obj.value);\n             }\n   }\n\nfunction callExcelDisplay(){\n\tvar frm=window.parent.frames[1];\n\tformObj = document.OtReportOptionsForm;\n\tvar locale = formObj.locale.value;\n\tvar female_value=getLabel(\"Common.female.label\",\"common\");\n\tvar male_value=getLabel(\"Common.male.label\",\"common\");\n\n\tvar qryStr=\"SELECT  B.OPER_NUM, TO_CHAR(B.OPER_DATE, \'DD/MM/YYYY\'), B.PATIENT_ID, decode (\'\"+locale+\"\',\'en\',PATIENT_NAME, NVL(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)) PATIENT_NAME, GET_AGE(C.DATE_OF_BIRTH) AGE,  DECODE(C.SEX, \'M\', \'\"+male_value+\"\', \'F\', \'\"+female_value+\"\') SEX,  C.NATIONAL_ID_NO NRIC, I.SHORT_DESC SPECIALITY,    J.SHORT_NAME , G.LONG_DESC OPER_DESC,  D.SHORT_DESC ||\' \'||  LTRIM(RTRIM(E.PROSTHESIS_CAT_DESC)) ||\',  \'|| LTRIM(RTRIM(F.PROSTHESIS_TYPE_DESC ))   PROS_CATG_TYPE,QUANTITY, DECODE(CONSIGNMENT_ITEM_YN, \'Y\', \'Yes\', \'N\', \'No\', \'No\') CONSIGNMENT_ITEM_YN  ,  PROSTHESIS_MFR, substr(APPL_USER_NAME,1, 15)  RECORDING_NURSE, A.REMARKS      FROM    OT_POST_OPER_HDR  B, MP_PATIENT C,  OT_SURGICAL_ACCESSORIES  A , OT_PROSTHESIS_LANG_VW  D, OT_PROSTHESIS_CATEGORY E, OT_PROSTHESIS_TYPE_LANG_VW F , OT_OPER_MAST  G,  sm_appl_user  H , AM_SPECIALITY_LANG_VW I , AM_PRACTITIONER_LANG_VW J WHERE I.LANGUAGE_ID=\'\"+locale+\"\' AND J.LANGUAGE_ID=\'\"+locale+\"\' AND F.LANGUAGE_ID=\'\"+locale+\"\' AND  B.OPERATING_FACILITY_ID  =  nvl(\'\"+formObj.p_facility_id.value+\"\', B.OPERATING_FACILITY_ID ) AND  B.PATIENT_ID  =  C.PATIENT_ID AND B.OPERATING_FACILITY_ID = A.OPERATING_FACILITY_ID AND     B.OPER_NUM =  A.OPER_NUM AND   TRUNC(B.OPER_DATE)  BETWEEN  TRUNC(nvl(TO_DATE(\'\"+formObj.param1.value+\"\',\'DD/MM/YYYY\'), B.OPER_DATE))   AND TRUNC(nvl(TO_DATE(\'\"+formObj.param2.value+\"\',\'DD/MM/YYYY\'), B.OPER_DATE)) AND A.ACCESSORY_CODE  =  D.PROSTHESIS_CODE  AND    D.PROSTHESIS_CAT_CODE =  E.PROSTHESIS_CAT_CODE (+) AND    D.PROSTHESIS_TYPE = F.PROSTHESIS_TYPE (+) AND D.LANGUAGE_ID=\'\"+locale+\"\'  AND  A.ACCESSORY_TYPE  = \'S\' AND   A.OPER_CODE = G.OPER_CODE AND  A.ADDED_BY_ID = H.APPL_USER_ID(+) AND  B.SPECIALITY_CODE = I.SPECIALITY_CODE AND B.SURGEON_CODE = J.PRACTITIONER_ID(+) AND A.OPER_CODE  BETWEEN  NVL(\'\"+formObj.param3.value+\"\', A.OPER_CODE )  AND NVL(\'\"+formObj.param4.value+\"\', A.OPER_CODE ) AND  A.ACCESSORY_CODE  BETWEEN    NVL(\'\"+formObj.param9.value+\"\', A.ACCESSORY_CODE)   AND   NVL(\'\"+formObj.param10.value+\"\',  A.ACCESSORY_CODE) AND ( (A.PROSTHESIS_MFR  IS NOT NULL AND upper(A.PROSTHESIS_MFR)  =  upper(NVL(\'\"+formObj.param11.value+\"\',  A.PROSTHESIS_MFR)) )  OR  (A.PROSTHESIS_MFR  IS NULL )) AND   NVL(CONSIGNMENT_ITEM_YN , \'N\') =  DECODE(NVL(\'\"+formObj.param12.value+\"\', \'N\'),   \'Y\', \'Y\', \'N\', \'N\') AND  B.SPECIALITY_CODE BETWEEN  NVL(\'\"+formObj.param5.value+\"\' , B.SPECIALITY_CODE)  AND  NVL(\'\"+formObj.param6.value+\"\',  B.SPECIALITY_CODE) AND  B.SURGEON_CODE BETWEEN NVL(\'\"+formObj.param7.value+\"\', B.SURGEON_CODE)   AND  NVL(\'\"+formObj.param8.value+\"\', B.SURGEON_CODE) ORDER BY   B.OPER_DATE , B.OPERATING_FACILITY_ID, B.OPER_NUM \";//MMS-CRF-199-US2\n\n\tvar sql_site_name=\"SELECT SITE_NAME  FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID= \'\"+locale+\"\'\";\n\t\n\tvar sql_facility_name=\"SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE  FACILITY_ID =\'\"+formObj.p_facility_id.value+\"\' \";\n\tvar sql_report_desc=\"SELECT REPORT_DESC FROM SM_REPORT WHERE  REPORT_ID = \'\"+formObj.p_report_id.value+\"\' AND  MODULE_ID  = \'\"+formObj.p_module_id.value+\"\' \";\n    \n\tif(formObj.param11.value==null || formObj.param11.value==\"\")\n        formObj.param11.value=\"All\";\n    if(formObj.chk.checked==true)\n       formObj.chk.value=\"Yes\";\n\telse\n       formObj.chk.value=\"No\";\n\tif(formObj.chk.value==null)\n       formObj.chk.value=\"No\";\n\tif(formObj.param8.value==null || formObj.param8.value==\"\")\n\t\tformObj.param8.value=\"All\";\n\tvar header_Details = \"From Operation Date\"+\"*\"+formObj.param1.value+\"*\"+\"To Operation Date\"+\"*\"+formObj.param2.value+\"*\"+\"From Speciality\"+\"*\"+decodeLower(formObj.param5)+\"*\"+\"To Speciality\"+\"*\"+decodeHigher(formObj.param6)+\"*\"+\"Consignment Item \"+\"*\"+formObj.chk.value+\"#\"+\"From Procedure\"+\"*\"+decodeLower(formObj.param3)+\"*\"+\"To Procedure\"+\"*\"+decodeHigher(formObj.param4)+\"*\"+\"Surgeon\"+\"*\"+formObj.param8.value+\"#\"+\"From Implant Type\"+\"*\"+decodeLower(formObj.param9)+\"*\"+\"To Implant Type\"+\"*\"+decodeHigher(formObj.param10)+\"*\"+\"Implant Vendor\"+\"*\"+formObj.param11.value;\n\n    formObj.header_Details.value=header_Details;\n\n\tformObj.sql_site_name.value=sql_site_name;\n\tformObj.sql_facility_name.value=sql_facility_name;\n\tformObj.sql_report_desc.value=sql_report_desc;\t\n   \n\tformObj.qryStr.value = qryStr;\n\tformObj.noOfCols.value = \"16\";\n\tformObj.method = \'POST\';\n\tformObj.action=\'../../servlet/eOT.OtRegistryReportsServlet\';\n\tformObj.target = \'f_query_add_mod\';\n\tformObj.submit();\n\tfrm.location.reload();\n\t//formObj.action=\"../../eCommon/jsp/report_options.jsp\" ;\n\t//formObj.target=\"messageFrame\";\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\n<!-- <form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\"> -->\n<form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eOT/jsp/OTReportsIntermediate.jsp\"  target=\"messageFrame\">\n\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n\n<tr> \n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\t  <input type=\'text\' name=\'param1\' id=\'param1\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' onkeypress=\"return checkForSpecCharsforID(event);\" onBlur=\"isValidDate(this);\" maxlength=\'10\'>  \n\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param1\');\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t </td>\n\t\t\n\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\t </td>\n\t <td class=\'fields\' width=\'25%\'>\n\t\t  <input type=\'text\' name=\'param2\' id=\'param2\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onkeypress=\"return checkForSpecCharsforID(event);\" onBlur=\"isValidDate(this);\" maxlength=\'10\'>\n\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param2\');\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t </td>\n\t\n</tr>\n\n\n<tr>\n\t <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n</td>\n    <td class=\'fields\' width=\'25%\'>\n\t\t <input type=\'hidden\' name=\'param4\' id=\'param4\'> \n\t\t<input type=\'hidden\' name=\'param3\' id=\'param3\'> \n\t\t<input type=\'text\' name=\'param3_desc\' id=\'param3_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' param1 = \'param3\'  param2 = \'param4\' key =\'PROCEDURE\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param3.value=\'\',param4.value=\'\'\" maxlength=\'70\' onkeypress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'ProcedureLookUp\' id=\'ProcedureLookUp\' onClick=\"callCommonLookup(param3_desc);\" >\n\t</td>\n<!-- \t<td class=\'label\' align=\'right\' nowrap>To Procedure </td>\n\t <td align=\'left\'>\n\t\t <input type=\'hidden\' name=\'param4\' id=\'param4\'> \n\t\t<input type=\'text\' name=\'param4_desc\' id=\'param4_desc\' size=\'20\' > \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'ProcedureLookUp\' id=\'ProcedureLookUp\' onClick=\"searchCode(param4,param4_desc, \'To Procedure\', document.forms[0].sql_text_1.value);\" >\n\t </td> -->\n \n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n</td>\n     <td class=\'fields\' width=\'25%\'>\n\t\t<input type=\'hidden\' name=\'param6\' id=\'param6\'> \n\t\t<input type=\'hidden\' name=\'param5\' id=\'param5\'> \n\t\t<input type=\'text\' name=\'param5_desc\' id=\'param5_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' param1 = \'param5\'  param2 = \'param6\' key =\'SPECIALITY\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param5.value=\'\',param6.value=\'\'\" maxlength=\'70\' onkeypress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'SpecialityLookUp\' id=\'SpecialityLookUp\' onClick=\"callCommonLookup(param5_desc);\" >\n\t</td>\n\t \t \n\n<!-- \t<td class=\'label\' align=\'right\' nowrap>To Speciality </td>\n\t <td align=\'left\'>\n\t\t <input type=\'hidden\' name=\'param6\' id=\'param6\'> \n\t\t<input type=\'text\' name=\'param6_desc\' id=\'param6_desc\' size=\'20\' > \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'SpecialityLookUp\' id=\'SpecialityLookUp\' onClick=\"searchCode(param6,param6_desc, \'To Speciality\', document.forms[0].sql_text_2.value);\" >\n\t </td>\n \t <td colspan=\'2\'></td> -->\n\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td>\n    <td class=\'fields\' width=\'25%\'>\n\t     <input type=\'hidden\' name=\'param8\' id=\'param8\'>\n\t\t<input type=\'hidden\' name=\'param7\' id=\'param7\'> \n\t\t<input type=\'text\' name=\'param7_desc\' id=\'param7_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' param1 = \'param7\'  param2 = \'param8\' key =\'SURGEON\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param7.value=\'\',param8.value=\'\' \" maxlength=\'70\' onkeypress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'SurgeonLookUp\' id=\'SurgeonLookUp\' onClick=\"callCommonLookup(param7_desc);\" >\n\t</td>\n\t<!--<td class=\'label\' align=\'right\' nowrap>To Surgeon </td>\n\t <td align=\'left\'>\n\t\t <input type=\'hidden\' name=\'param8\' id=\'param8\'> \n\t\t<input type=\'text\' name=\'param8_desc\' id=\'param8_desc\' size=\'20\' > \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'SurgeonLookUp\' id=\'SurgeonLookUp\' onClick=\"searchCode(param8,param8_desc, \'To Surgeon\', document.forms[0].sql_text_3.value);\" >\n\n\t </td>-->\n\t\n\n\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </td>\n    <td class=\'fields\' width=\'25%\'>\n\t\t<input type=\'hidden\' name=\'param10\' id=\'param10\'> \n\t\t<input type=\'hidden\' name=\'param9\' id=\'param9\'> \n\t\t<input type=\'text\' name=\'param9_desc\' id=\'param9_desc\' size=\'20\' onBlur=\"if(this.value!=\'\')srchCommonCode(param9,param9_desc,param10,implantType_title, document.forms[0].sql_text_4.value); else param10.value=\'\',param9.value=\'\'\" maxlength=\'70\' onkeypress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'ImplantLookUp\' id=\'ImplantLookUp\' onClick=\"srchCommonCode(param9,param9_desc,param10,implantType_title, document.forms[0].sql_text_4.value);\" >\n\t</td>\n\t\t \t \n\n<!-- \t<td class=\'label\' align=\'right\' nowrap>To Implant Type </td>\n\t <td align=\'left\'>\n\t\t <input type=\'hidden\' name=\'param10\' id=\'param10\'> \n\t\t<input type=\'text\' name=\'param10_desc\' id=\'param10_desc\' size=\'20\' > \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'ImplantLookUp\' id=\'ImplantLookUp\' onClick=\"searchCode(param10,param10_desc, \'To Implant Type\', document.forms[0].sql_text_4.value);\" >\n\t </td> -->\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </td>\n    <td class=\'fields\' width=\'25%\'>\n\t\t<input type=\'text\' name=\'param11\' id=\'param11\' size=\'20\' > \n<!-- \t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'ImplantVendorLookUp\' id=\'ImplantVendorLookUp\' onClick=\"searchCode(param11,param11_desc, \'Implant Vendor\');\" > -->\n\t</td>\n\t\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\t<input type =\'checkbox\' name =\'chk\' onClick=\'checkProcess(this)\'>\n\t\t\n\t\n\t<!-- <input type=\"BUTTON\" class=\"button\" name=\"Submit\" id=\"Submit\" value=\'Report in Excel Format\' onClick=\"callExcelDisplay();\"> \n </td>\n  -->\n \t<image src=\'../../eOT/images/excel.gif\' onClick=\"callExcelDisplay();\" width=\"15\" height=\"15\" title=\"Report in Excel Format\" >\n\t\n\t</td>\n \n  \n\t \n</tr>\n     \n\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"header_Details\" id=\"header_Details\" value=\"\">\n\t<input type=\"hidden\" name=\"sql_site_name\" id=\"sql_site_name\" value=\"\">\n\t<input type=\"hidden\" name=\"sql_facility_name\" id=\"sql_facility_name\" value=\"\">\n\t<input type=\"hidden\" name=\"sql_report_desc\" id=\"sql_report_desc\" value=\"\">\n\t<input type=\"hidden\" name=\"qryStr\" id=\"qryStr\" value=\"\">\n\t<input type=\"hidden\" name=\"noOfCols\" id=\"noOfCols\" value=\"\">\n\t<input type=\"hidden\" name=\"p_user_id\" id=\"p_user_id\"\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\"\tvalue=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"  value=\"OT\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"OTRIMPRY\">\n\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\"\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" value=\"OTRIMPRY\">\n\t<input type=\"hidden\" name=\"sql_text_4\" id=\"sql_text_4\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_5\" id=\"sql_text_5\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" disabled>\n\n\t<input type=\"hidden\" name=\"no_of_mandatory_fields\" id=\"no_of_mandatory_fields\" value=\"2\" disabled>\n\t<input type=\"hidden\" name=\"mandatory_fm_1\" id=\"mandatory_fm_1\" value=\"param1##";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" disabled>\n    <input type=\"hidden\" name=\"mandatory_fm_2\" id=\"mandatory_fm_2\" value=\"param2##";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" disabled>\n<!-- Validatiosn is removed for CRF-45 as per dilip instruction on 09/06/2010 -->\n\t<!-- <input type=\"hidden\" name=\"no_of_compare_date_fields\" id=\"no_of_compare_date_fields\" value=\"1\" disabled>\n\t<input type=\"hidden\" name=\"compare_date_fm_1\" id=\"compare_date_fm_1\" value=\"param1##Operation Date\" disabled>\n    <input type=\"hidden\" name=\"compare_date_to_1\" id=\"compare_date_to_1\" value=\"param2\" disabled> -->\n\n\t<input type=\"hidden\" name=\"no_of_comparison_fields\" id=\"no_of_comparison_fields\" value=\"3\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_1\" id=\"compare_fm_1\" value=\"param3##Procedure\" disabled>\n\t<input type=\"hidden\" name=\"compare_to_1\" id=\"compare_to_1\" value=\"param4\" disabled>\n\n\t<input type=\"hidden\" name=\"compare_fm_2\" id=\"compare_fm_2\" value=\"param5##Speciality\" disabled>\n\t<input type=\"hidden\" name=\"compare_to_2\" id=\"compare_to_2\" value=\"param6\" disabled>\n\n\t<input type=\"hidden\" name=\"compare_fm_3\" id=\"compare_fm_3\" value=\"param9##Implant Type\" disabled>\n\t<input type=\"hidden\" name=\"compare_to_3\" id=\"compare_to_3\" value=\"param10\" disabled>\n\t<input type=\"hidden\" name=\"param12\" id=\"param12\" value=\"N\" >\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\'hidden\' name=\'reportParams\' id=\'reportParams\' value=\"param1#param2#param4#param3#param6#param5#param7#param8#param9#param10#param11#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id\">\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
locale=locale.toLowerCase();

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String procedure_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");

	String surgery_date = "";
	
	String  sql_implanttype = "SELECT A.PROSTHESIS_CODE CODE, A.SHORT_DESC DESCRIPTION FROM OT_PROSTHESIS_LANG_VW A  WHERE UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.PROSTHESIS_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID='"+locale+"'  ORDER BY 2";

	String  sql_implantvendor = "SELECT A.PROSTHESIS_MFR CODE, null DESCRIPTION FROM OT_SURGICAL_ACCESSORIES A  WHERE UPPER(A.PROSTHESIS_MFR) LIKE UPPER(?) ORDER BY 1";

	if(facility_id == null) facility_id="";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//surgery_date = rst.getString("CURRENT_DATE");
			//Buddhist date conversion (Thai Locale)
			surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);

		}
	}
	catch(Exception e){
		System.err.println("Err Msg ImplantRegistryReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }


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

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(speciality_title));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(surgeon_title));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sql_implanttype));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sql_implantvendor));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(fromoperationdate));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tooperationdate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ImplantType.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ImplantVendor.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsignmentItem.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
