package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eIP.advbedmgmt.transaction.assignbed.AssignBedConstants;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __gbmassignbedsearchpanel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/GBMAssignBedSearchPanel.jsp", 1709117760240L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javaScript\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eIP/js/IPLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eIP/js/IPQueryCommon.js\' language=\'javascript\'></script>\n\t<script src=\"../../eIP/js/IPPractitionerComponent.js\" language=\"javaScript\"></script>\n\t<script src=\'../../js/GBMAssignBed.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n<script>\n\t\t// below code is added for the 17600 end  Wednesday, December 23, 2009\n\t\tfunction clearResultpage()\n\t\t{\n\t\t\tvar resultIFrame = document.getElementById(\'resultframe\');\n\t\t\tif(resultIFrame){\n\t\t\t\tresultIFrame.src = \'../../eCommon/html/blank.html\';\n\t\t\t}\n\t\t\t//parent.frames[2].location.href =\'../../eCommon/html/blank.html\';\n\t\t}\n\n// Added by Sridhar on Jan 3rd 2006...\n// This Function will check for empty values before calling up the common lookup func..\nfunction BeforeGetPractitioner(obj, target, details)\n{\n\tif(details == \'from\')\n\t{\n\t\tif(document.forms[0].from_practid_desc.value !=\"\")\n\t\t\tgetPractitionerLocal(obj, target, details);\n\t\telse\n\t\t\tdocument.forms[0].from_practid.value =\"\"\n\t}\n\telse\n\t{\n\t\tif(document.forms[0].practid_desc.value !=\"\")\n\t\t\tgetPractitionerLocal(obj, target, details);\n\t\telse\n\t\t\tdocument.forms[0].practid.value =\"\";\n\t}\n\n}\n\nfunction getPractitionerLocal(obj, target, details)\n{\n\tvar facility_id\t\t= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\tvar locale\t\t\t= \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tgetPractitioner(obj, target, facility_id, \"\",\"\",\"Q3\");\n\n} // End of getToPractitioner.\n\n// To be called by the GeneralPractitionerSearch to set Practitioner.\nfunction PractLookupRetVal(retVal,objName)\n{\n\tvar arr;\n\tif (retVal != null)\n\t{\n\t\tarr=retVal.split(\"~\");\n\t\tif(objName == \"from_practid_desc\")\n\t\t{\n\t\t\tdocument.forms[0].from_practid.value=arr[0];\n\t\t\tdocument.forms[0].from_practid_desc.value=arr[1];\t\t\t\n\t\t}\n\t\telse if(objName==\'cancel_pract\')\n\t\t{\n\t\t\tdocument.forms[0].cancel_pract_id.value=arr[0];\n\t\t\tdocument.forms[0].cancel_pract.value=arr[1];\n\n\t\t}\t\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].practid.value=arr[0];\n\t\t\tdocument.forms[0].practid_desc.value=arr[1];\t\t\t\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(objName.name == \"practid_desc\")\n\t\t{\n\t\t\tdocument.forms[0].from_practid.value=\"\";\n\t\t\tdocument.forms[0].from_practid_desc.value=\"\";\t\t\t\n\t\t}\n\t\telse if(objName==\'cancel_pract\'){\n\t\t\n\t\t\tdocument.forms[0].cancel_pract_id.value=\"\";\n\t\t\tdocument.forms[0].cancel_pract.value=\"\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].practid.value=\"\";\n\t\t\tdocument.forms[0].practid_desc.value=\"\";\t\t\t\n\t\t}\n\t}\n}\n\nfunction CheckZeroVal(obj) \n{\n\t\n    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) \n\t{\n\t\t\n        return true;\n    }\n    else \n\t{\n\t\tif(obj.value.length > 0 && obj.value==0) \n\t\t{\n\t\t\t\n            alert(getMessage(\"VALUE_SHOULD_BE_GR_ZERO\",\"Common\"));\n            obj.select();\n            obj.focus();\n            return false;\n        }\n    }\n}\n\n//Pls note.. This function is not moved to IPLookup.js as many Java variables are directly used in this function...    \nfunction clearAll()\n{\n\t\t\n\t//parent.frames[1].document.location.href =\'../../eCommon/html/blank.html\';\n\n\t/* if(parent.messageFrame)\n\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\'; */\n\n\tvar resultFrameComp = parent.document.getElementById(\'resultframe\');\n\tif(resultFrameComp){\n\t\talert(\'result\');\n\t\tresultFrameComp.src = \'\';\n\t}else{\n\t\talert(\'result comp not obtained\');\n\t}\n\t\n\t//document.forms[0].search.disabled=false;\n\tvar searchButton = document.getElementById(\'search\');\n\tif(searchButton){\n\t\tsearchButton.disabled = false;\n\t}\n}\n\n//Pls note.. This function is not moved to IPLookup.js as many Java variables are directly used in this function...\nfunction submitPage()\n{\n\t\n\tvar condition=\"\"\n\tfor(var i=0; i<document.forms[0].elements.length; i++)\n\t{\n\t\t\tcondition+= document.forms[0].elements[i].name +\"=\"+ escape(document.forms[0].elements[i].value)+\"&\"\n\t}\n\tdocument.forms[0].search.disabled=true;\n\toper_stn = document.forms[0].operstn.value;\n\troutine_tfr_yn = document.forms[0].routine_tfr_yn.value;\n\tcall_function =document.forms[0].call_function.value;\n\t\n\tvar modalComp = document.getElementById(\"modal\");\n\tvar modalVal = \'\';\n\tif(modalComp){\n\t\tmodalVal = modalComp.value;\n\t}\n\tif(modalVal == \'yes\')\n\t{\n\t\tvar resultDivComp = parent.document.getElementById(\'resultComp\');\n\t\tif(resultDivComp){\n\t\t\talert(\'result is valid\');\n\t\t}else{\n\t\t\talert(\'result comp not obtained\');\n\t\t}\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t}\n\telse\n\t{\n\t\tvar exclude_nda_pats=\"N\";\n\t\tvar resultFrameComp = parent.document.getElementById(\'resultframe\');\n\t\tif(resultFrameComp){\n\t\t\t//alert(\'result is valid\');\n\t\t\tresultFrameComp.src = \'../../eIP/jsp/InpatientLookupQueryResult.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&\'+condition+\'&oper_stn_id=\'+oper_stn+\'&routine_tfr_yn =\'+routine_tfr_yn+\'&show_bed_yn=Y&opst=\'+oper_stn+\'&exclude_nda_pats=\'+exclude_nda_pats+\'\';\n\t\t\tvar legendPanel = parent.document.getElementById(\'legendframe\');\n\t\t\tif(legendPanel){\n\t\t\t\t//alert(\'setting legend panel\');\n\t\t\t\t//legendPanel.innerHTML = \'<\'+\'object id=\"legendObj\" name=\"legendObj\" type=\"text/html\" data=\"QuerySearchResultFrames.jsp?step=assignbed\"\'+\'><\\/object>\';\n\t\t\t\tlegendPanel.src = \'QuerySearchResultFrames.jsp?step=assignbed\';\n\t\t\t\talert(\'legend panel is set\');\n\t\t\t}\n\t\t\t\n\t\t}else{\n\t\t\talert(\'result comp not obtained\');\n\t\t}\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t/* parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\'; */\n\t}\n}\nfunction BeforeGetPractID1(obj1,obj2)\n{\n\tif(document.forms[0].cancel_pract.value!=\"\")\n\t\tgetPractitioner(obj1,obj2,\'\',\'\',\'Q7\');\t// For 17674 (Monday, December 28, 2009)\n}\n\t\n</script>\n</head>\n\t<body onSelect=\"codeArrestThruSelect();\" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' onLoad=\"FocusFirstElement();//checkForMPRequest();\">\n\t\t<form name=\'Inpatientlookup_Form\' id=\'Inpatientlookup_Form\' action=\'../../eIP/jsp/BookingReferenceLookupResult.jsp\' target=\'result\' >\n\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t\t\t\t<script>getLabel(\"Common.nursingUnit.label\",\"common\")</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td CLASS=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<input type=text id=\"nursing_unit_desc\" name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" size=15 maxlength=\'15\' onblur=\"BeforeGetNursingUnit(this, \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'to\');\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t\t\t\t<input type=hidden id=\"nursing_unit\" name=\"nursing_unit\" id=\"nursing_unit\" size=15 > \n\t\t\t\t\t\t<input type=button class=button name=\'nursing_unit_lookup\' id=\'nursing_unit_lookup\' value=\'?\' onClick=\"getNursingUnitValue(nursing_unit_desc,nursing_unit, \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'to\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\'  nowrap width=\"25%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   class=\'fields\' width=\'25%\'  nowrap>\n\t\t\t\t\t\t<input type=\'text\' id=\"admn_date_from\" maxlength=\'10\' size=\'10\' name=\'from_date\' id=\'from_date\' \n\t\t\t\t\t\tonBlur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\");compareDates();\'>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.getElementById(\'admn_date_from\').focus();return showCalendar(\'admn_date_from\');\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t - ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;\n\t\t\t\t\t\t \t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'text\' id=\"admn_date_to\"  maxlength=\'10\' size=\'10\' name=\'to_date\' id=\'to_date\' onBlur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\");compareDates();\'>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].admn_date_to.focus();return showCalendar(\'admn_date_to\');\" >\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<td  class=\'label\' width=\'25%\' nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap>\n\t\t\t\t\t\t<input type=text name=specialty_desc size=15 maxlength=\'15\' onblur=\"BeforeGetSpecialtyValue(this, \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n\t\t\t\t\t\t<input type=hidden class=label name=Splcode size=15 readonly>\n\t\t\t\t\t\t<input type=button class=button name=\'specialty_lookup\' id=\'specialty_lookup\' value=\'?\' onClick=\"getSpecialtyValue(specialty_desc, \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'to\');\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t<td  class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap>\n\t\t\t\t\t\t<input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' size=\"25\" maxlength=\"30\" onblur=\"BeforeGetPractitioner(document.getElementById(\'practid\'),document.getElementById(\'practid_desc\'),\'to\');\" value=\"\">\n\t\t\t\t\t\t<input type=\'hidden\' id=\"practid\" name=\'practid\' id=\'practid\' value=\"\" size=\"15\" maxlength=\"15\" > \n\t\t\t\t\t\t<input type=\'button\' id=\"pract_id_search\" name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerLocal(document.getElementById(\'practid\'), document.getElementById(\'practid_desc\'),\'to\');\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\n\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\t<td class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap>\n\t\t\t\t\t\t<input type=\'text\'  size=\'12\'  maxlength=\'12\' name=\'encounter_id\' id=\'encounter_id\' onKeyPress=\"return allowValidNumber(this,event,12,0)\" onBlur=\"validSplchars1(this);CheckNum(this)\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=4></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=4>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t</table>\t\n\t\n\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t<tr>\n\t\t\t<td width = \"75%\" class=\'white\' >&nbsp;</td>\n\t\t\t<td width = \"25%\" class=\'white\' align=\"right\">\n\t\t\t\t<input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' class=\'button\' onclick=\'submitPage()\'>\n\t\t\t\t<input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' class=\'button\' onclick=\'clearAll()\'>\n\t\t\t</td>\n\t\t</tr>\n\n\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\t\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n\t<input type=\'hidden\' name=\'routine_tfr_yn\' id=\'routine_tfr_yn\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t<input type=\'hidden\' name=\'targetURL\' id=\'targetURL\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n\t<input type=\'hidden\' name=\'wherecondn\' id=\'wherecondn\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n\t<input type=\'hidden\' name=\'bed_block_period_max\' id=\'bed_block_period_max\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t<input type=\'hidden\' name=\'bedBlock_normal\' id=\'bedBlock_normal\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t<input type=\'hidden\' name=\'max_blk_type\' id=\'max_blk_type\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n\t<input type=\'hidden\' name=\'systemdate\' id=\'systemdate\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n\t<input type=\'hidden\' name=\'chk_in_lodger_min_date\' id=\'chk_in_lodger_min_date\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\'hidden\' name=\'chg_nurs_unit_in_assign_bed_yn\' id=\'chg_nurs_unit_in_assign_bed_yn\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t<input type=\'hidden\' name=\'patient_id_length\' id=\'patient_id_length\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n</form>\n</body>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n</html>\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );
public static String checkForNull(String inputString) {
		return ((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return ((inputString == null) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

 	String sStyle = checkForNull(
 			(String) session.getAttribute("PREFERRED_STYLE"),
 			"IeStyle.css");
 
            _bw.write(_wl_block6Bytes, _wl_block6);

	//data from request parameter
	String nuCode = CommonBean.checkForNull(request
			.getParameter(AssignBedConstants.NURSING_UNIT_REQ_PARAM));
	String nuDesc = CommonBean
			.checkForNull(request
					.getParameter(AssignBedConstants.NURSING_UNIT_DESC_REQ_PARAM));
	String specialtyCode = CommonBean.checkForNull(request
			.getParameter(AssignBedConstants.SPECIALTY_CODE_REQ_PARAM));
	String specialtyDesc = CommonBean.checkForNull(request
			.getParameter(AssignBedConstants.SPECIALTY_DESC_REQ_PARAM));
	String showNuPopup = CommonBean.checkForNull(request
			.getParameter(AssignBedConstants.SHOW_NU_POPUP_REQ_PARAM),
			AssignBedConstants.SHOW_NU_POPUP_DEFAULT_VALUE);
	String showSpecialtyPopup = CommonBean
			.checkForNull(
					request.getParameter(AssignBedConstants.SHOW_SPECIALTY_POPUP_REQ_PARAM),
					AssignBedConstants.SHOW_SPECIALTY_POPUP_DEFAULT_VALUE);

	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rset = null;
	try {
		con = ConnectionManager.getConnection(request);
		// added for assign bed on 3/8/2005 by Sridhar R 
		String chg_nurs_unit_in_assign_bed_yn = checkForNull(
				request.getParameter("chg_nurs_unit_in_assign_bed_yn"),
				"N");
		// need to get nursing unit code, nursing unit desc, specialty code, specialty desc
		// also get status for showing nursing unit popup and specialty popup 

		String chk_in_lodger_max_period = checkForNull(
				request.getParameter("chk_in_lodger_max_period"), "0");
		String bed_block_period_max = checkForNull(request
				.getParameter("bed_block_period_max"));
		String bl_install_yn = checkForNull(request
				.getParameter("bl_install_yn"));
		String bedBlock_normal = checkForNull(request
				.getParameter("bedBlock_normal"));
		String max_blk_type = checkForNull(request
				.getParameter("max_blk_type"));
		String oper_stn_id = checkForNull(request
				.getParameter("oper_stn_id"));
		String routine_tfr_yn = "";
		String jsp_name = checkForNull(request.getParameter("jsp_name"));
		String win_height = checkForNull(request
				.getParameter("win_height"));
		String win_width = checkForNull(request
				.getParameter("win_width"));
		String call_function = checkForNull(request
				.getParameter("call_function"));
		String modal = checkForNull(request.getParameter("modal"));
		String dialogTop = checkForNull(request
				.getParameter("dialogTop"));
		String module = checkForNull(request.getParameter("module"));
		String model_window = checkForNull(request
				.getParameter("model_window"));
		String function_id = checkForNull(request
				.getParameter("function_id"));
		String function_name = checkForNull(request
				.getParameter("function_name"));
		String prog_id = checkForNull(request.getParameter("prog_id"));
		String wherecondn = checkForNull(request
				.getParameter("wherecondn"));
		//String operstn								= checkForNull(request.getParameter("oper_stn_id"));
		String targetURL = checkForNull(request
				.getParameter("targetURL"));
		String facilityID = (String) session.getValue("facility_id");
		String loginUser = (String) session.getValue("login_user");
		String practitioner_id = checkForNull(request
				.getParameter("practitioner_id"));
		String encounterID_repDischargeAdvice = checkForNull(request
				.getParameter("encounter_id"));
		StringBuffer sbSql = new StringBuffer();
		String systemdate = "";
		String chk_in_lodger_min_date = "";
		String systemdate_converted = "";
		String patient_id_length = "";
		String dis_adv_chk = "";
		String dis_adv_val = "N";
		String display_discharge_pat_list = "";
		if (call_function.equals("DischargePatient")) {
			display_discharge_pat_list = checkForNull(
					request.getParameter("display_discharge_pat_list"),
					"A");

			if (display_discharge_pat_list.equals("D")) {
				dis_adv_chk = "checked";
				dis_adv_val = "Y";
			} else {
				dis_adv_chk = "";
				dis_adv_val = "N";
			}

		}
		try {
			if (oper_stn_id.equals("")
					|| call_function.equals("TransferPatientOut")) {
				sbSql.append(" select a.oper_stn_id oper_stn_id,a.routine_tfr_yn, to_char(sysdate,'dd/mm/rrrr') systemdate,(select patient_id_length  from mp_param where  module_id = 'MP' )patient_id_length from am_oper_stn a, am_user_for_oper_stn b 	   ");
				sbSql.append(" where a.facility_id='" + facilityID
						+ "' and a.facility_id=b.facility_id	   ");
				sbSql.append(" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"
						+ loginUser + "'   ");
				sbSql.append(" and trunc(sysdate) between b.eff_date_from and ");
				sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
				stmt = con.createStatement();
				rs = stmt.executeQuery(sbSql.toString());

				if (rs != null) {
					while (rs.next()) {
						systemdate = checkForNull(rs
								.getString("systemdate"));
						if (!(systemdate == null || systemdate
								.equals("")))
							systemdate_converted = DateUtils
									.convertDate(systemdate, "DMY",
											"en", locale);
						oper_stn_id = checkForNull(rs
								.getString("oper_stn_id"));
						routine_tfr_yn = checkForNull(rs
								.getString("routine_tfr_yn"));
						patient_id_length = checkForNull(rs
								.getString("patient_id_length"));
					}
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
				}
			} else {
				sbSql.append(" select patient_id_length,to_char(sysdate,'dd/mm/rrrr'), to_char(trunc(sysdate)-round(");
				sbSql.append(chk_in_lodger_max_period);
				sbSql.append("/24),'dd/mm/yyyy') from mp_param where  module_id = 'MP' ");
				stmt = con.createStatement();
				rs = stmt.executeQuery(sbSql.toString());

				if (rs != null && rs.next()) {
					patient_id_length = checkForNull(rs.getString(1));
					systemdate = checkForNull(rs.getString(2));
					if (!(systemdate == null || systemdate.equals("")))
						systemdate_converted = DateUtils.convertDate(
								systemdate, "DMY", "en", locale);
					chk_in_lodger_min_date = checkForNull(rs
							.getString(3));
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (sbSql.length() > 0)
			sbSql.delete(0, sbSql.length());

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

							String disabled = "";
							if ((nuCode != null && !nuCode.trim().equals(""))
									&& (AssignBedConstants.SHOW_NU_POPUP_DEFAULT_VALUE
											.equalsIgnoreCase(showNuPopup))) {
								disabled = "disabled";
							}
						
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(nuDesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block26Bytes, _wl_block26);

					disabled = "";
					if (specialtyCode != null && !specialtyCode.trim().equals("")) {
						if(AssignBedConstants.HIDE_SPECIALTY_POPUP_VALUE.
								equalsIgnoreCase(showSpecialtyPopup)){
							disabled = "disabled";
						}
					}else{
						specialtyDesc = "";
						if(AssignBedConstants.HIDE_SPECIALTY_POPUP_VALUE.
								equalsIgnoreCase(showSpecialtyPopup)){
							disabled = "disabled";
						}
					}
					
					
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(specialtyDesc ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            {java.lang.String __page ="IPPatientLookUpDetailCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id_length"), weblogic.utils.StringUtils.valueOf(patient_id_length
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.search.label", "common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.clear.label", "common_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(module));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(routine_tfr_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(targetURL));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bed_block_period_max));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bedBlock_normal));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(max_blk_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(systemdate));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(chk_in_lodger_min_date));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(chg_nurs_unit_in_assign_bed_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block65Bytes, _wl_block65);

	if (rset != null)
			rset.close();
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();

	} catch (Exception e) {

		e.printStackTrace();
	} finally {
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block66Bytes, _wl_block66);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmDateFrom.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
}
