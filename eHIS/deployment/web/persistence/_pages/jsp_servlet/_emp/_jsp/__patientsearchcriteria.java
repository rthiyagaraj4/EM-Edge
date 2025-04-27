package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patientsearchcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatientSearchCriteria.jsp", 1743068575396L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<!-- Last Modified Date Time : 9/23/2005 11:28 AM -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eMP/js/SmartCard.js\" language=\"JavaScript\"></Script>\n\n<!-- Added by Ashwin K for AAKH-CRF-0150-->\n\t<Script src=\"../../eMP/js/SmartCard01.js\" language=\"JavaScript\"></Script>\n\n<Script src=\"../../eXH/js/ExternalApplication.js\" language=\"JavaScript\"></Script><!--Added by kamatchi S form MOHE-CRF-0016.1 on 26-AUG-2020-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\t\n<Script src=\"../../eMP/js/json02.js\"></Script>\n<Script src=\"../../eMP/js/jquery.min.js\"></Script>\t\n<!-- Added By Ashwin K for AAKH-CRF-0150 -->\n<script  src=\"../../eCommon/js/jquery-ui.js\" language=\"JavaScript\"></script>  \n<link href=\"../../eCommon/html/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\">\n<!-- Ended By Ashwin K for AAKH-CRF-0150 -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<Script language=\"JavaScript\"src=\"../../eCommon/js/DateUtils.js\" ></Script>\t\n \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>\n    <head>\n        <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n          \n        <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>       \n\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n        <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientSearch.js\'></Script>\n       <Script language=\"JavaScript\">\n        </Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n\t\t<!--Added by Ashwin K for AAKH-CRF-0150 -->\n\t <script>\n\t\tfunction MButton_click_PatSearch()\n\t\t\t{\n\t\t\tvar res = PatSearch_ReadDF1_onclick(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =");\n\t\t\tvar arr = res.split(\"!~\");\n\t\t\t//alert(\"arr length \"+arr.length);\n\t\t\tvar res_natid = arr[0].replace(/^\\s+|\\s+$/gm,\'\');\n\t\t\tvar res_mobno = arr[1].replace(/^\\s+|\\s+$/gm,\'\');\n\t\t\t$.ajax({\n\t\t\ttype: \"POST\",\n\t\t\turl: \"../../eMP/jsp/getPatientCount.jsp\",\n\t\t\tdata: {\n\t\t\t\tNatID : res_natid,\n\t\t\t\tsmart_data : res\t\n\t\t\t},\n\t\t\tasync: false\n\t\t})\n\t\t.done (function(data, textStatus, jqXHR) { \n\t\t});\t\n\t\t}\n\n\t\t\t$(document).ready(function()\n\t\t\t\t{\n\t\t\t\t$(\"#M_Btn\").prop(\'disabled\', false);\n\t\t\t\t$(\"#National_Id_No\").prop(\'disabled\', true);\n\t\t\t\t$(\"#EmiratesID_edit\").click(function() {\n\t\t\t\tif($(\'#EmiratesID_edit\').is(\':checked\'))\n\t\t\t\t{\n\t\t\t\tvar auth_userEmirates = EditEmiratesID_authScr();\n\t\t\t\t//alert(\"auth_userEmirates =\"+auth_userEmirates);\n\t\t\t\tif(auth_userEmirates == true)\n\t\t\t\t\t{\n\t\t\t\t\t$(\"#National_Id_No\").prop(\'disabled\', false);\n\t\t\t\t\t$(\"#M_Btn\").prop(\'disabled\', true);\n\t\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t$(\'#EmiratesID_edit\').prop(\'checked\', false);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t$(\"#National_Id_No\").prop(\'disabled\', true);\n\t\t\t\t\t$(\"#M_Btn\").prop(\'disabled\', false);\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t});\n\n\nasync function EditEmiratesID_authScr()\n{\t\n\tvar retVal=new Array();\n\tvar dialogHeight= \"10\" ;\n\tvar dialogWidth\t= \"22\" ;\n\tvar dialogTop = \"225\" ;\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\tretVal =await window.showModalDialog(\"../../eSM/jsp/AuthorizeMain.jsp?mode=s\",arguments,features);\n\treturn retVal;\n\n}\n\t\t</script>\n<!-- Ended By Ashwin K for AAKH-CRF-0150 -->\n    </head>         \n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\n\n    <body class=\'content\' topmargin=\'0\' OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onLoad=\"DefaultSelect(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');dfltPatClass(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');\"> \n    <form name=\"Advnc_Patient_Search_Form\" id=\"Advnc_Patient_Search_Form\" id=\"DupPatForm\" method=\'post\' action=\'../../eMP/jsp/PatientSearchCriteria.jsp\' >\n\t<input type=\"hidden\" name=\"maintain_doc_or_file\" id=\"maintain_doc_or_file\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type =\'hidden\' name=\'family_org_id_accept_yn\' id=\'family_org_id_accept_yn\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></input>\n\t<input type =\'hidden\' name=\'func_idpassed\' id=\'func_idpassed\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></input>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\n            <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\">\n              <tr>\n                    <td width=\'100%\' class=\"BORDER\" valign=top>\n\n\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\">\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"fields\" ><input type=\"text\" name=\"Patient_Id\" id=\"Patient_Id\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onFocus=\"MoveFocus(2)\" onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"makeValidQueryCriteria(this);ChangeCase(this)\" > &nbsp;\n\t\t\t\t\t\t\t\t\t\t<select name=\"patient_id_search_by\" id=\"patient_id_search_by\">\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"S\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"E\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"C\" selected>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td> \n\t\t\t\t\t\t\t\t\t<td class=\"label\"><input type=\"text\" name=\"abha_pat_id\" id=\"abha_pat_id\"     value=\'\' size=\'20\' >&nbsp;&nbsp;&nbsp;<input type=button value=\'S\' id=\'S_Btn\' name=\'S_Btn\' id=\'S_Btn\' class= \'button\' onClick=\"scanAndShareAbhaId(\'\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');\"/></td>\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td nowrap align=\'right\' class=\"label\" nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<!-- Added  id=\"National_Id_No\" by Ashwin K for AAKH-CRF-0150 -->\n\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"15%\">&nbsp;&nbsp;<input type=\"text\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" id=\"National_Id_No\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" name=\"National_Id_No\" size=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" maxlength=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" \n\t\t\t\t\t\t\t\t\t\t\tonkeypress=\"return ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"\tonBlur=\'makeValidQueryCriteria(this);validateID(this,\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\");check_clear();\' tabindex=1>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!-- Added by Ashwin K for AAKH-CRF-0150 -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t<input type=button value=\'M\' id=\'M_Btn\' name=\'M_Btn\' id=\'M_Btn\' class= \'button\' onClick=\'MButton_click_PatSearch();\'>\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\"  name=\"EmiratesID_edit\" id=\"EmiratesID_edit\"  >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<!--\"05\" Added  by santhosh for TH-KW-CRF-0019.1 -->\n\t\t\t\t\t\t\t\t\t<input type=button value=\'M\' id=\'M_Btn\' name=\'M_Btn\' id=\'M_Btn\' class= \'button\' onClick=\'MButton_click_PatSearch();\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" <!--\"07\" Added  by Lakhsmanan for MOHE-CRF-0164.1 -->\n\t\t\t\t\t\t\t\t\t<input name=\'NatID_Btn1\' id=\'NatID_Btn1\' class=\'button\' Onclick=\"NationalID_Search(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\" type=\"button\" value=\'M\'>   ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t<input type=button value=\'M\' class= \'button\' onClick=\'PatSearch_ReadDF1_onclick();\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t<!-- Ended by Ashwin K for AAKH-CRF-0150 -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t\t<!-- <applet code=\"CardReaderApplet.class\" name=\"CardReader\"\n\t\t\t\t\t\t\t\t\t\t\tcodebase=\"../../eMP/CardReader/\" archive=\"CardReaderApplet.jar\" width=\"5\"\n\t\t\t\t\t\t\t\t\t\t\theight=\"5\">\n\t\t\t\t\t\t\t\t\t\t\t<PARAM name=\"button_width\" value=\"0\" />\n\t\t\t\t\t\t\t\t\t\t\t<PARAM name=\"button_height\" value=\"0\" />\n\t\t\t\t\t\t\t\t\t\t\t<PARAM name=\"button_label\" value=\"0\" />\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\t\t\t\t\t\t\tSorry, Your browser does not support Java applet!\n\t\t\t\t\t\t\t\t\t\t\t</applet>  -->\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<!-- Commented above old card reader applet and added for AAKH-CRF-0158 -->\n\n\t\t\t\t\t\t\t\t\t\t\t<APPLET style=\"border:solid 1px gray\" id=\"PublicDataWebComponent\" name=\"PublicDataWebComponent\" codebase=\"../../eMP/CardReader/\" CODE=\"emiratesid.jio.webcomponents.PublicDataReader\"\n                                                        ARCHIVE=\"PublicDataApplet-Sagem.jar\" WIDTH=\"0\" HEIGHT=\"0\">\n                                                        <param name=\"EncryptParameters\" value=\"false\" />\n                                                        <param name=\"RelativeCertPath\" value=\"certs\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<PARAM name=\"button_label\" value=\"0\" />\t\n                                                         This browser does not support Applets.\n                                             </APPLET> \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>                                 \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"National_Id_No\" id=\"National_Id_No\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"\tonBlur=\"makeValidQueryCriteria(this)\" onFocus=\"MoveFocus(2)\" tabindex=1></td>\n\t\t\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t  <input type=\"hidden\" name=\"National_Id_No\" id=\"National_Id_No\"  \n\t\t\t\t\t\t\t\t       value=\'\'> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"abha_pat_id\" id=\"abha_pat_id\"    id=\"abha_pat_id\" value=\'\' size=\'20\' >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" \n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr><!--Below line modified by venkatesh on 07/Oct/2013 against 43291-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t    <td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\t    <td  width=\'25%\' class=\"fields\" ><input type=\"text\" name=\"Alt_Id1_No\" id=\"Alt_Id1_No\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" value=\'\' onKeyPress=\'return CheckForSpeclChars(event,\"Alt_Id1\")\'onFocus=\"MoveFocus(2)\" onBlur=\"makeValidQueryCriteria(this);AdnvcenableSuffix()\"  ><input type=\"hidden\" name=\"Expiry_Date1\" id=\"Expiry_Date1\" size=\"8\" maxlength=\"10\"  onFocus=\"MoveFocus(1)\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"newborn_suffix\" id=\"newborn_suffix\" size=\'1\' onKeyPress=\"return allowValidNumber(this,event,2,0);\" onBlur=\"makeValidQueryCriteria(this);\"\n\t\t\t\t\t\t\t\tmaxlength=\'2\'  disabled></td>\n                            ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="   \n\t\t\t\t\t\t\t\t<!--below code change done for SRR20056-SCF-12671-->\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"Alt_Id2_No\" id=\"Alt_Id2_No\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" value=\'\' onKeyPress=\'return altID234Validations(event)\' onBlur=\"makeValidQueryCriteria(this)\" onFocus=\"MoveFocus(2)\" ><input type=\"hidden\" name=\"Expiry_Date2\" id=\"Expiry_Date2\" size=\"8\" maxlength=\"10\"  onFocus=\"MoveFocus(1)\"></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t<td class=\'label\'  width=\'15%\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&nbsp;";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'fields\' ><div id=\'insurance_div\'><textarea name=\'insurance_id\' id=\'insurance_id\' rows=\"3\" cols=\"50\" maxlength=\'300\'  tabindex = \'6\'  value = \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" readonly></textarea>&nbsp;<input type=\'button\' class=\'button\' Value=\' Read \' onClick=\'insCardReader(insurance_id,insurance_div)\'> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"insurance_id_2\" id=\"insurance_id_2\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Alt_Id2_No\" id=\"Alt_Id2_No\" value=\"\"></div></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"Alt_Id3_No\" id=\"Alt_Id3_No\" size=\"25\" value=\'\' maxlength=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" onKeyPress=\'return altID234Validations(event)\' onBlur=\"makeValidQueryCriteria(this)\" onFocus=\"MoveFocus(2)\" ><input type=\"hidden\" name=\"Expiry_Date3\" id=\"Expiry_Date3\" size=\"8\" maxlength=\"10\"  onFocus=\"MoveFocus(1)\"></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t<!--below code change done for SRR20056-SCF-12671-->\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"Alt_Id4_No\" id=\"Alt_Id4_No\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" value=\'\' onKeyPress=\'return altID234Validations(event)\' onBlur=\"makeValidQueryCriteria(this)\" onFocus=\"MoveFocus(2)\" ><input type=\"hidden\" name=\"Expiry_Date4\" id=\"Expiry_Date4\" size=\"8\" maxlength=\"10\"  onFocus=\"MoveFocus(1)\" ></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\" >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\" ><select onchange=\'enableOtherAltId(this.value)\' name=\'other_alt_id\' id=\'other_alt_id\' ><option value=\'\'>----";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="----\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  class=label  width=\'25%\'>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t\t\t\t<td class=fields  width=\'25%\'>\n\t\t\t\t\t\t\t\t<!--<input type =\'text\' name = \'other_alt_Id_no\' value=\"\" size=\'25\' maxlength=\'20\' disabled onKeyPress=\"return CheckForSpecChars(event)\">-->\n\t\t\t\t\t\t\t\t<input type =\'text\' name = \'other_alt_Id_no\' value=\"\" size=\'25\' maxlength=\'20\' disabled>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t</tr>\n<!-- Name part -->\n<!-- Modified onBlur=\'makeValidString(this)\' for the incident IN031010 by Shanthi on 8-3-2012 -->\n\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t     <input type=\"hidden\" name=\"First_Name\" id=\"First_Name\">\n\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"Second_Name\" id=\"Second_Name\">\n\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"Third_Name\" id=\"Third_Name\">\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t    \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t\t\t<tr>  \n                                ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n                               \n                          ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n                           \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n                               \n                          <!-- ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" -->\n                           \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</tr><tr>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</tr>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t</tr>\n\t\t\t\t\n\n\n\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\"></td>\n\t\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\"><input type=\"hidden\" name=\"Soundex\" id=\"Soundex\" value=\'\'></td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\n                                <td  width=\'25%\' class=\"fields\" ><Select name=\"Soundex\" id=\"Soundex\"  onChange=\"EnableFamSearch(this);\"  >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t<Option value=\"\">-----";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="----<Option value=\"E\">";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="<Option value=\"G\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</Select></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><Select name=\"Sex\" id=\"Sex\" ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" ><Option value=\"\" >----";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="----<Option value=\"A\" >";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="<Option value=\"M\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =">";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</option><Option value=\"F\" ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</option><option value=\"U\">";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</option></Select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t </tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" </td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"Dob\" id=\"Dob\" size=\"11\"  onBlur=\"validDateObj(this,\'DMY\',localeName)\" maxlength=\"10\" ><img style=\"cursor=\'hand\'\" id=\'dobCal\' name=\'dobCal\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].Dob.select(); return showCalendar(\'Dob\',null,null,true);\" >\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t&nbsp;&nbsp;<Select name=\"By\" id=\"By\" ><Option value=\"D\" Selected>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="<Option value=\"Y\">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</Select></td> \n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td  align=\'25%\'   class=\"label\" >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n\n\t\t\t\t\t\t\t<td align=\'25%\'   class=\"fields\" ><input type=\"text\" name=\"Family_No\" id=\"Family_No\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" onblur=\'ChangeCase(this);\' ></td> \n\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td align=\'right\'   class=\"fields\"><input type=\"hidden\" name=\"Family_No\" id=\"Family_No\" size=\"25\" maxlength=\"\"  ></td> \n\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\n\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t<tr>\t\n\n\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\n                            <td  width=\'25%\' class=\"fields\"><input type=\'text\' name=\"nationality_desc\" id=\"nationality_desc\" size=\'22\' maxlength=\'30\' onblur=\'getNationality(this);\'><input type=\'hidden\' name=\'Nationality\' id=\'Nationality\' value=\'\'><input type=\'button\' class=\'button\' Value=\'?\' name=\'natCode\' id=\'natCode\' onClick=\'getNationality(this);\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'nationality_desc_hid\' id=\'nationality_desc_hid\' value=\'\'>\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'Nationality_hid\' id=\'Nationality_hid\' value=\'\'></TD>\n\n\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\n                            <td  width=\'25%\' class=\"fields\" ><input type=\'text\' name=\'ethnic_group_desc\' id=\'ethnic_group_desc\' value=\'\' size=\'22\' maxlength=\'30\'   onblur=\'getRace(this);\'><input type=\'button\' class=\'button\' name=\'raceBt\' id=\'raceBt\' value=\'?\' onclick=\'getRace(this);\'   ><input type=\'hidden\' name=\"ethnic_group\" id=\"ethnic_group\"   value=\'\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'ethnic_group_desc_hid\' id=\'ethnic_group_desc_hid\' value=\'\'>\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'ethnic_group_hid\' id=\'ethnic_group_hid\' value=\'\'>\n\t\t\t\t\t\t\t</td>\t\n\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t    \n\n\t\t\t\t\t\t\t\t<td align=\'25%\'   class=\"label\">";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\n                                <td align=\'25%\'   class=\"fields\"><input type=\'hidden\' name=\"Area\" id=\"Area\" value=\'\'><input type=\'text\' name=\'area_desc\' id=\'area_desc\' size=\'22\' value=\'\'    onBlur=\'getArea(this);\'><input type=\'button\' class=\'button\' value=\'?\' onClick=\'getArea(this);\'  ></td>  \n\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'area_desc_hid\' id=\'area_desc_hid\' value=\'\'>\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'Area_hid\' id=\'Area_hid\' value=\'\'>\n\n\n\t\t\t\t\t\t\t\t<td align=\'25%\'   class=\"label\">";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t\t   <select name=\'patient_series\' id=\'patient_series\' > \n                                <option value=\"\">--------";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="-------</option>\n\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="  \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</select>\n                        </td>\n\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\t\n\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t<td  class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\n\t\t\t\t\t\t\t<td  class=\"fields\" width=\'25%\' id=\'mem_type\' >\n\t\t\t\t\t\t\t<SELECT name=\"family_org_membership\" id=\"family_org_membership\" onchange=\"\">\n\t\t\t\t\t\t\t<option selected value =\"\">---------";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="---------- </option>\n\t\t\t\t\t\t\t<option value =\"1\">";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</option>\n\t\t\t\t\t\t\t<option value =\"2\">";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</option>\n\t\t\t\t\t\t\t<option value =\"3\">";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</option>\n\t\t\t\t\t\t\t<option value =\"4\">";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</option>\n\t\t\t\t\t\t\t</SELECT></TD>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\n\t\t\t\t\t\t\t<td  class=\"label\" width=\'25%\' colspan=\'2\'>&nbsp;</td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t</tr>\n\t\t\t    <tr>\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td  class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td  class=\"fields\" width=\'25%\'><input type=\'text\' name=\'organization\' id=\'organization\'  size=\'22\' maxlength=\'30\' onBlur=\'get_org_sub_org_blur(organization,sub_org_desc,this);\'  tabindex=23><input type=\'hidden\' name=\'org_id\' id=\'org_id\' value=\'\'><input type=\'button\' class=\'Button\' value=\'?\' onclick=\'get_org_sub_org(organization,sub_organization,this)\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'organization_hid\' id=\'organization_hid\' value=\'\'>\n\n\t\t\t\t\t\t<td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\n\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'sub_org_desc\' id=\'sub_org_desc\' size=\'22\' onBlur=\'get_sub_org_blur(sub_org_desc);\' tabindex=\'23\'><input type=\'hidden\' name=\'sub_organization\' id=\'sub_organization\'value=\'\'><input type=\'button\' class=\'Button\' id=\'sub_org_id_btn\' value=\'?\' onclick=\'get_sub_org(sub_org_desc)\'>\n\t\t\t\t        </td> \n\n\t\t\t\t\t\t<!--\t \n\t\t\t\t\t\t <td  class=\"fields\" width=\'25%\'><SELECT name=\"sub_organization\" id=\"sub_organization\" onblur=\"moveFocustoAddl();\" tabindex=23>\n\t\t\t\t\t\t<option selected disabled value =\"\"> --------";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="---------</option>\n\t\t\t\t\t\t</SELECT>\n\t\t\t\t        </td>\n\t\t\t\t\t\t-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t\t<td colspan=2>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr >\n                                <td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t\t\t\t\t\t\t\t<!--Added smart_contact_no by Ashwin K for AAKH-CRF-0150 -->\n                                <td  class=\"fields\" width=\"25%\"><input type=\"text\" name=\"Contact_No\" id=\"Contact_No\" size=\"25\" maxlength=\"20\" onBlur=\"makeValidQueryCriteria(this);MoveFocus(3)\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" tabindex=26>\n\t\t\t\t\t\t\t\t &nbsp;\n\n\t\t\t\t\t\t\t\t <!--Added  by Ashwin K for AAKH-CRF-0150 --><!--\"05\" Added  by santhosh for TH-KW-CRF-0019.1 -->\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =" \n\t\t\t\t\t\t\t\t\t\t<select name=\"contact_search_by\" id=\"contact_search_by\">\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"S\">";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t\t\t\t\t<!--Ended by Ashwin K for AAKH-CRF-0150 -->\n\t\t\t\t\t\t\t\t</td>\n                               \n\t\t\t\t\t\t\t\t<td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</td>\n                                <td class=\"fields\" width=\"25%\"><Select name=\"Mode\" id=\"Mode\" onFocus=\"MoveFocus(3)\" tabindex=27 disabled><Option value=\"\" selected>---";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="---\n                                ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t\t\t<!-- Below line added for this CRF  PMG2013-MMS-CRF-0004 [IN:045277] -->\n\t\t\t\t\t\t\t\t<option value=\'NHPN\'>";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="  ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'NMPN\'>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'NOPN\'>";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</option>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<option value=\'FHPN\'>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'FMPN\'>";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'FOPN\'>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</option>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<option value=\'EHPN\'>";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</option>\n\t\t\t\t\t\t\t\t<option value=\'EOPN\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</option>\n\t\t\t\t\t\t\t\t<!-- End this CRF  PMG2013-MMS-CRF-0004 [IN:045277] -->\n\t\t\t\t\t\t\t\t</Select></td>  \n\t\t\t\t\t\t\t</tr>  \n\t\t\n\t\t\t<tr>\n\t\t\t\t\t\t<td   class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\n                        \n\t\t\t\t\t\t<td    class=\"fields\" width=\'25%\'><Select name=\"order_by\" id=\"order_by\" onBlur=\'moveFocustoAddl();\' >\n\t\t\t\t\t\t<OPTION value=\'X\'>----";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="----\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n                                </select>\n                        </td> \n\t\t\t\t\t\t<td   class=\"label\" width=\'25%\' style=\"display:None\">";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td   class=\"fields\" width=\'25%\' style=\"display:None\" ><Select name=\"search_in\" id=\"search_in\"  disabled ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =">\n\t\t\t\t\t\t\t<Option value=\"P\" selected >";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t\t<Option value=\"B\" >";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t\t\t\t\t<Option value=\"D\">";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t\t\t</Select></td> \n\t\t\t\t\t\t\t<td>&nbsp;</td><td><input type=\'button\' class=\'BUTTON\' name=\'Moreless\' id=\'Moreless\' title= \'Moreless\' align=\'right\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' onClick=\"parent.Pat_Search_Criteria_Frame.MoreLess();\"></td>\n\t\t\t\t</tr>\n\n\n\n\t\t\t\t\t\t\t\t<tbody id=\"rowExpansion\" style=\"display:none\">\n                                \n\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t\t\t\t<td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</td>\n                               <td class=\"fields\" width=\"25%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t\t\t\t   <input type=\"checkbox\" name=\"deceased_yn\" id=\"deceased_yn\" checked tabindex=30 value=\'Y\'></td> \n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"deceased_yn\" id=\"deceased_yn\" tabindex=30 value=\"N\"  ></td>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =" \n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n                                <td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</td>\n                                <td class=\"fields\" width=\"25%\"><input type=\"text\" name=\"addl_field1\" id=\"addl_field1\" size=\'25\' maxlength=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' onBlur=\'makeValidString(this)\' tabindex=33></td>\n                             ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n                                <td >&nbsp;<input type=\'hidden\' name=\"addl_field1\" id=\"addl_field1\"></td>\n\t\t\t\t\t\t\t\t <td >&nbsp;</td>\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t</tr>\n\n\n                            <tr>\n                              <td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</td>\n                               <td class=\"fields\" width=\"25%\"><input type=\"checkbox\" value=\"N\" name=\"suspend_yn\" id=\"suspend_yn\" tabindex=31 ></td>   \n                                              \n                            ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</td>\n                                <td class=\"fields\" width=\"25%\"><input type=\"text\" name=\"addl_field2\" id=\"addl_field2\" size=\'25\' maxlength=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' onBlur=\'makeValidString(this)\' tabindex=34></td>\n                             ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n                                <td>&nbsp;<input type=\'hidden\' name=\"addl_field2\" id=\"addl_field2\"></td>\n\t\t\t\t\t\t\t\t    <td >&nbsp;</td>\n                             ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =" \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t </tr>\n\t\t\t\t\t\t\t <tr>\n                               <td  align=\'right\' class=\"label\">";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n                               <td class=\"fields\" width=\"25%\"><input type=\"checkbox\" name=\"active_yn\" id=\"active_yn\" onBlur=\'moveFocustoGeneral(this)\' value=\"N\" tabindex=32 ></td>   \n                             \n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</td>\n                                <td class=\"fields\" width=\"25%\"><input type=\"text\" name=\"addl_field3\" id=\"addl_field3\" size=\'25\' maxlength=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' onBlur=\'makeValidString(this)\' tabindex=35></td>\n                             ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n                                <td >&nbsp;<input type=\'hidden\' name=\"addl_field3\" id=\"addl_field3\"></td>\n\t\t\t\t\t\t\t\t    <td >&nbsp;</td>\n                             ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\t\n\t\t\t\t\t\t\t</tr>\t\n\n\t\t\t\t\t\t\t<tr>\n                             <td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td>\n\t\t\t\t\t\t\t<td class=\"fields\" width=\"25%\"><input type=\'text\' name=\'mother_maiden_name\' id=\'mother_maiden_name\' size=\'25\' maxlength=\'80\' onBlur=\'makeValidString(this)\' tabindex=35></td>\n                              ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t\t\t\t\t\n                                <td  class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n                                <td class=\"fields\" width=\"25%\"><input type=\"text\" name=\"addl_field4\" id=\"addl_field4\" size=\'25\' onBlur=\'makeValidString(this);moveFocustoGeneral(this)\' maxlength=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' tabindex=36></td>\n                             ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n                                <input type=\'hidden\' name=\"addl_field4\" id=\"addl_field4\">\n\t\t\t\t\t\t\t\t    <td >&nbsp;</td>\n\t\t\t\t\t\t\t\t    <td >&nbsp;</td>\n                             ";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n                           \n                            </tr>   \n\n                            <tr>\n\t\t\t\t\t\t <td class=\"label\">";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\n\t\t\t\t\t\t   <td class=\"fields\" colspan=\'1\'><SELECT name=\"reg_mode\" id=\"reg_mode\">\n\t\t\t\t\t\t   <option value=\'\'>---";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="---</option>\n\t\t\t\t\t\t   <option value=\'N\'>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</option>\n\t\t\t\t\t\t   <option value=\'Y\'>";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="</option>\n\t\t\t\t\t\t   <option value=\'R\'>";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</option>\n\t\t\t\t\t\t   </SELECT></td>\n                            ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</td>\n                                <td class=\"fields\" width=\"25%\"><input type=\"text\" name=\"addl_field5\" id=\"addl_field5\" size=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\' onBlur=\'makeValidString(this);moveFocustoGeneral(this)\' maxlength=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' tabindex=37></td>\n                             ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n                               <td   class=\"label\" width=\"25%\"><input type=\'hidden\' name=\"addl_field5\" id=\"addl_field5\"></td>\n\t\t\t\t\t\t\t\t    <td >&nbsp;</td>\n                             ";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n                           </tr>  \n\t\t\t   \t<tr>\n\t\t\t\t\t<td   width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</td>\n\t\t\t\t\t<td class=\"fields\" width=\"25%\" ><input type=\"text\" name=\"OldFileNo\" id=\"OldFileNo\" size=\"20\" maxlength=\"20\" onKeyPress=\"return allowAlphaNumeric(event)\" onBlur=\'makeValidString(this);ChangeCase(this)\' tabindex=25 ";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="></td>\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t\t\t<td   width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="</td>\n\t\t\t\t\t<td class=\"fields\" width=\"25%\" ><input type=\"text\" name=\"MRN\" id=\"MRN\" size=\"20%\" maxlength=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" onKeyPress=\"return allowAlphaNumeric(event)\" onBlur=\'makeValidString(this);ChangeCase(this)\' tabindex=24  ";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="></td>\n\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t\t<td colspan=\'2\' class=\"label\" width=\"50%\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td   width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="</td>\n\t\t\t\t\t<td class=\"fields\" width=\"25%\" colspan=\'3\'><input type=\"checkbox\" name=\"IP_yn\" id=\"IP_yn\" value=\'IP\'>";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="&nbsp;<input type=\"checkbox\" name=\"DC_yn\" id=\"DC_yn\" value=\'DC\'>";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="&nbsp;<input type=\"checkbox\" name=\"OP_yn\" id=\"OP_yn\" value=\'OP\'>";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="&nbsp;<input type=\"checkbox\" name=\"EM_yn\" id=\"EM_yn\" value=\'EM\' onblur=\'movefocusout(this)\'>";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</td>\n\t\t\t\t\t<td colspan=2></td>\n\t\t\t\t</tr>\n\t\t\t\t</tbody>\n\t\t\t\t\n\t\t\t\t  </table>\n                    </td>\n                </tr>\t\t\t\t\t\t\t \n\t\t\t\n\t\t </table>\n        </center>\n   </table>\n\n\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n    <input type=\"hidden\" name=\"1\" id=\"1\" value=\"\">\n    <input type=\"hidden\" name=\"FULLSQL\" id=\"FULLSQL\" value=\"\">\n    <input type=\"hidden\" name=\"ORDERBY\" id=\"ORDERBY\" value=\"\">\n    <input type=\"hidden\" name=\"jsp_name\" id=\"jsp_name\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n    <input type=\"hidden\" name=\"window_styl\" id=\"window_styl\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n    <input type=\"hidden\" name=\"close_yn\" id=\"close_yn\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n    <input type=\"hidden\" name=\"register_button_yn\" id=\"register_button_yn\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n    <input type=\"hidden\" name=\"func_act\" id=\"func_act\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n    <input type=\"hidden\" name=\"soundex_dflt\" id=\"soundex_dflt\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n    <input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n\t<input type=\'hidden\' name=\'alt_id1_accept_alphanumeric\' id=\'alt_id1_accept_alphanumeric\' value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n   \t<input type=\"hidden\" name=\"names_in_oth_lang_yn_hd\" id=\"names_in_oth_lang_yn_hd\" value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">\n   \t<input type=\"hidden\" name=\"pat_name_as_multipart_yn_hd\" id=\"pat_name_as_multipart_yn_hd\" value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n   \t<input type=\"hidden\" name=\"simplesearch_select_yn\" id=\"simplesearch_select_yn\" value=\"Y\">\n   \t<input type=\"hidden\" name=\"morelessexpand\" id=\"morelessexpand\" value=\"Y\">\n\n   \t<input type=\"hidden\" name=\"cr_jsp_name\" id=\"cr_jsp_name\" value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n   \t<input type=\"hidden\" name=\"cr_window_styl\" id=\"cr_window_styl\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n   \t<input type=\"hidden\" name=\"cr_close_yn\" id=\"cr_close_yn\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n   \t<input type=\"hidden\" name=\"cr_win_top\" id=\"cr_win_top\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n   \t<input type=\"hidden\" name=\"cr_win_width\" id=\"cr_win_width\" value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n   \t<input type=\"hidden\" name=\"cr_win_height\" id=\"cr_win_height\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n   \t<input type=\"hidden\" name=\"cr_act_yn\" id=\"cr_act_yn\" value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n   \t<input type=\"hidden\" name=\"cr_srr\" id=\"cr_srr\" value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\n   \t<input type=\"hidden\" name=\"cr_register_button_yn\" id=\"cr_register_button_yn\" value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n   \t<input type=\"hidden\" name=\"cr_func_act\" id=\"cr_func_act\" value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n   \t<input type=\"hidden\" name=\"cr_defaultgender\" id=\"cr_defaultgender\" value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\">\n   \t<input type=\"hidden\" name=\"cr_enablegenderyn\" id=\"cr_enablegenderyn\" value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n   \t<input type=\"hidden\" name=\"cr_function_id\" id=\"cr_function_id\" value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n   \t<input type=\"hidden\" name=\"cr_func_idpassed\" id=\"cr_func_idpassed\" value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\">\n   \t<input type=\"hidden\" name=\"cntPrefFac\" id=\"cntPrefFac\" value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\">\n   \t<input type=\"hidden\" name=\"allow_nb_review\" id=\"allow_nb_review\" value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n   \t<input type=\"hidden\" name=\"patient_id_length\" id=\"patient_id_length\" value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n\t<!--for smart card-->\n\t<input type=\"hidden\" name=\"txtSmartcard_path\" id=\"txtSmartcard_path\" value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n\t<!--for Alkhaleej smart card-->\n\t<input type=\"hidden\" name=\"txtSmart_fn_name\" id=\"txtSmart_fn_name\" value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n\t<input type=\"hidden\" name=\"nat_id_prompt\" id=\"nat_id_prompt\" value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">\n\t<input type=\"hidden\" name=\"nat_id_accept_alphanumeric_yn\" id=\"nat_id_accept_alphanumeric_yn\" value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n\t<input type=\"hidden\" name=\"name_dervn_logic\" id=\"name_dervn_logic\" value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">\n\t<input type=\"hidden\" name=\"txtSmartcard_dup\" id=\"txtSmartcard_dup\" value=\"\">\n\t<input type=\"hidden\" name=\"alert_reqd_yn\" id=\"alert_reqd_yn\" value=\"\">\n\t<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\"><!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601-->\n\t<input type=\'hidden\' name=\'isAddressLengthIncAppl\' id=\'isAddressLengthIncAppl\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\"><!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2-->\n\t\n\t<!--for smart card-->\n\t<!--Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]-->\n\t<input type=\"hidden\" name=\"alt_id1_pat_sch_exact_yn\" id=\"alt_id1_pat_sch_exact_yn\" value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\n\t<input type=\"hidden\" name=\"alt_id2_pat_sch_exact_yn\" id=\"alt_id2_pat_sch_exact_yn\" value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n\t<input type=\"hidden\" name=\"alt_id3_pat_sch_exact_yn\" id=\"alt_id3_pat_sch_exact_yn\" value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n\t<input type=\"hidden\" name=\"alt_id4_pat_sch_exact_yn\" id=\"alt_id4_pat_sch_exact_yn\" value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n\t<!--Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]-->\n\t  <!--Below line added for this CRF HSA-CRF-0289 -->\t\n\t  <input type=\"hidden\" name=\"alterIdSearch\" id=\"alterIdSearch\" value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t  <input type=\"hidden\" name=\"isAlternateId\" id=\"isAlternateId\" value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n\t  <input type=\"hidden\" name=\"alternate_no\" id=\"alternate_no\" value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n\n\t   <input type=\"hidden\" name=\"fam_name_ind\" id=\"fam_name_ind\" value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t    <input type=\"hidden\" name=\"isInsuranceCardReader\" id=\"isInsuranceCardReader\" value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\"><!--Added by kamatchi S for MOHE-CRF-0016.1 ON 28-AUG-2020-->\n\t\t<!--//Added by Maheshwaran K for AAKH-CRF-0168-->\n\t\t<input type=\"hidden\" name=\"dft_national_id\" id=\"dft_national_id\" value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t\t\t\t<!--//Added by Maheshwaran K for AAKH-CRF-0175-->\n\t\t<input type=\"hidden\" name=\"biometric_authentication_yn\" id=\"biometric_authentication_yn\" value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n\t <!--Added by Rameswar on  19-04-2016 for HSA-CRF-0299-->\n\t    <input type=\"hidden\" name=\"suspend_inactive_pat_yn\" id=\"suspend_inactive_pat_yn\" value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n\t\t <input type=\"hidden\" name=\"ndhm_appl_YN\" id=\"ndhm_appl_YN\" value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\"><!-- //Maheshwaran K added for GHL-CRF-0657.2 as 06-09-2923-->\n\t\t\n   </form>\n    <!--<script>setTimeout(\'FocusFirstElement()\',500)</script>-->\n\t<script>\n\tif(\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'!=\"\"&&\'";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'==\"true\"){ \n\t     setTimeout(\"AlternateIdFocus(\'";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\')\",500)\n\t}else{ \n\t     setTimeout(\'FocusFirstElement()\',500)\n\t}\n\t</script>\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
/*Added by lakshmanan on nov 03 2022 against GHL-CRF-0657.1*/
	public static String getNDHMApplicable(Connection con){
		String sqlNDHMApplicable="SELECT count(*) FROM XH_STANDARD_PROFILE WHERE PROFILE_ID LIKE '%NDHMPROF1%' and NVL(EFF_STATUS,'Y') = 'Y' AND ROWNUM = 1  ";
		int count=0;
		String ndhmYN="N";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(sqlNDHMApplicable);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				ndhmYN="Y";
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return ndhmYN;
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

	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	
            _bw.write(_wl_block7Bytes, _wl_block7);


	// Added for MOHE-CRF-164.1 by lakshmanan
	String sessionID 		= 			session.getId();
	String facility			= (String) session.getValue("facility_id");
	String loginUser		= (String) session.getValue("login_user");
	Properties p = (java.util.Properties) session.getValue("jdbc");
	String p_ws_no = p.getProperty("client_ip_address");
    // MOHE-CRF-0164 end


    Connection con = null;
    PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
    ResultSet rs=null;
    ResultSet rs1=null;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String language_direction="";
	String pat_ser_grp_code="";
	String pat_ser_grp_desc="";
	int count=0;
	String nat_id_prompt ="";
	String names_in_oth_lang_yn="";
	String ext_system_interface_yn="";
	String nat_data_source_id="";
	String nat_id_check_digit_id="";
    String First_Name_Accept_Yn ="";
    int First_Name_Order=0;
    String First_Name_Prompt ="";
    String Second_Name_Accept_Yn ="";
    int Second_Name_Order =0;
    String Second_Name_Prompt ="";
    String Third_Name_Accept_Yn ="";
    int Third_Name_Order =0;
    String Third_Name_Prompt ="";
    String Family_Name_Accept_Yn =""; 
    int Family_Name_Order =0;
    String Family_Name_Prompt ="";
    int patient_id_length =0;
    int nat_id_length =0;
    int alt_id1_length =0;
    int alt_id2_length =0;
    int alt_id3_length =0;
    int alt_id4_length =0;
	String firstRowElement="";
	String firstRowCompleted="";
    String Family_No_Link_Yn ="";
    String Family_No_Prompt ="";
    String Res_Area_Prompt = "";
    //String orderby="";
    String Alt_Id1 = "" ;
    String Alt_Id2 = "" ;
    String Alt_Id3 = "" ;
    String Alt_Id4 = "" ;
	//String prn_label="";
	//String orn_label="";
    String addl_field1_prompt = "";
    int addl_field1_length = 0;
    String addl_field2_prompt = "";
    int addl_field2_length = 0;
    String addl_field3_prompt = "";
    int addl_field3_length = 0;
    String addl_field4_prompt = "";
    int addl_field4_length = 0;
    String addl_field5_prompt = "";
    int addl_field5_length = 0;
	String accept_national_id_no_yn = "N";
	String nat_id_accept_alphanumeric_yn = "N";
	String alt_id1_accept_alphanumeric_yn ="";
	String accept_oth_alt_id_yn = "N";
	String family_org_id_accept_yn = "N";
	String Family_Name_loc_lang_Prompt="";
	String Third_Name_loc_lang_Prompt="";
	String Second_Name_loc_lang_Prompt="";
	String First_Name_loc_lang_Prompt="";
	String jsp_name=request.getParameter("jsp_name");
	String cr_jsp_name=request.getParameter("jsp_name");
    String window_styl=request.getParameter("window_styl");
    String cr_window_styl=request.getParameter("window_styl");
    String close_yn=request.getParameter("close_yn");
    String cr_close_yn=request.getParameter("close_yn");
    //String win_height   =request.getParameter("win_height");
    String cr_win_height   =request.getParameter("win_height");
    //String win_width    =request.getParameter("win_width");
    String cr_win_width    =request.getParameter("win_width");
    //String win_top      =request.getParameter("win_top");
    String cr_win_top      =request.getParameter("win_top");
    //String act_yn   =request.getParameter("act_yn");
    String cr_act_yn   =request.getParameter("act_yn");
    //String srr = request.getParameter("srr");
    String cr_srr = request.getParameter("srr");
    String register_button_yn = request.getParameter("register_button_yn");
    String cr_register_button_yn = request.getParameter("register_button_yn");
    String func_act = request.getParameter("func_act");
    String cr_func_act = request.getParameter("func_act");
    func_act = (func_act == null)?"":func_act;
    String func_idpassed = request.getParameter("func_idpassed");
    String cr_func_idpassed = request.getParameter("func_idpassed");
	if (func_idpassed == null || func_idpassed.equals("null")) func_idpassed = "";
	if (cr_func_idpassed == null || cr_func_idpassed.equals("null")) cr_func_idpassed = "";

	String defaultgender        =   request.getParameter("default_gender")==null?"":request.getParameter("default_gender");
	String cr_defaultgender        =   request.getParameter("default_gender")==null?"":request.getParameter("default_gender");
    String enablegenderyn   =   request.getParameter("enable_gender_yn")==null?"":request.getParameter("enable_gender_yn");
    String cr_enablegenderyn   =   request.getParameter("enable_gender_yn")==null?"":request.getParameter("enable_gender_yn");

	// Added for IN0 by Suresh M on 20.12.2010
	String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	
	//Added for this CRF HSA-CRF-0289
	String alterIdSearch=request.getParameter("alterIdSearch")==null?"":request.getParameter("alterIdSearch");
	String isAlternateId=request.getParameter("isAlternateId")==null?"":request.getParameter("isAlternateId");
	String alternate_no=request.getParameter("alternate_no")==null?"":request.getParameter("alternate_no");
	//End HSA-CRF-0289
	//Maheshwaran K added for MMS-DM-CRF-0208.1
	String suspend_inactive_pat_yn=request.getParameter("suspend_inactive_pat_yn")==null?"N":request.getParameter("suspend_inactive_pat_yn");
	String smart_contact_no=request.getParameter("smart_contact_no")==null?"":request.getParameter("smart_contact_no"); //Added by Ashwin K for AAKH-CRF-0150
	

    String self     = "";
    String selm = "";
    String dis      = "";
    String sdisable = "";
	String Smartcard_path="" ; //added for smart card 
	String function_name="" ; //added for Alkhalej smart card 
	String name_dervn_logic="";

    if(defaultgender.equals("F")) self = "selected";
    else if(defaultgender.equals("M")) selm = "selected";

    if(enablegenderyn.equals("N")) dis = "DISABLED";


    String Soundex ="";
    //String fieldname = "";
    //String str="";
    //String str_new ="";
    //String dateofbirthyn="N";
    //Added by kumar on 8/3/2002 for DR Module
    String function_id  =   request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
    String cr_function_id  =   request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
   
    if(!function_id.equals("") && !function_id.equals("PAT_REG") && !function_id.equals("NEWBORN_REG")) sdisable = "disabled";
	
	if(func_act.equals("DuplicateRegistration"))
	sdisable = "";
	//String dr_install_yn = "N";
   // boolean Sndx = false;
    String errFlag = "N";
	String separate_file_no_yn = "N";
	String mrn_length = "20";
	int cntPrefFac = 0;

	String pat_name_as_multipart_yn	= "";
	String maintain_doc_or_file		= "";
	String docDisableField			= "";
	String first_name_length = "";
	String second_name_length = "";
	String third_name_length = "";
	String family_name_length = "";
	String file_type_appl_yn = "";
	String review_nb_links_bef_reg_yn = "";
//	String patient_id_length = "";
/*Indivisual Quires */
	//Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
	String alt_id1_pat_sch_exact_yn="";
	String alt_id2_pat_sch_exact_yn="";
	String alt_id3_pat_sch_exact_yn="";
	String alt_id4_pat_sch_exact_yn="";
	String dft_national_id="";
	String biometric_authentication_yn="N"; //Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
	boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601

	boolean isAddressLengthIncAppl = false;//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2
	
	boolean isPatientNameContainsAppl = false;  //Added by Mujafar  against ML-MMOH-CRF-1127
	String select_val=""; //Added by Mujafar  against ML-MMOH-CRF-1127
	
	boolean isInsuranceCardReader = false;//Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020
	String insurance_id = "";//Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020
	String ndhm_appl_YN = "N"; // Added for NDHM integration GHL-CRF o657.1
/*Query For Select  Some Of theFileds From MP_Pararm*/

		String Qry_For_Param="SELECT Dflt_Sndx_type, separate_file_no_yn, pat_name_as_multipart_yn, maintain_doc_or_file,family_org_id_accept_yn,first_name_length, second_name_length,third_name_length,family_name_length,file_type_appl_yn,review_nb_links_bef_reg_yn,patient_id_length,dft_national_id,biometric_authentication_yn FROM mp_param where module_id='MP'";

/*Query For Other Alt ID Type Drop Down*/

		String Qry_For_AltType = "SELECT alt_id_type,nvl((select desc1_value from SM_OTH_LANG_DATA_SKEY where table_id ='MP_ALTERNATE_ID_TYPE' and language_id =? and pk_value=mp_alternate_id_type.alt_id_type),SHORT_DESC) SHORT_DESC FROM mp_alternate_id_type WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM where module_id='MP') and eff_status='E' order by 2";

/*Query For Patient Series Drop Down*/
		String Qry_For_PatSeries="select pat_ser_grp_code,short_desc from mp_pat_ser_grp_lang_vw where 	language_id=? order by short_desc"; 
/*Query For Order By Drop Down*/
		String Qry_for_OrderBy="select field_name,field_desc from mp_pat_search_result_lang_vw where field_select='Y' and language_id =? order by field_order ";
/*Query For Contact Mode  Drop Down*/
		String Qry_For_CntMode="Select Contact_Mode,short_desc from mp_contact_mode_lang_vw where language_id=? and eff_status='E' order by short_desc";


/**ENDS**/
/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
	String fam_name_ind="N";

	try 
	{	  
		con = ConnectionManager.getConnection(request);
		//for smart card
		pstmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

		rs = pstmt.executeQuery();	
  

		if(rs!=null && rs.next())
		{
		Smartcard_path=rs.getString("VALUE_1");
		function_name=rs.getString("VALUE_2");   // alkhaleej smart card

		}		

		isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601

		isAddressLengthIncAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2
		
		isPatientNameContainsAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","PATIENT_NAME_CONTAINS_APPL"); //Added by Mujafar  against ML-MMOH-CRF-1127
		ndhm_appl_YN 	= getNDHMApplicable(con);  //Maheshwaran K added for GHL-CRF-0657.2 as 06-09-2923

	
		if(isPatientNameContainsAppl) //Added by Mujafar  against ML-MMOH-CRF-1127
			select_val = "selected";

		isInsuranceCardReader = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INSURANCE_CARD_READER"); //Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020

		if(pstmt!=null)
		pstmt.close();
		if(rs!=null)
		rs.close();
		//for smart card
        pstmt = con.prepareStatement(Qry_For_Param);
        rs=pstmt.executeQuery();
        if(rs.next()) 
		{
            Soundex = checkForNull(rs.getString(1));      
			separate_file_no_yn = checkForNull(rs.getString(2));
			pat_name_as_multipart_yn = checkForNull(rs.getString(3));
			maintain_doc_or_file = checkForNull(rs.getString(4));
			first_name_length = rs.getString("first_name_length");
			second_name_length = rs.getString("second_name_length");
			third_name_length = rs.getString("third_name_length");
			family_name_length = rs.getString("family_name_length");
			file_type_appl_yn = checkForNull(rs.getString("file_type_appl_yn"));
			if(maintain_doc_or_file == null) maintain_doc_or_file = "F";
			family_org_id_accept_yn = checkForNull(rs.getString("family_org_id_accept_yn"),"N"); 
			review_nb_links_bef_reg_yn = checkForNull(rs.getString("review_nb_links_bef_reg_yn"),"N"); 
//			patient_id_length = checkForNull(rs.getString("patient_id_length"),""); 
			dft_national_id=checkForNull(rs.getString("dft_national_id"));//Added by Maheshwaran K for AAKH-CRF-0168
			biometric_authentication_yn=checkForNull(rs.getString("biometric_authentication_yn"));//Added by Maheshwaran K for AAKH-CRF-0175
        }       
        else
        {
            errFlag = "Y";
            out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));</script>");
            //out.println("<script>parent.window.close();</script>"); 
			out.println("<script>const dialogTag = parent.parent.document.getElementById('dialog_tag'); dialogTag.close();</script>");      			
        }
		
		if(maintain_doc_or_file.equals("D")) docDisableField = "disabled";
	  /*  try 
		{
			pstmt = con.prepareStatement("Select install_yn from sm_module where module_id ='DR'");
	        rs=pstmt.executeQuery();
			if(rs.next()) 
			{           
				dr_install_yn= rs.getString(1);
			}
		}
		catch(Exception e)
		{   
			out.println(e.toString());
		}*/

		/*try 
		{
			pstmt = con.prepareStatement("Select count(1) from mp_pat_search_result where field_select='Y' and UPPER(field_name)='PREF_FACILITY_ID'");
			rs=pstmt.executeQuery();
			if(rs.next()) 
			{           
				cntPrefFac = rs.getInt(1);
			}
		}
	    catch(Exception e)
		{   
			out.println(e.toString());
		}*/

		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

		
		
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();


		pstmt = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status = 'E'" ) ;
		
		rs = pstmt.executeQuery() ;
             
			
        if ( rs != null && rs.next() ) 
		 {
		 count = rs.getInt("total");
		 }

		if ( count==1 ) 
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}


		 if(pstmt != null) pstmt.close();
		 if(rs != null) rs.close();
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block10Bytes, _wl_block10);

                            try{
								  //String Qry_For_Slct_Flds="Select nvl(param.Nat_Id_Prompt, 'National ID No') Nat_ID_Prompt, param.nat_data_source_id, param.nat_id_check_digit_id, param.Patient_Id_Length,param.Nat_Id_Length,param.Family_No_Link_Yn,param.Family_No_Prompt,param.First_Name_Accept_Yn,param.First_Name_Order,param.First_Name_Prompt,param.Second_Name_Accept_Yn,param.Second_Name_Order,param.Second_Name_Prompt,param.Third_Name_Accept_Yn,param.Third_Name_Order,param.Third_Name_Prompt,param.Family_Name_Accept_Yn,param.Family_Name_Order,param.Family_Name_Prompt,First_Name_loc_lang_Prompt, Second_Name_loc_lang_Prompt, Third_Name_loc_lang_Prompt, Family_Name_loc_lang_Prompt,param.alt_id1_accept_alphanumeric_yn, param.Alt_Id1_type,alt_id1.long_desc alt_id1_desc, param.Alt_Id2_type,alt_id2.long_desc alt_id2_desc, param.Alt_Id3_type,alt_id3.long_desc alt_id3_desc,param.Alt_Id4_type,(alt_id4.long_desc) alt_id4_desc, param.alt_id1_length, param.alt_id2_length, param.alt_id3_length, param.alt_id4_length, param.addl_field1_prompt, param.addl_field1_length, param.addl_field2_prompt, param.addl_field2_length, addl_field3_prompt, addl_field3_length, param.addl_field4_prompt, param.addl_field4_length, param.addl_field5_prompt, param.addl_field5_length,param.accept_national_id_no_yn,param.nat_id_accept_alphanumeric_yn,param.ext_system_interface_yn,param.accept_oth_alt_id_yn,NAMES_IN_OTH_LANG_YN from MP_PARAM_LANG_VW param,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id1,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id2,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id3,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id4 where param.module_id='MP' and param.language_id =? and  param.language_id=alt_id1.language_id and param.language_id=alt_id2.language_id(+) and param.language_id=alt_id3.language_id(+) and param.language_id=alt_id4.language_id(+) and param.alt_id1_type=alt_id1.alt_id_type and param.alt_id2_type=alt_id2.alt_id_type(+) and param.alt_id3_type=alt_id3.alt_id_type(+) and param.alt_id4_type=alt_id4.alt_id_type(+)";
								  /*String Qry_For_Slct_Flds="SELECT NVL (param.nat_id_prompt, 'National ID No') nat_id_prompt,param.nat_data_source_id, param.nat_id_check_digit_id,param.patient_id_length, param.nat_id_length, param.family_no_link_yn,param.family_no_prompt, param.first_name_accept_yn,param.first_name_order, param.first_name_prompt,param.second_name_accept_yn, param.second_name_order,param.second_name_prompt, param.third_name_accept_yn,param.third_name_order, param.third_name_prompt,param.family_name_accept_yn, param.family_name_order,param.family_name_prompt, first_name_loc_lang_prompt,second_name_loc_lang_prompt, third_name_loc_lang_prompt,family_name_loc_lang_prompt, param.alt_id1_accept_alphanumeric_yn,param.alt_id1_type,mp_get_desc.mp_alternate_id_type(param.alt_id1_type,param.language_id,'1') alt_id1_desc,param.alt_id2_type,mp_get_desc.mp_alternate_id_type(param.alt_id2_type,param.language_id,'1') alt_id2_desc,param.alt_id3_type,mp_get_desc.mp_alternate_id_type(param.alt_id3_type,param.language_id,'1') alt_id3_desc,param.alt_id4_type,mp_get_desc.mp_alternate_id_type(param.alt_id4_type,param.language_id,'1') alt_id4_desc,param.alt_id1_length,param.alt_id2_length, param.alt_id3_length, param.alt_id4_length,param.addl_field1_prompt, param.addl_field1_length,param.addl_field2_prompt, param.addl_field2_length, addl_field3_prompt,addl_field3_length, param.addl_field4_prompt, param.addl_field4_length,param.addl_field5_prompt, param.addl_field5_length,param.accept_national_id_no_yn, param.nat_id_accept_alphanumeric_yn,param.ext_system_interface_yn, param.accept_oth_alt_id_yn,names_in_oth_lang_yn,name_dervn_logic FROM   mp_param_lang_vw param WHERE  param.module_id = 'MP' AND param.language_id = ?";//Query modified for Performance tuning*/
								  String Qry_For_Slct_Flds="SELECT param.alt_id1_pat_sch_exact_yn,param.alt_id2_pat_sch_exact_yn,param.alt_id3_pat_sch_exact_yn,param.alt_id4_pat_sch_exact_yn,NVL (param.nat_id_prompt, 'National ID No') nat_id_prompt,param.nat_data_source_id, param.nat_id_check_digit_id,param.patient_id_length, param.nat_id_length, param.family_no_link_yn,param.family_no_prompt, param.first_name_accept_yn,param.first_name_order, param.first_name_prompt,param.second_name_accept_yn, param.second_name_order,param.second_name_prompt, param.third_name_accept_yn,param.third_name_order, param.third_name_prompt,param.family_name_accept_yn, param.family_name_order,param.family_name_prompt, first_name_loc_lang_prompt,second_name_loc_lang_prompt, third_name_loc_lang_prompt,family_name_loc_lang_prompt, param.alt_id1_accept_alphanumeric_yn,param.alt_id1_type,mp_get_desc.mp_alternate_id_type(param.alt_id1_type,param.language_id,'1') alt_id1_desc,param.alt_id2_type,mp_get_desc.mp_alternate_id_type(param.alt_id2_type,param.language_id,'1') alt_id2_desc,param.alt_id3_type,mp_get_desc.mp_alternate_id_type(param.alt_id3_type,param.language_id,'1') alt_id3_desc,param.alt_id4_type,mp_get_desc.mp_alternate_id_type(param.alt_id4_type,param.language_id,'1') alt_id4_desc,param.alt_id1_length,param.alt_id2_length, param.alt_id3_length, param.alt_id4_length,param.addl_field1_prompt, param.addl_field1_length,param.addl_field2_prompt, param.addl_field2_length, addl_field3_prompt,addl_field3_length, param.addl_field4_prompt, param.addl_field4_length,param.addl_field5_prompt, param.addl_field5_length,param.accept_national_id_no_yn, param.nat_id_accept_alphanumeric_yn,param.ext_system_interface_yn, param.accept_oth_alt_id_yn,names_in_oth_lang_yn,name_dervn_logic FROM   mp_param_lang_vw param WHERE  param.module_id = 'MP' AND param.language_id = ?";//Query modified for Performance tuning and few columns are added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
                                  pstmt = con.prepareStatement(Qry_For_Slct_Flds);
								  pstmt.setString(1,locale);
								  rs = pstmt.executeQuery();
                                  if (rs !=null){
                                        if (rs.next())
                                        {
                                            nat_id_prompt = rs.getString("Nat_Id_Prompt");
                                            if (nat_id_prompt==null) nat_id_prompt = "";
											ext_system_interface_yn = rs.getString("ext_system_interface_yn");
											nat_data_source_id = checkForNull(rs.getString("nat_data_source_id"),"");
											nat_id_check_digit_id = checkForNull(rs.getString("nat_id_check_digit_id"),"");
                                            patient_id_length = rs.getInt("Patient_Id_Length");
                                            nat_id_length = rs.getInt("Nat_Id_Length");
                                            Family_No_Link_Yn =rs.getString("Family_No_Link_Yn")== null ?  "N" : rs.getString("Family_No_Link_Yn");
                                            Family_No_Prompt =rs.getString("Family_No_Prompt")== null ? "Head of the Family" : rs.getString("Family_No_Prompt");
                                            First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
											names_in_oth_lang_yn=rs.getString("names_in_oth_lang_yn");
                                            First_Name_Order = rs.getInt("First_Name_Order");
                                            First_Name_Prompt = rs.getString("First_Name_Prompt")==null ? "First Name" : rs.getString("First_Name_Prompt");
                                            Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
											
                                            Second_Name_Order = rs.getInt("Second_Name_Order");
                                            Second_Name_Prompt = rs.getString("Second_Name_Prompt")==null ? "Second Name" : rs.getString("Second_Name_Prompt");
                                            Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
                                            Third_Name_Order = rs.getInt("Third_Name_Order");
                                            Third_Name_Prompt = rs.getString("Third_Name_Prompt")==null ? "Third Name" : rs.getString("Third_Name_Prompt");
											
											 First_Name_loc_lang_Prompt=checkForNull(rs.getString("First_Name_loc_lang_Prompt"));
											Second_Name_loc_lang_Prompt=checkForNull(rs.getString("Second_Name_loc_lang_Prompt"));
											Third_Name_loc_lang_Prompt=checkForNull(rs.getString("Third_Name_loc_lang_Prompt"));
											Family_Name_loc_lang_Prompt=checkForNull(rs.getString("Family_Name_loc_lang_Prompt"));

                                            Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
                                            Family_Name_Order = rs.getInt("Family_Name_Order");
											accept_oth_alt_id_yn = rs.getString("accept_oth_alt_id_yn")==null ? "N" : rs.getString("accept_oth_alt_id_yn");
											name_dervn_logic = rs.getString("name_dervn_logic")==null ? "N" : rs.getString("name_dervn_logic");
											
											alt_id1_accept_alphanumeric_yn = rs.getString("alt_id1_accept_alphanumeric_yn")==null ? "N" : rs.getString("alt_id1_accept_alphanumeric_yn");
											
											
											if 	(pat_name_as_multipart_yn.equals("N"))
										{
												Family_Name_Order = 4;
												//family_name_length = "40";
											}
											else
											{
												//family_name_length = "15";
											
										}											
											Family_Name_Prompt = rs.getString("Family_Name_Prompt")==null ? "Family Name" : rs.getString("Family_Name_Prompt");
                                            Res_Area_Prompt = "Area";
                                            Alt_Id1 = rs.getString("alt_id1_desc")==null?"Alt ID No":rs.getString("alt_id1_desc");
                                            Alt_Id2 = rs.getString("alt_id2_desc")==null?"":rs.getString("alt_id2_desc");
                                            Alt_Id3 = rs.getString("alt_id3_desc")==null?"":rs.getString("alt_id3_desc");
                                            Alt_Id4 = rs.getString("alt_id4_desc")==null?"":rs.getString("alt_id4_desc");
											
                                            alt_id1_length = rs.getInt("alt_id1_length");
                                            alt_id2_length = rs.getInt("alt_id2_length");
                                            alt_id3_length = rs.getInt("alt_id3_length");
                                            alt_id4_length = rs.getInt("alt_id4_length");
											
                                            addl_field1_prompt = rs.getString("addl_field1_prompt")==null?"":rs.getString("addl_field1_prompt");
                                            addl_field1_length = rs.getInt("addl_field1_length");
                                            addl_field2_prompt = rs.getString("addl_field2_prompt")==null?"":rs.getString("addl_field2_prompt");
                                            addl_field2_length = rs.getInt("addl_field2_length");   
                                            addl_field3_prompt = rs.getString("addl_field3_prompt")==null?"":rs.getString("addl_field3_prompt");
                                            addl_field3_length = rs.getInt("addl_field3_length");  
											
                                            addl_field4_prompt = rs.getString("addl_field4_prompt")==null?"":rs.getString("addl_field4_prompt");
                                            addl_field4_length = rs.getInt("addl_field4_length");   
                                            addl_field5_prompt = rs.getString("addl_field5_prompt")==null?"":rs.getString("addl_field5_prompt");
                                            addl_field5_length = rs.getInt("addl_field5_length");
											
											accept_national_id_no_yn = rs.getString("accept_national_id_no_yn");
											if (accept_national_id_no_yn==null) accept_national_id_no_yn = "N";

											nat_id_accept_alphanumeric_yn = rs.getString("nat_id_accept_alphanumeric_yn");
											if (nat_id_accept_alphanumeric_yn==null) nat_id_accept_alphanumeric_yn = "N";
											if (separate_file_no_yn.equals("N")) mrn_length= rs.getString("Patient_Id_Length");
											/*Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
											alt_id1_pat_sch_exact_yn=rs.getString("alt_id1_pat_sch_exact_yn")==null?"N":rs.getString("alt_id1_pat_sch_exact_yn");
											alt_id2_pat_sch_exact_yn=rs.getString("alt_id2_pat_sch_exact_yn")==null?"N":rs.getString("alt_id2_pat_sch_exact_yn");
											alt_id3_pat_sch_exact_yn=rs.getString("alt_id3_pat_sch_exact_yn")==null?"N":rs.getString("alt_id3_pat_sch_exact_yn");
											alt_id4_pat_sch_exact_yn=rs.getString("alt_id4_pat_sch_exact_yn")==null?"N":rs.getString("alt_id4_pat_sch_exact_yn");
											
											
                                        }
                                    }
                                }catch(Exception e) { out.println(e.toString());}
                                finally
                                {
                                    if (pstmt != null) pstmt.close();
                                    if (rs != null) rs.close();
                                }

                                /*  pstmt = con.prepareStatement("select contact_mode, short_desc from mp_contact_mode_lang_vw where contact_mode in ('PRN', 'ORN') and language_id = '"+locale+"'");
								  try{
                                    rs = pstmt.executeQuery();
									String cnt_mode="";
									while(rs!=null && rs.next()){
										cnt_mode=rs.getString("contact_mode");
										if(cnt_mode.equals("PRN"))
											prn_label=rs.getString("short_desc");
										if(cnt_mode.equals("ORN"))
											orn_label=rs.getString("short_desc");
									}
								  }catch(Exception ex){
									 ex.printStackTrace();
								  }finally{
									  if (pstmt != null) pstmt.close();
									  if (rs != null) rs.close();
								  }*/

                                
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Soundex));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(family_org_id_accept_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(func_idpassed));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
 

									String nat_id_onKeyPress = "";
										
									if(nat_id_accept_alphanumeric_yn.equals("Y"))
									{
										nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
									}
									else
									{
										nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
									}
									//Maheshwaran K added for GHL-CRF-0657.2 as 06-09-2923	
						
									if(ndhm_appl_YN.equals("Y")) {
										
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_ws_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sessionID));
            _bw.write(_wl_block26Bytes, _wl_block26);
	}
									else {
									if (accept_national_id_no_yn.equals("Y"))
									{ 
										if (ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC") && nat_id_check_digit_id.equals(""))
										{
										
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(function_name.equals("01")){
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nat_id_check_digit_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(function_name.equals("01")){
            _bw.write(_wl_block35Bytes, _wl_block35);
}
									else if(function_name.equals("05")){ 
            _bw.write(_wl_block36Bytes, _wl_block36);
 } 
									else if( function_name.equals("07")){ 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sessionID));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_ws_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
} // MOHE-CRF-0164.1
									else { 
            _bw.write(_wl_block39Bytes, _wl_block39);
 } 
            _bw.write(_wl_block40Bytes, _wl_block40);

										if(function_name.equals("01")){
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
}
										else 
										 {
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
									}else{
            _bw.write(_wl_block46Bytes, _wl_block46);
}	
            _bw.write(_wl_block47Bytes, _wl_block47);
									
									}
            _bw.write(_wl_block48Bytes, _wl_block48);
if(!Alt_Id1.equals("")){
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Alt_Id1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);

									if(!isInsuranceCardReader){//Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020
									if(!Alt_Id2.equals("")){
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Alt_Id2));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block55Bytes, _wl_block55);
}
								}else{
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(insurance_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(insurance_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
if(!Alt_Id3.equals("")){
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Alt_Id3));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
if(!Alt_Id4.equals("")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(Alt_Id4));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
if(accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

									
									pstmt = con.prepareStatement(Qry_For_AltType);
									pstmt.setString(1,locale);
									rs = pstmt.executeQuery();	
									
									if(rs != null){
										while (rs.next()){          
											out.println ( "<Option value=\""+rs.getString("alt_id_type")+"\" >"+rs.getString("SHORT_DESC")+"</Option>" ) ;
										}
									}	
								
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block73Bytes, _wl_block73);

							if(pat_name_as_multipart_yn.equals("Y")){  
									
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   width='25%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   width='25%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td    width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='15' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
									
                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
										firstRowElement="Y";

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								}
                                    }
                                   

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='First_Name' id='First_Name' >");
                                }
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Second_Name' id='Second_Name' >");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Third_Name' id='Third_Name' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Family_Name' id='Family_Name' >");
                                    }
									 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td  width='25%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td  width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td  width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								}
                                    }
                                   

									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='25%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='25%'  class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								}
                                    }
                         
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='25%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                   else
									  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) {
									   if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td  width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
										
								    /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								}

								   }
								      else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }

                                     
								}
								
								if (pat_name_as_multipart_yn.equals("N"))	
								{			out.println("<td nowrap  width='25%' class='label'>" + Family_Name_Prompt + "</td>");
											out.println("<td  nowrap class='fields' width='25%'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);EnableSearchBy(this);'     style=\"text-align:left\">");
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
									}
										else
										out.println("</td>");
                                    
                            /*        else {
                                        out.println("<td  width='13%' class='label'>&nbsp;</td>");
                                        out.println("<td  width='11%' class='label'>&nbsp;&nbsp;</td>");
                                    }*/ 
            _bw.write(_wl_block74Bytes, _wl_block74);
	
					if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) 
					  {
						 if (pat_name_as_multipart_yn.equals("N"))	
						 { 
            _bw.write(_wl_block75Bytes, _wl_block75);
}
					 }
                  
            _bw.write(_wl_block76Bytes, _wl_block76);

					      if(names_in_oth_lang_yn.equals("Y")){
							firstRowElement="";
							firstRowCompleted="";
					
							if(!language_direction.equals("R"))
							{
						
					      if(pat_name_as_multipart_yn.equals("Y")){  

								
            _bw.write(_wl_block77Bytes, _wl_block77);
 
										
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields' ><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									 firstRowElement="Y";

                                    }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==1 )
									{
										 out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
									}
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										firstRowElement="Y";


                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										firstRowElement="Y";


                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
									
                                        out.println("<td   class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										firstRowElement="Y";
                                    }
                                   

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
                                }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==0)
								{
									 out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
								}
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='second_name_loc_lang' id='second_name_loc_lang'>");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='third_name_loc_lang' id='third_name_loc_lang' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='family_name_loc_lang' id='family_name_loc_lang' >");
                                    }
									 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									 if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
										//out.println("Second");
                                        out.println("<td   class='label' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										 out.println("></td>");
										 if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                   

									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                     
										out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    
									

									
                                
            _bw.write(_wl_block78Bytes, _wl_block78);
if(pat_name_as_multipart_yn.equals("Y")){  }
            _bw.write(_wl_block79Bytes, _wl_block79);

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
									if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td></tr><tr>");
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"'	onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this)' ");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									   out.println("></td>");
                                    }
                                   else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) {
									   if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td    class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\">");
                                        out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
										
								   }
						       else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
						  }
										if (pat_name_as_multipart_yn.equals("N"))	
										{
											 out.println("<td nowrap   class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
											out.println("<td  nowrap   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);EnableSearchBy(this);'style=\"text-align:left\">");
//											String selects1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By_Lang' id='Search_By_Lang' disabled><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
							
										}

										out.println("</td>");

						}
						else
						{
							/**** Added for Arabic ****/
							firstRowElement="";
							firstRowCompleted="";
					      if(pat_name_as_multipart_yn.equals("Y")){  
								
            _bw.write(_wl_block77Bytes, _wl_block77);
 
										
									  
            _bw.write(_wl_block80Bytes, _wl_block80);
if(pat_name_as_multipart_yn.equals("Y")){  }
            _bw.write(_wl_block81Bytes, _wl_block81);

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										//firstRowElement="Y";
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										//firstRowElement="Y";
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2) {
                                        out.println("<td   class='arabic' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"'	onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this)' ");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									   out.println("></td>");
									   //firstRowElement="Y";
                                    }
                                   else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2) {
                                        out.println("<td    class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\">");
                                        out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									// firstRowElement="Y";
										
								   }else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }


									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}*/
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}*/
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}*/
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                     
										out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}*/
                                    }else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
									
            _bw.write(_wl_block82Bytes, _wl_block82);

									
									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									 /*
									 if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
										 
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/

                                        out.println("<td   class='arabic' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										 out.println("></td>");
										 /*
										 if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										/*
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										/*
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    }else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }


                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields' ><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)' ");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");

                                    }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==3 )
									{
										 out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
									}
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");


                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										} */
                                        out.println("<td   class='arabic' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");


                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
									
                                        out.println("<td   class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
                                    }else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
                                   
            _bw.write(_wl_block83Bytes, _wl_block83);


                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
                                }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==0)
								{
									 out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
								}
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='second_name_loc_lang' id='second_name_loc_lang'>");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='third_name_loc_lang' id='third_name_loc_lang' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='family_name_loc_lang' id='family_name_loc_lang' >");
                                    }


									
                              
						  }
										if (pat_name_as_multipart_yn.equals("N"))	
										{
											 out.println("<td    class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
											out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);EnableSearchBy(this);'   dir='RTL' >");
//											String selects1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By_Lang' id='Search_By_Lang' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
							
										}

										out.println("</td>");

										/**** End of Arabic changes ****/

						}
						} 
            _bw.write(_wl_block84Bytes, _wl_block84);
if(pat_name_as_multipart_yn.equals("N")){
            _bw.write(_wl_block85Bytes, _wl_block85);
}else{
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(selm));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(self));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
if(Family_No_Link_Yn.equals("Y")) {
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block106Bytes, _wl_block106);
} else {
            _bw.write(_wl_block107Bytes, _wl_block107);
}
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

				             	pstmt1 = con.prepareStatement(Qry_For_PatSeries);
								pstmt1.setString(1,locale);
							   rs1= pstmt1.executeQuery();
					          while(rs1.next())
					          {	
								pat_ser_grp_code=rs1.getString("pat_ser_grp_code");
								pat_ser_grp_desc=rs1.getString("short_desc");
								out.println( "<option value='"+pat_ser_grp_code+"' >"+pat_ser_grp_desc) ;
						      }
				       
						 
					    
	                   
            _bw.write(_wl_block114Bytes, _wl_block114);
            _bw.write(_wl_block115Bytes, _wl_block115);
if(family_org_id_accept_yn.equals("Y")){
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
}else{
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block124Bytes, _wl_block124);
if(family_org_id_accept_yn.equals("Y")){
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block129Bytes, _wl_block129);
}
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(smart_contact_no));
            _bw.write(_wl_block132Bytes, _wl_block132);
if(function_name.equals("01") || function_name.equals("05")){
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);

								
                                try{
                                    pstmt = con.prepareStatement(Qry_For_CntMode);
									pstmt.setString(1,locale);
                                    rs = pstmt.executeQuery();
                                        if(rs != null)
                                            while(rs.next()) {
                                                String Contact_Mode = rs.getString("contact_mode");
                                                String short_desc=rs.getString("short_desc");
                                                out.println("<Option value='" + Contact_Mode + "'>" + short_desc);
                                            }
                                }catch(Exception e) { out.println(e.toString());}
                                finally
                                {
                                    if (pstmt != null) pstmt.close();
                                    if (rs != null) rs.close();
                                }
                                
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

                                try
                                {
									
                                    pstmt = con.prepareStatement(Qry_for_OrderBy);
									pstmt.setString(1,locale);
                                    rs = pstmt.executeQuery();
                                        if(rs != null)
                                            while(rs.next()) 
                                            {
                                                if(!rs.getString(1).equals("Pat_Photo")) 
                                                {
                                                    String order_field_code = rs.getString("field_name");
                                                    String order_field_desc =rs.getString("field_desc");
                                                    out.println("<Option value='" + order_field_code + "'>" + order_field_desc);
                                                }
                                            }
                                }
                                catch(Exception e) { out.println(e.toString());}
                                
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(sdisable));
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
if(func_act.equals("MO")){
            _bw.write(_wl_block159Bytes, _wl_block159);
}else{
            _bw.write(_wl_block160Bytes, _wl_block160);
}
            _bw.write(_wl_block161Bytes, _wl_block161);
 if(!addl_field1_prompt.equals(""))
                               {
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(addl_field1_prompt));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(addl_field1_length));
            _bw.write(_wl_block164Bytes, _wl_block164);
}
                               else 
                               {
            _bw.write(_wl_block165Bytes, _wl_block165);
}
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
 if (!addl_field2_prompt.equals(""))
                               {
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(addl_field2_prompt));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(addl_field2_length));
            _bw.write(_wl_block169Bytes, _wl_block169);
}
                               else 
                               {
            _bw.write(_wl_block170Bytes, _wl_block170);
}
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
 if (!addl_field3_prompt.equals(""))
                               {
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(addl_field3_prompt));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(addl_field3_length));
            _bw.write(_wl_block174Bytes, _wl_block174);
}
                               else 
                               {
            _bw.write(_wl_block175Bytes, _wl_block175);
}
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
 if (!addl_field4_prompt.equals(""))
                               {
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(addl_field4_prompt));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(addl_field4_length));
            _bw.write(_wl_block180Bytes, _wl_block180);
}
                               else 
                               {
            _bw.write(_wl_block181Bytes, _wl_block181);
}
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);
 if (!addl_field5_prompt.equals(""))
                               {
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(addl_field5_prompt));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(addl_field5_length));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(addl_field5_length));
            _bw.write(_wl_block190Bytes, _wl_block190);
}
                               else 
                               {
            _bw.write(_wl_block191Bytes, _wl_block191);
}
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(docDisableField));
            _bw.write(_wl_block194Bytes, _wl_block194);
if (!file_type_appl_yn.equals("Y")){
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(docDisableField));
            _bw.write(_wl_block198Bytes, _wl_block198);
}else{
            _bw.write(_wl_block199Bytes, _wl_block199);
}
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
      
            }catch(Exception e) {
                out.println(e.toString());
            }
            finally {
                if(pstmt != null) pstmt.close();
				if(pstmt1 != null) pstmt1.close();
                if(rs !=null) rs.close();
				if(rs1 !=null) rs1.close();
                if(con!=null) ConnectionManager.returnConnection(con,request);                
            }            
        
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(window_styl));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(close_yn));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(register_button_yn));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(Soundex));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(cr_jsp_name));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(cr_window_styl));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(cr_close_yn));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(cr_win_top));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(cr_win_width));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(cr_win_height));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(cr_act_yn));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(cr_srr));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(cr_register_button_yn));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(cr_func_act));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(cr_defaultgender));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(cr_enablegenderyn));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(cr_function_id));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(cr_func_idpassed));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(cntPrefFac));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(review_nb_links_bef_reg_yn));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(Smartcard_path));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(nat_id_accept_alphanumeric_yn));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(name_dervn_logic));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(isAddressLengthIncAppl));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(alt_id1_pat_sch_exact_yn));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(alt_id2_pat_sch_exact_yn));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(alt_id3_pat_sch_exact_yn));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(alt_id4_pat_sch_exact_yn));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(alterIdSearch));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(isAlternateId));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(alternate_no));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(fam_name_ind));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(isInsuranceCardReader));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(dft_national_id));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(biometric_authentication_yn));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(suspend_inactive_pat_yn));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(ndhm_appl_YN));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(alterIdSearch));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(isAlternateId));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(alterIdSearch));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(isAlternateId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alternate_no));
            _bw.write(_wl_block256Bytes, _wl_block256);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startsWith.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.endsWith.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contains.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ABHANumber.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Insurance.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.soundex.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ethnic.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.generic.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.year.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.HeadPatientID.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.area.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.membership.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.organizationmember.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedmemberfamily.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.relatedmembernonfamily.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.nonorganizationmember.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Organization.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.suborgn.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contactNo.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startsWith.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.endsWith.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contains.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mode.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextofkin.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firsttonotify.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.homephoneno.label", java.lang.String .class,"key"));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.employmentdetails.label", java.lang.String .class,"key"));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchIn.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientMaster.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Both.label", java.lang.String .class,"key"));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DuplicateMaster.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.morecriteria.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Deceasedonly.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Suspendedonly.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Inactiveonly.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mothername.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegistrationMode.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Rapid.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OldFileNo.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientFileNo.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CurrentPatientClass.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IP.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DC.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OP.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.EM.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }
}
