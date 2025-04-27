package jsp_servlet._emr._jsp;

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
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __authorizerecode extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AuthorizeRecode.jsp", 1732529910165L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n</head>\n\n<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name= \'f\' >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<input type=\"hidden\" name=\"res\" id=\"res\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >\n<script>\nasync function show_window()\n{\t\n\t\t//Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123\n        var termset_id = parent.RecDiagnosisAddModify.document.forms[0].code_set.value;\n\t\tvar xmlDoc = \"\"\n\t\tvar xmlHttp = new XMLHttpRequest()\n\t\txmlStr =\"<root><SEARCH termset_id=\\\"\"+termset_id+\"\\\" action=\'getFreeTextApplYN\' /></root>\"\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\txmlHttp.open(\"POST\",\"../jsp/MRIntermediate.jsp\",false)\n\t\txmlHttp.send(xmlDoc)\n\t\tresponseText=xmlHttp.responseText\n\t\tvar free_text_applicable_yn\t= trimString(responseText);\n\t\t//End ML-MMOH-SCF-2123\n\t\t\n\t\tvar called_from_ip = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\tvar val1 = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ;\n\t\tvar val2 = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ;\n\t\tvar val3 = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' ;\n\t\tvar val = val1+\'/\'+val2+\'/\'+val3;\n      \n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"188px\" ;\n\t\tvar dialogWidth\t= \"350px\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\tvar arguments\t= \"\" ;\n\n\t\t\n\t\tretVal = await window.showModalDialog(\"../../eMR/jsp/AuthorizeMRAccessFrame.jsp?constr=\"+val,arguments,features);\n\t\t\n\t\t      \n\t\t\n\t\tif(retVal == \"T\" )\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'==\"Ass\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t//var diag_code=parent.addModifyPatProblem.document.forms[0].code.value;\n\t\t\t\tvar diag_code;\n\t\t\t\tif(parent.RecDiagnosisAddModify!=null)\n\t\t\t\t\tdiag_code=parent.RecDiagnosisAddModify.document.forms[0].diag_code.value;\n\t\t\t\telse if(parent.addModifyPatProblem!=null)\n\t\t\t\t\tdiag_code=parent.addModifyPatProblem.document.forms[0].code.value;\n\t\t\t\t\n\t\t\t\t//if(parent.addModifyPatProblem.document.forms[0].diag_stage)\n\t\t\t\t\t\t//var diag_stage=parent.addModifyPatProblem.document.forms[0].diag_stage.value;\n\t\t\t\t//if(parent.RecDiagnosisAddModify.document.forms[0].diag_stage)\n\t\t\t\t\t//var diag_stage=parent.RecDiagnosisAddModify.document.forms[0].diag_stage.value;\n\t\t\t\t//var diagtype=parent.addModifyPatProblem.document.forms[0].diag_type.value;\n\t\t\t\t//var diagtype=parent.RecDiagnosisAddModify.document.forms[0].diag_type.value;\n\t\t\t\t//var state=parent.addModifyPatProblem.document.forms[0].function_name.value;\n\t\t\t\t//var trn_srl_no=parent.addModifyPatProblem.document.forms[0].trn_srl_no.value;\n\t\t\t\t//var trn_srl_no=parent.RecDiagnosisAddModify.document.forms[0].trn_srl_no.value;\n\t\t\t\t\n\t\t\t\t\t\t\t//parent.PatProblemQueryResult.location.href=\'../../eMR/jsp/";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="?stage_code=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&stage_desc=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&P_context=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&Encounter_Id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&Practitioner_Id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&Clinic_Code=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&Patient_Id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&Location_Type=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&radio_par=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&pr=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&f_authorize_yn=Y&Locn_Code=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&Locn_Type=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&patient_class=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&called_from_ip=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&Sex=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&Dob=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&code_indicator=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&associate_codes=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&modal_yn=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&calledFromDeathReg=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\n\n\t\t\t\t\t\t\tparent.RecDiagnosisCurrentDiag.location.href=\'../../eMR/jsp/";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&Logical_Seq=&Function=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&episode_type=&visit_adm_date=&relationship_id=&term_code=&term_set_id=&practitioner_type=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\n\n\t\t\t\t\t\t\t\t//parent.addModifyPatProblem.location.href=\"../../eMR/jsp/DiagRecodeaddModifyPatProblem.jsp?diag_code=\"+diag_code+\"&diagtype=\"+diagtype+\"&diag_stage=\"+diag_stage+\"&trn_srl_no=\"+trn_srl_no+\"&stage_code=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&QueryString=\" + escape(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\') + \"&Sex=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&retVal_auth=T&code_indicator=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&data_state=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t\t\t\t\t//parent.PatProblemQueryTools.document.forms[0].authorize.value=\'Normal Mode\'\n\n\n\t\t\t\t\t\t\t//parent.RecDiagnosisAddModify.location.href=\"../../eMR/jsp/RecDiagnosisAddModify.jsp?diag_code=\"+diag_code+\"&diagtype=&diag_stage=&trn_srl_no=&stage_code=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&episode_type=&visit_adm_date=&relationship_id=&occur_srl_no=&term_code=&term_set_id=\";\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value= getLabel(\'Common.Normal.label\',\'Common\')+\' \'+getLabel(\'Common.mode.label\',\'Common\');\n\t\t\t\t\t\t\t\tparent.RecDiagnosisOpernToolbar.document.forms[0].mode.value=\'Normal Mode\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(parent.addModifyPatProblem!=null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.PatProblemQueryTools.document.forms[0].authorize.value= getLabel(\'Common.Normal.label\',\'Common\')+\' \'+getLabel(\'Common.mode.label\',\'Common\');\n\t\t\t\t\t\t\t\tparent.PatProblemQueryTools.document.forms[0].mode.value=\'Normal Mode\';\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//Need to check below code in v3 MR module\n\t\t\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' == \"PatAlertHighRiskMainFrame.jsp\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(called_from_ip == \"Y\"){\n\t\t\t\t\t\t\t\t\tparent.PatAlertQueryHighRiskResult.document.forms[0].high_risk_button.value=\'Normal Mode\'\t;\n\t\t\t\t\t\t\t\t\tparent.PatAlertHighRiskMainFrame.location.href=\'../../eMR/jsp/";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="?Encounter_Id=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"&Sex=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\';\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.PatAlertQueryHighRiskResult.document.forms[0].high_risk_button.value=\'Normal Mode\'\t;\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.PatAlertHighRiskMainFrame.location.href=\'../../eMR/jsp/";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\';\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\ttop.content.workAreaFrame.PatAlertQueryAllergyClass.location.href=\'../../eMR/jsp/";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t}\n\t\telse\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t//Need to check below code in v3 MR module\n\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' == \"PatAlertHighRiskMainFrame.jsp\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(called_from_ip == \"N\"){\n\t\t\t\t\t\t\ttop.content.workAreaFrame.PatAlertQueryHighRiskResult.radio_high_risk.high_risk_button.checked=false;\n\t\t\t\t\t\t\twindow.location.href=\"../../eCA/jsp/blank.jsp\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tparent.PatAlertQueryHighRiskResult.radio_high_risk.high_risk_button.checked=false;\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t//else if (\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' == \"DiagRecodePatProblemQueryResult.jsp\")\n\t\t\t\t\telse if (\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' == \"RecDiagnosisCurrentDiag.jsp\" || \'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' == \"DiagRecodePatProblemQueryResult.jsp\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\n\t\t\t\t\tif(called_from_ip == \"N\"){\n//parent.PatProblemQueryResult.location.href=\'../../eMR/jsp/";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&f_authorize_yn=N&patient_class=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\';\n\n\t\t\t\t\t\t//parent.RecDiagnosisCurrentDiag.location.href=\'../../eMR/jsp/";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&Logical_Seq=&episode_type=&visit_adm_date=&Locn_Code=&relationship_id=&Locn_Type=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&practitioner_type=&Encounter_Id=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&term_code=&Clinic_Code=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&term_set_id=&Patient_Id=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&Function=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&practitioner_type=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\';\n\t\t\t\t\t}else{\n\t\t\t\t\t\n\n//parent.PatProblemQueryResult.location.href=\'../../eMR/jsp/";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\';\t\t\n\t\t\n\t\t//parent.RecDiagnosisCurrentDiag.location.href=\'../../eMR/jsp/";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&episode_type=&visit_adm_date=&Locn_Code=&relationship_id=&Locn_Type=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&practitioner_type=&term_code=&term_set_id=&Logical_Seq=&Encounter_Id=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\';\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//9/19/2009 14614\n\t\t\t\t\t\t\tif(parent.RecDiagnosisAddModify.document.forms[0].mode.value != \'modify\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value=\"\";\n\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value=\"\";\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value==\"\"&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled) \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t//Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123\n\t\t\t\t\t\t\t\t\tif(free_text_applicable_yn == \'Y\'){\n\t\t\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=false;\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=true;\n\t\t\t\t\t\t\t\t\t}//End ML-MMOH-SCF-2123\n\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t//parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=false; //added for this CRF Bru-HIMS-CRF-024.2\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t//Monday, August 03, 2009 commented for 13271 parent.RecDiagnosisAddModify.document.forms[0].accuracy.value=\"\";\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility=\'hidden\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].AddAssociateCodes.disabled=true;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t/*Below line added for this CRF Bru-HIMS-CRF-024.2*/\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value==\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value==\'\'))\n\t\t                    {  \n\t\t\t                    parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=true;\n\t\t                    }\n\t\t\t\t\t\t\t   //End Bru-HIMS-CRF-024.2\t\n                           \n                            //Below line added for this CRF GDOH-CRF-0082\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t//if(\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"==\"true\" ){\n\t\t\t\t\t\t\t if(\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"==\"true\" &&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value==\"\"){\n                               \t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'hidden\';\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=\"\";\n\t\t\t\t\t\t\t}\n\t\t                    //End GDOH-CRF-0082\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility=\'hidden\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].high_risk.style.visibility=\'hidden\'; // Saanthaa\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(parent.addModifyPatProblem!=null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].Description1.value=\"\";\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility=\'hidden\';\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].exclamation.style.visibility=\'hidden\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\n}\n\n\t\n\tif (document.f.res.value == 0)\n\t\t\twindow.setTimeout(\"show_window();\",1000);\n\telse\n\t{\n\t\talert(getMessage(\"DIAG_AUTH_REQD\",\'CA\'));\t\t\n\t}\n</script>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
    Connection con = null;
	
	String P_patient_id = request.getParameter("Patient_Id");
	String P_encounter_id = request.getParameter("Encounter_Id");
	String P_practitioner_id = request.getParameter("Practitioner_Id");
	String P_clinic_code = request.getParameter("Clinic_Code");
	String P_locn_type = request.getParameter("Location_Type");
	String P_access_type = request.getParameter("Access_Type");
	
	String P_access_data = request.getParameter("Access_Data");
	String P_patient_type = request.getParameter("Patient_Type");
	String patient_class    = request.getParameter("patient_class");
	String context=request.getParameter("Context");
	String practitioner_type	=	request.getParameter("practitioner_type");
	if(practitioner_type.equals(""))	
		practitioner_type = ((String)session.getValue("practitioner_type"));

    String func=request.getParameter("Fn_Name");
	String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
	String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
	String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
	String QueryString = request.getParameter("QueryString")==null?"":request.getParameter("QueryString");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
	String calledFromDeathReg = request.getParameter("calledFromDeathReg")==null?"N":request.getParameter("calledFromDeathReg");
	String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	String associate_codes = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
	String P_radio_par = request.getParameter("radio_par");
	String P_jsp_name = request.getParameter("jsp_name");
	String P_pr =request.getParameter("pr");

	String dob   = request.getParameter("Dob");	
	String sex   = request.getParameter("Sex");	
	String state=request.getParameter("function")==null?"":request.getParameter("function");

	if(context!=null)
	{
			if(context.equals("PatientQueue")	)
					P_patient_type="O";
			else
					P_patient_type="C"; 
	}


    con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rset=null ;

	Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String loginuser=p.getProperty( "login_user" ) ;
	String facilityId = (String)session.getValue("facility_id");

	
		

            _bw.write(_wl_block9Bytes, _wl_block9);

try{

       /*Below line added for this CRF GDOH-CRF-0082*/			
		boolean diagnosisPmb=CommonBean.isSiteSpecific(con, "MR","DIAG_MAPPED_PMB"); 	
	   //End GDOH-CRF-0082  

	int a = 0;
	/*Access_scope was changed from "HR" to "SD" in the query for the SKR-SCF-0492 (IN032655) by Maheshwaran K as on 08/05/2012*/
	String sql = " Select '1' from mr_user_access_rights_vw where appl_user_id = ? and access_type = 'E' and patient_type ='C' and access_scope= 'SD' and facility_id=?" ;
	pstmt=con.prepareStatement(sql);
	pstmt.setString(1,loginuser);
	pstmt.setString(2,facilityId);
	rset=pstmt.executeQuery();
	
	
	if(!(rset.next()))
	{
			a=1;
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(a));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(P_access_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_access_data));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_patient_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(func));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(context));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(calledFromDeathReg));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(context));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(calledFromDeathReg));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(state));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(context));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(QueryString));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(state));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(calledFromDeathReg));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(context));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(QueryString));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(state));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(calledFromDeathReg));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(state));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(calledFromDeathReg));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(context));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(P_jsp_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(context));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_radio_par));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(P_pr));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(diagnosisPmb));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(diagnosisPmb));
            _bw.write(_wl_block71Bytes, _wl_block71);

	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();

} //end try
catch(Exception e ){
	/* out.println("Exception in Authorize.jsp"+e.toString()); */ e.printStackTrace();}
finally{
//	if(stmt!=null) stmt.close();
	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block72Bytes, _wl_block72);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
