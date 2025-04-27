package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __encounterscontrols extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncountersControls.jsp", 1742381962008L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\t\tRev.Date\t\tRev.Name\t\t\tDescription\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           \t\t\t\t\t\t\t\t\t\tcreated\n20/06/2012\t  IN033489\t\tMenaka V\t\t\t\t\t\t\t\t\t\t\tReport header blank in \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclinical event history.\t\t\t\t\t\t\t\t\t\t\n07/01/2013\t  IN035950\t\tNijitha\t\t\t\t\t\t\t\t\t\t\t\tCHL Hospital suggested that the \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpresentation of the Clinician desktop be changed and more appealing. Keeping the display of information more clear and visible.\n18/07/2013\t\tIN034514\tKarthi L\t\t\t\t\t\t\t\t\t\t\tIn Clinical Event History, one could see\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tinformation about patient\'s visit as a summary which included Patient Admission date, date of discharge, attending practitioner, etc\n10/06/2015\t\tIN057797\tVijayakumar K\t\t\t\t\t\t\t\t\t\tGHL-SCF-976 [IN:057797]\n16/11/2015\t\tIN057113\tKarthi L\t\t\t\t\t\t\t \t\t\t\tML-MMOH-CRF-0335 - IN057113\n17/12/2015     \tIN058148    Prathyusha   Allow copy text from event history views\n--------------------------------------------------------------------------------------------------------------\nDate       \tEdit History      \tName        \tRev.Date\t\tRev.Name\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n07/10/2016\tIN047572\t\t\tKarthi L\t\t\t\t\t\t\t\t\t\t[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?\t\t\t\t\n23/10/2018\t\tIN068011\t\tRaja S\t\t\t23/10/2018\t\tRamesh G\t\tML-MMOH-CRF-1204\t\n02/01/2019  \t\tIN066453\t\tKamalakannan G  02/01/2019\t\tRamesh G\t\tML-BRU-CRF-0491\n03/02/2020\t\t\tIN071561\tSIVABAGYAM M\t\t03/02/2020\t\tRAMESH G\t\tGHL-CRF-0558.1\n03/02/2020\t\t39052\t\t\tRamesh\t\t\t\t\t\t\t\t\t\t\tML-BRU-CRF-0634\n--------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<STYLE>\n\ttd.errorEvents\n\t{\n\t\tbackground-color: BROWN;\n\t\tborder-style: dashed;\n\t}\n\tFONT.CRITICAL{\n\t\tbackground-color:#D2B48C;\n\t}\n\tFONT.ABNORMAL{\n\t\tbackground-color:#FFF8DC;\n\t}\n\tFONT.HIGH{\n\t\tbackground-color:#FFC0CB;\n\t}\n\tFONT.LOW{\n\t\tbackground-color:#F0FFFF;\n\t}\n\tFONT.CRITICALLOW{\n\t\tbackground-color:#D8BFD8;\n\t}\n\tFONT.CRITICALHIGH{\n\t\tbackground-color:#F4A460;\n\t}\n\n\tFONT.DELTAFAIL{\n\t\tbackground-color:#FFE4E1;\n\t}\n\n</STYLE>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/Encounters.js\'></script>\n<script src=\'../../eCA/js/DateCheck.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/ViewClinicalDocument.js\' language=\'javascript\'></script>\n\n</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<!--<script>\n\t\t\t\t\t\tdtArr[";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="] = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\t</script> -->\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<!-- <script>\n\t\t\t\t\t\tdtArr[";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<!--\t<script>\t\t\t\t\t\t\n\t\t\t\t\t\tdtArr[";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t</script> -->\n\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<!-- <script>dtArr[";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\n\t\t\t\t</script> -->\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<BODY  class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'encounterform\' id=\'encounterform\' >\n<input type = hidden  name = idx_value\t\tvalue = ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n<input type = hidden  name = cur_idx_value\tvalue = \"0\">\n<input type = hidden  name = called_from\tvalue =";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >\n<input type = hidden  name = from_date\tvalue =";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n<input type = hidden  name = to_date\t\tvalue =";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" >\n<input type = hidden  name = patient_id\t\tvalue =";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >\n<input type = hidden  name = history_type\t\tvalue =";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n<input type = hidden  name = event_class\tvalue =";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >\n<input type = hidden  name = event_group\tvalue =";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n<input type = hidden  name = event_item\t\tvalue =";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >\n<input type = hidden  name = facility_id\tvalue =";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n<input type = hidden  name = encounter_id value =";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n<input type = hidden  name = enc_id value =";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" >\n<input type = hidden  name = episode_type\tvalue =";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n<input type = hidden  name = normalcy\t\tvalue =";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" >\n<input type = hidden  name = abnormal\t\tvalue =";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" >\n<input type = hidden  name = strFlowSheetId value =";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" >\n<input type = hidden  name = viewConfRes\t\t\tvalue =";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >\n<input type = hidden  name = strGraphOrder\tvalue =";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" >\n<input type = hidden  name = strErrorEvent\tvalue =";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" >\n<input type = hidden  name = event_date\tvalue =";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" >\n<input type = hidden  name = \'EHR_YN\'\tvalue =";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" >\n<input type = hidden  name = \'page_no\'\tvalue = \"1\" >\n<input type=\"hidden\" value=\"\" name=\"data_type\" id=\"data_type\">\n<input type = hidden  name = fac_id value =";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ><!-- IN033489-->\n<input type = hidden  name = enctr_id value =";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ><!-- IN033489-->\n<input type = hidden  name = patient_class value =";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="><!-- IN034514 -->\n<input type = hidden  name = p_enc_details_tree value =";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="><!-- IN034514 -->\n<input type = hidden  name = encntr_yn value =";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="><!-- IN034514 -->\n<input type = hidden  name = p_menu_type value =";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="><!-- IN034514 -->\n<input type=\"hidden\" name=\"l_conf_pin_req_yn\" id=\"l_conf_pin_req_yn\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"> <!-- ML-MMOH-CRF-0335 - IN057113 -->\n<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"> <!--  MMS-QH-CRF-0177 [IN047572]  -->\n<input type=\"hidden\" name=\"attend_pract_code\" id=\"attend_pract_code\" value = \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"> <!-- MMS-QH-CRF-0177 [IN047572]  -->\n<input type=\"hidden\" name=\"p_review_rad_yn\" id=\"p_review_rad_yn\" value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"><!--IN071561-->\n<input type=\"hidden\" name=\"order_type_3T\" id=\"order_type_3T\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">  <!-- 39052 -->\n<table border=1 cellpadding=0 cellspacing=0 height=\'100%\' width=\"100%\" align=\'center\' id=\'tablePrevNext\' >\n<tr><td>\n\t\n\t\t<table border=0 cellpadding=0 cellspacing=0 width=\"100%\">\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<td  class=\'label\'>&nbsp;";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t<!-- IN058148 start -->\n\t\t\t\t<td width=\'5%\' id = \'copy_text_id\' style=\'display:none\'>\n\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'  name=\'copy_text\' class=\'BUTTON\' onClick=\'copyText()\' title=\'Copy Text\' alt=\'Copy Text\'/>&nbsp;</td>\n\t\t\t\t<!-- IN058148 end -->\n\t\t\t\t<td width=\'5%\'>\n\t\t\t\t<!--IN066453 disabled condition added for manage,comments & print button-->\n\t\t\t\t\t\t<INPUT TYPE=\"button\" name=\"manage\" id=\"manage\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="disabled";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' class=\'BUTTON\' onClick=\'manageText()\' title=\'Click to manage the events\'>&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td width=\'5%\'>\n\t\t\t\t\t\t<INPUT TYPE=\"button\" name=\"comments\" id=\"comments\" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' class=\'BUTTON\' onClick=\'showEnterQuickText();\' title=\'Click to enter comments\'>&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td  width=\'3%\'>\n\t\t\t\t\t\t<!-- IN057797 starts -->\n\t\t\t\t\t\t<!--<input type=\"button\"  name=\"print\" id=\"print\"  class=\"button\" value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' onClick=\"valsForPrint()\" title=\'Click to print the events\' >&nbsp;-->\n\t\t\t\t\t\t<input type=\"button\"  name=\"print\" id=\"print\"  ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" class=\"button\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' onClick=\"valsForPrint()\" title=\'Click to print the events\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" >&nbsp;\n\t\t\t\t\t\t<!-- IN057797 ends -->\n\t\t\t\t</td>\n\t\t\t\t<td width=\'5%\'>\n\t\t\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' class=\'BUTTON\' onClick=\'emailText()\' title=\'Click to email the events\' name=\'emailBtn\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =">&nbsp;\n\t\t\t\t</td>\t\n\n\t\t\t\t<!-- Modifeied By \t: Arvind Singh Pal,\tPurpose :  For GHL-CRF-0043 on 12 November 2009   -->\n\n\t\t\t\t<td width=\'5%\'>\n\t\t\t\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' class=\'BUTTON\' title=\'Click to view\' name=\'viewBtn\' onclick=\'loadViewPage()\'>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t<!-- End Here -->\n\n\t\t\t\t<!-- <td align=\'left\' width=\'5%\'><input type=\'button\' id=\'prev\' name=\'prev\' id=\'prev\' value=\'<\' ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" class=\'button\' onclick=\'loadPrevNext1(this)\' align=\'right\'></td>\n\t\t\t\t<td  align =\'center\' class = \'QRYEVEN\'>\n\t\t\t\t\t\t<input type =\'label\' class=\"LABEL\" name = \'label_cap\'> \n\t\t\t\t</td>\n\t\t\t\t<td align=\'left\' width=\'5%\'><input type=\'button\' id=\'next\' name=\'next\' id=\'next\' value=\'>\' ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" class=\'button\' onclick=\'loadPrevNext1(this)\' ></td> -->\n\n\t\t\t\t<td align=right style=\"width: 25%;\">\n\t\t\t\t<table border=0 cellpadding=0 cellspacing=0 width=\"80%\" id=\'tablePrevNext\' style=\'border-color:#CFCFCD;\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'2%\' nowrap><img src=\'../../eCommon/images/iGridSPreviousNOR16.gif\' id=\'first\' onclick=\'loadPrevNext1(this)\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" /><img src=\'../../eCommon/images/iGridPreviousNOR16.gif\' id=\'prev\' onclick=\'loadPrevNext1(this)\' ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" /></td>\n\t\t\t\t\t\t<td id=\'label_cap\' class=\'Pagination\'>&nbsp;</td>\n\t\t\t\t\t\t<td width=\'2%\' nowrap><img src=\'../../eCommon/images/iGridNextNOR16.gif\' id=\'next\' onclick=\'loadPrevNext1(this)\' ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" /><img src=\'../../eCommon/images/iGridSNextNOR16.gif\' id=\'last\' onclick=\'loadPrevNext1(this)\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" /></td>\n\n\t\t\t\t\t</tr>\n\t\t\t\t</table>&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\n\t</td></tr>\n</table>\n<script> \n<!-- IN058148 start -->\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\tdocument.getElementById(\"copy_text_id\").style.display = \'\'; \n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="<!-- IN058148 end -->\nfunction defaultPage()\n{\n\tvar idx_value\t= document.forms[0].idx_value.value;\n\n\t//var called_from = parent.encountercontrol.document.forms[0].called_from.value;\n\tvar graphorder = parent.encountercontrol.document.forms[0].strGraphOrder.value;\n\t\n\tvar cur_idx_value = document.forms[0].cur_idx_value.value;\n\n\tvar fromDateTime =\"\";\n\tvar toDateTime =\"\";\n\tvar displend = \"\";\n\tvar displstart = 1;\n\n\tif(idx_value > 0)\n\t{\n\t\tfromDateTime\t= document.forms[0].from_date.value;\n\t\ttoDateTime\t\t= document.forms[0].to_date.value;\n\t\t\n\t\tif (idx_value >= 1)\n\t\t{\n\t\t\t//toDateTime = dtArr[1];\n\t\t\tif (idx_value > 1)\n\t\t\t\tdisplend = eval(idx_value) ;\n\t\t\telse\n\t\t\t\tdisplend = 1;\n\t\t}\n\t\telse\n\t\t\tdisplend = 1;\n\n\t\tparent.encountercontrol.document.forms[0].cur_idx_value.value = 0;\n\t\tparent.encountercontrol.document.getElementById(\'label_cap\').innerText = \"Page \"+ displstart + \" of \" + displend;\n\t\t\n\t\tif(displend == 1)\n\t\t{\n\t\t\tparent.encountercontrol.document.forms[0].next.disabled = true;\n\t\t\tparent.encountercontrol.document.forms[0].prev.disabled = true;\n\t\t\tparent.encountercontrol.document.forms[0].first.disabled = true;\n\t\t\tparent.encountercontrol.document.forms[0].last.disabled = true;\n\t\t}\n\n\t\tpopulateControl1(fromDateTime,toDateTime);\n\t\t//else\n\t\t//\tpopulateControlOR(fromDateTime,toDateTime);\n\t}\n}\n\ndefaultPage();\n\n</script>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Properties p	= (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String login_user = (String)session.getValue("login_user");//IN071561
	String archivalYN= request.getParameter("archivalYN")==null?"N": request.getParameter("archivalYN");//52176

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmtDt = null;

	ResultSet rsDt = null;
	ResultSet rs = null;
	
	String high_str = "",low_str="",abn_str="",crit_str="",crit_high_str="",crit_low_str="",delta_fail_str="";

	String disabled ="";
	String disablePrev = " disabled ";
	String disableNext = "";
	String birth="";
	String called_from ="";
	String strFromDate  = "";
	String strToDate = "";
	String strPatientId = "";
	String strHistRecType = "";
	String strEventClass ="";
	String strEventGroup = "";
	String strEventCode  = "";
	String strFacilityId ="";
	String strEncounterId ="";
	String strEpisodeType ="";
	String strNormalcyInd ="";
	String strAbnormal ="";
	String strFlowSheetId ="";
	String strViewConfRes ="";
	String strGraphOrder ="";
	String strErrorEvent ="";
	String event_date="";
	String strEncId="";
	String EHR_YN="";
	String defPrevStatus = "";
	//String lastAddedDate = "";
	String emailDisp = "style='display'";
	//ML-MMOH-CRF-0335 - IN057113 - Start
	String conf_pin_req_yn = ""; 
	String bean_id = "Or_ViewOrder" ; 
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;	
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
	//ML-MMOH-CRF-0335 - IN057113 - End
	StringBuffer sbQryCriteria = new StringBuffer();
	StringBuffer	strBuffDates	= new StringBuffer();
	String calling_from_2T = request.getParameter("calling_from_2T")==null?"":request.getParameter("calling_from_2T");//IN068011

	int nKey = 0;
	int nIndex =1;

	strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");

	if(strGraphOrder.equals("D"))
		strGraphOrder = "desc";
	else if(strGraphOrder.equals("A"))
		strGraphOrder = "asc";

	//strViewConfRes	= request.getParameter("viewby")==null?"":request.getParameter("viewby");
	strViewConfRes	= request.getParameter("view_by")==null?"":request.getParameter("view_by");
	strFromDate		= request.getParameter("from_date")==null?"":request.getParameter("from_date"); 
	strToDate		= request.getParameter("to_date")==null?"":request.getParameter("to_date");
	strFromDate		= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
	strToDate		= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");
	event_date		= request.getParameter("event_date")==null?"":request.getParameter("event_date");
	strEventCode	= request.getParameter("event_item")==null?"":request.getParameter("event_item");
	// strErrorEvent= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
	strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
	strPatientId	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	strEventGroup	= request.getParameter("event_group")==null?"":request.getParameter("event_group");
	strEventClass	= request.getParameter("event_class")==null?"":request.getParameter("event_class");
	strHistRecType	= request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
	String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
	//called_from	= request.getParameter("called_from")==null?"":request.getParameter("p_called_from");
	strFacilityId	= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	strEpisodeType	= request.getParameter("episode_type")==null?"B":request.getParameter("episode_type");
	strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	strEncId		= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	strNormalcyInd	= request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
	String eventdate = request.getParameter("event_date")==null?"":request.getParameter("event_date");
	EHR_YN = request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");
	String sortOrder = request.getParameter("sortOrder")==null?"desc":request.getParameter("sortOrder");

	String show_mode = request.getParameter("show_mode")==null?"":request.getParameter("show_mode");
	String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class"); //IN034514
	String p_enc_details_tree		=	request.getParameter("p_enc_details_tree")==null?"":request.getParameter("p_enc_details_tree");//IN034514
	String encntr_yn		=	request.getParameter("encntr_yn")==null?"":request.getParameter("encntr_yn");//IN034514
	
	String p_menu_type		=	request.getParameter("p_menu_type")==null?"":request.getParameter("p_menu_type");//IN034514
	String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
	String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	String key_ref = strPatientId+strEncounterId+strFacilityId;
	String strRowId = "";
	String enctr_id = "";//IN031989
	String fac_id = "";//IN033489
	if(strEpisodeType.equals(""))
		strEpisodeType = "B";
	String resp_id = (String)session.getValue("responsibility_id"); //IN057797
	String printDisp = "style='display'"; //IN057797
	String defPrevStatusForPrint = ""; //IN057797
	String isSiteSpecificForLabPrint = request.getParameter("isSiteSpecificForLabPrint")==null?"":request.getParameter("isSiteSpecificForLabPrint");//IN066453
	eCA.ChartRecordingAddGroupBean encounterBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("encounterBean"+key_ref,"eCA.ChartRecordingAddGroupBean",session);
	boolean restrict_rd	=false;	//IN071561
	encounterBean.clearBean();
	try
	{
		con = ConnectionManager.getConnection(request);
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
	if(strEncId.equals("")) strEncId = "0";

	if(called_from.equals("OR"))
		disabled = "disabled";

	sbQryCriteria.append(" a.patient_id = ? ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= a.FACILITY_ID AND F.ENCOUNTER_ID(+) = a.ENCOUNTER_ID ");  // ##ORDERTYPERESULT## added for 39052

	if(!strHistRecType.equals(""))
		sbQryCriteria.append(" and a.hist_rec_type = ? ");

	if(!strEventClass.equals(""))
		sbQryCriteria.append(" and a.event_class = ? ");

	if(!strEventGroup.equals(""))
		sbQryCriteria.append(" and a.event_group = ? ");

	if(!strEventCode.equals(""))
		sbQryCriteria.append(" and rtrim(a.event_code) = ? ");

	if(!strFromDate.equals(""))
		sbQryCriteria.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI')");

	if(!strToDate.equals(""))
		sbQryCriteria.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287"); //adding 59 seconds more to the todate
		
	if(!eventdate.equals("") && strViewConfRes.equals("D"))
		sbQryCriteria.append(" and  trunc(a.event_date)= to_date(?,'dd/mm/yyyy')");

	if(!strFacilityId.equals(""))
		sbQryCriteria.append(" and a.facility_id = ? ");
	//IN071561 STARTS
	 if(restrict_rd){
		   //sbQryCriteria.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");//common-icn-0180
	       sbQryCriteria.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,?)='N' ");//common-icn-0180
	 }
	//IN071561 ENDS
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && "".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class=? ");
		}
		//IN035950 End

	if(!strEncounterId.equals(""))
		sbQryCriteria.append(" and a.encounter_id = ? ");

  //If patient class is not null then this below query is append related to IN18063.
	if (!strEpisodeType.equals("B") )
		sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

	if(strAbnormal.equals("Y"))
	{
		//Modified the following condition by Archana on 9/16/2010 related to the incident IN023804.
		sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
	}

	if(strViewConfRes.equals("X"))
		sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z')");

	if(strErrorEvent.equals("Y"))//dont'include error events
		sbQryCriteria.append(" and nvl(a.STATUS,'`')!= 'S'  ");
	else 
		sbQryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')"); 
	
	if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
		if(!speciality_code.equals("")){
			sbQryCriteria.append(" and F.SPECIALTY_CODE = ? ");
		}
	} else {
		sbQryCriteria.append(" and F.ATTEND_PRACTITIONER_ID = ? ");
	} // MMS-QH-CRF-0177 [IN047572] - End

		//IN068011 starts
	if("Y".equals(calling_from_2T))
		sbQryCriteria.append(" and a.Added_BY_ID ='DM'");
	//IN068011 Ends
	/*strBuffDates.append("Select distinct to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date 	From 	cr_encounter_detail a ");
	strBuffDates.append("where  "+sbQryCriteria.toString());

	if(!strFlowSheetId.equals(""))
		strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=rtrim(a.event_code)  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ;
			
	strBuffDates.append(" Order by to_date(event_date,'dd/mm/yyyy hh24:mi')  "+strGraphOrder);*/

	//strBuffDates.append("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.event_class, CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,'"+locale+"','1')  event_class_desc, a.event_group, CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,'"+locale+"','1') event_group_desc,a.event_code, CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,'"+locale+"','1') event_desc, a.rowid row_id From	cr_encounter_detail a ,PR_ENCOUNTER F ");//IN033489
	//strBuffDates.append("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.event_class, CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,'"+locale+"','1')  event_class_desc, a.event_group, CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,'"+locale+"','1') event_group_desc,a.event_code, CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,'"+locale+"','1') event_desc, a.rowid row_id, a.encounter_ID, a.FACILITY_ID From	cr_encounter_detail a ,PR_ENCOUNTER F ");//IN033489//common-icn-0180
	strBuffDates.append("Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc, a.event_class, CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc, a.event_group, CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code, CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1') event_desc, a.rowid row_id, a.encounter_ID, a.FACILITY_ID From	cr_encounter_detail a ,PR_ENCOUNTER F ");//IN033489//common-icn-0180

	strBuffDates.append(" where  "+sbQryCriteria.toString());
	
	strBuffDates.append(" order by ");
	
	strBuffDates.append(" 1 ");
	strBuffDates.append(sortOrder+" ,");

	if(strViewConfRes.equals("D")) 
	{
		strBuffDates.append(" TO_CHAR(event_date,'YYYYMMDD') ");
		strBuffDates.append(sortOrder+" ,") ;
     }
	//strBuffDates.append(" 2,1,4,3,nvl(a.REQUEST_NUM_SEQ,'0'),6,5,8,7, event_date ");
	strBuffDates.append(" 3,2,5,4,nvl(a.REQUEST_NUM_SEQ,'0'),7,6,9,8, event_date ");
	strBuffDates.append(sortOrder);
	
//39052 Start.
	String  sqlQuery = strBuffDates.toString();
	if("CA01".equals(order_type_3T)){
		sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##"," AND 'CA01'=SUBSTR(a.ACCESSION_NUM,0,4) ");
	}else{
		sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##","");
	}
	//39052 End.	
		pstmtDt = con.prepareStatement(sqlQuery);
		//common-icn-0180 starts
				pstmtDt.setString(nIndex++, locale);
				pstmtDt.setString(nIndex++, locale);
				pstmtDt.setString(nIndex++, locale);
				pstmtDt.setString(nIndex++, locale);
		//common-icn-0180 ends

		pstmtDt.setString(nIndex++,strPatientId);

		if(!strHistRecType.equals(""))
			pstmtDt.setString(nIndex++,strHistRecType);

		if(!strEventClass.equals(""))
			pstmtDt.setString(nIndex++,strEventClass);

		if(!strEventGroup.equals(""))
			pstmtDt.setString(nIndex++,strEventGroup);

		if(!strEventCode.equals(""))
			pstmtDt.setString(nIndex++,strEventCode);
		
		{
			if(!strFromDate.equals(""))
				pstmtDt.setString(nIndex++,strFromDate);

			if(!strToDate.equals(""))
				pstmtDt.setString(nIndex++,strToDate);
		}
		//else
		/*{
			if(!strFromDate.equals(""))
				pstmtDt.setString(nIndex++,strToDate);

			if(!strToDate.equals(""))
				pstmtDt.setString(nIndex++,strFromDate);
		}
		*/

		if(!eventdate.equals("") && strViewConfRes.equals("D"))
			pstmtDt.setString(nIndex++,eventdate);

		if(!strFacilityId.equals(""))
			pstmtDt.setString(nIndex++,strFacilityId);
		//common-icn-0180 starts
		 if(restrict_rd)
			 pstmtDt.setString(nIndex++,login_user);
		//common-icn-0180 ends
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			pstmtDt.setString(nIndex++,eventClasswidget);
		}
		//IN035950 Ends
		if(!strEncounterId.equals(""))
			pstmtDt.setString(nIndex++,strEncounterId);

	    //If patient class is not null then this below query is append related to IN18063.
		/*modified by Archana on 2/4/2010 at 3:07 PM for IN018685*/
		/*
			strEpisodeType was coming from the tree page as IP instaed of I, so added the || condition
		*/
		if(!strEpisodeType.equals("B") )
		{
			if(strEpisodeType.equals("I") || strEpisodeType.equals("IP"))
				pstmtDt.setString(nIndex++,"IP");
			else if(strEpisodeType.equals("O") || strEpisodeType.equals("OP"))
				pstmtDt.setString(nIndex++,"OP");
			else if(strEpisodeType.equals("D") || strEpisodeType.equals("DC"))
				pstmtDt.setString(nIndex++,"DC");
			else if(strEpisodeType.equals("E") || strEpisodeType.equals("EM"))
				pstmtDt.setString(nIndex++,"EM");
			else if(strEpisodeType.equals("X") || strEpisodeType.equals("XT"))
				pstmtDt.setString(nIndex++,"XT");
		}
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				pstmtDt.setString(nIndex++, speciality_code);
			}
		} else {
			pstmtDt.setString(nIndex++, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572] - End
		//if(!strFlowSheetId.equals(""))
			//pstmtDt.setString(nIndex++,strFlowSheetId);

		int nCtr = 0;

		try
		{
			rsDt = pstmtDt.executeQuery();
	
			String strDateRecd = "";
			//String strLastDt = "";
			//Commented by Jyothi on 12/03/2010 to fix 18685
			/*while (rsDt.next())
			{
				strDateRecd = rsDt.getString(1);
				if(!show_mode.equals("E"))
				{
					if (nCtr == 0 || nCtr == 10)
					{
						lastAddedDate = strDateRecd;*/
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block11Bytes, _wl_block11);

						/*nKey++;
						nCtr =0;
					}
				}
				else
				{
					if (nCtr == 0 || nCtr == 3)
					{
						lastAddedDate = strDateRecd;*/
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block11Bytes, _wl_block11);

						/*nKey++;
						nCtr =0;
					}
				}
				nCtr++;
			}
			if (!strDateRecd.equals(lastAddedDate))
			{ */
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block14Bytes, _wl_block14);
	
			/*nKey++;
		}
			if(nCtr >= 1)
			{*/
				
				
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block16Bytes, _wl_block16);

			//}
			//Added by Jyothi on 12/03/2010 to fix 18685
			int k = 0;
			while (rsDt.next())
			{
				k++;
				fac_id = rsDt.getString("FACILITY_ID") == null ? "" : rsDt.getString("FACILITY_ID");//IN033489
				enctr_id = rsDt.getString("encounter_ID") == null ? "" : rsDt.getString("encounter_ID");//IN033489
				strRowId = rsDt.getString("row_id") == null ? "" : rsDt.getString("row_id");
				Integer in = new Integer(k);
				encounterBean.addRecords(in.toString(),strRowId);

				if(!show_mode.equals("E"))
				{
					if (nCtr == 0 || nCtr == 15)
					{
						nKey++;
						nCtr = 0;
					}
				}
				else
				{
					if (nCtr == 0 || nCtr == 5)
					{
						nKey++;
						nCtr = 0;
					}
				}
				nCtr++;
			}
		
			if(nKey == 0)
			{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
				out.println("clearForm('FS');</script>");
			}


		}
		catch (Exception ee1)
		{
			ee1.printStackTrace();
		}
		finally
		{
			if(rsDt != null) rsDt.close();
			if(pstmtDt != null) pstmtDt.close();
		}
		
		pstmt = con.prepareStatement("SELECT HIGH_STR,LOW_STR, ABN_STR,CRIT_STR, CRIT_HIGH_STR, CRIT_LOW_STR, DELTA_FAIL_STR, nvl((select 'Y' from mp_birth_register where patient_id=?),'N') birth FROM CR_CLIN_EVENT_PARAM");

		pstmt.setString(1,strPatientId);

		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			high_str		= rs.getString("HIGH_STR");
			low_str			= rs.getString("LOW_STR");
			abn_str			= rs.getString("ABN_STR");
			crit_str		= rs.getString("CRIT_STR");
			crit_high_str	= rs.getString("CRIT_HIGH_STR");
			crit_low_str	= rs.getString("CRIT_LOW_STR");
			delta_fail_str	= rs.getString("DELTA_FAIL_STR");
			birth			= rs.getString("birth");
		}
		
		if(delta_fail_str == null) delta_fail_str="";
	
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'EMAIL_DATA' ");
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatus = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if(defPrevStatus.equals("A")) emailDisp = "style='display'";
		else emailDisp = "style='display:none'";
		
		//IN057797 starts
		pstmt = con.prepareStatement("select GET_TASK_APPLICABILITY('PRINT_CLIN_DATA',NULL,?,NULL) DFLT_PRIVILEGE_STATUS from dual");
		pstmt.setString(1,resp_id);
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatusForPrint = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(defPrevStatusForPrint.equals("A")) printDisp = "style='display'";
		else printDisp = "style='display:none'";
		//IN057797 ends
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

	putObjectInBean("encounterBean"+key_ref,encounterBean,session);


            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strFromDate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strToDate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strHistRecType));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strEventClass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strEventGroup));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strEventCode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strEncId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strAbnormal));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strFlowSheetId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strViewConfRes));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strGraphOrder));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strErrorEvent));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(event_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(EHR_YN));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(enctr_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(p_enc_details_tree));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encntr_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(p_menu_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( conf_pin_req_yn ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( speciality_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( attend_pract_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( p_review_rad_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(order_type_3T));
            _bw.write(_wl_block49Bytes, _wl_block49);
 
			if(!"Y".equals(archivalYN)){
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")));
            _bw.write(_wl_block56Bytes, _wl_block56);
 //=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")
            _bw.write(_wl_block57Bytes, _wl_block57);
if(isSiteSpecificForLabPrint.equals("true")&&strHistRecType.equals("LBIN")){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(printDisp));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(emailDisp));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disablePrev));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disableNext));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(disablePrev));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(disablePrev));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(disableNext));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(disableNext));
            _bw.write(_wl_block70Bytes, _wl_block70);
 if(called_from_widget.equals("")){
if(show_mode.equals("E")) {
            _bw.write(_wl_block71Bytes, _wl_block71);

}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewDocument.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClickOnValueCell.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CopyText.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Manage.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Email.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.View.label", java.lang.String .class,"key"));
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
}
