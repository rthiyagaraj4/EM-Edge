package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recmaternitydeliveryrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecMaternityDeliveryRecord.jsp", 1709116211231L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"JavaScript\" src =\"../../eCA/js/RecMaternityDeliveryRecord.js\"></script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\t\t\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\t\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n\t\t\n\t\t<form name=\"recMatDeliveryRecordForm\" id=\"recMatDeliveryRecordForm\"  method =\'post\' target=\'messageFrame\' action=\'../../servlet/eCA.RecMaternityConsServlet\'>\n\t\t<table border=\'0\' cellspacing=\'0\' cellpadding=\'3\' width=\'100%\' align=\"grid\">\n\t\t<tr>\n\t\t\t<td class =\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t<select name =\"delivery_type\" onChange=\'enDisCompls(this.value,\"Y\")\' ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n\t\t\t<option  value=\"\">------ ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" ------</option>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\t\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="selected";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t</option>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class =\'label\' width=\'25%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;&nbsp;&nbsp;\n\t\t\t</td>\n\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<input type=\"text\" name=\"lmp_date\" id=\"lmp_date\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" size=\"16\" maxlength=\"16\" onblur=\'return checkingDate(this,\"DMY\",\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\")\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="><img id=\"common_calander\" src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendar(\'lmp_date\');\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="><img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class =\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\t\t\t\n\t\t\t<td  class=\'fields\'>\n\t\t\t\t<input type=\'text\' size=\"25\"  name=\"attend_practid_desc\" id=\"attend_practid_desc\"  onBlur=\'getattndpract();\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"><input type=\'button\'  name=\'pract_id_search1\' id=\'pract_id_search1\' value=\'?\' class=\'button\'  onClick=\'callPractSearch(document.recMatDeliveryRecordForm.pract_id_search1,document.recMatDeliveryRecordForm.attend_practid_desc);\' >\n\t\t\t\t<input type=\'hidden\' name=\"attend_pract_id\" id=\"attend_pract_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class =\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t\t<input type=\"text\" name=\"att_nurse_newborn\" id=\"att_nurse_newborn\" size=\"25\" onblur=\"attendingNurse(this);\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><input type=\'button\'  name=\'att_nurse_search\' id=\'att_nurse_search\' onClick=\"attendingNurse(document.recMatDeliveryRecordForm.att_nurse_newborn);\" value=\'?\' class=\'button\'>\n\t\t\t\t<input type=hidden name=\"attend_nurse_id\" id=\"attend_nurse_id\" value =\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t\t<input type=\"text\" name=\"proc_class_desc\" id=\"proc_class_desc\" onblur=\'chkprocclass();\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"><input type=\'button\'  name=\'proc_id\' id=\'proc_id\' value=\'?\' class=\'button\' onClick=\'procClass(proc_id,proc_class_desc);\'>\n\t\t\t\t<input type=\"hidden\" name=\"proc_classification\" id=\"proc_classification\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t\t<input type=\"text\" name=\"del_serv_desc\" id=\"del_serv_desc\" onblur=\'chkdelsurgclass();\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"><input type=\'button\'  name=\'del_serv_id\' id=\'del_serv_id\' value=\'?\' class=\'button\' onClick=\'delSurgClass(del_serv_id,del_serv_desc);\' onKeyPress=\'delSurgClass(del_serv_id,del_serv_desc);\' >\n\t\t\t\t<input type=\"hidden\" name=\"del_surg_classification\" id=\"del_surg_classification\" value =\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t\t<input type=\"text\" name=\"vaginal_del_type_desc\" id=\"vaginal_del_type_desc\" onblur=\'chkvagclass();\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="><input type=\'button\' name=\'vaginal_del_type_search\' id=\'vaginal_del_type_search\' value=\'?\' class=\'button\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" onClick=\'vagClass(vaginal_del_type_search, vaginal_del_type_desc);\' onkeypress=\'vagClass(vaginal_del_type_search, vaginal_del_type_desc);\' >\n\t\t\t\t<input type=\'hidden\' name=\"vaginal_delivery_type\" id=\"vaginal_delivery_type\" value =\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t<input type=\'text\'  name=\'no_of_birth\' id=\'no_of_birth\' size=\'1\' maxlength=\'1\' onKeyPress=\"return allowValidNumberLocal(this, event,1,0) \" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' ><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\" id=\'final_mand\' style=\'display:none\' >\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class =\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t<select name =\"comp_in_del_stage1\"  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</select>\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class =\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t<select name =\"comp_in_del_stage2\"  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t</select>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class =\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t<select name =\"comp_in_del_stage3\"  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"  ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t\t<input type=\"text\" name=\"comple_ofdel_newborn\" id=\"comple_ofdel_newborn\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="  onblur=\"compDelievary1(this,\'comple_of_button\');\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"><input type=\'button\'  name=\'comple_of_button\' id=\'comple_of_button\' ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" onClick=\"compDelievary(document.recMatDeliveryRecordForm.comple_ofdel_newborn,\'comple_of_button\');\" value=\'?\'  class=\'button\'  onClick=\'\' >\n\t\t\t\t<input type=hidden name=\"comp_of_delivery\" id=\"comp_of_delivery\" value =\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class =\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t\t<input type=\"text\" name=\"foetus_comple_ofdel_newborn\" id=\"foetus_comple_ofdel_newborn\" value =\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"  onblur=\"compDelievary1(this,\'foetus_comple_of_button\');\"><input type=\'button\'  name=\'foetus_comple_of_button\' id=\'foetus_comple_of_button\' onClick=\"compDelievary(document.recMatDeliveryRecordForm.foetus_comple_ofdel_newborn,\'foetus_comple_of_button\');\" value=\'?\'  class=\'button\'  onClick=\'\' >\n\t\t\t\t<input type=hidden name=\"foetus_comp_of_delivery\" id=\"foetus_comp_of_delivery\" value =\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t\t<input type=\"checkbox\" name=\"finalize_yn\" id=\"finalize_yn\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" onClick=\"setFinalizeValue(this)\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="checked";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =">\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\t\t\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\'hidden\' name=\'mother_patient_id\' id=\'mother_patient_id\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t<input type=\'hidden\' name=\'cycle_no\' id=\'cycle_no\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type=\'hidden\' name=\'delivery_record\' id=\'delivery_record\' value=\"DeliverRecord\">\n\t\t<input type=\'hidden\' name=\'modeValue\' id=\'modeValue\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t<input type=\'hidden\' name=\'min_gestation\' id=\'min_gestation\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type=\'hidden\' name=\'max_gestation\' id=\'max_gestation\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\'hidden\' name=\'unit_of_gest_nb\' id=\'unit_of_gest_nb\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t<input type=\'hidden\' name=\'currentDate\' id=\'currentDate\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t<input type=\'hidden\' name=\'splty_event_code\' id=\'splty_event_code\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t<input type=\'hidden\' name=\'splty_task_code\' id=\'splty_task_code\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t</form>\n\t\t</body>\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t</html>\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

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

  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facility_id       = (String) session.getValue("facility_id");
  Connection con = null; 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			try{
				//String ca_delivery_type="";
				Properties p		= (java.util.Properties) session.getValue("jdbc");
				String  locale = (String) p.getProperty("LOCALE");
				PreparedStatement pstmt		= null;
				ResultSet rs	 =null;
				
				con = ConnectionManager.getConnection();
				ArrayList array_list = new ArrayList();
				
				String mother_patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
				String encounter_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
				String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
				String cycle_no = request.getParameter("cycle_no") == null ? "" : request.getParameter("cycle_no");
				String modeValue = request.getParameter("modevalue") == null ? "" : request.getParameter("modevalue");
				
				String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
				String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
				String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
				

				

				String delivery_type = "";
				String attend_pract_id = "";
				String attend_nurse_id = "";
				String proc_classification = "";
				String del_surg_classification = "";
				String vaginal_delivery_type = "";
				String no_of_birth = "";
				String comp_in_del_stage1 = "";
				String comp_in_del_stage2 = "";
				String comp_in_del_stage3 = "";
				String comp_of_delivery = "";
				String foetus_comp_of_delivery = "";
				String finalize_yn = "N";			
				String attend_pract_name = "";
				String attend_nurse_name = "";
				String proc_classification_desc = "";
				String del_surg_classification_desc = "";
				String vaginal_delivery_type_desc = "";							
				String comp_of_delivery_desc = "";
				String foetus_comp_of_delivery_desc = "";			
				String delivery_indicator = "";			
				String disable_delivery_type = "";
				String disable_fields1 = "";
				String disable_fields2 = "";
				String delivery_type1 = "";
				String lmp = "";
				String disableLmp = "";
				String min_gestation = "";
				String max_gestation = "";
				String unit_of_gest_nb = "";
				
				String currentDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
				
				try {

				String lmp_Qry = "SELECT DISCR_MSR_VALUE FROM CA_PAT_SPLTY_KEY_MSR WHERE PATIENT_ID = ? AND MODULE_ID = ? AND CYCLE_NO= ? AND EVENT_CODE=? AND DISCR_MSR_ID=? "; 
				//AND ACCESSION_NUM = ?"

				pstmt		=	con.prepareStatement(lmp_Qry);	
				pstmt.setString(1,mother_patient_id);
				pstmt.setString(2,module_id);
				pstmt.setString(3,cycle_no);
				pstmt.setString(4,"MCE004");
				pstmt.setString(5,"MC01LMP");
				rs	 =	pstmt.executeQuery();		

				if(rs.next()){
					lmp =  rs.getString("DISCR_MSR_VALUE") == null?"":rs.getString("DISCR_MSR_VALUE");
					disableLmp = "disabled";
				}

				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();

				String ges_Qry = "SELECT nvl(min_gestation,0) min_gestation, nvl(max_gestation,0) max_gestation,unit_of_gest_nb FROM mp_param_lang_vw WHERE language_id=? and module_id ='MP'"; 				
				

				pstmt		=	con.prepareStatement(ges_Qry);	
				pstmt.setString(1,locale);
				
				rs	 =	pstmt.executeQuery();		

				if(rs.next()){
					min_gestation = rs.getString("min_gestation")==null?"0":rs.getString("min_gestation");
					max_gestation = rs.getString("max_gestation")==null?"0":rs.getString("max_gestation");
					unit_of_gest_nb = rs.getString("unit_of_gest_nb")==null?"0":rs.getString("unit_of_gest_nb");
				}

				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();

			//	String query_section_details="SELECT FACILITY_ID, ENCOUNTER_ID, MOTHER_PATIENT_ID, DELIVERY_TYPE || '$' || (SELECT DELIVERY_INDICATOR FROM MP_NOD_TYPE WHERE NOD_TYPE = DELIVERY_TYPE) DELIVERY_TYPE, ATTEND_PRACT_ID, ATTEND_NURSE_ID, PROC_CLASSIFICATION, DEL_SURG_CLASSIFICATION, VAGINAL_DELIVERY_TYPE, NO_OF_BIRTH, COMP_IN_DEL_STAGE1, COMP_IN_DEL_STAGE2, COMP_IN_DEL_STAGE3, COMP_OF_DELIVERY, FOETUS_COMP_OF_DELIVERY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, CYCLE_NO, FINALIZE_YN,am_get_desc.AM_PRACTITIONER(ATTEND_PRACT_ID,?,1) ATTEND_PRACT_NAME,am_get_desc.AM_PRACTITIONER(ATTEND_NURSE_ID,?,1) ATTEND_NURSE_NAME,mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,?,2)  PROC_CLASSIFICATION_DESC, mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,?,2) DEL_SURG_CLASSIFICATION_DESC, mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,?,2) VAGINAL_DELIVERY_TYPE_DESC,mp_get_desc.MP_COMPLN_DELIVERY(COMP_OF_DELIVERY,?,2) COMP_OF_DELIVERY_DESC, mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,?,2) FOETUS_COMP_OF_DELIVERY_DESC,(SELECT DELIVERY_INDICATOR FROM MP_NOD_TYPE WHERE NOD_TYPE = DELIVERY_TYPE) DELIVERY_INDICATOR,to_char(LMP,'dd/mm/yyyy') LMP FROM CA_SPL_DELIVERY_RECORD A WHERE A.FACILITY_ID = ?  AND A.MOTHER_PATIENT_ID = ? AND CYCLE_NO = ?";	
				String query_section_details="SELECT FACILITY_ID, ENCOUNTER_ID, MOTHER_PATIENT_ID, DELIVERY_TYPE || '$' || (SELECT DELIVERY_INDICATOR FROM MP_NOD_TYPE WHERE NOD_TYPE = DELIVERY_TYPE) DELIVERY_TYPE, ATTEND_PRACT_ID, ATTEND_NURSE_ID, PROC_CLASSIFICATION, DEL_SURG_CLASSIFICATION, VAGINAL_DELIVERY_TYPE, NO_OF_BIRTH, COMP_IN_DEL_STAGE1, COMP_IN_DEL_STAGE2, COMP_IN_DEL_STAGE3, COMP_OF_DELIVERY, FOETUS_COMP_OF_DELIVERY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, CYCLE_NO, FINALIZE_YN,am_get_desc.AM_PRACTITIONER(ATTEND_PRACT_ID,?,1) ATTEND_PRACT_NAME,am_get_desc.AM_PRACTITIONER(ATTEND_NURSE_ID,?,1) ATTEND_NURSE_NAME,mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,?,2)  PROC_CLASSIFICATION_DESC, mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,?,2) DEL_SURG_CLASSIFICATION_DESC, mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,?,2) VAGINAL_DELIVERY_TYPE_DESC,mp_get_desc.MP_COMPLN_DELIVERY(COMP_OF_DELIVERY,?,2) COMP_OF_DELIVERY_DESC, mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,?,2) FOETUS_COMP_OF_DELIVERY_DESC,(SELECT DELIVERY_INDICATOR FROM MP_NOD_TYPE WHERE NOD_TYPE = DELIVERY_TYPE) DELIVERY_INDICATOR,to_char(LMP,'dd/mm/yyyy') LMP FROM CA_SPL_DELIVERY_RECORD A WHERE A.MOTHER_PATIENT_ID = ? AND CYCLE_NO = ?";	
				
				pstmt		=	con.prepareStatement(query_section_details);										
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,locale);
				pstmt.setString(6,locale);
				pstmt.setString(7,locale);
			//	pstmt.setString(8,facility_id);
				//pstmt.setString(9,encounter_id);
				pstmt.setString(8,mother_patient_id);
				pstmt.setString(9,cycle_no);
				
				rs	 =	pstmt.executeQuery();		

				if(rs.next())
				{
					delivery_type = rs.getString("DELIVERY_TYPE") == null?"":rs.getString("DELIVERY_TYPE");
					attend_pract_id = rs.getString("ATTEND_PRACT_ID") == null?"":rs.getString("ATTEND_PRACT_ID");
					attend_nurse_id = rs.getString("ATTEND_NURSE_ID") == null?"":rs.getString("ATTEND_NURSE_ID");
					proc_classification = rs.getString("proc_classification") == null?"":rs.getString("proc_classification");
					del_surg_classification = rs.getString("del_surg_classification") == null?"":rs.getString("del_surg_classification");
					vaginal_delivery_type = rs.getString("vaginal_delivery_type") == null?"":rs.getString("vaginal_delivery_type");
					no_of_birth = rs.getString("no_of_birth") == null?"":rs.getString("no_of_birth");
					comp_in_del_stage1 = rs.getString("comp_in_del_stage1") == null?"":rs.getString("comp_in_del_stage1");
					comp_in_del_stage2 = rs.getString("comp_in_del_stage2") == null?"":rs.getString("comp_in_del_stage2");
					comp_in_del_stage3 = rs.getString("comp_in_del_stage3") == null?"":rs.getString("comp_in_del_stage3");
					comp_of_delivery = rs.getString("comp_of_delivery") == null?"":rs.getString("comp_of_delivery");
					foetus_comp_of_delivery = rs.getString("foetus_comp_of_delivery") == null?"":rs.getString("foetus_comp_of_delivery");
					finalize_yn = rs.getString("finalize_yn") == null?"N":rs.getString("finalize_yn");				
					attend_pract_name = rs.getString("attend_pract_name") == null?"":rs.getString("attend_pract_name");
					attend_nurse_name = rs.getString("attend_nurse_name") == null?"":rs.getString("attend_nurse_name");
					proc_classification_desc = rs.getString("proc_classification_desc") == null?"":rs.getString("proc_classification_desc");
					del_surg_classification_desc = rs.getString("del_surg_classification_desc") == null?"":rs.getString("del_surg_classification_desc");
					vaginal_delivery_type_desc = rs.getString("vaginal_delivery_type_desc") == null?"":rs.getString("vaginal_delivery_type_desc");							
					comp_of_delivery_desc = rs.getString("comp_of_delivery_desc") == null?"":rs.getString("comp_of_delivery_desc");
					foetus_comp_of_delivery_desc = rs.getString("foetus_comp_of_delivery_desc") == null?"":rs.getString("foetus_comp_of_delivery_desc");				
					delivery_indicator = rs.getString("delivery_indicator") == null?"":rs.getString("delivery_indicator");				
					lmp = rs.getString("LMP") == null?"":rs.getString("LMP");			
					
				
				}
				if(!lmp.equals(""))
					lmp = com.ehis.util.DateUtils.convertDate(lmp,"DMY","en",locale);

				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				}catch(Exception ee){
					ee.printStackTrace();
				}

				if(!delivery_type.equals(""))
						disable_delivery_type = "disabled";

				if(delivery_indicator.equals("N"))
				{
					disable_fields1 = "disabled";
					disable_fields2 = "";
				}else if(delivery_indicator.equals("C")){
					disable_fields2 = "disabled";
					disable_fields1 = "";				
				}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(disable_delivery_type));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

				array_list.clear();
				array_list = eMP.NewbornDetails.getNodeTypeShortDesc(con,p);				
				for(int i=0;i<array_list.size();i+=3) {		
					delivery_type1 = (String)array_list.get(i)+"$"+(String)array_list.get(i+2);
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(delivery_type1));
            _bw.write(_wl_block13Bytes, _wl_block13);
if(delivery_type.equals(delivery_type1)){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((String) array_list.get(i+1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
			} 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(lmp));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disableLmp));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disableLmp));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(attend_pract_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(attend_pract_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(attend_nurse_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(attend_nurse_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(proc_classification_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(proc_classification));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(del_surg_classification_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(del_surg_classification));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(vaginal_delivery_type_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disable_fields1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disable_fields1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(vaginal_delivery_type));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(no_of_birth));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disable_fields2));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"First");
						
						for(int i=0;i<array_list.size();i+=2) 
					{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)array_list.get(i)));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(comp_in_del_stage1.equals(((String)array_list.get(i)))){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String) array_list.get(i+1)));
            _bw.write(_wl_block41Bytes, _wl_block41);
			}
					
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disable_fields2));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Second");
						
						for(int i=0;i<array_list.size();i+=2) { 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)array_list.get(i)));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(comp_in_del_stage2.equals(((String)array_list.get(i)))){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String) array_list.get(i+1)));
            _bw.write(_wl_block44Bytes, _wl_block44);
					}
					
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disable_fields2));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Third");
						
						for(int i=0;i<array_list.size();i+=2) { 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)array_list.get(i)));
            _bw.write(_wl_block47Bytes, _wl_block47);
if(comp_in_del_stage3.equals(((String)array_list.get(i)))){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String) array_list.get(i+1)));
            _bw.write(_wl_block44Bytes, _wl_block44);
					}
					
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disable_fields1));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(comp_of_delivery_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(disable_fields1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(comp_of_delivery));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(foetus_comp_of_delivery_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(foetus_comp_of_delivery));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
if(finalize_yn.equals("Y")){
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(modeValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(min_gestation));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(max_gestation));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(unit_of_gest_nb));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(currentDate));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(splty_event_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block72Bytes, _wl_block72);
}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null) ConnectionManager.returnConnection(con);
			
		}
            _bw.write(_wl_block73Bytes, _wl_block73);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DeliveryType.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LMP.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AttendingNurse.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ProcedureClassification.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DeliverySurgicalClassification.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VaginalDeliveryType.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoofBirth.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ComplicationinStage1ofDelivery.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ComplicationinStage2ofDelivery.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ComplicationinStage3ofDelivery.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ComplicationofDelivery.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.FoetusComplicationofDelivery.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Finalize.label", java.lang.String .class,"key"));
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
}
