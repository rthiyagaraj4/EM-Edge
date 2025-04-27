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
import java.text.*;
import java.util.*;

public final class __confirmbedclasschangedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ConfirmBedClassChangeDetails.jsp", 1742376992702L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tChitra \n\tCreated on \t:\t13/07/2001\n\tModule\t\t:\tip\n-->\n\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../js/ConfirmBedClass.js\" language=\"javascript\"></script>\n\t<script src=\"../js/IPPractitionerComponent.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\n\t<script>\n\n\n// Added by Sridhar on 2 JULY 2004\n// Function chkPractRole will check whether the selected Practitioner is an Consultant Practitioner or not...IF \'Yes\'.. then user will have to select another practitioner..\nfunction chkPractRole(practID)\n{\n\tvar encounterId = document.forms[0].encounter_id.value;\n\tvar HTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown=\'lockKey()\'><form name=\'practRole\' id=\'practRole\' method=\'post\' action=\'../../eIP/jsp/PractIncompleteError.jsp?criteria=chkPractRole&encounter_ID=\"+encounterId+\"&pract_ID=\"+practID+\"\'></form></BODY></HTML>\";\n\tparent.frames[3].document.write(HTMLVal);\n\tparent.frames[3].document.forms[0].submit();\n}\n\n\n//By Annadurai 2/6/2004., to use Common Lookup starts.,\nvar flag = 0;\nfunction clearRoom()\n{\n\tif (document.forms[0].to_bed_no.value==\"\")\n\tdocument.forms[0].to_room_no.value=\"\";\n}\n\nfunction popDynamicValues_confirm(obj)\n{\n\t//dummy function added to stop the exceptions\n}\n\n\nfunction disableselect()\n{\tif(document.getElementById(\'reqstat\').value==\'2\')\n\t{\n\n\t\tdocument.forms[0].Bedcode.disabled=true;\n\t\tdocument.forms[0].bed_type_code.disabled=true;\n\n\t\tdocument.getElementById(\'legend2\').innerHTML\t    =\tgetLabel(\'Common.ReasonforRejection.label\',\'Common\')+\"&nbsp;&nbsp;\";\n\t\tdocument.getElementById(\'select2\').style.visibility\t    =\t\"Visible\";\n\t\tdocument.getElementById(\'rejection\').style.visibility\t    =\t\"Visible\";\n\t\tdocument.forms[0].to_bed_no.value=document.forms[0].hid_tobedno.value;\n\t\tdocument.forms[0].to_room_no.value=document.forms[0].hid_toroomno.value;\n\t\tdocument.forms[0].to_bed_no.disabled=true;\n\t\tdocument.forms[0].to_room_no.disabled=true;\n\t\tdocument.getElementById(\'bedlookkup\').disabled=true;\n\t\tdocument.getElementById(\'bedoimg\').style.visibility\t    =\t\"Hidden\";\n\t}\n\telse if(document.getElementById(\'reqstat\').value==\'1\')\n\t{\n\t\tdocument.forms[0].Bedcode.disabled=false;\n\t\tdocument.forms[0].bed_type_code.disabled=false;\n\t\tdocument.getElementById(\'legend2\').innerHTML\t    =\t\"\";\n\t\tdocument.getElementById(\'select2\').style.visibility\t    =\t\"Hidden\";\n\t\tdocument.getElementById(\'rejection\').style.visibility\t    =\t\"Hidden\";\n\t\tdocument.forms[0].to_bed_no.disabled=false;\n\t\tdocument.forms[0].to_room_no.disabled=false;\n\t\tdocument.forms[0].to_room_no.readOnly=true;\n\t\tdocument.getElementById(\'bedlookkup\').disabled=false;\n\tif(document.forms[0].tfr_type.value==\'ET\')\n\t\tdocument.getElementById(\'bedoimg\').style.visibility\t    =\t\"Visible\";\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'legend2\').innerHTML\t    =\t\"\";\n\t\tdocument.getElementById(\'select2\').style.visibility\t    =\t\"Hidden\";\n\t\tdocument.forms[0].Bedcode.disabled=true;\n\t\tdocument.forms[0].bed_type_code.disabled=true;\n\t\tdocument.getElementById(\'rejection\').style.visibility\t    =\t\"Hidden\";\n\t\tdocument.forms[0].to_bed_no.value=document.forms[0].hid_tobedno.value;\n\t\tdocument.forms[0].to_room_no.value=document.forms[0].hid_toroomno.value;\n\t\tdocument.forms[0].to_bed_no.disabled=true;\n\t\tdocument.forms[0].to_room_no.disabled=true;\n\t\tdocument.getElementById(\'bedlookkup\').disabled=true;\n\t\tdocument.getElementById(\'bedoimg\').style.visibility\t    =\t\"Hidden\";\n\t}\n}\n\nasync function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)\n{\n\tvar nursingUnit\t\t= aNursingUnit.value;\n\tvar facilityId\t\t= aFacilityId;\n\tvar loginUserId\t\t= aLoginUser;\n\tvar\toperStnID\t\t= pOperStnID;\n\n\tvar retVal\t\t\t= new String();\n\n\tvar argumentArray\t= new Array() ;\n\tvar dataNameArray\t= new Array() ;\n\tvar dataValueArray\t= new Array() ;\n\tvar dataTypeArray\t= new Array() ;\n\n\tsql=\"select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit a, am_os_user_locn_access_vw b where a.facility_id  like ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.oper_stn_id  like ? and b.appl_user_id  like ? and emergency_tfr_yn=\'Y\' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)\";\n\t\n\tdataNameArray[0]\t= \"a.facility_id\" ;\n\tdataValueArray[0]\t= facilityId;\n\tdataTypeArray[0]\t= STRING ;\n\t\n\tdataNameArray[1]\t= \"b.oper_stn_id\" ;\n\tdataValueArray[1]\t= operStnID;\n\tdataTypeArray[1]\t= STRING ;\n\t\n\tdataNameArray[2]\t= \"b.appl_user_id\" ;\n\tdataValueArray[2]\t= loginUserId;\n\tdataTypeArray[2]\t= STRING ;\n\n\targumentArray[0]\t= sql;\n\targumentArray[1]\t= dataNameArray ;\n\targumentArray[2]\t= dataValueArray ;\n\targumentArray[3]\t= dataTypeArray ;\n\targumentArray[4]\t= \"4, 5\";\n\targumentArray[5]\t= nursingUnit;\n\targumentArray[6]\t= DESC_LINK;\n\targumentArray[7]\t= DESC_CODE;\n\n\tvar tit=getLabel(\'Common.nursingUnit.label\',\'common\');;\n\n\tretVal = await CommonLookup( tit, argumentArray );\n\t\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].nursing_unit.value\t\t=\tarr[0];\n\t\tdocument.forms[0].nursing_unit_desc.value\t=\tarr[1];\n\t\tpopDynamicValues_confirm(document.forms[0].nursing_unit);\n\t\tdocument.forms[0].Splcode_desc.value=\'\';\n\t\tdocument.forms[0].Splcode.value=\'\';\n\t\tdocument.forms[0].practid.value=\'\';\n\t\tdocument.forms[0].pract_desc.value=\'\';\n\t\tdocument.forms[0].team_id.value=\'\';\n\t\tPopulateService();\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].nursing_unit_desc.value=\'\';\n\t\tdocument.forms[0].nursing_unit.value=\'\';\n\t\tdocument.forms[0].Splcode_desc.value=\'\';\n\t\tdocument.forms[0].Splcode.value=\'\';\n\t\tdocument.forms[0].practid.value=\'\';\n\t\tdocument.forms[0].pract_desc.value=\'\';\n\t\tdocument.forms[0].team_id.value=\'\';\n\t\tdocument.forms[0].to_bed_no.value=\'\';\n\t\tdocument.forms[0].to_room_no.value=\'\';\n\t\tdocument.forms[0].service.value=\'\';\n\t}\n}\n// To check the presence of Nursing Unit.\nfunction checkForNursing() \n{\n\tif (document.forms[0].nursing_unit_desc.value==\"\")\n\t{\n\t\tflag = 1;\n\t\talert(getMessage(\'NU_NOTNULL\',\'IP\'));\n\t\tdocument.forms[0].nursing_unit_desc.focus();\n\t}\n} // End of checkForNursing.\n\n\n// Added by Sridhar on 7 APR 2004\n// To Display the chief Practitioner if Medical Team is selected when pratitioner is empty.\nfunction getMedicalTeamHead(Obj)\n{\n\tif (Obj.value == \"\")\n\t{\n\t\tdocument.EmergencyTransfer_form.pract_desc.value = \"\";\n\t}\n\telse if (document.EmergencyTransfer_form.pract_desc.value == \"\")\n\t{\n\t\t var teamId = document.EmergencyTransfer_form.team_id.value;\n\t\t var sqlString = \"SELECT pract_role, PRACTITIONER_ID FROM am_pract_for_team WHERE team_id = \'\"+ document.EmergencyTransfer_form.team_id.value + \"\' AND pract_role=\'C\'\";\n\t\t\n\t\tdocument.EmergencyTransfer_form.selecTeam.value=sqlString;\n\n\t\tvar HTMLValue = \" <html><body onKeyDown=\'lockKey()\'><form name=\'dum_form\' id=\'dum_form\' method=\'post\' \t\t\t\t\t\t\taction=\'../../eIP/jsp/TransferValidation.jsp\'>\";\n\t\t\tHTMLValue += \" <input type=\'hidden\' name=\'selectedTeam\' id=\'selectedTeam\' value=\'\"+teamId+\"\'>\";\n\t\t\tHTMLValue += \" <input type=\'hidden\' name=\'reqParam\' id=\'reqParam\' value= \'executeQuery\' >\";\n\t\t\tHTMLValue +=\" <input type=\'hidden\' name=\'sqlQuery\' id=\'sqlQuery\' value=\'\"+sqlString+\"\'></form></body></html>\";\n\t\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLValue);\n\t\tparent.frames[2].document.dum_form.submit();\n\t}\n}\n\nfunction checkTxtVal(obj1,obj2)\n{\n\tif(document.forms[0].Splcode_desc.value == \"\")\n\t\tgetSpecialty(obj1,obj2);\n}\n\nfunction checkPractTxtVal(obj,target, aFacilityID)\n{\n\tif(document.forms[0].pract_desc.value == \"\")\n\t\tgetPractitionerLocal(obj,target, aFacilityID);\n}\n\n// Function will check for empty values before calling up the common lookup func..\n\nfunction BeforeGetSpecialty(obj1,obj2)\n{\n\tif(document.forms[0].spec_desc_hid.value != document.forms[0].Splcode_desc.value)\n\t{\n\t\tif(document.forms[0].Splcode_desc.value!=\"\")\n\t\t\tgetSpecialty(obj1,obj2);\n\t\telse\n\t\t\tdocument.forms[0].pract_desc.value = \"\";\t\n\t}\n}\nfunction BeforeGetPractitioner(obj,target, aFacilityID)\n{\n\tif(document.forms[0].pract_desc_hid.value != document.forms[0].pract_desc.value)\n\t{\n\t\tif(document.forms[0].pract_desc.value!= \"\")\n\t\t\tgetPractitionerLocal(obj,target, aFacilityID);\n\t\telse\n\t\t{\t\n\t\t\t\n\t\t\tvar obj =document.forms[0].team_id;\n\t\t\tvar length  = obj.length;\n\t\t\t\n\t\t\tfor(i=0;i<length;i++) \n\t\t\t\tobj.remove(0);\n\t\t\tvar opt = document.createElement(\'OPTION\'); \n\t\t\topt.text = \"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\topt.value= \'\';\n\t\t\tobj.add(opt);\n\t\t}\n\t}\n}\n\nasync function getSpecialty(aSpecialtID, Facility_ID)\n{\n\tcheckForNursing(); // To check for Nursing Unit.\n\tvar target\t\t\t= document.forms[0].Splcode_desc;\n\tvar code\t\t\t= document.forms[0].nursing_unit.value;\n\tvar FacilityID\t\t= Facility_ID;\n\tvar retVal\t\t\t= new String();\n\tvar argumentArray\t= new Array() ;\n\tvar dataNameArray\t= new Array() ;\n\tvar dataValueArray\t= new Array() ;\n\tvar dataTypeArray\t= new Array() ;\n\n\tsql\t=\t\"Select a.speciality_code code,a.short_desc description from am_speciality a, ip_nurs_unit_for_specialty b where eff_status=\'E\' and a.speciality_code=b.specialty_code and b.facility_id like ? and b.nursing_unit_code like ? and upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?) \";\n\t\n\tvar tit=getLabel(\'Common.speciality.label\',\'common\');\n\t\n\tdataNameArray[0]\t= \"b.facility_id\" ;\n\tdataValueArray[0]\t= FacilityID;\n\tdataTypeArray[0]\t= STRING ;\n\t\n\tdataNameArray[1]\t= \"b.nursing_unit_code\" ;\n\tdataValueArray[1]\t= code;\n\tdataTypeArray[1]\t= STRING ;\n\t\n\targumentArray[0]\t= sql;\n\targumentArray[1]\t= dataNameArray ;\n\targumentArray[2]\t= dataValueArray ;\n\targumentArray[3]\t= dataTypeArray ;\n\targumentArray[4]\t= \"3, 4\";\n\targumentArray[5]\t= aSpecialtID.value;\n\targumentArray[6]\t= DESC_LINK;\n\targumentArray[7]\t= DESC_CODE;\n\t\n\tretVal = await CommonLookup( tit, argumentArray );\n\t\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].Splcode.value=arr[0];\n\t\tdocument.forms[0].Splcode_desc.value=arr[1];\n\t\tdocument.forms[0].pract_desc.value=\'\';\n\t\tdocument.forms[0].practid.value=\'\';\n\t\tdocument.forms[0].team_id.value=\"\";\n\t\tdocument.forms[0].spec_desc_hid.value = document.forms[0].Splcode_desc.value;\n\t\tPopulateMedicalTeam();\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].Splcode_desc.value=\"\";\n\t\tdocument.forms[0].Splcode.value=\"\";\n\t\tdocument.forms[0].pract_desc.value=\"\";\n\t\tdocument.forms[0].practid.value=\"\";\n\t\tdocument.forms[0].team_id.value=\"\";\n\t} \n} // End of getSpecialty().\n\n// By Annadurai ends.,\n\n\tfunction fetchValForBedClass(obj){}\n\t\n// To check the Nursing Unit and Specialty when selecting Practitioner.  \nfunctio";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="n checkForValues()\n{\n\tif ((document.forms[0].nursing_unit_desc.value==\"\") && (document.forms[0].Splcode_desc.value==\"\"))\n\t{\n\t\tflag = 2;\n\t\tvar errorMsg = getMessage(\'NU_NOTNULL\',\'IP\')+\"\\n\"+getMessage(\'SPLTY_NOTNULL\',\'IP\'); \n\t\talert(errorMsg);\n\t\tdocument.forms[0].nursing_unit_desc.focus();\n\t}\n\telse if (document.forms[0].nursing_unit_desc.value==\"\")\n\t{\n\t\tflag = 2;\n\t\talert(getMessage(\'NU_NOTNULL\',\'IP\'));\n\t\tdocument.forms[0].nursing_unit_desc.focus();\n\t}\n\telse if (document.forms[0].Splcode_desc.value==\"\")\n\t{\n\t\tflag = 2;\n\t\talert(getMessage(\'SPLTY_NOTNULL\',\'IP\'));\n\t\tdocument.forms[0].Splcode_desc.focus();\n\t}\n} // End of checkForValues.\n\n\n\nfunction getPractitionerLocal(obj,target, aFacilityID)\n{\n\tcheckForValues();\n\tvar practName_FName\t\t= \"\";\n\tvar practName_FValue\t= \"\";\n\tvar practId_FName\t\t= \"\";\n\t\n\tpractName_FName\t\t\t= target.name;\n\tpractName_FValue\t\t= target.value;\n\tpractId_FName\t\t\t= document.forms[0].practid.name;\n\tvar nursing_unit_code\t= document.forms[0].nursing_unit.value;\n\tvar spl_code\t\t\t= document.forms[0].Splcode.value;\n\tvar locale\t\t\t= document.forms[0].locale.value;\n\tvar facility_id\t\t\t= aFacilityID;\n\t\n\tgetPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,\"Q5\");\n\t\n\t/*\n\tvar sql = \" SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1) practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,\'\"+locale+\"\',2) practitioner_type, a.specialty_code, am_get_desc.AM_SPECIALITY(a.SPECIALITY_CODE,\'\"+locale+\"\',2 ) primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,\'\"+locale+\"\',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = \'\"+facility_id+\"\'  AND a.specialty_code = \'\"+spl_code+\"\'  AND e.facility_id = a.facility_id  AND e.nursing_unit_code = \'\"+nursing_unit_code+\"\' AND e.practitioner_id = a.practitioner_id  AND a.pract_type LIKE (?)  AND a.specialty_code LIKE UPPER (?) AND (    UPPER (a.practitioner_id) LIKE UPPER (NVL (?,a.practitioner_id)) AND UPPER (am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) \";\n\n\tvar sql2 = \" SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1)practitioner_name, am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,\'\"+locale+\"\',2) practitioner_type, a.specialty_code, am_get_desc.AM_SPECIALITY(a.SPECIALITY_CODE,\'\"+locale+\"\',2 ) primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,\'\"+locale+\"\',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = \'\"+facility_id+\"\'  AND a.specialty_code = \'\"+spl_code+\"\'  AND e.facility_id = a.facility_id  AND e.nursing_unit_code = \'\"+nursing_unit_code+\"\' AND e.practitioner_id = a.practitioner_id  AND a.pract_type LIKE (?)  AND a.specialty_code LIKE UPPER (?) AND (    UPPER (a.practitioner_id) LIKE UPPER (NVL (?,a.practitioner_id)) and UPPER (am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) \";\n\n\tvar xmlDoc\t\t = new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\tvar xmlHttp\t\t = new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;\n\txmlStr\t\t\t = \"<root><SEARCH \" ;\n\txmlStr\t\t\t+= \" practName_FName=\\\"\" +practName_FName + \"\\\"\";\n\txmlStr\t\t\t+= \" practName_FValue=\\\"\" + practName_FValue + \"\\\"\";\n\txmlStr\t\t\t+= \" practId_FName=\\\"\" + practId_FName + \"\\\"\";\n\txmlStr\t\t\t+= \" sql=\\\"\" +escape(sql)+ \"\\\"\";\n\txmlStr\t\t\t+= \" sqlSec=\\\"\" +escape(sql2)+ \"\\\"\";\n\txmlStr\t\t\t+= \" practitioner_type=\\\"\" + \"\" + \"\\\"\";\n\txmlStr\t\t\t+= \" specialty_code=\\\"\" + spl_code+ \"\\\"\";\n\txmlStr\t\t\t+= \" job_title=\\\"\" + \"\" + \"\\\"\";\n\txmlStr\t\t\t+= \" gender=\\\"\" + \"\" + \"\\\"\";\n\txmlStr\t\t\t+=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\txmlHttp.send(xmlDoc);\n\tresponseText\t =xmlHttp.responseText;\n\tresponseText\t = trimString(responseText);\n\teval(responseText);\t\n\n\t*/\n\n\n} // End of getPractitioner();\n\n// To set the values to Attending Practitioner when using  \n// GeneralPratitionerLookup. It\'s called by the GeneralPratitionerLookup.\nfunction PractLookupRetVal(retVal,objName)\n{\n\tvar arr;\n\tif (retVal != null)\n\t{\n\t\tarr=retVal.split(\"~\");\n\t\tdocument.forms[0].practid.value=arr[0];\n\t\tdocument.forms[0].pract_desc.value=arr[1];\t\n\t\tdocument.forms[0].pract_desc_hid.value = document.forms[0].pract_desc.value;\n\t\tchkPractRole(document.forms[0].practid.value);\n\t\tPopulateMedicalTeam();\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].practid.value=\"\";\n\t\tdocument.forms[0].pract_desc.value=\"\";\t\t\t\n\t}\n} // End of PractLookupRetVal().\n\n\tasync function getPractID()\n\t{\n\t\tvar facility_id=\"\";\n\t\tvar nursing_unit_code\t= \"`\"+document.forms[0].nursing_unit.value+\"`\";\n\t\tvar spl_code\t\t\t= \"`\"+document.forms[0].Splcode.value+\"`\";\n\n\t\tfacility_id\t\t\t\t=\"`\"+\"";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\"+\"`\";\n\t\tif(nursing_unit_code != \"\")\n\t\t{\n\t\t\tif(spl_code != \"\")\n\t\t\t{\n\t\t\t\tvar target\t\t\t\t= document.forms[0].practid;\n\t\t\t\tvar retVal\t\t\t\t=    new String();\n\t\t\t\tvar dialogTop\t\t\t= \"40\";\n\t\t\t\tvar dialogHeight\t\t= \"10\" ;\n\t\t\t\tvar dialogWidth\t\t\t= \"40\" ;\n\t\t\t\tvar features\t\t\t=\"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\t\tvar sql=\"\";\n\t\t\t\tvar search_desc=\"\";\n\t\t\t\tvar tit=\"\";\n\n\t\t\t\tsql=\"select practitioner_id, practitioner_name from ip_nursing_unit_for_pract_vw where facility_id=\"+facility_id+\" and nursing_unit_code=\"+nursing_unit_code+\" and practitioner_id in (select practitioner_id from am_practitioner  where primary_speciality_code=\"+spl_code+\" and eff_status = `E` union select practitioner_id from  am_pract_specialities where facility_id = \"+facility_id+\" and speciality_code =\"+spl_code+\")\";\n\n\t\t\t\tsearch_code=\"practitioner_id\";\n\t\t\t\tsearch_desc=\"practitioner_name\";\n\t\t\t\tvar tit=getLabel(\'Common.practitioner.label\',\'common\');\n\n\t\t\t\tretVal=await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&dispDescFirst=dispDescFirst&title=\"+encodeURIComponent(tit),arguments,features);\n\n\t\t\t\tif (!(retVal == null))\n\t\t\t\t{\n\t\t\t\t\tif (!(unescape(retVal) == null))\n\t\t\t\t\t{\n\t\t\t\t\t\tarr=unescape(retVal).split(\"::\");\n\t\t\t\t\t\tdocument.forms[0].pract_desc.value=arr[0];\n\t\t\t\t\t\tdocument.forms[0].practid.value=arr[1];\n\t\t\t\t\t\tPopulateMedicalTeam();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].pract_desc.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].practid.value=\"\";\n\t\t\t\t\t\tdocument.forms[0].team_id.value=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar error = getMessage(\'CAN_NOT_BE_BLANK\',\'common\');\n\t\t\t\terror = error.replace(\'$\',getLabel(\"Common.speciality.label\",\"Common\"));\n\t\t\t\talert(error);\t\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar error = getMessage(\'CAN_NOT_BE_BLANK\',\'common\');\n\t\t\terror = error.replace(\'$\',getLabel(\"Common.nursingUnit.label\",\"Common\"));\n\t\t\talert(error);\t\n\t\t}\n\t}\n\n\tfunction PopulateMedicalTeam()\n\t{ \t\n\t\t// Nanda 01/10/2002 \n\t\tvar selected = document.forms[0].team_id;\n\t\twhile ( selected.options.length > 0 )\n\t\t\tselected.remove(selected.options[0]);\n\t\tvar\tstr1 = \"\" ;\n\t\tvar\tstr2 = \"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\"\n\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\telement.text = str2; \n\t\telement.value= str1;\n\t\tdocument.forms[0].team_id.add(element);\n\n\t\tvar ippractid  = document.forms[0].practid.value;\n\t\tvar getservice = document.forms[0].practid.value;\n\t\tvar spl_code = document.forms[0].Splcode.value;\n\t\tif (ippractid != null && ippractid != \"\")\n\t\t{\n\t\t\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'querydept\' id=\'querydept\' method=\'post\' action=\'../../eIP/jsp/MedicalTeamPopulate.jsp\'><input type=\'hidden\' name=\'ippractid\' id=\'ippractid\' value=\'\"+ippractid+\"\'><input type=\'hidden\' name=\'booking\' id=\'booking\' value=\'AssignBed\'><input type=\'hidden\' name=\'spy_code\' id=\'spy_code\' value=\'\"+spl_code+\"\'></form></body></html>\";\n\t\t\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tparent.frames[2].document.querydept.submit();\n\t\t}\n\t}\n\n\tfunction ClearPractMedDtls()\n\t{\n\t\tdocument.forms[0].practid.value=\'\';\n\t\tvar selected = EmergencyTransfer_form.team_id;\n\t\twhile ( selected.options.length > 0 )\n\t\t\tselected.remove(selected.options[0]);\n\n\t\tvar\tstr1 = \"\" ;\n\t\tvar\tstr2 = \"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\telement.text = str2; \n\t\telement.value= str1;\n\t\tdocument.forms[0].team_id.add(element);\n\t}\n\n\t//added by kishore on 8/21/2004\n\tfunction validSpecialChars(obj)\n\t{\t\n\t\tvar val = obj.value.toUpperCase();\t\t\t\n\t\tobj.value = val;\t\n\t\tvar fields=new Array();\n\t\tvar names=new Array();\n\t\tfields[0]=obj;\n\t\tnames[0]=\"Bed Blocking Period\";\n\t\tif(SpecialCharCheck( fields, names,\'\',\"A\",\'\'))\n\t\t{\n\t\t\tcheckForMaxPeriod();\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tobj.select();\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n\nfunction specialChar(obj,val)\n{\n\tif(obj.value!=\'\')\n\t{\n\t\tvar fields1 = new Array(obj);\n\t\tvar names1 = new Array(obj.name.toUpperCase());\n\t\tvar messageFrame = \"\"; var error_page = \"\";\n\t\tif(SpecialCharCheck(fields1,names1,messageFrame,\"A\",error_page) )\n\t\t{\n\t\t\tif(val==\"Num\")\n\t\t\t{\n\t\t\t\tif(CheckNum(obj))\n\t\t\t\t\t{\n\t\t\t\t\t\t return true;\n\t\t\t\t\t}\n\t\t\t\t\telse \n\t\t\t\t\t{\n\t\t\t\t\t\t obj.focus();\n\t\t\t\t\t\t obj.value=\'\';\n\t\t\t\t\t\t return false;\n\t\t\t\t\t}\n\t\t\t}\n\t\t\telse if(val==\"Char\")\n\t\t\t{\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\n\t\t   obj.focus()\n\t\t   obj.value=\'\';\n\t\t   return false;\n\t\t}\n\t}\n\n}\n\n//added by kishore on 7/8/2004\nfunction checkForMaxPeriod()\n{\n\t if(document.forms[0].bed_blocking_period.value==\'\' ||document.forms[0].bed_blocking_period.value ==\'0\')\n\t{\n\t\tdocument.forms[0].bed_block_until.value=\'\';\n\t}\n\tvar period_no=eval(document.forms[0].bed_blocking_period.value);\n\tif(period_no>0)\n\t{\n\t\tif (eval(document.forms[0].bed_blocking_period.value) > eval(document.forms[0].def_max_period.value))\n\t\t{\n\t\t\tvar error = getMessage(\'BED_BLK_PRD_CANT_EXCEED\',\'IP\');\n\t\t\terror = error.replace(\'$\',getLabel(\"eIP.BlockPeriod.label\",\"IP\"));\n\t\t\talert(error);\n\t\t\tdocument.forms[0].bed_blocking_period.select();\n\t\t}\n\t\telse\n\t\t\tgetBlockBedDate1();\n\t}\n\t\n}\nfunction allowOnlyNumbers(event)\n{\n\tif (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 46))\n\t\treturn true;\n\telse return false;\n}\n\n\nfunction PopulateSubService()\n{\n\n}\n\n\nfunction setDesable()\n{\n\tdocument.getElementById(\'legend2\').innerHTML\t    =\t\"\";\n\tdocument.getElementById(\'select2\').style.visibility\t    =\t\"Hidden\"; \n}\n\n</script>\n</head>\n\n <body onload=\'getOnload_tfrDtls();\'onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> \n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<form name=\"EmergencyTransfer_form\" id=\"EmergencyTransfer_form\"  method=\"post\" action=\"../../servlet/eIP.EmergencyTransferServlet\" target=\"parent.frames[1]\">\n\t<table border=0 width=\"100%\" cellpadding=0 cellspacing=0>\n\t\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>\t\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\" width=\"20%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;&nbsp;</td>\n\t\t\t <td width=\"30%\" class=\'querydata\'><input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td align=\"right\" class=\"label\" width=\"15%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td width=\"35%\" class=\'querydata\'><input type=\"hidden\" name=\"admission_type\" id=\"admission_type\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >&nbsp;&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td> \n\t\t</tr>\n\n<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;&nbsp;</td>\n\t\t\t<td class=\'querydata\' width=\"30%\"><input type=\"hidden\" name=\"transfer_date\" id=\"transfer_date\"  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"> ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </td>\n\t\t\t<td align=\"right\" class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t<td width=\"35%\" class=\'querydata\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<input type=\"hidden\" name=\"transfer_type_code\" id=\"transfer_type_code\"  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\n\t\t\t\t\n</td>\n</tr>\n<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>\n\n<tr>\n\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" &nbsp;</td>\n\t\t<td class=\'querydata\' width=\"30%\">\n\n\t\t<SELECT name=\"reqstat\" id=\"reqstat\" onchange=\'disableselect()\'>\n\t\t<option value=\"\">---&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;---</option> \n\t\t<option value=\"1\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t<option value=\"2\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t</SELECT>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t</td>\n\t\t<td align=\"right\" class=\"label\" width=\"25%\">&nbsp;&nbsp;</td>\n\t\t<td></td>\n\t\t\t</tr>\n\t\t<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>\n\t\t<tr>\n\t\n\t\t<td align=\"right\" class=\"label\" width=\"20%\"  id=\'legend2\'></td>\n\t\t <td width=\"20%\" class=\'querydata\' colspan=4>\n\t\t<SELECT name=\"resnforrej\" id=\"resnforrej\" id=\'select2\' style=\'visibility:hidden\' >\n\t\t<option value=\"\" align=\'center\'>---&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;---</option> \n \n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<OPTION VALUE=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t \t</SELECT>\n\t\t\t<img align=\"center\" id=\'rejection\' src=\"../../eCommon/images/mandatory.gif\">\n\t\t</td> \n\n\n\t\n</tr>\n\t<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>\n\n\t\t</table>\n\n\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\n\t\t \n\t\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n\n\t<TABLE border=0 width=\"100%\" cellpadding=0 cellspacing=0>\n\t<tr>\n        \n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<td><input type=\"hidden\" class=\"button\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" onclick=\"ComputeBlDtl();\"></td> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<td align=\'right\'><input type=\"button\" class=\"button\" name=\"transfer\" id=\"transfer\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onclick=\"submitForm_confirm();\">&nbsp;<input type=\"button\" class=\"button\"  value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onclick=\"cancel();\">&nbsp;</td>\n\t</tr>\n\t\n\t</table>\t\n\t\t<input type=\"hidden\" name=\"modified_date_val\" id=\"modified_date_val\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"Change_Bedclass\">\n\t\t<input type=\'hidden\' name=\'modified_bed_type_code\' id=\'modified_bed_type_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\'hidden\' name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\"hidden\" name=\"tobedtype\" id=\"tobedtype\" value=\"\">\n\t\t<input type=\"hidden\" name=\"fr_team_id\" id=\"fr_team_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"open_enctr_gender\" id=\"open_enctr_gender\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type=\"hidden\" name=\"open_enctr_age\" id=\"open_enctr_age\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type=\"hidden\" name=\"bl_interface_yn\" id=\"bl_interface_yn\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"hidden\" name=\"fr_daily_rate\" id=\"fr_daily_rate\" value=\"0\">\n\t\t<input type=\"hidden\" name=\"to_daily_rate\" id=\"to_daily_rate\" value=\"0\">\n\t\t<input type=\"hidden\" name=\"bill_type_code\" id=\"bill_type_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"blng_class_code\" id=\"blng_class_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"blng_serv_code\" id=\"blng_serv_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"hidden\" name=\"continue_yn\" id=\"continue_yn\" value=\"\">\n\t\t<input type=\'hidden\' name = \'bl_operational\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t<input type=\"hidden\" name=\"def_max_period\" id=\"def_max_period\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\"hidden\" name=\"blocking_type_code\" id=\"blocking_type_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"bed_class_allowed\" id=\"bed_class_allowed\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\t\n\t\t<input type=\"hidden\" name=\"reqRadioBtn\" id=\"reqRadioBtn\" value=\"\"><!--Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866-->\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t<input type=\'hidden\' name=\'transfer_chargeable_yn\' id=\'transfer_chargeable_yn\' value=\'Y\'>\n\t\t<input type=\'hidden\' name=\'transfer_serv_charge\' id=\'transfer_serv_charge\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'surgery_reqd_yn\' id=\'surgery_reqd_yn\' value=\'Y\' >\n\t\t<input type=\'hidden\' name=\'addnl_dep_amt\' id=\'addnl_dep_amt\' value=\'\'>\n\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t<table border=0 cellpadding=0 cellspacing=0 align=\"right\" height=\'100%\' width=100%>\n\t<tr>\n\t\t<!-- MOD#06 Button is changed to hidden -->\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\n\t     <td class=\"label\">&nbsp;</td>\n         \n\t</tr>\n\t</table>\n<script>\n\n\t\tvar count=0\n\t\t\tif(count==0)\n\t\t\t{\n\t\t\t\tpopDynamicValues_confirm(document.forms[0].nursing_unit);\n\t\t\t\tcount++;\n\t\t\t}\n\nfunction cancel()\n{\n\twindow.close();\n}\n\n\n</script>\n\t</form>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t \n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );
	
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
 
	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;	
	ResultSet rs_opn		= null;	

	String bl_operational =	(String)session.getValue("bl_operational");
	String billing_group_id		= "";
	String billing_group_desc	= "";
	//String loginUser			= (String)session.getValue("login_user");
	String facilityId			= (String)session.getValue("facility_id");
	String modified_date_val	= "";
	String frnursingunitcode	= "";
	String frbedno				= "";
	String frpractitionerid		= "";
	String frpractdesc			= "";
	String frspecialitycode		= "";   
	String frspecialitydesc		= "";
	String frbedclass			= ""; 
	String frbedclassdesc		= ""; 
	String frnursingunitdesc	= "";
	String frroomno				= "";
	String frbedtype			= "";
	String frbedtypedesc		= "";
	int    frdailycharge		= 0;
	String age					= "";
	String gender				= "";
	String frservicecode		= "";
	String frservicedesc		= "";
	String frsubservcode		= "";
	String frsubservdesc		= "";
	String patient_class		= "";
	String frmeddesc			= "";
	String frmedid				= "";

	// Following Code is to Check the Module with Billing Interface 
	String install_yn			= "";

	StringBuffer SqlSB = new StringBuffer();
	int bed_block_period_max=0;
	String max_blk_type="";
	String bed_class_allowed ="";
	String block_period_max = "";


	try
	{
		con =ConnectionManager.getConnection(request);
		stmt		= con.createStatement();	
	
	
			
				install_yn=checkForNull(request.getParameter("bl_interfaced_yn"));
			    block_period_max=checkForNull(request.getParameter("bed_block_period_max"));
			    max_blk_type=checkForNull(request.getParameter("bed_block_period_max_type"));
			    bed_class_allowed=checkForNull(request.getParameter("change_bed_class_yn"));

				bed_block_period_max = Integer.parseInt(block_period_max);
				if(max_blk_type.equals("D"))
				 bed_block_period_max=(bed_block_period_max)*24; 
		
		/*
		SqlSB.append(" select nvl(bl_interfaced_yn,'N') bl_interfaced_yn , BED_BLOCK_PERIOD_MAX,BED_BLOCK_PERIOD_MAX_TYPE,CHANGE_BED_CLASS_YN from ip_param where facility_id='"+facilityId+"' ");
		try
		{
			stmt_bl=con.createStatement();
			rs_bl=stmt_bl.executeQuery(SqlSB.toString());
			if(rs_bl.next())
			{
				install_yn=rs_bl.getString("bl_interfaced_yn");
				BED_BLOCK_PERIOD_MAX=rs_bl.getInt("BED_BLOCK_PERIOD_MAX");
			    max_blk_type=rs_bl.getString("BED_BLOCK_PERIOD_MAX_TYPE");
			    bed_class_allowed=rs_bl.getString("CHANGE_BED_CLASS_YN");
			    if(max_blk_type.equals("D"))
				BED_BLOCK_PERIOD_MAX=(BED_BLOCK_PERIOD_MAX)*24; 
			}
			
		//added by kishore on 8/21/2004
			if(rs_bl		!= null)   rs_bl.close();
			if(stmt_bl   != null)   stmt_bl.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception @try1"+e);
		}
	
	if(SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());
	

	SqlSB.append(" select  from ip_param where facility_id='"+facilityId+"' ");

	*/

	

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block8Bytes, _wl_block8);

			java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt						= new java.util.Date();
			String d			= dateFormat.format( dt ) ;
			String min			= String.valueOf(dt.getMinutes()) ;
            if(min.length() == 1)   min = "0"+min ;

			d=d + " "+String.valueOf(dt.getHours())+":"+min;

			String patientid		= checkForNull(request.getParameter("patient_id"));			
			String eid				= checkForNull(request.getParameter("encounter_id"));

			session.putValue("encounter_id",eid);
			session.putValue("patientid",patientid);
	
			long encounterid = 0;
			String admissiondate	= "";
			String admissiontype	= "";
			String transfer_date2 = "";
			String transfer_type2 = "";
			String transfer_type_desc = "";

			String tonursingunitcode	= "" ;
			String tonursingunitdesc	= "" ;
			String toservicecode		= "" ;
			String tobedclass			= "" ;
			String tobedtype			= "" ;
			String tobedtypedesc		= "" ;
			String tobedclassdesc		= "" ;
			String tobedno				= "" ;
			String toroomno			= "" ;
			String tospecialitycode	= "" ;
			String tospecialitydesc	= "" ;
			String topractitionerid	= "" ;
			String topractdesc			= "" ;
			String toteamid			= "" ;
			String tosubservcode		= "" ;
			String TRN_TYPE 			= "" ;
			String blocking_period 	= "" ;
			String blocking_remark 	= "" ;
			String blocking_type_code 	= "" ;
			String mother_bed_status	= "" ;

			if(bl_operational.equals("Y"))
			{
				if(SqlSB.length() > 0)
					SqlSB.delete(0, SqlSB.length());

				SqlSB.append(" select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a, BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+eid+"' ");
				rs_opn = stmt.executeQuery(SqlSB.toString());
				while(rs_opn.next())
				{
					billing_group_id = rs_opn.getString("BLNG_GRP_ID");
					billing_group_desc = rs_opn.getString("SHORT_DESC");
				}
			}	

			if(rs_opn != null) rs_opn.close();
			if(stmt != null) stmt.close();
			
			if(SqlSB.length() > 0)
				SqlSB.delete(0, SqlSB.length());
/*
			SqlSB.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
			stmt_opn = con.createStatement();
			rs_opn = stmt_opn.executeQuery(SqlSB.toString());

			if (rs_opn.next())
			{
			}

*/
			
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);

	//ragha 9/6/2004

		if(SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());
		SqlSB.append(" select to_char(admission_date_time,'dd/mm/rrrr hh24:MI') admission_date, admission_short_desc,nursing_unit_code,nursing_unit_short_desc, specialty_code, specialty_short_desc, practitioner_id, practitioner_name,room_no,bed_no,bed_class_code,bed_class_short_desc, null dly_charge,  nursing_unit_type_code, bed_type_code,BED_TYPE_SHORT_DESC,gender,to_char (date_of_birth, 'dd/mm/rrrr') date_of_birth, service_code, service_short_desc,SUBSERVICE_CODE,SUBSERVICE_SHORT_DESC,subservice_short_desc,patient_class,team_desc,team_id, to_char(modified_date,'dd/mm/rrrr hh24:mi') modified_date from IP_OPEN_ENCOUNTER_VW where facility_id = '"+facilityId+"' and encounter_id = "+eid ); 
		
		stmt  = con.createStatement();
		rset  = stmt.executeQuery(SqlSB.toString());
		if(rset.next())
		{
			admissiondate		= checkForNull(rset.getString("admission_date"));
			admissiontype		= checkForNull(rset.getString("admission_short_desc"));
			frnursingunitcode	= checkForNull(rset.getString("nursing_unit_code")); 
			modified_date_val	= checkForNull(rset.getString("modified_date"));				
			frbedno				= checkForNull(rset.getString("bed_no"));
			frpractitionerid	= checkForNull(rset.getString("practitioner_id")); 
			frpractdesc			= checkForNull(rset.getString("practitioner_name"));
			frspecialitycode	= checkForNull(rset.getString("specialty_code"));   
			frspecialitydesc	= checkForNull(rset.getString("specialty_short_desc"));
			frbedclass			= checkForNull(rset.getString("bed_class_code"));  
			frbedclassdesc		= checkForNull(rset.getString("bed_class_short_desc")); 
			frnursingunitdesc	= checkForNull(rset.getString("nursing_unit_short_desc")); 
			frroomno			= checkForNull(rset.getString("room_no"));
			frbedtype			= checkForNull(rset.getString("bed_type_code")); 
			frbedtypedesc		= checkForNull(rset.getString("BED_TYPE_SHORT_DESC"));
			frdailycharge		= rset.getInt("dly_charge");
			age					= checkForNull(rset.getString("date_of_birth"));
			gender				= checkForNull(rset.getString("gender"));
			frservicecode		= checkForNull(rset.getString("service_code"));
			frservicedesc		= checkForNull(rset.getString("service_short_desc"));
			frsubservcode		= checkForNull(rset.getString("SUBSERVICE_CODE"));
			frsubservdesc		= checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
			patient_class		= checkForNull(rset.getString("PATIENT_CLASS"));
			frmeddesc			= checkForNull(rset.getString("TEAM_DESC"));
			frmedid				= checkForNull(rset.getString("TEAM_ID"));

		}
	
			if(rset != null) rset.close();
			if(rs_opn != null) rs_opn.close();
			if(stmt != null) stmt.close();	

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block17Bytes, _wl_block17);

	if(SqlSB.length() > 0)
		SqlSB.delete(0, SqlSB.length());
			

	SqlSB.append(" select to_char(REQUEST_DATE,'dd/mm/rrrr hh24:MI') request_date, TRANSFER_TYPE_SHORT_DESC, TRANSFER_TYPE_CODE,req_nursing_unit_code,ip_get_desc.ip_nursing_unit (facility_id, req_nursing_unit_code, 'en', '2') req_nursing_unit_short_desc,to_service_code, am_get_desc.am_service (to_service_code, 'en', '2') to_service_short_desc, to_subservice_code,am_get_desc.am_subservice (to_service_code, to_subservice_code, 'en', '2') to_subservice_short_desc,       req_bed_class_code, ip_get_desc.ip_bed_class (req_bed_class_code, 'en', '2') req_bed_class_short_desc,req_bed_type_code, ip_get_desc.ip_bed_type (req_bed_type_code, 'en', '2') req_bed_type_short_desc, req_bed_no,req_room_no, to_specialty_code, am_get_desc.am_speciality (to_specialty_code, 'en', '2') to_specialty_short_desc,to_practitioner_id, am_get_desc.am_practitioner (to_practitioner_id, 'en', '1') to_practitioner_name, to_team_id,am_get_desc.am_medical_team (facility_id, to_team_id, 'en', '2') to_team_short_desc, trn_type, blocking_period,blocking_remarks, blocking_type_code, delink_baby_yn from ip_bed_class_request_vw where encounter_id ='"+eid+"' and facility_id = '"+facilityId+"' and request_status='0' ");
	stmt  = con.createStatement();
	
	rset  = stmt.executeQuery(SqlSB.toString());
	if(rset.next())
	{
			transfer_date2	= checkForNull(rset.getString("request_date"));
			transfer_type_desc	= checkForNull(rset.getString("TRANSFER_TYPE_SHORT_DESC"));
			transfer_type2		= checkForNull(rset.getString("TRANSFER_TYPE_CODE"));

			tonursingunitcode	= checkForNull(rset.getString("REQ_NURSING_UNIT_CODE"));
			tonursingunitdesc	= checkForNull(rset.getString("REQ_NURSING_UNIT_SHORT_DESC"));
			toservicecode		= checkForNull(rset.getString("TO_SERVICE_CODE"));
			tobedclass			= checkForNull(rset.getString("REQ_BED_CLASS_CODE"));
			tobedtype			= checkForNull(rset.getString("REQ_BED_TYPE_CODE"));
			tobedtypedesc		= checkForNull(rset.getString("REQ_BED_TYPE_SHORT_DESC"));
			tobedclassdesc		= checkForNull(rset.getString("REQ_BED_CLASS_SHORT_DESC"));
			tobedno				= checkForNull(rset.getString("REQ_BED_NO"));
			toroomno			= checkForNull(rset.getString("REQ_ROOM_NO"));
			tospecialitycode	= checkForNull(rset.getString("TO_SPECIALTY_CODE"));
			tospecialitydesc	= checkForNull(rset.getString("TO_SPECIALTY_SHORT_DESC"));
			topractitionerid	= checkForNull(rset.getString("TO_PRACTITIONER_ID"));
			topractdesc			= checkForNull(rset.getString("TO_PRACTITIONER_NAME"));
			toteamid			= checkForNull(rset.getString("TO_TEAM_ID"));
			tosubservcode		= checkForNull(rset.getString("TO_SUBSERVICE_CODE"));
			TRN_TYPE 			= checkForNull(rset.getString("TRN_TYPE"));
			blocking_period 	= checkForNull(rset.getString("BLOCKING_PERIOD"));
			blocking_remark 	= checkForNull(rset.getString("BLOCKING_REMARKS"));
			blocking_type_code 	= checkForNull(rset.getString("BLOCKING_TYPE_CODE"));
			mother_bed_status	= checkForNull(rset.getString("DELINK_BABY_YN"));
	}

	if(rset != null) rset.close();
	if(stmt != null) stmt.close();	


            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(transfer_date2));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(transfer_date2));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(transfer_type_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(transfer_type2));
            _bw.write(_wl_block23Bytes, _wl_block23);

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
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

		 String contact_reason="";
		String contact_reason_code="";
	try{
		stmt = con.createStatement();
	    rset = stmt.executeQuery("select contact_reason_code, contact_reason from am_contact_reason where eff_status = 'E' and cancel_transfer_yn = 'Y' order by 2");   
        if( rset != null ) {
	      while(rset.next()) {
			 contact_reason   = rset.getString("contact_reason") ;
			 contact_reason_code   = rset.getString("contact_reason_code") ;
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(contact_reason_code ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(contact_reason));

          }
	    }
	}catch(Exception e) {out.println(e.toString()); e.printStackTrace();}
	

            _bw.write(_wl_block30Bytes, _wl_block30);
            {java.lang.String __page ="../../eIP/jsp/TransferDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("Change_Bedclass")},{ weblogic.utils.StringUtils.valueOf("admissiondate"), weblogic.utils.StringUtils.valueOf(admissiondate
                        )},{ weblogic.utils.StringUtils.valueOf("frnursingunitcode"), weblogic.utils.StringUtils.valueOf(frnursingunitcode
                        )},{ weblogic.utils.StringUtils.valueOf("frbedno"), weblogic.utils.StringUtils.valueOf(frbedno
                        )},{ weblogic.utils.StringUtils.valueOf("frpractitionerid"), weblogic.utils.StringUtils.valueOf(frpractitionerid
                        )},{ weblogic.utils.StringUtils.valueOf("frpractdesc"), weblogic.utils.StringUtils.valueOf(frpractdesc
                        )},{ weblogic.utils.StringUtils.valueOf("frspecialitycode"), weblogic.utils.StringUtils.valueOf(frspecialitycode
                        )},{ weblogic.utils.StringUtils.valueOf("frspecialitydesc"), weblogic.utils.StringUtils.valueOf(frspecialitydesc
                        )},{ weblogic.utils.StringUtils.valueOf("frbedclass"), weblogic.utils.StringUtils.valueOf(frbedclass
                        )},{ weblogic.utils.StringUtils.valueOf("frbedclassdesc"), weblogic.utils.StringUtils.valueOf(frbedclassdesc
                        )},{ weblogic.utils.StringUtils.valueOf("frnursingunitdesc"), weblogic.utils.StringUtils.valueOf(frnursingunitdesc
                        )},{ weblogic.utils.StringUtils.valueOf("frroomno"), weblogic.utils.StringUtils.valueOf(frroomno
                        )},{ weblogic.utils.StringUtils.valueOf("frbedtype"), weblogic.utils.StringUtils.valueOf(frbedtype
                        )},{ weblogic.utils.StringUtils.valueOf("frbedtypedesc"), weblogic.utils.StringUtils.valueOf(frbedtypedesc
                        )},{ weblogic.utils.StringUtils.valueOf("frdailycharge"), weblogic.utils.StringUtils.valueOf(frdailycharge
                        )},{ weblogic.utils.StringUtils.valueOf("age"), weblogic.utils.StringUtils.valueOf(age
                        )},{ weblogic.utils.StringUtils.valueOf("gender"), weblogic.utils.StringUtils.valueOf(gender
                        )},{ weblogic.utils.StringUtils.valueOf("frservicecode"), weblogic.utils.StringUtils.valueOf(frservicecode
                        )},{ weblogic.utils.StringUtils.valueOf("frservicedesc"), weblogic.utils.StringUtils.valueOf(frservicedesc
                        )},{ weblogic.utils.StringUtils.valueOf("frsubservcode"), weblogic.utils.StringUtils.valueOf(frsubservcode
                        )},{ weblogic.utils.StringUtils.valueOf("frsubservdesc"), weblogic.utils.StringUtils.valueOf(frsubservdesc
                        )},{ weblogic.utils.StringUtils.valueOf("patient_class"), weblogic.utils.StringUtils.valueOf(patient_class
                        )},{ weblogic.utils.StringUtils.valueOf("frmeddesc"), weblogic.utils.StringUtils.valueOf(frmeddesc
                        )},{ weblogic.utils.StringUtils.valueOf("frmedid"), weblogic.utils.StringUtils.valueOf(frmedid
                        )},{ weblogic.utils.StringUtils.valueOf("tonursingunitcode"), weblogic.utils.StringUtils.valueOf(tonursingunitcode
                        )},{ weblogic.utils.StringUtils.valueOf("tonursingunitdesc"), weblogic.utils.StringUtils.valueOf(tonursingunitdesc
                        )},{ weblogic.utils.StringUtils.valueOf("toservicecode"), weblogic.utils.StringUtils.valueOf(toservicecode
                        )},{ weblogic.utils.StringUtils.valueOf("tobedclass"), weblogic.utils.StringUtils.valueOf(tobedclass
                        )},{ weblogic.utils.StringUtils.valueOf("tobedtype"), weblogic.utils.StringUtils.valueOf(tobedtype
                        )},{ weblogic.utils.StringUtils.valueOf("tobedtypedesc"), weblogic.utils.StringUtils.valueOf(tobedtypedesc
                        )},{ weblogic.utils.StringUtils.valueOf("tobedclassdesc"), weblogic.utils.StringUtils.valueOf(tobedclassdesc
                        )},{ weblogic.utils.StringUtils.valueOf("toroomno"), weblogic.utils.StringUtils.valueOf(toroomno
                        )},{ weblogic.utils.StringUtils.valueOf("tobedno"), weblogic.utils.StringUtils.valueOf(tobedno
                        )},{ weblogic.utils.StringUtils.valueOf("tospecialitycode"), weblogic.utils.StringUtils.valueOf(tospecialitycode
                        )},{ weblogic.utils.StringUtils.valueOf("tospecialitydesc"), weblogic.utils.StringUtils.valueOf(tospecialitydesc
                        )},{ weblogic.utils.StringUtils.valueOf("topractitionerid"), weblogic.utils.StringUtils.valueOf(topractitionerid
                        )},{ weblogic.utils.StringUtils.valueOf("topractdesc"), weblogic.utils.StringUtils.valueOf(topractdesc
                        )},{ weblogic.utils.StringUtils.valueOf("toteamid"), weblogic.utils.StringUtils.valueOf(toteamid
                        )},{ weblogic.utils.StringUtils.valueOf("tosubservcode"), weblogic.utils.StringUtils.valueOf(tosubservcode
                        )},{ weblogic.utils.StringUtils.valueOf("TRN_TYPE"), weblogic.utils.StringUtils.valueOf(TRN_TYPE
                        )},{ weblogic.utils.StringUtils.valueOf("blocking_period"), weblogic.utils.StringUtils.valueOf(blocking_period
                        )},{ weblogic.utils.StringUtils.valueOf("blocking_remark"), weblogic.utils.StringUtils.valueOf(blocking_remark
                        )},{ weblogic.utils.StringUtils.valueOf("blocking_type_code"), weblogic.utils.StringUtils.valueOf(blocking_type_code
                        )},{ weblogic.utils.StringUtils.valueOf("mother_bed_status"), weblogic.utils.StringUtils.valueOf(mother_bed_status
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block35Bytes, _wl_block35);
 if(install_yn.equals("Y")) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Compute.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(modified_date_val));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(billing_group_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(billing_group_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(age));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bed_block_period_max));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bed_class_allowed));
            _bw.write(_wl_block52Bytes, _wl_block52);

	if(install_yn.equals("Y"))
	{
	
            _bw.write(_wl_block53Bytes, _wl_block53);

	}
	
            _bw.write(_wl_block54Bytes, _wl_block54);
 if(install_yn.equals("Y")) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Compute.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
		
		if(rset		!= null)   rset.close();
		if(stmt		!= null)   stmt.close();
	
	}catch(Exception e)
	{
		out.print("Exception :"+e);
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
	 
            _bw.write(_wl_block56Bytes, _wl_block56);
            _bw.write(_wl_block57Bytes, _wl_block57);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.transferdate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforTransfer.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestStatus.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reject.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
