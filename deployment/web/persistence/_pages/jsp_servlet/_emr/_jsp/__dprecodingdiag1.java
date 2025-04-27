package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __dprecodingdiag1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingDiag1.jsp", 1742299832457L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script> \n\t<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\n\n\t\tfunction disableButtons(){\n//\t\t\t\t\tparent.RecodeScreen.rows=\"47%,47%,0%,0%\";\n\t\t\t\t\tvar allow_recode_diag_yn\t= document.getElementById(\'allow_recode_diag_yn\').value;\n\t\t\t\t\tvar allow_recode_proc_yn\t= document.getElementById(\"allow_recode_proc_yn\").value;\n\t\t\t\t\tif(allow_recode_diag_yn==\"Y\" && allow_recode_proc_yn==\"Y\"){\n\t\t\t\t\t\tparent.RecodeScreen.rows=\"48%,48%,4%,0%\";\n\t\t\t\t\t}else if(allow_recode_diag_yn==\"Y\"){\n\t\t\t\t\t\tparent.RecodeScreen.rows=\"95%,0%,5%,0%\";\n\t\t\t\t\t}else if(allow_recode_proc_yn==\"Y\"){\n\t\t\t\t\t\tparent.RecodeScreen.rows=\"10%,85%,5%,0%\";\n\t\t\t\t\t}\n\t\t\t\t\tif(parent.frames[4].document.forms[0].new_code_diag){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].new_code_diag.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].new_code_diag.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].new_code_proc){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].new_code_proc.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].new_code_proc.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].recode){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].recode.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].recode.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].confirm){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].confirm.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].confirm.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].error){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].error.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].error.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].complete){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].complete.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].complete.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t}\n\n\t\t/*function disable_confirmed_Buttons(){               \n\n\t\t\t\t\tvar final_diag_values=parent.frames[2].document.forms[0].final_diag_values.value;\n\t\t\t\t\tvar final_proc_values=parent.frames[3].document.forms[0].final_proc_values.value;\n\n\t\t\t\t\tvar out_arr=\"\";\n\n\t\t\t\t\tvar DB_Chkdiag_Values=\"\";\n\t\t\t\t\tvar DB_Chkdiag_srl_no=\"\";\n\t\t\t\t\tvar DB_Chkproc_Values=\"\";\n\t\t\t\t\tvar DB_Chkproc_srl_no=\"\";\n\n\t\t\t\t\tvar error=\'\';\n\n\n\t\t\t\t\tif(final_diag_values!=\"\"){\n\t\t\t\t\t\t out_arr=final_diag_values.split(\"~\");\n\t\t\t\t\t\tfor(i=0;i<out_arr.length-1;i++){\n\t\t\t\t\t\t\tvar in_arr=out_arr[i].split(\"$\");\n\t\t\t\t\t\t\tif(in_arr[3]!=\'Confirmed\'){\n\t\t\t\t\t\t\t\terror=\"Y\";\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(final_proc_values!=\"\"){\n\t\t\t\t\t\tout_arr1=final_proc_values.split(\"~\");\n\t\t\t\t\t\tfor(ij=0;ij<out_arr1.length-1;ij++){\n\t\t\t\t\t\t\tvar in_arr1=out_arr1[ij].split(\"$\");\n\t\t\t\t\t\t\tif(in_arr1[3]!=\'Confirmed\'){\n\t\t\t\t\t\t\t\terror=\"Y\";\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(error==\"\"){\n\t\t\t\t\t\tif(parent.frames[4].document.forms[0].recode){\n\t\t\t\t\t\t\tparent.frames[4].document.forms[0].recode.disabled=true;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[4].document.forms[0].confirm){\n\t\t\t\t\t\t\tparent.frames[4].document.forms[0].confirm.disabled=true;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[4].document.forms[0].error){\n\t\t\t\t\t\t\tparent.frames[4].document.forms[0].error.disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t}\t*/\n\t\tfunction expandDiagnosis()\t{\n\t\t\t/* parent.RecodeScreen.rows=\"85%,10%,5%,0%\"; */\n\t\t\tparent.document.getElementById(\"DiagProcRecodingPatDetail\").style.height=\"59vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisDiag\").style.height=\"63vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisProc\").style.height=\"12vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisButton\").style.height=\"9vh\";\n\t\t\tparent.document.getElementById(\"DiagProcTrans\").style.height=\"0vh\";\n\t\t\tparent.frames[3].document.getElementById(\"Proc_icon\").innerHTML=\"<a href=\'javascript:onclick=expandProcedure()\'>+</a>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t//parent.frames[3].scrolling=\"no\";\n\t\t\tparent.frames[2].document.getElementById(\"Diag_icon\").innerHTML=\"<a href=\'javascript:onclick=collapseDiagnosis()\'>-</a>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t}\n\n\t\tfunction collapseDiagnosis()\t{\n\t\t\t/* parent.RecodeScreen.rows=\"48%,48%,4%,0%\"; */\n\t\t\tparent.document.getElementById(\"DiagProcRecodingPatDetail\").style.height=\"40vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisDiag\").style.height=\"44vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisProc\").style.height=\"29vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisButton\").style.height=\"4vh\";\n\t\t\tparent.document.getElementById(\"DiagProcTrans\").style.height=\"0vh\";\n\t\t\tparent.frames[2].document.getElementById(\"Diag_icon\").innerHTML=\"<a href=\'javascript:onclick=expandDiagnosis()\'>+</a>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\n\t\t}\n\n\t\tfunction showDiag()\t{\n\t\t\t//if(mode.equals(\"Y\"))\n\t\t\t\t//parent.frames[2].document.RecodeDiagnosisDiagDetail.diagTable.visiblity=\'visible\';\n\t\t}\n\n\n\t\t\n\tfunction expandHist(i)\t{\n\tvar sel=i;\n\tvar len=eval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist\"+parseInt(sel)).length;\n\t\t\n\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist\"+parseInt(sel)).style.visibility=\'visible\';\n\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist\"+parseInt(sel)).style.display=\'inline\';\n\t\t\n\t\n\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodeSymbol\"+parseInt(sel)).innerHTML=\"<a href=\'javascript:onclick=collapseHist(\"+parseInt(sel)+\")\'>-</a>\";\n\t\n}\n\nfunction collapseHist(i)\t{\n\n\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist\"+parseInt(i)).style.visibility=\'hidden\';\n\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist\"+parseInt(i)).style.display=\'none\';\n\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodeSymbol\"+parseInt(i)).innerHTML=\"<a href=\'javascript:onclick=expandHist(\"+parseInt(i)+\")\'>+</a>\";\n}\n//Added by Ajay Hatwate for ML-MMOH-CRF-1940\nfunction longDescToolTip(term_code, long_desc) {\n    var tab_data2 = \"<div class=\'tooltip1\'> \" + term_code + \" / \" + long_desc + \"</div>\";\n    return tab_data2;\n}\n\t</script>\n\t</head>\n\t<body onKeyDown=\'lockKey()\'; onLoad=\'document.getElementById(\"clinical_err_histry\").focus();\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="onunload=\"destroyPopUps()\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t<form name=\"RecodeDiagnosisDiagDetail\" id=\"RecodeDiagnosisDiagDetail\" method=\'post\' >\n\t<table id=\'diagTable\' style=\'visibility:visible;display:inline\' border=0 cellpadding=\'1\' cellspacing=\'0\' width=\"100%\"  valign=\'top\' onLoad=\'showDiag();\'>\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=\'fields\'><select name=\'show_level\' id=\'show_level\' onChange=\'getLevel(this);\' onmousewheel=\'return false;\'>\n\n\t\t<option value=\'0\'>Original</option>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<option value=\'1\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;1</option>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;1</option>\n\t\t\t\t<option value=\'2\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;2</option>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;1</option>\n\t\t\t\t<option value=\'2\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;2</option>\n\t\t\t\t<option value=\'3\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;3</option>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<option value=\'1\'selected>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;2</option>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;1</option>\n\t\t\t\t<option value=\'2\' selected>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;2</option>\n\t\t\t\t<option value=\'3\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;3</option>\n\n\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</select>\n\t\t</td>\n\t\t<td colspan=\"5\">\n\t\t<input type=\'button\' name=\'Reject_Diag\' id=\'Reject_Diag\' class=\'button\'  onclick=\'Original_Diag();\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'   style=\"visibility:hidden\">\n\t\t&nbsp;\n\t\t<input type=\'button\' name=\'Reject_Proc\' id=\'Reject_Proc\' class=\'button\'  onclick=\'Original_Proc();\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  style=\"visibility:hidden\">&nbsp;\n\t\t\n\t\t</td>\n\t\t<td id=\'viewClinicalHistory\' nowrap style=\"padding-left: 550px;\">\n\t\t\t<a href=\"javascript:onclick=DummyRef()\" id=\"clinical_err_histry\" onclick=\"displayMenu()\"  style=\"cursor:pointer\" >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</a>&nbsp;&nbsp;\n\t\t</td>\n\t\t<td colspan=\"1\" id=\'errorHistory\' style=\"display:none\" nowrap>\n\t\t\t<img src=\'../../eCommon/images/view.gif \'  style=\"cursor:pointer;\"onclick=\"show_err_history(\'MRK_ERR\')\" alt=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >&nbsp;&nbsp;\n\t\t</td>\n\t\t<td  id=\'exlucdeCodeHistory\' style=\"display:none\" nowrap>\t\t\t\n\t\t\t<img src=\'../../eCommon/images/disabled.gif \'  style=\"cursor:pointer;\"onclick=\"show_err_history(\'EX_CODES\')\" alt=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">&nbsp;&nbsp;\n\t\t</td>\n\t<td id=\'origerrorHistory\' style=\"display:none\" nowrap>\n\t\t\t<img src=\'../../eCommon/images/PI_SuspendedPatient.gif \'  style=\"cursor:pointer;\"onclick=\"show_err_history(\'ORIG_MRK_ERR\')\" alt=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">&nbsp;&nbsp;\n\t</td>\n\n\t\t</tr>\n\n\t\t<table style=\"visibility:";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" border=0 width=\"100%\" cellpadding=\'1\' cellspacing=\'0\'>\n\n\t\t\t<tr><td colspan=\'14\' class=\'PANELTOOLBAR\' id=\"Diag_icon\"><a href=\"javascript:onclick=expandDiagnosis()\"  style=\"visibility:";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">+</a>&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td></tr>\n\t\t<tr>&nbsp;</tr>\n\t\t<tr>\n\t\t\t<th align=\'center\'>&nbsp;</th>\n\t\t\t<th align=\'center\' >&nbsp;</th><!-- Addedd On 7/2/2009 -->\n\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</th>\n\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</th>\n\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th>\n\t\t\t<th align=\'center\' >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;&nbsp;</th>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<th align=\'center\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</th> <!--modified by mujafar for ML-MMOH-CRF-1270 -->\n\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdd_trx_no";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"hdd_trx_no";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t\t\t\t\t\t<select name=\'seqdiag";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'seqdiag";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' disabled onchange=\"validate_duplicate_diag(this,";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =")\">\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/EqivDiag.gif\'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"onclick=\'callDetails(\"Eq_Term_cd\",\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\",\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\",\"\",\"\",\"\",\"\",\"\")\' alt=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"><img src=\'../../eCommon/images/SuppDiag.gif\'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"onclick=\'recodeSupportDiagnosis(\"RECODE\",\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\")\' alt=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"><img src=\'../../eCommon/images/RecodeRemarks.gif\'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"onclick=\'callDetails(\"Remarks\",\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\",\"N\",\"\",\"\")\' alt=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"><span nowrap title=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" style=\"cursor:pointer;display:";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"><a href=\"javascript:showLongDescription(\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\')\"><b>!</b></a></span>\n\t\t\t\t\t\t\t</td>\t<!-- Equalent Term Code,Support Diag&Remarks Images  -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!--Modified by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'><input type=\'checkbox\' name=\'select_chk1";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'select_chk1";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="$";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="~\' onClick=\'enableSelect1(";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =",this,document.forms[0].term_code.value)\' ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" ></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Status";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"Status";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"></td>\t<!-- Status -->\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="&nbsp;/&nbsp;<a href=\"javascript:onclick=enableSelect1(";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =",document.forms[0].select_chk1";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =",document.forms[0].term_code.value,\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\',\'Modify\')\" >";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</a>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'></td><!-- Term Set | Term Code & Dagger Independent Indicator-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t<!-- Added by Ajay Hatwate for ML-MMOH-CRF-1940 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" \n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" onMouseOver=\"Tip(longDescToolTip(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\', \'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'))\" onMouseOut=\"UnTip()\">";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td><!-- Diag.Desc -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>&nbsp;";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&nbsp;</td><!-- Diag Classification  -->\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'nowrap>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n\t\t\t\t\t\t\t<!-- FYI: Added On 9/22/2009 For MDR.  \n\t\t\t\t\t\t\t\t1.Based upon the MDR Cause Of Death the Images will be displayed for a diagnosis which is having the death_reg_seq_no=1 that is the Primary.\n\t\t\t\t\t\t\t\t2.The same approach is followed for Recoded Codes,History and Original Codes  also.\n\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>&nbsp;<img src=\'../../eCommon/images/Y-Red.gif\' alt=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"/></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>&nbsp;<img src=\'../../eCommon/images/y-white.gif\' alt=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>&nbsp;<img src=\'../../eCommon/images/n-white.gif\' alt=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>&nbsp;<img src=\'../../eCommon/images/n-white.gif\'/></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td id=\'recodeSymbol";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' class=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdd_trx_no";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<select name=\'seqdiag";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =")\">\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:onclick=expandHist(\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\')\">+</a>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/EqivDiag.gif\'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\')\"><b>!</b></a></span>\n\t\t\t\t\t\t\t\t\t\t</td>\t<!-- Equalent Term Code,Support Diag&Remarks Images  -->\n\n\t\t\t\t\t\t\t\t\t\t<!--Modified by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="~\'\t\n\t\t\t\t\t\t\t\t\t\tonClick=\'enableSelect1(";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Status";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"></td>\t<!-- Status -->\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' nowrap>";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'></td><!-- Term Set | Term Code & Dagger Independent Indicator-->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td><!-- Diag.Desc -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t\t\t\t<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="&nbsp;</td><!-- Diag Classification  -->\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n\t\t\t\t\t\t\t\t\t\t<!-- Added On 9/22/2009 For MDR -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' >&nbsp;<img src=\'../../eCommon/images/Y-Red.gif\' alt=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\"/></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' >&nbsp;<img src=\'../../eCommon/images/y-white.gif\' alt=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' >&nbsp;<img src=\'../../eCommon/images/n-white.gif\' alt=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\"/></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>&nbsp;<img src=\'../../eCommon/images/n-white.gif\'/></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td colspan=10 align=\"left\" width=\"100%\">\n\t\t\t\t\t\t\t\t\t\t<tbody id=\"recodehist";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" style=\'visibility:hidden;display:none\'>\n\t\t\t\t\t\t\t\t\t\t<tr><td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdd_trx_no";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t\t\t\t<select name=\'seqdiag";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =")\">\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/EqivDiag.gif\'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\')\"><b>!</b></a></span>\n\t\t\t\t\t\t</td>\t<!-- Equalent Term Code,Support Diag&Remarks Images  -->\n\n\t\t\t\t\t\t<!--Modified by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =" ></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"Status";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'></td><!-- Term Set | Term Code & Dagger Independent Indicator-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="<!-- Added by Ajay Hatwate for ML-MMOH-CRF-1940  -->\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</td><!-- Diag.Desc -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="&nbsp;</td><!-- Diag Classification  -->\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</td>\n\t\t\t\t\t\t<!-- Added On 9/22/2009 For MDR -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' >&nbsp;<img src=\'../../eCommon/images/y-white.gif\' alt=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'/></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>&nbsp;<img src=\'../../eCommon/images/n-white.gif\' alt=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t</table>\n\n\t</table>\n\n\t\t\t\t<input type=\'hidden\' name=\'Stage_no\' id=\'Stage_no\' value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'stage_no\' id=\'stage_no\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'EncounterId\' id=\'EncounterId\' value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'Practitioner_Id\' id=\'Practitioner_Id\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'Pat_id\' id=\'Pat_id\' value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'Patient_Class\' id=\'Patient_Class\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'checked_yn\' id=\'checked_yn\' value=\'N\'>\n\t\t\t\t<input type=\'hidden\' name=\'temp_chk\' id=\'temp_chk\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'temp_code\' id=\'temp_code\' value=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'dflt_termset\' id=\'dflt_termset\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'spec_code\' id=\'spec_code\' value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'caused_death\' id=\'caused_death\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'hd_term_set\' id=\'hd_term_set\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'hd_term_code\' id=\'hd_term_code\' value=\'\'>\n\t\t\t\t<input type=\"hidden\" name=\"chk_yn\" id=\"chk_yn\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\t\n\t\t\t\t<input type=\'hidden\' name=\'procedure_yn\' id=\'procedure_yn\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'Lock_all\' id=\'Lock_all\' value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'values_fetched\' id=\'values_fetched\' value=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'final_diag_values\' id=\'final_diag_values\' value=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'active_diag_codes\' id=\'active_diag_codes\' value=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'activity\' id=\'activity\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'allow_recode_diag_yn\' id=\'allow_recode_diag_yn\' value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'allow_recode_proc_yn\' id=\'allow_recode_proc_yn\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'principal_diag\' id=\'principal_diag\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'prin_stg_srl_no\' id=\'prin_stg_srl_no\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'diag_seq_no\' id=\'diag_seq_no\' value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'modify_temp_code\' id=\'modify_temp_code\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'hid_free_text_yn\' id=\'hid_free_text_yn\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'diag_term_set_cnt\' id=\'diag_term_set_cnt\' value=\"0\">\n\t\t\t\t<input type=\'hidden\' name=\'prin_diag_cnt\' id=\'prin_diag_cnt\' value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n\t\t\t\t<!-- In Below line speciality added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300 -->\n\t\t\t\t <input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\"> \n\t\t\t\t <input type=\"hidden\" name=\"isMultiDescAppl\" id=\"isMultiDescAppl\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\"> <!-- added by mujafar for ML-MMOH-CRF-1281 -->\n\t\t\t\t\t   \n\t\t\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tsetTimeout(\'disableButtons()\',150);\t\t\t\t\t\t\n//\t\t\t\t\t\tdisableButtons();\n\t\t\t\t\t</script>\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].show_level.options.selectedIndex=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\';\n\t\t\t\t\t//setTimeout(\'disable_confirmed_Buttons()\',150);\n//\t\t\t\t\tdisable_confirmed_Buttons();\n\t\t\t\t</script>\n\n\t\t\n\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t<script>\n\t\tdocument.forms[0].show_level[0].options.selectedIndex=0;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t<script>\n\t\tdocument.forms[0].Reject_Diag.style.visibility=\"visible\";\n\t</script>\n\n\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t<script>\n\t\tdocument.forms[0].Reject_Proc.style.visibility=\"visible\";\n\t</script>\n\n\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t<script>\n\t\t\tdocument.getElementById(\"errorHistory\").style.display=\"inline\";\n\t\t</script>\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t<script>\n\t\t\tdocument.getElementById(\"exlucdeCodeHistory\").style.display=\"inline\";\n\t\t</script>\n";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t<script>\n\t\t\tdocument.getElementById(\"origerrorHistory\").style.display=\"inline\";\n\t\t</script>\n";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\n\t\t<input type=\"hidden\" name=\"diag_err_cnt\" id=\"diag_err_cnt\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\t\t\n\t\t<input type=\"hidden\" name=\"proc_err_cnt\" id=\"proc_err_cnt\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t\t<input type=\"hidden\" name=\"diag_excodes_cnt\" id=\"diag_excodes_cnt\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n\t\t<input type=\"hidden\" name=\"proc_excodes_cnt\" id=\"proc_excodes_cnt\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t\t<input type=\"hidden\" name=\"diag_origerr_cnt\" id=\"diag_origerr_cnt\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t\t<input type=\"hidden\" name=\"proc_origerr_cnt\" id=\"proc_origerr_cnt\" value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n\t\t<!--Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272-->\n\t\t<input type=\"hidden\" name=\"dischargeSummary\" id=\"dischargeSummary\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n\t\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\" value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">\n\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:15%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr><td width=\'100%\' id=\'t\'></td></tr>\n\t\t\t</table>\n\t\t</div>\t \n\t</form>\n\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eOT/js/wz_tooltip.js\'></script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
 request.setCharacterEncoding("UTF-8");
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
		
 String sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
 //String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
 String loginUser			= (String) session.getValue( "login_user" );	
 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale					= (String)session.getAttribute("LOCALE"); 
String practitioner_type= (String)session.getValue("practitioner_type");//Added On 2/26/2010 For SRR-CRF-303.2 [IN05597]
String ca_practitioner_id= (String)session.getValue("ca_practitioner_id");//Added On 2/26/2010 For SRR-CRF-303.2 [IN05597]
 practitioner_type			= checkForNull(practitioner_type);
 ca_practitioner_id		= checkForNull(ca_practitioner_id);
String EncounterId		= request.getParameter("EncounterId");
 String mode					= checkForNull(request.getParameter("mode"));
 //String dflt_termset = checkForNull(request.getParameter("dflt_termset"));
 String Pat_id				= checkForNull(request.getParameter("Pat_id"));
 String temp_code			= checkForNull(request.getParameter("temp_code"));
 String gender				= checkForNull(request.getParameter("gender"));
 String age						= checkForNull(request.getParameter("age"));
  String dob					= checkForNull(request.getParameter("dob"));
 String spec_code			= checkForNull(request.getParameter("spec_code"));
 String Patient_Class		= checkForNull(request.getParameter("Patient_Class"));
// String DRGcal = checkForNull(request.getParameter("DRGcal"));
//String drg_temp = checkForNull(request.getParameter("drg_temp"));      
 String stage_no			= checkForNull(request.getParameter("stage_no"));
 String stage_l2				= checkForNull(request.getParameter("stage_l2"));
 //String sequenced_yn = checkForNull(request.getParameter("sequenced_yn"));
// String tot_cnt = checkForNull(request.getParameter("tot_cnt"));
 String cur_Sel				=checkForNull(request.getParameter("sel_val"));
String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
String drg_yn							= checkForNull((String)session.getAttribute("drg_calculation_yn"),"N");
/* In Below line speciality added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
String specialty_code=checkForNull(request.getParameter("specialty_code"));  
String hdr_status ="";

//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
Boolean doctorsDescription = false;
String doctors_description = "";

//Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272
Boolean dischargeSummary = false;
String accession_num = "";

Boolean isMultiDescAppl = false; // added by mujafar for ML-MMOH-CRF-1281

//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
Boolean isDiagClassLongDescAppl = false;
String diag_class_long_desc = "";

 //String recd_count="0";
 int Stage_no = 0;
 //int y=0;
 String chk_yn = "";

if(stage_no != "")
   Stage_no = Integer.parseInt(stage_no);
 if(mode.equals(""))
	mode="N";
if(cur_Sel.equals("")){
	cur_Sel=stage_no;
}
Connection conn		= null;	
CallableStatement main_cal_pstmt	=	null;
PreparedStatement pstmt			= null;
//PreparedStatement pstmt1		= null;
ResultSet rs					= null;
//ResultSet rs1				= null;


try  {
	conn = ConnectionManager.getConnection(request);		
	//PreparedStatement pstmt2		= null;
	//ResultSet rs2				= null;
	StringBuffer sql1 = new StringBuffer();

	PreparedStatement pstmt3		= null;
	ResultSet rs3				= null;
	
	String classValue	 = "";
	String term_set		= "";
	String term_code	= "";
	String term_desc	= "";
	String coded_by	= "";
	String coded_date		= "";
	String causeDeath		= "";
	String recodeStatus	= "";
	String stg_srl_no		= "";
	//String hd_recodeStatus_disp = "";
	String patient_id			= "";
	String orig_term_set		= "";
	String orig_term_code	= "";
	//String authorize_item = "";
	String p_episode_type = "";
	String temp_chk		   = "N";
//	String equivalent_term_code = "";
	String recodeStatus_desc="";
	String recodeStatus_desc_temp=""; // added by mujafar for ML-MMOH-CRF-1270
	//int nc_cnt=0;
	//String rev_flg="N";
	String group_YN		="";
	String stage_seq_no	="";
	//String tem_str="";
	String stage_no_disp	 ="";
	String confirm_yn		 ="";
	String chk_disable		 ="";
	String Lock_all			 ="";
	String values_fetched	 ="";
	String final_diag_values	 ="";
	String active_diag_codes	 ="";
	String DIAG_CLASS_TYPE="";
	String Prin_diag			 ="";
	String prin_stg_srl_no="";
	String dagger_independent_yn	="";// Added For SRR-CRF-303.2
	String disp_dagger_dep_ind		="";// Added For SRR-CRF-303.2
	String cross_ref_type				="";// Added For SRR-CRF-303.2
	String occur_srl_no					="";// Added For SRR-CRF-303.2
	String trx_no			="";
	int prin_diag_cnt	=0;

	int i = 0;
	int seq_no=0;
	//int cnt1 = 0;
	//int auth_cnt = 0;
	
	doctorsDescription =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DOCTOR_DESC"); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
	boolean toolTip_diagnosis	=   eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","TOOLTIP_FOR_DIAGNOSIS");//Added by AJay Hatwate for ML-MMOH-CRF-1940	
	isMultiDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281

	/*Added by Ashwini on 22-Jan-2019 for ML-MMOH-CRF-1272*/
	dischargeSummary =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DISCHARGE_SUMMARY");

	isDiagClassLongDescAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DIAG_CLASS_LONG_DESC"); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364

	JSONObject jsonAccssnNo = eMR.MRCommonBean.getAccessionNum(conn,EncounterId,Pat_id);
	accession_num = (String) jsonAccssnNo.get("accession_num");
	/*End ML-MMOH-CRF-1272*/

	if(Patient_Class.equals("IP"))
		p_episode_type="I";
	else if(Patient_Class.equals("EM"))
		p_episode_type="E";
	else if(Patient_Class.equals("DC"))
		p_episode_type="D";
	else if(Patient_Class.equals("OP"))
		p_episode_type="O";

//String  hide_header		="";
String  hide_dataTable	="";
String  hide_exp			="";
String New_EncounterId="";
/*Note:Based upon the  allow_recode_diag_yn value(Parameter Setup) 
the perticular part is hiding to Display Only Procedure Part To User*/
	if(allow_recode_diag_yn.equals("Y")){
//		hide_header		=	"visible";
		hide_dataTable	=	"visible";
		New_EncounterId=EncounterId; //If allow_recode_diag_yn="Y"
	}else{
//		hide_header		=	"hidden";
		hide_dataTable	=	"hidden";
		New_EncounterId="";
	}
	if(allow_recode_proc_yn.equals("Y")){
		hide_exp	="visible";
	}else{
		hide_exp	="hidden";
	}
	if(practitioner_type.equals("") && ca_practitioner_id.equals("") ){
		String PRACT_TYPE_SQL ="SELECT PRACT_TYPE,PRACTITIONER_ID FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = (SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID = '"+loginUser+"')";
		pstmt=conn.prepareStatement(PRACT_TYPE_SQL);
		rs = pstmt.executeQuery();
		while(rs.next()){
			practitioner_type		= rs.getString("PRACT_TYPE");
			ca_practitioner_id		= rs.getString("PRACTITIONER_ID");
		}
		session.putValue("practitioner_type",practitioner_type);
		session.putValue("ca_practitioner_id",ca_practitioner_id);
	}

				String L1_hdr_status = checkForNull(request.getParameter("L1_hdr_status"));
				String L2_hdr_status = checkForNull(request.getParameter("L2_hdr_status"));
				String L3_hdr_status = checkForNull(request.getParameter("L3_hdr_status"));
				String hdr_level			= checkForNull(request.getParameter("curr_level"));;


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
if(dischargeSummary){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		if(stage_l2.equals(""))   {
			if(Stage_no == 1){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			}else if(Stage_no == 2){
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			}else if(Stage_no == 3){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
		}else if(stage_l2.equals("Y")){
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}else {
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
		
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectDiagnosis.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectProcedure.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewErrorHistory.label","mr_labels")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.viewexcludedcodes.label","mr_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.showerrorcodesbypractitioner.label","mr_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(hide_dataTable));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(hide_exp));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
if(doctorsDescription){
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

		/*String New_EncounterId=EncounterId; //If allow_recode_diag_yn="Y"; 

			if(allow_recode_diag_yn.equals("N")){
				New_EncounterId="";
			} Note: Commented Code Was Implemented @@ Line:*/
		/*
		Commented On 4/21/2010 for PE Tuning
		String sql3="";
		sql3="select nvl(DRG_CALCULATION_YN,'N') DRG_CALCULATION_YN from mr_parameter";
		pstmt = conn.prepareStatement(sql3);
		rs = pstmt.executeQuery();	
		String drg_yn="";
		while(rs.next()){
		drg_yn = checkForNull(rs.getString("DRG_CALCULATION_YN"));
		}*/
			if(mode.equals("Y")){
				if ( i % 2 == 0 )
					classValue = "gridData" ;
				else
					classValue = "gridData" ;
			
				/*String sql_hdr_sts="SELECT CURR_LEVEL,nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"'";

				
				pstmt = conn.prepareStatement(sql_hdr_sts);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					hdr_level=rs.getString("CURR_LEVEL");
					L1_hdr_status=rs.getString("LEVEL1_STATUS");
					L2_hdr_status=rs.getString("LEVEL2_STATUS");
					L3_hdr_status=rs.getString("LEVEL3_STATUS");
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();*/

				


				//if(cur_Sel.equals("1")){

					/// replaced all stage_no by cur_Sel
					//sql1.append("SELECT a.patient_id, a.orig_term_set_id,a.orig_term_code, a.term_set_id, a.term_code, b.short_desc,       am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,       TO_CHAR(a.recorded_date_time, 'dd/mm/yy hh24:mi') recorded_date_time, a.cause_of_death,a.recode_status,decode(a.recode_status,'O','Review','N','NewCode','R','Recoded','F','Recoded')recodeStatus_desc,  STAGE_SRL_NO,stage_seq_no,group_YN,stage_no,confirm_yn FROM MR_DIAGNOSIS_RECODING_DTL a, mr_term_code b WHERE a.facility_id = '"+p_facility_id+"'   AND a.encounter_id = '"+EncounterId+"' and a.stage_no<="+cur_Sel+"  and a.active_YN='Y' AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code order by Stage_srl_no");
				//}else {  /// for level 2 handling

				

				
					//sql1.append("WITH tmp AS ( SELECT patient_id, orig_term_set_id, orig_term_code,term_set_id, term_code, practitioner_id, recorded_date_time, cause_of_death, recode_status,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn, active_yn FROM mr_diagnosis_recoding_dtl WHERE facility_id = '"+p_facility_id+"' AND encounter_id = '"+EncounterId+"' AND stage_no <= "+cur_Sel+") SELECT a.patient_id, a.orig_term_set_id, a.orig_term_code, a.term_set_id, a.term_code, b.short_desc, am_get_desc.am_practitioner(practitioner_id, 'en', '1') practitioner_name, TO_CHAR(a.recorded_date_time, 'dd/mm/yy hh24:mi') recorded_date_time, a.cause_of_death, a.recode_status,DECODE(a.recode_status, 'O', 'Review', 'N', 'NewCode', 'R', 'Recoded') recodestatus_desc, stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn FROM tmp a, mr_term_code b  WHERE a.term_set_id = b.term_set_id AND a.term_code = b.term_code AND recode_status NOT IN('E', 'F') AND active_yn = 'Y' AND (a.term_code, stage_srl_no) NOT IN( SELECT m1.term_code, m1.stage_srl_no        FROM (SELECT * FROM tmp WHERE active_yn = 'Y') m1, (SELECT * FROM tmp WHERE active_yn = 'N') m2 WHERE m1.term_code = m2.term_code      AND m1.stage_srl_no < m2.stage_srl_no) ");

//					sql1.append("WITH tmp AS (SELECT patient_id, orig_term_set_id, orig_term_code,term_set_id, term_code, practitioner_id, recorded_date_time, cause_of_death, recode_status,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn, active_yn,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,diag_class_code,remarks FROM mr_diagnosis_recoding_dtl WHERE facility_id = '"+p_facility_id+"' AND encounter_id = '"+New_EncounterId+"' AND stage_no  <= "+cur_Sel+") SELECT a.patient_id, a.orig_term_set_id, a.orig_term_code, a.term_set_id, a.term_code,b.short_desc,c.DIAG_CLASS_TYPE, am_get_desc.am_practitioner(practitioner_id, 'en', '1') practitioner_name,TO_CHAR(a.recorded_date_time, 'dd/mm/yy hh24:mi') recorded_date_time,a.cause_of_death, a.recode_status,DECODE(a.recode_status, 'O', 'Review', 'N', 'NewCode', 'R', 'Recoded') recodestatus_desc,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,a.remarks,decode (c.DIAG_CLASS_TYPE,'PD','Principal','CM','Comorbidity','EC','External Causes','CO','Complication','','Others') diag_classification_code  FROM tmp a, mr_term_code b,MR_DIAG_CLASS c WHERE a.term_set_id = b.term_set_id AND a.term_code = b.term_code and a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE (+) AND recode_status NOT IN('E', 'F') AND active_yn = 'Y' AND (stage_srl_no) NOT IN( SELECT m1.stage_srl_no FROM (SELECT term_code, stage_srl_no FROM tmp WHERE active_yn = 'Y') m1, (SELECT term_code, stage_srl_no FROM tmp WHERE active_yn = 'N' or confirm_yn = 'Y') m2 WHERE m1.term_code = m2.term_code AND m1.stage_srl_no < m2.stage_srl_no)");

//					CallableStatement main_cal_pstmt	=	null;
					String out_srl_no="";
					main_cal_pstmt = conn.prepareCall("{call MR_TERM_RECODE.GET_ACTIVE_CODES(?, ?, ?, ?, ?,?,?)}");
					main_cal_pstmt.setString( 1, "MR_DIAGNOSIS_RECODING_DTL");//Table Name
					main_cal_pstmt.setString( 2, p_facility_id);//Facility_ID
					main_cal_pstmt.setString( 3, New_EncounterId);//Encounter_ID
					main_cal_pstmt.setString( 4, cur_Sel);//Encounter_ID
					main_cal_pstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					main_cal_pstmt.setString( 6, ",");//Separator
					main_cal_pstmt.setString( 7, "D");//Procedure OT And Non OT Value 
					main_cal_pstmt.execute();
					out_srl_no=main_cal_pstmt.getString(5);


//					StringTokenizer his_out_srl_no	= new StringTokenizer(out_srl_no,",");


					/*Modified by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364*/
					sql1.append("SELECT a.patient_id, a.orig_term_set_id, a.orig_term_code, a.term_set_id, a.term_code,mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2') short_desc,a.term_code_short_desc,b.free_text_yn,c.DIAG_CLASS_TYPE,b.dagger_independent_yn,b.cross_ref_type,a.occur_srl_no,b.long_desc,am_get_desc.am_practitioner(practitioner_id, '"+locale+"', '1') practitioner_name,TO_CHAR(a.recorded_date_time, 'dd/mm/yyyy hh24:mi') recorded_date_time,a.cause_of_death,a.death_reg_seq_no,a.recode_status,DECODE(a.recode_status, 'O', 'Review', 'N', 'NewCode', 'R', 'Recoded') recodestatus_desc,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,a.remarks,decode (c.DIAG_CLASS_TYPE,'PD','Principal','CM','Comorbidity','EC','External Causes','CO','Complication','','Others') diag_classification,decode (c.DIAG_CLASS_TYPE,'PD','1','CM','2','EC','4','CO','3','','5') diag_classification_grp, mr_get_desc.mr_diag_class (a.diag_class_code,'"+locale+"', '1') diag_class_long_desc, a.support_seq_no,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mc WHERE mc.TERM_SET_ID = a.term_set_id AND mc.term_code = a.term_code AND mc.CROSS_REF_TYPE = 'EQ') equiv_count,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct1 WHERE mct1.TERM_SET_ID = a.term_set_id AND mct1.TERM_CODE = a.term_code AND mct1.EQUIVALENT_TERM_SET_ID = a.term_set_id AND mct1.CROSS_REF_TYPE='AS' ) dgr_cnt,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct2 WHERE mct2.TERM_SET_ID = a.term_set_id AND Mct2.TERM_CODE = a.term_code AND mct2.EQUIVALENT_TERM_SET_ID = a.term_set_id AND mct2.CROSS_REF_TYPE='EC' ) conseq_cnt,DOCTORS_DESCRIPTION FROM mr_diagnosis_recoding_dtl a,mr_term_code b,MR_DIAG_CLASS c WHERE a.term_set_id = b.term_set_id AND a.term_code = b.term_code and a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE (+) and a.facility_id = '"+p_facility_id+"' AND a.encounter_id = '"+New_EncounterId+"' AND a.stage_no  <= "+cur_Sel+" and a.stage_srl_no in ("+out_srl_no+") and a.status='A' ");//Query Was Modified On 1/28/2010  added DAGGER_INDEPENDENT_YN for SRR-CRF-303.2   
					//DOCTORS_DESCRIPTION Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269


					
					if(cur_Sel.equals("1") && L1_hdr_status.equals("A") || cur_Sel.equals("2") && L2_hdr_status.equals("A") || cur_Sel.equals("3") && L3_hdr_status.equals("A")){
						sql1.append("order by TRX_NO");
					}
				//}
				pstmt = conn.prepareStatement(sql1.toString());
				rs = pstmt.executeQuery();	
				//String inside_grp="N";
				String old_trm_cd="";
				//String old_tmpstr="";
				String diag_level_prc="";
				String srl_no_prc="";
				//String old_class="classValue";
				//String hist_stage_seq_no="";
				//String hist_stage_srl_no="";
				String orig_term_code_old="";
				String Group_seq_no="";

				String grp_trm_cd	 ="";
//				String prin_code="";
				String seq_yn	="";
				String remarks	="";
				String diag_class_code="";
				String show_eq_tmcd	=	"";
				String show_sprt_diag	=	"";
				String show_remarks	=	"";				
	String  remark_lbl			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisRemarks.label","mr_labels"); // modified by mujafar for ML-MMOH-CRF-1270
				String  eqvi_code_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels");
				String spprt_dig_lbl		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SupportingDiagnosis.label","common_labels");
				String free_text_yn		=	"";// Added On 8/20/2009
				String death_reg_seq_no	=	"";// Added On 9/22/2009 For MDR death_reg_seq_no
				String associate_codes		=	"";//Added On 2/1/2010 ForSRR-CRF-303.2
				String support_seq_no		=	"";//Added On 2/1/2010 ForSRR-CRF-303.2
				String primary_lbl		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primary.label","common_labels");
				String related_lbl		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.related.label","mr_labels");
				String notrelated_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.notrelated.label","mr_labels");

				int equivalent_term_code_cnt = 0;
				int support_diag_cnt	=0;

				


		
				while(rs.next()){
					String diag_clas_lbl			=	"";
					String long_desc				= "";// Added For Site Enhancement On 3/11/2010
					String long_desc_params	= "";// Added For Site Enhancement On 3/11/2010
					String display_long_desc	= "none";// Added For Site Enhancement On 3/11/2010
					boolean modify_diag		=true;
					String supprt_diag_view	="E";//Added On 2/1/2010 ForSRR-CRF-303.2
					patient_id		= checkForNull(rs.getString("PATIENT_ID"));
					term_set		= checkForNull(rs.getString("TERM_SET_ID"));
					term_code	= checkForNull(rs.getString("TERM_CODE"));
//					out.println("term_code===>" +term_code)

					term_desc		= checkForNull(rs.getString("SHORT_DESC"));
					//term_desc="test";
					coded_date		= checkForNull(rs.getString("RECORDED_DATE_TIME"));
					coded_date		=DateUtils.convertDate(coded_date,"DMYHM" ,"en",locale);
					coded_by			= checkForNull(rs.getString("practitioner_name"));
					causeDeath		= checkForNull(rs.getString("CAUSE_OF_DEATH"));
					death_reg_seq_no	= checkForNull(rs.getString("death_reg_seq_no"));
					orig_term_set			=checkForNull(rs.getString("orig_term_set_id"));
					orig_term_code		= checkForNull(rs.getString("orig_term_code"));
					recodeStatus				= checkForNull(rs.getString("recode_status"));
					stg_srl_no					= checkForNull(rs.getString("STAGE_SRL_NO"));
					recodeStatus_desc	= checkForNull(rs.getString("recodeStatus_desc"));
					group_YN					= checkForNull(rs.getString("group_YN"));
					stage_seq_no			=checkForNull(rs.getString("stage_seq_no"));
					stage_no_disp			=checkForNull(rs.getString("stage_no"));
					confirm_yn				=checkForNull(rs.getString("confirm_yn"));
					Group_seq_no			=checkForNull(rs.getString("Group_seq_no"));
					seq_yn						=checkForNull(rs.getString("SEQUENCED_YN"));
					DIAG_CLASS_TYPE	=checkForNull(rs.getString("DIAG_CLASS_TYPE"));
					remarks						=checkForNull(rs.getString("remarks"));
					diag_class_code			=checkForNull(rs.getString("diag_classification"));
					dagger_independent_yn	= checkForNull(rs.getString("dagger_independent_yn"));
					cross_ref_type					= checkForNull(rs.getString("cross_ref_type"));
					occur_srl_no						= checkForNull(rs.getString("occur_srl_no"));
					support_seq_no				= checkForNull(rs.getString("support_seq_no"));
					free_text_yn						=checkForNull(rs.getString("free_text_yn"));// Added On 8/20/2009
					trx_no								=checkForNull(rs.getString("trx_no"));// Added On 23/Jan/2009
					long_desc							=checkForNull(rs.getString("long_desc"));// Added On 23/Jan/2009

					doctors_description	= checkForNull(rs.getString("doctors_description")); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
					diag_class_long_desc = checkForNull(rs.getString("diag_class_long_desc")); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364

					equivalent_term_code_cnt=0;
					support_diag_cnt=0;

					equivalent_term_code_cnt=rs.getInt("equiv_count");  // done for PE. count query merged with the main query

					if(cross_ref_type.equals("D")){
						associate_codes		= "A";
						support_diag_cnt=rs.getInt("dgr_cnt");
					}else if(cross_ref_type.equals("C")){
						associate_codes		= "EC";
						support_diag_cnt=rs.getInt("conseq_cnt");
					}else{
						show_sprt_diag	="hidden";
						associate_codes	="";
					}

					

					if(free_text_yn.equals("Y")){
						term_desc = checkForNull(rs.getString("term_code_short_desc"));
					}
					
				if(isMultiDescAppl && term_set.equals("ICD10") ) //  added by mujafar for ML-MMOH-CRF-1281
				{
				term_desc = checkForNull(rs.getString("term_code_short_desc"));
				if(term_desc.equals(""))
				term_desc		= checkForNull(rs.getString("SHORT_DESC"));
				}
				
					
					
					

					if(DIAG_CLASS_TYPE.equals("PD")){
						if(!Prin_diag.equals(term_code)){
							Prin_diag=term_code;
							prin_stg_srl_no=stg_srl_no;
						}
						prin_diag_cnt++;
				}
/*
		F.Y.I :Added on 1/28/2010 For SRR-CRF-303.2
		1.When the Term Code is Dagger independent based upon 
			the dagger_independent_yn value the indicator of the term code wiii be visible.
*/
				if(dagger_independent_yn.equals("Y")){
					disp_dagger_dep_ind	=	"display:inline";
				}else{
					disp_dagger_dep_ind	=	"display:none";
				}						
				
			//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
			if(isDiagClassLongDescAppl){
				diag_clas_lbl = diag_class_long_desc;
			}else
			{
				if(diag_class_code.equals("Principal")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.principal.label","mr_labels");
				}else if(diag_class_code.equals("Comorbidity")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.comorbidity.label","mr_labels");
				}else if(diag_class_code.equals("External Causes")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.externalcauses.label","mr_labels");
				}else if(diag_class_code.equals("Complication")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.complication.label","mr_labels");
				}else if(diag_class_code.equals("Others")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.others.label","mr_labels");
				}
			}
						if(recodeStatus.equals("N")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.newcode.label","mr_labels");//NewCode;
						}else if(recodeStatus.equals("O")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//For Original Code;
						}else if(recodeStatus.equals("R")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.recoded.label","mr_labels");//"Recoded";
						}

//					out.println("stage_no_disp====>" +stage_no_disp);
//					out.println("cur_Sel====>" +cur_Sel);
					if(group_YN.equals("Y")){// added for level 2 handling
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){// added for level 2 handling

							if(!grp_trm_cd.equals(term_code)){
								grp_trm_cd=term_code;
							}else{
								continue;
							}
						}

					}

					

					/*-----------------------*/
					
					/*int int_stg_no=Integer.parseInt(stage_no);
					int int_cur_sel=Integer.parseInt(cur_Sel);

					if(int_stg_no==int_cur_sel){
						if(int_stg_no==1){
							hdr_status=L1_hdr_status;
						}else if(int_stg_no==2){
							if(L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){ // aded 19/jun	
								if(L1_hdr_status.equals("A")){
									L2_hdr_status="A";								
								}
							}
							hdr_status=L2_hdr_status;
						}else if(int_stg_no==3){
							if(L3_hdr_status.equals("P")){ // aded 19/jun	
								if((L1_hdr_status.equals("A") && L2_hdr_status.equals("P")) || L2_hdr_status.equals("A")){
									L3_hdr_status="A";
									
								}
							}
							hdr_status=L3_hdr_status;
						}
							chk_disable="";
							if(hdr_status.equals("C")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
								chk_disable="disabled";
							}
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");
								chk_disable="disabled";
							}
							if(hdr_status.equals("S")){
								if(confirm_yn.equals("Y")){
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");
									chk_disable="disabled";
								}else{
									chk_disable="";
								}
							}
							if(hdr_status.equals("R")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");
								chk_disable="";
							}
					}else{
						chk_disable="disabled";
						Lock_all="Y";
						if(int_cur_sel==1){
							hdr_status=L1_hdr_status;
						}else if(int_cur_sel==2){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P")){
									L2_hdr_status="A";
									
							 }
							hdr_status=L2_hdr_status;
						}
						
						if(hdr_status.equals("C")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
						}
						if(hdr_status.equals("A")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");
						}
						if(hdr_status.equals("S")){
							if(confirm_yn.equals("Y")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");
							}
						}
						if(hdr_status.equals("R")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");
						}
						
					}*/

					/*----------------------*/
					
					if(cur_Sel.equals("1")){
						if(L1_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";

						}
						if(L1_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						hdr_status=L1_hdr_status; //Added on 7/2/2009
					}else if(cur_Sel.equals("2")){
						if(L2_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Completed";
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						if(L2_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						hdr_status=L2_hdr_status; //Added on 7/2/2009
					}else if(cur_Sel.equals("3")){
						if(L3_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						if(L3_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						hdr_status=L3_hdr_status;//Added on 7/1/2009
					}

					/*if(stage_no.equals("1")){  //Added on 7/2/2009
						if(!L2_hdr_status.equals("P") || !L3_hdr_status.equals("P")){				
							chk_disable="disabled";
							Lock_all="Y";
						}
						hdr_status=L1_hdr_status;
					}else if(stage_no.equals("2")){
						if( !L3_hdr_status.equals("P")){				
							chk_disable="disabled";
							Lock_all="Y";
						}
						hdr_status=L2_hdr_status;	
						
					}else if(stage_no.equals("3")){//Commented On 7/1/2009
						hdr_status=L3_hdr_status;
						
					}				
					*/
//					out.println("hdr_status==>" +hdr_status);
//					out.println("modify_diag==>" +modify_diag);

					if(!hdr_status.equals("C") ){
						
						if(!hdr_status.equals("A") ){

							if(confirm_yn.equals("Y")){
								if(Integer.parseInt(cur_Sel)==Integer.parseInt(stage_no_disp)){
									chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
//									recodeStatus_desc="Confirmed";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confirmed";

									
									if(Integer.parseInt(cur_Sel)<Integer.parseInt(stage_no)){
										
										if(cur_Sel.equals("1") && L1_hdr_status.equals("C")){
											recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("1")&& L1_hdr_status.equals("A")){
											recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("2")&& L2_hdr_status.equals("C")){
											recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("2")&& L2_hdr_status.equals("A")){
											recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Confirmed";

										}

									}


								}
							}else{
								chk_disable="";
							}
						}
					}
					

					// for auth carryover.
					if(stage_no.equals(cur_Sel)){
//						out.println("stage_no==============>" +stage_no);
						if(stage_no.equals("2")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P")){
									chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L1_hdr_status;
							}
							
						}

						if(stage_no.equals("3")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
								chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L1_hdr_status;

							}

							if(L2_hdr_status.equals("A") && L3_hdr_status.equals("P")){
								chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L2_hdr_status;
							}

						}

					}else{
						if(cur_Sel.equals("2")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
								chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L1_hdr_status;

							}/*Added On 8/18/2009 for J.Mail*/
					}
				}
					//out.println("hdr_status==" +hdr_status);				
					// for auth carryover.
										
/*For EQUIVALENT_TERM_CODE*/
					//String sqlicd="SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID = '"+term_set+"' AND term_code = '"+term_code+"' AND CROSS_REF_TYPE = 'EQ'";
					//pstmt1 = conn.prepareStatement(sqlicd);
					//rs1	 = pstmt1.executeQuery();	
					//while(rs1.next()){
							//equivalent_term_code_cnt=rs1.getInt("COUNT");
					//}
					//if(pstmt1 != null) pstmt1.close();
					//if(rs1 != null) rs1.close();
/**Ends**/

/*For Support Diagnosis*/
		//String sql_sprt_diag="";
/*
		F.Y.I :Added on 1/28/2010 For SRR-CRF-303.2
		1.Based Upon the code indicator the supporting diagnosis icon will be open.
		2.Before this enhancement if the icon was clicked only the astrik codes are visible for the respective Dagger.
*/
				/*if(cross_ref_type.equals("D")){ 
//						show_sprt_diag	= "visible";
						associate_codes		= "A";
						sql_sprt_diag			=	"SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE B,MR_TERM_CODE A WHERE B.TERM_SET_ID = '"+term_set+"'AND B.TERM_CODE = '"+term_code+"'AND B.EQUIVALENT_TERM_SET_ID = '"+term_set+"' AND A.TERM_SET_ID=B.EQUIVALENT_TERM_SET_ID AND A.TERM_CODE=B.EQUIVALENT_TERM_CODE ";
						pstmt1 = conn.prepareStatement(sql_sprt_diag);
						rs1	 = pstmt1.executeQuery();	
						while(rs1.next()){
								support_diag_cnt=rs1.getInt("COUNT");
						}
						if(pstmt1 != null) pstmt1.close();
						if(rs1 != null) rs1.close();

				}else if(cross_ref_type.equals("C")){
						associate_codes		= "EC";
						sql_sprt_diag			=	"SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE B,MR_TERM_CODE A WHERE B.TERM_SET_ID = '"+term_set+"'AND B.TERM_CODE = '"+term_code+"'AND B.EQUIVALENT_TERM_SET_ID = '"+term_set+"' AND A.TERM_SET_ID=B.EQUIVALENT_TERM_SET_ID AND A.TERM_CODE=B.EQUIVALENT_TERM_CODE ";
						pstmt1 = conn.prepareStatement(sql_sprt_diag);
						rs1	 = pstmt1.executeQuery();	
						while(rs1.next()){
								support_diag_cnt=rs1.getInt("COUNT");
						}
						if(pstmt1 != null) pstmt1.close();
						if(rs1 != null) rs1.close();
				}else{
						show_sprt_diag	="hidden";
						associate_codes	="";
				}	
				*/
	/*Ends*/
				if(equivalent_term_code_cnt!=0){
					show_eq_tmcd	 ="visible";
				}else{
					show_eq_tmcd		="hidden";
				}
				if(support_diag_cnt!=0){
					show_sprt_diag	="visible";
				}else{
					show_sprt_diag	="hidden";
				}
				if(!remarks.equals("")){
					show_remarks	="visible";
				}else{
					show_remarks		="hidden";
				}
				if(!(term_desc.equals(long_desc))&&!(term_code.equals("*OTH"))){
					display_long_desc ="inline";
					long_desc_params = term_code+","+term_set;
				}

					if(group_YN.equals("X")){
						if(orig_term_code_old.equals("")){
							values_fetched=orig_term_code+","+term_code;
							orig_term_code_old=orig_term_code;
							//classValue="recodeDataY1";

						}else{
							if(orig_term_code_old.equals(orig_term_code)){
								values_fetched=values_fetched+","+term_code;
								//classValue="recodeDataY1";
							}else{
								values_fetched=values_fetched+"~"+orig_term_code+","+term_code;
								orig_term_code_old=orig_term_code;
								//classValue="recodeDataY1";
							}
							
						}
					}
					if(Integer.parseInt(hdr_level)>Integer.parseInt(cur_Sel) || Integer.parseInt(stage_no)>Integer.parseInt(cur_Sel) ){ // added for level 2 handling
						chk_disable="disabled";
						Lock_all="Y";
						supprt_diag_view ="D";
						
					}
//					String tmcode_srl_no=his_out_srl_no.nextToken();
					if(recodeStatus.equals("R")){  // recoded records
//							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.recoded.label","mr_labels");//"Recoded";
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){ // added for level 2 handling
//							recodeStatus_desc="Review";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//"Review";
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Review";
							}
							final_diag_values=final_diag_values+i+"$"+term_code+"$"+term_set+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_term_code+"$"+Group_seq_no+"$"+confirm_yn+"$"+support_seq_no+"~";
							active_diag_codes=active_diag_codes+term_set+"$"+term_code+"~";
							
							
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
seq_no++;
							}
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(show_eq_tmcd));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(eqvi_code_lbl));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(show_sprt_diag));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(cur_Sel));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(support_seq_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(supprt_diag_view));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(spprt_dig_lbl));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(show_remarks));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(remark_lbl));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(recodeStatus_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(orig_term_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(free_text_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(java.net.URLEncoder.encode(term_desc)));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block76Bytes, _wl_block76);

										if(recodeStatus_desc.equals("Recoded"))
										{ // added by mujafar for ML-MMOH-CRF-1270
												recodeStatus_desc_temp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Coded.label","mr_labels");
										}
										else
										{
											recodeStatus_desc_temp = recodeStatus_desc;
										}
										
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recodeStatus_desc_temp));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block81Bytes, _wl_block81);
if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel) && modify_diag){
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disp_dagger_dep_ind));
            _bw.write(_wl_block88Bytes, _wl_block88);
}else{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(disp_dagger_dep_ind));
            _bw.write(_wl_block88Bytes, _wl_block88);
}
            _bw.write(_wl_block90Bytes, _wl_block90);
if(toolTip_diagnosis){
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(term_code ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(long_desc ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);
}else{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
} 
            _bw.write(_wl_block97Bytes, _wl_block97);
if(doctorsDescription){
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(doctors_description));
            _bw.write(_wl_block99Bytes, _wl_block99);
}
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(diag_clas_lbl));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(coded_by));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(coded_date));
            _bw.write(_wl_block103Bytes, _wl_block103);
if(causeDeath.equals("C")){
							String title="";
							if(death_reg_seq_no.equals("1")){
								 title=primary_lbl;
							}
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(title));
            _bw.write(_wl_block106Bytes, _wl_block106);
}else if(causeDeath.equals("O")){
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(related_lbl));
            _bw.write(_wl_block106Bytes, _wl_block106);
}else if(causeDeath.equals("R")){
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(notrelated_lbl));
            _bw.write(_wl_block106Bytes, _wl_block106);
}else{
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
}
            _bw.write(_wl_block110Bytes, _wl_block110);

							}else{

								if(!old_trm_cd.equals(term_code)){
									//out.println("term_code"+ term_code +"diag_level" +diag_level+"group_YN"+group_YN);
									if(group_YN.equals("Y")){  // commented on 3rd june
										classValue="recodeData";
									}else{
										classValue="gridData";
									}	

									//out.println("classValue" + classValue);
									
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block113Bytes, _wl_block113);
if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block116Bytes, _wl_block116);
seq_no++;
										}else{
											if(!seq_yn.equals("H")){
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
  }
										}
										final_diag_values=final_diag_values+i+"$"+term_code+"$"+term_set+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_term_code+"$"+Group_seq_no+"$"+confirm_yn+"$"+support_seq_no+"~";
										active_diag_codes=active_diag_codes+term_set+"$"+term_code+"~";
										
										
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(show_eq_tmcd));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(eqvi_code_lbl));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(show_sprt_diag));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(cur_Sel));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(support_seq_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(supprt_diag_view));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(spprt_dig_lbl));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(show_remarks));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(remark_lbl));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(recodeStatus_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(orig_term_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(free_text_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(java.net.URLEncoder.encode(term_desc)));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block123Bytes, _wl_block123);

										if(recodeStatus_desc.equals("Recoded"))
										{ // added by mujafar for ML-MMOH-CRF-1270
												recodeStatus_desc_temp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Coded.label","mr_labels");
										}
										else
										{
											recodeStatus_desc_temp = recodeStatus_desc;
										}
										
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recodeStatus_desc_temp));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block126Bytes, _wl_block126);
if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel) && modify_diag){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disp_dagger_dep_ind));
            _bw.write(_wl_block129Bytes, _wl_block129);
}else{
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(disp_dagger_dep_ind));
            _bw.write(_wl_block129Bytes, _wl_block129);
}
										if(toolTip_diagnosis){
										
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(term_code ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(long_desc ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block131Bytes, _wl_block131);
}else{ 
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block133Bytes, _wl_block133);
} 
            _bw.write(_wl_block134Bytes, _wl_block134);
if(doctorsDescription){
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(doctors_description));
            _bw.write(_wl_block131Bytes, _wl_block131);
}
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(diag_clas_lbl));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(coded_by));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(coded_date));
            _bw.write(_wl_block137Bytes, _wl_block137);
if(causeDeath.equals("C")){
											String title="";
											if(death_reg_seq_no.equals("1")){
												 title=primary_lbl;
											}
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(title));
            _bw.write(_wl_block139Bytes, _wl_block139);
}else if(causeDeath.equals("O")){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(related_lbl));
            _bw.write(_wl_block139Bytes, _wl_block139);
}else if(causeDeath.equals("R")){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(notrelated_lbl));
            _bw.write(_wl_block142Bytes, _wl_block142);
}else{
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block143Bytes, _wl_block143);
}
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
								
									String term_chain="";
									String Srl_chain="";										
									try{
										CallableStatement cal_pstmt	=	null;
										cal_pstmt = conn.prepareCall("{call MR_TERM_RECODE.RECODE_NODE(?,?,?,?,?,?,?,?,?)}");
										cal_pstmt.setString( 1, "MR_DIAGNOSIS_RECODING_DTL");//Encounter_ID
										cal_pstmt.setString( 2, p_facility_id);//p_facility_id
										cal_pstmt.setString( 3, EncounterId);//Encounter_ID
										cal_pstmt.setString( 4, term_set);//term_set Added On 8/3/2009
										cal_pstmt.setString( 5, term_code);//Term_Code
										cal_pstmt.setString( 6, cur_Sel);//stage no
										cal_pstmt.setString( 7, stg_srl_no);//term_code_stage_srl_no which will be getting from the main Query
										cal_pstmt.registerOutParameter( 8,java.sql.Types.VARCHAR);
										cal_pstmt.registerOutParameter( 9,java.sql.Types.VARCHAR);
										cal_pstmt.execute();
										term_chain = cal_pstmt.getString(8);
										Srl_chain = cal_pstmt.getString(9);
										cal_pstmt.close();
									}catch ( Exception ex){
										ex.printStackTrace();
									}

									StringTokenizer stk_trm_chn=new StringTokenizer(term_chain,"$");
									StringTokenizer stk_srl_chn=new StringTokenizer(Srl_chain,"$");
									String hist_disp="";							
									

									int ikk=0;
									while(stk_trm_chn.hasMoreTokens()){
										StringTokenizer st_trm=new StringTokenizer(stk_trm_chn.nextToken(),",");
										StringTokenizer st_trm_srl=new StringTokenizer(stk_srl_chn.nextToken(),",");
//										out.println("<table width='100%' cellpadding=0 cellspacing=0 border=1>");
										hist_disp="";

										
										while(st_trm.hasMoreTokens()){
										
										
											String old_diaglevel="";
											int ijk=0;
											
											
											//diag_level_prc= stk_trm_chn.nextToken();
											diag_level_prc= st_trm.nextToken();
											//diag_level_prc=diag_level_prc.substring(0,diag_level_prc.length()-1);
											//srl_no_prc= stk_srl_chn.nextToken();
											srl_no_prc= st_trm_srl.nextToken();
											//srl_no_prc=srl_no_prc.substring(0,srl_no_prc.length()-1);								
											
											
											/*FYI:Query Was changed on 9/22/2009 for MDR to display cause_of_death based*/
											/*Modified by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364*/
											String sql_hist_det="SELECT a.orig_term_set_id,a.orig_term_code, a.term_set_id, a.term_code, mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2') short_desc,b.free_text_yn,a.term_code_short_desc,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,TO_CHAR(a.recorded_date_time, 'dd/mm/yyyy hh24:mi') recorded_date_time, a.cause_of_death,a.death_reg_seq_no,a.recode_status,decode(a.recode_status,'O','Review','N','Review','R','Review')recodeStatus_desc,  STAGE_SRL_NO,stage_seq_no,group_YN,group_seq_no,decode (c.DIAG_CLASS_TYPE,'PD','Principal','CM','Comorbidity','EC','External Causes','CO','Complication','','Others') diag_classification, mr_get_desc.mr_diag_class (a.diag_class_code,'"+locale+"', '1') diag_class_long_desc FROM MR_DIAGNOSIS_RECODING_DTL a, mr_term_code b,MR_DIAG_CLASS c WHERE a.facility_id = '"+p_facility_id+"'   AND a.encounter_id = '"+EncounterId+"' and a.term_code in("+diag_level_prc+") and stage_srl_no in ("+srl_no_prc+") and a.active_YN='N'  AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code and a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE (+) order by orig_term_code ,stage_srl_no desc";
											pstmt3 = conn.prepareStatement(sql_hist_det);
											rs3 = pstmt3.executeQuery();	
											String tmp_cd="";
											String his_diag_clas="";
											String recorded_date_time="";
											String free_text_yn1="";
											String short_desc1="";
											String cause_of_death_his=""; //Added On 9/22/2009 for MDR
											String death_reg_seq_no_his="";//Added On 9/22/2009 for MDR


											
											while(rs3.next()){
												String his_diag_clas_lbl="";
												tmp_cd=rs3.getString("term_code");
												his_diag_clas=checkForNull(rs3.getString("diag_classification"));
												diag_class_long_desc = checkForNull(rs3.getString("diag_class_long_desc")); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
												recorded_date_time=checkForNull(rs3.getString("recorded_date_time"));
												recorded_date_time=DateUtils.convertDate(recorded_date_time,"DMYHM" ,"en",locale);
												free_text_yn1=checkForNull(rs3.getString("free_text_yn"));
												if(free_text_yn1.equals("Y")){
													short_desc1=checkForNull(rs3.getString("term_code_short_desc"));
												}else{
													short_desc1=checkForNull(rs3.getString("short_desc"));
												}
												
				if(isMultiDescAppl && term_set.equals("ICD10") ) //  added by mujafar for ML-MMOH-CRF-1281
				{
				short_desc1 = checkForNull(rs3.getString("term_code_short_desc"));
				if(short_desc1.equals(""))
				short_desc1		= checkForNull(rs3.getString("SHORT_DESC"));
				}
												
												
												
												cause_of_death_his		=checkForNull(rs3.getString("cause_of_death"));
												death_reg_seq_no_his	=checkForNull(rs3.getString("death_reg_seq_no"));

												int diag_len=diag_level_prc.indexOf(",");

												if(group_YN.equals("X")){
													//out.println("diag_level" +diag_level);
													//out.println("old_diaglevel" +old_diaglevel);
													
													if(diag_len>0){
														if(old_diaglevel.equals("")){
															ijk++;
															//classValue="OAFORCED";
															old_diaglevel=diag_level_prc;
														}

														if(!diag_level_prc.equals(old_diaglevel)){
															ijk++;
															old_diaglevel=diag_level_prc;
															//classValue="OAYELLOW";
														}
														
														if ( ijk % 2 == 0 ){
															//classValue="recodeDataY1";
														}else{
															//classValue="recodeDataY2";
														}
													}

												}
											
											//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
											if(isDiagClassLongDescAppl){
												his_diag_clas_lbl = diag_class_long_desc;
											}
											else
											{
												if(his_diag_clas.equals("Principal")){
													his_diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.principal.label","mr_labels");
												}else if(his_diag_clas.equals("Comorbidity")){
													diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.comorbidity.label","mr_labels");
												}else if(his_diag_clas.equals("External Causes")){
													his_diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.externalcauses.label","mr_labels");
												}else if(his_diag_clas.equals("Complication")){
													his_diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.complication.label","mr_labels");
												}else if(his_diag_clas.equals("Others")){
													his_diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.others.label","mr_labels");
												}
											}

												if ( ikk % 2 == 0 ){
													hist_disp=hist_disp+"<tr><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap  align='left'>&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' nowrap align='left'  ><b>"+checkForNull(rs3.getString("term_set_id"))+"</b>&nbsp;/&nbsp;<b>"+checkForNull(rs3.getString("term_code"))+"</b></td><td class='"+classValue+"' wrap align='left'><b>"+short_desc1+"</b></td>";
													
													/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
													if(doctorsDescription){
													hist_disp=hist_disp+"<td class='"+classValue+"' align='left'>&nbsp;</td>";
													}

													hist_disp=hist_disp+"<td class='"+classValue+"' align='left'><b>"+his_diag_clas_lbl+"</b>&nbsp;</td><td class='"+classValue+"' nowrap  align='left'><b>"+checkForNull(rs3.getString("practitioner_name"))+"</b></td><td  class='"+classValue+"' nowrap align='left' ><b>"+recorded_date_time+"</b></td>";
													/*Added on 9/22/2009 For MDR */
													if(cause_of_death_his.equals("C")){
															String title="";
															if(death_reg_seq_no_his.equals("1")){
																 title=primary_lbl;
															}
															hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/Y-Red.gif' alt='"+title+"'/></td></tr>";
													}else if(cause_of_death_his.equals("O")){
															hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/y-white.gif' alt='"+related_lbl+"'/></td></tr>";
													}else if(cause_of_death_his.equals("R")){
															hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<b><img src='../../eCommon/images/n-white.gif' alt='"+notrelated_lbl+"'/></b></td></tr>";
													}else{
															hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<b><img src='../../eCommon/images/n-white.gif'/></b></td></tr>";
													}
												}else{
													hist_disp=hist_disp+"<tr><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap  align='left'>&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' align='left' nowrap>"+checkForNull(rs3.getString("term_set_id"))+" &nbsp;/&nbsp;"+checkForNull(rs3.getString("term_code"))+"</td><td class='"+classValue+"' wrap align='left'>"+short_desc1+"</td>";

													/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
													if(doctorsDescription){
													hist_disp=hist_disp+"<td class='"+classValue+"' align='left'>&nbsp;</td>";
													}
													
													hist_disp=hist_disp+"<td class='"+classValue+"' wrap  align='left'>"+his_diag_clas_lbl+"&nbsp;</td><td class='"+classValue+"' nowrap  align='left' >"+checkForNull(rs3.getString("practitioner_name"))+"</td><td  class='"+classValue+"' nowrap  align='left' >"+recorded_date_time+"</td>";
													if(cause_of_death_his.equals("C")){
														String title="";
														if(death_reg_seq_no_his.equals("1")){
															 title=primary_lbl;
														}
														hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/Y-Red.gif' alt='"+title+"'/></td></tr>";
													}else if(cause_of_death_his.equals("O")){
														hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/y-white.gif' alt='"+related_lbl+"'/></td></tr>";
													}else if(cause_of_death_his.equals("R")){
														hist_disp=hist_disp+"<td class='"+classValue+"'  wrap align='left'>&nbsp;<img src='../../eCommon/images/n-white.gif' alt='"+notrelated_lbl+"'/></td></tr>";
													}else{
														hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/n-white.gif'/></td></tr>";
													}
												}
											}
											/*Error Record To be Displayed */
										} // inner loop
										ikk++;
										out.println(hist_disp);
//										out.println("</table>");
									}  // outer loop

									
            _bw.write(_wl_block146Bytes, _wl_block146);

									old_trm_cd=term_code;
									classValue="gridData";
								}
						

						}



					}else{ // only original or new code
						
	
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){  // added for level 2 handling
//							recodeStatus_desc="Review";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//"Review";
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Review";
							}
						}

						if(hdr_status.equals("A")){
							chk_disable="disabled";
//							recodeStatus_desc="Authorized";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
						}else if(hdr_status.equals("C")){
							chk_disable="disabled";
//							recodeStatus_desc="Completed";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Completed";

						}
						
			


							
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block150Bytes, _wl_block150);

								seq_no++;
							}
							
						final_diag_values=final_diag_values+i+"$"+term_code+"$"+term_set+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_term_code+"$"+Group_seq_no+"$"+confirm_yn+"$"+support_seq_no+"~";
						active_diag_codes=active_diag_codes+term_set+"$"+term_code+"~";

						
						
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(show_eq_tmcd));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(eqvi_code_lbl));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(show_sprt_diag));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(cur_Sel));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(support_seq_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(supprt_diag_view));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(spprt_dig_lbl));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(show_remarks));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(remark_lbl));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(recodeStatus_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(orig_term_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(free_text_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(java.net.URLEncoder.encode(term_desc)));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block154Bytes, _wl_block154);

										if(recodeStatus_desc.equals("Recoded"))
										{ // added by mujafar for ML-MMOH-CRF-1270
												recodeStatus_desc_temp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Coded.label","mr_labels");
										}
										else
										{
											recodeStatus_desc_temp = recodeStatus_desc;
										}
										
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recodeStatus_desc_temp));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block157Bytes, _wl_block157);
if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel) && modify_diag){
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dagger_independent_yn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disp_dagger_dep_ind));
            _bw.write(_wl_block158Bytes, _wl_block158);
}else{
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(disp_dagger_dep_ind));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
						if(toolTip_diagnosis){
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(term_code ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(long_desc ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);
}else{ 
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block160Bytes, _wl_block160);
} 
            _bw.write(_wl_block161Bytes, _wl_block161);
if(doctorsDescription){
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(doctors_description));
            _bw.write(_wl_block95Bytes, _wl_block95);
}
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(diag_clas_lbl));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(coded_by));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(coded_date));
            _bw.write(_wl_block164Bytes, _wl_block164);
if(causeDeath.equals("C")){
								String title="";
								if(death_reg_seq_no.equals("1")){
									 title=primary_lbl;
								}
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(title));
            _bw.write(_wl_block106Bytes, _wl_block106);
}else if(causeDeath.equals("O")){
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(related_lbl));
            _bw.write(_wl_block167Bytes, _wl_block167);
}else if(causeDeath.equals("R")){
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(notrelated_lbl));
            _bw.write(_wl_block167Bytes, _wl_block167);
}else{
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block109Bytes, _wl_block109);
}
            _bw.write(_wl_block169Bytes, _wl_block169);

						
					}




					


					i++;
				}// while loop
				if(main_cal_pstmt!=null)main_cal_pstmt.close();
				if(rs!=null)rs.close();
			}
		
		
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(Patient_Class));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(i));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(temp_chk));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(temp_code));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(age));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(chk_yn));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(Lock_all));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(values_fetched));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(final_diag_values));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(active_diag_codes));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(allow_recode_diag_yn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(allow_recode_proc_yn));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(Prin_diag));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(prin_stg_srl_no));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(prin_diag_cnt));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(isMultiDescAppl));
            _bw.write(_wl_block197Bytes, _wl_block197);
if(Lock_all.equals("Y")){
            _bw.write(_wl_block198Bytes, _wl_block198);
}
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(cur_Sel));
            _bw.write(_wl_block200Bytes, _wl_block200);

	if(cur_Sel.equals("0")){
            _bw.write(_wl_block201Bytes, _wl_block201);
}
	
     
String rej_diag="";
String rej_proc="";
int proc_count=0;
int diag_count=0;

String new_diag_btn="";
String new_proc_btn="";

if(!hdr_status.equals("A") && Integer.parseInt(hdr_level)>0){
	if( Integer.parseInt(cur_Sel)>0 && (Integer.parseInt(cur_Sel)==(Integer.parseInt(stage_no)-1))){
		

		/*String diag_count_SQL	="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ";
			pstmt = conn.prepareStatement(diag_count_SQL);
			rs = pstmt.executeQuery();	
			while(rs.next()){
				diag_count = rs.getInt("COUNT");
				if(diag_count==0){
					new_diag_btn	="hidden";				
				}else{
					new_diag_btn="visible";
			}
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		String proc_count_SQL	="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ";
		pstmt = conn.prepareStatement(proc_count_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			proc_count = rs.getInt("COUNT");
			if(proc_count==0){
				new_proc_btn	="hidden";				
			}else{
				new_proc_btn="visible";
		}
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		diag_count=0;
		proc_count=0;
		if(new_diag_btn.equals("visible")){

			String diag_change_SQL	="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' and stage_no='"+stage_no+"'";
				pstmt = conn.prepareStatement(diag_change_SQL);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					diag_count = rs.getInt("COUNT");
					if(diag_count==0){
						rej_diag	="Y";				
					}else{
						rej_diag="N";
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		
		if(new_proc_btn.equals("visible")){
			String proc_change_SQL	="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' and stage_no='"+stage_no+"'";
				pstmt = conn.prepareStatement(proc_change_SQL);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					proc_count = rs.getInt("COUNT");
					if(proc_count==0){
						rej_proc	="Y";				
					}else{
						rej_proc="N";
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();	
		}*/

		String diag_count_SQL	="SELECT (select COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"')cnt_1,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"')cnt_2,(SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' and stage_no='"+stage_no+"')cnt_3,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' and stage_no='"+stage_no+"')cnt_4 from dual";
		pstmt = conn.prepareStatement(diag_count_SQL);
		rs = pstmt.executeQuery();	

		if(rs !=null && rs.next()){

			diag_count = rs.getInt("cnt_1");
			if(diag_count==0){
				new_diag_btn	="hidden";				
			}else{
				new_diag_btn="visible";
			}

			proc_count = rs.getInt("cnt_2");
			if(proc_count==0){
				new_proc_btn	="hidden";				
			}else{
				new_proc_btn="visible";
			}

			diag_count=0;
			proc_count=0;
			if(new_diag_btn.equals("visible")){

				diag_count = rs.getInt("cnt_3");
				if(diag_count==0){
					rej_diag	="Y";				
				}else{
					rej_diag="N";
				}	
	
			}

			if(new_proc_btn.equals("visible")){

				proc_count = rs.getInt("cnt_4");
				if(proc_count==0){
					rej_proc	="Y";				
				}else{
					rej_proc="N";
				}
			}
		}

	}
}
if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
if(allow_recode_diag_yn.equals("Y")){
if(rej_diag.equals("Y")){
	
            _bw.write(_wl_block202Bytes, _wl_block202);

	}
}
if(allow_recode_proc_yn.equals("Y")){
if(rej_proc.equals("Y")){
	
            _bw.write(_wl_block203Bytes, _wl_block203);

	}
}
//String disp_diagerr_his="";
//String disp_procerr_his="";
int diag_err_cnt=0;
int diag_excodes_cnt=0;
int proc_err_cnt=0;
int proc_excodes_cnt=0;
int diag_origerr_cnt=0;
int proc_origerr_cnt=0;


if(allow_recode_diag_yn.equals("Y")){
	//	String Diagerror_cnt_SQL	="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ";
	/*String Diagerror_cnt_SQL	="SELECT (SELECT COUNT (RECODE_STATUS) FROM MR_DIAGNOSIS_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ) ERROR_STATUS_COUNT, (SELECT COUNT (ERROR_DTL) FROM MR_DIAGNOSIS_RECODING_DTL  WHERE ERROR_DTL = 'X' AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' )  EX_CODES_COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' AND ROWNUM = 1";
	pstmt = conn.prepareStatement(Diagerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		diag_err_cnt = rs.getInt("ERROR_STATUS_COUNT");
		diag_excodes_cnt = rs.getInt("EX_CODES_COUNT");
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	String Diaf_origerr_cnt_SQL="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"'";				
	pstmt = conn.prepareStatement(Diaf_origerr_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		diag_origerr_cnt = rs.getInt("COUNT");
	}

	*/
	String Diagerror_cnt_SQL="SELECT (SELECT COUNT (RECODE_STATUS) FROM MR_DIAGNOSIS_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ) DIAG_ERROR_STATUS_COUNT, (SELECT COUNT (ERROR_DTL) FROM MR_DIAGNOSIS_RECODING_DTL  WHERE ERROR_DTL = 'X' AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' )  DIAG_EX_CODES_COUNT, (SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"') DIAG_ORIG_ERR_COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' AND ROWNUM = 1";
	pstmt = conn.prepareStatement(Diagerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	if(rs!=null && rs.next()){
		diag_err_cnt = rs.getInt("DIAG_ERROR_STATUS_COUNT");
		diag_excodes_cnt = rs.getInt("DIAG_EX_CODES_COUNT");
		diag_origerr_cnt = rs.getInt("DIAG_ORIG_ERR_COUNT");
	}



	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
}

if(allow_recode_proc_yn.equals("Y")){

	//	String Procerror_cnt_SQL	="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE RECODE_STATUS='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ";
	/*String Procerror_cnt_SQL	="SELECT (SELECT COUNT (RECODE_STATUS) FROM MR_PROCEDURE_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ) ERROR_STATUS_COUNT, (SELECT COUNT (ERROR_DTL) FROM MR_PROCEDURE_RECODING_DTL  WHERE ERROR_DTL = 'X' AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' )  EX_CODES_COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' AND ROWNUM = 1";

	pstmt = conn.prepareStatement(Procerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		proc_err_cnt = rs.getInt("ERROR_STATUS_COUNT");
		proc_excodes_cnt = rs.getInt("EX_CODES_COUNT");
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();	


	String Procerror_cnt_SQL="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"'";				

	pstmt = conn.prepareStatement(Procerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		proc_origerr_cnt = rs.getInt("COUNT");
	}
	*/

	String Procerror_cnt_SQL	="SELECT (SELECT COUNT (RECODE_STATUS) FROM MR_PROCEDURE_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"' ) PROC_ERROR_STATUS_COUNT, (SELECT COUNT (ERROR_DTL) FROM MR_PROCEDURE_RECODING_DTL  WHERE ERROR_DTL = 'X' AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' )  PROC_EX_CODES_COUNT,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"') PROC_ORIG_ERR_COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' AND ROWNUM = 1";
	
	pstmt = conn.prepareStatement(Procerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		proc_err_cnt = rs.getInt("PROC_ERROR_STATUS_COUNT");
		proc_excodes_cnt = rs.getInt("PROC_EX_CODES_COUNT");
		proc_origerr_cnt = rs.getInt("PROC_ORIG_ERR_COUNT");
	}

	
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();	

}
	if(diag_err_cnt>0 || proc_err_cnt>0){
            _bw.write(_wl_block204Bytes, _wl_block204);
}
	if(diag_excodes_cnt>0 || proc_excodes_cnt>0){
            _bw.write(_wl_block205Bytes, _wl_block205);
}
	if(diag_origerr_cnt>0 || proc_origerr_cnt>0){
            _bw.write(_wl_block206Bytes, _wl_block206);
}
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(diag_err_cnt));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(proc_err_cnt));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(diag_excodes_cnt));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(proc_excodes_cnt));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(diag_origerr_cnt));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(proc_origerr_cnt));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(dischargeSummary));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block215Bytes, _wl_block215);

}catch(Exception e){
	e.printStackTrace();
 }finally{
		if(main_cal_pstmt!=null)main_cal_pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(conn,request);

 }

	
            _bw.write(_wl_block216Bytes, _wl_block216);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.show.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ViewClinicalHistory.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Select.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSet.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DoctorDesc.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Classification.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CodedBy.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.CauseOfDeath.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
