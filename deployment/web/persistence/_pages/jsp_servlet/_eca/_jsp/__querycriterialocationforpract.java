package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __querycriterialocationforpract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QueryCriteriaLocationForPract.jsp", 1743150051016L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' /> \n\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t   <!--  <script src=\"../../eCA/js/LocationforPract.js\" language=\"javascript\"></script>  -->\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<script language=\"JavaScript\" src =\"../../eCA/js/LocationForPractitioner.js\"></script>\n\t\t<script language=\'javascript\'>\n\t\t\tfunction clearValFrame(){\n\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tparent.frames[0].document.forms[0].pract_id.value=\'\';\n\t\t\t\tparent.frames[0].document.forms[0].pract_name.value=\'\';\n\t\t\t}\n\t\t\tasync function searchPract(obj)\n\t\t\t{\n\t\t\tif(obj.value!=\"\")\n\t\t\t\t{\n\n\t\t\t\tvar search_text = obj.value;\n\t\t\t\ttarget = document.forms[0].pract_id;\t\n\t\t\t\tvar speciality = document.forms[0].speciality.value;\n\t\t\t\tvar prime_spl_code = document.forms[0].prime_spl_code.value;\n\t\t\t\t//var fields = new Array (document.forms[0].speciality);\t\n\t\t\t\t//var names = new Array ( \"Primary Speciality\");\n\t\t\t\t//var names = new Array (getLabel(\'Common.primaryspeciality.label\',\'Common\'));\n\t\t\t\t//if(checkFieldsofMst( fields, names, parent.parent.messageFrame) )\n\t\t\t\t//{\n\t\t\t\t\tvar p_facility_id=\"`\"+\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'+\"`\";\n\t\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\tvar dialogHeight= \"28\" ;\n\t\t\t\t\tvar dialogWidth\t= \"43\" ;\n\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\tvar sql=\"\";\n\t\t\t\t\tvar search_code=\"\";\n\t\t\t\t\tvar search_desc=\"\";\n\t\t\t\t\tvar tit=\"\";\n\t\t\t\t\tvar  fac_id=\'\'\n\t\t\t\t\ttit=getLabel(\"Common.practitioner.label\",\"common\");\n\t\t\t\t\tsql=\" select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id =\"+p_facility_id ;\t\t\n\t\t\t\t\tsearch_code=\"practitioner_id\";\n\t\t\t\t\tsearch_desc= \"practitioner_name\";\n\t\t\t\t\t\n\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\n\t\t\t\t\tretVal = await window.showModalDialog(\"LocationforPractSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit,\"UTF-8\")+\"&splty_code=\"+prime_spl_code+\"&search_text=\"+search_text,arguments,features);\n\t\t\t\t\tif (!(retVal == null)){\n\t\t\t\t\t\ttarget.value=retVal;\n\t\t\t\t\t\t//document.forms[0].pract_name.focus();\n\t\t\t\t\t\tPopulateName(target);\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].pract_name.value=\"\";\n\t\t\t\t\t\t//document.forms[0].pract_name.focus();\n\t\t\t\t\t}\t\n\t\t\t\t//}\t\n\t\t\t  }\n\t\t\t}\n\t\t\tfunction makeVisibleInvisible(obj){\n\t\t\t\t\n\t\t\t\tfor(i=0; i<document.qry_location.loc_pract.length; i++){\n\t\t\t\t\tif(document.qry_location.loc_pract[i].checked == true){\n\t\t\t\t\t\tif(obj.value==\"practioner\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\tif(document.qry_location.loc_pract[i].value == \'practioner\'){\n\t\t\t\t\t\t\t\tdocument.getElementById(\'prac\').innerHTML= \" <table width=\'100%\' cellpadding=\'3\' cellspacing=0 border=0 align =\'center\'><tr><td  width=\'48%\' class=\'label\'  >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;&nbsp;</td><td class=\'fields\' width=\'70.5%\'><input type=\'text\' name=\'pract_name\' size=30   onblur=\'getPractitioners(this)\';><input type=\'button\' style=\'height:22\' name=\'pract\' id=\'pract\' value=\'?\'  class=\'button\'  onclick=\'getPractitioners(this)\'><img src=\'../../eCommon/images/mandatory.gif\'></td></tr><tr><input type=\'hidden\' name=\'pract_id\' size=30 ></td></tr><tr><td><input type=hidden name=mode value=practioner><input type=hidden name=\'facility_id\'  id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></td></tr></table>\"\n\t\t\t\t\t\t\t\tdocument.getElementById(\'speciality_id\').style.display=\'inline\';\n\t\t\t\t\t\t\t\tdocument.getElementById(\'speciality_id\').style.visibility=\'visible\';   \n\t\t\t\t\t\t\t\tdocument.getElementById(\'speciality_id\').style.display=\'inline\';\n\t\t\t\t\t\t\t\tdocument.getElementById(\'location_id\').style.visibility=\'visible\';\n\t\t\t\t\t\t\t\tdocument.getElementById(\'breakdiv\').style.display=\'inline\';\n\t\t\t\t\t\t\t\tdocument.getElementById(\'breakdiv1\').style.display=\'none\';\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\tif(obj.value==\"location\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\t\t\t\tif(document.qry_location.loc_pract[i].value == \'location\'){\n\t\t\t\t\t\t\t\tdocument.getElementById(\'prac\').innerHTML= \"<table width=\'100%\' cellpadding=\'3\' cellspacing=0 border=0 align=center><tr ><td colspan=4>&nbsp;</td></tr><tr> <td  class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td><td class=\'fields\'><select name=\'locn_type\' onchange=\'PopulateLoc(this)\'><option value=\'\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---- ---- ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="---- ----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option><option value=\'Z\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option><option value=\'Y\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option><option value=\'X\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option><option value=\'C\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option><option value=\'W\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option><option value=\'P\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option></select><img src=\'../../eCommon/images/mandatory.gif\'></td><td  class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td><td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'locn_code\' value=\'\' size=\'30\' maxlength=\'40\' OnBlur =\'populateLocatn()\' OnChange=\'resetValues();setValue();clearFrame()\'><input type=\'button\' class=\'button\' name=\'buttonloctn\' value=\'?\' OnClick=\'resetValues();populateLocatn()\'><img src=\'../../eCommon/images/mandatory.gif\'></td></tr><tr><td>&nbsp;</td></tr><tr><td><input type=hidden name=mode value=location><input type=\'hidden\' name=\'flag\' value=\'true\'><input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'><input type=\'hidden\' name=\'locaSerch\' value=locaSerch></td></tr></table>\"\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.getElementById(\'speciality_id\').style.display=\'none\';\n\t\t\t\t\t\t\t\t//document.all.speciality_id.style.visibility=\'hidden\'; \n\t\t\t\t\t\t\t\tdocument.getElementById(\'location_id\').style.visibility=\'visible\';   \n\t\t\t\t\t\t\t\tdocument.getElementById(\'breakdiv\').style.visibility=\'visible\';\n\t\t\t\t\t\t\t\tdocument.getElementById(\'breakdiv\').style.display=\'none\'; //none\n\t\t\t\t\t\t\t\tdocument.getElementById(\'breakdiv1\').style.display=\'inline\';\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\tdocument.getElementById(\'submt\').innerHTML=\"<table width=\'100%\' cellpadding=\'3\' cellspacing=0 border=0  align=center><tr ><td colspan=4 WIDTH = \'100%\' ALIGN =\'RIGHT\'><input type=submit value=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" class=\'button\' onClick=\'searchFrame();\'>&nbsp;&nbsp;&nbsp;<input type=button value=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" class=\'button\' onClick=\'clearing();\'></td></tr></table>\"\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction clearFrame(){\n\t\t\t\n\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t}\n\t\t\tfunction searchFrame(){\n\t\t\t\n\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t\t\tif(document.forms[0].pract_name)\n\t\t\t{\n\t\t\t   if(document.qry_location.pract_name.value==null || document.qry_location.pract_name.value==\"\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t    document.forms[0].pract_name.value=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t\t  if(document.forms[0].pract_id)\n\t\t\t {\n\t\t\t\tif(document.qry_location.pract_name.value==null || document.qry_location.pract_name.value==\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tdocument.forms[0].pract_id.value=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t  }\n\t\t\tfunction clearing()\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tif(document.forms[0].speciality) document.forms[0].speciality.value=\"\";\n\t\t\t\tif(document.forms[0].pract_id)\t document.forms[0].pract_id.value=\"\";\n\t\t\t\tif(document.forms[0].pract_name)   document.forms[0].pract_name.value=\"\";\n\t\t\t\tif(document.forms[0].locn_type)   document.forms[0].locn_type.value=\"\";\n\t\t\t\tif(document.forms[0].locn_code)\n\t\t\t\t{\n\t\t\t\t\tdelete_values(document.forms[0].locn_code);\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].pract_name) document.forms[0].pract_name.value=\"\";\n\t\t\t}\n\t\t\tasync function searchCode(obj, target){\n\t\t\t\ttarget = document.forms[0].pract_id;\t\n\t\t\t\tvar speciality = document.forms[0].speciality.value;\n\t\t\t\tvar prime_spl_code = document.forms[0].prime_spl_code.value;\n\t\t\t\t//var fields = new Array (document.forms[0].speciality);\t\n\t\t\t//var names = new Array(getLabel(\'Common.primaryspeciality.label\',\'Common\'));\n\t\t\t\t//if(checkFieldsofMst( fields, names, parent.parent.messageFrame) )\n\t\t\t\t//{\n\t\t\t\t\tvar p_facility_id=\"`\"+\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'+\"`\";\n\t\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\tvar dialogHeight= \"32.25\" ;\n\t\t\t\t\tvar dialogWidth\t= \"43\" ;\n\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\tvar sql=\"\";\n\t\t\t\t\tvar search_code=\"\";\n\t\t\t\t\tvar search_desc=\"\";\n\t\t\t\t\tvar tit=\"\";\n\t\t\t\t\tvar  fac_id=\'\'\n\t\t\t\t\ttit=getLabel(\"Common.practitioner.label\",\"common\");\n\t\t\t\t\tsql=\" select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id =\"+p_facility_id ;\t\t\n\t\t\t\t\tsearch_code = \"practitioner_id\";\n\t\t\t\t\tsearch_desc = \"practitioner_name\";\n\t\t\t\t\t\n\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\t\t\t\n\t\t\t\t\tretVal =await  window.showModalDialog(\"LocationforPractSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit,\"UTF-8\")+\"&splty_code=\"+prime_spl_code,arguments,features);\n\t\t\t\t\tif (!(retVal == null)){\n\t\t\t\t\t\ttarget.value=retVal;\n\t\t\t\t\t\t//document.forms[0].pract_name.focus();\n\t\t\t\t\t\tPopulateName(target);\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].pract_name.focus();\n\t\t\t\t\t}\t\n\t\t\t\t//}\t\t\n\t\t\t}\n\t\t\tfunction PopulateName(obj){\n\t\t\t\tvar practitioner_id=obj.value;\n\t\t\t\tif(obj.value.length>0){\n\t\t\t\t\tparent.parent.frames[2].location.href=\"GetNameofLocationforPract.jsp?practitioner_id=\"+practitioner_id.toUpperCase();\n\t\t\t\t}else{\n\t\t\t\t\tdocument.forms[0].practitioner_id.value=\"\";\n\t\t\t\t\tdocument.getElementById(\'prac_name\').value=\"\";\n\t\t\t\t\tparent.frames[0].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n\t\t\t\t}\n\t\t\t}\n\n\t\t\t\n           function CheckForSpecialCharacter(ObjText)\n             {\n\t             var key = window.event.keyCode\n\t\t         if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))\n\t\t\t     return false\n\t\t         return true\n             }\n\n\n          function resetValues()\n           {\n              parent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n            }\n          function setValue()\n            {\n\t           document.forms[0].flag.value=\'false\';\n             }\n\t\t\t\n\n\t\t\t  \n\t\t\tfunction PopulateLoc(obj)\n\t\t     {\n\t\t\t\tvar mode=document.forms[0].mode.value;\n\t\t\t\tvar locn_type= obj.value;\n\t\t\t\tif( locn_type==\"X\" || locn_type==\"Y\" || locn_type==\"Z\"  || locn_type==\"P\" ) \n\t\t\t\t{\n\t\t\t\t\t//delete_values1(document.forms[0].locn_code);\n\t\t\t\t\tif(locn_type==\"X\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].locn_code.value =getLabel(\'eCA.AllClinics.label\',\'CA\');\n\t\t\t\t\t\tdocument.forms[0].locaSerch.value =\"*ALLC\";\n\t\t\t\t\t\tdocument.forms[0].buttonloctn.disabled=true;\n\t\t\t\t\t\tdocument.forms[0].locn_code.readOnly=true;\t\t\n\t\t\t\t\t}\n\t\t\t\t\tif(locn_type==\"Y\")\n\t\t\t\t\t{   \n\t\t\t\t\t\tdocument.forms[0].locn_code.value    =getLabel(\'eCA.AllNursingUnits.label\',\'CA\');\n\t\t\t\t\t\tdocument.forms[0].locaSerch.value =\"*ALLW\";\t\n\t\t\t\t\t\tdocument.forms[0].buttonloctn.disabled=true;\n\t\t\t\t\t\tdocument.forms[0].locn_code.readOnly=true;\n\t\t\t\t\t}\n\t\t\t\t\tif(locn_type==\"Z\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].locn_code.value =getLabel(\'Common.AllLocations.label\',\'COMMON\');\n\t\t\t\t\t\tdocument.forms[0].locaSerch.value =\"*ALLZ\";\n\t\t\t\t\t\tdocument.forms[0].buttonloctn.disabled=true;\n\t\t\t\t\t\tdocument.forms[0].locn_code.readOnly=true;\n\t\t\t\t\t}\n\t\t\t\tif(locn_type==\"P\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].locn_code.value =getLabel(\'eCA.ByPractitionerRights.label\',\'CA\');\n\t\t\t\t\t\tdocument.forms[0].locaSerch.value =\"*ALLP\";\n\t\t\t\t\t\tdocument.forms[0].locn_code.readOnly=true;\n\t\t\t\t\t\tdocument.forms[0].buttonloctn.disabled=true;\n\t\t\t\t\t}\t\n\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdelete_values(document.forms[0].locn_type);\n\t\t\t\t\tdocument.forms[0].locn_code.readOnly=false;\n\n\t\t\t\t\t//delete_values(document.forms[0].locn_code);\n\t\t\t\t}\n\n\n\t\t\t\t//var HTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</link></HEAD><BODY CLASS=\'MESSAGE\' onMouseDown=CodeArrest() onKeyDown=lockKey()><form name=\'form1\' method=\'post\' action=\'PopulateLocationResult.jsp?locn_type=\"+locn_type+\"\'></form></BODY></HTML>\";\n\t\t\t\t//parent.frames[2].document.write(HTMLVal);\n\t\t\t\t//parent.frames[2].document.forms[0].submit();\n\t\t\t }\n\t\tfunction delete_values(field)\n\t\t{\n\t\t\t\n\t\t\tdocument.forms[0].locn_code.value=\"\";\n\t\t\tdocument.forms[0].locaSerch.value=\"\";\n\t\t\tdocument.forms[0].buttonloctn.disabled=false;\n\t\t\t\n\t\t\t\n\t\t/*\tvar selected = field;\n\t\t\twhile ( selected.options.length > 0 )\n\t\t\t\t\t\tselected.remove(selected.options[0]);\n\t\t\tvar opt=parent.frames[2].document.createElement(\"Option\");\n\t\t\topt.text=\"        ---Select---       \"\n\t\t\topt.value=\"\";\n\t\t\tfield.add(opt); */\n\t\t}\n\t\tfunction delete_values1(field)\n\t\t{\n\t\t\n\t\n\t\tdocument.forms[0].locn_code.value=field.value;\t\n\t\tdocument.forms[0].locaSerch.value=document.forms[0].locn_type.value;\n\t\t\n\n\t\t/*\tvar selected = field;\n\t\t\twhile ( selected.options.length > 0 )\n\t\t\t\tselected.remove(selected.options[0]);*/\n\t\t}\n\n\n\t\tfunction checkMandatory(){\n\t\t\t\tif(document.qry_location.locn_type)\n\t\t\t\t{\n\t\t\t\t\t//alert(\"here1\")\n\t\t\t\t\tvar fields = new Array (document.qry_location.locn_type,document.qry_location.locn_code);\t\n\t\t\t\t\tvar names = new Array ( getLabel(\"Common.locationtype.label\",\"Common\"),getLabel(\"Common.locationcode.label\",\"Common\"));\n\t\t\t\t\tif(checkFieldsofMst( fields, names, parent.parent.messageFrame) )\n\t\t\t\t\t{\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t return false;\n\t\t\t\t\t}\n\t\t\t\t}\t\n\t\t\t\telse\n\t\t\t\tif(document.qry_location.pract_id)\n\t\t\t\t{\n\t\t\t\t\t//alert(\"here2\")\n\t\t\t\t\tvar fields = new Array (document.qry_location.pract_id);\t\n\t\t\t\t\tvar names = new Array (getLabel(\"Common.practitioner.label\",\"Common\"));\n\t\t\t\t\tif(checkFieldsofMst( fields, names, parent.parent.messageFrame) )\n\t\t\t\t\t{\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\n\n\t\t/*function PopulateLoc(obj) {\n\t\t\t\t\n\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tvar locn_type= obj.value;\n\t\t\t\tif( locn_type==\"X\" || locn_type==\"Y\" || locn_type==\"Z\"  || locn_type==\"P\" ) {\n\t\t\t\t\tdelete_values(document.forms[0].locn_code);\n\t\t\t\t}else{\n\t\t\t\t\tdelete_values(document.forms[0].locn_code);\n\t\t\t\t}\n\t\t\t\tvar HTMLVal = \"<HTML><HEAD></HEAD><BODY CLASS=\'MESSAGE\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'PopulateLocationResult.jsp?locn_type=\"+locn_type+\"\'></form></BODY></HTML>\";\n\t\t\t\tparent.parent.messageFrame.document.write(HTMLVal);\n\t\t\t\tparent.parent.messageFrame.document.forms[0].submit();\n\t\t\t}\n\t\t\tfunction delete_values(field){\n\t\t\t\tvar selected = field;\n\t\t\t\twhile ( selected.options.length > 0 )\n\t\t\t\t\t\tselected.remove(selected.options[0]);\n\t\t\t\tvar opt=parent.frames[1].document.createElement(\"Option\");\n\t\t\t\topt.text=\"-----------------------";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="--------------\";\n\t\t\t\topt.value=\"\";\n\t\t\t\tfield.add(opt);\n\t\t\t}\n\t\t\tfunction delete_values1(field){\n\t\t\t\tvar selected = field;\n\t\t\t\twhile ( selected.options.length > 0 )\n\t\t\t\t\t\tselected.remove(selected.options[0]);\n\t\t\t}*/\n\n\t\t</script>\n\t</head>\n\t<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n\t\t<form name=\'qry_location\' id=\'qry_location\' method=\'post\' action=\'QueryResultLocationforPractResult.jsp\' target=QueryResult onSubmit=\'return checkMandatory()\'>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\n\n\t\t<table width=\'100%\' cellpadding=\'3\' cellspacing=0 border=0 align=center id=tbl>\n\t\t\t<tr>\n\t\t\t\t<td align=\'left\' ><b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</b>\n\t\t\t\t\t\t<input type=radio name=loc_pract value=\'practioner\' onclick=\'makeVisibleInvisible(this)\' > ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" <input type=radio name=loc_pract value=\'location\' onclick=\'makeVisibleInvisible(this)\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t</table>\n\n\t\t<table width=\'100%\' cellpadding=\'3\' cellspacing=0 border=0 align=\'center\' id=\'speciality_id\' >\n\t\t<div id=breakdiv>\n\t\t\t\n\t\t\t<br>\n\t\t</div>  \n\t \t<tr>\n\t\t\t<td  colspan=4>&nbsp;</td>\n\t\t</tr> \n\t\t<tr>\n\t\t\t<td width=\'74%\' class=label align=\"left\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t<td class=\'fields\' width=\'36%\' align=\"center\">&nbsp;&nbsp;<input type=\"hidden\" name=\"prime_spl_code\" id=\"prime_spl_code\" size=\"20\" maxlength=\"20\" value=\"\"><input type=\"text\" name=\"speciality\" id=\"speciality\" size=\'30\' maxlength=\'20\' onBlur=\'getPrimarySpacilityCode(this)\' OnChange=\'resetValues();setValue();clearValFrame()\'><input type=\"button\" value=\"?\" class=\"button\" name=\'primeSearch\' id=\'primeSearch\' onClick=\'resetValues();getPrimarySpacilityCode(this)\'></td>\n\t\t</tr>\n\n\n\t\t\t<!-- <td class=\'fields\' width=\'25%\'>&nbsp;&nbsp;\n\t\t\t\t<select name=\'speciality\' id=\'speciality\' onchange=\'clearValFrame()\'>\n\t\t\t\t\t<option value=\'\'>------------------";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="---------------</option> \n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t</option>\n\t\t\t\t</select>\n\t\t\t</td> </tr>--> \t\n\t\t\t\n\t\t\n\t\t ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t</table> \n\t<!-- <td width =\'25%\'> -->\t<table  cellpadding=0 cellspacing=0 border=0  id=\'location_id\'>\n\t\t\t<div id=breakdiv1>\n\t\t\t\n\t\t\t\t<br>\n\t\t\t</div>\n\t\t\t<tr width=\'100%\'>\n\t\t\t\t<td id=\'prac\'  width=\'100%\' ></td> <td>&nbsp;</td><!-- colspan=\'2\' -->\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td id=\'submt\' ></td><!-- colspan=\'2\' -->\n\t\t\t</tr>\n\t\t</table> \n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t <img src=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' width=\'100%\' height=\'15\'/> \n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<script>\n\t\t   document.getElementById(\"speciality_id\").style.visibility=\'hidden\';\n\t\t   document.getElementById(\"location_id\").style.visibility=\'hidden\';\n\t\t</script>\n\t\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\'true\'>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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

request.setCharacterEncoding("UTF-8");
String facility_id=(String) session.getValue("facility_id");

            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
			// added by Sridhar Reddy @ 01-12-08 
			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }
		 //end

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

			Connection con  =  null;
		   try{
			  con=ConnectionManager.getConnection(request);
		
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

						PreparedStatement pstmt=null;
						ResultSet rs1=null;
						try
						{
						  String sqlSpec = "Select speciality_code, short_desc from am_speciality where eff_status ='E' order by 2";
						  pstmt = con.prepareStatement(sqlSpec);
						  rs1 = pstmt.executeQuery();
						  while(rs1!=null && rs1.next())
						  {
							out.println("<option value='"+rs1.getString(1)+"' >"+rs1.getString(2)+"</option>");
						   }
						}catch(Exception e)
						{
						   //out.println(e);//common-icn-0181
						   e.printStackTrace();//COMMON-ICN-0181
						}
						finally
						{
						   if(rs1!=null) rs1.close();	
						   if(pstmt!=null) pstmt.close();
						}
					
            _bw.write(_wl_block32Bytes, _wl_block32);
} 
		catch(Exception e)
		{
		  //out.println(e.toString());//COMMON-ICN-0181
		  e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
		  ConnectionManager.returnConnection(con,request);
		}
            _bw.write(_wl_block33Bytes, _wl_block33);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllLocations.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AllNursingUnits.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AllClinics.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Clinics.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NursingUnits.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ByPractitionerRights.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewBy.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primaryspeciality.label", java.lang.String .class,"key"));
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
}
