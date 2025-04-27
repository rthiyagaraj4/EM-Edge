package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.XHDBAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eXH.XHUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __mediclaimseligibilitypopup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/MediClaimsEligibilityPopUp.jsp", 1733051399089L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\n<head>\n\n\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'></link>\t\t      \n\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/jquery-3.6.3.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<title> Patient Eligibility Check </title>\n\n<script>\nvar err_code=\"\";\nvar response_str=\"\";\nfunction eligibilityCheck()\n{\n\tvar responseMsg = \"\";\n\n\tvar patientId = document.forms[0].patient_id.value;\n\n\tvar encounterId = document.forms[0].encounterId.value;\n\n\tvar episodeId = document.forms[0].episodeId.value;\n\n\tvar patientName = document.forms[0].patient_name.value;\n\tvar sex = document.forms[0].sex.value;\n\tvar nationalId = document.forms[0].nationalId.value;\n\n\tvar patientClass = document.forms[0].patient_cls_episode.value;\n\tvar visitAdmissionDate = document.forms[0].visitAdmissionDt.value;\n\tvar locationType = document.forms[0].locationType.value;\n\n\tvar serviceCode = document.forms[0].serviceCode.value;\n\tvar specialityCode = document.forms[0].speciality_code.value;\n\tvar custCode = document.forms[0].custCode.value;\t\t\t\t\t\n\n\tvar firstName = document.forms[0].firstName.value;\n\tvar secondName = document.forms[0].secondName.value;\n\tvar initial = document.forms[0].initial.value;\n\tvar familyName = document.forms[0].familyName.value;\n\tvar dob = document.forms[0].dob.value;\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar visit_id=document.forms[0].visit_id.value;\n\t\n\tvar checkType = document.forms[0].checkType.value;\n\tvar membership_number = document.getElementById(\"membership_number\").value;\n\tvar wca_num = document.getElementById(\"p_wca_num\").value ;\n\tvar dependant_num = document.getElementById(\"p_dependant_num\").value;\n\tvar dependant_relation = document.getElementById(\"p_dependant_relation\").value; \n\tvar dest_code = document.getElementById(\"destCode\").value; \n\n\tvar m_surname = document.getElementById(\"p_surname\").value; \n\tvar m_intial = document.getElementById(\"p_intial\").value; \n\n\tvar AddedByFacilityId = document.getElementById(\"AddedByFacilityId\").value ;\n\tvar AddedByUserId = document.getElementById(\"AddedByUserId\").value;\n\tvar WorkstationNo = document.getElementById(\"WorkstationNo\").value; \n    document.forms[0].episodeId.value =episodeId;\n\tdocument.forms[0].episode_type.value =episode_type;\n\n\tvar blng_grp_id=document.forms[0].blng_grp_id.value;\n\tvar admission_type = document.forms[0].admission_type.value;\n\tvar settlement_ind=document.forms[0].settlement_ind.value;\n\n\tif(!(membership_number != null && membership_number != \"\" && membership_number != \" \") && checkType != \"IDC\" && checkType != \"UEC\")\n\t{ \n\t\talert(\"APP-XH0070 Membership Number Should not be Empty\");\n\t\tdocument.getElementById(\"membership_number\").focus();\n\t\treturn;\n\t} \n\n\tif(!(m_surname != null && m_surname != \"\" && m_surname != \" \") && checkType != \"IDC\" && checkType != \"UEC\")\n\t{ \n\t\talert(\"APP-XH0070 Membership Surname Should not be Empty\");\n\t\tdocument.getElementById(\"p_surname\").focus();\n\t\treturn;\n\t} \n\n\tif(!(dest_code != null && dest_code != \"\" && dest_code != \" \"))\n\t{ \n\t\talert(\"APP-XH0070 Destination Code for the Customer has not been configured, Please configure and try again\");\n\t\treturn;\n\t} \n\t\n\n\tdataElements = \"<PATIENT_ID>\"+patientId+\"$!^<ENCOUNTER_ID>\"+encounterId+\"$!^<EPISODE_TYPE>\"+episode_type+\"$!^<REQUEST>\"+checkType+\"$!^<REQUEST_TYPE>ELCREQ$!^<MEMBER_ID>\"+membership_number+\"$!^<DEPD_CODE>\"+dependant_num+\"$!^<DEPD_RELN>\"+dependant_relation+\"$!^<CUST_CD>\"+custCode+\"$!^<DEST_CD>\"+dest_code+\"$!^<USER>\"+AddedByUserId+\"$!^<FACILITY_ID>\"+AddedByFacilityId+\"$!^<TRANS_ID>$!^<WCA_NUM>\"+wca_num+\"$!^<WS_NO>\"+WorkstationNo+\"$!^<EPISODE_ID>\"+episodeId+\"$!^<VISIT_ID>\"+visit_id+\"$!^<SURNAME>\"+m_surname+\"$!^<INITIAL>\"+m_intial+\"$!^<BLNG_GRP_ID>\"+blng_grp_id+\"$!^<SETTLEMENT_IND>\"+settlement_ind+\"$!^<ADMISSION_TYPE>\"+admission_type+\"$!^\";\n\n\t//dataElements = \"<PATIENT_ID>\"+patientId+\"$!^<ENCOUNTER_ID>\"+encounterId+\"$!^<NATIONAL_ID>\"+nationalId+\"$!^<PATIENT_NAME>\"+patientName+\"$!^<PATIENT_DOB>\"+dob+\"$!^<SEX>\"+sex+\"$!^<PATIENT_CLASS>\"+patientClass+\"$!^<VISIT_ADMISSION_DATE>\"+visitAdmissionDate+\"$!^<LOCATION_TYPE>\"+locationType+\"$!^<SERVICE_CODE>\"+serviceCode+\"$!^<SPECIALITY_CODE>\"+specialityCode+\"$!^<CUST_CODE>\"+custCode+\"$!^<FIRST_NAME>\"+firstName+\"$!^<SECOND_NAME>\"+secondName+\"$!^<INITIAL>\"+initial+\"$!^<FAMILY_NAME>\"+familyName+\"$!^<CHECKTYPE>\"+checkType+\"$!^<MEMBERSHIP_NUMBER>\"+membership_number+\"$!^<WCA_NUMBER>\"+wca_num+\"$!^<DEPENDENT_NUMBER>\"+dependant_num+\"$!^<DEPENDENT_RELATION>\"+dependant_relation+\"$!^\";\n\n\tvar responseMsg = eligibilityCheckTransaction(dataElements,\"ECLAIMSEC\")\n\tParseCheckResponse(responseMsg);\n\n\tvar trans_id = document.forms[0].transID.value;\n}\n\nfunction fetchResponse()\n{\t\t\t\t\t\t\t\n\tvar patientId = document.forms[0].patient_id.value;\n\n\tvar encounterId = document.forms[0].encounterId.value;\n\n\tvar patientName = document.forms[0].patient_name.value;\n\tvar sex = document.forms[0].sex.value;\n\tvar nationalId = document.forms[0].nationalId.value;\n\n\tvar patientClass = document.forms[0].patient_cls_episode.value;\n\tvar visitAdmissionDate = document.forms[0].visitAdmissionDt.value;\n\tvar locationType = document.forms[0].locationType.value;\n\n\tvar serviceCode = document.forms[0].serviceCode.value;\n\tvar specialityCode = document.forms[0].speciality_code.value;\n\tvar custCode = document.forms[0].custCode.value;\t\t\t\t\t\n\n\tvar firstName = document.forms[0].firstName.value;\n\tvar secondName = document.forms[0].secondName.value;\n\tvar initial = document.forms[0].initial.value;\n\tvar familyName = document.forms[0].familyName.value;\n\tvar dob = document.forms[0].dob.value;\n\tvar m_surname = document.getElementById(\"p_surname\").value; \n\tvar m_intial = document.getElementById(\"p_intial\").value; \n\n\t\n\tvar checkType = document.forms[0].checkType.value;\n\tvar membership_number = document.getElementById(\"membership_number\").value;\n\tvar wca_num = document.getElementById(\"p_wca_num\").value ;\n\tvar dependant_num = document.getElementById(\"p_dependant_num\").value;\n\tvar dependant_relation = document.getElementById(\"p_dependant_relation\").value; \n\tvar dest_code = document.getElementById(\"destCode\").value; \n\tvar trans_id = document.getElementById(\"transID\").value; \n\n\tvar AddedByFacilityId = document.getElementById(\"AddedByFacilityId\").value ;\n\tvar AddedByUserId = document.getElementById(\"AddedByUserId\").value;\n\tvar WorkstationNo = document.getElementById(\"WorkstationNo\").value;\n\n\tvar episode_type=document.forms[0].episode_type.value;\n\tvar episodeId=document.forms[0].episodeId.value;\n\tvar custCode=document.forms[0].custCode.value;\n\tvar AddedByFacilityId = document.getElementById(\"AddedByFacilityId\").value ;\n\n\tvar visit_id=document.forms[0].visit_id.value;\n\tdocument.forms[0].episodeId.value =episodeId;\n\tdocument.forms[0].episode_type.value =episode_type;\n\n\tvar blng_grp_id=document.forms[0].blng_grp_id.value;\n\tvar settlement_ind=document.forms[0].settlement_ind.value;\n\t/*\n\n\tvar l_episode_type = \"\";\n\tif (episode_type == \"OP\") {\n\t\tl_episode_type = \"O\";\n\t}\n\tif (episode_type == \"EM\") {\n\t\tl_episode_type = \"E\";\n\t}\n\tif (episode_type == \"IP\") {\n\t\tl_episode_type = \"I\";\n\t}\n\tif (episode_type == \"DC\") {\n\t\tl_episode_type = \"D\";\n\t}\n\tif (episode_type == \"\") {\n\t\tl_episode_type = \"X\";\n\t}\n\n\t*/\n\n\n\n\tif(!(membership_number != null && membership_number != \"\" && membership_number != \" \") && checkType != \"IDC\" && checkType != \"UEC\")\n\t{ \n\t\talert(\"APP-XH0070 Membership Number Should not be Empty\");\n\t\tdocument.getElementById(\"membership_number\").focus();\n\t\treturn;\n\t} \n\t\n\tif(!(m_surname != null && m_surname != \"\" && m_surname != \" \") && checkType != \"IDC\" && checkType != \"UEC\")\n\t{ \n\t\talert(\"APP-XH0070 Membership Surname Should not be Empty\");\n\t\tdocument.getElementById(\"p_surname\").focus();\n\t\treturn;\n\t}  \n\t\t\n\n\tdataElements = \"<PATIENT_ID>\"+patientId+\"$!^<ENCOUNTER_ID>\"+encounterId+\"$!^<EPISODE_TYPE>\"+episode_type+\"$!^<REQUEST>\"+checkType+\"$!^<REQUEST_TYPE>ELCRES$!^<MEMBER_ID>\"+membership_number+\"$!^<DEPD_CODE>\"+dependant_num+\"$!^<DEPD_RELN>\"+dependant_relation+\"$!^<CUST_CD>\"+custCode+\"$!^<DEST_CD>\"+dest_code+\"$!^<USER>\"+AddedByUserId+\"$!^<FACILITY_ID>\"+AddedByFacilityId+\"$!^<TRANS_ID>\"+trans_id+\"$!^<WCA_NUM>\"+wca_num+\"$!^<WS_NO>\"+WorkstationNo+\"$!^<EPISODE_ID>\"+episodeId+\"$!^<VISIT_ID>\"+visit_id+\"$!^<SURNAME>\"+m_surname+\"$!^<INITIAL>\"+m_intial+\"$!^<BLNG_GRP_ID>\"+blng_grp_id+\"$!^<SETTLEMENT_IND>\"+settlement_ind+\"$!^\";\n\n\t//dataElements = \"<PATIENT_ID>\"+patientId+\"$!^<ENCOUNTER_ID>\"+encounterId+\"$!^<NATIONAL_ID>\"+nationalId+\"$!^<PATIENT_NAME>\"+patientName+\"$!^<PATIENT_DOB>\"+dob+\"$!^<SEX>\"+sex+\"$!^<PATIENT_CLASS>\"+patientClass+\"$!^<VISIT_ADMISSION_DATE>\"+visitAdmissionDate+\"$!^<LOCATION_TYPE>\"+locationType+\"$!^<SERVICE_CODE>\"+serviceCode+\"$!^<SPECIALITY_CODE>\"+specialityCode+\"$!^<CUST_CODE>\"+custCode+\"$!^<FIRST_NAME>\"+firstName+\"$!^<SECOND_NAME>\"+secondName+\"$!^<INITIAL>\"+initial+\"$!^<FAMILY_NAME>\"+familyName+\"$!^<CHECKTYPE>\"+checkType+\"$!^<MEMBERSHIP_NUMBER>\"+membership_number+\"$!^<WCA_NUMBER>\"+wca_num+\"$!^<DEPENDENT_NUMBER>\"+dependant_num+\"$!^<DEPENDENT_RELATION>\"+dependant_relation+\"$!^\";\n\n\t//var responseMsg = eligibilityCheckTransaction(dataElements);\n\tvar responseMsg = eligibilityCheckTransaction(dataElements,\"ECLAIMSEC\")\n\tParseCheckResponse(responseMsg);\n\treturn responseMsg;\n\t\n}\nfunction ParseCheckResponse(responseMsg){\n\tvar responseData = \"\";\n\tvar warnData = \"\";\n\tvar warning_data= \"\";\n\tvar warning_response= \"\";\n\tvar checkType = document.forms[0].checkType.value;\n\tvar patientId = document.forms[0].patient_id.value;\n\tvar custCode = document.forms[0].custCode.value;\n\tvar memshipno = \"\";\n\n\tdocument.getElementById(\'Response\').innerHTML = \"\";\n\tdocument.getElementById(\'Warning\').innerHTML = \"\";\n\tdocument.getElementById(\'dispayWarning\').style.display = \'none\';\n\tdocument.getElementById(\'comparePatientData\').style.display = \'none\';\n\n\tdocument.getElementById(\'update_auth_patientDetail\').disabled = true;\n\tdocument.getElementById(\'update_auth\').disabled = true;\n\n\tresponseData = responseMsg.split(\"$!^\");\n\n\tif (responseData.length > 0)\n\t{\n\t\tdocument.forms[0].transID.value = responseData[1];\n\n\t\tif (responseData[0] == \"S\")\n\t\t{\n\t\t\tif (responseData[9].length>0)\n\t\t\t\t\tdocument.getElementById(\"membership_number\").value = responseData[9];\n\n\t\t\t\tif (responseData[9].length>0)\n\t\t\t\t\tmemshipno = responseData[9];\n\t\t\t\telse\n\t\t\t\t\tmemshipno = document.getElementById(\"membership_number\").value;\n\n\t\t\tif(!(responseData[8] !=\"A\"))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"eligibility_trns\").disabled = true;\n\n\t\t\t\tif(ch";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="eckType == \"IEC\")\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'dispayWarning\').style.display = \'block\';\n\t\t\t\t\tdocument.getElementById(\'comparePatientData\').style.display = \'none\';\n\t\t\t\t\ttrans_id=responseData[1];\n\t\t\t\t\t warnData = EligibilityTrans(\"<PATIENT_ID>\"+patientId+\"$!^<TRANS_ID>\"+responseData[1]+\"$!^<STATUS>\"+responseData[8]+\"$!^\",\"ECLAIMSWARN\");\t\n\t\t\t\t\tif(warnData != null && warnData != \"\" && warnData != \" \"){\n\t\t\t\t\t\tdocument.getElementById(\'Warning\').innerHTML = warnData;  \n\t\t\t\t\t}\n\t\t\t\t\tdocument.getElementById(\'update_auth\').disabled = true;\n\t\t\t\t}\n\t\t\t\telse if(checkType == \"UEC\"){\n\n\t\t\t\t\tdocument.getElementById(\'dispayWarning\').style.display = \'none\';\n\t\t\t\t\tdocument.forms[0].transID.value = responseData[1];\n\t\t\t\t\tresponse_str=responseData[5];\n\t\t\t\t\tvar dataElements = \"<MEMBERSHIP_NUMBER>\"+patientId+\"$!^<TRANS_ID>\"+responseData[1]+\"$!^<PATIENT_ID>\"+patientId+\"$!^<STATUS>\"+responseData[8]+\"$!^\";\n\t\t\t\t\tvar memdata = EligibilityTrans(dataElements,\"ECLAIMSEMPDTL\");\n\t\t\t\t\tif(memdata != null && memdata != \"\" && memdata != \" \")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'Response\').innerHTML = memdata;\n\t\t\t\t\t\tdocument.getElementById(\'comparePatientData\').style.display = \'block\';\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\'update_auth_patientDetail\').disabled = true;\n\t\t\t\t\tdocument.getElementById(\'update_auth\').disabled = true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'dispayWarning\').style.display = \'none\';\n\t\t\t\t\tdocument.forms[0].transID.value = responseData[1];\n\t\t\t\t\tresponse_str=responseData[5];\n\t\t\t\t\tvar memdata = EligibilityTrans(\"<MEMBERSHIP_NUMBER>\"+memshipno+\"$!^<CUSTCODE>\"+custCode+\"$!^\",\"ECLAIMSMEMDTL\");\n\t\t\t\t\tif(memdata != null && memdata != \"\" && memdata != \" \")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'Response\').innerHTML = memdata+\"\"+response_str;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'Response\').innerHTML = response_str ;\n\t\t\t\t\t}\n\t\t\t\t\twarnData = EligibilityTrans(\"<PATIENT_ID>\"+patientId+\"$!^<TRANS_ID>\"+responseData[1]+\"$!^<STATUS>\"+responseData[8]+\"$!^\",\"ECLAIMSWARN\");\n\t\t\t\t\tif(warnData.length>0){\n                          document.getElementById(\'Warning\').innerHTML = warnData;\n\t\t\t\t\t\t  document.getElementById(\'dispayWarning\').style.display = \'block\';\n\t\t\t\t\t}\n\t\t\t\t\tdocument.getElementById(\'comparePatientData\').style.display = \'block\';\n\t\t\t\t\tdocument.getElementById(\'update_auth_patientDetail\').disabled = false;\n\t\t\t\t\tdocument.getElementById(\'update_auth\').disabled = true;\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\"auth_number\").value =  responseData[7];\n\t\t\t\tdocument.getElementById(\"claims_number\").value = responseData[3];\n\t\t\t\tdocument.getElementById(\"response_type\").value = responseData[4];\n\t\t\t}\n\t\t\tif(!(responseData[8] !=\"R\"))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'comparePatientData\').style.display = \'none\';\n                \n\t\t\t\ttrans_id=responseData[1];\n\t\t\t\twarnData = EligibilityTrans(\"<PATIENT_ID>\"+patientId+\"$!^<TRANS_ID>\"+responseData[1]+\"$!^<STATUS>\"+responseData[8]+\"$!^\",\"ECLAIMSWARN\");\n\t\t\t\tif(warnData != null && warnData != \"\" && warnData != \" \"){\n\t\t\t\t    document.getElementById(\'dispayWarning\').style.display = \'block\';\n\t\t\t\t\tdocument.getElementById(\'Warning\').innerHTML = warnData;  \n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\'update_auth\').disabled = true;\n\t\t\t\tdocument.getElementById(\'update_auth_patientDetail\').disabled = true;\n\n\t\t\t\tdocument.getElementById(\"auth_number\").value =  responseData[7];\n\t\t\t\tdocument.getElementById(\"claims_number\").value = responseData[3];\n\t\t\t\tdocument.getElementById(\"response_type\").value = responseData[4];\n\n\t\t\t}\n\t\t\t\n\t\t\tif(!(responseData[8] !=\"F\")){\n\t\t\t\tdocument.getElementById(\'dispayWarning\').style.display = \'none\';\n\t\t\t\twarnData = failedResponse(responseMsg);\n\t            if(warnData != null && warnData != \"\" && warnData != \" \"){\n\t\t\t\t   document.getElementById(\'comparePatientData\').style.display = \'block\';\n                   document.getElementById(\'Response\').innerHTML = warnData;\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\'update_auth\').disabled = true;\n\t\t\t\tdocument.getElementById(\'update_auth_patientDetail\').disabled = true;\n\n\t\t\t\tdocument.getElementById(\"auth_number\").value =  \"\";\n\t\t\t\tdocument.getElementById(\"claims_number\").value = \"\";\n\t\t\t\tdocument.getElementById(\"response_type\").value = responseData[11];\n\t\t\t}\n\t\t}\n\t\telse {\n\t\t\t\n\t\t\tif(responseData[3] != null && responseData[3]!= \"\" && responseData[3] != \" \"){\n\t\t\talert(\"APP-XH0070 \"+responseData[3]);\n\t\t\t}\n\t\t\tif(responseData[3] == \"Error in reading File - No Response File\"){\n                document.getElementById(\"fetch_response_elgi\").disabled = false;\n\t\t\t}\n\t\t\telse {\n\t\t\t\talert(\"APP-XH0070 Error Occured.\");\n\t\t\t}\n\t\t}\n\t}\n\telse{\n\t\talert(\"APP-XH0070 No Response File\");\n\t}\n}\n\nfunction Update(update_type)\n{\n\tvar response =\"\";\n\tvar responseData = \"\";\n\tvar existingData = \"\";\n\tvar dataElements =\"\";\n\tvar checkedValue = \"\";\n\n\tvar auth_number =document.getElementById(\"auth_number\").value ;\n\tvar claims_number = document.getElementById(\"claims_number\").value;\n\tvar response_type = document.getElementById(\"response_type\").value;\n    var warning_code = \"\";\n\tvar warning_code_desc =\"\";\n\tvar membership_number = document.getElementById(\"membership_number\").value;\n\tvar wca_num = document.getElementById(\"p_wca_num\").value ;\n\tvar membership_surname = document.getElementById(\"mem_surname\").value;\n\tvar membership_initial = document.getElementById(\"mem_intial\").value ;\n\tvar dependant_num = document.getElementById(\"p_dependant_num\").value;\n\tvar dependant_relation = document.getElementById(\"p_dependant_relation\").value; \n\n\tvar checkType=document.forms[0].checkType.value;\n\tvar patientId = document.forms[0].patient_id.value;\n    var transId = document.forms[0].transID.value ;\n\n    var admission_type=document.forms[0].admission_type.value;\n    var episode_type=document.forms[0].episode_type.value;\n\tvar episodeId=document.forms[0].episodeId.value;\n\tvar custCode=document.forms[0].custCode.value;\n\tvar AddedByFacilityId = document.getElementById(\"AddedByFacilityId\").value ;\n\tvar AddedByUserId = document.getElementById(\"AddedByUserId\").value;\n\tvar WorkstationNo = document.getElementById(\"WorkstationNo\").value; \n\n\tvar encounterId=document.forms[0].encounterId.value;\n\tvar visit_id=document.forms[0].visit_id.value;\n\n\tvar blng_grp_id=document.forms[0].blng_grp_id.value;\n\tvar settlement_ind=document.forms[0].settlement_ind.value;\n   \n\t/*\n\n\tvar l_episode_type = \"\";\n\tif (episode_type == \"OP\") {\n\t\tl_episode_type = \"O\";\n\t}\n\tif (episode_type == \"EM\") {\n\t\tl_episode_type = \"E\";\n\t}\n\tif (episode_type == \"IP\") {\n\t\tl_episode_type = \"I\";\n\t}\n\tif (episode_type == \"DC\") {\n\t\tl_episode_type = \"D\";\n\t}\n\n\t*/\n\n\tif(update_type == \"2\"){\n\t\tvar i=0;\n\t\tvar j=0;\n\t\tvar mem_details = \"\";\n        var checkBoxes = document.getElementsByName(\'checkbox\');\n\n\t\tfor(var i = 0; i < checkBoxes.length; i++)\n\t\t{\n\t\t\tif(checkBoxes[i].checked)\n\t\t\t{\n\t\t\t\tcheckedValue = checkBoxes[i].value;\n\n\t\t\t\tvar dep_cd = checkedValue;\n\t\t\t\tvar surname = document.getElementById(\"Surname\"+dep_cd).innerHTML;\n\t\t\t\tvar firstname = document.getElementById(\"Firstname\"+dep_cd).innerHTML;\n\t\t\t\tvar initial = document.getElementById(\"Initial\"+dep_cd).innerHTML;\n\t\t\t\tvar national_id = document.getElementById(\"national_id\"+dep_cd).innerHTML;\n\t\t\t\tvar dob = document.getElementById(\"dob\"+dep_cd).innerHTML;\n\t\t\t\tvar gender = document.getElementById(\"gender\"+dep_cd).innerHTML;\n\t\t\t\tvar status = document.getElementById(\"status\"+dep_cd).innerHTML;\n\t\t\t\tvar scheme_name = document.getElementById(\"scheme_name\"+dep_cd).innerHTML;\n\t\t\t\tvar scheme_date = document.getElementById(\"scheme_date\"+dep_cd).innerHTML;\n\t\t\t\tvar row=\"\";\n\t\t\t\trow += dep_cd+\"##\";\n\t\t\t\trow += dob+\"##\";\n\t\t\t\trow += national_id+\"##\";\n\t\t\t\trow += surname+\"##\";\n\t\t\t\trow += firstname+\"##\";\n\t\t\t\trow += initial+\"##\";\n\t\t\t\trow += gender+\"##\";\n\t\t\t\trow += status+\"##\";\n\t\t\t\trow += scheme_name+\"##\";\n\t\t\t\trow += scheme_date;\n\t\t\t\tif(j==0){\n                    mem_details = row;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tmem_details +=\"@@\"+row ;\n\t\t\t\t}\n\n\t\t\t\tj++;\n\t\t\t }\n\t   } \n\n\t    if(j<=0)\n\t\t{\n\t\t\talert(\"APP-XH0070 Please select at least one Member.\");\n\t\t\treturn;\n\t\t}\n\t\t\n\t\tvar preData = \"\";\n\n\t   dataElements = \"<REQUEST>\"+checkType+\"$!^<REQUEST_TYPE>ELCUPD$!^<UPDATE_TYPE>\"+update_type+\"$!^<FAMILY_NAME>\"+surname+\"$!^<FIRST_NAME>\"+firstname+\"$!^<NAME_SUFFIX>\"+initial+\"$!^<NATIONAL_ID>\"+national_id+\"$!^<DATE_OF_BIRTH>\"+dob+\"$!^<SEX>\"+gender+\"$!^<PATIENT_ID>\"+patientId+\"$!^<TRANS_ID>\"+transId+\"$!^<PREVIOUS_DATA>\"+preData+\"$!^<AUTHORIZATION_NUM>\"+auth_number+\"$!^<CLAIMS_NUMBER>\"+claims_number+\"$!^<RESPONSE_TYPE>\"+response_type+\"$!^<WARNING_CODE>\"+warning_code+\"$!^<ADMISSION_TYPE>\"+admission_type+\"$!^<EPISODE_ID>\"+episodeId+\"$!^<CUST_CODE>\"+custCode+\"$!^<FACILITY_ID>\"+AddedByFacilityId+\"$!^<EPISODE_TYPE>\"+episode_type+\"$!^<MEMBERSHIP_NUMBER>\"+membership_number+\"$!^<DEPENDENT_NUMBER>\"+dependant_num+\"$!^<WCA_NUMBER>\"+wca_num+\"$!^<DEPENDENT_RELATION>\"+dependant_relation+\"$!^<USER>\"+AddedByUserId+\"$!^<WS_NO>\"+WorkstationNo+\"$!^<ENCOUNTER_ID>\"+encounterId+\"$!^<VISIT_ID>\"+visit_id+\"$!^<MEM_SURNAME>\"+membership_surname+\"$!^<MEM_INITIAL>\"+membership_initial+\"$!^<MEM_DETAILS>\"+mem_details+\"$!^<BLNG_GRP_ID>\"+blng_grp_id+\"$!^<SETTLEMENT_IND>\"+settlement_ind+\"$!^\";\n\n\t}\n\tif(update_type == \"1\"){\n\n\t\tdataElements = \"<REQUEST>\"+checkType+\"$!^<REQUEST_TYPE>ELCUPD$!^<UPDATE_TYPE>\"+update_type+\"$!^<CLAIMS_NUMBER>\"+claims_number+\"$!^<RESPONSE_TYPE>\"+response_type+\"$!^<WARNING_CODE>\"+warning_code+\"$!^<WARNING_DESC>\"+warning_code_desc+\"$!^<AUTHORIZATION_NUM>\"+auth_number+\"$!^<TRANS_ID>\"+transId+\"$!^<PATIENT_ID>\"+patientId+\"$!^<ADMISSION_TYPE>\"+admission_type+\"$!^<EPISODE_ID>\"+episodeId+\"$!^<CUST_CODE>\"+custCode+\"$!^<FACILITY_ID>\"+AddedByFacilityId+\"$!^<EPISODE_TYPE>\"+episode_type+\"$!^<MEMBERSHIP_NUMBER>\"+membership_number+\"$!^<DEPENDENT_NUMBER>\"+dependant_num+\"$!^<WCA_NUMBER>\"+wca_num+\"$!^<DEPENDENT_RELATION>\"+dependant_relation+\"$!^<USER>\"+AddedByUserId+\"$!^<WS_NO>\"+WorkstationNo+\"$!^<ENCOUNTER_ID>\"+encounterId+\"$!^<VISIT_ID>\"+visit_id+\"$!^<MEM_SURNAME>\"+membership_surname+\"$!^<MEM_INITIAL>\"+membership_initial+\"$!^<BLNG_GRP_ID>\"+blng_grp_id+\"$!^<SETTLEMENT_IND>\"+settlement_ind+\"$!^\";\n\t}\n\n\t//response = UpadtePatientDetails(dataElements);\n    response = eligibilityCheckTransaction(dataElements,\"ECLAIMSUPD\");\n\tresponseData = response.split(\"$!^\");\n\tif(responseData[0]==\"S\"){\n\t\talert(\"APP-XH0070 Details Updated Successfully\");\n\t\tif(update_type == \"2\"){\n\n\t\t\t//var memdata = CheckForMemberShip(\"<MEMBERSHIP_NUMBER>\"+membership_number+\"$!^<CUSTCODE>\"+custCode+\"$!^\");\n\t\t\tvar memdata = EligibilityTrans(\"<MEMBERSHIP_NUMBER>\"+membership_number+\"$!^<CUSTCODE>\"+custCode+\"$!^\",\"ECLAIMSMEMDTL\");\n\t\t\tif(memdata != null && memdata != \"\" && memdata != \" \")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'Response\').innerHTML = memdata;\n\t\t\t}\n\t\t}\n\t\twindow.close();\n\t\t\n\t}\n\telse\n\t{\n\t\talert(\"APP-XH0071 \"+responseData[1]);\n\t}\t   \n\t//window.close();\n}\n\nfunction cancel()\n{\n\twin";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block8_2 ="dow.close();\n}\n\nfunction reset()\n{\n  document.forms[0].reset();\n}\n\nfunction changeScreenSize() {        \n        window.resizeTo(screen.width-1000,screen.height-1000)   \n    }\nfunction selectDR(){\n    \n\tvar dependant_relation=document.getElementById(\"p_dependant_relation\").value;\n\n\tfor(var i = 0;i < document.getElementById(\"p_dependant_relation\").length;i++){\n    if(document.getElementById(\"p_dependant_relation\").options[i].value == dependant_relation){\n             document.getElementById(\"p_dependant_relation\").selectedIndex = i;\n\t\t\t break;\n      }\n\t}\n}\nfunction failedResponse(responseMsg){\n\tvar responseTxt = \"\";\n\tvar warning_response = \"\";\n\tvar error_code = [];\n\tvar error_desc = [];\n\tresponseTxt = responseMsg.split(\"$!^\");\n\t\n\twarning_response = \"<table border=\\\"1\\\" align=\\\"center\\\" width=\\\"100%\\\" height=\\\"100%\\\" id=\\\"ResponseTable\\\"><tr><td class=\\\"columnheader\\\" colspan=\\\"4\\\">Failed File Details</td></tr>\";\n\twarning_response += \"<tr><td class=\\\"columnheader\\\" >PC Number</td><td class=\\\"columnheader\\\"  >Workstation Number</td><td class=\\\"columnheader\\\" >Msg Format</td><td class=\\\"columnheader\\\" >Error Count</td></tr>\";\n\twarning_response +=\"<tr ><td id=\\\"DeptCode\\\">\"+responseTxt[3]+\"</td>\";\n\twarning_response +=\"<td id=\\\"Firstname\\\">\"+responseTxt[4]+\"</td>\";\n\twarning_response +=\"<td id=\\\"Surname\\\">\"+responseTxt[5]+\"</td>\";\n\twarning_response +=\"<td id=\\\"Initial\\\">\"+responseTxt[6]+\"</td></tr>\";\n\twarning_response += \"<tr><td class=\\\"columnheader\\\" colspan=\\\"4\\\">Error Details</td></tr>\";\n\twarning_response += \"<tr><td class=\\\"columnheader\\\" colspan=\\\"2\\\">Error Code</td><td class=\\\"columnheader\\\"  colspan=\\\"2\\\">Error Desc</td></tr>\";\n\terror_code=responseTxt[7].split(\"##\");\n\terror_desc=responseTxt[10].split(\"##\");\n\tfor (i = 0; i <error_code.length-1; i++) {\n\t\twarning_response +=\"<tr ><td id=\\\"ErrorCode\\\" colspan=\\\"2\\\" >\"+error_code[i]+\"</td>\";\n\t\twarning_response +=\"<td id=\\\"ErrorDesc\\\" colspan=\\\"2\\\" >\"+error_desc[i]+\"</td></tr>\";\n\t}\n\twarning_response +=\"</table>\";\n\n    return warning_response;\n}\nfunction EligibilityTrans(dataElements,calltype){\n\t//alert(calltype);\n    var responseMsg=\"\";\n\tvar data1=true;\n\t$.ajax({\n\t\turl: \'../../servlet/eXH.GetStatusServlet\',\n\t\ttype: \'POST\',\n\t\tcache: false,\n\t\t\n\t\tdata: {\n\t\t\t\tcallType: calltype,\n\t\t\t\tparamString: dataElements\n\t\t},\n\t\tsuccess: function (data1) {\n\t\t\tresponseMsg = data1;\n\t\t},\t\t\n\t\tdataType: \'text\',\n\t\tasync: false\n\t});\n\t\n\treturn responseMsg;\n\n}\nfunction eligibilityCheckTransaction(dataElements,calltype)\n{\n\t//alert(calltype);\n    var responseMsg=\"\";\n\tvar data1=true;\n\t$.ajax({\n\t\turl: \'../../servlet/eXH.InvokeMedikreditApplication\',\n\t\ttype: \'POST\',\n\t\tcache: false,\n\t\t\n\t\tdata: {\n\t\t\t\tcallType: calltype,\n\t\t\t\tparamString: dataElements\n\t\t},\n\t\tsuccess: function (data1) {\n\t\t\tresponseMsg = data1;\n\t\t},\t\t\n\t\tdataType: \'text\',\n\t\tasync: false\n\t});\n\n  return responseMsg;\n} \n</script>\n</head>\n\n\n<body>\n\n";
    private final static byte[]  _wl_block8_2Bytes = _getBytes( _wl_block8_2 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'add_modify_pat_fin_det_ins_bodyedit\' id=\'add_modify_pat_fin_det_ins_bodyedit\' method=\'post\' action=\"\">\n\n\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=center border=1>\n\t\t<tr>\n\t\t\t<td colspan=\"15\" class=\"COLUMNHEADER\" align=\'LEFT\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" :";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\n\t\t\t<td colspan=\"10\" class=\"COLUMNHEADER\" align=\'center\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n\t\t\t<td colspan=\"10\" class=\"COLUMNHEADER\" align=\'RIGHT\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" : ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td colspan=\"10\" class=\"COLUMNHEADER\" align=\'RIGHT\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t</tr>\t\n\t</table>\n<!--</fieldset>-->\n\n<fieldset style=\" border-color:grey;\">\n\t<table cellspacing=0 cellpadding=0 width=\'100%\' align=left >\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=left >\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=left border=0>\n\t\t\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"membership_number\" name=\"membership_number\" id=\"membership_number\"  value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"p_wca_num\" name=\"p_wca_num\" id=\"p_wca_num\" align=\"left\" size=\'20\'  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t    <td class=label>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"mem_surname\" name=\"p_surname\" id=\"p_surname\" align=\"left\" size=\'20\'  value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"mem_intial\" name=\"p_intial\" id=\"p_intial\"  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"p_dependant_num\" name=\"p_dependant_num\" id=\"p_dependant_num\" align=\"left\" size=\'20\'  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label >\n\t\t\t\t\t\t\t\t\t\t<select name=\"p_dependant_relation\" id=\"p_dependant_relation\" id=\"p_dependant_relation\" style=\"width: 150px\"  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t<option value = \'\'>----";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="----</option>\n\t\t\t\t\t\t\t\t\t\t\t<option value = \'0\'>Self</option>\n\t\t\t\t\t\t\t\t\t\t\t<option value = \'1\'>Spouse</option>\n\t\t\t\t\t\t\t\t\t\t\t<option value = \'2\'>Child</option>\n\t\t\t\t\t\t\t\t\t\t\t<option value = \'3\'>Other</option>\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\tvar tempObjName = \'p_dependant_relation\';\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' > 0 )\n\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\tvar selTempObj = document.getElementById(tempObjName);\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\tfor(var i=0;i<selTempObj.options.length;i++){\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\tif (selTempObj.options[i].value == \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\') {\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tselTempObj.selectedIndex = i;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=RIGHT>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"eligibility_trns\" name=\"eligibility_trns\" id=\"eligibility_trns\" value=\'Eligibility Trx\' onClick=\"eligibilityCheck()\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">\n\t\t\t\t\t\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"fetch_response_elgi\" name=\"fetch_response_elgi\" id=\"fetch_response_elgi\" value=\'Fetch Response\' onClick=\"fetchResponse()\" disabled>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\t\n\t</table>\t\n</fieldset>\n\n<fieldset style=\" border-color:grey;\">\n<div id=\"resultFieldSet\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">\n\t<table cellspacing=0 cellpadding=0 width=\'100%\' align=left  >\t\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=left >\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=left border=0>\n\t\t\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"claims_number\" name=\"claims_number\" id=\"claims_number\"  value=\"\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"response_type\" name=\"response_type\" id=\"response_type\" align=\"left\" size=\'20\'  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!--<tr>\n\t\t\t\t\t\t\t\t\t<td class=label >Warning Code\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label >\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"warning_code\" name=\"warning_code\" id=\"warning_code\" align=\"left\" size=\'20\'  value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>Warning Code Description</td>\n\t\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"warning_code_desc\" name=\"warning_code_desc\" id=\"warning_code_desc\" align=\"left\" size=\'20\'  value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>-->\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t</td>\n\t\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" id=\"auth_number\" name=\"auth_number\" id=\"auth_number\" align=\"left\" size=\'20\'  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t<td> </td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\t\n\t</table>\n</div>\n</fieldset>\n<fieldset style=\" border-color:grey;\" height=\"100%\">\n\n<div id=\"comparePatientData\"  height=\"100%\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" style=\"height:350px;overflow: auto; border:1px solid #ff0000;\">\n \n\t<table width=\"100%\" height=\"100px\" cellPadding=\"1\" noWrap=\"nowrap\" bgcolor=\"#000000\" border=\"1\" style=\"overflow: auto;\">\n        <tr height=\"100px\">\n\t\t\t<td id=\"Response\" colSpan=\"1\"  align=\"center\"  ></td>\n\t\t</tr> \t\t\n\t</table>\n</div>\n</fieldset>\n<fieldset style=\" border-color:grey;\">\n\n<div id=\"dispayWarning\"  height=\"10%\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" style=\"margin-top:5px;\">\n\n\n<table width=\"100%\" height=\"40%\" cellPadding=\"1\" noWrap=\"nowrap\" bgcolor=\"#000000\" border=\"1\" style=\"border-collapse: collapse;border-style: solid;border-color: #d5ecfb #d5ecfb; overflow-y: auto;\">\n        <tr height=\"100%\">\n\t\t\t<td id=\"Warning\" colSpan=\"1\"  align=\"center\"  style=\"background-color: #dae6f2; color: black;\" ></td>\n\t\t</tr> \t\t\n\t</table>\n</div>\n</fieldset>\n\n<table cellspacing=0 cellpadding=0 width=\'100%\' align=left >\n<tr height=\"25px\"> \n\t\t\t<td  colSpan=\"2\"  align=\"right\"  style=\"background-color: #dae6f2; color: black;\" >\t\t\t\t\t\t\t\n\t\t\t\t<input type=\"button\" class=\"BUTTON\" ID=\"update_auth\" name=\'update_auth\' id=\'update_auth\' value=\'Save Authorization Detail\' onClick=\"Update(\'1\')\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">\n\t\t\t\t<input type=\"button\" class=\"BUTTON\" ID=\"update_auth_patientDetail\" name=\'update_auth_patientDetail\' id=\'update_auth_patientDetail\' value=\'Save Member Details\' onClick=\"Update(\'2\')\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">\n\t\t\t\t<input  type=\"button\" class=\"BUTTON\" value=\'Close\' onClick=\"cancel()\" >\n\t\t\t</td>\n\t\t</tr>\n</table>\n<input type=hidden name=\"patient_name\" id=\"patient_name\" value=\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n<input type=hidden name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n<input type=hidden name=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n<input type=hidden name=\"sex\" id=\"sex\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n<input type=hidden name=\"nationalId\" id=\"nationalId\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n<input type=hidden name=\"patient_cls_episode\" id=\"patient_cls_episode\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n<input type=hidden name=\"episodeId\" id=\"episodeId\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n<input type=hidden name=\"visitAdmissionDt\" id=\"visitAdmissionDt\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n<input type=hidden name=\"locationType\" id=\"locationType\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n<input type=hidden name=\"serviceCode\" id=\"serviceCode\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n<input type=hidden name=\"speciality_code\" id=\"speciality_code\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n<input type=hidden name=\"custCode\" id=\"custCode\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n<input type=hidden name=\"firstName\" id=\"firstName\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n<input type=hidden name=\"secondName\" id=\"secondName\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n<input type=hidden name=\"initial\" id=\"initial\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n<input type=hidden name=\"dob\" id=\"dob\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n<input type=hidden name=\"familyName\" id=\"familyName\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n<input type=hidden name=\"checkType\" id=\"checkType\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n<input type=hidden name=\"destCode\" id=\"destCode\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n<input type=hidden name=\"transID\" id=\"transID\" value=\"\" >\n<input type=hidden name=\"AddedByFacilityId\" id=\"AddedByFacilityId\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n<input type=hidden name=\"AddedByUserId\" id=\"AddedByUserId\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n<input type=hidden name=\"WorkstationNo\" id=\"WorkstationNo\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n<input type=hidden name=\"admission_type\" id=\"admission_type\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n<input type=hidden name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n<input type=hidden name=\"visit_id\" id=\"visit_id\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n<input type=hidden name=\"preData\" id=\"preData\" value=\"\" >\n<input type=hidden name=\"blng_grp_id\" id=\"blng_grp_id\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n<input type=hidden name=\"settlement_ind\" id=\"settlement_ind\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            _bw.write(_wl_block8_2Bytes, _wl_block8_2);


		Connection connMedikredit = null;
		PreparedStatement pstmtMedikredit = null;
		ResultSet rsMedikredit = null;

		/* var params= "title="+title+"&pname="+patient_name+"&pid="+patient_id+"&pcepisode="+pat_cls_episode+"&epid="+episode_id+"&pdob="+pat_dob+"&nid="+national_id+"&sex="+sex+"&vadmitdt="+visit_adm_dt_time+"&locType="+locationType+"&loccd="+locationCode+"&fcid="+facilityId+"&fname="+firstName+"&sname="+secondName+"&initial="+initial+"&memno="+membership_no+"&wca="+wca_no+"&depNum="+dependant_number+"&depRel="+dependant_relationship;  */

		String loginfacility = (String) session.getValue("facility_id");
		String user_id	= (String)session.getValue("login_user") ;
		Properties p=( java.util.Properties ) session.getValue( "jdbc" ) ;
		String AddedAtWsNo     =  p.getProperty("client_ip_address");

		System.out.println(loginfacility + " ::: "+ user_id + " ::: "+ AddedAtWsNo );

		String patient_name = XHDBAdapter.checkNull(request.getParameter("pname"));    
		String patient_id = XHDBAdapter.checkNull(request.getParameter("pid"));
		String encounterId = XHDBAdapter.checkNull(request.getParameter("encounterId")); 
		String patient_cls_episode = XHDBAdapter.checkNull(request.getParameter("pcepisode"));  
		String episodeId = XHDBAdapter.checkNull(request.getParameter("epid"));  
		//String nursing_unit_code = XHDBAdapter.checkNull(request.getParameter("nuc"));
		String dob = XHDBAdapter.checkNull(request.getParameter("pdob"));   
		//to_store  cust_code

		String nationalId = XHDBAdapter.checkNull(request.getParameter("nid"));
		String sex = XHDBAdapter.checkNull(request.getParameter("sex"));
		String visitAdmissionDt = XHDBAdapter.checkNull(request.getParameter("vadmitdt"));  // cust_group_code
		String locationType = XHDBAdapter.checkNull(request.getParameter("locType"));


		String custCode = XHDBAdapter.checkNull(request.getParameter("custCode"));
		String serviceCode= XHDBAdapter.checkNull(request.getParameter("scode")); 
		String locationCode = XHDBAdapter.checkNull(request.getParameter("loccd"));
		String facilityId = XHDBAdapter.checkNull(request.getParameter("fcid"));

		String speciality_code = XHDBAdapter.checkNull(request.getParameter("speciality_code"));
		String firstName = XHDBAdapter.checkNull(request.getParameter("fname"));   //to_store
		String secondName = XHDBAdapter.checkNull(request.getParameter("sname"));
		String initial = XHDBAdapter.checkNull(request.getParameter("initial")); //to_store
		String familyName = XHDBAdapter.checkNull(request.getParameter("familyName"));
		String membershipNumber = XHDBAdapter.checkNull(request.getParameter("memno"));
		String wcaNumber = XHDBAdapter.checkNull(request.getParameter("wca"));    //to_store
		String m_surname = XHDBAdapter.checkNull(request.getParameter("m_surname"));
		String m_initial = XHDBAdapter.checkNull(request.getParameter("m_initial"));

		String dependantNumber = XHDBAdapter.checkNull(request.getParameter("depNum"));
		String dependantRelation = XHDBAdapter.checkNull(request.getParameter("depRel"));

		String checkType = XHDBAdapter.checkNull(request.getParameter("checkType"));
		String destCode = XHDBAdapter.checkNull(request.getParameter("destCode"));
	    String admission_type = XHDBAdapter.checkNull(request.getParameter("admission_type"));
		String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
		String visit_id = XHDBAdapter.checkNull(request.getParameter("visit_id"));

		String request_status = XHDBAdapter.checkNull(request.getParameter("request_status"));
		String auth_num = XHDBAdapter.checkNull(request.getParameter("auth_num"));
	    String approval_status = XHDBAdapter.checkNull(request.getParameter("approval_status"));
		String warn_code = XHDBAdapter.checkNull(request.getParameter("warn_code"));
		String warn_desc = XHDBAdapter.checkNull(request.getParameter("warn_desc"));
		String event_type = XHDBAdapter.checkNull(request.getParameter("event_type"));

		String blng_grp_id = XHDBAdapter.checkNull(request.getParameter("blng_grp_id"));
		String settlement_ind = XHDBAdapter.checkNull(request.getParameter("settlement_ind"));
		
		String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));
		if(isDebugYN.equals("Y")) System.out.println("destCode...."+destCode);
	    if(isDebugYN.equals("Y")) System.out.println("checkType...."+checkType);


        
		if(checkType.equals("IDC")){
			 destCode = (XHUtil.singleParamExeQry("SELECT DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG where  ELEMENT_ID = 'IDC_DEST_CD' and SEGMENT_ID = 'ELC'"));
		}

		if(isDebugYN.equals("Y")) System.out.println("destCode...."+destCode);
	    if(isDebugYN.equals("Y")) System.out.println("checkType...."+checkType);

		String approval_status_desc = "";

		if (approval_status.equals("A"))
			approval_status_desc = "Authorized";
		if (approval_status.equals("R"))
			approval_status_desc = "Rejected";
		if (approval_status.equals("F"))
			approval_status_desc = "Failed";
		if (!(approval_status.length()>0))
			approval_status_desc = "";

		String enableField = "";

	/*	if (approval_status.equals("A") && event_type.equals("IEC"))
			enableField = "Disabled";*/


		String disabledStr="disabled";
		String eligibilityCheckFields1 = "";
		String eligibilityCheckFields2 = "";
		String eligibilityCheckFields3 = "";


		if(isDebugYN.equals("Y")) System.out.println("admission_type...."+admission_type);
		if(isDebugYN.equals("Y")) System.out.println("event_type...."+event_type);
		if(isDebugYN.equals("Y")) System.out.println("checkType...."+checkType);

		String hideButton = "disabled";

		eligibilityCheckFields1 = "style='display:block;'";
		eligibilityCheckFields2 = "style='display:none;'";
		eligibilityCheckFields3 = "style='display:none;'";

		/*try{
			   SimpleDateFormat in_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			   SimpleDateFormat out_date = new SimpleDateFormat("yyyymmdd");

				Date date = in_date.parse(dob);
				dob = out_date.format(date);
				System.out.println("jsp.....dob.............. "+dob);
			}
			catch(Exception e)
			{
				System.out.println("eXH:::jsp..exception...."+ e.getMessage());
			}
			*/


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_name ));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(nationalId ));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(membershipNumber ));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(wcaNumber ));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(m_surname ));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(m_initial ));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dependantNumber ));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dependantRelation ));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dependantRelation.length()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dependantRelation));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(enableField));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(eligibilityCheckFields1 ));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(approval_status_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(warn_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(warn_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(auth_num));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(eligibilityCheckFields2));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(eligibilityCheckFields3));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(hideButton));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(enableField));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(hideButton));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(enableField));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_name ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(sex ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nationalId ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_cls_episode ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(visitAdmissionDt ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(locationType ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(serviceCode ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(speciality_code ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(custCode ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(firstName ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(secondName ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(initial ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(dob ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(familyName ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(checkType));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(destCode));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(loginfacility ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(AddedAtWsNo));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(admission_type));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(settlement_ind));
            _bw.write(_wl_block71Bytes, _wl_block71);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NationalID.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MembershipNo.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SchemeAuthNumber.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Membersuname.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MemberInitial.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DependantNo.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DependantRelatiosnhip.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ClaimNumber.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.responsetype.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AuthNumber.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
