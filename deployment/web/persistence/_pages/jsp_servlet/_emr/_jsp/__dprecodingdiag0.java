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

public final class __dprecodingdiag0 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingDiag0.jsp", 1742299652404L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script> \n\t<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t<script>\n\tfunction expandDiagnosis()\t{\n//\t\tparent.RecodeScreen.rows=\"80%,5%,*\";\n\t\tparent.RecodeScreen.rows=\"85%,10%,5%,0%\";\n\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.Proc_icon\").innerHTML=\"<a href=\'javascript:onclick=expandProcedure()\'>+</a>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\n\t\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.Diag_icon\").innerHTML=\"<a href=\'javascript:onclick=collapseDiagnosis()\'>-</a>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t}\n\n\tfunction collapseDiagnosis()\t{\n//\t\tparent.RecodeScreen.rows=\"40%,40%,*\";\n\t\tparent.RecodeScreen.rows=\"48%,48%,4%,0%\";\n\t\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.Diag_icon\").innerHTML=\"<a href=\'javascript:onclick=expandDiagnosis()\'>+</a>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\n\t}\n\n\tfunction showDiag()\t{\n\t\t//if(mode.equals(\"Y\"))\n\t\t\t//parent.frames[2].document.RecodeDiagnosisDiagDetail.diagTable.visiblity=\'visible\';\n\n\t}\n\n\tfunction expandRecode(i)\t{\n\t\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recode1\"+i).style.visibility=\'visible\';\n\t\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recode1\"+i).style.display=\'inline\';\n\t\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodeSymbol\"+i).innerHTML=\"<a href=\'javascript:onclick=collapseRecode(\"+i+\")\'>-</a>\";\n\t}\n\n\tfunction collapseRecode(i)\t\t{\n\n\t\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recode1\"+i).style.visibility=\'hidden\';\n\t\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recode1\"+i).style.display=\'none\';\n\t\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodeSymbol\"+i).innerHTML=\"<a href=\'javascript:onclick=expandRecode(\"+i+\")\'>+</a>\";\n\t}\n\n\t//Added by Ajay Hatwate for ML-MMOH-CRF-1940\n\tfunction longDescToolTip(term_code, long_desc) {\n\t    var tab_data2 = \"<div class=\'tooltip1\'> \" + term_code + \" / \" + long_desc + \"</div>\";\n\t    return tab_data2;\n\t}\n\n\t</script>\n\n\t</head>\n\t<body onKeyDown=\'lockKey()\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="onunload=\"destroyPopUps()\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t<form name=\"RecodeDiagnosisDiagDetail\" id=\"RecodeDiagnosisDiagDetail\" method=\'post\'>\n\t<!--<form name=\"RecodeDiagnosisDiagDetail\" id=\"RecodeDiagnosisDiagDetail\">-->\n\t<table id=\'diagTable\' style=\'visibility:visible;display:inline\' border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\"  valign=\'top\' onLoad=\'showDiag();\'>\n\t<tr>\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'fields\'><select name=\'show_level\' id=\'show_level\' onChange=\'getLevel(this);\' onmousewheel=\'return false;\'><!-- <option >----- ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" -----</option> -->\n\n\t<option value=\'0\'>Original</option>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<option value=\'1\' selected>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;1</option>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;1</option>\n\t\t\t<option value=\'2\' selected>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;2</option>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;1</option>\n\t\t\t<option value=\'2\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;2</option>\n\t\t\t<option value=\'3\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;3</option>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<option value=\'1\'selected>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;1</option>\n\t\t<option value=\'2\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;2</option>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;1</option>\n\t\t<option value=\'2\' selected>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;2</option>\n\t\t<option value=\'3\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;3</option>\n\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t</select>\n\t</td>\n\t<td colspan=\"6\"><input type=\'button\' name=\'Reject_Diag\' id=\'Reject_Diag\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" Diagnosis\' class=\'button\'  onclick=\'Original_Diag();\' style=\"visibility:hidden\">&nbsp;<input type=\'button\' name=\'Reject_Proc\' id=\'Reject_Proc\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" Procedure\' class=\'button\'  onclick=\'Original_Proc();\' style=\"visibility:hidden\">&nbsp;</td>\n\t<!-- <td colspan=1 nowrap>\n\t\t<a href=\"javascript:onclick=show_clinic_his()\" >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a>\n\t</td> -->\n\n\t</td>\n\t\t<td nowrap onmouseover=\"hideTooltip()\">\n\t\t\t<a href=\"javascript:onclick=DummyRef()\" onclick=\"displayMenu()\"  style=\"cursor:pointer\" >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</a>&nbsp;&nbsp;\n\t\t</td>\n\n\t\n\t<td id=\'origerrorHistory\' style=\"display:none\" nowrap>\n\t\t\t<img src=\'../../eCommon/images/PI_SuspendedPatient.gif \'  style=\"cursor:pointer;\"onclick=\"show_err_history(\'ORIG_MRK_ERR\')\" alt=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">&nbsp;&nbsp;\n\t</td>\n\t</tr>\n\n\t<tr>&nbsp;</tr>\n\t<table style=\"visibility:";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"width=\'100%\'  border=\'1\' cellpadding=\'1\' cellspacing=\'0\'>\n\t<tr style=\"visibility:";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"><td colspan=\'10\' class=\'PANELTOOLBAR\' id=\"Diag_icon\"><a href=\"javascript:onclick=expandDiagnosis()\" style=\"visibility:";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">+</a>&nbsp;";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td></tr>\n\t\t<tr>&nbsp;</tr>\n\t<tr>\n\t<th align=\'center\'>&nbsp;</th>\n\t<th align=\'center\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th>\n\t<th align=\'center\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</th>\n\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</th>\n\t<th align=\'center\' >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</th>\n\t<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;&nbsp;</th>\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<th align=\'center\' >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</th>\n\t<!-- \t<th align=\'center\' >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</th>Added On 7/2/2009-->\t\n    <th align=\'center\' >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</th> \n\t<th align=\'center\' >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</th>\n\t</tr>\n\n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t<tr id=\'recode1";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t\t<img src=\'../../eCommon/images/EqivDiag.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"onclick=\'callDetails(\"Eq_Term_cd\",\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\",\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\",\"\",\"\",\"\",\"\",\"\")\' alt=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"><img src=\'../../eCommon/images/SuppDiag.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"onclick=\'recodeSupportDiagnosis(\"ORIGINAL\",\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\",\"\")\' alt=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"><img src=\'../../eCommon/images/RecodeRemarks.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"onclick=\'callDetails(\"Remarks\",\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\",\"N\",\"\",\"\")\' alt=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"><span nowrap title=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" style=\"cursor:pointer;display:";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"><a href=\"javascript:showLongDescription(\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\')\"><b>!</b></a></span>\n\t\t\t\t</td>\t<!-- Equalent Term Code,Support Diag&Remarks Images  -->\n\t\t\t\t<!--Modified by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269--> \n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'><input type=\'checkbox\' name=\'select_chk1";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'select_chk1";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="$";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="$REVIEW$";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="~\' onClick=\'enableSelect1(";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =",this,document.forms[0].term_code.value)\' ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" onMouseOver=\"Tip(longDescToolTip(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\', \'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'))\" onMouseOut=\"UnTip()\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->\n\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>&nbsp;";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="&nbsp;</td><!-- Diag.Classification -->\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' nowrap>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>&nbsp;<img src=\'../../eCommon/images/Y-Red.gif\' alt=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>&nbsp;<img src=\'../../eCommon/images/y-white.gif\' alt=\'Related\'/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>&nbsp;<img src=\'../../eCommon/images/n-white.gif\' alt=\'Not Related\'/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>&nbsp;<img src=\'../../eCommon/images/n-white.gif\'/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t<script>\n\t\t\tdocument.getElementById(\"origerrorHistory\").style.display=\"inline\";\n\t\t</script>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t</table>\n\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"diag_origerr_cnt\" id=\"diag_origerr_cnt\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\t\t\n\t\t<input type=\"hidden\" name=\"proc_origerr_cnt\" id=\"proc_origerr_cnt\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\n\t\t<input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t<input type=\'hidden\' name=\'diagprob_code\' id=\'diagprob_code\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t<input type=\'hidden\' name=\'temp_code\' id=\'temp_code\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t<input type=\'hidden\' name=\'sel_item\' id=\'sel_item\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'dflt_termset\' id=\'dflt_termset\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\t\t<input type=\'hidden\' name=\'Pat_id\' id=\'Pat_id\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\t\t<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t\t<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n\t\t<input type=\'hidden\' name=\'spec_code\' id=\'spec_code\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n\t\t<input type=\'hidden\' name=\'Patient_Class\' id=\'Patient_Class\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t<input type=\'hidden\' name=\'EncounterId\' id=\'EncounterId\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\t\t<input type=\'hidden\' name=\'Practitioner_Id\' id=\'Practitioner_Id\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t\t<input type=\'hidden\' name=\'fieldSeperator\' id=\'fieldSeperator\' value=\'|\'>\n\t\t<input type=\'hidden\' name=\'profileID\' id=\'profileID\' value=\'XB\'>\n\t\t<input type=\'hidden\' name=\'caused_death\' id=\'caused_death\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t\t<input type=\'hidden\' name=\'code_set\' id=\'code_set\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'diagprob_code\' id=\'diagprob_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'diag_classfication\' id=\'diag_classfication\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'accuracy\' id=\'accuracy\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'severity\' id=\'severity\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'onset_type\' id=\'onset_type\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'onset_date\' id=\'onset_date\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'status\' id=\'status\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'status_date\' id=\'status_date\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'applicable_side\' id=\'applicable_side\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'occur_srl_no\' id=\'occur_srl_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'recode_status\' id=\'recode_status\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'orig_termset\' id=\'orig_termset\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'orig_termcode\' id=\'orig_termcode\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'checked_yn\' id=\'checked_yn\' value=\'N\'>\n\t\t<input type=\'hidden\' name=\'hd_term_set\' id=\'hd_term_set\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t\t<input type=\'hidden\' name=\'hd_term_code\' id=\'hd_term_code\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t\t<input type=\'hidden\' name=\'drg_temp\' id=\'drg_temp\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\n\t\t<input type=\'hidden\' name=\'cnt1\' id=\'cnt1\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t<input type=\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t\t<input type=\'hidden\' name=\'termcode_cnt\' id=\'termcode_cnt\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t\t<input type=\'hidden\' name=\'authorize_item\' id=\'authorize_item\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t\t<input type=\'hidden\' name=\'procedure_yn\' id=\'procedure_yn\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'recal_yn\' id=\'recal_yn\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'p_episode_type\' id=\'p_episode_type\' value=\'I\'>\n\t\t<input type=\'hidden\' name=\'temp_chk\' id=\'temp_chk\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t<input type=\'hidden\' name=\'stage_l2\' id=\'stage_l2\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n\t\t<input type=\'hidden\' name=\'sequenced_yn\' id=\'sequenced_yn\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\t\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\t\n\t\t<input type=\"hidden\" name=\"chk_yn\" id=\"chk_yn\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\t\n\t\t<input type=\"hidden\" name=\"y\" id=\"y\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\t\n\t\t<input type=\"hidden\" name=\"tot_cnt\" id=\"tot_cnt\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t\t<input type=\"hidden\" name=\"recd_count\" id=\"recd_count\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t\t<input type=\"hidden\" name=\"rev_flg\" id=\"rev_flg\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\n\t\t<input type=\"hidden\" name=\"cur_Sel\" id=\"cur_Sel\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n<!-- \t\t<input type=\'hidden\' name=\'show_level\' id=\'show_level\' value=\'\'>\n -->\t\t<input type=\'hidden\' name=\'Stage_no\' id=\'Stage_no\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n\t\t<input type=\'hidden\' name=\'stage_no\' id=\'stage_no\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t\t<input type=\'hidden\' name=\'allow_recode_diag_yn\' id=\'allow_recode_diag_yn\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t\t<input type=\'hidden\' name=\'allow_recode_proc_yn\' id=\'allow_recode_proc_yn\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t\t<!--Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272-->\n\t\t<input type=\"hidden\" name=\"dischargeSummary\" id=\"dischargeSummary\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\n\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t <script>\n\t\t\tdocument.forms[0].show_level.options.selectedIndex=0;\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:15%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr><td width=\'100%\' id=\'t\'></td></tr>\n\t\t\t</table>\n\t\t</div>\t\n\t\t</form>\n\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n<script language=\'javascript\' src=\'../../eOT/js/wz_tooltip.js\'></script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

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
	
 
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
 String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
 String loginUser		= (String) session.getValue( "login_user" );	
 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale = (String)session.getAttribute("LOCALE"); 

 String EncounterId = request.getParameter("EncounterId");
 String mode = checkForNull(request.getParameter("mode"));
 String dflt_termset = checkForNull(request.getParameter("dflt_termset"));
 String Pat_id = checkForNull(request.getParameter("Pat_id"));
 String temp_code = checkForNull(request.getParameter("temp_code"));
 String gender = checkForNull(request.getParameter("gender"));
 String age = checkForNull(request.getParameter("age"));
 String dob = checkForNull(request.getParameter("dob"));
 String spec_code = checkForNull(request.getParameter("spec_code"));
 String Patient_Class = checkForNull(request.getParameter("Patient_Class"));
 //String DRGcal = checkForNull(request.getParameter("DRGcal"));
 String drg_temp = checkForNull(request.getParameter("drg_temp"));
 String stage_no = checkForNull(request.getParameter("stage_no"));
 String stage_l2 = checkForNull(request.getParameter("stage_l2"));
 String sequenced_yn = checkForNull(request.getParameter("sequenced_yn"));
 String tot_cnt = checkForNull(request.getParameter("tot_cnt"));
 String cur_Sel=checkForNull(request.getParameter("sel_val"));

String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");

//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
Boolean doctorsDescription = false;
String doctors_description = "";
Boolean isMultiDescAppl = false; // added by mujafar for ML-MMOH-CRF-1281

//Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272
Boolean dischargeSummary = false;
String accession_num = "";

//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
Boolean isDiagClassLongDescAppl = false;
String diag_class_long_desc = "";

 String recd_count="0";
 int Stage_no = 0;
 int y=0;
 String chk_yn = "";

if(stage_no != "")
   Stage_no = Integer.parseInt(stage_no);



Connection conn = ConnectionManager.getConnection(request);	

 if(mode.equals(""))
	mode="N";
try
 {

	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1		= null;
	//PreparedStatement pstmt2		= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	//ResultSet rs2				= null;
	StringBuffer sql1 = new StringBuffer();
	String term_set		= "";
	String term_code	= "";
	String term_desc	= "";
	String record_by	= "";
	String record_date		= "";
	String caused_death		= "";
	String classValue			= "";
	String hd_term_set	    = "";
	String hd_term_code		= "";
	String patient_id			= "";
	String authorize_item	= "";
	String p_episode_type  = "";
	String temp_chk			= "N";
	String free_text_yn		="";
	String dagger_independent_yn	= "";// Added For SRR-CRF-303.2 On 1/28/2010
	String disp_dagger_dep_ind		= "";// Added For SRR-CRF-303.2 On 1/28/2010
	String cross_ref_type				= "";// Added For SRR-CRF-303.2 On 1/28/2010
	String occur_srl_no					= "";// Added For SRR-CRF-303.2 On 1/28/2010
	String associate_codes				= "";// Added For SRR-CRF-303.2 On 1/28/2010

	doctorsDescription =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DOCTOR_DESC"); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
	isMultiDescAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281
	/*Added by Ashwini on 22-Jan-2019 for ML-MMOH-CRF-1272*/
	dischargeSummary =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DISCHARGE_SUMMARY");

	isDiagClassLongDescAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DIAG_CLASS_LONG_DESC"); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364

	JSONObject jsonAccssnNo = eMR.MRCommonBean.getAccessionNum(conn,EncounterId,Pat_id);
	accession_num = (String) jsonAccssnNo.get("accession_num");
	/*End ML-MMOH-CRF-1272*/
	boolean toolTip_diagnosis	=   eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","TOOLTIP_FOR_DIAGNOSIS");	//Added by AJay Hatwate for ML-MMOH-CRF-1940
//	String equivalent_term_code = "";
	String recodeStatus = "";
	//int nc_cnt=0;
	String rev_flg="N";


	int i = 0;
	int cnt1 = 0;
	//int auth_cnt = 0;



	if(Patient_Class.equals("IP"))
		p_episode_type="I";
	else if(Patient_Class.equals("EM"))
		p_episode_type="E";
	else if(Patient_Class.equals("DC"))
		p_episode_type="D";
	else if(Patient_Class.equals("OP"))
		p_episode_type="O";

	String  hide_header		="";
	String  hide_dataTable	="";
	String  hide_exp			="";
	String show_eq_tmcd	=	"";
	String show_sprt_diag	=	"";
	String show_remarks	=	"";				
	String Stage_srl_no		=	"";				
	String remarks		=	"";				
	String diag_classification		=	"";		
	String death_reg_seq_no		=	"";	//Added On 9/22/2009 For MDR.




/*Note:Based upon the  allow_recode_diag_yn value(Parameter Setup) 
the perticular part is hiding to Display Only Procedure Part To User*/
	if(allow_recode_diag_yn.equals("Y")){
		hide_header		=	"visible";
		hide_dataTable	=	"visible";
	}else{
		hide_header		=	"hidden";
		hide_dataTable	=	"hidden";
	}
	if(allow_recode_proc_yn.equals("Y")){
		hide_exp			=	"visible";
	}else{
		hide_exp			=	"hidden";
	}



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

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	if(stage_l2.equals("")) {
		if(Stage_no == 1){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		}else if(Stage_no == 2){
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

		}else if(Stage_no == 3){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
	}else if(stage_l2.equals("Y")){
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
}
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.showerrorcodesbypractitioner.label","mr_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(hide_dataTable));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(hide_header));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(hide_exp));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
if(doctorsDescription){
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

		String  remark_lbl			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
		String  eqvi_code_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels");
		String spprt_dig_lbl		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SupportingDiagnosis.label","common_labels");		
		String diag_clas_lbl		=	"";		
	
		String New_EncounterId=EncounterId;//If allow_recode_diag_yn="Y";
		if(allow_recode_diag_yn.equals("N")){
			New_EncounterId="";
		}

		if(mode.equals("Y")){
					 

			if ( i % 2 == 0 )
				classValue = "gridData" ;
			else
				classValue = "gridData" ;
		
			//sql1.append("SELECT A.PATIENT_ID,A.TERM_SET_ID,A.TERM_CODE, B.SHORT_DESC, am_get_desc.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1') practitioner_name, TO_CHAR (A.RECORDED_DATE_TIME, 'dd/mm/yy hh24:mi') RECORDED_DATE_TIME, 	A.CAUSE_OF_DEATH_YN FROM PR_DIAGNOSIS_ENC_DTL A,MR_TERM_CODE B WHERE A.FACILITY_ID = '"+p_facility_id+"' AND A.ENCOUNTER_ID = '"+EncounterId+"' AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE");

			//sql1.append("SELECT a.patient_id, a.term_set_id, a.term_code, b.short_desc,       am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,       TO_CHAR(a.recorded_date_time, 'dd/mm/yy hh24:mi') recorded_date_time, a.cause_of_death_yn FROM pr_diagnosis c,pr_diagnosis_enc_dtl a, mr_term_code b WHERE a.facility_id = '"+p_facility_id+"'   AND a.encounter_id = '"+EncounterId+"' AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code and c.patient_id=a.patient_id and c.term_set_id=a.term_set_id and c.term_code=a.term_code and c.occur_srl_no=a.occur_srl_no AND c.curr_facility_id=a.facility_id and c.curr_encounter_id=a.encounter_id");

			/*Query Was Modified For MDR Modified On 9/22/2009*/
			/*Modified by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364*/
			sql1.append("SELECT a.patient_id, a.term_set_id, a.term_code, b.short_desc,b.free_text_yn,(case when a.term_code = '*OTH' then a.term_code_short_desc else mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2') end) term_code_short_desc,a.term_code_short_desc term_code_short_desc1,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,TO_CHAR(a.recorded_date_time, 'dd/mm/yyyy hh24:mi') recorded_date_time, a.cause_of_death,a.death_reg_seq_no,decode(recode_status,'O','Review')recode_status, Stage_srl_no,remarks,decode (c.DIAG_CLASS_TYPE,'PD','Principal','CM','Comorbidity','EC','External Causes','CO','Complication','','Others') diag_classification,decode (c.DIAG_CLASS_TYPE,'PD','1','CM','2','EC','4','CO','3','','5') diag_classification_grp, mr_get_desc.mr_diag_class (a.diag_class_code,'"+locale+"', '1') diag_class_long_desc, b.dagger_independent_yn,b.cross_ref_type,a.occur_srl_no,b.long_desc,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mc WHERE mc.TERM_SET_ID = a.term_set_id AND mc.term_code = a.term_code AND mc.CROSS_REF_TYPE = 'EQ') equiv_count,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct1 WHERE mct1.TERM_SET_ID = a.term_set_id AND mct1.TERM_CODE = a.term_code AND mct1.EQUIVALENT_TERM_SET_ID = a.term_set_id AND mct1.CROSS_REF_TYPE='AS' ) dgr_cnt,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct2 WHERE mct2.TERM_SET_ID = a.term_set_id AND Mct2.TERM_CODE = a.term_code AND mct2.EQUIVALENT_TERM_SET_ID = a.term_set_id AND mct2.CROSS_REF_TYPE='EC' ) conseq_cnt,DOCTORS_DESCRIPTION FROM  MR_DIAGNOSIS_RECODING_DTL  a, mr_term_code b,MR_DIAG_CLASS c WHERE a.facility_id = '"+p_facility_id+"'  AND a.encounter_id = '"+New_EncounterId+"' and a.recode_status='O' and stage_no='0' and status='A' and a.term_set_id = b.term_set_id AND a.term_code = b.term_code  and a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE (+)  order by diag_classification_grp");
			// modified by mujafar for ML-MMOH-CRF-1281
			//DOCTORS_DESCRIPTION Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
			pstmt = conn.prepareStatement(sql1.toString());
			rs = pstmt.executeQuery();	
			while(rs.next()){
				String long_desc				= "";// Added For Site Enhancement On 3/11/2010
				String display_long_desc	 = "none";// Added For Site Enhancement On 3/11/2010
				String long_desc_params	 = "";// Added For Site Enhancement On 3/11/2010
				int equivalent_term_code_cnt =0;
				int support_diag_cnt				  =0;

				patient_id				= checkForNull(rs.getString("patient_id"));
				term_set				= checkForNull(rs.getString("term_set_id"));
				term_code			= checkForNull(rs.getString("term_code"));
				free_text_yn			= checkForNull(rs.getString("free_text_yn"));
				if(free_text_yn.equals("Y")){
					term_desc		= checkForNull(rs.getString("term_code_short_desc"));
				}else{
					term_desc		= checkForNull(rs.getString("short_desc"));
				}
				
				
				if(isMultiDescAppl && term_set.equals("ICD10") ) //  added by mujafar for ML-MMOH-CRF-1281
				{
				term_desc = checkForNull(rs.getString("term_code_short_desc1"));
				if(term_desc.equals(""))
				term_desc		= checkForNull(rs.getString("SHORT_DESC"));
				}
				
				
				
				record_date			 = checkForNull(rs.getString("recorded_date_time"));
				record_date			 =DateUtils.convertDate(record_date,"DMYHM" ,"en",locale);
				record_by			 = checkForNull(rs.getString("practitioner_name"));
				caused_death		 = checkForNull(rs.getString("cause_of_death"));
				death_reg_seq_no = checkForNull(rs.getString("death_reg_seq_no"));
				recodeStatus			 = checkForNull(rs.getString("recode_status"));
				remarks				 = checkForNull(rs.getString("remarks"));
				Stage_srl_no			 = checkForNull(rs.getString("Stage_srl_no"));
				diag_classification	 = checkForNull(rs.getString("diag_classification"));
				dagger_independent_yn	= checkForNull(rs.getString("dagger_independent_yn"));
				cross_ref_type					= checkForNull(rs.getString("cross_ref_type"));
				occur_srl_no						= checkForNull(rs.getString("occur_srl_no"));
				long_desc							= checkForNull(rs.getString("long_desc"));
				equivalent_term_code_cnt= rs.getInt("equiv_count");

				doctors_description	= checkForNull(rs.getString("doctors_description")); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
				diag_class_long_desc = checkForNull(rs.getString("diag_class_long_desc")); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364

//				long_desc							= java.net.URLEncoder.encode(long_desc);
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
				
				if(recodeStatus.equals("Review")){
					recodeStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//For Original Code;
				}

			//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
			if(isDiagClassLongDescAppl){
				diag_clas_lbl = diag_class_long_desc;
			}else
			{
				if(diag_classification.equals("Principal")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.principal.label","mr_labels");
				}else if(diag_classification.equals("Comorbidity")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.comorbidity.label","mr_labels");
				}else if(diag_classification.equals("External Causes")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.externalcauses.label","mr_labels");
				}else if(diag_classification.equals("Complication")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.complication.label","mr_labels");
				}else if(diag_classification.equals("Others")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.others.label","mr_labels");
				}
			}
			
			//int cnt_icd = 0;
				//String sqlicd="SELECT EQUIVALENT_TERM_CODE FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID != 'ICD10' AND EQUIVALENT_TERM_SET_ID = 'ICD10' AND term_code = '"+term_code+"'";
			
/*For EQUIVALENT_TERM_CODE
				This Query Was merged with main Quey For  PE Tuning
*/
					/*String sqlicd="SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID = '"+term_set+"' AND term_code = '"+term_code+"' AND CROSS_REF_TYPE = 'EQ'";
					pstmt1 = conn.prepareStatement(sqlicd);
					rs1	 = pstmt1.executeQuery();	
					while(rs1.next()){
							equivalent_term_code_cnt=rs1.getInt("COUNT");
					}
					if(pstmt1 != null) pstmt1.close();
					if(rs1 != null) rs1.close();*/
/**Ends**/
/*For Support Diagnosis*/
/*
		F.Y.I :Added on 1/28/2010 For SRR-CRF-303.2
		1.Based Upon the code indicator the supporting diagnosis icon will be open.
		2.Before this enhancement if the icon was clicked only the astrik codes are visible for the respective Dagger.
*/
//				String sql_sprt_diag="";
				if(cross_ref_type.equals("D")){ 
//						show_sprt_diag	= "visible";
						associate_codes		= "A";
						support_diag_cnt		=rs.getInt("dgr_cnt");
				}else if(cross_ref_type.equals("C")){
						associate_codes		= "EC";
						support_diag_cnt		=rs.getInt("conseq_cnt");
				}else{
						show_sprt_diag	="hidden";
						associate_codes	="";
				}						

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
				
				//StringBuffer sql3 = new StringBuffer();
				
				//String recodesql_21 = "select count(*) FROM MR_DIAGNOSIS_RECODING WHERE FACILITY_ID = '"+p_facility_id+"' AND ENCOUNTER_ID = '"+EncounterId+"' AND  STAGE_NO='"+Stage_no+"' AND ORIG_TERM_SET_ID='"+term_set+"' AND ORIG_TERM_CODE='"+term_code+"' and RECODE_STATUS !='NEWCODE'";
				//pstmt = conn.prepareStatement(recodesql_21);
				//rs1	 = pstmt.executeQuery();

				//int mr_diag_count=0;
				String chk_status ="disabled";

				//if(rs1.next()){
					//mr_diag_count=rs1.getInt(1);

				//}


				//if(mr_diag_count > 0)
					//chk_status="disabled";
				//else
					//chk_status="";
				
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(show_eq_tmcd));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(eqvi_code_lbl));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(show_sprt_diag));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(cur_Sel));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Stage_srl_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(spprt_dig_lbl));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(show_remarks));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Stage_srl_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(remark_lbl));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(java.net.URLEncoder.encode(term_desc)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(chk_status));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(disp_dagger_dep_ind));
            _bw.write(_wl_block79Bytes, _wl_block79);
if(toolTip_diagnosis){ 
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(term_code ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(long_desc ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
}else{ 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
} 
            _bw.write(_wl_block86Bytes, _wl_block86);
if(doctorsDescription){
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(doctors_description));
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(diag_clas_lbl));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(record_by));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(record_date));
            _bw.write(_wl_block91Bytes, _wl_block91);
if(caused_death.equals("C")){
					String title="";
					if(death_reg_seq_no.equals("1")){
						 title="Primary";
					}
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(title));
            _bw.write(_wl_block94Bytes, _wl_block94);
}else if(caused_death.equals("O")){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block96Bytes, _wl_block96);
}else if(caused_death.equals("R")){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block97Bytes, _wl_block97);
}else{
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block98Bytes, _wl_block98);
}
            _bw.write(_wl_block99Bytes, _wl_block99);
}  // while loop

					
		} // mode check
		int  diag_origerr_cnt=0;
		int  proc_origerr_cnt=0;
		String Diag_Proc_err_cnt_SQL="SELECT (SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"')diag_err_cnt,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"')proc_err_cnt FROM DUAL";
		pstmt = conn.prepareStatement(Diag_Proc_err_cnt_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			diag_origerr_cnt = rs.getInt("diag_err_cnt");
			proc_origerr_cnt = rs.getInt("proc_err_cnt");
		}
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();

		/*String Proc_err_cnt_SQL="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"'";				
		pstmt = conn.prepareStatement(Proc_err_cnt_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
		}
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();*/

	if(diag_origerr_cnt>0 || proc_origerr_cnt>0){
            _bw.write(_wl_block100Bytes, _wl_block100);
}

		if(rs != null)rs.close();
		if(rs1 != null)rs1.close();
		if(pstmt  != null)pstmt.close();
		if(pstmt1  != null)pstmt1.close();
		
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(diag_origerr_cnt));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(proc_origerr_cnt));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(temp_code));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(age));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(Patient_Class));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(caused_death));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(hd_term_set));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(hd_term_code));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(drg_temp));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(cnt1));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(authorize_item));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(temp_chk));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(stage_l2));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(sequenced_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(chk_yn));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(y));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(tot_cnt));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(recd_count));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(rev_flg));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(cur_Sel));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(allow_recode_diag_yn));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(allow_recode_proc_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(dischargeSummary));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block140Bytes, _wl_block140);


		if(cur_Sel.equals("0")){
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block142Bytes, _wl_block142);

}catch(Exception e) {
	e.printStackTrace();
 }finally{
		ConnectionManager.returnConnection(conn,request);

 }

	
            _bw.write(_wl_block143Bytes, _wl_block143);
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ViewClinicalHistory.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ViewClinicalHistory.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Select.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSet.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DoctorDesc.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Classification.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CodedBy.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CausedDeath.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
