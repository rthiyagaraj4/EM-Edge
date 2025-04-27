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
import java.util.*;
import com.ehis.util.*;

public final class __dprecodingproc1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingProc1.jsp", 1737635599621L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script> \n\t<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t<script>\n\n\t\tfunction disableButtons(){\n//\t\t\tparent.RecodeScreen.rows=\"47%,47%,0%,0%\";\n\t\t\t\t\tvar allow_recode_diag_yn\t= document.forms[0].all.allow_recode_diag_yn.value;\n\t\t\t\t\tvar allow_recode_proc_yn\t= document.forms[0].all.allow_recode_proc_yn.value;\n\t\t\t\t\tif(allow_recode_diag_yn==\"Y\" && allow_recode_proc_yn==\"Y\"){\n\t\t\t\t\t\tparent.RecodeScreen.rows=\"48%,48%,4%,0%\";\n\t\t\t\t\t}else if(allow_recode_diag_yn==\"Y\"){\n\t\t\t\t\t\tparent.RecodeScreen.rows=\"95%,0%,5%,0%\";\n\t\t\t\t\t}else if(allow_recode_proc_yn==\"Y\"){\n\t\t\t\t\t\tparent.RecodeScreen.rows=\"10%,85%,5%,0%\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].new_code_diag){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].new_code_diag.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].new_code_diag.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].new_code_proc){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].new_code_proc.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].new_code_proc.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].recode){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].recode.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].recode.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].confirm){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].confirm.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].confirm.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].error){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].error.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].error.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.frames[4].document.forms[0].complete){\n\t\t\t\t\t\tparent.frames[4].document.forms[0].complete.disabled=true;\n\t\t\t\t\t\tparent.frames[4].document.forms[0].complete.style.visibility=\"hidden\";\n\t\t\t\t\t}\n\n\t\t\t\t\t\n\t\t}\n\n\t\t/*function disable_confirmed_Buttons(){\n\n\t\t\t\t\tvar final_diag_values=parent.frames[2].document.forms[0].final_diag_values.value;\n\t\t\t\t\tvar final_proc_values=parent.frames[3].document.forms[0].final_proc_values.value;\n//\t\t\t\t\talert(final_proc_values)\n\t\t\t\t\tvar out_arr=\"\";\n\n\t\t\t\t\tvar DB_Chkdiag_Values=\"\";\n\t\t\t\t\tvar DB_Chkdiag_srl_no=\"\";\n\t\t\t\t\tvar DB_Chkproc_Values=\"\";\n\t\t\t\t\tvar DB_Chkproc_srl_no=\"\";\n\n\t\t\t\t\tvar error=\'\';\n\n\t\t\t\t\tif(final_diag_values!=\"\"){\n\t\t\t\t\t\t out_arr=final_diag_values.split(\"~\");\n\t\t\t\t\t\tfor(i=0;i<out_arr.length-1;i++){\n\t\t\t\t\t\t\tvar in_arr=out_arr[i].split(\"$\");\n\t\t\t\t\t\t\tif(in_arr[3]!=\'Confirmed\'){\n\t\t\t\t\t\t\t\terror=\"Y\";\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(final_proc_values!=\"\"){\n\t\t\t\t\t\tout_arr1=final_proc_values.split(\"~\");\n\t\t\t\t\t\tfor(ij=0;ij<out_arr1.length-1;ij++){\n\t\t\t\t\t\t\tvar in_arr1=out_arr1[ij].split(\"$\");\n\t\t\t\t\t\t\tif(in_arr1[3]!=\'Confirmed\'){\n\t\t\t\t\t\t\t\terror=\"Y\";\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tif(error==\"\"){\n\t\t\t\t\t\tif(parent.frames[4].document.forms[0].recode){\n\t\t\t\t\t\t\tparent.frames[4].document.forms[0].recode.disabled=true;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[4].document.forms[0].confirm){\n\t\t\t\t\t\t\tparent.frames[4].document.forms[0].confirm.disabled=true;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[4].document.forms[0].error){\n\t\t\t\t\t\t\tparent.frames[4].document.forms[0].error.disabled=true;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t}\t*/\n\n\n\t\tfunction expandProcedure(){\n//\t\t\tparent.RecodeScreen.rows=\"48%,48%,4%,0%\";\n\t\t\t/* parent.RecodeScreen.rows=\"13%,85%,5%,0%\"; */\n\t\t\tparent.document.getElementById(\"DiagProcRecodingPatDetail\").style.height=\"18vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisDiag\").style.height=\"22vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisProc\").style.height=\"49vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisButton\").style.height=\"5vh\";\n\t\t\tparent.document.getElementById(\"DiagProcTrans\").style.height=\"0vh\";\n\t\t\tparent.frames[2].document.getElementById(\"Diag_icon\").innerHTML=\"<a href=\'javascript:onclick=expandDiagnosis()\'>+</a>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\tparent.frames[3].document.getElementById(\"Proc_icon\").innerHTML=\"<a href=\'javascript:onclick=collapseProcedure()\'>-</a>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t}\n\n\t\tfunction collapseProcedure(){\n//\t\t\tparent.RecodeScreen.rows=\"40%,40%,5%\";\n\t\t\t/* parent.RecodeScreen.rows=\"48%,48%,4%,0%\"; */\n\t\t\tparent.document.getElementById(\"DiagProcRecodingPatDetail\").style.height=\"33vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisDiag\").style.height=\"37vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisProc\").style.height=\"45vh\";\n\t\t\tparent.document.getElementById(\"RecDiagnosisButton\").style.height=\"5vh\";\n\t\t\tparent.document.getElementById(\"DiagProcTrans\").style.height=\"0vh\";\n\t\t\tparent.frames[3].document.getElementById(\"Proc_icon\").innerHTML=\"<a href=\'javascript:onclick=expandProcedure()\'>+</a>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\n\t\t}\n\n\t\t/*function expandRecode(i){\n\t\t\t//alert(\"expandRecode \"+i);\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1\"+i).style.visibility=\'visible\';\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1\"+i).style.display=\'inline\';\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol\"+i).innerHTML=\"<a href=\'javascript:onclick=collapseRecode(\"+i+\")\'>-</a>\";\n\t\t}\n\n\t\tfunction collapseRecode(i){\n\t\t\t//alert(\"collapseRecode \"+i);\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1\"+i).style.visibility=\'hidden\';\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1\"+i).style.display=\'none\';\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol\"+i).innerHTML=\"<a href=\'javascript:onclick=expandRecode(\"+i+\")\'>+</a>\";\n\t\t}*/\n\t\tfunction expandHist(i)\t{\n\t\tvar sel=i;\n//\t\tvar len=eval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist\"+parseInt(sel)).length;\n\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist\"+parseInt(sel)).style.visibility=\'visible\';\n\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist\"+parseInt(sel)).style.display=\'inline\';\n\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol\"+parseInt(sel)).innerHTML=\"<a href=\'javascript:onclick=collapseHist(\"+parseInt(sel)+\")\'>-</a>\";\n\t}\n\n\tfunction collapseHist(i)\t{\n\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist\"+parseInt(i)).style.visibility=\'hidden\';\n\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist\"+parseInt(i)).style.display=\'none\';\n\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol\"+parseInt(i)).innerHTML=\"<a href=\'javascript:onclick=expandHist(\"+parseInt(i)+\")\'>+</a>\";\n\t}\n\n\t</script>\n</head>\n<body onKeyDown=\'lockKey()\' >\n\t<form name=\"RecodeDiagnosisProcDetail\" id=\"RecodeDiagnosisProcDetail\" method=\'post\' >\n\n\t\t<table border=\'0\' cellpadding=\'1\' cellspacing=\'0\' width=\"93%\"  valign=\'top\' style=\"visibility:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<tr><td colspan=\'13\' class=\'PANELTOOLBAR\' id=\"Proc_icon\"><a href=\"javascript:onclick=expandProcedure()\" style=\"visibility:";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">+</a>&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td></tr>\n\t\t<tr>&nbsp;</tr>\n\n\t\t<tr>\n\t\t\t<th align=\'center\'>&nbsp;</th>\n\t\t\t<th align=\'center\'>&nbsp;</th><!-- Added On 7/2/2009 -->\n\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th><!-- Added On 7/8/2009 -->\n\t\t\t<th align=\'center\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </th><!-- Added On 7/8/2009 -->\n<!-- \t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th></th>  Added 7/2/2009-->\t\t\t\n\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\n<!-- \t\t\t<th align=\'center\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n -->\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdd_trx_no";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"hdd_trx_no";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t\t\t<select name=\'seqproc";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'seqproc";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' disabled onchange=\"validate_duplicate_proc(this,";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =")\">\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/EqivDiag.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"onclick=\'callDetails(\"Eq_Term_cd\",\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\",\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\",\"\",\"\",\"\",\"\",\"\")\' alt=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"/><img src=\'../../eCommon/images/RecodeRemarks.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"onclick=\'callDetails(\"Remarks\",\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\",\"Y\",\"\",\"\")\' alt=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"/><img src=\'../../eCommon/images/order_catalog.gif \' style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"onclick=\'callDetails(\"AcessionNum\",\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\",\"\",\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\")\' alt=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"/><span nowrap title=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" style=\"display:";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"><a href=\"javascript:showLongDescription(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\')\"><b>!</b></a></span>\n\t\t\t\t\t\t\t</td>\t<!-- Equalent Term Code,Remarks Images & Order Catalog Images  -->\n\n\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'><input type=\'checkbox\' name=\'select_chk1";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'select_chk1";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="$";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="~\' onClick=\'selectProcedure(";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =",this)\' ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" ></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Status";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"Status";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp;/&nbsp;<a href=\"javascript:onclick=selectProcedure(";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =",document.forms[0].select_chk1";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =",document.forms[0].proc_code.value,\'ProcModify\',\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\')\" >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</a></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' wrap >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' >&nbsp;";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'nowrap>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' nowrap>&nbsp;";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'nowrap>&nbsp;";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\n<!-- \t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n -->\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td id=\'recodeSymbol";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' class=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>&nbsp;\n\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdd_trx_no";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<select name=\'seqproc";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =")\">\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:onclick=expandHist(\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\')\">+</a>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/EqivDiag.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"/><img src=\'../../eCommon/images/order_catalog.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\')\"><b>!</b></a></span>\n\t\t\t\t\t\t\t\t\t\t</td>\t<!-- Equalent Term Code,Remarks Images & Order Catalog  Images -->\n\n\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="~\' \t\n\t\t\t\t\t\t\t\t\t\tonClick=\'selectProcedure(";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="></td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Status";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</a></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'  >";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td><!-- Added On 12/14/2009 for SRR-CRF-303.1 -->\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td><!-- Added On 12/14/2009 for SRR-CRF-303.1 -->\n\n<!-- \t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n -->\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t <tr>\n\t\t\t\t\t\t\t\t\t\t<td colspan=10 align=\"left\" width=\"100%\">\n\t\t\t\t\t\t\t\t\t\t<tbody id=\"recodehist";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" style=\'visibility:hidden;display:none\'>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/EqivDiag.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\')\"><b>!</b></a></span>\n\t\t\t\t\t\t</td>\t<!-- Equalent Term Code,Remarks Images & Order Catalog  Images -->\n\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" ></td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"Status";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"></td>\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\')\">";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</a></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td><!-- Added On 12/14/2009 for SRR-CRF-303.1 -->\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td><!-- Added On 12/14/2009 for SRR-CRF-303.1 -->\n\n<!-- \t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n -->\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\t\t\n\t\t\t\t\t</table>\n\t</table>\n\t\t<input type=\'hidden\' name=\'temp_proc\' id=\'temp_proc\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t\t<input type=\'hidden\' name=\'temp_chk\' id=\'temp_chk\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t\t<input type=\'hidden\' name=\'procedure_yn\' id=\'procedure_yn\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'proc_code\' id=\'proc_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t<input type=\'hidden\' name=\'dflt_termset\' id=\'dflt_termset\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n\t\t<input type=\'hidden\' name=\'stage_no\' id=\'stage_no\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\t\t<input type=\'hidden\' name=\'final_proc_values\' id=\'final_proc_values\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n\t\t<input type=\'hidden\' name=\'active_proc_codes\' id=\'active_proc_codes\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n\t\t<input type=\'hidden\' name=\'Patient_Class\' id=\'Patient_Class\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n\t\t<input type=\'hidden\' name=\'allow_recode_diag_yn\' id=\'allow_recode_diag_yn\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n\t\t<input type=\'hidden\' name=\'allow_recode_proc_yn\' id=\'allow_recode_proc_yn\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n\t\t<input type=\'hidden\' name=\'proc_seq_no\' id=\'proc_seq_no\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\t\t<input type=\'hidden\' name=\'modify_temp_proc\' id=\'modify_temp_proc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'EncounterId\' id=\'EncounterId\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t\t<input type=\'hidden\' name=\'Pat_id\' id=\'Pat_id\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t<!-- Added On 12/12/2009 for SRR-CRF-303.1 -->\n\t\t<input type=\'hidden\' name=\'pat_visit_dt_time\' id=\'pat_visit_dt_time\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t<input type=\'hidden\' name=\'pat_disch_dt_time\' id=\'pat_disch_dt_time\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t<input type=\'hidden\' name=\'proc_term_set_cnt\' id=\'proc_term_set_cnt\' value=\"0\">\n\t\t\n\n\t\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tsetTimeout(\'disableButtons()\',200);\t\t\n//\t\t\t\t\t\t\t\t\tdisableButtons();\n\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t<script>\n\t\t\t\t\t//setTimeout(\'disable_confirmed_Buttons()\',200);\n//\t\t\t\t\tdisable_confirmed_Buttons()\n\t\t\t\t</script>\n\n\n\n\t</form>\n\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	public static String checkForEmpty(String inputString, String defaultValue)
	{
		return(((inputString=="") ) ? defaultValue : inputString);
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
 //String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
 //String loginUser		= (String) session.getValue( "login_user" );	
 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale = (String)session.getAttribute("LOCALE"); 

 String EncounterId = request.getParameter("EncounterId");
 String Pat_id = checkForNull(request.getParameter("Pat_id"));
 String mode = checkForNull(request.getParameter("mode"));
 String dflt_termset = checkForNull(request.getParameter("dflt_termset"));
 String temp_proc = checkForNull(request.getParameter("temp_proc"));
 String Patient_Class = checkForNull(request.getParameter("Patient_Class"));
 String stage_no = checkForNull(request.getParameter("stage_no"));  
 String cur_Sel=checkForNull(request.getParameter("sel_val"));

String allow_recode_diag_yn				= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn				= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
String allow_ot_proc_recode_yn			= checkForNull((String)session.getAttribute("allow_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String allow_non_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_non_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String drg_yn										= checkForNull((String)session.getAttribute("drg_calculation_yn"),"N");

 //String Pat_id = checkForNull(request.getParameter("Pat_id"));
 //String gender = checkForNull(request.getParameter("gender"));
// String age = checkForNull(request.getParameter("age"));
 //String dob = checkForNull(request.getParameter("dob"));
 //String spec_code = checkForNull(request.getParameter("spec_code"));
 //String DRGcal = checkForNull(request.getParameter("DRGcal"));
 //String drg_temp = checkForNull(request.getParameter("drg_temp"));
// String stage_l2 = checkForNull(request.getParameter("stage_l2"));
 //String sequenced_yn = checkForNull(request.getParameter("sequenced_yn"));
 //String tot_cnt = checkForNull(request.getParameter("tot_cnt"));
 //String recd_count="0";
 int Stage_no = 0;
 //int y=0;
//String chk_yn = "";

if(stage_no != "")
   Stage_no = Integer.parseInt(stage_no);

 if(mode.equals(""))
	mode="N";

if(cur_Sel.equals("")){
	cur_Sel=stage_no;
}

	Connection conn = null;	
	PreparedStatement pstmt			= null;
	PreparedStatement pstmt1		= null;
	PreparedStatement pstmt3		= null;
	CallableStatement main_cal_pstmt	=	null;
	ResultSet rs					= null;
	ResultSet rs1				= null;
	ResultSet rs3				= null;


try  {
	conn = ConnectionManager.getConnection(request);
	StringBuffer sql1 = new StringBuffer();
	String classValue = "";
	//String proc_set = "";
//	String proc_code = "";
//	String proc_desc = "";
	String coded_by = "";
	String coded_date = "";
	String causeDeath = "N";
	String recodeStatus = "";
	String stg_srl_no = "";
	//String hd_recodeStatus_disp = "";
	String patient_id = "";
	//String orig_term_set = "";
	//String orig_term_code = "";
	//String authorize_item = "";
	String p_episode_type = "";
	String temp_chk = "N";
	int equivalent_term_code_cnt = 0;
	//String nc_recodeStatus = "";
	//String nc_term_set = "";
	//String nc_term_code = "";
	//String nc_term_desc = "";
	//String nc_coded_by = "";
	//String nc_coded_date = "";
	//String nc_patient_id = "";
	//String nc_causeDeath = "N";
	String recodeStatus_desc="";
	String recodeStatus_desc_temp=""; // added by mujafar for ML-MMOH-CRF-1270
	//int nc_cnt=0;
	//String rev_flg="N";
	String group_YN="";
	String stage_seq_no="";
	//String tem_str="";
	String stage_no_disp="";
	String confirm_yn="";
	String chk_disable="";
	String Lock_all="";
	String values_fetched="";
	String final_proc_values="";
	String active_proc_codes="";
	String proc_trx_no="";



	int i = 0;
	int seq_no=0;
	//int cnt1 = 0;
	//int auth_cnt = 0;



	if(Patient_Class.equals("IP"))
		p_episode_type="I";
	else if(Patient_Class.equals("EM"))
		p_episode_type="E";
	else if(Patient_Class.equals("DC"))
		p_episode_type="D";
	else if(Patient_Class.equals("OP"))
		p_episode_type="O";

String hide_exp="";
String hide_dataTable="";
String p_proc_filter  ="";
String New_EncounterId="";
String  pat_visit_dt_time="";// Added On 12/11/2009
String  pat_disch_dt_time="";// Added On 12/11/2009


/*Note:Based upon the  allow_recode_diag_yn value(Parameter Setup) 
the perticular part is hiding to Display Only Procedure Part To User*/
	if(allow_recode_proc_yn.equals("Y")){
		hide_dataTable	=	"visible";
		New_EncounterId=EncounterId;//If allow_recode_proc_yn="Y"
	if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
		p_proc_filter ="B";
	}else if(allow_ot_proc_recode_yn.equals("Y")){
		p_proc_filter	="O";
	}else if(allow_non_ot_proc_recode_yn.equals("Y")){
		p_proc_filter	="N";
	}
}else{
		hide_dataTable	=	"hidden";
		New_EncounterId="";
	}
	if(allow_recode_diag_yn.equals("Y")){
		hide_exp	=	"visible";
	}else{
		hide_exp	=	"hidden";
	}

			/******Ends******/



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
            out.print( String.valueOf(hide_dataTable));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(hide_exp));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

	 		
			/*String New_EncounterId=EncounterId;//If allow_recode_proc_yn="Y";
			if(allow_recode_proc_yn.equals("N")){
				New_EncounterId="";
			} Note: The Commented Code was Implemented @@133 Line No:*/
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
			
				//sql1.append("SELECT A.PATIENT_ID,A.TERM_SET_ID,A.TERM_CODE, B.SHORT_DESC, am_get_desc.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1') practitioner_name, TO_CHAR (A.RECORDED_DATE_TIME, 'dd/mm/yy hh24:mi') RECORDED_DATE_TIME, 	A.CAUSE_OF_DEATH_YN FROM PR_DIAGNOSIS_ENC_DTL A,MR_TERM_CODE B WHERE A.FACILITY_ID = '"+p_facility_id+"' AND A.ENCOUNTER_ID = '"+EncounterId+"' AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE");
				String hdr_status ="";
				String L1_hdr_status = checkForNull(request.getParameter("L1_hdr_status"));
				String L2_hdr_status = checkForNull(request.getParameter("L2_hdr_status"));
				String L3_hdr_status = checkForNull(request.getParameter("L3_hdr_status"));
				String hdr_level			= checkForNull(request.getParameter("curr_level"));;
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

//				sql1.append("WITH tmp AS (SELECT patient_id, orig_proc_code_scheme, orig_proc_code,decode(laterality_ind,'L','Left','R','Right','B','Both','N','Not Applicable') laterality_ind ,proc_code_scheme, proc_code, practitioner_id, proc_date, recode_status,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn, active_yn,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,REMARKS  FROM mr_procedure_recoding_dtl WHERE facility_id = '"+p_facility_id+"' AND encounter_id = '"+New_EncounterId+"' AND stage_no  <= "+cur_Sel+") SELECT a.patient_id, a.orig_proc_code_scheme, a.orig_proc_code, a.proc_code_scheme, a.proc_code,b.short_desc, am_get_desc.am_practitioner(practitioner_id, 'en', '1') practitioner_name,TO_CHAR(a.proc_date, 'dd/mm/yy hh24:mi') recorded_date_time,a.recode_status,DECODE(a.recode_status, 'O', 'Review', 'N', 'NewCode', 'R', 'Recoded') recodestatus_desc,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn,a.laterality_ind,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,a.remarks  FROM tmp a, mr_term_code b WHERE a.proc_code_scheme = b.term_set_id AND a.proc_code = b.term_code AND recode_status NOT IN('E', 'F') AND active_yn = 'Y' AND (stage_srl_no) NOT IN( SELECT m1.stage_srl_no FROM (SELECT proc_code, stage_srl_no FROM tmp WHERE active_yn = 'Y') m1, (SELECT proc_code, stage_srl_no FROM tmp WHERE active_yn = 'N' or confirm_yn = 'Y') m2 WHERE m1.proc_code = m2.proc_code AND m1.stage_srl_no < m2.stage_srl_no) ");

				//sql1.append("WITH tmp AS (SELECT patient_id, orig_proc_code_scheme, orig_proc_code, decode(laterality_ind,'L','Left','R','Right','B','Both','N','Not Applicable') laterality_ind, proc_code_scheme, proc_code, practitioner_id,proc_date, recode_status, stage_srl_no, stage_seq_no, group_yn,stage_no, confirm_yn, active_yn,NVL (group_seq_no, '0') group_seq_no, sequenced_yn, trx_no  FROM mr_procedure_recoding_dtl  WHERE facility_id = '"+p_facility_id+"'  AND encounter_id = '"+EncounterId+"' AND stage_no <= "+cur_Sel+" )SELECT a.patient_id, a.orig_proc_code_scheme, a.orig_proc_code, a.proc_code_scheme, a.proc_code, b.short_desc,a.active_yn, am_get_desc.am_practitioner (practitioner_id,'en','1') practitioner_name,practitioner_id,TO_CHAR (a.proc_date, 'dd/mm/yy hh24:mi') recorded_date_time,a.recode_status,DECODE (a.recode_status,'O', 'Review','N', 'NewCode','R', 'Recoded') recodestatus_desc,       stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn,a.laterality_ind, NVL (group_seq_no, '0') group_seq_no, sequenced_yn,       trx_no FROM tmp a, mr_term_code b WHERE a.proc_code_scheme = b.term_set_id  AND a.proc_code = b.term_code AND recode_status NOT IN ('E', 'F') AND active_yn = 'Y' AND (stage_srl_no) NOT IN ( SELECT m1.stage_srl_no FROM (SELECT proc_code, stage_srl_no,recode_status             FROM tmp WHERE active_yn = 'Y' order by stage_srl_no) m1 WHERE m1.stage_srl_no < (select max(stage_srl_no) from tmp where proc_code = m1.proc_code and active_yn = 'N' OR confirm_yn = 'Y') AND m1.recode_status !='O') ");
					String out_srl_no="";
					main_cal_pstmt = conn.prepareCall("{call MR_TERM_RECODE.GET_ACTIVE_CODES(?, ?, ?, ?, ?,?,?)}");
					main_cal_pstmt.setString( 1, "MR_PROCEDURE_RECODING_DTL");//Table Name
					main_cal_pstmt.setString( 2, p_facility_id);//Facility_ID
					main_cal_pstmt.setString( 3, New_EncounterId);//Encounter_ID
					main_cal_pstmt.setString( 4, cur_Sel);//Encounter_ID
					main_cal_pstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					main_cal_pstmt.setString( 6, ",");//Separator
					main_cal_pstmt.setString( 7, p_proc_filter);//Procedure OT And Non OT Value 
					main_cal_pstmt.execute();
					out_srl_no=main_cal_pstmt.getString(5);
//					StringTokenizer his_out_srl_no	= new StringTokenizer(out_srl_no,",");
				
					sql1.append("SELECT a.patient_id, a.orig_proc_code_scheme, a.orig_proc_code, a.proc_code_scheme, a.proc_code, mr_get_desc.mr_term_code(a.proc_code_scheme,a.proc_code,'"+locale+"','2') short_desc,b.long_desc,a.active_yn, am_get_desc.am_practitioner (practitioner_id,'"+locale+"','1') practitioner_name,practitioner_id,TO_CHAR (a.proc_date, 'dd/mm/yyyy hh24:mi') recorded_date_time,a.recode_status,DECODE (a.recode_status,'O', 'Review','N', 'NewCode','R', 'Recoded') recodestatus_desc,       a.stage_srl_no, a.stage_seq_no,a. group_yn, a.stage_no, a.confirm_yn,decode(a.laterality_ind,'L','Left','R','Right','B','Both','N','NotApplicable') desc_laterality_ind,laterality_ind, NVL (a.group_seq_no, '0') group_seq_no, a.sequenced_yn,a.remarks,a.trx_no,a.contr_mod_id,to_char(a.proc_checkin_start_date_time,'dd/mm/yyyy hh24:mi')proc_checkin_start_date_time,to_char(a.proc_checkout_end_date_time,'dd/mm/yyyy hh24:mi')proc_checkout_end_date_time,to_char(c.visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time,to_char(c.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time,( SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct WHERE mct.TERM_SET_ID = a.proc_code_scheme AND mct.term_code = a.proc_code AND mct.CROSS_REF_TYPE = 'EQ')equiv_count,a.ACCESSION_NUM ,a.CODE_EXTN_YN,a.CODE_EXTN_DTL FROM mr_procedure_recoding_dtl a, mr_term_code b,pr_encounter c WHERE a.proc_code_scheme = b.term_set_id  AND a.proc_code = b.term_code AND a.facility_id = '"+p_facility_id+"'  AND a.encounter_id = '"+EncounterId+"' AND a.encounter_id=c.encounter_id AND a.stage_no <= "+cur_Sel+" and a.stage_srl_no in ("+out_srl_no+") " );
					
					//recode_status NOT IN ('E', 'F') AND active_yn = 'Y' AND (stage_srl_no) NOT IN ( SELECT m1.stage_srl_no FROM (SELECT proc_code, stage_srl_no,recode_status             FROM tmp WHERE active_yn = 'Y' order by stage_srl_no) m1 WHERE m1.stage_srl_no < (select max(stage_srl_no) from tmp where proc_code = m1.proc_code and active_yn = 'N' OR confirm_yn = 'Y') AND m1.recode_status !='O') ");

					//WITH tmp AS (SELECT patient_id, orig_proc_code_scheme, orig_proc_code, decode(laterality_ind,'L','Left','R','Right','B','Both','N','Not Applicable') laterality_ind, proc_code_scheme, proc_code, practitioner_id,proc_date, recode_status, stage_srl_no, stage_seq_no, group_yn,stage_no, confirm_yn, active_yn,NVL (group_seq_no, '0') group_seq_no, sequenced_yn, trx_no  FROM mr_procedure_recoding_dtl  WHERE facility_id = '"+p_facility_id+"'  AND encounter_id = '"+EncounterId+"' AND stage_no <= "+cur_Sel+" )
			
					if(cur_Sel.equals("1") && L1_hdr_status.equals("A") || cur_Sel.equals("2") && L2_hdr_status.equals("A") || cur_Sel.equals("3") && L3_hdr_status.equals("A")){
						sql1.append("order by TRX_NO");
					}else{
						sql1.append("order by a.contr_mod_id desc");
					}
					pstmt = conn.prepareStatement(sql1.toString());
					rs = pstmt.executeQuery();	

				String old_trm_cd					="";
				String diag_level_prc				="";
				String srl_no_prc					="";
				String orig_term_code_old	="";
				String  proc_code_scheme	="";
				String  proc_code					="";
				String  proc_desc					="";
				String  orig_proc_code_scheme="";
				String  orig_proc_code			="";
				String  laterality_ind				="";
				String Group_seq_no			="";
				String seq_yn						="";
				String grp_trm_cd					="";
				String remarks						="";
				String contr_mod_id				="";// Added On 7/8/2009
				String show_eq_tmcd			="";
				String show_remarks			="";
				String proc_type					="";// Added On 7/8/2009
				String  accession_num			="";// Added On 7/8/2009
				String  code_extn_yn			="";// Added On 7/8/2009
				String  code_extn_dtl			="";// Added On 7/8/2009
				String show_accesion			="";// Added On 7/8/2009
//				boolean disp_ot=false;// Added On 7/8/2009
				String  db_accession_num		="";// Added On 7/10/2009
				String  db_code_extn_dtl		="";// Added On 7/10/2009
				String  db_laterality_ind		="";// Added On 12/12/2009.
				String  proc_srt_dt_time	="";// Added On 12/12/2009.
				String  proc_end_dt_time		="";// Added On 12/12/2009.
				String  db_proc_srt_dt_time			="";// Added On 12/14/2009.
				String  db_proc_end_dt_time		="";// Added On 12/14/2009.
				String  code_laterality_ind		="";// Added On 12/14/2009.
			String  remark_lbl	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisRemarks.label","mr_labels"); // modified by mujafar for ML-MMOH-CRF-1270
				String  eqvi_code_lbl			=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels");
				String  order_cat_lbl				=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ordercatalog.label","common_labels");
				while(rs.next()){
					String  latind_lbl			="";
					String long_desc			= "";// Added For Site Enhancement On 3/11/2010
					String long_desc_params	= "";// Added For Site Enhancement On 3/11/2010
					String display_long_desc	= "none";// Added For Site Enhancement On 3/11/2010
					boolean modify_proc	=	true;// Added On 7/8/2009
					patient_id						= checkForNull(rs.getString("patient_id"));
					proc_code_scheme		= checkForNull(rs.getString("proc_code_scheme"));
					proc_code					= checkForNull(rs.getString("proc_code"));
					proc_desc					= checkForNull(rs.getString("SHORT_DESC"));
					coded_date					= checkForNull(rs.getString("recorded_date_time"));
					coded_date					=DateUtils.convertDate(coded_date,"DMYHM" ,"en",locale);
					coded_by						= checkForNull(rs.getString("practitioner_name"));
					orig_proc_code_scheme	=checkForNull(rs.getString("orig_proc_code_scheme"));
					orig_proc_code				= checkForNull(rs.getString("orig_proc_code"));
					recodeStatus						= checkForNull(rs.getString("recode_status"));
					stg_srl_no							= checkForNull(rs.getString("stage_srl_no"));
					recodeStatus_desc			= checkForNull(rs.getString("recodeStatus_desc"));
					group_YN							= checkForNull(rs.getString("group_YN"));
					stage_seq_no					=checkForNull(rs.getString("stage_seq_no"));
					stage_no_disp					=checkForNull(rs.getString("stage_no"));
					confirm_yn						=checkForNull(rs.getString("confirm_yn"));
					laterality_ind						= checkForNull(rs.getString("desc_laterality_ind"));
					code_laterality_ind			= checkForNull(rs.getString("laterality_ind"));
					Group_seq_no					= checkForNull(rs.getString("group_seq_no"));
					seq_yn								=checkForNull(rs.getString("SEQUENCED_YN"));
					remarks							=checkForNull(rs.getString("REMARKS"));
					contr_mod_id					=checkForNull(rs.getString("contr_mod_id"),"XT");//When contr_mod_id  is Empty(Null). XT is The Default Value Of  contr_mod_id. For Tokenizing Purpose. Added On 7/8/2009;
					pat_visit_dt_time				= checkForNull(rs.getString("visit_adm_date_time"));//Added On 12/14/2009 for SRR-CRF-303.1
					pat_disch_dt_time			= checkForNull(rs.getString("discharge_date_time"));//Added On 12/14/2009 for SRR-CRF-303.1
					proc_srt_dt_time				= checkForNull(rs.getString("proc_checkin_start_date_time"));
					proc_srt_dt_time				= DateUtils.convertDate(proc_srt_dt_time,"DMYHM" ,"en",locale);//Date conversion to Thai
					proc_end_dt_time			= checkForNull(rs.getString("proc_checkout_end_date_time"));
					proc_end_dt_time			= DateUtils.convertDate(proc_end_dt_time,"DMYHM" ,"en",locale);//Date conversion to Thai
					proc_trx_no						= checkForNull(rs.getString("trx_no")); // added on 23 Jan 2010
					long_desc							= checkForNull(rs.getString("long_desc")); // added on 23 Jan 2010

					equivalent_term_code_cnt	=	rs.getInt("equiv_count");
					accession_num	= checkForNull(rs.getString("ACCESSION_NUM"));//Default For Tokenizing 
					code_extn_yn	= checkForNull(rs.getString("CODE_EXTN_YN"));
					code_extn_dtl	= checkForNull(rs.getString("CODE_EXTN_DTL"));//Default For Tokenizing


						if(recodeStatus.equals("N")){
							recodeStatus_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.newcode.label","mr_labels");//NewCode;
						}else if(recodeStatus.equals("O")){
							recodeStatus_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//For Original Code;
						}else if(recodeStatus.equals("R")){
							recodeStatus_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.recoded.label","mr_labels");//"Recoded";
						}
						if(laterality_ind.equals("Left")){
							latind_lbl				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
						}else if(laterality_ind.equals("Right")){
							latind_lbl				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
						}else if(laterality_ind.equals("Both")){
							latind_lbl				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
						}else if(laterality_ind.equals("NotApplicable")){
							latind_lbl				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						}
					if(group_YN.equals("Y")){// added for level 2 handling
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){// added for level 2 handling
							if(!grp_trm_cd.equals(proc_code)){
								grp_trm_cd=proc_code;
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
						
					}
					*/

					/*----------------------*/
					if(cur_Sel.equals("1")){
						if(L1_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
							chk_disable				= "disabled";
							modify_proc				= false;
						}
						if(L1_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
							chk_disable				= "disabled";
							modify_proc				= false;
						}
						hdr_status=L1_hdr_status; //Added On 7/1/2009

					}else if(cur_Sel.equals("2")){
						if(L2_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Completed";
							chk_disable				= "disabled";
							modify_proc				= false;

						}
						if(L2_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
							chk_disable				= "disabled";
							modify_proc				= false;

						}
						hdr_status=L2_hdr_status; //Added On 7/1/2009
					}else if(cur_Sel.equals("3")){
						if(L3_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
							chk_disable				= "disabled";
							modify_proc				= false;

						}
						if(L3_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");
							chk_disable				= "disabled";
							modify_proc				= false;

						}
						hdr_status	= L3_hdr_status; //Added On 7/1/2009
					}

				/*	if(stage_no.equals("1")){
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
						
					}else if(stage_no.equals("3")){
						hdr_status=L3_hdr_status;
						
					}*/

					//out.println("hdr_status" + hdr_status);

					if(!hdr_status.equals("C") ){
						if(!hdr_status.equals("A") ){
							if(confirm_yn.equals("Y")){
								if(Integer.parseInt(cur_Sel)==Integer.parseInt(stage_no_disp)){
									chk_disable			 =	"disabled";
//									recodeStatus_desc="Confirmed";
									recodeStatus_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confirmed";
									modify_proc	 = false;
									if(Integer.parseInt(cur_Sel)<Integer.parseInt(stage_no)){
										if(cur_Sel.equals("1") && L1_hdr_status.equals("C")){
											recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("1")&& L1_hdr_status.equals("A")){
											recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("2")&& L2_hdr_status.equals("C")){
											recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("2")&& L2_hdr_status.equals("A")){
											recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Confirmed";
										}
									}
								}
							}else{
								chk_disable	=	"";
							}
						}
					}
					// for auth carryover.
					if(stage_no.equals(cur_Sel)){
						if(stage_no.equals("2")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P")){
									chk_disable				=	"disabled";
									modify_proc				=	false;
									recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L1_hdr_status;
							}
						}
						if(stage_no.equals("3")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
								chk_disable				=	"disabled";
								modify_proc				= false;
								recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
								hdr_status				= L1_hdr_status;

							}

							if(L2_hdr_status.equals("A") && L3_hdr_status.equals("P")){
								chk_disable				= "disabled";
								modify_proc				= false;
								recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
								hdr_status				= L2_hdr_status;

							}

						}
					}else{
						if(cur_Sel.equals("2")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
								chk_disable				= "disabled";
									modify_proc			= false;
								recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
								hdr_status				= L1_hdr_status;

							}
					}
				}/*Added On 8/18/2009 for J.Mail*/
					// for auth carryover.
						//String sqlicd	=	"SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID = '"+proc_code_scheme+"' AND term_code = '"+proc_code+"' AND CROSS_REF_TYPE = 'EQ'";
						//pstmt1			= conn.prepareStatement(sqlicd);
						//rs1				= pstmt1.executeQuery();	
						//while(rs1.next()){
								//equivalent_term_code_cnt	=	rs1.getInt("COUNT");
						//}
					//if(pstmt1 != null) pstmt1.close();
					//if(rs1 != null) rs1.close();
	/*Based Upon the Count and Remarks The Respective Images will Visible or Hidden*/
					if(equivalent_term_code_cnt!=0){
						show_eq_tmcd="visible";
					}else{
						show_eq_tmcd="hidden";
					}
					if(!remarks.equals("")){
						show_remarks	="visible";
					}else{
						show_remarks	="hidden";
					}
/***Ends**/
/*To Display the Type of  Procedure is wheather the Procedure is OT OR Non OT  */
			if(contr_mod_id.equals("OT") ){
				proc_type	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OT.label","mr_labels");
			}else{
				proc_type	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NonOT.label","mr_labels");
			}
/*Ends*/
/*To Display ACCESSION_NUM ,CODE_EXTN_YN, CODE_EXTN_DTL for each Line Items */
		/*String sql_dtl_cols="Select ACCESSION_NUM ,CODE_EXTN_YN, CODE_EXTN_DTL from MR_PROCEDURE_RECODING_DTL where   proc_code = '"+proc_code+"'  and  stage_srl_no ='"+stg_srl_no+"' and encounter_id='"+EncounterId+"' and facility_id='"+p_facility_id+"'";
		pstmt1 = conn.prepareStatement(sql_dtl_cols);
		rs1	 = pstmt1.executeQuery();	
		while(rs1.next()){
			accession_num	= checkForNull(rs1.getString("ACCESSION_NUM"));//Default For Tokenizing 
			code_extn_yn	= checkForNull(rs1.getString("CODE_EXTN_YN"));
			code_extn_dtl	= checkForNull(rs1.getString("CODE_EXTN_DTL"));//Default For Tokenizing
		}
		*/
	if(pstmt1 != null) pstmt1.close();
	if(rs1 != null) rs1.close();
	if(!accession_num.equals("")){
		if(contr_mod_id.equals("OT")){
//			db_accession_num=accession_num.replace("$","||");
			show_accesion	 ="visible";
		}else if(contr_mod_id.equals("RD")){
//			db_accession_num=accession_num.replace("$","||");
			show_accesion	 ="visible";
		}else if(contr_mod_id.equals("OR")){
//			db_accession_num=accession_num.replace("$","||");
			show_accesion	 ="visible";
		}else{
			show_accesion	 ="hidden";
		}
	}else{
		show_accesion	 ="hidden";
		db_accession_num="00";
	}
//	if(code_extn_yn.equals("N")){
		/*if(contr_mod_id.equals("OT")){
			db_code_extn_dtl=code_extn_dtl;
			/*if(code_extn_dtl.equals("01")){
				code_extn_dtl="";			
			}
			disp_ot	= true;
		/*}else{
			db_code_extn_dtl=code_extn_dtl;
			code_extn_dtl	 ="";
			disp_ot		= false;
		}*/
	/*}else{
		db_code_extn_dtl=code_extn_dtl;
		code_extn_dtl	="";
	}*/
	/*F.Y.I
		Passing the values to Recoding screen for defaulting the respective values
	*/
	db_code_extn_dtl		= checkForEmpty(code_extn_dtl,"01");
	db_laterality_ind			= checkForEmpty(code_laterality_ind,"01");
	db_proc_srt_dt_time	= checkForEmpty(proc_srt_dt_time,"01");
	db_proc_end_dt_time	=checkForEmpty(proc_end_dt_time,"01");
	/*db_code_extn_dtl	= code_extn_dtl;
	db_laterality_ind		= laterality_ind;

	if(db_code_extn_dtl.equals("")){
		db_code_extn_dtl	=	"01";
	}
	if(db_laterality_ind.equals("")){
		db_laterality_ind	=	"01";
	}
	if(db_proc_srt_dt_time.equals("")){
		db_proc_srt_dt_time	=	"01";
	}
	if(db_proc_end_dt_time.equals("")){
		db_proc_end_dt_time	=	"01";
	}*/
/***Ends***/
/*To Display Long Desc */
	if(!(proc_desc.equals(long_desc))){
		display_long_desc ="inline";
		long_desc_params =proc_code+","+proc_code_scheme;
	}
/*Ends*/

					if(group_YN.equals("X")){
						if(orig_term_code_old.equals("")){
							values_fetched=orig_proc_code+","+proc_code;
							orig_term_code_old=orig_proc_code;
							//classValue="recodeDataY1";
						}else{
							if(orig_term_code_old.equals(orig_proc_code)){
								values_fetched=values_fetched+","+proc_code;
								//classValue="recodeDataY1";
							}else{
								values_fetched=values_fetched+"~"+orig_proc_code+","+proc_code;
								orig_term_code_old=orig_proc_code;
								//classValue="recodeDataY1";
							}
							
						}

					}

					if(Integer.parseInt(hdr_level)>Integer.parseInt(cur_Sel) || Integer.parseInt(stage_no)>Integer.parseInt(cur_Sel) ){ // added for level 2 handling
						chk_disable="disabled";
						Lock_all="Y";
						
					}
//					String  equvi_lbl=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
//					String tmcode_srl_no=his_out_srl_no.nextToken();
					if(recodeStatus.equals("R")){  // recoded records
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){ // added for level 2 handling
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//"Review";
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Review";
							}
							final_proc_values=final_proc_values+i+"$"+proc_code+"$"+proc_code_scheme+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_proc_code+"$"+Group_seq_no+"$"+confirm_yn+"~";

							active_proc_codes=active_proc_codes+proc_code_scheme+"$"+proc_code+"~";
							
							
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){ 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(proc_trx_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
seq_no++;
								}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(show_eq_tmcd));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(eqvi_code_lbl));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(show_remarks));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(remark_lbl));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(show_accesion));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_cat_lbl));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recodeStatus_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(orig_proc_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(code_extn_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_code_extn_dtl));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_laterality_ind));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_proc_srt_dt_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_proc_end_dt_time));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block54Bytes, _wl_block54);

								if(recodeStatus_desc.equals("Recoded"))
								{ // added by mujafar for ML-MMOH-CRF-1270
										recodeStatus_desc_temp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Coded.label","mr_labels");
								}
								else
								{
									recodeStatus_desc_temp = recodeStatus_desc;
								}
							
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recodeStatus_desc_temp));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block59Bytes, _wl_block59);
if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel)  && modify_proc){
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(code_extn_dtl));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(laterality_ind));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(pat_visit_dt_time));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(pat_disch_dt_time));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( proc_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( proc_type));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(code_extn_dtl));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(coded_by));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(coded_date));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(latind_lbl));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(proc_srt_dt_time));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(proc_end_dt_time));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(causeDeath));
            _bw.write(_wl_block77Bytes, _wl_block77);

						}else{

								if(!old_trm_cd.equals(proc_code)){
//									out.println("term_code"+ proc_code +"group_YN"+group_YN);
									if(group_YN.equals("Y")){
										classValue="recodeData";
									}else{
										classValue="gridData";
									}	

									final_proc_values=final_proc_values+i+"$"+proc_code+"$"+proc_code_scheme+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_proc_code+"$"+Group_seq_no+"$"+confirm_yn+"~";
									active_proc_codes=active_proc_codes+proc_code_scheme+"$"+proc_code+"~";
									
									
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block80Bytes, _wl_block80);
if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(proc_trx_no));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block83Bytes, _wl_block83);
seq_no++;
											}else{
											if(!seq_yn.equals("H")){
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
  }
										}
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(show_eq_tmcd));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(eqvi_code_lbl));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(show_remarks));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(remark_lbl));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(show_accesion));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_cat_lbl));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recodeStatus_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(orig_proc_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(code_extn_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_code_extn_dtl));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_laterality_ind));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_proc_srt_dt_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_proc_end_dt_time));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block91Bytes, _wl_block91);

								if(recodeStatus_desc.equals("Recoded"))
								{ // added by mujafar for ML-MMOH-CRF-1270
										recodeStatus_desc_temp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Coded.label","mr_labels");
								}
								else
								{
									recodeStatus_desc_temp = recodeStatus_desc;
								}
							
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recodeStatus_desc_temp));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block94Bytes, _wl_block94);
if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel)  && modify_proc){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(code_extn_dtl));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(laterality_ind));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(pat_visit_dt_time));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(pat_disch_dt_time));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
}else{
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( proc_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( proc_type));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(code_extn_dtl));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(coded_by));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(coded_date));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(latind_lbl));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(proc_srt_dt_time));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(proc_end_dt_time));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(causeDeath));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);

											String term_chain="";
											String Srl_chain="";
											try{
												CallableStatement cal_pstmt	=	null;
												cal_pstmt = conn.prepareCall("{call MR_TERM_RECODE.RECODE_NODE(?,?,?,?,?,?,?,?,?)}");
												cal_pstmt.setString( 1, "MR_PROCEDURE_RECODING_DTL");//Table
												cal_pstmt.setString( 2, p_facility_id);//p_facility_id
												cal_pstmt.setString( 3, EncounterId);//Encounter_ID
												cal_pstmt.setString( 4, proc_code_scheme);//proc_code_scheme Added On 8/3/2009
												cal_pstmt.setString( 5, proc_code);//proc_Code
												cal_pstmt.setString( 6, cur_Sel);//stage no
												cal_pstmt.setString( 7, stg_srl_no);//term_code_stage_srl_no which will be getting from the main Query.
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

					/*Outer While:*/	while(stk_trm_chn.hasMoreTokens()){


										StringTokenizer st_trm=new StringTokenizer(stk_trm_chn.nextToken(),",");
										StringTokenizer st_trm_srl=new StringTokenizer(stk_srl_chn.nextToken(),",");
//										out.println("<table width='100%' cellpadding=0 cellspacing=0 border=1>");
										hist_disp="";

										while(st_trm.hasMoreTokens()){

												String old_diaglevel	= "";
												int ijk=0;
												//while(rs1.next()){
													//diag_level_prc= stk_trm_chn.nextToken();
													diag_level_prc	= st_trm.nextToken();
													//diag_level_prc=diag_level_prc.substring(0,diag_level_prc.length()-1);
													//srl_no_prc= stk_srl_chn.nextToken();
													srl_no_prc		= st_trm_srl.nextToken();
													//srl_no_prc=srl_no_prc.substring(0,srl_no_prc.length()-1);	
												

													String sql_hist_det="SELECT a.orig_proc_code_scheme,a.ORIG_PROC_CODE, a.proc_code_scheme, a.PROC_CODE,mr_get_desc.mr_term_code(a.proc_code_scheme,a.proc_code,'"+locale+"','2') short_desc,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,       TO_CHAR(a.PROC_DATE, 'dd/mm/yyyy hh24:mi') recorded_date_time, a.recode_status,decode(a.recode_status,'O','Review','N','Review','R','Review')recodeStatus_desc,  STAGE_SRL_NO,stage_seq_no,group_YN, decode(a.laterality_ind,'L','Left','R','Right','B','Both','N','NotApplicable') laterality_ind,a.contr_mod_id proc_type FROM MR_PROCEDURE_RECODING_DTL a, mr_term_code b WHERE a.facility_id = '"+p_facility_id+"'   AND a.encounter_id = '"+EncounterId+"' and a.proc_code in("+diag_level_prc+") and stage_srl_no in ("+srl_no_prc+") and a.active_YN='N'  AND a.proc_code_scheme = b.term_set_id AND a.proc_code = b.term_code order by orig_proc_code_scheme ,stage_srl_no desc";

													pstmt3 = conn.prepareStatement(sql_hist_det);
													rs3 = pstmt3.executeQuery();	
													String tmp_cd						= "";
													String proce_type_his			= "";
													String proce_type_lbl			= "";
													String latdind_his					= "";
													String recorded_date_time	="";
													//String proc_st_dt_time_his	 ="21/10/2005 16:19";
													//String proc_end_dt_time_his	 ="21/10/2005 20:19";

													
													while(rs3.next()){
														String latdind_his_lbl	 = "";
														tmp_cd						= rs3.getString("PROC_CODE");
														proce_type_his			= checkForNull(rs3.getString("proc_type"));
														latdind_his				= checkForNull(rs3.getString("laterality_ind"));
														 recorded_date_time	= checkForNull(rs3.getString("recorded_date_time"));
														recorded_date_time		= DateUtils.convertDate(recorded_date_time,"DMYHM" ,"en",locale);

														int diag_len	=diag_level_prc.indexOf(",");
														if(group_YN.equals("X")){
															if(diag_len>0){
																if(old_diaglevel.equals("")){
																	ijk++;
																	old_diaglevel	= diag_level_prc;
																}
																if(!diag_level_prc.equals(old_diaglevel)){
																	ijk++;
																	old_diaglevel	= diag_level_prc;
																}
																if ( ijk % 2 == 0 ){
																}else{
																}
															}

														}
													if(proce_type_his.equals("OT")){
														proce_type_lbl	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OT.label","mr_labels");
													}else{
														proce_type_lbl	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NonOT.label","mr_labels");
												}
													if(latdind_his.equals("Left")){
														latdind_his_lbl	  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
													}else if(latdind_his.equals("Right")){
														latdind_his_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
													}else if(latdind_his.equals("Both")){
														latdind_his_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
													}else if(latdind_his.equals("NotApplicable")){
														latdind_his_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
													}
														if ( ikk % 2 == 0 ){
															hist_disp=hist_disp+"<tr><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' align='left' wrap ><b>"+checkForNull(rs3.getString("proc_code_scheme"))+"</b>&nbsp;/&nbsp;<b>"+checkForNull(rs3.getString("proc_code"))+"</b></td><td class='"+classValue+"' wrap align='left'><b>"+checkForNull(rs3.getString("short_desc"))+"</b></td><td class='"+classValue+"' wrap ><b>"+proce_type_lbl+"</b></td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' nowrap ><b>"+checkForNull(rs3.getString("practitioner_name"))+"</b></td><td  class='"+classValue+"' nowrap ><b>"+recorded_date_time+"</b></td><td class='"+classValue+"' wrap ><b>&nbsp;</b></td><td  class='"+classValue+"' wrap ><b>&nbsp;</b></td><td class='"+classValue+"' wrap ><b>&nbsp;</b></td></tr>";
														}else{
															hist_disp=hist_disp+"<tr><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap  width='30px'>&nbsp;&nbsp;&nbsp;&nbsp;</td><td class='"+classValue+"' align='left' wrap >"+checkForNull(rs3.getString("proc_code_scheme"))+"&nbsp;/&nbsp;"+checkForNull(rs3.getString("proc_code"))+"</td><td class='"+classValue+"' wrap align='left'>"+checkForNull(rs3.getString("short_desc"))+"</td><td class='"+classValue+"' wrap >"+proce_type_lbl+"</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' nowrap>"+checkForNull(rs3.getString("practitioner_name"))+"</td><td  class='"+classValue+"' nowrap>"+recorded_date_time+"</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td></tr>";
														}
													}
													/*Error Record To be Displayed */
											}// innner loop
											ikk++;
											out.println(hist_disp);
//											out.println("</table>");
										}// outer loop
										
            _bw.write(_wl_block105Bytes, _wl_block105);

											old_trm_cd=proc_code;
											classValue="gridData";
							}
					}
				}else{ // only original or new code
						
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){  // added for level 2 handling
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//"Review";
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Review";
							}
						}

						if(hdr_status.equals("A")){
							chk_disable="disabled";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
						}else if(hdr_status.equals("C")){
							chk_disable="disabled";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Completed";
						}
							
						final_proc_values=final_proc_values+i+"$"+proc_code+"$"+proc_code_scheme+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_proc_code+"$"+Group_seq_no+"$"+confirm_yn+"~";
						active_proc_codes=active_proc_codes+proc_code_scheme+"$"+proc_code+"~";
					
						
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(proc_trx_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
seq_no++;
							}
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(show_eq_tmcd));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(eqvi_code_lbl));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(show_remarks));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(remark_lbl));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(show_accesion));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_cat_lbl));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recodeStatus_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(stg_srl_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(orig_proc_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(code_extn_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_code_extn_dtl));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_laterality_ind));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_proc_srt_dt_time));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(db_proc_end_dt_time));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(chk_disable));
            _bw.write(_wl_block110Bytes, _wl_block110);

								if(recodeStatus_desc.equals("Recoded"))
								{ // added by mujafar for ML-MMOH-CRF-1270
										recodeStatus_desc_temp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Coded.label","mr_labels");
								}
								else
								{
									recodeStatus_desc_temp = recodeStatus_desc;
								}
							
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recodeStatus_desc_temp));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recodeStatus));
            _bw.write(_wl_block113Bytes, _wl_block113);
if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel) && modify_proc){
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(code_extn_dtl));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(laterality_ind));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(pat_visit_dt_time));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(pat_disch_dt_time));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block115Bytes, _wl_block115);
}else{
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
}
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( proc_desc));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( proc_type));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(code_extn_dtl));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(coded_by));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(coded_date));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(latind_lbl));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(proc_srt_dt_time));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(proc_end_dt_time));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(causeDeath));
            _bw.write(_wl_block121Bytes, _wl_block121);

						
					}
					i++;
			}//While Loop
			 if(main_cal_pstmt!=null)main_cal_pstmt.close();
			 if(rs!=null)rs.close();

		}
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(temp_proc));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(temp_chk));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(stage_no));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(final_proc_values));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(active_proc_codes));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(Patient_Class));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(allow_recode_diag_yn));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(allow_recode_proc_yn));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(pat_visit_dt_time));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(pat_disch_dt_time));
            _bw.write(_wl_block137Bytes, _wl_block137);
if(Lock_all.equals("Y")){
            _bw.write(_wl_block138Bytes, _wl_block138);
}
            _bw.write(_wl_block139Bytes, _wl_block139);

}catch(Exception e){
	e.printStackTrace();
 }finally{
		 if(main_cal_pstmt!=null)main_cal_pstmt.close();
		 if(rs!=null)rs.close();
		ConnectionManager.returnConnection(conn,request);

 }
            _bw.write(_wl_block140Bytes, _wl_block140);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Select.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSet.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ext.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CodedBy.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Laterality.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startdatetime.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddatetime.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CausedDeath.label", java.lang.String .class,"key"));
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
}
