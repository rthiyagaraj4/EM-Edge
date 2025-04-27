package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotesheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesHeader.jsp", 1739512432692L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="<!--Added common bean IN064566-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n<title>RecClinicalNotesHeader</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script language=\"javascript\" src=\"../../eCA/js/RecClinicalNotesPart1.js\"></script>\n<script language=\"javascript\" src=\"../../eCA/js/RecClinicalNotesPart2.js\"></script>\n<script language=\"javascript\" src=\"../../eCA/js/RecClinicalNotesPart4.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<!-- IN071264 Starts-->\n<script>\nfunction autoSave(auto_save_time){\n\tif(\'N\'==document.getElementById(\"autoSaveCheck\").value){\n\t\tdocument.getElementById(\"autoSaveCheck\").value=\'Y\';\n\t\tdocument.getElementById(\"autoSaveImg\").src=\'../../eCA/images/ToggleSwitchOn.png\';\n\t\tdocument.getElementById(\"timer\").style.display=\'inline-block\';\n\t\tdocument.getElementById(\"timerlable\").style.display=\'inline-block\';\t\t\n\t\tcountdown(auto_save_time);\n\t}else if(\'Y\'==document.getElementById(\"autoSaveCheck\").value){\n\t\tdocument.getElementById(\"autoSaveCheck\").value=\'N\';\n\t\tdocument.getElementById(\"autoSaveImg\").src=\'../../eCA/images/ToggleSwitchOff.png\';\n\t\tdocument.getElementById(\"timer\").style.display=\"none\";\n\t\tdocument.getElementById(\"timerlable\").style.display=\"none\";\n\t}\n}\n</script>\n<!-- IN071264 Starts-->\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"callMeOnLoad()\" class=\'CONTENT\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<center>\n\t<form name=\"RecClinicalNotesHeaderForm\" id=\"RecClinicalNotesHeaderForm\" >\n\t<table border=\"0\" cellpadding = 4 cellspacing=\"0\" width=\"100%\" name=\"detailTable\" id=\"detailTable\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"  width=\"20%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t<td class=\"DATA\" width=\"30%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<input type=\"hidden\" name=\"note_type\" id=\"note_type\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"note_group\" id=\"note_group\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></td>\n\t\t\t\t<td class=\"label\" width=\"20%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td class=\"DATA\" width=\"30%\" colspan=\'2\'>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<input type =\"text\" name =\"serv_disp\" readonly  value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">&nbsp;\n\t\t\t\t\t\t<input type=\"button\" value=\"?\" class=\"button\" \t\tonClick=\"callConditionLookupServ(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" name=\'search_btn_serv\' >\n\t\t\t\t\t\t<input type =\"hidden\" name =\"service_code\" value = \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<input type =\"hidden\" name =\"serv_disp\" readonly  value = ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"service_code\" id=\"service_code\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td class=\"DATA\" width=\"25%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<input type=\"hidden\" name=\"event_date_time\" id=\"event_date_time\"  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></td>\n\t\t\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t<td class=\"DATA\" width=\"25%\" colspan=\'2\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<input type=\"hidden\" name=\"performed_by_id\" id=\"performed_by_id\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<td class=\"DATA\" width=\"25%\"><input type=\"text\" name=\"event_title_desc\" id=\"event_title_desc\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" size=\"60\" maxlength=\"200\" onBlur=\"return makeValidString(this);\">\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t<td class=\"DATA\" width=\"25%\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"event_title_desc\" id=\"event_title_desc\" size=\"40\" maxlength=\"200\" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\"  width=\"25%\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'event_status\' id=\'event_status\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t\t\t<!--<input type=\"hidden\" name=\"event_status\" id=\"event_status\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"> -->\n\t\t\t\t</td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<!-- IN071264 Starts -->\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<td class=\"label\" width=\'25%\'  style=\"display:\" id=\"autosaveontd\" name=\"autosaveontd\">Auto Save</td>\n\t\t\t\t<td class=\"LABEL\" width=\'25%\' valign=\"center\"  style=\"display:\" id=\"autosaveon\" name=\"autosaveon\">\n\t\t\t\t\t<table border=\"0\" cellpadding = 0 cellspacing=\"0\" width=\"100%\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"20%\"><img id=\"autoSaveImg\" src=\"../../eCA/images/ToggleSwitchOff.png\" onClick=\'autoSave(";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =")\'/></td>\n\t\t\t\t\t\t\t<td class=\"LABEL\" width=\"80%\"><font color=\"red\"><div id=\"timerlable\" style=\"display:none\">Time Remaining</div>&nbsp;<div id=\"timer\" style=\"display:none\"> 2:00</div></font></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" id=\"autoSaveCheck\" name=\"autoSaveCheck\" id=\"autoSaveCheck\" value=\"N\"/>\n\t\t\t\t</td>\n\t\t\t\t<td  colspan = 3 ></td>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<!-- IN071264 Ends -->\n\t\t\t\t<td  colspan = 4 width=\'50%\' class =\'button\' align=\"right\">\n\t\t\t\t<input type=button value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" class=button onclick=\"compressHeaderFrames();\" name=\"hideHeaderButton\" id=\"hideHeaderButton\"></td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\n\t\t\t\t\t\t\tconsole.log(parent.content.workAreaFrame);\n\t\t\t\t\t\t\tsetTimeout(\"loadFileUpload();\",50);\t\n\t\t\t\t\t\t\tfunction loadFileUpload()\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.frameSetIdSection.cols=\"100%,0%,0%\";\n\n\t\t\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?note_type=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&facility_id=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&encounter_id=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&patient_id=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&patient_class=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&appl_task_id=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&accession_num=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&called_from=NOTES_HEADER\';\n\n\t\t\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&called_from=NOTES_HEADER\';\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<script>\n\t\t\tconsole.log(parent.content.workAreaFrame);\n\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href=\'../../eCA/jsp/RecClinicalNotesToolbar.jsp?operation_mode=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&doc_linked_note_yn=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&function_id=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\';\n\t\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"LABEL\"  id=\"td_filter_by\" width=\'25%\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&nbsp;";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t<td class =\'fields\' width=\'25%\'>\n\t\t\t\t<select name=\"filter_by\" id=\"filter_by\" onChange = \"javascript:fnDisplaySplty(this);return populateNoteType(this);\"  ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =">\n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t<option value=\"R\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</option>\n\t\t\t\t\t<!-- <option value=\"NT\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</option> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t<option value=\"P\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="<option value=\"N\" selected >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</option>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t</select></td><!-- <img src=\"../../eCommon/images/mandatory.gif\"></img> -->\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\n\n\t\t\t\t<td class =\'LABEL\' width=\'25%\' id=\"td_lbl_splty\" style=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" </td>\n\t\t\t\t<td class=\"fields\"  width=\'25%\' id=\"td_splty\" colspan=\"2\">\n\t\t\t\t<select name=\"speciality_list\" id=\"speciality_list\" onChange = \"javascript:return populateNoteType(document.RecClinicalNotesHeaderForm.filter_by);\"  style=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"><option value=\"\">&nbsp;&nbsp;--------- ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="--------- &nbsp;&nbsp;</option>\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="  >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t</select>\t\t\t\n\t\t\t\t </td>\n\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"LABEL\" name=\"td_note_type\" id=\"td_note_type\"  width=\'25%\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t<td class =\'fields\' width=\'25%\'><select name=\"note_type\" id=\"note_type\" onChange = \"return callNoteSectionRoutine()\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =">\n\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;---------- ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="---------- &nbsp;&nbsp;&nbsp;</option>\n\t\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\"label\" width=\'25%\' >\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"fields\" width=\'25%\'>\n\t\t\t\t\t<select name=\"note_group\" id=\"note_group\" onchange=\"populateNoteTypesForGroup(this,\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\',\'Header\');\" ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =">\n\t\t\t\t\t\t<option value=\"\">----------------";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="-----------------</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="selected ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</option>\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td> </tr>\n\t\t\t\t<tr>\n    <td class=\"LABEL\" width=\'25%\' id=\"td_service_code\">\n        ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n    </td>\n    <td class=\"fields\" width=\'25%\'>\n        <input type=\"text\" name=\"serv_disp\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"  >\n        <input type=\"button\" value=\"?\" class=\"button\" onClick=\"callConditionLookupServ(\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\')\" name=\'search_btn_serv\'>\n        <input type=\"hidden\" name=\"service_code\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n        <img src=\"../../eCommon/images/mandatory.gif\"></img>\n    </td>\n    <td class=\"LABEL\" width=\'25%\' id=\"td_event_date_time\" name=\"td_event_date_time\">\n        ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n    </td>\n    ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n        <td class=\"fields\" width=\'25%\'>\n            <input type=\"text\" name=\"event_date_time\" id=\"event_date_time\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" size=\"16\" maxlength=\"16\">\n    ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" size=\"16\" maxlength=\"16\" \n                onBlur=\'return checkIsValidDate(this,\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\",\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\",\"DMYHM\",\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\")\'>\n    ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n        <button id=\"common_calendar\" type=\"button\" style=\"background: none; border: none; padding: 0; margin: 0; display: inline-block;width: 16px; height: 16px;\" onclick=\'showCalendarValidateForRecTime(\"event_date_time\")\'><img src=\"../../eCommon/images/CommonCalendar.gif\" alt=\"Calendar Icon\" style=\"width: 100%; height: auto;\"></button><img src=\"../../eCommon/images/mandatory.gif\"></img>\n    </td>\n</tr>\n<tr>\t\n\t\t\t\t<td class=\"LABEL\" width=\'25%\' id=\"td_performed_by_id\" name=\"td_performed_by_id\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\t\t\t\t\n\t\t\t\t<td class=\"fields\" width=\'25%\'><input type =\"text\" name =\"performed_by_phy_name\"  onBlur=\"javascript:callConditionLookup();\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="><input type=\"button\" value=\"?\" class=\"button\" onClick=\"callConditionLookup()\" name=\'search_btn\' id=\'search_btn\' ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =">\n\t\t\t\t<input type=\"hidden\"\t\tname=\"performed_by_id\" id=\"performed_by_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img></td>\n\t\t\t\t<td width=\'25%\'></td><td width=\'25%\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\"LABEL\" width=\'25%\' id=\"td_event_title_desc\" name=\"td_event_title_desc\">";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</td>\n\t\t\t\t<td  class=\"fields\" width=\'25%\'><input type=\"text\" name=\"event_title_desc\" id=\"event_title_desc\" value=\"\" size=\"60\" maxlength=\"200\" onBlur=\"return makeValidString(this);\"></td>\n\t\t\t\t<!-- IN071264 Starts -->\n\t\t\t\t<td class=\"LABEL\" width=\'25%\'  style=\"display:none\" id=\"autosaveontd\" name=\"autosaveontd\">Auto Save</td>\n\t\t\t\t<td class=\"LABEL\" width=\'25%\' valign=\"center\"  style=\"display:none\" id=\"autosaveon\" name=\"autosaveon\">\n\t\t\t\t\t<table border=\"0\" cellpadding = 1 cellspacing=\"0\" width=\"100%\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"20%\"><img id=\"autoSaveImg\" src=\"../../eCA/images/ToggleSwitchOff.png\" onClick=\'autoSave(";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =")\'/></td>\n\t\t\t\t\t\t\t<td class=\"LABEL\" width=\"80%\"><font color=\"red\"><div id=\"timerlable\" style=\"display:none\">Time Remaining</div>&nbsp;<div id=\"timer\" style=\"display:none\"> 2:00</div></font></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" id=\"autoSaveCheck\" name=\"autoSaveCheck\" id=\"autoSaveCheck\" value=\"N\"/>\n\t\t\t\t</td>\n\t\t\t\t<!-- IN071264 Ends -->\n\t\t\t\t<td  colspan = 2 width=\'50%\' class =\'button\' align=\"right\">\n\t\t\t\t<input type=button value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" class=button onclick=\"compressHeaderFrames();\" name=\"hideHeaderButton\" id=\"hideHeaderButton\" ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="disabled";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar msg = getMessage(\'DIS_ADV_NOT_EXISTS\',\'CA\');\n\t\t\t\t\t\t\t\talert(msg);\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tmessageFrameReference.location.href = \'../../eCA/jsp/CAError.jsp?err_num=\'+msg;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar msg = getMessage(\'DECEASED_ONLY\',\'CA\');\n\t\t\t\t\t\t\t\talert(msg);\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tmessageFrameReference.location.href = \'../../eCA/jsp/CAError.jsp?err_num=\'+msg;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\talert(getMessage(\"MAX_NOTES_LIMIT\",\"CA\"));\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar sec_count = \"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\";\n\t\t\t\t\t\t\t\tvar doc_linked_note_yn = \"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\";\n\t\t\t\t\t\t\t\tvar NoteTypeflag = ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t if ((NoteTypeflag == true)  && (parseInt(sec_count) > 0))\n\t\t\t\t\t\t\t\t {\t\t   \t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t//console.log(parent.parent.document.getElementById(\"RecClinicalNotesFrame\").contentWindow.document.getElementById(\"RecClinicalNotesSectionFrame\"));\n\t\t\t\t\t\t\t\t\t\t//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="&event_title_desc=\'+encodeURIComponent(\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\",\"UTF-8\")+\'&note_status=";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="&performed_by_pract=\'+encodeURIComponent(\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\",\"UTF-8\")+\'&performed_date=";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="&attending_practitioner=\'+encodeURIComponent(\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\",\"UTF-8\")+\'&speciality_name=\'+encodeURIComponent(\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\",\"UTF-8\")+\'&Sex=";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="&visit_adm_date=";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="&med_service=\'+encodeURIComponent(\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\",\"UTF-8\")+\'&accession_num=";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="&discharge_date=";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="&location_code=";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\';//IN041881\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="&attending_practitioner=";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="&speciality_name=\'+encodeURIComponent(\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\';//IN041881\n\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href=\'../../eCA/jsp/RecClinicalNotesToolbar.jsp?operation_mode=";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\';\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t}else if (doc_linked_note_yn == \"Y\" && parseInt(sec_count) == 0 && NoteTypeflag == true)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.frameSetIdSection.cols=\"100%,0%,0%\";\n\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?note_type=";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="&called_from=NOTES_HEADER\';\n\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="&called_from=NOTES_HEADER\';\n\n\t\t\t\t\t\t\t\t\t/*top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUpload.jsp?note_type=";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\';\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\';*/\n\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t\t<input type=\"hidden\" name=\"prev_sec_hdg_code\" id=\"prev_sec_hdg_code\"\t\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"prev_child_sec_hdg_code\" id=\"prev_child_sec_hdg_code\"\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"multi_sec_hdg_code\" id=\"multi_sec_hdg_code\"\t\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"multi_child_sec_hdg_code\" id=\"multi_child_sec_hdg_code\"\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"prev_image_linked_yn\" id=\"prev_image_linked_yn\"\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"prev_sec_type\" id=\"prev_sec_type\"\t\t\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"prev_sec_result_link_type\" id=\"prev_sec_result_link_type\"\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"avl_image_selected\" id=\"avl_image_selected\"\t\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"addendumTxt\" id=\"addendumTxt\"\t\t\t\t\tvalue=\"\">\t\n\t\t\t\t\t<input type=\"hidden\" name=\"no_of_rows\" id=\"no_of_rows\"\t\t\t\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"serv_facl_spec_yn\" id=\"serv_facl_spec_yn\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"forwarded_clinician_id\" id=\"forwarded_clinician_id\"\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"action_comment\" id=\"action_comment\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"enable_cannedtext\" id=\"enable_cannedtext\"\t\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"performedby_name\" id=\"performedby_name\"\t\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"loggedUser\" id=\"loggedUser\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"autho_doct_name\" id=\"autho_doct_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"modified_by\" id=\"modified_by\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sys_date_time\" id=\"sys_date_time\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"operation_mode\" id=\"operation_mode\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"record_mode\" id=\"record_mode\"\t\t\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"srl_no\" id=\"srl_no\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"amendment_type\" id=\"amendment_type\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"event_class\" id=\"event_class\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"privilege_type\" id=\"privilege_type\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"note_type_desc\" id=\"note_type_desc\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"event_type_caption\" id=\"event_type_caption\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"note_type_security_level\" id=\"note_type_security_level\"\tvalue=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"event_date_caption\" id=\"event_date_caption\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"event_perf_by_caption\" id=\"event_perf_by_caption\"\t\tvalue=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"event_title_caption\" id=\"event_title_caption\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"event_auth_by_caption\" id=\"event_auth_by_caption\"\t\tvalue=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"event_status_caption\" id=\"event_status_caption\"\t\tvalue=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"figer_print_auth_yn\" id=\"figer_print_auth_yn\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"appl_task_id\" id=\"appl_task_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\t\n\t\t\t\t\t<input type=\"hidden\" name=\"med_service\" id=\"med_service\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"service_name\" id=\"service_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"speciality_name\" id=\"speciality_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t\t\t<!-- Added by Deepa on 6/25/2009 at 6:00 PM for IN010888 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"performing_phy_name\" id=\"performing_phy_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"attending_practitioner\" id=\"attending_practitioner\"\t\tvalue=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sel_facility_id\" id=\"sel_facility_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"defa_speciality_code\" id=\"defa_speciality_code\"\t\tvalue=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"days_backdate\" id=\"days_backdate\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"event_date_time_flag\" id=\"event_date_time_flag\"\t\tvalue=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"synchFlag\" id=\"synchFlag\"\t\t\t\t\tvalue= \"0\">\n\t\t\t\t\t<input type=\"hidden\" name=\"sel_note_type\" id=\"sel_note_type\"\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"Sex\" id=\"Sex\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"Dob\" id=\"Dob\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"discharge_date\" id=\"discharge_date\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"selection_type\" id=\"selection_type\"\t\t\t\t\t\tvalue= \"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ql_flag\" id=\"ql_flag\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"medanc_serv_ql\" id=\"medanc_serv_ql\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"serv_name_ql\" id=\"serv_name_ql\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"performed_by_ql\" id=\"performed_by_ql\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"perf_pract_name_ql\" id=\"perf_pract_name_ql\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"transcription_yn\" id=\"transcription_yn\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\"\t\tvalue= \"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"note_group_req\" id=\"note_group_req\"\tvalue= \"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"contr_mod_accession_num\" id=\"contr_mod_accession_num\"\tvalue= \"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"contr_oth_accession_num\" id=\"contr_oth_accession_num\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\"> <!-- IN053733 -->\n\t\t\t\t\t<!-- <input type=\"hidden\" name=\"doc_linked_note_yn\" id=\"doc_linked_note_yn\"\t\t\t\t\t\tvalue= \"\"> --> \n\t\t\t\t\t<input type=\"hidden\" name=\"sec_count\" id=\"sec_count\"\t\t\t\t\t\tvalue= \"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\"> \n\t\t\t\t\t<input type=\"hidden\" name=\"forwardToFac\" id=\"forwardToFac\" value= \"\"> <!--IN038176-->\n\t\t\t\t\t<input type=\"hidden\" name=\"notifiable_code\" id=\"notifiable_code\" value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\"> <!--IN044085-->\n\t\t\t\t\t<input type=\"hidden\" name=\"notifiable_emailYN\" id=\"notifiable_emailYN\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\"> <!--IN044085-->\n\t\t\t\t\t<input type=\"hidden\" name=\"dispResLinkHYMLYN\" id=\"dispResLinkHYMLYN\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\"><!-- IN041284-->\n\t\t\t\t\t<input type=\"hidden\" name=\"noteSplCharValidate\" id=\"noteSplCharValidate\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\"><!-- //IN059571-->\n\t\t\t\t\t<input type=\"hidden\" name=\"p_event_class_widget\" id=\"p_event_class_widget\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\"><!-- IN037701 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"p_notes_view\" id=\"p_notes_view\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\"><!-- IN037701 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'c_note_type\' id=\'c_note_type\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'site_manflg\' id=\'site_manflg\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'><!-- IN064566 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'display\' id=\'display\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'><!-- IN063799 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'myHIXSiteFlg\' id=\'myHIXSiteFlg\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'><!-- IN067607 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'myHIXNoteType\' id=\'myHIXNoteType\' value=\'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'><!-- IN067607 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'copiedFlagYN\' id=\'copiedFlagYN\' value=\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\'><!-- IN068105 -->\n\t\t\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'accession_num_auto\' id=\'accession_num_auto\' value=\'\'><!--IN071264-->\n\t\t\t\t\t<input type=\'hidden\' name=\'auto_save_yn\' id=\'auto_save_yn\' value=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'><!--IN071264-->\n\t\t\t\t\t<input type=\'hidden\' name=\'operation_mode_as\' id=\'operation_mode_as\' value=\'\'><!--IN071264-->\n\t\t\t\t\t<input type=\'hidden\' name=\'p_called_from_widget\' id=\'p_called_from_widget\' value=\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\'><!--IN071264-->\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<table id=\"headerLineTable\" style=\"display:none\" width=\"100%\" border=1 style=\"border-color:#A0522D\" align=\'center\' cellspacing=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'CAHIGHERLEVELCOLOR\' width=\'100%\' align = \'left\'  id=headerTitle>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\'50%\' style=\"background-color:#83AAB4\" align = right class = \'CAHIGHERLEVELCOLOR\'>\n\t\t\t\t\t\t\t<input type=button value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" class=button onclick=\"expandHeaderFrames();\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</form>\n\t\t\t\t</center>\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\t\t\t\t\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"DIAG_NOT_RECORDED\",\"OR\"));\n\t\t\t\t</script>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t<script>\t\n\tif( \'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\' == \"\" ){\n\t\tpopulateNoteType(document.RecClinicalNotesHeaderForm.filter_by);//IN050839\n\t\tcallNoteSectionRoutine();//IN050839\n\t}\n\t</script>\n\n";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n</body>\n</html>\n<!--IN071264 Starts-->\n<script type=\"text/javascript\">\nif(\"Y\"==\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\' && document.RecClinicalNotesHeaderForm.note_type.value!=\'\' ){\n\tdocument.getElementById(\"autosaveontd\").style.display =\"\";\n\tdocument.getElementById(\"autosaveon\").style.display=\"\";\n\t\n}\nvar auto_save_mins;//IN071264\nvar index =0;//IN071264\nvar timeoutHandle;\nfunction countdown(minutes) {\n\t\n    var seconds = 60;\n    if(index==0)//IN071264\n    auto_save_mins = minutes;//IN071264\n    var mins = minutes\n    function tick() {\n    \tindex++;\n    \tif(\"Y\"==document.getElementById(\"autoSaveCheck\").value){\n\t        var counter = document.getElementById(\"timer\");\n\t        var current_minutes = mins-1\n\t        seconds--;\n\t        counter.innerHTML =\n\t        current_minutes.toString() + \":\" + (seconds < 10 ? \"0\" : \"\") + String(seconds);\n\t        if( seconds > 0 ) {\n\t            timeoutHandle=setTimeout(tick, 1000);\n\t        } else {\n\t \n\t            if(mins > 1){\n\t \n\t               // countdown(mins-1);   never reach \"00\" issue solved:Contributed by Victor Streithorst\n\t               setTimeout(function () { countdown(mins - 1); }, 1000);\n\t \t\t\t\n\t            }else{\n\t            \tRecordClinicalNotes(\'\',\'Y\');\n\t            \tcountdown(auto_save_mins);\n\t            }\n\t        }\n\t        \n\t    }\n    }\n    tick();\n}\n</script>\n<!--IN071264 Ends-->\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );
	
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
	private String checkForNull(String inputString, String retValue)
	{
		return (inputString==null)	?	retValue	:	inputString;
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
 
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
25/07/2012		IN034224			Dinesh T	Recording and signing the addendum is not functioning properly
19/09/2012		IN033677			Dinesh T	CRF-Recording and signing the addendum with new free text editor
04/03/2013	IN038176		Dinesh T		Forwarding the notes to other practitioner for signing
08/10/2013	    IN041881		NijithaS		MO-GN-5428
17/12/2013		IN044085		Ramesh G		Bru-HIMS-CRF-024.2 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory� results in a clinical note section template does not display neatly .
02/06/2014	  IN037701		Nijitha											SKR-CRF-0036
24/09/2014	  IN050839		NijithaS										ML-BRU-SCF-1422	
28/11/2014    IN052757		Chowminya										Clinical default from quicklink select - page not loaded
06/05/2015	IN053733		Ramesh G										When a notifiable recorded against a notifiable diagnosis is marked in error, 
																			the notification to be de-linked from the parent diagnosis
13/05/2016		IN059571	Ramesh G										Problem:Lab & Radiology Results are not transferring to CA screen, from yesterday nigh the background job was running.
01/11/2016		IN061988	Vijayakumar K									AAKH-CRF-0088.3 [IN:061988]
27/06/2017	 IN064566		Raja S		27/06/2017		Ramesh G			PMG2017-GHL-CRF-0005
15/02/2018	 IN063799		Prakash C	15/02/2018		Ramesh		ML-MMOH-CRF-0808
22/05/2018	 IN067607		Raja S		22/05/2018		Ramesh G			ML-MMOH-CRF-1130.2
27/07/2018	IN068105		Raja S			27/07/2018	Ramesh G		MMS-DM-CRF-0143
18/03/2020	IN071264		Nijitha S	18/03/2020		Ramesh G			GHL-CRF-0604
27/07/2022	26826			Ramesh G									MMS-DM-CRF-0197
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String practitioner_id		=	(String)session.getValue("ca_practitioner_id");
	String practitioner_name		=	checkForNull((String)		session.getValue("practitioner_name"));
	practitioner_name		=	practitioner_name.replace('\'',' ');
	
	String action_comment = request.getParameter("action_comment") == null ? "" : request.getParameter("action_comment");
	String dispResLinkHYMLYN = request.getParameter("dispResLinkHYMLYN") == null ? "" : request.getParameter("dispResLinkHYMLYN"); //IN041284
	String noteSplCharValidate = request.getParameter("noteSplCharValidate") == null ? "" : request.getParameter("noteSplCharValidate"); //IN059571
	//IN037701 Starts
	String p_event_class_widget = request.getParameter("p_event_class_widget") == null ? "" : request.getParameter("p_event_class_widget");
	String l_notes_view = request.getParameter("p_notes_view") == null ? "" : request.getParameter("p_notes_view");
	//IN037701 Ends
	String display   =request.getParameter("display")==null?"Y":request.getParameter("display"); //IN063799
	String p_called_from_widget   =request.getParameter("p_called_from_widget")==null?"Y":request.getParameter("p_called_from_widget"); //IN071264

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	
	Connection				con					= null;
	
	PreparedStatement		pstmt				= null;
	PreparedStatement		ptPatLine			= null;

	ResultSet				rs					= null;
	ResultSet				stPatLine			= null;

	String	note_type						=	"",		note_type_desc			=	"";
	String	service_code					=	"",		service_desc			=	"";
	String	performed_by_id					=	"",		performed_by_name		=	"";
	String	episode_type					=	"",		resp_id					=	"";
	String	patient_id						=	"",		categoryId				=	"";
	String	encounter_id					=	"",		visit_adm_date			=	"";
	String	sys_date_time					=	"",		appl_task_id			=	"";
	String	operation_mode					=	"",		facility_id				=	"";
	String auto_save_yn="";//IN071264
	String auto_save_time="";//IN071264
	String	patient_class					=	"",		function_id				=	"";
	String	accession_num					=	"",		privilege_type			=	"";
	String	event_type_caption				=	"",		event_class				=	"";
	String	security_level					=	"",		event_date_caption		=	"";
	String	event_date_time					=	"",		event_perf_by_caption	=	"";
	String	event_title_caption				=	"",		event_title_desc		=	"";
	String	event_auth_by_caption			=	"",		amendment_type			=	"";
	String	event_status_caption			=	"",		event_status			=	"";
	String	serv_facl_spec_yn				=	"",		figer_print_auth_yn		=   "";
	String	p_note_type						=	"",		p_date_time				=	"";
	String	autho_doct_name					=	"",		strModifiedBy			=	"";
	String	speciality_code					=	"",		qry_params				=	"";
	String  strDetailsQry					=	"",		facility_name			=	"";
	String  attending_practitioner			=	"",		disflag					=	"disabled";
	String	days_backdate					=	"",		speciality_name			=	"";
	String	event_status_code				=	""; 
	String  attending_practitioner_temp			= "";//IN041881
	String	Sex				=	"",quicklinkDate="",parameterDate="";
	String notifiable_code		=""; //IN053733
	int temp=0; 
	String	Dob				=	""; 
	String	module_id				=	""; 
	String	discharge_date_time				=	""; 
	String	location_code				=	""; 
	String	service_name				=	""; 
	String	speciality_code1				=	""; 
	String splty_code = "";
	String p_splty_code = "";
	String splty_code_desc = "";
	String splQuery = "";
	String disableFilterBy = "";
	String note_group_id = "";
	String note_group_disable = "";
	String note_status = "";
	String sec_count = "";
	String doc_linked_note_yn = "";
	String no_of_rec_per_enc			=	"";
	String countQuerySec			=	"";
	String query_section_details			=	"";
	String query_section_details_serv			=	"";
	String msgfrom			=	"";
	String called_from			=	"";
	String contr_mod_accession_num			=	"";
	String contr_oth_accession_num  = ""; //IN053733
	String performedId						=	"";
	boolean NoteTypeflag			=	false;
	String srl_no	= "";  //[IN033677]
	int record_cnt_for_enc = 0;
	
	String		role_based_access_yn	=	"",	pre_cond_for_rec 			=	"";
	boolean error_flag = false;
	boolean search_screen_activated = false;
	int cntNote = 0;
	int count=1;
	int count1=1;
	int count2=1;
	StringBuffer sqlQuery = new StringBuffer();

	String sec_count_upd ="";
	String doc_linked_note_yn_upd ="";

	// 0064 

		PreparedStatement stmtsql = null;
		
		String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
		String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");

		String sqlFilter = "";
		String column_id = "",	column_desc = "",	value_type = "",	actual_value = "";
		String date_time_rel_id = "",	date_time_rel_val = "",	date_time_rel_unit = "",	relative_value = "";
		String final_value = "";
		String field_desc = "";
		//String sel = "";
		//String iSel = "", dSel = "", oSel = "", Esel = "", Xsel = "";
		HashMap map = new HashMap();		
		String default_sql = "";
		StringBuffer default_query = new StringBuffer();
		int Existance_Count = 0;

		String filter_by_ql="",speciality_ql="",note_type_ql="",medanc_serv_ql="",performed_by_ql="";

		String date_ind = "", date_val = "", date_unit = "", date_ref = "";
		StringTokenizer strToken = null;

		String  filter_by_sel="";
		String  speciality_disp="";
		StringBuffer spl_ql_qry =new StringBuffer();

		String filter_by_ql_tmp="P";
		String ql_flag="N";
		String serv_name_ql="",perf_pract_name_ql="";

		// 0064 ends
	
		String dflt_transcription_yn ="N";
		String transcription_yn ="N";
		String sel_filterBy ="";
		String note_group_req ="";
		boolean custSpecificFlg =false;//IN064566
		String siteSpecFlag="N"; //IN064566
		boolean myHIXSiteFlag =false;//IN067607
		String myHIXSiteFlg="N";//IN067607
		String myHIXNoteType = "";//IN067607
		boolean copiedFlag = false;//IN068105
		String copiedFlagYN = "N";//IN068105

		StringBuffer	query_header_details	=	new StringBuffer();	
		String loggedUser	= (String) session.getValue("login_user");

		try
		{
			facility_id				=	(String)session.getValue("facility_id");
			resp_id					=	(String)session.getValue("responsibility_id");
			
			operation_mode			=	checkForNull(request.getParameter("operation_mode"));
			function_id				=	checkForNull(request.getParameter("function_id"));
			amendment_type			=	checkForNull(request.getParameter("amendment_type"));
			episode_type			=	checkForNull(request.getParameter("episode_type"));
			patient_id				=	checkForNull(request.getParameter("patient_id"));
			encounter_id			=	checkForNull(request.getParameter("encounter_id"),"0");
			visit_adm_date			=	checkForNull(request.getParameter("visit_adm_date"));
			patient_class			=	checkForNull(request.getParameter("patient_class"),"XT");
			event_class				=	checkForNull(request.getParameter("event_class"));
			categoryId				=   checkForNull(request.getParameter("categ_id"));
			note_type				=	checkForNull(request.getParameter("note_type")); 
			appl_task_id			=	checkForNull(request.getParameter("appl_task_id"));
			called_from			=	checkForNull(request.getParameter("called_from"));
			note_group_req			=	checkForNull(request.getParameter("note_group"));
			srl_no					=	checkForNull(request.getParameter("srl_no"));
			contr_mod_accession_num	=	checkForNull(request.getParameter("contr_mod_accession_num"));
			contr_oth_accession_num	=	checkForNull(request.getParameter("contr_oth_accession_num"));
			notifiable_code  =	request.getParameter("notifiable_code")==null?"":(String)request.getParameter("notifiable_code"); //IN044085
			String notifiable_emailYN  =	request.getParameter("notifiable_emailYN")==null?"N":(String)request.getParameter("notifiable_emailYN"); //IN044085
			
			
			performedId				=	request.getParameter("performedId")==null?"":(String)request.getParameter("performedId");
			performed_by_ql	=	request.getParameter("performed_by_ql")==null?"":(String)request.getParameter("performed_by_ql");
			
			
			con				=	ConnectionManager.getConnection(request);
		
			//26826 Start.			
			String or_bean_id 						= "@orderentrybean"+patient_id+encounter_id;
			String or_bean_name 					= "eOR.OrderEntryBean";
			OrderEntryBean bean					= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
			bean.setLanguageId(locale);			
			String  dxChkBfrPlaceOrderYN=bean.allowedNewOrders(con,patient_id,encounter_id,patient_class,facility_id);
			if("Y".equals(dxChkBfrPlaceOrderYN)){
			//26826 End.
			
				//IN064566 starts
				try
				{
					custSpecificFlg = CommonBean.isSiteSpecific(con, "CA","MANDATORY_CHECK_ALERT");
					if(custSpecificFlg)
						siteSpecFlag ="Y";
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				//IN064566 Ends
				//IN041284 Start.
				//IN059571 Star.
				//String sql = "select DISP_RES_LINK_HTML_YN from CA_NOTE_PARAM";
				//String sql = "select DISP_RES_LINK_HTML_YN,NOTE_SPL_CHAR_VALD from CA_NOTE_PARAM";//IN071264
				
				String sql = "select DISP_RES_LINK_HTML_YN,NOTE_SPL_CHAR_VALD, AUTO_SAVE_YN,AUTO_SAVE_TIME from CA_NOTE_PARAM";//IN071264
				//IN059571 End.
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()){
					dispResLinkHYMLYN = rs.getString(1) == null ? "N" : (String) rs.getString(1);
					noteSplCharValidate = rs.getString(2) == null ? "N" : (String) rs.getString(2); //IN059571
					auto_save_yn = rs.getString(3) == null ? "N" : (String) rs.getString(3); //IN071264 

					auto_save_time = rs.getString(4) == null ? "N" : (String) rs.getString(4); //IN071264
					
				}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				//IN041284 End.
				qry_params		= "select nvl(FIGER_PRINT_AUTH_YN, 'N') FIGER_PRINT_AUTH_YN,days_backdate from ca_note_param";
				pstmt = con.prepareStatement(qry_params);
				
				rs = pstmt.executeQuery();

				if(rs.next())
				{
					figer_print_auth_yn			=   rs.getString("figer_print_auth_yn");
					days_backdate				=	rs.getString("days_backdate");
				}
				sys_date_time	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
				
				if(rs!=null) rs.close();					   
				if(pstmt!=null) pstmt.close();
			
				
				
				//IN068105 start
				copiedFlag = CommonBean.isSiteSpecific(con, "CA","COPIED_NOTE_INFO");
				if(copiedFlag)
					copiedFlagYN="Y";
				//IN068105 ends		
			//IN067607 starts
				try
				{
					if(function_id.equals("DISCHARGE_SUMMARY")){
						myHIXSiteFlag = CommonBean.isSiteSpecific(con, "CA","SENT_MYHIX");
						if(myHIXSiteFlag){
							myHIXSiteFlg ="Y";

							String myHIXSql="Select DEFAULT_VALUE MYHIX_NOTE_CODE from XH_STANDARD_CONTROL_SEG where STANDARD_CODE = 'XMLSTD' and SEGMENT_ID in ('DISREGC','ENCREGC') and ELEMENT_ID = 'NOTE_TYPE'";
							pstmt	=	con.prepareStatement(myHIXSql);
							rs		=	pstmt.executeQuery();
							if(rs != null)
							{
								while(rs.next())
								{
									myHIXNoteType = myHIXNoteType+'|'+rs.getString(1)+'|';
								}
							}	
						}
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally{
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				}
			//IN067607 Ends
			
			if (appl_task_id.equals("PAT_MEDICAL_REPORT")||function_id.equals("TASK_LIST"))
			{
				disableFilterBy = "disabled";
			}else{
				disableFilterBy="";
			}
			if(function_id.equals("TASK_LIST"))
			{
				sel_filterBy = "selected";
			}
			else
			{
				sel_filterBy = "";	
			}
			
			//appl_task_id="PAT_MEDICAL_REPORT";
			autho_doct_name			=	checkForNull(request.getParameter("authority"));
			strModifiedBy			=	checkForNull(request.getParameter("modified_by"));
			Sex			=	checkForNull(request.getParameter("Sex"));
			Dob			=	checkForNull(request.getParameter("Dob"));
			module_id			=	checkForNull(request.getParameter("module_id"));
			location_code			=	checkForNull(request.getParameter("location_code"));
			speciality_name			=	checkForNull(request.getParameter("speciality_name"));
			speciality_code1			=	checkForNull(request.getParameter("speciality_code"));


			if(encounter_id == null || encounter_id.equals("") )
			{
				encounter_id = "0";
				patient_class = "XT";
			}
			
			if( !operation_mode.equals("Update") && !operation_mode.equals("ModifySection") && !operation_mode.equals("ModifyAddendum"))
			{
					if(function_id.equals("SPCL_NOTE")){
						p_note_type		=	request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
						//accession_num	=	checkForNull(request.getParameter("accession_num"));
					}else{
						p_note_type		=	request.getParameter("p_note_type") == null ? "" : request.getParameter("p_note_type");	
					}
			}
			
			//crf 0064 starts here
			
			if(!function_id.equals("SPCL_NOTE") && !function_id.equals("TASK_LIST")){
				if(ql_ref.equals("") && !default_yn.equals("N"))
				{
					//default_sql = "select 1 Existance_Count from SM_QUICK_LINK_FOR_USER where APPL_USER_ID = ? and DEFAULT_YN = 'Y' and OPTION_ID=? and rownum=1";
					//default_sql = "SELECT 1 existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.default_yn = 'Y' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y' AND ROWNUM = 1";
					default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";//changed for regression issue DineshT 2009-12-29


					stmtsql = con.prepareStatement(default_sql);
				
					stmtsql.setString(1,loggedUser);
					stmtsql.setString(2,resp_id);
					stmtsql.setString(3,appl_task_id);
					stmtsql.setString(4,locale);
					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");
					}
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();

					default_query.append("select A.QUICK_LINK_REF from ");
					if(Existance_Count>0)//changed for regression issue DineshT 2009-12-29
						default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
					else
						default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
					default_query.append(" and LINK_TYPE = 'F' and DEFAULT_YN = 'Y' and OPTION_ID=? ");
					
					stmtsql = con.prepareStatement(default_query.toString());
					if(Existance_Count >0)//changed for regression issue DineshT 2009-12-29
						stmtsql.setString(1,loggedUser);
					else
						stmtsql.setString(1,resp_id);

						stmtsql.setString(2,appl_task_id);

					rs = stmtsql.executeQuery();

					if(rs.next())
					{
						ql_ref = rs.getString(1) == null ? "" : rs.getString(1);
					}

					if(stmtsql != null) stmtsql.close();
					if(rs != null) rs.close();
				}
			}
			
			
			if(!ql_ref.equals(""))
			{
				sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID AND OPTION_ID=?) COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,appl_task_id);
				stmtsql.setString(2,ql_ref);
				rs = stmtsql.executeQuery();

				while(rs.next())
				{
					column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
					column_desc = rs.getString("COLUMN_DESC") == null ? "" : rs.getString("COLUMN_DESC");
					value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
					actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
					date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
					date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
					date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
					relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");

					if(value_type.equals("A"))
						final_value = actual_value;
					else
					{
						if(column_id.equals("DATE_TIME"))
						{
							if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
							{
								final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
							}
							else
							{
								final_value = "";
							}
						}
						else
							final_value = relative_value;
					}

					map.put(column_id,final_value);

				}
				if(stmtsql != null) stmtsql.close();
				if(rs != null) rs.close();
	/*		}

			if(!ql_ref.equals(""))
			{*/

				field_desc = (String) map.get("FILTER_BY") == null ? "" : (String) map.get("FILTER_BY");
				if(!field_desc.equals("")){
					filter_by_ql = field_desc;
					filter_by_ql_tmp=filter_by_ql;
				}

				field_desc = (String) map.get("SPECIALITY") == null ? "" : (String) map.get("SPECIALITY");
				if(!field_desc.equals(""))
					speciality_ql = field_desc;
				if(speciality_ql.equals("CURR_PAT_SPLTY_CODE"))
				{
					speciality_ql=speciality_code1;
				}

				field_desc = (String) map.get("NOTE_TYPE") == null ? "" : (String) map.get("NOTE_TYPE");
				if(!field_desc.equals(""))
					note_type_ql = field_desc;

				field_desc = (String) map.get("MEDANC_SERV") == null ? "" : (String) map.get("MEDANC_SERV");
				if(!field_desc.equals(""))
					medanc_serv_ql = field_desc;

				field_desc = (String) map.get("PERFORMED_BY") == null ? "" : (String) map.get("PERFORMED_BY");
				if(!field_desc.equals(""))
					performed_by_ql = field_desc;
				
				if(performed_by_ql.equals("LOGGED_IN_PRACT"))
				{
					performed_by_ql=practitioner_id;
				}

				field_desc = (String) map.get("DATE_TIME") == null ? "" : (String) map.get("DATE_TIME");

				
				

				String currDate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
				int noOfdays = 0;
				if(!field_desc.equals(""))
				{
					strToken = new StringTokenizer(field_desc,"|");
					if(strToken.hasMoreTokens())
					{
						date_ind = strToken.nextToken();
						date_val = strToken.nextToken();
						date_unit = strToken.nextToken();
						date_ref = strToken.nextToken();
					}
					noOfdays = Integer.parseInt(date_val);
					/*if(noOfdays<=Integer.parseInt(days_backdate)){
					if(date_ind.equals("B"))
						sys_date_time = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
					//else if(date_ind.equals("A"))
						//sys_date_time = //com.ehis.util.DateUtils.plusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
					}*/			
					temp=Integer.parseInt(days_backdate);
					parameterDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,temp,"d");
					quicklinkDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);					
					if(com.ehis.util.DateUtils.isAfter(quicklinkDate,parameterDate, "DMYHM", locale))
					{					
					if(date_ind.equals("B"))
						{
						sys_date_time =quicklinkDate ;
						}
					}			
				}			
				
				if(!filter_by_ql.equals(""))
				{
					
					if (filter_by_ql.equals("R")){		

							//IN061988 starts
							//spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");	  
							if("PH_NOTES".equals(appl_task_id))
							{
								spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resp_id = ?  and a.note_type = c.note_type AND a.note_type = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");	  	
							}
							else
							{
								spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");	  	
							}
							//IN061988 ends
					   
					   }else if (filter_by_ql.equals("P") ){			
						   
						   //IN061988 starts
						  //spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  if("PH_NOTES".equals(appl_task_id))
						  {
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resource_type=? and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and a.note_type_id = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  }
						  else
						  {
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  }
						  //IN061988 ends
					   }
					   else if (filter_by_ql.equals("S")){	
						   
						   if(speciality_ql.equals("")){
						   
									String spltySql = "SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?";
									
									stmtsql = con.prepareStatement(spltySql.toString());	
									stmtsql.setString(1,practitioner_id);
									rs = stmtsql.executeQuery();
									if(rs.next()){
										speciality_ql = rs.getString("PRIMARY_SPECIALITY_CODE");
									
									}

									if(rs == null) rs.close();
									if(stmtsql == null) stmtsql.close();
						   
						   }
									
						  //IN061988 starts
						  //spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? ");
						  if("PH_NOTES".equals(appl_task_id))
						  {
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resource_type=? ");
						  }
						  else
						  {
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? ");
						  }
						  //IN061988 ends
						  
						  if (!(speciality_ql.equals("")))
							  spl_ql_qry.append(" and a.RESOURCE_CODE = ? ");
						  //else
							  spl_ql_qry.append(" and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)  ");
						  //IN061988 starts
						  //spl_ql_qry.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  if("PH_NOTES".equals(appl_task_id))
						  {
							spl_ql_qry.append(" and a.note_type_id = c.note_type and a.note_type_id = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  }
						  else
						  {
							spl_ql_qry.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						  }
						  //IN061988 ends
						 
					   }					 

					  
						 if(!note_type_ql.equals(""))
								spl_ql_qry.append(" 	and c.note_type = ? ");
						 //else //IN052757
								spl_ql_qry.append(" 	AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");						
					   
				
					
					   stmtsql = con.prepareStatement(spl_ql_qry.toString());				   

						if (filter_by_ql.equals("R")) 
						{
							stmtsql.setString(1,resp_id);
							stmtsql.setString(2,locale);
							stmtsql.setString(3,patient_class);//
							if(!note_type_ql.equals("")){
								stmtsql.setString(4,note_type_ql);
								stmtsql.setString(5,appl_task_id);
							}else{
								stmtsql.setString(4,appl_task_id);
							}

						}
						 else if (filter_by_ql.equals("P"))
						{
							stmtsql.setString(1,"P");
							stmtsql.setString(2,practitioner_id);
							stmtsql.setString(3,locale);
							stmtsql.setString(4,patient_class);
							stmtsql.setString(5,resp_id);
							if(!note_type_ql.equals("")){
								stmtsql.setString(6,note_type_ql);
								stmtsql.setString(7,appl_task_id);
							}else{
								stmtsql.setString(6,appl_task_id);
							}
								

						}									
						 else if (filter_by_ql.equals("S"))
						 {
							stmtsql.setString(1,"S");
						   if (!speciality_ql.equals(""))
						   {
							stmtsql.setString(2,speciality_ql);
							stmtsql.setString(3,practitioner_id);
							stmtsql.setString(4,practitioner_id);
							stmtsql.setString(5,locale);
							stmtsql.setString(6,patient_class);
							stmtsql.setString(7,resp_id);
							if(!note_type_ql.equals("")){
								stmtsql.setString(8,note_type_ql);
								stmtsql.setString(9,appl_task_id);
							}else{
								stmtsql.setString(8,appl_task_id);
							}
						   }
						   else
						   {
							stmtsql.setString(2,practitioner_id);
							stmtsql.setString(3,practitioner_id);
							stmtsql.setString(4,locale);
							stmtsql.setString(5,patient_class);
							stmtsql.setString(6,resp_id);
							if(!note_type_ql.equals("")){
								stmtsql.setString(7,note_type_ql);
								stmtsql.setString(8,appl_task_id);
						   }else{
								stmtsql.setString(7,appl_task_id);							
						   }
						   }
						}

					
					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");					
					}else{
						Existance_Count = 0;
					}
					
					if(Existance_Count==1 && !ql_ref.equals(""))
					{
						ql_flag="Y";
					}
					else
					{
						filter_by_ql="";
						speciality_ql="";
						note_type_ql="";
						medanc_serv_ql="";
						performed_by_ql="";
						filter_by_ql_tmp="P";
					}
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();

					
				
				}
				else
				{				
					//IN061988 starts
					//spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type='P' and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
					if("PH_NOTES".equals(appl_task_id))
					{
						spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d  where a.resource_type='P' and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and a.note_type_id = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
					}
					else
					{
						spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type='P' and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
					}
					//IN061988 ends
					if(!note_type_ql.equals(""))
						spl_ql_qry.append(" and c.note_type = ? ");
					else
						spl_ql_qry.append(" AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");

						 stmtsql = con.prepareStatement(spl_ql_qry.toString());
						 
						stmtsql.setString(1,practitioner_id);
						stmtsql.setString(2,locale);
						stmtsql.setString(3,patient_class);
						stmtsql.setString(4,resp_id);
					if(!note_type_ql.equals(""))
						stmtsql.setString(5,note_type_ql);
					else
						stmtsql.setString(5,appl_task_id);

					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");
					}

					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();

					if(Existance_Count !=1)
					{				
						spl_ql_qry.delete(0,spl_ql_qry.length());
						//IN061988 starts
						//spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
						if("PH_NOTES".equals(appl_task_id))
						{
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resp_id = ?  and a.note_type = c.note_type AND a.note_type = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
						}
						else
						{
							spl_ql_qry.append("Select 1 Existance_Count from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
						}
						//IN061988 ends

						 if(!note_type_ql.equals(""))
								spl_ql_qry.append(" 	and c.note_type = ? ");
						 else
								spl_ql_qry.append(" 	AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");

							stmtsql = con.prepareStatement(spl_ql_qry.toString());
							stmtsql.setString(1,resp_id);
							stmtsql.setString(2,locale);
							stmtsql.setString(3,patient_class);//
						if(!note_type_ql.equals(""))
							stmtsql.setString(4,note_type_ql);
						else
							stmtsql.setString(4,appl_task_id);//

						rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");				
					}
					


				}

				if(Existance_Count==1 && !ql_ref.equals(""))
					{
						ql_flag="Y";
					}
					else
					{
						filter_by_ql="";
						speciality_ql="";
						note_type_ql="";
						medanc_serv_ql="";
						performed_by_ql="";
						filter_by_ql_tmp="";
					}
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();
			}			
				
				if(ql_flag.equals("Y"))
					{
					
						
						String serv_ql_qry= "select AM_GET_DESC.AM_SERVICE(nvl(?,''),?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(nvl(?,''),?,1) performed_by_name from dual";
						stmtsql = con.prepareStatement(serv_ql_qry);
						stmtsql.setString(1,medanc_serv_ql);
						stmtsql.setString(2,locale);
						stmtsql.setString(3,performed_by_ql);
						stmtsql.setString(4,locale);

						rs = stmtsql.executeQuery();
						if(rs.next())
						{
							serv_name_ql = rs.getString("service_name")==null?"":rs.getString("service_name");
							perf_pract_name_ql = rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");					
							
						}

						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();

						countQuerySec = "select count(*) count  from ca_note_section  where note_type = ? ";
						stmtsql = con.prepareStatement(countQuerySec);
						stmtsql.setString(1,note_type_ql);

						rs = stmtsql.executeQuery();
						
						if(rs.next())
						{
							sec_count = rs.getString("count");
							
						}
						
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();


						query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";
						stmtsql		=	con.prepareStatement(query_section_details);					
										
						stmtsql.setString(1, resp_id);
						stmtsql.setString(2, note_type_ql);
						stmtsql.setString(3, locale);
						rs	=	stmtsql.executeQuery();

						if(rs.next())
						{
							event_class					=	checkForNull( rs.getString("event_class") );
							serv_facl_spec_yn			=	checkForNull( rs.getString("serv_facl_spec_yn") );
							privilege_type				=	checkForNull( rs.getString("privilege_type") );
							note_type_desc				=	checkForNull( rs.getString("note_type_desc") );
							event_type_caption			=	checkForNull( rs.getString("event_type_caption") );
							security_level	=	checkForNull( rs.getString("security_level") );
							event_date_caption			=	checkForNull( rs.getString("event_date_caption") );
							event_perf_by_caption		=	checkForNull( rs.getString("event_perf_by_caption") );
							event_title_caption			=	checkForNull( rs.getString("event_title_caption") );
							event_title_desc			=	checkForNull( rs.getString("event_title_caption") );
							event_auth_by_caption		=	checkForNull( rs.getString("event_auth_by_caption") );
							event_status_caption		=	checkForNull( rs.getString("event_status_caption") );
							note_group_id				=	checkForNull( rs.getString("note_group_id") );
							//sys_date_time				=	checkForNull( rs.getString("sys_date_time") );
							doc_linked_note_yn			=	checkForNull( rs.getString("DOC_LINKED_NOTE_YN") );

							//sys_date_time				=	com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHM","en",locale);
						//	sys_date_time				=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
							
						}
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
		
						
						if(!privilege_type.equals("1") && !note_type_ql.equals(""))
						{
							performed_by_ql  =  practitioner_id;
							perf_pract_name_ql = practitioner_name;
							
							disflag  = "disabled";
						}else{
								disflag  = "";
						}
						
						String note_group_query2 ="select note_group_id from ca_note_type where note_type = ?";
						pstmt		=	con.prepareStatement(note_group_query2);
						pstmt.setString(1,note_type_ql);
						ResultSet rs1			=	pstmt.executeQuery();
						if(rs1.next()){
							note_group_id = rs1.getString("note_group_id");						
						}
						if(rs1 != null)rs1.close();
						if(pstmt != null)pstmt.close();

						String query_note_group_props = "select NO_OF_REC_PER_ENC,ROLE_BASED_ACCESS_YN,PRE_COND_FOR_REC from ca_note_group where NOTE_GROUP=?";

					pstmt = con.prepareStatement(query_note_group_props);
					pstmt.setString(1, note_group_id);
					rs = pstmt.executeQuery();
					
					if(rs.next())
					{
						no_of_rec_per_enc		= checkForNull(rs.getString("NO_OF_REC_PER_ENC")); 
						role_based_access_yn	= checkForNull(rs.getString("ROLE_BASED_ACCESS_YN")); 
						role_based_access_yn=role_based_access_yn;
						pre_cond_for_rec			= checkForNull(rs.getString("PRE_COND_FOR_REC")); 
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
					if(pre_cond_for_rec.equals("D"))
					{
						if(patient_class.equals("IP") || patient_class.equals("DC"))
						{
							String query_ip_dis_advice =	 "select 1 from ip_discharge_advice where facility_id =? and  encounter_id=? and DIS_ADV_STATUS in ('0','1')";
							pstmt = con.prepareStatement(query_ip_dis_advice);
							pstmt.setString(1, facility_id);
							pstmt.setString(2, encounter_id);
							rs = pstmt.executeQuery();						
							if(!rs.next())
							{
								error_flag = true;
								msgfrom = "DIS_ADV_NOT_EXISTS";
								p_note_type = "";
								note_type_ql="";
								note_group_id="";
								performed_by_ql  =  "";
								perf_pract_name_ql = "";
								disflag  = "";
								filter_by_ql="P";
								speciality_ql="";							
								medanc_serv_ql="";								
								filter_by_ql_tmp="P";								
								serv_name_ql = "";		
							}
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
						}
					}
					else if(pre_cond_for_rec.equals("E"))
					{
						
						String install_yn = "";
						String query_install_yn = "SELECT  INSTALL_YN     FROM SM_MODULE  WHERE MODULE_ID='AE'";
						pstmt = con.prepareStatement(query_install_yn);
						rs = pstmt.executeQuery();
						if(rs.next())
							install_yn = checkForNull(rs.getString("INSTALL_YN"));						
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();

						String query_chk_deceased = "";
						if(install_yn.equals("Y"))
							query_chk_deceased = "SELECT 1 FROM MR_DEATH_REGISTER_HDR WHERE PATIENT_ID=?";
						else
							query_chk_deceased = "select DECEASED_YN from mp_patient where patient_id=? and DECEASED_YN='Y'";

						pstmt = con.prepareStatement(query_chk_deceased);
						pstmt.setString(1, patient_id);
						rs = pstmt.executeQuery();
						
						if(!rs.next())
						{
							error_flag = true;
							msgfrom = "DECEASED_ONLY";
							p_note_type = "";
							note_type_ql="";
							note_group_id="";
							performed_by_ql  =  "";
							perf_pract_name_ql = "";
							disflag  = "";
							filter_by_ql="P";
							speciality_ql="";							
							medanc_serv_ql="";								
							filter_by_ql_tmp="P";								
							serv_name_ql = "";		
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}

					
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					
					if(!error_flag)
					{
						if(!no_of_rec_per_enc.equals(""))
						{
							try
							{
								String query = "select count(*) from ca_encntr_note where encounter_id = ? and facility_id=? and note_type = ? and event_status in ('1','2','3','4','5') ";
								pstmt = con.prepareStatement(query);
								pstmt.setString(1, encounter_id);
								pstmt.setString(2, facility_id);
								pstmt.setString(3, note_type_ql);
								rs = pstmt.executeQuery();
								if(rs.next())
									record_cnt_for_enc =  rs.getInt(1);

								if(record_cnt_for_enc >=  Integer.parseInt(no_of_rec_per_enc))
								{
									msgfrom="MAX_NOTES_LIMIT";
									search_screen_activated = true;
									p_note_type = "";
									note_type_ql="";
									note_group_id="";
									performed_by_ql  =  "";
									perf_pract_name_ql = "";
									disflag  = "";
									filter_by_ql="P";
									speciality_ql="";							
									medanc_serv_ql="";								
									filter_by_ql_tmp="P";								
									serv_name_ql = "";		
								}

								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();							
							}
							catch(Exception e)
							{
								e.printStackTrace();							
							}
						}
					}


					}


			}else if(!p_note_type.equals("")&&!function_id.equals("TASK_LIST"))
			{
				
						
						String serv_ql_qry= "select AM_GET_DESC.AM_SERVICE(nvl(?,''),?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(nvl(?,''),?,1) performed_by_name from dual";
						
						stmtsql = con.prepareStatement(serv_ql_qry);
						stmtsql.setString(1,medanc_serv_ql);
						stmtsql.setString(2,locale);
						stmtsql.setString(3,performed_by_ql);
						stmtsql.setString(4,locale);

						rs = stmtsql.executeQuery();
						if(rs.next())
						{
							serv_name_ql = rs.getString("service_name")==null?"":rs.getString("service_name");
							perf_pract_name_ql = rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");					
							
						}

						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();

						countQuerySec = "select count(*) count  from ca_note_section  where note_type = ? ";
						stmtsql = con.prepareStatement(countQuerySec);
						stmtsql.setString(1,p_note_type);

						rs = stmtsql.executeQuery();
						
						if(rs.next())
						{
							sec_count = rs.getString("count");
							
						}
						
						
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();


						query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";
						stmtsql		=	con.prepareStatement(query_section_details);					
										
						
						stmtsql.setString(1, resp_id);
						stmtsql.setString(2, p_note_type);
						stmtsql.setString(3, locale);
						rs	=	stmtsql.executeQuery();

						if(rs.next())
						{
							//event_class,serv_facl_spec_yn,privilege_type,note_type_desc
							//event_type_caption,security_level,event_date_caption,event_perf_by_caption,security_level,event_date_caption,event_perf_by_caption,event_title_caption,event_title_desc,event_auth_by_caption,event_status_caption,note_group_id,doc_linked_note_yn

							
							event_class					=	checkForNull( rs.getString("event_class") );
							serv_facl_spec_yn			=	checkForNull( rs.getString("serv_facl_spec_yn") );
							privilege_type				=	checkForNull( rs.getString("privilege_type") );
							note_type_desc				=	checkForNull( rs.getString("note_type_desc") );
							event_type_caption			=	checkForNull( rs.getString("event_type_caption") );
							security_level	=	checkForNull( rs.getString("security_level") );
							event_date_caption			=	checkForNull( rs.getString("event_date_caption") );
							event_perf_by_caption		=	checkForNull( rs.getString("event_perf_by_caption") );
							event_title_caption			=	checkForNull( rs.getString("event_title_caption") );
							event_title_desc			=	checkForNull( rs.getString("event_title_caption") );
							event_auth_by_caption		=	checkForNull( rs.getString("event_auth_by_caption") );
							event_status_caption		=	checkForNull( rs.getString("event_status_caption") );
							note_group_id				=	checkForNull( rs.getString("note_group_id") );
							//sys_date_time				=	checkForNull( rs.getString("sys_date_time") );
							doc_linked_note_yn			=	checkForNull( rs.getString("DOC_LINKED_NOTE_YN") );

							//sys_date_time				=	com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHM","en",locale);
						//	sys_date_time				=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
							
						}
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
		
						
						if(!privilege_type.equals("1") && !p_note_type.equals("") && performed_by_ql.equals(""))
						{
							performed_by_ql  =  practitioner_id;
							perf_pract_name_ql = practitioner_name;
							
							disflag  = "disabled";
						}else if(!performed_by_ql.equals("")){
							disflag  = "disabled";
						}else{
								disflag  = "";
						}					
						
						String note_group_query2 ="select note_group_id from ca_note_type where note_type = ?";
						pstmt		=	con.prepareStatement(note_group_query2);
							
						pstmt.setString(1,note_type_ql);
						ResultSet rs1			=	pstmt.executeQuery();
						if(rs1.next()){
							note_group_id = rs1.getString("note_group_id");						
						}
						if(rs1 != null)rs1.close();
						if(pstmt != null)pstmt.close();

						String query_note_group_props = "select NO_OF_REC_PER_ENC,ROLE_BASED_ACCESS_YN,PRE_COND_FOR_REC from ca_note_group where NOTE_GROUP=?";

					pstmt = con.prepareStatement(query_note_group_props);
					pstmt.setString(1, note_group_id);
					rs = pstmt.executeQuery();
					
					if(rs.next())
					{
						no_of_rec_per_enc		= checkForNull(rs.getString("NO_OF_REC_PER_ENC")); 
						role_based_access_yn	= checkForNull(rs.getString("ROLE_BASED_ACCESS_YN")); 
						role_based_access_yn=role_based_access_yn;
						pre_cond_for_rec			= checkForNull(rs.getString("PRE_COND_FOR_REC")); 
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
					if(pre_cond_for_rec.equals("D"))
					{
						if(patient_class.equals("IP") || patient_class.equals("DC"))
						{
							String query_ip_dis_advice =	 "select 1 from ip_discharge_advice where facility_id =? and  encounter_id=? and DIS_ADV_STATUS in ('0','1')";
							pstmt = con.prepareStatement(query_ip_dis_advice);
							pstmt.setString(1, facility_id);
							pstmt.setString(2, encounter_id);
							rs = pstmt.executeQuery();						
							if(!rs.next())
							{
								error_flag = true;
								msgfrom = "DIS_ADV_NOT_EXISTS";
								//p_note_type = "";
								note_type_ql="";
								note_group_id="";
								performed_by_ql  =  "";
								//perf_pract_name_ql = "";
								disflag  = "";
								filter_by_ql="P";
								speciality_ql="";							
								medanc_serv_ql="";								
								filter_by_ql_tmp="P";								
								serv_name_ql = "";		
								if(!appl_task_id.equals("PROGRESS_NOTES"))
								{
									p_note_type = "";
									perf_pract_name_ql = "";
								}


							}
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
						}
					}
					else if(pre_cond_for_rec.equals("E"))
					{
						
						String install_yn = "";
						String query_install_yn = "SELECT  INSTALL_YN     FROM SM_MODULE  WHERE MODULE_ID='AE'";
						pstmt = con.prepareStatement(query_install_yn);
						rs = pstmt.executeQuery();
						if(rs.next())
							install_yn = checkForNull(rs.getString("INSTALL_YN"));						
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();

						String query_chk_deceased = "";
						if(install_yn.equals("Y"))
							query_chk_deceased = "SELECT 1 FROM MR_DEATH_REGISTER_HDR WHERE PATIENT_ID=?";
						else
							query_chk_deceased = "select DECEASED_YN from mp_patient where patient_id=? and DECEASED_YN='Y'";

						pstmt = con.prepareStatement(query_chk_deceased);
						pstmt.setString(1, patient_id);
						rs = pstmt.executeQuery();
						
						if(!rs.next())
						{
							error_flag = true;
							msgfrom = "DECEASED_ONLY";
							
							if(!appl_task_id.equals("PROGRESS_NOTES"))
							{
							p_note_type = "";
								perf_pract_name_ql = "";
							}
							
							note_type_ql="";
							note_group_id="";
							performed_by_ql  =  "";
							disflag  = "";
							filter_by_ql="P";
							speciality_ql="";							
							medanc_serv_ql="";								
							filter_by_ql_tmp="P";								
							serv_name_ql = "";		
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}

					
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					
					if(!error_flag)
					{
						
						if(!no_of_rec_per_enc.equals(""))
						{
							try
							{
								String query = "select count(*) from ca_encntr_note where encounter_id = ? and facility_id=? and note_type = ? and event_status in ('1','2','3','4','5') ";
								pstmt = con.prepareStatement(query);
								pstmt.setString(1, encounter_id);
								pstmt.setString(2, facility_id);
								pstmt.setString(3, note_type_ql);
								rs = pstmt.executeQuery();
								if(rs.next())
									record_cnt_for_enc =  rs.getInt(1);
								if (!no_of_rec_per_enc.equals(""))
								{
									if(record_cnt_for_enc >=  Integer.parseInt(no_of_rec_per_enc))
									{
										msgfrom="MAX_NOTES_LIMIT";
										search_screen_activated = true;
										p_note_type = "";
										note_type_ql="";
										note_group_id="";
										performed_by_ql  =  "";
										perf_pract_name_ql = "";
										disflag  = "";
										filter_by_ql="P";
										speciality_ql="";							
										medanc_serv_ql="";								
										filter_by_ql_tmp="P";								
										serv_name_ql = "";		
									}
								}

								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();							
							}
							catch(Exception e)
							{
								e.printStackTrace();
								
							}
						}
					  }
					}
					else
					{	
						
						p_note_type = note_type;
						performed_by_ql=performedId;
						
						//new addition
						
						query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";
						stmtsql		=	con.prepareStatement(query_section_details);					
										
						stmtsql.setString(1, resp_id);
						stmtsql.setString(2, p_note_type);
						stmtsql.setString(3, locale);
						rs	=	stmtsql.executeQuery();

						if(rs.next())
						{
							//event_class,serv_facl_spec_yn,privilege_type,note_type_desc
							//event_type_caption,security_level,event_date_caption,event_perf_by_caption,security_level,event_date_caption,event_perf_by_caption,event_title_caption,event_title_desc,event_auth_by_caption,event_status_caption,note_group_id,doc_linked_note_yn

							
							event_class					=	checkForNull( rs.getString("event_class") );
							serv_facl_spec_yn			=	checkForNull( rs.getString("serv_facl_spec_yn") );
							privilege_type				=	checkForNull( rs.getString("privilege_type") );
							note_type_desc				=	checkForNull( rs.getString("note_type_desc") );
							event_type_caption			=	checkForNull( rs.getString("event_type_caption") );
							security_level	=	checkForNull( rs.getString("security_level") );
							event_date_caption			=	checkForNull( rs.getString("event_date_caption") );
							event_perf_by_caption		=	checkForNull( rs.getString("event_perf_by_caption") );
							event_title_caption			=	checkForNull( rs.getString("event_title_caption") );
							event_title_desc			=	checkForNull( rs.getString("event_title_caption") );
							event_auth_by_caption		=	checkForNull( rs.getString("event_auth_by_caption") );
							event_status_caption		=	checkForNull( rs.getString("event_status_caption") );
							note_group_id				=	checkForNull( rs.getString("note_group_id") );
							//sys_date_time				=	checkForNull( rs.getString("sys_date_time") );
							doc_linked_note_yn			=	checkForNull( rs.getString("DOC_LINKED_NOTE_YN") );

							//sys_date_time				=	com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHM","en",locale);
						//	sys_date_time				=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
							
						}
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
						// ends here
						//49237 Start.
						if(!privilege_type.equals("1") && !p_note_type.equals("") && performed_by_ql.equals(""))
						{							
							performed_by_ql  =  practitioner_id;
							perf_pract_name_ql = practitioner_name;
							
							disflag  = "disabled";
						}else if(!performed_by_ql.equals("")){							
							disflag  = "disabled";
						}else{
								disflag  = "";
						}
						//49237 End.
						String query_tasklst = "select AM_GET_DESC.AM_PRACTITIONER(nvl(?,''),?,1) performed_by_name from dual";
						
						stmtsql = con.prepareStatement(query_tasklst);
						stmtsql.setString(1,performedId);
						stmtsql.setString(2,locale);

						rs = stmtsql.executeQuery();
						if(rs.next())
						{
							perf_pract_name_ql = rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");					
							
						}

						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
						
						

						countQuerySec = "select count(*) count  from ca_note_section  where note_type = ? ";
						stmtsql = con.prepareStatement(countQuerySec);
						stmtsql.setString(1,p_note_type);

						rs = stmtsql.executeQuery();
						
						if(rs.next())
						{						
							sec_count = rs.getString("count");
							
						}
						
						
						if(rs != null)rs.close();
						if(stmtsql != null)stmtsql.close();
					
						
					}


			//crf 0064 ends here
					if(appl_task_id.equals("RD_CLINICAL_NOTES")){						
						if(!privilege_type.equals("1")){
							disflag  = "disabled";
							performed_by_ql  =  practitioner_id;
							perf_pract_name_ql = practitioner_name;
						}else{
							disflag  = "";	
							performed_by_ql  =  "";
							perf_pract_name_ql = "";
						}
					}
			if(!patient_class.equals("XT") )
			{
				//strDetailsQry	=	"select to_char( VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, 	nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,(select facility_name from sm_facility_param where facility_id=a.facility_id) facility_name, (select short_desc from am_service where service_code=a. SERVICE_CODE )  specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ATTEND_PRACTITIONER_ID) attending_practitioner,service_code from pr_encounter a where facility_id = ? and encounter_id = ? ";
				  strDetailsQry	="select  to_char( VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,1)  attending_practitioner,service_code,AM_GET_DESC.AM_SPECIALITY(?,?,'2') speciality_name from    pr_encounter a where   facility_id = ? and     encounter_id = ?";
				try
				{
					ptPatLine	=	con.prepareStatement(strDetailsQry);

					ptPatLine.setString	(	1,	locale	);
					ptPatLine.setString	(	2,	locale	);
					ptPatLine.setString	(	3,	locale	);
					ptPatLine.setString	(	4,	speciality_code1 );
					ptPatLine.setString	(	5,	locale	);
					ptPatLine.setString	(	6,	facility_id	);
					ptPatLine.setString	(	7,	encounter_id);

					stPatLine		=	ptPatLine.executeQuery();

					if(stPatLine.next())
					{
						service_name				=	stPatLine.getString("service_name");
						speciality_code				=	stPatLine.getString("service_code");
						discharge_date_time				=	stPatLine.getString("DISCHARGE_DATE_TIME");
						attending_practitioner		=	stPatLine.getString("attending_practitioner");
						attending_practitioner_temp	= java.net.URLEncoder.encode(attending_practitioner,"UTF-8");//IN041881
						speciality_name		=	stPatLine.getString("speciality_name");
						visit_adm_date		=	stPatLine.getString("visit_adm_date");
					}
				

							// added for CRF 499 unlinked issue starts
			
		
				if(serv_facl_spec_yn.equals("Y") )
				{

					query_section_details_serv = " select ca_note_type_by_serv.service_code from ca_note_type_by_serv, AM_FACILITY_SERVICE_VW where ca_note_type_by_serv.facility_id=AM_FACILITY_SERVICE_VW.operating_facility_id and ca_note_type_by_serv.note_type = ?  and ca_note_type_by_serv.service_code=AM_FACILITY_SERVICE_VW.SERVICE_CODE AND ca_note_type_by_serv.SERVICE_CODE = ? ";

					pstmt		=	con.prepareStatement(query_section_details_serv);
					
					pstmt.setString(1, p_note_type);
					pstmt.setString(2, speciality_code);
					rs	=	pstmt.executeQuery();

				if(rs.next())
					 service_code = rs.getString(1);

				if(service_code == null) service_code ="";

				if(service_code.equals(""))
				{
					 speciality_code ="";
					 service_name = "" ;

				}



				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

						
				}

			

		// added for CRF 499 unlinked issue ends





					/*if(ql_flag.equals("Y"))
					{
						if(!service_name.equals(serv_name_ql))
						{
							service_name="";	
						}

					}*/

					if(medanc_serv_ql.equals("") && (!note_type_ql.equals("") || !p_note_type.equals("")))
					{
						medanc_serv_ql = speciality_code;
						serv_name_ql = service_name;				
					}
				
				}
				catch (Exception eeee)
				{
					eeee.printStackTrace() ;
				}
				finally
				{
					if ( stPatLine!= null) stPatLine.close();
					if ( ptPatLine!= null) ptPatLine.close();
				}
			}		
			boolean chk_flag = com.ehis.util.DateUtils.isBefore(sys_date_time, visit_adm_date, "DMYHM", locale);
			if(chk_flag)
			{
				sys_date_time = visit_adm_date;
			}else{
				sys_date_time = sys_date_time;
			}	
			
            _bw.write(_wl_block10Bytes, _wl_block10);

			
			if( operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum"))
			{
				String sel_note_group = "";
				accession_num	=	checkForNull(request.getParameter("accession_num"));
				note_type			=	checkForNull(request.getParameter("note_type"));

				//query_header_details.append("select event_type_caption, note_type, note_type_desc, service_code, short_desc service_desc, event_class, security_level, event_date_caption, to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, event_perf_by_caption, performed_by_id, short_name performed_by_name, event_title_caption, event_title_desc, event_auth_by_caption, event_status_caption, decode( event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified') event_status from ca_encntr_note_vw where facility_id = ? and accession_num = ? ");
				query_header_details.append("select event_type_caption, note_type, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc, service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') service_desc, event_class, security_level, event_date_caption, to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, event_perf_by_caption, performed_by_id, AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,1) performed_by_name, event_title_caption, event_title_desc, event_auth_by_caption, event_status_caption, event_status, (select note_group_id from ca_note_type b where b.note_type = a.note_type ) note_group_id	from 	ca_encntr_note A where 	/*facility_id = ? and 	*/accession_num = ?");
				try
				{
					pstmt	=	con.prepareStatement(query_header_details.toString());
					pstmt.setString( 1,	locale	);
					pstmt.setString( 2,	locale	);
					pstmt.setString( 3,	locale	);
					//pstmt.setString( 4,	facility_id		);
					pstmt.setString( 4,	accession_num	);
					
					rs	=	pstmt.executeQuery();
					if(rs.next())
					{
						event_type_caption				=	rs.getString("event_type_caption");
						note_type						=	rs.getString("note_type");
						note_type_desc					=	rs.getString("note_type_desc");
						service_code					=	rs.getString("service_code");
						service_desc					=	rs.getString("service_desc");
						event_class						=	rs.getString("event_class");
						security_level					=	rs.getString("security_level");
						event_date_caption				=	rs.getString("event_date_caption");
						event_date_time					=	rs.getString("event_date_time");
						event_perf_by_caption			=	rs.getString("event_perf_by_caption");
						performed_by_id					=	rs.getString("performed_by_id");
						performed_by_name				=	rs.getString("performed_by_name");
						event_title_caption				=	rs.getString("event_title_caption");
						event_title_desc				=	rs.getString("event_title_desc");
						event_auth_by_caption			=	rs.getString("event_auth_by_caption");
						event_status_caption			=	rs.getString("event_status_caption");
						event_status_code				=	rs.getString("event_status");					
						sel_note_group				=	rs.getString("note_group_id");					
						//event_status					=	rs.getString("event_status");				
						
						event_date_time					=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);

						if(event_status_code.equals("1"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
						else if (event_status_code.equals("2"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
						else if (event_status_code.equals("3"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
						else if (event_status_code.equals("4"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
						else if (event_status_code.equals("5"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");


						if(event_title_desc==null)		
							event_title_desc		=	"";
						if(event_type_caption==null)	
							event_type_caption		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteTypes.label","ca_labels");
						if(event_date_caption==null)	
							event_date_caption		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels");
						if(event_perf_by_caption==null)	
							event_perf_by_caption	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels") ;
						if(event_title_caption==null)	
							event_title_caption		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteTitle.label","ca_labels");
						if(event_auth_by_caption==null)	
							event_auth_by_caption	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.authorizedby.label","common_labels");	
						if(event_status_caption==null)	
							event_status_caption	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");		 //"Note Status";
					}

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					//IN034224,starts Addendum
					accession_num	=	checkForNull(request.getParameter("accession_num"));			
					
					if(!accession_num.equals(""))
					{
						//Connection			conAddendum			=	null;
						PreparedStatement	pstmtAddendum		=	null;
						ResultSet			rsAddendum			=	null;
						
						try
						{
							//conAddendum				=	ConnectionManager.getConnection(request);//IN033677
							//pstmtAddendum			=	conAddendum.prepareStatement("SELECT SRL_NO FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881
							pstmtAddendum			=	con.prepareStatement("SELECT SRL_NO FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881//IN033677
							pstmtAddendum.setString(1, accession_num);
							
							rsAddendum				=	pstmtAddendum.executeQuery();
													
							if(rsAddendum.next())
							{
								srl_no	=rsAddendum.getString(1);
							}
						}
						catch(Exception e)
						{
							//out.println("Exception in RecClinicalNotesHeader.jsp,1400=>"+e);//COMMON-ICN-0181
							e.printStackTrace();//COMMON-ICN-0181
						}
						finally
						{			
							if(rsAddendum!=null) rsAddendum.close();
							if(pstmtAddendum!=null)pstmtAddendum.close();
							//if(conAddendum!=null) ConnectionManager.returnConnection(conAddendum,request);//IN033677
						}
					}
					//IN034224,ends Addendum

					String query_privilege_type = "select privilege_type,SERV_FACL_SPEC_YN from ca_note_type_for_resp_view where resp_id = ? and note_type = ? ";

					pstmt		=	con.prepareStatement(query_privilege_type);

					pstmt.setString( 1,	resp_id.trim());
					pstmt.setString( 2,	note_type.trim());

					rs			=	pstmt.executeQuery();

					if(rs.next())
					{
						privilege_type	=	rs.getString("privilege_type");
						serv_facl_spec_yn = rs.getString("serv_facl_spec_yn");
						
					}

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(event_type_caption));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sel_note_group));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(operation_mode.equals("Update"))
				{
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(serv_facl_spec_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(event_date_caption));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_date_time));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(event_date_time));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(event_perf_by_caption));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(performed_by_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(performed_by_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(event_title_caption));
            _bw.write(_wl_block32Bytes, _wl_block32);

				//Note Title Editable for Note Modification time. Start.
				if( operation_mode.equals("Update")){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(event_title_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(event_title_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(event_title_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
				//Note Title Editable for Note Modification time. End.
				
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(event_status_caption));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
if("Y".equals(auto_save_yn)){ 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(auto_save_time));
            _bw.write(_wl_block43Bytes, _wl_block43);
} 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HideHeader.label","ca_labels")));
            _bw.write(_wl_block45Bytes, _wl_block45);

					String secQuery = " select (select count(*)  from ca_note_section B where B.note_type = A.NOTE_TYPE ) sec_count,DOC_LINKED_NOTE_YN from CA_NOTE_TYPE_LANG_VW A where NOTE_TYPE = ? and LANGUAGE_ID = ? ";

					pstmt		=	con.prepareStatement(secQuery);

					pstmt.setString( 1,	note_type.trim());
					pstmt.setString( 2,	locale );

					rs			=	pstmt.executeQuery();

					if(rs.next())
					{
						sec_count_upd	=	rs.getString("sec_count");
						doc_linked_note_yn_upd = rs.getString("DOC_LINKED_NOTE_YN");
						
					}

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if (doc_linked_note_yn_upd.equals("Y")){
						if(Integer.parseInt(sec_count_upd) == 0){

					
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block54Bytes, _wl_block54);

					}
					else 
					{
		
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block58Bytes, _wl_block58);


					}
					}
			}
			else
			{					
				
		
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disableFilterBy));
            _bw.write(_wl_block62Bytes, _wl_block62);
if (p_note_type.trim().equals("") || appl_task_id.equals("NOTIFIABLEFORM") ) {//IN050839	
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(filter_by_ql_tmp.equals("R")) filter_by_sel="selected"; 
					   else filter_by_sel=""; 
					 
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(filter_by_sel));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
 if(filter_by_ql_tmp.equals("P")) filter_by_sel="selected"; else filter_by_sel=""; 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(filter_by_sel));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
 if(filter_by_ql_tmp.equals("S")) filter_by_sel="selected"; else filter_by_sel=""; 
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(filter_by_sel));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

					}
					else
					{
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block73Bytes, _wl_block73);

				if(filter_by_ql_tmp.equals("S") && ql_flag.equals("Y"))
				{
					speciality_disp="display:";
				}
				else
				{
					speciality_disp ="display:none";
				}
					
				
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(speciality_disp));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(speciality_disp));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

						try
						{					
							splQuery = "select SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,?,'2') short_desc from am_speciality_lang_vw where language_id=? and SPECIALITY_CODE IN (select A.PRIMARY_SPECIALITY_CODE from AM_PRACTITIONER A where A.PRACTITIONER_ID = ? UNION  select B.SPECIALITY_CODE from AM_PRACT_SPECIALITIES B where B.PRACTITIONER_ID = ? and B.FACILITY_ID = ?) and eff_status = 'E' order by 2";					
							
							pstmt		=	con.prepareStatement(splQuery);		
							
							pstmt.setString(1,locale);
							pstmt.setString(2,locale);						
							pstmt.setString(3,practitioner_id);						
							pstmt.setString(4,practitioner_id);
							pstmt.setString(5,facility_id);
							
							rs			=	pstmt.executeQuery();

							while(rs.next())
							{
								splty_code		=	rs.getString("speciality_code");
								splty_code_desc	=	rs.getString("short_desc");					
					
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((splty_code.trim().equals(p_splty_code.trim())||splty_code.trim().equals(speciality_ql.trim()))?"selected":""));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(splty_code_desc));
            _bw.write(_wl_block68Bytes, _wl_block68);
}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}			
				
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(((function_id.equals("SPCL_NOTE")&&(!p_note_type.equals("")))||(function_id.equals("TASK_LIST"))?"disabled":"")));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

				try
				{
					/*
					query_header_details.append("Select note_type, replace(note_type_desc,'''','') note_type_desc from ca_note_type_for_resp_view where resp_id = ? and privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y'  ");

					if(!p_note_type.equals(""))
						query_header_details.append(" and note_type = ? ");
					else
						query_header_details.append(" AND NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");

					query_header_details.append(" order by  2 "); */

					//

			/*		query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");

					if(!p_note_type.equals(""))
						query_header_details.append(" 	and c.note_type = ? ");
					else
						query_header_details.append(" 	AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");  */

					if((appl_task_id.equals("RD_CLINICAL_NOTES")&&!p_note_type.equals(""))||(function_id.equals("SPCL_NOTE")&&(!p_note_type.equals("")))) {
							query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");								
					}else{
							
						if (!appl_task_id.equals("PAT_MEDICAL_REPORT"))
						{
							if(!filter_by_ql.equals("R")&&!filter_by_ql.equals(""))
							{
							
							sqlQuery.append("Select count(*) total from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_TYPE =?");
							
							if(filter_by_ql.equals("S")&& speciality_ql.equals(""))
							{
							sqlQuery.append(" and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)");
							}
							else
							{
							sqlQuery.append(" AND a.RESOURCE_CODE = ?");
							}
							 sqlQuery.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) AND EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5')");
							
							pstmt		=	con.prepareStatement(sqlQuery.toString());

							if(filter_by_ql.equals("S")||filter_by_ql.equals("P"))
							{
								pstmt.setString(count1++,filter_by_ql);
							}
							else if(filter_by_ql.equals(""))
							{
								pstmt.setString(count1++,"P");
							}
							if(filter_by_ql.equals("S"))
							{
								if(speciality_ql.equals(""))
								{
									pstmt.setString(count1++,practitioner_id);
									pstmt.setString(count1++,practitioner_id);
								}
								else
								{
									pstmt.setString(count1++,speciality_ql);
								}
							}
							else if(filter_by_ql.equals("")||filter_by_ql.equals("P"))
							{
								pstmt.setString(count1++,practitioner_id);	
							}
											
							pstmt.setString(count1++,locale);
							pstmt.setString(count1++,patient_class);
							pstmt.setString(count1++,appl_task_id);
							pstmt.setString(count1++,resp_id);	

							rs			=	pstmt.executeQuery();

							if (rs.next())
								cntNote = rs.getInt("total");
															
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
							}
							else if(filter_by_ql.equals(""))
							{
								sqlQuery.delete(0,sqlQuery.length());
								sqlQuery.append("Select count(*) total from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_TYPE ='P'");
								sqlQuery.append(" AND a.RESOURCE_CODE = ?");
								sqlQuery.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) AND EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5')");
								
								if(!note_type_ql.equals(""))
								sqlQuery.append(" and c.note_type = ? ");
							
								if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
								{
									sqlQuery.append(" and c.NOTE_GROUP_ID = ? ");

								}
							
								pstmt		=	con.prepareStatement(sqlQuery.toString());
								pstmt.setString(count1++,practitioner_id);
								pstmt.setString(count1++,locale);
								pstmt.setString(count1++,patient_class);
								pstmt.setString(count1++,appl_task_id);
								pstmt.setString(count1++,resp_id);
								if(!note_type_ql.equals(""))
									pstmt.setString(count1++,note_type_ql);
								if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
								{	
									pstmt.setString(count1++,note_group_req);
								}

								rs			=	pstmt.executeQuery();

								if (rs.next())
									cntNote = rs.getInt("total");
								
															
								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();


							}

						}
							if (cntNote > 0) {				
								
								query_header_details.append("Select distinct a.note_type_id note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_TYPE =? ");
								
								if(filter_by_ql.equals("S")&& speciality_ql.equals(""))
								{
									query_header_details.append(" and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)");
								}
								else
								{
									query_header_details.append(" AND a.RESOURCE_CODE = ?");
								}
								
								 query_header_details.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' ) ");
							}else {
								if(!function_id.equals("TASK_LIST")){	out.println("<SCRIPT>document.RecClinicalNotesHeaderForm.filter_by.value = 'R'</SCRIPT>");}
								//IN061988 starts
								//query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");	
								if("PH_NOTES".equals(appl_task_id))
								{
									query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resp a , ca_note_type_lang_vw c,PH_NOTE_EXT_DRUG d where a.resp_id = ?  and a.note_type = c.note_type AND a.note_type = D.NOTE_TYPE and c.note_type = d.note_type and c.note_group_id = D.NOTE_GROUP_ID and D.EXT_DRUG_NOTE_YN = 'Y' and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
								}
								else
								{
									query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =c.NOTE_GROUP_ID ) dflt_transcription_yn from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");				
								}
								//IN061988 ends
							}
												
					}
						if(!p_note_type.equals(""))
							query_header_details.append(" 	and c.note_type = ? ");
						else
							query_header_details.append(" 	AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");
						//IN037701 Starts
						if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
						{
							query_header_details.append(" 	AND EVENT_CLASS= ? ");
						}
						//IN037701 Ends
						if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
								query_header_details.append(" AND  (EXISTS (SELECT 1 FROM CA_PMR_FOR_PRACTITIONER WHERE NOTE_TYPE_ID=A.NOTE_TYPE AND PRACTITIONER_ID=? AND FACILITY_ID=? ) OR (EXISTS (SELECT 1 FROM  CA_PMR_FOR_SPECIALITY WHERE NOTE_TYPE_ID=A.NOTE_TYPE  AND FACILITY_ID=? AND SPECIALITY_CODE IN  (SELECT  PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?))))");
						if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT")&&p_note_type.equals(""))
						{	
							query_header_details.append(" and c.NOTE_GROUP_ID = ? ");
						}

						query_header_details.append(" 	order by  2 ");
						
					
					pstmt		=	con.prepareStatement(query_header_details.toString());
											
				//	pstmt.setString(1,resp_id);
				/*
				if((!p_note_type.equals(""))) {
					
					pstmt.setString(count2++,resp_id);	
					pstmt.setString(count2++,locale);
					pstmt.setString(count2++,patient_class);
					
					if(!p_note_type.equals(""))
						pstmt.setString(count2++,p_note_type);
					else
						pstmt.setString(count2++,appl_task_id);
				
				}else */{
					if (cntNote > 0)
					{
							
							if(filter_by_ql.equals("S")||filter_by_ql.equals("P"))
							{
								pstmt.setString(count2++,filter_by_ql);
							}
							else if(filter_by_ql.equals(""))
							{
								pstmt.setString(count2++,"P");
							}
							if(filter_by_ql.equals("S"))
							{
								
								if(speciality_ql.equals(""))
								{
									pstmt.setString(count2++,practitioner_id);
									pstmt.setString(count2++,practitioner_id);
								}
								else
								{
									pstmt.setString(count2++,speciality_ql);
								}
								
								
							}
							else if(filter_by_ql.equals("")||filter_by_ql.equals("P"))
							{
								pstmt.setString(count2++,practitioner_id);	
							}
						
						//pstmt.setString(1,practitioner_id);
						pstmt.setString(count2++,locale);
						pstmt.setString(count2++,patient_class);
						pstmt.setString(count2++,resp_id);
						if(!p_note_type.equals(""))
							pstmt.setString(count2++,p_note_type);
						else
							pstmt.setString(count2++,appl_task_id);
						if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
						{
							 pstmt.setString(count2++,practitioner_id);
							 pstmt.setString(count2++,facility_id);
							 pstmt.setString(count2++,facility_id);
							 pstmt.setString(count2++,practitioner_id);
							 pstmt.setString(count2++,practitioner_id);
						}
					}
					else
					{	
						pstmt.setString(count2++,resp_id);	
						pstmt.setString(count2++,locale);
						pstmt.setString(count2++,patient_class);
						if(!p_note_type.equals(""))
							pstmt.setString(count2++,p_note_type);
						else
							pstmt.setString(count2++,appl_task_id);
						//IN037701 Starts
						if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
						{
							//p_event_class_widget
							 pstmt.setString(count2++,p_event_class_widget);
						}
						//IN037701 Ends
						if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
						{
							 pstmt.setString(count2++,practitioner_id);
							 pstmt.setString(count2++,facility_id);
							 pstmt.setString(count2++,facility_id);
							 pstmt.setString(count2++,practitioner_id);
							 pstmt.setString(count2++,practitioner_id);
						}
					}
						if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
						{	
							pstmt.setString(count2++,note_group_req);
						}
				}
						
					
					rs			=	pstmt.executeQuery();

					while(rs.next())
					{
						note_type		=	rs.getString("note_type");
						note_type_desc	=	rs.getString("note_type_desc");		
						dflt_transcription_yn	=	rs.getString("dflt_transcription_yn");	

						if (note_type.trim().equals(p_note_type.trim())||note_type.trim().equals(note_type_ql.trim()))
						{
							NoteTypeflag = true;						 
						}
			
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((note_type.trim().equals(p_note_type.trim())||note_type.trim().equals(note_type_ql.trim()))?"selected":""));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);

						if((note_type.trim().equals(p_note_type.trim())||note_type.trim().equals(note_type_ql.trim())))
						{
							transcription_yn = dflt_transcription_yn;
						}
			}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}	

				/*if(!ql_ref.equals("")&&!note_type_ql.equals(""))
				{
					p_note_type =note_type_ql;
				}*/

				if(p_note_type.equals("") && !note_type_ql.equals(""))
				{
					p_note_type =note_type_ql;
				}
				
				if((!p_note_type.equals("") || !note_type_ql.equals("")) ){
					String note_group_query1 ="select note_group_id from ca_note_type where note_type = ?";
					pstmt		=	con.prepareStatement(note_group_query1);
					pstmt.setString(1,p_note_type);
					ResultSet rs1			=	pstmt.executeQuery();
					if(rs1.next()){
						note_group_id = rs1.getString("note_group_id");
						note_group_disable = "disabled";
					}
					if(rs1 != null)rs1.close();
					if(pstmt != null)pstmt.close();
				}
				if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
				{
					note_group_id =note_group_req;
					note_group_disable = "disabled";
				}

				
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(note_group_disable));
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

						try
						{
							String note_group = "";
							String note_group_desc = "";
							/*
							StringBuffer note_group_query = new StringBuffer(" Select note_group, note_group_desc from ca_note_group  where eff_status='E'  ");
							if(!p_note_type.equals(""))
								note_group_query.append(" and note_group =(select note_group_id from ca_note_type where note_type = ? ) ");
							else if (!appl_task_id.equals(""))
								note_group_query.append(" and APPL_TASK_ID=?  ");
							note_group_query.append("  order by 2"); */

							//										

							StringBuffer note_group_query = new StringBuffer(" 	Select note_group, note_group_desc from ca_note_group_lang_vw  a  where a.eff_status='E'  and a.language_id = ? ");
							
							if((!p_note_type.equals("") || !note_type_ql.equals("")) &&ql_flag.equals("N"))					
								note_group_query.append(" and a.note_group =( select note_group_id from ca_note_type where note_type = ? ) ");
							else if (!appl_task_id.equals(""))
							{
								note_group_query.append("  and a.APPL_TASK_ID=?  ");
							

								if (cntNote > 0) {	
									note_group_query.append(" and exists (select 1 from ca_note_type ia,ca_note_type_for_resource ib where IB.RESOURCE_TYPE=? ");
									if(filter_by_ql.equals("S")&& speciality_ql.equals(""))
									{
										note_group_query.append(" and IB.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)");
									}
									else
									{
										note_group_query.append(" AND ib.RESOURCE_CODE = ?");
									}
					
									
										note_group_query.append(" and ib.note_type_id=ia.note_type and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1" );
								}else {															
									note_group_query.append(" and exists (select 1 from ca_note_type ia,ca_note_type_for_resp ib where ib.resp_id=? and ib.note_type=ia.note_type and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1");
								}
								if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
									note_group_query.append(" AND  (EXISTS (SELECT 1 FROM CA_PMR_FOR_PRACTITIONER WHERE NOTE_TYPE_ID=iA.NOTE_TYPE AND PRACTITIONER_ID=? AND FACILITY_ID=? ) OR  (EXISTS (SELECT 1 FROM  CA_PMR_FOR_SPECIALITY WHERE NOTE_TYPE_ID=iA.NOTE_TYPE  AND FACILITY_ID=? AND SPECIALITY_CODE IN  (SELECT  PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?))))");
								
								note_group_query.append(")");
								if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
								{
									note_group_query.append("and  a.NOTE_GROUP = ?");
								}


								
							}
								note_group_query.append("  order by 2");									

							pstmt		=	con.prepareStatement(note_group_query.toString());		
							
							pstmt.setString(count++,locale);	
							if(!p_note_type.equals("")&&ql_flag.equals("N"))						
								pstmt.setString(count++,p_note_type);
							else if (!appl_task_id.equals(""))
							{
								pstmt.setString(count++, appl_task_id);
							
								if (cntNote > 0)
								{
									//new								
									if(filter_by_ql.equals("S")||filter_by_ql.equals("P"))
									{
										pstmt.setString(count++,filter_by_ql);
									}
									else if(filter_by_ql.equals(""))
									{
										pstmt.setString(count++,"P");
									}
									if(filter_by_ql.equals("S"))
									{
										
										if(speciality_ql.equals(""))
										{
											pstmt.setString(count++,practitioner_id);
											pstmt.setString(count++,practitioner_id);
										}
										else
										{
											pstmt.setString(count++,speciality_ql);
										}
								
																		
									}
									else if(filter_by_ql.equals("")||filter_by_ql.equals("P"))
									{
										pstmt.setString(count++,practitioner_id);	
									}

								 
									//new
									//pstmt.setString(3,practitioner_id);
								}
								else
								{
									pstmt.setString(count++,resp_id);			
								}
								if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
								{
									 pstmt.setString(count++,practitioner_id);
									 pstmt.setString(count++,facility_id);
									 pstmt.setString(count++,facility_id);
									 pstmt.setString(count++,practitioner_id);
									 pstmt.setString(count++,practitioner_id);
								}
								if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
								{
									pstmt.setString(count++,note_group_req);
								}

							}						
							rs			=	pstmt.executeQuery();
						
							while(rs.next())
							{
								note_group		=	rs.getString("note_group");
								note_group_desc	=	rs.getString("note_group_desc");					
					
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block80Bytes, _wl_block80);
if(!note_group_id.equals("") && note_group_id.equals(note_group)){
            _bw.write(_wl_block94Bytes, _wl_block94);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);

							}

							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
							
						}
						catch(Exception e)
						{
							e.printStackTrace();
							
						}			
						
						
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
if(NoteTypeflag){
            out.print( String.valueOf(serv_name_ql));
}
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(serv_facl_spec_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
if(NoteTypeflag){
            out.print( String.valueOf(medanc_serv_ql));
}
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
 if(p_date_time != null && !p_date_time.equals("")) { 
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(p_date_time));
            _bw.write(_wl_block103Bytes, _wl_block103);
 } else { 
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(days_backdate));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block107Bytes, _wl_block107);
 } 
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
if(NoteTypeflag){
            out.print( String.valueOf(perf_pract_name_ql));
}
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(disflag));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(disflag));
            _bw.write(_wl_block111Bytes, _wl_block111);
if(NoteTypeflag){
            out.print( String.valueOf(performed_by_ql));
}
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(auto_save_time));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HideHeader.label","ca_labels")));
            _bw.write(_wl_block115Bytes, _wl_block115);
if(p_note_type.equals("")||(!ql_flag.equals("Y")&&!appl_task_id.equals("PROGRESS_NOTES"))){ 
            _bw.write(_wl_block116Bytes, _wl_block116);
}
            _bw.write(_wl_block117Bytes, _wl_block117);
				
					if(!p_note_type.equals("")||ql_flag.equals("Y"))
					{  
						if(performed_by_name.equals(""))
							performed_by_name = perf_pract_name_ql;			
						
						
								
						if(error_flag && msgfrom.equals("DIS_ADV_NOT_EXISTS"))
						{
            _bw.write(_wl_block118Bytes, _wl_block118);
	}else if(error_flag && msgfrom.equals("DECEASED_ONLY"))
						{
            _bw.write(_wl_block119Bytes, _wl_block119);
	}else if(!error_flag && msgfrom.equals("MAX_NOTES_LIMIT"))
						{
            _bw.write(_wl_block120Bytes, _wl_block120);
  }else{
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(sec_count));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(NoteTypeflag));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(p_note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(event_title_desc));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(note_status));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(perf_pract_name_ql));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(p_date_time));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(attending_practitioner));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(speciality_name));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(serv_name_ql));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(discharge_date_time));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(p_note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(event_title_desc));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(note_status));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(perf_pract_name_ql));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(p_date_time));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(attending_practitioner_temp));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(speciality_name));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(serv_name_ql));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(discharge_date_time));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(p_note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(p_note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block145Bytes, _wl_block145);
		}	}
					} // end of else
						
				
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(serv_facl_spec_yn));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(action_comment));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(loggedUser));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(autho_doct_name));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(strModifiedBy));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(amendment_type));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(event_class));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(privilege_type));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(event_type_caption));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(security_level));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(event_date_caption));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(event_perf_by_caption));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(event_title_caption));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(event_auth_by_caption));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(event_status_caption));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(figer_print_auth_yn));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(service_name));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(speciality_name));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(speciality_code1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(performed_by_name));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(attending_practitioner));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(days_backdate));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(p_note_type));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(discharge_date_time));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(ql_flag));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(medanc_serv_ql));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(serv_name_ql));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(performed_by_ql));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(perf_pract_name_ql));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(transcription_yn));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(note_group_req));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(contr_oth_accession_num));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(sec_count));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(notifiable_code));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(notifiable_emailYN));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(dispResLinkHYMLYN));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(noteSplCharValidate));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(p_event_class_widget));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(l_notes_view));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(p_note_type));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(siteSpecFlag));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(display));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(myHIXSiteFlg));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(myHIXNoteType));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(copiedFlagYN));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(auto_save_yn));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ShowHeader.label","ca_labels")));
            _bw.write(_wl_block220Bytes, _wl_block220);

			//26826 Start.
			}else{
				
            _bw.write(_wl_block221Bytes, _wl_block221);

			}
			//26826 End.
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block1Bytes, _wl_block1);

if("NOTIFIABLEFORM".equals(appl_task_id))//IN050839 
{

            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block223Bytes, _wl_block223);
}
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(auto_save_yn));
            _bw.write(_wl_block225Bytes, _wl_block225);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Med/AncService.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MyFilter.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.responsibility.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoteGroup.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Med/AncService.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoteTitle.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NOTESHEADERINFORMATION.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
