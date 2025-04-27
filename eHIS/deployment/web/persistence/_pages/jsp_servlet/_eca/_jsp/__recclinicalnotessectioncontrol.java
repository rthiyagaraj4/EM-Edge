package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCA.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotessectioncontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesSectionControl.jsp", 1743657851460L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="<!--IN071264-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/prototype.js\'></script>\n\t<script>\n\t//IN041284 Start.\n\t//function showSectionTemplate_new(curr_sec_hdg_code,curr_section_type,curr_child_sec_hdg_code, template_title,patient_id,episode_id,sex,dob)\n\t//IN059571 Start.\n\t//function showSectionTemplate_new(curr_sec_hdg_code,curr_section_type,curr_child_sec_hdg_code, template_title,patient_id,episode_id,sex,dob,dispResLinkHYMLYN)\n\tfunction showSectionTemplate_new(curr_sec_hdg_code,curr_section_type,curr_child_sec_hdg_code, template_title,patient_id,episode_id,sex,dob,dispResLinkHYMLYN,noteSplCharValidate)\n\t//IN059571 End.\n\t//IN041284 End.\t\n\t{\t\n\t\tvar arguments\t\t=\t\"\" ;\t\t\n\t\tvar action_url\t\t=\t\'../../eCA/jsp/RecClinicalNotesTemplateMain.jsp\';\n\t\taction_url\t\t\t+=\t\"?curr_sec_hdg_code=\"+curr_sec_hdg_code+\"&curr_section_type=\"+curr_section_type+\"&curr_child_sec_hdg_code=\"+curr_child_sec_hdg_code+\"&template_title=\"+template_title+\"&operation_mode=&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&Sex=\"+sex+\"&Dob=\"+dob;\n\t\taction_url\t\t\t+=\"&dispResLinkHYMLYN=\"+dispResLinkHYMLYN;  //IN041284\n\t\taction_url\t\t\t+=\"&noteSplCharValidate=\"+noteSplCharValidate;  //IN059571\n\t\tparent.RecClinicalNotesSecDetailsFrame.location.href\t= action_url;\n\t\tparent.EditorTitleFrame.location.href = \"../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?editor_title=\"+encodeURIComponent(template_title,\"UTF-8\");\t\t\t\n\t\tsetTimeout(\"fnEnableLinks()\",1500);\t\t\n\t}\n\n\tfunction fnEnableLinks(){\t\n\t\tparent.frameSetIdMessage.rows=\'*%,0%\'\n\t\tcompressSectionFrames();\n\t}\n\n\tfunction callMeToGetEditor()\n\t{\n\t\tdocument.GetEditorForm.target = parent.RecClinicalNotesSecDetailsFrame.name;\n\t\tdocument.GetEditorForm.submit();\n\t}\n\t\n\tfunction changeEditorTitle_new(editor_title,image_linked_yn)\n\t{\t\n\t\tparent.EditorTitleFrame.location.href = \"../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?editor_title=\"+encodeURIComponent(editor_title,\"UTF-8\")+\"&image_linked_yn=\"+image_linked_yn;\n\t}\n\t//function recordSectionDetails()//Commented for IN067607\n\tfunction recordSectionDetails(myHIXYNFLG)//IN067607\n\t{\n\t\tvar noteType = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;//IN035950\n\t\tvar notifiable_code = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.notifiable_code.value;//IN044085\n\t\tvar notifiable_emailYN = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.notifiable_emailYN.value;//IN044085\n\t\tvar noteCopiedYN =parent.RecClinicalNotesToolbarFrame.document.getElementById(\"noteCopiedYN\").value;//IN068105\n\t\tvar sexValue =parent.RecClinicalNotesHeaderFrame.document.getElementById(\"Sex\").value;//IN072879\n\t\tvar speciality_name =parent.RecClinicalNotesHeaderFrame.document.getElementById(\"speciality_name\").value;//IN072879\n\t\tvar location_code =parent.RecClinicalNotesHeaderFrame.document.getElementById(\"location_code\").value;//IN072879\n\t\t//IN035950 Starts\n\t\t/*var noteType=\"\";\n\t\tif(null!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm && null!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type)\n\t\t{\n\t\tnoteType = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value\n\t\t}*/\n\t\t\n\t\t\n\t\t//IN035950 Ends\n\t\tvar FieldRef = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.Field_Ref.value\n\t\t//IN071264 Starts\n\t\tvar accession_num = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.accession_num.value;\n\t\tvar accession_num_auto = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num_auto.value;\n\t\tvar patient_id = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;\n\t\tvar encounter_id = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;\n\t\tvar prev_sec_hdg_code = document.getElementById(\"prev_sec_hdg_code\").value;\n\t\tvar prev_child_sec_hdg_code = document.getElementById(\"prev_child_sec_hdg_code\").value;\n\t\tif(undefined==accession_num_auto){\n\t\t\t\n\t\t\taccession_num_auto =\"\";\n\t\t}\n\t\t//IN071264 Ends\n\t\tvar ContrAcc = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.contr_mod_accession_num.value\n\t\tvar module_id = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.module_id.value\n//\t\tvar Performed = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id.value\n//\t\tvar evtdttime = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value\n\t\t//IN037701 Starts\n\t\tif(undefined!=parent.messageFrameReference)\n\t\t\tparent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.target\t=\tparent.messageFrameReference.name;\n\t\telse\n\t\t\tparent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.target\t=\tparent.messageframe.name;\n\t\t//IN037701 Ends\n\t\t//IN044085 Start.\n\t\t//parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action\t=\t\'../../servlet/eCA.RecClinicalNotesServlet?note_type=\'+noteType+\"&Field_Ref=\"+FieldRef +\"&contr_mod_accession_num=\"+ContrAcc+\'&module_id=\'+module_id;\n\t\t//parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action\t=\t\'../../servlet/eCA.RecClinicalNotesServlet?note_type=\'+noteType+\"&Field_Ref=\"+FieldRef +\"&contr_mod_accession_num=\"+ContrAcc+\'&module_id=\'+module_id+\'&notifiable_code=\'+notifiable_code+\'&notifiable_emailYN=\'+notifiable_emailYN;//Commented for IN067607\n\t\t//IN044085 End.\n\t\t//parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action\t=\t\'../../servlet/eCA.RecClinicalNotesServlet?note_type=\'+noteType+\"&Field_Ref=\"+FieldRef +\"&contr_mod_accession_num=\"+ContrAcc+\'&module_id=\'+module_id+\'&notifiable_code=\'+notifiable_code+\'&notifiable_emailYN=\'+notifiable_emailYN+\'&myHIXYN=\'+myHIXYNFLG;//modified for IN067607//commented for IN068105\n\t\t//parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action\t=\t\'../../servlet/eCA.RecClinicalNotesServlet?note_type=\'+noteType+\"&Field_Ref=\"+FieldRef +\"&contr_mod_accession_num=\"+ContrAcc+\'&module_id=\'+module_id+\'&notifiable_code=\'+notifiable_code+\'&notifiable_emailYN=\'+notifiable_emailYN+\'&myHIXYN=\'+myHIXYNFLG+\'&noteCopiedYN=\'+noteCopiedYN+\"&accession_num_auto=\"+accession_num_auto+\"&patient_id=\"+patient_id+\"&encounter_id=\"+encounter_id+\"&prev_child_sec_hdg_code_as=\"+prev_child_sec_hdg_code+\"&prev_sec_hdg_code_as=\"+prev_sec_hdg_code;//modified for IN067607 //modified for IN068105//Added for IN071264 //IN072879\n\t\tparent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action\t=\t\'../../servlet/eCA.RecClinicalNotesServlet?note_type=\'+noteType+\"&Field_Ref=\"+FieldRef +\"&contr_mod_accession_num=\"+ContrAcc+\'&module_id=\'+module_id+\'&notifiable_code=\'+notifiable_code+\'&notifiable_emailYN=\'+notifiable_emailYN+\'&myHIXYN=\'+myHIXYNFLG+\'&noteCopiedYN=\'+noteCopiedYN+\"&accession_num_auto=\"+accession_num_auto+\"&encounter_id=\"+encounter_id+\"&prev_child_sec_hdg_code_as=\"+prev_child_sec_hdg_code+\"&prev_sec_hdg_code_as=\"+prev_sec_hdg_code+\'&location_code=\'+location_code+\'&speciality_name=\'+speciality_name+\'&Sex=\'+sexValue+\"&patient_id=\"+patient_id;//modified for IN067607 //modified for IN068105//Added for IN071264 //IN072879\n\t\tparent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.method\t=\t\'post\';\n\t\tparent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.submit();\n\t}\n\n\tasync function showLinkDocuments(sec_hdg_code, sec_content_type, child_sec_hdg_code, child_sec_content_type, result_linked_rec_type,image_linked_yn)\n\t{\n\t\tvar episode_type\t= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.episode_type.value;\n\t\tvar encounter_id\t= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;\n\t\tvar patient_id\t\t= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;\n\n\t\tvar retVal\t\t\t\t=\t\"\";\n\t\tvar dialogTop\t\t\t=\t\"80\" ;\n\t\tvar dialogHeight\t\t=\t\"30\" ;\n\t\tvar dialogWidth\t\t\t=\t\"80\" ;\n\t\tvar status\t\t\t\t=\t\"no\";\n\t\tvar arguments\t\t\t=\t\"\" ;\n\t\tvar sql\t\t\t\t\t=\t\"\";\n\t\tvar search_code\t\t\t=\t\"\";\n\t\tvar search_desc\t\t\t=\t\"\";\n\t\tvar title\t\t\t\t=\t\"\";\n\t\tvar param\t\t\t\t=\t\"\";\n\t\tvar action_url\t\t\t=   \"\";\n\t\t\n\n\t\taction_url\t\t\t=\t\'../../eCA/jsp/RecClinicalNotesLinkHistMain.jsp\';\n\t\tvar features\t\t=\t\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status;\n\t\taction_url\t\t\t+=\t\"?result_linked_rec_type=\"+result_linked_rec_type+\"&episode_type=\"+episode_type+\"&encounter_id=\"+encounter_id+\"&patient_id=\"+patient_id;\n\n\t\tif(image_linked_yn==\'Y\')\n\t\t\tvar url = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.location.href;\n\t\telse\n\t\t\tvar\turl\t=\tparent.RecClinicalNotesSecDetailsFrame.location.href;\n\n\t\tif( (url.indexOf(\'/eCA/jsp/RTEditor.jsp\')!=-1) )\n\t\t{\n\t\t\tif(image_linked_yn==\'Y\')\n\t\t\t\tparent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.focus();\n\t\t\telse\n\t\t\t\tparent.RecClinicalNotesSecDetailsFrame.RTEditor0.focus();\n\t\t}\n\t\t\t\n\t\tretVal\t\t\t\t= await\twindow.showModalDialog(action_url,arguments,features);\n\t\t\n\t\tif (retVal != null)\n\t\t{\n\t\t\tif( (url.indexOf(\'/eCA/jsp/RTEditor.jsp\')==-1) )\n\t\t\t{\n\t\t\t\tawait swapHeaderValues();\n\t\t\t\tawait assignSectionDetails(sec_hdg_code,sec_content_type,child_sec_hdg_code, child_sec_content_type, result_linked_rec_type,\'sectionEdit\',doc_exists);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(image_linked_yn==\'Y\')\t\t\t\t\t\t\t\n\t\t\t\t\tvar txtRange\t\t\t=\tparent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.createTextRange();\n\t\t\t\telse\n\t\t\t\t\tvar txtRange\t\t\t=\tparent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.createTextRange();\n\t\t\t\t\n\t\t\t\tvar section_content\t=\ttxtRange.text;\n\n\t\t\t\tif(section_content.length>0)\n\t\t\t\t{\n\t\t\t\t\tif(result_linked_rec_type==\'CLNT\'||result_linked_rec_type==\'MEDN\'||result_linked_rec_type==\'ALGY\'||result_linked_rec_type==\'DIAG\' || result_linked_rec_type == \'PTCR\' || result_linked_rec_type == \'LBIN\' || result_linked_rec_type == \'LBRP\'|| result_linked_rec_type == \'RDIN\' || result_linked_rec_type == \'RDRP\' || result_linked_rec_type == \'SUNT\' || result_linked_rec_type == \'TRET\' )\n\t\t\t\t\t\tretVal\t= \"<br>\"+retVal;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\n\t\t\t\tif(result_linked_rec_type!=\"\" && result_linked_rec_type!=null)\n\t\t\t\t{\n\t\t\t\t\tif(image_linked_yn==\'Y\')\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.insertAdjacentHTML(\"BeforeEnd\",(retVal));\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.insertAdjacentHTML(\"BeforeEnd\",(retVal));\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(image_linked_yn==\'Y\')\n\t\t\t\t\t\tparent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.execCommand(\"paste\",\"\",retVal );\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.execCommand(\"paste\",\"\",retVal );\n\t\t\t\t}\t\t\t\n\t\t\t}\n\t\t}\n\n\t\tparent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc.disabled = false;\n}\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n <BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> \n<form name=\'RecClinicalNotesSecControlForm\' id=\'RecClinicalNotesSecControlForm\' method=\'post\' >\n\t<input type=\'hidden\' name=\'image_linked_yn\' id=\'image_linked_yn\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t<input type=\'hidden\' name=\'operation_mode\' id=\'operation_mode\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t<input type=\'hidden\' name=\'curr_section_type\' id=\'curr_section_type\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t<input type=\'hidden\' name=\'curr_result_link_type\' id=\'curr_result_link_type\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t<input type=\'hidden\' name=\"section_image_content\" id=\"section_image_content\" >\n\t<input type=\'hidden\' name=\"section_image_height\" id=\"section_image_height\" >  <!-- IN053298 -->\n\t<input type=\'hidden\' name=\"section_content\" id=\"section_content\" >\n\t<input type = \'hidden\' name = \'Field_Ref\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type = \'hidden\' name = \'contr_mod_accession_num\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type = \'hidden\' name=\'contr_oth_accession_num\' id=\'contr_oth_accession_num\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">  <!-- IN053733 -->\n\t<input type=\'hidden\' name=\'Sex\' id=\'Sex\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=\'hidden\' name=\'Dob\' id=\'Dob\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type=\'hidden\' name=\'dispResLinkHYMLYN\' id=\'dispResLinkHYMLYN\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'> <!-- //IN041284 -->\n\t<input type=\'hidden\' name=\'noteSplCharValidate\' id=\'noteSplCharValidate\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'> <!-- //IN059571 -->\n\t\t<input type=\'hidden\' name=\'accession_num_auto\' id=\'accession_num_auto\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=\'hidden\' name=\'prev_sec_hdg_code\' id=\'prev_sec_hdg_code\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'prev_child_sec_hdg_code\' id=\'prev_child_sec_hdg_code\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<!--IN071264-->\n</form>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<script>\n\tsetTimeout(\"parent.RecClinicalNotesToolbarFrame.document.forms[0].noteCopiedYN.value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\",1000);//IN068105\n</script>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<!-- <script language=\'javascript\'>\t-->\n\t\t\t<script>\n\t\t\t//IN041284 Start\n\t\t\t//var template_mode = \tshowSectionTemplate_new(\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\",\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\");\n\t\t\t//IN059571 Start.\n\t\t\t//var template_mode = \tshowSectionTemplate_new(\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\");\n\t\t\tvar template_mode = \tshowSectionTemplate_new(\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\");\n\t\t\t//IN059571 End.\n\t\t\t//IN041284 End.\t\t\t\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n\t\t<form name=\'GetEditorForm\' id=\'GetEditorForm\' method=\'post\' action=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\t\n\t\t\t<input type=\'hidden\' name=\'RTEText\' id=\'RTEText\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t<input type=\'hidden\' name=\'image_linked_yn\' id=\'image_linked_yn\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t<input type=\'hidden\' name=\'curr_sec_hdg_code\' id=\'curr_sec_hdg_code\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t<input type=\'hidden\' name=\'curr_child_sec_hdg_code\' id=\'curr_child_sec_hdg_code\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type=\'hidden\' name=\'curr_section_type\' id=\'curr_section_type\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t<input type=\'hidden\' name=\'curr_result_link_type\' id=\'curr_result_link_type\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t<input type=\'hidden\' name=\'curr_result_link_yn\' id=\'curr_result_link_yn\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<input type=\'hidden\' name=\'sec_hdg_code\' id=\'sec_hdg_code\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ModuleID\' id=\'ModuleID\' value=\'CA\'>\n\t\t\t\n\n\t\t</form>\n\t\t</body>\n</html>\n\t\t<script language=\'javascript\'>\t\t\t\n\t\t\tchangeEditorTitle_new(\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\");\n\t\t\tcallMeToGetEditor();\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t<script>\t\t\n\t\t\t\t\talert(getMessage(\"FILL_COMPONENT\",\'CA\'));\t\t\n\t\t\t\t\t\n\t\t\t\t\tvar curr_sec_hdg_code = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById(\"sec_hdg_code\").value;\n\t\t\t\t\t\n\t\t\t\t\tvar curr_section_type = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById(\"sec_content_type\").value;\n\t\t\t\t\t\n\t\t\t\t\tvar curr_child_sec_hdg_code = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById(\"child_sec_hdg_code\").value;\n\t\t\t\t\t\n\t\t\t\t\tvar editor_title = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById(\"template_title\").value;\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tassignSectionDetails(curr_sec_hdg_code,curr_child_sec_hdg_code,editor_title,\'\',\'sectionView\');\n\t\t\t\t\t\n\t\t\t\t\t//Newly added  by Name :Selvin M  Date :16 june 2011 INCIDENT NO: 27228 Changes:newly added Starts\n\t\t\t\t\tparent.RecClinicalNotesToolbarFrame.document.getElementById(\"display_view\").innerHTML =\'<b>Click on \"Notes View\" for \"Record\" & \"SIGN\" buttons</b>\';\n\t\t\t\t\t//Ends\n\t\t\t\t\tsetToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].sign,false);\t\n\t\t\t\t\tsetToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].record,false);\n\t\t\t\t\tsetToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].notesView,true);\t\t\t\t\t\t\t\n\t\t\t\t\tparent.frameSetIdMessage.rows=\'*%,0%\';\n\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\n\t\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar multi_sec_hdg_code = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_sec_hdg_code.value;\n\t\t\t\t\tvar noteCopiedYN = parent.RecClinicalNotesToolbarFrame.document.forms[0].noteCopiedYN.value//IN068105\n\t\t\t\t\t\tvar multi_child_sec_hdg_code = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_child_sec_hdg_code.value\n\t\t\t\t\t\tparent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record.disabled = false;//note missing changes\n\t\t\t\t\t\tparent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign.disabled = false;//note missing changes\n\t\t\t\t\t\t//parent.RecClinicalNotesSecDetailsFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&patient_id=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&encounter_id=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&appl_task_id=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&selection_type=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&multi_sec_hdg_code=\'+multi_sec_hdg_code+\'&multi_child_sec_hdg_code=\'+multi_child_sec_hdg_code;//Commented for IN068105\n\t\t\t\t\t\tparent.RecClinicalNotesSecDetailsFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&multi_sec_hdg_code=\'+multi_sec_hdg_code+\'&multi_child_sec_hdg_code=\'+multi_child_sec_hdg_code+\'&noteCopiedYN=\'+noteCopiedYN;//modified for IN068105\n\t\t\t\t\t\t</script>\t\t\t\t\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<script>\t\t\t\n\t\t\t//var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;IN035950\n\t\t\t//IN035950 Start\n\t\t\tif(undefined!=top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame)\n\t\t\t{//IN037701\n\t\t\tvar Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;\t\n\t\t\t}\n\t\t\t//IN035950 End\n\t\t\tvar note_title\t\t\t= \"\";\n\t\t\tvar med_service\t\t\t= \"\";\n\t\t\tvar event_date_time\t\t= \"\";\n\t\t\tvar performed_by_name\t= \"\";\n\n\t\t\tevent_date_time\t\t= Obj.event_date_time.value;\n\t\t\tperformed_by_name\t= Obj.performing_phy_name.value;\n\t\t\tnote_title\t\t\t= Obj.event_title_desc.value;\n\n\t\t\tif(Obj.serv_disp != null)\n\t\t\t\tmed_service\t\t\t= Obj.serv_disp.value;\n\n\t\t\t//var url =\'../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&episode_type=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&accession_num=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&patient_class=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&note_title=\'+encodeURIComponent(note_title)+\'&med_service=\'+encodeURIComponent(med_service)+\'&event_date_time=\'+event_date_time+\'&performed_by_name=\'+encodeURIComponent(performed_by_name); //[IN032721]\n\t\t\t//var url =\'../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&note_title=\'+encodeURIComponent(note_title)+\'&med_service=\'+encodeURIComponent(med_service)+\'&event_date_time=\'+event_date_time+\'&performed_by_name=\'+encodeURIComponent(performed_by_name)+\'&contr_mod_accession_num=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\';  //[IN032721]//IN053733\n\t\t\t//var url =\'../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&contr_oth_accession_num=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\';  //IN053733 //commented for IN068105\n\t\t\tvar url =\'../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&noteCopiedYN=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\';  //modified for IN068105\n\t\t\twindow.open(url,\'Document\',\'height=570,width=790,top=0,left=0,resizable=yes,scrollbars=yes\' );  \n\t\t\t\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t<script>\n\t\t\t\t\t//recordSectionDetails();//Commented for IN067607\n\t\t\t\t\trecordSectionDetails(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');//Modified for IN067607\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\n\t\t<script>\t\t\t\n\t\t\t//setTimeout(\"parent.RecClinicalNotesSecDetailsFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'\",1500);//Commented for IN068105\n\t\t\tsetTimeout(\"parent.RecClinicalNotesSecDetailsFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'\",1500);//modified for IN068105\n\t\t//setButtonsforOperations(\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\",true);\n\t\t</script>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n<script>\n<!-- IN057329 Start.  -->\t\nif (\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" != \"\" && \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"==\"Y\" && \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"==\"\" )\n{\n\tif(parent.RecClinicalNotesToolbarFrame.document.forms[0]!=null)  //INT-CA005_CA_Patient Assessment.docx  found issue which checking IE11\n\tsetToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Notes,true); \n}<!-- IN057329 End.  -->\t\n<!-- IN063931 Start.  -->\t\nif (\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"==\"\" )\n{\n\tif(parent.RecClinicalNotesToolbarFrame.document.forms[0]!=null)    \n\tsetToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Section,true);\n}\n<!-- IN063931 End.  -->\t\n</script>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );
	
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
//TBMC-SCF-0089 Start	
public String getDateBasedOnLocale(String date, String locale,String format) 
	{
	      String returnLocaledate ="";
	      try
				{
	    	      if(!"en".equals(locale))
	    	      {	  
					returnLocaledate  =  com.ehis.util.DateUtils.convertDate(date,format,"en",locale);	
	    	      }
	    	      else{
	    	    	  returnLocaledate = date;
	    	      }
				}
			catch(Exception e)
			{
				System.out.println("Exception  while geting SM_CONVERT_DATE_2T:"+e);
				e.printStackTrace();
			}
	     
		return returnLocaledate;
	}
	//TBMC-SCF-0089 End	


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
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100           ?          		created
14/07/2012	IN033487		Menaka V	 	CA> Record Clinical Note>After setup note to add 1 Note per
												Encounter but if users access to add same note in same time then system allow to record more than 1 note.							
17/12/2012  IN035950      	Nijitha        	CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.	
03/06/2013	IN040265		Ramesh G		Issue 1: At print preview the addendum details displayed as "Addendum Created by"  instead of "Addendum Recorded by"
												Issue 2: Addendum details  displayed twice.
03/06/2013	IN040266		Ramesh G		Issue 1: Record Clinical Notes->Search Tab->Update->System is displaying the updated text in different font in Print Preview and Print.
												Issue 2: Chart Summary->Lab Results->Note Type text data is displayed in different font.
												Issue 3: OT Surgeon Notes->System is displaying the text in different font in Print Preview and Print.
05/09/2013	IN043083		Chowminya G		Issue With NRIC in Medical Certificate Function													
17/12/2013	IN044085		Ramesh G		Bru-HIMS-CRF-024.2 										 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G		30/04/2014		Sunil KV		The alignment for result Link for laboratory? results in a clinical note section template does not display neatly .	
02/06/2014	  IN037701		Nijitha											SKR-CRF-0036
05/05/2015	IN053298		Ramesh G		05/05/2015		Akbar S			When we attach an image to the clinical note part of the image is not displayed.
12/05/2015	IN053733		Ramesh G										Bru-HIMS-CRF-024.3
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template 
04/09/2015	IN057329		Ramesh G										In Modify Mode, when a note is having a single section,Copy from previous note button is not available.
01/02/2015 INT-CA005_CA	RAJA S											Script Error found issue which checking IE11 in Patient Assessment
13/05/2016		IN059571	Ramesh G										Problem:Lab & Radiology Results are not transferring to CA screen, from yesterday nigh the background job was running.
22/01/2018	IN063931		Prakash C		23/01/2018		Ramesh			KDAH-CRF-0431(Copy previous section)
15/02/2018	 IN063799		Prakash C		15/02/2018		Ramesh			ML-MMOH-CRF-0808
22/05/2018	 IN067607		Raja S			22/05/2018		Ramesh G		ML-MMOH-CRF-1130.2
27/07/2018	IN068105		Raja S			27/07/2018		Ramesh G		MMS-DM-CRF-0143
24/09/2018	IN068725		Raja S			24/09/2018		Ramesh G		MMS-ICN-00102
06/09/2019	IN071335	   	Ramesh G										Common-ICN-0012
9/9/2019	IN071291		Nijitha s		9/9/2019		Ramesh G		TBMC-SCF-0089
18/03/2020	IN071264		Nijitha S									GHL-CRF-0604
27/05/2020		IN072879		SIVABAGYAM M		27/05/2020		RAMESH G		MMS-DM-SCF-0688
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	eCA.PatientBannerGroupLine manageEmailBean = null; //IN052940

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	
	String		prev_sec_content_type					= "";
	String 		prev_sec_hdg_code						= "";
	String 		prev_child_sec_hdg_code					= "";
	String 		prev_result_link_type					= "";
	String 		ageDependentCompIds						= "";
	String 		compDependentAgeGrps					= "";
	String 		patient_id								= "";
	String 		ageDependentResults						= "";
	String 		no_of_rows								= "";
	String 		section_content							= "";
	String 		prev_image_linked_yn					= "";
	String 		prev_populated_section_tblrowID			= "";
	String 		strContentEditableYn					= "";
	String 		curr_section_type						= "";
	String 		url_for_details_frame					= "";
	String 		image_view_counter						= "";
	String 		encounter_id							= "";
	String 		template_title							= "";
	String 		curr_sec_hdg_code						= "";
	String 		curr_child_sec_hdg_code					= "";
	String 		grid_component_ids						= "";
	String 		section_image_content					= "";
	String 		section_image_height					= "";  //IN053298
	String 		curr_image_linked_yn					= "";
	String 		sec_content_type						= "";
	String 		editor_title							= "";
	String 		operation_mode							= "";
	String 		note_type								= "";
	String 		image_edited_yn							= "";
	String 		curr_result_link_type					= "";
	String 		curr_result_link_yn						= "";
	String		patient_class							= "";
	String		accession_num							= "";
	String		episode_type							= "";
	String		strRecFlag								= "";
	String		strKey									=	"";
	String		field_ref								=	"";
	String		contr_mod_accession_num					=	"";
	String 		contr_oth_accession_num					=	"";
	String		Sex										=	"";
	String		Dob										=	"";
	String		module_id								=	"";
	String		xslURL1  								=	"";
	String		xslURL									=	"";
	String		appl_task_id							=	"";
	String		selection_type							=	"";
	String		clear_values							=	"";
	String 		dispResLinkHYMLYN						=	""; //IN041284
	String 		noteSplCharValidate						=	"N"; //IN059571
	String		myHIXYN								=	"N";//IN067607
	Properties tempProp = null;
	String chk_Empty = "";
	Connection con = null;
	//IN033487 Starts
	//Connection con1 = null;commented for checkstyle
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	//String note_group_id = "";commented for checkstyle
	//String no_of_rec_per_enc = "";commented for checkstyle
	//int record_cnt_for_enc = 0;commented for checkstyle
	//boolean search_screen_activated = false;commented for checkstyle
	//String msgfrom = "";commented for checkstyle
	String facility_id = "";
	//IN033487 ends
	String resp_id	= "";	//IN052940
	String previousNote_accession_num = "";  //IN052940
	String ca_disp_copy_prev_notes_yn = "";  //IN052940
	String call_for_copy_previous_sec 	= "";//IN063931
	String call_for_copy_previous_note 	= "";//IN063931
	String ca_disp_copy_prev_section_yn ="";//IN063931
	String display="";//IN063799
	String noteCopiedYN = "";//IN068105
	String speciality_name="",location_code="";//IN072879
//	int			exc										=	0;
//	int			exc1									=	0;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	facility_id		=	(String)session.getValue("facility_id");//IN033487
	resp_id		=	(String)session.getValue("responsibility_id");
	strRecFlag							=		checkForNull(request.getParameter("rec_flag"));
	prev_sec_hdg_code					=		checkForNull(request.getParameter("prev_sec_hdg_code"));
	prev_child_sec_hdg_code				=		checkForNull(request.getParameter("prev_child_sec_hdg_code"));
	patient_id							=		checkForNull(request.getParameter("patient_id"));
	section_content						=		checkForNull(request.getParameter("section_content"));
	prev_populated_section_tblrowID		=		checkForNull(request.getParameter("prev_populated_section_tblrowID"));
	image_view_counter					=		checkForNull(request.getParameter("image_view_counter"));
	encounter_id						=		checkForNull(request.getParameter("encounter_id"));
	template_title						=		checkForNull(request.getParameter("template_title"));
	curr_sec_hdg_code					=		checkForNull(request.getParameter("curr_sec_hdg_code"));
	curr_child_sec_hdg_code				=		checkForNull(request.getParameter("curr_child_sec_hdg_code"));
	grid_component_ids					=		checkForNull(request.getParameter("grid_component_ids"));
	section_image_content				=		checkForNull(request.getParameter("section_image_content"));
	section_image_height				= 		checkForNull(request.getParameter("section_image_height"));	//IN053298
	editor_title						=		checkForNull(request.getParameter("editor_title"));
	operation_mode						=		checkForNull(request.getParameter("operation_mode"));
	note_type							=		checkForNull(request.getParameter("note_type"));
	image_edited_yn						=		checkForNull(request.getParameter("image_edited_yn"));
	no_of_rows							=		checkForNull(request.getParameter("no_of_rows"));
	patient_class						=		checkForNull(request.getParameter("patient_class"));
	accession_num						=		checkForNull(request.getParameter("accession_num"));
	String accession_num_auto = checkForNull(request.getParameter("accession_num_auto"));//IN071264
	episode_type						=		checkForNull(request.getParameter("episode_type"));
	field_ref							=		checkForNull( request.getParameter("Field_Ref")	);
	noteCopiedYN						=		checkForNull( request.getParameter("noteCopiedYN")	); //IN068105
	speciality_name						=		checkForNull( request.getParameter("speciality_name")	); //IN072879	
	location_code						=		checkForNull( request.getParameter("location_code")	); //IN072879
	
	contr_mod_accession_num				=		checkForNull( request.getParameter("contr_mod_accession_num")	);
	contr_oth_accession_num				=		checkForNull( request.getParameter("contr_oth_accession_num")	); //IN053733
	Sex				=		checkForNull( request.getParameter("Sex")	);
	Dob				=		checkForNull( request.getParameter("Dob")	);
	module_id		=		checkForNull( request.getParameter("module_id")	);
	appl_task_id		=		checkForNull( request.getParameter("appl_task_id"));
	selection_type		=		checkForNull( request.getParameter("selection_type"));
	chk_Empty		=		request.getParameter("chk_Empty")==null?"false":request.getParameter("chk_Empty");
	clear_values		=		request.getParameter("clear_values")==null?"":request.getParameter("clear_values");
	dispResLinkHYMLYN	=	request.getParameter("dispResLinkHYMLYN")==null?"N":(String)request.getParameter("dispResLinkHYMLYN"); //IN041284
	noteSplCharValidate	=	request.getParameter("noteSplCharValidate")==null?"N":(String)request.getParameter("noteSplCharValidate"); //IN059571
	myHIXYN			=	request.getParameter("myHIXYN")==null?"N":(String)request.getParameter("myHIXYN"); //IN067607
	previousNote_accession_num = checkForNull( request.getParameter("previousNote_accession_num"));		 //IN052940
	call_for_copy_previous_sec	   = checkForNull( request.getParameter("call_for_copy_previous_sec"));//IN063931
	call_for_copy_previous_note	   = checkForNull( request.getParameter("call_for_copy_previous_note"));//IN063931
	display   =request.getParameter("display")==null?"Y":request.getParameter("display"); //IN063799
	if (encounter_id.equals(""))
		encounter_id = "0";
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session); //IN052940
	manageEmailBean.clearBean(); //IN052940
	ca_disp_copy_prev_notes_yn = manageEmailBean.getCopyPreviousNotesYN(resp_id, locale,note_type);
	ca_disp_copy_prev_section_yn = manageEmailBean.getCopyPreviousSectionYN(resp_id, locale,note_type);//IN063931
	// IN071335 Changes Start.
	//xslURL   = HttpUtils.getRequestURL(request).toString();
	//xslURL = xslURL.substring(0,xslURL.indexOf("jsp/"));
	xslURL	=  application.getRealPath("/eCA/")+"/";	
	// IN071335 Changes End.
	xslURL1 = xslURL + "html/RecClinicalNotesTemplateDispayView.xsl";
	


	try
	{
		//excepThrow();

		//exc1 = exc/0;
	
		con	= ConnectionManager.getConnection(request);
		
		strKey	= patient_id + "~"+encounter_id;
		strKey = strKey.trim();

		tempProp = sectionBean.getPatientSection(strKey);
			
		StringBuffer sectionContentXML	=	new StringBuffer();
		StringBuffer sbSecFormat		=	new StringBuffer();
		StringBuffer sbOutFormat		=	new StringBuffer();
		
		String contentXML="";
		StringBuffer contentOutXML = new StringBuffer();

		Hashtable htParameter=new Hashtable();
		Hashtable htPatdet=new Hashtable();
		Hashtable htOutParameter ;
		if(!(prev_sec_hdg_code.equals("")) || !(prev_child_sec_hdg_code.equals("")))
		{
			prev_sec_content_type		= sectionBean.getSectionType(prev_sec_hdg_code,prev_child_sec_hdg_code);
			
			prev_result_link_type		= sectionBean.getResultLinked(prev_sec_hdg_code,prev_child_sec_hdg_code);
			prev_image_linked_yn		= sectionBean.getImageLinked(prev_sec_hdg_code,prev_child_sec_hdg_code);
			
		}
		
		if(!(curr_sec_hdg_code.equals("")) || !(curr_child_sec_hdg_code.equals("")))
		{
			curr_section_type		= sectionBean.getSectionType(curr_sec_hdg_code,curr_child_sec_hdg_code);			
			curr_image_linked_yn	= sectionBean.getImageLinked(curr_sec_hdg_code,curr_child_sec_hdg_code);
			curr_result_link_yn		= sectionBean.getResultLinked(curr_sec_hdg_code,curr_child_sec_hdg_code);
			curr_result_link_type	= sectionBean.getHistoryType(curr_sec_hdg_code,curr_child_sec_hdg_code);
			
		}
		//IN068105 starts
		PreparedStatement psEncNote = null;
		ResultSet rsEncNote = null;
		try{

			psEncNote =	con.prepareStatement("SELECT NOTES_COPIED_YN FROM CA_ENCNTR_NOTE WHERE ACCESSION_NUM=?");
			psEncNote.setString(1,accession_num);			
			rsEncNote	= psEncNote.executeQuery();		
			if(rsEncNote.next())
			{
				noteCopiedYN=rsEncNote.getString("NOTES_COPIED_YN")==null?"N":rsEncNote.getString("NOTES_COPIED_YN");//IN068725
			}
		}
		catch(Exception m){
				m.printStackTrace();
		}
		finally{
					if(rsEncNote!=null) rsEncNote.close();
					if(psEncNote!=null) psEncNote.close();
		}
		//IN068105 ends
		if(prev_sec_content_type.equals("T"))
		{
			try
			{
			
			Enumeration enumParameter=request.getParameterNames();
			
			String parameterName="";
			String parameterValue="";
					
			while(enumParameter.hasMoreElements())
			{
				parameterName=(String)enumParameter.nextElement();
				
				parameterValue = request.getParameter(parameterName)==null?"":request.getParameter(parameterName);
				htParameter.put(parameterName, parameterValue);
				
			}
			
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				
			}
			
			htOutParameter = new Hashtable(htParameter);

			eCA.DomParser parser = new eCA.DomParser();
		
			contentXML=(String)sectionBean.getSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code);
						
		//	eCA.DomParser outparser = new eCA.DomParser();

			try
			{
				//con	= ConnectionManager.getConnection(request);

				if (contentXML == null || contentXML.equals("") )
				{
					contentXML = "";
					PreparedStatement psSec = null;
					ResultSet rsSec = null;
			
					String strSecGetQuery = "Select AGE_GRP_DEP_COMP_INFO,DEP_AGE_GRP_INFO,TEMPLATE_FORMAT from CA_SECTION_HDG where sec_hdg_code = ? ";
			
					psSec =	con.prepareStatement(strSecGetQuery);
					psSec.setString(1,prev_child_sec_hdg_code);			
					rsSec	= psSec.executeQuery();		
						
					if(rsSec.next())
					{
						ageDependentCompIds		= rsSec.getString(1)==null?"":rsSec.getString(1); 
						compDependentAgeGrps	= rsSec.getString(2)==null?"":rsSec.getString(2);
						Clob clb = rsSec.getClob(3);				
					
						if(clb!=null)
						{
							java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
							String line = null;
							
							while((line=r.readLine()) != null) 
							{
								sbSecFormat.append(line);
							}
						}
					}
					//check for the age group dependency and call a function to delete the component from the XML by parsing it
					if(rsSec!=null) rsSec.close();
					if(psSec!=null) psSec.close();

					PreparedStatement psage = null;
					ResultSet rsage = null;
	
					if(!ageDependentCompIds.equals(""))
					{
						String functionSQL = "Select ca_comp_visibility(?,?) from dual";
						psage =con.prepareStatement(functionSQL);

						psage.setString(1,compDependentAgeGrps);
						psage.setString(2,patient_id);
						rsage = psage.executeQuery();

						if(rsage.next())
						{
							ageDependentResults = rsage.getString(1);
							eCA.AgeGroupCodeDependencyParser ageGroupBeanObj=new eCA.AgeGroupCodeDependencyParser();
							sbSecFormat = ageGroupBeanObj.removeAgeDependentComponents(sbSecFormat,ageDependentCompIds,ageDependentResults);
						}
					}
					if(rsage!=null) rsage.close();
					if(psage!=null) psage.close();
				
					contentXML = sbSecFormat.toString();
				}
				if(!grid_component_ids.equals(""))
				{			
					eCA.GridComponent gridComp = new eCA.GridComponent();			
					contentXML = gridComp.updateXML(no_of_rows, contentXML).toString();			
					gridComp = null;
				}
				if (contentXML!= null && !contentXML.equals("") &&  clear_values.equals("clearTemplateValues"))
				{	
					htParameter = parser.clearComponentValues(new StringBuffer(contentXML),htParameter);
					htOutParameter = htParameter;
					
					//htParameter.clear();
					sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
				}

				sectionContentXML.append(contentXML);	
				StringBuffer sectionContentUpdatedXML=new StringBuffer();
				if(!sectionContentXML.toString().equals("") && sectionContentXML != null && !clear_values.equals("clearTemplateValues"))
				{ 						
					chk_Empty = parser.isTemplateEmpty(sectionContentXML,htParameter);							
					if(operation_mode.equals("") && chk_Empty.equals("false"))
					{						
						sectionBean.removeSectionContent( prev_sec_hdg_code,prev_child_sec_hdg_code);
					}
					
					
				//Added By Sridhar Reddy V on 13/05/2010 to restrict recording empty section.
					if(chk_Empty.equals("true"))
					{
						//***************************** [CRF-118] Start *****************************					
						eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
						HashMap paramHash=new HashMap();
						Hashtable tempParameter=new Hashtable();
						paramHash.put("#p_patient_id#",patient_id);
						paramHash.put("#p_encounter_id#",encounter_id);
						paramHash.put("#p_accNum#",accession_num);
						paramHash.put("#p_locale#",locale);
						tempParameter = dynamicCompDetails.getDynamicCompDetails(sectionContentXML,paramHash);
						if(tempParameter.size()>0){					
						htParameter.putAll(tempParameter);
						}
						//*****************************[CRF-118] Ends *****************************
						sectionContentUpdatedXML=parser.updateXMLContentValues(sectionContentXML,htParameter,locale);
						//sectionContentUpdatedXML=parser.removeEmptyValuesGridComp(sectionContentUpdatedXML); //Missing Grid rows
						sectionContentUpdatedXML=parser.displayGridCompYN(display,no_of_rows,sectionContentUpdatedXML);//IN063799
						sectionContentUpdatedXML=parser.displayMatrixCompYN(display,sectionContentUpdatedXML);//IN063799
					}
					
				}
				parser=null;				
				
				


				// new changes
					PreparedStatement pstmt = null;
					ResultSet rs = null;
				String output_yn =  "";

				output_yn = sectionBean.getOutputExistYN(prev_sec_hdg_code,prev_sec_hdg_code);
				if(output_yn.equals("Y") && !clear_values.equals("clearTemplateValues") && !sectionContentUpdatedXML.equals(""))
				{
					String output_format_qry ="select OUTPUT_XML_FORMAT from  CA_SEC_OUTPUT_FORM b where b.SEC_HDG_CODE =?" ;
					pstmt=	con.prepareStatement(output_format_qry);
					pstmt.setString(1,prev_sec_hdg_code);	
					rs	= pstmt.executeQuery();	

					if(rs.next())
					{
						
						Clob clb1 = rs.getClob("OUTPUT_XML_FORMAT");				
					
						if(clb1!=null)
						{
							java.io.BufferedReader r = new java.io.BufferedReader(clb1.getCharacterStream());
							String line = null;
							
							while((line=r.readLine()) != null) 
							{
								sbOutFormat.append(line);
							}
						}
					}
					
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					contentOutXML = sbOutFormat;

				}
				StringBuffer contentOutUpdatedXML = new StringBuffer();
				
				
				
			
			//	htParameter.put("C_MRFROM2","abcd");
			//	htParameter.put("C_MRTO3","efgh");
			
				
				htPatdet = sectionBean.getPatOutDetails(patient_id);
				
				if(htPatdet!=null)
				{
					htOutParameter.put("PATIENT_ID",htPatdet.get("PATIENT_ID"));
					htOutParameter.put("PATIENT_NAME",htPatdet.get("PATIENT_NAME"));
					//htOutParameter.put("REGN_DATE",htPatdet.get("REGN_DATE"));//TBMC-SCF-0089 Commented
					htOutParameter.put("REGN_DATE",getDateBasedOnLocale((String)htPatdet.get("REGN_DATE"),locale,"DMY"));//TBMC-SCF-0089
					htOutParameter.put("GENDER",htPatdet.get("GENDER"));
					htOutParameter.put("RESIDENTAIL_ADDRESS",htPatdet.get("RESIDENTAIL_ADDRESS"));
					htOutParameter.put("AGE",htPatdet.get("AGE"));
					htOutParameter.put("FACILITY_NAME",htPatdet.get("FACILITY_NAME"));
					//htOutParameter.put("DATE_OF_BIRTH",htPatdet.get("DATE_OF_BIRTH"));//TBMC-SCF-0089 Commented
					htOutParameter.put("DATE_OF_BIRTH",getDateBasedOnLocale((String)htPatdet.get("DATE_OF_BIRTH"),locale,"DMY"));//TBMC-SCF-0089
					htOutParameter.put("MAR_STATUS_CODE",htPatdet.get("MAR_STATUS_CODE"));
					htOutParameter.put("NATIONALITY_CODE",htPatdet.get("NATIONALITY_CODE"));
					htOutParameter.put("RH_FACTOR",htPatdet.get("RH_FACTOR"));
					htOutParameter.put("BLOOD_GRP",htPatdet.get("BLOOD_GRP"));
					htOutParameter.put("RES_AREA_CODE",htPatdet.get("RES_AREA_CODE"));
					htOutParameter.put("RES_TOWN_CODE",htPatdet.get("RES_TOWN_CODE"));
					htOutParameter.put("RELGN_CODE",htPatdet.get("RELGN_CODE"));
					htOutParameter.put("NAME_PREFIX",htPatdet.get("NAME_PREFIX"));
					htOutParameter.put("REGION_CODE",htPatdet.get("REGION_CODE"));
					htOutParameter.put("ENCOUNTER_ID",htPatdet.get("ENCOUNTER_ID"));
					htOutParameter.put("CURRENT_LOCATION",htPatdet.get("CURRENT_LOCATION"));
					htOutParameter.put("ATTENDING_PRACTITIONER",htPatdet.get("ATTENDING_PRACTITIONER"));
					//htOutParameter.put("ADMISSION_DATE",htPatdet.get("ADMISSION_DATE"));//TBMC-SCF-0089 Commented
					htOutParameter.put("ADMISSION_DATE",getDateBasedOnLocale((String)htPatdet.get("ADMISSION_DATE"),locale,"DMYHM"));//TBMC-SCF-0089 
					htOutParameter.put("SPECIALITY",htPatdet.get("SPECIALITY"));
					htOutParameter.put("PATIENT_CLASS",htPatdet.get("PATIENT_CLASS"));
					htOutParameter.put("ROOM_NUM",htPatdet.get("ROOM_NUM"));
					htOutParameter.put("BED_NUM",htPatdet.get("BED_NUM"));
					htOutParameter.put("SERVICE_CODE",htPatdet.get("SERVICE_CODE"));
					htOutParameter.put("ATT_PRACT_WITH_CREDENTIAL",htPatdet.get("ATT_PRACT_WITH_CREDENTIAL"));
					htOutParameter.put("PATIENT_NRIC",htPatdet.get("PATIENT_NRIC"));//IN043083

				}
				if(!contentOutXML.toString().equals("") && contentOutXML != null)
				{ 
					if(parser==null)
					{
						parser = new eCA.DomParser();	
					}								
					contentOutUpdatedXML=parser.updateXMLOutContentValues(sectionContentUpdatedXML,contentOutXML,htOutParameter,locale,xslURL1);								
				}
			

				String prev_sec_hdg_code_out ="";
				String prev_child_sec_hdg_code_out ="";

				prev_sec_hdg_code_out = prev_sec_hdg_code+"_out";
				prev_child_sec_hdg_code_out = prev_child_sec_hdg_code+"_out";

				
				


				// new changes ends..
				
				
				parser=null;
				sectionBean.setSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code,sectionContentUpdatedXML.toString());
				sectionBean.setSectionValues(prev_sec_hdg_code_out,prev_child_sec_hdg_code_out,"T","N","N","N","N","","N","N", contentOutUpdatedXML.toString(),"",output_yn);
				

			putObjectInBean("sectionBean",sectionBean,session);		
			}
			catch(Exception ex)
			{
				//out.println("Exception @ RecClinicalemplateCtrl"+ex.toString());//COMMON-ICN-0181
				ex.printStackTrace();
			}
			
		}//end of Template Based Sections
		else if(prev_sec_content_type.equals("F") || prev_sec_content_type.equals("R"))
		{			
			if(!(section_content.equals("")) )
			{				
				sectionBean.setSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code, "<ADDRESS>"+section_content+"<ADDRESS>"); //IN040265,IN040266
			}
			else if (section_content.equals("")&&( !(appl_task_id.equals("PAT_MEDICAL_REPORT")&&selection_type.equals("M"))) )
			{				
				sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
			}
			
			if(prev_image_linked_yn.equals("Y") && image_edited_yn.equals("Y")){
				sectionBean.setSectionImageContent(prev_sec_hdg_code,prev_child_sec_hdg_code,section_image_content);
				sectionBean.setSectionImageHeight(prev_sec_hdg_code,prev_child_sec_hdg_code,section_image_height);		//IN053298
			}
			putObjectInBean("sectionBean",sectionBean,session);
		}

		if(!section_content.equals("") && !prev_populated_section_tblrowID.equals(""))
		{
			out.println("<script>");
			out.println("var tblrow_id = eval(\"parent.RecClinicalNotesSectionFrame.document." + prev_populated_section_tblrowID + "\");");
			out.println("if(tblrow_id != null)");
			out.println("{");
			out.println("tblrow_id.cells(0).className = \"POPULATED_SECTION\";");
			out.println("}");
			out.println("</script>");
		}
		//IN052940 Start.
		if(!"".equals(previousNote_accession_num) && !"undefined".equals(previousNote_accession_num)){			
			//IN063931 start
			/*sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
			String	sql = "SELECT SEC_HDG_CODE,SUBSEC_HDG_CODE,NOTES_SECTION_CONTENT FROM CA_ENCNTR_NOTE_SECTION WHERE ACCESSION_NUM = ?";	
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1,previousNote_accession_num);*/
			
			if("Y".equals(call_for_copy_previous_note))
			{
				sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
				String	sql = "SELECT SEC_HDG_CODE,SUBSEC_HDG_CODE,NOTES_SECTION_CONTENT FROM CA_ENCNTR_NOTE_SECTION WHERE ACCESSION_NUM = ?";
	
				pstmt1 = con.prepareStatement(sql);
				pstmt1.setString(1,previousNote_accession_num);
			}
			if("Y".equals(call_for_copy_previous_sec))
			{
				sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
				String	sql_sec = "SELECT SEC_HDG_CODE,SUBSEC_HDG_CODE,NOTES_SECTION_CONTENT FROM CA_ENCNTR_NOTE_SECTION WHERE ACCESSION_NUM = ? and SEC_HDG_CODE= ?";
			
				pstmt1 = con.prepareStatement(sql_sec);
				pstmt1.setString(1,previousNote_accession_num);
				pstmt1.setString(2,prev_sec_hdg_code);
			}
			//IN063931 ends
			rs1 = pstmt1.executeQuery();			
			java.sql.Clob			clob_content	= null;
			while(rs1.next()){	
				String clobData="";			
				clob_content = (java.sql.Clob) rs1.getObject("NOTES_SECTION_CONTENT");
				if(clob_content!=null && clob_content.length() > 0){
					clobData = clob_content.getSubString(1,( (int)clob_content.length() ));
				}				
				sectionBean.setSectionContent((String) rs1.getString("SEC_HDG_CODE"),(String) rs1.getString("SUBSEC_HDG_CODE"),clobData);				
			}		
			
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
		
		}
		//IN052940 End.
	}
	
	catch(Exception e)
	{
		
		e.printStackTrace();
	}finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	
	// this code takes care of the display part of the current section.......
	try
	{
		section_content = "";		
		//IN071264 Starts
		String section_content_autosave_temp = "";
		String auto_save_yn ="N";
		CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
		auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
		//IN071264 Ends
		if(!curr_sec_hdg_code.equals("") && !curr_child_sec_hdg_code.equals(""))
		{
			/* section_content = (java.lang.String) sectionBean.getSectionContent(curr_sec_hdg_code,
					curr_child_sec_hdg_code); *///IN071264 
			 if("Y".equals(auto_save_yn) &&  (operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") || 
					operation_mode.equals("UpdateRecord") )){
				section_content_autosave_temp = (java.lang.String) sectionBean.getSectionContent("temp"+curr_sec_hdg_code,
						"temp"+curr_child_sec_hdg_code);
			}
			if(null!=section_content_autosave_temp && !"".equals(section_content_autosave_temp)){
				section_content = section_content_autosave_temp;
			}
			else{
				section_content = (java.lang.String) sectionBean.getSectionContent(curr_sec_hdg_code,
					curr_child_sec_hdg_code);
			}
			if(section_content == null || section_content.equals("") )
				section_content = "";
			
			section_content			=	java.net.URLEncoder.encode(section_content,"UTF-8");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_image_linked_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(curr_section_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(curr_result_link_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(field_ref));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(contr_oth_accession_num ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dispResLinkHYMLYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(noteSplCharValidate));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(accession_num_auto));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(prev_sec_hdg_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prev_child_sec_hdg_code));
            _bw.write(_wl_block26Bytes, _wl_block26);

//IN068105
if(noteCopiedYN.equals("Y")){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(noteCopiedYN));
            _bw.write(_wl_block28Bytes, _wl_block28);

}
//IN068105
	if(curr_section_type.equals("T"))
	{		
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(curr_section_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(editor_title));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(curr_section_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(editor_title));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(dispResLinkHYMLYN));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(curr_section_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(editor_title));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(dispResLinkHYMLYN));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(noteSplCharValidate));
            _bw.write(_wl_block33Bytes, _wl_block33);

	}
	else if(curr_section_type.equals("F") || curr_section_type.equals("R"))
	{		
		
		if(curr_image_linked_yn.equals("Y"))
		{
			url_for_details_frame = "../../eCA/jsp/RecClinicalNotesEditorsFrame.jsp?content_editable_yn="+strContentEditableYn+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&editor_param=I";
		}else if(appl_task_id.equals("PAT_MEDICAL_REPORT")&&selection_type.equals("M"))
		{
			
			url_for_details_frame = "../../eCA/jsp/RecClinicalNotesSectionView.jsp?note_type="+note_type+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&appl_task_id="+appl_task_id+"&selection_type="+selection_type;
				//+"&multi_sec_hdg_code="+multi_sec_hdg_code+"&multi_child_sec_hdg_code="+multi_child_sec_hdg_code;
		}
		else {
			
			url_for_details_frame = "../../eCA/jsp/RTEditor.jsp?content_editable_yn="+strContentEditableYn+"&editor_param=R";
		}
		putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session); //IN052940	
		
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(url_for_details_frame));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(section_content));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(curr_image_linked_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(curr_section_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(curr_result_link_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(curr_result_link_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sec_content_type.equals("S")?curr_child_sec_hdg_code:curr_sec_hdg_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(editor_title));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(curr_image_linked_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);

	}
	else if(operation_mode.equals("sectionView"))
	{ 			
		if(chk_Empty.equals("false") && prev_sec_content_type.equals("T") && !clear_values.equals("clearTemplateValues")){
		
		
            _bw.write(_wl_block45Bytes, _wl_block45);
 }else{ 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(selection_type));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(selection_type));
            _bw.write(_wl_block52Bytes, _wl_block52);
			
			}
	}
	else if(operation_mode.equals("Preview"))
	{		
		
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(contr_mod_accession_num ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(contr_mod_accession_num ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(contr_oth_accession_num));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(contr_oth_accession_num));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(noteCopiedYN));
            _bw.write(_wl_block63Bytes, _wl_block63);

	}
	else if(strRecFlag.equals("") && (operation_mode.equals("Record") || operation_mode.equals("Sign") || operation_mode.equals("ModifySection")) )
	{
		
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(myHIXYN));
            _bw.write(_wl_block65Bytes, _wl_block65);

		
		
		
		
	}else if(operation_mode.equals("Update")) {  
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(noteCopiedYN));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(ca_disp_copy_prev_notes_yn));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(ca_disp_copy_prev_section_yn));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block74Bytes, _wl_block74);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RichTextEditor.label", java.lang.String .class,"key"));
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
}
