package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __recordpatientadverseevent13 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordPatientAdverseEvent13.jsp", 1740388179371L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n  <script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/messages.js\' ></script>\n<!--   <script language=\'javascript\' src=\'../../eMR/js/eMRmessages.js\' ></script> -->\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n  <script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n  <script language=\'javascript\' src=\"../../eMR/js/RecordPatientAdverseEvent.js\"></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n  <script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n  <script language=\"javascript\" src=\"../../eMP/js/PatEncBanner.js\"></script>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'  onload=\'setTimeout(\"load_reaction_table()\",500);\'> \n \n  <form name = \'reaction_part\' action=\'../../servlet/eMR.RecordAdverseEventServlet\' method=\'post\' target=\'messageFrame\'>\n   <input type=\'hidden\' name=\'react_code_final\' id=\'react_code_final\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n   <input type=\'hidden\' name=\'reac_desc_val\' id=\'reac_desc_val\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n   <input type=\'hidden\' name=\'reac_desc1_val\' id=\'reac_desc1_val\' value=\'\'>\n   <input type=\'hidden\' name=\'otr_reaction\' id=\'otr_reaction\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n  \n<input type=\'hidden\' name=\'reaction_value\' id=\'reaction_value\' value=\'\'>\n <input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n <input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n  <input type=\'hidden\' name=\'adv_event_type\' id=\'adv_event_type\' value=\'\'>\n  <input type=\'hidden\' name=\'onset_date\' id=\'onset_date\' value=\'\'>\n <input type=\'hidden\' name=\'allergen_id\' id=\'allergen_id\' value=\'\'>\n <!--Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start-->\n  <input type=\'hidden\' name=\'allergen_free_text\' id=\'allergen_free_text\' value=\'\'>\n  <input type=\'hidden\' name=\'advEventSrlNo\' id=\'advEventSrlNo\' value=\'\'>\n  <!--End-->\n  <input type=\'hidden\' name=\'allergyAlertby\' id=\'allergyAlertby\' value=\'\'>\n <input type=\'hidden\' name=\'cause_sub\' id=\'cause_sub\' value=\'\'>\n <input type=\'hidden\' name=\'adv_event_ind\' id=\'adv_event_ind\' value=\'\'>\n <input type=\'hidden\' name=\'certainity\' id=\'certainity\' value=\'\'>\n <input type=\'hidden\' name=\'sou_of_info\' id=\'sou_of_info\' value=\'\'>\n <input type=\'hidden\' name=\'status_val\' id=\'status_val\' value=\'\'>\n <input type=\'hidden\' name=\'since_date\' id=\'since_date\' value=\'\'>\n <input type=\'hidden\' name=\'diagnosis_code\' id=\'diagnosis_code\' value=\'\'>\n <input type=\'hidden\' name=\'route_of_expo\' id=\'route_of_expo\' value=\'\'>\n <input type=\'hidden\' name=\'allergy_test_res\' id=\'allergy_test_res\' value=\'\'>\n <input type=\'hidden\' name=\'treat_advice\' id=\'treat_advice\' value=\'\'>\n <input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'>\n <input type=\'hidden\' name=\'drug_code\' id=\'drug_code\' value=\'\'>\n <input type=\'hidden\' name=\'PatientId\' id=\'PatientId\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n <input type=\'hidden\' name=\'Encounter_Id\' id=\'Encounter_Id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n <input type=\'hidden\' name=\'date_time\' id=\'date_time\' value=\'\'>\n <input type=\'hidden\' name=\'allergen\' id=\'allergen\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n <input type=\'hidden\' name=\'causative_code\' id=\'causative_code\' value=\'\'>\n<input type=\'hidden\' name=\'status1\' id=\'status1\' value=\'\'>\n<input type=\'hidden\' name=\'err_remark\' id=\'err_remark\' value=\'\'>\n<input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\'\'>\n<input type=\'hidden\' name=\'no_known_allergy\' id=\'no_known_allergy\' value=\'\'>\n<input type=\'hidden\' name=\'estimated_duration_yn\' id=\'estimated_duration_yn\' value=\'\'>\n<input type=\'hidden\' name=\'add_reation_yn\' id=\'add_reation_yn\' value=\'\'>\n<input type=\'hidden\' name=\'check_stat\' id=\'check_stat\' value=\'\'>\n<input type=\'hidden\' name=\'AllergyConfirmYN\' id=\'AllergyConfirmYN\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'><!--  ADDED FOR THE CRF - RUT-CRF-0064 -->\n<input type=\'hidden\' name=\'allergy_conf_reqd_yn\' id=\'allergy_conf_reqd_yn\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'><!--  ADDED FOR THE CRF - RUT-CRF-0064 -->\n<!-- Below lines added by venkatesh.S against ML-MMOH-CRF-0366 -->\n<input type=\'hidden\' name=\'onset_type\' id=\'onset_type\' value=\'\'> \n<input type=\'hidden\' name=\'comments\' id=\'comments\' value=\'\'> \n<!-- end ML-MMOH-CRF-0366 -->\n\n   <!-- Below line added for this CRF Bru-HIMS-CRF-133 -->\n\t<input type=\"hidden\" name=\"isPatientEncMovement\" id=\"isPatientEncMovement\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"Sydate\" id=\"Sydate\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"p_queue_date\" id=\"p_queue_date\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"p_queue_status\" id=\"p_queue_status\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<!-- End Bru-HIMS-CRF-133 -->\n\n\n<table cellpadding=\'0\' id=\'reaction_table\' name=\'reaction_table\' border=\'1\' cellspacing=\'0\' width=\'100%\' align=\'center\' style=\'display:none\' >\t\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<th width=\'20%\'><div  id=\'head0\' class=\'myClass\' nowrap width=\'25%\' ></div></th>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<th width=\'20%\'><div  id=\'head1\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div></th>\n\t<th width=\'30%\'><div  id=\'head2\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div></th>\n\t<th width=\'25%\'><div  id=\'head3\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div></th>\n\t<th width=\'25%\'><div  id=\'head4\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div></th>\n ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<td class=\'label\' width=\'20%\' style = \'text-align:justify;word-break:break-all;\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<td class=\'label\' width=\'30%\'><input type=\'text\' name=\'reaction_date\' id=\'reaction_date\' disabled value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  maxlength=\"16\" size=\"14\" ><img id=\'cal1\' src=\"../../eCommon/images/CommonCalendar.gif\" disabled /></td>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'><input type=\'text\' name=\'severity\' id=\'severity\' disabled value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  maxlength=\"16\" size=\"14\" ></td>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'><textarea name=\'Site_Of_Reac\' disabled onkeypress=\"return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);\" rows=\'1\' cols=\'25\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</textarea></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t<td  class=\'label\' width=\'20%\'>\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' name =\"chkreact";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" value =\'\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" onclick=\'getchkvalues(this)\' id=\'react\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="disabled";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'20%\' style = \'text-align:justify;word-break:break-all;\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="<input type=\"hidden\" name=\"adv_reac_event_code";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"adv_reac_event_code";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t<input type= \'hidden\' name = \'error_status";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t\t\t\t\t<td class=\'label\' width=\'30%\'><input type=\'text\' name=\'reaction_date";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'reaction_date";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' disabled value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'  maxlength=\"16\" size=\"14\" ><img id=\'cal1\' src=\"../../eCommon/images/CommonCalendar.gif\" disabled />\n\t\t\t\t\t\t\t<input type = \'hidden\' name = \'react_description";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' value = \'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'></td>\n\t\t\t\t\t\t\t<td class=\'label\' width=\'25%\'><input type=\'text\' name=\'severity\' id=\'severity\' disabled value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'  maxlength=\"16\" size=\"14\" ></td><input type = \'hidden\' name = \'severity_desc";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t\t\t\t\t\t<td class=\'label\' width=\'25%\'><textarea name=\'Site_Of_Reac\' disabled onkeypress=\"return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);\" rows=\'1\' cols=\'25\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</textarea></td>\n\t\t\t\t\t\t\t<input type = \'hidden\' name = \'site_desc";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t\t\t\t\t\t<input type = \'hidden\' name = \'adv_event_rxn_srl_no";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t<td  class=\'label\' width=\'20%\'>\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' name =\"achkreact";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" onclick=\'getchkvalues(this)\' id=\'react";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'20%\' style = \'text-align:justify;word-break:break-all;\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t<input type= \'hidden\' name = \'a_error_status";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t\t\t\t\t\t<td class=\'label\' width=\'30%\'><input type=\'text\' name=\'a_reaction_date";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'a_reaction_date";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' maxlength=\"16\" size=\"14\" ><img id=\'acal1\' src=\"../../eCommon/images/CommonCalendar.gif\" disabled />\n\t\t\t\t\t\t\t<input type = \'hidden\' name = \'a_react_description";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'></td>\n\t\t\t\t\t\t\t<td class=\'label\' width=\'25%\'><input type=\'text\' name=\'a_severity\' id=\'a_severity\' disabled value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'  maxlength=\"16\" size=\"14\" ></td><input type = \'hidden\' name = \'a_severity_desc";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t\t\t\t\t\t<td class=\'label\' width=\'25%\'><textarea name=\'a_Site_Of_Reac\' disabled onkeypress=\"return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);\" rows=\'1\' cols=\'25\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</textarea></td>\n\t\t\t\t\t\t\t<input type = \'hidden\' name = \'a_site_desc";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t<input type = \'hidden\' name = \'oldreactionvalue_count\' value = \'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\t\t<tr >\n\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\n\t\t     <!--<td class=\'label\' width=\'20%\'>&nbsp;<!--<input type=\"checkbox\" name=\"x";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"x";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" value=\'\' > -->\n\t\t\t<!--</td>-->\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\n\t\t     <td class=\'label\' width=\'20%\'>&nbsp;<!--<input type=\"checkbox\" name=\"x";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" value=\'\' > -->\n\t\t\t</td> \n\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td><input type=\'hidden\' name=\'reac_desc";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' id=\'reac_desc";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' >\n\t\t\t\t<td class=\'label\' width=\'30%\'><input type=\'text\' name=\'reaction_date";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'  maxlength=\"16\" size=\"14\" onblur=\"CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate(this,";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =");\"><img id=\'cal1\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'reaction_date";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\',null,\'hh:mm\');\"/><img id=\'cal_man\' src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img></td>\n\t\t\t\t<td class=\'label\' width=\'25%\'><select name=\'severity";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' id=\'severity";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="---</option>\n\t\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</option>\n\t\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</option>\n\t\t\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</option>\n\t\t\t\t<option value=\'U\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</option></select></td>\n\t\t\t\t<td class=\'label\' width=\'25%\'><textarea name=\'Site_Of_Reac";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'  onblur = \'checkMaxLimit(this);\' onkeypress=\"return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);\" rows=\'1\' cols=\'25\' value=\'\'>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</textarea></td>\n\t\t\t\t<script>\n\t\t\t\t\tdocument.forms[0].severity";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =".value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\';\n\t\t\t\t</script>\n\t\t\t   </tr>\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" value=\'\' > -->\n\t\t\t</td> \n\t\t\t\n\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\t\t\t\t\t\n\t\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' >\n\t\t\t<td class=\'label\' width=\'30%\'><input type=\'text\' name=\'reaction_date";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'   maxlength=\"16\" size=\"14\" onblur=\"CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate(this,";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\',null,\'hh:mm\');\"/><img id=\'cal_man\' src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img></td>\n\t\t\t<td class=\'label\' width=\'25%\'><select name=\'severity";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' >\n\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="---</option>\n\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</option>\n\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</option>\n\t\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</option>\n\t\t\t<option value=\'U\'>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</option></select></td>\n\t\t\t<td class=\'label\' width=\'25%\'><textarea name=\'Site_Of_Reac";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'  onblur = \'checkMaxLimit(this);\' onkeypress=\"return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);\" rows=\'1\' cols=\'25\' value=\'\'></textarea></td>\n\t  ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t  \n\t\t     <td class=\'label\' width=\'20%\'>&nbsp;<!--<input type=\"checkbox\" name=\"x";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\n\t\t\t<td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'  maxlength=\"16\" \n\t\t\tsize=\"14\" onblur=\"CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate(this,";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =");\">\n\t\t\t<!--<td class=\'label\' width=\'30%\'><input type=\'text\' name=\'reaction_date";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'  maxlength=\"16\"  size=\"14\" onblur=\"CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate(this,";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =");\">-->\n\t\t\t<img id=\'cal1\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'reaction_date";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'  onblur = \'checkMaxLimit(this);\' onkeypress=\"return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);\" rows=\'1\' cols=\'25\' value=\'\'></textarea></td>\n\n\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t<tr>\n\n\t    <!--<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =": ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</td>-->\n\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t     <td class=\'label\' width=\'20%\'><input type=\"checkbox\" name=\"chkreact_2\" id=\"chkreact_2\" value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' style=\'display:none\' >  </td>\n\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t<td class=\'label\' width=\'20%\' style = \'text-align:justify;word-break:break-all;\' >";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</td>\n\t\t\t<input type=\'hidden\' name=\'oth_reac_desc";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' id=\'oth_reac_desc";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' >\n\n\t\t\t<td class=\'label\' width=\'30%\'><input type=\'text\' name=\'other_reaction_date";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' id=\'other_reaction_date";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' id=\'other_reaction";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' maxlength=\"16\" size=\"14\" onblur=\"CompareRegnDate2(this,document.forms[0].sysdate);Check_Duplicate1(this);\">\n\t\t\t<img id=\'cal1\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'other_reaction";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\',null,\'hh:mm\');\"/><img id=\'cal_man\' src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img></td>\n\t\t\t<td class=\'label\' width=\'25%\'><select name=\'severity_oth";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' id=\'severity_oth";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</option></select></td>\n\t\t\t<td class=\'label\' width=\'25%\'><textarea name=\'Site_Of_Reac_oth";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'  onblur = \'checkMaxLimit(this);\' onkeypress=\"return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);\" rows=\'1\' cols=\'25\' value=\"\">";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</textarea></td>\n\t\t\t<script>\n\t\t\t\tdocument.forms[0].severity_oth";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\';\n\t\t\t</script>\n\t\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t\t<td class=\'label\' width=\'20%\' style = \'text-align:justify;word-break:break-all;\' >";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'  onblur = \'checkMaxLimit(this);\' onkeypress=\"return CheckForSpecChars_spec(event);return imposeMaxLength(this, 100);\" rows=\'1\' cols=\'25\' value=\'\'></textarea></td>\t\n\t\t\t\n\t\t</tr>\n\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t<input type=\'hidden\' name=\'reaction_oth";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\' id=\'reaction_oth";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t<input type=\'hidden\' name=\'reaction_oth\' id=\'reaction_oth\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n</table>\n\t\t<table cellpadding=\'0\' id=\'add_reaction_table\' border=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' >\n\n<tr>\n\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t <td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =" </td>\n\t\t\t\t <td class=\'fields\' width=\'30%\' ><input type=\'text\'  disabled  name=\'add_reaction\' id=\'add_reaction\'  value=\'\' size=\'30\' maxlength=\'30\' onblur=\'if(this.value !=\"\") onblur_reaction(this) else disable()\' ><input disabled  type=\'button\' class=\'BUTTON\' name=\'add_reaction_search\' id=\'add_reaction_search\' value=\'?\' onClick=\'callreactionSearch();\'  id=\'reaction_search\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'add_resc\' ></img>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</td>\n\t\t\t\t <td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t\t \n\t\t\t\t <td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" </td>\n\t\t\t\t <td class=\'fields\' width=\'30%\' ><input type=\'text\'  name=\'add_reaction\' id=\'add_reaction\'  value=\'\' size=\'30\' maxlength=\'30\' onblur=\'if(this.value !=\"\") onblur_reaction(this)\' disabled><input type=\'button\' class=\'BUTTON\' name=\'add_reaction_search\' id=\'add_reaction_search\' value=\'?\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 =" onClick=\'callreactionSearch();\' >";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'add_resc\'></img>";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</td>\n\t\t\t\t <td class=\'label\' colspan=\'2\'>&nbsp;";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="<input type = \'hidden\' name = \'oldreactionvalue_count\' value = \'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'></td>\n\t\t\t\t ";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t  <td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" </td>\n\t\t\t\t \t <td class=\'fields\' width=\'30%\' ><input type=\'text\'  name=\'add_reaction\' id=\'add_reaction\'  value=\'\' size=\'30\' maxlength=\'30\' onblur=\'if(this.value !=\"\") onblur_reaction(this)\' ";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="><input type=\'button\' class=\'BUTTON\' name=\'add_reaction_search\' id=\'add_reaction_search\' value=\'?\' onClick=\'callreactionSearch();\' ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'add_resc\' ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="style=\"visibility:hidden\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="></img></td>\n\t\t\t\t <td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t\n\t\t\t ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n </tr> \n </table>\n";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\n \n <input type=\'hidden\' name=\'count_val\' id=\'count_val\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n\n <input type=\'hidden\' name=\'react_code_final1\' id=\'react_code_final1\' value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n <input type=\'hidden\' name=\'oth_reaction\' id=\'oth_reaction\' value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\n <input type=\'hidden\' name=\'oth_reaction_counter\' id=\'oth_reaction_counter\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n <input type=\'hidden\' name=\'status\' id=\'status\' value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\n <input type=\'hidden\' name=\'tot_cnt\' id=\'tot_cnt\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'>\n  <input type=\'hidden\' name=\'final_react_description\' id=\'final_react_description\' value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n  <input type=\'hidden\' name=\'final_value\' id=\'final_value\' value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'>\n  <input type=\'hidden\' name=\'adv_reac_code\' id=\'adv_reac_code\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\n  <input type=\'hidden\' name=\'adding_react_yn\' id=\'adding_react_yn\' value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\n  <input type=\'hidden\' name=\'final_total\' id=\'final_total\' value=\'\'>\n  <input type=\'hidden\' name=\'chk_react\' id=\'chk_react\' value=\'\'>\n  <input type=\'hidden\' name=\'onset_date1\' id=\'onset_date1\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n  <input type=\'hidden\' name=\'adv_event_type_ind_code1\' id=\'adv_event_type_ind_code1\' value=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'>\n\n<!--27/11/2008 6257 reopen--->\n\n\n</form>\n\n</body>\n<script>\n\n</script>\n\n ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\n\n";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


 
  request.setCharacterEncoding("UTF-8");
  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs = null;
  Statement stmt = null;
  PreparedStatement pstmt = null;//Added For PE On 6/10/2010
  String chkAttribute="";
  String chkdisable="";
  String all_disabled=" ";
           /*Below line added for this CRF Bru-HIMS-CRF-133*/	
        String isPatientEncMovement=request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
        String Sydate=request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
        String p_queue_date=request.getParameter("p_queue_date")==null?"":request.getParameter("p_queue_date");
        String p_queue_status=request.getParameter("p_queue_status")==null?"":request.getParameter("p_queue_status");
		
	  //End this CRF Bru-HIMS-CRF-133		
  String locale = (String)session.getAttribute("LOCALE");
  boolean diplay_mandatory=false;
    String status = request.getParameter("status");
	if(status == null) status = "";
status=java.net.URLDecoder.decode(status);
//ArrayList list=new ArrayList();//commented for checkstyle
	String status_r = "";
	String adv_event_rxn_srl_no="";
	//String final_reaction="";
	//String final_date="";
	//String final_severity="";
	//String final_site="";
	//String final_reac="";
	//String final_date1="";
	//String final_severity1="";
	//String final_site1="";
	//int tempcount=0;

	if(status.equals("R") || status.equals("E"))
	{
		status_r = "disabled";
		

	}
	
    String adding_react_yn = request.getParameter("adding_react_yn");
	if(adding_react_yn==null)
		adding_react_yn="N";

  String reac_code_val=request.getParameter("reac_code_val");
  if(reac_code_val ==null) reac_code_val="";
reac_code_val=java.net.URLDecoder.decode(reac_code_val);

//out.println("<script>alert(\""+reac_code_val+"\");</script>");
  String otr_reaction=request.getParameter("otr_reaction");
  if(otr_reaction ==null) otr_reaction="";
otr_reaction=java.net.URLDecoder.decode(otr_reaction);
  String reac_desc_val=request.getParameter("reac_desc_val");
  if(reac_desc_val ==null) reac_desc_val="";
  
  String mode=request.getParameter("mode");
 
 if(mode ==null || mode=="") mode="insert";
 //
if(mode.equals("insert")){
	//chkAttribute="CHECKED";
	//out.println(chkAttribute);
}
/*if(mode.equals("record")){
	if(!status.equals("Active"))
	{
	chkdisable= "DISABLED";
	chkAttribute="";
	}
	//out.println(chkdisable);

}*/


  String PatientId=request.getParameter("PatientId");
  if(PatientId ==null) PatientId="";
PatientId=java.net.URLDecoder.decode(PatientId);

   String Encounter_Id=request.getParameter("Encounter_Id");
  if(Encounter_Id ==null) Encounter_Id="";
Encounter_Id=java.net.URLDecoder.decode(Encounter_Id);

  String reaction_date_modify=request.getParameter("reaction_date");
  if(reaction_date_modify ==null) reaction_date_modify="";
  reaction_date_modify=java.net.URLDecoder.decode(reaction_date_modify);
  String causative_code=request.getParameter("causative_code");
  if(causative_code ==null) causative_code="";
	causative_code=java.net.URLDecoder.decode(causative_code);

  String adv_event_type_code=request.getParameter("adv_event_type_code");
  if(adv_event_type_code ==null) adv_event_type_code="";
  adv_event_type_code=java.net.URLDecoder.decode(adv_event_type_code);

  String adv_event_type_ind_code=request.getParameter("adv_event_type_ind_code");
  if(adv_event_type_ind_code ==null) adv_event_type_ind_code="";
adv_event_type_ind_code=java.net.URLDecoder.decode(adv_event_type_ind_code);
  

  String allergen_blank = request.getParameter("allergen_blank");
  if(allergen_blank==null)
   all_disabled ="disabled";

String onset_date = request.getParameter("onset_date");
if(onset_date == null) onset_date = "";
onset_date=java.net.URLDecoder.decode(onset_date);
//out.println("<script>alert(\""+onset_date+"\");</script>");
 //if(allergen_blank ==null) allergen_blank="";
//if(allergen_blank.equals(null)  || allergen_blank==null)
//if(allergen_blank.equals(null)  || allergen_blank==null||allergen_blank.equals("null"))
			//String all_disabled ="disabled";
   //String reactioncode="";
   String reactDesc=" ";
  String reactiondesc_total="";
  String reaction_desc="";
  String reaction_date="";
  String reaction_date1_disply="";
  String onset_date_disply="";
  String sysdate="";
  String reac_code ="";
  String reaction_date_modify_disply="";
  String oth_reaction="";
  String final_value="";
  String adv_reac_code="";
  String err_status="";

  String disableField="";
onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
//out.println("<script>alert(\""+onset_date_disply+"\");</script>");

	
 
  String allengy_dis=checkForNull(request.getParameter("causative_code"));
  String AllergyConfirmYN=checkForNull(request.getParameter("AllergyConfirmYN"));//Added for the crf - RUT-CRF-0064
  String allergy_conf_reqd_yn=checkForNull(request.getParameter("allergy_conf_reqd_yn"));//Added for the crf - RUT-CRF-0064
if(allengy_dis==""||allengy_dis.equals(" ")){
  disableField="disabled";
}
else{
		disableField="";
}
  int i=0;
  int other_reaction_counter = 0;

  int max_record = 0;


	try 
	{
//		Commented On 6/10/2010 for PE
//	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt=con.createStatement();
		String sql="SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi') FROM dual";
		rs=stmt.executeQuery(sql);
		if(rs !=null && rs.next()){
			reaction_date=rs.getString(1);
		}
		sysdate = reaction_date;
		if(stmt!=null){stmt.close();}
		if(rs!=null){rs.close();}

/*Wednesday, December 23, 2009 modified for SRR20056-CRF-0303.1 [IN015407] ,to display reaction date as active since date*/
	String reaction_date_disply=request.getParameter("reaction_date_disply");
	if(reaction_date_disply ==null) reaction_date_disply="";
	//reaction_date_disply=java.net.URLDecoder.decode(reaction_date_disply);
	//reaction_date1_disply=DateUtils.convertDate(reaction_date_disply,"DMYHM","en",locale);
	/*Tuesday, September 28, 2010 , SRR20056-SCF-5367 [IN:024015]*/
	reaction_date1_disply=java.net.URLDecoder.decode(reaction_date_disply);
	String localeSysDate =DateUtils.convertDate(sysdate,"DMYHM","en",locale); //INC:47616

 if (rs != null) rs.close();


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(reac_code_val));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(reac_desc_val));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(otr_reaction));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(AllergyConfirmYN));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(allergy_conf_reqd_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_queue_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(mode.equals("record")){
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
 
	String sql_default_values="";

/*The Below Query was modified for PE changed to PreparedStatement from Statement.*/
	sql_default_values= " SELECT  f.ADV_REAC_CODE   ,g.LONG_DESC LONG_DESC,to_char(f.reaction_date,'dd/mm/yyyy hh24:mi') reaction_date ,f.OTHERS_REACTION,f.SEVERITY,f.REACTION_SITE REACTION_SITE,f.status error_status,f.adv_event_rxn_srl_no FROM pr_allergy_sensitivity a,pr_adverse_event e, pr_adverse_event_reaction f,am_reaction_lang_vw g  WHERE a.patient_id =? AND a.status = ?  AND f.reaction_date=nvl(To_Date(?, 'dd/mm/yyyy hh24:mi'),reaction_date )AND   a.allergen_code=?  AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind  AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code  AND a. ADV_EVENT_TYPE=?  AND a.ADV_EVENT_TYPE=e.ADV_EVENT_TYPE AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND f.adv_reac_code = g.reaction_code(+) and g.language_id(+)=? and f.status = 'A' and a.onset_date=nvl(To_Date(?, 'dd/mm/yyyy hh24:mi:ss'),onset_date ) and a.adv_event_type_ind = ?ORDER BY a.allergen_code, a.onset_date, f.reaction_date";
if(mode.equals("modify")){
			/* Commented ON 6/10/2010 for PE
			rs=stmt.executeQuery(sql_default_values);
			rs.last();
			max_record = rs.getRow();
			rs.beforeFirst();*/
			pstmt =con.prepareStatement(sql_default_values);
			pstmt.setString(1,PatientId);
			pstmt.setString(2,status);
			pstmt.setString(3,reaction_date_modify);
			pstmt.setString(4,causative_code);
			pstmt.setString(5,adv_event_type_code);
			pstmt.setString(6,locale);
			pstmt.setString(7,onset_date);
			pstmt.setString(8,adv_event_type_ind_code);
			rs=pstmt.executeQuery();
			if(rs !=null){
				while(rs.next()){
				adv_reac_code=rs.getString("ADV_REAC_CODE");
				if(adv_reac_code == null){ adv_reac_code="";}
				String others_reaction=rs.getString("OTHERS_REACTION");
				if(others_reaction == null){ 
					others_reaction="";
				}else{
					others_reaction= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OtherReactions.label","mr_labels") + ":"+ others_reaction;
				}
				String site_of_reac=rs.getString("REACTION_SITE");
				if(site_of_reac ==null){site_of_reac="";}
				String reaction_desc_modify=rs.getString("LONG_DESC");
				if(reaction_desc_modify ==null){reaction_desc_modify="";}
				String severity_code=rs.getString("SEVERITY");
				if(severity_code ==null){severity_code="";}
				String severity_desc="";
				err_status = rs.getString("error_status");
				if(mode.equals("record")){
					reaction_date_modify=rs.getString("reaction_date");
					adv_event_rxn_srl_no=rs.getString("adv_event_rxn_srl_no");
					if(reaction_date_modify ==null){reaction_date_modify="";}
					reaction_date_modify_disply=DateUtils.convertDate(reaction_date_modify,"DMYHM","en",locale);
				}
				if(severity_code.equals("M")){
					severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
				}else if(severity_code.equals("O")){
					severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labelsels");
				}else if(severity_code.equals("S"))	{
					severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
				}else if(severity_code.equals("U")){
					severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}
				
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(adv_reac_code.equals("Oth"))	{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(others_reaction));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(reaction_desc_modify));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(reaction_date_modify_disply));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(severity_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(site_of_reac));
            _bw.write(_wl_block36Bytes, _wl_block36);

					max_record++;
				}
				if(pstmt!=null){pstmt.close();}
				if(rs!=null){rs.close();}
			}
		}else{
			if(mode.equals("record")){
				max_record=0;
				/*Commented ON 6/10/2010 for PE
				rs=stmt.executeQuery(sql_default_values);
				rs.last();
				max_record = rs.getRow();
				rs.beforeFirst();*/
				pstmt =con.prepareStatement(sql_default_values);
				pstmt.setString(1,PatientId);
				pstmt.setString(2,status);
				pstmt.setString(3,reaction_date_modify);
				pstmt.setString(4,causative_code);
				pstmt.setString(5,adv_event_type_code);
				pstmt.setString(6,locale);
				pstmt.setString(7,onset_date);
				pstmt.setString(8,adv_event_type_ind_code);
				rs=pstmt.executeQuery();
				if(rs !=null){
					while(rs.next()){
					
					
						adv_reac_code=rs.getString("ADV_REAC_CODE");
						if(adv_reac_code == null) adv_reac_code="";
						String others_reaction=rs.getString("OTHERS_REACTION");
						if(others_reaction == null) {
							others_reaction="";
						}else{
							others_reaction= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OtherReactions.label","mr_labels")+ ":"+ others_reaction;
						}
						String site_of_reac=rs.getString("REACTION_SITE");
						adv_event_rxn_srl_no=rs.getString("adv_event_rxn_srl_no");
						if(site_of_reac ==null){site_of_reac="";}
						String reaction_desc_modify=rs.getString("LONG_DESC");
						if(reaction_desc_modify ==null){reaction_desc_modify="";}
						String severity_code=rs.getString("SEVERITY");
						if(severity_code ==null){severity_code="";}
						String severity_desc="";
						reaction_date_modify=rs.getString("reaction_date");
						if(reaction_date_modify ==null){reaction_date_modify="";}
						/**10/2/2008*/
						String error_status = "";
						err_status = rs.getString("error_status");
						if(error_status==null){err_status = "A";}
						if(adv_reac_code.equals("Oth")){
							//error_status=others_reaction;
							error_status=others_reaction;
						}else{
							error_status=adv_reac_code;
						}
						/*Created by Senthil Reaction code Added into ArrayList on 01-08-2011*/						
                        //list.add(adv_reac_code);	
						
						/**10/2/2008*/
						reaction_date_modify_disply=DateUtils.convertDate(reaction_date_modify,"DMYHM","en",locale);
						if(severity_code.equals("M")){
							severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
						}else if(severity_code.equals("O")){
							severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labelsels");
						}else if(severity_code.equals("S")){
							severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
						}else if(severity_code.equals("U")){
							severity_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						}
						
						if(adding_react_yn.equals("N")){
            _bw.write(_wl_block37Bytes, _wl_block37);
if(!(mode.equals("insert") || err_status.equals("E"))){ 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chkdisable));
            _bw.write(_wl_block40Bytes, _wl_block40);
if(!status.equals("A")){
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
 if(adv_reac_code.equals("Oth"))	{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(others_reaction));
 /*hidden field added by senthil 09-08-2011*/
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(adv_reac_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else {
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(reaction_desc_modify));
 /*hidden field added by senthil 09-08-2011*/
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(adv_reac_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(error_status));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(reaction_date_modify_disply));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(reaction_date_modify_disply));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(severity_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(severity_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(site_of_reac));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(site_of_reac));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(adv_event_rxn_srl_no));
            _bw.write(_wl_block62Bytes, _wl_block62);

						}else{
            _bw.write(_wl_block37Bytes, _wl_block37);
if(!(mode.equals("insert") || err_status.equals("E"))){
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chkdisable));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            _bw.write(_wl_block41Bytes, _wl_block41);
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
 if(adv_reac_code.equals("Oth")){
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(others_reaction));
            _bw.write(_wl_block67Bytes, _wl_block67);
 /*hidden field added by senthil 09-08-2011*/
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(adv_reac_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
}else {
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(reaction_desc_modify));
            _bw.write(_wl_block67Bytes, _wl_block67);
/* hidden field added by senthil 09-08-2011*/
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(adv_reac_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(error_status));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(reaction_date_modify_disply));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(reaction_date_modify_disply));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(severity_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(severity_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(site_of_reac));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(site_of_reac));
            _bw.write(_wl_block62Bytes, _wl_block62);
}
						i++;
						max_record++;
					}
					 /*hidden field added by senthil 09-08-2011*/
					
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);

					if(pstmt!=null){pstmt.close();}
					if(rs!=null){rs.close();}
				}
				//Wednesday, March 25, 2009	this is added here for modified mode
				i=0;
	}
		String reactionCode="";
		String reactionDesc="";
		String reactionDate="";
		String reactionSeviarity="";
		String siteofReaction="";
		ArrayList addReaction=new ArrayList();		
		String final_total = checkForNull(request.getParameter("final_total"));	
        	
		int no_of_rws=0;
		if(!final_total.equals("")){
			StringTokenizer _token = new StringTokenizer(final_total,"!");
			while(_token.hasMoreTokens()){
				no_of_rws++;
				String listReaction=_token.nextToken();
				StringTokenizer finalListRec = new StringTokenizer(listReaction,"^");
				while(finalListRec.hasMoreTokens()){

					reactionCode = finalListRec.nextToken();		
					reactionDesc = finalListRec.nextToken();		
					reactionDate = finalListRec.nextToken();		
					reactionSeviarity = finalListRec.nextToken();
					if(reactionSeviarity.equals("~")) reactionSeviarity = "";
					siteofReaction = finalListRec.nextToken();
					if(siteofReaction.equals("~")) siteofReaction = "";
					addReaction.add(reactionCode);
					addReaction.add(reactionDesc);
					addReaction.add(reactionDate);
					addReaction.add(reactionSeviarity);
					addReaction.add(siteofReaction);

				
			  }
			}
		}
		//out.println(addReaction);
		
		
	
	String prev_oth_reaction="$";
 
	if(!reac_desc_val.equals("") )
			{
	StringTokenizer reaction_val= new StringTokenizer(reac_desc_val,"`");

	if(adding_react_yn.equals("Y"))
		i=0;
	//int reactionvalCnt = reaction_val.countTokens();//Commented for checkstyle
	//for(int rvc = 0 ;rvc < reactionvalCnt ;rvc++ )
	//{
	while(reaction_val.hasMoreTokens())
	{
		reactiondesc_total=reaction_val.nextToken();	    
		oth_reaction=reaction_val.nextToken();
			
		oth_reaction=oth_reaction.substring(0,oth_reaction.length()-1);
		diplay_mandatory=true;

	int temp_var=0;

	if(!reactiondesc_total.equals("$"))
		{
StringTokenizer reaction_val_new= new StringTokenizer(reactiondesc_total,";");

String tmp_code="";
String tmp_desc="";
String tmp_dt="";
String tmp_sev="";
String tmp_sit="";
String reacDescCode="";



	while(reaction_val_new.hasMoreTokens() )
	{
		reacDescCode=reaction_val_new.nextToken();		 
		reaction_desc=reaction_val_new.nextToken();	
		
            _bw.write(_wl_block79Bytes, _wl_block79);
//if(!mode.equals("insert")){
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
//}	 
		boolean populateValues = false;		
		if(addReaction.size()>0  && addReaction.size() >temp_var){							
			for(int a=0;a<addReaction.size();a++){				
				if((addReaction.get(a)).equals(reacDescCode)){	 
					populateValues = true;			
					temp_var = a;
				}			
			}						
		 
			
		if(populateValues ){		 
				tmp_code=(String) addReaction.get(temp_var);
				tmp_desc=(String) addReaction.get(temp_var+1);
				tmp_dt=(String) addReaction.get(temp_var+2);
				tmp_sev=(String) addReaction.get(temp_var+3);
				tmp_sit=(String) addReaction.get(temp_var+4);	
	 
			/*Avoid the Add Duplicate Reaction Created by Senthil on 01-08-2011*/	
			if(!mode.equals("insert")){
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
}//End 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(reaction_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(reaction_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(tmp_dt));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(tmp_sit));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(tmp_sev));
            _bw.write(_wl_block102Bytes, _wl_block102);
}
				else{	  
					temp_var=temp_var-5;
          /*Avoid the Duplicate Reaction Created by Senthil on 01-08-2011*/						
			if(!mode.equals("insert")){
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
} //End
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(reaction_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(reaction_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(reaction_date1_disply));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
} 	
		}else{ 		  
		if(!mode.equals("insert")){
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
} //End
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(reaction_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(reaction_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(localeSysDate));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);
		
	}
		temp_var=temp_var+5;	
	
	i++; 
		disableField=" ";	
	}

	int j=0;
	int k=0;
	
	StringTokenizer reaction_code= new StringTokenizer(reac_code_val,"`");     
	int counter1=reaction_code.countTokens(); 
	String reaction_code1[]=new String[counter1];
	while(reaction_code.hasMoreTokens())
	{
		reaction_code1[j]=reaction_code.nextToken();
		 
		if(j!=0)
		{
		out.println("<input type='hidden' name='reaction_code"+(k-1)+"' id='reaction_code"+(k-1)+"' value='"+reaction_code1[j]+"'>");
		if(j==1)
		{
		reac_code=reaction_code1[j];		 
		}else
		{
		//reac_code+="*"+reaction_code1[j];
		reac_code=reac_code+"`"+reaction_code1[j];
		}
		}
		j++;
		k++;
		
	}
	out.println("<input type='hidden' name='reac_code' id='reac_code' value='"+reac_code+"'>");
	}else
	{
		
	}
	
            _bw.write(_wl_block122Bytes, _wl_block122);

		String final_total_oth = checkForNull(request.getParameter("final_total_oth"));
	


	    String reactionCodeOth="";
		String reactionDateOth="";
		String reactionSeviarityOth="";
		String siteofReactionOth="";
		int temp_varOTH=0;

		ArrayList addReactionOTH=new ArrayList();

		int no_of_rwsOth=1;
			if(!final_total_oth.equals("")){
			StringTokenizer _token_oth = new StringTokenizer(final_total_oth,"!");
			while(_token_oth.hasMoreTokens()){
				no_of_rwsOth++;
				String listReactionOTH=_token_oth.nextToken();
				StringTokenizer finalListRecOth = new StringTokenizer(listReactionOTH,"^");
				while(finalListRecOth.hasMoreTokens()){

					reactionCodeOth = finalListRecOth.nextToken();		
					reactionDateOth = finalListRecOth.nextToken();		
					reactionSeviarityOth = finalListRecOth.nextToken();
					if(reactionSeviarityOth.equals("~")) reactionSeviarityOth = "";
					siteofReactionOth = finalListRecOth.nextToken();
					if(siteofReactionOth.equals("~")) siteofReactionOth = "";

					addReactionOTH.add(reactionCodeOth);
					addReactionOTH.add(reactionDateOth);
					addReactionOTH.add(reactionSeviarityOth);
					addReactionOTH.add(siteofReactionOth);

				
			  }
			}
		}

		
		
	if(!prev_oth_reaction.equals(oth_reaction)) {

		StringTokenizer multi_other_reaction= new StringTokenizer(oth_reaction,"||");

		
		while(multi_other_reaction.hasMoreTokens())
		{
			String other_reaction_token = multi_other_reaction.nextToken();
	

            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(oth_reaction));
            _bw.write(_wl_block125Bytes, _wl_block125);
if(!mode.equals("insert")){
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block127Bytes, _wl_block127);
}
			String tmp_dtOth="";
			String tmp_sevOth="";
			String tmp_sitOth="";

		if(addReactionOTH.size()>0  && addReactionOTH.size() >temp_varOTH){

			

			tmp_dtOth=(String) addReactionOTH.get(temp_varOTH+1);
			tmp_sevOth=(String) addReactionOTH.get(temp_varOTH+2);
			tmp_sitOth=(String) addReactionOTH.get(temp_varOTH+3);
		
		
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(other_reaction_token));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(other_reaction_token));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(tmp_dtOth));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(tmp_sitOth));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(tmp_sevOth));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
			else{
				
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(other_reaction_token));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(other_reaction_token));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(reaction_date1_disply));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block143Bytes, _wl_block143);

			}
				
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(other_reaction_token));
            _bw.write(_wl_block146Bytes, _wl_block146);

				temp_varOTH=temp_varOTH+4;	
				other_reaction_counter++;
		}
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(oth_reaction));
            _bw.write(_wl_block148Bytes, _wl_block148);

		}
			prev_oth_reaction=oth_reaction;
			

	}//close for while
	//} //close for for loop
			}//close for reac_desc_val if
	
	
            _bw.write(_wl_block149Bytes, _wl_block149);
if(mode.equals("") ) {
		/*if(allergen_blank.equals(""))
			String all_disabled ="disabled";*/

            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);
if(!diplay_mandatory){
            _bw.write(_wl_block152Bytes, _wl_block152);
}
            _bw.write(_wl_block153Bytes, _wl_block153);
}else{
					if(mode.equals("insert"))
					{
			
						
			
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(disableField));
            _bw.write(_wl_block156Bytes, _wl_block156);
if(!diplay_mandatory){
            _bw.write(_wl_block157Bytes, _wl_block157);
}
            _bw.write(_wl_block158Bytes, _wl_block158);
/*hidden field added by senthil on 16-08-2011*/
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(max_record));
            _bw.write(_wl_block160Bytes, _wl_block160);
}else{
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(status_r));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(status_r));
            _bw.write(_wl_block164Bytes, _wl_block164);
            _bw.write(_wl_block165Bytes, _wl_block165);
            _bw.write(_wl_block166Bytes, _wl_block166);
}}
            _bw.write(_wl_block167Bytes, _wl_block167);
}

            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(reac_code));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(oth_reaction));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(other_reaction_counter));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(status));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(max_record));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(reactDesc));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(final_value));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(adv_reac_code));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(adding_react_yn));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(adv_event_type_ind_code));
            _bw.write(_wl_block180Bytes, _wl_block180);

     } catch(Exception e) {
	 e.printStackTrace();
          if (stmt != null) stmt.close();
     }
     finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block181Bytes, _wl_block181);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.reactiondesc.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReactionDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SiteOfReaction.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mild.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Moderate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severe.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mild.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Moderate.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severe.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mild.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Moderate.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severe.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.OtherReactions.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.OtherReactions.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mild.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Moderate.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severe.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.OtherReactions.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mild.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Moderate.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severe.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.addreaction.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.addreaction.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.addreaction.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
