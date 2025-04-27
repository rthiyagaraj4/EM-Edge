package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import java.io.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __displayresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/DisplayResults.jsp", 1742301656080L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<Script src=\"../../eOA/js/ChangeDate.js\" language=\"JavaScript\"></Script>\n <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n <script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script> \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<html>\n\t\t<head>\t\t\n\t</head>\n\t\t\t<script src=\"../../eOP/js/ManageSPatQueue.js\"></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\n<script>\n\tasync function call_visit_regn(patient,q_appt_ref_no,referral_id,q_clinic_code,q_clinic_type,q_appt_time,q_visit_adm_type,q_practitioner_id,contact_reason_code,reason,service_code)\n\t{\t\n\t\tif(referral_id == \"~\")\n\t\t\treferral_id=\'\';\n\t\tif(service_code == \'null\' || service_code == \"~\")\n\t\t\tservice_code=\'\';\n\t\t\t\n\t\tvar dialogHeight= \"46\" ;\n\t\tvar dialogWidth = \"70\" ;\n\t\tvar dialogTop \t= \"85\";\n\t\tvar center = \"1\" ;\n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar retval=await  window.showModalDialog(\"../../eOP/jsp/VisitRegistration.jsp?menu_id=OP&module_id=OP&function_id=VISIT_REGISTRATION&function_name=Register Visit&function_type=F&access=NYNNN&patient=\"+patient+\"&q_appt_ref_no=\"+q_appt_ref_no+\"&referral_id=\"+referral_id+\"&q_clinic_code=\"+q_clinic_code+\"&q_locn_type=\"+q_clinic_type+\"&q_visit_adm_type=\"+q_visit_adm_type+\"&q_Appt_time=\"+q_appt_time+\"&q_practitioner_id=\"+q_practitioner_id+\"&contact_reason_code=\"+contact_reason_code+\"&reason=\"+reason+\"&call_from=CA&service_code=\"+service_code+\"&resource_class=\"+document.forms[0].res_type.value,arguments,features);\n\n\n\t\tif(retval == \'Y\')\n\t\t\tdocument.location.reload();\n\t}\n\n\tfunction call_patient_chart(encounter_id)\n\t{\t\n\t\t\tvar HTMLVal  = \"<html>\";\n\t\t\tHTMLVal  += \"<form name=\'OpenChartWrapperForm\' id=\'OpenChartWrapperForm\' action = \'../../eCA/jsp/OpenChartWrapper.jsp\' method=\'post\' target=\'messageFrame\' >\";\n\t\t\tHTMLVal  += \"<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'\" + encounter_id + \"\'>\";\n\t\t\tHTMLVal  += \"<input type=\'hidden\' name=\'from_module\' id=\'from_module\' value=\'AE\'>\";\n\t\t\tHTMLVal  += \"<input type=\'hidden\' name=\'from_service_yn\' id=\'from_service_yn\' value=\'Y\'>\";\n\t\t\tHTMLVal  += \"</form>\";\n\t\t\tHTMLVal  += \"</html>\";\n\t\t\t//This is commented on 03/07/09 bcoz getting script errors from CA when we click on the patient_id hyperlink in schedule appointments\n\t\t \t/*parent.parent.parent.parent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\t\n\t\t\tparent.parent.parent.parent.messageFrame.document.OpenChartWrapperForm.submit();*/\n\t\t\tparent.parent.parent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\t\n\t\t\tparent.parent.parent.messageFrame.document.OpenChartWrapperForm.submit()\n\t\t\t\n\t}\n\n</script>\n\n<body onLoad=\'visiblelity()\' OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onscroll=\"scrollheader();scrollTitle();\">\n\n<form name=\"single_pract\" id=\"single_pract\">\n\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'SCHEDULE_APPOINTMENT\'>\t\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\t\t\t\n\t\tvar msg = getMessage(\'SCH_NOT_DEFINED_FOR_CLINIC\',\'OA\'); \n\t\talert(msg +\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\n\t\tparent.frames[0].document.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.frames[1].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script>\n\t\tparent.frames[0].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\n\t<div id=\"labeldiv2\" style=\"visibility:visible;backgroundColor:white;overflow:scroll\">\n\t<!--\n\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t-->\n\t<!--Above line commented and below line added for this CRF ML-MMOH-CRF-0606-->\n\t<table width=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t<!--End this CRF ML-MMOH-CRF-0606-->\n\t\t\t\n\t\t\t<tr>\n\t\t\t<td  class=\'label\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td class=\'fields\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" width=\'50%\'><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<td class=\'label\' width=\'30%\'><a href=\"javascript:allocationDetails(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</b></a></td>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<td class=\'label\' width=\'30%\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\n\n\t\t\t<td colspan = 1 class=\'label\'  align=center >\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<a href=\'javascript:moveNextlabels()\'>\n\t\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b></a><input type=\'hidden\' name=\'dummy\' id=\'dummy\' > <!--/td-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t&nbsp;</td>\n\n\t\t\t</tr>\n\n\t\t\t<tr>\n\n\t\t\t<td  class=\'label\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t<td  class=\'fields\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</b></td>\n\n\t\t\t<td class=\'label\' width=\'30%\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t</tr>\n\n\t<tr><td class=\'DEFAULTBLANKROW2PT\'  colspan=4>&nbsp;</td></tr>\n\t</table>\t\t\n\n\t<!--\n\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t-->\n\t<!--Above line commented and below line added for this CRF ML-MMOH-CRF-0606-->\t\n\t<table width=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t<!--End this CRF ML-MMOH-CRF-0606-->\n\t\n\t<tr>\n\t<td>\n\t\n\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\'>\n\n\t<tr>\n\t\n\t<td class=\'label\' width=\"2%\">&nbsp;</td>\n\t<td class=\'label\' align=\'middle\'>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<b>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</b>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t</td>\t\n\t<td class=\'label\' align=\'middle\'  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</b></td>\n\t<td class=\'label\' align=\'middle\'  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</b></td>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<td class=\'label\' align=\'middle\'  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">\n\t\t<b>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</b>\n\t</td>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\n\t<!--Below line Modified for this CRF ML-MMOH-CRF-0606-->\t\n    <!--Below line Modified for this CRF ML-MMOH-CRF-0609 by Mano-->\n\t<td class=\'label\' align=\'middle\'  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</b></td>\n\t<!--End this CRF ML-MMOH-CRF-0609-->\n\t<!--End this CRF ML-MMOH-CRF-0606-->\n\t\n\t</tr>\n\t\n\t<tr>\n\t<td class=\'label\' width=\"2%\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</b></td>\n\t<td class=\'label\' align=\'middle\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t</td>\t\n\t<td class=\'label\' align=\'middle\' ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =">\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<b>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</b>\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t<td class=\'label\' align=\'middle\' ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =">\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t</td>\n\t<td class=\'label\' align=\'middle\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</b></td>\n\n\t<td class=\'label\' align=\'middle\' ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</b> </td>\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t<td class=\'label\' align=\'middle\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t\n\t\t\n\t<td class=\'label\' >&nbsp;</td>\n\t<td class=\'label\' >&nbsp;</td>\n\n\t</tr>\n\n\t<tr>\n\t<td class=\'label\' width=\"2%\" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</b></td>\n\t<td class=\'label\' align=\'middle\'><b>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</b></td>\t\n\t<td class=\'label\' align=\'middle\'><b>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t<td class=\'label\' align=\'middle\'>\n\t\t<b>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\n\t<td class=\'label\' >&nbsp;</td>\n\t<td class=\'label\' >&nbsp;</td>\n\n\t</tr>\n\n\t   \n\t </tr> <!-- </table>\n\t<table width=\'80%\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>  -->\n\t<tr>\n\t    <!--Below line Modified for this CRF ML-MMOH-CRF-0606-->\n\t\t<td class=\'label\' nowrap width=\'2%\'>&nbsp;</td>\n\t\t\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t \t\n\t\t<td class=\'label\' ><b>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</b></td>\n\t\t<td class=\'label\' ><b>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</b></td>\n\t\t\t\n\t\t<!-- <td colspan = \'4\' class=\'label\'  align=center> </td> -->\n\t\t\n\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</div>\n\t<!-- <div id=\'header\' style=\"visibility:visible;backgroundColor:white;overflow:scroll\"> -->\n\t<br>\n\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'results1\'>\n\t<th align=\'left\' width=\'4%\'><div  id=\'head1\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</div></th>\n\t<th align=\'left\' width=\'4%\'><div  id=\'head2\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</div></th>\n\t<!--Added for the CRF Bru-HIMS-CRF-172  -->\n\t<th align=\'left\' width=\'4%\'><div  id=\'head11\'  class=\'myClass\' wrap >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</div></th>\n\t<th align=\'left\' width=\'21%\'><div  id=\'head3\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</div></th>\n\t<th align=\'left\' width=\'6%\' ><div  id=\'head4\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</div></th>\n\t<!--Below line added for this CRF GHL-CRF-0414 -->\n\t<th align=\'left\' width=\'6%\' ><div  id=\'head13\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</div></th>\n\t<!--End GHL-CRF-0414 -->\n\t<th align=\'left\' width=\'13%\' ><div  id=\'head5\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</div></th>\n\t<th align=\'left\' width=\'12%\'><div  id=\'head6\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</div></th>\n\t<th align=\'left\' width=\'12%\'><div  id=\'head7\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</div></th>\n\n   <!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]   -->\n    <th align=\'left\' width=\'12%\'><div  id=\'head12\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</div></th>\n  <!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->\n\n\t<!--Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start-->\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t<th align=\'left\' width=\'12%\'><div  id=\'head14\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</div></th>\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t<!--End-->\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t<th align=\'left\' width=\'11%\' ><div  id=\'head8\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</div></th>\n\t<th align=\'left\' width=\'11%\' ><div  id=\'head10\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</div></th>\n\t<th align=\'left\' width=\'12%\' ><div  id=\'head9\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</div></th>\t\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n<!-- </table></div>\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'results\'> -->\n\t\t\n\t\t\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\t\n\t\t\t\t\t\t<script>alert(getMessage(\'APPT_CAN_NOT_TRANS_OTH_CAT\',\'OA\'));</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t<script>alert(getMessage(\'APPT_TRANS_OTH_CAT\',\'OA\'));</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t<script>\n\nfunction doDateCheckAlert(from,to) {\n\tvar fromarray; var toarray;\n\tvar fromdate = from ;\n\tvar todate = to ;\n\tif(fromdate.length > 0 && todate.length > 0 ) {\n\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\ttoarray = todate.split(\"/\");\n\t\t\tfromarray[1]=fromarray[1]-1;\n\t\t\ttoarray[1]=toarray[1]-1;\n\n\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse if(Date.parse(todt) >= Date.parse(fromdt)) { return true; } \n\t\t\t\n\t\t\t\n\t}\nreturn true;\n}\n</script>\n\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\n\n<tr onClick=\'row(this)\'>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\"4%\" ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" class=\"OARED\" onClick=\'col(this)\' title=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="<input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' id=\'o_appt_ref_no";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' ></td>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t<td width=\"4%\"  ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" class=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" onClick=\'col(this)\'>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" <input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' ></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td width=\"4%\"  ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' ></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"4%\"  ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\"4%\"  ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" class=\"OARED\" onClick=\'col(this)\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' ></td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\"4%\"  ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" class=\"OAFORCED\" onClick=\'col(this)\'>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td width=\"4%\"  ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t<td width=\"4%\"  ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\n\t\t<td width=\"4%\"  ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" class=\'oablock\'>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' ></td>\n\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\n\t\t<td width=\"4%\"  ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" class=\'oared\'>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' ></td>\n\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" class=\'OARED\' title=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' ></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="  class=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' > </td>\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' > </td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" onClick=\'col(this)\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<a href= \"javascript:GroupappointmentSelect(\'\',\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\')\">";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</a> <input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' > </td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" onClick=\'col(this)\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<a href= \"javascript:moveNext_results(\'\',\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t\t\t\t   <td width=\"5%\" ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' >\n\t\t\t\t\t\t\t\t\t  </td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" onClick=\'col(this)\'><a href= \"javascript:moveNext_results(\'\',\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t  \t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</a><input type=\'hidden\'  name=\'o_appt_ref_no";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' > </td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\"<input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' > </td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =" class=\'OAFORCED\' onClick=\'col(this)\' Title=\'Forced Appointment\'><a href= \"javascript:moveNext_results(\'F\',\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</a> <input type=\'hidden\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" onClick=\'col(this)\'><a href= \"javascript:moveNext_results(\'NF\',\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</a> <input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' ></td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\t\n\t\t\t\t\t\t\t\t\t\t<td width=5% ";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" onClick=\'col(this)\'><a href= \"javascript:moveNext_results(\'M\',\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\' ></td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' ></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" >";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' > </td>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" class=\'oablock\'>\n\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\n\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="  class=\'oared\'  title =\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 =" \n\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\' ></td>\n\t\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">&nbsp; <input type=\'hidden\' name=\'o_appt_ref_no\' name=\'o_appt_ref_no";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\n\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =" class=\"OARED\" title=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</td>\n\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 =" class=\"OAFORCED\" Title=\"Forced Appointment\">";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\n\t\t\t\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</td>\n\t\t\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\n\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</td>\n\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\n\t\t<td width=\"5%\" ";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =" class=\'OARED\'  title =\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t<td width=\"5%\" ";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">&nbsp;</td>\n";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="<td width=\"5%\" ";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\"><center><img src=\'../../eCommon/images/inpatient.gif\'><center></td>";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n<td width=\"5%\" ";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">&nbsp</td>\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t<td width=\'27%\' ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">\n\t\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t\t\t\t\t<a href=\"javascript:call_visit_regn(\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\')\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\t\t\t\n\t\t\t\t\t\t</a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t\t<a href=\"javascript:call_patient_chart(\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\')\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t\t\t\t";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\n\t\t\t\n\t\t\t&nbsp;";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="<img src=\'../../eCommon/images/PI_VIP.gif\'>";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="&nbsp;,";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t<td width=\'27%\' ";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">***</td>\n\t\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\n\t\t\t\t<td width=\'27%\' ";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 =" class=\'OARED\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t\t<td width=\'27%\' class=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 =":&nbsp;<b>";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="</b></td>\n\t\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\t\t\t\t \n\t\t\t\t<td width=\'27%\' class=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\t\t\t\n\t\t\t<td width=\'21%\'  class=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 =",";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="<div style =\'BACKGROUND-COLOR:#D5D5D5; font-weight:bold; color:red\'>";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="</div>";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n\t\t\t\t<td width=\'21%\'  class=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t\t\n\t\t\t\t<td width=\'21%\'  class=\'OARED\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t<td width=\'21%\'  class=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t\t<td width=\'21%\' class=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =" ";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="&nbsp;<b>";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\t\t\t\t \n\t\t\t\t<td width=\'21%\' class=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 =" \n\t\t<td width=\'6%\' ";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="  style=\"background-color:";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 =";FONT-SIZE:8pt;\" >";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="&nbsp;</td>\n\t\t<td width=\'6%\' ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\n\t\t    <td width=\'12%\' ";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\t\t\t\n\t\t\t<td width=\'12%\' class=\'OARED\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t\t<td width=\'12%\' class=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">&nbsp;</td>\n\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 =";FONT-SIZE:8pt;\">";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t<td width=\'12%\'  class=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">&nbsp;&nbsp;</td>\n\t";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="<td width=\'12%\' class=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="&nbsp;</td>";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n<td width=\'15%\' class=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\n\t\t<a href=\"javascript:show_Reference_details_results(\'";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\')\">\n\t\t\t";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n\t\t</a>\n\t";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="&nbsp;</td>\n\t<!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->\n\t<td width=\'12%\' class=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" onClick=\'col(this)\' >";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="<a href=\"javascript:show_order_select(\'\',\'";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\t\t</a>";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="<input type=\'hidden\'  name=\'order_appt_ref_no";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\' id=\'order_appt_ref_no";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\' ></td>\n\t<!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659] -->\n\t";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\n\t\t<td width=\'12%\' class=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="<a href=\"javascript:dispApptRemarks(\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\')\">\n\t\t";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n<td width=\'12%\' class=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="&nbsp;</td><!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->\n\t<td width=\'12%\' class=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">&nbsp;</td>\n\t<!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659] -->\n\t\n";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\n\t\t\t<td width=\'11%\' class=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="</td><td width=\'11%\' class=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">&nbsp;";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="<a href=\"javascript:show_patinstructions(\'";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="</a>";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="</td><td  class=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" width=\'11%\'>";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n\t\t<td  width=\'11%\' class=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\">&nbsp;</td><td width=\'11%\' class=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="</td><td width=\'11%\'class=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\n</tr>\n";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\n</table>\n\n\t\n<input type=\"hidden\" name=\"p_o_obvisit_flag\" id=\"p_o_obvisit_flag\" value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">\n<input type=\"hidden\" name=\"oper_stn_id\" id=\"oper_stn_id\" value=\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\">\n\t<input type=\'hidden\' name=\'r_appt_status\' id=\'r_appt_status\' value=\'null\' >\n\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\' >\n\t<input type=\'hidden\' name=\'clinic_name\' id=\'clinic_name\' value=\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\' >\n\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\'";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\' >\n\t<input type=\'hidden\' name=\'pract_name\' id=\'pract_name\' value=\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\' >\n\t<input type=\'hidden\' name=\'appt_date\' id=\'appt_date\' value=\'";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\' >\n\t<input type=\'hidden\' name=\'over_booked\' id=\'over_booked\' value=\'";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\' >\n\t<input type=\'hidden\' name=\'over_booked_label\' id=\'over_booked_label\' value=\'";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\'>\n\t<input type=\'hidden\' name=\'P_O_TIME_TAB_TYPE\' id=\'P_O_TIME_TAB_TYPE\' value=\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\' >\n\t<input type=\'hidden\' name=\'max_patients_per_slab\' id=\'max_patients_per_slab\' value=\'";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\' >\n\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\' >\n\t<input type=\'hidden\' name=\'sys_time\' id=\'sys_time\' value=\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\' >\n\t<input type=\"hidden\" name=\"alcn_criteria\" id=\"alcn_criteria\" value=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\">\n\t<input type=\"hidden\" name=\"slot_appt_ctrl\" id=\"slot_appt_ctrl\" value=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\">\n\t<input type=\"hidden\" name=\"visit_limit_rule\" id=\"visit_limit_rule\" value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\t<input type=\"hidden\" name=\"override_no_of_slots_yn\" id=\"override_no_of_slots_yn\" value=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\">\n\t<input type=\'hidden\' name=\'reason_for_revise\' id=\'reason_for_revise\'  value=\'";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\' >\n\t<input type=\'hidden\' name=\'ref_no\' id=\'ref_no\' value= \'";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\' >\n\t<input type=\'hidden\' name=\'old_date\' id=\'old_date\' value=\'";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\' >\n\t<input type=\'hidden\' name=\'p_o_end_time\' id=\'p_o_end_time\' value =\'";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\' >\n\t<input type=\'hidden\' name=\'old_from_time\' id=\'old_from_time\' value=\'";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\' >\n\t<input type=\'hidden\' name=\'old_to_time\' id=\'old_to_time\' value=\'";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\' >\n\t<input type=\'hidden\' name=\'book_appt_yn\' id=\'book_appt_yn\' value=\'";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\' >\n\t<input type=\'hidden\' name=\'book_appt_wo_pid_yn\' id=\'book_appt_wo_pid_yn\' value=\'";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\' >\n\t<input type=\'hidden\' name=\'obook_appt_yn\' id=\'obook_appt_yn\' value=\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\' >\n\t<input type=\'hidden\' name=\'book_appt_across_catg_yn\' id=\'book_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\' >\n\t<input type=\'hidden\' name=\'tfr_appt_yn\' id=\'tfr_appt_yn\' value=\'";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\' >\n\t<input type=\'hidden\' name=\'tfr_appt_across_catg_yn\' id=\'tfr_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\' >\n\t<input type=\'hidden\' name=\'canc_appt_yn\' id=\'canc_appt_yn\' value=\'";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\' >\n\t <input type=\'hidden\' name=\'pre_pat_alcn_catg_code\' id=\'pre_pat_alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\' >\n\t<input type=\'hidden\' name=\'ca_mode\' id=\'ca_mode\' value=\'";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\' >\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'null\' >\n\t<input type=\"hidden\" name=\'ca_patient_id\' id=\'ca_patient_id\' value=\'";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\' >\n\t<input type=\"hidden\" name=\"maxForced\" id=\"maxForced\" value=\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\">\n\t<input type=\"hidden\" name=\"totForced\" id=\"totForced\" value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\">\n\t<input type=\"hidden\" name=\"maxGlobal\" id=\"maxGlobal\" value=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\">\n\t<input type=\"hidden\" name=\"totGlobal\" id=\"totGlobal\" value=\"";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\">\n\t<input type=\"hidden\" name=\'callingMode\' id=\'callingMode\' value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\">\n\t<input type=\"hidden\" name=\'calling_mode_new\' id=\'calling_mode_new\' value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\">\n\t<input type=\"hidden\" name=\'req_id\' id=\'req_id\' value=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\">\n\t<input type=\"hidden\" name=\"install_yn_val\" id=\"install_yn_val\" value=\"";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\">\n\t<input type=\"hidden\" name=\"create_wait_list_yn\" id=\"create_wait_list_yn\" value=\"";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\">\n\t<input type=\"hidden\" name=\'visit_flag_OP\' id=\'visit_flag_OP\' value=\'";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\'>\n\t<input type=\"hidden\" name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\'>\n<input type=\"hidden\" name=\'contact_num_reqd_yn\' id=\'contact_num_reqd_yn\' value=\'";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\'>\n\t<input type=\"hidden\" name=\'page1\' id=\'page1\' value=\'";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\'>\n<input type=\"hidden\" name=\'from_page\' id=\'from_page\' value=\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\'>\n<input type=\"hidden\" name=\'from_facility_id\' id=\'from_facility_id\' value=\'";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\'>\n<input type=\"hidden\" name=\'from_encounter_id\' id=\'from_encounter_id\' value=\'";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\'>\n<input type=\"hidden\" name=\'no_of_noshow_appts_for_alert\' id=\'no_of_noshow_appts_for_alert\' value=\'";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\'>\n<input type=\"hidden\" name=\'per_chk_for_no_show_alert\' id=\'per_chk_for_no_show_alert\' value=\'";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\'>\n<input type=\"hidden\" name=\'isIncRemarksLengthAppl\' id=\'isIncRemarksLengthAppl\' value=\'";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\'><!--Added by Thamizh selvi on 16th July 2018 against ML-MMOH-CRF-1184-->\n\n<input type=\"hidden\" name=\"refID\" id=\"refID\" value=\"";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\">\n<input type=\"hidden\" name=\'min_ela_per_resc_noshow_in_day\' id=\'min_ela_per_resc_noshow_in_day\' value=\'";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\'>\n<input type=\"hidden\" name=\'noshow_ctrl_by_splty_or_clinic\' id=\'noshow_ctrl_by_splty_or_clinic\' value=\'";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\'>\n";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\n\t<input type=\"hidden\" name=\"calling_mode\" id=\"calling_mode\" value=\"";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\">\n\t<input type=\"hidden\" name=\"ForcedAllowed\" id=\"ForcedAllowed\" value=\"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\">\n\t<input type=\"hidden\" name=\"GlobalAllowed\" id=\"GlobalAllowed\" value=\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\">\n\t<input type=\"hidden\" name=\"LocGlbChk\" id=\"LocGlbChk\" value=\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\" >\n\n\t\n\t<input type=\"hidden\" name=\"clinic_type\" id=\"clinic_type\" value=\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">\n\t<input type=\"hidden\" name=\"res_type\" id=\"res_type\" value=\"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\">\n\t<input type=\"hidden\" name=\"or_catalogue_code\" id=\"or_catalogue_code\" value=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\">\n\t<input type=\"hidden\" name=\"order_line_num\" id=\"order_line_num\" value=\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\">\t\n\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\">\t\n\t<input type=\"hidden\" name=\"order_catalog_code\" id=\"order_catalog_code\" value=\"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\">\n\t<input type=\"hidden\" name=\"hddUrl\" id=\"hddUrl\" value=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\">\n\t<!-- Added for ML-BRU-CRF-0628.1 -->\n\t<input type=\"hidden\" name=\"p_o_ext_slot_status\" id=\"p_o_ext_slot_status\" value=\"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\">\n\t<input type=\"hidden\" name=\"p_o_reserved_slot_dtls\" id=\"p_o_reserved_slot_dtls\" value=\"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\">\n\t<input type=\"hidden\" name=\"p_o_appt_slot_dtls\" id=\"p_o_appt_slot_dtls\" value=\"";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\">\n\t<input type=\"hidden\" name=\"p_o_block_slot_dtls\" id=\"p_o_block_slot_dtls\" value=\"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\">\n\t<input type=\"hidden\" name=\"p_o_break_slot_dtls\" id=\"p_o_break_slot_dtls\" value=\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\">\n\t<input type=\"hidden\" name=\"isSlotStartMidEndAppl\" id=\"isSlotStartMidEndAppl\" value=\"";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\">\n\t<!-- End ML-BRU-CRF-0628.1 -->\n\t\n";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\n\n<input type=\"hidden\" name=\"recall_time\" id=\"recall_time\" value=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\">\n\n<input type=\"hidden\" name=\"wtListControl\" id=\"wtListControl\" value=\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\">\n<input type=\"hidden\" name=\"waitListNo\" id=\"waitListNo\" value=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\">\n<input type=\"hidden\" name=\"rd_appt_yn\" id=\"rd_appt_yn\" value=\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\">\n\n<!--Below line Added for this CRF Bru-HIMS-CRF-191 [IN:030391]  -->\n<input type=\"hidden\" name=\"groupApptYN\" id=\"groupApptYN\" value=\"";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\">\n<input type=\"hidden\" name=\"group_check\" id=\"group_check\" value=\"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\">\n<input type=\"hidden\" name=\"entitlement_by_pat_cat_yn\" id=\"entitlement_by_pat_cat_yn\" value=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\">\n\n</form>\n<script>\n\t\n\t/* Added for ML-BRU-CRF-0628.1 */\n\tif (document.forms[0].isSlotStartMidEndAppl.value==\'true\'){\n\t\n\t\tvar ext_slt=document.forms[0].p_o_ext_slot_status.value;\n\t\tvar res_slt=document.forms[0].p_o_reserved_slot_dtls.value;\n\t\tvar appt_slt=document.forms[0].p_o_appt_slot_dtls.value;\n\t\tvar blk_slt=document.forms[0].p_o_block_slot_dtls.value;\n\t\tvar brk_slt=document.forms[0].p_o_break_slot_dtls.value;\n\n\n\t\tvar ext_slot_arr=ext_slt.split(\"|\");\n\t\tvar res_slot_arr=res_slt.split(\"|\");\n\t\tvar appt_slot_arr=appt_slt.split(\"|\");\n\t\tvar blk_slot_arr=blk_slt.split(\"|\");\n\t\tvar brk_slot_arr=brk_slt.split(\"|\");\n\n\n\t\tfor(var i=0;i<=ext_slot_arr.length;i++){\n\t\t\t\n\t\t\tif(ext_slot_arr[i]==\'Y\') {\n\n\t\t\t\tif(blk_slot_arr[i]==\'N\' && brk_slot_arr[i]==\'N\') {\n\t\t\t\t\tif(res_slot_arr[i] !=\'N\'){\n\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\'results1\').rows[i+1].cells[0].style.backgroundColor = \"Bisque\";\n\t\t\t\t\t\tdocument.getElementById(\'results1\').rows[i+1].cells[1].style.backgroundColor = \"Bisque\";\n\t\t\t\t\t\tdocument.getElementById(\'results1\').rows[i+1].cells[0].style.Color = \"Black\";\n\t\t\t\t\t\tdocument.getElementById(\'results1\').rows[i+1].cells[1].style.Color = \"Black\";\n\t\t\t\t\t\tdocument.getElementById(\'results1\').rows[i+1].cells[3].style.backgroundColor = \"Bisque\";\n\t\t\t\t\t\tdocument.getElementById(\'results1\').rows[i+1].cells[3].innerText = \"BRU Health Reservation : \"+res_slot_arr[i];\n\n\t\t\t\t\t}else {\n\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\'results1\').rows[i+1].cells[0].style.backgroundColor = \"Bisque\";\n\t\t\t\t\t\tdocument.getElementById(\'results1\').rows[i+1].cells[1].style.backgroundColor = \"Bisque\";\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\t\n\t\t\t}\n\t\t\t\t\n\t\t}\n\t}\n\t/* End ML-BRU-CRF-0628.1 */\n\t</script>\n\n";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\n\t<script>\n\t\tsetTimeout(\'vv()\',1000); \n\t\tfunction vv()\n\t\t{ \n\t\t\tparent.frames[0].document.getElementById(\'ss\').style.visibility=\'hidden\';\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t}\n\t\tvar error = getMessage(\'SCH_NOT_AVAILABLE_DAY\',\'OA\');\n\t\tparent.parent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+error ;\n\t</script>\n";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\n\n</body>\n\t\t\n</html>\n\n";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//out.println("sStyle==>" +sStyle);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

		Connection con = null;
		CallableStatement statement=null;
		CallableStatement statement_bru = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt_label		= null;
		PreparedStatement pstmt_access		= null;

		ResultSet rs = null; 
		ResultSet rs32= null;
		//Statement stmtsd=null;
		Statement stmt=null;
		PreparedStatement stmtps=null;
		Statement stmtn=null;
		ResultSet rsps=null;
		//Statement stmt_visit=null;
		//ResultSet rs_visit=null;
		String wrap_reqd="";
		wrap_reqd="nowrap";
		String temp=request.getQueryString();
		String curr_user_id=(String)session.getValue("login_user");
		String ref_id="";
		ref_id=(String) session.getValue("ref_id");
		if(ref_id==null) ref_id="N";
		String calling_mode=request.getParameter("callingMode");
	

		if(calling_mode==null) calling_mode="N";
		String blkStatus="";
		String blkRemark="";
		String book_appt_yn ="";                  
		String book_appt_wo_pid_yn="";            
		String obook_appt_yn ="";                 
		String book_appt_across_catg_yn  ="";     
		String tfr_appt_yn="";                    
		String tfr_appt_across_catg_yn="";        
		String canc_appt_yn  ="";  
		//String alcn_crit="";
		String sql_access="";
		String mode_find="";
		String inv_visit_mpq_from_ca_yn="";
		boolean allow_revise=true;
		int max_patient			=0;
		int total_booked		=0;
		String nowarp1 ="";
		//jit
		//String holdArr[]=new String[5];
		/*Above line commented and added for thic CRF GHL-CRF-0414*/
		String holdArr[]=new String[6];
		
		ArrayList arrLst=new ArrayList();
		String tmp_Hld_var="";
		String locale = (String)session.getAttribute("LOCALE");

		String TOTAL_NORMAL_TFR="";
		String TOTAL_BULK_TFR="";

		String global_locn_yn="";
		String param_alcn_check="";
		String today_date="";
		String wtListControl=request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");
		String waitListNo=request.getParameter("waitListNo")==null?"":request.getParameter("waitListNo");
		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
		String show_vip="N";
	//Below variable declare for this  [Bru-HIMS-CRF-177]
	//CheckStyle Violation Commented by Munisekhar
	//String colour_indicator="", visite_code="";
	  String colour_indicator="";
	  String max_patients_per_slab="";
	
	//Added for this CRF Bru-HIMS-CRF-191 [IN:030391]		
	 Statement stApptgroup=null;
	 ResultSet rsApptgroup=null;
	 String groupApptYN="";	
	 String entitlement_by_pat_cat_yn	= "";
	 int group_check=0;
	//End Bru-HIMS-CRF-191 [IN:030391]

		int order_clinic_count=	0; //this CRF Bru-HIMS-CRF-165.1 [IN:035659]	

	 boolean isIncRemarksLengthAppl = false;//Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058
	 String apptRemarks = "";
	 
	 boolean isVIPimgpatfrontappl = false;//Added by Mujafar against ML-MMOH-CRF-1070

	 //Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
	 boolean isOverBookingAppl = false;
	 String time_elapsed_yn = "";
	 int sch_cnt = 0;

	 //Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	 String schedule_extend_yn="N"; 

	 //Added by Ashwini on 24-Jun-2020 for PMG2020-MOHE-CRF-0001   
	 int future_slot_count = 0; 

	 //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	 Boolean isSlotStartMidEndAppl = false;
	 String p_o_ext_slot_status = "";
	 String p_o_reserved_slot_dtls = "";
	 String p_o_appt_slot_dtls = "";
	 String p_o_block_slot_dtls = "";
	 String p_o_break_slot_dtls = "";

//end
try
{
			con=ConnectionManager.getConnection(request);
              
            isIncRemarksLengthAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","INCREASE_APPT_REMARKS_LENGTH");//Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058	
			
			isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070
			
			isOverBookingAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","SCH_APPT_OVER_BOOKING");//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017

			isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

			//stmtsd=con.createStatement();
			stmtn=con.createStatement();
			ResultSet rsCA = null;
			ResultSet rset = null;
			Statement stmt_ca = con.createStatement();
			stmt= con.createStatement();
			String date1="";
			String date=(String)request.getParameter("Date");
			
			String mod=(String)request.getParameter("mod");
			if(mod ==null) mod ="";
			String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";
			String clinic_type=request.getParameter("clinic_type");
			String res_type=request.getParameter("res_type");
			String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
			String order_line_num=request.getParameter("order_line_num");
			if(order_line_num ==null) order_line_num="";
			String order_id=request.getParameter("order_id");
			String fcid=(String)session.getValue("facility_id");
			if(order_id ==null) order_id="";
			String order_catalog_code=request.getParameter("order_catalog_code");
			if(order_catalog_code ==null) order_catalog_code="";
			if (clinic_type==null) clinic_type = "C";
			if (res_type==null) res_type = "P";

			String decide=(String)request.getParameter("decide");
				if(decide == null || decide.equals("null")) decide="";

			String currdate=(String)request.getParameter("currdate");
			//String inv_visit_frm_ca="SELECT INV_VISITREGN_MPQ_FROM_CA_YN FROM op_param WHERE OPERATING_FACILITY_ID='"+fcid+"'";
String clinic_code=(String)request.getParameter("clinic_code"); 

			 /*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
            stApptgroup=con.createStatement();	
			//String oderclinicquery="select count(*) order_count_clinic from op_catalog_for_clinic a where a.facility_id='"+fcid+"' AND a.CLINIC_CODE='"+clinic_code+"'";
			//rsApptgroup=stApptgroup.executeQuery(oderclinicquery);
			String oderclinicquery="select count(*) order_count_clinic from op_catalog_for_clinic a where a.facility_id=? AND a.CLINIC_CODE=?";
			if(stmtps != null) stmtps.close();
			stmtps = con.prepareStatement(oderclinicquery);
			stmtps.setString(1,fcid);
			stmtps.setString(2,clinic_code);
			rsApptgroup = stmtps.executeQuery();
			if(rsApptgroup.next()) {
				order_clinic_count=rsApptgroup.getInt("order_count_clinic");
				
			}
			if(stApptgroup!=null) stApptgroup.close();
			if(rsApptgroup!=null) rsApptgroup.close();
         //End this CRF Bru-HIMS-CRF-165.1 [IN:035659]		

			/*Below line code Added for this CRF  Bru-HIMS-CRF-191 [IN:030391]*/
			
		
			
			stApptgroup=con.createStatement();	
			//String groupApptquery="select count(*) count_value from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and LOCN_CODE='"+clinic_code+"' and a.GROUP_ID=b.GROUP_ID";
			//rsApptgroup=stApptgroup.executeQuery(groupApptquery);
			String groupApptquery="select count(*) count_value from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and LOCN_CODE=? and a.GROUP_ID=b.GROUP_ID";
			if(stmtps != null) stmtps.close();
			stmtps = con.prepareStatement(groupApptquery);
			stmtps.setString(1,clinic_code);
			rsApptgroup = stmtps.executeQuery();
			if(rsApptgroup.next()) {
				group_check=rsApptgroup.getInt("count_value");
				
			}
			System.out.println("group_check==>"+group_check);
			if(stApptgroup!=null) stApptgroup.close();
			if(rsApptgroup!=null) rsApptgroup.close();
			
			//End Bru-HIMS-CRF-191 [IN:030391]		
			

			String inv_visit_frm_ca="select (SELECT INV_VISITREGN_MPQ_FROM_CA_YN FROM op_param WHERE OPERATING_FACILITY_ID='"+fcid+"')INV_VISITREGN_MPQ_FROM_CA_YN ,(select to_char(sysdate,'dd/mm/yyyy') system_date from dual)system_date,ALCN_CRITERIA,group_appt_yn,(select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP')ENTITLEMENT_BY_PAT_CAT_YN from oa_param where module_id='OA'";

			rset=stmtn.executeQuery(inv_visit_frm_ca);
			if(rset!=null && rset.next()){
				inv_visit_mpq_from_ca_yn=rset.getString("INV_VISITREGN_MPQ_FROM_CA_YN");
				today_date = rset.getString("system_date");
				param_alcn_check=rset.getString("ALCN_CRITERIA")==null?"":rset.getString("ALCN_CRITERIA");
				groupApptYN=rset.getString("group_appt_yn")==null?"":rset.getString("group_appt_yn");
				entitlement_by_pat_cat_yn	= rset.getString("entitlement_by_pat_cat_yn")==null?"":rset.getString("entitlement_by_pat_cat_yn");
			}
			if(rset!=null) rset.close();
			if(mod.equals("tfr"))
			{
				date = currdate;
				decide="Query";
			}	
			if(decide.equals("Query"))
	{
//date=DateUtils.convertDate(date,"DMY",locale,"en");
	}
			mode_find=(String)request.getParameter("mode_find");
			if(mode_find==null) mode_find="";
 String from_page=request.getParameter("from_page");
//out.println("from_page==>" +from_page);
if(from_page ==null) from_page="";

			//String inv_visit_mpq_from_ca_yn = request.getParameter("inv_visit_mpq_from_ca_yn")==null?"N":request.getParameter("inv_visit_mpq_from_ca_yn");

			String practitioner_id=(String)request.getParameter("practitioner_id");
				if( practitioner_id == null|| practitioner_id.equals("null")) practitioner_id="";
			String value12=(String)request.getParameter("value12");
				if( value12 == null || value12.equals("null")) value12="";
			String value13=(String)request.getParameter("value13");
			if( value13 == null || value13.equals("null"))  value13="";
			String facilityid=(String)session.getValue("facility_id");
			String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
			if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";

			String old_date=(String)request.getParameter("old_date");
				if(old_date  == null || old_date.equals("null")) old_date="";

			String old_from_time = request.getParameter("old_from_time");
				if( old_from_time == null) old_from_time="";

			String old_to_time = request.getParameter("old_to_time");
				if( old_to_time == null) old_to_time="";

			String ca_mode = request.getParameter("ca_mode");
			if(( ca_mode == null) || ca_mode.equals(""))  ca_mode="";
			String ca_patient_id=request.getParameter("ca_patient_id");
				if(ca_patient_id==null) ca_patient_id="";
//out.println("<script>alert('ca_mode :"+ca_mode+"')</script>");
//out.println("<script>alert('ca_patient_id :"+ca_patient_id+"')</script>");
			
			if(!ref_id.equals("N")){		
				session.putValue("ca_patient_id_new",ca_patient_id);
				String ca_patient_id_new=(String)session.getValue("ca_patient_id_new");
				if(ca_patient_id_new.equals(null) ||ca_patient_id_new ==null) ca_patient_id_new="";				
			}

			//Added by Suman
			String callingMode = request.getParameter("callingMode");
			if (callingMode==null) callingMode = "";
			
			String calling_mode_new=(String)session.getValue("callingMode_new");
			if(calling_mode_new ==null) calling_mode_new="";

			String oper_stn_id=request.getParameter("oper_stn_id");
			if(oper_stn_id == null) oper_stn_id="";
			if(oper_stn_id!=null && !oper_stn_id.equals("")){
				show_vip="Y";
			}
			String visit_limit_rule =request.getParameter("visit_limit_rule");
			if(visit_limit_rule == null) visit_limit_rule="";

			String slot_appt_ctrl   =request.getParameter("slot_appt_ctrl");
			if(slot_appt_ctrl == null) slot_appt_ctrl="";

			String alcn_criteria=request.getParameter("alcn_criteria");
			if(alcn_criteria == null || alcn_criteria.equals("null")) alcn_criteria="";	
			
			String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn");
			if(override_no_of_slots_yn ==null) override_no_of_slots_yn ="";
			
			String req_id=request.getParameter("req_id");
			if(req_id ==null) req_id="";

			String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="";

			String visit_flag_OP=request.getParameter("visit_flag_OP");
			if(visit_flag_OP==null) visit_flag_OP="N";	

			//Added by suman for getting the value from OP Checkout
		
	String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";

 String no_of_noshow_appts_for_alert =  request.getParameter("no_of_noshow_appts_for_alert");
  if(no_of_noshow_appts_for_alert ==null) no_of_noshow_appts_for_alert="";

String per_chk_for_no_show_alert    =   request.getParameter("per_chk_for_no_show_alert");
 if(per_chk_for_no_show_alert ==null) per_chk_for_no_show_alert="";



			String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn");
					String contact_num_reqd_yn= request.getParameter("contact_num_reqd_yn");
		if(contact_num_reqd_yn ==null) contact_num_reqd_yn="N"; 
			 String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
			 if(noshow_ctrl_by_splty_or_clinic ==null) noshow_ctrl_by_splty_or_clinic="";
			 String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
			 if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";
			String res_class_desc="";
	if(res_type.equals("P"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R"))
	{
   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O"))
	{
res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}

	/*	if(res_type.equals("P")){
			res_class_desc="Practitioner";
		}else if(res_type.equals("E")){
			res_class_desc="Equipment";
		}else if(res_type.equals("R")){
			res_class_desc="Room";
		}else if(res_type.equals("O")){
			res_class_desc="Others";
		}else if(res_type.equals("B")){
			res_class_desc="Bed";
		}*/
		String care_locn_ind_desc="";
		if(clinic_type.equals("C")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(clinic_type.equals("E")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(clinic_type.equals("D")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}
			// End of the addition	

		String P_O_CLINIC             ="";       
		String P_O_PRACTITIONER       ="";       
		String P_O_MAX_PAT            ="";       
		String P_O_MAX_OVER_BOOK      ="";
		String P_O_MAX_FORCED_BOOK    ="";
		String P_O_FORCED_BOOK		  =""; 	
		String P_O_MAX_GLOBAL_BOOK    ="";
		String P_O_GLOBAL_BOOK		  =""; 	
		String P_O_BOOKED             ="";       
		String P_O_OVER_BOOKED        ="";       
		String P_O_OVER_BOOKING       ="N";       
		String P_O_TIME_TAB_TYPE     ="";        
		String P_O_END_TIME= "";
		String P_O_MAX_SLOTS_FOR_FIRST_VISITS = "";
		String P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
		String P_O_MAX_FIRST_VISITS = "";
		String P_O_TOTAL_FIRST_VISIT = "";
		String P_O_OBVISIT_FLAG = "N";
		String P_O_MAX_SLOTS_PER_DAY="";
		String P_O_MAX_OTHER_VISITS="";
		String P_O_TOTAL_OTHER_VISITS="";
		String P_O_STATUS             ="";
		String P_O_FROM_TIME          ="";
		String P_O_TO_TIME            ="";
		String P_O_APPT_REF_NO        ="";
		String P_O_PATIENT_NAME       ="";
			String P_O_PATIENT_ID       ="";
			String P_LAST_APPT_BOOKED       ="";

			String P_O_VISIT_TYPE_CODE       ="";
			String P_O_REFERRAL_ID       ="";
			String P_O_CONTACT_REASON_CODE       ="";
			String P_O_ENCOUNTER_ID       ="";
			String P_O_SERVICE_CODE      ="";
			String P_O_pat_cat      ="";


			String P_O_VISIT_TYPE_IND     ="";
			String P_O_NO_OF_SLOTS= "";
			String P_O_Max_Forced= "";
			String P_O_Total_Forced= "";
			String P_O_Max_Global= "";
			String P_O_Total_Global= "";

			String sql="";
			String current_date="";
			String current_time="";
			String total_booked1="";
			//String max_patients_per_day="";

			String FORCED_BOOK_APPT_YN="";
			String GLOBAL_BOOK_APPT_YN="";
			PreparedStatement pstmtststus=null;
			ResultSet rsststus=null;
			Statement stmt_date= null;
			String P_APPT_OTH_DTL       ="";

			//ResultSet rs_date=null;
			//ResultSet rs_slot=null;
			//ResultSet rs_slab=null;
			//String sql2="";
			//String time_per_patient="";
			//int noslots =0;
			//int durtime=0;
			//int totaltm=0;
			//int max_pat_per_slab=0;
			//String inner_string = "";
			//String next_string = "";
			//String totm ="";
			//String totm1 = "";
			//String ftime2="";
			//String ttime2="";
			//int ftm1=0;
			//int ttm1=0;
			//int confirsttm=ftm1*60;
			//int totim = 0;
			//int totim1 =0;
			//int frmtime1 =0;
			//int mainfrmtm =0;
			//int totime1 = 0;
			//int maintotm = 0;
			//int dur = 0;
			//int dur1 = 0;
			//String COUNT_VAL="";
			//String sys_time="";
			//String sql1="";
			//String end_time_val="";
			String chk_frm_CA="";
			String clinic_type_frm_CA="";
			boolean normal_booking_allow_flag = true;
			String schedule_status="";

try{
	

		/*stmt_date=con.createStatement();

		rsCA = stmt_date.executeQuery("select to_char(sysdate,'dd/mm/yyyy') system_date from dual");

		if(rsCA !=null && rsCA.next())
		{
			today_date = rsCA.getString("system_date");
		}
		if(rsCA!=null)rsCA.close();		
		*/

		if(callingMode.equals("CA"))
		{
			//chk_frm_CA="select CARE_LOCN_TYPE_IND from op_clinic where clinic_code='"+clinic_code+"' and facility_id='"+facilityid+"'";
			//rsCA = stmt_ca.executeQuery(chk_frm_CA);
			chk_frm_CA="select CARE_LOCN_TYPE_IND from op_clinic where clinic_code=? and facility_id=? ";
			if(stmtps != null) stmtps.close();
			stmtps = con.prepareStatement(chk_frm_CA);
			stmtps.setString(1,clinic_code);
			stmtps.setString(2,facilityid);
			rsCA = stmtps.executeQuery();
			if(rsCA !=null && rsCA.next())
			{
				clinic_type_frm_CA=rsCA.getString("CARE_LOCN_TYPE_IND");
			}
			clinic_type=clinic_type_frm_CA;
		}
		//Allocation for the clinic
		
		/*String param_sql="select ALCN_CRITERIA from oa_param where module_id='OA'";
		if(rs!=null)rs.close();
		rs=stmt.executeQuery(param_sql);
		if(rs!=null && rs.next()){
			param_alcn_check=rs.getString("ALCN_CRITERIA")==null?"":rs.getString("ALCN_CRITERIA");
		}
		if(rs!=null)rs.close();
		*/
		if(!param_alcn_check.equals("")){
			StringBuffer clinic_alcn_sql=new StringBuffer();
			clinic_alcn_sql.append("select alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+clinic_code+"' AND ");
			if(practitioner_id.equals("")){
				clinic_alcn_sql.append("practitioner_id is null and");
			}else{
				clinic_alcn_sql.append("practitioner_id = '"+practitioner_id+"' and ");
			}
			clinic_alcn_sql.append("clinic_date=to_date('"+date+"','dd/mm/yyyy')");
			
			//NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+date+"','dd/mm/yyyy')";

		
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(clinic_alcn_sql.toString());
			clinic_alcn_sql=null;
			if(rs!=null && rs.next()){
				alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
			}
			if(rs!=null)rs.close();
		}else{
			alcn_criteria="";
		}
	
	/*if (slot_appt_ctrl.equals("P")){
		alcn_crit="select nvl(max_patients_per_day,0) max_patients_per_day, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked from oa_clinic_schedule  where facility_id='"+facilityid+"' and clinic_date =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"' and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id+"' ,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"'";


		rs = stmtsd.executeQuery(alcn_crit);
		
		if(rs !=null){
			while ( rs.next() ){
					max_patients_per_day= rs.getString("max_patients_per_day");
					if(max_patients_per_day ==null) max_patients_per_day="";
					total_booked1		= rs.getString("total_booked");
					if(total_booked1==null) total_booked1="";

			}
		
		}  
		if(rs !=null) rs.close();

		if (max_patients_per_day.equals(total_booked1))
			normal_booking_allow_flag=false;
	}
	*/

			sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=?  and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y') ";

		
			
			pstmt_access = con.prepareStatement(sql_access);
			
			pstmt_access.setString(1,facilityid);
			pstmt_access.setString(2,clinic_code);
			pstmt_access.setString(3,oper_stn_id);
			pstmt_access.setString(4,curr_user_id);

			rs = pstmt_access.executeQuery();



			if(rs !=null){
			while ( rs.next() )
			{
						book_appt_yn= rs.getString("book_appt_yn");
						if(book_appt_yn ==null) book_appt_yn="";
						book_appt_wo_pid_yn= rs.getString("book_appt_wo_pid_yn");
						if(book_appt_wo_pid_yn==null) book_appt_wo_pid_yn="";
						obook_appt_yn= rs.getString("obook_appt_yn");
						if(obook_appt_yn ==null) obook_appt_yn="";
						book_appt_across_catg_yn= rs.getString("book_appt_across_catg_yn");
						if(book_appt_across_catg_yn ==null) book_appt_across_catg_yn="";
						tfr_appt_yn= rs.getString("tfr_appt_yn");
						if(tfr_appt_yn==null) tfr_appt_yn="";
						tfr_appt_across_catg_yn= rs.getString("tfr_appt_across_catg_yn");
						if(tfr_appt_across_catg_yn ==null) tfr_appt_across_catg_yn="";
						canc_appt_yn= rs.getString("canc_appt_yn");
						if(canc_appt_yn ==null) canc_appt_yn="";
						FORCED_BOOK_APPT_YN= rs.getString("FORCED_BOOK_APPT_YN");
						if(FORCED_BOOK_APPT_YN ==null) FORCED_BOOK_APPT_YN="";
						GLOBAL_BOOK_APPT_YN = rs.getString("GLOBAL_BOOK_APPT_YN");
						if(GLOBAL_BOOK_APPT_YN ==null) GLOBAL_BOOK_APPT_YN="";
						global_locn_yn= rs.getString("global_locn_yn");
						if(global_locn_yn ==null) global_locn_yn="N";
			}
			}
		if(rs !=null) rs.close();


	/*String sqlStat="SELECT NVL(Schedule_status,'A') Schedulestatus,Remarks FROM OA_CLINIC_SCHEDULE WHERE Facility_id=? AND clinic_date=TO_DATE(?,'dd/mm/yyyy') AND clinic_code=? AND nvl(practitioner_id,'x')=nvl(?,'x') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"'";

	pstmtststus=con.prepareStatement(sqlStat);
	pstmtststus.setString( 1, facilityid);
	pstmtststus.setString( 2, date);
	pstmtststus.setString( 3, clinic_code);
	pstmtststus.setString( 4, practitioner_id);

	rsststus = pstmtststus.executeQuery();
	if(rsststus !=null && rsststus.next())
	{
		blkStatus= rsststus.getString("Schedulestatus");
		blkRemark=rsststus.getString("Remarks");
	} */

//if(rsststus !=null) rsststus.close();




	StringBuffer  sql_label =new StringBuffer();
	
	//sql_label.append("select OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'))  practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked,  to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit, nvl(total_first_visit,0) total_first_visit, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits, nvl(max_first_visits,0) max_first_visits, nvl(max_slots_per_day,0) max_slots_per_day, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, nvl(total_first_visits_blocked,0) total_first_visits_blocked, nvl(total_other_visits_blocked,0) total_other_visits_blocked ,NVL(Schedule_status,'A') Schedulestatus,Remarks, to_char(sysdate,'dd/mm/yyyy') current_date,to_char(sysdate,'hh24:mi') current_time, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR,nvl(schedule_status,'O') schedule_status,nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked_count  from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"'  and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'");

	sql_label.append("select OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,?,'1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'))  practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked,  to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit, nvl(total_first_visit,0) total_first_visit, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits, nvl(max_first_visits,0) max_first_visits, nvl(max_slots_per_day,0) max_slots_per_day, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, nvl(total_first_visits_blocked,0) total_first_visits_blocked, nvl(total_other_visits_blocked,0) total_other_visits_blocked ,NVL(Schedule_status,'A') Schedulestatus,Remarks, to_char(sysdate,'dd/mm/yyyy') current_date,to_char(sysdate,'hh24:mi') current_time, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR,nvl(schedule_status,'O') schedule_status,nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked_count,max_patients_per_slab,SCHEDULE_EXTEND_YN  from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=?  and care_locn_type_ind =? and resource_class=? and ");
	
	if(practitioner_id.equals("")){
		sql_label.append("practitioner_id is null ");
	}else{
		sql_label.append("practitioner_id = ?");
	}
	

		pstmt_label = con.prepareStatement(sql_label.toString());

		pstmt_label.setString(1,locale);
		pstmt_label.setString(2,locale);
		pstmt_label.setString(3,locale);
		pstmt_label.setString(4,locale);
		pstmt_label.setString(5,locale);
		pstmt_label.setString(6,facilityid);
		pstmt_label.setString(7,date);
		pstmt_label.setString(8,clinic_code);
		pstmt_label.setString(9,clinic_type);
		pstmt_label.setString(10,res_type);
		if(!practitioner_id.equals("")){
			pstmt_label.setString(11,practitioner_id);
		}

		rs32 = pstmt_label.executeQuery();
		sql_label=null;

		if( rs32 !=null && rs32.next() ){

					P_O_CLINIC			= rs32.getString("clinic_name");
					P_O_PRACTITIONER 	= rs32.getString("practitioner_name");
					if( P_O_PRACTITIONER == null) P_O_PRACTITIONER=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Notidentified.label","oa_labels");
					P_O_MAX_PAT 		= rs32.getString("max_patients_per_day");
					P_O_TIME_TAB_TYPE    = rs32.getString("time_table_type" );   
					P_O_MAX_OVER_BOOK   =rs32.getString("max_over_booking" );        
					if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
					
					P_O_MAX_FORCED_BOOK  =rs32.getString("MAX_FORCED_IN_BOOKING");
					if(P_O_MAX_FORCED_BOOK==null)P_O_MAX_FORCED_BOOK="";
					P_O_FORCED_BOOK	=rs32.getString("TOTAL_FORCED_IN_BOOKED");
					if(P_O_FORCED_BOOK==null)P_O_FORCED_BOOK="";

					P_O_MAX_GLOBAL_BOOK  =rs32.getString("MAX_GLOBAL_BOOKING");
					if(P_O_MAX_GLOBAL_BOOK==null)P_O_MAX_GLOBAL_BOOK="";
					P_O_GLOBAL_BOOK	=rs32.getString("TOTAL_GLOBAL_BOOKED");
					if(P_O_GLOBAL_BOOK==null)P_O_GLOBAL_BOOK="";
					blkStatus= rs32.getString("Schedulestatus");
					if(blkStatus ==null) blkStatus="";
					blkRemark=rs32.getString("Remarks");
					if(blkRemark ==null) blkRemark="";

					P_O_BOOKED          =rs32.getString("total_slots_booked" );   
					if( P_O_BOOKED ==null) P_O_BOOKED="";
					P_O_OVER_BOOKED        =rs32.getString( "total_slots_overbooked" );    
					if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
					P_O_TO_TIME                  =rs32.getString("start_time" );	
					if(P_O_TO_TIME == null) P_O_TO_TIME="";
					P_O_END_TIME = rs32.getString("end_time"); 
					if( P_O_END_TIME == null) P_O_END_TIME="";	

					TOTAL_NORMAL_TFR=rs32.getString("TOTAL_NORMAL_TFR");
					if(TOTAL_NORMAL_TFR ==null) TOTAL_NORMAL_TFR="0";

					TOTAL_BULK_TFR=rs32.getString("TOTAL_BULK_TFR");
					if(TOTAL_BULK_TFR ==null) TOTAL_BULK_TFR="0";

					

					P_O_MAX_SLOTS_FOR_FIRST_VISITS = rs32.getString("max_slots_for_first_visit"); 
					if( P_O_MAX_SLOTS_FOR_FIRST_VISITS == null) P_O_MAX_SLOTS_FOR_FIRST_VISITS="";
					P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED= rs32.getString("total_first_visit_slots_booked"); 
					if( P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED == null) P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
					P_O_MAX_FIRST_VISITS = rs32.getString("max_first_visits"); 
					if( P_O_MAX_FIRST_VISITS == null) P_O_MAX_FIRST_VISITS="";
					P_O_TOTAL_FIRST_VISIT = rs32.getString("total_first_visit"); 
					if( P_O_TOTAL_FIRST_VISIT == null) P_O_TOTAL_FIRST_VISIT="";

					P_O_MAX_OTHER_VISITS = rs32.getString("max_other_visits"); 
					if( P_O_MAX_OTHER_VISITS == null) P_O_MAX_OTHER_VISITS="";
					P_O_TOTAL_OTHER_VISITS = rs32.getString("total_other_visits"); 
					if( P_O_TOTAL_OTHER_VISITS == null) P_O_TOTAL_OTHER_VISITS="";
					P_O_MAX_SLOTS_PER_DAY= rs32.getString("max_slots_per_day"); 
					if( P_O_MAX_SLOTS_PER_DAY== null) P_O_MAX_SLOTS_PER_DAY="";
					current_date=rs32.getString("current_date");
					if(current_date ==null) current_date="";
					current_time=rs32.getString("current_time");
					if(current_time ==null) current_time="";

					total_booked1		= rs32.getString("total_booked_count");					
					if(total_booked1==null) total_booked1="";
					
					max_patients_per_slab		= rs32.getString("max_patients_per_slab");
					if(max_patients_per_slab==null) max_patients_per_slab="";
			
					if (slot_appt_ctrl.equals("P")){

						if (P_O_MAX_PAT.equals(total_booked1))
							normal_booking_allow_flag=false;
					}

					if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("P"))

					P_O_BOOKED = String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(P_O_TOTAL_OTHER_VISITS)+Integer.parseInt(rs32.getString("total_first_visits_blocked"))+Integer.parseInt(rs32.getString("total_other_visits_blocked")));

					P_O_TOTAL_FIRST_VISIT   = String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(rs32.getString("total_first_visits_blocked")));
					P_O_TOTAL_OTHER_VISITS  = String.valueOf(Integer.parseInt(P_O_TOTAL_OTHER_VISITS)+Integer.parseInt(rs32.getString("total_other_visits_blocked")));

					schedule_status=rs32.getString("schedule_status");
					if(schedule_status ==null) schedule_status="";

					schedule_extend_yn=rs32.getString("schedule_extend_yn");
					if(schedule_extend_yn==null) schedule_extend_yn="N";

					

					
					

					
			
			// to be removed as there is no relation of Overbooking with time for a current day schedule

			/*if(P_O_TIME_TAB_TYPE.equals("1")){

					sql1="select count(1) count ,to_char(sysdate,'hh24:mi')sys_date from dual where sysdate > =to_date('"+date+" "+P_O_TO_TIME+"','dd/mm/yyyy hh24:mi')";
					rs_date=stmt_date.executeQuery(sql1);


						if(rs_date !=null && rs_date.next()){
							COUNT_VAL=rs_date.getString("count");
							sys_time=rs_date.getString("sys_date");
								
						}


					sql2= "select to_char(TIME_PER_PATIENT,'hh24:mi') TIME_PER_PATIENT from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"'  and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id+"' ,'X') and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'";

					
					rs_slot=stmt_date.executeQuery(sql2);
					if(rs_slot !=null  && rs_slot.next()){
						time_per_patient=rs_slot.getString("TIME_PER_PATIENT");
					}



						if (rs_slot !=null) rs_slot.close();

			}else {
					if(P_O_TIME_TAB_TYPE.equals("2"))		{
						if(rs_date !=null)rs_date.close();
						sql1="select count(1) count,to_char(sysdate,'hh24:mi')sys_date from dual where sysdate >=to_date('"+date+" "+P_O_END_TIME+"','dd/mm/yyyy hh24:mi')";
						rs_date=stmt_date.executeQuery(sql1);

						if(rs_date !=null && rs_date.next()){
							COUNT_VAL=rs_date.getString("count");
							sys_time=rs_date.getString("sys_date");
						}

						sql2= "select TO_CHAR (TIME_PER_SLAB, 'hh24:mi') TIME_PER_SLAB,MAX_PATIENTS_PER_SLAB from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"' and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id+"' ,'X') and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'";
						rs_slab=stmt_date.executeQuery(sql2);
						
						if(rs_slab !=null  && rs_slab.next()) 	{
							time_per_patient=rs_slab.getString("TIME_PER_SLAB");
							max_pat_per_slab=rs_slab.getInt("MAX_PATIENTS_PER_SLAB");
						}
						//out.println("sql2 :" +sql2);
						if(rs_slab !=null)rs_slab.close();
						sql2= "SELECT  to_char(SLOT_SLAB_END_TIME,'hh24:mi')  end_time FROM oa_clinic_schedule_slot_slab WHERE facility_id = '"+facilityid+"'  AND CLINIC_DATE = TO_DATE ('"+date+"', 'dd/mm/yyyy')  AND clinic_code = '"+clinic_code+"'  AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', 'X') AND care_locn_type_ind = '"+clinic_type+"' AND resource_class ='"+res_type+"' AND to_char(SLOT_SLAB_END_TIME,'hh24:mi') <= to_char(sysdate,'hh24:mi')";
						rs_slab=stmt_date.executeQuery(sql2);
						//out.println("sql2 1:" +sql2);
						if(rs_slab !=null  )			{
							while ( rs_slab.next())				{
								end_time_val=rs_slab.getString("end_time");
							}

						}
							sys_time=end_time_val;

					}else{

						if(P_O_TIME_TAB_TYPE.equals("3")){
							String	et=P_O_END_TIME;
							boolean b=false,result=false;
							String from_time1="";
							String end_time1="";
							stmt=con.createStatement();
							String qry="SELECT to_char(APPT_SLAB_FROM_TIME,'hh24:mi') start_time,to_char(APPT_SLAB_TO_TIME,'hh24:mi') end_time,to_char(sysdate,'hh24:mi') FROM oa_appt WHERE facility_id = '"+facilityid+"'   AND appt_date = TO_DATE ('"+date+"', 'dd/mm/yyyy')   AND clinic_code = '"+clinic_code+"'   AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', 'X')   AND care_locn_type_ind = '"+clinic_type+"'   AND resource_class = '"+res_type+"'   AND to_char(APPT_SLAB_FROM_TIME,'hh24:mi') >= to_char(sysdate,'hh24:mi')";
							rs=stmt.executeQuery(qry);
							b=rs.next();

				
							while(b){
								end_time1=rs.getString("end_time");
								b=rs.next();
								if (!b) break; 
								from_time1=rs.getString("start_time");
								if (end_time1.equals(from_time1)){
									result=true;
								}else{
									result=false;
									break;
								}
							}

							if (result && end_time1.equals(et) ) {
								P_O_OVER_BOOKING         ="Y";
								P_O_OBVISIT_FLAG		 ="F";
							}else{
							}
						}
					}
			}
		//sys_time="10:50";
		StringTokenizer duration = new StringTokenizer(sys_time, ":");
			if(duration.hasMoreTokens())
			{
				 inner_string = duration.nextToken();
				 next_string = duration.nextToken();
				
				 dur = Integer.parseInt(inner_string);
				 dur1 = Integer.parseInt(next_string);
					

				StringTokenizer duration2 = new StringTokenizer(P_O_END_TIME, ":");
				if(duration2.hasMoreTokens())
				{
					 totm = duration2.nextToken();
					 totm1 = duration2.nextToken();
					 totim = Integer.parseInt(totm);
					 totim1 = Integer.parseInt(totm1);


					 frmtime1 = dur*60;
					 mainfrmtm = frmtime1+dur1;
					 totime1 = totim*60;
					 maintotm = totime1+totim1;

					durtime = maintotm - mainfrmtm;

			
					StringTokenizer duration3 = new StringTokenizer(time_per_patient, ":");
					if(duration3.hasMoreTokens())
					{
						 ftime2=duration3.nextToken();
						 ttime2=duration3.nextToken();

						 ftm1=Integer.parseInt(ftime2);
						 ttm1=Integer.parseInt(ttime2);


						 confirsttm=ftm1*60;
						 totaltm = confirsttm + ttm1;


						 noslots = durtime/totaltm;

					}	
				}
			}
			int total_slots=0;
		 
		if(P_O_TIME_TAB_TYPE.equals("2")){
			total_slots = noslots*max_pat_per_slab;
		}
		*/

		// end the  removal part
		
		//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
		time_elapsed_yn = eOA.OACommonBean.getTimeElapsedYN(con,P_O_END_TIME,current_time);
		sch_cnt = eOA.OACommonBean.getScheduleCount(con,clinic_code,practitioner_id,facilityid,P_O_TO_TIME);
		
		if(isOverBookingAppl)
		{
			if(("1").equals(P_O_TIME_TAB_TYPE) || ("2").equals(P_O_TIME_TAB_TYPE))
			{
				if(!("Y").equals(P_O_OVER_BOOKING))
				{
					if(date.equals(current_date))
					{
						if(("Y").equals(time_elapsed_yn))
						{
							if(Integer.parseInt(P_O_OVER_BOOKED) < Integer.parseInt(P_O_MAX_OVER_BOOK))
							{
								P_O_OVER_BOOKING = "Y";
							}
						}else
						{
							if(sch_cnt > 0)
							{
								//Added by Ashwini on 24-Jun-2020 for PMG2020-MOHE-CRF-0001
								future_slot_count = eOA.OACommonBean.getFutureSlotCount(con,clinic_code,practitioner_id,facilityid,P_O_TO_TIME,P_O_END_TIME);
								
								if(future_slot_count == 0)
								{
									if(Integer.parseInt(P_O_OVER_BOOKED) < Integer.parseInt(P_O_MAX_OVER_BOOK))
									{
										P_O_OVER_BOOKING = "Y";
									}
								}
							}
						}
					}
				}
			}
		}

		if (!visit_limit_rule.equals("N"))	{
						
				if(! P_O_MAX_FIRST_VISITS.equals("") &&  !P_O_TOTAL_FIRST_VISIT.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))	{

						if (Integer.parseInt(P_O_MAX_FIRST_VISITS) <= Integer.parseInt(P_O_TOTAL_FIRST_VISIT)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)&&Integer.parseInt(P_O_MAX_FIRST_VISITS)>0){
								
								P_O_OVER_BOOKING         ="Y";
								P_O_OBVISIT_FLAG		 ="F";
						}
				}
						
				if(! P_O_MAX_OTHER_VISITS.equals("") &&  !P_O_TOTAL_OTHER_VISITS.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals("")){
								
						if (Integer.parseInt(P_O_MAX_OTHER_VISITS) <= Integer.parseInt(P_O_TOTAL_OTHER_VISITS)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)&&Integer.parseInt(P_O_MAX_OTHER_VISITS)>0){
									P_O_OVER_BOOKING         ="Y";
									if(P_O_OBVISIT_FLAG.equals("F"))
										P_O_OBVISIT_FLAG		 ="A";
									else
										P_O_OBVISIT_FLAG		 ="O";

						}
				}			
		}
				
		if(! P_O_MAX_PAT.equals("") &&  !P_O_BOOKED.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))	{
					
				if (Integer.parseInt(P_O_MAX_PAT) == Integer.parseInt(P_O_BOOKED)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)){
							P_O_OVER_BOOKING         ="Y";
							P_O_OBVISIT_FLAG		 ="A";
				}

				// to be removed as there is no relation of Overbooking with time for a current day schedule
				/*if(COUNT_VAL.equals("1")){

						if(noslots == Integer.parseInt(P_O_BOOKED) &&  P_O_TIME_TAB_TYPE.equals("1") && Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED))	{

							P_O_OVER_BOOKING         ="Y";
							P_O_OBVISIT_FLAG		 ="A";
						}
						
						if(P_O_TIME_TAB_TYPE.equals("2") && total_slots == Integer.parseInt(P_O_BOOKED) && Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) )	{
							P_O_OVER_BOOKING         ="Y";
							P_O_OBVISIT_FLAG		 ="A";
						}
						
				}*/

					
		}
}

String  over_booked_label="";
over_booked_label=P_O_OVER_BOOKING;

if(blkStatus.equals("B")){
	P_O_OVER_BOOKING="N";
}
	if(rs32 !=null) rs32.close();
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	if(P_O_MAX_PAT==null || P_O_MAX_PAT.equals(""))
{
		date1=DateUtils.convertDate(date,"DMY","en",locale);
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(date1));
            _bw.write(_wl_block11Bytes, _wl_block11);
if(decide!=null && decide.equals("Query"))
	{
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
}else{
	if( P_O_CLINIC.length() !=0) {
	  
	/*Below line added for this CRF ML-MMOH-CRF-0606*/
	  String Tablewidth="100%";	  
	  if(mod!=null && mod.equals("tfr")) {
			Tablewidth="108%";
	  }	 
	//End this CRF ML-MMOH-CRF-0606
	
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Tablewidth));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(P_O_CLINIC ));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!alcn_criteria.equals("")){ 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
if(decide.equals("Query")){
			}else{
				if(mod!=null && mod.equals("tfr")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{
						if(P_O_OVER_BOOKING.equals("Y") && global_locn_yn.equals("N")){
							
							if((calling_mode.equals("")) || (((calling_mode).equals("OP") || (calling_mode).equals("OP_RV"))&& (ref_id.equals("N"))) || (calling_mode.equals("CA") || (calling_mode.equals("OR")))) {
								
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
 } 
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
}	
			}
		}
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(P_O_PRACTITIONER ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Tablewidth));
            _bw.write(_wl_block35Bytes, _wl_block35);
if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block49Bytes, _wl_block49);
if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(P_O_MAX_SLOTS_PER_DAY));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(P_O_MAX_PAT));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block51Bytes, _wl_block51);
if(P_O_MAX_FIRST_VISITS.equals("0")){
            _bw.write(_wl_block52Bytes, _wl_block52);
}else{
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(P_O_MAX_FIRST_VISITS));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block56Bytes, _wl_block56);
if(P_O_MAX_OTHER_VISITS.equals("0")){
            _bw.write(_wl_block52Bytes, _wl_block52);
}else{
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(P_O_MAX_OTHER_VISITS));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(P_O_MAX_OVER_BOOK));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(P_O_MAX_GLOBAL_BOOK));
            _bw.write(_wl_block59Bytes, _wl_block59);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(P_O_MAX_FORCED_BOOK));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(P_O_BOOKED));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(P_O_TOTAL_FIRST_VISIT));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(P_O_TOTAL_OTHER_VISITS));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(P_O_OVER_BOOKED));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(P_O_GLOBAL_BOOK));
            _bw.write(_wl_block41Bytes, _wl_block41);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(P_O_FORCED_BOOK));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(TOTAL_NORMAL_TFR));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(TOTAL_BULK_TFR));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
 if(isIncRemarksLengthAppl){ 
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
 } 
            _bw.write(_wl_block82Bytes, _wl_block82);

		
if(decide.equals("Query"))
{ 
nowarp1="nowrap";

            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

}


            _bw.write(_wl_block87Bytes, _wl_block87);
}
}
	System.err.println("<-------------------------------DisplayResults.jsp------------------------------->");
	System.err.println("Before execute oa_external_slots_BRU---in Param---facilityid-->"+facilityid+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  date-->"+date);

	/* Added for ML-BRU-CRF-0628.1 */
	if(isSlotStartMidEndAppl){
		cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");
		cstmt.setString( 1, facilityid );
		cstmt.setString( 2, clinic_code );
		cstmt.setString( 3, practitioner_id );
		cstmt.setString( 4, date );
		cstmt.registerOutParameter( 5, Types.VARCHAR );
		cstmt.registerOutParameter( 6, Types.VARCHAR );
		cstmt.registerOutParameter( 7, Types.VARCHAR );
		cstmt.registerOutParameter( 8, Types.VARCHAR );
		cstmt.registerOutParameter( 9, Types.VARCHAR );

		cstmt.execute() ;

		System.err.println("After execute oa_external_slots_BRU---in Param---facilityid-->"+facilityid+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  date-->"+date);

		p_o_ext_slot_status = cstmt.getString( 5 ); 
		if(p_o_ext_slot_status == null) p_o_ext_slot_status = "";
		
		p_o_reserved_slot_dtls = cstmt.getString( 6 );
		if(p_o_reserved_slot_dtls == null) p_o_reserved_slot_dtls = "";

		p_o_appt_slot_dtls = cstmt.getString( 7 );
		if(p_o_appt_slot_dtls == null) p_o_appt_slot_dtls = "";

		p_o_block_slot_dtls = cstmt.getString( 8 );
		if(p_o_block_slot_dtls == null) p_o_block_slot_dtls = "";

		p_o_break_slot_dtls = cstmt.getString( 9 );
		if(p_o_break_slot_dtls == null) p_o_break_slot_dtls = "";
	}

	if(isSlotStartMidEndAppl && P_O_TIME_TAB_TYPE.equals("2") && !max_patients_per_slab.equals("1")){
		
		System.err.println("Before execute oa_slabs_BRU---in Param---facilityid-->"+facilityid+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  date-->"+date);

		statement_bru = con.prepareCall("{call oa_slabs_BRU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

		statement_bru.setString( 1, facilityid);
		statement_bru.setString( 2, clinic_code);
		statement_bru.setString( 3, practitioner_id);
		statement_bru.setString( 4, date);
		statement_bru.registerOutParameter( 5, Types.CLOB );
		statement_bru.registerOutParameter( 6, Types.CLOB );
		statement_bru.registerOutParameter( 7, Types.CLOB );
		statement_bru.registerOutParameter( 8, Types.CLOB );
		statement_bru.registerOutParameter( 9, Types.CLOB );
		statement_bru.registerOutParameter(10, Types.CLOB );
		statement_bru.registerOutParameter(11, Types.CLOB );
		statement_bru.registerOutParameter(12, Types.CLOB );
		statement_bru.registerOutParameter(13, Types.CLOB );
		statement_bru.registerOutParameter(14, Types.CLOB );
		statement_bru.registerOutParameter(15, Types.CLOB );
		statement_bru.registerOutParameter(16, Types.CLOB );
		statement_bru.registerOutParameter(17, Types.CLOB );
		statement_bru.registerOutParameter(18, Types.CLOB );
		statement_bru.registerOutParameter(19, Types.CLOB );
		statement_bru.registerOutParameter(20, Types.CLOB );
		statement_bru.registerOutParameter(21, Types.CLOB );
		statement_bru.registerOutParameter(22, Types.CLOB );
		statement_bru.registerOutParameter(23, Types.CLOB );
		statement_bru.registerOutParameter(24, Types.CLOB );
		statement_bru.registerOutParameter(25, Types.CLOB );
		statement_bru.registerOutParameter(26, Types.CLOB );

		statement_bru.execute() ;

		

		P_O_Max_Forced = P_O_MAX_FORCED_BOOK;

		P_O_Total_Forced = P_O_FORCED_BOOK;

		P_O_Max_Global = P_O_MAX_GLOBAL_BOOK;
			
		P_O_Total_Global = P_O_GLOBAL_BOOK;

		P_O_STATUS = statement_bru.getString(6); 
		if( P_O_STATUS == null) P_O_STATUS="";

		P_O_APPT_REF_NO = statement_bru.getString(7); 
		if( P_O_APPT_REF_NO == null) P_O_APPT_REF_NO="";

		P_O_PATIENT_NAME = statement_bru.getString(8); 
		if( P_O_PATIENT_NAME == null) P_O_PATIENT_NAME="";

		tmp_Hld_var = statement_bru.getString(9); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[0]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(10); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[1]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(12); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[2]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(17); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[3]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(13); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[4]=tmp_Hld_var;

		P_O_VISIT_TYPE_IND = statement_bru.getString(14); 
		if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
		holdArr[5]=P_O_VISIT_TYPE_IND;

		P_O_PATIENT_ID = statement_bru.getString(15); 
		if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

		P_LAST_APPT_BOOKED = statement_bru.getString(16); 
		if( P_LAST_APPT_BOOKED == null) P_LAST_APPT_BOOKED="";

		P_O_VISIT_TYPE_CODE = statement_bru.getString(11); 
		if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";

		P_O_REFERRAL_ID = statement_bru.getString(18); 
		if( P_O_REFERRAL_ID == null) P_O_REFERRAL_ID="";

		P_O_CONTACT_REASON_CODE = statement_bru.getString(19); 
		if( P_O_CONTACT_REASON_CODE == null) P_O_CONTACT_REASON_CODE="";

		P_O_ENCOUNTER_ID = statement_bru.getString(20); 
		if( P_O_ENCOUNTER_ID == null) P_O_ENCOUNTER_ID="";

		P_O_SERVICE_CODE = statement_bru.getString(21); 
		if( P_O_SERVICE_CODE == null) P_O_SERVICE_CODE="";

		P_APPT_OTH_DTL = statement_bru.getString(22); 
		if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

		P_O_pat_cat = statement_bru.getString(23); 
		if( P_O_pat_cat == null) P_O_pat_cat="";

		P_O_FROM_TIME = statement_bru.getString(24);     
		if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

		P_O_TO_TIME = statement_bru.getString(25);	
		if(P_O_TO_TIME == null) P_O_TO_TIME="";

		P_O_NO_OF_SLOTS = statement_bru.getString(26); 
		if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";
	}else{
	/* End ML-BRU-CRF-0628.1 */
	
	System.err.println("Before execute get_day_status---in Param---facilityid-->"+facilityid+"  date-->"+date+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  clinic_type-->"+clinic_type+"  res_type-->"+res_type);

	statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");


	statement.setString( 1, facilityid);
	statement.setString( 2, date);
	statement.setString( 3, clinic_code);
	statement.setString( 4, practitioner_id);
	statement.setString( 5, clinic_type);
	statement.setString( 6, res_type);


	statement.registerOutParameter(7, Types.VARCHAR );
	statement.registerOutParameter(8, Types.VARCHAR );
	
	/*statement.registerOutParameter(7, Types.CLOB );
	statement.registerOutParameter(8, Types.CLOB );
	*/
	statement.registerOutParameter(9, Types.INTEGER);
	statement.registerOutParameter(10, Types.INTEGER);
	statement.registerOutParameter(11, Types.INTEGER);
	statement.registerOutParameter(12, Types.INTEGER);

	statement.registerOutParameter(13, Types.VARCHAR );
	statement.registerOutParameter(14, Types.VARCHAR );
	statement.registerOutParameter(15, Types.VARCHAR );
	statement.registerOutParameter(16, Types.VARCHAR );
	statement.registerOutParameter(17, Types.VARCHAR );
	statement.registerOutParameter(18, Types.VARCHAR );
	statement.registerOutParameter(19, Types.VARCHAR );
	statement.registerOutParameter(20, Types.VARCHAR );
	statement.registerOutParameter(21, Types.VARCHAR );
	statement.registerOutParameter(22, Types.VARCHAR );
	statement.registerOutParameter(23, Types.VARCHAR );
	statement.registerOutParameter(24 ,Types.VARCHAR );
	statement.registerOutParameter(25 ,Types.VARCHAR );
	statement.registerOutParameter(26 ,Types.VARCHAR );
	statement.registerOutParameter(27 ,Types.VARCHAR );
	statement.registerOutParameter(28 ,Types.VARCHAR );
	statement.registerOutParameter(29 ,Types.VARCHAR );
	statement.registerOutParameter(30 ,Types.VARCHAR );
	statement.registerOutParameter(31 ,Types.VARCHAR );
	statement.registerOutParameter(32 ,Types.VARCHAR );
	statement.registerOutParameter(33 ,Types.VARCHAR );	
	
	/*statement.registerOutParameter(13, Types.CLOB );
	statement.registerOutParameter(14, Types.CLOB );
	statement.registerOutParameter(15, Types.CLOB );
	statement.registerOutParameter(16, Types.CLOB );
	statement.registerOutParameter(17, Types.CLOB );
	statement.registerOutParameter(18, Types.CLOB );
	statement.registerOutParameter(19, Types.CLOB );
	statement.registerOutParameter(20, Types.CLOB );
	statement.registerOutParameter(21, Types.CLOB );
	statement.registerOutParameter(22, Types.CLOB );
	statement.registerOutParameter(23, Types.CLOB );
	statement.registerOutParameter(24 ,Types.CLOB );
	statement.registerOutParameter(25 ,Types.CLOB );
	statement.registerOutParameter(26 ,Types.CLOB );
	statement.registerOutParameter(27 ,Types.CLOB );
	statement.registerOutParameter(28 ,Types.INTEGER );
	statement.registerOutParameter(29 ,Types.INTEGER);
	statement.registerOutParameter(30 ,Types.INTEGER );
	statement.registerOutParameter(31 ,Types.INTEGER );
	statement.registerOutParameter(32 ,Types.CLOB );
	statement.registerOutParameter(33 ,Types.CLOB );	
	*/
	statement.setString(34, locale);

	statement.registerOutParameter(35 ,Types.VARCHAR );
	statement.registerOutParameter(36 ,Types.VARCHAR );
	statement.registerOutParameter(37 ,Types.VARCHAR );
	statement.registerOutParameter(38 ,Types.VARCHAR );
	statement.registerOutParameter(39 ,Types.VARCHAR );
	statement.registerOutParameter(40 ,Types.VARCHAR );
	statement.registerOutParameter(41 ,Types.VARCHAR );

	/*statement.registerOutParameter(35 ,Types.CLOB );
	statement.registerOutParameter(36 ,Types.CLOB );
	statement.registerOutParameter(37 ,Types.CLOB );
	statement.registerOutParameter(38 ,Types.CLOB );
	statement.registerOutParameter(39 ,Types.CLOB );
	statement.registerOutParameter(40 ,Types.CLOB );
	*/


	statement.execute() ;

	System.err.println("After execute get_day_status---in Param---facilityid-->"+facilityid+"  date-->"+date+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  clinic_type-->"+clinic_type+"  res_type-->"+res_type);

	System.err.println("<--------DisplayResults.jsp----1506---->");

	P_O_CLINIC=statement.getString( 7 ); 
	if(P_O_CLINIC == null) P_O_CLINIC="";

	P_O_PRACTITIONER=statement.getString( 8 ); 
	if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";

	P_O_MAX_PAT=statement.getString( 9 ); 
	if(P_O_MAX_PAT == null) P_O_MAX_PAT="";

	P_O_MAX_OVER_BOOK     =statement.getString( 10 );        
	if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";

	P_O_BOOKED                 =statement.getString(11 );   
	if( P_O_BOOKED ==null) P_O_BOOKED="";

	P_O_OVER_BOOKED        =statement.getString( 12 );    
	if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";

	P_O_OVER_BOOKING        =statement.getString( 13 );
	if(P_O_OVER_BOOKING == null) P_O_OVER_BOOKING="";

	P_O_TIME_TAB_TYPE          =statement.getString( 14 );
	if(P_O_TIME_TAB_TYPE == null) P_O_TIME_TAB_TYPE="";

	P_O_STATUS                    =statement.getString(15);
	if(P_O_STATUS == null) P_O_STATUS="";

	P_O_FROM_TIME            =statement.getString( 16 );     
	if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

	P_O_TO_TIME              =statement.getString( 17 );	
	if(P_O_TO_TIME == null) P_O_TO_TIME="";

	P_O_APPT_REF_NO         =statement.getString(18 );     
	if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";

	P_O_PATIENT_NAME        =statement.getString( 19 );     
	if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";

	tmp_Hld_var                       =statement.getString( 20 );	
	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[0]=tmp_Hld_var;

	tmp_Hld_var                    =statement.getString( 21 );
	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[1]=tmp_Hld_var;

	tmp_Hld_var    =statement.getString( 22 );     
	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[2]=tmp_Hld_var;

	tmp_Hld_var                =statement.getString( 23 );	
	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[3]=tmp_Hld_var;

	tmp_Hld_var       =statement.getString( 24 );	
	if(tmp_Hld_var == null) tmp_Hld_var="";
	holdArr[4]=tmp_Hld_var;

	P_O_END_TIME = statement.getString(25); 
	if( P_O_END_TIME == null) P_O_END_TIME="";

	P_O_VISIT_TYPE_IND = statement.getString(26); 
	if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
	holdArr[5]=P_O_VISIT_TYPE_IND; //Added for this CRF GHL-CRF-0414

	P_O_NO_OF_SLOTS = statement.getString(27); 
	if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

	P_O_Max_Forced=statement.getString(28); 
	if( P_O_Max_Forced == null) P_O_Max_Forced="";

	P_O_Total_Forced=statement.getString(29); 
	if( P_O_Total_Forced == null) P_O_Total_Forced="";

	P_O_Max_Global=statement.getString(30);
	if( P_O_Max_Global == null) P_O_Max_Global="";

	P_O_Total_Global=statement.getString(31); 
	if( P_O_Total_Global == null) P_O_Total_Global="";

	P_O_PATIENT_ID=statement.getString(32); 
	if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

	P_LAST_APPT_BOOKED=statement.getString(33); 
	if( P_LAST_APPT_BOOKED == null) P_LAST_APPT_BOOKED="";

	P_O_VISIT_TYPE_CODE = statement.getString(35);
	if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";

	P_O_REFERRAL_ID = statement.getString(36); 
	if( P_O_REFERRAL_ID == null) P_O_REFERRAL_ID="";

	P_O_CONTACT_REASON_CODE = statement.getString(37);
	if( P_O_CONTACT_REASON_CODE == null) P_O_CONTACT_REASON_CODE="";

	P_O_ENCOUNTER_ID = statement.getString(38); 
	if( P_O_ENCOUNTER_ID == null) P_O_ENCOUNTER_ID="";

	P_O_SERVICE_CODE = statement.getString(39); 
	if( P_O_SERVICE_CODE == null) P_O_SERVICE_CODE="";

	P_APPT_OTH_DTL= statement.getString(40); 
	if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

	P_O_pat_cat= statement.getString(41); 
	if( P_O_pat_cat == null) P_O_pat_cat="";
	
	}

	System.err.println("P_O_CLINIC-------->"+P_O_CLINIC);
	System.err.println("P_O_PRACTITIONER-------->"+P_O_PRACTITIONER);
	System.err.println("P_O_MAX_PAT-------->"+P_O_MAX_PAT);
	System.err.println("P_O_MAX_OVER_BOOK-------->"+P_O_MAX_OVER_BOOK);
	System.err.println("P_O_BOOKED-------->"+P_O_BOOKED);
	System.err.println("P_O_OVER_BOOKED-------->"+P_O_OVER_BOOKED);
	System.err.println("P_O_OVER_BOOKING-------->"+P_O_OVER_BOOKING);
	System.err.println("P_O_TIME_TAB_TYPE-------->"+P_O_TIME_TAB_TYPE);
	System.err.println("P_O_STATUS-------->"+P_O_STATUS);
	System.err.println("P_O_FROM_TIME-------->"+P_O_FROM_TIME);
	System.err.println("P_O_TO_TIME-------->"+P_O_TO_TIME);
	System.err.println("P_O_APPT_REF_NO-------->"+P_O_APPT_REF_NO);
	System.err.println("P_O_PATIENT_NAME-------->"+P_O_PATIENT_NAME);
	System.err.println("holdArr[0]-------->"+holdArr[0]);
	System.err.println("holdArr[1]-------->"+holdArr[1]);
	System.err.println("holdArr[2]-------->"+holdArr[2]);
	System.err.println("holdArr[3]-------->"+holdArr[3]);
	System.err.println("holdArr[4]-------->"+holdArr[4]);	
	System.err.println("P_O_END_TIME-------->"+P_O_END_TIME);
	System.err.println("holdArr[5]-------->"+holdArr[5]);
	System.err.println("P_O_NO_OF_SLOTS-------->"+P_O_NO_OF_SLOTS);
	System.err.println("P_O_Max_Forced-------->"+P_O_Max_Forced);
	System.err.println("P_O_Total_Forced-------->"+P_O_Total_Forced);
	System.err.println("P_O_Max_Global-------->"+P_O_Max_Global);
	System.err.println("P_O_Total_Global-------->"+P_O_Total_Global);
	System.err.println("P_O_PATIENT_ID-------->"+P_O_PATIENT_ID);
	System.err.println("P_LAST_APPT_BOOKED-------->"+P_LAST_APPT_BOOKED);
	System.err.println("P_O_VISIT_TYPE_CODE-------->"+P_O_VISIT_TYPE_CODE);
	System.err.println("P_O_REFERRAL_ID-------->"+P_O_REFERRAL_ID);
	System.err.println("P_O_CONTACT_REASON_CODE-------->"+P_O_CONTACT_REASON_CODE);
	System.err.println("P_O_ENCOUNTER_ID-------->"+P_O_ENCOUNTER_ID);
	System.err.println("P_O_SERVICE_CODE-------->"+P_O_SERVICE_CODE);
	System.err.println("P_APPT_OTH_DTL-------->"+P_APPT_OTH_DTL);
	System.err.println("P_O_pat_cat-------->"+P_O_pat_cat);

	System.err.println("<--------DisplayResults.jsp----1653---->");

			StringTokenizer token = new StringTokenizer(P_O_FROM_TIME, "|");
			int counter=token.countTokens();

			String from_time[]=new String[counter];
			int track=0;
			while (token.hasMoreTokens())
				{
				from_time[track]=token.nextToken();
				track++;
				}
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_TO_TIME, "|");

			String to_time[]=new String[counter];
			String end_time ="";
			int tot_token= token.countTokens();
			
			while (token.hasMoreTokens())
			{
				end_time=token.nextToken();

				if(schedule_extend_yn.equals("Y") && P_O_TIME_TAB_TYPE.equals("1")) { // to handle last slot for extended

					if (tot_token-track == 1) {					
						end_time="00:00";
					}
				}
				
				to_time[track]=end_time;

				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_NAME, "|");
			String patient_name[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_name[track]=token.nextToken();
				track++;
				}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_ID, "|");
			String patient_id[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_id[track]=token.nextToken();
				track++;
				}
			for(int ij=0;ij<holdArr.length;ij++){
				token=null;
				track=0;
				String popArr[]=new String[counter];
				token = new StringTokenizer(holdArr[ij], "|");

				while (token.hasMoreTokens()){
					popArr[track]=token.nextToken();
					track++;
				}
				 arrLst.add(popArr);				 
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_APPT_REF_NO, "|");
			String o_appt_ref_no[]=new String[counter];
			while (token.hasMoreTokens())
			{
			o_appt_ref_no[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;

			token = new StringTokenizer(P_APPT_OTH_DTL, "|");
			String appt_ot_dtl[]=new String[counter];
			
			while (token.hasMoreTokens())
			{
			appt_ot_dtl[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;

			token = new StringTokenizer(P_O_STATUS, "|");
			String status[]=new String[counter];
			String status1[]=new String[counter];
			while (token.hasMoreTokens())
			{
			status[track]=token.nextToken();
			status1[track]=status[track];
			track++;
			}
			
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_IND, "|");
			String visit_type_ind[]=new String[counter];
			while (token.hasMoreTokens())
			{
			visit_type_ind[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_LAST_APPT_BOOKED, "|");
			String last_appt_booked[]=new String[counter];
			while (token.hasMoreTokens())
			{
			last_appt_booked[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
			String no_of_slots[]=new String[counter];
			while (token.hasMoreTokens())
			{
			no_of_slots[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			
			token = new StringTokenizer(P_O_VISIT_TYPE_CODE, "|");			
			String visit_type_code[]=new String[counter];
			
			while (token.hasMoreTokens())
			{
				visit_type_code[track]=token.nextToken();
				track++;
			}
			
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_REFERRAL_ID, "|");
			String referral_id[]=new String[counter];
			while (token.hasMoreTokens())
			{
				referral_id[track]=token.nextToken();
				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_CONTACT_REASON_CODE, "|");
			String contact_reason_code[]=new String[counter];
			while (token.hasMoreTokens())
			{
				contact_reason_code[track]=token.nextToken();
				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_ENCOUNTER_ID, "|");
			String encounter_id[]=new String[counter];
			while (token.hasMoreTokens())
			{
				encounter_id[track]=token.nextToken();
				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_SERVICE_CODE, "|");
			String service_code[]=new String[counter];
			while (token.hasMoreTokens())
			{
				service_code[track]=token.nextToken();
				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_pat_cat, "|");
			String pat_cat[]=new String[counter];
			while (token.hasMoreTokens())
			{
				pat_cat[track]=token.nextToken();
				track++;
			}

	if(mode_find !=null && mode_find.equals("revise")){
			if(date !=null && date.equals(old_date)){
				allow_revise=true;
			}
			else{
				if(max_patient!=0){
				if(max_patient==total_booked){
					if(tfr_appt_across_catg_yn!=null && tfr_appt_across_catg_yn.equalsIgnoreCase("N")){
					allow_revise=false;
					
            _bw.write(_wl_block88Bytes, _wl_block88);

					}
					else{
            _bw.write(_wl_block89Bytes, _wl_block89);
allow_revise=true;
					}
				}
				}
				else
				{
				allow_revise=true;
				}
			}
		}		
		if(allow_revise){

            _bw.write(_wl_block90Bytes, _wl_block90);

 /*Below Code Added for this CRF [Bru-HIMS-CRF-177] */  
        java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,facilityid); 
	//CheckStyle Violation Commented by Munisekhar	
//Statement stmt1=null;
//ResultSet color_ind_rs=null;	
//String colour_indicator_query=""; 
//String colour_indicator_code1="";
//String visite_code1=""; 
//String visitcode="";
				
		
int maxval=0; String appt_ref_assign_value="";
for (int maxchk = 0; maxchk < o_appt_ref_no.length; maxchk++) 
{
   appt_ref_assign_value=o_appt_ref_no[maxchk];   
   if(!appt_ref_assign_value.equals("~")){
       while(Integer.parseInt(appt_ref_assign_value)>maxval)
       { 
          maxval=Integer.parseInt(appt_ref_assign_value);
       }
   } 
}

// End [Bru-HIMS-CRF-177] 
String classValue="";
int slots = 0;
String same_appt = "N";
String pat_name = "";
for(int init=0;init<counter;init++)
{
    /*Added by Thamizh selvi on 11th July 2018 against ML-MMOH-CRF-1058 Start*/
	if(isIncRemarksLengthAppl && !o_appt_ref_no[init].equals(""))
		apptRemarks		= eOA.OACommonBean.getApptRemarks(con,fcid,o_appt_ref_no[init]);	
	/*End*/

	/*
	String encounter_id = "";	

	String sql_visit="select ENCOUNTER_ID from oa_appt where facility_id = '"+facilityid+"' and  appt_ref_no='"+o_appt_ref_no[init]+"'";

	stmt_visit = con.createStatement();
	rs_visit = stmt_visit.executeQuery(sql_visit);

	if(rs_visit!=null&&rs_visit.next())
	{
		encounter_id = rs_visit.getString("ENCOUNTER_ID");
	}	

	*/


same_appt = "N";

if( !(no_of_slots[init].equals("~")) && (Integer.parseInt(no_of_slots[init]) > 1) ) 
{
	slots = Integer.parseInt(no_of_slots[init]);
	pat_name = patient_name[init];

}

if ( init % 2 == 0 )
		classValue = "OAQRYEVEN" ;
			else
		classValue = "OAQRYODD" ;
if(last_appt_booked[init].equals("Y")){

classValue = "OA_EMERGENT" ;
}
            _bw.write(_wl_block91Bytes, _wl_block91);

String u=from_time[init];
String z=status[init];
String z1=status1[init];

String visit_registered_yn="N";

if( z.equals("VT") || z.equals("VT*F"))
	visit_registered_yn="Y";
else
	visit_registered_yn="N";

String reason ="";
String reason1=z.substring(0,2);
if( z.length() > 2)
	reason=z.substring(2,z.length());
else
	reason="";
z=reason1;


String chk_blank_row_patient=patient_name[init];
/*
OL --BOOKED
VT --VISITED
VL --OVER-BOOKED
BN --Block
FL --FREE
*/
if(decide.equals("Query"))
{  
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")){
				if(chk_blank_row_patient.equals("~"))
					{ 
					if(slots > 0)
					 {
            _bw.write(_wl_block92Bytes, _wl_block92);
 if(blkStatus.equals("B")){
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block99Bytes, _wl_block99);
 } else { 
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( u));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block104Bytes, _wl_block104);
 } 
            _bw.write(_wl_block92Bytes, _wl_block92);

							slots--;
						same_appt = "Y";
							}
							else
							{
								if(blkStatus.equals("B")){
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block106Bytes, _wl_block106);
}else{
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block106Bytes, _wl_block106);
}
							}
					}
			else
					{

					{
            _bw.write(_wl_block108Bytes, _wl_block108);
if(z1.equals("OL*F")){
						if(blkStatus.equals("B")){
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block111Bytes, _wl_block111);
}else{
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block111Bytes, _wl_block111);
}
            _bw.write(_wl_block114Bytes, _wl_block114);
}else{
						
							if(blkStatus.equals("B")){
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block104Bytes, _wl_block104);
}else{
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block108Bytes, _wl_block108);
pat_name = patient_name[init];
						slots--;
					}
					
					}


		}
	else if (z.equals("RN")){
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block119Bytes, _wl_block119);
}else
			if (z.equals("VT")){
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block119Bytes, _wl_block119);
} else { 
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(u));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block122Bytes, _wl_block122);
 }

}
else
{
	if( ! u .equals("~")) //u represents from_time
	{
			if(z.equals("FL") || z.equals("OL") || z.equals("VL")||z.equals("VT"))
		{
			if(!(mode_find.equals("revise")) || mode_find.equals(""))
			{
				if(chk_blank_row_patient.equals("~"))
					{ 
						if(book_appt_yn.equalsIgnoreCase("Y"))
						{
							if(slots > 0)
							{
            _bw.write(_wl_block123Bytes, _wl_block123);
if(blkStatus.equals("B")){
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block126Bytes, _wl_block126);
}else{
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block128Bytes, _wl_block128);
}
            _bw.write(_wl_block123Bytes, _wl_block123);
slots--;
								same_appt = "Y";
							}
							else
							{
					          if (z.equals("VT"))
								{
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block130Bytes, _wl_block130);
}
							   else{
								    if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block132Bytes, _wl_block132);
}
									else{
										if(blkStatus.equals("B")){
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block133Bytes, _wl_block133);
}else{
										/*Below line Added for this CRF  Bru-HIMS-CRF-191 [IN:030391]*/										
										if(P_O_TIME_TAB_TYPE.equals("2") && groupApptYN.equals("Y") && group_check>0  && callingMode.equals("") && (from_page.equals("") || from_page.equals("schedule_appt"))){
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(u));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block138Bytes, _wl_block138);
//End this CRF  Bru-HIMS-CRF-191 [IN:030391]
												}else{
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(u));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block138Bytes, _wl_block138);
}}
									}
								   
							   }
							}
						}
						else 
						{
							if(book_appt_yn!=null && book_appt_yn.equalsIgnoreCase("N"))
							{
								if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block142Bytes, _wl_block142);
}else{
									if(blkStatus.equals("B")){
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block144Bytes, _wl_block144);
}else{
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block128Bytes, _wl_block128);
}
								}
							}
						}
					}
					else
					{
                      if (z.equals("VT"))
						{
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(u));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block148Bytes, _wl_block148);
}
					  else
						{
							if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(u));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block150Bytes, _wl_block150);
}else{
								if(blkStatus.equals("B")){
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block152Bytes, _wl_block152);
}else{
            _bw.write(_wl_block153Bytes, _wl_block153);
if(z1.equals("OL*F")){ 
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(u));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block128Bytes, _wl_block128);
}else if(z1.equals("OL*")){
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(u));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block159Bytes, _wl_block159);
}else if(z1.equals("OL*M")){
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(u));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block162Bytes, _wl_block162);
}else{
            _bw.write(_wl_block163Bytes, _wl_block163);
if(z.equals("VL")){
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(u));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block164Bytes, _wl_block164);
}else{
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(u));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block164Bytes, _wl_block164);
}
            _bw.write(_wl_block165Bytes, _wl_block165);
}
            _bw.write(_wl_block123Bytes, _wl_block123);
}
							}
						}
						pat_name = patient_name[init];
						slots--;

					}
			}
			else
			{
					if(chk_blank_row_patient.equals("~"))
					{
						if (z.equals("FL")&&(!normal_booking_allow_flag)){
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( u));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block148Bytes, _wl_block148);
}else{
							if(blkStatus.equals("B")){
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u));
            _bw.write(_wl_block168Bytes, _wl_block168);
}else{
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf( u));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block150Bytes, _wl_block150);
}
						}
					}
					else
					{
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf( u));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block171Bytes, _wl_block171);
}
		   	}
		}
		else 
		{
			if(z.equals("RN"))
			{
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(u));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block122Bytes, _wl_block122);
}	
			else
			{
				if(z.equals("BN"))
				{
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf( u));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block179Bytes, _wl_block179);
}	
				else
				{
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( u));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block179Bytes, _wl_block179);
}
			}
		}
	}
	else
	{
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(init));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block119Bytes, _wl_block119);
}
}
String u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

if( ! u1 .equals("~"))
{
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT"))
	{
		if(blkStatus.equals("B")){
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(blkRemark));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block185Bytes, _wl_block185);
}else{
            _bw.write(_wl_block186Bytes, _wl_block186);
if(z1.equals("OL*F")){
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block188Bytes, _wl_block188);
}else{
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block190Bytes, _wl_block190);
}
            _bw.write(_wl_block191Bytes, _wl_block191);
}
            _bw.write(_wl_block192Bytes, _wl_block192);
}
	else
	if(z.equals("RN"))
	{
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block193Bytes, _wl_block193);
}
	else
	if(z.equals("BN"))
	{
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(u1));
            _bw.write(_wl_block193Bytes, _wl_block193);
}
}
else{
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block197Bytes, _wl_block197);
}

String dispArr1[]=(String []) arrLst.get(0);
String dispArr2[]=(String []) arrLst.get(1);

String dispArr3[]=(String []) arrLst.get(2);
//String dispArr4[]=(String []) arrLst.get(3);
String dispArr4[]=(String []) arrLst.get(4);

String contact_reason = dispArr3[init];
String contact = dispArr4[init];
//String visit_type = dispArr4[init];

	

String u31=dispArr1[init];
String u32=dispArr2[init];



String u2=patient_name[init];
String pat_id=patient_id[init];
String pat_id_regn = "";
if(pat_id.equals("~"))
{
	pat_id="";
}
else
{
	pat_id_regn = pat_id;
	pat_id=pat_id+" , ";
}

webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
patdata.setFacility_id(fcid);

String isInpatient = patdata.CheckInPatient(con,patient_id[init],fcid);
if(isInpatient.equals("CURRENTLY_IN_PATIENT")) {
	
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block199Bytes, _wl_block199);

}
else
{
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block201Bytes, _wl_block201);

}

if(!decide.equals("Query"))
	{

	if( ! u2 .equals("~")){
		
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
					
			
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block203Bytes, _wl_block203);

			if(inv_visit_mpq_from_ca_yn.equals("Y") && from_page.equals("ca_appt_dairy") && ca_patient_id.equals("") )
			{
				if(date.equals(today_date))
				{
					if(visit_registered_yn.equals("N"))
					{
					
					
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(pat_id_regn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(referral_id[init]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(u));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(visit_type_code[init]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(contact_reason_code[init]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(contact_reason));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(service_code[init]));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block206Bytes, _wl_block206);

					}
					else if(visit_registered_yn.equals("Y"))
					{
					
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(encounter_id[init]));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block206Bytes, _wl_block206);

					}
				}
				else
				{
					
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block108Bytes, _wl_block108);

				}
			}
			else
			{
			
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block186Bytes, _wl_block186);

			}
			
            _bw.write(_wl_block210Bytes, _wl_block210);
 if(isVIPimgpatfrontappl){if(pat_cat[init].equals("V") && show_vip.equals("Y")){
            _bw.write(_wl_block211Bytes, _wl_block211);
}}
            out.print( String.valueOf(u2));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(u32));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(u31));
            _bw.write(_wl_block213Bytes, _wl_block213);
 if(!isVIPimgpatfrontappl){if(pat_cat[init].equals("V") && show_vip.equals("Y")){
            _bw.write(_wl_block211Bytes, _wl_block211);
}}
            _bw.write(_wl_block214Bytes, _wl_block214);
}else	{
			if(same_appt.equals("Y")){
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block216Bytes, _wl_block216);
}else{
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block218Bytes, _wl_block218);
}
		}
	}else{
		if(same_appt.equals("Y")){
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(pat_name));
            _bw.write(_wl_block185Bytes, _wl_block185);
}	else{
			if(z.equals("BN")){
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block221Bytes, _wl_block221);
}else{
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block223Bytes, _wl_block223);
}
			
		}
	}	
	}else
	{	 //Below code added for SKR-CRF-PAS-OA-002 [IN:028086] on 10.07.2011 by Suresh M
		String deceasedYN = "N";		
		if(!pat_id_regn.equals("")){
			sql="select deceased_yn from mp_patient where patient_id = ?";			
			stmtps=con.prepareStatement(sql);
			stmtps.setString(1,pat_id_regn);
			rsps=stmtps.executeQuery();
			if ( rsps != null && rsps.next()){	
					deceasedYN=rsps.getString("deceased_yn");									
			}
			if (stmtps !=null) stmtps.close();
			if (rsps !=null) rsps.close();			
		}
		// Ends SKR-CRF-PAS-OA-002 
		if( ! u2 .equals("~")){
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block186Bytes, _wl_block186);
 if(isVIPimgpatfrontappl){if(pat_cat[init].equals("V") && show_vip.equals("Y")){
            _bw.write(_wl_block211Bytes, _wl_block211);
}}
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(u2));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(u32));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(u31));
            _bw.write(_wl_block46Bytes, _wl_block46);
 if(deceasedYN.equals("Y") && !pat_id_regn.equals("")){
            _bw.write(_wl_block226Bytes, _wl_block226);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block227Bytes, _wl_block227);
}
            _bw.write(_wl_block186Bytes, _wl_block186);
 if(!isVIPimgpatfrontappl){if(pat_cat[init].equals("V") && show_vip.equals("Y")){
            _bw.write(_wl_block211Bytes, _wl_block211);
}}
            _bw.write(_wl_block185Bytes, _wl_block185);
}else	{
			if(same_appt.equals("Y")){
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block216Bytes, _wl_block216);
}else{
            _bw.write(_wl_block229Bytes, _wl_block229);
}
		}
	}else{
		if(same_appt.equals("Y")){
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(pat_name));
            _bw.write(_wl_block185Bytes, _wl_block185);
}	else{
			if(z.equals("BN")){
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block221Bytes, _wl_block221);
}else{
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block223Bytes, _wl_block223);
}
			
		}
	}
	}
// code opt by Jith
for(int kkk=2;kkk<arrLst.size();kkk++){
	int kkk1=0;
	if(kkk==2){
		kkk1=3;
	}else if(kkk==3) {
		kkk1=2;
	}else{
		kkk1=kkk;
	}
	
	/*Above line commented and below line added for this CRF GHL-CRF-0414*/
	/*int kkk1=0;
	if(kkk==2){
		kkk1=3;
	}else if(kkk==3) {
		kkk1=4;
	}else if(kkk==4) {
		kkk1=2;
	}else{
		kkk1=kkk;
	}*/	
	//End GHL-CRF-0414
	
	String dispArr[]=(String []) arrLst.get(kkk1);

	String u3=dispArr[init];
	
	
if(!decide.equals("Query"))
	{
	if( ! u3 .equals("~"))	{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
		  		
		//Below line added for this CRF GHL-CRF-0414
	    String visit_ind_code="",visit_type_indcator="";
		
		// Below "IF" conditions Added for this CRF [Bru-HIMS-CRF-177] 
		  if(kkk1==3){ 
		   String retval=checkForNull(visit_type_code[init]);		   
		 
		   colour_indicator =(String)hm.get(retval);
			
			   if(colour_indicator==null ||colour_indicator.equals("null"))colour_indicator="";	
             
                if(colour_indicator.equals("") && last_appt_booked[init].equals("Y")){
			      colour_indicator="ORANGE";
                  } 
				  
				 
           /*Below line added for this CRF GHL-CRF-0414*/
			//String visit_type_indcator="";
            visit_ind_code=checkForNull(visit_type_ind[init]);	
			if(visit_ind_code.equals("F"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
			if(visit_ind_code.equals("L"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
			if(visit_ind_code.equals("R"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			if(visit_ind_code.equals("E"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			if(visit_ind_code.equals("S"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
			if(visit_ind_code.equals("C"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
	       //End GHL-CRF-0414 
			             				
         /*Below line modified for this CRF End GHL-CRF-0414*/      	 
		
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(colour_indicator));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf( u3));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(visit_type_indcator));
            _bw.write(_wl_block239Bytes, _wl_block239);
 }if(kkk1==2){
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf( u3));
            _bw.write(_wl_block239Bytes, _wl_block239);
}
		}else{
            _bw.write(_wl_block241Bytes, _wl_block241);
}
		
	}else{
	      /*Below line modified with from 16 to 12 for this CRF End GHL-CRF-0414*/
		   
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block243Bytes, _wl_block243);
}
	}else {
		if( ! u3 .equals("~"))	{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
		
		//Below line added for this CRF GHL-CRF-0414
	    String visit_ind_code="",visit_type_indcator="";
		
		 // Below "IF" conditions Added for this CRF [Bru-HIMS-CRF-177] 
		   if(kkk1==3){  
              String retval=checkForNull(visit_type_code[init]);		     
		       colour_indicator =(String)hm.get(retval);			  
			   if(colour_indicator==null ||colour_indicator.equals("null"))colour_indicator="";	
              			   
			 if(colour_indicator.equals("") && last_appt_booked[init].equals("Y")){
			    colour_indicator="ORANGE";
			   }
			   
			   
			 /*Below line added for this CRF GHL-CRF-0414*/
			//String visit_type_indcator="";
            visit_ind_code=checkForNull(visit_type_ind[init]);	
			if(visit_ind_code.equals("F"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
			if(visit_ind_code.equals("L"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
			if(visit_ind_code.equals("R"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			if(visit_ind_code.equals("E"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			if(visit_ind_code.equals("S"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
			if(visit_ind_code.equals("C"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
	       //End GHL-CRF-0414 	
			
		/*Below line modified and with also changed from 12 to 6 for this CRF End GHL-CRF-0414*/	 
		
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(colour_indicator));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf( u3));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(nowarp1));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(visit_type_indcator));
            _bw.write(_wl_block239Bytes, _wl_block239);
}if(kkk1==2){
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf( u3));
            _bw.write(_wl_block239Bytes, _wl_block239);
}
		}else{
            _bw.write(_wl_block241Bytes, _wl_block241);
}
	}else{
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block246Bytes, _wl_block246);
}
	}
            _bw.write(_wl_block1Bytes, _wl_block1);
}
   if(!contact.equals("~")){
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(contact));
            _bw.write(_wl_block248Bytes, _wl_block248);

   }
// end JIth

String tmp_ref_no=o_appt_ref_no[init];
String oth_dtls=appt_ot_dtl[init];
int sec_cnt=0;
String showpatInstructionsYN="N";
String showprocInstructionsYN="N";

String showInstructionsYN="N";



StringTokenizer tmp_oth_dtl = new StringTokenizer(oth_dtls, "*");
while (tmp_oth_dtl.hasMoreTokens())	{
	sec_cnt=Integer.parseInt(tmp_oth_dtl.nextToken());
	if(!tmp_oth_dtl.nextToken().equals("0")){
		showpatInstructionsYN="Y";
	}else{
		showpatInstructionsYN="N";
	}

	if(!tmp_oth_dtl.nextToken().equals("0")){
		showprocInstructionsYN="Y";
	}else{
		showprocInstructionsYN="N";
	}
	
}
if(showpatInstructionsYN.equals("Y")){
	showInstructionsYN="Y";
}else{
	if(showprocInstructionsYN.equals("Y")){
		showInstructionsYN="Y";
	}
}
if(tmp_ref_no.equals("~")) tmp_ref_no="";

/*if(!tmp_ref_no.equals("")){
	sql="select count(appt_ref_no) count from oa_resource_for_appt where appt_ref_no = '"+tmp_ref_no+"' and FACILITY_ID='"+facilityid+"'";
		stmtps=con.prepareStatement(sql);
		rsps=stmtps.executeQuery();
		if ( rsps != null && rsps.next()){	
				sec_cnt=rsps.getInt("count");	
			
		}
}
if (stmtps !=null) stmtps.close();
if (rsps !=null) rsps.close();
*/
if(!decide.equals("Query"))
	{
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block250Bytes, _wl_block250);
if(sec_cnt>0){
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block252Bytes, _wl_block252);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);
}
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block255Bytes, _wl_block255);
if(!tmp_ref_no.equals("") && order_clinic_count>0){
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(z));
            _bw.write(_wl_block252Bytes, _wl_block252);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block257Bytes, _wl_block257);
}else{ 
            _bw.write(_wl_block46Bytes, _wl_block46);
} 
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(init));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(init));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block260Bytes, _wl_block260);
/*Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start*/
	if(isIncRemarksLengthAppl){ 
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block255Bytes, _wl_block255);
if(!("").equals(apptRemarks)){
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block263Bytes, _wl_block263);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block257Bytes, _wl_block257);
}else{ 
            _bw.write(_wl_block46Bytes, _wl_block46);
} 
            _bw.write(_wl_block193Bytes, _wl_block193);
 } 
	/*End*/
	}else {
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block250Bytes, _wl_block250);
if(sec_cnt>0){
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block252Bytes, _wl_block252);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);
}
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block266Bytes, _wl_block266);
}
//The following code is for "Appointment for a Resource" function
if(decide.equals("Query")){ 
	/*
	ResultSet qsRs=null;
	String sql4="select *  from oa_appt_pat_instructions where facility_id='"+facilityid+"' and appt_ref_no='"+o_appt_ref_no[init]+"'";

	qsRs = stmtsd.executeQuery(sql4);
	if ( qsRs != null ){
		if(qsRs!=null && qsRs.next()){	
			showInstructionsYN="Y";					
		}
	}
	if(qsRs !=null)qsRs.close();
	if(showInstructionsYN.equals("N")){
		sql4="select *  from oa_appt_proc_instructions where facility_id='"+facilityid+"' and appt_ref_no='"+o_appt_ref_no[init]+"'";
		qsRs = stmtsd.executeQuery(sql4);
		if ( qsRs != null ){
			if(qsRs!=null && qsRs.next()){	
				showInstructionsYN="Y";					
			}
		}
		if(qsRs !=null)qsRs.close();
	}
	*/
	
            _bw.write(_wl_block192Bytes, _wl_block192);

		if(!(o_appt_ref_no[init].equals("~"))){
		// Issue Fix Against Incident Number : 34667 Below local query Column Name Changed from modified_by_id to added_by_id
		sql="select added_by_id, to_char(modified_date,'dd/mm/yyyy hh24:mi') mod_date from oa_appt where facility_id = ? and  appt_ref_no=?";
		stmtps=con.prepareStatement(sql);
		stmtps.setString(1,facilityid);
		stmtps.setString(2,o_appt_ref_no[init]);
		rsps=stmtps.executeQuery();
		while(rsps.next()){
			String mod_date=rsps.getString("mod_date");
			mod_date=DateUtils.convertDate(mod_date,"DMYHM","en",locale);
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(rsps.getString("added_by_id")));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block269Bytes, _wl_block269);
if(showInstructionsYN.equals("Y")){
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block271Bytes, _wl_block271);
}
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(mod_date));
            _bw.write(_wl_block185Bytes, _wl_block185);
}	
	}else{
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block269Bytes, _wl_block269);
if(showInstructionsYN.equals("Y")){
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(o_appt_ref_no[init]));
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block271Bytes, _wl_block271);
}
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block243Bytes, _wl_block243);
}

}
if (stmtps !=null) stmtps.close();
if (rsps !=null) rsps.close();

            _bw.write(_wl_block277Bytes, _wl_block277);


}
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(P_O_OBVISIT_FLAG));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf( clinic_code ));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(P_O_CLINIC ));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(practitioner_id ));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(P_O_PRACTITIONER ));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(date ));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(P_O_OVER_BOOKING));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(over_booked_label));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(P_O_TIME_TAB_TYPE));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(max_patients_per_slab));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf( current_time ));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf( value12));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf( value13));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(P_O_END_TIME));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(old_from_time));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(old_to_time));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(book_appt_wo_pid_yn));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(book_appt_across_catg_yn));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(P_O_Max_Forced));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(P_O_Total_Forced));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(P_O_Max_Global));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(P_O_Total_Global));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(calling_mode_new));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(decide));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(isIncRemarksLengthAppl));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(ref_id));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block333Bytes, _wl_block333);
String calling_mode1=request.getParameter("callingMode");
if(calling_mode1==null) calling_mode1="N";

            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(calling_mode1));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(FORCED_BOOK_APPT_YN));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(GLOBAL_BOOK_APPT_YN));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(global_locn_yn));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(p_o_ext_slot_status));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(p_o_reserved_slot_dtls));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(p_o_appt_slot_dtls));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(p_o_block_slot_dtls));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(p_o_break_slot_dtls));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(isSlotStartMidEndAppl));
            _bw.write(_wl_block351Bytes, _wl_block351);
String recall_time=(String) session.getValue("recall_time");
if(recall_time==null)
	recall_time="N";


            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(recall_time));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(wtListControl));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(groupApptYN));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(group_check));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block359Bytes, _wl_block359);

}


	if (stmtps != null) stmtps.close();
	if (statement != null) statement.close();
	if (statement_bru != null) statement_bru.close();
	if (cstmt != null) cstmt.close();
	if (rs != null) rs.close();
	if (rsps != null) rsps.close();
	if(rsCA !=null)rsCA.close();
	if(rsps !=null)rsps.close();
	//if (stmtsd !=null) stmtsd.close();
	if (pstmtststus!=null) pstmtststus.close();
	//if (stmtsd !=null) stmtsd.close();
	if (rsststus!=null) rsststus.close();
	if(stmtn !=null)stmtn.close();
	if(stmt_ca !=null)stmt_ca.close();
	if(stmt !=null)stmt.close();
	if(stmt_date !=null)stmt_date.close();
	if(pstmt_access !=null)pstmt_access.close();
	if(pstmt_label !=null)pstmt_label.close();
	arrLst.clear();
}catch(Exception e) { 
	e.printStackTrace(); 
	//out.println("Exception here");
	//out.println("Exception in 3076 DisplayResults.jsp" + e.getMessage());
}

}
catch(Exception e){
	e.printStackTrace();
	//out.println("Exception here");
	//out.println("Exception in 3083 DisplayResults.jsp" + e.getMessage());
	
	
            _bw.write(_wl_block360Bytes, _wl_block360);
}finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block361Bytes, _wl_block361);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Allocation.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Slot.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firstvisit.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.othervisit.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Global.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Forced.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.NormalReschedule.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.count.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.BulkReschedule.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.count.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.maximum.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booked.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.isinpatient.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visit.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.INDICATOR.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Selection.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ApptGivenBy.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ApptGivenOn.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.blocked.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceased.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.blocked.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }
}
