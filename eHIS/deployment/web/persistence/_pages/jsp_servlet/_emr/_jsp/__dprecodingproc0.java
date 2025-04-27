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

public final class __dprecodingproc0 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingProc0.jsp", 1709118910938L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script> \n\t<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\t\tfunction expandProcedure()\n\t\t{\n//\t\t\tparent.RecodeScreen.rows=\"10%,80%,*\";\n\t\t\tparent.RecodeScreen.rows=\"14%,85%,5%,0%\";\n\t\t\teval(\"parent.frames[2].document.RecodeDiagnosisDiagDetail.all.Diag_icon\").innerHTML=\"<a href=\'javascript:onclick=expandDiagnosis()\'>+</a>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.Proc_icon\").innerHTML=\"<a href=\'javascript:onclick=collapseProcedure()\'>-</a>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t//all.diagTable.visibility);\n\t\t\t//diagTable\n\t\t}\n\n\t\tfunction collapseProcedure()\n\t\t{\n//\t\t\tparent.RecodeScreen.rows=\"40%,40%,*\";\n\t\t\tparent.RecodeScreen.rows=\"48%,48%,4%,0%\";\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.Proc_icon\").innerHTML=\"<a href=\'javascript:onclick=expandProcedure()\'>+</a>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\n\t\t}\n\n\n\t\tfunction showDiag()\n\t\t{\n\t\t\t//if(mode.equals(\"Y\"))\n\t\t\t\t//parent.frames[2].document.RecodeDiagnosisProcDetail.diagTable.visiblity=\'visible\';\n\n\t\t}\n\t\t\n\t\tfunction expandRecode(i)\n\t\t{\n\t\t\t//alert(\"expandRecode \"+i);\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1\"+i).style.visibility=\'visible\';\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1\"+i).style.display=\'inline\';\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol\"+i).innerHTML=\"<a href=\'javascript:onclick=collapseRecode(\"+i+\")\'>-</a>\";\n\t\t}\n\n\t\tfunction collapseRecode(i)\n\t\t{\n\t\t\t//alert(\"collapseRecode \"+i);\n\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1\"+i).style.visibility=\'hidden\';\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1\"+i).style.display=\'none\';\n\t\t\teval(\"parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol\"+i).innerHTML=\"<a href=\'javascript:onclick=expandRecode(\"+i+\")\'>+</a>\";\n\t\t}\n\t</script>\n</head>\n<body onKeyDown=\'lockKey()\'>\n\t<form name=\"RecodeDiagnosisProcDetail\" id=\"RecodeDiagnosisProcDetail\" method=\'post\'>\n\t<!--<form name=\"RecodeDiagnosisProcDetail\" id=\"RecodeDiagnosisProcDetail\">-->\n\n\t<table id=\'diagTable\' style=\'visibility:visible;display:inline\' border=\'1\' cellpadding=\'1\' cellspacing=\'0\' width=\"100%\"  valign=\'top\' onLoad=\'showDiag();\' style=\"visibility:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\n\n\t\t<tr><td colspan=\'13\' class=\'PANELTOOLBAR\' id=\"Proc_icon\"><a href=\"javascript:onclick=expandProcedure()\" style=\"visibility:";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">+</a>&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td></tr>\n\t\t<tr>&nbsp;</tr>\n\t\t<tr>\n\t\t\t<th align=\'center\'>&nbsp;</th>\n\t\t\t<th align=\'center\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t<th align=\'center\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<th align=\'center\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th><!-- Added On 7/8/2009 -->\n\t\t\t<th align=\'center\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </th><!-- Added On 7/8/2009 -->\n\n<!-- \t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th></th> Added On 7/2/2009-->\t\t\t\n\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\n\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t\t<img src=\'../../eCommon/images/EqivDiag.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"onclick=\'callDetails(\"Eq_Term_cd\",\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\",\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\",\"\",\"\",\"\",\"\",\"\")\' alt=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><img src=\'../../eCommon/images/RecodeRemarks.gif \'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"onclick=\'callDetails(\"Remarks\",\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\",\"Y\",\"\",\"\")\' alt=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"><img src=\'../../eCommon/images/order_catalog.gif\'  style=\"cursor:pointer;visibility:";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"onclick=\'callDetails(\"AcessionNum\",\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",\"\",\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\")\' alt=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"/><span nowrap title=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" style=\"cursor:pointer;display:";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"><a href=\"javascript:showLongDescription(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\"><b>!</b></a></span>\n\t\t\t\t</td>\t<!-- Equalent Term Code,Support Diag&Remarks Images  -->\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'><input type=\'checkbox\' name=\'select_chk1";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'select_chk1";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' disabled value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="$";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="~\' onClick=\'selectProcedure(";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =",this)\' ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >&nbsp;";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\t\t\t\t\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>&nbsp;";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' nowrap>&nbsp;";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t<input type=\'hidden\' name=\'hd_termset";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'hd_termset";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\t</table>\n\n\t<input type=\'hidden\' name=\'Stage_no\' id=\'Stage_no\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t<input type=\'hidden\' name=\'stage_no\' id=\'stage_no\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t<input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t<input type=\'hidden\' name=\'diagprob_code\' id=\'diagprob_code\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t<input type=\'hidden\' name=\'temp_code\' id=\'temp_code\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t<input type=\'hidden\' name=\'sel_item\' id=\'sel_item\' value=\'\'>\n\t<input type=\'hidden\' name=\'dflt_termset\' id=\'dflt_termset\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t<input type=\'hidden\' name=\'Pat_id\' id=\'Pat_id\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t<input type=\'hidden\' name=\'spec_code\' id=\'spec_code\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t<input type=\'hidden\' name=\'Patient_Class\' id=\'Patient_Class\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t<input type=\'hidden\' name=\'EncounterId\' id=\'EncounterId\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t<input type=\'hidden\' name=\'Practitioner_Id\' id=\'Practitioner_Id\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t<input type=\'hidden\' name=\'fieldSeperator\' id=\'fieldSeperator\' value=\'|\'>\n\t<input type=\'hidden\' name=\'profileID\' id=\'profileID\' value=\'XB\'>\n<!-- \t<input type=\'hidden\' name=\'caused_death\' id=\'caused_death\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n -->\t<input type=\'hidden\' name=\'code_set\' id=\'code_set\' value=\'\'>\n\t<input type=\'hidden\' name=\'diagprob_code\' id=\'diagprob_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'diag_classfication\' id=\'diag_classfication\' value=\'\'>\n\t<input type=\'hidden\' name=\'accuracy\' id=\'accuracy\' value=\'\'>\n\t<input type=\'hidden\' name=\'severity\' id=\'severity\' value=\'\'>\n\t<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\'\'>\n\t<input type=\'hidden\' name=\'onset_type\' id=\'onset_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'onset_date\' id=\'onset_date\' value=\'\'>\n\t<input type=\'hidden\' name=\'status\' id=\'status\' value=\'\'>\n\t<input type=\'hidden\' name=\'status_date\' id=\'status_date\' value=\'\'>\n\t<input type=\'hidden\' name=\'applicable_side\' id=\'applicable_side\' value=\'\'>\n\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'>\n\t<input type=\'hidden\' name=\'occur_srl_no\' id=\'occur_srl_no\' value=\'\'>\n\t<input type=\'hidden\' name=\'recode_status\' id=\'recode_status\' value=\'\'>\n\t<input type=\'hidden\' name=\'orig_termset\' id=\'orig_termset\' value=\'\'>\n\t<input type=\'hidden\' name=\'orig_termcode\' id=\'orig_termcode\' value=\'\'>\n\t<input type=\'hidden\' name=\'checked_yn\' id=\'checked_yn\' value=\'N\'>\n\t<input type=\'hidden\' name=\'allow_recode_diag_yn\' id=\'allow_recode_diag_yn\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t<input type=\'hidden\' name=\'allow_recode_proc_yn\' id=\'allow_recode_proc_yn\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\n\n\n\t</form>\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

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
	
 	Connection conn = ConnectionManager.getConnection(request);	

try
 {
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	 
	 String loginUser		= (String) session.getValue( "login_user" );	
	 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	 String locale = (String)session.getAttribute("LOCALE"); 


	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1		= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	StringBuffer sql1 = new StringBuffer();
	String term_set = "";
	//String term_code = "";
	//String term_desc = "";
	String record_by = "";
	String record_date = "";
	String caused_death = "";
	String classValue = "";
	//String hd_patient_id = "";
	//String hd_term_set = "";
	//String hd_term_code = "";
	//String hd_term_desc = "";
	//String hd_coded_by = "";
	//String hd_coded_date = "";
	//String hd_causeDeath = "";
	//String hd_recodeStatus = "";
	String patient_id = "";
	//String orig_term_set = "";
	//String orig_term_code = "";
	
	String proc_code = "";
	String proc_desc = "";
	//String hd_proc_code_scheme = "";
	//String hd_proc_code = "";
	
	String laterality="";
	String remarks="";
	String stage_srl_no="";
	String show_eq_tmcd="";
	String show_remarks="";



	int i = 0;
	//int cnt1 = 0;
	int srl_no = 0;



 String EncounterId = request.getParameter("EncounterId");
 String mode = checkForNull(request.getParameter("mode"));
 String dflt_termset = checkForNull(request.getParameter("dflt_termset"));
 //String Pat_id = checkForNull(request.getParameter("Pat_id"));
 String temp_code = checkForNull(request.getParameter("temp_code"));
 String gender = checkForNull(request.getParameter("gender"));
 String age = checkForNull(request.getParameter("age"));
 String dob = checkForNull(request.getParameter("dob"));
 String spec_code = checkForNull(request.getParameter("spec_code"));
 String Patient_Class = checkForNull(request.getParameter("Patient_Class"));
 //String show_level = checkForNull(request.getParameter("show_level"));
 //String DRGcal = checkForNull(request.getParameter("DRGcal"));
// String drg_temp = checkForNull(request.getParameter("drg_temp"));
 String stage_no = request.getParameter("stage_no");
// String mode1 = checkForNull(request.getParameter("mode1"));
 //String temp_proc = checkForNull(request.getParameter("temp_proc"));
// String tot_cnt = checkForNull(request.getParameter("tot_cnt"));

String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
String allow_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String allow_non_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_non_ot_proc_recode_yn"),"N");//Added On 7/7/2009
 int Stage_no = Integer.parseInt(stage_no);
 String recode_status = "";
 //String recodeStatus_disp = "";

//String  hide_header		="";
String  hide_dataTable	="";
String  hide_exp			="";
String New_EncounterId="";
String proc_type_filtr="";
if(allow_recode_proc_yn.equals("Y")){
	hide_dataTable="visible";
	New_EncounterId=EncounterId;//If allow_recode_proc_yn="Y";
	/*Added On 7/7/2009*/
	if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
		proc_type_filtr ="";
	}else if(allow_ot_proc_recode_yn.equals("Y")){
		proc_type_filtr	=" AND CONTR_MOD_ID='OT' ";
	}else if(allow_non_ot_proc_recode_yn.equals("Y")){
		proc_type_filtr	=" AND nvl(CONTR_MOD_ID,'x')!=nvl('OT','x') ";
	}
}else{
	hide_dataTable="hidden";
	New_EncounterId="";
}
if(allow_recode_diag_yn.equals("Y")){
	hide_exp	=	"visible";
}else{
	hide_exp	=	"hidden";
}

 if(mode.equals(""))
	mode="N";





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
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

	 		/*String New_EncounterId=EncounterId;//If allow_recode_proc_yn="Y";
			if(allow_recode_proc_yn.equals("N")){
				New_EncounterId="";
			} Note: This Commented Code Was Implemented @ Line No:98*/ 
			String contr_mod_id="";
			String proc_type="";
			String  accession_num	="";// Added On 7/8/2009
			String  code_extn_yn	="";// Added On 7/8/2009
			String  code_extn_dtl	="";// Added On 7/8/2009
			String show_accesion="";// Added On 7/8/2009
			boolean show_cdxtn=false;// Added On 7/8/2009
			String  remark_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
			String  eqvi_code_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels");
			String  order_cat_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ordercatalog.label","common_labels");
			String  latind_lbl="";;
			String  proc_srt_dt_time="";;
			String  proc_end_dt_time="";;



			if(mode.equals("Y")){
			if ( i % 2 == 0 )
				classValue = "gridData" ;
			else
				classValue = "gridData" ;


					sql1.append("select a.patient_id,a.proc_code_scheme, a.proc_code,mr_get_desc.mr_term_code(a.proc_code_scheme,a.proc_code,'"+locale+"','2') short_desc,b.long_desc,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name, decode(a.laterality_ind,'L','Left','R','Right','B','Both','N','NotApplicable') laterality_ind,to_char(a.proc_checkin_start_date_time,'dd/mm/yyyy hh24:mi')proc_checkin_start_date_time,to_char(a.proc_checkout_end_date_time,'dd/mm/yyyy hh24:mi')proc_checkout_end_date_time,to_char (a.proc_date, 'dd/mm/yyyy hh24:mi') recorded_date_time,decode(recode_status,'O','Review') recode_status,stage_srl_no,remarks,contr_mod_id,( SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct WHERE mct.TERM_SET_ID = a.proc_code_scheme AND mct.term_code = a.proc_code AND mct.CROSS_REF_TYPE = 'EQ')equiv_count,a.ACCESSION_NUM ,a.CODE_EXTN_YN,a.CODE_EXTN_DTL from mr_procedure_recoding_dtl a, mr_term_code b where a.facility_id='"+p_facility_id+"' and a.encounter_id = '"+New_EncounterId+"'  and a.recode_status='O' and stage_no='0' and status='A' and  a.proc_code_scheme=b.term_set_id and a.proc_code=b.term_code  "+proc_type_filtr+" order by contr_mod_id desc");
					pstmt = conn.prepareStatement(sql1.toString());
					rs = pstmt.executeQuery();	


				while(rs.next()){
					String long_desc			= "";// Added For Site Enhancement On 3/11/2010
					String long_desc_params	= "";// Added For Site Enhancement On 3/11/2010
					String display_long_desc	= "none";// Added For Site Enhancement On 3/11/2010
					int equivalent_term_code_cnt =0;
					patient_id = checkForNull(rs.getString("patient_id"));
					term_set = checkForNull(rs.getString("proc_code_scheme"));
					proc_code = checkForNull(rs.getString("proc_code"));
					proc_desc = checkForNull(rs.getString("short_desc"));
					recode_status = checkForNull(rs.getString("recode_status"));
					record_date = checkForNull(rs.getString("recorded_date_time"));
					record_date=DateUtils.convertDate(record_date,"DMYHM" ,"en",locale);

					record_by				= checkForNull(rs.getString("practitioner_name"));
					laterality					=checkForNull(rs.getString("laterality_ind"));
					remarks					=checkForNull(rs.getString("remarks"));
					stage_srl_no				=checkForNull(rs.getString("stage_srl_no"));
					contr_mod_id			=checkForNull(rs.getString("contr_mod_id"));
					proc_srt_dt_time		= checkForNull(rs.getString("proc_checkin_start_date_time"));
					proc_end_dt_time	= checkForNull(rs.getString("proc_checkout_end_date_time"));
					long_desc					= checkForNull(rs.getString("long_desc"));
					equivalent_term_code_cnt	= rs.getInt("equiv_count");
					accession_num						= checkForNull(rs.getString("ACCESSION_NUM"));
					code_extn_yn						= checkForNull(rs.getString("CODE_EXTN_YN"));
					code_extn_dtl						= checkForNull(rs.getString("CODE_EXTN_DTL"));
					if(recode_status.equals("Review")){
						recode_status	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//Review
					}
					if(laterality.equals("Left")){
						latind_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
					}else if(laterality.equals("Right")){
						latind_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
					}else if(laterality.equals("Both")){
						latind_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
					}else if(laterality.equals("NotApplicable")){
						latind_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
					}					
					//int cnt_icd = 0;
					/*String sqlicd="SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID = '"+term_set+"' AND term_code = '"+proc_code+"' AND CROSS_REF_TYPE = 'EQ'";

					pstmt1 = conn.prepareStatement(sqlicd);
					rs1	 = pstmt1.executeQuery();	

					while(rs1.next()){
							equivalent_term_code_cnt=rs1.getInt("COUNT");
					}

						if(pstmt1 != null) pstmt1.close();
						if(rs1 != null) rs1.close();*/

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
					if(!(proc_desc.equals(long_desc))){
						display_long_desc ="inline";
						long_desc_params = proc_code+","+term_set;
					}

				
			String chk_status ="disabled";
			if(contr_mod_id.equals("OT") ){
				proc_type	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OT.label","mr_labels");;
			}else{
				proc_type	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NonOT.label","mr_labels");
			}
		/*String sql_dtl_cols="Select ACCESSION_NUM ,CODE_EXTN_YN, CODE_EXTN_DTL from MR_PROCEDURE_RECODING_DTL where   proc_code = '"+proc_code+"'  and  stage_srl_no ='"+stage_srl_no+"' and encounter_id='"+EncounterId+"' and facility_id='"+p_facility_id+"'";
		pstmt1 = conn.prepareStatement(sql_dtl_cols);
		rs1	 = pstmt1.executeQuery();	
		while(rs1.next()){
			accession_num	= checkForNull(rs1.getString("ACCESSION_NUM"));
			code_extn_yn	= checkForNull(rs1.getString("CODE_EXTN_YN"));
			code_extn_dtl	= checkForNull(rs1.getString("CODE_EXTN_DTL"));
		}
				if(pstmt1 != null) pstmt1.close();
				if(rs1 != null) rs1.close();*/

				if(!accession_num.equals("")){
					if(!contr_mod_id.equals("")){
						show_accesion	 ="visible";
					}else{
						show_accesion	 ="hidden";
					}
				}else{
					show_accesion	 ="hidden";
				}

				if(code_extn_yn.equals("N")){
					if(contr_mod_id.equals("OT")){
						show_cdxtn	= true;
					}else{
						code_extn_dtl	 ="";
						show_cdxtn		= false;
					}
				}else{
					code_extn_dtl	="";
				}


            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(show_eq_tmcd));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(eqvi_code_lbl));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(show_remarks));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(stage_srl_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(remark_lbl));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(show_accesion));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(stage_srl_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(contr_mod_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_cat_lbl));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(display_long_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(long_desc_params));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recode_status));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(chk_status));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(recode_status));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(proc_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( proc_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(code_extn_dtl));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(record_by));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(record_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(latind_lbl));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(proc_srt_dt_time));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(proc_end_dt_time));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block58Bytes, _wl_block58);

			}//While Loop Ends
		}//Mode Check Ends
			if(rs != null)rs.close();
			if(rs1 != null)rs1.close();
			if(pstmt  != null)pstmt.close();
			if(pstmt1  != null)pstmt1.close();
		
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(Stage_no));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(temp_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(age));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(Patient_Class));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(caused_death));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(allow_recode_diag_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(allow_recode_proc_yn));
            _bw.write(_wl_block77Bytes, _wl_block77);

}catch(Exception e){
	e.printStackTrace();
}finally{
		ConnectionManager.returnConnection(conn,request);

 }

	
            _bw.write(_wl_block78Bytes, _wl_block78);
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
}
