package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.net.URLEncoder.*;
import com.ehis.util.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __serversidevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ServerSideValidation.jsp", 1732696876910L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n       <script>\n\t   i=1;\n       obj1=parent.frames[1].document.forms[0].clinic;\n\t   obj1.remove(obj1.options[0]);\n       opt=parent.frames[1].document.createElement(\'OPTION\');\n\t   opt2=parent.frames[1].document.forms[0].default_select.value;\n       opt.value=\'\';\n\t   opt.text=\"------------------------\"+opt2+\"------------------------\";\n\t   obj1.add(opt);\n\n       len= parent.frames[1].document.forms[0].clinic.options.length;\n\t   while(i<len){\n\t\t   obj1.remove(obj1.options[i]);\n\t\t   i+=1;\n\t   }\n\t\t</script>\n\t  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\topt=parent.frames[1].document.createElement(\'OPTION\');\n\t\t\topt.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="|";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\n\t\t\topt.text=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n\t\t\tparent.frames[1].document.forms[0].clinic.add(opt);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\n\t\t<script>\n\t\tparent.frames[3].location.href=\'../../eCommon/jsp/error.jsp\'\n\t\t</SCRIPT>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script>\n\n\t\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[1].document.forms[0].eff_from.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\tparent.frames[1].document.forms[0].eff_from_date.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\tparent.frames[1].document.forms[0].eff_to.value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\tparent.frames[1].document.forms[0].eff_to_date.value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n                    /*Below Line condtion Added for this CRF [AMRI-CRF-0236]*/\n\t\t\t\t //  if(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'==\"GenerateSchedule_ref\" && parent.frames[1].document.forms[0].chkvalue){\n\t\t\t\t  //     parent.frames[1].document.forms[0].chkvalue.value=\"timetableexist\";\t\t\t\t\n\t\t\t\t  // }\n\t\t\t\t   //if(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'!=\"GenerateSchedule_ref\"){\n\t\t\t\t\t    parent.frames[1].document.forms[0].all_practitioners.value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\t  // }\n\t\t\t\t     /*Above Line condtion Added for this CRF [AMRI-CRF-0236]*/\n\n\t\t\t\t\tparent.frames[1].document.forms[0].no_days.value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\tparent.frames[1].document.forms[0].generate.disabled=false;\n\n\t\t\t\t\tparent.frames[1].document.forms[0].dutyRosterCount.value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\n\t\t\t\t\tparent.frames[1].document.getElementById(\"info\").innerHTML=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\t\tparent.frames[3].location.href=\'../../eCommon/jsp/error.jsp\'\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<script>\n\t\t\t\t/*Below Line condtion Added for this CRF [AMRI-CRF-0236]*/\n\t\t\t//\tif(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'==\"GenerateSchedule_ref\" && parent.frames[1].document.forms[0].chkvalue){\n\t\t\t//\tparent.frames[1].document.forms[0].chkvalue.value=\"timetablenotexist\";\t\t\t\t\n\t\t\t//\t}\n\t\t\t\t//End this CRF [AMRI-CRF-0236]\n\t\t\t\t\n\t\t\t    alert(parent.frames[1].getMessage(\"TIME_TABLE_DOES_NOT_EXIST\",\"OA\"));\t\t\t\t\n\t\t\t\t\n\t\t\t\tparent.frames[1].document.forms[0].eff_to.value=\'\';\n\t\t\t\tparent.frames[1].document.forms[0].eff_from.value=\'\';\n\t\t\t\t/*Below Line condtion Added for this CRF [AMRI-CRF-0236]*/\t\t\t\t\n\t\t\t\t//if(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'!=\"GenerateSchedule_ref\"){\n\t\t\t\tparent.frames[1].document.forms[0].all_practitioners.checked=false;\n\t\t\t\tparent.frames[1].document.forms[0].all_practitioners.disabled=true;\n\t\t\t\t//}\n\t\t\t\t// End [AMRI-CRF-0236]\n\t\t\t\tparent.frames[1].document.forms[0].generate.disabled=true;\n\t\t\t\tparent.frames[3].location.href=\'../../eCommon/jsp/error.jsp\'\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n\t   <script>\n\t\tobj=parent.frames[1].document.frames[0].document.forms[0].blocation;\n\t\tvar len=obj.options.length;\n\t\ti=0;\n\t\tfor(;i<len;i++) obj.remove(obj.options[i]) ;\n\t\topt=parent.frames[1].document.frames[0].document.createElement(\'OPTION\');\n\t\topt.value=\'\';\n\t\topt.text=\'-----------------------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'-----------------------\';\n\t\tobj.add(opt);\n\t   </script>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<script>\n\t\t\tobj=parent.frames[1].document.frames[0].document.forms[0].blocation;\n\t\t\topt=parent.frames[1].document.frames[0].document.createElement(\'OPTION\');\n\t\t\topt.value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="$";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\topt.text=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\tobj.add(opt);\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t   <script>\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp\'\n\t  </SCRIPT>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n\t   <script>\n        \n       obj1=parent.frames[1].document.forms[0].blocation;\n\t   while(obj1.options.length > 0) \n\t\t   obj1.remove(obj1.options[0]);\n\n       opt=parent.frames[1].document.createElement(\'OPTION\');\n       opt.value=\'\';\n\t   opt.text=\'-----------------------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'-----------------------\';\n\t   obj1.add(opt);\n\n       \n\t\t</script>  \n\t\t\t\t\t  \n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<script>\n\t\t\tobj=parent.frames[1].document.forms[0].blocation;\n\t\t\topt=parent.frames[1].document.createElement(\'OPTION\');\n\t\t\topt.value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" \n\n\t\t<script>\n\t\tparent.frames[3].location.href=\'../../eCommon/jsp/error.jsp\'\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<script>\n\t\t\t\n\t\t\tvar error1=getMessage(\"RECORD_MODIFIED\",\"SM\");\n\t\t\talert(error1);\n\t\t\t//parent.window.close();\n\t\t\tparent.parent.document.querySelectorAll(\'#dialog_tag\')[parent.parent.document.querySelectorAll(\'#dialog_tag\').length-1].close();\n\t\t\tparent.parent.parent.frames[2].frames[3].location.reload();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<script>\n\t\t\t\n\t\t\tvar error5=getMessage(\"NO_CHANGE_TO_SAVE\",\"Common\");\n\t\t\t\n\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_num=\"+error5;\n\t\t\tparent.frames[2].location.reload();\n\t\t\t</script>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<script>\n\t\t\t\n\t\t\tvar error2=getMessage(\"RECORD_MODIFIED\",\"SM\");\n\t\t\talert(error2);\n\t\t\t//window.close();\n\t\t\tparent.parent.document.querySelectorAll(\'#dialog_tag\')[parent.parent.document.querySelectorAll(\'#dialog_tag\').length-1].close();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<script>\n\t\t\t\n\t\t\tvar error4=getMessage(\"NO_CHANGE_TO_SAVE\",\"Common\");\n\t\t\talert(error4);\n\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<script>\n\t\tif (parent.frames[0].document.getElementById(\"resourceType1\")){\n\t\t\tparent.frames[0].document.getElementById(\"resourceType1\").value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\tparent.frames[0].document.getElementById(\"pract_type1\").innerHTML=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t}else{\n\t\t    parent.frames[1].document.forms[0].resourceType1.value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\tparent.frames[1].document.getElementById(\"pract_type1\").innerHTML=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\tparent.frames[3].location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<script>\n\t\t\tvar error=getMessage(\"RECORD_MODIFIED\",\"SM\");\n\t\t\tvar err_value=\"\";\n\t\t\t</script>\n\t\t\t<html>\n\t\t\t<script>parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_num=\"+error;</script>\n\t\t\t<body class=\'message\' onKeyDown = \'lockKey()\'></html>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<html>\n\t\t\t<script>\n\t\t\tvar error3=getMessage(\"NO_CHANGE_TO_SAVE\",\"Common\");\n\t\t\tvar err_value3=\"\";\n\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_num=\"+error3;\n\t\t\t</script>\n\t\t\t<body class=\'message\' onKeyDown = \'lockKey()\'></html>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<script>\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num= \";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\"INVALID_PATIENT\",\"MP\"));\n\t\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num= \";\n\t\t\t\tparent.frames[1].document.forms[0].patientid.value=\"\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"PAT_DECEASED_NOT_ALLOWED\",\"MP\"));\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'==\'\' || \'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'==\'Pending_referral\'){\n\t\t\t\t\t\t\tvar frameName=\"\";\n\t\t\t\t\t\t\tif(parent.f_query_add_mod && parent.f_query_add_mod.querying){\n\t\t\t\t\t\t\t\tframeName = \"parent.f_query_add_mod.querying\";\n\t\t\t\t\t\t\t}else if(parent.querying){\n\t\t\t\t\t\t\t\tframeName = \"parent.querying\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.patient_id){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.patient_id.focus();\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.patient_id.select();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_prefix){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.first_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.second_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.third_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.family_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_suffix){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_prefix_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.first_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.second_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.third_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.family_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_suffix_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.contact_no){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.contact_no.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.contact_no.disabled=false;\n\t\t\t\t\t\t\t\t//if(eval(frameName).document.schedule_appointment.contact_no_gif)\n\t\t\t\t\t\t\t\t\t//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility=\'visible\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.gender){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.gender.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.gender.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.nationality_desc){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.disabled=false;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_button.disabled=false;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_code.value=\'\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.language_desc){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_desc.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_desc.disabled=false;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_button.disabled=false;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_code.value=\'\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"PAT_SUSPENDED_NOT_ALLOWED\",\"MP\"));\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'==\'Pending_referral\'){\n\t\t\t\t\t\t\tvar frameName=\"\";\n\t\t\t\t\t\t\tif(parent.f_query_add_mod && parent.f_query_add_mod.querying){\n\t\t\t\t\t\t\t\tframeName = \"parent.f_query_add_mod.querying\";\n\t\t\t\t\t\t\t}else if(parent.querying){\n\t\t\t\t\t\t\t\tframeName = \"parent.querying\";\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.patient_id){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.patient_id.focus();\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.patient_id.select();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_prefix){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.first_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.second_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.third_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.family_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name.disabled=false;\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_suffix){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_prefix_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.first_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.second_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.third_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.family_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_suffix_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix_oth_lang.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix_oth_lang.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.contact_no){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.contact_no.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.contact_no.disabled=false;\n\t\t\t\t\t\t\t\t//if(eval(frameName).document.schedule_appointment.contact_no_gif)\n\t\t\t\t\t\t\t\t\t//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility=\'visible\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.gender){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.gender.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.gender.disabled=false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.nationality_desc){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.disabled=false;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_button.disabled=false;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_code.value=\'\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.language_desc){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_desc.value=\'\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_desc.disabled=false;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_button.disabled=false;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_code.value=\'\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'==\'Pending_referral\'){\n\t\t\t\t\t\t\tvar frameName=\"\";\n\t\t\t\t\t\t\tif(parent.f_query_add_mod && parent.f_query_add_mod.querying){\n\t\t\t\t\t\t\t\tframeName = \"parent.f_query_add_mod.querying\";\n\t\t\t\t\t\t\t}else if(parent.querying){\n\t\t\t\t\t\t\t\tframeName = \"parent.querying\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_prefix){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix.disabled=true;\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.first_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name.value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.second_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name.value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.third_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name.value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.family_name){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name.value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_suffix){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_prefix_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix_oth_lang.value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix_oth_lang.disabled=true;\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.first_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name_oth_lang.value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name_oth_lang.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.second_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name_oth_lang.value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name_oth_lang.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.third_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name_oth_lang.value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name_oth_lang.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.family_name_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name_oth_lang.value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name_oth_lang.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_suffix_oth_lang){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix_oth_lang.value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix_oth_lang.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.contact_no){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.contact_no.value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.contact_no.disabled=true;\n\t\t\t\t\t\t\t\t//if(eval(frameName).document.schedule_appointment.contact_no_gif)\n\t\t\t\t\t\t\t\t\t//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility=\'hidden\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.gender){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.gender.value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.gender.disabled=true;\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.nationality_desc){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.disabled=true;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_button.disabled=true;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_code.value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\tif(eval(frameName).document.schedule_appointment.language_desc){\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_desc.value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\';\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_desc.disabled=true;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_button.disabled=true;\n\t\t\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_code.value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t<script>parent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num= \";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t<script>\t\t\t\t\n\t\t\t\talert(getMessage(\"INVALID_PATIENT\",\"MP\"));\t\t\t\n\t\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num= \";\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'==\'\'  || \'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'==\'Pending_referral\'){\n\t\t\t\t\t\t\tvar frameName=\"\";\n\t\t\t\t\t\t\tif(parent.f_query_add_mod && parent.f_query_add_mod.querying){\n\t\t\t\t\t\t\t\tframeName = \"parent.f_query_add_mod.querying\";\n\t\t\t\t\t\t\t}else if(parent.querying){\n\t\t\t\t\t\t\t\tframeName = \"parent.querying\";\n\t\t\t\t\t\t\t}\t\t\t\t\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.patient_id){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.patient_id.focus();\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.patient_id.select();\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_prefix){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.first_name){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.second_name){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.third_name){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.family_name){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_suffix){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_prefix_oth_lang){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix_oth_lang.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_prefix_oth_lang.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.first_name_oth_lang){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name_oth_lang.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.first_name_oth_lang.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.second_name_oth_lang){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name_oth_lang.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.second_name_oth_lang.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.third_name_oth_lang){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name_oth_lang.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.third_name_oth_lang.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.family_name_oth_lang){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name_oth_lang.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.family_name_oth_lang.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.name_suffix_oth_lang){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix_oth_lang.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.name_suffix_oth_lang.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.contact_no){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.contact_no.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.contact_no.disabled=false;\n\t\t\t\t\t\t//if(eval(frameName).document.schedule_appointment.contact_no_gif)\n\t\t\t\t\t\t\t//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility=\'visible\';\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.gender){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.gender.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.gender.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.nationality_desc){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.disabled=false;\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_button.disabled=false;\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.nationality_code.value=\'\';\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(frameName).document.schedule_appointment.language_desc){\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_desc.value=\'\';\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_desc.disabled=false;\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_button.disabled=false;\n\t\t\t\t\t\teval(frameName).document.schedule_appointment.language_code.value=\'\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t<script>\n\t\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num= \";\n\t\t\t\tvar frameName=\"\";\n\t\t\t\tif(parent.result){\n\t\t\t\t\tframeName = \"parent.result\";\n\t\t\t\t}else if(parent.f_query_add_mod && parent.f_query_add_mod.result){\n\t\t\t\t\tframeName = \"parent.f_query_add_mod.result\";\n\t\t\t\t}else if((parent.frames[3])&&(parent.frames[3].result)){\n\t\t\t\t\tframeName = \"parent.frames[3].result\";\n\t\t\t\t}\n\t\t\t\teval(frameName).rule_sch_appt_form.book_appt_yn.value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\';\n\t\t\t\teval(frameName).rule_sch_appt_form.book_appt_wo_pid_yn.value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\';\n\t\t\t\teval(frameName).rule_sch_appt_form.book_appt_across_catg_yn.value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\';\n\t\t\t\teval(frameName).rule_sch_appt_form.tfr_appt_yn.value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\';\n\t\t\t\teval(frameName).rule_sch_appt_form.tfr_appt_across_catg_yn.value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\';\n\t\t\t\teval(frameName).rule_sch_appt_form.canc_appt_yn.value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\';\n\t\t\t\teval(frameName).rule_sch_appt_form.obook_appt_yn.value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\';\n\t\t\t\teval(frameName).rule_sch_appt_form.global_locn_yn.value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\';\n\t\t\t\teval(frameName).rule_sch_appt_form.global_book_appt_yn.value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\';\n\t\t\t\teval(frameName).BookAppointmentModalWindow(\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\',\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\');\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t<script>\n\t\t\tvar frameName=\"\";\n\t\t\tif(parent.f_query_add_mod && parent.f_query_add_mod.querying){\n\t\t\t\tframeName = \"parent.f_query_add_mod.querying\";\n\t\t\t}else if(parent.querying){\n\t\t\t\tframeName = \"parent.querying\";\n\t\t\t}\t\t\t\t\t\t\n\t\t\tif(eval(frameName).document.schedule_appointment.first_name){\n\t\t\t\teval(frameName).document.schedule_appointment.first_name.value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\';\n\t\t\t\teval(frameName).document.schedule_appointment.first_name.disabled=true;\n\t\t\t}\n\t\t\tif(eval(frameName).document.schedule_appointment.second_name){\n\t\t\t\teval(frameName).document.schedule_appointment.second_name.value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\';\n\t\t\t\teval(frameName).document.schedule_appointment.second_name.disabled=true;\n\t\t\t}\n\t\t\tif(eval(frameName).document.schedule_appointment.third_name){\n\t\t\t\teval(frameName).document.schedule_appointment.third_name.value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\';\n\t\t\t\teval(frameName).document.schedule_appointment.third_name.disabled=true;\n\t\t\t}\n\t\t\tif(eval(frameName).document.schedule_appointment.family_name){\n\t\t\t\teval(frameName).document.schedule_appointment.family_name.value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\';\n\t\t\t\teval(frameName).document.schedule_appointment.family_name.disabled=true;\n\t\t\t}\n\t\t\tif(eval(frameName).document.schedule_appointment.contact_no){\n\t\t\t\teval(frameName).document.schedule_appointment.contact_no.value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\';\n\t\t\t\teval(frameName).document.schedule_appointment.contact_no.disabled=true;\n\t\t\t\t//if(eval(frameName).document.schedule_appointment.contact_no_gif)\n\t\t\t\t\t//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility=\'hidden\';\n\t\t\t}\n\t\t\tif(eval(frameName).document.schedule_appointment.gender){\n\t\t\t\teval(frameName).document.schedule_appointment.gender.value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\';\n\t\t\t\teval(frameName).document.schedule_appointment.gender.disabled=true;\n\t\t\t}\n\n\t\t\tif(eval(frameName).document.schedule_appointment.nationality_desc){\n\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\';\n\t\t\t\teval(frameName).document.schedule_appointment.nationality_desc.disabled=true;\n\t\t\t\teval(frameName).document.schedule_appointment.nationality_button.disabled=true;\n\t\t\t\teval(frameName).document.schedule_appointment.nationality_code.value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'\n\t\t\t}\n\n\t\t\tif(eval(frameName).document.schedule_appointment.language_desc){\n\t\t\t\teval(frameName).document.schedule_appointment.language_desc.value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\';\n\t\t\t\teval(frameName).document.schedule_appointment.language_desc.disabled=true;\n\t\t\t\teval(frameName).document.schedule_appointment.language_button.disabled=true;\n\t\t\t\teval(frameName).document.schedule_appointment.language_code.value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\';\n\t\t\t}\n\t\t</script>\n\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'MR_INVALID_PROC_CODE\',\'MR\'))\n\t\t\t\t\tparent.frames[1].document.forms[0].proc_desc.value=\"\";\n\t\t\t\t\tparent.frames[1].document.forms[0].proc_code.value=\"\";\n\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t<!--\n\t\t\t\tparent.frames[1].document.forms[0].proc_desc.value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t//-->\n\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\t\t\n\n\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
public static String isSiteSpecificforBiometric(Connection con)
	 {
	 	String function_name="";
	 	PreparedStatement pstmt		= null;
	 	ResultSet rs 				= null;
	 	try
	 	{
	 	String siteSpecificSQL="select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID";
	 	pstmt= con.prepareStatement(siteSpecificSQL);
	     rs= pstmt.executeQuery();
	     if(rs!=null && rs.next())
	 	{
	 	function_name=rs.getString("VALUE_2");
	 	}	
	 	}catch(Exception esql)
	 	{
	 		esql.printStackTrace();
	 	}finally
	 	{
	 		try{
	 	 if(pstmt != null)pstmt.close();
	 	 if(rs != null)rs.close();
	 		}catch(Exception fe){
	 		}
	 	}
	 	return function_name;
}
 public static String insertReasonforBiometric(Connection con,String facility_id,String fun_id,String patient_id,String ref_no,String location_code,String reason,String addedworkstation,String user_id) 
	 {
	 	CallableStatement cstmt = null;
	 	String status="E";
	 	try{
	 			StringBuffer sqloa = new StringBuffer() ;
	 			sqloa.append("{call mp_biometric_auth_prc(?,?,?,?,?,?,?,?,?)}");
	 				cstmt = con.prepareCall(sqloa.toString());
	 				cstmt.setString(1, facility_id);
	 				cstmt.setString(2, fun_id);
	 				cstmt.setString(3, patient_id);
	 				cstmt.setString(4, ref_no);
	 				cstmt.setString(5, location_code);
	 				cstmt.setString(6, reason);
	 				cstmt.setString(7, addedworkstation);
	 				cstmt.setString(8, user_id);
	 				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR	);
	 				cstmt.execute();
	 				status = cstmt.getString(9);
	 	}catch(Exception e)
	 	{
	 		status="E";
	 		e.printStackTrace();
	 	}finally
	 	{
	 		try{if(cstmt != null)cstmt.close();}
	 		catch(Exception fe){}
	 	}
	 	return status;
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
 
Connection con = null;
ResultSet rs=null;
Statement stmt =null; 

ResultSet rssql1=null;
Statement stsql2 = null;	
java.util.Properties p;
PreparedStatement pstmt		= null;
// added by N Munisekhar on 04-May-2012 against [IN:039768]
String apptrefno="";
try{
	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	con = ConnectionManager.getConnection(request);
	 stmt = con.createStatement();

	 stsql2 = con.createStatement();	

	String oper_stn_id="";
	String locale			= (String)session.getAttribute("LOCALE");

	String fac_id    	= (String) session.getValue( "facility_id" ) ;
	String biometric_reason   = checkForNull((String) session.getValue( "biometric_reason" )) ;//Added By Himanshu for AAKH-crf-0175 on 04-09-23
	String smartCardFunc	=  isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 04-09-2023 
			
	String curr_user_id=(String)session.getValue("login_user");
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address ;
	client_ip_address = p.getProperty("client_ip_address");
    String lbValue=request.getParameter("LBoxValue")==null?"":request.getParameter("LBoxValue");
    String fromPage=(String) request.getParameter("from")==null?"":request.getParameter("from");
	//System.out.println("fromPage--------->"+fromPage);
	String reason_code=request.getParameter("reason_code");
	String proc_code	=request.getParameter("proc_code");//ADDED oN 1/4/2011 FOR RETNUIN CRF
	String term_set_id=request.getParameter("term_set_id");//ADDED oN 1/4/2011 FOR RETNUIN CRF
	//System.out.println("proc_code--------->"+proc_code);
	//System.out.println("term_set_id--------->"+term_set_id);
	String odrer_category=request.getParameter("odrer_category");
	String pat_id1				=	request.getParameter("patient_id");
	if(pat_id1 ==null) pat_id1="";
	String blng_grp				=	request.getParameter("blng_grp");
	if(blng_grp ==null) blng_grp="";

	if(odrer_category ==null) odrer_category="";

	oper_stn_id=(String) request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	
	String other_remarks = request.getParameter("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	if (fromPage.equals("GenerateSchedule")){
		StringBuffer sql=new StringBuffer("");
		sql.append("Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+fac_id+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.language_id='"+locale+"' and ");

		if(lbValue.equals("D")){
			sql.append(" clinic_type='Y' ");
		}else{
			sql.append("  clinic_type='"+lbValue+"' ");
		}  
  
		sql.append(" and CARE_LOCN_TYPE_IND='"+lbValue+"' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+fac_id+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+curr_user_id+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type order by a.long_desc");

		rs=stmt.executeQuery(sql.toString());
		sql.setLength(0);
		
            _bw.write(_wl_block8Bytes, _wl_block8);
 String dat="";
	     String ID="";
		 String locntype="";
		 while(rs.next() && rs!=null){
		 
			dat=rs.getString("long_desc");
			ID=rs.getString("clinic_code");
			locntype = rs.getString("clinic_type");


			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locntype));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block12Bytes, _wl_block12);

		 }
			if(rs !=null) rs.close();
            _bw.write(_wl_block13Bytes, _wl_block13);
}else if (fromPage.equals("GenerateSchedule_ref")){

		String clinic_code=(String) request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");

			
		String currentdate=(String) request.getParameter("sys_date")==null?"":request.getParameter("sys_date");		
		int dutyRosterCount = 0;
		String effdatefrom="";
		String effdateto="";
		String checkBoxAttribute1 = "";
		String checkBoxAttribute2 = "";
		String checkBoxAttribute3 = "";
		String checkBoxAttribute4 = "";
		String checkBoxAttribute5 = "";
		String checkBoxAttribute6 = "";
		String checkBoxAttribute7 = "";
			
		String day_1=request.getParameter("day_1");
		String day_2=request.getParameter("day_2");
		String day_3=request.getParameter("day_3");
		String day_4=request.getParameter("day_4");
		String day_5=request.getParameter("day_5");
		String day_6=request.getParameter("day_6");
		String day_7=request.getParameter("day_7");
		/*System.out.println("day_1:"+day_1);
		System.out.println("day_2:"+day_2);
		System.out.println("day_3:"+day_3);
		System.out.println("day_4:"+day_4);
		System.out.println("day_5:"+day_5);
		System.out.println("day_6:"+day_6);
		System.out.println("day_7:"+day_7);*/

		/*String dis1 = "DISABLED";
		String dis2 = "DISABLED";
		String dis3 = "DISABLED";
		String dis4 = "DISABLED";
		String dis5 = "DISABLED";
		String dis6 = "DISABLED";
		String dis7 = "DISABLED";
		String dis="DISABLED";
		*/
		String chk="DISABLED";
		//dis = dis;
		String dayofweek="";

		String day_1_desc="";
		String day_2_desc="";
		String day_3_desc="";
		String day_4_desc="";
		String day_5_desc="";
		String day_6_desc="";
		String day_7_desc="";

		String eff_from_disply="";
		String eff_to_disply="";

		int i=0;


		if(!(clinic_code == null ||clinic_code.equals(""))){

			rs=stmt.executeQuery("select to_char(max(effective_to_date_time+1),'dd/mm/yyyy') d from oa_clinic_schedule_validity where facility_id = '"+fac_id+"' and clinic_code = '"+clinic_code+"' ");
				
			if(rs.next()){
				effdatefrom =  rs.getString("d");

				if(effdatefrom == null ||effdatefrom.equals(""))
					effdatefrom = "";

				if(!effdatefrom.equals("")){
					String datComp="select case when  sysdate <to_date('"+effdatefrom+"','dd/mm/yyyy') then '0'else '1' end if from dual ";
					rssql1=stsql2.executeQuery(datComp);
					rssql1.next();
					if(rssql1.getString(1).equals("1"))
						effdatefrom=currentdate;
					}
					effdateto = effdatefrom;
				}
				if(rs !=null)	 rs.close();
				if(rssql1 !=null) rssql1.close();

				String sql_temp = "select count(1) cnt from oa_roster_for_pract where facility_id = '"+fac_id+"' and clinic_code = '"+clinic_code+"' and TO_CHAR(on_duty_date,'dd/mm/yyyy') between '"+effdatefrom+"' and '"+effdateto+"'";
				
				rssql1 = stsql2.executeQuery(sql_temp);
				if(rssql1.next())	{
					dutyRosterCount = rssql1.getInt("cnt");
				}
			}
			if(rs !=null) rs.close();

			StringBuffer dispStr=new StringBuffer("");
			day_1_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_1.toLowerCase())+".label","common_labels");
			day_2_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_2.toLowerCase())+".label","common_labels");
			day_3_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_3.toLowerCase())+".label","common_labels");
			day_4_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_4.toLowerCase())+".label","common_labels");
			day_5_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_5.toLowerCase())+".label","common_labels");
			day_6_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_6.toLowerCase())+".label","common_labels");
			day_7_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_7.toLowerCase())+".label","common_labels");

			String sql="select distinct lower(b.day_of_week)day_of_week, a.day_no from oa_clinic_time_table a, sm_day_of_week b where facility_id = '"+fac_id+"' and clinic_code = '"+clinic_code+"' and a.day_no = b.day_no order by a.day_no ";
			rs=stmt.executeQuery(sql);
			String time_table_yn="";
			String day_no="";
			if(rs.next()){
				chk="CHECKED";				
				dispStr.append("<table id='id' border='0' cellpadding='0' cellspacing='0'  width='80%'>");
				do{ 
					dayofweek =  rs.getString("day_of_week");
					dayofweek = dayofweek.substring(0, 3);
					day_no=rs.getString("day_no");
					i++;
					if(day_1.equalsIgnoreCase(dayofweek)){						
						checkBoxAttribute1 = "CHECKED";
					}else if(day_2.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute2 = "CHECKED";
					}else if(day_3.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute3 = "CHECKED";
					}else if(day_4.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute4 = "CHECKED";
					}else if(day_5.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute5 = "CHECKED";
					}else if(day_6.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute6 = "CHECKED";
					}else if(day_7.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute7 = "CHECKED";
					}				
				}while(rs.next());

				/*day_1_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
				day_2_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
				day_3_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
				day_4_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
				day_5_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
				day_6_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
				day_7_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");*/

				

				dispStr.append("<tr><td  id ='lbl' width='23%' class=label >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.TimeTableAvailableDays.label","oa_labels")+"</td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_1_desc+"<br>&nbsp;<input type='checkbox' name='day_1' id='day_1' value='"+day_1+"' "+checkBoxAttribute1+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_2_desc+"<br>&nbsp;<input type='checkbox' name='day_2' id='day_2' value='"+day_2+"' "+checkBoxAttribute2+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_3_desc+"<br>&nbsp;<input type='checkbox' name='day_3' id='day_3' value='"+day_3+"' "+checkBoxAttribute3+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_4_desc+"<br>&nbsp;<input type='checkbox' name='day_4' id='day_4' value='"+day_4+"' "+checkBoxAttribute4+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_5_desc+"<br>&nbsp;<input type='checkbox' name='day_5' id='day_5' value='"+day_5+"' "+checkBoxAttribute5+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_6_desc+"<br>&nbsp;<input type='checkbox' name='day_6' id='day_6' value='"+day_6+"' "+checkBoxAttribute6+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_7_desc+"<br>&nbsp;<input type='checkbox' name='day_7' id='day_7' value='"+day_7+"' "+checkBoxAttribute7+" disabled></td>");
				dispStr.append("</tr></table>");


				eff_from_disply=DateUtils.convertDate(effdatefrom,"DMY","en",locale);
				eff_to_disply=DateUtils.convertDate(effdateto,"DMY","en",locale);
				
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eff_from_disply));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(effdatefrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(eff_to_disply));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(effdateto));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fromPage));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fromPage));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dutyRosterCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dispStr.toString()));
            _bw.write(_wl_block24Bytes, _wl_block24);

				dispStr.setLength(0);
			}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fromPage));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fromPage));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
			if(rs !=null) rs.close();			 
			
            _bw.write(_wl_block28Bytes, _wl_block28);
}else if (fromPage.equals("QryApptforPractCriteria")){
            _bw.write(_wl_block29Bytes, _wl_block29);

		StringBuffer sqlQuery=new StringBuffer("");
		sqlQuery.append("select long_desc long_desc, clinic_code,ident_at_checkin,open_to_all_pract_yn,to_char(sysdate,'dd/mm/yyyy')  sydate from op_clinic_lang_vw   where facility_id='"+fac_id+"' and ");

		if(lbValue.equals("D")){
			sqlQuery.append("  clinic_type='Y' ");

		}else{
			sqlQuery.append("  clinic_type='"+lbValue+"' ");

		}
		  
		  
		 sqlQuery.append(" and CARE_LOCN_TYPE_IND='"+lbValue+"' and level_of_care_ind = 'A' and  eff_status='E' and  language_id ='"+locale+"' order by long_desc") ;

		if (rs!=null) rs.close();
		rs=stmt.executeQuery(sqlQuery.toString());
		sqlQuery.setLength(0);

		String clinicCode="";
		String clinicDesc="";
		String open_to_all_pract_yn="";
		String ident_at_checkin="";

		while(rs.next() && rs!=null){
			clinicCode=rs.getString("clinic_code");
			clinicDesc=rs.getString("long_desc");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
			ident_at_checkin=rs.getString("ident_at_checkin");
			
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(clinicCode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinicDesc));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
			
		if(rs !=null)	 rs.close();
			
            _bw.write(_wl_block34Bytes, _wl_block34);
} else if (fromPage.equals("LocationForADay")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);

		StringBuffer sql	= new StringBuffer("");
		sql.append("select long_desc long_desc, clinic_code, open_to_all_pract_yn ,to_char(sysdate,'dd/mm/yyyy')  sydate from op_clinic_lang_vw   where facility_id='"+fac_id+"' and language_id='"+locale+"' and ");

		if(lbValue.equals("D")){
			sql.append("  clinic_type='Y' ");
		}else{
			sql.append("  clinic_type='"+lbValue+"' ");
		}


		sql.append(" and CARE_LOCN_TYPE_IND='"+lbValue+"' and level_of_care_ind = 'A' and  eff_status='E' order by long_desc") ;

		if (rs!=null) rs.close();
		rs 	= stmt.executeQuery( sql.toString() ) ;
		sql.setLength(0);

		String clinicCode = "" ;
		String clinicDesc = "" ;
		String open_to_all_pract_yn="";

		while(rs.next() && rs!=null){
			clinicCode=rs.getString("clinic_code");
			clinicDesc=rs.getString("long_desc");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
			
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(clinicCode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinicDesc));
            _bw.write(_wl_block33Bytes, _wl_block33);
} 
		if(rs !=null) rs.close();	
			
            _bw.write(_wl_block37Bytes, _wl_block37);

	}else if (fromPage.equals("WaitListMgmtCancel")){
		
		PreparedStatement pStmt=null;
		con.setAutoCommit(false);
		Statement stmtsd=null;
		stmtsd=con.createStatement();
		String sys_date="";
			String sql="select to_char(sysdate,'dd/mm/yyyy') sys_dt from dual";
		rs=stmtsd.executeQuery(sql);
		while(rs.next())
		{
			sys_date=rs.getString("sys_dt");
		}
		if(rs !=null) rs.close();
		//Updating audit columns::
		String sQl="update pr_wait_list set wait_list_status='C' , REASON_FOR_CANCEL='"+reason_code+"' , REMARKS_FOR_CANCEL='"+other_remarks+"', MODIFIED_BY_ID='"+curr_user_id+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+fac_id+"' where facility_id=? and WAIT_LIST_NO=?"; //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		pStmt=con.prepareStatement(sQl);
		
		pStmt.setString(1,fac_id);
		pStmt.setString(2,lbValue);

		int cnt=pStmt.executeUpdate();

		//Added By Himanshu for AAKH-crf-0175 on 04-09-23 Start
		 try 
			{
			if(cnt!=0 && smartCardFunc.equals("01") && !biometric_reason.equals("")){
				String clinic_code=request.getParameter("clinicCode")==null?"":request.getParameter("clinicCode");
				session.removeAttribute("biometric_reason");
				String status1=insertReasonforBiometric(con,fac_id,"OA_MANAGE_WAITLIST",pat_id1,lbValue,clinic_code,biometric_reason,client_ip_address,curr_user_id);
				}
			}
			catch(Exception e){e.printStackTrace();}
		//  for AAKH-crf-0175 on 04-09-23 Ends

		if (cnt!=0){
			con.commit();
			
            _bw.write(_wl_block38Bytes, _wl_block38);


		}else{
			try{
			con.rollback();
		   }catch(Exception es){}
			
			
            _bw.write(_wl_block39Bytes, _wl_block39);

		
		}
		if (pStmt!=null) pStmt.close();


	} else if (fromPage.equals("WaitListMgmtModify")){

	   String preferredDate=request.getParameter("preferredDate")==null?"":request.getParameter("preferredDate");
	   String status=request.getParameter("status")==null?"":request.getParameter("status");
	   String clinic_code=request.getParameter("clinicCode")==null?"":request.getParameter("clinicCode");
	   String resourceId=request.getParameter("resourceid")==null?"":request.getParameter("resourceid");
	   String resource_class=request.getParameter("resource")==null?"":request.getParameter("resource");
	   String elapsed=request.getParameter("elapsed");
	   String wait_list_ref_no=request.getParameter("wait_list_ref_no")==null?"":request.getParameter("wait_list_ref_no");


	   String wait_list_category=request.getParameter("wait_list_category")==null?"":request.getParameter("wait_list_category");
	   String reason_modify_code=request.getParameter("reason_modify_code")==null?"":request.getParameter("reason_modify_code");
		
		//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		String remarks_for_modify = request.getParameter("remarks_for_modify")==null?"":request.getParameter("remarks_for_modify");
	   
	   if (elapsed==null) elapsed="";
				   
	   String sQl="";
	   PreparedStatement pStmt=null;
	   con.setAutoCommit(false);
	Statement stmtsd=null;
		stmtsd=con.createStatement();
		String sys_date="";
			String sql="select to_char(sysdate,'dd/mm/yyyy') sys_dt from dual";
		rs=stmtsd.executeQuery(sql);
		while(rs.next())
		{
			sys_date=rs.getString("sys_dt");
		}
		if(rs !=null) rs.close();
	   if (elapsed.equals("N")){
		   //Updating audit columns::
		   sQl="update pr_wait_list set WAIT_LIST_PRIORITY=?,PREFERRED_DATE_TIME=to_date(?,'dd/mm/yyyy'),locn_code=?,resource_class=?,RESOURCE_ID=? ,ORDER_CATALOG_CODE=? ,WAITLIST_CATEGORY_CODE=? ,REASON_FOR_MODIFY=?,MODIFIED_BY_ID='"+curr_user_id+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate,wait_list_ref_no=?, MODIFIED_FACILITY_ID='"+fac_id+"', REMARKS_FOR_MODIFY=? where facility_id=? and WAIT_LIST_NO=?"; //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

		   pStmt=con.prepareStatement(sQl);
		   pStmt.setString(1,status);
		   pStmt.setString(2,preferredDate);
		   pStmt.setString(3,clinic_code);
		   pStmt.setString(4,resource_class);
		   pStmt.setString(5,resourceId);
		   pStmt.setString(6,odrer_category);
		   pStmt.setString(7,wait_list_category);
		   pStmt.setString(8,reason_modify_code);
		   pStmt.setString(9,wait_list_ref_no);
		   pStmt.setString(10,remarks_for_modify); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		   pStmt.setString(11,fac_id);
		   pStmt.setString(12,lbValue);

		 //Added By Himanshu for AAKH-crf-0175 on 04-09-23 Start
		   try 
			{
			if(smartCardFunc.equals("01") && !biometric_reason.equals("")){
				session.removeAttribute("biometric_reason");
				String status1=insertReasonforBiometric(con,fac_id,"OA_MANAGE_WAITLIST",pat_id1,lbValue,clinic_code,biometric_reason,client_ip_address,curr_user_id);
				}
			}
			catch(Exception e){e.printStackTrace();}
		 // for AAKH-crf-0175 on 04-09-23 Start   
			
	}else if (elapsed.equals("Y")){
			//Updating audit columns::
			sQl="update pr_wait_list set PREFERRED_DATE_TIME=to_date(?,'dd/mm/yyyy'),REASON_FOR_MODIFY=? ,MODIFIED_BY_ID='"+curr_user_id+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+fac_id+"', REMARKS_FOR_MODIFY=? where facility_id=? and WAIT_LIST_NO=?"; //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			if (pStmt!=null) pStmt.close();
			pStmt=con.prepareStatement(sQl);
			pStmt.setString(1,preferredDate);
			pStmt.setString(2,reason_modify_code);
			pStmt.setString(3,remarks_for_modify); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			pStmt.setString(4,fac_id);
			pStmt.setString(5,lbValue);
		}

	   int result=pStmt.executeUpdate();
	   if (result!=0){
		   con.commit();
			
            _bw.write(_wl_block40Bytes, _wl_block40);


	   }else{
		   try{
			con.rollback();
		   }catch(Exception es){}
		
			
			
            _bw.write(_wl_block41Bytes, _wl_block41);

		 
	   }
	   
	   if (pStmt!=null) pStmt.close();

	}else if (fromPage.equals("WaitListMgmtModifyWindow")){

		String clinic_code1=request.getParameter("clinicCode")==null?"":request.getParameter("clinicCode");
		String clinic_type =request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
		String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+fac_id+"'";

		String code="";
		String desc="";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);
		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
				if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
			
			if (desc==null) desc="";
		
		}
				if(rs !=null) rs.close();	

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block46Bytes, _wl_block46);

	}else if (fromPage.equals("ForceClose")){
		String force_prd_days=request.getParameter("force_prd_days");
		String patientid=request.getParameter("patientid");
		if(patientid ==null) patientid="";
		String sQl="";
		PreparedStatement pStmt=null;
		con.setAutoCommit(false);
		int result=0;
		if(patientid.equals("null") || patientid.equals(""))
			{
			//Updating Audit Columns::
		sQl="update pr_wait_list set wait_list_status ='X', MODIFIED_BY_ID='"+curr_user_id+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+fac_id+"'  where facility_id=? and wait_list_status='O' and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') between   trunc(sysdate - ?)  and  trunc(sysdate-1)";
	

		if (pStmt!=null) pStmt.close();
		pStmt=con.prepareStatement(sQl);
		pStmt.setString(1,fac_id);
		pStmt.setString(2,force_prd_days);

	    result=pStmt.executeUpdate();
			}else
			{
			//Updating audit columns::
		sQl="update pr_wait_list set wait_list_status ='X', MODIFIED_BY_ID='"+curr_user_id+"', MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+fac_id+"'  where facility_id=? and wait_list_status='O' and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') between trunc(sysdate - ? )  and  trunc(sysdate-1) and patient_id=?";
				

		if (pStmt!=null) pStmt.close();
		pStmt=con.prepareStatement(sQl);
		pStmt.setString(1,fac_id);
		pStmt.setString(2,force_prd_days);
		pStmt.setString(3,patientid);

	    result=pStmt.executeUpdate();

			}

	   if (result !=0){
		  con.commit();
		
            _bw.write(_wl_block47Bytes, _wl_block47);


	   }else{
		   try{
			con.rollback();
		   }catch(Exception es){}
		
			
            _bw.write(_wl_block48Bytes, _wl_block48);

			
			
	   }
	   
	   if (pStmt!=null) pStmt.close();


	}else if (fromPage.equals("chkpatient_id_valid")){ 

			String patient_id_chk=request.getParameter("patient_id");
			String sql_pat_id="Select * from mp_patient where patient_id='"+patient_id_chk+"'";
			rs=stmt.executeQuery(sql_pat_id);
			if(rs !=null && rs.next())
			{
            _bw.write(_wl_block49Bytes, _wl_block49);
}else
			{
            _bw.write(_wl_block50Bytes, _wl_block50);
}

	}else if (fromPage.equals("rule_based_patient_val")){ 
	// added by N Munisekhar on 04-May-2012 against [IN:039768]
	        String sql_pat_id="";
			String patient_id=request.getParameter("patient_id");
			apptrefno=request.getParameter("apptrefno");
			String from_page_new=request.getParameter("from_page_new")==null?"":request.getParameter("from_page_new");
			if(patient_id!=null){ 
			 sql_pat_id="Select NAME_PREFIX,FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME,NAME_SUFFIX,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG, SEX, ACTIVE_YN, SUSPEND_YN, DECEASED_YN, LANGUAGE_ID,CONTACT2_NO ,NATIONALITY_CODE country_id,b.long_desc country_desc,c.long_name language_desc  from mp_patient a, mp_country b,MP_LANGUAGE c where patient_id='"+patient_id+"' and A.NATIONALITY_CODE=B.COUNTRY_CODE(+) and A.LANGUAGE_ID=C.LANG_ID(+) ";
			}// added by N Munisekhar on 04-May-2012 against [IN:039768]
			else if(patient_id==null && apptrefno!="")
			{
		sql_pat_id="SELECT NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NAME_PREFIX_LOC_LANG, FIRST_NAME_LOC_LANG, SECOND_NAME_LOC_LANG, THIRD_NAME_LOC_LANG, FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,gender SEX, LANGUAGE_ID, OTH_CONTACT_NO CONTACT2_NO,NATIONAL_ID_NO country_id, b.long_desc country_desc,c.long_name language_desc FROM oa_appt_del_tr a,mp_country b, mp_language c WHERE a.appt_ref_no ='"+apptrefno+"' AND a.NATIONAL_ID_NO = b.country_code(+) and A.LANGUAGE_ID=C.LANG_ID(+)";
		}
			rs=stmt.executeQuery(sql_pat_id);
			String name_prefix="";
			String first_name="";
			String second_name="";
			String third_name="";
			String family_name="";
			String name_suffix="";
			String name_prefix_loc_lang="";
			String first_name_loc_lang="";
			String second_name_loc_lang="";
			String third_name_loc_lang="";
			String family_name_loc_lang="";
			String name_suffix_loc_lang="";
			String deceased_yn="";
			String suspend_yn="";
			String gender="";
			String contact2_no="";
			String language_id="";
			String language_desc="";
			String country_id="";
			String country_desc="";
			if(rs !=null && rs.next()){
				name_prefix=rs.getString("NAME_PREFIX")==null?"":rs.getString("NAME_PREFIX");
				first_name=rs.getString("FIRST_NAME")==null?"":rs.getString("FIRST_NAME");
				second_name=rs.getString("SECOND_NAME")==null?"":rs.getString("SECOND_NAME");
				third_name=rs.getString("THIRD_NAME")==null?"":rs.getString("THIRD_NAME");
				family_name=rs.getString("FAMILY_NAME")==null?"":rs.getString("FAMILY_NAME");
				name_suffix=rs.getString("NAME_SUFFIX")==null?"":rs.getString("NAME_SUFFIX");
				name_prefix_loc_lang=rs.getString("name_prefix_loc_lang")==null?"":rs.getString("name_prefix_loc_lang");
				first_name_loc_lang=rs.getString("first_name_loc_lang")==null?"":rs.getString("first_name_loc_lang");
				second_name_loc_lang=rs.getString("second_name_loc_lang")==null?"":rs.getString("second_name_loc_lang");
				third_name_loc_lang=rs.getString("third_name_loc_lang")==null?"":rs.getString("third_name_loc_lang");
				family_name_loc_lang=rs.getString("family_name_loc_lang")==null?"":rs.getString("family_name_loc_lang");
				name_suffix_loc_lang=rs.getString("name_suffix_loc_lang")==null?"":rs.getString("name_suffix_loc_lang");
				// added by N Munisekhar on 04-May-2012 against [IN:039768]
				if(patient_id!=null){ 
				deceased_yn=rs.getString("DECEASED_YN")==null?"N":rs.getString("DECEASED_YN");
				suspend_yn=rs.getString("SUSPEND_YN")==null?"N":rs.getString("SUSPEND_YN");
				}
				gender=rs.getString("SEX")==null?"":rs.getString("SEX");
				contact2_no=rs.getString("CONTACT2_NO")==null?"":rs.getString("CONTACT2_NO");
				language_id=rs.getString("language_id")==null?"":rs.getString("language_id");
				language_desc=rs.getString("language_desc")==null?"":rs.getString("language_desc");
				country_id=rs.getString("country_id")==null?"":rs.getString("country_id");
				country_desc=rs.getString("country_desc")==null?"":rs.getString("country_desc");
				if(deceased_yn.equals("Y")){//System.out.println("coming inside one");
					
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(from_page_new));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(from_page_new));
            _bw.write(_wl_block53Bytes, _wl_block53);
}else if(suspend_yn.equals("Y")){//System.out.println("coming inside two");
						
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(from_page_new));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(from_page_new));
            _bw.write(_wl_block55Bytes, _wl_block55);
}else{
						
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(from_page_new));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(from_page_new));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(name_suffix));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(name_suffix_loc_lang));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(contact2_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(country_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(country_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(language_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(language_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
}
            _bw.write(_wl_block76Bytes, _wl_block76);
}else{
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(from_page_new));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(from_page_new));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
	}else if(fromPage.equals("rule_based_appt")){	
		

		String from_page_new=request.getParameter("from_page_new");		
		String clinic_code=request.getParameter("clinic_code");
		String clinic_date=request.getParameter("clinic_date");
		String pract_id=request.getParameter("pract_id");
		String start_time=request.getParameter("start_time");
		String end_time=request.getParameter("end_time");
		String time_table_type=request.getParameter("time_table_type");

		
			String book_appt_yn ="";
			String book_appt_wo_pid_yn ="";
			String obook_appt_yn ="";
			String book_appt_across_catg_yn ="";
			String tfr_appt_yn ="";
			String tfr_appt_across_catg_yn ="";
			String canc_appt_yn ="";
			String FORCED_BOOK_APPT_YN ="";
			String GLOBAL_BOOK_APPT_YN ="";
			String global_locn_yn ="";
			//String chk_frm_CA="select CARE_LOCN_TYPE_IND from op_clinic where clinic_code='"+clinic_code+"' and facility_id='"+facilityid+"'";
			String sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=?  and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y') ";
			pstmt = con.prepareStatement(sql_access);
			pstmt.setString(1,fac_id);
			pstmt.setString(2,clinic_code);
			pstmt.setString(3,oper_stn_id);
			pstmt.setString(4,curr_user_id);
			if(rs !=null) rs.close();
			rs=pstmt.executeQuery();
			if(rs !=null && rs.next()){
				book_appt_yn			= checkForNull(rs.getString("book_appt_yn"));
				book_appt_wo_pid_yn		= checkForNull(rs.getString("book_appt_wo_pid_yn"));
				obook_appt_yn			= checkForNull(rs.getString("obook_appt_yn"));
				book_appt_across_catg_yn= checkForNull(rs.getString("book_appt_across_catg_yn"));
				tfr_appt_yn				= checkForNull(rs.getString("tfr_appt_yn"));
				tfr_appt_across_catg_yn	= checkForNull(rs.getString("tfr_appt_across_catg_yn"));
				canc_appt_yn			= checkForNull(rs.getString("canc_appt_yn"));
				FORCED_BOOK_APPT_YN		= checkForNull(rs.getString("FORCED_BOOK_APPT_YN"));
				GLOBAL_BOOK_APPT_YN		= checkForNull(rs.getString("GLOBAL_BOOK_APPT_YN"));
				global_locn_yn			= checkForNull(rs.getString("global_locn_yn"));
			}
			if(rs !=null) rs.close();
		
			
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(book_appt_wo_pid_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(book_appt_across_catg_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(global_locn_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(GLOBAL_BOOK_APPT_YN));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(time_table_type));
            _bw.write(_wl_block91Bytes, _wl_block91);

	}else if(fromPage.equals("pop_wtlist_data")){
		String waitListNo=request.getParameter("waitListNo");
		String waitListDataSql="Select FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME,GENDER,NATIONALITY_CODE country_id,b.long_desc country_desc/*,LANGUAGE_ID,c.long_name language_desc*/  from pr_wait_list a, mp_country b/*,MP_LANGUAGE c*/ where wait_list_no='"+waitListNo+"' and A.NATIONALITY_CODE=B.COUNTRY_CODE(+) /*and A.LANGUAGE_ID=C.LANG_ID(+)*/";
		
		//System.out.println("waitListDataSql :"+waitListDataSql);
		rs=stmt.executeQuery(waitListDataSql);
		String first_name="";
		String second_name="";
		String third_name="";
		String family_name="";
		String gender="";
		String contact2_no="";
		String language_id="";
		String language_desc="";
		String country_id="";
		String country_desc="";
		if(rs !=null && rs.next()){
			first_name=rs.getString("FIRST_NAME")==null?"":rs.getString("FIRST_NAME");
			second_name=rs.getString("SECOND_NAME")==null?"":rs.getString("SECOND_NAME");
			third_name=rs.getString("THIRD_NAME")==null?"":rs.getString("THIRD_NAME");
			family_name=rs.getString("FAMILY_NAME")==null?"":rs.getString("FAMILY_NAME");
			gender=rs.getString("GENDER")==null?"":rs.getString("GENDER");
			country_id=rs.getString("country_id")==null?"":rs.getString("country_id");
			country_desc=rs.getString("country_desc")==null?"":rs.getString("country_desc");		
		}
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(contact2_no));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(country_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(country_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(language_desc));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(language_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
}

	if(rssql1!=null) rssql1.close();
	if (rs!=null) rs.close();
	if(stmt !=null) stmt.close();
	if(stsql2!=null) stsql2.close();
	if(pstmt!=null) pstmt.close();

	if(fromPage.equals("PROC_PRACT_LINK")){
			String  short_desc="";
			String PROC_DESC_SQL="SELECT SHORT_DESC FROM MR_D_"+term_set_id+"_LANG_VW WHERE TERM_CODE = ? AND TERM_SET_ID=? AND LANGUAGE_ID=? ";
			pstmt = con.prepareStatement(PROC_DESC_SQL);
			pstmt.setString(1,proc_code);
			pstmt.setString(2,term_set_id);
			pstmt.setString(3,locale);
			rs=pstmt.executeQuery();
			while(rs.next()){
				short_desc = rs.getString("SHORT_DESC");
			}
			if (rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(short_desc.equals("")){
            _bw.write(_wl_block103Bytes, _wl_block103);
}else{
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block105Bytes, _wl_block105);
}
	}

}catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();
}
finally{

	if (con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block106Bytes, _wl_block106);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
