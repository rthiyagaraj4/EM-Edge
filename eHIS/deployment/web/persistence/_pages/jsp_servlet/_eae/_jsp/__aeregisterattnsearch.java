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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aeregisterattnsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AERegisterAttnSearch.jsp", 1743148994824L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n    <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n     <script language=\'javascript\' src=\'../../eAE/js/AERegisterAttn.js\'></script>\n\t<Script src=\"../../eMP/js/SmartCard.js\" language=\"JavaScript\"></Script>\n\t<!-- Added by Ashwin K for AAKH-CRF-0150-->\n\t<!--<Script src=\"../../eMP/js/SmartCard01.js\" language=\"JavaScript\"></Script>-->\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n\t<Script src=\"../../eMP/js/json02.js\"></Script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\n <!-- Added By Ashwin K for AAKH-CRF-0150 -->\n   \n<link href=\"../../eCommon/html/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\">\n<!-- Ended By Ashwin K for AAKH-CRF-0150 -->\n<script> \n\t<!-- Added By Ashwin K for AAKH-CRF-0150 -->\n\t\t$(document).ready(function(){\n\t$(\"#M_btn1\").prop(\'disabled\', false); \n\t$(\"#National_Id_No\").prop(\'disabled\', true);\n\t$(\"#EmiratesID_edit\").click(function() {\n\tif($(\'#EmiratesID_edit\').is(\':checked\'))\n\t\t{\n\t\tvar auth_userEmirates = EditEmiratesID_authScr();\n\t\tif(auth_userEmirates == true)\n\t\t\t{\n\t\t\t$(\"#National_Id_No\").prop(\'disabled\', false);\n\t\t\t$(\"#M_btn1\").prop(\'disabled\', true); \n\t\t\t}\n\telse\n\t {\n\t\t$(\'#EmiratesID_edit\').prop(\'checked\', false);\n\t }\n }\n else\n\t{\n\t\t$(\"#National_Id_No\").prop(\'disabled\', true);\n\t\t$(\"#M_btn1\").prop(\'disabled\', false); \n\t}\n        });\n\t});\nasync function EditEmiratesID_authScr()\n{\t\n\tvar retVal=new Array();\n\tvar dialogHeight= \"10vh\" ;\n\tvar dialogWidth\t= \"22vw\" ;\n\tvar dialogTop = \"225\" ;\n\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\tretVal = await window.showModalDialog(\"../../eSM/jsp/AuthorizeMain.jsp?mode=s\",arguments,features);\n\treturn retVal;\n}\n<!-- Ended By Ashwin K for AAKH-CRF-0150 -->\n\t\t/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/\n\t\t\n\t\tfunction regAttForNB(){\n\t\t\tif(document.forms[0].invoke_from.value==\'EMER_REGN_NB\' && document.forms[0].nb_patient_id.value!=\"\"){\n\t\t\t\tdocument.forms[0].frameRef.value=\"parent.parent\";\n\t\t\t\tdocument.forms[0].patient_id.value=document.forms[0].nb_patient_id.value;\n\t\t\t\tdocument.forms[0].patient_id.onblur();\n\t\t\t\tdocument.forms[0].patient_id.disabled=true;\n\t\t\t\tparent.parent.frames[0].document.getElementById(\"home\").disabled = true;\n\t\t\t\tparent.parent.frames[0].document.getElementById(\"reset\").disabled = true;\n\t\t\t\tdocument.forms[0].clear.disabled = true;\n\t\t\t}\n\t\t}\n\t\t/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/\n\t\n\t</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="      \n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n</head>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t <!--Added by Ashwin K for AAKH-CRF-0150 -->\n\t <script>\n\tfunction MButton_click_AEReg()\n\t\t{\n\t\tvar res = RegAttnSearch_ReadDF1_onclick(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =");\n\t\tvar arr = res.split(\"!~\");\n\t\tvar res_natid = arr[0].replace(/^\\s+|\\s+$/gm,\'\');\n\t\tvar res_mobno = arr[1].replace(/^\\s+|\\s+$/gm,\'\');\n\t\tvar patcnt = 0;\n\t\tvar p_id = \"\";\n\t\t//var res = \"\";\n\t\t$.ajax({\n\t\t\ttype: \"POST\",\n\t\t\turl: \"../../eMP/jsp/getPatientCount.jsp\",\n\t\t\tdata: {\n\t\t\t\tNatID : res_natid,\n\t\t\t\tsmart_data : res\t\n\n\t\t\t},\n\t\t\tasync: false\n\t\t})\n\t\t.done (function(data, textStatus, jqXHR) { \n\t\t  res = data;\nvar res1 = res.substring(res.indexOf(\"<patcnt>\")+8,res.indexOf(\"</patcnt>\"));\nvar res2 = res.substring(res.indexOf(\"<patid>\")+7,res.indexOf(\"</patid>\"));\npatcnt = parseInt(res1);\np_id = res2;  \n});\nif(patcnt == 0)\n{\n\talert(getMessage(\'MOBILE_NO_SEARCH\',\'MP\'));\n\tcallPatientSearch_MBtn(res_mobno);\n\n}\nelse\n{\n\tdocument.getElementById(\"patient_id\").value= p_id;\n\tsearchPatient(p_id);\n}\n}\n</script>\n\t <!-- Ended by Ashwin K for AAKH-CRF-0150 -->\n\t <body OnMouseDown=\'CodeArrest()\' onLoad=\'setFocus();disReset();regAttForNB();\' onKeyDown = \'lockKey()\'>\n\t <form name=\"ae_patient_form\" id=\"ae_patient_form\">\n\t   <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t     <tr>\n\t\t    <td class=\'label\' width=\'18%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;&nbsp;<span class=\'field\'><input type=\"checkbox\" name=\'eReg\' id=\'eReg\' onClick=\"eRegistration()\"></span></td>\n\t\t    <td class=\'LABEL\'  width=\'25%\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;&nbsp;<span class=\'field\'><input type=\'text\'  name=patient_id id=patient_id value=\"\" maxLength=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' size=\'20\' onKeyPress=\"return(CheckForSpecChars(event))\" \n\t\t\tonBlur=\"changeCase(this);disReset();searchPatient(document.forms[0].patient_id)\">&nbsp;<input type=\"button\" name=\"patient_search\" id=\"patient_search\" class=BUTTON value=\"?\" onChange=\'disReset();\' onClick=\"if(document.forms[0].patient_id.value==\'\'){callPatientSearch()}\" ></span>\t\n                ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" <!--Below line modified for this CRF MMS-QH-CRF-0162.1-->\n\t\t\t\t\t\t  <img  align=\'center\'  style=\"visibility:hidden\"  id=\"Update_pat\" Title=\"Change Patient Details\" src=\'../../eCommon/images/update.jpg\' onClick=\"getPatientDetails(document.forms[0].patient_id.value);OnSearch()\"/>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n            </td>\t\n\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t<td nowrap align=\'right\' class=\"label\" width=\'10%\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</td>\n\n\t\t\t\t\t\t\t\t\t<!-- Added id=\"National_Id_No\" by Ashwin K for AAKH-CRF-0150 -->\n\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"10%\" nowrap><input type=\"text\" name=\"National_Id_No\" id=\"National_Id_No\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="id=\"National_Id_No\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" value=\"\"size=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" maxlength=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" \n\t\t\t\t\t\t\t\t\tonkeypress=\"return allowValidNumber(this,event,2, 0);\"\tonBlur=\'makeValidQueryCriteria(this);searchPatient(document.forms[0].National_Id_No);\' onFocus=\"\" tabindex=1> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t<input type=button id=\'M_btn1\' value=\'M\' class= \'button\' name=\"National_Id_Button\" id=\"National_Id_Button\" onClick=\'MButton_click_AEReg()\'>\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"EmiratesID_edit\" name=\"EmiratesID_edit\" id=\"EmiratesID_edit\"  >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="<!--Added  by santhosh for TH-KW-CRF-0019.1 -->\n\t\t\t\t\t\t\t\t\t<input type=button id=\'M_btn1\' value=\'M\' class= \'button\' name=\"National_Id_Button\" id=\"National_Id_Button\" onClick=\'MButton_click_AEReg()\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<!--Added  by santhosh for TH-KW-CRF-0019.1 -->\n\t\t\t\t\t\t\t\t\t<input type=button id=\'M_btn1\' value=\'M\' class= \'button\' name=\"National_Id_Button\" id=\"National_Id_Button\" onClick=\'RegAttnSearch_ReadDF1_onclick(\"AE_REGATTN\")\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<!--Added  by Lakshmanan for MOHE-CRF-0164.1 -->\n\t\t\t\t\t\t\t\t\t<input type=hidden  value=\'M\' class= \'button\' name=\"National_Id_Button\" id=\"National_Id_Button\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t<input type=button  value=\'M\' class= \'button\' name=\"National_Id_Button\" id=\"National_Id_Button\" onClick=\'RegAttnSearch_ReadDF1_onclick()\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n<!-- Added by Ashwin K for AAKH-CRF-0158 -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<!--\t <applet code=\"CardReaderApplet.class\" name=\"CardReader\"\n\t\t\t\t\t\tcodebase=\"../../eMP/CardReader/\" archive=\"CardReaderApplet.jar\" width=\"5\"\n\t\t\t\t\t\theight=\"5\">\n\t\t\t\t\t\t<PARAM name=\"button_width\" value=\"0\" />\n\t\t\t\t\t\t<PARAM name=\"button_height\" value=\"0\" />\n\t\t\t\t\t\t<PARAM name=\"button_label\" value=\"0\" />\t\t\t\t\t\t\n\t\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\t\tSorry, Your browser does not support Java applet!\n\t\t\t\t\t\t</applet>  -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- Commented above old card reader applet and added for AAKH-CRF-0158 -->\n\t\t\t\t\t\t <APPLET style=\"border:solid 1px gray\" id=\"PublicDataWebComponent\" name=\"PublicDataWebComponent\" codebase=\"../../eMP/CardReader/\" CODE=\"emiratesid.jio.webcomponents.PublicDataReader\"\n                                                        ARCHIVE=\"PublicDataApplet-Sagem.jar\" WIDTH=\"0\" HEIGHT=\"0\">\n                                                        <param name=\"EncryptParameters\" value=\"false\" />\n                                                        <param name=\"RelativeCertPath\" value=\"certs\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<param name=\"separate_jvm\" value=\"true\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<PARAM name=\"button_label\" value=\"0\" />\t\n                                                         This browser does not support Applets.\n                                                    </APPLET> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n<!-- Ended by Ashwin K for AAKH-CRF-0158 -->\n\t\t\t\t\t\t\t\t\t<!-- Ended by Ashwin K for AAKH-CRF-0150 -->\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t<td nowrap align=\'right\'  class=\"label\" nowrap width=\'10%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"10%\" nowrap><input type=\"text\" name=\"National_Id_No\" id=\"National_Id_No\" value=\"\"size=\"17\" maxlength=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" \n\t\t\t\t\t\t\t\t\tonkeypress=\"return allowValidNumber(this,event,2, 0);\"\tonBlur=\'makeValidQueryCriteria(this);searchPatient(document.forms[0].National_Id_No)\' onFocus=\"\" tabindex=1></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t<td nowrap align=\'right\'  class=\"label\" nowrap width=\'22\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n           \n\t\t\t<td class=\'label\' width=\'25%\' nowrap >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;&nbsp;<span class=\'field\'><input type=\'text\' name=\'referal_id\' id=\'referal_id\' value=\'\' maxlength=\'14\' size=\'14\'  onBlur=\'changeCase(this);searchPatient(document.forms[0].referal_id)\'>&nbsp;<input type=\'button\' class=\'button\' value=\'?\' name=\'ref_id_search\' id=\'ref_id_search\' onClick=\'getReferralID()\' ></span></td>\n           \n\t\t    <td class=\'field\'   width=\'18%\'><input type=\"button\" name=\"search\" id=\"search\" class=BUTTON value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'  onClick=\"OnSearch();\">&nbsp;<input type=\"button\" name=\"clear\" id=\"clear\" class=BUTTON value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onClick=\"clearing();\">\t\n            </td>\n\t\t\t\n\t      </tr>\t\n   \t   </table> \n           <input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t   <input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'> \n\t\t   <input type=\'hidden\' name=\'patFlag\' id=\'patFlag\' value=\'\'> \n\t\t   <input type=\'hidden\' name=\'register_pat_yn\' id=\'register_pat_yn\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t   <input type=\'hidden\' name=\'attendance_for_inpat_yn\' id=\'attendance_for_inpat_yn\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t   <input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t   <!--Below line added by venkatesh.s on 02-April-2014 against 48233 -->\n\t\t   <input type=\'hidden\' name=\'ext_system_interface_yn\' id=\'ext_system_interface_yn\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"> \n\t\t   \n\t\t   <!-- // (venkat s) for PE_EXE ae regn attn function -->\n\t\t\t<input type=\'hidden\' name=\'prev_visit_hrs\' id=\'prev_visit_hrs\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'visit_status\' id=\'visit_status\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t<input type=\'hidden\' name=\'entitlement_by_cat_yn\' id=\'entitlement_by_cat_yn\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t<input type=\'hidden\' name=\'p_alt_id2_type\' id=\'p_alt_id2_type\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t<input type=\'hidden\' name=\'p_alt_id3_type\' id=\'p_alt_id3_type\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t<input type=\'hidden\' name=\'p_alt_id4_type\' id=\'p_alt_id4_type\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t<!--added by munisekhar for MMS-QH-CRF-0162-->\n\t\t\t<input type=\'hidden\' name=\'isSiteSpe_change_pat_dtls\' id=\'isSiteSpe_change_pat_dtls\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"> \n\t\t\t<input type=\'hidden\' name=\'userFunRightsCount\' id=\'userFunRightsCount\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"> <!--Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]-->\n\t\t\t<!-- below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272] -->\n\t\t\t<input type=\'hidden\' name=\'max_hrs_for_re_attend\' id=\'max_hrs_for_re_attend\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\n<!--end CRF  Bru-HIMS-CRF-152 [IN030272]-->\t\n\t\t<!-- Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start-->\n\t\t\t<input type=\'hidden\' name=\'nb_patient_id\' id=\'nb_patient_id\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t<input type=\'hidden\' name=\'invoke_from\' id=\'invoke_from\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t<input type=\'hidden\' name=\'frameRef\' id=\'frameRef\' value=\"top.content\">\n\t\t<!-- Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End-->\n\n\t\t<input type=\'hidden\' name=\'isAERegisterTypeAutoUpdateAppl\' id=\'isAERegisterTypeAutoUpdateAppl\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"> <!-- added by mujafar for KDAH-CRF-0526 -->\n\t\t<input type=\'hidden\' name=\'dflt_emer_follow_type_code\' id=\'dflt_emer_follow_type_code\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=\'hidden\' name=\'dflt_time_reg_auto_update\' id=\'dflt_time_reg_auto_update\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023\t-->\n\t\t<input type=\'hidden\' name=\'biometric_authentication_yn\' id=\'biometric_authentication_yn\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\n\n\t  <script>\n\t\tparent.parent.frames[0].document.forms[0].reset.disabled=true;\n\t\n\t</script>\n\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t<!--for smart card-->\n\t\t\t\t<input type=\"hidden\" name=\"txtSmartcard_path\" id=\"txtSmartcard_path\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"txtSmartcard_dup\" id=\"txtSmartcard_dup\" value=\"\">\n\t\t\t\t<!--for smart card-->\n\t\t\t\t<!--for Alkhaleej smart card-->\n\t\t\t\t<input type=\"hidden\" name=\"txtSmart_fn_name\" id=\"txtSmart_fn_name\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\n\t\t\t\t<!-- Tested and Added by Ashwin K for AAKH-CRF-0150-->\n\t\t\t\t<input type=\"hidden\" id=\"retreived_natid\" value=\"\">\n\t\t\t\t<input type=\"hidden\" id=\"retreied_mobno\" value=\"\">\n\t\t\t\t<input type=\"hidden\" id=\"pat_cnt\" value=\"0\">\n\t\t\t\t<!-- Tested and Ended by Ashwin K for AAKH-CRF-0150-->\n\t\t  </form> \n\t\n\t\t   \n\t\t  </body>\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n</html>\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

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

	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		
            _bw.write(_wl_block8Bytes, _wl_block8);

	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>\n"+
						"<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n"
						);
		}
	}
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
 
        Connection con               = null;
    	PreparedStatement pstmt		 = null;
        ResultSet rset               = null ;
		java.sql.Statement stmt		 = null;
		String Smartcard_path="" ; //added for smart card 
		String function_name="" ; //added for Alkhalej smart card 

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String facilityId			 = (String)session.getValue("facility_id");
		String bl_install_yn         = (String)session.getValue("bl_operational");
		bl_install_yn				 = (bl_install_yn==null)?"N":bl_install_yn;
		String patient_id_length	 = "";
		String ext_system_interface_yn	 = "";
		String nat_id_length	 = "";
		String nat_id_prompt	 = "";
		String accept_national_id_no_yn	 = "";
		String oper_stn_id			 = request.getParameter("oper_stn_id");
		oper_stn_id					 = (oper_stn_id==null)?"":oper_stn_id;
		oper_stn_id					 = (oper_stn_id==null)?"":oper_stn_id;
		String user_id 			 	 = (String)session.getValue("login_user") ;
		user_id					 = (user_id==null)?"":user_id;
		String params				= request.getQueryString() ;
		String register_pat_yn="N";
		String reg_attendance_for_inpat_yn= request.getParameter("attendance_for_inpat_yn");
		reg_attendance_for_inpat_yn					 = (reg_attendance_for_inpat_yn==null)?"N":reg_attendance_for_inpat_yn;
		// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
		String max_hrs_for_re_attend=request.getParameter("max_hrs_for_re_attend");
		max_hrs_for_re_attend					 = (max_hrs_for_re_attend==null)?"N":max_hrs_for_re_attend;
		//end CRF  Bru-HIMS-CRF-152 [IN030272]
		
		String p_alt_id2_type = "" , p_alt_id3_type = "", p_alt_id4_type = "";
		String entitlement_by_cat_yn = "";
		String biometric_authentication_yn="N";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		String nb_patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String invoke_from			= request.getParameter("invoke_from") == null ? "" : request.getParameter("invoke_from");
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
		
		String dflt_emer_follow_type_code = request.getParameter("dflt_emer_follow_type_code"); // added by mujafar for KDAH-CRF-0526
		String  dflt_time_reg_auto_update = request.getParameter("dflt_time_reg_auto_update");// added by mujafar for KDAH-CRF-0526

		int v_cnt=0;
		try{
					con                  = ConnectionManager.getConnection(request);
					Boolean isAERegisterTypeAutoUpdateAppl =	CommonBean.isSiteSpecific(con, "AE", "AE_REG_TYPE_AUTO_UPDATE"); // added by mujafar for KDAH-CRF-0526
				    StringBuffer patLength = new StringBuffer();
				//  VENKAT S PE_EXE (ae_regn_attn function)
					patLength.append(" select patient_id_length, ext_system_interface_yn, nat_id_length, NVL (nat_id_prompt, 'National ID No') nat_id_prompt,alt_id1_type, alt_id2_type, alt_id3_type, alt_id4_type, entitlement_by_pat_cat_yn, accept_national_id_no_yn,biometric_authentication_yn from MP_PARAM  where MODULE_ID='MP' ");
					pstmt   = con.prepareStatement(patLength.toString());
					rset = pstmt.executeQuery();
					while(rset!=null && rset.next())
					{   
						patient_id_length = rset.getString("patient_id_length");
						ext_system_interface_yn = rset.getString("ext_system_interface_yn");
						nat_id_length = rset.getString("Nat_Id_Length");
						nat_id_prompt = rset.getString("Nat_Id_Prompt");
						accept_national_id_no_yn = rset.getString("accept_national_id_no_yn");	
						p_alt_id2_type = rset.getString("alt_id2_type");	
						p_alt_id3_type = rset.getString("alt_id3_type");	
						p_alt_id4_type = rset.getString("alt_id4_type");	
						entitlement_by_cat_yn = rset.getString("entitlement_by_pat_cat_yn");	
						biometric_authentication_yn=rset.getString("biometric_authentication_yn");	//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
						
					} 
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					if((patLength != null) && (patLength.length() > 0))
					 {
						patLength.delete(0,patLength.length());
					 }

				  stmt	= con.createStatement();	
				  rset	= stmt.executeQuery("Select count(*) v_cnt FROM AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+facilityId+"' and oper_stn_id ='"+oper_stn_id+"' and REGISTER_PAT_YN = 'Y' AND APPL_USER_ID = '"+user_id+"'") ;
                  rset.next();
				  v_cnt=rset.getInt(1);

				   if(v_cnt>0){
                     register_pat_yn	 = "Y";
				   }
				   //for smart card
			pstmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
			rset = pstmt.executeQuery();	 
			if(rset!=null && rset.next())
			{
			Smartcard_path=rset.getString("VALUE_1");
			function_name=rset.getString("VALUE_2");   // alkhaleej smart card
			}		
			if(pstmt!=null)
			pstmt.close();
			if(rset!=null)
			rset.close();
			//for smart card
				   

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block15Bytes, _wl_block15);

				boolean isSiteSpe_change_pat_dtls= CommonBean.isSiteSpecific(con, "OP","INVOKE_CHANGE_PATIENT_DETIALS"); 
				int userFunRightsCount	= 0;//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
				if(isSiteSpe_change_pat_dtls)
				{
					userFunRightsCount	= CommonBean.getUserFunRightsCount(con,user_id,"CHG_PAT_DTLS","MP");//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
					if(userFunRightsCount > 0) {
					
            _bw.write(_wl_block16Bytes, _wl_block16);
}
				}
            _bw.write(_wl_block17Bytes, _wl_block17);

				if (accept_national_id_no_yn.equals("Y"))
					{	
							if(ext_system_interface_yn.equals("Y"))
								{
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(function_name.equals("01")){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(function_name.equals("01")){
            _bw.write(_wl_block24Bytes, _wl_block24);
}
									else if(function_name.equals("05")){
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
									else if(function_name.equals("06")){
            _bw.write(_wl_block26Bytes, _wl_block26);
 }
									else if (function_name.equals("07")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}
									else {
            _bw.write(_wl_block28Bytes, _wl_block28);
 } 
            _bw.write(_wl_block29Bytes, _wl_block29);
if(function_name.equals("01")){
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);

					}
							else
								{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
					}
				else
					{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
									 
		   
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(params));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(register_pat_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reg_attendance_for_inpat_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ext_system_interface_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(entitlement_by_cat_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(p_alt_id2_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(p_alt_id3_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(p_alt_id4_type));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(isSiteSpe_change_pat_dtls));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(userFunRightsCount));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(max_hrs_for_re_attend));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nb_patient_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(invoke_from));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(isAERegisterTypeAutoUpdateAppl));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(dflt_emer_follow_type_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(dflt_time_reg_auto_update));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(biometric_authentication_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);







		
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(Smartcard_path));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block62Bytes, _wl_block62);

			if(bl_install_yn.equals("Y"))
			{
                session.removeAttribute("financial_details");
		    }
		
            _bw.write(_wl_block1Bytes, _wl_block1);

	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();

    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
	    ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block63Bytes, _wl_block63);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.detailsunknown.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
}
