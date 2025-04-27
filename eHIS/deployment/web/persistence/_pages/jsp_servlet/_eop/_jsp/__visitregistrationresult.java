package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import blopin.*;
import eOR.*;
import eBL.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.Common.*;
import eOP.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __visitregistrationresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/VisitRegistrationResult.jsp", 1743070040202L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\n<html> \n\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<STYLE TYPE=\"text/CSS\">\n\n\n/* This style is used for locking the table\'s heading  */\n\ndiv#order_ctlg_tbl {\nwidth: 1020px;\nheight: 85px;\noverflow: auto;\nposition: absolute;\n}\n\nthead th, thead th.locked\t{\nposition:relative;\n}\n\nthead th {\ntop: expression(document.getElementById(\"order_ctlg_tbl\").scrollTop-2); \nz-index: 20;\n}\ndiv.label{\n\tCOLOR:#444444;  \n\tbackground-color:#FFFFFF;\n\tFONT-SIZE: 8pt;\n\tTEXT-ALIGN: LEFT;   \n\tPADDING-LEFT:5px;\n\tPADDING-RIGHT:5px\n}\n\n</STYLE>\n\n<meta http-equiv=\"Expires\" content=\"0\">\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eMP/js/PatientRegistration.js\" language=\"JavaScript\"></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n<Script src=\"../../eOP/js/VisitRegistrationQuery.js\" language=\"JavaScript\"></Script> \n<Script src=\"../../eOP/js/VisitRegistration.js\" language=\"JavaScript\"></Script>\t \n<Script src=\"../../eOP/js/VisitRegistration1.js\" language=\"JavaScript\"></Script>\t \n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eOP/js/OPPractitionerComponent.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n<script language=\"javascript\" src=\"../../eOP/js/Checkblockscheduleforpract.js\"></script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013-->\n<script src=\'../../eBL/js/AddModifyPatFinDetails.js\' language=\'Javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery.js\'></script> <!-- added by mujafar for AMRI-CRF-0357 -->\n\n<!--Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1-->\n<script src=\'../../eXH/js/ExternalApplication.js\' language=\'Javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n$(document).ready(function(){ \t\n var isPractoApptYn = document.getElementById(\'isPractoApptYn\');\n if(isPractoApptYn) {\n\t isPractoApptYn=isPractoApptYn.value;\n }\n if(isPractoApptYn==\"Y\"){\n\t parent.parent.frames[0].document.forms[0].apply.click();\n }\n});\n\n</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>alert(getMessage(\'OP_EMERG_PAT_NOT_ALLOWED\',\'OP\'));\n         parent.parent.frames[0].document.getElementById(\"reset\").click();\n    </SCRIPT>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script>     \n\talert(getMessage(\'PREF_FCY_NOT_LOG_FCY\',\'MP\'));\t  \n </SCRIPT>\n\t\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n <SCRIPT>\n\tparent.frames[2].location.href=\'../../eCommon/jsp/pline.jsp?Patient_Id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'\n </SCRIPT>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n <SCRIPT>\n\t             \n\tparent.parent.frames[1].frames[2].location.href=\'../../eCommon/jsp/pline.jsp?Patient_Id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'\n </SCRIPT>\n ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n<body onLoad=\'populateContactDetails();enableGif();PatVisHid(1);displayRemarksForOtherReason(document.forms[0].contact_reason_code);";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="populateRefTab(document.forms[0].assign_care_locn_code.value);";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onMouseDown=\"CodeArrest();\" onKeyDown =\'lockKey()\' onSelect=\"codeArrestThruSelect();\" class=\'content\'  >\n<form name=\'visit_registration\' id=\'visit_registration\' method=\'post\' action=\'../../servlet/eOP.VisitRegistrationServlet\' target=\"messageFrame\">\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \t \n\n<script>prevTabObj=\"visit_tab\"</script>\n\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=\'0\' align=\'center\' >\n<tr>\n \n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n\t<td  class=\"white\"  width=\'70%\' align=\'left\'>\n\t\t<ul id=\"tablist\" class=\"tablist\"  style=padding-left:0px;>\n\t\t\t<li class=\"tablistitem\" title=\"Visit\">\n\t\t\t\t<a onclick=\"tab_clickQuery(\'visit_tab\')\" class=\"tabClicked\" id=\"visit_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"visit_tabspan\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\"Financial\">\n\t\t\t\t<a onclick=\"javascript:tab_clickQuery(\'financial_tab\')\" class=\"tabA\" id=\"financial_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"financial_tabspan\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t</ul>\n\t</td>\n \n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<td class=\"white\"  width=\'70%\' align=\'left\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n   <td id=\'button_item4\' width=\'10%\' class=\'button\'></td><td id=\'button_item1\' width=\'10%\' class=\'button\'></td>\n</tr>\n</table>\n\t\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'> \n<a name=\'demo\' ></a>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n<tr>\n\t\t<td class=\'label\' width=\'18%\' > ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t<td id=\'refdetails\' style=\'position:relative;\' class=\"data\" colspan=\'3\' ><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</b></td><!-- <td colspan=\'4\'></td> -->\n</tr>\n\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \t \n\n\n\n<tr>\n\n<td class=\'label\'  width=\'18%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n<td id=\'refdetails\' style=\'position:relative;\' class=\"label\" width = \'34%\'>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" / ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</b>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</td>\n\n<!--modified below by Kamatchi S for ML-MMOH-CRF-1609--> \n<td class=\'label\'  width=\'18%\'>     \n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;\n</td> \n<td class=\'fields\' style=\'position:relative;\' width=\'30%\'>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<b>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</b>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n</td>\n</tr>\t\n\n<tr>\n\n<td class=\'label\' width=\'18%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t<td class=\'fields\' width=\'34%\'>\t\t\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\t\t    <input type=\'text\'  id=\'regndatetime\' name=\"vst_regn_date_time\" id=\"vst_regn_date_time\"  value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" maxLength=\'19\' size=\'19\' onBlur=\'chkFromToTime2(this);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'regndatetime\',\'dd/mm/yyyy\' ,\'hh:mm:ss\',null );\" style=\'cursor:pointer\'></img>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t\t<input type=\'hidden\' name=\'AllowedDate\' id=\'AllowedDate\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\'sysDateSer\' id=\'sysDateSer\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"></input>\n\t\t\t<input type=\'hidden\' name=\"vst_regn_date_time_new\" id=\"vst_regn_date_time_new\"  value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"></input>\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\"vst_regn_date_time\" id=\"vst_regn_date_time\"  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" ></input>\t\n\t\t\t<input type=\'text\' name=\"vst_regn_date_time_new\" id=\"vst_regn_date_time_new\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" maxLength=\'16\' size=\'16\' readonly> <!-- created by Srinivasrao Yeluri for incident no 29368 --> \t\t\t\t\n        </td> \n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<td  class=\'label\' width = \'18%\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t<td   class=\'fields\' width = \'30%\'>\n\t\t\t<INPUT TYPE=\"text\" name=\"vis_det_temp_desc\" id=\"vis_det_temp_desc\" onBlur=\"onBlurgetVisdetails(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\',document.forms[0].vis_det_temp_desc)\" onchange=\'clearVisitDtls();\'        ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" ><input type=\"button\" name=\"vis_det_temp_btn\" id=\"vis_det_temp_btn\" value=\"?\" class=\"button\" onClick=\"getVisdetails(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',document.forms[0].vis_det_temp_desc)\"  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" ><input type=\"hidden\" name=\"vis_det_temp_code\" id=\"vis_det_temp_code\" value=\"\" >\n\n\t\t\t<!--Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1-->\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t&nbsp;&nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t&nbsp;&nbsp;<input type=\"text\" name=\"qms_queue_pkid\" id=\"qms_queue_pkid\" maxlength=8 size=12 onKeyPress=\"return CheckForSpecCharsValidation2(event);\" OnBlur=\"CheckSplCharsforIdValidation(this);getCommonQueueDtls(this,\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\',\'OnBlur\');\">\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\n\t\t</td>\n\n \n</tr>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="  \n\t \n\n\t  \n\t<tr>\n\n\t<td class=\'label\' width=\'18%\' nowrap>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t<td class=\'fields\' width=\'34%\' nowrap><select name=\"locn_type\" id=\"locn_type\" onchange=\'clearLocnVal();displayRemarksForOtherReason(document.forms[0].contact_reason_code);\' disabled>\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t<td class=\'fields\' width=\'30%\' nowrap><select name=\"locn_type\" id=\"locn_type\" onchange=\'clearLocnVal(this);displayRemarksForOtherReason(document.forms[0].contact_reason_code);\'>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t<option value=\"\">------ ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" ------\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n           <OPTION VALUE=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' selected>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n            ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t<OPTION VALUE=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\n\t</select>\n\t&nbsp;/&nbsp;\t\n ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n   <INPUT TYPE=\"text\" name=\"assign_care_locn_desc\" id=\"assign_care_locn_desc\"  onBlur=\"onBlurgetLoc(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\',\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\',document.forms[0].assign_care_locn_desc);displayRemarksForOtherReason(document.forms[0].contact_reason_code);";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"><input type=\"button\" id=\"qloc_butt_id\" name=\"qloc_butt\" id=\"qloc_butt\" value=\"?\" class=\"button\" onClick=\"getLocn(\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" ><input type=\"hidden\" name=\"assign_care_locn_code\" id=\"assign_care_locn_code\"><img src=\'../../eCommon/images/mandatory.gif\'>\n   <!--added by munisekhar for MMS-QH-CRF-0167 [IN:044923] -->\n   ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n   <img  align=\'center\' style=\"visibility:hidden\" id=\"loc_name\" src=\'../../eCommon/images/PatVisitLoad.png\' onClick=\"getPatientQueue(document.forms[0].assign_care_locn_code.value)\"/>\n   ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n   \n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t<INPUT TYPE=\"text\" name=\"assign_care_locn_desc\" id=\"assign_care_locn_desc\"  value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" onBlur=\"onBlurgetLoc(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" ><input type=\"hidden\" name=\"assign_care_locn_code\" id=\"assign_care_locn_code\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"><img src=\'../../eCommon/images/mandatory.gif\'>\n\t<!--added by munisekhar for MMS-QH-CRF-0167 [IN:044923] -->\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t<img  align=\'center\' style=\"visibility:hidden\" id=\"loc_name\" src=\'../../eCommon/images/PatVisitLoad.png\' onClick=\"getPatientQueue(document.forms[0].assign_care_locn_code.value)\"/>\n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n    <input type=\"text\" name=\'assign_care_locn_desc\' id=\'assign_care_locn_desc\' maxlength=\'20\' size=\'20\' value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" readonly><img src=\'../../eCommon/images/mandatory.gif\'>\n\t<!--added by munisekhar for MMS-QH-CRF-0167 [IN:044923] -->\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n    <input type=\'hidden\' name=\'assign_care_locn_code\' id=\'assign_care_locn_code\' value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"></td>\n ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n </td>\n\n\n<td class = \'label\'  width = \'18%\' >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t<td width = \'34%\' colspan = \'2\'>\n\t<select name=\'room_no\' id=\'room_no\' onChange = \'populateRoomDesc(this)\'><option value = \"\">------------------";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="-------------------</option>\n\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t   <!--below line was modified by Venkatesh.S on 08-Nov-2012 against 36090 -->\n \t\t<option value = \'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n  </select>\n  \n   <img ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="  id=\'room_img\' src=\'../../eCommon/images/mandatory.gif\'>\n\t\n   \n   <div id = \'roomDesc\' style=\'position:absolute\' class=\"label\" ></div>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t<script> \n\t/* this line was commentd by venkatesh.s on 09/Nov/2012 agaings CRF SS-CRF-0010 [IN034516] FD 3.0 version */\n\t//parent.frames[3].document.getElementById(\"roomDesc\").innerHTML=\'&nbsp;/&nbsp;\'+\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\';\n\t\t\t\t \n  </script>\n\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n   </td>\n </tr>\t\n<tr> \n<td   class=\'label\' width = \'18%\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n<td   class=\'fields\' width = \'34%\'>\n<select   name=service_code id=service_code onChange=\"popSubservice(this);\">\n<option value=\'\'>------";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="-------</option>\n ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n      <option value = \"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" selected>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</option>\n      ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" >";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t <script>document.forms[0].service_code.options[1].selected = true\t;</script>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t<script>document.forms[0].service_code.options[1].selected = false</script>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\n\n\n </select><img src=\'../../eCommon/images/mandatory.gif\'>\n</td>\n <td  class=\'label\' nowrap width = \'18%\'>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n <td    class=\'fields\' width = \'30%\'>\n <select   name=subservice_code id=subservice_code  >\n <option value=\'\'>-------";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="-------</option></select>\n </td>\n</tr>\n  \n <tr>\n <td  class = \'label\'  width = \'18%\' nowrap> ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n <td  class=\'fields\' width = \'34%\' >\n <!-- Modified against PMG2014-TTM-CRF-0001 [IN:048624] -->\n <input type=\'hidden\' name=\'isMohbr\' id=\'isMohbr\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" <select name=\'visit_adm_type\' id=\'visit_adm_type\' onChange=\"ChangeObj2(this,\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\');enableGif()\"  disabled><option value=\'\'>------";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="-------</select><img src=\'../../eCommon/images/mandatory.gif\'>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t  \n\t  <input type=\"text\" name=\'visit_adm_type_text1\' id=\'visit_adm_type_text1\' maxlength=\'20\' size=\'18\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" disabled><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t     <input type=\'hidden\' name=\'visit_adm_type\' id=\'visit_adm_type\' value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n    <select name=\'visit_adm_type\' id=\'visit_adm_type\' onChange=\"ChangeObj2(this,\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\');enableGif()\"  disabled>\n\t\n\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="<option value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</option>\n\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="<option value=\'\'>------";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="-------";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t</select><img src=\'../../eCommon/images/mandatory.gif\'>\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n      \n    <!--  <input type=\"text\" name=\'visit_adm_type_text1\' id=\'visit_adm_type_text1\' maxlength=\'20\' size=\'18\' value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" readonly><img src=\'../../eCommon/images/mandatory.gif\'></img>\n     <input type=\'hidden\' name=\'visit_adm_type\' id=\'visit_adm_type\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"> --><!--Commented for the MMS-SCF-0010 -->\n   ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t<input type=\"text\" name=\'visit_adm_type_text1\' id=\'visit_adm_type_text1\' maxlength=\'20\' size=\'18\' value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t  <select name=\'visit_adm_type\' id=\'visit_adm_type\' onChange=\"ChangeObj2(this,\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="-------\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n</td>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t  \n\n\n<td class=\'label\' width = \'18%\'>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td>\n<td class=\'fields\' width = \'30%\'>\n<select name=\'pat_class\' id=\'pat_class\' ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =">\n<option value=\'\'>------";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="-------\n\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'> ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</option>\n   \t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n</select>\n</td> \t\n   \n\n\n\n<tr>\t\n\t<td  class=\'label\' width = \'18%\'>";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</td>\n\t<td  align=\'left\' width = \'34%\'>\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =" \n\t<input type=\"text\" name=\"pract_name\" id=\"pract_name\"  readonly maxlength=\"30\" size=\"30\"  onblur=\'onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);\' ><input type=\"button\" name=\"pract_butt\" id=\"pract_butt\" value=\"?\" disabled class=\"button\" onClick=\"callPractSearchQuery(this,pract_name);\">\n\t<img id=\"gifpop\" style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\n\t<input type=\'hidden\' name=\'attend_practitioner_id\' id=\'attend_practitioner_id\' value=\"\"><input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\"></td>\n\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" \n\t\t<input type=\"text\" name=\"pract_name\" id=\"pract_name\" maxlength=\"30\" size=\"30\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"  ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" onblur=\'onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);\' ><input type=\"button\" name=\"pract_butt\" id=\"pract_butt\" value=\"?\" class=\"button\" ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" onClick=\"callPractSearchQuery(this,pract_name);\">\n\t\t<img id=\"gifpop\" style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img><img id=\"sec_res_gif\" style=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' src=\'../../eCommon/images/SecRes.png\' onclick=\'showSecondaryResource();\'>\n\t   ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t<input type=\'hidden\' name=\'attend_practitioner_id\' id=\'attend_practitioner_id\' value=\"\">\n       ";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t<input type=\'hidden\' name=\'attend_practitioner_id\' id=\'attend_practitioner_id\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t<input type=\'hidden\' name=\'appt_practitioner_id\' id=\'appt_practitioner_id\' value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t<input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\">\t\t\n\t\t</td>\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t<input type=\"text\" name=\"pract_name\" id=\"pract_name\" maxlength=\"30\" size=\"30\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="  onClick=\"callPractSearchQuery(this,pract_name);\">\n\t\t<img id=\"gifpop\" style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img><img id=\"sec_res_gif\" style=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' src=\'../../eCommon/images/SecRes.png\' onclick=\'showSecondaryResource();\'>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t <div id= \'enablelookup\'>\n\t\t<input type=\"text\" name=\'pract_name\' id=\'pract_name\' maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =" readonly><img id=\"gifpop\" src=\'../../eCommon/images/mandatory.gif\'></img><img id=\"sec_res_gif\" style=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' src=\'../../eCommon/images/SecRes.png\' onclick=\'showSecondaryResource();\'></div>\n\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="<input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\">\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =" \n\t<input type=\"text\" name=\"pract_name\" id=\"pract_name\"  readonly ";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =" maxlength=\"30\" size=\"30\"  onblur=\'onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);\' ><input type=\"button\" name=\"pract_butt\" id=\"pract_butt\" value=\"?\" disabled class=\"button\" onClick=\"callPractSearchQuery(this,pract_name);\">\n\t<img id=\"gifpoppract\" src=\'../../eCommon/images/mandatory.gif\'></img>\t\n\t<input type=\'hidden\' name=\'attend_practitioner_id\' id=\'attend_practitioner_id\' value=\"\"><input type=\'hidden\' name=\'prev_pract_name\' id=\'prev_pract_name\' value=\"\"></td>\n";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" onblur=\'onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);\' ><input type=\"button\"  name=\"pract_butt\" id=\"pract_butt\" value=\"?\" class=\"button\" ";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="  onClick=\"callPractSearchQuery(this,pract_name);\">\n\t\t<img id=\"gifpoppract\" src=\'../../eCommon/images/mandatory.gif\'></img><img id=\"sec_res_gif\" style=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" onblur=\'onBlurCallPractitionerSearchQuery(document.forms[0].pract_butt,pract_name);\' ><input type=\"button\" name=\"pract_butt\" id=\"pract_butt\" value=\"?\" ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =" class=\"button\" onClick=\"callPractSearchQuery(this,pract_name);\">\n\t\t<img id=\"gifpoppract\" src=\'../../eCommon/images/mandatory.gif\'></img><img id=\"sec_res_gif\" style=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" readonly><img id=\"gifpoppract\" src=\'../../eCommon/images/mandatory.gif\'></img></div>\n\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\n\n  <td  class=\'label\' nowrap width = \'18%\'>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</td>\n  <td  align=\'left\' nowrap width = \'30%\'>\n  <select name=\'other_res_type\' id=\'other_res_type\' onChange=\'clearResourceVal(this);\'>\n  <option value=\'\'>-----";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="--------</option>\n\n  ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n  <option value=\'E\' selected>";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</option>\n  <option value=\'O\'>";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</option>\n  ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n    <option value=\'E\'>";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</option>\n\t<option value=\'O\' selected>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t<option value=\'E\'>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</option>\n\t<option value=\'O\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n  </select> \n  &nbsp;/&nbsp;\t\n  <input type=\'text\' name=\'other_res_txt\' id=\'other_res_txt\' maxlength=\'15\' size=\'16\'  value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' ><input type=\'button\' class=\'button\' name=\'other_res_butt\' id=\'other_res_butt\' value=\'?\' onClick=\'otherResourceLookUp(this,other_res_txt);\' >\n  <input type=\'hidden\' name=\'other_res_code\' id=\'other_res_code\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n  </td>\n</tr>\n\n<tr>\n\t<td   class=\'label\' nowrap width = \'18%\'>";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="</td>\n\t<td  id=\'ordcat\' width = \'34%\'>\n\t ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t<input type=\"text\" name=\"order_cat_txt\" id=\"order_cat_txt\" maxlength=\"40\" size=\"25\"  value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'readOnly><input type=\"button\" name=\"order_cat_butt\" id=\"order_cat_butt\" value=\"?\" class=\"button\" disabled onClick=\"CallCatalogSearch(this,order_cat_txt);\" ><img id=\"gifpopord\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\" ></img>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="<input type=\"text\" name=\"order_cat_txt\" id=\"order_cat_txt\"  maxlength=\"40\" size=\"25\"  onblur=\"onBlurCallCatalogSearch(document.forms[0].order_cat_butt,order_cat_txt);\" ><input type=\"button\" name=\"order_cat_butt\" id=\"order_cat_butt\" value=\"?\" class=\"button\" onClick=\"CallCatalogSearch(this,order_cat_txt);\" ><img id=\"gifpopord\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\" ></img>";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="<input type=\"text\" name=\"order_cat_txt\" id=\"order_cat_txt\" readOnly maxlength=\"40\" size=\"25\"  onblur=\"onBlurCallCatalogSearch(document.forms[0].order_cat_butt,order_cat_txt);\" ><input type=\"button\" disabled name=\"order_cat_butt\" id=\"order_cat_butt\" value=\"?\" class=\"button\" onClick=\"CallCatalogSearch(this,order_cat_txt);\" ><img id=\"gifpopord\" src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\" ></img>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\n\n\t<input type=\'hidden\' name=\'order_cat_txt_hidd\' id=\'order_cat_txt_hidd\' value=\'\'>\n\t<input type=\'hidden\' name=\'order_cat_code\' id=\'order_cat_code\' value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' >\n\t<input type=\'hidden\' name=\'order_category_code\' id=\'order_category_code\' value=\'\' >\n\t<input type=\'hidden\' name=\'order_type_code\' id=\'order_type_code\' value=\'\' >\n\t<input type=\'hidden\' name=\'ordering_facility_id\' id=\'ordering_facility_id\' value=\'\' >\n\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'\' >\n\t<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\'\' >\t\n\t</td>\n";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t <td  class=\'label\' NOWRAP width = \'18%\'>";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</td>\n     <td  class=\'Fields\' width = \'30%\'><input type=\"text\" name=\"assigncare_location_desc\" id=\"assigncare_location_desc\" maxlength=\"40\" size=\"25\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 =" >\n     </td>\t \n\t ";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n     <td  class=\'label\' NOWRAP width = \'18%\'>";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</td>\n\t <!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n     <td  class=\'Fields\' width = \'30%\'><input type=\"text\" name=\"contact_reason_txt\" id=\"contact_reason_txt\" maxlength=\"40\" size=\"25\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" onblur=\"onBlurCallContactReasonSearch(document.forms[0].contact_reason_butt,contact_reason_txt,\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\');displayRemarksForOtherReason(document.forms[0].contact_reason_code);\" ><input type=\"button\" name=\"contact_reason_butt\" id=\"contact_reason_butt\" value=\"?\" class=\"button\" onClick=\"CallContactReasonSearch(this,contact_reason_txt,\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\');displayRemarksForOtherReason(document.forms[0].contact_reason_code);\" >\n     </td>\n";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n <input type=\"hidden\" name=\"contact_reason_txt_hidd\" id=\"contact_reason_txt_hidd\" value=\"\">\n <input type=\"hidden\" name=\"contact_reason_code\" id=\"contact_reason_code\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n<td  class=\'label\' NOWRAP width = \'18%\'>";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="</td>\n<td   class=\'Fields\' width = \'30%\'>\n\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n<input type=\"text\" name=\"contact_reason_txt\" id=\"contact_reason_txt\" maxlength=\"40\" size=\"25\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\');displayRemarksForOtherReason(contact_reason_code);\" ><input type=\"button\" name=\"contact_reason_butt\" id=\"contact_reason_butt\" value=\"?\" class=\"button\" onClick=\"CallContactReasonSearch(this,contact_reason_txt,\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\');displayRemarksForOtherReason(contact_reason_code);\" >\n<input type=\'hidden\' name=\'contact_reason_txt_hidd\' id=\'contact_reason_txt_hidd\' value=\'\'>\n<input type=\'hidden\' name=\'contact_reason_code\' id=\'contact_reason_code\' value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' >\n</td>\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t</tr>\n";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n<tr>\n\t<td class=label id=\'remarks_labl\' style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="</td>\n\t<td class=\"fields\" id=\'remarks_fld\' style=\'visibility:hidden\'><textarea rows=2 cols=45 name=\"other_remarks\" onkeyPress=\'checkMaxLimit(this,100)\' onBlur=\"SPCheckMaxLen(\'Remarks\',this,100)\"></textarea><img src=\'../../eCommon/images/mandatory.gif\' id=\'remarks_img\' style=\'visibility:hidden\'></td>\n</tr>\n<!--End ML-MMOH-CRF-1114-->\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n<!--Added by Santhosh for MMS-DM-CRF-0209.4-US005-->\n<tr id=\"reqReff\" style=\'visibility:hidden\'>\n<td  class=\'label\' NOWRAP width = \'18%\'>Referal Required</td>\n<td nowrap><input type=\"checkbox\" name=\"Referal_Required\" id=\'Referal_Required\' onclick=\"getReferralReqID(this)\"> </td>\n</tr>\n<!--END-->\n<input  type=\'hidden\' name=\'emergency_details\' id=\'emergency_details\'>    \n</table>     \n\n<div id=\'order_ctlg_tbl\'>\n</div>\n\n\n      <!--Start--Hidden Fields for Billing Interface-->\n    ";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t ";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\t\t\t     ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\t\n        ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n        ";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\t\t\n        ";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n    ";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n    <input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\"\"></input>\n    <input type=\'hidden\' name=\'billing_class\' id=\'billing_class\' value=\"\"></input>\n    <input type=\'hidden\' name=\'employer_code\' id=\'employer_code\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_set_type1\' id=\'cash_set_type1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_ref1\' id=\'cash_insmt_ref1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_date1\' id=\'cash_insmt_date1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_rmks1\' id=\'cash_insmt_rmks1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_1\' id=\'cust_1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_ref1\' id=\'credit_doc_ref1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_date1\' id=\'credit_doc_date1\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_2\' id=\'cust_2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_ref2\' id=\'credit_doc_ref2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_date2\' id=\'credit_doc_date2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_3\' id=\'cust_3\' value=\"\"></input>\n    <input type=\'hidden\' name=\'policy_type\' id=\'policy_type\' value=\"\"></input>\n    <input type=\'hidden\' name=\'policy_no\' id=\'policy_no\' value=\"\"></input>\n    <input type=\'hidden\' name=\'policy_expiry_date\' id=\'policy_expiry_date\' value=\"\"></input>\n    <input type=\'hidden\' name=\'non_insur_blng_grp\' id=\'non_insur_blng_grp\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_set_type2\' id=\'cash_set_type2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_date2\' id=\'cash_insmt_date2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_4\' id=\'cust_4\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_ref3\' id=\'credit_doc_ref3\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_doc_date3\' id=\'credit_doc_date3\' value=\"\"></input>\n    <input type=\'hidden\' name=\'setlmt_ind\' id=\'setlmt_ind\' value=\"\"></input>\n    <input type=\'hidden\' name=\'upd_fin_dtls\' id=\'upd_fin_dtls\' value=\"\"></input>\n    <input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\"Add\"></input>\n    <input type=\'hidden\' name=\'credit_auth_date\' id=\'credit_auth_date\' value=\'\'></input>\n    <input type=\'hidden\' name=\'app_days\' id=\'app_days\' value=\'\'></input>\n    <input type=\'hidden\' name=\'app_amount\' id=\'app_amount\' value=\'\'></input>\n\t\n\t\n<!-- Added for Billing Enhancements -->    \n\t<input type=\'hidden\' name=\'health_card_expired_yn\' id=\'health_card_expired_yn\' value=\'\'></input>\n    <input type=\'hidden\' name=\'annual_income\' id=\'annual_income\' value=\'\'></input>\n    <input type=\'hidden\' name=\'family_asset\' id=\'family_asset\' value=\'\'></input>\n    <input type=\'hidden\' name=\'no_of_dependants\' id=\'no_of_dependants\' value=\'\'></input>\n    <input type=\'hidden\' name=\'resp_for_payment\' id=\'resp_for_payment\' value=\'\'></input>\n    <input type=\'hidden\' name=\'credit_doc_reqd_yn1\' id=\'credit_doc_reqd_yn1\' value=\'\'></input>\n    <input type=\'hidden\' name=\'credit_doc_reqd_yn2\' id=\'credit_doc_reqd_yn2\' value=\'\'></input>\n<!-- End for Billing Enhancements -->\n    <input type=\'hidden\' name=\'eff_frm_date\' id=\'eff_frm_date\' value=\'\'></input>\n   \n\t\t<input type=\'hidden\' name=\'gl_holder_name\' id=\'gl_holder_name\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'gl_holder_reln\' id=\'gl_holder_reln\' value=\"\">\n    ";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n    <!--End--Hidden Fields for Billing Interface-->\n    <input type=\'hidden\' name=\'new_op_episode_yn\' id=\'new_op_episode_yn\' value=\'\'></input>\n\t<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'></input>\n\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'></input>   \n    <input type=\'hidden\' name=\'upd_user_flag\' id=\'upd_user_flag\' value=\'\'></input>\n    <input type=\'hidden\' name=\'reccnt\' id=\'reccnt\' value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\"></input>\n    <!-- Hidden fields for Visit Charge Calculation  -->\n    <input type=\'hidden\' name=\'pkg_bill_doc_type\' id=\'pkg_bill_doc_type\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pkg_bill_doc_num\' id=\'pkg_bill_doc_num\' value=\"\"></input>\n    <input type=\'hidden\' name=\'policy_type_code\' id=\'policy_type_code\' value=\"\"></input>\n    <input type=\'hidden\' name=\'effective_date\' id=\'effective_date\' value=\"\"></input>\n    <input type=\'hidden\' name=\'credit_auth_ref\' id=\'credit_auth_ref\' value=\"\"></input>\n    <input type=\'hidden\' name=\'approved_days\' id=\'approved_days\' value=\"\"></input>\n    <input type=\'hidden\' name=\'base_qty\' id=\'base_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'base_rate\' id=\'base_rate\' value=\"\"></input>\n    <input type=\'hidden\' name=\'base_charge_amt\' id=\'base_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'gross_charge_amt\' id=\'gross_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'disc_amt\' id=\'disc_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'net_charge_amt\' id=\'net_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_base_qty\' id=\'pat_base_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_base_rate\' id=\'pat_base_rate\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_serv_qty\' id=\'pat_serv_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_base_charge_amt\' id=\'pat_base_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_gross_charge_amt\' id=\'pat_gross_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_disc_amt\' id=\'pat_disc_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pat_net_charge_amt\' id=\'pat_net_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_base_qty\' id=\'cust_base_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_base_rate\' id=\'cust_base_rate\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_serv_qty\' id=\'cust_serv_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_base_charge_amt\' id=\'cust_base_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_gross_charge_amt\' id=\'cust_gross_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_disc_amt\' id=\'cust_disc_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'cust_net_charge_amt\' id=\'cust_net_charge_amt\' value=\"\"></input>\n    <input type=\'hidden\' name=\'split_yn\' id=\'split_yn\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pkg_ins_pat_ind\' id=\'pkg_ins_pat_ind\' value=\"\"></input>\n    <input type=\'hidden\' name=\'req_pkg_qty\' id=\'req_pkg_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'req_addl_qty\' id=\'req_addl_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'req_std_qty\' id=\'req_std_qty\' value=\"\"></input>\n    <input type=\'hidden\' name=\'curr_availed\' id=\'curr_availed\' value=\"\"></input>\n    <input type=\'hidden\' name=\'canadj_alert_ind\' id=\'canadj_alert_ind\' value=\"\"></input>\n    <input type=\'hidden\' name=\'pkg_serv_code\' id=\'pkg_serv_code\' value=\"\"></input>\n    <input type=\'hidden\' name=\'visit_charge_stage\' id=\'visit_charge_stage\' value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\"></input>\n    <input type=\'hidden\' name=\'day_type_code\' id=\'day_type_code\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'time_type_code\' id=\'time_type_code\' value=\"\"></input>     \n    <input type=\'hidden\' name=\'disc_perc\' id=\'disc_perc\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'addl_fctr\' id=\'addl_fctr\' value=\"\"></input>\n  \n\t<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\"></input>\n\t<input type=\'hidden\' name=\'order_catalog_desc\' id=\'order_catalog_desc\' value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\"></input>\n\t<input type=\'hidden\' name=\'orderId\' id=\'orderId\' value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n\t<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t<input type=\'hidden\' name=\'populate_visit_type\' id=\'populate_visit_type\' value=\"\">\n\t\n\t\t\n    \n\n    <!-- End of Hidden fields for Visit Charge Calculation  -->\n    <input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\"></input> \n\t<input type=\'hidden\' name=\'pkg_sel\' id=\'pkg_sel\' value=\"\"></input>    \n    <input type=\'hidden\' name=\'pkg_bill_type\' id=\'pkg_bill_type\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'pkg_bill_no\' id=\'pkg_bill_no\' value=\"\"></input>\n\t\t<input type=\'hidden\' name=\'resource_class\' id=\'resource_class\' value=\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'>\n\t<input type=\'hidden\' name=\'res_pract_id\' id=\'res_pract_id\' value=\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'>\n\n\n\t<input type=\'hidden\' name=\'cred_start_dt1\' id=\'cred_start_dt1\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'cred_start_dt2\' id=\'cred_start_dt2\' value=\"\"></input>  \n    <input type=\'hidden\' name=\'cred_start_dt3\' id=\'cred_start_dt3\' value=\"\"></input> \n\n\t\n\t<input type=\'hidden\' name=\'entitlement_by_cat_yn\' id=\'entitlement_by_cat_yn\' value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\"></input> \n\t<input type=\'hidden\' name=\'isOrderCtlgAmtCalc\' id=\'isOrderCtlgAmtCalc\' value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" />\n\t<input type=\'hidden\' name=\'isPractoApptYn\' id=\'isPractoApptYn\' value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" />\n\t\t\n  ";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n              <script>dispAuth(";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 =",\'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\');</script>\n\t\t\t";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t\t <script>funPatRegCharges(\'";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\');</script>\n\t\t\t\t";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n<script>\n/** Commented by Smita Unnikrishnan on 02-03-04 while changing the layout design for Visit registration**/\nif(document.getElementById(\"button_item1\")  != null)\n\tdocument.getElementById(\"button_item1\").innerHTML=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\";\n\nif(document.getElementById(\"button_item4\") != null)\n\tdocument.getElementById(\"button_item4\").innerHTML=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\";\n\nif(";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 =" == 0) {\n\tif(document.forms[0].prev_visit != null) {\n\t\tdocument.forms[0].prev_visit.disabled=true;\n\t}\n} else {\n\tif(document.forms[0].prev_visit != null) {\n\t\tdocument.forms[0].prev_visit.disabled=false;\n\t}\n} \n\t\n</script> \t\n\t\n\t<input type=\'hidden\' name=\'pat_ser_grp_code\' id=\'pat_ser_grp_code\' value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\t\n\t<input type=\'hidden\' name=\'exceded_max_walkin\' id=\'exceded_max_walkin\' value=\"false\">\t\n\t<input type=\'hidden\' name=\'no_of_multi_orders\' id=\'no_of_multi_orders\' value=\"1\">\t\n\t<input type=\'hidden\' name=\'override_walkin_yn\' id=\'override_walkin_yn\' value=\"\">\n\t<input type=\'hidden\' name=\'queueNo\' id=\'queueNo\' value=\'\'>\t\t \n\t<input type=\'hidden\' name=\'waitTime\' id=\'waitTime\' value=\'\'>\t\n\t<!-- <input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\"> -->\n\n\t<input type=\'hidden\' name=\'inv_splty_code\' id=\'inv_splty_code\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\t\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n\t<input type=\'hidden\' name=\'override_pract_for_appt\' id=\'override_pract_for_appt\' value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\t\n\t<input type=\'hidden\' name=\'assign_q_num_by\' id=\'assign_q_num_by\' value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\t\n\t<input type=\'hidden\' name=\'bl_patient_id\' id=\'bl_patient_id\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\t\n\t<input type=\'hidden\' name=\'oa_install_yn\' id=\'oa_install_yn\' value=\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\'>\t\n\t<input type=\'hidden\' name=\'patFlag\' id=\'patFlag\' value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\t\n\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n\t<input type=\'hidden\' name=\'pat_details\' id=\'pat_details\' value=\'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\'>\n\t<input type=\'hidden\' name=\'date_of_birth\' id=\'date_of_birth\' value=\'";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\'>\n\t<input type=\'hidden\' name=\'sec_level\' id=\'sec_level\' value=\'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\'>\n\t<input type=\'hidden\' name=\'protection_ind\' id=\'protection_ind\' value=\'";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\'>\n\t<input type=\'hidden\' name=\'outst_amt\' id=\'outst_amt\' value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n\t<input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\"\">\n\t<input type=\'hidden\' name=\'last_visit_date\' id=\'last_visit_date\'>\n\t<input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n\t<input type=\'hidden\' name=\'no_practitioner_for_appt\' id=\'no_practitioner_for_appt\' value=\"N\">\n\t<input type=\'hidden\' name=\'ident_at_checkin\' id=\'ident_at_checkin\' value=\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'>\n\t<input type=\'hidden\' name=\'h_visit_type_ind\' id=\'h_visit_type_ind\'>\n\t<input type=\'hidden\' name=\'gen_file_yn\' id=\'gen_file_yn\' value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n\t<input type=\'hidden\' name=\'build_episode_rule\' id=\'build_episode_rule\' value=\'";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\'> \n\t<input type=\'hidden\' name=\'or_install_yn\' id=\'or_install_yn\' value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" >\n\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\"> \n\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'Generate_File\'>\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'Generate_File\'>\n\t<input type=\'hidden\' name=\'Chg_to_Visitor_Grp\' id=\'Chg_to_Visitor_Grp\' value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\">\n\t<!-- Added for Billing validation on 16/8/2002 -->\n\t<input type=\'hidden\' name=\'health_card_expired_yn1\' id=\'health_card_expired_yn1\' value=\'";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\'>\n\t<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\"N\">\n\t<input type=\'hidden\' name=\'override_vtype_on_epsd_yn\' id=\'override_vtype_on_epsd_yn\' value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\">\n\t<input type=\'hidden\' name=\'episode_close_days_fu\' id=\'episode_close_days_fu\' value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\">\n\t<input type=\'hidden\' name=\'episode_close_days_wo_fu\' id=\'episode_close_days_wo_fu\' value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">  \n\t<input type=\'hidden\' name=\'dur_for_fu_vsts_in_days\' id=\'dur_for_fu_vsts_in_days\' value=\"\">  \n\t<input type=\'hidden\' name=\'no_of_fu_visits_allowed\' id=\'no_of_fu_visits_allowed\' value=\"\">  \n\t<input type=\'hidden\' name=\'ct_patient_id\' id=\'ct_patient_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'error\' id=\'error\' value=\'\'>\n\t<input type=\'hidden\' name=\'old_op_episode_id\' id=\'old_op_episode_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'old_op_episode_visit_num\' id=\'old_op_episode_visit_num\' value=\'\'>\n\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\'>\n\t<input type=\'hidden\' name=\'l_encounter_id\' id=\'l_encounter_id\' value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\"> \n\t<input type=\'hidden\' name=\'new_episode_yn\' id=\'new_episode_yn\' value=\"\">\n\t<input type=\'hidden\' name=\'referral_code\' id=\'referral_code\' value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\">\n\t<input type=\'hidden\' name=\'reg_vis_param\' id=\'reg_vis_param\' value=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\'>\n\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n\t<input type=\'hidden\' name=\'visit_adm_type_ind\' id=\'visit_adm_type_ind\' value=\"R\">\n\t<input type=\'hidden\'  name=\'old_episode_no\' id=\'old_episode_no\'>\n    <input type=\'hidden\' style=\'text-align:right\' name=\'op_episode_id\' id=\'op_episode_id\'  >\n\t<input type=\'hidden\' style=\'text-align:right\' name=\'cur_episode_id\' id=\'cur_episode_id\'  value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" size=\'12\' maxlength=\'12\'>\n    <input type=\'hidden\' style=\'text-align:right\' name=\'op_episode_visit_num\' id=\'op_episode_visit_num\' >\n\t<input type=\'hidden\' name=\'register_pat_yn\' id=\'register_pat_yn\' value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n\t<input type=\'hidden\' name=\'wait_list_flag\' id=\'wait_list_flag\' value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\">\n\t<input type=\'hidden\' name=\'DispAlert\' id=\'DispAlert\' value=\"Y\">\n\t<input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\">\n\t<!-- *********added on 11/12/2003 , pass referral_id  to financila details******* -->\n\t<input type=\'hidden\' name=\'financial_detail_ref_id\' id=\'financial_detail_ref_id\' value=\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\'> \n\t<input type=\'hidden\' name=\'org_type\' id=\'org_type\' value=\'";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\'>\n\t<input type=\"hidden\" name=\"room_type\" id=\"room_type\" value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\"  >\n\t<input type=\"hidden\" name=\"rm_no\" id=\"rm_no\" value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\"  >\n\t<input type=\"hidden\" name=\"q_visit_adm_type_ind\" id=\"q_visit_adm_type_ind\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\"  >\n\t<input type=\"hidden\" name=\"q_visit_adm_type\" id=\"q_visit_adm_type\" value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\"  ><!--Included for the MMS-SCF-0010 -->\n\t<!-- *****added for inclusion of contact details**** -->\n\t<input type=\'hidden\' name=\'change_address\' id=\'change_address\' value=\'\'>\n    <input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\">\t<input type=\'hidden\' name=\'concat_NatIdDetails_hidden\' id=\'concat_NatIdDetails_hidden\' value=\'\'>\t\t\n\t<input type=\'hidden\' name=\'addr1_type\' id=\'addr1_type\' value=\"\">\n\t<input type=\'hidden\' name=\'addr_line1\' id=\'addr_line1\' value=\"\" >\n\t<input type=\'hidden\' name=\'addr_line2\' id=\'addr_line2\' value=\"\" >\n\t<input type=\'hidden\' name=\'addr_line3\' id=\'addr_line3\' value=\"\" >\n\t<input type=\'hidden\' name=\'addr_line4\' id=\'addr_line4\' value=\"\" >\n\t<input type=\'hidden\' name=\'res_town_code\' id=\'res_town_code\' value=\"\" >\n\t<input type=\'hidden\' name=\'res_town_desc\' id=\'res_town_desc\' value=\"\" >\n\t<input type=\'hidden\' name=\'res_area_code\' id=\'res_area_code\' value=\"\">\n\t<input type=\'hidden\' name=\'res_area_desc\' id=\'res_area_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'postal_code\' id=\'postal_code\' value=\"\" >\t\n\t<input type=\'hidden\' name=\'region_code\' id=\'region_code\' value=\"\" >\t\n\t<input type=\'hidden\' name=\'region_desc\' id=\'region_desc\' value=\"\" >\t\n\t<input type=\'hidden\' name=\'country_code\' id=\'country_code\' value=\"\" >\n\t<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\"\">\n\t<input type=\'hidden\' name=\'invalid1_yn\' id=\'invalid1_yn\' value=\"\">\n\t<input type=\'hidden\' name=\'addr2_type\' id=\'addr2_type\' value=\"\">\n\t<input type=\'hidden\' name=\'mail_addr_line1\' id=\'mail_addr_line1\'value=\"\">\n\t<input type=\'hidden\' name=\'mail_addr_line2\' id=\'mail_addr_line2\' value=\"\">\n\t<input type=\'hidden\' name=\'mail_addr_line3\' id=\'mail_addr_line3\' value=\"\" >\n\t<input type=\'hidden\' name=\'mail_addr_line4\' id=\'mail_addr_line4\' value=\"\">\n\t<input type=\'hidden\' name=\'mail_res_town_code\' id=\'mail_res_town_code\' value=\"\">\n\t<input type=\'hidden\' name=\'mail_res_town_desc\' id=\'mail_res_town_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'mail_res_area_code\' id=\'mail_res_area_code\' value=\"\">\n\t<input type=\'hidden\' name=\'mail_res_area_desc\' id=\'mail_res_area_desc\' value=\"\" >\n\t<input type=\'hidden\' name=\'mail_postal_code\' id=\'mail_postal_code\' value=\"\" >\n\t<input type=\'hidden\' name=\'mail_region_code\' id=\'mail_region_code\' value=\"\">\n\t<input type=\'hidden\' name=\'mail_region_desc\' id=\'mail_region_desc\' value=\"\" >\n\t<input type=\'hidden\' name=\'mail_country_code\' id=\'mail_country_code\' value=\"\" >\n\t<input type=\'hidden\' name=\'r_postal_code1\' id=\'r_postal_code1\' value=\'\' >\n    <input type=\'hidden\' name=\'m_postal_code1\' id=\'m_postal_code1\' value=\'\'>\n\n\t<!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start-->\n\t<input type=\'hidden\' name=\'addr3_type\' id=\'addr3_type\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_addr_line1\' id=\'alt_addr_line1\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_addr_line2\' id=\'alt_addr_line2\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_addr_line3\' id=\'alt_addr_line3\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_addr_line4\' id=\'alt_addr_line4\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_town_code\' id=\'alt_town_code\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_town_desc\' id=\'alt_town_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_area_code\' id=\'alt_area_code\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_area_desc\' id=\'alt_area_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_postal_code1\' id=\'alt_postal_code1\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_region_code\' id=\'alt_region_code\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_region_desc\' id=\'alt_region_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_country_code\' id=\'alt_country_code\' value=\"\">\n\t<input type=\'hidden\' name=\'alt_country_desc\' id=\'alt_country_desc\' value=\"\">\n\t<!--End-->\n\t\n\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">\n\t<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\"\">\n\t<input type=\'hidden\' name=\'invalid2_yn\' id=\'invalid2_yn\' value=\"\">\n\t<input type=\'hidden\' name=\'country_desc\' id=\'country_desc\' value=\"\" maxlength=\'6\'>\n\t<input type=\'hidden\' name=\'mail_country_desc\' id=\'mail_country_desc\' value=\"\" maxlength=\'6\'>\n\t<input type=\'hidden\' name=\'bed_num\' id=\'bed_num\' value=\'";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\'>\n\t<input type=\'hidden\' name=\'discharge_date_time\' id=\'discharge_date_time\' value=\'";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\'>\n\t<input type=\'hidden\' name=\'functionId\' id=\'functionId\' value=\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\'>\n\t<input type=\'hidden\' name=\'menu_function_id\' id=\'menu_function_id\' value=\'";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\'>\n\t<input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\'>\n\t<input type=\"hidden\" name=\"appt_ref_no_2\" id=\"appt_ref_no_2\" value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\"  >\n\t<input type=\"hidden\" name=\"appt_ref_no\" id=\"appt_ref_no\" value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\"  >\n\t<input type=\'hidden\' name=\'clptype\' id=\'clptype\' value=\"\">\n\t<input type=\'hidden\' name=\'order_req\' id=\'order_req\' value=\"\">\n\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\'>\n\t<input type=\'hidden\' name=\'contact1_no\' id=\'contact1_no\' value=\"\">\n\t<input type=\'hidden\' name=\'contact2_no\' id=\'contact2_no\' value=\"\">\n\t<input type=\'hidden\' name=\'email\' id=\'email\' value=\"\">\n\t<input type=\'hidden\' name=\'locationSpeciality\' id=\'locationSpeciality\' value=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\">\n\t<input type=\'hidden\' name=\'from_reg\' id=\'from_reg\' value=\'";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\'>\n\t<input type=\'hidden\' name=\'new_file_no\' id=\'new_file_no\' value=\'\'>\n\t<input type=\'hidden\' name=\'dummy_visit_type\' id=\'dummy_visit_type\' value=\'\'>\t\t\t\n\t<input type=\'hidden\' name=\'dummy_locn_code\' id=\'dummy_locn_code\' value=\'\'>\t\t\n\t<input type=\'hidden\' name=\'dummy_visit_dttime\' id=\'dummy_visit_dttime\' value=\'\'>\t\t\n\t<input type=\'hidden\' name=\'episodeReqd\' id=\'episodeReqd\' value=\'S\'>\t\t \n\t\n\t<input type=\'hidden\' name=\'bl_enter_yn\' id=\'bl_enter_yn\' value=\'N\'>\t\n\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\'>\t\n\t<input type=\'hidden\' name=\'invitation_no\' id=\'invitation_no\' value=\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\'>\t\n\t<input type=\'hidden\' name=\'room_no1\' id=\'room_no1\' value=\'\'>\t\n\t<input type=\'hidden\' name=\'frame_ref\' id=\'frame_ref\' value=\"parent.frames[1].frames[3].\">\n\t<input type=hidden name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\'> \n\t<input type=hidden name=\'iSPractVisitLoad\' id=\'iSPractVisitLoad\' value=\'";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\'><!--added by munisekhar for MMS-QH-CRF-0167 [IN:044923] --> \n    <input type=hidden name=\'isAllowRegForSameService\' id=\'isAllowRegForSameService\' value=\'";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\'>    <!-- Added by mujafar for ML-MMOH-CRF-1437 -->\n\t<!-- Senthil Added for MMS-QH-CRF-0162.1 Linked incident Added for this incident [52415]-->\n\t<input type=hidden name=\'q_appt_time\' id=\'q_appt_time\' value=\'";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\'>\n\t<input type=hidden name=\'rec_no\' id=\'rec_no\' value=\'";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\'>\n\t<input type=hidden name=\'visit_for_inpat_yn\' id=\'visit_for_inpat_yn\' value=\'";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\'> \n\t<input type=hidden name=\'auth_win_reqd_yn\' id=\'auth_win_reqd_yn\' value=\'";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\'>  \n    <!--Added for this incident [52619] -->\t\n\t<!--Below hidden field added for this incident [52854]-->\n\t<input type=hidden name=\"episode\" id=\"episode\" value=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\">\n\t<input type=hidden name=\"record\" id=\"record\" value=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\n\t<!--End incident [52854] -->\n\t<input type=hidden name=\'from_head\' id=\'from_head\' value=\'";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\'> \n\t<input type=hidden name=\'locn_ind\' id=\'locn_ind\' value=\'";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\'> \n\t<input type=hidden name=\'waitlist_status\' id=\'waitlist_status\' value=\'";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\'> \n\t\t\n\n\t\t<input type=\'hidden\' name=\'p_hosp_main\' id=\'p_hosp_main\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'p_hosp_sub\' id=\'p_hosp_sub\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'p_card_id\' id=\'p_card_id\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'p_expiry_date\' id=\'p_expiry_date\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'p_privl_type_code\' id=\'p_privl_type_code\' value=\'\'>\t \n\t\t<input type=\'hidden\' name=\'p_all_services\' id=\'p_all_services\' value=\'\'>\n\n\t\t<input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\'>\n\t\t<input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\'>\n\t\t<input type=\'hidden\' name=\'multiple_orders_yn\' id=\'multiple_orders_yn\' value=\'N\'>\n\n\t\t<input type=\'hidden\' name=\'accept_dis_inv_no\' id=\'accept_dis_inv_no\' value=\'";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\'>\n\t\t<input type=\'hidden\' name=\'visit_type_derv_rule\' id=\'visit_type_derv_rule\' value=\'";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\'>\n\t\t<input type=\'hidden\' name=\'visit_back_yn\' id=\'visit_back_yn\' value=\'";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\'>\n\t\t<input type=\'hidden\' name=\'vst_type_ind\' id=\'vst_type_ind\' value=\'\'><!--added for the CRF MMS-QH-CRF 41.1-->\n\t\t<input type=\'hidden\' name=\'multi_speciality_yn\' id=\'multi_speciality_yn\' value=\'";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\'><!--added for the CRF Bru-HIMS-CRF 0198-->\n\n\t    <!--  Below hidden added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]-->\n\t\t<input type=\"hidden\" name=\"appt_order\" id=\"appt_order\" value=\"";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\">\n\t\t<input type=\"hidden\" name=\"order_count_select\" id=\"order_count_select\" value=\"";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\">\n\n\t\t<!--  Below hidden added for this SCF - MMS-SCF-0082 [IN0 042800]-->\n\t\t<input type=\"hidden\" name=\"blng_grp_id\" id=\"blng_grp_id\"  value=\"\">\n\t\t<input type=\"hidden\" name=\"cust_grp_code\" id=\"cust_grp_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"cust_code\" id=\"cust_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"policy_type_code\" id=\"policy_type_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"proceed_visit_regn\" id=\"proceed_visit_regn\" value=\"\"><!--added for the MMS-SCF-0167 -->\n\t\t<input type=\"hidden\" name=\"upt_contact_dtls_oa_yn\" id=\"upt_contact_dtls_oa_yn\" value=\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\">\n\t\t<input type=\"hidden\" name=\"downtimePatient\" id=\"downtimePatient\" value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\">\n\n\t\t<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start-->\n\t\t<input type = \'hidden\' name = \'isForm60Available\' value=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\">  \n\t\t<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End-->\n\n\t\t<input type=\'hidden\' name=\'reg_date_time\' id=\'reg_date_time\' value=\"";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\"><!--Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] -->\n\t\t\n\t\t<!-- START Added by Sangeetha for KDAH-CRF-0347-->\n\t\t<input type=\"hidden\" name=\"validationForPanCardAvail\" id=\"validationForPanCardAvail\" value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\"> \n\t\t<input type=\"hidden\" name=\"form60_YN\" id=\"form60_YN\" value=\"\">\n\t\t<!-- END KDAH-CRF-0347-->\n\t\t\n\t\t<input type=\"hidden\" name=\"defFinDtls\" id=\"defFinDtls\" value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\">\n\t\t<input type=\'hidden\' name=\'assign_care_locn_desc_prev\' id=\'assign_care_locn_desc_prev\' value=\"\">\n\t\t<input type=\'hidden\' name=\'apptrefno\' id=\'apptrefno\' value=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\" >\n\t\t\n\t\t\n\t\t<input type=\'hidden\' name=\'isRoomMandatoryRegVisit\' id=\'isRoomMandatoryRegVisit\' value=\"";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" > <!-- added by mujafar for NMC-JD-CRF-0025 -->\n\t\t\n\t\t  <script>\n\t if(document.forms[0].assign_care_locn_code.length<=1)\n      alert(getMessage(\'NO_CLINIC_ACCESS\',\'OP\'));\n\t  </script>\n\t\t";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\n\t\t<script>\n\t\t\tif(document.getElementById(\"visit_adm_type\")) { \n                var ispract=document.getElementById(\"isPractoApptYn\");\t\t\t\n\t\t\t\tif(document.getElementById(\"visit_type_derv_rule\").value ==\"P\"  && ispract.value ==\"N\")\n\t\t\t\t  defaultVisitType();\n\t\t\t\telse if(document.getElementById(\"visit_type_derv_rule\").value ==\"B\")//Added for the SCF - MMS-SCF-0134\n\t\t\t\t\tpopulateVisitTypeForBillingInsurance(\'";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\');\n\t\t\t\telse\n\t\t\t\t\tChangeObj2(document.getElementById(\"visit_adm_type\"),\'";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\');\t\t\t\t\t\t\t\t\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\n\n\n";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 =" \n\t<script>\nasync function getPatientQueue(clinic_code)\n\t\t{ \n\t\t    var dialogHeight = \"35\" ;\n\t\t\tvar dialogWidth\t= \"45\" ;\n\t\t\tvar dialogTop = \"160\" ;\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ; \n\t\t\tawait window.showModalDialog(\"../../eOP/jsp/PatientQueueFrames.jsp?clinic_code=\"+clinic_code,arguments,features);\n\t\t\t\n\t\t}\n\n\t\tvar alternate_id_cont_yn = \"Y\";\n\t\tfunction setValue()\t{\n\t\t\talternate_id_cont_yn = \"N\";\n\t\t\tparent.frames[1].document.forms[0].clear1.click();\n\t\t}\n\t\t<!--Below line Added for this CRF  Bru-HIMS-CRF-165.1 [IN:035659] -->\n\t\t\n\t\t\tif(\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\'>0)\n\t\t\t{\n\t\t\tvar ordercatbutt=document.forms[0].order_cat_butt;\n\t\t\tvar ordercattxt=document.forms[0].order_cat_txt;\n\t\t\t//SelectOrderCatalogSearch(document.forms[0].order_cat_butt,document.forms[0].order_cat_txt);\t\n\t\t\tsetTimeout(\"SelectOrderCatalogSearch(\'\"+ordercatbutt+\"\',\'\"+ordercattxt+\"\');\",1000); //this line added for this incident[IN43474]\n\t\t}\n\t\t<!--End Bru-HIMS-CRF-165.1 [IN:035659] -->\n\t</script>\n\t<!-- Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 Start-->\n\t<input type=\"hidden\" name=\"is_prac_blocked\" id=\'is_prac_blocked\' value=\"\">\n\t<input type=\"hidden\" name=\"action_on_pract_schedule\" id=\'action_on_pract_schedule\' value=\"";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\">\n\t<!-- Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 End-->\t\n\t<!--Below line added for this CRF GDOH-CRF-0129-->\n\t<input type=\"hidden\" name=\"assigncare_loctype_ind\" id=\"assigncare_loctype_ind\" value=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\">\n\t<input type=\"hidden\" name=\"assigncare_locacode\" id=\"assigncare_locacode\" value=\"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n\t<input type=\"hidden\" name=\"isReferral\" id=\"isReferral\" value=\"";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\"> \n\t<!--End GDOH-CRF-0129-->\n\t <input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\"";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\"><!--Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601-->\n\t <!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t <input type=\'hidden\' name=\'others_id\' id=\'others_id\' value=\'";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\'>\n\t <!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->\n\t <input type=\'hidden\' name=\'isImproveReferralProcessAppl\' id=\'isImproveReferralProcessAppl\' value=\'";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\'>\n\t <input type=\'hidden\' name=\'referral_clicked_yn\' id=\'referral_clicked_yn\' value=\'N\'>\n\t \n\t <!--Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1-->\n\t <input type=\'hidden\' name=\'isQMSInOPVisitRegAppl\' id=\'isQMSInOPVisitRegAppl\' value=\'";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\'>\n\t <input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\'";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\'>\n\t <input type=\'hidden\' name=\'visit_date\' id=\'visit_date\' value=\'";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\'>\n\t <input type=\'hidden\' name=\'common_queue_status\' id=\'common_queue_status\' value=\'\'>\n\t <input type=\'hidden\' name=\'common_queue_status_msg\' id=\'common_queue_status_msg\' value=\'\'>\n\t <input type=\'hidden\' name=\'common_queue_id\' id=\'common_queue_id\' value=\'\'>\n\t <input type=\'hidden\' name=\'common_queue_no\' id=\'common_queue_no\' value=\'\'>\n\t <input type=\'hidden\' name=\'common_queue_issue_dt_tm\' id=\'common_queue_issue_dt_tm\' value=\'\'>\n\t <input type=\'hidden\' name=\'common_queue_called_dt_tm\' id=\'common_queue_called_dt_tm\' value=\'\'>\n\t <input type=\'hidden\' name=\'virtual_queue_status\' id=\'virtual_queue_status\' value=\'\'>\n\t <input type=\'hidden\' name=\'virtual_queue_status_msg\' id=\'virtual_queue_status_msg\' value=\'\'>\n\t <input type=\'hidden\' name=\'virtual_queue_id\' id=\'virtual_queue_id\' value=\'\'>\n\t <input type=\'hidden\' name=\'virtual_queue_no\' id=\'virtual_queue_no\' value=\'\'>\n\t <input type=\'hidden\' name=\'virtual_queue_issue_dt_tm\' id=\'virtual_queue_issue_dt_tm\' value=\'\'>\n\t <input type=\'hidden\' name=\'virtual_queue_called_dt_tm\' id=\'virtual_queue_called_dt_tm\' value=\'\'>\n\t \n\t <!--Added by Santhosh for MMS-DM-CRF-0209.4-US005-->\n\t <input type=\'hidden\' name=\'category\' id=\'category\' value=\'\'>\n\t <input type=\'hidden\' name=\'isClinicCategory\' id=\'isClinicCategory\' value=\'";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\'>\n\t <input type=\'hidden\' name=\'firstVisitList\' id=\'firstVisitList\' value=\'";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\'>\n\t <input type=\'hidden\' name=\'followUpVisitList\' id=\'followUpVisitList\' value=\'";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\'>\n\t <input type=\'hidden\' name=\'isReferalId\' id=\'isReferalId\' value=\'";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\'>\n\t <input type=\'hidden\' name=\'referral_req_yn\' id=\'referral_req_yn\' value=\'";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\'>\n\t \n\t <!-- added by Lakshmanan for ML-MMOH-CRF-1930 US008 -->\n\t <input type=\'hidden\' name=\'virtualConsultEnable\' id=\'virtualConsultEnable\' value=\'";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\'>\n\t <input type=\'hidden\' name=\'isVirtualConsultationVisit\' id=\'isVirtualConsultationVisit\' value=\'";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\'>\n\n\t \n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


public StringBuffer getContactDetails(String from,String P_fromValue,String refer_id,String appt_ref_no,Connection con,String facility_id,String locale) throws Exception
{
	PreparedStatement		pstmt1		 = null ;
	ResultSet						resultSet  = null ;
	String sqlContact="";
	String fromValue=P_fromValue;
	String a_res_addr_line1 = "",a_res_addr_line2="",a_res_addr_line3="";
	String a_res_addr_line4 = "",a_country_code="",a_postal_code="";
	String a_res_area			= "",a_res_area_code="",a_res_town2_code="";
	String a_res_town2_desc = "",a_res_region_code="";
	String a_res_region_desc = "" ,m_res_addr_line1="",m_res_addr_line2="";
	String m_res_addr_line3 = "" ,m_res_addr_line4="",m_postal_code="";
	String m_country_code  = "",m_res_area_code="",m_res_area_desc="";
	String m_res_town2_code = "",m_res_town2_desc="",m_res_region_code="";
	String m_res_region_desc = "",strPrimaryResNo="",strOtherResNo="";
	String 	strEmail			= "",country1_desc="",country2_desc="",postal2_desc="",postaldesc1="";
	/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
	String alt_addr_line1 = "",alt_addr_line2="",alt_addr_line3="";
	String alt_addr_line4 = "",alt_country_code="", alt_country_desc="", alt_postal_code="";
	String alt_postal_desc = "", alt_area_desc	= "", alt_area_code="",alt_town_code="";
	String alt_town_desc = "",alt_region_code="", alt_region_desc = ""; 
	/*End*/
	StringBuffer contactAddress=new StringBuffer();
	if(!appt_ref_no.equals("")){
		sqlContact="SELECT res_addr_line1 addr1_line1, res_addr_line2 addr1_line2, res_addr_line3 addr1_line3, res_addr_line4 addr1_line4, res_town_code, (SELECT long_desc  FROM mp_res_town_lang_vw   WHERE language_id='"+locale+"' and res_town_code = a.res_town_code) res_town, res_area_code,       (SELECT long_desc          FROM mp_res_area_lang_vw    WHERE language_id='"+locale+"' and res_area_code = a.res_area_code) res_area,       res_region_code region_code,       (SELECT short_desc          FROM mp_region_lang_vw   WHERE language_id='"+locale+"' and  region_code = a.res_region_code) region,       country_code country1_code,(select long_desc from mp_country_lang_vw where language_id='"+locale+"' and  country_code=a.country_code) country1_desc, postal_code postal1_code,MP_GET_DESC.MP_POSTAL_CODE(postal_code,'"+locale+"','2')postaldesc1,       mail_addr_line1 addr2_line1, mail_addr_line2 addr2_line2,       mail_addr_line3 addr2_line3, mail_addr_line4 addr2_line4,       mail_town_code res_town2_code,       (SELECT short_desc          FROM mp_res_town_lang_vw     WHERE language_id='"+locale+"' and  res_town_code = a.mail_town_code) res_town2,       mail_area_code res_area2_code,       (SELECT short_desc          FROM mp_res_area_lang_vw          WHERE language_id='"+locale+"' and  res_area_code = a.mail_area_code) res_area2,       mail_region_code region2_code,       (SELECT short_desc          FROM mp_region_lang_vw   WHERE language_id='"+locale+"' and  region_code = a.mail_region_code) region2_desc, mail_country_code country2_code,(select short_name from mp_country_lang_vw  where language_id='"+locale+"' and  country_code=a.mail_country_code ) country2_desc, mail_postal_code postal2_code,MP_GET_DESC.MP_POSTAL_CODE(mail_postal_code,'"+locale+"','2')postal2_desc ,     res_tel_no CONTACT1_NO, oth_contact_no CONTACT2_NO, email_id, ALT_ADDR_LINE1, ALT_ADDR_LINE2, ALT_ADDR_LINE3 , ALT_ADDR_LINE4, ALT_TOWN_CODE, (SELECT long_desc FROM mp_res_town_lang_vw WHERE language_id = '"+locale+"' AND res_town_code = a.ALT_TOWN_CODE) ALT_TOWN_DESC, ALT_AREA_CODE, (SELECT long_desc FROM mp_res_area_lang_vw WHERE language_id = '"+locale+"' AND res_area_code = a.ALT_AREA_CODE) ALT_AREA_DESC, ALT_REGION_CODE, (SELECT short_desc FROM mp_region_lang_vw WHERE language_id = '"+locale+"' AND region_code = a.ALT_REGION_CODE) ALT_REGION_DESC, ALT_COUNTRY_CODE, (SELECT short_name FROM mp_country_lang_vw WHERE language_id = '"+locale+"' AND country_code = a.ALT_COUNTRY_CODE) ALT_COUNTRY_DESC, ALT_POSTAL_CODE, mp_get_desc.mp_postal_code (ALT_POSTAL_CODE, '"+locale+"', '2') ALT_POSTAL_DESC  FROM oa_appt a WHERE appt_ref_no=? and facility_id='"+facility_id+"'";//Modified by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601

		fromValue=appt_ref_no;
	} else if(!refer_id.equals("")) {		 
		sqlContact = "SELECT addr_line1 addr1_line1,addr_line2 addr1_line2,addr_line3 addr1_line3,addr_line4 addr1_line4,res_town_code,(SELECT long_desc  FROM mp_res_town_lang_vw WHERE language_id='"+locale+"' and res_town_code = a.res_town_code) res_town,res_area_code, (SELECT long_desc FROM mp_res_area_lang_vw       WHERE language_id='"+locale+"' and res_area_code = a.res_area_code) res_area,region_code,(SELECT short_desc FROM  mp_region_lang_vw WHERE language_id='"+locale+"' and region_code = a.region_code ) region,country_code country1_code,(select long_desc from mp_country_lang_vw where language_id='"+locale+"' and country_code=a.country_code) country1_desc,postal_code postal1_code, MP_GET_DESC.MP_POSTAL_CODE(postal_code,'"+locale+"','2') postaldesc1, mail_addr_line1 addr2_line1, mail_addr_line2 addr2_line2, mail_addr_line3 addr2_line3,mail_addr_line4 addr2_line4,mail_res_town_code res_town2_code, (SELECT short_desc FROM mp_res_town_lang_vw WHERE language_id='"+locale+"' and res_town_code = a.mail_res_town_code) res_town2,mail_res_area_code res_area2_code,(SELECT short_desc FROM mp_res_area_lang_vw WHERE language_id='"+locale+"' and res_area_code = a.mail_res_area_code) res_area2,mail_region_code region2_code,(SELECT short_desc          FROM mp_region_lang_vw WHERE language_id='"+locale+"' and  region_code = a.mail_region_code) region2_desc,mail_country_code country2_code,(select short_name from mp_country_lang_vw where language_id='"+locale+"' and country_code=a.mail_country_code) country2_desc,mail_postal_code postal2_code,MP_GET_DESC.MP_POSTAL_CODE(mail_postal_code,'"+locale+"','2')postal2_desc,contact1_no, contact2_no,email_id, ALT_ADDR_LINE1, ALT_ADDR_LINE2, ALT_ADDR_LINE3 , ALT_ADDR_LINE4, ALT_TOWN_CODE, (SELECT long_desc FROM mp_res_town_lang_vw WHERE language_id = '"+locale+"' AND res_town_code = a.ALT_TOWN_CODE) ALT_TOWN_DESC, ALT_AREA_CODE, (SELECT long_desc FROM mp_res_area_lang_vw WHERE language_id = '"+locale+"' AND res_area_code = a.ALT_AREA_CODE) ALT_AREA_DESC, ALT_REGION_CODE, (SELECT short_desc FROM mp_region_lang_vw WHERE language_id = '"+locale+"' AND region_code = a.ALT_REGION_CODE) ALT_REGION_DESC, ALT_COUNTRY_CODE, (SELECT short_name FROM mp_country_lang_vw WHERE language_id = '"+locale+"' AND country_code = a.ALT_COUNTRY_CODE) ALT_COUNTRY_DESC, ALT_POSTAL_CODE, mp_get_desc.mp_postal_code (ALT_POSTAL_CODE, '"+locale+"', '2') ALT_POSTAL_DESC FROM pr_referral_register a WHERE  referral_id = ? ";//Modified by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
	
		fromValue=refer_id;
	}
	
try { 
		
		pstmt1 = con.prepareStatement(sqlContact) ;
		
		pstmt1.setString( 1, fromValue);
		resultSet = pstmt1.executeQuery() ;
	if(resultSet != null)
	{
		while(resultSet.next())
		{
			a_res_addr_line1 = resultSet.getString("addr1_line1");
			a_res_addr_line2 = resultSet.getString("addr1_line2");
			a_res_addr_line3 = resultSet.getString("addr1_line3");
			a_res_addr_line4 = resultSet.getString("addr1_line4");
			a_country_code  = resultSet.getString("country1_code");
			a_postal_code    = resultSet.getString("postal1_code");
			a_res_area_code = resultSet.getString("res_area_code");
			a_res_area = resultSet.getString("res_area");			
			a_res_town2_code = resultSet.getString("res_town_code");
			a_res_town2_desc = resultSet.getString("res_town");
			a_res_region_code = resultSet.getString("region_code");
			a_res_region_desc = resultSet.getString("region");			
			m_res_addr_line1 = resultSet.getString("addr2_line1");
			m_res_addr_line2 = resultSet.getString("addr2_line2");
			m_res_addr_line3 = resultSet.getString("addr2_line3");
			m_res_addr_line4 = resultSet.getString("addr2_line4");
			m_postal_code    = resultSet.getString("postal2_code");
			m_country_code  = resultSet.getString("country2_code");
			m_res_area_code = resultSet.getString("res_area2_code");
			m_res_area_desc = resultSet.getString("res_area2");
		    m_res_town2_code = resultSet.getString("res_town2_code");
		    m_res_town2_desc = resultSet.getString("res_town2");
		    m_res_region_code = resultSet.getString("region2_code");
		    m_res_region_desc = resultSet.getString("region2_desc");
		    strPrimaryResNo  = resultSet.getString("CONTACT1_NO");
			strOtherResNo    = resultSet.getString("CONTACT2_NO");
			strEmail	   = resultSet.getString("EMAIL_ID");	
			country1_desc	   = resultSet.getString("country1_desc");	
			country2_desc	   = resultSet.getString("country2_desc");	
		    postaldesc1= resultSet.getString("postaldesc1");	
			postal2_desc= resultSet.getString("postal2_desc");	
			
			/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1 = checkForNull(resultSet.getString("alt_addr_line1"));
			alt_addr_line2 = checkForNull(resultSet.getString("ALT_ADDR_LINE2"));
			alt_addr_line3 = checkForNull(resultSet.getString("ALT_ADDR_LINE3"));
			alt_addr_line4 = checkForNull(resultSet.getString("ALT_ADDR_LINE4"));
			alt_country_code  = checkForNull(resultSet.getString("ALT_COUNTRY_CODE"));
			alt_country_desc  = checkForNull(resultSet.getString("ALT_COUNTRY_DESC"));
			alt_postal_code    = checkForNull(resultSet.getString("ALT_POSTAL_CODE"));
			alt_postal_desc    = checkForNull(resultSet.getString("ALT_POSTAL_DESC"));
			alt_area_code = checkForNull(resultSet.getString("ALT_AREA_CODE"));
			alt_area_desc = checkForNull(resultSet.getString("ALT_AREA_DESC"));			
			alt_town_code = checkForNull(resultSet.getString("ALT_TOWN_CODE"));
			alt_town_desc = checkForNull(resultSet.getString("ALT_TOWN_DESC"));
			alt_region_code = checkForNull(resultSet.getString("ALT_REGION_CODE"));
			alt_region_desc = checkForNull(resultSet.getString("ALT_REGION_DESC"));
			/*End*/

		
		}
	}
	if(resultSet != null) resultSet.close();
	if(pstmt1 != null) pstmt1.close();
	if(a_res_addr_line1 == null)a_res_addr_line1="";
			if(a_res_addr_line2 == null)a_res_addr_line2="";
			if(a_res_addr_line3 == null)a_res_addr_line3="";
			if(a_res_addr_line4 == null)a_res_addr_line4="";
			if(a_country_code == null)a_country_code="";
			if(a_postal_code == null)a_postal_code="";
			if(a_res_area_code == null)a_res_area_code="";
			if(a_res_area == null)a_res_area="";
			if(a_res_town2_code == null)a_res_town2_code="";
			if(a_res_town2_desc == null)a_res_town2_desc="";
			if(a_res_region_code == null)a_res_region_code="";
			if(a_res_region_desc == null)a_res_region_desc="";
			if(m_res_addr_line1 == null)m_res_addr_line1="";
			if(m_res_addr_line2 == null)m_res_addr_line2="";
			if(m_res_addr_line3 == null)m_res_addr_line3="";
			if(m_res_addr_line4 == null)m_res_addr_line4="";
			if(m_postal_code == null)m_postal_code="";
			if(m_country_code == null)m_country_code="";
			if(m_res_area_desc == null)m_res_area_desc="";
			if(m_res_town2_code == null)m_res_town2_code="";
			if(m_res_town2_desc == null)m_res_town2_desc="";
			if(m_res_region_code == null)m_res_region_code="";
			if(m_res_region_desc == null)m_res_region_desc="";
			if(strPrimaryResNo == null)strPrimaryResNo="";
			if(strOtherResNo == null)strOtherResNo="";
			if(strEmail == null)strEmail="";
			if(country1_desc == null)country1_desc="";
			if(country2_desc == null)country2_desc="";
			if(postaldesc1==null)postaldesc1="";
			if(postal2_desc==null)postal2_desc="";
		contactAddress.append(""+"^^");
		contactAddress.append(a_res_addr_line1+"^^");
		contactAddress.append(a_res_addr_line2+"^^");
		contactAddress.append(a_res_addr_line3+"^^");
		contactAddress.append(a_res_addr_line4+"^^");
		contactAddress.append(a_res_town2_code+"^^");
		contactAddress.append(a_res_area_code+"^^");
		contactAddress.append(a_postal_code+"^^");
		contactAddress.append(a_res_region_code+"^^");
		contactAddress.append(a_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(m_res_addr_line1+"^^");
		contactAddress.append(m_res_addr_line2+"^^");
		contactAddress.append(m_res_addr_line3+"^^");
		contactAddress.append(m_res_addr_line4+"^^");
		contactAddress.append(m_res_town2_code+"^^");
		contactAddress.append(m_res_area_code+"^^");
		contactAddress.append(m_postal_code+"^^");
		contactAddress.append(m_res_region_code+"^^");
		contactAddress.append(m_country_code+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(strPrimaryResNo+"^^");
		contactAddress.append(strOtherResNo+"^^");
		contactAddress.append(strEmail+"^^");
		contactAddress.append(""+"^^");
		contactAddress.append(a_res_town2_desc+"^^");
		contactAddress.append(a_res_area+"^^");
		contactAddress.append(a_res_region_desc+"^^");
		contactAddress.append(m_res_town2_desc+"^^");
		contactAddress.append(m_res_area_desc+"^^");
		contactAddress.append(m_res_region_desc+"^^");
		contactAddress.append(country1_desc+"^^");
		contactAddress.append(country2_desc+"^^");
		contactAddress.append(postaldesc1+"^^");
		contactAddress.append(postal2_desc);
		/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		contactAddress.append(""+"^^");
		contactAddress.append(alt_addr_line1+"^^");
		contactAddress.append(alt_addr_line2+"^^");
		contactAddress.append(alt_addr_line3+"^^");
		contactAddress.append(alt_addr_line4+"^^");
		contactAddress.append(alt_town_code+"^^");
		contactAddress.append(alt_area_code+"^^");
		contactAddress.append(alt_postal_code+"^^");
		contactAddress.append(alt_region_code+"^^");
		contactAddress.append(alt_country_code+"^^");
		contactAddress.append(alt_town_desc+"^^");
		contactAddress.append(alt_area_desc+"^^");
		contactAddress.append(alt_postal_desc+"^^");
		contactAddress.append(alt_region_desc+"^^");
		contactAddress.append(alt_country_desc+"^^");
		/*End*/

	}catch ( Exception e ){            
            e.printStackTrace() ; }
        finally {      if(resultSet!=null)     resultSet.close();
                       if(pstmt1!=null) pstmt1.close();
                     //  ConnectionManager.returnConnection(con,request);
				 }
		return contactAddress;
}



//String check_patient_id(javax.servlet.jsp.JspWriter out,String patient_id,String fac_id,Connection con,String visit_for_inpat_yn,String call_from,String locale)
/* Modified By Dharma for Non-Citizen Validation on 6th Jan 2014 */
//isNationalIdValidationAppl Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
String check_patient_id(javax.servlet.jsp.JspWriter out,String patient_id,String fac_id,Connection con,String visit_for_inpat_yn,String call_from,String locale,String q_appt_ref_no,String referal_id,boolean isNationalIdValidationAppl,boolean isUHID_valid_appl,String bl_install_yn,boolean isNatIdOrAltIdMandVisaType,boolean isInvokeChngPatDtls,boolean isChkMPParamMandFlds,boolean isCountryRegionValAppl,boolean isNatIdAltIdMandVisaType)
{  
		String alt_status="";
		String continue_yn="Y";		
		char alert_yn='Y';
		String warning_text="";
		String valid_patient_id=patient_id;	
		String in_pat_status = "";
		String result_pr_enc_ref_man	= "Y";/* Added By Dharma for Non-Citizen Validation on 30th Dec 2013 Start*/
		PreparedStatement pstmt1=null;
		Statement stmt1    = null;
		ResultSet rs1    = null;
		
        try { 
                       
			webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
			patdata.setFacility_id(fac_id);
			

			String pat_status = patdata.CheckStatus(con,patient_id);			
			
	        if (pat_status.equals("SUSPENDED")) {
                out.println("<script>alert(parent.frames[1].getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));");
		        out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";	 	            
				valid_patient_id="";
	        } else if (pat_status.equals("DECEASED")) {
				out.println("<script>alert(parent.frames[1].getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));");	out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";					
		        valid_patient_id="";		
	        } else if (pat_status.equals("SECURED")) {
       	        out.println("<script>alert(parent.frames[1].getMessage('SECURED_NOT_ALLOWED','COMMON'));");
    	        out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";
                valid_patient_id="";
	        } else if (pat_status.equals("INACTIVE")) {
		        out.println("<script>alert(parent.frames[1].getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));");
		        out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";
				valid_patient_id="";
         	} else if ( pat_status.equals("INVALID_PATIENT") || alt_status.equals("INVALID_PATIENT") )	{
				out.println("<script>alert(parent.frames[1].getMessage('INVALID_PATIENT','MP'));");
				out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
				alert_yn = 'N';  continue_yn = "N";				  
				valid_patient_id="";
			} else if (pat_status.equals("BLACKLISTED_PATIENT")) {
				out.println("<script>alert(parent.frames[1].getMessage('BLACKLISTED_PATIENT','MP'));");
				out.println("parent.frames[1].document.forms[0].clear1.click();</script>");
				alert_yn = 'N';  continue_yn = "N";	  
				valid_patient_id="";
			} else if (pat_status.indexOf("PATIENT_MERGED_VALID")>=0 ) {
				StringTokenizer token=new StringTokenizer(pat_status,"$");
				valid_patient_id = token.nextToken(); 
				valid_patient_id = token.nextToken();
				
				alert_yn = 'N';  
				continue_yn = "N"; 		
				out.println("<script>var msg =parent.frames[1].getMessage('PATIENT_MERGED_VALID','MP')");
				out.println("msg = msg.replace('#','"+valid_patient_id+"');alert(msg);");
				out.println("parent.frames[1].document.forms[0].pat_id1.value='"+valid_patient_id+"';</script>"); 
				patient_id=valid_patient_id;
			} else if (pat_status != "") {
				warning_text=warning_text+pat_status+ "<br>";
			}
	        
	        /* Added By Dharma for Non-Citizen Validation on 30th Dec 2013 Start*/
		
		  	  if((!valid_patient_id.equals("") && referal_id.equals(""))){
		  		  
		  			  	if(pstmt1 != null) pstmt1.close();
		  				if(rs1  != null) rs1.close();
		  				String PrEncRefManSql =  "select  PR_ENC_REF_MAN(?,?,?,?) from dual";
		  				pstmt1 = con.prepareStatement(PrEncRefManSql);
		  				pstmt1.setString(1,fac_id);
		  				pstmt1.setString(2,valid_patient_id);
		  				pstmt1.setString(3,q_appt_ref_no);
		  				pstmt1.setString(4,"OP");
		  				rs1 = pstmt1.executeQuery();
		  			 try{
		  				 if(rs1!=null && rs1.next()){
		  					 result_pr_enc_ref_man	= rs1.getString(1);
		  				 }

		  				
		  				 if(result_pr_enc_ref_man.equals("N")){
		  					out.println("<script>alert(parent.frames[1].getMessage('PATIENT_IS_NOT_A_CITIZEN','COMMON'));</script>");
		  					out.println("<script>parent.parent.frames[0].document.getElementById('reset').click();</script>");
		  			 		 alert_yn	= 'N';
		  			 		valid_patient_id="";
							continue_yn = "N";
		  				 }
		  			  } catch(Exception e1) {
		  					e1.printStackTrace();
		  			  } finally{
		  				 if(pstmt1 != null) pstmt1.close();
		  				 if(rs1  != null) rs1.close();
		  				}
		  	
		  	  }
		  	  /* Added By Dharma for Non-Citizen Validation on 30th Dec 2013 End*/ 
	        
	    /*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
		if(isNationalIdValidationAppl && alert_yn != 'N')
		{
			JSONObject valJSONObj	= new JSONObject();
			valJSONObj				= eMP.MPCommonBean.getNationalIdValidationYN(con, patient_id, fac_id, "OP");
			String validate_yn		= (String)valJSONObj.get("validate_yn");
			String national_id		= (String)valJSONObj.get("national_id");
			String chk_citizen_yn	= (String)valJSONObj.get("citizen_yn");

			if(validate_yn.equals("Y") && national_id.equals("") && chk_citizen_yn.equals("Y"))
			{	
				out.println("<script>");
				out.println("alert(getMessage('VALIDATE_NATIONAL_ID','MP'))");
				out.println("parent.parent.frames[0].document.getElementById('reset').click();");
				out.println("</script>");
				alert_yn = 'N';  
				continue_yn = "N";
				valid_patient_id = "";
			}else
			{
				alert_yn = 'Y';
			}

			if(alert_yn == 'N')
			{
				alt_status = "";
				in_pat_status = "";
			}
		}
		/*End MO-CRF-20148*/
			
			// added by mujafar for AMRI-CRF-0357 START
			
			//if(isUHID_valid_appl && bl_install_yn.equals("Y") && alert_yn != 'N'  )
		if(isUHID_valid_appl && alert_yn != 'N'   )
		{
							String UHIDValidCount = "0";
							String UHIDValidCount_tmp = "";
							String pat_ser_grp_code = "";
					try{
							
							
						 UHIDValidCount_tmp	= eMP.MPCommonBean.getUHIDValidCount(con,patient_id,fac_id);
						 
						String arr_temp[] = UHIDValidCount_tmp.split("~~");
						UHIDValidCount = arr_temp[0];
						if(arr_temp.length>1)
							pat_ser_grp_code = arr_temp[1];
						
					
						
						if(UHIDValidCount.equals("0"))
						{
							 
					out.println("<script>");		 
					out.println("if(confirm(getMessage('UHID_EXPIRED','MP'))){	");
					out.println("var check = blUHIDBillchk('"+patient_id+"','VISIT_REGISTRATION','OP','"+pat_ser_grp_code+"');");
					out.println("if(check == 'Y'){");
					
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.click();");
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");
					out.println("}else{");
					alert_yn = 'N';  continue_yn = "N";
					valid_patient_id="";
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					
					out.println("}");
					
					out.println("}else{");
					 alert_yn = 'N';  continue_yn = "N";
					valid_patient_id="";
					
					
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					out.println("}");	 
					out.println("</script>");	
						}
						else
						{
							 
							
							 
						}
						
							}
							catch(Exception e1) {
										e1.printStackTrace();
								 } 
								 
								 
							
				
			if(alert_yn == 'N')
			{
					alt_status = "";
					in_pat_status="";
					
			}
			
		}
			
	        // added by mujafar for AMRI-CRF-0357 end
		/* isNatIdOrAltIdMandVisaType Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] Start*/
		JSONObject patDtlsObj	= new JSONObject();
			
			String natId					= "";
			String altId1					= "";
			String altId2					= "";
			String pat_dtls_unknown_yn		= "";
			String citizen_yn				= "";
			String visa_type				= "";
			String altId1Desc				= "";
			String altId2Desc				= "";
			String natIdPrompt				= "";
			String errMsg					= "";
			String showAlert				= "N";
			//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		if((isNatIdOrAltIdMandVisaType || isNatIdAltIdMandVisaType || isInvokeChngPatDtls) && alert_yn != 'N'){
			patDtlsObj						= eMP.MPCommonBean.chkNatIDAltIDAvail(con, patient_id,locale);
			natId					= (String)patDtlsObj.get("national_id_no");
			altId1					= (String)patDtlsObj.get("alt_id1_no");
			altId2					= (String)patDtlsObj.get("alt_id2_no");
			pat_dtls_unknown_yn		= (String)patDtlsObj.get("pat_dtls_unknown_yn");
			citizen_yn				= (String)patDtlsObj.get("citizen_yn");
			visa_type				= (String)patDtlsObj.get("visa_type"); //Maheshwaran added  for AAKH-CRF-0145 as on 22-04-2022
			altId1Desc				= (String)patDtlsObj.get("alt_id1_type_desc");
			altId2Desc				= (String)patDtlsObj.get("alt_id2_type_desc");
			natIdPrompt				= (String)patDtlsObj.get("nat_id_prompt");
			showAlert				= (String)patDtlsObj.get("showAlert");
			//Maheshwaran added  for AAKH-CRF-0145 as on 22-04-2022
			if(visa_type.equals(""))
			visa_type="W";
		}
		if(isNatIdOrAltIdMandVisaType && alert_yn != 'N'){
			if(pat_dtls_unknown_yn.equals("N") && showAlert.equals("Y")){
				if(citizen_yn.equals("Y") && natId.equals("")){
					errMsg	= natIdPrompt;
				}else if(citizen_yn.equals("N") && altId1.equals("") && altId2.equals("") ){
					errMsg	= altId1Desc+"/"+altId2Desc;
				}
				/*if(!errMsg.equals("")){
					out.println("<script>");
					out.println("var message=getMessage('NATID_ALTID_NOT_AVAILABLE','MP'); alert(message.replace('#','"+errMsg+"'));");
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					out.println("</script>");
					alert_yn	= 'N';
					continue_yn = "N";
				}else{
					alert_yn = 'Y';
				}
				if(alert_yn == 'N') {
					alt_status = "";
					in_pat_status = "";
				}*/
			}
		}
		/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] End*/
/*Added By Dharma on 14th May 2020 against KDAH-CRF-0522.1 Start*/
	String strMPParamMandFlds	= "";
	if(isChkMPParamMandFlds && alert_yn != 'N'){
		strMPParamMandFlds = eMP.MPCommonBean.chkMPMandFieldsForEncCreation(con, patient_id,locale);
		if(!strMPParamMandFlds.equals("Y")){
			errMsg	= strMPParamMandFlds;
		}
	}
	if((isNatIdOrAltIdMandVisaType || isChkMPParamMandFlds) && alert_yn != 'N' && !errMsg.equals("")){
		if(!errMsg.equals("")){
			out.println("<script>");
			out.println("var message=getMessage('NATID_ALTID_NOT_AVAILABLE','MP'); alert(message.replace('#','"+errMsg+"'));");
			out.println("parent.parent.frames[0].document.getElementById('reset').click();");
			out.println("</script>");
			alert_yn	= 'N';
			continue_yn = "N";
		}else{
			alert_yn = 'Y';
		}
		if(alert_yn == 'N') {
			alt_status = "";
			in_pat_status = "";
		}
	}
	/*Added By Dharma on 14th May 2020 against KDAH-CRF-0522.1 End*/
 /*Added by Dharma on 24th Apr against MMS-DM-CRF-0152.1 [IN:070226] Start*/ 
 	//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		if((isInvokeChngPatDtls || isNatIdAltIdMandVisaType ) && alert_yn != 'N'){
				if(pat_dtls_unknown_yn.equals("N")  && showAlert.equals("Y") ){
					if(isInvokeChngPatDtls)
						{
						if(citizen_yn.equals("Y") && natId.equals("")){
						errMsg	= natIdPrompt;
						}else if(citizen_yn.equals("N") && altId1.equals("")  ){
						errMsg	= altId1Desc;
						}
						}
					//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022	
					if(isNatIdAltIdMandVisaType)
						{
						if(citizen_yn.equals("Y") && natId.equals("")){
							errMsg	= natIdPrompt;
							}	
							else if(citizen_yn.equals("N") && (visa_type.equals("W")) && natId.equals("") ){
							errMsg	= natIdPrompt;
							}
							else if(citizen_yn.equals("N") && (visa_type.equals("V")) && altId1.equals("") && !altId2.equals("") ){
							errMsg	= altId1Desc;	
							}
							else if(citizen_yn.equals("N") && (visa_type.equals("V")) && !altId1.equals("") && altId2.equals("")){
							errMsg	= altId2Desc;	
							}
							else if(citizen_yn.equals("N") && (visa_type.equals("V")) && altId1.equals("") && altId2.equals("")){
							errMsg	= altId1Desc+"/"+altId2Desc;	
							}								
						}
					if(!errMsg.equals("")){
					out.println("<script>");
						out.println("async function alt (){var message= getMessage('NATID_ALTID_NOT_AVAILABLE_UPDATE','MP'); message = message.replace('#','"+errMsg+"');");
						out.println("if(confirm(message)){");
						out.println("var dialogTop   = '40px'");
						out.println("var dialogHeight    = '400px'") ; 
						out.println("var dialogWidth = '700px'") ;
						out.println("var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no'");
						out.println("var arguments = '' ");
						out.println("var retVal = '';");
						out.println("var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id+"';");
						out.println("retVal = await window.showModalDialog(url,arguments,features);");
						out.println("if(retVal){");
						out.println("if( retVal != null || retVal.length != 0)");
						out.println("parent.close();");
						out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;"); 
						out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.click();");
						out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");

						out.println("}else{");
						out.println("parent.parent.frames[0].document.getElementById('reset').click();");
						out.println("}");
						out.println("}else{");
						out.println("parent.parent.frames[0].document.getElementById('reset').click();");
						out.println("}}");
					out.println("</script>");
					alert_yn	= 'N';
					continue_yn = "N";
					}else{
						alert_yn = 'Y';
					}
					
					if(alert_yn == 'N') {
						alt_status = "";
						in_pat_status = "";
					}
				}
		}
	    /*Added by Dharma on 24th Apr against MMS-DM-CRF-0152.1 [IN:070226] End*/   
			
		/*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
		if(isCountryRegionValAppl && alert_yn != 'N'){

			JSONObject SMSiteJSONObj = new JSONObject();
			SMSiteJSONObj = eSM.SMCommonBean.getSMSiteParamDetails(con);
			String region_prompt = (String)SMSiteJSONObj.get("region_prompt");

			JSONObject MPParamJSONObj = new JSONObject();
			MPParamJSONObj = eMP.MPCommonBean.getMPAuditTrailDetails(con);
			String country_reqd_yn = (String)MPParamJSONObj.get("country_reqd_yn");
			String region_reqd_yn = (String)MPParamJSONObj.get("region_reqd_yn");

			JSONObject PatAddrJSONObj = new JSONObject();
			PatAddrJSONObj = eMP.MPCommonBean.getMPPatContactDetails(con,patient_id);
			String country_code = (String)PatAddrJSONObj.get("country_code");	
			String region_code = (String)PatAddrJSONObj.get("region_code");

			String dispMsg = "";

			if(country_code.equals("") || region_code.equals(""))
			{
				if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("N") && country_code.equals(""))
				{
					dispMsg = "Y";
					out.println("<script>");
					out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',getLabel('Common.country.label','Common'));");
					out.println("</script>");
				}
				else if(country_reqd_yn.equals("N") && region_reqd_yn.equals("Y") && region_code.equals(""))
				{
					dispMsg = "Y";
					out.println("<script>");
					out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#','"+region_prompt+"');");
					out.println("</script>");
				}
				else if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("Y"))
				{
					if(country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("<script>");
						out.println("var cr_prompt = getLabel('Common.country.label','Common')+' '+getLabel('Common.and.label','Common')+' '+'"+region_prompt+"';");
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',cr_prompt);");
						out.println("</script>");
					}
					else if(country_code.equals("") && !region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("<script>");
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',getLabel('Common.country.label','Common'));");
						out.println("</script>");
					}
					else if(!country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("<script>");
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#','"+region_prompt+"');");
						out.println("</script>");
					}
				}else
				{
					dispMsg = "";
				}
			}
			
			if(!dispMsg.equals("")){
					out.println("<script>");
					out.println("if(confirm(message)){");
					out.println("var dialogTop   = '65'");
					out.println("var dialogHeight    = '44'") ; 
					out.println("var dialogWidth = '65'") ;
					out.println("var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no'");
					out.println("var arguments = '' ");
					out.println("var retVal = '';");
					out.println("var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&load_tab=CONTACT_ADDR_TAB&Patient_ID="+patient_id+"';");
					out.println("retVal = window.showModalDialog(url,arguments,features);");
					out.println("if(retVal){");
					out.println("if( retVal != null || retVal.length != 0)");
					out.println("parent.close();");
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;"); 
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.click();");
					out.println("parent.parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");

					out.println("}else{");
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					out.println("}");
					out.println("}else{");
					out.println("parent.parent.frames[0].document.getElementById('reset').click();");
					out.println("}");
					out.println("</script>");
				alert_yn	= 'N';
				continue_yn = "N";
				}else{
					alert_yn = 'Y';
				}
				
				if(alert_yn == 'N') {
					alt_status = "";
					in_pat_status = "";
				}
		}
		/*End AAKH-CRF-0128.1*/

			if(alert_yn != 'N')
			{
				in_pat_status = patdata.CheckInPatient(con,patient_id,fac_id);
				alt_status = patdata.CheckAlternateId(con,patient_id,locale);
				  
				if(in_pat_status.equals("CURRENTLY_IN_PATIENT")) {
					if(visit_for_inpat_yn.equals("Y")){	
						out.println("<script>alert(parent.frames[1].getMessage('CURRENTLY_IN_PATIENT','COMMON'));</script>");
					} else {						
						out.println("<script>alert(parent.frames[1].getMessage('VIS_REGN_NOT_ALLOWED_FOR_CURR_INPAT','OP'));");		
						if(!call_from.equals("CA")){
							out.println("parent.parent.frames[0].document.getElementById('reset').click();</script>");
						}else{
							out.println("window.close();</script>");
						}
						alert_yn = 'N';  continue_yn = "N";
						valid_patient_id="";
					}
				}
				out.println("<script>setTimeout('PatVisHid(4)',200);</script>");// added by munisekhar for MMS-QH-CRF-0162
				
			} 	
		
		    if(!alt_status.equals("")) {
				
				char val=alt_status.charAt(0);
				if(val == 'W') {
					String val1=alt_status.substring(2,alt_status.length());
					out.println("<script>contyn = confirm(\""+val1+"\");  if(!contyn) setValue();</script>"); 
				} else if(val =='C') {			
					String val1=alt_status.substring(1,alt_status.length());
					out.println("<script>alert(\""+val1+"\");setValue();</script>");					
				} else {
					String val1=alt_status.substring(2,alt_status.length());
					out.println("<script>alert(\""+val1+"\");</script>");
				}
			}
	 
	
		} catch (Exception ce){
			try{out.println("check_patient_id:"+ce);}catch(Exception e){e.printStackTrace();}
		}	
	
		return continue_yn;  
}

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");      
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String bean_id = "refusalOrdersBean" ;
String bean_name = "eOR.RefusalOrdersBean";
boolean iSPractVisitLoad=false;//added by munisekhar for MMS-QH-CRF-0167 [IN:044923]
Boolean isImproveReferralProcessAppl = false; 
RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;

Orderables.clearObject();
Properties p=(java.util.Properties) session.getValue("jdbc"); //Added for this CRF GDOH-CRF-0129
//Start - Added for GDOH-CRF-149
	session.removeAttribute("str_clinic_code");
	session.removeAttribute("classTypChangeAuthYnPatId");
//End - Added for GDOH-CRF-149

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

StringBuffer servsql=new StringBuffer();
String short_desc="";
String service_code="";
String room_type="";
String rm_no="";
String to_ser_code="";
String l_encounter_id="";
String open_to_all_pract_yn="";
String register_visit_walkin="";
String register_visit_referral="";
String org_type_data="";
String Pat_Details="";
String dob="";
String seclevel="";
String to_speciality_code = "";
int reccnt=0;
String protectionind="";
double outst_amt=0;
String outst_amt1 = "0";
String gen_file_yn="";
String visit_charge_stage="";
String order_id="";
String sys_date="";
String resource_class=request.getParameter("resource_class")==null?"":request.getParameter("resource_class");
String entitlement_by_cat_yn=request.getParameter("entitlement_by_cat_yn")==null?"":request.getParameter("entitlement_by_cat_yn");
String isPractoApptYn=request.getParameter("isPractoApptYn")==null?"":request.getParameter("isPractoApptYn");
String virtualConsultEnable=request.getParameter("virtualConsultEnable")==null?"":request.getParameter("virtualConsultEnable"); // Added by Lakshmanan ML-MMOH-CRF-1930
System.err.println("isPractoApptYn 107 VisitRegistrationResult.jsp==>"+isPractoApptYn);

//Below line added for this CRF GDOH-CRF-0129
String assigncare_location_code="",assigncare_location_desc="",assigncareloctype="";
Boolean isReferral=false;
Boolean isCurrentEncounter=false;
ArrayList arrIPList=null;
ArrayList arrOPList=null; 
String referralforcurrentencounter="";
//End GDOH-CRF-0129

String res_pract_id="";
//String entitlement_by_cat_yn="";
String regfromquery="Y";
String display_button3="";
String display_button1="";
String HcExpired="";
String episode_close_days_fu="";
String  vis_det_temp_yn="";
String upt_contact_dtls_oa_yn=request.getParameter("upt_contact_dtls_oa_yn")==null?"":request.getParameter("upt_contact_dtls_oa_yn");
String reason_code=request.getParameter("contact_reason_code")==null?"":request.getParameter("contact_reason_code");
String reason=request.getParameter("reason")==null?"":request.getParameter("reason");
String facilityid  = checkForNull((String) session.getValue("facility_id"));
String userid      = checkForNull((String) session.getValue("login_user"));
String emer_regn_allow_yn=request.getParameter("emer_regn_allow_yn")==null?"":request.getParameter("emer_regn_allow_yn");
String invitation_no=request.getParameter("invitation_no")==null?"":request.getParameter("invitation_no");
String bl_interface_yn=request.getParameter("bl_interface_yn")==null?"":request.getParameter("bl_interface_yn");

String inv_splty_code=request.getParameter("inv_splty_code")==null?"":request.getParameter("inv_splty_code");
String q_appt_ref_no=request.getParameter("q_appt_ref_no")==null?"":request.getParameter("q_appt_ref_no");
String q_practitioner_name=request.getParameter("q_practitioner_name")==null?"":request.getParameter("q_practitioner_name");
String oa_install_yn=request.getParameter("oa_install_yn")==null?"":request.getParameter("oa_install_yn");
String or_install_yn=request.getParameter("or_install_yn")==null?"":request.getParameter("or_install_yn");
String referal_id=request.getParameter("referral_id")==null?"":request.getParameter("referral_id");
String query_string=request.getParameter("query_String")==null?"":request.getParameter("query_String");
String Rpractitioner_name=request.getParameter("Rpractitioner_name")==null?"":request.getParameter("Rpractitioner_name");

String from_reg=request.getParameter("from_reg")==null?"":request.getParameter("from_reg");
String dischargedatetime=request.getParameter("dischargedatetime")==null?"":request.getParameter("dischargedatetime");
String bed_num=request.getParameter("bed_num")==null?"":request.getParameter("bed_num");

String nat_id_prompt=request.getParameter("nat_id_prompt")==null?"":request.getParameter("nat_id_prompt");

String register_pat_yn=request.getParameter("register_pat_yn")==null?"":request.getParameter("register_pat_yn");
String reg_vis_param=request.getParameter("reg_vis_param")==null?"":request.getParameter("reg_vis_param");
String q_visit_adm_type_ind=request.getParameter("q_visit_adm_type_ind")==null?"":request.getParameter("q_visit_adm_type_ind");
String episode_close_days_wo_fu=request.getParameter("episode_close_days_wo_fu")==null?"":request.getParameter("episode_close_days_wo_fu");
String ChgToVisitorGrp=request.getParameter("ChgToVisitorGrp")==null?"":request.getParameter("ChgToVisitorGrp");
String patientFlag=request.getParameter("patientFlag")==null?"":request.getParameter("patientFlag");
String pres_class=request.getParameter("pres_class")==null?"":request.getParameter("pres_class");
String q_clinic_desc=request.getParameter("q_clinic_desc")==null?"":request.getParameter("q_clinic_desc");
String q_clinic_code=request.getParameter("q_clinic_code")==null?"":request.getParameter("q_clinic_code");


String q_visit_adm_type_desc=request.getParameter("q_visit_adm_type_desc")==null?"":request.getParameter("q_visit_adm_type_desc");
String q_visit_adm_type=request.getParameter("q_visit_adm_type")==null?"":request.getParameter("q_visit_adm_type");
String q_practitioner_id=request.getParameter("q_practitioner_id")==null?"":request.getParameter("q_practitioner_id");
String q_practitioner_id1=request.getParameter("q_practitioner_id1")==null?"":request.getParameter("q_practitioner_id1");


String CheckinIdent=request.getParameter("CheckinIdent")==null?"":request.getParameter("CheckinIdent");
String functionId=request.getParameter("functionId")==null?"":request.getParameter("functionId");
String menu_function_id=request.getParameter("menu_function_id")==null?"":request.getParameter("menu_function_id");
String res_name=request.getParameter("res_name")==null?"":request.getParameter("res_name");
String res_id=request.getParameter("res_id")==null?"":request.getParameter("res_id");
String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
String order_catalog_desc=request.getParameter("order_catalog_desc")==null?"":request.getParameter("order_catalog_desc");
String episodeReqd=request.getParameter("episodeReqd")==null?"":request.getParameter("episodeReqd");
//Added Incident [52854]
String episode=request.getParameter("episode")==null?"":request.getParameter("episode");
if(episode.equals(""))episode="N";
//End //Added Incident [52854]	
String record=request.getParameter("record")==null?"":request.getParameter("record");
String patient=request.getParameter("patient")==null?"":request.getParameter("patient");
String locale = checkForNull((String)session.getAttribute("LOCALE"));
String bl_install_yn = checkForNull((String)session.getValue("bl_operational"));

String wait_flag=request.getParameter("wait_list_inv")==null?"":request.getParameter("wait_list_inv");
String build_episode_rule=request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
String call_from=request.getParameter("call_from")==null?"":request.getParameter("call_from");

StringBuffer concat_address_hidden=new StringBuffer();
episodeReqd=build_episode_rule;
String curepisodeid="";
String q_appt_time = request.getParameter("q_appt_time")==null?"":request.getParameter("q_appt_time");
String locn_ind = request.getParameter("locn_ind")==null?"":request.getParameter("locn_ind");
String visit_for_inpat_yn = request.getParameter("visit_for_inpat_yn")==null?"N":request.getParameter("visit_for_inpat_yn");  

//String practitioner = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");

String accept_dis_inv_no=(request.getParameter("accept_dis_inv_no") == null)?"":request.getParameter("accept_dis_inv_no");

/*Below line Added for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/
String appt_order=(request.getParameter("appt_order") == null)?"":request.getParameter("appt_order");
String rec_no=(request.getParameter("rec_no") == null)?"":request.getParameter("rec_no");//Added for this incident [52415]
String blflag_op_yn=(request.getParameter("blflag_op_yn") == null)?"":request.getParameter("blflag_op_yn");//Added for this incident [52415]
String from_head=(request.getParameter("from_head") == null)?"":request.getParameter("from_head");//Added for this incident [52619]
String waitlist_status=(request.getParameter("waitlist_status") == null)?"":request.getParameter("waitlist_status");//Added for this incident [52619]

String multi_speciality_yn=(request.getParameter("multi_speciality_yn") == null)?"N":request.getParameter("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
String gif_style="visibility:hidden";
String disable_pract="";
if(multi_speciality_yn.equals("Y")){
	disable_pract="disabled";
}

int serviceCount = 0;

Connection con = null;
PreparedStatement pstmt=null;
String id_type="";
String pref_fac="";
ResultSet rs=null;
String OP_APPL_YN="N";
String IP_APPL_YN="N";
String DC_APPL_YN="N";
String EM_APPL_YN="N";
String assign_q_num_by = "";

String vst_regn_date = "";
String vst_regn_date_new = "";//for incident no 29368 by Srinivasarao Yeluri on 22/02/12
String override_pract_for_appt_yn="";
String override_vtype_on_epsd_yn="";
String visit_backdate_days = "";
int visit_backdate_days_val=0;
String visit_back_yn = "";
String allowed_date = "";
String loctype = "";
String loctypedesc  = "";  
String ref_dtls  = "";  
String dis_value =""; 
String continueYN = "Y";
String disableVisitTemplate = "";
String auth_win_reqd_yn = "N";
String speciality_code = "";
String pat_ser_grp_code = "";
String visit_type_derv_rule = "S";
String action_on_pract_schedule	= "N";//Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
int pr_ent_cnt = 0;
String others_id = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

int order_count_select=0;//this CRFBru-HIMS-CRF-165.1 [IN:035659]
int sec_res_count = 0;//Added for the CRF - Bru-HIMS-CRF-0198

boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
boolean isUHID_valid_appl =false; // Added by mujafar for AMRI-CRF-0357
Boolean isNationalIdValidationAppl = false; //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
boolean isNatIdOrAltIdMandVisaType = false; //Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] 
boolean isNatIdAltIdMandVisaType = false;  	//Maheshwaran added  for AAKH-CRF-0145 as on 22-04-2022
boolean isRoomMandatoryRegVisit = false; //Added by Mujafar on 27th Jun 2019 NMC-JD-CRF-0025
boolean isAllowRegForSameService = false; // Added by mujafar for ML-MMOH-CRF-1437
boolean isVirtualConsultationVisit=false; // added by Lakshmanan for ML-MMOH-CRF-1930 US008
//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
isImproveReferralProcessAppl = false;

//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
Boolean isQMSInOPVisitRegAppl = false;
String patient_name = "";

//Added by Santhosh for MMS-DM-CRF-0209.4-US005
boolean isClinicCategory = false;
String firstVisitList=""; 
String followUpVisitList="";
String isReferalId ="";
String referral_req_yn="";

String gen_remark ="";



try{
	/******************************added for package billing to clear the bean object******************************/
		String bean_id1		= "PkgSubsBean";
		String bean_name1	= "eBL.PkgSubsBean";
		PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id1, bean_name1, request ) ;
		bean.clearBean();
/******************************end******************************/

	if(!query_string.equals(""))
		{	
			session.putValue("queryString",query_string) ;
		}

	con = ConnectionManager.getConnection(request);
	//Added for ML-MMOH-CRF-1802
		if(!patient.equals("")){
			try{
    			pstmt   = con.prepareStatement("select patient_remarks from mp_patient_remarks where patient_id=?");
			pstmt.setString(1, patient);
    			rs    = pstmt.executeQuery();
			if(rs!=null && rs.next())
				{
    gen_remark = checkForNull(rs.getString("patient_remarks"));
				}
    if(pstmt != null) pstmt.close();
    if(rs != null) rs.close();
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		}
	isClinicCategory = CommonBean.isSiteSpecific(con, "OP","CLINIC_CATEGORY");//Added by Santhosh for MMS-DM-CRF-0209.4-US005
	boolean isMohbr = CommonBean.isSiteSpecific(con, "OP","DFLT_APPT_VISIT_TYPE");	//Added for the CRF - PMG2013-BRU-CRF-0002 [IN045555]
	boolean isOrderCtlgAmtCalc = CommonBean.isSiteSpecific(con, "OP","ORDER_CTLG_AMT_CALC");
	boolean downtimePatient =CommonBean.isDownTimePatient(con,patient);//Rameswar
	isRoomMandatoryRegVisit =CommonBean.isSiteSpecific(con, "OP", "ROOM_FOR_CLINIC_PROCUNIT_APPL");//Added by Mujafar on 27th Jun 2019 NMC-JD-CRF-0025
	isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601
	 isUHID_valid_appl = CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357
	 isNationalIdValidationAppl = CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION"); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	 isNatIdOrAltIdMandVisaType = CommonBean.isSiteSpecific(con, "MP", "MP_RES_VAL_VISA_TYPE");//Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] 
	isNatIdAltIdMandVisaType = CommonBean.isSiteSpecific(con, "MP", "MP_VAL_VISA_TYPE"); 	//Maheshwaran added  for AAKH-CRF-0145 as on 22-04-2022
	boolean isInvokeChngPatDtls = CommonBean.isSiteSpecific(con, "MP", "MP_RESIDENCY_NAT_ALT1_ID_MAND"); //Added by Dharma on 24th Apr 2019 against MMS-DM-CRF-0152.1 [IN:070226]

	boolean isCountryRegionValAppl = CommonBean.isSiteSpecific(con, "MP", "CHECK_COUNTRY_REGION");//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
	
	isAllowRegForSameService = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "ALLOW_VISIT_SAME_SER");//Added by Mujafar  for GHL-CRF-0527
	//STARTS -  added for GDOH-CRF-149	
	boolean defFinDtls=false;
	boolean isChkMPParamMandFlds = CommonBean.isSiteSpecific(con, "MP", "MP_CHK_MAND_FLDS"); /*Added by Dharma on 12th May 2020 against KDAH-CRF-0522.1*/

	//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
	isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS"); 
	
	//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
	isQMSInOPVisitRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","QMS_IN_OP_VISIT_REG");
	
	isVirtualConsultationVisit=CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION"); // added by Lakshmanan for ML-MMOH-CRF-1930 US008
	try
	{
		
		defFinDtls = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_FIN_CLASS_DTLS_BLANK");

	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in site specific "+e);
	}
	//ENDS -  added for GDOH-CRF-149
	Boolean isForm60Available	= CommonBean.isSiteSpecific(con, "MP","REG_PAT_ALT_ID3_PAN_CARD");//Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799]
	
	Boolean validationForPanCardAvail	= CommonBean.isSiteSpecific(con, "MP","GENERATE_FORM_60"); //Added by Sangeetha on  10/apr/17 for KDAH-CRF-0347

	/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
	HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(con, "OA","REMARKS_FOR_OTHERS");
	others_id	= (String)hashdata.get("value1");
	if(others_id == null) others_id = "";
	/*End ML-MMOH-CRF-1114*/
	
  //Below line added for this GDOH-CRF-0129
  isReferral=CommonBean.isSiteSpecific(con, "IP","REGISTER_REFERRAL");  
	 if(isReferral){
		arrIPList=(ArrayList)ReferralCurrentEncounterDetails.getIPCurrentEncounterDetails(con,patient,facilityid,p);
			 for(int ip=0; ip<arrIPList.size(); ip++){
					ReferralCurrentEncounterDetailsBean ipEncounterDetails=(ReferralCurrentEncounterDetailsBean)arrIPList.get(ip); 
					assigncare_location_code=ipEncounterDetails.getAssigncareloccode();
					assigncare_location_desc=ipEncounterDetails.getAssigncarelocdesc();
					assigncareloctype=ipEncounterDetails.getAssigncareloctype();
					referralforcurrentencounter="disabled";
					isCurrentEncounter=true;
					
			 }
	 if(arrIPList.size()==0){
		arrOPList=(ArrayList)ReferralCurrentEncounterDetails.getOPCurrentEncounterDetails(con,patient,facilityid,p);
			 for(int op=0; op<arrOPList.size(); op++){
					ReferralCurrentEncounterDetailsBean opEncounterDetails=(ReferralCurrentEncounterDetailsBean)arrOPList.get(op); 
					assigncare_location_code=opEncounterDetails.getAssigncareloccode();
					assigncare_location_desc=opEncounterDetails.getAssigncarelocdesc();
					assigncareloctype=opEncounterDetails.getAssigncareloctype();
					referralforcurrentencounter="disabled";
					isCurrentEncounter=true;
			}
		  }
	 }
 //End GDOH-CRF-0129	
	

	/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
	  String reg_date_time =CommonBean.getRegistrationDateTime(con,patient);//Dharma May 24,2016
	  if(!reg_date_time.equals("")){
		  reg_date_time = DateUtils.convertDate(reg_date_time,"DMYHMS","en",locale);
	  }
	 /*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/


	if(!q_appt_ref_no.equals("") || !invitation_no.equals("")) {		
		//continueYN = check_patient_id(out,patient,facilityid,con,visit_for_inpat_yn,call_from,locale);
		/* Modified By Dharma for Non-Citizen Validation on 6th Jan 2014 */
			//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		continueYN = check_patient_id(out,patient,facilityid,con,visit_for_inpat_yn,call_from,locale,q_appt_ref_no,referal_id,isNationalIdValidationAppl,isUHID_valid_appl,bl_install_yn,isNatIdOrAltIdMandVisaType,isInvokeChngPatDtls,isChkMPParamMandFlds,isCountryRegionValAppl,isNatIdAltIdMandVisaType); //Modified by Ashwini on 06-Mar-2019 for MO-CRF-20148
	}
	
	if(continueYN.equals("Y")) {

	if((!q_appt_ref_no.equals("")) || (!referal_id.equals(""))) {
		concat_address_hidden = getContactDetails("",patient,referal_id,q_appt_ref_no,con,facilityid,locale);
	}


	 /*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */	
	String select_order="SELECT count(*) order_record_count FROM  or_order_catalog a, OR_APPT_REF_CATALOG b where APPT_REF_NO='"+q_appt_ref_no+"' and FACILITY_ID ='"+facilityid+"' and a.ORDER_CATALOG_CODE =b.ORDER_CATALOG_CODE";		
	pstmt=con.prepareStatement(select_order);
	rs = pstmt.executeQuery();
	if(rs.next()) {	  	
		order_count_select=rs.getInt("order_record_count");	
	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();	
  /*End this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
	
	
	//pstmt=con.prepareStatement("select ASSIGN_QUEUE_NUM_BY,use_template_in_vis_regn_yn, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_new, OVERRIDE_PRACT_FOR_APPT_YN, OVERRIDE_VTYPE_ON_EPSD_YN,VISIT_BACKDATE_DAYS, to_char((sysdate - NVL(VISIT_BACKDATE_DAYS,0)),'dd/mm/yyyy hh24:mi:ss') sys1,VISIT_TYPE_DERV_RULE from op_param where operating_facility_id='"+facilityid+"'");//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368
pstmt=con.prepareStatement("select action_on_pract_schedule,ASSIGN_QUEUE_NUM_BY,use_template_in_vis_regn_yn, to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_new, OVERRIDE_PRACT_FOR_APPT_YN, OVERRIDE_VTYPE_ON_EPSD_YN,VISIT_BACKDATE_DAYS, to_char((sysdate - NVL(VISIT_BACKDATE_DAYS,0)),'dd/mm/yyyy hh24:mi:ss') sys1,VISIT_TYPE_DERV_RULE, REFERRAL_REQ_YN from op_param where operating_facility_id='"+facilityid+"'");//modified for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
	rs = pstmt.executeQuery();

	if(rs.next()) {	  		
		action_on_pract_schedule	= rs.getString("action_on_pract_schedule");//Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
		assign_q_num_by = checkForNull(rs.getString("ASSIGN_QUEUE_NUM_BY"));
		vst_regn_date = checkForNull(rs.getString("sys"));
		vst_regn_date_new =  checkForNull(rs.getString("sys_new")); // for incident 29368
		override_pract_for_appt_yn = checkForNull(rs.getString("OVERRIDE_PRACT_FOR_APPT_YN"));		
		override_vtype_on_epsd_yn = rs.getString("OVERRIDE_VTYPE_ON_EPSD_YN") == null? "N" : rs.getString("OVERRIDE_VTYPE_ON_EPSD_YN");	
		visit_backdate_days = rs.getString("VISIT_BACKDATE_DAYS") == null? "" : rs.getString("VISIT_BACKDATE_DAYS");
		allowed_date = rs.getString("sys1") == null? "" : rs.getString("sys1");
		vis_det_temp_yn = rs.getString( "use_template_in_vis_regn_yn" ) == null? "N" : rs.getString("use_template_in_vis_regn_yn");
		visit_type_derv_rule = rs.getString( "VISIT_TYPE_DERV_RULE" ) == null? "S" : rs.getString("VISIT_TYPE_DERV_RULE");
		referral_req_yn = rs.getString( "REFERRAL_REQ_YN" ) == null? "N" : rs.getString("REFERRAL_REQ_YN");
		
	}	

	
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();

	if(!q_appt_ref_no.equals("") || !invitation_no.equals("") || !vis_det_temp_yn.equals("Y")) {
		disableVisitTemplate = "disabled";
	} else {
		disableVisitTemplate = "";
	}

    if(!( visit_backdate_days ==null || visit_backdate_days.equals("") ))
		visit_backdate_days_val =Integer.parseInt(visit_backdate_days);

    if (visit_backdate_days_val > 0) {
		visit_back_yn = "Y";
	}
	vst_regn_date = DateUtils.convertDate(vst_regn_date,"DMYHMS","en",locale);//format changed by Srinivasrao Yeluri for incident  no 29368

	vst_regn_date_new = DateUtils.convertDate(vst_regn_date_new,"DMYHM","en",locale);
	
	if(q_appt_ref_no.equals("") && referal_id.equals("")) {

		pstmt = con.prepareStatement("SELECT addr1_type, addr1_line1, addr1_line2, addr1_line3, addr1_line4,postal1_code, MP_GET_DESC.MP_POSTAL_CODE(postal1_code,'"+locale+"','2') postaldesc1,country1_code,(select long_desc from mp_country_lang_vw where language_id='"+locale+"' and country_code=a.country1_code) country1_desc,contact1_name,invalid1_yn,(select long_desc from mp_res_area_lang_vw  where language_id='"+locale+"' and res_area_code=b.res_area_code) res_area,b.res_area_code ,(select long_desc from mp_res_town_lang_vw  where language_id='"+locale+"' and res_town_code= b.res_town_code) res_town,b.res_town_code ,(select short_desc from mp_region_lang_vw where language_id='"+locale+"' and region_code=b.region_code) region,b.region_code, addr2_type,addr2_line1,addr2_line2, addr2_line3,addr2_line4,postal2_code,MP_GET_DESC.MP_POSTAL_CODE(postal2_code,'"+locale+"','2')postal2_desc,country2_code,(select short_name from mp_country_lang_vw where language_id='"+locale+"' and country_code=a.country2_code) country2_desc,contact2_name,invalid2_yn, (select short_desc from mp_res_area_lang_vw where language_id='"+locale+"' and  res_area_code=a.res_area2_code ) res_area2,a.res_area2_code, (select short_desc from mp_res_town_lang_vw  where language_id='"+locale+"' and res_town_code=res_town2_code) res_town2, res_town2_code,(select short_desc from mp_region_lang_vw  where language_id='"+locale+"' and region_code=region2_code) region2_desc,region2_code, CONTACT1_NO, CONTACT2_NO, EMAIL_ID, nvl(pref_facility_id,'') pref_facility_id, nvl(EMEG_REGN_YN,'N') emer_regn_yn, b.pat_ser_grp_code pat_ser_grp_code , c.id_type, (select count(*) from pr_encounter where facility_id='"+facilityid+"' and patient_id='"+patient+"') pr_ent_cnt,0 sec_res_count, alt_addr_type, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_postal_code, mp_get_desc.mp_postal_code (alt_postal_code, '"+locale+"', '2' ) alt_postal_desc, alt_country_code, (select short_name from mp_country_lang_vw where language_id = '"+locale+"' and country_code = a.alt_country_code) alt_country_desc, alt_contact_name, alt_invalid_yn, (select short_desc from mp_res_area_lang_vw where language_id = '"+locale+"' and res_area_code = a.alt_area_code) alt_area_desc, a.alt_area_code, (select short_desc from mp_res_town_lang_vw where language_id = '"+locale+"' and res_town_code = a.alt_town_code) alt_town_desc, alt_town_code, (select short_desc from mp_region_lang_vw where language_id = '"+locale+"' and region_code = alt_region_code) alt_region_desc, alt_region_code, b.patient_name FROM mp_pat_addresses a , MP_PATIENT b, mp_pat_ser_grp c WHERE b.PATIENT_ID = a.PATIENT_ID and  b.patient_id='"+patient+"' and c.pat_ser_grp_code = b.pat_ser_grp_code "); //Modified by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601

	} else {

		pstmt = con.prepareStatement("select nvl(pref_facility_id,'') pref_facility_id, nvl(EMEG_REGN_YN,'N') emer_regn_yn, a.pat_ser_grp_code pat_ser_grp_code, b.id_type, (select count(*) from pr_encounter where facility_id='"+facilityid+"' and patient_id='"+patient+"') pr_ent_cnt,(select count(*) from oa_resource_for_appt where facility_id='"+facilityid+"' and APPT_REF_NO='"+q_appt_ref_no+"') sec_res_count, a.patient_name from mp_patient a, mp_pat_ser_grp b where patient_id = '"+patient+"' and a.pat_ser_grp_code = b.pat_ser_grp_code");
	}

    rs = pstmt.executeQuery();
    if(rs!=null && rs.next())
	{		  
		id_type = (rs.getString("id_type") == null)?"":rs.getString("id_type");
		pref_fac=rs.getString("pref_facility_id")==null?"":rs.getString("pref_facility_id"); 
		pat_ser_grp_code = rs.getString("pat_ser_grp_code")==null?"":rs.getString("pat_ser_grp_code");
		pr_ent_cnt = rs.getInt("pr_ent_cnt");
		//Added for the CRF - Bru-HIMS-CRF-0198 - start
		sec_res_count = rs.getInt("sec_res_count");
		if((!q_appt_ref_no.equals("")) && sec_res_count > 0 && multi_speciality_yn.equals("Y")){
			gif_style="visibility:visible";
		}
		//Added for the CRF - Bru-HIMS-CRF-0198 - end
		
		//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
		patient_name = (rs.getString("patient_name") == null)?"":rs.getString("patient_name");
		
		if(q_appt_ref_no.equals("") && referal_id.equals("")) {

			String a_res_addr_line1 = "",a_res_addr_line2="",a_res_addr_line3="";
			String a_res_addr_line4 = "",a_country_code="",a_postal_code="";
			String a_res_area			= "",a_res_area_code="",a_res_town2_code="";
			String a_res_town2_desc = "",a_res_region_code="";
			String a_res_region_desc = "" ,m_res_addr_line1="",m_res_addr_line2="";
			String m_res_addr_line3 = "" ,m_res_addr_line4="",m_postal_code="";
			String m_country_code  = "",m_res_area_code="",m_res_area_desc="";
			String m_res_town2_code = "",m_res_town2_desc="",m_res_region_code="";
			String m_res_region_desc = "",strPrimaryResNo="",strOtherResNo="";
			String 	strEmail			= "",country1_desc="",country2_desc="",postal2_desc="",postaldesc1="";
			StringBuffer contactAddress=new StringBuffer();

			/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			String alt_addr_line1 = "",alt_addr_line2="",alt_addr_line3="";
			String alt_addr_line4 = "",alt_country_code="", alt_country_desc="", alt_postal_code="";
			String alt_postal_desc = "", alt_area_desc	= "", alt_area_code="",alt_town_code="";
			String alt_town_desc = "",alt_region_code="", alt_region_desc = ""; 
			alt_addr_line1 = checkForNull(rs.getString("alt_addr_line1"));
			alt_addr_line2 = checkForNull(rs.getString("ALT_ADDR_LINE2"));
			alt_addr_line3 = checkForNull(rs.getString("ALT_ADDR_LINE3"));
			alt_addr_line4 = checkForNull(rs.getString("ALT_ADDR_LINE4"));
			alt_country_code  = checkForNull(rs.getString("ALT_COUNTRY_CODE"));
			alt_country_desc  = checkForNull(rs.getString("ALT_COUNTRY_DESC"));
			alt_postal_code    = checkForNull(rs.getString("ALT_POSTAL_CODE"));
			alt_postal_desc    = checkForNull(rs.getString("ALT_POSTAL_DESC"));
			alt_area_code = checkForNull(rs.getString("ALT_AREA_CODE"));
			alt_area_desc = checkForNull(rs.getString("ALT_AREA_DESC"));			
			alt_town_code = checkForNull(rs.getString("ALT_TOWN_CODE"));
			alt_town_desc = checkForNull(rs.getString("ALT_TOWN_DESC"));
			alt_region_code = checkForNull(rs.getString("ALT_REGION_CODE"));
			alt_region_desc = checkForNull(rs.getString("ALT_REGION_DESC"));
			/*End*/

			a_res_addr_line1 = rs.getString("addr1_line1");
			a_res_addr_line2 = rs.getString("addr1_line2");
			a_res_addr_line3 = rs.getString("addr1_line3");
			a_res_addr_line4 = rs.getString("addr1_line4");
			a_country_code  = rs.getString("country1_code");
			a_postal_code    = rs.getString("postal1_code");
			a_res_area_code = rs.getString("res_area_code");
			a_res_area = rs.getString("res_area");			
			a_res_town2_code = rs.getString("res_town_code");
			a_res_town2_desc = rs.getString("res_town");
			a_res_region_code = rs.getString("region_code");
			a_res_region_desc = rs.getString("region");			
			m_res_addr_line1 = rs.getString("addr2_line1");
			m_res_addr_line2 = rs.getString("addr2_line2");
			m_res_addr_line3 = rs.getString("addr2_line3");
			m_res_addr_line4 = rs.getString("addr2_line4");
			m_postal_code    = rs.getString("postal2_code");
			m_country_code  = rs.getString("country2_code");
			m_res_area_code = rs.getString("res_area2_code");
			m_res_area_desc = rs.getString("res_area2");
			m_res_town2_code = rs.getString("res_town2_code");
			m_res_town2_desc = rs.getString("res_town2");
			m_res_region_code = rs.getString("region2_code");
			m_res_region_desc = rs.getString("region2_desc");
			strPrimaryResNo  = rs.getString("CONTACT1_NO");
			strOtherResNo    = rs.getString("CONTACT2_NO");
			strEmail	   = rs.getString("EMAIL_ID");	
			country1_desc	   = rs.getString("country1_desc");	
			country2_desc	   = rs.getString("country2_desc");	
			postaldesc1= rs.getString("postaldesc1");	
			postal2_desc= rs.getString("postal2_desc"); 

			if(a_res_addr_line1 == null)a_res_addr_line1="";
			if(a_res_addr_line2 == null)a_res_addr_line2="";
			if(a_res_addr_line3 == null)a_res_addr_line3="";
			if(a_res_addr_line4 == null)a_res_addr_line4="";
			if(a_country_code == null)a_country_code="";
			if(a_postal_code == null)a_postal_code="";
			if(a_res_area_code == null)a_res_area_code="";
			if(a_res_area == null)a_res_area="";
			if(a_res_town2_code == null)a_res_town2_code="";
			if(a_res_town2_desc == null)a_res_town2_desc="";
			if(a_res_region_code == null)a_res_region_code="";
			if(a_res_region_desc == null)a_res_region_desc="";
			if(m_res_addr_line1 == null)m_res_addr_line1="";
			if(m_res_addr_line2 == null)m_res_addr_line2="";
			if(m_res_addr_line3 == null)m_res_addr_line3="";
			if(m_res_addr_line4 == null)m_res_addr_line4="";
			if(m_postal_code == null)m_postal_code="";
			if(m_country_code == null)m_country_code="";
			if(m_res_area_desc == null)m_res_area_desc="";
			if(m_res_town2_code == null)m_res_town2_code="";
			if(m_res_town2_desc == null)m_res_town2_desc="";
			if(m_res_region_code == null)m_res_region_code="";
			if(m_res_region_desc == null)m_res_region_desc="";
			if(strPrimaryResNo == null)strPrimaryResNo="";
			if(strOtherResNo == null)strOtherResNo="";
			if(strEmail == null)strEmail="";
			if(country1_desc == null)country1_desc="";
			if(country2_desc == null)country2_desc="";
			if(postaldesc1==null)postaldesc1="";
			if(postal2_desc==null)postal2_desc="";
			if(m_res_area_code==null)m_res_area_code="";
			
			contactAddress.append(""+"^^");
			contactAddress.append(a_res_addr_line1+"^^");
			contactAddress.append(a_res_addr_line2+"^^");
			contactAddress.append(a_res_addr_line3+"^^");
			contactAddress.append(a_res_addr_line4+"^^");
			contactAddress.append(a_res_town2_code+"^^");
			contactAddress.append(a_res_area_code+"^^");
			contactAddress.append(a_postal_code+"^^");
			contactAddress.append(a_res_region_code+"^^");
			contactAddress.append(a_country_code+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(m_res_addr_line1+"^^");
			contactAddress.append(m_res_addr_line2+"^^");
			contactAddress.append(m_res_addr_line3+"^^");
			contactAddress.append(m_res_addr_line4+"^^");
			contactAddress.append(m_res_town2_code+"^^");
			contactAddress.append(m_res_area_code+"^^");
			contactAddress.append(m_postal_code+"^^");
			contactAddress.append(m_res_region_code+"^^");
			contactAddress.append(m_country_code+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(strPrimaryResNo+"^^");
			contactAddress.append(strOtherResNo+"^^");
			contactAddress.append(strEmail+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(a_res_town2_desc+"^^");
			contactAddress.append(a_res_area+"^^");
			contactAddress.append(a_res_region_desc+"^^");
			contactAddress.append(m_res_town2_desc+"^^");
			contactAddress.append(m_res_area_desc+"^^");
			contactAddress.append(m_res_region_desc+"^^");
			contactAddress.append(country1_desc+"^^");
			contactAddress.append(country2_desc+"^^");
			contactAddress.append(postaldesc1+"^^");
			contactAddress.append(postal2_desc);
			/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			contactAddress.append(""+"^^");
			contactAddress.append(alt_addr_line1+"^^");
			contactAddress.append(alt_addr_line2+"^^");
			contactAddress.append(alt_addr_line3+"^^");
			contactAddress.append(alt_addr_line4+"^^");
			contactAddress.append(alt_town_code+"^^");
			contactAddress.append(alt_area_code+"^^");
			contactAddress.append(alt_postal_code+"^^");
			contactAddress.append(alt_region_code+"^^");
			contactAddress.append(alt_country_code+"^^");
			contactAddress.append(alt_town_desc+"^^");
			contactAddress.append(alt_area_desc+"^^");
			contactAddress.append(alt_postal_desc+"^^");
			contactAddress.append(alt_region_desc+"^^");
			contactAddress.append(alt_country_desc+"^^");
			/*End*/

			concat_address_hidden = contactAddress;
		}

	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();
	
	//Added by Santhosh for MMS-DM-CRF-0209.4-US005
	pstmt = con.prepareStatement("SELECT VISIT_TYPE_CODE FROM OP_VISIT_TYPE WHERE VISIT_TYPE_IND='F' AND EFF_STATUS='E'");
	
    rs = pstmt.executeQuery();
    if(rs!=null){
		while(rs.next()){
			firstVisitList = (firstVisitList=="" || firstVisitList.equals(""))?checkForNull(rs.getString("VISIT_TYPE_CODE")):firstVisitList+","+checkForNull(rs.getString("VISIT_TYPE_CODE"));
		}
	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();
	
	pstmt = con.prepareStatement("SELECT VISIT_TYPE_CODE FROM OP_VISIT_TYPE WHERE VISIT_TYPE_IND='L' AND EFF_STATUS='E'");
	
    rs = pstmt.executeQuery();
    if(rs!=null){
		while(rs.next()){
			followUpVisitList = (followUpVisitList=="" || followUpVisitList.equals(""))?checkForNull(rs.getString("VISIT_TYPE_CODE")):followUpVisitList+","+checkForNull(rs.getString("VISIT_TYPE_CODE"));
		}
	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();
	
	pstmt = con.prepareStatement("select REFERRAL_ID from PR_REFERRAL_REGISTER where PATIENT_ID='"+patient+"'");
    rs = pstmt.executeQuery();
    if(rs!=null && rs.next()) {
		isReferalId = (rs.getString("REFERRAL_ID") == null)?"":rs.getString("REFERRAL_ID");
	}
	if(rs != null) rs.close();		
	if(pstmt!=null)pstmt.close();
	
	System.err.println("firstVisitList============"+firstVisitList);
if(emer_regn_allow_yn.equals("N")&&id_type.equals("E"))
	{
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{

if(!facilityid.equals(pref_fac))
   {
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block2Bytes, _wl_block2);

if(call_from.equals("CA"))
{

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block12Bytes, _wl_block12);

}
else
{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block14Bytes, _wl_block14);

 }
 
            _bw.write(_wl_block15Bytes, _wl_block15);
if(isImproveReferralProcessAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

  
 if (bl_interface_yn.equals("Y") && bl_install_yn.equals("Y") && regfromquery.equals("Y"))
  {
	
	CallableStatement call = con.prepareCall("{ ? = call  BLCOMMON.IS_AUTH_WINDOW_REQUIRED('"+facilityid+"', '"+patient+"','O',?)}");

	call.registerOutParameter(1, java.sql.Types.VARCHAR);
	call.registerOutParameter(2, java.sql.Types.VARCHAR); 	
	call.execute(); 
	
	auth_win_reqd_yn = checkForNull(call.getString(1));
	outst_amt = call.getDouble(2);	
	
	outst_amt1 = ""+outst_amt;
	
    CurrencyFormat cf1 = new CurrencyFormat();
    outst_amt1 = cf1.formatCurrency(outst_amt1, 2);
	
	reccnt = 1;
    record="Y";	

	if(call!=null)
		call.close();

   }
            _bw.write(_wl_block18Bytes, _wl_block18);

	if(bl_install_yn.equals("Y"))
	{

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
} else { 
            _bw.write(_wl_block22Bytes, _wl_block22);
 } 
            _bw.write(_wl_block23Bytes, _wl_block23);

	    if(!referal_id.equals("")) {
			pstmt  = con.prepareStatement("select get_referral_detail_line('"+referal_id+"','FROM','"+locale+"') from dual");
			rs = pstmt.executeQuery() ;
			rs.next() ; 
			//ref_dtls = (rs.getString(1).substring(2));
			ref_dtls = checkForNull(rs.getString(1));
			if(!ref_dtls.equals(""))
				ref_dtls = ref_dtls.substring(2);
		}
	

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ref_dtls));
            _bw.write(_wl_block26Bytes, _wl_block26);

	   if(rs != null) rs.close();
	   if(pstmt != null) pstmt.close(); 
	 
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

		if(!q_appt_ref_no.equals("")) {
	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(q_appt_time));
            _bw.write(_wl_block31Bytes, _wl_block31);

		to_ser_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");
		}
	
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 if (bl_install_yn.equals("Y")&&(outst_amt > 0)) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(outst_amt1));
            _bw.write(_wl_block35Bytes, _wl_block35);
 } 
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
 if (visit_back_yn.equalsIgnoreCase("Y")) { 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(vst_regn_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(allowed_date));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(vst_regn_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(vst_regn_date_new));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else {
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(vst_regn_date));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(vst_regn_date_new));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facilityid ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disableVisitTemplate));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(facilityid ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(disableVisitTemplate));
            _bw.write(_wl_block51Bytes, _wl_block51);
if(isQMSInOPVisitRegAppl){
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
 if (!q_visit_adm_type.equals("")) {       
	pstmt   = con.prepareStatement( "select short_desc from op_visit_type_lang_vw where visit_type_code = ? and facility_id=? and language_id='"+locale+"'"); pstmt.setString(1,q_visit_adm_type); 
	pstmt.setString(2,facilityid); 
	rs =  pstmt.executeQuery(); 
	if (rs!=null) 
	{ 
		while(rs.next()) 
		{ 
			q_visit_adm_type_desc = checkForNull(rs.getString(1)); 
		} 
	} 
	if (rs != null)   
		rs.close(); 
	if (pstmt != null) 
		pstmt.close();     
	}    

if(!order_catalog_code.equals("")) 
{ 
	pstmt=con.prepareStatement("select long_desc from or_order_catalog where order_catalog_code='"+order_catalog_code+"'"); 
	rs=pstmt.executeQuery(); 
	if(rs != null) 
	{ 
		if(rs.next()) 
		{ 
			order_catalog_desc=checkForNull(rs.getString(1)); 
		} 
	} 
	if(rs != null) 
		rs.close(); 
	if(pstmt != null) 
		pstmt.close(); 
}	

if(!q_practitioner_id.equals("")) 
{ 
	q_practitioner_id   = request.getParameter("q_practitioner_id")==null?"":request.getParameter("q_practitioner_id");

pstmt   = con.prepareStatement( "select practitioner_name from am_practitioner_lang_vw where practitioner_id = '"+q_practitioner_id+"' and language_id='"+locale+"'");

            rs =  pstmt.executeQuery();
            if (rs!=null)
            {
              while(rs.next())
              {
                q_practitioner_name = checkForNull(rs.getString(1));              
              }
            }
			if (rs != null)   rs.close();
            if (pstmt != null) pstmt.close();
              
             
      }	
	  
	  if(!q_appt_ref_no.equals(""))
	 {
		   if(!resource_class.equals("P") && !resource_class.equals("") && multi_speciality_yn.equals("N"))
		   {			   
		   	     q_practitioner_name="";
		   }
		   if(resource_class.equals("E") || resource_class.equals("O"))
		   {
				res_name=Rpractitioner_name;
				res_id=q_practitioner_id;
				

		   }

	 }
	  



	 
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
 if (!locn_ind.equals(""))  {
            _bw.write(_wl_block58Bytes, _wl_block58);
}else{
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);


		try{
			String sql_locn = "select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E') and locn_type in ('C','E') and SYS_USER_DEF_IND='S' and language_id='"+localeName+"' order by short_desc ";	
							
			pstmt=con.prepareStatement(sql_locn);
			rs=pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					loctype=checkForNull(rs.getString("locn_type"));
					loctypedesc=checkForNull(rs.getString("short_desc"));
					if(loctype.equals(locn_ind)) {
            
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(loctype));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(loctypedesc));
            _bw.write(_wl_block64Bytes, _wl_block64);
}else{ 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(loctype));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(loctypedesc));
            _bw.write(_wl_block67Bytes, _wl_block67);
} }				
		       }	
		
			if(rs != null ) rs.close();
			if(pstmt != null ) pstmt.close();							
		} catch(Exception e) {
			e.printStackTrace();
		}


	
            _bw.write(_wl_block68Bytes, _wl_block68);

	 	
 iSPractVisitLoad=eOP.QMSInterface.isSiteSpecific(con,"OP","PRACT_VISIT_LOAD");//added by munisekhar for MMS-QH-CRF-0167 [IN:044923] 
	// naren - to be checked
	if(!referal_id.equals(""))
	{
	pstmt   = con.prepareStatement("Select TO_SPECIALITY_CODE,TO_SERVICE_CODE  from PR_REFERRAL_REGISTER where REFERRAL_ID = ? ");
	pstmt.setString(1,referal_id);
	
	rs = pstmt.executeQuery();
	while( rs.next() )
		{
		
	to_speciality_code = rs.getString("TO_SPECIALITY_CODE")==null?"":rs.getString("TO_SPECIALITY_CODE");
	to_ser_code        = rs.getString("to_service_code")==null?"":rs.getString("to_service_code");
	
		}
	}
	 if(rs != null) rs.close();
	 if(pstmt != null) pstmt.close();
 	  

   if (q_clinic_code.equals(""))
    { 	
  
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(invitation_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(referal_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block71Bytes, _wl_block71);
if(isImproveReferralProcessAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(invitation_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(referal_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block71Bytes, _wl_block71);
if(isImproveReferralProcessAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block73Bytes, _wl_block73);
if(iSPractVisitLoad){
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{	
     pstmt   = con.prepareStatement( "select open_to_all_pract_yn,ident_at_checkin,primary_resource_class,long_desc, OP_APPL_YN, DC_APPL_YN, IP_APPL_YN, EM_APPL_YN,SPECIALITY_CODE from op_clinic_lang_vw where clinic_code='"+q_clinic_code+"' and language_id='"+locale+"' and facility_id='"+facilityid+"'");
     
	 rs = pstmt.executeQuery();
     if(rs != null)
      {
        while (rs.next())
	    { 
		CheckinIdent = checkForNull(rs.getString("ident_at_checkin")); 
		pres_class = checkForNull(rs.getString("primary_resource_class"));
		OP_APPL_YN = checkForNull(rs.getString( "OP_APPL_YN" ));
		IP_APPL_YN = checkForNull(rs.getString( "IP_APPL_YN" ));
		DC_APPL_YN = checkForNull(rs.getString( "DC_APPL_YN" ));
		EM_APPL_YN = checkForNull(rs.getString( "EM_APPL_YN" ));	
		open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"N":rs.getString("open_to_all_pract_yn");
		q_clinic_desc=rs.getString("long_desc");
		speciality_code =  rs.getString("SPECIALITY_CODE")==null?"":rs.getString("SPECIALITY_CODE");
	    }
      }
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	if(!invitation_no.equals("")){  //If condition added by S.Sathish for PMG20089-CRF-0850 on Friday, July 02, 2010

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(q_clinic_desc));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(invitation_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(referal_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block71Bytes, _wl_block71);
if(isImproveReferralProcessAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(invitation_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(referal_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block71Bytes, _wl_block71);
if(isImproveReferralProcessAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(q_clinic_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
if(iSPractVisitLoad){
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
}else{
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(q_clinic_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
if(iSPractVisitLoad){
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(q_clinic_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
}}
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

	// query tuning.. modified by venkat S
 String  room_desc = "" ;
 String  selected = "" ;
 boolean flagvalue=false;  // added by mujafar for NMC-JD-CRF-0025
 String dis_room_value = "style='visibility:hidden;'";
   if (!q_clinic_code.equals(""))
    { 
		
		
	   if(q_practitioner_id1.equals(""))
		   q_practitioner_id1=q_practitioner_id;
	   
	   String sqlQuery =  "select a.practitioner_id ROOM_NO,b.room_type room_type,b.short_desc room_desc, CASE WHEN a.practitioner_id = '"+q_practitioner_id1+"' THEN 'selected=\"selected\"'  END AS selected from op_pract_for_clinic a, am_facility_room b where a.facility_id='"+facilityid+"' and a.clinic_code='"+q_clinic_code+"' and a.eff_status='E' and a.resource_class='R' and a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID";
		
	   pstmt   = con.prepareStatement(sqlQuery);
	

	   
     rs = pstmt.executeQuery();
     while( rs.next())
      {
		  flagvalue=true;
        rm_no   = checkForNull(rs.getString( "ROOM_NO" ));
		room_type = checkForNull(rs.getString( "room_type" ));		
		room_desc = checkForNull(rs.getString( "room_desc" ));	
		selected = checkForNull(rs.getString( "selected" ));	
		
		
       
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rm_no));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(rm_no));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(room_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
}}
	
	if(isRoomMandatoryRegVisit && flagvalue) // added by mujafar for NMC-JD-CRF-0025
		dis_room_value = "style='visibility:visible;'";
	   
	   
	   
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(dis_room_value));
            _bw.write(_wl_block94Bytes, _wl_block94);


  if(!room_desc.equals("") && !selected.equals("")){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(room_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
  
    servsql.setLength(0);
	
	if (!q_clinic_code.equals("")) {
    servsql.append("select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and eff_status = 'E' and service_code in (select service_code from op_clinic where clinic_code ='"+q_clinic_code+"' and facility_id='"+facilityid+"' union SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code ='"+q_clinic_code+"' AND b.facility_id='"+facilityid+"'"); 
	if(functionId.equals("VISIT_REGISTRATION"))
     {
      servsql.append( " and b.care_locn_type_ind = 'C')");
     }
    else if(functionId.equals("PROCD_REGISTRATION"))
          {
               servsql.append( " and b.care_locn_type_ind = 'E')");
          }
	pstmt   = con.prepareStatement(servsql.toString());
    rs = pstmt.executeQuery();
	
	
    while( rs.next())
    {
	  serviceCount++;		
	  service_code = checkForNull(rs.getString( "service_code" ));
	  short_desc   = checkForNull(rs.getString( "short_desc" ));
      if(to_ser_code.equals(service_code)){
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);
}else{
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);

	  }	
    }
	// The below code is newly added for CRF PMG20089-CRF-0855 [IN:024101] by Suresh M on 30.11.2010.
	  if(serviceCount == 1){
            _bw.write(_wl_block104Bytes, _wl_block104);

	  }else{
            _bw.write(_wl_block105Bytes, _wl_block105);

	  }
	}
	
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(isMohbr));
            _bw.write(_wl_block110Bytes, _wl_block110);

if(visit_type_derv_rule.equals("S")){
	if(isMohbr){//The if condition added for the CRF - PMG2013-BRU-CRF-0002 [IN045555]
		if (q_visit_adm_type.equals(""))
	  {
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

	  }else{
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(q_visit_adm_type_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(q_visit_adm_type));
            _bw.write(_wl_block116Bytes, _wl_block116);

		}
	}else{
   //if (q_visit_adm_type.equals(""))//Commented for the MMS-SCF-0010 
  //{
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
if(!q_visit_adm_type.equals("")){
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(q_visit_adm_type));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(q_visit_adm_type_desc));
            _bw.write(_wl_block120Bytes, _wl_block120);
}else{
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
}
            _bw.write(_wl_block123Bytes, _wl_block123);
//}//else{//Commented for the MMS-SCF-0010 - start
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(q_visit_adm_type_desc));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(q_visit_adm_type));
            _bw.write(_wl_block126Bytes, _wl_block126);
//}
	 } 
}else if(visit_type_derv_rule.equals("P") && isPractoApptYn.equals("Y") && !q_visit_adm_type.equals("")){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(q_visit_adm_type_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(q_visit_adm_type));
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
 }
            _bw.write(_wl_block131Bytes, _wl_block131);
 if(!locn_ind.equals("E"))
	   dis_value="disabled";
	   else
		   dis_value="";
	   
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(dis_value));
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);

	
if (!q_clinic_code.equals("")){
  // {

      pstmt   = con.prepareStatement( "Select Patient_Class, Short_Desc from AM_PATIENT_CLASS_lang_vw WHERE language_id='"+locale+"' and PATIENT_CLASS in(		decode(?,'Y','OP'),decode(?,'Y','IP'),decode(?,'Y','EM'),decode(?,'Y','DC'))");
	  
				
				pstmt.setString(1,OP_APPL_YN);
				pstmt.setString(2,IP_APPL_YN);
				pstmt.setString(3,EM_APPL_YN);
				pstmt.setString(4,DC_APPL_YN);
				rs = pstmt.executeQuery();
				while( rs.next())
				{
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(checkForNull(rs.getString("Patient_Class"))));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(checkForNull(rs.getString("Short_Desc"))));
            _bw.write(_wl_block138Bytes, _wl_block138);
}
   }
  
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);


if(visit_type_derv_rule.equals("S") || visit_type_derv_rule.equals("B")){
   if(q_practitioner_id.equals("") && q_appt_ref_no.equals("")) {	
            _bw.write(_wl_block141Bytes, _wl_block141);

	} else { 
	if(override_pract_for_appt_yn.equals("Y")){
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(q_practitioner_name));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(gif_style));
            _bw.write(_wl_block146Bytes, _wl_block146);
if((!q_appt_ref_no.equals("")) && (!resource_class.equals("P")) && multi_speciality_yn.equals("N")) {
            _bw.write(_wl_block147Bytes, _wl_block147);
}else{
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(q_practitioner_id));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(q_practitioner_id));
            _bw.write(_wl_block150Bytes, _wl_block150);
}
            _bw.write(_wl_block151Bytes, _wl_block151);

	 }else{ if(q_practitioner_name.equals("") ) {
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(q_practitioner_name));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(gif_style));
            _bw.write(_wl_block155Bytes, _wl_block155);
} else{ 	
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(q_practitioner_name));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(gif_style));
            _bw.write(_wl_block158Bytes, _wl_block158);
}
		if((!q_appt_ref_no.equals("")) && (!resource_class.equals("P")) && multi_speciality_yn.equals("N")){
            _bw.write(_wl_block147Bytes, _wl_block147);
}else{
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(q_practitioner_id));
            _bw.write(_wl_block150Bytes, _wl_block150);
}
		
            _bw.write(_wl_block159Bytes, _wl_block159);

		}	
	  }      
}else{// below IF condition is modified by Srinivas.Y for IN:35753
		if(q_practitioner_id.equals("") && q_appt_ref_no.equals("") && referal_id.equals("")) {	
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block161Bytes, _wl_block161);

} else { 
	if(override_pract_for_appt_yn.equals("Y")){
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(q_practitioner_name));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(gif_style));
            _bw.write(_wl_block146Bytes, _wl_block146);
if((!q_appt_ref_no.equals("")) && (!resource_class.equals("P")) && multi_speciality_yn.equals("N")) {
            _bw.write(_wl_block147Bytes, _wl_block147);
}else{
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(q_practitioner_id));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(q_practitioner_id));
            _bw.write(_wl_block150Bytes, _wl_block150);
}
            _bw.write(_wl_block151Bytes, _wl_block151);

	 }else{ if(q_practitioner_name.equals("") ) {
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(q_practitioner_name));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(disable_pract ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(gif_style));
            _bw.write(_wl_block155Bytes, _wl_block155);
} else{ 	
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(q_practitioner_name));
            _bw.write(_wl_block166Bytes, _wl_block166);
}
		if((!q_appt_ref_no.equals("")) && (!resource_class.equals("P"))){
            _bw.write(_wl_block147Bytes, _wl_block147);
}else{
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(q_practitioner_id));
            _bw.write(_wl_block150Bytes, _wl_block150);
}
		
            _bw.write(_wl_block159Bytes, _wl_block159);

		}	
     }
  }

            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
 if(resource_class.equals("E")){
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
}else if(resource_class.equals("O")){ 
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
}else{
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
}
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(res_name));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(res_id));
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);
	
	if(!order_catalog_code.equals("")) { 
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(order_catalog_desc));
            _bw.write(_wl_block182Bytes, _wl_block182);
}else{ if(!q_appt_ref_no.equals("")){
            _bw.write(_wl_block183Bytes, _wl_block183);
} else {
            _bw.write(_wl_block184Bytes, _wl_block184);
} }


            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block186Bytes, _wl_block186);

/*Below line added for this CRF GDOH-CRF-0129*/
if(isReferral){
     if(isCurrentEncounter){
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(assigncare_location_desc));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(referralforcurrentencounter));
            _bw.write(_wl_block189Bytes, _wl_block189);
}else{
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block194Bytes, _wl_block194);
}
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(reason_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);


	
// naren - contact reason to be passed and accessing oa_appt to be removed.

/*if (!q_appt_ref_no.equals("Null") || q_appt_ref_no !="")
{ 
pstmt   = con.prepareStatement("select am_get_desc.am_contact_reason(CONTACT_REASON_CODE,'"+locale+"',1)  reason,CONTACT_REASON_CODE from oa_appt where appt_ref_no='"+q_appt_ref_no+"' and facility_id='"+facilityid+"'");
rs= pstmt.executeQuery();
  if (rs!=null)
 {
  while (rs.next())
      {
       reason = rs.getString("reason");
      reason_code=rs.getString("CONTACT_REASON_CODE");
	  }
 }                           
}*/
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(reason_code));
            _bw.write(_wl_block201Bytes, _wl_block201);
}
 //End this GDOH-CRF-0129

            _bw.write(_wl_block202Bytes, _wl_block202);
if(!others_id.equals("")){
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
}
            _bw.write(_wl_block205Bytes, _wl_block205);

		
    if((episode.equals("Y") && record.equals("Y")) || (episode.equals("N") && record.equals("Y")))
    {
    
            _bw.write(_wl_block206Bytes, _wl_block206);
 
		if((!q_appt_ref_no.equals("")))
			{
		
            _bw.write(_wl_block207Bytes, _wl_block207);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient
                        )},{ weblogic.utils.StringUtils.valueOf("episode"), weblogic.utils.StringUtils.valueOf(episode
                        )},{ weblogic.utils.StringUtils.valueOf("record"), weblogic.utils.StringUtils.valueOf(record
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("OP")},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("O")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(functionId
                        )},{ weblogic.utils.StringUtils.valueOf("apptrefno"), weblogic.utils.StringUtils.valueOf(q_appt_ref_no
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block206Bytes, _wl_block206);
			
			}
			else {
		
            _bw.write(_wl_block209Bytes, _wl_block209);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient
                        )},{ weblogic.utils.StringUtils.valueOf("episode"), weblogic.utils.StringUtils.valueOf(episode
                        )},{ weblogic.utils.StringUtils.valueOf("record"), weblogic.utils.StringUtils.valueOf(record
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("OP")},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("O")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(functionId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block212Bytes, _wl_block212);

			}
    }
    else {
    
    
            _bw.write(_wl_block213Bytes, _wl_block213);
}
    
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(reccnt));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(visit_charge_stage));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(order_catalog_desc));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(res_pract_id));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(entitlement_by_cat_yn));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(isOrderCtlgAmtCalc));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(isPractoApptYn));
            _bw.write(_wl_block227Bytes, _wl_block227);

     //Added for biling  
  // for scrum code added 
	
      if (bl_interface_yn.equals("Y") && bl_install_yn.equals("Y") )
      {
		    /*
		    if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();

			String auth_win_reqd_yn = "N";
			
			pstmt = con.prepareStatement("select BLCOMMON.IS_AUTH_WINDOW_REQUIRED('"+facilityid+"', '"+patient+"','O') from dual");

			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()) {
				auth_win_reqd_yn = rs.getString(1);
			}

			*/

			if((auth_win_reqd_yn.equals("Y")|| !gen_remark.equals("") ) && !blflag_op_yn.equals("Y") ) { //Added for this CRF incident [52415]
           
			
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(+outst_amt));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block230Bytes, _wl_block230);
  

			}
			else
		  {
				/*
				  Below code added for Scrum 10638
				*/
				
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block232Bytes, _wl_block232);

		  }				
		
			if(regfromquery.equals("Y"))
			{
			PreparedStatement pstmtBillingRem= null;
			ResultSet rsetBillingRem = null;
			String episode_type = "O";
			String bl_show_remarks_yn = "N";
			long episode_id = 0;
			long visit_id = 0;
			String calling_module_id = "OP";
			String calling_function_id = functionId;

			pstmtBillingRem = con.prepareStatement("Select blcommon.BL_SHOW_BLNG_REMARKS_YN(?,?,?,?,?,?,?) from dual");
			pstmtBillingRem.setString(1,facilityid);
			pstmtBillingRem.setString(2,calling_module_id);
			pstmtBillingRem.setString(3,calling_function_id);
			pstmtBillingRem.setString(4,patient);
			pstmtBillingRem.setString(5,episode_type);
			pstmtBillingRem.setLong(6,episode_id);
			pstmtBillingRem.setLong(7,visit_id);
			rsetBillingRem = pstmtBillingRem.executeQuery();
			while(rsetBillingRem.next())
			{
				bl_show_remarks_yn = checkForNull(rsetBillingRem.getString(1));
			}
			
			rsetBillingRem.close();
			pstmtBillingRem.close();
			out.println("<input type='hidden' name='module_id' id='module_id' value='"+calling_module_id+"'>");
			out.println("<input type='hidden' name='calling_function_id' id='calling_function_id' value='"+calling_function_id+"'>");
			out.println("<input type='hidden' name='episode_type' id='episode_type' value='"+episode_type+"'>");
			out.println("<input type='hidden' name='bl_show_remarks_yn' id='bl_show_remarks_yn' value='"+bl_show_remarks_yn+"'>");
			out.println("<input type='hidden' name='episode_id' id='episode_id' value='"+episode_id+"'>");
			out.println("<input type='hidden' name='visit_id' id='visit_id' value='"+visit_id+"'>");
			out.println("<input type='hidden' name='patId' id='patId' value='"+patient+"'>");
			if (bl_show_remarks_yn.equalsIgnoreCase("Y"))
			{
				out.println("<script>showBillingRemarks();</script>");
			}
			}
		

			//<<billing_remarks#02>>End

		if(rs != null) rs.close();		
		if(pstmt!=null)pstmt.close();

	if(!referal_id.equals(""))
	{

		pstmt=con.prepareStatement("select b.org_type from PR_REFERRAL_REGISTER a, AM_REFERRAL b where a.referral_id = '"+referal_id+"' and a.from_ref_code = b.referral_code ");
		rs = pstmt.executeQuery();

			if(rs.next()) 
			{
				org_type_data = checkForNull(rs.getString("org_type"));
				if(org_type_data == null) org_type_data = "";

				if(org_type_data.equals("P"))  		
					org_type_data="P";
				else
					org_type_data="G";
			}
			else
			{
				org_type_data="G";
			}
			if(rs != null)rs.close(); if(pstmt != null) pstmt.close();									
	}
      }
      // End of Billing
				
    display_button3 = "<input type='button' name='prev_visit' id='prev_visit'  Value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")+"'  class='Button' onClick=show_last_visit_details('"+patient+"') >";
	display_button1 = "<input type='button' class='button' name='contact_details' id='contact_details' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactDetails.label","common_labels")+"'  onclick='Modal_Contact_Details(this);'id = '' >";



            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(display_button1));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(display_button3));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(pr_ent_cnt));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(pat_ser_grp_code));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(inv_splty_code));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(override_pract_for_appt_yn));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(assign_q_num_by));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(patientFlag));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(Pat_Details));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(seclevel));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(protectionind));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(outst_amt));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(CheckinIdent));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(gen_file_yn));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(ChgToVisitorGrp));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(HcExpired));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(override_vtype_on_epsd_yn));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(episode_close_days_fu));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(episode_close_days_wo_fu));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(l_encounter_id));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(referal_id));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(reg_vis_param));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(curepisodeid));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(register_pat_yn));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(wait_flag));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(referal_id));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(org_type_data));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(room_type));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(rm_no));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(q_visit_adm_type_ind));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(q_visit_adm_type));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(concat_address_hidden.toString()));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(bed_num));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(dischargedatetime));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(menu_function_id));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(from_reg));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(invitation_no));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(iSPractVisitLoad));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(isAllowRegForSameService));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(q_appt_time));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(rec_no));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(auth_win_reqd_yn));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(episode));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(record));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(from_head));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(locn_ind));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(waitlist_status));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(accept_dis_inv_no));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(visit_type_derv_rule));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(visit_back_yn));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(multi_speciality_yn));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(appt_order));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(order_count_select));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(upt_contact_dtls_oa_yn));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(downtimePatient));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(isForm60Available));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(reg_date_time));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(validationForPanCardAvail));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(defFinDtls));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(isRoomMandatoryRegVisit));
            _bw.write(_wl_block319Bytes, _wl_block319);

	 }//below IF condition is modified by Srinivas.Y for IN:35753
	  if(!q_appt_ref_no.equals("") || !referal_id.equals("")) { 
		 
		
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(q_visit_adm_type));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block322Bytes, _wl_block322);

	 }
	}
}
catch(Exception e)
{
	e.printStackTrace();
	if(con!=null) {
		ConnectionManager.returnConnection(con,request);
	}
} finally {
	if(con!=null) {
		ConnectionManager.returnConnection(con,request);
	}
}

			
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block323Bytes, _wl_block323);
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(order_count_select));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(action_on_pract_schedule));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(assigncareloctype));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(assigncare_location_code));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(isReferral));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(others_id));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(isImproveReferralProcessAppl));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(isQMSInOPVisitRegAppl));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(vst_regn_date));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(isClinicCategory));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(firstVisitList));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(followUpVisitList));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(isReferalId));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(referral_req_yn));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(virtualConsultEnable));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(isVirtualConsultationVisit));
            _bw.write(_wl_block342Bytes, _wl_block342);
 // The below condition serviceCount is newly added for CRF PMG20089-CRF-0855 [IN:024101] by Suresh M on 30.11.2010.
	if((!q_appt_ref_no.equals("") || !to_ser_code.equals("") || serviceCount == 1) && !visit_type_derv_rule.equals("P") ) {
		//out.println("<script>setTimeout('popSubservice(document.forms[0].service_code)',1500);</script>");
		out.println("<script>if(document.forms[0])popSubservice(document.forms[0].service_code);</script>");
	}	

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.Visits.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AppointmentDetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDateTime.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.VisitDtlsTemplate.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.QueuePKID.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.OtherResource.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Referralfrom.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Referralfrom.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
