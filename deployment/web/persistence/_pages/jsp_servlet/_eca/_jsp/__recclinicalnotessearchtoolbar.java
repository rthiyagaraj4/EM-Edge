package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import org.json.simple.*;
import eOR.*;
import eCA.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotessearchtoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesSearchToolbar.jsp", 1742466010562L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\n--------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName        \t\tDescription\n--------------------------------------------------------------------------------------------------------------\n?           100\t\t\t\t?\t          \t\tcreated\n09/07/2012  IN033511\t\tChowminya G\t\t\tWhen Login Thai and view existing note ?Print? button disappear\n22/02/2013\tIN036821\t\tChowminya G\t\t\tReporting Practitioner name not coming in the CA report\n25/03/2013\tIN038840\t\tNijitha\tS\t\t\tCRF-CA- CHL-CRF-0011/05- Social History Widget->If the Role is modified after sign note we get script error\n08/01/2014\tIN045365\t\tDinesh T\t\t\tClinical Notes Access Rights Author But Without Authorization Facility\n\t\t\t\t\t\t\t\t\t\t\t\tI have setup access level for 1 of the notes as Author but without Authorization Facility.\n06/05/2015\tIN053733\t\tRamesh G\t\t\tWhen a notifiable recorded against a notifiable diagnosis is marked in error, \n\t\t\t\t\t\t\t\t\t\t\t\tthe notification to be de-linked from the parent diagnosis\n18/11/2015\tIN057113\t\tKarthi L\t\t\tML-MMOH-CRF-0335 - IN057113\t\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n08/01/2018\tIN064446\t\tRaja S\t\t\t08/01/2018\t\tRamesh G\t\tGHL-CRF-0469\n22/05/2018\tIN067607\t\tRaja S\t\t\t22/05/2018\t\tRamesh G\t\tML-MMOH-CRF-1130.2\n05/06/2018\tIN67872\t\t\tDinesh T\t\t05/06/2018\tRamesh G\t\tGHL-CRF-0497.1\t\n07/08/2018\tIN063818\t\tRaja S\t\t\t07/08/2018\t\tRamesh G\t\tMMS-DM-CRF-0102\n04/03/2019\tIN066806\t\tRamya Maddena\t\t04/03/2019\t\tRamesh G\t\tAMRI-CRF-0339\n28/02/2025\t  68801\t            Twinkle Shah\t\t28/02/2025\t\t\tML-MMOH-CRF-0579 \n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<title>RecClinicalNotesToolbar</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n<script language=\"javascript\" src=\"../../eCA/js/RecClinicalNotesPart1.js\"></script>\n<script language=\"javascript\" src=\"../../eCA/js/RecClinicalNotesPart2.js\"></script>\n<script language=\"javascript\" src=\"../../eCA/js/RecClinicalNotesPart3.js\"></script>\t\n<script language=\"javascript\" src=\"../../eCA/js/RecClinicalNotesFileUpload.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<center>\n\t<form name=\"RecClinicalNotesSearchToolbarForm\" id=\"RecClinicalNotesSearchToolbarForm\">\n\t<p align=\"left\">\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" height=\"100%\" align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"reject\" id=\"reject\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onClick=\"callMeOnReject()\" >&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"forward\" id=\"forward\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onClick=\"getForwardTo(\'Forward\')\" disabled>&nbsp;\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onClick=\"getForwardTo(\'Forward\')\" >&nbsp;\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"update\" id=\"update\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onClick=\"callMeOnUpdate();\">&nbsp;\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<input type=\"BUTTON\" class=\"BUTTON\" name=\"modify\" id=\"modify\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onClick=\"callMeOnModify();\" disabled>&nbsp;\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\n<input type=\"BUTTON\" class=\"BUTTON\" name=\"modify\" id=\"modify\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onClick=\"callMeOnModify();\">&nbsp;\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"modify\" id=\"modify\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onClick=\"callMeOnModify();\" disabled>&nbsp;\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t <input type=\"BUTTON\" class=\"BUTTON\" name=\"modify\" id=\"modify\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onClick=\"callMeOnModify();\">&nbsp;\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"modify\" id=\"modify\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onClick=\"callMeOnModify();\" disabled>&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onClick=\"callMeOnModify();\">&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"delete\" id=\"delete\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onClick=\"callMeOnDelete();\">&nbsp;\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"review\" id=\"review\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onClick=\"callMeOnReview();\">&nbsp;\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"sign\" id=\"sign\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  onClick=\"callMeOnSign();\">&nbsp;\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n<input type=\"BUTTON\" class=\"BUTTON\" name=\"error\" id=\"error\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onClick=\"callMeOnError()\" disabled>&nbsp;\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onClick=\"callMeOnError()\">&nbsp;\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"printpreview\" id=\"printpreview\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" onClick=\"printNotes()\">&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"print\" id=\"print\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onClick=\"printNotes()\">&nbsp;\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onClick=\"emailText()\" title=\'Click to email the events\' name=\'emailBtn\'>&nbsp;\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"view_error\" id=\"view_error\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" onClick=\"showErrorDocuments()\">&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"printpreview\" id=\"printpreview\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" onClick=\"printNotes()\">&nbsp;\t\t\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\n\t\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"print\" id=\"print\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" onClick=\"printNotes()\">&nbsp;\t\t\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<input type=\"BUTTON\" class=\"BUTTON\" name=\"close\" id=\"close\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" onClick=\"closeWindow()\">&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t</p>\n\t<input type=\"hidden\" name=\"note_type\" id=\"note_type\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"siteName\" id=\"siteName\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\n\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"performed_by_id\" id=\"performed_by_id\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\n\t<input type=\"hidden\" name=\"amendment_type\" id=\"amendment_type\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"privilege_type\" id=\"privilege_type\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"hidden\" name=\"forwarded_clinician_id\" id=\"forwarded_clinician_id\"\tvalue=\"\">\n\t<input type=\"hidden\" name=\"action_comment\" id=\"action_comment\"\t\t\tvalue=\"\">\n\t<input type=\"hidden\" name=\"operation_mode\" id=\"operation_mode\"\t\t\tvalue=\"\">\n\t<input type=\"hidden\" name=\"forward_mode\" id=\"forward_mode\"\t\t\tvalue=\"\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\"\tvalue=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\"hidden\" name=\"med_service\" id=\"med_service\"\tvalue=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\"\tvalue=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\"hidden\" name=\"patient_line\" id=\"patient_line\"\tvalue=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\"\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\"hidden\" name=\"patientName_Local_Lang\" id=\"patientName_Local_Lang\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\"hidden\" name=\"loggedUser\" id=\"loggedUser\"\t\tvalue=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"hidden\" name=\"printDateTime\" id=\"printDateTime\"\t\tvalue=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\"hidden\" name=\"dischargeDateTime\" id=\"dischargeDateTime\"\t\tvalue=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" name=\"authorizedBy\" id=\"authorizedBy\"\tvalue=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\"hidden\" name=\"attending_practitioner\" id=\"attending_practitioner\"\tvalue=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\"hidden\" name=\"admitting_practitioner\" id=\"admitting_practitioner\"\tvalue=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\"hidden\" name=\"lastModifiedBy\" id=\"lastModifiedBy\"\tvalue=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t<input type=\"hidden\" name=\"note_header_desc\" id=\"note_header_desc\"\tvalue=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t<input type=\"hidden\" name=\"event_date_time\" id=\"event_date_time\"\tvalue=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\n\t<input type=\"hidden\" name=\"discharge_summary_text\" id=\"discharge_summary_text\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<input type=\"hidden\" name =\"oledb_con_string\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >\n\t<input type=\"hidden\" name =\"figer_print_auth_yn\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n\n\t<input type=\"hidden\" name =\"window_close\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n\t<input type=\"hidden\" name =\"performed_by_name\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" >\n\t<input type=\"hidden\" name =\"patient_id\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t<input type=\"hidden\" name =\"patient_name\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" >\n\t<input type=\"hidden\" name =\"patient_sex\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\n\t<input type=\"hidden\" name =\"patient_age\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" >\n\t<input type=\"hidden\" name =\"locationDesc\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\n\t<input type=\"hidden\" name =\"doc_linked_note_yn\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" >\n\t<input type=\"hidden\" name =\"sec_count\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n\t<input type=\"hidden\" name =\"patient_class\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" >\n\t<input type=\"hidden\" name =\"location_code\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" >\n\t<input type=\"hidden\" name =\"performed_by_desc\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" >\n\t<input type=\"hidden\" name =\"specialty_name\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n\t<input type=\"hidden\" name =\"speciality_code\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" >\n\t<input type=\"hidden\" name =\"appl_task_id\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\n\t<input type=\"hidden\" name =\"enc_id\" value=\"\" >\n\t<input type=\"hidden\" name =\"forwardToFac\" value=\"\" >\n\t<input type=hidden name=notifiable_code id=notifiable_code value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'><!-- IN053733 -->\n\t<input type=\"hidden\" name=\"l_conf_pin_req_yn\" id=\"l_conf_pin_req_yn\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"> <!-- ML-MMOH-CRF-0335 - IN057113 -->\n\t<input type=\"hidden\" name=\"printPreviewFlag\" id=\"printPreviewFlag\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"> <!-- IN064446-->\n\t<input type=\"hidden\" name=\"myHIXYN\" id=\"myHIXYN\" value=\"N\"/><!--IN067607-->\n\t<input type=\"hidden\" name=\"myHIXSiteFlg\" id=\"myHIXSiteFlg\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"/><!--IN067607-->\n\t<input type=\"hidden\" name=\"myHIXNoteType\" id=\"myHIXNoteType\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"/><!--IN067607-->\n\t<input type=\"hidden\" name=\"isModifyDescYN\" id=\"isModifyDescYN\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"/><!--IN067607-->\n\t</form>\n\t</center>\n\t<!-- <OBJECT ID=\"WebFp\" CLASSID=\"CLSID:CA452A7B-737F-434D-904A-AB06E644C25F\" \tCODEBASE=\"PrintFPCom.CAB#version=1,0,0,0\" VIEWASTEXT></OBJECT> -->\n</body>\n</html>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );
	
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


	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String ca_practitioner_id		=	(String)session.getValue("ca_practitioner_id");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	PreparedStatement	pstmt2	=	null;
	
	ResultSet			rs		=	null, rs1=null,rs2=null;

	String	printDateTime="",			dischargeDateTime="",	authorizedBy="",	event_date_time ="", lastModifiedBy="";
	String	attending_practitioner	=	"",		note_header_desc		=	"";	
	String  admitting_practitioner	=	"";
	String	note_type				=	"",		operations_allowed		=	"";
	String	facility_id				=	"",		accession_num			=	"";
	String	button_name				=	"",		amendment_type			=	"";
	String	privilege_type			=	"",		resp_id					=	"";
	String	performed_by_id			=	"",		function_id				=	"";
	String	encounter_id			=	"",		patient_line			=	"";
	String	facility_name			=	"",		visit_adm_date			=	"";
	String	specialty_name			=	"",		error_docs_exists		=	"";
	String	episode_type			=	"";
	String	patient_name			=	"";
	String	patient_age				=	"";
	String	patient_sex				=	"";
	String	patient_id				=	"";
	String	patientName_Local_Lang	=	null;
	String	loggedUser				=	"";
	String	figer_print_auth_yn		=	"";
	String	query_privilege_type	=	"",		strSql="";
	String	discharge_summary_text="";
	String	performed_by_name 	= "";
	String	locationDesc		= "";
	String	doc_linked_note_yn	= "";
	String	sec_count		= "";
	String	window_close		= "";
	String	oledb_con_string	= "";
	String	sqlSite			= "";
	String	gender			= "";
	String	location_code		= "";
	String	performed_by_desc	= "";
	String	speciality_code		= "";
	String	med_service		= "";
	String	res_encounter_id	= "";
	String	status_display_text	= "";
	String	appl_task_id		= "";
	String	user_privilage_id	= "";
	String	print_privilage		= "";
	String	email_privilage		= "";
	String	note_status		= "";	//--[IN033511]
	String  notifiable_code		= "";		//IN053733
	String dischargedYN	= "Y"; //IN066806
	String  noteGroupYN		= ""; //IN066806
	boolean isModifyDisable 	= false; //IN066806
	JSONObject jsonObj		= new JSONObject(); //IN066806
	/*To include siteName in the header part of the report */
    String orderStatusCodeHdr=""; //68801
	String siteName="";
	
	//ML-MMOH-CRF-0335 - IN057113 - Start
	String conf_pin_req_yn = ""; 
	String bean_id = "Or_ViewOrder" ; 
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;	
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
	//ML-MMOH-CRF-0335 - IN057113 - End
	StringTokenizer		stoken			=	null;
	Properties				jdbc_props	=	null;
	ArrayList				arrFunctions	=	new ArrayList();

	note_type				=	checkForNull(request.getParameter("note_type"));
	facility_id				=	checkForNull(request.getParameter("facility_id"));
	accession_num			=	checkForNull(request.getParameter("accession_num"));
	performed_by_id			=	checkForNull(request.getParameter("performed_by_id"));
	operations_allowed		=	checkForNull(request.getParameter("operations_allowed"));
	amendment_type			=	checkForNull(request.getParameter("amendment_type"));
	function_id				=	checkForNull(request.getParameter("function_id"));
	encounter_id			=	checkForNull(request.getParameter("encounter_id"));
	doc_linked_note_yn		=	checkForNull(request.getParameter("doc_linked_note_yn"));
	sec_count				=	checkForNull(request.getParameter("sec_count"));
	error_docs_exists		=	checkForNull(request.getParameter("error_docs_exists"));
	episode_type			=	checkForNull(request.getParameter("episode_type"));
	patient_id				=	checkForNull(request.getParameter("patient_id"));
	window_close			=	checkForNull(request.getParameter("window_close"));
	performed_by_name		=	checkForNull(request.getParameter("performed_by_name"));
	speciality_code		=	checkForNull(request.getParameter("speciality_code"));
	appl_task_id		=	checkForNull(request.getParameter("appl_task_id"));
	note_status		=	checkForNull(request.getParameter("note_status")); //--[IN033511]
	String patientClass = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
	res_encounter_id = request.getParameter("res_encounter_id") == null ? "0" : request.getParameter("res_encounter_id");
	status_display_text = request.getParameter("status_display_text") == null ? "" : request.getParameter("status_display_text");
	//String status_authorized = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");//Check style fix
	//String status_modify = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");//Checkstyle fix
	notifiable_code	= 	checkForNull(request.getParameter("notifiable_code")); //IN053733
	orderStatusCodeHdr = request.getParameter("orderStatusCodeHdr") == null ? "" : request.getParameter("orderStatusCodeHdr");  //68801
	if(encounter_id == null || encounter_id.equals("") )
		encounter_id = "0";

	if(res_encounter_id == null || res_encounter_id.equals("") )
		res_encounter_id = "0";

	loggedUser = (String) session.getValue("login_user");
	oledb_con_string=(String)session.getValue("oledb_con_string");
	
	//sqlSite = "SELECT site_name FROM SM_SITE_PARAM";
	sqlSite = "SELECT 	site_name FROM 	SM_SITE_PARAM_LANG_VW where language_id = ?";
	//IN064446 changes starts
	boolean isPPSiteSpecific = false;
	String printPreviewFlag ="N";
	//IN064446 changes ends
	//IN067607 changes starts
	boolean myHIXSiteFlag = false;
	String myHIXSiteFlg ="N";
	String myHIXNoteType = "";
	//IN067607 changes ends
	//IN063818 changes starts
	boolean isModifyDescSS = false;
	String isModifyDescYN ="N";
	//IN063818 changes ends
    String isPatinetDichargedYN=""; //68801
	//strSql=" select  (select ia.DISCLIMER_TEXT from ca_disclimer_text ia, ca_note_type ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE and ib.NOTE_TYPE=a.note_type) DIS_SUMM_DISCLAIMER_TXT,null REF_LETTER_DISCLAIMER_TXT, (select SHORT_NAME from am_practitioner where practitioner_id=a.authorized_by_id) Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(select nvl(PATIENT_NAME_LOC_LANG,'')  from MP_PATIENT where PATIENT_ID=a.patient_id) PATIENT_NAME_LOC_LANG,(select practitioner_name from am_practitioner where practitioner_id=a.last_amended_by_id) last_modified_by_name ,(select ib.REPORT_HEADER from ca_note_group ib, ca_note_type ia where ib.note_group=ia.note_group_id and ia.note_type=a.note_type)  note_header_desc from ca_encntr_note a where a.facility_id=? and a.accession_num=? ";
	strSql=" select  (select ia.DISCLIMER_TEXT from CA_DISCLIMER_TEXT_LANG_VW ia, ca_note_type ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE  and ib.NOTE_TYPE=a.note_type and language_id = ?)  DIS_SUMM_DISCLAIMER_TXT,to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, null REF_LETTER_DISCLAIMER_TXT, AM_GET_DESC.AM_PRACTITIONER(A.authorized_by_id,?,'2') Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(select nvl(PATIENT_NAME_LOC_LANG,'') from MP_PATIENT where PATIENT_ID=a.patient_id) PATIENT_NAME_LOC_LANG,AM_GET_DESC.AM_PRACTITIONER(a.last_amended_by_id,?,'1') last_modified_by_name ,performed_by_id, AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,'1') performed_by_name, (select ib.REPORT_HEADER from ca_note_group_lang_vw ib, ca_note_type ia where ib.note_group=ia.note_group_id and ia.note_type=a.note_type and ib.language_id = ? )  note_header_desc,a.patient_id from ca_encntr_note a where 	/* a.facility_id=? and*/ a.accession_num=?";//IN036821
	try
	{
		stoken				=	new java.util.StringTokenizer(operations_allowed,"|");	

		arrFunctions.clear();

		while(stoken.hasMoreTokens())
		{
			button_name	=	(String) stoken.nextToken();
			
			if(!arrFunctions.contains(button_name) )
				arrFunctions.add(button_name);
		}	
	
		con				=	ConnectionManager.getConnection(request);
		facility_id		=	(String)		session.getValue("facility_id");
		jdbc_props		=	(Properties)	session.getValue("jdbc");
		resp_id			=	(String)		session.getValue("responsibility_id");
		
		pstmt2	=	con.prepareStatement(sqlSite);
		pstmt2.setString(1,locale);
		
		rs2		=	pstmt2.executeQuery();

		if(rs2 !=null)
		{
			rs2.next();
			siteName = rs2.getString(1);
		}

		if(rs2 !=null) 
			rs2.close();

		if(pstmt2 !=null) 
			pstmt2.close();

		//IN064446 changes starts
		isPPSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","PRINT_PREVIEW_SIGN_NOTES"); 
		if(isPPSiteSpecific)
			printPreviewFlag="Y";
		//IN064446 changes Ends
		//IN063818 Starts
		ArrayList<String> functionIds = new ArrayList<String>();
		functionIds.add("DIS_MODIFY_AS_UPDATE");
		functionIds.add("DISCHARGE_NOTE_MODIFY_YN"); //IN066806 
		String beanId					= "CAClinicalHistoryBean" ;
		String beanName				= "eCA.CAClinicalHistoryBean";
		CAClinicalHistoryBean bean1	= (CAClinicalHistoryBean)getBeanObject( beanId, beanName , request) ;
		bean1.setSiteSpecific(functionIds,"CA");
		isModifyDescSS = bean1.isSiteSpecific("DIS_MODIFY_AS_UPDATE");
		if(isModifyDescSS)
			isModifyDescYN ="Y";
		//IN063818 End.
		isModifyDisable = bean1.isSiteSpecific("DISCHARGE_NOTE_MODIFY_YN"); //IN066806 
		jsonObj =bean1.getstatusbean(con,patient_id,encounter_id,note_type);//IN066806
		dischargedYN = (String) jsonObj.get("discharged_yn");//IN066806
		noteGroupYN = (String) jsonObj.get("noteGroupYN");//IN066806	
		//IN067607 changes starts
		try
		{
		myHIXSiteFlag = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","SENT_MYHIX"); 
		if(myHIXSiteFlag)
		{
			myHIXSiteFlg="Y";

			String myHIXSql="Select DEFAULT_VALUE MYHIX_NOTE_CODE from XH_STANDARD_CONTROL_SEG where STANDARD_CODE = 'XMLSTD' and SEGMENT_ID in ('DISREGC','ENCREGC') and ELEMENT_ID = 'NOTE_TYPE'";
			pstmt2	=	con.prepareStatement(myHIXSql);
			rs2		=	pstmt2.executeQuery();
			if(rs2 != null)
			{
				while(rs2.next())
				{
					myHIXNoteType = myHIXNoteType+'|'+rs2.getString(1)+'|';
				}
			}	
		}
		}catch(Exception m){
	
			//out.println("Exception@1 : "+m);//COMMON-ICN-0181
			System.err.println("RecClinicalNotesSearchToolbar.jsp,384,message=>"+m.getMessage());
			m.printStackTrace();
		}finally{
			if(rs2 !=null) rs2.close();
			if(pstmt2 !=null) pstmt2.close();
		}
		//IN067607 changes Ends
		
		pstmt	=	con.prepareStatement(strSql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);//IN036821
		//pstmt.setString(5,facility_id);
		pstmt.setString(6,accession_num);
		rs1 = pstmt.executeQuery();

		if(rs1.next())
		{
			patientName_Local_Lang	=	 checkForNull(rs1.getString("PATIENT_NAME_LOC_LANG"));
			printDateTime			= rs1.getString("print_date_time");
			authorizedBy			= checkForNull(rs1.getString("Authorized_by_name"));
			note_header_desc		= rs1.getString("note_header_desc");
			lastModifiedBy			=checkForNull(rs1.getString("LAST_MODIFIED_BY_NAME"));
			discharge_summary_text	= checkForNull(rs1.getString("DIS_SUMM_DISCLAIMER_TXT"));
			event_date_time	= checkForNull(rs1.getString("event_date_time"));
			patient_id= checkForNull(rs1.getString("patient_id"));
			//IN036821 - Start
			if(performed_by_name.equals(""))
				performed_by_name	= checkForNull(rs1.getString("performed_by_name"));	
			//IN036821 - end	
		}	

		if(rs!=null) 
			rs.close();

		if(rs1!=null) 
			rs1.close();

		if(pstmt!=null)	
			pstmt.close();
		if (!encounter_id.equals("0"))
		{	
			//IN045365, starts
			/*if(function_id.equals("")||appl_task_id.equals("PROGRESS_NOTES")){
				query_privilege_type	=	"select privilege_type, get_patient.get_line_detail(?,?,?) patient_line, (select FIGER_PRINT_AUTH_YN from ca_note_param) figer_print_auth_yn from ca_note_type_for_resp where resp_id = ? and note_type = ? ";
			}
			else
			{
			query_privilege_type	=	"select max(privilege_type) privilege_type, get_patient.get_line_detail(?,?,?) patient_line, (select FIGER_PRINT_AUTH_YN from ca_note_param) figer_print_auth_yn from ca_note_type_for_resp where resp_id in (select resp_id from SM_RESP_FOR_USER where APPL_user_id= ? ) and note_type = ? AND privilege_type<=4 GROUP BY get_patient.get_line_detail(?,?,?) ";
			}
			*/
			//IN045365, ends
			query_privilege_type	=	"select privilege_type, get_patient.get_line_detail(?,?,?) patient_line, (select FIGER_PRINT_AUTH_YN from ca_note_param) figer_print_auth_yn from ca_note_type_for_resp where resp_id = ? and note_type = ? ";//IN045365

			pstmt	=	con.prepareStatement(query_privilege_type);

			pstmt.setString	(	1,	facility_id	);
			pstmt.setString	(	2,	encounter_id);
			pstmt.setString	(	3,	locale);
				
			//IN045365, starts
			/*if(function_id.equals("")||appl_task_id.equals("PROGRESS_NOTES"))
			{
				pstmt.setString	(	4,	resp_id		);
				pstmt.setString	(	5,	note_type	);
			}
			else
			{
				pstmt.setString	(	4,	loggedUser );
				pstmt.setString	(	5,	note_type	);
				pstmt.setString	(	6,	facility_id	);
				pstmt.setString	(	7,	encounter_id);
				pstmt.setString	(	8,	locale);
			}*/

			pstmt.setString	(	4,	resp_id		);
			pstmt.setString	(	5,	note_type	);
			//IN045365, ends

			rs		=	pstmt.executeQuery();

			if(rs.next())
			{
				privilege_type	=	rs.getString("privilege_type");
				patient_line	=	rs.getString("patient_line");
				figer_print_auth_yn = rs.getString("figer_print_auth_yn");
			}
			

			if(pstmt!=null)	
				pstmt.close();
			
			if(rs!=null)
				rs.close();

			if(	episode_type.equals("O") )
			{				
				//query_privilege_type	=	"select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,acc_entity_name facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_op_episode_vw.PHYSICIAN_ID) attending_practitioner,DECODE(SEX,'M','Male','F','Female','U','Unknown') gender,get_age(DOB) AGE,(LOCN_NAME || '/' || NVL(ROOM_NUM,'') || ' '|| NVL(BED_NUM,'') )location,PATIENT_NAME from ca_op_episode_vw where facility_id = ? and episode_id = ? ";
				// by rajan on 29/07/2008query_privilege_type	=	"select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(SERVICE_CODE,?,'2')  service_name,AM_GET_DESC.AM_PRACTITIONER(PHYSICIAN_ID,?,'2') attending_practitioner,SEX gender,get_age(DOB) AGE,(OP_GET_DESC.OP_CLINIC(?,LOCN_CODE,?,'1') || '/' || NVL(ROOM_NUM,'') || ' '|| NVL(BED_NUM,'') )location,LOCN_CODE locn_code,PATIENT_NAME,AM_GET_DESC.AM_SPECIALITY(?,?,'2') specialty_name from ca_op_episode_vw where facility_id = ? and episode_id = ?";
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner , ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";
			}
			else
			{	
				//speciality_code
				//query_privilege_type	=	"select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_ip_active_episode_vw.CUR_PHYSICIAN_ID) attending_practitioner,DECODE(SEX,'M','Male','F','Female','U','Unknown') gender,get_age(DOB) AGE ,(WARD_SHORT_DESC || '/' || nvl(CUR_ROOM_NUM,'') || '' || nvl(CUR_BED_NUM,'') ) location,patient_name  from ca_ip_active_episode_vw where facility_id = ? and episode_id = ? ";
				//rajan on 29/072008 query_privilege_type	=	"select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(SERVICE_CODE,?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(CUR_PHYSICIAN_ID,?,'2') attending_practitioner,SEX gender,get_age(DOB) AGE ,(IP_GET_DESC.IP_NURSING_UNIT(?,CUR_WARD_CODE,?,'1') || '/' || nvl(CUR_ROOM_NUM,'') || '' || nvl(CUR_BED_NUM,'') ) location,CUR_WARD_CODE locn_code, patient_name ,AM_GET_DESC.AM_SPECIALITY(?,?,'2') specialty_name from ca_ip_active_episode_vw where facility_id = ? and episode_id = ?";
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner , ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";
			}

			pstmt	=	con.prepareStatement(query_privilege_type);
			pstmt.setString	(	1,	locale	);
			pstmt.setString	(	2,	locale	);
			pstmt.setString	(	3,	locale	);
			pstmt.setString	(	4,	locale	);
			pstmt.setString	(	5,	locale	);			
			pstmt.setString	(	6,	locale	);			
			pstmt.setString	(	7,	locale	);			
			pstmt.setString	(	8,	facility_id	);
			pstmt.setString	(	9,	encounter_id);

			rs		=	pstmt.executeQuery();

			if(rs.next())
			{
				facility_name			=	rs.getString("facility_name");
				visit_adm_date			=	rs.getString("visit_adm_date");
				med_service			=	rs.getString("service_name");
				dischargeDateTime		=	rs.getString("DISCHARGE_DATE_TIME");
				attending_practitioner	=	rs.getString("attending_practitioner");
				admitting_practitioner	=	rs.getString("admitting_practitioner");
				patient_age				=	rs.getString("AGE");
				gender					=	rs.getString("gender");
				locationDesc			=	rs.getString("location");
				location_code			=	rs.getString("locn_code");
				patient_name			=	rs.getString("patient_name");
				specialty_name			=	rs.getString("specialty_name");
				//performed_by_desc			=	rs.getString("performed_by_desc");

				if(gender.equals("M"))
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else 
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}

			if(dischargeDateTime==null)
			{
				dischargeDateTime="";
			}

			if(pstmt!=null)	
				pstmt.close();
			if(rs!=null)
				rs.close();
		}
		else
		{
			//String strPatInfoQuery = "select short_name patient_name,get_age(date_of_birth) patient_age,DECODE(Sex,'M','Male','F','Female','Unknown') Gender from mp_patient_mast where patient_id = ? "; 
			String strPatInfoQuery = "select short_name patient_name,get_age(date_of_birth) patient_age,Sex Gender from mp_patient_mast where patient_id = ?";
			pstmt	=	con.prepareStatement(strPatInfoQuery);

			pstmt.setString	(	1,	patient_id	);

			rs = pstmt.executeQuery();
	
			if(rs.next() )
			{
				patient_name	= rs.getString("patient_name");
				patient_age		= rs.getString("patient_age");
				//patient_sex		= rs.getString("gender");
				gender			= rs.getString("gender");
				
				if(gender.equals("M"))
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else 
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}

			if(pstmt!=null)
				pstmt.close();
			
			if(rs!=null)
				rs.close();
		}

		

		//added by Sridhar Reddy on 23/08/2008 
		//Code to Checking for User Privileges to display Print and Email Buttons for Patient Medical Report. 
		
		String privQuery = "select PRIVILAGE_ID from CA_PMR_USER_PRIVILAGES where NOTE_TYPE_ID = ? and PRACTITIONER_ID = ? ";

		pstmt	=	con.prepareStatement(privQuery);
		pstmt.setString(1,note_type);
		pstmt.setString(2,ca_practitioner_id);		
		rs1 = pstmt.executeQuery();
		
		while(rs1.next())
		{			
			user_privilage_id	= checkForNull(rs1.getString("PRIVILAGE_ID"));
			
			if (user_privilage_id.equals("P"))
			{
				print_privilage = user_privilage_id;
			}
			else if (user_privilage_id.equals("E")) 
			{
				email_privilage = user_privilage_id;
			}		
		}

		if(pstmt!=null)
			pstmt.close();

		if(rs1!=null)
			rs1.close();	

		// End Checking for User Privileges.
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
		System.err.println("RecClinicalNotesSearchToolbar.jsp,384,message=>"+e.getMessage());
		e.printStackTrace();
	}
	finally
	{		
		if(rs2 !=null) 
			rs2.close();

		if(pstmt2 !=null) 
			pstmt2.close();

		if(pstmt!=null)	
			pstmt.close();

		if(rs!=null) 
			rs.close();

		if(rs1!=null) 
			rs1.close();

		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
		
		
		if (encounter_id.equals(res_encounter_id))
		{
			for(int i=0; i<arrFunctions.size(); i++)
			{
				button_name = (String)arrFunctions.get(i);
				
				if( button_name==null ) 
					button_name = "";
				
				//IN67872, starts
				if( button_name.equals("REJECT") && (eCA._ca_license_rights.getKey()).equals("CACLDC") )
				{
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);

				}
				//IN67872, ends
				if( button_name.equals("FORWARD") && (eCA._ca_license_rights.getKey()).equals("CACLDC") )
				{
if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM"))
{ //68801

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{ 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
				}

				if(button_name.equals("UPDATE"))
				{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);

				}

				if(button_name.equals("MODIFY"))
				{
					//IN063818 changes starts
					if(isModifyDescSS){ 
if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM")){ //68801

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{ 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
}}
					else{
					//IN063818 changes ends
						//IN066806 Starts						
						if(isModifyDisable){	
								if(!((dischargedYN.equals("Y")) && (noteGroupYN.equals("Y"))&& (privilege_type.equals("3")))){
								if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM"))
								{//68801
								
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{ 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
						}
						}else{
							if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM"))
							{ //68801
						
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
						}
						//IN066806 ends
					}
            _bw.write(_wl_block27Bytes, _wl_block27);
}

				if(button_name.equals("DELETE"))
				{

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);

				}

				if(button_name.equals("REVIEW"))
				{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.review.label","common_labels")));
            _bw.write(_wl_block31Bytes, _wl_block31);

				}

				if(button_name.equals("SIGN"))
				{

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sign.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);

				}

				if(button_name.equals("ERROR"))
				{
					
					if(!appl_task_id.equals("PAT_HISTORY"))
					{
						//IN038840
if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM")){ //68801

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else{ 

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
		}			}
				}

				if(button_name.equals("PRINT"))
				{							
					if(appl_task_id.equals("PAT_MEDICAL_REPORT"))
					{  
						if (print_privilage.equals("P")) 
						{
							//IN064446 changes starts
							if(isPPSiteSpecific)
							{

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Printpreview.label","ca_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
							}
							//IN064446 changes ends
						}

					    if (email_privilage.equals("E")) 
						{					

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Email.label","ca_labels")));
            _bw.write(_wl_block42Bytes, _wl_block42);
							
						}
					}
					else
					{  
							//IN064446 changes starts
							if(isPPSiteSpecific)
							{

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Printpreview.label","ca_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
							}
							//IN064446 changes ends
					}
				}
				
			}
												
			if(error_docs_exists.equalsIgnoreCase("true") )
			{

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorDocuments.label","ca_labels")));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}
		}
		else if (!(encounter_id.equals(res_encounter_id)) && (note_status.equals("4") || note_status.equals("5"))) //--[IN033511]
		{  
			//IN064446 changes starts
			if(isPPSiteSpecific)
			{

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Printpreview.label","ca_labels")));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block48Bytes, _wl_block48);
			}
			//IN064446 changes ends
		}

		if(!appl_task_id.equals("PROGRESS_NOTES"))
		{

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block50Bytes, _wl_block50);

		}

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(siteName));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(performed_by_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendment_type));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(privilege_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(med_service));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_line));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(patientName_Local_Lang));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(loggedUser));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(printDateTime));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(dischargeDateTime));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(authorizedBy));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(attending_practitioner));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(admitting_practitioner));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(lastModifiedBy));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(note_header_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(event_date_time));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(discharge_summary_text));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(loggedUser));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(oledb_con_string));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(figer_print_auth_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(window_close));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(performed_by_name));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_sex));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(locationDesc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(sec_count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(performed_by_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(specialty_name));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(notifiable_code ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf( conf_pin_req_yn ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(printPreviewFlag));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(myHIXSiteFlg));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(myHIXNoteType));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(isModifyDescYN));
            _bw.write(_wl_block101Bytes, _wl_block101);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
