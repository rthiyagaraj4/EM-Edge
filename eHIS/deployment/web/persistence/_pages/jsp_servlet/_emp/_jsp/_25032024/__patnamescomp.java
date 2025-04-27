package jsp_servlet._emp._jsp._25032024;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import java.util.*;

public final class __patnamescomp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/25032024/PatNamesComp.jsp", 1711026796043L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3_0 =" \n<SCRIPT LANGUAGE=\"JavaScript\"> \n\tvar NamePrefixArray = new Array(); \n\tvar NamePrefixLocArray = new Array(); \n\tvar PrefixSexArray = new Array();\n\tvar NameSuffixArray = new Array();\n\tvar NameSuffixLocArray = new Array();\n\tvar SuffixSexArray = new Array();\n\tvar NamePrefixLocArrayTemp = new Array();//added By Sudhakar during UAT-3\n\tvar NameSuffixLocArrayTemp = new Array();//added By Sudhakar during UAT-3\n\n\n\tfunction populateLocalValues(obj,fromobj,toobj,lang,CalledFromFunction){\t\t\n\t\tif(CalledFromFunction==\'FatherDtls\') { \n\t\t\tfromobj = fromobj[0];\n\t\t\ttoobj = toobj[0];\t\t\n\t\t}else if(CalledFromFunction==\'NewbornDtls\') {\n\t\t\tfromobj = fromobj[1];\n\t\t\ttoobj = toobj[1];\t\t\t\n\t\t}else{\n\t\t\ttoobj =eval(\"document.forms[0].\"+toobj.name)\t\t\t\t\n\t\t}\n\t\tif(document.forms[0].language_direction.value == \"R\"){\n\t\t\t\tif(fromobj.name == \"family_name\" || fromobj.name==\"family_name_oth_lang\"){\n\t\t\t\t\tvar familyname = \"Y\";\n\t\t\t\t}\n\t\t\t\t var xmlStr =\"<root><SEARCH \";\n\t\t\t\t xmlStr +=\" /></root>\";\n\t\t\t\t var param=\"called_function=MP&othername=\"+encodeURIComponent(obj.value)+\"&lang=\"+lang+\"&familyname=\"+familyname;\n\t\t\t\t var temp_jsp=\"../../eMP/jsp/PopulateNames.jsp?\"+param;\t\t\t\t \n\t\t\t\t var xmlDoc = \"\" ;\n\t\t\t\t var xmlHttp = new XMLHttpRequest() ;\n\t\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t xmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\t\t xmlHttp.send(xmlDoc);\n\t\t\t\t responseText=trimString(xmlHttp.responseText);\t\t\t\t \n\t\t\t\t var retVal =responseText.split(\"#\")\t\t\t\t\t \n\t\t\t\t if(retVal[1] != \"\"){\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\ttoobj.value = retVal[1]\n\t\t\t\t } else {\t\t\n\t\t\t\t\tif(lang==\"E\"){\t\t\t\t\t\t\n\t\t\t\t\t\ttoobj.value = \"\";\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\t\n\t\t}\t\n\t\tputLocalLangPatientName(\'\',CalledFromFunction);\n\t\tif(lang==\"O\"){\n\t\t\tputPatientName(\'\',CalledFromFunction);\n\t\t}\n\t}\n\n\n\n\n\tasync function callSearch(fromobj, toobj, field_lang,CalledFromFunction){   \n\t\tif(CalledFromFunction==\'FatherDtls\') { \n\t\t\tfromobj = fromobj[0];\n\t\t\ttoobj = toobj[0];\t\t\n\t\t}else if(CalledFromFunction==\'NewbornDtls\') {\n\t\t\tfromobj = fromobj[1];\n\t\t\ttoobj = toobj[1];\t\n\t\t}else{\n\t\t\tfromobj = fromobj;\n\t\t\ttoobj = toobj;\t\n\t\t}\n\t\tvar names_in_oth_lang = \"\";\n\t\tif(document.forms[0].pat_names_in_oth_lang_yn.length > 0){\n\t\t\tnames_in_oth_lang = document.forms[0].pat_names_in_oth_lang_yn[1].value;\n\t\t}else{\n\t\t\tnames_in_oth_lang = document.forms[0].pat_names_in_oth_lang_yn.value;\n\t\t}\n\t\tvar lang_dir = \"\"; \n\t\tif(document.forms[0].language_direction.length > 0) {\t\n\t\t\tlang_dir = document.forms[0].language_direction[1].value;\t\n\t\t}else{\n\t\t\tlang_dir = document.forms[0].language_direction.value;\t\n\t\t}\n\t\tif(lang_dir == \'R\'){\n\t\t\tvar jsp_name =\"../../eMP/jsp/SearchStdOtherName.jsp?names_in_oth_lang=\"+names_in_oth_lang+\"&param_value=\"+encodeURIComponent(fromobj.value)+\"&field_lang=\"+field_lang;\n\t\t\tif(fromobj.name == \"family_name\" || fromobj.name==\"family_name_oth_lang\"){\n\t\t\t\tjsp_name =\"../../eMP/jsp/SearchStdFamilyName.jsp?names_in_oth_lang=\"+names_in_oth_lang+\"&param_value=\"+encodeURIComponent(fromobj.value)+\"&field_lang=\"+field_lang;\n\t\t\t}\n\t\t\tvar retVal = new String();\n\t\t\t//var dialogHeight = \"28\";\n\t\t\t//var dialogWidth = \"43\";\n\t\t\tvar dialogHeight = \"400px\";\n\t\t\tvar dialogWidth = \"700px\";\n\t\t\tvar dialogTop = \"10px\";\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments = \"\";\n\t\t\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\tretVal = await window.showModalDialog( jsp_name,arguments,features);\n\t\t\tif(retVal != null){\n\t\t\t\tvar arr = retVal.split(\"`\");\n\t\t\t\tif((fromobj.name).indexOf(\"oth_lang\") == -1){\n\t\t\t\t\tfromobj.value =arr[0]\n\t\t\t\t\ttoobj =eval(\"document.forms[0].\"+toobj)\n\t\t\t\t\tif(toobj != null){\n\t\t\t\t\t\ttoobj.value = arr[1]\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\ttoobj.value = arr[0]\n\t\t\t\t\tfromobj.value =arr[1]\n\t\t\t\t\tChangeInitCase(toobj)\n\t\t\t\t}\n\t\t\t\tfromobj.focus();\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction sel_prefix_gen(obj,CalledFromFunction){\n\t\tvar val=obj.value;\n\t\tvar prefix_length;\n\t\t\t/*Added By Dharma Start*/\n\tvar fatherDtlsIndex\t\t\t= 0;\n\tvar newBornDtlsIndex\t\t= 1;\n\tvar isNewBornChngsAppl\t\t= \"\";\n\tvar called_function\t\t\t= \"\";\n\tif(document.getElementById(\"called_function\")){\n\t\tcalled_function\t= document.getElementById(\"called_function\").value;\n\t}\n\tif(document.getElementById(\"isNewBornChngsAppl\")){\n\t\tisNewBornChngsAppl\t= document.getElementById(\"isNewBornChngsAppl\").value;\n\t}\n\tif(called_function==\"IP\" && isNewBornChngsAppl\t==\"true\"){\n\t\tvar fatherDtlsIndex\t\t= 1;\n\t\tvar newBornDtlsIndex\t= 0;\n\t}\n\t/*Added By Dharma End*/\n\t\tif((document.getElementById(\"op_call\") && document.getElementById(\"op_call\").value==\'OA\') && document.getElementById(\"sex\").disabled){\n\t\t\tdocument.getElementById(\"sex\").disabled=false;\n\t\t}\n\t\tif(obj.value != \"\"){\n\t\t\tif(obj.name==\"name_prefix\"){\n\t\t\t\tprefix_length=NamePrefixArray.length;\n\t\t\t\tfor(i = 0; i < prefix_length; i++){                      \n\t\t\t\t\tif(unescape(NamePrefixArray[i])==val){\t\t\t\n\t\t\t\t\t\tif(CalledFromFunction==\'FatherDtls\'){ \n\t\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\") && document.getElementById(\"name_prefix_oth_lang\")[fatherDtlsIndex]) { // Issue Fix AAKH-SCF-0011 [IN:037789]\n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\")[fatherDtlsIndex].value=unescape(NamePrefixLocArray[i]);\n\t\t\t\t\t\t\t} \n\t\t\t\t\t\t}else if(CalledFromFunction==\'NewbornDtls\'){\n\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\") && document.getElementById(\"name_prefix_oth_lang\")[newBornDtlsIndex]) { \n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\")[newBornDtlsIndex].value=unescape(NamePrefixLocArray[i]);\n\t\t\t\t\t\t\t} \t\t\t\t\n\t\t\t\t\t\t}else{ \n\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\")){ \n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\").value=unescape(NamePrefixLocArray[i]);\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(unescape(PrefixSexArray[i])!=\'B\')\n\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=unescape(PrefixSexArray[i]);\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=\"\"; \n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tprefix_length=NamePrefixLocArray.length;\n\t\t\t\tfor(i = 0; i < prefix_length; i++){                      \n\t\t\t\t\tif(unescape(NamePrefixLocArray[i])==val){\n\t\t\t\t\t\tif(CalledFromFunction==\'FatherDtls\'){ \n\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix\")[fatherDtlsIndex])\t\t\t\n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix\")[fatherDtlsIndex].value=unescape(NamePrefixArray[i]);\n\t\t\t\t\t\t}else if(CalledFromFunction==\'NewbornDtls\'){\n\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix\") && document.getElementById(\"name_prefix\")[newBornDtlsIndex])\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix\")[newBornDtlsIndex].value=unescape(NamePrefixArray[i]);\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix\"))\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix\").value=unescape(NamePrefixArray[i]); \n\t\t\t\t\t\t\tif(unescape(PrefixSexArray[i])!=\'B\')\n\t\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=unescape(PrefixSexArray[i]);\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=\"\";\n\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t}\n\t\t}else{\n\t\t\tif(CalledFromFunction==\'FatherDtls\') { \n\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\") && document.getElementById(\"name_prefix_oth_lang\")[fatherDtlsIndex])// Issue Fix AAKH-SCF-0011 [IN:037789]\n\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\")[fatherDtlsIndex].value=\"\";\n\t\t\t\tif(document.getElementById(\"name_prefix\")[fatherDtlsIndex])\n\t\t\t\t\tdocument.getElementById(\"name_prefix\")[fatherDtlsIndex].value=\"\";\n\t\t\t}else if(CalledFromFunction==\'NewbornDtls\') {\n\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\") && document.getElementById(\"name_prefix_oth_lang\")[newBornDtlsIndex])\n\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\")[newBornDtlsIndex].value=\"\";\n\t\t\t\tif(document.getElementById(\"name_prefix\")[newBornDtlsIndex])\n\t\t\t\t\tdocument.getElementById(\"name_prefix\")[newBornDtlsIndex].value=\"\";\n\t\t\t}else{\n\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\"))\n\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\").value=\"\";\n\t\t\t\tif(document.getElementById(\"name_prefix\"))\n\t\t\t\t\tdocument.getElementById(\"name_prefix\").value=\"\";\n\t\t\t\tdocument.getElementById(\"sex\").value=\"\";\n\t\t\t}\n\t\t}\n\t\tputLocalLangPatientName(\'\',CalledFromFunction);\n\t\tputPatientName(\'\',CalledFromFunction);\n\t}\n\n\tfunction sel_suffix_gen(obj,CalledFromFunction){\n\t\tvar val=obj.value;\n\t\tvar prefix_length;\n\t\tif(obj.value != \"\"){\n\t\tif(obj.name==\"name_suffix\"){\n\t\t\tprefix_length=NameSuffixArray.length;\n\t\t\tfor(i = 0; i < prefix_length; i++){                      \n\t\t\t\tif(unescape(NameSuffixArray[i])==val){\n\t\t\t\t\tif(CalledFromFunction==\'FatherDtls\') { \n\t\t\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\") && document.getElementById(\"name_suffix_oth_lang\")[0]) {\t// Issue Fix AAKH-SCF-0011 [IN:037789]\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\")[0].value=unescape(NameSuffixLocArray[i]);\n\t\t\t\t\t\t}\n\t\t\t\t\t}else if(CalledFromFunction==\'NewbornDtls\') {\n\t\t\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\") && document.getElementById(\"name_suffix_oth_lang\")[1]) {\t\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\")[1].value=unescape(NameSuffixLocArray[i]);\n\t\t\t\t\t\t}\n\t\t\t\t\t}else {\n\t\t\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\")) {\t\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\").value=unescape(NameSuffixLocArray[i]);\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(unescape(SuffixSexArray[i])!=\'B\')\n\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=unescape(SuffixSexArray[i]);\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=\"\";\n\t\t\t\t\t} \t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}else{\n\t\t\tprefix_length=NameSuffixLocArray.length;\n\t\t\tfor(i = 0; i < prefix_length; i++){                      \n\t\t\t\tif(unescape(NameSuffixLocArray[i])==val){\n\t\t\t\t\tif(CalledFromFunction==\'FatherDtls\') { \n\t\t\t\t\t\tif(document.getElementById(\"name_suffix\")[0]) {\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix\")[0].value = unescape(NameSuffixArray[i]);\n\t\t\t\t\t\t}\n\t\t\t\t\t} else if(CalledFromFunction==\'NewbornDtls\') {\n\t\t\t\t\t\tif(document.getElementById(\"name_suffix\") && document.getElementById(\"name_suffix\")[1]) {\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix\")[1].value = unescape(NameSuffixArray[i]);\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\n\t\t\t\t\t\tif(document.getElementById(\"name_suffix\")) {\n\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix\").value = unescape(NameSuffixArray[i]);\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(unescape(SuffixSexArray[i])!=\'B\')\n\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=unescape(SuffixSexArray[i]);\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tdocument.getElementById(\"sex\").value=\"\";\n\t\t\t\t\t}\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t} \n\t\t}else{\n\t\t\tif(CalledFromFunction==\'FatherDtls\') { \n\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\") && document.getElementById(\"name_suffix_oth_lang\")[0]) // Issue Fix AAKH-SCF-0011 [IN:037789]\n\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\")[0].value=\"\";\n\t\t\t\tif(document.getElementById(\"name_suffix\")[0])\n\t\t\t\t\tdocument.getElementById(\"name_suffix\")[0].value=\"\";\n\t\t\t}else if(CalledFromFunction==\'NewbornDtls\'){\n\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\") && document.getElementById(\"name_suffix_oth_lang\")[1])\n\t\t\t\t\tdocument.getElementBy";
    private final static byte[]  _wl_block3_0Bytes = _getBytes( _wl_block3_0 );

    private final static java.lang.String  _wl_block3_1 ="Id(\"name_suffix_oth_lang\")[1].value=\"\";\n\t\t\t\tif(document.getElementById(\"name_suffix\")[1])\n\t\t\t\t\tdocument.getElementById(\"name_suffix\")[1].value=\"\";\n\n\t\t\t}else{\n\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\"))\n\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\").value=\"\";\n\t\t\t\tif(document.getElementById(\"name_suffix\"))\n\t\t\t\t\tdocument.getElementById(\"name_suffix\").value=\"\";\n\t\t\t\tdocument.getElementById(\"sex\").value=\"\";\n\t\t\t}\n\t\t}\n\t\tputLocalLangPatientName(\'\',CalledFromFunction);\n\t\tputPatientName(\'\',CalledFromFunction);\n\t}\n\nfunction CheckForPipeChars(event){\n\t\tvar strCheck = \'|,~,=,#\';\t//Added by Sathish.S for 20824 on Thursday, April 22, 2010\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\t\tif (strCheck.indexOf(key) == -1) return true;  // Not a valid key\n\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\t\treturn (event.keyCode -= 32);\n\t\treturn false ;\n}\n\n/*\t\nfunction pipeCharsChk(elementRef)\n{\n var checkValue = new String(elementRef.value);\n var newValue = \'\'; \n for (var i=0; i<checkValue.length; i++)\n {\n  var currentChar = checkValue.charAt(i);\n\n  if (currentChar != \'|\')  \n   newValue += currentChar;\n }\n \n elementRef.value = newValue;\n}*/\n//Below line added for this SCF AAKH-SCF-0261\nfunction SpecialCharsChk(event){\n    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) ) \n\t\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n\nfunction isValidCharacter(elementRef) {   \n\t\n   var regExp =\"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+\";\n   var checkValue = new String(elementRef.value);     \n for (var i=0; i<checkValue.length; i++)\n {\t\n\tif (regExp.indexOf(checkValue.charAt(i)) == -1) {\t\n\t        var msg = getMessage(\"RES_MOB_NO_SPL_NOT_ALLOWED\",\'MP\');\n            elementRef.value = \"\";\n\t\t\talert(msg);\n\t\t\telementRef.focus();\n\t\t\treturn false;  \t\n\t\t  \n\t}\n\t  \n }  \n}\n\n//End AAKH-SCF-0261\n\n</SCRIPT>\n";
    private final static byte[]  _wl_block3_1Bytes = _getBytes( _wl_block3_1 );

    private final static java.lang.String  _wl_block4 ="\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_prompt\' id=\'name_prefix_prompt\' value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n\t\t\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<img id= \'name_prefix_img\' src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'></img>\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(document.forms[0].all.name_prefix_img.length > 0)\n\t\t\t\t\t\t\t\tdocument.forms[0].all.name_prefix_img[1].style.visibility=\'visible\';\n\t\t\t\t\t\t\telse \n\t\t\t\t\t\t\t\tdocument.forms[0].all.name_prefix_img.style.visibility=\'visible\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_reqd_yn\' id=\'name_prefix_reqd_yn\' value=\'Y\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(document.forms[0].all.name_prefix_img && document.forms[0].all.name_pfx_reqd_for_org_mem_yn.value==\'Y\') {\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].all.name_prefix_img.style.visibility=\'visible\';\n\t\t\t\t\t\t\t\t\t} else if(document.forms[0].all.name_prefix_img) {\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].all.name_prefix_img.style.visibility=\'hidden\';\n\t\t\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_reqd_yn\' id=\'name_prefix_reqd_yn\' value=\'Y\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_reqd_yn\' id=\'name_prefix_reqd_yn\' value=\'N\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<input type=\'hidden\' name=\'name_prefix_reqd_yn\' id=\'name_prefix_reqd_yn\' value=\'N\'></td> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<td class=\'label\'>&nbsp;</td>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_name_prompt\' id=\'first_name_prompt\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'N\'></input></td> \n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_name_prompt\' id=\'first_name_prompt\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<td class=\'label\' >&nbsp;</td>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'Y\'></input><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_name_prompt\' id=\'second_name_prompt\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'N\'></input>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_name_prompt\' id=\'second_name_prompt\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></td> ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'Y\'></input><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_name_prompt\' id=\'third_name_prompt\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'N\'></input>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_name_prompt\' id=\'third_name_prompt\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t\t\t</td> ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t<td  class=\'label\'  nowrap >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<img src=\'../../eCommon/images/mandatory.gif\'  style=\'visibility:visible;\'></img></td><input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'family_name_prompt\' id=\'family_name_prompt\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="  <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'N\'></input><input type=\'hidden\' name=\'family_name_prompt\' id=\'family_name_prompt\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'Y\'></input><img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible;\'></img></td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'family_name_prompt\' id=\'family_name_prompt\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'N\'></input></td> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'name_suffix_prompt\' id=\'name_suffix_prompt\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img><input type=\'hidden\' name=\'name_suffix_reqd_yn\' id=\'name_suffix_reqd_yn\' value=\'Y\'></input></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<input type=\'hidden\' name=\'name_suffix_reqd_yn\' id=\'name_suffix_reqd_yn\' value=\'N\'></input></td>\n\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t   ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="<input type=\'hidden\' name=\'name_suffix_reqd_yn\' id=\'name_suffix_reqd_yn\' value=\'N\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="<td class=\'label\' colspan=\'2\'>&nbsp;</td>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<td  class=\'fields\' ><Select name=\'name_prefix\' id=\'name_prefix\' onchange=\"sel_prefix_gen(this,\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\');putPatientName(this,\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');if (document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value==\'Y\'){getPatCategory();}\">\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t<td    class=\'fields\' ><Select name=\'name_prefix\' id=\'name_prefix\'  onchange=\"sel_prefix_gen(this,\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\');if (  document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value==\'Y\'){getPatCategory();}\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t<Option value=\'\'>------";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="------</option>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tprefix_length = NamePrefixArray.length;\n\t\t\t\t\t\t\t\tfor(i = 0; i < prefix_length; i++) {\n\t\t\t\t\t\t\t\t\topt = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\tname_pfx = unescape(NamePrefixArray[i]);\n\t\t\t\t\t\t\t\t\topt.text = name_pfx;\n\t\t\t\t\t\t\t\t\topt.value = name_pfx; \n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'==\'true\' && \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" == \"IP\"){\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'==\'NewbornDtls\') {\n\t\t\t\t\t\t\t\t\t\t\tif(document.forms[0].name_prefix){\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_prefix.options.add(opt);\t\t\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\t\tif(document.forms[0].name_prefix && document.forms[0].name_prefix[1])  {\n\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_prefix[1].options.add(opt);\t\t\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'==\'NewbornDtls\') {\n\t\t\t\t\t\t\t\t\t\t\tif(document.forms[0].name_prefix && document.forms[0].name_prefix[1])  {\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_prefix[1].options.add(opt);\t\t\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\t\tif(document.forms[0].name_prefix){\n\t\t\t\t\t\t\t\t\t\t\tdocument.forms[0].name_prefix.options.add(opt);\t\t\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t} \n\n\t\t                            //document.forms[0].name_prefix.add(opt);\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' == \'ChangePatDtls\' || \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"!=\'\') {\n\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' == \'ChangePatDtls\' && name_pfx == \"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\") {\n\t\t\t\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t\t\t\t} else if(name_pfx == \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\") {\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t</Select></td><td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif (document.forms[0].all.family_org_membership.value==\'1\')\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif (document.forms[0].all.name_prefix_img)\n\t\t\t\t\t\t\t\t\t\tdocument.forms[0].all.name_prefix_img.style.visibility=\'hidden\';\n\t\t\t\t\t\t\t\t\tdocument.forms[0].all.name_prefix.disabled=true;\n\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\telse if(document.forms[0].all.name_prefix_img)\n\t\t\t\t\t\t\t\t\tdocument.forms[0].all.name_prefix.disabled=false;\n\t\t\t\t\t\t</script>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t<td   class=\'fields\'  nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<input type=\'button\' style=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' class=\'button\' value=\'?\' onclick=\"callSearch(first_name,\'first_name_oth_lang\',\'English\',\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\')\" name=\'bf\'></td><td class=\'label\' ></td> ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' class=\'button\' value=\'?\' onclick=\"callSearch(second_name,\'second_name_oth_lang\',\'English\',\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\')\" name=\'bs\'></td><td class=\'label\' >&nbsp;</td>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' class=\'button\' value=\'?\' onclick=\"callSearch(third_name,\'third_name_oth_lang\',\'English\',\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\')\" name=\'bt\'></td><td class=\'label\' >&nbsp;</td> ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' class=\'button\' value=\'?\' onclick=\"callSearch(family_name,\'family_name_oth_lang\',\'English\',\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\')\" name=\'bfam\'> \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" \n\t\t\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t<td  class=\'label\'  ><Select name=\'name_suffix\' id=\'name_suffix\' onchange=\"sel_suffix_gen(this,\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\" ><Option value=\'\'>------";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="------</option>\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\tsuffix_length = NameSuffixArray.length;\n\t\t\t\t\t\t\t\tfor(i = 0; i < suffix_length; i++) {\n\t\t\t\t\t\t\t\t\topt = document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\tname_sfx = unescape(NameSuffixArray[i]);\n\t\t\t\t\t\t\t\t\topt.text = name_sfx;\n\t\t\t\t\t\t\t\t\topt.value = name_sfx; \n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'==\'NewbornDtls\') {\n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_suffix\") && document.getElementById(\"name_suffix\")[1])  \n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix\")[1].options.add(opt); \t\t \t\t\t\t\n\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_suffix\")) \n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix\").options.add(opt);\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\n\n\t\t                            //document.forms[0].name_suffix.add(opt);\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' == \'ChangePatDtls\' || \'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'!=\'\') {\n\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' == \'ChangePatDtls\' && name_sfx == \'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\') {\n\t\t\t\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t\t\t\t} else if(name_sfx == \'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\') {\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\n\t\t\t\t\t ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" \n\t\t</select></td> \n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t<script>\n\t\t\t\tif ( document.forms[0].all.name_prefix_oth_lang)\n\t\t\t\t{\n\t\t\t\t\tif ( (document.getElementById(\"family_org_membership\")) && (document.getElementById(\"family_org_membership\").value==\'1\')  ) \n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].all.name_prefix_oth_lang.disabled=true;\n\t\t\t\t\t}else{\n\t\t\t\t\t\tdocument.forms[0].all.name_prefix_oth_lang.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\'name_prefix_oth\' style=\'visibility:hidden;\'></img>\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t <script>\n\t\t\t\t\tif(document.getElementById(\"name_prefix_oth\").length > 0)\t{\n\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth\")[1])\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\")[1].style.visibility=\'visible\';\n\t\t\t\t\t} else { \t\t\t\t\t\t\n\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth\"))\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'visible\';\n\t\t\t\t\t}\n\t\t\t\t </script>\n\t\t\t\t <input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t<script>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif ((document.getElementById(\"name_prefix_oth\")) && (document.forms[0].all.name_pfx_reqd_for_org_mem_yn.value==\'Y\')) { \t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'visible\' \n\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'hidden\' \n\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_reqd_yn\' id=\'name_prefix_reqd_yn\' value=\'N\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" \n\t\t\t\t <input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'N\'></input>\n\t\t\t\t <script>\n\t\t\t\t\tif (document.getElementById(\"name_prefix_oth\").length > 0) {\n\t\t\t\t\t\tif (document.getElementById(\"name_prefix_oth\")[1]) {\t\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\")[1].style.visibility=\'hidden\'\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\n\t\t\t\t\t\tif (document.getElementById(\"name_prefix_oth\")) {  \n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'hidden\'\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t<input type=\'hidden\' name=\'name_prefix_oth_prompt\' id=\'name_prefix_oth_prompt\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="<input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'N\'></td> ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&nbsp;";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_oth_name_reqd_yn\' id=\'first_oth_name_reqd_yn\' value=\'Y\'></input><img\tid=\'first_oth\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'first_oth_name_reqd_yn\' id=\'first_oth_name_reqd_yn\' value=\'N\'><img\tid=\'first_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'first_name_oth_prompt\' id=\'first_name_oth_prompt\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t<td   class=\'label\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_oth_name_reqd_yn\' id=\'second_oth_name_reqd_yn\' value=\'Y\'></input><img id=\"sec_oth\" src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'second_oth_name_reqd_yn\' id=\'second_oth_name_reqd_yn\' value=\'N\'><img\tid=\'sec_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'second_name_oth_prompt\' id=\'second_name_oth_prompt\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"> \n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_oth_name_reqd_yn\' id=\'third_oth_name_reqd_yn\' value=\'Y\'></input><img id=\'third_oth\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'third_oth_name_reqd_yn\' id=\'third_oth_name_reqd_yn\' value=\'N\'><img\tid=\'third_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'third_name_oth_prompt\' id=\'third_name_oth_prompt\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'family_oth_name_reqd_yn\' id=\'family_oth_name_reqd_yn\' value=\'Y\'></input><img id=\'fam_oth\' src=\'../../eCommon/images/mandatory.gif\'  style=\'visibility:visible\'></img>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'family_oth_name_reqd_yn\' id=\'family_oth_name_reqd_yn\' value=\'N\'><img\tid=\'fam_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'family_name_oth_prompt\' id=\'family_name_oth_prompt\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>            \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="<td   class=\'label\' >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" <input type=\'hidden\' name=\'family_oth_name_reqd_yn\' id=\'family_oth_name_reqd_yn\' value=\'N\'><img\tid=\'fam_oth\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></input> ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t<td   class=\'label\'>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="<img src=\'../../eCommon/images/mandatory.gif\' id=\'name_suffix_oth\' style=\'visibility:hidden\'></img>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'name_suffix_oth_name_reqd_yn\' id=\'name_suffix_oth_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(document.forms[0].name_suffix_oth.length>0) {\n\t\t\t\t\t\t\t\tdocument.forms[0].name_suffix_oth[1].style.visibility=\'visible\'\n\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\tdocument.forms[0].name_suffix_oth.style.visibility=\'visible\'\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =" \n\t\t\t\t\t\t<input type=\'hidden\' name=\'name_suffix_oth_name_reqd_yn\' id=\'name_suffix_oth_name_reqd_yn\' value=\'N\'></input>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(document.forms[0].name_suffix_oth.length>0) {\n\t\t\t\t\t\t\t\tif(document.forms[0].name_suffix_oth[1])\n\t\t\t\t\t\t\t\t\tdocument.forms[0].name_suffix_oth[1].style.visibility=\'hidden\'\n\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\tif(document.forms[0].name_suffix_oth)\n\t\t\t\t\t\t\t\t\tdocument.forms[0].name_suffix_oth.style.visibility=\'hidden\'\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t<input type=\'hidden\' name=\'name_suffix_oth_prompt\' id=\'name_suffix_oth_prompt\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">          \n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="<input type=\'hidden\' name=\'name_suffix_oth_name_reqd_yn\' id=\'name_suffix_oth_name_reqd_yn\' value=\'N\'></td> ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="<td class=\'v\' colspan=\'2\'>&nbsp;</td>";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t</tr>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t<td class=\'fields\'   ><Select name=\'name_prefix_oth_lang\' id=\'name_prefix_oth_lang\' onchange=\'sel_prefix_gen(this,\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\");putLocalLangPatientName(this,\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\");if (document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();}\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t<td class=\'fields\'  ><Select name=\'name_prefix_oth_lang\' id=\'name_prefix_oth_lang\' onchange=\'sel_prefix_gen(this,\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\");if ( document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();}\' > \n\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t<Option value=\'\'>------";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="------</option>\n\n\t\t\t\t\t<script>\n\t\t\t\t\t\tprefix_loc_length = NamePrefixLocArrayTemp.length;//added By Sudhakar during UAT-3\n\t\t\t\t\t\t\tfor(i = 0; i < prefix_loc_length; i++) {\n\t\t\t\t\t\t\t\tloc_name_pfx = unescape(NamePrefixLocArrayTemp[i]);//added By Sudhakar during UAT-3\n\t\t\t\t\t\t\t\tif(loc_name_pfx!=\'\') {\n\n\t\t\t\t\t\t\t\t\topt = document.createElement(\"OPTION\");\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\topt.text = loc_name_pfx;\n\t\t\t\t\t\t\t\t\topt.value = loc_name_pfx; \n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'==\'NewbornDtls\') {\n\t\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\")) \n\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\").options.add(opt);\n\t\t\t\t\t\t\t\t\t\t}else { \n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\") && document.getElementById(\"name_prefix_oth_lang\")[1]) { \n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\")[1].options.add(opt);\n\t\t\t\t\t\t\t\t\t\t} \t\t\t\t\n\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'==\'NewbornDtls\') {\n\t\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\") && document.getElementById(\"name_prefix_oth_lang\")[1]) { \n\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\")[1].options.add(opt);\n\t\t\t\t\t\t\t\t\t\t\t} \t\t\t\t\n\t\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\")) \n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\").options.add(opt);\t\n\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t} \n\n\t\t\t\t\t\t\t\t\t//document.forms[0].name_prefix_oth_lang.add(opt);\n\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' == \'ChangePatDtls\' && loc_name_pfx == \"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\") {\n\t\t\t\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t\t\t\t} else if(loc_name_pfx == \"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\") {\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t</script> \n\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t</Select></td>\t<td class=\'label\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="<input type=\'button\' class=\'button\' value=\'?\' style=\'visibility:hidden\' onclick=\"document.forms[0].first_name_oth_lang.focus();callSearch(\'first_name_oth_lang\',\'first_name\',\'Others\',\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\')\" name=\'bfo\'>\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="<input type=\'button\' class=\'button\' style=\'visibility:hidden\' value=\'?\'onclick=\"callSearch(second_name_oth_lang,second_name,\'Others\',\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\')\" name=\'bso\'> \n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="<input type=\'button\' class=\'button\' value=\'?\' style=\'visibility:hidden\' onclick=\"callSearch(third_name_oth_lang,third_name,\'Others\',\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\')\" name=\'bto\'>\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="<input type=\'button\' class=\'button\' value=\'?\' style=\'visibility:hidden\' onclick=\"callSearch(family_name_oth_lang,family_name,\'Others\',\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\')\" name=\'bfamo\'>\n\t\t\t\t\t\t</td><td class=\'label\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t<td   class=\'label\'><Select name=\'name_suffix_oth_lang\' id=\'name_suffix_oth_lang\' onchange=\'sel_suffix_gen(this,\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\");\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t<td   class=\'label\'><Select name=\'name_suffix_oth_lang\' id=\'name_suffix_oth_lang\' onchange=\'sel_suffix_gen(this,\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\");\'>\n\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\n\t\t\t\t<script>\n\t\t\t\t\tsuffix_length = NameSuffixLocArrayTemp.length;//added By Sudhakar during UAT-3\n\t\t\t\t\tfor(i = 0; i < suffix_length; i++) {\n\t\t\t\t\t\topt = document.createElement(\"OPTION\");\n\t\t\t\t\t\tloc_name_sfx = unescape(NameSuffixLocArrayTemp[i]);//added By Sudhakar during UAT-3\n\t\t\t\t\t\topt.text = loc_name_sfx;\n\t\t\t\t\t\topt.value = loc_name_sfx; \n\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'==\'NewbornDtls\') {\n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\") && document.getElementById(\"name_suffix_oth_lang\")[1]) { \n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\")[1].options.add(opt);\n\t\t\t\t\t\t\t\t\t\t} \t\t\t\t\n\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\"))\n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\").options.add(opt);\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\n\t\t                //document.forms[0].name_suffix_oth_lang.add(opt);\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'!=\'\') {\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\' == \'ChangePatDtls\' && loc_name_sfx == \'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\') {\n\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t} else if(loc_name_sfx == \'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\') {\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t} \n\t\t\t\t\t\t}\t\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</tr>\n\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t<script>if (parent.frames[0].document.getElementById(\"patient_name_loc_lang\")) parent.frames[0].document.getElementById(\"patient_name_loc_lang\").style.visibility = \'visible\';</script>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t<td   class=\'arabic\'><img src=\'../../eCommon/images/mandatory.gif\' id=\'name_suffix_oth\' style=\'visibility:hidden\'></img>";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'name_suffix_oth_name_reqd_yn\' id=\'name_suffix_oth_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(document.forms[0].name_suffix_oth.length>0) {\n\t\t\t\t\t\t\t\tif(document.forms[0].name_suffix_oth[1])\n\t\t\t\t\t\t\t\t\tdocument.forms[0].name_suffix_oth[1].style.visibility=\'visible\'\n\t\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\t\tif(document.forms[0].name_suffix_oth)\n\t\t\t\t\t\t\t\t\tdocument.forms[0].name_suffix_oth.style.visibility=\'visible\'\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t\t\t<td  class=\'arabic\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t\t<td   class=\'arabic\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t\t\t\t</td><td class=\'arabic\' >&nbsp;</td> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\"> \n\t\t\t\t\t\t</td><td class=\'arabic\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t<td  class=\'arabic\'>&nbsp;";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t\t\t\t</td><td class=\'arabic\' >&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="<td   class=\'arabic\' >\n\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t<td class=\'arabic\'  ><img src=\'../../eCommon/images/mandatory.gif\' id=\'name_prefix_oth\' style=\'visibility:hidden;\'></img>&nbsp;";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\t\t\t  \t\t\t\n\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t <script>\t\n\t\t\t\t\tif(document.getElementById(\"name_prefix_oth\").length > 0)\t{\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth\")[1])\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\")[1].style.visibility=\'visible\';\n\t\t\t\t\t} else {\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth\"))\t\t\t\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'visible\';\n\t\t\t\t\t}\n\t\t\t\t </script>\n\t\t\t\t <input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t<script>\t\t\t\t\t\t\n\t\t\t\t\t\tif ((document.getElementById(\"name_prefix_oth\")) && (document.forms[0].all.name_pfx_reqd_for_org_mem_yn.value==\'Y\')) { \t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'visible\' \n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'hidden\' \n\t\t\t\t\t\t}\t\n\t\t\t\t\t</script>\n\t\t\t\t\t<input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =" \n\t\t\t\t <input type=\'hidden\' name=\'name_prefix_oth_name_reqd_yn\' id=\'name_prefix_oth_name_reqd_yn\' value=\'N\'></input>\n\t\t\t\t <script>\n\t\t\t\t\tif (document.getElementById(\"name_prefix_oth\").length>0) { \n\t\t\t\t\t\tif (document.getElementById(\"name_prefix_oth\")[1]) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\")[1].style.visibility=\'hidden\'\n\t\t\t\t\t\t}\n\t\t\t\t\t} else {\n\t\t\t\t\t\tif (document.getElementById(\"name_prefix_oth\")) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth\").style.visibility=\'hidden\'\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t</td>\n\t\t\t<td class=\'arabic\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t\t<td   class=\'arabic\'><Select name=\'name_suffix_oth_lang\' id=\'name_suffix_oth_lang\' onchange=\'sel_suffix_gen(this,\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\");putLocalLangPatientName(this),\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\";\' dir=\'RTL\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t<td   class=\'arabic\'><Select name=\'name_suffix_oth_lang\' id=\'name_suffix_oth_lang\' onchange=\'sel_suffix_gen(this,\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\");\' dir=\'RTL\'>\n\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\n\t\t\t\t<script>\n\t\t\t\t\tsuffix_length = NameSuffixLocArrayTemp.length;//added By Sudhakar during UAT-3\n\t\t\t\t\tfor(i = 0; i < suffix_length; i++) {\n\t\t\t\t\t\topt = document.createElement(\"OPTION\");\n\t\t\t\t\t\tloc_name_sfx = unescape(NameSuffixLocArrayTemp[i]);//added By Sudhakar during UAT-3\n\t\t\t\t\t\topt.text = loc_name_sfx;\n\t\t\t\t\t\topt.value = loc_name_sfx; \n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'==\'NewbornDtls\') {\n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\") && document.getElementById(\"name_suffix_oth_lang\")[1]) { \n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\")[1].options.add(opt);\n\t\t\t\t\t\t\t\t\t\t} \t\t\t\t\n\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_suffix_oth_lang\")) \n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_suffix_oth_lang\").options.add(opt);\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t                //document.forms[0].name_suffix_oth_lang.add(opt);\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t</td>\n\t\t\t<td class=\'arabic\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="<input type=\'button\' class=\'button\' value=\'?\' style=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' onclick=\"callSearch(family_name_oth_lang,family_name,\'Others\',\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' onclick=\"callSearch(third_name_oth_lang,third_name,\'Others\',\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="<input type=\'button\' class=\'button\' style=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' value=\'?\'onclick=\"callSearch(second_name_oth_lang,second_name,\'Others\',\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\' onclick=\"callSearch(first_name_oth_lang,first_name,\'Others\',\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t<td class=\'arabic\'   ><Select name=\'name_prefix_oth_lang\' id=\'name_prefix_oth_lang\' onchange=\'sel_prefix_gen(this,\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\");if (document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();}\' dir=\'RTL\'  >\n\t\t\t\t\t";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t<td class=\'arabic\'  ><Select name=\'name_prefix_oth_lang\' id=\'name_prefix_oth_lang\' onchange=\'sel_prefix_gen(this,\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\");if ( document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();}\' dir=\'RTL\' > \n\t\t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="------</option>\n\n\t\t\t\t\t<script>\n\t\t\t\t\t\tprefix_loc_length = NamePrefixLocArrayTemp.length;//added By Sudhakar during UAT-3\n\t\t\t\t\t\t\tfor(i = 0; i < prefix_loc_length; i++) {\n\t\t\t\t\t\t\t\tloc_name_pfx = unescape(NamePrefixLocArrayTemp[i]);//added By Sudhakar during UAT-3\n\t\t\t\t\t\t\t\tif(loc_name_pfx!=\'\') {\n\n\t\t\t\t\t\t\t\t\topt = document.createElement(\"OPTION\");\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\topt.text = loc_name_pfx;\n\t\t\t\t\t\t\t\t\topt.value = loc_name_pfx;\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" == \"IP\"){\n\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\'==\'NewbornDtls\') {\n\t\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\")) \n\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\").options.add(opt);\t\n\t\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\") && document.getElementById(\"name_prefix_oth_lang\")[1]) { \n\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\")[1].options.add(opt);\n\t\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'==\'NewbornDtls\') {\n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\") && document.getElementById(\"name_prefix_oth_lang\")[1]) { \n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\")[1].options.add(opt);\n\t\t\t\t\t\t\t\t\t\t} \t\t\t\t\n\t\t\t\t\t\t\t\t\t} else { \n\t\t\t\t\t\t\t\t\t\tif(document.getElementById(\"name_prefix_oth_lang\")) \n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"name_prefix_oth_lang\").options.add(opt);\t\t\t\n\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t//document.forms[0].name_prefix_oth_lang.add(opt);\n\n\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\") {\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\topt.selected=true;\n\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="</Select></td>\t<!-- <td class=\'label\'>&nbsp;</td> -->\n\t\t\t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\t\t\t<input type=\'hidden\' name=\'language_direction\' id=\'language_direction\' value=";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 =">\n\t\t\t<input type=\'hidden\' name=\'pat_names_in_oth_lang_yn\' id=\'pat_names_in_oth_lang_yn\' value=";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =">\t\t\n\t\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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
            _bw.write(_wl_block3_0Bytes, _wl_block3_0);
            _bw.write(_wl_block3_1Bytes, _wl_block3_1);
 
    Connection conn			= null;
	PreparedStatement pstmt=null ;
	
    ResultSet rs=null ;
	try
	{
	String language_direction = "";
	String name_comp_visibility = "visibility:hidden";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_id=checkForNull((String)session.getAttribute("facility_id")); //added for the incident 34901

	int count=0;


	Properties p					=	 (java.util.Properties) session.getValue("jdbc");
	conn							=	 ConnectionManager.getConnection(request);
 	HashMap hash_Map				=	 new HashMap();
 	HashMap hash_Map1				=	 new HashMap();
	HashMap Name_Order 			=	 new HashMap(); 
	String downtime_regn_yn		= "N";//Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724]

		pstmt = conn.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
		 
		rs = pstmt.executeQuery() ;
             
			
        if ( rs != null && rs.next() ) 
		 {
		  count = rs.getInt("total");
		 }

		
		if ( count==1 ) 
		{
			 language_direction = "R" ;
			 name_comp_visibility = "visibility:visible";
		}else
		{
			 language_direction = "L" ;
			 name_comp_visibility = "visibility:hidden";
		}


		 if(pstmt != null) pstmt.close();
		 if(rs != null) rs.close();


	String patient_id					= checkForNull(request.getParameter("patient_id"));
	String mother_patient_id			= checkForNull(request.getParameter("mother_patient_id"));
	String populatenewBornDtls			= checkForNull(request.getParameter("populatenewBornDtls"),"N");
	String group						= checkForNull(request.getParameter("group"));
	String CalledFromFunction			= checkForNull(request.getParameter("CalledFromFunction"));
	String isNewBornChngsAppl			= checkForNull(request.getParameter("isNewBornChngsAppl"),"false");
	String calling_module_id			= checkForNull(request.getParameter("calling_module_id"));
	String a_name_prefix				= checkForNull(request.getParameter("a_name_prefix"));
	
	String a_name_suffix				= checkForNull(request.getParameter("a_name_suffix"));
	String a_family_name				= checkForNull(request.getParameter("a_family_name"));
	String a_first_name					= checkForNull(request.getParameter("a_first_name"));
	
	String a_second_name				= checkForNull(request.getParameter("a_second_name"));
	String a_third_name					= checkForNull(request.getParameter("a_third_name"));

	String a_name_prefix_loc_lang		= checkForNull(request.getParameter("a_name_prefix_loc_lang"));
	String a_first_name_loc_lang		= checkForNull(request.getParameter("a_first_name_loc_lang"));
	String a_second_name_loc_lang		= checkForNull(request.getParameter("a_second_name_loc_lang"));
	String a_third_name_loc_lang		= checkForNull(request.getParameter("a_third_name_loc_lang"));
	String a_family_name_loc_lang		= checkForNull(request.getParameter("a_family_name_loc_lang"));
	String a_name_suffix_loc_lang		= checkForNull(request.getParameter("a_name_suffix_loc_lang"));	 	
	String nb_father_name_mandatory_yn	= "";


	String Name_Prefix_Accept_Yn		= checkForNull(request.getParameter("Name_Prefix_Accept_Yn"));
	String Name_Prefix_Reqd_Yn			= checkForNull(request.getParameter("Name_Prefix_Reqd_Yn"));
	String Name_Suffix_Accept_Yn		= checkForNull(request.getParameter("Name_Suffix_Accept_Yn"));
	String Name_Suffix_Reqd_Yn			= checkForNull(request.getParameter("Name_Suffix_Reqd_Yn"));
	String First_Name_Accept_Yn			= checkForNull(request.getParameter("First_Name_Accept_Yn"));
	String First_Name_Prompt			= checkForNull(request.getParameter("First_Name_Prompt"));
	String First_Name_Reqd_Yn			= checkForNull(request.getParameter("First_Name_Reqd_Yn"));
	String Second_Name_Accept_Yn		= checkForNull(request.getParameter("Second_Name_Accept_Yn"));
	String Second_Name_Prompt			= checkForNull(request.getParameter("Second_Name_Prompt"));
	String Third_Name_Accept_Yn			= checkForNull(request.getParameter("Third_Name_Accept_Yn"));
	String Third_Name_Prompt			= checkForNull(request.getParameter("Third_Name_Prompt"));
	String Family_Name_Accept_Yn		= checkForNull(request.getParameter("Family_Name_Accept_Yn"));
	String Family_Name_Prompt			= checkForNull(request.getParameter("Family_Name_Prompt"));
	String Second_Name_Reqd_Yn			= checkForNull(request.getParameter("Second_Name_Reqd_Yn"));
	String Third_Name_Reqd_Yn			= checkForNull(request.getParameter("Third_Name_Reqd_Yn"));
	String Family_Name_Reqd_Yn			= checkForNull(request.getParameter("Family_Name_Reqd_Yn"));
	String pat_name_as_multipart_yn		= checkForNull(request.getParameter("pat_name_as_multipart_yn"));
	String family_org_id_accept_yn		= checkForNull(request.getParameter("family_org_id_accept_yn "));
	String Name_Suffix_Prompt			= checkForNull(request.getParameter("Name_Suffix_Prompt"));
	String Name_Prefix_Prompt			= checkForNull(request.getParameter("Name_Prefix_Prompt"));
	String Family_Name_Order			= checkForNull(request.getParameter("Family_Name_Order"));
	String First_Name_Order			= checkForNull(request.getParameter("First_Name_Order"));
	String Second_Name_Order			= checkForNull(request.getParameter("Second_Name_Order"));
	String Third_Name_Order			= checkForNull(request.getParameter("Third_Name_Order"));	
	String first_name_length			= checkForNull(request.getParameter("first_name_length"),"0");
	String second_name_length			= checkForNull(request.getParameter("second_name_length"),"0");
	String third_name_length			= checkForNull(request.getParameter("third_name_length"),"0");
	String family_name_length			= checkForNull(request.getParameter("family_name_length"),"0");	
	String family_name_loc_lang_prompt = checkForNull(request.getParameter("family_name_loc_lang_prompt"));
	String pat_name_in_loc_lang_reqd_yn = checkForNull(request.getParameter("pat_name_in_loc_lang_reqd_yn"),"N");
	String name_suffix_loc_lang_prompt = checkForNull(request.getParameter("name_suffix_loc_lang_prompt"));
	String first_name_loc_lang_prompt = checkForNull(request.getParameter("first_name_loc_lang_prompt"));
	String second_name_loc_lang_prompt = checkForNull(request.getParameter("second_name_loc_lang_prompt"));
	String third_name_loc_lang_prompt = checkForNull(request.getParameter("third_name_loc_lang_prompt"));
	String name_prefix_loc_lang_prompt = checkForNull(request.getParameter("name_prefix_loc_lang_prompt"));		
	String names_in_oth_lang_yn = checkForNull(request.getParameter("names_in_oth_lang_yn"),"N");


	if(CalledFromFunction!=null && CalledFromFunction.equals("FatherDtls")){

		nb_father_name_mandatory_yn = checkForNull(request.getParameter("nb_father_name_mandatory_yn"),"N");
		/*
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select nb_father_name_mandatory_yn from mp_param where module_id='MP'");
		if(rs!=null && rs.next()){					
			nb_father_name_mandatory_yn=rs.getString("nb_father_name_mandatory_yn")==null?"N":rs.getString("nb_father_name_mandatory_yn");
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		*/
	}

	if(CalledFromFunction!=null && !CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {

		hash_Map	= eMP.ChangePatientDetails.getSetupData(facility_id,group, conn,p);

		Name_Prefix_Accept_Yn		= checkForNull((String) hash_Map.get("Name_Prefix_Accept_Yn"));
		Name_Prefix_Reqd_Yn			= checkForNull((String) hash_Map.get("Name_Prefix_Reqd_Yn"));
		Name_Suffix_Accept_Yn		= checkForNull((String) hash_Map.get("Name_Suffix_Accept_Yn"));
		Name_Suffix_Reqd_Yn			= checkForNull((String) hash_Map.get("Name_Suffix_Reqd_Yn"));
		First_Name_Accept_Yn			= checkForNull((String) hash_Map.get("First_Name_Accept_Yn"));
		First_Name_Prompt			= checkForNull((String) hash_Map.get("First_Name_Prompt"));
		First_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("First_Name_Reqd_Yn"));
		Second_Name_Accept_Yn		= checkForNull((String) hash_Map.get("Second_Name_Accept_Yn"));
		Second_Name_Prompt			= checkForNull((String) hash_Map.get("Second_Name_Prompt"));
		Third_Name_Accept_Yn			= checkForNull((String) hash_Map.get("Third_Name_Accept_Yn"));
		Third_Name_Prompt			= checkForNull((String) hash_Map.get("Third_Name_Prompt"));
		Family_Name_Accept_Yn		= checkForNull((String) hash_Map.get("Family_Name_Accept_Yn"));
		Family_Name_Prompt			= checkForNull((String) hash_Map.get("Family_Name_Prompt"));

		Second_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Second_Name_Reqd_Yn"));
		Third_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Third_Name_Reqd_Yn"));
		Family_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Family_Name_Reqd_Yn"));
		pat_name_as_multipart_yn		= checkForNull((String) hash_Map.get("pat_name_as_multipart_yn"));
		family_org_id_accept_yn		= checkForNull((String) hash_Map.get("family_org_id_accept_yn "));
		Name_Suffix_Prompt			= checkForNull((String) hash_Map.get("Name_Suffix_Prompt"));
		Name_Prefix_Prompt			= checkForNull((String) hash_Map.get("Name_Prefix_Prompt"));
		Family_Name_Order			= checkForNull((String) hash_Map.get("Family_Name_Order"));
		First_Name_Order			= checkForNull((String) hash_Map.get("First_Name_Order"));
		Second_Name_Order			= checkForNull((String) hash_Map.get("Second_Name_Order"));
		Third_Name_Order			= checkForNull((String) hash_Map.get("Third_Name_Order")); 	
		first_name_length			= checkForNull((String) hash_Map.get("first_name_length"),"0");
		second_name_length			= checkForNull((String) hash_Map.get("second_name_length"),"0");
		third_name_length			= checkForNull((String) hash_Map.get("third_name_length"),"0");
		family_name_length			= checkForNull((String) hash_Map.get("family_name_length"),"0"); 
		names_in_oth_lang_yn		= checkForNull((String)hash_Map.get("names_in_oth_lang_yn"),"N");
	}

	if((CalledFromFunction!=null && CalledFromFunction.equals("FatherDtls")) && nb_father_name_mandatory_yn.equals("N")){
		//name component settings for father details in new born
		Name_Prefix_Reqd_Yn="N";
		Name_Suffix_Reqd_Yn="N";
		First_Name_Reqd_Yn="N";
		Second_Name_Reqd_Yn="N";
		Third_Name_Reqd_Yn="N";
		Family_Name_Reqd_Yn="N";
	}
	/* Added for HSA-CRF-0192 [IN:049807] By Dharma on 15th Oct 2014 Start*/
	String familyNametextBoxSize	= "20";
	if(!First_Name_Accept_Yn.equals("Y") && !Second_Name_Accept_Yn.equals("Y") && !Third_Name_Accept_Yn.equals("Y") && Family_Name_Accept_Yn.equals("Y")){
		
		familyNametextBoxSize	= family_name_length;

	}
	/* Added for HSA-CRF-0192 [IN:049807] By Dharma on 15th Oct 2014 End*/



	 /* Prompts and Orders are placed in Hash Map for easy retrieval */
	Name_Order.put(Family_Name_Order,"Family_Name_Order");
	Name_Order.put(First_Name_Order,"First_Name_Order");
	Name_Order.put(Second_Name_Order,"Second_Name_Order");
	Name_Order.put(Third_Name_Order,"Third_Name_Order");

	String name_suffix			= "";
	String name_prefix			= "";
	String family_name		= "";
	String first_name			= "";
	String second_name		= "";
	String third_name			= "";

	int		 emptyCnt			= 0;  /*To Count the Missing Name Fields as per MP Param*/

	ArrayList arrayList2 = new ArrayList();
	arrayList2 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix",p);
	out.println("<script>");
	int a = 0;
	Set set = new HashSet();//added By Sudhakar during UAT-3
	for(int i=0;i<arrayList2.size();i+=3) 
	{
		set.add((String)arrayList2.get(i+1));//added By Sudhakar during UAT-3
		out.print("NamePrefixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
		out.print("NamePrefixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
		out.print("PrefixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
		a++;
	} 
	//added By Sudhakar during UAT-3 starts
	Set sortedSet = new TreeSet(set);	
	Iterator iterator = sortedSet.iterator();
	a = 0;
	while(iterator.hasNext()){
		String prefix_loc=(String)iterator.next();
		out.print("NamePrefixLocArrayTemp["+a+"]=escape(\""+prefix_loc+"\");");
		a++;
	}
	set.clear();
	sortedSet.clear();
	//added By Sudhakar during UAT-3 ends
	out.println("</script>");
	arrayList2.clear();
	arrayList2 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix2",p);
	out.println("<script>");
	a = 0;
	for(int i=0;i<arrayList2.size();i+=3) 
	{
		set.add((String)arrayList2.get(i+1));//added By Sudhakar during UAT-3
		out.print("NameSuffixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
		out.print("NameSuffixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
		out.print("SuffixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
		a++;
	} 
	//added By Sudhakar during UAT-3 starts
	sortedSet = new TreeSet(set);	
	iterator = sortedSet.iterator();
	a = 0;
	while(iterator.hasNext()){
		String suffix_loc=(String)iterator.next();
		out.print("NameSuffixLocArrayTemp["+a+"]=escape(\""+suffix_loc+"\");");
		a++;
	}
	//added By Sudhakar during UAT-3 ends
	out.println("</script>");
	
	if(CalledFromFunction.equals("ChangePatDtls")) 
	{
		 hash_Map1				= eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);
		/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] Start*/
		 downtime_regn_yn=checkForNull((String) hash_Map1.get("downtime_regn_yn"));
     	if(checkForNull((String)hash_Map1.get("regn_date")).equals("") && downtime_regn_yn.equals("Y")){
			hash_Map1.put("name_suffix","");
			hash_Map1.put("first_name","");
			hash_Map1.put("second_name","");
			hash_Map1.put("third_name","");
			hash_Map1.put("family_name","");
		
		}
		/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] End*/
		 
		 name_suffix			= checkForNull((String) hash_Map1.get("name_suffix"));
		 name_prefix			= checkForNull((String) hash_Map1.get("name_prefix"));
		 first_name				= checkForNull((String) hash_Map1.get("first_name"));
		 second_name			= checkForNull((String) hash_Map1.get("second_name"));
		 third_name				= checkForNull((String) hash_Map1.get("third_name"));
		 family_name			= checkForNull((String) hash_Map1.get("family_name"));
	}
	if(CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N")) {
		 hash_Map1				= eMP.ChangePatientDetails.getPatientData(mother_patient_id, conn,p);
		 //name_suffix			= checkForNull((String) hash_Map1.get("name_suffix"));
		 //name_prefix			= checkForNull((String) hash_Map1.get("name_prefix"));
		 /*first_name			= checkForNull((String) hash_Map1.get("first_name"));
		 second_name			= checkForNull((String) hash_Map1.get("second_name"));
		 third_name				= checkForNull((String) hash_Map1.get("third_name"));
		 family_name			= checkForNull((String) hash_Map1.get("family_name"));*/
	}

            _bw.write(_wl_block4Bytes, _wl_block4);

				if(Name_Prefix_Accept_Yn.equals("Y")) 
				{ 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(Name_Prefix_Prompt));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Name_Prefix_Prompt));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
					if ( (Name_Prefix_Reqd_Yn.equals("Y")) || (( checkForNull((String)hash_Map1.get("MembershipType"))).equals("1")))
					{ 
						if ( Name_Prefix_Reqd_Yn.equals("Y")) {
						
            _bw.write(_wl_block8Bytes, _wl_block8);

						} else {
							// Added by Muthu on 23/01/2010 against incident IN018465 to correct the issue prefix should not be mandatory for newborn and father patient ids even though name_pfx_reqd_for_org_mem_yn is set to Y in MP Param 
							if(!CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {	
						
            _bw.write(_wl_block9Bytes, _wl_block9);

							} else {
								
            _bw.write(_wl_block10Bytes, _wl_block10);

							}
							// End of Comment
						}
            _bw.write(_wl_block11Bytes, _wl_block11);
					}
					else
					{ 
						
            _bw.write(_wl_block12Bytes, _wl_block12);
 
					}
					
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
				
			/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
			   if  (pat_name_as_multipart_yn.equals("Y"))
			   {
				     String order = "";
					 for(int i=1;i<=4;++i)
					 {
						 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

						
						 if (order.equals("First_Name_Order"))
						 {
							if(First_Name_Accept_Yn.equals("Y")) 
							{ 
								
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block15Bytes, _wl_block15);

								if(First_Name_Reqd_Yn.equals("Y")) 
								{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block17Bytes, _wl_block17);
} else { 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block19Bytes, _wl_block19);
 }
									
            _bw.write(_wl_block20Bytes, _wl_block20);

							}
							 else
								emptyCnt++;						 
						 }
						 else
						 if (order.equals("Second_Name_Order"))
						 {
							 if(Second_Name_Accept_Yn.equals("Y")) 
							{
								
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block15Bytes, _wl_block15);
 if(Second_Name_Reqd_Yn.equals("Y")) { 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } else { 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block24Bytes, _wl_block24);
 }
								
            _bw.write(_wl_block20Bytes, _wl_block20);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Third_Name_Order"))
						 {
							 if (Third_Name_Accept_Yn.equals("Y") )
							{ 
								
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(Third_Name_Reqd_Yn.equals("Y")) { 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } else { 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block28Bytes, _wl_block28);
 }
								
            _bw.write(_wl_block20Bytes, _wl_block20);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Family_Name_Order"))
						 {
							 if (Family_Name_Accept_Yn.equals("Y") ) 
							{  
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block15Bytes, _wl_block15);

									 if(Family_Name_Reqd_Yn.equals("Y")) { 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block31Bytes, _wl_block31);
 } else { 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block24Bytes, _wl_block24);
 }
								  
            _bw.write(_wl_block20Bytes, _wl_block20);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 {
							 emptyCnt++;
						 }
					}
			   }else{	   

					if(Family_Name_Accept_Yn.equals("Y")) 
					{ 
						
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block34Bytes, _wl_block34);
  if(Family_Name_Reqd_Yn.equals("Y")) { 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block36Bytes, _wl_block36);
 	} else { 
            _bw.write(_wl_block37Bytes, _wl_block37);
 }
					}
				}
					/*  if (pat_name_as_multipart_yn.equals("Y") */
				if(Name_Suffix_Accept_Yn.equals("Y")) 
				{ 
					
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Name_Suffix_Prompt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Name_Suffix_Prompt));
            _bw.write(_wl_block40Bytes, _wl_block40);

					if(Name_Suffix_Reqd_Yn.equals("Y")) 
					{ 
						
            _bw.write(_wl_block41Bytes, _wl_block41);
 }else{
            _bw.write(_wl_block42Bytes, _wl_block42);
	 }
				}else{		
					if(Name_Prefix_Accept_Yn.equals("Y")){
						emptyCnt++;
					}
					
            _bw.write(_wl_block43Bytes, _wl_block43);

				}
				 /*To fill the blank spaces in the table with blank TDs*/
				for(int j=1;j<=emptyCnt;++j)
					{
            _bw.write(_wl_block44Bytes, _wl_block44);
}
				
            _bw.write(_wl_block45Bytes, _wl_block45);
	
				if(Name_Prefix_Accept_Yn.equals("Y"))
				{
					if(pat_name_as_multipart_yn.equals("N")) 
					{
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
					else
					{ 
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block50Bytes, _wl_block50);
 
					}
					
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(a_name_prefix));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(a_name_prefix));
            _bw.write(_wl_block61Bytes, _wl_block61);
 /*
						array_List1 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix0",p);
						for(int i=0;i<array_List1.size();i++) {
						out.print("<Option value=\"" + (String)array_List1.get(i) + "\"" );
						if(CalledFromFunction.equals("ChangePatDtls") || !a_name_prefix.equals(""))
						{
							if((CalledFromFunction.equals("ChangePatDtls")) && ((String)array_List1.get(i)).equals(name_prefix)) 
								out.print(" selected >"+(String)array_List1.get(i)+"</option>");
							else if(((String)array_List1.get(i)).equals(a_name_prefix))
								out.print(" selected >"+(String)array_List1.get(i)+"</option>");
							else  out.print(" > " + (String)array_List1.get(i)+"</option>");
						} else out.print(" > " + (String)array_List1.get(i)+"</option>");
						} 
						*/
						
            _bw.write(_wl_block62Bytes, _wl_block62);

					if  (CalledFromFunction.equals("ChangePatDtls") && family_org_id_accept_yn.equals("Y"))
					{ 
            _bw.write(_wl_block63Bytes, _wl_block63);
}
						}
						else
						{	
						}
			  
			    emptyCnt = 0;

			   	if (pat_name_as_multipart_yn.equals("Y") )
				{
					 String order = "";
					 for(int i=1;i<=4;++i)
					 {
						 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

						

						 if (order.equals("First_Name_Order"))
						 {
							if(First_Name_Accept_Yn.equals("Y")) 
							{ 
								
            _bw.write(_wl_block64Bytes, _wl_block64);

								out.print("<input type='text' name='first_name' id='first_name' maxlength='"+first_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)'   onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
								if(names_in_oth_lang_yn.equals("Y")){
									out.print("populateLocalValues(this,first_name,first_name_oth_lang,'E','"+CalledFromFunction+"')");
								}
								if(CalledFromFunction.equals("ChangePatDtls") || !a_first_name.equals("") || CalledFromFunction.equals("NewbornDtls"))
								{
									if(CalledFromFunction.equals("ChangePatDtls") || (CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N")))
									{
										if(!(((String)hash_Map1.get("first_name")).equals("")))
											out.print(" value=\""+(String)hash_Map1.get("first_name")+"\">");
										else out.print(" value=\"\" >"); 
									} 
									else if(!a_first_name.equals(""))
										out.print(" value=\""+a_first_name+"\">");
									else out.print(" value=\"\" >"); 
								}
								else out.print(" value = \"\" >");
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block67Bytes, _wl_block67);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Second_Name_Order"))
						 {
							 if (Second_Name_Accept_Yn.equals("Y")) 
							{ 
								
            _bw.write(_wl_block64Bytes, _wl_block64);
  out.print("<input type='text' name='second_name' id='second_name' maxlength='"+second_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
								if(names_in_oth_lang_yn.equals("Y")){
									out.print("populateLocalValues(this,second_name,second_name_oth_lang,'E','"+CalledFromFunction+"')");
								}
								if(CalledFromFunction.equals("ChangePatDtls") || !a_second_name.equals("") || CalledFromFunction.equals("NewbornDtls"))
								{
									if(CalledFromFunction.equals("ChangePatDtls") || (CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N")))
									{
										if (!(((String)hash_Map1.get("second_name"))).equals(""))
											out.print(" value=\""+checkForNull((String)hash_Map1.get("second_name"))+"\">");
										else out.print(" value = \"\" >");
									}
									else if(!a_second_name.equals(""))
									{
										out.print(" value=\""+a_second_name+"\">");
									}
									else out.print(" value = \"\" >");
								} else out.print(" value = \"\" >");
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block69Bytes, _wl_block69);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Third_Name_Order"))
						 {
							if(Third_Name_Accept_Yn.equals("Y")) 
							{ 
								
            _bw.write(_wl_block70Bytes, _wl_block70);
  out.print("<input type='text' name='third_name' id='third_name' maxlength='"+third_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)'   onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
								if(names_in_oth_lang_yn.equals("Y")){
									out.print("populateLocalValues(this,third_name,third_name_oth_lang,'E','"+CalledFromFunction+"')");
								}
								if(CalledFromFunction.equals("ChangePatDtls") || !a_third_name.equals("") || CalledFromFunction.equals("NewbornDtls"))
								{
									if(CalledFromFunction.equals("ChangePatDtls") || (CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N")))
									{
										if(!(((String)hash_Map1.get("third_name")).equals("")))
											out.print(" value=\""+(String)hash_Map1.get("third_name")+"\">");
										else out.print(" value = \"\" >");    
									}
									else if(!a_third_name.equals(""))
									{
										out.print(" value=\""+a_third_name+"\">");
									}
									else out.print(" value = \"\" >");    
								}else out.print(" value = \"\" >");
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block72Bytes, _wl_block72);

							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Family_Name_Order"))
						 {
							 if(Family_Name_Accept_Yn.equals("Y")) 
							{   
								out.print("<td  class='fields'  nowrap><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)'  onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
								if(names_in_oth_lang_yn.equals("Y")){
									out.print("populateLocalValues(this,family_name,family_name_oth_lang,'E','"+CalledFromFunction+"')");
								}
								if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name.equals("") || CalledFromFunction.equals("NewbornDtls"))
								{
								if((CalledFromFunction.equals("ChangePatDtls") || (CalledFromFunction.equals("NewbornDtls") && populatenewBornDtls.equals("N"))) && !(((String)hash_Map1.get("family_name")).equals("")))
										
									out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
									else if(!a_family_name.equals(""))
										out.print(" value=\""+a_family_name+"\">");
									else out.print(" value = \"\" >");    
								} else out.print(" value = \"\" >");    
								if (pat_name_as_multipart_yn.equals("Y")) { 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block74Bytes, _wl_block74);
 } 
            _bw.write(_wl_block75Bytes, _wl_block75);
 
							}
							else
							{
								emptyCnt++;
							}
						 }
						  else
						  {
							 emptyCnt++;
						  }
						}
			}
			/* END of	if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
				//new
				if(Family_Name_Accept_Yn.equals("Y"))  
			    { 
				out.print("<td class='fields' nowrap ><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'"+CalledFromFunction+"');");
				}
				
				if(CalledFromFunction.equals("ChangePatDtls") && Family_Name_Accept_Yn.equals("Y") || !a_family_name.equals("") &&Family_Name_Accept_Yn.equals("Y"))
				{   
					
					if( (CalledFromFunction.equals("ChangePatDtls")) && !(((String)hash_Map1.get("family_name")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
					else if(!a_family_name.equals(""))
						out.print(" value=\""+a_family_name+"\" >");
					else out.print(" value = \"\" >");   
				}  
				else if(Family_Name_Accept_Yn.equals("Y"))
				{	//Monday, December 27, 2010 
					/*This else part is modified to populate the Family name even if Multipart is Unchecked
						Added by Rameswar on  05-05-2016 for ML-MMOH-SCF-0336 Start
					*/
					if(CalledFromFunction.equals("NewbornDtls")|| !a_family_name.equals(""))
					{
					if( (CalledFromFunction.equals("NewbornDtls")) && !(((String)hash_Map1.get("family_name")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
					else if(!a_family_name.equals(""))
						out.print(" value=\""+a_family_name+"\" >");
					else 
					out.print(" value = \"\" >"); 
						/*Added by Rameswar on  05-05-2016 for ML-MMOH-SCF-0336 End*/
						out.println("<input type = 'hidden' name = 'Family_Name_Prompt' value='"+Family_Name_Prompt+"'>");
					} //Monday, December 27, 2010
					else{/*Added by Rameswar on  19-10-2016 for ML-MMOH-SCF-0530 End*/
						out.print(" value = \"\" >"); 
						out.println("<input type = 'hidden' name = 'Family_Name_Prompt' value='"+Family_Name_Prompt+"'>");
					}
				
            _bw.write(_wl_block76Bytes, _wl_block76);

				}
					
			 }
			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{  	
			 
					
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(a_name_suffix));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf((String)hash_Map1.get("name_suffix")));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(a_name_suffix));
            _bw.write(_wl_block85Bytes, _wl_block85);
 
						/* 
						 array_List.clear();
					array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix",p);
					for(int i=0;i<array_List.size();i++) {
					 out.print("<Option value=\""+(String)array_List.get(i)+"\"");
					if(CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix.equals(""))
					{  
						if((CalledFromFunction.equals("ChangePatDtls")) && ((String)array_List.get(i)).equals((String)hash_Map1.get("name_suffix")) )
							out.print(" selected >");
						else if(((String)array_List.get(i)).equals(a_name_suffix))
							out.print(" selected >");
						else out.print(" value=\"\" >");     
					} else out.print(" value=\"\" >");     
					out.print((String)array_List.get(i)+"</option>");
				} 
				*/
		//  }
		
            _bw.write(_wl_block86Bytes, _wl_block86);

		}
		else
		{
			if(Name_Prefix_Accept_Yn.equals("Y")) 
			{
				emptyCnt++;
			}
		}
		 /*To fill the blank spaces in the table with blank TDs*/
		for(int j=1;j<=emptyCnt;++j)
			{
            _bw.write(_wl_block44Bytes, _wl_block44);
}
		
            _bw.write(_wl_block87Bytes, _wl_block87);

		if (CalledFromFunction.equals("ChangePatDtls") ) { 
            _bw.write(_wl_block88Bytes, _wl_block88);
 }
	//String names_in_oth_lang_yn	= checkForNull(request.getParameter("names_in_oth_lang_yn"));

	if(CalledFromFunction!=null && !CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {
		
		family_name_loc_lang_prompt = checkForNull((String) hash_Map.get("family_name_loc_lang_prompt")); 		
		name_suffix_loc_lang_prompt = checkForNull((String)hash_Map.get("name_suffix_loc_lang_prompt"));
		first_name_loc_lang_prompt	= checkForNull((String)hash_Map.get("first_name_loc_lang_prompt"));
		second_name_loc_lang_prompt = checkForNull((String)hash_Map.get("second_name_loc_lang_prompt"));
		third_name_loc_lang_prompt  = checkForNull((String)hash_Map.get("third_name_loc_lang_prompt"));
		name_prefix_loc_lang_prompt = checkForNull((String)hash_Map.get("name_prefix_loc_lang_prompt"));	
		names_in_oth_lang_yn		= checkForNull((String)hash_Map.get("names_in_oth_lang_yn"),"N");
	}
/*
	if(CalledFromFunction.equals("ChangePatDtls")) 
	{
		hash_Map1 = eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);		
	}
	*/
   String temp		= "";
   emptyCnt	= 0;  /*To Count the Missing Name Fields as per MP Param*/
    
   if(names_in_oth_lang_yn.equals("Y")) 
   {
	   if(!language_direction.equals("R"))
	   {
	   
            _bw.write(_wl_block89Bytes, _wl_block89);

		 	if(Name_Prefix_Accept_Yn.equals("Y")) 
		{ 
			
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(name_prefix_loc_lang_prompt));
            _bw.write(_wl_block91Bytes, _wl_block91);
 				
			if( (Name_Prefix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
			{ 
				if(Name_Prefix_Reqd_Yn.equals("Y"))
				{
				
            _bw.write(_wl_block92Bytes, _wl_block92);

				}
				else
				{
					// Added by Muthu on 23/01/2010 against incident IN018465 to correct the issue prefix should not be mandatory for newborn and father patient ids even though name_pfx_reqd_for_org_mem_yn is set to Y in MP Param
					if(!CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {
					
            _bw.write(_wl_block93Bytes, _wl_block93);

					} else {
						
            _bw.write(_wl_block94Bytes, _wl_block94);

					}
					// End of Comment
				}			
			}
			else
			{ 
				
            _bw.write(_wl_block95Bytes, _wl_block95);

			}		
	   
			temp = ((name_prefix_loc_lang_prompt).equals("&nbsp;")) ? Name_Prefix_Prompt:name_prefix_loc_lang_prompt ;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block97Bytes, _wl_block97);

		}
		else
		{ 
			
            _bw.write(_wl_block98Bytes, _wl_block98);
 
		}
		
/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
		if (pat_name_as_multipart_yn.equals("Y") )
		{
			
			 String order = "";
			 /*Prompts and Names to be painted in Reverse Order for Local Lang*/
			 for(int i=1;i<=4;++i)
			 {
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 if (order.equals("First_Name_Order"))
				 {
					 if (First_Name_Accept_Yn.equals("Y")) 
					 { 
						
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(first_name_loc_lang_prompt));
            _bw.write(_wl_block100Bytes, _wl_block100);

						if ( (First_Name_Reqd_Yn.equals("Y") ) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block101Bytes, _wl_block101);

						}
						else
						{
							
            _bw.write(_wl_block102Bytes, _wl_block102);

						}
						temp = ((first_name_loc_lang_prompt).equals("&nbsp;"))? First_Name_Prompt:first_name_loc_lang_prompt; 
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block104Bytes, _wl_block104);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Second_Name_Order"))
				 {
					  if(Second_Name_Accept_Yn.equals("Y")) 
					  {
						
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(second_name_loc_lang_prompt));
            _bw.write(_wl_block106Bytes, _wl_block106);

						if ((Second_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{
							
            _bw.write(_wl_block107Bytes, _wl_block107);

						}
						else
						{ 
							
            _bw.write(_wl_block108Bytes, _wl_block108);

						}
						temp = ((second_name_loc_lang_prompt).equals("&nbsp;")) ? Second_Name_Prompt:second_name_loc_lang_prompt; 
						
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block110Bytes, _wl_block110);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Third_Name_Order"))
				 {
					  if(Third_Name_Accept_Yn.equals("Y")) 
					  { 
						
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(third_name_loc_lang_prompt));
            _bw.write(_wl_block106Bytes, _wl_block106);
 
						if ((Third_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block111Bytes, _wl_block111);

						}
						else
						{
							
            _bw.write(_wl_block112Bytes, _wl_block112);

						}
						temp = ((third_name_loc_lang_prompt).equals("&nbsp;")) ? Third_Name_Prompt:third_name_loc_lang_prompt; 
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block114Bytes, _wl_block114);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y") ) 
					{
						
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block106Bytes, _wl_block106);

						if ((Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block116Bytes, _wl_block116);

						}
						else
						{
							
            _bw.write(_wl_block117Bytes, _wl_block117);

						}
						temp = family_name_loc_lang_prompt.equals("&nbsp;") ? Family_Name_Prompt : family_name_loc_lang_prompt; 
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block119Bytes, _wl_block119);

					}
					else
					{
						emptyCnt++;
					}
			 }
			 else
			 {
				emptyCnt++;
			 }
  		  }
		}/* END of  if (pat_name_as_multipart_yn.equals("Y") )   */
		else
		{
			
		   if(Family_Name_Accept_Yn.equals("Y") ) 
			{
				
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block121Bytes, _wl_block121);

				if ( (Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
					out.print("<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>");
				} else { 
            _bw.write(_wl_block122Bytes, _wl_block122);
 }
						temp = family_name_loc_lang_prompt.equals("&nbsp;")? Family_Name_Prompt:family_name_loc_lang_prompt ; 
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block123Bytes, _wl_block123);

			}
		}


			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{ 
				
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(name_suffix_loc_lang_prompt));
            _bw.write(_wl_block125Bytes, _wl_block125);
 
					if ((Name_Suffix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
						
            _bw.write(_wl_block126Bytes, _wl_block126);
 
					}
					else
					{ 
						
            _bw.write(_wl_block127Bytes, _wl_block127);

					}
					temp = (name_suffix_loc_lang_prompt.equals("&nbsp;")) ? Name_Suffix_Prompt : name_suffix_loc_lang_prompt; 
				
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block129Bytes, _wl_block129);

			}
			else
			{ 
				
            _bw.write(_wl_block130Bytes, _wl_block130);
 
			}

	
		 /*To fill the blank spaces in the table with blank TDs*/
		 for(int j=1;j<=emptyCnt;++j)
			   {
            _bw.write(_wl_block131Bytes, _wl_block131);
}
		
            _bw.write(_wl_block132Bytes, _wl_block132);

	
			if(Name_Prefix_Accept_Yn.equals("Y")) 
			{
				if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block135Bytes, _wl_block135);

				}
				else
				{ 
					
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block137Bytes, _wl_block137);

				} 
				//if(Name_Prefix_Reqd_Yn.equals("N")) 
				//{ 
					
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(a_name_prefix_loc_lang));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)hash_Map1.get("name_prefix_loc_lang")));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(a_name_prefix_loc_lang));
            _bw.write(_wl_block144Bytes, _wl_block144);
 /*
						
				//} 									
				array_List.clear(); 
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix1",p);
				for(int i=0;i<array_List.size();i+=2) 
				{ 
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<option  value=\""+(String)array_List.get(i)+"\"");
						if(CalledFromFunction.equals("ChangePatDtls")  || !a_name_prefix_loc_lang.equals("") ) {
						if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_prefix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_prefix_loc_lang) )
								out.print(" selected >" );
							else out.print(" > " );
						}
						else out.print(" > " );
						out.print((String)array_List.get(i)+"</option>");
						}
					} */ 
            _bw.write(_wl_block145Bytes, _wl_block145);
}
   		    
		 if (pat_name_as_multipart_yn.equals("Y") )
		 {
			 String order = "";
			 //int tabIndex = 20;
			 emptyCnt = 0;
			 for(int i=1;i<=4;++i)
			 {
				 //tabIndex++; // To increase the tab order
				 //order = (String)Name_Order.get((new Integer(i)).toString());
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 if (order.equals("First_Name_Order"))
				 {
					if(First_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='fields'><input type='text' name='first_name_oth_lang' id='first_name_oth_lang' maxlength='"+first_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,first_name_oth_lang,first_name,'O','"+CalledFromFunction+"') ");

						
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_first_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_first_name_loc_lang.equals(""))
								out.print(" value=\""+a_first_name_loc_lang+"\">");
							else
							if(!(((String)(hash_Map1.get("first_name_loc_lang")==null?"":hash_Map1.get("first_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("first_name_loc_lang") +"\">");
							else 
							 out.print(" value = \"\" >");
								
						} else out.print(" value = \"\" >");  
						
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block147Bytes, _wl_block147);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Second_Name_Order"))
				 {
					if(Second_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("	<td     class='fields'><input type='text' name='second_name_oth_lang' id='second_name_oth_lang' maxlength='"+second_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)'  onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,second_name_oth_lang,second_name,'O','"+CalledFromFunction+"');  ");

						
						if( CalledFromFunction.equals("ChangePatDtls") || !a_second_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_second_name_loc_lang.equals(""))
								out.print(" value = \""+a_second_name_loc_lang+"\" >");   
							else
							if (!(((String)(hash_Map1.get("second_name_loc_lang")==null?"":hash_Map1.get("second_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("second_name_loc_lang") +"\">");
							else 
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >");
						
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block149Bytes, _wl_block149);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Third_Name_Order"))
				 {
					if(Third_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='fields'><input type='text' name='third_name_oth_lang' id='third_name_oth_lang' maxlength='"+third_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,third_name_oth_lang,third_name,'O','"+CalledFromFunction+"') ;");

						if ( CalledFromFunction.equals("ChangePatDtls") || !a_third_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_third_name_loc_lang.equals(""))
								out.print(" value = \""+a_third_name_loc_lang+"\" >");  
							else
							if(!(((String)(hash_Map1.get("third_name_loc_lang")==null?"":hash_Map1.get("third_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("third_name_loc_lang")+"\">");
							else 
								out.print(" value = \"\" >");   
						} 
						else out.print(" value = \"\" >");
						
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block151Bytes, _wl_block151);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y")) 
					{
						out.println("<td  class='fields' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,family_name_oth_lang,family_name,'O','"+CalledFromFunction+"') ; ");

						
						if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_family_name_loc_lang.equals(""))
								out.print(" value = \""+a_family_name_loc_lang+"\" >");  
							else
							if(!(((String)(hash_Map1.get("family_name_loc_lang")==null?"":hash_Map1.get("family_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
							else
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >"); 
					
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block153Bytes, _wl_block153);

				  }
				  else
				  {
				 	emptyCnt++;
				  }
			  }
			  else
			  {
				 emptyCnt++;
			  }
			}
		 }
		 /* if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
			   if(Family_Name_Accept_Yn.equals("Y") ) 
			   {
				out.print("<td  class='fields' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"'); ");

					

				if ( CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix_loc_lang.equals("")  )
				{
					if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
					else out.print(" value = \"\" >");    
				} 
				else out.print(" value = \""+a_name_suffix_loc_lang+"\" >");    
				
            _bw.write(_wl_block154Bytes, _wl_block154);

			} 
		}

			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{	 
				 if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block156Bytes, _wl_block156);

				}
				else
				{ 
				  
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
				if(Name_Suffix_Reqd_Yn.equals("N")) 
				{
					out.print("<Option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label" ,"common_labels")+"------</option>");
				} 
				
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(a_name_suffix_loc_lang));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf((String)hash_Map1.get("name_suffix_loc_lang")));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(a_name_suffix_loc_lang));
            _bw.write(_wl_block164Bytes, _wl_block164);


				/*
				array_List.clear();
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix1",p);
				
				for(int i=0;i<array_List.size();i+=2) 
				{
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<Option value=\"" + (String)array_List.get(i) + "\" ");
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_name_suffix_loc_lang.equals("") )
						{
							if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_suffix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_suffix_loc_lang) )
								out.print(" selected > ");
							else out.print(" > "); 
						}
						else out.print(" > "); 
						out.print((String)array_List.get(i)+"</option>");
					} 
				}
				*/
			
			
            _bw.write(_wl_block165Bytes, _wl_block165);

			}
			else
			{	
			}
		 /*To fill the blank spaces in the table with blank TDs*/
			 for(int j=1;j<=emptyCnt;++j)
			   {
            _bw.write(_wl_block44Bytes, _wl_block44);
}
			
            _bw.write(_wl_block166Bytes, _wl_block166);
	
			if(CalledFromFunction.equals("PatientRegistration")) { 
            _bw.write(_wl_block167Bytes, _wl_block167);
 }
   }
   else if(language_direction.equals("R"))
		{

	   /*******Added for Arabic*********/

	   	   
            _bw.write(_wl_block89Bytes, _wl_block89);


		
			   
			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{ 
				
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(name_suffix_loc_lang_prompt));
            _bw.write(_wl_block169Bytes, _wl_block169);
 
					if ((Name_Suffix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
						
            _bw.write(_wl_block170Bytes, _wl_block170);
 
					}
					else
					{ 
						
            _bw.write(_wl_block127Bytes, _wl_block127);

					}
					temp = (name_suffix_loc_lang_prompt.equals("&nbsp;")) ? Name_Suffix_Prompt : name_suffix_loc_lang_prompt; 
				
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block129Bytes, _wl_block129);

			}
			else
			{ 
				
            _bw.write(_wl_block130Bytes, _wl_block130);
 
			}


			/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
		if (pat_name_as_multipart_yn.equals("Y") )
		{
			 String order = "";
			 /*Prompts and Names to be painted in Reverse Order for Local Lang*/
			// for(int i=1;i<=4;i++)
			 for(int i=4;i>0;--i)
			 {
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y") ) 
					{
						
            _bw.write(_wl_block171Bytes, _wl_block171);

						if ((Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block116Bytes, _wl_block116);

						}
						else
						{
							
            _bw.write(_wl_block117Bytes, _wl_block117);

						}
						
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block106Bytes, _wl_block106);


						temp = family_name_loc_lang_prompt.equals("&nbsp;") ? Family_Name_Prompt : family_name_loc_lang_prompt; 
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block119Bytes, _wl_block119);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Third_Name_Order"))
				 {
					  if(Third_Name_Accept_Yn.equals("Y")) 
					  { 
						
            _bw.write(_wl_block172Bytes, _wl_block172);
 
						if ((Third_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block111Bytes, _wl_block111);

						}
						else
						{
							
            _bw.write(_wl_block112Bytes, _wl_block112);

						}

						
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(third_name_loc_lang_prompt));
            _bw.write(_wl_block106Bytes, _wl_block106);


						temp = ((third_name_loc_lang_prompt).equals("&nbsp;")) ? Third_Name_Prompt:third_name_loc_lang_prompt; 
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block173Bytes, _wl_block173);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Second_Name_Order"))
				 {
					  if(Second_Name_Accept_Yn.equals("Y")) 
					  {
						
            _bw.write(_wl_block172Bytes, _wl_block172);

						if ((Second_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{
							
            _bw.write(_wl_block107Bytes, _wl_block107);

						}
						else
						{ 
							
            _bw.write(_wl_block108Bytes, _wl_block108);

						}

						
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(second_name_loc_lang_prompt));
            _bw.write(_wl_block106Bytes, _wl_block106);


						temp = ((second_name_loc_lang_prompt).equals("&nbsp;")) ? Second_Name_Prompt:second_name_loc_lang_prompt; 
						
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block174Bytes, _wl_block174);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else  if (order.equals("First_Name_Order"))
				 {
					 if (First_Name_Accept_Yn.equals("Y")) 
					 { 
						
            _bw.write(_wl_block175Bytes, _wl_block175);

						if ( (First_Name_Reqd_Yn.equals("Y") ) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							
            _bw.write(_wl_block101Bytes, _wl_block101);

						}
						else
						{
							
            _bw.write(_wl_block102Bytes, _wl_block102);

						}

						
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(first_name_loc_lang_prompt));
            _bw.write(_wl_block106Bytes, _wl_block106);

						temp = ((first_name_loc_lang_prompt).equals("&nbsp;"))? First_Name_Prompt:first_name_loc_lang_prompt; 
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block176Bytes, _wl_block176);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
			 {
				emptyCnt++;
			 }
  		  }
		}/* END of  if (pat_name_as_multipart_yn.equals("Y") )   */
		else
		{
		   if(Family_Name_Accept_Yn.equals("Y") ) 
			{
				
            _bw.write(_wl_block177Bytes, _wl_block177);

				if ( (Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
					out.print("<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>");
				} else { 
            _bw.write(_wl_block122Bytes, _wl_block122);
 }
			
				
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block121Bytes, _wl_block121);

						temp = family_name_loc_lang_prompt.equals("&nbsp;")? Family_Name_Prompt:family_name_loc_lang_prompt ; 
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block123Bytes, _wl_block123);

			}
		}

		 	if(Name_Prefix_Accept_Yn.equals("Y")) 
		{ 
			
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(name_prefix_loc_lang_prompt));
            _bw.write(_wl_block179Bytes, _wl_block179);
 
			if( (Name_Prefix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
			{ 
				if(Name_Prefix_Reqd_Yn.equals("Y"))
				{
				
            _bw.write(_wl_block180Bytes, _wl_block180);

				}
				else
				{
					// Added by Muthu on 23/01/2010 against incident IN018465 to correct the issue prefix should not be mandatory for newborn and father patient ids even though name_pfx_reqd_for_org_mem_yn is set to Y in MP Param 
					if(!CalledFromFunction.equals("FatherDtls") && !CalledFromFunction.equals("NewbornDtls")) {
				
            _bw.write(_wl_block181Bytes, _wl_block181);

					} else {
						
            _bw.write(_wl_block94Bytes, _wl_block94);

					}
					// End of Comment
				}				
			}
			else
			{ 
				
            _bw.write(_wl_block182Bytes, _wl_block182);

			}
			temp = ((name_prefix_loc_lang_prompt).equals("&nbsp;")) ? Name_Prefix_Prompt:name_prefix_loc_lang_prompt ;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block183Bytes, _wl_block183);

		}
		else
		{ 
			
            _bw.write(_wl_block98Bytes, _wl_block98);
 
		}




	
		 /*To fill the blank spaces in the table with blank TDs*/
		 for(int j=1;j<=emptyCnt;++j)
		// for(int j=emptyCnt;j>0;--j)
			   {
            _bw.write(_wl_block131Bytes, _wl_block131);
}
		
            _bw.write(_wl_block132Bytes, _wl_block132);


			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{	 
				 if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block186Bytes, _wl_block186);

				}
				else
				{ 
				  
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block188Bytes, _wl_block188);
}
				if(Name_Suffix_Reqd_Yn.equals("N")) 
				{
					out.print("<Option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label" ,"common_labels")+"------</option>");
				}
				
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(a_name_suffix_loc_lang));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf((String)hash_Map1.get("name_suffix_loc_lang")));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(a_name_suffix_loc_lang));
            _bw.write(_wl_block164Bytes, _wl_block164);

				/*	
				array_List.clear();
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix1",p);
				
				for(int i=0;i<array_List.size();i+=2) 
				{
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<Option value=\"" + (String)array_List.get(i) + "\" ");
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_name_suffix_loc_lang.equals("") )
						{
							if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_suffix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_suffix_loc_lang) )
								out.print(" selected > ");
							else out.print(" > "); 
						}
						else out.print(" > "); 
						out.print((String)array_List.get(i)+"</option>");
					} 
				}
				*/			
			
            _bw.write(_wl_block191Bytes, _wl_block191);

			}
			else
			{	
			}

		if (pat_name_as_multipart_yn.equals("Y") )
		 {
			 String order = "";
			 //int tabIndex = 20;
			 emptyCnt = 0;
			 //for(int i=1;i<=4;++i)
			for(int i=4;i>0;--i)
			 {
				 //tabIndex++; // To increase the tab order
				 //order = (String)Name_Order.get((new Integer(i)).toString());
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y")) 
					{
						out.println("<td  class='arabic' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,family_name_oth_lang,family_name,'O','"+CalledFromFunction+"') ; ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls") )
						{
							if (!a_family_name_loc_lang.equals(""))
								out.print(" value = \""+a_family_name_loc_lang+"\" >");  
							else
							if(!(((String)(hash_Map1.get("family_name_loc_lang")==null?"":hash_Map1.get("family_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
							else
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >"); 
					
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block153Bytes, _wl_block153);

				  }
				  else
				  {
				 	emptyCnt++;
				  }
			  }
			  else 	if (order.equals("Third_Name_Order"))
				 {
					if(Third_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='arabic'><input type='text' name='third_name_oth_lang' id='third_name_oth_lang' maxlength='"+third_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,third_name_oth_lang,third_name,'O','"+CalledFromFunction+"') ; ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if ( CalledFromFunction.equals("ChangePatDtls") || !a_third_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_third_name_loc_lang.equals(""))
								out.print(" value = \""+a_third_name_loc_lang+"\" >");  
							else
							if(!(((String)(hash_Map1.get("third_name_loc_lang")==null?"":hash_Map1.get("third_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("third_name_loc_lang")+"\">");
							else 
								out.print(" value = \"\" >");   
						} 
						else out.print(" value = \"\" >");
						
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block151Bytes, _wl_block151);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Second_Name_Order"))
				 {
					if(Second_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("	<td     class='arabic'><input type='text' name='second_name_oth_lang' id='second_name_oth_lang' maxlength='"+second_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,second_name_oth_lang,second_name,'O','"+CalledFromFunction+"') ; ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if( CalledFromFunction.equals("ChangePatDtls") || !a_second_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls"))
						{
							if (!a_second_name_loc_lang.equals(""))
								out.print(" value = \""+a_second_name_loc_lang+"\" >");   
							else
							if (!(((String)(hash_Map1.get("second_name_loc_lang")==null?"":hash_Map1.get("second_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("second_name_loc_lang") +"\">");
							else 
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >");
						
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block149Bytes, _wl_block149);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else  if (order.equals("First_Name_Order"))
				 {
					if(First_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='arabic'><input type='text' name='first_name_oth_lang' id='first_name_oth_lang' maxlength='"+first_name_length+"' size='20' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"');populateLocalValues(this,first_name_oth_lang,first_name,'O','"+CalledFromFunction+"') ; ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_first_name_loc_lang.equals("") || CalledFromFunction.equals("NewbornDtls") )
						{
							if (!a_first_name_loc_lang.equals(""))
								out.print(" value=\""+a_first_name_loc_lang+"\">");
							else
							if(!(((String)(hash_Map1.get("first_name_loc_lang")==null?"":hash_Map1.get("first_name_loc_lang"))).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("first_name_loc_lang") +"\">");
							else 
							 out.print(" value = \"\" >");
								
						} else out.print(" value = \"\" >");  
						
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(name_comp_visibility));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block147Bytes, _wl_block147);

					}
					else
					{
						emptyCnt++;
					}
				 }
				 else				
			  {
				 emptyCnt++;
			  }
			}
		 }
		 /* if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
			   if(Family_Name_Accept_Yn.equals("Y") ) 
			   {
				out.print("<td  class='arabic' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+familyNametextBoxSize+"' onKeyPress='return CheckForPipeChars(event)' onblur=makeValidString(this);putLocalLangPatientName(this,'"+CalledFromFunction+"'); ");

					if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

				if ( CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix_loc_lang.equals("")  )
				{
					if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
					else out.print(" value = \"\" >");    
				} 
				else out.print(" value = \""+a_name_suffix_loc_lang+"\" >");    
				
            _bw.write(_wl_block154Bytes, _wl_block154);

			} 
		}
	
			if(Name_Prefix_Accept_Yn.equals("Y")) 
			{
				if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block199Bytes, _wl_block199);

				}
				else
				{ 
					
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block201Bytes, _wl_block201);

				} 
				//if(Name_Prefix_Reqd_Yn.equals("N")) 
				//{ 
					
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(a_name_prefix_loc_lang));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(CalledFromFunction));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((String)hash_Map1.get("name_prefix_loc_lang")));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(a_name_prefix_loc_lang));
            _bw.write(_wl_block206Bytes, _wl_block206);

				//}
					/*
				array_List.clear(); 
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix1",p);
				for(int i=0;i<array_List.size();i+=2) 
				{ 
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<option  value=\""+(String)array_List.get(i)+"\"");
						if(CalledFromFunction.equals("ChangePatDtls")  || !a_name_prefix_loc_lang.equals("") ) {
						if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_prefix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_prefix_loc_lang) )
								out.print(" selected >" );
							else out.print(" > " );
						}
						else out.print(" > " );
						out.print((String)array_List.get(i)+"</option>");
						}
					}*/ 
            _bw.write(_wl_block207Bytes, _wl_block207);
}
   		    
		 

	
		 /*To fill the blank spaces in the table with blank TDs*/
			 for(int j=1;j<=emptyCnt;++j)
			   {
            _bw.write(_wl_block44Bytes, _wl_block44);
}
			
            _bw.write(_wl_block166Bytes, _wl_block166);
	
			if(CalledFromFunction.equals("PatientRegistration")) { 
            _bw.write(_wl_block167Bytes, _wl_block167);
 }

		}
		/*******end for Arabic*********/
		}
		if(!CalledFromFunction.equals("NewbornDtls"))	{
		
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block210Bytes, _wl_block210);

		}

		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
