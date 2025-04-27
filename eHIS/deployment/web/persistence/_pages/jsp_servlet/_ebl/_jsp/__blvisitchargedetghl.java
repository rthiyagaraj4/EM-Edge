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

public final class __blvisitchargedetghl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLVisitChargeDetGHL.jsp", 1744006288308L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6_0 ="\n\n<html>\n\t<head>\n\t<script language=\'javascript\'>\n\t\tfunction showvisitcharge()\n\t\t{\t\t\n\t\t\tvar hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;\n\t\t\tvar medvisitchargeYN=document.forms[0].medvisitchargeYN.value;\n\t\t\tvar addlvisitchargeYN = document.forms[0].addlvisitchargeYN.value;\n\t\t\tvar exempt_date=document.forms[0].exempt_date.value;\n\t\t\tvar bill_gen=document.forms[0].bill_gen.value;\n\n\t\t\tvar charge_net_amt=document.forms[0].charge_net_amt.value;\n\t\t\tvar patientPayble=document.forms[0].patientPayble.value;\n\t\t\tvar ae_bed_calYN=document.forms[0].ae_bed_calYN.value;\n\n\t\t\tif(hospvisitchargeYN == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"hospchrgamt\").innerText=document.forms[0].str_hosp_chrg_amt.value;\n\t\t\t\tdocument.getElementById(\"hospchrgpatamt\").innerText=document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\t}\n\t\t\tif(medvisitchargeYN == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"profchrgamt\").innerText=document.forms[0].str_med_chrg_amt.value;\n\t\t\t\tdocument.getElementById(\"profchrgpatamt\").innerText=document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\t}\n\t\t\tif(addlvisitchargeYN == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"addlchrgamt\").innerText=document.forms[0].str_addl_chrg_amt.value;\n\t\t\t\tdocument.getElementById(\"addlchrgpatamt\").innerText=document.forms[0].str_addl_chrg_pat_amt.value;\n\t\t\t}\n\t\t\t\n\t\t\tif(charge_net_amt != \"\" && ae_bed_calYN == \"Y\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"chrNetAmt\").innerText=charge_net_amt;\n\t\t\t\tdocument.getElementById(\"patientbedpay\").innerText=patientPayble;\n\t\t\t}\n\n\t\t\tif(exempt_date!=\"\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"exemptdate\").innerText=document.forms[0].exempt_date.value;\n\t\t\t}\n\t\t\telse if(bill_gen!=\"\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"billgen\").innerText=document.forms[0].bill_gen.value;\n\t\t\t}\n\t\t\t\n\t\t\tvar strOrderCtlgDtls = document.forms[0].strOrderCtlgDtls.value;\n\t\t\tvar strOrderCtlgTotal = document.forms[0].strOrderCtlgTotal.value;\n\t\t\tif(strOrderCtlgDtls != \"\") {\n\t\t\t\tvar strOrderCtlgDtlsSplit = strOrderCtlgDtls.split(\"|\");\n\t\t\t\tfor(var i = 0; i < strOrderCtlgDtlsSplit.length; i++) {\n\t\t\t\t\tvar orderCtlgDtlsSplit = strOrderCtlgDtlsSplit[i].split(\"~\");\n\t\t\t\t\tdocument.getElementById(orderCtlgDtlsSplit[0]+\"_net\").innerText = orderCtlgDtlsSplit[1];\n\t\t\t\t\tdocument.getElementById(orderCtlgDtlsSplit[0]+\"_pat\").innerText = orderCtlgDtlsSplit[3];\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tvar totalNetAmt = 0, totalPatAmt = 0;\n\t\t\t\n\t\t\tif(strOrderCtlgTotal != \"\") {\n\t\t\t\tvar strOrderCtlgTotalSplit = strOrderCtlgTotal.split(\"~\");\n\t\t\t\ttotalNetAmt = strOrderCtlgTotalSplit[0];\n\t\t\t\ttotalPatAmt = strOrderCtlgTotalSplit[2];\n\t\t\t\t\n\t\t\t\tif(hospvisitchargeYN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tif(isNaN(document.forms[0].str_hosp_chrg_amt.value) != false || isNaN(document.forms[0].str_hosp_chrg_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalNetAmt = +totalNetAmt + +document.forms[0].str_hosp_chrg_amt.value;\n\t\t\t\t\t}\n\t\t\t\t\tif(isNaN(document.forms[0].str_hosp_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_hosp_chrg_pat_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalPatAmt = +totalPatAmt + +document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(medvisitchargeYN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tif(isNaN(document.forms[0].str_med_chrg_amt.value) != false || isNaN(document.forms[0].str_med_chrg_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalNetAmt = +totalNetAmt + +document.forms[0].str_med_chrg_amt.value;\n\t\t\t\t\t}\n\t\t\t\t\tif(isNaN(document.forms[0].str_med_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_med_chrg_pat_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalPatAmt = +totalPatAmt + +document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(addlvisitchargeYN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tif(isNaN(document.forms[0].str_addl_chrg_amt.value) != false || isNaN(document.forms[0].str_addl_chrg_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalNetAmt = +totalNetAmt + +document.forms[0].str_addl_chrg_amt.value;\n\t\t\t\t\t}\n\t\t\t\t\tif(isNaN(document.forms[0].str_addl_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_addl_chrg_pat_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalPatAmt = +totalPatAmt + +document.forms[0].str_addl_chrg_pat_amt.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t} else {\n\t\t\t\tif(hospvisitchargeYN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tif(isNaN(document.forms[0].str_hosp_chrg_amt.value) != false || isNaN(document.forms[0].str_hosp_chrg_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalNetAmt = +totalNetAmt + +document.forms[0].str_hosp_chrg_amt.value;\n\t\t\t\t\t}\n\t\t\t\t\tif(isNaN(document.forms[0].str_hosp_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_hosp_chrg_pat_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalPatAmt = +totalPatAmt + +document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(medvisitchargeYN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tif(isNaN(document.forms[0].str_med_chrg_amt.value) != false || isNaN(document.forms[0].str_med_chrg_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalNetAmt = +totalNetAmt + +document.forms[0].str_med_chrg_amt.value;\n\t\t\t\t\t}\n\t\t\t\t\tif(isNaN(document.forms[0].str_med_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_med_chrg_pat_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalPatAmt = +totalPatAmt + +document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(addlvisitchargeYN == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tif(isNaN(document.forms[0].str_addl_chrg_amt.value) != false || isNaN(document.forms[0].str_addl_chrg_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalNetAmt = +totalNetAmt + +document.forms[0].str_addl_chrg_amt.value;\n\t\t\t\t\t}\n\t\t\t\t\tif(isNaN(document.forms[0].str_addl_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_addl_chrg_pat_amt.value) != \"false\") {\n\t\t\t\t\t\ttotalPatAmt = +totalPatAmt + +document.forms[0].str_addl_chrg_pat_amt.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tdocument.getElementById(\"total_net\").innerText = totalNetAmt;\n\t\t\tdocument.getElementById(\"total_pat\").innerText = totalPatAmt;\n\t\t }\n\n\t\t function continuemodifybut(Obj)\n\t\t {\n\t\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\n\t\t\tif (Obj == \"C\")\n\t\t\t {\n\t\t\t\tif(call_after_reg==\"Y\")\n\t\t\t\t{\n\t\t\t\t\twindow.returnValue=1;\n\t\t\t\t\tdocument.forms[0].action=\"../../servlet/eBL.BLFinancialDetailsCloseConsultServlet\";\n\t\t\t\t\tdocument.forms[0].submit();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\twindow.returnValue=1;\n\t\t\t\t\twindow.close();\t\t\t\n\t\t\t\t}\n\t\t\t }\n\t\t\telse\n\t\t\t {\t\n\t\t\t\n\t\t\t\twindow.returnValue=2;\n\t\t\t\twindow.close();\t\t\t\n\t\t\t}\n\n\t\t }\n\n\t\t function hsptl_chrg()\n\t\t {\n\t\t\tvar episode_type=document.forms[0].episode_type.value;\n\t\t\tvar patient_id = document.forms[0].patient_id.value;\t\t\t\n\t\t\tvar visit_id=document.forms[0].visit_id.value;\n\t\t\tvar episode_id=document.forms[0].episode_id.value;\n\t\t\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\t\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\n\t\t\tvar hosp_serv_panel_ind=document.forms[0].hosp_serv_panel_ind.value;\n\t\t\tvar hosp_serv_panel_code=document.forms[0].hosp_serv_panel_code.value;\n\t\t\tvar hosp_serv_panel_qty=document.forms[0].hosp_serv_panel_qty.value;\n\t\t\tvar hosp_serv_chrg_amt=document.forms[0].hosp_serv_chrg_amt.value;\n\n\t\t\tvar med_serv_panel_ind=document.forms[0].med_serv_panel_ind.value;\n\t\t\tvar med_serv_panel_code=document.forms[0].med_serv_panel_code.value;\n\t\t\tvar med_serv_panel_qty=document.forms[0].med_serv_panel_qty.value;\n\t\t\tvar med_serv_chrg_amt=document.forms[0].med_serv_chrg_amt.value;\n\n\t\t\tvar addl_serv_panel_ind=document.forms[0].addl_serv_panel_ind.value;\n\t\t\tvar addl_serv_panel_code=document.forms[0].addl_serv_panel_code.value;\n\t\t\tvar addl_serv_panel_qty=document.forms[0].addl_serv_panel_qty.value;\n\t\t\tvar addl_serv_chrg_amt=document.forms[0].addl_serv_chrg_amt.value;\n\n\t\t\tvar str_hosp_chrg_amt=document.forms[0].str_hosp_chrg_amt.value;\n\t\t\tvar str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\tvar str_med_chrg_amt=document.forms[0].str_med_chrg_amt.value;\n\t\t\tvar str_med_chrg_pat_amt=document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\tvar str_addl_chrg_amt=document.forms[0].str_addl_chrg_amt.value;\n\t\t\tvar str_addl_chrg_pat_amt=document.forms[0].str_addl_chrg_pat_amt.value;\n\n\t\t\tvar hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;\n\t\t\tvar medvisitchargeYN=document.forms[0].medvisitchargeYN.value;\n\t\t\tvar addlvisitchargeYN=document.forms[0].addlvisitchargeYN.value;\n\n\t\t\tvar exempt_date = document.forms[0].exempt_date.value;\n\n\t\t\tvar clinic_code=document.forms[0].clinic_code.value;\n\t\t\tvar charge_net_amt=document.forms[0].charge_net_amt.value;\n\t\t\tvar patientPayble=document.forms[0].patientPayble.value;\n\t\t\t var url=\"../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble=\"+patientPayble+\"&charge_net_amt=\"+charge_net_amt+\"&hsptl_chrg=Y&call_after_reg=\"+call_after_reg+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&calling_module_id=\"+calling_module_id+\"&hosp_serv_panel_ind=\"+hosp_serv_panel_ind+\"&hosp_serv_panel_code=\"+hosp_serv_panel_code+\"&hosp_serv_panel_qty=\"+hosp_serv_panel_qty+\"&hosp_serv_chrg_amt=\"+hosp_serv_chrg_amt+\"&med_serv_panel_ind=\"+med_serv_panel_ind+\"&med_serv_panel_code=\"+med_serv_panel_code+\"&med_serv_panel_qty=\"+med_serv_panel_qty+\"&med_serv_chrg_amt=\"+med_serv_chrg_amt+\"&addl_serv_panel_ind=\"+addl_serv_panel_ind+\"&addl_serv_panel_code=\"+addl_serv_panel_code+\"&addl_serv_panel_qty=\"+addl_serv_panel_qty+\"&addl_serv_chrg_amt=\"+addl_serv_chrg_amt+\"&str_hosp_chrg_amt=\"+str_hosp_chrg_amt+\"&str_hosp_chrg_pat_amt=\"+str_hosp_chrg_pat_amt+\"&str_med_chrg_amt=\"+str_med_chrg_amt+\"&str_med_chrg_pat_amt=\"+str_med_chrg_pat_amt+\"&str_addl_chrg_amt=\"+str_addl_chrg_amt+\"&str_addl_chrg_pat_amt=\"+str_addl_chrg_pat_amt+\"&clinic_code=\"+clinic_code+\"&hospvisitchargeYN=\"+hospvisitchargeYN+\"&medvisitchargeYN=\"+medvisitchargeYN+\"&addlvisitchargeYN=\"+addlvisitchargeYN+\"&exempt_date=\"+encodeURIComponent(exempt_date);\n\n\t\t\t\n\t\t\tparent.frames[1].location.href=url;\n\t\t\n\t\t}\n\n\t\t function prof_chrg()\n\t\t {\n\n\t\t\t var episode_type=document.forms[0].episode_type.value;\n\t\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\t\tvar visit_id=document.forms[0].visit_id.value;\n\t\t\tvar episode_id=document.forms[0].episode_id.value;\n\t\t\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\t\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\n\t\t\tvar hosp_serv_panel_ind=document.forms[0].hosp_serv_panel_ind.value;\n\t\t\tvar hosp_serv_panel_code=document.forms[0].hosp_serv_panel_code.value;\n//\t\t\tvar hosp_serv_panel_str=document.forms[0].hosp_serv_panel_str.value;\n\t\t\tvar hosp_serv_panel_qty=document.forms[0].hosp_serv_panel_qty.value;\n\t\t\tvar hosp_serv_chrg_amt=document.forms[0].hosp_serv_chrg_amt.value;\n\n\t\t\tvar med_serv_panel_ind=document.forms[0].med_serv_panel_ind.value;\n\t\t\tvar med_serv_panel_code=document.forms[0].med_serv_panel_code.value;\n//\t\t\tvar med_serv_panel_str=document.forms[0].med_serv_panel_str.value;\n\t\t\tvar med_serv_panel_qty=document.forms[0].med_serv_panel_qty.value;\n\t\t\tvar med_serv_chrg_amt=document.forms[0].med_serv_chrg_amt.value;\n\n\t\t\tvar addl_serv_panel_ind=document.forms[0].addl_serv_panel_i";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="nd.value;\n\t\t\tvar addl_serv_panel_code=document.forms[0].addl_serv_panel_code.value;\n//\t\t\tvar med_serv_panel_str=document.forms[0].med_serv_panel_str.value;\n\t\t\tvar addl_serv_panel_qty=document.forms[0].addl_serv_panel_qty.value;\n\t\t\tvar addl_serv_chrg_amt=document.forms[0].addl_serv_chrg_amt.value;\n\t\t\t\n\t\t\tvar str_hosp_chrg_amt=document.forms[0].str_hosp_chrg_amt.value;\n\t\t\tvar str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\tvar str_med_chrg_amt=document.forms[0].str_med_chrg_amt.value;\n\t\t\tvar str_med_chrg_pat_amt=document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\tvar str_addl_chrg_amt=document.forms[0].str_addl_chrg_amt.value;\n\t\t\tvar str_addl_chrg_pat_amt=document.forms[0].str_addl_chrg_pat_amt.value;\n\n\t\t\tvar exempt_date = document.forms[0].exempt_date.value;\n\n\t\t\tvar clinic_code=document.forms[0].clinic_code.value;\n\n\t\t\tvar hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;\n\t\t\tvar medvisitchargeYN=document.forms[0].medvisitchargeYN.value;\n\t\t\tvar addlvisitchargeYN=document.forms[0].addlvisitchargeYN.value;\n\n/*** CRF-362 SCRUM related changes starts ****/\n\t\t\tvar charge_net_amt=document.forms[0].charge_net_amt.value;\n\t\t\tvar patientPayble=document.forms[0].patientPayble.value;\n/*** CRF-362 SCRUM related changes ends ****/\n\n\t\t\tvar url=\"../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble=\"+patientPayble+\"&charge_net_amt=\"+charge_net_amt+\"&prof_chrg=Y&call_after_reg=\"+call_after_reg+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&calling_module_id=\"+calling_module_id+\"&hosp_serv_panel_ind=\"+hosp_serv_panel_ind+\"&hosp_serv_panel_code=\"+hosp_serv_panel_code+\"&hosp_serv_panel_qty=\"+hosp_serv_panel_qty+\"&hosp_serv_chrg_amt=\"+hosp_serv_chrg_amt+\"&med_serv_panel_ind=\"+med_serv_panel_ind+\"&med_serv_panel_code=\"+med_serv_panel_code+\"&med_serv_panel_qty=\"+med_serv_panel_qty+\"&med_serv_chrg_amt=\"+med_serv_chrg_amt+\"&addl_serv_panel_ind=\"+addl_serv_panel_ind+\"&addl_serv_panel_code=\"+addl_serv_panel_code+\"&addl_serv_panel_qty=\"+addl_serv_panel_qty+\"&addl_serv_chrg_amt=\"+addl_serv_chrg_amt+\"&str_hosp_chrg_amt=\"+str_hosp_chrg_amt+\"&str_hosp_chrg_pat_amt=\"+str_hosp_chrg_pat_amt+\"&str_med_chrg_amt=\"+str_med_chrg_amt+\"&str_med_chrg_pat_amt=\"+str_med_chrg_pat_amt+\"&str_addl_chrg_amt=\"+str_addl_chrg_amt+\"&str_addl_chrg_pat_amt=\"+str_addl_chrg_pat_amt+\"&clinic_code=\"+clinic_code+\"&hospvisitchargeYN=\"+hospvisitchargeYN+\"&medvisitchargeYN=\"+medvisitchargeYN+\"&addlvisitchargeYN=\"+addlvisitchargeYN+\"&exempt_date=\"+encodeURIComponent(exempt_date);\n\n\t\t\tparent.frames[1].location.href=url;\n\t\t }\n\n\t\t function addl_chrg()\n\t\t {\n\n\t\t\t var episode_type=document.forms[0].episode_type.value;\n\t\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\t\tvar visit_id=document.forms[0].visit_id.value;\n\t\t\tvar episode_id=document.forms[0].episode_id.value;\n\t\t\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\t\t\tvar call_after_reg=document.forms[0].call_after_reg.value;\n\n\t\t\tvar hosp_serv_panel_ind=document.forms[0].hosp_serv_panel_ind.value;\n\t\t\tvar hosp_serv_panel_code=document.forms[0].hosp_serv_panel_code.value;\n//\t\t\tvar hosp_serv_panel_str=document.forms[0].hosp_serv_panel_str.value;\n\t\t\tvar hosp_serv_panel_qty=document.forms[0].hosp_serv_panel_qty.value;\n\t\t\tvar hosp_serv_chrg_amt=document.forms[0].hosp_serv_chrg_amt.value;\n\n\t\t\tvar med_serv_panel_ind=document.forms[0].med_serv_panel_ind.value;\n\t\t\tvar med_serv_panel_code=document.forms[0].med_serv_panel_code.value;\n//\t\t\tvar med_serv_panel_str=document.forms[0].med_serv_panel_str.value;\n\t\t\tvar med_serv_panel_qty=document.forms[0].med_serv_panel_qty.value;\n\t\t\tvar med_serv_chrg_amt=document.forms[0].med_serv_chrg_amt.value;\n\n\t\t\tvar addl_serv_panel_ind=document.forms[0].addl_serv_panel_ind.value;\n\t\t\tvar addl_serv_panel_code=document.forms[0].addl_serv_panel_code.value;\n//\t\t\tvar med_serv_panel_str=document.forms[0].med_serv_panel_str.value;\n\t\t\tvar addl_serv_panel_qty=document.forms[0].addl_serv_panel_qty.value;\n\t\t\tvar addl_serv_chrg_amt=document.forms[0].addl_serv_chrg_amt.value;\n\t\t\t\n\t\t\tvar str_hosp_chrg_amt=document.forms[0].str_hosp_chrg_amt.value;\n\t\t\tvar str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;\n\t\t\tvar str_med_chrg_amt=document.forms[0].str_med_chrg_amt.value;\n\t\t\tvar str_med_chrg_pat_amt=document.forms[0].str_med_chrg_pat_amt.value;\n\t\t\tvar str_addl_chrg_amt=document.forms[0].str_addl_chrg_amt.value;\n\t\t\tvar str_addl_chrg_pat_amt=document.forms[0].str_addl_chrg_pat_amt.value;\n\n\t\t\tvar exempt_date = document.forms[0].exempt_date.value;\n\n\t\t\tvar clinic_code=document.forms[0].clinic_code.value;\n\n\t\t\tvar hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;\n\t\t\tvar medvisitchargeYN=document.forms[0].medvisitchargeYN.value;\n\t\t\tvar addlvisitchargeYN=document.forms[0].addlvisitchargeYN.value;\n\n/*** CRF-362 SCRUM related changes starts ****/\n\t\t\tvar charge_net_amt=document.forms[0].charge_net_amt.value;\n\t\t\tvar patientPayble=document.forms[0].patientPayble.value;\n/*** CRF-362 SCRUM related changes ends ****/\n\n\t\t\tvar url=\"../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble=\"+patientPayble+\"&charge_net_amt=\"+charge_net_amt+\"&addl_chrg=Y&call_after_reg=\"+call_after_reg+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&calling_module_id=\"+calling_module_id+\"&hosp_serv_panel_ind=\"+hosp_serv_panel_ind+\"&hosp_serv_panel_code=\"+hosp_serv_panel_code+\"&hosp_serv_panel_qty=\"+hosp_serv_panel_qty+\"&hosp_serv_chrg_amt=\"+hosp_serv_chrg_amt+\"&med_serv_panel_ind=\"+med_serv_panel_ind+\"&med_serv_panel_code=\"+med_serv_panel_code+\"&med_serv_panel_qty=\"+med_serv_panel_qty+\"&med_serv_chrg_amt=\"+med_serv_chrg_amt+\"&addl_serv_panel_ind=\"+addl_serv_panel_ind+\"&addl_serv_panel_code=\"+addl_serv_panel_code+\"&addl_serv_panel_qty=\"+addl_serv_panel_qty+\"&addl_serv_chrg_amt=\"+addl_serv_chrg_amt+\"&str_hosp_chrg_amt=\"+str_hosp_chrg_amt+\"&str_hosp_chrg_pat_amt=\"+str_hosp_chrg_pat_amt+\"&str_med_chrg_amt=\"+str_med_chrg_amt+\"&str_med_chrg_pat_amt=\"+str_med_chrg_pat_amt+\"&str_addl_chrg_amt=\"+str_addl_chrg_amt+\"&str_addl_chrg_pat_amt=\"+str_addl_chrg_pat_amt+\"&clinic_code=\"+clinic_code+\"&hospvisitchargeYN=\"+hospvisitchargeYN+\"&medvisitchargeYN=\"+medvisitchargeYN+\"&addlvisitchargeYN=\"+addlvisitchargeYN+\"&exempt_date=\"+encodeURIComponent(exempt_date);\n\n\t\t\tparent.frames[1].location.href=url;\n\t\t }\n\n\t</script>\n\n\t<title>";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\t\t\t\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n<body onLoad=\'showvisitcharge();\' onUnload=\'\' onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\">\n<form name=\'VisitChargeDet\' id=\'VisitChargeDet\' method=\'post\' action=\'\'>\t\t\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'1\' align=\'center\' width=\'100%\' height=\'100%\'>\t\n<!-- Added by muthuN for 32915 on 15-6-2012 -->\n<tr>\n\t<td class = \'COLUMNHEADER\'  width=\"25%\" nowrap>Code</td>\n\t<td class = \'COLUMNHEADER\'  width=\"25%\" nowrap>Description</td>\n\t<td class = \'COLUMNHEADER\'  width=\"25%\" nowrap>Net Amount</td>\n\t<td class = \'COLUMNHEADER\'  width=\"25%\" nowrap>Patient Net Payable</td>\n</tr>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\n\t\t<td width=\"25%\" align = \'left\'>&nbsp;</td>\n\t\t<td width=\"25%\" align = \'center\' class=\"label\" style=\'text-align: center;\'><a href=\"#\" onClick=\"hsptl_chrg();\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</a></td>\n\t\t<td width=\"25%\" align = \'right\' class=\"label\" style=\'text-align: right;\'><div id=\"hospchrgamt\"></div></td>\n\t\t<td width=\"25%\" align = \'right\' class=\"label\" style=\'text-align: right;\'><div id=\"hospchrgpatamt\"></div></td>\n\t</tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<tr>\n\t\t<td width=\"25%\" align=\'left\'>&nbsp;</td>\n\t\t<td width=\"25%\" align=\'center\' class=\"label\" style=\'text-align: center;\'><a href=\"#\" onClick=\"prof_chrg();\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><div id=\"profchrgamt\"></div></td>\n\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><div id=\"profchrgpatamt\"></div></td>\n\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<tr>\n\t\t<td width=\"25%\" align=\'left\'>&nbsp;</td>\n\t\t<td width=\"25%\" align=\'center\' class=\"label\" style=\'text-align: center;\'><a href=\"#\" onClick=\"addl_chrg();\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a></td>\n\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><div id=\"addlchrgamt\"></div></td>\n\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><div id=\"addlchrgpatamt\"></div></td>\n\t</tr>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<tr>\n\t\t<td width=\"25%\" align=\'left\'>&nbsp;</td>\n\t\t<td width=\"25%\" align=\'center\' class=\"label\" style=\'text-align: center;\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a></td>\n\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><div id=\"chrNetAmt\"></div></td>\n\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><div id=\"patientbedpay\"></div></td>\n\n\t</tr> \n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\"25%\" align=\'center\' class=\"label\" style=\'text-align: center;\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td width=\"25%\" align=\'center\' nowrap class=\"label\" style=\'text-align: center;\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><div id=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="_net\">&nbsp;</div></td>\n\t\t\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><div id=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="_pat\">&nbsp;</div></td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<tr>\n\t\t<td width=\"25%\" align=\'center\'>&nbsp;</td>\n\t\t<td width=\"25%\" align=\'right\' nowrap class=\"label\" style=\'text-align: right;\'><b>Grant Total</b></td>\n\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><b id=\"total_net\">&nbsp;</b></td>\n\t\t<td width=\"25%\" align=\'right\' class=\"label\" style=\'text-align: right;\'><b id=\"total_pat\">&nbsp;</b></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<tr>\n\t\n\t\t<td width=\"25%\" class=\"label\" colspan=\'4\'><b id=\"exemptdate\"></b></td>\n\n\t</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<tr>\n\t\n\t\t<td width=\"25%\" class=\"label\" colspan=\'4\'><b id=\"billgen\"></b></td>\n\n\t</tr>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\n\t<tr>\t\t \n\t\t<!-- <td width=\"25%\" align=\'left\'>&nbsp;</td> -->\n\t\t<td width=\"25%\" class=\"label\" align=\'left\' colspan = \'2\'>&nbsp;</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'>\n\t\t\t<input type=button class=\'button\' name=\'continue\' id=\'continue\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" \n\t\t\t\tonClick=\'return continuemodifybut(\"C\");\'>\n\t\t</td>\n\t\t<td width=\"25%\" align=\'right\'>\n\t\t\t<input type=button class=\'button\' name=\'Revise\' id=\'Revise\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" \n\t\t\tonClick=\'return continuemodifybut(\"M\");\'>\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<tr>\t\t \n\t\t<!-- <td width=\"25%\" align=\'left\'>&nbsp;</td> -->\n\t\t<td width=\"25%\" class=\"label\" align=\'left\' colspan = \'2\'>&nbsp;</td>\n\t\t<td width=\"25%\" class=\"label\" align=\'right\'>\n\t\t\t<input type=button class=\'button\' name=\'continue\' id=\'continue\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" \n\t\t\t\tonClick=\'return continuemodifybut(\"M\");\'>\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\n\n</table>\n\n<input type=\"hidden\" name=\"call_after_reg\" id=\"call_after_reg\"  value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"> </input>\n\n<input type=\"hidden\" name=\'hospvisitchargeYN\' id=\'hospvisitchargeYN\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\"hidden\" name=\'medvisitchargeYN\' id=\'medvisitchargeYN\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\"hidden\" name=\'addlvisitchargeYN\' id=\'addlvisitchargeYN\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\"hidden\" name=\'exempt_date\' id=\'exempt_date\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\"hidden\" name=\'bill_gen\' id=\'bill_gen\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\n<input type=\"hidden\" name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\t\n<input type=\"hidden\" name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\t\n<input type=\"hidden\" name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\t\n<input type=\"hidden\" name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\"hidden\" name=\'calling_module_id\' id=\'calling_module_id\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\n\n<input type=\"hidden\" name=\"hosp_serv_panel_ind\" id=\"hosp_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"></input>\t\n<input type=\"hidden\" name=\"hosp_serv_panel_code\" id=\"hosp_serv_panel_code\"\t value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"></input>\t\n<input type=\"hidden\" name=\"hosp_serv_panel_qty\" id=\"hosp_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"></input>\n<input type=\"hidden\" name=\"hosp_serv_chrg_amt\" id=\"hosp_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"></input>\n\n<input type=\"hidden\" name=\"med_serv_panel_ind\" id=\"med_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"></input>\t\n<input type=\"hidden\" name=\"med_serv_panel_code\" id=\"med_serv_panel_code\"\t value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></input>\t\n<input type=\"hidden\" name=\"med_serv_panel_qty\" id=\"med_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"></input>\n<input type=\"hidden\" name=\"med_serv_chrg_amt\" id=\"med_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></input>\n\n<input type=\"hidden\" name=\"addl_serv_panel_ind\" id=\"addl_serv_panel_ind\"\t value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"></input>\t\n<input type=\"hidden\" name=\"addl_serv_panel_code\" id=\"addl_serv_panel_code\"\t value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"></input>\t\n<input type=\"hidden\" name=\"addl_serv_panel_qty\" id=\"addl_serv_panel_qty\"\t value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"></input>\n<input type=\"hidden\" name=\"addl_serv_chrg_amt\" id=\"addl_serv_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"></input>\n\n<input type=\"hidden\" name=\"str_hosp_chrg_amt\" id=\"str_hosp_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"></input>\n<input type=\"hidden\" name=\"str_hosp_chrg_pat_amt\" id=\"str_hosp_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"></input>\n<input type=\"hidden\" name=\"str_med_chrg_amt\" id=\"str_med_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"></input>\n<input type=\"hidden\" name=\"str_med_chrg_pat_amt\" id=\"str_med_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"></input>\t\t \n<input type=\"hidden\" name=\"str_addl_chrg_amt\" id=\"str_addl_chrg_amt\"\t value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"></input>\n<input type=\"hidden\" name=\"str_addl_chrg_pat_amt\" id=\"str_addl_chrg_pat_amt\"\t value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"></input>\t\t \n\n<input type=\"hidden\" name=\"clinic_code\" id=\"clinic_code\"\t value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"></input>\n\n<!-- CRF-362 SCRUM related changes starts -->\n<input type=\"hidden\" name=\"charge_net_amt\" id=\"charge_net_amt\"\t value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"></input>\n<input type=\"hidden\" name=\"encounterId\" id=\"encounterId\"\t value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"></input>\n<input type=\"hidden\" name=\"patientPayble\" id=\"patientPayble\"\t value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"></input>\n<input type=\"hidden\" name=\"ae_bed_calYN\" id=\"ae_bed_calYN\"\t value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"></input>\n<!-- CRF-362 SCRUM related changes ends -->\n\n<input type=\"hidden\" name=\"strOrderCtlgDtls\" id=\"strOrderCtlgDtls\"\t value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"></input><!-- Added V190403-Aravindh/GHL-CRF-0525 -->\n<input type=\"hidden\" name=\"strOrderCtlgTotal\" id=\"strOrderCtlgTotal\"\t value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"></input><!-- Added V190403-Aravindh/GHL-CRF-0525 -->\n\t \n</form>\n</body>\n\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

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


	String customer_id="";
	String calling_module_id="";
	String call_after_reg="";

	String hosp_serv_panel_ind="";
	String hosp_serv_panel_code="";
	String hosp_serv_panel_qty="";
	String hosp_serv_chrg_amt="";

	String med_serv_panel_ind="";
	String med_serv_panel_code="";
	String med_serv_panel_qty="";
	String med_serv_chrg_amt="";

	String addl_serv_panel_ind="";
	String addl_serv_panel_code="";
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

	String charge_net_amt="";
	String patientPayble="";
	String encounterId="";
	String ae_bed_calYN="";
	
	String orderCatalogCodeStr = "", orderCtlgDtls = "", orderCtlgTotal = "";//Added V190403-Aravindh/GHL-CRF-0525

	ae_bed_calYN=request.getParameter("ae_bed_calYN");
	if (ae_bed_calYN == null || ae_bed_calYN.equals("null") || ae_bed_calYN.equals("")) ae_bed_calYN = "N";

	patientPayble=request.getParameter("patientPayble");
	if (patientPayble == null || patientPayble.equals("null") || patientPayble.equals("")) patientPayble = "";

	encounterId=request.getParameter("encounterId");
	if (encounterId == null || encounterId.equals("null")) patientPayble = "";

	charge_net_amt=request.getParameter("charge_net_amt");
	if (charge_net_amt == null || charge_net_amt.equals("null") || charge_net_amt.equals("")) charge_net_amt = "";
	
	
	call_after_reg=request.getParameter("call_after_reg");
	if ( call_after_reg == null ) call_after_reg = "";

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
	
	orderCatalogCodeStr = request.getParameter("orderCatalogCode");//Added V190403-Aravindh/GHL-CRF-0525
	if (orderCatalogCodeStr == null) orderCatalogCodeStr="";//Added V190403-Aravindh/GHL-CRF-0525
	
	orderCtlgDtls = request.getParameter("strOrderCtlgDtls");//Added V190403-Aravindh/GHL-CRF-0525
	if (orderCtlgDtls == null) orderCtlgDtls="";//Added V190403-Aravindh/GHL-CRF-0525
	
	orderCtlgTotal = request.getParameter("strOrderCtlgTotal");//Added V190403-Aravindh/GHL-CRF-0525
	if (orderCtlgTotal == null) orderCtlgTotal="";//Added V190403-Aravindh/GHL-CRF-0525


            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
 
	if(hospvisitchargeYN.equals("Y"))
	{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	if(medvisitchargeYN.equals("Y"))
	{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	
	if(addlvisitchargeYN.equals("Y"))
	{

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			/*
		CRF -362 Displaying the Bill Charges
		this pract_type_ind variable used if user calling from current emergency patient and called visit charges details.we restrict the charges.
		*/
	}

/*** CRF-362 SCRUM related changes starts ****/
	if(!charge_net_amt.equals("") && ae_bed_calYN.equals("Y"))
	{

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	}
/*** CRF-362 SCRUM related changes ends ****/

	/* Added for GHL-CRF-0525/Starts */
	//orderCatalogCodeStr = "~~TEAF000009~~CDCD000005~~CDCD000004~~";
	orderCatalogCodeStr = orderCatalogCodeStr.replace("~~", "~");
	System.out.println("BLVisitCharge->orderCatalogCodeStr: "+orderCatalogCodeStr);
	if(null != orderCatalogCodeStr && !"".equals(orderCatalogCodeStr)) {
		String[] orderCatalogCodeList = orderCatalogCodeStr.split("\\~");
		
		for(int i = 0; i < orderCatalogCodeList.length; i++) {
			pstmt = con.prepareStatement("SELECT SHORT_DESC FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = ?");
			pstmt.setString(1, orderCatalogCodeList[i]);
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null )
			{
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(orderCatalogCodeList[i] ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString("SHORT_DESC") ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(orderCatalogCodeList[i]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(orderCatalogCodeList[i]));
            _bw.write(_wl_block22Bytes, _wl_block22);
	
			}
		}
	}
	
            _bw.write(_wl_block23Bytes, _wl_block23);

	/* Added for GHL-CRF-0525/Ends */

	if(!exempt_date.equals(""))
	{

            _bw.write(_wl_block24Bytes, _wl_block24);

	}
	else if(!bill_gen.equals(""))
	{

            _bw.write(_wl_block25Bytes, _wl_block25);

	}

            _bw.write(_wl_block26Bytes, _wl_block26);

	if(call_after_reg.equals("Y"))
	{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);

	}
	else
	{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")));
            _bw.write(_wl_block31Bytes, _wl_block31);

	}

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(call_after_reg));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(hospvisitchargeYN));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(medvisitchargeYN));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(addlvisitchargeYN));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(exempt_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bill_gen));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(hosp_serv_panel_ind));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(hosp_serv_panel_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(hosp_serv_panel_qty));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(hosp_serv_chrg_amt));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(med_serv_panel_ind));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(med_serv_panel_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(med_serv_panel_qty));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(med_serv_chrg_amt));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(addl_serv_panel_ind));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(addl_serv_panel_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(addl_serv_panel_qty));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(addl_serv_chrg_amt));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(str_hosp_chrg_amt));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(str_hosp_chrg_pat_amt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(str_med_chrg_amt));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(str_med_chrg_pat_amt));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(str_addl_chrg_amt));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(str_addl_chrg_pat_amt));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(charge_net_amt));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(patientPayble));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(ae_bed_calYN));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(orderCtlgDtls));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(orderCtlgTotal));
            _bw.write(_wl_block68Bytes, _wl_block68);

	}
	catch(Exception e)
	{
		System.out.println("Main Exception:"+e);
	}
	finally
	{ 
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block69Bytes, _wl_block69);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.HOSP_CHRG.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PROF_CHRG.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADDL_CHARGE.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedCharge.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
