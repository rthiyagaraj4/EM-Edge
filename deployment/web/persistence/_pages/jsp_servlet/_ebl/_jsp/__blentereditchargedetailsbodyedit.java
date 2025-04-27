package jsp_servlet._ebl._jsp;

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
import java.io.*;
import webbeans.op.CurrencyFormat;
import eOR.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __blentereditchargedetailsbodyedit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLEnterEditChargeDetailsBodyEdit.jsp", 1737915913320L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\t\t\n\t<!--<script Language=\"JavaScript\" src=\"../../eCommon/js/DateValidation.js\"></script>-->\n\t<!--<script Language=\"JavaScript\" src=\'../../eCA/js/ViewClinicalNote.js\'></script>-->\n\t<!--<script Language=\"JavaScript\" src=\'../../eCommon/js/dchk.js\'> </script>-->\n\t<!--<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>-->\n\t<!--<script language=\'javascript\' src=\'../../eCA/js/DateCheck.js\' ></script>-->\n\t<!--<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>-->\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<title>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</title>\n</head>\n<script>\nvar mass=\"\";\n\tfunction listitemvalidation()\n\t{\n\t\t//var inclexclind=document.forms[0].str_excl_incl_ind.value;\n\t\tvar inclexclind=document.forms[0].incl_excl.value;\t\n\t\tvar inclexclact=document.forms[0].incl_excl_action.value;\n\t\tif(inclexclind==\"\")\n\t\t{\n\t\t\tinclexclact=\"X\";\n\t\t}\n\t\tif(inclexclind!=\"\" && inclexclind==inclexclact)\n\t\t{\n\t    document.forms[0].incl_excl.value=\"\";\n\t\tdocument.forms[0].action_reason_desc.value=\"\";\n\t\tdocument.forms[0].action_reason_code.value=\"\";\t\n\t\t}\n\t}\n\tfunction callvalidations()\n\t{\n\t\t//alert(\"blng_serv_code \"+blng_serv_code);\n\t\tdocument.forms[0].serv_amt_changed.value=\"\";\n\t\tvar blng_serv_code=document.forms[0].blng_serv_code.value;\n\t\t//var blng_serv_code=document.forms[0].blng_serv_code.value;\n//alert (\"blng_serv_code in calvalidations()--------> \"+blng_serv_code)\t\t\n\t\tvar episode_type=document.forms[0].h_episode_type.value;\n\t\tvar patient_id=document.forms[0].h_patient_id.value;\n\t\tvar visit_id=document.forms[0].h_visit_id.value;\n\t\tvar episode_id=document.forms[0].h_episode_id.value;\n\t\tvar module_id=document.forms[0].h_module_id.value;\n\t\tvar action1=document.forms[0].action.value;\n\t\tvar rate=document.forms[0].rate.value;\n\t\tvar total_qty=document.forms[0].total_qty.value;\n\t\tvar incl_excl=document.forms[0].incl_excl.value;\n\t\tvar service_date=document.forms[0].service_date.value;\n\t\tvar incl_excl_action=document.forms[0].incl_excl_action.value;\n\t\tvar revise_qty=document.forms[0].revise_qty.value;\n\t\tvar rate_charge_ind=document.forms[0].charge.value;\t\n\t\t\n\t\tvar p_order_id=document.forms[0].p_order_id.value;\n\t\tvar p_order_line_no=document.forms[0].p_order_line_no.value;\n\t\tvar str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;\n\t\tstr_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);\n\n\t\tvar panel_qty=document.forms[0].panel_qty.value;\n\n\t\t/**Added by Ram ghl-1.2**/\n\t\tvar calledfrmencYN=document.forms[0].calledfrmencYN.value;\n\t\tvar bean_id_bl=document.forms[0].bean_id_bl.value;\n\t\t//alert(\"calledfrmencYN SERV\" +calledfrmencYN);\n\t\t//alert(\"bean_id_bl SERV\" +bean_id_bl);\n\t\t/**End **********************/\t\n\t\t\t\t\n\t\tvar ind=\"BLNG_SERV_CODE\";\n\t\t\n\t\tif(blng_serv_code!=\"\")\n\t\t{\n\t\t  \n\t//alert (\"calvalidations() @ rate_charge_ind ===> \"+rate_charge_ind)\n\n\tvar original_qty=  document.forms[0].original_qty.value;\n\t\t\t\tvar string=\"../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty=\"+original_qty+\"&blng_serv_code=\"+blng_serv_code+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&action1=\"+action1+\"&module_id=\"+module_id+\"&rate=\"+rate+\"&total_qty=\"+total_qty+\"&service_date=\"+service_date+\"&incl_excl_action=\"+incl_excl_action+\"&incl_excl=\"+incl_excl+\"&ind=\"+ind+\"&revise_qty=\"+revise_qty+\"&rate_charge_ind=\"+rate_charge_ind+\"&p_order_id=\"+p_order_id+\"&p_order_line_no=\"+p_order_line_no+\"&str_epi_type_clinic_code=\"+str_epi_type_clinic_code+\"&panel_qty=\"+panel_qty+\"&calledfrmencYN=\"+calledfrmencYN+\"&bean_id_bl=\"+bean_id_bl;\n\n\t\t\t\t\n\t\t\n\t\tparent.frames[1].location.href=string;\n\n\t\t}\n\t}\n\n\tfunction cancel()\n\t{\n\t\t//parent.window.close();\n\t\tparent.parent.document.getElementById(\'dialog_tag\').close();\n\t}\n\tfunction acceptchargedet()\n\t{\n\t\t//setTimeout(\'acceptchargedet1()\',500);\t\t\n\t\tif(document.forms[0].total_pay.value==\"\" && document.forms[0].patient_pay.value==\"\")\n\t\t{\n\t\t\tif(document.forms[0].rate_chk.value == \"Y\")\n\t\t\t{\t\t\n\t\t\t\tdocument.forms[0].rate_chk_close.value=\'Y\';\n\t\t\t\trateval(\"Y\");\n\t\t\t}\n\t\t\tif(document.forms[0].qty_chk.value == \"Y\")\n\t\t\t{\t\n\t\t\t\tdocument.forms[0].rate_chk_close.value=\'Y\';\t\t\t\t\n\t\t\t\trevqyt(\"Y\");\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tacceptchargedet1();\n\t\t}\n\t}\n\t\n\tasync function acceptchargedet1()\n\t{\n\t\tvar ser=document.forms[0].service.value;\n\t\tif(ser==\"\")\n\t\t{\n\t\t\talert(getMessage(\'BL9605\',\'BL\'));\n\t\t\tdocument.forms[0].service.focus();\n\t\t\treturn false;\n\t\t}\t\n\t\tvar rev_qty=document.forms[0].revise_qty.value;\n\t\tif(rev_qty==\"\" || rev_qty<=0)\n\t\t{\n\t\t\talert(getMessage(\'BL9606\',\'BL\'));\t\n\t\t\tdocument.forms[0].revise_qty.focus();\n\t\t\treturn false;\n\t\t}\n\t\tvar ratechr_ind=document.forms[0].charge.value;\n\t\tvar amt=document.forms[0].rate.value;\n\t\t\n\t\tif(document.forms[0].rate.value==\'0.00\')\n\t\t{\n\t\t\tif(!(confirm(getMessage(\'BL9861\',\'BL\'))))\n\t\t\t{\t\n\t\t\t\tif(ratechr_ind==\'C\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].rate.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tdocument.forms[0].revise_qty.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\t\t\t\t\n\t\t}\n\n\t\tif(amt==\"\")\n\t\t{\n\t\t\t\n\t\t\talert(getMessage(\'BL9862\',\'BL\'));\n\t\t\tdocument.forms[0].rate.focus();\n\t\t\treturn false;\n\t\t}\n\t/*\t\tif(ratechr_ind==\"C\" && amt==0)\n\t\t{\n\t\t\talert(getMessage(\'BL0628\',\'BL\'));\n\t\t}\t\n*/\n\t\tif(document.forms[0].incl_excl_action.value!=\"\" && document.forms[0].action_reason_desc.value ==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9608\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\n\t\tvar cbflag=eval(\"document.forms[0].preappr_reqd\");\n\t\t//alert(\"cbflag :\"+cbflag.checked);\n\t\tif(cbflag.checked)\n\t\t{\n\t\t\t cbflag=\"checked\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcbflag=\" \";\n\t\t}\t\t\n\t\tvar service=document.forms[0].service.value;\n\t\tif(service==\"\") service=\" \";\n\t\tvar blng_serv_code=document.forms[0].blng_serv_code.value;\n\t\tif(blng_serv_code==\"\") blng_serv_code=\" \";\n\t\tvar incl_excl=document.forms[0].incl_excl.value;\n\t\tif(incl_excl==\"\") incl_excl=\" \";\n\t\tvar incl_excl_action=document.forms[0].incl_excl_action.value;\n\t\tif(incl_excl_action==\"\") incl_excl_action=\"\";\n//\t\tif(incl_excl_action==\"I\") incl_excl_action=\"Include\";\n//\t\tif(incl_excl_action==\"E\") incl_excl_action=\"Exclude\";\n\t\tvar action_reason_desc=document.forms[0].action_reason_desc.value;\n\t\tif(action_reason_desc==\"\") action_reason_desc=\"\";\n\t\tvar action_reason_code=document.forms[0].action_reason_code.value;\n\t\tif(action_reason_code==\"\") action_reason_code=\"\";\n\t\tvar charge=document.forms[0].charge.value;\n\t\tif(charge==\"\") charge=\"\";\n\t\t\n\t\tvar original_qty=document.forms[0].original_qty.value;\n\t\tif(original_qty==\"\") original_qty=\"\";\n\t\tvar modify_qty_yn=document.forms[0].modify_qty_yn.value;\n\t\tif(modify_qty_yn==\"\") modify_qty_yn=\"\";\n\t\tvar uom=document.forms[0].uom.value;\n\t\tif(uom==\"\") uom=\"\";\n\t\tvar uom_code=document.forms[0].uom_code.value;\n\t\tif(uom_code==\"\") uom_code=\"\";\n\t\tvar revise_qty=document.forms[0].revise_qty.value;\n\t\tif(revise_qty==\"\") revise_qty=\"\";\n\t\tvar total_qty=document.forms[0].total_qty.value;\n\t\tif(total_qty==\"\") total_qty=\"\";\n\t\tvar rate=document.forms[0].rate.value;\n\t\t//alert(\"Rate acceptchargedet1 \"+rate);\n\t\tif(rate==\"\") rate=\"\";\n\t\tvar practioner_type=document.forms[0].practioner_type.value;\n\t\tif(practioner_type==\"\") practioner_type=\"\";\t\t\t\n\t\tvar pract_id=document.forms[0].pract_id.value;\n\t\tif(pract_id==\"\") pract_id=\" \";\t\n\t\tvar pract_staff_id=document.forms[0].pract_staff_id.value;\n\t\tif(pract_staff_id==\"\") pract_staff_id=\" \";\t\t\n\t\tvar practioner=document.forms[0].practioner.value;\n\t\tif(practioner==\"\") practioner=\"\";\n\t\tif(practioner_type!=\'\' && practioner==\'\')\n\t\t{\n\t\t\t//alert(\"practioner/staff cannot be epmty\");\n\t\t\talert(getMessage(\'BL9889\',\'BL\'));\n\t\t\treturn false;\n\n\t\t}\n\t\tvar total_pay=document.forms[0].total_pay.value;\n\t\tif(total_pay==\"\") total_pay=\"0.0\";\n\t\tvar patient_pay=document.forms[0].patient_pay.value;\n\t\tif(patient_pay==\"\") patient_pay=\"\";\n\t\tvar patient_paid=document.forms[0].patient_paid.value;\n\t\tif(patient_paid==\"\") patient_paid=\" \";\n\t\tvar ratecharge_desc=document.forms[0].ratecharge_desc.value;\n\t\tif(ratecharge_desc==\"\") ratecharge_desc=\" \";\t\n\t\tvar charged_yn=document.forms[0].charged_yn.value;\n\t\tif(charged_yn==\"\") charged_yn=\" \";\n\t\tvar override_yn=document.forms[0].override_yn.value;\n\t\tif(override_yn==\"\") override_yn=\" \";\n\n\t\t//var net_amount=document.forms[0].net_amount.value;\n\t\t//if(net_amount==\"\") net_amount=\" \";\n\n\t\tvar serv_amt_changed=document.forms[0].serv_amt_changed.value;\n\t\tif(serv_amt_changed==\"\") serv_amt_changed=\" \";\n\t\tvar excl_incl_ind_for_screen=document.forms[0].excl_incl_ind_for_screen.value;\t\n\n\t\tvar retVal= await encodeURIComponent(service)+\"::\"+blng_serv_code+\"::\"+incl_excl+\"::\"+incl_excl_action+\"::\"+encodeURIComponent(action_reason_desc)+\"::\"+action_reason_code+\"::\"+charge+\"::\"+original_qty+\"::\"+modify_qty_yn+\"::\"+encodeURIComponent(uom)+\"::\"+uom_code+\"::\"+revise_qty+\"::\"+total_qty+\"::\"+rate+\"::\"+practioner_type+\"::\"+pract_id+\"::\"+encodeURIComponent(practioner)+\"::\"+total_pay+\"::\"+patient_pay+\"::\"+patient_paid+\"::\"+cbflag+\"::\"+pract_staff_id+\"::\"+ratecharge_desc+\"::\"+charged_yn+\"::\"+override_yn+\"::\"+serv_amt_changed+\"::\"+excl_incl_ind_for_screen;\n\t\t//parent.window.returnValue = escape(retVal);\n\t\t//parent.window.close();\n\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t    dialogBody.contentWindow.returnValue = escape(retVal);\n\t    \n\t    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t    dialogTag.close();   \n\t}\nfunction disableAllElements_payer()\n{\n\tvar len = document.forms[0].elements.length;\n\tfor(var i=0;i<len;i++)\n\t{\n\t\tdocument.forms[0].elements(i).disabled=true;\n\t}\n\tdocument.forms[0].modify_button.disabled=false;\n\tdocument.forms[0].cancel_button.disabled=false;\n\n}\nfunction disableAllElements_payer_remove()\n{\n\tvar len = document.forms[0].elements.length;\n\tfor(var i=0;i<len;i++)\n\t{\n\t\tdocument.forms[0].elements(i).disabled=true;\n\t}\n\tdocument.forms[0].remove_button.disabled=false;\n\tdocument.forms[0].cancel_button.disabled=false;\n}\n\nfunction enableAllElements_service()\n{\n\t/*var len = document.forms[0].elements.length;\n\tfor(var i=0;i<len;i++)\n\t{document.forms[0].elements(i).disabled=false;\t}*/\n\t//document.forms[0].remove_button.disabled=true;\n\t//document.forms[0].modify_button.disabled=true;\n\tdocument.forms[0].preappr_reqd.disabled=true;\n\t//document.forms[0].practioner_type.disabled=true;\n\t//document.forms[0].practstaffbut.disabled=true;\t\t\n\tvar\tmodify_qty_yn=document.forms[0].modify_qty_yn.value;\n\tif(modify_qty_yn==\"N\")\n\t{\n\t\tdocument.forms[0].revise_qty.readOnly=true;\n\t\t$(\'#revise_qty\').removeAttr(\'onblur\');//Added V190909-Aravindh/TBMC-SCF-0086\n\t\t//document.forms[0].revise_qty.disabled=true;\n\t}\n\telse{\n\t\tif(modify_qty_yn==\"Y\")\n\t\t{\n\t\t\t document.forms[0].revise_qty.readOnly=false;\n\t//\t\tdocument.forms[0].revise_qty.disabled=false;\n\t\t}\n\t\t}\n\tvar charge=document.forms[0].charge.value;\n\tif(charge==\"R\")\n\t{\n\t}\n/*\tvar pract_type_temp=document.forms[0].practioner_type.value;\n\tif(pract_type_temp==\"\")\n\t\t{document.forms[0].practstaffbut.disabled=true;\n\t\t}else{document.forms[0].practstaffbut.disabled=false;}*/\n\t\tvar service_panel_ind1=document.forms[0].service_panel_ind1.value;\n\t\tif(service_panel_ind1==\"S\")\n\t\t{\n\t\t\tdocument.forms[0].revise_qty.readOnly=true;\n\t\t\t$(\'#revise_qty\').removeAttr(\'onblur\');//Added V190909-Aravindh/TBMC-SCF-0086\n\t\t}\n\t\t//var v_override_yn=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tvar override_allowed_yn\t=document.forms[0].override_yn.value;//\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11_0 ="\";\n\t\tvar dirIndirChrgsFlag=document.forms[0].dirIndirChrgsFlag.value;\n\t\t//alert(\"override_allowed_yn\" +override_allowed_yn);\n\t\tif(override_allowed_yn==\"\" || override_allowed_yn==\"N\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].incl_excl_action.disabled=true;\n\t\t\t\tdocument.forms[0].action_reason_desc.disabled=true;\n\t\t\t}\n\t\telse if(dirIndirChrgsFlag==\'Y\'){\n\t\t\t//alert(\"dirIndirChrgsFlag \"+dirIndirChrgsFlag);\n\t\t\t\tdocument.forms[0].incl_excl_action.disabled=true;\n\t\t\t\tdocument.forms[0].action_reason_desc.disabled=true;\n\t\t\t}\n\t\t\telse{\n\t\t\t\tdocument.forms[0].incl_excl_action.disabled=false;\n\t\t\t\tdocument.forms[0].action_reason_desc.disabled=false;\n\t\t\t\t}\n\n\t\tmodify_validations()\n\t\t}\n\n/*function enableAllElements_service_remove()\n{\n\t//document.forms[0].remove_button.disabled=false;\n\tdocument.forms[0].cancel_button.disabled=false;\n}*/\nfunction remove_payer()\n{\n\tparent.window.returnValue = \"remove\";\n\tparent.window.close();\t\n}\n\nfunction PractStaffInd()\n{\n document.forms[0].pract_id.value=\"\";\n  document.forms[0].practioner.value=\"\";\n}\n\nasync function servicelkup()\n{     \n//alert (\"---------------------------------\"+document.forms[0].blng_serv_code.value)\n\t\t\t//alert(\"------------------------------------\"+retArray[0]);\n\t\t\tdocument.forms[0].incl_excl.value=\"\";\n\t\t\t//document.forms[0].service.value=\"\";\t\t\t\n\t\t\tdocument.forms[0].ratecharge_desc.value=\"\";\n\t\t\tdocument.forms[0].charge.value=\"\";\n\t\t\tdocument.forms[0].uom.value=\"\";\n\t\t\tdocument.forms[0].uom_code.value=\"\";\n\t\t\tdocument.forms[0].rate.value=\"\";\t\n\t\t\tdocument.forms[0].revise_qty.value=\'\';\n\t\t\tdocument.forms[0].original_qty.value=\'\';\n\t\t\tdocument.forms[0].total_qty.value=\'\';\n\t\t\tdocument.forms[0].total_pay.value=\'\';\n\t\t\tdocument.forms[0].patient_pay.value=\'\';\n\t\t\tdocument.forms[0].patient_paid.value=\'\';\n\t\t\tdocument.forms[0].action_reason_desc.value=\'\';\n\t\t\tdocument.forms[0].incl_excl_action.value=\'\';\n\t\t\tdocument.forms[0].incl_excl_action.disabled=false;\n\t\t\tdocument.forms[0].action_reason_desc.disabled=false;\n\t\t\tvar dirIndirChrgsFlag=document.forms[0].dirIndirChrgsFlag.value;\n\t\t\tif(dirIndirChrgsFlag==\'Y\'){\t\t\t\t\n\t\t\t\t\tdocument.forms[0].incl_excl_action.disabled=true;\n\t\t\t\t\tdocument.forms[0].action_reason_desc.disabled=true;\n\t\t\t\t}\n\t\t\t\n\t\t\tdocument.forms[0].action_reason_code.value=\'\';\n\t\tvar target\t\t\t= document.forms[0].service;\t\t\n\t\tvar retVal\t\t\t=  new String();\n\t\tvar dialogTop\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar title\t\t\t= getLabel(\"Common.service.label\",\'COMMON\');\n\t\tvar locale  = document.forms[0].locale.value;\t\t\n\t\tvar sql1=\"select blng_serv_code code,long_desc description from bl_blng_serv_lang_vw where language_id = \'\"+locale+\"\' AND nvl(status,\'x\') != \'S\'  and upper(blng_serv_code) like upper(?) and upper(long_desc) like upper(?)\"; \n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql1;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\n\t\targArray[5] = target.value;\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = DESC_CODE;\t\t\t\t\n\t\tretArray = await CommonLookup( title, argArray );\t\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\n\t\t\tdocument.forms[0].blng_serv_code.value=arr[0];\n\t\t\t//muthu\n\t\t\t//alert(\"--------blng_serv_code-----\"+document.forms[0].blng_serv_code.value)\n\t\t\t//alert(\"--------retArray-----\"+retArray[0]);\n\t\t\t//muthu\n\t\t\t//target.value=retArray[0];\n\t\t\tdocument.forms[0].service.value=arr[1];\t\t\t\n\t\t\t/*if(document.forms[0].service.value==\"\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].service.focus();\n\t\t\t}*/\n\t\t\t\n\t\t\tcallvalidations();\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\n\t\t\tdocument.forms[0].incl_excl.value=\"\";\n\t\t\t//document.forms[0].max_chg_amt=\"\"; //muthu 27-2-12\n\t\t\tdocument.forms[0].service.value=\"\";\t\t\t\n\t\t\tdocument.forms[0].blng_serv_code.value=\"\";\t\t\t\n\t\t\tdocument.forms[0].ratecharge_desc.value=\"\";\n\t\t\tdocument.forms[0].charge.value=\"\";\n\t\t\tdocument.forms[0].uom.value=\"\";\n\t\t\tdocument.forms[0].uom_code.value=\"\";\n\t\t\tdocument.forms[0].rate.value=\"\";\t\n\t\t\tdocument.forms[0].revise_qty.value=\'\';\n\t\t\tdocument.forms[0].original_qty.value=\'\';\n\t\t\tdocument.forms[0].total_qty.value=\'\';\n\t\t\tdocument.forms[0].total_pay.value=\'\';\n\t\t\tdocument.forms[0].patient_pay.value=\'\';\n\t\t\tdocument.forms[0].patient_paid.value=\'\';\n\t\t\tdocument.forms[0].incl_excl_action.value=\'\';\n\t\t\tdocument.forms[0].incl_excl_action.disabled=false;\t\t\t\n\t\t\tdocument.forms[0].action_reason_desc.disabled=true;\n\t\t\tvar dirIndirChrgsFlag=document.forms[0].dirIndirChrgsFlag.value;\n\t\t\tif(dirIndirChrgsFlag==\'Y\'){\n\t\t\t\t//alert(\"dirIndirChrgsFlag \"+dirIndirChrgsFlag);\n\t\t\t\t\tdocument.forms[0].incl_excl_action.disabled=true;\n\t\t\t\t\tdocument.forms[0].action_reason_desc.disabled=true;\n\t\t\t\t}\n\t\t\tdocument.forms[0].action_reason_desc.value=\'\';\n\t\t\tdocument.forms[0].action_reason_code.value=\'\';\n\t\t\t//target.focus();\n\t\t\t//document.forms[0].incl_excl_action.focus();\n\t\t}\n//document.ss..location.href=\'../../eBL/jsp/BLEnterEditChargeDetailsBodyEdit.jsp\';\n\t\t\n\t\t}\n\nasync function reasonlkup()\n{\n\n\tif((document.forms[0].blng_serv_code.value == \"\" && document.forms[0].service.value == \"\") && document.forms[0].incl_excl_action.value != \"\")\n\t{\n\t\treturn false;\n\t}\n\telse if((document.forms[0].blng_serv_code.value == \"\" && document.forms[0].service.value == \"\") && document.forms[0].incl_excl_action.value == \"\")\n\t{\n\t\treturn false;\n\t}\n\t\t//var note_group      =document.forms[0].note_group.value;\n\t\tvar action_reason_desc=document.forms[0].action_reason_desc.value;\n\t\t//if(action_reason_desc==\"\")\n\t\t//{\n   \t\tvar target\t\t\t= document.forms[0].action_reason_desc;\n\t\tvar inc_exc\t\t\t= document.forms[0].incl_excl_action.value;\n\t\tif(inc_exc==\"\") return;\n\t\tvar retVal\t\t\t=  new String();\n\t\tvar dialogTop\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t= \"40\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar search_desc\t\t\t= \"\";\n\t\tvar title =getLabel(\"eBL.INCLUDED_EXCLUDED_ACTION.label\",\"BL\");\t\t\n\t\t//var title = encodeURIComponent(title);\t\t\n\t\tvar locale  = document.forms[0].locale.value;\t\t\t\n\t\tvar sql2=\"select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a where nvl(status,\'!\') != \'S\'and upper(language_id) = upper(\'\"+locale+\"\')and exists (select b.action_type from bl_action_type b, bl_action_reason_by_type c where b.action_type = c.action_type and b.action_type = \'OV\' and c.action_reason_code = a.action_reason_code and c.active_yn = \'Y\') and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1\";\n\n\t\tvar argArray = new Array();\n\t\tvar namesArray = new Array();\n\t\tvar valuesArray = new Array();\n\t\tvar datatypesArray = new Array();\n\t\targArray[0] = sql2;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"1,2\";\n\t\targArray[5] = target.value;\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = DESC_CODE;\t\t\n\t\tretArray = await CommonLookup( title, argArray );\t\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\t\t\n\t\t\tdocument.forms[0].action_reason_code.value=arr[0];\n\t\t\tdocument.forms[0].action_reason_desc.value=arr[1];\t\t\t\n\t\t\treasonvalidations();\n\t\t\t//document.forms[0].reason.focus();\n\t\t\t//document.forms[0].incl_excl_action.focus();\t\t\t\n\t\t}\n\t\telse\n\t\t{\t\t\t\n\t\t\tdocument.forms[0].action_reason_desc.value=\"\";\n\t\t\tdocument.forms[0].action_reason_code.value=\"\";\n\t\t\t//target.focus();\n\t\t\t//document.forms[0].incl_excl_action.focus();\n\t\t}\n\t\t//}\n\t\tvar action_reason_desc_temp=document.forms[0].action_reason_desc.value;\n\t\tvar incl_excl_action_temp=document.forms[0].incl_excl_action.value;\n\t\tif(incl_excl_action_temp!=\"\" && action_reason_desc_temp==\"\")\n\t\t{\n\t\t\t//document.forms[0].action_reason_desc.focus();\t\t\t\n\t\t\talert(getMessage(\"BL9608\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t}\t\n\n\nfunction reasonvalidations()\n{\n\t//alert(\"reasonvalidations \")\n  var action1=document.forms[0].action.value;\n  var incl_excl_action=document.forms[0].incl_excl_action.value;\n  var episode_type=document.forms[0].h_episode_type.value;\n  var patient_id=document.forms[0].h_patient_id.value;\n  var visit_id=document.forms[0].h_visit_id.value;\n  var episode_id=document.forms[0].h_episode_id.value;\n  var added_serv_yn=document.forms[0].added_serv_yn.value;\n  var p_order_id=document.forms[0].p_order_id.value;\n  var p_order_line_no=document.forms[0].p_order_line_no.value;\n  var str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;\n\t\n\tvar panel_qty=document.forms[0].panel_qty.value;\n\t/**Added by Ram ghl-1.2**/\n\t\tvar calledfrmencYN=document.forms[0].calledfrmencYN.value;\n\t\tvar bean_id_bl=document.forms[0].bean_id_bl.value;\n\t\t//alert(\"calledfrmencYN edit\" +calledfrmencYN);\n\t\t//alert(\"bean_id_bl edit\" +bean_id_bl);\n\t/**End **********************/\t\n\n\t\n  var ind=\"REASON_CODE\";\n  var action_reason_code=document.forms[0].action_reason_code.value; \n  var original_qty=  document.forms[0].original_qty.value;\n//alert(\'833\');\nparent.frames[1].location.href=\"../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty=\"+original_qty+\"&action1=\"+action1+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&action_reason_code=\"+action_reason_code+\"&ind=\"+ind+\"&added_serv_yn=\"+added_serv_yn+\"&incl_excl_action=\"+incl_excl_action+\"&p_order_id=\"+p_order_id+\"&p_order_line_no=\"+p_order_line_no+\"&str_epi_type_clinic_code=\"+str_epi_type_clinic_code+\"&panel_qty=\"+panel_qty+\"&calledfrmencYN=\"+calledfrmencYN+\"&bean_id_bl=\"+bean_id_bl;\n}\n\nasync function funQry(clng_evnt)\n{\n\n\n\tif(clng_evnt == \'B\')\n\t{\n\t\tif( document.forms[0].practioner.value == \"\")\n\t\t{\n\t\t\tdocument.forms[0].practioner.value = \"\";\n\t\t\tdocument.forms[0].pract_staff_id.value = \"\";\n\t\t\treturn;\n\t\t}\n\t}\n\t\tvar pract_name=\"\";\n\t\tvar pract_staff_id=\"\";\t\t\t\t\n\t\tvar retVal\t\t\t= new String();\t\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"90vh\" ;\n\t\tvar dialogWidth\t\t\t= \"80vw\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar sql\t\t\t\t\t= \"\";\n\t\tvar sql3\t\t\t\t= \"\";\t\t\n\t\tvar locale = document.forms[0].locale.value;\n\t\tvar facility_id = document.forms[0].facility_id.value;\n\t\tvar pract_id=document.forms[0].pract_id.value;\n\n\t\tvar title=encodeURIComponent(getLabel(\"eBL.PRACT_STAFF_TYPE.label\",\"BL\"));\n\t\tvar column_sizes = escape(\"15%,10%,10%,10%\");\n\t\tif(pract_id==\"P\")\n\t\t{\n\t\t\tvar staff_name=encodeURIComponent(getLabel(\"Common.practitionername.label\",\"common\"));\n\t\t\tvar staff_id=encodeURICom";
    private final static byte[]  _wl_block11_0Bytes = _getBytes( _wl_block11_0 );

    private final static java.lang.String  _wl_block11_1 ="ponent(getLabel(\"Common.identification.label\",\"common\"));\n\t\t\tvar short_desc=encodeURIComponent(getLabel(\"Common.shortdescription.label\",\"common\"));\n\t\t\tvar staff_type=encodeURIComponent(getLabel(\"Common.practitionertype.label\",\"common\"));\n\t\t}else if(pract_id==\"O\"){\n\t\t\t\tvar staff_name=encodeURIComponent(getLabel(\"Common.OtherStaffName.label\",\"common\"));\n\t\t\t\tvar staff_id=encodeURIComponent(getLabel(\"Common.identification.label\",\"common\"));\n\t\t\t\tvar short_desc=encodeURIComponent(getLabel(\"Common.shortdescription.label\",\"common\"));\n\t\t\t\tvar staff_type=encodeURIComponent(getLabel(\"Common.OtherStaffType.label\",\"common\"));\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t//alert(\"857\");//lakshmi\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t\t}\n\t\tvar column_descriptions =staff_name+\",\"+staff_id+\",\"+short_desc+\",\"+staff_type; \n\n\t\t\n\n\t\tvar message = \'\';\n\t//Below Query is Modified By muthuN on 27-8-12 against 28655\n\tsql3=\"select a.name NAME,a.PRACTITIONER_ID ID,a.st_type_desc ST_TYPE_DESC,a.st_type STAFF_TYPE from BL_AM_PRACT_STAFF_VW a where PRACT_STAFF_IND=\'\"+pract_id+\"\' AND LANGUAGE_ID=\'\"+locale+\"\' AND facility_id=\'\"+facility_id+\"\'  \";\n\n\t//sql3=\"select name NAME,PRACTITIONER_ID ID,st_type_desc ST_TYPE_DESC,st_type ST_TYPE from BL_AM_PRACT_STAFF_VW where PRACT_STAFF_IND=\'\"+pract_id+\"\' AND LANGUAGE_ID=\'\"+locale+\"\' AND facility_id=\'\"+facility_id+\"\'\";\n/*\tsql3 =\"SELECT A.PRACTITIONER_NAME NAME,  A.PRACTITIONER_ID ID,  B.DESC_USERDEF ST_TYPE_DESC, \"+\n\t\"A.PRACT_TYPE ST_TYPE FROM AM_PRACTITIONER_LANG_VW A, AM_PRACT_TYPE_LANG_VW B \"+\n\t\"WHERE EXISTS (SELECT PRACTITIONER_ID FROM AM_PRACT_FOR_FACILITY C  \"+\n\t\"WHERE facility_id = \'HS\' AND C.PRACTITIONER_ID = A.PRACTITIONER_ID AND NVL(C.EFF_STATUS,\'!\') != \'S\') \"+\n\t\"AND UPPER(A.LANGUAGE_ID) = UPPER(\'en\') AND A.PRACT_TYPE = B.PRACT_TYPE \"+\n\t\"AND A.LANGUAGE_ID = B.LANGUAGE_ID AND NVL(A.EFF_STATUS,\'!\') != \'S\' \";/*UNION ALL\t\t\"+\t\t\n\t\"SELECT A.OTHER_STAFF_NAME NAME, A.OTHER_STAFF_ID ID, B.SHORT_DESC ST_TYPE_DESC, A.OTHER_STAFF_TYPE ST_TYPE \"+\n\t\"FROM AM_OTHER_STAFF_LANG_VW A,AM_OTHER_STAFF_TYPE_LANG_VW B  \"+\t\t\n    \"WHERE EXISTS (SELECT OTHER_STAFF_ID FROM AM_OTHER_STAFF_FOR_FACILITY C \"+\n    \"WHERE facility_id = \'HS\' AND C.OTHER_STAFF_ID = A.OTHER_STAFF_ID AND NVL(C.EFF_STATUS,\'!\') != \'S\') \"+\n    \"AND UPPER(A.LANGUAGE_ID) = UPPER(\'en\') AND A.OTHER_STAFF_TYPE = B.OTHER_STAFF_TYPE \"+\n    \"AND A.LANGUAGE_ID = B.LANGUAGE_ID AND NVL(A.EFF_STATUS,\'!\') != \'S\' \";\t*/\t\n\t sql = escape(sql3);\t\n\t var param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(document.forms[0].practioner.value)+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYYY\";\n\t retVal=await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\t\t \n\t var arr=new Array();\n\t if(retVal == null) retVal=\'\';\n\t if (retVal != null || retVal!=\"\")\n\t{\n\t\t if(retVal!=\'undefined\' && retVal!=undefined)\n\t\t{\n\t\t var retVal=unescape(retVal);\t\t \n\t\t if(retVal != null && retVal.length>0)\n\t\t  {\n\t\t\t    //arr=retVal.split(\"::\");\t\n\t\t\t\tarr=retVal.split(\"^~^\");\t\n\t\t\t\tpract_name=arr[0];\t\t\t\t\n\t\t\t\tpract_staff_id=arr[1];\t\t\t\t\n\t\t  \n\t\t  document.forms[0].practioner.value=pract_name;\t\n\t\tdocument.forms[0].pract_staff_id.value=pract_staff_id;\n//\t\tdocument.forms[0].practioner.focus();\n\t\t  }\n\t\t}\n\t}\n\t\t//document.forms[0].practioner.value=pract_name;\t\n\t\t//document.forms[0].pract_staff_id.value=pract_staff_id;\n\t\t//document.forms[0].practioner.focus();\n\t}\n\t\nfunction practstaffvalidations()\n{\t\n  var action1=document.forms[0].action.value;\n  var practioner=document.forms[0].practioner.value;\n  var episode_type=document.forms[0].h_episode_type.value;\n  var patient_id=document.forms[0].h_patient_id.value;\n  var visit_id=document.forms[0].h_visit_id.value;\n  var episode_id=document.forms[0].h_episode_id.value;\n  var pract_id=document.forms[0].pract_id.value;\n  var pract_id=document.forms[0].pract_id.value; \n  var p_order_id=document.forms[0].p_order_id.value;\n  var p_order_line_no=document.forms[0].p_order_line_no.value;\n  var ind=\"PRACT_STAFF\";\n  var original_qty=  document.forms[0].original_qty.value;\n\tparent.frames[1].location.href=\"../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty=\"+original_qty+\"&action1=\"+action1+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&practioner=\"+practioner+\"&ind=\"+ind+\"&p_order_id=\"+p_order_id+\"&p_order_line_no=\"+p_order_line_no;\n}\n\nfunction revqyt(qty_chk)\n{\n\tvar action1=document.forms[0].action.value;\n\tvar blng_serv_code=document.forms[0].blng_serv_code.value;\t\n\tvar episode_type=document.forms[0].h_episode_type.value;\t\n\tvar patient_id=document.forms[0].h_patient_id.value;\t\n\tvar visit_id=document.forms[0].h_visit_id.value;\t\n\tvar episode_id=document.forms[0].h_episode_id.value;\t\n\tvar module_id=document.forms[0].h_module_id.value;\n\tvar rate=document.forms[0].rate.value;\n\tvar total_qty=document.forms[0].total_qty.value;\n\tvar revise_qty=document.forms[0].revise_qty.value;\t\n\tvar service_date=document.forms[0].service_date.value;\n\tvar incl_excl_action=document.forms[0].incl_excl_action.value;\t\n\tvar rate_charge_ind=document.forms[0].charge.value;\t\n\tvar p_order_id=document.forms[0].p_order_id.value;\n\tvar p_order_line_no=document.forms[0].p_order_line_no.value;\n\tvar encounter_id=\'\';//document.forms[0].encounter_id.value;\n\tvar panel_qty=document.forms[0].panel_qty.value;\n\t\n\tvar str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;\n\tstr_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);\n\n\t/**Added by Ram ghl-1.2**/\n\t\tvar calledfrmencYN=document.forms[0].calledfrmencYN.value;\n\t\tvar bean_id_bl=document.forms[0].bean_id_bl.value;\n\t\t//alert(\"calledfrmencYN edit\" +calledfrmencYN);\n\t\t//alert(\"bean_id_bl edit\" +bean_id_bl);\n\t/**End **********************/\t\n\n    var ind=\"REVISED_QTY\";\n\tif(revise_qty!=\"\")\n\t{\n\t\tvar original_qty=  document.forms[0].original_qty.value;\n\t\tparent.frames[1].location.href=\"../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty=\"+original_qty+\"&action1=\"+action1+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&revise_qty=\"+revise_qty+\"&rate_charge_ind=\"+rate_charge_ind+\"&ind=\"+ind+\"&rate=\"+rate+\"&blng_serv_code=\"+blng_serv_code+\"&module_id=\"+module_id+\"&service_date=\"+service_date+\"&incl_excl_action=\"+incl_excl_action+\"&total_qty=\"+total_qty+\"&p_order_id=\"+p_order_id+\"&p_order_line_no=\"+p_order_line_no+\"&str_epi_type_clinic_code=\"+str_epi_type_clinic_code+\"&qty_chk=\"+qty_chk+\"&encounter_id=\"+encounter_id+\"&panel_qty=\"+panel_qty+\"&calledfrmencYN=\"+calledfrmencYN+\"&bean_id_bl=\"+bean_id_bl;\n\t}\n}\nfunction rateval(rate_chk,obj)\n{ \n//alert(\"max_chg_amt in rateval() ============> \"+obj)\n//alert(\"rate_chk rateval() ==========> \"+rate_chk)\n\t//changeAmt(rate_chk);\n\t//var mass=\"\";\n\tif(obj!=\"\")\n\t{\n\tmass=obj;\n\tdocument.forms[0].max_chg_amt1.value=obj;\n\t\n\t//alert (\"document.cookie---------\"+document.cookie);\n\t //mass=document.forms[0].max_chg_amt.value;\n\t }\n\t //alert (\"document.cookie---------\"+document.cookie);\n\t //alert(\"mass rateval()===========> \"+mass);\n    var max_chg_amt = document.forms[0].max_chg_amt.value;\n\t//alert(\"in rateval() max max_chg_amt line 1036----> \"+max_chg_amt);\n\tvar action1=document.forms[0].action.value;\t\t\n\tvar serv_amt_changed = document.forms[0].serv_amt_changed.value;\t\n//\talert(\"serv_amt_changed rateval()====> \"+serv_amt_changed);\n\tvar blng_serv_code=document.forms[0].blng_serv_code.value;\n\t//alert(\"blng_serv_code in rateval()--> \"+blng_serv_code);\n\tvar episode_type=document.forms[0].h_episode_type.value;\t\n\tvar patient_id=document.forms[0].h_patient_id.value;\n\tvar visit_id=document.forms[0].h_visit_id.value;\n\tvar episode_id=document.forms[0].h_episode_id.value;\n\tvar module_id=document.forms[0].h_module_id.value;\t\n\t\n\tvar rate=document.forms[0].rate.value;\n\t//alert(\"rate in rateval() ====> \"+rate);\n\t//document.forms[0].actual_amt_val.value=rate;\n\tvar total_qty=document.forms[0].total_qty.value;\n\tvar incl_excl=document.forms[0].incl_excl.value;\n\tvar service_date=document.forms[0].service_date.value;\n\tvar incl_excl_action=document.forms[0].incl_excl_action.value;\t\t\n\tvar rate_charge_ind=document.forms[0].charge.value;\n\t//alert(\"rate_charge_ind in rateval()===> \"+rate_charge_ind);\n\tvar min_chg_amt=document.forms[0].min_chg_amt.value;\n\t//alert(\"min_chg_amt \"+min_chg_amt);\n\tvar modify_qty_yn=document.forms[0].modify_qty_yn.value;\n\tvar revise_qty=document.forms[0].revise_qty.value;\n\tvar p_order_id=document.forms[0].p_order_id.value;\n\tvar p_order_line_no=document.forms[0].p_order_line_no.value;\n\tvar str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;\n\tstr_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);\n//\tvar actual_amt=document.forms[0].actual_amt_val.value;\n\t\n\tvar panel_qty=document.forms[0].panel_qty.value;\n\n\t/**Added by Ram ghl-1.2**/\n\t\tvar calledfrmencYN=document.forms[0].calledfrmencYN.value;\n\t\tvar bean_id_bl=document.forms[0].bean_id_bl.value;\n\t\t//alert(\"calledfrmencYN edit\" +calledfrmencYN);\n\t\t//alert(\"bean_id_bl edit\" +bean_id_bl);\n\t/**End **********************/\t\n\n//Modified By muthukumar on 31-1-12 against SKR-SCF-0320\t \n//if(max_chg_amt == \"0.0\" ){\n//alert(\"rate in rateval() ==> \"+rate+\"max_chg_amt in rateval()==> \"+max_chg_amt);\nif(parseFloat(rate) <= parseFloat(max_chg_amt) || max_chg_amt==0 || rate == \"\"){\n\t//alert(\"*** Entering into If condition in rateval() ***\")\n//Modified By muthukumar on 31-1-12 against SKR-SCF-0320\n\tvar ind=\"RATE\";\n\t if(rate!=\"\"){\t\n//muthu\t \n//alert(\"in rateval() inside if condition blng_serv_code ----> \"+blng_serv_code);\n//alert(\"in rateval() inside if condition max max_chg_amt ----> \"+max_chg_amt);\n\n//muthu\n  \n \n var original_qty=  document.forms[0].original_qty.value;\nparent.frames[1].location.href=\"../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty=\"+original_qty+\"&blng_serv_code=\"+blng_serv_code+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&action1=\"+action1+\"&module_id=\"+module_id+\"&rate=\"+rate+\"&total_qty=\"+total_qty+\"&service_date=\"+service_date+\"&incl_excl_action=\"+incl_excl_action+\"&incl_excl=\"+incl_excl+\"&modify_qty_yn=\"+modify_qty_yn+\"&rate_charge_ind=\"+rate_charge_ind+\"&min_chg_amt=\"+min_chg_amt+\"&ind=\"+ind+\"&revise_qty=\"+revise_qty+\"&p_order_id=\"+p_order_id+\"&p_order_line_no=\"+p_order_line_no+\"&str_epi_type_clinic_code=\"+str_epi_type_clinic_code+\"&rate_chk=\"+rate_chk+\"&panel_qty=\"+panel_qty+\"&serv_amt_changed=\"+serv_amt_changed+\"&calledfrmencYN=\"+calledfrmencYN+\"&bean_id_bl=\"+bean_id_bl;\t\n\t}\n\t\n\t}\n\telse \n\t{\t\n\t\talert(getMessage(\"BL9124\",\'BL\'));\n\t\tdocument.forms[0].rate.value=\'\';\n\t}\n/*\n}else{\n\tif(rate!=\"\"){\t\t\t parent.frames";
    private final static byte[]  _wl_block11_1Bytes = _getBytes( _wl_block11_1 );

    private final static java.lang.String  _wl_block11_2 ="[1].location.href=\'../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?blng_serv_code=\'+blng_serv_code+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&action1=\"+action1+\"&module_id=\"+module_id+\"&rate=\"+rate+\"&total_qty=\"+total_qty+\"&service_date=\"+service_date+\"&incl_excl_action=\"+incl_excl_action+\"&incl_excl=\"+incl_excl+\"&modify_qty_yn=\"+modify_qty_yn+\"&rate_charge_ind=\"+rate_charge_ind+\"&min_chg_amt=\"+min_chg_amt+\"&ind=\"+ind+\"&revise_qty=\"+revise_qty+\"&p_order_id=\"+p_order_id+\"&p_order_line_no=\"+p_order_line_no+\"&str_epi_type_clinic_code=\"+str_epi_type_clinic_code+\"&rate_chk=\"+rate_chk+\"&panel_qty=\"+panel_qty+\"&serv_amt_changed=\"+serv_amt_changed+\"&calledfrmencYN=\"+calledfrmencYN+\"&bean_id_bl=\"+bean_id_bl;\t\n\t}\n}*/\n//Modified By muthukumar on 31-1-12 against SKR-SCF-0320\n}\nfunction valexclincl()\n{\n\tvar blng_serv_code=document.forms[0].blng_serv_code.value;\t\n\tvar episode_type=document.forms[0].h_episode_type.value;\n\tvar patient_id=document.forms[0].h_patient_id.value;\n\tvar visit_id=document.forms[0].h_visit_id.value;\n\tvar episode_id=document.forms[0].h_episode_id.value;\n\tvar module_id=document.forms[0].h_module_id.value;\n\tvar action1=document.forms[0].action.value;\n\tvar rate=document.forms[0].rate.value;\n\tvar total_qty=document.forms[0].total_qty.value;\n\tvar incl_excl=document.forms[0].incl_excl.value;\n\n\n\t\n\tvar service_date=document.forms[0].service_date.value;\n\tvar incl_excl_action=document.forms[0].incl_excl_action.value;\n\n\t\n\tvar rate_charge_ind=document.forms[0].charge.value;\n\tvar min_chg_amt=document.forms[0].min_chg_amt.value;\n\tvar revise_qty=document.forms[0].revise_qty.value;\n\tvar str_encounter_id=document.forms[0].encounter_id.value;\n\tvar str_acc_seq_no=document.forms[0].acc_seq_no.value;\n\tvar p_order_id=document.forms[0].p_order_id.value;\n\tvar p_order_line_no=document.forms[0].p_order_line_no.value;\n\tvar str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;\n\tstr_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);\n\n\tvar panel_qty=document.forms[0].panel_qty.value;\n\t\nvar serv_amt_changed = document.forms[0].serv_amt_changed.value;\n/**Added by Ram ghl-1.2**/\n\t\tvar calledfrmencYN=document.forms[0].calledfrmencYN.value;\n\t\tvar bean_id_bl=document.forms[0].bean_id_bl.value;\n\t\t//alert(\"calledfrmencYN edit\" +calledfrmencYN);\n\t\t//alert(\"bean_id_bl edit\" +bean_id_bl);\n\t/**End **********************/\t\n\n\n\tvar ind=\"EXCL_INCL_ACT\";\n\tvar original_qty=  document.forms[0].original_qty.value;\n\tparent.frames[1].location.href=\"../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty=\"+original_qty+\"&blng_serv_code=\"+blng_serv_code+\"&episode_type=\"+episode_type+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&action1=\"+action1+\"&module_id=\"+module_id+\"&rate=\"+rate+\"&total_qty=\"+total_qty+\"&service_date=\"+service_date+\"&incl_excl_action=\"+incl_excl_action+\"&incl_excl=\"+incl_excl+\"&rate_charge_ind=\"+rate_charge_ind+\"&min_chg_amt=\"+min_chg_amt+\"&ind=\"+ind+\"&revise_qty=\"+revise_qty+\"&encounter_id=\"+str_encounter_id+\"&acc_seq_no=\"+str_acc_seq_no+\"&p_order_id=\"+p_order_id+\"&p_order_line_no=\"+p_order_line_no+\"&str_epi_type_clinic_code=\"+str_epi_type_clinic_code+\"&panel_qty=\"+panel_qty+\"&serv_amt_changed=\"+serv_amt_changed+\"&calledfrmencYN=\"+calledfrmencYN+\"&bean_id_bl=\"+bean_id_bl;\t\n}\n\nfunction modify_validations()\n{\n\tdocument.forms[0].service.disabled=true;\t\n\tdocument.forms[0].servicebut.disabled=true;\t\t\n\tvar ratecha=document.forms[0].charge.value;\n\tif(ratecha==\"C\")\n\t{\n\t\tdocument.forms[0].revise_qty.disabled=true;\n\t}\n\n\tif(ratecha==\"R\")\n\t{\n\t\tdocument.forms[0].rate.disabled=true;\n\t}\n\n\t//parent.frames[1].location.href=\'../../eBL/jsp/BLEnterEditChargeDetialsHdr.jsp?action1=\'+action1;\n\tvar chk_inc_excl=document.forms[0].incl_excl.value;\n\tif(chk_inc_excl==\"Excluded\")\n\t{\n\t\tdocument.forms[0].incl_excl_action.value=\"I\";\n\t}\n\telse if(chk_inc_excl==\"Included\"){\n\t\tdocument.forms[0].incl_excl_action.value=\"E\";\t\n\t\t\t\t\t\t\t\t\t}\n// Added for OH-CRF-1233 on 08/29/2009\n";
    private final static byte[]  _wl_block11_2Bytes = _getBytes( _wl_block11_2 );

    private final static java.lang.String  _wl_block12 ="\n\tif(document.forms[0].preappr_reqd.checked)\n\t{\n\t\tdocument.forms[0].incl_excl_action.disabled = true;\n\t\tdocument.forms[0].action_reason_desc.disabled = true;\n\t\tdocument.forms[0].reasonbut.disabled = true;\n\t}\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n}\nfunction lis()\n{\t\n\tif((document.forms[0].blng_serv_code.value == \"\" && document.forms[0].service.value == \"\") && document.forms[0].incl_excl_action.value != \"\")\n\t{\n\t\t//alert(\"Billing Service Cannot be Null\")\n\t\talert(getMessage(\'BL9991\',\'BL\'));\n\t\tdocument.forms[0].incl_excl_action.value=\"\";\n\t\treturn false;\n\t}\n\telse if((document.forms[0].blng_serv_code.value == \"\" && document.forms[0].service.value == \"\") && document.forms[0].incl_excl_action.value == \"\")\n\t{\n\t\treturn false;\n\t}\n\n\tvar chk_inc_excl=document.forms[0].incl_excl.value;\n\tvar chk_inc_excl_act=document.forms[0].incl_excl_action.value;\n\tvar override_yn = document.forms[0].override_yn.value;\n\n\tif(override_yn != \'B\')\n\t{\n\t\t/*if(chk_inc_excl==chk_inc_excl_act)\n\t\t{\n\t\t\tdocument.forms[0].incl_excl_action.value=\"\";\n\t\t\tdocument.forms[0].action_reason_desc.value=\"\";\n\t\t\tdocument.forms[0].action_reason_code.value=\"\";\n\t\t\tdocument.forms[0].action_reason_desc.readOnly=true;\n\t\t\tvalexclincl();\n\t\t}\n\t\telse*/ if(chk_inc_excl_act==\"\")\n\t\t{\t\n\t\t\t\n\t\t\tdocument.forms[0].incl_excl_action.value=\"\";\n\t\t\tdocument.forms[0].action_reason_desc.value=\"\";\n\t\t\tdocument.forms[0].action_reason_code.value=\"\";\n\t\t\tdocument.forms[0].action_reason_desc.readOnly=true;\n\t\t\tdocument.forms[0].reasonbut.disabled=true;\n\t\t\tvalexclincl();\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvalexclincl();\n\t\t\tdocument.forms[0].action_reason_desc.readOnly=false;\n\t\t\tdocument.forms[0].reasonbut.disabled=false;\n\t\t\tdocument.forms[0].action_reason_desc.focus();\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(chk_inc_excl_act==\"\")\n\t\t{\t\n\t\t\tdocument.forms[0].incl_excl_action.value=\"\";\n\t\t\tdocument.forms[0].action_reason_desc.value=\"\";\n\t\t\tdocument.forms[0].action_reason_code.value=\"\";\n\t\t\tdocument.forms[0].action_reason_desc.readOnly=true;\n\t\t\tdocument.forms[0].reasonbut.disabled=true;\n\t\t\tvalexclincl();\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvalexclincl();\n\t\t\tdocument.forms[0].action_reason_desc.readOnly=false;\n\t\t\tdocument.forms[0].reasonbut.disabled=false;\n\t\t\tdocument.forms[0].action_reason_desc.focus();\n\t\t}\n\t}\n\n/*\tif(chk_inc_excl_act==\"I\")\n\t{\n      temp=\"Include\";\n\t}\n\telse{\n\t\ttemp=\"Exclude\";\n\t}\n\tif(chk_inc_excl==\"Include en\" || chk_inc_excl==\"Exclude en\")\n\t{\n\tvar pos=chk_inc_excl.lastIndexOf(\'en\');\n\tpos=pos-1;\n\tvar chk_inc_excl=chk_inc_excl.substring(0, pos);\n\t}\n\n\tif(chk_inc_excl==temp)\n\t{\n\t\tdocument.forms[0].incl_excl_action.value=\"\";\n\t}\n*/\n\n}\n\nfunction accept_chargedts_val()\n{\n\tvar serv_disc=document.forms[0].service.value;\n\tvar serv_amt=document.forms[0].rate.value;\n\tvar serv_rev_qty=document.forms[0].revise_qty.value;\n}\n\nfunction putdeci(object)\n{\t\n\t\n\tif(object.value!=\'\')\n\t{\n\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\tputDecimal(object,17,decimal);\n\t}\n}\n\nfunction pract_id_set()\n{\n\tvar practioner_type=document.forms[0].practioner_type.value;\n\tdocument.forms[0].practioner.value=\"\";\n\tif(practioner_type==\"Practitioner\")\n\t{\n\t\tdocument.forms[0].pract_id.value=\"P\";\n\t}\n\telse if(practioner_type==\"OtherStaff\")\n\t{\n\t\tdocument.forms[0].pract_id.value=\"O\";\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].pract_id.value=\"\";\n\t}\n\n}\nfunction serv_focus()\n{\n\n\tdocument.forms[0].service.focus();\n}\nfunction ChkNumberInput1(val,e,deci,call_from)\n{\n\t\n\t//document.forms[0].accept_button.disabled=true;\n\t//rateval();\t\t\n\t//document.forms[0].total_pay.value=\"\";\n\t//document.forms[0].patient_pay.value=\"\";\n\tif(call_from==\'rate\')\n\t{\t\t\n\t\tdocument.forms[0].rate_chk.value=\'Y\';\n\t}\n\tif(call_from==\'qty\')\n\t{\n\t\tdocument.forms[0].qty_chk.value=\'Y\';\t\n\t}\n\t//ChkNumberInput(val,evnt,deci);\nif (parseInt(deci)>0)\n   var strCheck = \'.0123456789\';\nelse\n   var strCheck = \'0123456789\';\n\t\nvar whichCode = (window.Event) ? e.which : e.keyCode;\nif (whichCode == 13) return true;  // Enter\n\nkey = String.fromCharCode(whichCode);  // Get key value from key code\n\nif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\nif(key == \".\" && val.value.indexOf(key) != -1) return false; // Not more than one \'.\' char\n\n\t\n}\n\nfunction changeAmt()\n{\n\tdocument.forms[0].serv_amt_changed.value=document.forms[0].rate.value;\t\n}\n</script>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"enableAllElements_service()\" >\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload=\"serv_focus()\"  >\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n<form name=\'ss\' id=\'ss\' ACTION=\'\' method=\'post\' target=\'\'>\n<table cellpadding=3 cellspacing=0 border=\'0\' width=\"100%\" align=\'right\'>\t\n</tr>\n\t<tr>\n\t<input type=\'hidden\' name=\'orig_qty\' id=\'orig_qty\' id=\'orig_qty\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<td width=\'25%\' class=\'label\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td> \n\t<td width=\'26%\' class=\"fields\"><input type=\'text\' name=\'service\' id=\'service\' size=\'20\'  maxlength=\'100\'  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onBlur=\"if(this.value != \'\'){ servicelkup(); }\"><input type=\'button\' class=\'button\' name=\"servicebut\" id=\"servicebut\" value=\'?\'  onClick=\'servicelkup();\' tabindex=\'0\' ><img src=\'../../eCommon/images/mandatory.gif\'><input type=hidden name=\'blng_serv_code\' id=\'blng_serv_code\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ></td>\n\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'incl_excl\' id=\'incl_excl\' size=\'10\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" readonly></td>\n\t\n\t\n\t</tr>\n\t<tr>\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t<!--<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'incl_excl_action\' id=\'incl_excl_action\' size=\'10\' maxlength=\'30\'  value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'></td>-->\n\t<td  width=\'25%\' class=\'fields\'>\n\t   <select name=\'incl_excl_action\' id=\'incl_excl_action\' onChange=\'lis()\'>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t <option value=\'\'>-----";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="-----</option>\n\t\t <option value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\n\t\t <option value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="-----</option>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t   </select>\n\t</td>\t\n\t <!--  <input type=hidden name=\'h_incl_excl_ind\' id=\'h_incl_excl_ind\' value=\"\" >\n\t   <input type=hidden name=\'h_incl_excl_action_ind\' id=\'h_incl_excl_action_ind\' value=\"\" >-->\n\t   \n\t<td width=\'25%\' class=\'label\' >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'action_reason_desc\' id=\'action_reason_desc\' size=\'10\'  maxlength=\'30\'  value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onBlur=\'reasonlkup();\' readonly ><input type=\'button\' class=\'button\' name=\"reasonbut\" id=\"reasonbut\"  disabled value=\'?\'  tabindex=\'0\' onClick=\'reasonlkup()\'><input type=hidden name=\'action_reason_code\' id=\'action_reason_code\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"></td>\n\t\n\t\n\t</tr>\n\t<tr>\t\t\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'ratecharge_desc\' id=\'ratecharge_desc\' size=\'15\' readonly maxlength=\'5\'  value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\'hidden\' name=\'charge\' id=\'charge\' size=\'10\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" ></td>\t\t\n\t\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'original_qty\' id=\'original_qty\' size=\'10\'  maxlength=\'7\'  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" readonly style=\'text-align:right\' onBlur=\'putdeci(this)\'><input type=hidden name=\'modify_qty_yn\' id=\'modify_qty_yn\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" ></td>\n\t\n\t\n\t</tr>\n\t<tr>\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'uom\' id=\'uom\' size=\'15\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" readonly>\n\t<input type=hidden name=\'uom_code\' id=\'uom_code\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" ></td>\n\t\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t<td width=\'25%\' class=\"fields\">\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="<!-- Modified V190909-Aravindh/TBMC-SCF-0086/Added if-else for readonly -->\n\t\t<input type=\'text\' name=\'revise_qty\' id=\'revise_qty\'  size=\'10\'  maxlength=\'7\'  value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" style=\'text-align:right\' onKeyPress=\'return ChkNumberInput1(this,event,document.forms[0].noofdecimal.value,\"qty\")\'  onBlur=\'putdeci(this);\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" />\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<input type=\'text\' name=\'revise_qty\'  id=\'revise_qty\' size=\'10\'  maxlength=\'7\'  value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" style=\'text-align:right\' onKeyPress=\'return ChkNumberInput1(this,event,document.forms[0].noofdecimal.value,\"qty\")\'  onBlur=\'putdeci(this);revqyt(\"Y\")\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' />\n\t</td>\n\t\n\t\n\t</tr>\n\t<tr>\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'total_qty\' id=\'total_qty\' size=\'10\'  maxlength=\'7\'  value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" readonly style=\'text-align:right\' onFocus=\'putdeci(this)\'></td>\n\t\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'rate\' id=\'rate\' size=\'14\'  maxlength=\'10\' style=\'text-align:right\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" onKeyPress=\'return ChkNumberInput1(this,event,document.forms[0].noofdecimal.value,\"rate\");\' onchange= \'changeAmt()\' onBlur=\'putdeci(this);rateval(\"\",\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\");\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\n\t\n\t\n\t</tr>\n\t<tr>\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t<td  width=\'25%\' class=\'fields\' >\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t   <select name=\'practioner_type\' id=\'practioner_type\' onChange=\'PractStaffInd();practstaffvalidations();pract_id_set();\' >\n\t\t   <option value=\'\'>-----";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="-----</option>\n\t\t   <option value=\'Practitioner\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</option>\n\t\t   <option value=\'OtherStaff\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</option>\n\t\t   </select><input type=hidden name=\'pract_id\' id=\'pract_id\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' >\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t <select name=\'practioner_type\' id=\'practioner_type\' >\n\t\t  <option value=\'Practitioner\' selected>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</option>\n\t\t <input type=hidden name=\'pract_id\' id=\'pract_id\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t <select name=\'practioner_type\' id=\'practioner_type\' >\n\t\t  <option value=\'OtherStaff\' selected>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</option>\n\t\t  <input type=hidden name=\'pract_id\' id=\'pract_id\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t\t\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t<select name=\'practioner_type\' id=\'practioner_type\' onChange=\"pract_id_set()\">\n\t\t    <option value=\'\'>-----";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="-----</option>\n\t \t    <option value=\'Practitioner\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</option>\n\t\t    <option value=\'OtherStaff\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</option></select>\n\t\t\t<input type=hidden name=\'pract_id\' id=\'pract_id\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t</td>\n\t\t\t\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'practioner\' id=\'practioner\' size=\'10\'  maxlength=\'100\'  value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" onBlur=\"funQry(\'B\')\"><input type=\'button\' class=\'button\' name=\"practstaffbut\" id=\"practstaffbut\" value=\'?\'  tabindex=\'0\' onClick=\"funQry(\'C\')\" ><input type=hidden name=\'pract_staff_id\' id=\'pract_staff_id\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'total_pay\' id=\'total_pay\' size=\'14\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" style=\'text-align:right\' readonly></td>\n\t\n\t<td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t<td width=\'25%\' class=\"fields\"><input type=\'text\' name=\'patient_pay\' id=\'patient_pay\' size=\'14\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" readonly style=\'text-align:right\'></td>\n\t\n\t\n\t</tr>\n\t<tr>\t\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t<td class=\'label\' width=\'25%\'><input type=\'text\' name=\'patient_paid\' id=\'patient_paid\' size=\'14\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\t\n\t<td width=\'25%\' class=\"fields\"><input type=\'checkbox\' name=\'preappr_reqd\' id=\'preappr_reqd\' size=\'10\'  maxlength=\'30\' ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" disabled ></td>\n\t\n\t\t\n\t<input type=\'hidden\' name=\'charged_yn\' id=\'charged_yn\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t<input type=\'hidden\' name=\"excl_incl_ind_for_screen\" id=\"excl_incl_ind_for_screen\" value=\"\">\n\n\t\t\n\t</tr>\n\t<tr>\n\n\t<!--<td width=\"25%\"  class=\"label\">Net Amount</td>\n\t<td class=\'label\' width=\'25%\'><input type=\'text\' name=\'net_amount\' id=\'net_amount\' size=\'10\'  maxlength=\'30\'  value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" style=\'text-align:right\' readonly></td>\n\t<input type=\'hidden\' name=\'actual_amt_val\' id=\'actual_amt_val\' value=\"\">-->\n\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" \t\n\t<td width=\"25%\"  class=\"label\">&nbsp;</td>\n\t<td width=\"25%\"  class=\"label\">&nbsp;</td>\n\t\n\t<!-- The Below Button is for Add Functionality -->\n\t<td width=\"25%\"  class=\"fields\"><input type=\'button\'  name=\"accept_button\" id=\"accept_button\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" class=\'button\' onclick=\'acceptchargedet()\'></td>\n\t<td width=\"25%\"  class=\"fields\"><input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" class=\'button\' onClick=\'cancel()\'></td>\n\t\n\t\n\t<!-- \t-->\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t<!--<td  class=\"fields\"><input type=\'button\' class=\'button\' \t\t\tonclick=\'enableAllElements_service();modify_validations()\' name=\"modify_button\" id=\"modify_button\"  value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" ></td>\n\t<td  class=\"fields\"><input type=\'button\' class=\'button\' onclick=\'enableAllElements_service_remove();remove_payer()\' name=\"remove_button\" id=\"remove_button\"  value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" ></td>-->\n\n\t<td width=\"25%\"  class=\"label\">&nbsp;</td>\n\t<td width=\"25%\"  class=\"label\">&nbsp;</td>\n\n\t<!-- The Below Button is for Add Functionality -->\n\t<td width=\"25%\"  class=\"fields\"><input type=\'button\' class=\'button\' onclick=\'acceptchargedet()\' name=\"accept_button\" id=\"accept_button\"  value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" ></td>\n\t<td width=\"25%\"  class=\"fields\"><input type=\'button\' class=\'button\' onclick=\'cancel()\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" ></td>\n\t\t\n\t<!-- \t-->\n\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t</tr>\t\n</table>\n<input type=\"hidden\" name=\'serv_amt_changed\' id=\'serv_amt_changed\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type= hidden name=\"locale\" id=\"locale\"  value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<input type= hidden name=\"facility_id\" id=\"facility_id\"  value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\t\t\n\t\t<input type= \'hidden\' name=\'action\' id=\'action\'  value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\t\t\n\t\t<input type= \'hidden\' name=\'blng_serv_code1\' id=\'blng_serv_code1\'  value=\'\'>\n\t\t<input type= hidden name=\"h_episode_type\" id=\"h_episode_type\"  value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t<input type= hidden name=\"h_patient_id\" id=\"h_patient_id\"  value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t<input type= hidden name=\"h_visit_id\" id=\"h_visit_id\"  value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t<input type= hidden name=\"h_episode_id\" id=\"h_episode_id\"  value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t<input type= hidden name=\"h_module_id\" id=\"h_module_id\"  value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t<input type= hidden name=\"str_excl_incl_ind\" id=\"str_excl_incl_ind\"  value=\'\'>\n\t\t<input type= hidden name=\"added_serv_yn\" id=\"added_serv_yn\"  value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t<input type= hidden name=\"service_panel_ind\" id=\"service_panel_ind\"  value=\'S\'>\n\t\t<input type= hidden name=\"min_chg_amt\" id=\"min_chg_amt\"  value=\'\'>\n\t\t<input type= hidden name=\"desc_amt\" id=\"desc_amt\"  value=\'\'>\n\t\t<input type= hidden name=\"preapp_yn\" id=\"preapp_yn\"  value=\'\'>\n\t\t<input type= hidden name=\"override_yn\" id=\"override_yn\"  value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t<input type= hidden name=\"service_date\" id=\"service_date\"  value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" >\n\t\t<input type=\'hidden\' name=\'charge_flag\' id=\'charge_flag\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" >\n\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" >\n\t\t<input type=\'hidden\' name=\'acc_seq_no\' id=\'acc_seq_no\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >\n\t\t<input type=\'hidden\' name=\'p_order_id\' id=\'p_order_id\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" >\n\t\t<input type=\'hidden\' name=\'p_order_line_no\' id=\'p_order_line_no\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" >\n\t\t<input type=\'hidden\' name=\"service_panel_ind1\" id=\"service_panel_ind1\"  value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t<input type=\'hidden\' name=\"str_epi_type_clinic_code\" id=\"str_epi_type_clinic_code\"  value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t<input type= \'hidden\' name=\"rate_chk\" id=\"rate_chk\"  value=\'\'>\n\t\t<input type= \'hidden\' name=\"qty_chk\" id=\"qty_chk\"  value=\'\'>\n\t\t<input type= \'hidden\' name=\"rate_chk_close\" id=\"rate_chk_close\"  value=\'\'>\n\t\t<input type= \'hidden\' name=\"panel_qty\" id=\"panel_qty\"  value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t\t<input type= \'hidden\' name=\"dirIndirChrgsFlag\" id=\"dirIndirChrgsFlag\"  value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\n\t\t<input type=\'hidden\' name=\'bean_id_bl\' id=\'bean_id_bl\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" >\n\t\t<input type=\'hidden\' name=\'calledfrmencYN\' id=\'calledfrmencYN\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" >\n\t<!-- Modified By muthukumar on 31-1-12 against SKR-SCF-0320 -->\n\t\t<input type=\'hidden\' name=\'max_chg_amt\' id=\'max_chg_amt\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t<input type=\'hidden\' name=\'max_chg_amt1\' id=\'max_chg_amt1\' value=\'\'>\n\t<!-- Modified By muthukumar on 31-1-12 against SKR-SCF-0320 -->\n\t\t\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

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
	
	Connection con = null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ; //Modified By muthukumar on 31-1-12 against SKR-SCF-0320
	//ResultSet rs1 = null; ResultSet rs2 = null; 
	ResultSet rs_dec=null;
	ResultSet rs_dec1=null; //Modified By muthukumar on 31-1-12 against SKR-SCF-0320
	
	ResultSet  rs_chrge = null;

	//Statement stmt=null;	
		String myval=request.getParameter("blng_serv_code");
		//muthu
		  String bling_serv_code1="";
		 //muthu
	String locale = (String)session.getAttribute("LOCALE");
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	con	=	ConnectionManager.getConnection(request);
	//String sql_chr_det=""; String sql_phisician=""; String sql_phisician1="";
	String p_action_ind="";	//String sql=""; String sql1=""; String sql2=""; String sql3="";
	String stradded_serv_yn="";	String readonly="";
	
	String originalqty="";
	String revise_qty_flag="";	String rate_flag="";
	 p_action_ind=request.getParameter("action");
	
	if(p_action_ind==null || p_action_ind.equals("")) p_action_ind="";
	if(p_action_ind.equals("add"))
	{
		
		stradded_serv_yn="Y";
		
	}
		else 
		{
			//System.out.println("Entering into Else Condition********* ");
			stradded_serv_yn=request.getParameter("added_serv_yn");
			readonly="READONLY";
		}
	//if(stradded_serv_yn.equals("null"))stradded_serv_yn="N";
	String p_facility_id="";	String p_login_user=""; 	String p_episode_type="";
	String p_patient_id="";    	String str_episode_id="";long p_episode_id=0;     	String str_visit_id="";
	long p_visit_id=0; String p_service_date="";   String p_service_panel_ind=""; 	String p_service_panel_code="";
	String p_serv_panel_qty=""; 	String p_pract_staff_ind=""; 	//String p_pract_staff_id="";
	String p_serv_panel_str=""; 	String p_order_catalog_code=""; 	String service="";
	String incl_excl="";	String incl_excl_action=""; String incl_action_flag="";String excl_action_flag=""; 	String reason=""; String uom="";String charge="";		String original_qty="";		String revise_qty="";	
	String total_qty="";	String rate="";	 	String practioner_type=""; String pract_staff_id=""; 	
	String practioner="";	String total_pay="";		String patient_pay=""; //String cbflag="";
	//String strservice=""; 		String strincl_excl="";		String strincl_excl_action="";
	//String strreason="";	String strcharge="";	String stroriginal_qty="";
	//String strrevise_qty="";	String strtotal_qty="";	String strrate=""; String struom="";
	//String strpractioner_type="";String strpractioner="";	String strtotal_pay="";String strpatient_pay="";		
	//String cbflag1=""; String cbflag12="";
	String patient_paid=""; String blng_serv_code=""; String action_reason_code="";String  uom_code=""; 
	String pract_id="";	String p_module_id=""; 	String preappr_reqd="";String modify_qty_yn=""; 	int noofdecimal=0;
	float max_chg_amt=0; //Modified By muthukumar on 31-1-12 against SKR-SCF-0320
	float max_chg_amt1=0;
    String include_label="";String exclude_label="";
	String str_encounter_id="";String str_acct_seq_no="";String ratecharge_desc="";	String p_charged_yn="";
	String p_order_id=""; String p_order_line_no="";String str_override_yn="";
	String p_serv_qty=""; String str_charge_based_amt="";String p_incl_excl_action="";String override_allowed_yn="",panel_qty="",serv_amt_changed="";
	/****ghl-crf-1.2*************/
	String calledfrmencYN="N";
	String bean_id_bl ="";
	String charge_logic_yn="";
	String dirIndirChrgsFlag="";
	//String bean_name_bl="";
	//HashMap finDtls		= new HashMap();
	/******end*******************/



	String str_epi_type_clinic_code="";
	try
	{
		
		originalqty=request.getParameter("original_qty");
		System.out.println("original_qty"+originalqty);
		
		p_facility_id = (String)httpSession.getValue("facility_id");
		p_login_user =  p.getProperty("login_user");
		p_episode_type = request.getParameter("episode_type");
		p_patient_id = request.getParameter("patient_id");
		str_visit_id = request.getParameter("visit_id");		
		str_episode_id = request.getParameter("episode_id");
		p_service_date = request.getParameter("service_date");
		p_service_panel_ind = request.getParameter("service_panel_ind");
		p_service_panel_code = request.getParameter("service_panel_code");
		p_serv_panel_qty = request.getParameter("serv_panel_qty");
		p_pract_staff_ind = request.getParameter("pract_staff_ind");
		include_label=request.getParameter("include_label");
		exclude_label=request.getParameter("exclude_label");	
		dirIndirChrgsFlag=request.getParameter("dirIndirChrgsFlag");

		practioner_type = request.getParameter("practioner_type");
		pract_id=request.getParameter("pract_id");

		practioner = request.getParameter("practioner");
		pract_staff_id = request.getParameter("pract_staff_id");

		p_serv_panel_str = request.getParameter("serv_panel_str");
		p_order_catalog_code = request.getParameter("order_catalog_code");	
		p_module_id = request.getParameter("module_id");		
		str_encounter_id=request.getParameter("encounter_id");
		ratecharge_desc=request.getParameter("ratecharge_desc");
		p_charged_yn=request.getParameter("p_charged_yn");
		p_serv_qty=request.getParameter("revise_qty");
		if(p_serv_qty==null || p_serv_qty.equals("")) p_serv_qty="";	

		panel_qty=request.getParameter("panel_qty");
		if(panel_qty==null || panel_qty.equals("")) panel_qty="";	

		override_allowed_yn=request.getParameter("override_allowed_yn");
		if(override_allowed_yn==null || override_allowed_yn.equals(" ")) override_allowed_yn="";
	
		p_order_id = request.getParameter("p_order_id");
		if(p_order_id==null || p_order_id.equals("")) p_order_id="";
		
		p_order_line_no= request.getParameter("p_order_line_no");
		if(p_order_line_no==null || p_order_line_no.equals("")) p_order_line_no="";		

		serv_amt_changed=request.getParameter("serv_amt_changed");
		if(serv_amt_changed==null || serv_amt_changed.equals("")) serv_amt_changed="";

		if(str_encounter_id==null || str_encounter_id.equals("")) str_encounter_id="0";
		str_acct_seq_no=request.getParameter("acct_seq_no");
		if(str_acct_seq_no==null || str_acct_seq_no.equals("")) str_acct_seq_no="1";

		str_epi_type_clinic_code=request.getParameter("str_epi_type_clinic_code");
		if(str_epi_type_clinic_code==null) str_epi_type_clinic_code="";

		if(p_episode_type==null) p_episode_type="";
		if(p_patient_id==null) p_patient_id="";
		if(str_visit_id==null) str_visit_id="0";
		if(str_episode_id==null) str_episode_id="0";
		if(p_service_date==null) p_service_date="";
//		p_service_date=com.ehis.util.DateUtils.convertDate(p_service_date,"DMYHMS","en",locale);
		if(p_service_panel_ind==null) p_service_panel_ind="";
		
		if(p_serv_panel_qty==null) p_serv_panel_qty="";		
		if(p_pract_staff_ind==null) p_pract_staff_ind="";
		if(pract_id==null) pract_id="";
		if(practioner_type==null) practioner_type="";
		if(pract_staff_id==null) pract_staff_id="";
		if(practioner==null) practioner="";
//		System.out.println("practioner @@" + practioner);
		if(p_serv_panel_str==null) p_serv_panel_str="";
		if(p_order_catalog_code==null) p_order_catalog_code="";
		if(ratecharge_desc==null) ratecharge_desc="";
		if(p_charged_yn==null) p_charged_yn="";
		p_episode_id=Long.parseLong(str_episode_id);	
		p_visit_id=Integer.parseInt(str_visit_id);	

		//include_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Include.label","common_labels");
		//exclude_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Exclude.label","common_labels");

		/****ghl-crf-1.2*************/	
		calledfrmencYN=request.getParameter("calledfrmencYN");
		if(calledfrmencYN==null) calledfrmencYN="";
//		System.out.println("calledfrmencYN edit"+calledfrmencYN);
		if(calledfrmencYN.equals("Y"))
		{
			bean_id_bl=request.getParameter("bean_id_bl");
			if(bean_id_bl==null) bean_id_bl="";
		}
			/******end*******************/	
	}
	catch(Exception eX)
	{	
		out.println("Error= "+eX);
	}
	
	try
	{
		pstmt1 = con.prepareStatement("select NVL(charge_logic_yn,'N') from bl_parameters where operating_facility_id ='"+p_facility_id+"'");				
		rs_chrge = pstmt1.executeQuery();	
		if ( rs_chrge.next() && rs_chrge != null )
			charge_logic_yn  =  rs_chrge.getString(1);
		System.out.println(" Charage logic  Yn "+charge_logic_yn);
		
	}
	catch(Exception ee1)  {System.out.println("Exception ee"+ee1);}
	finally
	{
		if(rs_chrge!=null) rs_chrge.close();
		if(pstmt1!=null) pstmt1.close();		
	}
	
		try
			{
//Modified By muthukumar on 31-1-12 against SKR-SCF-0320
String bling_serv_code=request.getParameter("blng_serv_code");
pstmt1 = con.prepareStatement("select nvl(MAX_CHARGE_AMT,0) MAX_CHARGE_AMT from bl_blng_serv where BLNG_SERV_CODE ='"+bling_serv_code+"'");				
rs_dec1 = pstmt1.executeQuery();	
if ( rs_dec1.next() && rs_dec1 != null ) 
max_chg_amt  =  rs_dec1.getInt(1);
//Modified By muthukumar on 31-1-12 against SKR-SCF-0320
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");				
				rs_dec = pstmt.executeQuery();	
				if ( rs_dec.next() && rs_dec != null ) 
				noofdecimal  =  rs_dec.getInt(1);
				
				/*String sqlincexclover="{call blcommon.bl_check_excl_incl_override('"+p_facility_id+"','"+p_episode_type+"','"+p_episode_id+"','"+p_visit_id+"','"+p_patient_id+"','"+p_service_panel_code+"',?)}";
				CallableStatement call = con.prepareCall(sqlincexclover);	
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.execute();	
				str_override_yn=call.getString(1);
				if(str_override_yn==null) str_override_yn="";
				System.out.println("str_override_yn"+str_override_yn);
				call.close();
				*/
			}
			catch(Exception e)
			{
				System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rs_dec != null)   rs_dec.close();
				if (rs_dec1 != null)   rs_dec1.close(); //Modified By muthukumar on 31-1-12 against SKR-SCF-0320
				if (pstmt != null) pstmt.close();
				if (pstmt1 != null) pstmt1.close();//Modified By muthukumar on 31-1-12 against SKR-SCF-0320
				if(con!=null) {
				ConnectionManager.returnConnection(con, request);
							}
			}

	try{   
	//muthu
	String service1=request.getParameter("service");
	//muthu
		if(p_action_ind.equals("modify") || p_action_ind.equals("remove"))
		{
			//System.out.println("Enter into Modify 204 in BodyEdit.jsp **** ");
			service=request.getParameter("service");
			//muthu
			//System.out.println("muthu_in_modified mode======>"+service);
			//muthu
			if(service==null || service.equals("")) service="";
			blng_serv_code=request.getParameter("blng_serv_code");
			if(blng_serv_code==null || blng_serv_code.equals("")) blng_serv_code="";
			incl_excl=request.getParameter("incl_excl");
			if(incl_excl==null || incl_excl.equals("")) incl_excl="";			
			incl_excl_action=request.getParameter("incl_excl_action");
			if(incl_excl_action==null || incl_excl_action.equals("")) incl_excl_action="";
			if(incl_excl_action.equals(include_label))
			{
//				System.out.println("exclude_label edit 1");
				incl_action_flag="SELECTED";
				excl_action_flag="";
			}
			else if(incl_excl_action.equals(exclude_label))
					{
				
						incl_action_flag="";
						excl_action_flag="SELECTED";
					}
					reason=request.getParameter("reason");
					if(reason==null ||reason.equals("")) reason="";
					action_reason_code=request.getParameter("action_reason_code");
					if(action_reason_code==null ||action_reason_code.equals("")) action_reason_code="";
					charge=request.getParameter("charge");
				
					if(charge==null ||charge.equals("")) charge="";
					original_qty=request.getParameter("original_qty");
					if(original_qty==null ||original_qty.equals("")) original_qty="";
					modify_qty_yn=request.getParameter("modify_qty_yn");
					if(modify_qty_yn==null ||modify_qty_yn.equals("")) modify_qty_yn="";
					uom=request.getParameter("uom");
					if(uom==null ||uom.equals("")) uom="";
					uom_code=request.getParameter("uom_code");
					if(uom_code==null ||uom_code.equals("")) uom_code="";
					revise_qty=request.getParameter("revise_qty");
					if(revise_qty==null ||revise_qty.equals("")) revise_qty="";
					total_qty=request.getParameter("total_qty");
					if(total_qty==null ||total_qty.equals("")) total_qty="";
					rate=request.getParameter("rate");
					if(rate==null ||rate.equals("")) rate="";
					if(charge.equals("R"))
						{
							rate_flag="readonly";	
						}
						else if(charge.equals("C"))
							{
								revise_qty_flag="readonly";	
							}

						if(charge.equals("R"))
						{
							str_charge_based_amt=revise_qty;	
						}
						else if(charge.equals("C"))
							{
							str_charge_based_amt=rate;
							}		
							if(incl_excl_action.equals("Exclude en")||incl_excl_action.equals("Exclude"))
							{
								p_incl_excl_action="E";
							}
							else if(incl_excl_action.equals("Include en")||incl_excl_action.equals("Include"))
								{
									p_incl_excl_action="I";
								}

/*	practioner_type=request.getParameter("practioner_type");
	if(practioner_type.equals("")) practioner_type="";
	pract_id=request.getParameter("pract_id");
	if(pract_id.equals("")) pract_id="";
	practioner=request.getParameter("practioner");
	if(practioner.equals("")) practioner="";
*/
						pract_id=request.getParameter("pract_id");
						if(pract_id==null || pract_id.equals("")) pract_id="";
						practioner_type = request.getParameter("practioner_type");
						if(practioner_type==null || practioner_type.equals("")) practioner_type="";
						pract_staff_id = request.getParameter("pract_staff_id");
						if(pract_staff_id==null || pract_staff_id.equals("")) pract_staff_id="";
						practioner = request.getParameter("practioner");
						if(practioner==null || practioner.equals("")) practioner="";
						total_pay=request.getParameter("total_pay");
						if(total_pay==null || total_pay.equals("")) total_pay="";
						patient_pay=request.getParameter("patient_pay");
						if(patient_pay==null || patient_pay.equals("")) patient_pay="";
						patient_paid=request.getParameter("patient_paid");
						if(patient_paid==null || patient_paid.equals("")) patient_paid="";
						preappr_reqd=request.getParameter("cbflag");	
						if(preappr_reqd==null || preappr_reqd.equals("")) preappr_reqd="";

						serv_amt_changed=request.getParameter("serv_amt_changed");
		if(serv_amt_changed==null || serv_amt_changed.equals("")) serv_amt_changed="";
		}
	
		}catch(Exception eX)
			{	
				out.println("Error modfy= "+eX);
			}
		/*	finally 
			{
				if (rs_dec1 != null)   rs_dec1.close();
				if (pstmt1 != null) pstmt1.close();		 		
				if(con!=null) {
				ConnectionManager.returnConnection(con, request);
							 }
			}*/

//billserventry proc.......

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getParameter("title")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(str_override_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(override_allowed_yn));
            _bw.write(_wl_block11_0Bytes, _wl_block11_0);
            _bw.write(_wl_block11_1Bytes, _wl_block11_1);
            _bw.write(_wl_block11_2Bytes, _wl_block11_2);
 if(charge_logic_yn.equals("N")){
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

	if(p_action_ind.equals("modify"))
	{
		System.out.println("1300 in BodyEdit.jsp ");

            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	
		else
		{

            _bw.write(_wl_block15Bytes, _wl_block15);

		}


            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(originalqty));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(service));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(blng_serv_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
   
/*rs_dec1.close();
	pstmt1.close();
	System.out.println("]]]]]]]]]]]]]]]]]]---->"+bling_serv_code1);
	
	con	=	ConnectionManager.getConnection(request);
pstmt1 = con.prepareStatement("select nvl(MAX_CHARGE_AMT,0) MAX_CHARGE_AMT from bl_blng_serv where BLNG_SERV_CODE ='"+bling_serv_code1+"'");				
rs_dec1 = pstmt1.executeQuery();	
if ( rs_dec1.next() && rs_dec1 != null ) 
max_chg_amt1  =  rs_dec1.getInt(1);
System.out.println("sumasumasumasumasumasumasuma========>"+max_chg_amt1); */
	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(incl_excl));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(incl_excl_action));
            _bw.write(_wl_block25Bytes, _wl_block25);

   
		if(override_allowed_yn.equals("I"))
		{

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(include_label));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(incl_action_flag));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(include_label));
            _bw.write(_wl_block30Bytes, _wl_block30);

		}
		else if(override_allowed_yn.equals("E"))
		{

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(exclude_label));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(excl_action_flag));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(exclude_label));
            _bw.write(_wl_block30Bytes, _wl_block30);

		}
		else if(override_allowed_yn.equals("B"))
		{

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(include_label));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(incl_action_flag));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(include_label));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(exclude_label));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(excl_action_flag));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(exclude_label));
            _bw.write(_wl_block30Bytes, _wl_block30);

		}
		else
		{

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

		}

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(action_reason_code));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ratecharge_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(charge));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(original_qty));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(modify_qty_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
 if("readonly".equals(revise_qty_flag)) {
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(revise_qty));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(revise_qty_flag));
            _bw.write(_wl_block49Bytes, _wl_block49);
 } else { 
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(revise_qty));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(revise_qty_flag));
            _bw.write(_wl_block49Bytes, _wl_block49);
 } 
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(total_qty));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rate));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(max_chg_amt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(rate_flag));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

	if(p_action_ind.equals("add")|| p_action_ind.equals("modify"))
	{
				System.out.println("1408 in BodyEdit.jsp ");
		String pract_select="";
		String other_select="";
		if(pract_id.equals("P"))
		{
			pract_select="SELECTED";
		}
		else if(pract_id.equals("O"))
		{
			other_select="SELECTED";
		}
	
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(pract_select));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(other_select));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block64Bytes, _wl_block64);

	}	
	else if( p_action_ind.equals("remove"))
	{
				System.out.println("1429 in BodyEdit.jsp ");
		if(pract_id.equals("P"))
		{

            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block67Bytes, _wl_block67);

		}
		else if(pract_id.equals("O"))
		{

            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block70Bytes, _wl_block70);

		}
		else
		{

            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
		}
	}

            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(practioner));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(pract_staff_id));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(total_pay));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patient_pay));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(patient_paid));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(preappr_reqd));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(preappr_reqd));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(p_charged_yn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(patient_paid));
            _bw.write(_wl_block87Bytes, _wl_block87);

	if(p_action_ind.equals("add"))
	{
				System.out.println("1494 in BodyEdit.jsp ");

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block90Bytes, _wl_block90);

	}
	else
	{

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block95Bytes, _wl_block95);

	}

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(serv_amt_changed));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(p_facility_id ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(p_action_ind));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(p_episode_type));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(p_visit_id));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(p_episode_id));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(p_module_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(stradded_serv_yn));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(override_allowed_yn));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(p_service_date));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(charge));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(str_encounter_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(str_acct_seq_no));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(p_order_id));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(p_order_line_no));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(p_service_panel_ind));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(str_epi_type_clinic_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(panel_qty));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(dirIndirChrgsFlag));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(bean_id_bl));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(calledfrmencYN));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(max_chg_amt));
            _bw.write(_wl_block121Bytes, _wl_block121);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INCLUDED_EXCLUDED.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INCLUDED_EXCLUDED_ACTION.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RATE_CHARGE.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ORIG_QTY_PER_PANEL.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REVISED_QTY_PER_PANEL.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TOTAL_QTY.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RATE.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRACT_STAFF_TYPE.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherStaff.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherStaff.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherStaff.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRACTITIONER_STAFF.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TOTAL_PAYABLE.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PREAPPR_REQD.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
