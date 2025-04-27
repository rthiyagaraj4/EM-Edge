package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __iplookupcriteriaforamendtrn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPLookupCriteriaForAmendTrn.jsp", 1742387576029L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'javascript\'></script>\n\t<Script src=\"../../eIP/js/IPPractitionerComponent.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n<script>\n\nfunction compareDates(Obj)\n{\n\tif(validDateObj(Obj,\"DMY\",localeName))\n\t{\n\t\tif(document.forms[0].from_date.value !=\'\' && document.forms[0].to_date.value !=\'\')// DateUtils.js\n\t\t{\n\t\t\tvar fromDt = convertDate(document.forms[0].from_date.value,\"DMY\",localeName,\"en\");\n\t\t\tvar toDt = convertDate(document.forms[0].to_date.value,\"DMY\",localeName,\"en\");\n\n\t\t\t//if(isAfter(fromDt,toDt,\'DMY\',localeName))\n\t\t\tif(isAfter(fromDt,toDt,\'DMY\',\"en\"))\n\t\t\t{\n\t\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\tdocument.forms[0].to_date.select();\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction BeforeGetPractitioner(obj, target, details)\n{\n\tif(details == \'from\')\n\t{\n\t\tif(document.forms[0].from_practid_desc.value !=\"\")\n\t\t\tgetPractitionerLocal(obj, target, details);\n\t\telse\n\t\t\tdocument.forms[0].from_practid.value =\"\"\n\t}\n\telse if(details == \'to\')\n\t{\n\t\tif(document.forms[0].practid_desc.value !=\"\")\n\t\t\tgetPractitionerLocal(obj, target, details);\n\t\telse\n\t\t\tdocument.forms[0].practid.value =\"\"\n\t}\n}\n\nfunction getPractitionerLocal(obj, target, details)\n{\n\tvar practName_FName=\"\";\n\tvar practName_FValue=\"\";\n\tvar practId_FName=\"\";\n\n\tpractName_FName=target.name;\n\tpractName_FValue=target.value;\n\tif(details == \'from\')\n\t\tpractId_FName=document.forms[0].from_practid.name;\n\telse\n\t\tpractId_FName=document.forms[0].practid.name;\n\n\tvar\tlocale = document.forms[0].locale.value;\n\tvar facility_id\t\t= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\n\tgetPractitioner(obj, target, facility_id, \"\",\"\",\"Q2\");\n\n\t/*\n\t\n\tvar sql = \" select A.PRACTITIONER_ID PRACTITIONER_ID , am_get_desc.AM_PRACTITIONER(b.PRACTITIONER_ID,\'\"+locale+\"\',1) PRACTITIONER_NAME ,am_get_desc.AM_PRACT_TYPE(b.PRACT_TYPE,\'\"+locale+\"\',2) PRACTITIONER_TYPE ,am_get_desc.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,\'\"+locale+\"\',2 ) PRIMARY_SPECIALTY , DECODE(B.GENDER,\'M\',\'Male\',\'F\',\'Female\',\'U\',\'Unknown\') GENDER , am_get_desc.AM_POSITION(b.position_code,\'\"+locale+\"\',1) JOB_TITLE from AM_PRACT_FOR_FACILITY A , AM_PRACTITIONER B where A.PRACTITIONER_ID = B.PRACTITIONER_ID and B.PRACT_TYPE LIKE (?) and B.PRIMARY_SPECIALITY_CODE LIKE UPPER(?) and (UPPER(B.PRACTITIONER_ID) LIKE UPPER(NVL(?,B.PRACTITIONER_ID)) or UPPER(am_get_desc.AM_PRACTITIONER(b.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,B.PRACTITIONER_NAME)) ) and B.GENDER LIKE (?) and ( b.POSITION_CODE LIKE (?) or b.POSITION_CODE is NULL ) and A.FACILITY_ID= \'\"+facility_id+\"\' \";\n\t\n\tvar sql2 = \" select A.PRACTITIONER_ID PRACTITIONER_ID , am_get_desc.AM_PRACTITIONER(b.PRACTITIONER_ID,\'\"+locale+\"\',1) PRACTITIONER_NAME ,am_get_desc.AM_PRACT_TYPE(b.PRACT_TYPE,\'\"+locale+\"\',2) PRACTITIONER_TYPE ,am_get_desc.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,\'\"+locale+\"\',2 ) PRIMARY_SPECIALTY , DECODE(B.GENDER,\'M\',\'Male\',\'F\',\'Female\',\'U\',\'Unknown\') GENDER , am_get_desc.AM_POSITION(b.position_code,\'\"+locale+\"\',1) JOB_TITLE from AM_PRACT_FOR_FACILITY A , AM_PRACTITIONER B where A.PRACTITIONER_ID = B.PRACTITIONER_ID and B.PRACT_TYPE LIKE (?) and B.PRIMARY_SPECIALITY_CODE LIKE UPPER(?) and (UPPER(B.PRACTITIONER_ID) LIKE UPPER(NVL(?,B.PRACTITIONER_ID)) or UPPER(am_get_desc.AM_PRACTITIONER(b.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,B.PRACTITIONER_NAME)) ) and B.GENDER LIKE (?) and ( b.POSITION_CODE LIKE (?) or b.POSITION_CODE is NULL ) and A.FACILITY_ID= \'\"+facility_id+\"\' \";\n\n\n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\txmlStr\t=\"<root><SEARCH \" ;\n\txmlStr += \" practName_FName=\\\"\" +practName_FName + \"\\\"\";\n\txmlStr += \" practName_FValue=\\\"\" + encodeURIComponent(practName_FValue) + \"\\\"\";\n\txmlStr += \" sql=\\\"\" +escape(sql)+ \"\\\"\";\n\txmlStr += \" sqlSec=\\\"\" +escape(sql2)+ \"\\\"\";\n\txmlStr += \" practitioner_type=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" specialty_code=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" job_title=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" gender=\\\"\" + \"\" + \"\\\"\";\n\txmlStr +=\" /></root>\" ;\n\txmlDoc.loadXML( xmlStr );\n\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\txmlHttp.send(xmlDoc);\n\tresponseText=xmlHttp.responseText;\n\tresponseText = trimString(responseText);\n\teval(responseText);\t\n\n\t*/\n} // End of getPractitioner.\n\n// To be called by the GeneralPractitionerSearch to set Practitioner.\nfunction PractLookupRetVal(retVal,objName)\n{\n\tvar arr;\n\tif (retVal != null)\n\t{\n\t\tarr=retVal.split(\"~\");\n\t\tif(objName == \"from_practid_desc\")\n\t\t{\n\t\t\tdocument.forms[0].from_practid.value=arr[0];\n\t\t\tdocument.forms[0].from_practid_desc.value=arr[1];\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].practid.value=arr[0];\n\t\t\tdocument.forms[0].practid_desc.value=arr[1];\t\t\t\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(objName == \"from_practid_desc\")\n\t\t{\n\t\t\tdocument.forms[0].from_practid.value=\"\";\n\t\t\tdocument.forms[0].from_practid_desc.value=\"\";\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].practid.value=\"\";\n\t\t\tdocument.forms[0].practid_desc.value=\"\";\t\t\t\n\t\t}\n\t}\n\n}\n\n\tfunction OffsetDate(sysdatetime,strPri1,strDftUnts1)\n\t{\n\t\t//we are taking the sysdate to get the current time...cause the local machine may have a wrong time setting ...so we may not want to depend on the local time setiings...on the better side we save time with the local Date() object of JS.. \n\t\tvar result = \"\";\n\t\tvar days= strPri1;\n\t\tif(days!=\'\')\n\t\t{\n\t\t\tvar sysdate = sysdatetime.substring(0,10);\n\t\t\tvar systime = sysdatetime.substring(11,16);\n\t\t\t//building current date object from sysdate to avoid local machine date setting errors\n\t\t\tvar dateArray = sysdate.split(\"/\");\n\t\t\tsysdate1=dateArray[1]+\"/\"+dateArray[0]+\"/\"+dateArray[2]\n\t\t\tvar tempdate = Date.parse(sysdate1);\n\t\t\tvar currentDate=new Date(tempdate);\n\t\t\tvar timeArray = systime.split(\":\");\n\t\t\tsystime1=dateArray[1]+\"/\"+dateArray[0]+\"/\"+dateArray[2]+\" \"+timeArray[0]+\":\"+timeArray[1]\n\t\t\tvar tempdatetime = Date.parse(systime1);\n\t\t\tvar currentDateTime=new Date(tempdatetime);\n\t\t\tvar dwm = strDftUnts1;\n\t\t\tvar currentMonth=currentDate.getMonth();\n\t\t\tvar presentDate=currentDate.getDate();\n\t\t\tvar presentTime=currentDateTime.getHours();\n\t\t\tvar finaldate;\n\t\t\tif(dwm==\'D\')\n\t\t\t{\n\t\t\t\tfinaldate=presentDate-eval(days);\n\t\t\t\tcurrentDate.setDate(finaldate);\n\t\t\t\tresult = currentDate.getDate()+\"/\"+eval(currentDate.getMonth()+1)+\"/\"+currentDate.getFullYear();\n\t\t\t}\n\t\t\telse if(dwm==\'W\')\n\t\t\t{\n\t\t\t\tfinaldate=presentDate-eval(days*7);\n\t\t\t\tcurrentDate.setDate(finaldate);\n\t\t\t\tresult = currentDate.getDate()+\"/\"+eval(currentDate.getMonth()+1)+\"/\"+currentDate.getFullYear();\n\t\t\t}\n\t\t\telse if(dwm==\'H\') \n\t\t\t{\n\t\t\t\tfinaldate=presentTime-eval(days);\n\t\t\t\tcurrentDateTime.setHours(finaldate);\n\t\t\t\tresult = currentDateTime.getDate()+\"/\"+eval(currentDateTime.getMonth()+1)+\"/\"+currentDateTime.getFullYear()+\" \"+currentDateTime.getHours()+\":\"+currentDateTime.getMinutes();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tcurrentDate.setMonth(eval(currentMonth+eval(days)));\n\t\t\t\tresult = currentDate.getDate()+\"/\"+eval(currentDate.getMonth()+1)+\"/\"+currentDate.getFullYear();\n\t\t\t}\n\t\t\tdocument.forms[0].pri_target1.value= result;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].pri_target1.value=\"\";\n\t\t}\n\t\treturn result;\n\t}\n\n\tfunction submitPage()\n\t{\n\t\tvar systemdatetime = document.forms[0].sys_date_time.value;\n\t\tvar strPri1 =  document.forms[0].pri_val.value.split(\"~\");\n\t\tvar strDftUnts1 =  document.forms[0].pri_unt.value.split(\"~\");;\n\t\tvar retValP2 = OffsetDate(systemdatetime,strPri1[0],strDftUnts1[0]);\n\t\tvar retValP3 =OffsetDate(systemdatetime,strPri1[1],strDftUnts1[1]);\n\t\tdocument.forms[0].pri_target1.value = retValP2 +\"~\"+retValP3;\n\t\t   //Code changes starts by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011\n\t\t   var chk_status = document.getElementById(\'myCheckBox\').status; \n       \n\t\t   if(chk_status==true)\t\n\t\t\t{\n\t\t\tdocument.forms[0].loc_lang.value=\'th\';\n\t\t\t}\n\t\t\t//Code changes ends by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011\n\t\tvar condition=\"\"\n\t\tfor(var i=0; i<document.forms[0].elements.length; i++)\n\t\t\t\tcondition+= document.forms[0].elements[i].name +\"=\"+ document.forms[0].elements[i].value+\"&\"\n\t\tdocument.forms[0].search.disabled=true;\n\t\t\n\t\tif(document.forms[0].modal.value == \'yes\')\n\t\t\tparent.frames[1].location.href= \'../../eIP/jsp/IPLookupResultForAmendTrn.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&\'+condition\n\t\telse\n\t\t\tparent.frames[2].location.href= \'../../eIP/jsp/IPLookupResultForAmendTrn.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&\'+condition\t\n\t}\n\n\tfunction clearAll()\n\t{\n\t\tparent.frames[2].document.location.href =\'../../eCommon/html/blank.html\'; \n\t\tdocument.forms[0].search.disabled=false;\n\t}\n\n\n\t\n\t// Added by Sridhar on 3 FEB 2004\n\t// Function will check for empty values before calling up the common lookup func..\n\tfunction beforeGetSpecialty(aSpecialtID, Facility_ID, details)\n\t{\n\t\tif(details == \'from\')\n\t\t{\n\t\t\tif(document.forms[0].from_Splcode_desc.value != \"\")\n\t\t\t{\n\t\t\t\tgetSpecialty(aSpecialtID, Facility_ID, details)\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].from_Splcode_desc.value=\"\";\n\t\t\t\tdocument.forms[0].from_Splcode.value=\"\";\n\t\t\t}\n\t\t}\n\t\telse if(details == \'to\')\n\t\t{\n\t\t\tif(document.forms[0].Splcode_desc.value != \"\")\n\t\t\t{\n\t\t\t\tgetSpecialty(aSpecialtID, Facility_ID,details)\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].Splcode_desc.value=\"\";\n\t\t\t\tdocument.forms[0].Splcode.value=\"\";\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction beforeGetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID, details)\n\t{\n\t\tif(details == \'from\')\n\t\t{\n\t\t\tif(document.forms[0].from_nursing_unit_desc.value != \"\")\n\t\t\t{\n\t\t\t\tgetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID, details)\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].from_nursing_unit.value = \"\";\n\t\t\t\tdocument.forms[0].from_nursing_unit.value = \"\";\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(document.forms[0].nursing_unit_desc.value != \"\")\n\t\t\t{\n\t\t\t\tgetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID, details)\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].to_nursing_unit.value = \"\";\n\t\t\t\tdocument.forms[0].nursing_unit.value = \"\";\n\t\t\t}\n\t\t}\n\t}\n\n\n\t// By Annadurai 2/7/2004 starts..\n\t// To get the nursing unit using CommonLookup.\n\tasync function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID, details)\n\t{\n\t\tvar nursingUnit = aNursingUnit.value;\n\t\tvar facilityId\t= aFacilityId;\n\t\tvar loginUserId\t= aLoginUser;\n\t\tvar\toperStnID\t= pOperStnID;\n\t\tvar call_function =document.forms[0].function_id.value;\n\t\tvar tit\t\t\t= getLabel(\"Common.nursingUnit.label\",\"Common\");\n\t\tvar dialogHeight\t\t\t= \"60vh\" ;\n\t\tvar dialogWidth\t\t\t\t= \"50vw\" ;\n\t\tvar status\t\t\t\t\t= \"no\";\n\t\tvar features\t\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; scroll=no; status:\" + status ;\n\t\tvar arguments\t\t\t\t= \"\" ;\n\t\tvar retVal =    new String();\n\t\t\n\t\tvar jsp_name = \"\";\n\t\tif(details == \'from\')\n\t\t{\n\t\t\tjsp_name = \"../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode=\"+encodeURIComponent(nursingUnit)+\"&login_user=\"+loginUserId+\"&oper_id=\"+operStnID+\"&title=\"+encodeURIComponent(tit)+\"&facility_id=\"+facilityId+\"&call_function=\"+call_function+\"&open_location_yn=Y\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tjsp_name = \"../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode=\"+encodeURIComponent(nursingUnit)+\"&login_user=\"+loginUserId+\"&oper_id=\"+operStnID+\"&title=\"+encodeURIComponent(tit)+\"&facility_id=\"+facilityId+\"&call_function=\"+call_function;\n\t\t}\n\n\t\tvar retVal =  await window.showModalDialog(jsp_name,arguments,features);\n\t\tvar arr=new Array();\n\n\t\tif(retVal != null && retVal != \"\" )\n\t\t{\n\t\t\tarr=retVal.split(\"~\");\n\n\t\t\tif(details == \'from\')\n\t\t\t{\n\t\t\t\tif((aNursingUnit.name == \"from_nursing_unit_lookup\") || (aNursingUnit.name == \"from_nursing_unit_desc\"))\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].from_nursing_unit.value\t\t=\tarr[0];\n\t\t\t\t\tdocument.forms[0].from_nursing_unit_desc.value\t=\tarr[1];\n\t\t\t\t}\n\t\t\t\telse if((aNursingUnit.name == \"from_nursing_unit_to_lookup\") || (aNursingUnit.name == \"from_nursing_unit_to_desc\"))\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].from_to_nursing_unit.value\t\t\t=\tarr[0];\n\t\t\t\t\tdocument.forms[0].from_nursing_unit_to_desc.value\t=\tarr[1];\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(details == \'to\')\n\t\t\t{\n\t\t\t\tif((aNursingUnit.name == \"nursing_unit_lookup\") || (aNursingUnit.name == \"nursing_unit_desc\"))\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].nursing_unit.value\t\t=\tarr[0];\n\t\t\t\t\tdocument.forms[0].nursing_unit_desc.value\t=\tarr[1];\n\t\t\t\t}\n\t\t\t\telse if((aNursingUnit.name == \"nursing_unit_to_lookup\") || (aNursingUnit.name == \"nursing_unit_to_desc\"))\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].to_nursing_unit.value\t\t\t=\tarr[0];\n\t\t\t\t\tdocument.forms[0].nursing_unit_to_desc.value\t=\tarr[1];\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(details == \'from\')\n\t\t\t{\n\t\t\t\tif((aNursingUnit.name == \"from_nursing_unit_lookup\") || (aNursingUnit.name == \"from_nursing_unit_desc\"))\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].from_nursing_unit_desc.value\t= \"\";\n\t\t\t\t\tdocument.forms[0].from_nursing_unit.value\t\t= \"\";\n\t\t\t\t\tdocument.forms[0].from_nursing_unit_desc.focus();\n\t\t\t\t}\n\t\t\t\telse if((aNursingUnit.name == \"from_nursing_unit_to_lookup\") || (aNursingUnit.name == \"from_nursing_unit_to_desc\"))\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].from_nursing_unit_to_desc.value = \"\";\n\t\t\t\t\tdocument.forms[0].from_nursing_unit.value\t\t = \"\";\n\t\t\t\t\tdocument.forms[0].from_nursing_unit_to_desc.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(details == \'to\')\n\t\t\t{\n\t\t\t\tif((aNursingUnit.name == \"nursing_unit_lookup\") || (aNursingUnit.name == \"nursing_unit_desc\"))\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].nursing_unit_desc.value\t= \"\";\n\t\t\t\t\tdocument.forms[0].nursing_unit.value\t\t= \"\";\n\t\t\t\t\tdocument.forms[0].nursing_unit_desc.focus();\n\t\t\t\t}\n\t\t\t\telse if((aNursingUnit.name == \"nursing_unit_to_lookup\") || (aNursingUnit.name == \"nursing_unit_to_desc\"))\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].nursing_unit_to_desc.value = \"\";\n\t\t\t\t\tdocument.forms[0].to_nursing_unit.value\t\t = \"\";\n\t\t\t\t\tdocument.forms[0].nursing_unit_to_desc.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t} // End of getNursingUnit().\n\n\tfunction compareFrom()\n\t{\n\t\tfromVal\t=\tdocument.forms[0].nursing_unit.value;\n\t\ttoVal\t=\tdocument.forms[0].to_nursing_unit.value;\n\t\tif(fromVal != null && toVal != \'\')\n\t\t{\n\t\t\tif(toVal < fromVal)\n\t\t\t{\n\t\t\t\talert(getMessage(\'TO_NRS_UT_GR_FR_NR_UT\',\'IP\'));\n\t\t\t\tdocument.forms[0].nursing_unit_to_desc.value=\'\';\n\t\t\t\tdocument.forms[0].to_nursing_unit.value\t=\'\';\n\t\t\t\tdocument.forms[0].nursing_unit_to_lookup.focus();\n\t\t\t}\n\t\t}\n\t}\n\n\t// To get the specialty using CommonLookup.\n\tasync function getSpecialty(aSpecialtID, Facility_ID, details)\n\t{\n\t\tvar target\t\t\t= \"\";\n\t\tvar code\t\t\t= \"\";\n\t\tif(details == \'from\')\n\t\t{\n\t\t\ttarget\t\t\t= document.forms[0].from_Splcode_desc;\n\t\t}\n\t\telse if(details == \'to\')\n\t\t{\n\t\t\ttarget\t\t\t= document.forms[0].Splcode_desc;\n\t\t}\n\t\tvar FacilityID\t\t= Facility_ID;\n\t\tvar retVal\t\t\t= new String();\n\t\tvar argumentArray\t= new Array() ;\n\t\tvar dataNameArray\t= new Array() ;\n\t\tvar dataValueArray\t= new Array() ;\n\t\tvar dataTypeArray\t= new Array() ;\n\t\tvar locale = document.forms[0].locale.value;\t\n\n\t\tsql = \"Select speciality_code code,short_desc description from AM_SPECIALITY_LANG_VW where eff_status like \'E\' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) and language_id  = \'\"+locale+\"\' \";\n\n\t\ttit = getLabel(\"Common.speciality.label\",\"Common\");\n\n\t\targumentArray[0] = sql;\n\t\targumentArray[1] = dataNameArray ;\n\t\targumentArray[2] = dataValueArray ;\n\t\targumentArray[3] = dataTypeArray ;\n\t\targumentArray[4] = \"1, 2\";\n\t\targumentArray[5] = aSpecialtID.value;\n\t\targumentArray[6] = CODE_DESC_LINK;\n\t\targumentArray[7] = CODE_DESC;\n\n\t\t\n\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\tif(retVal != null && retVal != \"\" )\n\t\t{\n\t\t\tvar ret1=unescape(retVal);\n\t\t\tarr=ret1.split(\",\");\n\t\t\tif(details == \'from\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].from_Splcode.value=arr[0];\n\t\t\t\tdocument.forms[0].from_Splcode_desc.value=arr[1];\n\t\t\t}\n\t\t\telse if(details == \'to\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].Splcode.value=arr[0];\n\t\t\t\tdocument.forms[0].Splcode_desc.value=arr[1];\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(details == \'from\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].from_Splcode_desc.value=\"\";\n\t\t\t\tdocument.forms[0].from_Splcode.value=\"\";\n\t\t\t}\n\t\t\telse if(details == \'to\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].Splcode_desc.value=\"\";\n\t\t\t\tdocument.forms[0].Splcode.value=\"\";\n\t\t\t}\n\t\t} \n\t} \n</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</head>\n\t<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' onLoad=\'FocusFirstElement();\' >\n\t\t<form name=\'Inpatientlookup_Form\' id=\'Inpatientlookup_Form\' action=\'../../eIP/jsp/BookingReferenceLookupResult.jsp\' target=\'result\' >\n\t\t\t<table cellspacing=0 cellpadding=3 align=\'center\' width=\'100%\' border=\'0\'>\n\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\"25%\"></td>\n\t\t\t\t\t<td class=\'querydata\' colspan=\'1\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td class=\'label\' width=\"25%\"></td>\n\t\t\t\t\t<td class=\'querydata\' colspan=\'1\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\n\t\t\t</tr>\n\n\n\t\t\t<tr>\n\t\t\t\t<td nowrap class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\n\t\t\t\t<td width=\'25%\' class=\'fields\' nowrap><input type=text name=\"from_nursing_unit_desc\" id=\"from_nursing_unit_desc\" maxlength=15 size=15 onblur=\"beforeGetNursingUnit(this,\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'from\');\" ><input type=button class=button name=from_nursing_unit_lookup value=\'?\' onClick=\"getNursingUnit(from_nursing_unit_desc,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'from\')\"><input type=hidden name=\"from_nursing_unit\" id=\"from_nursing_unit\"></td>\n\n\n\t\t\t\t<td  width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\n\t\t\t\t<td  width=\'25%\' class=\'fields\' ><input type=text name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" maxlength=15 size=15 onblur=\"beforeGetNursingUnit(this,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'to\');\" ><input type=button class=button name=nursing_unit_lookup value=\'?\' onClick=\"getNursingUnit(nursing_unit_desc,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'to\')\"><input type=hidden name=\"to_nursing_unit\" id=\"to_nursing_unit\"><input type=hidden name=\"nursing_unit\" id=\"nursing_unit\" ></td>\n\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td  width=\'25%\' class=\'label\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td  width=\'25%\' class=\'fields\'><input type=text name=\'from_Splcode_desc\' id=\'from_Splcode_desc\' maxlength=15 size=15 onblur=\"beforeGetSpecialty(this, \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'from\');\" ><input type=hidden name=\'from_Splcode\' id=\'from_Splcode\' ><input type=button name=\'from_Splcode_lookup\' id=\'from_Splcode_lookup\' value=\'?\' class=button onClick=\"getSpecialty(from_Splcode_desc,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'from\');\"></td>\n\n\t\t\t\t<td   width=\'25%\' class=\'label\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\n\t\t\t\t<td width=\'25%\' class=\'fields\'><input type=text name=\'Splcode_desc\' id=\'Splcode_desc\' maxlength=15 size=15 onblur=\"beforeGetSpecialty(this, \'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'to\');\" ><input type=hidden name=\'Splcode\' id=\'Splcode\' ><input type=button name=\'Splcode_lookup\' id=\'Splcode_lookup\' value=\'?\' class=button onClick=\"getSpecialty(Splcode_desc,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'to\');\"></td>\n\t\t\t\t\t\n\t\t\t</tr>\t\n\n\t\t\t<tr>\n\t\t\t\t<td  width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td  width=\'25%\' class=\'fields\'><input type=\'text\' name=\'from_practid_desc\' id=\'from_practid_desc\' size=\"25\" maxlength=\"30\" onblur=\"BeforeGetPractitioner(document.forms[0].from_practid,from_practid_desc,\'from\');\" value=\"\"><input type=\'hidden\' name=\'from_practid\' id=\'from_practid\' value=\"\" size=\"15\" maxlength=\"15\" ><input type=\'button\' name=\'from_pract_id_search\' id=\'from_pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerLocal(document.forms[0].from_practid,from_practid_desc,\'from\');\"></td>\n\n\t\t\t\t<td   width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\n\t\t\t\t<td  width=\'25%\' class=\'fields\'><input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' size=\"25\" maxlength=\"30\" onblur=\"BeforeGetPractitioner(document.forms[0].practid,practid_desc,\'to\');\" value=\"\"><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"\" size=\"15\" maxlength=\"15\" ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerLocal(document.forms[0].practid,practid_desc,\'to\');\"></td>\n\t\t\t</tr>\n\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t<td width=\'25%\' class=\'fields\'>\n\t\t\t\t\n\t\t\t\t<input type=\'text\' id=\"adm_date_from\" maxlength=\'10\' size=\'10\' name=\'from_date\' id=\'from_date\'  value=\"\" onBlur=\'compareDates(this);\'><img  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].adm_date_from.focus();return showCalendar(\'adm_date_from\');\"/> - <input type=\'text\' id=\"adm_date_to\" value=\"\" maxlength=\'10\' size=\'10\' name=\'to_date\' id=\'to_date\' onBlur=\'compareDates(this);\'><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].adm_date_to.focus();return showCalendar(\'adm_date_to\',null);\"/></td>\n\t\t\t\t\t\n\t\t\t\t<td class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t<td width=\'25%\' class=\'fields\' nowrap><input type=\'text\' maxlength=\'12\' size=\'12\' name=\'encounter_id\' id=\'encounter_id\' onKeyPress=\"return allowValidNumber(this,event,12,0);\" onBlur=\" CheckNum(this);;\"></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\n\t\t\t\t\t<td width=\'25%\' class=\'fields\' nowrap><select name=\'transfer_type\' id=\'transfer_type\'><option value=\"\">---&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;---\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t</table>\n\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' class=\'white\'>\n\t\t\t\t\t\t<input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' class=\'button\' onclick=\'submitPage()\'>\n\t\t\t\t\t\t<input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' class=\'button\' onclick=\'clearAll()\'>\n\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\n\t\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' >\n\t\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >\n\t\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' >\n\t\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' >\t\n\t\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >\n\t\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' >\n\t\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' >\n\t\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' >\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >\n\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' >\n\t\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' >\n\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >\n\t\t<input type=\'hidden\' name=\'sys_date_time\' id=\'sys_date_time\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t<input type=\'hidden\' name=\'pri_val\' id=\'pri_val\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t<input type=\'hidden\' name=\'pri_unt\' id=\'pri_unt\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t<input type=\'hidden\' name=\'pri_target1\' id=\'pri_target1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'operStation\' id=\'operStation\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\n\t\t<!-- // Added by Sridhar R on Mar 11 2005.. for passing parameters to result page...-->\n\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t<input type=\'hidden\' name=\'routine_tfr_yn\' id=\'routine_tfr_yn\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t<input type=\'hidden\' name=\'bed_block_period_max_int\' id=\'bed_block_period_max_int\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t<input type=\'hidden\' name=\'sydate\' id=\'sydate\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t<input type=\'hidden\' name=\'priority_applicable_yn\' id=\'priority_applicable_yn\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t<input type=\'hidden\' name=\'change_bed_class_yn\' id=\'change_bed_class_yn\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t<input type=\'hidden\' name=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t<input type=\'hidden\' name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t<input type=\'hidden\' name=\'bed_block_period_max_type\' id=\'bed_block_period_max_type\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\n\t\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n</html>\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String locale							= (String)session.getAttribute("LOCALE");
	String loginUser						= (String)session.getValue("login_user");
	String facility_id						= (String)session.getValue("facility_id");
	String p_oper_stn_id					= checkForNull(request.getParameter("oper_stn_id"));
	String routine_tfr_yn					= checkForNull(request.getParameter("routine_tfr_yn"),"N");
	String systemdatetime					= checkForNull(request.getParameter("sydate"));
	String priority_applicable_yn			= checkForNull(request.getParameter("priority_applicable_yn"),"N");
	String change_bed_class_yn				= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	String deactivate_pseudo_bed_yn			= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String bl_interfaced_yn					= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
	String bed_block_period_max_type		= checkForNull(request.getParameter("bed_block_period_max_type"));
	String jsp_name							= checkForNull(request.getParameter("jsp_name"));
	String win_height						= checkForNull(request.getParameter("win_height"));
	String win_width						= checkForNull(request.getParameter("win_width"));
	String call_function					= checkForNull(request.getParameter("call_function"));
	String modal							= checkForNull(request.getParameter("modal"));
	String dialogTop						= checkForNull(request.getParameter("dialogTop"));
	String module							= checkForNull(request.getParameter("module"));
	String model_window						= checkForNull(request.getParameter("model_window"));
	String function_id						= checkForNull(request.getParameter("function_id"));
	String prog_id							= checkForNull(request.getParameter("prog_id"));
	String practitioner_id					= checkForNull(request.getParameter("practitioner_id"));
	String bed_block_period_max_str			= checkForNull(request.getParameter("bed_block_period_max_int"));
	int bed_block_period_max_int			= 0;
	if(! bed_block_period_max_str.equals(""))
		bed_block_period_max_int			= Integer.parseInt(bed_block_period_max_str);
	
	String strPri1		= "";
	String strDftUnts1	= "";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);

		Connection con	= null;
		Statement stmt	= null;
		ResultSet rs	= null;
		try
		{
			con = ConnectionManager.getConnection(request);
	
			strPri1="~";
			strDftUnts1="~";

		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

							StringBuffer sql = new StringBuffer();
							sql.append("select TRANSFER_TYPE_CODE,SHORT_DESC from ip_transfer_type_lang_vw where language_id='"+locale+"' and eff_status='E' order by SHORT_DESC ");
							stmt = con.createStatement();
							rs = stmt.executeQuery(sql.toString());
							if(rs!=null)
							{
								while( rs.next() )
								{
									String code = rs.getString("TRANSFER_TYPE_CODE");
									String desc = rs.getString("SHORT_DESC");
									out.print("<option value=\""+code+"\">"+desc);
								}
								if(rs!=null) rs.close();
								if(stmt!=null) stmt.close();
							}
					
            _bw.write(_wl_block34Bytes, _wl_block34);
            {java.lang.String __page ="IPPatientDetailCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(module));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(systemdatetime));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strPri1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strDftUnts1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(routine_tfr_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bed_block_period_max_int));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(systemdatetime));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(priority_applicable_yn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(change_bed_class_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bed_block_period_max_type));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block63Bytes, _wl_block63);
	}catch(Exception e)
	{
		out.println(" Exception in tryCatch in IPLookupCriteriaForAmendTrn.jsp : "+e);
	}
	finally
	{
		if(stmt != null)stmt.close();
		if(rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block64Bytes, _wl_block64);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmDateFrom.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransferType.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
