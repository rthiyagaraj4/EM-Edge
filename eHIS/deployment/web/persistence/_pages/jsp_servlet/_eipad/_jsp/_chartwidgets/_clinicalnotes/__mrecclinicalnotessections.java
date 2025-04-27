package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesSectionItem;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesSectionListResponse;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import java.text.SimpleDateFormat;
import eCA.HeaderDomParser;
import java.io.Reader;
import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisSetHO;
import java.util.ResourceBundle;
import java.util.*;
import java.io.*;
import com.google.gson.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSetResponse;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesSectionFields;
import eIPAD.chartsummary.common.healthobject.PatContext;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;
import java.awt.image.BufferedImage;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __mrecclinicalnotessections extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSections.jsp", 1709118015568L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\n<style>\n.addendumSectionClass{\n\tbottom: 6px !important;\n    position: fixed !important;\n    width: 98.3% !important;  \n}\n</style>\n\n<script>\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\nvar path;\n\nvar subSectionListScroll;\nfunction assignSubSectionListScroll(sectCode) {\n\tif(subSectionListScroll){\n\t\tsubSectionListScroll.destroy();\n\t}\n\tsubSectionListScroll = new IScroll(\'#clinicalNotesSubsectionWrap_\'+sectCode, { \n\t\tscrollX: true, \n\t\tscrollY: false, \n\t\tscrollbars: false,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true,\n\t\tuseTransition: false,\n\t\tbindToWrapper: true\n\t\t/* interactiveScrollbars: true,\n\t\tshrinkScrollbars: \'scale\',*/\n\t\t/* fadeScrollbars: true  */\n\t});\n\tsubSectionListScroll.refresh();\n}\n\n\nvar clinicalNotesSectListScroll;\nfunction assignclinicalNotesSectListScroll() {\n\tclinicalNotesSectListScroll = new IScroll(\'#ClinicalNotesSectListWrap\', { \n\t\tscrollX: true, \n\t\tscrollY: false, \n\t\tscrollbars: false,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true,\n\t\tuseTransition: false,\n\t\tbindToWrapper: true\n\t\t/* interactiveScrollbars: true,\n\t\tshrinkScrollbars: \'scale\',*/\n\t\t/* fadeScrollbars: true  */\n\t});\n\tclinicalNotesSectListScroll.refresh();\n}\n\n\n\n\n\n$(document).ready(function () {\n\tdocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\t\n\tpath = document.getElementById(\"hdnPath\").value;\n\tassignclinicalNotesSectListScroll();\n\t//assignSubSectionListScroll();\n\tif(clinicalNotesSectListScroll)\n\t\tclinicalNotesSectListScroll.refresh();\n\t\n\topenFirstSectionByDefault();\n\t$(\"#CNActionBtnPreviewNote\").on(\'click\',function(){\t\t\n\t\t $(\"#addendumHeader\").hide();\n\t});\n});\n\nfunction openFirstSectionByDefault(){\n\tvar firstNoteSection = $(\"[data-first_note_section=\'true\']\");\n\tvar firstNoteSectionId = firstNoteSection.attr(\"id\");\n\tvar jsObjOfFirstSection = document.getElementById(firstNoteSectionId);\t\n\tvar event_status_code = $(\"#event_status_code\").val();\n\tvar operationMode= document.getElementById(\"hdnOpMode\").value;\n\tif(operationMode == \"ModifyAddendum\" && event_status_code != \"1\"){\n\t\t $(\"#addendumHeader\").show();\n\t\topenNoteSectionAddendum(jsObjOfFirstSection);\n\t}\n\telse{\n\topenNoteSection(jsObjOfFirstSection);\n\t $(\"#addendumHeader\").hide();\n\t}\n}\n\n\n\n\n \n var bExpanded = true;\n function toggleMenu() {\n\n\t\tif (bExpanded) {\n\t\t\t$(\'#divMenu\').animate({\n\t\t\t\twidth : \"0%\"\n\t\t\t}, \'slow\');\n\t\t\t$(\'#divContent\').animate({\n\t\t\t\twidth : \"100%\"\n\t\t\t}, \'slow\');\n\t\t\tdocument.getElementById(\"mb\").style.display = \"none\";\n\t\t\tdocument.getElementById(\"mh\").style.display = \"none\";\n\t\t\tdocument.getElementById(\"mc\").style.display = \"none\";\n\t\t\tbExpanded = false;\n\t\t} else {\n\t\t\t$(\'#divMenu\').animate({\n\t\t\t\twidth : \"2%\"\n\t\t\t}, \'slow\');\n\t\t\t$(\'#divContent\').animate({\n\t\t\t\twidth : \"98%\"\n\t\t\t}, \'slow\');\n\t\t\tdocument.getElementById(\"mb\").style.display = \"block\";\n\t\t\tdocument.getElementById(\"mh\").style.display = \"block\";\n\t\t\tdocument.getElementById(\"mc\").style.display = \"block\";\n\t\t\tbExpanded = true;\n\n\t\t}\n\t}\n \n var mandatoryCheck = false; \n var CheckValArray=[];\n\n function openNoteSectionAddendum(obj){\n\t\n\tsaveCurrentSectionToBean();\n\t   var content_type = $(\"#hdnCurChildSectionType\").val();\n\t\t\n\t\tvar section_code = \"*AmmendNotes*\";\n\t\tvar section_desc = $(\"#hdnCurSectionDesc\").val();\n\t\tvar child_section_code = \"*AmmendNotes*\";\n\t\tvar child_section_desc = $(\"#hdnCurChildSectionDesc\").val();\t\t\t\n\t\tvar note_type = $(\"#note_type\").val();\n\t\tvar patient_id = $(\"#patient_id\").val();\n\t\tvar encounter_id = $(\"#encounter_id\").val();\n\t\tvar accession_num = $(\"#accession_num\").val();\n\t\tvar operation_mode = $(\"#operation_mode\").val();\n\t\tvar amendment_type = $(\"#amendment_type\").val();\n\t\tvar addendum_sec_code = $(\"#hdnCurSectionCode\").val();\t\t\n\t\t$(\"#clinicalNotesSubsectionWrap_\" + addendum_sec_code).hide();\n\t\t\n\t\t$(\"#hdnCurSectionCode\").val(section_code);\n\t$(\"#hdnCurSectionDesc\").val(section_code);\n\t\n\tif(content_type==null ||content_type==\"\"||content_type==\" \"){\n\t\tcontent_type=\"A\";\n\t}\n\t\n\t$(\"#hdnCurChildSectionType\").val(content_type); //TODO change to hdnCurChildSectionType\n\t$(\"#hdnCurChildSectionCode\").val(child_section_code);\n\t$(\"#hdnCurChildSectionDesc\").val(child_section_desc);\n\t\t\n\t \n\t    $(\"#addendumHeader\").show();\n\t\t$(\".cnMainSectCell\").removeClass(\"cnSectHighlight\");\n\t\t$(\"#AddendumNoteSectionMenuItem\").addClass(\"cnSectHighlight\");\t\t\n\t      $(\"#NoteSectionData\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t     \n\t\t\t//$(\"#NoteSectionData\").load(path+\"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesRTEditor.jsp?section_code=\"+section_code+\"&child_section_code=\"+child_section_code+\"&addum=addumMode\",function(){\n\t\t\t\tvar timestamp = new Date().getTime();\n\t\t\t$(\"#NoteSectionData\").load(path+\"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesAddendumEditorsFrame.jsp?section_code=\"+section_code+\"&child_section_code=\"+child_section_code+\"&addum=addumMode&timestamp=\"+timestamp,function(){\n\t\t\t\tsetTimeout(function(){ \t\t\t\t\t\t\t\t\t\n\t\t\t\t\t//sectionListScroll.refresh(); \n\t\t\t\t\t//sectionListScroll.scrollToElement(\"#NoteSectionHeading_\"+child_section_code,0);\n\t\t\t\t}, 500);\t\t\t\t\t\n\t\t\t});\t\t\n\t }\nfunction openNoteSection(obj){\n\t\n\ttry\n\t{\n\t$(\"#cke_53\").hide();\n\twindow.parent.$(\"#ChartSummaryIframe\").contents().find(\"#NoteSectionView\").css({\"height\":\"100%\"});\t\n\t}\n\tcatch(e){\t}\n\t\n$(\"#addendumHeader\").hide();\n\tmandatoryCheck = false;\n\t\n\tsaveCurrentSectionToBean();\n\tvar parent_section_code = $(obj).data(\"parent_section_code\");\n\tvar parent_section_desc = $(obj).data(\"parent_section_desc\");\n\tvar parent_content_type = $(obj).data(\"parent_content_type\");\n\tvar content_type = $(obj).data(\"content_type\");\n\tvar section_desc = $(obj).data(\"section_desc\");\n\tvar section_code = $(obj).data(\"section_code\");\n\tvar note_type = $(\"#note_type\").val();\n\tvar patient_id = $(\"#patient_id\").val();\n\tvar encounter_id = $(\"#encounter_id\").val();\n\tvar accession_num = $(\"#accession_num\").val();\n\tvar operation_mode = $(\"#operation_mode\").val();\n\tvar event_status_code = $(\"#event_status_code\").val();\n\t\n\tif(parent_section_code === section_code){\n       \n\t\tvar sectionId=\"Mad_NoteSectionMenuItem_\"+section_code;\n\t\t\n\t\t$(\".cnMainSectCell\").removeClass(\"cnSectHighlight\");\n\t\t$(\"#NoteSectionMenuItem_\"+section_code).addClass(\"cnSectHighlight\");\n\t}\n\telse{\n\t\t\n\t\tvar sectionId=\"Subsect_NoteSectionMenuItem_\"+section_code;\n\t\t\n\t\t$(\".cnSubSectFont\").removeClass(\"cnSubSectHighlight\");\n\t\t$(\"#NoteSubSectionMenuItem_\"+section_code).addClass(\"cnSubSectHighlight\");\n\t}\n\t\n\t\n\t$(\"#hdnCurSectionCode\").val(parent_section_code);\n\t$(\"#hdnCurSectionDesc\").val(parent_section_desc);\n\t\n\t\n\t$(\"#hdnCurChildSectionType\").val(content_type); //TODO change to hdnCurChildSectionType\n\t$(\"#hdnCurChildSectionCode\").val(section_code);\n\t$(\"#hdnCurChildSectionDesc\").val(section_desc);\n\t\n\t$(\"#NoteSectionData\").empty();\n\tif(parent_content_type!=\"S\"){\n\t\tif(section_desc!=null){\n\t\t\t$(\"[data-parent_sect_code]\").css(\"display\",\"none\");\n\t\t}\n\t}\n\t\t\n\t\n\tif(content_type==\"A\"){\t\t\n\t\tvar timestamp = new Date().getTime();\n\t\t$(\"#NoteSectionData\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t\t$(\"#NoteSectionData\").load(path+\"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionAddendumView.jsp?sec_content_type=T\"+\"&sec_hdg_code=\"+parent_section_code+\"&child_sec_hdg_code=\"+section_code+\"&note_type=\"+note_type+\"&encounter_id=\"+encounter_id+\"&patient_id=\"+patient_id+\"&timestamp=\"+timestamp,\n\t\tfunction(){\t\t\n\t\t});\t\t\t\t\n\t}\n\t\n\telse if(content_type==\"T\"){\t\n\n\t\tif(operation_mode ==\"ModifyAddendum\" && event_status_code !=1){\n\t\t\tvar timestamp = new Date().getTime();\n\t\t$(\"#NoteSectionData\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t\t$(\"#NoteSectionData\").load(path+\"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionAddendumView.jsp?sec_content_type=T\"+\"&sec_hdg_code=\"+parent_section_code+\"&child_sec_hdg_code=\"+section_code+\"&note_type=\"+note_type+\"&encounter_id=\"+encounter_id+\"&patient_id=\"+patient_id+\"&timestamp=\"+timestamp,\n\t\tfunction(){\t\t\n\t\t});\n\t\t}\n\telse{\n\t\t$(\"#NoteSectionData\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t\tvar timestamp = new Date().getTime();\n\t\t$(\"#NoteSectionData\").load(path+\"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesTemplate.jsp?section_code=\"+parent_section_code+\"&child_section_code=\"+section_code+\"&child_section_type=\"+content_type+\"&timestamp=\"+timestamp,\n\t\t\tfunction(){\t\t\n\t\t\tif(mandatoryCheck == true){\n\t\t\t\t  $(\"#\"+sectionId).show();\n\t\t\t  }\n\t\t\t  else{\n\t\t\t\t  $(\"#\"+sectionId).hide();\n\t\t\t  }\n\t\t});\n\t}\n\t}\n\telse if(content_type==\"S\"){\n\t\t$(\"[data-parent_sect_code]\").css(\"display\",\"none\");\n\t\t$(\"[data-parent_sect_code=\'\"+section_code+\"\']\").css(\"display\",\"table-row\");\n\t\tassignSubSectionListScroll(section_code);\n\t\tif(subSectionListScroll){\n\t\t\tsubSectionListScroll.refresh();\n\t\t}\n\t\t//Selecting the first subsection by default\n\t\tvar firstNoteSubSection = $(\"[data-parent_section_code=\'\"+section_code+\"\'][data-first_note_subsection=\'true\']\");\n\t\tvar firstNoteSubSectionId = firstNoteSubSection.attr(\"id\");\n\t\tvar jsObjOfFirstSubSection = document.getElementById(firstNoteSubSectionId);\n\t\topenNoteSection(jsObjOfFirstSubSection); \n\t}else if(content_type==\"F\" || content_type==\"R\"){\n\t\t//$(\"#SectionDescription\").html(section_desc);\n\t\t\n\t\t$(\"#NoteSectionData\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t\tvar timestamp = new Date().getTime();\n\t\t//$(\"#NoteSectionData\").load(path+\"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesRTEditor.jsp?section_code=\"+parent_section_code+\"&child_section_code=\"+section_code,function(){\n\t\t$(\"#NoteSectionData\").load(path+\"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesRTE.jsp?section_code=\"+parent_section_code+\"&child_section_code=\"+section_code+\"&timestamp=\"+timestamp,function(){\n\t\t\tsetTimeout(function(){ \n\t\t\t\t//sectionListScroll.refresh(); \n\t\t\t\t//sectionListScroll.scrollToElement(\"#NoteSectionHeading_\"+child_section_code,0);\n\t\t\t}, 500);\n\t\t\t\n\t\t\t\n\t\t});\n\t\t\n\t\t\n\t}\n}\n\nfunction saveCurrentSectionToBean(callback){\t\t\t\n\tvar content_type = $(\"#hdnCurChildSectionType\").val();\n\tvar section_code = $(\"#hdnCurSectionCode\").val();\n\tvar section_desc = $(\"#hdnCurSectionDesc\").val();\n\tvar child_section_code = $(\"#hdnCurChildSectionCode\").val();\n\tvar child_section_desc = $(\"#hdnCurChildSectionDesc\").val();\t\t\t\n\tvar note_type = $(\"#note_type\").val();\n\tvar patient_id = $(\"#patient_id\").val();\n\tvar encounter_id = $(\"#encounter_id\").val();\n\tvar accession_num = $(\"#accession_num\").val();\n\tvar operation_mode = $(\"#operation_mode\").val();\n\tvar amendment_type = $(\"#amendment_type\").val();\n\tvar event_status_code = $(\"#event_status_code\").val();\n\t\n\tif(operation_mode ==\"ModifyAddendum\" && event_status_code!=\'1\'){\t\t\n\t\t//var section_content=$(\'#RTEditor0\').contents().find(\'body\').html(); \n\t\tif(content_type && section_code && child_section_code && child_section_code!=\"\"){\n\t\t\tvar section_content = eval(\"CKEDITOR.instances.RecNotesRTE_CK.getData()\");\n";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="\n\t\t\t$.ajax({\n\t\t\t\t\t  method: \"POST\",\n\t\t\t\t\t  url: path+\"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionAddendumControl.jsp\",\n\t\t\t\t\t  data: { curr_sec_hdg_code: section_code, curr_child_sec_hdg_code: child_section_code, editor_title: \"\", operation_mode: \"ModifyAddendum\",note_type:note_type, patient_id:patient_id,prev_sec_hdg_code:\"\",prev_child_sec_hdg_code:\"\",ammend_mode:\"\",record_mode:\"RecordAddendum\",encounter_id:encounter_id,episode_type:\"I\",patient_class:\"IP\",section_content: section_content,accession_num:accession_num}\n\t\t\t\t\t})\n\t\t\t\t\t  .done(function( msg ) {\t\t    \n\t\t\t\t\t    if(callback)\n\t\t\t\t\t\t  callback();\n\t\t\t\t\t  });\t\n\t\t}\n\t}\n\telse{\n\tif(content_type && section_code && child_section_code && child_section_code!=\"\"){\n\t\tif(content_type == \"F\" || content_type == \"R\"){\t\t\n\t\t\t//var e = document.getElementById(\"RTEditor0\");\n\t\t\t//var  section_content=e.contentWindow.document.body.innerHTML;\t\t\t\t\n\t\t\t//var section_content = eval(\"CKEDITOR.instances.RecNotesRTE_CK.getData()\");\n\t\t\tvar section_content = eval(\"CKEDITOR.instances.RecNotesRTE_\" + child_section_code +\".getData()\");\n\n\t\t\tsection_content=section_content.replace(\"<address1>\",\"<address>\");\n\t\t\tsection_content=section_content.replace(\"</address1>\",\"</address>\");\n\n\t\t\t$.ajax({\n\t\t\t\t  method: \"POST\",\n\t\t\t\t  url: path+\"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionControl.jsp\",\n\t\t\t\t  data: { content_type: content_type, child_section_code: child_section_code, section_code: section_code, section_content: section_content }\n\t\t\t\t})\n\t\t\t\t  .done(function( msg ) {\t\t\t    \n\t\t\t\t    if(callback)\n\t\t\t\t\t  callback();\n\t\t\t\t  });\n\t\t}\n\t\telse if(content_type == \"T\"){\n\t\t\t$.ajax({\n\t\t        //url: path + \"/eIPAD/jsp/chartwidgets/orders/MoeAddToCart.jsp?check_box_value=\"+check_box_value+\"&OrderCatalogCode=\"+orderCatalogCode+\"&OrderTypeCode=\"+orderTypeCode+\"&OrderCatCode=\"+orderCategoryCode,\n\t\t        type: \"POST\",\n\t\t        url: path + \"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionControl.jsp\",\n\t\t        data: $(\"#CNSectionTemplateForm\").serialize(),\n\t\t        success: function(response) {\n\t\t        \tif(callback)\n\t\t\t\t\t\t  callback();\n\t\t          \n\t\t\t\t},\n\t\t\t\terror: function (xhr, ajaxOptions, thrownError) {\n\t\t\t\t\tif(callback)\n\t\t\t\t\t\tcallback();\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t//end ajax options\n\t\t\t});//end ajax \n\t\t} \n\t}\n\telse{\n\t\tif(callback)\n\t\t\tcallback();\n\t\t\t\t}\n\t}\n\t\n}\n\n</script>\n\n<style>\n\n\n.clinicalNote {\n\twidth: 100%;\n\theight: 97%;\n\tbackground: rgba(233, 238, 241, 0.45);\n}\n\n.cnMainSectCell {\n\tpadding-left: 15px;\n\tpadding-right: 15px;\n\tfont-size: 14px;\n\tcolor: #dce5e9;\n\tfont-weight: bold;\n\tdisplay: inline-block;\n\tlist-style-type: none;\n}\n\n.cnSectHighlight {\n\tfont-size: 14px;\n\tcolor: #fff;\n\tfont-weight: bold;\n\tborder-bottom: 3px solid #fff;\n\tpadding-bottom: 11.5px;\n}\n\n\n\n/*******************/\n.cnSubSection {\n\tmargin: 6px;\n\theight: 98%;\n}\n\n.cnMainSectionClass {\n    overflow: hidden; \n    position: relative;\n    width: 100%; \n\theight: 45px;\n\tmax-height: 45px;\n\tbackground: #2a7fa1;\n\tfont-size: 14px;\n\tcolor: #dce5e9;\n\tfont-weight: bold;\n}\n\n.addendumToCommonNote {\n    overflow: hidden; \n    position: relative;\n    width: 100%; \n\theight: 45px;\n\tbackground: #e0e0eb;\n\tmax-height: 45px;\n\tfont-size: 14px;\n    color: #1f2227;;\n\tvertical-align: middle;\n    line-height: 45px;\n    padding-left: 15px;\n\tfont-weight: bold;\n}\n.cnSubSectionClass {\n\theight: 45px;\n\twidth: 100%;\n\toverflow: hidden;\n\tposition: relative;\n}\n\n.cnSubsectBackground {\n\tbackground: #e3e9ed;\n}\n\n.cnSubsectionChild { /* display: none; */\n\tposition: absolute;\n\twidth: auto;\n}\n\n.cnBodySectionClass{\n    background: rgba(233, 238, 241, 0.45)\n    overflow: hidden; \n    position: relative;\n    height: 100%;\n    width: 100%; \n}\n\n.cnSubSectUlCell {\n\twhite-space: nowrap;\n\tpadding-left: 0px;\n}\n\n.cnSubSectLiCell {\n\tpadding-left: 15px;\n\tpadding-right: 15px;\n\tfont-size: 12px;\n\tcolor: #484848;\n\tfont-weight: bold;\n\tdisplay: inline-block;\n\tlist-style-type: none;\n}\n\n.cnSubSectFont {\n\tfont-size: 12px;\n\tcolor: #64a2b5;\n\tfont-weight: bold;\n}\n\n.cnSubSectHighlight {\n\tfont-size: 12px;\n\tcolor: #006a88; \n\tfont-weight: bold;\n\tborder-bottom: 3px solid #006a88;\n\tpadding-bottom: 13px;\n}\n\n/*********************/\n.recNotesSectListCont {\n\twidth: 100%;\n\theight: 100%;\n\tbackground: #ccc;\n\toverflow: hidden;\n\t/* position:relative; */\n}\n\n.recNotesSectWrapper {\n\twidth: 100%;\n\theight: 100%;\n\toverflow: hidden;\n\tposition: relative;\n}\n\n.recNotesSectScroller {\n\twidth: 100%;\n\theight: auto;\n\tposition: relative;\n}\n\n.recNotesSectItem {\n\theight: 40px;\n}\n</style>\n\n<div style=\"width: 100%; height: 100%;    position: relative;\" class=\"table\">\n\t";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<!-- popup container ends -->\n\n\t<!-- <div id=\"divcnt\" class=\"divAllergyContent divAllergyContentTheme\" style=\"padding: 0px; overflow: hidden\" data-role=\"none\">\n\t\t\t\t\t<div style=\"width: 100%; height: 100%; overflow: auto\" data-role=\"none\"> -->\n\t<!-- <div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\"> -->\n\t<!-- container start -->\n\n\t<!-- Header row STARTS -->\n\t<div style=\"height: 75px;position:relative;width:100%;\" class=\"row\">\n\t\t<div style=\"width: 100%;\"\n\t\t\tclass=\"WidgetContentStripTheme cell cnRecNotesHeader\">\n\t\t\t<div style=\"width: 100%; height: 100%\" class=\"table\">\n\t\t\t\t<div class=\"row\">\n\t\t\t\t\t<div\n\t\t\t\t\t\tstyle=\"width: 60px; height: 100%; vertical-align: middle; text-align: center;padding-left:10px\"\n\t\t\t\t\t\tclass=\"cell\">\n                        <div  class=\"CNButtonItemTheme\" id=\"CNActionBtnPreviewNote\">\n\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/Preview24x24.png\" />\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"CNButtonItemTheme\" style=\"display:none\" id=\"NotePreviewCloseBtn\" onclick=\"enableNoteEditMode()\">\n\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/BacktoEdit24x24.png\">\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t\t<div style=\"vertical-align: middle;\" class=\"cell\">\n\t\t\t\t\t\t<div style=\"width: 100%; height: 100%\" class=\"table\">\n\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t<div class=\"cnRecNotesHeaderTxt cell\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t<div class=\"cnPracName cell\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\t<!-- Header row ENDS -->\n\n\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t \t\t\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" /> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"note_type_desc\" id=\"note_type_desc\" id=\"note_type_desc\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"note_type\" id=\"note_type\" id=\"note_type\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"service_code\" id=\"service_code\" id=\"service_code\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"event_status\" id=\"event_status\" id=\"event_status\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"selection_type\" id=\"selection_type\" id=\"selection_type\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\" id=\"accession_num\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"operation_mode\" id=\"operation_mode\" id=\"operation_mode\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"event_status_code\" id=\"event_status_code\" id=\"event_status_code\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"event_date_time\" id=\"event_date_time\" id=\"event_date_time\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"/>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnCurSectionCode\" id=\"hdnCurSectionCode\" id=\"hdnCurSectionCode\" value=\"\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnCurChildSectionType\" id=\"hdnCurChildSectionType\" id=\"hdnCurChildSectionType\" value=\"\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnCurSectionDesc\" id=\"hdnCurSectionDesc\" id=\"hdnCurSectionDesc\" value=\"\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnCurChildSectionCode\" id=\"hdnCurChildSectionCode\" id=\"hdnCurChildSectionCode\" value=\"\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnCurChildSectionDesc\" id=\"hdnCurChildSectionDesc\" id=\"hdnCurChildSectionDesc\" value=\"\"/>\n\n\n\t\t\t\t\t\t \t\n\t\t\t\t\t\t<!-- </div>  --><!-- container ends-->\n\t\t\t\t\t<!-- </div>\n\t\t\t\t</div> -->\n\t\t\t\t\n\t\t<!-- </form>\n\t</div> -->\n\t\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n<!-- Body(section list) row STARTS -->\n\n\t<div  class=\"row clinicalNote\">\n\t  <div class=\"cell\" style=\"width:100%;height:100%; position:relative;\">\n\t    <div class=\"table\" style=\"width:100%;height:100%\">\n\t\t<!-- Main Section Table STARTS -->\n\t\t<div id=\"ClinicalNotesSectListWrap\" class=\"cnMainSectionClass row\">\n\t\t\t<div style=\"width: auto; position: absolute; height: 100%;\">\n\t\t\t\t<ul style=\"white-space: nowrap;padding-left:0px;\">\n\t\t\t\t<input type=\"hidden\" name=\"hdnOpMode\" id=\"hdnOpMode\" id=\"hdnOpMode\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'/>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<li id=\"AddendumNoteSectionMenuItem\" id=\"NoteSectionMenuItem_AmmendNotes\"\n\t\t\t\t\t\tdata-parent_section_code=\"*AmmendNotes*\"\n\t\t\t\t\t\tdata-parent_section_desc=\"*AmmendNotes*\"\n\t\t\t\t\t\tdata-parent_content_type=\"*AmmendNotes*\"\n\t\t\t\t\t\tdata-content_type=\"*AmmendNotes*\"\n\t\t\t\t\t\tdata-section_code=\"*AmmendNotes*\"\n\t\t\t\t\t\tdata-section_desc=\"*AmmendNotes*\" data-first_note_section=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" class=\"cnMainSectCell\" onclick=\"openNoteSectionAddendum(this)\">Addendum to Note</li>\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t<li class=\"cnMainSectCell\"\n\t\t\t\t\t\tid=\"NoteSectionMenuItem_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"\n\t\t\t\t\t\tdata-parent_section_code=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"\n\t\t\t\t\t\tdata-parent_section_desc=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"\n\t\t\t\t\t\tdata-parent_content_type=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"\n\t\t\t\t\t\tdata-content_type=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"\n\t\t\t\t\t\tdata-section_code=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"\n\t\t\t\t\t\tdata-section_desc=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\n\t\t\t\t\t\tdata-first_note_section=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\tonclick=\"openNoteSection(this)\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="<span id=\"Mad_NoteSectionMenuItem_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" style=\"display: none;\"><font style=\"color: red\">*</font></span></li>\n\t\t\t\t\t<!-- <li class=\"cnMainSectCell\">test1</li>\n\t\t\t\t\t<li class=\"cnMainSectCell\">test2</li>\n\t\t\t\t\t<li class=\"cnMainSectCell\">test3</li>\n\t\t\t\t\t<li class=\"cnMainSectCell\">test4</li>\n\t\t\t\t\t<li class=\"cnMainSectCell\">test5</li> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\tonclick=\"openNoteSection(this)\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</li>\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\t\t\t\n                </ul>\n                </div> \n                </div>\n                           \n\t\t\t<!-- Main Section Table ENDS -->\n\t\t\t\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t<div class=\"cnSubSection row\">\n\t\t<div class=\"cell\" style=\"padding-top:9px;padding-left:9px;padding-right:9px;\">\n\t\t<div class=\"table\" style=\"width:100%;height:calc(100% - 9px)\">\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n         \n            <div class=\"cnSubSectionClass cnSubsectBackground\" style=\"display: none;\" id=\"clinicalNotesSubsectionWrap_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" data-parent_sect_code=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t<div class=\"cnSubsectionChild\" style=\"width: auto; position: absolute; height: 100%;\">\n\t\t\t\t\t\t<ul class=\"cnSubSectUlCell\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t<li class=\"cnSubSectLiCell cnSubSectFont\" id=\"NoteSubSectionMenuItem_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"\n\t\t\t\t\t\t\t\tdata-parent_section_code=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"\n\t\t\t\t\t\t\t\tdata-parent_section_desc=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"\n\t\t\t\t\t\t\t\tdata-parent_content_type=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"\n\t\t\t\t\t\t\t\tdata-content_type=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"\n\t\t\t\t\t\t\t\tdata-section_code=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"\n\t\t\t\t\t\t\t\tdata-section_desc=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"\n\t\t\t\t\t\t\t\tdata-first_note_subsection=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\tonclick=\"openNoteSection(this)\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t   <span id=\"Subsect_NoteSectionMenuItem_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" style=\"display: none;\"><font style=\"color: red\">*</font></span>\n\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t<li class=\"cnSubSectLiCell\"><div style=\"opacity:0.5;\">No subsections were present</div></li>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n\t\t\t\t\t\t</ul>\n\t\t\t</div>\n\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t<!-- Sub Section Table ENDS -->\n\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n        <div class=\"row\">\n\t\t<div class=\"cnBodySectionClass\" id=\"bodySectionWrapper\" style=\"display:table-cell;-webkit-box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75); -moz-box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75); box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75);padding: 5px;position: relative;\">\n\t\t         <div id=\"addendumHeader\" style=\"background: #e0e0eb;font-size: 14px;vertical-align: middle;line-height: 45px;padding-left: 15px;font-weight: bold;\">Add Your Addendum Below</div>\n\t\t\t<!-- <div style=\"width: 100%; position: absolute; height: auto;\"> -->\n\t\t\t\t<div style=\"background: #fafafa;width:100%; height: 100%;border:1px solid #dddddd;    position: relative;\" class=\"table\" id=\"NoteSectionData\">\n\t\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t<!-- </div>\t -->\n\t\t</div>\n\t\t<div class=\"cnBodySectionClass\" id=\"NoteSectionPreviewWrap\" style=\"visbility:hidden;\">\n\t\t\t<!-- <div style=\"width: 100%; position: absolute; height: auto;\"> -->\n\t\t\t\t<div style=\"background: #fafafa;width:100%; height: auto;\" id=\"NoteSectionPreview\"> \n\t\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t<!-- </div>\t -->\n\t\t</div>\n\t\t</div>\n\t\t\n\t </div>\n\t </div>\t\n     </div>\t\n     </div>\n     </div>\n\t</div>\n\t<!-- Body(section list) row ENDS -->\n<!-- \t\n\t<div class=\"row\" style=\"height:90%\">\n\t\tThe template/text editor loads in this div\n\t\t<div class=\"cell\" style=\"width: 100%;height:100%\">\n\t\t\t<div style=\"position: relative;width:100%;height:100%\">\n\t\t\t\t<div style=\"position: absolute; background: lightblue;width:100%;height:100%\" id=\"NoteSectionData\">\n\t\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t</div>\t\n\t\t</div>\n\t</div> -->\t\n\n\t\t\t\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t<div> No sections configured for the selected Note Type</div>\n\t\t\t\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\n\n\n\t\n\t\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n</div>\n\n\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" \n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );
	
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


public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}
public String checkForNull(String inputString, String defaultValue)
{
	if(inputString==null)inputString ="";
	return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);

String path = request.getContextPath();
PatContext patContext= (PatContext)session.getAttribute("PatientContext");
String note_type = request.getParameter("note_type") == null? "":request.getParameter("note_type"); //noteTypeId
//String noteTypedesc = request.getParameter("cmbNoteType_input") == null? "":request.getParameter("cmbNoteType_input");
String service_code = request.getParameter("service_code") == null? "":request.getParameter("service_code");
String event_status_code = request.getParameter("event_status_code")==null?"":request.getParameter("event_status_code");



if(patContext!=null){
	
	String patient_id = patContext.getPatientId();
	String patient_class = patContext.getPatientClass();
	String facility_id = patContext.getFacilityId();
	String location_code = patContext.getLocationCode();
	String encounter_id = patContext.getEncounterId();
	String clinician_id = patContext.getClinicianId();
	String login_user_id = (String)session.getValue("login_user");

            _bw.write(_wl_block7Bytes, _wl_block7);


	String attending_practitioner = "";//TODO
	String speciality_name = "";//TODO
	String visit_adm_date = "";//TODO
	String discharge_date = "";//TODO
	String event_date_time = "";//TODO
	String patient_name = "";
	String age = "";
	String Sex = "";
	String location_desc = "";
	String print_date_time = "";
	String regn_date = "";
	String date_of_birth = "";
	String mar_status = "";
	String nationality = "";
	String res_area_code = "";
	String res_town_desc = "";
	String relgn = "";
	String name_prefix = "" ;
	String region_code = "";
	String facility_name = "";
	String res_addr = "";
	String blood_grp = "";
	String rh_factor = "";
	String national_id = "";
	String practitioner_name = "";
	String degree;
	String credential_id;
	String credential_id1;
	String credential_id2;
	String credential_id3;
	String email_id;
	String pref_contact_mode;
	String off_tel_num;
	String off_tel_ext;
	String res_tel_num;
	String fax_num;
	String mobile_num;
	String pager_num;
	String bed_num = "";
	String room_num = "";
	StringBuffer prac_credentials = new StringBuffer();
	String event_date_caption = "";
	String event_perf_by_caption = "";
	String event_status_caption = "";
	String event_title_caption = "";
	String event_type_caption = "";
	String note_header_code = "";
	String footer_code = "";
	String report_header_code = "";
	String note_type_desc = "";
	String accession_num = request.getParameter("accession_num") == null? "":request.getParameter("accession_num");
	String authorized_by = "";
	String last_amended_by = "";
	String doc_ref_id = "";
	String performing_phy_name = "";
	String med_service = "";
	String encounter_id1 = "";
	String output_form_exists_yn = "N";
	String note_status = "";
	String note_title = "";
	String contr_mod_accession_num = "";//IN038439
	String strKey = "";
	String doc_exists;
	String sec_hdg_code;
	String sec_hdg_desc;
	String sec_content_type;
	String sec_result_linked_rec_type;
	String child_sec_hdg_code;
	String child_sec_hdg_desc;
	String child_sec_content_type;
	String child_sec_result_link_rec_type;
	String chief_complaint_sec_yn;
	String image_linked_yn;
	String strContentEditableYn;
	String content_type;
	String result_link_type;
	String result_link_yn = "N";
	String selection_type = "S";
	String operation_mode = request.getParameter("operation_mode") == null? "":request.getParameter("operation_mode");
	String query_notes_detail;
	String image_content = "";
	String image_recorded_yn = "N";
	String section_content_out = "";
	String child_sec_hdg_code_out;
	String sec_hdg_code_out;
	String doc_linked_yn = "";
	String image_edited_yn = "N";
	String edited_yn = "N";
	String prev_sec_hdg_code = "";
	String tblrow_id;
	String cnt_ofMainSections = "";
	String ids_of_mainSections = "";
	String section_image_height = "400"; //IN057343
	String event_status = "1"; // for Record
	String status;
	
	int sub_section_counter = 0;
	int cnt = 0;
	int cntSec = 0;
	
	
	
	HashSet recSet	= new HashSet();
	Hashtable htParameter=new Hashtable();
	Hashtable htPatDet=new Hashtable();
	Hashtable htPrompt=new Hashtable();
	
	Clob clob_notes_content = null;
	Clob clob_section_image_content	= null;
	Reader content_reader = null;
	BufferedReader	bf_content_reader = null;
	String section_content = "";
	
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	StringBuffer query_section_details = new StringBuffer();
	StringBuffer sbResult			   = new StringBuffer();
	
	HeaderDomParser parser = new HeaderDomParser();
	eCA.TemplatePromtRepParser prompt_parser = new eCA.TemplatePromtRepParser();
	
	
	//String practName = request.getParameter("practName") == null? "":request.getParameter("practName");
	
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	strKey = patContext.getPatientId() + "~" + patContext.getEncounterId();
	strKey = strKey.trim();
	sectionBean.removePatientSection(strKey);	
	sectionBean.startPatientSection(strKey);
	eCA.PatientBannerGroupLine manageEmailBean = null;
	
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	
	Connection			con				=	null;
	PreparedStatement	pstmt			=	null;
	PreparedStatement	pstmt1			=	null;
	PreparedStatement	pstmt2			=	null;
	ResultSet			rs				=	null;
	ResultSet			rs1				=	null;
	ResultSet			rs2				=	null;
	
	con				=	ConnectionManager.getConnection(request);
	
	if(!(patient_id.equals("")))
	{
	
		try{
			//String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN CURR_PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC from mp_patient where patient_id = ? ";
			//String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN ? IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC , to_Char(REGN_DATE,'dd/mm/yyyy') REGN_DATE,to_Char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, mp_get_desc.MP_MARITAL_STATUS(MAR_STATUS_CODE,?,2) MAR_STATUS, mp_get_desc.MP_COUNTRY(NATIONALITY_CODE,?,2) NATIONALITY ,mp_get_desc.MP_RES_AREA(RES_AREA_CODE,?,2) RES_AREA_CODE,RES_TOWN_DESC,mp_get_desc.MP_RELIGION(RELGN_CODE,?,2) RELGN ,NAME_PREFIX,mp_get_desc.MP_REGION(REGION_CODE,?,2) REGION_CODE,sm_get_desc.SM_FACILITY_PARAM(?,?,1) FACILITY_NAME,b.ADDR1_LINE1||','||b.ADDR1_LINE2||','||b.ADDR1_LINE3||','||b.ADDR1_LINE4 res_addr,c.BLOOD_GRP ,c.RH_FACTOR from mp_patient a,MP_PAT_ADDRESSES b,MP_PAT_OTH_DTLS c where a.PATIENT_ID = b.PATIENT_ID and a.PATIENT_ID = c.PATIENT_ID and a.patient_id = ?";//IN043083
			String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN ? IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC , to_Char(REGN_DATE,'dd/mm/yyyy') REGN_DATE,to_Char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, mp_get_desc.MP_MARITAL_STATUS(MAR_STATUS_CODE,?,2) MAR_STATUS, mp_get_desc.MP_COUNTRY(NATIONALITY_CODE,?,2) NATIONALITY ,mp_get_desc.MP_RES_AREA(RES_AREA_CODE,?,2) RES_AREA_CODE,RES_TOWN_DESC,mp_get_desc.MP_RELIGION(RELGN_CODE,?,2) RELGN ,NAME_PREFIX,mp_get_desc.MP_REGION(REGION_CODE,?,2) REGION_CODE,sm_get_desc.SM_FACILITY_PARAM(?,?,1) FACILITY_NAME,b.ADDR1_LINE1||','||b.ADDR1_LINE2||','||b.ADDR1_LINE3||','||b.ADDR1_LINE4 res_addr,c.BLOOD_GRP ,c.RH_FACTOR,a.NATIONAL_ID_NO from mp_patient a,MP_PAT_ADDRESSES b,MP_PAT_OTH_DTLS c where a.PATIENT_ID = b.PATIENT_ID and a.PATIENT_ID = c.PATIENT_ID and a.patient_id = ?";//IN043083
				
			pstmt2	= con.prepareStatement(strPatInfoQuery);
			pstmt2.setString(1,patient_class);
			pstmt2.setString(2,facility_id);
			pstmt2.setString(3,location_code);
			pstmt2.setString(4,locale);
			pstmt2.setString(5,facility_id);
			pstmt2.setString(6,location_code);
			pstmt2.setString(7,locale);//
			pstmt2.setString(8,locale);//
			pstmt2.setString(9,locale);//
			pstmt2.setString(10,locale);//
			pstmt2.setString(11,locale);//
			pstmt2.setString(12,locale);//
			pstmt2.setString(13,facility_id);//
			pstmt2.setString(14,locale);//
			pstmt2.setString(15,patient_id);
			rs2 = pstmt2.executeQuery();
			
			while(rs2.next())
			{
				patient_name = rs2.getString("patient_name")==null?"":rs2.getString("patient_name");
				age = rs2.getString("patient_age")==null?"":rs2.getString("patient_age");
				Sex = rs2.getString("Gender")==null?"":rs2.getString("Gender");
				location_desc = rs2.getString("LOCN_DESC")==null?"":rs2.getString("LOCN_DESC");
				print_date_time = rs2.getString("print_date_time")==null?"":rs2.getString("print_date_time");
				regn_date = rs2.getString("regn_date")==null?"":rs2.getString("regn_date");
				date_of_birth = rs2.getString("date_of_birth")==null?"":rs2.getString("date_of_birth");
				mar_status = rs2.getString("mar_status")==null?"":rs2.getString("mar_status");
				nationality = rs2.getString("nationality")==null?"":rs2.getString("nationality");
				res_area_code = rs2.getString("res_area_code")==null?"":rs2.getString("res_area_code");
				res_town_desc = rs2.getString("res_town_desc")==null?"":rs2.getString("res_town_desc");
				relgn = rs2.getString("relgn")==null?"":rs2.getString("relgn");
				name_prefix = rs2.getString("name_prefix")==null?"":rs2.getString("name_prefix");
				region_code = rs2.getString("region_code")==null?"":rs2.getString("region_code");		
				facility_name = rs2.getString("FACILITY_NAME")==null?"":rs2.getString("FACILITY_NAME");		
				res_addr = rs2.getString("res_addr")==null?"":rs2.getString("res_addr");		
				blood_grp = rs2.getString("BLOOD_GRP")==null?"":rs2.getString("BLOOD_GRP");		
				rh_factor = rs2.getString("RH_FACTOR")==null?"":rs2.getString("RH_FACTOR");		
				national_id = rs2.getString("NATIONAL_ID_NO")==null?"":rs2.getString("NATIONAL_ID_NO");	//IN043083
		
		
				if(Sex.equals("M") )
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(Sex.equals("F") )
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		
				if(patient_class.equals("OP"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(patient_class.equals("IP"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(patient_class.equals("EM"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(patient_class.equals("DC"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
		
			}
			//setPatOutDetails
		
		
		}
		catch(Exception ee)
		{
			out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
			ee.printStackTrace();
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}
		
		try{				
			String strPracCredentialsQuery = "select PRACTITIONER_NAME,DEGREE,CREDENTIAL_ID,CREDENTIAL_ID1,CREDENTIAL_ID2,CREDENTIAL_ID3,EMAIL_ID,PREF_CONTACT_MODE,OFF_TEL_NUM,OFF_TEL_EXT,RES_TEL_NUM,FAX_NUM,MOBILE_NUM,PAGER_NUM ,ASSIGN_BED_NUM,ASSIGN_ROOM_NUM FROM AM_PRACTITIONER A, PR_ENCOUNTER B WHERE A.PRACTITIONER_ID=B.ATTEND_PRACTITIONER_ID AND FACILITY_ID=? AND ENCOUNTER_ID=?";						
			pstmt2	= con.prepareStatement(strPracCredentialsQuery);
			pstmt2.setString(1,facility_id);
			pstmt2.setString(2,encounter_id);
			rs2 = pstmt2.executeQuery();

			if(rs2.next())
			{
				practitioner_name = rs2.getString("PRACTITIONER_NAME")==null?"":rs2.getString("PRACTITIONER_NAME");
				degree = rs2.getString("DEGREE")==null?"":rs2.getString("DEGREE");
				credential_id = rs2.getString("CREDENTIAL_ID")==null?"":rs2.getString("CREDENTIAL_ID");
				credential_id1 = rs2.getString("CREDENTIAL_ID1")==null?"":rs2.getString("CREDENTIAL_ID1");
				credential_id2 = rs2.getString("CREDENTIAL_ID2")==null?"":rs2.getString("CREDENTIAL_ID2");
				credential_id3 = rs2.getString("CREDENTIAL_ID3")==null?"":rs2.getString("CREDENTIAL_ID3");
				email_id = rs2.getString("EMAIL_ID")==null?"":rs2.getString("EMAIL_ID");
				pref_contact_mode = rs2.getString("PREF_CONTACT_MODE")==null?"":rs2.getString("PREF_CONTACT_MODE");
				off_tel_num = rs2.getString("OFF_TEL_NUM")==null?"":rs2.getString("OFF_TEL_NUM");
				off_tel_ext = rs2.getString("OFF_TEL_EXT")==null?"":rs2.getString("OFF_TEL_EXT");
				res_tel_num = rs2.getString("RES_TEL_NUM")==null?"":rs2.getString("RES_TEL_NUM");
				fax_num = rs2.getString("FAX_NUM")==null?"":rs2.getString("FAX_NUM");
				mobile_num = rs2.getString("MOBILE_NUM")==null?"":rs2.getString("MOBILE_NUM");
				pager_num = rs2.getString("PAGER_NUM")==null?"":rs2.getString("PAGER_NUM");
				bed_num = rs2.getString("ASSIGN_BED_NUM")==null?"":rs2.getString("ASSIGN_BED_NUM");
				room_num = rs2.getString("ASSIGN_ROOM_NUM")==null?"":rs2.getString("ASSIGN_ROOM_NUM");
			
				prac_credentials.append(practitioner_name+" "+degree+"<br/>");
				
				if(!credential_id.equals(""))
					prac_credentials.append(credential_id);

				if(!credential_id.equals("") && (!credential_id1.equals("")))
					prac_credentials.append(",");
				
				prac_credentials.append(credential_id1);

				if(!credential_id1.equals("") && (!credential_id2.equals("")))
					prac_credentials.append(",");

				prac_credentials.append(credential_id2);

				if(!credential_id2.equals("") && (!credential_id3.equals("")))
					prac_credentials.append(",");
				
				prac_credentials.append(credential_id3);
				
				if(!credential_id1.equals("") || !credential_id2.equals("") || (!credential_id3.equals("")))
					prac_credentials.append("<br/>");
		
				
				if(pref_contact_mode.equals("M")){
					prac_credentials.append("Mobile : "+mobile_num);
					if(!email_id.equals(""))
						prac_credentials.append("  Email : "+email_id);
				}
				else if(pref_contact_mode.equals("R")){
					prac_credentials.append("Residence Tel : "+res_tel_num);
					if(!email_id.equals(""))
						prac_credentials.append("  Email : "+email_id);
				}
				else if(pref_contact_mode.equals("O")){									
					prac_credentials.append("Office Tel : "+off_tel_num);
					if(!off_tel_ext.equals(""))
						prac_credentials.append("  ext : "+off_tel_ext);
					if(!email_id.equals(""))
						prac_credentials.append("  Email : "+email_id);
				}
				else{
					if(!email_id.equals(""))
						prac_credentials.append("  Email : "+email_id);
				}
			}
		}
		catch(Exception ee){
			out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
			ee.printStackTrace();
		}
		finally{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}
		
		try{
			String strEventTitles = "select  a.EVENT_DATE_CAPTION,a.EVENT_PERF_BY_CAPTION ,a.EVENT_STATUS_CAPTION,a.EVENT_TITLE_CAPTION,a.EVENT_TYPE_CAPTION from CA_NOTE_TYPE_lang_vw a where a.NOTE_TYPE =? and a.LANGUAGE_ID =? ";
			
			pstmt2	= con.prepareStatement(strEventTitles);
			pstmt2.setString(1,note_type);
			pstmt2.setString(2,locale);
			
			rs2 = pstmt2.executeQuery();

			while(rs2.next()){
				event_date_caption = rs2.getString("EVENT_DATE_CAPTION")==null?"":rs2.getString("EVENT_DATE_CAPTION");
				event_perf_by_caption = rs2.getString("EVENT_PERF_BY_CAPTION")==null?"":rs2.getString("EVENT_PERF_BY_CAPTION");
				event_status_caption = rs2.getString("EVENT_STATUS_CAPTION")==null?"":rs2.getString("EVENT_STATUS_CAPTION");
				event_title_caption = rs2.getString("EVENT_TITLE_CAPTION")==null?"":rs2.getString("EVENT_TITLE_CAPTION");
				event_type_caption = rs2.getString("EVENT_TYPE_CAPTION")==null?"":rs2.getString("EVENT_TYPE_CAPTION");
			}
				htPrompt.put("V$PR_DATE", event_date_caption);
				htPrompt.put("V$NT_STATUS", event_status_caption);
				htPrompt.put("V$NT_TITLE", event_title_caption);
				htPrompt.put("V$NT_TYPE", event_type_caption);
				htPrompt.put("V$PR_BY_PRACT", event_perf_by_caption);
					
				
		}
		catch(Exception ee)
		{
			out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
			ee.printStackTrace();
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}
		
		if(!(note_type.equals("")))
		{
			
			// new addition for report header and Notes header STARTS
			try{
				String head_foot_qry ="select a.NOTE_TYPE_DESC,a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";

				pstmt2	= con.prepareStatement(head_foot_qry);
				pstmt2.setString(1,note_type);
				rs2 = pstmt2.executeQuery();

				while(rs2.next())
				{
					note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
					footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
					report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
					note_type_desc = rs2.getString("NOTE_TYPE_DESC")==null?"":rs2.getString("NOTE_TYPE_DESC");
				}

			}
			catch(Exception ee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
				ee.printStackTrace();
			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
			// new addition for report header and Notes header ENDS
			
			// Report Header STARTS
			try
			{
				String rpt_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(rpt_sect_query);
				pstmt2.setString(1,report_header_code);
				rs2 = pstmt2.executeQuery();
				if(rs2.next())
				{
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
					if(clob_notes_content!=null)
					{
						try
						{
							content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
							bf_content_reader	= new java.io.BufferedReader(content_reader);
							char[] arr_notes_content = new char[(int)clob_notes_content.length()];
							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
							section_content = new String(arr_notes_content);
							bf_content_reader.close();
										
							if(section_content == null)
								section_content = "";
						
						}
						catch(Exception e)
						{
							out.println("Exception@1-readCLOB : "+e);
							e.printStackTrace();
						}
	
	
					}
				}
			}

			catch(Exception eee)
			{
				out.println("Exception in MRecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}

			if(!accession_num.equals(""))
			{
				try
				{
					String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,1) AUTHORIZED_BY_ID,a.LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name,a.SERVICE_CODE service_code, a.event_status status from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

					pstmt2	= con.prepareStatement(athorise_by_qry);
					pstmt2.setString(1,locale);
					pstmt2.setString(2,locale);
					pstmt2.setString(3,locale);
					pstmt2.setString(4,accession_num);
					pstmt2.setString(5,patient_id);
					rs2 = pstmt2.executeQuery();
					
					while(rs2.next())
					{
						authorized_by		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );
						last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
						doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );
						performing_phy_name		=	checkForNull( rs2.getString("performed_by_name") );
						med_service		=	checkForNull( rs2.getString("service_name") );
						service_code = checkForNull( rs2.getString("service_code") ); // Setting the service code in case of modify
						status = checkForNull( rs2.getString("status") );
						
						if(status.equals("1"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
						else if(status.equals("2"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
						else if(status.equals("3"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
						else if(status.equals("4"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
						else if(status.equals("5"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
						else if(status.equals("9"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
					}
					
				}
				catch (Exception roro )
				{
					out.println("Exception in MRecClinicalNotesSection.jsp getting section content : "+roro.toString());
					roro.printStackTrace();

				}
				finally 
				{
				  if(rs2 != null) rs2.close();
				  if(pstmt2 != null) pstmt2.close();
				}
            }
			encounter_id1=encounter_id;
			if(encounter_id.equals("0"))
				encounter_id1="";
			htParameter.put("V$ATT_PRACT", attending_practitioner);
			htParameter.put("V$PT_SPLTY", speciality_name);
			htParameter.put("V$PT_NAME", patient_name);
			htParameter.put("V$PT_ID", patient_id);
			htParameter.put("V$SEX", Sex);
			htParameter.put("V$AGE", age);
			htParameter.put("V$ENC_ID", encounter_id1);
			htParameter.put("V$ADM_DT", visit_adm_date); 
			htParameter.put("V$DIS_DT", discharge_date); 
			htParameter.put("V$MED_SERV", med_service);
			htParameter.put("V$DOC_REF_H", doc_ref_id);
			htParameter.put("V$PT_LOCN", location_desc); 
			htParameter.put("V$PT_CLASS", patient_class);
				
				
			//sectionContentUpdatedXML = new StringBuffer();
			StringBuffer section_content_new = new StringBuffer(section_content);
	
			if(!section_content_new.toString().equals("") && !section_content_new.toString().equals("&nbsp;") && section_content_new != null)
			{
				//***************************** [CRF-118] Start *****************************					
				eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
				HashMap paramHash=new HashMap();
				Hashtable tempParameter=new Hashtable();
				paramHash.put("#p_patient_id#",patient_id);
				paramHash.put("#p_encounter_id#",encounter_id1);
				paramHash.put("#p_accNum#",accession_num);
				paramHash.put("#p_locale#",locale);
				paramHash.put("#p_eventDate#",event_date_time); //IN039562
				paramHash.put("#p_facility_id#",facility_id);//IN038439
				tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
				if(tempParameter.size()>0){					
				htParameter.putAll(tempParameter);
				}
				//*****************************[CRF-118] Ends *****************************
				sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
			}

				
			if(!report_header_code.equals("") && report_header_code != null)
			{
				sectionBean.setSectionValues(report_header_code,report_header_code,"T","N","N","N","N","","N","N", sectionContentUpdatedXML.toString(),"",output_form_exists_yn);
			}
				
			section_content ="";
			//Report Header ENDS
			
			// notes header STARTS
			try
			{
				String hdr_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(hdr_sect_query);
				pstmt2.setString(1,note_header_code);
				rs2 = pstmt2.executeQuery();
				if(rs2.next())
				{
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
					if(clob_notes_content!=null)
					{
						try
						{
							content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
							bf_content_reader	= new java.io.BufferedReader(content_reader);
							char[] arr_notes_content = new char[(int)clob_notes_content.length()];
							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
							section_content = new String(arr_notes_content);
							bf_content_reader.close();
										
							if(section_content == null)
								section_content = "";
						}
						catch(Exception e)
						{
							out.println("Exception@1-readCLOB : "+e);
							e.printStackTrace();
						}
					}
				}
			}
			catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
			htParameter=new Hashtable();
			htParameter.put("V$PR_DATE", event_date_time);
			htParameter.put("V$NT_STATUS", note_status);
			htParameter.put("V$NT_TITLE", note_title);
			htParameter.put("V$NT_TYPE", note_type_desc);
			htParameter.put("V$PR_BY_PRACT", performing_phy_name);
			htParameter.put("V$DOC_REF_NH", doc_ref_id); 
			htParameter.put("V$NT_MEDSRV", med_service);
			
			sectionContentUpdatedXML.delete(0,sectionContentUpdatedXML.length())  ;
			section_content_new = new StringBuffer(section_content);
			
			
			//changing the prompt values
			if(!section_content_new.toString().equals(""))
			{
				//IN041827 Start
				eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
				HashMap paramHash=new HashMap();
				Hashtable tempParameter=new Hashtable();
				paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
				paramHash.put("#p_accNum#",accession_num);
				paramHash.put("#p_locale#",locale);
				paramHash.put("#p_pract_id#",clinician_id);
				tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
				
				if(tempParameter.size()>0)
				{					
					htParameter.putAll(tempParameter);
				}
				//IN041827 Ends
				sectionContentUpdatedXML = prompt_parser.changePromptValuesForComps(section_content_new,htPrompt,locale);
			}
			

			if(!sectionContentUpdatedXML.toString().equals("") && sectionContentUpdatedXML != null)
			{
				sectionContentUpdatedXML = parser.updateXMLContentValues(sectionContentUpdatedXML,htParameter,locale);
			}

			//new ends
			if(!note_header_code.equals("") && note_header_code != null)
			{
				sectionBean.setSectionValues(note_header_code,note_header_code,"T","N","N","N","N","","N","N", sectionContentUpdatedXML.toString(),"",output_form_exists_yn);
				
			}
					
			section_content ="";
			//Notes header ENDS....
			
			query_section_details.append("select sec_hdg_code,1 DOC_EXISTS,");
			query_section_details.append("case when ? = 'en' then replace(sec_hdg_desc,'''','') else ");
			query_section_details.append("replace(CA_GET_DESC.CA_SECTION_HDG(SEC_HDG_CODE ,? ,'1'),'''','') end sec_hdg_desc");
			query_section_details.append(",sec_content_type,sec_result_linked_rec_type,");
			query_section_details.append("NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, ");
			query_section_details.append("CASE 	WHEN CHILD_SEC_HDG_CODE = NULL THEN ''");
			query_section_details.append("ELSE case when ? = 'en' then replace(child_sec_hdg_desc,'''','') ");
			query_section_details.append("else replace(CA_GET_DESC.CA_SECTION_HDG(child_sec_hdg_code,?,'1'),'''','') ");
			query_section_details.append("end end child_sec_hdg_desc ");
			query_section_details.append(",child_sec_content_type, child_sec_result_link_rec_type, CHIEF_COMPLAINT_SEC_YN");
			query_section_details.append(",IMAGE_LINKED_YN,'Y' CONTENT_EDITABLE_YN");
			query_section_details.append(",nvl(child_sec_result_link_rec_type,sec_result_linked_rec_type) result_link_type");
			query_section_details.append(",nvl(child_sec_content_type,sec_content_type) content_type, OUTPUT_FORM_EXISTS_YN,SELECTION_TYPE ");  
			query_section_details.append("from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num");
			
			pstmt		=	con.prepareStatement(query_section_details.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,note_type);
		
			strKey = patient_id + "~"+ encounter_id;
			strKey = strKey.trim();
			sectionBean.getPatientSection(strKey);
			
			rs			=	pstmt.executeQuery();
			String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
			
			PreparedStatement addendumTextPstmt = null;
			ResultSet addendumTextRs = null;
			//IN033677,ends
			
			
		

            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(note_type_desc ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_name ));
            _bw.write(_wl_block13Bytes, _wl_block13);

			while(rs.next())
			{
			
				addendumTextPstmt = con.prepareStatement(addendumTextSql);//IN033677
				doc_exists									=	checkForNull(rs.getString("DOC_EXISTS"));
				sec_hdg_code								=	checkForNull( rs.getString("sec_hdg_code") );
				sec_hdg_desc								=	checkForNull( rs.getString("sec_hdg_desc") );
				sec_content_type							=	checkForNull( rs.getString("sec_content_type") );
				sec_result_linked_rec_type					=	checkForNull( rs.getString("sec_result_linked_rec_type") );
				child_sec_hdg_code							=	checkForNull( rs.getString("child_sec_hdg_code") );
				child_sec_hdg_desc							=	checkForNull( rs.getString("child_sec_hdg_desc") );
				child_sec_content_type						=	checkForNull( rs.getString("child_sec_content_type") );
				child_sec_result_link_rec_type				=	checkForNull( rs.getString("child_sec_result_link_rec_type") );
				chief_complaint_sec_yn						=   checkForNull( rs.getString("chief_complaint_sec_yn") );
				image_linked_yn								=   checkForNull( rs.getString("image_linked_yn") );
				strContentEditableYn						=	checkForNull( rs.getString("CONTENT_EDITABLE_YN") );
				content_type								=	checkForNull( rs.getString("content_type") );
				result_link_type							=	checkForNull( rs.getString("result_link_type") );
				output_form_exists_yn							=	rs.getString("OUTPUT_FORM_EXISTS_YN") ;
				result_link_yn								=	"N";
				selection_type							= rs.getString("SELECTION_TYPE")==null?"S":rs.getString("SELECTION_TYPE"); 	
				
				//IN033677,starts				
				addendumTextPstmt.setString(1,accession_num);
				addendumTextPstmt.setString(2,sec_hdg_code);
				addendumTextPstmt.setString(3,child_sec_hdg_code);
				addendumTextRs				=	addendumTextPstmt.executeQuery();
				String addendumText = "";
			
				if(addendumTextRs.next())
				{
					addendumText = addendumTextRs.getString("addendum_text");
				}
				//IN033677,ends
			
				if(strContentEditableYn == null || strContentEditableYn.equals("") )
					strContentEditableYn = "Y";	
			
				if(content_type.equals("R"))
				{
					content_type = "F";
					result_link_yn = "Y";
				}		
			
				if( operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") || operation_mode.equals("UpdateRecord") || !accession_num.equals("") )
				{
					query_notes_detail = "SELECT A.NOTES_SECTION_CONTENT,A.CHIEF_COMPLAINT_SEC_YN, DECODE(B.ACCESSION_NUM,NULL,'N','Y') IMAGE_RECORDED_YN, B.IMG_CONTENT FROM CA_ENCNTR_NOTE_SECTION A , CA_ENCNTR_NOTE_SECTION_OBJ B WHERE /*A.FACILITY_ID = ? AND */A.ACCESSION_NUM = ? AND A.SEC_HDG_CODE = ?  AND  A.SUBSEC_HDG_CODE = ?  AND B.OPERATING_FACILITY_ID(+)=A.FACILITY_ID AND B.ACCESSION_NUM(+)=A.ACCESSION_NUM AND b.SEC_HDG_CODE(+) = a.SEC_HDG_CODE AND  b.SUBSEC_HDG_CODE(+) =a.SUBSEC_HDG_CODE  ";
					pstmt1			=	con.prepareStatement(query_notes_detail);
					//pstmt1.setString(1, facility_id);
					pstmt1.setString(1, accession_num);
					pstmt1.setString(2, sec_hdg_code);
					pstmt1.setString(3, child_sec_hdg_code);
			
					rs1				=	pstmt1.executeQuery();
					
					section_content		=	"";
					image_content		=	"";
			
					if(rs1.next())
					{
						chief_complaint_sec_yn		=	checkForNull( rs1.getString("chief_complaint_sec_yn") );
						clob_notes_content			=	(java.sql.Clob) rs1.getObject("notes_section_content");
						clob_section_image_content	=	(java.sql.Clob) rs1.getObject("img_content");
						image_recorded_yn			=	rs1.getString("image_recorded_yn");
			
						if(clob_notes_content!=null)
						{
							try
							{
								content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
								bf_content_reader	= new java.io.BufferedReader(content_reader);
								char[] arr_notes_content = new char[(int)clob_notes_content.length()];
								bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
								section_content = new String(arr_notes_content);
								bf_content_reader.close();
								
								if(section_content == null)
									section_content = "";
									
								if(image_recorded_yn.equals("Y"))
								{
									if(clob_section_image_content != null)
									{
										content_reader	= ((java.sql.Clob) clob_section_image_content).getCharacterStream();
										bf_content_reader = new java.io.BufferedReader(content_reader);
										arr_notes_content = new char[(int)clob_section_image_content.length()];		bf_content_reader.read(arr_notes_content,0,(int)clob_section_image_content.length());
										image_content = new String(arr_notes_content);
										//image_content = java.net.URLEncoder.encode(image_content);
										bf_content_reader.close();
										
										//IN057343 Start.											
										section_image_height  = checkForNull((String) sectionBean.getSectionImageHeight(sec_hdg_code,child_sec_hdg_code),"");  
										if("0".equals(section_image_height) && !"".equals(image_content)){ 
											BASE64Decoder decoder = new BASE64Decoder();
											byte[]  imageByte = decoder.decodeBuffer(image_content);
											ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
											BufferedImage bimg = ImageIO.read(bis);
											section_image_height         = String.valueOf(bimg.getHeight());
											
											sectionBean.setSectionImageHeight(sec_hdg_code,child_sec_hdg_code,section_image_height);
										}
										//IN057343 End.
									}
								}
							}
							catch(Exception e)
							{
								out.println("Exception@1-readCLOB : "+e);
								e.printStackTrace();
							}
						}
					}
					
					if(pstmt1!=null){	pstmt1.close();	}
					if(rs1!=null)	{	rs1.close();	}
			
					if(content_type.equals("T")  && !section_content.equals(""))
					{							
						sbResult.delete(0,sbResult.length());
						sbResult.append(section_content);
						if (!locale.equals("en")) {
							HashMap<String,String> paramMap = new HashMap<String,String>();
							paramMap.put("CURR_SEC_HDG_CODE",child_sec_hdg_code);
							paramMap.put("LOCALE",locale);						
							paramMap.put("RANGE_PASER_YN","N");
							eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,sbResult);
							sbResult = tempLangParse.getLangReplacedXML();
							tempLangParse = null;
						}
						section_content = sbResult.toString();
					}
					
					if(output_form_exists_yn.equals("Y"))
					{
						String query_out_det ="select NOTES_SECTION_RESULT from CA_ENCNTR_NOTE_SEC_OUTPUT where SEC_HDG_CODE =? and SUBSEC_HDG_CODE =? and ACCESSION_NUM =? and FACILITY_ID =? and rownum =1 " ;
						pstmt1		=	con.prepareStatement(query_out_det);
						pstmt1.setString(1, sec_hdg_code); 
						pstmt1.setString(2, child_sec_hdg_code); 
						pstmt1.setString(3, accession_num); 
						pstmt1.setString(4, facility_id); 
						rs1				=	pstmt1.executeQuery();
			
						if(rs1.next())
						{
							clob_notes_content			=	(java.sql.Clob) rs1.getObject("NOTES_SECTION_RESULT");
							
			
							if(clob_notes_content!=null)
							{
								try
								{
									content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
									bf_content_reader	= new java.io.BufferedReader(content_reader);
									char[] arr_notes_content = new char[(int)clob_notes_content.length()];
									bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
									section_content_out = new String(arr_notes_content);
									bf_content_reader.close();
									
									if(section_content_out == null)
										section_content_out = "";
																
								}
								catch(Exception e)
								{
									out.println("Exception@1-readCLOB : "+e);
									e.printStackTrace();
								}
							}
						}
					
						if(pstmt1!=null){	pstmt1.close();	}
						if(rs1!=null)	{	rs1.close();	}
						
						sec_hdg_code_out =sec_hdg_code+"_out";
						child_sec_hdg_code_out =child_sec_hdg_code+"_out";
						sectionBean.setSectionValues(sec_hdg_code_out,child_sec_hdg_code_out,"T","N","N","N","N","","N","N", section_content_out,"",output_form_exists_yn);
			
						section_content_out ="";
						
					} //end if out
					
					if(!"".equals(addendumText)){
						sectionBean.setAddendumText(sec_hdg_code,child_sec_hdg_code,addendumText);//IN033677
					}
				}
			
			
				sectionBean.setSectionValues(sec_hdg_code,child_sec_hdg_code,content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,result_link_type, image_edited_yn,edited_yn, section_content, image_content,output_form_exists_yn);
			
				if(chief_complaint_sec_yn.equals("Y"))		// Only One section as Chief Complaint
				{	
					String queryChiefComplaint = "select COMPLAINT_ID from CA_ENCNTR_NOTE_SEC_COMPLAINT where facility_id = ? and accession_num = ? and SEC_HDG_CODE = ?";					
					
					try
					{
						pstmt1 = con.prepareStatement(queryChiefComplaint);
						pstmt1.setString(1, facility_id);
						pstmt1.setString(2, accession_num);
						pstmt1.setString(3, sec_hdg_code);
			
						rs1 = pstmt1.executeQuery();
					
						String complaint= "";
			
						while(rs1.next())
						{
							complaint = rs1.getString(1);
							recSet.add(complaint);
						}
					}
					catch (Exception ee2)
					{
						out.println("Exception@2-readChiefcomplaint : "+ee2);
						ee2.printStackTrace();
			
					}
					finally
					{
						if(pstmt1!=null){	pstmt1.close();	}
						if(rs1!=null)	{	rs1.close();	}
					}
			
					if(!recSet.isEmpty())
						sectionBean.setSectionChiefComplaint(sec_hdg_code,child_sec_hdg_code,recSet);	
				}
			
					if(!(sec_hdg_code.equals(prev_sec_hdg_code)))
					{
						sub_section_counter = 0;
						
						tblrow_id = "tblrow_id"+(cnt);
						cnt++;					
						if(!sec_content_type.equals("S")){//Individual item

            _bw.write(_wl_block14Bytes, _wl_block14);
							
						}
						else{//Item with Subsections

            _bw.write(_wl_block2Bytes, _wl_block2);

						}
						
						
					
						prev_sec_hdg_code	=	sec_hdg_code;
					}
			
					if(sec_content_type.equals("S"))
					{
						tblrow_id = "tblrow_id"+(cnt);
						/*if((cnt%2)==0)	classValue	=	"QRYEVEN";
						else			classValue	=	"QRYODD";*/
						
						if(child_sec_hdg_desc.equals(""))
						{						
						}
						else
						{				
							if(image_linked_yn.equals("Y"))
								sub_section_counter++;
							
								if(sub_section_counter == 1 )
								{
									//out.println("document.getElementById("no_of_sub_sections_")"+sec_hdg_code+"_anchor.style.visibility = '';");
									cnt_ofMainSections =cnt_ofMainSections+(cnt_ofMainSections.equals("")?((cnt) + ""):("|" + (cnt)));
									ids_of_mainSections =ids_of_mainSections+ (ids_of_mainSections.equals("")?((sec_hdg_code) + ""):("|" + (sec_hdg_code)));
								}								

            _bw.write(_wl_block15Bytes, _wl_block15);
								
						}
						
						cnt++;
					}
					cntSec++;
			}// end of while(rs.next())	



            _bw.write(_wl_block16Bytes, _wl_block16);

			//IN033677,starts
			if(addendumTextPstmt!=null)
				addendumTextPstmt.close();
			if(addendumTextRs!=null)
				addendumTextRs.close();
			
			if(!accession_num.equals("&nbsp;") && !accession_num.equals(""))
			{
				addendumTextPstmt = con.prepareStatement(addendumTextSql);
				addendumTextPstmt.setString(1,accession_num);
				addendumTextPstmt.setString(2,"*AmmendNotes*");
				addendumTextPstmt.setString(3,"*AmmendNotes*");
				addendumTextRs				=	addendumTextPstmt.executeQuery();
				String addendumText = "";
			
				if(addendumTextRs.next())
				{
					addendumText = addendumTextRs.getString("addendum_text");
				}
			
				sectionBean.setAddendumText("*AmmendNotes*","*AmmendNotes*",addendumText);
			}
			//IN033677,ends
			
			// putting notes footer in bean

			 if (!footer_code.equals("") && footer_code != null) 
			{
				try
				{			  
					String footer_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
					pstmt2	= con.prepareStatement(footer_sect_query);
					pstmt2.setString(1,footer_code);
					rs2 = pstmt2.executeQuery();


					if(rs2.next())
					{
					
						clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
						
					if(clob_notes_content!=null)
					{
					try
						{
					
						content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
						bf_content_reader	= new java.io.BufferedReader(content_reader);
						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
						section_content = new String(arr_notes_content);
						bf_content_reader.close();
										
						if(section_content == null)
							section_content = "";
						}
						catch(Exception e)
						{
							out.println("Exception@1-readCLOB : "+e);
							e.printStackTrace();
						}


					 }
					}
				}

				catch(Exception eee)
				{
					out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
					eee.printStackTrace();

				}
				finally
				{
					if(rs2 != null) rs2.close();
					if(pstmt2 != null) pstmt2.close();
				}
			
				
			
				htParameter=new Hashtable();
				htParameter.put("V$CUR_USR", login_user_id);
				htParameter.put("V$AT_PRACT", authorized_by);
				htParameter.put("V$LT_MODI_USR", last_amended_by);
				htParameter.put("V$PRN_DTTIME", print_date_time);
				htParameter.put("V$DOC_REF_F", doc_ref_id);
								
				section_content_new = new StringBuffer(section_content);
				//IN038439 Start
						if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
						{													
							eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
							HashMap paramHash=new HashMap();
							Hashtable tempParameter=new Hashtable();
						
							paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
							paramHash.put("#p_accNum#",accession_num);
							paramHash.put("#p_locale#",locale);
							paramHash.put("#p_pract_id#",clinician_id);
							tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);	
							if(tempParameter.size()>0)
							{					
								htParameter.putAll(tempParameter);
							}
						}
				 //IN038439 Ends
				sectionContentUpdatedXML = new StringBuffer();
			
				if(!section_content_new.toString().equals("") && section_content_new != null)
				{
					sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
				}



				
				if(!footer_code.equals("") && footer_code != null)
				{
					sectionBean.setSectionValues(footer_code,footer_code,"T","N","N","N","N","","N","N", sectionContentUpdatedXML.toString(),"",output_form_exists_yn);
				}
			}
			section_content ="";
	
			tblrow_id = "tblrow_id"+(cnt);

            _bw.write(_wl_block17Bytes, _wl_block17);
		}
		
		// setting pat details in bean
		htPatDet.put("PATIENT_ID",patient_id); htPatDet.put("PATIENT_NAME",patient_name);
		htPatDet.put("REGN_DATE",regn_date);  htPatDet.put("GENDER",Sex);
		htPatDet.put("RESIDENTAIL_ADDRESS",res_addr);
		htPatDet.put("AGE",age);   	htPatDet.put("FACILITY_NAME",facility_name);
		htPatDet.put("DATE_OF_BIRTH",date_of_birth); htPatDet.put("MAR_STATUS_CODE",mar_status);
		htPatDet.put("NATIONALITY_CODE",nationality);
		htPatDet.put("RH_FACTOR",rh_factor); 	htPatDet.put("BLOOD_GRP",blood_grp);
		htPatDet.put("RES_AREA_CODE",res_area_code);	htPatDet.put("RES_TOWN_CODE",res_town_desc);
		htPatDet.put("RELGN_CODE",relgn); 	htPatDet.put("NAME_PREFIX",name_prefix);
		htPatDet.put("REGION_CODE",region_code); 
		htPatDet.put("ENCOUNTER_ID",encounter_id1);
		htPatDet.put("CURRENT_LOCATION",location_desc);
		htPatDet.put("ATTENDING_PRACTITIONER",attending_practitioner);
		htPatDet.put("ADMISSION_DATE",visit_adm_date);
		htPatDet.put("SPECIALITY",speciality_name);
		htPatDet.put("PATIENT_CLASS",patient_class);
		htPatDet.put("ROOM_NUM",room_num);
		htPatDet.put("BED_NUM",bed_num);
		htPatDet.put("SERVICE_CODE",med_service);
		htPatDet.put("ATT_PRACT_WITH_CREDENTIAL",prac_credentials.toString());
		htPatDet.put("PATIENT_NRIC",national_id);//IN043083
	
		sectionBean.setPatOutDetails(htPatDet,patient_id);
		
		putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);
		putObjectInBean("sectionBean",sectionBean,session);
	

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(selection_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(event_status_code));
            _bw.write(_wl_block29Bytes, _wl_block29);

								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sdf.format(new Date())));
            _bw.write(_wl_block31Bytes, _wl_block31);

	ClinicalNotesBC bc = new ClinicalNotesBC();
	ClinicalNotesSectionListResponse sectResp =  bc.getSectionListForNoteType(note_type, locale);
	if(sectResp!=null){
		boolean isSuccessResponse = sectResp.isSuccessResponse();
		boolean isEmptyResponse = sectResp.isEmptyDataResponse();
		ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
		List<ClinicalNotesSectionItem> sectList = sectResp.getSectionList();
		errorList = sectResp.getErrorsList();
		if(sectList!=null  && !sectList.isEmpty())
			isEmptyResponse = false;
		if(isSuccessResponse && !isEmptyResponse){

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block33Bytes, _wl_block33);
				
				if(operation_mode.equals("ModifyAddendum") && !event_status_code.equals("1")){
				
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf("true"));
            _bw.write(_wl_block35Bytes, _wl_block35);

				}
				
            _bw.write(_wl_block36Bytes, _wl_block36);

String prevSectCode = "";
HashMap<String, ArrayList<ClinicalNotesSectionItem>> subSectionsMap = new HashMap<String, ArrayList<ClinicalNotesSectionItem>>();
for(int i=0;i<sectList.size();i++){
	ClinicalNotesSectionItem currentSect = sectList.get(i);
	String sectionCode = currentSect.getSectionCode();
	String sectionDesc = currentSect.getSectionDesc();
	String sectionContentType = currentSect.getSectionContentType();
	if(!sectionContentType.equals("S")){
String opertion_type;
		
if(operation_mode.equals("ModifyAddendum") && !event_status_code.equals("1"))	{	
	opertion_type="A";
	
}else{
	opertion_type=sectionContentType;
	
}

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sectionDesc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sectionContentType));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(opertion_type));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(sectionDesc));
            _bw.write(_wl_block44Bytes, _wl_block44);
if(!operation_mode.equals("ModifyAddendum") ||(operation_mode.equals("ModifyAddendum") && event_status_code.equals("1"))){
if(i==0)
            out.print( String.valueOf("true"));
else
            out.print( String.valueOf("false"));
}
else
            out.print( String.valueOf("false"));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(sectionDesc ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block47Bytes, _wl_block47);
	
	}
	else if(sectionContentType.equals("S")){
		if(subSectionsMap.containsKey(sectionCode)){
			subSectionsMap.get(sectionCode).add(currentSect);
		}else{
			ArrayList<ClinicalNotesSectionItem> subSectionItemsList = new ArrayList<ClinicalNotesSectionItem>();
			if(!currentSect.getChildSectionDesc().equals(""))
				subSectionItemsList.add(currentSect);
			subSectionsMap.put(sectionCode, subSectionItemsList);
		}
		
		if(!prevSectCode.equals(sectionCode)){

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sectionDesc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sectionContentType));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sectionContentType));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(sectionDesc));
            _bw.write(_wl_block44Bytes, _wl_block44);
if(i==0)
            out.print( String.valueOf("true"));
else
            out.print( String.valueOf("false"));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(sectionDesc ));
            _bw.write(_wl_block49Bytes, _wl_block49);
		
		}
	}
	prevSectCode = currentSect.getSectionCode();
}

            _bw.write(_wl_block50Bytes, _wl_block50);

		if(!subSectionsMap.isEmpty()){ //sub sections exists


            _bw.write(_wl_block51Bytes, _wl_block51);

			for(Map.Entry<String, ArrayList<ClinicalNotesSectionItem>> entry : subSectionsMap.entrySet()){
				 ArrayList<ClinicalNotesSectionItem> subItems = entry.getValue();

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(entry.getKey() ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(entry.getKey() ));
            _bw.write(_wl_block54Bytes, _wl_block54);

						if(!subItems.isEmpty()){
							for(int x=0;x<subItems.size();x++){
								ClinicalNotesSectionItem currentSubItem = subItems.get(x);
								String childSectionContentType = currentSubItem.getChildSectionContentType();
								String childSectionDesc = currentSubItem.getChildSectionDesc();
								String childSectionCode = currentSubItem.getChildSectionCode();
								String parentSectionCode = currentSubItem.getSectionCode();
								String parentSectionDesc = currentSubItem.getSectionDesc();
								String parentSectionContentType = currentSubItem.getSectionContentType();

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(childSectionCode));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(parentSectionCode));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(parentSectionDesc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(parentSectionContentType));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(childSectionContentType));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(childSectionCode));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(childSectionDesc));
            _bw.write(_wl_block62Bytes, _wl_block62);
if(x==0)
            out.print( String.valueOf("true"));
else
            out.print( String.valueOf("false"));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(subItems.get(x).getChildSectionDesc() ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(childSectionCode));
            _bw.write(_wl_block65Bytes, _wl_block65);

							}
						}
						else{

            _bw.write(_wl_block66Bytes, _wl_block66);

						}

            _bw.write(_wl_block67Bytes, _wl_block67);

			}

            _bw.write(_wl_block68Bytes, _wl_block68);

		}

            _bw.write(_wl_block69Bytes, _wl_block69);

		}
		else{

            _bw.write(_wl_block70Bytes, _wl_block70);
			
		}
	}
	
			

            _bw.write(_wl_block71Bytes, _wl_block71);

		}
	if(rs!=null) rs.close();
	if(rs1!=null) rs1.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();
	if(con!=null)	ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block72Bytes, _wl_block72);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
