package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.net.*;

public final class __patientdetailscomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PatientDetailsComponent.jsp", 1743060942113L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n \t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<head>\n\t\t\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n\t<script>\n\t// ============== Added by ranjani starts==============\n\n\tfunction enableAltID(){\n\t\t\t\t\t\n\t\t\t\tif(document.getElementById(\'other_alt_id\').selectedIndex != 0)\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'other_alt_Id_text\').disabled = false;\n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t\tdocument.getElementById(\'other_alt_Id_text\').disabled = true;\n\t\t\t}\n\n\t\t\t function ChangeInitCase(obj)\n            {\n              var name=obj.value;\n              var spltval = name.split(\" \") ;\n              var temp_name = \"\"\n             for(var i=0;i<spltval.length;i++)\n             {\n                var length= obj.value.length;\n              var letter = spltval[i].substring(0,length-(length-1));\n              var rest = spltval[i].substring(1,length);\n              letter=letter.toUpperCase();\n              rest=rest.toLowerCase();\n              var  namenow= letter.concat(rest);\n\t\t\t  temp_name+= namenow+\" \";\n             }\n             obj.value= temp_name.substring(0,temp_name.length-1);\n\n            }\n\t\t\tfunction enableOtherAltIdText(val)\n\t\t{\n\t\t\t\n\t\t\tif(val != \"\")\n\t\t\t{\n\t\t\t\tdocument.forms[0].contact1_oth_alt_id_no.disabled= false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].contact1_oth_alt_id_no.value=\"\";\n\t\t\t\tdocument.forms[0].contact1_oth_alt_id_no.disabled= true;\n\t\t\t}\n\t\t}\n\n\tfunction populateDetail(filedname, details, addresses)\n\t{\n\n\t  if (details == \"DECEASED\"|| details == \"SUSPENDED\"|| details == \"INACTIVE\")\n\t  {\n\t\talert(details);\n\t  }\n\t  else{\n\t\t\t\n\t\tvar arr = new Array();\n\t\tarr = details.split(\"||\");\n\t\t\t  \n\t       if (arr[0]==\"NAT_ID_VALUES\")\n\t\t\t{\n\t\t\t\t// Assign the values to the fields\t\n\t\t\t\n\t\t\t\tdocument.forms[0].date_of_birth.value = arr[1];\n\t\t\t\tdocument.forms[0].b_age.value = arr[2];\n\t\t\t\tdocument.forms[0].b_months.value = arr[3];\n\t\t\t\tdocument.forms[0].b_days.value = arr[4];\n\t\t\t\tdocument.forms[0].gender_obj.value = arr[5];\n\t\t\t\tdocument.forms[0].gender_obj.disabled = true;\n\t\t\t }\n\t      else\n\t\t  {\n\t\t\t\tif(document.forms[0].patient_id)\n\t\t\t\tdocument.forms[0].patient_id.value = arr[0];\n\t\t\t\t\n\t\t\t\tif(document.forms[0].patient_name)\n\t\t\t\tdocument.forms[0].patient_name.value = arr[1];\n\t\t\t\t\n\t\t\t\tif(document.forms[0].national_id_no)\n\t\t\t\tdocument.forms[0].national_id_no.value = arr[2];\n\t\t\t\t\n\t\t\t\tif(document.forms[0].alt_id1_no)\n\t\t\t\tdocument.forms[0].alt_id1_no.value = arr[3];\n\t\t\t\t\n\t\t\t\tif(document.forms[0].alt_id2_no)\n\t\t\t\tdocument.forms[0].alt_id2_no.value = arr[4];\n\t\t\t\t\n\t\t\t\tif(document.forms[0].alt_id3_no)\n\t\t\t\tdocument.forms[0].alt_id3_no.value = arr[5];\n\t\t\t\n\t\t\tif(document.forms[0].alt_id4_no)\n\t\t\tdocument.forms[0].alt_id4_no.value = arr[6];\n\t\t\t\n\t\t\tif(document.forms[0].name_prefix)\n\t\t\tdocument.forms[0].name_prefixz.value = arr[7];\n\t\t\t\n\t\t\tif(document.forms[0].first_name)\n\t\t\tdocument.forms[0].first_name.value = arr[8];\n\t\n\t\t\tif(document.forms[0].second_name)\n\t\t\tdocument.forms[0].second_name.value = arr[9];\n\t\t\t\n\t\t\tif(document.forms[0].third_name)\n\t\t\tdocument.forms[0].third_name.value = arr[10];\n\t\n\t\t\tif(document.forms[0].family_name)\n\t\t\tdocument.forms[0].family_name.value = arr[11];\n\t\n\tif(document.forms[0].name_suffix)\n\t\t\tdocument.forms[0].name_suffix.value = arr[12];\n\n\t\tif(document.forms[0].gender_obj)\n\t\t  {\n\t\t\tdocument.forms[0].gender_obj.value = arr[13];\n\t\t    document.forms[0].gender_obj.disabled = true;\n\t\t  }\n\tif(document.forms[0].b_days)\n\t\t\tdocument.forms[0].b_days.value = arr[25];\n\t\n\tif(document.forms[0].b_months)\n\t\t\tdocument.forms[0].b_months.value = arr[24];\n\t\n\tif(document.forms[0].b_age)\n\t\t\tdocument.forms[0].b_age.value = arr[23];\n\t\n\tif(document.forms[0].date_of_birth)\n\t\t\tdocument.forms[0].date_of_birth.value = arr[14];\n\t\n\tif(document.forms[0].contact1_no)\n\t\t\tdocument.forms[0].contact1_no.value = arr[15];\n\t\n\tif(document.forms[0].contact2_no)\n\t\t\tdocument.forms[0].contact2_no.value = arr[16];\n\t\n\tif(document.forms[0].email_id)\n\t\t\tdocument.forms[0].email_id.value = arr[17];\n\t\n\tif(document.forms[0].nationality)\n\t\tdocument.forms[0].nationality.value = arr[18];\n\t \n\t }\n\t }\n\t}\n\n\t// ============== Added by ranjani ends==============\n\n\tfunction ChangeInitCase(obj)\n\t{\n     var name=obj.value;\n     var spltval = name.split(\" \") ;\n     var temp_name = \"\"\n     for(var i=0;i<spltval.length;i++)\n     {\n         var length= obj.value.length;\n         var letter = spltval[i].substring(0,length-(length-1));\n         var rest = spltval[i].substring(1,length);\n         letter=letter.toUpperCase();\n         rest=rest.toLowerCase();\n         var  namenow= letter.concat(rest);\n\t     temp_name+= namenow+\" \";\n     }\n     obj.value= temp_name.substring(0,temp_name.length-1);\n}\t\n\nfunction ClearValues(Objval)\n{\n\tif(Objval == \"\")\n\t{\n\tdocument.forms[0].patient_id.readOnly = false;\n\tdocument.forms[0].Splcode_desc.readOnly = false;\n\tdocument.forms[0].alt_id1_no.readOnly = false;\n\tdocument.forms[0].date_of_birth.readOnly = false;\n\tdocument.forms[0].b_age.readOnly = false;\n\tdocument.forms[0].b_months.readOnly = false;\n\tdocument.forms[0].b_days.readOnly = false;\n\tdocument.forms[0].nationality.disabled = false;\n\tdocument.forms[0].gender_obj.disabled = false;\n\tdocument.forms[0].pref_adm_date.value = \"\";\n\tdocument.forms[0].Splcode.value = \"\";\n\tdocument.forms[0].patient_id.value = \"\";\n\tdocument.forms[0].Splcode_desc.value = \"\";\n\tdocument.forms[0].alt_id1_no.value = \"\";\n\tdocument.forms[0].patient_name.value = \"\";\n\tdocument.forms[0].date_of_birth.value = \"\";\n\tdocument.forms[0].b_age.value = \"\";\n\tdocument.forms[0].b_months.value = \"\";\n\tdocument.forms[0].b_days.value = \"\";\n\tdocument.forms[0].nationality.value = \"\";\n\tdocument.forms[0].gender_obj.value = \"\";\n\n\tif(document.forms[0].name_prefixz != null)\n\t{\n\t   document.forms[0].name_prefixz.disabled = false;\n\t   document.forms[0].name_prefixz.value = \"\";\n\t}\n\n\tif(document.forms[0].first_name != null)\n\t{\n\t   document.forms[0].first_name.readOnly = false;\n\t   document.forms[0].first_name.value = \"\";\n\t}\n\n\tif(document.forms[0].second_name != null)\n\t{\n\t   document.forms[0].second_name.readOnly = false;\n\t   document.forms[0].second_name.value = \"\";\n\t}\n\n\tif(document.forms[0].third_name != null)\n\t{\n\t   document.forms[0].third_name.readOnly = false;\n\t   document.forms[0].third_name.value = \"\";\n\t}\n\n\tif(document.forms[0].family_name != null)\n\t{\n\t   document.forms[0].family_name.readOnly = false;\n\t   document.forms[0].family_name.value = \"\";\n\t}\n\n\tif(document.forms[0].name_suffixz != null)\n\t{\n\t   document.forms[0].name_suffixz.disabled = false;\n\t   document.forms[0].name_suffixz.value = \"\";\n\t}\n\t}\n}\n\nfunction specialChar(obj,val)\n{\n\tif(obj.value!=\'\')\n\t{\n\t\tvar fields1 = new Array(obj);\n\t\tvar names1 = new Array(obj.name.toUpperCase());\n\t\tvar messageFrame = \"\"; var error_page = \"\";\n\t\tif(SpecialCharCheck(fields1,names1,messageFrame,\"A\",error_page) )\n\t\t{\n\t\t\tif(val==\"Num\")\n\t\t\t{\n\t\t\t\tif(CheckNum(obj))\n\t\t\t\t\t{\n\t\t\t\t\t\t return true;\n\t\t\t\t\t}\n\t\t\t\t\telse \n\t\t\t\t\t{\n\t\t\t\t\t\t obj.focus();\n\t\t\t\t\t\t obj.value=\'\';\n\t\t\t\t\t\t return false;\n\t\t\t\t\t}\n\t\t\t}\n\t\t\telse if(val==\"Char\")\n\t\t\t{\n\t\t\t\treturn true;\n\t\t\t}\n\n\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\n\t\t   obj.focus()\n\t\t   obj.value=\'\';\n\t\t   return false;\n\t\t}\n\t}\n\n}\n\tfunction OpenModel() \n\t{\n\t\t\n\t\tvar HTMLVal = new String();\n\t\tvar HTMLVal1 = new String();\n\t\t\tvar patid=PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'\',\'\',\'OTHER\');\n\t\t\tif( patid ==null)patid=\"\";\n\t\t\tif (patid != \"\")document.forms[0].patient_id.value=patid;\n\n\t\t\tif(patid != \"\" && patid !=null) {\n\t\t\tHTMLVal = \"<HTML><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+IeStyle.css+\"\'></link></head><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/BookAppointmentValidations.jsp\'><input name=\'pat_id\' id=\'pat_id\' type=\'hidden\' value=\'\"+escape(document.forms[0].patient_id.value)+\"\'><input name=\'Unregpatbkgyn\' id=\'Unregpatbkgyn\' type=\'hidden\' value=\'\"+escape(document.forms[0].unregisteredpatientsbkgyn.value)+\"\'>\t</form></BODY></HTML>\";\n\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t}\n\t}\n\t\t\n\tfunction validpatient(obj) \n\t{\n\t\tvar CA_Pat = \"\";\n\t\tif(document.forms[0].CA_Patient_ID.value != \"\")\n\t\t\tCA_Pat = \"Y\";\n\t\telse\n\t\t\tCA_Pat = \"N\";\n\t\t\n\t\tif(document.forms[0].patient_id.value !=\"\" && document.forms[0].patient_id.value !=null)\n\t\t{\tdocument.forms[0].checkval.value = \"1\";\n\t\t\tif(specialChar(obj,\'Char\')==true)\n\t\t\t{\n\t\t\t\tvar HTMLVal = new String();\n\t\t\t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/BookAppointmentValidations.jsp\'><input name=\'pat_id\' id=\'pat_id\' type=\'hidden\' value=\'\"+escape(document.forms[0].patient_id.value)+\"\'><input name=\'CA_Pat\' id=\'CA_Pat\' type=\'hidden\' value=\'\"+CA_Pat+\"\'><input name=\'Unregpatbkgyn\' id=\'Unregpatbkgyn\' type=\'hidden\' value=\'\"+escape(document.forms[0].unregisteredpatientsbkgyn.value)+\"\'></form></BODY></HTML>\";\n\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\n\t\t\tif(document.forms[0].call_function)\n\t\t\t{\n\t\t\t\tif(document.forms[0].call_function.value==\"Revise_Booking\")\n\t\t\t\t{\t\n\t\t\t\t\tdocument.forms[0].patient_id.value=\"\";\n\t\t\t\t\tif(document.forms[0].national_id !=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].national_id.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].alternate_id !=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].alternate_id.disabled=false;\n\t\t\t\t\t}\n\n\t\t\t\t\tif(document.forms[0].name_prefixz != null)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].name_prefixz.value=\"\";\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\tif(document.forms[0].first_name !=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].first_name.readOnly=false;\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\tif(document.forms[0].second_name !=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].second_name.readOnly=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].third_name !=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].third_name.readOnly=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].family_name !=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].family_name.readOnly=false;\n\t\t\t\t\t}\n\t\t\t\t\tif(document.forms[0].name_suffixz !=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].name_suffixz.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\tdocument.forms[0].gender_obj.disabled=false;\n\t\t\t\t\tdocument.forms[0].date_of_birth.readOnly=false;\n\t\t\t\t\tdocument.forms[0].b_age.readOnly=false;\n\t\t\t\t\tdocument.forms[0].b_months.readOnly=false;\n\t\t\t\t\tdocument.forms[0].b_days.readOnly=false;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].patient_id.value=\"\";\n\t\t\t\tdocument.forms[0].patient_name.value=\"\";\n\t\t\t\t\n\t\t\t\tif(document.forms[0].national_id !=null)\n\t\t\t\t{\n\t";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="\t\t\tdocument.forms[0].national_id.value=\"\";\n\t\t\t\tdocument.forms[0].national_id.disabled=false;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].alternate_id !=null)\n\t\t\t\t{\n\t\t\t\tdocument.forms[0].alternate_id.value=\"\";\n\t\t\t\tdocument.forms[0].alternate_id.disabled=false;\n\t\t\t\t}\n\n\t\t\t\tif(document.forms[0].name_prefixz != null)\n\t\t\t\t{\n\t\t\t\tdocument.forms[0].name_prefixz.disabled=false;\n\t\t\t\tdocument.forms[0].name_prefixz.value=\"\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(document.forms[0].first_name !=null)\n\t\t\t\t{\n\t\t\t\tdocument.forms[0].first_name.value=\"\";\n\t\t\t\tdocument.forms[0].first_name.readOnly=false;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(document.forms[0].second_name !=null)\n\t\t\t\t{\n\t\t\t\tdocument.forms[0].second_name.value=\"\";\n\t\t\t\tdocument.forms[0].second_name.readOnly=false;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].third_name !=null)\n\t\t\t\t{\n\t\t\t\tdocument.forms[0].third_name.value=\"\";\n\t\t\t\tdocument.forms[0].third_name.readOnly=false;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].family_name !=null)\n\t\t\t\t{\n\t\t\t\tdocument.forms[0].family_name.value=\"\";\n\t\t\t\tdocument.forms[0].family_name.readOnly=false;\n\t\t\t\t}\n\t\t\t\tif(document.forms[0].name_suffixz !=null)\n\t\t\t\t{\n\t\t\t\tdocument.forms[0].name_suffixz.value=\"\";\n\t\t\t\tdocument.forms[0].name_suffixz.disabled=false;\n\t\t\t\t}\n\t\t\t\tdocument.forms[0].gender_obj.value=\"\";\n\t\t\t\tdocument.forms[0].gender_obj.disabled=false;\n\t\t\t\t\n\t\t\t\tdocument.forms[0].date_of_birth.value=\"\";\n\t\t\t\tdocument.forms[0].date_of_birth.readOnly=false;\n\t\t\t\t\n\t\t\t\tdocument.forms[0].b_age.value=\"\";\n\t\t\t\tdocument.forms[0].b_age.readOnly=false;\n\t\t\t\t\n\t\t\t\tdocument.forms[0].b_months.value=\"\";\n\t\t\t\tdocument.forms[0].b_months.readOnly=false;\n\t\t\t\t\n\t\t\t\tdocument.forms[0].b_days.value=\"\";\n\t\t\t\tdocument.forms[0].b_days.readOnly=false;\n\t\t\t}\n\t\t}\n\t}\n\n\t///////////// This function is used to validate Nationality ID////////////////\t\n\t\t\nfunction validateNationality(Nat_Id)\t\n\t{\n\t\tvar HTMLVal = new String();\n\t\t\tvar nid = new String();\n\t\t\tnid = trimString(Nat_Id.value);\n\t\t\tNat_Id.value = nid;\n\t\t\n\t\t\tif (nid.length != 0)\n\t\t\t{\n\t\t\t\tHTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/BookApptCheckForNat.jsp?step=second\'><input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\'\"+escape(Nat_Id.value)+\"\'></form></body></html>\";\n\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t}\n\t}\n\n\tfunction validateExpiryDate(obj)\n\t{\n\t\tif(obj.value != \'\')\n\t\t{\n\t\t}\n\t}\n/////////////////// This function is used to validate Alternate Id ///////////\nfunction altid(Alt_Id) \n{\n\tif(specialChar(document.forms[0].alternate_id,\'Char\')==true)\n\t{\n\t\tvar altid=document.forms[0].alternate_id.value;\n\t\tvar HTMLVal1 = new String();\n\t}\n\tsetTimeout(\'altidval()\',2000);\n}\n\nfunction altidval()\n{\n\tif(document.forms[0].alternate_id.value !=\"\")  \n\t{\n\t\tif(specialChar(document.forms[0].alternate_id,\'Char\')==true)\n\t\t{\n\t\t\tif(document.forms[0].alternate_id.readOnly==false) \n\t\t\t{\n\t\t\t\tdocument.forms[0].checkval.value = \"1\";\n\t\t\tHTMLVal1 = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form3\' id=\'form3\' method=\'post\' action=\'../../eIP/jsp/BookAppointmentValidations.jsp\'><input name=\'alt_id\' id=\'alt_id\' type=\'hidden\' value=\'\"+escape(document.forms[0].alternate_id.value)+\"\'><input name=\'alt_id_prompt\' id=\'alt_id_prompt\' type=\'hidden\' value=\'\"+document.forms[0].Alt_Id1_Type.value+\"\'><input name=\'step\' id=\'step\' type=\'hidden\' value=\'Alternate\'><input name=\'Unregpatbkgyn\' id=\'Unregpatbkgyn\' type=\'hidden\' value=\'\"+escape(document.forms[0].unregisteredpatientsbkgyn.value)+\"\'></form></BODY></HTML>\";\n\t\t\tparent.document.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal1);\n\t\t\tparent.messageFrame.document.form3.submit();\n\t\t\t}\n\t\t}\n\t}\n}\n/////////////// This function is used to put the values into the name field //////////\n\nfunction putPatientName(from1,from)\n{\n\tif(makeValidString(from1) == false) \n\t{\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\n\tvar logic = new String();\n\tlogic = document.forms[0].name_drvn_logic.value;\n\tvar derievedName = \"\";\n\tvar logicElements = new Array();\n\tlogicElements = logic.split(\'+\');\n\tvar i=0;\n\n\t\tfor ( i=0;i<logicElements.length;i++)\n\t\t{\n\t\tif ( logicElements[i] == \'1N\' && document.getElementById(\'first_name\') != null)\n\t\t\t{\n\t\t\t\tif ( document.forms[0].first_name.value != \'\' )\n\t\t\t\t\tderievedName = derievedName + document.forms[0].first_name.value;\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'2N\' && document.forms[0].second_name != null )\n\t\t\t{\n\t\t\t\tif ( document.forms[0].second_name.value != \'\' )\n\t\t\t\t\tderievedName = derievedName + document.forms[0].second_name.value;\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'3N\' && document.forms[0].third_name != null)\n\t\t\t{\n\t\t\t\tif ( document.forms[0].third_name.value != \'\' )\n\t\t\t\t\tderievedName = derievedName + document.forms[0].third_name.value;\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'FN\' && document.forms[0].family_name != null)\n\t\t\t{\n\t\t\t\tif ( document.forms[0].family_name.value != \'\' )\n\t\t\t\t\tderievedName = derievedName + document.forms[0].family_name.value;\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'PR\' &&  document.forms[0].name_prefixz != null)\n\t\t\t{\n\t\t\t\tif ( document.forms[0].name_prefixz.value != \'\' )\n\t\t\t\t\tderievedName = derievedName +document.forms[0].name_prefixz.value;\n\t\t\t}\n\t\t\telse if ( logicElements[i] == \'SF\' &&  document.forms[0].name_suffixz != null)\n\t\t\t{\n\t\t\t\tif ( document.forms[0].name_suffixz.value != \'\' )\n\t\t\t\t\tderievedName = derievedName + document.forms[0].name_suffixz.value;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif ( logicElements[i] != \'1N\' &&  logicElements[i] != \'2N\' && logicElements[i] != \'3N\' && logicElements[i] != \'FN\' && logicElements[i] != \'PR\' && logicElements[i] != \'SF\' )\n\t\t\t\t{\n\t\t\t\t\tvar arLen = logicElements[i].length;\n\t\t\t\t\tvar tempVal = logicElements[i].substring(1,arLen - 1);\n\t\t\t\t\tif(derievedName == \"\")  tempVal=\"\";\n\t\t\t\t\tderievedName = derievedName + tempVal;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\tif (document.forms[0].pat_name_as_multipart_yn.value==\'N\')\n\t{\n\t\tif ( derievedName.length >= 60 )\n\t\t{\n\t\t\tderievedName = derievedName.substr(0,60);\n\t\t}\n\t}\n\telse\n\t{\n\t\tif ( derievedName.length >= 40 )\n\t\t{\n\t\t\tderievedName = derievedName.substr(0,40);\n\t\t}\n\t}\n\tdocument.forms[0].patient_name.value = derievedName;\n\t}\n}// End of FUNCTION\n\n////////////////// This function is used to pop up modal window for address details\n\n \tasync function show_window(Val,Val2,Val3,Val4)\n\t{\n\t\t\n\t\tvar patid=document.forms[0].patient_id.value;\n\t\tvar natid = document.forms[0].national_id_no.value;\n\t\tvar altid = \" \";\n\t\t\tif(Val ==\"One\") \n\t\t\t{\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= \"22\" ;\n\t\t\t\tvar dialogWidth\t= \"30\" ;\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no;status:\" + status;\n\t\t\t\tvar arguments\t= \"\";\n\n\t\t\t\tif(document.forms[0].checkval.value == \"1\")\n\t\t\t\t{\targuments\t= Val4;   document.forms[0].checkval.value = \"2\";   }\n\t\t\t\telse\t\n\t\t\t\t\targuments\t= Val3;\n\n\t\t\t\tvar contactdetails=Val3.value;\n\n\t\t\t\tvar url=\"../../eIP/jsp/BookAppointmentContact.jsp?patient_id=\"+escape(patid)+\"&natid=\"+escape(natid)+\"&altid=\"+escape(altid)+\"&booking_ref_no=\"+escape(Val2)+\"&contactdetails=\"+escape(contactdetails);\n\t\t\tretVal = await window.showModalDialog(url,arguments,features);\t\t\n\t\t\t\tif(retVal != \"\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].contactvals.value=retVal;\t\n\t\t\t\t\tvar contact_vals = retVal;\n\t\t\t\t\tvar contacts = contact_vals.split(\"||\");\n\n\t\t\t\t\t\tdocument.forms[0].restelno.value = contacts[0];\n\t\t\t\t\t\tdocument.forms[0].othertelno.value = contacts[1];\n\t\t\t\t\t\tdocument.forms[0].emailid.value = contacts[2];\n\t\t\t\t\t\tdocument.forms[0].postalcode.value = contacts[3];\n\t\t\t\t\t\tdocument.forms[0].countrycode.value = contacts[4];\n\t\t\t\t\t\tdocument.forms[0].resaddrline1.value = contacts[5];\n\t\t\t\t\t\tdocument.forms[0].resaddrline2.value = contacts[6];\n\t\t\t\t\t\tdocument.forms[0].resaddrline3.value = contacts[7];\n\t\t\t\t\t\tdocument.forms[0].resaddrline4.value = contacts[8];\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t//////////// This Function Calculates Year,Month and Days given D.O.B/////////\n\tfunction calc()\n\t{\n\t    var b_days  = document.forms[0].b_days.value;\t\n\t    var b_months  = document.forms[0].b_months.value;\n\t    var b_age  = document.forms[0].b_age.value;\n\t    \n\t    var HTMLVal = \"<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+IeStyle.css+\"\'></link></head><body class=\'message\' onKeyDown=\'lockKey()\'><form name=\'fetchvalforbooking\' id=\'fetchvalforbooking\' method=\'post\' action=\'../../eIP/jsp/FetchValForBooking.jsp\'><input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\'DOB_CALC\'><input type=\'hidden\' name=\'b_days\' id=\'b_days\' value=\'\"+b_days+\"\'><input type=\'hidden\' name=\'b_months\' id=\'b_months\' value=\'\"+b_months+\"\'><input type=\'hidden\' name=\'b_age\' id=\'b_age\' value=\'\"+b_age+\"\'></form></body></html>\";\n\t    parent.frames[0].document.write(HTMLVal);\t    \n\t    parent.frames[0].document.forms[0].submit();\n\t}\t\t\n\nfunction calci(Obj)\n\t{\n\t\tvar hide= document.forms[0].ServerDate.value;\n\t\tstrDateArray = hide.split(\"/\");\n\t\t\tif (strDateArray.length != 3) ;\n\t\t\telse {\n\t\t\t\tstrDay = strDateArray[0];\n\t\t\t\tstrMonth = strDateArray[1];\n\t\t\t\tstrYear = strDateArray[2];\n\t\t\t}\n\t\tif(Obj.name == \'b_age\' || Obj.value >0)\n\t\t\t{\n\t\t\tvar yy=document.forms[0].b_age.value;\n\t\t\tdays = new Date();\n\t\t\tgdate = days.getDate();\n\t\t\tgmonth = days.getMonth();\n\t\t\tgyear = days.getYear(); \n\t\t\tage = strYear - yy;\n\t\t\tdocument.forms[0].date_of_birth.value=strDay+\"/\"+strMonth+\"/\"+age;\n\t\t\tdocument.forms[0].text5.value=document.forms[0].date_of_birth.value;\n\t\t\t\n\t\t\tdocument.forms[0].text6.value=document.forms[0].date_of_birth.value;\n\n\n\t\t\t}\n\t\t\t\n\t\tif(Obj.name == \'b_months\' || (document.forms[0].b_months.value >0 && document.forms[0].b_months.value <12))\n\t\t{\n\t\tif(document.forms[0].text5.value == \'\') document.forms[0].text5.value=document.forms[0].ServerDate.value;\n\t\tvar hide1= document.forms[0].text5.value;\n\t\tvar mm=document.forms[0].b_months.value;\n\t\t\n\t\tstrDateArray1 = hide1.split(\"/\");\n\t\t\n\t\t\t\tstrDay1 = strDateArray1[0];\n\t\t\t\tstrMonth1 = strDateArray1[1];\n\t\t\t\tstrYear1 = strDateArray1[2];\n\t\tstrMonth1=strMonth1-mm;\n\t\tif(strMonth1 <=0)\n\t\t{\n\t\tstrMonth1=12+strMonth1;\n\t\tstrYear1=strYear1-1;\n\t\t}\n\t\t\n\t\t\n\t\tif(strMonth1 == \"1\") strMonth1=\"01\";\n\t\tif(strMonth1 == \"2\") strMonth1=\"02\";\n\t\tif(strMonth1 == \"3\") strMonth1=\"03\";\n\t\tif(strMonth1 == \"4\") strMonth1=\"04\";\n\t\tif(strMonth1 == \"5\") strMonth1=\"05\";\n\t\tif(strMonth1 == \"6\") strMonth1=\"06\";\n\t\tif(strMonth1 == \"7\") strMonth1=\"07\";\n\t\tif(strMonth1 == \"8\") strMonth1=\"08\";\n\t\tif(strMonth1 == \"9\") strMonth1=\"09\";\n\n\t\t\n\t\tif(strDay == \"1\") strDay=\"01\";\n\t\tif(strDay == \"2\") strDay=\"02\";\n\t\tif(strDay == \"3\") strDay=\"03\";\n\t\tif(strDay == \"4\") strDay=\"04\";\n\t\tif(strDay == \"5\") strDay=\"05\";\n\t\tif(strDay == \"6\") strDay=\"06\";\n\t\tif(strDay == \"7\") strDay=\"07\";\n\t\tif(strDay == \"8\") strDay=\"08\";\n\t\tif(strDay == \"9\") strDay=\"09\";\n\t\t\n\t\t\n\t\tdocument.forms[0].date_of_birth.value=strDay+\"/\"+strMonth1+\"/\"+strYear1;\n\t";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block9_2 ="\tdocument.forms[0].text6.value=document.forms[0].date_of_birth.value;\n\n\t\n\t\t}\n\t\t\n\t\tif(Obj.name == \'b_days\' || (document.forms[0].b_days.value >0 && document.forms[0].b_days.value <32))\n\t\t{\n\t\tif(document.forms[0].text6.value == \'\')  document.forms[0].text6.value=document.forms[0].ServerDate.value;\n\t\tvar hide2= document.forms[0].text6.value;\n\t\tvar dd=document.forms[0].b_days.value;\n\t\tstrDateArray2 = hide2.split(\"/\");\n\t\t\n\t\t\t\tstrDay2 = strDateArray2[0];\n\t\t\t\tstrMonth2= strDateArray2[1];\n\t\t\t\tstrYear2 = strDateArray2[2];\n\n\n\t\tstrDay=strDay2-dd;\n\n\t\tif(strDay <=0)\n\t\t{\n\t\tif( strMonth2 == 1){  strMonth2=13; strYear2--; } \n\t\tstrMonth2=strMonth2-1;\n\t\tif(strMonth2 == 2)\n\t\t\t{\n\t\t\tif(leapyear(strYear2))\n\t\t\t\t{\n\t\t\t\tstrDay=29+strDay+2;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\tstrDay=28+strDay;\n\t\t\t}\n\t\t\telse\n\t\t\tif((strMonth2 == 4) || (strMonth2 == 6) || (strMonth2 == 9) || (strMonth2 == 11))\n\t\t\t{\n\t\t\tstrDay=30+strDay;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tstrDay=31+strDay-1;\n\t\t\t}\n\t\t\t}\n\t\tif(strMonth2 == \"1\") strMonth2=\"01\";\n\t\tif(strMonth2 == \"2\") strMonth2=\"02\";\n\t\tif(strMonth2 == \"3\") strMonth2=\"03\";\n\t\tif(strMonth2 == \"4\") strMonth2=\"04\";\n\t\tif(strMonth2 == \"5\") strMonth2=\"05\";\n\t\tif(strMonth2 == \"6\") strMonth2=\"06\";\n\t\tif(strMonth2 == \"7\") strMonth2=\"07\";\n\t\tif(strMonth2 == \"8\") strMonth2=\"08\";\n\t\tif(strMonth2 == \"9\") strMonth2=\"09\";\n\t\t\n\t\tif(strDay == \"1\") strDay=\"01\";\n\t\tif(strDay == \"2\") strDay=\"02\";\n\t\tif(strDay == \"3\") strDay=\"03\";\n\t\tif(strDay == \"4\") strDay=\"04\";\n\t\tif(strDay == \"5\") strDay=\"05\";\n\t\tif(strDay == \"6\") strDay=\"06\";\n\t\tif(strDay == \"7\") strDay=\"07\";\n\t\tif(strDay == \"8\") strDay=\"08\";\n\t\tif(strDay == \"9\") strDay=\"09\";\n\t\tdocument.forms[0].date_of_birth.value=strDay+\"/\"+strMonth2+\"/\"+strYear2;\n\t\t}\n\t}\n\n\tfunction leapyear(a) {\n\tif(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))\n\treturn true;\n\telse\n\treturn false;\n\t}\n\n\tfunction CheckForNumber_L(Objval) {\n\t\t\tval = Objval.value;\n\t\n\t\tif ( trimCheck(val) && isNaN(val) == false && val >=0)\n\t\t\treturn true;\n\t\telse\n\t\t\tif ( val.length > 0 ) {\n\t\t\tdocument.forms[0].date_of_birth.value=\'\';\n\t\t\t\talert(getMessage(\"NUM_ALLOWED\",\"SM\"));\n\t\t\t\tObjval.select();\n\t\t\t\tObjval.focus();\n\t\t\t\treturn false;\n\t\t\t\t\n\t\t\t}\n\t}\n\n\t\t\tfunction calcage(obj1,obj2) {\n\t\t\t\tif(doDateCheckAlert(obj1,obj2))\n\t\t\t\t{\n\t\t\t\tif(CheckDate(obj1) == false)\n\t\t\t\tobj1.focus();\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tif(obj1.value.length !=0)\n\t\t\t\t{\n\t\t\t\tvar datecal=obj1.value;\n\t\t\tstrDateArray = datecal.split(\"/\");\n\t\t\t\tif (strDateArray.length != 3) ;\n\t\t\t\telse {\n\t\t\t\t\tstrDay = strDateArray[0];\n\t\t\t\t\tstrMonth = strDateArray[1];\n\t\t\t\t\tstrYear = strDateArray[2];\n\t\t\t\t}\n\t\t\n\t\t\t    var ageYears, ageMonths, ageDays\n\t\t\t    var datecal2=obj2.value;\n\t\t\t    bornDate = new Date(strMonth+\'/\'+strDay+\'/\'+strYear);\n\t\t\n\t\t\t    mm = bornDate.getMonth()+1 ;\n\t\t\t    dd = bornDate.getDate();\n\t\t\t    yy = bornDate.getYear();\n\t\t\n\t\t\t\tstrDateArray1 = datecal2.split(\"/\");\n\t\t\t\t\t\tif (strDateArray.length != 3) ;\n\t\t\t\t\t\telse {\n\t\t\t\t\t\t\tstrDay1 = strDateArray1[0];\n\t\t\t\t\t\t\tstrMonth1 = strDateArray1[1];\n\t\t\t\t\t\t\tstrYear1 = strDateArray1[2];\n\t\t\t\t}\n\t\t\n\t\t\t    testDate = new Date(strMonth1+\'/\'+strDay1+\'/\'+strYear1);\n\t\t\t    mm2 = testDate.getMonth()+1 ;\n\t\t\t    dd2 = testDate.getDate();\n\t\t\t    yy2 = testDate.getYear();\n\t\t\n\t\t\n\t\t\n\t\t\t\tif (yy < 100 && yy > 20) {\n\t\t\t\t\t        yy = yy + 1900\n\t\t\t\t\t        }\n\t\t\t\t\t\tif (yy2 < 100){\n\t\t\t\t\t\t\tif (yy2 > 20) {\n\t\t\t\t\t\t\t\tyy2 = yy2 + 1900\n\t\t\t\t\t        }else{\n\t\t\t\t\t\t\t\tyy2 = yy2 + 2000\n\t\t\t\t\t        }\n\t\t\t\t\t    }\n\t\t\n\t\t\n\t\t\t    //calcualate # of years\n\t\t\t    ageYears = yy2 - yy\n\t\t\t    //adjust years by looking at months\n\t\t\t    //same month, no birthday yet (add 12 months)\n\t\t\t    if(mm2 == mm){\n\t\t\t\t\tif(dd2 < dd){\n\t\t\t\t\t\tmm2 = mm2 + 12;\n\t\t\t\t\t\tageYears = ageYears - 1;\n\t\t\t\t\t}\n\t\t\t    }\n\t\t\t    //earlier month (add 12 months)\n\t\t\t    if(mm2 < mm){\n\t\t\t\t\tmm2 = mm2 + 12;\n\t\t\t\t\tageYears = ageYears - 1;\n\t\t\t\t\tageMonths = mm2 - mm;\n\t\t\t\t}\n\t\t\n\t\t\t\tageMonths = mm2 - mm;\n\t\t\n\t\t\t    //adjust months by looking at days\n\t\t\t    if (dd2 < dd) {\n\t\t\t\t\tageMonths = ageMonths - 1;\n\t\t\t\t\tif((ageMonths == 4) || (ageMonths == 6) || (ageMonths == 9) || (ageMonths == 11))\n\t\t\t\t\t{\n\t\t\t\t\t//commented on 25-09-2003 by dhanasekaran (shows incorrect days when dob is 28/04/1970)\n\t\t\t\t\t\tdd2 = dd2 + 31;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\tif(ageMonths == 2)\n\t\t\t\t\t{\n\t\t\t\t\t\tdd2=dd2+30;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdd2=dd2+30;\n\t\t\t\t\t}\n\t\t\t\t\tif (mm2 == mm) \n\t\t\t\t\t {\n\t\t\t\t\t\tageMonths = 0;\n\t\t\t\t\t\tageYears = ageYears - 1;\n\t\t\t\t\t }\n\t\t\t        }\n\t\t\t        ageDays = dd2 - dd;\n\t\t\tdocument.forms[0].b_age.value= ageYears ;\n\t\t\tif((document.forms[0].b_age.value.length == 1  || document.forms[0].b_age.value.length == 2) &&  document.forms[0].b_age.value !=\'0\' ) \t\n\t\t\t\tdocument.forms[0].b_age.value=ageYears ;\n\t\t\telse\n\t\t\t\tdocument.forms[0].b_age.value = document.forms[0].b_age.value.substring(2,document.forms[0].b_age.value.length)\n\n\t\t\tdocument.forms[0].b_months.value=ageMonths;\n\t\t\tdocument.forms[0].b_days.value=ageDays;\n\t\t\t}\n\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\talert(getMessage(\'BIRTH_DATE_GREATER_SYSDATE\',\'MP\'));\n\t\t\tobj1.focus();\n\t\t}\n\t\t}\n\t\t\n\t\tfunction enable(Obj)\n\t\t{\n\t\tif(Obj.checked)\n\t\t{\n\t\tyear.disabled=false;\n\t\tmonth.disabled=false;\n\t\tday.disabled=false\n\t\ttext4.disabled=true;\n\t\t}\n\t\telse\n\t\t{\n\t\tyear.disabled=true;\n\t\tmonth.disabled=true;\n\t\tday.disabled=true;\n\t\ttext4.disabled=false;\n\t\t}\n\t\t}\n\t\t\n\t\tfunction checkMonth(Obj)\n\t\t{\n\t\tif( Obj.value  > 11) { alert(getMessage(\'MONTH_NOT_GR_11\',\'MP\')); Obj.focus(); document.forms[0].date_of_birth.value=\'\';}\n\t\t}\n\t\t\n\t\tfunction checkDays(Obj)\n\t\t{\n\t\tif( Obj.value  > 31) { alert(getMessage(\'DAYS_NOT_31_CH\',\'MP\')); Obj.focus(); document.forms[0].date_of_birth.value=\'\';}\n\t\t}\n\n\t</script>\t\n\t</head>\n \t";
    private final static byte[]  _wl_block9_2Bytes = _getBytes( _wl_block9_2 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t     <body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\t\t\n\t     \t\t<input type=\'hidden\' name=\'name_drvn_logic\' id=\'name_drvn_logic\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n\t     \t\t<input type=\'hidden\' name=\'contactvals\' id=\'contactvals\' value=\'\'>\n\t     \t\t<input type=\'hidden\' name=\"checkval\" id=\"checkval\" value=\"1\">\n\t     \t\t<input type=\'hidden\' name=\"firstvals\" id=\"firstvals\" value=\"PopulateValues\">\n\n\t     \t\t<input type=\'hidden\' name=\'name_prefix\' id=\'name_prefix\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'name_suffix\' id=\'name_suffix\' value=\'\'>\n   \t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\' >\n\t\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t<td width=\"100%\" class=\"Border\">\n\t\t\t\t\t<!-- Table starting here for patient Details -->\n\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\n\t\t\t\t\t\t<tr>\n\t\t    \t\t\t\t<td align=\'left\' class=\'label\' width=\"10%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\t<td align=\'left\' width=\"15%\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<input type= \'text\' name=\'patient_id\' id=\'patient_id\' value=\"\" size=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" maxlength=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"><input type=\'button\' name=\'search\' id=\'search\' value=\'?\'  class=\"BUTTON\" onClick=\'OpenModel()\' tabIndex=\"-1\" ><img id = \"patidgif\" src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t<input type= \'text\' name=\'patient_id\' id=\'patient_id\' value=\"\" onChange=\'ClearValues(this.value);\' onBlur=\'ChangeUpperCase(this);validpatient(this)\' onKeyPress=\'return CheckForSpecChars(event)\' size=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"><input type=\'button\' name=\'search\' id=\'search\' value=\'?\'  class=\"BUTTON\" onClick=\'OpenModel()\' tabIndex=\"-1\" >\t<img id = \"patidgif\" src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\n\t\t\t\t\t\t <td align=\'right\' class=\'label\' width=\"10%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t\t\t<!-- Added on 14/03/2003 for Name field -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<td width=\"35%\">\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'patient_name\' id=\'patient_name\' value=\"\" maxlength=\'60\' size=\'40\' readonly></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t<td  width=\"45%\">\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'patient_name\' id=\'patient_name\' value=\"\" maxlength=\'40\' size=\'40\' readonly></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<td width=\'10%\' class= \'label\' align = \'left\' nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<td width=\'10%\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n                    <td width=\'20%\' nowrap>\n                        ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'national_id_no\' id=\'national_id_no\' maxlength=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' onKeyPress=\'return CheckForSpecChars(event)\' size=\'20\' onblur=\"return validateNationality(this,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" tabIndex=\'3\'>\n\t\t\t\t\t\t\t\t<input type=button value=\'M\' class= \'button\' tabindex=-1><img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden;\' name=\'nat_gif\'></img>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n                    \n\t\t\t\t</td>\t\n                </tr>\n\n\t\t</table>\n\n\t\t<table cellspacing=0 cellpadding=0 width=\'100%\' border=0>\n\t\t\t\t <tr></tr><tr></tr><tr></tr><tr></tr> \n                <tr> \n                    ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n                        <td class= \'label\' align = \'left\' width=\'12%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n                        <td nowrap>\n                            ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n                    ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n                    ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n                        <td class= \'label\' align = \'left\' width=\'10%\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n                </tr>\n\n                <tr>\n                    ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n                ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n                    <td class= \'label\' align = \'left\' width=\'10%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n                    <td nowrap>\n                        ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n                  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" \n                </tr>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t <tr><td class=\'label\' nowrap align=\'left\' width=\'10%\' >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t  <td colspan=3><select onchange=\'enableAltID();\' name=\'other_alt_id\' id=\'other_alt_id\'  tabindex=11>\n\t\t\t\t\t\t <option value=\'\'>---";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="---\n\t\t\t\t\t ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t  </select><input type =\'text\' name = \'other_alt_Id_text\' value=\"\" size=\'20\' maxlength=\'20\' tabindex=12 disabled></td>\n\t\t\t\t\t\t\t  <td></td><td></td><td></td><td></td></tr>\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t  \n\t\t\t\t\t <tr></tr><tr></tr><tr></tr> \n</table>\n\t\t\t\t\t<!--Table Ends here for Patient Details  -->\n\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'99%\' align=\'center\' valign=\'top\' >\n\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t</tr>\n\t\t<tr>\n\t\t<!-- Added on 14/03/2003 for Prifix select box -->\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<Option value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" > ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t    \t\t\t\t\t\t\t\t\t\t</tr>\n\t</table>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<td align=\"left\" class=\"label\" width=\'15%\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t\t<td align=\'left\' class=\'label\' width=\'20%\'> ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" </td>\n\t\t\t\t<td align=\'left\' class=\'label\' width=\'15%\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t\t<td align=\'left\' class=\'label\' width=\'30%\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t\t<td align=\'left\' class=\'label\' width=\'20%\' ></td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td align=\'left\' width=\'15%\' ><select name=\'gender_obj\' id=\'gender_obj\' >\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\'\'>---&nbsp";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&nbsp--- \n\t\t\t\t\t\t\t\t\t   <option value=\'M\' selected>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t   <option value=\'F\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t   <option value=\'U\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&nbsp--- \n\t\t\t\t\t\t\t\t\t   <option value=\'M\' >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t   <option value=\'F\' selected>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&nbsp---\n\t\t\t\t\t\t\t\t\t\t<option value=\'M\' >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\'F\' >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t   <option value=\'U\' selected>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t<option value=\'\' selected>---";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="--- \n\t\t\t\t\t\t\t\t\t\t<option value=\'M\' >";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t   <option value=\'U\' >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t     </select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t</td>\n\t\t\t<td align=\'left\' width=\'20%\' class=\'data\' nowrap><input type=\"text\" name=\"b_age\" id=\"b_age\" maxlength=\"3\" size=\"2\" value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'   onChange=\'calci(this)\' onBlur=\'CheckForNumber_L(this);\' onKeyPress=\'return(ChkNumberInput(this,event,0))\'>Y\n\t\t\t\t<input type=\"text\"  name=\"b_months\" id=\"b_months\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' size=\"1\"   onChange=\'calci(this)\' onBlur=\'CheckForNumber_L(this);checkMonth(this)\' onKeyPress=\'return(ChkNumberInput(this,event,0))\'  >M\n\t\t\t\t<input type=\"text\" name=\"b_days\" id=\"b_days\" maxlength=\"2\" size=\"1\" value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'   onChange=\'calci(this)\' onBlur=\'CheckForNumber_L(this);checkDays(this)\'  onKeyPress=\'return(ChkNumberInput(this,event,0))\'>D\n\t\t\t</td>\n\t\t\t<td align=\'left\' width=\'15%\' >\n\t\t\t\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t\t\t<input type=\"text\" id = \"dateofbirth\" name=\"date_of_birth\" id=\"date_of_birth\" maxlength=\"10\" size=\"10\"  value=\'\' onblur=\'calcage(this,ServerDate)\' ><input type=\'image\' name= \"dob\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].date_of_birth.select();return showCalendar(\'dateofbirth\');\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'>\n\t\t\t\t<input type=\'hidden\' name=\'ServerTime\' id=\'ServerTime\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'gen\' id=\'gen\' value=\'\'>\n\t\t\t</td>\n\t\t\t<td align=\'left\' width=\'30%\' ><SELECT name=\'nationality\' id=\'nationality\'>\n\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="---</option>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t\t\n\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t</SELECT>\t\n\t\t\t</td>\n\t\t\t <td align=\'left\' width=\'20%\'><input type=\'button\' name=\'ContactDetails\' id=\'ContactDetails\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' onClick=\"show_window(\'One\',\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\',contactvals,firstvals)\" class=\"BUTTON\" >\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n</td>\n</tr>\n</table>\n<input type=\'hidden\' name=\'First_Name_Prompt\' id=\'First_Name_Prompt\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n<input type=\'hidden\' name=\'Second_Name_Prompt\' id=\'Second_Name_Prompt\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n<input type=\'hidden\' name=\'Third_Name_Prompt\' id=\'Third_Name_Prompt\' value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n<input type=\'hidden\' name=\'Family_Name_Prompt\' id=\'Family_Name_Prompt\' value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n<input type=\'hidden\' name=\'Name_Suffix_Prompt\' id=\'Name_Suffix_Prompt\' value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n<input type=\'hidden\' name=\'Name_Prefix_Prompt\' id=\'Name_Prefix_Prompt\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n<input type=\'hidden\' name=\'CA_Patient_ID\' id=\'CA_Patient_ID\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n<input type=\'hidden\' name=\'Alt_Id1_Type\' id=\'Alt_Id1_Type\' value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\n<input type=\'hidden\' name=\'restelno\' id=\'restelno\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<input type=\'hidden\' name=\'othertelno\' id=\'othertelno\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n<input type=\'hidden\' name=\'emailid\' id=\'emailid\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n<input type=\'hidden\' name=\'postalcode\' id=\'postalcode\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<input type=\'hidden\' name=\'countrycode\' id=\'countrycode\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\'hidden\' name=\'resaddrline1\' id=\'resaddrline1\' value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type=\'hidden\' name=\'resaddrline2\' id=\'resaddrline2\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type=\'hidden\' name=\'resaddrline3\' id=\'resaddrline3\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=\'hidden\' name=\'resaddrline4\' id=\'resaddrline4\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value = \"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"> \n\n<!--- added on 26-09-2003 by dhanasekaran --->\n<input type=\'hidden\' name=\'unregisteredpatientsbkgyn\' id=\'unregisteredpatientsbkgyn\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"> \n<!--- end addition --->\n\n</body>\n<script>\n\t\n\tif(\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"!=\'\')\n\t{\n\t   document.forms[0].patient_id.value = \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t   document.forms[0].patient_id.readOnly=true;\n\t   document.forms[0].search.disabled=true;\n\t   validpatient(document.forms[0].patient_id);\n\t}\n\tvar unregisteredpatientsbkgyn = \'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\';\n\tsetTimeout(\'calcage(document.forms[0].date_of_birth,document.forms[0].ServerDate)\',1000);\n\ndocument.forms[0].contactvals.value\t+=\t\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' +\"||\";\ndocument.forms[0].contactvals.value +=\t\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\';\n\n</script>\t\n\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n<input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n<input type=\'hidden\' name=\'gifval\' id=\'gifval\' value=N>\n\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);

 		Connection conn = null;
	 	String unregisteredpatientsbkgyn= "";
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);
            _bw.write(_wl_block9_2Bytes, _wl_block9_2);

	Statement stmt=null;
	Statement stmt4=null;
	Statement stmt5=null;
	Statement stmtsd=null;
	Statement stmtlen=null;
	Statement stmt10=null;
	Statement stmt20=null;
	PreparedStatement pstmt=null;	

	ResultSet oth_rset=null;
	ResultSet rset=null;
	ResultSet rst=null;
	ResultSet rs=null;
	ResultSet rs4=null;
	ResultSet rs5=null;
	ResultSet rssd=null;
	ResultSet rslen=null;
	ResultSet rs10=null;
	ResultSet rs20=null;

 	try
	{
	String ca_patient_id = request.getParameter("ca_patient_id");
		if(ca_patient_id==null || ca_patient_id.equals("")) ca_patient_id="";
	StringBuffer sql = new StringBuffer();

	//Added on 14/03/2003
	String pat_name_as_multipart_yn = "";
	String First_Name_Accept_Yn ="";
	int First_Name_Order=0;
	String First_Name_Prompt ="";
	String Second_Name_Accept_Yn ="";
	int Second_Name_Order =0;
	String Second_Name_Prompt ="";
	String Third_Name_Accept_Yn ="";
	int Third_Name_Order =0;
	String Third_Name_Prompt ="";
	String Family_Name_Accept_Yn ="";
	int Family_Name_Order =0;
	String Family_Name_Prompt ="";
	String Name_Suffix_Accept_Yn ="";
	String Name_Suffix_Prompt ="";
	String Name_Prefix_Accept_Yn = "";
	String Name_Prefix_Prompt = "";

	String First_Name_Reqd_Yn ="";
	String Second_Name_Reqd_Yn ="";
	String Third_Name_Reqd_Yn ="";
	String Family_Name_Reqd_Yn ="";
	String Name_Suffix_Reqd_Yn ="";
	String Name_Prefix_Reqd_Yn ="";
	String Alt_Id1_Type ="";
 	String NameDrvnLogic="";
 	String facilityid=(String)session.getValue("facility_id");
	
	conn = ConnectionManager.getConnection(request);
	
	StringBuffer len_check = new StringBuffer();
	len_check.append("Select Patient_Id_Length,Nat_Id_Length,alt_id1_length from mp_param");
	stmtlen=conn.createStatement();
	rslen=stmtlen.executeQuery(len_check.toString());
	rslen.next();
	String Patient_Id_Length=rslen.getString(1);
	String Nat_Id_Length=rslen.getString(2);
	String Alt_id1_length=rslen.getString(3);
	
	String patient_grp="";
	StringBuffer sqlGroup = new StringBuffer();
	sqlGroup.append("select dflt_pat_ser_grp_type from mp_param");
	stmtlen=conn.createStatement();
	rslen=stmtlen.executeQuery(sqlGroup.toString());
	if(rslen != null) {
		rslen.next() ;
		patient_grp = rslen.getString(1);}
	else
		patient_grp = "G";

	String Site="";
	StringBuffer sqlSite = new StringBuffer();
	sqlSite.append("select site_id from sm_site_param");
	stmtlen=conn.createStatement();
	rslen=stmtlen.executeQuery(sqlSite.toString());
	if(rslen != null) {
		rslen.next() ;
		Site = rslen.getString(1);
	}
	
	
	if(Patient_Id_Length==null)	Patient_Id_Length	=	"0";
	if(Nat_Id_Length==null)		Nat_Id_Length		=	"20";
	if(Alt_id1_length==null)	Alt_id1_length		=	"0";

	int pat_id_len=Integer.parseInt(Patient_Id_Length);

	String firstname="";
	String secondname="";
	String thirdname="";
	String familyname="";
	String gender="";
	String agey="";
	String agem="";
	String aged="";
	String addrl1="";
	String addrl2="";
	String addrl3="";
	String addrl4="";
	String postal_code1="";
	String prn_tel_no="";
	String orn_tel_no="";
	String email_id="";
	String countrycode="";
 	String booking_ref_no = "";
 	String nat_id_prompt ="";
	
	String names_in_oth_lang="";
	String accept_national_id_no_yn="";
	String alt_id1_accept_oth_pat_ser_yn="";
	String alt_id1_accept_alphanumeric_yn="";
	String max_pat_age="";
	String Accept_oth_alt_id_yn="";
	String a_national_id_no="";
	String a_alt_id1_no="";
	String exe_str="";
	String AltIdNo="";
	String AltIdNo2="";
	String AltIdNo3="";
	String AltIdNo4="";

 	booking_ref_no = request.getParameter("booking_ref_no");	
	String from_revise_booking = request.getParameter("from_revise_booking");

	if(booking_ref_no == null || booking_ref_no.equals("null")) booking_ref_no = "";
	if(from_revise_booking == null || from_revise_booking.equals("null")) from_revise_booking = "";

	stmtsd=conn.createStatement();
	String sqlsd="select to_char(sysdate,'dd/mm/rrrr') from dual";
	rssd=stmtsd.executeQuery(sqlsd);
	rssd.next();
	 String str13=rssd.getString(1);

	stmt=conn.createStatement();

	sql.append("select nvl(First_Name_Accept_Yn,'N'),First_Name_Order,nvl(First_Name_Prompt,'First Name'),nvl(Second_Name_Accept_Yn,'N'),Second_Name_Order,nvl(Second_Name_Prompt,'Second Name'),nvl(Third_Name_Accept_Yn,'N'),Third_Name_Order,nvl(Third_Name_Prompt,'Third Name'),nvl(Family_Name_Accept_Yn,'N'),Family_Name_Order,nvl(Family_Name_Prompt,'Family Name'),nvl(name_suffix_accept_yn,'N'),nvl(name_prefix_accept_yn,'N'),nvl(name_suffix_prompt,'Name Suffix'),nvl(name_prefix_prompt,'Name Prefix'),nvl(first_name_reqd_yn,'N'),nvl(second_name_reqd_yn,'N'),nvl(third_name_reqd_yn,'N'),nvl(family_name_reqd_yn,'N'),nvl(name_suffix_reqd_yn,'N'),nvl(name_prefix_reqd_yn,'N'),name_dervn_logic, nvl(Alt_Id1_reqd_yn,'N'), Alt_Id1_type, nvl(Alt_Id1_length,0), nvl(Alt_Id1_Unique_yn,'N'),nvl(nat_id_prompt,''),pat_name_as_multipart_yn from mp_param ");
	 
	rs=stmt.executeQuery(sql.toString());
	rs.next();
	First_Name_Accept_Yn = rs.getString(1);
	First_Name_Order = rs.getInt(2);
	First_Name_Prompt = rs.getString(3);
	Second_Name_Accept_Yn = rs.getString(4);
	Second_Name_Order = rs.getInt(5);
	Second_Name_Prompt = rs.getString(6);
	Third_Name_Accept_Yn = rs.getString(7);
	Third_Name_Order = rs.getInt(8);
	Third_Name_Prompt = rs.getString(9);
	Family_Name_Accept_Yn = rs.getString(10);
	Family_Name_Order = rs.getInt(11);
	Family_Name_Prompt = rs.getString(12);

	Name_Suffix_Accept_Yn = rs.getString(13);
	Name_Prefix_Accept_Yn = rs.getString(14);
	Name_Suffix_Prompt = rs.getString(15);
	Name_Prefix_Prompt = rs.getString(16);

	First_Name_Reqd_Yn = rs.getString(17);
	Second_Name_Reqd_Yn = rs.getString(18);
	Third_Name_Reqd_Yn = rs.getString(19);
	Family_Name_Reqd_Yn = rs.getString(20);
	Name_Suffix_Reqd_Yn = rs.getString(21);
	Name_Prefix_Reqd_Yn = rs.getString(22);
	NameDrvnLogic=rs.getString(23);
	Alt_Id1_Type = rs.getString(25) ;
	nat_id_prompt	=   rs.getString(28);
	
	//Added on 14/03/2003
	pat_name_as_multipart_yn = rs.getString(29);
	if(pat_name_as_multipart_yn==null) pat_name_as_multipart_yn="N";

	if (nat_id_prompt==null) nat_id_prompt="National Id No";
	StringBuffer unregBkSql = new StringBuffer();
	unregBkSql.append("Select  unregistered_patients_bkg_yn from ip_param where facility_id='"+facilityid+"'");
	stmt20 = conn.createStatement();
	rs20  = stmt20.executeQuery(unregBkSql.toString());
	if(unregBkSql != null)
	{
		if(rs20.next())
		{
			unregisteredpatientsbkgyn = rs20.getString("unregistered_patients_bkg_yn");
		} 	
	}
	StringBuffer contactsql = new StringBuffer();
	contactsql.append("select patient_id,res_addr_line1, res_addr_line2, res_addr_line3, res_addr_line4,postal_code,country_code, res_tel_no,oth_contact_no,email_id from ip_booking_list_vw where bkg_lst_ref_no = ?");
	pstmt=conn.prepareStatement(contactsql.toString());
	pstmt.setString(1,booking_ref_no);
	rst=pstmt.executeQuery();
	if(rst!=null)
	 {
	  if(rst.next())
	   {
		 addrl1=rst.getString("res_addr_line1");
		 addrl2=rst.getString("res_addr_line2");
		 addrl3=rst.getString("res_addr_line3");
		 addrl4=rst.getString("res_addr_line4");
		 postal_code1=rst.getString("postal_code");
		 prn_tel_no=rst.getString("res_tel_no");
		 orn_tel_no=rst.getString("oth_contact_no");
		 email_id=rst.getString("email_id");
		 countrycode=rst.getString("country_code");	
	   }
	 }  
	
	if(addrl1==null || addrl1.equals("")) addrl1="";
	if(addrl2==null || addrl2.equals("")) addrl2="";
	if(addrl3==null || addrl3.equals("")) addrl3="";
	if(addrl4==null || addrl4.equals("")) addrl4="";
	if(postal_code1==null || postal_code1.equals("")) postal_code1="";
	if(countrycode==null || countrycode.equals("")) countrycode="";
    if(prn_tel_no==null || prn_tel_no.equals("")) prn_tel_no="";
	if(orn_tel_no==null || orn_tel_no.equals("")) orn_tel_no="";	
    if(email_id==null || email_id.equals("") || email_id.equals("null")) email_id="";
	
 if(pstmt!=null) pstmt.close();
 if(rst!=null) rst.close();
					
					
		

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(NameDrvnLogic));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

						
						if(from_revise_booking.equals("Y"))
						{
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pat_id_len));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_id_len));
            _bw.write(_wl_block16Bytes, _wl_block16);

						}
						else
						{
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pat_id_len));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_id_len));
            _bw.write(_wl_block18Bytes, _wl_block18);

						}
					
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

								if(pat_name_as_multipart_yn.equals("N"))
								{
							
            _bw.write(_wl_block21Bytes, _wl_block21);

								}
								else
								{
							
            _bw.write(_wl_block22Bytes, _wl_block22);

									
								}
            _bw.write(_wl_block2Bytes, _wl_block2);

	if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append(" Select nvl(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, nvl(Alt_Id2_reqd_yn,'N') Alt_Id2_reqd_yn, nvl(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, nvl(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn, Alt_Id1_type,initcap(substr(alt_id1.short_desc,1,10)) alt_id1_desc, Alt_Id2_type,initcap(substr(alt_id2.short_desc,1,10)) alt_id2_desc, Alt_Id3_type,initcap(substr(alt_id3.short_desc,1,10)) alt_id3_desc,Alt_Id4_type,initcap(substr(alt_id4.short_desc,1,10)) alt_id4_desc, nvl(First_Name_Accept_Yn,'N') First_Name_Accept_Yn, First_Name_Order, nvl(First_Name_Prompt,'First Name')First_Name_Prompt, nvl(Second_Name_Accept_Yn,'N') Second_Name_Accept_Yn, Second_Name_Order, nvl(Second_Name_Prompt,'Second Name') Second_Name_Prompt, nvl(Third_Name_Accept_Yn,'N') Third_Name_Accept_Yn,Third_Name_Order, nvl(Third_Name_Prompt,'Third Name') Third_Name_Prompt, nvl(Family_Name_Accept_Yn,'N') Family_Name_Accept_Yn,Family_Name_Order, nvl(Family_Name_Prompt,'Family Name') Family_Name_Prompt,name_dervn_logic,  nvl(Alt_Id1_length,0)Alt_Id1_length,nvl(Alt_Id2_length,0)Alt_Id2_length, nvl(Alt_Id3_length,0) Alt_Id3_length,nvl(Alt_Id4_length,0)Alt_Id4_length, nvl(name_suffix_accept_yn,'N') name_suffix_accept_yn, nvl(name_prefix_accept_yn,'N')name_prefix_accept_yn, nvl(name_suffix_prompt,'Name Suffix')name_suffix_prompt, nvl(name_prefix_prompt,'Name Prefix')name_prefix_prompt,  nvl(first_name_reqd_yn,'N')first_name_reqd_yn, nvl(second_name_reqd_yn,'N')second_name_reqd_yn, nvl(third_name_reqd_yn,'N') third_name_reqd_yn, nvl(family_name_reqd_yn,'N')family_name_reqd_yn, nvl(name_suffix_reqd_yn,'N')name_suffix_reqd_yn, nvl(name_prefix_reqd_yn,'N')name_prefix_reqd_yn, nvl(family_no_link_yn,'N') family_no_link_yn, nvl(patient_id_length,0) patient_id_length,citizen_nationality_code, nvl(Alt_Id1_Unique_yn,'N')Alt_Id1_Unique_yn, nvl(Alt_Id2_Unique_yn,'N')Alt_Id2_Unique_yn, nvl(Alt_Id3_Unique_yn,'N')Alt_Id3_Unique_yn, nvl(Alt_Id4_Unique_yn,'N')Alt_Id4_Unique_yn,  decode('"+patient_grp+"','N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dfltPSG, nvl(alt_id_pat_ser_grp,'') AltdfltPSG, nat_id_length , nvl(ALT_ID1_LEN_VALIDATION_YN,'N') ALT_ID1_LEN_VALIDATION_YN, nvl(ALT_ID2_LEN_VALIDATION_YN,'N') ALT_ID2_LEN_VALIDATION_YN, nvl(ALT_ID3_LEN_VALIDATION_YN,'N') ALT_ID3_LEN_VALIDATION_YN, nvl(ALT_ID4_LEN_VALIDATION_YN,'N')ALT_ID4_LEN_VALIDATION_YN, alt_id1_exp_date_accept_yn,alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn,alt_id4_exp_date_accept_yn, alt_id1_routine_yn,  alt_id1_data_source_id alt_id1_routine,  alt_id2_routine_yn, alt_id2_data_source_id  alt_id2_routine, alt_id3_routine_yn, alt_id3_data_source_id  alt_id3_routine, alt_id4_routine_yn, alt_id4_data_source_id  alt_id4_routine, nvl(NAT_ID_PAT_SER_GRP,'') def_nat_id_pat_ser_grp, nvl(nat_id_prompt,'National ID No') nat_id_prompt, NAMES_IN_OTH_LANG_YN,  decode(dflt_pat_ser_grp_type,'N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dflt_grp,  alt_id1_chk_digit_scheme,alt_id2_chk_digit_scheme,alt_id3_chk_digit_scheme,  alt_id4_chk_digit_scheme,invoke_routine,nat_data_source_id,  nvl(nat_id_check_digit_id,'')  nat_id_check_digit_id, nvl(ADDL_FIELD1_PROMPT,'')ADDL_FIELD1_PROMPT,  nvl(ADDL_FIELD1_LENGTH,'0')ADDL_FIELD1_LENGTH, nvl(ADDL_FIELD1_SECTION,'')ADDL_FIELD1_SECTION, nvl(ADDL_FIELD2_PROMPT,'')ADDL_FIELD2_PROMPT, nvl(ADDL_FIELD2_LENGTH ,'0')ADDL_FIELD2_LENGTH, nvl(ADDL_FIELD2_SECTION ,'')ADDL_FIELD2_SECTION, nvl(ADDL_FIELD3_PROMPT ,'')ADDL_FIELD3_PROMPT, nvl(ADDL_FIELD3_LENGTH ,'0')ADDL_FIELD3_LENGTH, nvl(ADDL_FIELD3_SECTION ,'')ADDL_FIELD3_SECTION, nvl(ADDL_FIELD4_PROMPT ,'')ADDL_FIELD4_PROMPT, nvl(ADDL_FIELD4_LENGTH,'0')ADDL_FIELD4_LENGTH, nvl(ADDL_FIELD4_SECTION ,'')ADDL_FIELD4_SECTION, nvl(ADDL_FIELD5_PROMPT,'')ADDL_FIELD5_PROMPT, nvl(ADDL_FIELD5_LENGTH ,'0')ADDL_FIELD5_LENGTH, nvl(ADDL_FIELD5_SECTION ,'')ADDL_FIELD5_SECTION,nvl(NAT_ID_CHK_LEN,'N')NAT_ID_CHK_LEN,  to_char(sysdate,'dd/mm/rrrr')ServerDate,to_char(sysdate,'ddmmrrrrhhmmss')photo_file_name, nvl(NAT_ID_REQD_ALL_SERIES,'N') NAT_ID_REQD_ALL_SERIES, nvl(NAME_PREFIX_LOC_LANG_PROMPT,'')NAME_PREFIX_LOC_LANG_PROMPT, nvl(FIRST_NAME_LOC_LANG_PROMPT,'')FIRST_NAME_LOC_LANG_PROMPT , nvl(SECOND_NAME_LOC_LANG_PROMPT,'')SECOND_NAME_LOC_LANG_PROMPT,  nvl(THIRD_NAME_LOC_LANG_PROMPT,'')THIRD_NAME_LOC_LANG_PROMPT, nvl(FAMILY_NAME_LOC_LANG_PROMPT,'')FAMILY_NAME_LOC_LANG_PROMPT,  nvl(NAME_SUFFIX_LOC_LANG_PROMPT,'')NAME_SUFFIX_LOC_LANG_PROMPT,accept_national_id_no_yn, alt_id1_accept_oth_pat_ser_yn,alt_id1_accept_alphanumeric_yn, max_patient_age, name_dervn_logic_oth_lang, pat_name_as_multipart_yn,Accept_oth_alt_id_yn from mp_param,mp_alternate_id_type alt_id1,mp_alternate_id_type alt_id2,mp_alternate_id_type alt_id3,mp_alternate_id_type alt_id4 where alt_id1_type=alt_id1.alt_id_type and alt_id2_type=alt_id2.alt_id_type(+) and alt_id3_type=alt_id3.alt_id_type(+) and alt_id4_type=alt_id4.alt_id_type(+) " );           
					 
					 stmt = conn.createStatement();
					 rset = stmt.executeQuery(sql.toString()) ;
					if(rset != null)
						rset.next() ;

					names_in_oth_lang = rset.getString("NAMES_IN_OTH_LANG_YN");
					if (names_in_oth_lang ==null) names_in_oth_lang = "N";
					//Added by kumar for enhancements. Additional Restrictions for Alternate id1 and //national id no. 
					accept_national_id_no_yn = rset.getString("accept_national_id_no_yn");
					alt_id1_accept_oth_pat_ser_yn = rset.getString("alt_id1_accept_oth_pat_ser_yn");
					alt_id1_accept_alphanumeric_yn = rset.getString("alt_id1_accept_alphanumeric_yn");
					
					if (accept_national_id_no_yn==null) accept_national_id_no_yn = "N";
					if (alt_id1_accept_oth_pat_ser_yn==null) alt_id1_accept_oth_pat_ser_yn = "N";
					if (alt_id1_accept_alphanumeric_yn==null) alt_id1_accept_alphanumeric_yn = "N";

					pat_name_as_multipart_yn = rset.getString("pat_name_as_multipart_yn");
					Accept_oth_alt_id_yn = rset.getString("Accept_oth_alt_id_yn");
					if(Accept_oth_alt_id_yn == null) Accept_oth_alt_id_yn = "N"; 
            _bw.write(_wl_block23Bytes, _wl_block23);
	out.println("<input type='hidden' name='accept_national_id_no' id='accept_national_id_no' value='"+accept_national_id_no_yn+"'>");
					out.println("<input type='hidden' name='alt_id1_accept_oth_pat_ser_yn' id='alt_id1_accept_oth_pat_ser_yn' value='"+alt_id1_accept_oth_pat_ser_yn+"'>");
					out.println("<input type='hidden' name='alt_id1_accept_alphanumeric_yn' id='alt_id1_accept_alphanumeric_yn' value='"+alt_id1_accept_alphanumeric_yn+"'>");
					out.println("<input type='hidden' name='max_patient_age' id='max_patient_age' value="+max_pat_age+">");
					
					if (accept_national_id_no_yn.equals("Y"))
					{						
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( (rset.getString("nat_id_prompt") 	== null? "National ID No;":rset.getString("nat_id_prompt")) ));
            _bw.write(_wl_block25Bytes, _wl_block25);

					}
					else
					{
					
            _bw.write(_wl_block26Bytes, _wl_block26);

					}
            _bw.write(_wl_block27Bytes, _wl_block27);
                          
							if ( patient_grp.equals("N") && accept_national_id_no_yn.equals("Y"))
                            {
                                a_national_id_no = request.getParameter("nat_id") ;
                            }
							if (accept_national_id_no_yn.equals("Y"))
							{
								
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( rset.getString("nat_id_length") ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Site));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rset.getString("def_nat_id_pat_ser_grp")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rset.getString("invoke_routine")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rset.getString("nat_data_source_id")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rset.getString("nat_id_check_digit_id")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rset.getString("NAT_ID_CHK_LEN")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((a_national_id_no == null ? "" : a_national_id_no) ));
            _bw.write(_wl_block32Bytes, _wl_block32);

								if(!a_national_id_no.equals(""))
								{							
								}
								exe_str =rset.getString("nat_id_length")+"`"+ (rset.getString("nat_id_check_digit_id")== null ?" ":rset.getString("nat_id_check_digit_id"))+"`"+rset.getString("NAT_ID_CHK_LEN") ;
								out.println("<input type='hidden' name='Nat_id_Valid_data' id='Nat_id_Valid_data' value=\""+exe_str+"\">");
								out.println("<input type='hidden' name='nat_id_reqd_all_series' id='nat_id_reqd_all_series' value=\""+rset.getString("nat_id_reqd_all_series")+"\">");
								out.println("<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value=\""+rset.getString("nat_id_prompt")+"\">");
								out.println("<input type='hidden' name='invoke_routine' id='invoke_routine' value=\""+rset.getString("invoke_routine")+"\">");
								out.println("<input type='hidden' name='nat_data_source_id' id='nat_data_source_id' value=\""+rset.getString("nat_data_source_id")+"\">");
							}
							else
							{
								out.println("<input type='hidden' name='national_id_no' id='national_id_no' value=''>");	
							}
                        
            _bw.write(_wl_block33Bytes, _wl_block33);
if( rset.getString("alt_id1_type") != null ) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( (rset.getString("alt_id1_desc") == null? "":rset.getString("alt_id1_desc")) ));
            _bw.write(_wl_block35Bytes, _wl_block35);

                               if ( rset.getString("Alt_Id1_Unique_Yn").equals("Y") )
                                    exe_str = "checkAlternateIdForUnique(document.forms[0].alt_id1_no,1,'"+rset.getString("alt_id1_len_validation_yn")+"','"+rset.getString("alt_id1_routine_yn")+"','"+rset.getString("alt_id1_routine")+"','"+ (rset.getString("alt_id1_chk_digit_scheme")==null?"":rset.getString("alt_id1_chk_digit_scheme"))+"')";
                                else 
                                    exe_str = "checkAltIDLength(document.forms[0].alt_id1_no,1,'"+rset.getString("alt_id1_len_validation_yn")+"','"+rset.getString("alt_id1_routine_yn")+"','"+rset.getString("alt_id1_routine")+"','"+ (rset.getString("alt_id1_chk_digit_scheme")==null?"":rset.getString("alt_id1_chk_digit_scheme"))+"','"+alt_id1_accept_alphanumeric_yn+"')";

                                out.println("<input type='text' name='alt_id1_no' id='alt_id1_no' onBlur='return makeValidString(this);' maxlength='"+rset.getString("Alt_Id1_length")+"' size='15' value=\""+a_alt_id1_no+"\" onChange=\""+exe_str+"\" tabIndex='4'>");
                                out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_gif'></img>") ;
                                out.println("<input type='hidden' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value='"+rset.getString("alt_id1_reqd_yn")+"'> ");
                                

                                if(rset.getString("alt_id1_exp_date_accept_yn").equals("Y"))  
                                {
                                    out.println("</td><td class='label' nowrap align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
                                    out.println("<td><input type='text' name='alt_id1_exp_date' id='alt_id1_exp_date' maxlength='10' size='8' id='altidexpdate1' onblur='makeValidString(this);checkExpiryDate(this,1)' tabIndex='5' readOnly onChange=\"document.getElementById('alt_exp_date_fromHCS').value='N'\"><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt1' disabled onClick=\"document.forms[0].alt_id1_exp_date.select();return showCalendar('altidexpdate1');\" tabindex=-1></td>");
                                }
                                else
                                out.println("<td colspan=2> </td>") ;

                                out.println("<input type='hidden' name='alt_id1_type' id='alt_id1_type' value=\""+rset.getString("Alt_Id1_Type")+"\">");
                                
                                if(patient_grp.equals("A") ||!AltIdNo.equals("") )
								{
                                }
                                exe_str = exe_str.substring(0,exe_str.indexOf("("));
                                exe_str = exe_str+"`"+rset.getString("alt_id1_len_validation_yn")+"`"+rset.getString("Alt_Id1_length")+"`"+rset.getString("alt_id1_chk_digit_scheme") ;

                                out.println("<input type='hidden' name='Alt_id1_Valid_data' id='Alt_id1_Valid_data' value=\""+exe_str+"\">");
								if(rset.getString("alt_id1_exp_date_accept_yn").equals("N"))  
                                {
									out.println("</td>") ;
								}
                            
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
if( rset.getString("alt_id2_type") != null ) {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( (rset.getString("alt_id2_desc") == null? "":rset.getString("alt_id2_desc")) ));
            _bw.write(_wl_block35Bytes, _wl_block35);

                               if ( rset.getString("Alt_Id2_Unique_Yn").equals("Y") )
                                    exe_str = "checkAlternateIdForUnique(document.forms[0].alt_id2_no,2,'"+rset.getString("alt_id2_len_validation_yn")+"','"+rset.getString("alt_id2_routine_yn")+"','"+rset.getString("alt_id2_routine")+"','"+(rset.getString("alt_id2_chk_digit_scheme") == null ?"":rset.getString("alt_id2_chk_digit_scheme"))+"')";
                                else 
                                    exe_str = "checkAltIDLength(document.forms[0].alt_id2_no,2,'"+rset.getString("alt_id2_len_validation_yn")+"','"+rset.getString("alt_id2_routine_yn")+"','"+rset.getString("alt_id2_routine")+"','"+(rset.getString("alt_id2_chk_digit_scheme") == null ?"":rset.getString("alt_id2_chk_digit_scheme"))+"')";

                                out.println("<input type='text' name='alt_id2_no' id='alt_id2_no' onBlur='return makeValidString(this);' maxlength='"+rset.getString("alt_id2_length")+"' size='15' value=\""+AltIdNo2+"\" onChange=\""+exe_str+"\" tabIndex='6'>");
                                out.println("<input type='hidden' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value='"+rset.getString("alt_id2_reqd_yn")+"'> ");
                                if(rset.getString("alt_id2_reqd_yn").equals("Y"))
                                    out.println("<img src='../../eCommon/images/mandatory.gif'></img>") ;
                                else
                                    out.println("");

                                if(rset.getString("alt_id2_exp_date_accept_yn").equals("Y"))  
                                {
                                    out.println("</td><td class='label' nowrap align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
                                    out.println("<td><input type='text' name='alt_id2_exp_date' id='alt_id2_exp_date' maxlength='10' size='8' id='altidexpdate2' onblur='makeValidString(this);checkExpiryDate(this,2)' tabIndex='7' readOnly><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt2' disabled onClick=\"document.forms[0].alt_id2_exp_date.select();return showCalendar('altidexpdate2');\" tabindex=-1></td>");
                                }
                                else
                                    out.println("<td colspan=2></td>") ;
                                out.println("<input type='hidden' name='alt_id2_type' id='alt_id2_type' value=\""+rset.getString("alt_id2_Type")+"\">");

								if(!AltIdNo2.equals(""))
								{
								}

								exe_str = exe_str.substring(0,exe_str.indexOf("("));
								exe_str=exe_str+"`"+rset.getString("alt_id2_len_validation_yn")+"`"+rset.getString("Alt_Id2_length")+"`"+rset.getString("alt_id2_chk_digit_scheme") ;

                                out.println("<input type='hidden' name='Alt_id2_Valid_data' id='Alt_id2_Valid_data' value=\""+exe_str+"\">");
                                if(rset.getString("alt_id2_exp_date_accept_yn").equals("N"))  
                                {
									out.println("</td>");
								}
                            
            _bw.write(_wl_block36Bytes, _wl_block36);
}
                      else
                        out.println("<td colspan='4'></td>");
                    
            _bw.write(_wl_block39Bytes, _wl_block39);
if( rset.getString("alt_id3_type") != null ) {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( (rset.getString("alt_id3_desc") == null? "":rset.getString("alt_id3_desc")) ));
            _bw.write(_wl_block35Bytes, _wl_block35);

                               if ( rset.getString("alt_id3_Unique_Yn").equals("Y") )
                                    exe_str = "checkAlternateIdForUnique(document.forms[0].alt_id3_no,3,'"+rset.getString("alt_id3_len_validation_yn")+"','"+rset.getString("alt_id3_routine_yn")+"','"+rset.getString("alt_id3_routine")+"','"+ (rset.getString("alt_id3_chk_digit_scheme") == null?"":rset.getString("alt_id3_chk_digit_scheme"))+"')";
                                else 
                                    exe_str = "checkAltIDLength(document.forms[0].alt_id3_no,3,'"+rset.getString("alt_id3_len_validation_yn")+"','"+rset.getString("alt_id3_routine_yn")+"','"+rset.getString("alt_id3_routine")+"','"+ (rset.getString("alt_id3_chk_digit_scheme") == null?"":rset.getString("alt_id3_chk_digit_scheme"))+"')";

                                out.println("<input type='text' name='alt_id3_no' id='alt_id3_no' maxlength='"+rset.getString("alt_id3_length")+"' onBlur='return makeValidString(this);' size='15' value=\""+AltIdNo3+"\" onChange=\""+exe_str+"\" tabIndex='8'>");
                                out.println("<input type='hidden' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value='"+rset.getString("alt_id3_reqd_yn")+"'> ");
                                if(rset.getString("alt_id3_reqd_yn").equals("Y"))
                                    out.println("<img src='../../eCommon/images/mandatory.gif'></img>") ;
                                else
                                    out.println("");

                                if(rset.getString("alt_id3_exp_date_accept_yn").equals("Y"))  
                                {
                                    out.println("</td><td class='label' nowrap align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
                                    out.println("<td><input type='text' name='alt_id3_exp_date' id='alt_id3_exp_date' maxlength='10' size='8'  onblur='makeValidString(this);checkExpiryDate(this,3)' tabIndex='9' readOnly><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt3' disabled onClick=\"document.forms[0].alt_id3_exp_date.select();return showCalendar('alt_id_exp_dt3');\" tabindex=-1></td>");
                                }
                                else
                                     out.println("<td colspan=2></td>") ;

                                out.println("<input type='hidden' name='alt_id3_type' id='alt_id3_type' value=\""+rset.getString("alt_id3_Type")+"\">");

								if(!AltIdNo3.equals(""))
								{
								}
								exe_str = exe_str.substring(0,exe_str.indexOf("("));
								exe_str = exe_str+"`"+rset.getString("alt_id3_len_validation_yn")+"`"+rset.getString("Alt_Id3_length")+"`"+rset.getString("alt_id3_chk_digit_scheme") ;

                                out.println("<input type='hidden' name='Alt_id3_Valid_data' id='Alt_id3_Valid_data' value=\""+exe_str+"\">");
                                if(rset.getString("alt_id3_exp_date_accept_yn").equals("N"))  
                                {
									out.println("</td>");
								}
                            
            _bw.write(_wl_block36Bytes, _wl_block36);
}
                      else
                        out.println("<td colspan='4'></td>");
                    
            _bw.write(_wl_block40Bytes, _wl_block40);
if( rset.getString("alt_id4_type") != null ) {
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( (rset.getString("alt_id4_desc") == null? "":rset.getString("alt_id4_desc")) ));
            _bw.write(_wl_block42Bytes, _wl_block42);

                           if ( rset.getString("alt_id4_Unique_Yn").equals("Y") )
                                exe_str = "checkAlternateIdForUnique(document.forms[0].alt_id4_no,4,'"+rset.getString("alt_id4_len_validation_yn")+"','"+rset.getString("alt_id4_routine_yn")+"','"+rset.getString("alt_id4_routine")+"','"+ (rset.getString("alt_id4_chk_digit_scheme")==null?"":rset.getString("alt_id4_chk_digit_scheme"))+"')";

                            else 
                                exe_str = "checkAltIDLength(document.forms[0].alt_id4_no,4,'"+rset.getString("alt_id4_len_validation_yn")+"','"+rset.getString("alt_id4_routine_yn")+"','"+rset.getString("alt_id4_routine")+"','"+ (rset.getString("alt_id4_chk_digit_scheme")==null?"":rset.getString("alt_id4_chk_digit_scheme"))+"')";

                            out.println("<input type='text' name='alt_id4_no' id='alt_id4_no' onBlur='return makeValidString(this);' maxlength='"+rset.getString("alt_id4_length")+"' size='15' value=\""+AltIdNo4+"\" onChange=\""+exe_str+"\" tabIndex='10'>");
                            out.println("<input type='hidden' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value=\""+rset.getString("alt_id4_reqd_yn")+"\"> ");
                            if(rset.getString("alt_id4_reqd_yn").equals("Y"))
                                out.println("<img src='../../eCommon/images/mandatory.gif'></img>") ;
                            else
                                 out.println("");

                            if(rset.getString("alt_id4_exp_date_accept_yn").equals("Y")) 
                            {
                               out.println("</td><td class='label' nowrap align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
                               out.println("<td><input type='text' name='alt_id4_exp_date' id='alt_id4_exp_date' maxlength='10' size='8' id='altidexpdate4' onblur='makeValidString(this);checkExpiryDate(this,4)' tabIndex='11' readOnly><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt4' disabled onClick=\"document.forms[0].alt_id4_exp_date.select();return showCalendar('altidexpdate4');\" tabindex=-1>");
                            }
                            else
                                out.println("<td colspan=2></td>") ;
                            out.println("<input type='hidden' name='alt_id4_type' id='alt_id4_type' value=\""+rset.getString("alt_id4_Type")+"\"></td>");

							if(!AltIdNo4.equals("") ) 
							{
							}
							exe_str = exe_str.substring(0,exe_str.indexOf("("));
							exe_str=exe_str +"`"+rset.getString("alt_id4_len_validation_yn")+"`"+rset.getString("Alt_Id4_length")+"`"+rset.getString("alt_id4_chk_digit_scheme") ;

							out.println("<input type='hidden' name='Alt_id4_Valid_data' id='Alt_id4_Valid_data' value=\""+exe_str+"\">");
							if(rset.getString("alt_id4_exp_date_accept_yn").equals("N")) 
                            {
								out.println("</td>");
							}
                        
            _bw.write(_wl_block43Bytes, _wl_block43);
}
                    else
                        out.println("<td colspan='4'></td>");
                  
            _bw.write(_wl_block44Bytes, _wl_block44);

					  
				  if(Accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

						 if(sql.length() > 0) sql.delete(0,sql.length());
					  sql.append("select alt_id_type,substr(SHORT_DESC,1,10) SHORT_DESC from mp_alternate_id_type where alt_id_type not in (select alt_id1_type from mp_param union select nvl(alt_id2_type,1) from mp_param union select nvl(alt_id3_type,2) from mp_param union select nvl(alt_id4_type,3) from mp_param) and eff_status='E' order by 2");
						stmt = conn.createStatement();
					oth_rset = stmt.executeQuery(sql.toString());
					if(oth_rset != null){
						while (oth_rset.next()){          
							out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
						}
					}
					  
				  
					
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
	
		if ( Name_Prefix_Accept_Yn.equals("Y") )
			out.println("<td align='left' class='label'>"+Name_Prefix_Prompt);

		if (Name_Prefix_Reqd_Yn.equals("Y")  )
			out.println("<img name='id2' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
		else
			out.println("</td>");
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) 
		{
			out.println("<td align='left' class='label' >"+First_Name_Prompt);
			if (First_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='fid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) 
		{
			out.println("<td align='left' class='label' >" + Second_Name_Prompt);
			if (Second_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='sid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  
		{
			out.println("<td align='left' class='label' >" + Third_Name_Prompt);
			if (Third_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='tid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) 
		{
			out.println("<td align='left' class='label' >"+Family_Name_Prompt);
			if ( Family_Name_Reqd_Yn.equals("Y") )
				out.println("<img name='faid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) 
		{
			out.println("<td align='left' class='label' >"+ First_Name_Prompt);
			if (First_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='fid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) 
		{
			out.println("<td align='left' class='label' >" + Second_Name_Prompt);
			if (Second_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='sid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  
		{
			out.println("<td align='left' class='label' >" + Third_Name_Prompt);
			if (Third_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='tid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) 
		{
			out.println("<td align='left' class='label' >"+Family_Name_Prompt);
			if ( Family_Name_Reqd_Yn.equals("Y") )
				out.println("<img name='faid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		

		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) 
		{
			out.println("<td align='left' class='label' >"+ First_Name_Prompt);
			if (First_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='fid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) 
		{
			out.println("<td align='left' class='label' >" + Second_Name_Prompt);
			if (Second_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='sid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  
		{
			out.println("<td align='left' class='label' >" + Third_Name_Prompt);
			if (Third_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='tid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) 
		{
			out.println("<td align='left' class='label' >"+Family_Name_Prompt);
			if ( Family_Name_Reqd_Yn.equals("Y") )
				out.println("<img name='faid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) 
		{
			out.println("<td align='left' class='label' >"+ First_Name_Prompt);
			if (First_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='fid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) 
		{
			out.println("<td align='left' class='label' >" + Second_Name_Prompt);
			if (Second_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='sid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  
		{
			out.println("<td align='left' class='label' >" + Third_Name_Prompt);
			if (Third_Name_Reqd_Yn.equals("Y")  )
				out.println("<img name='tid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) 
		{
			out.println("<td align='left' class='label' >"+Family_Name_Prompt);
			if ( Family_Name_Reqd_Yn.equals("Y") )
				out.println("<img name='faid' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
			else
				out.println("</td>");
		}
		
		if ( Name_Suffix_Accept_Yn.equals("Y") )
			out.println("<td align='left' class='label' >"+Name_Suffix_Prompt);

		if (Name_Suffix_Reqd_Yn.equals("Y")  )
			out.println("<img name='id1' src='../../eCommon/images/mandatory.gif' align='center'></img></td>");
		else
			out.println("</td>");
		
		
            _bw.write(_wl_block50Bytes, _wl_block50);

		if ( Name_Prefix_Accept_Yn.equals("Y") )
		{
			//Added on 14/03/2003
			out.println("<td align='left'>") ;
			if (pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<select onchange='putPatientName(this);' name='name_prefixz' id='name_prefixz'  style='width: 200px'>") ; }
			else
			{	out.println("<select onchange='putPatientName(this);' name='name_prefixz' id='name_prefixz'  style='width: 90px'>") ;
			}
			//End of Addtion on 14/03/2003

			out.println("<Option value=''>&nbsp--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp---</option>");
			stmt4=conn.createStatement();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("Select Name_Prefix from Mp_Name_Prefix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1");
			rs4 = stmt4.executeQuery(sql.toString());
				while( rs4.next() ) {
					String a=rs4.getString("Name_Prefix");

				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(a));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(rs4.getString("Name_Prefix")));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}
		
			if (Name_Prefix_Reqd_Yn.equals("Y")  )
			{
				out.println("</select><input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("</select><input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'></input>");
			}
			
			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
				out.println("<input type='hidden' name='first_name' id='first_name' size='15' maxlength='20'>");
			}
			else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
				out.println("<input type='hidden' name='second_name' id='second_name' size='15' maxlength='20'>");
			}
			else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
				out.println("<input type='hidden' name='third_name' id='third_name' size='15' maxlength='20'>");
			}
			else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
				out.println("<input type='hidden' name='family_name' id='family_name' size='15' maxlength='20'>");
			}
		
		out.println("</td>");
		}
		// Ended on 14/03/2003 for Prifix select box
	
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 )
		{
				out.println("<td align='left' nowrap><input type='text' name='first_name' id='first_name' maxlength='20' size='15' value='"+firstname+"'  onBlur=putPatientName(this,'firstname') >");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
		{
			out.println("<td align='left' nowrap><input type='text' name='second_name' id='second_name' maxlength='20' size='15' value='"+secondname+"' onBlur=putPatientName(this,'secondname') >");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )
		{
			out.println("<td align='left' nowrap><input type='text' name='third_name' id='third_name' maxlength='20' size='15' value='"+thirdname+"'  onBlur=putPatientName(this,'thirdname') >");
		
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		//Added on 14/03/2003 for Family Name
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 )
		{
			
			//Added on 14/03/2003 for Family name
			if(pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='40' size='40' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");

			}
			else
			{	
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='15' size='15' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");			
			
			}
			//End of 14/03/2003

			if ( Family_Name_Reqd_Yn.equals("Y") )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		//Ended on 14/03/2003 for Family Name
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 )
		{
			out.println("<td align='left' nowrap><input type='text' name='first_name' id='first_name' maxlength='20' size='15' value='"+firstname+"' onBlur=putPatientName(this,'firstname') >");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 )
		{
			out.println("<td align='left' nowrap><input type='text' name='second_name' id='second_name' maxlength='20' size='15' value='"+secondname+"'  onBlur=putPatientName(this,'secondname') >");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )
		{
			out.println("<td align='left' nowrap><input type='text' name='third_name' id='third_name' maxlength='20' size='15' value='"+thirdname+"' onBlur=putPatientName(this,'thirdname') >");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 )
		{
			//Added on 14/03/2003 for Family name
			if(pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='40' size='40' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");

			}
			else
			{	
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='15' size='15' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");			
			
			}
			//End of 14/03/2003
		
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 )
		{
			out.println("<td align='left' nowrap><input type='text' name='first_name' id='first_name' maxlength='20' size='15' value='"+firstname+"'  onBlur=putPatientName(this,'firstname') >");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 )
		{
			out.println("<td align='left' nowrap><input type='text' name='second_name' id='second_name' maxlength='20' size='15' value='"+secondname+"'  onBlur=putPatientName(this,'secondname') >");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )
		{
			out.println("<td align='left' nowrap><input type='text' name='third_name' id='third_name' maxlength='20' size='15' value='"+thirdname+"'  onBlur=putPatientName(this,'thirdname') >");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 )
		{
			//Added on 14/03/2003 for Family name
			if(pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='40' size='40' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");

			}
			else
			{	
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='15' size='15' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");			
			
			}
			//End of 14/03/2003
			
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 )
		{
			out.println("<td align='left' nowrap><input type='text' name='first_name' id='first_name' maxlength='20' size='15' value='"+firstname+"'  onBlur=putPatientName(this,'firstname') >");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 )
		{
			out.println("<td align='left' nowrap><input type='text' name='second_name' id='second_name' maxlength='20' size='15' value='"+secondname+"'  onBlur=putPatientName(this,'secondname') >");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )
		{
			out.println("<td align='left' nowrap><input type='text' name='third_name' id='third_name' maxlength='20' size='15' value='"+thirdname+"'  onBlur=putPatientName(this,'thirdname') >");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 )
		{
			//Added on 14/03/2003 for Family name
			if(pat_name_as_multipart_yn.equals("N"))
			{
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='40' size='40' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");

			}
			else
			{	
				out.println("<td align='left' nowrap><input type='text' name='family_name' id='family_name' maxlength='15' size='15' value='"+familyname+"'  onBlur=makeValidString(this);ChangeInitCase(this);putPatientName(this,'familyname') >");			
			
			}
			//End of 14/03/2003
			
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		
		if ( Name_Suffix_Accept_Yn.equals("Y") )
		{
			out.println("<td align='left' nowrap><select name='name_suffixz' id='name_suffixz' onChange=putPatientName(this,'namesuffix')>");
			out.println("<Option value=''>---&nbsp"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp---</option>");
			stmt5=conn.createStatement();
			sql.append("Select Name_Suffix from Mp_Name_Suffix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1");
			rs5 = stmt5.executeQuery(sql.toString());
			if(rs5 != null ) {
				while(rs5.next()) {
					String b=rs5.getString("name_suffix");
					
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( b ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(b));
            _bw.write(_wl_block55Bytes, _wl_block55);

				}
			}
		
			if (Name_Suffix_Reqd_Yn.equals("Y")  )
			{
				out.println("</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		

            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

			if(gender.equals("M")) {
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
 } else if(gender.equals("F")) {
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
 } else if(gender.equals("U")) {
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
 } else if(gender.equals("") || gender==null) {
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(agey));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(agem));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(aged));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(str13));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
					

			String sql2 = "Select country_code,long_desc from mp_country where eff_status = 'E' order by long_desc";					
					out.println(sql2);
					stmt10= conn.createStatement();
					rs10 = stmt10.executeQuery(sql2);
					if( rs10 != null )
					 {
						while( rs10.next() )
						{
							String nationality   = rs10.getString(1) ;
							String natname = rs10.getString(2) ;

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( nationality ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( natname ));
            _bw.write(_wl_block1Bytes, _wl_block1);
			  			}
					 }
					

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MailingAddress.label","common_labels")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(Name_Suffix_Prompt));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(Name_Prefix_Prompt));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(Alt_Id1_Type));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(prn_tel_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(orn_tel_no));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(postal_code1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(countrycode));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(addrl1));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(addrl2));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(addrl3));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(addrl4));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(unregisteredpatientsbkgyn));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(unregisteredpatientsbkgyn));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(prn_tel_no));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(orn_tel_no));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(postal_code1));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(countrycode));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(addrl1));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(addrl2));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(addrl3));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(addrl4));
            _bw.write(_wl_block108Bytes, _wl_block108);

	if(stmt!=null) stmt.close();
	if(stmt4!=null) stmt4.close();
	if(stmt5!=null) stmt5.close();

	if(stmtsd!=null) stmtsd.close();
	if(stmtlen!=null) stmtlen.close();
	if(rst!=null) rst.close();
	if(rs!=null) rs.close();
	if(rs4!=null) rs4.close();
	if(rs5!=null) rs5.close();
	if(rssd!=null) rssd.close();
	if(rslen!=null) rslen.close();
	if(rs10!=null) rs10.close();
	if(stmt10!=null) stmt10.close();
	if(rs20 != null) rs20.close();
	if(stmt20 != null) stmt20.close();

} catch(Exception e ){out.println("Exception@1: "+e);
}finally
{
	ConnectionManager.returnConnection(conn,request);
}
            _bw.write(_wl_block109Bytes, _wl_block109);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otheraltid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
