package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __visitregistrationpromptpatidf1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/VisitRegistrationPromptPatIDF1.jsp", 1743500060189L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--    Function Name VisitRegistration\n    Created by M.Sathis Kumar on 13/12/2000 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<!--Above line added for this CRF HSA-CRF-0289-->\n<html>\n    <head>\n        <meta http-equiv=\"Expires\" content=\"0\">\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\'></link>\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n        <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n        <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n<script>\nfunction makeRequest(Obj) {  \n            //var xmlDoc=new ActiveXObject(\"Microsoft.XMLDom\")\n\t\t\tvar xmlDoc=\"\";\n\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\txmlStr =\"<root><SEARCH alt_id_name=\\\"\"+Obj.name+\"\\\" alt_id_value=\\\"\"+Obj.value+\"\\\" process_id=\'31\'/></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\t\t\t\n\t\t\tvar url = \"../../eMP/jsp/ServerValidationXML.jsp\";\n\t\t\txmlHttp.open(\"POST\", url, false);\n\t\t\txmlHttp.send(xmlDoc)\n\t\t\tresponseText=xmlHttp.responseText;\n\t\t\tresponseText = trimString(responseText) ;\t\t\t\t\n\t\t\teval(responseText)\n\t\t\t \n\t\t\tif(1<parseInt(document.forms[0].isAlternateIdCount.value)){ \n\t\t\tvar objval=\"\";\n\t\t\tif(Obj.name==\"alt_id1_no\")objval=\"search1\";\n            if(Obj.name==\"alt_id2_no\")objval=\"search2\";\n            if(Obj.name==\"alt_id3_no\")objval=\"search3\";\n            if(Obj.name==\"alt_id4_no\")objval=\"search4\";\n\t\t\tgetPatientID(objval);\n\t\t\t}\n\t\t\t\t\n}\n \n/*\n* Returns a function that waits for the state change in XMLHttpRequest\n*/\n\n async  function getPatientID(objval)\n        {   \n\t\t   // var pat_id=PatientSearch();\n\t\t   //Above line commented for this CRF HSA-CRF-0289\n\t\t    var isAlternateId=document.forms[0].isAlternateId.value;   \n\t\t\tvar alternatSearch=objval.name;    \n\t\t\tif(typeof alternatSearch===\"undefined\"){alternatSearch=objval;}\t\t\t\t\n\t\t\t\n    \t\tvar alternate_id_no=\"\";\n\t\t\tif(alternatSearch==\"search1\")alternate_id_no=document.forms[0].alt_id1_no.value; \n\t\t\tif(alternatSearch==\"search2\")alternate_id_no=document.forms[0].alt_id2_no.value; \n\t\t\tif(alternatSearch==\"search3\")alternate_id_no=document.forms[0].alt_id3_no.value; \n\t\t\tif(alternatSearch==\"search4\")alternate_id_no=document.forms[0].alt_id4_no.value; \n\t\t\tvar pat_id=await PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',alternatSearch,isAlternateId,alternate_id_no);\n\t\t\t \n            if( pat_id != null )\n            {\n                document.getElementById(\'patient_id\').value = pat_id \n                check_patient_id();\n            }\n\t\t\tif(typeof pat_id===\"undefined\"){ \n\t\t\t           document.forms[0].patient_id.value=\'\'; \n\t\t\t\t\t   document.getElementById(\'patient_name\').innerText=\'\'; \n\t\t\t\t\t   document.getElementById(\'years\').innerText=\'\'; \n\t\t\t\t\t   document.getElementById(\'months\').innerText=\'\'; \n\t\t\t\t\t   document.getElementById(\'days\').innerText=\'\'; \n\t\t\t\t\t   document.getElementById(\'sex\').innerText=\'\'; \n\t\t\t\t\t   document.getElementById(\'date_of_birth\').innerText=\'\'; \n\t\t\t\t\t   document.getElementById(\'date_of_birth_greg\').innerText=\'\'; \n\t\t\t\t\t   document.getElementById(\'nationality\').innerText=\'\'; \t\t\t\t\t    \n\t\t\t\t\t   document.forms[0].alt_id1_no.value=\'\'; \n\t\t\t\t\t   if(document.getElementById(\'nat_id_prompt_no\'))document.getElementById(\'nat_id_prompt_no\').innerText=\'\'; \n\t\t\t\t\t if(isAlternateId==\"true\"){\t\t\t\t\t    \n\t\t\t\t\t    document.getElementById(\'alt_id2_no\').value=\'\';\t\t\t\t\t     \n\t\t\t\t\t    document.getElementById(\'alt_id3_no\').value=\'\';\t\t\t\t\t   \n\t\t\t\t\t    document.getElementById(\'alt_id4_no\').value=\'\';                       \n\t\t\t\t\t    document.getElementById(\'oth_alt_id_no\').innerHTML=\'\';                       \n\t\t\t\t\t    document.getElementById(\'oth_alt_id\').innerHTML=getLabel(\'eMP.OtherAltNo.label\',\'MP\'); \t\t   \n\t\t\t\t\t  }else{\t\t\t\t\t \n\t\t\t\t\t   document.getElementById(\'alt_id2_no\').innerHTML=\'\'; \t\t\t\t\t   \n\t\t\t\t\t   document.getElementById(\'alt_id3_no\').innerHTML=\'\';\t\t\t\t\t   \n\t\t\t\t\t   document.getElementById(\'alt_id4_no\').innerHTML=\'\'; \t\t\t\t\t  \n\t\t\t\t\t   document.getElementById(\'oth_alt_id\').innerHTML=\'\';\t\t\t\t\t   \n\t\t\t\t\t   document.getElementById(\'oth_alt_id_no\').innerHTML=\'\'; \n\t\t\t\t\t  }\n\n\t\t\t\n\t\t\t\t\t\t\n\t\t\t}\t\n\t\t}\n\t\tfunction check_patient_id(obj){\n\t\t\n\t\t\tvar fields = new Array (document.forms[0].patient_id);\n        \tvar names = new Array (getLabel(\'Common.patientId.label\',\'common\'));\t\n\t\t\tvar error_jsp=\"\";\n\t\t\tvar messageFrame=\"\";\n\t\t\tif(SpecialCharCheck(fields,names,messageFrame,\"A\",error_jsp))\n\t\t    {\n\t\t\t\t  var HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'dummypromptpatient1\' id=\'dummypromptpatient1\' method=\'post\' action=\'../../eMP/jsp/PatReferralValidation.jsp\' target=\'prompt_patidf2\'><input type=\'hidden\' name=\'list_name\' id=\'list_name\' value=\'check_patient_id\'><input type=\'hidden\' name=\'prompt_patient_id\' id=\'prompt_patient_id\' value=\'\"+document.forms[0].patient_id.value+\"\'><input type=\'hidden\' name=\'q_clinic_code\' id=\'q_clinic_code\' value=\'\"+document.forms[0].q_clinic_code.value+\"\'><input type=\'hidden\' name=\'q_appt_ref_no\' id=\'q_appt_ref_no\' value=\'\"+document.forms[0].q_appt_ref_no.value+\"\'><input type=\'hidden\' name=\'q_booking_ref_no\' id=\'q_booking_ref_no\' value=\'\"+document.forms[0].q_booking_ref_no.value+\"\'><input type=\'hidden\' name=\'p_referral_id\' id=\'p_referral_id\' value=\'\"+document.forms[0].p_referral_id.value+\"\'><input type=\'hidden\' name=\'p_referral_id\' id=\'p_referral_id\' value=\'\"+document.forms[0].p_referral_id.value+\"\'><input type=\'hidden\' name=\'func_act\' id=\'func_act\' value=\'\"+document.forms[0].func_act.value+\"\'><input type=\'hidden\' name=\'calledFrom\' id=\'calledFrom\' value=\'\"+document.forms[0].calledFrom.value+\"\'><input type=\'hidden\' name=\'Unregpatbkgyn\' id=\'Unregpatbkgyn\' value=\'\"+document.forms[0].Unregpatbkgyn.value+\"\'><input type=\'hidden\' name=\'fromVR\' id=\'fromVR\' value=\'\"+document.forms[0].fromVR.value+\"\'><input type=\'hidden\' name=\'q_booking_type\' id=\'q_booking_type\' value=\'\"+document.forms[0].q_booking_type.value+\"\'>\";\n\n\t\t\t\t\tif(obj !=null){ //Added for this CRF HSA-CRF-0289\n\t\t\t\t\t\n\t\t\t\t\t  if(obj.name == \'alt_id1_no\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t  HTMLVal= HTMLVal + \"<input type = \'hidden\' name=\'alt_id1_no\' id=\'alt_id1_no\' value=\'\"+obj.value+\"\'><input type=\'hidden\' name=\'alt_id_type\' id=\'alt_id_type\' value=\'\"+document.forms[0].alt_id_type.value+\"\'>\" ;\n\t\t\t\t\t\t}\n\t\t\t\t\t  if(obj.name == \'alt_id2_no\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t  HTMLVal= HTMLVal + \"<input type = \'hidden\' name=\'alt_id2_no\' id=\'alt_id2_no\' value=\'\"+obj.value+\"\'><input type=\'hidden\' name=\'alt_id2_type\' id=\'alt_id2_type\' value=\'\"+document.forms[0].alt_id2_type.value+\"\'>\" ;\n\t\t\t\t\t\t}\n\t\t\t\t\t  if(obj.name == \'alt_id3_no\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t  HTMLVal= HTMLVal + \"<input type = \'hidden\' name=\'alt_id3_no\' id=\'alt_id3_no\' value=\'\"+obj.value+\"\'><input type=\'hidden\' name=\'alt_id3_type\' id=\'alt_id3_type\' value=\'\"+document.forms[0].alt_id3_type.value+\"\'>\" ;\n\t\t\t\t\t\t}\n\t\t\t\t\t  if(obj.name == \'alt_id4_no\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t  HTMLVal= HTMLVal + \"<input type = \'hidden\' name=\'alt_id4_no\' id=\'alt_id4_no\' value=\'\"+obj.value+\"\'><input type=\'hidden\' name=\'alt_id4_type\' id=\'alt_id4_type\' value=\'\"+document.forms[0].alt_id4_type.value+\"\'>\" ;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t     } //End HSA-CRF-0289 \t\t\n\t\t\t\t\t HTMLVal = HTMLVal+\"</form></body></html>\";\n\t\t\t\t\t parent.frames[1].document.write(HTMLVal);\n\t\t\t\t\t parent.frames[1].document.dummypromptpatient1.submit();\n\t\t\t\t}\n\t\t}\n\n\tasync function ButtonClick(flag)\n    {\n\t  var q_clinic_code=document.forms[0].q_clinic_code.value;\n\t  var q_appt_ref_no=document.forms[0].q_appt_ref_no.value;\n      var function_id = document.forms[0].function_id.value;\n\t  var q_from_funct=document.forms[0].q_from_funct.value;\n\t  var q_booking_ref_no= document.forms[0].q_booking_ref_no.value;\n\t  var p_referral_id=document.forms[0].p_referral_id.value;\n\t  var func_act= document.forms[0].func_act.value;\n\t  var q_booking_type= document.forms[0].q_booking_type.value;\n\t  var fromVR= document.forms[0].fromVR.value;\n     \n\t  if (flag==\"O\")\n      {\n\t \tif((document.forms[0].patient_id.value != \"\") )\n\t\t{\n\t\t\n\t\t\t\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'dummypromptpatient2\' id=\'dummypromptpatient2\' method=\'post\' action=\'../../eMP/jsp/PatReferralValidation.jsp\'><input type=\'hidden\' name=\'list_name\' id=\'list_name\' value=\'ok\'><input type=\'hidden\' name=\'prompt_patient_id\' id=\'prompt_patient_id\' value=\'\"+document.forms[0].patient_id.value+\"\'><input type=\'hidden\' name=\'q_clinic_code\' id=\'q_clinic_code\' value=\'\"+q_clinic_code+\"\'><input type=\'hidden\' name=\'q_appt_ref_no\' id=\'q_appt_ref_no\' value=\'\"+q_appt_ref_no+\"\'><input type=\'hidden\' name=\'q_from_funct\' id=\'q_from_funct\' value=\'\"+q_from_funct+\"\'><input type=\'hidden\' name=\'q_booking_ref_no\' id=\'q_booking_ref_no\' value=\'\"+q_booking_ref_no+\"\'><input type=\'hidden\' name=\'p_referral_id\' id=\'p_referral_id\' value=\'\"+p_referral_id+\"\'><input type=\'hidden\' name=\'func_act\' id=\'func_act\' value=\'\"+func_act+\"\'><input type=\'hidden\' name=\'fromVR\' id=\'fromVR\' value=\'\"+fromVR+\"\'><input type=\'hidden\' name=\'q_booking_type\' id=\'q_booking_type\' value=\'\"+q_booking_type+\"\'><input type=\'hidden\' name=\'from_PatIDF1\' id=\'from_PatIDF1\' value=\'true\'><input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'\"+function_id+\"\' >\";\n\n\t\t\t   HTMLVal = HTMLVal+\"</form></body></html>\";\n\t\t\t //parent.frames[1].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t       parent.frames[1].document.write(HTMLVal);\n\t\t\t   if(parent.frames[1].document.dummypromptpatient2)\n\t\t\t   parent.frames[1].document.dummypromptpatient2.submit();\n\t\t\t}else{\n\t\t\t\tif((parent.frames[0].document.forms[0].alt_id1_no.value == \"\") && (parent.frames[0].document.forms[0].patient_id.disabled !=  true))\n\t\t\t\t{\n\t\t\t\t\tvar error = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\t\t\t\t\terror = error.replace(\'$\',\'Patient ID\');\n\t\t\t\t\talert(error);\n\t\t\t\t\tif(parent.frames[0].document.forms[0].patient_id.disabled != true){\n\t\t\t\t\tparent.frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\telse if (flag==\"R\")\n     {\n\t\t   var patient_id_regd = await show_patient_registration();\n\t\t  \n\t\t\t if(patient_id_regd != null)\n                {\n\t\t\t\t\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'dummypromptpatient3\' id=\'dummypromptpatient3\' method=\'post\' action=\'../../eMP/jsp/PatReferralValidation.jsp\'><input type=\'hidden\' name=\'list_name\' id=\'list_name\' value=\'register\'><input type=\'hidden\' name=\'prompt_patient_id\' id=\'prompt_patient_id\' value=\'\"+patient_id_regd+\"\'><input type=\'hidden\' name=\'q_clinic_code\' id=\'q_clinic_code\' value=\'\"+q_clinic_code+\"\'><input type=\'hidden\' name=\'q_appt_ref_no\' id=\'q_appt_ref_no\' value=\'\"+q_appt_ref_no+\"\'><input type=\'hidden\' name=\'p_referral_id\' id=\'p_referral_id\' value=\'\"+p_referral_id+\"\'><input type=\'hidden\' name=\'func_act\' id=\'func_act\' value=\'\"+func_act+\"\'><input type=\'hidden\' name=\'fromchk\' id=\'fromchk\' value=\'N\'><input type=\'hidden\' name=\'q_booking_type\' id=\'q_booking_type\' value=\'\"+q_booking_type+\"\'><input type=\'hidden\' name=\'from_PatIDF1\' id=\'from_PatIDF1\' value=\'false\'><input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'\"+function_id+\"\'>\";\n\t\t\t\t\tHTMLVal = HTMLVal+\"</form></body></html>\";\n\t\t\t\t\tparent.frames[1].docum";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="ent.write(HTMLVal);\n\t\t\t\t\tparent.frames[1].document.dummypromptpatient3.submit();\n\t\t\t\t}\n         }\n         else\n              {\n\t\t\t\t\tvar Unregpatbkgyn = document.forms[0].Unregpatbkgyn.value;\n\t\t\t\t\tvar calledFrom = document.forms[0].calledFrom.value;\n\t\t\t\t\tif(calledFrom == \'Booking\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(Unregpatbkgyn == \"Y\")\n\t\t\t\t\t\t\tparent.window.returnValue=p_referral_id;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.window.returnValue=\"C\";\n\t\t\t\t\t\n\t\t\t\t\tparent.window.close();\n                }\n  }\n   \nasync function show_patient_registration()\n   {\n\t  var q_appt_ref_no=document.forms[0].q_appt_ref_no.value;\n      var q_booking_ref_no= document.forms[0].q_booking_ref_no.value;\n\t  var p_referral_id= document.forms[0].p_referral_id.value;\n\t  var func_act= document.forms[0].func_act.value;\n\t  var q_booking_type= document.forms[0].q_booking_type.value;\n\t   var retVal =  new String();\n\t   var dialogTop= \"72\";\n\t   var dialogHeight= \"90vh\" ;\n\t   var dialogWidth = \"80vw\" ;\n\t   /*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/\n\t   var isAlternateAddressAppl = document.forms[0].isAlternateAddressAppl.value;\n\t   var isAddressLengthIncAppl = document.forms[0].isAddressLengthIncAppl.value;\n\t   if(isAlternateAddressAppl == \"true\" || isAddressLengthIncAppl == \"true\")\n\t\t\tdialogWidth = \"80vw\" ;\n\t   /*End*/\n\t   var features  = \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no; scroll=no\";\n\t   var arguments = \"\" ;\n\t  // alert(\'q_booking_type:\'+q_booking_type)\n\t   retVal = await top.window.showModalDialog(\"../../eMP/jsp/PatientRegistrationMain.jsp?module_id=MP&function_id=PAT_REG&function_name=Register%20Patient&function_type=F&access=NYNNN&home_required_yn=N&appt_ref_no=\"+q_appt_ref_no+\"&booking_ref_no=\"+q_booking_ref_no+\"&p_referral_id=\"+p_referral_id+\"&func_act=\"+func_act+\"&q_booking_type=\"+q_booking_type+\"&title=\"+encodeURIComponent(getLabel(\'eMP.RegisterPatient.label\',\'MP\')),arguments,features);\n\t\tif( retVal != null )\n\t\t{\t\t\t\n\t\t   retVal = \'Y\'+retVal;\n\t\t   parent.window.returnValue=retVal;\n\t\t   parent.window.close();\t\t\t\t  \n\t\t } \n }  \n \n function closing()\n{\t\t\n\t\tvar Unregpatbkgyn = document.forms[0].Unregpatbkgyn.value;\n\t\tvar calledFrom = document.forms[0].calledFrom.value;\n\t\tvar p_referral_id= parent.frames[0].document.forms[0].p_referral_id.value;\n\t\tif(calledFrom == \'Booking\')\n\t\t{\n\t\t\tif(Unregpatbkgyn == \"Y\")\n\t\t\t\tparent.window.returnValue=p_referral_id;\n\t\t}\n\t\tif (parent.window.returnValue == null)\n\t\t{\t\n\t\t\tparent.window.returnValue=\'C\';\n\t\t}\n\t\tparent.window.close();\n}\n//below lines added by Venkatesh.S (4008) on 28-April-2012 againist RUT-CRF-0060 [IN029598]\nfunction moveOnMax1(field)\n{\nif(field.value.length>=field.maxLength && field !=null && field.id==\'barcode\')\n{\ndocument.getElementById(\"ok\").click();\n\n}\n}\n//end  RUT-CRF-0060 [IN029598]\n</script>\n\n        ";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n\t</head>\n    <body onUnload=\'closing();\' onLoad=\'FocusFirstElement();\' class=\'content\' topmargin=\'0\' bottommargin=\'0\' onKeyDown =\'lockKey()\'>\n        <form name=\'propmtpatientid\' id=\'propmtpatientid\' method=\'post\'>\n\t\t<input type=\'hidden\' name=\'isAlternateId\' id=\'isAlternateId\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\t\n        <br>\n\t\t\t<table width=\'97%\' cellpadding=\"2\" cellspacing=\"0\" align=\"center\" >\n                ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n                    <tr>\n                        <td class=\'label\' width=\'20%\' nowrap>\n                            ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t\t\t<!--Below line was added by venkatesh.S (4008) on 10-Oct-2012 aginst  ML-BRU-SCF-0336 [IN:034501]-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n                        <td width=\'30%\'  colspan=\'3\' nowrap class=\'fields\'>\n                            <!--below lines modified by Venkatesh.S (4008) on 28-April-2012 againist RUT-CRF-0060 [IN029598] -->\n                             <input type=\"text\" id=\'barcode\' name=\"patient_id\" id=\"patient_id\" size=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' maxlength=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'  onblur=\'ChangeUpperCase(this);\' onChange=\"if(check_patient_id()){document.forms[0].alt_id1_no.disabled=true;document.forms[0].search1.disabled=true;}\"  onKeyPress=\"return CheckForSpecChars(event)\" onkeyup=\"moveOnMax1(this);\"> <!--Rameez Added \'onKeyPress\' for ML-BRU-SCF-0483 [IN35430] on 28-09-2012-->\n\t\t\t\t\t\t\t <!--end  RUT-CRF-0060 [IN029598] -->\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t <input type=\'button\' class=\'button\' value=\'?\' name=\'search\' id=\'search\' onClick=\"getPatientID(this)\" >\n\t\t\t\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t   </td>\n                        ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t <td width=\'30%\'  colspan=\'3\' nowrap class=\'fields\'>\n                            <input type=\"text\" name=\"patient_id\" id=\"patient_id\" size=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  onblur=\'ChangeUpperCase(this);\' onChange=\"ChangeUpperCase(this);if(check_patient_id()){document.forms[0].alt_id1_no.disabled=true;document.forms[0].search1.disabled=true;}\" onKeyPress=\"return CheckForSpecChars(event)\" ><!--Rameez Added \'onKeyPress\' for ML-BRU-SCF-0483 [IN35430] on 28-09-2012--><input type=\'button\' class=\'button\' value=\'?\' name=\'search\' id=\'search\' onClick=\"getPatientID(this)\" ><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t   </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<!--end SCF ML-BRU-SCF-0336 [IN:034501] -->\n                        ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n                                <td  class=\'label\' width=\'20%\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n                                <td width=\'35%\' colspan=\'2\' class=\'fields\'>\n                                    <input type=\"text\" name=\"alt_id1_no\" id=\"alt_id1_no\" size=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onChange=\"if(document.forms[0].isAlternateId&&document.forms[0].isAlternateId.value==\'true\'){makeRequest(this);if(parseInt(document.forms[0].isAlternateIdCount.value)<2){if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}}else {if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}\" onblur=\'\'><input type=\'button\' class=\'button\' value=\'?\' name=\'search1\' id=\'search1\' onClick=\"getPatientID(this)\" >&nbsp;&nbsp;\n                                 </td>\n                        ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n                    </tr>\n                    </table>\n                     <!--added code for PMG2014-HSA-CRF-0001 [IN:050020]  -->\n\t\t\t\t\t <!--Below line added for this CRF HSA-CRF-0298 -->\n                    <table width=\'97%\' cellpadding=\"2\" cellspacing=\"0\" align=\"center\" height=\'25%\'>\n                   <tr>\n                    ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="                           \n                               <td class=\'LABEL\'  width=\'20%\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </td>\n\t\t\t\t\t           <td width=\'30%\' colspan=3 name=\'alt_id2_no\' id=\'alt_id2_no\'  class=\'data\'> </td>                                \n                        ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </td>\n\t\t\t\t\t           <td width=\'30%\' colspan=\'2\' class=\'fields\'>\n\t\t\t\t\t\t\t    <input type=\"text\" name=\'alt_id2_no\' id=\'alt_id2_no\' size=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'onChange=\"makeRequest(this);if(parseInt(document.forms[0].isAlternateIdCount.value)<2){if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}\" onblur=\'\'><input type=\'button\' class=\'button\' value=\'?\' name=\'search2\' id=\'search2\' onClick=\"getPatientID(this)\" >&nbsp;&nbsp; </td>\n                        ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t  <td class=\'LABEL\'  width=\'20%\' >&nbsp;</td>\n\t\t\t\t\t\t  <td class=\'data\' width=\'30%\'  colspan=3 colspan=3> &nbsp;</td>\n\t\t\t              ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="                            \n                                <td  class=\'label\' width=\'20%\' nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n                                <td width=\'35%\' colspan=2 name=\'alt_id3_no\' id=\'alt_id3_no\'class=\'data\'></td>\n                        ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" </td>\n\t\t\t\t\t           <td width=\'30%\' colspan=\'2\' class=\'fields\'>  \n\t\t\t\t\t\t\t   <input type=\"text\" name=\'alt_id3_no\' id=\'alt_id3_no\' size=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onChange=\"makeRequest(this);if(parseInt(document.forms[0].isAlternateIdCount.value)<2){if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}\" onblur=\'\'><input type=\'button\' class=\'button\' value=\'?\' name=\'search3\' id=\'search3\' onClick=\"getPatientID(this)\" >&nbsp;&nbsp; </td>\n                        ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t  <td class=\'LABEL\'  width=\'20%\' >&nbsp;</td>\n\t\t\t\t\t\t  <td class=\'data\' colspan=2  width=\'30%\' colspan=3> &nbsp;</td>\n\t\t\t              ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n                    </tr>\n                     <tr>\n                     ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n                                <td width=\'30%\' colspan=3 name=\'alt_id4_no\' id=\'alt_id4_no\'  class=\'data\'></td>\n                        ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" </td>\n\t\t\t\t\t           <td width=\'30%\' colspan=\'2\' class=\'fields\'>  \n\t\t\t\t\t\t\t   <input type=\"text\" name=\'alt_id4_no\' id=\'alt_id4_no\' size=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onChange=\"makeRequest(this);if(parseInt(document.forms[0].isAlternateIdCount.value)<2){if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}\" onblur=\'\'><input type=\'button\' class=\'button\' value=\'?\' name=\'search4\' id=\'search4\' onClick=\"getPatientID(this)\" >&nbsp;&nbsp; </td>\n                        ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t  <td class=\'LABEL\'  width=\'20%\' >&nbsp;</td>\n\t\t\t\t\t\t  <td class=\'data\' colspan=3  width=\'30%\' colspan=3> &nbsp;</td>\n\t\t\t              ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n                        \n                        <td  class=\'label\' width=\'20%\' nowrap>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n                        <td width=\'35%\' colspan=2 name=\'nat_id_prompt_no\' id=\'nat_id_prompt_no\' class=\'data\'></td>\n                          ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \t\t\t\t\t\t   \n\t\t\t\t\t\t    <td  class=\'label\' width=\'20%\' name=\'oth_alt_id\' id=\'oth_alt_id\'  nowrap>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n                            <td width=\'30%\' colspan=2  name=\'oth_alt_id_no\' id=\'oth_alt_id_no\' class=\'data\'></td>\n                      ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t \n                     </tr>\n                     <tr>\n                     ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n                     <td  class=\'label\' width=\'20%\' name=\'oth_alt_id\' id=\'oth_alt_id\'  nowrap></td>\n                     <td width=\'30%\' colspan=3 name=\'oth_alt_id_no\' id=\'oth_alt_id_no\' class=\'data\'></td>\n                      ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t \n                    </tr>\n\t\t\t\t\t</table>\n                    <!-- end code for PMG2014-HSA-CRF-0001 [IN:050020] -->\n\t\t\t\t\t  <table width=\'97%\' cellpadding=\"2\" cellspacing=\"0\" align=\"center\" height=\'40%\'>\n\t\t\t\t\t  <tr>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="                        \n                        <td  class=\'label\' width=\'20%\' nowrap>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n                        <td width=\'35%\' colspan=6 name=\'nat_id_prompt_no\' id=\'nat_id_prompt_no\' class=\'data\'></td>\n                          ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t  <td class=\'LABEL\'  width=\'20%\' >&nbsp;</td>\n\t\t\t\t\t\t  <td class=\'data\' colspan=6  width=\'30%\' colspan=3> &nbsp;</td>\n\t\t\t              ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t </tr>\n\t\t\t\t\t<tr>\n                        <td class=\'label\' width=\'20%\' nowrap>\n                            ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n                        </td>\n                        <td width=\'30%\' colspan=6 name=\'patient_name\' id=\'patient_name\' class=\'data\'>\n                        </td>\n                    </tr>\n\t\t\t\t\t\n\t\t\t      <tr>\n                        <td class=\'label\' width=\'20%\' >\n                            ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n                        </td>\n                        <td width=\'30%\' id=\'years\' class=\'data\'>\n                        </td>\n                        <td class=\'label\' width=\'2%\' nowrap>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n                        <td width=\'10%\'  id=\'months\' class=\'data\' align=\'center\'>\n                        </td>\n                        <td class=\'label\' width=\'3%\' nowrap>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n                        <td width=\'10%\'  id=\'days\' class=\'data\' align=\'center\'>\n                        </td>\n                        <td class=\'label\' width=\'15%\' nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n                    </tr>\n                <!--*** Changed on 18 May 2001 the sex and DOB labels were interchanged *** --> \n                  <tr>\n                        <td class=\'label\' width=\'20%\' nowrap>\n                            ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n                        </td>\n                        <td width=\'30%\' colspan=\'6\'  id=\'date_of_birth_greg\' class=\'data\'></td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'date_of_birth\' id=\'date_of_birth\' value=\'\'>\n                    </tr>\n                 \n                    <tr>\n                        <td class=\'label\' width=\'20%\' nowrap>\n                            ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n                        </td>\n                        <td width=\'30%\' colspan=\'6\'  id=\'sex\' class=\'data\'>\n                    </td>\n                    </tr>\n                    <tr>\n                        <td class=\'label\' width=\'20%\' nowrap>\n                            ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n                        </td>\n\t\t\t\t\t\t<td width=\'30%\' colspan=\'6\' id=\'nationality\' class=\'data\'></td>\n                    </tr>\n                </table>\n                <br>\n                <table cellpadding=\"0\" cellspacing=\"0\"  width=\'97%\' align=\'center\' height=\'5%\'>\n                    <tr>\n                        <td  align=\'center\'><input type=\"button\" name=\"ok\" id=\"ok\" value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' onClick=\"ButtonClick(\'O\');\" class=\"button\" ><input type=\"button\" name=\"cancel\" id=\"cancel\"      value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' onClick=\"ButtonClick(\'C\');\" class=\"button\"><input type=\"button\" name=\"register\" id=\"register\"   value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'   onClick=\"ButtonClick(\'R\');\" class=\"button\" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =">\n                        </td>\n                    </tr>\n                </table>\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n            <input type=\"hidden\" name=\"valid_patient_id\" id=\"valid_patient_id\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"Unregpatbkgyn\" id=\"Unregpatbkgyn\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t    <input type=\'hidden\' name=\'q_clinic_code\' id=\'q_clinic_code\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t\t<input type=\'hidden\' name=\'q_appt_ref_no\' id=\'q_appt_ref_no\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t    <input type=\'hidden\' name=\'calledFrom\' id=\'calledFrom\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t\t<input type=\'hidden\' name=\'q_from_funct\' id=\'q_from_funct\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t<input type=\'hidden\' name=\'q_booking_ref_no\' id=\'q_booking_ref_no\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t\t<input type=\'hidden\' name=\'p_referral_id\' id=\'p_referral_id\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t\t<input type=\'hidden\' name=\'func_act\' id=\'func_act\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t\t<input type=\'hidden\' name=\'fromVR\' id=\'fromVR\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t\t<input type=\'hidden\' name=\'q_booking_type\' id=\'q_booking_type\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t<input type=\'hidden\' name=\'alt_id_type\' id=\'alt_id_type\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t\t<!--Added for this CRF HSA-CRF-0289 -->\n\t\t\t<input type=\'hidden\' name=\'alt_id2_type\' id=\'alt_id2_type\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t\t<input type=\'hidden\' name=\'alt_id3_type\' id=\'alt_id3_type\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t\t<input type=\'hidden\' name=\'alt_id4_type\' id=\'alt_id4_type\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'isAlternateIdCount\' id=\'isAlternateIdCount\' value=\'\'> \n\t\t\t<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"><!--Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601-->\n\t\t\t<input type=\'hidden\' name=\'isAddressLengthIncAppl\' id=\'isAddressLengthIncAppl\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"><!--Added by Thamizh selvi on 13th Feb 2018 against ML-MMOH-CRF-0860.2-->\n        </form>\n    </body>\n    ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n</html>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale =((String)session.getAttribute("LOCALE"));
request.setCharacterEncoding("UTF-8");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

			request.setCharacterEncoding("UTF-8");

            String gen_file_yn      = request.getParameter("gen_file_yn");
			if(gen_file_yn==null) gen_file_yn="";
            String q_clinic_code    = request.getParameter("q_clinic_code");
			if(q_clinic_code==null) q_clinic_code="";
            String q_appt_ref_no    = request.getParameter("q_appt_ref_no");
			if(q_appt_ref_no==null) q_appt_ref_no="";
			
            String q_from_funct     = request.getParameter("q_from_funct")==null?"":request.getParameter("q_from_funct"); 
            String q_booking_ref_no = request.getParameter("q_booking_ref_no")==null?"":request.getParameter("q_booking_ref_no");
			String q_booking_type = request.getParameter("q_booking_type")==null?"":request.getParameter("q_booking_type");
 
            String p_referral_id    = request.getParameter("p_referral_id")==null?"":request.getParameter("p_referral_id"); 
			
            String func_act         = request.getParameter("func_act")==null?"":request.getParameter("func_act"); 
			String calledFrom         = request.getParameter("calledFrom");
			if(calledFrom==null) calledFrom =""; 
			
			String Unregpatbkgyn         = request.getParameter("Unregpatbkgyn");
			if(Unregpatbkgyn==null) Unregpatbkgyn ="N"; 
		
            String fromVR = request.getParameter("fromVR")==null?"":request.getParameter("fromVR");
            String facility_id       = (String) session.getValue("facility_id");
			if(facility_id==null) facility_id="";
            String oper_stn_id     = request.getParameter("oper_stn_id");
			if(oper_stn_id==null) oper_stn_id="";

			String function_id=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");
			
            String user_id         = (String) session.getValue("login_user");
			if(user_id==null) user_id="";
            if(fromVR == null)  fromVR= "" ;
			StringBuffer sql =new StringBuffer();

			Statement stmt = null ;
			ResultSet rset = null ;
			ResultSet rs=null;
			Connection con = null ;
			String locn_type = "";
			String register_pat_yn = "" ;
			//added code for PMG2014-HSA-CRF-0001 [IN:050020]
			String alt_id1_type_desc="";
			String alt_id2_type_desc="";
			String alt_id3_type_desc="";
			String alt_id4_type_desc="";
			String alt_id1_type="";
			String alt_id2_type="";
			String alt_id3_type="";
			String alt_id4_type="";
			String customer_id="";
			String patient_id_length="";
			String alt_id1_length="";
			String accept_oth_alt_id_yn="";
			String accept_national_id_no_yn="";
			String nat_id_prompt="";
			
			//Below line Added for HSA-CRF-0298
			String alt_id2_length="",alt_id3_length="",alt_id4_length="";
			boolean isAlternateId=false;
			PreparedStatement pstmt=null;
			
			boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601
			boolean isAddressLengthIncAppl = false;//Added by Thamizh selvi on 13th Feb 2018 against ML-MMOH-CRF-0860.2

            if (q_booking_ref_no.equals(""))
			{
				/* Added on 23/04/2003 by Mallikarjuna Reddy for disabling or enabling the Register Patient Button */
				if (p_referral_id.equals(""))
				{
					sql.append("select clinic_type from op_clinic where facility_id='"+facility_id+"' and clinic_code='"+ q_clinic_code +"'");

				}
				else
				{
					sql.append("select to_locn_type, to_locn_code from pr_referral_register where referral_id = '"+p_referral_id+"'");
				}
				/* End of the Addition on 23/04/2003 by Mallikarjuna Reddy for disabling or enabling the Register Patient Button */
			}
            else{
				sql.append("select b.locn_type,a.nursing_unit_code  from ip_booking_list a, ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id='"+facility_id+"' and a.bkg_lst_ref_no='"+ q_booking_ref_no +"'");
			}
 
            try
            {
            con = ConnectionManager.getConnection(request);
			isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601
			isAddressLengthIncAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");//Added by Thamizh selvi on 13th Feb 2018 against ML-MMOH-CRF-0860.2
			isAlternateId = CommonBean.isSiteSpecific(con,"MP","ALTERNATE_ID_LOOKUP");//Added for this CRF HSA-CRF-0298
            stmt = con.createStatement() ;
			
            rset = stmt.executeQuery(sql.toString());

			sql.setLength(0);
			
			if(!calledFrom.equals("Booking"))
			{
            if (q_booking_ref_no.equals("")){
				/* Added on 23/04/2003 by Mallikarjuna Reddy for disabling or enabling the Register Patient Button */
	            if (p_referral_id.equals(""))
				{
					if(rset.next()) locn_type = rset.getString(1) ;

					if(rset != null) rset.close();

					if (!q_appt_ref_no.equals(""))
					{
						sql.append(" select NVL(register_pat_yn, 'N') from am_os_user_locn_access_Vw where facility_id = '"+facility_id+"' and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
						sql.append("and appl_user_id = '"+user_id+"'  and locn_type = '"+locn_type+"' and locn_code = '"+q_clinic_code+"' ");  
					}
					else
					{
						sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_os_user_locn_access_Vw  where facility_id = '"+facility_id+"'  and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
						sql.append(" and appl_user_id = '"+user_id+"'");  
					}
				}
				else
				{
					String nursing_unit_code="";
					String nursing_unit_type="";
					if(rset!=null && rset.next())
						{
						nursing_unit_type = rset.getString(1) ;
						
						nursing_unit_code = rset.getString(2) ;
						
						if (nursing_unit_type==null) nursing_unit_type="";
						if (nursing_unit_code==null) nursing_unit_code="";
					    }

					if(rset != null) rset.close();
					
					if (calledFrom.equals("IP"))
					{
						if (!nursing_unit_code.equals("")){
								
								sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_os_user_locn_access_Vw  where facility_id = '"+facility_id+"' and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
								sql.append(" and appl_user_id = '"+user_id+"'  and locn_type = '"+nursing_unit_type+"' and locn_code = '"+nursing_unit_code+"' ");
								
							}
						else{
								sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_oper_stn  where facility_id = '"+facility_id+"' and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )" ); 
							}
					}
					else
					{
						sql.append(" select NVL(register_pat_yn, 'N') from am_os_user_locn_access_Vw  where facility_id = '"+facility_id+"'  and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
						sql.append(" and appl_user_id = '"+user_id+"' ");
							
					}
				}

		        rset = stmt.executeQuery(sql.toString());
			    if(rset.next()) register_pat_yn = (rset.getString(1).equals("Y") ? "" : "disabled" ) ;

				if(rset != null) rset.close();
				/* End of the Addition on 23/04/2003 by Mallikarjuna Reddy for disabling or enabling the Register Patient Button */
			}
			else{
                String nursing_unit_code="";
				String nursing_unit_type="";
				if(rset!=null && rset.next()){
					nursing_unit_type = rset.getString(1) ;
					
					nursing_unit_code = rset.getString(2) ;
					
				}

				if(rset != null) rset.close();

				if (!nursing_unit_code.equals("")){
						sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_os_user_locn_access_Vw  where facility_id = '"+facility_id+"'  and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
						sql.append(" and appl_user_id = '"+user_id+"' and locn_type = '"+nursing_unit_type+"' and locn_code = '"+nursing_unit_code+"' ");
					}
				else{
						sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_oper_stn  where facility_id = '"+facility_id+"' and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )");

				}      

		        rset = stmt.executeQuery(sql.toString());
			    if(rset.next()) register_pat_yn = (rset.getString(1).equals("Y") ? "" : "disabled" ) ;
				
				if(rset != null) rset.close();
			}
			
			}
			sql.setLength(0);
    
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(isAlternateId));
            _bw.write(_wl_block9Bytes, _wl_block9);
//added code for PMG2014-HSA-CRF-0001 [IN:050020]
                    rs = stmt.executeQuery("select alt_id1_reqd_yn,alt_id1_type,alt_id2_type,alt_id3_type,alt_id4_type,alt_id2_length,alt_id3_length,alt_id4_length,accept_oth_alt_id_yn,accept_national_id_no_yn,alt_id1_length,nat_id_prompt,mp_get_desc.mp_alternate_id_type (alt_id1_type,'en','1')alt_id1_type_desc,mp_get_desc.mp_alternate_id_type (alt_id2_type,'en','1')alt_id2_type_desc,mp_get_desc.mp_alternate_id_type (alt_id3_type,'en','1')alt_id3_type_desc,mp_get_desc.mp_alternate_id_type (alt_id4_type,'en','1')alt_id4_type_desc,patient_id_length,b.customer_id from mp_param, SM_SITE_PARAM b") ;
                    
                if(rs != null)
					{   
                    if(rs.next()) {
                   
                   alt_id1_type_desc=rs.getString("alt_id1_type_desc")==null?"":rs.getString("alt_id1_type_desc");
                   alt_id2_type_desc=rs.getString("alt_id2_type_desc")==null?"":rs.getString("alt_id2_type_desc");
                   alt_id3_type_desc=rs.getString("alt_id3_type_desc")==null?"":rs.getString("alt_id3_type_desc");
                   alt_id4_type_desc=rs.getString("alt_id4_type_desc")==null?"":rs.getString("alt_id4_type_desc");
                   nat_id_prompt=rs.getString("nat_id_prompt")==null?"":rs.getString("nat_id_prompt");
				   customer_id=rs.getString("customer_id")==null?"":rs.getString("customer_id");
				   alt_id1_type=rs.getString("alt_id1_type")==null?"":rs.getString("alt_id1_type");
				   patient_id_length=rs.getString("patient_id_length")==null?"":rs.getString("patient_id_length");
				   alt_id1_length=rs.getString("alt_id1_length")==null?"":rs.getString("alt_id1_length");
				   accept_oth_alt_id_yn=rs.getString("accept_oth_alt_id_yn")==null?"N":rs.getString("accept_oth_alt_id_yn");
				   accept_national_id_no_yn=rs.getString("accept_national_id_no_yn")==null?"N":rs.getString("accept_national_id_no_yn");				  
				   //Added for this CRF HSA-CRF-0298
				   alt_id2_type=rs.getString("alt_id2_type")==null?"":rs.getString("alt_id2_type");
				   alt_id3_type=rs.getString("alt_id3_type")==null?"":rs.getString("alt_id3_type");
				   alt_id4_type=rs.getString("alt_id4_type")==null?"":rs.getString("alt_id4_type");
				   alt_id2_length=rs.getString("alt_id2_length")==null?"":rs.getString("alt_id2_length");
				   alt_id3_length=rs.getString("alt_id3_length")==null?"":rs.getString("alt_id3_length");
				   alt_id4_length=rs.getString("alt_id4_length")==null?"":rs.getString("alt_id4_length");				   
				   //End this CRF HSA-CRF-0298
				  
                    }
					}
                    
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(customer_id.equals("RTN")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
 
                        if(alt_id1_type_desc !="")
                            {
							
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
if(alt_id2_type_desc!="" && !isAlternateId) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else if(alt_id2_type_desc!="" && isAlternateId) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else {  
            _bw.write(_wl_block26Bytes, _wl_block26);
 } 
						if(alt_id3_type_desc !="" && !isAlternateId){
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alt_id3_type_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
}else if(alt_id3_type_desc!="" && isAlternateId) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alt_id3_type_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else {  
            _bw.write(_wl_block31Bytes, _wl_block31);
 } 
            _bw.write(_wl_block32Bytes, _wl_block32);
 if(alt_id4_type_desc !=""&& !isAlternateId){
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(alt_id4_type_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else if(alt_id4_type_desc!="" && isAlternateId) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alt_id4_type_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else {
            _bw.write(_wl_block36Bytes, _wl_block36);
} //End this CRF HSA-CRF-0298 
						  if(!isAlternateId){
						  if(accept_national_id_no_yn.equals("Y")){
						    if(nat_id_prompt !=""){
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block38Bytes, _wl_block38);
}}else {  
            _bw.write(_wl_block31Bytes, _wl_block31);
 }} 
						   if(isAlternateId){
						   if(accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
}else {  
            _bw.write(_wl_block31Bytes, _wl_block31);
 }}
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!isAlternateId){
					 if(accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}else {  
            _bw.write(_wl_block31Bytes, _wl_block31);
 }}
            _bw.write(_wl_block43Bytes, _wl_block43);
if(isAlternateId){ 
						 if(accept_national_id_no_yn.equals("Y")){
						    if(nat_id_prompt !=""){
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block45Bytes, _wl_block45);
}}else {  
            _bw.write(_wl_block46Bytes, _wl_block46);
 } 
						 }
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RegisterPatient.label","mp_labels")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(register_pat_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(Unregpatbkgyn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(q_clinic_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(q_from_funct));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(q_booking_ref_no));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(p_referral_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(fromVR));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(q_booking_type));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(alt_id2_type));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(alt_id3_type));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(alt_id4_type));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(isAddressLengthIncAppl));
            _bw.write(_wl_block77Bytes, _wl_block77);

        }
        catch(Exception e){out.println(e);}
        finally
        {
			try{
			if(rs!=null)rs.close();
			if(rset != null)    rset.close() ;
            if(stmt != null)    stmt.close() ;
			}catch(Exception e){}
            
			if(con!=null) ConnectionManager.returnConnection(con,request);
        }
    
            _bw.write(_wl_block78Bytes, _wl_block78);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.year.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
}
