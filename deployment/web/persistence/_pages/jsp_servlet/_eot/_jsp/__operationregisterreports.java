package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import eOT.Common.*;

public final class __operationregisterreports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperationRegisterReports.jsp", 1709120268000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="             \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="    \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head><title></title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script src=\"../../eOT/js/OtReports.js\" ></script>\n\t<script src=\"../../eOT/js/OTReportsLkupSQL.js\" ></script>\n\t<script src=\"../../eCommon/js/common.js\" ></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n<script language=\"javascript\">\n  function checkval() {\n\t\tvar frmObj=document.forms[0];\n\t\tif (frmObj.param18_desc.value == null || frmObj.param18_desc.value == \"\"){\n\t\t\tfrmObj.param18.value = \"\";\n\t\t\tfrmObj.param19.value = \"\";\n\t\t}\n\t\tif (((frmObj.param18.value != null) && (frmObj.param18.value !=\"\"))\n\t\t&& ((frmObj.param19.value == null) || (frmObj.param19.value ==\"\")))\n\t\t{\n\t\t\tfrmObj.param19.value = frmObj.param18.value; \n\t\t}\n  } \n  \n  function decodeLower(obj)\n   {\n            if ( (obj.value==null)||(obj.value==\"\")||(obj.value==\"undefined\") )\n             {\n                 return(\"LOWEST\");\n             }\n            else\n             {\n                 return(obj.value);\n             }\n   }\n\n   function decodeHigher(obj)\n     {\n            if ( (obj.value==null)||(obj.value==\"\")||(obj.value==\"undefined\") )\n             {\n                 return(\"HIGHEST\");\n             }\n            else\n             {\n                 return(obj.value);\n             }\n   }\n\n\nfunction callExcelDisplay(){\n\tvar frm=window.parent.frames[1];\n\tformObj = document.OtReportOptionsForm;\n\t//Modified against SRR20056-SCF-12442 - Submitting dummy Form \n\ttmpformObj = document.dummy1;\n\tvar locale = formObj.locale.value;\n\t//Added by  SRR20056-SCF-12442 @ Bangkok by MuthuN on 2/10/2014\n\t\n\tvar qryStr = \"SELECT  A.OPERATING_FACILITY_ID, A.OPER_NUM, sm_convert_date_2t (a.oper_date,\'\"+formObj.locale.value+\"\') oper_date /*TO_CHAR(A.OPER_DATE, \'DD/MM/YYYY\')*/ , A.PATIENT_ID,  decode (\'\"+formObj.locale.value+\"\',\'en\',B.PATIENT_NAME, NVL(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)) SHORT_NAME,  DECODE(B.SEX, \'M\', \'Male\', \'F\', \'Female\')  SEX,  GET_AGE(B.DATE_OF_BIRTH) AGE, B.NATIONAL_ID_NO  NRIC, A.REF_SOURCE_CODE  ,  R.SHORT_DESC RACE_DESC,  decode(A.NATURE_TYPE, \'EL\', \'Elective\', \'EM\', \'Emergency\') NATURE_TYPEM , PRE_OPER_DIAG, POST_OPER_DIAG,  H.SHORT_DESC ANESTH_DESC , C.OPER_NUM DTL_OPER_NUM, E.LONG_DESC ||\'(\'|| J.SHORT_DESC||\')\'   OPER_DESC,decode(c.OPER_ADDED_IN_SURGEON_NOTES_YN,\'Y\',\'Yes\',\'N\',\'No\') FROM  OT_POST_OPER_HDR  A,  MP_PATIENT B ,  MP_RACE R, OT_POST_OPER_DTLS C , OT_OPER_MAST E ,  AM_ANAESTHESIA H , OT_OPER_TYPE_LANG_VW  J, OT_POST_OPER_DIAG K  WHERE  J.LANGUAGE_ID=\'\"+formObj.locale.value+\"\' AND A.OPERATING_FACILITY_ID  =  NVL(\'\"+formObj.p_facility_id.value+\"\' ,A.OPERATING_FACILITY_ID)        AND  A.PATIENT_ID  = B.PATIENT_ID AND A.PATIENT_ID  =  NVL(\'\"+formObj.p_patient_id.value+\"\',A.PATIENT_ID)  AND B.RACE_CODE = R.RACE_CODE(+)  AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID(+) AND A.OPER_NUM = C.OPER_NUM(+) AND A.OPERATING_FACILITY_ID = K.OPERATING_FACILITY_ID(+) AND A.OPER_NUM = K.OPER_NUM(+) AND C.OPER_CODE = E.OPER_CODE  AND A.ANESTHESIA_CODE = H.ANAESTHESIA_CODE(+) AND  E.OPER_TYPE_CODE =  J.OPER_TYPE(+) AND A.NATURE_CODE  =  DECODE(\'\"+formObj.param7.value+\"\', \'A\',  A.NATURE_CODE,  \'\"+formObj.param7.value+\"\' ) AND A.SPECIALITY_CODE  BETWEEN   NVL(\'\"+formObj.param8.value+\"\', A.SPECIALITY_CODE)   AND   NVL(\'\"+formObj.param9.value+\"\', A.SPECIALITY_CODE) AND   TRUNC(A.OPER_DATE)   BETWEEN  TRUNC(TO_DATE(\'\"+formObj.param1.value+\"\', \'dd/mm/yyyy\'))   AND TRUNC(TO_DATE(\'\"+formObj.param2.value+\"\', \'dd/mm/yyyy\')) AND  OPER_STATUS   =  DECODE(NVL(\'\"+formObj.param13.value+\"\', \'A\'), \'A\',  A.OPER_STATUS,  \'\"+formObj.param13.value+\"\') AND  (A.OPERATING_FACILITY_ID , A.OPER_NUM) IN (SELECT OPERATING_FACILITY_ID ,  OPER_NUM   FROM  OT_POST_OPER_DTLS Y,  OT_OPER_MAST  X   WHERE  Y.OPER_CODE  = X.OPER_CODE   AND  Y.OPER_CODE  BETWEEN   NVL(\'\"+formObj.param3.value+\"\',  Y.OPER_CODE)   AND   NVL(\'\"+formObj.param4.value+\"\',  Y.OPER_CODE)   AND  X.OPER_TYPE_CODE  BETWEEN  NVL(\'\"+formObj.param5.value+\"\', X.OPER_TYPE_CODE)  AND NVL(\'\"+formObj.param6.value+\"\', X.OPER_TYPE_CODE)  )\";//AAKH-CRF-90 & MMS-CRF-199-US2\n\n\tif((formObj.param18.value!=null && formObj.param18.value!=\"\"))\n\t\tqryStr = qryStr+\" AND K.DIAG_CODE BETWEEN  NVL(\'\"+formObj.param18.value+\"\', K.DIAG_CODE)  AND  NVL(\'\"+formObj.param18.value+\"\', K.DIAG_CODE) \" ;\n\n    qryStr = qryStr+\" ORDER BY OPER_DATE,    A.OPER_NUM, C.OPER_NUM,  A.PATIENT_ID\";\n\n   \tvar sql_site_name=\"SELECT SITE_NAME  FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID= \'\"+locale+\"\'\";\n\tvar sql_facility_name=\"SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE  FACILITY_ID =\'\"+formObj.p_facility_id.value+\"\' \";\n\tvar sql_report_desc=\"SELECT REPORT_DESC FROM SM_REPORT WHERE  REPORT_ID = \'\"+formObj.p_report_id.value+\"\' AND  MODULE_ID  = \'\"+formObj.p_module_id.value+\"\' \";\n\n\tif(formObj.param13_desc.value==null || formObj.param13_desc.value==\"\")\n        formObj.param13_desc.value=\"All\";\n\tif(formObj.param10.value==null || formObj.param10.value==\"\")\n\t\tformObj.param10.value=\"All\";\n\tif(formObj.param18.value==null || formObj.param18.value==\"\")\n\t\tformObj.param18.value=\"All\";\n    if(formObj.param14.value==null || formObj.param14.value==\"\")\n\t\tformObj.param14.value=\"All\";\n\tvar fromoperationdate\t=getLabel(\"eOT.FromOperationDate.Label\",\"OT\");\n\tvar tooperationdate\t\t=getLabel(\"eOT.ToOperationDate.Label\",\"OT\");\n\tvar fromSpeciality\t\t=getLabel(\"eOT.FromSpeciality.Label\",\"OT\");\n\tvar tospeciality\t\t=getLabel(\"eOT.ToSpeciality.Label\",\"OT\");\n\tvar\tsurgeon\t\t\t\t=getLabel(\"Common.Surgeon.label\",\"Common\");\n\tvar fromProcedure\t\t=getLabel(\"eOT.FromProcedure.Label\",\"OT\");\n\tvar toprocedure\t\t\t=getLabel(\"eOT.ToProcedure.Label\",\"OT\");\n\tvar\tdiagnosis\t\t\t=getLabel(\"Common.diagnosis.label\",\"Common\");\n\tvar anaesthetist\t\t=getLabel(\"Common.Anaesthetist.label\",\"Common\");\n\tvar fromOperationType\t=getLabel(\"eOT.FromOperationType.Label\",\"OT\");\n\tvar\tfromProcedure\t\t=getLabel(\"eOT.FromProcedure.Label\",\"OT\");\n\tvar toOperationType\t\t=getLabel(\"eOT.ToOperationType.Label\",\"OT\");\n\tvar status\t\t\t\t=getLabel(\"Common.status.label\",\"Common\");\n\t\n\t//57891\n\tvar p1=convertDate(formObj.param1.value,\'DMY\',\'en\',locale);\t\t\n\tvar p2=convertDate(formObj.param2.value,\'DMY\',\'en\',locale);\n\t//57891\n\t\n\tvar header_Details = fromoperationdate+\"*\"+p1+\"*\"+tooperationdate+\"*\"+p2+\"*\"+fromSpeciality+\"*\"+decodeLower(formObj.param8)+\"*\"+tospeciality+\"*\"+decodeHigher(formObj.param9)+\"*\"+surgeon+\"*\"+nullSafe(formObj.param10.value)+\"#\"+fromProcedure+\"*\"+decodeLower(formObj.param3)+\"*\"+toprocedure+\"*\"+decodeHigher(formObj.param4)+\"*\"+diagnosis+\"*\"+formObj.param18.value+\"*\"+anaesthetist+\"*\"+formObj.param14.value+\"#\"+fromOperationType+\"*\"+decodeLower(formObj.param5)+\"*\"+toOperationType+\"*\"+decodeHigher(formObj.param6)+\"*\"+status+\"*\"+formObj.param13_desc.value;//57891\n\t// Modified against SCF-12442 - Start\n\ttmpformObj.header_Details.value=header_Details;\n\ttmpformObj.sql_site_name.value=sql_site_name;\n\ttmpformObj.sql_facility_name.value=sql_facility_name;\n\ttmpformObj.sql_report_desc.value=sql_report_desc;\n\ttmpformObj.qryStr.value = qryStr;\n\ttmpformObj.noOfCols.value = \"15\";\n\ttmpformObj.method = \'POST\';\n\t\n\ttmpformObj.action=\'../../servlet/eOT.OtRegistryReportsServlet\';\n\t\n\ttmpformObj.target = \'f_query_add_mod\';\n\ttmpformObj.submit();\n\tfrm.location.reload();//57891\n\t// Modified against SCF-12442 - End\n}\n\nfunction nullSafe(str){\n\treturn (str!=null)?str:\"\";\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<table>\n<form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eOT/jsp/OTReportsIntermediate.jsp\"  target=\"messageFrame\">\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n<tr> \n\t  <td class=\'label\' width=\"16%\"nowrap>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\t  </td>\n\t  <td class=\'fields\' width=\"41%\">\n\t  <!-- Added against 57891 Starts -->\n\t\t  <input type=\'text\' name=\'param1_disp\' id=\'param1_disp\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onKeyPress=\"return checkForSpecCharsforID(event);\" onBlur=\"isValidDate(this);\" maxlength=\'10\'>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param1_disp\');\">\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t<input type=\'hidden\' name=\'param1\' id=\'param1\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t </td>\n\t\t\n\t  <td class=\'label\' width=\"18%\"  nowrap>\n\t\t  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\t  </td>\n\t  <td class=\'fields\' width=\"25%\" >\n\t\t  <input type=\'text\' name=\'param2_disp\' id=\'param2_disp\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onKeyPress=\"return checkForSpecCharsforID(event);\" onBlur=\"isValidDate(this);\" maxlength=\'10\'>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param2_disp\');\">\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t<input type=\'hidden\' name=\'param2\' id=\'param2\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<!-- Added against 57891 Ends -->\t\t\t\n\t </td>\n\t <td width=\"0%\" colspan=\'2\'></td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\"16%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</td>\n     <td class=\'fields\' width=\"41%\" >\n\t\t<input type=\'hidden\' name=\'param4\' id=\'param4\' value=\"\"> \n\t\t<input type=\'hidden\' name=\"param3\" id=\"param3\" value=\"\"> \n\t\t<input type=\'text\' name=\'param3_desc\' id=\'param3_desc\' size=\'00\' title=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' param1 = \'param3\'  param2 = \'param4\' key =\'PROCEDURE\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param3.value=\'\',param4.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperCodeLookUp\' id=\'OperCodeLookUp\' \n\t\tonClick=\"callCommonLookup(param3_desc);\" >\n\t</td>\t\t\n\t\t<td class=\'fields\' width=\"18%\" nowrap>\t\t\n\t</td>\n\t\t<td class=\'fields\' width=\"25%\" nowrap>\t\t\n\t</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\"16%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</td>\n     <td class=\'fields\' width=\"41%\" >\n\t\t<input type=\'hidden\' name=\'param6\' id=\'param6\'> \n\t\t<input type=\'hidden\' name=\'param5\' id=\'param5\'> \n\t\t<input type=\'text\' name=\'param5_desc\' id=\'param5_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' param1 = \'param5\'  param2 = \'param6\' key =\'OPER_TYPE\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param5.value=\'\',param6.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'OperTypeLookUp\' id=\'OperTypeLookUp\' onClick=\"callCommonLookup(param5_desc);\" >\n\t</td>\n\t\t<td class=\'fields\' width=\"18%\" nowrap>\t\t\n\t</td>\n\t\t<td class=\'fields\' width=\"25%\" nowrap>\t\t\n\t</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\"16%\">\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>\n     <td class=\'fields\' width=\"41%\"  >\n\t\t <input type=\'hidden\' name=\'param9\' id=\'param9\'> \n\t\t<input type=\'hidden\' name=\'param8\' id=\'param8\'> \n\t\t<input type=\'text\' name=\'param8_desc\' id=\'param8_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' param1 = \'param8\'  param2 = \'param9\' key =\'SPECIALITY\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param8.value=\'\',param9.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'SpecialityLookUp\' id=\'SpecialityLookUp\' onClick=\"callCommonLookup(param8_desc);\" >\n\t</td>\n\t\t<td class=\'fields\' width=\"18%\" nowrap>\t\t\n\t</td>\n\t\t<td class=\'fields\' width=\"25%\" nowrap>\t\t\n\t</td>\n</tr>\t \n\n<tr>\n\t<td class=\'label\' width=\"16%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t</td>\n     <td class=\'fields\' width=\"41%\"  >\n\t\t<input type=\'hidden\' name=\'param19\' id=\'param19\'> \n\t\t<input type=\'hidden\' name=\'param18\' id=\'param18\'> \n\t\t<input type=\'text\' name=\'param18_desc\' id=\'param18_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' param1 = \'param18\'  param2 = \'param19\' key =\'DIAGNOSIS\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param18.value=\'\',param19.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'DiagnosisLookUp\' id=\'DiagnosisLookUp\' onClick=\"callCommonLookup(param18_desc);checkval();\" >\n\t</td>\n\t\t<td class=\'fields\' width=\"18%\" nowrap>\t\t\n\t</td>\n\t\t<td class=\'fields\' width=\"25%\" nowrap>\t\t\n\t</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\"16%\"nowrap>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t</td>\n     <td class=\'fields\' width=\"41%\"  >\n\t     <input type=\'hidden\' name=\'param11\' id=\'param11\' > \n\t\t<input type=\'hidden\' name=\'param10\' id=\'param10\'> \n\t\t<input type=\'text\' name=\'param10_desc\' id=\'param10_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' param1 = \'param10\'  param2 = \'param11\' key =\'SURGEON\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param10.value=\'\',param11.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'SurgeonLookUp\' id=\'SurgeonLookUp\' onClick=\"callCommonLookup(param10_desc);\" >\n\t</td>\n\t\t<td class=\'fields\' width=\"18%\" nowrap>\t\t\n\t</td>\n\t\t<td class=\'fields\' width=\"25%\" nowrap>\t\t\n\t</td>\n</tr>\n\n<tr>\n<td class=\'label\' width=\"16%\"nowrap>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</td>\n     <td class=\'fields\' width=\"41%\"  >\n\t    <input type=\'hidden\' name=\'param15\' id=\'param15\'> \n\t\t<input type=\'hidden\' name=\'param14\' id=\'param14\'> \n\t\t<input type=\'text\' name=\'param14_desc\' id=\'param14_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' param1 = \'param14\'  param2 = \'param15\' key =\'ANAESTHETIST\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param14.value=\'\',param15.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'AnaesthetistLookUp\' id=\'AnaesthetistLookUp\' onClick=\"callCommonLookup(param14_desc);\" >\n\t</td>\n\t    <td class=\'fields\' width=\"18%\" nowrap>\n\t</td>\n\t\t<td class=\'fields\' width=\"25%\" nowrap>\t\n\t</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\"16%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t</td>\n\t <td class=\'fields\' width=\"41%\" nowrap >\n\t\t<input type=\'hidden\' name=\'param13\' id=\'param13\'> \n\t\t<input type=\'text\' name=\'param13_desc\' id=\'param13_desc\' size=\'20\' onBlur=\"if(this.value!=\'\')searchCode(param13,param13_desc, \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\', document.forms[0].sql_text_5.value); else param13.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'StatusLookUp\' id=\'StatusLookUp\' onClick=\"searchCode(param13,param13_desc, \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\', document.forms[0].sql_text_5.value);\" >\n\t</td>\n\t\t<td class=\'fields\' width=\"18%\" nowrap>\n\t</td>\n\t\t<td class=\'fields\' width=\"25%\" nowrap>\t\n\t</td>\n</tr>\n\n<tr>\n\n\t<td class=\'label\' width=\"16%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \n\t</td>\n\t<td class=\'fields\' width=\"41%\">\n\t <select name=\"param7\" id=\"param7\" >  \n\t <option value=\"A\">\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="  </option>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<option value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'> ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" </option>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t </select>\n\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t </td>\n\t\t <td class=\'fields\' width=\"18%\" nowrap>\n\t </td>\n\t\t<td class=\'fields\' width=\"25%\" nowrap>\t\n\t</td>\n</tr>\n\n<tr> \n<td  class=\'label\'  width=\"16%\">\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t<td align=\'left\'>\n\t\t<input type=\'text\' name=\'p_patient_id\' id=\'p_patient_id\' maxlength=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' size=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value= \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onBlur=\"if(this.value!=\'\')callPatientSearch();else clearDesc();\" onKeyPress=\"return CheckForSpecChars(event)\">\n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'surButton\' id=\'surButton\' onClick=\"callPatientSearch();\" maxlength=\'70\'>\n\t</td>\n\t\t<td class=\'fields\' width=\"18%\" nowrap>\n\t</td>\n\t\t<td class=\'fields\' width=\"25%\" nowrap>\t\n\t</td>\n</tr>\n\n<tr>\n\t<td  class=\'label\'  width=\"16%\">\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t</td>\n\t<td align=\'left\'>\n\t\t<input type=\'text\' name=\'patientname\' id=\'patientname\' maxlength=\'60\' size=\'30\' value= \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" readonly>\n\t</td>\n\t\t<td class=\'label\' width=\'18%\' ></td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'16%\'>\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t</td>\n      <td class=\'fields\' width=\'41%\'>\n\t\t <input type=\'hidden\' name=\'param22\' id=\'param22\' value=\'\'> \n\t\t <input type=\'hidden\' name=\'p_nursing_unit_code\' id=\'p_nursing_unit_code\'>\n\t\t <!-- ML-MMOH-CRF-0752.3-US001 -->\n\t\t <input type=\'text\' name=\'param9_desc\' id=\'param9_desc\' size=\'67\' title=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' param1 = \'p_nursing_unit_code\'  param2 = \'param22\' key =\'WARD\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param22.value=\'\',p_nursing_unit_code.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t <input type=\'button\' class=\'button\' value=\'?\' name=\'SurgeonLookUp\' id=\'SurgeonLookUp\' onClick=\"callCommonLookup(param9_desc);\" >\n\t</td>\n\t<td class=\'fields\' width=\"18%\" > \n\t\t<image src=\'../../eOT/images/excel.gif\' onClick=\"callExcelDisplay();\" width=\"15\" height=\"15\" title=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'  >\n\t</td>\n\t</tr>\n</table>\n\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"qryStr\" id=\"qryStr\" value=\"\">\n\t<input type=\"hidden\" name=\"header_Details\" id=\"header_Details\" value=\"\">\n\t<input type=\"hidden\" name=\"noOfCols\" id=\"noOfCols\" value=\"\">\n\t<input type=\"hidden\" name=\"sql_site_name\" id=\"sql_site_name\" value=\"\">\n\t<input type=\"hidden\" name=\"sql_facility_name\" id=\"sql_facility_name\" value=\"\">\n\t<input type=\"hidden\" name=\"sql_report_desc\" id=\"sql_report_desc\" value=\"\">\n\t<input type=\"hidden\" name=\"p_user_id\" id=\"p_user_id\"\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"  value=\"OT\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"OTROPREG\">\n\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\"\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n\t<input type=\"hidden\" name=\"p_loc_type\" id=\"p_loc_type\" id=\"p_currn_locn\"  value=\"N\" ><!--SRR20056-SCF-15511-->\n\t<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" value=\"OTROPREG\">\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\"\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"sql_text\" id=\"sql_text\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_1\" id=\"sql_text_1\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" disabled>\n\t<input type=\"hidden\" name=\"z\" id=\"z\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_3\" id=\"sql_text_3\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_4\" id=\"sql_text_4\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_5\" id=\"sql_text_5\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_6\" id=\"sql_text_6\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" disabled>\n\t<input type=\"hidden\" name=\"sql_text_7\" id=\"sql_text_7\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" disabled>\n\t<input type=\"hidden\" name=\"no_of_mandatory_fields\" id=\"no_of_mandatory_fields\" value=\"2\" disabled>\n\t<input type=\"hidden\" name=\"mandatory_fm_1\" id=\"mandatory_fm_1\" value=\"param1##";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" disabled>\n    <input type=\"hidden\" name=\"mandatory_fm_2\" id=\"mandatory_fm_2\" value=\"param2##";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" disabled>\n\t<input type=\"hidden\" name=\"no_of_compare_date_fields\" id=\"no_of_compare_date_fields\" value=\"1\" disabled>\n\t<input type=\"hidden\" name=\"compare_date_fm_1\" id=\"compare_date_fm_1\" value=\"param1##Operation Date\" disabled>\n    <input type=\"hidden\" name=\"compare_date_to_1\" id=\"compare_date_to_1\" value=\"param2\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_1\" id=\"compare_fm_1\" value=\"param3##Procedure\" disabled>\n    <input type=\"hidden\" name=\"compare_to_1\" id=\"compare_to_1\" value=\"param4\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_2\" id=\"compare_fm_2\" value=\"param5##Operation Type\" disabled>\n    <input type=\"hidden\" name=\"compare_to_2\" id=\"compare_to_2\" value=\"param6\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_3\" id=\"compare_fm_3\" value=\"param8##Speciality\" disabled>\n    <input type=\"hidden\" name=\"compare_to_3\" id=\"compare_to_3\" value=\"param9\" disabled>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\'hidden\' name=\'nursingUnitTitle\' id=\'nursingUnitTitle\' id=\"nursingUnitTitle\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\'hidden\' name=\'reportParams\' id=\'reportParams\' value=\"param1#param2#param4#param3#param5#param6#param7#param8#param9#param18#param19#param10#param11#param14#param15#param13#p_patient_id#param22#p_nursing_unit_code#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id#p_loc_type\">\n</form>\n<!-- Modified against SCF-12442 - Included dummy Form:: -->\n<form name=\"dummy1\" id=\"dummy1\">\n\t<input type=\'hidden\' name=\'param3\' id=\'param3\'> \n\t<input type=\'hidden\' name=\'param4\' id=\'param4\'> \n\t<input type=\'hidden\' name=\'param5\' id=\'param5\'> \n\t<input type=\'hidden\' name=\'param6\' id=\'param6\'> \n\t<input type=\'hidden\' name=\'param7\' id=\'param7\'> \n\t<input type=\'hidden\' name=\'param8\' id=\'param8\'> \n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" value=\"OTROPREG\">\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\"\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" disabled>\n\t<input type=\"hidden\" name=\"no_of_compare_date_fields\" id=\"no_of_compare_date_fields\" value=\"1\" disabled>\n\t<input type=\"hidden\" name=\"compare_date_fm_1\" id=\"compare_date_fm_1\" value=\"param1##Operation Date\" disabled>\n   \t<input type=\"hidden\" name=\"compare_date_to_1\" id=\"compare_date_to_1\" value=\"param2\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_1\" id=\"compare_fm_1\" value=\"param3##Procedure\" disabled>\n   \t<input type=\"hidden\" name=\"compare_to_1\" id=\"compare_to_1\" value=\"param4\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_2\" id=\"compare_fm_2\" value=\"param5##Operation Type\" disabled>\n    <input type=\"hidden\" name=\"compare_to_2\" id=\"compare_to_2\" value=\"param6\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_3\" id=\"compare_fm_3\" value=\"param8##Speciality\" disabled>\n   \t<input type=\"hidden\" name=\"compare_to_3\" id=\"compare_to_3\" value=\"param9\" disabled>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\'hidden\' name=\'reportParams\' id=\'reportParams\' value=\"param1#param2#param4#param3#param5#param6#param7#param8#param9#param18#param19#param10#param11#param14#param15#param13#p_patient_id#param22#p_nursing_unit_code#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String operationType_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationType.Label","ot_labels");
	String speciality_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String diagnosis_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String anesthetist_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthetist.label","common_labels");
	String Procedure_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String status_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String strPatientId = checkForNull(request.getParameter("p_patient_id"));
	String surgery_date = "";
	String strPatientName="";
	if(facility_id == null) facility_id="";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"'   ORDER BY 2";

	String  sql_oper_procedure = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";
	String  sql_oper_type = "SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE_LANG_VW WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 2";
	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	String  sql_anaesthetist = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('AN') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	String sql_status = "SELECT STATUS_CODE CODE, STATUS_DESC DESCRIPTION FROM OT_STATUS WHERE UPPER(STATUS_DESC) LIKE UPPER(?) AND UPPER(STATUS_CODE) LIKE UPPER(?) ORDER BY 2";
	String sql_diagnosis = "SELECT DIAG_CODE CODE, SHORT_DESC DESCRIPTION FROM MR_ICD_CODE WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(DIAG_CODE) LIKE UPPER(?) ORDER BY 2";

	String sql_ward="SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND EFF_STATUS = 'E' ORDER BY 2 ";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	ResultSet rs = null;
	String PatIDLen="";
	con = ConnectionManager.getConnection(request);
	try{
		String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
		pstmt=con.prepareStatement(sqlLen);
		rs=pstmt.executeQuery();
			while(rs.next() && rs!=null)
			{
			PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception  ee){ee.printStackTrace();}
	try{		
			pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			rst = pstmt.executeQuery();
			while(rst.next()){
				surgery_date = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			}		
			if(pstmt!=null) pstmt.close();
			if(rst!=null) rst.close();
			pstmt = con.prepareStatement(sql_surgery_type);
			rst = pstmt.executeQuery();

            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(DateUtils.convertDate(surgery_date,"DMY",locale,"en")));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(DateUtils.convertDate(surgery_date,"DMY",locale,"en")));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Procedure_title));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(operationType_title));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(speciality_title));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(diagnosis_title));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(surgeon_title));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(anesthetist_title ));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(status_title));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(status_title));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 while(rst.next()){ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rst.getString(1)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rst.getString(2)));
            _bw.write(_wl_block35Bytes, _wl_block35);
   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg TheatreBkgStatByOtRoomReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
        if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
	

            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ward_title));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sql_oper_procedure));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(sql_oper_type));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(sql_speciality));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(sql_surgeon));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(sql_anaesthetist));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(sql_status));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(sql_diagnosis));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(sql_ward));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(fromoperationdate));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(tooperationdate));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(ward_title));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sql_oper_procedure));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(sql_oper_type));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(sql_speciality));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(sql_surgeon));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(sql_anaesthetist));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(sql_status));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(sql_diagnosis));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(sql_ward));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(fromoperationdate));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(tooperationdate));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block66Bytes, _wl_block66);
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationType.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthetist.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SurgeryType.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ReportinExcelFormat.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
