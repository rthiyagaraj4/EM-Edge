package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blvisitchargedet extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLVisitChargeDet.jsp", 1737917595610L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\n\n<html>\n\t<head>\n\t<script language=\'javascript\'>\n\t\tfunction showvisitcharge()\n\t\t{\t\t\n\t\t\tvar hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;\n\t\t\tvar medvisitchargeYN=document.forms[0].medvisitchargeYN.value;\n\t\t\tvar addlvisitchargeYN = document.forms[0].addlvisitchargeYN.value;\n\t\t\tvar exempt_date=document.forms[0].exempt_date.value;\n\t\t\tvar bill_gen=document.forms[0].bill_gen.value;\n\n/*** CRF-362 SCRUM related changes starts ****/\n\t\t\tvar charge_net_amt=document.forms[0].charge_net_amt.value;\n\t\t\tvar patientPayble=document.forms[0].patientPayble.value;\n\t\t\tvar ae_bed_calYN=document.forms[0].ae_bed_calYN.value;\n/*** CRF-362 SCRUM related changes ends ****/\n\n\t\t\tif(hospvisitchargeYN == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"hospchrgamt\").innerText=document.forms[0].str_hosp_chrg_amt.value;\n\t\t\t\tdocument.getElementById(\"hospchrgpatamt\").innerText=document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\t}\n\t\t\tif(medvisitchargeYN == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"profchrgamt\").innerText=document.forms[0].str_med_chrg_amt.value;\n\t\t\t\tdocument.getElementById(\"profchrgpatamt\").innerText=document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\t}\n\t\t\tif(addlvisitchargeYN == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"addlchrgamt\").innerText=document.forms[0].str_addl_chrg_amt.value;\n\t\t\t\tdocument.getElementById(\"addlchrgpatamt\").innerText=document.forms[0].str_addl_chrg_pat_amt.value;\n\t\t\t}\n\t\t\t\n/*** CRF-362 SCRUM related changes starts ****/\n\t\t\tif(charge_net_amt != \"\" && ae_bed_calYN == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"chrNetAmt\").innerText=charge_net_amt;\n\t\t\t\tdocument.getElementById(\"patientbedpay\").innerText=patientPayble;\n\t\t\t}\n/*** CRF-362 SCRUM related changes ends ****/\n\n\t\t\tif(exempt_date!=\"\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"exemptdate\").innerText=document.forms[0].exempt_date.value;\n\t\t\t}\n\t\t\telse if(bill_gen!=\"\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"billgen\").innerText=document.forms[0].bill_gen.value;\n\t\t\t}\n\n\t\t }\n\t\t\n\t\tfunction continuemodifybut(Obj)\n\t\t {\n\t\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\t\t\t\n\t\t\tif (Obj == \"C\")\n\t\t\t {\n\t\t\t\tif(call_after_reg==\"Y\")\n\t\t\t\t{\n\t\t\t\t\t//window.returnValue=1;\n\t\t\t\t\t//parent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = 1;\n\t\t\t\t\tparent.parent.document.querySelectorAll(\'#dialog-body\')[parent.parent.document.querySelectorAll(\'#dialog-body\').length-1].contentWindow.returnValue= 1;\n \n\t\t\t\t\tdocument.forms[0].action=\"../../servlet/eBL.BLFinancialDetailsCloseConsultServlet\";\n\t\t\t\t\tdocument.forms[0].submit();\n\t\t\t\t\t//parent.parent.document.getElementById(\'dialog_tag\').close();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//window.returnValue=1;\n\t\t\t\t\t//window.close();\n\t\t\t\t\t\n\t\t\t\t\t/* parent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = 1;\n\t\t\t\t\tparent.parent.document.getElementById(\'dialog_tag\').close(); */\n\t\t\t\t\tparent.parent.document.querySelectorAll(\'#dialog-body\')[parent.parent.document.querySelectorAll(\'#dialog-body\').length-1].contentWindow.returnValue = 1;\n\t\t\t\t\tparent.parent.document.querySelectorAll(\'#dialog_tag\')[parent.parent.document.querySelectorAll(\'#dialog_tag\').length-1].close();\n \n\t\t\t\t}\n\t\t\t }\n\t\t\telse\n\t\t\t {\t\n\t\t\t\t//window.returnValue=2;\n\t\t\t\t//window.close();\t\t\n\t\t\t\t/* parent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = 2;\n\t\t\t\tparent.parent.document.getElementById(\'dialog_tag\').close(); */\n\t\t\t\tparent.parent.document.querySelectorAll(\'#dialog-body\')[parent.parent.document.querySelectorAll(\'#dialog-body\').length-1].contentWindow.returnValue = 2;\n\t\t\t\tparent.parent.document.querySelectorAll(\'#dialog_tag\')[parent.parent.document.querySelectorAll(\'#dialog_tag\').length-1].close();\n\n\t\t\t}\n\n\t\t }\n\n\t\t /* function continuemodifybut(Obj)\n\t\t {\n\t\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\n\t\t\tif (Obj == \"C\")\n\t\t\t {\n\t\t\t\tif(call_after_reg==\"Y\")\n\t\t\t\t{\n//\t\t\t\t\talert(\"In VisitChargeDet\");\n\t\t\t\t\twindow.returnValue=1;\n\t\t\t\t\tdocument.forms[0].action=\"../../servlet/eBL.BLFinancialDetailsCloseConsultServlet\";\n\t\t\t\t\tdocument.forms[0].submit();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\twindow.returnValue=1;\n\t\t\t\t\twindow.close();\t\t\t\n\t\t\t\t}\n\t\t\t }\n\t\t\telse\n\t\t\t {\t\n\t\t\t\n\t\t\t\twindow.returnValue=2;\n\t\t\t\twindow.close();\t\t\t\n\t\t\t}\n\n\t\t } */\n\n\t\t function hsptl_chrg()\n\t\t {\n\t\t\tvar episode_type=document.forms[0].episode_type.value;\n\t\t\tvar patient_id = document.forms[0].patient_id.value;\t\t\t\n\t\t\tvar visit_id=document.forms[0].visit_id.value;\n\t\t\tvar episode_id=document.forms[0].episode_id.value;\n\t\t\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\t\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\n\t\t\tvar hosp_serv_panel_ind=document.forms[0].hosp_serv_panel_ind.value;\n\t\t\tvar hosp_serv_panel_code=document.forms[0].hosp_serv_panel_code.value;\n\t\t\tvar hosp_serv_panel_qty=document.forms[0].hosp_serv_panel_qty.value;\n\t\t\tvar hosp_serv_chrg_amt=document.forms[0].hosp_serv_chrg_amt.value;\n\n\t\t\tvar med_serv_panel_ind=document.forms[0].med_serv_panel_ind.value;\n\t\t\tvar med_serv_panel_code=document.forms[0].med_serv_panel_code.value;\n\t\t\tvar med_serv_panel_qty=document.forms[0].med_serv_panel_qty.value;\n\t\t\tvar med_serv_chrg_amt=document.forms[0].med_serv_chrg_amt.value;\n\n\t\t\tvar addl_serv_panel_ind=document.forms[0].addl_serv_panel_ind.value;\n\t\t\tvar addl_serv_panel_code=document.forms[0].addl_serv_panel_code.value;\n//\t\t\tvar med_serv_panel_str=document.forms[0].med_serv_panel_str.value;\n\t\t\tvar addl_serv_panel_qty=document.forms[0].addl_serv_panel_qty.value;\n\t\t\tvar addl_serv_chrg_amt=document.forms[0].addl_serv_chrg_amt.value;\n\n\t\t\tvar str_hosp_chrg_amt=document.forms[0].str_hosp_chrg_amt.value;\n\t\t\tvar str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\tvar str_med_chrg_amt=document.forms[0].str_med_chrg_amt.value;\n\t\t\tvar str_med_chrg_pat_amt=document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\tvar str_addl_chrg_amt=document.forms[0].str_addl_chrg_amt.value;\n\t\t\tvar str_addl_chrg_pat_amt=document.forms[0].str_addl_chrg_pat_amt.value;\n\n\t\t\tvar hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;\n\t\t\tvar medvisitchargeYN=document.forms[0].medvisitchargeYN.value;\n\t\t\tvar addlvisitchargeYN=document.forms[0].addlvisitchargeYN.value;\n\n\t\t\tvar exempt_date = document.forms[0].exempt_date.value;\n\n\t\t\tvar clinic_code=document.forms[0].clinic_code.value;\n/*** CRF-362 SCRUM related changes starts ****/\n\t\t\tvar charge_net_amt=document.forms[0].charge_net_amt.value;\n\t\t\tvar patientPayble=document.forms[0].patientPayble.value;\n/*** CRF-362 SCRUM related changes ends ****/\n\t\t\t var url=\"../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble=\"+patientPayble+\"&charge_net_amt=\"+charge_net_amt+\"&hsptl_chrg=Y&call_after_reg=\"+call_after_reg+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&calling_module_id=\"+calling_module_id+\"&hosp_serv_panel_ind=\"+hosp_serv_panel_ind+\"&hosp_serv_panel_code=\"+hosp_serv_panel_code+\"&hosp_serv_panel_qty=\"+hosp_serv_panel_qty+\"&hosp_serv_chrg_amt=\"+hosp_serv_chrg_amt+\"&med_serv_panel_ind=\"+med_serv_panel_ind+\"&med_serv_panel_code=\"+med_serv_panel_code+\"&med_serv_panel_qty=\"+med_serv_panel_qty+\"&med_serv_chrg_amt=\"+med_serv_chrg_amt+\"&addl_serv_panel_ind=\"+addl_serv_panel_ind+\"&addl_serv_panel_code=\"+addl_serv_panel_code+\"&addl_serv_panel_qty=\"+addl_serv_panel_qty+\"&addl_serv_chrg_amt=\"+addl_serv_chrg_amt+\"&str_hosp_chrg_amt=\"+str_hosp_chrg_amt+\"&str_hosp_chrg_pat_amt=\"+str_hosp_chrg_pat_amt+\"&str_med_chrg_amt=\"+str_med_chrg_amt+\"&str_med_chrg_pat_amt=\"+str_med_chrg_pat_amt+\"&str_addl_chrg_amt=\"+str_addl_chrg_amt+\"&str_addl_chrg_pat_amt=\"+str_addl_chrg_pat_amt+\"&clinic_code=\"+clinic_code+\"&hospvisitchargeYN=\"+hospvisitchargeYN+\"&medvisitchargeYN=\"+medvisitchargeYN+\"&addlvisitchargeYN=\"+addlvisitchargeYN+\"&exempt_date=\"+encodeURIComponent(exempt_date);\n\n\t\t\t\n//\t\t\talert(\"url:\"+url);\n\t\t\tparent.frames[1].location.href=url;\n\t\t\n\t\t}\n\n\t\t function prof_chrg()\n\t\t {\n\n\t\t\t var episode_type=document.forms[0].episode_type.value;\n\t\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\t\tvar visit_id=document.forms[0].visit_id.value;\n\t\t\tvar episode_id=document.forms[0].episode_id.value;\n\t\t\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\t\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\n\t\t\tvar hosp_serv_panel_ind=document.forms[0].hosp_serv_panel_ind.value;\n\t\t\tvar hosp_serv_panel_code=document.forms[0].hosp_serv_panel_code.value;\n//\t\t\tvar hosp_serv_panel_str=document.forms[0].hosp_serv_panel_str.value;\n\t\t\tvar hosp_serv_panel_qty=document.forms[0].hosp_serv_panel_qty.value;\n\t\t\tvar hosp_serv_chrg_amt=document.forms[0].hosp_serv_chrg_amt.value;\n\n\t\t\tvar med_serv_panel_ind=document.forms[0].med_serv_panel_ind.value;\n\t\t\tvar med_serv_panel_code=document.forms[0].med_serv_panel_code.value;\n//\t\t\tvar med_serv_panel_str=document.forms[0].med_serv_panel_str.value;\n\t\t\tvar med_serv_panel_qty=document.forms[0].med_serv_panel_qty.value;\n\t\t\tvar med_serv_chrg_amt=document.forms[0].med_serv_chrg_amt.value;\n\n\t\t\tvar addl_serv_panel_ind=document.forms[0].addl_serv_panel_ind.value;\n\t\t\tvar addl_serv_panel_code=document.forms[0].addl_serv_panel_code.value;\n//\t\t\tvar med_serv_panel_str=document.forms[0].med_serv_panel_str.value;\n\t\t\tvar addl_serv_panel_qty=document.forms[0].addl_serv_panel_qty.value;\n\t\t\tvar addl_serv_chrg_amt=document.forms[0].addl_serv_chrg_amt.value;\n\t\t\t\n\t\t\tvar str_hosp_chrg_amt=document.forms[0].str_hosp_chrg_amt.value;\n\t\t\tvar str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\tvar str_med_chrg_amt=document.forms[0].str_med_chrg_amt.value;\n\t\t\tvar str_med_chrg_pat_amt=document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\tvar str_addl_chrg_amt=document.forms[0].str_addl_chrg_amt.value;\n\t\t\tvar str_addl_chrg_pat_amt=document.forms[0].str_addl_chrg_pat_amt.value;\n\n\t\t\tvar exempt_date = document.forms[0].exempt_date.value;\n\n\t\t\tvar clinic_code=document.forms[0].clinic_code.value;\n\n\t\t\tvar hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;\n\t\t\tvar medvisitchargeYN=document.forms[0].medvisitchargeYN.value;\n\t\t\tvar addlvisitchargeYN=document.forms[0].addlvisitchargeYN.value;\n\n/*** CRF-362 SCRUM related changes starts ****/\n\t\t\tvar charge_net_amt=document.forms[0].charge_net_amt.value;\n\t\t\tvar patientPayble=document.forms[0].patientPayble.value;\n/*** CRF-362 SCRUM related changes ends ****/\n\n\t\t\tvar url=\"../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble=\"+patientPayble+\"&charge_net_amt=\"+charge_net_amt+\"&prof_chrg=Y&call_after_reg=\"+call_after_reg+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&calling_module_id=\"+calling_module_id+\"&hosp_serv_panel_ind=\"+hosp_serv_panel_ind+\"&hosp_serv_panel_code=\"+hosp_serv_panel_code+\"&hosp_serv_panel_qty=\"+hosp_serv_panel_qty+\"&hosp_serv_chrg_amt=\"+hosp_serv_chrg_amt+\"&med_serv_panel_ind=\"";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="+med_serv_panel_ind+\"&med_serv_panel_code=\"+med_serv_panel_code+\"&med_serv_panel_qty=\"+med_serv_panel_qty+\"&med_serv_chrg_amt=\"+med_serv_chrg_amt+\"&addl_serv_panel_ind=\"+addl_serv_panel_ind+\"&addl_serv_panel_code=\"+addl_serv_panel_code+\"&addl_serv_panel_qty=\"+addl_serv_panel_qty+\"&addl_serv_chrg_amt=\"+addl_serv_chrg_amt+\"&str_hosp_chrg_amt=\"+str_hosp_chrg_amt+\"&str_hosp_chrg_pat_amt=\"+str_hosp_chrg_pat_amt+\"&str_med_chrg_amt=\"+str_med_chrg_amt+\"&str_med_chrg_pat_amt=\"+str_med_chrg_pat_amt+\"&str_addl_chrg_amt=\"+str_addl_chrg_amt+\"&str_addl_chrg_pat_amt=\"+str_addl_chrg_pat_amt+\"&clinic_code=\"+clinic_code+\"&hospvisitchargeYN=\"+hospvisitchargeYN+\"&medvisitchargeYN=\"+medvisitchargeYN+\"&addlvisitchargeYN=\"+addlvisitchargeYN+\"&exempt_date=\"+encodeURIComponent(exempt_date);\n\n//\t\t\talert(\"url:\"+url);\n\t\t\t\n\t\t\tparent.frames[1].location.href=url;\n\t\t }\n\n\t\t function addl_chrg()\n\t\t {\n\n\t\t\t var episode_type=document.forms[0].episode_type.value;\n\t\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\t\tvar visit_id=document.forms[0].visit_id.value;\n\t\t\tvar episode_id=document.forms[0].episode_id.value;\n\t\t\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\t\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\n\t\t\tvar hosp_serv_panel_ind=document.forms[0].hosp_serv_panel_ind.value;\n\t\t\tvar hosp_serv_panel_code=document.forms[0].hosp_serv_panel_code.value;\n//\t\t\tvar hosp_serv_panel_str=document.forms[0].hosp_serv_panel_str.value;\n\t\t\tvar hosp_serv_panel_qty=document.forms[0].hosp_serv_panel_qty.value;\n\t\t\tvar hosp_serv_chrg_amt=document.forms[0].hosp_serv_chrg_amt.value;\n\n\t\t\tvar med_serv_panel_ind=document.forms[0].med_serv_panel_ind.value;\n\t\t\tvar med_serv_panel_code=document.forms[0].med_serv_panel_code.value;\n//\t\t\tvar med_serv_panel_str=document.forms[0].med_serv_panel_str.value;\n\t\t\tvar med_serv_panel_qty=document.forms[0].med_serv_panel_qty.value;\n\t\t\tvar med_serv_chrg_amt=document.forms[0].med_serv_chrg_amt.value;\n\n\t\t\tvar addl_serv_panel_ind=document.forms[0].addl_serv_panel_ind.value;\n\t\t\tvar addl_serv_panel_code=document.forms[0].addl_serv_panel_code.value;\n//\t\t\tvar med_serv_panel_str=document.forms[0].med_serv_panel_str.value;\n\t\t\tvar addl_serv_panel_qty=document.forms[0].addl_serv_panel_qty.value;\n\t\t\tvar addl_serv_chrg_amt=document.forms[0].addl_serv_chrg_amt.value;\n\t\t\t\n\t\t\tvar str_hosp_chrg_amt=document.forms[0].str_hosp_chrg_amt.value;\n\t\t\tvar str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\tvar str_med_chrg_amt=document.forms[0].str_med_chrg_amt.value;\n\t\t\tvar str_med_chrg_pat_amt=document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\tvar str_addl_chrg_amt=document.forms[0].str_addl_chrg_amt.value;\n\t\t\tvar str_addl_chrg_pat_amt=document.forms[0].str_addl_chrg_pat_amt.value;\n\n\t\t\tvar exempt_date = document.forms[0].exempt_date.value;\n\n\t\t\tvar clinic_code=document.forms[0].clinic_code.value;\n\n\t\t\tvar hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;\n\t\t\tvar medvisitchargeYN=document.forms[0].medvisitchargeYN.value;\n\t\t\tvar addlvisitchargeYN=document.forms[0].addlvisitchargeYN.value;\n\n/*** CRF-362 SCRUM related changes starts ****/\n\t\t\tvar charge_net_amt=document.forms[0].charge_net_amt.value;\n\t\t\tvar patientPayble=document.forms[0].patientPayble.value;\n/*** CRF-362 SCRUM related changes ends ****/\n\n\t\t\tvar url=\"../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble=\"+patientPayble+\"&charge_net_amt=\"+charge_net_amt+\"&addl_chrg=Y&call_after_reg=\"+call_after_reg+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&calling_module_id=\"+calling_module_id+\"&hosp_serv_panel_ind=\"+hosp_serv_panel_ind+\"&hosp_serv_panel_code=\"+hosp_serv_panel_code+\"&hosp_serv_panel_qty=\"+hosp_serv_panel_qty+\"&hosp_serv_chrg_amt=\"+hosp_serv_chrg_amt+\"&med_serv_panel_ind=\"+med_serv_panel_ind+\"&med_serv_panel_code=\"+med_serv_panel_code+\"&med_serv_panel_qty=\"+med_serv_panel_qty+\"&med_serv_chrg_amt=\"+med_serv_chrg_amt+\"&addl_serv_panel_ind=\"+addl_serv_panel_ind+\"&addl_serv_panel_code=\"+addl_serv_panel_code+\"&addl_serv_panel_qty=\"+addl_serv_panel_qty+\"&addl_serv_chrg_amt=\"+addl_serv_chrg_amt+\"&str_hosp_chrg_amt=\"+str_hosp_chrg_amt+\"&str_hosp_chrg_pat_amt=\"+str_hosp_chrg_pat_amt+\"&str_med_chrg_amt=\"+str_med_chrg_amt+\"&str_med_chrg_pat_amt=\"+str_med_chrg_pat_amt+\"&str_addl_chrg_amt=\"+str_addl_chrg_amt+\"&str_addl_chrg_pat_amt=\"+str_addl_chrg_pat_amt+\"&clinic_code=\"+clinic_code+\"&hospvisitchargeYN=\"+hospvisitchargeYN+\"&medvisitchargeYN=\"+medvisitchargeYN+\"&addlvisitchargeYN=\"+addlvisitchargeYN+\"&exempt_date=\"+encodeURIComponent(exempt_date);\n\n//\t\t\talert(\"url:\"+url);\n\t\t\t\n\t\t\tparent.frames[1].location.href=url;\n\t\t }\n\n\t</script>\n\n\t<title>";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\t\t\t\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t</head>\n\t<script language=\"javascript\">\n\t\n\t$(document).ready(function () {\n\t\t\n\t\tvar KDAHSite_fin_det = document.forms[0].KDAHSite_finTab.value;\n\t\tvar pract_app_yn = document.forms[0].practo_appt_yn.value;\n\t\tif(pract_app_yn == \"Y\"){\n\t\tif(KDAHSite_fin_det== \"Y\"){\t\n\t\t\tdocument.getElementById(\"continue\").click();\n\t\t\t  $(\"continue\").click();  \n\t\t}\n\t\t}\t\t\t\t\n\t\t});\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n<body onLoad=\'showvisitcharge();\' onUnload=\'\' onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\">\n<form name=\'VisitChargeDet\' id=\'VisitChargeDet\' method=\'post\' action=\'\'>\t\t\n<table cellpadding=\'10\' cellspacing=\'0\' border=\'0\' align=\'center\' width=\'100%\' height=\'100%\'>\t\n<!-- Added by muthuN for 32915 on 15-6-2012 -->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'><a href=\"#\" onClick=\"hsptl_chrg();\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a></td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'><b id=\"hospchrgamt\"></b></td>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'><b id=\"hospchrgpatamt\"></b></td>\n\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'><a href=\"#\" onClick=\"prof_chrg();\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td>\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'><b id=\"profchrgamt\"></b></td>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'><b id=\"profchrgpatamt\"></b></td>\n\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<!-- Added by muthuN for 32915 on 15-6-2012 -->\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'><a href=\"#\" onClick=\"addl_chrg();\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></td>\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'><b id=\"addlchrgamt\"></b></td>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'><b id=\"addlchrgpatamt\"></b></td>\n\t</tr>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<tr>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></td>\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'><b id=\"chrNetAmt\"></b></td>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'><b id=\"patientbedpay\"></b></td>\n\n\t</tr> \n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<tr>\n\t\n\t\t<td width=\"25%\" class=\"label\" colspan=\'4\'><b id=\"exemptdate\"></b></td>\n\n\t</tr>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<tr>\n\t\n\t\t<td width=\"25%\" class=\"label\" colspan=\'4\'><b id=\"billgen\"></b></td>\n\n\t</tr>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t<tr>\t\t \n\t\t<td width=\"25%\" class=\"label\" align=\'left\'>&nbsp;</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'>&nbsp;</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'><input type=button class=\'button\' name=\'continue\' id=\'continue\' id=\'continue\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onClick=\'return continuemodifybut(\"C\");\'></td>\n\t\t<td width=\"25%\" align=\'right\'>\n\t\t\n\t\t<input type=button class=\'button\' name=\'Revise\' id=\'Revise\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onClick=\'return continuemodifybut(\"M\");\'>\n\t\t</td>\n\t</tr>\n<!--\n\t<tr> \n\t<td width=\"25%\" class=\"label\" align=\'left\' colspan=\'4\'><B>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =":</B>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t</tr>\n-->\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<tr>\t\t \n\t\t<td width=\"25%\" class=\"label\" align=\'left\'>&nbsp;</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'left\'>&nbsp;</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'><input type=button class=\'button\' name=\'continue\' id=\'continue\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onClick=\'return continuemodifybut(\"M\");\'></td>\n\t</tr>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\n\n</table>\n\n<input type=\"hidden\" name=\"call_after_reg\" id=\"call_after_reg\"  value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"> </input>\n\n<input type=\"hidden\" name=\'hospvisitchargeYN\' id=\'hospvisitchargeYN\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\"hidden\" name=\'medvisitchargeYN\' id=\'medvisitchargeYN\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\"hidden\" name=\'addlvisitchargeYN\' id=\'addlvisitchargeYN\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\"hidden\" name=\'exempt_date\' id=\'exempt_date\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\"hidden\" name=\'bill_gen\' id=\'bill_gen\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\n<input type=\"hidden\" name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\t\n<input type=\"hidden\" name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\t\n<input type=\"hidden\" name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\t\n<input type=\"hidden\" name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=\"hidden\" name=\'calling_module_id\' id=\'calling_module_id\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\n\n<input type=\"hidden\" name=\"hosp_serv_panel_ind\" id=\"hosp_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"></input>\t\n<input type=\"hidden\" name=\"hosp_serv_panel_code\" id=\"hosp_serv_panel_code\"\t value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></input>\t\n<input type=\"hidden\" name=\"hosp_serv_panel_qty\" id=\"hosp_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"></input>\n<input type=\"hidden\" name=\"hosp_serv_chrg_amt\" id=\"hosp_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></input>\n\n<input type=\"hidden\" name=\"med_serv_panel_ind\" id=\"med_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"></input>\t\n<input type=\"hidden\" name=\"med_serv_panel_code\" id=\"med_serv_panel_code\"\t value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"></input>\t\n<input type=\"hidden\" name=\"med_serv_panel_qty\" id=\"med_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"></input>\n<input type=\"hidden\" name=\"med_serv_chrg_amt\" id=\"med_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"></input>\n\n<input type=\"hidden\" name=\"addl_serv_panel_ind\" id=\"addl_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"></input>\t\n<input type=\"hidden\" name=\"addl_serv_panel_code\" id=\"addl_serv_panel_code\"\t value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"></input>\t\n<input type=\"hidden\" name=\"addl_serv_panel_qty\" id=\"addl_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"></input>\n<input type=\"hidden\" name=\"addl_serv_chrg_amt\" id=\"addl_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"></input>\n\n<input type=\"hidden\" name=\"str_hosp_chrg_amt\" id=\"str_hosp_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"></input>\n<input type=\"hidden\" name=\"str_hosp_chrg_pat_amt\" id=\"str_hosp_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"></input>\n<input type=\"hidden\" name=\"str_med_chrg_amt\" id=\"str_med_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"></input>\n<input type=\"hidden\" name=\"str_med_chrg_pat_amt\" id=\"str_med_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"></input>\t\t \n<input type=\"hidden\" name=\"str_addl_chrg_amt\" id=\"str_addl_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"></input>\n<input type=\"hidden\" name=\"str_addl_chrg_pat_amt\" id=\"str_addl_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"></input>\t\t \n\n<input type=\"hidden\" name=\"clinic_code\" id=\"clinic_code\"\t value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"></input>\n\n<!-- CRF-362 SCRUM related changes starts -->\n<input type=\"hidden\" name=\"charge_net_amt\" id=\"charge_net_amt\"\t value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"></input>\n<input type=\"hidden\" name=\"encounterId\" id=\"encounterId\"\t value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"></input>\n<input type=\"hidden\" name=\"patientPayble\" id=\"patientPayble\"\t value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"></input>\n<input type=\"hidden\" name=\"ae_bed_calYN\" id=\"ae_bed_calYN\"\t value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"></input>\n<input type=\'hidden\' name=\'KDAHSite_finTab\' id=\'KDAHSite_finTab\' id=\'KDAHSite_finTab\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'> \n<input type=\'hidden\' name=\'practo_appt_yn\' id=\'practo_appt_yn\' id=\'practo_appt_yn\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'> \n\n<!-- CRF-362 SCRUM related changes ends -->\n\t \n</form>\n</body>\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n</html>\n\n\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

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

	Connection con				= null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 

	try{
		
	request.setCharacterEncoding("UTF-8");	
	con	=	ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);


//Unused Var's
/*
	String service_panel_code="";
	String service_panel_ind=""; 
	String service_date="";
	String serv_panel_qty="";
	String pract_staff_ind="";
	String pract_staff_id="";
	String serv_panel_str="";
	String order_catalog_code="";
*/
	//Added by muthuN for 32915 on 15-6-2012	
	String customer_id="";
	//Added by muthuN for 32915 on 15-6-2012
	String calling_module_id="";
	String call_after_reg="";

//Unused Var's
/*	double d_tot_qty=0;double d_serv_amt=0; double d_pat_payable=0;double d_min_chr_amt=0;double d_patient_paid=0;

	String str_excl_incl_ind=""; String str_preappr_yn=""; String str_error_code="";
	String str_sys_message_id=""; String str_error_text="";String str_override_yn="";
	String str_blng_serv_desc=""; String str_rate_chr_ind="";
	String hosp_panel_str="";String prof_panel_str="";
	String str_charge_based_yn="";String str_excl_incl_act="";String str_act_reason_code="";
	String str_error_level=""; double serv_qty=0;
*/
	String hosp_serv_panel_ind="";
	String hosp_serv_panel_code="";
//	String hosp_serv_panel_str="";
	String hosp_serv_panel_qty="";
	String hosp_serv_chrg_amt="";

	String med_serv_panel_ind="";
	String med_serv_panel_code="";
//	String med_serv_panel_str="";
	String med_serv_panel_qty="";
	String med_serv_chrg_amt="";

	String addl_serv_panel_ind="";
	String addl_serv_panel_code="";
//	String med_serv_panel_str="";
	String addl_serv_panel_qty="";
	String addl_serv_chrg_amt="";

	String str_hosp_chrg_amt="";
	String str_hosp_chrg_pat_amt="";
	String str_med_chrg_amt="";
	String str_med_chrg_pat_amt="";
	String str_addl_chrg_amt="";
	String str_addl_chrg_pat_amt="";

	String upd_hosp_chrg_amt="";
	String upd_hosp_chrg_pat_amt="";
	String upd_med_chrg_amt="";
	String upd_med_chrg_pat_amt="";	
	String upd_addl_chrg_amt="";
	String upd_addl_chrg_pat_amt="";

/*** CRF-362 SCRUM related changes starts ****/
	String charge_net_amt="";
	String patientPayble="";
	String encounterId="";
	String ae_bed_calYN="";
	//System.out.println("Entering into BLVisitChargeDet.jsp *** "); //muthu

	//Added by muthuN for 32915 on 15-6-2012
	
	
			Boolean KDAHSite_fin_tab=false;
			String KDAHSite_finTab ="";
			try
			{
				KDAHSite_fin_tab = eCommon.Common.CommonBean.isSiteSpecific(con, "OP","OP_AUTO_APPLY_PRACTO_APPT");	
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			if(KDAHSite_fin_tab){
				KDAHSite_finTab="Y";
			}
			else{
				KDAHSite_finTab="N";
			}
	
	try
		{		
			pstmt = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null )
			{
				customer_id  =  rs.getString(1);
 				//System.out.println("customer_id ChargeDet.jsp ==> "+customer_id);
			}
			}
			catch(Exception e)
			{   e.printStackTrace();
				System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 		
			}
//Added by muthuN for 32915 on 15-6-2012

//	String error_level="";
//	String sys_message_id="";
//	String error_text="";
	ae_bed_calYN=request.getParameter("ae_bed_calYN");
	if (ae_bed_calYN == null || ae_bed_calYN.equals("null") || ae_bed_calYN.equals("")) ae_bed_calYN = "N";

	patientPayble=request.getParameter("patientPayble");
	if (patientPayble == null || patientPayble.equals("null") || patientPayble.equals("")) patientPayble = "";

	encounterId=request.getParameter("encounterId");
	if (encounterId == null || encounterId.equals("null")) patientPayble = "";

	charge_net_amt=request.getParameter("charge_net_amt");
	if (charge_net_amt == null || charge_net_amt.equals("null") || charge_net_amt.equals("")) charge_net_amt = "";
	
//	System.err.println("charge_net_amt:"+charge_net_amt);
//	System.err.println("patientPayble:"+patientPayble);
//	System.err.println("encounterId:"+encounterId);
//	System.err.println("ae_bed_calYN:"+ae_bed_calYN);
	
	call_after_reg=request.getParameter("call_after_reg");
	if ( call_after_reg == null ) call_after_reg = "";
/*** CRF-362 SCRUM related changes ends ****/

	String exempt_date=request.getParameter("exempt_date");
	if ( exempt_date == null ) exempt_date = "";

	String hospvisitchargeYN = request.getParameter("hospvisitchargeYN");
	if ( hospvisitchargeYN == null ) hospvisitchargeYN = "N";
	

	String medvisitchargeYN = request.getParameter("medvisitchargeYN");
	if ( medvisitchargeYN == null ) medvisitchargeYN = "N";

	String addlvisitchargeYN = request.getParameter("addlvisitchargeYN");
	if ( addlvisitchargeYN == null ) addlvisitchargeYN = "N";

	String bill_gen=request.getParameter("bill_gen");
	if ( bill_gen == null ) bill_gen = "";

	String facility_id = (String)httpSession.getValue("facility_id");
	if ( facility_id == null ) facility_id = "";
	
	String episode_id=request.getParameter("episode_id");
	if ( episode_id == null || episode_id.equals("")) episode_id = "0";

	String episode_type=request.getParameter("episode_type");
	if ( episode_type == null ) episode_type = "";

	String visit_type_code=request.getParameter("visit_type_code");
	if ( visit_type_code == null ) visit_type_code = "";

	String visit_id=request.getParameter("visit_id");
	if ( visit_id == null || visit_id.equals("")) visit_id = "0";

	String patient_id=request.getParameter("patient_id");
	if ( patient_id == null ) patient_id = "";

	calling_module_id=request.getParameter("calling_module_id");
	if(calling_module_id==null) calling_module_id="";
//System.err.println("calling_module_id det :"+calling_module_id);
	String clinic_code = request.getParameter("clinic_code");
	if(clinic_code==null) clinic_code="";

	hosp_serv_panel_ind = request.getParameter("hosp_serv_panel_ind");
	if(hosp_serv_panel_ind==null) hosp_serv_panel_ind="";

	hosp_serv_panel_code = request.getParameter("hosp_serv_panel_code");
	if(hosp_serv_panel_code==null) hosp_serv_panel_code="";

	hosp_serv_panel_qty = request.getParameter("hosp_serv_panel_qty");
	if(hosp_serv_panel_qty==null) hosp_serv_panel_qty="";

	hosp_serv_chrg_amt = request.getParameter("hosp_serv_chrg_amt");
	if(hosp_serv_chrg_amt==null) hosp_serv_chrg_amt="";

	med_serv_panel_ind = request.getParameter("med_serv_panel_ind");
	if(med_serv_panel_ind==null) med_serv_panel_ind="";

	med_serv_panel_code = request.getParameter("med_serv_panel_code");
	if(med_serv_panel_code==null) med_serv_panel_code="";

	med_serv_panel_qty = request.getParameter("med_serv_panel_qty");
	if(med_serv_panel_qty==null) med_serv_panel_qty="";

	med_serv_chrg_amt = request.getParameter("med_serv_chrg_amt");
	if(med_serv_chrg_amt==null) med_serv_chrg_amt="";

	addl_serv_panel_ind = request.getParameter("addl_serv_panel_ind");
	if(addl_serv_panel_ind==null) addl_serv_panel_ind="";

	addl_serv_panel_code = request.getParameter("addl_serv_panel_code");
	if(addl_serv_panel_code==null) addl_serv_panel_code="";

	addl_serv_panel_qty = request.getParameter("addl_serv_panel_qty");
	if(addl_serv_panel_qty==null) addl_serv_panel_qty="";

	addl_serv_chrg_amt = request.getParameter("addl_serv_chrg_amt");
	if(addl_serv_chrg_amt==null) addl_serv_chrg_amt="";

	str_hosp_chrg_amt = request.getParameter("str_hosp_chrg_amt");
	if(str_hosp_chrg_amt==null) str_hosp_chrg_amt="";

	str_hosp_chrg_pat_amt = request.getParameter("str_hosp_chrg_pat_amt");
	if(str_hosp_chrg_pat_amt==null) str_hosp_chrg_pat_amt="";

	str_med_chrg_amt = request.getParameter("str_med_chrg_amt");
	if(str_med_chrg_amt==null) str_med_chrg_amt="";

	str_med_chrg_pat_amt = request.getParameter("str_med_chrg_pat_amt");
	if(str_med_chrg_pat_amt==null) str_med_chrg_pat_amt="";

	str_addl_chrg_amt = request.getParameter("str_addl_chrg_amt");
	if(str_addl_chrg_amt==null) str_addl_chrg_amt="";

	str_addl_chrg_pat_amt = request.getParameter("str_addl_chrg_pat_amt");
	if(str_addl_chrg_pat_amt==null) str_addl_chrg_pat_amt="";

	upd_hosp_chrg_amt=request.getParameter("upd_hosp_chrg_amt");
	if(upd_hosp_chrg_amt==null) upd_hosp_chrg_amt="";

	if(!upd_hosp_chrg_amt.equals(""))
	{
		str_hosp_chrg_amt=upd_hosp_chrg_amt;
	}

	upd_hosp_chrg_pat_amt=request.getParameter("upd_hosp_chrg_pat_amt");
	if(upd_hosp_chrg_pat_amt==null) upd_hosp_chrg_pat_amt="";
	
	if(!upd_hosp_chrg_pat_amt.equals(""))
	{
		str_hosp_chrg_pat_amt=upd_hosp_chrg_pat_amt;
	}

	upd_med_chrg_amt=request.getParameter("upd_med_chrg_amt");
	if(upd_med_chrg_amt==null) upd_med_chrg_amt="";
	
	if(!upd_med_chrg_amt.equals(""))
	{
		str_med_chrg_amt=upd_med_chrg_amt;
	}

	upd_med_chrg_pat_amt=request.getParameter("upd_med_chrg_pat_amt");
	if(upd_med_chrg_pat_amt==null) upd_med_chrg_pat_amt="";
	
	if(!upd_med_chrg_pat_amt.equals(""))
	{
		str_med_chrg_pat_amt=upd_med_chrg_pat_amt;
	}

	upd_addl_chrg_amt=request.getParameter("upd_addl_chrg_amt");
	if(upd_addl_chrg_amt==null) upd_addl_chrg_amt="";
	
	if(!upd_addl_chrg_amt.equals(""))
	{
		str_addl_chrg_amt=upd_addl_chrg_amt;
	}

	upd_addl_chrg_pat_amt=request.getParameter("upd_addl_chrg_pat_amt");
	if(upd_addl_chrg_pat_amt==null) upd_addl_chrg_pat_amt="";
		
	if(!upd_addl_chrg_pat_amt.equals(""))
	{
		str_addl_chrg_pat_amt=upd_addl_chrg_pat_amt;
	}

	String practo_appt_yn=request.getParameter("practo_appt_yn");
	if(practo_appt_yn==null) practo_appt_yn="N";
	
	

            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

if(customer_id.equals("MOHBR")){	
	if(hospvisitchargeYN.equals("Y"))
	{

            _bw.write(_wl_block10Bytes, _wl_block10);

		if(calling_module_id.equals("MP"))
		{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		else
		{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		}

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	if(medvisitchargeYN.equals("Y"))
	{

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	}

}else {

            _bw.write(_wl_block18Bytes, _wl_block18);
 
	if(hospvisitchargeYN.equals("Y"))
	{

            _bw.write(_wl_block10Bytes, _wl_block10);

		if(calling_module_id.equals("MP"))
		{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		else
		{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		}

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	if(medvisitchargeYN.equals("Y"))
	{

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	}
}
	if(addlvisitchargeYN.equals("Y"))
	{

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			/*
		CRF -362 Displaying the Bill Charges
		this pract_type_ind variable used if user calling from current emergency patient and called visit charges details.we restrict the charges.
		*/
	}

/*** CRF-362 SCRUM related changes starts ****/
	if(!charge_net_amt.equals("") && ae_bed_calYN.equals("Y"))
	{

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

	}
/*** CRF-362 SCRUM related changes ends ****/

	if(!exempt_date.equals(""))
	{

            _bw.write(_wl_block25Bytes, _wl_block25);

	}
	else if(!bill_gen.equals(""))
	{

            _bw.write(_wl_block26Bytes, _wl_block26);

	}

            _bw.write(_wl_block27Bytes, _wl_block27);

	if(call_after_reg.equals("Y"))
	{

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

	}
	else
	{

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);

	}

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(call_after_reg));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(hospvisitchargeYN));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(medvisitchargeYN));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(addlvisitchargeYN));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(exempt_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bill_gen));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(hosp_serv_panel_ind));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(hosp_serv_panel_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(hosp_serv_panel_qty));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(hosp_serv_chrg_amt));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(med_serv_panel_ind));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(med_serv_panel_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(med_serv_panel_qty));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(med_serv_chrg_amt));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(addl_serv_panel_ind));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(addl_serv_panel_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(addl_serv_panel_qty));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(addl_serv_chrg_amt));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(str_hosp_chrg_amt));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(str_hosp_chrg_pat_amt));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(str_med_chrg_amt));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(str_med_chrg_pat_amt));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(str_addl_chrg_amt));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(str_addl_chrg_pat_amt));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(charge_net_amt));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(patientPayble));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(ae_bed_calYN));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(KDAHSite_finTab));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(practo_appt_yn));
            _bw.write(_wl_block72Bytes, _wl_block72);

	}
	catch(Exception e)
	{
		System.out.println("Main Exception:"+e);
	}
	finally
	{ 
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block73Bytes, _wl_block73);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VISIT_CHARGE_DTL.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAT_REG_CHRG.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RegistrationFee.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ConsultationFee.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAT_REG_CHRG.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HOSP_CHRG.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PROF_CHRG.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADDL_CHARGE.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedCharge.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.note.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAT_PAY_SIM_MES_1.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAT_PAY_SIM_MES_2.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
