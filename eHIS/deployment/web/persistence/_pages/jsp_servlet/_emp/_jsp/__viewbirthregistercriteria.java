package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __viewbirthregistercriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ViewBirthRegisterCriteria.jsp", 1742452490804L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/23/2005 11:34 AM -->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eMP/js/NewbornRegistration.js\' language=\'javascript\'></script>\n<script src=\'../../eMP/js/NewbornRegistration1.js\' language=\'javascript\'></script>\n<script src=\'../../eMP/js/NewbornRegistration2.js\' language=\'javascript\'></script>\n<!-- <Script src=\"../../eMP/js/MaintainBirthRegistration.js\" language=\"JavaScript\"></Script> -->\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<Script src=\'../../eMP/js/ViewBirthDetails.js\' language=\'JavaScript\'></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script src=\'../../eMP/js/NameSuffix.js\' language=\'javascript\'></script>\n\n<!--\t\n\t\tThe following methods are moved to ViewBirthDetails.js :\n\t\tEnableFamSearch(),DefaultSelect(),checkReadOnly(),makeToDateEnable(),ChangeCase(),\n\t\tDobToCheck() ,changeOtherInput(),changeInputFocus(), PatSearch(), formatFlds(),callEmpty()\n-->\n\n<script>\nvar flag;\nvar strand=\" AND \";\n\tfunction Posting()\n\t{\n\n\t\tvar flag=false;\n\t\tif(document.getElementById(\"names_search_by\").value==\"\")\n\t\t{\n\t\t\tflag=true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(document.birth_register_Form.first_name.value != \"\" || document.birth_register_Form.second_name.value != \"\" || document.birth_register_Form.third_name.value != \"\" || document.birth_register_Form.family_name.value != \"\")\n\t\t\t{\n\t\t\t\tflag=true;\n\t\t\t}\n\n\t\t}\n\t\tif(flag==true)\n\t\t{\n\t\tvar PatientID=document.birth_register_Form.Patient_Id.value;\n\t\tvar MotherPatientID= document.birth_register_Form.Mother_Patient_Id.value;\n\t\tif(document.birth_register_Form.Alt_Id1_No)\n\t\tvar AltId1No = document.birth_register_Form.Alt_Id1_No.value;\n\t\tif(document.birth_register_Form.Alt_Id2_No)\n\t\tvar AltId2No = document.birth_register_Form.Alt_Id2_No.value;\n\t\tif(document.birth_register_Form.Alt_Id3_No)\n\t\tvar AltId3No = document.birth_register_Form.Alt_Id3_No.value;\n\t\tif(document.birth_register_Form.Alt_Id4_No)\n\t\tvar AltId4No = document.birth_register_Form.Alt_Id4_No.value;\n\t\tif(document.birth_register_Form.other_alt_id)\n\t\tvar other_alt_id = document.birth_register_Form.other_alt_id.value;\n\t\tif(document.birth_register_Form.other_alt_Id_no)\n\t\tvar other_alt_Id_no = document.birth_register_Form.other_alt_Id_no.value;\n\t\tif(document.birth_register_Form.nat_id_prompt)\n\t\tvar nat_id_prompt = document.birth_register_Form.nat_id_prompt.value;\n\t\tvar Sex = document.birth_register_Form.Sex.value;\n\t\tvar DOB = document.birth_register_Form.Dob.value;\n\t\tvar DOBTo =document.birth_register_Form.DobTo.value; \n\t\tvar view=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\t\tvar altIDType=document.birth_register_Form.altIDType.value;\n\t\tvar fourth_name=\"\";\n\t\tvar fifth_name=\"\";\n\t\tif (document.birth_register_Form.fourth_name)\n\t\t\tfourth_name = document.birth_register_Form.fourth_name.value;\n\t\tif (document.birth_register_Form.fifth_name)\n\t\t\tfifth_name = document.birth_register_Form.fifth_name.value;\n\t\tvar altIDType1=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\tvar function_id = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tvar regn_type = \"\";\n\t\t//Added by kumar on 17/03/2003 for Malaysia Enhancements\t\t\n\t\tvar searchby = \"\";\n\t\tif (document.forms[0].searchby)\n\t\t\tsearchby = document.forms[0].searchby.value;\n\t\tvar pat_name_as_multipart_yn = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t//End of Addition\n\t\tvar regn_no = \"\";\n\t\tfor (var i=0;i<document.forms[0].elements.length;i++)\n\t\t{\n\t\t\tdocument.forms[0].elements[i].disabled=true;\n\t\t}\n\t\tparent.frames[2].document.forms[0].Search.focus();\n\t\tparent.frames[2].document.forms[0].Search.disabled = true;\n\t\tparent.frames[0].location.href=\'../../eCommon/jsp/process.jsp\';\n\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\tif (parent.frames[1].document.forms[0].searchby)\n\t\t\tif (document.birth_register_Form.soundex_val.value != \'\')\n\t\t\t\tparent.frames[1].document.forms[0].searchby.disabled=true;\n\t\t\n\t\tvar hiddenVals   = \" <html> <head><META HTTP-EQUIV=\'Content-Type\' CONTENT=\'text/html; charset=UTF-8\'></head> \\n\"\n\t\thiddenVals   += \" <body onKeyDown=\'lockKey()\'> <form name=\'tempform\' id=\'tempform\' method=\'post\' action=\'../../eMP/jsp/ViewBirthRegisterResult.jsp\'> \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\\\"\"+function_id+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'Patient_Id\' id=\'Patient_Id\' value=\\\"\"+PatientID+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'Mother_Patient_Id\' id=\'Mother_Patient_Id\' value=\\\"\"+MotherPatientID+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'Alt_Id1_No\' id=\'Alt_Id1_No\' value=\\\"\"+AltId1No+\"\\\" > \\n\" ; \t\t\n\t\thiddenVals   += \" <input type=\'hidden\' name=\'Alt_Id2_No\' id=\'Alt_Id2_No\' value=\\\"\"+AltId2No+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'Alt_Id3_No\' id=\'Alt_Id3_No\' value=\\\"\"+AltId3No+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'Alt_Id4_No\' id=\'Alt_Id4_No\' value=\\\"\"+AltId4No+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'other_alt_id\' id=\'other_alt_id\' value=\\\"\"+other_alt_id+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'other_alt_Id_no\' id=\'other_alt_Id_no\' value=\\\"\"+other_alt_Id_no+\"\\\" > \\n\" ;\n\t\thiddenVals   += \" <input type=\'hidden\' name=\'nat_id_prompt\' id=\'nat_id_prompt\' value=\\\"\"+nat_id_prompt+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'Sex\' id=\'Sex\' value=\\\"\"+Sex+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'Dob\' id=\'Dob\' value=\\\"\"+DOB+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'view\' id=\'view\' value=\\\"\"+view+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'altIDType\' id=\'altIDType\' value=\\\"\"+altIDType1+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'DobTo\' id=\'DobTo\' value=\\\"\"+DOBTo+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'regn_type\' id=\'regn_type\' value=\\\"\"+regn_type+\"\\\" > \\n\" ;\n\t\thiddenVals   += \" <input type=\'hidden\' name=\'regn_no\' id=\'regn_no\' value=\\\"\"+regn_no+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\\\"\"+document.birth_register_Form.first_name.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'second_name\' id=\'second_name\' value=\\\"\"+document.birth_register_Form.second_name.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'third_name\' id=\'third_name\' value=\\\"\"+document.birth_register_Form.third_name.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'family_name\' id=\'family_name\' value=\\\"\"+document.birth_register_Form.family_name.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'fourth_name\' id=\'fourth_name\' value=\\\"\"+fourth_name+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'fifth_name\' id=\'fifth_name\' value=\\\"\"+fifth_name+\"\\\" > \\n\" ;\n\t\t//Added by kumar on 17/03/2003 for Malaysia Enhancements\n\t\thiddenVals   += \" <input type=\'hidden\' name=\'searchby\' id=\'searchby\' value=\\\"\"+searchby+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value=\\\"\"+pat_name_as_multipart_yn+\"\\\" > \\n\" ; \n\t\t//End of Addition\n\t\thiddenVals   += \" <input type=\'hidden\' name=\'soundex\' id=\'soundex\' value=\\\"\"+document.birth_register_Form.soundex_val.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'names_search_by\' id=\'names_search_by\' value=\\\"\"+document.birth_register_Form.names_search_by.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'alt_id1_type_deschd\' id=\'alt_id1_type_deschd\' value=\\\"\"+document.birth_register_Form.alt_id1_type_deschd.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'alt_id2_type_deschd\' id=\'alt_id2_type_deschd\' value=\\\"\"+document.birth_register_Form.alt_id2_type_deschd.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'alt_id3_type_deschd\' id=\'alt_id3_type_deschd\' value=\\\"\"+document.birth_register_Form.alt_id3_type_deschd.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'alt_id4_type_deschd\' id=\'alt_id4_type_deschd\' value=\\\"\"+document.birth_register_Form.alt_id4_type_deschd.value+\"\\\" > \\n\" ; \n\t\thiddenVals   += \" <input type=\'hidden\' name=\'nat_id_prompt_des\' id=\'nat_id_prompt_des\' value=\\\"\"+document.birth_register_Form.nat_id_prompt_des.value+\"\\\" > \\n\" ; \n\t\tif (document.forms[0].names_in_oth_lang)\n\t\t\tif(document.forms[0].names_in_oth_lang.checked )\n\t\t\t\thiddenVals   += \" <input type=\'hidden\' name=\'apply_oth_name\' id=\'apply_oth_name\' value=\'Y\' > \\n\" ; \n\t\thiddenVals   += \" </form></body></html> \\n\" ; \n\t\tparent.frames[3].document.body.insertAdjacentHTML(\'afterbegin\',hiddenVals);\n\t\t\n\t\tparent.frames[3].document.forms[0].submit();\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\talert(getMessage(\'ONE_NAME_ENTER\',\'MP\'));\n\t\t\tparent.frames[0].location.href=\'../../eMP/jsp/BirthRegisterToolBar.jsp\';\n\t\t\treturn;\n\t\t}\n}\n\nfunction setFields()\n{\n\tvar sp=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\tEnableFamSearch(document.forms[0].soundex_val);\n\tif(document.forms[0].names_search_by.value==\"F\")\n\t{\n\t\t//document.getElementById(\'aa\').innerHTML=getLabel(\'eMP.fathername.label\',\'MP\');\n\t\t//document.forms[0].soundex_val.disabled=true;\n\t//\tdocument.forms[0].family_name.value=\"\";\n\t\tif(document.forms[0].searchby)\n\t\t\tdocument.forms[0].searchby.disabled=false;\n\t}\n\t\n\telse\n\t{\n\t\t//document.getElementById(\'aa\').innerHTML=sp;\n\t\tdocument.forms[0].soundex_val.disabled=false;\n\t}\n\n\tif(document.forms[0].names_search_by.value != \"\")\n\t{\n\t\tdocument.birth_register_Form.first_name.disabled =  false; document.birth_register_Form.second_name.disabled = false; document.birth_register_Form.third_name.disabled = false; document.birth_register_Form.family_name.disabled = false;\n\t}\n\telse\n\t{\n\tdocument.birth_register_Form.first_name.disabled =  true; document.birth_register_Form.second_name.disabled = true; document.birth_register_Form.third_name.disabled = true; document.birth_register_Form.family_name.disabled = true;\n\n\tdocument.birth_register_Form.first_name.value =  \"\";\n\tdocument.birth_register_Form.second_name.value = \"\"; \n\tdocument.birth_register_Form.third_name.value = \"\"; \n\tdocument.birth_register_Form.family_name.value = \"\";\n\t}\n}\n\n</script>\n\n</head>\n\n<body ID=\'HR\' class=\'content\'  onload=\"FocusFirstElement();DefaultSelect(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');EnableFamSearch(document.forms[0].soundex_val)\" onKeyDown = \'lockKey()\'>\n\n<form name=\"birth_register_Form\" id=\"birth_register_Form\" action=\'../../eMP/jsp/ViewBirthRegisterResult.jsp\' target=\'results\'>\n\n<center>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n\n<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n<tr>\n\t<td width=\"100%\" class=\"BORDER\">\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\">\n\t\t\t<tr>\n\t\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"FIELDS\"><input type=\"text\" name=\"Patient_Id\" id=\"Patient_Id\" size=\"15\" maxlength=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" \n\t\t\t\tonFocus=\"changeInputFocus(this)\" onKeyPress=\'return CheckForSpecChars(event)\'\n\t\t\t\tonBlur=\"makeValidQueryCriteria(this);ChangeUpperCase(this);\"  \n\t\t\t\t></td>\t\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"fields\" ><input type=\'checkbox\' name=\'names_in_oth_lang\' id=\'names_in_oth_lang\' value=\'Y\' checked></td>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t           <td  class=\'fields\' >\t\t\t\t\t\t\n\t           </td>\n\t           ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \n\t\t\t</tr>\t\t\t\t \n\t\t\t<tr><td class=\"label\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td  class=\"FIELDS\"><input type=\"text\" id=\"dobfrom\" name=\"Dob\" id=\"Dob\" size=\"8\" onBlur=\"makeToDateEnable(this);DobToCheck();\" maxlength=\"10\"><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"showCalendar(\'dobfrom\');document.forms[0].Dob.select();\" tabindex=-1></img>-<input type=\"text\" id=\"dobto\" name=\"DobTo\" id=\"DobTo\" size=\"8\" onBlur=\"validDateObj(this,\'DMY\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');DobToCheck();\" maxlength=\"10\"  ><img src=\'../../eCommon/images/CommonCalendar.gif\' id=\"dobtoimg\" disabled onClick=\"showCalendar(\'dobto\');document.forms[0].DobTo.select();\" tabindex=-1></img></td>\t\n\t\t\t\t<td width=\"25%\" class=\"label\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"FIELDS\"><Select name=\"Sex\" id=\"Sex\"><Option value=\"\" >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option><Option value=\"M\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option><Option value=\"F\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option><Option value=\"U\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option></Select></td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr> \n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\t\t \n\t\t\t\t<td  class=\"FIELDS\"><input type=\"text\" name=\"Mother_Patient_Id\" id=\"Mother_Patient_Id\" size=\"15\" maxlength=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  \n\t\t\t\tonFocus=\"changeInputFocus(this)\"\n\t\t\t\tonKeyPress=\'return CheckForSpecChars(event)\'\tonBlur=\"makeValidQueryCriteria(this);ChangeUpperCase(this);\" ><input type=\'button\' class=\'button\' value=\'?\' tabIndex=\'-1\' name=\"search\" id=\"search\" onClick=\"PatSearch(); \"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t<td class=\"FIELDS\"><input type=\"text\" name=\"Alt_Id1_No\" id=\"Alt_Id1_No\" size=\"15\" maxlength=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\n\t\t\t\tonFocus=\"changeInputFocus(this)\"\n\t\t\t\tonKeyPress=\'return CheckForSpecChars(event)\'\n\t\t\t\t <!--onblur = \"checkReadOnly();--> makeValidQueryCriteria(this);\"></td>\n\t               ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t \t\t\t\n\t\t\t\t <input type =\"hidden\" name=\"alt_id1_Type\" id=\"alt_id1_Type\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t  \n\t\t\t\t </tr>\n\t\t\t\t <tr>\n\t\t\t\t  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t <td class=\"label\" >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t<td class=\"FIELDS\"><input type=\"text\" name=\"Alt_Id2_No\" id=\"Alt_Id2_No\" size=\"15\" maxlength=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"\n\t\t\t\tonFocus=\"changeInputFocus(this)\"\n\t\t\t\tonKeyPress=\'return CheckForSpecChars(event)\' makeValidQueryCriteria(this);\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t <input type =\"hidden\" name=\"alt_id2_Type\" id=\"alt_id2_Type\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t<td class=\"FIELDS\"><input type=\"text\" name=\"Alt_Id3_No\" id=\"Alt_Id3_No\" size=\"15\" maxlength=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"\n\t\t\t\tonFocus=\"changeInputFocus(this)\"\n\t\t\t\tonKeyPress=\'return CheckForSpecChars(event)\' makeValidQueryCriteria(this);\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t <input type =\"hidden\" name=\"alt_id3_Type\" id=\"alt_id3_Type\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t  \n\t\t\t\t </tr>\n\t\t\t\t  <tr>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t<td class=\"FIELDS\"><input type=\"text\" name=\"Alt_Id4_No\" id=\"Alt_Id4_No\" size=\"15\" maxlength=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t <input type =\"hidden\" name=\"alt_id4_Type\" id=\"alt_id4_Type\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t<td class=\"FIELDS\"><input type=\"text\" name=\"nat_id_prompt\" id=\"nat_id_prompt\" size=\"15\" maxlength=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\n\t\t\t\t <input type =\"hidden\" name=\"alt_id4_Type\" id=\"alt_id4_Type\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t  \n\t\t\t\t </tr>\n\t\t\t\t   <tr>\n\t\t\t\t  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\' class=\"label\" >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\' class=\"fields\" ><select onchange=\'enableOtherAltId(this.value)\' name=\'other_alt_id\' id=\'other_alt_id\' ><option value=\'\'>----";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="----\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  class=label  width=\'25%\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t\t\t\t<td class=fields  width=\'25%\'><input type =\'text\' name = \'other_alt_Id_no\' value=\"\" size=\'25\' disabled  maxlength=\'20\'  onKeyPress=\"return CheckForSpecChars(event)\"></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t     </tr>\n\t\t\t\t \n\t\t\t     <tr> \n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t<td  class=\"FIELDS\"><select name=\"names_search_by\" id=\"names_search_by\" onchange=\"setFields(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\')\">\n\t\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="----</option>\n\t\t\t\t\t\t<option value=\"B\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</option>\n\t\t\t\t\t\t<option value=\"M\" >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</option>\n\t\t\t\t\t\t<option value=\"F\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t</td>\n                   ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t                <td class=\"FIELDS\"><Select name=\"soundex_val\" id=\"soundex_val\" onChange=\"EnableFamSearch(this)\" tabindex=14><Option value=\"\">---";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="---<Option value=\"E\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<Option value=\"G\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</Select></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\t<td class=\"label\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t\t\t\t<td class=\"FIELDS\"><Select name=\"soundex_val\" id=\"soundex_val\" tabindex=14><Option value=\"\">---";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</Select></td>                 \n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t<td colspan=2><input type=\'hidden\' name=\'soundex_val\' id=\'soundex_val\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" \n\t\t\t\t \n\t\t\t\t\t\n\n\t\t\t</tr>\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t</table>\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t\t<tr> \n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t\t\t\t\t\n\t\t\t\t\t<td width=\'25%\' class=\"LABELLEFT\" ><div id=\"aa\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</div></td>\n\t\t\t\t\t<td colspan=3></td>\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t<td width=\'25%\' class=\"LABELLEFT\" >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t\t\t<td width=\'25%\' class=\"LABELLEFT\" >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t\t\t\t<td width=\'25%\' class=\"LABELLEFT\" ><div id=\"aa\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</div></td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr> \n\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'first_name\' id=\'first_name\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'second_name\' id=\'second_name\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'third_name\' id=\'third_name\'>\n\t\t\t\t\t\t<td class=\"FIELDS\"  ><input type=\'text\' maxlength=\'40\' size=\'40\' name=\'family_name\' id=\'family_name\' disabled onBlur=\'makeValidQueryCriteria(this)\'></td>\n\t\t\t\t\t\t<td class=\"FIELDS\" ><select disabled name=\'searchby\' id=\'searchby\'><option selected value=\'\'>------";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="-----</option><option value=\'S\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</option><option value=\'C\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</option><option value=\'E\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</option></select></td>\n\t\t\t\t\t\t<td colspan=2></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t<td   class=\"FIELDS\"><input type=\'text\'  maxlength=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' size=\'30\' name=\'first_name\' onBlur=\'makeValidQueryCriteria(this)\' disabled></td>\n\t\t\t\t\t<td  class=\"FIELDS\"><input type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' size=\'30\' name=\'second_name\' onBlur=\'makeValidQueryCriteria(this)\' disabled></td>\n\t\t\t\t\t<td  class=\"FIELDS\"><input type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' size=\'30\' name=\'third_name\' onBlur=\'makeValidQueryCriteria(this)\' disabled></td>\n\t\t\t\t\t<td  class=\"FIELDS\"><input type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' size=\'30\' name=\'family_name\' onBlur=\'makeValidQueryCriteria(this)\' disabled></td>\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t<tr><td colspan=\'4\'></td></tr>\n\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t</table>\n\t</td>\n</tr>\n</table>\n</center>\n<input type =\"hidden\" name=\"altIDType\" id=\"altIDType\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n<input type =\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n<input type =\"hidden\" name=\"func_idpassed\" id=\"func_idpassed\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<input type =\"hidden\" name=\"alt_id1_type_deschd\" id=\"alt_id1_type_deschd\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n<input type =\"hidden\" name=\"alt_id2_type_deschd\" id=\"alt_id2_type_deschd\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n<input type =\"hidden\" name=\"alt_id3_type_deschd\" id=\"alt_id3_type_deschd\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<input type =\"hidden\" name=\"alt_id4_type_deschd\" id=\"alt_id4_type_deschd\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type =\"hidden\" name=\"nat_id_prompt_des\" id=\"nat_id_prompt_des\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type =\"hidden\" name=\"accept_oth_alt_id_yn\" id=\"accept_oth_alt_id_yn\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type =\"hidden\" name=\"accept_national_id_no_yn\" id=\"accept_national_id_no_yn\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\n</form>\n</body>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n</html>\n\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs    =null;

String func_act = request.getParameter("func_act");
String view= request.getParameter("view");
if(view == null) view="";

func_act = (func_act == null)?"":func_act;

func_act = "VIEW";

String locale =((String)session.getAttribute("LOCALE"));
String patientIDLength = "";
String alt_id1_length = "",alt_id2_length = "",alt_id3_length = "",alt_id4_length = "";// added for PMG2014-HSA-CRF-0001 [IN:050020] 
String alt_id1_Type   = "",alt_id2_Type   = "",alt_id3_Type   = "",alt_id4_Type   = "";// added for PMG2014-HSA-CRF-0001 [IN:050020] 
//String alternate_id_type_desc = "";
String dflt_sndx_type = "", first_name_prompt = "", second_name_prompt = "", third_name_prompt = "", family_name_prompt = "";
String names_in_oth_lang_yn = "";
String pat_name_as_multipart_yn = "";
String alt_id1_type_desc = "",alt_id2_type_desc = "",alt_id3_type_desc = "",alt_id4_type_desc = "",nat_id_prompt="",nat_id_length="";// added for PMG2014-HSA-CRF-0001 [IN:050020] 
String function_id = request.getParameter("function_id");
String func_idpassed = request.getParameter("func_idpassed")==null?"":request.getParameter("func_idpassed");
String first_name_length = "";
String second_name_length = "";
String third_name_length = "";
String family_name_length = "";
String accept_oth_alt_id_yn="";
String accept_national_id_no_yn="";

if (function_id==null) function_id = "";
try 
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(" Select patient_id_length,Alt_id1_length,Alt_id1_type,Alt_id2_length,Alt_id2_type, Alt_id3_length,Alt_id3_type,Alt_id4_length,Alt_id4_type,nat_id_prompt, Alt_id1_type Dflt_Sndx_type, First_Name_Prompt, second_Name_Prompt, third_Name_Prompt, family_Name_Prompt, names_in_oth_lang_yn, pat_name_as_multipart_yn,nat_id_length,accept_oth_alt_id_yn,accept_national_id_no_yn,(select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE=alt_id1_type and language_id='"+locale+"') alt_id1_type_desc,(select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE=alt_id2_type and language_id='"+locale+"') alt_id2_type_desc,(select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE=alt_id3_type and language_id='"+locale+"') alt_id3_type_desc,(select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE=alt_id4_type and language_id='"+locale+"') alt_id4_type_desc,first_name_length, second_name_length, third_name_length,family_name_length from mp_param_lang_vw where language_id='"+locale +"'");
	rs=pstmt.executeQuery();
	if(rs.next()) 
	{           
		patientIDLength= checkForNull(rs.getString(1));
		alt_id1_length = checkForNull(rs.getString(2));
		alt_id1_Type   = checkForNull( rs.getString(3));
		alt_id2_length =checkForNull( rs.getString(4));
		alt_id2_Type   = checkForNull(rs.getString(5));
		alt_id3_length = checkForNull(rs.getString(6));
		alt_id3_Type   =checkForNull( rs.getString(7));
		alt_id4_length = checkForNull(rs.getString(8));
		alt_id4_Type   = checkForNull(rs.getString(9));
		nat_id_prompt   = checkForNull(rs.getString(10));
		dflt_sndx_type = checkForNull(rs.getString(11));
		first_name_prompt =checkForNull( rs.getString(12));
		second_name_prompt =checkForNull(rs.getString(13));
		third_name_prompt = checkForNull(rs.getString(14));
		family_name_prompt =checkForNull(rs.getString(15));
		if (first_name_prompt==null) first_name_prompt="First Name";
		if (second_name_prompt==null) second_name_prompt="Second Name";
		if (third_name_prompt==null) third_name_prompt="Third Name";
		if (family_name_prompt==null) family_name_prompt="Family Name";
		names_in_oth_lang_yn = rs.getString(16)==null?"":rs.getString(16);
		pat_name_as_multipart_yn =checkForNull(rs.getString(17));
		alt_id1_type_desc =checkForNull( rs.getString("alt_id1_type_desc"));
		alt_id2_type_desc =checkForNull( rs.getString("alt_id2_type_desc"));
		alt_id3_type_desc = checkForNull(rs.getString("alt_id3_type_desc"));
		alt_id4_type_desc = checkForNull(rs.getString("alt_id4_type_desc"));
		nat_id_length = rs.getString("nat_id_length")==null?"":rs.getString("nat_id_length");
		first_name_length = rs.getString("first_name_length")==null?"":rs.getString("first_name_length");
		second_name_length = rs.getString("second_name_length")==null?"":rs.getString("second_name_length");
		third_name_length = rs.getString("third_name_length")==null?"":rs.getString("third_name_length");
		family_name_length = rs.getString("family_name_length")==null?"":rs.getString("family_name_length");
		accept_oth_alt_id_yn = rs.getString("accept_oth_alt_id_yn")==null ? "N" : rs.getString("accept_oth_alt_id_yn");
		accept_national_id_no_yn = rs.getString("accept_national_id_no_yn")==null ? "N" : rs.getString("accept_national_id_no_yn");
	}
	if (rs!=null) rs.close();
	if (pstmt!=null) pstmt.close();

	/*
	pstmt = con.prepareStatement("select long_desc from mp_alternate_id_type_lang_vw where alt_id_type = ? and language_id='"+locale+"'");
	pstmt.setString(1,altIDType);
	rs=pstmt.executeQuery();
	if(rs.next()) 
	{
		alternate_id_type_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
	}

	if (rs!=null) rs.close();
	if (pstmt!=null) pstmt.close();
	*/


            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(view));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(alt_id1_Type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dflt_sndx_type));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientIDLength));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(names_in_oth_lang_yn.equals("Y")) { 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}else {
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patientIDLength));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(!alt_id1_type_desc.equals("")){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block32Bytes, _wl_block32);
} 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_id1_Type));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(!alt_id2_type_desc.equals("")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block37Bytes, _wl_block37);
} 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(alt_id2_Type));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(!alt_id3_type_desc.equals("")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alt_id3_type_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block41Bytes, _wl_block41);
} 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id3_Type));
            _bw.write(_wl_block43Bytes, _wl_block43);
if(!alt_id4_type_desc.equals("")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alt_id4_type_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block41Bytes, _wl_block41);
} 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alt_id4_Type));
            _bw.write(_wl_block39Bytes, _wl_block39);
if (accept_national_id_no_yn.equals("Y")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block41Bytes, _wl_block41);
} 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(alt_id4_Type));
            _bw.write(_wl_block48Bytes, _wl_block48);
if(accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
String Qry_For_AltType = "SELECT alt_id_type,nvl((select desc1_value from SM_OTH_LANG_DATA_SKEY where table_id ='MP_ALTERNATE_ID_TYPE' and language_id =? and pk_value=mp_alternate_id_type.alt_id_type),SHORT_DESC) SHORT_DESC FROM mp_alternate_id_type WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM where module_id='MP') and eff_status='E' order by 2";
									pstmt = con.prepareStatement(Qry_For_AltType);
									pstmt.setString(1,locale);
									rs = pstmt.executeQuery();	
									
									if(rs != null){
										while (rs.next()){          
											out.println ( "<Option value=\""+rs.getString("alt_id_type")+"\" >"+rs.getString("SHORT_DESC")+"</Option>" ) ;
										}
									}	
								
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
 if (function_id.equals("")) { 
					//Added by kumar on 17/03/2003 for Malaysia Enhancements
					if (pat_name_as_multipart_yn.equals("N"))
					{
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
}
					else
					{
				
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
	}
				}
				else
				{
				
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
 if (function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG")) {
					//Added by kumar on 17/03/2003 for Malaysia Enhancements
					if (pat_name_as_multipart_yn.equals("N")) {
				
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block72Bytes, _wl_block72);
	}
					else
					{ 
					
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(first_name_prompt));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(second_name_prompt));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(third_name_prompt));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block76Bytes, _wl_block76);
}
				}
				
            _bw.write(_wl_block77Bytes, _wl_block77);
if (function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG")) {
					//Added by kumar on 17/03/2003 for Malaysia Enhancements
					if (pat_name_as_multipart_yn.equals("N")) { 
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
}
					else
					{
				
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(first_name_length ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(second_name_length));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(third_name_length));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block87Bytes, _wl_block87);

					}
				}
				
            _bw.write(_wl_block88Bytes, _wl_block88);
if (function_id.equals("")) {
			
            _bw.write(_wl_block89Bytes, _wl_block89);
}
			
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(alt_id1_Type));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(func_idpassed));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(alt_id2_type_desc));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(alt_id3_type_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(alt_id4_type_desc));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(accept_oth_alt_id_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(accept_national_id_no_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);
        
}catch(Exception e)
{
out.println(e.toString());
}
finally
{
if(rs !=null) rs.close();
if(pstmt != null) pstmt.close();
if(con!=null) ConnectionManager.returnConnection(con,request);                
}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SearchCriteria.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.SearchNameWithLocalLang.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.motherpatientid.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.namesearchby.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BabyName.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mothername.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.fathername.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.soundex.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ethnic.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.generic.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.soundex.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ethnic.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.generic.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startsWith.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contains.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.endsWith.label", java.lang.String .class,"key"));
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
}
