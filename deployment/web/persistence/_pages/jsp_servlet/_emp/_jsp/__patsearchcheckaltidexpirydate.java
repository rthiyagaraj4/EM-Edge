package jsp_servlet._emp._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __patsearchcheckaltidexpirydate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatSearchCheckAltIDExpiryDate.jsp", 1733374540451L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eMP/js/PatientSearch.js\"></Script>\n\t\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t<script>\n\t\tasync function showRegisterNewBorn(patientid)\n\t\t{ \n\t\t\tvar nursing_unit_code = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\tvar calling_module_id = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\tvar bed_no = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\tvar retVal =    new String();\n\t\t\tvar dialogHeight= \"95vh\" ;\n\t\t\tvar dialogWidth = \"95vw\" ;\n\t\t\tvar dialogPadding = \"10px\";;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments   = \"\" ;\n\t\t\tvar features    = \"dialogPadding:\" + dialogPadding +\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; scroll=no; status:\" + status;\t\t\n\t\t\t\t\t\n\t\t\t\t\t\tvar retVal = await top.window.showModalDialog(\"../../eMP/jsp/PaintNewbornMotherBabyLink.jsp?mother_id=\"+escape(patientid),arguments,features);\n\t\t\t\t\t\tif(retVal != null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar arr = retVal.split(\'`\');\n\t\t\t\t\t\t\tif(arr[1] == \'N\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\talert(getMessage(\"NO_MOTHER_BABY_LINKS\",\'MP\'));\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdialogHeight= \"95vh\" ;\n\t\t\t\t\t\t\t\tdialogWidth = \"95vw\" ;\n\t\t\t\t\t\t\t\tdialogPadding = \"10px\";\n\n\t\t\t\t\t\t\t\tfeatures    = \"dialogPadding:\" + dialogPadding +\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\t\t\t\t\t\t\targuments   = \"\" ;\n\t\t\t\t\t\t\t\tvar param=\"../../eMP/jsp/NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=\"+encodeURIComponent(getLabel(\"eMP.RegNewBorn.label\",\"MP\"))+\"&function_type=F&access=NNNNN&home_required_yn=N&Patient_ID=\"+escape(patientid)+\"&mother_nursing_unit=\"+nursing_unit_code+\"&mother_bed_no=\"+bed_no+\"&calling_module_id=\"+calling_module_id;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar retVal = await top.window.showModalDialog(param,arguments,features);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(arr[1] == \'Y\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdialogHeight= \"95vh\" ;\n\t\t\t\t\t\t\t\tdialogWidth = \"95vw\" ;\n\t\t\t\t\t\t\t\tdialogPadding = \"10px\";\n\n\t\t\t\t\t\t\t\tfeatures    = \"dialogPadding:\" + dialogPadding +\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\t\t\t\t\t\t\targuments   = \"\" ;\n\t\t\t\t\t\t\t\tvar param=\"../../eMP/jsp/NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NNNNN&home_required_yn=N&Patient_ID=\"+escape(patientid)+\"&mother_nursing_unit=\"+nursing_unit_code+\"&mother_bed_no=\"+bed_no+\"&calling_module_id=\"+calling_module_id;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar retVal = await top.window.showModalDialog(param,arguments,features);\n\t\t\t\t\t\t\t\t//var retVal = window.open(param,arguments,features);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t}\n\t\t\n\t\tasync function returnPatient(pat,flag) \n\t\t{\n\t\t\t/* Code Added by Vedesh A D for Edge Conversion */\n\t\t\tvar dialogTagFrame = \"\";\n\t\t\tvar dialogBodyFrame = \"\";\n\t\t\tconst diagElement = top.document.getElementsByTagName(\"dialog\");\n            var i = 0; var j = 0;\n            for (i = 0; i < diagElement.length; i++) \n    \t\t{\n            \tfor (j = 0; j < diagElement[i].children.length; j++) \n\t\t\t\t{\n            \t\tvar element = diagElement[i].children[j];\n            \t\tlet dialogSrc = element.src;\n            \t\tif (typeof dialogSrc !== \"undefined\")\n            \t\t{ \n        \t    \t\tif (dialogSrc.includes(\"ModelPatientSearch.jsp\") )\n        \t        \t{\n        \t    \t\t\tdialogTagFrame = diagElement[i];\n        \t    \t\t\tdialogBodyFrame = element;\n        \t        \t}\n            \t\t}    \t\t\n            \t} \n            }\n            \n            if(dialogTagFrame == undefined && dialogBodyFrame == undefined){\n            \tdialogTagFrame = parent.parent.document.getElementById(\'dialog_tag\');\n            \tdialogBodyFrame = parent.parent.document.getElementById(\'dialog-body\');\n            }\n            /* end */\n            \n\t\t\t\n\t\t\tif(flag == \'false\')\n\t\t\t{\n\t\t\t\t//var desc = parent.parent.frames[1].document.forms[0].jsp_name.value;\n\t\t\t\tvar desc = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;\n\t\t\t\tvar chk = desc.indexOf(\"?\");\n\t\t\t\tvar url_to_pass = \"\";\n\t\t\t\t\n\t\t\t\tif ((chk == -1)) url_to_pass =\'?\';\n\t\t\t\telse url_to_pass =\'&\';\n\t\t\t\t\n\t\t\t\t//var window_styl =   parent.frames[1].document.forms[0].window_styl.value;\n\t\t\t\tvar window_styl =   dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;\n\t\t\t\t//var close_yn    =   parent.frames[1].document.forms[0].close_yn.value;\n\t\t\t\tvar close_yn    =  dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;\n\t\t\t\tif(desc == null || desc.length == 0)\n\t\t\t\t{\n\t\t\t\t\tdialogBodyFrame.contentWindow.returnValue = escape(pat);\n\t\t\t\t\tdialogTagFrame.close();\n\t\t\t\t\t//parent.returnValue = escape(pat);\n\t\t\t\t\t//parent.close();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(window_styl == \'N\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar url = desc+url_to_pass+\"Patient_Id=\" + escapse(pat);\n\t\t\t\t\t\tif(close_yn == \'Y\') dialogTagFrame.close();\n\t\t\t\t\t\t//parent.close();\n\t\t\t\t\t\tparent.location.href=url;\n\t\t\t\t\t}\n\t\t\t\t\tif(window_styl == \'O\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar url = desc+url_to_pass+\"Patient_Id=\" + escape(pat);\n\t\t\t\t\t\tvar dialogTop       = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t\t\tvar dialogHeight    = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' ;\n\t\t\t\t\t\tvar dialogWidth     = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ;\n\t\t\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no\" ;\n\t\t\t\t\t\tvar returnval = await window.showModalDialog( url, arguments, features ) ;\n\t\t\t\t\t\t//parent.location.href=url;\n\t\t\t\t\t\tif(close_yn == \'Y\') dialogTagFrame.close();  //parent.close();\n\t\t\t\t\t\treturn returnval;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar desc = \"\";\n\t\t\t\tvar window_styl = \"\";\n\t\t\t\tvar close_yn    = \"\";\n\t\t\t\t\n\t\t\t\tif (parent.Pat_Search_Tabs_Frame)\n\t\t\t\t{\n\t\t\t\t\tif (parent.Pat_Search_Tabs_Frame.document.getElementById(\"tab_id_clicked\").value == \"AdvanceTab\"){\t\t\t\t\t\t \n\t\t\t\t\t\t//desc = parent.parent.document.getElementById(\'dialog-body\').contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;\n\t\t\t\t\t\t//window_styl = parent.parent.document.getElementById(\'dialog-body\').contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;\n\t\t\t\t\t\t//close_yn    = parent.parent.document.getElementById(\'dialog-body\').contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;\n\t\t\t\t\t\n\t\t\t\t\t\tdesc = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;\n\t\t\t\t\t\twindow_styl = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;\n\t\t\t\t\t\tclose_yn    = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\t if (parent.Pat_Search_Tabs_Frame.document.getElementById(\"tab_id_clicked\").value == \"BasicTab\"){\t\t\t\t\t\t\t \n\t\t\t\t\t\t\tdesc = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;\n\t\t\t\t\t\t\twindow_styl = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;\n\t\t\t\t\t\t\tclose_yn    = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;\n\t\t\t\t\t\t }\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdesc = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;\n\t\t\t\t\twindow_styl = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;\n\t\t\t\t\tclose_yn    = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;\n\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t//var desc = parent.parent.frames[1].document.forms[0].jsp_name.value;\n\t\t\t\t//var desc = parent.parent.document.getElementById(\'dialog-body\').contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;\n\t\t\t\t\n\t\t\t\tvar chk = desc.indexOf(\"?\");\n\t\t\t\tvar url_to_pass = \"\";\n\n\t\t\t\tif((chk == -1)) url_to_pass = \'?\';\n\t\t\t\telse url_to_pass =\'&\';\n\t\t\t\t\n\t\t\t\t//var window_styl = parent.frames[1].document.forms[0].window_styl.value;\n\t\t\t\t//var close_yn    = parent.frames[1].document.forms[0].close_yn.value;\n\t\t\t\t\n\t\t\t\t//var window_styl = parent.parent.document.getElementById(\'dialog-body\').contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;\n\t\t\t\t//var close_yn    = parent.parent.document.getElementById(\'dialog-body\').contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;\n\t\t\t\t\n\t\t\t\tif(desc == null || desc.length == 0)\n\t\t\t\t{\t\n\t\t\t\t\t/*\n\t\t\t\t\tparent.returnValue = escape(pat);\n\t\t\t\t\tparent.close();\n\t\t\t\t\t*/\n\t\t\t\t\t\n\t\t\t\t\tif (parent.Pat_Search_Tabs_Frame)\n\t\t\t\t\t{\n\t\t\t\t\t\tif (parent.Pat_Search_Tabs_Frame.document.getElementById(\"tab_id_clicked\").value == \"AdvanceTab\"){\t\n\t\t\t\t\t\t\tdialogBodyFrame.contentWindow.returnValue = pat;\n\t\t\t\t\t\t\tdialogTagFrame.close();\n\t\t\t\t\t\t\t/* let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\t\t\t    dialogBody.contentWindow.returnValue = pat;\n\t\t\t\t\t\t    \n\t\t\t\t\t\t    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");  \n\t\t\t\t\t\t    dialogTag.close();  */\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdialogBodyFrame.contentWindow.returnValue = pat;\n\t\t\t\t\t\t\tdialogTagFrame.close(); \n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdialogBodyFrame.contentWindow.returnValue = pat;\n\t\t\t\t\t\tdialogTagFrame.close();\n\t\t\t\t\t}\n\t\t\t\t\t \n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(window_styl == \'N\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar url = desc+url_to_pass+\"Patient_Id=\" + escape(pat);\n\t\t\t\t\t\tif(close_yn == \'Y\') dialogTagFrame.close();\n\t\t\t\t\t\t//parent.close();\n\t\t\t\t\t\tparent.location.href=url;\n\t\t\t\t\t}\n\t\t\t\t\tif(window_styl == \'O\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar url = desc+url_to_pass+\"Patient_Id=\" + escape(pat);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar dialogTop       = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ;\n\t\t\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no\" ;\n\t\t\t\t\t\tvar returnval = await window.showModalDialog( url, arguments, features ) ;\n\n\t\t\t\t\t\tif (close_yn == \'Y\') dialogTagFrame.close();\n\t\t\t\t\t\t//parent.close();\n\n\t\t\t\t\t\treturn returnval;\n\t\t\t\t   }\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tasync function aa(flag)\n\t\t{\n\t\t\t\n\t\t\t/* Code Added by Vedesh A D for Edge Conversion */\n\t\t\tvar dialogTagFrame = \"\";\n\t\t\tvar dialogBodyFrame = \"\";\n\t\t\tconst diagElement = top.document.getElementsByTagName(\"dialog\");\n            var i = 0; var j = 0;\n            for (i = 0; i < diagElement.length; i++) \n    \t\t{\n            \tfor (j = 0; j < diagElement[i].children.length; j++) \n\t\t\t\t{\n            \t\tvar element = diagElement[i].children[j];\n            \t\tlet dialogSrc = element.src;\n            \t\tif (typeof dialogSrc !== \"undefined\")\n            \t\t{ \n        \t    \t\tif (dialogSrc.includes(\"ModelPatientSearch.jsp\") )\n        \t        \t{\n        \t    \t\t\tdialogTagFrame = diagElement[i];\n        \t    \t\t\tdialogBodyFrame = element;\n        \t        \t}\n            \t\t}    \t\t\n            \t} \n            }\n            \n            if(dialogTagFrame == undefined && dialogBodyFrame == undefined){\n            \tdialogTagFrame = parent.parent.document.getElementById(\'dialog_tag\');\n            \tdialogBodyFrame = parent.parent.document.getElementById(\'dialog-body\');\n            }\n            /* end */\n            \n\t\t\tif(flag==\'false\')\n\t\t\t{\n\t\t\t\tvar hyp_yn = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\t\tif(!(hyp_yn == null || hyp_yn.length == 0 ))\n\t\t\t\t{\n\t\t\t\t\tvar chk = hyp_yn.indexOf(\"?\");\n\t\t\t\t\tvar url_to_pass = \"\";\n\t\t\t\t\t\n\t\t\t\t\tif((chk == -1)) url_to_pass = \'?\';\n\t\t\t\t\telse url_to_pass =\'&\';\n\t\t\t\t\n\t\t\t\t\tvar p_desc          =   parent.frames[1].document.getElementById(\'jsp_name\').value;\n\t\t\t\t\tvar p_window_styl   =   parent.frames[1].document.getElementById(\'window_styl\').value;\n\t\t\t\t\tvar p_close_yn      =   parent.frames[1].document.getElementById(\'close_yn\').value;\n\n\t\t\t\t\tif(p_window_styl == \'N\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar url = p_desc+url_to_pass+\"Patient_Id=\"+escape(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\");\n\t\t\t\t\t\tif(p_close_yn == \'Y\') dialogTagFrame.close(); //parent.close();\n\t\t\t\t\t\tparent.location.href=url;\n\t\t\t\t\t}\n\t\t\t\t\tif(p_window_styl == \'O\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar url = p_desc+url_to_pass+\"Patient_Id=\"+escape(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\");\n\t\t\t\t\t\tvar dialogTop       = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"               //\"61\";\n\t\t\t\t\t\tvar dialogHeight    = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"            //\"34\" ;\n\t\t\t\t\t\tvar dialogWidth     = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"             //\"50\" ;\n\t\t\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no \";\n\t\t\t\t\t\tvar returnval = await window.showModalDialog( url, arguments, features ) ;\n\n\t\t\t\t\t\tif(p_close_yn == \'Y\') //parent.close();\n\t\t\t\t\t\t\tdialogTagFrame.close();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdialogBodyFrame.contentWindow.returnValue = escape(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\") ;\n\t\t\t\t\tdialogTagFrame.close();\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\t\t\t\n\t\t\t{\n\t\t\t\tvar hyp_yn = \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\t\t\t\tif(!(hyp_yn == null || hyp_yn.length == 0))\n\t\t\t\t{\n\t\t\t\t\tvar chk = hyp_yn.indexOf(\"?\");\n\t\t\t\t\tvar url_to_pass = \"\";\n\t\t\t\t\t\n\t\t\t\t\tif((chk == -1))\turl_to_pass = \'?\';\n\t\t\t\t\telse url_to_pass = \'&\';\n\t\t\t\t\t\n\t\t\t\t\tvar p_desc          =   parent.frames[1].document.getElementById(\'jsp_name\').value;\n\t\t\t\t\tvar p_window_styl   =   parent.frames[1].document.getElementById(\'window_styl\').value;\n\t\t\t\t\tvar p_close_yn      =   parent.frames[1].document.getElementById(\'close_yn\').value;\n\t\t\t\t\tif(p_window_styl == \'N\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar url = p_desc+url_to_pass+\"Patient_Id=\"+escape(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\");\n\t\t\t\t\t\tif(p_close_yn == \'Y\') dialogTagFrame.close();\n\t\t\t\t\t\tparent.location.href=url;\n\t\t\t\t\t}\n\t\t\t\t\tif(p_window_styl == \'O\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar url\t\t\t\t= p_desc+url_to_pass+\"Patient_Id=\"+escape(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\");\n\t\t\t\t\t\tvar dialogTop\t\t= \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"    //\"61\";\n\t\t\t\t\t\tvar dialogHeight\t= \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" //\"34\";\n\t\t\t\t\t\tvar dialogWidth\t\t= \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  //\"50\";\n\t\t\t\t\t\tvar arguments\t\t= \"\" ;\n\t\t\t\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no \";\n\t\t\t\t\t\tvar returnval\t\t= await window.showModalDialog( url, arguments, features ) ;\n\n\t\t\t\t\t\tif(p_close_yn == \'Y\') //parent.close();\n\t\t\t\t\t\t\tdialogTagFrame.close();  \n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(dialogBodyFrame)\n\t\t\t\t\t{\n\t\t\t\t\t\tdialogBodyFrame.contentWindow.returnValue = escape(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\") ;\n\t\t\t\t\t\tdialogTagFrame.close();\n\t\t\t\t\t}\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n</head>\n<body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar msg = getMessage(\"ALT_ID_EXPIRED\",\'MP\'); \n\t\t\t\t\t\t\tmsg = msg.replace(\'$\', \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"); \n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar msg = getMessage(\"ALT_ID_EXP_WITH_GRACE\",\'MP\'); \n\t\t\t\t\t\t\tmsg = msg.replace(\'$\', \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"); \n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\");\n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t       <script>\n\t\t\t\t\t\t\tvar msg = getMessage(\"ALT_ID_EXP_WITH_GRACE\",\'MP\'); \n\t\t\t\t\t\t\tmsg = msg.replace(\'$\', \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar msg = getMessage(\"ALT_ID_EXPIRED\",\'MP\');\n\t\t\t\t\t\t\tmsg = msg.replace(\'$\', \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t            <script>\n\t\t\t\t\t\t\tvar msg = getMessage(\"ALT_ID_EXP_WITH_GRACE\",\'MP\'); \n\t\t\t\t\t\t\tmsg = msg.replace(\'$\', \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t        <script>\n\t\t\t\t\t\t\tvar msg = getMessage(\"ALT_ID_EXP_WITH_GRACE\",\'MP\');\n\t\t\t\t\t\t\tmsg = msg.replace(\'$\', \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar msg = getMessage(\"ALT_ID_EXP_WITHIN\",\'MP\'); \n\t\t\t\t\t\t\t\tmsg = msg.replace(\'$\',\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"); \n\t\t\t\t\t\t\t\tvar alt_days = ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =";\n\t\t\t\t\t\t\t\tvar p_alt_id1_diff_days = ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =";\n\n\t\t\t\t\t\t\t\talt_days = alt_days-";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =";\n\t\t\t\t\t\t\t\talert(msg+\' \'+p_alt_id1_diff_days+\' days\');\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =";\n\t\t\t\t\t\t\t\tvar p_alt_id2_diff_days = ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =";\n\t\t\t\t\t\t\t\talt_days = alt_days-";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =";\n\t\t\t\t\t\t\t\talert(msg+\' \'+p_alt_id2_diff_days+\' days\');\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =";\n\t\t\t\t\t\t\t\tvar p_alt_id3_diff_days = ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =";\n\t\t\t\t\t\t\t\talert(msg+\' \'+p_alt_id3_diff_days+\' days\');\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =";\n\t\t\t\t\t\t\t\tvar p_alt_id4_diff_days = ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =";\n\t\t\t\t\t\t\t\talert(msg+\' \'+p_alt_id4_diff_days+\' days\');\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t<script>\n\t\t\t\tvar cflag  = \'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\';\n\t\t\t\tvar cflag1 = \'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\';\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' != \'PAT_REG\'){\n\t\t\t\t\tif(cflag == \"false\"){\n\t\t\t\t\t\taa(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');\n\t\t\t\t\t}else if(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' == \'F\'){\t\n\t\t\t\t\t\tif(cflag1 == \"false\"){\t\t\n\t\t\t\t\t\t\talert(getMessage(\"MOTHER_AGE_PARAM\",\'MP\'));\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<script>\n\t\t\t\tvar cflag = \'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' != \'PAT_REG\'){\n\t\t\t\t\tif(cflag==\"false\"){\n\t\t\t\t\t\treturnPatient(\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\",\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' == \'F\'){\n\t\t\t\t\t\tif(cflag1 == \"false\"){\t\t\t\t\t\n\t\t\t\t\t\t\talert(getMessage(\"MOTHER_AGE_PARAM\",\'MP\'));\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n</body>\n</html> \n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
Connection conn					= null;
PreparedStatement pstmt			= null;
//PreparedStatement caPstmt		= null;
PreparedStatement pstmt7		= null;
PreparedStatement pstmt8		= null;
//PreparedStatement pstmt_chk_age = null;
//PreparedStatement pstmtSex		= null;
//PreparedStatement pstmtGest1	= null;
//PreparedStatement pstmtTEMP		= null;
ResultSet rsGest				= null;
//ResultSet rsGest1				= null;
//ResultSet rsTEMP				= null;
ResultSet rs					= null;
//ResultSet rs_chk_age			= null;
//ResultSet rs_sex				= null;
ResultSet rs7					= null;
ResultSet rs8					= null;
//ResultSet caRS					= null;
CallableStatement cstmt			=null;

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String alt_id1_exp_warn_yn			= "";
String alt_id2_exp_warn_yn			= "";
String alt_id3_exp_warn_yn			= "";
String alt_id4_exp_warn_yn			= "";
String alt_id1_adv_alert_reqd_yn	= "";
String alt_id2_adv_alert_reqd_yn	= "";
String alt_id3_adv_alert_reqd_yn	= "";
String alt_id4_adv_alert_reqd_yn	= "";
String sex_det						= ""; 
String p_alt_id1_type				= "";
String p_alt_id2_type				= "";
String p_alt_id3_type				= "";
String p_alt_id4_type				= "";
String multiple_birth_yn			= "";
String sub_multi_birth_hw			= "";
String age_flag						= "false";
String age_flag1					= "false";
String flag							= "true";

String jsp_name				= request.getParameter("jsp_name"); 
String retback				= request.getParameter("flag"); 
String func					= request.getParameter("func_id") == null?"":request.getParameter("func_id");

String sflag				= request.getParameter("sflag"); 
String nursing_unit_code	= request.getParameter("nursing_unit_code") == null ? "" : request.getParameter("nursing_unit_code");
String bed_no				= request.getParameter("bed_no") == null ? "" : request.getParameter("bed_no");
String IPValue				= request.getParameter("IPValue"); 

String pat_id				= request.getParameter("pat_id"); 
pat_id = java.net.URLDecoder.decode(pat_id);
String win_top				= request.getParameter("win_top");
String win_width			= request.getParameter("win_width");
String win_height			= request.getParameter("win_height");
String func_idpassed		= request.getParameter("func_idpassed") == null ? "" : request.getParameter("func_idpassed");
String function_id			= request.getParameter("function_id")== null ?"":request.getParameter("function_id");
String calling_module_id	= request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");


//session.setAttribute("Special_case","N");  // added on 14th Oct 2009

if(jsp_name == null) jsp_name = "";
if(retback == null) retback = "";
if(func == null) func = "";
if(sflag == null) sflag = "";
if(IPValue == null) IPValue = "";
if(pat_id == null) pat_id = "";
if(function_id == null) function_id = "";

int alt_id1_exp_grace_days	= 0;
int alt_id2_exp_grace_days	= 0;
int alt_id3_exp_grace_days	= 0;
int alt_id4_exp_grace_days	= 0;
int alt_id1_adv_alert_days	= 0;
int alt_id2_adv_alert_days	= 0;
int alt_id3_adv_alert_days	= 0;
int alt_id4_adv_alert_days	= 0;
int p_adv_diff_days			= 0;
int min_age					= 0;
int min_age1				= 0;
int min_age2				= 0;
int mother_min_age			= 0;
int last_nb_order			= 0;
int no_of_births			= 0;
int father_age				= 0;
int father_min_age			= 0;
int mother_max_age			= 0;
int mother_cutoff_age		= 0;
int p_alt_id1_diff_days		= 0;
int p_alt_id2_diff_days		= 0;
int p_alt_id3_diff_days		= 0;
int p_alt_id4_diff_days		= 0;

double MAX_MULTIPLE_BIRTH_REGN_HRS	= 0.0;
double diffWeeks = 0.0;
double diffDays = 0.0;
double diffHours = 0.0;

//double temp1 = 0.0;
double min_gest_bet_del			= 0.0;
double min_gest_bet_del_days	= 0.0;

java.util.Date current_date	= null;
java.util.Date p_alt_id1_exp_date = null, p_alt_id1_total_exp_date = null;
java.util.Date p_alt_id2_exp_date = null, p_alt_id2_total_exp_date = null;
java.util.Date p_alt_id3_exp_date = null, p_alt_id3_total_exp_date = null;
java.util.Date p_alt_id4_exp_date = null, p_alt_id4_total_exp_date = null;
session.removeValue("mc_cycle_number");//clearing value from session 


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(win_top));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(win_top));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(win_top));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(win_top));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            _bw.write(_wl_block30Bytes, _wl_block30);


	String CountNo = "0"; 

	String expsql = "SELECT alt_id1_exp_warn_yn, alt_id1_exp_grace_days, alt_id2_exp_warn_yn, alt_id2_exp_grace_days, alt_id3_exp_warn_yn, alt_id3_exp_grace_days, alt_id4_exp_warn_yn, alt_id4_exp_grace_days, sysdate, alt_id1_adv_alert_reqd_yn, alt_id1_adv_alert_days, alt_id2_adv_alert_reqd_yn, alt_id2_adv_alert_days, alt_id3_adv_alert_reqd_yn, alt_id3_adv_alert_days, alt_id4_adv_alert_reqd_yn, alt_id4_adv_alert_days, NB_MOTHER_MIN_AGE, NB_MOTHER_UPPER_AGE, NB_MOTHER_CUTOFF_AGE, NB_MIN_GEST_BET_2_DELY, NB_FATHER_MIN_AGE, MAX_MULTIPLE_BIRTH_REGN_HRS,sub_multi_birth_hw, (select count(module_id) from sm_module where module_id='MC' and install_yn='Y') countNo FROM mp_param where module_id='MP'";

	try{
		conn = ConnectionManager.getConnection(request);
		pstmt8 = conn.prepareStatement(expsql);
		rs8=pstmt8.executeQuery();    
		if (rs8.next()) {

			alt_id1_exp_warn_yn			= rs8.getString(1);
			alt_id1_exp_grace_days		= rs8.getInt(2);
			alt_id2_exp_warn_yn			= rs8.getString(3);
			alt_id2_exp_grace_days		= rs8.getInt(4);
			alt_id3_exp_warn_yn			= rs8.getString(5);
			alt_id3_exp_grace_days		= rs8.getInt(6);
			alt_id4_exp_warn_yn			= rs8.getString(7);
			alt_id4_exp_grace_days		= rs8.getInt(8);
			current_date				= rs8.getDate(9);
			alt_id1_adv_alert_reqd_yn	= rs8.getString(10);
			alt_id1_adv_alert_days		= rs8.getInt(11);
			alt_id2_adv_alert_reqd_yn	= rs8.getString(12);
			alt_id2_adv_alert_days		= rs8.getInt(13);
			alt_id3_adv_alert_reqd_yn	= rs8.getString(14);
			alt_id3_adv_alert_days		= rs8.getInt(15);
			alt_id4_adv_alert_reqd_yn	= rs8.getString(16);
			alt_id4_adv_alert_days		= rs8.getInt(17);

			mother_min_age				= rs8.getInt("NB_MOTHER_MIN_AGE"); 	
			mother_max_age				= rs8.getInt("NB_MOTHER_UPPER_AGE"); 
			mother_cutoff_age			= rs8.getInt("NB_MOTHER_CUTOFF_AGE");
			min_gest_bet_del			= rs8.getDouble("NB_MIN_GEST_BET_2_DELY");
			MAX_MULTIPLE_BIRTH_REGN_HRS	= rs8.getDouble("MAX_MULTIPLE_BIRTH_REGN_HRS");
			sub_multi_birth_hw = rs8.getString("sub_multi_birth_hw");
			CountNo = rs8.getString("countNo")==null?"0":rs8.getString("countNo");
			father_min_age = rs8.getInt("NB_FATHER_MIN_AGE");

			if(alt_id1_exp_warn_yn == null) alt_id1_exp_warn_yn = "";    
			if(alt_id2_exp_warn_yn == null) alt_id2_exp_warn_yn = "";        
			if(alt_id3_exp_warn_yn == null) alt_id3_exp_warn_yn = "";        
			if(alt_id4_exp_warn_yn == null) alt_id4_exp_warn_yn = "";        
			if(alt_id1_adv_alert_reqd_yn == null) alt_id1_adv_alert_reqd_yn = "";
			if(alt_id2_adv_alert_reqd_yn == null) alt_id2_adv_alert_reqd_yn = "";
			if(alt_id3_adv_alert_reqd_yn == null) alt_id3_adv_alert_reqd_yn = "";
			if(alt_id4_adv_alert_reqd_yn == null) alt_id4_adv_alert_reqd_yn = "";
			if(sub_multi_birth_hw == null) sub_multi_birth_hw = "";

			/*
			if(alt_id1_adv_alert_days == null) alt_id1_adv_alert_days = 0;
			if(alt_id2_adv_alert_days == null) alt_id2_adv_alert_days = 0;
			if(alt_id3_adv_alert_days == null) alt_id3_adv_alert_days = 0;
			if(alt_id4_adv_alert_days == null) alt_id4_adv_alert_days = 0;

			if(mother_min_age == null) mother_min_age = 0;
			if(father_min_age == null) father_min_age = 0;
			if(mother_max_age == null) mother_max_age = 0;
			if(mother_cutoff_age == null) mother_cutoff_age = 0;
			if(min_gest_bet_del == null) min_gest_bet_del = 0.0;
			if(MAX_MULTIPLE_BIRTH_REGN_HRS == null) MAX_MULTIPLE_BIRTH_REGN_HRS = 0.0;
			*/
		}

		if(pstmt8 != null) pstmt8.close();
		if(rs8!=null) rs8.close();

		String psql="SELECT TRUNC(ALT_ID1_EXP_DATE), TRUNC(ALT_ID2_EXP_DATE), TRUNC(ALT_ID3_EXP_DATE), TRUNC(ALT_ID4_EXP_DATE), ABS(TRUNC(ALT_ID1_EXP_DATE)-TRUNC(SYSDATE)), ABS(TRUNC(ALT_ID2_EXP_DATE)-TRUNC(SYSDATE)), ABS(TRUNC(ALT_ID3_EXP_DATE)-TRUNC(SYSDATE)),  ABS(TRUNC(ALT_ID4_EXP_DATE)-TRUNC(SYSDATE)), calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'), 1),  TRUNC(SYSDATE)-TRUNC(regn_date),(CASE WHEN alt_id1_no IS NOT NULL THEN 	    MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id1_type,?,1) END) alt_id1_type, (CASE WHEN alt_id2_no IS NOT NULL THEN MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id2_type,?,1) END) alt_id2_type, (CASE WHEN alt_id3_no IS NOT NULL THEN  MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id3_type,?,1) END) alt_id3_type, (CASE WHEN alt_id4_no IS NOT NULL THEN MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id4_type,?,1) END)   alt_id4_type,calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'), 2),   calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'), 3), sex FROM mp_patient  WHERE patient_id = ?";

		try{
			pstmt7 = conn.prepareStatement(psql);
			pstmt7.setString(1,locale);
			pstmt7.setString(2,locale);
			pstmt7.setString(3,locale);
			pstmt7.setString(4,locale);
			pstmt7.setString(5,pat_id);
			rs7 = pstmt7.executeQuery();
			if(rs7.next()){
				p_alt_id1_exp_date	= rs7.getDate(1);
				p_alt_id2_exp_date	= rs7.getDate(2);
				p_alt_id3_exp_date	= rs7.getDate(3);
				p_alt_id4_exp_date	= rs7.getDate(4);
				p_alt_id1_diff_days	= rs7.getInt(5);
				p_alt_id2_diff_days = rs7.getInt(6);
				p_alt_id3_diff_days = rs7.getInt(7);
				p_alt_id4_diff_days = rs7.getInt(8);
				min_age				= rs7.getInt(9);
				father_age			= rs7.getInt(9);
				p_adv_diff_days		= rs7.getInt(10);
				p_alt_id1_type		= rs7.getString(11);
				p_alt_id2_type		= rs7.getString(12);
				p_alt_id3_type		= rs7.getString(13);
				p_alt_id4_type		= rs7.getString(14);
				min_age1			= rs7.getInt(15);
				min_age2			= rs7.getInt(16);				
				sex_det			= rs7.getString("sex") == null?"":rs7.getString("sex");				
			}
	    }catch(Exception e) { 
			e.printStackTrace();
		}finally{
			if (pstmt7 != null) pstmt7.close();
	        if (rs7 != null) rs7.close();
		}
		if(alt_id1_exp_warn_yn.equals("Y")){
			if(p_alt_id1_exp_date != null){
				p_alt_id1_total_exp_date=new java.util.Date(p_alt_id1_exp_date.getTime());
				p_alt_id1_total_exp_date.setDate(p_alt_id1_exp_date.getDate()+alt_id1_exp_grace_days);  
				if((p_alt_id1_exp_date.compareTo(current_date))< 0){
				    if((p_alt_id1_total_exp_date.compareTo(current_date))< 0){
						flag="false"; 
					
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_alt_id1_type));
            _bw.write(_wl_block32Bytes, _wl_block32);

					}
					else
					{
						
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_alt_id1_type));
            _bw.write(_wl_block34Bytes, _wl_block34);

					}
				}
			}
		}
		if(alt_id2_exp_warn_yn.equals("Y"))
		{
		   if(p_alt_id2_exp_date != null)
		   {
				p_alt_id2_total_exp_date=new java.util.Date(p_alt_id2_exp_date.getTime());
				p_alt_id2_total_exp_date.setDate(p_alt_id2_exp_date.getDate()+alt_id2_exp_grace_days);  
				if((p_alt_id2_exp_date.compareTo(current_date))< 0)
				{
					if((p_alt_id2_total_exp_date.compareTo(current_date))< 0)
					{
						flag="false";
						
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_alt_id2_type));
            _bw.write(_wl_block35Bytes, _wl_block35);

					}
			        else
					{
					   
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(p_alt_id2_type));
            _bw.write(_wl_block34Bytes, _wl_block34);

					}  
				}
			}
		}
		if(alt_id3_exp_warn_yn.equals("Y"))
		{
			if(p_alt_id3_exp_date != null)
			{
			    p_alt_id3_total_exp_date=new java.util.Date(p_alt_id3_exp_date.getTime());
				p_alt_id3_total_exp_date.setDate(p_alt_id3_exp_date.getDate()+alt_id3_exp_grace_days);  
				if((p_alt_id3_exp_date.compareTo(current_date))< 0)
				{
			       if((p_alt_id3_total_exp_date.compareTo(current_date))< 0)
					{
						flag = "false";
						
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(p_alt_id3_type));
            _bw.write(_wl_block34Bytes, _wl_block34);

					}
					else
					{
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(p_alt_id3_type));
            _bw.write(_wl_block34Bytes, _wl_block34);

					}  
				}
			}
		}
		if(alt_id4_exp_warn_yn.equals("Y"))
		{
		   if(p_alt_id4_exp_date != null)
			{
				p_alt_id4_total_exp_date = new java.util.Date(p_alt_id4_exp_date.getTime());
				p_alt_id4_total_exp_date.setDate(p_alt_id4_exp_date.getDate()+alt_id4_exp_grace_days);  if((p_alt_id4_exp_date.compareTo(current_date))< 0)
				{
				    if((p_alt_id4_total_exp_date.compareTo(current_date))< 0)
					{
						flag = "false";
						
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_alt_id4_type));
            _bw.write(_wl_block34Bytes, _wl_block34);

					}
					else
					{
						
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(p_alt_id4_type));
            _bw.write(_wl_block34Bytes, _wl_block34);

					}  
				}
			}
		}
		if(alt_id1_adv_alert_reqd_yn.equals("Y"))
		{    
			if(p_alt_id1_exp_date != null)
			{
				if((p_alt_id1_exp_date.compareTo(current_date))> 0)
				{
					if(p_alt_id1_diff_days > 0) 
					{
						if( p_alt_id1_diff_days <= alt_id1_adv_alert_days)
						{
							
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(p_alt_id1_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id1_adv_alert_days));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(p_alt_id1_diff_days));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(p_adv_diff_days));
            _bw.write(_wl_block44Bytes, _wl_block44);

						}
					}
				}
			}
		}
		if(alt_id2_adv_alert_reqd_yn.equals("Y"))
		{
			if(p_alt_id2_exp_date != null)
			{
				if((p_alt_id2_exp_date.compareTo(current_date))> 0)
				{
					if(p_alt_id2_diff_days > 0) 
					{
						if(p_alt_id2_diff_days <= alt_id2_adv_alert_days)
						{
							
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(p_alt_id2_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id2_adv_alert_days));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(p_alt_id2_diff_days));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(p_adv_diff_days));
            _bw.write(_wl_block47Bytes, _wl_block47);

						}
					}
				}
			}
		}
		if(alt_id3_adv_alert_reqd_yn.equals("Y"))
		{
			if(p_alt_id3_exp_date != null)
			{                 
				if((p_alt_id3_exp_date.compareTo(current_date))> 0)
				{
					if(p_alt_id3_diff_days > 0) 
					{
						if(p_alt_id3_diff_days <= alt_id3_adv_alert_days)
						{
							
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(p_alt_id3_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id3_adv_alert_days));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(p_alt_id3_diff_days));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(p_adv_diff_days));
            _bw.write(_wl_block49Bytes, _wl_block49);

						}
					}
				}
			}
		}
		if(alt_id4_adv_alert_reqd_yn.equals("Y"))
		{
			if(p_alt_id4_exp_date != null)
			{
				if((p_alt_id4_exp_date.compareTo(current_date)) > 0)
				{
					if(p_alt_id4_diff_days > 0) 
					{
						if(p_alt_id4_diff_days <= alt_id4_adv_alert_days)
						{
							
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(p_alt_id4_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alt_id4_adv_alert_days));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(p_alt_id4_diff_days));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(p_adv_diff_days));
            _bw.write(_wl_block51Bytes, _wl_block51);

						}
					}
				}
			}
		}
		if(!func_idpassed.equals("MP_VIEW_BIRTH_REG")&&!func_idpassed.equals("MP_MAIN_NB_REG")){
			if(func.equals("NEWBORN_REG")){  
				try{
					/*
					pstmtSex=conn.prepareStatement("SELECT SEX FROM MP_PATIENT WHERE PATIENT_ID='"+pat_id+"'");
					rs_sex=pstmtSex.executeQuery();
					if(rs_sex.next()){
						sex_det = rs_sex.getString(1);
					}
					if(pstmtSex != null) pstmtSex.close();
					if(rs_sex != null) rs_sex.close();
					*/

					if(sex_det.equals("F")){
						//pstmt_chk_age = conn.prepareStatement("SELECT alt_id1_exp_warn_yn, alt_id1_exp_grace_days, alt_id2_exp_warn_yn, alt_id2_exp_grace_days, alt_id3_exp_warn_yn, alt_id3_exp_grace_days, alt_id4_exp_warn_yn, alt_id4_exp_grace_days,sysdate, alt_id1_adv_alert_reqd_yn, nvl(alt_id1_adv_alert_days,0) alt_id1_adv_alert_days, alt_id2_adv_alert_reqd_yn, nvl(alt_id2_adv_alert_days, 0) alt_id2_adv_alert_days, alt_id3_adv_alert_reqd_yn, nvl(alt_id3_adv_alert_days, 0) alt_id3_adv_alert_days, alt_id4_adv_alert_reqd_yn, nvl(alt_id4_adv_alert_days, 0) alt_id4_adv_alert_days, nvl(NB_MOTHER_MIN_AGE,0) NB_MOTHER_MIN_AGE, nvl(NB_MOTHER_UPPER_AGE,0) NB_MOTHER_UPPER_AGE, nvl(NB_MOTHER_CUTOFF_AGE,0) NB_MOTHER_CUTOFF_AGE, NB_MIN_GEST_BET_2_DELY, UNIT_OF_GEST_NB, nvl(NB_FATHER_MIN_AGE,0) NB_FATHER_MIN_AGE, MAX_MULTIPLE_BIRTH_REGN_HRS FROM mp_param where module_id='MP'"); 						
						try{
							if(func!=null & func.equals("NEWBORN_REG")){
								/*
								String mcModuleSQL="select count(module_id) countNo from sm_module where module_id='MC' and install_yn='Y'";
								pstmt=conn.prepareStatement(mcModuleSQL);
								rs=pstmt.executeQuery();
								if(rs!=null && rs.next()){
								*/
									//String CountNo=rs.getString("countNo");
									if(CountNo.equals("1")) {
										cstmt=conn.prepareCall("{call MP_VALIDATE_NB_REG( ?,?,?)}");
										cstmt.setString(1,pat_id);
										cstmt.registerOutParameter(2,java.sql.Types.INTEGER);
										cstmt.registerOutParameter(3,java.sql.Types.VARCHAR) ;
										cstmt.execute() ;
										int mc_cycle_number=cstmt.getInt(2);
										String msg=cstmt.getString(3);
										session.putValue("mc_cycle_number",new Integer(mc_cycle_number));
										if(msg!=null && !msg.equals("")){
											out.println("<script>alert(getMessage('"+msg+"','MP'))</script>");
											flag		= "false";
											return;
										}else{
											session.putValue("dft_vlaues_from_mc","Y");
										}
									}
								//}
							}
						}catch(Exception ex){
							ex.printStackTrace();
							//out.println("<script>alert('Exception in prepared statement')</script>");
							//flag		= "false";
							//return;
						}
					} 
					/*
					else if(sex_det.equals("M")){
						pstmt_chk_age = conn.prepareStatement("select nvl(NB_FATHER_MIN_AGE,0)NB_FATHER_MIN_AGE from mp_param where module_id='MP'"); 
					} 
					*/
					//rs_chk_age = pstmt_chk_age.executeQuery(); 
					if(sex_det.equals("M")){	 			    
						//father_min_age = rs_chk_age.getInt("NB_FATHER_MIN_AGE");
						if(father_age < father_min_age){
							out.println("<script>var msg=getMessage('FATHER_AGE_PARAM','MP');alert(msg)</script>"); 
							flag = "false";
							age_flag	= "true";
							age_flag1	= "true";
						}			
					}					
					if(flag=="true"){
						//if(rs_chk_age.next()){

							/*
							mother_min_age				= rs_chk_age.getInt("NB_MOTHER_MIN_AGE"); 	
							mother_max_age				= rs_chk_age.getInt("NB_MOTHER_UPPER_AGE"); 
							mother_cutoff_age			= rs_chk_age.getInt("NB_MOTHER_CUTOFF_AGE");
							min_gest_bet_del			= rs_chk_age.getDouble("NB_MIN_GEST_BET_2_DELY");
							MAX_MULTIPLE_BIRTH_REGN_HRS	= rs_chk_age.getDouble("MAX_MULTIPLE_BIRTH_REGN_HRS");
							*/
						if(sex_det.equals("F")){	
							if((mother_cutoff_age > 0) && (min_age < mother_cutoff_age))
							{
								// Mother's age shd be > MP Param value
								out.println("<script>var msg=getMessage('MOTHER_AGE_PARAM','MP');alert(msg)</script>");   
								flag		= "false";
								age_flag	= "true";
								age_flag1	= "true";
							}
							else if((mother_min_age > 0) && (min_age < mother_min_age))
							{
								//** The alert is just for warning. When pressed ok it will proceed further.**//

								out.println("<script>var msg=getMessage('MOTHER_CUTOFF_AGE','MP');alert(msg)</script>");  
								flag		= "true";
								age_flag	= "false";
								age_flag1	= "false";
							}
							else if ((mother_max_age > 0) && (min_age > mother_max_age))
							{
								out.println("<script>var msg=getMessage('MOTHER_MAX_AGE','MP');alert(msg)</script>");	
								flag		= "false";
								age_flag	= "true";
								age_flag1	= "true";
							}

							else if((mother_max_age > 0) && (min_age == mother_max_age))
							{
								if(min_age1 > 0)
								{
									out.println("<script>var msg=getMessage('MOTHER_MAX_AGE','MP');alert(msg)</script>");	
									flag		= "false";
									age_flag	= "true";
									age_flag1	= "true";
								}
								else if((min_age1 == 0) && (min_age2 > 0))
								{	
									out.println("<script>var msg=getMessage('MOTHER_MAX_AGE','MP');alert(msg)</script>");	
									flag		= "false";
									age_flag	= "true";
									age_flag1	= "true";
								}
								else flag = "true";
							}
							else flag = "true";

						  //}
							if(flag == "true") 
							{
								try 
								{
									int noofmultibabiesregistered = 0;
									//pstmtTEMP = conn.prepareStatement("select count(*) from mp_birth_register where mother_patient_id=?");

									pstmt = conn.prepareStatement(" select no_of_multi_babies_regd, round(abs(sysdate - TIME_OF_BIRTH)*24,2) diffHours, patient_id last_nb_ID, birth_order last_nb_order, no_of_births, multiple_birth_yn from mp_birth_register where mother_patient_id = ? order by ADDED_DATE DESC ");

									pstmt.setString(1,pat_id);
									rs=pstmt.executeQuery();

									if(rs!=null && rs.next())
									{
										/*
										count = rs.getInt(1);
									}
									if(count > 0)
									{
										
										int noofmultibabiesregistered = 0;										

										pstmt = conn.prepareStatement("Select no_of_multi_babies_regd from mp_birth_register where mother_patient_id = ? order by ADDED_DATE DESC");
										
										pstmt.setString(1,pat_id);
										rs = pstmt.executeQuery();
										if(rs != null && rs.next()){
											noofmultibabiesregistered = rs.getInt(1);
										}									

										pstmtGest1=conn.prepareStatement ("SELECT round(abs(sysdate - max(TIME_OF_BIRTH))*24,2) diffHours,max(patient_id) last_nb_ID,max(birth_order) last_nb_order, max(no_of_births) no_of_births, max(multiple_birth_yn) multiple_birth_yn FROM MP_BIRTH_REGISTER WHERE MOTHER_PATIENT_ID=?");
										
										pstmtGest1.setString(1,pat_id);
										rsGest1 = pstmtGest1.executeQuery();

										if(rsGest1.next())
										{
											*/
											noofmultibabiesregistered = rs.getInt("no_of_multi_babies_regd");
											diffHours			= rs.getDouble("diffHours");
											last_nb_order		= rs.getInt("last_nb_order");
											no_of_births		= rs.getInt("no_of_births");
											multiple_birth_yn	= rs.getString("multiple_birth_yn");									
										//}
										last_nb_order			= last_nb_order;
										no_of_births			= no_of_births;									
										diffWeeks					= (double)diffHours/(24*7);						
										diffDays				= diffWeeks * 7;
										min_gest_bet_del_days	= min_gest_bet_del * 7;					
										if(multiple_birth_yn.equals("N"))
										{	
											if((diffWeeks <= min_gest_bet_del) || (diffDays <= min_gest_bet_del_days))
											{	
												out.println("<script>var msg=getMessage('DIFF_BET_TWO_DELY','MP');alert(msg)</script>");	
												flag= "false";
												age_flag	= "true";
												age_flag1	= "true";
											}
										}
										else 
										{						
											if(noofmultibabiesregistered > 0)
											{
												if(MAX_MULTIPLE_BIRTH_REGN_HRS > 0)
												{
													if(sub_multi_birth_hw.equals("H")){
														if(diffHours > MAX_MULTIPLE_BIRTH_REGN_HRS){  												
															out.println("<script>var msg=getMessage('SUBSEQUENT_DELY','MP');alert(msg)</script>");
															flag		= "false";
															age_flag	= "true";
															age_flag1	= "true";														
														}
													}else if(sub_multi_birth_hw.equals("W")){
														if(diffWeeks > MAX_MULTIPLE_BIRTH_REGN_HRS){  																
															out.println("<script>var msg=getMessage('SUBSEQUENT_DELY','MP');alert(msg)</script>");
															flag		= "false";
															age_flag	= "true";
															age_flag1	= "true";														
														}
													}
												}
											}
											else if(noofmultibabiesregistered == 0)
											{
												if((diffWeeks <= min_gest_bet_del) && (diffDays <= min_gest_bet_del_days))
												{ 
													out.println("<script>var msg=getMessage('DIFF_BET_TWO_DELY','MP');alert(msg)</script>");
													flag		= "false";
													age_flag	= "true";
													age_flag1	= "true";
												}
											}
											else
											{	
												flag		= "true";
												age_flag	= "false";
												age_flag1	= "false";
											}
										}
									} //end if count > 0
								}
								catch(Exception e) {out.println(e.toString());}
							}
						}
						//}
					}
				} //end try
				catch(Exception e) {out.println(e.toString());}
			}//end if
		}
		else 
		{					
			flag		= "true";
			age_flag	= "false";
			age_flag1	= "false";  
		}
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
		//if(rs_sex != null) rs_sex.close();
		//if(pstmtSex != null) pstmtSex.close();
		if (pstmt8 != null) pstmt8.close();
		if (rs8 != null) rs8.close();

		if(pstmt!=null) pstmt.close();
		if (rs != null) rs.close();	

		//if (rs_chk_age != null) rs_chk_age.close();
		//if (pstmtTEMP != null) pstmtTEMP.close();
		//if (pstmt_chk_age !=null) pstmt_chk_age.close();
		//if (pstmtGest1 != null) pstmtGest1.close();
		if (rsGest != null) rsGest.close();
		//if (rsGest1 != null) rsGest1.close();
		//if (rsTEMP != null) rsTEMP.close();
		ConnectionManager.returnConnection(conn,request);
	}
	if(sflag.equals("") || sflag.equals("undefined")){
		if(retback.equals("retback")){
			
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(age_flag));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(age_flag1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(sex_det));
            _bw.write(_wl_block57Bytes, _wl_block57);

		}
		else
		{
			
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(age_flag));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(age_flag1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(sex_det));
            _bw.write(_wl_block61Bytes, _wl_block61);

		}
	}else if(flag.equals("true")){
		out.println("<script>callMenu('"+sflag+"',\""+pat_id+"\");</script>");
	}
	if(!IPValue.equals("")){
		if (flag.equals("true")){
			out.println("<script>showRegisterNewBorn('"+pat_id+"');</script>");
		}else{
			return;
		}
	}

            _bw.write(_wl_block62Bytes, _wl_block62);
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
