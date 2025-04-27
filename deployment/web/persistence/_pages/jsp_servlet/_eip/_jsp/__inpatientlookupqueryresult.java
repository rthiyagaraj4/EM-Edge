package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __inpatientlookupqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/InpatientLookupQueryResult.jsp", 1745311940288L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/ForSplChars.jsp", 1709116911640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t<Script src=\"../../eIP/js/IPLookup.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<STYLE>\ntable th\n{\ntext-align: left;\n}\n\n</STYLE>\n\t<script>\n\t\n\t  \n\t\tvar oder_list = new Array();\n           index=0;\n\t\t\n\t\tfunction hideToolTip()\n\t\t{\n\t\t\tdocument.getElementById(\"tooltiplayer\").style.visibility\t= \'hidden\';\n\t\t}\n\n\t\tfunction displayToolTip(cancel_date, cancelled_by, cancelled_reason)\n\t\t{\n\t\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' align=\'right\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' >\";\n\t\t\ttab_dat += \"<tr class=\'TRNEW\'><td class = \'TDLABEL\' nowrap align= \'right\'>\"+document.forms[0].CancelledReason.value+\" : </td><td class = \'TDDATA\' nowrap>\"+cancelled_reason+\"</td></tr>\";\n\t\t\ttab_dat += \"<tr class=\'TRNEW\'><td class = \'TDLABEL\' nowrap align= \'right\'>\"+document.forms[0].CancelledBy.value+\" : </td><td class = \'TDDATA\' nowrap>\"+cancelled_by+\"</td></tr>\";\n\t\t\ttab_dat += \"<tr class=\'TRNEW\'><td class = \'TDLABEL\' nowrap align= \'right\'>\"+document.forms[0].CancelledDate.value+\" : </td><td class = \'TDDATA\' nowrap>\"+cancel_date+\"</td></tr>\";\n\t\t\ttab_dat += \"</table>\";\n\t\t\t\t\t\t\t\n\t\t\tvar bodwidth=0;\n\t\t\tvar bodheight=0;\n\n\t\t\tbodwidth = parent.frames[0].document.body.offsetWidth;\n\t\t\tbodheight = parent.frames[0].document.body.offsetHeight;\n\t\t\tvar y =event.y;\n\n\t\t\ty = y + (document.getElementById(\"tooltiplayer\").offsetHeight);\n\t\t\t\t\n\t\t\tif(y<bodheight)\n\t\t\t\ty =event.y;\n\t\t\telse if(event.y>bodheight)\n\t\t\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight*2);\n\t\t\telse\n\t\t\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight);\n\n\t\t\ty+=document.body.scrollTop;\n\t\t\tif(bodwidth > 800)\n\t\t\t\tdocument.getElementById(\"tooltiplayer\").style.posRight = -275;\n\t\t\telse\n\t\t\t\tdocument.getElementById(\"tooltiplayer\").style.posRight =-525;\n\n\t\t\tdocument.getElementById(\"column\").innerHTML = tab_dat;\n\t\t\tdocument.getElementById(\"tooltiplayer\").style.posTop = y;\n\t\t\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\';\n\t\t}\n\t\t\n\t\tfunction runReport(enc, patid)\n\t\t{\n\t\t\tvar facility_id = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\tvar Disc_Chk ;\n\t\t\tif(parent.frames[1].document.forms[0].Disc_Chk)\n\t\t\t\tDisc_Chk = parent.frames[1].document.forms[0].Disc_Chk.value;\n\t\t\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'report_form\' id=\'report_form\' action=\'../../eCommon/jsp/report_options.jsp\'><input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+facility_id+\"\'><input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'IPDLYACK\'> <input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'IP\'> <input type=\'hidden\' name=\'p_moth_pat_id\' id=\'p_moth_pat_id\' value=\'\"+patid+\"\'><input type=\'hidden\' name=\'p_moth_enc_id\' id=\'p_moth_enc_id\' value=\'\"+enc+\"\'><input type=\'hidden\' name=\'p_discharge_yn\' id=\'p_discharge_yn\' value=\'\"+Disc_Chk+\"\'></form></body></html>\";\n\t\t\tparent.frames[3].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tparent.frames[3].document.report_form.submit();\n\t\t}\n\t\t//Pls note.. This function is not moved to IPLookup.js as many Java variables are directly used in this function...\n\t\t\n\n\t\tasync function showModal( enc, patid, practid,IPval, sex, bed_no, patientclass, colorCode, status_value, tfr_req_status, leave_exp_dt_flag,pat_dtls_unknown_yn,contact1_name,contact2_name,cutt_of_time,finalize_yn,discharge_date_time,m_death_yn,indicator,req_no,perm_fs_locn,result_count,fac_id,pre_dis_initiate_yn,ward_return,blood_consump_status,pend_sal_ret_fin_stats,isAllowDischargeDisAdv) \n\t\t{\t\n\t\t\n\t\t\t\n\t\t    var function_id\t\t=\tdocument.forms[0].function_id.value;\n\t\t\tvar oper_stn_id\t\t=\t\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\tvar dialogHeight\t= \"90vh\";\n\t\t\tvar dialogWidth\t\t= \"90vw\";\n\t\t\tvar dialogTop\t\t= \"0\";\n\t\t\t/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] Start*/\n\t\t\tvar weight_on_admn_mandatory\t= \"\";\n\t\t\tif(document.forms[0].weight_on_admn_mandatory!=null)\n\t\t\t\tweight_on_admn_mandatory\t= document.forms[0].weight_on_admn_mandatory.value;\n\t\t\t/*Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541] End*/\n\t\t\t\n\t\t\t/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527*/\n\t\t\tvar height_on_admn_mandatory\t= \"\";\n\t\t\tif(document.forms[0].height_on_admn_mandatory!=null)\n\t\t\t\theight_on_admn_mandatory\t= document.forms[0].height_on_admn_mandatory.value;\n\t\t\t\n\t\t\tvar enable_height_bmi_pat_cls\t= \"\";\n\t\t\tif(document.forms[0].enable_height_bmi_pat_cls!=null)\n\t\t\t\tenable_height_bmi_pat_cls\t= document.forms[0].enable_height_bmi_pat_cls.value;\n\t\t\t\n\t\t\t/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527* END/\n\t\t\t\n\t\t\t\n\t\t\t/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/\n\t\t\tvar call_function = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\tvar trans_yn_unfnzed_newborn\t= document.forms[0].trans_yn_unfnzed_newborn.value;\n\t\t\tvar isNewBornChngsAppl\t= document.forms[0].isNewBornChngsAppl.value;\n\t\t\tif((call_function == \"TransferPatientOut\" || call_function ==\"TransferPatient\" || call_function == \"RequestforTransfer\" || call_function ==\"TransferPatientIn\" || call_function ==\"EMERGENCY_TRANSFER\" || call_function == \"ConfirmBedClass\") && sex == \"Female\" && trans_yn_unfnzed_newborn ==\"Y\" && isNewBornChngsAppl == \"true\"){\n\t\t\t\tvar unFinalizedNewBornCnt\t= eval(\"document.forms[0].unFinalizedNewBornCnt_\"+enc).value;\n\t\t\t\tif(unFinalizedNewBornCnt > 0){\n\t\t\t\t\talert(getMessage(\'UNFINALIZED_NEW_BORN_EXISTS\',\"IP\"));\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t}\n\t\t\t/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/\n\n\t\t\t\n\n\t\t\t\t\t\n\t\t\tif(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" == \"TransferPatientIn\"){\n\t\t\t\tdialogHeight\t= \"700px\";\n\t\t\t}\n\t\t\tif(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" == \"TransferPatient\" || \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" == \"RequestforTransfer\" || \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" == \'EMERGENCY_TRANSFER\')\n\t\t\t{\n\t\t\t\tvar call_function=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"\n\t\t\t\tif(tfr_req_status != \"\")\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'ONLY_ONE_REQ_BKG\',\"IP\"));\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t//10/16/2008 5089_MF-CRF-0017 enhancement start\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" == \"TransferPatient\"|| \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" == \"RequestforTransfer\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(bed_no==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].jsp_name.value=\'AssignBedMain.jsp\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t//10/16/2008 5089_MF-CRF-0017 enhancement start\n\t\t\tif(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" ==\'TransferPatientOut\'||\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ==\'PrepareDischargeAdvice\' || \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" == \'EMERGENCY_TRANSFER\')\n\t\t\t{ \n\t\t\t\t// Added for the CRF -KDAH-CRF-0104  by Dharma Start\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" ==\'PrepareDischargeAdvice\'){\n\t\t\t\t\tvar pre_disch_appl_yn\t= document.forms[0].pre_disch_appl_yn.value;\n\t\t\t\t\tif(pre_disch_appl_yn==\'Y\' && pre_dis_initiate_yn==\'N\' ){\n\t\t\t\t\t\talert(getMessage(\"PREDISCHARGE_NOT_INITIATED\",\"IP\"));\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t\t/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/\n\t\t\t\t\tvar chk_pen_sale_rtn_bfr_dis_adv = document.forms[0].chk_pen_sale_rtn_bfr_dis_adv.value;\n\t\t\t\t\tvar isRestrictDisAdvSaleRetPend\t = document.forms[0].isRestrictDisAdvSaleRetPend.value;\n\t\t\t\t\tif(chk_pen_sale_rtn_bfr_dis_adv == \'Y\' && pend_sal_ret_fin_stats ==\"N\" && isRestrictDisAdvSaleRetPend==\"true\"){\n\t\t\t\t\t\talert(getMessage(\"SALE_RET_PENDING_CNT_PROCEED\",\"IP\"));\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t\t/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End*/\n\t\t\t\t\tif(isAllowDischargeDisAdv == \'N\'){\n\t\t\t\t\t\talert(getMessage(\"OT_REC_PENDING_CNT_PROCEED\",\"IP\"));\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t\t// Added for the CRF -KDAH-CRF-0104  by Dharma End\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tif(bed_no==\"\")\n\t\t\t\t{\n\t\t\t\t\tvar retVal\t= \tnew String();\n\t\t\t\t\tdocument.forms[0].jsp_name.value=\'AssignBedMain.jsp\';\n\t\t\t\t}\n\t\t\t}\n\t//10/16/2008 5089_MF-CRF-0017 enhancement end\n\n\t\t\tvar chk_jsp\t\t\t= document.forms[0].jsp_name.value;\n\t\t\t\n\t\t\tvar tot_count\t\t= document.forms[0].total_count.value;\n\t\t\tvar instl_yn\t\t= document.forms[0].bl_install.value;\n\t\t\tvar patient_class=\'\';\t\n\t\t\tif(patientclass != null)\n\t\t\t\tpatient_class\t= patientclass;\n\t\t\tvar function_name\t= document.forms[0].function_name.value;\n\t\t\tvar condition\t\t= \"\";\t\n\t\t\tif (document.forms[0].targetURL.value != \"\")\n\t\t\t{\n\t\t\t\tvar temp\t\t= \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'+\"&Patient_ID=\"+patid+\"&nursing_unit_code=\"+IPval+\"&bed_no=\"+bed_no+\"&";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" \n\t\t\t\tdocument.forms[0].targetURL.value = document.forms[0].targetURL.value+ \"&Patient_ID=\"+patid+\"&nursing_unit_code=\"+IPval+\"&bed_no=\"+bed_no+\"&";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" ;\n\t\t\t\tdocument.forms[0].jsp_name.value = \'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\';\n\t\t\t\tawait checkExpiry(patid,\'\',\'retback\', \'NEWBORN_REG\',\'\',temp,IPval,bed_no);\n\t\t\t}\n\t\t\telse if((chk_jsp==\"CancelDischargeAdviceMain.jsp\") && (instl_yn==\"Y\"))\n\t\t\t{\t\n\t\t\t\t\n\t\t\t\tif(finalize_yn == \"Y\") {\n\t\t\t\t\talert(getMessage(\"MDR_FINALIZED_DISCH_CANT_CANCEL\",\"MR\"));\n\t\t\t\t}else{\n\t\t\t\n\t\t\t\t\tvar HTMLVal = new String();\n\t\t\t\t\n\t\t\t\t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/FindCancelDischargeAdvice.jsp?IP_val=\"+IPval+\"&enable_height_bmi_pat_cls=\"+enable_height_bmi_pat_cls+\"&encounter_Id=\"+enc+\"&patient_Id=\"+patid+\"&Practitioner_Id=\"+practid+\"&callfrom=IP&call_function=CancelDischargeAdviceMain.jsp&jsp_name=\"+chk_jsp+\"&Sex=\"+sex+\"&p_service_type=\"+\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"+\"&mode=modal&function_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'></form></BODY></HTML>\";\n\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\tparent.messageFrame.document.form1.submit();\t\t\t\n\t\t\t\t }\n\t\t\t}\n\t\t\telse if(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" == \"CANCEL_DISCHARGE_PATIENT\")\n\t\t\t{\n\t\t\t\tdialogHeight\t= \"56\";\n\t\t\t\tdialogTop\t\t= \"10\";\n\t\t\t\tvar HTMLVal\t\t= new String();\n\t\t\t\t//Added enable_height_bmi_pat_cls for ML-MMOH-SCF-1643 by Kamatchi S\n\t\t\t\tHTMLVal\t\t\t= \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/FindPatientDischarge.jsp?IP_val=\"+IPval+\"&encounter_Id=\"+enc+\"&enable_height_bmi_pat_cls=\"+enable_height_bmi_pat_cls+\"&patient_Id=\"+patid+\"&Practitioner_Id=\"+practid+\"&callfrom=IP&call_function=CANCEL_DISCHARGE_PATIENT&jsp_name=\"+chk_jsp+\"&Sex=\"+sex+\"&p_service_type=\"+\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"+\"&bl_install_yn=\"+instl_yn+\"&mode=modal&function_id=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&mo_install_yn=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'></form></BODY></HTML>\";\n\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t}\n\t\t\telse if((chk_jsp==\"PaintDischargePatient.jsp\"))\n\t\t\t{\t\t\t\t\n                 \n\t\t\t\tif(isAllowDischargeDisAdv == \'N\'){\n\t\t\t\t\talert(getMessage(\"OT_REC_PENDING_CNT_PROCEED\",\"IP\"));\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tvar HTMLVal\t\t= new String();\n\t\t\t\t//JD006\t\t\t \n\t\t\t\tvar pen_orders_chk=document.forms[0].chc_for_pen_orders_bfr_dischrg.value;\n\t\t\t\tvar allow_yn=document.forms[0].dischrg_allow_yn.value;\t\n\t\t\t\t// changes start fo KDAh 41 and JD006\n\t\t\t\tvar p_facility_id=fac_id;\n\t\t\t\tvar p_patient_id= patid;\n\t\t\t\tvar p_enc_id=enc;\n\t\t\t\tvar dialogHeight\t= \"90vh\";\n\t\t\t\tvar dialogWidth\t\t= \"90vw\";\n\t\t\t\tvar dialogTop = \"0vh\" ;\n\t\t\t\t//var dialogWidth\t= \"1300px\" ;\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status  + \"; dialogTop :\" + dialogTop ;\n\t\t\t\tvar url=\"../../eOR/jsp/ViewPendingOrders.jsp?patient_id=\"+p_patient_id+\"&encounter_id=\"+p_enc_id+\"&facility_id=\"+p_facility_id+\"&discharge_ind=D\";\n\t\t\t\t\n\t\t\t\tvar proc_flg=\"N\";\n\t\t\t\t\n\t\t\t\tif(pen_orders_chk==\'Y\'){\n\t\t\t\t\t\n\t\t\t\t\tif(result_count>0){\n\t\t\t\t\t\tif(allow_yn==\"Y\"){ \n\t\t\t\t\t\t\t//if(window.confirm(\"Order(s) Pending. Do you wish to view and continue ?\")){\t\t\t\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\tvar retVal = new String();\n\t\t\t\t\t\t\t\tretVal = await top.window.showModalDialog(url,arguments,features);\n\t\t\t\t\t\t\t\tif(window.confirm(getMessage(\"PROCEED_DISCHARGE\",\"IP\")))\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tproc_flg=\"Y\";\n\t\t\t\t\t\t\t\t}\n\n\n\t\t\t\t\t\t\t//}\n\n\t\t\t\t\t\t}else{\n\n\t\t\t\t\t\t\tif(window.confirm(getMessage(\"ORDER_PENDING_CNT_PROCEED_VIEW\",\"IP\")))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar retVal = new String();\n\t\t\t\t\t\t\t\tretVal = await top.window.showModalDialog(url,arguments,features);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t}else{\n\t\t\t\t\t\tproc_flg=\"Y\";\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\t\n\t\t\t\t\tproc_flg=\"Y\";\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\t//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135\n\t\t\t\tvar BT_flag=\"\";\n\t\t\t\tvar chk_dis_pat_bt_order_pend=document.forms[0].chk_dis_pat_bt_order_pend.value;\n\t\t\t\tvar isDisPatBTorderPendAppl=document.forms[0].isDisPatBTorderPendAppl.value;\n\t\t\t\tif(isDisPatBTorderPendAppl==\"true\" && chk_dis_pat_bt_order_pend==\'Y\'){\n\t\t\t\t\tif(blood_consump_status==\"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BLD_UNIT_CONSP_CNT_PROCEED\",\"IP\"));\n\t\t\t\t\t\tBT_flag=\"N\";\n\t\t\t\t\t}else \n\t\t\t\t\t\tBT_flag=\"Y\";\n\t\t\t\t}\n\t\t\t\t//End\n\t\t\t\tif(proc_flg==\"N\" || BT_flag==\"N\")\n\t\t\t\t\tproc_flg=\"N\";\n\t\t\t\telse\n\t\t\t\t\tproc_flg=\"Y\";\n\t\t\t\t\n\t\t\t\tif(proc_flg==\"Y\"){\n\t\t\t\t\n\t\t\t\t\tvar HTMLVal\t\t= new String();\n\t\t\t\t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/FindPatientDischarge.jsp?weight_on_admn_mandatory=\"+weight_on_admn_mandatory+\"&height_on_admn_mandatory=\"+height_on_admn_mandatory+\"&enable_height_bmi_pat_cls=\"+enable_height_bmi_pat_cls+\"&IP_val=\"+IPval+\"&encounter_Id=\"+enc+\"&patient_Id=\"+patid+\"&Practitioner_Id=\"+practid+\"&callfrom=IP&call_function=PaintDischargePatient.jsp&jsp_name=\"+chk_jsp+\"&Sex=\"+sex+\"&p_service_type=\"+\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&discharge_checklist_app_yn=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&bed_block_period_dis=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&dis_date_chk_days=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&dis_date_chk_days_unit=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&diag_update_period_max_unit=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&max_disch_period_for_predc=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&deactivate_pseudo_bed_yn=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&allow_late_discharge_reason=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&disch_reason_mand_yn=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'></form></BODY></HTML>\";\t\n\t\t\t\t\t//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527\n\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t}\n\t\t\t\t// changes end fo KDAh 41 and JD006\n\n\t\t\t\t\n\t\t\t}\n\t\t\telse if((chk_jsp==\"DischargeAdviceMain.jsp\") && (instl_yn==\"Y\")){\t\t\t\t\n\t\t\t\t\n\t\t\t\tvar HTMLVal\t\t= new String();\n\t\t\t\t\t\t \n\t\t\t\tvar pen_orders_chk=document.forms[0].chc_for_pen_orders_bfr_dis_adv.value;\n\t\t\t\tvar allow_yn=document.forms[0].dis_adv_allow_yn.value;\t\n\t\t\t\t// changes start fo KDAh 41 and JD006\n\t\t\t\tvar p_facility_id=fac_id;\n\t\t\t\tvar p_patient_id= patid;\n\t\t\t\tvar p_enc_id=enc;\n\t\t\t\tvar dialogHeight= \"90vh\" ;\n\t\t\t\tvar dialogTop = \"0vh\" ;\n\t\t\t\tvar dialogWidth\t= \"95vw\" ;\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status  + \"; dialogTop :\" + dialogTop ;\n\t\t\t\tvar url=\"../../eOR/jsp/ViewPendingOrders.jsp?patient_id=\"+p_patient_id+\"&encounter_id=\"+p_enc_id+\"&facility_id=\"+p_facility_id+\"&discharge_ind=A\";\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tvar proc_flg=\"N\";\n\n\t\t\t\t//Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2\n\t\t\t\tvar alert_ward_return = \"\";\n\t\t\t\tvar check_flag = \"N\";\n\t\t\t\tvar chk_ward_return = document.forms[0].restriction_for_wardReturn.value; \n\t\t\t\tif(chk_ward_return == \"Y\")\n\t\t\t\t{\n                  \n\t\t\t\t\t\tif(ward_return==\"W\"){ \n                            alert_ward_return = \"Y\";\n\t\t\t\t\t   }\n\t\t\t\t}\n\n\t\t\t\tif(pen_orders_chk==\'Y\'){\n\t\t\t\t\t\n\t\t\t\t\tif(result_count>0){\n                        //Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2\n\t\t\t\t\t\tcheck_flag = \"Y\";\n\t\t\t\t\t\tif(allow_yn==\"Y\"){ \n\t\t\t\t\t\t\t//if(window.confirm(\"Order(s) Pending. Do you wish to view and continue ?\")){\t\n\t\t\t\t\t\t\t\tif(alert_ward_return == \"Y\"){\n\t\t\t\t\t\t\t\t\talert(getMessage(\'WARD_RETURN\',\'IP\'));\t\n\t\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tvar retVal = new String();\n\t\t\t\t\t\t\t\t\tretVal = await top.window.showModalDialog(url,arguments,features);\n\t\t\t\t\t\t\t\t\tif(window.confirm(getMessage(\"PROCEED_DISCHARGE_ADVICE\",\"IP\")))\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tproc_flg=\"Y\";\n\t\t\t\t\t\t\t\t\t}    \n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t//}\n\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t//Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2\n\t\t\t\t\t\t\tif(alert_ward_return == \"Y\"){\n\t\t\t\t\t\t\t\talert(getMessage(\'WARD_RETURN\',\'IP\'));\n\t\t\t\t\t\t\tif(window.confirm(getMessage(\"ORDER_PENDING_CNT_PROCEED_VIEW\",\"IP\")))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar retVal = new String();\n\t\t\t\t\t\t\t\tretVal = await top.window.showModalDialog(url,arguments,features);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tif(window.confirm(getMessage(\"ORDER_PENDING_CNT_PROCEED_VIEW\",\"IP\")))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar retVal = new String();\n\t\t\t\t\t\t\t\tretVal = await top.window.showModalDialog(url,arguments,features);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t}else{\n\t\t\t\t\t\tproc_flg=\"Y\";\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\t\n\t\t\t\t\tproc_flg=\"Y\"\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\t//Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2\n                if(alert_ward_return == \"Y\" && check_flag == \"N\"){ \n\t\t\t\t\t\t\talert(getMessage(\'WARD_RETURN\',\'IP\'));\t\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t   }\n\n\t\t\t\tif(proc_flg==\"Y\"){\n\t\t\t\t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/FindPrepareDischarge.jsp?weight_on_admn_mandatory=\"+weight_on_admn_mandatory+\"&height_on_admn_mandatory=\"+height_on_admn_mandatory+\"&enable_height_bmi_pat_cls=\"+enable_height_bmi_pat_cls+\"&IP_val=\"+IPval+\"&encounter_Id=\"+enc+\"&patient_Id=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=DischargeAdviceMain.jsp&jsp_name=\"+chk_jsp+\"&Sex=\"+sex+\"&p_service_type=\"+\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"+\"&patient_class=\"+patientclass+\"&leave_exp_dt_flag=\"+leave_exp_dt_flag+\"&mode=modal&setup_bl_dtls_in_ip_yn=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&allow_discharge_date=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&max_disch_period_for_dc=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&function_id=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&allow_discharge_date_predc=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&mother_cut_off_age_pda=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&mother_max_age_pda=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&pat_dtls_unknown_yn_pda=\"+pat_dtls_unknown_yn+\"&contact1_name_pda=\"+contact1_name+\"&contact2_name_pda=\"+contact2_name+\"\'></form></BODY></HTML>\";//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527\n\n\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t}\n\t\t\t\t// changes end fo KDAh 41 and JD006\n\t\t\t\t//Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041\t\n\t\t\t\t/*var listno=1;\n\t\t\t\tvar confirm;\n\t\t\t\tvar orders=\"\";\n\t\t\n\t\t\t errmsge2=getMessage(\"ORDERS_PENDING_WISH_TO_CONTINUE\",\"IP\")\n\t\t\t\t\n\t\t\t\tif(result_count > 0 && pen_orders_chk ==\"Y\"){\n\t\t\t\t\tif(allow_yn == \"Y\" && result_count >1 ){\n\t\t\t\t\t\n\t\t\t\t\tfor(i=0;i<oder_list.length;i++)\n\t\t\n\t\t               {\n\t\t             orders=orders+\"\\n \"+listno+\".  \"+oder_list[i];\n\t\t              listno++;\n\t\t              }\n\t\t\t\t\t//sam1=errmsge2.replace(\"$\",orders);\n\t\t\t\t\t \n\t\t\t\t\t //confirm=window.confirm(errmsge2.replace(\"$\",orders))\n\t\t\t\t\t confirm=window.confirm(\"Pending orders exist. Click Ok to view and coninue\" )\n\t\t\t\t\t\t//var confirm=window.confirm(getMessage(\"LAB_ORDERS_PENDING_WISH_TO_CONTINUE\",\"IP\"));\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(confirm==true ){\n\t\t\t\t\t\t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/FindPrepareDischarge.jsp?weight_on_admn_mandatory=\"+weight_on_admn_mandatory+\"&IP_val=\"+IPval+\"&encounter_Id=\"+enc+\"&patient_Id=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=DischargeAdviceMain.jsp&jsp_name=\"+chk_jsp+\"&Sex=\"+sex+\"&p_service_type=\"+\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&pat_dtls_unknown_yn_pda=\"+pat_dtls_unknown_yn+\"&contact1_name_pda=\"+contact1_name+\"&contact2_name_pda=\"+contact2_name+\"\'></form></BODY></HTML>\";\n\n\t\t\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t\t\t}\n\t\t\t\t\t}if(allow_yn==\'Y\' && result_count<=1)\n\t\t\t\t\t{\n\t\t\t\t\tvar error=getMessage(\"ORDER_PENDING_WISH_TO_CONTINUE\",\"IP\");\n\t\t\t\t\tvar sam2=error.replace(\"$\",oder_list[0])\n\t\t\t\t   confirm=window.confirm(sam2.replace(\"undefined\",\"\"))\n\t\t\t\t\tif(confirm==true ){\n\t\t\t\t\t\t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/FindPrepareDischarge.jsp?weight_on_admn_mandatory=\"+weight_on_admn_mandatory+\"&IP_val=\"+IPval+\"&encounter_Id=\"+enc+\"&patient_Id=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=DischargeAdviceMain.jsp&jsp_name=\"+chk_jsp+\"&Sex=\"+sex+\"&p_service_type=\"+\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&pat_dtls_unknown_yn_pda=\"+pat_dtls_unknown_yn+\"&contact1_name_pda=\"+contact1_name+\"&contact2_name_pda=\"+contact2_name+\"\'></form></BODY></HTML>\";\n\n\t\t\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(allow_yn ==\"N\" &&  result_count >1)\n\t\t\t\t\t{\n\t\t\t\t\tvar error3=getMessage(\"ORDERS_PENDING_NOT_PROCEED_FURTHER\",\"IP\");\n\t\t\t\t\t\t\n\t\t\t\t\t\tfor(i=0;i<oder_list.length;i++)\n\t\t\n\t\t             {\n\t\t           orders=orders+\"\\n \"+listno+\".  \"+oder_list[i];\n\t\t              listno++;\n\t\t               }\n\t\t\t\t\t   var sam3=error3.replace(\"$\",orders)\n\t\t\t\t\talert (sam3.replace(\"undefined\",\"\"))\t\n\t\t\t\t\t\t//alert(getMessage(\"LAB_ORDERS_PENDING_NOT_PROCEED_FURTHER\",\"IP\"));\t\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\tif (allow_yn ==\"N\" &&  result_count <=1)\n\t\t\t\t\t{\n\t\t\t\t\tvar error4=getMessage(\"ORDER_PENDING_NOT_PROCEED_FURTHER\",\"IP\")\n\t\t\t\t\tvar sam4=error4.replace(\"$\",oder_list[0])\n\t\t\t\t\talert (sam4.replace(\"undefined\",\"\"))\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/FindPrepareDischarge.jsp?weight_on_admn_mandatory=\"+weight_on_admn_mandatory+\"&IP_val=\"+IPval+\"&encounter_Id=\"+enc+\"&patient_Id=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=DischargeAdviceMain.jsp&jsp_name=\"+chk_jsp+\"&Sex=\"+sex+\"&p_service_type=\"+\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&pat_dtls_unknown_yn_pda=\"+pat_dtls_unknown_yn+\"&contact1_name_pda=\"+contact1_name+\"&contact2_name_pda=\"+contact2_name+\"\'></form></BODY></HTML>\";\n\n\t\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t\t}\n\t\t\t\t\t*/\n\t\t\t\t// venkatesh KDAH-CRF-0041 END\t\t\t\n\t\t\t}\n\t\t\telse if((chk_jsp==\"CancelAdmissionMain.jsp\") && (instl_yn==\"Y\"))\n\t\t\t{ \n\t\t\t\tvar HTMLVal\t\t= new String();\n\t\t\t\tpat_check_in_allowed_yn = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\t\tvar allowCancelAdmsn = document.forms[0].allowCancelAdm.value;//Added by Thamizh selvi on 22nd Feb 2017 against MMS-QH-CRF-0182\n\n\n\t\t\t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eBL/jsp/CancelIPAdmit.jsp?IP_val=\"+IPval+\"&encounter_Id=\"+enc+\"&patient_Id=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=CancelAdmissionMain.jsp&jsp_name=\"+chk_jsp+\"&Sex=\"+sex+\"&allowCancelAdmsn=\"+allowCancelAdmsn+\"&pat_check_in_allowed_yn=\"+pat_check_in_allowed_yn+\"&p_service_type=\"+\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"+\"&mode=modal\'></form></BODY></HTML>\";//Added \"allowCancelAdmsn\" on 22nd Feb 2017 against MMS-QH-CRF-0182\n\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t}\n\t\t\telse if(chk_jsp==\"PaintIpinternalReportReprint.jsp\") \t\t\t\t\n\t\t\t\t{\n\t\t\t\tvar retVal\t\t= \tnew String();\n\t\t\t\tvar center\t\t= \"1\" ;\n\t\t\t\tvar status\t\t= \"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tvar facility_id = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\tvar disposition_type_y ;\n\t\t\t\tvar no_of_days\t= document.forms[0].no_of_days.value;\n\t\t\t\tvar age\t\t\t= leave_exp_dt_flag;\n\t\t\t\tvar gen_file_no\t= \"\";\n\t\t\t\tvar location_type = \"N\";\n\t\t\t\tvar p_call_from =\"WALKIN\"\n\t\t\t\t\n\t\t\t\tif(req_no == undefined) req_no = \"\"; \n\t\t\t\t\n\t\t\t\tvar reportParamNames = \"p_encounter_id,p_call_from,p_clinic_code,p_clinic_type,p_patient_id,p_req_no,p_file_no,p_facilityId\";\n\t\t\t\tvar reportParamValues = \"\"+enc+\",\"+p_call_from+\",\"+IPval+\",\"+location_type+\",\"+patid+\",\"+req_no+\",\"+gen_file_no+\",\"+facility_id+\"\";\n\n\t\t\t\t\tif(discharge_date_time != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(indicator==\'DS\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(m_death_yn ==\'N\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN \'IPBAORFR\' AND a.report_id NOT IN \'IPBMDNOT\' \";\n\t\t\t\t\t\t\t\tif(age <= 2 ) {\n\t\t\t\t\t\t\t\t\t//sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t\t/*Below line Added for this incident [40372]*/\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBWBLBL\' \";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBINWBL\' \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}else if(m_death_yn==\'Y\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN \'IPBAORFR\' \";\n\t\t\t\t\t\t\t\tif(age <=2) {\n\t\t\t\t\t\t\t\t\t//  sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t\t/*Below line Added for this incident [40372]*/\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBWBLBL\' \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBINWBL\' \";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN \'IPBAORFR\' AND a.report_id NOT IN \'IPBMDNOT\' \";\n\t\t\t\t\t\t\t\tif(age <= 2 ) {\n\t\t\t\t\t\t\t\t\t//sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t\t/*Below line Added for this incident [40372]*/\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBWBLBL\' \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBINWBL\' \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else if(indicator==\'AO\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN \'IPBBDYTG\' AND a.report_id NOT IN \'IPBMDNOT\' \";\n\t\t\t\t\t\t\tif(age <= 2 ) {\n\t\t\t\t\t\t\t\t// sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t/*Below line Added for this incident [40372]*/\n\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBWBLBL\' \";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t }\n\t\t\t\t\t\t\t\telse {\n\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBINWBL\' \";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN \'IPBBDYTG\' AND a.report_id NOT IN \'IPBAORFR\' AND a.report_id NOT IN \'IPBMDNOT\' \";\n\t\t\t\t\t\t\tif(age <= 2 )\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t// sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t/*Below line Added for this incident [40372]*/\n\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBWBLBL\' \";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t  sqlString = sqlString+\" and a.report_id not in \'IPBINWBL\' \";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t  }\n\t\t\t\t\t} else\n\t\t\t\t\t {\n\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN \'IPBBDYTG\' AND a.report_id NOT IN \'IPBAORFR\' AND a.report_id NOT IN \'IPBMDNOT\' \";\n\t\t\t\t\t\tif(age <= 2 )\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t//\tsqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\n\t\t\t\t\t\t/*Below line Added for this incident [40372]*/\n\t\t\t\t\t\t    sqlString = sqlString+\" and a.report_id not in \'IPBWBLBL\' \";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in \'IPBINWBL\' \";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t }\n\n\t\t\t\t\t if(req_no == \"\") \n\t\t\t\t\t\t sqlString = sqlString+\" and a.report_id not in \'FMFLRQSL\' order by 2 \";\n\t\t\t\t\t else \n\t\t\t\t\t\tsqlString = sqlString+\" order by 2 \";\n\t\t\t\t\t\t//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.\n\t\t\n\t\t\t\t\t\tvar xmlDoc = \"\"\n\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\t\t\t\txmlStr =\"<root><SEARCH sqlstring_querykey=\\\"\"+sqlString+\"\\\" action=\'setSqlStringValue\' /></root>\"\n\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t\t\t\txmlHttp.open(\"POST\",\"../../eIP/jsp/IPintermediate.jsp\",false)\n\t\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\tretVal = \tawait top.window.showModalDialog(\"../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=IPINTERNALREPORTREPRINT&step=1&dest_locn_type=\"+location_type+\"&dest_locn_code=\"+escape(IPval)+\"&EncounterId=\"+enc+\"&Patient_ID=\"+patid+\"&reportParamNames=\"+reportParamNames+\"&reportParamValues=\"+reportParamValues+\"&perm_fs_locn_code=\"+perm_fs_locn,arguments,features);\n\t\t\t\tif(tot_count >= 1)\n\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\telse\n\t\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t}\n\t\t\telse if(chk_jsp==\"CheckinLodgerFrames.jsp\") \t\t\t\t\n\t\t\t{\n\t\t\t\t// Added by SRIDHAR R on 30 JULY 2004\n\t\t\t\t// This block will be executed if the function is for CheckIn Lodger\n\t\t\t\tvar call_function\t= \"CHECK_IN_LODGER\";\t\t\t\n\t\t\t\tvar retVal\t\t\t= \tnew String();\n\t\t\t\tvar center\t\t\t= \"1\" ;\n\t\t\t\tvar status\t\t\t= \"no\";\n\t\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t\t= \"\" ;\n\t\t\t\tretVal\t\t\t\t= \tawait top.window.showModalDialog(\"../../eIP/jsp/CheckinLodgerFrames.jsp?location_code=\"+IPval+\"&EncounterId=\"+enc+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex+\"&oper_stn_id=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&mode=insert&Category=L\",arguments,features);\n\t\t\t\tif(tot_count >= 1)\n\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\telse\n\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t\telse if(chk_jsp==\"CheckinAccmpPersonFrames.jsp\") \t\t\t\t\n\t\t\t{\n\t\t\t\t\n\t\t\t\t// Added by SRIDHAR R on 31 JULY 2004\n\t\t\t\t// This block will be executed if the function is for CheckIn Accompanying Person...\n\t\t\t\tvar call_function\t= \"CHECK_IN_ACCMP_PERSON\";\t\t\t\n\t\t\t\tvar retVal\t\t\t= \tnew String();\n\t\t\t\tvar center\t\t\t= \"1\";\n\t\t\t\tvar status\t\t\t= \"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t\t= \"\" ;\n\t\t\t\tretVal\t\t\t\t= \tawait window.showModalDialog(\"../../eIP/jsp/CheckinAccmpPersonFrames.jsp?location_code=\"+IPval+\"&EncounterId=\"+enc+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex+\"&oper_stn_id=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&mode=insert&Category=A&Lodger_Max_RefNo=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&Lodger_Next_RefNo=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&Lodger_Period=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&Acc_Period=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&Acc_Period_unit=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&IP_param_No_Acc_Persons=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\",arguments,features);\n\t\t\t\tif(tot_count >= 1)\n\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\telse\n\t\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t\telse if(chk_jsp==\"ConfirmBedSideReferralDetail.jsp\") \t\t\t\t\n\t\t\t{\n\t\t\t\t\n\t\t\t\t/// Added by SRIDHAR R on 7 JULY 2004\n\t\t\t\t/// This block will be executed if the function is for BED SIDE REFERRAL\n\t\t\t\tvar call_function\t= \"BedSideReferral\";\t\t\t\n\t\t\t\tvar retVal\t\t\t= \tnew String();\n\t\t\t\tvar center\t\t\t= \"1\" ;\n\t\t\t\tvar status\t\t\t= \"no\";\n\t\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; scroll = no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t\t= \"\" ;\n\t\t\t\tretVal = \tawait window.showModalDialog(\"../../eIP/jsp/PaintReferralPatientDetails.jsp?location_code=\"+IPval+\"&encounterId=\"+enc+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&Sex=\"+sex+\"&mode=modal&bl_instal=\"+instl_yn+\"&p_service_type=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&oper_stn_id=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\",arguments,features);\n\t\t\t\tif(tot_count >= 1)\n\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\telse\n\t\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t\telse if(chk_jsp==\"PaintReferralPatientDetails.jsp\") \t\t\t\t\n\t\t\t{\n\t\t\t\tvar function_id\t\t= document.forms[0].function_id.value;\n\t\t\t\tvar call_function\t= \"ReferralPatientDetails\";\n\t\t\t\tvar retVal\t\t\t= \tnew String();\n\t\t\t\tvar center\t\t\t= \"1\" ;\n\t\t\t\tvar status\t\t\t= \"no\";\n\t\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t\t= \"\" ;\n\t\t\t\tretVal = \tawait top.window.showModalDialog(\"../../eIP/jsp/PaintReferralPatientDetails.jsp?function_id=\"+function_id+\" \t&location_code=\"+IPval+\"&encounterId=\"+enc+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\",arguments,features);\n\n\t\t\t\tif(tot_count >= 1)\n\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\telse\n\t\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif( document.forms[0].modal.value != \'yes\')\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t// Setting of windows size for different Functions.\n\t\t\t\t\t\n\t\t\t\t\tvar jsp_name\t= document.forms[0].jsp_name.value;\n\t\t\t\t\twin_height\t\t= \"45\";\n\t\t\t\t\twin_width\t\t= \"65\"; \n\t\t\t\t\tif(jsp_name==\"ConfirmBedSideReferralDetail.jsp\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar call_function= \"BedSideReferral\";\n\t\t\t\t\t}\n\t\t\t\t\telse if(jsp_name==\"CancelAdmissionMain.jsp\")\n\t\t\t\t\t{\n\t\t\t\t\t\tcondition = \'pat_check_in_allowed_yn=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"\';\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif(jsp_name==\"PaintEmergencyTransfer.jsp\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(colorCode==\"#FECBFA\")\n\t\t\t\t\t\t\t\tcondition = \'bed_class_req_cnt=1&trans_req_cnt=1\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tvar module\t\t= document.forms[0].module.value;\n\t\t\t\t\tvar blinstal\t= document.forms[0].bl_install.value;\n\t\t\t\t\t// Checking whether the module is IP\n\t\t\t\t\tif(module == \"\") module=\"eIP\";\n\t\t\t\t\tvar model_window=document.forms[0].model_window.value;\n\t\t\t\t\t\tif( model_window == \"\") model_window =\"\";\n\t\t\t\t\t\n\t\t\t\t\tif( model_window == \'NO\')\n\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.parent.frames[1].document.location.href=\"../../\"+module+\"/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&function_name=\"+function_name+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="&Sex=\"+sex+\"&bl_instal=\"+instl_yn+\"&\"+condition;\n\t\t\t\t\t}\n\t\t\t\t\telse if( model_window == \'N\')\n\t\t\t\t\t{\n\t\t\t\t\tparent.frames[3].document.location.href=\"../../\"+module+\"/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&function_name=\"+function_name+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&Sex=\"+sex+\"&bl_instal=\"+instl_yn+\"&\"+condition;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar retVal\t\t=    new String();\n\t\t\t\t\t\tvar instl_yn\t= document.forms[0].bl_install.value;\n\t\t\t\t\t\tvar allowCancelAdmsn = document.forms[0].allowCancelAdm.value;//Added by Thamizh selvi on 22nd Feb 2017 against MMS-QH-CRF-0182\n\n\t\t\t\t\t\tvar chg_nurs_unit_in_assign_bed_yn = document.forms[0].chg_nurs_unit_in_assign_bed_yn.value;\n\t\t\t\t\t\tvar center\t\t= \"1\" ;\n\t\t\t\t\t\tvar status\t\t= \"no\";\n\t\t\t\t\t\tvar features    = \"\";\n\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" == \"CANCEL_DISCHARGE_PATIENT\")\n\t\t\t\t\t\t\tfeatures =\"dialogHeight:41; scroll=no; dialogWidth:65; center: \" + center + \"; status: \" + status + \"; dialogTop :82\";\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tfeatures =\"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :5\";\n\n\t\t\t\t\t\t//console.log(features);\n\t\t\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\t\t\tvar called_from = document.forms[0].called_from.value;\n\t\t\t\t\t\tif((called_from == \'DischargeCheckList\') || (called_from == \'ViewCheckList\'))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tretVal =    await parent.window.showModalDialog(\"../../\"+module+\"/jsp/DischargeCheckListFrames.jsp?location_code=\"+IPval+\"&encounterId=\"+enc+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="&menu_id=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="&Sex=\"+sex+\"&mode=modal&bl_instal=\"+instl_yn+\"&confirmIP=";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="&p_service_type=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="&disc_to_date=";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="&disc_from_date=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\",arguments,features);\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' != \'MODIFY_SERVICE_FOR_INPATIENT\') {   \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif((chk_jsp==\"CancelDischargeAdviceMain.jsp\") && (finalize_yn==\"Y\")){\n\t\t\t\t\t\t\t\talert(getMessage(\"MDR_FINALIZED_DISCH_CANT_CANCEL\",\"MR\"));\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t//Assign Bed/Mark Patient Arrival\n\t\t\t\t\t\t\t\t\t\t//Modified for the CRF HSA-CRF-0035\n\t\t\t\t\t\t\t\t\t\t//weight_on_admn_mandatory Added by Dharma on Oct 28th against HSA-CRF-0181 [IN:049541]\n\t\t\t\t\t\t\t\t\t\t//height_on_admn_mandatory,enable_height_bmi_pat_cls Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527\n\t\t\t\t\t\t\t\t\t\tretVal =    await top.window.showModalDialog(\"../../\"+module+\"/jsp/\"+jsp_name+\"?weight_on_admn_mandatory=\"+weight_on_admn_mandatory+\"&height_on_admn_mandatory=\"+height_on_admn_mandatory+\"&enable_height_bmi_pat_cls=\"+enable_height_bmi_pat_cls+\"&location_code=\"+IPval+\"&encounterId=\"+enc+\"&function_id=\"+function_id+\"&function_name=\"+function_name+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&Sex=\"+sex+\"&mode=modal&bl_instal=\"+instl_yn+\"&status_value=\"+status_value+\"&confirmIP=";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="&chg_nurs_unit_in_assign_bed_yn=\"+chg_nurs_unit_in_assign_bed_yn+\"&oper_stn_id=";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="&pat_check_in_allowed_yn=";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="&setup_bl_dtls_in_ip_yn=";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="&priotity_status=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="&change_bed_class_yn=";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="&dflt_blk_prd_for_tfr_out=";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="&bed_block_period_normal=";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="&reserve_bed_on_tfr_yn=";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="&res_reserve_bed_intraward_yn=";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="&bed_block_period_max=";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="&bed_block_period_max_type=";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="&allow_multiple_bed_for_resv_yn=";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="&transfer_wo_delink_yn=";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="&allowCancelAdmsn=\"+allowCancelAdmsn+\"&contact1_name_pda=\"+encodeURIComponent(contact1_name)+\"&contact2_name_pda=\"+encodeURIComponent(contact2_name)+\"\"+condition,arguments,features);\n\t\t\t\t\t\t\t\t\t\t//Added \"allowCancelAdmsn\" on 22nd Feb 2017 against MMS-QH-CRF-0182\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(tot_count >= 1)\n\t\t\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\twindow.returnValue=enc;\n\t\t\t\t\twindow.close();\n\t\t\t\t}\n\t\t\t}\n\t}\n\tasync function showModalReprint( enc, patid, practid, IPval, sex, bed_no, patientclass, colorCode, status_value, tfr_req_status, leave_exp_dt_flag,discharge_date_time,m_death_yn,indicator,req_no,perm_fs_locn,patient_file_no,pat_ser_grp_code)\n\t\t{\t\t\n\t\t\n\t\t\tvar function_id\t\t=\tdocument.forms[0].function_id.value;\n\t\t\tvar oper_stn_id\t\t=\t\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\';\n\t\t\tvar dialogHeight\t= \"500px\";\n\t\t\tvar dialogWidth\t\t= \"800px\";\n\t\t\tvar dialogTop\t\t= \"72\";\n\t\t\tvar chk_jsp\t\t\t= document.forms[0].jsp_name.value;\n\t\t\tvar tot_count\t\t= document.forms[0].total_count.value;\n\t\t\tvar instl_yn\t\t= document.forms[0].bl_install.value;\n\t\t\tvar patient_class=\'\';\n\t\t\tif(patientclass != null)\n\t\t\t\tpatient_class\t= patientclass;\n\t\t\tvar function_name\t= document.forms[0].function_name.value;\n\t\t\tvar condition\t\t= \"\";\t\n\t\t\t if(chk_jsp==\"PaintIpinternalReportReprint.jsp\") \t\t\t\t\n\t\t\t{\n\t\t\t\tvar retVal\t\t= \tnew String();\n\t\t\t\tvar center\t\t= \"1\" ;\n\t\t\t\tvar status\t\t= \"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tvar facility_id = \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\tvar locale\t\t= \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\tvar disposition_type_y ;\n\t\t\t\tvar no_of_days\t= document.forms[0].no_of_days.value;\n\t\t\t\tvar age\t\t\t= leave_exp_dt_flag;\n\t\t\t\tvar gen_file_no\t= \"\";\n\t\t\t\tvar location_type = \"N\";\n\t\t\t\tvar p_call_from =\"WALKIN\"\n\t\t\t\t\n\t\t\t\tif(req_no == undefined) req_no = \"\"; \n\t\t\t\t\n\t\t\t\tvar reportParamNames = \"p_encounter_id,p_call_from,p_clinic_code,p_clinic_type,p_patient_id,p_req_no,p_file_no\";\n\t\t\t\tvar reportParamValues = \"\"+enc+\",\"+p_call_from+\",\"+IPval+\",\"+location_type+\",\"+patid+\",\"+req_no+\",\"+patient_file_no+\"\";\n\n\t\t\t\t\tif(discharge_date_time != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(indicator==\'DS\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(m_death_yn ==\'N\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN (\'IPBAORFR\') AND a.report_id NOT IN (\'IPBMDNOT\') \";\n\t\t\t\t\t\t\t\tif(age <= 2 ) {\n\t\t\t\t\t\t\t\t\t//sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t\t/*Below line  Added for this incident [40372]*/\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBWBLBL\') \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBINWBL\') \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}else if(m_death_yn==\'Y\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN (\'IPBAORFR\') \";\n\t\t\t\t\t\t\t\tif(age <=2) {\n\t\t\t\t\t\t\t\t\t//  sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t/*Below line  Added for this incident [40372]*/\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBWBLBL\') \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBINWBL\') \";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN (\'IPBAORFR\') AND a.report_id NOT IN (\'IPBMDNOT\') \";\n\t\t\t\t\t\t\t\tif(age <= 2 ) {\n\t\t\t\t\t\t\t\t\t//sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t/*Below line  Added for this incident [40372]*/\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBWBLBL\') \";\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBINWBL\') \";\n\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else if(indicator==\'AO\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN (\'IPBBDYTG\') AND a.report_id NOT IN (\'IPBMDNOT\') \";\n\t\t\t\t\t\t\tif(age <= 2 ) {\n\t\t\t\t\t\t\t\t// sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t/*Below line  Added for this incident [40372]*/\n\t\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBWBLBL\') \";\n\t\t\t\t\t\t\t\t }\n\t\t\t\t\t\t\t\telse {\n\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBINWBL\') \";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' OR print_on_disch_adv_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN (\'IPBBDYTG\') AND a.report_id NOT IN (\'IPBAORFR\') AND a.report_id NOT IN (\'IPBMDNOT\')\";\n\t\t\t\t\t\t\tif(age <= 2 )\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t// sqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t/*Below line  Added for this incident [40372]*/\n\t\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBWBLBL\') \";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t  sqlString = sqlString+\" and a.report_id not in (\'IPBINWBL\') \";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t  }\n\t\t\t\t\t} else\n\t\t\t\t\t {\n\t\t\t\t\t\tvar sqlString = \"SELECT a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id FROM ip_online_report a, sm_report b WHERE a.module_id IN (\'IP\', \'FM\') AND b.internal_request_yn = \'Y\' AND a.facility_id = \'\"+facility_id+\"\' AND ( a.print_on_admission_yn = \'Y\' OR a.print_on_transfer_request_yn = \'Y\' OR a.print_on_conform_transfer_yn = \'Y\' OR a.print_on_bed_assigned_yn = \'Y\' OR a.print_on_discharge_yn = \'Y\' ) AND a.nursing_unit_code = \'\"+IPval+\"\' AND a.report_id = b.report_id AND a.report_id NOT IN (\'IPBBDYTG\') AND a.report_id NOT IN (\'IPBAORFR\') AND a.report_id NOT IN (\'IPBMDNOT\')\";\n\t\t\t\t\t\tif(age <= 2 )\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t//\tsqlString = sqlString+\"order by 2 \";\n\t\t\t\t\t\t/*Below line  Added for this incident [40372]*/\n\t\t\t\t\t\t sqlString = sqlString+\" and a.report_id not in (\'IPBWBLBL\') \";\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBINWBL\') \";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t//Below line Added for this incident [40702]\n\t\t\t\t\t\t\tif(discharge_date_time==\"\"){\n\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'IPBDISDF\')\";  \n\t\t\t\t\t\t\t}\n\t\t\t\t\t }\n\n\t\t\t\t\t if(req_no == \"\" && patient_file_no == \"\") \n\t\t\t\t\t\t sqlString = sqlString+\" and a.report_id not in (\'FMFLRQSL\') order by 2 \";\n\t\t\t\t\t else \n\t\t\t\t\t{\n\t\t\t\t\t\t//sqlString= sqlString+\" order by 2 \";\n\t\t\t\t\t\tif(req_no == \"\")\n\t\t\t\t\t\t\tsqlString = sqlString+\" and a.report_id not in (\'FMFLRQSL\') \";\n\t\t\t\t\t\tsqlString = sqlString+\" UNION SELECT report_id, report_desc, no_of_copies, module_id FROM (SELECT DISTINCT a.report_id, b.report_desc, 1 no_of_copies, b.module_id, 1 orderby FROM mp_online_reports a, sm_report_lang_vw b WHERE a.pat_ser_grp_code = \'\"+pat_ser_grp_code+\"\' AND b.language_id = \'\"+locale+\"\' AND a.print_reqd_yn = \'Y\' AND b.report_id = a.report_id AND a.report_id IN (\'MPBFLLBL\')) ORDER BY 2 \";\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\t\tvar xmlDoc = \"\"\n\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\t\t\t\txmlStr =\"<root><SEARCH sqlstring_querykey=\\\"\"+sqlString+\"\\\" action=\'setSqlStringValue\' /></root>\"\n\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t\t\t\txmlHttp.open(\"POST\",\"../../eIP/jsp/IPintermediate.jsp\",false)\n\t\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\n\t\t\t\t//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.\n\t\t\t\tretVal = \tawait window.showModalDialog(\"../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=IPINTERNALREPORTREPRINT&step=1&dest_locn_type=\"+location_type+\"&dest_locn_code=\"+escape(IPval)+\"&EncounterId=\"+enc+\"&Patient_ID=\"+patid+\"&reportParamNames=\"+reportParamNames+\"&reportParamValues=\"+reportParamValues+\"&perm_fs_locn_code=\"+perm_fs_locn,arguments,features);\n\t\t\t\tif(tot_count >= 1)\n\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\telse\n\t\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t}\n\n\t}\n\tfunction callChangeAdmDtls(enc, patid, practid, IPval, sex, bed_no, patientclass, colorCode, status_value, tfr_req_status, leave_exp_dt_flag,cutt_of_time)\n\t{\n\t\t\t\tif( document.forms[0].modal.value != \'yes\'){\n\t\t\t\t\tisBlAllowed(enc, patid, practid, IPval, sex, bed_no, patientclass, colorCode, status_value, tfr_req_status, leave_exp_dt_flag,cutt_of_time);\n\t\t\t\t}else{\n\t\t\t\t\twindow.parent.returnValue=enc;\n\t\t\t\t\twindow.parent.close();\n\t\t\t}\n\t}\n\n\t\t\n\t\t//This modal window is for validation of current date with discharge date\n\t\tfunction showModalForCancelDischarge( enc, patid, practid, IPval, sex, bed_no, patientclass, colorCode, status_value, tfr_req_status, leave_exp_dt_flag, dischargeDate,open_cnt,mo_install_yn,latestDischargeEncId)\n\t\t{\n\t\t\t\n\t\t\t/*if(!isAfterNow(dischargeDate,\'DMY\',localeName))\n\t\t\t{\n\t\t\t\talert(getMessage(\"DISCH_DT_NOT_SAME_AS_CURR_DT\",\"IP\"));\n\t\t\t\treturn ;\n\t\t\t}else \n\t\t\t*/\n\t\t\t//latestDischargeEncId conditions added by Dharma on Aug 27th 2018 against PMG2018-GHL-CRF-0001 [IN:068328]\n\t\t\tif(open_cnt > 0){\t\n\t\t\t\talert(getMessage(\"CANNOT_CANCEL_DISCHARGE\",\"IP\"));\n\t\t\t\treturn ;\n\t\t\t}else if(latestDischargeEncId!=enc){\n\t\t\t\tvar msg\t= getMessage(\"CANNOT_CANCEL_DISCHARGE_NOT_LATEST\",\"IP\");\n\t\t\t\tmsg=msg.replace(\"$$$\",latestDischargeEncId);\n\t\t\t\talert(msg)\n\t\t\t}else\n\t\t\t\tshowModal( enc, patid, practid, IPval, sex, bed_no, patientclass, colorCode, status_value, tfr_req_status, leave_exp_dt_flag);\n\n\n\t\t}\n\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t</head>\n\t\t\t<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' >\n\t\t\t<form name=\'iplookupqueryresult\' id=\'iplookupqueryresult\'>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.getElementById(\'navigate_table\').style=\"display\";\n\t\t\t\t\t\t\t\tdocument.getElementById(\'table_header\').style=\"display\";\t\t\n\t\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\t\n\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\tdocument.getElementById(\'next\').style.display=\"none\";\n\t\t\t</SCRIPT>\n\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\t\n\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\tdocument.getElementById(\'next\').style.display=\"inline\";\n\t\t\t</SCRIPT>\t\t\t\n\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t\t<tr><td width = \"100%\" class=\'white\' >&nbsp;</td>\n\t\t\t\t</tr>\n\t\t<tr>\n\t\t\t<td width = \"75%\" class=\'white\' >&nbsp;</td>\n\t\t\t<td width = \"25%\" class=\'white\' align=\"right\"><input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' class=\'button\' >\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" >\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" >\n\t\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" >\n\t\t\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" >\n\t\t\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" >\n\t\t\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >\n\t\t\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" >\n\t\t\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" >\n\t\t\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" >\n\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" >\n\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" >\n\t\t\t<input type=\'hidden\' name=\'routine_tfr_yn\' id=\'routine_tfr_yn\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" >\n\t\t\t<input type=\'hidden\' name=\'no_of_days\' id=\'no_of_days\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" >\n\t\t\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" >\n\t\t\t<input type=\'hidden\' name=\'bl_install\' id=\'bl_install\' value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" >\n\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" >\n\t\t\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" >\n\t\t\t<input type=\'hidden\' name=\'targetURL\' id=\'targetURL\' value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >\n\t\t\t<input type=\'hidden\' name=\'IPParamValue\' id=\'IPParamValue\' value=\"\" >\n\t\t\t<input type=\'hidden\' name=\'leave_exp_dt_flag\' id=\'leave_exp_dt_flag\' value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" >\n\t\t\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" >\n\t\t\t<input type=\'hidden\' name=\'bed_block_period_max\' id=\'bed_block_period_max\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" >\n\t\t\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >\n\t\t\t<input type=\'hidden\' name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n\t\t\t<input type=\'hidden\' name=\'bedBlock_normal\' id=\'bedBlock_normal\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" >\n\t\t\t<input type=\'hidden\' name=\'max_blk_type\' id=\'max_blk_type\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" >\n\t\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" >\n\t\t\t<input type=\'hidden\' name=\'setup_bl_dtls_in_ip_yn\' id=\'setup_bl_dtls_in_ip_yn\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" >\n\t\t\t<input type=\'hidden\' name=\'allow_discharge_date\' id=\'allow_discharge_date\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" >\n\t\t\t<input type=\'hidden\' name=\'max_disch_period_for_dc\' id=\'max_disch_period_for_dc\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" >\n\t\t\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" >\n\t\t\t<input type=\'hidden\' name=\'chg_nurs_unit_in_assign_bed_yn\' id=\'chg_nurs_unit_in_assign_bed_yn\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" >\n\t\t\t<input type=\'hidden\' name=\'sys_dt_time\' id=\'sys_dt_time\' value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" >\n\t\t\t<input type=\'hidden\' name=\'confirmIP\' id=\'confirmIP\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" >\n\t\t\t<input type=\'hidden\' name=\'p_service_type\' id=\'p_service_type\' value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" >\n\t\t\t<input type=\'hidden\' name=\'pat_check_in_allowed_yn\' id=\'pat_check_in_allowed_yn\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" >\n\t\t\t<input type=\'hidden\' name=\'priotity_status\' id=\'priotity_status\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" >\n\t\t\t<input type=\'hidden\' name=\'change_bed_class_yn\' id=\'change_bed_class_yn\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" >\n\t\t\t<input type=\'hidden\' name=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" >\n\t\t\t<input type=\'hidden\' name=\'dflt_blk_prd_for_tfr_out\' id=\'dflt_blk_prd_for_tfr_out\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" >\n\t\t\t<input type=\'hidden\' name=\'bed_block_period_normal\' id=\'bed_block_period_normal\' value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" >\n\t\t\t<input type=\'hidden\' name=\'change_adm_dtls_duration\' id=\'change_adm_dtls_duration\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" >\n\t\t\t<input type=\'hidden\' name=\'reserve_bed_on_tfr_yn\' id=\'reserve_bed_on_tfr_yn\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" >\n\t\t\t<input type=\'hidden\' name=\'bed_block_period_max_type\' id=\'bed_block_period_max_type\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" >\n\t\t\t<input type=\'hidden\' name=\'allow_multiple_bed_for_resv_yn\' id=\'allow_multiple_bed_for_resv_yn\' value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" >\n\t\t\t<!-- venkat crf 41-->\n\t\t\n\t\t\t<input type=\'hidden\' name=\'result_count\' id=\'result_count\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" >\n\t\t\t<input type=\'hidden\' name=\'chc_for_pen_orders_bfr_dis_adv\' id=\'chc_for_pen_orders_bfr_dis_adv\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t<input type=\'hidden\' name=\'dis_adv_allow_yn\' id=\'dis_adv_allow_yn\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n<!-- venkat crf 41-->\n\t\t\t<input type=\'hidden\' name=\'chc_for_pen_orders_bfr_dischrg\' id=\'chc_for_pen_orders_bfr_dischrg\' value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t<input type=\'hidden\' name=\'dischrg_allow_yn\' id=\'dischrg_allow_yn\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\n\t\t\t<input type=\'hidden\' name=\'allow_late_discharge_reason\' id=\'allow_late_discharge_reason\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n\t\t\t<input type=\'hidden\' name=\'disch_reason_mand_yn\' id=\'disch_reason_mand_yn\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n\t\t\t<input type=\'hidden\' name=\'transfer_wo_delink_yn\' id=\'transfer_wo_delink_yn\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'><!-- Added for the CRF HSA-CRF 0035 -->\n\n\t\t\t<input type=\'hidden\' name=\'CancelledReason\' id=\'CancelledReason\' value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" >\n\t\t\t<input type=\'hidden\' name=\'CancelledBy\' id=\'CancelledBy\' value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" >\n\t\t\t<input type=\'hidden\' name=\'CancelledDate\' id=\'CancelledDate\' value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" >\n\t\t\t<input type=\'hidden\' name=\'bed_no\' id=\'bed_no\' value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" >\n\t\t\t<!-- 10/17/2008-->\n\t\t\t<input type=\'hidden\' name=\'assign_bed\' id=\'assign_bed\' value=\" \" >\n\t\t\n\t\t\t<!-- 10/17/2008    end-->\n<!-- 0-7/09/2009    end-->\n\t\t\t\t<input type=\'hidden\' name=\'deceased_date_time\' id=\'deceased_date_time\' value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\" >\n\t\t\t<input type=\'hidden\' name=\'maternal_death_yn\' id=\'maternal_death_yn\' value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" \" >\n\t\t\t<input type=\'hidden\' name=\'indicator\' id=\'indicator\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" >\n\t\t\t<input type=\'hidden\' name=\'discharge_date_time\' id=\'discharge_date_time\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" >\n\t\t\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" >\n\t\t\t<input type=\'hidden\' name=\'pre_disch_appl_yn\' id=\'pre_disch_appl_yn\' value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" ><!-- Added for the CRF -KDAH-CRF-0104  by Dharma    end-->\n\t\t\t<input type=\'hidden\' name=\'weight_on_admn_mandatory\' id=\'weight_on_admn_mandatory\' value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" > <!-- Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] -->\n\t\t\t<input type=\'hidden\' name=\'height_on_admn_mandatory\' id=\'height_on_admn_mandatory\' value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" >  <!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->\n\t\t\t<input type=\'hidden\' name=\'enable_height_bmi_pat_cls\' id=\'enable_height_bmi_pat_cls\' value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" >  <!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->\n\t\t\t<input type=\'hidden\' name=\'restriction_for_wardReturn\' id=\'restriction_for_wardReturn\' value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" > <!-- Added by Sangeetha on 09-Nov-2016 against GHL-CRF-412.2 -->\n\t\t\t<!--Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start-->\n\t\t\t<input type=\'hidden\' name=\'chk_pen_sale_rtn_bfr_dis_adv\' id=\'chk_pen_sale_rtn_bfr_dis_adv\' value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" >\n\t\t\t<input type=\'hidden\' name=\'isRestrictDisAdvSaleRetPend\' id=\'isRestrictDisAdvSaleRetPend\' value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" >\n\t\t\t<!--Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End-->\n\n\t\t\t<input type=\'hidden\' name=\'allowCancelAdm\' id=\'allowCancelAdm\' value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" >  <!-- Added by Thamizh selvi on 20th Feb 2017 against MMS-QH-CRF-0182 -->\n\t\t\t<!--Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135 -->\n            <input type=\'hidden\' name=\'chk_dis_pat_bt_order_pend\' id=\'chk_dis_pat_bt_order_pend\' value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t<input type=\'hidden\' name=\'blood_consump_status\' id=\'blood_consump_status\' value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t<input type=\'hidden\' name=\'isDisPatBTorderPendAppl\' id=\'isDisPatBTorderPendAppl\' value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t<!--end-->\n\t\t\t<input type=\'hidden\' name=\'isNewBornChngsAppl\' id=\'isNewBornChngsAppl\' value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t<input type=\'hidden\' name=\'trans_yn_unfnzed_newborn\' id=\'trans_yn_unfnzed_newborn\' value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\n             \n\t\t\t</form>\n\n\n\t\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t\t<tr><td width=\'100%\' id=\'column\'></td></tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\n\t\t\t</body>\n\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n</html>\n\n";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );
 
public String singleToDoubleQuotes(String strDB)
{
	/*
	String strModified="";
	try
	{
		if((strDB != null) ||(strDB !=""))
		{
			StringBuffer stringbuffer = new StringBuffer(strDB);
			int i = 0;
			for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
			{
				i = strDB.indexOf('\'', i);
				stringbuffer.insert(i + j, "'");
				i++;
			}
			strModified=stringbuffer.toString();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}


	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet cancelBedDetail= null;synchronized(session){
                cancelBedDetail=(webbeans.eCommon.RecordSet)pageContext.getAttribute("cancelBedDetail",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(cancelBedDetail==null){
                    cancelBedDetail=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("cancelBedDetail",cancelBedDetail,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String locale					= (String)session.getAttribute("LOCALE");
	Connection con					= null;
	Statement stmt_bl				= null;
	ResultSet rs_bl					= null;
	Statement stmt					= null;
	ResultSet rs					= null;
	ResultSet colorRS				= null;
	Statement paramstmt				= null;
	ResultSet paramrs				= null; 
	PreparedStatement pstmt			= null;
	//PreparedStatement paramstmt1	= null;
	ResultSet rs1					= null;
	//Added by Sangeetha for GHL-CRF-0412.2 on 4-nov-2016
	PreparedStatement pstmtward = null;		
	ResultSet rsetWard			= null; 
	String SQLRetMedication     = "";
	String ward_return			= "";
	String oth_adt_status1		="";

	//Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
	//ResultSet params_1               =null;
    //Statement paramstat                   =null;
    //Connection con_1                      =null;
	String chc_for_pen_orders_bfr_dis_adv ="";
    String dis_adv_allow_yn               ="";
	String chc_for_pen_orders_bfr_dischrg ="";
	String chk_pen_ward_rtn_bfr_dis_adv	  =""; //Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
	//Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start
	String chk_pen_sale_rtn_bfr_dis_adv	  =""; 
	String pend_sal_ret_fin_stats		  ="Y";
	//Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End
	String bill_indicator=""; //Maheshwaran K added for TH-KW-CRF-0141.1
	
	String dischrg_allow_yn               ="";
    int result_count=0;
	//String order_list="";
	// venkatesh KDAH-CRF-0041 END
	
	String tfr_req_stat				= "";	
	String facility_id				= "";
	String login_user				= "";
	String oper_stn_id				= "";
	String show_bed_yn				= "";
	String wherecondn				= "";
	String wc_for_bed_ref			= "";
	String function_name			= "";
	String fam_name_search			= "";
	String pat_check_in_allowed_yn	= "N";
	String setup_bl_dtls_in_ip_yn	= "N";
	String routine_tfr_yn			= "";
	String req_stat_tout			= "";
	String priotity_status			= "";
	String date_of_birth_converted  = "";
	String cutt_of_time				= "";
	String req_no					= "";
	String perm_fs_locn				= "";
	

	String bl_operational			= (String)session.getAttribute("bl_operational");
	facility_id						= (String)session.getAttribute("facility_id");
	login_user						= (String)session.getAttribute("login_user");
	oper_stn_id						= checkForNull(request.getParameter("opst"));
	show_bed_yn						= checkForNull(request.getParameter("show_bed_yn"));
	wherecondn						= checkForNull(request.getParameter("wherecondn"));
	function_name					= checkForNull(request.getParameter("function_name"));
	routine_tfr_yn					= checkForNull(request.getParameter("routine_tfr_yn"));
	String discharge_type			= checkForNull(request.getParameter("discharge_type"));
	String discharge_status			= checkForNull(request.getParameter("discharge_status"));
	String ServiceCode				= checkForNull(request.getParameter("ServiceCode"));
	String SubServiceCode			= checkForNull(request.getParameter("SubServiceCode"));
	int change_admission_dtls		= 0;

	String disc_from_date			= checkForNull(request.getParameter("disc_from_date"));
		if(!disc_from_date.equals(""))
			disc_from_date			= DateUtils.convertDate(disc_from_date,"DMY",locale,"en"); 
	String disc_to_date				= checkForNull(request.getParameter("disc_to_date"));
		if(!disc_to_date.equals(""))
			disc_to_date			= DateUtils.convertDate(disc_to_date,"DMY",locale,"en"); 
	// added for assign bed on 3/8/2005 by Sridhar R 
	String chg_nurs_unit_in_assign_bed_yn		= checkForNull(request.getParameter("chg_nurs_unit_in_assign_bed_yn"),"N");
	String bl_interfaced_yn			= "";
	String Lodger_Max_RefNo			= "";
	String ALLOW_GATE_PASS_PRE_DIS_ADV_YN = ""; // added by mujafar for MO-CRF-20157
	String Lodger_Next_RefNo		= "";
	String Lodger_Period			= "";
	String Acc_Period				= "";
	String Acc_Period_unit			= "";
	String deactivate_pseudo_bed_yn	= "";
	String cancel_reason_code		= "";
	String cancellation_date_time	= "";
	String cancelled_by_id			= "";
	String contact_reason			= "";
	String modified_By_rslt			= "";
	String reason_for_modification  = "";
	String reserve_bed_on_tfr_yn    = "";
	String res_reserve_bed_intraward_yn    = "";//Maheshwaran
	String bed_block_period_max    = "";
	String bed_block_period_max_type= "";
	//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
    String chk_dis_pat_bt_order_pend="";   
    String blood_consump_status="";     
	String blood_consump_count="";
	//End
	String trans_yn_unfnzed_newborn	= "N";
	String discharge_date_time_display = "&nbsp;";
	
	String discharge_date_time_display_report=""; //Added this line for this incident [40702]

	int IP_param_No_Acc_Persons		= 0;
	int bed_block_period_dis		= 0;
	int dis_date_chk_days			= 0;
	int dflt_blk_prd_for_tfr_out	= 0;
	int bed_block_period_normal		= 0;
	String status_value				= "";	
	String status_value_converted   = "";
	String call_func				= "";	
	String confirmIP				= checkForNull(request.getParameter("confirmIP"));
	String p_service_type			= checkForNull(request.getParameter("p_service_type"));
	String targetURL				= checkForNull(request.getParameter("targetURL"));
	String color_code_scheme		= "";
		if (show_bed_yn==null) show_bed_yn = "Y";
	String clinic_list				= checkForNull(request.getParameter("clinic_list"), "1");
		if(clinic_list.length() == 0) clinic_list="('')";
	String call_function			=	checkForNull(request.getParameter("param"));

	String pend_order_status="";

	/*
		Vairable Added :
			On:10/28/2010,For:FD-PMG20089-CRF-0862,By:Chiranjeevi.C
	*/
	String exclude_nda_pats			=	checkForNull(request.getParameter("exclude_nda_pats"),"N");


	//10/16/2008 5089_MF-CRF-0017 enhancement startcall_function put request scope
	request.setAttribute("call_function",call_function);

	String paramsValue				=	checkForNull((String) session.getAttribute("paramsValue"));
	String menu_id					=	checkForNull(request.getParameter("menu_id"));

	String allow_discharge_date		= checkForNull(request.getParameter("allow_discharge_date"));
	String max_disch_period_for_dc_str	= checkForNull(request.getParameter("max_disch_period_for_dc"));
	String patientName			= checkForNull(request.getParameter("patientName"));
	//String patientName				=  java.net.URLDecoder.decode(patientName1,"UTF-8");
	String asgn_bed_mark_arvl		= "";
	String link_font_color          = "";
	String sys_dt_time				= "";

	String function_id				= checkForNull(request.getParameter("function_id"));
	String allow_late_discharge_reason="";
	String disch_reason_mand_yn="";
	String transfer_wo_delink_yn="";//Added for the CRF HSA-CRf-0035

	int max_disch_period_for_dc		= 0;

	String deceased_date_time		= "";
	String maternal_death_yn		= "";
	String indicator				= "";
	String age						= "";
	int n_Age						= 0;
	String allow_multiple_bed_for_resv_yn		= "";
	int  max_disch_period_for_predc				= 0;
	String  allow_discharge_date_predc			= "";
	String  discharge_checklist_app_yn			= "";
	String  dis_date_chk_days_unit				= "";
	String  diag_update_period_max_unit			= "";
	String  serverdate				= "";
	String  patient_file_no						= "";
	String  pat_ser_grp_code					= "";
	
	//Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613
	PreparedStatement pstmt2 = null;
	CallableStatement cs = null;
	ResultSet rs2 = null;
	int episode_id = 0;
	int session_id = 0;
	String  Respc = "";
	String  pat_class = "";
	String  episode_type = "";
	String  pgm_date = "";
	
	if(! max_disch_period_for_dc_str.equals(""))
		max_disch_period_for_dc		= Integer.parseInt(max_disch_period_for_dc_str);
	try
	{
		// Following Code is to Check the Module with Billing Interface 
		con							= ConnectionManager.getConnection(request);
		paramstmt					= con.createStatement();
		String bed_class_allowed    = "";
		// Added by Goamthi 07/09/2004 for Allow Patient Check-in during admission
//		paramrs = paramstmt.executeQuery(" SELECT NVL(bl_interfaced_yn,'N') bl_interfaced_yn, setup_bl_dtls_in_ip_yn, pat_check_in_allowed_yn, priority_applicable_yn, change_bed_class_yn,  bed_block_period_dis, dis_date_chk_days, deactivate_pseudo_bed_yn, dflt_blk_prd_for_tfr_out, bed_block_period_normal, lodger_max_srl_no, lodger_next_srl_no, max_stay_of_lodger_after_disc, dflt_gate_pass_period, dflt_gate_pass_unit, max_allowed_accom_pers,change_admission_dtls,to_char(sysdate,'dd/mm/yyyy hh24:mi')sys_dt_time,reserve_bed_on_tfr_yn,bed_block_period_max,bed_block_period_max_type,allow_multiple_bed_for_resv_yn,dis_date_chk_days, dis_date_chk_days_unit,  max_disch_period_for_dc,to_char(sysdate - decode( dis_date_chk_days_unit,'H', dis_date_chk_days/24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date FROM IP_PARAM WHERE facility_id='"+facility_id+"' ");
/*
	Added for 5/6/2010 PE.
	1.The below query was modified for PDA.
	2.Joining of MP_PARAM table based upon conditionally whern the calling function is PDA.
	3. The MP_PARAM values required to  PDA files.
*/
		String mp_param_table		= "";
		String mp_param_colns		= "";
		String mp_param_criteria	= "";
		String mother_cut_off_age	= "";
		String mother_max_age		= "";
		String mo_install_sql		= "";
		String mo_install_yn		= "";
		String pre_disch_appl_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
		String pre_dis_initiate_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
		String weight_on_admn_mandatory	= ""; //Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541]
		String height_on_admn_mandatory	= ""; //Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527
		String enable_height_bmi_pat_cls = "";//Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527
		String dis_ot_pend_ord_yn				= "N";
		String dis_adv_ot_pend_ord_yn			= "N";
		String isAllowDischargeDisAdv			= "Y";

		boolean allowCancelAdm =  eCommon.Common.CommonBean.isSiteSpecific(con,"IP","ALLOW_CANCEL_ADMISSION"); //Added by Thamizh selvi on 15th Feb 2017 against MMS-QH-CRF-0182
		Boolean isDisPatBTorderPendAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","CHK_DIS_PAT_BT_ORDER_PEND");//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
		Boolean isNewBornChngsAppl		= eCommon.Common.CommonBean.isSiteSpecific(con,"IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");//Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757]
		Boolean isCurrentLocDtlsAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","CURNT_LOC_DTLS_APPL");//Added by Shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
		Boolean isRestrictDisAdvSaleRetPend = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","RESTRICT_DIS_ADV_SALE_RET_PEND");//Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892]

        Boolean isTopupDepositAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"IP","IP_TOPUP_DEPOSIT"); //Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613
		Boolean isCoderClearance =  eCommon.Common.CommonBean.isSiteSpecific(con,"IP","IP_DISCHAGE_PAT_CODER_CLR");  //Maheshwaran K added for TH-KW-CRF-0141.1
		//Maheshwaran K added for TH-KW-CRF-0141.1
		String current_bill_status="";	 
		String bill_indicator_val="";
		//StringBuffer bill_indicator_val = new StringBuffer();
		if(call_function.equals("DischargePatient")  && isCoderClearance) {
		current_bill_status			= checkForNull(request.getParameter("current_bill_status"));
		if(current_bill_status.equals("CC"))
			bill_indicator_val="1";
		if(current_bill_status.equals("DB"))
			bill_indicator_val="2";
		if(current_bill_status.equals("DC"))
			bill_indicator_val="3";
		if(current_bill_status.equals("A"))
			bill_indicator_val="A";
		}
		if(call_function.equals("PrepareDischargeAdvice")){
				mp_param_table=" ,MP_PARAM B";                                                                                                                                                                   
				mp_param_colns=" ,B.NB_MOTHER_CUTOFF_AGE MOTHER_CUT_OFF_AGE,B.NB_MOTHER_UPPER_AGE MOTHER_MAX_AGE"; 
				mp_param_criteria	=" AND B.MODULE_ID='MP'";                                                                                                                                                     
		
		}
		if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
			mo_install_sql = ",(select  install_yn from  sm_module where   module_id ='MO')mo_install_yn";
		
		//paramrs = paramstmt.executeQuery(" SELECT pre_disch_appl_yn,bl_interfaced_yn, setup_bl_dtls_in_ip_yn, pat_check_in_allowed_yn, discharge_checklist_app_yn, diag_update_period_max_unit,	TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') serverdate,priority_applicable_yn, change_bed_class_yn, bed_block_period_dis, dis_date_chk_days, deactivate_pseudo_bed_yn,       dflt_blk_prd_for_tfr_out, bed_block_period_normal, lodger_max_srl_no, lodger_next_srl_no, max_stay_of_lodger_after_disc, dflt_gate_pass_period, dflt_gate_pass_unit, max_allowed_accom_pers,change_admission_dtls, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_dt_time, reserve_bed_on_tfr_yn,bed_block_period_max, bed_block_period_max_type, allow_multiple_bed_for_resv_yn, dis_date_chk_days, ALLOW_LATE_DISCHARGE_REASON, DISCH_REASON_MAND_YN, transfer_wo_delink_yn,dis_date_chk_days_unit,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN,CHK_FOR_PEN_ORDERS_BFR_DIS,DIS_ALLOW_YN, max_disch_period_for_dc,TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date"+mp_param_colns+" "+mo_install_sql+" FROM IP_PARAM "+mp_param_table+" WHERE facility_id='"+facility_id+"' "+mp_param_criteria+" ");
		//weight_on_admn_mandatory added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] 
		//Maheshwaran K added RES_RESERVE_BED_INTRAWARD_YN
		//height_on_admn_mandatory,enable_height_bmi_pat_cls added Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527
		
		
		paramrs = paramstmt.executeQuery(" SELECT ALLOW_GATE_PASS_PRE_DIS_ADV_YN,weight_on_admn_mandatory,height_on_admn_mandatory,enable_height_bmi_pat_cls,pre_disch_appl_yn,bl_interfaced_yn, setup_bl_dtls_in_ip_yn, pat_check_in_allowed_yn, discharge_checklist_app_yn, diag_update_period_max_unit,	TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') serverdate,priority_applicable_yn, change_bed_class_yn, bed_block_period_dis, dis_date_chk_days, deactivate_pseudo_bed_yn,       dflt_blk_prd_for_tfr_out, bed_block_period_normal, lodger_max_srl_no, lodger_next_srl_no, max_stay_of_lodger_after_disc, dflt_gate_pass_period, dflt_gate_pass_unit, max_allowed_accom_pers,change_admission_dtls, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_dt_time, reserve_bed_on_tfr_yn,RES_RESERVE_BED_INTRAWARD_YN,bed_block_period_max, bed_block_period_max_type, allow_multiple_bed_for_resv_yn, dis_date_chk_days, ALLOW_LATE_DISCHARGE_REASON, DISCH_REASON_MAND_YN, transfer_wo_delink_yn,dis_date_chk_days_unit,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN,CHK_FOR_PEN_ORDERS_BFR_DIS,DIS_ALLOW_YN,CHK_PEN_WARD_RTN_BFR_DIS_ADV,chk_pen_sale_rtn_bfr_dis_adv,CHK_DIS_PAT_BT_ORDER_PEND, TRANS_YN_UNFNZED_NEWBORN,max_disch_period_for_dc,TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date"+mp_param_colns+" "+mo_install_sql+",DIS_OT_PEND_ORD_YN,DIS_ADV_OT_PEND_ORD_YN FROM IP_PARAM "+mp_param_table+" WHERE facility_id='"+facility_id+"' "+mp_param_criteria+" ");  // "CHK_PEN_WARD_RTN_BFR_DIS_ADV" Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2 // "CHK_DIS_PAT_BT_ORDER_PEND" Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
	      

		while(paramrs.next()){
				Lodger_Max_RefNo				= checkForNull(paramrs.getString("lodger_max_srl_no"));
				ALLOW_GATE_PASS_PRE_DIS_ADV_YN = checkForNull(paramrs.getString("ALLOW_GATE_PASS_PRE_DIS_ADV_YN")); // added by mujafar for MO-CRF-20157
				Lodger_Next_RefNo				= checkForNull(paramrs.getString("lodger_next_srl_no"));
				Lodger_Period					= checkForNull(paramrs.getString("max_stay_of_lodger_after_disc"));
				Acc_Period						= checkForNull(paramrs.getString("dflt_gate_pass_period"));
				Acc_Period_unit					= checkForNull(paramrs.getString("dflt_gate_pass_unit"));
				IP_param_No_Acc_Persons			= paramrs.getInt("max_allowed_accom_pers");
				bl_interfaced_yn				= checkForNull(paramrs.getString("bl_interfaced_yn"));
				setup_bl_dtls_in_ip_yn			= checkForNull(paramrs.getString("setup_bl_dtls_in_ip_yn"));
				pat_check_in_allowed_yn	        = checkForNull(paramrs.getString("pat_check_in_allowed_yn"));
				priotity_status					= checkForNull(paramrs.getString("priority_applicable_yn"));
				bed_class_allowed				= checkForNull(paramrs.getString("change_bed_class_yn"));
				deactivate_pseudo_bed_yn		= checkForNull(paramrs.getString("deactivate_pseudo_bed_yn"));
				bed_block_period_dis			= paramrs.getInt("bed_block_period_dis");
				dis_date_chk_days				= paramrs.getInt("dis_date_chk_days");
				dflt_blk_prd_for_tfr_out		= paramrs.getInt("dflt_blk_prd_for_tfr_out");
				bed_block_period_normal	        = paramrs.getInt("bed_block_period_normal");
				change_admission_dtls			= paramrs.getInt("change_admission_dtls");
				sys_dt_time						= paramrs.getString("sys_dt_time");
				reserve_bed_on_tfr_yn			= checkForNull(paramrs.getString("reserve_bed_on_tfr_yn"));
				res_reserve_bed_intraward_yn	= checkForNull(paramrs.getString("RES_RESERVE_BED_INTRAWARD_YN"));
				bed_block_period_max			= checkForNull(paramrs.getString("bed_block_period_max"));
				bed_block_period_max_type		= checkForNull(paramrs.getString("bed_block_period_max_type"));
				allow_multiple_bed_for_resv_yn	= checkForNull(paramrs.getString("allow_multiple_bed_for_resv_yn"),"N");
				dis_ot_pend_ord_yn				= checkForNull(paramrs.getString("DIS_OT_PEND_ORD_YN"),"N");
				dis_adv_ot_pend_ord_yn			= checkForNull(paramrs.getString("DIS_ADV_OT_PEND_ORD_YN"),"N");
				max_disch_period_for_predc		= paramrs.getInt("max_disch_period_for_dc");
				allow_discharge_date_predc		= checkForNull(paramrs.getString("allow_discharge_date"));
				discharge_checklist_app_yn		= checkForNull(paramrs.getString("discharge_checklist_app_yn"));
				dis_date_chk_days_unit			= checkForNull(paramrs.getString("dis_date_chk_days_unit"));
				diag_update_period_max_unit		= checkForNull(paramrs.getString("diag_update_period_max_unit"));
				serverdate						= checkForNull(paramrs.getString("serverdate"));
			// Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
				chc_for_pen_orders_bfr_dis_adv=checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS_ADV"));
				dis_adv_allow_yn=checkForNull(paramrs.getString("DIS_ADV_ALLOW_YN"));

				chk_pen_ward_rtn_bfr_dis_adv=checkForNull(paramrs.getString("CHK_PEN_WARD_RTN_BFR_DIS_ADV")); //Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
				chk_pen_sale_rtn_bfr_dis_adv	= checkForNull(paramrs.getString("chk_pen_sale_rtn_bfr_dis_adv"),"Y");/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/
					
				// venkatesh KDAH-CRF-0041 END
				
				chc_for_pen_orders_bfr_dischrg =checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS"));
				dischrg_allow_yn  =checkForNull(paramrs.getString("DIS_ALLOW_YN"));
                chk_dis_pat_bt_order_pend=checkForNull(paramrs.getString("CHK_DIS_PAT_BT_ORDER_PEND"));//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
                trans_yn_unfnzed_newborn=checkForNull(paramrs.getString("TRANS_YN_UNFNZED_NEWBORN"));//Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757]
				
				allow_late_discharge_reason=checkForNull(paramrs.getString("allow_late_discharge_reason"));
				disch_reason_mand_yn=checkForNull(paramrs.getString("disch_reason_mand_yn"));
				transfer_wo_delink_yn=checkForNull(paramrs.getString("transfer_wo_delink_yn"));//Added for the CRF HSA-CRF-0035
				
				if(call_function.equals("PrepareDischargeAdvice")){
					mother_cut_off_age			= checkForNull(paramrs.getString("mother_cut_off_age"));
					mother_max_age				= checkForNull(paramrs.getString("mother_max_age"));
				}
				if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					mo_install_yn				=  checkForNull(paramrs.getString("mo_install_yn"),"N");
				pre_disch_appl_yn	= checkForNull(paramrs.getString("pre_disch_appl_yn"));//Added for the CRF -KDAH-CRF-0104  by Dharma
				weight_on_admn_mandatory = checkForNull(paramrs.getString("weight_on_admn_mandatory"));//Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541]
				height_on_admn_mandatory = checkForNull(paramrs.getString("height_on_admn_mandatory"));//Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527
				enable_height_bmi_pat_cls = checkForNull(paramrs.getString("enable_height_bmi_pat_cls"));//Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527
		}	

		if(paramrs != null)			paramrs.close();
		if(paramstmt != null)		paramstmt.close();
		//Added by kishore on 5/15/2004
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(targetURL));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(paramsValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(paramsValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(targetURL));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(mo_install_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(discharge_checklist_app_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed_block_period_dis));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dis_date_chk_days));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(dis_date_chk_days_unit));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(diag_update_period_max_unit));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(allow_late_discharge_reason));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disch_reason_mand_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(allow_discharge_date));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(allow_discharge_date_predc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(mother_cut_off_age));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mother_max_age));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(allow_discharge_date));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(allow_discharge_date_predc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(mother_cut_off_age));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mother_max_age));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(allow_discharge_date));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(allow_discharge_date_predc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(mother_cut_off_age));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mother_max_age));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(allow_discharge_date));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(allow_discharge_date_predc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(mother_cut_off_age));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mother_max_age));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(Lodger_Max_RefNo));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(Lodger_Next_RefNo));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(Lodger_Period));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(Acc_Period));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(Acc_Period_unit));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(IP_param_No_Acc_Persons));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed_block_period_dis));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dis_date_chk_days));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed_block_period_dis));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dis_date_chk_days));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(confirmIP));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(disc_to_date));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disc_from_date));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(confirmIP));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(priotity_status));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(bed_class_allowed));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(dflt_blk_prd_for_tfr_out));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bed_block_period_normal));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(res_reserve_bed_intraward_yn));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(bed_block_period_max));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(bed_block_period_max_type));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(allow_multiple_bed_for_resv_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(mother_cut_off_age));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mother_max_age));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(transfer_wo_delink_yn));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block98Bytes, _wl_block98);

		try
		{

			String nurs_unit_code		= "";
			StringBuffer where_criteria = new StringBuffer();
			StringBuffer where_criteria_count = new StringBuffer();
			StringBuffer sql			= new StringBuffer();
			String class_val			= "QRYODDSMALL";
			String bl_install_yn		=	checkForNull(request.getParameter("bl_install_yn"));
			String bedBlock_normal		=	checkForNull(request.getParameter("bedBlock_normal"));
			String max_blk_type			=	checkForNull(request.getParameter("max_blk_type"));
			String whereClause			=	checkForNull(request.getParameter("whereclause"));
			String whereClauseCount		=	checkForNull(request.getParameter("whereclausecount"));
			String from					=	checkForNull(request.getParameter("from"));
			String to					=	checkForNull(request.getParameter("to"));
			String soundex_type			=	checkForNull(request.getParameter("soundex"));
			String no_of_days			=	checkForNull(request.getParameter("no_of_days"));
			String nursing_unit_code	=	checkForNull(request.getParameter("nursing_unit"));
			String from_nursing_unit	=	checkForNull(request.getParameter("from_nursing_unit"));
			String to_nursing_unit_code	=	checkForNull(request.getParameter("to_nursing_unit"));
			String to_Splcode			=	checkForNull(request.getParameter("to_Splcode"));
			String speciality_code		=	checkForNull(request.getParameter("Splcode"));
			String from_Splcode			=	checkForNull(request.getParameter("from_Splcode"));
			String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
			
			String practitioner_id		=	checkForNull(request.getParameter("practid"));
			String from_practid			=	checkForNull(request.getParameter("from_practid"));
			String from_date			=	checkForNull(request.getParameter("from_date"));
			if(!from_date.equals(""))
				from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
			String to_date				=	checkForNull(request.getParameter("to_date"));
			if(!to_date.equals(""))
				to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
			String chk_in_lodger_min_date= checkForNull(request.getParameter("chk_in_lodger_min_date"));
			String patient_id			=	checkForNull(request.getParameter("patient_id"));
			String gender				=	checkForNull(request.getParameter("gender"));
			String Modified_By				=	checkForNull(request.getParameter("user_name"));
			String modified_date_from	=	checkForNull(request.getParameter("modified_from_date"));
			if(!modified_date_from.equals(""))
				modified_date_from = DateUtils.convertDate(modified_date_from,"DMY",locale,"en"); 
			String modified_date_to		=	checkForNull(request.getParameter("modified_to_date"));
			if(!modified_date_to.equals(""))
				modified_date_to = DateUtils.convertDate(modified_date_to,"DMY",locale,"en"); 
			if(call_function.equals("NEWBORN_REG") || call_function.equals("BabyLinktoMother"))
			{
				gender="F";
			}
			String name_prefix			=	checkForNull(request.getParameter("name_prefix"));
			String name_suffix			=	checkForNull(request.getParameter("name_suffix"));
			String first_name			=	checkForNull(request.getParameter("first_name"));
			String second_name			=	checkForNull(request.getParameter("second_name"));
			String third_name			=	checkForNull(request.getParameter("third_name"));
			String family_name			=	checkForNull(request.getParameter("family_name"));
			//Added by kumar on 18/03/2003 for Malaysia Enhancements
			String searchby				=	checkForNull(request.getParameter("searchby"), "S");
			String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
			String patient_name			= "";
			String nursing_unit_short_desc= "";
			String service_short_desc	= "";
			String subservice_short_desc="";
			String bed_no				= "";
			int baby_count				= 0;
			String room_no				= "";
			String bed_class_short_desc	= "";
			String bed_type_short_desc	= "";
			String to_nursing_unit_short_desc = "";
			String to_bed_class_short_desc = "";
			String to_bed_type_short_desc = "";
			String blocked_bedno		= "";
			String specialty_short_desc	= "";
			String referral_id			= "";
			String practitioner_name	= "";
			String prev_val				= "";
			String prev_val2			= "";
			String Sex					= "";
			String admission_date_time	= "";
			String adm_date_display		= "";
			String discharge_date_time	= "";
			String adt_status			= "";
			String patient_status		= "";
			String ip_leave_status		= "";
			String leave_exp_dt			= "";
			String leave_exp_dt_flag	= "N";
			String date_of_birth		= "";
			String priority				= "";
			String priority_code		= "";
			String pat_dtls_unknown_yn	= "";
			String contact1_name		= "";
			String contact2_name		= "";


			//Added by Devang for Spl. chars
			name_prefix				= singleToDoubleQuotes(name_prefix);
			name_suffix				= singleToDoubleQuotes(name_suffix);
			nursing_unit_code		= singleToDoubleQuotes(nursing_unit_code);
			from_nursing_unit		= singleToDoubleQuotes(from_nursing_unit);
			from_Splcode			= singleToDoubleQuotes(from_Splcode);
			speciality_code			= singleToDoubleQuotes(speciality_code);
			to_nursing_unit_code	= singleToDoubleQuotes(to_nursing_unit_code);
			to_Splcode				= singleToDoubleQuotes(to_Splcode);
			from_practid			= singleToDoubleQuotes(from_practid);
			practitioner_id			= singleToDoubleQuotes(practitioner_id);
			String jsp_name			= checkForNull(request.getParameter("jsp_name"));
			String called_from		= checkForNull(request.getParameter("called_from"));
			String win_height		= checkForNull(request.getParameter("win_height"));
			String dialogTop		= checkForNull(request.getParameter("dialogTop"));
			String win_width		= checkForNull(request.getParameter("win_width"));
			String modal			= checkForNull(request.getParameter("modal"));
			String module			= checkForNull(request.getParameter("module"));
			String model_window		= checkForNull(request.getParameter("model_window"));
		//	String function_id		= checkForNull(request.getParameter("function_id"));


			String prog_id			= checkForNull(request.getParameter("prog_id"));
			String p_practitioner_id= checkForNull(request.getParameter("practitioner_id"));
			call_func				= checkForNull(request.getParameter("call_function"));
			String Disc_Chk			= checkForNull(request.getParameter("Disc_Chk"));
			String bed_class_code	= checkForNull(request.getParameter("Bedcode"));
			String bed_type_code	= checkForNull(request.getParameter("bed_type_code"));
			String cancelled_id		= checkForNull(request.getParameter("cancel_pract_id")); 
			String cancel_reason_desc		= "";
			String discharge_type_desc		= "";
			String discharge_status_desc	= "";
			String location_desc	= "";
			String patient_class	= "";
			
			//Santhosh ML-MMOH-CRF-1894
			String searchBy_first_name			=	checkForNull(request.getParameter("searchBy_first_name"));
			String searchBy_second_name			=	checkForNull(request.getParameter("searchBy_second_name"));
			String searchBy_third_name			=	checkForNull(request.getParameter("searchBy_third_name"));
			String searchBy_family_name			=	checkForNull(request.getParameter("searchBy_family_name"));
				 



			//String allow_emerg_trf_yn	= "";
			if(call_func.equals("CHECK_IN_LODGER"))
				jsp_name = "CheckinLodgerFrames.jsp";

			if(call_func.equals("CHECK_IN_ACCMP_PERSON"))
				jsp_name = "CheckinAccmpPersonFrames.jsp";

			if(call_func.equals("ReferralPatientDetails") || call_func.equals("BedSideReferral"))
				wherecondn = "ADMIT_PAT_YN";
			
            _bw.write(_wl_block99Bytes, _wl_block99);

			if(whereClause.equals(""))
			{
				
				if(call_function.equals("TransferPatientOut"))
				{
						/*
					where_criteria.append(" where a.facility_id='"+facility_id+"' and a.oth_adt_status is null and a.ip_leave_status is null and a.bed_num is not null ");
					10/15/2008 5089_MF-CRF-0017 enhancement*/
				
					where_criteria.append(" where a.facility_id='"+facility_id+"' and a.oth_adt_status is null and a.ip_leave_status is null  ");
					
					where_criteria.append(" AND (a.tfr_req_Status IS NULL OR a.tfr_req_Status = '1') AND a.Encounter_Id = b.Encounter_Id (+) AND a.Facility_Id = b.Facility_Id (+) ");
					// newly adddes this condition For 21855 Venkat S
					if(patient_id!=null && !patient_id.equals("")) {
						where_criteria.append(" and a.patient_id ='" );
						where_criteria.append( ""+patient_id+"'");
					} else {/*Monday, May 03, 2010 , condition added for PE*/
						where_criteria.append(" and a.patient_id like'" );
						where_criteria.append( "%%'");
					}

					if(encounter_id != null && !encounter_id.equals("")) {
						where_criteria.append(" and a.encounter_id='");
						where_criteria.append(""+encounter_id+"'");
					}else{/*Monday, May 03, 2010 , condition added for PE*/
						where_criteria.append(" and a.encounter_id like'");
						where_criteria.append("%%'");
					}

					if(confirmIP.equals("01")) {
						where_criteria.append("	AND b.tfr_req_Status(+) = '1' ");
					} else if (confirmIP.equals("02")) {
						where_criteria.append("	AND b.tfr_req_Status = '1' ");
					}
				}
			
				if(call_function.equals("NEWBORN_REG"))
				{
					where_criteria.append(" where allow_new_born_regn_yn = 'Y' ");
					where_criteria.append(" and a.adt_status = '01' ");
					where_criteria.append(" and a.oth_adt_status is null ");
					where_criteria.append(" and a.bed_num is not null ");
					where_criteria.append(" and (ip_leave_status not in ('3','4') or ip_leave_status is null) ");
					where_criteria.append(" and tfr_req_status is null ");
				}
				if(!call_function.equals("TransferPatientOut") && !call_function.equals("NEWBORN_REG") && !call_function.equals("ChangedAdmDtls"))
				{
					/*
					// Added by Krishnan on 3/23/2004
					if(call_function.equals("TransferPatientIn") || call_function.equals("CancelTransferPatientOut"))
					{
						where_criteria.append(" where a.facility_id='");
					}
					else
					{
						where_criteria.append(" where facility_id='");
					}
					*/
					if(call_function.equals("QueryDischarge"))
					{
						where_criteria.append(" where b.facility_id='"+facility_id+"' ");
						where_criteria_count.append(" where b.facility_id='"+facility_id+"' ");
					}else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					{
						where_criteria_count.append(" where a.facility_id='"+facility_id+"' ");
						where_criteria.append(" where a.facility_id='"+facility_id+"' ");
					}else if(call_function.equals("IPList"))
					{
						where_criteria_count.append(" where a.facility_id='"+facility_id+"' ");
						where_criteria.append(" where a.facility_id='"+facility_id+"' ");
					}
					else
					{
						where_criteria.append(" where a.facility_id='");
						where_criteria.append(facility_id);
						where_criteria.append("' ");
					}
					
					if(call_function.equals("TransferPatientIn"))
					{
						
						where_criteria.append(" AND a.facility_id = b.facility_id ");
						where_criteria.append(" AND a.patient_id = b.patient_id ");
					}
					if(call_function.equals("DischargeCheckList") || call_function.equals("ViewCheckList"))
					if(disc_from_date!=null && !disc_from_date.equals("") && disc_to_date!=null && !disc_to_date.equals(""))
					{
					}
					else
					{
						if(call_function.equals("AdminHist"))
							where_criteria.append(" and adt_status = '08'");
						else if(call_function.equals("IPList"))
							where_criteria.append("  ");
						else if(!(call_function.equals("CHECK_IN_LODGER") || call_function.equals("assign_bed") || call_function.equals("CancelAdmission") || call_function.equals("TransferPatientIn") || call_function.equals("CancelTransferPatientOut") || call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT") || call_function.equals("RepDischargeAdvice"))) 
							where_criteria.append(" and adt_status = '01'");

					}
				}

				/*if(call_function.equals("QueryCancelDischarge"))
				{
					
					where_criteria.append(" and trn_type ='X' ");
				}*/

				if(call_function.equals("QueryCancelDischarge") && cancelled_id!=null && !cancelled_id.equals(""))
				{
					where_criteria.append(" and cancel_disch_practitioner_id='"+cancelled_id+"' ");
				}
				if(!wherecondn.equals(""))
				{
					// Added by Sridhar on Jan 4 2006...
					// This part of the where criteria is required Transfer Patient In and Cancel 	Transfer Patient Out functions...
						if(call_function.equals("TransferPatientIn") )
						{
							if(from_nursing_unit != null && !from_nursing_unit.equals(""))
								where_criteria.append(" and b.NURSING_UNIT_CODE = '"+from_nursing_unit+"'");

							if(from_Splcode != null && !from_Splcode.equals(""))
								where_criteria.append(" and b.SPECIALTY_CODE = '"+from_Splcode+"' ");

							if(from_practid != null && !from_practid.equals(""))
								where_criteria.append(" and b.ATTEND_PRACTITIONER_ID = '"+from_practid+"' ");
							/*
							if(speciality_code != null && !speciality_code.equals(""))
							where_criteria.append(" and REQ_SPECIALTY_CODE = '"+from_Splcode+"' ");

							if(from_practid != null && !from_practid.equals(""))
							where_criteria.append(" and b.ATTEND_PRACTITIONER_ID = '"+from_practid+"' ");
							*/
						}
						/*Tuesday, July 06, 2010 ,condition added for SRR20056-SCF-4783 [IN:022486] by Manoj*/
						else if (call_function.equals("CancelTransferPatientOut") )
						{
							if(from_nursing_unit != null && !from_nursing_unit.equals(""))
								where_criteria.append(" and b.NURSING_UNIT_CODE = '"+from_nursing_unit+"'");
							else
							{
									where_criteria.append(" and exists (Select locn_code from AM_OS_USER_LOCN_ACCESS_VW n where n.facility_id = a.facility_id and n.locn_code = b.nursing_unit_code and n.locn_type = 'N' and n.oper_stn_id='"+oper_stn_id+"' and n.appl_user_id='"+login_user+"' ");
								
									where_criteria.append(" and n.");
									where_criteria.append(wherecondn);
									where_criteria.append("='Y' )"); 												
							}

							if(from_Splcode != null && !from_Splcode.equals(""))
								where_criteria.append(" and b.SPECIALTY_CODE = '"+from_Splcode+"' ");

							if(from_practid != null && !from_practid.equals(""))
								where_criteria.append(" and b.ATTEND_PRACTITIONER_ID = '"+from_practid+"' ");
						}
						

						if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
						{
							if(call_function.equals("TransferPatientIn") || call_function.equals("CancelTransferPatientOut") )
							{
								// Added by Krishnan on 3/23/2004
								// This part of the where criteria is required Transfer Patient In and Cancel Transfer Patient Out functions 
								where_criteria.append(" and REQ_NURSING_UNIT_CODE='");
								where_criteria.append(nursing_unit_code);
								where_criteria.append("' ");
							}
							else if (call_function.equals("CANCEL_DISCHARGE_PATIENT"))
							{
								where_criteria_count.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
								where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
							}
							else if(!call_function.equals("TransferPatientOut")&&!call_function.equals("ChangedAdmDtls")){
								where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
							}
						}
						else
						{
							// Added by Krishnan on 3/23/2004
							//if(call_function.equals("CancelTransferPatientOut") || call_function.equals("TransferPatientIn") || call_function.equals("TransferPatientOut") )/*SRR20056-SCF-3843 IN016276*/
							if(call_function.equals("TransferPatientOut") )
							{
								// Added by Krishnan on 3/23/2004
								// This part of the where criteria is used in Transfer Patient Out function. This condition filters all those nursing units that are attached to the current operator station. 
								
									where_criteria.append(" and exists (Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = a.facility_id and b.locn_code = a.nursing_unit_code and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"' ");
								
									where_criteria.append(" and b.");
									where_criteria.append(wherecondn);
									where_criteria.append("='Y' )"); 
							
														
							}
							/*SRR20056-SCF-3843 IN016276*/
							//else if(call_function.equals("CancelTransferPatientOut") || call_function.equals("TransferPatientIn") )
							else if(call_function.equals("TransferPatientIn") )
							{
		
									where_criteria.append(" and exists (Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = a.facility_id and b.locn_code = a.req_nursing_unit_code and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"' ");
								
									where_criteria.append(" and b.");
									where_criteria.append(wherecondn);
									where_criteria.append("='Y' )"); 
								
														
							}
							else if(!call_function.equals("TransferPatientOut") && !call_function.equals("CancelTransferPatientOut"))/*Tuesday, July 06, 2010 , CancelTransferPatientOut added for SRR20056-SCF-4783 [IN:022486] by Manoj*/
							{
								// This part of the where criteria is used for for all other functions. This condition filters all those nursing units that are attached to the current operator station. 
								//pat_check_in_allowed_yn is added to chk the condition from ip-param
								if(call_function.equals("ReferralPatientDetails"))
								{
									where_criteria.append(" and ip_leave_status is null ");
								}

								where_criteria.append(" and exists (Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = a.facility_id and b.locn_code = a.nursing_unit_code and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"' ");

								if(call_func.equals("ReferralPatientDetails") || call_func.equals("BedSideReferral"))
								{
									where_criteria.append(" )");
								}
								else
								{
									if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")){
									where_criteria.append(" and b.");
									where_criteria.append(wherecondn);
									where_criteria.append("='Y' )"); 
									}else{
									where_criteria.append(" and b.");
									where_criteria.append(wherecondn);
									where_criteria.append("='Y' )"); 

									}
								}
							}
						}
						if(speciality_code!=null && !speciality_code.equals(""))
						  {
							if(call_function.equals("TransferPatientIn") ||  call_function.equals("CancelTransferPatientOut") )
							{
								 where_criteria.append(" and REQ_SPECIALTY_CODE='");
								 where_criteria.append(speciality_code);
								 where_criteria.append("' ");


							}
							else if (call_function.equals("CANCEL_DISCHARGE_PATIENT"))
							{
								where_criteria_count.append(" and a.specialty_code='"+speciality_code+"' ");
								where_criteria.append(" and a.specialty_code='"+speciality_code+"' ");
							}

						  }
						  if(practitioner_id!=null && !practitioner_id.equals(""))
						 {
							 if(call_function.equals("TransferPatientIn") ||  call_function.equals("CancelTransferPatientOut") )
							{
								 where_criteria.append(" and REQ_PRACTITIONER_ID='");
								where_criteria.append(practitioner_id);
								where_criteria.append("' ");


							}

						}
				}
				else
				{				
					if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
					{
						if(call_function.equals("QueryCancelDischarge")){
							where_criteria.append(" and a.fr_nursing_unit_code='");
							// below code added for the 17600
							where_criteria.append(nursing_unit_code);
							where_criteria.append("' ");
							// below code added for the 17600 end here Wednesday, December 23, 2009
						}else if(call_function.equals("QueryDischarge"))
						{
							where_criteria.append(" and b.nursing_unit_code='"+nursing_unit_code+"' ");
							where_criteria_count.append(" and b.nursing_unit_code='"+nursing_unit_code+"' ");
						}else if(call_function.equals("IPList"))
						{
							where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
							where_criteria_count.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
						}
						else
							if(!call_function.equals("ChangedAdmDtls")){
							where_criteria.append(" and a.nursing_unit_code='");
							where_criteria.append(nursing_unit_code);
							where_criteria.append("' ");
						}
					}
				}
				//if(!call_function.equals("TransferPatientOut"))/*Friday, August 07, 2009 IN012638*/
				if(!call_function.equals("TransferPatientOut") && !call_function.equals("TransferPatientIn") && !call_function.equals("CancelTransferPatientOut"))
				/*Tuesday, July 06, 2010 , CancelTransferPatientOut added for SRR20056-SCF-4783 [IN:022486] by Manoj*/
				{
					if(speciality_code!=null && !speciality_code.equals(""))
					{
						if(call_function.equals("QueryCancelDischarge"))
						{
							where_criteria.append(" and a.fr_specialty_code='");
							where_criteria.append(speciality_code);
							where_criteria.append("' ");
						}
						else if(call_function.equals("QueryDischarge"))
						{
							where_criteria_count.append(" and specialty_code='");
							where_criteria_count.append(speciality_code);
							where_criteria_count.append("' ");
							where_criteria.append(" and specialty_code='");
							where_criteria.append(speciality_code);
							where_criteria.append("' ");
							
						}else if(call_function.equals("IPList"))
						{
							where_criteria_count.append(" and a.specialty_code='");
							where_criteria_count.append(speciality_code);
							where_criteria_count.append("' ");
							where_criteria.append(" and a.specialty_code='");
							where_criteria.append(speciality_code);
							where_criteria.append("' ");
						}
						else
						{
							where_criteria.append(" and specialty_code='");
							where_criteria.append(speciality_code);
							where_criteria.append("' ");
						}
					}

					if(practitioner_id!=null && !practitioner_id.equals(""))
					{
							if(!no_of_days.equals(""))
							{
								where_criteria.append(" and practitioner_id='");
								where_criteria.append(practitioner_id);
								where_criteria.append("' ");
							}
							//else if(call_function.equals("AdminHist"))
							//else if(call_function.equals("AdminHist") || call_function.equals("RepDischargeAdvice") || call_function.equals("IPList"))
							else if(call_function.equals("AdminHist") || call_function.equals("RepDischargeAdvice") || call_function.equals("IPList"))
							{
								where_criteria_count.append(" and attend_practitioner_id='");
								where_criteria_count.append(practitioner_id);
								where_criteria_count.append("' ");
								where_criteria.append(" and practitioner_id='");
								where_criteria.append(practitioner_id);
								where_criteria.append("' ");
							}
							else if(call_function.equals("QueryCancelDischarge"))
							{
								where_criteria.append(" and a.fr_practitioner_id='");
								where_criteria.append(practitioner_id);
								where_criteria.append("' ");
							}
							else if(call_function.equals("QueryDischarge"))
							{
								where_criteria_count.append(" and attend_practitioner_id='");
								where_criteria_count.append(practitioner_id);
								where_criteria_count.append("' ");
								where_criteria.append(" and attend_practitioner_id='");
								where_criteria.append(practitioner_id);
								where_criteria.append("' ");
							}
							else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
							{
								where_criteria_count.append(" and a.attend_practitioner_id='");
								where_criteria_count.append(practitioner_id);
								where_criteria_count.append("' ");
								where_criteria.append(" and a.attend_practitioner_id='");
								where_criteria.append(practitioner_id);
								where_criteria.append("' ");
							}
							else if(!call_function.equals("ChangedAdmDtls")){
								where_criteria.append(" and attend_practitioner_id='");
								where_criteria.append(practitioner_id);
								where_criteria.append("' ");
							}
							
						}
					

				}

				if(ServiceCode != null && !ServiceCode.equals(""))
				{
					if(call_function.equals("IPList"))
					{
						where_criteria_count.append(" and SERVICE_CODE='"+ServiceCode+"' ");
						where_criteria.append(" and SERVICE_CODE='"+ServiceCode+"' ");
					}
				}

				if(SubServiceCode != null && !SubServiceCode.equals(""))
				{
					if(call_function.equals("IPList"))
					{
						where_criteria_count.append(" and SUBSERVICE_CODE='"+SubServiceCode+"' ");
						where_criteria.append(" and SUBSERVICE_CODE='"+SubServiceCode+"' ");
					}
				}
				/**
				* sep-1-2008 enhancement of Pateient name  
				*Mod:Ip
				*/
				if(patientName != null && !patientName.equals(""))
				{
					if(call_function.equals("IPList"))
					{
						
						
					//	where_criteria.append(" and UPPER(a.patient_name) like upper('"+patientName+"%') ");
					// Commented by Krishnan on 08/03/2010 for tuning
					//where_criteria.append(" and UPPER(a.patient_name) like replace(UPPER('"+patientName+"%'),' ','%') ");
					/*Wednesday, February 23, 2011,SRR20056-SCF-6968 [IN:026632]*/
						patientName=patientName.replaceAll("'","''");  //GHL-SCF-708 [IN:038170] By Saanthaakumar
						if(locale.equals("en"))
						{
							where_criteria_count.append(" and UPPER(b.patient_name) like replace(UPPER('%"+patientName+"%'),' ','%') ");
							where_criteria.append(" and UPPER(a.patient_name) like replace(UPPER('%"+patientName+"%'),' ','%') ");
						}else
						{
							where_criteria_count.append(" and UPPER(b.patient_name_loc_lang) like replace(UPPER('%"+patientName+"%'),' ','%') ");
							where_criteria.append(" and UPPER(a.patient_name_loc_lang) like replace(UPPER('%"+patientName+"%'),' ','%')");
							
						}
					
					}
				}
			

				if (call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT") || call_function.equals("CHECK_IN_LODGER") || call_function.equals("QueryCancelDischarge"))
				{

					if(call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					{
						if(discharge_type!=null && !discharge_type.equals(""))
							where_criteria.append(" and discharge_type_code = '"+discharge_type+"' ");
					}

					if( call_function.equals("QueryCancelDischarge"))
					{
						if(discharge_type!=null && !discharge_type.equals(""))
							where_criteria.append(" and a.trn_code  = '"+discharge_type+"' ");
						if(discharge_status!=null && !discharge_status.equals(""))
							where_criteria.append(" and c.discharge_status_code  = '"+discharge_status+"' ");

					}

	
					if(from_date!=null && !from_date.equals(""))
					{
						if(call_function.equals("QueryCancelDischarge"))
						{
							where_criteria.append(" and trunc(cancel_disch_date) >= to_date('");
							where_criteria.append(from_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
						}
						/*Thursday, December 24, 2009 , IN017602*/
						else if(call_function.equals("CHECK_IN_LODGER"))
						{
					//where_criteria.append(" and a.facility_id = c.facility_id  and trunc(discharge_date_time) >= to_date('");17879
							where_criteria.append(" and a.facility_id = c.facility_id  and trunc(a.discharge_date_time) >= to_date('");
							where_criteria.append(from_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
						}else if(call_function.equals("QueryDischarge"))
						{
							where_criteria_count.append(" and trunc(discharge_date_time) >= to_date('");
							where_criteria_count.append(from_date);
							where_criteria_count.append("' , 'dd/mm/rrrr') ");
							where_criteria.append(" and trunc(discharge_date_time) >= to_date('");
							where_criteria.append(from_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
						}
						/*Friday, February 18, 2011 , added to filter Cancel discharge Patient function based on Admission Date which is passed as from_date from Criteria page*/
						else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
						{
							where_criteria.append(" and trunc(admission_date_time) >= to_date('");
							where_criteria.append(from_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
						}
						else
						{
							where_criteria.append(" and trunc(discharge_date_time) >= to_date('");
						where_criteria.append(from_date);
						where_criteria.append("' , 'dd/mm/rrrr') ");
						}
						/* 17879 */
						if(call_function.equals("CHECK_IN_LODGER"))
						{
						where_criteria.append(" and (c.CHK_IN_LODGER_MAX_PERIOD >= (sysdate - a.discharge_date_time) * 24) ");
						/*   17879 Wednesday, January 06, 2010 (venkats)
						the current encounter id  of a patient only displayed*/
     					where_criteria.append("and a.patient_id NOT IN(SELECT DISTINCT patient_id FROM ip_open_encounter WHERE patient_id = a.patient_id)");
						where_criteria.append("and (a.facility_id, a.encounter_id) IN( SELECT facility_id, encounter_id FROM ip_patient_last_encounter WHERE (patient_id, discharge_date_time) IN( SELECT   patient_id, MAX(discharge_date_time) discharge_date_time FROM ip_patient_last_encounter WHERE patient_id = a.patient_id ");
						where_criteria.append("GROUP BY patient_id))");
						//end comment.
						}
					}

					if (call_function.equals("CHECK_IN_LODGER"))
					{
						if(from_date==null || from_date.equals(""))
						{
							where_criteria.append(" and a.facility_id = c.facility_id ");
							where_criteria.append(" and trunc(a.discharge_date_time) >= to_date('");
							where_criteria.append(chk_in_lodger_min_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
							where_criteria.append(" and (c.CHK_IN_LODGER_MAX_PERIOD >= (sysdate - a.discharge_date_time) * 24) ");
							/*   17879 Wednesday, January 06, 2010 (venkats)
							the current encounter id  of a patient only displayed*/
     						where_criteria.append("and a.patient_id NOT IN(SELECT DISTINCT patient_id FROM ip_open_encounter WHERE patient_id = a.patient_id)");
							where_criteria.append("and (a.facility_id, a.encounter_id) IN( SELECT facility_id, encounter_id FROM ip_patient_last_encounter WHERE (patient_id, discharge_date_time) IN( SELECT   patient_id, MAX(discharge_date_time) discharge_date_time FROM ip_patient_last_encounter WHERE patient_id = a.patient_id ");
							where_criteria.append("GROUP BY patient_id))");
							//end comment.   
    
						}
					}
					if(to_date!=null && !to_date.equals(""))
					{
						if(call_function.equals("QueryCancelDischarge"))
						{
							where_criteria.append(" and trunc(cancel_disch_date) <= to_date('");
							where_criteria.append(to_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
						}
						/*Thursday, December 24, 2009 , IN017602*/
						else if(call_function.equals("CHECK_IN_LODGER"))
						{
							where_criteria.append(" and a.facility_id = c.facility_id  and trunc(discharge_date_time) <= to_date('");
							where_criteria.append(to_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
						}else if(call_function.equals("QueryDischarge"))
						{
							where_criteria_count.append(" and trunc(discharge_date_time) <= to_date('");
							where_criteria_count.append(to_date);
							where_criteria_count.append("' , 'dd/mm/rrrr') ");
							where_criteria.append(" and trunc(discharge_date_time) <= to_date('");
							where_criteria.append(to_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
						}
						/*Friday, February 18, 2011 , added to filter Cancel discharge Patient function based on Admission Date which is passed as to_date from Criteria page*/
						else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
						{
							where_criteria.append(" and trunc(admission_date_time) <= to_date('");
							where_criteria.append(to_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
						}
						else
						{
							where_criteria.append(" and trunc(discharge_date_time) <= to_date('");
							where_criteria.append(to_date);
							where_criteria.append("' , 'dd/mm/rrrr') ");
						}
					}
				}
				else
				{
					if(!call_function.equals("TransferPatientOut"))
					{
						if(call_function.equals("RepDischargeAdvice"))
						{
							if(from_date!=null && !from_date.equals(""))
							{
								where_criteria.append(" and trunc(discharge_date_time) >= to_date('");
								where_criteria.append(from_date);
								where_criteria.append("' , 'dd/mm/rrrr') ");
							}	
							if(to_date!=null && !to_date.equals(""))
							{
								where_criteria.append(" and trunc(discharge_date_time) <= to_date('");
								where_criteria.append(to_date);
								where_criteria.append("' , 'dd/mm/rrrr') ");
							}
						}
						else
						{
							if(from_date!=null && !from_date.equals(""))
							{
								if(call_function.equals("IPList"))
								{
									where_criteria_count.append(" and trunc(admission_date_time) >= to_date('");
									where_criteria_count.append(from_date);
									where_criteria_count.append("' , 'dd/mm/rrrr') ");
									where_criteria.append(" and trunc(admission_date_time) >= to_date('");
									where_criteria.append(from_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								}else
								{
									where_criteria.append(" and trunc(admission_date_time) >= to_date('");
									where_criteria.append(from_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								}
							}	
							if(to_date!=null && !to_date.equals(""))
							{
								if(call_function.equals("IPList"))
								{
									where_criteria_count.append(" and trunc(admission_date_time) <= to_date('");
									where_criteria_count.append(to_date);
									where_criteria_count.append("' , 'dd/mm/rrrr') ");
									where_criteria.append(" and trunc(admission_date_time) <= to_date('");
									where_criteria.append(to_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								}else
								{
									where_criteria.append(" and trunc(admission_date_time) <= to_date('");
									where_criteria.append(to_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								}
							}
						}
					}
				}

				if(!call_function.equals("TransferPatientOut") && !call_function.equals("ChangedAdmDtls")){
					if(patient_id!=null && !patient_id.equals("")){
						
						if(call_function.equals("QueryDischarge"))
						{
							where_criteria.append(" and b.patient_id like '");
							where_criteria.append(patient_id);
							where_criteria.append("%' ");
							where_criteria_count.append(" and b.patient_id like '");
							where_criteria_count.append(patient_id);
							where_criteria_count.append("%' ");
						}else if(call_function.equals("IPList"))
						{
							where_criteria.append(" and a.patient_id like '");
							where_criteria.append(patient_id);
							where_criteria.append("%' ");
							where_criteria_count.append(" and b.patient_id like '");
							where_criteria_count.append(patient_id);
							where_criteria_count.append("%' ");
						}else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
						{
							where_criteria.append(" and a.patient_id like '");
							where_criteria.append(patient_id);
							where_criteria.append("%' ");
							where_criteria_count.append(" and b.patient_id like '");
							where_criteria_count.append(patient_id);
							where_criteria_count.append("%' ");
						}
						else
						{
							where_criteria.append(" and a.patient_id like '");
							where_criteria.append(patient_id);
							where_criteria.append("%' ");
						}
					}

					if(encounter_id != null && !encounter_id.equals(""))
					{
						if(call_function.equals("QueryDischarge"))
						{
							where_criteria.append(" and b.encounter_id='");
							where_criteria.append(encounter_id);
							where_criteria.append("' ");
							where_criteria_count.append(" and b.encounter_id='");
							where_criteria_count.append(encounter_id);
							where_criteria_count.append("' ");

						}else if(call_function.equals("IPList"))
						{
							where_criteria.append(" and a.encounter_id='");
							where_criteria.append(encounter_id);
							where_criteria.append("' ");
							where_criteria_count.append(" and a.encounter_id='");
							where_criteria_count.append(encounter_id);
							where_criteria_count.append("' ");
						}else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
						{
							where_criteria.append(" and a.encounter_id='");
							where_criteria.append(encounter_id);
							where_criteria.append("' ");
							where_criteria_count.append(" and a.encounter_id='");
							where_criteria_count.append(encounter_id);
							where_criteria_count.append("' ");
						}
						else
						{
							where_criteria.append(" and a.encounter_id='");
							where_criteria.append(encounter_id);
							where_criteria.append("' ");
						}
					}	

					if(gender!=null && !gender.equals(""))
					{
						
						if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
						{
							//where_criteria_count.append(where_criteria.toString());
							where_criteria_count.append(" and b.sex='"+gender+"' ");
							where_criteria.append(" and a.GENDER='");
							where_criteria.append(gender);
							where_criteria.append("' ");
						}
						else if(call_function.equals("QueryDischarge"))
						{
							//where_criteria_count.append(where_criteria.toString());
							where_criteria_count.append(" and a.sex='"+gender+"' ");
							where_criteria.append(" and b.GENDER='");
							where_criteria.append(gender);
							where_criteria.append("' ");
						}
						else
						{
							where_criteria.append(" and b.sex='");
							where_criteria.append(gender);
							where_criteria.append("' ");
						}
						
					}

					if(name_prefix!=null && !name_prefix.equals(""))
					{
						where_criteria.append(" and name_prefix='");
						where_criteria.append(name_prefix);
						where_criteria.append("' ");
					}

					if(name_suffix!=null && !name_suffix.equals(""))
					{
						where_criteria.append(" and name_suffix='");
						where_criteria.append(name_suffix);
						where_criteria.append("' ");
					}	

					if(soundex_type.equals("E"))
					{
						if(first_name!=null && !first_name.equals(""))
						{
							where_criteria.append(" and upper(ethnic_soundex(first_name)) like upper(ethnic_soundex('");
							where_criteria.append(first_name);
							where_criteria.append("')) || '%' ");
						}
						if(second_name!=null && !second_name.equals(""))
						{
							where_criteria.append(" and upper(ethnic_soundex(second_name)) like 	upper(ethnic_soundex('");
							where_criteria.append(second_name);
							where_criteria.append("')) || '%' ");
						}
						if(third_name!=null && !third_name.equals(""))
						{
							where_criteria.append(" and upper(ethnic_soundex(third_name)) like upper(ethnic_soundex('");
							where_criteria.append(third_name);
							where_criteria.append("')) || '%' ");
						}	
						if(family_name!=null && !family_name.equals(""))
						{
							//Added for Malaysia Enhancements on 18/03/2003 by kumar
							fam_name_search = "";
							if (pat_name_as_multipart_yn.equals("N"))
							{
								StringTokenizer stktok = new StringTokenizer(family_name, " ");
								if (stktok.hasMoreTokens())
									fam_name_search = stktok.nextToken();
								else
									fam_name_search = family_name;
							}
							else
								fam_name_search = family_name;

							where_criteria.append(" and upper(ethnic_soundex(family_name)) like upper(ethnic_soundex('");
							where_criteria.append(fam_name_search);
							where_criteria.append("')) || '%' ");
						}
					}
					else if(soundex_type.equals("G"))
					{
						if(first_name!=null && !first_name.equals(""))
						{
							where_criteria.append(" and upper(soundex(first_name)) like upper(soundex('");
							where_criteria.append(first_name);
							where_criteria.append("')) || '%' ");
						}
						if(second_name!=null && !second_name.equals(""))
						{
							where_criteria.append(" and upper(soundex(second_name)) like upper(soundex('");
							where_criteria.append(second_name);
							where_criteria.append("')) || '%' ");
						}
						if(third_name!=null && !third_name.equals(""))
						{
							where_criteria.append(" and upper(soundex(third_name)) like upper(soundex('");
							where_criteria.append(third_name);
							where_criteria.append("')) || '%' ");
						}
						if(family_name!=null && !family_name.equals(""))
						{
							fam_name_search = "";
							if (pat_name_as_multipart_yn.equals("N"))
							{
								StringTokenizer stktok = new StringTokenizer(family_name, " ");
								if (stktok.hasMoreTokens())
									fam_name_search = stktok.nextToken();
								else
									fam_name_search = family_name;
							}
							else
								fam_name_search = family_name;

							where_criteria.append(" and upper(soundex(family_name)) like upper(soundex('");
							where_criteria.append(fam_name_search);
							where_criteria.append("')) || '%' ");
						}
					}
					else
					{
						//Added by kumar on 18/03/2003 for Malaysia Enhancements.
						if (pat_name_as_multipart_yn.equals("Y"))
						{
							if(first_name!=null && !first_name.equals(""))
							{
								where_criteria.append(" and upper(first_name) like upper('");
								where_criteria.append(first_name);
								where_criteria.append("') || '%' ");
							}

							if(second_name!=null && !second_name.equals(""))
							{
								where_criteria.append(" and upper(second_name) like upper('" );
								where_criteria.append(second_name);
								where_criteria.append("') || '%' ");
							}

							if(third_name!=null && !third_name.equals(""))
							{
								where_criteria.append(" and upper(third_name) like upper('");
								where_criteria.append(third_name);
								where_criteria.append("') || '%' ");
							}

							if(family_name!=null && !family_name.equals(""))
							{
								where_criteria.append(" and upper(family_name) like upper('" );
								where_criteria.append(family_name);
								where_criteria.append("') || '%' ");
							}
						}
						else
						{	
							if (searchby.equals("C"))
							{
								if(!family_name.equals(""))
								{
									where_criteria.append(" and upper(family_name) like '%' || upper('");
									where_criteria.append(family_name);
									where_criteria.append("') || '%' ");
								}
							}
							else if (searchby.equals("E"))
							{
								if(!family_name.equals(""))
								{
									where_criteria.append(" and upper(family_name) like '%' || upper('");
									where_criteria.append(family_name);
									where_criteria.append("') ");			  						}
							}
							else
							{
								if(!family_name.equals(""))
								{
									where_criteria.append(" and upper(family_name) like upper('");
									where_criteria.append(family_name);
									where_criteria.append("') || '%' ");
								}
							}
						}
					}
				}
				
				if( p_practitioner_id!=null && !p_practitioner_id.equals(""))
				{
					where_criteria.append(" and (practitioner_id ='");
					where_criteria.append( p_practitioner_id);
					where_criteria.append("'  ");
					where_criteria.append(" or encounter_id in ");
					where_criteria.append("(select encounter_id  ");
					where_criteria.append(" from PR_ENCOUNTER_PRACT ");
					where_criteria.append(" where operating_facility_Id= '");
					where_criteria.append(facility_id);
					where_criteria.append("'  ");
					where_criteria.append(" and practitioner_id= '");
					where_criteria.append(p_practitioner_id);
					where_criteria.append("' )) ");
				}

				// This part of the where criteria is specific to discharge patient where the patient who are on leave are filtered, and only those patients who have their discharge advice created are selected.

				
				if(call_function.equals("DischargePatient"))
				{
					//where_criteria.append(" and (a.ip_leave_status is null or a.ip_leave_status != '1') and a.oth_adt_status = '7' ");
					where_criteria.append(" and (a.ip_leave_status is null or a.ip_leave_status != '1') ");
					/*Tuesday, November 23, 2010 , condition added for PMG20089-CRF-0862-IN024492 */
					if(exclude_nda_pats.equals("Y")){
						where_criteria.append("and (a.oth_adt_status = '7')");
					}else{
						where_criteria.append("and (a.oth_adt_status = '7'  or (a.oth_adt_status != 7 or a.oth_adt_status is null))");
					}
				}

				// common conditions added for the functions.. by Sridhar R ON 6/26/2006
				if( call_function.equals("AssignTreatingPract") || call_function.equals("RecordInpatienLeave") || call_function.equals("RequestforTransfer") || call_function.equals("TransferPatient") || call_function.equals("TransferPractitioner") )
				{
					where_criteria.append(" and a.ip_leave_status is null ");
				}

				if( call_function.equals("AssignTreatingPract") || call_function.equals("RecordInpatienLeave") || call_function.equals("RequestforTransfer") || call_function.equals("TransferPatient") || call_function.equals("TransferPractitioner") || call_function.equals("REC_EXP_PROC_DATE") || call_function.equals("MODIFY_SERVICE_FOR_INPATIENT"))
				{
					where_criteria.append(" and a.oth_adt_status is null ");
				}
				
				if( call_function.equals("RecordInpatienLeave") || call_function.equals("TransferPractitioner") || call_function.equals("AssignTreatingPract") )
				{
					where_criteria.append(" and a.tfr_req_status is null ");
				}


				if( call_function.equals("AssignTreatingPract") || call_function.equals("TransferPractitioner") || call_function.equals("RecordInpatienLeave") || call_function.equals("DischargePatient") || call_function.equals("ViewCheckList") || call_function.equals("REG_NEWBORN_FOR_IP") || /*call_function.equals("RequestforTransfer") ||*/ /*call_function.equals("TransferPatient") ||*/ /*call_function.equals("PrepareDischargeAdvice") ||*/ call_function.equals("CHECK_IN_ACCMP_PERSON") )
				{
					//where_criteria.append(" and a.bed_num is not null ");
					if(Disc_Chk.equals("Y"))
						where_criteria.append(" and a.bed_no is not null ");
					else
						where_criteria.append(" and a.bed_num is not null ");

				
				}
				if(call_function.equals("EMERGENCY_TRANSFER")){
					where_criteria.append("and a.ip_leave_status is null and a.oth_adt_status is null  and a.facility_id='"+facility_id+"'");
				}



				if(call_function.equals("DischargeCheckList"))
				{
					if(Disc_Chk.equals("Y"))
						where_criteria.append(" and a.bed_no is not null ");
					else
						where_criteria.append(" and a.bed_num is not null ");
				}


				// This part of the where criteria is used in Assign Bed function where the patient who have not been assigned a bed will be filtered. All those patients who have not returned from leave will not be taken into account.
				if (call_function.equals("assign_bed"))
				{
					if (pat_check_in_allowed_yn.equals("Y"))
						where_criteria.append("and adt_status = '00' ");
					else
						where_criteria.append(" and bed_num is null ");
				}

				if(call_function.equals("REG_NEWBORN_FOR_IP"))
				{
					where_criteria.append(" and exists (select 1 from MP_BIRTH_REGISTER a where a.encounter_facility_id = facility_id and a.mother_encounter_id = encounter_id) ");
				}

				if(call_function.equals("DischargeCheckList") || call_function.equals("ViewCheckList"))
				{
					if((disc_from_date==null || disc_from_date.equals("")) && ( disc_to_date==null || disc_to_date.equals("")) )
						where_criteria.append(" and a.oth_adt_status = '7' ");
				}

				if(call_function.equals("ViewCheckList"))
				{
					where_criteria.append(" and exists (select 1 from ip_discharge_checklist where facility_id = a.facility_id and encounter_id = a.encounter_id) ");
				}
				
				// This part of the where criteriais used in Transfer Patient functions and will filter those patients for whom discharge advice has not been prepared and for those who booking (book bed for transfer) is not made and for those who have not gone on leave.
				if (call_function.equals("TransferPatient"))
				{
					where_criteria.append(" and a.facility_id='"+facility_id+"' ");
				}

				// This part of the where criteria is used in Transfer Patient In and Cancel Transfer Patient Out function.
				//This is used to filter those patients for whom (booking status = 3) transfer patient out has been confirmed and for those whom record no show has been made.
				if( call_function.equals("CancelTransferPatientOut") || call_function.equals("TransferPatientIn") )
				{
					where_criteria.append(" and b.oth_adt_status is null ");
					where_criteria.append(" and b.ip_leave_status is null ");
					where_criteria.append(" and a.tfr_req_status = '3' ");
				}

				if( call_function.equals("CancelTransferPatientOut"))
				{
					where_criteria.append(" and a.facility_id = b.facility_id ");
					where_criteria.append(" and a.encounter_id = b.encounter_id ");
				}
				
				if(call_function.equals("TransferPatientIn"))
				{
					if(bed_class_allowed.equals("Y"))
						where_criteria.append(" and bed_class_req_status = '1' ");
				}

				// This part of the where criteria is used in the Prepare Discharge Advice function.
				// This will fetch those records for whom discharge advice has not been prepared and those who have been assiged a bed.
				if (call_function.equals("PrepareDischargeAdvice"))
				{
					where_criteria.append(" and (leave_expiry_date_time < sysdate or leave_expiry_date_time is null) AND (a.oth_adt_status != 7 or a.oth_adt_status is null)  ");
				}

				if(call_func.equals("CHECK_IN_ACCMP_PERSON"))
				{
					if(ALLOW_GATE_PASS_PRE_DIS_ADV_YN.equals("Y")) // added by mujafar for MO-CRF-20157
					{}
					else{
					where_criteria.append(" and a.oth_adt_status is null  ");}
				}


				// This part of the where criteria is used in Cancel Discharge Advice function
				// This will fetch those patients records for whom discharge advice has been prepared.
				if (call_function.equals("CancelDischargeAdvice"))
				{
					where_criteria.append(" and a.oth_adt_status = '7' ");
				}

				// This part of the where criteria is used in Cancel Admission function.
				// This will fetch those patients records who have been admitted to the facility (Only one record should exist for the encounter) and for those who have not returned from leave.
				if (call_function.equals("CancelAdmission"))
				{
					/*Added by Thamizh selvi on 15th Feb 2017 against MMS-QH-CRF-0182 Start*/
					if(allowCancelAdm){
						where_criteria.append(" and encounter_id in (select a.encounter_id from IP_ADT_TRN a, IP_OPEN_ENCOUNTER b ");
					}/*End*/
					else{
						where_criteria.append(" and (encounter_id,1) in (select a.encounter_id,count(*) from IP_ADT_TRN a, IP_OPEN_ENCOUNTER b ");
					}
					/*Above line commented and below line added for this CRF MMS-QH-CRF-0182*/
					//where_criteria.append(" and (encounter_id) in (select a.encounter_id from IP_ADT_TRN a, IP_OPEN_ENCOUNTER b ");
					//End this CRF MMS-QH-CRF-0182
					where_criteria.append(" where a.facility_id=b.facility_id and a.facility_id='");
					where_criteria.append(facility_id);
					where_criteria.append("' and a.encounter_id=b.encounter_id group by a.encounter_id) ");
				}

				if (call_function.equals("BedSideReferral"))
				{
					where_criteria.append(" and encounter_id in (select from_encounter_id from PR_REFERRAL_REGISTER where from_facility_id = '");
					where_criteria.append(facility_id);
					where_criteria.append("' and bedside_referral_yn = 'Y' and bedside_ref_seen_date is null )" );
				}

				// This part of the where criteria will be used in "Record Expected Discharge" function. 
				//This will fetch all those patient's records for whom discharge advice has not been prepared.
				if (call_function.equals("ExpectedDischarge")) 
				{
					where_criteria.append("  AND ( oth_adt_status IS NULL or oth_adt_status = 1 ) ");
				}

				if (call_function.equals("OrderEntry"))
					where_criteria.append(" and bed_no is not null ");
				if (call_function.equals("IpInternalReportReprint"))
					where_criteria.append(" ");	
				if (call_function.equals("ReferralPatientDetails")){
					where_criteria.append(" ");	
					
					//Santhosh start ML-MMOH-CRF-1894
										
					if(first_name!=null && !first_name.equals("")){
						if(searchBy_first_name.equals("E"))
						{
							where_criteria.append(" and upper(first_name) like '%' || upper('" +first_name+"') ");
						}
						if(searchBy_first_name.equals("C"))
						{
							where_criteria.append( " and upper(first_name) like '%' || upper('" +first_name+"') || '%' ");
						}
						if(searchBy_first_name.equals("S"))
						{
							where_criteria.append(" and upper(first_name) like upper('" +first_name+"') || '%' ");
						}
					}
					if(second_name!=null && !second_name.equals("")){
						if(searchBy_second_name.equals("E"))
						{
							where_criteria.append(" and upper(second_name) like '%' || upper('" +second_name+"') ");
						}
						if(searchBy_second_name.equals("C"))
						{
							where_criteria.append( " and upper(second_name) like '%' || upper('" +second_name+"') || '%' ");
						}
						if(searchBy_second_name.equals("S"))
						{
							where_criteria.append(" and upper(second_name) like upper('" +second_name+"') || '%' ");
						}
					}
					if(third_name!=null && !third_name.equals("")){
						if(searchBy_third_name.equals("E"))
						{
							where_criteria.append(" and upper(third_name) like '%' || upper('" +third_name+"') ");
						}	
						if(searchBy_third_name.equals("C"))
						{
							where_criteria.append( " and upper(third_name) like '%' || upper('" +third_name+"') || '%' ");
						}
						if(searchBy_third_name.equals("S"))
						{
							where_criteria.append(" and upper(third_name) like upper('" +third_name+"') || '%' ");
						}
					}
					
					if(family_name!=null && !family_name.equals("")){
						fam_name_search = "";
						if (pat_name_as_multipart_yn.equals("N"))
						{
							StringTokenizer stktok = new StringTokenizer(family_name, " ");
							if (stktok.hasMoreTokens())
								fam_name_search = stktok.nextToken();
							else
								fam_name_search = family_name;
						}
						else
							fam_name_search = family_name;
					
						if(searchBy_family_name.equals("E"))
						{
							where_criteria.append(" and upper(family_name) like '%' || upper('" +fam_name_search+"') ");
						}
						if(searchBy_family_name.equals("C"))
						{
							where_criteria.append(" and upper(family_name) like '%' || upper('" +fam_name_search+"') || '%' ");
						}
						if(searchBy_family_name.equals("S"))
						{
							where_criteria.append(" and upper(family_name) like upper('" +fam_name_search+"') || '%' ");
						}
					}
					//Santhosh END
				}
									

				if( clinic_list.length() >= 4)
				{
					where_criteria.append(" and nursing_unit_code in ");
					where_criteria.append(clinic_list);
					where_criteria.append("");
				}

				if(call_function.equals("DischargeCheckList") || call_function.equals("ViewCheckList") || call_function.equals("REG_NEWBORN_FOR_IP") || call_function.equals("CANCEL_DISCHARGE_PATIENT"))
				{
				
					
					if(disc_from_date!=null && !disc_from_date.equals("") && disc_to_date!=null && !disc_to_date.equals(""))
					{
						where_criteria.append(" AND TRUNC(DISCHARGE_DATE_TIME) between  to_date('"+disc_from_date+"','DD/MM/RRRR') and to_date('"+disc_to_date+"','DD/MM/RRRR') ");
						
						where_criteria_count.append(" AND TRUNC(DISCHARGE_DATE_TIME) between  to_date('"+disc_from_date+"','DD/MM/RRRR') and to_date('"+disc_to_date+"','DD/MM/RRRR') ");
					}
					else if(disc_from_date!=null && !disc_from_date.equals("") && call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					{
						where_criteria_count.append(" AND TRUNC(DISCHARGE_DATE_TIME) >=  to_date('"+disc_from_date+"','DD/MM/RRRR') ");
						where_criteria.append(" AND TRUNC(DISCHARGE_DATE_TIME) >=  to_date('"+disc_from_date+"','DD/MM/RRRR') ");
					}
					else if(disc_to_date!=null && !disc_to_date.equals("") && call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					{
						where_criteria_count.append(" AND TRUNC(DISCHARGE_DATE_TIME) <=  to_date('"+disc_to_date+"','DD/MM/RRRR') ");
						where_criteria.append(" AND TRUNC(DISCHARGE_DATE_TIME) <=  to_date('"+disc_to_date+"','DD/MM/RRRR') ");
					}
				}
				else if(call_function.equals("ChangedAdmDtls")){
					where_criteria_count.append(where_criteria.toString());
					if(patient_id!=null && !patient_id.equals("")){
						where_criteria_count.append(" and b.patient_id like '");
						where_criteria_count.append(patient_id);
						where_criteria_count.append("%' ");
						
						where_criteria.append(" and patient_id like '");
						where_criteria.append(patient_id);
						where_criteria.append("%' ");
					}
					if(encounter_id != null && !encounter_id.equals("")){
						where_criteria.append(" and encounter_id='"+encounter_id+"' ");
						where_criteria_count.append(" and b.encounter_id='"+encounter_id+"' ");
					}	

					if(gender!=null && !gender.equals("")){
						where_criteria.append("and GENDER='"+gender+"' ");
						where_criteria_count.append("AND a.sex = NVL('"+gender+"', a.sex) ");
					}
					if(!practitioner_id.equals("")){
						//where_criteria.append(" and practitioner_id='"+practitioner_id+"' ");
						where_criteria_count.append(" and b.attend_practitioner_id ='"+practitioner_id+"' ");

						where_criteria.append(" and practitioner_id ='"+practitioner_id+"' ");
					}
					if(!nursing_unit_code.equals("")){
						where_criteria.append("AND NURSING_UNIT_CODE='"+nursing_unit_code+"' ");	
						where_criteria_count.append("AND b.NURSING_UNIT_CODE='"+nursing_unit_code+"' ");	
					}
					if(!Modified_By.equals("")){
						where_criteria.append("AND MODIFIED_BY_ID='"+Modified_By+"' ");
						where_criteria_count.append("AND b.MODIFIED_BY_ID='"+Modified_By+"' ");
					}
						where_criteria.append("AND TRUNC (modified_date) >= TO_DATE ('"+modified_date_from+"', 'dd/mm/rrrr')  AND TRUNC (modified_date) <= TO_DATE ('"+modified_date_to+"', 'dd/mm/rrrr')");
						where_criteria_count.append("AND TRUNC (b.modified_date) >= TO_DATE ('"+modified_date_from+"', 'dd/mm/rrrr')  AND TRUNC (b.modified_date) <= TO_DATE ('"+modified_date_to+"', 'dd/mm/rrrr')");
				}
			}//E.O BUILDING WHERE-CLAUSE
			else
			{
				where_criteria.append( whereClause) ;
				where_criteria_count.append( whereClauseCount) ;
			}
			int start = 0 ;
			int end = 0 ;
			int i=1;
			
			if (from.equals(""))
				start = 1 ;
			else
				start = Integer.parseInt( from ) ;
			
			if (to.equals(""))
				end = 12 ;
			else
				end = Integer.parseInt( to ) ;
			// The SQL below is constructed to count the number of record returned for the given criteria. The corresponding tables are used for the respective functions.
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" select count(*) ");
			
			if (call_function.equals("RepDischargeAdvice"))
				sql.append( " from IP_DISCHARGE_ADVICE_VW a "+where_criteria.toString() );
			else if (call_function.equals("CANCEL_DISCHARGE_PATIENT"))
			{
					sql.append( " from IP_PATIENT_LAST_ENCOUNTER a , mp_patient b "+where_criteria_count.toString() );
					sql.append( " and a.encounter_id LIKE '%%' AND a.patient_id = b.patient_id ");
			}
			else if (call_function.equals("QueryDischarge"))
			{
				sql.append( " from IP_PATIENT_LAST_ENCOUNTER b , mp_patient a "+where_criteria_count.toString() );
				sql.append(" and b.encounter_id LIKE '%%' AND a.patient_id = b.patient_id");
			}
			else if (call_function.equals("QueryCancelDischarge"))
			{
					//sql.append( " from IP_ADT_TRN a, MP_PATIENT b "+where_criteria.toString() );
					//added IP_DISCHARGE_ADVICE c in query on 7-7-8 for SCR 3228
					sql.append( " from IP_CANCELLED_DISCHARGE a, MP_PATIENT b ,IP_DISCHARGE_ADVICE c "+where_criteria.toString() );
					sql.append(" and a.patient_id = b.patient_id and a.patient_id=c.patient_id"); 
			}
			else if(call_function.equals("CHECK_IN_LODGER"))
			{
				sql.append( " from IP_PATIENT_LAST_ENCOUNTER a, MP_PATIENT b,ip_param c "+where_criteria.toString() );
				sql.append(" and a.patient_id = b.patient_id "); 
			}
			else if (call_function.equals("AdminHist"))
				sql.append( " from IP_ADMISSION_HISTORY_VW a"+where_criteria.toString() );
			else if (call_function.equals("TransferPatientIn") || call_function.equals("CancelTransferPatientOut"))
			{
				sql.append( " from IP_TRANSFER_REQUEST a, IP_OPEN_ENCOUNTER b, MP_PATIENT c "+where_criteria.toString() );
				sql.append(" and a.patient_id = c.patient_id "); 
			}
			else if (call_function.equals("TransferPatientOut"))
			{
				// added for Transfer Patient Out on Jan 7 2005 by Sridhar R ...
				// all whereclauses are added seperately, as records are fetched from IP_TRANSFER_REQUEST_VW and IP_OPEN_ENCOUNTER_VW based on criteria. ( remove some code below for 21855)
				
				if(name_prefix!=null && !name_prefix.equals(""))
				{
					where_criteria.append(" and c.name_prefix ='" );
					where_criteria.append( ""+name_prefix+"'");
				}
				if(name_suffix!=null && !name_suffix.equals(""))
				{
					where_criteria.append(" and c.name_suffix ='" );
					where_criteria.append( ""+name_suffix+"'");
				}
				
				if(gender!=null && !gender.equals(""))
				{
					where_criteria.append(" and c.sex='");
					where_criteria.append(""+gender+"'");
				}	
				
				if(from_date!=null && !from_date.equals(""))
				{
					where_criteria.append(" and trunc(a.admission_date_time) >= to_date('");
					where_criteria.append(""+from_date+"'");
					where_criteria.append(", 'dd/mm/rrrr') ");
				}	
				if(to_date!=null && !to_date.equals(""))
				{
					where_criteria.append(" and trunc(a.admission_date_time) <= to_date('");
					where_criteria.append(""+to_date+"'");
					where_criteria.append(", 'dd/mm/rrrr') ");
				} 

				if(soundex_type.equals("E"))
				{
					if(first_name!=null && !first_name.equals(""))
					{
						where_criteria.append("and upper(ethnic_soundex(c.first_name)) like upper(ethnic_soundex('" );
						where_criteria.append( ""+first_name+"'");
						where_criteria.append( ")) || '%' ");
					}

					if(second_name!=null && !second_name.equals(""))
					{
						where_criteria.append("and upper(ethnic_soundex(c.second_name)) like upper(ethnic_soundex('" );
						where_criteria.append( ""+second_name+"'");
						where_criteria.append( ")) || '%' ");
					}

					if(third_name!=null && !third_name.equals(""))
					{
						where_criteria.append("and upper(ethnic_soundex(c.third_name)) like upper(ethnic_soundex('" );
						where_criteria.append( ""+third_name+"'");
						where_criteria.append( ")) || '%' ");
					}	

					if(family_name!=null && !family_name.equals(""))
					{
						fam_name_search = "";
						if (pat_name_as_multipart_yn.equals("N"))
						{
							StringTokenizer stktok = new StringTokenizer(family_name, " ");
							if (stktok.hasMoreTokens())
								fam_name_search = stktok.nextToken();
							else
								fam_name_search = family_name;
						}
						else
							fam_name_search = family_name;

						where_criteria.append("and upper(ethnic_soundex(c.family_name)) like upper(ethnic_soundex('" );
						where_criteria.append( ""+family_name+"'");
						where_criteria.append( ")) || '%' ");
					}
				}
				else if(soundex_type.equals("G"))
				{
					if(first_name!=null && !first_name.equals(""))
					{
						where_criteria.append("and upper(soundex(c.first_name)) like upper(soundex('" );
						where_criteria.append( ""+first_name+"'");
						where_criteria.append( ")) || '%' ");
					}

					if(second_name!=null && !second_name.equals(""))
					{
						where_criteria.append("and upper(soundex(c.second_name)) like upper(soundex('" );
						where_criteria.append( ""+second_name+"'");
						where_criteria.append( ")) || '%' ");
					}

					if(third_name!=null && !third_name.equals(""))
					{
						where_criteria.append("and upper(soundex(c.third_name)) like upper(soundex('" );
						where_criteria.append( ""+third_name+"'");
						where_criteria.append( ")) || '%' ");
					}

					if(family_name!=null && !family_name.equals(""))
					{
						fam_name_search = "";
						if (pat_name_as_multipart_yn.equals("N"))
						{
							StringTokenizer stktok = new StringTokenizer(family_name, " ");
							if (stktok.hasMoreTokens())
								fam_name_search = stktok.nextToken();
							else
								fam_name_search = family_name;
						}
						else
							fam_name_search = family_name;

						where_criteria.append("and upper(soundex(c.family_name)) like upper(soundex('" );
						where_criteria.append( ""+family_name+"'");
						where_criteria.append( ")) || '%' ");
					}
				}
				else
				{
					if(pat_name_as_multipart_yn.equals("Y"))
					{
						if(first_name!=null && !first_name.equals(""))
						{
							where_criteria.append("and upper(c.first_name) like upper('" );
							where_criteria.append( ""+first_name+"'");
							where_criteria.append( ") || '%' ");
						}
				
						if(second_name!=null && !second_name.equals(""))
						{
							where_criteria.append("and upper(c.first_name) like upper('" );
							where_criteria.append( ""+second_name+"'");
							where_criteria.append( ") || '%' ");
						}
			
						if(third_name!=null && !third_name.equals(""))
						{
							where_criteria.append("and upper(c.third_name) like upper('" );
							where_criteria.append( ""+third_name+"'");
							where_criteria.append( ") || '%' ");
						}
				
						if(family_name!=null && !family_name.equals(""))
						{
							where_criteria.append("and upper(c.family_name) like upper('" );
							where_criteria.append( ""+family_name+"'");
							where_criteria.append( ") || '%' ");
						}
					}
					else
					{						
						if (searchby.equals("C"))
						{
							if(!family_name.equals(""))
							{
								where_criteria.append("and upper(c.family_name) like '%' || upper('" );
								where_criteria.append( ""+family_name+"'");
								where_criteria.append( ") || '%' ");
							}
						}
						else if (searchby.equals("E"))
						{
							if(!family_name.equals(""))
							{
								where_criteria.append(" and upper(c.family_name) like '%' || upper('" );
								where_criteria.append( ""+family_name+"'");
								where_criteria.append( ") ");
							}
						}
						else
						{
							if(!family_name.equals(""))
							{
								where_criteria.append(" and upper(c.family_name) like upper('" );
								where_criteria.append( ""+family_name+"'");
								where_criteria.append( ") || '%' ");
							}
						}
					}
				}

				if(confirmIP.equals("01"))
				{
					//where_criteria.append("	AND b.tfr_req_Status(+) = '1' "); 21855
					
					if(!nursing_unit_code.equals("") || !speciality_code.equals("") || !practitioner_id.equals(""))
					{
						// From Details  - from IP_OPEN_ENCOUNTER...
						if(from_nursing_unit != null && !from_nursing_unit.equals(""))
							where_criteria.append(" and a.nursing_unit_code='"+from_nursing_unit+"'");

						if(from_Splcode != null && !from_Splcode.equals(""))
							where_criteria.append(" and a.specialty_code='"+from_Splcode+"' ");

						if(from_practid != null && !from_practid.equals(""))
							where_criteria.append(" and a.attend_practitioner_id='"+from_practid+"' ");

						// To Details from  - IP_TRANSFER_REQUEST...
						if(nursing_unit_code != null && !nursing_unit_code.equals(""))
							where_criteria.append(" and b.req_nursing_unit_code='"+nursing_unit_code+"'");

						if(speciality_code != null && !speciality_code.equals(""))
							where_criteria.append(" and b.req_specialty_code='"+speciality_code+"' ");

						if(practitioner_id != null && !practitioner_id.equals(""))
							where_criteria.append(" and b.req_practitioner_id='"+practitioner_id+"' ");
					}
					else
					{
						// From Details - from IP_OPEN_ENCOUNTER...
						if(from_nursing_unit != null && !from_nursing_unit.equals(""))
							where_criteria.append(" and a.nursing_unit_code='"+from_nursing_unit+"'");

						if(from_Splcode != null && !from_Splcode.equals(""))
							where_criteria.append(" and a.specialty_code='"+from_Splcode+"' ");

						if(from_practid != null && !from_practid.equals(""))
							where_criteria.append(" and a.attend_practitioner_id='"+from_practid+"' ");
					}
				}
				else if (confirmIP.equals("02"))
				{
					//where_criteria.append("	AND b.tfr_req_Status = '1' "); 21855
					// From Details - from IP_TRANSFER_REQUEST_VW...
					if(from_nursing_unit != null && !from_nursing_unit.equals(""))
						where_criteria.append(" and a.nursing_unit_code='"+from_nursing_unit+"'");

					if(from_Splcode != null && !from_Splcode.equals(""))
						where_criteria.append(" and a.specialty_code='"+from_Splcode+"' ");

					if(from_practid != null && !from_practid.equals(""))
						where_criteria.append(" and a.attend_practitioner_id='"+from_practid+"' ");

					// To Details - from IP_TRANSFER_REQUEST_VW...
					if(nursing_unit_code != null && !nursing_unit_code.equals(""))
						where_criteria.append(" and b.req_nursing_unit_code='"+nursing_unit_code+"'");

					if(speciality_code != null && !speciality_code.equals(""))
						where_criteria.append(" and b.req_specialty_code='"+speciality_code+"' ");

					if(practitioner_id != null && !practitioner_id.equals(""))
						where_criteria.append(" and b.req_practitioner_id='"+practitioner_id+"' ");
				}

				sql.append(" from IP_OPEN_ENCOUNTER a, IP_TRANSFER_REQUEST b, MP_PATIENT c "+where_criteria.toString());
				sql.append(" and a.patient_id = c.patient_id "); 

			}
			else if (call_function.equals("ConfirmBedClass"))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("SELECT count(*) FROM IP_BED_CLASS_REQUEST a, IP_OPEN_ENCOUNTER b, MP_PATIENT c WHERE a.facility_id = '"+facility_id+"' ");

				if(!bed_class_code.equals(""))
					sql.append( " and b.BED_CLASS_CODE = '"+bed_class_code+"' ");

				if(!bed_type_code.equals(""))	
					sql.append( " and b.BED_TYPE_CODE = '"+bed_type_code+"' ");

				if(patient_id!=null && !patient_id.equals(""))
				{
					sql.append(" and a.patient_id ='" );
					sql.append( ""+patient_id+"'");
				}

				if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
				{
					sql.append(" and b.nursing_unit_code ='" );
					sql.append( ""+nursing_unit_code+"'");
				}

				if(name_prefix!=null && !name_prefix.equals(""))
				{
					sql.append(" and c.name_prefix ='" );
					sql.append( ""+name_prefix+"'");
				}
				if(name_suffix!=null && !name_suffix.equals(""))
				{
					sql.append(" and c.name_suffix ='" );
					sql.append( ""+name_suffix+"'");
				}	

				if(practitioner_id!=null && !practitioner_id.equals(""))
				{
					sql.append(" and b.attend_practitioner_id='");
					sql.append(""+practitioner_id+"'");
				}

				if(speciality_code!=null && !speciality_code.equals(""))
				{
					sql.append(" and b.specialty_code='");
					sql.append(""+speciality_code+"'");
				}

				if(encounter_id != null && !encounter_id.equals(""))
				{
					sql.append(" and a.encounter_id='");
					sql.append(""+encounter_id+"'");
				}
				if(gender!=null && !gender.equals(""))
				{
					sql.append(" and c.sex='");
					sql.append(""+gender+"'");
				}	

				if(from_date!=null && !from_date.equals(""))
				{
					sql.append(" and trunc(b.admission_date_time) >= to_date('");
					sql.append(""+from_date+"'");
					sql.append(", 'dd/mm/rrrr') ");
				}	

				if(to_date!=null && !to_date.equals(""))
				{
					sql.append(" and trunc(b.admission_date_time) <= to_date('");
					sql.append(""+to_date+"'");
					sql.append(", 'dd/mm/rrrr') ");
				} 

				if(soundex_type.equals("E"))
				{
					if(first_name!=null && !first_name.equals(""))
					{
						sql.append("and upper(ethnic_soundex(c.first_name)) like upper(ethnic_soundex('" );
						sql.append( ""+first_name+"'");
						sql.append( ")) || '%' ");
					}

					if(second_name!=null && !second_name.equals(""))
					{
						sql.append("and upper(ethnic_soundex(c.second_name)) like upper(ethnic_soundex('" );
						sql.append( ""+second_name+"'");
						sql.append( ")) || '%' ");
					}

					if(third_name!=null && !third_name.equals(""))
					{
						sql.append("and upper(ethnic_soundex(c.third_name)) like upper(ethnic_soundex('" );
						sql.append( ""+third_name+"'");
						sql.append( ")) || '%' ");
					}	

					if(family_name!=null && !family_name.equals(""))
					{
						fam_name_search = "";
						if (pat_name_as_multipart_yn.equals("N"))
						{
							StringTokenizer stktok = new StringTokenizer(family_name, " ");
							if (stktok.hasMoreTokens())
								fam_name_search = stktok.nextToken();
							else
								fam_name_search = family_name;
						}
						else
							fam_name_search = family_name;

						sql.append("and upper(ethnic_soundex(c.family_name)) like upper(ethnic_soundex('" );
						sql.append( ""+family_name+"'");
						sql.append( ")) || '%' ");
					}
				}
				else if(soundex_type.equals("G"))
				{
					if(first_name!=null && !first_name.equals(""))
					{
						sql.append("and upper(soundex(c.first_name)) like upper(soundex('" );
						sql.append( ""+first_name+"'");
						sql.append( ")) || '%' ");
					}

					if(second_name!=null && !second_name.equals(""))
					{
						sql.append("and upper(soundex(c.second_name)) like upper(soundex('" );
						sql.append( ""+second_name+"'");
						sql.append( ")) || '%' ");
					}

					if(third_name!=null && !third_name.equals(""))
					{
						sql.append("and upper(soundex(c.third_name)) like upper(soundex('" );
						sql.append( ""+third_name+"'");
						sql.append( ")) || '%' ");
					}

					if(family_name!=null && !family_name.equals(""))
					{
						fam_name_search = "";
						if (pat_name_as_multipart_yn.equals("N"))
						{
							StringTokenizer stktok = new StringTokenizer(family_name, " ");
							if (stktok.hasMoreTokens())
								fam_name_search = stktok.nextToken();
							else
								fam_name_search = family_name;
						}
						else
							fam_name_search = family_name;

						sql.append("and upper(soundex(c.family_name)) like upper(soundex('" );
						sql.append( ""+family_name+"'");
						sql.append( ")) || '%' ");
					}
				}
				else
				{
					if (pat_name_as_multipart_yn.equals("Y"))
					{
						if(first_name!=null && !first_name.equals(""))
						{
							sql.append("and upper(c.first_name) like upper('" );
							sql.append( ""+first_name+"'");
							sql.append( ") || '%' ");
						}
				
						if(second_name!=null && !second_name.equals(""))
						{
							sql.append("and upper(c.first_name) like upper('" );
							sql.append( ""+second_name+"'");
							sql.append( ") || '%' ");
						}
			
						if(third_name!=null && !third_name.equals(""))
						{
							sql.append("and upper(c.third_name) like upper('" );
							sql.append( ""+third_name+"'");
							sql.append( ") || '%' ");
						}
				
						if(family_name!=null && !family_name.equals(""))
						{
							sql.append("and upper(c.family_name) like upper('" );
							sql.append( ""+family_name+"'");
							sql.append( ") || '%' ");
						}
					}
					else
					{						
						if (searchby.equals("C"))
						{
							if(!family_name.equals(""))
							{
								sql.append("and upper(c.family_name) like '%' || upper('" );
								sql.append( ""+family_name+"'");
								sql.append( ") || '%' ");
							}
						}
						else if (searchby.equals("E"))
						{
							if(!family_name.equals(""))
							{
								sql.append(" and upper(c.family_name) like '%' || upper('" );
								sql.append( ""+family_name+"'");
								sql.append( ") ");
							}
						}
						else
						{
							if(!family_name.equals(""))
							{
								sql.append(" and upper(c.family_name) like upper('" );
								sql.append( ""+family_name+"'");
								sql.append( ") || '%' ");
							}
						}
					}
				}

//here
				sql.append(" and a.request_status = '0' and a.to_nursing_unit_code in ( select a.nursing_unit_code from IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id = '"+facility_id+"' and a.facility_id = b.facility_id and a.nursing_unit_code = b.locn_code and a.locn_type = b.locn_type and b.locn_type = 'N' and a.eff_status = 'E' and b.oper_stn_id = '"+oper_stn_id+"' and b.appl_user_id = '"+login_user+"' and b.bed_class_change_yn = 'Y') and a.facility_id = b.facility_id and a.encounter_id = b.encounter_id and b.oth_adt_status is null and b.ip_leave_status is null and b.patient_id = c.patient_id");
			}
			else if (call_function.equals("BedSideReferral"))
			{
				wc_for_bed_ref = "and bedside_referral_yn = 'Y' and a.facility_id = b.from_facility_id and a.encounter_id = b.from_encounter_id ";
				sql.append( " from IP_OPEN_ENCOUNTER_VW a, PR_REFERRAL_REGISTER b  "+where_criteria.toString()+ " "+wc_for_bed_ref );
			}
			else if(call_function.equals("BabyLinktoMother"))
			{
				sql.append(" FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b, IP_NURSING_UNIT c "+where_criteria.toString()+" and a.facility_id = '"+facility_id+"' and a.facility_id = c.facility_id and c.nursing_unit_code = a.nursing_unit_code and a.patient_id = b.patient_id and c.allow_new_born_regn_yn = 'Y' and baby_delinked_yn = 'Y' and adt_status = '01' and a.ip_leave_status is null and a.oth_adt_status is null and a.bed_num is not null and a.tfr_req_status is null ");
			}
			else if(call_function.equals("NEWBORN_REG"))
			{
				sql.append(" FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b, IP_NURSING_UNIT c "+where_criteria.toString()+" ");
				sql.append(" and a.facility_id = '"+facility_id+"' "); 
				sql.append(" and a.facility_id = c.facility_id ");
				sql.append(" and c.nursing_unit_code = a.nursing_unit_code ");
				sql.append(" and a.Patient_Id = b.Patient_Id ");
			}
			else if(call_function.equals("IPList"))
			{
				// Commented by Krishnan on 08/03/2010 for tuning 
				// sql.append(" FROM IP_OPEN_ENCOUNTER_VW a, MP_PATIENT b "+where_criteria.toString() );
				sql.append(" FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b "+where_criteria_count.toString() );
				sql.append(" and a.patient_id = b.patient_id");
			}
			else if(call_function.equals("ChangedAdmDtls")){
				
				//sql.append(" FROM IP_OPEN_ENCOUNTER  where facility_id='"+facility_id+"' "+where_criteria.toString() );
				/*Wednesday, March 24, 2010 , IN020195 ,mp_patient added for search criteria Gender */
				sql.append(" FROM mp_patient a , IP_OPEN_ENCOUNTER b  where b.facility_id='"+facility_id+"'  AND b.encounter_id LIKE '%%' AND a.patient_id = b.patient_id "+where_criteria_count.toString() );
				sql.append("and b.ENC_MODIFIED_YN='Y' ");
				
			}
			else
			{
				sql.append(" FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b "+where_criteria.toString() );
				sql.append(" and a.patient_id = b.patient_id");
			}

			if(call_function.equals("DischargeCheckList") || call_function.equals("ViewCheckList") || call_function.equals("REG_NEWBORN_FOR_IP"))
			{
				if(disc_from_date!=null && !disc_from_date.equals("") && disc_to_date!=null && !disc_to_date.equals(""))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select count(*) from IP_PATIENT_LAST_ENCOUNTER_VW a "+ where_criteria.toString());
				}
			}

			if(!call_function.equals("ConfirmBedClass"))
			{
				if(call_function.equals("AdminHist"))
					sql.append("order by specialty_short_desc, practitioner_short_name,encounter_id ");
			}

			if(!no_of_days.equals(""))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select a.cnt+b.cnt from (select count(1) cnt from IP_PATIENT_LAST_ENCOUNTER_VW a "+where_criteria.toString()+" and trunc(discharge_date_time) >= trunc(sysdate-"+no_of_days+") ) a, (select count(1) cnt from IP_OPEN_ENCOUNTER_VW a "+where_criteria.toString()+" ) b");
			}
			// below code is added for the 17600 start 
			if(call_function.equals("QueryCancelDischarge"))
			{
				
					sql.append(" AND a.trn_code = c.discharge_type_code ");
			}
			// below code is added for the 17600 end 
			

			/*
			Commented For PE on 4/28/2010
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql.toString());
			
			rs.next();
			int maxRecord=0;
			maxRecord = rs.getInt(1);*/



			if(rs!=null)	rs.close();
			if(stmt!=null)	stmt.close();
			// Added by Devang on 28/09/2002
			// The validation below is done based on the query constructed above. If the query returns no records an error message is displayed.
			/*Commented On 4/28/2010 for PE 
			if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				return;
			}*/
			// The SQL used below is constructed as per the requirements of the respective functions and display the appropriate result.

			if (!call_function.equals("AdminHist"))
			{
				if( call_function.equals("CHECK_IN_LODGER") )
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select room_num room_no, ip_get_desc.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc, ip_get_desc.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, to_char(discharge_date_time,'dd/mm/rrrr hh24:mi') discharge_date_time, b.sex gender, am_get_desc.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc, nursing_unit_code, am_get_desc.AM_PRACTITIONER(admit_practitioner_id,'"+locale+"','1') practitioner_short_name, encounter_id, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.IP_NURSING_UNIT(a.facility_id,nursing_unit_code,'"+locale+"','2')nursing_unit_short_desc, bed_num bed_no, admit_practitioner_id practitioner_id FROM IP_PATIENT_LAST_ENCOUNTER a, MP_PATIENT b,ip_param c "+where_criteria.toString()+" and a.patient_id = b.patient_id ORDER BY specialty_short_desc, practitioner_short_name, a.admission_date_time, a.encounter_id ");
				}
				else if( call_function.equals("QueryDischarge") )
				{
					
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select room_no, bed_class_short_desc, bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,to_char(discharge_date_time,'dd/mm/rrrr hh24:mi') discharge_date_time, gender, specialty_short_desc, nursing_unit_code,attend_practitioner_name practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, nursing_unit_short_desc, bed_no, attend_practitioner_id practitioner_id from IP_PATIENT_LAST_ENCOUNTER_VW b "+where_criteria.toString()+" order by  specialty_short_desc, practitioner_short_name,admission_date_time,encounter_id");
				}else if( call_function.equals("CANCEL_DISCHARGE_PATIENT") )
				{
					
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select room_no, ip_get_desc.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, ip_get_desc.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,to_char(discharge_date_time,'dd/mm/rrrr hh24:mi') discharge_date_time, gender,am_get_desc.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc, nursing_unit_code,am_get_desc.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,'"+locale+"','1') practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, ip_get_desc.IP_NURSING_UNIT(facility_id,nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc, bed_no,attend_practitioner_id practitioner_id ");
					/*Tuesday, June 01, 2010 added for PE*/
					sql.append(",(select count(1)  from ip_open_encounter where facility_id = a.facility_id and patient_id = a.patient_id)open_cnt ");
					/**/
					/*Added by Dharma on 27th Aug 2018 against PMG2018-GHL-CRF-0001 [IN:068328] Start*/
					sql.append(", (SELECT encounter_id FROM ip_patient_last_encounter WHERE discharge_date_time = (SELECT MAX (discharge_date_time) FROM ip_patient_last_encounter WHERE patient_id = a.patient_id AND patient_class IN ('IP', 'DC') AND facility_id = a.facility_id AND discharge_date_time IS NOT NULL) AND patient_id = a.patient_id AND patient_class IN ('IP', 'DC') AND facility_id = a.facility_id AND discharge_date_time IS NOT NULL) latest_dis_enc_id ");
					/*Added by Dharma on 27th Aug 2018 against PMG2018-GHL-CRF-0001 [IN:068328] End*/
					sql.append(" from IP_PATIENT_LAST_ENCOUNTER_VW a "+where_criteria.toString()+" order by  specialty_short_desc, practitioner_short_name,admission_date_time,encounter_id");
				}
				else if( call_function.equals("QueryCancelDischarge"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());

					           
					//sql.append(" SELECT  to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,sex gender, AM_GET_DESC.AM_SPECIALITY(FR_SPECIALTY_CODE,'"+locale+"','2') specialty_short_desc, am_get_desc.AM_PRACTITIONER(fr_practitioner_id,'"+locale+"','2') practitioner_short_name, encounter_id, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang,b.patient_name))patient_name, ip_get_desc.IP_NURSING_UNIT('"+facility_id+"',FR_NURSING_UNIT_CODE,'"+locale+"','2')  nursing_unit_short_desc,to_char(cancel_disch_date,'dd/mm/rrrr hh24:mi') cancel_disch_date,am_get_desc.AM_PRACTITIONER(cancel_disch_practitioner_id,'"+locale+"','2') cancel_disch_practitioner_desc,am_get_desc.AM_CONTACT_REASON(cancel_reason_code,'"+locale+"','1') cancel_reason_desc,IP_GET_DESC.IP_DISCHARGE_TYPE(trn_code,'"+locale+"','2') discharge_type_desc from IP_ADT_TRN a ,mp_patient b  "+where_criteria.toString()+" and a.patient_id=b.patient_id order by IP_GET_DESC.IP_DISCHARGE_TYPE(trn_code,'"+locale+"','2'), patient_id, encounter_id ");

					/*added IP_GET_DESC.IP_DISCHARGE_STATUS(discharge_status_code,'"+locale+"','2') discharge_status_desc  , ip_discharge_advice c ,a.trn_code = c.discharge_type_code on  query 7-7-8 for SCR 3228 */
					//sql.append(" SELECT Distinct to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,sex gender, AM_GET_DESC.AM_SPECIALITY(FR_SPECIALTY_CODE,'"+locale+"','2') specialty_short_desc, am_get_desc.AM_PRACTITIONER(fr_practitioner_id,'"+locale+"','2') practitioner_short_name, a.encounter_id, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang,b.patient_name))patient_name, ip_get_desc.IP_NURSING_UNIT('"+facility_id+"',FR_NURSING_UNIT_CODE,'"+locale+"','2')  nursing_unit_short_desc,to_char(cancel_disch_date,'dd/mm/rrrr hh24:mi') cancel_disch_date,am_get_desc.AM_PRACTITIONER(cancel_disch_practitioner_id,'"+locale+"','2') cancel_disch_practitioner_desc,am_get_desc.AM_CONTACT_REASON(cancel_reason_code,'"+locale+"','1') cancel_reason_desc,IP_GET_DESC.IP_DISCHARGE_TYPE(trn_code,'"+locale+"','2') discharge_type_desc,IP_GET_DESC.IP_DISCHARGE_STATUS(discharge_status_code,'"+locale+"','2') discharge_status_desc from IP_CANCELLED_DISCHARGE a ,mp_patient b , ip_discharge_advice c  "+where_criteria.toString()+" and a.patient_id=b.patient_id and a.patient_id=c.patient_id and a.trn_code = c.discharge_type_code order by IP_GET_DESC.IP_DISCHARGE_TYPE(trn_code,'"+locale+"','2'), patient_id, encounter_id ");
					
					sql.append(" SELECT Distinct to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,sex gender, AM_GET_DESC.AM_SPECIALITY(FR_SPECIALTY_CODE,'"+locale+"','2') specialty_short_desc, am_get_desc.AM_PRACTITIONER(fr_practitioner_id,'"+locale+"','2') practitioner_short_name, a.encounter_id, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang,b.patient_name))patient_name, ip_get_desc.IP_NURSING_UNIT('"+facility_id+"',FR_NURSING_UNIT_CODE,'"+locale+"','2')  nursing_unit_short_desc,to_char(cancel_disch_date,'dd/mm/rrrr hh24:mi') cancel_disch_date,am_get_desc.AM_PRACTITIONER(cancel_disch_practitioner_id,'"+locale+"','2') cancel_disch_practitioner_desc,am_get_desc.AM_CONTACT_REASON(cancel_reason_code,'"+locale+"','1') cancel_reason_desc,IP_GET_DESC.IP_DISCHARGE_TYPE(trn_code,'"+locale+"','2') discharge_type_desc,am_get_desc.am_contact_reason(cancel_reason_code,'"+locale+"','1') discharge_status_desc from IP_CANCELLED_DISCHARGE a ,mp_patient b  "+where_criteria.toString()+" and a.patient_id=b.patient_id  order by IP_GET_DESC.IP_DISCHARGE_TYPE(trn_code,'"+locale+"','2'), patient_id, encounter_id ");

					

				}
				else if (call_function.equals("RepDischargeAdvice"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select room_no, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,to_char(discharge_date_time,'dd/mm/rrrr hh24:mi') discharge_date_time, gender, specialty_short_desc, nursing_unit_code, practitioner_name practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, nursing_unit_short_desc, bed_no, practitioner_id from IP_DISCHARGE_ADVICE_VW  a "+where_criteria.toString()+" order by  specialty_short_desc, practitioner_short_name, to_date(admission_date_time,'dd/mm/rrrr hh24:mi') desc,encounter_id ");
				}
				else
				{
					if(!no_of_days.equals(""))
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" select room_no, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,null discharge_date_time,null deceased_date_time, gender, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc, am_get_desc.AM_SUBSERVICE(SERVICE_CODE, SUBSERVICE_CODE,'"+locale+"','2') subservice_short_desc, nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, IP_GET_DESC.IP_NURSING_UNIT(facility_id,nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc, bed_no, practitioner_id, 0 baby_count, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, NURSING_UNIT_CODE,'"+locale+"','2') location_desc,null maternal_death_yn,null indicator, 'IP' patient_class,a.pat_ser_grp_code,to_char(a.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(a.date_of_birth) age  from IP_OPEN_ENCOUNTER_VW a "+where_criteria.toString()+" UNION ALL select room_no, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, to_char(discharge_date_time,'dd/mm/rrrr hh24:mi') discharge_date_time,to_char(deceased_date_time,'dd/mm/rrrr hh24:mi') deceased_date_time, gender, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc, am_get_desc.AM_SUBSERVICE(SERVICE_CODE, SUBSERVICE_CODE,'"+locale+"','2') subservice_short_desc, nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1') practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, IP_GET_DESC.IP_NURSING_UNIT(facility_id,nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc, bed_no, practitioner_id, 0 baby_count, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, NURSING_UNIT_CODE,'"+locale+"','2') location_desc,case when a.discharge_type_code is not null then (select maternal_death_yn from ip_discharge_type where discharge_type_code = a.discharge_type_code ) end maternal_death_yn, case when 	a.discharge_type_code is not null then (select indicator from ip_discharge_type  where discharge_type_code = a.discharge_type_code ) end indicator, 'IP' patient_class ,a.pat_ser_grp_code,to_char(a.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(a.date_of_birth) age from IP_PATIENT_LAST_ENCOUNTER_VW a"+where_criteria.toString()+" and trunc(discharge_date_time) >= trunc(sysdate-"+no_of_days+") order by specialty_short_desc, practitioner_short_name, admission_date_time, encounter_id");
					}
					else
					{
							
						if ( call_function.equals( "TransferPatientIn" ) )
						{
							if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append("select to_char(b.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.room_num room_no, b.bed_num bed_no, AM_GET_DESC.AM_SPECIALITY(b.specialty_code,'"+locale+"','2') specialty_short_desc, b.nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(b.attend_PRACTITIONER_ID,'"+locale+"','1') practitioner_short_name, IP_GET_DESC.IP_NURSING_UNIT(b.FACILITY_ID, b.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, b.attend_practitioner_id practitioner_id, IP_GET_DESC.IP_BED_CLASS(b.bed_class_code,'"+locale+"','2')bed_class_short_desc, IP_GET_DESC.IP_BED_TYPE(b.bed_type_code,'"+locale+"','2')bed_type_short_desc, IP_GET_DESC.IP_BED_CLASS(a.req_bed_class_code,'"+locale+"','2') to_bed_class_short_desc, IP_GET_DESC.IP_BED_TYPE(a.req_bed_type_code,'"+locale+"','2') to_bed_type_short_desc, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.req_NURSING_UNIT_CODE,'"+locale+"','2') to_nursing_unit_short_desc,AM_GET_DESC.AM_PRACTITIONER(A.REQ_PRACTITIONER_ID,'"+locale+"','1') TO_PRACTITIONER_NAME , AM_GET_DESC.AM_SPECIALITY(A.REQ_SPECIALTY_CODE,'"+locale+"','2') TO_SPECIALTY_SHORT_DESC ,a.cancel_reason_code, to_char(a.cancellation_date_time,'dd/mm/rrrr hh24:mi')cancellation_date_time, a.cancelled_by_id, a.CANCEL_REASON_CODE contact_reason, d.sex gender, a.encounter_id, a.patient_id, decode('"+locale+"','en',d.patient_name, nvl(d.patient_name_loc_lang, d.patient_name)) patient_name, IP_GET_DESC.IP_TRANSFER_PRIORITY(a.facility_id, a.priority_code,'"+locale+"','2') PRIORITY_SHORT_DESC, a.PRIORITY_CODE, decode(b.pat_curr_locn_type,'N', IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, b.pat_curr_locn_code,'"+locale+"','2'), 'R', b.pat_curr_locn_code, OP_GET_DESC.OP_CLINIC(b.FACILITY_ID,b.pat_curr_locn_code,'"+locale+"','1')) location_desc ");
							/*Monday, May 03, 2010 , added for PE*/
							sql.append(",(select color_code_scheme FROM IP_TRANSFER_PRIORITY where facility_id=a.facility_id and priority_code = a.priority_code ) color_code_scheme ");
							/**/
							sql.append(" from IP_TRANSFER_REQUEST a, IP_OPEN_ENCOUNTER b, MP_PATIENT d " +where_criteria.toString()+" ");

							sql.append(" and a.facility_id = b.facility_id ");
							sql.append(" and a.Patient_Id = b.Patient_Id ");
							sql.append(" AND b.patient_id = d.patient_id ");

							if(priotity_status.equals("Y"))
								sql.append(" order by priority_code ");
							else
								sql.append(" order by specialty_short_desc, practitioner_short_name, admission_date_time, a.encounter_id "); 
						}
						else if (call_function.equals("CancelTransferPatientOut")) 
						{
							if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append(" select b.room_num room_no, ip_get_desc.IP_BED_CLASS(b.BED_CLASS_CODE,'"+locale+"', '2') bed_class_short_desc, ip_get_desc.ip_bed_type(b.BED_TYPE_CODE,'"+locale+"', '2') bed_type_short_desc, a.REQ_ROOM_NO to_room_no, ip_get_desc.IP_BED_CLASS(a.req_bed_class_code,'"+locale+"', '2')to_bed_class_short_desc, ip_get_desc.ip_nursing_unit(a.facility_id,a.REQ_NURSING_UNIT_CODE,'"+locale+"','2') to_nursing_unit_short_desc, ip_get_desc.ip_bed_type(a.REQ_BED_TYPE_CODE,'"+locale+"', '2') to_bed_type_short_desc, TO_CHAR(b.admission_date_time, 'dd/mm/rrrr hh24:mi') admission_date_time, c.sex gender, am_get_desc.AM_SPECIALITY(b.SPECIALTY_CODE,'"+locale+"','2') specialty_short_desc, b.nursing_unit_code nursing_unit_code, am_get_desc.AM_PRACTITIONER(b.ATTEND_PRACTITIONER_ID,'"+locale+"','2') practitioner_short_name, a.encounter_id, a.patient_id, decode('"+locale+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(b.facility_id, b.nursing_unit_code,'"+locale+"', '2') nursing_unit_short_desc, b.bed_num bed_no, B.attend_practitioner_id practitioner_id, a.priority_code, ip_get_desc.IP_TRANSFER_PRIORITY(a.facility_id, a.priority_code,'"+locale+"', '2') priority_short_desc ");
							/*Monday, May 03, 2010 , added for PE*/
							sql.append(",(select color_code_scheme FROM IP_TRANSFER_PRIORITY where facility_id=a.facility_id and priority_code = a.priority_code ) color_code_scheme ");
							/**/
							sql.append(" FROM IP_TRANSFER_REQUEST A, IP_OPEN_ENCOUNTER B, MP_PATIENT C "+where_criteria.toString()+" and a.patient_id = c.patient_id ");
						}
						else if (call_function.equals("BedSideReferral"))
						{
							if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append(" select a.room_no, IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc,  IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.referral_id, a.encounter_id, a.gender, AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specialty_short_desc, a.nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_short_name,a.encounter_id, a.patient_id,to_char(a.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, a.bed_no, a.practitioner_id, a.oth_adt_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, decode(a.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.pat_curr_locn_code,'"+locale+"','2'), 'R',AM_GET_DESC.AM_FACILITY_ROOM(a.FACILITY_ID, a.pat_curr_locn_code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"','1')) location_desc from IP_OPEN_ENCOUNTER_VW a, PR_REFERRAL_REGISTER b "+where_criteria.toString() +" "+wc_for_bed_ref );
							
							String order_by = " order by specialty_short_desc, practitioner_short_name, to_date(admission_date_time, 'DD/MM/RRRR HH24:MI') ";
							sql.append(order_by);
						}
						else if(call_function.equals("ConfirmBedClass"))
						{
							if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append(" SELECT TO_CHAR (b.admission_date_time,'dd/mm/rrrr hh24:mi' ) admission_date_time, gender,AM_GET_DESC.AM_SPECIALITY(b.specialty_code,'"+locale+"','2') specialty_short_desc, b.nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(b.PRACTITIONER_ID,'"+locale+"','1') practitioner_short_name, a.encounter_id, a.patient_id,TO_CHAR (b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth,decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, IP_GET_DESC.IP_NURSING_UNIT(b.FACILITY_ID, b.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, b.bed_no, b.room_no, IP_GET_DESC.IP_BED_CLASS(b.bed_class_code,'"+locale+"','2') bed_class_short_desc,b.blocked_bed_no, b.practitioner_id, b.oth_adt_status, b.leave_expiry_date_time, DECODE(SIGN ((b.leave_expiry_date_time - SYSDATE)),-1, 'Y','N') leave_flag, DECODE(b.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(b.FACILITY_ID, b.pat_curr_locn_code,'"+locale+"','2'), 'R',AM_GET_DESC.AM_FACILITY_ROOM(b.FACILITY_ID, b.pat_curr_locn_code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(b.FACILITY_ID,b.pat_curr_locn_code,'"+locale+"','1')) location_desc, IP_GET_DESC.IP_BED_TYPE(b.bed_type_code,'"+locale+"','2') bed_type_short_desc FROM IP_BED_CLASS_REQUEST_VW a, IP_OPEN_ENCOUNTER_VW b WHERE a.facility_id = '"+facility_id+"' ");

							//sql.append(" SELECT TO_CHAR (b.admission_date_time,'dd/mm/rrrr hh24:mi' ) admission_date_time, gender,AM_GET_DESC.AM_SPECIALITY(b.specialty_code,'"+locale+"','2') specialty_short_desc, b.nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(b.PRACTITIONER_ID,'"+locale+"','1') practitioner_short_name, a.encounter_id, a.patient_id,TO_CHAR (b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth,decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, IP_GET_DESC.IP_NURSING_UNIT(b.FACILITY_ID, b.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, b.bed_no, b.room_no, IP_GET_DESC.IP_BED_CLASS(b.bed_class_code,'"+locale+"','2') bed_class_short_desc,b.blocked_bed_no, b.practitioner_id, b.oth_adt_status, b.leave_expiry_date_time, DECODE(SIGN ((b.leave_expiry_date_time - SYSDATE)),-1, 'Y','N') leave_flag, DECODE(b.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(b.FACILITY_ID, b.pat_curr_locn_code,'"+locale+"','2'), 'R',AM_GET_DESC.AM_FACILITY_ROOM(b.FACILITY_ID, b.pat_curr_locn_code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(b.FACILITY_ID,b.pat_curr_locn_code,'"+locale+"','1')) location_desc, IP_GET_DESC.IP_BED_TYPE(b.bed_type_code,'"+locale+"','2') bed_type_short_desc FROM IP_BED_CLASS_REQUEST_VW a, IP_OPEN_ENCOUNTER_VW b WHERE a.facility_id = '"+facility_id+"' and a.REQ_BED_CLASS_CODE=b.bed_class_code and a.REQ_BED_TYPE_CODE=b.bed_type_code ");
						
						
							
							if(!bed_class_code.equals(""))
								sql.append( " and b.BED_CLASS_CODE = '"+bed_class_code+"' ");

							if(!bed_type_code.equals(""))	
								sql.append( " and b.BED_TYPE_CODE = '"+bed_type_code+"' ");


							if(patient_id!=null && !patient_id.equals(""))
							{
								sql.append(" and a.patient_id ='" );
								sql.append( ""+patient_id+"'");
							}
							
							if(encounter_id != null && !encounter_id.equals(""))
							{
								sql.append(" and a.encounter_id='");
								sql.append(""+encounter_id+"'");
							}
			
							if(gender!=null && !gender.equals(""))
							{
								sql.append(" and b.gender='");
								sql.append(""+gender+"'");
							}

							if(name_prefix!=null && !name_prefix.equals(""))
							{
								sql.append(" and b.name_prefix ='" );
								sql.append( ""+name_prefix+"'");
							}
							if(name_suffix!=null && !name_suffix.equals(""))
							{
								sql.append(" and b.name_suffix ='" );
								sql.append( ""+name_suffix+"'");
							}

							if(practitioner_id!=null && !practitioner_id.equals(""))
							{
								sql.append(" and b.practitioner_id='");
								sql.append(""+practitioner_id+"'");
							}

							if(speciality_code!=null && !speciality_code.equals(""))
							{
								sql.append(" and b.specialty_code='");
								sql.append(""+speciality_code+"'");
							}

							if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
							{
								sql.append(" and b.nursing_unit_code ='" );
								sql.append( ""+nursing_unit_code+"'");
							}

							if(from_date!=null && !from_date.equals(""))
							{
								sql.append(" and trunc(b.admission_date_time) >= to_date('");
								sql.append(""+from_date+"'");
								sql.append(", 'dd/mm/rrrr') ");
							}	

							if(to_date!=null && !to_date.equals(""))
							{
								sql.append(" and trunc(b.admission_date_time) <= to_date('");
								sql.append(""+to_date+"'");
								sql.append(", 'dd/mm/rrrr') ");
							} 

							if(soundex_type.equals("E"))
							{
								if(first_name!=null && !first_name.equals(""))
								{
									sql.append("and upper(ethnic_soundex(first_name)) like upper(ethnic_soundex('" );
									sql.append( ""+first_name+"'");
									sql.append( ")) || '%' ");
								}

								if(second_name!=null && !second_name.equals(""))
								{
									sql.append("and upper(ethnic_soundex(second_name)) like 	upper(ethnic_soundex('" );
									sql.append( ""+second_name+"'");
									sql.append( ")) || '%' ");
								}

								if(third_name!=null && !third_name.equals(""))
								{
									sql.append("and upper(ethnic_soundex(third_name)) like upper(ethnic_soundex('" );
									sql.append( ""+third_name+"'");
									sql.append( ")) || '%' ");
								}	

								if(family_name!=null && !family_name.equals(""))
								{
										fam_name_search = "";
										if (pat_name_as_multipart_yn.equals("N"))
										{
											StringTokenizer stktok = new StringTokenizer(family_name, " ");
											if (stktok.hasMoreTokens())
												fam_name_search = stktok.nextToken();
											else
												fam_name_search = family_name;
										}
									else
										fam_name_search = family_name;

									sql.append("and upper(ethnic_soundex(family_name)) like upper(ethnic_soundex('" );
									sql.append( ""+family_name+"'");
									sql.append( ")) || '%' ");
								}
							}
							else if(soundex_type.equals("G"))
							{
								if(first_name!=null && !first_name.equals(""))
								{
									sql.append("and upper(soundex(first_name)) like upper(soundex('" );
									sql.append( ""+first_name+"'");
									sql.append( ")) || '%' ");
								}

								if(second_name!=null && !second_name.equals(""))
								{
									sql.append("and upper(soundex(second_name)) like upper(soundex('" );
									sql.append( ""+second_name+"'");
									sql.append( ")) || '%' ");
								}

								if(third_name!=null && !third_name.equals(""))
								{
									sql.append("and upper(soundex(third_name)) like upper(soundex('" );
									sql.append( ""+third_name+"'");
									sql.append( ")) || '%' ");
								}

								if(family_name!=null && !family_name.equals(""))
								{
									fam_name_search = "";
									if (pat_name_as_multipart_yn.equals("N"))
									{
										StringTokenizer stktok = new StringTokenizer(family_name, " ");
										if (stktok.hasMoreTokens())
											fam_name_search = stktok.nextToken();
										else
											fam_name_search = family_name;
									}
									else
										fam_name_search = family_name;

									sql.append("and upper(soundex(family_name)) like upper(soundex('" );
									sql.append( ""+family_name+"'");
									sql.append( ")) || '%' ");
								}
							}
							else
							{
								if (pat_name_as_multipart_yn.equals("Y"))
								{
									if(first_name!=null && !first_name.equals(""))
									{
										sql.append("and upper(first_name) like upper('" );
										sql.append( ""+first_name+"'");
										sql.append( ") || '%' ");
									}
		
									if(second_name!=null && !second_name.equals(""))
									{
										sql.append("and upper(first_name) like upper('" );
										sql.append( ""+second_name+"'");
										sql.append( ") || '%' ");
									}
			
									if(third_name!=null && !third_name.equals(""))
									{
										sql.append("and upper(third_name) like upper('" );
										sql.append( ""+third_name+"'");
										sql.append( ") || '%' ");
									}
			
									if(family_name!=null && !family_name.equals(""))
									{
										sql.append("and upper(family_name) like upper('" );
										sql.append( ""+family_name+"'");
										sql.append( ") || '%' ");
									}
								}
								else
								{						
									if (searchby.equals("C"))
									{
										if(!family_name.equals(""))
										{
											sql.append("and upper(family_name) like '%' || upper('" );
											sql.append( ""+family_name+"'");
											sql.append( ") || '%' ");
										}
									}
									else if (searchby.equals("E"))
									{
										if(!family_name.equals(""))
										{
											sql.append(" and upper(family_name) like '%' || upper('" );
											sql.append( ""+family_name+"'");
											sql.append( ") ");
										}
									}
									else
									{
										if(!family_name.equals(""))
										{
											sql.append(" and upper(family_name) like upper('" );
											sql.append( ""+family_name+"'");
											sql.append( ") || '%' ");
										}
									}
								}
							}

// here a.request_status = '0'
							sql.append(" and a.request_status = '0' AND a.to_nursing_unit_code IN ( SELECT a.nursing_unit_code FROM IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b WHERE a.facility_id = '"+facility_id+"'  AND a.facility_id = b.facility_id   AND a.nursing_unit_code = b.locn_code  AND a.locn_type = b.locn_type   AND b.locn_type = 'N'  AND a.eff_status = 'E' AND b.oper_stn_id = '"+oper_stn_id+"'  AND b.appl_user_id = '"+login_user+"' AND b.bed_class_change_yn = 'Y') AND A.FACILITY_ID = b.facility_id and a.encounter_id = b.encounter_id and oth_adt_status is null and ip_leave_status is null ");
				
						}
						else
						{
							//Selection of Bed Type and Bed No added on 23-sep-2004 For assign bed
							String order_by = "";
							if(call_function.equals("IPList"))
							{
								if(sql.length() > 0) sql.delete(0,sql.length());
								sql.append(" select room_no, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,gender, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc,am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc, am_get_desc.AM_SUBSERVICE(SERVICE_CODE, SUBSERVICE_CODE,'"+locale+"','2') subservice_short_desc, nursing_unit_code,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_short_name, encounter_id, patient_id, to_char(date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, bed_no, blocked_bed_no, practitioner_id, oth_adt_status, leave_expiry_date_time, decode(sign(( leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, decode(pat_curr_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.pat_curr_locn_code,'"+locale+"','2'),'R',AM_GET_DESC.AM_FACILITY_ROOM(a.FACILITY_ID, a.pat_curr_locn_code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"','1'))location_desc, patient_class, (select count(*) from MP_BIRTH_REGISTER where ENCOUNTER_FACILITY_ID = a.facility_id and MOTHER_ENCOUNTER_ID = a.encounter_id AND patient_id NOT IN (SELECT patient_id FROM IP_OPEN_ENCOUNTER)) baby_count from IP_OPEN_ENCOUNTER_VW a  "+where_criteria.toString() );
								order_by = " order by specialty_short_desc, practitioner_short_name, to_date(admission_date_time, 'DD/MM/RRRR HH24:MI') ";
								
								
							}
							else if(call_function.equals("ChangedAdmDtls")){
										if(sql.length() > 0) sql.delete(0,sql.length());
										sql.append(" select patient_class,room_no,to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,gender, specialty_short_desc,practitioner_name practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang,patient_name)) patient_name, nursing_unit_short_desc,modified_by_id, am_get_desc.am_contact_reason (contact_reason_code,'"+locale+"',1) contact_reason from IP_OPEN_ENCOUNTER_VW  where facility_id='"+facility_id+"' "+where_criteria.toString()+" and ENC_MODIFIED_YN='Y' order by specialty_short_desc, practitioner_short_name, admission_date_time, to_date(admission_date_time, 'DD/MM/RRRR HH24:MI')   ");

							}else{
								if( call_function.equals("BabyLinktoMother") || call_function.equals("NEWBORN_REG") ) {
									if(sql.length() > 0) sql.delete(0,sql.length());
									sql.append(" SELECT a.Room_num Room_No, ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,'"+locale+"',2) Bed_Class_Short_desc, ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,'"+locale+"',2) Bed_Type_Short_desc, To_char(a.Admission_Date_Time,'dd/mm/rrrr hh24:mi') Admission_Date_Time, b.Sex Gender, Am_Get_desc.Am_speciality(a.Specialty_Code,'"+locale+"',2) Specialty_Short_desc, a.nurSing_Unit_Code, Am_Get_desc.Am_practitioner(a.Attend_Practitioner_Id,'"+locale+"',1) Practitioner_Short_Name, a.Encounter_Id, a.Patient_Id, To_char(b.Date_Of_Birth,'dd/mm/rrrr') Date_Of_Birth, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) Patient_Name, ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.nurSing_Unit_Code,'"+locale+"',2) nurSing_Unit_Short_desc, a.Bed_num Bed_No, a.Blocked_Bed_No, a.Attend_Practitioner_Id Practitioner_Id, a.oth_Adt_Status, a.ip_Leave_Status, a.Leave_exPiry_Date_Time, DECODE(Sign((a.Leave_exPiry_Date_Time - SYSDATE)),-1,'Y','N') Leave_Flag, DECODE(Pat_Curr_Locn_Type,'N', ip_Get_desc.Ip_nursing_unit (a.Facility_Id, Pat_Curr_Locn_Code,'"+locale+"',2), 'R',Pat_Curr_Locn_Code, op_Get_desc.Op_clinic (a.Facility_Id, Pat_Curr_Locn_Code,'"+locale+"',1)) Location_desc, a.Patient_Class FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b, IP_NURSING_UNIT c "+where_criteria.toString()+" ");

									sql.append(" and a.facility_id = '"+facility_id+"' "); 
									sql.append(" and a.facility_id = c.facility_id ");
									sql.append(" and c.nursing_unit_code = a.nursing_unit_code ");
									sql.append(" and a.Patient_Id = b.Patient_Id ");

									if(call_function.equals("BabyLinktoMother")) 
									{
										sql.append("  AND c.Allow_New_Born_regn_yn = 'Y' AND Baby_deLinked_yn = 'Y' AND Adt_Status = '01' AND ip_Leave_Status IS NULL AND oth_Adt_Status IS NULL AND Bed_num IS NOT NULL AND tfr_req_Status IS NULL ");
									}
								}
								else if ((call_function.equals( "RequestforTransfer") || call_function.equals("TransferPatient") || call_function.equals("EMERGENCY_TRANSFER")))
								{
									if(sql.length() > 0) sql.delete(0,sql.length());
									sql.append(" select a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2) bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_num bed_no, a.blocked_bed_no, a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (facility_id, pat_curr_locn_code, '"+locale+"', 2 ), 'R', pat_curr_locn_code, op_get_desc.op_clinic (facility_id, pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class, a.tfr_req_status,calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1)year  from IP_OPEN_ENCOUNTER a, MP_PATIENT b "+where_criteria.toString()+" AND a.patient_id = b.patient_id ");
								}
								else
								{
									/*4029	PMG20089-CRF-0127	IP 1/8/2009*/
									if( call_function.equals("assign_bed")){
										if(sql.length() > 0) sql.delete(0,sql.length());
									
										sql.append(" select a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_num bed_no, a.blocked_bed_no, a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (a.facility_id, pat_curr_locn_code, '"+locale+"', 2 ), 'R', pat_curr_locn_code, op_get_desc.op_clinic (a.facility_id, pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class,calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1)year,CASE WHEN c.grc_prd_for_asgn_bed_mark_arvl IS NOT NULL AND (SYSDATE - admission_date_time) * 24 > c.grc_prd_for_asgn_bed_mark_arvl THEN 'E' ELSE 'N' END asgn_bed_mark_arvl from IP_OPEN_ENCOUNTER a, MP_PATIENT b ,ip_param c "+where_criteria.toString()+" AND a.patient_id = b.patient_id and a.facility_id = c.facility_id");
										/* */
									}else{
										if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")){
										if(sql.length() > 0) sql.delete(0,sql.length());
										sql.append(" select a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, nvl(a.bed_num ,a.blocked_bed_no)bed_no , a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (facility_id, pat_curr_locn_code, '"+locale+"', 2 ), 'R', pat_curr_locn_code, op_get_desc.op_clinic (facility_id, pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class,round((SYSDATE - a.admission_date_time)*24)cutt_of_time from IP_OPEN_ENCOUNTER a, MP_PATIENT b "+where_criteria.toString()+" AND a.patient_id = b.patient_id and a.oth_adt_status is null and a.ip_leave_status is null ");
										}else{ 
										if(sql.length() > 0) sql.delete(0,sql.length());
										if(call_function.equals("PrepareDischargeAdvice")){

											//Added by Sangeetha for GHL-CRF-0412.2 on 04-nov-2016

										SQLRetMedication="SELECT distinct patient_id, store_acknowledge_status store_status FROM ph_ward_return_dtl a, ph_ward_return_hdr b WHERE a.facility_id = b.facility_id AND a.ret_doc_no = b.ret_doc_no AND patient_id = ? and encounter_id=? and store_acknowledge_status is null";

										pstmtward=con.prepareStatement(SQLRetMedication);	
			
										}
										//sql.append(" select a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(b.date_of_birth) age , decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_num bed_no, a.blocked_bed_no, a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (a.pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 2 ), 'R', a.pat_curr_locn_code, op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class,b.pat_dtls_unknown_yn,b.pat_ser_grp_code");
										sql.append(" select a.pre_dis_initiate_yn,a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(b.date_of_birth) age , decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_num bed_no, a.blocked_bed_no, a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (a.pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 2 ), 'R', a.pat_curr_locn_code, op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class,b.pat_dtls_unknown_yn,b.pat_ser_grp_code");//Modified for the CRF -KDAH-CRF-0104  by Dharma

										// changes end fo KDAh 41 and JD006
										if(call_function.equals("DischargePatient")){
											sql.append(" ,(select Or_patient_Order_Pend(a.patient_id,a.facility_id,a.encounter_id,'D') from dual) pend_ord_stats");
											sql.append(",(SELECT count(*) FROM BT_UNIT_REQUEST_DTL x, BT_OUTSTAND_SPECIMENS_VW y WHERE  x.PATIENT_ID=a.patient_Id and y.ORDERED_FACILITY_ID='"+facility_id+"' AND y.EPISODE_TYPE = 'I' AND NVL(x.unit_status, 'UO') IN ('UI') AND x.operating_facility_id = y.operating_facility_id AND y.specimen_no = x.specimen_no AND y.patient_id = x.patient_id) bld_status");//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
										}
										/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/
										if(call_function.equals("PrepareDischargeAdvice") && chk_pen_sale_rtn_bfr_dis_adv.equals("Y") && isRestrictDisAdvSaleRetPend){
											sql.append(",(select ST_SAL_FIN_STATUS(a.patient_id,a.encounter_id,a.facility_id) from dual) pend_sal_ret_fin_stats");
										}
										/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End*/

										if((call_function.equals("PrepareDischargeAdvice") && dis_adv_ot_pend_ord_yn.equals("Y")) || (call_function.equals("DischargePatient") && dis_ot_pend_ord_yn.equals("Y")) ){
											sql.append(",(select ot_allow_discharge_patient(a.facility_id,a.encounter_id,a.patient_id) from dual) isAllowDischargeDisAdv "); 
										}
										 //Maheshwaran K added for TH-KW-CRF-0141.1
										if(call_function.equals("DischargePatient")  && isCoderClearance) 
											{
										//	if(bill_indicator_val.equals("A"))
										//		{
										//		sql.append(" ,'All' bill_indicator ");	
										//		}
											//else {	
												sql.append(" ,bl_get_bill_gen_dtls.get_stage_for_patdisch(a.facility_id,a.patient_id,decode(a.patient_class,'IP','I','DC','D'),a.encounter_id) bill_indicator ");
											//	}
											}
			
										if(call_function.equals("PrepareDischargeAdvice"))
											sql.append(",c.contact1_name,c.contact2_name,(select Or_patient_Order_Pend(a.patient_id,a.facility_id,a.encounter_id,'A') from dual) pend_ord_stats");
										sql.append(" from IP_OPEN_ENCOUNTER a, MP_PATIENT b");

										// changes for KDAh 41 and JD006

										if(call_function.equals("PrepareDischargeAdvice"))
											sql.append(", MP_PAT_REL_CONTACTS c ");
										sql.append(" "+where_criteria.toString()+" AND a.patient_id = b.patient_id ");
										if(call_function.equals("PrepareDischargeAdvice"))
											sql.append("AND b.patient_id=c.patient_id");
										}
									}

								}
								//Maheshwaran K added for TH-KW-CRF-0141.1
								if(call_function.equals("DischargePatient")   && isCoderClearance ) 
									{
									if(!bill_indicator_val.equals("A")){	
										sql.append("   AND  bl_get_bill_gen_dtls.get_stage_for_patdisch(a.facility_id,a.patient_id,decode(a.patient_class,'IP','I','DC','D'),a.encounter_id) = '"+bill_indicator_val+"' ");
									}
									}
								order_by = " order by specialty_short_desc, practitioner_short_name, admission_date_time, to_date(admission_date_time, 'DD/MM/RRRR HH24:MI') ";
							}
							if (!call_function.equals("ConfirmBedClass"))
								sql.append(order_by); 
						}
					}
				}
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,  gender, specialty_short_desc, nursing_unit_code,practitioner_short_name,encounter_id,patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, nursing_unit_short_desc,bed_no,practitioner_id,adt_status from IP_ADMISSION_HISTORY_VW a  "+where_criteria.toString()+" order by specialty_short_desc, practitioner_short_name, admission_date_time, encounter_id ");
			}
			
			if(call_function.equals("TransferPatientOut")) 
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select ip_Get_desc.Ip_bed_class(b.req_bed_class_code,'"+locale+"','2') To_Bed_Class_Short_desc, ip_Get_desc.Ip_bed_type(b.req_bed_type_code,'"+locale+"','2') To_Bed_Type_Short_desc,ip_Get_desc.Ip_nursing_unit(b.Facility_Id,b.req_nurSing_Unit_Code,'"+locale+"','2') To_nurSing_Unit_Short_desc, a.room_num Room_No, ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,'"+locale+"','2') Bed_Class_Short_desc, ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,'"+locale+"','2') Bed_Type_Short_desc, To_char(a.Admission_Date_Time,'dd/mm/rrrr hh24:mi') Admission_Date_Time, a.Encounter_Id, a.Patient_Id, decode('"+locale+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name)) Patient_Name, c.sex Gender, ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.nurSing_Unit_Code,'"+locale+"','2') nurSing_Unit_Short_desc, a.nurSing_Unit_Code, a.bed_num Bed_No, Am_Get_desc.Am_speciality(a.Specialty_Code,'"+locale+"','2') Specialty_Short_desc, a.attend_Practitioner_Id Practitioner_Id, Am_Get_desc.Am_practitioner(a.attend_Practitioner_Id,'"+locale+"','1') Practitioner_Short_Name, IP_GET_DESC.IP_TRANSFER_PRIORITY(b.facility_id, b.priority_code,'"+locale+"','2') Priority_Short_desc, b.priority_code Priority_Code, a.tfr_req_Status, a.tfr_req_Status Status, DECODE(a.Pat_Curr_Locn_Type,'N',ip_Get_desc.Ip_nursing_unit(a.Facility_Id,a.Pat_Curr_Locn_Code,'"+locale+"','2'), 'R',Am_Get_desc.Am_facility_room(a.Facility_Id,a.Pat_Curr_Locn_Code,'"+locale+"','2'), op_Get_desc.Op_clinic(a.Facility_Id,a.Pat_Curr_Locn_Code,'"+locale+"','1')) Location_desc ");
				/*Monday, May 03, 2010 , added for PE*/
				sql.append(",(select color_code_scheme FROM IP_TRANSFER_PRIORITY where facility_id=b.facility_id and priority_code = b.priority_code ) color_code_scheme ");
				/**/
				sql.append(" FROM ");
				sql.append(" IP_OPEN_ENCOUNTER a, IP_TRANSFER_REQUEST b, MP_PATIENT c ");
				sql.append(where_criteria);
				sql.append(" and a.patient_id = c.patient_id");

				if(priotity_status.equals("Y"))
					sql.append(" order by b.PRIORITY_CODE ");
				else
				{
					sql.append(" order by a.admission_date_time, a.encounter_id "); 
				}
			}

			if(call_function.equals("DischargeCheckList") || call_function.equals("ViewCheckList") || call_function.equals("REG_NEWBORN_FOR_IP"))
			if(disc_from_date!=null && !disc_from_date.equals("") && disc_to_date!=null && !disc_to_date.equals(""))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("SELECT TO_CHAR (admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, TO_CHAR(discharge_date_time,'dd/mm/rrrr hh24:mi') DISCHARGE_DATE_TIME, gender,specialty_short_desc, nursing_unit_code, practitioner_name practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, nursing_unit_short_desc, bed_no, practitioner_id, TO_CHAR (date_of_birth,'dd/mm/rrrr hh24:mi') date_of_birth, room_no, bed_class_short_desc, bed_type_short_desc, patient_class from IP_PATIENT_LAST_ENCOUNTER_VW a "+ where_criteria.toString());
			 }

			int maxRecords=0;
//			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);


			pstmt = con.prepareStatement(sql.toString());
			rs= pstmt.executeQuery();

//			rs.last();
//			maxRecord = rs.getRow();
//			rs.beforeFirst();
		/*	if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				return;
			}*/



			// The below code is to print the result in a tabular format.

				out.println("<table align='right' style='display:none' id='navigate_table'><tr><td align ='right'>");
				if ( !(start <= 1) ){
						out.println("<A HREF='../jsp/InpatientLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start-12)+"&to="+(end-12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+URLEncoder.encode(call_func)+"&opst="+URLEncoder.encode(oper_stn_id)+"&current_bill_status="+URLEncoder.encode(current_bill_status)+"&function_id="+URLEncoder.encode(function_id)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				}
						out.println("<A  HREF='../jsp/InpatientLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start+12)+"&to="+(end+12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+ URLEncoder.encode(call_func) +"&opst="+URLEncoder.encode(oper_stn_id)+"&current_bill_status="+URLEncoder.encode(current_bill_status)+"&function_id="+URLEncoder.encode(function_id)+"'"+" text-decoration='none' style='display:none' id='next'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						out.println("</td></tr></table></p>");
						out.println("<br><br>");				
			out.println(" <table cellspacing=0 cellpadding=0 align='center' width='130%' border='1' cellpadding=0 cellspacing=0>");
			//code for Header paint part start
			out.println("<thead id='table_header' style='display:none'>");
						if(call_function.equals("CancelReserveBeds")){
								out.println("<tr>");
								out.println("<th colspan=6>&nbsp;</th>");
								out.println("<th colspan=5 >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReserveBedDetails.label","ip_labels")+"&nbsp;"+"</th>");
								out.println("<th colspan=2>&nbsp;</th>");
								out.println("</tr>");
						}
						// code for Header paint part end
					if(call_function.equals("TransferPatientIn") || call_function.equals("CancelTransferPatientOut") || call_function.equals("TransferPatientOut")){
								out.println("<tr>");
								out.println("<th colspan=6>&nbsp;</th>");
								if(isCurrentLocDtlsAppl){//Added by shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
								out.println("<th colspan=5 >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.current.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDetails.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th colspan=3 >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.To.label","bl_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDetails.label","common_labels")+"&nbsp;"+"</th>");
								}else{
								out.println("<th colspan=5 >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FromDetails.label","ip_labels")+"&nbsp;"+"</th>");
								out.println("<th colspan=3 >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ToDetails.label","ip_labels")+"&nbsp;"+"</th>");}
								if(call_function.equals("TransferPatientIn") || call_function.equals("TransferPatientOut"))
								out.println("<th colspan=3>&nbsp;</th>"); 
								else if(call_function.equals("CancelTransferPatientOut") && priotity_status.equals("Y") )
								out.println("<th colspan=1>&nbsp;</th>"); 
								out.println("</tr>");
					}
						out.println("<tr>");
													out.println("<th>&nbsp;</th>");
						/*ICN 7647 1/19/2009*/
						if(call_function.equals("assign_bed"))
							out.println("<th width = '3%'>&nbsp;</th>");
						/**/
						if(call_function.equals("QueryCancelDischarge")){
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargetype.label","common_labels")+"&nbsp;"+"</th>");
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeStatus.label","ip_labels")+"&nbsp;"+"</th>");
						}else{
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th>");
						}
					if (call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT") || !no_of_days.equals("") || call_function.equals("RepDischargeAdvice") || call_function.equals("CHECK_IN_LODGER")){
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargedatetime.label","common_labels")+"</th>");
						}
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th>");
					if (call_function.equals("BedSideReferral")){
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"&nbsp;"+"</th>");
					}
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th>");
						if (call_function.equals("NEWBORN_REG")){
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")+"&nbsp;"+"</th>");
						}
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"</th>");

						//Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613
						if(isTopupDepositAppl && call_function.equals("IPList")){
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TopupDeposit.label","common_labels")+"&nbsp;"+"</th>");
						}

						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th>");
						//Maheshwaran K added for TH-KW-CRF-0141.1
					if(call_function.equals("DischargePatient")  && isCoderClearance) 	{			 
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CurrentStatus.label","common_labels")+"&nbsp;"+"</th>");	
						}
						if(call_function.equals("ChangedAdmDtls")){
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"&nbsp;"+"</th>");
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"&nbsp;"+"</th>");
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels")+"&nbsp;"+"</th>");
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.modifiedby.label","common_labels")+"&nbsp;"+"</th>");
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels")+"&nbsp;"+"</th>");
						}
						if (call_function.equals("IPList")){
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+"&nbsp;"+"</th>");
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+"&nbsp;"+"</th>");
						}
						if (!show_bed_yn.equals("N")){
									if(!call_function.equals("AdminHist") && !call_function.equals("RepDischargeAdvice") && !call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls")){
										out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+"</th>");
										out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+"&nbsp;"+"</th>");
									}
									if(!call_function.equals("assign_bed") && !call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls") ){
										out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+"</th>");
									}else if(!call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls")){
										if(pat_check_in_allowed_yn.equals("Y")){
											out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedBedNo.label","ip_labels")+"&nbsp;"+"</th>");
										}
									}
									if(!call_function.equals("AdminHist") && !call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls")){
										out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;"+"</th>");
									}
						}
						if ((call_function.equals( "TransferPatientIn" )) || (call_function.equals("CancelTransferPatientOut")) || (call_function.equals("TransferPatientOut"))){
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+"&nbsp;"+"</th>");

								if(priotity_status.equals("Y")){
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"&nbsp;"+"</th>");
								}
						}
						if (call_function.equals("CancelReserveBeds")){
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;"+"</th>");
						}
						if (call_function.equals("IPList")){
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BabyDetails.label","ip_labels")+"&nbsp;"+"</th>");
						}
						/// Added by SRIDHAR R on 6 AUG 2004 
						/// Added for Location
						//Modified by shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
						if(call_function.equals("CHECK_IN_ACCMP_PERSON") || call_function.equals("AssignTreatingPract") || call_function.equals("ExpectedDischarge") || call_function.equals("CancelAdmission") || call_function.equals("TransferPatient") || call_function.equals("TransferPractitioner") || 
						call_function.equals("PrepareDischargeAdvice") ||
						call_function.equals("CancelDischargeAdvice") ||
						call_function.equals("DischargePatient") ||
						call_function.equals("RecordInpatienLeave") ||
						(call_function.equals("TransferPatientIn") && (!isCurrentLocDtlsAppl))||
						(call_function.equals("TransferPatientOut") && (!isCurrentLocDtlsAppl)) ||
						call_function.equals("RequestforTransfer") ||
						call_function.equals("IPList") || call_function.equals("PatMovList") ||call_function.equals("EMERGENCY_TRANSFER") )
						{   
							out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;"+"</th>");
						}

						if(call_function.equals("TransferPatientOut") || call_function.equals("TransferPatientIn")){
							out.println("<th colspan=1 nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"&nbsp;"+"</th>");
						}
						if(call_function.equals("DischargeCheckList") || call_function.equals("ViewCheckList") || call_function.equals("REG_NEWBORN_FOR_IP")){
								if(disc_from_date==null || disc_from_date.equals("") || disc_to_date==null || disc_to_date.equals("")){
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;"+"</th>");
								}else{
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargedatetime.label","common_labels")+"&nbsp;"+"</th>");
								}
						}
						if(call_function.equals("QueryCancelDischarge")){
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"&nbsp;"+"</th>");
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"&nbsp;"+"</th>");
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th>");
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelledDate/Time.label","common_labels")+"&nbsp;"+"</th>");
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelledby.label","common_labels")+"&nbsp;"+"</th>");
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforCancellation.label","common_labels")+"&nbsp;"+"</th>");				
						}
						out.println("</tr>");
			out.println("</thead>");
		
					int initCount				= 1 ;
					int z						= 0 ;
					int records_to_show			= 12 ;
			if(rs!=null)
			{
				if ( start != 0 )
				{
					for( int j=1; j<start; i++,j++ )
					{
						rs.next() ;
					}
					initCount+=start;
					--initCount;
				}
							
				while (rs!=null && (z < records_to_show) && rs.next() )
				{
					
						if(maxRecords==0){
            _bw.write(_wl_block100Bytes, _wl_block100);
}//Added by kishore on 5/15/2004
						z++;
					admission_date_time=rs.getString("admission_date_time");
					if(admission_date_time == null) admission_date_time="&nbsp;";
					if(!admission_date_time.equals("&nbsp;")){
						adm_date_display = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 
					}
					n_Age = 0;
					if (call_function.equals("IpInternalReportReprint")){
							/*commented to get age for the patients when no of days is checked and to reprint age related report(Wrist band label)*/
							//if (no_of_days.equals("") ){
									age=rs.getString("age");
									if(age == null) age="&nbsp;";
									if(age.indexOf("Y") > 0){
										age = age.substring(0,age.indexOf("Y"));
										n_Age = Integer.parseInt(age);
									}
							//}						
					}
					if (call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT") || !no_of_days.equals("") || call_function.equals("RepDischargeAdvice") || call_function.equals("CHECK_IN_LODGER")){
						discharge_date_time=rs.getString("discharge_date_time");
						
					discharge_date_time_display_report=checkForNull(discharge_date_time);//Added this line for this incident [40702]					
						
						if(discharge_date_time == null) discharge_date_time="&nbsp;";
						bed_no = rs.getString("bed_no");
						if(bed_no == null) bed_no="&nbsp;";
						if(call_function.equals("IpInternalReportReprint")){
							deceased_date_time =checkForNull(rs.getString("DECEASED_DATE_TIME"));
							maternal_death_yn  =checkForNull(rs.getString("MATERNAL_DEATH_YN"));
							indicator		   =checkForNull(rs.getString("INDICATOR"));
						}
					}
					specialty_short_desc=rs.getString("specialty_short_desc");
					if(specialty_short_desc == null) specialty_short_desc="&nbsp;";
					encounter_id=rs.getString("encounter_id");
					if(encounter_id == null) encounter_id="";
					if (call_function.equals("BedSideReferral"))
					referral_id=rs.getString("referral_id");
					if(referral_id == null) referral_id="";

					if (call_function.equals("PrepareDischargeAdvice") || call_function.equals("DischargePatient")){
						pend_order_status=rs.getString("pend_ord_stats"); 
						pre_dis_initiate_yn	= rs.getString("pre_dis_initiate_yn"); //Added for the CRF -KDAH-CRF-0104  by Dharma
					}
					//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
					/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/
					if (call_function.equals("PrepareDischargeAdvice") && chk_pen_sale_rtn_bfr_dis_adv.equals("Y") && isRestrictDisAdvSaleRetPend){
						pend_sal_ret_fin_stats=rs.getString("pend_sal_ret_fin_stats"); 
					}
					/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End*/
					
					if((call_function.equals("PrepareDischargeAdvice") && dis_adv_ot_pend_ord_yn.equals("Y")) || (call_function.equals("DischargePatient") && dis_ot_pend_ord_yn.equals("Y"))){
						isAllowDischargeDisAdv=rs.getString("isAllowDischargeDisAdv"); 
					}

					if(call_function.equals("DischargePatient"))
					blood_consump_count=rs.getString("bld_status");
					//End
					Sex =rs.getString("gender");

					patient_id = rs.getString("patient_id");
					if( patient_id == null) patient_id="";
					/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
					int unFinalizedNewBornCnt	= 0;
					if(("TransferPatientOut".equals(call_function) || "TransferPatient".equals(call_function) || "RequestforTransfer".equals(call_function) || "TransferPatientIn".equals(call_function) || "EMERGENCY_TRANSFER".equals(call_function) || "ConfirmBedClass".equals(call_function)) && !"".equals(patient_id) && "F".equals(Sex) && isNewBornChngsAppl && "Y".equals(trans_yn_unfnzed_newborn)){
						unFinalizedNewBornCnt		= eIP.IPCommonBean.getUnfinalizedNewBornCount(con,patient_id);	
						out.println("<input type='hidden' name='unFinalizedNewBornCnt_"+encounter_id+"' id='unFinalizedNewBornCnt_"+encounter_id+"' value='"+unFinalizedNewBornCnt+"'/>");
					}
					/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/

		
					if(Sex == null )
						Sex="";
					else if (Sex.equals("M"))
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if (Sex.equals("F"))
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else 
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					
					/*Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613*/
					if(isTopupDepositAppl && call_function.equals("IPList")){
					
						String  sql6 = " select episode_id, patient_class from pr_encounter where facility_id = '"+facility_id+"' and encounter_id = '"+encounter_id+"' and patient_id = '"+patient_id+"' ";

						pstmt2 = con.prepareStatement(sql6);
						rs2 = pstmt2.executeQuery();

						if( rs2 != null && rs2.next()){
							episode_id = rs2.getInt("episode_id");
							pat_class = checkForNull(rs2.getString("patient_class"));
						}

						if(pstmt2 != null) pstmt2.close();
						if(rs2 != null) rs2.close();

						if(pat_class.equals("IP"))
						{
							episode_type = "I";
						}
						else if(pat_class.equals("DC"))
						{
							episode_type = "D";
						}
																	
						cs = con.prepareCall( "{ call blcommon.bl_topup_deposit_dtls( ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;
						cs.setString(1, facility_id) ;
						cs.setString(2, patient_id) ;
						cs.setString(3, episode_type) ;
						cs.setInt(4, episode_id) ;
						cs.registerOutParameter(5, Types.VARCHAR) ;
						cs.registerOutParameter(6, Types.VARCHAR) ;
						cs.registerOutParameter(7, Types.VARCHAR) ;
						cs.registerOutParameter(8, Types.VARCHAR) ;
						cs.execute() ;							
						Respc = checkForNull(cs.getString(5)) ;

						if(Respc.equals("Y")){
							String  sql7 = " SELECT USERENV ('SESSIONID') session_id, TO_CHAR (SYSDATE, 'DDMMYYHH24MISS') pgm_date FROM DUAL ";

							pstmt2 = con.prepareStatement(sql7);
							rs2 = pstmt2.executeQuery();

							if( rs2 != null && rs2.next()){
								session_id = rs2.getInt("session_id");
								pgm_date = checkForNull(rs2.getString("pgm_date"));
							}
						}
					}
					/*End ML-MMOH-CRF-1613*/
                      
					if (call_function.equals("NEWBORN_REG"))
					{
						date_of_birth = rs.getString("date_of_birth");
							if (date_of_birth == null) date_of_birth = "";

						if(!date_of_birth.equals(""))
							date_of_birth_converted = DateUtils.convertDate(date_of_birth,"DMY","en",locale);
					}

					patient_name=rs.getString("patient_name");
					if ((patient_name == null) || (patient_name.equals("null"))) 
						patient_name="";
					if ( call_function.equals("TransferPatientIn") )
					{
						nurs_unit_code =rs.getString("nursing_unit_code");
							if( nurs_unit_code == null) nurs_unit_code="";
						nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
							if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";
						location_desc=rs.getString("location_desc");
							if(location_desc == null) location_desc="&nbsp;";
					}
					else if (call_function.equals("CancelTransferPatientOut"))
					{
						nurs_unit_code =rs.getString("nursing_unit_code");
							if( nurs_unit_code == null) nurs_unit_code="";
						nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
							if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";
					}
					else 
					{
						
						if (!call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls"))
						{
							nurs_unit_code =rs.getString("nursing_unit_code");
							if( nurs_unit_code == null) nurs_unit_code="";
						}
						nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
							if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";

						if (call_function.equals("IPList"))
						{
							service_short_desc=rs.getString("service_short_desc");
								if(service_short_desc== null) service_short_desc="&nbsp;";
							subservice_short_desc=rs.getString("subservice_short_desc");
								if(subservice_short_desc== null) subservice_short_desc="&nbsp;";
						}
					}

				
					
					
					if (!call_function.equals("CancelTransferPatientOut")&&!call_function.equals("CHECK_IN_LODGER") && !call_function.equals("RepDischargeAdvice") && !call_function.equals("AdminHist") && !call_function.equals("QueryDischarge") && !call_function.equals("CANCEL_DISCHARGE_PATIENT") && !call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls"))
					{
						if(call_function.equals("DischargeCheckList") || call_function.equals("ViewCheckList") || call_function.equals("REG_NEWBORN_FOR_IP"))
						{
							if(disc_from_date!=null && !disc_from_date.equals("") && disc_to_date!=null && !disc_to_date.equals(""))
							{}
							else
							{
							  location_desc = rs.getString("location_desc");
								if(location_desc == null) location_desc = "&nbsp;";
							}
						}
						else
						{
						  location_desc = rs.getString("location_desc");
							if(location_desc == null) location_desc = "&nbsp;";
						}
					}

					if (call_function.equals("TransferPatientIn") ) 
					{
						bed_no = rs.getString("bed_no");
							if( bed_no == null) bed_no="&nbsp;";
					}
					else if (call_function.equals("CancelTransferPatientOut"))
					{
						bed_no = rs.getString("bed_no");
							if( bed_no == null) bed_no="&nbsp;";
					}
					else if (!call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls"))
					{
						
						bed_no = rs.getString("bed_no");
						
						if( bed_no == null){ bed_no="&nbsp;";
						}

						if(call_function.equals("CancelAdmission"))
						{
							if(pat_check_in_allowed_yn.equals("Y"))
							{
								if(bed_no == null) bed_no=rs.getString("blocked_bed_no");
								if(bed_no == null) bed_no="&nbsp;";
							}
							else
							{
								if(bed_no == null) bed_no="&nbsp;";
							}
						}
						else
						{
							if(bed_no == null) bed_no="&nbsp;";
						}

						if (call_function.equals("IPList"))
						{
							baby_count = rs.getInt("baby_count");
						}
					}
					if (call_function.equals("TransferPatientOut"))
					{
						status_value = checkForNull(rs.getString("status"));

						if(status_value.equals("1"))
						{
							//status_value = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirmed.label","common_labels");
							status_value = "Confirmed";
							status_value_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirmed.label","common_labels");	
						}
						else if(status_value.equals(""))
						{
							//status_value  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Regular.label","common_labels");
							status_value = "Regular";
							status_value_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Regular.label","common_labels");	
						}

						req_stat_tout = rs.getString("tfr_req_status");
						if (req_stat_tout == null)  req_stat_tout ="";
						if (req_stat_tout.equals("0"))
							color_code_scheme = "#FECBFA";
						else
							color_code_scheme = "";
					}

					

					if(!call_function.equals("AdminHist") && !call_function.equals("QueryCancelDischarge"))
					{
						room_no = rs.getString("room_no");
							if( room_no == null) room_no="&nbsp;";

					if(!call_function.equals("RepDischargeAdvice")&&!call_function.equals("ChangedAdmDtls"))
					{
						bed_class_short_desc = rs.getString("bed_class_short_desc");
							if( bed_class_short_desc == null) bed_class_short_desc="&nbsp;";
						bed_type_short_desc = rs.getString("bed_type_short_desc");
							if( bed_type_short_desc == null) bed_type_short_desc="&nbsp;";
					}
					


						if(call_function.equals("TransferPatientIn") || call_function.equals("CancelTransferPatientOut") || call_function.equals("TransferPatientOut"))
						{
							to_nursing_unit_short_desc = rs.getString("to_nursing_unit_short_desc");
							if( to_nursing_unit_short_desc == null) to_nursing_unit_short_desc="&nbsp;";
							to_bed_class_short_desc = rs.getString("to_bed_class_short_desc");
							if( to_bed_class_short_desc == null) to_bed_class_short_desc="&nbsp;";
							to_bed_type_short_desc = rs.getString("to_bed_type_short_desc");
							if( to_bed_type_short_desc == null) to_bed_type_short_desc="&nbsp;";
						}
					}

					if (call_function.equals("assign_bed")||call_function.equals("CancelAdmission"))
					{
						if(!call_function.equals("CancelAdmission"))
						{
							blocked_bedno = rs.getString("blocked_bed_no");
								if( blocked_bedno == null) blocked_bedno="&nbsp;";
							bed_no = blocked_bedno;
						}
					}
					
					if (!call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls"))
					{
						practitioner_id=rs.getString("practitioner_id");
							if(practitioner_id == null) practitioner_id="";
					}
					practitioner_name=rs.getString("practitioner_short_name");
						if((practitioner_name == null) || (practitioner_name.equals("null"))) 	practitioner_name="";

				if(!(call_function.equals("TransferPatientOut") || call_function.equals("TransferPatientIn") || call_function.equals("ConfirmBedClass")|| call_function.equals("CancelTransferPatientOut") || call_function.equals("CHECK_IN_LODGER") || call_function.equals("AdminHist") || call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT") || call_function.equals("QueryCancelDischarge") || call_function.equals("RepDischargeAdvice")))
					{ 
						patient_class = rs.getString("patient_class");
							if((patient_class == null) || (patient_class.equals("null")))
								patient_class="";
					}

					if (call_function.equals("AdminHist"))
					{
						adt_status=rs.getString("adt_status");
						if(adt_status == null) adt_status="";
					}

					if(call_function.equals("PrepareDischargeAdvice"))
					{
						ip_leave_status=rs.getString("ip_leave_status");
							if(ip_leave_status == null) ip_leave_status="";
						patient_status=rs.getString("oth_adt_status");
							if(patient_status == null) patient_status="";
						leave_exp_dt = rs.getString("leave_expiry_date_time");
							if(leave_exp_dt == null) leave_exp_dt="";
						leave_exp_dt_flag = rs.getString("leave_flag");
							if(leave_exp_dt_flag == null) leave_exp_dt_flag="";
							pat_dtls_unknown_yn	= checkForNull(rs.getString("pat_dtls_unknown_yn"));
							contact1_name				= checkForNull(rs.getString("contact1_name"));
							contact2_name				= checkForNull(rs.getString("contact2_name"));
					}

					if (call_function.equals("TransferPatientIn") || call_function.equals("CancelTransferPatientOut") || call_function.equals("TransferPatientOut"))
					{
						priority		= checkForNull(rs.getString("PRIORITY_SHORT_DESC"));
						priority_code	= rs.getString("PRIORITY_CODE");
							if (priority == null) priority = "&nbsp;";
						color_code_scheme		= checkForNull(rs.getString("color_code_scheme"));
						/*Monday, May 03, 2010 , commented for PE , query moved to line no 2811*/
						/*
						StringBuffer sqlBuffer		= new StringBuffer();
						sqlBuffer.append(" select color_code_scheme, short_desc FROM IP_TRANSFER_PRIORITY where facility_id='");
						sqlBuffer.append(facility_id);
						sqlBuffer.append("' and priority_code = '");
						sqlBuffer.append(priority_code);
						sqlBuffer.append("' ");

						stmt	= con.createStatement();
						colorRS	= stmt.executeQuery(sqlBuffer.toString());

						if ((colorRS!=null) && (colorRS.next()))
						{
							color_code_scheme		= colorRS.getString("color_code_scheme");
							if(colorRS!=null)	colorRS.close();
							if(stmt!=null)	stmt.close();
						}
						else 
						{
							color_code_scheme		= "";
						}
						*/
					}
					else if ((call_function.equals( "RequestforTransfer") ||call_function.equals("TransferPatient") || call_function.equals("EMERGENCY_TRANSFER")))
					{
						tfr_req_stat= checkForNull(rs.getString("TFR_REQ_STATUS"));
						if(!tfr_req_stat.equals(""))
							color_code_scheme = "#FECBFA";
						else
						{
							tfr_req_stat= checkForNull(rs.getString("TFR_REQ_STATUS"));
							if(tfr_req_stat != "")
								color_code_scheme = "#FECBFA";
							else
								color_code_scheme = "";
						}
						if(colorRS!=null)	colorRS.close();
					}
					else if(call_function.equals("PrepareDischargeAdvice"))
					{
						if(patient_status.equals("3"))
							color_code_scheme = "#FCC9B4";
						else if(patient_status.equals("4"))
							color_code_scheme = "#9DCECE";
						else if(ip_leave_status.equals("3"))
							color_code_scheme = "#FCC9B4";
						else if(ip_leave_status.equals("4"))
							color_code_scheme = "#9DCECE";
						else if(leave_exp_dt_flag.equals("Y"))
							color_code_scheme = "#FECBFA";
						else
							color_code_scheme = "";
					}
					else
					{
						if(class_val.equals("QRYEVENSMALL"))
							class_val = "QRYODDSMALL";
						else
							class_val = "QRYEVENSMALL";
					}
					if(priotity_status.equals("N"))
					{
						if(call_function.equals("TransferPatientOut"))
						{
							if (req_stat_tout.equals("0"))
								color_code_scheme = "#FECBFA";
							else
								color_code_scheme = "";
						}
					}
					if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")){
						cutt_of_time=rs.getString("cutt_of_time");
					}
					out.println("<tr>");

					if(!(jsp_name.equals("") && modal.equals("") ) )
					{
						if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
						{
							String disp_value = specialty_short_desc;
							if (!practitioner_name.equals(""))
								disp_value = disp_value+"/"+practitioner_name;

							

							if (call_function.equals("TransferPatientOut"))
							{
								if(!priotity_status.equals("Y"))
								{
									out.println("<td class='CAGROUPHEADING' colspan='16' align='left'>"+disp_value+"</td></tr><tr>");
								}
							}
							else if (call_function.equals("IPList"))
							{
								out.println("<td class='CAGROUPHEADING' colspan='11' align='left'>"+disp_value+"</td></tr><tr>");
							}
							else if (call_function.equals("NEWBORN_REG") || call_function.equals("BedSideReferral") || call_function.equals("AmendTransferPatient"))
							{
								out.println("<td class='CAGROUPHEADING' colspan='12' align='left'>"+disp_value+"</td></tr><tr>");
							}
							else if(call_function.equals("TransferPatientIn"))
							{
								if(!priotity_status.equals("Y"))
								{
									out.println("<td class='CAGROUPHEADING' colspan='16' align='left'>"+disp_value+"</td></tr><tr>");
								}
							}
							else if(call_function.equals("CancelTransferPatientOut"))
							{
								if(priotity_status.equals("Y"))
									out.println("<td class='CAGROUPHEADING' colspan='15' align='left'>"+disp_value+"</td></tr><tr>");
								else
									out.println("<td class='CAGROUPHEADING' colspan='14' align='left'>"+disp_value+"</td></tr><tr>");
							}
							else if (!call_function.equals("RepDischargeAdvice"))
							{
								
								//For assign bed function
								if(pat_check_in_allowed_yn.equals("Y"))
								{
									out.println("<td class='CAGROUPHEADING' colspan='12	' align='left'>"+disp_value+"</td></tr><tr>");
								}
								else
								{
									out.println("<td class='CAGROUPHEADING' colspan='12' align='left'>"+disp_value+"</td></tr><tr>");
								}
							}
							else
							{
								
								out.println("<td class='CAGROUPHEADING' colspan='12' align='left'>"+disp_value+"</td></tr><tr>");
							}
						}


						out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap> ");

						if(!call_function.equals("IPList"))
						{	
							out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','N')\">+</a></td>");
						}
						if( call_function.equals("assign_bed"))
						{
							/*4029	PMG20089-CRF-0127	IP 1/8/2009*/					
								asgn_bed_mark_arvl = checkForNull(rs.getString("asgn_bed_mark_arvl"));
									if(asgn_bed_mark_arvl.equals("E")){
										link_font_color		= "brown";
									}else{
										link_font_color		= "";
										
									}
								out.println("<td style='background-color:"+link_font_color+" ' class='"+class_val+"' width = '3%' nowrap >&nbsp;</td>");

							/**/
							
							
							if(bed_no.equals("&nbsp;"))
							{
								
								nurs_unit_code =rs.getString("nursing_unit_code");
								out.println("<td class='"+class_val+"'  nowrap >"+adm_date_display+"</td>");
								out.println("<td class='"+class_val+"'  nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','IPval','"+nurs_unit_code+"','"+color_code_scheme+"')\">"+encounter_id+"</a></td>");
							}
							else
							{		
								if(pat_check_in_allowed_yn.equals("N"))
								{
									out.println("<td class='"+class_val+"'  nowrap>"+adm_date_display+"</td>");
									out.println("<td class='"+class_val+"'  nowrap>"+encounter_id+"</td>");
								}
								else
								{
									out.println("<td class='"+class_val+"'  nowrap>"+adm_date_display+"</td>");
									/*Tuesday, August 17, 2010 , nurs_unit_code added for SRR20056-SCF-5026- IN023297 since location_code was going as null to AssignBedMain.jsp at query am_os_user_locn_access_vw */
									out.println("<td class='"+class_val+"'  nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','IPval','"+nurs_unit_code+"','"+color_code_scheme+"')\">"+encounter_id+"</a></td>");
								}
							}
						}
						else
						{
							if((!(call_function.equals("IPList"))) && (!(call_function.equals("NEWBORN_REG"))) && (!(call_function.equals("QueryCancelDischarge"))))
							{
							// Modified by Muthu on 08/03/2010 for Walkthrough changes
							// Issue :- Exception is coming when discharge date time is blank for the patient
							discharge_date_time_display = "&nbsp;";
								if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;")))
									discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
							// End of changes
								
								out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+adm_date_display+"</td>");
								if (call_function.equals("RepDischargeAdvice") || call_function.equals("CHECK_IN_LODGER") || call_function.equals("CANCEL_DISCHARGE_PATIENT") || call_function.equals("QueryCancelDischarge"))	
								{
									out.println("<td nowrap class='"+class_val+"'>"+discharge_date_time_display+"</td>");
								}

								if (!no_of_days.equals("") && call_function.equals("IpInternalReportReprint"))	
								{
									
									out.println("<td nowrap class='"+class_val+"'>"+discharge_date_time_display+"</td>");
								}
								if(call_function.equals("BabyLinktoMother"))
								{
									out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModalBabyDetails('"+encounter_id+"','"+facility_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"')\">"+encounter_id+"</a></td>");
								}
								else if(call_function.equals("TransferPatientOut"))
								{
									
									if(!req_stat_tout.equals("0"))
									{
										//10/16/2008 5089_MF-CRF-0017  TransferPatientOut start enhancement
										if(bed_no.equals("&nbsp;"))
										{
											out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+"" +"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','')\">"+encounter_id+"</a></td>");
										}
										else
											//10/16/2008 5089_MF-CRF-0017  TransferPatientOut start enhancement
										out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"')\">"+encounter_id+"</a></td>");
									}
									else
									{
										
										out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:ONLY_ONE_BKG()\">"+encounter_id+"</a></td>");
									}
								}
								else
								{
									if (call_function.equals("PrepareDischargeAdvice"))
									{    
                                         //Added by Sangeetha for GHL-CRF-0412.2 on 8-nov-2016
										pstmtward.setString(1,patient_id);
										pstmtward.setString(2,encounter_id);

										rsetWard=pstmtward.executeQuery();

										if(rsetWard != null && rsetWard.next()){
											 ward_return=rsetWard.getString("store_status")==null?"W":rsetWard.getString("store_status");   
										}

										//10/16/2008 5089_MF-CRF-0017  PrepareDischargeAdvice start enhancement
										if(bed_no.equals("&nbsp;"))
										{
										//Maheshwaran K removed(blank) the Contact_name1 and contact_name2 in the below function as on 15/07/2013
									//out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+"" +"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','','"+pat_dtls_unknown_yn+"','','','"+ward_return+"')\">"+encounter_id+"</a></td>");    
									
									out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+"" +"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','','"+pat_dtls_unknown_yn+"','','','','','','','','','','','','','"+ward_return+"','','"+pend_sal_ret_fin_stats+"','"+isAllowDischargeDisAdv+"')\">"+encounter_id+"</a></td>"); //modified by Sangeetha for GHL-CRF-0412.2 on 4-nov-2016
										}else{
											//10/16/2008 5089_MF-CRF-0017  PrepareDischargeAdvice start enhancement
											
                           //Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
											//con_1 =ConnectionManager.getConnection(request);
											//paramstat=con_1.createStatement();
											//String q="SELECT COUNT(*) result FROM or_order WHERE order_status IN (SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE oper_or_group_ref = 'OPER_AMENDCANCEL' AND a.order_status_type = b.order_status_type) AND patient_id = '"+patient_id+"'  AND encounter_id = '"+encounter_id+"'  AND patient_class = '"+patient_class+"' AND order_category IN (SELECT order_category  FROM or_order_category  WHERE chk_pend_ord_category = 'Y')";
											//String q="SELECT COUNT (*)conut,b.long_desc FROM or_order a ,or_order_category b WHERE order_status IN (SELECT order_status_code FROM or_order_status_code a, or_status_applicability b WHERE oper_or_group_ref = 'OPER_AMENDCANCEL' AND a.order_status_type = b.order_status_type) AND patient_id = '"+patient_id+"'AND encounter_id = '"+encounter_id+"' AND patient_class = '"+patient_class+"' AND a.ORDER_CATEGORY=b.ORDER_CATEGORY AND b.order_category IN (SELECT order_category FROM or_order_category WHERE chk_pend_ord_category = 'Y') group by b.ORDER_CATEGORY,b.long_desc";
											
											//String q="select Or_patient_Order_Pend('"+patient_id+"','"+facility_id+"','"+encounter_id+"','A') pend_ord_stats from dual";
											
									//params_1=paramstat.executeQuery(q);
									//result_count=0;
									//String pend_ord_stats="Y";
									//while( params_1!=null && params_1.next()){
										//pend_ord_stats=params_1.getString("pend_ord_stats");
									//}


									// changes  added for KDAH 41 and JD006
									if(pend_order_status.equals("Y")){
										result_count=1;
									}else{
										result_count=0;
									}
									// changes  added for KDAH 41 and JD006
									//Maheshwaran K removed(blank) the Contact_name1 and contact_name2 in the below function as on 15/07/2013
									//out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','"+leave_exp_dt_flag+"','"+pat_dtls_unknown_yn+"','','','"+result_count+"','','','','','','','"+result_count+"','"+facility_id+"')\">"+encounter_id+"</a></td>");
									// Added pre_dis_initiate_yn for the CRF -KDAH-CRF-0104  by Dharma
									out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','"+leave_exp_dt_flag+"','"+pat_dtls_unknown_yn+"','','','"+result_count+"','','','','','','','"+result_count+"','"+facility_id+"','"+pre_dis_initiate_yn+"','"+ward_return+"','','"+pend_sal_ret_fin_stats+"','"+isAllowDischargeDisAdv+"')\">"+encounter_id+"</a></td>");          //modified by Sangeetha for GHL-CRF-0412.2 on 4-nov-2016
	
										}
							// venkatesh KDAH-CRF-0041 END	
									}
									else if (call_function.equals("CANCEL_DISCHARGE_PATIENT"))
									{
										String cancel_discharge_date = "";
										if(!(discharge_date_time_display==null || discharge_date_time_display.equals("")))
											cancel_discharge_date = discharge_date_time_display.substring(0,10);
										
										int open_cnt = 0;
										open_cnt     = rs.getInt("open_cnt");
										String latestDischargeEncId	= rs.getString("latest_dis_enc_id");// Added by Dharma on 27th Aug 2018 against PMG2018-GHL-CRF-0001 [IN:068328]
										
										out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModalForCancelDischarge('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','','"+cancel_discharge_date+"','"+open_cnt+"','"+mo_install_yn+"','"+latestDischargeEncId+"')\">"+encounter_id+"</a></td>");

									}
									else 
									{
										//10/16/2008 5089_MF-CRF-0017 enhance ment start

										if(bed_no.equals("&nbsp;")&&!call_function.equals("MODIFY_SERVICE_FOR_INPATIENT") && !call_function.equals("IpInternalReportReprint")){
										
											out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+"" +"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','')\">"+encounter_id+"</a></td>");
										}
										/*Modifed For Change Admission Details starts*/
										else if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")){
																			
										out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:callChangeAdmDtls('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','','"+cutt_of_time+"')\">"+encounter_id+"</a></td>");
										}//Ends		
									
										else if (call_function.equals("CancelDischargeAdvice")) {
																			
										String finalize_yn = "";
										
										 String sql5 = "select finalize_yn from mr_death_register_hdr where facility_id = '"+facility_id+"' and encounter_id = '"+encounter_id+"' and patient_id = '"+patient_id+"' ";			
										 										 
											pstmt=con.prepareStatement(sql5);
											rs1=pstmt.executeQuery();
											while(rs1.next()){
												finalize_yn		=	checkForNull(rs1.getString("finalize_yn"));
											}												
											
											
											out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','','','"+finalize_yn+"')\">"+encounter_id+"</a></td>");

										}
									
										else{
											if (call_function.equals("IpInternalReportReprint"))
												{						
													pat_ser_grp_code = checkForNull(rs.getString("pat_ser_grp_code"));
													req_no = "";												String sqlPREnc = "";	
													try
													{
														String sqlReport = "select req_no,req_to_fs_locn_code,file_no from fm_req_dtl where curr_facility_id = '"+facility_id+"' and encounter_id = '"+encounter_id+"' and rownum < 2 ";													
													pstmt=con.prepareStatement(sqlReport);
													rs1=pstmt.executeQuery();
														while(rs1 != null && rs1.next()) {
													req_no		=	checkForNull(rs1.getString("req_no"));
													perm_fs_locn=	checkForNull(rs1.getString("req_to_fs_locn_code"));
														patient_file_no=	checkForNull(rs1.getString("file_no"));
													}														
													}catch(Exception sqlR)
													{
														sqlR.printStackTrace();
													}
													if(req_no.equals(""))
													{
													try
													{
														sqlPREnc = "select file_no from pr_encounter where facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+" ";	

														if(rs1 != null)rs1.close(); if(pstmt != null) pstmt.close();
														pstmt=con.prepareStatement(sqlPREnc);
														rs1=pstmt.executeQuery();
														if(rs1 != null && rs1.next())
														{
															patient_file_no =	checkForNull(rs1.getString("file_no"));
														}

													}
													catch(Exception sqlP)
													{
														sqlP.printStackTrace();
													}
												}
												//Below line modified for this incident [40702]
													out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModalReprint('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','"+n_Age+"','"+discharge_date_time_display_report+"','"+maternal_death_yn+"','"+indicator+"','"+req_no+"','"+perm_fs_locn+"','"+patient_file_no+"','"+pat_ser_grp_code+"')\">"+encounter_id+"</a></td>");
												}
												else
											{
											
											// changes  added for KDAH 41 and JD006
											if(pend_order_status.equals("Y")){
												result_count=1;
											}else{
												result_count=0;
											}
											//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
											if(blood_consump_count.equals("0")){
												blood_consump_status="N";
											}else{
												blood_consump_status="Y";
											}

											// changes  added for KDAH 41 and JD006

											out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','"+n_Age+"','','','"+discharge_date_time_display+"','"+maternal_death_yn+"','"+indicator+"','"+req_no+"','"+perm_fs_locn+"','','','','"+result_count+"','"+facility_id+"','','','"+blood_consump_status+"','','"+isAllowDischargeDisAdv+"')\">"+encounter_id+"</a></td>");

											
											}
										
										
										
										//10/16/2008 5089_MF-CRF-0017 enhance ment start
										}
										//10/16/2008 5089_MF-CRF-0017 enhance ment start
									}
								}
								if (call_function.equals("BedSideReferral"))
									out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+referral_id+"</td>");
							}
							else if(call_function.equals("QueryCancelDischarge"))
							{
								discharge_type_desc		= checkForNull(rs.getString("discharge_type_desc"));
								out.println("<td class='"+class_val+"' 	nowrap>"+discharge_type_desc+"</td>");
								out.println("<td class='"+class_val+"' nowrap>"+encounter_id+"</td>");
							}
							else
							{
								out.println("<td class='"+class_val+"' 	nowrap>"+adm_date_display+"</td>");
								out.println("<td class='"+class_val+"' nowrap>"+encounter_id+"</td>");
							}
						}	
					}
					else
					{
						
						
						if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
						{
							if (!call_function.equals("QueryCancelDischarge") &&( call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT")  || !no_of_days.equals("") || !call_function.equals("RepDischargeAdvice") || !call_function.equals("CHECK_IN_LODGER")))		
							{
								String prac = rs.getString("practitioner_short_name");
								if(prac == null) prac = "";
								String disp_value = specialty_short_desc;
								if (!practitioner_name.equals(""))
									disp_value = disp_value+"/"+practitioner_name;
								String cols = "";
								if(call_function.equals("IPList"))

									if(!no_of_days.equals(""))//modified on 4/8/8
										cols = "16";
									else
										cols="15";//
								else
									cols = "13";

								//Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613
								if(isTopupDepositAppl && call_function.equals("IPList")){
									if(!no_of_days.equals(""))
										cols = "17";
									else
										cols="16";
								}

								if(bed_no.equals("")) bed_no="&nbsp;";
									out.println("<td class='CAGROUPHEADING' colspan='"+cols+"' align='left' nowrap>"+specialty_short_desc+"/"+prac+"</td></tr><tr>");
							}									
							else if (call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT") ||   !no_of_days.equals("") || call_function.equals("RepDischargeAdvice") || call_function.equals("CHECK_IN_LODGER"))		
							{
								
								String disp_value = specialty_short_desc;
								if (!practitioner_name.equals(""))
								disp_value = disp_value+"/"+practitioner_name;
								out.println("<td class='CAGROUPHEADING' colspan='10' align='left' nowrap>"+disp_value+"</td></tr><tr>");
							}
							else
							{
							// added by sridhar on 28 sep 2004 for Queries Inpatient List...
							if(call_function.equals("IPList"))
							{
								out.println("<td class='CAGROUPHEADING' colspan='10' align='left' nowrap>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
							}
							else if(!call_function.equals("QueryCancelDischarge"))
							{	
								
								out.println("<td class='CAGROUPHEADING' colspan='8' align='left' nowrap>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
							}
							}
						}

							out.println("<td nowrap class='"+class_val+"'> ");
							String changeCallFunc = "";
							if( !no_of_days.equals("") && discharge_date_time != "&nbsp;")
								changeCallFunc = "Y";
							else
								changeCallFunc = "N";

							out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','"+changeCallFunc+"')\">");								
							out.print("+</a></td>" );

						if(call_function.equals("QueryCancelDischarge"))
						{
							discharge_type_desc			= checkForNull(rs.getString("discharge_type_desc"));
							discharge_status_desc		= checkForNull(rs.getString("discharge_status_desc"));
							// code added for 17600 Wednesday, December 23, 2009 start
							if((discharge_type_desc == null)||(discharge_type_desc.equals(""))) 
							{
								discharge_type_desc="&nbsp;";
								
							}
							if((discharge_status_desc == null)||(discharge_status_desc.equals(""))) 
							{
								discharge_status_desc="&nbsp;";
								
							}
							// code added for 17600 Wednesday, December 23, 2009 end 
							out.println("<td class='"+class_val+"' 	nowrap>"+discharge_type_desc+"</td>");			
							//3-07-08 SCR 3228 for Discharge Status
							out.println("<td class='"+class_val+"' 	nowrap>"+discharge_status_desc+"</td>");	
						}
						else
							out.println("<td nowrap class='"+class_val+"' nowrap>"+adm_date_display+"</td>");

						 discharge_date_time_display = "&nbsp;";
						if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;") || discharge_date_time.equals("")))
							discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);


						
				

						if ((call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT") ||   !no_of_days.equals("") ||
						call_function.equals("RepDischargeAdvice") ||
						call_func.equals("CHECK_IN_LODGER")) && !call_function.equals("QueryCancelDischarge"))	
						{
							
							out.println("<td nowrap class='"+class_val+"'>"+discharge_date_time_display+"</td>");
						}
				
						if(call_function.equals("REG_NEWBORN_FOR_IP"))
						{
							out.println("<td class='"+class_val+"' nowrap><a href=\"javascript:runReport('"+encounter_id+"','"+patient_id+"')\">"+encounter_id+"</a></td>");
						}
						else
						{
							out.println("<td nowrap class='"+class_val+"'>"+encounter_id+"</td>");	
						}
					}
					if (call_function.equals("NEWBORN_REG"))
					{
						out.println("<td class='"+class_val+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"')\">"+patient_id+"</a></td>");
					out.println("<td nowrap class='"+class_val+"'>"+date_of_birth_converted+"</td>");
					}
					else
					out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+patient_id+"</td>");
					if(call_function.equals("assign_bed")){
					if ((patient_name.trim()).equals(""))
						patient_name = "&nbsp;";
					out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+patient_name+"</td>");
					}else{
					
					if ((patient_name.trim()).equals(""))
						patient_name = "&nbsp;";
					out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+patient_name+"</td>");
					}
					
					
					out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+Sex+"</td>");
					
					/*Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613*/
					if(isTopupDepositAppl && call_function.equals("IPList")){
						if(Respc.equals("Y")){
							out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:insertDataInvokeBLReport('"+facility_id+"','"+episode_id+"','"+locale+"', '"+session_id+"','"+pgm_date+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TopupDeposit.label","common_labels")+"&nbsp;"+"</a></td>");
						}else{
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>&nbsp</td>");
						}
					}
					/*End ML-MMOH-CRF-1613*/

					out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+nursing_unit_short_desc+"</td>");
					//Maheshwaran K added for TH-KW-CRF-0141.1
					if(call_function.equals("DischargePatient")  && isCoderClearance) 
				 		{
						bill_indicator			= checkForNull(rs.getString("bill_indicator"));
						oth_adt_status1			= checkForNull(rs.getString("oth_adt_status"));
						
						if(bill_indicator.equals("0"))
							{
							if(exclude_nda_pats.equals("N"))
								{
								if(oth_adt_status1.equals("7"))	{
								out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeAdvicePrepared.label","common_labels")+"&nbsp;</td>");	
								}
								else {
								out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeAdvicePending.label","common_labels")+"&nbsp;</td>");
								
								}
								}
							else {
								if(oth_adt_status1.equals("7"))	{
								out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeAdvicePrepared.label","common_labels")+"&nbsp;</td>");	
								}
								else {
								out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeAdvicePending.label","common_labels")+"&nbsp;</td>");
								
								}
							}
						
							}
						if(bill_indicator.equals("1"))
							{
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CoderClearance.label","common_labels")+"&nbsp;"+"</td>");
							}
						if(bill_indicator.equals("2"))
							{
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeBill.label","common_labels")+"&nbsp;"+"</td>");
							}
						if(bill_indicator.equals("3"))
							{
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeClearance.label","common_labels")+"&nbsp;"+"</td>");
							}	

						}
					
					if (call_function.equals("IPList"))
					{
						out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+service_short_desc+"</td>");
						out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+subservice_short_desc+"</td>");
					}

					if (!show_bed_yn.equals("N"))
					{
						if(!call_function.equals("AdminHist") && !call_function.equals("RepDischargeAdvice") && !call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls"))
						{
							out.println("<td style='background-color:"+color_code_scheme+"' nowrap class='"+class_val+"'>"+bed_class_short_desc+"</td>");
							out.println("<td style='background-color:"+color_code_scheme+"' nowrap class='"+class_val+"'>"+bed_type_short_desc+"</td>");
						}

						if(call_function.equals("assign_bed"))
						{
							if(pat_check_in_allowed_yn.equals("Y"))
							out.println("<td nowrap class='"+class_val+"' >"+blocked_bedno+"</td>");
						}
					}

					
					if (!show_bed_yn.equals("N"))
					{
						if(!call_function.equals("assign_bed") && !call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls"))
						{
							if(bed_no == null) bed_no  = "&nbsp;";
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+bed_no+"</td>");
						}
						if(!call_function.equals("AdminHist") && !call_function.equals("QueryCancelDischarge")&&!call_function.equals("ChangedAdmDtls")){
						out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+room_no+"</td>");
					}
		
				
					//11-sep-2008 check box code start
					if(call_function.equals("CancelReserveBeds") )
					{
						out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><input type='checkbox' name='selectChk' id='selectChk'"+i+"' value=' '></td>");
					}
					//check box codeend 
					if(call_function.equals("TransferPatientIn") || call_function.equals("TransferPatientOut") || call_function.equals("CancelTransferPatientOut"))
					{
						out.println("<td style='background-color:"+color_code_scheme+"' nowrap class='"+class_val+"'>"+to_nursing_unit_short_desc+"</td>");

						out.println("<td style='background-color:"+color_code_scheme+"' nowrap class='"+class_val+"'>"+to_bed_class_short_desc+"</td>");

						out.println("<td style='background-color:"+color_code_scheme+"' nowrap class='"+class_val+"'>"+to_bed_type_short_desc+"</td>");
					}

						if (call_function.equals("IPList"))
						{
							if(baby_count>0)
							{
								out.println("<td class='"+class_val+"' nowrap><a href=\"javascript:showModalBabyDetails('"+encounter_id+"','"+facility_id+"','"+patient_id+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ViewDetails.label","common_labels")+"&nbsp;"+"</a></td>");
							}
							else
							{
								out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>&nbsp</td>");
							}
						}
					}

					//Location type added by kishore on 5/15/2004
					if ((call_function.equals( "TransferPatientIn" )) || (call_function.equals("CancelTransferPatientOut")) || (call_function.equals("TransferPatientOut")))
					{
						if(priotity_status.equals("Y"))
						{
							if(priority.equals(""))
								priority="&nbsp";
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' align='center' >"+priority+"</td>");
						}
					}
					// Added by SRIDHAR R on 6 AUG 2004 
					// this is used in all functions to display Location
					//Added by shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
					if(call_func.equals("CHECK_IN_ACCMP_PERSON") || call_function.equals("AssignTreatingPract") ||
					call_function.equals("ExpectedDischarge") ||
					call_function.equals("CancelAdmission") ||
					call_function.equals("TransferPatient") ||
					call_function.equals("TransferPractitioner") || 
					call_function.equals("PrepareDischargeAdvice") ||
					call_function.equals("CancelDischargeAdvice") ||
					call_function.equals("DischargePatient") ||
					call_function.equals("RecordInpatienLeave") ||
					(call_function.equals("TransferPatientIn") && (!isCurrentLocDtlsAppl))||
					(call_function.equals("TransferPatientOut") && (!isCurrentLocDtlsAppl))||
					call_function.equals("RequestforTransfer") || call_function.equals("IPList") || call_function.equals("PatMovList") || call_function.equals("EMERGENCY_TRANSFER"))
					{
						out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+location_desc+"</td>");
					}
					

					if (call_function.equals("TransferPatientOut"))
					{
						if (status_value.equals("Regular"))
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+status_value_converted+"</td>");
						if (status_value.equals("Confirmed"))
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' ><a href=\"javascript:getStatusDetails('"+encounter_id+"','"+patient_id+"','1')\";>"+status_value_converted+"</a></td>");
						if (status_value.equals("&nbsp;"))
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+status_value_converted+"</a></td>");
					}

					String status = "";
					if(call_function.equals("TransferPatientIn"))
					{
						cancel_reason_code		= checkForNull(rs.getString("cancel_reason_code"));
						cancellation_date_time	= checkForNull(rs.getString("cancellation_date_time"));
						cancelled_by_id			= checkForNull(rs.getString("cancelled_by_id"));
						contact_reason			= checkForNull(rs.getString("contact_reason"));
						if(cancel_reason_code.equals(""))
							status = "Pending";
						else
							status = "Rejected";
						
						if(status.equals("Rejected"))
						{
							out.println("<td nowrap class='"+class_val+"' style='cursor:pointer;background-color:"+color_code_scheme+"'   onMouseOver='displayToolTip(\""+cancellation_date_time+"\",\""+cancelled_by_id+"\",\""+contact_reason+"\")' onMouseOut ='hideToolTip()' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels")+"&nbsp;"+"</td>");
						}
						else if(status.equals("Pending"))
						{
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels")+"&nbsp;"+"</td>");
						}

					}
					if( call_function.equals("DischargeCheckList") || call_function.equals("ViewCheckList") || call_function.equals("REG_NEWBORN_FOR_IP"))
					{
						if(disc_from_date==null || disc_from_date.equals("") || disc_to_date==null || disc_to_date.equals(""))
						{
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+location_desc+"</td>");
						}
						else
						{
							discharge_date_time = rs.getString("discharge_date_time");
						 discharge_date_time_display = "&nbsp;"; 
							if((discharge_date_time == null)||(discharge_date_time.equals(""))) 
							{
								discharge_date_time="&nbsp;";
								discharge_date_time_display = "&nbsp;"; 
							}
							else
							discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+discharge_date_time_display+"</td>");
						}
					}

						if(call_function.equals("ChangedAdmDtls")){
							modified_By_rslt				= rs.getString("modified_by_id");
							reason_for_modification	= rs.getString("contact_reason");
							String disp_pract	="";
							if(practitioner_name.equals(""))disp_pract="&nbsp";
							else disp_pract	=	practitioner_name;
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+specialty_short_desc+"</td>");	
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+disp_pract+"</td>");
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+room_no+"</td>");
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+modified_By_rslt+"</td>");
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+reason_for_modification+"</td>");
							
						}					


				if( call_function.equals("QueryCancelDischarge"))
					{
						cancel_reason_desc		= checkForNull(rs.getString("cancel_reason_desc"));
						cancellation_date_time	= checkForNull(rs.getString("cancel_disch_date"));
						cancelled_by_id			= checkForNull(rs.getString("cancel_disch_practitioner_desc"));

						if(!(cancellation_date_time==null || cancellation_date_time.equals("")))
							cancellation_date_time = DateUtils.convertDate(cancellation_date_time,"DMYHM","en",locale);
						out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+specialty_short_desc+"</td>");		
						out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+practitioner_name+"</td>");		
						out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+adm_date_display+"</td>");							
						out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+cancellation_date_time+"</td>");
						out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+cancelled_by_id+"</td>");
						out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+cancel_reason_desc+"</td>");						
					}

					out.println("</tr>");
					prev_val  = specialty_short_desc;
					prev_val2 = practitioner_name;
					i++;
					maxRecords++;
				}//End of While
			}
		out.println("</table>");
		if(maxRecords<12 || !(rs.next())){ 
            _bw.write(_wl_block101Bytes, _wl_block101);
}else{  
            _bw.write(_wl_block102Bytes, _wl_block102);
}
		if(maxRecords==0){
            _bw.write(_wl_block103Bytes, _wl_block103);
}
			// boolean occupy_flag=false;
			/*
		  paramstmt = con.createStatement();
		//  rs = paramstmt.executeQuery("SELECT '1' FROM pr_encounter WHERE  DECEASED_DATE_TIME IS NOT NULL  AND PATIENT_CLASS='IP' AND DISPOSITION_TYPE  IN (SELECT DISCHARGE_TYPE_CODE FROM ip_discharge_type WHERE INDICATOR='DS' ) and ENCOUNTER_ID='"+encounter_id+"'");

		  rs = paramstmt.executeQuery("SELECT A.DECEASED_DATE_TIME, B.MATERNAL_DEATH_YN,B.INDICATOR FROM pr_encounter a, ip_discharge_type b WHERE PATIENT_CLASS='IP' AND A.DISPOSITION_TYPE= B.DISCHARGE_TYPE_CODE AND ENCOUNTER_ID='"+encounter_id+"' ");

		if(rs!=null && rs.next()){
			//occupy_flag=true; //31-08-2009
			
			deceased_date_time =checkForNull(rs.getString("DECEASED_DATE_TIME"));
			maternal_death_yn  =checkForNull(rs.getString("MATERNAL_DEATH_YN"));

			indicator =checkForNull(rs.getString("INDICATOR"));
		}
			if(rs!=null)	rs.close();
			if(paramstmt!=null)	paramstmt.close();
		*/

			//11-sep-2008 cancel reserved bed started
			if( call_function.equals("CancelReserveBeds")){
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block105Bytes, _wl_block105);
}
				//11-sep-2008 cancel reserved bed ended
				
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(module));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(routine_tfr_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(targetURL));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(leave_exp_dt_flag));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(bed_block_period_max));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(bedBlock_normal));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(max_blk_type));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(allow_discharge_date));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(chg_nurs_unit_in_assign_bed_yn));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(sys_dt_time));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(confirmIP));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(priotity_status));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(bed_class_allowed));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(dflt_blk_prd_for_tfr_out));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(bed_block_period_normal));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(change_admission_dtls));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(bed_block_period_max_type));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(allow_multiple_bed_for_resv_yn));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(result_count));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf( chc_for_pen_orders_bfr_dis_adv));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(dis_adv_allow_yn));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf( chc_for_pen_orders_bfr_dischrg));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(dischrg_allow_yn));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(allow_late_discharge_reason));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(disch_reason_mand_yn));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(transfer_wo_delink_yn));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforRejection.label","common_labels")));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedBy.label","ip_labels")));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedDate.label","ip_labels")));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(deceased_date_time));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(maternal_death_yn));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(indicator));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(discharge_date_time_display));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(age));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(pre_disch_appl_yn));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(height_on_admn_mandatory));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(chk_pen_ward_rtn_bfr_dis_adv));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(chk_pen_sale_rtn_bfr_dis_adv));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(isRestrictDisAdvSaleRetPend));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(allowCancelAdm));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(chk_dis_pat_bt_order_pend));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(blood_consump_status));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(isDisPatBTorderPendAppl));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(isNewBornChngsAppl));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(trans_yn_unfnzed_newborn));
            _bw.write(_wl_block180Bytes, _wl_block180);
 

			if(stmt_bl != null)			stmt_bl.close();
			if(stmt != null)			stmt.close();
			if(rs_bl != null)			rs_bl.close();
			if(rs != null)				rs.close();
			if(colorRS != null)			colorRS.close();
			if(paramstmt != null)		paramstmt.close();
			if(paramrs != null)			paramrs.close();

		}catch(Exception e)
		{
			out.println("Exception @tryCatch : "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			//added on 18-10-2003 by dhanasekaran		
			if(call_func.equals("CheckInLodger") || call_func.equals("RepDischargeAdvice"))
			{
				out.print("<script>if(parent.frames[0].document.forms[0]!= null)");
				out.print("parent.frames[0].document.forms[0].search.disabled=false</script>");
			}
			else
			{
				out.print("<script>if(parent.frames[1].document.forms[0]!= null)");
				// code added to check search component existence
				out.print("if(parent.frames[1].document.forms[0].search)");
				out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
			}
		}

		if(stmt_bl != null)			stmt_bl.close();
		if(stmt != null)			stmt.close();
		if(rs_bl != null)			rs_bl.close();
		if(rs != null)				rs.close();
		if(paramstmt != null)		paramstmt.close();
		if(paramrs != null)			paramrs.close();
		//Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613
		if(pstmt2 != null)			pstmt2.close();
		if(cs != null)				cs.close();
		if(rs2 != null)				rs2.close();
		
	}catch(Exception e)
	{ 
		out.println("Error in InpatientLookupQueryResult : "+e.toString());	
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}	


            _bw.write(_wl_block181Bytes, _wl_block181);
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
