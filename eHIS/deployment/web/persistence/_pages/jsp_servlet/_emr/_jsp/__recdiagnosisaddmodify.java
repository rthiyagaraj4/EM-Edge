package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recdiagnosisaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisAddModify.jsp", 1743143804134L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisGetValidation.jsp", 1730014091638L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\">\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'javascript\'></script>\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script>\n<script src=\'../js/RecDiagnosisMain.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\'  language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCA/js/jquery-1.7.2.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n//Maheshwaran K added for TH-KW-CRF-165.1\nfunction callSetDiagCatg(){\n\tcallDiagCateg(parent.RecDiagnosisAddModify.document.getElementById(\'diagcode\'));\n}\n\n\tfunction setVal(obj)\n\t{\n\t\tif(obj.checked == true)\n\t\t\tobj.value=\'Y\';\n\t\telse\n\t\t\tobj.value=\'N\';\n\t}\n\n\tfunction setFocus1()\n\t{\n\t\tif(document.forms[0].mode.value != \'modify\')\n\t\t\tdocument.forms[0].code_set.focus();\n\t}\n\n\t\n\tfunction _refreshSet(){\n\t\tgetCodeSet();\n\t\tsetTermCode1();\n\n\t}\n\t//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013\n\t//Start\n\tfunction EnableNotifySetup()\n\t{\n\t\tvar notify_code=document.forms[0].notification_setup.value;\n\t\tvar notify_code1 = notify_code.split(\"&\"); \n\t\tvar notifiable_code=notify_code1[0];\n\t\tvar email_yn=notify_code1[1];\n\t\tvar deft_note_type=notify_code1[2];//Added senthil\n\t\t\t\n        var diagprob_code=document.forms[0].diagprob_code.value; \n        var diagprob_desc=document.forms[0].diagprob_desc.value;\t\n\t\tif(document.forms[0].notification_setup.value!=\'\')\n\t\t{ \n\t\t\t\n\t\t\tif(document.forms[0].notifiable_form_mand_yn.value==\"Y\"&&document.forms[0].diag_enc_level.value==\"N\")document.forms[0].notifi_frm_mand_gif.style.visibility=\'visible\';  //Added 24.2\n\t\t\t//if((document.forms[0].notifiable_form_mand_yn.value==\"Y\"&&diagprob_code!=\'\'&&diagprob_desc!=\'\') || (document.forms[0].notifiable_form_mand_yn.value==\"Y\"&&document.forms[0].diagprob_code.disabled&&diagprob_desc!=\'\')){ \n\t\t\tif((diagprob_code!=\'\'&&diagprob_desc!=\'\')||(document.forms[0].diagprob_code.disabled&&diagprob_desc!=\'\')){ \n\t\t\t\tdocument.forms[0].Addnotification.disabled=false;\t\t\t\n\t\t\t}\n\t\t\t/*else if(document.forms[0].notifiable_form_mand_yn.value==\"N\"&&diagprob_code==\'\'&&diagprob_desc==\'\' || document.forms[0].notifiable_form_mand_yn.value==\"N\"&&diagprob_code!=\'\'&&diagprob_desc!=\'\'){document.forms[0].Addnotification.disabled=false;\n\t\t\t}*//*else{ \n\t\t\tdocument.forms[0].Addnotification.disabled=true;\n\t\t\t}*/\n\t\t\tdocument.forms[0].notifiable_code.value=notifiable_code;\n\t\t\tdocument.forms[0].email_yn.value=email_yn;\n\t\t\tdocument.forms[0].deft_note_type.value=deft_note_type; //Added senthil\n\t\t}\n\t\telse \n\t\t{ \n\t\t\tdocument.forms[0].notifi_frm_mand_gif.style.visibility=\'hidden\';   //Added 24.2\n\t\t\tdocument.forms[0].Addnotification.disabled=true;\n\t\t\tdocument.forms[0].notifiable_code.value=notifiable_code;\n\t\t\tdocument.forms[0].email_yn.value=email_yn;\n\t\t\tdocument.forms[0].deft_note_type.value=deft_note_type; //Added senthil\n\t\t}\n\t}\n\t//End\t\n</script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\'setFocus1();callSetDiagCatg();\' >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<script>\n\nfunction decider()\n{\n\tcode_indicator = document.forms[0].code_indicator.value;\n\t\n\t/*\n\tif(code_indicator == \'C\')\n\t\taddAssociateCodes();\n\telse if(code_indicator == \'D\')*/\n\t\taddAssociateCodes1();\n}\n\n\nasync function addAssociateCodes()\n{\n\n\t\n\tcode_indicator = document.forms[0].code_indicator.value;\n\t\n\tif(code_indicator == \'C\')\n\t\tcode_indicator = \'E\';\n\telse if(code_indicator == \'D\')\n\t\tcode_indicator = \'A\';\n\t\n\tdiag_desc = document.forms[0].diagprob_desc.value;\n\tp_scheme = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\tvar associate_codes = document.forms[0].associate_codes.value;\n\n\tdiag_code = document.forms[0].diagprob_code.value;\n\t\n\tvar retVal\t\t\t\t= \"\";\n\tvar dialogHeight\t\t= \"18\";\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\n\tvar scheme_desc= document.forms[0].scheme_desc.value; \n\tvar Encounter_Id= document.forms[0].Encounter_Id.value ;\n\tvar p_auth_yn=\"N\";\n    var s = document.forms[0].scheme.value;\n\tvar age = document.forms[0].age.value;\n\tvar sex = document.forms[0].sex.value;\n\tvar dob = document.forms[0].dob.value;\n\t\n\tvar arguments\t\t\t= \"\" ;\n\t\n\tvar mode =  document.forms[0].mode.value;\n\n\tvar qs1 = \"code_indicator=\" + code_indicator + \"&diag_desc=\" + diag_desc + \"&title=\"+scheme_desc+\" Code List&p_diag_code=\"+s+\"&p_diag_scheme_desc=\"+scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&p_auth_yn=\"+p_auth_yn+\"&cause_indicator=&Age=\" + age + \"&Sex=\" + sex + \"&Dob=\" + dob + \"&p_scheme=\" +  p_scheme +\"&diag_code=\"+diag_code+\"&term_set_id=\"+scheme_desc+\"&associate_codes=\"+associate_codes+\"&mode=\"+mode;;\n\t\n\t//retVal = window.showModalDialog(\"../../eCA/jsp/AddAssociateCodeFrames.jsp?\" + qs1,arguments,features);\n\tretVal = await window.showModalDialog(\"../../eMR/jsp/AddAssociateCodeFrames.jsp?\" + qs1,arguments,features);\n\n\tif(retVal != null)\n\t\tdocument.forms[0].associate_codes.value = retVal;\n\t\t\n}\n\nasync function addAssociateCodes1()\n{\n\tcode_indicator = document.forms[0].code_indicator.value;\n\tif(code_indicator == \'C\')\n\t\tcode_indicator = \'E\';\n\telse if(code_indicator == \'D\')\n\t\tcode_indicator = \'A\';\n\t\n\tdiag_desc = document.forms[0].diagprob_desc.value;\n\tp_scheme = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\tvar associate_codes = document.forms[0].associate_codes.value;\n\tvar associate_codes_modify = document.forms[0].associate_codes_modify.value;\n\n\tdiag_code = document.forms[0].diagprob_code.value;\n\t\n\tvar retVal\t\t\t\t= \"\";\n\tvar dialogHeight\t\t= \"60vh\" ;\n\tvar dialogWidth\t\t\t= \"70vw\" ;\n\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\n\tvar scheme_desc= document.forms[0].scheme_desc.value; \n\tvar Encounter_Id= document.forms[0].Encounter_Id.value ;\n\tvar p_auth_yn=\"N\";\n    var s = document.forms[0].scheme.value;\n\tvar age = document.forms[0].age.value;\n\tvar sex = document.forms[0].sex.value;\n\tvar dob = document.forms[0].dob.value;\n\tvar code_set = document.forms[0].code_set.value;\n\t\n\tvar mode =  document.forms[0].mode.value; //Added for this CRF GDOH-CRF-0082\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar qs1 = \"code_indicator=\" + code_indicator + \"&title=\"+scheme_desc+\" Code List&p_diag_code=\"+s+\"&p_diag_scheme_desc=\"+scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&p_auth_yn=\"+p_auth_yn+\"&cause_indicator=&Age=\" + age + \"&Sex=\" + sex + \"&Dob=\" + dob + \"&p_scheme=\" +p_scheme +\"&diag_code=\"+diag_code+\"&code_set=\"+code_set+\"&associate_codes=\"+associate_codes+\"&associate_codes_modify=\"+associate_codes_modify+\"&mode=\"+mode+ \"&diag_desc=\" + diag_desc;  //Modified by Sangeetha for ML-MMOH-CRF-0733\n\t\t\n\t\t\t\t\t\n\t\t//Above line modified for this CRF GDOH-CRF-0082\n\t\t\n\t\t//retVal = window.showModalDialog(\"../../eCA/jsp/AddDaggerCodeFrames.jsp?\" + qs1,arguments,features);\n\t\tretVal = await top.window.showModalDialog(\"../../eMR/jsp/AddDaggerCodeFrames.jsp?\" + qs1,arguments,features);\n\t\tif(retVal != null )\n\t\t\tdocument.forms[0].associate_codes.value = retVal;\n\t\t\t\t\t\n//Below line added for this CRF GDOH-CRF-0082  \n\t\t//if(retVal!=null){\n if(document.forms[0].diagnosisPmb&&document.forms[0].diagnosisPmb && document.forms[0].diagnosisPmb&&document.forms[0].diagnosisPmb.value==\"true\"){\n\t   if(retVal !=\"\" && retVal != null && retVal != undefined){ \n\t\t\t\tvar supportdiagcode=\"\";\n\t\t\t\tvar ret1=unescape(retVal);\t\t\t\t\t\n\t\t\t\tvar diag_code = ret1.split(\"|\");\t\t\t\t\n\t\t\t\tfor(var i=0; i<diag_code.length; i++){\n\t\t\t\t\tvar temp=diag_code[i].split(\'~\');\n\t\t\t\t\tvar str1 = new String(temp);\t\t\t   \n\t\t\t\t\tvar indx=str1.indexOf(\",\");\t\t\t    \n\t\t\t\t\tvar code=str1.substring(0,indx); \t\t\t \n\t\t\t\t\tsupportdiagcode+=\"\'\"+code+\"\'\"+\",\";\t\t\t\t\t\t\t\t   \n\t\t\t\t}\n\t\t if(supportdiagcode!=\"\")supportdiagcode=supportdiagcode.substring(0,supportdiagcode.length-1); \t\t\t\n            document.forms[0].pmbsupportdiag.value = supportdiagcode; \n            document.forms[0].totsupportdiagCount.value = diag_code.length;            \n            PMBValidation();\t\t\t\n\t\t}\t\t\t\n\t}\n//End GDOH-CRF-0082\t\n}\n\n\nfunction callDesc(Obj)\n{\n\tdocument.getElementById(\'view_link\').style.visibility=\'hidden\';\n\n\t//Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123\n\tvar termset_id = document.forms[0].code_set.value;\t\n\n\tvar xmlDoc = \"\"\n\tvar xmlHttp = new XMLHttpRequest()\n\txmlStr =\"<root><SEARCH termset_id=\\\"\"+termset_id+\"\\\" action=\'getFreeTextApplYN\' /></root>\"\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\txmlHttp.open(\"POST\",\"../jsp/MRIntermediate.jsp\",false)\n\txmlHttp.send(xmlDoc)\n\tresponseText=xmlHttp.responseText\n\tvar free_text_applicable_yn\t= trimString(responseText);\n\t//End ML-MMOH-SCF-2123\n\t\n\tif(Obj.value == \"\")\n\t{ \n\t    //Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123\n\t    if(free_text_applicable_yn == \'Y\'){      \n\t\t\tdocument.forms[0].diagprob_desc.disabled = false;\n\t\t}else{\n\t\t\tdocument.forms[0].diagprob_desc.disabled = true;\n\t\t}\n\t\t//End ML-MMOH-SCF-2123\n\n\t\tdocument.forms[0].LongDescription.value=\"\";\n\t\tdocument.forms[0].diagprob_desc.value=\"\";\n\t\tdocument.forms[0].Description.value=\"\";\t\n\t\tdocument.forms[0].exclamation.style.visibility=\'hidden\';\n\t\t//document.forms[0].view_link.style.visibility=\'hidden\';\n\t\tdocument.forms[0].ntf_button.style.visibility=\'hidden\';\tdocument.forms[0].AddAssociateCodes.disabled=true;\n\t\tdocument.forms[0].dagger_independent_yn.value=\"N\";\n\t\tdocument.forms[0].high_risk.style.visibility=\'hidden\'  // Saantha\n\n\n\t\tif(document.forms[0].isMultiDescAppl.value == \"true\")\n\t\t{ // added by mujafar for ML-MMOH-CRF-1281\n\t\t\tdocument.getElementById(\'other_disp1\').style.visibility=\'hidden\';\n\t\t\tdocument.getElementById(\'other_disp2\').style.visibility=\'hidden\';\n\t\t\n\t\t}\n\t\t\n\t\t//Below line Added for this CRF Bru-HIMS-CRF-024.2\n\t\tvar diagprob_code=document.forms[0].diagprob_code.value; \n        var diagprob_desc=document.forms[0].diagprob_desc.value;\t   \n\t\tif(document.forms[0].notification_setup.value!=\'\'&& document.forms[0].notifiable_form_mand_yn.value==\"Y\" && diagprob_code==\'\'&& diagprob_desc==\'\')\n\t\t{  \n\t\t\tdocument.forms[0].Addnotification.disabled=true;\n\t\t}\n\t\t\n\t\t//Below line added for this CRF GDOH-CRF-0082\n\t\tif(document.forms[0].diagnosisPmb&&document.forms[0].diagnosisPmb.value==\"true\"){\n\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'hidden\';\t\t\t\t\t\t\n\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=\"\";\n\t\t\tdocument.forms[0].totsupportdiagCount.value=\"\";\t\n            document.forms[0].pmbsupportdiag.value=\"\";\t\n\t\t}\n\t\t//End GDOH-CRF-0082\t\n\t\t\t\n\t}\n\telse\n\t\tObj.value = Obj.value.toUpperCase();\t\n\n\t\n\tif(makeValidString(Obj)==false)\n\treturn false;\n\n\tvar sex = document.forms[0].sex.value;\n\tvar dob = document.forms[0].dob.value;\n\n\tvar mode =  document.forms[0].mode.value;\n\tvar called_from_ip =  document.forms[0].called_from_ip.value;\n\tvar code_set =  document.forms[0].code_set.value;\n\tvar modal_yn = document.forms[0].modal_yn.value;\n\t\n\tif(mode==\"modify\")\n\t{\n\t\treturn false;\n\t}\n\t//Monday, October 18, 2010  IN024381  -SCF-SRR20056-SCF-5625\n//\tif(trimCheck(Obj.value)==\"\")\n\tif((Obj.value)==\"\")\n\t{\n\t\tdocument.forms[0].diagprob_desc.disabled = false;\n\t\tdocument.forms[0].diagprob_desc.focus();\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\t\n\t\tdocument.forms[0].diagprob_desc.disabled = true;\n\t\tdocument.forms[0].diagprob_desc.value = \'\';\n\t}\n\n    var pq = document.forms[0].scheme.value;\n\n\n    var stagecode = document.forms[0].diag_stage.value;\n\tvar isMultiDescAppl = document.forms[0].isMultiDescAppl.value; // added by mujafar for ML-MMOH-CRF-1281\n    if (pq == 1 || pq == 2)\n    {\n\t\t //  var p_diag_code = Obj.value;\n\t\t//Monday, October 18, 2010  IN024381  -SCF-SRR20056-SCF-5625\n\t\t//var p_diag_code = encodeURIComponent(Obj.value);\n//\t\tvar p_diag_code = trimString(Obj.value);\n\t\tvar p_diag_code = Obj.value;\n//\t\tObj.value=p_diag_code;\n        var indicator= \"\";\n        if(pq==\'2\')\n            indicator = document.forms[0].cause_ind.value; //chk if the form field is a hidden field or the select box object\n        var p_scheme  = ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =";\n        var sensitive=\'N\';\n\n\n\t\tvar authorizeButton=parent.RecDiagnosisOpernToolbar.document.forms[0].authorizeButton.value;\n\t\tif(parent.RecDiagnosisOpernToolbar.document.forms[0].mode)\n\t\tparent.RecDiagnosisOpernToolbar.document.forms[0].mode.value=\'Authorize Mode\';\n        if(parent.RecDiagnosisOpernToolbar.document.forms[0].authorize!=null)\n        {\n           if(parent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value==\"Normal Mode\")\n                sensitive=\'Y\';\n        }\n\n\t\t\n        htmlVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eMR/jsp/DiagRecodePatProblemVal.jsp\'><input type=\'hidden\' name=\'p_stage_code\' id=\'p_stage_code\' value=\'\"+stagecode+\"\'><input type=\'hidden\' name=\'p_diag_code\' id=\'p_diag_code\' value=\'\"+p_diag_code+\"\'><input type=\'hidden\' name=\'p_scheme\' id=\'p_scheme\' value=\'\"+p_scheme+\"\'><input type=\'hidden\' name=\'p_cause_indicator\' id=\'p_cause_indicator\' value=\'\"+indicator+\"\'><input type=\'hidden\' name=\'p_sensitive_yn\' id=\'p_sensitive_yn\' value=\'\"+sensitive+\"\'><input type=\'hidden\' name=\'authorizeButton\' id=\'authorizeButton\' value=\'\"+authorizeButton+\"\'><input type=\'hidden\' name=\'Sex\' id=\'Sex\' value=\'\"+sex+\"\'><input type=\'hidden\' name=\'Dob\' id=\'Dob\' value=\'\"+dob+\"\'><input type=\'hidden\' name=\'code_set\' id=\'code_set\' value=\'\"+code_set+\"\'><input type=\'hidden\' name= \'associate_codes\' id= \'associate_codes\' value=\'\" + document.forms[0].associate_codes.value + \"\'><input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'><input type=\'hidden\' name=\'calledFromDeathReg\' id=\'calledFromDeathReg\' value=\'\'><input type=\'hidden\' name=\'isMultiDescAppl\' id=\'isMultiDescAppl\' value=\'\"+isMultiDescAppl+\"\'></form></body></html>\";\n\t\t// Modified by mujafar for ML-MMOH-CRF-1281\t\n\t\t\n\t\tif(called_from_ip == \"Y\" || modal_yn == \"Y\") /* || \'<calledFromDeathReg%>\' == \"Y\" */\n\t\t{ \n\t\t\t  \n\t\t\tparent.messageFrame.document.write(htmlVal);\n\t\t    parent.messageFrame.document.form1.submit();\n\t\t}\n\t\telse\n\t\t{\n\t        top.content.workAreaFrame.support.document.body.insertAdjacentHTML(\'afterbegin\',htmlVal);\n\t\t    top.content.workAreaFrame.support.document.form1.submit();\n\t\t}\n    }\n\t\n}\n\n</script>\n<form name=\'RecDaignosis_form\' id=\'RecDaignosis_form\'  action=\'../../servlet/eMR.RecDiagnosisServlet\' method=\'post\' target=\'messageFrame\'>\n<font size=1>\n<div>\n\t<table border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\">\n\t<tr height=\'1\'> \n\t<!--<th colspan=\'10\'  style=\'BACKGROUND-COLOR: #ffc5b5;COLOR: black;\' class=\"COLUMNHEADER\"><font=\'verdana\' size=2 >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font></th>-->\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<td class=\"COLUMNHEADER\" colspan=\'5\' style=\'BACKGROUND-COLOR: #ffc5b5;COLOR: black;\'><font=\'verdana\' size=\'2\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></td>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<td class=\"COLUMNHEADER\" colspan=\'5\' style=\'BACKGROUND-COLOR: #ffc5b5;COLOR: black;\'><font=\'verdana\' size=\'2\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t    <td width=\'18%\' class=\'fields\'><select name=\"code_set\" id=\"code_set\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" onblur=\'\' onChange=\"getCodeSet(\'x\');/*showTable(this);*/setTimeout(\'setTermCode1()\',100);\" onmousewheel=\'return false;\'><option value=\'\'>----- ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" -----</option>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t/*\n\t\t\t\t\t\tThis logic for the the DefaultTerSet selected.\n\t\t\t\t\t*/\n\t\t\t\t\t\n\t\t\t\t\tvar code=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t//setTimeout(\"getCodeSet()\",500);  // commented for PE\n\t\t\t\t\tsetTimeout(\'_getTableDefaultTermSet(\\\"\"+code+\"\\\")\',700);\n\t\t\t\t\tsetTimeout(\"setTermCode1()\",700)\t\t\t\n\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n        </select><img  src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\t<td class=\'label\' width=\'20%\' ></td>\n\t<td class=\'label\' width=\'20%\' ></td>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<td class=\'label\' width=\'20%\' ></td>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<td class=\'button\' width=\'20%\' align=\"right\"><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' onClick=\"expandColapseframe(\'E\')\" name=\'expand\' id=\'expand\'></input><input type=\'button\'  class=\'button\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onClick=\"expandColapseframe(\'C\')\" name=\'collapse\'></input></td> \n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</tr>\n<tr>\n\t<table border=0 cellspacing=0 cellpadding = 3 width=\'100%\' style=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'DiagTable\'>\n\t<tr>\n\t\t<td class=\'label\' width=\'12%\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t<td class=\'fields\' width=\'18%\'><input type=\'textbox\'  name=\'diagprob_code\' id=\'diagprob_code\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  size=\'5\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="  onblur= \'getDrugIntrValidation();callDesc(this);//getDescription();\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" onchange=\'checkDiagProbDesc();\'></td><!--getDrugIntrValidation() added by kamatchi s -->\t<!-- onChange=\'clear_notify();\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" is removed from in modify mode becoz of it shows browse problem -->\t\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\n\t\t<td class=\'fields\' colspan=\'3\'>\n\n\t\t<!--Added by Ashwini on 29-Jun-2018 for ML-MMOH-CRF-1187-->\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t<input type=\"text\"  name=\"diagprob_desc\" id=\"diagprob_desc\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" size=\'50\'  maxlength = \'100\'onblur=\'enableExternal1();checkMaxLimit(this);\' onchange=\'checkDiagProbCode();\' onKeyPress=\"return CheckForSpecChars_freetext(event);\" disabled>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<textarea name=\"diagprob_desc\" rows=\'3\' cols=\'70\' maxlength = \'100\' onblur=\'enableExternal1();checkMaxLimit(this);\' onchange=\'checkDiagProbCode();\' onKeyPress=\"return CheckForSpecChars_freetext(event);\" disabled>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</textarea>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n\t\t<input type=\'button\' class=\'button\' value=\'?\' ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" onclick=\'show_window()\' name = \'diagprob_button\'><input type=\"hidden\"  name = \"Description\" value=\"\"><input class=\"button\" type=\"button\" value=\"!\" name = \"exclamation\" id=\"exclamation\" onclick = \"javascript:showLongDescription();\" style=\"visibility:hidden\" ><img  src=\'../../eCommon/images/mandatory.gif\'>\n\t\t<!--<input class=\"button\" type=\"button\" value=\"!\" name = \"exclamation\" onclick = \"javascript:showLongDescription();\" style=\'\' >-->\n\t\t<input type=\"hidden\"  name = \"LongDescription\" value=\"\">\n\t\t<input type=\"button\" id=\'AddAssociateCodes\' name=\"AddAssociateCodes\" value = \"+\" onclick = \"/*decider()*/addAssociateCodes1();\" title=\"Supporting Diagnosis\" class=\"button\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" >\t\n\t\t<input type=\"button\"  name=\"ntf_button\" id=\"ntf_button\"  value=\"+\"   onClick=\"callNotifiableNotes(\'DiagnosisNote\')\" title=\"Record Notifiable Form\" class=\'button\' id=\'RecordNotifiableBtn\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" style=\'visibility:hidden\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" >\n\t\t<!-- <img name=\'high_risk\' src=\'../../eCA/images/MI_HighRisk.gif\' style=\'visibility:hidden\'> --><!-- Added for this BRU-HIMS-CRF-19.1-->\n\t\t<img id=\'high_risk\' src=\'../../eCommon/images/PI_HighRisk.gif\' style=\'visibility:hidden\'><!-- Added for this BRU-HIMS-CRF-19.1-->\n\t\t<!--Below line added for this CRF GDOH-CRF-0082-->\n\t\t<span name=\"pmb_diagnosis\" id=\"pmb_diagnosis\" style=\"visibility:hidden;font-size:11px\"></span>\n\t\t<!--End  GDOH-CRF-0082-->\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<td class=\'label\' width=\'10%\'><b><font  size=\'1\' color=\'blue\'><a  id=\'manifest_anchor\' href=\'javascript:;\' onclick=\'manifestion()\'></a></font></b></td>\n\t\t<td class=\'label\' width=\'10%\' align = \'left\'><b><font  size=\'1\' color=\'blue\'><a href=\"javascript:;\" onclick=\"viewLink();\"  id=\'view_link\' ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="style=\"visibility:hidden\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="style=\"visibility:visible\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&nbsp;";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</a></font></b></td>\n\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\n\t\t<td class=\'label\' width=\'10%\' id=\'other_disp1\' name=\'other_disp1\' style =\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="s </td>\n\t\t<td class=\'fields\' width=\'15%\' id=\'other_disp2\' name=\'other_disp2\' style =\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t\t<select name=\'term_oth_desc\' id=\'term_oth_desc\' id=\'term_oth_desc\' style=\'width:100\' ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" >\n\t\t\n\n\n\t\t</select><img src= \'../../eCommon/images/mandatory.gif\'></img></td>\n\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\n\t</tr>\t\n\n\t<tr>\t\t\n\t\t<!--<td class=\'label\' width=\'13%\' id=\'enc_stage_tab_id\'  style=\'\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>-->\n\t\t<td class=\'label\' width=\'12%\' id=\'enc_stage_tab_id\'  style=\'\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t<td class=\'fields\' width=\'18%\' id=\'enc_stage_tab_id1\'  style=\'\'><select name=\'diag_stage\' id=\'diag_stage\'  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =">\n\n        <!--Below Added by Suji Keerthi for ML-MMOH-CRF-1605-->\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t<option value=\"A\" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</option>\t\n\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</option>\t\n\t\t\t\t\t\t<option value=\"D\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t<option value=\"A\" >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</option>\t\n\t\t\t\t\t\t<option value=\"I\" >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</option>\t\n\t\t\t\t\t\t<option value=\"D\" selected>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</option>\t\n\n\t\t\t    ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" -----</option>\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t</select><img src= \'../../eCommon/images/mandatory.gif\' id=\'enc_stage_tab_img\'></img></td>\n\n\t\t<td  class=\"label\" width=\'20%\' id=\'diag_classf_legend\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t</td>\n\n\t\t<td  class=\"fields\" width=\'20%\' >\n\t\t\t<select name=\"diag_classfication\"  id=\'diag_classfication\' ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" onChange=\"callDiagCateg(this);restirctPrimaryDiag(this);\">\n\t\t\t   <OPTION value=\"\">---------- ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="----------</option>\n\t\t\t\n\t\t\t  \n\t</select><img src= \'../../eCommon/images/mandatory.gif\'  style=\'visibility:hidden\' id=\'diag_class_img\'></img>\n\t<span id=\"id_diag_class_type\"></span>\n\t<!--Above line  Modified for this CRF AAKH-CRF-0012 [IN:037736] -->\n\t</td>\n\n\t\t<!--<td class=\'label\' colspan=\'2\' ></td> --> <!-- commented and below code added for ML-MMOH-CRF-1281 -->\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t<td class=\'label\' width=\'10%\'><b><font  size=\'1\' color=\'blue\'><a  id=\'manifest_anchor\' href=\'javascript:;\' onclick=\'manifestion()\'></a></font></b></td>\n\t\t<td class=\'label\' width=\'10%\' align = \'left\'><b><font  size=\'1\' color=\'blue\'><a href=\"javascript:;\" onclick=\"viewLink();\"  id=\'view_link\' ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</a></font></b></td>\n\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t<td class=\'label\' width=\"3%\">";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t<td class=\'fields\' align = \'left\' >\n\t\t\t<select name=\"poa_indicator\" id=\"poa_indicator\">\n\t\t\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" -----</option>\n\t\t\t\t<option value=\"Y\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="selected";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =">Y</option>\n\t\t\t\t<option value=\"N\" ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">N</option>\n\t\t\t\t<option value=\"U\" ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =">U</option>\n\t\t\t\t<option value=\"W\" ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =">W</option>\n\t\t\t\t<option value=\"1\" ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =">1</option>\n\t\t\t</select>\n\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t<td class=\'label\' colspan=\'2\' >\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\n\n\t</tr>\n\t\n\t<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->\n\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t<tr id=\"linkcheckbox\" style=\"display:";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t<td colspan=\'2\'>\n\t\t\t<td class=\'fields\' width=\'20%\' colspan=\'2\' nowrap>\n\t\t\t\t<input type=\'checkbox\' name=\'link_diag_pri_sec_yn\' id=\'link_diag_pri_sec_yn\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" onClick=\"linkDiagCodeToPriSecDiagClass(this);\">\n\t\t\t\t<b>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</b>\n\t\t\t</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t<!--End ML-MMOH-CRF-1742-->\n\n\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t<tr>\n\t\t<td class=\'label\' colspan=\'2\'>\n\t\t\t</td>\n\t\t\t<td  class=\"label\" width=\'20%\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t</td>\n\t\t\t<td  class=\"fields\" width=\'20%\'>\n\t\t\t<select name=\"diag_category\" id=\"diag_category\" id = \"diag_category1\"   >\n\t\t\t\t\t<OPTION value=\"\">---------- ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="----------</option>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\n\t\t\t\t\t\n</select><img src= \'../../eCommon/images/mandatory.gif\' style=\'visibility:";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' id=\'diag_catg_img\'></img>\t\n \n\t\t\t</td>\n\t\t\t<td class=\'label\' colspan=\'2\' >\n\t\t \n\t\t\t</td>\n\t\t</tr>\n \n\t\t\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t<tr>\n\t\t<td colspan=6>\n\t\t<table border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\" >\n\t\t<tr> \n\t\t<td class = \'label\' width=\'12%\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\n\t\t<td class=\'fields\' width=\'18%\'><textarea type=\'textarea\' name=\'complaint_desc\' value=\'\' readonly >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</textarea><input type=\'hidden\' name=\'complaint_id\' id=\'complaint_id\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'></input><input type=\'button\' name=\'ComplaintSrch\' id=\'ComplaintSrch\' value=\'?\'  OnClick=\'selectProblem();\' class=\'button\' ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="disabled";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" ></input>\n\t\t<!-- Added by jeyachitra for ML-MMOH-CRF 1742 -->\n\t\t<input type=\'hidden\' name=\'aud_complaint_desc\' id=\'aud_complaint_desc\' value = \'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'/>\n\t\t</td>\n\t\t<!--//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013-->\n\n\t\t<!--Added by Sangeetha on 20th Feb 2017 for ML-MMOH-CRF-0547-->\n\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\t\t\t\n\t\t\t<td  class=\"label\" width=\'20%\' >\n\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" \n\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="<!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->\n\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\t\n\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t   </td>\n\t\t   <input type=\"hidden\" name=\"legendChangeAsTypesOfNotiForm\" id=\"legendChangeAsTypesOfNotiForm\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"> \n\t\t   <input type=\"hidden\" name=\"notifiableLegndChgApplYn\" id=\"notifiableLegndChgApplYn\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"> \n\t\t<td  class=\"fields\" width=\'20%\' >\n\t\t\t<select name=\"notification_setup\" id=\"notification_setup\" onchange=\'EnableNotifySetup()\' ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" >\n\t\t\t <OPTION value=\"\">---------- ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="----------</option>\n\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t  \n\t\t</select>\n\t\t<input type=\"button\"  name=\"Addnotification\" id=\"Addnotification\"  value=\"+\"   onClick=\"GetSerialNumber();callNotifiableNotes(\'NotifiableNote\')\" title=\"Record Notifiable Form\" class=\'button\' id=\'AddnotificationBtn\'  ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" >\n\t\t&nbsp;&nbsp;<img src= \'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'notifi_frm_mand_gif\'></td>\n\t\t<!--Added for this CRF Bru-HIMS-CRF-024.2 -->\n\t\t<!--End-->\n\t\t<td  class=\"label\" width=\'20%\' ></td>\n\t\t</td></table>\n\t\t</tr>\n\n\t<tr>\n\t<td colspan=6>\n\t<table border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\" id=\'Diag_yn_tab\'>\n\t<tr> \n\t\t<td class=\"label\" width=\'12%\' id=\'nature_tab_id\' >";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n\t\t<td  id=\'nature_tab_id1\' width=\'18%\' class=\'fields\'><select name=\'nature\' id=\'nature\' ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =">><option value=\'\'>----- ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" -----</option>\n\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t</select><img   id=\'nature_img\' src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\n\t\t<td  class=\"label\" width=\'20%\' >";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</td>\n\t\t\n\t\t<td class=\'fields\' width=\'20%\'><select name=\"accuracy\" id=\"accuracy\" onChange=\'getAccuracy_code();show_diff_link(this);setStatus();\' ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="><option value=\'\' >----- ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =" -----</option>\n\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t</select><img  src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t<td class=\'label\'  width=\'20%\' style=\'\' ><b><font  size=\'1\' color=\'blue\'><a href=\"javascript:;\" onclick=\"diffGroup(document.forms[0].code_set.value)\"   id=\'differential_anchor\'>";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</a></font></b></td>\n\t\t\n\t</tr>\n\t<tr id=\'ser_pri_row\'>\t\n\t\t<td class=\'label\' id=\'severity_tab_id\' style=\'\'  width=\'12%\'>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td>\n\t\t<td  id=\'severity_tab_id1\' class=\'fields\' width=\'18%\'><select name=\"severity\" id=\"severity\" ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" >\n\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t <option value=\'D\' >";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</option>\n\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t<option value=\'D\' ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t<option value=\'L\' ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</option>\n            <option value=\'S\' ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</option>\n\t\t\t<option value=\'E\' ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</option>\n\t\t</select><img id=\'sevrity_img\' src=\'../../eCommon/images/mandatory.gif\'></td>  \n\t\t<td class=\'label\'   id=\'priority_tab_id\' style=\'\'  width=\'20%\'>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t\t<td id=\'priority_tab_id1\' width=\'20%\' class=\'fields\'><select name=\"priority\" id=\"priority\" ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="><option value=\'\'>----- ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" -----</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t</select><img id=\'priority_img\' src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t<td class=\'label\' style=\'\' width=\'20%\' ><b><font size=\'1\' color=\'blue\'><a href=\"javascript:;\" onclick=\"evidencedby1()\" id=\'evidence_anchor\'></a></b></font></td>\n\t</tr>\n\t</table> \n\t</td>\n   </tr>\n<tr>\n<td colspan=6>\n<table border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\" >\n\t<tr> \n\t\t<td class=\'label\' width=\'12%\' id=\"onset_type_tabid\" style=\'visibility:visible\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t\t<td width=\'18%\' id=\"onset_type_tabid1\" class=\'fields\'><select name=\"type\" id=\"type\" ";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 =" ><option value=\'N\' ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</option><option value=\'A\' ";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</option><option  value=\'C\' ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</option></select><!-- <img id=\'\' src=\'../../eCommon/images/mandatory.gif\' id=\'onset_type_img\'> -->\n\t\t<input type=\"hidden\"  name=\"old_onset_type\" id=\"old_onset_type\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t</td> \n\t\t<td width=\'20%\' class=\'label\' >";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</td><input type=\'hidden\' name=\'currentdateTime\' id=\'currentdateTime\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'></td>\n\t\t<td width=\'20%\' class=\'fields\'><input type=\'text\' name=\'onset_date\' id=\'onset_date\' ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' id=\'date1\' size=\'18\' maxlength=\'18\' Onblur=\'if(validDateObj(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\")){DateChk(currentdateTime,this);}\'><img src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =" onclick=\"document.forms[0].onset_date.focus();return showCalendar(\'date1\',null,\'hh:mm\');\"/><img src=\'../../eCommon/images/mandatory.gif\'><input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'></td>\n\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t<td class=\"label\" width=\'20%\'>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="<input type=\"text\" name=\"b_days\" id=\"b_days\" ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" maxlength=\"2\" size=\"2\" value=\'\'  tabIndex=\'4\'  onBlur=\'CheckForNumber_L(this,onset_date);checkDays(this,onset_date);gotoNext(this)\' onKeyPress=\'return(ChkNumberInput(this,event,0));\' >D<input type=\"text\" name=\"b_months\" id=\"b_months\" ";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 =" maxlength=\"2\" value=\'\' size=\"2\" onKeyPress=\'return(ChkNumberInput(this,event,0));\'  onBlur=\'CheckForNumber_L(this,onset_date);checkMonth(this,onset_date);gotoNext(this)\'   tabIndex=\'5\' >M<input type=\"text\" name=\"b_age\" id=\"b_age\" ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" maxlength=\"3\" size=\"3\" value=\'\'    onBlur=\'CheckForNumber_L(this,onset_date);gotoNext(this)\' onKeyPress=\'return(ChkNumberInput(this,event,0));\'  tabIndex=\'6\'>Y</td>\n\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t<td class=\"label\" width=\'20%\'>\n\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t</tr>\n</table> \n</td>\n</tr>\n<tr>\n<td colspan=6>\n<table border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\">\n\t<tr> <!--//Maheshwaran K Modified for the SKR-CRF-0020 as on 17/07/2013*/-->\n\t\t<td class=\"label\" width=\'12%\'>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</td>\n\t\t<td width=\'18%\' class=\'fields\'><select name=\"status\" id=\"status\" onchange=\"Image_Enable(this)\" ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" disabled ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =" >\n\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</option>\n            <option value=\'R\' ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</option>\n\t\t\t<option value=\'X\' ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</option>\n\t\t</select></td>\n\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</td>\n\t\t<td width=\'20%\' class=\'fields\'><input type=\'text\' name=\'status_date\' id=\'status_date\' id=\'date2\' ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' size=\'10\' maxlength=\'10\'  Onblur=\'if(validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\")) { validate_date1(document.forms[0].onset_date,status_date,currentdate);}\' ><img src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" onclick=\"document.forms[0].status_date.focus();return showCalendar(\'date2\');\"/><img   src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t<td class=\'label\' width=\'20%\'>\n\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t<input type=\'checkbox\' checked \n\t\t\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =" \n\t\t\t\t\tname=\'inc_encounter\' id=\'inc_encounter\' onClick=\"check_enc();\">\n\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t</td>\n\t</tr>\n\n\n</table> \n</td>\n</tr>\n\n</table>\n</tr>\n<!--modified on 08-may 2008 to add Anatomical site & Applicable Side-->\n<td colspan=8>\n<table border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\" id=\'AnatomicalSiteTable\'>\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t<td class=\'label\' width=\'16%\' >";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\n\t\t<td width=\'18%\' class=\'fields\'><select name=\"anatomical_site\" id=\"anatomical_site\" onchange=\'show_diag_link(this);\' \n\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =" >\n\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 =">----- ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =" -----</option>\n\t\t\t<option value=\'C\' ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</option>\n            <option  value=\'O\' ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</option>\n            </select>\n\t\t</td>\n\t\t<td width=\'18%\' class=\'fields\' id = \'oral_sites\' ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 =" style=\"visibility:hidden\" ";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 =">\n\t\t\t<select id=\"anatomical_oral_sites\" name = \'anatomical_oral_sites\' ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 =">\n";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\t\t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="--------</option>\n";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="--------</option>\n\n\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t</select>\n\t\t</td>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t<td class=\'label\' width=\'12%\' ></td>\n\t\t<td width=\'18%\' class=\'fields\'></td>\n\t\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t<td class=\'label\'  width=\'\' style=\'\' ><b><font  size=\'1\' color=\'blue\'><a href=\"javascript:;\" onclick=\"linkdiagnosis();\"   id=\'link_diagnosis\'>";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="</a></font></b></td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t<td class=\'label\'></td>\n\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t<td class=\'label\' width=\'20%\' ";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="style=\'visibility:hidden\' ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="style=\'visibility:hidden\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="style=\'visibility:visible\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 =" id=\'app_label\'>";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</td>\n\t\t<td width=\'20%\' class=\'fields\' ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="style=\'\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="  id=\'app_select\'><select name=\"applicable_side\" id=\"applicable_side\"  ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 =" -----</option>\n\t\t\t<option value=\'L\' ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</option>\n            <option  value=\'R\' ";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</option>\n\t\t\t<option value=\'B\' ";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="</option>\n\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</option>\n            </select>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t</tr>\n\t\n\t<!---->\n\t<!---->\n\n<!--Modified by Himanshu Saxena for ML-MMOH-CRF-1986.1 (UserStory 2) on 25-04-2023 Started--><!-- added onkeypress=\"return CheckForSpecChars_onlyfive(event);\"-->\n\t\t<tr>\t\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="</td> <!-- modified by mujafar for ML-MMOH-CRF-1270 -->\n\t\t<td colspan=\'4\' class=\'fields\'><textarea name=\"remarks\" ";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 =" rows=\"2\" cols=\"80\" maxlength=\'2000\'   onBlur=\"makeValidString(this);checkMaxLimitOfRemark(this);\" onkeypress=\"return CheckForSpecChars_onlyfive(event);\" onpaste=\"return checkspecialandalphanumeric(event);\">";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</textarea><img  id=\'remk_image\' src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' ></img></td>\n\t\t<td class=\'label\' ></td>\n\t</tr>\n\t</td></table>\n\t<!---->\n</table>\n\n";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t<input type=\"hidden\"  name=\"analysis_code\" id=\"analysis_code\"      value=\"\">\n\t\t<input type=\"hidden\"  name=\"cause_indicator\" id=\"cause_indicator\"    value=\"\">\n\t\t<input type=\"hidden\"  name=\"diag_code\" id=\"diag_code\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n\t\t<input type=\"hidden\"  name=\"primary_yn\" id=\"primary_yn\"         value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" >\n\t\t<input type=\"hidden\"  name=\"retVal_auth\" id=\"retVal_auth\"\t\tvalue=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t\t<input type=\"hidden\"  name=\"sensitive_yn\" id=\"sensitive_yn\"       value=\"\">\n\t\t<input type=\"hidden\"  name=\"significant_yn\" id=\"significant_yn\"     value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\" >\n\t\t<input type=\"hidden\"  name=\"srl_no_from_table\" id=\"srl_no_from_table\"  value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" >\n\t\t<input type=\"hidden\"  name=\"tab_list_no\" id=\"tab_list_no\"        value=\"\">\n\t\t<input type=\"hidden\"  name=\"term_id\" id=\"term_id\"            value=\"\">\n";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\n\t\t<input type=\"hidden\"  name=\"sensitive_yn\" id=\"sensitive_yn\"       value=\"N\">\n\t\t<input type=\"hidden\"  name=\"significant_yn\" id=\"significant_yn\"     value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n    \n\n<!--//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013-->\n<input type=\"hidden\" name = \"curr_encounter_id\" value =\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n<input type=\"hidden\" name = \"Encounter_Id\" value =\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\">\n<input type=\"hidden\" name = \"Locn_Code\" value =\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n<input type=\"hidden\" name = \"Locn_Type\" value =\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n<input type=\"hidden\" name = \"Patient_Id\" value =\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\">\n<input type=\"hidden\" name = \"Practitioner_Id\" value =\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\">\n<input type=\"hidden\" name = \"accry_code\" value =\"\">\n<input type=\"hidden\" name = \"accry_code_ind\" value =\"\">\n<input type=\"hidden\" name = \"as_evidenced_by_hid\" value =\"\">\n<input type=\"hidden\" name = \"currentdate\" value =\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n<input type=\"hidden\" name = \"dateTime\" value =\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n<input type=\"hidden\" name = \"relationship_id\" value =\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n<input type=\'hidden\' name = \'episode_type\' value=\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'>\n<input type=\'hidden\' name = \'visit_adm_date\' value=\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\'>\n<input type=\'hidden\' name = \'ext_mand_for_consq\' value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'>\n<input type=\'hidden\' name = \'astk_mand_for_dagg\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\'>\n<!--Below line Added for this CRF AAKH-CRF-0012 [IN:037736] -->\n<input type=\'hidden\' name = \'diag_class_mand_yn\' value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'>\n\n<input type=\'hidden\' name = \'isMultiDescAppl\' id = \'isMultiDescAppl\' value=\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'>   <!-- added by mujafar for ML-MMOH-CRF-1281 -->\n<input type=\'hidden\' name = \'term_sht_desc\' id = \'term_sht_desc\' value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\"> \n\n\n<!-- Params for Code Set up...Get papulate from Script file. -->\n<input type=\"hidden\" name = \"term_set_id\" value =\"\">\n<input type=\"hidden\" name = \"priority_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"nature_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"severity_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"onset_type_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"factors_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"notification_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"notifiable_yn\" value =\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n<input type=\"hidden\" name = \"enc_stage_appl_yn\" value =\"\">\n<!-- Added by KAMATCHI S for ML-MMOH-CRF-1581 START-->\n<input type=\'hidden\' name= \"inpatient_appl_yn\" value=\"\">\n<input type=\'hidden\' name= \"daycare_appl_yn\" value=\"\">\n<!-- Added by KAMATCHI S for ML-MMOH-CRF-1581 END -->\n<!-- hidden fields for search -->\n<input type=\"hidden\" name =\"speciality_code\" id =\"speciality_code\" value =\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n<input type=\"hidden\" name =\"practitioner_type\" id =\"practitioner_type\" value =\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n<input type=\"hidden\" name =\"dob\" id =\"dob\" value =\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n<input type=\"hidden\" name =\"age\" id =\"age\" value =\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n<input type=\"hidden\" name =\"sex\" id =\"sex\" value =\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n<input type=\"hidden\" name =\"facilityId\" id=\"facilityId\" value =\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n<input type=\"hidden\" name =\"mode\" id=\"mode\" value =\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n<input type=\'hidden\' name=\'scheme_desc\' id=\'scheme_desc\' value=\'";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\'>\n<input type=\"hidden\" name=\"scheme\" id=\"scheme\" value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n<input type=\"hidden\" name =\"modal_yn\" id=\"modal_yn\"  value =\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n<input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n<input type=\'hidden\' name=\'onset_date_temp\' id=\'onset_date_temp\' value=\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'>\t\n<input type=\'hidden\' name=\'status_date_temp\' id=\'status_date_temp\' value=\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'>\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'>\n\n\n<input type=\'hidden\' name=\'isEncounterStage\' id=\'isEncounterStage\' value=\'";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\'><!-- Added by KAMATCHI S for ML-MMOH-CRF-1581 END -->\n\n<input type=\'hidden\' name=\'status_srl_no\' id=\'status_srl_no\' value=\'";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\'>\n<input type=\'hidden\' name=\'onset_date1\' id=\'onset_date1\' value=\'";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\'>\n<input type=\'hidden\' name=\'current_date\' id=\'current_date\' value=\'";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\'>\n<input type=\'hidden\' name=\'current_time\' id=\'current_time\' value=\'";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\'>\n<input type=\'hidden\' name=\'called_from_ip\' id=\'called_from_ip\' value=\'";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\'>\n<input type=\"hidden\"  name=\"f_authorize_yn\" id=\"f_authorize_yn\"  value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n\n<!--  hidden fields requeried to populate external diag -->\n<!--Below line modified for this CRF GDOH-CRF-0082-->\n<input type=\'hidden\' name=\'associate_codes\' id=\'associate_codes\' value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\">\n<input type=\'hidden\' name=\'associate_codes_modify\' id=\'associate_codes_modify\' value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n<input type=\'hidden\' name=\'code_indicator\' id=\'code_indicator\' ";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="value=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 =" value=\'\' ";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 =">\n<input type=\'hidden\' name=\'diff_group_id_hid\' id=\'diff_group_id_hid\' value=\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\'>\n<input type=\'hidden\' name=\'occur_srl_no_hid\' id=\'occur_srl_no_hid\' value=\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\'>\n";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t<input type=\'hidden\' name=\'expandcollapse\' id=\'expandcollapse\' value=\'C\'></input>\n";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\n<input type=\'hidden\' name=\'high_risk_code\' id=\'high_risk_code\' value=\'";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\'></input>\n<input type=\'hidden\' name=\'curr_encr_flag\' id=\'curr_encr_flag\' value=\'\'></input>\n<input type=\'hidden\' name=\'diff_group_vals\' id=\'diff_group_vals\' value=\'\'></input>\n<input type=\'hidden\' name=\'expandFlag\' id=\'expandFlag\' value=\'N\'></input>\n<input type=\'hidden\' name=\'isCalledFromCA\' id=\'isCalledFromCA\' value=\'";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\'></input>\n<input type=\'hidden\' name=\'old_encounter_id\' id=\'old_encounter_id\' value=\'";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\'></input>\n<input type=\'hidden\' name=\'onset_encounter_id\' id=\'onset_encounter_id\' value=\'";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\'></input>\n<input type=\'hidden\' name=\'accession_number\' id=\'accession_number\' value=\'";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\'></input>\n<input type=\'hidden\' name=\'option_id\' id=\'option_id\' value=\'";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\'></input>\n<input type=\'hidden\' name=\'oh_chart_num\' id=\'oh_chart_num\' value=\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\'></input>\n<input type=\'hidden\' name=\'diagcode\' id=\'diagcode\' value=\'";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\'></input>\n<input type=\'hidden\' name=\'diag_class\' id=\'diag_class\' value=\'";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\'></input>\n<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\'>\n<input type=\'hidden\' name=\'totalRecords\' id=\'totalRecords\' value=\'";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\'>\n<input type=\'hidden\' name=\'diag_class_code\' id=\'diag_class_code\' value=\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\'>\n<!-- Added On 2/22/2010 for SRR-CRF-303.2[IN015597] -->\n<input type=\'hidden\' name=\'dagger_independent_yn\' id=\'dagger_independent_yn\' value=\'";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\'>\n<input type=\'hidden\' name=\'recode_curr_level\' id=\'recode_curr_level\' value=\'";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\'>\n<input type=\'hidden\' name=\'diag_class_type\' id=\'diag_class_type\' value=\'\'>\n<!-- Added On 12/6/2010 for SRR20056-SCF-5914 [IN:024929] -->\n<input type=\'hidden\' name=\'isCurrentEncounter\' id=\'isCurrentEncounter\' value=\'";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\'>\n<input type=\'hidden\' name=\'diag_enc_level\' id=\'diag_enc_level\' value=\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\'>\n<input type=\'hidden\' name=\'p_called_from_widget\' id=\'p_called_from_widget\' value=\'";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\'> <!-- CHL-CRF- 0008 - IN:001472 -->\n\n<!--Added below hidden field for this CRF  [PMG2012-CRF-0030]-->\n<input type=\'hidden\' name=\'called_from_ot\' id=\'called_from_ot\' value=\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\'> \n\n<!-- Hidden field for the reporting charting(OHT) -->\n\n<input type=\'hidden\' name=\'_restoreChart\' id=\'_restoreChart\' value=\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\'></input>\n<input type=\'hidden\' name=\'is_oh_install\' id=\'is_oh_install\' value=\'";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\'></input>\n<input type=\'hidden\' name=\'email_yn\' id=\'email_yn\' value=\'";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\'></input>\n<input type=\'hidden\' name=\'diagnosis_by_long_desc_yn\' id=\'diagnosis_by_long_desc_yn\' value=\'";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\'></input><!--//Maheshwaran K added for HSA-CRF-0234-->\n<input type=\'hidden\' name=\'notifiable_code\' id=\'notifiable_code\' value=\'";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\'></input><!--Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013-->\n\n<input type=\'hidden\' name=\'deft_note_type\' id=\'deft_note_type\' value=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\"/><!--Added Senthil-->\n<!--Added for this CRF Bru-HIMS-CRF-024.2-->\n<input type=\'hidden\' name=\'notifiable_form_mand_yn\' id=\'notifiable_form_mand_yn\' value=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\"/> \n<input type=\'hidden\' name=\'notifiable_note_form\' id=\'notifiable_note_form\' value=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\"/> \n<input type=\'hidden\' name=\'accession_num_notifiable\' id=\'accession_num_notifiable\' value=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\"/> \n<input type=\'hidden\' name=\'srl_no_control\' id=\'srl_no_control\' value=\"\"/> \n<!--Added for this CRF GDOH-CRF-0082-->\n<input type=\"hidden\" name=\"diagnosisPmb\" id=\"diagnosisPmb\" value=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\"/> \n<input type=\"hidden\" name=\"pmbsupportdiag\" id=\"pmbsupportdiag\" value=\"";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\"/>\n<input type=\"hidden\" name=\"totsupportdiagCount\" id=\"totsupportdiagCount\" value=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\"/>  \n<!-- End Added for this CRF GDOH-CRF-0082-->\n\n<!--Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645-->\n<input type=\'hidden\' name=\'termCodeEffStatus\' id=\'termCodeEffStatus\' value=\'";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\'></input>\n\n<!--Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818-->\n<input type=\'hidden\' name=\'slink_flag\' id=\'slink_flag\' value=\'\'></input>\n\n<!-- Below Added by Suji Keerthi for ML-MMOH-CRF-1395 US002-->\n<input type=\'hidden\' name= \"diagnosis_class_mand_yn\" value=\"\"></input>\n<input type=\'hidden\' name=\'isDiagClassMand\' id=\'isDiagClassMand\' value=\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\'></input>\n<!-- Ended by Suji Keerthi for ML-MMOH-CRF-1395 US002-->\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\'></input>\n<input type=\'hidden\' name=\'restrict_sec_diag_yn\' id=\'restrict_sec_diag_yn\' value=\'";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\'></input>\n\n<input type=\'hidden\' name=\'isPrepDisDefaultDischargeAppl\' id=\'isPrepDisDefaultDischargeAppl\' value=\'";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\'></input>\n\n<!--//Added by MaheshwaranK on 20 Jan 2022 for TH-KW-CRF-165.1-->\n<input type=\'hidden\' name=\'isDiagCatgMand\' id=\'isDiagCatgMand\' value=\'";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\'></input>\n<input type=\'hidden\' name=\'isPatClsForDiagCat\' id=\'isPatClsForDiagCat\' value=\'";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\'></input>\n<!-- Added by Ajay Hatwate for ML-MMOH-CRF-1741 -->\n<input type=\'hidden\' name=\'mode_modify_curr_enc\' id=\'mode_modify_curr_enc\' value=\'";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\'></input>\n<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->\n<input type=\'hidden\' name=\'isDeceasedDiagClassDeathRegAppl\' id=\'isDeceasedDiagClassDeathRegAppl\' value=\'";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\'></input>\n<input type=\'hidden\' name=\'primary_diag_class\' id=\'primary_diag_class\' value=\'";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\'></input>\n<input type=\'hidden\' name=\'secondary_diag_class\' id=\'secondary_diag_class\' value=\'";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\'></input>\n<input type=\'hidden\' name=\'linked_yn\' id=\'linked_yn\' value=\'";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\'></input>\n \n<script>\nif((\'";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\' == \'C\' || \'";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\' == \'D\' ))\n\tdocument.forms[0].AddAssociateCodes.disabled=false;\n\nif((\'";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\' == \'modify\' &&  \'";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\' == \'Y\' ))\n\t\t{\n\t\t\tif (parent.RecDiagnosisOpernToolbar.document.forms[0].authorize){\n\t\t\tparent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value=getLabel(\'Common.Normal.label\',\'Common\')+\'\'+getLabel(\'Common.mode.label\',\'Common\');\n\t\t\tparent.RecDiagnosisOpernToolbar.document.forms[0].mode.value=\'Normal Mode\';\n\t\t\t}\n\t\t}\n\t\telse if(\'";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\' == \'modify\')\n\t\t{\n\t\t\tif (parent.RecDiagnosisOpernToolbar.document.forms[0].authorize){\n\t\t\tparent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value= getLabel(\'Common.Authorize.label\',\'Common\')+\'\'+getLabel(\'Common.mode.label\',\'Common\');\n\t\t\tparent.RecDiagnosisOpernToolbar.document.forms[0].mode.value=\'Authorize Mode\';\n\t\t\t}\n\t\t}\n\n\nif(\'";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\' == \'modify\' && \'";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\' != \"\" ){ \n\tdocument.getElementById(\'high_risk\').style.visibility = \'visible\';\n\tdocument.getElementById(\'high_risk\').title = \'";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\' \n}\n/*Below line added for this CRF GDOH-CRF-0082*/\nif(\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\"==\"true\" && \'";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\' == \'modify\'){\n    //PMBValidation();\n\t\n\tif(\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\'!=\"\" ){ \n\t\t\tvar pmb=getLabel(\"eMR.ThisisPMB.label\",\"MR\");\t\t\t\t\t\t\n\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'visible\';\t\t\n\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=pmb;\n\t}if(\'";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\' == \"\" ){\n\t\tvar notpmb=getLabel(\"eMR.ThisisnotPMB.label\",\"MR\");\t\t\t\t\t\t\n\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'visible\';\t\t\t\t\t\t\n\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=notpmb;\n\t}if(document.forms[0].totsupportdiagCount&&document.forms[0].totsupportdiagCount.value!=\"\"&&document.forms[0].totsupportdiagCount.value!=0){\n    \tsetTimeout(\'PMBValidation()\',1000);\n\t}\n}\n//End GDOH-CRF-0082\n\n</script>\n";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\n\n\n<!-- <script>setTimeout(\"getCodeSet()\",300);</script> -->\n\n\n<script>\ngetAccuracy_code();\ngetCodeSet(\'y\');\n</script>\n";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\n\t<script>setStatus();</script>\n";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\n\t<script>check_enc();</script>\n";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 =" \n\n";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\n\t<script>//setTimeout(\"diagClassLoad()\",30);</script>\n";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\n\t<script>///*Monday, February 01, 2010 IN018664 , called in getCodeSet() of RecDiagnosis.js*/ setTimeout(\"diagClassModify()\",30);</script>\n";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\n\t<script>//expandColapseframe(\'E\');\n\tonload_display();\n\t</script>\n";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\n\t<script>setTimeout(\"getDescription()\",300);</script>\n";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n</font>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
	

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale			= (String)session.getAttribute("LOCALE");


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	Connection con				= null;
	//Statement stmt				= null;
	PreparedStatement stmt		= null;
	ResultSet rset				= null;
	ResultSet rs2				= null;
	PreparedStatement stmt2		= null;
	PreparedStatement pstmt		= null;

	ResultSet rsset				= null;
	PreparedStatement prepstmt	= null;

	String check_box_value		= "";
	String significant_yn		= "";
	String srl_no_from_table	= "";
	String diag_code			= "";
	String retVal_auth			= "";

	String Practitioner_Id		= "";	
	String _Practitioner_Id		= "";	
	String scheme				= "";
    String scheme_desc			= "";
	String relationship_id		= "";
	String Locn_Code			="";	
	String Locn_Type			= "";
	String Patient_Id			= "";	
	String Encounter_Id			= "";
	String currentdate			= "";	
	String facilityId           = "";
	String currentdateTime		= "";
	String currentTime			= "";
	String dob					= ""; 
	String age					= "";
	String sex					= ""; 
	String associate_codes		= "";
	String notifiable_yn;
	String term_code			= "";	
	String term_set_id			= "";
	String nature				= "";  	
	String onset_date			= "";
	String onset_encounter_id="";//Mahesh added 06/04/2014
	String status				= "";  	
	String srl_no				= "";     
	String diastgSel_1			= "";
	String diastgSel_2			= "";
	String diastgSel_3			= "";	
	String	severity			= "";	
	String	onset_type			= "";
	String	priority			= "";	
	String	accuracy_code		= "";
	String	remarks				= "";	
	String patient_class		= "";	
	String disimage				= "visibility:hidden";
	String def_status			= ""; 
	String date_status			= "";
	String def_disable			= "";  
	String occur_srl_no			= "";
	String style_def			= "";		
	String mode					= "";
	String stage_code			= "";		
	String episode_type			= "";		
	String visit_adm_date		= "";		
	String modal_yn				= "N";	
	String called_from_ip		= "";	
    String dis_add_associate	= "disabled";
	String diagstagecode		= "";
	String onset_date_converted	= "";
	String status_date_converted= "";
	String cause_of_death_yn	= "N";
	String ext_mand_for_consq	= "";
	String astk_mand_for_dagg	= "";
	String isCalledFromCA		= "N";
	//
	String anatomical_site      = "" ;
	String applicable_side      = "" ;
	String anatomy_select_c     = "";
	String anatomy_select_o     = "";
	String applicable_l			= "";
	String applicable_r			= "";
	String applicable_b			= "";
	String applicable_n			= "";
	String is_oh_install        = "N";
	String diag_class_mand_yn        = "N";
	String restrict_sec_diag_yn        = "N";
	String diagMandVisible        = "";
	String anatomy_select_default = "";
	String diag_class			= "";
	String diag_catg			= "";
	String diag_catg_code			= "";
	String term_set_desc		= "";
	String spl_code				= "";
	int view_cnt				= 0;
	String free_text_applicable_yn = ""; 
	String term_code_short_desc = ""; 
	String restorative_Chart	= checkForNull((String)session.getAttribute("restorative_Chart"));
	
	String called_from_ot = checkForNull(request.getParameter("called_from_ot")); //this line Added for this CRF [PMG2012-CRF-0030]
	//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
	//Start
	String notifiable_code=checkForNull(request.getParameter("notifiable_code"));
	String notifiable_code_style="";
	
	//End
	String facility_id			= checkForNull((String)session.getValue("facility_id"));

	String practitioner_type	= checkForNull(request.getParameter("practitioner_type"));
	String cause_of_death		= checkForNull(request.getParameter("cause_of_death"));
	String speciality_code		= checkForNull(request.getParameter("speciality_code"));
	String isCurrentEncounter	= checkForNull(request.getParameter("isCurrentEncounter"));
	String old_encounter_id		= checkForNull(request.getParameter("old_encounter_id"));
	String accession_number		= checkForNull(request.getParameter("accession_num"));
	String oh_chart_num			= checkForNull(request.getParameter("oh_chart_num"));	
	String option_id			= checkForNull(request.getParameter("option_id"));
    String _status				= checkForNull(request.getParameter("status"));
	String diagcode				= checkForNull(request.getParameter("diagcode")) ;
	String call_from				= checkForNull(request.getParameter("call_from")) ;//Calling From MDR added on 9/15/2009
	String totalRecords		= checkForNull(request.getParameter("totalRecords")) ;//Calling From MDR added on 9/15/2009
	String function_id		= checkForNull(request.getParameter("function_id")) ;//Added by Suji Keerthi for ML-MMOH-CRF-1605
	String dagger_independent_yn		= "" ;//Added For SRR-CRF-303.1 1/27/2010
	if(practitioner_type.equals(""))	
		practitioner_type		= checkForNull((String)session.getValue("practitioner_type"));

	StringBuffer sql			= new StringBuffer(); 
	String complaint_Desc		= ""; 
	String _complaint_Desc		= ""; 
	String complaint_id			= ""; 
	String _complaint_id		= "";
	boolean	firstTime			= true;
		
	String anatomical_site_code = "";
	String anatomical_short_desc= "";
	String oral_sites_style		= "visibility:hidden";
	String high_risk_code = "";				
	String highRiskDesc = "";				
	ArrayList prio_list=new ArrayList();
	ArrayList enc_stg_list=new ArrayList();
	ArrayList nat_list=new ArrayList();
	String diagnosis_by_long_desc_yn="N";
	String diag_enc_level="N";//Maheshwaran K Modified for the SKR-CRF-0020 as on 17/07/2013
	String curr_encounter_id="";//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
	String email_yn="";
	String email_sel_yn="";
	String default_note_type="",deflt_note_type="";//Added Senthil
	//Added for this Bru-HIMS-CRF-024.2
    String notifiable_form_mand_yn="N"; String notifiable_frm_mand_gif="";
    HashMap ResultParamHashMap = new HashMap();	
	//Added for this CRF Bru-HIMS-CRF-024.2
	String accession_num_work_related="",accession_num_notifiable="",dis_work_related_notifiable="";
	
	//Below line added for this CRF GDOH-CRF-0082
	 String pmb_code="";	 
	 boolean diagnosisPmb=false;
	 String support_diag_code="";
	 int supportdiagCount=0;
	//End GDOH-CRF-0082

	//Added by Ashwini on 29-Jun-2018 for ML-MMOH-CRF-1187
	Boolean isEnlargeDiagFldAppl = false;
	Boolean isMultiDescAppl = false; // added by mujafar for ML-MMOH-CRF-1281
	String includevisibility="visibility:hidden"; // added by mujafar for ML-MMOH-CRF-1281 END

	Boolean termCodeEffStatus = false; //Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645
	boolean isCoderDiagAppl	= false; //Added By Dharma on 3rd June 2020 against AAKH-CRF-0122.1
	Boolean isEncounterStage= false; //Added by KAMATCHI S for ML-MMOH-CRF-1581
	Boolean isDiagClassMand= false;  //Added by Suji Keerthi for ML-MMOH-CRF-1395 US002
	Boolean isPrepDisDefaultDischargeAppl= false;  //Added by Suji Keerthi for ML-MMOH-CRF-1605
	//Added by Ajay for TH-KW-CRF 165.1
	//Started
	Boolean isDiagCatgMand = false; 
	Boolean isPatClsForDiagCat = false;
	
	String diagCatgForEM = "";
	String diagCatgForDC = "";
	String diagCatgForIP = "";
	String diagCatgForOP = "";
	
	String diagCatgDisabled = "disabled";
	String DiagCatgImgHdn = "hidden";
	//End of CRF TH-KW-CRF 165.1
	
	/* Added by Ajay Hatwate for ML-MMOH-CRF-1741 */
	String mode_modify_curr_enc="";

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String primary_diag_class = "";
	String secondary_diag_class = "";
	String linkcheckboxdisp = "none";
	String link_diag_pri_sec_yn = "N";
	String checklinkprisec = "";
	String linked_yn = "";
	
	try
	{
		con = ConnectionManager.getConnection(request);
		//stmt = con.createStatement();
		isEncounterStage	=  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","TERM_RECODE_DIAG");//Added by KAMATCHI S for ML-MMOH-CRF-1581
		isDiagClassMand =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DIAG_CLASS_MAND"); //Added by Suji Keerthi for ML-MMOH-CRF-1395 US002
		isPrepDisDefaultDischargeAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"IP","PREPDIS_ADV_ENCSTAGE_DEFAULT"); //Added by Suji Keerthi for ML-MMOH-CRF-1605
		
		isDiagCatgMand  = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MR_DIAG_CATEGORY_MAND");
		patient_class				= checkForNull(request.getParameter("patient_class"));
		isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		/*Below line Added for this CRF Bru-HIMS-CRF-024.2*/
		HashMap sqlColumns = new HashMap();
		sqlColumns.put("notifiable_form_mand_yn","S");		
		
		//Added by Ajay for TH-KW-CRF 165.1
		sqlColumns.put("DIAG_CATG_PR_FOR_DC_YN","S");	
		sqlColumns.put("DIAG_CATG_PR_FOR_EM_YN","S");	
		sqlColumns.put("DIAG_CATG_PR_FOR_IP_YN","S");	
		sqlColumns.put("DIAG_CATG_PR_FOR_OP_YN","S");	
		ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,"","mr_parameter",con);
		notifiable_form_mand_yn = (String) ResultParamHashMap.get("notifiable_form_mand_yn");		
		//End  Bru-HIMS-CRF-024.2		

		diagCatgForDC = (String)ResultParamHashMap.get("DIAG_CATG_PR_FOR_DC_YN");
		diagCatgForIP = (String)ResultParamHashMap.get("DIAG_CATG_PR_FOR_IP_YN");
		diagCatgForEM = (String)ResultParamHashMap.get("DIAG_CATG_PR_FOR_EM_YN");
		diagCatgForOP = (String)ResultParamHashMap.get("DIAG_CATG_PR_FOR_OP_YN");

		
		if(patient_class.equals("IP") && diagCatgForIP.equals("Y")){
			isPatClsForDiagCat = true;
		}else if(patient_class.equals("OP") && diagCatgForOP.equals("Y")){
			isPatClsForDiagCat = true;
		}else if(patient_class.equals("EM") && diagCatgForEM.equals("Y")){
			isPatClsForDiagCat = true;
		}else if(patient_class.equals("DC") && diagCatgForDC.equals("Y")){
			isPatClsForDiagCat = true;
		}

		
		//End of TH-KW-CRF 165.1
		
       /*Below line added for this CRF GDOH-CRF-0082*/		
		diagnosisPmb=CommonBean.isSiteSpecific(con, "MR","DIAG_MAPPED_PMB"); 	
		//End GDOH-CRF-0082	   
		
		//Added by Ashwini on 29-Jun-2018 for ML-MMOH-CRF-1187
		isEnlargeDiagFldAppl = CommonBean.isSiteSpecific(con, "MR","ENLARGE_DIAGNOSIS_FIELD"); 

		termCodeEffStatus =  CommonBean.isSiteSpecific(con,"MR","CHK_TERM_CODE_EFF_STATUS"); //Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645
		isCoderDiagAppl =  CommonBean.isSiteSpecific(con,"MR","MR_CODER_DIAGNOSIS"); //Added By Dharma on 3rd June 2020 against AAKH-CRF-0122.1 
		
		isMultiDescAppl =  CommonBean.isSiteSpecific(con,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281
		called_from_ip			= checkForNull(request.getParameter("called_from_ip"));
		visit_adm_date			= checkForNull(request.getParameter("visit_adm_date"));
		occur_srl_no			= checkForNull(request.getParameter("occur_srl_no"));
		episode_type			= checkForNull(request.getParameter("episode_type"));
		srl_no					= checkForNull(request.getParameter("srl_no"));
		Practitioner_Id			= checkForNull(request.getParameter("Practitioner_Id"));	
		relationship_id			= checkForNull(request.getParameter("relationship_id"));
		Locn_Code				= checkForNull(request.getParameter("Locn_Code"));			
		Locn_Type				= checkForNull(request.getParameter("Locn_Type"));
		Patient_Id				= checkForNull(request.getParameter("Patient_Id"));
       
		Encounter_Id			= checkForNull(request.getParameter("Encounter_Id"));
		associate_codes		= checkForNull(request.getParameter("associate_codes"));
		age						= checkForNull(request.getParameter("Age"));	
		dob						= checkForNull(request.getParameter("Dob"));	
		sex						= checkForNull(request.getParameter("Sex"));
		mode					= checkForNull(request.getParameter("mode"));
		if(mode.equals("modify_curr_enc")){
			mode = "modify";
			mode_modify_curr_enc = "modify_curr_enc";
		}
		modal_yn				= checkForNull(request.getParameter("modal_yn"));
		notifiable_yn			= checkForNull(request.getParameter("notifiable_yn"));
		term_set_id				= checkForNull(request.getParameter("term_set_id"));
		term_set_desc			= checkForNull(request.getParameter("term_set_desc"));
		isCalledFromCA			= checkForNull(request.getParameter("isCalledFromCA"));
		String isCleared		= checkForNull(request.getParameter("isCleared"));
		diag_class              = checkForNull(request.getParameter("diag_classification"));
		diag_catg_code              = checkForNull(request.getParameter("diagnosis_category"));
		term_code_short_desc    = checkForNull(request.getParameter("term_code_short_desc"));
		String p_called_from_widget = checkForNull(request.getParameter("p_called_from_widget")); //CHL-CRF- 0008 - IN:001472
		/*Below line added for this CRF Bru-HIMS-CRF-024.2*/
	/*	if(notifiable_form_mand_yn.equals("Y")&&"".equals(mode)){
		notifiable_frm_mand_gif = "visibility:visible";
		}else{
		notifiable_frm_mand_gif = "visibility:hidden";
		}		
		out.println("<script>alert('"+notifiable_frm_mand_gif+"');</script>");*/
		//End Bru-HIMS-CRF-024.2
		if(mode.equals("modify") && !diag_catg_code.equals("")){
			diagCatgDisabled = "";
			DiagCatgImgHdn = "";
		}

		/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
		String sqllinkyn = " SELECT CASE WHEN MAX (CASE WHEN link_diag_pri_sec_yn = 'Y' THEN 1 ELSE 0 END) = 1 THEN 'Y' ELSE '' END AS linked_yn FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND status != 'E' ";
		
		prepstmt = con.prepareStatement(sqllinkyn);
		prepstmt.setString(1,Patient_Id);
		prepstmt.setString(2,Encounter_Id);
		prepstmt.setString(3,facility_id);

		rsset = prepstmt.executeQuery();

		if(rsset!=null && rsset.next()){
			linked_yn = (rsset.getString("linked_yn")==null || rsset.getString("linked_yn")=="")?"" : rsset.getString("linked_yn");
		}

		if (prepstmt!=null) prepstmt.close();
		if (rsset!=null) rsset.close();
		/*End ML-MMOH-CRF-1742*/
		
		//String getDate = "select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual" ;
		//Maheshwaran K added diag_enc_level for the SKR-CRF-0020 as on 17/07/2013
		//Maheshwaran K added diagnosis_by_long_desc_yn for HSA-CRF-0234
		String sqlScheme=" select diagnosis_by_long_desc_yn,diag_code_scheme scheme,restrict_sec_diag_yn,diag_class_mand_yn,diag_enc_level, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date,(select PRACTITIONER_NAME from am_practitioner where practitioner_id=?) Recorded_by_pract_name, EXT_MAND_FOR_CONSQ,ASTK_MAND_FOR_DAGG,(select to_char(sysdate,'dd/mm/rrrr hh24:mi')  from dual)sdate,(select install_yn from sm_module where  module_id  ='OH') OH_install, primary_diag_class, secondary_diag_class from MR_PARAMETER ";

		stmt=con.prepareStatement(sqlScheme);
		stmt.setString(1,Practitioner_Id);
		rset	  = stmt.executeQuery();

		if (rset.next())
		{
			currentdateTime	= checkForNull(rset.getString("sdate"));
			currentdate		= currentdateTime.substring(0,10);
			currentTime		= currentdateTime.substring(11);
		
            scheme      = checkForNull(rset.getString("scheme"));
            diag_class_mand_yn = checkForNull(rset.getString("diag_class_mand_yn"));
			restrict_sec_diag_yn = checkForNull(rset.getString("restrict_sec_diag_yn"));//Maheshwaran K added for MMS-DM-CRF-0197.1			
            scheme_desc = checkForNull(rset.getString("scheme_desc"));
			ext_mand_for_consq      = checkForNull(rset.getString("EXT_MAND_FOR_CONSQ"));
            astk_mand_for_dagg = checkForNull(rset.getString("ASTK_MAND_FOR_DAGG"));
			diag_enc_level = checkForNull(rset.getString("diag_enc_level"));//Maheshwaran K added for the SKR-CRF-0020 as on 17/07/2013
			diagnosis_by_long_desc_yn = checkForNull(rset.getString("diagnosis_by_long_desc_yn"));	//Maheshwaran K added diagnosis_by_long_desc_yn for HSA-CRF-0234
			 is_oh_install      = checkForNull(rset.getString("OH_install"));

			 //Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
			 primary_diag_class = checkForNull(rset.getString("primary_diag_class"));
			 secondary_diag_class = checkForNull(rset.getString("secondary_diag_class"));
		}
		if ( rset != null ) rset.close();	
		//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
		curr_encounter_id=Encounter_Id;
		/*if(diag_enc_level.equals("Y")){

			if((old_encounter_id!="")&&(!old_encounter_id.equals(Encounter_Id)))
			Encounter_Id=old_encounter_id;
		}*/

		onset_date				= currentdateTime;

		onset_date_converted	=	DateUtils.convertDate(currentdateTime,"DMYHM","en",locale); 
		status_date_converted	=	DateUtils.convertDate(currentdate,"DMY","en",locale); 
		currentdate				=	DateUtils.convertDate(currentdate,"DMY","en",locale); 
		/*Added On 9/23/2009 FOr MDR*/
		

		String sql45	="select list_value,dflt_value_yn,criteria from  mr_term_set_crit_for_pc where  patient_class=? and criteria in ('PRIORITY','ENCOUNTER_STAGE','NATURE') ";	
		
		stmt=con.prepareStatement(sql45);
		stmt.setString(1,patient_class);
		rset = stmt.executeQuery();
		while(rset.next()){	
			if(checkForNull(rset.getString("criteria")).equals("PRIORITY")){
				prio_list.add(checkForNull(rset.getString("list_value")));
				prio_list.add(checkForNull(rset.getString("dflt_value_yn")));
							}else if (checkForNull(rset.getString("criteria")).equals("ENCOUNTER_STAGE")){
				enc_stg_list.add(checkForNull(rset.getString("list_value")));
				enc_stg_list.add(checkForNull(rset.getString("dflt_value_yn")));
			}else if (checkForNull(rset.getString("criteria")).equals("NATURE")){
				nat_list.add(checkForNull(rset.getString("list_value")));
				nat_list.add(checkForNull(rset.getString("dflt_value_yn")));
			}

		}
		

		if(call_from.equals("MAINTAIN_DEATH_REGISTER")){
			mode="";
		}

		//out.println("<script>alert(\"mode :"+mode+"\");</script>");			

		if(isCleared.equals("Y"))
		{
			RecordSet OHDiagLinkConditionOBJ	=	(webbeans.eCommon.RecordSet)	session.getAttribute("OHDiagLinkConditionOBJ");
			if(OHDiagLinkConditionOBJ!=null)
			{
				OHDiagLinkConditionOBJ.clearAll();
				session.removeAttribute("OHDiagLinkConditionOBJ");
			}
		}
	
			
		if(!term_set_id.equals(""))
			disimage = "visibility:visible";
		term_code				= checkForNull(request.getParameter("term_code"));
		String term_code_dsply		= term_code;
		//if(term_code.equals("*OTH"))
			//term_code_dsply		= "";
				
		stage_code				= checkForNull(request.getParameter("stage_code"));
		String f_authorize_yn	= checkForNull(request.getParameter("f_authorize_yn"));

		String term_short_desc  = checkForNull(request.getParameter("term_short_desc"));
		String term_sht_desc  = checkForNull(request.getParameter("term_sht_desc")); // added by mujafar for ML-MMOH-CRF-1281
		String codes = "";			String Aselect ="";			String Pselect ="";
		String Wselect ="";			String pri_N_select ="";	String pri_H_select ="";
		String pri_C_select ="";	String sevr_L_select ="";	String sevr_D_select ="";
		String sevr_S_select ="";	String sevr_E_select ="";	String stus_A_select ="";
		String stus_R_select ="";	String stus_X_select ="";	String stus_E_select ="";

		String type_A_select = "";	String type_C_select = "";	String mandatory_status	=""; 
		String type_N_select = "";	
		String code_ind	="";		String mandatory_disable	=""; String diff_group_id	="";
		String def_select = "";
		String diag_class_code = "";
		String assign_locn_type = "";
		String _anatomical_site_code = "";
		String _anatomical_short_desc = "";
		String code = "";
		String poa_indicator	= "";
		
		
		/*4/29/2009 IN009713*/
		//11/5/2009 added facility_id

		String Splsql = "select specialty_code,assign_care_locn_type from pr_encounter where encounter_id=? AND facility_id=?" ;


		stmt=con.prepareStatement(Splsql);
		stmt.setString(1,Encounter_Id);
		stmt.setString(2,facility_id);
		rset = stmt.executeQuery();

		if(rset.next())
		{
			spl_code = checkForNull(rset.getString("specialty_code"));
			assign_locn_type = checkForNull(rset.getString("assign_care_locn_type"));
		}
		if(rset != null) rset.close();
		if(speciality_code.equals("") || speciality_code.equals("null"))
			speciality_code=spl_code;
			
		if(Locn_Type.equals("") || Locn_Type.equals("null"))
			Locn_Type=assign_locn_type;

		/**/

		if(is_oh_install==null || is_oh_install.equals(""))
			is_oh_install = "N";
		
	//if(modal_yn.equals("Y")) /*5/7/2009 IN010486*/


	if(modal_yn.equals("Y") && _status.equals("Active"))
	{
		dis_add_associate = "disabled";
		
		if(!term_code.equals("*OTH"))
		{
			//Maheshwaran K modified the query for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select OCCUR_SRL_NO from pr_diagnosis  where patient_id = ? ");
			sql.append(" and TERM_SET_ID=? and TERM_CODE=?  and CURR_STATUS ='A' and curr_encounter_id= ?  ");
			pstmt = con.prepareStatement( sql.toString() ) ;
			pstmt.setString( 1, Patient_Id) ;
			pstmt.setString( 2, term_set_id) ;
			pstmt.setString( 3, term_code) ;
			//Mahesh modified to get the srl no of old enc id 
			if(diag_enc_level.equals("Y"))
				{
				pstmt.setString(4, old_encounter_id) ;
				}
			else
				{	
				pstmt.setString(4, Encounter_Id) ;
				}//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
			rset = pstmt.executeQuery() ;
			while(rset.next())
			{
				occur_srl_no=checkForNull(rset.getString("OCCUR_SRL_NO"));
			}if (pstmt!=null) pstmt.close();
			 if(rset!=null) rset.close();

		}
		if(!occur_srl_no.equals(""))
			mode="modify";
	}	
	
	if(mode.equals("modify"))
	{
		disimage = "visibility:visible";
		mandatory_status="readonly";
		mandatory_disable	="disabled";
		def_select = "";
		
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("select a.accession_num,a.patient_id,a.term_set_id,a.term_code,accession_num_work_related,accession_num_notifiable,"); //Modified for this Bru-HIMS-CRF-024.2
		//Maheshwaran k modified the query for the SKR-SCF-0863 [IN:044466]  as on 22/10/2013
		if(term_code.equals("*OTH"))
			{
			sql.append(" a.term_code_short_desc term_short_desc, ");
			}
		else
			{	
			sql.append(" mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2') term_short_desc, ");
			}
		if(isMultiDescAppl && term_set_id.equals("ICD10")) // Added by mujafar for ML-MMOH-CRF-1281
		sql.append("a.term_code_short_desc term_sht_desc,");
		sql.append("a.code_indicator,to_char(a.onset_date,'dd/mm/rrrr hh24:mi') onset_date,a.ONSET_ENCOUNTER_ID ,a.curr_severity, ");
		sql.append("a.curr_onset_type,a.curr_facility_id,"); 
		sql.append("a.curr_encounter_id,a.curr_practitioner_id ,a.curr_practitioner_reln_id,"); sql.append("a.curr_locn_type,a.curr_locn_code,a.curr_nature,a.curr_priority,");
		sql.append("a.curr_accuracy_code,a.curr_accuracy_ind, a.curr_remarks, a.curr_status,"); sql.append("to_char(a.curr_status_date,'dd/mm/rrrr') status_date ,nvl(c.diff_group_id,'0') diff_group_id,b.high_risk_code,mr_get_desc.mr_high_risk(b.high_risk_code,'"+locale+"','1') highRiskDesc ");
		//<!--modified on 08-may 2008 to add Anatomical site & Applicable Side-->
		sql.append(" , a.anatomical_site , a.applicable_side ,a.diag_class_code,a.anatomical_site_code,AM_GET_DESC.AM_ANATOMICAL_SITE(a.anatomical_site_code,?,'2') anatomical_short_desc,b.dagger_independent_yn,a.poa_indicator poa_indicator");
		//
		sql.append(" from PR_DIAGNOSIS a, MR_TERM_CODE b ,");
		sql.append(" PR_DIFFERENTIAL_DIAGNOSIS c where a.term_code=b.term_code  ");
		sql.append(" and a.term_set_id = b.term_set_id "); 
		sql.append(" and c.term_code(+) = a.term_code ");
		sql.append(" and c.OCCUR_SRL_NO(+) = a.OCCUR_SRL_NO and c.term_set_id(+) = a.term_set_id and ");
		sql.append(" c.patient_id(+) = a.patient_id and ");
		sql.append(" a.patient_id = ? and a.term_set_id = ? and a.term_code = ? "); 
		//if(!term_code.equals("*OTH"))
			sql.append(" and a.occur_srl_no = ?");
		//else
			//sql.append(" and a.term_code_short_desc = ?");
		//sql.append("  and a.curr_status = 'A'");
       
		
		stmt2 = con.prepareStatement(sql.toString());
		
		stmt2.setString(1,locale);
		stmt2.setString(2,Patient_Id);
		stmt2.setString(3,term_set_id);
		stmt2.setString(4,term_code);
		//if(!term_code.equals("*OTH"))
		stmt2.setString(5,occur_srl_no);
		//else
			//stmt2.setString(5,term_code_short_desc);
		rs2 = stmt2.executeQuery();
		

		while(rs2.next())
		{
			status						= checkForNull(rs2.getString("curr_status"));
			Patient_Id				= checkForNull(rs2.getString("patient_id"));
			term_set_id			    = checkForNull(rs2.getString("term_set_id"));
			term_code				= checkForNull(rs2.getString("term_code"));
			term_short_desc		= checkForNull(rs2.getString("term_short_desc")); 
			if(isMultiDescAppl && term_set_id.equals("ICD10")) // added by mujafar for ML-MMOH-CRF-1281
			term_sht_desc		= checkForNull(rs2.getString("term_sht_desc"));
			onset_date				= checkForNull(rs2.getString("onset_date"));
			onset_encounter_id				= checkForNull(rs2.getString("ONSET_ENCOUNTER_ID"));//Mahesh added 06/04/2014
			onset_date_converted	=	DateUtils.convertDate(onset_date,"DMYHM","en",locale); 
			currentTime				= onset_date.substring(11);
			severity					= checkForNull(rs2.getString("curr_severity"));
			onset_type				= checkForNull(rs2.getString("curr_onset_type"));
			curr_encounter_id		= checkForNull(rs2.getString("curr_encounter_id"));
			_Practitioner_Id		= checkForNull(rs2.getString("curr_practitioner_id"));
			relationship_id			= checkForNull(rs2.getString("curr_practitioner_reln_id"));
			/* IN010259 */
			//Locn_Type				= checkForNull(rs2.getString("curr_locn_type"));
			//Locn_Code				= checkForNull(rs2.getString("curr_locn_code"));
			nature						= checkForNull(rs2.getString("curr_nature"));
			priority						= checkForNull(rs2.getString("curr_priority"));
			accuracy_code			= checkForNull(rs2.getString("curr_accuracy_code"));
			remarks					= checkForNull(rs2.getString("curr_remarks"));
			diff_group_id			= checkForNull(rs2.getString("diff_group_id"));
			high_risk_code			= checkForNull(rs2.getString("high_risk_code"));
			highRiskDesc			= checkForNull(rs2.getString("highRiskDesc"));
			status_date_converted		= checkForNull(rs2.getString("status_date"));
			status_date_converted		=	DateUtils.convertDate(status_date_converted,"DMY","en",locale); 
			code_ind							= checkForNull(rs2.getString("code_indicator"));
			anatomical_site					= checkForNull(rs2.getString("anatomical_site"));
			applicable_side					= checkForNull(rs2.getString("applicable_side"));
			diag_class_code				= checkForNull(rs2.getString("diag_class_code"));
			dagger_independent_yn	= checkForNull(rs2.getString("dagger_independent_yn"));
			if(accession_number.equals(""))
				accession_number			= checkForNull(rs2.getString("accession_num"));
			_anatomical_site_code		= checkForNull(rs2.getString("anatomical_site_code"));
			_anatomical_short_desc	= checkForNull(rs2.getString("anatomical_short_desc"));
			
			//Below line Added for this CRF Bru-HIMS-CRF-024.2
			accession_num_work_related = checkForNull(rs2.getString("accession_num_work_related"));
			accession_num_notifiable = checkForNull(rs2.getString("accession_num_notifiable"));
			poa_indicator = checkForNull(rs2.getString("poa_indicator"));
			if(!accession_num_work_related.equals(""))
			dis_work_related_notifiable= "disabled";
			else
			dis_work_related_notifiable= "";
			
		}

		if(code_ind.equals(""))
			dis_add_associate = "disabled";
		else
			dis_add_associate = "";


		if(rs2!=null) rs2.close();
		if(stmt2!=null) stmt2.close();

		
		if(nature.equals("A"))
			Aselect = "selected";
		else if(nature.equals("P"))
			Pselect = "selected";
		else if(nature.equals("W"))
			Wselect = "selected";

		if(priority.equals("N"))
			pri_N_select = "selected";
		else if(priority.equals("H"))
			pri_H_select = "selected";
		else if(priority.equals("C"))
			pri_C_select = "selected";

		if(severity.equals("L"))
			sevr_L_select = "selected";
		else if(severity.equals("D"))
			sevr_D_select = "selected";
		else if(severity.equals("S"))
			sevr_S_select = "selected";
		else if(severity.equals("E"))
			sevr_E_select = "selected";
	
		if(status.equals("A"))
		{	
			stus_A_select = "selected";
			def_status="";
			date_status="readOnly";
			def_disable	="";
		}
		else if(status.equals("R"))
		{
			stus_R_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
		else if(status.equals("X"))
		{
			stus_X_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
		else if(status.equals("E"))
		{
			stus_E_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
	
		if(onset_type.equals("A"))
			type_A_select = "selected";
		else if(onset_type.equals("C"))
			type_C_select = "selected";
		else 
			type_N_select = "selected";

		if(!option_id.equals("OH_REST_CHART_REC"))
		{
		
			if(anatomical_site.equals("O"))
				anatomy_select_o = "selected";
			else if(anatomical_site.equals("C"))
				anatomy_select_c = "selected";
			else
				anatomy_select_default = "selected";


		}
		else
		{
			if(anatomical_site.equals("C"))
				anatomy_select_c = "selected";
			else if(anatomical_site.equals("O"))
				anatomy_select_o = "selected";	
			else
				anatomy_select_default = "selected";			
		}

		
		if(applicable_side.equals("L"))
			applicable_l = "selected";
		else if(applicable_side.equals("R"))
			applicable_r = "selected";
		else if(applicable_side.equals("B"))
			applicable_b = "selected";
		else if(applicable_side.equals("N"))
			applicable_n = "selected";
		
		//For Supprot Diiagnosis.......
		if(sql.length() > 0) sql.delete(0,sql.length());
		int temp=0;
		String supp_term_code=""; String supp_term_desc ="";
		StringBuffer temp_associate_codes = new StringBuffer();
        //Added for this CRF GDOH-CRF-0082		
		StringBuffer temp_supportdiag_codes = new StringBuffer();		
		
		
/*
		sql.append(" select a.supp_term_code ,b.short_desc from PR_SUPPORT_DIAGNOSIS a , ");
		sql.append(" MR_TERM_CODE b where b.term_code = a.supp_term_code and a.patient_id =? and ");
		sql.append(" a.term_code = ? and b.term_set_id = ? and occur_srl_no=? and srl_no=");
		sql.append("(select max(srl_no) from PR_SUPPORT_DIAGNOSIS where patient_id=a.patient_id and "); 
		sql.append(" term_set_id=a.term_set_id and term_code=a.term_code and occur_srl_no=a.occur_srl_no) ");
		

sql.append("  SELECT a.supp_term_code, b.short_desc FROM pr_support_diagnosis a, mr_term_code b WHERE b.term_code = a.supp_term_code AND a.patient_id = ? AND a.term_set_id = ? AND b.term_set_id = ? AND a.term_code = ? AND occur_srl_no = ? AND srl_no = (SELECT MAX (srl_no) FROM pr_support_diagnosis WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no) ");
*/
		/*Friday, January 29, 2010 SRR20056-CRF-0303.2 IN015597 */
		sql.append("  SELECT a.supp_term_code, b.short_desc FROM pr_support_diagnosis a, mr_term_code b WHERE b.term_code = a.supp_term_code AND a.patient_id = ? AND a.term_set_id = ? AND b.term_set_id = ? AND a.term_code = ? AND occur_srl_no = ?  ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,Patient_Id);
		pstmt.setString(2,term_set_id);
		pstmt.setString(3,term_set_id);
		pstmt.setString(4,term_code);
		pstmt.setString(5,occur_srl_no);
		rset = pstmt.executeQuery();
		      
		temp = 0;
		while(rset.next())
		{
			supp_term_code = checkForNull(rset.getString(1));
			supp_term_desc = checkForNull(rset.getString(2));
			/*Added by Dharma for single quote issue Start for ML-MMOH-CRF-0733*/
			if(!supp_term_desc.equals("")){
				supp_term_desc	= supp_term_desc.replaceAll("\'","");
			}
			/*Added by Dharma for single quote issue End*/				
			if(temp == 0)
				temp_associate_codes.append(supp_term_code + "~" + supp_term_desc);
			else
				temp_associate_codes.append("|" + supp_term_code + "~" + supp_term_desc);	
			temp++;
			
			//Below line added for this CRF GDOH-CRF-0082
			temp_supportdiag_codes.append("'"+supp_term_code+"',"); 
			supportdiagCount++;
		}
	   //Below line added for this CRF GDOH-CRF-0082
		support_diag_code = temp_supportdiag_codes.toString();
		if(!support_diag_code.equals("")){	
			support_diag_code=support_diag_code.substring(0,support_diag_code.length()-1);
		}	
		//End GDOH-CRF-0082
		
		if(associate_codes.equals(""))
			associate_codes = temp_associate_codes.toString();

		
		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
		
		/*Below line added for this CRF GDOH-CRF-0082*/	
           if(diagnosisPmb){   
              pmb_code=eMR.MRQueryPMBCode.getPMBCode(con,term_code_dsply);             		  
	       }			
		//End GDOH-CRF-0082
		
	}
	else
	{
		def_disable="";			def_status	="";
		mandatory_status="";	mandatory_disable	="";
		def_select = "selected";

		if(option_id.equals("OH_REST_CHART_REC"))
		{
			anatomy_select_c = "selected";	
			oral_sites_style = "visibility:visible";
		}
		else		
		{
			anatomy_select_o = "selected";
			oral_sites_style = "visibility:hidden";
		}

		if(option_id.equals("OH_REST_CHART_REC"))	
		{
			anatomical_site = "C";
			oral_sites_style= "visibility:visible";
		}
		else
		{
			anatomical_site = "O";
			oral_sites_style= "visibility:hidden";
		}

		
	}

	
	//For  Diagnosis Stage
	//added encounter_id on 3/26/2009 since returning more rows for multiple encounters.
	//11/5/2009 added facility_id

	if(sql.length() > 0) sql.delete(0,sql.length());
	
		sql.append(" Select enc_stage,NOTIFICATION_CODE, cause_of_death_yn, link_diag_pri_sec_yn  from PR_DIAGNOSIS_ENC_DTL where patient_id = ? and TERM_CODE = ? and TERM_SET_ID = ? and encounter_id = ?  and facility_id= ? AND status != 'E'");//Modified on 3rd May 2018 against ML-BRU-SCF-1818
	//sql.append(" Select ip_diag_stage from pr_problem where patient_id = ? and srl_no = ? ");

	pstmt	=	con. prepareStatement(sql.toString());
	pstmt.setString(1,Patient_Id);
	//pstmt.setString(2,srl_no);
	pstmt.setString(2,term_code);
	pstmt.setString(3,term_set_id);
	pstmt.setString(4,Encounter_Id);
	pstmt.setString(5,facility_id);
	rset = pstmt.executeQuery();

	if(rset.next())
	{
		diagstagecode	=	checkForNull(rset.getString("enc_stage"));
		/*Added on 3rd May 2018 against ML-BRU-SCF-1818 Start*/
		if(notifiable_code.equals("") && diag_enc_level.equals("N"))
			notifiable_code	=	checkForNull(rset.getString("NOTIFICATION_CODE"));
		/*End*/
		cause_of_death_yn	=	checkForNull(rset.getString("cause_of_death_yn"));
		link_diag_pri_sec_yn = checkForNull(rset.getString("link_diag_pri_sec_yn")); //Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
 	}
	/*Added on 3rd May 2018 against ML-BRU-SCF-1818 Start*/
	if(notifiable_code.equals(""))
	notifiable_code_style="disabled";
	/*End*/
	if(cause_of_death_yn == null)	cause_of_death_yn = "N";

	String checkDeath = "";
	if(cause_of_death_yn.equals("Y"))
		checkDeath = "checked";
	
	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	if(link_diag_pri_sec_yn == null) link_diag_pri_sec_yn = "N";
	if(link_diag_pri_sec_yn.equals("Y"))
		checklinkprisec = "checked";
	
	if(rset!=null)  rset.close();
	if(pstmt!=null) pstmt.close();

	
	if(!(diagstagecode==null || diagstagecode.equals("")))
		{
			if(diagstagecode.equals("A"))
				diastgSel_1="selected";
			else if(diagstagecode.equals("I"))
				diastgSel_2="selected";
			else if(diagstagecode.equals("D"))
				diastgSel_3="selected";
		}

	
		// Changes modified on 02-03-2012 against Incident Number 26033 by Saanthaakumar
		
		
		
	if(called_from_ip.equals("Y"))
	{

		    if(diagstagecode.equals("A"))
				diastgSel_1="selected";
			else if(diagstagecode.equals("I"))
				diastgSel_2="selected";
			else if(diagstagecode.equals("D"))
				diastgSel_3="selected";
	}
//modified over Incident Number 26033

	
String recode_curr_level	= "";

if(mode.equals("modify")) {

	String view_link = "SELECT Count(*) FROM mr_equivalent_term_code  WHERE term_code = ? and CROSS_REF_TYPE='EQ'";
		
			pstmt = con.prepareStatement( view_link.toString() ) ;
			pstmt.setString( 1, term_code) ;
			rset = pstmt.executeQuery();
			if(rset != null && rset.next())
				view_cnt = rset.getInt(1);
			if(rset!=null)  rset.close();
			if(pstmt!=null) pstmt.close();

	
if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append("select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text, to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and a.occur_srl_no='"+occur_srl_no+"'");
			if(!term_code.equals("*OTH"))
				sql.append("and a.term_code = ? ");
			else
				sql.append("and a.term_code_short_desc = ? ");
			sql.append("order by a.onset_date desc");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,Encounter_Id);
			pstmt.setString(4,term_set_id);
			if(!term_code.equals("*OTH"))
				pstmt.setString(5,term_code);
			else
				pstmt.setString(5,term_short_desc);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				complaint_Desc		= rset.getString("complaint_text")==null?"":rset.getString("complaint_text");
				complaint_id		= rset.getString("complaint_id")==null?"":rset.getString("complaint_id");
				if(firstTime)
				{
					_complaint_Desc = _complaint_Desc + "" +complaint_Desc +"";
					_complaint_id   = _complaint_id + "" +complaint_id +"";
				}
				else
				{
					_complaint_Desc = _complaint_Desc + ";" +complaint_Desc +"";
					_complaint_id   = _complaint_id + "$" +complaint_id +"";
				}
				firstTime = false;
			}
				
			if(rset!=null)  rset.close();
			if(pstmt!=null) pstmt.close();

/*
	1.Added On 2/22/2010 For SRR-CRF-303.2 [IN015597]
	2.Makring of Originals from Recording when recoding was started for a patient.
	3.Retriving the  Curr_Level is at Encounter Level.
*/


			String RECODE_HDR_SQL ="SELECT CURR_LEVEL FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+facility_id+"' AND ENCOUNTER_ID='"+Encounter_Id+"'";
			pstmt = con.prepareStatement(RECODE_HDR_SQL);
			rset	= pstmt.executeQuery();
			while(rset.next()){
				recode_curr_level = checkForNull(rset.getString("CURR_LEVEL"));
			}

			if(rset!=null)  rset.close();
			if(pstmt!=null) pstmt.close();

}




            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(call_from.equals("MAINTAIN_DEATH_REGISTER")){
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
if(mode.equals("modify") ||modal_yn.equals("Y"))
            out.print( String.valueOf(mandatory_disable));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);


			if(sql.length() > 0) sql.delete(0,sql.length());
			//sql.append(" select a.term_set_id,(select dflt_term_set_yn from mr_term_set_for_pract_type		 where term_set_id=a.term_set_id and pract_type = ?)dflt_term_set_yn,priority_appl_yn || '=' || nature_appl_yn || '=' || severity_appl_yn || '=' || onset_type_appl_yn || '=' || factors_appl_yn || '=' || notification_appl_yn || '=' || enc_stage_appl_yn term_set_id1, term_set_desc from MR_TERM_SET a where exists (select 1 from MR_TERM_SET_FOR_FACILITY where facility_id = ? and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_PRACT_TYPE where pract_type = ? and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_SPECIALTY where specialty_code in (select specialty_code from PR_ENCOUNTER where facility_id = ? and encounter_id = ? ) and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_PRACT ib where practitioner_id = ? and ( term_set_id = a.term_set_id or not exists (select 1 from MR_TERM_SET_FOR_PRACT where practitioner_id = ? ))) and eff_status = 'E' and diag_spec_yn = 'Y' order by term_set_desc ");
			/*3/5/2009 IN008756 for defaulting practitioner and pract type*/
			//inpatient_appl_yn and daycare_appl_yn is Added for ML-MMOH-CRF-1581 by KAMATCHI S //diagnosis_class_mand_yn Added by Suji Keerthi for ML-MMOH-CRF-1395 US002
			sql.append(" select a.term_set_id,(SELECT b.dflt_term_set_yn FROM mr_term_set_for_pract_type b,am_practitioner c WHERE b.pract_type = ? AND b.term_set_id = a.term_set_id AND c.practitioner_id = ? AND c.pract_type = b.pract_type) default_pract_type,(SELECT b.dflt_term_set_yn FROM mr_term_set_for_pract_type d,  mr_term_set_for_pract b, am_practitioner c WHERE d.term_set_id = b.term_set_id AND d.pract_type = ? AND b.practitioner_id = ?  AND c.practitioner_id = b.practitioner_id AND c.pract_type = d.pract_type AND a.term_set_id = d.term_set_id) default_pract,priority_appl_yn || '=' || nature_appl_yn || '=' || severity_appl_yn || '=' || onset_type_appl_yn || '=' || factors_appl_yn || '=' || notification_appl_yn || '=' || enc_stage_appl_yn || '=' ||inpatient_appl_yn || '=' || daycare_appl_yn || '=' || diagnosis_class_mand_yn term_set_id1 , mr_get_desc.mr_term_set(a.term_set_id,'"+locale+"',1)term_set_desc ,free_text_applicable_yn from MR_TERM_SET a where exists (select 1 from MR_TERM_SET_FOR_FACILITY where facility_id = ? and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_PRACT_TYPE where pract_type = ? and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_SPECIALTY where specialty_code in (select specialty_code from PR_ENCOUNTER where facility_id = ? and encounter_id = ? ) and term_set_id = a.term_set_id) and (exists (select 1 from MR_TERM_SET_FOR_PRACT ib where practitioner_id = ? and  term_set_id = a.term_set_id) or not exists (select 1 from MR_TERM_SET_FOR_PRACT where practitioner_id = ? )) and eff_status = 'E' and diag_spec_yn = 'Y' order by term_set_desc ");
			
			pstmt = con.prepareStatement(sql.toString());

            pstmt.setString( 1, practitioner_type);
			pstmt.setString( 2, Practitioner_Id);
			pstmt.setString( 3, practitioner_type);
			pstmt.setString( 4, Practitioner_Id);
			pstmt.setString( 5, facility_id);
			pstmt.setString( 6, practitioner_type);
			pstmt.setString( 7, facility_id);
			pstmt.setString( 8, Encounter_Id);
			pstmt.setString( 9, Practitioner_Id);
			pstmt.setString( 10, Practitioner_Id);
			rset = pstmt.executeQuery();
			

			while(rset.next())
			{
				String desc = checkForNull(rset.getString("term_set_desc"));
				//String dflt_term_set_yn = rset.getString("dflt_term_set_yn");
				String default_pract_type = checkForNull(rset.getString("default_pract_type"));
				String default_pract = checkForNull(rset.getString("default_pract"));
				code = checkForNull(rset.getString("term_set_id"));
				
				String code1 = checkForNull(rset.getString("term_set_id1"));
				free_text_applicable_yn = checkForNull(rset.getString("free_text_applicable_yn"));
				String sel = "";

				if(term_set_id.equals(code))
				{
					out.print("<option value='"+code+"' id='"+code1+"' selected >"+desc+"</option>");
				}
				/*
					If we not use this condition(!mode.equals("modify")) in modify mode it reloading again 2/18/2009 (IN008320 )
				*/
				//else if(dflt_term_set_yn.equals("Y")&&!mode.equals("modify"))
				/*
					3/5/2009 IN008756 for defaulting practitioner and pract type

					Practitioner_type  Practitioner   Default Term-set
					     Y					Y			Y
						 N					Y			Y
						 Y					N			N
						 N					N			N
				*/
				else if(((default_pract_type.equals("Y") && default_pract.equals("Y")) || (default_pract_type.equals("N") && default_pract.equals("Y"))) && !mode.equals("modify"))
				{

					sel="selected";
					out.print("<option value='"+code+"'"+sel+" id='"+code1+"'>"+desc+"</option>");
					
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block25Bytes, _wl_block25);

					
					
					
				}
				else{

						out.print("<option value='"+code+"'"+sel+" id='"+code1+"'>"+desc+"</option>");

				}

			}
			if(rset	!= null)   rset.close();
			if(pstmt  != null)   pstmt.close();		
		
		
            _bw.write(_wl_block26Bytes, _wl_block26);

	if(call_from.equals("MAINTAIN_DEATH_REGISTER")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Expand.label","mr_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Collapse.label","common_labels")));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disimage));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
if(mode.equals("modify") || modal_yn.equals("Y"))
            out.print( String.valueOf(mandatory_status));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(term_code_dsply));
            _bw.write(_wl_block35Bytes, _wl_block35);
if(!mode.equals("modify")){
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block38Bytes, _wl_block38);


		
            _bw.write(_wl_block39Bytes, _wl_block39);
if(!isEnlargeDiagFldAppl){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(term_short_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(term_short_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
if(mode.equals("modify") ||modal_yn.equals("Y"))
            out.print( String.valueOf(mandatory_disable));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dis_add_associate));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(!notifiable_yn.equals("Y")){
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);

		if(!isMultiDescAppl)
		{ // if - else added by mujafar for ML-MMOH-CRF-1281
		
            _bw.write(_wl_block49Bytes, _wl_block49);
if(view_cnt==0){
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
}
		else
		{
		
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(includevisibility));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(includevisibility));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
		
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block63Bytes, _wl_block63);
 if(isPrepDisDefaultDischargeAppl && function_id.equals("PRE_DIS_ADVICE")) 
			{
               if(mode.equals("modify")) {
				   if(diagstagecode.equals("") || diagstagecode==null)
					   {
                           diastgSel_3 ="selected";
                        }
				   
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(diastgSel_1));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(diastgSel_2));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(diastgSel_3));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
}else{ 
					   
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
} }
		
		   else { 
				
		
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
	
			for(int ij=0;ij<enc_stg_list.size();ij+=2){
			
				String list_value="";
				String dflt_value_yn = "";
				String list_value1="";
				//String mode1 ="";
				list_value=checkForNull((String) enc_stg_list.get(ij));
				
				dflt_value_yn=checkForNull((String) enc_stg_list.get(ij+1));
				
				if(list_value.equals("ADMISSION"))
				{
					list_value="A";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");

				}
				if(list_value.equals("INTERMEDIATE"))
				{
					list_value="I";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				}
				if(list_value.equals("DISCHARGE"))
				{
					list_value="D";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
				}


				if(!mode.equals("modify"))
				{
					
						if(dflt_value_yn.equals("Y"))
						{
							out.print("<option value='"+list_value+"' selected />"+list_value1 );

						}
						else
						{
							out.print("<option value='"+list_value+"'  />"+list_value1 );
						}
				}
				
			}
			//if(rset!=null) rset.close();

			String Admission = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
			String Intermediate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
			String Discharge = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
			
			if(mode.equals("modify"))
				{
						
						/*
						out.print("<option value='A' "+diastgSel_1+"  />Admission");
						out.print("<option value='I' "+diastgSel_2+"  />Intermediate");
						out.print("<option value='D' "+diastgSel_3+"  />Discharge");
						*/
						out.print("<option value='A' "+diastgSel_1+"  />"+Admission);
						out.print("<option value='I' "+diastgSel_2+"  />"+Intermediate);
						out.print("<option value='D' "+diastgSel_3+"  />"+Discharge);
						
						
				}
	} //End for else condition
		
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

		if(isMultiDescAppl) {
		
            _bw.write(_wl_block79Bytes, _wl_block79);
if(view_cnt==0){
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
 }else if(isCoderDiagAppl){
		
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
if("Y".equals(poa_indicator)){
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
if("N".equals(poa_indicator)){
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block86Bytes, _wl_block86);
if("U".equals(poa_indicator)){
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block87Bytes, _wl_block87);
if("W".equals(poa_indicator)){
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block88Bytes, _wl_block88);
if("1".equals(poa_indicator)){
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
}else{
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block91Bytes, _wl_block91);
if(isDeceasedDiagClassDeathRegAppl && !primary_diag_class.equals("") && !secondary_diag_class.equals("")){
		if(linked_yn.equals("Y")){
			if(diag_class_code.equals(primary_diag_class) && link_diag_pri_sec_yn.equals("Y")){
				linkcheckboxdisp = "inline";
			}
		}else{
			if(diag_class_code.equals(primary_diag_class)){
				linkcheckboxdisp = "inline";
			}
		}
	
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(linkcheckboxdisp));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(link_diag_pri_sec_yn));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(checklinkprisec));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block97Bytes, _wl_block97);
//if(isDiagCatgMand && isPatClsForDiagCat){
			if(isDiagCatgMand) {
			
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

if(mode.equals("modify")){
	String diagCatSql = "select diag_catg_code, short_desc, eff_status from mr_diag_category where eff_status = 'E' order by DIAG_CATG_CODE";
					pstmt = con.prepareStatement(diagCatSql);
					rset = pstmt.executeQuery();
					while(rset.next()){
						if(diag_catg_code.equals(rset.getString("diag_catg_code"))){
						out.println("<OPTION value = '"+rset.getString("diag_catg_code")+"' selected>"+rset.getString("short_desc")+"</OPION>");
						}else{
							out.println("<OPTION value = '"+rset.getString("diag_catg_code")+"'>"+rset.getString("short_desc")+"</OPION>");
						}
					}
}else{ 					
					String diagCatSql = "select diag_catg_code, short_desc, eff_status from mr_diag_category where eff_status = 'E' order by DIAG_CATG_CODE";
					pstmt = con.prepareStatement(diagCatSql);
					rset = pstmt.executeQuery();
					while(rset.next()){
						out.println("<OPTION value = '"+rset.getString("diag_catg_code")+"'>"+rset.getString("short_desc")+"</OPION>");
					}
}			


					
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(DiagCatgImgHdn));
            _bw.write(_wl_block102Bytes, _wl_block102);
}
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(_complaint_Desc));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(_complaint_id));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block107Bytes, _wl_block107);
 if(!mode.equals("modify")){
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(_complaint_Desc));
            _bw.write(_wl_block110Bytes, _wl_block110);
 
			Boolean legendChangeAsTypesOfNotiForm =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","TYPES_OF_NOTIFICATION_FORM"); //Added by Sangeetha for ML-MMOH-CRF-0547
			Boolean notifiableLegndChgApplYn =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","NOTIFIABLE_LEGEND_CHG"); //Added by Dharma
			
            _bw.write(_wl_block111Bytes, _wl_block111);
if(legendChangeAsTypesOfNotiForm){ 
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
 }else if(notifiableLegndChgApplYn){ 
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
}else{
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
 } 
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(legendChangeAsTypesOfNotiForm));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(notifiableLegndChgApplYn));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(dis_work_related_notifiable));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
try
				{
			//	String notify_sql="SELECT NOTIFICATION_CODE,SHORT_DESC,EMAIL_APPLICABLE FROM MR_NOTIFICATION_SETUP WHERE EFF_STATUS='E'";
			    String notify_sql="SELECT NOTIFICATION_CODE,SHORT_DESC,EMAIL_APPLICABLE,DEFAULT_NOTE_TYPE FROM MR_NOTIFICATION_SETUP WHERE EFF_STATUS='E'"; //senthil modified
				pstmt = con.prepareStatement(notify_sql);
				rset=pstmt.executeQuery();
				while(rset.next())
					{
					String notify_code=rset.getString("NOTIFICATION_CODE");
					String notify_desc=rset.getString("SHORT_DESC");
					email_yn=rset.getString("EMAIL_APPLICABLE");
					default_note_type=rset.getString("DEFAULT_NOTE_TYPE")==null?"":rset.getString("DEFAULT_NOTE_TYPE");					
					if(notifiable_code.equals(notify_code))
						{
						email_sel_yn=email_yn;
						deflt_note_type=default_note_type; //Added Senthil
						out.println("<option value='"+notify_code+"&"+email_yn+"&"+default_note_type+"' selected>"+notify_desc+"</option>");
						}
					else{	
					out.println("<option value='"+notify_code+"&"+email_yn+"&"+default_note_type+"'>"+notify_desc+"</option>");	
					}
					}
				if(pstmt!=null) pstmt.close();
				if(rset	!= null)   rset.close();
				}
			catch(Exception e)
				{
				e.printStackTrace();
				}
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(notifiable_code_style));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

			//String sql1	="select list_value,dflt_value_yn from  mr_term_set_crit_for_pc where  patient_class='"+patient_class+"' and criteria='NATURE'";

			
			//rset = stmt.executeQuery(sql1);
			//while(rset.next()){	
				
			for(int ij=0;ij<nat_list.size();ij+=2){
			
				String list_value="";
				String dflt_value_yn = "";
				String list_value1="";
				//String mode1 ="";
				list_value=checkForNull((String) nat_list.get(ij));
				dflt_value_yn=checkForNull((String) nat_list.get(ij+1));
			

				
				if(list_value.equals("ACTUAL"))
				{
					list_value="A";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
				}
				if(list_value.equals("WELLNESS"))
				{
					list_value="W";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
				}
				if(list_value.equals("POTENTIAL"))
				{
					list_value="P";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
				}


				if(!mode.equals("modify"))
				{
					
						if(dflt_value_yn.equals("Y"))
						{
							out.print("<option value='"+list_value+"' selected />"+list_value1 );

						}
						else
						{
							out.print("<option value='"+list_value+"'  />"+list_value1 );
						}
				}
				
			}
					
			//if(rset!=null) rset.close();

			String Actual = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
			String Wellness = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
			String Potential = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
			if(mode.equals("modify"))
				{
						/*
						out.print("<option value='A' "+Aselect+"  />Actual" );
						out.print("<option value='W' "+Wselect+"  />Wellness" );
						out.print("<option value='P' "+Pselect+"  />Potential" );
						*/
						out.print("<option value='A' "+Aselect+"  />"+Actual );
						out.print("<option value='W' "+Wselect+"  />"+Wellness );
						out.print("<option value='P' "+Pselect+"  />"+Potential );

						
				}
			
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);

			

			String sql3	="select a.accuracy_code||'='||a.accuracy_indicator accuracy_code1, a.accuracy_code, a.short_desc,b.DFLT_VALUE_YN from MR_ACCURACY_LANG_VW a , mr_term_set_crit_for_pc b where a.language_id=? and a.eff_status='E' AND a.accuracy_code=b.accuracy_code and b.patient_class=? and b.criteria='ACCURACY' order by a.short_desc";

				stmt=con.prepareStatement(sql3);
				stmt.setString(1,locale);
				stmt.setString(2,patient_class);
				rset = stmt.executeQuery();
			
			while(rset.next())
			{	
				
				String accr_desc = checkForNull(rset.getString("short_desc"));
				String accr_code = checkForNull(rset.getString("accuracy_code1"));
				codes = checkForNull(rset.getString("accuracy_code"));
				String dflt_value_yn=checkForNull(rset.getString("dflt_value_yn"));


				if(accuracy_code.equals(codes))
				{
					out.print("<option value='"+accr_code+"' selected />"+accr_desc );
					if(accr_desc.equals("Provisional")){
							style_def = "[ Differential Group ]";
					}
				}
				else
				{
					style_def = "";
					if(!mode.equals("modify"))
					{
						if(dflt_value_yn.equals("Y"))
							out.print("<option value='"+accr_code+"' selected />"+accr_desc );
						else
							out.print("<option value='"+accr_code+"'/>"+accr_desc );	
					}
					else
						out.print("<option value='"+accr_code+"'/>"+accr_desc );	
						
					
				}
			
			}
			if(rset!=null) rset.close();




		
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(style_def));
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block134Bytes, _wl_block134);
if(!mode.equals("modify")){
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);
}else{
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(sevr_D_select));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(def_select));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
}
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(sevr_L_select));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(sevr_S_select));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(sevr_E_select));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);

				//String sql2	="select list_value,dflt_value_yn from  mr_term_set_crit_for_pc where  patient_class='"+patient_class+"' and criteria='PRIORITY'";

				//rset = stmt.executeQuery(sql2);

			//while(rset.next()){	

			for(int ij=0;ij<prio_list.size();ij+=2){
			
				String list_value="";
				String dflt_value_yn = "";
				String list_value1="";
				//String mode1 ="";
				list_value=checkForNull((String) prio_list.get(ij));
				dflt_value_yn=checkForNull((String) prio_list.get(ij+1));
			

				
					
				if(list_value.equals("NORMAL"))
				{
					list_value="N";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
				}
				if(list_value.equals("HIGH"))
				{
					list_value="H";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
				}
				if(list_value.equals("CRITICAL"))
				{
					list_value="C";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
				}


				if(!mode.equals("modify"))
				{
					
						if(dflt_value_yn.equals("Y"))
						{
							out.print("<option value='"+list_value+"' selected />"+list_value1 );

						}
						else
						{
							out.print("<option value='"+list_value+"'  />"+list_value1 );
						}
				}
				
			}
			//if(rset!=null) rset.close();

			String Normal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels"); 
			String High = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels"); 
			String Critical = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels"); 
			
			if(mode.equals("modify"))
				{
						/*
						out.print("<option value='N' "+pri_N_select+"  />Normal");
						out.print("<option value='H' "+pri_H_select+"  />High");
						out.print("<option value='C' "+pri_C_select+"  />Critical" );
						*/
						out.print("<option value='N' "+pri_N_select+"  />"+Normal);
						out.print("<option value='H' "+pri_H_select+"  />"+High);
						out.print("<option value='C' "+pri_C_select+"  />"+Critical);

						
				}
			
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(type_N_select));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(type_A_select));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(type_C_select));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(onset_type));
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(onset_date_converted));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(date_status));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(def_status));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(onset_date_converted));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block157Bytes, _wl_block157);
 if(mode.equals("modify"))
            out.print( String.valueOf(mandatory_disable));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block159Bytes, _wl_block159);
if(!mode.equals("modify")){
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(date_status));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(def_status));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(date_status));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(def_status));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(date_status));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(def_status));
            _bw.write(_wl_block164Bytes, _wl_block164);
}else{
            _bw.write(_wl_block165Bytes, _wl_block165);
}
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block107Bytes, _wl_block107);
if(!mode.equals("modify")){
            _bw.write(_wl_block168Bytes, _wl_block168);
}
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(stus_A_select));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(stus_R_select));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(stus_X_select));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(stus_E_select));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(def_status));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(date_status));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(status_date_converted));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(def_disable));
            _bw.write(_wl_block176Bytes, _wl_block176);
if((mode.equals("modify") && isCurrentEncounter.equals("Y")) || (!mode.equals("modify"))){
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);
}else{
}
            _bw.write(_wl_block178Bytes, _wl_block178);
if((mode.equals("modify") && isCurrentEncounter.equals("Y")) || (!mode.equals("modify"))){
            _bw.write(_wl_block179Bytes, _wl_block179);
if(isCurrentEncounter.equals("Y")){}else{
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block180Bytes, _wl_block180);
}else{
}
            _bw.write(_wl_block181Bytes, _wl_block181);
if(is_oh_install.equals("Y")){
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
if (mode.equals("modify")){
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(anatomy_select_default));
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(anatomy_select_c));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(anatomy_select_o));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
            _bw.write(_wl_block189Bytes, _wl_block189);
            _bw.write(_wl_block190Bytes, _wl_block190);
if (mode.equals("modify")){
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block191Bytes, _wl_block191);

			if(!mode.equals("modify"))
			{

            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);

			}else{
				if(_anatomical_site_code.equals("")){
				
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);

				}
				else
				{

					out.print("<option value='"+_anatomical_site_code+"' selected/>"+_anatomical_short_desc );
				}
			}


            _bw.write(_wl_block195Bytes, _wl_block195);
}else{
            _bw.write(_wl_block196Bytes, _wl_block196);
}
            _bw.write(_wl_block197Bytes, _wl_block197);
if(option_id.equals("OH_REST_CHART_REC")){ 
            _bw.write(_wl_block198Bytes, _wl_block198);
if(!anatomical_site.equals("O") && anatomical_site.equals("C"))

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block199Bytes, _wl_block199);
}else{
            _bw.write(_wl_block200Bytes, _wl_block200);
}
            _bw.write(_wl_block197Bytes, _wl_block197);
if(is_oh_install.equals("Y")){
            _bw.write(_wl_block201Bytes, _wl_block201);
if(option_id.equals("OH_REST_CHART_REC") && ! anatomical_site.equals("O")){
            _bw.write(_wl_block202Bytes, _wl_block202);
}else if(anatomical_site.equals("C")){
            _bw.write(_wl_block203Bytes, _wl_block203);
}else if(anatomical_site.equals("0")){
            _bw.write(_wl_block204Bytes, _wl_block204);
}else if(anatomical_site.equals("")){
            _bw.write(_wl_block203Bytes, _wl_block203);
}
            _bw.write(_wl_block205Bytes, _wl_block205);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);
if(option_id.equals("OH_REST_CHART_REC") && ! anatomical_site.equals("O")){
            _bw.write(_wl_block202Bytes, _wl_block202);
}else if(anatomical_site.equals("C")){
            _bw.write(_wl_block203Bytes, _wl_block203);
}else if(anatomical_site.equals("0")){
            _bw.write(_wl_block207Bytes, _wl_block207);
}else if(anatomical_site.equals("")){
            _bw.write(_wl_block203Bytes, _wl_block203);
}
            _bw.write(_wl_block208Bytes, _wl_block208);
if(mode.equals("modify")){
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(applicable_l));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(applicable_r));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(applicable_b));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(applicable_n));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
}else{
            _bw.write(_wl_block196Bytes, _wl_block196);
}
            _bw.write(_wl_block214Bytes, _wl_block214);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(def_status));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block217Bytes, _wl_block217);
	if(scheme.equals("1") ||  scheme.equals("2"))
    {	
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(retVal_auth));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(significant_yn));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(srl_no_from_table));
            _bw.write(_wl_block223Bytes, _wl_block223);
	}
    else
	{	
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(retVal_auth));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(srl_no_from_table));
            _bw.write(_wl_block223Bytes, _wl_block223);
	}	
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(curr_encounter_id));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(onset_date_converted));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(ext_mand_for_consq));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(astk_mand_for_dagg));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(diag_class_mand_yn));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(isMultiDescAppl));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(java.net.URLEncoder.encode(term_sht_desc)));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(notifiable_yn));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(age));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(scheme_desc));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(status_date_converted));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(isEncounterStage));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(currentTime));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block264Bytes, _wl_block264);
if(mode.equals("modify")){ 
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(code_ind));
            _bw.write(_wl_block266Bytes, _wl_block266);
} else{
            _bw.write(_wl_block267Bytes, _wl_block267);
}
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(diff_group_id));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block270Bytes, _wl_block270);
if(!call_from.equals("MAINTAIN_DEATH_REGISTER")){
            _bw.write(_wl_block271Bytes, _wl_block271);
}
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(high_risk_code));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(isCalledFromCA));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(old_encounter_id));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(onset_encounter_id));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(diagcode));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(diag_class));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(diag_class_code));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(recode_curr_level));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(isCurrentEncounter));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(diag_enc_level));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(called_from_ot));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(restorative_Chart));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(is_oh_install));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(email_sel_yn));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(diagnosis_by_long_desc_yn));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(notifiable_code));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(deflt_note_type));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(notifiable_form_mand_yn));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(accession_num_work_related));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(accession_num_notifiable));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(diagnosisPmb));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(support_diag_code));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(supportdiagCount));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(termCodeEffStatus));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(isDiagClassMand));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(restrict_sec_diag_yn));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(isPrepDisDefaultDischargeAppl));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(isDiagCatgMand));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(isPatClsForDiagCat));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(mode_modify_curr_enc));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(isDeceasedDiagClassDeathRegAppl));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(primary_diag_class));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(secondary_diag_class));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(linked_yn));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(code_ind));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(code_ind));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(notifiable_yn));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(high_risk_code));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(highRiskDesc));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(diagnosisPmb));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(pmb_code));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(pmb_code));
            _bw.write(_wl_block326Bytes, _wl_block326);

if(stmt  != null)   stmt.close();		

} 
catch(Exception sqle)
{
	sqle.printStackTrace() ;
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

session.removeAttribute("diagnosis_code"); //Added for this CRF GDOH-CRF-0082


            _bw.write(_wl_block327Bytes, _wl_block327);
if(mode.equals("modify") && status.equals("A")) {
            _bw.write(_wl_block328Bytes, _wl_block328);
}
            _bw.write(_wl_block3Bytes, _wl_block3);
if((mode.equals("modify") && isCurrentEncounter.equals("Y")) || (!mode.equals("modify"))){
            _bw.write(_wl_block329Bytes, _wl_block329);
}
            _bw.write(_wl_block330Bytes, _wl_block330);
if(!mode.equals("modify")){
            _bw.write(_wl_block331Bytes, _wl_block331);
}else {
            _bw.write(_wl_block332Bytes, _wl_block332);
}
            _bw.write(_wl_block3Bytes, _wl_block3);
if(mode.equals("modify")){
            _bw.write(_wl_block333Bytes, _wl_block333);
}
            _bw.write(_wl_block3Bytes, _wl_block3);
if(modal_yn.equals("Y") && !mode.equals("modify")){
            _bw.write(_wl_block334Bytes, _wl_block334);
}
            _bw.write(_wl_block335Bytes, _wl_block335);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.UpdateDiagnosisProfile.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CurrentDiagnosisProfile.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.UpdateDiagnosisProfile.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisSet.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Link.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisStage.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EncounterStage.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Intermediate.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discharge.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Intermediate.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discharge.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Classification.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Link.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.POA.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.LinkDiagCodeToPriSecDiagClass.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisCategory.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChiefComplaint.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TypesofNotification.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Notifiable.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.WorkRelated.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Nature.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accuracy.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Moderate.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Moderate.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mild.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severe.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Extreme.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.OnsetType.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Acute.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Chronic.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.since.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.active.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Resolved.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Revoked.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InError.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ason.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IncludeinCurrentEncounter.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AnatomicalSite.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.OralCavity.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.LinkCondition.Label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicableSide.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Left.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Right.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Both.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisRemarks.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }
}
