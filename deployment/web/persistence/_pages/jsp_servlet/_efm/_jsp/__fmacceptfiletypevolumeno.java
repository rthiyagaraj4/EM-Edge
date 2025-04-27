package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.Properties;
import java.util.*;
import com.ehis.util.*;

public final class __fmacceptfiletypevolumeno extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMAcceptFileTypeVolumeNo.jsp", 1730122971996L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>alert(\'Database Connection is not available\');\n\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\'; \n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<input type=\"hidden\" name=\"req_no\" id=\"req_no\"  value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"perm_fs_locn\" id=\"perm_fs_locn\"  value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="     \n   \n\t\t<script>\t\t\t\n\t\t\t\n\t\t\tvar volume_status=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t       var curr_file_status=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t  if(volume_status==\"L\")\n\t\talert(parent.frames[0].getMessage(\'FILE_IS_LOST\',\'FM\'));\n\t\telse\n   alert(parent.frames[0].getMessage(\'FILE_IS_INACTIVE\',\'FM\'));\n\t\t</script>\n    \t\t\n\t\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'></link>\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<Script>\n\tfunction EnableDisableOKButton()\n\t{\n\t\t\n\t\t\n\t\tif(document.forms[0].file_type_code)\n\t\t{\n\t\t\n\t\tif(document.forms[0].file_type_code.value==\"\" || document.forms[0].volume_no.value ==\"\" || document.forms[0].narration_code.value==\"\" )\n\t\t{\n\t\t\tdocument.forms[0].ok_button.disabled = true;\n\t\t}\n\t\telse if(document.forms[0].file_type_code.value !=\"\" && document.forms[0].volume_no.value !=\"\" && document.forms[0].narration_code.value !=\"\"  )\n\t\t{\n\t\t\tif(document.forms[0].ok_button.disabled == true)\n\t\t\t{\n\t\t\t\tdocument.forms[0].ok_button.disabled = false;\n\t\t\t}\n\t\t}\n\t\t}else{\n\n\nif(document.forms[0].volume_no.value ==\"\" || document.forms[0].narration_code.value==\"\" || document.forms[0].fs_locn_code_1.value==\"\" )\n\t\t{\n\t\tdocument.forms[0].ok_button.disabled = true;\n\t\t}\n\t\telse if(document.forms[0].volume_no.value !=\"\" && document.forms[0].narration_code.value !=\"\"  && document.forms[0].fs_locn_code_1.value!=\"\")\n\t\t{\n\t\t\tif(document.forms[0].ok_button.disabled == true)\n\t\t\t{\n\t\t\t\tdocument.forms[0].ok_button.disabled = false;\n\t\t\t}\n\t\t}\n\n\t\t}\n\t}\n\t\n\tfunction populatevolumeno()\n\t\t{\n\n        var file_type_code=\"\"; \n\t\tvar count_reason=\"\";\n\t\tvar perm_fs_locn_code=\"\";\n\t\tvar flag_status=\"AUTO_REQ\";\n\t\tif(document.forms[0].file_type_code)\n\t\tfile_type_code=document.forms[0].file_type_code.value;\t\t\n\t\t\n\t\tif(document.forms[0].count_reason)\n\t\tcount_reason=document.forms[0].count_reason.value;\n\t\t\t\n\t\tvar patient_id=document.forms[0].patient_id.value;\n          var file_type_appl_yn  =document.forms[0].file_type_appl_yn.value;\n\t\t\tif(document.forms[0].fs_locn_code_1)\n\t\t\t perm_fs_locn_code =document.forms[0].fs_locn_code_1.value;\n\t\t\tremoveitems(document.forms[0].volume_no);\n             var temp =\"\";\n\t\t\t\tvar temp1=\"------\" +getLabel(\'Common.defaultSelect.label\',\'common\')+ \"-----\";\n\t\t\t\tvar opt=parent.document.frames[0].document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\t\tparent.document.frames[0].document.forms[0].volume_no.add(opt);\n \n \n //   var xmlHttp \t= new ActiveXObject( \"Microsoft.XMLHTTP\" );\n\t\t\t//xmlHttp.open(\"POST\",\"../../eFM/jsp/FMCheckFileExists.jsp?flag_status=AUTO_REQ&patient_id=\"+patient_id+\"&file_type_code=\"+file_type_code+\"&file_type_appl_yn1=\"+file_type_appl_yn+\"&perm_fs_locn_code=\"+perm_fs_locn_code,false);\n\t\t//\txmlHttp.send(null);\t\t\n\t\t//\tresponseText=trimString(xmlHttp.responseText);\n//alert(responseText)\n\n\n var HTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eFM/jsp/FMCheckFileExists.jsp\' ><input name=\'patient_id\' id=\'patient_id\' type=\'hidden\' value=\'\"+patient_id+\"\'><input name=\'file_type_code\' id=\'file_type_code\' type=\'hidden\' value=\'\"+file_type_code+\"\'><input name=\'file_type_appl_yn1\' id=\'file_type_appl_yn1\' type=\'hidden\' value=\'\"+file_type_appl_yn+\"\'><input name=\'perm_fs_locn_code\' id=\'perm_fs_locn_code\' type=\'hidden\' value=\'\"+perm_fs_locn_code+\"\'><input name=\'flag_status\' id=\'flag_status\' type=\'hidden\' value=\'\"+flag_status+\"\'><input name=\'count_reason\' id=\'count_reason\' type=\'hidden\' value=\'\"+count_reason+\"\'></form></BODY></HTML>\";\n\t\tparent.msgFrame.document.write(HTMLVal);\n\t\tparent.msgFrame.document.form1.submit();\n\n\t\t}\n\t\n\tfunction removeitems(obj)\n{\n\tvar len=obj.length;\n\tvar i=0;\n\twhile(i<len)\n\t{\n\t\tlen=obj.length\n\t\tobj.remove(i)\n\t}\n}\n\tfunction closeWindow()\n\t{ \t if(document.forms[0].file_type_code)\n\t\t{\n\t\t if(document.forms[0].file_type_code.value == \'\')\n\t\t{\n\t\t\t//alert(\'APP-000001 Volume No cannot be blank...\');\n\t\t\tvar msg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\tmsg=msg.replace(\"$\",getLabel(\"eFM.FMFileType.label\",\"FM\"));\n\t\t\talert(msg);\n\t\t} \n\t\telse if(document.forms[0].volume_no.value == \'\')\n\t\t{\n\t\t\t//alert(\'APP-000001 Volume No cannot be blank...\');\n\t\t\tvar msg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\tmsg=msg.replace(\"$\",getLabel(\"eFM.VolumeNo.label\",\"FM\"));\n\t\t\talert(msg);\n\t\t}\n\t\telse if(document.forms[0].narration_code.value == \'\')\n\t\t{\n\t\t\t//alert(\'APP-000001 Reason for Borrowing cannot be blank...\');\n\t\t\tvar msg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\tmsg=msg.replace(\"$\",getLabel(\"eFM.ReasonForBorrowing.label\",\"FM\"));\n\t\t\talert(msg);\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//if(document.forms[0].fs_locn_code_1!=null)\n\t\t\t\t//document.forms[0].fs_locn_code.value = document.forms[0].fs_locn_code_1.value;\n\t\t\tif(document.forms[0].volume_no!=null)\n\t\t\t\tdocument.forms[0].volume_no1.value = document.forms[0].volume_no.value;\n\t\t\tif(document.forms[0].file_type_code!=null)\n\t\t\t\tdocument.forms[0].file_type_code1.value = document.forms[0].file_type_code.value;\n\t\t\tif(document.forms[0].narration_code!=null)\n\t\t\t\tdocument.forms[0].narration_code1.value = document.forms[0].narration_code.value;\t\t\t\n\t\t\t\tdocument.forms[0].submit();\t\n\t\t\t\n\t\t\t//parent.parent.window.close();\n\t\t}\n\t\t}else{\n\n\tif(document.forms[0].fs_locn_code_1.value==\'\')\n\t\t\t{\n        \tvar msg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\tmsg=msg.replace(\"$\",getLabel(\"Common.FileStorageLocation.label\",\"common\"));\n\t\t\talert(msg);\n\n\t\t\t}\n\telse if(document.forms[0].volume_no.value ==\'\')\n\t\t\t{\n\t\t\t//alert(\'APP-000001 Volume No cannot be blank...\');\n\t\t\tvar msg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\tmsg=msg.replace(\"$\",getLabel(\"eFM.VolumeNo.label\",\"FM\"));\n\t\t\talert(msg);\n\t\t}\n\t\telse if(document.forms[0].narration_code.value == \'\')\n\t\t{\n\t\t\t//alert(\'APP-000001 Reason for Borrowing cannot be blank...\');\n\t\t\tvar msg=getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\tmsg=msg.replace(\"$\",getLabel(\"eFM.ReasonForBorrowing.label\",\"FM\"));\n\t\t\talert(msg);\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//if(document.forms[0].fs_locn_code_1!=null)\n\t\t\t\t//document.forms[0].fs_locn_code.value = document.forms[0].fs_locn_code_1.value;\n\t\t\tif(document.forms[0].volume_no!=null)\n\t\t\t\tdocument.forms[0].volume_no1.value = document.forms[0].volume_no.value;\n\t\t\tif(document.forms[0].file_type_code!=null)\n\t\t\t\tdocument.forms[0].file_type_code1.value = document.forms[0].file_type_code.value;\n\t\t\t\tif(document.forms[0].narration_code!=null)\n\t\t\t\tdocument.forms[0].narration_code1.value = document.forms[0].narration_code.value;\n\t\t\t\tdocument.forms[0].submit();\t\t\t\n\t\t//\tparent.parent.window.close();\n\t\t}\n\n\n\t\t}\n\t}\n\tfunction CancelWindow()\n\t{\n\t\tconst diagElement = parent.parent.document.getElementsByTagName(\'dialog\');\n\t\tvar returnValue;\n\t\tfor (var i = 0; i < diagElement.length; i++) {\n\t\t    for (var j = 0; j < diagElement[i].children.length; j++) {\n\t\t        var element = diagElement[i].children[j];\n\t\t        let dialogSrc = element.src;\n\t\t        if (typeof dialogSrc !== \'undefined\') {\n\t\t            if (dialogSrc.includes(\'FMAcceptFileTypeVolumeNoFrame.jsp\')) {\n\t\t               diagElement[i].close(); \n\t\t            }\n\t\t        }\n\t\t    }\n\t\t}\n\t\t//parent.parent.window.close();\n\t}\n</script>\n\n</head>\n</html>\n<form name=\"FMAcceptFileTypeForm\" id=\"FMAcceptFileTypeForm\" action=\"FMAcceptFileTypeVolumeNo.jsp\" method=\"POST\" target=\"msgFrame\">\n<input type=\'Hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\'Hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<!-- Added for MMS-QH-CRF-0148 -->\n<input type=\'Hidden\' name=\'count_volumeno\' id=\'count_volumeno\' value=\"0\">\n<input type=\'Hidden\' name=\'count_reason\' id=\'count_reason\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<table width=\"100%\" border=\'0\' cellpadding=\'2\' cellspacing=\'0\' align=\"CENTER\">\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<tr>\n\t\t<td class=\'label\' nowrap width=\"40%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t<td class=\'fields\' width=\"60%\"><select name=\"file_type_code\" id=\"file_type_code\" onChange=\'EnableDisableOKButton();populatevolumeno();\'>\n\t\t\t<option>------";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="-----</option>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<option value = \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t</td>\n\t</tr>\n\t<!-- <tr><td colspan=\"2\">&nbsp;</td></tr> -->\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t<td class=\'fields\' width=\"60%\"><select name=\"fs_locn_code_1\" id=\"fs_locn_code_1\" onChange=\'EnableDisableOKButton();populatevolumeno();\'>\n\t\t\t<option>------";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t<tr>\n\t<td  class=\'label\' nowrap width=\"40%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t<td  class=\'fields\' width=\"60%\" nowrap><select name=\"volume_no\" id=\"volume_no\" onChange=\'EnableDisableOKButton();\'>\n\t\t<option value=\"\">------";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="-----</option>\n\t\t\t\n\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t</td>\n\t</tr>\n<!--Below line added for this CRF PMG2013-MMS-CRF-0005 [IN:045278] -->\n<script>\nif(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'==\"Y\"){\nif(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'==1){\ndocument.forms[0].file_type_code.selectedIndex = 1;\npopulatevolumeno();\n}else{\ndocument.forms[0].file_type_code.selectedIndex = 0;\n}\n}\nif(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'==\"N\"){\nif(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'==1){\ndocument.forms[0].fs_locn_code_1.selectedIndex = 1;\npopulatevolumeno();\n}else{\ndocument.forms[0].fs_locn_code_1.selectedIndex = 0;\n}\n}\n\n</script>\n<!--End PMG2013-MMS-CRF-0005 [IN:045278] -->\n\t\n\t<tr>\n\t<td  class=\'label\' nowrap width=\"40%\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t<td  class=\'fields\' width=\"60%\" nowrap><select name=\"narration_code\" id=\"narration_code\"  onChange=\'EnableDisableOKButton();\' >\n\t\t<option value=\"\">------";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</option>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t</td>\n\t</tr>\n\n\t<tr><td colspan=\"2\">&nbsp;</td></tr>\n\t<tr>\n\t\t<td colspan=\"2\" align=\"CENTER\"><input type=\"button\" class=\"BUTTON\" value=\"OK\" id=\"ok_button\" name=\"ok_button\" id=\"ok_button\" style=\"width:50\" onClick=\"closeWindow();\" disabled>&nbsp;<input type=\"button\" class=\"BUTTON\" value=\"Cancel\" name=\"CancelButton\" id=\"CancelButton\" onClick=\"CancelWindow();\"></td>\n\t</tr>\n\t\n\t<input type=\'Hidden\' name=\'online_mr_notfn_yn\' id=\'online_mr_notfn_yn\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\'Hidden\' name=\'req_locn_id\' id=\'req_locn_id\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\'Hidden\' name=\'file_no1\' id=\'file_no1\' value=\"\">\n\t<input type=\'Hidden\' name=\'fs_locn_code\' id=\'fs_locn_code\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\'Hidden\' name=\'volume_no1\' id=\'volume_no1\' value=\"\">\t\n\t<input type=\'Hidden\' name=\'file_type_code1\' id=\'file_type_code1\' value=\"\">\n\t<input type=\'Hidden\' name=\'narration_code1\' id=\'narration_code1\' value=\"\">\n\t<input type=\'Hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<!-- Added for MMS-QH-CRF-0148 -->\n\t<input type=\'Hidden\' name=\'count_filetype\' id=\'count_filetype\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\'Hidden\' name=\'sitespecific_autofilereq\' id=\'sitespecific_autofilereq\' value=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">\n\t</table>\n</form>\n</html>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
Connection connection			= null;
PreparedStatement preStatement	= null;
ResultSet	resultSet			= null;

String file_type_appl_yn	= "N";
String sqlString			= "";
String loginUser			= "";
String facilityID			= "";
String file_no				= "";
String file_no_new			= "";
String file_type_code		= "";
String patient_id			= "";
String volume_no			= "";
String fs_locn_code			= "";
String online_mr_notfn_yn	= "";
String req_locn_id			= "";
String narration_code		= "";
//String dflt_narration		= "";
String p_code				= "";
String p_desc				= "";
String encounter_id			= "";
String file_type_code2="";
String fileno_nw="";
String volume_status="";
String curr_file_status="";
Boolean SiteSpecific_AutoFileReq = false;
// Below line added this CRF PMG2013-MMS-CRF-0005 [IN:045278]
int count_filetype=0; 
int count_reason=0; 
	
try
{
	connection = ConnectionManager.getConnection(request);
	String locale=(String)session.getAttribute("LOCALE");

	if(connection == null)
	{
		
            _bw.write(_wl_block6Bytes, _wl_block6);

	}

	loginUser			=	checkForNull((String) session.getValue("login_user"));
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	StringBuffer sqlBuffer		=	new StringBuffer();
	online_mr_notfn_yn	=	checkForNull(request.getParameter("online_mr_notfn_yn"));
	req_locn_id			=	checkForNull(request.getParameter("req_locn_id"));
	patient_id			=	checkForNull(request.getParameter("patient_id"));

	file_no				=	checkForNull(request.getParameter("file_no1"));
	volume_no			=	checkForNull(request.getParameter("volume_no1"));
	file_type_code		=	checkForNull(request.getParameter("file_type_code1"));
	fs_locn_code		=	checkForNull(request.getParameter("fs_locn_code"));
	narration_code			=	checkForNull(request.getParameter("narration_code1"));
	encounter_id			=	checkForNull(request.getParameter("encounter_id"));
  file_type_code2      =	checkForNull(request.getParameter("file_type_code"));
  
	SiteSpecific_AutoFileReq = CommonBean.isSiteSpecific(connection, "MP","AUTO_CREATE_PAT_FILE_AND_REQ"); //Added for MMS-QH-CRF-0148
	
  // Added this CRF PMG2013-MMS-CRF-0005 [IN:045278]
        String sqlcount = "select count(*) reasonbrowsing from fm_narration_lang_vw where eff_status='E' and language_id='"+locale+"'";
		preStatement	=	connection.prepareStatement(sqlcount);		
		resultSet		=	preStatement.executeQuery();
		if(resultSet != null) {
			    while(resultSet.next()){  
 				   count_reason=resultSet.getInt("reasonbrowsing"); 
	            }
        }
    if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();		
//End PMG2013-MMS-CRF-0005 [IN:045278]	

		
	if(!file_no.equals(""))
	{
	preStatement	= connection.prepareStatement("SELECT volume_status,CURR_FILE_STATUS, (SELECT file_type_appl_yn FROM mp_param) file_type_appl_yn FROM fm_curr_locn where facility_id = ? and patient_id=? and file_no=? and volume_no=? ");
	preStatement.setString(1, facilityID);
	preStatement.setString(2, patient_id);
	preStatement.setString(3, file_no );
	preStatement.setString(4, volume_no);

	} else {
   preStatement	= connection.prepareStatement("SELECT file_type_appl_yn FROM mp_param ");
	}

	resultSet		= preStatement.executeQuery();
	
	
	if((resultSet != null) && (resultSet.next()))
	{
		if(!file_no.equals(""))
		{
		volume_status		= resultSet.getString("volume_status");
		curr_file_status    = resultSet.getString("CURR_FILE_STATUS");
		file_type_appl_yn	= resultSet.getString("file_type_appl_yn");
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "N";
		}else{
       file_type_appl_yn	= resultSet.getString("file_type_appl_yn");
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "N";

		}
	
	}
	
	
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
	
	/*preStatement	= connection.prepareStatement("SELECT file_type_appl_yn FROM mp_param ");
	resultSet		= preStatement.executeQuery();
	if((resultSet != null) && (resultSet.next()))
	{
		file_type_appl_yn	= resultSet.getString("file_type_appl_yn");
	}
	
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "N";

	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();*/

	if(!volume_no.equals(""))
	{
		int filecount			=0 ;
		String client_ip_address	= "";
		
		CallableStatement callStatement = null;

		Properties p = (Properties) session.getValue( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		
	//	preStatement = connection.prepareStatement("select count(*) fc from fm_req_dtl a ,fm_req_hdr b where a.req_no=b.req_no and a.req_to_facility_id = ? and  b.REQ_FS_LOCN_CODE = ?  and a.FILE_NO = ? and a.cancel_yn = 'N' and a.volume_no = ? ");
		                           sqlBuffer.append("SELECT count(*) fc " );
								sqlBuffer.append("FROM" );
								sqlBuffer.append("  FM_REQ_HDR A" );
								sqlBuffer.append("  , FM_REQ_DTL B " );
								sqlBuffer.append("WHERE A.REQ_NO = B.REQ_NO " );
								sqlBuffer.append("  AND A.REQ_FS_LOCN_CODE = '"+fs_locn_code+"' " );
								sqlBuffer.append("  AND A.REQ_FACILITY_ID = '"+facilityID+"' " );
								sqlBuffer.append("  AND B.ISS_YN = 'N' " );
								sqlBuffer.append("  AND B.CANCEL_YN = 'N'" );
								sqlBuffer.append(" AND B.FILE_NO='"+file_no+"' ");
								sqlBuffer.append(" AND B.volume_no="+volume_no+" ");
								
							
														
							preStatement = connection.prepareStatement(sqlBuffer.toString());
								
								
	/*	preStatement.setString(1, facilityID );
		preStatement.setString(2, fs_locn_code );
		preStatement.setString(3, file_no );
		preStatement.setString(4, volume_no ); */
		
			resultSet = preStatement.executeQuery();
		if((resultSet != null) && resultSet.next())
		{
			filecount = resultSet.getInt(1);
		}
      	
		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();

	
	if(filecount==0 && !volume_status.equals("L") && !curr_file_status.equals("A"))
		{			
						
				if(online_mr_notfn_yn.equals("Y")&& fs_locn_code!="" && file_no!="")
			{				

			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
					
			if(file_type_appl_yn.equals("Y"))
			{
				String   sqlString1 = "SELECT b.file_no file_no FROM mr_pat_file_index b WHERE b.facility_id = ? AND b.file_type_code=? AND b.patient_id = ?  ";
			
			preStatement	=	connection.prepareStatement(sqlString1);
			preStatement.setString(1, facilityID);
			preStatement.setString(2, file_type_code2);
			preStatement.setString(3, patient_id);
			resultSet		=	preStatement.executeQuery();
			if(resultSet != null) 
			{
				while(resultSet.next())
				{
					fileno_nw = resultSet.getString("file_no");
				}
				}
			file_no=fileno_nw;
			file_type_code=file_type_code2;
		
				 	}
				  
				
					
				
				
				StringBuffer strBuffer		=	new StringBuffer();
				strBuffer.append("{call FM_REQUEST_FILE ('");
				strBuffer.append(facilityID);
				strBuffer.append("','");
				strBuffer.append(fs_locn_code);
				strBuffer.append("','");
				strBuffer.append(loginUser);
				strBuffer.append("','");
				strBuffer.append(file_no);
				strBuffer.append("','");
				strBuffer.append(file_type_code);
				strBuffer.append("','");
				strBuffer.append(volume_no);
				strBuffer.append("','");
				strBuffer.append(req_locn_id);
				strBuffer.append("','");
				strBuffer.append(narration_code);
				strBuffer.append("','");
				strBuffer.append(client_ip_address);
				strBuffer.append("','','");
				strBuffer.append(encounter_id);
				strBuffer.append("',?,?)}");


				callStatement = connection.prepareCall( strBuffer.toString()) ;
				callStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
				callStatement.registerOutParameter(2,java.sql.Types.VARCHAR);
				callStatement.execute() ;
				String req_no = callStatement.getString(1);						
				String perm_fs_locn = callStatement.getString(2);			
				
				
				connection.commit();
				
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(req_no));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(perm_fs_locn));
            _bw.write(_wl_block9Bytes, _wl_block9);
					
					out.println("<script>var retValue ='"+req_no+"'+'&'+'"+perm_fs_locn+"';</script>");					
					out.println("<script>parent.window.returnValue =retValue;</script>");
					
				   out.println("<script>parent.window.close(); </script>");
					
			}
			
		} else {			
			
			if(volume_status.equals("L") || curr_file_status.equals("A"))
			{ 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(volume_status));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(curr_file_status));
            _bw.write(_wl_block12Bytes, _wl_block12);

	
   		}else{
		
		//	out.println("<script>var volume_status ='"+volume_status+"'; if(volume_status=='L') {		alert(getMessage('FILE_IS_LOST','FM'));}else{parent.window.close() }; </script>");
			out.println("<script>parent.window.close() ; </script>");
			
			}
		}
		if(callStatement != null) callStatement.close();

		//out.println("<script>parent.msgFrame.location.href='../../eCommon/jsp/error.jsp'; alert(parent.msgFrame.location.href);</script>");
		out.println("<script>parent.msgFrame.location.href='../../eCommon/jsp/error.jsp'; </script>");
	}
	if(volume_no.equals(""))
	{

            _bw.write(_wl_block13Bytes, _wl_block13);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(count_reason));
            _bw.write(_wl_block18Bytes, _wl_block18);

if(file_type_appl_yn.equals("Y"))
	{

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);


			sqlString = "SELECT b.file_type_code file_type_code, a.short_desc file_type_desc, b.file_no file_no FROM mr_file_type_lang_vw a, mr_pat_file_index b WHERE a.language_id='"+locale+"' and b.facility_id = a.facility_id AND b.file_type_code = a.file_type_code AND b.facility_id = ? AND b.patient_id = ?  ";
			
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
		
			preStatement	=	connection.prepareStatement(sqlString);
			preStatement.setString(1, facilityID);
			//preStatement.setString(2, file_no);
			preStatement.setString(2, patient_id);
			resultSet		=	preStatement.executeQuery();
			if(resultSet != null) 
			{
				while(resultSet.next())
				{  
    				count_filetype++; // Senthil Added
					
					file_no_new = resultSet.getString("file_no");
					
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_type_code"))));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(checkForNull(resultSet.getString("file_type_desc"))));
            _bw.write(_wl_block24Bytes, _wl_block24);

				}
			}
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
			
            _bw.write(_wl_block25Bytes, _wl_block25);
 
	} 
	else if(file_type_appl_yn.equals("N"))
	{
			
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
			

			sqlString = "SELECT b.FS_LOCN_CODE FS_LOCN_CODE, a.short_desc fs_locn_desc,b.file_no file_no FROM FM_STORAGE_LOCN_LANG_VW a, mr_pat_file_index b WHERE a.language_id='"+locale+"' and b.facility_id = a.facility_id AND b.FS_LOCN_CODE = a.FS_LOCN_CODE AND b.facility_id = ? AND b.patient_id=? ";
			
			preStatement	=	connection.prepareStatement(sqlString);
			preStatement.setString(1, facilityID);			
			preStatement.setString(2, patient_id);
			resultSet		=	preStatement.executeQuery();
			if(resultSet != null) 
			{
				while(resultSet.next())
				{
				    count_filetype++; //  Added this CRF PMG2013-MMS-CRF-0005 [IN:045278]
				   
					file_no_new = resultSet.getString("file_no");
					
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(checkForNull(resultSet.getString("FS_LOCN_CODE"))));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(checkForNull(resultSet.getString("fs_locn_desc"))));
            _bw.write(_wl_block24Bytes, _wl_block24);

						
				}
			}
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
			
            _bw.write(_wl_block25Bytes, _wl_block25);
 
	}

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count_filetype));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count_filetype));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			sqlString = "select narration_code,short_desc from fm_narration_lang_vw where eff_status='E' and language_id='"+locale+"'order by 2";
			
			preStatement	=	connection.prepareStatement(sqlString);		
			resultSet		=	preStatement.executeQuery();
			if(resultSet != null) 
			{
				while(resultSet.next())
				{  
 				   					
					p_code = resultSet.getString("narration_code");
					p_desc = resultSet.getString("short_desc");				
				
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
		

				}
			}

			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
	
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(online_mr_notfn_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(req_locn_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(fs_locn_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(count_filetype));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(SiteSpecific_AutoFileReq));
            _bw.write(_wl_block43Bytes, _wl_block43);

	}
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();

}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.filetype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FileStorageLocation.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.VolumeNo.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReasonForBorrowing.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
