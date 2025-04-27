package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import org.json.simple.*;

public final class __diagrecodepatproblemval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagRecodePatProblemVal.jsp", 1709118904892L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" <!-- modified by mujafar for ML-MMOH-CRF-1281 US3-->\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script>\n<script src=\'../js/RecDiagnosisMain.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'INVALID_DIAG_CODE\',\'MR\'));\n\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null){\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].Description.value=\'\';\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value=\'\';\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value=\'\';//select();\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility=\'hidden\'; \n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility=\'hidden\';\n\t\t\t\t\t\t//parent.RecDiagnosisAddModify.document.forms[0].view_link.style.visibility=\'hidden\';\n\t\t\t\t\t\t<!--Below line added for Bru-HIMS-CRF-024.2-->\n\t   \t\t            if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=\'\'))\n\t\t                {     \n\t\t\t                   parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;\n\t\t                }\n\t\t\t\t\t\tif((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled)&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=\'\'))\n\t                    {     \n\t                     parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;\n\t                    }\n\t\t\t\t\t\tif((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value==\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value==\'\'))\n\t\t                {     \n\t\t\t                   parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=true;\n\t\t                }\n\t\t\t\t\t\t//Below line added for this CRF GDOH-CRF-0082\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"==\"true\"){\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'hidden\';\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=\"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//End GDOH-CRF-0082\n\t\t\t\t\t\t\n\t\t\t\t\t}else if(parent.addModifyPatProblem!=null){\n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].code.value=\'\';\n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].Description1.value=\'\';\n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].code.focus();\n\t\t\t\t\t}\n\t\t\t\t\tgetCodeSet();setTermCode1();\n\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'CODE_NOT_SELECTABLE\',\'MR\'));\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null){\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].Description.value=\'\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value=\'\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value=\'\';//select();\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility=\'hidden\'; \n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility=\'hidden\';\n\t\t\t\t\t\t\t//parent.RecDiagnosisAddModify.document.forms[0].view_link.style.visibility=\'hidden\';\n\t\t\t\t\t\t  //Below line added for this CRF GDOH-CRF-0082\n\t\t\t\t\t\t  if(\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"==\"true\"){\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'hidden\';\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=\"\";\n\t\t\t\t\t\t  }\n\t\t\t\t\t\t //End GDOH-CRF-0082\t\t\t\t\t\t\t\n\t\t\t\t\t\t}else if(parent.addModifyPatProblem!=null){\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].code.value=\'\';\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].Description1.value=\'\';\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].code.focus();\n\t\t\t\t\t\t}\n\t\t\t\t\t\tgetCodeSet();setTermCode1();\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\n\t\t\t\tif(parent.RecDiagnosisAddModify!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].Description.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].cause_indicator.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].notifiable_yn.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].sensitive_yn.value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify.document.getElementById(\'other_disp1\')) // Added by mujafar for ML-MMOH-CRF-1281 US3\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'other_disp1\').style.visibility=\'visible\'; \n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'other_disp2\').style.visibility=\'visible\';\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar select = parent.RecDiagnosisAddModify.document.forms[0].term_oth_desc;\n\t\t\t\t\t\t\n\t\t\t\t\t\t if (select.type!=\'hidden\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\twhile (select.options.length > 0 )\n\t\t\t\t\t\t\tselect.remove(select.options[0]);\n\t\t\t\t\t\t\tvar element =parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \'-----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----- \';\n\t\t\t\t\t\t\telement.value= \'\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].term_oth_desc.add(element);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t\t\tvar element =parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";//  description";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\t\t\tif(element.value!=\'\')\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].term_oth_desc.add(element);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t   \n\t\t\t\t\t\n\t\t\t\t\t     }\t\n\n\t\n\n\n\n\t\t\t\t\t\t}\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify.document.getElementById(\'other_disp1\'))\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'other_disp1\').style.visibility=\'hidden\'; \n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'other_disp2\').style.visibility=\'hidden\';\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar select = parent.RecDiagnosisAddModify.document.forms[0].term_oth_desc;\n\t\t\t\t\t\t\n\t\t\t\t\t\t if (select.type!=\'hidden\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\twhile (select.options.length > 0 )\n\t\t\t\t\t\t\tselect.remove(select.options[0]);\n\t\t\t\t\t\t\tvar element =parent.RecDiagnosisAddModify.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \'-----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----- \';\n\t\t\t\t\t\t\telement.value= \'\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].term_oth_desc.add(element);\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t   \n\t\t\t\t\t\n\t\t\t\t\t     }\t\n\n\t\n\n\n\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\t\t\t\t\t\t/*Below line added for this CRF GDOH-CRF-0082*/\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"==\"true\"){\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'!=\"\"){ \t\n\t\t\t\t\t\t\t\tvar pmb=getLabel(\"eMR.ThisisPMB.label\",\"MR\");\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'visible\';\t\t\n\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=pmb;\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}else{ \t\n\t\t\t\t\t\t\t\tvar notpmb=getLabel(\"eMR.ThisisnotPMB.label\",\"MR\");\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').style.visibility=\'visible\';\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'pmb_diagnosis\').innerHTML=notpmb;\t\t\t\t\t\t \n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n                        //End this CRF GDOH-CRF-0082 \t\t\t\t\t\t\n\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].LongDescription.value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"; \n\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility=\'visible\';\t\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].ComplaintSrch.disabled=false;\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].dagger_independent_yn.value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";//Added for SRR-CRF-303.2 1/27/2010\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.restirctPrimaryDiag(parent.RecDiagnosisAddModify.document.forms[0].diag_classfication)\n\t\t\t\t\t\t//parent.RecDiagnosisAddModify.document.forms[0].view_link.value=\'viewLink\';\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\"view_link\").style.visibility=\'visible\';\t\n\t\t\t\t\t\t/*parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";*/\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t//parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t}\n\t\t\t\t\telse if(parent.addModifyPatProblem!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].Description.value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].cause_indicator.value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].notifiable_yn.value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].sensitive_yn.value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].LongDescription.value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"; \n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].exclamation.style.visibility=\'visible\';\n\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].Description1.value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].high_risk.style.visibility=\'visible\';\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].high_risk_code.value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify.document.forms[0].high_risk.style.visibility==\'visible\'){\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\"high_risk\").title = \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' ;   \n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].high_risk.style.visibility=\'hidden\'; \n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null){ //alert(\'279\');\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility=\'visible\';\t\n\t\t\t\t\t\t\t<!--Below line added for Bru-HIMS-CRF-024.2-->\n\t   \t\t                 if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup!=null&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code!=null&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc!=null&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=\'\'))\n\t\t                     {\n\t\t\t                   parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;\n\t\t                     }\n\t\t\t\t\t\t\t if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled)&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=\'\'))\n\t                         {     \n\t                            parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;\n\t                        }\n\t\t             \t}else if(parent.addModifyPatProblem!=null){\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility=\'visible\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null){\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility=\'hidden\';\n\t\t\t\t\t\t\t<!--Below line added for Bru-HIMS-CRF-024.2--> \n\t\t\t\t\t\t\t//alert(\'298\');\n\t   \t\t                 if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup!=null&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code!=null&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc!=null&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=\'\'))\n\t\t                     {\n\t\t\t                   parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;\n\t\t                     }\n\t\t\t\t\t\t\t if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!=\'\')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.disabled)&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&& parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value!=\'\'))\n\t                        {     \n\t                           parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=false;\n\t                        }\n\t\t\t\t\t\t}else if(parent.addModifyPatProblem!=null){\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility=\'hidden\';\n\t\t\t\t\t\t}\t\n\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<script>\t\n\t\t\t\t\t\t\t\tif(parent.RecDiagnosisAddModify.document.forms[0].isMultiDescAppl.value==\"true\" && parent.RecDiagnosisAddModify.document.getElementById(\'other_disp1\'))\n\t\t\t\t\t\t\t\t\t{ // Added by mujafar for ML-MMOH-CRF-1281 US3\n\t\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'other_disp1\').style.visibility = \"hidden\";\n\t\t\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.getElementById(\'other_disp2\').style.visibility = \"hidden\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null)\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].code_indicator.value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t\t\telse if(parent.addModifyPatProblem!=null)\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].code_indicator.value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\t\t\t\t\n\t\t\t\t\t</script>\n\n\t\t\t\t<script>\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" == \'D\' || \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" == \'C\')\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null)\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].AddAssociateCodes.disabled=false;\n\t\t\t\t\t\telse if(parent.addModifyPatProblem!=null)\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].AddAssociateCodes.disabled=false;\n\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{     \n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].AddAssociateCodes.disabled=true;\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].associate_codes.value = \'\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(parent.addModifyPatProblem!=null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].AddAssociateCodes.disabled=true;\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].associate_codes.value = \'\';\n\t\t\t\t\t\t}\n\n\t\t\t\t\t}\n\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"==\"N\" && \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"==\"Y\"){ /*age_checked added by Rameswar on 17-OCT-2016 for IN062122*/\n\t\t\t\t\t\t\n\t\t\t\t\t\t\talert(getMessage(\'RECORDING_SUPPRT_DIAG_NOT_ALLOWED\',\'MR\'));\n\t\t\t\t\t\t}else if(\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"==\"N\"){\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\talert(getMessage(\'MR_INVALID_DIAG_CODE_FOR_PATIENT\',\'MR\'));\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(parent.RecDiagnosisAddModify!=null){\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].Description.value=\'\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value=\'\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_code.focus();\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value=\'\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility=\'hidden\';\n\t\t\t\t\t\t\tparent.RecDiagnosisAddModify.document.forms[0].AddAssociateCodes.disabled=true;\n\t\t\t\t\t\t}else if(parent.addModifyPatProblem!=null){\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].Description.value=\'\';\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].Description1.value=\'\';\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].code.focus();\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].code.value=\'\';\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility=\'hidden\';\n\t\t\t\t\t\t\tparent.addModifyPatProblem.document.forms[0].AddAssociateCodes.disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tgetCodeSet();setTermCode1();\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

public static String checkForNull(String inputString){
return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null; 
    PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs = null;
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale = checkForNull((String)session.getAttribute("LOCALE")); 

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);



	try
	{
		con = ConnectionManager.getConnection(request);
		String code_set			=	checkForNull(request.getParameter("code_set"));
		String p_p_diag_code	= 	request.getParameter("p_diag_code");
		String p_scheme			=	request.getParameter("p_scheme");
		String cause_indicator	=	request.getParameter("p_cause_indicator");
		String sensitive_yn		=	request.getParameter("p_sensitive_yn");
		String sex		=	request.getParameter("Sex");
		String dob		=	request.getParameter("Dob");
		int descCount=0;
		String isMultiDescAppl = request.getParameter("isMultiDescAppl"); // added by mujafar for ML-MMOH-CRF-1281
		JSONObject DescriptionJsonObj		= new JSONObject();
		DescriptionJsonObj = eMR.MRCommonBean.getTermCodeDescription(con,code_set,p_p_diag_code);
		JSONArray DescriptionJsonArray 		= (JSONArray)DescriptionJsonObj.get("results");
		JSONObject termCodeCountObj = new JSONObject();
		JSONObject multi_desc_ynObj = new JSONObject();
		Integer termCodeCount =0;
		String multi_desc_yn = "N";
		if(DescriptionJsonArray.size() > 0)
		{
		termCodeCountObj	= (JSONObject)DescriptionJsonArray.get(0);
		//multi_desc_ynObj	= (JSONObject)DescriptionJsonArray.get("multi_desc_yn");

		termCodeCount = (Integer)termCodeCountObj.get("termCodeCount");
		multi_desc_yn = checkForNull((String)termCodeCountObj.get("multi_desc_yn"));
		if(isMultiDescAppl.equals("true") && termCodeCount == 1 && multi_desc_yn.equals("Y")) descCount = 1;
		}

		String code_indicator		= "";
		String select_yn		 = "";
		String dagger_independent_yn = "";//Added For SRR-CRF-303.2 added For 1/25/2010.
		String valid_diag	= "Y";//Added For SRR-CRF-303.2 added For 1/25/2010.
		String age_check	= "Y";//Added For SRR-CRF-303.2 added For 1/25/2010.
		boolean proceed		= true;//Added For SRR-CRF-303.2 added For 1/25/2010.
		//String associate_codes  = request.getParameter("associate_codes")==null?"N":request.getParameter("associate_codes");
		
		
		String authorizeButton=request.getParameter("authorizeButton")==null?"N":request.getParameter("authorizeButton");
//		String p_diag_code		=   p_p_diag_code.trim();
		String p_diag_code		=   p_p_diag_code;
		/*Below line added for this CRF GDOH-CRF-0082*/	
		String pmb_code="";
		boolean diagnosisPmb=CommonBean.isSiteSpecific(con, "MR","DIAG_MAPPED_PMB"); 	
		//End GDOH-CRF-0082
		
		if (!(p_diag_code == null || p_diag_code.equals("null")||p_diag_code.length()==0)){
			String p_diag_desc ="";
			String p_cause_indicator ="";
			String p_notifiable_yn ="";
			String p_sensitive_yn ="";
			String p_longdescription="";
			int record_count=0;
			StringBuffer sql = new StringBuffer();
			String high_risk_code="";
			String highRiskDesc="";  // Saantha
/*****************modify this query*******************************/
			//sql.append(" select b.short_desc, b.cause_indicator, b.notifiable_yn, b.sensitive_yn, b.long_desc, b.code_indicator from MR_TERM_CODE a, MR_ICD_CODE b where a.term_code = b.diag_code and b.diag_code = ? and b.diag_code_scheme = ? and (b.code_indicator in ('D','C') OR b.code_indicator IS NULL) ");

//--from  MR_D_"+term_set_id+"_VW
/*****************modify this query*******************************/
			sql.append(" select a.short_desc,a.cause_indicator,a.notifiable_yn, a.sensitive_yn, a.long_desc, a.code_indicator,a.dagger_independent_yn,a.high_risk_code,mr_get_desc.mr_high_risk(a.high_risk_code,'"+locale+"','1') highRiskDesc,a.select_yn from   MR_D_"+code_set+"_lang_VW a where  a.TERM_CODE=upper('"+p_diag_code+"') and a.TERM_SET_ID = '"+code_set+"' and a.eff_status='E' and language_id='"+locale+"' ");

			stmt=con.createStatement();
			rs = stmt.executeQuery(sql.toString());
			String t_cause_indicator = "";
			while( rs.next() ){
				t_cause_indicator	=	checkForNull( rs.getString("cause_indicator") );
				if( (record_count==0) || (cause_indicator.equals(t_cause_indicator)) ){
					p_cause_indicator	=	t_cause_indicator;
					p_diag_desc 		=	checkForNull( rs.getString("short_desc") );
					p_notifiable_yn		=	checkForNull( rs.getString("notifiable_yn") );
					p_sensitive_yn		=	checkForNull( rs.getString("sensitive_yn") );
					p_longdescription	=   checkForNull(rs.getString("long_desc"));
					code_indicator		= checkForNull(rs.getString("code_indicator"));
					dagger_independent_yn		= checkForNull(rs.getString("dagger_independent_yn"),"N");
					select_yn			= checkForNull(rs.getString("select_yn"),"N");
					high_risk_code		= checkForNull(rs.getString("high_risk_code"));
					highRiskDesc		= checkForNull(rs.getString("highRiskDesc"));   //Saantha
				}
				record_count++;
			}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			
			/*Below line added for this CRF GDOH-CRF-0082*/	
            if(diagnosisPmb){				
				 pmb_code=eMR.MRQueryPMBCode.getPMBCode(con,p_diag_code);
            }			
			//End GDOH-CRF-0082
			
			int view_cnt = 0;
			String view_link = "SELECT Count(*) FROM mr_equivalent_term_code  WHERE term_code = ? and CROSS_REF_TYPE='EQ'";
			pstmt = con.prepareStatement( view_link ) ;
			pstmt.setString( 1, p_diag_code) ;
			rs = pstmt.executeQuery();
			if(rs != null && rs.next())
				view_cnt = rs.getInt(1);
			if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			if(record_count==0){
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(diagnosisPmb));
            _bw.write(_wl_block6Bytes, _wl_block6);

			}else if(select_yn.equals("N")){
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(diagnosisPmb));
            _bw.write(_wl_block8Bytes, _wl_block8);

			}else{
				int valid_cnt=0;
				int age_cnt=0;
				sql = new StringBuffer();
//				String QUERY_FOR_VALID_CODE ="";
				String QUERY_FOR_PAT_AGE ="";
				//sql.append("select count(*) from mr_icd_code where diag_code=? and diag_code_scheme=?  and ( gender_spec_ind = ? OR gender_spec_ind IS NULL)  and ( nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind IN  ( select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'N'  END FROM MR_PARAMETER )) AND (code_indicator not in ('A','E') OR code_indicator IS NULL) ");
				//sql.append("select count(*) from MR_D_"+code_set+"_VW where TERM_SET_ID =? AND TERM_CODE=upper(?) and ( gender_spec_ind = ? OR gender_spec_ind IS NULL)  and ( nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind IN  ( select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'N'  END FROM MR_PARAMETER )) AND (code_indicator not in ('A','E') OR code_indicator IS NULL) ");

				// 
				/* 
					6/5/2009 modified for IN011172
				*/
				/*sql.append("select count(*) from MR_D_"+code_set+"_VW a where TERM_SET_ID =? AND TERM_CODE=upper(?)and (gender_spec_ind = ? OR gender_spec_ind IS NULL) AND (code_indicator not in ('A','E') OR code_indicator IS NULL or dagger_independent_yn='Y')  AND (1 = (SELECT check_age_between (to_date(?,'dd-mm-yyyy'),min_age,age_unit,max_age + 1,age_unit_max) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR a.age_spec_ind IS null) ");*/
//				sql.append("select count(*) from MR_D_"+code_set+"_VW a where TERM_SET_ID =? AND TERM_CODE=upper(?)and (gender_spec_ind = ? OR gender_spec_ind IS NULL) AND (code_indicator not in ('A','E') OR code_indicator IS NULL)  AND (1 = (SELECT check_age_between (to_date(?,'dd-mm-yyyy'),min_age,age_unit,max_age + 1,age_unit_max) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR a.age_spec_ind IS null) ");

				String cd_ind="";
				String dag_ind="";
				QUERY_FOR_PAT_AGE ="SELECT COUNT(*) COUNT,CODE_INDICATOR,DAGGER_INDEPENDENT_YN FROM MR_D_"+code_set+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?)AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL)group by CODE_INDICATOR,DAGGER_INDEPENDENT_YN";
					pstmt=con.prepareStatement(QUERY_FOR_PAT_AGE);
					pstmt.setString(1,code_set);
					pstmt.setString(2,p_diag_code);
					pstmt.setString(3,sex);
					pstmt.setString(4,dob);
					rs = pstmt.executeQuery();

					if(rs!=null && rs.next()){
						age_cnt=rs.getInt("COUNT");
						cd_ind=checkForNull(rs.getString("CODE_INDICATOR"));
						dag_ind=checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"));
						if(cd_ind.equals("") || cd_ind.equals("D")||cd_ind.equals("C") || dag_ind.equals("Y") ){
							valid_cnt=1;						
						}
						
					}
					/*Below age_cnt is added by Rameswar on 17-OCT-2016 for IN062122*/
				if(age_cnt==0){
						age_check="N";
						}
				
				/*QUERY_FOR_VALID_CODE ="SELECT COUNT(*) COUNT FROM MR_D_"+code_set+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE = UPPER (?) AND ( CODE_INDICATOR NOT IN ('A', 'E') OR CODE_INDICATOR IS NULL OR DAGGER_INDEPENDENT_YN = 'Y') ";
				pstmt=con.prepareStatement(QUERY_FOR_VALID_CODE);
				pstmt.setString(1,code_set);
				pstmt.setString(2,p_diag_code);
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()){
					valid_cnt=rs.getInt("COUNT");
				}
				*/
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();

				if(valid_cnt>0){
					/*QUERY_FOR_PAT_AGE ="SELECT COUNT(*) COUNT FROM MR_D_"+code_set+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?)AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL)";
					pstmt=con.prepareStatement(QUERY_FOR_PAT_AGE);
					pstmt.setString(1,code_set);
					pstmt.setString(2,p_diag_code);
					pstmt.setString(3,sex);
					pstmt.setString(4,dob);
					rs = pstmt.executeQuery();
					if(rs!=null&&rs.next()){
						age_cnt=rs.getInt("COUNT");
					}
					*/
					/*if(age_cnt==0){
						age_check="N";
					}*/// age_cnt is Commented by Rameswar on 17-OCT-2016 for IN062122
				}else{
					valid_diag="N";
				}
				if(valid_diag.equals("N")||age_check.equals("N")){
					proceed=false;
				}

				/*pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1,code_set);
				pstmt.setString(2,p_diag_code);
				pstmt.setString(3,sex);
				pstmt.setString(4,dob);
				rs = pstmt.executeQuery();
				rs.next();*/
				if(proceed){
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_diag_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_cause_indicator));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_notifiable_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_sensitive_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_diag_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(descCount>0){
            _bw.write(_wl_block15Bytes, _wl_block15);

							JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);

							String descriptions="";
							for(int i=1;i<=10;i++)
							{
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+i));
								
							
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block19Bytes, _wl_block19);

							}	
							
            _bw.write(_wl_block20Bytes, _wl_block20);
}
					else{
					
            _bw.write(_wl_block21Bytes, _wl_block21);

							JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);

							String descriptions="";
							for(int i=1;i<=10;i++)
							{
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+i));
								System.out.println("descriptions else:"+descriptions);
							
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(descriptions));
            _bw.write(_wl_block19Bytes, _wl_block19);

							}	
							
            _bw.write(_wl_block23Bytes, _wl_block23);

						}	
						
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(diagnosisPmb));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pmb_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_longdescription));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(view_cnt>0){
            _bw.write(_wl_block29Bytes, _wl_block29);
}/*else{*/
            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_diag_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_cause_indicator));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_notifiable_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(p_sensitive_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_longdescription));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(p_diag_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);

				if(high_risk_code!=""){
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(high_risk_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(highRiskDesc));
            _bw.write(_wl_block40Bytes, _wl_block40);
}else{
						
            _bw.write(_wl_block41Bytes, _wl_block41);

					}
				
					if(p_notifiable_yn.equals("Y") )
					{	
            _bw.write(_wl_block42Bytes, _wl_block42);

					}
					else
					{	
            _bw.write(_wl_block43Bytes, _wl_block43);
	}

					/*
					if(p_longdescription!=null )
					{
						a1.append("parent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility='visible';");
					}
					else
					{
						a1.append("parent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility='hidden';");
					}
					*/
					if(p_cause_indicator!=null)
					{
						if(p_cause_indicator.equals("E") && p_scheme.equals("2"))
						out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.options[1].selected=true;</script>");	
					}else
					{
						if(p_scheme.equals("2"))
							out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.options[0].selected=true;</script>");
					}
					if(record_count==1)
					{
						if(p_scheme.equals("2"))
						{
							if(p_cause_indicator.equals("E"))
							out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.selectedIndex=1;</script>");
							else
							out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.selectedIndex=0;</script>");
							out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.disabled=true;</script>");
						}
					}
					if(record_count>1)
						out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].cause_ind.disabled=false;</script>");
					
					
					if(!sensitive_yn.equals("Y"))
					{
						if(p_sensitive_yn.equals("Y"))
						{

							if (authorizeButton.equals("N"))
							{ 
								
								out.println("<script>alert(getMessage('DIAG_AUTH_REQD','CA'));</script>");
								out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].Description.value='';</script>");
								out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value='';</script>");
								
            _bw.write(_wl_block44Bytes, _wl_block44);

							}

							if (authorizeButton.equals("N"))
							{
								out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.focus();</script>");
								out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value='';/*select();*/</script>");
							}

							
							if (authorizeButton.equals("Y"))
							{
								//out.println("<script>parent.RecDiagnosisAddModify.chkAuthorize(parent.PatProblemQueryTools.document.forms[0].authorize,'"+code_indicator+"');</script>");
								//out.println("<script>parent.RecDiagnosisAddModify.chkAuthorize('Authorize Mode','"+code_indicator+"');</script>");	
							
								out.println("<script>								if(parent.RecDiagnosisAddModify!=null)parent.RecDiagnosisAddModify.chkAuthorize(parent.RecDiagnosisOpernToolbar.document.forms[0].mode,'"+code_indicator+"'); else if(parent.addModifyPatProblem!=null)parent.addModifyPatProblem.chkAuthorize(parent.PatProblemQueryTools.document.forms[0].mode,'"+code_indicator+"');</script>");	
									
							}
					
						}
					}
									
					
					
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block49Bytes, _wl_block49);

				}else{
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(valid_diag));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(age_check));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(age_check));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}
			}
		}else{
			out.println("<script>parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value='';</script>");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{	
		//out.println(e.toString()); 
		e.printStackTrace();
	}
	finally 
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block54Bytes, _wl_block54);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
