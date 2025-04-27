package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;

public final class __addmodifynursingunit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addModifyNursingUnit.jsp", 1743142686434L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" <!-- included for the CRF - RUT-CRF-013 23396-->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../js/NursingUnit.js\' language=\'javascript\'></script>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<script language=\'javascript\' src=\'../../eIP/js/IPPatInstructions.js\'></script><!--included for the CRF - RUT-CRF-013 23396 -->\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></script>\n<script language=\"JavaScript\">\n\t//Function not moved because the function uses the following script variables.\n\tvar gender_ind = new Array () ;\n\tvar cnt = 0;\n\n\tfunction enableDisableChkSex(obj)\n\t{\n\t   var n = obj.selectedIndex;\n\t   var gender = gender_ind[n];\n\n\t   if (gender==\"M\" || gender==\"F\")\n\t   {\n\t\t  document.forms[0].check_same_sex_in_room_yn.disabled=true;\n\t\t  document.forms[0].check_same_sex_in_room_yn.checked=true;\n\t\t  document.forms[0].check_same_sex.value = \"Y\";\n\t   }\n\t   else\n\t   {\n\t\t  document.forms[0].check_same_sex_in_room_yn.disabled=false;\n\t\t  document.forms[0].check_same_sex_in_room_yn.checked=false;\n\t\t  document.forms[0].check_same_sex.value = \"N\";\n\t   }\n\t}\n\n\n\nfunction GetValues(obj)\n{\n\t\t\n\t/*\n\t\tThis function is called When mr_section type value changes the mr section drop down enables and disables accrodingly and values are changed.The auto file request checkbox also enables and disables accordingly.\n\n\t*/\n\t//\tvar callfunction=document.forms(0).call_function.value;\n\t\tvar LevelCode=document.getElementById(\'level_of_care_code\').value;\n\t\tvar centralValue=document.forms[0].centralValue.value;\n\n\t\t\n\n\t\tvar callfunction=\"\";\n\n\t\tvar HTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'popSectionVal\'  id=\'popSectionVal\' method=\'post\' action=\'../../eIP/jsp/GetService.jsp\'>\";\n\n\t\tif(obj.name == \"mr_section_type\")\n\t\t{\n\t\t\tif(obj.value == \'D\' && document.NursingUnit_form.reportcnt.value > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"FM_ONLINE_REP_RULE_NOT_DEFINED\",\"FM\"));\n\t\t\t\tobj.value = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tclearlist(document.forms[0].mr_section_type);\n\t\t\t\tclearlist(document.forms[0].mr_section);\n\t\t\t\tclearlist(document.forms[0].mr_location_code);\n\t\t\t\tclearlist(document.forms[0].dflt_file_type);\n\n\t\t\t\tvar seperatefile\t= document.forms[0].separate_file_no_yn.value;\n\t\t\t\tvar sormid\t\t\t= document.forms[0].single_or_multi_files_ind.value;\n\n\t\t\t\tdocument.forms[0].mr_section.disabled=false;\n\n\t\t\t\tHTMLVal+= \"<input id=\'sectionType\' name=\'sectionType\'  type=\'hidden\' value=\'\"+obj.value + \"\'><input type=\'hidden\' name=\'mrsectionName\' id=\'mrsectionName\' value=\'\"+obj.name+\"\'><input name=\'centralValue\' id=\'centralValue\' type=\'hidden\' value=\'\"+centralValue+\"\'><input name=\'fminstall\' id=\'fminstall\' type=\'hidden\' value=\'\"+document.forms[0].fm_install.value+\"\'>\";\n\t\t\t\t/*Friday, March 12, 2010 , 18770 to disable mr_section other than departmental and single_or_multi_files_ind.equals(\"M\") && separate_file_no_yn.equals(\"N\")*/\n\t\t\t\t//if(obj.value==\"C\")\n\t\t\t\tif(obj.value != \"D\")\n\t\t\t\t{\n\t\t\t\t\tif(seperatefile==\"N\" && sormid==\"M\")\n\t\t\t\t\t{\n\t\t\t\t\t\tHTMLVal+=\"<input type=\'hidden\' name=\'seperatefile\' id=\'seperatefile\' value=\'\"+seperatefile+\"\'><input type=\'hidden\' name=\'single_or_multi_files_ind\' id=\'single_or_multi_files_ind\' value=\'\"+sormid+\"\'>\";\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.forms[0].mr_section.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(document.getElementById(\"fm_install\").value == \"Y\")\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tHTMLVal+=\"<input name=\'criteria\' id=\'criteria\' type=\'hidden\' value=\'populatefs\'> \";\n\n\t\t\t\t\tif (obj.value==\"D\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'popUp\').style.visibility=\'visible\';\n\t\t\t\t\t\tdocument.forms[0].online_mr_notfn_yn.value=\"N\";\n\t\t\t\t\t\tdocument.forms[0].online_mr_notfn_yn1.value=\"N\";\n\t\t\t\t\t\tdocument.forms[0].online_mr_notfn_yn.disabled=true;\n\t\t\t\t\t\tdocument.forms[0].online_mr_notfn_yn.checked=false;\n\t\t\t\t\t\tdocument.forms[0].auto_file_transfer_yn.value=\"N\";\n\t\t\t\t\t\tdocument.forms[0].auto_file_transfer_yn.disabled=true;\n\t\t\t\t\t\tdocument.forms[0].auto_file_transfer_yn.checked=false;\n\t\t\t\t\t}\t\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\"popUp\").style.visibility=\'hidden\';\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].create_file_yn.value==\'Y\')\n\t\t\t\t\t\t\tdocument.forms[0].online_mr_notfn_yn.disabled=false;\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tdocument.forms[0].online_mr_notfn_yn.disabled=true;\n\t\t\t\t\t\tdocument.forms[0].auto_file_transfer_yn.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse if(obj.name==\"mr_location_code\")\n\t\t{\n\t\t\tvar fm_installyn=parent.frames[1].document.forms[0].fm_install.value;\n\t\t\n\t\t\tclearlist(document.forms[0].mr_location_code);\n\t\t\tclearlist(document.forms[0].dflt_file_type);\n\n\t\t\tHTMLVal+= \"<input name=\'defaultlocn\' id=\'defaultlocn\' type=\'hidden\' value=\'\"+obj.value+\"\'><input name=\'criteria\' id=\'criteria\' type=\'hidden\' value=\'populateDF\'><input name=\'fminstall\' id=\'fminstall\' type=\'hidden\' value=\'\"+fm_installyn+ \"\'>\";\n\t\t}\n\t\t\n\t\tHTMLVal+=\"<input type=\'hidden\' name=\'callfunction\' id=\'callfunction\' value=\'\"+callfunction+\"\'>\";\n\t\tHTMLVal+=\"<input type=\'hidden\' name=\'levelfcare\' id=\'levelfcare\' value=\'\"+LevelCode+\"\'>\";\n\t\tHTMLVal+= \"</form></body></html>\";\n\n\t\t/*5/12/2009 IN010516*/\n\t\t//if(obj.name != \"\")\n\t\t//{\n\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tparent.messageFrame.popSectionVal.submit();\n\t\t//}\n\n}\n\nfunction clearlist(obj)\n{\n\tif(obj.name == \"mr_section_type\")\n\t{\t\t\t\n\t\tvar length1= parent.frames[1].document.forms[0].mr_section.length;\t\n\t\tfor(i=0;i<length1;i++)\n\t\t{\n\t\t\tparent.frames[1].document.forms[0].mr_section.remove(1);\n\t\t}\n\n\t\tvar length  =parent.frames[1].document.forms[0].mr_location_code.length;\n\t\tfor(i=0;i<length;i++)\n\t\t{\n\t\t  parent.frames[1].document.forms[0].mr_location_code.remove(1);\n\t\t}\t\n\t\t\n\t\t\n\t}\n\telse if(obj.name==\"mr_location_code\")\n\t{\n         var length=parent.frames[1].document.forms[0].dflt_file_type.length;\n\t\t for(i=0;i<length;i++)\n\t\t{\n\t\t\t parent.frames[1].document.forms[0].dflt_file_type.remove(1);\n\t\t}\n\n\t}\n}\n\n\nfunction assignval(obj)\n{\n\tif(obj.checked == true)\n\t{\n\t\tobj.value=\"Y\";\n\t\teval(\"parent.frames[1].document.forms[0].\"+obj.name+\"1\").value=\"Y\";\t\t\t\t\n\t}\n\telse\n\t{\n\t\tobj.value=\"N\";\n\t\teval(\"parent.frames[1].document.forms[0].\"+obj.name+\"1\").value=\"N\";\t\n\t}\t\t\t\n}\n/* Included for the CRF Rut-CRF-013 23396*/\nfunction invokeTab(tabdetails)\n{\n\tif (tabdetails==\'details_tab\')\n\t{\n\t\t// parent.nur_unit_frame.rows=\"42,*,0,50\"; \n\t\t \n\t\t parent.document.getElementById(\"commontoolbarFrame\").style.height=\"8vh\";\n\t\t parent.document.getElementById(\"f_query_add_mod\").style.height=\"83vh\";\n\t     parent.document.getElementById(\"blank\").style.height=\"0vh\";\n\t\t parent.document.getElementById(\"messageFrame\").style.height=\"9vh\";\n\t\tdocument.getElementById(\"Oth_dtls\").style.display = \'inline\';\n\t\tdocument.getElementById(\"pat_instns_div\").style.display = \'none\';\t\n\t\tdocument.getElementById(\"details_tab\").className=\"tabClicked\";\n\t\tdocument.getElementById(\"patinstruction_tab\").className=\"tabA\";\n\t\tdocument.getElementById(\"othdtls_tabspan\").className=\"tabSpanclicked\";\n\t\tdocument.getElementById(\"p_tabspan\").className=\"tabAspan\";\n\t}\n\telse if (tabdetails==\'patinstruction_tab\')\n\t{\n\t\t//parent.nur_unit_frame.rows=\"42,30%,*,5%\"; \n\t\t\n\t\tparent.document.getElementById(\"commontoolbarFrame\").style.height=\"8vh\";\n\t\tparent.document.getElementById(\"f_query_add_mod\").style.height=\"83vh\";\n\t\tparent.document.getElementById(\"blank\").style.height=\"1vh\";\n\t\tparent.document.getElementById(\"messageFrame\").style.height=\"8vh\";\n\t\t\n\t\tdocument.getElementById(\"Oth_dtls\").style.display = \'none\';\n\t\tdocument.getElementById(\"pat_instns_div\").style.display = \'inline\';\n\t\tdocument.getElementById(\"details_tab\").className=\"tabA\";\n\t\tdocument.getElementById(\"patinstruction_tab\").className=\"tabClicked\";\n\t\tdocument.getElementById(\"othdtls_tabspan\").className=\"tabAspan\";\n\t\tdocument.getElementById(\"p_tabspan\").className=\"tabSpanclicked\";\n\t\tdocument.getElementById(\'pat_instns_div\').style.visibility =\'visible\' ; \n\t}\t\n}\n</script>\n</head>\n\n<body onLoad=\"FocusFirstElement();disfilreq(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t<form name=\'NursingUnit_form\' id=\'NursingUnit_form\'  method=\"post\" action=\"../../servlet/eIP.NursingUnitServlet\" target=\"messageFrame\">\n\t<input type=\'hidden\' name=\'all_new_bor\' id=\'all_new_bor\' value=\'\'>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t<!-- <br><br><br><br><br> -->\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<!--    <br><br><br><br> -->\n\t<table cellspacing=0 cellpadding=2 align=\'center\' width=\'100%\' border=\'0\'>\n\t<tr>\n\t\t<td class=\'label\' align=\'right\' width=\'20%\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td  width=\'25%\' align=\'left\'>&nbsp;<input type=\"text\" name=\"nursing_unit_code\" id=\"nursing_unit_code\" size=\'4\' maxlength=\'4\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" onblur=\"javascript:ChangeUpperCase(this)\" onKeyPress=\"return CheckForSpecChars(event)\"><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t<td  width=\'25%\' class=\'label\' align=\'right\'  >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td   width=\'20%\'   align=\'left\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;<select name=\"locn_type\" id=\"locn_type\" >\n\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" ---\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<tr>\n\t\t<td  class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<td align=\'left\' width=\'30%\'>&nbsp;<input type=\"text\" name=\"long_desc\" id=\"long_desc\" size=\'60\' maxlength=\'60\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" onBlur=\"return makeValidString(this);\"><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t<td  class=\'label\' align=\'right\' width=\'25%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td width=\'20%\' align=\'left\'>&nbsp;<input type=\"text\" name=\"short_desc\" id=\"short_desc\" size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" onBlur=\"return makeValidString(this);\"><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t\t<td  class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td align=\'left\' width=\'25%\'><input type=\"checkbox\" name=\"eff_status\" id=\"eff_status\" value=\'E\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" ></td>\n\t\t\t\t<td  class=\'label\' align=\'right\' width=\'25%\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td   align=\'left\' width=\'20%\'>&nbsp;<select name=\"applicable_to\" id=\"applicable_to\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" onChange=\"populateFileType();disableall()\">\n\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t</select><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\t</tr>\n\t<tr>\n<!-- Physical Location for NU -->\n\t\t<td nowrap class=\'label\' align=\'right\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t<td nowrap align=\'left\' >&nbsp;<input type=\"text\" name=\"physical_location\" id=\"physical_location\" size=\'20\' maxlength=\'40\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" onblur=\"\" ></td>\n\t\t<td>&nbsp;</td>\n\t\t<td>&nbsp;</td>\n\t</tr>\n\n\t </table> \n\t<!--Below Line Code Added for this RUT-CRF-013 Shanthi -->\n\t<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0>\n\t<tr>\n\t\t<td width= \"100%\" class=\"white\">\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t<a onclick=\"invokeTab(\'details_tab\')\" class=\"tabClicked\" id=\"details_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"othdtls_tabspan\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t<a onclick=\"invokeTab(\'patinstruction_tab\')\" class=\"tabA\" id=\"patinstruction_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"p_tabspan\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n </td></tr>\n</table>\t\n\t\n\t<!--Above Line Code Added for this CRF  Shanthi-->\n<div id=\'Oth_dtls\'>\n<table cellspacing=0 cellpadding=2 align=\'center\' width=\'100%\' border=\'0\'>\n\t<th align=\'left\'  colspan=\'4\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</th>\n<tr>\n\t<td   class=\'label\' align=\'right\' width=\'20%\'  >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t<td width=\'30%\' align=\'left\'   >\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<input type=\"text\" name=\"mr_section_type_desc\" id=\"mr_section_type_desc\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" readonly>\n\t\t\t<input type=\"hidden\" name=\"mr_section_type\" id=\"mr_section_type\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<select name=\'mr_section_type\' id=\'mr_section_type\' >\n\t\t\t\t\t<option value=\'\' >--- ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" ---</select>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t<select name=\'mr_section_type\' id=\'mr_section_type\' onChange=\'GetValues(this);\' onmousewheel=\'return false;\'>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t<select name=\'mr_section_type\' id=\'mr_section_type\' ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" >\n\t\t\t\t<option value=\'\' >--- ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" ---</select>\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t<option value=\'\' >--- ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" ---\n\t\t\t\t\t<option value=\'D\' selected>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" ---\n\t\t\t\t\t<option value=\'D\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t<option value=\'C\' selected>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<option value=\'\' selected>--- ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t</select>\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t</td>\n\t\t\n\t\t<td   class=\'label\' width=\'25%\' align=\'right\'  >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t<td width=\'20%\' align=\'left\'   >\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t<input type=\"text\" name=\"mr_section_desc\" id=\"mr_section_desc\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" readonly>\n\t\t\t\t<input type=\"hidden\" name=\"mr_section\" id=\"mr_section\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t&nbsp;<select name=\'mr_section\' id=\'mr_section\' disabled><option value=\'\'>--- ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" ---\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t&nbsp;<select name=\'mr_section\' id=\'mr_section\'  ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =">\n\t\t\t\t\t\t<option value=\'\' >--- ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" ---\n\t\t\t\t\t</select>\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t&nbsp;<select name=\'mr_section\' id=\'mr_section\'>\n\t\t\t\t\t\t<option value=\'\' >--- ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" ---\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t </td>\n</tr>\n<tr>\n\t<td   class=\'label\' width=\'20%\' align=\'right\'  >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t<td width=\'30%\' align=\'left\' >\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t&nbsp;<input type=\"text\" name=\"mr_location_desc\" id=\"mr_location_desc\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" readonly>\n\t\t<input type=\"hidden\" name=\"mr_location_code\" id=\"mr_location_code\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t&nbsp;<select name=mr_location_code onchange=\"GetValues(this);\">\n\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" ---\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t</select><img id=\'popUp\' src=\'../../eCommon/images/mandatory.gif\' align=\'center\' style=\'visibility:hidden\'></img>\n\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t </td>\n\t<td align=\'right\' class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t<td align=\'left\' width=\'20%\' >\n\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t&nbsp;<input type=\"text\" name=\"dflt_file_type_desc\" id=\"dflt_file_type_desc\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" readonly>\n\t\t<input type=\"hidden\" name=\"dflt_file_type\" id=\"dflt_file_type\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t&nbsp;<select name=dflt_file_type ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="><option value=\'\'>--- ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</option>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t</select>\n\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td align=\'right\' class=\'label\'  width=\'20%\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t<td align=\'left\' width=\'30%\' >\n\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t<input type=\'checkbox\' name=\'online_mr_notfn_yn\' id=\'online_mr_notfn_yn\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="  onClick=\'assignval(this);chkAutoFilReq(this);\' ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="disabled";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =">\t\n\t\t<input type=\'hidden\' name=\'online_mr_notfn_yn1\' id=\'online_mr_notfn_yn1\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' >\n\t\t<input type=\'hidden\' name=\'create_file_yn\' id=\'create_file_yn\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' >\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t<td  class=\'label\' width=\'25%\' align=\'right\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t<td width=\'20%\' align=\'left\' ><input type=\"checkbox\" name=\"auto_file_transfer_yn\" id=\"auto_file_transfer_yn\" value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" onClick=\'checkvalue(this)\' ></td>\t\n\t</tr>\n</table>\n\n<!-- \t\n<select name=\"mr_section_type\" id=\"mr_section_type\" onchange=\'populatemrSectionType(this);disen();\' ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" ><option value=\'\'> ------- Select ------- ;</option>\n\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t <option value=\'C\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" </option>\n\t <option value=\'D\'>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" </option>\n\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t<option value=\'C\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" </option>\n\t <option value=\'D\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</option>\n\t\t\n\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" \n\t</select></td>\n\n\n\t\t<td  nowrap class=\'label\' align=\'right\' width = \'20%\' >MR Section</td>\n\t\t<td nowrap width = \'20%\'>&nbsp;&nbsp;<select name=\"mr_section_code\" id=\"mr_section_code\"  ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="  style =\'width:145px\'><option value=\'\'> ------- Select ------- ;</option>\n\t\t ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" \n\t\t\t\t</select>\n&nbsp;<img id=\"img3\" src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t</td>\n</tr>\n<tr>\n\t<td nowrap class=\'label\' align=\'right\' nowrap>File Storage Location</td>\n\t\t\t<td nowrap>&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\t\t\t\t<select name=\"fs_locn_code\" id=\"fs_locn_code\" ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" style =\'width:200px\' onChange=\"populateFileType();\">\n\t\t\t\t<option value=\'\'>&nbsp; ------- Select ------- &nbsp;\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\t\t\t</select><img align=\'center\' id=\'mandatory_gif\' src=\'../../eCommon/images/mandatory.gif\' style=\"visibility:hidden\"></img>\n\t\t\t</td>\n\t<td  nowrap class=\'label\' align=\'right\' > &nbsp;Default File Type</td>\n\t<td nowrap >&nbsp;&nbsp;<select name=\"dflt_file_type\" id=\"dflt_file_type\"  ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="  style=\"width:123\">\t\n\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t<option value=\'\'> ------- Select ------- ;</option>\n\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t<option value=\'\'> ------- Select ------- ;</option>\n\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t</select>\n\t</td>\n</tr>\n\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t<tr><td nowrap class=\'label\' align=\'right\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Auto File Request</td>\n\t   <td nowrap>&nbsp;<input type=\"checkbox\" name=\"online_mr_notfn_yn\" id=\"online_mr_notfn_yn\" value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" onClick=\'checkvalue(this)\'></td>\t\n\t   <td nowrap class=\'label\' align=\'right\'>&nbsp;&nbsp;Auto File Transfer</td>\n\t   <td nowrap>&nbsp;<input type=\"checkbox\" name=\"auto_file_transfer_yn\" id=\"auto_file_transfer_yn\" value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="  ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" onClick=\'checkvalue(this)\' ></td>\t\n\t\t   ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t</tr>\n-->\n\n\n<table cellspacing=0 cellpadding=2 align=\'center\' width=\'100%\' border=\'0\'>\n\t<th align=\'left\' width=\'25%\' colspan=\'4\'>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</th>\n\t<tr>\n\t\t<td   class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\t\t<td  width=\'30%\' align=\'left\'>&nbsp;<select name=\"nursing_unit_type_code\" id=\"nursing_unit_type_code\" ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =" ---";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t</select><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\n\t\t<td  class=\'label\' align=\'right\' width=\'25%\'>";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t\t<td  width=\'20%\' align=\'left\'>&nbsp;<select name=\"age_group_code\" id=\"age_group_code\" ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =" onChange=\"enableDisableChkSex(this)\">\n\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t</select>\n\t\t</td>\n\t</tr>\n<tr>\n\n<!-- LEVEL OF CARE  -->\n\t<td  class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td>\n\t<td  width=\'30%\' align=\'left\'>&nbsp;<select name=\"level_of_care_code\" id=\"level_of_care_code\" ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t</select>\n\t</td> \n\t<td colspan=\'2\' class=\'label\'></td>\n</tr>\n\n\t<tr>\n\t\t<td  class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</td>\n\t\t<td  width=\'30%\' align=\'left\'><input type=\"checkbox\" name=\"allow_emerg_trg_yn\" id=\"allow_emerg_trg_yn\" value=\'Y\' ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="></td>\n\t\t<td   class=\'label\' width=\'25%\' align=\'right\'>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td><td  width=\'20%\' align=\'left\'><input type=\"hidden\" name=\"check_same_sex\" id=\"check_same_sex\" value=\'Y\' ><input type=\"checkbox\" name=\"check_same_sex_in_room_yn\" id=\"check_same_sex_in_room_yn\" value=\'Y\' ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 =" onClick=\'assignValues(this)\'></td>\n\t</tr>\n\n\t<tr>\n\t\t<td  class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</td>\n\t\t<td  align=\'left\' width=\'30%\'><input type=\"checkbox\" name=\"temporary_location_yn\" id=\"temporary_location_yn\" value=\'Y\' ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="></td>\n\t\t<td  class=\'label\' align=\'right\' width=\'25%\'>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</td><td  align=\'left\' width=\'20%\'><input type=\"checkbox\" name=\"teaching_location_yn\" id=\"teaching_location_yn\" value=\'Y\' ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="></td>\n\t</tr>\n\n<!-- Release Bed on Leave added on 31/01/04 by Sridhar -->\n\t<tr>\n\t\t<td  class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t\t<td  align=\'left\' width=\'30%\'><input type=\"checkbox\" name=\"rel_bed_on_leave\" id=\"rel_bed_on_leave\" value=\'Y\' ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" ></td>\n\t\t\n\t\t<td  class=\'label\' align=\'right\' width=\'25%\'>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td><td  align=\'left\' width=\'20%\'><input type=\"checkbox\" name=\"incl_for_hosp_occup_calc_yn\" id=\"incl_for_hosp_occup_calc_yn\" value=\'Y\' ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="></td>\n\t</tr>\n\t\t\t<tr>\n\t\t<td  class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t\t<td  align=\'left\' width=\'30%\'><input type=\"checkbox\" name=\"ALLOW_NEW_BORN_REGN_YN\" id=\"ALLOW_NEW_BORN_REGN_YN\" value=\'Y\'  ";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="></td>\n\t\t<td colspan=2></td>\t</tr>\n\n\t<tr><th colspan=\'4\' align=\'left\'>";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="&nbsp;";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</th></tr>\n\t<tr>\n\t\t<td class=\'label\' align=\'right\' width=\'20%\' >";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</td>\n\t\t<td align=\'left\' width=\'30%\'><input type=\"checkbox\" name=\"allow_pseudo_bed_srl_yn\" id=\"allow_pseudo_bed_srl_yn\" value=\'Y\'  ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" onClick=\"javascript:enableDisable(this)\"></td>\n\t\t<td colspan=\'2\'></td>\n\t</tr>\n\n\t<tr>\n\t\t<th align=\'left\' colspan=\'4\'>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</th>\n\t</tr>\n\t<tr>\n\t\t<td   class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</td>\n\t\t<td width=\'30%\' align=\'left\'>&nbsp;<select name=\"dept_code\" id=\"dept_code\" ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" onChange=\"javascript:getService(\'I\')\">\n\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t </select><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\n<!-- SECTION  -->\n\t\t<td   class=\'label\' align=\'right\' width=\'25%\'>";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</td>\n\t\t<td width=\'20%\' align=\'left\'>&nbsp;<select name=\"section\" id=\"section\" ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =" ><option>--- ";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =" ---</option></select>\n\t\t<input type=\"hidden\" name=\"hidden_section_code\" id=\"hidden_section_code\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"></td>\n\t</tr>\n<tr>\n<!-- SERVICE -->\n\t<td nowrap class=\'label\' align=\'right\' >";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</td>\n\t<td nowrap align=\'left\' >&nbsp;<select name=\"service_code\" id=\"service_code\" ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" >\n\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 =" ---</select><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img><input type=\"hidden\" name=\"hidden_service_code\" id=\"hidden_service_code\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" \n\t</td>\n\t<td>&nbsp;</td>\n\t<td>&nbsp;</td>\n\t</tr>\n\t\t\t<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value= \'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n\t\t\t<input type=\"hidden\" name=\"bl_setup_ip\" id=\"bl_setup_ip\" value= \'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n\t\t\t<input type=\"hidden\" name=\"fm_install_yn\" id=\"fm_install_yn\" value= \'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n\t\t\t<input type=\"hidden\" name=\"hdd_param_releaseBed\" id=\"hdd_param_releaseBed\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" >\t\n\t\t\t\t<input type=\"hidden\" name=\"fslocncode\" id=\"fslocncode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\n</table>\n\n<br>\n\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t<table cellspacing=0 cellpadding=2 width=\'100%\' border=\'0\'>\n\t\t<th colspan=\'4\' align=\'left\'>";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</th>\n\t\t<tr><td  class=\'label\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n\t\t\t\t<td  width=\'30%\'>&nbsp;<select name=\"bill_type\" id=\"bill_type\" ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =">\n\t\t\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t\t\t</select><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t<input type=\"hidden\" name=\"hidden_bill_type\" id=\"hidden_bill_type\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" >\n\t\t</td>\n\t\t<td colspan=2></td>\n\t</tr>\n</table>\n\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n</div>\n<!--Included for the CRF - RUT CRF 013 -->\n<div id=\"pat_instns_div\" style=\"visibility:hidden;display:none\">\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\'  align=\'center\'  width=\'100%\'>\n<tr>\n\t<td  colspan=\'5\'>&nbsp;</td>\n</tr> \n<tr>\n\t <td width=\'20%\' class=\'label\'>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td>\n\t <td class=\'fields\'><input type=\'text\' name=\'serial_no\' id=\'serial_no\' value=\"\" size=\'10\' maxlength=\'2\'  onKeyPress=\"return CheckForSpecChar(event)\" onblur=\"if(this.value!=\'\')CheckForZero()\"><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t <td width=\'20%\'>&nbsp;</td>\n     <td class=\'label\'>";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</td>\n\t <td><input type=\"text\" name=\"instruction_desc\" id=\"instruction_desc\" size=\"12\" maxlength=\"200\" value=\"\" onblur=\'getInstructionDesc(instruction_desc)\' ><input type=\'button\' name=\'desc_button\' id=\'desc_button\' value=\'?\'  class=\'button\' onClick=\'getInstructionDesc(instruction_desc)\' ><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n</tr>\n<tr>\n\t <td width=\'20%\' class=\'label\'>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n\t <td class=\'fields\'><input type=\'text\' name=\'instruction_id\' id=\'instruction_id\' size=\'10\' maxlength=\'8\' value=\"\" readonly></td>\n\t <td width=\'20%\'>&nbsp;</td>\n     <td width=\'20%\'>&nbsp;</td>\n\t <td><input type=\'button\' name=\'add\' id=\'add\' value=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' class=\'button\' onClick=\'addRecord()\'>\n\t<input type=\'button\' name=\'del\' id=\'del\'  disabled value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\' class=\'button\' onClick=\'deleteRecord()\' ></td>\n</tr>\n<tr id=\'searchBoxBG\' style=\'display:inline\'>\n\t<td colspan=\"5\">\n\n\t</td>\n</tr> \n</table>\n</div>\n";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\t\n\t<script>\n\t\tdocument.NursingUnit_form.long_desc.select();\n\t</script>\n \t<script>\t\n\t\t\n\t\tparent.frames[2].location.href=\"../../eIP/jsp/IPPatInstructionsResult.jsp?mode=modify&nursing_unit_code=";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="&facility_id=";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\";\n\t</script> \n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t<script>\t\t\n\t\tparent.frames[2].location.href=\"../../eIP/jsp/IPPatInstructionsResult.jsp\";\n\t\t</script> \n\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t<script>\n\t\t\t\tdocument.forms[0].mr_section_type.value\t\t\t  =  \"\";\n\t\t\t\tdocument.forms[0].mr_section_type.disabled\t\t  = true;\n\t\t\t\tdocument.forms[0].mr_section.value\t\t\t      =  \"\";\n\t\t\t\tdocument.forms[0].mr_section.disabled\t\t\t  = true;\n\t\t\t\tdocument.forms[0].mr_location_code.value\t\t  =  \"\";\n\t\t\t\tdocument.forms[0].mr_location_code.disabled\t\t  = true;\n\t\t\t\tdocument.forms[0].dflt_file_type.value\t\t\t  =  \"\";\n\t\t\t\tdocument.forms[0].dflt_file_type.disabled\t\t  = true;\n\t\t\t\tdocument.forms[0].online_mr_notfn_yn.disabled    = true;\n\t\t\t\tdocument.forms[0].auto_file_transfer_yn.disabled  = true;\n//\t\t\t\tdocument.forms[0].img3.style.visibility = \'hidden\';\n\t\t\t\t</script>\n\t\n\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t<script>\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' != \"\")\n\t\t\t\t\tdocument.getElementById(\"popUp\").style.visibility=\'visible\';\n\n\t\t\t\tdocument.forms[0].online_mr_notfn_yn.disabled=true;\n\t\t\t\tdocument.forms[0].online_mr_notfn_yn.checked=false;\n\t\t\t\tdocument.forms[0].auto_file_transfer_yn.disabled=true;\n\t\t\t\tdocument.forms[0].auto_file_transfer_yn.checked=false;\n\t\t\t</script>\n";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\t\n\t<script>\n\t\t\tif(document.NursingUnit_form.hdd_param_releaseBed.value == \"Y\")\n\t\t\t   document.NursingUnit_form.rel_bed_on_leave.disabled = true;\n\t\t</script>\n\t\t<input type=\'hidden\' name=\'separate_file_no_yn\' id=\'separate_file_no_yn\' value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' >\n\t\t<input type=\'hidden\' name=\'single_or_multi_files_ind\' id=\'single_or_multi_files_ind\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\' >\n\t\t<input type=\'hidden\' name=\'fm_install\' id=\'fm_install\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' >\n\t\t<input type=\'hidden\' name=\'online_mr_notfn_yn1\' id=\'online_mr_notfn_yn1\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' >\n\t\t<input type=\'hidden\' name=\'maintain_doc_or_file\' id=\'maintain_doc_or_file\' value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' >\n\t\t<input type=\'hidden\' name=\'centralValue\' id=\'centralValue\' value=\"N\">\n\t\t<input type=\'hidden\' name=\'reportcnt\' id=\'reportcnt\' value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n\t\t<input type=\'hidden\' name=\'mode_flag\' id=\'mode_flag\' value=\'false\'>\n\t\t<input type=\'hidden\' name=\'ins_flag\' id=\'ins_flag\' value=\'false\'>\n\n\n</form>\n\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet associateDiagBean= null;synchronized(session){
                associateDiagBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("associateDiagBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(associateDiagBean==null){
                    associateDiagBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("associateDiagBean",associateDiagBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);


	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con				= null;
	Statement st				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt2	= null;
	ResultSet rs				= null;
	ResultSet rset				= null;
	ResultSet rset7				= null;
	Statement stmt2				= null;
	ResultSet rs2				= null;
	Statement dfstmt			= null;
	ResultSet dfrset			= null;
	String shortdesc1			= "";


	String facilityId			= (String)session.getAttribute("facility_id");
	String locale				= (String)session.getAttribute("LOCALE");
	String callfunc				=(request.getParameter("call_func") == null)?"":request.getParameter("call_func");
	
	//included for the CRF - RUT-CRF-013 23396
	
	
	associateDiagBean.clearAll();
		
	String fnval				= "insert";
	String default_code			= "";
	String default_desc			= "";
	String mrflag1				= "Y";
	String dat					= "";
	String chkval				= "";
	String ID					= "";
	String sel					= "";
	String chk1					= "checked";
	String disable				= "";
	String selvalue				= "";
	String chk2					= "";
	String chk3					= "";
	String chk4					= "";
	String chk5					= "";
	String chk6					= "";
	String chk7					= "";
	String rd1					= "";
	String dis1					= "";
	String disbled				= ""; 
	String rdall				= "";
	String disall				= "";
	String disfld 				= "";
	StringBuffer dfsql			= new StringBuffer();
	String defaultdisable		= "";
	String fslocndesc			= "";
	String ALLOW_NEW_BORN_REGN_YN = "";
	StringBuffer sqlString		= new StringBuffer();
	String file_type_code		= "";
	String file_type_desc		= "";
	String fsflag				= "Y";
    String central_value		= "N";
	String fs_locn_code			= "";
	String fs_locn_desc			= "";

	String allow_alter			= request.getParameter("allow_alter");
		if(allow_alter==null)allow_alter="N";

	String disablechksex				= "";
	String nursingunitcode				= "";
	String longdesc						= "";
	String shortdesc					= "";
	String locntype						= "";
	String effstatus					= "";
	String nursingunittypecode			= "";
	String LevelCode					= "";
	String agegroupcode					= "";
	String inclforhospoccupcalcyn		= "";
	String dfltfiletypedesc      		= "";
	String dflt_file_type_code    		= "";
	String allowemergtrgyn				= "";
	String checksamesexinroomyn			= "";
	String temporarylocationyn			= "";
	String teachinglocationyn			= "";
	String allowpseudobedsrlyn			= "";
	//String generatepseudobedsrlyn		= "";
	String deptcode						= "";
	String physicalLocation				= "";
	String servicecode					= "";
	String chk_rel_bed_leave			= "";
	String dis							= "";
	String param_allow_release_bed_on_lv= "N";
	String allow_release_bed_on_lv		= "N";
	String locntypedesc					= "";
	String bill_type					= "";
	String bl_setup_ip					= "N";
	String fslocncode					= "";
	String fm_install_yn				= "";
	String online_mr_notfn_yn			= "Y";
	String auto_file_transfer_yn		= "Y";
	String online_mr_notfn_yn_chk		= "Checked";
	String auto_file_transfer_yn_chk	= "Checked";
	String dayCareDesc					= "";
	String dayCareCode					= "";
	String patientClassCode				= "";
	String sectioncode					= "";
	String mrsection					= "";
	String mrsectiondesc				= "";
	String mrsectioncode				= "";
	String mrSectionType				= "";
	String mrSectionTypedesc			= "";
	String maintain_doc_or_file			= "";
	String single_or_multi_files_ind	= "";
	String separate_file_no_yn			= "";
	String mrflag						= "Y";
	String sql1							= "";
	String create_file_yn				= "";
	int reportcnt						= 0;
	//String shortdes="";

//	String levelofcarecode[] = {"","A","E","F","N","C","R","S"};
//	String levelofcaredesc[] = {" ------- Select ------- ","Ambulatory","Emergency","Isolation","Intensive Care","Critical Care","Routine","Surgery"};

	String code = request.getParameter("nursing_unit_code");
	
	String facid = request.getParameter("facility_id");
	facid=(String)session.getAttribute("facility_id");

	
	try{	
		con = ConnectionManager.getConnection(request);
		stmt= con.createStatement();
		stmt2 = con.createStatement();
		st = con.createStatement();
		
		StringBuffer chkmp = new StringBuffer();
		//chkmp.append("select maintain_doc_or_file, single_or_multi_files_ind, separate_file_no_yn from MP_PARAM ");
		chkmp.append("select maintain_doc_or_file, single_or_multi_files_ind, separate_file_no_yn , create_file_yn from MP_PARAM ");
		rs = st.executeQuery(chkmp.toString());
		if(rs!=null)
		{
			while(rs.next())
			{
				maintain_doc_or_file		= checkForNull(rs.getString("maintain_doc_or_file"));
				single_or_multi_files_ind	= checkForNull(rs.getString("single_or_multi_files_ind"));
				separate_file_no_yn			= checkForNull(rs.getString("separate_file_no_yn"));
				create_file_yn				= checkForNull(rs.getString("create_file_yn"));
			}
		}

		if(maintain_doc_or_file.equals("D"))
			defaultdisable="disabled";
		else
			defaultdisable="";

		

		if(st!=null) st.close();
		if(rs!=null) rs.close(); 

	try
	{
		StringBuffer query_bl_chk = new StringBuffer();
		query_bl_chk.append("select setup_bl_dtls_in_ip_yn,allow_release_bed_on_lv from ip_param where facility_id='"+facilityId+"' ");
		rset = stmt.executeQuery(query_bl_chk.toString());
		if(rset!=null)
		{
			while(rset.next())
			{
				bl_setup_ip=rset.getString("setup_bl_dtls_in_ip_yn");

				param_allow_release_bed_on_lv = rset.getString("allow_release_bed_on_lv");
				if(param_allow_release_bed_on_lv.equalsIgnoreCase("y"))
				{
					chk_rel_bed_leave = "checked";
					dis = "disabled";
				}
				else
				{
					chk_rel_bed_leave = "";
					dis = "";
				}
			}
		}
	}
	catch(Exception e)
	{
		//out.print("Exception @ query_bl_chk :"+e);
		e.printStackTrace();
	}
	
/*try{
		//String str = "Select short_desc,fs_locn_code from fm_storage_locn";
		String str = "Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and locn_identity ='N' and eff_status = 'E' order by short_desc ";

		stmt=con.createStatement();
		rs = stmt.executeQuery(str);
		if(rs != null)
		{
		while(rs.next())
			{
	  shortdesc1=(rs.getString("short_desc") == null)?"":rs.getString("short_desc");
		out.println("shortdesc1=="+shortdesc1);

	}
		}
	
}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	*/

	try
	{
		StringBuffer query_FM_chk = new StringBuffer();
		query_FM_chk.append("select install_yn from sm_module where module_id='FM' ");
		stmt= con.createStatement();
		rset = stmt.executeQuery(query_FM_chk.toString());
		if(rset!=null )
		{
			if(rset.next())
			{
				fm_install_yn=rset.getString("install_yn");
				if (fm_install_yn==null) fm_install_yn="N";
			}
		}
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
	}
	catch(Exception e)
	{
		//out.print("Exception @ query_bl_chk :"+e);
		e.printStackTrace();
	}	
	
	if(code == null)
	{
		code = "";
	}
	else
	{
			fnval  = "modify";
			rd1    = "readonly";
			
			pstmt=con.prepareStatement("select nursing_unit_code, nursing_unit_code,locn_type,locn_short_desc,nursing_unit_long_desc,nursing_unit_short_desc,nursing_unit_type_code,level_of_care_code,age_group_code,dept_code,service_code,physical_location,section_code,patient_class,mr_section_code,mr_section_short_desc,file_type_short_desc,file_type_short_desc,dflt_file_type_code,mr_section_type,LOCN_SHORT_DESC,incl_for_hosp_occup_calc_yn,allow_emerg_trf_yn,temporary_location_yn,teaching_location_yn,allow_pseudo_bed_yn,check_same_sex_in_room_yn,eff_status,online_mr_notfn_yn,auto_file_transfer_yn,release_bed_on_leave_yn,fs_locn_code,FM_GET_DESC.FM_STORAGE_LOCN(FACILITY_ID, fs_locn_code,'"+locale+"','2') fs_locn_desc,ALLOW_NEW_BORN_REGN_YN from IP_NURSING_UNIT_VW where nursing_unit_code=? and facility_id =?");
			
			pstmt.setString(1,code);
			pstmt.setString(2,facid);

			rset=pstmt.executeQuery();
			rset.next();
			ALLOW_NEW_BORN_REGN_YN = checkForNull(rset.getString("ALLOW_NEW_BORN_REGN_YN"));
			if(ALLOW_NEW_BORN_REGN_YN.equals("Y")) 
				ALLOW_NEW_BORN_REGN_YN ="checked";
			else
				ALLOW_NEW_BORN_REGN_YN = "";
			nursingunitcode			= checkForNull(rset.getString("nursing_unit_code"));
			nursingunitcode			= checkForNull(rset.getString("nursing_unit_code"));
			locntype				= checkForNull(rset.getString("locn_type"));
			locntypedesc			= checkForNull(rset.getString("locn_short_desc"));
			longdesc				= checkForNull(rset.getString("nursing_unit_long_desc"));
			shortdesc				= checkForNull(rset.getString("nursing_unit_short_desc"));
			nursingunittypecode		= checkForNull(rset.getString("nursing_unit_type_code"));
			LevelCode				= checkForNull(rset.getString("level_of_care_code"));
			agegroupcode			= checkForNull(rset.getString("age_group_code"));	
			deptcode				= checkForNull(rset.getString("dept_code"));
			servicecode				= checkForNull(rset.getString("service_code"));
			physicalLocation		= checkForNull(rset.getString("physical_location"));
			sectioncode				= checkForNull(rset.getString("section_code"));
			patientClassCode		= checkForNull(rset.getString("patient_class"));
			mrsection				= checkForNull(rset.getString("mr_section_code"));
			mrsectiondesc			= checkForNull(rset.getString("mr_section_short_desc"));
			dfltfiletypedesc		= checkForNull(rset.getString("file_type_short_desc"));
			dflt_file_type_code		= checkForNull(rset.getString("dflt_file_type_code"));
			mrSectionType			= checkForNull(rset.getString("mr_section_type"));
			if(mrSectionType.equals("D"))
				mrSectionTypedesc="Department";
			else if(mrSectionType.equals("C"))
				mrSectionTypedesc="Central";

			if(fm_install_yn.equals("Y"))
			{
				fslocndesc=(rset.getString("LOCN_SHORT_DESC") == null)?"":rset.getString("LOCN_SHORT_DESC");
			}
			inclforhospoccupcalcyn	= checkForNull(rset.getString("incl_for_hosp_occup_calc_yn"));
			allowemergtrgyn			= checkForNull(rset.getString("allow_emerg_trf_yn"));
			temporarylocationyn		= checkForNull(rset.getString("temporary_location_yn"));
			teachinglocationyn		= checkForNull(rset.getString("teaching_location_yn"));
			allowpseudobedsrlyn		= checkForNull(rset.getString("allow_pseudo_bed_yn"));
			//generatepseudobedsrlyn	= checkForNull(rset.getString("generate_pseudo_bed_srl_yn"));
			checksamesexinroomyn	= checkForNull(rset.getString("check_same_sex_in_room_yn"));
			effstatus				= checkForNull(rset.getString("eff_status"));
			online_mr_notfn_yn		= checkForNull(rset.getString("online_mr_notfn_yn"));
			auto_file_transfer_yn	= checkForNull(rset.getString("auto_file_transfer_yn"));
			allow_release_bed_on_lv = checkForNull(rset.getString("release_bed_on_leave_yn"));

			if (online_mr_notfn_yn.equals("Y"))
				online_mr_notfn_yn_chk = "Checked";
			else
				online_mr_notfn_yn_chk = "";
			if (auto_file_transfer_yn.equals("Y"))
				auto_file_transfer_yn_chk = "Checked";
			else
				auto_file_transfer_yn_chk = "";
			String eff_stat=effstatus;
			fs_locn_code 			= rset.getString("fs_locn_code");
			if(fs_locn_code == null) fs_locn_code ="";

			fs_locn_desc 			= rset.getString("fs_locn_desc");
			if(fs_locn_desc == null) fs_locn_desc ="";
			
			
			if(allow_alter!=null && allow_alter.equals("Y"))
			{
				effstatus="E";
			}
			else
			{
				effstatus=eff_stat;
			}
			
			if(effstatus.equals("D"))
			{
				chk1	= "";
				disall	= "disabled";
				rdall	= "readonly";
			}
			if(inclforhospoccupcalcyn.equals("Y"))	chk2 = "checked";
			if(allowemergtrgyn.equals("Y"))			chk3 = "checked";
			if(checksamesexinroomyn.equals("Y"))	chk4 = "checked";
			if(temporarylocationyn.equals("Y"))		chk5 = "checked";
			if(teachinglocationyn.equals("Y"))		chk6 = "checked";

			if(allow_release_bed_on_lv.equals("Y"))  
			{
				chk_rel_bed_leave="checked";
				dis = "disabled";
			}
			else
			{
				chk_rel_bed_leave = "";
				dis = "";
			}
			
			if(allowpseudobedsrlyn.equals("Y"))
			{
				chk7		= "checked";
				dis1		= "disabled";
			}
			else if(fnval.equals("modify"))
				dis1		= "disabled";
			else
				dis1 = "";
			
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			try
			{
				if(bl_setup_ip.equals("Y"))
				{
					StringBuffer query_bill_type = new StringBuffer();
					query_bill_type.append("select bill_type_code from bl_ip_nursing_unit where nursing_unit_code='"+nursingunitcode+"' and facility_id='"+facilityId+"'");

					rs2 = stmt2.executeQuery(query_bill_type.toString());

					if(rs2 != null)
					{
						while(rs2.next())
						{
							bill_type = checkForNull(rs2.getString("bill_type_code"));
						}
					if(rs2!=null) rs2.close();
					if(stmt2!=null) stmt2.close();
					}

					if((bill_type==null)||(bill_type.equals("null")))
					{
						bill_type="";
					}
				}
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}

	try{
		//String str = "Select short_desc,fs_locn_code from fm_storage_locn";
			String str = "Select short_desc,fs_locn_code from fm_storage_locn  where facility_id = '"+facilityId+"' and locn_identity ='N' and eff_status = 'E' order by short_desc ";
			stmt=con.createStatement();
			rs = stmt.executeQuery(str);
			if(rs != null)
			{
				while(rs.next())
				{
					shortdesc1=(rs.getString("short_desc") == null)?"":rs.getString("short_desc");
		

				}
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
	
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		try{
		
			String rptr = "Select 1 from ip_online_report where report_id = 'FMFLRQSL' and nursing_unit_code = '"+nursingunitcode+"' and facility_id ='"+facilityId+"' ";
			stmt=con.createStatement();
			rs = stmt.executeQuery(rptr);
			if(rs != null && rs.next())
			{
				reportcnt = rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	
	

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mrSectionType));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block11Bytes, _wl_block11);
	
	
//	if(bl_setup_ip.equals("N"))
//	{	
            _bw.write(_wl_block12Bytes, _wl_block12);
//	}	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rd1));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		if(fnval.equals("insert"))
		{
		
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

					stmt= con.createStatement();
					//rset=stmt.executeQuery("select locn_type, short_desc from am_care_locn_type where care_locn_type_ind='N'  order by short_desc");
					// modified on 11/7/2008 for ICN-6071 
					
					rset=stmt.executeQuery("select locn_type, short_desc from am_care_locn_type where care_locn_type_ind='N' and sys_user_def_ind = 'S' order by short_desc");
					if(rset!=null)
					{
					   while(rset.next())
					   {
							dat=checkForNull(rset.getString("short_desc"));
							ID=checkForNull(rset.getString("locn_type"));
							if(locntype.equals(ID))
								sel = "selected";
							else
								sel = "";
							out.println("<option value='"+ID+"' "+sel+"  "+rd1+">"+dat+"</option>");
						}
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
					out.print("</select>");}
					else
					{out.print("&nbsp;<input type='text' size=17 maxlength=15 name='locn' id='locn' readonly value='"+locntypedesc+"'>");
						out.print("<input type='hidden'  name='locn_type' id='locn_type'  value='"+locntype+"'>");}
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(fnval.equals("modify"))
		{
		 disbled="disabled";
		}
		
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(longdesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rdall));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rdall));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(chk1));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disbled));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

				stmt= con.createStatement();
				rset=stmt.executeQuery("select patient_class,short_desc from am_patient_class where patient_class in('IP','DC') order by short_desc ");
	
				if(rset!=null)
				{
				   while(rset.next())
				   {
						dayCareDesc = checkForNull(rset.getString("short_desc"));
						dayCareCode = checkForNull(rset.getString("patient_class"));
						if(patientClassCode.equals(dayCareCode))
							sel = "selected";
						else
							sel="";	   
						out.println("<option value='"+dayCareCode+"' "+sel+">"+dayCareDesc+"</option>");
					}
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(physicalLocation));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rdall));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
	if(fnval.equals("modify") && effstatus.equals("D"))
		{	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(mrSectionTypedesc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(mrSectionType));
            _bw.write(_wl_block41Bytes, _wl_block41);
	}
		else
		{
			// For the mr section type only if the single or multi files indicator == M then the values are populated else the field is shown as disabled.
			if(maintain_doc_or_file.equals("F"))
			{
				if(!single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N"))
				{
					mrflag="N";
			
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
	}
				else
				{	
            _bw.write(_wl_block44Bytes, _wl_block44);
	}
			}
			else
			{	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(defaultdisable));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
	}
		
			if(maintain_doc_or_file.equals("F") && mrflag.equals("Y"))
			{
				if(mrSectionType.equals("D"))
				{	
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
	}
				else if(mrSectionType.equals("C"))
				{	
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
	}
				else
				{	
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
	}	
            _bw.write(_wl_block55Bytes, _wl_block55);

			}
		}	
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
		if(fnval.equals("modify") && effstatus.equals("D"))
			{
			
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(mrsectiondesc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(mrsection));
            _bw.write(_wl_block60Bytes, _wl_block60);

			}
			else
			{	
				// For the mr section only if the single or multi files indicator == M && separate_file_no_yn == N then the values are populated else the field is shown as disabled.
				
				if(maintain_doc_or_file.equals("F"))
				{
					/*Friday, March 12, 2010 , 18770 to disable mr_section other than departmental and should satisfy single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N")*/
					//if(!single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N"))
					if(!mrSectionType.equals("D"))
					{
						if(!(single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N")))
						{
						mrflag1="N";
						
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
		
						}
					}
				}
				else
				{	
				
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(defaultdisable));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
		}	
				if(mrflag1.equals("Y"))
				{
				
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

				if(maintain_doc_or_file.equals("F"))
				{
					try
					{
						if(!fnval.equals("insert") && fm_install_yn.equals("Y"))
						{

							if(!mrSectionType.equals(""))
							{
								if(mrSectionType.equals("C"))
								{
									sql1="select mr_section_code,short_name from mr_section where 	facility_id='"+facilityId+"' and eff_status='E' and mr_section_type = 'C' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
								}
								else if(mrSectionType.equals("D"))
								{
									sql1="select mr_section_code,short_name from mr_section where facility_id='"+facilityId+"' and eff_status='E' and mr_section_type = 'D' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
								}

								pstmt=con.prepareStatement(sql1);								
								rs=pstmt.executeQuery();

								if(rs != null)
								{
									while(rs.next())
									{
										mrsectioncode=checkForNull(rs.getString("mr_section_code"));
										if(mrsection.equals(mrsectioncode))
											sel="selected";
										else
											sel="";
										
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mrsectioncode));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(checkForNull(rs.getString("short_name"))));
            _bw.write(_wl_block71Bytes, _wl_block71);
	}
								}

								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
							}
						}
					}catch(Exception e)
					{
						
						e.printStackTrace();
					}

					
            _bw.write(_wl_block72Bytes, _wl_block72);

				}
			}
			}	
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

	 if(fnval.equals("modify") && effstatus.equals("D"))
	{
	
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(fs_locn_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(fs_locn_code));
            _bw.write(_wl_block41Bytes, _wl_block41);

	}
	else
	{	
	
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

		// If the FM install boolean is yes and in insert mode the single and multi files indicator is not M...then the field values are populated.The single and multi files ind is not considered for modify mode.

		if(fm_install_yn.equals("Y"))
		{									
			if(fnval.equals("modify"))
			{
				try
				{
					if(maintain_doc_or_file.equals("F"))
					{
						fsflag="N";
						if(!mrSectionType.equals(""))
						{
							if(mrSectionType.equals("D"))
							{
								pstmt=con.prepareStatement("Select short_desc,fs_locn_code from fm_storage_locn where facility_id = ? and eff_status = 'E' and MR_LOCN_YN='Y' and permanent_file_area_yn='Y' and locn_identity ='"+central_value+"' order by short_desc ");
							}
							else if(mrSectionType.equals("C"))
							{
								pstmt=con.prepareStatement(" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = ? and locn_identity ='"+central_value+"' and permanent_file_area_yn='N' and eff_status = 'E' order by short_desc ");
							}
						}
						else
						{
							pstmt=con.prepareStatement(" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = ? and locn_identity ='"+central_value+"' and permanent_file_area_yn='N' and eff_status = 'E' order by short_desc ");
						}

							pstmt.setString(1,facilityId);

							rs=pstmt.executeQuery();
							if(rs != null)
							{
								while(rs.next())
								{
									

									fslocncode=(rs.getString("fs_locn_code") == null)?"":rs.getString("fs_locn_code");

								
										
									if(fs_locn_code.equals(fslocncode))
										sel="selected";
									else
										sel="";
									
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(fslocncode));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf((rs.getString("short_desc") == null)?"":rs.getString("short_desc")));
            _bw.write(_wl_block79Bytes, _wl_block79);

								}
							}

							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();

					}
				}catch(Exception e)
				{
					
					e.printStackTrace();
				}
			}
		try
		{
			if(fsflag.equals("Y") && !maintain_doc_or_file.equals(""))
			{
				if(maintain_doc_or_file.equals("D"))
				{
					pstmt=con.prepareStatement("Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and locn_identity ='"+central_value+"' and eff_status = 'E' order by short_desc");
				
				}
				else if(maintain_doc_or_file.equals("F")&& fsflag.equals("Y"))
				{
					pstmt=con.prepareStatement("Select short_desc,fs_locn_code from fm_storage_locn   where facility_id = '"+facilityId+"' and eff_status = 'E' and locn_identity ='"+central_value+"' and permanent_file_area_yn='N' order by short_desc ");
				
				}
				
				rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						fslocncode=(rs.getString("fs_locn_code") == null)?"":rs.getString("fs_locn_code");
						if(fs_locn_code.equals(fslocncode))
							sel="selected";
						else
							sel="";
						
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(fslocncode));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf((rs.getString("short_desc") == null)?"":rs.getString("short_desc")));
            _bw.write(_wl_block81Bytes, _wl_block81);

					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			}catch(Exception ef)
			{
				
				ef.printStackTrace();
			}
			
		}
	
            _bw.write(_wl_block82Bytes, _wl_block82);

	}
	
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

	if(fnval.equals("modify") && effstatus.equals("D"))
	{
	
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(dfltfiletypedesc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(dflt_file_type_code));
            _bw.write(_wl_block41Bytes, _wl_block41);

	}
	else
	{
		if(fnval.equals("modify"))
		{
			if(fm_install_yn.equals("Y"))
			{
				dfsql.append(" select a.file_type_code file_type_code,b.short_desc file_type_desc from FM_FILE_TYPE_FOR_FSL a, MR_FILE_TYPE b where b.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id and a.fs_locn_code ='"+fs_locn_code+"'  and a.file_type_code = b.file_type_code and a.eff_status = 'E' ");

				if((LevelCode.equals("A"))&&(!callfunc.equals("DaycareUnit")))
					dfsql.append(" and b.appl_to_ip='Y' ");
				else if((LevelCode.equals("A"))&&(callfunc.equals("DaycareUnit")))
					dfsql.append(" and b.appl_to_dc='Y' ");
				else if(LevelCode.equals("E"))
					dfsql.append(" and b.appl_to_em='Y' ");

				dfsql.append(" order by file_type_desc ");

			}
		}

		/*if(fm_install_yn.equals("N") )
		{
			dfsql.append(" select file_type_code,SHORT_DESC file_type_desc from mr_file_type where facility_id ='"+facilityId+"' and EFF_STATUS = 'E' and appl_to_op = 'Y' order by short_desc ");*/
/*
			if(fnval.equals("insert"))
			{
				if(!callfunc.equals("DaycareUnit")) 
				   dfsql+=" and appl_to_op = 'Y' ";
				else
					dfsql+=" and appl_to_dc='Y'";
			}
			else
			{
				if((LevelCode.equals("A"))&&(!callfunc.equals("DaycareUnit")))
					dfsql+=" and appl_to_op='Y'";
				else if((LevelCode.equals("A"))&&(callfunc.equals("DaycareUnit")))
					dfsql+=" and appl_to_dc='Y'";
				else if(LevelCode.equals("E"))
					dfsql+=" and appl_to_em='Y'";
			}
			 dfsql+=" order by short_desc";
		 */
		/*}*/
		
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(defaultdisable));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

		//if(fnval.equals("modify")  || fm_install_yn.equals("N") )
		if(fnval.equals("modify")  && fm_install_yn.equals("Y") )
		{

			dfstmt=con.createStatement();
			dfrset=dfstmt.executeQuery(dfsql.toString());

			while(dfrset.next())
			{
				default_code=dfrset.getString("file_type_code");
				default_desc=dfrset.getString("file_type_desc");
					
				if(dflt_file_type_code.equals(default_code))	
					selvalue="selected";
				else
					selvalue="";
				
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(default_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(selvalue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(default_desc));
            _bw.write(_wl_block90Bytes, _wl_block90);
	}	
			if(dfrset != null )dfrset.close();
			if(dfstmt != null )dfstmt.close();

		}	
            _bw.write(_wl_block91Bytes, _wl_block91);


		}
		
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

			chkval="";
		//String chkval2= "";

			
			if(online_mr_notfn_yn.equals("Y") && create_file_yn.equals("Y"))
			{
				chkval="checked";
			}
			else if(online_mr_notfn_yn.equals("N"))
			{
				chkval="";
			}
			
			if(maintain_doc_or_file.equals("D"))
			 {
				online_mr_notfn_yn="N";
				chkval="";
			 }

			if(fnval.equals("modify") && ((effstatus.equals(""))||(effstatus==null)||(effstatus.equals("D"))))
			{
				disable="disabled";
			}else
			{
				disable="";
			}
		
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(online_mr_notfn_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(defaultdisable));
            _bw.write(_wl_block96Bytes, _wl_block96);
if(create_file_yn.equals("N")){
            _bw.write(_wl_block97Bytes, _wl_block97);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(online_mr_notfn_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(create_file_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);

			if(auto_file_transfer_yn.equals("Y"))
			{
				chkval="checked";
			}
			else if(auto_file_transfer_yn.equals("N"))
			{
				chkval="";
			}
			
			if(maintain_doc_or_file.equals("D"))
			 {
				auto_file_transfer_yn="N";
				chkval="";
			 }
		
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(auto_file_transfer_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(chkval));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(defaultdisable));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block104Bytes, _wl_block104);
if(fnval.equals("insert")){
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

	}else if(fnval.equals("modify"))
		{
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf((mrSectionType.equals("C"))?"Selected":""));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf((mrSectionType.equals("D"))?"Selected":""));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
}	
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block112Bytes, _wl_block112);

		stmt= con.createStatement();
		rset=stmt.executeQuery(" select SHORT_NAME, MR_SECTION_CODE from MR_SECTION where eff_status='E' and facility_id='"+facilityId+"' and MR_SECTION_TYPE ='"+mrSectionType+"' order by SHORT_NAME");
			if(rset!=null)
			{
			   while(rset.next())
			   {
					dat=checkForNull(rset.getString("SHORT_NAME"));
					ID=checkForNull(rset.getString("MR_SECTION_CODE"));
				
					if(mrsection.equals(ID))
				   {				
						sel = "selected";
				   }
					else
				   {
						sel="";
				   }
					out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
				}
			}
		
            _bw.write(_wl_block113Bytes, _wl_block113);

				  if(disall.equals("disabled"))
					{
				  disfld="disabled";
				    }

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(disfld));
            _bw.write(_wl_block115Bytes, _wl_block115);
				
		if(fnval.equals("modify"))
		{
	
		stmt= con.createStatement();
		if(mrSectionType.equals("C"))
			{
			rset=stmt.executeQuery("select FS_LOCN_CODE, short_desc from fm_storage_locn where locn_identity='N' and eff_status = 'E' and locn_identity = 'N' and permanent_file_area_yn = 'N' and facility_id='"+facilityId+"' order by short_desc");
			}
		else
		if(mrSectionType.equals("D"))
			{
			rset=stmt.executeQuery(" select fs_locn_code, short_desc from fm_storage_locn where facility_id = '"+facilityId+"' and mr_locn_yn ='Y' and permanent_file_area_yn = 'Y' and locn_identity = 'N'");
			}

			if(rset!=null)
			{
			   while(rset.next())
			   {
				dat=checkForNull(rset.getString("short_desc"));
				ID=checkForNull(rset.getString("FS_LOCN_CODE"));
				if(fslocncode.equals(ID))
					sel = "selected";
				else
					sel="";
				out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
				}
			}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		}


            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block117Bytes, _wl_block117);

	if(!dfltfiletypedesc.equals(""))
	{
	
            _bw.write(_wl_block118Bytes, _wl_block118);

		if ((fm_install_yn.equals("Y")) && (!fslocncode.equals("")) && (dayCareCode.equals("IP")))
		{
			sqlString.append(" SELECT distinct a.file_type_code file_type_code, c.short_desc file_type_desc FROM fm_file_type_for_fsl a, mr_file_type c WHERE c.facility_id = ? AND a.facility_id = c.facility_id AND a.fs_locn_code = ? AND a.file_type_code = c.file_type_code AND appl_to_ip = 'Y' ORDER BY file_type_desc ");
		}
		else if ((fm_install_yn.equals("N")) && (dayCareCode.equals("IP")))
		{
			sqlString.append(" SELECT  distinct file_type_code, short_desc file_type_desc FROM mr_file_type WHERE facility_id = ? AND appl_to_ip = 'Y' AND eff_status = 'E' ORDER BY short_desc ");
		} 
		if (sqlString.length() > 0)
		{
			pstmt2	=	con.prepareStatement(sqlString.toString());
			pstmt2.setString(1, facilityId);
			if (fm_install_yn.equals("Y"))
			pstmt2.setString(2, fslocncode);
			rset7	=	pstmt2.executeQuery();
			if (rset7 != null)
			{
				while(rset7.next())
				{
					file_type_code	=	checkForNull(rset7.getString("file_type_code"));
					file_type_desc	=	checkForNull(rset7.getString("file_type_desc"));
					if(dfltfiletypedesc.equals(file_type_desc))
					{
					out.println("<option value='"+file_type_code+"' selected>"+file_type_desc+"</option>");
					}
					else
					{
					out.println("<option value='"+file_type_code+"'>"+file_type_desc+"</option>");
					}
				}
			if(rset7!=null) rset7.close();
			if(pstmt2!=null) pstmt2.close();
		}
		}
	}
	else
		{
		
            _bw.write(_wl_block119Bytes, _wl_block119);

		}
	
            _bw.write(_wl_block120Bytes, _wl_block120);

			if(fm_install_yn.equals("Y"))
	{
			
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(online_mr_notfn_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(online_mr_notfn_yn_chk));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(auto_file_transfer_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(auto_file_transfer_yn_chk));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block124Bytes, _wl_block124);

	}
	   
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

		stmt= con.createStatement();
		rset=stmt.executeQuery(" select short_desc, nursing_unit_type_code from ip_nursing_unit_type where eff_status='E'  order by short_desc");
					if(rset!=null)
					{
					   while(rset.next())
					   {
							dat=checkForNull(rset.getString("short_desc"));
							ID=checkForNull(rset.getString("nursing_unit_type_code"));
							if(nursingunittypecode.equals(ID))
								sel = "selected";
							else
								sel="";
							out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
						}
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
					
				
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

					stmt= con.createStatement();
					rset=stmt.executeQuery("select short_desc, age_group_code, gender from am_age_group where eff_status = 'E' order by short_desc ");
					if(rset!=null)
					{
					   String genderval = "";
					   out.println("<script>gender_ind[cnt]='';cnt++;</script>");
					   while(rset.next())
					   {
							dat	= checkForNull(rset.getString("short_desc"));
							ID	= checkForNull(rset.getString("age_group_code"));
							if(agegroupcode.equals(ID))
								sel = "selected";
							else
								sel	= "";

							genderval = rset.getString(3);
							if (genderval == null) genderval = "";
							if(agegroupcode.equals(ID) && (genderval.equals("M") || genderval.equals("F")))
								disablechksex = "disabled";

							out.println("<script>gender_ind[cnt] = '"+genderval+"';cnt++;</script>");
							out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
						}
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

	stmt= con.createStatement();
	rset=stmt.executeQuery("SELECT LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC FROM am_level_of_care where eff_status = 'E' order by LEVEL_OF_CARE_DESC");
			if(rset!=null)
				{
				   while(rset.next())
				   {
						dat	= checkForNull(rset.getString("LEVEL_OF_CARE_DESC"));
						ID	= checkForNull(rset.getString("LEVEL_OF_CARE_CODE"));
						if(LevelCode.equals(ID))
							sel = "selected";
						else
							sel="";
						out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
					}
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(chk3));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(chk4));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disablechksex));
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(chk5));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(chk6));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(chk_rel_bed_leave));
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(chk2));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(ALLOW_NEW_BORN_REGN_YN));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(chk7));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

				    stmt= con.createStatement();
					rset=stmt.executeQuery("select dept_short_desc, dept_code from am_facility_dept_vw where operating_facility_id='"+facilityId+"' and eff_status = 'E' order by 1");
					if(rset!=null)
					{
					   while(rset.next())
					   {
							dat=checkForNull(rset.getString("dept_short_desc"));
							ID=checkForNull(rset.getString("dept_code"));
							if(deptcode.equals(ID))
								sel = "selected";
							else
								sel="";
							out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
						}
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
					
				
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(sectioncode));
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block41Bytes, _wl_block41);

		if(fnval.equals("modify"))
			out.println("<script>getService('M');</script>");
	
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(bl_setup_ip));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(fm_install_yn));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(param_allow_release_bed_on_lv));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf( fslocncode ));
            _bw.write(_wl_block169Bytes, _wl_block169);

	if(bl_setup_ip.equals("Y"))
	{
	
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(disall));
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

							stmt= con.createStatement();
							rset=stmt.executeQuery("select bill_type_code, short_desc from bl_bill_type where status is null order by 2");
							if(rset!=null)
							{
								while(rset.next())
								{
									dat	= checkForNull(rset.getString("short_desc"));
									ID	= checkForNull(rset.getString("bill_type_code"));
									if(bill_type.equals(ID))
										sel = "selected";
									else
										sel="";
									out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
								}
							}
							if(rset!=null) rset.close();
							if(stmt!=null) stmt.close();
							
						
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(bill_type));
            _bw.write(_wl_block175Bytes, _wl_block175);

	}

            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);

if(fnval.equals("modify"))
{

            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block184Bytes, _wl_block184);
	}
	else if (fnval.equals("insert")) {
		
            _bw.write(_wl_block185Bytes, _wl_block185);

	}

	if(fnval.equals("modify"))
	{
		if(patientClassCode!=null)
		if(patientClassCode.equals("DC"))
		{	
            _bw.write(_wl_block186Bytes, _wl_block186);
	}
	if(mrSectionType.equals("D")&&effstatus.equals("E"))
	   {
	
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block188Bytes, _wl_block188);
	
	}
	}

            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(separate_file_no_yn));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(single_or_multi_files_ind));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(fm_install_yn));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(online_mr_notfn_yn));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(reportcnt));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block196Bytes, _wl_block196);

		if(rset	 != null)	rset.close();
		if(rs2	 != null)	rs2.close();
		if(rs	 != null)	rs.close();
		if(rset7 != null)	rset7.close();
		if(stmt2  != null)	stmt2.close();
		if(st  != null)		st.close();
		if(stmt  != null)	stmt.close();
		if(pstmt != null)	pstmt.close();
		if(pstmt2 != null)	pstmt2.close();

	}catch(Exception e){
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	 
            _bw.write(_wl_block197Bytes, _wl_block197);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApplicableTo.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PhysicalLocation.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FileDetails.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MRSectionType.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Departmental.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Central.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Departmental.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Central.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Departmental.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Central.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MRSection.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FileStorageLocation.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultFileType.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AutoFileRequest.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AutoFileTransfer.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Central.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Departmental.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Central.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Departmental.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Characteristics.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NursingUnitType.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.agegroup.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.levelofcare.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowTransferWOReq.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CheckforSameSexinRoom.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TemporaryLocation.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TeachingLocation.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReleaseBedonLeave.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.IncludeforHospitalOccupancyCalculations.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowNewbornRegn.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Pseudo.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Beds.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowPseudoBeds.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AcctDeptService.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.acctdept.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Section.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BillingParameter.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingClass.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SerialNo.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.InstructionDescript.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.InstructionID.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }
}
