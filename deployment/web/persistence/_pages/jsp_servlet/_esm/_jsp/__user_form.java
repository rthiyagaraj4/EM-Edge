package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __user_form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/User_Form.jsp", 1742366152378L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n  <head>\n      \t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script language=\'javascript\' src=\'../../eSM/js/User.js\'></script>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n   \t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n   \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n     <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n\t    <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n\n \t<script>\n\t\n// NOTE:if the user has javascript disabled this will not work.\n\nfunction emailvalidate(email) {\n   var reg = /^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$/;\n   if(reg.test(email.value) == false) {\n      alert(\'Invalid Email Address\');\n\t  email.value=\'\';\n      return false;\n   }\n}\n\n//Modified by Kamatchi S for ML-MMOH-CRF-1844.2 \nfunction CheckForSpecCharsforID(event){\n\n\tvar isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;\n\n\tif(isSSOIntegrationAppl == \'true\'){\n\t\tvar strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_$#\';\n\t}else{\n\t\tvar strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_\';\n\t}\n\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\treturn (event.keyCode -= 32);\n\treturn true ;\n}\n\n//Modified by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2\nfunction checkSpecChar()\n{\n\tappl_user_id = document.forms[0].appl_user_id.value;\n\tfirstChar = appl_user_id.charAt(0);\n\n\tvar isSSOIntegrationAppl = document.forms[0].isSSOIntegrationAppl.value;\n\n\tif(isSSOIntegrationAppl == \'true\'){\n\t\tif(firstChar == \"_\" || firstChar == \"$\" || firstChar == \"#\"){\n\t\t\talert(getMessage(\'ID_CANT_HAVE_SPEC_CHAR_FIRST\',\'SM\'));\n\t\t\t//document.forms[0].appl_user_id.focus();\n\t\t\tdocument.getElementById(\'appl_user_id\').focus();\n\t\t\treturn false;\n\t\t}\n\t}else{\n\t\tif(firstChar == \"_\"){\n\t\t\talert(getMessage(\'ID_CANT_HAVE_UNDER_SCORE\',\'SM\'));\n\t\t\t//document.forms[0].appl_user_id.focus();\n\t\t\tdocument.getElementById(\'appl_user_id\').focus();\n\t\t\treturn false;\n\t\t}\n\t}\n}\n\nfunction validate_from_date(obj)\n\t{\n\t\tif(document.forms[0].function_name.value==\"insert\")\n\t\t{\n\t\t\tif(obj.value.length>0)\n\t\t\tif(validDateObj(obj,\"DMY\",localeName)){\n\t\t\tDateValidation(obj);\n\t\t\t}\n\t\t}\n\t\telse if(document.forms[0].function_name.value==\"modify\")\n\t\t{\n\t\t\tif(document.forms[0].old_eff_date_from.value==\"\")\n\t\t\t{\n\t\t\t\tif(obj.value.length>0)\n\t\t\t\t{\n\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName)){\n\t\t\t\t\tDateValidation(obj);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(obj.value.length<=0)\n\t\t\t\t{\n/*\nCommented on 13 Apr by Sridhar as [ Effective From ] value is not a mandatory field...\t\t\t\t\t\talert(getMessage(\"FROM_DATE_CANNOT_BE_BLANK\"));\n\t\t\t\t\tobj.select();\n\t\t\t\t\tobj.focus();\n*/\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName)){\n\t\t\t\t\tDateValidation(obj);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tdatecopmare();\n\t}\nvar flag=1;\n\t\tfunction validate_to_date(obj)\n\t\t{\n\t\t\tif(document.forms[0].function_name.value==\"insert\")\n\t\t{\n\t\t\tif(obj.value.length>0)\n\t\t\tif(validDateObj(obj,\"DMY\",localeName)){\n\t\t\tDateValidation(obj);\n\t\t\t}\n\t\t}\n\t\t\t\n\t\t\t\n\t\t\tif(document.forms[0].function_name.value==\"insert\")\n\t\t\t{\n\t\t\t\tif(document.forms[0].eff_date_from1.value!=\"\" && document.forms[0].eff_date_to1.value!=\"\")\n\t\t\t\t{\n\t\t\t\t\tif(flag){\n\t\t\t\t\t\tdatecopmare();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(obj.value.length<0)\n\t\t\t\t\t{\n\t\t\t\t\t\tvalidDateObj(obj,\"DMY\",localeName);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(document.forms[0].function_name.value==\"modify\")\n\t\t\t{\n\t\t\t\t\n\t\t\t\tif(document.forms[0].eff_date_from1.value==\"\")\n\t\t\t\t{\n\t\t\t\t\tif(obj.value.length>0)\n\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName)){\n\t\t\t\t\t\tDateValidation(obj)/**/\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tif(obj.value.length>0){\n\t\t\t\t\t\t\t\n\t\t\t\t\tif(validDateObj(obj,\"DMY\",localeName)){\n\t\t\t\t\t\tif(DateValidation(obj)!=false)\n\t\t\t\t\t\tdatecopmare();\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t//alert(doDateCheck1(document.forms[0].eff_date_from,document.forms[0].eff_date_to));\n\t\t\t\t\t/*if(!doDateCheck1(document.forms[0].eff_date_from1,document.forms[0].eff_date_to1))\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'TO_DT_GR_EQ_FM_DT\',\'SM\'));\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t}*/\n\t\t\t\t}\n\t\t\t}\n\t\t}\nfunction datecopmare(){\n\t   if(document.forms[0].eff_date_from1.value!=\"\" && document.forms[0].eff_date_to1.value!=\"\"){\n\t\t\t   if(!(isBefore(document.forms[0].eff_date_from1.value,document.forms[0].eff_date_to1.value,\"DMY\",localeName)))\n\t\t   {\n\t\t\t\t\t\t\t\t\t   alert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\t\t\t\t\t\t   //document.forms[0].eff_date_to1.value=\'\';\n\t\t\t\t\t\t\t\t\t   document.getElementById(\'eff_date_to1\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t//document.forms[0].eff_date_to1.select();\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'eff_date_to1\').select();\n\t\t\t\t\t\t\t\t\t\t//document.forms[0].eff_date_to1.focus();\n\t\t\t\t\t\t\t\t\t\t\talert(\"3:\"+document.getElementById(\'eff_date_to1\'));\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'eff_date_to1\').focus();\n\n\t\t}\n\t\t\t   \n\n   }\n}\n\t\t\n\t\t\t\nfunction callpract(obj1,obj,target_id)\n{\n\tif(obj.value == \"\")\n\t{obj.value=\"\";\n\ttarget_id.value=\"\";\n\treturn ;\n\t}\n\n  displayUser(obj1,obj,target_id)\n}\n\n\t\t\t\n\t\t\tfunction DateValidation(obj){\n\t\t\t\tcurdate = document.user_form.cur_date;\n\t\t\t\t\n\t\t\t\tvar msg=\"\";\n\t\t\t\tif(obj.name==\"eff_date_from1\")\n\t\t\t\t msg = getMessage(\"FROM_DATE_LESS_SYSDATE\",\"SM\");\n\t\t\t\tif(obj.name==\"eff_date_to1\")\n\t\t\t\tmsg = getMessage(\"TO_DATE_LESS_SYSDATE\",\"SM\");\n\t\t\t\t\n\t\t\t\tif(!(isAfterNow(obj.value,\"DMY\",localeName))) {\n\t\t\t\t\tflag=0;\n\n\t\t\t\t\tobj.focus();\n\t\t\t\t\tobj.select();\n\t\t\t\t\talert(msg);\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t}\n\n\t\tfunction doDateCheck1(from,to,messageFrame,val) \n\t\t{\n\t\tvar fromarray; var toarray;\n\t\tvar fromdate = from.value ;\n\t\tvar todate = to.value ;\n\t\tif(fromdate.length > 0 && todate.length > 0 ) \n\t\t{\n\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\ttoarray = todate.split(\"/\");\n\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\t\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) \n\t\t\t{\n\t\t\t\t{\n\t\t\t\tif(val==\"1\")  \n\t\t\t\t{\n\t\t\t\t\tto.select();\n\n\t\t\t\tto.focus();\n\t\t\t\t}\n\t\t\t\telse if(val==\"2\") \n\t\t\t\t{\n\t\t\t\t\tfrom.select();\n\n\t\t\t\t\tfrom.focus();\n\t\t\t\t}\n\t\t\t\telse if(val==\"3\")\n\t\t\t\t{\n\t\t\t\t\tto.select();\n\n\t\t\t\t\tto.focus();\n\t\t\t\t}\n\t\t\t\telse if(val==\"4\")\n\t\t\t\t{\n\t\t\t\t\tto.select();\n\n\t\t\t\t\tto.focus();\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse if(Date.parse(todt) >= Date.parse(fromdt)) return true;\n\t}\t\nreturn true;\n}\n/*function changeLabl()\n{\n\tvar roletype \t\t= document.user_form.role_type.value;\n\tif (roletype!=\'\' || roletype!=null )\n\t{\n\t\tif(roletype==\'O\')\n\t\t{\n\t\t\tdocument.getElementById(\'typeLabl\').innerText=\"Other Staff Type\";\n\t\t\tdocument.getElementById(\'typeLablName\').innerText=\"Other Staff Name\";\n\t\t}else if(roletype.==\'P\'){\n\t\t\tdocument.getElementById(\'typeLabl\').innerText=\"Practitioner Type\";\n\t\t\tdocument.getElementById(\'typeLablName\').innerText=\"Practitioner Name\";\n\t\t}\n\t}\n}*/\nfunction clearName()\n{\ndocument.forms[0].pract_name.value=\'\';\n}\n\tfunction onSuccess(){\n\t//alert(\'success\');\n\t}\n\n//Added by Maheshwaran K for the Password Validation as on 11/07/2012\n//Start\n//This method is called by onblur from Password field\nfunction chk_pass()\n\t{\n\tvar chkpassvalue=document.forms[0].appl_user_password.value\n\tif(chkpassvalue!=\"\")\n\tdocument.forms[0].password_value_Y.value=\"Y\";\n\t}\n//End\t\n</script>\n\t\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script>\n      \tvar flg = 1;\n      \tfunction change() {\n      \t if (user_form.eff_status.checked == true)\n      \t \tuser_form.eff_status.value=\"E\";\n      \t else\n      \t\tuser_form.eff_status.value=\"D\";\n      \t}\n\n\t\t//Added by Kamatchi S for ML-MMOH-CRF-1844.2\n\t\tfunction setVal(obj)\n\t\t{\n\t\t\tif(obj.checked == true)\n\t\t\t{\n\t\t\t\tobj.value = \"Y\";\n\t\t\t\tdocument.user_form.active_dir_id.disabled = false;\n\t\t\t\tdocument.user_form.active_dir_id_btn.disabled = false;\n\t\t\t\tdocument.user_form.active_dir_img.style.visibility = \"visible\";\n\t\t\t\tdocument.user_form.resp_group_id.disabled = true;\n\t\t\t\tdocument.user_form.resp_group_id.value = \"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tobj.value = \"N\";\n\t\t\t\tdocument.user_form.active_dir_id.disabled = true;\n\t\t\t\tdocument.user_form.active_dir_id_btn.disabled = true;\n\t\t\t\tdocument.user_form.active_dir_id.value = \"\";\n\t\t\t\tdocument.user_form.active_dir_img.style.visibility = \"hidden\";\n\t\t\t\tdocument.user_form.resp_group_id.disabled = false;\n\t\t\t\tdocument.user_form.appl_user_password.disabled = false;\n\t\t\t\tdocument.user_form.appl_user_cpassword.disabled = false;\n\t\t\t}\n\t\t}\n\t\t\n\t\tfunction setVal1()\n\t\t{\n\t\t\tif(document.user_form.active_dir_id.value != \"\"){\n\t\t\t\tdocument.user_form.appl_user_password.disabled = true;\n\t\t\t\tdocument.user_form.appl_user_cpassword.disabled = true;\n\t\t\t}else{\n\t\t\t\tdocument.user_form.appl_user_password.disabled = false;\n\t\t\t\tdocument.user_form.appl_user_cpassword.disabled = false;\n\t\t\t}\n\n\t\t\tif(document.user_form.eff_status.checked == true){\n\t\t\t\tif(document.user_form.link_ad_user.value == \"Y\"){\n\t\t\t\t\tdocument.user_form.link_ad_user.checked = true;\n\t\t\t\t\tdocument.user_form.active_dir_id.disabled = false;\n\t\t\t\t\tdocument.user_form.active_dir_id_btn.disabled = false;\n\t\t\t\t\tdocument.user_form.active_dir_img.style.visibility=\"visible\";\n\t\t\t\t\tdocument.user_form.resp_group_id.disabled = true;\n\t\t\t\t\tdocument.user_form.resp_group_id.value = \"\";\n\t\t\t\t}else{\n\t\t\t\t\tdocument.user_form.link_ad_user.checked = false;\n\t\t\t\t\tdocument.user_form.active_dir_id.disabled = true;\n\t\t\t\t\tdocument.user_form.active_dir_id_btn.disabled = true;\n\t\t\t\t\tif(document.user_form.active_dir_id.value == \"\")\n\t\t\t\t\tdocument.user_form.active_dir_id.value = \"\";\n\t\t\t\t\tdocument.user_form.active_dir_img.style.visibility = \"hidden\";\n\t\t\t\t\tdocument.user_form.resp_group_id.disabled = false;\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tif(document.user_form.link_ad_user.value == \"Y\"){\n\t\t\t\t\tdocument.user_form.link_ad_user.checked = true;\n\t\t\t\t\tdocument.user_form.active_dir_img.style.visibility = \"visible\";\n\t\t\t\t}else{\n\t\t\t\t\tdocument.user_form.link_ad_user.checked = false;\n\t\t\t\t\tdocument.user_form.active_dir_img.style.visibility = \"hidden\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n      \tfunction change1() {\n      \tuser_form.rep_facility_id2.value = user_form.rep_facility_id.value;\n      \t}\n\t\t//Maheshwaran modified for MMS-QH-CRF-0149\n      \tfunction checkLen_1(Obj,enforce_password_policy_yn,allowed_spl_char_in_password,password_length_min,password_length_max) {\n\t\tvar allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,\'UTF-8\');\n\t\tallowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace(\"+\",\'\')\n\t\t\tvar errors = \"\" ;\n\t\t\tvar len_one=Obj.value.length;\n\t\t\t//Maheshwaran added for MMS-QH-CRF-0149\n\t\t\t\tif(enforce_password_policy_yn==\'Y\')\n\t\t\t\t\t{\n\t\t\t\t\tChkPWSplChar(Obj,allowed_spl_char_in_password1,\'tab\');\n\t\t\t\t\t}\n\t\t\tif (len_one < password_length_min)\n\t\t\t\t{\n\t\t\t\terrors = getMessage(\'PWD_MIN_CH\',\'SM\');\n\t\t\t\terrors=errors.replace(\"#\",password_length_min);\n\t\t\t\tObj.focus();\n\t\t\t\treturn false;\t\t\n\t\t\t\t}\n\t\t\t\telse if (len_one > password_length_max)//Maheshwaran changed from 20 to 10 for MMS-QH-CRF-0149\n\t\t\t\t{\n\t\t\t\terrors = getMessage(\'PWD_MAX_CH\',\'SM\');\n\t\t\t\terrors=errors.replace(\"#\",password_length_max);\n\t\t\t\tObj.focus();\n\t\t\t\treturn false;\t\t\t\n\t\t\t\t}\t\t\t\n\t\t\t\telse {\n\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\nfunction checkLen_2(len){\n\t\t\tvar errors = \"\" ;\n\t\t\tvar len_two=len.value.length;\n\t\t\tif (len_two <5)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PWD_MIN_CH\',\'SM\');\n\t\t\t\t\terrors=errors.replace(\"#\",password_length_min);\n\t\t\t\t\tlen.focus();\n\t\t\t\t\treturn false;\t\t\n\t\t\t\t}\n\t\t\t\telse if (len_two >10)\n\t\t\t\t{\n\t\t\t\t\terrors = getMessage(\'PWD_MAX_CH\',\'SM\');\n\t\t\t\t\terrors=errors.replace(\"#\",password_length_max);\n\t\t\t\t\tlen.focus();\n\t\t\t\t\treturn false;\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\n\t\t\t\n\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\nfunction PopPractType(){\n\n   \n\tvar practitioner_type;\n\tvar practtype = \"\";\n\t\t//parent.frames[1].document.user_form.pract_type.value;\n\n\t\n\n\n\tvar  HTMLVal = new String();\n\n\tclear_list(parent.frames[1].document.forms[0].pract_type);\n\n\tparent.frames[1].document.forms[0].pract_name.value=\'\';\n\tparent.frames[1].document.forms[0].pract_name_desc.value=\'\';\n\tvar roletype \t\t= document.user_form.role_type.value;\n\t\n\n\t\n\tif (roletype == \"P\")\n\t{\n\n\t\tdocument.getElementById(\'typeLabl\').innerText=getLabel(\"Common.practitionertype.label\",\"Common\");\n\t\tdocument.getElementById(\'typeLablName\').innerText=getLabel(\"Common.practitionername.label\",\"Common\");\n\t\tdocument.getElementById(\'pract_type_gif\').style.visibility=\"visible\";\n\t\tdocument.getElementById(\'pract_name_gif\').style.visibility=\"visible\";\n\t\t\n\t\t\n\t\tHTMLVal = \"<html><body onKeyDown = \'lockKey()\'><form name=\'dum_form\' id=\'dum_form\' method=\'post\' action=\'../../eSM/jsp/GetValUser.jsp\'><input type=\'hidden\' name=\'role_type\' id=\'role_type\' value=\'\"+roletype+\"\'><input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\'\"+practtype+\"\'><input type=\'hidden\' name=\'pract_name\' id=\'pract_name\' value=\'\'></form></body></html>\";\n\t\t\n\n\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\tparent.messageFrame.document.dum_form.submit();\n\n\t}\n\telse if (roletype == \"O\")\n\t{\n\t\tdocument.getElementById(\'typeLabl\').innerText=getLabel(\"Common.OtherStaffType.label\",\"Common\");\n\t\tdocument.getElementById(\'typeLablName\').innerText=getLabel(\"Common.OtherStaffName.label\",\"Common\");\n\t\tdocument.getElementById(\'pract_type_gif\').style.visibility=\"visible\";\n\t\tdocument.getElementById(\'pract_name_gif\').style.visibility=\"visible\";\n    \n\t\tHTMLVal = \"<html><body onKeyDown = \'lockKey()\'><form name=\'dum_form\' id=\'dum_form\' method=\'post\' action=\'../../eSM/jsp/GetValUser.jsp\'><input type=\'hidden\' name=\'role_type\' id=\'role_type\' value=\'\"+roletype+\"\'><input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\'\"+practtype+\"\'><input type=\'hidden\' name=\'pract_name\' id=\'pract_name\' value=\'\'></form></body></html>\";\n\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\tparent.messageFrame.document.dum_form.submit();\n\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'typeLabl\').innerText=\"Functional Type\";\n\t\tdocument.getElementById(\'typeLablName\').innerText=\"Functional Name\";\n\t\tdocument.getElementById(\'pract_type_gif\').style.visibility=\"hidden\";\n\t\tdocument.getElementById(\'pract_name_gif\').style.visibility=\"hidden\";\n\n\t}\n\n}\n\n\t\t\tfunction PopPractName(cod,code){\n\t\t\t\t\n                       if(parent.frames[1].document.forms[0].pract_type.value==\"\")\n\t\t\t\t{\n\t\t\t\tparent.frames[1].document.getElementById(\"prid\").disabled=true;\n\t\t\t\tparent.frames[1].document.forms[0].pract_name_desc.readOnly=true; \n\t\t\t\tparent.frames[1].document.forms[0].pract_name.value=\'\';\n\t\t\t\tparent.frames[1].document.forms[0].pract_name_desc.value=\'\';\n\t\t\t\t}else{\n\t\t\t\t\t   parent.frames[1].document.getElementById(\"prid\").disabled=false;\n\t\t\t\t\t   parent.frames[1].document.forms[0].pract_name_desc.readOnly=false;\n\t\t\t\t\t  // parent.frames[1].document.forms[0].pract_name_desc.value=\'\';\n\t\t\t\t\n\t\t\t\t}\n\n\t\t\t\tif(parent.frames[1].document.forms[0].eff_status.value==\'D\'){\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[1].document.forms[0].prid.disabled=\"true\";\n\t\t\t\t\t\n\t\t\t\t}\n\t\t}\n\t\t\t\t\tfunction PopPractName1(cod,code){\n\t\t\t\t\n                       if(parent.frames[1].document.forms[0].pract_type.value==\"\")\n\t\t\t\t{\n\t\t\t\tparent.frames[1].document.getElementById(\"prid\").disabled=true;\n\t\t\t\tparent.frames[1].document.forms[0].pract_name_desc.readOnly=true; \n\t\t\t\tparent.frames[1].document.forms[0].pract_name.value=\'\';\n\t\t\t\tparent.frames[1].document.forms[0].pract_name_desc.value=\'\';\n\t\t\t\t}else{\n\t\t\t\t\t   parent.frames[1].document.getElementById(\"prid\").disabled=false;\n\t\t\t\t\t   parent.frames[1].document.forms[0].pract_name_desc.readOnly=false;\n\t\t\t\t\t  parent.frames[1].document.forms[0].pract_name_desc.value=\'\';\n\t\t\t\t\n\t\t\t\t}\n\t\t}\n\n\t\t\n\n\t\tfunction clear_list(obj)\n\t\t{\n\t\t\t\twhile ( obj.options.length > 0 )\n\t\t\t      {\n\t\t\t\t \tobj.remove(obj.options[0]);\n\t\t\t\t  }\n\t\t\t\t  \n\n\t\t\t\t\n\t\t\t\t\t\tvar opt = parent.document.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text = \'  --------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'--------  \';\n\t\t\t\t\t\topt.value= \'\';\n\t\t\t\t\t\n\t\t\t\t\t\tobj.add(opt)\n\n\t}\n\t\tfunction clear_list1(obj)\n\t\t{\n\t\t\t\t\twhile ( obj.options.length > 0 )\n\t\t\t\t\t\tobj.remove(obj.options[0]);\n\n\t\t\t\n\t\t\t\t\t\tvar opt = parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text = \'  --------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'--------  \';\n\t\t\t\t\t\topt.value= \'\';\n\n\t\t\t\t\t\tobj.add(opt)\n\n\n\t}\n\tfunction ToDateValidation(obj){\n\t\t\tvar curdate = document.user_form.cur_date;\n\t\t\tvar msg = getMessage(\"TO_DATE_LESS_SYSDATE\",\"SM\");\n\t\t\tif(doDateCheckAlert(curdate,obj) == false\t ) {\n\t\t\t\tobj.focus();\n\t\t\t\tobj.select();\n\t\t\t\talert(msg);\n\t\t\t}\n\t\t  }\n\tfunction CheckForNumber(obj) \n\t{\n\t\tif (obj.value.length > 0 )\n\t\t{\n\t\t\tif ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)\n\t\t\t{\t\t\n\t\t\t\talert(getMessage(\'CANNOT_START_WITH_NUMERIC\',\'SM\'));\n\t\t\t\tobj.value=\'\';\n\t\t\t\tobj.select();\n\t\t\t\tobj.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tif (obj.value.substr(0,1) >= 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\'CANNOT_START_WITH_NUMERIC\',\'SM\'));\n\t\t\t\tobj.value=\'\';\n\t\t\t\tobj.select();\n\t\t\t\tobj.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\nfunction CheckPositiveNumber1(obj)\n\t\t{\t\n\tif ( !(trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0)) {\t\n\n\t  \t\tif ( obj.value.length > 0 ) {\n  \t\t\talert(getMessage(\"ONLY_POSITIVE_NUM\",\"SM\"));\n  \t\t\tobj.select();\n  \t\t\tobj.focus();\n  \t\t}\n\n  \t}\n}\n\n\tasync function displayUser(obj,target,target_id)\n\t{\n\t\n\tvar retVal = \tnew String();\n\n\n\t   var retVal =    new String();\n\t  var argumentArray  = new Array() ;\n\t  var dataNameArray  = new Array() ;\n\t  var dataValueArray = new Array() ;\n\t  var dataTypeArray  = new Array() ;\n\t  var tit=\"\";\t\t\t\t\n      practtype  =document.forms[0].pract_type.value;\n\t  var roletype= document.user_form.role_type.value;\n\n\t\t \n\t\t\n\tif(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' >0  && practtype !=\'\')\n\t{ \n     tit=getLabel(\"Common.practitioner.label\",\"Common\");\n\t\tif (roletype == \"P\"){\n\t\t\tif(this.value==\"\"){\n\t\t\t\tdocument.forms[0].pract_name_desc.value=\"\";\n\t\t\t\tdocument.forms[0].pract_name.value=\"\";\n\n\t\t\t}else{\n\t\t\tgetPractitioner(target,target_id)\n\t\t\t}\n\t\t//parent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'\n\t\t//sql=\"Select practitioner_id code,practitioner_NAME description from am_practitioner where   PRACT_TYPE =\'\"+practtype+\"\' and upper(practitioner_id) like upper(?) and upper(practitioner_NAME) like upper(?) and  eff_status = \'E\'  order by 2\";\n\t\n\t}\n\telse if (roletype == \"O\"){\n\ttit=getLabel(\"Common.OtherStaff.label\",\"Common\")\t\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'\n\t\tsql=\"Select OTHER_STAFF_ID code,OTHER_STAFF_NAME description from AM_OTHER_STAFF where eff_status=\'E\' and  OTHER_STAFF_TYPE =\'\"+practtype+\"\' and upper(OTHER_STAFF_ID) like upper(?) and upper(OTHER_STAFF_NAME) like upper(?)  order by 2\";\n\t\t\n\t\n\t\n\t    argumentArray[0] =sql;\n\t\targumentArray[1] = dataNameArray ;\n\t\targumentArray[2] = dataValueArray ;\n\t\targumentArray[3] = dataTypeArray ;\n\t\targumentArray[4] = \"1,2\";\n\t\targumentArray[5] = target.value;\n\t\targumentArray[6] = DESC_LINK ;\n\t\targumentArray[7] = DESC_CODE;\n\t\tretVal = await CommonLookup( tit, argumentArray );\n\t \n\n\t\t\n\t\tvar arr=new Array();\n\t\tif (!(retVal == null||retVal==\"\"))\n\t\t{\n\t\t\tvar ret1=unescape(retVal);\n\t\t\tarr=ret1.split(\",\");\n\t\t\ttarget.value=arr[1];\n\t\t\ttarget_id.value=arr[0];\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttarget.value=\"\";\n\t\t\ttarget_id.value=\"\";\n\t\t}\n\t}\n\t}\n\telse\n\t{\n\tvar err= getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\t\n\tif (roletype == \"P\"){\n\terr= err.replace(\"$\",getLabel(\"Common.practitionertype.label\",\"Common\"));\n\t}\n\t\n\telse if (roletype == \"O\"){\n\t\terr= err.replace(\"$\",getLabel(\"Common.OtherStaffType.label\",\"Common\"));\n\t}\n\telse if (roletype == \"\"){\n\t\terr= err.replace(\"$\",getLabel(\"Common.RoleType.label\",\"Common\"));\n\t}\n\tparent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+err;\n\t\n\t}\n\t\n}\n\nfunction getPractitioner(obj,target){\n\n\n\tvar practName_FName=\"\";\n\tvar practName_FValue=\"\";\n\tvar practId_FName=\"\";\n\tobj.value=trimString(obj.value);\n\tpractName_FName=obj.name;\n\tpractName_FValue=obj.value;\n\tvar sql1=\"\";\n\tvar sql2=\"\";\n\tpracttype  =document.forms[0].pract_type.value;\n\n\tsql1 = \"SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.PRIMARY_SPECIALITY_DESC primary_specialty, a.position_code, a.gender FROM am_practitioner_lang_vw a WHERE  a.pract_type = NVL (\'\"+practtype+\"\', a.pract_type) AND  a.eff_status = \'E\' AND  a.language_id = \'\"+localeName+\"\' AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND gender LIKE NVL(UPPER(?),gender) AND UPPER(NVL(a.POSITION_CODE ,\'123\')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,\'123\')))\";\n\n\tsql2=\"SELECT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.PRIMARY_SPECIALITY_DESC primary_specialty, a.position_code, a.gender FROM am_practitioner_lang_vw a WHERE  a.pract_type = NVL (\'\"+practtype+\"\', a.pract_type) AND  a.eff_status = \'E\' AND  a.language_id = \'\"+localeName+\"\' AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND gender LIKE NVL(UPPER(?),gender) AND UPPER(NVL(a.POSITION_CODE ,\'123\')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,\'123\')))\";\n\n\tvar xmlDoc= \"\" ;\n\tvar xmlHttp= new XMLHttpRequest();\n\n\n\txmlStr\t=\"<root><SEARCH \" ;\n\txmlStr += \" practName_FName=\\\"\" +practName_FName + \"\\\"\";\n\txmlStr += \" practName_FValue=\\\"\" + encodeURIComponent(practName_FValue) + \"\\\"\";\n\txmlStr += \" sql=\\\"\" +encodeURIComponent(sql1)+ \"\\\"\";\n\txmlStr += \" sqlSec=\\\"\" +encodeURIComponent(sql2)+ \"\\\"\";\n\txmlStr += \" practitioner_type=\\\"\" + practtype + \"\\\"\";\n\txmlStr += \" specialty_code=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" job_title=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" gender=\\\"\" + \"\" + \"\\\"\";\n\txmlStr +=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\txmlHttp.send(xmlDoc);\n\tresponseText=xmlHttp.responseText;\n\tresponseText = trimString(responseText);\n\teval(responseText);\t\n\n\n}\n\nfunction PractLookupRetVal(retVal,objName)\n{\n\tvar arr;\n\t\tif(retVal!=null){\n\t\tarr=retVal.split(\"~\");\n\t\tdocument.forms[0].pract_name_desc.value=arr[1];\n\t\tdocument.forms[0].pract_name.value=arr[0];\n     \t}\n\t\telse{\n\t\t\tdocument.forms[0].pract_name_desc.value=\"\";\n\t\t\tdocument.forms[0].pract_name.value=\"\";\n\t\t}\n\n}\n//Maheshwaran added for MMS-QH-CRF-0149\nfunction checkValidPW(obj,old_pw){\n\t  \t  \n\t  /*Below line modified for this SCF AMS-SCF-0597*/\n\t  var newPassword=obj.value;\n\t  var oldPassword=old_pw;\n\t  \n\t  if(newPassword!=\"\")newPassword=newPassword.toUpperCase();\n\t  if(oldPassword!=\"\")oldPassword=oldPassword.toUpperCase();\n\t  \n\t  if((newPassword!=\"\" && (newPassword!=oldPassword))){\n\t\t   document.forms[0].first_login_yn.value=\"R\";\n\t  }\n\t  if((newPassword!=\"\" && (newPassword==oldPassword))){\n\t\t   document.forms[0].first_login_yn.value=document.forms[0].first_login.value; \n\t  }\t  \n\t  //End this SCF AMS-SCF-0597\n\t  \n}\n   \t</script>\n\n      </head>\n\n      <!--setVal1() Added by Kamatchi S for ML-MMOH-CRF-1844.2-->\n      <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" oncontextmenu=\"return false\" onload=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="setVal1();";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="FocusFirstElement();PopPractName();\' onKeyPress=\'return ChkKey(event);\'> \n       <!--<body  onload=\'FocusFirstElement();PopPractName();\' >-->\n\n      \t<form name=\'user_form\' id=\'user_form\' action=\'../../servlet/eSM.UserServlet\' method=\'post\' target=\'messageFrame\'>\n\n\t     <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' >\n      \t\t<tr>\n      \t\t    <td  width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n      \t\t    <td  width=\'25%\' class=\'fields\'><input type=\'text\' name=\'appl_user_id\' id=\'appl_user_id\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" size=\'30\' maxlength=\'30\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" onKeyPress=\"return CheckForSpecCharsValidation2(event); return CheckForSpecCharsforID(event);\" onBlur=\'ChangeUpperCase(this);makeValidString(this);checkSpecChar();CheckSplCharsforIdValidation(this);\' onKeyUp=\"CheckForNumber(this);\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onBlur=\"ChangeUpperCase(this);makeValidString(this);checkSpecChar()\"  onKeyUp=\"CheckForNumber(this);\" onKeyPress=\"return CheckForSpecCharsforID(event)\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\n\t\t\t\t<td class=\'label\' width=\'20%\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\' width=\'30%\'>&nbsp;</td>\n      \t\t</tr>\n      \t\t<tr>\n      \t\t    <td  class=label>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n      \t\t    <td class=\'fields\'><input type=\'text\' name=\'appl_user_name\' id=\'appl_user_name\' size=\'30\' maxlength=\'60\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" onKeyPress=\"return CheckForSpecCharsValidation1(event)\" onBlur=\'CheckSplCharsValidation(this); makeValidString(this);\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n      \t\t</tr>\n      \t\t\n\t\t\t <tr>\n      \t\t    <td  class=label>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n      \t\t    <td  class=\'fields\'><select name=\'language\' id=\'language\'  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n\t\t \t \t <option value=\'\'>&nbsp;&nbsp;-------";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="------&nbsp;&nbsp;</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' selected>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" </option>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t   <option value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="> ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\n\t\t\t\t  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\n\t\t\t\t\t\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\t\t \t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n      \t\t</tr>\n\t\n\t\t\t<tr>\n      \t\t<td class=\'label\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t    <td class=\'fields\'>\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t    <input type=\'text\' id=\'eff_date_from1\' name=\'eff_date_from1\'  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" size=\'10\' maxlength=\'10\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" onblur=\'if (!this.readOnly) {validate_from_date(this);}\'><img  src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" onClick=\"document.getElementById(\'eff_date_from1\').focus();return showCalendar(\'eff_date_from1\',null,null,true);\" style=\"cursor=\'hand\'\"></td>\n\n\t\t\t<td class=label>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'text\' id=\'eff_date_to1\' name=\'eff_date_to1\'  size=\'10\' maxlength=\'10\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" onblur=\'validate_to_date(this);\' ><img  src=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" onClick=\"document.getElementById(\'eff_date_to1\').focus();return showCalendar(\'eff_date_to1\',null,null,true);\" style=\"cursor=\'hand\'\"></td>\n\t\t\t\n      \t\t</tr>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n      \t<tr>\n<td class=\"label\"  >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n<td class=\"fields\" colspan=\'2\' ><textarea name=\'long_name\' id=\'long_name\'  rows=\'4\' cols=\'72\' ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" onKeyPress=\"return CheckForSpecCharsValidation1(event); checkMaxLimit(this,300);\" onBlur=\'CheckSplCharsValidation(this); return maxLength(this,\"300\");\' onpaste=\'return maxLengthPaste(this,\"300\");\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\tonKeyPress=\'checkMaxLimit(this,300);\' onpaste=\'return maxLengthPaste(this,\"300\");\' onBlur=\'return maxLength(this,\"300\");\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</textarea><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\t\n\n</td>\n<td class=\'label\'  >&nbsp;</td>\n\t<td class=\'fields\' ></td>\n\t\t</tr>\n<tr>\n\n<!--Added by Kamatchi S for ML-MMOH-CRF-1844.2-->\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n<td class=\'label\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n<td class=\'fields\'><input type=\'checkbox\' name=\'link_ad_user\' id=\'link_ad_user\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" onClick=\"setVal(this)\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="></td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t<td  class=label>\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t</td>\n\t<td class=\'fields\' clospan=\'2\'>\n\t\t<input type=\'text\' name=\'active_dir_id\' id=\'active_dir_id\' size=\'91\' maxlength=\'80\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" onBlur=\"makeValidString(this);activeDirIdBlur(active_dir_id);\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="><input type=\'button\' class=\'button\'  value=\'?\'  id=\'active_dir_id_btn\'   onClick=\'activeDirId(active_dir_id);\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="><img id=\"active_dir_img\" style=\"visibility:hidden\" src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t<td  class=label>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t<td class=\'fields\' clospan=\'2\'><input type=\'text\' name=\'active_dir_id\' id=\'active_dir_id\' size=\'91\' maxlength=\'80\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" ></td>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\n<td class=\'label\'  >&nbsp;</td>\n\t<td class=\'fields\' ></td>\n\n\n</tr>\t\t\n      \t\t<tr>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\n      \t\t     <td class=\'label\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n      \t\t     <td class=\'fields\'><input type=\'checkbox\' name=\'eff_status\' id=\'eff_status\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" onClick=\"change()\"></td>\n\t\t\t\t <td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n      \t\t</tr>\n   \n\t\t<tr><td class=\'columnheader\' colspan=\'4\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td></tr>\n      \t<tr>\n\t      \t    <td class=\'label\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n  \t   ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n      \t\t    <td class=\'querydata\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n      \t\t    ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t    <td class=\'querydata\' >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n      \t\n      \t\t    <td class=\'label\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t      \t    <td class=\'fields\'><input type=\'text\' name=\'contact_tel_no\' id=\'contact_tel_no\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"  onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" >\n\t      \t    </td>\n\t</tr>\n\t<tr>\n\t      \t    <td class=\'label\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" </td>\n      \t\t    <td class=\'fields\'><input type=\'text\' name=\'contact_fax_no\' id=\'contact_fax_no\' size=\'20\' maxlength=\'20\' onBlur=\"makeValidString(this)\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" ></td>\n\t       \t    <td class=\'label\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t    <td class=\'fields\'><input type=\'text\' name=\'email_id\' id=\'email_id\' size=\'25\' maxlength=\'50\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"  onBlur=\"makeValidString(this);if(this.value != \'\'){emailvalidate(this)}\" ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" >\n\t\t\t  \t</td>\n    </tr>\n      \t\t\t\n\n      <tr>\t<td class=\'columnheader\' colspan=\'4\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td></tr>\n\t\n\t\t <tr> \n\t\t <td  class=label> ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t  <td class=\'fields\'><select name=\'role_type\' id=\'role_type\' onChange=\'PopPractType();PopPractName()\'  ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="  >\n\t\t\t\t\t\t <option value=\'\'>-----------";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="---------</option>\n\t\t\t\t\t\t <option value=\'P\' ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</option>\n\t\t\t\t\t\t <option value=\'O\' ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</option>\n\t\t\t\t\t\t\n\t\t\t\t\t\t </select>\n\t\t\t</td>\n\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t <td class=label id=\'typeLabl\' nowrap>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t     <td class=\'fields\'><select name=\'pract_type\' id=\'pract_type\' onChange=\'PopPractName1();\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =">\n\t\t \t \t\t\t\t\t <option value=\'\'>&nbsp;&nbsp;---------";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="----------&nbsp;&nbsp;</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t\t</select><img id=\'pract_type_gif\' src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\'visibility:";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' ></img>\n\t\t\t  </td>\n\t\t\t  <td id =\'typeLablName\' class=label>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t  <td class=\'fields\'><input type=\'text\' name=\'pract_name_desc\' id=\'pract_name_desc\' onBlur=\"makeValidString(this);if(this.value != \'\'){displayUser(this,pract_name_desc,pract_name);} else { clearName()}\" ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"   size=\'25\' maxlength=\'30\' readOnly><input type=\'hidden\' name=\'pract_name\' id=\'pract_name\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="><input type=\'button\' class=\'button\'  value=\'?\'  id=\'prid\' disabled  onClick=\'displayUser(this,pract_name_desc,pract_name)\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="><img id=\'pract_name_gif\'src=\'../../eCommon/images/mandatory.gif\' align=\'center\'  style=\'visibility:";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'  ></img>\n\t\t\t\t\t\t\t\t\n\t\t\t</td>\n\t\t\t</tr>\n\t\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="<script>\n\t\t\t\tdocument.getElementById(\'typeLabl\').innerText=getLabel(\"Common.practitionertype.label\",\"Common\");\n\t         \tdocument.getElementById(\'typeLablName\').innerText=getLabel(\"Common.practitionername.label\",\"Common\");\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t  <script>\t\n\t\t\t\tdocument.getElementById(\'typeLabl\').innerText=getLabel(\"Common.OtherStaffType.label\",\"Common\");\n\t         \tdocument.getElementById(\'typeLablName\').innerText=getLabel(\"Common.OtherStaffName.label\",\"Common\");\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t  <script>\n\t\t\t\tdocument.getElementById(\'typeLabl\').innerText=getLabel(\"eSM.FunctionalType.label\",\"SM\")\n\t         \tdocument.getElementById(\'typeLablName\').innerText=getLabel(\"eSM.FunctionalName.label\",\"SM\")\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\n\n\t\t <tr><td class=\'columnheader\' colspan=\'4\'>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td></tr>\n\t\t\n\t\t <tr>\n\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n    \t\t<td class=\'fields\' ><select name=\'resp_group_id\' id=\'resp_group_id\' ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" >\n\t\t\t\t\t\t\t<option value=\'\'>--------------";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="-----------</option>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' selected> ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'> ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t\t </select>&nbsp;&nbsp;\n    \t\t\t\t     </td>\n\n\t\t\t\t<td  class=label nowrap>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n      \t\t    <td  class=\'fields\'><input type=\'text\' name=\'employee_no\' id=\'employee_no\' size=\'10\' maxlength=\'10\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" onBlur=\"makeValidString(this)\"  ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" ></td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n    \t\t\t <td class=\'fields\' ><select name=\'responsibility_group\' id=\'responsibility_group\' ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t </select>\n    \t\t\t\t     </td>\n\t\t\t\t <td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t <tr>\n\t\t\t\t <td  class=label nowrap>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</td>\n      \t\t    <td  class=\'fields\'><input type=\'text\' name=\'rpt_output_dir\' id=\'rpt_output_dir\' size=\'20\' maxlength=\'60\' value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" onBlur=\"makeValidString(this)\"   ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" ></td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t</tr>\n\n\n\t <tr><td class=\'columnheader\' colspan=\'4\'>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td></tr>\n\t\n      \t<tr>\n      \t\t    <td class=\'label\' >";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t      \t    </td>\n\t\t\t\t<!--chk_pass(); in onblur was added by Maheshwaran K for the Password Valiation as on 11/07/212-->\n\t      \t    <td class=\'fields\'><!--input type=\'password\' name=\'appl_user_password\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" onBlur=\"chk_pass(); makeValidString(this)\" onChange=\"checkLen_1(this)\"  ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="  onkeypress=\"return CheckForSpecCharsforID(event);checkMaxLimit(this,20);\" OnKeyUp=\'CheckSpecialChar(this);CheckForNumber(this)\' -->\n\t\t\t\t<!--Maheshwaran K modified for the MMS-QH-CRF-0149-->\n\t\t\t\t<input type=\'password\' name=\'appl_user_password\' id=\'appl_user_password\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" onBlur=\"chk_pass();  makeValidString(this); checkValidPW(this,\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\');\" onChange=\"checkLen_1(this,\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\',\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\',";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =",";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =");\"  ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="  onkeypress=\" return  checkMaxLimit(this,20);\" OnKeyUp=\"CheckSpecialChar(this,\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'); CheckForNumber(this); \" >\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t<!--Added by Maheshwaran K for the Password Valiation as on 11/07/212-->\n\t\t\t\t<input type=\'hidden\' name=\'password_value_Y\' id=\'password_value_Y\' value=\'\'>\n\t\t\t\t<!--End-->\n\t      \t    </td>\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\'><!--input type=\'password\' name=\'appl_user_cpassword\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"  onChange=\'checkLen_2(this)\'  ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="  onkeypress=\"return CheckForSpecCharsforID(event);checkMaxLimit(this,20);\" OnKeyUp=\'CheckSpecialChar(this);CheckForNumber(this)\' -->\n\t\t\t\t<!--Maheshwaran K modified for the MMS-QH-CRF-0149-->\n\t\t\t\t<input type=\'password\' name=\'appl_user_cpassword\' id=\'appl_user_cpassword\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"  onChange=\"checkLen_1(this,\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =")\"  ";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="  onkeypress=\"return checkMaxLimit(this,20);\" OnKeyUp=\"CheckSpecialChar(this,\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'); CheckForNumber(this);\" >\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>  <!--onBlur=\"chkPassword(this)\"-->\n\t      \t    </td>\n\t</tr>\n\t<tr>\n\t\t    <td class=\'label\'>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t    </td>\n\t\t    <td class=\'fields\'><input type=\'password\' name=\'appl_pin_no\' id=\'appl_pin_no\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"  onChange=\'\'  ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =">\n\t\t    </td>\n\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t<td align=\'right\' class=label nowrap></td>\n\t\t\t\t<td align=\'left\' >&nbsp;&nbsp;\n\t\t\t\t<input type=\'button\' name=\'Unlock_User\' id=\'Unlock_User\' value=\'Unlock User\' class=\'button\' onClick=\'applyunlock();\' ></td>\n\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t</tr>\n\t<!--Maheshwaran added for MMS-QH-CRF-0149-->\n\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t<tr>\n\t <td colspan=\'3\' class=\'label\' style=\'color:red\'><b>";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</b>&nbsp;";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t</table>\n\n\n\n    ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\n      \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n      \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\n      ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\n      \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n      \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n     ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t <input type=\'hidden\' name=\'func_id\' id=\'func_id\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' >\n\t\t<input type=\'hidden\' name=\'old_password\' id=\'old_password\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' >\n\t\t<input type=\'hidden\' name=\'password_status\' id=\'password_status\' value=\'N\' >\n\t\t<input type=\'hidden\' name=\'old_resource_id\' id=\'old_resource_id\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' >\n\t\t<input type=\'hidden\' name=\'resource_status\' id=\'resource_status\' value=\'N\' >\n      \t<input type=\'hidden\' name=\'role_type1\' id=\'role_type1\' value=\'\'>\n      \t<input type=\'hidden\' name=\'pract_type1\' id=\'pract_type1\' value =\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n      \t<input type=\'hidden\' name=\'pract_name1\' id=\'pract_name1\' >\n      \t<input type=\'hidden\' name=\'resp_group_id1\' id=\'resp_group_id1\' >\n      \t<input type=\'hidden\' name=\'eff_date_from\' id=\'eff_date_from\' >\n      \t<input type=\'hidden\' name=\'eff_date_from_temp\' id=\'eff_date_from_temp\' >\n      \t<input type=\'hidden\' name=\'eff_date_to_temp\' id=\'eff_date_to_temp\' >\n      \t<input type=\'hidden\' name=\'eff_date_to\' id=\'eff_date_to\' >\n\t\t<input type=\'hidden\' name=\'appl_pin_no1\' id=\'appl_pin_no1\' value = >\n\t\t<input type=\'hidden\' name=\'old_eff_date_from\' id=\'old_eff_date_from\' value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'>\n\t\t<input type=\'hidden\' name=\'old_eff_date_to\' id=\'old_eff_date_to\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>\n\t\t<!--Below added by Suji Keerthi for MMS-MD-SCF-0173--> \n\t\t<input type=\'hidden\' name=\'old_response_id\' id=\'old_response_id\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' >\n\t    <input type=\'hidden\' name=\'responsibility_group1\' id=\'responsibility_group1\' >\n\t\t<input type=\'hidden\' name=\'response_status\' id=\'response_status\' value=\'N\' >\n\t\t<!--Ended by Suji Keerthi for MMS-MD-SCF-0173-->\n\t\t<!--Added by Maheshwaran K for the Password Validation as on 11/07/2012\n\t\tStart-->\n\t\t<input type=\'hidden\' name=\'unlock_yn\' id=\'unlock_yn\' >\n\t\t<input type=\'hidden\' name=\'ws_no\' id=\'ws_no\' value=";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =">\n\t\t<!--\t//Maheshwaran added for the MMS-QH-CRF-0149-->\n\t\t<input type=\'hidden\' name=\'allowed_spl_char_in_password\' id=\'allowed_spl_char_in_password\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n\t\t<input type=\'hidden\' name=\'enforce_password_policy_yn\' id=\'enforce_password_policy_yn\' value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n\t\t<input type=\'hidden\' name=\'case_sensitive_password_yn\' id=\'case_sensitive_password_yn\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\t\t\n\t\t<input type=\'hidden\' name=\'password_length_min\' id=\'password_length_min\' value=";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =">\t\n\t\t<input type=\'hidden\' name=\'password_length_max\' id=\'password_length_max\' value=";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =">\t\n\t\t<input type=\'hidden\' name=\'first_login_yn\' id=\'first_login_yn\' value=";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =">\t\t\n\t\t<!--End-->\n\t\t<!--Below line added for this SCF AMS-SCF-0597-->\n\t\t<input type=\'hidden\' name=\'first_login\' id=\'first_login\' value=";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =">\n\t\t<!--End this SCF AMS-SCF-0597-->\t\t\n\t\t<input type=\'hidden\' name=\'cur_date\' id=\'cur_date\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' >\n\n\t\t<!--Added by Ashwini on 20-Jul-2020 for AMS-SCF-0888-->\n\t\t<input type=\'hidden\' name=\'curr_effstatus\' id=\'curr_effstatus\' value=";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =">\n\n\t\t<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->\n\t\t<input type=\'hidden\' name=\'isSSOIntegrationAppl\' id=\'isSSOIntegrationAppl\' value=";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =">\n\t\t<input type=\'hidden\' name=\'defpass_sso\' id=\'defpass_sso\' value=";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =">\n\n<script>\nfunction maxLength(field,maxChars)\n{\n      //if(field.value.length >= maxChars) {\n\t   if(field.value.length > maxChars) {\n\t     var errors1 = getMessage(\'OBJ_CANNOT_EXCEED\',\'Common\');\n\t\terrors1 = errors1.replace(\'$\', maxChars);\t\t  \n\t\t  alert(errors1); \n             field.select();\n             field.focus();\t\t  \n         return false;\n      }\n\t   else{\n\t     return true;\n\t   }\n}    \n\nfunction maxLengthPaste(field,maxChars)\n{\n     event.returnValue=false;\n     if((field.value.length +  window.clipboardData.getData(\"Text\").length) > maxChars) {\t \n\t     var errors1 = getMessage(\'OBJ_CANNOT_EXCEED\',\'Common\');\n\t\terrors1 = errors1.replace(\'$\', maxChars);\t\t  \n\t\t  alert(errors1);  \n\t    return false;\n     }\n     event.returnValue=true;\n}\nfunction ChkKey(evnt)\n{ \n\tif(evnt.keyCode == \'13\')\n\t\treturn false;\n}\n</script>\t\t\n\n      \t</form>\n      \t</body>\n      \t</html>\n\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

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
   
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

  request.setCharacterEncoding("UTF-8");
  String locale					= (String)session.getAttribute("LOCALE");
  String visibilityPract="hidden";
  String lang_id			="";
  String practName = request.getParameter("practName");
 	if(practName == null) practName="";
 	 String diffdate = "0";
   String redOnly = "";
   String appl_user_id="";
   String appl_user_name="";
   String appl_user_password="";
   String appl_pin_no="";
   String reporting_facility="";
   StringBuffer str1=new StringBuffer();
   String facilityid="";
   String facilityname="";
   String telephone="";
   String fax="";
   String email="";
   String cpassword="";
   String effdatefrom="";
   String effdateto="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   String dat="";
   String id="";
   String sel="";
   String resp_group_id="";
   String responsibility_group=""; //Added by Suji Keerthi for MMS-MD-SCF-0173
   String func_id="";
	String fnvalue="insert";
   String appl_pract_type="";
	String	appl_pract_name="";
	String	employee_no="";
	String FIRST_LOGIN_YN="N";
	String responsibility_grp="";
	String reports_home_dir="";

   boolean newUser=false;
   boolean isSplCharNotAllowApplYN=false; //Added by Suji Keerthi for MOHE-CRF-0113 US001
   
   //Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
   boolean isSSOIntegrationAppl = false;
   String defpass_sso = "";

   // Added by sri
   String str12="";
   String str21="";
	//Added by Maheshwaran K for the Password Validation as on 11/07/2012
	//Start
	String ws_no="";
	//End
	String old_eff_date_from="";
	String old_eff_date_to="";
	String eff_date_from="";
	String eff_date_to="";
	String sql = "";
	String selP ="";
	String selO ="";
	String appluserlongname="";
	String appluserlongname1="";
	String active_dir_id="";
	String link_ad_user="";//Added by Kamatchi S for ML-MMOH-CRF-1844.2
	Connection conn=null;
	try{
	conn = ConnectionManager.getConnection(request);
	isSplCharNotAllowApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "SPL_CHAR_NOT_ALLOWED"); //Added by Suji Keerthi for MOHE-CRF-0113 US001
	
	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	isSSOIntegrationAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "SSO_INTEGRATION");
	HashMap hashdata  = eCommon.Common.CommonBean.getSiteSpecificDetails(conn,"SM","SSO_INTEGRATION");
	defpass_sso = (String)hashdata.get("value1");

	java.sql.Statement stmt = null;
	java.sql.Statement stmt1=null;
	java.sql.Statement stmt2=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	ResultSet rs=null;

	int countRec=0;

	
	String tel_no ="";
	String fax_no = "";
	String emailid = "";
	String func_role = "";
	String func_role_id = "";
	String pract_type = "";

	String P_flag = "N";

	String listDisable = "";
	String disableToFld = "";
	int count_am_practitioner = 0;
	//Maheshwaran added for the MMS-QH-CRF-0149
	//Start
	String ENFORCE_PASSWORD_POLICY_YN="";
	String CASE_SENSITIVE_PASSWORD_YN="";
	String ALLOWED_SPL_CHAR_IN_PASSWORD="";
	int PASSWORD_LENGTH_MIN=0;
	int PASSWORD_LENGTH_MAX=0;
	//End
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;

try {
	
		String sqlforAM  = "";
		if(conn!= null)
		sqlforAM  = "select count(1) from all_tables where table_name='AM_PRACTITIONER'";
		stmt1 = conn.createStatement() ;
		rset = stmt1.executeQuery(sqlforAM) ;
		while(rset.next())
		{
			count_am_practitioner=rset.getInt(1);
		}			
	
	appl_user_id=request.getParameter("appl_user_id");

	if(appl_user_id==null){

		appl_user_id="";
		appl_user_name="";
		appl_user_password="";
        if(rset!=null)rset.close();
        if(stmt1!=null)stmt1.close();
		stmt = conn.createStatement();
		String sql_user="Select role from session_roles";
		rset=stmt.executeQuery(sql_user);
		
	
		
 		String sql1="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name";
		if(rset!=null)rset.close();
 		rset=stmt.executeQuery(sql1);
 		str1.append("<select name='rep_facility_id' id='rep_facility_id'><option value=''>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------");
		while (rset.next()) {
		 facilityid=rset.getString("facility_id");
		 facilityname=rset.getString("facility_name");
		 str1.append("<option value='"+ facilityid+"'>"+facilityname);
		 }
		 str1.append("</select>");

		telephone="";
		appl_pin_no = "";
		fax="";
		email="";
		cpassword="";
		effdatefrom="";
		effdateto="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		newUser=true;
		  

	}

	else
		{
		if(stmt!=null)stmt.close();
		stmt = conn.createStatement();
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//"WS_NO" was added in the Query
		  sql = "select appl_user_id,language_id,appl_user_name,APP_PASSWORD.decrypt(appl_user_password) appl_user_password,employee_no, APP_PASSWORD.decrypt(pin_no) appl_pin_no,eff_date_from, trunc(sysdate)-trunc(eff_date_from) diffdate,eff_date_to ,ora_rsrc_group_id, eff_status, rep_facility_name facility_name, rep_facility_id, contact_tel_no, contact_fax_no , email_id,  FUNC_ROLE,resp_group_id,reports_home_dir, func_role_id, PRACT_TYPE, PRACTITIONER_NAME ,to_char(eff_date_from,'dd/mm/yyyy') eff_date_from1,to_char(eff_date_to,'dd/mm/yyyy') eff_date_to1 ,WS_NO,APPL_USER_LONG_NAME,ACTIVE_DIR_ID,FIRST_LOGIN_YN,LINK_AD_USER  from sm_appl_user_vw where  appl_user_id='"+appl_user_id+"'";
			 if(rset!=null)rset.close();
			rset = stmt.executeQuery(sql);
			if(rset!=null)
			rset.next();

			appl_user_id=rset.getString("appl_user_id");
			appl_user_name=rset.getString("appl_user_name");

			appl_user_password=rset.getString("appl_user_password");

			resp_group_id=rset.getString("ora_rsrc_group_id");
            lang_id=rset.getString("language_id")==null?"":rset.getString("language_id");
			employee_no=rset.getString("employee_no");

			tel_no = rset.getString("contact_tel_no");

			appl_pin_no = rset.getString("appl_pin_no");
			if(appl_pin_no == null) appl_pin_no = "";
			if (resp_group_id ==null   ) resp_group_id="";
			if (employee_no ==null) employee_no="";

			if(tel_no==null || tel_no.equals("") ||  tel_no.length() == 0)
				telephone="";
			else
				telephone=tel_no;

			fax_no = rset.getString("contact_fax_no");
			if(fax_no==null || fax_no.equals("") || fax_no.length() == 0)
				fax="";
			else
				fax=fax_no;

			emailid = rset.getString("email_id");
			if(emailid==null ||  emailid.equals("") || emailid.length() == 0)
				email="";
			else
				email=rset.getString("email_id");

			func_role = rset.getString("func_role");
		
 
			if(func_role==null ){
					P_flag = "N";
				}
			else{
				
					P_flag = "Y";
				}
		     if(func_role == null)
	            {
		          func_role="";
	            }
            if(!(func_role.equals("") || func_role == null ))	            
			{
				if(func_role.equals("P")){
					selP="selected";
					selO="";
				}else if(func_role.equals("O")){
					selP="";
					selO="selected";
				}else{
					selP="";
					selO="";
				}
			}
 		  
			func_role_id = rset.getString("func_role_id");
			if(func_role_id == null) func_role_id="";
			func_id = rset.getString("func_role_id");

			if(func_id == null) func_id="";
			


			pract_type=rset.getString("PRACT_TYPE");

			if(pract_type==null || pract_type.equals("") ){
					appl_pract_type = "";
			
				}
			else{
					/***************************/
					visibilityPract="visible";				
					appl_pract_type= pract_type;
					P_flag = "Y";
				}
			appl_pract_name=rset.getString("practitioner_name");

			if(appl_pract_name == null) appl_pract_name="";

			responsibility_grp=rset.getString("resp_group_id");

			if(responsibility_grp == null) responsibility_grp="";
            
			 //Below added by Suji Keerthi for MMS-MD-SCF-0173
			responsibility_group=rset.getString("resp_group_id");

			if(responsibility_group == null) responsibility_group="";
			 //Ended by Suji Keerthi for MMS-MD-SCF-0173
			
			reports_home_dir=rset.getString("reports_home_dir");

			if(reports_home_dir == null) reports_home_dir="";
			


			if(!(appl_pract_type.equals("") || appl_pract_type == null ))
				sel="SELECTED";
			else
				sel = "";
		  if ( rset.getDate("eff_date_to") != null )
		  {
			 java.util.Date date = rset.getDate("eff_date_to");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		 	 effdateto = formatter.format(date);
			 effdateto=DateUtils.convertDate(effdateto,"DMY","en",locale);
		 	 date = null;
		 	 formatter = null;
		   }else {
 		 	effdateto="";
 		   }

 		   if ( rset.getDate("eff_date_from") != null)
 		   {
			 java.util.Date date1 = rset.getDate("eff_date_from");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 effdatefrom = formatter.format(date1);
			 effdatefrom=DateUtils.convertDate(effdatefrom,"DMY","en",locale);
			  date1 = null;
			 formatter = null;
		    }else {
			effdatefrom="";
		    }
			
			eff_date_from=rset.getString("eff_date_from1");
			if( eff_date_from==null ) 
			{
				eff_date_from="";
				old_eff_date_from="";
			}
			old_eff_date_from=eff_date_from;

			
			eff_date_to=rset.getString("eff_date_to1");
			if( eff_date_to==null ) 
			{
				eff_date_to="";
				old_eff_date_to="";
			}
			old_eff_date_to=eff_date_to;
			
			diffdate = rset.getString("diffdate");

			if (diffdate==null || diffdate.equals("") || Integer.parseInt(diffdate) < 0) diffdate = "0";

	
			effstatus=rset.getString("eff_status");

			if(effstatus.equals("D"))
			{
				otherTextAttribute="READONLY";
				checkBoxAttribute="";
				listDisable = "disabled";
		/* SM */disableToFld = "disabled";
		    }
			else
			{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
								listDisable = "enabled";

		    }

		    reporting_facility=rset.getString("rep_facility_id");
			if (reporting_facility==null) reporting_facility="";
			//Added by Maheshwaran K for the Password Validation as on 11/07/2012
			//Start
			ws_no = rset.getString("WS_NO");
			if(ws_no == null) ws_no="";
			//End

			appluserlongname=rset.getString("APPL_USER_LONG_NAME");
			if(appluserlongname == null) appluserlongname="";
			active_dir_id=rset.getString("ACTIVE_DIR_ID");
			if(active_dir_id == null) active_dir_id="";
			FIRST_LOGIN_YN=rset.getString("FIRST_LOGIN_YN");
			if(FIRST_LOGIN_YN == null) FIRST_LOGIN_YN="N";
			
			//Added by Kamatchi S for ML-MMOH-CRF-1844.2
			link_ad_user=rset.getString("LINK_AD_USER");
			if(link_ad_user == null) link_ad_user="N";
			
			stmt2 = conn.createStatement();

		    String sql1="select facility_id,facility_name from sm_facility_param where facility_type='F' order by facility_name";

		    rs=stmt2.executeQuery(sql1);

		     String x="";
		     String rep_facility_id1="";
		     rep_facility_id1 = rset.getString("facility_name");
			 if(rep_facility_id1 == null) rep_facility_id1 ="";
		     
		     x = rset.getString("rep_facility_id");
			if(x == null) x="";
			if(str1.length() > 0) str1.delete(0,str1.length());
		 	str1.append("<select name='rep_facility_id' id='rep_facility_id' onClick='change1()'><option value=''>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------");
					while (rs.next()) {
						facilityid=rs.getString(1);
						 facilityname=rs.getString(2);
						 if(x.equals(facilityid))
						 str1.append("<option selected value='"+ facilityid+"'>"+facilityname);
						 else
						  str1.append("<option  value='"+ facilityid+"'>"+facilityname);
						 } str1.append("</select>");

						 str12="<input type='text' name='rep_facility_id1' id='rep_facility_id1' size='30' maxlength='30' value=\""+rep_facility_id1+"\" readonly>";
						 if(x == null) {
						 str21 = "<input type='hidden' name='rep_facility_id2' id='rep_facility_id2' size='15' maxlength='15' value='' >";
						 }
						 else if(x != null){
						 String repFacID=rset.getString("rep_facility_id");
						 if(repFacID == null) repFacID="";
						 str21 = "<input type='hidden' name='rep_facility_id2' id='rep_facility_id2' size='15' maxlength='15' value='"+repFacID+"' >";
						 }

		codeTextAttribute="READONLY";
		
		newUser=false;
		fnvalue = "modify";
		eventFunctionForCase="";
		cpassword=appl_user_password;
		if(rset!=null) rset.close();
	}
//Maheshwaran added for the MMS-QH-CRF-0149	
	try
		{
		String sql3="select ENFORCE_PASSWORD_POLICY_YN,CASE_SENSITIVE_PASSWORD_YN,ALLOWED_SPL_CHAR_IN_PASSWORD,PASSWORD_LENGTH_MIN,PASSWORD_LENGTH_MAX from sm_site_param";
		if(rset!=null)rset.close();
		rset=stmt.executeQuery(sql3);
		if(rset.next())
			{
			ENFORCE_PASSWORD_POLICY_YN=rset.getString("ENFORCE_PASSWORD_POLICY_YN");
			CASE_SENSITIVE_PASSWORD_YN=rset.getString("CASE_SENSITIVE_PASSWORD_YN");
			ALLOWED_SPL_CHAR_IN_PASSWORD=rset.getString("ALLOWED_SPL_CHAR_IN_PASSWORD");
			PASSWORD_LENGTH_MIN=rset.getInt("PASSWORD_LENGTH_MIN");
			PASSWORD_LENGTH_MAX=rset.getInt("PASSWORD_LENGTH_MAX");
			}
		if(stmt!=null)stmt.close();	
		if(rset!=null)rset.close();	
		}
	catch(Exception e)	
		{
		System.out.println("Exception in sm_site_param : "+e);
		}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(count_am_practitioner));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(isSSOIntegrationAppl){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(appl_user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(codeTextAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eventFunctionForCase));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

				
				sql="select LANGUAGE_ID,SHORT_NAME from sm_language where eff_status='E' and LANGUAGE_DIRECTION!='R' order by 2";
							if(pstmt!=null)pstmt.close();
							if(rset!=null)rset.close();

				 pstmt = conn.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
							rset = pstmt.executeQuery(sql) ;
							
							 if(rset != null)
							   {
								  rset.last();
								  countRec = rset.getRow();
								  rset.beforeFirst();
							   }

					if (countRec == 1)
					  {
						while(rset!=null && rset.next())
						  {
							
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rset.getString("LANGUAGE_ID")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rset.getString("SHORT_NAME")));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
					  }
				   else if (countRec >= 1)
				   {
				  while(rset!=null && rset.next())
				  {
								dat=rset.getString("SHORT_NAME");
								id=rset.getString("LANGUAGE_ID");
								if (id.equals(lang_id))
								sel = "selected";
								else
								sel = "";
								
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
				  }
							
				if(pstmt!=null)pstmt.close();
				if(rset!=null)rset.close();
				
								
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

				if (Integer.parseInt(diffdate)>0)
				{
					redOnly = "readonly";
				
				}
			else
				{
					redOnly = "";

				}
				
				
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(redOnly));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(effdatefrom));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disableToFld));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(effdateto));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disableToFld));
            _bw.write(_wl_block43Bytes, _wl_block43);
if(!(appluserlongname.equals("")))
{
int len = appluserlongname.length();
int i1=0;
int n_incre = 0;
int max = 0;

if (len > 75) 
{ 
    for ( i1=0; i1 <= (len/75);i1++) 
	{   
		if((i1+1)*75 < len)
			max = (i1+1)*75;
		 else
		  max = len;
		
		appluserlongname1=appluserlongname1+""+appluserlongname.substring((i1*75),max);
		n_incre = 1;
    }}
else  {
	appluserlongname1=appluserlongname;
 }}
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(appluserlongname1));
            _bw.write(_wl_block49Bytes, _wl_block49);
if(isSSOIntegrationAppl){
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(link_ad_user));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
if(isSSOIntegrationAppl){
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(active_dir_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block58Bytes, _wl_block58);
}else{
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(active_dir_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);

String isEnableEffStatus	 ="";
if(fnvalue.equals("modify") && effstatus.equals("D") && ! ws_no.equals("")){
	isEnableEffStatus	= "disabled";
}
			

            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(isEnableEffStatus));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

		if(effstatus.equals("E")) {
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(str1.toString()));
            out.print( String.valueOf(str21));
            _bw.write(_wl_block70Bytes, _wl_block70);
}
		   else if(effstatus.equals("D")){
			   
			   
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(str12));
            out.print( String.valueOf(str21));
            _bw.write(_wl_block70Bytes, _wl_block70);
}str1.setLength(0);
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(telephone));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(fax));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(email));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(selP));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(selO));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

								
								
								if(fnvalue.equals("modify") && P_flag.equals("Y"))
								{
									
								if(func_role.equals("P"))
	                            {	
									if(count_am_practitioner > 0)
									{	
										
										sql="select PRACT_TYPE, DESC_USERDEF from am_pract_type where 	eff_status 	= 'E' and sysdate >= nvl(eff_date_from,sysdate) and 	sysdate <= nvl(eff_date_to,sysdate) order by 2";
										if(stmt!=null)stmt.close();
										stmt = conn.createStatement() ;
										if(rset!=null)rset.close();
										rset = stmt.executeQuery(sql) ;	 
										while (rset.next())
										{
											dat=rset.getString("DESC_USERDEF");
											id=rset.getString("PRACT_TYPE");
											if (id.equals(pract_type))
												sel = "selected";
											else
												sel = "";
											
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rset.getString("pract_type")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rset.getString("desc_userdef")));
            _bw.write(_wl_block92Bytes, _wl_block92);

										}
									}
								 }
								 
								 else if(func_role.equals("O")) {
						
								 sql="select OTHER_STAFF_TYPE, SHORT_DESC from am_other_staff_type where eff_status = 'E' ORDER BY 2";
			
										if(stmt!=null)stmt.close();
										stmt = conn.createStatement() ;
										if(rset!=null)rset.close();
										rset = stmt.executeQuery(sql) ;	 
										while (rset.next())
										{
											dat=rset.getString("SHORT_DESC");
											id=rset.getString("OTHER_STAFF_TYPE");
											if (id.equals(pract_type))
												sel = "selected";
											else
												sel = "";
											
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rset.getString("OTHER_STAFF_TYPE")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rset.getString("SHORT_DESC")));
            _bw.write(_wl_block92Bytes, _wl_block92);

										}
											if(rset!=null) rset.close();
								 }
                               }
								
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(visibilityPract));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(appl_pract_name));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(func_role_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(visibilityPract));
            _bw.write(_wl_block100Bytes, _wl_block100);

		if(fnvalue.equals("modify")){
		if(!(func_role.equals("") || func_role == null )){	            
        if(func_role.equals("P"))
		    {
            _bw.write(_wl_block101Bytes, _wl_block101);
}else if(func_role.equals("O")){
            _bw.write(_wl_block102Bytes, _wl_block102);
}else {
            _bw.write(_wl_block103Bytes, _wl_block103);
}
		  }
		}
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
 
							 String sqlresp="select ora_rsrc_group_id,ora_rsrc_group_name from sm_ora_rsrc_grp ";
							 if(stmt!=null)stmt.close();
							 stmt=conn.createStatement();
							 ResultSet rsresp = stmt.executeQuery(sqlresp);
							  while(rsresp.next()){
							id=rsresp.getString("ora_rsrc_group_id");
							dat=rsresp.getString("ora_rsrc_group_name");

							if(id.equals(resp_group_id))
							{
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(id ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block111Bytes, _wl_block111);
}
							else
								{
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(id));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block114Bytes, _wl_block114);
}

							  }
							  if(rsresp!=null) rsresp.close();
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(employee_no));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
 
							 sqlresp="select resp_group_id,resp_group_name from sm_resp_grp where eff_status='E' order by 1 ";
							 rsresp = stmt.executeQuery(sqlresp);
							  while(rsresp.next()){
								id=rsresp.getString("resp_group_id");
								dat=rsresp.getString("resp_group_name");

								if(id.equals(responsibility_grp))
								{
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block114Bytes, _wl_block114);
}
								else{
								
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(id));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block114Bytes, _wl_block114);
}

							  }
							  if(rsresp!=null) rsresp.close();
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(reports_home_dir));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(listDisable));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(appl_user_password));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(appl_user_password));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(appl_user_password));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(PASSWORD_LENGTH_MIN));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(cpassword));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(cpassword));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(PASSWORD_LENGTH_MIN));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(appl_pin_no));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block147Bytes, _wl_block147);

			//Added by Maheshwaran K for the Password Validation as on 11/07/2012
			//Start
			if(fnvalue.equals("modify") && effstatus.equals("D") && ! ws_no.equals(""))
				{
				
            _bw.write(_wl_block148Bytes, _wl_block148);
 
				}
			//End
		
            _bw.write(_wl_block149Bytes, _wl_block149);
if(ENFORCE_PASSWORD_POLICY_YN.equals("Y")) {
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(ALLOWED_SPL_CHAR_IN_PASSWORD));
            _bw.write(_wl_block152Bytes, _wl_block152);
}
            _bw.write(_wl_block153Bytes, _wl_block153);
  if(newUser){
            _bw.write(_wl_block154Bytes, _wl_block154);
}else { // function_name = "modify";
            _bw.write(_wl_block155Bytes, _wl_block155);
}
		if(rs!=null) rs.close();
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();
		if(stmt2 != null) stmt2.close();
     	}
		catch(Exception e){out.print(e);}
		
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(func_id));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(appl_user_password));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(resp_group_id));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(old_eff_date_from));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(old_eff_date_to));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(responsibility_group));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(ws_no));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(ENFORCE_PASSWORD_POLICY_YN));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(CASE_SENSITIVE_PASSWORD_YN));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(PASSWORD_LENGTH_MIN));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(PASSWORD_LENGTH_MAX));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(FIRST_LOGIN_YN));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(FIRST_LOGIN_YN));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(dateFormat.format( new java.util.Date() ) ));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(isSSOIntegrationAppl));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(defpass_sso));
            _bw.write(_wl_block175Bytes, _wl_block175);

		}catch(Exception e){out.println(e);}
		finally { 
					ConnectionManager.returnConnection(conn,request);
				}	
		
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PreferredLanguage.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longname.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.LinkActDirUser.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ActiveDirectoryID.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ActiveDirectoryID.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RepFacility.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.telephone.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fax.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.FunctionalRoleDetails.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RoleType.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherStaff.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.FunctionalType.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.FunctionalName.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ResourceGroup.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmployeeNo.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ResponsibilityGroup.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.ReportOutputDirectory.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.password.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.password.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConfirmPassword.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PINNo.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PASSWORD_POLICY.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.PASSWORD_POLICY1.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
