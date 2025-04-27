package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eMP.PatSearch.*;
import webbeans.eCommon.*;
import javax.naming.*;
import javax.ejb.*;
import java.rmi.*;
import javax.rmi.*;
import java.util.*;
import com.ehis.util.*;

public final class __duppatientiddisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/DupPatientIDDisplay.jsp", 1725010947723L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<Script src=\"../../eMP/js/DupPatientSearch.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t\n\t\t<script>\n\t\t\tfunction SearchLimit(val) \n\t\t\t{           \n\t\t\t\tvar hit=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t    parent.parent.Pat_Search_Criteria_Frame.document.forms[0].ORDERBY.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tif(parent.parent.Pat_Search_Criteria_Frame.document.forms[0].Contact_No.value=\"\"){\n\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].Mode.value=\"\";\n\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].Mode.disabled=true;\n\t\t\t\t}\n\t\t\t}\n/*\t\t\tfunction modelPhoto(pat) \n            {   \n\t\t\t\tvar view_pat_photo_yn = document.forms[0].view_pat_photo_yn.value;\n                var resp_name = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n                if (view_pat_photo_yn==\"Y\")\n                {\n\t\t\t\t\tvar url     = \"../../eCommon/jsp/PatientSearchPhoto.jsp?Patient_id=\" + escape(pat);\n                    var dialogHeight    = \"12\" ;\n                    var dialogWidth = \"12\" ;\n                    var arguments   = \"\" ;\n                    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; status=no\";\n                    var closeWin    = window.showModalDialog( url, arguments, features ) ;\n\t\t\t\t}\n                else\n                {\n\t\t\t\t\tvar msg = parent.getMessage(\"VIEW_PAT_PHOTO_RESTRICT\",\'MP\'); msg = msg.replace(\'~\',resp_name); alert(msg);\n                }\n\t\t\t}*/\n\t\t\tasync function ViewPatDtl(Pat_id)\n            { \n\n\t\t\t\tPat_id=unescape(Pat_id)\n\t\t\t\tvar url         = \"../jsp/ViewPatDetailsMain.jsp?Patient_ID=\"+escape(Pat_id);\n\t\t\t\tvar\tdialogHeight=\"700vh\";\n\t\t\t\tvar\tdialogWidth=\"400vw\";\n\t\t\t\tvar\tdialogTop=\"72\";\n               \n                var arguments   = \"\" ;\n                var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no;\";\n                var returnval = await window.showModalDialog( url, arguments, features ) ;\n            }\n\t\t\t/*\n\t\t\tfunction ViewPatDtlDup(Pat_id)\n            {\n\t\t\t\tvar url         = \"../jsp/ViewPatDetailsMain.jsp?disp_dup_pat_dtls=Duplicate&Patient_ID=\"+Pat_id;\n                var dialogTop       = \"65\";\n                var dialogHeight    = \"33.4\";\n                var dialogWidth     = \"50\";\n                var arguments   = \"\" ;\n                var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no;\";\n                var returnval = window.showModalDialog( url, arguments, features ) ;\n\t\t\t} \n\t\t\t*/\n\t\t\tasync function showSecuredNames(patientID)\n\t\t\t{\n\t\t\t\tvar url         = \"../../eMP/jsp/DisplayPatientSecuredNames.jsp?patient_id=\"+escape(patientID);\n                var dialogTop       = \"76\";\n                var dialogHeight    = \"15\";\n                var dialogWidth     = \"50\";\n                var arguments   = \"\" ;\n                var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no;\";\n                var returnval = await window.showModalDialog( url, arguments, features ) ;\n\t\t\t\tif (returnval)\n\t\t\t\t{\n\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].reset();\n\t\t\t\t\tparent.parent.Pat_Results_Frame.location.href = \'../../eCommon/html/blank.html\';\n                    parent.parent.frames[4].location.href = \'../../eCommon/html/blank.html\';\n\t\t\t\t}\n\t\t\t}\n            async function showMRNS(patientID)\n            {\n\t\t\t\tvar url         = \"../../eMP/jsp/MultipleMRN.jsp?Patient_Id=\"+escape(patientID);\n                var dialogTop       = \"76\";\n                var dialogHeight    = \"15\";\n                var dialogWidth     = \"50\";\n                var arguments   = \"\" ;\n                var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no;\";\n                var returnval = await window.showModalDialog( url, arguments, features ) ;\n            //RETURN VALUE COMES BACK ONLY IF THE SEARCH IS TRIGGERED FROM MP ONLINE REPORTS\n                if (returnval)\n\t\t\t\t{\n\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].reset();\n                    parent.parent.Pat_Results_Frame.location.href = \'../../eCommon/html/blank.html\';\n                    parent.parent.frames[4].location.href = \'../../eCommon/html/blank.html\';\n                    var retValArray = returnval.split(\":\");\n                    PrintOnlineReports(retValArray[0],retValArray[1]);                      \n\t\t\t\t}\n\t\t\t}\n            async function PrintOnlineReports(PatID,GenFN)\n            {\n\t\t\t\tvar retVal =    new String();\n                var dialogHeight    = \"30\" ;\n                var dialogWidth = \"70\" ;\n                var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; status=no;\" ;\n                var arguments   = \"\" ;\n                retVal = await window.showModalDialog(\"../../eCommon/jsp/InternalReportsReprint.jsp?module_id=MP&step=0&patient_id=\"+escape(PatID)+\"&Gen_File_No=\"+escape(GenFN)+\"&target=step2\",arguments,features);                 \n\t\t\t}\n\t\t\t/* \n\t\t\tFunction :  To change the ordef By clause in Query.\n\t\t\t */\n\t\t\t function ordercols(field) \n            { \n\t\t\t\t\tvar htmlVal=\"<html><body onKeyDown=\'lockKey()\'><form name=\'f1\' id=\'f1\' action=\'../../eMP/jsp/DupPatientIDDisplay.jsp?orderFlag=Y\' method=\'post\'> \";\n\t\t\t\t\tfor (var i=0;i<document.forms[0].elements.length;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tif (document.forms[0].elements[i].name!=\'final_sql\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\thtmlVal = htmlVal + \"<input type=\'hidden\' name=\\\"\"+document.forms[0].elements[i].name+\"\\\" id=\\\"\"+document.forms[0].elements[i].name+\"\\\" value=\\\"\"+document.forms[0].elements[i].value+\"\\\">\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar ordSql = parent.Pat_Results_Frame.document.forms[0].final_sql.value;\n\t\t\t\t\t\t\thtmlVal = htmlVal + \"<input type=\'hidden\' name=\'final_sql\' id=\'final_sql\' value=\\\"\"+ordSql+\"\\\">\";\n\t\t\t\t\t\t\thtmlVal = htmlVal + \"<input type=\'hidden\' name=\'Hdr_Order\' id=\'Hdr_Order\' value=\\\"\"+field+\"\\\">\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tvar whrCls=parent.Pat_Results_Frame.document.forms[0].final_whereClause.value;\n\t\t\t\t\thtmlVal = htmlVal +\"<input type=\'hidden\' name=\'OrderwhereClause\' id=\'OrderwhereClause\' value=\\\"\"+whrCls+\"\\\">\";\n\t\t\t\t\thtmlVal = htmlVal + \"</form></body></html>\";\n\t\t\t\t\tparent.Pat_Results_Frame.document.write(htmlVal);\n\t\t\t\t\tparent.Pat_Results_Frame.document.f1.submit();\n\t\t\t\t\tparent.Pat_Search_Toolbar_Frame.defaultSetting();\n\t\t\t}\n\t\t\tfunction checkExpiry(pat_id,jsp_name,flag,func_id, sflag){\n\t\t\t\t//alert(\"in DupPatientIDDisplay.jsp page\");\n\t\t\t\t//alert(\"inside basicpatient 3\");\n\t\t\t\tvar sStyle = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t var HTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown=\'lockKey()\'>\";\n\t\t\t\t HTMLVal = HTMLVal +\"<form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eMP/jsp/DupPatSearchCheckAltIDExpiryDate.jsp\'>\";\n\t\t\t\t HTMLVal = HTMLVal +\"<input name=\'pat_id\' id=\'pat_id\' type=\'hidden\' value= \\\"\"+escape(pat_id) + \"\\\">\";\n\t\t\t\t HTMLVal = HTMLVal +\"<input name=\'jsp_name\' id=\'jsp_name\' type=\'hidden\' value= \'\"+jsp_name+\"\'>\";\n\t\t\t\t HTMLVal = HTMLVal +\"<input name=\'flag\' id=\'flag\' type=\'hidden\' value= \'\"+flag+\"\'>\";\n\t\t\t\t HTMLVal = HTMLVal +\"<input name=\'func_id\' id=\'func_id\' type=\'hidden\' value= \'\"+func_id+\"\'>\";\n\t\t\t\t HTMLVal = HTMLVal +\"<input name=\'sflag\' id=\'sflag\' type=\'hidden\' value= \'\"+sflag+\"\'>\";\n\t\t\t\t HTMLVal = HTMLVal +\"<input name=\'win_width\' id=\'win_width\' type=\'hidden\' value= \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\";\n\t\t\t\t HTMLVal = HTMLVal +\"<input name=\'win_top\' id=\'win_top\' type=\'hidden\' value= \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\";\n\t\t\t\t HTMLVal = HTMLVal +\"<input name=\'win_height\' id=\'win_height\' type=\'hidden\' value= \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\";\n\t\t\t\t HTMLVal = HTMLVal +\"</form></BODY></HTML>\";\n\t\t\t\t \n\t\t\t\t parent.frames[5].document.write(HTMLVal);\n\t\t\t\t parent.frames[5].document.form1.submit(); \n\t\t\t}\n\t\t</script>\n\t\t<style type=\"text/css\">\n\n#patDtl { width:870; overflow-y:no;overflow-x:auto;height:238px; }\n\n#patId {height:238px;}\n</style>\n\t</head>\n<BODY class=\'CONTENT\' onLoad=\"SearchLimit(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\" onKeyDown = \'lockKey()\'>\n<form name=\'result_form\' id=\'result_form\' action = \"../../eMP/jsp/DupPatientIDDisplay.jsp\" >\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tsetTimeout(\'aa()\',70);\n\t\t\t\t\t\t\tfunction aa(){\n\t\t\t\t\t\t\t\tvar flag=\'retback\';\n\t\t\t\t\t\t\t\tif ( (parent.parent.Pat_Search_Criteria_Frame.document.forms[0].Sex.disabled==true) && (parent.parent.Pat_Search_Criteria_Frame.document.forms[0].func_idpassed.value!=\'MP_MAIN_NB_REG\') )\n\t\t\t\t\t\t\t\t\tcheckExpiry(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'retback\', \'NEWBORN_REG\');\n\t\t\t\t\t\t\t\telse checkExpiry(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'retback\',\'\');\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n                \t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t                <script>\n\t\t                setTimeout(\'aa()\',70);\n\t\t\t            function aa(){\n\t\t\t\t\t\t\talert(\"in dup 11\");\n\t\t\t\t\t        var flag=\'retback\';\n\t\t\t\t\t\t  \tif ( (parent.parent.Pat_Search_Criteria_Frame.document.forms[0].Sex.disabled==true) && (parent.parent.Pat_Search_Criteria_Frame.document.forms[0].func_idpassed.value!=\'MP_MAIN_NB_REG\') )\n\t\t                        checkExpiry(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'retback\', \'NEWBORN_REG\');\n\t\t\t                else checkExpiry(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'retback\',\'\');\n\t\t\t\t\t    }\n\t\t\t\t\t</script>\n                \t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n        <Script language=\"JavaScript\">\n\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.getElementById(\"disprec\").style.visibility=\'visible\' ; \n\t\t\tvar maxrec = \'\';\n\t\t\tvar str = \'\';\n\t\t\tif(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\")\n\t\t\tmaxrec = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";//parent.parent.Pat_Results_Frame.document.getElementById(\"Hit_Limit\").value;\n\t\t\tif(parent.parent.Pat_Results_Frame.document.getElementById(\"To\"))\n\t\t\tstr=parent.parent.Pat_Results_Frame.document.getElementById(\"To\").value;\n\t\t\tif (eval(maxrec) > 50)\n\t\t\t{\n\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.forms[0].prev.style.visibility = \'visible\';\n\t\t        parent.parent.Pat_Search_Toolbar_Frame.document.forms[0].next.style.visibility = \'visible\';\n\t\t\t}\n\t\t\tif (parent.parent.Pat_Search_Toolbar_Frame.document.forms[0].register)\n\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.forms[0].register.disabled = false;\n\t\t\tif (parent.parent.Pat_Search_Toolbar_Frame.document.forms[0].register1)\n\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.forms[0].register1.disabled = false;\n\t\t</Script>\n        ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n        <Script language=\"JavaScript\">\n\t\t\tif (parent.parent.Pat_Search_Toolbar_Frame.document.forms[0].register)\n\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.forms[0].register.disabled = false;\n \t\t\tif (parent.parent.Pat_Search_Toolbar_Frame.document.forms[0].register1)\n\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.forms[0].register1.disabled = false;\n\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="                  \n            var md = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n            if (md==\"\")\n            {\n\t\t\t\tvar td = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";            \n                var scroll_view = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";     \t\t\t\t\t\t\n\t\t\t\tif (scroll_view>0)\n                {\n\t\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.getElementById(\"disprec\").innerHTML= td;\n                    parent.parent.Pat_Search_Toolbar_Frame.document.getElementById(\"disprec\").style.visibility=\'visible\' ;   \n                    parent.parent.Pat_Search_Toolbar_Frame.document.getElementById(\"display\").style.visibility=\'visible\' ;\n\t\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.getElementById(\"str11\").focus();\n\t\t\t\t}\n                if (scroll_view>5) \n                {\n\t\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.forms[0].next.style.visibility = \'visible\';            parent.parent.Pat_Search_Toolbar_Frame.document.forms[0].prev.style.visibility = \'visible\';\n\t\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.forms[0].prev.disabled = true;\n\t\t\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.forms[0].next.disabled = false;\n\t\t\t\t}           \n\t\t\t\tmode = \"Y\";\n\t\t\t}\n\t\t</Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<script>\n\t\t\tfor (var i=0;i<parent.parent.Pat_Search_Criteria_Frame.document.forms[0].elements.length;i++) {\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].elements[i].disabled=false;}\n\t\t\tif(parent.parent.Pat_Search_Criteria_Frame.document.forms[0].maintain_doc_or_file.value == \'D\') {\n\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].MRN.disabled = true;\n\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].OldFileNo.disabled = true; \n\t\t\t}\n\t\t\tparent.parent.Pat_Search_Toolbar_Frame.document.forms[0].Search.disabled = false;\n\t\t\t//\tout.println(\"parent.parent.Pat_Search_Criteria_Frame.enableRegister()\");\n\t</script>\n\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.commontoolbar.location.href=\'../jsp/DupPatientSearchToolBar.jsp\'\t\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\n\t\t\t  \t\tvar PatientSearchCrt_Form=parent.Pat_Search_Criteria_Frame.document.forms[0];\n\t\t\t\t \n\t\t\t\t for (var i=0;i<PatientSearchCrt_Form.elements.length;i++) {\t\t\t\t\n\t\t\t\t\t\t PatientSearchCrt_Form.elements[i].disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.Pat_Search_Toolbar_Frame.document.forms[0].Search.disabled= false;\n\t\t\t\t\t\tif(PatientSearchCrt_Form.maintain_doc_or_file.value == \'D\') { ;\n\t\t\t\t\t\t\tPatientSearchCrt_Form.MRN.disabled = true;\n\t\t\t\t\t\t\tPatientSearchCrt_Form.OldFileNo.disabled = true; \n\t\t\t\t}\n\t\t\t\t\tif (PatientSearchCrt_Form.register !=null) \n\t\t\t\t\t\t\tPatientSearchCrt_Form.register.disabled=false;\n\t\t\t\t\tparent.document.frames[2].enableRegister();\n\t\t\t\t</script>\n\t\t\t\t<script>\n\t\t\t\t\tvar PatientSearchCrt_Form=parent.Pat_Search_Criteria_Frame.document.forms[0];\n\t\t\t\t\tif (PatientSearchCrt_Form.searchby !=null && PatientSearchCrt_Form.searchby.value ==\'\' )\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPatientSearchCrt_Form.searchby.disabled=false;\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n<input type=\"hidden\" name=\"From\" id=\"From\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"To\" id=\"To\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"\">\n<input type=\"hidden\" name=\"maxdisplay\" id=\"maxdisplay\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"maxdisplay1\" id=\"maxdisplay1\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"searchthreshold\" id=\"searchthreshold\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"search_in\" id=\"search_in\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"\">\n<input type=\"hidden\" name=\"age\" id=\"age\" value=\"\">\n<input type=\"hidden\" name=\"min_age\" id=\"min_age\" value=\"\">\n<input type=\"hidden\" name=\"func_act\" id=\"func_act\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\"hidden\" name=\"func_idpassed\" id=\"func_idpassed\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\"hidden\" name=\"allow_nb_review\" id=\"allow_nb_review\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=\"hidden\" name=\"view_pat_photo_yn\" id=\"view_pat_photo_yn\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\"hidden\" name=\"order_by\" id=\"order_by\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"Hit_Limit\" id=\"Hit_Limit\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"jsp_name\" id=\"jsp_name\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"p_no\" id=\"p_no\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n <input type=\"hidden\" name=\"National_Id_No\" id=\"National_Id_No\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n <input type=\"hidden\" name=\"win_top\" id=\"win_top\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\"win_width\" id=\"win_width\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\"hidden\" name=\"win_height\" id=\"win_height\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\"hidden\" name=\"act_yn\" id=\"act_yn\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\"hidden\" name=\"srr\" id=\"srr\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\"hidden\" name=\"old_file_no_where\" id=\"old_file_no_where\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type=\"hidden\" name=\"file_no_where\" id=\"file_no_where\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\"hidden\" name=\"MRN\" id=\"MRN\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<input type=\"hidden\" name=\"OldFileNo\" id=\"OldFileNo\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<input type=\"hidden\" name=\"usePatIDIndex\" id=\"usePatIDIndex\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<input type=\"hidden\" name=\"TotalNoRecords\" id=\"TotalNoRecords\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<input type=\"hidden\" name=\"enablegenderyn\" id=\"enablegenderyn\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<input type=\"hidden\" name=\"final_sql\" id=\"final_sql\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<input type=\"hidden\" name=\"final_whereClause1\" id=\"final_whereClause1\" value=\"\">\n<input type=\"hidden\" name=\"final_whereClause\" id=\"final_whereClause\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<input type=\"hidden\" name=\"selectClause\" id=\"selectClause\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\n</center>\n<script>\nif ( (\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'==\"NEWBORN_REG\") || (\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'==\"MP_MAIN_NB_REG\") )\n{\n\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].Sex.disabled = true;\n}\n</script>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	"":inputString;
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

request.setCharacterEncoding("UTF-8");
String maxRecord1 = request.getParameter("maxRecord");
if(maxRecord1 == null) maxRecord1="";
double maxRecord = 0;
if (!maxRecord1.equals(""))
maxRecord = Double.parseDouble(maxRecord1);
/*Combining DupPatientIDDisplay.jsp & DupPatientResultMain.jsp
==>All The Vairables Of DupPatientResultMain.jsp are declared Here
*/

//request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String logged_facility = (String) session.getValue("facility_id");
String resp_name = (String) session.getValue("responsibility_name");
Connection 	 conn = null;
PreparedStatement Count_pstmt		= null;
PreparedStatement Valid_pstmt		= null;
//PreparedStatement Lenth_pstmt		= null;
PreparedStatement Check_pstmt		= null;
PreparedStatement Select_pstmt		= null;
PreparedStatement tble_Cnt_pst		= null;
ResultSet Count_rSet	=	null;
ResultSet Valid_rSet		=	null;
ResultSet Select_rSet	=	null;
ResultSet tble_rSet		=	null;
ResultSet rs7=null;
String selectClause="";
String mode = "";
String view_pat_photo_yn = "N";
//outer try to close connections

try{//First & Final  Try

//String sql;
	conn = ConnectionManager.getConnection(request);



/**Vairable For Max Record & Max Display**/
int start			= 0;
int end				= 0;
int searchThreshold	= 11;
double maxDisplay	= 0;
double maxDisplay1	= 0;
int TotalNoRecords = 0;
//int percent=0;
int totalpercent=100; 


String from = request.getParameter( "From" );
String to = request.getParameter( "To" );

if ( from == null || from.equals(""))
    start = 1 ;
else
    start = Integer.parseInt( from ) ;
if ( to == null || to.equals(""))
    end = searchThreshold ;
else
    end = Integer.parseInt( to ) ;
//double maxRecord = 0;
//String photo[]=null;
double Hit=0;
double Hit_for_buttons=0;
String maxDisp = checkForNull(request.getParameter("maxdisplay"),"0");
String maxDisp1 = checkForNull(request.getParameter("maxdisplay1"),"0");

if (maxDisp==null ||maxDisp.equals("0.0")) maxDisp = "0";
if (maxDisp1==null ||maxDisp1.equals("0.0")) maxDisp1 = "0";
maxDisplay = Double.parseDouble(maxDisp);
maxDisplay1 = Double.parseDouble(maxDisp1);


/************Ends*************/

/******Vairable Declaration Of  Criteria Page*******/
String pat_id					=	checkForNull(request.getParameter("p_no"));
String Alt_Id1_No			=  checkForNull(request.getParameter("Alt_Id1_No"));
String National_Id_No	=  checkForNull(request.getParameter("National_Id_No"));
String  Family_No			=  checkForNull(request.getParameter("Family_No"));
String file_no					=  checkForNull(request.getParameter("MRN"));
String First_Name		    =  checkForNull(request.getParameter("First_Name"));
String Second_Name		=  checkForNull(request.getParameter("Second_Name"));
String  Third_Name			=  checkForNull(request.getParameter("Third_Name"));
String  Family_Name		=  checkForNull(request.getParameter("Family_Name"));
String  Sex						=  checkForNull(request.getParameter("Sex"));
String  By						=  checkForNull(request.getParameter("By"));

/* Note=1=>
1.DATE,FromDate&ToDate values  are the based upon the By Value. Either By Value is Date nOr Year
2.If By value is D(Date), DATE Value is Considered for WhereClause. 
3.Else By value is Y(Year) FromDate and ToDates are Considered for WhereClause */
String DATE								=	checkForNull(request.getParameter("DATE"));
String FromDate						=	checkForNull(request.getParameter("FromDate"));
String ToDate							=	checkForNull(request.getParameter("ToDate"));
String  Mode								=  checkForNull(request.getParameter("Mode"));
String  Contact_No					=  checkForNull(request.getParameter("Contact_No"));
String  Area								=  checkForNull(request.getParameter("Area"));
String  Soundex							=  checkForNull(request.getParameter("Soundex"));
String old_file_no						=  checkForNull(request.getParameter("OldFileNo"));
String  Alt_Id2_No					=  checkForNull(request.getParameter("Alt_Id2_No"));
String  Alt_Id3_No					=  checkForNull(request.getParameter("Alt_Id3_No"));
String  Alt_Id4_No					=  checkForNull(request.getParameter("Alt_Id4_No"));
String  Nationality						= checkForNull( request.getParameter("Nationality"));
String  addl_field1						=  checkForNull(request.getParameter("addl_field1"));
String  addl_field2						=  checkForNull(request.getParameter("addl_field2"));
String  addl_field3						=  checkForNull(request.getParameter("addl_field3"));
String  addl_field4						= checkForNull( request.getParameter("addl_field4"));
String  addl_field5						=  checkForNull(request.getParameter("addl_field5"));
String  ethnic_group					=  checkForNull(request.getParameter("ethnic_group"));
String other_alt_id					=  checkForNull(request.getParameter("other_alt_id"));
String other_alt_Id_no				= checkForNull( request.getParameter("other_alt_Id_no"));
//String sltDocType						= checkForNull( request.getParameter("sltDocType"));
//String txtDocType					=  checkForNull(request.getParameter("txtDocType"));
String family_org_membership =  checkForNull(request.getParameter("family_org_membership"));
String organization						=  checkForNull(request.getParameter("organization"));
String sub_organization				=  checkForNull(request.getParameter("sub_organization"));
String Orgnization_id					=	checkForNull(request.getParameter("Orgnization_id"));
String sub_Organisation				=	checkForNull(request.getParameter("sub_Organisation"));
//String mother_maiden_name		= checkForNull(request.getParameter("mother_maiden_name"));
String first_name_loc_lang			= checkForNull( request.getParameter("first_name_loc_lang"));
String second_name_loc_lang		=  checkForNull(request.getParameter("second_name_loc_lang"));
String third_name_loc_lang			=  checkForNull(request.getParameter("third_name_loc_lang"));
String family_name_loc_lang		= checkForNull( request.getParameter("family_name_loc_lang"));
String deceased_yn						= checkForNull( request.getParameter("deceased_yn"));
String suspend_yn						= checkForNull( request.getParameter("suspend_yn"));
String  active_yn							=	checkForNull(request.getParameter("active_yn"));
String reg_mode							=  checkForNull(request.getParameter("reg_mode"));
String  IP_yn								= checkForNull( request.getParameter("IP_yn"));
String DC_yn								= checkForNull( request.getParameter("DC_yn"));
String OP_yn								= checkForNull( request.getParameter("OP_yn"));
String EM_yn								= checkForNull( request.getParameter("EM_yn"));
String patient_series					=  checkForNull(request.getParameter("patient_series"));
String win_height						=	checkForNull(	request.getParameter("win_height"));
String win_width						=	checkForNull(request.getParameter("win_width"));
String win_top							=	checkForNull(	request.getParameter("win_top"));
String srr									=	checkForNull( request.getParameter("srr"));
String func_act							= checkForNull(request.getParameter("func_act"));
String act_yn							= checkForNull(request.getParameter("act_yn"));
String func_idpassed					=	checkForNull(request.getParameter("func_idpassed"));
String old_file_no_where			=	checkForNull( request.getParameter("old_file_no_where"));
String file_no_where					=	checkForNull( request.getParameter("file_no_where"));
String apply_oth_name				= checkForNull(request.getParameter("apply_oth_name"));
String selectClauseReq				= checkForNull(request.getParameter("selectClause"));


String search_in							=	checkForNull(request.getParameter("search_in"));
String order_by							=  checkForNull(request.getParameter( "order_by" ));
//String newBorn_sufx					=  checkForNull(request.getParameter( "newBorn_sufx" ));
String function_id						=	checkForNull(request.getParameter("function_id"));
String jsp_name						=  checkForNull(request.getParameter( "jsp_name" ));
String orderby							=	"";
//String cntPrefFac						= checkForNull(request.getParameter("cntPrefFac"),"0");
String enablegenderyn				= checkForNull(request.getParameter( "enablegenderyn" ),"Y");
String usePatIDIndex			    =	checkForNull(request.getParameter("usePatIDIndex"),"N");
//String dr_merge_valid				=	checkForNull(request.getParameter("dr_merge_valid"));

//int patient_id_length					=	Integer.parseInt(request.getParameter("patient_id_length"));
String allow_nb_review			=	checkForNull(request.getParameter ("allow_nb_review"),"N");


String alignment			=  (apply_oth_name == ""||  apply_oth_name.equals("")) ?"left" : "left" ;
String othlang			= (apply_oth_name == "" ||  apply_oth_name.equals("")) ?"N" : "Y" ;
//String orderClause="";
if (order_by.equals("")||order_by.equals("X")){
	orderby="";
}else{
	orderby=" order by "+order_by;
}

boolean addl_field_Flag=false;
if (addl_field1.equals("") &&	addl_field2.equals("") && addl_field3.equals("") && addl_field4.equals("") && addl_field5.equals("")){
addl_field_Flag=true;
}

boolean file_no_Flag=true;
if (file_no.equals("") || old_file_no.equals("")){
	file_no_Flag=false;
}
boolean proceed = true;
String strAND="";
//String strOR="";



/**************Vairable Declaration Ends********************/
/*Declaration OF StringBuffers*/
StringBuffer final_selectCaluse	=	new StringBuffer();
StringBuffer Dyn_selectClause	=	new StringBuffer();
StringBuffer whereClause			=	new StringBuffer();
StringBuffer fromClause			=	new StringBuffer();
StringBuffer finalQuery				=	new StringBuffer();
StringBuffer sbrfinal					=	new StringBuffer();
//StringBuffer orderByCaluse		=	new StringBuffer(orderby);

/****Ends****/
/*****Declaton For PageNation Vairables*******/
String pageWhere	 =	"";
String Pageflag		=	"";
StringBuffer pagewhereClause	=	null;

/**Ends**/   
/*Declaration OF Order Vairables*/	
String			OrderwhereClause	=	"";
StringBuffer	OrderBuffer				=	null;
String			final_sql					=	"";
String			orderFlag					=	"";
String			 Hdr_Order				=	"";
/****Ends****/
/**************Construction Of  Complete Query And Getting Result Form EJB  Once Patient Is Valid***************/




/*****Checking For Valid Patient********/
String valid_patient_id="";

if (!search_in.equals("D")&&(function_id.equals("") || function_id.equals("PAT_REG") ||func_act.equals("DuplicateRegistration") || 	function_id.equals("NEWBORN_REG"))){
	Valid_pstmt = conn.prepareStatement("select valid_patient_id from dr_mp_patient where duplicate_patient_id = ?");
	Valid_pstmt.setString(1,pat_id);
	Valid_rSet=Valid_pstmt.executeQuery();
	if (Valid_rSet!=null && Valid_rSet.next())
		valid_patient_id = Valid_rSet.getString("valid_patient_id");
	if (valid_patient_id==null) valid_patient_id = "";
	if (search_in.equals("P") && !valid_patient_id.equals("")){
			out.println("<script>");
			out.println("for (var i=0;i<parent.Pat_Search_Criteria_Frame.document.forms[0].elements.length;i++) {parent.Pat_Search_Criteria_Frame.document.forms[0].elements[i].disabled=false;}");
			out.println("parent.Pat_Search_Toolbar_Frame.document.forms[0].Search.disabled = false;");
			out.println("if(parent.Pat_Search_Criteria_Frame.document.forms[0].maintain_doc_or_file.value == 'D') {");
			out.println("parent.Pat_Search_Criteria_Frame.document.forms[0].MRN.disabled = true;");
			out.println("parent.Pat_Search_Criteria_Frame.document.forms[0].OldFileNo.disabled = true; }");
			out.println("parent.Pat_Search_Criteria_Frame.enableRegister()");
			out.println("</script>");
			out.println("<script>parent.Pat_Search_Criteria_Frame.document.forms[0].search_in.disabled=true;</script>");			
			out.println("<script>if (parent.Pat_Search_Criteria_Frame.document.forms[0].searchby1 !=null) if (parent.Pat_Search_Criteria_Frame.document.forms[0].searchby1.value =='') parent.Pat_Search_Criteria_Frame.document.forms[0].searchby1.disabled=true;</script>");
			out.println("<script>parent.commontoolbar.location.href='../jsp/PatientSearchToolBar.jsp'</script>");		
			out.println("<script>var msg = parent.Pat_Search_Criteria_Frame.getMessage('PAT_MERGED_VALID','MP');msg= msg.replace('#','"+valid_patient_id+"');alert(msg);</script>");			out.println("<script>parent.Pat_Search_Criteria_Frame.document.forms[0].Patient_Id.value='"+valid_patient_id+"';parent.Pat_Search_Toolbar_Frame.document.forms[0].Search.focus();</script>");
			proceed=false;
			if (Valid_pstmt!=null)Valid_pstmt.close();
			if (Valid_rSet!=null)Valid_rSet.close();
	}else{
		proceed=true;
	}
}

/***Ends***/
if (proceed){
String selectFileds	=	"Select field_name from mp_pat_search_result_lang_vw where language_id ='"+locale+"' and field_select='Y' order by field_order";
/*******
Note=2=>
1.The Fields which are going tobe select those Are Dynamic.
2.i.e. The Following Code will construct Select Clause the fields which are selected from the Table MP_PAT_SEARCH_RESULT_LANG_VW
3.Beacuse, Painting The Result Headings  coloumns selected from the above table only.
***********/
boolean fileNoResultFlag=true;
boolean fileFlag_yn=false;
boolean oldfileFlag_yn=false;
Select_pstmt	 =	conn.prepareStatement(selectFileds);
Select_rSet	=	Select_pstmt.executeQuery();
while(Select_rSet!=null&&Select_rSet.next()){
	if (Select_rSet.getString("field_name").equals("Patient_Name")){
			Dyn_selectClause.append("a.patient_name,");
		}
	if (Select_rSet.getString("field_name").equals("Sex")){
			Dyn_selectClause.append("a.sex,");
		}
	if (Select_rSet.getString("field_name").equals("Date_of_Birth")){
			Dyn_selectClause.append("to_char(a.date_of_birth, 'dd/mm/yyyy')date_of_birth,");
		}
	if (Select_rSet.getString("field_name").equals("National_ID_No")){
			Dyn_selectClause.append("a.national_id_no,");
		}
	if (Select_rSet.getString("field_name").equals("Second_Name")){
			Dyn_selectClause.append("a.Second_Name,");
		}
	if (Select_rSet.getString("field_name").equals("Third_Name")){
			Dyn_selectClause.append("a.Third_Name,");
		}
	if (Select_rSet.getString("field_name").equals("Nationality_Code")){
			Dyn_selectClause.append("(case when a.nationality_code is not null then (select long_desc from mp_country_lang_vw where country_code = a.nationality_code and language_id ='"+locale+"') end) nationality_desc,");
		}
	if (Select_rSet.getString("field_name").equals("Res_Area_Code")){
			Dyn_selectClause.append("(case when a.res_area_code is not null then (select long_desc from mp_res_area_lang_vw where res_area_code = a.res_area_code and language_id = '"+locale+"') end) res_area_desc,");
		}	
			if (Select_rSet.getString("field_name").equals("File_No")){
							Dyn_selectClause.append("'' File_No,");

			}
			if (Select_rSet.getString("field_name").equals("Old_File_No")){
			Dyn_selectClause.append("'' Old_File_No,");
			}

		if (Select_rSet.getString("field_name").equals("File_No")){
			if(fileNoResultFlag)
				Dyn_selectClause.append("case when (select count(1) from mr_pat_file_index where patient_id=a.patient_id ) < 2 then (select file_no||','||old_file_no||','||d.facility_name from mr_pat_file_index e, sm_facility_param_lang_vw d where e.facility_id = '"+logged_facility+"' and e.facility_id = d.facility_id and d.language_id = '"+locale+"' and e.patient_id = A.patient_id ) else '' end mr_section,");
			fileNoResultFlag=false;
			fileFlag_yn=true;
		}
	/*if ((Select_rSet.getString("field_name").equals("Old_File_No") || Select_rSet.getString("field_name").equals("Facility_id"))){
			if(fileNoResultFlag)
				Dyn_selectClause.append("case when (select count(1) from mr_pat_file_index where patient_id=a.patient_id ) < 2 then (select file_no||','||old_file_no||','||d.facility_name from mr_pat_file_index e, sm_facility_param_lang_vw d where e.facility_id = '"+logged_facility+"' and e.facility_id = d.facility_id and d.language_id = '"+locale+"' and e.patient_id = A.patient_id ) else '' end mr_section,(select facility_name from sm_facility_param_lang_vw where facility_id = A.Pref_Facility_Id  and language_id = '"+locale+"') Pref_Fac_Name,");
			fileNoResultFlag=false;
			oldfileFlag_yn=true;
		}*/
	if (Select_rSet.getString("field_name").equals("EMEG_REGN_YN")){
			Dyn_selectClause.append("a.emeg_regn_yn,");
		}
	if (Select_rSet.getString("field_name").equals("Contact1_No")){
			Dyn_selectClause.append("a.contact1_no,");
		}
	if (Select_rSet.getString("field_name").equals("ADDL_FIELD2")){
			Dyn_selectClause.append("b.addl_field2,");
		}
	if (Select_rSet.getString("field_name").equals("MOTHER_PATIENT_NAME")){
			Dyn_selectClause.append("a.patient_name mother_patient_name,");
		}
	if (Select_rSet.getString("field_name").equals("Alt_ID1_No")){
			Dyn_selectClause.append("a.alt_id1_no,");
		}
	if (Select_rSet.getString("field_name").equals("Contact2_No")){
			Dyn_selectClause.append("a.contact2_no,");
		}
	if (Select_rSet.getString("field_name").equals("ADDL_FIELD3")){
			Dyn_selectClause.append("b.addl_field3,");
		}
	if (Select_rSet.getString("field_name").equals("ADDL_FIELD4")){
			Dyn_selectClause.append("b.addl_field4,");
		}
	if (Select_rSet.getString("field_name").equals("OTH_ALT_ID_NO")){
			Dyn_selectClause.append("a.oth_alt_id_no,");
		}
	if (Select_rSet.getString("field_name").equals("OTH_ALT_ID_TYPE")){
			Dyn_selectClause.append("a.oth_alt_id_type,");
		}
	/*if (Select_rSet.getString("field_name").equals("Pref_Facility_Id")){
			Dyn_selectClause.append("(case when a.pref_facility_id is not null then (select facility_name from sm_facility_param_lang_vw where facility_id = a.pref_facility_id and language_id = '"+locale+"') end) Pref_Fac_Name,");
		}*/
	if (Select_rSet.getString("field_name").equals("ADDL_FIELD1")){
			Dyn_selectClause.append("b.addl_field1,");
		}
	if (Select_rSet.getString("field_name").equals("PAT_SER_GRP_CODE")){
			Dyn_selectClause.append("(case when a.pat_ser_grp_code is not null then (select long_desc from mp_pat_ser_grp_lang_vw where pat_ser_grp_code = a.pat_ser_grp_code and language_id = '"+locale+"') end) pat_ser_grp_desc,");
		}
	if (Select_rSet.getString("field_name").equals("PATIENT_NAME_LOC_LANG")){
			Dyn_selectClause.append("a.patient_name_loc_lang,");
		}
	if (Select_rSet.getString("field_name").equals("Name_Prefix")){
			Dyn_selectClause.append("a.name_prefix,");
		}
	if (Select_rSet.getString("field_name").equals("FAMILY_ORG_ID")){
			Dyn_selectClause.append("(case when a.family_org_id is not null then (select family_org_name from mp_family_org_lang_vw where family_org_id = a.family_org_id and language_id = '"+locale+"') end) family_org_name,");
		}
	if (Select_rSet.getString("field_name").equals("RELATIONSHIP_TO_HEAD")){
			Dyn_selectClause.append("a.relationship_to_head,");
		}
	if (Select_rSet.getString("field_name").equals("PAT_CAT_CODE")){
			Dyn_selectClause.append("(case when a.pat_cat_code is not null then (select long_desc from mp_pat_category_lang_vw where pat_cat_code = a.pat_cat_code and language_id = '"+locale+"') end) pat_cat_desc,");
		}
	if (Select_rSet.getString("field_name").equals("FAMILY_ORG_SUB_ID")){
			Dyn_selectClause.append("(case when a.family_org_sub_id is not null then (select family_org_sub_name from mp_family_org_sub_lang_vw where family_org_id = a.family_org_id and family_org_sub_id = a.family_org_sub_id and language_id = '"+locale+"') end) family_org_sub_name,");
		}
	if (Select_rSet.getString("field_name").equals("ADDL_FIELD5")){
			Dyn_selectClause.append("b.addl_field5,");
		}
	if (Select_rSet.getString("field_name").equals("First_Name")){
			Dyn_selectClause.append("a.first_name,");
		}
	if (Select_rSet.getString("field_name").equals("Family_Name")){
			Dyn_selectClause.append("a.family_name,");
		}
	if (Select_rSet.getString("field_name").equals("Name_Suffix")){
			Dyn_selectClause.append("a.name_suffix,");
		}
}
/*if(oldfileFlag_yn || fileFlag_yn){
	Dyn_selectClause.append("(SELECT COUNT (1) FROM mr_pat_file_index  WHERE patient_id = a.patient_id) countmrns");
}*/


/******Completion Of The Coloumn Selection*******/


String sub_Whr	 =	"";
int addl_field_cnt=0;
int File_No_field_cnt=0;

final_selectCaluse.append("select a.patient_id,"+Dyn_selectClause.toString()+"a.mother_patient_id,a.Pref_Facility_Id,a.enc_facility_id,a.curr_encounter_id,a.deceased_yn,a.suspend_yn,a.active_yn,a.curr_patient_class");
if(oldfileFlag_yn || fileFlag_yn){
	final_selectCaluse.append(",(SELECT COUNT (1) FROM mr_pat_file_index  WHERE patient_id = a.patient_id) countmrns");
}

/*******Dynamic Tables Building**********************/
//String count_Table="select count(*) count from MP_PAT_SEARCH_RESULT where FIELD_NAME in ('ADDL_FIELD1', 'ADDL_FIELD2', 'ADDL_FIELD3', 'ADDL_FIELD4','ADDL_FIELD5') and FIELD_SELECT=?";
String count_Table="select (SELECT COUNT (*) FROM mp_pat_search_result WHERE field_name IN ('ADDL_FIELD1', 'ADDL_FIELD2', 'ADDL_FIELD3', 'ADDL_FIELD4', 'ADDL_FIELD5') AND field_select = 'Y') addl_field_cnt, (SELECT COUNT (*) FROM mp_pat_search_result WHERE field_name IN ('Old_File_No',    'File_No', 'Facility_Id') AND field_select = 'Y') File_No_field_cnt from dual";

//tble_Cnt_pst	=	conn.Statement(count_Table);
Statement stmt = conn.createStatement();
tble_rSet		=	stmt.executeQuery(count_Table);
if (tble_rSet.next()){
 addl_field_cnt	=	tble_rSet.getInt("addl_field_cnt");
 File_No_field_cnt	=	tble_rSet.getInt("File_No_field_cnt");
}
if(addl_field_Flag && !(file_no_Flag) && addl_field_cnt==0 && File_No_field_cnt==0){
	
	fromClause.append(" from mp_patient a"); // addl_field = no & file_no = no
}else if( (addl_field_cnt!=0 || !(addl_field_Flag)) && (File_No_field_cnt!=0 || file_no_Flag)){
	
	if(file_no_Flag){
		fromClause.append(" from mp_patient a, mp_pat_oth_dtls b"); 
	}else{
		fromClause.append(" from mp_patient a, mp_pat_oth_dtls b");
	}
	sub_Whr	=	" a.patient_id = b.patient_id and ";
	//sub_Whr	=	" a.patient_id = b.patient_id and a.patient_id = c.patient_id and ";
	//sub_Whr	=	" a.patient_id = b.patient_id and a.patient_id = (select patient_id from mr_pat_file_index where file_no = 'MR00000695') and ";
}else if(File_No_field_cnt!=0 || file_no_Flag){
	
	if(file_no_Flag){
		fromClause.append(" from mp_patient a, mr_pat_file_index c ");
		sub_Whr	=	" a.patient_id = c.patient_id and ";
	}else{
		fromClause.append(" from mp_patient a");
	}
}else if((addl_field_cnt!=0 || !(addl_field_Flag))){
	
	fromClause.append(" from mp_patient a, mp_pat_oth_dtls b ");
	sub_Whr	=	" a.patient_id = b.patient_id and  ";
}
	/*if( addl_field_cnt>0 && File_No_field_cnt==0 ) {
	fromClause.append(" from mp_patient a, mp_pat_oth_dtls b ");  // addl_field = yes & file_no = no
	sub_Whr	=	" a.patient_id = b.patient_id and  ";
	}
	
	if (addl_field_cnt==0 && File_No_field_cnt>0){
	fromClause.append(" from mp_patient a, mr_pat_file_index c "); // addl_field = no & file_no = yes
	sub_Whr	=	" a.patient_id = c.patient_id and ";
	}

	if ( addl_field_cnt>0 && File_No_field_cnt>0){
	fromClause.append(" from mp_patient a, mp_pat_oth_dtls b, mr_pat_file_index c "); // addl_field = yes & file_no = yes
	sub_Whr	=	" a.patient_id = b.patient_id and a.patient_id = c.patient_id and ";
	}else{
		if(addl_field_cnt==0 && !(addl_field_Flag)){
			fromClause.append(" from mp_patient a, mp_pat_oth_dtls b "); 
		}
	}*/



/*******Completion Of Dynamic Table**************/

whereClause.append("  where "+sub_Whr+"  ");



/*Where Clause Constructed Based Upon Patient ID, National_ID_No,Familiy_No,MRN,OldFileNo,New Born Suffix & Nationality **/

if (!pat_id.equals("")){
whereClause.append("   a.Patient_id like trim('"+pat_id+"')||'%' ");
strAND="AND";
}																														

 if (!National_Id_No.equals("")){
whereClause.append(" "+strAND+" a.National_Id_No like trim('"+National_Id_No+ "') ||'%' ");
strAND="AND";
}																														

 if (!Family_No.equals("")){
whereClause.append(""+strAND+" a.Family_Link_No like trim('"+Family_No+"') ||'%' ");
strAND="AND";
} 																														 

if (!file_no.equals("")){
//whereClause.append(" "+strAND+" c.file_no = '"+file_no+"'  ");
whereClause.append(" "+strAND+" a.patient_id =  (select patient_id from mr_pat_file_index where file_no = '"+file_no+"')");
strAND="AND";
}																														
if (!old_file_no.equals("")){
//whereClause.append(""+strAND+" c.old_file_no = '"+old_file_no+"'  ");
whereClause.append(" "+strAND+" a.patient_id =  (select patient_id from mr_pat_file_index where old_file_no = '"+old_file_no+"')");
strAND="AND";
}																												

 /*if (!newBorn_sufx.equals("")&&!Alt_Id1_No.equals("")){
whereClause.append(" "+strAND+"  newborn_id_no_suffix=trim('" + newBorn_sufx + "')");
strAND="AND";
}*/																												 

if (!Nationality.equals("")){
whereClause.append(" "+strAND+" a.Nationality_code='"+Nationality+"' ");
strAND="AND";
}	
/***Ends******/

/*Where Clause Counstructed Based Upon Alt ID No1, 2,3,4*/
if (!Alt_Id1_No.equals("")){
whereClause.append(" "+strAND+" a.Alt_Id1_No like trim('"+ Alt_Id1_No+"') ||'%'");
strAND="AND";
}	
if (!Alt_Id2_No.equals("")){
whereClause.append(" "+strAND+" a.Alt_Id2_No like trim('"+Alt_Id2_No+"') ||'%' ");
strAND="AND";
}																														

if (!Alt_Id3_No.equals("")){
whereClause.append(" "+strAND+" a.Alt_Id3_No like trim('"+Alt_Id3_No+"') ||'%' ");
strAND="AND";
}																														

if (!Alt_Id4_No.equals("")){
whereClause.append(" "+strAND+" a.Alt_Id4_No like trim('" +Alt_Id4_No+"') ||'%' ");
strAND="AND";
}																														
/**Ends***/

/*if (!Family_No.equals("")){
whereClause.append("  "+strAND+" Family_Link_No like trim('" +Family_No+"') ||'%' ");
strAND="AND";
}	*/																													

/*Where Clause Counstructed Based Upon First Name,Second Name,Third Name,Familiy Name*/
if (!First_Name.equals("")){
whereClause.append(" "+strAND+" UPPER(a.First_Name) like UPPER('"+First_Name+"%') ");
strAND="AND";
}																														 

if (!Second_Name.equals("")){
whereClause.append(" "+strAND+" upper(a.second_name_loc_lang) like upper('"+Second_Name+"%'");
strAND="AND";
}																														

if (!Third_Name.equals("")){
whereClause.append(" "+strAND+" UPPER(a.Third_Name) like UPPER('"+Third_Name+"%')  ");
strAND="AND";
}																														

if (!Family_Name.equals("")){
whereClause.append("  "+strAND+" UPPER(a.Family_Name) like UPPER('"+Family_Name+"%')");
strAND="AND";
}	
/***Ends**/
/*Where Clause Constructed Based Upon Sex,DOB,Contact,Mode,Area,Soundex*/
if (!Sex.equals("")){
		if (Sex.equals("M")){
			whereClause.append(" "+strAND+" a.Sex='M' ");
		}else if (Sex.equals("F")){
			whereClause.append(" "+strAND+"  a.Sex='F' ");
		}else if (Sex.equals("U")){
			whereClause.append(" "+strAND+"  a.Sex='U' ");
		}else if (Sex.equals("A")){
			whereClause.append(" "+strAND+"  a.Sex like '%' ");
		}
		strAND="AND";
}																														

if (!By.equals("")){
	if (By.equals("D") && !DATE.equals("")){
	whereClause.append(" "+strAND+"  trunc(a.Date_Of_Birth) = to_date('" + DATE + "','dd/mm/yyyy') ");
	strAND="AND";
	}
	else if (By.equals("Y")){
			if (FromDate.equals("") && !ToDate.equals("")){
					whereClause.append(" "+strAND+" a.Date_Of_Birth between to_date('" + FromDate + "','dd/mm/yyyy') and to_date('" + ToDate + "','dd/mm/yyyy')");
					strAND="AND";
			}
	}
//	strAND="AND";
}		
			
if (!Mode.equals("")&&!Contact_No.equals("")){
whereClause.append(" "+strAND+" (a.Contact1_Mode=trim('" + Mode + "') and a.Contact1_No=trim('" + Contact_No + "')) or  (a.Contact2_Mode=trim('" + Mode+ "') and a.Contact2_No=trim('" + Contact_No  + "'))or(a.Contact3_Mode=trim('" + Mode+ "') and a.Contact3_No=trim('" + Contact_No  + "')) or (a.Contact4_Mode=trim('" + Mode+ "') and a.Contact4_No=trim('" + Contact_No  + "')) or (a.Contact5_Mode=trim('" + Mode+ "') and a.Contact5_No=trim('" + Contact_No  + "'))");
strAND="AND";
}

if (!Area.equals("")){
whereClause.append( " "+strAND+"  a.Res_Area_Code=trim('"+Area+"') " );
strAND="AND";
}	

 if (!First_Name.equals("") && !Second_Name.equals("")){
	String cmpltName=First_Name+Second_Name;
	      if (Soundex.equals("E")){
				whereClause.append("a.ethnic_sndx_first_second=ethnic_soundex('" +cmpltName+ "')");
		  }
		  else if (Soundex.equals("G")){
			  whereClause.append("a.generic_sndx_first_second=soundex('"+cmpltName+"')");
		  }																														 
strAND="AND";
}
/******Ends*********/

/*Where Clause Constructed Based Upon  Addtional Fields 1,2 3,4.5 */
if (!addl_field1.equals("")){
whereClause.append(" "+strAND+"  UPPER(b.addl_field1) like UPPER('"+addl_field1+"') || '%'");
strAND="AND";
}												 
if (!addl_field2.equals("")){
whereClause.append(" "+strAND+"  UPPER(b.addl_field2) like UPPER('"+addl_field2+"') || '%'");
strAND="AND";							
}	
if (!addl_field3.equals("")){
whereClause.append(" "+strAND+"  UPPER(b.addl_field3) like UPPER('"+addl_field3+"') || '%'");
strAND="AND";
}	
if (!addl_field4.equals("")){
whereClause.append(" "+strAND+"  UPPER(b.addl_field4) like UPPER('"+addl_field4+"') || '%'");
strAND="AND";
}	
if (!addl_field5.equals("")){
whereClause.append(" "+strAND+"  UPPER(b.addl_field5) like UPPER('"+addl_field5+"') || '%'");
strAND="AND";
}	
/******Ends**********/

/*Where Clause Constructed Based Upon Ethinic Group,Other Alt ID,Other Alt ID_No */

if (!ethnic_group.equals("")){
whereClause.append(" "+strAND+" a.race_code='"+ethnic_group+ "' ");
}																														


if (!other_alt_id.equals("")){
whereClause.append(" "+strAND+" a.oth_alt_id_type='"+ other_alt_id + "' ");
strAND="AND";
}																														 

if (!other_alt_Id_no.equals("")){
whereClause.append( " "+strAND+" a.oth_alt_Id_no='"+other_alt_Id_no+ "'  ");
strAND="AND";
}																														
/*******Ends*******/

/*Where Clause Constructed Based Upon sltDocType, txtDocType */

// naren - check and remove the below SQL
/*if (!sltDocType.equals("")&&!txtDocType.equals("")){
whereClause.append(" patient_id IN (SELECT patient_id FROM MP_PAT_DOCUMENTS WHERE (doc1_type='" + sltDocType+ "' AND doc1_num ='"+txtDocType+"' ) OR (doc2_type= '"+sltDocType+"' AND doc2_num= '"+txtDocType+"' ) OR (doc3_type='"+sltDocType+"' AND doc3_num= '"+txtDocType+"' ) OR (doc4_type='"+sltDocType+"' AND doc4_num= '"+txtDocType+"' ))" );
strAND="AND";
}*/
/***Ends******/

/*Where Clause Constructed Based upon Organization,Familiy Organization Sub Organization*/
if (!family_org_membership.equals("")){
whereClause.append("  "+strAND+" a.family_org_membership='"+family_org_membership+ "'  ");
strAND="AND";
}														

if (!organization.equals("")){
whereClause.append("  "+strAND+" a.family_org_id='"+Orgnization_id+"' ");
}														
if (!sub_organization.equals("")){
whereClause.append( "  "+strAND+"  a.family_org_sub_id='"+sub_Organisation+"' and  a.family_org_id = '"+sub_organization+"'");
}	
/*******Ends********/
// naren - check and remove the below SQL
/*if (!mother_maiden_name.equals("")){
whereClause.append(  " "+strAND+" a.mother_patient_id is not null and  exists ( select 1 from mp_patient where patient_id = a.mother_patient_id and upper(patient_name) like upper('%"+mother_maiden_name+"%'))");
strAND="AND";
}*/													
/*Where Clause Constructed Based Upon FirstName Loc Lang,Second Name Loc Lang,Third Name Loc Lag,Familiy Name Loc Lang*/
if (!first_name_loc_lang.equals("")){
whereClause.append(  " "+strAND+" upper(a.first_name_loc_lang) like upper('"+first_name_loc_lang+"%' )");
strAND="AND";
}													 

if (!second_name_loc_lang.equals("")){
whereClause.append(  " "+strAND+" upper(a.second_name_loc_lang) like upper('"+second_name_loc_lang+"%'))");
strAND="AND";
}													

if (!third_name_loc_lang.equals("")){
whereClause.append(  " "+strAND+" upper(a.third_name_loc_lang) like upper('"+ third_name_loc_lang+"%')");
strAND="AND";
}													

if (!family_name_loc_lang.equals("")){
whereClause.append(  " "+strAND+" upper(a.family_name_loc_lang) like upper('"+ family_name_loc_lang+"%')");
strAND="AND";
}		
/******Ends******/


if (!patient_series.equals("")){
whereClause.append(" "+strAND+"  a.PAT_SER_GRP_CODE='"+patient_series+"' ");
strAND="AND";
}													
/*Where Clause Constructed Based Upon Paient Series Group Code, Deceased_Yn,Suspend_Yn,Active_Yn,*/
if (deceased_yn.equals("Y")){
whereClause.append(" "+strAND+"  a.DECEASED_YN='"+deceased_yn+"' ");
strAND="AND";
}											      

if (suspend_yn.equals("Y")){
whereClause.append(" "+strAND+"  a.SUSPEND_YN='"+suspend_yn+"' ");
strAND="AND";
}												

if (active_yn.equals("Y")){
whereClause.append(" "+strAND+"  a.ACTIVE_YN='"+active_yn+"' ");
strAND="AND";
}												
/****Ends*****/
/*Where Clause Constructed Based Upon Reg_Mode,IP_Yn,DC_Yn,OP_Yn,EM_Yn*/
//String Qry_Ip	=	"";
//String Qry_Dc	=	"";
//String Qry_Op	=	"";
//String Qry_Em	=	"";
String Sub_qry="";
String Comma="";
if (!reg_mode.equals("")){
whereClause.append(" "+strAND+"  a.EMEG_REGN_YN like ('"+reg_mode+"') ");
strAND="AND";
}												

if (IP_yn.equals("IP")){
Sub_qry=" "+strAND+"  a.CURR_PATIENT_CLASS in('"+IP_yn+"')";
Comma=",";
//whereClause.append(" "+strAND+"  CURR_PATIENT_CLASS in('"+IP_yn+"') ");
//strAND="";
}											

 if (DC_yn.equals("DC")){
	 Comma=",";
Sub_qry=" "+strAND+"  a.CURR_PATIENT_CLASS in('"+IP_yn+"'"+Comma+"'"+DC_yn+"') ";

//whereClause.append(" "+strAND+"  CURR_PATIENT_CLASS in('"+IP_yn+"','"+DC_yn+"') ");
//strAND="";
//strOR="OR";

}												

 if (OP_yn.equals("OP")){
Comma=",";
Sub_qry="  "+strAND+" a.CURR_PATIENT_CLASS in('"+IP_yn+"'"+Comma+"'"+DC_yn+"'"+Comma+"'"+OP_yn+"') ";

//whereClause.append(" "+strAND+" CURR_PATIENT_CLASS in('"+IP_yn+"','"+DC_yn+"','"+OP_yn+"') ");
//strAND="";
//strOR="OR";
}												

 if (EM_yn.equals("EM")){
Comma=",";
Sub_qry="  "+strAND+" a.CURR_PATIENT_CLASS in('"+IP_yn+"'"+Comma+"'"+DC_yn+"'"+Comma+"'"+OP_yn+"'"+Comma+"'"+EM_yn+"') ";
//whereClause.append(" "+strAND+" CURR_PATIENT_CLASS in('"+IP_yn+"','"+DC_yn+"','"+OP_yn+"','"+EM_yn+"') ");
//strAND="";
//strOR="OR";
}

whereClause.append(Sub_qry);

/**Ends***/
/*************************Total Construction Of Where Clause Ends Here**************************************/

/*===Building Of Final Query which has to send to EJB===*/

finalQuery=final_selectCaluse.append(fromClause);
/*
Note==3=>
1.When Navigating Through Pages (i.e.Operating Through Numbers on Top),
These Pageflag,pagewhereClause,pageWhere are used To Store Same Where Caluse as  From The Criteria Page.
2.From Very First Time Controll Will be in Else Condtion.
*/
Pageflag		=	checkForNull(request.getParameter("Pageflag"),"N");
pageWhere	=	checkForNull(request.getParameter("PagewhereClause"));
if(pageWhere.indexOf("^")>=0){
pageWhere=pageWhere.replace('^','%');
}
if (Pageflag.equals("Y")){
pagewhereClause=new StringBuffer(pageWhere);
whereClause=pagewhereClause;
finalQuery=finalQuery.append(whereClause);
}
else{
finalQuery=finalQuery.append(whereClause);
}
/*****Ends*******/

/*Note==4==>
1.Operating through Headers Of The Result(i.e.Patient Name,Sex, etc.. To Arrange in order)
These Vairables final_sql,orderFlag,OrderBuffer are used To Store Same Where Caluse as  From The Criteria Page.
2.From Very First Time Controll Will be in Else Condtion.
 */
 final_sql		= checkForNull(request.getParameter("final_sql"));
 orderFlag		= checkForNull(request.getParameter("orderFlag"),"N");
 Hdr_Order	= checkForNull(request.getParameter("Hdr_Order"),"");
OrderwhereClause	=checkForNull(request.getParameter("OrderwhereClause"));

if (orderFlag.equals("Y")){
OrderBuffer=new StringBuffer(OrderwhereClause);
orderby=" order by "+Hdr_Order;
whereClause=OrderBuffer;
selectClause=selectClauseReq;
final_sql=selectClause.toString();
}
else{
	 final_sql = finalQuery.toString();
	 selectClause=final_sql;
}
/*****Ends******/

	
	if(final_sql == null) final_sql = "";
try {                   
			String CountSql = "";
			CountSql = "select count(1) total from ("+final_sql+")";  
			Count_pstmt=conn.prepareStatement(CountSql);
			Count_rSet = Count_pstmt.executeQuery();             
			if (Count_rSet.next()){
				maxRecord = Count_rSet.getInt("total");
			}		
			Hit=Integer.parseInt(request.getParameter("Hit_Limit"));
			if(Hit==0) Hit = maxRecord ;
			if (maxRecord < Hit){
				Hit_for_buttons = maxRecord;
			}else{
				Hit_for_buttons = Hit;
			}

	}
           catch( Exception e ) { Hit = maxRecord ; }

	
/*//	StringBuffer finalSqlBuffer1 = new StringBuffer((final_sql.substring(0,final_sql.lastIndexOf("order by ")+9)).trim());
//	StringBuffer finalSqlBuffer2 = new StringBuffer();
	String ord_sql = final_sql.substring(final_sql.lastIndexOf("order by ")+9,final_sql.length()).trim();

	String[] sqlToken = ord_sql.split("\\s");
     for (int x=1; x<sqlToken.length; x++)
	 {
        finalSqlBuffer2.append(" "+sqlToken[x]);
	 }*/
	/*String totalpercentage =  request.getParameter("totalpercent");
	if(totalpercentage ==null) totalpercentage="0";*/

//	int totalpercent = Integer.parseInt(totalpercentage);

	String TotalNoRec=request.getParameter("TotalNoRecords");
	if (TotalNoRec==null) TotalNoRec="0";
	TotalNoRecords = Integer.parseInt(TotalNoRec);

	String photo[]=null;
	//String path="";
	
    

            _bw.write(_wl_block6Bytes, _wl_block6);
  String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Hit));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resp_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(win_top));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Hit));
            _bw.write(_wl_block16Bytes, _wl_block16);

	/*****Once the totalCount Of the Of CountSql more than Or Equals 1 then Submision to EJB and Painting Result will Be allowed *************/
	String multiRec = "";
	if (function_id.equals("") && (search_in.equals("B")||search_in.equals("D")))
		multiRec = "Y";
	else
		multiRec = "N";

      if ((maxRecord == 1) && ((pat_id.length()!=0) || (National_Id_No.length()!=0 )) && (srr.equals("Y") && multiRec.equals("N")))
            { 
		 out.println("<script>parent.commontoolbar.location.href='../jsp/DupPatientSearchToolBar.jsp'</script>");
		out.println("<script>parent.Pat_Search_Toolbar_Frame.defaultSetting();</script>");
		out.println("<script>parent.Pat_Search_Criteria_Frame.document.forms[0].search_in.disabled=true;</script>");
String w_cls="";
String w_flag="N";
			if (pat_id.length()!=0)
                {
                    w_cls = w_cls + "patient_id like '"+pat_id+"%'";
                    w_flag="Y";
                }

                if (National_Id_No.length()!= 0 )
                {
                    if (w_flag.equals("Y"))
                        w_cls= w_cls+" and NATIONAL_ID_NO like '"+National_Id_No+"'";
                    else
                        w_cls= w_cls+" NATIONAL_ID_NO like '"+National_Id_No+"'";
                }
             		String deceased ="";
					String suspend="";
					String active ="";
                Check_pstmt =conn.prepareStatement("Select A.patient_id  patient_id, Deceased_Yn, Suspend_Yn, Active_Yn from mp_patient A where "+w_cls+""); 
//				Check_pstmt.setString(1,pat_id);
				rs7=Check_pstmt.executeQuery();
                rs7.next();
                pat_id = rs7.getString("patient_id");
                 deceased = rs7.getString("Deceased_Yn");
                if(deceased==null)deceased="N";
                 suspend  = rs7.getString("Suspend_Yn");
                if(suspend==null)suspend="N";
                active= rs7.getString("Active_Yn");
                if(active==null)active="Y";

				if(deceased.equals("N")){
					if(suspend.equals("Y") && !func_act.equals("SUSP") && !func_act.equals("RECD") && !func_act.equals("VIEW")){
						out.println("<script>alert(getMessage('PATIENT_SUSPENDED','MP'));</script>");
					}
					else if(active.equals("N") && !func_act.equals("ACTV") && !func_act.equals("RECD") && !func_act.equals("VIEW"))
                    out.println("<script>alert(getMessage('PATIENT_INACTIVE','MP'));</script>");
					else{
						
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block20Bytes, _wl_block20);

					}
				}
                else{
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block23Bytes, _wl_block23);

				}
				out.println("<script>");
				out.println("for (var i=0;i<parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.elements.length;i++) {				parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.elements[i].disabled=false;}");
				out.println("parent.Pat_Search_Toolbar_Frame.document.search_toolbar.Search.disabled = false;");
				out.println("if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.maintain_doc_or_file.value == 'D') { ");
				out.println("parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN.disabled = true;");
				out.println("parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.OldFileNo.disabled = true; }");
				out.println("parent.Pat_Search_Criteria_Frame.enableRegister()");
				out.println("</script>");
				if (enablegenderyn.equals("N"))	
					out.println("<script>parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Sex.disabled=true;</script>");

				//Added by kumar on 16/03/2003 for disabling the searchby when soundex is selected.
				out.println("<script>if (parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.searchby !=null) if (parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.searchby.value =='') parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.searchby.disabled=true;</script>");

				/*if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || 	function_id.equals("DR_MERGED_PATIENT_ID") || function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
					out.println("<script>parent.frames[1].document.forms[0].search_in.disabled=true;</script>");	
				out.println("<script>parent.frames[0].location.href='../jsp/PatientSearchToolBar.jsp'</script>");	*/		
            }
	else if(maxRecord >= 1) {
		out.println("<script>parent.commontoolbar.location.href='../jsp/DupPatientSearchToolBar.jsp'</script>");
//		out.println("<script>parent.Pat_Search_Toolbar_Frame.defaultSetting();</script>");
		out.println("<script>parent.Pat_Search_Criteria_Frame.document.forms[0].search_in.disabled=true;</script>");
//		out.println("parent.Pat_Search_Toolbar_Frame.defaultSetting();


            _bw.write(_wl_block24Bytes, _wl_block24);

	
	PatSearchRemote patSearchRemote = null;
	PatSearchHome patSearchHome = null;
    /* Modified on 08/11/2004 */

	InitialContext context = new InitialContext();
	Properties props = ( Properties)session.getValue("jdbc");
	Object homeObject = context.lookup("java:comp/env/PatSearch");
	patSearchHome = (PatSearchHome)PortableRemoteObject.narrow(homeObject,PatSearchHome.class);
	patSearchRemote = patSearchHome.create();
			
//	String logged_facility = (String) session.getValue("facility_id");

	/* 2 More parameters have been added in the getSearchTable method 
		Properties -	 To obtain the connection in PatSearchManager
		threshold  -	 to display the mumber of records
	*/
	String  strTable ="";
	String  strDtl ="";
	HashMap   strMap =null;
	
	try
	{
		if (final_sql!=null && !final_sql.equals("")){
/*Note==5==>For Better Performance  Order By Was  Appended At Last and Passed to EJB*/
			final_sql=final_sql+orderby;
/*****/
		//long time3=Calendar.getInstance().getTimeInMillis();
		strMap = patSearchRemote.getSearchTable(func_act,logged_facility, final_sql,start,totalpercent,function_id,search_in,act_yn,photo,alignment,othlang,props,searchThreshold);
		//long time4=Calendar.getInstance().getTimeInMillis();

		sbrfinal.setLength(0);
	      
	
	}

	}
catch(Exception e)
{
	e.printStackTrace();
}

	/* Modify End on 08/11/2004 */ 
	if (strMap !=null)
	{
		strTable =(String)strMap.get("PAT_ID");
		strDtl = (String)strMap.get("PAT_DTLS");				
	}
	      out.println("<Table border='0' cellpadding='1' ><tr><td class='WHITE'><div id='patId' >");
	      out.println(strTable);
	      out.println("</div></td><td class='WHITE'><div id='patDtl' >");
	      out.println(strDtl);
	      out.println("</div></td></tr></Table>");
	      out.println("<CENTER>");
          out.println("<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='red'><table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'><tr><td width='100%' id='t'></td></tr></table></div>");

	if ( !(start <= 1) ) 
    {
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Hit));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Hit));
            _bw.write(_wl_block27Bytes, _wl_block27);

	}
    else 
    {
		
            _bw.write(_wl_block28Bytes, _wl_block28);

            String display_anchors = "";  
            if(mode.equals(""))
            {                                               
				maxDisplay = maxRecord/searchThreshold;                             
                if (maxRecord > 10)
				{
					maxDisplay = Math.ceil(maxDisplay); 
				}else
				{
					maxDisplay = Math.floor(maxDisplay);
				}
                if (maxDisplay>5) maxDisplay1=5; else maxDisplay1 = maxDisplay;
                int noofRec = 0;
                display_anchors = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";             
                for (int i=0;i<maxDisplay1;i++) 
				{
					
					noofRec =noofRec +searchThreshold;
                    display_anchors = display_anchors +"<b><a name='str"+noofRec+"' href='javascript:parent.Pat_Search_Criteria_Frame.passURL("+noofRec+")'>"+(i+1)+"</a></b>";
                    display_anchors = display_anchors +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                }											
			}
            
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(display_anchors));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxDisplay));
            _bw.write(_wl_block32Bytes, _wl_block32);

	}
            _bw.write(_wl_block33Bytes, _wl_block33);
}
		else{	  
            _bw.write(_wl_block34Bytes, _wl_block34);
}
	
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(start));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(end));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(maxDisplay));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(maxDisplay1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(searchThreshold));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(search_in));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(func_idpassed));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(allow_nb_review));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(view_pat_photo_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(Hit));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(National_Id_No));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(win_top));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(act_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(srr));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(old_file_no_where));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(file_no_where));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(old_file_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(usePatIDIndex));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(TotalNoRecords));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(enablegenderyn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(finalQuery.toString()));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(whereClause.toString()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(selectClause.toString()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(func_idpassed));
            _bw.write(_wl_block68Bytes, _wl_block68);
 }//End OF Final Proceed 
}//Final Try
			catch(Exception e){
				out.println("Exception In DupPatientIDDisplay.jsp Main Catch");
				e.printStackTrace();
	}//End OF Catch
		finally{
			if (Count_pstmt!=null)Count_pstmt.close();
			if (Count_rSet!=null)Count_rSet.close();
			if (Valid_pstmt!=null)Valid_pstmt.close();
			if (Valid_rSet!=null)Valid_rSet.close();
			if (Select_pstmt!=null)Select_pstmt.close();
			if (Select_rSet!=null)Select_rSet.close();
			if (tble_Cnt_pst!=null)tble_Cnt_pst.close();
			if (tble_rSet!=null)tble_rSet.close();
//			orderByCaluse.clear();
		if(conn!=null)ConnectionManager.returnConnection(conn,request);
	}//End OF Finally

            _bw.write(_wl_block69Bytes, _wl_block69);
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
