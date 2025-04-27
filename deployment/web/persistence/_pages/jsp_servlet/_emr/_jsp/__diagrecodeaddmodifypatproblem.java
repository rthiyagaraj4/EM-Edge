package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __diagrecodeaddmodifypatproblem extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagRecodeaddModifyPatProblem.jsp", 1743670541089L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"> \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<!--<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></SCRIPT>-->\n<script src=\'../js/DiagRecodePatProblem.js\' language=\'javascript\'></SCRIPT>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<!--<script src=\'../../eMR/js/DiagRecodeDatevalidation.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eMR/js/DiagRecodePathighrisk.js\' language=\'javascript\'></SCRIPT>-->\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<script>\n\n\nfunction openPatientChart(Patient_Id)\n{\n\n\tvar dialogHeight= \"13\" ;\n\tvar dialogWidth = \"40\" ;\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\tvar arguments   = \"\" ;\n\tretVal = window.open(\"../../eCA/jsp/OpenChartWrapper.jsp?Patient_Id=\"+document.forms[0].patient_id,arguments,features);\n}\n\n\nvar scheme=\"\"\n\nasync function showdetails(srl_no,Patient_Id)\n{\n\tvar dialogHeight= \"13vh\" ;\n\tvar dialogWidth = \"40vw\" ;\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\tvar arguments   = \"\" ;\n\tretVal =await  window.showModalDialog(\"../../eMR/jsp/DiagRecodePatProblemShowdetails.jsp?Patient_Id=\"+Patient_Id+\"&srl_no=\"+srl_no,arguments,features);\n\n}\n\n\n/*function show_window()\n{\n\tvar dob = document.RecDaignosis_form.dob.value;\n\tvar age = document.RecDaignosis_form.age.value;\n\tvar sex = document.RecDaignosis_form.sex.value;\n\tvar searchtext = document.RecDaignosis_form.diagprob_code.value;\n\tvar practitioner_id = document.RecDaignosis_form.Practitioner_Id.value;\n\tvar term_set_id = document.RecDaignosis_form.code_set.value;\n\tvar Encounter_Id = document.RecDaignosis_form.Encounter_Id.value;\n\tvar speciality_code = document.RecDaignosis_form.speciality_code.value;\n\n\tvar p_auth_yn = \"N\";\n\tvar retVal =    new String();\n\tvar dialogHeight= \"27.22\" ;\n\tvar dialogWidth = \"44\" ;\n\tvar status = \"no\";\n\tvar arguments = \"\";\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\n\tretVal = window.showModalDialog(\"TermCodeSearchMainFrame.jsp?speciality_code=\"+speciality_code+\"&term_set_id=\"+term_set_id+\"&practitioner_id=\"+practitioner_id+\"&termsetid=\"+term_set_id+\"&Dob=\"+dob+\"&Age=\"+age+\"&Sex=\"+sex+\"&Encounter_Id=\"+Encounter_Id,arguments,features);\n\n\tif(retVal != null)\n\t{\n\t\tvar arr = new Array();\n\t\tretcode = retVal.split(\"/\");\n\t\tdocument.RecDaignosis_form.diagprob_code.value = retcode;\n\t\tdocument.RecDaignosis_form.diagprob_code.onblur();\n\t}\n}*/\n\n\nasync function show_window(scheme,scheme_desc)\n{\n\tvar s = document.PatProblem_form.scheme.value;\n\tvar practitioner_id = document.PatProblem_form.Practitioner_Id.value;\n\tscheme_desc= document.PatProblem_form.scheme_desc.value; \n\tvar Encounter_Id= document.PatProblem_form.Encounter_Id.value ;\n\tvar  p_auth_yn=\"N\";\n\n\tvar age = document.PatProblem_form.age.value;\n\tvar sex = document.PatProblem_form.sex.value;\n\tvar dob = document.PatProblem_form.dob.value;\n\n\tif(parent.PatProblemQueryTools.document.forms[0].authorize!=null)\n\t{\n\t   if(parent.PatProblemQueryTools.document.forms[0].authorize.value==\"Normal Mode\")\n\t\t\t\tp_auth_yn=\'Y\';\n\t}\n\n\tif (s == 5)\n\t{\n\t\tvar retVal = \"test Value\";\n\t\tvar dialogHeight= \"28vh\" ;\n\t\tvar dialogWidth = \"43vw\" ;\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\tvar arguments   = \"\" ;\n\t\tretVal = await window.showModalDialog(\"../../eCA/html/eCISLUE.html\",arguments,features);\n\n\t\t\tvar arr = new Array();\n\t\t\tarr = retVal.split(\"|\");\n\t\t\tvar stra = arr[0];\n\t\t\tvar strc = arr[1];\n\t\t\tvar strb = arr[2];\n\n\tdocument.PatProblem_form.code.value         = stra;\n\tdocument.PatProblem_form.Description1.value = strb;\n\tdocument.PatProblem_form.Description.value  = strb;\n\tdocument.PatProblem_form.term_id.value      = strc;\n\n\t}\n\tif (s == 1 || s == 2)\n\t{\n\t\tvar retVal =    new String();\n\t\tvar dialogHeight= \"27.22vh\" ;\n\t\tvar dialogWidth = \"44vw\" ;\n\t\tvar status = \"no\";\n\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\n\t\tvar cause_ind=\'\';\n\t\tif(scheme==\"2\")\n\t\t cause_ind=document.forms[0].cause_ind.value\n\t\t\n\t\t//retVal = window.showModalDialog(\"PaintConsultationFrame.jsp?title=\"+scheme_desc+\"Code List&p_diag_code=\"+s+\"&p_diag_scheme_desc=\"+scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&p_auth_yn=\"+p_auth_yn+\"&cause_indicator=&Age=\"+age+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&practitioner_id=\"+practitioner_id+\"&term_set_id=\"+scheme_desc+\"&mode=DiagSearch\",arguments,features);\n\n\t\tretVal =await window.showModalDialog(\"TermCodeSearchMainFrame.jsp?term_set_id=\"+scheme_desc+\"&practitioner_id=\"+practitioner_id+\"&termsetid=\"+scheme_desc+\"&Dob=\"+dob+\"&Age=\"+age+\"&Sex=\"+sex+\"&Encounter_Id=\"+Encounter_Id,arguments,features);\n\n\t\t\n\t\tif (!(retVal == null))\n\t\t{\n\t\t\tvar retdata;\n\t\t\tif(scheme==\"2\")\n\t\t\t{\n\t\t\t retdata=retVal.split(\"/\") ;\n\t\t\tretVal=retdata[0];\n\n\t\t\tif(retdata[1]==document.forms[0].cause_ind.options[1].value)\n\t\t\t\t\tdocument.forms[0].cause_ind.options[1].selected=true;\n\t\t\t}\n\t\t\tdocument.PatProblem_form.code.value=retVal;\n\t\t}\n\t\t\tdocument.PatProblem_form.code.focus();\n\t\t\tdocument.PatProblem_form.remarks.focus();\n\t\t\tdocument.PatProblem_form.AddAssociateCodes.disabled=true;\n\t}\n\n}\n\n</script>\n\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"callDesc(document.forms[0].code)\">\n<BR><BR>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script>\n\nfunction callDesc(Obj)\n{\t\n\tif(Obj.value == \"\")\n\t{\n\t\tdocument.PatProblem_form.LongDescription.value=\"\";\n\t\tdocument.PatProblem_form.Description1.value=\"\";\n\t\tdocument.PatProblem_form.Description.value=\"\";\t\t\n\t}\n\tif(makeValidString(Obj)==false)\n\treturn false;\n\n\tvar sex = document.PatProblem_form.sex.value;\n\tvar dob = document.PatProblem_form.dob.value;\n\n\tvar function_name =  document.forms[0].function_name.value;\n\tvar called_from_ip =  document.forms[0].called_from_ip.value;\n\tvar modal_yn = document.forms[0].modal_yn.value;\n\t//var code_set =  document.forms[0].code_set.value;\n\t\n\n\n\n\tif(function_name==\"modify\")\n\t{\n\t\treturn false;\n\t}\n\t var pq = document.PatProblem_form.scheme.value;\n    var stagecode = document.PatProblem_form.stage_code.value;\n    if (pq == 1 || pq == 2)\n    {\n        var p_diag_code = Obj.value;\n        var indicator= \"\";\n        if(scheme==\'2\')\n            indicator = document.forms[0].cause_ind.value;\n\t\t\n        var p_scheme  = ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";\n        var sensitive=\'N\';\n\n\t\tvar authorizeButton=parent.PatProblemQueryTools.document.forms[0].authorizeButton.value;\n        if(parent.PatProblemQueryTools.document.forms[0].authorize!=null)\n        {\n           if(parent.PatProblemQueryTools.document.forms[0].authorize.value==\"Normal Mode\")\n                sensitive=\'Y\';\n        }\n\n\t\t\n        htmlVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eMR/jsp/DiagRecodePatProblemVal.jsp\'><input type=\'hidden\' name=\'p_stage_code\' id=\'p_stage_code\' value=\'\"+stagecode+\"\'><input type=\'hidden\' name=\'p_diag_code\' id=\'p_diag_code\' value=\'\"+p_diag_code+\"\'><input type=\'hidden\' name=\'p_scheme\' id=\'p_scheme\' value=\'\"+p_scheme+\"\'><input type=\'hidden\' name=\'p_cause_indicator\' id=\'p_cause_indicator\' value=\'\"+indicator+\"\'><input type=\'hidden\' name=\'p_sensitive_yn\' id=\'p_sensitive_yn\' value=\'\"+sensitive+\"\'><input type=\'hidden\' name=\'authorizeButton\' id=\'authorizeButton\' value=\'\"+authorizeButton+\"\'><input type=\'hidden\' name=\'Sex\' id=\'Sex\' value=\'\"+sex+\"\'><input type=\'hidden\' name=\'Dob\' id=\'Dob\' value=\'\"+dob+\"\'><input type=\'hidden\' name=\'code_set\' id=\'code_set\' value=\'ICD10\'><input type=\'hidden\' name= \'associate_codes\' value=\'\" + document.PatProblem_form.associate_codes.value + \"\'></form></body></html>\";\n\n\t\tif(called_from_ip == \"Y\" || modal_yn == \"Y\" || \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' == \"Y\")\n\t\t{ //new check added on 5th may 2004\n\n\t\t\t\n\t\t\tparent.messageFrame.document.write(htmlVal);\n\t\t\tparent.messageFrame.document.form1.submit();\n\n\t\t\t\n\t        //parent.msgframe0.document.body.insertAdjacentHTML(\'afterbegin\',htmlVal);\n\t\t    //parent.msgframe0.document.form1.submit();\n\t\t}\n\t\telse\n\t\t{\n\t        //top.content.workAreaFrame.support.document.body.insertAdjacentHTML(\'afterbegin\',htmlVal);\n\t\t    //top.content.workAreaFrame.support.document.form1.submit();\n\t\t}\n    }\n\n}\n\n  function change_chkbox(Obj)\n    {\n        if (Obj.checked == true)\n        {\n            document.PatProblem_form.primary_yn.value=\"Y\";\n        }\n        else if (Obj.checked == false)\n                document.PatProblem_form.primary_yn.value=\"N\";\n    }\n\t\n\tfunction callOnClickSignificant(Obj)\n    {\n\t\tif (Obj.checked == true)\n\t\t\tdocument.PatProblem_form.significant_yn.value=\"Y\";\n\t\telse if (Obj.checked == false)\n\t\t\tdocument.PatProblem_form.significant_yn.value=\"N\";\n    }\n\n\tfunction callAuthorize(Obj,pract_id,pract_name){\n\t\tif (Obj.checked == true){\n\t\t\tdocument.PatProblem_form.authorizeCheck.value=\"Y\";\n\t\t\tdocument.PatProblem_form.authorizepract.disabled=false;\n\t\t\tdocument.PatProblem_form.authorizepractbtn.disabled=false;\n\t\t\tdocument.PatProblem_form.authorizepract.value=decodeURIComponent(pract_name);\n\t\t\tdocument.PatProblem_form.authorizepractid.value=pract_id;\n\t\t}\n\t\telse if (Obj.checked == false){\n\t\t\tdocument.PatProblem_form.authorizeCheck.value=\"N\";\n\t\t\tdocument.PatProblem_form.authorizepract.disabled=true;\n\t\t\tdocument.PatProblem_form.authorizepractbtn.disabled=true;\n\t\t\tdocument.PatProblem_form.authorizepract.value=\"\";\n\t\t\tdocument.PatProblem_form.authorizepractid.value=\"\";\n\t\t}\n\n\t}\n\n\tfunction chkAuthorize(Obj, code_indicator)\n    {\n\t\tvar QueryString= document.getElementById(\"QueryString\").value;\n\t\tvar called_from_ip =  parent.addModifyPatProblem.document.forms[0].called_from_ip.value;\n\t\t\n\t\tif (Obj.value == \'Authorize Mode\')\n\t\t{\n\t\t\n\t\t\tparent.support.location.href=\"../../eMR/jsp/AuthorizeRecode.jsp?stage_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&stage_desc=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&Context=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Access_Type=E&Context=PatientQueue&Access_Data=SD&Patient_Id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&Practitioner_Id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&jsp_name=DiagRecodePatProblemQueryResult.jsp&Encounter_Id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&Patient_Type=C&Fn_Name=Ass&Clinic_Code=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&Location_Type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&significant_yn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&patient_class=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&called_from_ip=Y&QueryString=\" + escape(QueryString) + \"&Sex=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&Dob=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&code_indicator=\" + code_indicator + \"&associate_codes=\" + escape(document.PatProblem_form.associate_codes.value)+\"&practitioner_type=&modal_yn=\"+document.PatProblem_form.modal_yn.value;\n\n\t\t}\n\t\telse if (Obj.value == \'Normal Mode\')\n\t\t{\n\t\t\tparent.PatProblemQueryResult.location.href=\"../../eMR/jsp/DiagRecodePatProblemQueryResult.jsp?Encounter_Id=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&Locn_Code=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&Patient_Id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&Locn_Type=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&f_authorize_yn=N&significant_yn=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&called_from_ip=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&Sex=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&code_indicator=\" + code_indicator;\n                     \n\t\t\t//parent.addModifyPatProblem.location.href=\"../../eMR/jsp/DiagRecodeaddModifyPatProblem.jsp?Logical_Seq=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&stage_code=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&Encounter_Id=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&P_context=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&code_indicator=\" + code_indicator;\n\n\t\t\tparent.PatProblemQueryTools.document.forms[0].authorize.value=\'Authorize Mode\';\n\t\t\n        }\n    }\nasync function showLongDescription()\n{\n\tvar dialogHeight= \"20vh\" ;\n    var dialogWidth = \"23vw\" ;\n\tvar a = document.forms[0].LongDescription.value;\n\t\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\";\n\tawait window.showModalDialog(\"../../eMR/jsp/DiagRecodePatProblemDialogLongDesc.jsp?longDesc=\"+a,\"\",features);\n}\nfunction changeList(Obj)\n{\n    var obj_val = Obj.value;\n    var diagtype = document.forms[0].diag_type.value;\n    var remarks = document.forms[0].remarks.value;\n\tvar significant_yn = document.forms[0].significant.value;\n\tvar primary_yn\t\t=\tdocument.forms[0].primary.value;\n\tif(significant_yn.checked==true) significant_yn = \"Y\";\n\telse significant_yn = \"N\";\n\n\tif(primary_yn.checked==true) primary_yn = \"Y\";\n\telse primary_yn = \"N\";\n\n\tvar dat=\tdocument.getElementById(\"currentdate\").value;\n\n\tif(document.getElementById(\"problem_status\").value == (\"C\"))\n\t{\t\n\t\tdocument.getElementById(\"close\").readOnly = false ;\n\n\t\tdocument.forms[0].b_days1.disabled=false;\n\t\tdocument.forms[0].\tb_months1.disabled=false;\n\t\tdocument.forms[0].\tb_age1.disabled=false;\n\t\tdocument.getElementById(\"img1\").disabled=false;\n\t\tdocument.forms[0].\tclose.disabled=false;\n\n\t\tdocument.getElementById(\"close\").value=dat;\n\t\tdocument.getElementById(\"ServerDate1\").value=dat;\n\t\tdocument.getElementById(\"close_date\").value=dat;\n\n\t}else{\n\n\t\tdocument.getElementById(\"close\").value=\'\';\n\t\tdocument.getElementById(\"ServerDate1\").value=\'\';\n\t\tdocument.getElementById(\"close_date\").value=\'\';\n\n\t\tdocument.forms[0].b_days1.disabled=\'\';\n\t\tdocument.forms[0].\tb_months1.disabled=\'\';\n\t\tdocument.forms[0].\tb_age1.disabled=\'\';\n\n\t\tdocument.forms[0].b_days1.disabled=true;\n\t\tdocument.forms[0].\tb_months1.disabled=true;\n\t\tdocument.forms[0].\tb_age1.disabled=true;\n\t\tdocument.getElementById(\"img1\").disabled=true;\n\t\tdocument.forms[0].\tclose.disabled=true;\n\n\t\tdocument.getElementById(\"close\").value = \"\" ;\n\t\tdocument.getElementById(\"close\").readOnly = true ;\n\t}\n\n}\nfunction decider()\n{\n\t\n\tcode_indicator = document.PatProblem_form.code_indicator.value;\n\t\n\tif(code_indicator == \'C\')\n\t\taddAssociateCodes();\n\telse if(code_indicator == \'D\')\n\t\taddAssociateCodes1();\n}\nasync function addAssociateCodes()\n{\n\t\n\tcode_indicator = document.PatProblem_form.code_indicator.value;\n\tif(code_indicator == \'C\')\n\t\t\tcode_indicator = \'E\';\n\telse\n\tif(code_indicator == \'D\')\n\t\t\tcode_indicator = \'A\';\n\t\n\tdiag_desc = document.PatProblem_form.Description1.value;\n\tp_scheme = \'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\';\n\tassociate_codes = document.PatProblem_form.associate_codes.value;\n\tdiag_code = document.PatProblem_form.code.value;\n\t\n\tvar retVal\t\t\t\t= \"\";\n\t//var dialogHeight\t\t= \"15\" ;\n\t//modified on 10-06-08 for ICN NO 4284\n\tvar dialogHeight\t\t= \"20\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\n\tvar scheme_desc= document.PatProblem_form.scheme_desc.value; \n\tvar Encounter_Id= document.PatProblem_form.Encounter_Id.value ;\n\tvar p_auth_yn=\"N\";\n    var s = document.PatProblem_form.scheme.value;\n\tvar age = document.PatProblem_form.age.value;\n\tvar sex = document.PatProblem_form.sex.value;\n\tvar dob = document.PatProblem_form.dob.value;\n\tvar patient_id = document.PatProblem_form.patient_id.value;\n\n\t\n//\tvar con = confirm(\"Do you want to associate codes to this diagnosis?\\nPress OK to continue...\");\n//\tif(con)\n/***************************************************************************/\n\t//{\n\t\tvar arguments\t\t\t= \"\" ;\n\t\t//var qs1 = \"code_indicator=\" + code_indicator + \"&diag_desc=\" + diag_desc + \"&title=\"+scheme_desc+\" Code List&p_diag_code=\"+s+\"&p_diag_scheme_desc=\"+scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&p_auth_yn=\"+p_auth_yn+\"&cause_indicator=&Age=\" + age + \"&Sex=\" + sex + \"&Dob=\" + dob + \"&p_scheme=\" +  p_scheme +\"&diag_code=\"+diag_code+\"&associate_codes=\" + associate_codes;\n\n\t\t//retVal = window.showModalDialog(\"../../eCA/jsp/AddAssociateCodeFrames.jsp?\" + qs1,arguments,features);\n\n\n\t\tvar qs1 = \'diag_code=\'+diag_code+\'&diag_desc=\'+diag_desc+\'&associate_codes=\'+associate_codes+\'&term_set_id=\'+scheme_desc+\'&Dob=\'+dob+\'&Age=\'+age+\'&Sex=\'+sex+\'&Patient_Id=\'+patient_id+\'&term_code=\'+diag_code+\'&occur_srl_no=\';\t\t\n\n\t\tretVal = await window.showModalDialog(\"../../eMR/jsp/AddAssociateCodeFrames.jsp?\" + qs1,arguments,features);\n\n\t\tif(retVal != null)\n\t\t\tdocument.PatProblem_form.associate_codes.value = retVal;\n\t\t/*else\n\t\t\tdocument.PatProblem_form.associate_codes.value = \"\";*/\n\t\t//return retVal;\n\t//}\n/***************************************************************************/\n}\nasync function addAssociateCodes1()\n{\n\tvar code_indicator = document.PatProblem_form.code_indicator.value;\n\tif(code_indicator == \'C\')\n\t\t\tcode_indicator = \'E\';\n\telse\n\t\tif(code_indicator == \'D\')\n\t\t\tcode_indicator = \'A\';\n\t\n\tvar diag_desc = document.PatProblem_form.Description1.value;\n\tvar p_scheme = \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\n\tvar associate_codes = document.PatProblem_form.associate_codes.value;\n\tvar diag_code = document.PatProblem_form.code.value;\n\t\n\tvar retVal\t\t\t\t= \"\";\n\t//var dialogTop\t\t\t= \"0\";\n\tvar dialogHeight\t\t= \"15vh\" ;\n\tvar dialogWidth\t\t\t= \"40vw\" ;\n\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\n\tvar scheme_desc= document.PatProblem_form.scheme_desc.value; \n\tvar Encounter_Id= document.PatProblem_form.Encounter_Id.value ;\n\tvar p_auth_yn=\"N\";\n    var s = document.PatProblem_form.scheme.value;\n\tvar age = document.PatProblem_form.age.value;\n\tvar sex = document.PatProblem_form.sex.value;\n\tvar dob = document.PatProblem_form.dob.value;\n\tvar patient_id = document.PatProblem_form.patient_id.value;\n\t\n\t\n//\tvar con = confirm(\"Do you want to associate codes to this diagnosis?\\nPress OK to continue...\");\n//\tif(con)\n\t//{\n\t\tvar arguments\t\t\t= \"\" ;\n\t\t//var qs1 = \"code_indicator=\" + code_indicator + \"&diag_desc=\" + diag_desc + \"&title=\"+scheme_desc+\" Code List&p_diag_code=\"+s+\"&p_diag_scheme_desc=\"+scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&p_auth_yn=\"+p_auth_yn+\"&cause_indicator=&Age=\" + age + \"&Sex=\" + sex + \"&Dob=\" + dob + \"&p_scheme=\" +  p_scheme +\"&diag_code=\"+diag_code+\"&associate_codes=\"+associate_codes;\n\n\t\n\n\t\t//retVal = window.showModalDialog(\"../../eCA/jsp/AddDaggerCodeFrames.jsp?\" + qs1,arguments,features);\n\t\t\t\n\t\tvar qs1 = \'diag_code=\'+diag_code+\'&diag_desc=\'+diag_desc+\'&associate_codes=\'+associate_codes+\'&term_set_id=\'+scheme_desc+\'&Dob=\'+dob+\'&Age=\'+age+\'&Sex=\'+sex+\'&Patient_Id=\'+patient_id+\'&term_code=\'+diag_code+\'&occur_srl_no=\';\n\n\t\tretVal = await window.showModalDialog(\"../../eMR/jsp/AddDaggerCodeFrames.jsp?\" + qs1,arguments,features);\n\t\tif(retVal != null )\n\t\t\tdocument.PatProblem_form.associate_codes.value = retVal;\n\t\t/*else\n\t\t\tdocument.PatProblem_form.associate_codes.value = \"\";*/\n\n\t\t//return retVal;\n\t//}\n}\n</script>\n<form name=\"PatProblem_form\" id=\"PatProblem_form\"  action=\"../../servlet/eMR.DiagnosisRecodeServlet?&encounter_id=\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&facility_id=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \" method=\"post\" target=\"messageFrame\">\n \n<div align=\'center\'>\n<table border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"90%\">\n<tr>\t\t\n\t<th align=\'left\' colspan=\'3\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" &nbsp;</th><th id=disMar align=right colspan=3></th>\n</tr>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t<tr>\n\t\t<td   align=\"right\" class=\'label\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&nbsp;</td>\n\t\t<td><input type=\"text\"  name=\"code\" id=\"code\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" size=\'10\' maxlength=\'10\' onblur=\'ChangeUpperCase(this);callDesc(this)\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" onchange=\"document.PatProblem_form.associate_codes.value = \'\';\" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img><input type=\"button\" name=\"AddAssociateCodes\" id=\"AddAssociateCodes\" value = \'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' onclick = \"decider()\"  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="  class=\"button\"  id=\'AddCodesBtn\'></td>\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;</td>\n\t\t\t<td><select name=\'cause_ind\' id=\'cause_ind\' onchange=\"callDesc(code)\"  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">\n\t\t\t\t\t\t<option\t value=\'\'>-----";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="-----</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t<option value=\'E\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</option>\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<td  align=\"left\" class=\'label\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&nbsp;<input type=\"button\" class=\'Button\' name=\"search_button\" id=\"search_button\" title=\'Search\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'  onClick=\"document.forms[0].code.value=\'\';\n\t\tshow_window(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" ></td>\n\t</tr>\n\t<tr>\n\t\t<td align=\"right\" class=\'label\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;</td>\n\t\t<td colspan=3><input type=\"text\"  name=\"Description1\" id=\"Description1\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" size=50 readonly>&nbsp;&nbsp;&nbsp;<input class=\"button\" type=\"button\" value=\"!\" name = \"exclamation\" onclick = \"javascript:showLongDescription();\" style=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" ><input type=\"hidden\"  name = \"Description\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><input type=\"hidden\"  name = \"LongDescription\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"></td>\n\t\t<td><input type=\"button\" class=\'Button\' name=\"ntf_button\" id=\"ntf_button\"  value=\"Record Notifiable Form\" onClick=\"callNotifiableNotes()\" style=\'display:none\'><!-- <a onclick=\"openPatientChart()\" >patient chart</a> --></td>\n\t</tr>\n\t<tr>\n\t\t<td align=\'right\' class=\'label\' valign=\'top\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;</td>\n\t\t<td colspan=\'3\' class=\'fields\'><textarea name=\"remarks\" rows=\"3\" cols=\"60\" maxlength=\'200\' onKeyPress=\'checkMaxLimit(this,200);\' onBlur=\"makeValidString(this);chkRemarkLength(this,200);\" readonly >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</textarea></td>\n\t\t<td colspan=1></td>\n\t</tr>\n</table>\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n    <input type=\"hidden\"  name=\"db_date\" id=\"db_date\"            value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n    <input type=\"hidden\"  name=\"diag_srl_no\" id=\"diag_srl_no\"        value=\"\">\n    <input type=\"hidden\"  name=\"record_type\" id=\"record_type\"        value=\"\">\n    <input type=\"hidden\"  name=\"cause_indicator\" id=\"cause_indicator\"    value=\"\">\n    <input type=\"hidden\"  name=\"tab_list_no\" id=\"tab_list_no\"        value=\"\">\n    <input type=\"hidden\"  name=\"analysis_code\" id=\"analysis_code\"      value=\"\">\n    <input type=\"hidden\"  name=\"notifiable_yn\" id=\"notifiable_yn\"      value=\"\">\n    <input type=\"hidden\"  name=\"sensitive_yn\" id=\"sensitive_yn\"       value=\"\">\n    <input type=\"hidden\"  name=\"primary_yn\" id=\"primary_yn\"         value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n    <input type=\"hidden\"  name=\"significant_yn\" id=\"significant_yn\"     value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n    <input type=\"hidden\"  name=\"srl_no_from_table\" id=\"srl_no_from_table\"  value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n    <input type=\"hidden\"  name=\"term_id\" id=\"term_id\"            value=\"\">\n    <input type=\"hidden\"  name=\"Sec_Hdg_Code\" id=\"Sec_Hdg_Code\"       value=\"\">\n    <input type=\"hidden\"  name=\"associate_codes\" id=\"associate_codes\"    value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n    <input type=\"hidden\"  name=\"code_indicator\" id=\"code_indicator\"     value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n    <input type=\"hidden\"  name=\"diag_code\" id=\"diag_code\"     value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n  <input type=\"hidden\"  name=\"retVal_auth\" id=\"retVal_auth\"     value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n    <input type=\"hidden\"  name=\"db_date\" id=\"db_date\"            value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n    <input type=\"hidden\"  name=\"diag_srl_no\" id=\"diag_srl_no\"        value=\"\">\n    <input type=\"hidden\"  name=\"record_type\" id=\"record_type\"        value=\"R\">\n    <input type=\"hidden\"  name=\"cause_indicator\" id=\"cause_indicator\"    value=\"\">\n    <input type=\"hidden\"  name=\"tab_list_no\" id=\"tab_list_no\"        value=\"\">\n    <input type=\"hidden\"  name=\"analysis_code\" id=\"analysis_code\"      value=\"\">\n    <input type=\"hidden\"  name=\"notifiable_yn\" id=\"notifiable_yn\"      value=\"N\">\n    <input type=\"hidden\"  name=\"sensitive_yn\" id=\"sensitive_yn\"       value=\"N\">\n    <input type=\"hidden\"  name=\"primary_yn\" id=\"primary_yn\"         value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >\n    <input type=\"hidden\"  name=\"term_id\" id=\"term_id\"            value=\"\">\n    <input type=\"hidden\"  name=\"Sec_Hdg_Code\" id=\"Sec_Hdg_Code\"       value=\"\">\n\t<input type=\"hidden\"  name=\"code_indicator\" id=\"code_indicator\"     value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n    <input type=\"hidden\"  name=\"retVal_auth\" id=\"retVal_auth\"     value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n    <input type=\"hidden\"  name=\"associate_codes\" id=\"associate_codes\"    value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\n</table>\n</div>\n<input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n<input type=\'hidden\' name=\'text7\' id=\'text7\' value=\'\'>\n<input type=\'hidden\' name=\'text8\' id=\'text8\' value=\'\'>\n<input type=\'hidden\' name=\'text9\' id=\'text9\' value=\'\'>\n<input type=\"hidden\"  name=\"Practitioner_Id\" id=\"Practitioner_Id\"  value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n<input type=\'hidden\'  name=\'scheme_desc\' id=\'scheme_desc\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'></td></tr>\n<input type=\'hidden\' name=\'function\' id=\'function\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\'hidden\' name=\'Invoking_Function\' id=\'Invoking_Function\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n<input type=\'hidden\' name=\'currentdate\' id=\'currentdate\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<input type=\'hidden\' name=\'current_date\' id=\'current_date\' value=\'\'>\n<input type=\'hidden\' name=\'context\' id=\'context\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n<input type=\'hidden\' name=\'stage_code\' id=\'stage_code\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n<input type=\'hidden\' name=\'stage_desc\' id=\'stage_desc\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n<input type=\'hidden\' name=\'logical_seq_no\' id=\'logical_seq_no\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n<input type=\'hidden\' name=\'QueryString\' id=\'QueryString\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<input type=\'hidden\' name=\'called_from_ip\' id=\'called_from_ip\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n<input type=\'hidden\' name=\'calledFromDeathReg\' id=\'calledFromDeathReg\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n<input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<input type=\'hidden\' name=\'diag_code_scheme\' id=\'diag_code_scheme\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\'hidden\' name=\'record_type\' id=\'record_type\' value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type=\'hidden\' name=\'cause_ind\' id=\'cause_ind\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type=\'hidden\' name=\'age\' id=\'age\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=\'hidden\' name=\'sex\' id=\'sex\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<input type=\"hidden\"  name=\"scheme\" id=\"scheme\"             value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n<input type=\"hidden\"  name=\"p_authorize\" id=\"p_authorize\"            value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\n<!-- parameters for the notes function -->\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n<input type=\'hidden\' name=\'visit_adm_date\' id=\'visit_adm_date\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n<input type=\'hidden\' name=\'diagstage\' id=\'diagstage\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n<input type=\'hidden\' name=\'diag_type\' id=\'diag_type\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n<input type=\"hidden\" name=\"Encounter_Id\" id=\"Encounter_Id\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n<input type=\"hidden\" name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'RECORD_DIAGNOSIS\'>\n<input type=hidden name=errorRemarks value=\'\'>\n<input type=\"hidden\" name=\'include_enc\' id=\'include_enc\' value=\'Y\'></input>\n<input type=\"hidden\" name=\'fromFinalize\' id=\'fromFinalize\' value=\'\'></input>\n<input type=\'hidden\' name=\'trn_srl_no\' id=\'trn_srl_no\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\n<!-- <input type=hidden name=currentdate value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'> -->\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );
	
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
            _bw.write(_wl_block6Bytes, _wl_block6);

 request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request);
 response.addHeader("X-XSS-Protection", "1; mode=block");
 response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

    String scheme_desc  ="";
    String scheme="";
	String flagAut="";
	String disAut="";
	String autAut="N";
	String disAutPract="";
	String disReviewPract ="";
	String record_type ="";
	String diag_code_scheme ="";
	String calledFromDeathReg = checkForNull(request.getParameter("calledFromDeathReg"));
	if(calledFromDeathReg.equals("")) calledFromDeathReg = "N";


            _bw.write(_wl_block9Bytes, _wl_block9);

    Connection con          = null; 
	StringBuffer sqlStrBufr=new StringBuffer();
    //java.util.Properties p  =(java.util.Properties) session.getValue( "jdbc" );
    SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
    String currentdate      = dateFormat.format(new java.util.Date()) ;
    String facilityId       = checkForNull((String) session.getValue( "facility_id" ));
	String Encounter_Id     = request.getParameter("Encounter_Id");	 
	String diag_code= "";
	String dup_diag_code="";
	String modal_yn			= checkForNull(request.getParameter("modal_yn"));
	String srl_no           = request.getParameter("srl_no");
    String Patient_Id       = checkForNull(request.getParameter("Patient_Id"));
	String patient_class    = checkForNull(request.getParameter("patient_class"));
	String called_from_ip   = checkForNull(request.getParameter("called_from_ip"));	
	String retVal_auth		=checkForNull(request.getParameter("retVal_auth"));
	String associate_codes  =checkForNull(request.getParameter("associate_codes"));
	String code_indicator   =checkForNull(request.getParameter("code_indicator"));

//	String oper_num= checkForNull(request.getParameter("oper_num"));
//	String patLineYN = checkForNull(request.getParameter("patLineYN"));	
//	String encounter_clor	=checkForNull(request.getParameter("encounter_clor"));
	String age				= checkForNull(request.getParameter("Age"));	
	String dob				= checkForNull(request.getParameter("Dob"));	
	String sex				= checkForNull(request.getParameter("Sex"));
	
	
	if(called_from_ip == null || called_from_ip.equals("null") || called_from_ip.equals(""))called_from_ip="N";

	PreparedStatement pstmt		=null;
	PreparedStatement stmt		=null;
	PreparedStatement stmt_1    =null;
    ResultSet rs				=null;
    ResultSet rs_1				=null;

	String srl_no_from_table	="";
//  String diag_code			="";
    String diag_desc			="";
    String diag_long_desc		="";
    String primary_yn			="N";
    String primary_status		="";
    String onset_date			=currentdate;
    String close_date			="";
    String problem_status		="";
    String dis					="disabled";
    String dis_add_associate	="disabled";
	String reviewed_by_pract	  ="";     
	String reviewed_by_pract_name ="";     
	String authorized_yn          ="";
	String authorized_by_pract    ="";	

//    String id[] ={"","B","W","S","C"};
//    String val[]={"-- Select --","Better","Worse","Same","Close"};
    
    String read_only    ="";
    String read_onlycode    ="readonly";
    String data_state   ="insert";
    String db_date="";
    String sql=" select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date,(select PRACTITIONER_NAME from am_practitioner where practitioner_id=?) Recorded_by_pract_name from mr_parameter ";
    String check_box_value="N";
    String cause_ind="";

    String diagstage = "";
    String diagstagecode = "";
    String problemremarks = "";
    String diagtype = "";
 
	String significant_status = "", significant_yn = "N";
    String sel1 = "", sel2 ="", sel3 = "";    
	
	String accession_num = "",notifiable_yn="",visible="visibility:hidden",visibleexclamation="visibility:hidden";

   if (Encounter_Id ==null||Encounter_Id.equals(""))
		Encounter_Id="0";
	
	String Practitioner_Id   = "";
	String Practitioner ="";

	// added for displaying values from the authorixed screen
	String dsel1="",dsel2="",dsel3="";
			diagstage=checkForNull(request.getParameter("diag_stage"));
			diag_code=checkForNull(request.getParameter("diag_code"));

			dup_diag_code=diag_code;
			diagtype=checkForNull(request.getParameter("diagtype"));
			if(diagtype.equals("P")) sel1 = "selected";
			else if(diagtype.equals("D")) sel2 = "selected";
			else if(diagtype.equals("F")) sel3 = "selected";
			
			if(!diagstage.equals("")) 
			{
				if(diagstage.equals("A"))
				{
					dsel1="selected";
				}
				else if(diagstage.equals("I"))
				{
					dsel2="selected";
				}
				else if(diagstage.equals("D"))
				{
					dsel3="selected";
				}
			}

	if( called_from_ip.equals("Y") || calledFromDeathReg.equals("Y") || modal_yn.equals("Y") )
	{	
		Practitioner_Id			= request.getParameter("Practitioner_Id");
//		Practitioner			= request.getParameter("practitioner_name");

	}
	else
	{
		Practitioner_Id			= (String) session.getValue("ca_practitioner_id");
		Practitioner			= (String) session.getValue("practitioner_name");
	}
	
	if(Practitioner==null || Practitioner.equals("null"))
		Practitioner="";

	String trn_srl_no			=checkForNull(request.getParameter("trn_srl_no"));
	String Locn_Code			= request.getParameter("Locn_Code");
    String Locn_Type			= request.getParameter("Locn_Type");
    String f_authorize_yn		= request.getParameter("f_authorize_yn");
    //String chk_status			=checkForNull(request.getParameter("problem_status"));
    String invoking_function    =checkForNull(request.getParameter("Function"));
    
	String context				= request.getParameter("P_context");
	if (patient_class.equals("OP") || patient_class.equals("EM")||patient_class.equals("XT"))
		context  = "OP_Q";
	else
		context  = "IP_Q";

    String stagedesc		=checkForNull(request.getParameter("stage_desc"));
    String stagecode		=checkForNull(request.getParameter("stage_code"));
	//added for notes
	String visit_adm_date	=checkForNull(request.getParameter("visit_adm_date"));
	String episode_type		=checkForNull(request.getParameter("episode_type"));
	//-------
    String logicalseqno		=checkForNull(request.getParameter("Logical_Seq"));
    String diagtypeselected =checkForNull(request.getParameter("diag_type"));
    String remarksselected	=checkForNull(request.getParameter("remarks"));
	String QueryString		=checkForNull(request.getParameter("QueryString"));


	primary_yn			=	(request.getParameter("primary_yn")==null)?"N" : request.getParameter("primary_yn");
	significant_yn		=	(request.getParameter("significant_yn")==null)?"N" : request.getParameter("significant_yn");
	String sql_1		="";    

try
{
	con = ConnectionManager.getConnection(request);

		//added new by kishore on 5/30/2005
		if(modal_yn.equals("Y"))
		{
			read_only   = "readonly";
			
			if(!calledFromDeathReg.equals("Y"))
				dis = "disabled";
				dis_add_associate = "disabled";

		if(sqlStrBufr.length() > 0) sqlStrBufr.delete(0,sqlStrBufr.length());
		sqlStrBufr.append("select srl_no from pr_problem_vw  where patient_id = ? and ");
		sqlStrBufr.append("diag_code=? and problem_status!='C' ");
		
		pstmt = con.prepareStatement( sqlStrBufr.toString() ) ;
		pstmt.setString( 1, Patient_Id) ;
		pstmt.setString( 2, diag_code) ;
		
		rs = pstmt.executeQuery() ;
		while(rs.next())
		{
			srl_no=rs.getString("SRL_NO");
		}
			if(srl_no== null)
			{
				//mode="modify";
				//diag_code ="";
				sel3 = "selected";
			}
		}	
		//ended here
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

        pstmt=con.prepareStatement(sql);
		pstmt.setString(1,Practitioner_Id);
        rs=pstmt.executeQuery();
        
        if(rs.next())
        {
            scheme      = rs.getString("scheme");
            out.print("<script>scheme='"+scheme+"'</script>");
            scheme_desc = rs.getString("scheme_desc");
            db_date     = rs.getString("db_date");
			Practitioner= rs.getString("Recorded_by_pract_name")==null?"":rs.getString("Recorded_by_pract_name");
        }
        else
             out.print("<script>scheme=''</script>");
		if(retVal_auth.equals("T"))
	{
			read_only   = "readonly";
			read_onlycode="";
			dis="";
	}

    if  (srl_no != null)
    {
		read_only   = "readonly";
        data_state = "modify";
        dis = "disabled";
        //dis_add_associate = "";
        if(code_indicator.equals(null) || code_indicator.equals("null") || code_indicator.equals("") ){
				//dis_add_associate = "disabled";
		}
		else{
			//dis_add_associate = "";
		}
		sql_1 = "Select RECORD_TYPE, DIAG_CODE_SCHEME, srl_no,diag_code,diag_desc,primary_yn,to_char(onset_date,'dd/mm/yyyy') onset_date,to_char(close_date,'dd/mm/yyyy') close_date, problem_status, cause_indicator, ip_diag_stage, decode(ip_diag_stage,'I','Intermediate','A','Admission','D','Discharge') diag_stage_desc, problem_remarks, diag_type, significant_yn,accession_num,notifiable_yn,reviewed_by_pract, (select short_name from am_practitioner where practitioner_id=reviewed_by_pract) reviewed_by_pract_name, authorized_yn, authorized_by_pract, recorded_by_pract, (select short_name from am_practitioner where practitioner_id=recorded_by_pract) recorded_by_pract_name,(select long_desc from mr_icd_code where diag_code=pr_problem.diag_code and rownum=1 ) long_desc from pr_problem where patient_id = ? and srl_no = ? " ;

		stmt_1 = con.prepareStatement(sql_1);
		stmt_1.setString(1,Patient_Id);

		stmt_1.setString(2,srl_no);
        rs_1 = stmt_1.executeQuery();

        if (rs_1.next())
        {
            diag_code_scheme = rs_1.getString("DIAG_CODE_SCHEME"); 
            record_type = rs_1.getString("RECORD_TYPE"); 
			srl_no_from_table=  rs_1.getString("srl_no");
            diag_code   =   rs_1.getString("diag_code");
            diag_desc   =   rs_1.getString("diag_desc");
            diag_long_desc   =   rs_1.getString("long_desc");
            primary_yn  =   rs_1.getString("primary_yn");
            onset_date  =   rs_1.getString("onset_date");
            close_date  =   rs_1.getString("close_date");
            problem_status= rs_1.getString("problem_status");
            cause_ind=rs_1.getString("cause_indicator");
            diagstage = rs_1.getString("diag_stage_desc")==null?"":rs_1.getString("diag_stage_desc");
            diagstagecode = rs_1.getString("ip_diag_stage")==null?"":rs_1.getString("ip_diag_stage");
            problemremarks = rs_1.getString("problem_remarks")==null?"":rs_1.getString("problem_remarks");
            diagtype = rs_1.getString("diag_type")==null?"":rs_1.getString("diag_type");
			significant_yn	=	rs_1.getString("significant_yn")==null?"N":rs_1.getString("significant_yn");
			if(diag_code==null) diag_code = "";
			
			// added code

			reviewed_by_pract	=rs_1.getString("reviewed_by_pract")==null?"":rs_1.getString("reviewed_by_pract");
			if(!reviewed_by_pract.equals(""))
				disReviewPract ="disabled";
			else
				disReviewPract ="";

			authorized_yn     =rs_1.getString("authorized_yn")==null?"":rs_1.getString("authorized_yn"); 
			if(authorized_yn.equals("Y")){
				autAut ="Y";
				disAut = "disabled";
				disAutPract ="disabled";
				flagAut ="checked";
			}
			else{
				autAut = "N";
				disAut = "";
				disAutPract ="disabled";
				flagAut ="";
			}

			authorized_by_pract =rs_1.getString("authorized_by_pract")==null?"":rs_1.getString("authorized_by_pract");
			reviewed_by_pract_name = rs_1.getString("reviewed_by_pract_name")==null?"":rs_1.getString("reviewed_by_pract_name");			
			accession_num = rs_1.getString("accession_num")==null?"":rs_1.getString("accession_num");
			notifiable_yn = rs_1.getString("notifiable_yn")==null?"":rs_1.getString("notifiable_yn");
			if(notifiable_yn.equals("Y"))
				visible = "visibility:visible";
            
            if(!(diagtypeselected.equals("") || diagtypeselected.equals("null")))
                diagtype = diagtypeselected;
            if(!(remarksselected.equals("") || remarksselected.equals("null")))
                    problemremarks = remarksselected;

            if(diagtype.equals("P")) sel1 = "selected";
            else if(diagtype.equals("D")) sel2 = "selected";
            else if(diagtype.equals("F")) sel3 = "selected";

            if(cause_ind==null) cause_ind="";

            if (close_date == null) close_date = "";

            if (problem_status.equals("A")) problem_status="";

        }
    }
        if(rs_1!=null)  rs_1.close();
		if(stmt_1!=null) stmt_1.close();
		if(primary_yn.equals("Y")) primary_status="checked";
		if(significant_yn.equals("Y")) significant_status=" checked ";



            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(calledFromDeathReg));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(context));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(significant_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(significant_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(significant_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(context));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

	if(code_indicator == null || code_indicator.equals("null") || code_indicator.equals(""))
	{ 
		dis_add_associate = "disabled";
	}
	else
	{
		dis_add_associate = "";
	}

            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(read_onlycode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SupportingDiagnosis.label","common_labels")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dis_add_associate));
            _bw.write(_wl_block46Bytes, _wl_block46);

		if(scheme.equals("2"))
		{
			String sel="";
			
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

								if(cause_ind.equals("E"))
									sel="selected";
							
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

		}
		else
		{
			out.print("<td COLSPAN=2>&nbsp</td>");
		}
		
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(scheme_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(visibleexclamation));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(diag_long_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(problemremarks));
            _bw.write(_wl_block65Bytes, _wl_block65);

    if (scheme.equals("1") ||  scheme.equals("2"))
    {

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(db_date));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(significant_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(srl_no_from_table));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(java.net.URLEncoder.encode(associate_codes)));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(retVal_auth));
            _bw.write(_wl_block74Bytes, _wl_block74);

    }
    else
    {

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(db_date));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(srl_no_from_table));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(retVal_auth));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(java.net.URLEncoder.encode(associate_codes)));
            _bw.write(_wl_block74Bytes, _wl_block74);

    }

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(scheme_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(data_state));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(data_state));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(invoking_function));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(context));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(QueryString));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(calledFromDeathReg));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(record_type));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(cause_ind));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(age));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(diagstagecode));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(diagtype));
            _bw.write(_wl_block74Bytes, _wl_block74);

    //out.print("x_problem_status "+problem_status);
}catch (Exception e)
{
    out.print("Exception in addModifyPatProblem.jsp:"+sql_1+""+e.toString());
}
finally{
    if(rs!=null) rs.close();
	if(stmt != null) stmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(trn_srl_no));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block115Bytes, _wl_block115);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProblemAssessment.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseIndicator.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.external.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
