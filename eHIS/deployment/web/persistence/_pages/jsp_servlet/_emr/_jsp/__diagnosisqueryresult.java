package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __diagnosisqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagnosisQueryResult.jsp", 1743665317680L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>\nfunction chkMax(Obj)\n{\n\tif(Obj.value.length >75)\n\t{\n\t\tvar error = getMessage(\'REMARKS_XCEED_2000_CHARS\',\'MR\');\n\t\terror\t= error.replace(\'2000\',\'75\');\n\t\talert(error)\n\t\tObj.focus();\n\t}\n}\n\nfunction Proceed()\n{\n\tvar j = document.forms[0].NumRecords.value;\n\tvar formFields =\"\";\n\tfor(var m=1; m<j; m++)\n\t{\n\t\tformFields += (eval(\"document.forms[0].recodedCode\"+m).name)+\"/\"+(eval(\"document.forms[0].recodedCode\"+m).value)+\"\";\n\t}\n\t\tdocument.forms[0].formFields.value = formFields;\n\n\t\tdocument.forms[0].action=\"../../servlet/eMR.DiagnosisRecodeServlet\";\n\t\tdocument.forms[0].submit();\n}\n\nfunction getDiagnosis(obj,j)\t\n{ \t\n\tvar DiagCode = obj.value;\n\tif(DiagCode != \'\')\n\t{\n\t\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'diag_form\' id=\'diag_form\' method=\'post\' action=\'../../eMR/jsp/MedRecRequestValidation.jsp?\'><input type=\'hidden\' name=\'DiagCode\' id=\'DiagCode\' value=\'\"+DiagCode+\"\'><input type=\'hidden\' name=\'j\' id=\'j\' value=\'\"+j+\"\'><input type=\'hidden\' name=\'Criteria\' id=\'Criteria\' value=\'getDiagnosis\'></form></body></html>\";\n\t\tparent.frames[2].document.write(HTMLVal)\n\t\tparent.frames[2].document.diag_form.submit();\n\t}\n\telse if(DiagCode == \'\')\n\t{\n\t\teval(document.getElementById(\"Description\"+j)).innerText=\"         \";\n\t}\n}\n\nasync function show_window(j)\n{\n\tvar scheme = document.forms[0].scheme.value;\n\tvar scheme_desc\t= document.forms[0].scheme_desc.value;\n\tvar Encounter_Id= document.forms[0].Encounter_Id.value;\n\tvar p_auth_yn=\"N\";\n\n\tif (scheme == 5)\n\t{\n\t\tvar retVal = \"test Value\";\n\t\tvar dialogHeight= \"28vh\" ;\n\t\tvar dialogWidth = \"43vw\" ;\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\tvar arguments   = \"\" ;\n\t\tretVal = await window.showModalDialog(\"../../eCA/html/eCISLUE.html\",arguments,features);\n\n\t\tvar arr = new Array();\n\t\tarr = retVal.split(\"|\");\n\t\tvar stra = arr[0];\n\t\tvar strc = arr[1];\n\t\tvar strb = arr[2];\n\n\t\teval(\"document.forms[0].recodedCode\"+j).value=stra;\n\t\teval(\"document.forms[0].Description\"+j).value=strb;\n\t}\n\n\tif (scheme == 1 || scheme == 2)\n\t{\n\t\tvar retVal =    new String();\n\t\tvar dialogHeight= \"27.22vh\" ;\n\t\tvar dialogWidth = \"44vw\" ;\n\t\tvar status = \"no\";\n\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\n\t\tvar cause_ind=\'\';\n\t\tif(scheme==\"2\")\n\t\t\tcause_ind=document.forms[0].cause_ind.value\n\n\t\tretVal = await window.showModalDialog(\"PaintConsultationFrame.jsp?title=\"+scheme_desc+\"&CodeList&p_diag_code=\"+scheme+\"&p_diag_scheme_desc=\"+scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&p_auth_yn=\"+p_auth_yn+\"&cause_indicator=\",arguments,features);\n\t\t\n\t\tif (!(retVal == null))\n\t\t{\n\t\t\tvar retdata;\n\t\t\tif(scheme==\"2\")\n\t\t\t{\n\t\t\t\tretdata\t= retVal.split(\"/\") ;\n\t\t\t\tretVal\t= retdata[0];\n\t\t\t}\n\n\t\t\teval(\"document.forms[0].recodedCode\"+j).value=retVal;\n\t\t}\n\t\teval(\"document.forms[0].recodedCode\"+j).focus();\n\t}\n}\n\nsrl_no_array = new Array();\nvar prev=1;\nvar i=0;\nvar prev1=0;\nvar j=0;\n\nfunction refer(ro,numofcols)\n{\n\tprev1\t=ro.rowIndex\n\tfor (var i=0;i<numofcols;i++)\n\t{\n\tdocument.forms[0].all.dataTable.rows[prev].cells[i].style.backgroundColor=ro.bgColor;\n\t}\n\tfor (var i=0;i<numofcols;i++)\n\t{\n\t\tro.cells(i).style.backgroundColor=\"#B2B6D7\";\n\t}\n\tprev = ro.rowIndex ;\n}\n\nfunction RecodeDiagDetail(obj)\n{\n\tvar srl_no_val = obj.value;\n\tvar pat_id = document.forms[0].PatientId.value;\n\tvar Encounter_Id = document.forms[0].Encounter_Id.value;\n\n\tparent.frames[1].document.location.href =\"../../eMR/jsp/DiagnosisQueryDetail.jsp?srl_no=\"+srl_no_val+\"&patient_id=\"+pat_id+\"&Encounter_Id=\"+Encounter_Id+\" \";\n}\n\nfunction RecodeTransDetail(term_set,term_code,occur_srl_no)\n{\n\t\n\tvar call_function = \'TRANSMIT_NOTIFY_REP\';\n\t//var srl_no_val = obj.value;\n\tvar pat_id = document.forms[0].PatientId.value;\n\tvar Encounter_Id = document.forms[0].Encounter_Id.value;\n\tvar diag_code = document.forms[0].diag_code.value;\n\tvar diag_code_scheme_desc = document.forms[0].diag_code_scheme_desc.value;\n\tvar DIAG_CODE_SCHEME = document.forms[0].DIAG_CODE_SCHEME.value;\n//alert(diag_code_scheme_desc);\n\t//parent.frames[1].document.location.href =\"../../eMR/jsp/DiagnosisTransmissionDetails.jsp?srl_no=\"+srl_no_val+\"&patient_id=\"+pat_id+\"&diag_code=\"+diag_code+\"&diag_code_scheme=\"+DIAG_CODE_SCHEME+\"&diag_code_scheme_desc=\"+diag_code_scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&call_function=\"+call_function+\"&recorded_date=\"+obj2+\" \";\n\tparent.frames[1].document.location.href =\"../../eMR/jsp/DiagnosisTransmissionDetails.jsp?term_set_id=\"+term_set+\"&term_code=\"+term_code+\"&occur_srl_no=\"+occur_srl_no+\"&patient_id=\"+pat_id+\"&diag_code=\"+diag_code+\"&diag_code_scheme=\"+DIAG_CODE_SCHEME+\"&diag_code_scheme_desc=\"+diag_code_scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&call_function=\"+call_function+\" \";\n}\n\nfunction RecodeConfDetail(term_set,term_code,occur_srl_no)\n{\n\t\n\tvar call_function = \'CONF_TRANSMIT_NOTIFY_REP\';\n\t\n\t//var srl_no_val = obj.value;\n\tvar pat_id = document.forms[0].PatientId.value;\n\tvar Encounter_Id = document.forms[0].Encounter_Id.value;\n\tvar diag_code = document.forms[0].diag_code.value;\n\tvar diag_code_scheme_desc = document.forms[0].diag_code_scheme_desc.value;\n\tvar DIAG_CODE_SCHEME = document.forms[0].DIAG_CODE_SCHEME.value;\n\n\t//parent.frames[1].document.location.href =\"../../eMR/jsp/DiagnosisTransmissionDetails.jsp?patient_id=\"+pat_id+\"&diag_code=\"+diag_code+\"&diag_code_scheme=\"+DIAG_CODE_SCHEME+\"&diag_code_scheme_desc=\"+diag_code_scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&call_function=\"+call_function+\" \";\n\tparent.frames[1].document.location.href =\"../../eMR/jsp/DiagnosisTransmissionDetails.jsp?term_set_id=\"+term_set+\"&term_code=\"+term_code+\"&occur_srl_no=\"+occur_srl_no+\"&patient_id=\"+pat_id+\"&diag_code=\"+diag_code+\"&diag_code_scheme=\"+DIAG_CODE_SCHEME+\"&diag_code_scheme_desc=\"+diag_code_scheme_desc+\"&Encounter_Id=\"+Encounter_Id+\"&call_function=\"+call_function+\" \";\n}\n\n\nfunction scrollTitle()\n{\n  var y = parent.PatProblemQueryResult.document.body.scrollTop;\n\n  if(y == 0){\n\tparent.PatProblemQueryResult.document.getElementById(\"divDataTitle\").style.position = \'static\';\n\tparent.PatProblemQueryResult.document.getElementById(\"divDataTitle\").style.posTop  = 0;\n  }else{\n\tparent.PatProblemQueryResult.document.getElementById(\"divDataTitle\").style.position = \'relative\';\n\tparent.PatProblemQueryResult.document.getElementById(\"divDataTitle\").style.posTop  = y-2;\n  }\n}\n\nfunction alignWidth()\n{\n\tvar totalRows =  parent.PatProblemQueryResult.document.getElementById(\"dataTable\").rows.length;\n\tvar counter = totalRows-1;\n\tvar temp = parent.PatProblemQueryResult.document.getElementById(\"dataTitleTable\").rows(1).cells.length;\n\tfor(var i=0;i<temp;i++) \n\t{\n\tparent.PatProblemQueryResult.document.getElementById(\"dataTitleTable\").rows(1).cells(i).width=parent.PatProblemQueryResult.document.getElementById(\"dataTable\").rows(counter).cells(i).offsetWidth;\n\t}\n}\n\n</script>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n<form name=\'query_form\' id=\'query_form\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eMR.DiagnosisRecodeServlet\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<!-- \t<table border=\"1\" width=\'125%\' id=\'dataTitleTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' >\n\t\t<tr>\n\t\t\t<th nowrap align=\'center\' >Onset Date</th>\n\t\t\t<th nowrap align=\'center\' >Code</th>\n\t\t\t<th nowrap align=\'center\' width=\'25%\'>Diagnosis</th>\n\t\t\t<th nowrap\talign=\'center\' >Scheme</th>\n\t\t\t<th nowrap align=\'center\' >Primary</th>\n\t\t\t<th nowrap align=\'center\' >Significant</th>\n\t\t\t<th nowrap align=\'center\' >Re-coded Code</th>\t\n\t\t\t<th nowrap align=\'center\' width=\'25%\'>Re-coded Diagnosis</th>\n\t\t\t<th nowrap align=\'center\' width=\'25%\'>Remarks</th>\n\t\t\t<th nowrap align=\'center\' >Recorded By</th>\n\t\t\t<th nowrap align=\'center\' >Recorded Date</th>\n\t\t</tr> -->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<center>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<table border=\"0\" width=\'125%\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'4\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'4\' class=\'label\' height=\"5\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"button\"><input type=\"button\" class=\'Button\' name=\"Record\" id=\"Record\" title=\'Record\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onclick=\"Proceed();\" ></td>\n\t\t\t\t\t<td class=\"button\"><input type=\"button\" class=\'Button\' name=\"Close\" id=\"Close\" title=\'Close\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onclick=\"window.close();\" ></td>\n\t\t\t\t\t<td class=\'white\' width=\"95%\" ></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'4\' class=\'label\' height=\"5\"></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<table border=\"1\" width=\'125%\' id=\'dataTitleTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'>\n\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n                <tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'></td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t<th nowrap align=\'center\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<th nowrap align=\'center\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t<th nowrap align=\'center\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </th>\n\t\t\t<th nowrap align=\'center\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t\t<th nowrap align=\'center\' width=\'30%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t\t<th nowrap\talign=\'center\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t<th nowrap align=\'center\' >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" </th>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<th nowrap\talign=\'center\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</th>\n\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</th>\n\t\t\t<th nowrap align=\'center\' width=\'12%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<!--<th nowrap align=\'center\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</th>-->\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\n\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'14\' class=\'CAGROUPHEADING\' ><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'14\' class=\'CAGROUPHEADING\' ><b>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n\t\t\t\t<script>\n\t\t\t\tsrl_no_array[i] = null;\n\t\t\t\ti++;\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<tr>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'><a name=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' href=\"javascript:RecodeTransDetail(document.forms[0].srl_no";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =",\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\')\">\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t<script>\n\t\t\t\tsrl_no_array[i] = ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\ti++;\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<tr>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\t\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'> <a name=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' href=\"javascript:RecodeConfDetail(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\',\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\')\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' href=\"javascript:RecodeTransDetail(\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\t\t\t\n\t\t\t\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n<tr style=\'visibility:hidden\'>\n<th nowrap >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</th>\n<th nowrap >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</th>\n</tr>\n</table>\n</center>\n\n<input type=\"hidden\" name=\"formFields\" id=\"formFields\" value=\"\">\n<input type=\"hidden\" name=\"help_function_id\" id=\"help_function_id\" value=\"RECORD_DIAGNOSIS\">\n<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<input type=\"hidden\" name=\"PatientId\" id=\"PatientId\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=\"hidden\" name=\"Encounter_Id\" id=\"Encounter_Id\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\"hidden\" name=\"diag_code\" id=\"diag_code\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<input type=\"hidden\" name=\"diag_code_scheme_desc\" id=\"diag_code_scheme_desc\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<input type=\"hidden\" name=\"DIAG_CODE_SCHEME\" id=\"DIAG_CODE_SCHEME\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\n<input type=\"hidden\" name=\"scheme\" id=\"scheme\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n<input type=\"hidden\" name=\"scheme_desc\" id=\"scheme_desc\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n<input type=\"hidden\" name=\"NumRecords\" id=\"NumRecords\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n<input type=\"hidden\" name=\"recode_count\" id=\"recode_count\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
 Function Name	:	Diagnosis Recoding
 Developer		:	SRIDHAR R
 Created On		:	27 JULY 2004
 Function 		:   Used to define the result page of recode diagnosis
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
   // String facilityId		= (String) session.getValue("facility_id");

   
   
   
	String locale			= (String) session.getAttribute("LOCALE"); 
	String PatientId		= request.getParameter("PatientId");
    String Encounter_Id     = request.getParameter("Encounter_Id");
	
    //added forBru-HIMS-CRF-380 Start
	String facilityId	= request.getParameter("facility_id");
	if(facilityId==null)
		facilityId = (String) session.getValue("facility_id");
	//added forBru-HIMS-CRF-380 End
	int j=1;
	String call_function	= request.getParameter("call_function");	
    String scheme       ="";
    String scheme_desc  ="";
	String significant_yn = request.getParameter("significant_yn");
	if(significant_yn==null) significant_yn = "N";
    int k=1;
    int aname=2;
    String classValue = "";
	String diag_type="", temp="";

	String sql_1="select diag_code_scheme scheme,decode(diag_code_scheme,'1','ICD 10','2','ICD 9CM','5','READ')scheme_desc from mr_parameter";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

        Connection conn 	= null; 
        PreparedStatement  pstmt = null;
        ResultSet  rs		= null;
        Statement  stmt_1	= null;
        ResultSet  rs_1		= null;
		Statement  recode_count_stmt	= null;
        ResultSet  recode_count_rs		= null;
		Statement  recode_stmt	= null;

		int recode_count	= 0;
        int maxRecord 		= 0;
		String diag_code			= "";
		String diag_code_scheme_desc= "";
		String DIAG_CODE_SCHEME		= "";


/// Added by SRIDHAR R on 8 Oct 2004...
/// This will execute if the function is Diagnosis Recoding & will display the values to the user in the update mode.. if records already exists in mr_diag_recoding...
		String recodeCode			= "";
		String recodeDesc			= "";
		String remark				= "";
		String modified_date			= "";
		String modified_by_id			= "";

try
{
	conn = ConnectionManager.getConnection(request);
	
	if(call_function.equals("DIAG_RECODE"))
	{
		/*String recode_count_sql = " SELECT COUNT (*) FROM mr_diag_recoding WHERE onset_facility_id = '"+facilityId+"' AND onset_encounter_id = '"+Encounter_Id+"' ";*/
	/*Below line added for this SCF ML-MMOH-SCF-0360*/
	String recode_count_sql = " SELECT COUNT (*) FROM mr_diagnosis_recoding_dtl WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+Encounter_Id+"'";
		
		recode_count_stmt	= conn.createStatement();
		recode_count_rs		= recode_count_stmt.executeQuery(recode_count_sql);
		if(recode_count_rs.next())
		{
			recode_count = recode_count_rs.getInt(1);
		}
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

/*
		if(recode_rs != null)
		{
			while(recode_rs.next())
			{
				n++;
				if ( n%2 == 0 )
					classValue = "QRYEVENSMALL" ;
				else
					classValue = "QRYODDSMALL" ;

				groupby_diagtype = checkForNull(recode_rs.getString("diagtype"));

				onsetDate = checkForNull(recode_rs.getString("onset_date"));
				origCode = checkForNull(recode_rs.getString("orig_diag_code"));
				origDesc = checkForNull(recode_rs.getString("DIAG_DESC"));
				OrgScheme = checkForNull(recode_rs.getString("orig_diag_code_scheme"));
				primary = recode_rs.getString("primary_yn");
					if(primary == null) primary = "N";
				significant = recode_rs.getString("significant_yn");
					if(significant == null) significant = "N";
				recodeCode = checkForNull(recode_rs.getString("recoded_diag_code"));
				recodeDesc = checkForNull(recode_rs.getString("recoded_diag_desc"));
				remark = checkForNull(recode_rs.getString("recoded_remarks"));
				recordedby = checkForNull(recode_rs.getString("onset_practitioner_id"));
				recordedDate = checkForNull(recode_rs.getString("onset_date"));

				if((!(groupby_diagtype.equals(new_groupby_diagtype))))
				{
					out.println("<tr><td colspan='14' class='CAGROUPHEADING'>"+groupby_diagtype+"</td></tr>");
				} 
				new_groupby_diagtype = groupby_diagtype;

			out.println(" <tr> ");
			out.println(" <td align='center' class='"+classValue+"'>"+onsetDate+"</td> ");
			out.println(" <td class='"+classValue+"'>"+origCode+"</td> ");
			out.println(" <td wrap class='"+classValue+"'>"+origDesc+"</td> ");
			out.println(" <td align='center' class='"+classValue+"'>"+OrgScheme+"</td> ");

			if(primary.equals("Y"))
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
			else
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");

			if(significant.equals("Y"))
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
			else
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
			
			out.println(" <td nowrap class='"+classValue+"'>"+recodeCode+"</td> ");
			out.println(" <td wrap class='"+classValue+"'>"+recodeDesc+"</td> ");
			out.println(" <td wrap class='"+classValue+"'>"+remark+"</td> ");
			out.println(" <td nowrap class='"+classValue+"'>"+recordedby+"</td> ");
			out.println(" <td align='center' nowrap class='"+classValue+"'>"+recordedDate+"</td> ");
			out.println(" </tr> ");
		
			}
		}
	}  /// End of addition ...
	else if(recode_count == 0)
	{
*/		
	
		if(recode_count_stmt!=null)	recode_count_stmt.close();
		if(recode_count_rs!=null)	recode_count_rs.close();
		
		stmt_1=conn.createStatement();
		rs_1=stmt_1.executeQuery(sql_1);
		if(rs_1.next())
		{
			scheme      = rs_1.getString("scheme");
			scheme_desc = rs_1.getString("scheme_desc");
		}

		if(rs_1 !=null) rs_1.close();
		if(stmt_1!=null) stmt_1.close();

		StringBuffer strsql = new StringBuffer();
		if (call_function.equals("VIEW_ENCOUNTER_DTLS")){
			strsql.append("select count(1) from pr_diagnosis_enc_dtl a, mr_term_code b where a.patient_Id = ? and a.encounter_id = ?  AND a.facility_id=? AND a.term_set_id=b.term_set_id AND a.term_code=b.term_code and a.status ='A'  ");
		}else{
			strsql.append("select count(1) from pr_diagnosis_enc_dtl a, mr_term_code b where a.patient_Id = ? and a.encounter_id = ?  AND a.facility_id=? AND a.term_set_id=b.term_set_id AND a.term_code=b.term_code and a.status ='A'  and b.NOTIFIABLE_YN = 'Y'");
		}
		if (call_function.equals("TRANSMIT_NOTIFY_REP") || call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
			strsql.append(" and NOTIFIABLE_YN = 'Y' ");
		}

		pstmt	=	conn.prepareStatement(strsql.toString());
		pstmt.setString(1,PatientId);
		pstmt.setString(2,Encounter_Id);
		pstmt.setString(3,facilityId);
		rs = pstmt.executeQuery();
		if(rs.next()){
		  maxRecord = rs.getInt(1);
		}
		if (maxRecord==0){			
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.window.close();</script>");
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		String sql = "";
		if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
		{
			
			//sql="select DIAG_CODE_SCHEME,srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc,ONSET_PRACTITIONER_NAME, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc, to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date, close_practitioner_name, close_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null  ";
			
			//sql="select DIAG_CODE_SCHEME,srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc,			AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME,significant_yn, diag_type diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc, to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date, AM_GET_DESC.AM_PRACTITIONER(CLOSE_PRACTITIONER_ID,'"+locale+"','1') close_practitioner_name, close_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null "; 




			//sql="select DIAG_CODE_SCHEME, srl_no, to_char(onset_date,'dd/mm/yyyy') onset_date1, sensitive_yn,diag_desc, diag_code, DECODE(DIAG_CODE_SCHEME,'1', 'ICD10','2', 'ICD9-CM','5','READ') DIAG_CODE_SCHEME_DESC ,AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag,diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date,AM_GET_DESC.AM_PRACTITIONER(CLOSE_PRACTITIONER_ID,'"+locale+"','1') close_practitioner_name,close_date from pr_problem where patient_Id = ? and onset_facility_id = '"+facilityId+"' and onset_encounter_id = ?  and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null ";

			/*sql = "SELECT   term_set_id, occur_srl_no,TO_CHAR (onset_date, 'dd/mm/yyyy') onset_date, am_get_desc.am_practitioner (onset_practitioner_id, '"+locale+"','1' ) onset_practitioner_name,term_code diag_code,term_code_short_desc diag_desc FROM pr_diagnosis WHERE patient_id = ? AND onset_facility_id = '"+facilityId+"' AND onset_encounter_id = ? AND term_set_id LIKE '%' AND curr_status !=  'E' ORDER BY onset_date DESC ";*/
			
			/*Below Query Modified for this SCF ML-MMOH-SCF-0360. The pr_diagnosis_enc_dtl table was replaced instead of PR_DIAGNOSIS*/
			
			sql = "SELECT   term_set_id, occur_srl_no,TO_CHAR (RECORDED_DATE_TIME, 'dd/mm/yyyy') onset_date, am_get_desc.am_practitioner (practitioner_id, '"+locale+"','1' ) onset_practitioner_name,term_code diag_code,term_code_short_desc diag_desc FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND facility_id = '"+facilityId+"' AND encounter_id = ? AND term_set_id LIKE '%' AND status != 'E' ORDER BY onset_date DESC ";

		}
		else if(recode_count == 0)
		{
			
			//sql="select DIAG_CODE_SCHEME,srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc,ONSET_PRACTITIONER_NAME, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null  ";

			//sql="select DIAG_CODE_SCHEME, srl_no, to_char(onset_date,'dd/mm/yyyy')onset_date1, sensitive_yn,diag_desc, diag_code,diag_code_scheme_desc, AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME, significant_yn, diag_type diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null  ";


			/*sql="select DIAG_CODE_SCHEME, srl_no, to_char(onset_date,'dd/mm/yyyy') onset_date1, sensitive_yn, diag_desc, diag_code, DECODE(DIAG_CODE_SCHEME,'1', 'ICD10','2', 'ICD9-CM','5','READ') DIAG_CODE_SCHEME_DESC , AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') onset_practitioner_name, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc, to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem where patient_Id = ? and onset_facility_id = '"+facilityId+"' and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null";*/
			if(call_function.equals("TRANSMIT_NOTIFY_REP")||call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){

//			sql="SELECT C.TERM_SET_ID,D.TERM_SET_DESC,C.TERM_CODE, C.SHORT_DESC, TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE1, decode(C.NOTIFIABLE_YN,'Y','Yes','N','No') NOTIFIABLE_YN, AM_GET_DESC.AM_PRACTITIONER (A.ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME,decode(B.NATURE,'A','Actual','P','Potential','W','Wellness')  nature,decode(B.PRIORITY,'N','Normal','H','High','C','Critical') priority , mr_get_desc.mr_accuracy(B.ACCURACY_CODE,'"+locale+"','2') accuracy_short_desc,decode(B.CAUSE_OF_DEATH_YN,'Y','Yes','N','No') CAUSE_OF_DEATH_YN,AM_GET_DESC.AM_PRACTITIONER(B.PRACTITIONER_ID,'"+locale+"','1') RECORDED_BY,to_char( B.RECORDED_DATE_TIME,'dd/mm/yyyy')  RECORDED_DATE, A.OCCUR_SRL_NO FROM PR_DIAGNOSIS A, PR_DIAGNOSIS_ENC_DTL B, MR_TERM_CODE C,MR_TERM_SET D WHERE B.FACILITY_ID = '"+facilityId+"' AND B.ENCOUNTER_ID = '"+Encounter_Id+"' AND A.PATIENT_ID = B.PATIENT_ID AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE AND A.TERM_SET_ID = C.TERM_SET_ID AND A.TERM_CODE = C.TERM_CODE AND C.TERM_SET_ID = D.TERM_SET_ID";
			sql="SELECT C.TERM_SET_ID,D.TERM_SET_DESC,C.TERM_CODE, C.SHORT_DESC, TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE1, decode(C.NOTIFIABLE_YN,'Y','Yes','N','No') NOTIFIABLE_YN, AM_GET_DESC.AM_PRACTITIONER (A.ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME,decode(B.NATURE,'A','Actual','P','Potential','W','Wellness')  nature,decode(B.PRIORITY,'N','Normal','H','High','C','Critical') priority , mr_get_desc.mr_accuracy(B.ACCURACY_CODE,'"+locale+"','2') accuracy_short_desc,AM_GET_DESC.AM_PRACTITIONER(B.PRACTITIONER_ID,'"+locale+"','1') RECORDED_BY,to_char( B.RECORDED_DATE_TIME,'dd/mm/yyyy')  RECORDED_DATE, A.OCCUR_SRL_NO,E.SEQ_NO FROM PR_DIAGNOSIS A, PR_DIAGNOSIS_ENC_DTL B, MR_TERM_CODE C,MR_TERM_SET D,MR_DEATH_REGISTER_DIAG_DTL E WHERE B.FACILITY_ID = '"+facilityId+"' AND B.ENCOUNTER_ID = '"+Encounter_Id+"' AND A.PATIENT_ID = B.PATIENT_ID AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE AND A.TERM_SET_ID = C.TERM_SET_ID AND A.TERM_CODE = C.TERM_CODE AND C.TERM_SET_ID = D.TERM_SET_ID AND B.PATIENT_ID=E.PATIENT_ID (+) AND B.TERM_CODE=E.TERM_CODE (+) AND B.TERM_SET_ID=E.TERM_SET_ID (+)";
			}else{
				sql="select DIAG_CODE_SCHEME, srl_no, to_char(onset_date,'dd/mm/yyyy') onset_date1, sensitive_yn, diag_desc, diag_code, DECODE(DIAG_CODE_SCHEME,'1', 'ICD10','2', 'ICD9-CM','5','READ') DIAG_CODE_SCHEME_DESC , AM_GET_DESC.AM_PRACTITIONER(ONSET_PRACTITIONER_ID,'"+locale+"','1') onset_practitioner_name, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc, to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem where patient_Id = ? and onset_facility_id = '"+facilityId+"' and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null";
			}
		}
		

	/*if(/*call_function.equals("TRANSMIT_NOTIFY_REP") || call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
	{
		sql = sql + " and NOTIFIABLE_YN = 'Y' ";
	}
	*/
	if(recode_count == 0&!call_function.equals("TRANSMIT_NOTIFY_REP")&&!call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
	{
		//sql = sql + " order by diagtype, onset_date desc ";
	}
	if(recode_count == 0)
	{
		
		pstmt	=	conn.prepareStatement(sql);
		if(!call_function.equals("TRANSMIT_NOTIFY_REP")&&!call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
		pstmt.setString(1,PatientId);
		pstmt.setString(2,Encounter_Id);
		}

		rs = pstmt.executeQuery();
	}

	if(recode_count > 0)
	{
		
		//String recode_sql = " SELECT a.modified_by_id, TO_CHAR (a.modified_date, 'dd/mm/yyyy') modified_date, decode(b.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, TO_CHAR (b.onset_date, 'dd/mm/yyyy') onset_date1, b.DIAG_DESC diag_desc, a.orig_diag_code, b.diag_code diag_code, a.orig_diag_code_scheme DIAG_CODE_SCHEME, b.primary_yn, b.significant_yn significant_yn, TO_CHAR(b.onset_recorded_date, 'dd/mm/yyyy') onset_recorded_date, b.onset_practitioner_id ONSET_PRACTITIONER_NAME, a.recoded_diag_desc , a.recoded_diag_code, a.RECODED_REMARKS recoded_remarks, nvl(b.PRIMARY_YN,'N') primary_diag, b.diag_code||nvl2(b.cause_indicator,'/'||b.CAUSE_INDICATOR,null)diag_code_desc, b.diag_code_scheme_desc, b.srl_no srl_no, b.sensitive_yn sensitive_yn,a.TRN_SRL_NO FROM MR_DIAG_RECODING_VW a, PR_PROBLEM_VW b WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+Encounter_Id+"' AND a.patient_id = b.patient_id AND a.srl_no = b.srl_no ORDER BY b.diag_type " ;


		//String recode_sql = "SELECT a.modified_by_id, TO_CHAR (a.modified_date, 'dd/mm/yyyy') modified_date,b.diag_type diagtype,TO_CHAR (b.onset_date, 'dd/mm/yyyy') onset_date1, b.DIAG_DESC diag_desc,a.orig_diag_code, b.diag_code diag_code, a.orig_diag_code_scheme DIAG_CODE_SCHEME,b.primary_yn, b.significant_yn significant_yn, TO_CHAR(b.onset_recorded_date, 'dd/mm/yyyy') onset_recorded_date, AM_GET_DESC.AM_PRACTITIONER(B.ONSET_PRACTITIONER_ID,'"+locale+"','1') ONSET_PRACTITIONER_NAME,a.recoded_diag_desc , a.recoded_diag_code, a.RECODED_REMARKS recoded_remarks,nvl(b.PRIMARY_YN,'N') primary_diag,b.diag_code||nvl2(b.cause_indicator,'/'||b.CAUSE_INDICATOR,null)diag_code_desc, b.diag_code_scheme_desc, b.srl_no srl_no,b.sensitive_yn sensitive_yn, a.TRN_SRL_NO FROM MR_DIAG_RECODING_VW a, PR_PROBLEM_VW b WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+Encounter_Id+"' AND a.patient_id = b.patient_id AND a.srl_no = b.srl_no ORDER BY b.diag_type " ;


		String recode_sql = "select a.modified_by_id, TO_CHAR (a.modified_date, 'dd/mm/yyyy') modified_date,decode(b.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype,TO_CHAR (b.onset_date, 'dd/mm/yyyy') onset_date1, b.DIAG_DESC diag_desc,a.orig_diag_code, b.diag_code diag_code, a.orig_diag_code_scheme diag_code_scheme,b.primary_yn, b.significant_yn significant_yn, TO_CHAR(b.onset_recorded_date,'dd/mm/yyyy') onset_recorded_date, AM_GET_DESC.AM_PRACTITIONER(B.ONSET_PRACTITIONER_ID,'"+locale+"','1') onset_practitioner_name,b.diag_desc recoded_diag_desc, a.recoded_diag_code,a.REMARKS recoded_remarks, nvl(b.PRIMARY_YN,'N') primary_diag,b.diag_code||nvl2(b.cause_indicator,'/'||b.CAUSE_INDICATOR,null)diag_code_desc, diag_code_scheme diag_code_scheme_desc, b.srl_no srl_no, b.sensitive_yn sensitive_yn,a.TRN_SRL_NO FROM MR_DIAG_RECODING a, PR_PROBLEM b WHERE a.onset_facility_id = '"+facilityId+"' AND a.onset_encounter_id = '"+Encounter_Id+"' AND a.patient_id = b.patient_id AND  a.srl_no = b.srl_no ORDER BY b.diag_type";

		if(rs != null) rs.close();
		recode_stmt	= conn.createStatement();
		rs	= recode_stmt.executeQuery(recode_sql);
	}
	

            _bw.write(_wl_block9Bytes, _wl_block9);
	if (call_function.equals("DIAG_RECODE")){	
            _bw.write(_wl_block10Bytes, _wl_block10);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(PatientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
	}	
            _bw.write(_wl_block14Bytes, _wl_block14);
	if(rs == null)
		{
            for (int x=0; x<6 ; x++)
            {
                if ( k%2 == 0 )
                    classValue = "QRYEVENSMALL" ;
                else
	                classValue = "QRYODDSMALL" ;
				
				
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);

                k++;
            }
        }
        else
        {	
            _bw.write(_wl_block18Bytes, _wl_block18);
	if(call_function.equals("DIAG_RECODE")){	
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
	}else if(call_function.equals("TRANSMIT_NOTIFY_REP")||call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
if(!call_function.equals("TRANSMIT_NOTIFY_REP")&!call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
	if(!call_function.equals("DIAG_RECODE")&!call_function.equals("TRANSMIT_NOTIFY_REP")&&!call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
		{	
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
	}	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

			if(call_function.equals("TRANSMIT_NOTIFY_REP")||call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
	
		}
		if (call_function.equals("DIAG_RECODE")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
	}	
            _bw.write(_wl_block35Bytes, _wl_block35);
	if (call_function.equals("VIEW_ENCOUNTER_DTLS")){	
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
	} 
            _bw.write(_wl_block38Bytes, _wl_block38);
	
		String onset_date		= "";
		String onset_date_display = "";
		String diag_desc		= "";
		String prim_diag		= "";
		String srl_no			= "";
		String sensitive_yn		= "";
		String Recorded_by		= "";
		//String closed_by		= "";
		//String closed_date		= "";
		//String closed_date_display = "";
		String recorded_date	= "";
		String recorded_date_display	= "";
		String trn_srl_no		="";
		String modified_date_display = ""; 
		String term_set      = ""; 
		while(rs.next())
		{
			if(!call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
			if(recode_count > 0)
			{
				modified_by_id = checkForNull(rs.getString("modified_by_id"));
				modified_date	= checkForNull(rs.getString("modified_date"));
				recodeCode	= checkForNull(rs.getString("recoded_diag_code"));
				recodeDesc	= checkForNull(rs.getString("recoded_diag_desc"));
				remark		= checkForNull(rs.getString("recoded_remarks"));
				trn_srl_no	=checkForNull(rs.getString("TRN_SRL_NO"));
			}
			if(!call_function.equals("VIEW_ENCOUNTER_DTLS"))
			{
			modified_date_display = DateUtils.convertDate(modified_date,"DMY","en",locale);
			DIAG_CODE_SCHEME	=	rs.getString("DIAG_CODE_SCHEME");
			onset_date		=	rs.getString("onset_date1");
			onset_date_display = DateUtils.convertDate(onset_date,"DMY","en",locale);
			Recorded_by		=	checkForNull(rs.getString("ONSET_PRACTITIONER_NAME"));
			recorded_date	=	checkForNull(rs.getString("onset_recorded_date"));
			recorded_date_display = DateUtils.convertDate(recorded_date,"DMY","en",locale);
			diag_desc		=	checkForNull(rs.getString("diag_desc"));
			diag_code		=	checkForNull(rs.getString("diag_code"));
			prim_diag		=	rs.getString("primary_diag");
			diag_type		=	rs.getString("diagtype");
				if(diag_type == null)	
					diag_type ="";
				else if(diag_type.equalsIgnoreCase("P"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");
				else if(diag_type.equalsIgnoreCase("D"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
				else if(diag_type.equalsIgnoreCase("F"))
					diag_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");

			diag_code_scheme_desc=	rs.getString("diag_code_scheme_desc");
			srl_no 			= 	rs.getString("srl_no");
			
			sensitive_yn	=	rs.getString("sensitive_yn");

			significant_yn	=	rs.getString("significant_yn");	
			if(significant_yn==null)	significant_yn  = "N";
			if(diag_code==null)			diag_code		= "&nbsp;";
				if(sensitive_yn!=null)
				{
				   if(sensitive_yn.equals("Y"))
						classValue="PATQRED";
				}
				if(significant_yn.equals("Y"))
				{
					classValue="SIGNIFICANT";
				}
			}
			if(call_function.equals("VIEW_ENCOUNTER_DTLS"))
			{	
				onset_date		=	rs.getString("onset_date");
				onset_date_display = DateUtils.convertDate(onset_date,"DMY","en",locale);
				diag_code		=	checkForNull(rs.getString("diag_code"));
				diag_desc		=	checkForNull(rs.getString("diag_desc"));
				term_set		=	checkForNull(rs.getString("term_set_id"));
				Recorded_by		=	checkForNull(rs.getString("ONSET_PRACTITIONER_NAME"));
				//recorded_date	=	checkForNull(rs.getString("onset_recorded_date"));
				//recorded_date_display = DateUtils.convertDate(recorded_date,"DMY","en",locale);
			} 				
			
			
			if ((!(diag_type.equals(temp))))
			{
				if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
				{	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(diag_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
	}else 
				{	
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diag_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
 } 
            _bw.write(_wl_block42Bytes, _wl_block42);

			}
			temp=diag_type;

		if ( k%2 == 0 )
			classValue = "QRYEVENSMALL" ;
		 else
			classValue = "QRYODDSMALL" ;					


	if (call_function.equals("TRANSMIT_NOTIFY_REP"))
	{ 	
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(onset_date_display));
            _bw.write(_wl_block45Bytes, _wl_block45);
	out.println("<td nowrap class='"+classValue+"'>" +diag_code+"</td>");	
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(aname));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(k));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(recorded_date_display));
            _bw.write(_wl_block50Bytes, _wl_block50);
	}
	else if (call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
	{
		out.println("<tr style='background-color:;'><td class='"+classValue+"'>"+onset_date_display+"</td>");
		out.println("<td nowrap class='"+classValue+"'>" +diag_code+"</td>");
		out.println("<td class='"+classValue+"'><a name='"+aname+"'  href='javascript:RecodeConfDetail(document.forms[0].srl_no"+k+")'>");
	}
	else if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
	{
		out.println("<tr style='background-color:;'><td class='"+classValue+"'>"+onset_date_display+"</td>");
		out.println("<td nowrap class='"+classValue+"'>" +diag_code+"</td>");
		out.println("<td class='"+classValue+"'>");
	}
	else
	{
		out.println("<tr style='background-color:;'><td class='"+classValue+"'>"+onset_date_display+"</td>");
		out.println("<td nowrap class='"+classValue+"'>" +diag_code+"</td><input type='hidden' name='OrgCode"+j+"' id='OrgCode"+j+"' value='"+diag_code+"' >");

		out.println("<td class='"+classValue+"' >");
	}

	if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
		out.println(diag_desc+"</td>");
	else
		out.println(diag_desc+"</a></td>");
	
	out.println("<input type='hidden' name='OrgDesc"+j+"' id='OrgDesc"+j+"' value='"+diag_desc+"' >");
	

	if(!call_function.equals("DIAG_RECODE"))
	{
		
		if(call_function.equals("VIEW_ENCOUNTER_DTLS"))
		out.println("<td nowrap class='"+classValue+"'>" +term_set+"</td>");
		else
		out.println("<td nowrap class='"+classValue+"'>" +diag_code_scheme_desc+"</td>");

		if(prim_diag.equals("Y"))
			out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
		else
			out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");

		if(significant_yn.equals("Y"))
			out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
		else
			out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
	}	


		out.println("<td nowrap class='"+classValue+"'>" +Recorded_by+"</td>");
		//out.println("<td nowrap class='"+classValue+"'>" +recorded_date_display+"</td>");

/// Added by Sridhar R on 6 OCT 2004..
	if(call_function.equals("DIAG_RECODE"))
	{	
		if(recode_count > 0)
		{
			diag_code = recodeCode;
			diag_desc = recodeDesc;
		}

		//	RECODE CODE
		
		out.println("<td class='"+classValue+"'><input type='text' size='10' maxlength='10' name='recodedCode"+j+"' id='recodedCode"+j+"' value='"+diag_code+"'  onblur='getDiagnosis(this,"+j+")'><input type='button' name='code_butt' id='code_butt' value='?' class='button' onClick=show_window("+j+") ></td><input type='hidden' name='trn_srl_no"+j+"' id='trn_srl_no"+j+"' value='"+trn_srl_no+"'>");

		//	RECODE DESC
		out.println("<td class='"+classValue+"' wrap id='Description"+j+"'>"+diag_desc+"</td><input type='hidden' name='reCodedDesc"+j+"' id='reCodedDesc"+j+"' value='"+diag_desc+"'>");

		//	REMARKS 
		out.println("<td class='"+classValue+"'><input type='text' size='20' maxlength='75' name='remarks"+j+"' id='remarks"+j+"' onblur=chkMax(this) value='"+remark+"'></td>");

		out.println("<td nowrap class='"+classValue+"'>" +modified_by_id+"</td>");
		out.println("<td nowrap class='"+classValue+"'>" +modified_date_display+"</td>");	
	
	}

// End of addition
	if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
	{
		//out.println("<td nowrap class='"+classValue+"'>" +closed_by+"</td>");
		//out.println("<td nowrap class='"+classValue+"'>" +closed_date_display+"</td>");
	}

	out.println("<input type='hidden' name='srl_no"+k+"' id='srl_no"+k+"' value='"+srl_no+"'></td>");
	out.println("</tr>");
		
		
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
		k++;
	        j++;
		}

		else
			{
			if ( k%2 == 0 ){
				classValue = "QRYEVENSMALL" ;
			}else{
				classValue = "QRYODDSMALL" ;
			}

			String term_set_id			= checkForNull(rs.getString("TERM_SET_ID"));
			String term_set_desc	= checkForNull(rs.getString("TERM_SET_DESC"));
			String term_code			= checkForNull(rs.getString("term_code"));
			String short_desc			= checkForNull(rs.getString("SHORT_DESC"));
			String onset_date1		= checkForNull(rs.getString("ONSET_DATE1"));
			String notifiable_yn		= checkForNull(rs.getString("NOTIFIABLE_YN"));
			String occur_srl_no		= checkForNull(rs.getString("OCCUR_SRL_NO"));
			String nature					= checkForNull(rs.getString("nature"));
			String priority				= checkForNull(rs.getString("priority"));		
			String accuracy_code	= checkForNull(rs.getString("accuracy_short_desc"));
//			String cause_of_death_yn=checkForNull(rs.getString("CAUSE_OF_DEATH_YN"));
			String recorded_by		= checkForNull(rs.getString("RECORDED_BY"));
			String recorded_date1	= checkForNull(rs.getString("RECORDED_DATE"));
			String seq_no				= checkForNull(rs.getString("SEQ_NO"));
			

			
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block55Bytes, _wl_block55);

			if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
			{
			
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(aname));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{
			
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(aname));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(onset_date1));
            _bw.write(_wl_block45Bytes, _wl_block45);


				if(notifiable_yn.equals("Yes"))
					out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
				else
					out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");		
			
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nature));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(accuracy_code));
            _bw.write(_wl_block64Bytes, _wl_block64);

				if(seq_no.equals("1")){
					out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
			}else{
					out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
			}
				
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recorded_by));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recorded_date1));
            _bw.write(_wl_block65Bytes, _wl_block65);

				out.println("<input type='hidden' name='srl_no"+k+"' id='srl_no"+k+"' value='"+srl_no+"'></td>");
				k++;
			}
		}
			if(rs!=null)    rs.close();
			if(recode_stmt != null) recode_stmt.close();
	  }

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(diag_code_scheme_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(DIAG_CODE_SCHEME));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(scheme_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(j));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(recode_count));
            _bw.write(_wl_block78Bytes, _wl_block78);
  
}catch(Exception e)
{
	//out.print("ERROR in DiagnosisQueryResult.jsp : "+e);
	e.printStackTrace();
}
finally
{
	if(pstmt!=null)  pstmt.close();
	ConnectionManager.returnConnection(conn, request);
}

            _bw.write(_wl_block79Bytes, _wl_block79);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSetID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSetDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCode.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ShortDesc.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Notifiable.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Nature.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accuracy.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseofDeath.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primary.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.significant.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.recordeddate.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RecodedCode.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RecodedDiagnosis.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RecodedBy.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RecodedDate.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ClosedBy.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ClosedDate.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primary.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }
}
