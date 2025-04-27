package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatproblem extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/addModifyPatProblem.jsp", 1743149771201L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"> \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../js/PatProblem.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../js/DateValidation.js\' language=\'javascript\'></SCRIPT> \n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script>\n\nvar scheme=\"\"\n\nfunction ShowPractitioner()\n{\n\tvar target\t\t\t= parent.addModifyPatProblem.document.forms[0].reviwedby;\n\tvar locale=parent.addModifyPatProblem.document.forms[0].locale.value;\n\tvar retVal\t\t\t=  new String();\n\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t\t= getLabel(\"Common.practitioner.label\",\"Common\");\n\n\tvar sql=\"SELECT practitioner_id,short_name  from am_practitioner_lang_Vw where eff_status=`E`  and language_id = `\"+locale+\"`\";\n\tsearch_code=\"practitioner_id\";\n\tsearch_desc=\"short_name\";\n\tretVal=window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(title,\"UTF-8\")+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\tvar arr=new Array();\n\t\n\tif (retVal != null && retVal != \'\' && retVal != \"null\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\t\tarr=retVal.split(\"::\");\n\t\tparent.addModifyPatProblem.document.forms[0].reviwedby.value=arr[0];\n\t\tparent.addModifyPatProblem.document.forms[0].reviwedbyid.value=arr[1];\n\t\tparent.addModifyPatProblem.document.forms[0].reviwedby.focus();\n\t}\n}\n\nasync function AuthorizePract()\n{\n\tvar target\t\t\t= parent.addModifyPatProblem.document.forms[0].authorizepract;\n\tvar locale=parent.addModifyPatProblem.document.forms[0].locale.value;\n\tvar retVal\t\t\t=  new String();\n\tvar dialogTop\t\t\t= \"40\";\n\tvar dialogHeight\t\t= \"10\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t= \"\";\n\tvar title\t\t\t= getLabel(\"Common.practitioner.label\",\"Common\");\n\t//var sql=\"SELECT practitioner_id,short_name from am_practitioner where eff_status=`E`\";\n\tvar sql=\"SELECT practitioner_id,short_name  from am_practitioner_lang_Vw where eff_status=`E`  and language_id = `\"+locale+\"`\";\n\t\n\tsearch_code=\"practitioner_id\";\n\tsearch_desc=\"short_name\";\n\tretVal =await  window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(title,\"UTF-8\")+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\tvar arr=new Array();\n\tif (retVal != null && retVal != \'\' && retVal != \"null\")\n\t{\n\t\tvar retVal=unescape(retVal);\n\t\tarr=retVal.split(\"::\");\n\t\tparent.addModifyPatProblem.document.forms[0].authorizepract.value=arr[0];\n\t\tparent.addModifyPatProblem.document.forms[0].authorizepractid.value=arr[1];\n\t\tparent.addModifyPatProblem.document.forms[0].authorizepract.focus();\n\t}\n}\nasync function showdetails(srl_no,Patient_Id)\n{\n\n\tvar dialogHeight= \"13\" ;\n\tvar dialogWidth = \"40\" ;\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\tvar arguments   = \"\" ;\n\tretVal =await window.showModalDialog(\"../../eCA/jsp/PatProblemShowdetails.jsp?Patient_Id=\"+Patient_Id+\"&srl_no=\"+srl_no,arguments,features);\n\n}\n\nasync function show_window(scheme,scheme_desc)\n{\n\tvar s = document.PatProblem_form.scheme.value;\n\tscheme_desc= document.PatProblem_form.scheme_desc.value; \n\tvar Encounter_Id= document.PatProblem_form.Encounter_Id.value ;\n\tvar  p_auth_yn=\"N\";\n\n\tvar age = document.PatProblem_form.age.value;\n\tvar sex = document.PatProblem_form.sex.value;\n\tvar dob = document.PatProblem_form.dob.value;\n\n\tif(parent.PatProblemQueryTools.document.forms[0].authorize!=null)\n\t{\n\t   if(parent.PatProblemQueryTools.document.forms[0].authorize.value==\"Normal Mode\")\n\t\t\t\tp_auth_yn=\'Y\';\n\t}\n\n\tif (s == 5)\n\t{\n\t\tvar retVal = \"test Value\";\n\t\tvar dialogHeight= \"28\" ;\n\t\tvar dialogWidth = \"83\" ;\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\tvar arguments   = \"\" ;\n\t\tretVal =await window.showModalDialog(\"../../eCA/html/eCISLUE.html\",arguments,features);\n\n\t\t\tvar arr = new Array();\n\t\t\tarr = retVal.split(\"|\");\n\t\t\tvar stra = arr[0];\n\t\t\tvar strc = arr[1];\n\t\t\tvar strb = arr[2];\n\n\tdocument.PatProblem_form.code.value         = stra;\n\tdocument.PatProblem_form.Description1.value = strb;\n\tdocument.PatProblem_form.Description.value  = strb;\n\tdocument.PatProblem_form.term_id.value      = strc;\n\n\t}\n\tif (s == 1 || s == 2)\n\t{\n\t\tvar retVal =    new String();\n\t\tvar dialogHeight= \"27.22\" ;\n\t\tvar dialogWidth = \"44\" ;\n\t\tvar status = \"no\";\n\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\n\t\tvar cause_ind=\'\';\n\t\tif(scheme==\"2\")\n\t\t cause_ind=document.forms[0].cause_ind.value\n\t\t\n\t\tretVal =await  window.showModalDialog(\"PaintConsultationFrame.jsp?title=\"+scheme_desc+\" Code List&p_diag_code=\"+s+\"&p_diag_scheme_desc=\"+scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&p_auth_yn=\"+p_auth_yn+\"&cause_indicator=&Age=\" + age + \"&Sex=\" + sex + \"&Dob=\" + dob+\"&mode=DiagSearch\",arguments,features);\n\t\tif (!(retVal == null))\n\t\t{\n\t\t\tvar retdata;\n\t\t\tif(scheme==\"2\")\n\t\t\t{\n\t\t\t retdata=retVal.split(\"/\") ;\n\t\t\tretVal=retdata[0];\n\n\t\t\tif(retdata[1]==document.forms[0].cause_ind.options[1].value)\n\t\t\t\t\tdocument.forms[0].cause_ind.options[1].selected=true;\n\t\t\t}\n\t\t\tdocument.PatProblem_form.code.value=retVal;\n\t\t}\n\t\t\tdocument.PatProblem_form.code.focus();\n\t\t\tdocument.PatProblem_form.remarks.focus();\n\t}\n}\n\nfunction check_enc(obj)\n{\n\tif(obj.checked == true)\n\t\t\tdocument.forms[0].include_enc.value = \"Y\";\n\telse\n\t\t\tdocument.forms[0].include_enc.value = \"N\";\n}\n</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\n\n\t/*function validate_date1(from,to) {\n\t\tvar fromarray;\n\t\tvar toarray;\n\t\tvar fromdate = from.value ;\n\t\tvar todate = to.value ;\n\t\tif(fromdate.length > 0 && todate.length > 0 ) {\n\t\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\t\ttoarray = todate.split(\"/\");\n\t\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\t\tif(Date.parse(todt) > Date.parse(fromdt)) \n\t\t\t\t{\n\t\t\t\t\tvar invaldt = getMessage(\"INVALID_CLOSE_DATE\",\"CA\") ;\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tdocument.forms[0].close.value=\'\';\n\t\t\t\t\tdocument.forms[0].close.focus();\n\t\t\t\t}\n\t\t\t\telse if(Date.parse(todt) <= Date.parse(fromdt)) return true;\n\t\t}\n\t\treturn true;\n\t}*/\n\n/*function DateCheck(from,to) {\n   \tvar fromarray;\n\tvar toarray;\n\tvar fromdate = from.value ;\n\tvar todate = to.value ;\n\tif(fromdate.length > 0 && todate.length > 0 ) {\n\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\ttoarray = todate.split(\"/\");\n\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\tvar todt   = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\tif(Date.parse(todt) > Date.parse(fromdt)) {\n\t\t\t\tvar invaldt=getMessage(\"INVALID_ONSET_DATE\",\"CA\");\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tdocument.forms[0].onset.value=\'\';\n\t\t\t\t\tdocument.forms[0].onset.focus();\n\n\t\t\t\t}\n\t\t\telse if(Date.parse(todt) <= Date.parse(fromdt)) return true;\n\t}\nreturn true;\n}*/\n\nfunction datechk(from,to,foc)\n{\n    DateValidation(from,to,foc,\'DATE_GREATER_SYSDATE\')\n}\n\nfunction callDesc(Obj)\n{\t\n\tif(Obj.value == \"\")\n\t{\n\t\tdocument.PatProblem_form.LongDescription.value=\"\";\n\t\tdocument.PatProblem_form.Description1.value=\"\";\n\t\tdocument.PatProblem_form.Description.value=\"\";\t\t\n\t}\n\tif(makeValidString(Obj)==false)\n\treturn false;\n\n\tvar sex = document.PatProblem_form.sex.value;\n\tvar dob = document.PatProblem_form.dob.value;\n\n\tvar function_name =  document.forms[0].function_name.value;\n\tvar called_from_ip =  document.forms[0].called_from_ip.value;\n\tvar modal_yn = document.forms[0].modal_yn.value;\n\tif(function_name==\"modify\")\n\t{\n\t\treturn false;\n\t}\n\tif(trimCheck(Obj.value)==\"\")\n\t{\n\t\tdocument.PatProblem_form.Description1.disabled = false;\n\t\tdocument.PatProblem_form.Description1.focus();\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\tdocument.PatProblem_form.Description1.disabled = true;\n\t\tdocument.PatProblem_form.Description1.value = \'\';\n\t}\n\n    var pq = document.PatProblem_form.scheme.value;\n    var stagecode = document.PatProblem_form.stage_code.value;\n    if (pq == 1 || pq == 2)\n    {\n        var p_diag_code = Obj.value;\n        var indicator= \"\";\n        if(scheme==\'2\')\n            indicator = document.forms[0].cause_ind.value;\n        var p_scheme  = ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =";\n        var sensitive=\'N\';\n\n\t\tvar authorizeButton=parent.PatProblemQueryTools.document.forms[0].authorizeButton.value;\n        if(parent.PatProblemQueryTools.document.forms[0].authorize!=null)\n        {\n           if(parent.PatProblemQueryTools.document.forms[0].authorize.value==\"Normal Mode\")\n                sensitive=\'Y\';\n        }\n\n\n        htmlVal = \"<html><body><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eCA/jsp/PatProblemVal.jsp\'><input type=\'hidden\' name=\'p_stage_code\' id=\'p_stage_code\' value=\'\"+stagecode+\"\'><input type=\'hidden\' name=\'p_diag_code\' id=\'p_diag_code\' value=\'\"+p_diag_code+\"\'><input type=\'hidden\' name=\'p_scheme\' id=\'p_scheme\' value=\'\"+p_scheme+\"\'><input type=\'hidden\' name=\'p_cause_indicator\' id=\'p_cause_indicator\' value=\'\"+indicator+\"\'><input type=\'hidden\' name=\'p_sensitive_yn\' id=\'p_sensitive_yn\' value=\'\"+sensitive+\"\'><input type=\'hidden\' name=\'authorizeButton\' id=\'authorizeButton\' value=\'\"+authorizeButton+\"\'><input type=\'hidden\' name=\'Sex\' id=\'Sex\' value=\'\"+sex+\"\'><input type=\'hidden\' name=\'Dob\' id=\'Dob\' value=\'\"+dob+\"\'><input type=\'hidden\' name= \'associate_codes\' value=\'\" + document.PatProblem_form.associate_codes.value + \"\'></form></body></html>\";\n\n\t\tif(called_from_ip == \"Y\" ||modal_yn==\"Y\")\n\t\t{ //new check added on 5th may 2004\n\t        parent.msgframe0.document.body.insertAdjacentHTML(\'afterbegin\',htmlVal);\n\t\t    parent.msgframe0.document.form1.submit();\n\t\t}\n\t\telse\n\t\t{\n\t        top.content.workAreaFrame.support.document.body.insertAdjacentHTML(\'afterbegin\',htmlVal);\n\t\t    top.content.workAreaFrame.support.document.form1.submit();\n\t\t}\n    }\n\n}\n\n  function change_chkbox(Obj)\n    {\n        if (Obj.checked == true)\n        {\n            document.PatProblem_form.primary_yn.value=\"Y\";\n        }\n        else if (Obj.checked == false)\n                document.PatProblem_form.primary_yn.value=\"N\";\n    }\n\t\n\tfunction callOnClickSignificant(Obj)\n    {\n\t\tif (Obj.checked == true)\n\t\t\tdocument.PatProblem_form.significant_yn.value=\"Y\";\n\t\telse if (Obj.checked == false)\n\t\t\tdocument.PatProblem_form.significant_yn.value=\"N\";\n    }\n\n\tfunction callAuthorize(Obj,pract_id,pract_name){\n\t\tif (Obj.checked == true){\n\t\t\tdocument.PatProblem_form.authorizeCheck.value=\"Y\";\n\t\t\tdocument.PatProblem_form.authorizepract.disabled=false;\n\t\t\tdocument.PatProblem_form.authorizepractbtn.disabled=false;\n\t\t\tdocument.PatProblem_form.authorizepract.value=pract_name;\n\t\t\tdocument.PatProblem_form.authorizepractid.value=pract_id;\n\t\t}\n\t\telse if (Obj.checked == false){\n\t\t\tdocument.PatProblem_form.authorizeCheck.value=\"N\";\n\t\t\tdocument.PatProblem_form.authorizepract.disabled=true;\n\t\t\tdocument.PatProblem_form.authorizepractbtn.disabled=true;\n\t\t\tdocument.PatProblem_form.authorizepract.value=\"\";\n\t\t\tdocument.PatProblem_form.authorizepractid.value=\"\";\n\t\t}\n\n\t}\n\n\tfunction chkAuthorize(Obj, code_indicator)\n    {\n\t\t\n\t\tvar QueryString= document.getElementById(\"QueryString\").value;\n\t\tvar called_from_ip =  parent.addModifyPatProblem.document.forms[0].called_from_ip.value;\n\t\tif (Obj.value == \'Authorize Mode\')\n\t\t{\t\n\t\t\tparent.support.location.href=\"../../eCA/jsp/Authorize.jsp?stage_code=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&stage_desc=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&Context=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&Access_Type=E&Context=PatientQueue&Access_Data=SD&Patient_Id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&Practitioner_Id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&jsp_name=PatProblemQueryResult.jsp&Encounter_Id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&Patient_Type=C&Fn_Name=Ass&Clinic_Code=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&Location_Type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&significant_yn=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patient_class=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&called_from_ip=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&QueryString=\" + escape(QueryString) + \"&Sex=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&Dob=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&code_indicator=\" + code_indicator + \"&associate_codes=\" + escape(document.PatProblem_form.associate_codes.value)\t;\n\t\t\t\n\t\t}\n\t\telse if (Obj.value == \'Normal Mode\')\n\t\t{\t\n\t\t\t\n\t\t\tparent.PatProblemQueryResult.location.href=\"../../eCA/jsp/PatProblemQueryResult.jsp?Encounter_Id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&Locn_Code=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&Patient_Id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&Locn_Type=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&f_authorize_yn=N&significant_yn=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&Sex=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&code_indicator=\" + code_indicator;\n            parent.addModifyPatProblem.location.href=\"../../eCA/jsp/addModifyPatProblem.jsp?Logical_Seq=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&stage_code=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&Encounter_Id=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&P_context=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&code_indicator=\" + code_indicator;\n\t\t\tparent.PatProblemQueryTools.document.forms[0].authorize.value=\'Authorize Mode\';\n        }  \n\t\t\n    }\nfunction showLongDescription()\n{\n\tvar dialogHeight= \"20\" ;\n    var dialogWidth = \"23\" ;\n\tvar a = document.forms[0].LongDescription.value;\n\t\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\";\n\twindow.showModalDialog(\"../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc=\"+a,\"\",features);\n}\nfunction changeList(Obj)\n{\n    var obj_val = Obj.value;\n    var diagtype = document.forms[0].diag_type.value;\n    var remarks = document.forms[0].remarks.value;\n\tvar significant_yn = document.forms[0].significant.value;\n\tvar primary_yn\t\t=\tdocument.forms[0].primary.value;\n\tif(significant_yn.checked==true) significant_yn = \"Y\";\n\telse significant_yn = \"N\";\n\n\tif(primary_yn.checked==true) primary_yn = \"Y\";\n\telse primary_yn = \"N\";\n\n\tvar dat=\tdocument.getElementById(\"currentdate\").value;\n\n\tif(document.getElementById(\"problem_status\").value == (\"C\"))\n\t{\t\n\t\tdocument.getElementById(\"close\").readOnly = false ;\n\n\t\tdocument.forms[0].b_days1.disabled=false;\n\t\tdocument.forms[0].\tb_months1.disabled=false;\n\t\tdocument.forms[0].\tb_age1.disabled=false;\n\t\tdocument.getElementById(\"img1\").disabled=false;\n\t\tdocument.forms[0].\tclose.disabled=false;\n\n\t\tdocument.getElementById(\"close\").value=dat;\n\t\tdocument.getElementById(\"ServerDate1\").value=dat;\n\t\tdocument.getElementById(\"close_date\").value=dat;\n\n\t}else{\n\n\t\tdocument.getElementById(\"close\").value=\'\';\n\t\tdocument.getElementById(\"ServerDate1\").value=\'\';\n\t\tdocument.getElementById(\"close_date\").value=\'\';\n\n\t\tdocument.forms[0].b_days1.disabled=\'\';\n\t\tdocument.forms[0].\tb_months1.disabled=\'\';\n\t\tdocument.forms[0].\tb_age1.disabled=\'\';\n\n\t\tdocument.forms[0].b_days1.disabled=true;\n\t\tdocument.forms[0].\tb_months1.disabled=true;\n\t\tdocument.forms[0].\tb_age1.disabled=true;\n\t\tdocument.getElementById(\"img1\").disabled=true;\n\t\tdocument.forms[0].\tclose.disabled=true;\n\n\t\tdocument.getElementById(\"close\").value = \"\" ;\n\t\tdocument.getElementById(\"close\").readOnly = true ;\n\t}\n\n}\nfunction decider()\n{\n\t\n\tcode_indicator = document.PatProblem_form.code_indicator.value;\n\t\n\tif(code_indicator == \'C\')\n\t\taddAssociateCodes();\n\telse if(code_indicator == \'D\')\n\t\taddAssociateCodes1();\n}\nasync function addAssociateCodes()\n{\n\t\n\tcode_indicator = document.PatProblem_form.code_indicator.value;\n\tif(code_indicator == \'C\')\n\t\t\tcode_indicator = \'E\';\n\telse\n\tif(code_indicator == \'D\')\n\t\t\tcode_indicator = \'A\';\n\t\n\tdiag_desc = document.PatProblem_form.Description1.value;\n\tp_scheme = \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\n\tassociate_codes = document.PatProblem_form.associate_codes.value;\n\tdiag_code = document.PatProblem_form.code.value;\n\t\n\tvar retVal\t\t\t\t= \"\";\n\tvar dialogHeight\t\t= \"15\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\n\tvar scheme_desc= document.PatProblem_form.scheme_desc.value; \n\tvar Encounter_Id= document.PatProblem_form.Encounter_Id.value ;\n\tvar p_auth_yn=\"N\";\n    var s = document.PatProblem_form.scheme.value;\n\tvar age = document.PatProblem_form.age.value;\n\tvar sex = document.PatProblem_form.sex.value;\n\tvar dob = document.PatProblem_form.dob.value;\n\t\n\t//alert(\"sex \"+sex+\"dob\"+dob+\"age\"+age);\n//\tvar con = confirm(\"Do you want to associate codes to this diagnosis?\\nPress OK to continue...\");\n//\tif(con)\n/***************************************************************************/\n\t//{\n\t\tvar arguments\t\t\t= \"\" ;\n\t\t//alert(\" code_indicator \"+code_indicator+\" diag_code \" +diag_desc);\n\t\tvar qs1 = \"code_indicator=\" + code_indicator + \"&diag_desc=\" + diag_desc + \"&title=\"+scheme_desc+\" Code List&p_diag_code=\"+s+\"&p_diag_scheme_desc=\"+scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&p_auth_yn=\"+p_auth_yn+\"&cause_indicator=&Age=\" + age + \"&Sex=\" + sex + \"&Dob=\" + dob + \"&p_scheme=\" +  p_scheme +\"&diag_code=\"+diag_code+\"&associate_codes=\" + associate_codes;\n//\t\talert(qs1);\n\t\tretVal =await window.showModalDialog(\"../../eCA/jsp/AddAssociateCodeFrames.jsp?\" + qs1,arguments,features);\n\t\t//alert(retVal);\n\t\tif(retVal != null)\n\t\t\tdocument.PatProblem_form.associate_codes.value = retVal;\n\t\t/*else\n\t\t\tdocument.PatProblem_form.associate_codes.value = \"\";*/\n\t\t//return retVal;\n\t//}\n/***************************************************************************/\n}\nasync function addAssociateCodes1()\n{\n\t//alert(\'new\');\n\tcode_indicator = document.PatProblem_form.code_indicator.value;\n\tif(code_indicator == \'C\')\n\t\t\tcode_indicator = \'E\';\n\telse\n\tif(code_indicator == \'D\')\n\t\t\tcode_indicator = \'A\';\n\t\n\tdiag_desc = document.PatProblem_form.Description1.value;\n\tp_scheme = \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\tassociate_codes = document.PatProblem_form.associate_codes.value;\n\t//alert(\'associate_codes :\'+associate_codes);\n\tdiag_code = document.PatProblem_form.code.value;\n\t//alert(diag_code);\n\t\n\tvar retVal\t\t\t\t= \"\";\n\t//var dialogTop\t\t\t= \"0\";\n\tvar dialogHeight\t\t= \"15\" ;\n\tvar dialogWidth\t\t\t= \"40\" ;\n\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\n\tvar scheme_desc= document.PatProblem_form.scheme_desc.value; \n\tvar Encounter_Id= document.PatProblem_form.Encounter_Id.value ;\n\tvar p_auth_yn=\"N\";\n    var s = document.PatProblem_form.scheme.value;\n\tvar age = document.PatProblem_form.age.value;\n\tvar sex = document.PatProblem_form.sex.value;\n\tvar dob = document.PatProblem_form.dob.value;\n\t\n\t//alert(\"sex \"+sex+\"dob\"+dob+\"age\"+age);\n//\tvar con = confirm(\"Do you want to associate codes to this diagnosis?\\nPress OK to continue...\");\n//\tif(con)\n\t//{\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar qs1 = \"code_indicator=\" + code_indicator + \"&diag_desc=\" + diag_desc + \"&title=\"+scheme_desc+\" Code List&p_diag_code=\"+s+\"&p_diag_scheme_desc=\"+scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&p_auth_yn=\"+p_auth_yn+\"&cause_indicator=&Age=\" + age + \"&Sex=\" + sex + \"&Dob=\" + dob + \"&p_scheme=\" +  p_scheme +\"&diag_code=\"+diag_code+\"&associate_codes=\"+associate_codes;\n//\t\talert(qs1);\n\t\tretVal =await window.showModalDialog(\"../../eCA/jsp/AddDaggerCodeFrames.jsp?\" + qs1,arguments,features);\n\t\t//retVal = window.open(\"../../eCA/jsp/AddDaggerCodeFrames.jsp?\" + qs1,arguments,features);\n\t\t\n\t\tif(retVal != null )\n\t\t\tdocument.PatProblem_form.associate_codes.value = retVal;\n\t\t/*else\n\t\t\tdocument.PatProblem_form.associate_codes.value = \"\";*/\n\n\t\t//return retVal;\n\t//}\n}\n</script>\n<form name=\"PatProblem_form\" id=\"PatProblem_form\"  action=\"../../servlet/eCA.PatProblemServlet?patient_id=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&encounter_id=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&practitioner_id=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&locn_code=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&locn_type=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&oper_num=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" method=\"post\" target=\"messageFrame\">\n<div align=\'center\'>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\"100%\" align=\'center\'>\n<tr>\n\t\t<td class=\'columnheader\' colspan=\'3\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td><td class=\'columnheader\' id=disMar  colspan=3></td>\n</tr>\n<tr>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n<td></td></tr><tr>\t\n<td  class=label width=\'25%\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n    <td class=\'feilds\' width=\'25%\'><select name=\"diag_type\" id=\"diag_type\"><option value=\'\'>----- ----- ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="----- -----</option>\n            <option value=\'P\' ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n            <option  value=\'D\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n            <option  value=\'F\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n        </select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\n</td>\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n   <td></td><td></td>  </tr><tr>\n    <td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n    <td class=\'fields\' width=\'25%\' nowrap>\n\t\t<input type=\"text\"  name=\"code\" id=\"code\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" size=\'10\' maxlength=\'10\' onblur=\'ChangeUpperCase(this);callDesc(this)\' ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" onchange=\"document.PatProblem_form.associate_codes.value = \'\';\">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t<input type=\"button\" name=\"AddAssociateCodes\" id=\"AddAssociateCodes\" value = \'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' onclick = \"decider()\"  class=\"button\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">\n\t</td>\n     ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n                <td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n                <td class=\'fields\' width=\'25%\'><select name=\'cause_ind\' id=\'cause_ind\' onchange=\"callDesc(code)\"  ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =">\n                                <option\t value=\'\'>----------";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="---------</option>\n                                    ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n                                <option value=\'E\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</option>\n                        </select>\n                </td>\n            ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n    <td width=\'25%\' class=\'label\' >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n    <input type=\"button\" class=\'Button\' name=\"search_button\" id=\"search_button\" title=\'Search\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" onClick=\"document.forms[0].code.value=\'\';show_window(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\')\"  ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =">\n    </td>\n    </tr>\n\n    <tr>\n        <td class=\'label\' width =\'25%\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n        <td  class=\'fields\' width =\'25%\'><input type=\"text\"  name=\"Description1\" id=\"Description1\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" size=40 readonly><input class=\"button\" type=\"button\" value=\"!\" name = \"exclamation\" onclick = \"javascript:showLongDescription();\" style=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" > \n        <input type=\"hidden\"  name = \"Description\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n        <input type=\"hidden\"  name = \"LongDescription\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t</td>\n\t\t<td>\n\t\t <input type=\"button\" class=\'Button\' name=\"ntf_button\" id=\"ntf_button\"  value=\"Record Notifiable Form\" onClick=\"callNotifiableNotes()\" style=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"  >\n        </td> <td></td>\n\n    </tr>\n\n    <!--  added by chitra on 19/10/2001  -->\n    <tr>\n\t\t    <td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n            <td class=\'fields\' width=\'25%\'><textarea name=\"remarks\" rows=\"3\" cols=\"40\" maxlength=\'2000\' onKeyPress=\'checkMaxLimit(this,2000);\'    onBlur=\"makeValidString(this)\" >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</textarea></td>\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\t\t\n\t\t\t<td  class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<input type=\'checkbox\' checked name=\'inc_encounter\' id=\'inc_encounter\' onClick=\"check_enc(this);\"></td>\n\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t<td>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t<td>&nbsp;</td>\n\t</tr>\n    <!--  added by chitra on 19/10/2001  ends -->\n\n<!-- <tr>\n<td colspan=5>\n<table border=1 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\"> -->\n\t<tr> \n\t\t<td  class=\"label\" width=\'15%\' >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t<td class=\"fields\"><input type=\'textbox\' name=\'recordedby\' id=\'recordedby\' align=\'left\' size=\'30\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' readOnly ></input><input type=\'hidden\' name=\'recordedbyid\' id=\'recordedbyid\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'></td>\n\t\t\n\t\t<td  class=\"label\" width=\'15%\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t<td class=\"fields\"><input type=\'textbox\' name=\'reviwedby\' id=\'reviwedby\' align=\'left\' size=\'15\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="></input>&nbsp;<input type=\'button\' class=\'button\' value=\'?\' onclick=\'ShowPractitioner()\' ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="><input type=\'hidden\' name=\'reviwedbyid\' id=\'reviwedbyid\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'></input></td>\n   </tr><tr>\n\t\t<td class=\'label\'  width=\'15%\'>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="&nbsp;\n\t\t<input type=\"checkbox\"   value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" name=\"authorizeCheck\" onclick=\"callAuthorize(this,\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\',\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="></td>\n\n\t\t<td class=\"fields\"><input type=\'text\' name=\'authorizepract\' id=\'authorizepract\' size=\'15\' value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="></input>&nbsp;<input type=\'button\' class=\'button\' value=\'?\' onclick=\'AuthorizePract()\' name=\'authorizepractbtn\' id=\'authorizepractbtn\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">\n\t\t<input type=\'hidden\' name=\'authorizepractid\' id=\'authorizepractid\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'></input></td> \n\n\n<!--</table> -->\n</td>\n<!-- <td colspan=5> <table border=1 width=\'100\' cellpadding=\'3\' align =\'center\'> \n\t<tr> -->\n    <td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="&nbsp;\n\t<input type=\"checkbox\" value=\"Y\" name=\"primary\" id=\"primary\" onclick=\"change_chkbox(this)\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" ></td>\n    \n    <td  class=\'fields\'  width=\'20%\'> ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="&nbsp;<input type=\"checkbox\"   value=\"Y\" name=\"significant\" id=\"significant\" onclick=\"callOnClickSignificant(this)\" ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" ></td>\n</tr><tr>\n\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\n\t\t<td  class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'></td>\n\t\t<td width=\'25%\'>\t\n\t\t\t<input type=\'text\' name=\'onset\' id=\'onset\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' size=\'10\' maxlength=\'10\' readonly  Onblur=\'CheckDate(this);isVaidwithSysDate(this,\"DMY\",\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\");calci(b_age,\"DMY\",\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\",onset);calcage(this,ServerDate,onset)\' ><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'onset\');\" ><img align=\'center\'  src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t<td width=\'25%\' class=\'label\' colspan=2 >\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="&nbsp;";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" (\n\t\t\t<input type=\'hidden\' name=\'onset_date\' id=\'onset_date\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\n\t\t\t<input type=\"text\" name=\"b_days\" id=\"b_days\" maxlength=\"2\" size=\"2\" value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' \t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\tonBlur=\'CheckForNumber_L(this,onset);checkDays(this,onset);calci(this,\"DMY\",\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\",onset)\'   tabIndex=\'4\'>D&nbsp;\n\n\t\t<input type=\"text\" name=\"b_months\" id=\"b_months\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' size=\"2\" \n\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\tonBlur=\'CheckForNumber_L(this,onset);checkMonth(this,onset);calci(this,\"DMY\",\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\",onset)\'   tabIndex=\'5\'>M&nbsp;\n\n\t\t<input type=\"text\" name=\"b_age\" id=\"b_age\" maxlength=\"3\" size=\"3\" value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'    \n\t\tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\tonBlur=\'CheckForNumber_L(this,onset);calci(this,\"DMY\",\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\",onset)\' tabIndex=\'6\'>Y&nbsp;)\n\t\t\t\n\t\t\n</td>\n    </tr>\n <!--</table> -->\n\t\t\n\t\t</td>\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\n    <input type=\"hidden\"  name=\"db_date\" id=\"db_date\"            value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n    <input type=\"hidden\"  name=\"diag_srl_no\" id=\"diag_srl_no\"        value=\"\">\n    <input type=\"hidden\"  name=\"record_type\" id=\"record_type\"        value=\"\">\n    <input type=\"hidden\"  name=\"cause_indicator\" id=\"cause_indicator\"    value=\"\">\n    <input type=\"hidden\"  name=\"tab_list_no\" id=\"tab_list_no\"        value=\"\">\n    <input type=\"hidden\"  name=\"analysis_code\" id=\"analysis_code\"      value=\"\">\n    <input type=\"hidden\"  name=\"notifiable_yn\" id=\"notifiable_yn\"      value=\"\">\n    <input type=\"hidden\"  name=\"sensitive_yn\" id=\"sensitive_yn\"       value=\"\">\n    <input type=\"hidden\"  name=\"primary_yn\" id=\"primary_yn\"         value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" >\n    <input type=\"hidden\"  name=\"significant_yn\" id=\"significant_yn\"     value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" >\n    <input type=\"hidden\"  name=\"srl_no_from_table\" id=\"srl_no_from_table\"  value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" >\n    <input type=\"hidden\"  name=\"term_id\" id=\"term_id\"            value=\"\">\n    <input type=\"hidden\"  name=\"Sec_Hdg_Code\" id=\"Sec_Hdg_Code\"       value=\"\">\n    <input type=\"hidden\"  name=\"associate_codes\" id=\"associate_codes\"    value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n    <input type=\"hidden\"  name=\"code_indicator\" id=\"code_indicator\"     value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">z\n    <input type=\"hidden\"  name=\"diag_code\" id=\"diag_code\"     value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n  <input type=\"hidden\"  name=\"retVal_auth\" id=\"retVal_auth\"     value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n    <input type=\"hidden\"  name=\"db_date\" id=\"db_date\"            value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n    <input type=\"hidden\"  name=\"diag_srl_no\" id=\"diag_srl_no\"        value=\"\">\n    <input type=\"hidden\"  name=\"record_type\" id=\"record_type\"        value=\"R\">\n    <input type=\"hidden\"  name=\"cause_indicator\" id=\"cause_indicator\"    value=\"\">\n    <input type=\"hidden\"  name=\"tab_list_no\" id=\"tab_list_no\"        value=\"\">\n    <input type=\"hidden\"  name=\"analysis_code\" id=\"analysis_code\"      value=\"\">\n    <input type=\"hidden\"  name=\"notifiable_yn\" id=\"notifiable_yn\"      value=\"N\">\n    <input type=\"hidden\"  name=\"sensitive_yn\" id=\"sensitive_yn\"       value=\"N\">\n    <input type=\"hidden\"  name=\"primary_yn\" id=\"primary_yn\"         value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" >\n    <input type=\"hidden\"  name=\"term_id\" id=\"term_id\"            value=\"\">\n    <input type=\"hidden\"  name=\"Sec_Hdg_Code\" id=\"Sec_Hdg_Code\"       value=\"\">\n\t<input type=\"hidden\"  name=\"code_indicator\" id=\"code_indicator\"     value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n    <input type=\"hidden\"  name=\"diag_code\" id=\"diag_code\"     value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n    <input type=\"hidden\"  name=\"retVal_auth\" id=\"retVal_auth\"     value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n    <input type=\"hidden\"  name=\"associate_codes\" id=\"associate_codes\"    value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\n    \n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="<!-- <td>&nbsp;</td> -->\n\t\t<td  class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</td>\n\t\t<td class=\'fields\'><input type=\'text\' name=\'onset\' id=\'onset\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' size=\'10\' maxlength=\'10\' readonly></td>\t\n\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="<input type=\'hidden\' name=\'ServerDate1\' id=\'ServerDate1\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'></td><td> <input type=\'text\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' size=\'10\' maxlength=\'10\'  readonly Onblur=\'CheckDate(this);isBetweenCurrDate(\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\",\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\",this,\"DMY\",\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\");calcage(this,ServerDate1,close);calci1(b_age1,\"DMY\",\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\",close);\' ><input type=\'image\' id=\'img1\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'close\');\" ><!-- <img align=\'center\'  src=\'../../eCommon/images/mandatory.gif\'> -->\n\t\t<input type=\'hidden\' name=\'close_date\' id=\'close_date\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'> <!-- </td>  -->\n\t\t<!-- <td align=\'left\'  colspan=\'1\'  width=\'22%\' nowrap class=label> --> <td class=\'label\' colspan=\'2\' >(&nbsp;";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="&nbsp;\n\t\t<input type=\"text\" name=\"b_days1\" id=\"b_days1\" maxlength=\"2\" size=\"2\" value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'  \n\t \tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t    onBlur=\'CheckForNumber_L(this,close);checkDays(this,close);calci1(this,\"DMY\",\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\",close)\'   tabIndex=\'6\'>D&nbsp;\t\n\n\t\t<input type=\"text\" name=\"b_months1\" id=\"b_months1\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\' size=\"2\"    \n\t \tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\tonBlur=\'CheckForNumber_L(this,close);checkMonth(this,close);calci1(this,\"DMY\",\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\",close)\'   tabIndex=\'5\'>M&nbsp;\n\t\t\t\n\t\t<input type=\"text\" name=\"b_age1\" id=\"b_age1\" maxlength=\"3\" size=\"3\" value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'  \n\t \tonKeyPress=\'return(ChkNumberInput(this,event,0))\'\n\t\tonBlur=\'CheckForNumber_L(this,close);calci1(this,\"DMY\",\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\",close)\'   tabIndex=\'4\'>Y&nbsp;)&nbsp;\n\t\t</td></tr>\n    ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n    </table>\n</div>\n<input type=\'hidden\'  name=\'scheme_desc\' id=\'scheme_desc\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'></td></tr>\n<input type=\'hidden\' name=\'function\' id=\'function\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n<input type=\'hidden\' name=\'Invoking_Function\' id=\'Invoking_Function\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n<input type=\'hidden\' name=\'currentdate\' id=\'currentdate\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n<input type=\'hidden\' name=\'current_date\' id=\'current_date\' value=\'\'>\n<input type=\'hidden\' name=\'context\' id=\'context\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n<input type=\'hidden\' name=\'stage_code\' id=\'stage_code\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n<input type=\'hidden\' name=\'stage_desc\' id=\'stage_desc\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'>\n<input type=\'hidden\' name=\'logical_seq_no\' id=\'logical_seq_no\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'>\n<input type=\'hidden\' name=\'QueryString\' id=\'QueryString\' value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n<input type=\'hidden\' name=\'called_from_ip\' id=\'called_from_ip\' value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n<input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\n\n<input type=\'hidden\' name=\'age\' id=\'age\' value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n<input type=\'hidden\' name=\'sex\' id=\'sex\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n<input type=\"hidden\"  name=\"scheme\" id=\"scheme\"             value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n<input type=\"hidden\"  name=\"p_authorize\" id=\"p_authorize\"            value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\n<!-- parameters for the notes function -->\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n<input type=\'hidden\' name=\'visit_adm_date\' id=\'visit_adm_date\' value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n<input type=\'hidden\' name=\'diagstage\' id=\'diagstage\' value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n<input type=\"hidden\" name=\"Encounter_Id\" id=\"Encounter_Id\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n<input type=\"hidden\" name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'RECORD_DIAGNOSIS\'>\n<input type=hidden name=errorRemarks value=\'\'>\n<input type=\"hidden\" name=\'include_enc\' id=\'include_enc\' value=\'Y\'></input>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\n<!--<input type=hidden name=currentdate value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>-->\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t<script language=javascript>\n\t\tdocument.forms[0].b_days1.disabled=true;\n\t\tdocument.forms[0].\tb_months1.disabled=true;\n\t\tdocument.forms[0].\tb_age1.disabled=true;\n\t\tdocument.getElementById(\"img1\").disabled=true;\n\t\tdocument.forms[0].\tclose.disabled=true;\n\t</script>\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\n\n";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t<script language=javascript>\t\n\t\t\tdocument.PatProblem_form.code.focus();\n\t\t\tdocument.PatProblem_form.remarks.focus();\n\t</script>\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n<script>\n\tvar practitioner = \'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\';\n\tif(practitioner == \'\')\n\t{\n\t\talert(getMessage(\"PERFORMED_NOT_BLANK\",\"CA\"));\n\t\t//alert(\'APP-CA0001 Practitioner cannot be empty.....\'); // this was done to avoid null practitioner name when diagnosis is recorded for the patient... if the pratitioner is empty, the dialog is closed when called from IP module\n\t\twindow.close();\n\t}\n</script>\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n<script>\nif(\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' == \'T\' && (\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' == \'C\' || \'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' == \'D\' ))\ndocument.PatProblem_form.AddAssociateCodes.disabled=false;\n</script>\n";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);


	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    String scheme_desc  ="";
    String scheme="";
	String flagAut="";
	String disAut="";
	String autAut="N";
	String disAutPract="";
	String disReviewPract ="";
	String sysdate		=	"";
	 Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	sysdate		=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

            _bw.write(_wl_block8Bytes, _wl_block8);

    Connection con          = null; 
	StringBuffer sqlStrBufr=new StringBuffer();
    //java.util.Properties p  =(java.util.Properties) session.getValue( "jdbc" );
//    SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
  //  String currentdate      = dateFormat.format(new java.util.Date()) ;

	String currentdate		=	"";
	currentdate				=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
    String facilityId       = checkForNull((String) session.getValue( "facility_id" ));
	String diag_code= "";
	String dup_diag_code="";
	String modal_yn				= checkForNull(request.getParameter("modal_yn"));
    String srl_no           = request.getParameter("srl_no");
    String Patient_Id       = checkForNull(request.getParameter("Patient_Id"));
	String patient_class    = checkForNull(request.getParameter("patient_class"));
	String called_from_ip   = checkForNull(request.getParameter("called_from_ip"));	
	String retVal_auth		=checkForNull(request.getParameter("retVal_auth"));
	String associate_codes  =checkForNull(request.getParameter("associate_codes"));
	
	String code_indicator   =checkForNull(request.getParameter("code_indicator"));

	String oper_num= checkForNull(request.getParameter("oper_num"));
	

	String encounter_clor	=checkForNull(request.getParameter("encounter_clor"));
	String age				= checkForNull(request.getParameter("Age"));	
	String dob				= checkForNull(request.getParameter("Dob"));	
	String sex				= checkForNull(request.getParameter("Sex"));
	
	if(called_from_ip == null || called_from_ip.equals("null") || called_from_ip.equals(""))called_from_ip="N";

	PreparedStatement pstmt		=null;
	PreparedStatement stmt		=null;
	PreparedStatement stmt_1    =null;
    ResultSet rs				=null;
    ResultSet rs_1				=null;

	String srl_no_from_table ="";
    String diag_desc="";
    String diag_long_desc="";
    String primary_yn="N";
    String primary_status="";
    String onset_date=currentdate;
    String close_date="";
    String problem_status ="";
    String dis="";
    String dis_add_associate="disabled";
	String from_ip_stage="";

	String reviewed_by_pract	  ="";     
	String reviewed_by_pract_name ="";     
	String authorized_yn          ="";

	String authorized_by_pract    ="";
	String authorized_by_pract_name  ="";

    String id[] ={"","B","W","S","C"};
    String val[]={"--"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+ "--",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Better.label","ca_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Worse.label","ca_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Same.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")};

    String select_val="";

    String read_only    ="";
    String read_onlycode    ="readonly";
    String data_state   ="insert";
    String db_date="";
   // String sql=" select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date,(select PRACTITIONER_NAME from am_practitioner where practitioner_id=?) Recorded_by_pract_name from mr_parameter ";

   String sql="select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') Recorded_by_pract_name from mr_parameter";
    String check_box_value="N";
    String cause_ind="";

    String diagstage = "";
    String diagstagecode = "";
    String problemremarks = "";
    String diagtype = "";
 
	String significant_status = "", significant_yn = "N";
    String sel1 = "", sel2 ="", sel3 = "";

    String spanval= "";
	
	String agey="";
	String agem="";
	String aged="";
	String accession_num = "",notifiable_yn="",visible="visibility:hidden",visibleexclamation="visibility:hidden";

    String Encounter_Id      = request.getParameter("Encounter_Id");

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
	// end
	if(called_from_ip.equals("Y"))
	{	
		Practitioner_Id      = request.getParameter("Practitioner_Id");
//		Practitioner		 = request.getParameter("practitioner_name");

	}
	else
	{
		Practitioner_Id   = (String) session.getValue("ca_practitioner_id");
		Practitioner = (String) session.getValue("practitioner_name");
	}	
	
	if(Practitioner==null || Practitioner.equals("null"))
		Practitioner="";
	
	String Locn_Code         = request.getParameter("Locn_Code");
    String Locn_Type         = request.getParameter("Locn_Type");
    String f_authorize_yn    = request.getParameter("f_authorize_yn");
    //String chk_status        =checkForNull(request.getParameter("problem_status"));
    String invoking_function         =checkForNull(request.getParameter("Function"));
    
	String context  = request.getParameter("P_context");
	if (patient_class.equals("OP") || patient_class.equals("EM")||patient_class.equals("XT"))
		context  = "OP_Q";
	else
		context  = "IP_Q";

    String stagedesc =checkForNull(request.getParameter("stage_desc"));
    String stagecode =checkForNull(request.getParameter("stage_code"));

	//added for notes
	String visit_adm_date =checkForNull(request.getParameter("visit_adm_date"));
	String episode_type =checkForNull(request.getParameter("episode_type"));
	//-------
    String logicalseqno =checkForNull(request.getParameter("Logical_Seq"));
    String diagtypeselected =checkForNull(request.getParameter("diag_type"));
    String remarksselected =checkForNull(request.getParameter("remarks"));
	String QueryString =checkForNull(request.getParameter("QueryString"));

	primary_yn		=	(request.getParameter("primary_yn")==null)?"N" : request.getParameter("primary_yn");
	significant_yn	=	(request.getParameter("significant_yn")==null)?"N" : request.getParameter("significant_yn");
	String sql_1=""; 

   

try
{
	con = ConnectionManager.getConnection(request);

		//added new by kishore on 5/30/2005
		if(modal_yn.equals("Y"))
		{
			read_only   = "readonly";
			dis_add_associate = "disabled";
			dis = "disabled";

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
		pstmt.setString(2,locale);
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
			read_only   = "readonly";

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
		//sql_1 = "Select srl_no,diag_code,diag_desc,primary_yn,to_char(onset_date,'dd/mm/yyyy') onset_date,to_char(close_date,'dd/mm/yyyy') close_date, problem_status, cause_indicator, ip_diag_stage, decode(ip_diag_stage,'I','Intermediate','A','Admission','D','Discharge') diag_stage_desc, problem_remarks, diag_type, significant_yn,accession_num,notifiable_yn,reviewed_by_pract, (select short_name from am_practitioner where practitioner_id=reviewed_by_pract) reviewed_by_pract_name, authorized_yn, authorized_by_pract, (select short_name from am_practitioner where practitioner_id = authorized_by_pract) authorized_by_pract_name ,recorded_by_pract, (select short_name from am_practitioner where practitioner_id=recorded_by_pract) recorded_by_pract_name,(select long_desc from mr_icd_code where diag_code=pr_problem.diag_code and rownum=1 ) long_desc from pr_problem where patient_id = ? and srl_no = ? " ;

		sql_1="Select srl_no,diag_code,diag_desc,primary_yn,to_char(onset_date,'dd/mm/yyyy') onset_date,to_char(close_date,'dd/mm/yyyy') close_date, problem_status, cause_indicator, ip_diag_stage, ip_diag_stage diag_stage_desc, problem_remarks, diag_type, significant_yn,accession_num,notifiable_yn,reviewed_by_pract, (select short_name from am_practitioner_lang_vw where practitioner_id=reviewed_by_pract and language_id = ?) reviewed_by_pract_name, authorized_yn, authorized_by_pract, (select short_name from am_practitioner_lang_vw where practitioner_id = authorized_by_pract and language_id = ?) authorized_by_pract_name ,recorded_by_pract, (select short_name from am_practitioner_lang_Vw where practitioner_id=recorded_by_pract and language_id = ?) recorded_by_pract_name ,(select long_desc from mr_icd_code where diag_code=pr_problem.diag_code and rownum=1 ) long_desc from pr_problem where patient_id = ? and srl_no = ? ";

		stmt_1 = con.prepareStatement(sql_1);
		stmt_1.setString(1,locale);
		stmt_1.setString(2,locale);
		stmt_1.setString(3,locale);
		stmt_1.setString(4,Patient_Id);

		stmt_1.setString(5,srl_no);
        rs_1 = stmt_1.executeQuery();

        if (rs_1.next())
        {
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
			onset_date		= com.ehis.util.DateUtils.convertDate(onset_date,"DMY","en",locale);
			close_date		= com.ehis.util.DateUtils.convertDate(close_date,"DMY","en",locale);
			if(diagstage.equals("I"))
				diagstage=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
			if(diagstage.equals("A"))
				diagstage=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
			if(diagstage.equals("D"))
			
			diagstage=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
			
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
			authorized_by_pract_name = rs_1.getString("authorized_by_pract_name")==null?"":rs_1.getString("authorized_by_pract_name");
			
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



            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(context));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(significant_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(significant_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(significant_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(context));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

	//String qry="select b.short_desc from ip_adt_trn a, ip_discharge_type b where a.facility_id = ? and a.encounter_id = ? and a.trn_type='D' and b.discharge_type_code=a.trn_code"; 

	String qry="select IP_GET_DESC.IP_DISCHARGE_TYPE(a.trn_code,?,'2') from ip_adt_trn a  where a.facility_id = ? and a.encounter_id = ? and a.trn_type='D' ";

	PreparedStatement stmt5 = null;
	ResultSet rs5 = null;

	try{
		stmt5 =	con.prepareStatement(qry);
		stmt5.setString(1, locale);
		stmt5.setString(2, facilityId);
		stmt5.setLong(3, Long.parseLong(Encounter_Id));

		rs5=stmt5.executeQuery();

	    if(context.equals("IP_Q"))
        {
            /*if(called_from_ip.equals("Y"))
			{
				stagecode="D";
				stagedesc="D";
			}*/
			if(data_state.equals("insert"))
            {
                if(!(stagecode.equals("") && stagedesc.equals(""))){
                    out.print("<td class='label' width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+"&nbsp;</td><td colspan=1><input type='text' width='25%' value='"+stagedesc+"' readonly size=15><img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='diag_stage' id='diag_stage' value='"+stagecode+"'></td>");                                    
                }else{
                    out.print("<td class='label' width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+"&nbsp;</td><td colspan=1 width='25%'><select name='diag_stage' id='diag_stage'><option >&nbsp;----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------&nbsp;</option><option value='A' "+dsel1+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels")+"</option><option value='I' "+dsel2+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels")+"</option><option value='D' "+dsel3+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels")+"</option></select><img src='../../eCommon/images/mandatory.gif'></img></td>");
				}
            }
            else
			{
				/*if(diagstage.equals(""))

				{*/
				String diastgSel_1="";String diastgSel_2="";String diastgSel_3="";
				
				if(diagstagecode.equals("A"))
						diastgSel_1="selected";
				else if(diagstagecode.equals("I"))
						diastgSel_2="selected";
				else if(diagstagecode.equals("D"))
						diastgSel_3="selected";

				if(called_from_ip.equals("Y"))
				{
					diastgSel_1="";
					diastgSel_2="";
					diastgSel_3 ="selected";
					from_ip_stage="disabled";
					
				}

                    out.print("<td class='label' width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+"&nbsp;</td><td colspan=1><select name='diag_stage' id='diag_stage' "+from_ip_stage+"><option >&nbsp;----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------&nbsp;</option><option value='A' "+diastgSel_1+" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels")+"</option><option value='I' "+diastgSel_2+" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels")+"</option><option value='D' "+diastgSel_3+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels")+"</option></select><img src='../../eCommon/images/mandatory.gif'></img></td>");			
				/*}
				else
				{
					out.print("<td class='label' align=right>Stage&nbsp;</td><td colspan=1><input type='text' value='"+diagstage+"' readonly size=15>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='diag_stage' id='diag_stage' value='"+diagstagecode+"'></td>");        
				}*/
			}
			if(rs5.next())
			{
				out.print("<td colspan=1 class='label' width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargetype.label","common_labels")+" :<b>"+rs5.getString(1)+"</b></td>"); 
			}
			else
				out.print("<td colspan=1 class='label' width='25%' >&nbsp;</td>"); 


        }
        else spanval = "5";
	}//end of try
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally{
		if(rs5!=null) rs5.close();
		if(stmt5 != null) stmt5.close();
	}

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(sel1));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(sel2));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(sel3));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

			
			if(data_state.equals("modify") )
			{
   		   	visibleexclamation="visibility:visible";
			}
			else
	       {
             read_onlycode="";
		   }
			if(code_indicator == null || code_indicator.equals("null") || code_indicator.equals(""))
	        { 
				dis_add_associate = "disabled";
			}
			else
	       {
				dis_add_associate = "";
		   }

			
			
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(read_onlycode));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SupportingDiagCode.label","ca_labels")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(dis_add_associate));
            _bw.write(_wl_block55Bytes, _wl_block55);

        if(scheme.equals("2"))
        {
            String sel="";
            
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

                                        if(cause_ind.equals("E"))
                                            sel="selected";
                                    
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

        }
        else
        {
            out.print("<td width='25%'>&nbsp;</td>");
        }
    
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(scheme_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(visibleexclamation));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(diag_long_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( visible ));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(problemremarks));
            _bw.write(_wl_block74Bytes, _wl_block74);

		if(data_state.equals("modify") && encounter_clor.equals("N"))
		{
	
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

		}
		else
		{
	
            _bw.write(_wl_block77Bytes, _wl_block77);

		}
	
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(java.net.URLDecoder.decode(Practitioner)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(reviewed_by_pract_name));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(disReviewPract));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(disReviewPract));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(reviewed_by_pract));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(autAut));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(Practitioner));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(flagAut));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(disAut));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(authorized_by_pract_name));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(disAutPract));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(disAutPract));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(authorized_by_pract));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(primary_status));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(read_only));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(significant_status));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(read_only));
            _bw.write(_wl_block99Bytes, _wl_block99);

    if (!data_state.equals("modify"))
    {

            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block114Bytes, _wl_block114);
  }  
            _bw.write(_wl_block2Bytes, _wl_block2);

    if (scheme.equals("1") ||  scheme.equals("2"))
    {

            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(db_date));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(significant_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(srl_no_from_table));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(java.net.URLEncoder.encode(associate_codes)));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(retVal_auth));
            _bw.write(_wl_block123Bytes, _wl_block123);

    }
    else
    {

            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(db_date));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(srl_no_from_table));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(retVal_auth));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(java.net.URLEncoder.encode(associate_codes)));
            _bw.write(_wl_block123Bytes, _wl_block123);

    }

            _bw.write(_wl_block130Bytes, _wl_block130);

    if (data_state  == "modify")
    {
		
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block133Bytes, _wl_block133);

        out.println("<td  class='label'  > "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"&nbsp;</td><td>");
    //    if(problem_status.equals("C"))
                close_date=""; //currentdate;
        out.println("<select name='problem_status' id='problem_status' onChange='return changeList(this)'>");
        for(int i=0; i<5; i++)
        {
          if(id[i].equals(problem_status))
			select_val="selected";
		  else
			select_val = "";
          out.print("<option value='"+id[i]+"' "+select_val+">"+val[i]+"</option>");
        }
        out.println("</select>");
        out.println("<img src='../../eCommon/images/mandatory.gif'align='center'>");
        out.println("</td></tr><tr><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CloseDate.label","ca_labels"));
    
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(close_date));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(close_date));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(close_date));
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block148Bytes, _wl_block148);

        out.println("<input type='hidden'  name='close_date' id='close_date' value='"+close_date+"' ></td></tr>");
        }

            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(scheme_desc));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(data_state));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(data_state));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(invoking_function));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(context));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(QueryString));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(age));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(f_authorize_yn));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(diagstagecode));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block123Bytes, _wl_block123);


}catch (Exception e)
{
    e.printStackTrace() ;
}
finally{
    if(rs!=null) rs.close();
	if(stmt != null) stmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block179Bytes, _wl_block179);
 if(data_state  == "modify"){ 
            _bw.write(_wl_block180Bytes, _wl_block180);
}
            _bw.write(_wl_block181Bytes, _wl_block181);
 if (!dup_diag_code.equals("")){  // this is for populating records if the privilage is not there  
            _bw.write(_wl_block182Bytes, _wl_block182);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
if(called_from_ip.equals("Y"))
{
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(Practitioner));
            _bw.write(_wl_block184Bytes, _wl_block184);
}


            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(retVal_auth));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block188Bytes, _wl_block188);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DiagType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Provisional.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Differential.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.final.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseInd.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.external.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IncludeinCurrentEncounter.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReviewedBy.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primary.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.significant.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Last.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Before.label", java.lang.String .class,"key"));
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
}
