package jsp_servlet._eae._jsp;

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
import eCommon.Common.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aeregisterattnvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AERegisterAttnValidations.jsp", 1743149012827L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AERegisterAttn.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eBL/js/AddModifyPatFinDetails.js\' language=\'Javascript\'></script>\n<script> \nvar alternate_id_cont_yn = \"Y\";\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\n\t\t\t\tif(window.confirm(get_message_text1(\'PAT_SUSPENDED_CONTINUE\',\'AE\'))){\n\t\t\t\t}else{\n\t\t\t\t\tsetValue();\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\talert_yn = \'N\'; \n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t}\n\t\t\t\tdocument.forms[0].suspended.value=\'Y\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tif(window.confirm(get_message_text1(\'PAT_DECEASED_CONTINUE\',\'AE\'))){\n\t\t\t\t\t}else{\n\t\t\t\t\t\tsetValue();\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\talert_yn = \'N\'; \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t}\n\t\t\t\t\tdocument.forms[0].deceased.value=\'Y\';\n\t\t\t\t\t</script>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.value=\'\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tif(window.confirm(get_message_text1(\'PAT_INACTIVATED_CONTINUE\',\'AE\'))){\n\t\t\t\t\t}else{\n\t\t\t\t\t\tsetValue();\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\talert_yn = \'N\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t}\n\t\t\t\t\tdocument.forms[0].inactive.value=\'Y\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tasync function AEERegisterAttnValidationfn(){\n\t\t\t\t\t\t\t\t\tif(confirm(getMessage(\'PAT_DISPOSED_REGISTER\',\'MP\'))){\t\n\t\t\t\t\t\t\t\t\t\tvar retVal =  new String();\n\t\t\t\t\t\t\t\t\t\tvar dialogTop   = \"65\";\n\t\t\t\t\t\t\t\t\t\tvar dialogHeight    = \"44vh\" ; //30.5\n\t\t\t\t\t\t\t\t\t\tvar dialogWidth = \"65vw\" ;\n\t\t\t\t\t\t\t\t\t\tvar features  = \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no; scroll=no\";\n\t\t\t\t\t\t\t\t\t\tvar arguments = \"\" ;\n\t\t\t\t\t\t\t\t\t\tvar function_id = \'VISIT_REGISTRATION\';\n\t\t\t\t\t\t\t\t\t\tvar url=\"../../eMP/jsp/PatientRegistrationMain.jsp?&module_id=MP&function_id=\"+function_id+\"&function_type=F&access=YYYNN&func_act=Visitreg\";\n\t\t\t\t\t\t\t\t\t\tretVal =await window.showModalDialog(url,arguments,features);\n\t\t\t\t\t\t\t\t\t\tif(retVal){\n\t\t\t\t\t\t\t\t\t\t\tif( retVal != null || retVal.length != 0)\n\t\t\t\t\t\t\t\t\t\t\t\tparent.close();\n\t\t\t\t\t\t\t\t\t\t\t\t top.content.frames[1].frames[0].document.forms[0].patient_id.value =retVal;\n\t\t\t\t\t\t\t\t\t\t\t\t top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();\n\t\t\t\t\t\t\t\t\t\t}   \n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t top.content.frames[1].frames[0].document.forms[0].patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\t top.content.frames[1].frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\tAEERegisterAttnValidationfn();\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif(confirm(getMessage(\'PAT_ACTIVATE\',\'MP\'))){\t\n\t\t\t\t\t\t\tvar xmlDoc = \"\";\n\t\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\t\t\txmlStr =\'<root><SEARCH /></root>\';\n\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\txmlHttp.open(\'POST\',\'../../eMP/jsp/MPIntermediate.jsp?action=activate_pat&patientId=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',false);\n\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\tresponseText=xmlHttp.responseText;\n\t\t\t\t\t\t\tresponseText = trimString(responseText);\n\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.onblur();\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t top.content.frames[1].frames[0].document.forms[0].patient_id.value=\"\";\n\t\t\t\t\t\t\t top.content.frames[1].frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<script>\t\t\t\n\t\t\t\t\t\tvar error= getMessage( \"PATIENT_MERGED_VALID\",\'MP\');\n\t\t\t\t\t\terror = error.replace(\'#\',\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\");\t\t\t\t\n\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.disabled=false;\n\t\t\t\t\t    top.content.frames[1].frames[0].document.forms[0].patient_id.value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"\t\t\t\t\t\t\t\n\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.select();\n\t\t\t\t\t\talert(error);\t\n\t\t\t</script> \n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar message= getMessage(\'NATID_ALTID_NOT_AVAILABLE_UPDATE\',\'MP\'); \n\t\t\t\t\t\t\tmessage = message.replace(\'#\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');\n\t\t\t\t\t\t\tshoModalCall(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\tmessage = message.replace(\'#\',getLabel(\'Common.country.label\',\'Common\'));\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\tmessage = message.replace(\'#\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\');\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar cr_prompt = getLabel(\'Common.country.label\',\'Common\')+\' \'+getLabel(\'Common.and.label\',\'Common\')+\' \'+\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\';\n\t\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\t\tmessage = message.replace(\'#\',cr_prompt);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\t\tmessage = message.replace(\'#\',getLabel(\'Common.country.label\',\'Common\'));\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\t\tmessage = message.replace(\'#\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<script>\n\t\t\t\tasync function AEERegisterAttnValidationfn1(){\n\t\t\t\tif(confirm(message)){\n\t\t\t\t\t\n\t\t\t\t\tvar dialogTop   = \'-13px\'; //65\n\t\t\t\t\tvar dialogHeight    = \'94vh\' ; //44\n\t\t\t\t\tvar dialogWidth = \'75vw\' ;//65\n\t\t\t\t\tvar features  = \'dialogTop:\' + dialogTop + \'; dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';status=no; scroll=no\';\n\t\t\t\t\tvar arguments = \'\' ;\n\t\t\t\t\tvar retVal = \'\';;\n\t\t\t\t\tvar url=\'../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&load_tab=CONTACT_ADDR_TAB&Patient_ID=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\n\t\t\t\t\tretVal =await  window.showModalDialog(url,arguments,features);\n\t\t\t\t\tif(retVal){\n\t\t\t\t\t\t//Below Modified by Suji Keerthi for PAS-AE-AE Transaction-Register Attendance\n\t\t\t\t\t\tif(top.content.frames[1].frames[0].document.forms[0].National_Id_No.value!=\"\"){\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.value = \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\t\t\t\t\t\t\tif(top.content.frames[1].frames[0].document.forms[0].patient_id.value!=\"\")\n\t\t\t\t\t\t\t       top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();\n\t\t\t\t\t\t           else if(top.content.frames[1].frames[0].document.forms[0].referal_id.value!=\"\")\n\t\t\t\t\t\t\t          top.content.frames[1].frames[0].document.forms[0].referal_id.onblur();\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\tif(top.content.frames[1].frames[0].document.forms[0].patient_id.value!=\"\")\n\t\t\t\t\t\t\t          top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();\n\t\t\t\t\t\t              else if(top.content.frames[1].frames[0].document.forms[0].referal_id.value!=\"\")\n\t\t\t\t\t\t\t             top.content.frames[1].frames[0].document.forms[0].referal_id.onblur();\n\t\t\t\t\t\t\t\t}\t\n\t\t\t\t\t}else{\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t//parent.window.close();\n\t\t\t\t\t\t\twindow.document.getElementById(\'dialog_tag\').close();\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.value=\"\";\n\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t//parent.window.close();\n\t\t\t\t\t\t\twindow.document.getElementById(\'dialog_tag\').close();\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tAEERegisterAttnValidationfn1();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" \n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar message=getMessage(\'NATID_ALTID_NOT_AVAILABLE\',\'MP\'); \n\t\t\t\t\t\tmessage = message.replace(\'#\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\n\t\t\t\t\t\talert(message);\n\t\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.value=\"\";\n\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" \n\t\t\t\t\t<script>alert(getMessage(\"VALIDATE_NATIONAL_ID\",\'MP\'));</script> \n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(confirm(getMessage(\'UHID_EXPIRED\',\'MP\'))){\t\n\t\t\t\t\t\t\t\t\tvar check = blUHIDBillchk(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'AE_REGISTER_ATTN\',\'AE\',\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\');\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tif(check == \'Y\')\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tif(top.content.frames[1].frames[0].document.forms[0].patient_id.value!=\"\")\n\t\t\t\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.onblur();\n\t\t\t\t\t\t\t\t\t\telse if(top.content.frames[1].frames[0].document.forms[0].referal_id.value!=\"\")\n\t\t\t\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].referal_id.onblur();\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}else{\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.focus();\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<script>\n\t\t\t\t\ttop.content.frames[1].frames[0].document.forms[0].patient_id.value=\'\';\n\t\t\t\t\t</script>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t <script>  \n\t\t  var practname\t\t= \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" ;\t\n\t\t  var clinicname\t= \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" ;\n\t\t  var lastvist=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t  mess = get_message_text1(\"AE_ALREADY_VISIT_LOCN\",\"AE\")+\"  \"+clinicname+\" \"+\"on\"+\" \"+lastvist+\"\\n\";\n\n\t\t if(mess != \'\' && alert_yn == \'Y\') \n\t\t  {\n\t\t\t  alert(mess);\n\t\t  }\n\t\t </script>\n\t\t\t\n        ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\n\n\t </form>\n\t </body>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
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
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
     
String locale			= (String)session.getAttribute("LOCALE");
String sStyle			=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute(
"PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE")
:"IeStyle.css";
out.println("<html><head> <link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body class='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

out.println("<script language='javascript' src='../../eCommon/js/common.js'></script>");
out.println("<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>");
out.println("<script language='javascript' src='../../eAE/js/AERegisterAttn.js'></script>\n"+
			"<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>");
out.println("<script>");
out.println("var alert_yn='Y'") ;
out.println("	function get_message_text(message,moduleid,prompt)");
out.println("	{");
out.println("		var message_text;");
out.println("		message_text = getMessage(message,moduleid);");
out.println("	    return message_text;");
out.println("	}");
out.println("	function get_message_text1(message,moduleid,prompt)");
out.println("	{");
out.println("		var message_text;");
out.println("		message_text = getMessage(message,moduleid);");
out.println("	    return message_text;");
out.println("	}");
out.println("</script>");
out.println("</head>");
out.println("<form name='ae_validations_form' id='ae_validations_form'  method='post' target='messageFrame'>	<input type='hidden' name='deceased' id='deceased' value='N'><input type='hidden' name='suspended' id='suspended' value='N'><input type='hidden' name='inactive' id='inactive' value='N'>");

        Connection con               = null;
    	PreparedStatement pstmt		 = null,pstmt1 = null,deceased_pstmt =	null;
        ResultSet rset               = null,deceased_rslt =	null;
		ResultSet     rs              = null;
		String patientId			 = "";
		String patient_id			 = request.getParameter("P_Patient_ID");
		String patFlag               = checkForNull(request.getParameter("patFlag"));
			String lastvist="";
	// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
	
		String max_hrs_for_re_attend  =request.getParameter("max_hrs_for_re_attend");
		 Double max_hrs_for_re_attend1 = new Double(max_hrs_for_re_attend);
		   
	//end CRF  Bru-HIMS-CRF-152 [IN030272]

		
		String pat_id				 = checkForNull(request.getParameter("P_Patient_ID"));
		String referral_id			 = checkForNull(request.getParameter("referal_id"));
		String params			     = checkForNull(request.getParameter("params"));
		String facility_id			 = (String)session.getValue("facility_id");
		String bl_install_yn         = (String)session.getValue("bl_operational");
		char alert_yn				 = 'Y';
	    String warning_text			 = "";
		String prompt				 = "";
	    String beginHtml			 = "<html><script>";
	    String endHtml			     = "</script></html>";
        String HcExpired             = "N";
		String episodeValidation	 =  checkForNull(request.getParameter("episodeValidation"));
		String oper_stn_id			 = checkForNull(request.getParameter("oper_stn_id"));

		//String p_alt_id2_type		 = checkForNull(request.getParameter("p_alt_id2_type"));
		//String p_alt_id3_type		 = checkForNull(request.getParameter("p_alt_id3_type"));
		//String p_alt_id4_type		 = checkForNull(request.getParameter("p_alt_id4_type"));
		String entitlement_by_cat_yn = checkForNull(request.getParameter("entitlement_by_cat_yn"));
		String nat_id_prompt		 = checkForNull(request.getParameter("nat_id_prompt"));

		String q_clinic_code = "";
		String q_appt_ref_no = "";
		String reg_attendance_for_inpat_yn =  checkForNull(request.getParameter("attendance_for_inpat_yn"));
        String national_id_no	=	checkForNull(request.getParameter("National_Id_No"));
		String national_id_flag	=	checkForNull(request.getParameter("National_Id_Flag"));
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		String frameRef				= checkForNull(request.getParameter("frameRef"),"top.content");
		String invoke_from	=	checkForNull(request.getParameter("invoke_from"));
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/

		String nat_ID_sql	=	"";
		String deceased_count	=	"";
		String deceased_sql		=	"";
		String practName	= "";
		String clinicName	= "";
		String visit_status			  = "";
		//String practitioner_name	  = "";
		String patient_class		  = "";
		String visit_adm_date_time	  = "";
		double prev_visit_hrs    = 0d;
		PreparedStatement nat_ID_pstmt	=	null;
		ResultSet nat_ID_rs	=	null;
		boolean isUHID_valid_appl = false; // Added by mujafar for AMRI-CRF-0357 
		Boolean isNationalIdValidationAppl = false; //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148

		try{
                con = ConnectionManager.getConnection(request);

		
		/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
		JSONObject aeParamJson		= new JSONObject();
		aeParamJson					= eAE.AECommonBean.getAEParam(con, facility_id);
		isUHID_valid_appl  = CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357

		isNationalIdValidationAppl = CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION"); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	
		String invokeRecallForAE	= (String)aeParamJson.get("invokeRecallForAE");
		/*End ML-MMOH-CRF-0657*/
		boolean isInvokeChngPatDtls  = CommonBean.isSiteSpecific(con, "MP","MP_RESIDENCY_NAT_ALT1_ID_MAND"); // Added by Dharma on 25th Apr against MMS-DM-CRF-0152.1 [IN:070226]
		boolean isChkMPParamMandFlds = CommonBean.isSiteSpecific(con, "MP", "MP_CHK_MAND_FLDS"); /*Added by Dharma on 15th May 2020 against KDAH-CRF-0522.1*/
		boolean isNatIdAltIdMandVisaType = CommonBean.isSiteSpecific(con, "MP", "MP_VAL_VISA_TYPE");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
		boolean isCountryRegionValAppl = CommonBean.isSiteSpecific(con, "MP", "CHECK_COUNTRY_REGION");//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1

/*	  pstmt=con.prepareStatement("SELECT ALT_ID1_TYPE, ALT_ID2_TYPE, ALT_ID3_TYPE, ALT_ID4_TYPE,ENTITLEMENT_BY_PAT_CAT_YN,NAT_ID_PROMPT FROM MP_PARAM WHERE MODULE_ID='MP' ");

rset = pstmt.executeQuery();

if(rset!=null)
{
while(rset.next())
{           
p_alt_id2_type        = rset.getString(2);
p_alt_id3_type        = rset.getString(3);
p_alt_id4_type        = rset.getString(4);
entitlement_by_cat_yn = rset.getString("ENTITLEMENT_BY_PAT_CAT_YN");
nat_id_prompt = rset.getString("NAT_ID_PROMPT")==null?"":rset.getString("NAT_ID_PROMPT");
if(entitlement_by_cat_yn == null) entitlement_by_cat_yn="N";
}
}
if(rset!=null) rset.close();
if(pstmt!=null) pstmt.close(); 
*/


    try{

		 if (national_id_flag.equals("Y")) {
			   try	{
			 	  if(!pat_id.equals("")) {
					  patient_id = pat_id;
				  } else {
					  nat_ID_sql	=	"select patient_id from mp_patient where national_id_no = '"+national_id_no+"'";
					  nat_ID_pstmt	=	con.prepareStatement(nat_ID_sql);
					  nat_ID_rs		=	nat_ID_pstmt.executeQuery();
					  if(nat_ID_rs.next()) {
						patient_id=nat_ID_rs.getString(1);
					  }	else {
						out.println(beginHtml+"var msg = getMessage('INVALID_VALUE','COMMON'); msg = msg.replace('#','"+nat_id_prompt+"'); alert(msg);"+endHtml);
						out.println(beginHtml+"enableAll();"+endHtml);
					 }	
				}
			 }	catch(Exception e) {
					{e.printStackTrace(); }
			 }	finally	{
					 if(nat_ID_pstmt!=null)nat_ID_pstmt.close();
					 if(nat_ID_rs!=null)nat_ID_rs.close();
			 }

		} else {

              
		try 
			{              
			  if(!pat_id.equals(""))
              {
               patient_id = pat_id;
              }
			  else
			  {	
				  StringBuffer sqlPR = new StringBuffer();
				  //sqlPR.append("select 1 from PR_REFERRAL_REGISTER a, op_clinic b  where a.REFERRAL_ID= ? and a.STATUS!='C' AND a.TO_FACILITY_ID=b.FACILITY_ID AND A.TO_LOCN_CODE=b.CLINIC_CODE AND b.LEVEL_OF_CARE_IND='E'");
				  sqlPR.append("select 1 from PR_REFERRAL_REGISTER a where a.REFERRAL_ID= ? and a.STATUS!='C' AND A.TO_LOCN_TYPE='C'   AND A.TO_FACILITY_ID ='"+facility_id+"' AND (A.TO_LOCN_CODE IS NULL OR (A.TO_LOCN_CODE IS NOT NULL AND 'E'= (SELECT LEVEL_OF_CARE_IND FROM OP_CLINIC WHERE FACILITY_ID=a.TO_FACILITY_ID AND CLINIC_CODE=A.TO_LOCN_CODE) ))");
				  pstmt1  = con.prepareStatement(sqlPR.toString());
				  pstmt1.setString(1, referral_id);

				  rs = pstmt1.executeQuery();     
                  if(!rs.next()) 
                  {
					  out.println(beginHtml+"alert(get_message_text('INVALID_REF_ID','OP'));"+endHtml);
					  out.println(beginHtml+"enableAll();"+endHtml);
				  if(rs!=null)rs.close();
                  if(pstmt1!=null)pstmt1.close();
				  
				  }
				  else
				  {
					  StringBuffer sqlPR1 = new StringBuffer();
				      sqlPR1.append("select patient_id from pr_referral_register where ");
				      sqlPR1.append("referral_id= ? ");
				      pstmt1  = con.prepareStatement(sqlPR1.toString());
				      pstmt1.setString(1, referral_id);

				      rs = pstmt1.executeQuery();     
						if (rs!=null) 
						{
						 while (rs.next())
							{
							 patientId = rs.getString("patient_id");   
							}
						}
						if(patientId == null) patientId = "";
						/*Modified by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
						/*Modified by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
						if(patientId.equals(""))
							{
                            out.println("<script language = 'JavaScript'> async function toSetPatID(){ var pat_id='';var patientID=''; pat_id= await show_patwindowReferral('"+q_clinic_code+"','"+q_appt_ref_no+"','"+referral_id+"'); console.log(pat_id); if(pat_id!=null && pat_id!='x'){ var patFlag=pat_id.charAt(0); if(patFlag=='Y'){  patientID=pat_id.substring(1,pat_id.length);pat_id=patientID;}else{patFlag='N'; patientID=pat_id}top.content.frames[1].frames[0].document.forms[0].patient_id.value=patientID;top.content.frames[1].frames[0].document.forms[0].patFlag.value=patFlag; top.content.frames[1].frames[0].document.forms[0].referal_id.onblur(); var invoke_recall = '"+invokeRecallForAE+"'; if(invoke_recall == \"Y\"){var cnt_yn=followUpCount(pat_id); if(cnt_yn == \"Y\") {var enc_id=showFollowUpEncounters(pat_id); top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+patientID;top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID='+patientID+'&oper_stn_id="+oper_stn_id+"&patFlag='+patFlag+'&referral_id="+referral_id+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&params=\""+params+"\"&enc_id='+enc_id+'&invoke_recall='+invoke_recall+''}else{top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+patientID;top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID='+patientID+'&oper_stn_id="+oper_stn_id+"&patFlag='+patFlag+'&referral_id="+referral_id+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&params=\""+params+"\"'}}else{top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+patientID;top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID='+patientID+'&oper_stn_id="+oper_stn_id+"&patFlag='+patFlag+'&referral_id="+referral_id+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&params=\""+params+"\"'}}else{top.content.frames[1].frames[0].document.forms[0].referal_id.value='';top.content.frames[1].frames[0].document.forms[0].patient_id.disabled=false;top.content.frames[1].frames[0].document.forms[0].referal_id.disabled=false;top.content.frames[1].frames[0].document.forms[0].ref_id_search.disabled=false;top.content.frames[1].frames[0].document.forms[0].eReg.disabled=false;top.content.frames[1].frames[0].document.forms[0].patient_id.focus();top.content.frames[1].frames[0].document.forms[0].search.disabled=false;top.content.frames[1].frames[0].document.forms[0].patient_search.disabled=false;top.content.frames[1].frames[1].location.href='../../eCommon/html/blank.html';top.content.frames[1].frames[2].location.href='../../eCommon/html/blank.html';}} toSetPatID();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
							
							}
							else
							{ 
								patient_id = patientId;
							}
						  }
					  }
					  if(rs!=null)rs.close();
                      if(pstmt1!=null)pstmt1.close();
				  }
          catch(Exception e) {e.printStackTrace();}

	  }

      if(episodeValidation!=null && !episodeValidation.equals("YES")) {

		  webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
		  patdata.setFacility_id(facility_id);
		  String patientIdStatus = patdata.CheckStatus(con,patient_id);			   
		  prompt = patient_id;
         if(!patient_id.equals(""))
		 {	  
		   if(patientIdStatus.equals("BLACKLISTED_PATIENT")) {
			    out.println(beginHtml+"alert(get_message_text('BLACKLISTED_PATIENT','MP','"+prompt+"'))"+endHtml);
				alert_yn = 'N';
				if(invoke_from.equals("EMER_REGN_NB")){
            _bw.write(_wl_block6Bytes, _wl_block6);
}

			} else if (patientIdStatus.equals("SUSPENDED")) {
				//out.println("<script>var ret=window.confirm(get_message_text1('PAT_SUSPENDED_CONTINUE','AE')); if(!ret){setValue();}document.forms[0].suspended.value='Y';</script>");
				
            _bw.write(_wl_block7Bytes, _wl_block7);
if(invoke_from.equals("EMER_REGN_NB")){
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
} else if (patientIdStatus.equals("DECEASED")) {
				/*The Query serves to  Restrict Patient Registration to one time (Avoding Duplications) for same Patient(ID) Thursday, March 04, 2010 19744 */ 
				deceased_sql	=	"select count(*) from pr_encounter where patient_id = ? and ( brought_dead_yn = 'Y'or deceased_date_time is not null) and visit_status !='99' ";
				deceased_pstmt	=	con.prepareStatement(deceased_sql);
				deceased_pstmt.setString(1,patient_id);
				deceased_rslt	=	deceased_pstmt.executeQuery();	
				if (deceased_rslt.next())
				deceased_count	=	deceased_rslt.getString("count(*)");				
				if (deceased_count.equals("0")) {
					//out.println("<script>var ret=window.confirm(get_message_text1('PAT_DECEASED_CONTINUE','AE')); if(!ret){setValue();}document.forms[0].deceased.value='Y';</script>");
					
            _bw.write(_wl_block10Bytes, _wl_block10);
if(invoke_from.equals("EMER_REGN_NB")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
} else {
					out.println("<script>alert(get_message_text1('VISIT_ALRDY_REGISTERED','AE'))</script>");
					alert_yn = 'N'; 
					
					
            _bw.write(_wl_block13Bytes, _wl_block13);
if(invoke_from.equals("EMER_REGN_NB")){
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

				}
			     if (deceased_pstmt!=null) deceased_pstmt.close();
			     if (deceased_rslt!=null) deceased_rslt.close();   // end 19744		
			} else if (patientIdStatus.equals("INACTIVE")) {
					//out.println("<script>var ret=window.confirm(get_message_text1('PAT_INACTIVATED_CONTINUE','AE')); if(!ret){setValue();}document.forms[0].inactive.value='Y';</script>");
					
            _bw.write(_wl_block17Bytes, _wl_block17);
if(invoke_from.equals("EMER_REGN_NB")){
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
} else if ( patientIdStatus.equals("INVALID_PATIENT")) {
					/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] Start*/
					String chkPatDispArch=patdata.checkPatientDisposeArchive(con,patient_id);
					if(chkPatDispArch.equals("D")){
						
            _bw.write(_wl_block20Bytes, _wl_block20);

						alert_yn = 'N';
					}else if(chkPatDispArch.equals("I")){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);

						alert_yn = 'N';
					}else{
						/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] End*/
					out.println(beginHtml+"alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'))"+endHtml);
					alert_yn = 'N';
					}//Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857]
			} else if (patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0 ) {
					StringTokenizer token=new StringTokenizer(patientIdStatus,"$");
					String valid_patient_id = token.nextToken();		
					valid_patient_id = token.nextToken(); 				//patient_id =  valid_patient_id ;
					alert_yn = 'N';
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
					
			} else if (patientIdStatus != "") {			
				//warning_text+=patientIdStatus+ "<br>";
				warning_text=warning_text + patientIdStatus+ "<br>";
			}

			/*Added by Dharma on 25th Apr against MMS-DM-CRF-0152.1 [IN:070226] Start*/ 
			String errMsg					= "";
			//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022 - isNatIdAltIdMandVisaType
			if((isInvokeChngPatDtls || isNatIdAltIdMandVisaType ) && alert_yn != 'N'){

				JSONObject patDtlsObj	= new JSONObject();
				patDtlsObj						= eMP.MPCommonBean.chkNatIDAltIDAvail(con, patient_id,locale);
				String natId					= (String)patDtlsObj.get("national_id_no");
				String natIddft				    = (String)patDtlsObj.get("national_id_no_dft");//Maheshwaran added AAKH-CRF-0168 as on 19-11-2022
				String altId1					= (String)patDtlsObj.get("alt_id1_no");
				String altId2					= (String)patDtlsObj.get("alt_id2_no");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
				String pat_dtls_unknown_yn		= (String)patDtlsObj.get("pat_dtls_unknown_yn");
				String citizen_yn				= (String)patDtlsObj.get("citizen_yn");
				String altId1Desc				= (String)patDtlsObj.get("alt_id1_type_desc");
				String altId2Desc				= (String)patDtlsObj.get("alt_id2_type_desc");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
				String natIdPrompt				= (String)patDtlsObj.get("nat_id_prompt"); 
				String showAlert				= (String)patDtlsObj.get("showAlert"); 
				String visa_type				= (String)patDtlsObj.get("visa_type");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
				//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
				JSONObject MPParamJSONObj1 = new JSONObject();
				MPParamJSONObj1 = eMP.MPCommonBean.getMPAuditTrailDetails(con);
				String dft_national_id = (String)MPParamJSONObj1.get("dft_national_id");//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
				//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
				if(visa_type.equals(""))
				visa_type="W";
				if(pat_dtls_unknown_yn.equals("N")  && showAlert.equals("Y")){
					if(isInvokeChngPatDtls)
					{
						if(citizen_yn.equals("Y") && natId.equals("")){
							errMsg	= natIdPrompt;
						}else if(citizen_yn.equals("N") && altId1.equals("")  ){
							errMsg	= altId1Desc;
						}
					}
					//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
						if(isNatIdAltIdMandVisaType)
							{
							if((citizen_yn.equals("Y") && !dft_national_id.equals("")) || (citizen_yn.equals("N") &&  !dft_national_id.equals("") && (visa_type.equals("") || visa_type.equals("W"))))
								{
								//National ID null	
								if(natId.equals("")  )
									{						
									if(!altId1.equals("") && !altId2.equals("") && !dft_national_id.equals(natIddft))		
										{
										errMsg	= natIdPrompt;									
										}
									if(altId1.equals("") && !altId2.equals("") && !dft_national_id.equals(natIddft))		
										{
										errMsg	= natIdPrompt+"/"+altId1Desc;								
										}	
									if(!altId1.equals("") && (altId2.equals("") && !dft_national_id.equals(natIddft)))	
										{
										errMsg	= natIdPrompt+"/"+altId2Desc;									
										}	
								
									}
								//Alt ID1 null		
								if(altId1.equals(""))
									{						
									if(!natId.equals("") && !altId2.equals(""))	
										{
										errMsg	= altId1Desc;									
										}
									if(natId.equals("") && !altId2.equals(""))	
										{
										errMsg	= natIdPrompt+"/"+altId1Desc;								
										}	
									if(!natId.equals("") && (altId2.equals("") && dft_national_id.equals(natId)))	
										{
										errMsg	= altId1Desc+"/"+altId2Desc;									
										}	
									}
								//Alt ID2 null		
								if(altId2.equals("") )
									{						
									if(!natId.equals("") && !altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= altId2Desc;									
										}
									if(natId.equals("") && natIddft.equals("")  && !altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= natIdPrompt+"/"+altId2Desc;								
										}	
									if(natId.equals("") && !natIddft.equals("")  && !altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= altId2Desc;								
										}	
									if(natId.equals("") && !altId1.equals("") && !dft_national_id.equals(natIddft))	
										{
										errMsg	= natIdPrompt;								
										}	
									if(natId.equals("") && altId1.equals("") && !dft_national_id.equals(natIddft))	
										{
										errMsg	= natIdPrompt+"/"+altId1Desc;								
										}	
									if(!natId.equals("") && altId1.equals("") && dft_national_id.equals(natIddft))		
										{
										errMsg	= altId1Desc+"/"+altId2Desc;									
										}
									if(!natId.equals("") && altId1.equals("") && !dft_national_id.equals(natIddft))		
										{
										errMsg	= altId1Desc;									
										}
										//newly added
									if(natId.equals("")  && natIddft.equals("")   && altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= natIdPrompt+"/"+altId1Desc+"/"+altId2Desc;									
										}	
									if(natId.equals("")  && !natIddft.equals("")   && altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= altId1Desc+"/"+altId2Desc;									
										}		
									}
	
								}
							else if(citizen_yn.equals("N"))
								{
								if(visa_type.equals("V"))
									{
									if(altId1.equals("") && !altId2.equals(""))
										{
										errMsg	= altId1Desc;	
										}	
									if(!altId1.equals("") && altId2.equals(""))
										{
										errMsg	= altId2Desc;	
										}		
									if(altId1.equals("") && altId2.equals(""))
										{
										errMsg	= altId1Desc+"/"+altId2Desc;		
										}
																		
									}														
								} 	
							
							}
					if(!errMsg.equals("")){
					alert_yn = 'N';
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(errMsg));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block28Bytes, _wl_block28);

						
					}
				}
			}

		/*Added by Dharma on 25th Apr against MMS-DM-CRF-0152.1 [IN:070226] End*/ 
		
		/*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
		if(isCountryRegionValAppl && alert_yn != 'N'){

			JSONObject SMSiteJSONObj = new JSONObject();
			SMSiteJSONObj = eSM.SMCommonBean.getSMSiteParamDetails(con);
			String region_prompt = (String)SMSiteJSONObj.get("region_prompt");

			JSONObject MPParamJSONObj = new JSONObject();
			MPParamJSONObj = eMP.MPCommonBean.getMPAuditTrailDetails(con);
			String country_reqd_yn = (String)MPParamJSONObj.get("country_reqd_yn");
			String region_reqd_yn = (String)MPParamJSONObj.get("region_reqd_yn");

			JSONObject PatAddrJSONObj = new JSONObject();
			PatAddrJSONObj = eMP.MPCommonBean.getMPPatContactDetails(con,patient_id);
			String country_code = (String)PatAddrJSONObj.get("country_code");	
			String region_code = (String)PatAddrJSONObj.get("region_code");

			String dispMsg = "";

			if(country_code.equals("") || region_code.equals(""))
			{
				if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("N") && country_code.equals(""))
				{
					dispMsg = "Y";
            _bw.write(_wl_block29Bytes, _wl_block29);
}
				else if(country_reqd_yn.equals("N") && region_reqd_yn.equals("Y") && region_code.equals(""))
				{
					dispMsg = "Y";
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
				else if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("Y"))
				{
					if(country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
					else if(country_code.equals("") && !region_code.equals(""))
					{
						dispMsg = "Y";
            _bw.write(_wl_block34Bytes, _wl_block34);
}
					else if(!country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
				}else
				{
					dispMsg = "";
				}
			}

			if(!dispMsg.equals("")){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(invoke_from.equals("EMER_REGN_NB")){
            _bw.write(_wl_block39Bytes, _wl_block39);
}else{
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
if(invoke_from.equals("EMER_REGN_NB")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block43Bytes, _wl_block43);

				alert_yn = 'N';
			}
		}
		/*End AAKH-CRF-0128.1*/

		/*Added By Dharma on 15th May 2020 against KDAH-CRF-0522.1 Start*/
		String strMPParamMandFlds	= "";
		if(isChkMPParamMandFlds && alert_yn != 'N') {
				strMPParamMandFlds				= eMP.MPCommonBean.chkMPMandFieldsForEncCreation(con, patient_id, locale);
				if(!strMPParamMandFlds.equals("Y")){
					errMsg	= strMPParamMandFlds;
				}
				if(!errMsg.equals("")) {
				
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(errMsg));
            _bw.write(_wl_block45Bytes, _wl_block45);

					alert_yn = 'N';
				
            _bw.write(_wl_block46Bytes, _wl_block46);

				}else {
					alert_yn = 'Y';
				}
			}
		/*Added By Dharma on 15th May 2020 against KDAH-CRF-0522.1 End*/

		
			 String alternateIdStatus = "";
			 String in_pat_status = "";
	// Check for the INPATIENT
	
		  if(alert_yn != 'N') 
		  {
			 in_pat_status = patdata.CheckInPatient(con,patient_id,facility_id);
			
			/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
			if(isNationalIdValidationAppl)
			{
				JSONObject valJSONObj	= new JSONObject();
				valJSONObj				= eMP.MPCommonBean.getNationalIdValidationYN(con, patient_id, facility_id, "AE");
				String validate_yn		= (String)valJSONObj.get("validate_yn");
				String national_id		= (String)valJSONObj.get("national_id");
				String chk_citizen_yn	= (String)valJSONObj.get("citizen_yn");

				if(validate_yn.equals("Y") && national_id.equals("") && chk_citizen_yn.equals("Y"))
				{
				
            _bw.write(_wl_block47Bytes, _wl_block47);

					alert_yn = 'N';
				
            _bw.write(_wl_block46Bytes, _wl_block46);

				}else
				{
					alert_yn = 'Y';
				}

				if(alert_yn == 'N')
				{
					alternateIdStatus = "";
					in_pat_status="";
				}
			}
			/*End MO-CRF-20148*/

			


	//if(isUHID_valid_appl  )		 
	 if(isUHID_valid_appl && bl_install_yn.equals("Y") )
	
		{
							String UHIDValidCount = "0";
							String UHIDValidCount_tmp = "";
							String pat_ser_grp_code = "";
					try{
							
							
						 UHIDValidCount_tmp	= eMP.MPCommonBean.getUHIDValidCount(con,patient_id,facility_id);
						String arr_temp[] = UHIDValidCount_tmp.split("~~");
						UHIDValidCount = arr_temp[0];
						if(arr_temp.length>1)
							pat_ser_grp_code = arr_temp[1];
						
						
						if(UHIDValidCount.equals("0"))
						{
							
							
					
					
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(pat_ser_grp_code));
            _bw.write(_wl_block50Bytes, _wl_block50);

										alert_yn = 'N';
										
            _bw.write(_wl_block51Bytes, _wl_block51);

										alert_yn = 'N';
										
            _bw.write(_wl_block52Bytes, _wl_block52);


					
						
						}
						else
						{
							 
							
							 
						}
						
							}
							catch(Exception e1) {
										e1.printStackTrace();
								 } 
				if(alert_yn == 'N'){
					alternateIdStatus = "";
					in_pat_status="";
				}
				
			
				
			
		}
			 
			 
		  }		  		  
			
		   if(in_pat_status.equals("CURRENTLY_IN_PATIENT")) {
               if(reg_attendance_for_inpat_yn.equals("Y")) {				out.println(beginHtml+"if(alternate_id_cont_yn==\"Y\")alert(get_message_text('CURRENTLY_IN_PATIENT','Common','"+prompt+"'))"+endHtml);
			    alert_yn = 'Y';
				} else {					out.println(beginHtml+"if(alternate_id_cont_yn==\"Y\")alert(get_message_text('REG_ATTEN_NOT_ALLOWED_FOR_CURR_INPAT','AE','"+prompt+"'))"+endHtml);
					alert_yn = 'N';
					
            _bw.write(_wl_block53Bytes, _wl_block53);

				}
			}
		  // Check for the Alternate Id
		  if (alert_yn != 'N') 
		  {
			  alternateIdStatus = patdata.CheckAlternateId(con,patient_id,locale);
		  }
		 
	//added  for billing interface on 8/26/2003	  
	//Added New 08/03/2006
     HcExpired = "N";
	  if(!alternateIdStatus.equals(""))
	  {
		char val=alternateIdStatus.charAt(0);
		
		if(val == 'W')
		{
			String val1=alternateIdStatus.substring(2,alternateIdStatus.length());
			out.println("<html><script>var contyn = confirm(\""+val1+"\");  if(!contyn) setValue();</script></html>");
		}else if(val =='C')
		{			
			String val1=alternateIdStatus.substring(1,alternateIdStatus.length());
			out.println("<html><script>alert(\""+val1+"\");setValue();</script></html>");
		}else 
		{
			String val1=alternateIdStatus.substring(2,alternateIdStatus.length());
			out.println("<html><script>alert(\""+val1+"\");</script></html>");
		}
	  }

 // Start (venkat s) for PE_EXE ae regn attn function (merged two quries)
			try
			{	 

				StringBuffer sqlClinc = new StringBuffer();
				sqlClinc.append(" Select OP_GET_DESC.OP_CLINIC(FACILITY_ID,ASSIGN_CARE_LOCN_CODE,'"+locale+"','1') CLINIC_NAME,");
				// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
				sqlClinc.append("  AM_GET_DESC.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME,TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI')VISIT_ADM_DATE_TIME,");
				//end CRF  Bru-HIMS-CRF-152 [IN030272]

				sqlClinc.append(" (SYSDATE - (VISIT_ADM_DATE_TIME)) * 24 prev_visit_hrs,");
				sqlClinc.append(" visit_status,");
				sqlClinc.append(" patient_class,");
				sqlClinc.append(" case when TRUNC (visit_adm_date_time) = TRUNC (SYSDATE) then 1 else 0 end is_current_date");
				sqlClinc.append(" from PR_ENCOUNTER where FACILITY_ID = ? AND PATIENT_ID = ?");
				sqlClinc.append("  ORDER BY prev_visit_hrs desc");

				// sqlClinc.append("Select OP_GET_DESC.OP_CLINIC(FACILITY_ID,ASSIGN_CARE_LOCN_CODE,'"+locale+"','1') CLINIC_NAME, AM_GET_DESC.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME from PR_ENCOUNTER where FACILITY_ID = ? AND PATIENT_ID = ? and trunc(visit_adm_date_time)=trunc(sysdate) and patient_class in ('OP','EM') ");

				
				

				  pstmt  = con.prepareStatement(sqlClinc.toString());
				  pstmt.setString(1, facility_id);
				  pstmt.setString(2, patient_id);

				  rset = pstmt.executeQuery();     
                  if(rset!=null)
                  {
                    while(rset.next())
                    {           
					practName		= rset.getString("PRACTITIONER_NAME");
					if(practName == null) practName = "";
					clinicName	= rset.getString("CLINIC_NAME");
					if(clinicName == null) clinicName = "";
					prev_visit_hrs = rset.getDouble("prev_visit_hrs");
					visit_status = rset.getString("visit_status");
					patient_class = rset.getString("patient_class");
					visit_adm_date_time = rset.getString("is_current_date");
					// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
					lastvist=rset.getString("visit_adm_date_time");
			//end CRF  Bru-HIMS-CRF-152 [IN030272]
				
					

				  }
				  
				 
                  } // End of if
				  
				  
				if (rset != null)   rset .close();
				if (pstmt != null) pstmt.close();
				if((sqlClinc != null) && (sqlClinc.length() > 0))
				 {
					sqlClinc.delete(0,sqlClinc.length());
				 }
           }
           catch(Exception e) {e.printStackTrace();}
 // End (venkat s) for PE_EXE ae regn attn function (merged two quries)





	//Ends Here 08/03/2006
	// To Inform the User, that this patient has already visited the Clinic
	
	 // below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
				   Double my_value = new  Double(prev_visit_hrs);
				   
			     //end CRF  Bru-HIMS-CRF-152 [IN030272]
	if(!(alert_yn=='N'))
	 {
	 out.println("<script>  var mess	= ''; </script>");
	
	if( ( max_hrs_for_re_attend1 > my_value) && (patient_class.equals("EM") || patient_class.equals("OP")) &&  (!(clinicName.equals("")))) // Start (venkat s) for PE_EXE ae regn attn function
		 {
	  //AE_ALREADY_VISIT_LOCN
		 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(practName));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(clinicName));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(lastvist));
            _bw.write(_wl_block57Bytes, _wl_block57);
 
		/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		/*out.println("<script> top.content.frames[1].frames[0].document.forms[0].prev_visit_hrs.value='"+prev_visit_hrs+"' </script>");
        out.println("<script> top.content.frames[1].frames[0].document.forms[0].visit_status.value='"+visit_status+"' </script>");*/
		out.println("<script> "+frameRef+".frames[1].frames[0].document.forms[0].prev_visit_hrs.value='"+prev_visit_hrs+"' </script>");
        out.println("<script> "+frameRef+".frames[1].frames[0].document.forms[0].visit_status.value='"+visit_status+"' </script>");
/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/

		}
		} // End of if
		/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		/*out.println("<script> top.content.frames[1].frames[0].document.forms[0].prev_visit_hrs.value='"+prev_visit_hrs+"' </script>");
        out.println("<script> top.content.frames[1].frames[0].document.forms[0].visit_status.value='"+visit_status+"' </script>");*/
		out.println("<script> "+frameRef+".frames[1].frames[0].document.forms[0].prev_visit_hrs.value='"+prev_visit_hrs+"' </script>");
        out.println("<script> "+frameRef+".frames[1].frames[0].document.forms[0].visit_status.value='"+visit_status+"' </script>");
		/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
		// end (venkat s) for PE_EXE ae_regn_attn function
		out.println(beginHtml);

	if(!(alert_yn=='N'))
	{
			String nat_id_no  = "";
			//out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.value='"+patient_id+"'");
			out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.value='"+patient_id+"'");/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148]*/
			out.println("ChangePatVisHid("+frameRef+");"); // added by munisekhar for MMS-QH-CRF-0162
			pstmt  = con.prepareStatement("select national_id_no from mp_patient where patient_id = '"+patient_id+"'");
			rset = pstmt.executeQuery();     
			if(rset!=null && rset.next()) {
				nat_id_no = rset.getString("national_id_no") == null?"":rset.getString("national_id_no");
			}
			if(!nat_id_no.equals("")) {
				//out.println("if(top.content.frames[1].frames[0].document.forms[0].National_Id_No){top.content.frames[1].frames[0].document.forms[0].National_Id_No.value='"+nat_id_no+"'}");
				out.println("if("+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No){"+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No.value='"+nat_id_no+"'}");/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148]*/
				//out.println("top.content.frames[1].frames[0].document.forms[0].National_Id_No.value='"+nat_id_no+"'");
			}
			if (rset != null)   rset .close();
			if (pstmt != null) pstmt.close();
		//added for billing on 8/26/2003
			if(bl_install_yn.equals("Y")) {
					/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
					/*out.println("if(alternate_id_cont_yn == \"N\"){		top.content.frames[1].location.href='../../eAE/jsp/AERegisterAttnFrameset.jsp?params="+params+"';}else{  top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&"+params+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&referral_id="+referral_id+"';}");*/
					/*Modified by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
					out.println("if(alternate_id_cont_yn == \"N\"){		"+frameRef+".frames[1].location.href='../../eAE/jsp/AERegisterAttnFrameset.jsp?params="+params+"';}else{var invoke_recall = '"+invokeRecallForAE+"'; if(invoke_recall == \"Y\") {var cnt_yn=followUpCount('"+patient_id+"'); if(cnt_yn == \"Y\") { var enc_id=showFollowUpEncounters('"+patient_id+"');"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&"+params+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"&enc_id='+enc_id+'&invoke_recall='+invoke_recall+'';}else{"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&"+params+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"';}}else{"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&"+params+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"';}}");
					/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
			} else {
					/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
					/*out.println("if(alternate_id_cont_yn == \"N\"){  top.content.frames[1].location.href='../../eAE/jsp/AERegisterAttnFrameset.jsp?params="+params+"';}else{var deceased =document.forms[0].deceased.value; top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&referral_id="+referral_id+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&"+params+"&deceased='+deceased+' ';}");*/
					/*Modified by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
					out.println("if(alternate_id_cont_yn == \"N\"){  "+frameRef+".frames[1].location.href='../../eAE/jsp/AERegisterAttnFrameset.jsp?params="+params+"';}else{var deceased =document.forms[0].deceased.value; var invoke_recall = '"+invokeRecallForAE+"'; if(invoke_recall == \"Y\") {var cnt_yn=followUpCount('"+patient_id+"'); if(cnt_yn == \"Y\") {var enc_id=showFollowUpEncounters('"+patient_id+"');"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&"+params+"&deceased='+deceased+' &enc_id='+enc_id+'&invoke_recall='+invoke_recall+' ';}else{"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&"+params+"&deceased='+deceased+' ';}}else{"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&"+params+"&deceased='+deceased+' ';}}");
					/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
			}	
    } else {
				/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
				 /*out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.disabled=false;");	
				 out.println("top.content.frames[1].frames[0].document.forms[0].referal_id.value='';"); 
				 out.println("top.content.frames[1].frames[0].document.forms[0].referal_id.disabled=false;"); out.println("top.content.frames[1].frames[0].document.forms[0].ref_id_search.disabled=false;");
				 out.println("if(top.content.frames[1].frames[0].document.forms[0].National_Id_No) 			  {top.content.frames[1].frames[0].document.forms[0].National_Id_No.value='';				 top.content.frames[1].frames[0].document.forms[0].National_Id_No.disabled=false;}"); 				 out.println("if(top.content.frames[1].frames[0].document.forms[0].National_Id_Button){top.content.frames[1].frames[0].document.forms[0].National_Id_Button.disabled=false;}");
				 out.println("top.content.frames[1].frames[0].document.forms[0].eReg.disabled=false;");	
				 out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.focus();"); 
				 out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.select();"); 
				 out.println("top.content.frames[1].frames[0].document.forms[0].search.disabled=false;");	
				 out.println("top.content.frames[1].frames[0].document.forms[0].patient_search.disabled=false;");	
				 out.println("top.content.frames[1].frames[1].location.href='../../eCommon/html/blank.html'");
				 out.println("top.content.frames[1].frames[2].location.href='../../eCommon/html/blank.html'");*/
				//out.println("async function forShowModalCall () {");
				//out.println("var ret =  await shoModalCall();	");
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.disabled=false;");	
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].referal_id.value='';"); 
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].referal_id.disabled=false;"); out.println(""+frameRef+".frames[1].frames[0].document.forms[0].ref_id_search.disabled=false;");
				out.println("if("+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No) 			  {"+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No.value='';				 "+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No.disabled=false;}"); 				 out.println("if("+frameRef+".frames[1].frames[0].document.forms[0].National_Id_Button){"+frameRef+".frames[1].frames[0].document.forms[0].National_Id_Button.disabled=false;}");
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].eReg.disabled=false;");
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.value='';"); 
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.focus();"); 
				
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.select();"); 
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].search.disabled=false;");	
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_search.disabled=false;");	
				out.println(""+frameRef+".frames[1].frames[1].location.href='../../eCommon/html/blank.html'");
				out.println(""+frameRef+".frames[1].frames[2].location.href='../../eCommon/html/blank.html'");
				 //out.println("forShowModalCall("+frameRef+");
				/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
	   	  }
  	
			//out.println("top.content.frames[2].location.href='../../eAE/jsp/AERegAttnMsgBlank.jsp';");	   
			out.println(""+frameRef+".frames[2].location.href='../../eAE/jsp/AERegAttnMsgBlank.jsp';");	 /*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148]*/  
		out.println(endHtml);
	  }
   }

            _bw.write(_wl_block58Bytes, _wl_block58);

	    }
		 catch(Exception e)
		{
			e.printStackTrace();
		 }
	    }
		 catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			 ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block59Bytes, _wl_block59);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
