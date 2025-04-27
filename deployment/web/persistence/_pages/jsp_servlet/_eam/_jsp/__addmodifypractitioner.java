package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifypractitioner extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addModifyPractitioner.jsp", 1742376284345L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n <head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n        <Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n      \t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eAM/js/Practitioner.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eAM/js/ExternalPractitioner.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\t\t\n      \t<script>\n\t\tvar isShift = false;\n\n\tfunction tab_click2(id){\n\t\t\tselectTab(id);\n\t\t\tobjClick(id);\n\t}\n\n\tfunction setShift(){\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 16) isShift=true;\n\t}\n\n\tfunction shift_tab(){\n\t\t\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 9 && isShift == true){\n\t\tparent.frames[1].document.practitioner1_form.b_age.focus();\n\t\n\t\t}\n\t\t\n\t}\n\t\n    function shift_tab2(){\t\t\n\t\tvar keyCode=window.event.keyCode;\t\t\n\t\tif(keyCode == 9 && isShift == true){\n\t\tparent.frames[1].document.practitioner1_form.offtelno.focus();\n\t//alert(parent.frames[1].document.getElementById(\"rtno\").tabIndex);\n\t\t}\t\n\t}\n\n    function shift_tab3(){\t\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 9 && isShift == true){\n\t\t\tparent.frames[1].document.practitioner1_form.year1.focus();\n\t\t}        \n    }\n\n    function shift_tab4(){\t\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 9 && isShift == true){\n        parent.frames[1].document.practitioner1_form.marital_status1.focus();\n\t\t}\n\t\t\n\t}\t\n\t\t\t\n\t\t\tvar currentLink = new String();\n\t\t\tcurrentLink = \"identity_link\";\n\t\t\tfunction changeToextn(obj)\n\t\t\t{\n\t\t\t\tif(obj.checked==true)\n\t\t\t\t{\n\t\t\t\t\t parent.parent.frames[1].frames[1].location.href=\"../../eAM/jsp/addModifyPractitioner.jsp?fcall=call&function_id=EXT_PRACT\";\t\n\t\t\t\t}\n\t\t\t    else\n\t\t\t    {\n\t\t\t\t\tparent.parent.frames[1].frames[1].location.href=\"../../eAM/jsp/addModifyPractitioner.jsp?fcall=call&function_id=PRACTITIONER\";\n\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction enabledata(obj)\n\t\t\t{\n\t\t\tif(obj.name==\"degree1\" )\n\t\t\t{\t\t\n\t\t\tif(obj.value!=\"\")\n\t\t\t{\n\t\t\tparent.frames[1].document.practitioner1_form.year1.readOnly=false;\n\t\t\tparent.frames[1].document.practitioner1_form.univ1.readOnly=false;\n\t\t\t\n\t\t\t}\t\n\t\t\telse\n\t\t\t{\n\t\t\tparent.frames[1].document.practitioner1_form.year1.value=\"\";\n\t\t\tparent.frames[1].document.practitioner1_form.year1.readOnly=true;\n\t\t\tparent.frames[1].document.practitioner1_form.univ1.value=\"\";\n\t\t\tparent.frames[1].document.practitioner1_form.univ1.readOnly=true;\n           \t\n\t\t\t//obj.focus();\n\t\t\t}\n\t\t\t}\n\t\t\t\t\n\t\t\t\n\t\t\tif(obj.name==\"degree2\" )\n\t\t\t{\t\t\n\t\t\tif(obj.value!=\"\")\n\t\t\t{\n\t\t\tparent.frames[1].document.practitioner1_form.year2.readOnly=false;\n\t\t\tparent.frames[1].document.practitioner1_form.univ2.readOnly=false;\n\t\t\t\n\t\t\t}\t\n\t\t\telse\n\t\t\t{\n           \tparent.frames[1].document.practitioner1_form.year2.value=\"\";\n\t\t\t\tparent.frames[1].document.practitioner1_form.year2.readOnly=true;\n\t\t\tparent.frames[1].document.practitioner1_form.univ2.value=\"\";\n\t\t   \n\t\t\tparent.frames[1].document.practitioner1_form.univ2.readOnly=true;\n\t\t//\tobj.focus();\n\t\t\n\t\t\t}\n\t\t\t}\n\n\t\t\tif(obj.name==\"degree3\" )\n\t\t\t{\t\t\n\t\t\tif(obj.value!=\"\")\n\t\t\t{\n\t\t\tparent.frames[1].document.practitioner1_form.year3.readOnly=false;\n\t\t\tparent.frames[1].document.practitioner1_form.univ3.readOnly=false;\n\t\t\t\n\t\t\t}\t\n\t\t\telse\n\t\t\t{\n\t\t\tparent.frames[1].document.practitioner1_form.year3.value=\"\";\n\t\t\tparent.frames[1].document.practitioner1_form.year3.readOnly=true;\n\t\t\tparent.frames[1].document.practitioner1_form.univ3.value=\"\";\n\t\t    parent.frames[1].document.practitioner1_form.univ3.readOnly=true;\n\t\t\t//obj.focus();\n\t\t\n\t\t\t}\n\t\t\t}\n\n\n          if(obj.name==\"degree4\" )\n\t\t\t{\t\t\n\t\t\tif(obj.value!=\"\")\n\t\t\t{\n\t\t\tparent.frames[1].document.practitioner1_form.year4.readOnly=false;\n\t\t\tparent.frames[1].document.practitioner1_form.univ4.readOnly=false;\n\t\t\t\n\t\t\t}\t\n\t\t\telse\n\t\t\t{\n\t\t\tparent.frames[1].document.practitioner1_form.year4.value=\"\";\n\t\t\tparent.frames[1].document.practitioner1_form.year4.readOnly=true;\n\t\t\tparent.frames[1].document.practitioner1_form.univ4.value=\"\";\n\t\t\tparent.frames[1].document.practitioner1_form.univ4.readOnly=true;\n\t\t   \n\t\t//\tobj.focus();\n\t\t\n\t\t\t}\n\t\t\t}\n\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t}\n\t\t\tfunction chkyear1(year1)\n\t\t\t{\n\t\t\t\tvar curyear = new Date();\n\t\t\t\tvar curyear1 =  curyear.getFullYear();\n\t\t\t\t\tif(year1.value > curyear1)\n\t\t\t\t{\n\t\t\t\t//alert(\'APP-AM0024 Year of Passing cannot be greater than current Year\');\n\t\t\t\talert(getMessage(\"AM0164\",\"AM\"));\n\t\t\t\t\tyear1.value = \"\";\n\t\t\t\t\tyear1.focus();\n\t\t\t\t}\n\t\t\t}\n\n\t\tfunction chkyear2(year2)\n\t\t\t{\n\t\t\t\tvar curyear = new Date();\n\t\t\t\tvar curyear2 =  curyear.getFullYear();\n\t\t\t\t\tif(year2.value > curyear2)\n\t\t\t\t{\n\t\t\t\t//alert(\'APP-AM0024 Year of Passing cannot be greater than current Year\');\n\t\t\t\talert(getMessage(\"AM0164\",\"AM\"));\n\t\t\t\tyear2.value = \"\";\n\t\t\t\t\tyear2.focus();\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction chkyear3(year3)\n\t\t\t{\n\t\t\t\tvar curyear = new Date();\n\t\t\t\tvar curyear3 =  curyear.getFullYear();\n\t\t\t\t\tif(year3.value > curyear3)\n\t\t\t\t{\n\t\t\t\t//alert(\'APP-AM0024 Year of Passing cannot be greater than current Year\');\n\t\t\t\talert(getMessage(\"AM0164\",\"AM\"));\n\t\t\t\tyear3.value = \"\";\n\t\t\t\t\tyear3.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction detailsoftraining()\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'degree1\').focus();\n\t\t\t}\t\t\t\n\t\t\t\n\n\t\t\tfunction chkyear4(year4)\n\t\t\t{\n\t\t\t\tvar curyear = new Date();\n\t\t\t\tvar curyear4 =  curyear.getYear();\n\t\t\t\t\tif(year4.value > curyear4)\n\t\t\t\t{\n\t\t\t\t//alert(\'APP-AM0024 Year of Passing cannot be greater than current Year\');\n\t\t\t\talert(getMessage(\"AM0164\",\"AM\"));\n\t\t\t\tyear4.value = \"\";\n\t\t\t\t\tyear4.focus();\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction chkY(b_age)\n\t\t\t{\n\t\t\t\t\n\t\t\t\tif(b_age.value > 150)\n\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"INVALID_AGE_YEAR\",\"AM\"));\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction objClick(objName)\n\t\t\t{\n\t\t\t\t//changeLink(objName);\n\t\t\t\tif (objName == \'demogrp_tab\')\n\t\t\t\t\tparent.practitioner_sub.moveToLink(1);\n\t\t\t\telse if(objName == \'others_tab\')\n\t\t\t\t{\n\t\t\t\t\tparent.practitioner_sub.moveToLink(2);\n\t\t\t\t}\n\t\t\t\telse if(objName == \'findtl_tab\')\n\t\t\t\t{\n\t\t\t\t\tparent.practitioner_sub.moveToLink(3);\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tasync function searchCountryCode(obj,target,callVal)\n\t\t\t{\n\t\t\t\tvar retVal =    new String();\n\t\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\tvar tit=getLabel(\"eMP.CountryCode.label\",\"mp\");\n\n\t\t\t\tsql = \"select country_code code, short_name description from mp_country where eff_status = \'E\' and upper(country_code) like upper(?) and upper(short_name) like upper(?) order by 2\";\n\t\t\t\t\t\n\t\t\t\targumentArray[0] = sql;\n\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\targumentArray[5] = target.value;\n\t\t\t\targumentArray[6] = DESC_LINK  ;\n\t\t\t\targumentArray[7] = DESC_CODE ;\n\t\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\t\t\tif(retVal != null && retVal != \"\" )\n\t\t\t\t{\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\ttarget.value=arr[1];\n\t\t\t\t\tif(callVal == \'residence\')\n\t\t\t\t\t{\n\t\t\t\t\t\tpractitioner1_form.res_add_country_code.value= arr[0];\n\t\t\t\t\t}\n\t\t\t\t\telse if(callVal == \'office\')\n\t\t\t\t\t{\n\t\t\t\t\t\tpractitioner1_form.off_add_country_code.value= arr[0];\n\t\t\t\t\t}\n\t\t\t\t\telse if(callVal == \'mail\')\n\t\t\t\t\t{\n\t\t\t\t\t\tpractitioner1_form.mail_add_country_code.value= arr[0];\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\ttarget.value = \'\';\n\t\t\t\t\tif(callVal == \'residence\')\n\t\t\t\t\t{\n\t\t\t\t\t\tpractitioner1_form.res_add_country_code.value= \"\";\n\t\t\t\t\t}\n\t\t\t\t\telse if(callVal == \'office\')\n\t\t\t\t\t{\n\t\t\t\t\t\tpractitioner1_form.off_add_country_code.value= \"\";\n\t\t\t\t\t}\n\t\t\t\t\telse if(callVal == \'mail\')\n\t\t\t\t\t{\n\t\t\t\t\t\tpractitioner1_form.mail_add_country_code.value= \"\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(callVal == \'residence\')\n\t\t\t\t{\n\t\t\t\t\tif(document.practitioner1_form.practid.value != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tcheck9()\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(callVal == \'office\')\n\t\t\t\t{\n\t\t\t\t\tif(document.practitioner1_form.practid.value != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tcheck11();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(callVal == \'mail\')\n\t\t\t\t{\n\t\t\t\t\tif(document.practitioner1_form.practid.value != \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tcheck13();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t\tfunction changeLink(LinkName) \n\t\t\t{\n\t\t\t\tif (currentLink==\'identity_link\')\n\t\t\t\t\tdocument.getElementById(\'identity_link\').src=\'../../eAM/images/Identity_click.gif\';\n\t\t\t\telse if (currentLink==\'contactno_link\')\n\t\t\t\t\tdocument.getElementById(\'contactno_link\').src = \'../../eAM/images/Contact_Addr_click.gif\';\n\t\t\t\telse if (currentLink==\'deg_link\')\n\t\t\t\t\tdocument.getElementById(\'deg_link\').src = \'../../eAM/images/Qualification_and_Training_click.gif\';\n\n\t\t\t\tif(LinkName==\'identity_link\')\n\t\t\t\t\tdocument.getElementById(\'identity_link\').src=\'../../eAM/images/Identity.gif\';\n\t\t\t\telse if(LinkName==\'contactno_link\')\n\t\t\t\t\tdocument.getElementById(\'contactno_link\').src=\'../../eAM/images/Contact_Addr.gif\';\n\t\t\t\telse if(LinkName==\'deg_link\')\n\t\t\t\t\tdocument.getElementById(\'deg_link\').src=\'../../eAM/images/Qualification_and_Training.gif\';\n\t\t\t\tcurrentLink = LinkName;\n\t\t\t}\n   \t\t\tfunction echeck1(Obj)\n   \t\t\t{\n     \t\t\tif(Obj.value == \"T\") \n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\'popempid\').innerHTML=\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID &nbsp;<input id=\'employee_id\'  type=\'text\' value=\'\' onBlur=\'makeValidString(this)\'  name=\'employee_id\' maxlength=\'30\' size =\'30\'>\";\t\n\t\t\t\t}\n     \t\t\telse \t\n     \t\t\t \tdocument.getElementById(\'popempid\').innerHTML=\"\";\t\n     \t\t}\t\n     \t\tfunction change(totApptCount) \n\t\t\t{\n\t\t\t\tif(totApptCount >0)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'FUTURE_APPT_EXISTS\',\'AM\'));\n\t\t\t\t\tpractitioner_form.eff_status.value=\"E\";\n\t\t\t\t\tpractitioner_form.eff_status.checked=true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif (practitioner_form.eff_status.checked == true)\n\t\t\t\t\t{\n\t\t\t\t\t\tpractitioner_form.eff_status.value=\"E\";\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tpractitioner_form.eff_status.value=\"D\";\n\t\t\t\t\t}\n\t\t\t\t}\n       \t\t}\n\t      \tfunction check() \n\t\t\t{ \n\t\t\t\t\t\t\t\t\n\t\t\t\tif(document.practitioner1_form.function_id)\n\t\t\t\t{\n\t\t\t\tif(document.practitioner1_form.function_id.value==\"PRACTITIONER\")\n\t\t\t\t{\n\t      \t\tif(practitioner1_form.all_facilities.checked == true) \n\t\t\t\t{\n\t\t\t\t\tpractitioner1_form.all_facilities.value=\"Y\";\n\t\t\t\t\tpractitioner1_form.all_facilities1.value=\"Y\"; // added by mujafar for MOHE-SCF-0002\n     \t\t\t\t\n\t\t\t\t\tif(document.getElementById(\'rep_facility\')!=null)\t{\n\t\t\t\t\t\tdocument.getElementById(\'rep_facility\').value=\"\";\n\t\t\t\t\t\tdocument.getElementById(\'rep_facility\').disabled=true;\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\n\t\t\t   }\n\t      \telse \n\t\t\t{\n\t\t\t\tpractitioner1_form.all_facilities.value=\"N\";";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="\n\t\t\t\tpractitioner1_form.all_facilities1.value=\"N\"; // added by mujafar for MOHE-SCF-0002\n\t\t\t\tif(document.getElementById(\'rep_facility\')!=null)\n\t\t\t\t\tdocument.getElementById(\'rep_facility\').disabled=false;\n\t\t\t}\n\t\t\t\t}\n\t\t\t\t}\n      \t}\n\t\t\n\t\t\n\t\tfunction checkpract()\n\t\t{\n\t\t\t\n\t\t\tif(practitioner1_form.function_name.value == \"insert\") \n\t\t\t{\n\t\t\t\tparent.frames[1].document.practitioner1_form.pract_type1.value=parent.frames[1].document.practitioner_form.pract_type.value;\n\t\t\t\t\n\t\t\t}\n\t\t\telse if(practitioner1_form.function_name.value == \"modify\") \n\t\t\t{    \n\t\t\t \tcheck1();\n\t\t\t\tpractitioner1_form.pract_type1.value=practitioner_form.pract_type3.value;\n\t\t\t}\n\t\t}\n\t\tfunction check1() {\n\t\tif(practitioner_form.pract_type){\n\t\t\tpractitioner_form.pract_type3.value = practitioner_form.pract_type.value;}\n\t\t}\n\t\tfunction check2() {\n\t\t\tpractitioner1_form.sex2.value=practitioner1_form.sex.value;\n\t\t}\n\t\tfunction check3() {\n\t\t\tpractitioner1_form.empl_status2.value=practitioner1_form.empl_status.value;\n\t\t}\n\t\tfunction check4() {\n\t\t\tpractitioner1_form.pref_contact_mode2.value=practitioner1_form.pref_contact_mode.value;\n\t\t}\n\t\tfunction check5() {\n\t\t\tpractitioner1_form.marital_status2.value=practitioner1_form.marital_status.value;\n\t\t}\n\t\tfunction check6() {\n\t\t\tpractitioner1_form.citizen2.value=practitioner1_form.citizen.value;\n\t\t}\n\t\t\n\t\tfunction check8() {\n\t\t\tpractitioner1_form.res_add_postal_code2.value=practitioner1_form.res_add_postal_code.value;\n\t\t}\n\t\tfunction check9() {\n\t\t\tpractitioner1_form.res_add_country_code2.value= practitioner1_form.res_add_country_code.value;\n\t\t}\n\t\tfunction check10() {\n\t\t\tpractitioner1_form.off_add_postal_code2.value =practitioner1_form.off_add_postal_code.value;\n\t\t}\n\t\tfunction check11() {\n\t\t\tpractitioner1_form.off_add_country_code2.value =practitioner1_form.off_add_country_code.value;\n\t\t}\n\t\tfunction check12() {\n\t\t\tpractitioner1_form.mail_add_postal_code2.value =practitioner1_form.mail_add_postal_code.value;\n\t\t}\n\t\tfunction check13() {\n\t\t\tpractitioner1_form.mail_add_country_code2.value =practitioner1_form.mail_add_country_code.value;\n\t\t}\n\t\tfunction check14() {\n\t\t\tpractitioner_form.primary_speciality_code2.value =practitioner_form.primary_speciality_code.value;\n\t\t}\n\t\tfunction moveto() {\n\t\tparent.frames[1].document.practitioner1_form.sex.focus();\n\t}\nfunction allowValidNumber(fld, e, maxInt, deci)\n{\n\tvar count=fld.value.length;\n\tvar whichCode = (window.Event) ? e.which : e.keyCode;\n\tif(count>=maxInt)\n\t{\n\t\tif(count==maxInt)\n\t\t{\n\t\t    var dotOccurance = fld.value.indexOf(\'.\');\n\t\t\tif(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))\n\t\t\t{\n\t\t\t\tif(whichCode!=46)\n\t\t\t\t{\n\t\t\t\t\t//var errors = \"APP-0001 Reached Maximum Integer value\";\n\t\t\t\t\tvar errors = getMessage(\"AM0126\",\"AM\");\n\t\t\t\t\t//parent.parent.frames[2].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse if(count>maxInt)\n\t\t{\n\t\t\tvar objectValue = fld.value;\n\t\t    var dotOccurance = objectValue.indexOf(\'.\');\n\t\t\tif((objectValue.charAt(maxInt))!=\'.\')\n\t\t\t{\n\t\t\t\tif(dotOccurance==-1)\n\t\t\t\t{\n\t\t\t\t\tfld.value = objectValue.substring(0,maxInt)+\".\";\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tif (parseInt(deci)==1)//For Minus,Decimal Point and 0-9\n\t  var strCheck = \'.0123456789-\';\n\telse if (parseInt(deci)==2) //For Decimal Point and 0-9\n\t{\n\t   var strCheck = \'.0123456789\';\n\t}\n\telse if (parseInt(deci)==0)//For Only Nos 0 - 9\n\t{\n\t\tvar strCheck = \'0123456789\';\n\t}\n\telse if (parseInt(deci)==3)//For Minus and 0-9 Only\n\t{\n\t\tvar strCheck = \'0123456789-\';\n\t}\n\tif (parseInt(deci)==1)\n\t{\n\t\tvar fldvalue=fld.value;\n\t\tif (whichCode == 45 && (fldvalue.length==0)) return true;  // minus \n\t\tif (whichCode == 45 && (fldvalue.length>0)) return false;  // minus \n\t}\n\n\tvar fldvalue=fld.value;\n\tvar whichCode = (window.Event) ? e.which : e.keyCode;\n\tif (whichCode == 13) return true;  // Enter\n\tvar pointCount=0;\n\tfor(var i=0;i<fldvalue.length;i++)\n\t{\n\t\tif(fldvalue.charAt(i)==\'.\') pointCount++;\n\t}\n\tif (pointCount>0 && whichCode == 46) return false;\n\n\tvar fldValue\t=\tfld.value;\n\tvar dotIndex\t=\tfldValue.indexOf(\".\");\n\tvar fldLength\t=\tfldValue.length;\n\n\tif(dotIndex!=-1)\n\t\tif( fldLength > (dotIndex+3) ) return false;\n\n\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\treturn true;\n}\nfunction resMove()\n{\n\t//alert(\'Welcome to eHIS\');\n\t//alert(getMessage(\"WELCOME\",\"Common\"));\n\n}\nfunction changeFocus()\n{\n\tif (document.getElementById(\"pract_type\")){\n\t\tdocument.getElementById(\"pract_type\").focus();\n\t}\n}\n/*function changeFocus3()\n{\n\tif (document.getElementById(\'pract_type2\')){\n\t\tdocument.getElementById(\'pract_type2\').focus();\n\t}\n}*/\n\nfunction changeFocus1()\n{\n\t//objClick(\'identity_link\');\t\n\tif(parent.practitioner_main.document.getElementById(\'eff_status\').value==\'E\')\n\t\t{\n\tdocument.practitioner1_form.sex.focus();\n\t\t}\n\telse\n\t\tdocument.practitioner1_form.sex1.focus();\n}\nfunction changeFocus2()\n{\n\tparent.frames[1].document.practitioner1_form.sex1.focus();\n\n\t\n}\n\nfunction changeFocus10()\n{\t\n\tif (parent.practitioner_main.document.getElementById(\"pract_type\"))\n\t\tparent.practitioner_main.document.getElementById(\"pract_type\").focus();\n\telse{\n\t\tif (parent.practitioner_main.document.getElementById(\'pract_type2\'))\n\t\tparent.practitioner_main.document.getElementById(\'pract_type2\').focus();\n  }\n}\nfunction changeFocus1_app()\n{ \n      if(parent.practitioner_main.document.practitioner_form.changeext.checked==true)\n\t{\n\t document.practitioner1_form.sex.focus();\n\t}\n\n\t  if(parent.frames[1].document.practitioner1_form.function_id.value==\"EXT_PRACT\")\n\t  objClick(\'identity_link\');\t\n}\nfunction callfunFocus()\n{\n\t//objClick(\'contactno_link\');\t\n\tdocument.getElementById(\'residencetelno\').focus();\n}\n\nfunction changeFocus1_new(obj)\n{\n\tif(obj.checked==true)\n\t objClick(\'identity_link\');\n\t\n\t//document.getElementById(\'sex\').focus();\n\t\n}\nfunction chkyearlen(obj)\n{\n\tif(obj.length < 4)\n\t{\n\t\talert(getMessage(\"INVALID_YR_FORMAT\",\"Common\"));\n\t\tobj.focus();\n\t}\n}\nasync function searchCitizenship(obj,target)\n{\n\t//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011\n\tvar isResidencyApplYN = document.practitioner1_form.isResidencyApplYN.value;\n\tvar retVal =    new String();\n\tvar argumentArray  = new Array() ;\n\tvar dataNameArray  = new Array() ;\n\tvar dataValueArray = new Array() ;\n\tvar dataTypeArray  = new Array() ;\n\tvar tit=encodeURIComponent(getLabel(\"Common.Citizenship.label\",\"common\"));\n\n\tsql = \"select country_code code, long_desc description from mp_country where eff_status = \'E\' and upper(country_code) like upper(?) and upper(long_desc) like upper(?) and long_desc is not null order by 2\";\n\t\t\n\targumentArray[0] =sql;\n\targumentArray[1] = dataNameArray ;\n\targumentArray[2] = dataValueArray ;\n\targumentArray[3] = dataTypeArray ;\n\targumentArray[4] = \"1,2\";\n\targumentArray[5] = target.value;\n\targumentArray[6] = DESC_LINK  ;\n\targumentArray[7] = DESC_CODE ;\n\tretVal = await CommonLookup( tit, argumentArray );\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\ttarget.value=arr[1];\n\t\tdocument.practitioner1_form.citizen.value= arr[0];\n\t\t\n\t}\n\telse{\n\t\ttarget.value=\'\';\n\t\tdocument.practitioner1_form.citizen.value= \'\';\n\t\t}\n\tif(document.practitioner1_form.practid.value != \'\')\n\t{\n\t\tcheck6();\n\t}\n\t\n\t//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011\n\tif(isResidencyApplYN == \"true\")\n\t{\n\t\tcheckCitznOrNonCitzn();\n\t}\n}\n\n/*function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"\'\")!=-1 || txtVal.value.indexOf(\"\'\'\")!=-1 || txtVal.value.indexOf(\'\"\')!=-1){\n\t\t txtVal.value = txtVal.value.replace(\"\'\", \'\'); \n\t\t txtVal.value = txtVal.value.replace(\"\'\'\", \'\');\n\t\t txtVal.value = txtVal.value.replace(\'\"\', \'\');\n\t}\n }*/\n function RemoveSpecialChar(txtVal){\n\tif(txtVal.value.indexOf(\"\'\")!=-1 || txtVal.value.indexOf(\"\'\'\")!=-1 || txtVal.value.indexOf(\'\"\')!=-1){\n\t\t  txtVal.value = txtVal.value.replace(/\'/g, \'\');\n\t\t  txtVal.value = txtVal.value.replace(/\"\"/g, \'\');\n\t\t  txtVal.value = txtVal.value.replace(/\'\'/g, \'\');\n          txtVal.value = txtVal.value.replace(/\"/g, \'\');\t\t  \n\t}\n } \n\n</script>\n</head>\n";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\n<body onLoad=\"populateValue1();changeFocus10(); check();if(parent.frames[1].document.getElementById(\'identitylink\')){parent.frames[1].document.getElementById(\'identitylink\').scrollIntoView();}\" onSelect = \"resMove()\" OnMouseDown=\'CodeArrest()\' onkeydown=\"setShift();lockKey()\" onKeyPress=\'return ChkKey(event);\' > \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body onLoad=\"FocusFirstElement(); changeFocus(); check();if(parent.frames[1].document.getElementById(\'identitylink\')){parent.frames[1].document.getElementById(\'identitylink\').scrollIntoView();}\" onSelect = \"resMove()\" OnMouseDown=\'CodeArrest()\' onkeydown=\"setShift();lockKey()\" onKeyPress=\'return ChkKey(event);\'> \n\t\t\t\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\'practitioner_form\' id=\'practitioner_form\' >\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n\t<td class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;&nbsp;</td>\n\t<td class=\'fields\' width=\"28%\" colspan=\'2\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</td>\n\t<!--Below line added for ML-MMOH-CRF-0862 -->\n\t<!--<td class=\'label\' width=\"13%\">&nbsp;</td>-->\n\t<td class=\'label\' width=\"18%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</td>\n\t<td class=\'label\' width=\"14%\">&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<input type=\'text\' name=\'cerner_practitioner_id1\' id=\'cerner_practitioner_id1\' size=\'42\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onkeyup=\"javascript:RemoveSpecialChar(this)\"  tabindex=\'2\' />";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;</td>\n\t<td class=\'label\' width=\"15%\">&nbsp;</td>\n\t<!--End this CRF ML-MMOH-CRF-0862 -->\n</tr>\n<tr>\n\t<td   class=\'label\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t</td>\n\t<td class=\'fields\' colspan=\'2\'>\n\t\t<input type=\'text\' name=\'practitioner_id\' id=\'practitioner_id\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" onKeyPress=\"return CheckForSpecCharsValidation2(event)\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" onKeyPress=\"return CheckForSpecChars(event)\"  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" tabindex=\'2\' size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t</td>\n\t\n\t<!--<td class=\'label\'>&nbsp;</td>-->\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t<td class=\'label\'><input type=\'checkbox\'  ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" name=\'changeext\' tabindex=\'3\' onClick=\"changeToextn(this);\"></td>\n\t<td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td class=\'label\'  >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;&nbsp;\n\t</td>\n\t<td class=\'fields\' colspan=\'2\'>\n\t\t<input type=\'text\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" onKeyPress=\"return CheckForSpecCharsValidation1(event)\" onBlur=\'CheckSplCharsValidation(this); makeValidString(this);\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" name=\'practitioner_name\' size=\'30\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" tabindex=\'4\'><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\t</td>\n\t<!--<td class=\'label\'  >&nbsp;</td>-->\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;</td>\n\t<td class=\'label\' colspan=\"2\">&nbsp;<input type=\'text\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" name=\'short_name\' size=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' maxlength=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" tabindex=\'5\' ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>&nbsp;</td><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\n\t<!--<td class=\'label\'>&nbsp;</td>-->\n</tr>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n<tr>\n\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n<td class=\"label\"width=\"20%\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n<td ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" colspan=\'2\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" colspan=\'5\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" class=\'fields\'><textarea name=\'long_name\'  id=\'long_name\' rows=\'4\' cols=\'72\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" onKeyPress=\"return CheckForSpecCharsValidation1(event); checkMaxLimit(this,\"300\");\" onBlur=\'CheckSplCharsValidation(this); return maxLength(this,\"300\");\' onpaste=\'return maxLengthPaste(this,\"300\");\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="  onKeyPress=\'checkMaxLimit(this,\"300\");\' ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" tabindex=\'6\'>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</textarea><!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->\t\t\t\t\n</td>\n<!--Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start-->\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n<td class=\'label\'>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&nbsp;(";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =")\n</td>\n<td class=\'label\'>\n\t<input type=\'checkbox\' name=\'FPPPract\' id=\'FPPPract\' tabindex=\'7\' ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" checked ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n</td>\n<td class=\'label\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n<!--Added by Dharma 19th Aug 2020 against AAKH-CRF-0122.4 Start-->\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n<td class=\'label\' align=\"left\">\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</td>\n<td class=\'label\'>\n\t<input type=\'checkbox\' name=\'supervisorchk\' id=\'supervisorchk\' tabindex=\'7\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" disabled ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" value=\'Y\'>\n</td>\n<td class=\'label\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n<!--End-->\n<!--<td class=\'label\'  >&nbsp;</td>\n\t<td class=\'fields\' ></td>\n\t<td class=\'label\'  >&nbsp;</td>\n\t<td class=\'fields\' ></td>-->\n\t</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;</td>\n\t\t<td class=\'fields\' colspan=\'2\'>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t<!--<td  class=\'label\'>&nbsp;</td>-->\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t<td class=\'label\'><input type=\'checkbox\' name=\'eff_status\' id=\'eff_status\' tabindex=\'8\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" onClick=\"change(";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =");changeFocus() \" onBlur=\'changeFocus10();\'></td>\n\t<td class=\'label\'>&nbsp;</td>\n</tr>\n\n<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\n\t<tr id=\'pract_Physician_div\' style=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =">\n\t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td>\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t\t<td class=\'label\'><input type=\'checkbox\' name=\'enable_virtual_consultation\' id=\'enable_virtual_consultation\' id=\'enable_virtual_consultation\'  value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" onclick=\"changevalue()\" tabindex=\'8\'></td>\n\t\t<td class=\'label\'>&nbsp;</td>\n\t</tr>\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t<input type=\'hidden\' name=\'enable_virtual_consultation\' id=\'enable_virtual_consultation\' id=\'enable_virtual_consultation\' value=\"D\">\t\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 End -->\n\n<tr><td colspan=\'6\'>\n<ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px\" >\n\t\t\t<li class=\"tablistitem\" title=\"Demographic details\">\n\t\t\t\t<a onclick=\"tab_click2(\'demogrp_tab\')\" class=\"tabClicked\" id=\"demogrp_tab\" >\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"demogrp_tabspan\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\n\t\t\t<li class=\"tablistitem\" title=\"Other details\">\n\t\t\t\t<a onclick=\"tab_click2(\'others_tab\')\" class=\"tabA\" id=\"others_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"others_tabspan\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\n\t\t\t\t<li class=\"tablistitem\" title=\"Financial details\">\n\t\t\t\t<a onclick=\"tab_click2(\'findtl_tab\')\" class=\"tabA\" id=\"findtl_tab\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"findtl_tabspan\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\t\n\t\t</ul>\n</td></tr>\n</table>\n</form>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t<script>prevTabObj=\'demogrp_tab\';</script>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<form name=\'practitioner1_form\' id=\'practitioner1_form\'    action=\'../../servlet/eAM.PractitionerServlet\'  method=\'post\' enctype = \'multipart/form-data\' target=\'messageFrame\'> <!-- multiform added by mujafar for AAKH-CRF-0079.4 -->\n<a name=\'identitylink\' id=\'identitylink\'></a>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\'  name=\'sub_tab1\' id=\'sub_tab1\'>\n\n<tr>\n   <td width=\"100%\" class=\"Border\">\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&nbsp;&nbsp;\n\t</td>\n\t<td class=\'fields\' >\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\n\t<td class=\'label\'>&nbsp;</td>\n\t<td class=\'label\'>&nbsp;</td>\n\t<input type=\"hidden\" name=\"max_pa_age\" id=\"max_pa_age\" value=\"120\">\n\n</tr>\n<tr>\n\n\t<td  class=\'label\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="&nbsp;&nbsp;</td>\n\t<td class=\'fields\'>\n\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t<input type=\"text\" name=\"b_age\" id=\"b_age\" maxlength=\"3\" size=\"3\" value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' tabindex=\'9\' onKeyPress=\'return  allowValidNumber(this,event,3,0);\' onChange=\'calculateAge(this,2)\' disabled onblur=\'chkY(this)\'>&nbsp;Y&nbsp;\n\t\t<input type=\"text\" name=\"b_months\" id=\"b_months\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' size=\"2\" tabindex=\'10\' onKeyPress=\'return  allowValidNumber(this,event,2,0);\' onChange=\'calculateAge(this,2)\' disabled >&nbsp;M&nbsp;\n\t\t<input type=\"text\" name=\"b_days\" id=\"b_days\" maxlength=\"2\" size=\"2\" value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' tabindex=\'11\' onKeyPress=\'return  allowValidNumber(this,event,2,0);\' onChange=\'calculateAge(this,2)\'  disabled>&nbsp;D&nbsp;\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' tabindex=\'9\'  onKeyPress=\'return  allowValidNumber(this,event,3,0);\' onChange=\'calculateAge(this,2)\' onblur=\'chkY(this)\'>&nbsp;Y&nbsp;\n\t\t<input type=\"text\" name=\"b_months\" id=\"b_months\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' size=\"2\" onKeyPress=\'return  allowValidNumber(this,event,2,0);\' tabindex=\'10\' onBlur=\'calculateAge(this,2)\' >&nbsp;M&nbsp;\n\t\t<input type=\"text\" name=\"b_days\" id=\"b_days\" maxlength=\"2\" size=\"2\" tabindex=\'11\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'onKeyPress=\'return  allowValidNumber(this,event,2,0);\' onBlur=\'calculateAge(this,2)\'  >&nbsp;D&nbsp;\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t</td>\n\t<td  class=\'label\' width=\'22%\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="&nbsp;&nbsp;</td>\n\t<td  class=\'fields\' width=\'34%\' >\n\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\t\n\t<!-- <input type=\"text\" name=\"date_of_birth\" id=\"date_of_birth\" maxlength=\"10\" size=\"8\"  value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' onBlur=\'calcage(this,ServerDate)\'  ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" > -->\n\t<input type=\'hidden\' name=\'greg_date_of_birth\' id=\'greg_date_of_birth\' value=\"\">\n\t<input type=\'hidden\' name=\'greg_date_of_birth_mod\' id=\'greg_date_of_birth_mod\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t<input type=\"text\" name=\"date_of_birth\" id=\"date_of_birth\" maxlength=\"10\" size=\"8\" tabindex=\'12\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' onblur=\'calculateAge(this,1);\'  ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'date_of_birth\');\" ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t</td>\n</tr>\n<tr>\n\t<td  class=\'label\' width=\'12%\'>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&nbsp;&nbsp;\t</td>\n\t<td  class=\'fields\' width=\'30%\'>\n\t\t<input type=\'text\' name=\"birth_place\" id=\"birth_place\" onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' tabindex=\'13\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =" >\n\t</td>\n\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" &nbsp;&nbsp;</td>\n\t<td class=\'fields\' ><select name=\'marital_status\' id=\'marital_status\' tabindex=\'26\' id=\"idrep_facility\" onBlur=\'changeFocus1()\'><option value=\'\'>----------";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="---------</option>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t <option value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =">";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</option>\n\t \n\t ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\n\t</td>\t\n</tr>\n<tr>\n<td colspan=\'4\'>&nbsp</td>\n</tr>\n</table>\n</td>\n</tr>\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\'  name=\'sub_tab\' id=\'sub_tab\'>\n<th>&nbsp;</th>\n<tr>\n<td width=\"100%\" class=\"Border\">\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n\t<td class=\'label\' colspan=\'4\'>&nbsp;</td>\n<tr>\n\n<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n<tr>\n\t<td class=\"label\" colspan=\'2\'>&nbsp;</td>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\t<td>\n\t\t<table width=\'53%\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\"oaBorder\" nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t<input type=\'radio\' name=\'res_citizen\' id=\'res_citizen\' ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" \n\t\t\t\t\tonClick=\'validateCitizen(\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\",\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\");\'>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" \n\t\t\t\t\tonClick=\'validateNonCitizen(\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" disabled>";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\'15%\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n<!--End MOHE-CRF-0011-->\n\n<tr>\n\t<td class=\'label\' width=20% >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="&nbsp;&nbsp;</td>\n\t<td class=\'fields\' width=30% >\n\t\t<input type=\'text\' name=\"alias_name\" id=\"alias_name\" onBlur=\"makeValidString(this)\" tabindex=\'15\' maxlength=\'25\' size=\'25\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" >\n\t</td>\n\t<td  class=\'label\' width=\'23%\'>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="&nbsp;&nbsp;\n\t</td><td class=\'fields\'  width=\'32%\'>\n\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t<!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t\t<input type=\'text\' name=\'citizenshipDesc\' id=\'citizenshipDesc\' size=\'15\' tabindex=\'16\' value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" onblur=\'if(this.value != \"\") searchCitizenship(this,citizenshipDesc);";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="checkCitznOrNonCitzn();";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'><input type=\'button\' name=\'citizenshipButton\' id=\'citizenshipButton\' value=\'?\' tabindex=\'16\' class=\'button\' onclick=\'searchCitizenship(this,citizenshipDesc)\'><input type=\'hidden\' name=\'citizen\' id=\'citizen\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="&nbsp;\n\t\t<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="&nbsp;\n\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t</td>\n</tr>\n<tr>\n\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t<td  class=\'label\'>";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="&nbsp;&nbsp;\n\t</td>\n\t<td class=\'fields\' >\n\t\t<!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t\t<input type=\'text\' name=\"national_id_no\" id=\"national_id_no\" maxlength=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" onBlur=\"makeValidString(this);validateNationality(this,\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\',\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\');\" tabindex=\'17\' size=\'15\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="  \n\t\tonKeyPress=\"return ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="<img name=\'nat_mandatory\' style=\'visibility:";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' src=\'../../eCommon/images/mandatory.gif\'>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t<input type=\'hidden\' name=\'oldnationalid\' id=\'oldnationalid\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t</td> <!--Added HSA-CRF-160 -->\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 =" &nbsp;&nbsp;</td>\n\t<td class=\'fields\' nowrap><select name=\"other_alt_type\" id=\"other_alt_type\" onchange=\"enabledOtherAltId()\" ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="><option value=\'\'>----------";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t  <!--Modified by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t <option value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</option>\t \n\t ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</select><input type=\'text\' name=\"other_alt_no\" id=\"other_alt_no\" onBlur=\"makeValidString(this);";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="duplicateOthAltIdValidation(this,\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\');";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" maxlength=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\' size=\'20\' tabindex=\'18\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =">\n\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="<img name=\'oth_alt_mand\' style=\'visibility:";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\n\t</td>\n\t\t\t</tr><tr>\n\t\t\t<!-- Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3 -->\n\t\t\t\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" 1&nbsp;&nbsp;</td>\n\t<td class=\'fields\' ><input type=\'text\' name=\"credential_id1\" id=\"credential_id1\" onBlur=\"makeValidString(this)\" maxlength=\'20\' size=\'20\' tabindex=\'18\' value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"  ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =" >\n\t\t\n\t</td>\n\t\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =" 2&nbsp;&nbsp;</td>\n\t<td class=\'fields\' >\n\t\t<input type=\'text\' name=\"credential_id2\" id=\"credential_id2\" onBlur=\"makeValidString(this)\" maxlength=\'20\' size=\'20\' tabindex=\'19\'  value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =" >\n\t</td>\n\t\n\t\t\t<!-- End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential-->\n\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n<!--Below line Added HSA-CRF-160 -->\n<td class=\'label\'>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =" 1&nbsp;&nbsp; </td>\n\t<td class=\'fields\' ><input type=\'text\' name=\"credential_id1\" id=\"credential_id1\" onBlur=\"makeValidString(this)\" maxlength=\'20\' size=\'20\' value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" >\n\t   \n\t</td>\n\t<td  class=\'label\'>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</td>\n\t\t<td class=\'fields\' nowrap><select name=\"other_alt_type\" id=\"other_alt_type\" onchange=\"enabledOtherAltId()\" ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =">\n\t<option value=\'\'>----------";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\n\t\t</td>\n\t\t</tr>\n\t\t<!-- End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential-->\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" 2&nbsp;&nbsp;&nbsp;</td><td  class=\'fields\'><input type=\'text\' name=\"credential_id2\" id=\"credential_id2\" onBlur=\"makeValidString(this)\" maxlength=\'20\' size=\'20\' value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =" >&nbsp;</td>\n\t\t<td   class=\'label\'>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" 3&nbsp;&nbsp;</td>\n\t\t<td class=\'fields\' ><input type=\'text\' name=\"credential_id3\" id=\"credential_id3\" onBlur=\"makeValidString(this)\" maxlength=\'20\' size=\'20\' tabindex=\'20\'   value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =" ></td>\n\t\t\n\t\t\n\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n</tr>\n<tr>\n\t<td   class=\'label\'>";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="&nbsp;&nbsp;</td>\n\t<td class=\'fields\' >\n      <select name=\'job_title\' id=\'job_title\' tabindex=\'21\'>\n\t <option value=\'\'>----------";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="---------</option>\n   \t</td>\n\t<td   class=\'label\' >";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" 3";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="&nbsp;&nbsp;</td>\n\t<td class=\'fields\'>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="<input type=\'text\' name=\"credential_id3\" id=\"credential_id3\" onBlur=\"makeValidString(this)\" maxlength=\'20\' size=\'20\' tabindex=\'20\'   value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" >";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\t&nbsp;&nbsp;</td>\n</tr>\n<tr>\n\t<td  class=\'label\' >";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="&nbsp;&nbsp;</td>\n\t<td  class= \'fields\'>\n\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\t\t\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t</td>\n\t<td   class=\'label\'>";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<td class=\'fields\' > <input type=\'text\' name=\"degree\" id=\"degree\" onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' tabindex=\'22\'  value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" >\n\t\t</td>\n</tr>\n\n<TR><TD colspan =\'4\' id = \'popempid\' class=\'label\'></TD></TR>\t\n<tr>\n\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="&nbsp;&nbsp;</td>\n\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="<td class=\'fields\'><input type=\'checkbox\' onBlur=\'changeFocus1_new(this)\'  name=\'all_facilities\' id=\'all_facilities\' tabindex=\'25\' value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" onClick=\'check();changeFocus1();\' ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =" align=\'left\' ><input type=\'hidden\' name=\'all_facilities1\' id=\'all_facilities1\' value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"  align=\'left\'></td>\n\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="<td class=\'fields\' ><input type=\'checkbox\'   name=\'all_facilities\' id=\'all_facilities\' value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" disabled ";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 =" align=\'left\'><input type=\'hidden\' name=\'all_facilities1\' id=\'all_facilities1\' value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\"  ></td>\n\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="<td  class=\'fields\' ><input type=\'checkbox\' name=\'all_facilities\' id=\'all_facilities\'  value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\n\t<td   class=\'label\'>\n\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =" \n\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t</td>\n\t\t<td class=\'fields\' >\n\t\t";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t<input type=\'text\' name=\"apc_no\" id=\"apc_no\" onBlur=\"makeValidString(this);changeFocus1_app();\"  tabindex=\'24\' maxlength=\'20\' size=\'20\' value=\"\">\n\t\t\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t<input type=\'text\' name=\"apc_no\" id=\"apc_no\" onBlur=\"makeValidString(this);changeFocus1_app();changeFocus1();\" tabindex=\'24\' maxlength=\'20\' size=\'20\' value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 =" >\n\t\t\t ";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t</td>\n\t\n\t</tr>\n\t<tr><td colspan =\'2\'>&nbsp;</td>\t\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 =" &nbsp;&nbsp;</td>\n\t<td class=\'fields\' ><select name=\'rep_facility\' id=\'rep_facility\' tabindex=\'26\' id=\"idrep_facility\" onBlur=\'changeFocus1()\'><option value=\'\'>----------";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t</select><img name=\'mandatory\' style=\'visibility: hidden\' src=\'../../eCommon/images/mandatory.gif\'>\n</td>\n\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n</tr>\n<!-- added by mujafar for AAKH-CRF-0079.4 -->\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="&nbsp;</td>\n<td class=\'fields\' ><input type=\'file\' name=\'signimage\' id=\'signimage\'  id=\'signimage\'  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'>&nbsp;\n<input type=\'button\' name=\'preview\' id=\'preview\'  ";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="   value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\' \nonClick=\"showPractSign(\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\',\'Sign\')\" size=40 maxlength=40 ></td>\n<!-- added by Lakshmanan For MO-CRF-20183.2 US001 start -->\n";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n<td class=\'label\' >";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</td>\n<td class=\'fields\' ><input type=\'text\' name=\'employee_service_number\' id=\'employee_service_number\'  id=\'employee_service_number\'  value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'  maxlength=\'15\' size=\'20\' onkeypress=\'return CheckForAlphaCharsNatID(event); return CheckSplCharsValidation_EmpSrvNo(this);\'  ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =" /> <input type=\'hidden\' name=\'employee_service_number_1\' id=\'employee_service_number_1\'  id=\'employee_service_number_1\'  value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'/>\n";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="<!--Added for PMG2023-COMN-CRF-0043 by Kamatchi S-->\n <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n</td>\n<!-- added by Lakshmanan For MO-CRF-20183.2 US001 end -->\n</tr>\n<!--Added by manjunath for TH-KW-CRF-0.161.1   -->\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="&nbsp;</td>\n\t<td class=\'fields\' colspan=\'2\'><input type=\'file\' name=\'stampimage\' id=\'stampimage\'  id=\'stampimage\'  value=\'\'  size=40 maxlength=40  onkeypress=\'return onkeyPressEvent(event);\' onblur=\'ValidateFileType(this)\'>&nbsp;\n\t<input type=\'button\' name=\'preview\' id=\'preview\'  ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\' \n\tonClick=\"showPractSign(\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\',\'Stamp\')\" size=40 maxlength=40 ></td>\n\t<td>&nbsp;</td><td>&nbsp;</td>\n</tr>\n\n\n\n<!-- Added by N Munisekhar on 25-July-2013 against MMS-QH-CRF-0104 [IN:039242] -->\n";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n<tr>\n\t<td class=\'label\' width=20% >";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="&nbsp;&nbsp;</td>\n\t<td class=\'fields\' width=30% >\n\t<input type=\'text\' value=\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\' name=\'employee_id\' maxlength=\'30\' size =\'30\' disabled/>\n\t<input type=\'hidden\' name=\'employee_id\' id=\'employee_id\' value=\'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'>\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n<!--End of MMS-QH-CRF-0104 [IN:039242] -->\n\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\'>\n\n<tr>\n<td colspan=\'4\'>&nbsp;</td>\n</tr>\n</table>\n</td>\n</tr>\n</table>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br>\n<br><br><br>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br>\n<br><br><br>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br>\n<br><br><br>\n<a name=\'contactnolink\' id=\'contactnolink\'></a>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n  \t<td width=\"100%\" class=\"Border\">\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n\t<td  class=\'label\' width=\"14%\">";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="&nbsp;</td>\n\n\t<td class=\'fields\' width=\"29%\" onkeyDown=\'shift_tab2()\'>\n\t\t<input type=\'text\' onBlur=\"makeValidString(this)\" name=\"residencetelno\" id=\"residencetelno\" maxlength=\'18\' size=\'18\' tabindex=\'27\' value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 =" >\n\t\t\t</td>\n\n\t<td  class=\'label\' width=\"30%\" >";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="&nbsp;</td>\n\n\t<td class=\'fields\' width=\"25%\">\n\t<input type=\'text\' name=\"offtelno\" id=\"offtelno\" tabindex=\'28\' onBlur=\"makeValidString(this)\" maxlength=\'18\' size=\'18\' value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =" >\n\t</td>\n</tr>\n<tr>\n\n\t<td   class=\'label\'>";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="&nbsp;</td>\n\t<td class=\'fields\' width=\"6%\" >\n\t\t<input type=\'text\' name=\"offtelext\" id=\"offtelext\" tabindex=\'29\' onBlur=\"makeValidString(this)\" maxlength=\'6\' size=\'6\' value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 =" >\n\t</td>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="&nbsp;&nbsp;</td>\n\t<td class=\'fields\' width=\"6%\">\n\t\t<input type=\'text\' name=\"faxno\" id=\"faxno\" tabindex=\'30\'  onBlur=\"makeValidString(this)\" maxlength=\'18\' size=\'18\' value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 =" >\n\t</td>\n</tr>\n<tr>\n\n\t<td  class=\'label\' width=\"6%\" >";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="&nbsp;</td>\n\t<td class=\'fields\' width=\"6%\">\n\t\t\t<input type=\'text\' name=\"mobileno\" id=\"mobileno\" tabindex=\'31\' onBlur=\"makeValidString(this)\" maxlength=\'18\' size=\'18\' value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =" >\n\t</td>\n\t<td  class=\'label\' width=\"6%\">";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="</td>\n\t<td class=\'fields\' width=\"6%\">\n\t\t<input type=\'text\' name=\"pagerno\" id=\"pagerno\" tabindex=\'32\' onBlur=\"makeValidString(this)\" maxlength=\'18\' size=\'18\' value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 =" >\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="&nbsp;&nbsp;</td>\n\t<td class=\'fields\' ><input type=\'text\' name=\'emailid\' id=\'emailid\' tabindex=\'33\'  onBlur=\"makeValidString(this)\" maxlength=\'50\' size=\'18\' value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 =" ></td>\n\t<td  class=\'label\' width=\"6%\">";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="&nbsp;</td>\n\t<td class=\'fields\' >\n\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\n\t</td>\n</tr>\n</table>\n</td>\n</tr>\n</table>\n<br>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n <td width=\"100%\" class=\"Border\">\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n<td colspan=\'4\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\'3%\'>&nbsp;</td>\n\t<td   width=\'3%\' class=\'label\'><b>";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>\n\t<td   width=\'3%\' class=\'label\'><b>";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>\n\t<td   width=\'3%\' class=\'label\'><b>";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>\n<tr>\n\t<td  width=\'3%\' class=\'label\'>";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="&nbsp;&nbsp;</td>\n\t<td class=\'fields\' width=\'7%\' >\n\t\t<input type=\'text\' name=\'res_add_ln1\' id=\'res_add_ln1\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'20\' tabindex=\'35\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 =" ></td>\n\t<td class=\'fields\' width=\'7%\' >\n\t\t<input type=\'text\' name=\'off_add_ln1\' id=\'off_add_ln1\' onBlur=\"makeValidString(this)\" maxlength=\'30\' tabindex=\'35\' size=\'20\' value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 =" ></td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'mail_add_ln1\' id=\'mail_add_ln1\' onBlur=\"makeValidString(this)\" maxlength=\'30\' tabindex=\'35\' size=\'20\' value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 =" ></td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\'3%\'> </td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'res_add_ln2\' id=\'res_add_ln2\' maxlength=\'30\' tabindex=\'35\' size=\'20\' value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\" onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 =" ></td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'off_add_ln2\' id=\'off_add_ln2\' maxlength=\'30\' size=\'20\' tabindex=\'35\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\"  onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 =" ></td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'mail_add_ln2\' id=\'mail_add_ln2\' maxlength=\'30\' size=\'20\' tabindex=\'35\' value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" onBlur=\"makeValidString(this)\"  ";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 =" ></td>\n</tr>\n<tr>\n\t<td width=\'3%\'> </td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'res_add_ln3\' id=\'res_add_ln3\' maxlength=\'30\' size=\'20\' tabindex=\'35\' value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 =" ></td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'off_add_ln3\' id=\'off_add_ln3\' maxlength=\'30\' size=\'20\' tabindex=\'35\' value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 =" ></td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'mail_add_ln3\' id=\'mail_add_ln3\' maxlength=\'30\' size=\'20\'  tabindex=\'35\'value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 =" ></td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\'3%\'> </td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'res_add_ln4\' id=\'res_add_ln4\' maxlength=\'30\' size=\'20\' tabindex=\'35\' value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 =" ></td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'off_add_ln4\' id=\'off_add_ln4\' maxlength=\'30\' size=\'20\' tabindex=\'35\' value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 =" ></td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\t<input type=\'text\' name=\'mail_add_ln4\' id=\'mail_add_ln4\' maxlength=\'30\' size=\'20\' tabindex=\'35\' value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 =" ></td>\n</tr>\n<tr>\n\t<td  width=\'3%\' class=\'label\'>";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="&nbsp;</td>\n\t";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n<td class=\'fields\' width=\'6%\' >\n";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n<input type=\'text\' name=\'res_add_postal_code\' id=\'res_add_postal_code\' size=\'15\'  tabindex=\'36\' onBlur=\"makeValidString(this);if(this.value != \'\'){\tsearchCode(this,res_add_postal_code);}else{}\" maxlength=\'15\' ><input type=\'button\' name=\'postal_code\' id=\'postal_code\' tabindex=\'36\' value=\'?\' class=\'button\' onclick=\'searchCode(this,res_add_postal_code)\'>\n";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\n\t\t\t\t<input type=\'text\' name=\'res_add_postal_code2\' id=\'res_add_postal_code2\' tabindex=\'36\' size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" onBlur=\"makeValidString(this);if(this.value != \'\'){searchCode(this,res_add_postal_code2);}else { }\" ><input type=\'button\' name=\'postal_code\' id=\'postal_code\' tabindex=\'36\' value=\'?\' class=\'button\' onclick=\'searchCode(this,res_add_postal_code2)\'>\n\t\t";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n\t\t\t\t<input type=\'text\' name=\'res_add_postal_code2\' id=\'res_add_postal_code2\' tabindex=\'36\' onBlur=\"makeValidString(this);if(this.value != \'\'){searchCode(this,res_add_postal_code2);}else{ }\" size=\'15\' maxlength=\'15\'><input type=\'button\'  name=\'postal_code\' id=\'postal_code\' tabindex=\'36\' value=\'?\' class=\'button\' onclick=\'searchCode(this,res_add_postal_code2)\'>\n\t\t";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="</td>\n\t<td class=\'fields\' width=\'6%\' >\n\t";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n\t\t\t<input type=\'text\' name=\'off_add_postal_code\' id=\'off_add_postal_code\' tabindex=\'36\' onBlur=\"makeValidString(this);if(this.value != \'\'){searchCode(this,off_add_postal_code);}else{}\"  size=\'15\' maxlength=\'15\'><input type=\'button\' name=\'postal_code\' id=\'postal_code\' tabindex=\'36\' value=\'?\' class=\'button\' onclick=\'searchCode(this,off_add_postal_code)\'>\n\t        ";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\t\t\t\t\t<input type=\'text\' name=\'off_add_postal_code2\' id=\'off_add_postal_code2\' tabindex=\'36\' size=\'15\' maxlength=\'15\'  onBlur=\"makeValidString(this);if(this.value != \'\'){searchCode(this,off_add_postal_code2);}else{}\" value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\"  ><input type=\'button\' name=\'postal_code\' id=\'postal_code\' tabindex=\'36\' value=\'?\' class=\'button\' onclick=\'searchCode(this,off_add_postal_code2)\'>\n\t\t\t\t";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\n\t\t\t\t\t<input type=\'text\' name=\'off_add_postal_code2\' id=\'off_add_postal_code2\' tabindex=\'36\' onBlur=\"makeValidString(this);if(this.value != \'\'){searchCode(this,off_add_postal_code2);}else{}\" size=\'15\' maxlength=\'15\'><input type=\'button\' tabindex=\'36\' name=\'postal_code\' id=\'postal_code\' value=\'?\' class=\'button\' onclick=\'searchCode(this,off_add_postal_code2)\'>\n\t\t\t\t";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="</td>\n\t<td class=\'fields\' width=\'6%\' >\n\t\n\t";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n\t\t\t<input type=\'text\' name=\'mail_add_postal_code\' id=\'mail_add_postal_code\'  tabindex=\'36\' size=\'15\' onBlur=\"makeValidString(this);if(this.value != \'\'){searchCode(this,mail_add_postal_code);}else{}\" maxlength=\'15\'><input type=\'button\' name=\'postal_code\' id=\'postal_code\' tabindex=\'36\' value=\'?\' class=\'button\' onclick=\'searchCode(this,mail_add_postal_code)\'>\n\n\t\t";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t\t\t<input type=\'text\' name=\'mail_add_postal_code2\' id=\'mail_add_postal_code2\' tabindex=\'36\' onBlur=\"makeValidString(this);if(this.value != \'\'){searchCode(this,mail_add_postal_code2);}else{}\"  size=\'15\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" ><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' tabindex=\'36\' class=\'button\' onclick=\'searchCode(this,mail_add_postal_code2)\'>\n\t\t\t\t";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n\t\t\t\t\t<input type=\'text\' name=\'mail_add_postal_code2\' id=\'mail_add_postal_code2\' tabindex=\'36\' onBlur=\"makeValidString(this);if(this.value != \'\'){searchCode(this,mail_add_postal_code2);}else{}\"   size=\'15\' maxlength=\'15\'><input type=\'button\' name=\'postal_code\' id=\'postal_code\' value=\'?\' tabindex=\'36\' class=\'button\' onclick=\'searchCode(this,mail_add_postal_code2)\'>\n\t\t\t\t";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="</td>\n\t";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n\t<td class=\'label\' width=\'6%\' >";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="</td>\n\t<td class=\'label\' width=\'6%\' >";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\n\t\t<input type=\'hidden\' name=\'res_code_value\' id=\'res_code_value\' value=\'";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\'>\n\t\t<input type=\'hidden\' name=\'off_code_value\' id=\'off_code_value\' value=\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\'>\n\t\t<input type=\'hidden\' name=\'mail_code_value\' id=\'mail_code_value\' value=\'";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\'>\n</tr>\n<tr>\n\t<td  width=\'3%\' class=\'label\'>";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\n\t\t<td class=\'fields\' width=\'6%\' >\n";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n<input type=\'text\' name=\'resCountryDode\' id=\'resCountryDode\' size=\'20\' value=\"\" tabindex=\'37\' onBlur=\"if(this.value != \'\') {searchCountryCode(this,resCountryDode,\'residence\');}\" maxlength=\'30\'> <input type=\'button\' name=\'CountryButton\' id=\'CountryButton\' value=\'?\' tabindex=\'37\' class=\'button\' onclick=\"searchCountryCode(this,resCountryDode,\'residence\')\" ><input type=\'hidden\' name=\'res_add_country_code\' id=\'res_add_country_code\' value=\'\'>\n";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n\t\t\t\t<input type=\'text\' name=\'resCountryDode\' id=\'resCountryDode\' size=\'20\' tabindex=\'37\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" onBlur=\"if(this.value != \'\') \t\t{searchCountryCode(this,resCountryDode,\'residence\');}\" ><input type=\'button\' tabindex=\'37\' name=\'CountryButton\' id=\'CountryButton\' value=\'?\' class=\'button\' onclick=\" searchCountryCode(this,resCountryDode,\'residence\')\" ><input type=\'hidden\' name=\'res_add_country_code\' id=\'res_add_country_code\' value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\">\n\t\t";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\n\t\t\t\t<input type=\'text\' name=\'resCountryDode\' id=\'resCountryDode\' tabindex=\'37\' size=\'20\' maxlength=\'30\'><input type=\'button\' onClick=\"searchCountryCode(this,resCountryDode,\'residence\');\" name=\'CountryButton\' id=\'CountryButton\' value=\'?\' class=\'button\' tabindex=\'37\' onclick=\"searchCountryCode(this,resCountryDode,\'residence\')\" ><input type=\'hidden\' name=\'res_add_country_code\' id=\'res_add_country_code\' value=\'\'>\n\t\t";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\n\t\t\t<input type=\'text\' name=\'offCountryDesc\' id=\'offCountryDesc\' value=\"\" tabindex=\'37\' onBlur=\"if(this.value != \'\') \t\t{searchCountryCode(this,offCountryDesc,\'office\');}\" size=\'20\' maxlength=\'30\'><input type=\'button\' tabindex=\'37\'  name=\'CountryButton\' id=\'CountryButton\' value=\'?\' class=\'button\' onclick=\"searchCountryCode(this,offCountryDesc,\'office\')\"><input type=\'hidden\' name=\'off_add_country_code\' id=\'off_add_country_code\' value=\'\'>\n\t        ";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n\t\t\t\t\t<input type=\'text\' name=\'offCountryDesc\' id=\'offCountryDesc\' size=\'20\' tabindex=\'37\' maxlength=\'30\'  onBlur=\"if(this.value != \'\') \t\t{searchCountryCode(this,offCountryDesc,\'office\');}\" value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\"  ><input type=\'button\' tabindex=\'37\' name=\'CountryButton\' id=\'CountryButton\' value=\'?\' class=\'button\' onclick=\"searchCountryCode(this,offCountryDesc,\'office\')\"><input type=\'hidden\' name=\'off_add_country_code\' id=\'off_add_country_code\' value=\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\n\t\t\t\t\t<input type=\'text\' name=\'offCountryDesc\' id=\'offCountryDesc\' value=\"\" tabindex=\'37\' onBlur=\"if(this.value != \'\') \t\t{searchCountryCode(this,offCountryDesc,\'office\');}\" size=\'20\' maxlength=\'30\'><input type=\'button\' tabindex=\'37\'  name=\'CountryButton\' id=\'CountryButton\' value=\'?\' class=\'button\' onclick=\"searchCountryCode(this,offCountryDesc,\'office\')\"><input type=\'hidden\' name=\'off_add_country_code\' id=\'off_add_country_code\' value=\'\'>\n\t\t\t\t";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="</td>\n\t<td class=\'fields\' width=\'6%\' >\n\t \n\t";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\n\t\t\t<input type=\'text\' name=\'offCountryDode\' id=\'offCountryDode\' size=\'20\' tabindex=\'37\' value=\"\" onBlur=\"if(this.value != \'\') {searchCountryCode(this,offCountryDode,\'mail\');}\" maxlength=\'30\'><input type=\'button\' tabindex=\'37\'  name=\'CountryButton\' id=\'CountryButton\' value=\'?\' class=\'button\' onclick=\"searchCountryCode(this,offCountryDode,\'mail\')\"onblur=\"callfunFocus();\"><input type=\'hidden\' name=\'mail_add_country_code\' id=\'mail_add_country_code\' value=\'\'>\n\n\t\t";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\n\t\t\t<input type=\'text\' name=\'offCountryDode\' id=\'offCountryDode\' size=\'20\' tabindex=\'37\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\" onBlur=\"if(this.value != \'\') \t\t{searchCountryCode(this,offCountryDode,\'mail\');}\"><input type=\'button\' tabindex=\'37\'  name=\'CountryButton\' id=\'CountryButton\' value=\'?\' class=\'button\' onclick=\"searchCode(this,offCountryDode,\'mail\')\" onblur=\"callfunFocus();\"><input type=\'hidden\' name=\'mail_add_country_code\' id=\'mail_add_country_code\' value=\'";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\n\t\t\t\t\t<input type=\'text\' name=\'offCountryDode\' id=\'offCountryDode\' tabindex=\'37\' value=\"\" onBlur=\"if(this.value != \'\') \t{searchCountryCode(this,offCountryDode,\'mail\');}\"   size=\'20\' maxlength=\'30\'><input type=\'button\'  tabindex=\'37\' name=\'CountryButton\' id=\'CountryButton\' value=\'?\' class=\'button\' onclick=\"searchCountryCode(this,offCountryDode,\'mail\')\" onblur=\"callfunFocus();\"><input type=\'hidden\' name=\'mail_add_country_code\' id=\'mail_add_country_code\' value=\'\'>\n\t\t\t\t";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="</td>\n\t\t\n\t\n\t";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\n\t<td align=\'left\' width=\'6%\'>";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="</td>\n\t<td align=\'left\' width=\'6%\'>";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\n</tr>\n</table>\n</td>\n</tr>\n<tr>\n<td>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n<tr>\n<td class=\'BODYCOLORFILLED\'>&nbsp;\n</td>\n</tr>\n</table>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br>\n<a name=\'deglink\' id=\'deglink\'></a>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\'  name=\'deg_link\' id=\'deg_link\'>\n<tr><th COLSPAN=\'4\'align=\'left\'>";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="</th></tr>\n\t<tr><td class=\'blankwhiterow\' colspan=\'4\'></td></tr>\n<tr>\n\t<td class = \'columnheader\' width=\'4%\'>&nbsp;</td>\n\t<td class = \'columnheader\' width=\'42%\'>";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="</td>\n\t<td class = \'columnheader\' width=\'22%\'>";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="</td>\n    <td class = \'columnheader\' width=\'32%\'>";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="</td>\n</tr>\n\n\n<tr>\t";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\n\t\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t<td class=\'fields\' onkeyDown=\'shift_tab3();\'><input type=\'text\' name=\"degree1\" id=\"degree1\" tabindex=\'38\' onBlur=\'makeValidString(this);enabledata(this)\' maxlength=\'60\' size=\'45\' value=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="   ></td><td class=\'fields\'><input type=\'text\' name=\"year1\" id=\"year1\" tabindex=\'38\' onBlur=\"makeValidString(this);chkyearlen(this);chkyear1(this);CheckNum(this)\" maxlength=\'4\' size=\'4\' value=\"";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 =" onkeypress=\"return allowValidNumber(this,event,20, 0);\"></td>\n\t\t<td class=\'fields\'>\n\t\t<input type=\'text\' name=\"univ1\" id=\"univ1\" tabindex=\'38\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 =" >\n\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'fields\' onkeyDown=\'shift_tab3()\'><input type=\'text\' name=\"degree1\" id=\"degree1\" tabindex=\'38\' onBlur=\"makeValidString(this);enabledata(this)\" maxlength=\'60\' size=\'45\' value=\"\"  ></td>\n\t\t\t<td class=\'fields\'><input type=\'text\' name=\"year1\" id=\"year1\" tabindex=\'38\' onBlur=\"makeValidString(this);chkyearlen(this);chkyear1(this);CheckNum(this) \" maxlength=\'4\' size=\'4\' value=\"\"  onkeypress=\"return allowValidNumber(this,event,20, 0);\" readonly ></td>\t\t\n\t\t<td class=\'fields\'>\n\t\t<input type=\'text\' name=\"univ1\" id=\"univ1\" tabindex=\'38\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"\" readOnly>\n\t\t</td>";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n\t\t</tr>\n\t\t\t<tr>\t";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\n\t<td>&nbsp;</td>\n\t<td class=\'fields\'><input type=\'text\' name=\"degree2\" id=\"degree2\" tabindex=\'38\' onBlur=\"makeValidString(this);enabledata(this)\" maxlength=\'60\' size=\'45\' value=\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 =" >\n</td>\n\t\t\n\t<td class=\'fields\'><input type=\'text\' name=\"year2\" id=\"year2\" tabindex=\'38\'  onBlur=\"makeValidString(this);chkyearlen(this);chkyear2(this);CheckNum(this) \" maxlength=\'4\' size=\'4\' value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 =" onkeypress=\"return allowValidNumber(this,event,20, 0);\"></td>\n\t<td class=\'fields\'><input type=\'text\' name=\"univ2\" id=\"univ2\" tabindex=\'38\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'fields\'><input type=\'text\' name=\"degree2\" id=\"degree2\" tabindex=\'38\' onBlur=\"makeValidString(this);enabledata(this)\" maxlength=\'60\' size=\'45\' value=\"\"  >\n</td><td class=\'fields\'><input type=\'text\' name=\"year2\" id=\"year2\" tabindex=\'38\' onBlur=\"makeValidString(this);chkyearlen(this);chkyear2(this);CheckNum(this) \" maxlength=\'4\' size=\'4\' value=\"\"  onkeypress=\"return allowValidNumber(this,event,20, 0);\" readOnly></td>\n\t<td class=\'fields\'>\n\t\t<input type=\'text\' name=\"univ2\" id=\"univ2\" tabindex=\'38\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"\" readonly>\n\t\t</td>";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\n\t<td class=\'label\'>&nbsp;</td><td class=\'fields\'><input type=\'text\' name=\"degree3\" id=\"degree3\" tabindex=\'38\' onBlur=\"makeValidString(this);enabledata(this);\" maxlength=\'60\' size=\'45\' value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 =" >\n</td><td class=\'fields\'><input type=\'text\' name=\"year3\" id=\"year3\" tabindex=\'38\' onBlur=\"makeValidString(this);chkyearlen(this);chkyear3(this);CheckNum(this) \" maxlength=\'4\' size=\'4\' value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 =" onkeypress=\"return allowValidNumber(this,event,20, 0);\" ></td><td class=\'fields\'>\n\t\t<input type=\'text\' name=\"univ3\" id=\"univ3\" tabindex=\'38\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 =">\n\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'fields\'><input type=\'text\' name=\"degree3\" id=\"degree3\" tabindex=\'38\' onBlur=\"makeValidString(this);enabledata(this)\" maxlength=\'60\' size=\'45\' value=\"\" >\n</td><td class=\'fields\'><input type=\'text\' name=\"year3\" id=\"year3\" tabindex=\'38\' onBlur=\"makeValidString(this);chkyearlen(this);chkyear3(this);CheckNum(this) \" maxlength=\'4\' size=\'4\' value=\"\" onkeypress=\"return allowValidNumber(this,event,20, 0);\" readonly></td><td>\n\t\t<input type=\'text\' name=\"univ3\" id=\"univ3\" tabindex=\'38\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"\" readonly>\n\t\t</td>";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\n\t<td class=\'label\'>&nbsp;</td><td class=\'fields\'><input type=\'text\' name=\"degree4\" id=\"degree4\" tabindex=\'38\' onBlur=\"makeValidString(this);enabledata(this)\" maxlength=\'60\' size=\'45\' value=\"";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 =" >\n</td><td class=\'fields\'><input type=\'text\' name=\"year4\" id=\"year4\" tabindex=\'38\' onBlur=\"makeValidString(this);chkyearlen(this);chkyear4(this);CheckNum(this) \"  maxlength=\'4\' size=\'4\' value=\"";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="onkeypress=\"return allowValidNumber(this,event,20, 0);\" ></td><td class=\'fields\'>\n\t\t<input type=\'text\' name=\"univ4\" id=\"univ4\" tabindex=\'38\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\'  value=\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\n\t\t\t<td class=\'label\'>&nbsp;</td><td class=\'fields\'><input type=\'text\' name=\"degree4\" id=\"degree4\" tabindex=\'38\' onBlur=\"makeValidString(this);enabledata(this)\" maxlength=\'60\' size=\'45\' value=\"\"  >\n</td><td class=\'fields\'><input type=\'text\' name=\"year4\" id=\"year4\" tabindex=\'38\' onBlur=\"makeValidString(this);chkyearlen(this);chkyear4(this);CheckNum(this) \" maxlength=\'4\' size=\'4\' value=\"\"  readonly onkeypress=\"return allowValidNumber(this,event,20, 0);\"></td>\n\t<td class=\'fields\'>\n\t\t<input type=\'text\' name=\"univ4\" id=\"univ4\" readonly tabindex=\'38\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"\" readonly>\n\t\t</td>";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n\t\t</tr>\n</table>\n\n\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\'  name=\'deg_link\' id=\'deg_link\'>\n<tr><th colspan=\"4\" align=\"left\">";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="</th></tr>\n\t\t<tr><td class=\'blankwhiterow\' colspan=\'4\'></td></tr>\n<tr>\n\t<td class = \'columnheader\' width=\'4%\'>&nbsp;</td>\n\t<td class = \'columnheader\' width=\'64%\' colspan=\'2\'>";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="</td>\t\n\t<td class = \'columnheader\' width=\'32%\'>";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="</td>\n</tr>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<tr>\n";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\n\t\t<td class=\'label\' width=\'4%\'>&nbsp;</td>\n\t\t<td class=\'fields\' width=\'64%\' colspan=\'2\'>\n\t\t\t<textarea name=\"det1\" id=\"det1\" rows=\'2\' cols =\'50\' size=\'30\' tabindex=\'39\' onKeyPress=\'checkMaxLimit(this,100);\' onBlur=\"makeValidString(this)\" ";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 =" width=\"5%\">";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="</textarea>\n\t\t</td>\n\t\t<td class=\'fields\' width=\'32%\'>\n\t\t\t<input type=\'text\' name=\"con1\" id=\"con1\" tabindex=\'39\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 =" >\n\t\t</td>\n";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\n\t\t\t<td class=\'label\' width=\'4%\'>&nbsp;</td>\n\t\t\t<td class=\'fields\' width=\'64%\' colspan=\'2\'>\n\t\t\t\t<textarea name=\"det1\" id=\"det1\"  rows=2 cols =50 onKeyPress=\'checkMaxLimit(this,100);\' tabindex=\'39\' size=\'30\' onBlur=\"makeValidString(this)\" value=\"\" width=\"5%\"></textarea>\n\t\t\t</td>\n\t\t\t<td class=\'fields\' width=\'32%\'>\n\t\t\t\t<input type=\'text\' name=\"con1\" id=\"con1\" tabindex=\'39\' maxlength=\'30\' size=\'30\' onBlur=\"makeValidString(this)\"  value=\"\" >\n\t\t\t</td>\n";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\n\t\t</tr>\n\t\t<tr>\n";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n\t\t<td class=\'label\' width=\'4%\'>&nbsp;</td>\n\t\t<td class=\'fields\' width=\'64%\' colspan=\'2\'><textarea name=\"det2\" id=\"det2\" tabindex=\'39\' rows=2 cols =50 onBlur=\"makeValidString(this)\" onKeyPress=\'checkMaxLimit(this,100);\' size=\'30\'  ";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="</textarea></td>\n\t\t<td class=\'fields\' width=\'32%\'>\n\t\t<input type=\'text\' name=\"con2\" id=\"con2\" tabindex=\'39\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\n\t\t\t<td class=\'label\' width=\'4%\'>&nbsp;</td>\n\t\t\t<td class=\'fields\' width=\'64%\' colspan=\'2\'><textarea name=\"det2\" id=\"det2\"  rows=2 cols =50 tabindex=\'39\' onBlur=\"makeValidString(this)\" onKeyPress=\'checkMaxLimit(this,100);\' size=\'30\' value=\"\" width=\"5%\"></textarea>\n\t\t\t</td>\n\t\t\t<td class=\'fields\' width=\'32%\'>\n\t\t\t<input type=\'text\' name=\"con2\" id=\"con2\" tabindex=\'39\'  onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"\" >\n\t\t\t</td>";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\n\t\t\t</tr>\n\t\t\t<tr>\t";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\n\t\t<td class=\'label\' width=\'4%\'>&nbsp;</td>\n\t\t<td class=\'fields\' width=\'64%\' colspan=\'2\'><textarea name=\"det3\" id=\"det3\" rows=2 tabindex=\'39\' cols =50 onBlur=\"makeValidString(this)\" onKeyPress=\'checkMaxLimit(this,100);\' size=\'30\'  ";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="</textarea></td>\n\t\t<td class=\'fields\' width=\'32%\'>\n\t\t<input type=\'text\' name=\"con3\" id=\"con3\" tabindex=\'39\' onBlur=\"makeValidString(this)\" maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\n\t\t\t<td class=\'label\' width=\'4%\'>&nbsp;</td>\n\t\t\t<td class=\'fields\' width=\'64%\' colspan=\'2\'><textarea name=\"det3\" id=\"det3\" rows=2 cols =50 tabindex=\'39\' onBlur=\"makeValidString(this)\" onKeyPress=\'checkMaxLimit(this,100);\' size=\'30\' value=\"\" width=\"5%\"></textarea>\n\t\t\t</td>\n\t\t\t<td class=\'fields\'width=\'332%\'>\n\t\t\t<input type=\'text\' name=\"con3\" id=\"con3\" onBlur=\"makeValidString(this)\" tabindex=\'39\' maxlength=\'30\' size=\'30\' value=\"\" >\n\t\t</td>";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\n\t\t<td class = \'label\'\twidth=\'4%\'>&nbsp;</td>\n\t\t<td class=\'fields\' width=\'64%\' colspan=\'2\'>\n\t\t<textarea name=\"det4\" id=\"det4\" rows=2 cols =50 tabindex=\'39\' onBlur=\"makeValidString(this)\" onKeyPress=\'checkMaxLimit(this,100);\' size=\'30\'  ";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="</textarea>\n\t\t</td>\n\t\t<td class=\'fields\' width=\'32%\'>\n\t\t<input type=\'text\' name=\"con4\" id=\"con4\" onBlur=\"makeValidString(this); detailsoftraining();\" tabindex=\'39\' maxlength=\'30\' size=\'30\' value=\"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\n\t\t\t<td class=\'label\' width=\'4%\'>&nbsp;</td>\n\t\t\t<td class=\'fields\' width=\'64%\' colspan=\'2\'><textarea name=\"det4\" id=\"det4\" rows=2 cols =50 tabindex=\'39\' onBlur=\"makeValidString(this)\" onKeyPress=\'checkMaxLimit(this,100);\' size=\'30\' value=\"\" width=\"5%\"></textarea></td>\n\t\t\t<td class=\'fields\' width=\'32%\'>\n\t\t\t<input type=\'text\' name=\"con4\" id=\"con4\" tabindex=\'39\' onBlur=\"makeValidString(this); detailsoftraining();\" maxlength=\'30\' size=\'30\' value=\"\">\n\t\t</td>";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\n\t\t</tr>\n</table>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br>\n<br><br><br><br><br><br>\n";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\n \t       \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n  \t       \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\n  \t";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\n\t       \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n  \t\t    <input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n  \n  \t       \t";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\n \t       \t<input type=\'hidden\' name=\'pract_type1\' id=\'pract_type1\'>\n\t\t\t<input type=\'hidden\' name=\'job_title1\' id=\'job_title1\'>\t\t\t\n  \t       \t<input type=\'hidden\' name=\'practitioner_id1\' id=\'practitioner_id1\' >\n  \t       \t<input type=\'hidden\' name=\'practitioner_name1\' id=\'practitioner_name1\' >\n  \t       \t<input type=\'hidden\' name=\'short_name1\' id=\'short_name1\'>\n  \t       \t<input type=\'hidden\' name=\'eff_status1\' id=\'eff_status1\'>\n\t\t\t<input type=\'hidden\' name=\'fpp_pract_yn\' id=\'fpp_pract_yn\'><!--Added by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184-->\n\t\t\t<input type=\'hidden\' name=\'supervisor_yn\' id=\'supervisor_yn\'>\n  \t       \t<input type=\'hidden\' name=\'date_of_birth1\' id=\'date_of_birth1\'>\n  \t       \t<input type=\'hidden\' name=\'date_of_birth2\' id=\'date_of_birth2\'>\n  \t       \t<input type=\'hidden\' name=\'primary_speciality_codeh\' id=\'primary_speciality_codeh\'>\n  \t        <input type=\'hidden\' name=\'practid\' id=\'practid\' value=";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 =" >\n  \t \t   <input type=\'hidden\' name=\'server_date\' id=\'server_date\' value=";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 =" >\n\t\t   <input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n\t\t   <input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\'>\n\t\t    <input type=\'hidden\' name=\'effstatus12\' id=\'effstatus12\' value=\'";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\'>\n\t\t\t <input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\'";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\'>\n\t\t\t<input type=\'hidden\' name=\'long_name1\' id=\'long_name1\'>\n\t\t\t<input type=\'hidden\' name=\'enable_virtual_consultation1\' id=\'enable_virtual_consultation1\'>//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 13-04-2023 -->\n\t\t\t<input type=\"hidden\" name=\"other_alt_no1\" id=\"other_alt_no1\" value=\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\"> <!--Added for this CRF HSA-CRF-160 -->\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"cerner_practitioner_id\" id=\"cerner_practitioner_id\" value=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\">  \n\t\t\t<input type=\"hidden\" name=\"signimage1\" id=\"signimage1\" value=\"\"> <!-- added by mujafar for AAKH-CRF-0079.4 -->\n\t\t\t<input type=\"hidden\" name=\"stampimage1\" id=\"stampimage1\" value=\"\"> <!-- added by manjunath for TH-KW-CRF-0161.1 -->\n\t\t\t<!--Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011-->\n\t\t\t<input type=\"hidden\" name=\"eff_stat\" id=\"eff_stat\" value=\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\">\n\t\t\t<input type=\"hidden\" name=\"citizen_nat_desc\" id=\"citizen_nat_desc\" value=\"";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\">\n\t\t\t<input type=\"hidden\" name=\"citizen_nat_code\" id=\"citizen_nat_code\" value=\"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\">\n\t\t\t<input type=\"hidden\" name=\"isResidencyApplYN\" id=\"isResidencyApplYN\" value=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\">\n\n\t\t\t<input type=\"hidden\" name=\"isPractEmployeeServiceNumber\" id=\"isPractEmployeeServiceNumber\" value=\"";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\"> <!-- Added by Kamatchi S for PMG2023-COMN-CRF-0043 -->\n\n\t\t\t<input type=\"hidden\" name=\"natid_mand_yn\" id=\"natid_mand_yn\" value=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\">\n\t\t\t<input type=\"hidden\" name=\"oth_alt_val\" id=\"oth_alt_val\" value=\"";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\">\n\t\t\t<input type=\"hidden\" name=\"other_alt_type_no\" id=\"other_alt_type_no\" value=\"";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\">\n\t\t\t<input type=\"hidden\" name=\"other_alt_type_desc\" id=\"other_alt_type_desc\" value=\"";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\">\n\t\t\t<input type=\"hidden\" name=\"alt_id1_type\" id=\"alt_id1_type\" value=\"";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\">\n\t\t\t<input type=\"hidden\" name=\"alt_id1_length\" id=\"alt_id1_length\" value=\"";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\">\n\t\t\t<input type=\"hidden\" name=\"oth_alt_length\" id=\"oth_alt_length\" value=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\">\n\t\t\t\n\t\t   \n<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n<script>\n\tif(\'";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\' == \"T\") \n\t{\n\t\tdocument.getElementById(\"popempid\").innerHTML=\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID <input type=\'text\' value=\'";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\' name=\'employee_id\' maxlength=\'30\' size =\'30\' READONLY>\";\n\t}\n\n</script>\t\n";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\n<script>document.practitioner1_form.job_title.disabled=true</script>\n";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\n</form>\n</body>\n<script>\nfunction populateValues()\n{\nvar obj=parent.practitioner_sub.document.practitioner1_form.job_title;\nvar length = obj.length;\n for(i=0;i<length;i++)\n  obj.remove(1);\nvar pract_type=parent.practitioner_main.document.practitioner_form.pract_type.value;\nvar HTMLVal = \"<html><body onKeyDown = \'lockKey()\'><form name=\'practform\' id=\'practform\' method=\'post\' action=\'../../eAM/jsp/PopulatePosition.jsp\'><input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\'\"+pract_type+\"\'>\t</form></body></html>\";\t\nparent.parent.frames[3].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\nparent.parent.frames[3].document.forms[0].submit();\n}\n\nfunction populateValue1()\n{\t\n\tvar obj;\nif(parent.practitioner_sub.document.practitioner1_form)\n\t{\n\tobj=parent.practitioner_sub.document.practitioner1_form.job_title;\n\t\nvar length = obj.length;\n for(i=0;i<length;i++)\n  obj.remove(1);\n\n if(practitioner1_form.function_name.value == \"modify\") \n\t\t\t{    \n         var pract_type=\'";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\';\n\t\t var pos_code=\'";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\';\n  //setTimeout(\'populateValue1()\',500); \t\t\nvar HTMLVal = \"<html><body onKeyDown = \'lockKey()\'><form name=\'practform\' id=\'practform\' method=\'post\' action=\'../../eAM/jsp/PopulatePosition.jsp\'><input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\'\"+pract_type+\"\'>\t<input type=\'hidden\' name=\'pos_code\' id=\'pos_code\' value=\'\"+pos_code+\"\'></form></body></html>\";\n\nif(parent.parent.frames[3].document.body)\nparent.parent.frames[3].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\nparent.parent.frames[3].document.forms[0].submit();\n\t\t\t}\n\t}\n}\nfunction populateValue2()\n{\n\tsetTimeout(\'populateValue1()\',5000); \n}\n\nfunction echeck10()\n{\n\tif(practitioner1_form.empl_status.value == \"T\")\t\t\t\n\t{\n\t\tdocument.getElementById(\'popempid\').innerHTML=\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Empl ID &nbsp;<input type=\'text\' value=\'";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\' name=\'employee_id\' maxlength=\'30\' size =\'30\' READONLY>\";\n\t}\n\telse \t\n\t \tdocument.getElementById(\'popempid\').innerHTML=\"&nbsp;\";\t\n}\nfunction maxLength(field,maxChars)\n {\n\t   alert(\"feild\"+field);\n       //if(field.value.length >= maxChars) {\n\t   if(field.value.length > maxChars) {\n\t     var errors1 = getMessage(\'OBJ_CANNOT_EXCEED\',\'Common\');\n\t\terrors1 = errors1.replace(\'$\', maxChars);\t\t  \n\t\t  alert(errors1);\n              field.select();\n              field.focus();\t\t  \n          return false;\n       }\n\t   else{\n\t     return true;\n\t   }\n }    \n\n function maxLengthPaste(field, maxChars) {\n\t    field.addEventListener(\'paste\', function(event) {\n\t        event.preventDefault();\n\t        var pasteData = (event.clipboardData || window.clipboardData).getData(\'text\');\n\t        var currentLength = field.value.length;\n\t        var pasteLength = pasteData.length;\n\n\t        if (currentLength + pasteLength > maxChars) {\n\t            var allowedLength = maxChars - currentLength;\n\t            var truncatedData = pasteData.substring(0, allowedLength);\n\t            var errors1 = getMessage(\'OBJ_CANNOT_EXCEED\', \'Common\');\n\t            errors1 = errors1.replace(\'$\', maxChars);\n\t            alert(errors1);\n\t            var startPos = field.selectionStart;\n\t            field.value = field.value.substring(0, startPos) + truncatedData + field.value.substring(startPos);\n\t            field.setSelectionRange(startPos + truncatedData.length, startPos + truncatedData.length);\n\t        } else {\n\t            var startPos = field.selectionStart;\n\t            var endPos = field.selectionEnd;\n\t            field.value = field.value.substring(0, startPos) + pasteData + field.value.substring(endPos);\n\t            field.setSelectionRange(startPos + pasteData.length, startPos + pasteData.length);\n\t        }\n\n\t        // Trigger input event to ensure the field is editable immediately\n\t        var inputEvent = new Event(\'input\', { bubbles: true });\n\t        field.dispatchEvent(inputEvent);\n\t    });\n\t}\nfunction ChkKey(evnt)\n{ \n\tif(evnt.keyCode == \'13\')\n\t\treturn false;\n}\n//Added for this CRF HAS-CRF-160\nfunction enabledOtherAltId(){ \n  document.practitioner1_form.other_alt_no.value=\"\";\n\t\tif(document.practitioner1_form.other_alt_type.selectedIndex != 0){\n\t\t\tdocument.practitioner1_form.other_alt_no.disabled = false;\n\t\t\tdocument.practitioner1_form.other_alt_no.value=\"\";\n\t\t\tdocument.practitioner1_form.other_alt_no1.value=\"\";\n\t\t}else { \n\t\t\tdocument.practitioner1_form.other_alt_no.disabled = true;\n\t\t\t\n\t\t}\n}\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);
request.setCharacterEncoding("UTF-8");
 //MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

      	Connection conn = null; 
		conn = ConnectionManager.getConnection(request);
		
		Boolean isVIRTUAL_CONSULTATION  = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION");//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 17-04-2023 -->
		
		//<!--added by lakshmanan for MO-CRF-20183.2 start-->
		String practEmployeeServiceNo="";
		
		//<!--added by lakshmanan for MO-CRF-20183.2 end-->
		
		boolean isPractEmployeeServiceNumber  = false ; // Added for PMG2023-COMN-CRF-0043 by Kamatchi S
		
      	String accept_national_id_no_yn = "N",/*nat_id_length="",*/nat_id_prompt="",nat_id_chk_len="",nat_id_check_digit_id="",nat_data_source_id="";
      	String practitionerid="";
      	String nat_id_accept_alphanumeric_yn = "";
      		
      	practitionerid=request.getParameter("practitioner_id");
		
		if(practitionerid==null) practitionerid = "null";
		String facilityid=(String)session.getValue("facility_id");
      	int totApptCount=0;
      	StringBuffer strt=new StringBuffer();;
      	String strt1="";
      	String strt2="";
      	String practtype="";
      	String practtypedesc="";
      	String practtype1="";
      	String practtypedesc1="";
		String birthdate_disp="";
		String reporting_facility_id="";      		
      	String practitionername="";
		InputStream practitioner_sign = null; // added by mujafar for AAKH-CRF-0079.4
		InputStream practitioner_stamp = null; // added by manjunath for TH-KW-CRF-0161.1
		String includevisibility = "disabled";
        String includevisibility1 = "disabled";// added by manjunath for TH-KW-CRF-0161.1
		String shortname="";
      	String effstatus="";
   	 	StringBuffer str1=new StringBuffer();
   	 	String strs1="";
   	 	String strs2="";
		StringBuffer str2=new StringBuffer();
		String strm1="";
		String strm2="";
		//String str3="";
		String strc1="";
		String strc2="";
		StringBuffer str4=new StringBuffer();
		String strr1="";
		String strr2="";
		StringBuffer str5=new StringBuffer();
		String stre1="";
		String stre2="";
		StringBuffer str15=new StringBuffer();
		String strpr1="";
		String strpr2="";
		StringBuffer str6=new StringBuffer();;
		String strp1="";
		String strp2="";
		
		String strrep1="";
		String strrep2="";
		//String str8="";
		String strrec1="";
		String strrec2="";
		String strofp1="";
		String strofp2="";
		//String str10="";
		String strofc1="";
		String strofc2="";
		String strmap1="";
		String strmap2="";
		//String str12="";
		String strmac1="";
		String strmac2="";
		String str13="";
		String str14="";
		String sex="";
		String sex1="";
		String emplstatus="";
		String emplstatus1="";
		String prefmode="";
		String prefmode1="";
		String birthdate="";
		String birthplace="";
		String mar_status_code="";
		String maritalstatus="";
		String maritaldesc="";
		String maritalstatus1="";
		String maritaldesc1="";
		String aliasname="";
		String citizen="";
		String citizendesc="";
		String citizen1="";
		String citizendesc1="";
		String nationalidno="";
		//Variables added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
		String credentialid1="";
		String credentialid2="";
		String credentialid3="";
		//End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
		String jobtitle="";
		String degree="";
		String repfacility="";
		String repfacilityname="";
		String repfacility1="";
		String repfacilityname1="";
		String prspcode="";
		String prspdesc="";
		String prspcode1="";
		String prspdesc1="";
		String allfacilities="";
		String restelnum="";
		String offtelnum="";
		String offtelext="";
		String pagernum="";
		String faxnum="";
		String mobilenum="";
		String emailid="";
		String resaddln1="";
		String resaddln2="";
		String resaddln3="";
		String resaddln4="";
		String offaddln1="";
		String offaddln2="";
		String offaddln3="";
		String offaddln4="";
		String mailaddln1="";
		String mailaddln2="";
		String mailaddln3="";
		String mailaddln4="";
		String respostalcode="";
		String offpostalcode="";
		String mailpostalcode="";
		String rescountrycode="";
		String rescountrydesc="";
		String respostaldesc="";
		String offpostaldesc="";
		String mailpostaldesc="";
		//String rescountrycode1="";
		//String rescountrydesc1="";
		String offcountrycode="";
		String offcountrydesc="";
		//String offcountrycode1="";
		//String offcountrydesc1="";
		String mailcountrycode="";
		String mailcountrydesc="";
		//String mailcountrycode1="";
		//String mailcountrydesc1="";
		String poscode="";
		String sql11="";
		String bage="";
		String bmonths="";
		String bdays="";
		int count=0;
   	 	String codeTextAttribute="";
		String otherTextAttribute="";
		String otherTextAttributeEmpSrvNo=""; //added by lakshmanan for MO-CRF-20183
		String checkBoxAttribute="";
		String checkBoxAttribute1="";
		String checkBoxAttribute_EVC=""; //added by Himanshu Saxena for ML-MMOH-CRF-1930(U1)
		String effstatus_EVC=""; //added by Himanshu Saxena for ML-MMOH-CRF-1930(U1)
		String disable_checkbox="";//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1)
		String eventFunctionForCase="";
		String fcall="";		
		String cnc = "";
		String cncdesc = "";
		String employeeid ="";
		String disablerecord="";
		String apc_no="";

		String degree1 = "";
		String degree2 = "";
		String degree3 = "";
		String degree4 = "";

		String year1 = "";
		String year2 = "";
		String year3 = "";
		String year4 = "";
		
		String univ1 = "";
		String chkvalue1="";
		String univ2 = "";
		String univ3 = "";
		String univ4 = "";

		String con1 = "";
		String con2 = "";
		String con3 = "";
		String con4 = "";
		
		String det1 = "";
		String det2 = "";
		String det3 = "";
		String det4 = "";
		String function_id="";
		String disableextn="";
	    String readProperty="";	
	    //Added for the CRF - Bru-HIMS-CRF-198
	    String multi_Spec_disabled="";	
	    String multi_speciality_yn="";	
	    String longname="";
	    String longname1="";
	   // String mode12="";
	   	java.sql.Statement stmt2= null;
		ResultSet rs2 = null;

		java.sql.Statement stmt = null;
		ResultSet rs = null;

	   //Added HSA-CRF-160
		Statement other_altstat=null;
		ResultSet other_altrs=null;
		String alt_type_code="",alt_type_desc="",other_alt_type_no="",other_alt_type_desc="",other_alt_select="";
		
		//Below line added for this CRF ML-MMOH-CRF-0862
	    boolean isCernerpractitioner = false; 
		String cerner_prac_id="";
		String shortdescMaxLength="15";
		String shortdescMaxSize="15";
		
		/*Added by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184 Start*/
		boolean isFPPPractApplicable	= false;
		String	fppPractYn				= "";
		/*End*/
		
		/*Added By Dharma on 19th Aug 2020 against AAKH-CRF-0122.4 Start*/
		boolean isCoderDiagAppl	= false;
		String supervisor_yn	= "N";
		/*Added By Dharma on 19th Aug 2020 against AAKH-CRF-0122.4 End*/

		/*Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
		Boolean isResidencyApplYN = false;
		String citizen_nat_code = "";
		String citizen_nat_desc = "";
		String citizen_code = "";
		String citizenChk = "Checked";
		String nonCitizenChk = "";
		String natIdDis = "";
		String nat_visibility = "";
		String natid_mand_yn = "";
		String oth_alt_val = "";
		String other_alt_type_dis = "";
		String other_alt_no_dis = "disabled";
		String oth_alt_visibility = "hidden";
		String alt_id1_type = "";
		String alt_id1_length = "";
		String oth_alt_length = "20";
		/*End MOHE-CRF-0011*/
		
		boolean isMMCLblchngesAppl		= false;////Added By Dharma on 23rd Dec 2019 against  ML-MMOH-CRF-1488
		boolean isSplCharNotAllowApplYN = false; //Added by Suji Keerthi for MOHE-CRF-0113 US001
		
	 //  if(mode12.equals("update"))
     //disableextn="disabled";

		java.sql.Statement stmtcit = null;
		ResultSet rscit = null;
		java.sql.Statement stmt9=null;
		stmt9=conn.createStatement();
		String sql9="select to_char(sysdate,'dd/mm/yyyy') from dual";
		ResultSet rs9=null;
		rs9=stmt9.executeQuery(sql9);
				  	
		if(rs9.next())
		{		  	
		str13=rs9.getString(1);
		} 


		try
		{
		
			isFPPPractApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","FULL_PAYING_PATIENT_PRACT");//Modified by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184
			isPractEmployeeServiceNumber = eCommon.Common.CommonBean.isSiteSpecific(conn,"AM","PRACT_EMPLOYEE_SERVICE_NO");// Added for PMG2023-COMN-CRF-0043 by Kamatchi S
			isMMCLblchngesAppl  = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","AM_MMCNO_LBL_APPL_YN");//Added By Dharma on 23rd Dec 2019 against  ML-MMOH-CRF-1488

			isCoderDiagAppl =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","MR_CODER_DIAGNOSIS"); //Added By Dharma on 19th Aug 2020 against AAKH-CRF-0122.4 
			
			//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			isResidencyApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "NATID_MAND_PRACT_OTHSTAFF");
			natid_mand_yn = eAM.AMCommonBean.getNatIdMandYN(conn);
			oth_alt_val = eAM.AMCommonBean.getOthAltDefaultValue(conn, "SM", "NATID_MAND_PRACT_OTHSTAFF");

		//Below line added for this CRF ML-MMOH-CRF-0862	    
		isCernerpractitioner=CommonBean.isSiteSpecific(conn, "AM","CERNER_PRACTITIONER_ID");
		if(isCernerpractitioner){
		shortdescMaxLength="40";
		shortdescMaxSize="60";
		}
		//End this ML-MMOH-CRF-0862

		isSplCharNotAllowApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "SPL_CHAR_NOT_ALLOWED"); //Added by Suji Keerthi for MOHE-CRF-0113 US001
		
		
		
			///////////////////////////
			stmtcit=conn.createStatement();
			
			rscit=stmtcit.executeQuery("select a.citizen_nationality_code citizen_nat_code, b.country_code , b.long_desc longDesc from mp_param a, mp_country b where b.eff_status = 'E' and  a.citizen_nationality_code = b.country_code");
			if(rscit != null && rscit.next())
			{		
				cnc=rscit.getString("citizen_nat_code");
				cncdesc=rscit.getString("longDesc");

				//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
				citizen_nat_code = rscit.getString("citizen_nat_code");
				if (citizen_nat_code == null || citizen_nat_code.equals("null")) citizen_nat_code = "";
				citizen_nat_desc = rscit.getString("longDesc");
				if (citizen_nat_desc == null || citizen_nat_desc.equals("null")) citizen_nat_desc = "";
			}
			 if(rscit != null) rscit.close();
			 if(stmtcit != null) stmtcit.close();
		////////////////////////////
       	boolean newPractitioner=false;
   	 	fcall = request.getParameter("fcall"); 
		if (fcall == null) fcall="";
			function_id=request.getParameter("function_id");
         if(function_id.equals("EXT_PRACT"))
			{
			  chkvalue1="checked";
			 // chk_value_new="Y";
			}
			else{
              chkvalue1="";
			 // chk_value_new="N";
			}
		if(function_id == null) function_id="";
	 	if(practitionerid!=null && practitionerid.equals("null")) 
		{
   	 		practitionerid = "";
			
			practitionername="";
			shortname="";
   	 		str1.append("<select name='sex' id='sex' tabindex='9' onkeyDown='shift_tab()'  ><option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</select>");

			birthdate="";
			birthplace="";

   	 		java.sql.Statement stmtty = null;
			
			java.sql.Statement stmt1= null;
		
			java.sql.Statement stmt3=null;
   	 		java.sql.Statement stmt4=null;
			java.sql.Statement stmt5=null;
			java.sql.Statement stmt6=null;
			java.sql.Statement stmt7=null;
			java.sql.Statement stmt8=null;
			
			java.sql.Statement stmt10=null;
			java.sql.Statement stmtpr=null;
			java.sql.Statement stmtf=null;
			//java.sql.Statement stmtc=null;
			ResultSet rst = null;
			
			ResultSet rs1 = null;
			
			ResultSet rs3 = null;
			ResultSet rs4= null;
			ResultSet rs5=null;
			ResultSet rs6=null;
			ResultSet rs7=null;
			ResultSet rs8=null;
			
			ResultSet rs10=null;
			ResultSet rspr=null;
			ResultSet rsf=null;
			//ResultSet rsc=null;

		try
			{
			stmtf=conn.createStatement();
			String sqlf="select count(*) as total from sm_facility_param";
			rsf=stmtf.executeQuery(sqlf);
			if(rsf.next())
			{
				count=rsf.getInt("total");
			}
		    }
			catch(Exception e) 
			{
		     out.println("errors="+e);
		     }
			 finally 
			 {
				 try
				 {
					 if(stmtf != null) stmtf.close();
					 if(rsf != null) rsf.close();
				  }
				  catch(Exception e)
				 {
					  e.printStackTrace();
				  }
			 }

		try {
		  	stmtty=conn.createStatement();
		  	String sqlt = "select pract_type,Desc_Userdef  from am_pract_type where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by Desc_Userdef";
		  	rst=stmtty.executeQuery(sqlt);
  strt.append("<select name='pract_type' id='pract_type' onChange='populateValues();enaDisSupervisorChkbox(this.value);validateEnablevirtualConst(this.value)' tabindex='1'><option value=''> -----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------");	
		  	 while(rst.next()) 
		  	 {
		  		practtype=rst.getString("pract_type");
		  		practtypedesc=rst.getString("Desc_Userdef");
		  		strt.append("<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc);
				

		  	 }
		  	strt.append("</select>");
			
			stmt1=conn.createStatement();
			String sql1="select country_code,long_desc from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))  and long_desc is not null order by long_desc ";
			rs1=stmt1.executeQuery(sql1);
			//str3="<select name='citizen' id='citizen'><option value=''>-----Select-----"+"</option>";
			 while(rs1.next())
			 {
				citizen=rs1.getString("country_code");
				citizendesc=rs1.getString("long_desc");
				if(citizen==null) citizen = "";
				if(citizendesc==null) citizendesc = "";
				if(cnc==null) cnc = "";

				/*if(cnc.equals(citizen)) 
				{
					str3+="<option value='"+citizen+"' selected>"+citizendesc+"</option>";
				}
				else 
				{
					str3+="<option value='"+citizen+"'>"+citizendesc+"</option>";
				}*/
			 }
			//str3+="</select>";
			
			stmt4=conn.createStatement();
			String sql4="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			rs4=stmt4.executeQuery(sql4);
			//str8="<select name='res_add_country_code' id='res_add_country_code'><option value=''>-----Select-----"+"</option>";
			while(rs4.next())
			{
				rescountrycode=rs4.getString("country_code");
				rescountrydesc=rs4.getString("short_name");
				//str8+="<option value='"+rescountrycode+"'>"+rescountrydesc+"</option>";
			}
			//str8+="</select>";
			
			stmt6=conn.createStatement();
			String sql6="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			rs6=stmt6.executeQuery(sql6);
			//str10="<select name='off_add_country_code' id='off_add_country_code'><option value=''>-----Select-----"+"</option>";
			 while(rs6.next())
		  	 {
		  		offcountrycode=rs6.getString("country_code");
		  		offcountrydesc=rs6.getString("short_name");
		  		//str10+="<option value='"+offcountrycode+"'>"+offcountrydesc+"</option>";
		  	 } 
		  	//str10+="</select>";
		  	
		  	stmt8=conn.createStatement();
		  	String sql8="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
		  	rs8=stmt8.executeQuery(sql8);
		  	//str12="<select name='mail_add_country_code' id='mail_add_country_code' onBlur='document.getElementById("residencetelno").focus()'><option value=''>-----Select-----"+"</option>";
		  	while (rs8.next())
		  	{
		  		mailcountrycode=rs8.getString("country_code");
		  		mailcountrydesc=rs8.getString("short_name");
		  		//str12+="<option value='"+mailcountrycode+"'>"+mailcountrydesc+"</option>";
		  	}
		  	//str12+="</select>";
			
		  	stmt10=conn.createStatement();
		  	String sql10="select nat_id_length,accept_national_id_no_yn,nat_id_prompt, nat_id_chk_len, nat_id_check_digit_id ,nat_data_source_id,nat_id_accept_alphanumeric_yn, alt_id1_type, alt_id1_length from mp_param";
		  	rs10=stmt10.executeQuery(sql10);
		  	
		  	if(rs10 != null)
		  	{		
		  		while(rs10.next())
		  		{
		  			str14=rs10.getString(1);
		  			accept_national_id_no_yn=rs10.getString(2);
					if(accept_national_id_no_yn == null) accept_national_id_no_yn ="N";
		  			nat_id_accept_alphanumeric_yn=rs10.getString("nat_id_accept_alphanumeric_yn");
		  			if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn ="N";
		  			nat_id_prompt=rs10.getString(3);if(nat_id_prompt == null) nat_id_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
		  			nat_id_chk_len=rs10.getString(4);if(nat_id_chk_len == null) nat_id_chk_len="";
		  			nat_id_check_digit_id=rs10.getString(5);if(nat_id_check_digit_id == null) nat_id_check_digit_id="";
		  			nat_data_source_id=rs10.getString(6);if(nat_data_source_id == null) nat_data_source_id="";
					//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
					alt_id1_type = rs10.getString("alt_id1_type");if(alt_id1_type == null) alt_id1_type="";
					alt_id1_length = rs10.getString("alt_id1_length");if(alt_id1_length == null) alt_id1_length="";	  			
		  		}	
		  	}	
		 	
		  	stmtpr=conn.createStatement();
		  	String sqlpr="select speciality_code,short_desc from am_speciality where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc ";
		  	rspr=stmtpr.executeQuery(sqlpr);
		  	str15.append("<select name='primary_speciality_code' id='primary_speciality_code' tabindex='7'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------"+"</option>");
		  	while (rspr.next())
		  	{
		  		prspcode=rspr.getString("speciality_code");
		  		prspdesc=rspr.getString("short_desc");
		  		str15.append("<option value='"+prspcode+"'>"+prspdesc+"</option>");
		  	}
		  	str15.append("</select>");
		}
		catch(Exception e)
		{
			out.println("ERROR is -->"+e);
		}
		finally
		{
			try
			{
			if (stmtty != null) stmtty.close();
			if (rst != null) rst.close();
			if (rs != null) rs.close();
			if (rs1 != null) rs1.close();
			if (rs2 != null) rs2.close();
			if (rs3 != null) rs3.close();
			if (rs4 != null) rs4.close();
			if (rs5 != null) rs5.close();
			if (rs6 != null) rs6.close();
			if (rs7 != null) rs7.close();
			if (rs8 != null) rs8.close();
			if (rs9 != null) rs9.close();
			if (rs10 != null) rs10.close();
			if (rspr != null) rspr.close();

			if (stmt != null) stmt.close();
			if (stmt1 != null) stmt1.close();
			if (stmt2 != null) stmt2.close();
			if (stmt3 != null) stmt3.close();
			if (stmt4 != null) stmt4.close();
			if (stmt5 != null) stmt5.close();
			if (stmt6 != null) stmt6.close();
			if (stmt7 != null) stmt7.close();
			if (stmt8 != null) stmt8.close();
			if (stmt9 != null) stmt9.close();
			if (stmt10 != null) stmt10.close();
			if (stmtpr != null) stmtpr.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		effstatus="E";
		bage="0";
		aliasname="";
		nationalidno="";
		credentialid1="";
		credentialid2="";
		credentialid3="";
		jobtitle="";
		str5.append("<select name='empl_status' id='empl_status' onChange='echeck1(this); 'tabindex='23'><option value=''>----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+"</select>");
		
		degree="";
		allfacilities="N";
		restelnum="";
		offtelnum="";
		offtelext="";
		pagernum="";
		faxnum="";
		mobilenum="";
		emailid="";
		str6.append("<select name='pref_contact_mode' id='pref_contact_mode' tabindex='34'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+"</select>");
		resaddln1="";
		resaddln2="";
		resaddln3="";
		resaddln4="";
		offaddln1="";
		offaddln2="";
		offaddln3="";
		offaddln4="";
		mailaddln1="";
		mailaddln2="";
		mailaddln3="";
		mailaddln4="";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
			checkBoxAttribute_EVC="";
			effstatus_EVC="D";	
			disable_checkbox="";
		//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) end //
				
		if(allfacilities.equals("N"))
				checkBoxAttribute1=" ";
		else
			checkBoxAttribute1="CHECKED";

		newPractitioner=true;
		//Below Modified by Suji Keerthi for PAS-OP-MOHE-CRF-0113/01-OP Code Setup-Clinic
		if(isSplCharNotAllowApplYN)
			{
			eventFunctionForCase="OnBlur='ChangeUpperCase(this);CheckSplCharsforIdValidation(this)'";		
			}
			else 
			{
		    eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";	
			}
	}
	else
	{
		// Commented by Krishnan on 28/08/2012 for ORA-600 Error
		//String sqlap="select count(1) as total from oa_appt where facility_id = '"+facilityid+"' and practitioner_id='"+practitionerid+"' AND trunc(appt_date) >= trunc(sysdate) and nvl(appt_status,1)!='A' ";
		//String sqlap="select count(1) count_total from oa_appt where facility_id = '"+facilityid+"' and practitioner_id='"+practitionerid+"' AND appt_date between to_date(to_char(sysdate, 'DD/MM/YYYY') || ' 00:00', 'DD/MM/YYYY HH24:MI') and sysdate+36524 and nvl(appt_status,1)!='A' ";
		
		//java.sql.Statement stmtap=conn.createStatement();
      		//ResultSet rsap=stmtap.executeQuery(sqlap);
			
		String sqlap="select count(1) count_total from oa_appt where facility_id = ? and practitioner_id=? AND appt_date between to_date(to_char(sysdate, 'DD/MM/YYYY') || ' 00:00', 'DD/MM/YYYY HH24:MI') and sysdate+36524 and nvl(appt_status,1)!='A' ";
			
		PreparedStatement pstmt   = conn.prepareStatement(sqlap);
		pstmt.setString	(	1,	facilityid		);
		pstmt.setString	(	2,	practitionerid		);
		ResultSet rsap		 = pstmt.executeQuery();
		if(rsap!=null)
		rsap.next();
		totApptCount = rsap.getInt("count_total");

        if(rsap != null) rsap.close();
      //  if(stmtap != null) stmtap.close();
        if(pstmt != null) pstmt.close();
				
		java.sql.Statement stmt10=null;
		java.sql.Statement stmt11=null;
		java.sql.Statement stmt12=null;
		java.sql.Statement stmt13=null;
		java.sql.Statement stmt14=null;
		java.sql.Statement stmt15=null;
		java.sql.Statement stmt16=null;
		java.sql.Statement stmt17=null;
		java.sql.Statement stmt18=null;
		java.sql.Statement stmt19=null;
		java.sql.Statement stmt20=null;
		java.sql.Statement stmt21=null;
		java.sql.Statement stmt22=null;
		java.sql.Statement stmt23=null;
		java.sql.Statement stmt24=null;
		java.sql.Statement stmt25=null;
		java.sql.Statement stmt26=null;
		java.sql.Statement stmt27=null;
		java.sql.Statement stmtp=null;
		java.sql.Statement stmtm=null;
		java.sql.Statement stmtc=null;
		java.sql.Statement stmtr=null;
		java.sql.Statement stmtrep=null;
		java.sql.Statement stmtrec=null;
		java.sql.Statement stmtofp=null;
		java.sql.Statement stmtofc=null;
		java.sql.Statement stmtmap=null;
		java.sql.Statement stmtmac=null;
		java.sql.Statement stmtpr=null;
		java.sql.Statement stmtpr1=null;
		java.sql.Statement stmtf=null;

		ResultSet rset=null;
      		ResultSet rset1=null;
		ResultSet rs10=null;
		ResultSet rs12=null;
		ResultSet rs13=null;
		ResultSet rs14=null;
		ResultSet rs15=null;
		ResultSet rs16=null;
		ResultSet rs17=null;
		ResultSet rs18=null;
		ResultSet rs19=null;
		ResultSet rs20=null;
		ResultSet rs21=null;
		ResultSet rs22=null;
		ResultSet rs23=null;
		ResultSet rs24=null;
		ResultSet rs25=null;
		ResultSet rs26=null;
		ResultSet rs27=null;
		ResultSet rsp=null;
		ResultSet rsm=null;
		ResultSet rsc=null;
		ResultSet rsr=null;
		ResultSet rsrep=null;
		ResultSet rsrec=null;
		ResultSet rsofp=null;
		ResultSet rsofc=null;
		ResultSet rsmap=null;
		ResultSet rsmac=null;
		ResultSet rspr=null;
		ResultSet rspr1=null;
		ResultSet rsf=null;
		try{
				stmtf=conn.createStatement();
					String sqlf="select count(*) count_total from sm_facility_param";
					rsf=stmtf.executeQuery(sqlf);
					if(rsf != null)
					{     
						while(rsf.next())
						{
							count=rsf.getInt("count_total");
						}	
					}	

				    }
					catch(Exception e) 
					{
						e.printStackTrace();
				    }
				     finally 
					{
					try
					{
				      if(stmtf != null) stmtf.close();
				      if(rsf != null) rsf.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
		      }


		try {

			stmt11 = conn.createStatement();
			if(function_id.equals("PRACTITIONER"))
			{     /*Below query modified for this CRF HSA-CRF-160*/
				sql11 ="select APC_NO,DEGREE_1, DEGREE_1_UNIV, DEGREE_1_YEAR, DEGREE_2, DEGREE_2_UNIV, DEGREE_2_YEAR, DEGREE_3, DEGREE_3_UNIV, DEGREE_3_YEAR, DEGREE_4, DEGREE_4_UNIV, DEGREE_4_YEAR,TRAINING_COND_BY_1, TRAINING_COND_BY_2, TRAINING_COND_BY_3, TRAINING_COND_BY_4, TRAINING_DTLS_1, TRAINING_DTLS_2, TRAINING_DTLS_3,TRAINING_DTLS_4,practitioner_id,practitioner_name,short_name,pract_type,gender,date_of_birth,place_of_birth,mar_status_code,alias_name,citizenship_code,national_id_num,credential_id1,credential_id2,credential_id3,POSITION_CODE,empl_status,employee_id,degree,primary_speciality_code,all_facilities_yn,reporting_facility_id,res_tel_num,pager_num,mobile_num,off_tel_num,off_tel_ext,fax_num,email_id,pref_contact_mode,res_add_ln1,res_add_ln2,res_add_ln3,res_add_ln4,res_add_postal_code,res_add_country_code,off_add_ln1,off_add_ln2,off_add_ln3,off_add_ln4,off_add_postal_code,off_add_country_code,mail_add_ln1,mail_add_ln2,mail_add_ln3,mail_add_ln4,mail_add_postal_code,mail_add_country_code,eff_date_from,eff_date_to,eff_status,Enable_virtual_cons,LONG_NAME,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,practitioner_long_id,fpp_pract_yn,PRACTITIONER_SIGN,supervisor_yn,PRACTITIONER_STAMP , EMPLOYEE_SERVICE_NO from am_practitioner where practitioner_id='"+practitionerid+"' ";//Modified by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184	
				// modified by mujafar for AAKH-CRF-0079.4 // added by manjunath for TH-KW-CRF-0161.1
			}
			else
			{
				if(function_id.equals("EXT_PRACT"))
				{    /*Below query modified for this CRF HSA-CRF-160*/
					sql11 ="select APC_NO,DEGREE_1, DEGREE_1_UNIV, DEGREE_1_YEAR, DEGREE_2, DEGREE_2_UNIV, DEGREE_2_YEAR, DEGREE_3, DEGREE_3_UNIV, DEGREE_3_YEAR, DEGREE_4, DEGREE_4_UNIV, DEGREE_4_YEAR,TRAINING_COND_BY_1, TRAINING_COND_BY_2, TRAINING_COND_BY_3, TRAINING_COND_BY_4, TRAINING_DTLS_1, TRAINING_DTLS_2, TRAINING_DTLS_3,TRAINING_DTLS_4,practitioner_id,practitioner_name,short_name,pract_type,gender,date_of_birth,place_of_birth,mar_status_code,alias_name,citizenship_code,national_id_num,credential_id1,credential_id2,credential_id3,POSITION_CODE,empl_status,employee_id,degree,primary_speciality_code,res_tel_num,pager_num,mobile_num,off_tel_num,off_tel_ext,fax_num,email_id,pref_contact_mode,res_add_ln1,res_add_ln2,res_add_ln3,res_add_ln4,res_add_postal_code,res_add_country_code,off_add_ln1,off_add_ln2,off_add_ln3,off_add_ln4,off_add_postal_code,off_add_country_code,mail_add_ln1,mail_add_ln2,mail_add_ln3,mail_add_ln4,mail_add_postal_code,mail_add_country_code,eff_date_from,eff_date_to,eff_status,Enable_virtual_cons,LONG_NAME,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,practitioner_long_id,fpp_pract_yn,PRACTITIONER_SIGN,supervisor_yn,PRACTITIONER_STAMP , EMPLOYEE_SERVICE_NO from am_ext_practitioner where practitioner_id='"+practitionerid+"' ";	//Modified by Thamizh selvi on 28th June 2018 against ML-MMOH-CRF-1184
					// modified by mujafar for AAKH-CRF-0079.4 // added by manjunath for TH-KW-CRF-0161.1
				}
			}
			rset=stmt11.executeQuery(sql11);
			rset.next();
			   	
				practitioner_sign = rset.getBinaryStream("practitioner_sign");
				if(practitioner_sign!=null)
				includevisibility = "";
				practitioner_stamp = rset.getBinaryStream("practitioner_stamp"); // added by manjunath for TH-KW-CRF-0161.1
				if(practitioner_stamp!=null)
				includevisibility1 = "";
               
				practitionerid=rset.getString("practitioner_id");
				practitionername=rset.getString("practitioner_name");
				shortname=rset.getString("short_name");
				sex=rset.getString("gender");
				employeeid=rset.getString("employee_id");
				if(employeeid == null) employeeid = "";
				apc_no = rset.getString("APC_NO");
				degree1 = rset.getString("DEGREE_1");
				if(apc_no == null) apc_no = "";
				if(degree1 == null) degree1 = "";
				degree2 = rset.getString("DEGREE_2");
				if(degree2 == null) degree2 = "";
				degree3 = rset.getString("DEGREE_3");
				if(degree3 == null) degree3 = "";
				degree4 = rset.getString("DEGREE_4");
				if(degree4 == null) degree4 = "";

				year1 = rset.getString("DEGREE_1_YEAR");
				if(year1 == null) year1 = "";
				year2 = rset.getString("DEGREE_2_YEAR");
				if(year2 == null) year2 = "";
				year3 = rset.getString("DEGREE_3_YEAR");
				if(year3 == null) year3 = "";
				year4 = rset.getString("DEGREE_4_YEAR");
				if(year4 == null) year4 = "";

				univ1 = rset.getString("DEGREE_1_UNIV");
				if(univ1 == null) univ1 = "";
				univ2 = rset.getString("DEGREE_2_UNIV");
				if(univ2 == null) univ2 = "";
				univ3 = rset.getString("DEGREE_3_UNIV");
				if(univ3 == null) univ3 = "";
				univ4 = rset.getString("DEGREE_4_UNIV");
				if(univ4 == null) univ4 = "";
				

				con1 = rset.getString("TRAINING_COND_BY_1");
				if(con1 == null) con1 = "";
				con2 = rset.getString("TRAINING_COND_BY_2");
				if(con2 == null) con2 = "";
				con3 = rset.getString("TRAINING_COND_BY_3");
				if(con3 == null) con3 = "";
				con4 = rset.getString("TRAINING_COND_BY_4");
				if(con4 == null) con4 = "";

				det1 = rset.getString("TRAINING_DTLS_1");
				if(det1 == null) det1 = "";
				det2 = rset.getString("TRAINING_DTLS_2");
				if(det2 == null) det2 = "";
				det3 = rset.getString("TRAINING_DTLS_3");
				if(det3 == null) det3 = "";
				det4 = rset.getString("TRAINING_DTLS_4");
				if(det4 == null) det4 = "";
				longname = rset.getString("LONG_NAME");
				if(longname == null) longname = "";
				/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
				fppPractYn = rset.getString("FPP_PRACT_YN");
				if(fppPractYn == null || fppPractYn.equals("null")) fppPractYn = "N";
				/*End*/

				/*Added by Dharma on 19th Aug 2020 against AAKH-CRF-0122.4 Start*/
				supervisor_yn = rset.getString("supervisor_yn");
				if(supervisor_yn == null || supervisor_yn.equals("null")) supervisor_yn = "N";
				/*End*/

				/*Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
				citizen_code = rset.getString("citizenship_code");
				if (citizen_code == null || citizen_code.equals("null")) citizen_code = "";
				/*End MOHE-CRF-0011*/
			
				/*Added by lakshmanan For MO-CRF-20183.2 start*/
				
				practEmployeeServiceNo=rset.getString("employee_service_no");
					if (practEmployeeServiceNo==null || practEmployeeServiceNo.equals("null")) practEmployeeServiceNo="";
				
				/*Added by lakshmanan For MO-CRF-20183.2 end*/
			
				if(function_id.equals("PRACTITIONER"))	{
					reporting_facility_id=rset.getString("reporting_facility_id");
				}
				mar_status_code=rset.getString("mar_status_code");
			if (sex.equals("M")) 
			{
				sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				str1.append("<select name='sex' id='sex' onClick='check2()' onChange='check2()' tabindex='8' onkeyDown='shift_tab()' >");
				str1.append("<option value='M' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+" </select>");
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' onkeyDown='shift_tab4();' value='"+sex1+"' readonly >";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
			else if (sex.equals("F")) 
			{
				sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				str1.append("<select name='sex' id='sex' onClick='check2()' onChange='check2()' tabindex='8' onkeyDown='shift_tab();' >");
				str1.append("<option value='M' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"&nbsp;<option value='F' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"<option value='U'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</select>");
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7' onkeyDown='shift_tab4();' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
			else if (sex.equals("U")) 
			{
				sex1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				str1.append("<select name='sex' id='sex' onClick='check2()' onChange='check2()' tabindex='8' onkeyDown='shift_tab();' >");
				str1.append("<option value='M' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"&nbsp;<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"<option value='U' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</select>");
				strs1="<input type='text' name='sex1' id='sex1' size='7' maxlength='7'onkeyDown='shift_tab4();' value='"+sex1+"' readonly>";
				strs2="<input type='hidden' name='sex2' id='sex2' size='15' maxlength='15' value='"+sex+"' >";
			}
				emplstatus=rset.getString("empl_status");
				

				if(emplstatus.equals("F")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels");
					str5.append("<select name='empl_status' id='empl_status' onClick='check3();' onChange='check3()' tabindex='23'>");
                    str5.append("<option value=>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5.append("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"&nbsp;<option value='F' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+" </select>");
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}
				else if (emplstatus.equals("P")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels");
					str5.append("<select name='empl_status' id='empl_status' onClick='check3();' onChange='check3()' tabindex='23'>");
					str5.append("<option value=>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5.append("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"&nbsp;<option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+" </select>");
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
					
				}
				else if (emplstatus.equals("V")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visitor.label","common_labels");
					str5.append("<select name='empl_status' id='empl_status' onClick='check3();echeck10()' onChange='check3(); echeck10();' tabindex='23'>");
					str5.append("<option value=>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5.append("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"&nbsp; <option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+"</select>");
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
				}
				else if(emplstatus.equals("S")) 
				{
					emplstatus1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels");
					str5.append("<select name='empl_status' id='empl_status' onClick='check3();' onChange='check3();' tabindex='23'>");
					str5.append("<option value=>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					stre2="<input type='hidden' name='empl_status2' id='empl_status2' size='15' maxlength='15' value='"+emplstatus+"'>";
					str5.append("<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+"&nbsp; <option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+"<option value='V' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.VisitingSpecialist.label","am_labels")+"</select>");
					stre1="<input type='text' name='empl_status1' id='empl_status1' size='15' maxlength='15' value='"+emplstatus1+"' readonly>";
				}
				prefmode=rset.getString("pref_contact_mode");
				if(prefmode != null) 
				{
					 if (prefmode.equals("R")) 
					 {	
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if (prefmode.equals("O")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
			str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("F")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("M")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("P")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals("E")) 
					{
						prefmode1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels");
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value=''>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
					else if(prefmode.equals(" ") || prefmode.equals("null")) 
					{
						prefmode1="-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----";
						str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value='' selected>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
						str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
						strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
						strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
					}
			     }
				 else
					{
					prefmode=" ";
					prefmode1=" ";
					str6.append("<select name='pref_contact_mode' id='pref_contact_mode' onClick='check4()' tabindex='34'><option value='' selected>-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
					str6.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+"<option value='M'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mobile.label","common_labels")+"<option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.office.label","common_labels")+"<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Pager.label","am_labels")+"<option value='R' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residence.label","common_labels")+" </select>");
					strp1="<input type='text' name='pref_contact_mode1' id='pref_contact_mode1' size='15' maxlength='15' value='"+prefmode1+"' readonly>";
					strp2="<input type='hidden' name='pref_contact_mode2' id='pref_contact_mode2' size='15' maxlength='15' value='"+prefmode+"' >";
			     }
			java.util.Date date2 = rset.getDate("date_of_birth");

			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			birthdate=formatter1.format(date2);
			birthdate_disp=DateUtils.convertDate(birthdate,"DMY","en",localeName);

			//date2 = null;
			formatter1 = null;
			stmt25=conn.createStatement();
			String sqldb="select calculate_age('"+birthdate+"',1) from dual";
			rs25=stmt25.executeQuery(sqldb);
			
			if(rs25 != null)
			{
				while(rs25.next())
				{
					bage=rs25.getString(1);
				}	
			}	
			if(bage==null) bage="0";
			stmt26=conn.createStatement();
			String sqldb1="select calculate_age('"+birthdate+"',2) from dual";
			rs26=stmt26.executeQuery(sqldb1);
			if(rs26 != null )
			{
				while(rs26.next())
				{
					bmonths=rs26.getString(1);
				}	
			}	
			if(bmonths==null) bmonths="0";
			stmt27=conn.createStatement();
			String sqldb2="select calculate_age('"+birthdate+"',3) from dual";
			rs27=stmt27.executeQuery(sqldb2);
			if(rs27 != null )
			{
				while(rs27.next())	
				{
					bdays=rs27.getString(1);
				}	
			}	
			if(bdays==null) bdays="0";
			birthplace=rset.getString("place_of_birth");
			if(birthplace == null) birthplace="";
			aliasname=rset.getString("alias_name");
			if(aliasname == null) aliasname="";
			nationalidno=rset.getString("national_id_num");

			if(nationalidno == null || nationalidno.equals("") || nationalidno.equals(" ")) nationalidno="";
			//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
			credentialid1=rset.getString("credential_id1");
			if(credentialid1==null) credentialid1="";
			
			credentialid2=rset.getString("credential_id2");
			if(credentialid2==null) credentialid2="";

			credentialid3=rset.getString("credential_id3");
			if(credentialid3==null) credentialid3="";
			//End of Addition on 24/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
			jobtitle=rset.getString("POSITION_CODE");
			if(jobtitle==null) jobtitle="";
			
			degree=rset.getString("degree");
			if(degree == null) degree="";
			
			restelnum=rset.getString("res_tel_num");
			if(restelnum==null) restelnum="";
			
			pagernum=rset.getString("pager_num");
			if(pagernum==null) pagernum="";
			
			mobilenum=rset.getString("mobile_num");
			if(mobilenum==null) mobilenum="";
			
			offtelnum=rset.getString("off_tel_num");
			if(offtelnum==null) offtelnum="";
			
			offtelext=rset.getString("off_tel_ext");
			if(offtelext==null) offtelext="";
			
			faxnum=rset.getString("fax_num");
			if(faxnum==null) faxnum="";
			
			emailid=rset.getString("email_id");
			if(emailid==null) emailid="";

			resaddln1=rset.getString("res_add_ln1");
			if(resaddln1==null) resaddln1="";

			resaddln2=rset.getString("res_add_ln2");
			if(resaddln2==null) resaddln2="";
			
			resaddln3=rset.getString("res_add_ln3");
			if(resaddln3==null) resaddln3="";
			
			resaddln4=rset.getString("res_add_ln4");
			if(resaddln4==null) resaddln4="";
			
			offaddln1=rset.getString("off_add_ln1");
			if(offaddln1==null) offaddln1="";
			
			offaddln2=rset.getString("off_add_ln2");
			if(offaddln2==null) offaddln2="";
			
			offaddln3=rset.getString("off_add_ln3");
			if(offaddln3==null) offaddln3="";
			
			offaddln4=rset.getString("off_add_ln4");
			if(offaddln4==null) offaddln4="";
			
			mailaddln1=rset.getString("mail_add_ln1");
			if(mailaddln1==null) mailaddln1="";
			
			mailaddln2=rset.getString("mail_add_ln2");
			if(mailaddln2==null) mailaddln2="";
			
			mailaddln3=rset.getString("mail_add_ln3");
			if(mailaddln3==null) mailaddln3="";
			
			mailaddln4=rset.getString("mail_add_ln4");
			if(mailaddln4==null) mailaddln4="";

         	effstatus=rset.getString("eff_status");
         	//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
         	effstatus_EVC=rset.getString("Enable_virtual_cons");
         	//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
			
			//Added for HSA-CRF-160
			other_alt_type_no=rset.getString("OTH_ALT_ID_TYPE")==null?"":rset.getString("OTH_ALT_ID_TYPE");
			other_alt_type_desc=rset.getString("OTH_ALT_ID_NO")==null?"":rset.getString("OTH_ALT_ID_NO");			
			
			//Added for this CRF ML-MMOH-CRF-0862
			cerner_prac_id=rset.getString("practitioner_long_id")==null?"":rset.getString("practitioner_long_id");
			

			if(effstatus.equals("D"))
			{
				otherTextAttribute="READONLY";
				disablerecord="disabled";
				checkBoxAttribute="";
			}
			else
			{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
 			}
			//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
         	if(effstatus_EVC.equals("D"))
			{
				checkBoxAttribute_EVC="";
				
			}
			else
			{
				checkBoxAttribute_EVC="CHECKED";
 			}
			
			
         	//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1) Started //
			if(jobtitle!="")
			{
			stmt10=conn.createStatement();
			
			String sql10="select POSITION_CODE,POSITION_DESC from am_position where POSITION_CODE='"+jobtitle+"'";
			
			rs10=stmt10.executeQuery(sql10);
              rs10.next();
            poscode=rs10.getString(1);
           	if(rs10!=null)rs10.close();
			if(stmt10!=null)stmt10.close();
			}
			stmt10=conn.createStatement();
			String sql10="select nat_id_length ,accept_national_id_no_yn,nat_id_prompt, nat_id_chk_len, nat_id_check_digit_id ,nat_data_source_id, nat_id_accept_alphanumeric_yn, alt_id1_type, alt_id1_length from mp_param";
			rs10=stmt10.executeQuery(sql10);

			if(rs10 != null)
			{		
				while(rs10.next())
				{
					str14=rs10.getString(1);
					accept_national_id_no_yn=rs10.getString(2);
					if(accept_national_id_no_yn == null) accept_national_id_no_yn="N";
					nat_id_accept_alphanumeric_yn=rs10.getString("nat_id_accept_alphanumeric_yn");
		  			if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn ="N";
					nat_id_prompt=rs10.getString(3);if(nat_id_prompt == null) nat_id_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
					nat_id_chk_len=rs10.getString(4);if(nat_id_chk_len == null) nat_id_chk_len="";
					nat_id_check_digit_id=rs10.getString(5);if(nat_id_check_digit_id == null) nat_id_check_digit_id="";
					nat_data_source_id=rs10.getString(6);if(nat_data_source_id == null) nat_data_source_id="";
					if(function_id.equals("PRACTITIONER"))
					{
					allfacilities=rset.getString("all_facilities_yn");
					}
					//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
					alt_id1_type = rs10.getString("alt_id1_type");if(alt_id1_type == null) alt_id1_type="";
					alt_id1_length = rs10.getString("alt_id1_length");if(alt_id1_length == null) alt_id1_length="";
				}	
			}	
			if(effstatus.equals("E") || effstatus.equals("D"))
			{
				if(allfacilities.equals("Y"))
					checkBoxAttribute1="CHECKED";
				else
					checkBoxAttribute1=" ";
			}
			respostalcode=rset.getString("res_add_postal_code");
			if(respostalcode==null || respostalcode.equals("null"))respostalcode="";

			strrep1="<input type='text' name='res_add_postal_code2' id='res_add_postal_code2' size='15' maxlength='15' value='"+respostalcode+"' readonly>";
			rescountrycode=rset.getString("res_add_country_code");
			if(rescountrycode != null)

			{
				stmtrec=conn.createStatement();
				String sqlrec="select short_name from mp_country where country_code='"+rescountrycode+"' ";
				rsrec=stmtrec.executeQuery(sqlrec);
				if(rsrec != null )
				{
					while(rsrec.next())
					{
						rescountrydesc=rsrec.getString("short_name");
					}	
				}	
			}
			else
			{
				rescountrydesc=" ";
			}

			stmt17=conn.createStatement();
			String sql17="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			rs17=stmt17.executeQuery(sql17);
			//str8="<select name='res_add_country_code' id='res_add_country_code' onClick='check9()'><option value=''>-----Select-----";
			if(rs17 !=null)
			{
			 while(rs17.next())
			 {
				//rescountrycode1=rs17.getString("country_code");
				//rescountrydesc1=rs17.getString("short_name");
				/*if((rescountrycode1.equals(rescountrycode)) && (rescountrydesc1.equals(rescountrydesc)))
				{
					str8+="<option value='"+rescountrycode1+"' selected>"+rescountrydesc1;
				}
				else 
				{
					str8+="<option value='"+rescountrycode1+"' >"+rescountrydesc1;
				}*/
			 }
			} 
			//str8+="</select>";
			
			strrec1="<input type='text' name='res_add_country_code1' id='res_add_country_code1' size='15' maxlength='15' value='"+rescountrydesc+"' readonly>";
			if(rescountrycode == null) 
			{
				strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(rescountrycode != null) 
			{
				if(effstatus.equals("E")) 
				{
					strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='"+rescountrycode+"' >";
				}
				else if(effstatus.equals("D")) 
				{
					strrec2="<input type='hidden' name='res_add_country_code2' id='res_add_country_code2' size='15' maxlength='15' value='"+rescountrycode+"' >";
				}
			}
			offpostalcode=rset.getString("off_add_postal_code");
			if(offpostalcode==null || offpostalcode.equals("null")) offpostalcode="";

			strofp1="<input type='text' name='off_add_postal_code2' id='off_add_postal_code2' size='15' maxlength='15' value='"+offpostalcode+"' readonly>";
			offcountrycode=rset.getString("off_add_country_code");
			if(offcountrycode != null)
			{
					stmtofc=conn.createStatement();
					String sqlofc="select short_name from mp_country where country_code='"+offcountrycode+"' ";
					rsofc=stmtofc.executeQuery(sqlofc);
					if(rsofc != null)
					{
						while(rsofc.next())
						{
							offcountrydesc=rsofc.getString("short_name");
						}	
					}	
			}
			else
			{
					offcountrydesc= " ";
			}
			stmt19=conn.createStatement();
			String sql19="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			rs19=stmt19.executeQuery(sql19);
			//str10="<select name='off_add_country_code' id='off_add_country_code' onClick='check11()'><option value=''>-----Select-----";
			if(rs19 != null )
			{
			 while(rs19.next())
			 {
				//offcountrycode1=rs19.getString("country_code");
				//offcountrydesc1=rs19.getString("short_name");
				/*if((offcountrycode1.equals(offcountrycode)) && (offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
					str10+="<option value='"+offcountrycode1+"' selected>"+offcountrydesc1;
				}
				else if((!offcountrycode1.equals(offcountrycode)) && (!offcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
				{
					str10+="<option value='"+offcountrycode1+"' >"+offcountrydesc1;
				}
				else if((offcountrycode == null) && (offcountrydesc.equals(" ")))
				{
					str10+="<option value='"+offcountrycode1+"' >"+offcountrydesc1;
				}*/

			 }
			}
			//str10+="</select>";
			strofc1="<input type='text' name='off_add_country_code1' id='off_add_country_code1' size='15' maxlength='15' value='"+offcountrydesc+"' readonly>";
			if(offcountrycode == null)
			{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(offcountrycode != null)
			{
				if(effstatus.equals("E"))
				{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='"+offcountrycode+"' >";
				}
				else if(effstatus.equals("D"))
				{
				strofc2="<input type='hidden' name='off_add_country_code2' id='off_add_country_code2' size='15' maxlength='15' value='"+offcountrycode+"' >";
				}
			}

			mailpostalcode=rset.getString("mail_add_postal_code");
			if(mailpostalcode==null || mailpostalcode.equals("null")) mailpostalcode="";
			
			
			strmap1="<input type='text' name='mail_add_postal_code2' id='mail_add_postal_code2' size='15' maxlength='15' value='"+mailpostalcode+"' readonly>";
			
			mailcountrycode=rset.getString("mail_add_country_code");
			if(mailcountrycode != null)
			{
			stmtmac=conn.createStatement();
			String sqlmac="select short_name from mp_country where country_code='"+mailcountrycode+"' ";
			rsmac=stmtmac.executeQuery(sqlmac);
			  if(rsmac != null)
			  {
			   while(rsmac.next())
			  	{
			 		mailcountrydesc =rsmac.getString("short_name");
			 	}	
			  }	
			}
			else
			{
				mailcountrydesc=" ";
			}
			stmt21=conn.createStatement();
			String sql21="select country_code,short_name from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')))order by short_name";
			rs21=stmt21.executeQuery(sql21);
			//str12="<select name='mail_add_country_code' id='mail_add_country_code' onClick='check13()'><option value=''>-----Select-----";
			if(rs21 != null )
			{
			 while(rs21.next())
			 {
					//mailcountrycode1=rs21.getString("country_code");
					//mailcountrydesc1=rs21.getString("short_name");
					/*if((mailcountrycode1.equals(mailcountrycode)) && (mailcountrydesc1.equals(mailcountrydesc)) && (mailcountrycode != null) && (!mailcountrydesc.equals(" ")))
					{
						str12+="<option value='"+mailcountrycode1+"' selected>"+mailcountrydesc1;
					}
					else if((!mailcountrycode1.equals(mailcountrycode)) && (!mailcountrydesc1.equals(offcountrydesc)) && (offcountrycode != null) && (!offcountrydesc.equals(" ")))
					{
						str12+="<option value='"+mailcountrycode1+"' >"+mailcountrydesc1;
					}
					else if((mailcountrycode == null) && (mailcountrydesc.equals(" ")))
					{
						str12+="<option value='"+mailcountrycode1+"' >"+mailcountrydesc1;
					}*/
			 }
			} 
			//str12+="</select>";
			strmac1="<input type='text' name='mail_add_country_code1' id='mail_add_country_code1' size='15' maxlength='15' value='"+mailcountrydesc+"' readonly onBlur='document.getElementById('residencetelno').focus()'>";
			if(mailcountrycode == null)
			{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='' >";
			}
			else if(mailcountrycode != null)
			{
				if(effstatus.equals("E"))
				{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='"+mailcountrycode+"' >";
				}
				else if(effstatus.equals("D"))
				{
				strmac2="<input type='hidden' name='mail_add_country_code2' id='mail_add_country_code2' size='15' maxlength='15' value='"+mailcountrycode+"' >";
				}
			}
			
			practtype=rset.getString("pract_type");
			stmtp=conn.createStatement();
			String sqlp="select Desc_Userdef from am_pract_type where pract_type='"+practtype+"' ";
			rsp=stmtp.executeQuery(sqlp);
			
			if(rsp != null )
			{
				while(rsp.next())
				{
					practtypedesc=rsp.getString("Desc_Userdef");
				}	
			}	
			stmt12=conn.createStatement();
			String sql12 = "select pract_type,Desc_Userdef from am_pract_type where eff_status='E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by Desc_Userdef";
			rs12=stmt12.executeQuery(sql12);
			strt.append("<select name='pract_type' id='pract_type' tabindex='1' onChange='populateValues();enaDisSupervisorChkbox(this.value);validateEnablevirtualConst(this.value);' onClick='checkpract();check1();' >");			
			if(rs12 != null)
			{
			while (rs12.next())
			{
				practtype1=rs12.getString("pract_type");
				practtypedesc1=rs12.getString("Desc_Userdef");
				if((practtype1.equals(practtype)) && (practtypedesc1.equals(practtypedesc)))
				{
					strt.append("<option value='"+practtype1+"' selected>"+practtypedesc1);
					
					if(effstatus.equals("E"))
					{

						strt2="<input type='hidden' name='pract_type3' id='pract_type3' size='15' maxlength='15' value='"+practtype+"'>";
					}
				}
				else if((!practtype1.equals(practtype)) && (!practtypedesc1.equals(practtypedesc)))
				{
					strt.append("<option value='"+practtype1+"'>"+practtypedesc1);
					if(effstatus.equals("E"))
					{
						strt2="<input type='hidden' name='pract_type3' id='pract_type3' size='15' maxlength='15' value='"+practtype+"'>";
					}
					
				}
			 }
		    }
			strt.append("<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----");
			strt.append("</select>");
			
			strt1="<input type='text' name='pract_type2' id='pract_type2' size='15' maxlength='15' tabindex='1' value='"+practtypedesc+"' readonly>";
 			if(effstatus.equals("D"))
 			{
 				strt2="<input type='hidden' name='pract_type3' id='pract_type3' size='15' maxlength='15' value='"+practtype+"'>";
 			}
 			
			citizen=rset.getString("citizenship_code");
			if (citizen == null || citizen.equals("null")) citizen="";
			if(!citizen.equals(""))
 			{
 				stmtc=conn.createStatement();
 				String sqlc="select long_desc from mp_country where country_code='"+citizen+"' ";
 				rsc=stmtc.executeQuery(sqlc);
 				if(rsc != null )
 				{
 					while(rsc.next())
 					{
 						citizendesc = rsc.getString("long_desc");
						if(citizendesc==null)citizendesc="";
 					}	
 				}if(rsc != null) rsc.close();
				if(stmtc != null) stmtc.close();	
 			}
 			else
 			{
 				citizendesc="";
 			}
			if(!citizen.equals("")) cnc = citizen;
			if(!citizendesc.equals("")) cncdesc = citizendesc;
			
 			stmt14=conn.createStatement();
 			String sql14="select country_code,long_desc from mp_country where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) and long_desc is not null order by long_desc";
 			rs14=stmt14.executeQuery(sql14);
 			//str3="<select name='citizen' id='citizen' onClick='check6()'><option value=''>-----Select-----";
 			if(rs14 != null)
 			{
 			while (rs14.next())
 			{
 				citizen1=rs14.getString("country_code");
 				if(citizen1 == null) citizen1="";
 				citizendesc1=rs14.getString("long_desc");
 				if (citizendesc1==null)citizendesc1="";
 				/*if((citizen1.equals(citizen)) && (citizendesc1.equals(citizendesc)) && (citizen != null) && (!citizendesc.equals(" ")))
 				{
					str3+="<option value='"+citizen1+"' selected>"+citizendesc1;
 				}
 				else if((!citizen1.equals(citizen)) && (!citizendesc1.equals(citizendesc)) && (citizen != null) && (!citizendesc.equals(" ")))
 				{
					str3+="<option value='"+citizen1+"'>"+citizendesc1;
 				}
 				else if((citizen == null) && (citizendesc.equals("")))
 				{
					str3+="<option value='"+citizen1+"'>"+citizendesc1;
 				}*/
 			 }
 			}
			//str3+="</select>";
 			strc1="<input type='text' name='citizen1' id='citizen1' size='15' maxlength='15' value='"+citizendesc+"' readonly>";
 			if(citizen==null)
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value=''>";
 			}
 			else if(citizen != null)
 			{

 			if(effstatus.equals("E"))
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value='"+citizen+"'>";
 			}
 			else if(effstatus.equals("D"))
 			{
 			strc2="<input type='hidden' name='citizen2' id='citizen2' size='15' maxlength='15' value='"+citizen+"'>";
 			}

 			}
 			prspcode=rset.getString("primary_speciality_code");
 			stmtpr1=conn.createStatement();
			String sqlpr1="select speciality_code,short_desc,multi_speciality_yn from am_speciality where speciality_code='"+prspcode+"' ";
			rspr1=stmtpr1.executeQuery(sqlpr1);
			if(rspr1 != null)
			{
			 while(rspr1.next())
			 {
 				prspdesc = rspr1.getString("short_desc");
 				multi_speciality_yn = rspr1.getString("multi_speciality_yn")==null?"N":rspr1.getString("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
			 }
			} 
			//Added for the CRF - Bru-HIMS-CRF-0198 - start
			if(multi_speciality_yn.equals("Y")){
				multi_Spec_disabled="disabled";
			}
			//Added for the CRF - Bru-HIMS-CRF-0198 - End

			stmtpr=conn.createStatement();
			String sqlpr="select speciality_code,short_desc from am_speciality where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc ";

			rspr=stmtpr.executeQuery(sqlpr);
			str15.append("<select name='primary_speciality_code' id='primary_speciality_code' onClick='check14()' onChange='check14()' "+multi_Spec_disabled +" tabindex='7'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------");//modified for the CRF - Bru-HIMS-CRF - 0198
						
			if(rspr != null)
			{
			 while(rspr.next())	
			 {
				prspcode1=rspr.getString("speciality_code");
				prspdesc1=rspr.getString("short_desc");
				if( prspcode1.equals(prspcode)&&
					prspdesc1.equals(prspdesc)){
				str15.append("<option value='"+prspcode1+"'selected >"+prspdesc1);
				} else
				str15.append("<option value='"+prspcode1+"' >"+prspdesc1);
			    
			 }
			} 
			str15.append("</select>");
			strpr1="<input type='text' name='primary_speciality_code1' id='primary_speciality_code1' value='"+prspdesc+"' readonly tabindex='7'>";
			strpr2="<input type='hidden' name='primary_speciality_code2' id='primary_speciality_code2' size='15' maxlength='15' value='"+prspcode+"'>";

			java.sql.Statement stmt_res=null;
			ResultSet rs_res=null;
			stmt_res=conn.createStatement();
			if(respostalcode !=null)
			{
			String sql_res="select short_desc from mp_postal_code where postal_code='"+respostalcode+"' ";
			
			rs_res=stmt_res.executeQuery(sql_res);
			if(rs_res != null && rs_res.next() )
				{
					respostaldesc=rs_res.getString("short_desc");
				}
				if(rs_res!=null)rs_res.close();
				if(stmt_res!=null)stmt_res.close();
			}
			if(offpostalcode !=null)
			{
				stmt_res =conn.createStatement();
				String sql_res="select short_desc from mp_postal_code where postal_code='"+offpostalcode+"' ";
			
				rs_res=stmt_res.executeQuery(sql_res);
				if(rs_res != null && rs_res.next() )
				{
					offpostaldesc=rs_res.getString("short_desc");
				}
				if(rs_res!=null)rs_res.close();
				if(stmt_res!=null)stmt_res.close();
			}
			if(mailpostalcode !=null)
			{
				stmt_res =conn.createStatement();
				String sql_res="select short_desc from mp_postal_code where postal_code='"+mailpostalcode+"' ";
			
				rs_res=stmt_res.executeQuery(sql_res);
				if(rs_res != null && rs_res.next() )
				{
					mailpostaldesc=rs_res.getString("short_desc");
				}
				if(rs_res!=null)rs_res.close();
				if(stmt_res!=null)stmt_res.close();
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
				{
			if(stmt10 != null) stmt10.close();
			if(stmt11 != null) stmt11.close();
			if(stmt12 != null) stmt12.close();
			if(stmt13 != null) stmt13.close();
			if(stmt14 != null) stmt14.close();
			if(stmt15 != null) stmt15.close();
			if(stmt16 != null) stmt16.close();
			if(stmt17 != null) stmt17.close();
			if(stmt18 != null) stmt18.close();
			if(stmt19 != null) stmt19.close();
			if(stmt20 != null) stmt20.close();
			if(stmt21 != null) stmt21.close();
			if(stmt22 != null) stmt22.close();
			if(stmt23 != null) stmt23.close();
			if(stmt24 != null) stmt24.close();
			if(stmt25 != null) stmt25.close();
			if(stmt26 != null) stmt26.close();
			if(stmt27 != null) stmt27.close();
			if(stmtp != null) stmtp.close();
			if(stmtm != null) stmtm.close();
			if(stmtr != null) stmtr.close();
			if(stmtrep != null) stmtrep.close();
			if(stmtrec != null) stmtrec.close();
			if(stmtofp != null) stmtofp.close();
			if(stmtofc != null) stmtofc.close();
			if(stmtmap != null) stmtmap.close();
			if(stmtmac != null) stmtmac.close();
			if(stmtpr != null) stmtpr.close();
			if(stmtpr1 != null) stmtpr1.close();

			if(rset != null) rset.close();
			if(rs10 != null) rs10.close();
			if(rs12 != null) rs12.close();
			if(rs13 != null) rs13.close();
			if(rs14 != null) rs14.close();
			if(rs15 != null) rs15.close();
			if(rs16 != null) rs16.close();
			if(rs17 != null) rs17.close();
			if(rs18 != null) rs18.close();
			if(rs19 != null) rs19.close();
			if(rs20 != null) rs20.close();
			if(rs21 != null) rs21.close();
			if(rs22 != null) rs22.close();
			if(rs23 != null) rs23.close();
			if(rs24 != null) rs24.close();
			if(rs25 != null) rs25.close();
			if(rs26 != null) rs26.close();
			if(rs27 != null) rs27.close();

			if(rsp != null) rsp.close();
			if(rsm != null) rsm.close();
			if(rsc != null) rsc.close();
			if(rsr != null) rsr.close();
			if(rsrep != null) rsrep.close();
			if(rsrec != null) rsrec.close();
			if(rsofp != null) rsofp.close();
			if(rsofc != null) rsofc.close();
			if(rsmap != null) rsmap.close();
			if(rsmac != null) rsmac.close();
			if(rspr != null) rspr.close();
			if(rspr1 != null) rspr1.close();
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			codeTextAttribute="READONLY";
			disableextn="disabled";

			newPractitioner=false;
 			eventFunctionForCase="";
	}		
		if(!(practitionerid.equals(""))){
		
            _bw.write(_wl_block9Bytes, _wl_block9);
}else
			{
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
		if(fcall.equals("nocall")){
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
	
		if(effstatus.equals("E")) 
	{
	

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strt));
            out.print( String.valueOf(strt2));
            _bw.write(_wl_block14Bytes, _wl_block14);
	}
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strt1));
            out.print( String.valueOf(strt2));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
if(isCernerpractitioner){

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
if(isCernerpractitioner){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cerner_prac_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
if(isCernerpractitioner){

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block23Bytes, _wl_block23);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(codeTextAttribute));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(eventFunctionForCase));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disableextn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(chkvalue1));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(practitionername));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(shortdescMaxSize));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(shortdescMaxLength));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(shortname));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block42Bytes, _wl_block42);
if(!(longname.equals("")))
{
int len = longname.length();
int i1=0;
int n_incre = 0;
int max = 0;

if (len > 75) 
{ 
    for ( i1=0; i1 <= (len/75);i1++) 
	{   
		if((i1+1)*75 < len)
			max = (i1+1)*75;
		 else
		  max = len;
		
		longname1=longname1+""+longname.substring((i1*75),max);
		n_incre = 1;
    }}
else  {
	longname1=longname;
 }} 
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
 if(isFPPPractApplicable || isCoderDiagAppl){ 
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
if(isSplCharNotAllowApplYN){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(longname1));
            _bw.write(_wl_block51Bytes, _wl_block51);
 if(isFPPPractApplicable){ 
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
if(fppPractYn.equals("Y")){
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(fppPractYn));
            _bw.write(_wl_block57Bytes, _wl_block57);
 } 
            _bw.write(_wl_block58Bytes, _wl_block58);
 if(isCoderDiagAppl){ 
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
if(!practtype.equals("MA")){
            _bw.write(_wl_block61Bytes, _wl_block61);
}
if(supervisor_yn.equals("Y")){
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
 } 
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
if(effstatus.equals("E")) {
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(str15));
            out.print( String.valueOf(strpr2));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
		else if(effstatus.equals("D")) {
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(strpr1));
            out.print( String.valueOf(strpr2));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(totApptCount));
            _bw.write(_wl_block70Bytes, _wl_block70);

if(isVIRTUAL_CONSULTATION)
{
	if(practtype.equals("MD")) // Only for Physician
	{
		disable_checkbox="";
	}
	else
	{
		disable_checkbox="display:none;";
	}

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(disable_checkbox ));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(effstatus_EVC));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checkBoxAttribute_EVC));
            _bw.write(_wl_block74Bytes, _wl_block74);

}else
{
	
            _bw.write(_wl_block75Bytes, _wl_block75);

}

            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
if(effstatus.equals("E")) {
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(str1));
            out.print( String.valueOf(strs2));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strs1));
            out.print( String.valueOf(strs2));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

		if(effstatus.equals("D")) {
		
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(bage));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(bmonths));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(bdays));
            _bw.write(_wl_block87Bytes, _wl_block87);

		}else{
		
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(bage));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bmonths));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bdays));
            _bw.write(_wl_block90Bytes, _wl_block90);

		}
		
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(birthdate));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disablerecord));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(birthdate));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(birthdate_disp));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disablerecord));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(disablerecord));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(birthplace));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

	stmt=conn.createStatement();
	String sql="select mar_status_code,short_desc from mp_marital_status where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc ";
	rs=stmt.executeQuery(sql);
	String maritalstatusSelected="";
	while(rs.next()){
		maritalstatus=rs.getString("mar_status_code")==null?"":rs.getString("mar_status_code");
		maritaldesc=rs.getString("short_desc")==null?"":rs.getString("short_desc");	 
		 if(maritalstatus.equals(mar_status_code)){
			maritalstatusSelected="selected";
		}else{
			maritalstatusSelected="";
		}		
	 
	 
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(maritalstatus));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(maritalstatusSelected));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(maritaldesc));
            _bw.write(_wl_block106Bytes, _wl_block106);
}
            _bw.write(_wl_block107Bytes, _wl_block107);
if(isResidencyApplYN){
	
	if(natid_mand_yn.equals("Y"))
	{
		nat_visibility = "visible";
	}else
	{
		nat_visibility = "hidden";
	}

	if(!citizen_code.equals(""))
	{
		if(citizen_nat_code.equals(citizen_code))
		{
			citizenChk = "Checked";
			natIdDis = "";
			if(!other_alt_type_no.equals(""))
			{
				other_alt_no_dis = "";
			}else
			{
				other_alt_no_dis = "disabled";
			}
			if(natid_mand_yn.equals("Y"))
			{
				nat_visibility = "visible";
			}
		}else
		{
			nonCitizenChk = "Checked";
			natIdDis = "disabled";
			nationalidno = "";
			nat_visibility = "hidden";
			if(alt_id1_type.equals(oth_alt_val))
			{
				oth_alt_length = alt_id1_length;
			}else
			{
				oth_alt_length = "20";
			}
			if(!oth_alt_val.equals(""))
			{
				if(oth_alt_val.equals(other_alt_type_no))
				{
					other_alt_type_no = oth_alt_val;
					other_alt_type_dis = "disabled";
					other_alt_no_dis = "";
					oth_alt_visibility = "visible";
				}else
				{
					other_alt_type_no = oth_alt_val;
					other_alt_type_dis = "disabled";
					other_alt_type_desc = "";
					other_alt_no_dis = "";
					oth_alt_visibility = "visible";
				}
			}else
			{
				other_alt_type_no = "";
				other_alt_type_dis = "disabled";
				other_alt_type_desc = "";
				other_alt_no_dis = "disabled";
			}
		}
	}
	
	if(effstatus.equals("D"))
	{
		other_alt_type_dis = "disabled";
		other_alt_no_dis = "disabled";
	}

            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
if(effstatus.equals("E")){
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(citizenChk));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(citizen_nat_desc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(citizen_nat_code));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(nonCitizenChk));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(cncdesc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(cnc));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
}else if(effstatus.equals("D")){
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(citizenChk));
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(nonCitizenChk));
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
}
            _bw.write(_wl_block117Bytes, _wl_block117);
}
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(aliasname));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
 if(effstatus.equals("E")) 
	{ 
		
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(cncdesc));
            _bw.write(_wl_block123Bytes, _wl_block123);
if(isResidencyApplYN){
            _bw.write(_wl_block124Bytes, _wl_block124);
}
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(cnc));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(strc2));
            _bw.write(_wl_block127Bytes, _wl_block127);
if(isResidencyApplYN){
            _bw.write(_wl_block128Bytes, _wl_block128);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strc1));
            out.print( String.valueOf(strc2));
            _bw.write(_wl_block129Bytes, _wl_block129);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
if(accept_national_id_no_yn.equals("Y")){
		
			String nat_id_onKeyPress="";

					/*
					if ( nat_id_check_digit_id.equals("M11") )
						nat_id_onKeyPress = "return CheckForCharsNatID(event);";
					else
						nat_id_onKeyPress = "return  allowValidNumber(this,event,'"+str14+"',0);";
					*/

					if(nat_id_accept_alphanumeric_yn.equals("Y"))
					{
						nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
					}
					else
					{
						if(nat_id_check_digit_id.equals("M11"))
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "allowValidNumber(this,event,'"+str14+"', 0);";
					}
		
		
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(str14));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(natIdDis));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(nat_id_check_digit_id));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(nationalidno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(nat_id_onKeyPress));
            _bw.write(_wl_block138Bytes, _wl_block138);
if(isResidencyApplYN && effstatus.equals("E")){
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(nat_visibility));
            _bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(nationalidno));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(other_alt_type_dis));
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

	 String alt_no="select alt_id_type, long_desc from mp_alternate_id_type where eff_Status='E' order by alt_id_type";
	 other_altstat=conn.createStatement();
	 other_altrs=other_altstat.executeQuery(alt_no);
	 while(other_altrs.next()){
	 alt_type_code=other_altrs.getString("alt_id_type")==null?"":other_altrs.getString("alt_id_type");
	 alt_type_desc=other_altrs.getString("long_desc")==null?"":other_altrs.getString("long_desc");
	 if(alt_type_code.equals(other_alt_type_no)){
	  other_alt_select="selected";
	 }else{
	    other_alt_select="";
      }		
	 
	 
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(alt_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(other_alt_select));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(alt_type_desc));
            _bw.write(_wl_block146Bytes, _wl_block146);
}
            _bw.write(_wl_block147Bytes, _wl_block147);
if(isResidencyApplYN && effstatus.equals("E")){
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(oth_alt_val));
            _bw.write(_wl_block149Bytes, _wl_block149);
}
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(oth_alt_length));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(other_alt_type_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(other_alt_no_dis));
            _bw.write(_wl_block152Bytes, _wl_block152);
if(isResidencyApplYN && effstatus.equals("E")){
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(oth_alt_visibility));
            _bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(credentialid1));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(credentialid2));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block159Bytes, _wl_block159);
} else {
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(credentialid1));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(other_alt_type_dis));
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

	 String alt_no="select alt_id_type, long_desc from mp_alternate_id_type where eff_Status='E' order by alt_id_type";
	 other_altstat=conn.createStatement();
	 other_altrs=other_altstat.executeQuery(alt_no);
	 while(other_altrs.next()){
	 alt_type_code=other_altrs.getString("alt_id_type")==null?"":other_altrs.getString("alt_id_type");
	 alt_type_desc=other_altrs.getString("long_desc")==null?"":other_altrs.getString("long_desc");
	 	 if(alt_type_code.equals(other_alt_type_no)){
             other_alt_select="selected";
	     }else{
	         other_alt_select="";
		 }	 
	 
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(alt_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(other_alt_select));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(alt_type_desc));
            _bw.write(_wl_block146Bytes, _wl_block146);
}
            _bw.write(_wl_block147Bytes, _wl_block147);
if(isResidencyApplYN && effstatus.equals("E")){
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(oth_alt_val));
            _bw.write(_wl_block149Bytes, _wl_block149);
}
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(oth_alt_length));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(other_alt_type_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(other_alt_no_dis));
            _bw.write(_wl_block152Bytes, _wl_block152);
if(isResidencyApplYN && effstatus.equals("E")){
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(oth_alt_visibility));
            _bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(credentialid2));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(credentialid3));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block169Bytes, _wl_block169);
 } 
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
if(accept_national_id_no_yn.equals("Y")){

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
}
            _bw.write(_wl_block174Bytes, _wl_block174);
if(accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(credentialid3));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block176Bytes, _wl_block176);
}
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);
if(effstatus.equals("E")) {
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(str5));
            out.print( String.valueOf(stre2));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
		else if(effstatus.equals("D")) {
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(stre1));
            out.print( String.valueOf(stre2));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(degree));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block181Bytes, _wl_block181);

      if(!function_id.equals("EXT_PRACT")) {
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
if(count > 1){
if(effstatus.equals("E")) {
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block187Bytes, _wl_block187);
 }
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block191Bytes, _wl_block191);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	else {
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(allfacilities));
            _bw.write(_wl_block187Bytes, _wl_block187);
}
            _bw.write(_wl_block193Bytes, _wl_block193);
if(isMMCLblchngesAppl){
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{ 
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
} 
            _bw.write(_wl_block195Bytes, _wl_block195);

			if(practitionerid.equals("")){
		
            _bw.write(_wl_block196Bytes, _wl_block196);

		}
		else{
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(apc_no));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block198Bytes, _wl_block198);
}
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

	stmt2=conn.createStatement();
	String sql2="select facility_id,facility_name from sm_facility_param where facility_type='F' and STATUS ='E' order by facility_name ";
	String repfacilitySelected="";	
	rs2=stmt2.executeQuery(sql2);
	
	 while(rs2.next()){
		repfacility=rs2.getString("facility_id")==null?"":rs2.getString("facility_id");				
		repfacilityname=rs2.getString("facility_name")==null?"":rs2.getString("facility_name");
	 
	 if(repfacility.equals(reporting_facility_id)){
	  repfacilitySelected="selected";
	 }else{
	    repfacilitySelected="";
      }		
	 
	 
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(repfacility));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(repfacilitySelected));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(repfacilityname));
            _bw.write(_wl_block106Bytes, _wl_block106);
}
            _bw.write(_wl_block201Bytes, _wl_block201);
}
            _bw.write(_wl_block202Bytes, _wl_block202);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(includevisibility));
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block206Bytes, _wl_block206);

if(practEmployeeServiceNo=="" && otherTextAttribute.equals("READONLY")){
otherTextAttributeEmpSrvNo="";
} else {
	otherTextAttributeEmpSrvNo=otherTextAttribute;
}

            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(practEmployeeServiceNo));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(otherTextAttributeEmpSrvNo));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(practEmployeeServiceNo));
            _bw.write(_wl_block211Bytes, _wl_block211);
if(isPractEmployeeServiceNumber==true){
            _bw.write(_wl_block212Bytes, _wl_block212);
}
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(includevisibility1));
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block216Bytes, _wl_block216);

	boolean isSiteSpecific=eOP.QMSInterface.isSiteSpecific(conn,"AM","AM_PRACT_EMP");
	if(isSiteSpecific){
	
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(employeeid));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(employeeid));
            _bw.write(_wl_block220Bytes, _wl_block220);
}
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(restelnum));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(offtelnum));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block226Bytes, _wl_block226);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(offtelext));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block228Bytes, _wl_block228);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(faxnum));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(mobilenum));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(pagernum));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(emailid));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block236Bytes, _wl_block236);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block237Bytes, _wl_block237);
if (effstatus.equals("E")) {
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(str6));
            out.print( String.valueOf(strp2));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strp1));
            out.print( String.valueOf(strp2));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block239Bytes, _wl_block239);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(resaddln1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(offaddln1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(mailaddln1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(resaddln2));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(offaddln2));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(mailaddln2));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(resaddln3));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(offaddln3));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(mailaddln3));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(resaddln4));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(offaddln4));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(mailaddln4));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block257Bytes, _wl_block257);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block258Bytes, _wl_block258);
		
				
				if(effstatus.equals("E")) {
		
            _bw.write(_wl_block259Bytes, _wl_block259);
		
			
	
		if(fcall.equals("call"))
	{
	if(newPractitioner)
	{ 
            _bw.write(_wl_block260Bytes, _wl_block260);
 
        }
        else								
        { 
        if(respostalcode != null) {
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(respostalcode));
            _bw.write(_wl_block262Bytes, _wl_block262);
}else{
            _bw.write(_wl_block263Bytes, _wl_block263);
}
	}
	}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strrep2));
            _bw.write(_wl_block264Bytes, _wl_block264);
    	if(fcall.equals("call"))
	        {
	        if(newPractitioner)
	        {
            _bw.write(_wl_block265Bytes, _wl_block265);
		
	        }
	        else
	        {
				if(offpostalcode != null) {
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(offpostalcode));
            _bw.write(_wl_block267Bytes, _wl_block267);
}else{
            _bw.write(_wl_block268Bytes, _wl_block268);
}
		}
	}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strofp2));
            _bw.write(_wl_block269Bytes, _wl_block269);
  if(fcall.equals("call"))
		{
		if(newPractitioner)
		{
            _bw.write(_wl_block270Bytes, _wl_block270);
		
		}else{
		if(mailpostalcode != null) {
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(mailpostalcode));
            _bw.write(_wl_block272Bytes, _wl_block272);
}else{
            _bw.write(_wl_block273Bytes, _wl_block273);
}
		}
	}			
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strmap2));
            _bw.write(_wl_block274Bytes, _wl_block274);
 }
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(strrep1));
            out.print( String.valueOf(strrep2));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(strofp1));
            out.print( String.valueOf(strofp2));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(strmap1));
            out.print( String.valueOf(strmap2));
            _bw.write(_wl_block274Bytes, _wl_block274);
 }
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(respostalcode));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(offpostalcode));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(mailpostalcode));
            _bw.write(_wl_block280Bytes, _wl_block280);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block258Bytes, _wl_block258);
if(effstatus.equals("E")) {
            _bw.write(_wl_block281Bytes, _wl_block281);
 if(fcall.equals("call"))
	{
	if(newPractitioner)
	{ 
            _bw.write(_wl_block282Bytes, _wl_block282);
 
        }
        else								
        { 
        if(rescountrycode != null) {
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(rescountrydesc));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(rescountrycode));
            _bw.write(_wl_block285Bytes, _wl_block285);
}else{
            _bw.write(_wl_block286Bytes, _wl_block286);
}
	}
	}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strrec2));
            _bw.write(_wl_block264Bytes, _wl_block264);
    	if(fcall.equals("call"))
	        {
	        if(newPractitioner)
	        {
            _bw.write(_wl_block287Bytes, _wl_block287);
		
	        }
	        else
	        {
				if(offcountrycode != null) {
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(offcountrydesc));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(offcountrycode));
            _bw.write(_wl_block290Bytes, _wl_block290);
}else{
            _bw.write(_wl_block291Bytes, _wl_block291);
}
		}
	}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strofc2));
            _bw.write(_wl_block292Bytes, _wl_block292);
  if(fcall.equals("call"))
		{
		if(newPractitioner)
		{
            _bw.write(_wl_block293Bytes, _wl_block293);
		
		}else{
		if(mailcountrycode != null) {
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(mailcountrydesc));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(mailcountrycode));
            _bw.write(_wl_block290Bytes, _wl_block290);
}else{
            _bw.write(_wl_block296Bytes, _wl_block296);
}
		}
	}			
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strmac2));
            _bw.write(_wl_block297Bytes, _wl_block297);
 }
	else if(effstatus.equals("D")) {
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(strrec1));
            out.print( String.valueOf(strrec2));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(strofc1));
            out.print( String.valueOf(strofc2));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(strmac1));
            out.print( String.valueOf(strmac2));
            _bw.write(_wl_block274Bytes, _wl_block274);
}
            _bw.write(_wl_block300Bytes, _wl_block300);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block301Bytes, _wl_block301);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block303Bytes, _wl_block303);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block304Bytes, _wl_block304);

			if(!(practitionerid.equals(""))){
				if(degree1.equals(""))
					readProperty="readOnly";
				else
					readProperty = "";
		
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(degree1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(year1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(readProperty));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(univ1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(readProperty));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block308Bytes, _wl_block308);
 } else {
            _bw.write(_wl_block309Bytes, _wl_block309);
}
            _bw.write(_wl_block310Bytes, _wl_block310);

			if(!(practitionerid.equals(""))){
			if(degree2.equals(""))
	       		readProperty="readOnly";
			else
				readProperty = "";
		
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(degree2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(year2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(readProperty));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(univ2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(readProperty));
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block308Bytes, _wl_block308);
 } else {
            _bw.write(_wl_block314Bytes, _wl_block314);
}
            _bw.write(_wl_block310Bytes, _wl_block310);

			if(!(practitionerid.equals(""))){
			if(degree3.equals(""))
	       		readProperty="readOnly";
			else
				readProperty = ""; 			
		
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(degree3));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(year3));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(readProperty));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(univ3));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(readProperty));
            _bw.write(_wl_block318Bytes, _wl_block318);
 } else {
            _bw.write(_wl_block319Bytes, _wl_block319);
}
            _bw.write(_wl_block310Bytes, _wl_block310);

			if(!(practitionerid.equals(""))){			
				if(degree4.equals(""))
	       			readProperty="readOnly";
				else
					readProperty = "";
		
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(degree4));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(year4));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(readProperty));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(univ4));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(readProperty));
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block308Bytes, _wl_block308);
 } else {
            _bw.write(_wl_block324Bytes, _wl_block324);
}
            _bw.write(_wl_block325Bytes, _wl_block325);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block326Bytes, _wl_block326);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block327Bytes, _wl_block327);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block328Bytes, _wl_block328);

	if(!(practitionerid.equals("")))
	{

            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(det1));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(con1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block332Bytes, _wl_block332);
  }
	else 
	{

            _bw.write(_wl_block333Bytes, _wl_block333);
  
	}

            _bw.write(_wl_block334Bytes, _wl_block334);

			if(!(practitionerid.equals(""))){
		
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(det2));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(con2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block308Bytes, _wl_block308);
 } else {
            _bw.write(_wl_block337Bytes, _wl_block337);
}
            _bw.write(_wl_block338Bytes, _wl_block338);

			if(!(practitionerid.equals(""))){
		
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(det3));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(con3));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block308Bytes, _wl_block308);
 } else {
            _bw.write(_wl_block341Bytes, _wl_block341);
}
            _bw.write(_wl_block310Bytes, _wl_block310);

			if(!(practitionerid.equals(""))){
		
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(det4));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(con4));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block308Bytes, _wl_block308);
 } else {
            _bw.write(_wl_block344Bytes, _wl_block344);
}
            _bw.write(_wl_block345Bytes, _wl_block345);
  
	/*if(fcall.equals("nocall"))
		out.println("<script>parent.frames[1].document.getElementById('identitylink').scrollIntoView();</script>");*/
  	if(newPractitioner){
            _bw.write(_wl_block346Bytes, _wl_block346);
}else{
            _bw.write(_wl_block347Bytes, _wl_block347);
}
  	   	}catch(Exception e){}
  	  	finally
		{
			if (stmt2 != null) stmt2.close();
			if (stmt != null) stmt.close();
			if (rs2 != null) rs2.close();
			if (rs != null) rs.close();

			ConnectionManager.returnConnection(conn,request);
		}
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(other_alt_type_desc));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(cerner_prac_id));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(citizen_nat_desc));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(citizen_nat_code));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(isResidencyApplYN));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(isPractEmployeeServiceNumber));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(natid_mand_yn));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(oth_alt_val));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(other_alt_type_no));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(other_alt_type_desc));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(oth_alt_length));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(emplstatus));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(employeeid));
            _bw.write(_wl_block369Bytes, _wl_block369);
if(effstatus.equals("D")) { 
            _bw.write(_wl_block370Bytes, _wl_block370);
 } 
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(practtype));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(poscode));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(employeeid));
            _bw.write(_wl_block374Bytes, _wl_block374);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CernerId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ExternalPractitioner.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullName.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortname.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longname.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FullPayngPatient.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FPP.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.Supervisor.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primaryspeciality.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Enable.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.virtualConsultation.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Identity.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactNoAddr.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QualificationTraining.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.maritalstatus.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.citizen.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.noncitizen.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AliasName.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Citizenship.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Credential.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Credential.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Credential.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Credential.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Credential.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Credential.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmplStatus.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ProfessionalQualification.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllFacilities.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.MMCNO.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.APCNo.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.RepFacility.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Signature.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Preview.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.EmployeeServiceNumber.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stamp.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Preview.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EmployeeID.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ResTelNo.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.officephoneno.label", java.lang.String .class,"key"));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ext.label", java.lang.String .class,"key"));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FaxNo.label", java.lang.String .class,"key"));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PagerNo.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PrefMode.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residence.label", java.lang.String .class,"key"));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.office.label", java.lang.String .class,"key"));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mail.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Address.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.postalcode.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QualificationDetails.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Degree.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Yearofpassing.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.University.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TrainingDetails.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DetailsofTraining.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConductedBy.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }
}
