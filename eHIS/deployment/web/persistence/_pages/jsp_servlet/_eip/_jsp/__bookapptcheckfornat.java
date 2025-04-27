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
import java.sql.*;

public final class __bookapptcheckfornat extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BookApptCheckForNat.jsp", 1742367597233L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eIP/js/Booking.js\' language=\'javascript\'></script>\n<script src=\'../../eIP/js/Booking1.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction nationalidvalues()\n{\n\tvar HTMLVal1 = new String();\n\tvar natid1=nat_id_val.value;\n\tsetTimeout(\'nat()\',0);\n}\n\nfunction nat() \n{\n\tHTMLVal1 = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form2\' id=\'form2\' method=\'post\' action=\'../jsp/BookAppointmentValues.jsp\'><input name=\'nat_id\' id=\'nat_id\' type=\'hidden\' value=\'\"+nat_id_val.value+\"\'><input type=\'hidden\' name=\'step\' id=\'step\' value=\'N\'></form></BODY></HTML>\";\n\tparent.document.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal1);\n\tparent.document.frames[2].document.form2.submit();\n\n}\n\n</script>\n<body bgcolor=\'#B2B6D7\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t\t<script>\n\t\t\t\tparent.f_query_add_mod.document.forms[0].team_id.disabled = false;\n\t\t\t\t/*Below condtion Added for this incident  [IN:043737]*/\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'!=\"\")parent.f_query_add_mod.document.forms[0].patient_id.value =\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].patient_id.onblur();/*16586*/\t\t\t\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].search.disabled = true;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].patient_id.disabled=true;\n\n\t\t\t\tparent.f_query_add_mod.document.forms[0].Splcode_desc.value =\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].Splcode_desc_hid.value =\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].Splcode.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].nursing_unit != null)\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].nursing_unit_desc.value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\n\t\t\t\tparent.f_query_add_mod.document.forms[0].nursing_unit.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].service_code.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].service_code != null)\n\t\t\t\t{\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\n\t\t\t\t\t\t\t\tvar opt = parent.f_query_add_mod.document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\t\t\t\tif(opt.value == \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")     \n\t\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\tvar obj = parent.f_query_add_mod.document.forms[0].service_desc;\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t}\n\t\t\t\tparent.f_query_add_mod.document.forms[0].practid_desc.value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].practid_desc_hid.value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].practid.value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t/*Thursday, January 21, 2010 , modified for 18385 since passing patient class to app_pat_class hidden variable .*/\n\t\t\t\t//parent.f_query_add_mod.document.forms[0].app_pat_class.value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].alt_id1_no != null)\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id1_no.value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id1_no.disabled = true;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].alt_id1_exp_date != null)\t\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id1_exp_date.value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].alt_id2_no != null)\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id2_no.value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id2_no.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].alt_id2_exp_date != null)\t\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id2_exp_date.value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\t\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].alt_id3_no != null)\n\t\t\t\t{\t\t\t\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id3_no.value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id3_no.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].alt_id3_exp_date != null)\t\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id3_exp_date.value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\t\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].alt_id4_no != null)\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id4_no.value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id4_no.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].alt_id4_exp_date != null)\t\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_id4_exp_date.value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].other_alt_Id != null)\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].other_alt_Id.value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].other_alt_Id.disabled = true;\n\t\t\t\t}\n\t\t\t\tif(parent.f_query_add_mod.document.forms[0].other_alt_type != null)\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].other_alt_type.value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].other_alt_type.disabled = true;\n\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].national_id_no.value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\n\t\t\t\tparent.f_query_add_mod.document.forms[0].national_id_no.disabled = true;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].patient_name.value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].patient_name.disabled =true;\tparent.f_query_add_mod.document.forms[0].date_of_birth.value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\n\t\t\t\tparent.f_query_add_mod.document.forms[0].date_of_birth.disabled = true;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].b_age.value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\t\t\tparent.f_query_add_mod.document.forms[0].b_months.value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\n\t\t\t\tparent.f_query_add_mod.document.forms[0].b_days.value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\n\t\t\t\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].Birth_place_code.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].birth_place.value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].place_of_birth.value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].birth_place.disabled =true;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].place_of_birth.disabled=true;\n\t\t\t\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].b_birth.disabled=true;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].nationality_id.disabled=true;\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t \n\t\t\tparent.f_query_add_mod.document.forms[0].citizen_yn[0].checked = true;\n\t\t\tparent.f_query_add_mod.document.forms[0].citizen.value = \"Y\";\n\t\t\t//parent.f_query_add_mod.document.forms[0].eth_gif.style.visibility= \"visible\";\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t \n\t\t\t//parent.f_query_add_mod.document.forms[0].eth_gif.style.visibility= \"hidden\";\n\t\t\tparent.f_query_add_mod.document.forms[0].citizen_yn[1].checked = true;\n\t\t\tparent.f_query_add_mod.document.forms[0].citizen.value = \"N\";\t\t\t \n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\tparent.f_query_add_mod.document.forms[0].citizen_yn[0].disabled=true;\n\t\tparent.f_query_add_mod.document.forms[0].citizen_yn[1].disabled=true;\n\t\t\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\tparent.f_query_add_mod.document.forms[0].legal_yn[0].checked = true;\n\t\t\tparent.f_query_add_mod.document.forms[0].legal.value = \"Y\";\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\tparent.f_query_add_mod.document.forms[0].legal_yn[1].checked = true;\n\t\t\tparent.f_query_add_mod.document.forms[0].legal.value = \"N\";\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\tparent.f_query_add_mod.document.forms[0].legal_yn[0].disabled=true;\n\t\tparent.f_query_add_mod.document.forms[0].legal_yn[1].disabled=true;\n\t\t\n\t\t\tparent.f_query_add_mod.document.forms[0].race_code.value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\tparent.f_query_add_mod.document.forms[0].race_desc.disabled = true;\n\t\t    parent.f_query_add_mod.document.forms[0].race_desc_id.disabled = true;\n\t\t\t/*Added by Dharma on 15th Dec 2014 against HSA-SCF-0046.1 [IN:052933] Start*/\n\t\t\tif(parent.f_query_add_mod.document.forms[0].race_code.value!=\"\")\n\t\t\t\tparent.f_query_add_mod.document.forms[0].race_desc.value\t= \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"\n\t\t\t/*Added by Dharma on 15th Dec 2014 against HSA-SCF-0046.1 [IN:052933] End*/\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\tvar obj = parent.f_query_add_mod.document.forms[0].ethnic_group;\n\t\t\t\tfor(i=0;i<obj.length;i++)\n\t\t\t\tobj.remove(1);\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n\t\t\t\tvar opt = parent.f_query_add_mod.document.createElement(\'Option\');\n\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\t\t\topt.value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\t\tobj.add(opt);\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\tvar obj = parent.f_query_add_mod.document.forms[0].ethnic_group;\n\t\t\t\tfor(i=0;i<obj.length;i++)\n\t\t\t\tobj.remove(1);\n\t\t\tvar opt = parent.f_query_add_mod.document.createElement(\'Option\');\n\t\t\topt.value = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\t\topt.text  = \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\tobj.add(opt);\n\t\t\topt.selected = true;\n\t\t\tobj.disabled = true;\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n      parent.f_query_add_mod.document.forms[0].ethnic_group.disabled=true;\n\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t//Commented on 10-10-2004 for disabling the race and ethnicity if the values are there.\t\n\t\t\n\t\t//added on 24-09-2003 by dhanasekaran\n\t\tparent.f_query_add_mod.document.getElementById(\'dob\').disabled=true;\n\n\t\t\n\t\tparent.f_query_add_mod.document.forms[0].b_age.disabled=true;\n\t\tparent.f_query_add_mod.document.forms[0].b_months.disabled=true;\n\t\tparent.f_query_add_mod.document.forms[0].b_days.disabled=true;\n\n\t\tparent.f_query_add_mod.document.forms[0].nationality_code1.value = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\n\t\tparent.f_query_add_mod.document.forms[0].nationality_desc.value= \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\tparent.f_query_add_mod.document.forms[0].nationality_desc.disabled = true;\n\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].name_prefix1!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tp = parent.f_query_add_mod.document.forms[0].name_prefix1.options;\n\t\t\t\t\t\tfor (i=0; i<p.options.length; i++) {\n\t\t\t\t\t\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\")\n\t\t\t\t\t\t\t\tp.options[i].selected = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].name_prefix1.disabled=true;\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].name_prefix!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tp = parent.f_query_add_mod.document.forms[0].name_prefix.options;\n\t\t\t\t\t\tfor (i=0; i<p.options.length; i++) {\n\t\t\t\t\t\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\")\n\t\t\t\t\t\t\t\tp.options[i].selected = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].name_prefix.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].name_suffix1!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tp = parent.f_query_add_mod.document.forms[0].name_suffix1.options;\n\t\t\t\t\t\tfor (i=0; i<p.options.length; i++) {\n\t\t\t\t\t\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\")\n\t\t\t\t\t\t\t\tp.options[i].selected = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].name_suffix1.disabled=true;\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].name_suffix!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tp = parent.f_query_add_mod.document.forms[0].name_suffix.options;\n\t\t\t\t\t\tfor (i=0; i<p.options.length; i++) {\n\t\t\t\t\t\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\")\n\t\t\t\t\t\t\t\tp.options[i].selected = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].name_suffix.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\tp = parent.f_query_add_mod.document.forms[0].sex.options;\n\t\t\t\t\tfor (i=0; i<p.options.length; i++) {\n\t\t\t\t\t\tif(p.options[i].value == \'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\')\n\t\t\t\t\t\t\tp.options[i].selected = true;\n\t\t\t\t\t}\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].sex.disabled=true;\n\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].first_name!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].first_name.value = \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].first_name.disabled =true;\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].second_name!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].second_name.value = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].second_name.disabled = true;\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].third_name!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].third_name.value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].third_name.disabled = true;\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].family_name!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].family_name.value = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].family_name.disabled = true;\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].name_prefix_oth_lang!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tp = parent.f_query_add_mod.document.forms[0].name_prefix_oth_lang.options;\n\t\t\t\t\t\tfor (i=0; i<p.options.length; i++) {\n\t\t\t\t\t\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\")\n\t\t\t\t\t\t\t\tp.options[i].selected = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].name_prefix_oth_lang.disabled=true;\n\t\t\t\t\t}\n\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].name_suffix_oth_lang!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tp = parent.f_query_add_mod.document.forms[0].name_suffix_oth_lang.options;\n\t\t\t\t\t\tfor (i=0; i<p.options.length; i++) {\n\t\t\t\t\t\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\")\n\t\t\t\t\t\t\t\tp.options[i].selected = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].name_suffix_oth_lang.disabled=true;\n\t\t\t\t\t}\n\n\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].first_name_oth_lang!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].first_name_oth_lang.value = \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].first_name_oth_lang.disabled =true;\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].second_name_oth_lang!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].second_name_oth_lang.value = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].second_name_oth_lang.disabled = true;\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].third_name_oth_lang!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].third_name_oth_lang.value = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].third_name_oth_lang.disabled = true;\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].family_name_oth_lang!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].family_name_oth_lang.value = \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].family_name_oth_lang.disabled = true;\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].pref_adm_date!=null)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].pref_adm_date.value ==\'\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].pref_adm_date.value = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].source_type.value = \"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n\n\t\t\t\tparent.f_query_add_mod.document.forms[0].source.value = \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\n\t\t\t\tparent.f_query_add_mod.document.forms[0].addr_line1.value = \"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].addr_line2.value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].addr_line3. value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].addr_line4. value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" ;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].res_town_code. value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" ;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].res_town_desc. value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" ;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].res_area_code. value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].res_area_desc. value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].region_code.value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].country_code.value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].country_desc.value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_addr_line1. value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_addr_line2. value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_addr_line3. value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_addr_line4. value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" ;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_res_town_code. value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" ;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_res_town_desc. value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_res_area_code. value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"; \n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_res_area_desc. value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"; \n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_postal_code. value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"; \n\t\t\t\tparent.f_query_add_mod.document.forms[0].m_postal_code_desc.value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\t\n\t\t\t\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_region_code. value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"; \n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_region_desc. value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"; \n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_country_code. value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"; \n\t\t\t\tparent.f_query_add_mod.document.forms[0].mail_country_desc. value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"; \n\t\t\t\tparent.f_query_add_mod.document.forms[0].contact1_no.value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].contact2_no.value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].email.value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"; \n\t\t\t\tparent.f_query_add_mod.document.forms[0].pref_adm_date.focus();\n\t\t\t\t/*Added by Thamizh selvi on 14th Feb 2018 against ML-MMOH-CRF-0601 Start*/\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_addr_line1.value\t= \"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_addr_line2.value\t= \"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_addr_line3.value\t= \"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_addr_line4.value\t= \"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_town_code.value\t= \"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_town_desc.value\t= \"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_area_code.value\t= \"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_area_desc.value\t= \"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_postal_desc.value\t= \"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_postal_code.value\t= \"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_region_code.value\t= \"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_region_desc.value\t= \"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_country_code.value\t= \"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].alt_country_desc.value\t= \"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\";\n\t\t\t\t/*End*/\n\t\t\t\t//parent.f_query_add_mod.PopulateService();\n\t\t\t\t/*IN016586*/\n\t\t\t\tsetTimeout(\'parent.f_query_add_mod.PopulateService();\',100);\n\t</script>\n\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t<script>\n\t\t\t\tvar obj =parent.f_query_add_mod.document.forms[0].team_id;\n\t\t\t\tvar length  = obj.length;\n\t\t\t\tfor(i=0;i<length;i++) {obj.remove(1);}\n\n\n\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\n\t\t\t\t\tvar \n\t\t\t\t\telement = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\";\n\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\";\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].team_id.add(element);\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t \n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t<script>\t\n\t\t\t\t\tHTMLVal1 = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form2\' id=\'form2\' method=\'post\' action=\'../jsp/BookAppointmentValues.jsp\'><input name=\'pat_id1\' id=\'pat_id1\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'><input type=\'hidden\' name=\'step\' id=\'step\' value=\'P\'></form></BODY></HTML>\";\n\t\t\t\t\tparent.document.frames[2].document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal1);\n\t\t\t\t\tparent.document.frames[2].document.form2.submit();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"INV_REF_ID\",\"IP\")); \n\t\t\t\tparent.f_query_add_mod.document.forms[0].referral_id.focus();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t<html>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<input type=\'hidden\' name=\'nat_id_val\' id=\'nat_id_val\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\n\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t<script language=\'javascript\'> nationalidvalues();</script>\n\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t<script language=\'javascript\'>\n\t\t\tparent.f_query_add_mod.window.alert(getMessage(\'INVALID_NAT_ID\',\'MP\'));\n\t\t\tparent.f_query_add_mod.document.getElementById(\"national_id\").focus();\n\t\t\t</script>\n\t\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n</head>\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	Connection			con		= null;
	Statement			stmt	= null;
	ResultSet			rs		= null;
	PreparedStatement	pstmt1	= null;
	ResultSet			rs1		= null;
	ResultSet			rset		= null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String function = request.getParameter("step");
		String ser_code = "";
		String ser_desc = "";
		if(function.equals("first"))
		{
			String patid			= "";
			String altid1no			= "";
			String altid1expdate	= "";
			String altid2no			= "";
			String altid2expdate	= "";
			String altid3no			= "";
			String altid3expdate	= "";
			String altid4no			= "";
			String altid4expdate	= "";
			String oth_alt_id_type	= "";
			String oth_alt_id_no	= "";
			String national_id_no	= "";
			String addr_line1		= "";
			String addr_line2		= "";
			String addr_line3		= "";
			String addr_line4		= "";
			String contact1_no		= "";
			String contact2_no		= "";
			String emailid			= "";
			String postalcode		= "";
		    String postal_desc      = "";
			String countrycode		= "";
			String countryDesc		= "";
			String res_town_code	= "";
			String res_town_desc	= "";
			String res_area_code	= "";
			String res_area_desc	= "";
			String res_region_code	= "";
			String res_region_desc	= "";
			String mail_addr_line1	= "";
			String mail_addr_line2	= "";
			String mail_addr_line3	= "";
			String mail_addr_line4	= "";
			String mail_town_code	= "";
			String mail_town_desc	= "";
			String mail_area_code	= "";
			String mail_area_desc	= "";
			String mail_region_code	= "";
			String mail_region_desc	= "";
			String mail_postal_code	= "";
			String mail_postal_desc	= "";
			String mail_country_code= "";
			String mail_country_desc= "";
			String patient_class	= "";
			/*Added by Thamizh selvi on 14th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			String alt_addr_line1	= "";
			String alt_addr_line2	= "";
			String alt_addr_line3	= "";
			String alt_addr_line4	= "";
			String alt_postal_code  = "";
			String alt_postal_desc  = "";
			String alt_country_code = "";
			String alt_country_desc = "";
			String alt_area_code	= "";
			String alt_area_desc	= "";
			String alt_town_code	= "";
			String alt_town_desc	= "";
			String alt_region_code	= "";
			String alt_region_desc	= "";
			/*End*/
		String referralid = request.getParameter("referral_id");
		stmt=con.createStatement();
		StringBuffer bookSql = new StringBuffer();
		bookSql.append("select PATIENT_ID,TO_PRACT_ID, am_get_desc.am_practitioner(TO_PRACT_ID, '"+localeName+"', 1) TO_FCY_PRACT_NAME,");
		//bookSql.append(" TO_SPECIALITY_CODE, AM_GET_DESC.AM_SPECIALITY(TO_SPECIALITY_CODE,'"+localeName+"','2') TO_SPECIALITY_DESC, NAME_PREFIX,");
		bookSql.append(" TO_SPECIALITY_CODE, AM_GET_DESC.AM_SPECIALITY(TO_SPECIALITY_CODE,'"+localeName+"','2') TO_SPECIALITY_DESC, NAME_PREFIX,NAME_PREFIX_LOC_LANG,");
		//bookSql.append("FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME, ");
		bookSql.append("FIRST_NAME,FIRST_NAME_LOC_LANG, SECOND_NAME,SECOND_NAME_LOC_LANG, THIRD_NAME,THIRD_NAME_LOC_LANG, FAMILY_NAME, FAMILY_NAME_LOC_LANG,");
		//bookSql.append("NAME_SUFFIX, decode('"+localeName+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))PATIENT_NAME, SEX, ");
		bookSql.append("NAME_SUFFIX,NAME_SUFFIX_LOC_LANG, decode('"+localeName+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))PATIENT_NAME, SEX, ");
		bookSql.append("to_char(DATE_OF_BIRTH,'dd/mm/rrrr') DATE_OF_BIRTH, ");
		bookSql.append("to_char(Nvl(PREFERRED_TREATMENT_DATE, ");
		bookSql.append(" REFERRAL_DATE),'dd/mm/rrrr')|| ' ' || ");
		bookSql.append(" to_char(sysdate,'hh24:mi')");
		bookSql.append("REFERRAL_DATE,calculate_age");
		bookSql.append("(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),1) years,");
		bookSql.append(" calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),2)");
		bookSql.append("months,");
		bookSql.append("calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),3)");
		bookSql.append("days, NATIONALITY_CODE, MP_GET_DESC.MP_COUNTRY(nationality_code,'"+localeName+"','1') NATIONALITY,  ADDR_LINE1,");
		bookSql.append("ADDR_LINE2, ADDR_LINE3, ADDR_LINE4, REGION_CODE,");
		bookSql.append("MP_GET_DESC.MP_REGION(REGION_CODE,'"+localeName+"','1') REGION_DESC,  RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+localeName+"','1') RES_AREA_DESC, ");
		bookSql.append("RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+localeName+"','1') RES_TOWN_DESC, POSTAL_CODE,  MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+localeName+"','2') POSTAL_DESC,");
		bookSql.append("COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+localeName+"','1') COUNTRY_NAME, CONTACT1_NO, CONTACT2_NO, ");
		bookSql.append("EMAIL_ID,  NATIONAL_ID_NO, ALT_ID1_TYPE, ALT_ID1_NO,");
		bookSql.append("to_char(ALT_ID1_DATE,'dd/mm/rrrr') ALT_ID1_DATE,");
		bookSql.append("ALT_ID2_TYPE, ALT_ID2_NO,"); bookSql.append("to_char(ALT_ID2_DATE,'dd/mm/rrrr')ALT_ID2_DATE, ");
		bookSql.append("ALT_ID3_TYPE, ALT_ID3_NO, ");
		bookSql.append("to_char(ALT_ID3_DATE,'dd/mm/rrrr')ALT_ID3_DATE, ");
		bookSql.append("ALT_ID4_TYPE, ALT_ID4_NO,  ");
		bookSql.append("to_char(ALT_ID4_DATE,'dd/mm/rrrr')ALT_ID4_DATE,");
		bookSql.append("OTH_ALT_ID_TYPE, OTH_ALT_ID_NO, MAIL_ADDR_LINE1, ");
		bookSql.append("MAIL_ADDR_LINE2, MAIL_ADDR_LINE3, MAIL_ADDR_LINE4, ");
		bookSql.append("MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+localeName+"','1')  MAIL_REGION_DESC, ");
		bookSql.append("MAIL_RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_RES_AREA_CODE,'"+localeName+"','1') MAIL_AREA_DESC, MAIL_RES_TOWN_CODE,");
		//bookSql.append("MP_GET_DESC.MP_RES_TOWN(MAIL_RES_TOWN_CODE,'"+localeName+"','1') MAIL_RES_TOWN_DESC,MAIL_POSTAL_CODE, MAIL_POSTAL_DESC,");
		bookSql.append("MP_GET_DESC.MP_RES_TOWN(MAIL_RES_TOWN_CODE,'"+localeName+"','1') MAIL_RES_TOWN_DESC,MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+localeName+"','2') MAIL_POSTAL_DESC , ");
		bookSql.append("MAIL_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+localeName+"','1') MAIL_COUNTRY_NAME, CITIZEN_YN,  ");
		/*Added by Thamizh selvi on 14th Feb 2018 against ML-MMOH-CRF-0601 Start*/
		bookSql.append("  alt_addr_line1" );
		bookSql.append("  , alt_addr_line2" );
		bookSql.append("  , alt_addr_line3" );
		bookSql.append("  , alt_addr_line4" );
		bookSql.append("  , alt_town_code" );
		bookSql.append("  , mp_get_desc.MP_RES_TOWN(alt_town_code,'"+localeName+"','1') alt_town_desc" );
		bookSql.append("  , alt_area_code" );
		bookSql.append("  , mp_get_desc.MP_RES_AREA(alt_area_code,'"+localeName+"','1') alt_area_desc" );
		bookSql.append("  , alt_region_code" );
		bookSql.append("  , mp_get_desc.MP_REGION(alt_region_code,'"+localeName+"','1') alt_region_desc" );
		bookSql.append("  , alt_postal_code" );
		bookSql.append("  , mp_get_desc.MP_POSTAL_CODE(alt_postal_code,'"+localeName+"',2) alt_postal_desc" );
		bookSql.append("  , alt_country_code" );
		bookSql.append("  , mp_get_desc.MP_COUNTRY(alt_country_code,'"+localeName+"','1') alt_country_desc, " );
		/*End*/
		bookSql.append("LEGAL_ILLEGAL_YN, RACE_CODE, MP_GET_DESC.MP_RACE(RACE_CODE,'"+localeName+"','1') RACE_DESC, ETHNIC_GRP_CODE,");
		bookSql.append(" MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GRP_CODE,'"+localeName+"','1') ETHNIC_GROUP_DESC, BIRTH_PLACE_CODE, MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+localeName+"','1') BIRTH_PLACE_DESC,");
		bookSql.append("BIRTH_PLACE_DESCRIPTION, TO_LOCN_TYPE, FROM_REF_CODE, FROM_REF_TYPE, TO_NURS_UNIT_CODE, IP_GET_DESC.IP_NURSING_UNIT(TO_FACILITY_ID, TO_NURS_UNIT_CODE,'"+localeName+"','2') TO_NURS_UNIT_DESC, TO_SERVICE_CODE, AM_GET_DESC.AM_SERVICE(TO_SERVICE_CODE,'"+localeName+"','2') TO_SERVICE_DESC from ");
		bookSql.append("PR_REFERRAL_REGISTER_VW a where referral_id = ");
		bookSql.append("'"+referralid+"' ");
		
		//out.println("<script>alert(\""+bookSql.toString()+"\");</script>");

		rs=stmt.executeQuery(bookSql.toString());
		
		if( rs != null && rs.next())
		{
			patid = checkForNull(rs.getString("PATIENT_ID"));
			String patient_name		= checkForNull(rs.getString("PATIENT_NAME"));		
			String pract_id			= checkForNull(rs.getString("TO_PRACT_ID"));
			String pract_desc		= checkForNull(rs.getString("TO_FCY_PRACT_NAME"));
			String specialty_code	= checkForNull(rs.getString("TO_SPECIALITY_CODE"));
			String specialty_desc	= checkForNull(rs.getString("TO_SPECIALITY_DESC"));
			String nurs_unit_code	= checkForNull(rs.getString("TO_NURS_UNIT_CODE"));
			String nurs_unit_desc	= checkForNull(rs.getString("TO_NURS_UNIT_DESC"));
			String service_code		= checkForNull(rs.getString("TO_SERVICE_CODE"));
			String date_of_birth	= checkForNull(rs.getString("DATE_OF_BIRTH"));
			String birth_place_code = checkForNull(rs.getString("BIRTH_PLACE_CODE"));
			String birth_place_desc = checkForNull(rs.getString("BIRTH_PLACE_DESC"));
			String bp_desc			= checkForNull(rs.getString("BIRTH_PLACE_DESCRIPTION"));
			String eth_grp_code		= checkForNull(rs.getString("ETHNIC_GRP_CODE"));
			String eth_grp_desc		= checkForNull(rs.getString("ETHNIC_GROUP_DESC"));
			String race_code		= checkForNull(rs.getString("race_code"));
			String race_desc		= checkForNull(rs.getString("RACE_DESC"));// Uncommented by Dharma on 15th Dec 2014 against HSA-SCF-0046.1 [IN:052933]
			String nationality_code	= checkForNull(rs.getString("NATIONALITY_CODE"));
			String nationality_desc = checkForNull(rs.getString("NATIONALITY"));
			String name_prefix		= checkForNull(rs.getString("NAME_PREFIX"));
			String name_suffix		= checkForNull(rs.getString("NAME_SUFFIX"));
			String first_name		= checkForNull(rs.getString("FIRST_NAME"));
			String second_name		= checkForNull(rs.getString("SECOND_NAME"));
			String third_name		= checkForNull(rs.getString("THIRD_NAME"));
			String family_name		= checkForNull(rs.getString("FAMILY_NAME"));
			String referral_date	= checkForNull(rs.getString("REFERRAL_DATE"));
			String from_ref_code	= checkForNull(rs.getString("FROM_REF_CODE"));
			String from_ref_type	= checkForNull(rs.getString("FROM_REF_TYPE"));
			String citizen_yn		= checkForNull(rs.getString("CITIZEN_YN"));
			String legal_yn			= checkForNull(rs.getString("LEGAL_ILLEGAL_YN"));
			String locale_lang_name_prefix		= checkForNull(rs.getString("NAME_PREFIX_LOC_LANG"));
			String locale_lang_name_suffix		= checkForNull(rs.getString("NAME_SUFFIX_LOC_LANG"));
			String locale_lang_first_name		= checkForNull(rs.getString("FIRST_NAME_LOC_LANG"));
			String locale_lang_second_name		= checkForNull(rs.getString("SECOND_NAME_LOC_LANG"));
			String locale_lang_third_name		= checkForNull(rs.getString("THIRD_NAME_LOC_LANG"));
			String locale_lang_family_name		= checkForNull(rs.getString("FAMILY_NAME_LOC_LANG"));

			addr_line1		= checkForNull(rs.getString("ADDR_LINE1"));
			addr_line2		= checkForNull(rs.getString("ADDR_LINE2"));
			addr_line3		= checkForNull(rs.getString("ADDR_LINE3"));
			addr_line4		= checkForNull(rs.getString("ADDR_LINE4"));
			contact1_no		= checkForNull(rs.getString("CONTACT1_NO"));
			contact2_no		= checkForNull(rs.getString("CONTACT2_NO"));
			emailid			= checkForNull(rs.getString("EMAIL_ID"));
			postalcode		= checkForNull(rs.getString("POSTAL_CODE"));
			postal_desc		= checkForNull(rs.getString("POSTAL_DESC"));
			countrycode		= checkForNull(rs.getString("COUNTRY_CODE"));
			countryDesc		= checkForNull(rs.getString("COUNTRY_NAME"));
			res_town_code	= checkForNull(rs.getString("RES_TOWN_CODE"));
			res_town_desc	= checkForNull(rs.getString("RES_TOWN_DESC"));
			res_area_code	= checkForNull(rs.getString("RES_AREA_CODE"));
			res_area_desc	= checkForNull(rs.getString("RES_AREA_DESC"));
			res_region_code	= checkForNull(rs.getString("REGION_CODE"));
			res_region_desc	= checkForNull(rs.getString("REGION_DESC"));
			mail_addr_line1	= checkForNull(rs.getString("MAIL_ADDR_LINE1"));
			mail_addr_line2	= checkForNull(rs.getString("MAIL_ADDR_LINE2"));
			mail_addr_line3	= checkForNull(rs.getString("MAIL_ADDR_LINE3"));
			mail_addr_line4	= checkForNull(rs.getString("MAIL_ADDR_LINE4"));
			mail_town_code	= checkForNull(rs.getString("MAIL_RES_TOWN_CODE"));
			mail_town_desc	= checkForNull(rs.getString("MAIL_RES_TOWN_DESC"));
			mail_area_code	= checkForNull(rs.getString("MAIL_RES_AREA_CODE"));
			mail_area_desc	= checkForNull(rs.getString("MAIL_AREA_DESC"));
			mail_region_code= checkForNull(rs.getString("MAIL_REGION_CODE"));
			mail_region_desc= checkForNull(rs.getString("MAIL_REGION_DESC"));
			mail_postal_code= checkForNull(rs.getString("MAIL_POSTAL_CODE"));
			mail_postal_desc= checkForNull(rs.getString("MAIL_POSTAL_DESC"));
			mail_country_code= checkForNull(rs.getString("MAIL_COUNTRY_CODE"));
			mail_country_desc= checkForNull(rs.getString("MAIL_COUNTRY_NAME"));
			patient_class		= checkForNull(rs.getString("TO_LOCN_TYPE"));
			altid1no			= checkForNull(rs.getString("ALT_ID1_NO"));
			altid1expdate		= checkForNull(rs.getString("ALT_ID1_DATE"));
			altid2no			= checkForNull(rs.getString("ALT_ID2_NO"));
			altid2expdate		= checkForNull(rs.getString("ALT_ID2_DATE"));
			altid3no			= checkForNull(rs.getString("ALT_ID3_NO"));
			altid3expdate		= checkForNull(rs.getString("ALT_ID3_DATE"));
			altid4no			= checkForNull(rs.getString("ALT_ID4_NO"));
			altid4expdate		= checkForNull(rs.getString("ALT_ID4_DATE"));
			oth_alt_id_type		= checkForNull(rs.getString("OTH_ALT_ID_TYPE"));
			oth_alt_id_no		= checkForNull(rs.getString("OTH_ALT_ID_NO"));
			national_id_no		= checkForNull(rs.getString("NATIONAL_ID_NO"));
			/*Added by Thamizh selvi on 14th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(rs.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(rs.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(rs.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(rs.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(rs.getString("alt_area_code"));
			alt_area_desc		= checkForNull(rs.getString("alt_area_desc"));
			alt_town_code		= checkForNull(rs.getString("alt_town_code"));
			alt_town_desc		= checkForNull(rs.getString("alt_town_desc"));
			alt_region_code		= checkForNull(rs.getString("alt_region_code"));
			alt_region_desc		= checkForNull(rs.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(rs.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(rs.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(rs.getString("alt_country_code"));
			alt_country_desc	= checkForNull(rs.getString("alt_country_desc"));
			/*End*/

			if(patient_class.equals("D"))
				patient_class = "DC";
			else
				patient_class = "IP";
			
			String facilityId = (String)session.getValue("facility_id"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( specialty_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( specialty_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nurs_unit_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nurs_unit_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
		
					String Sql= " select service_code, short_desc from AM_SERVICE_LANG_VW where language_id = '"+localeName+"' and Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code = '"+nurs_unit_code+"') ";
					stmt = con.createStatement();
					rset = stmt.executeQuery(Sql);
					if(rset!=null )
					{
						while (rset.next())
						{	
							ser_code = checkForNull(rset.getString("service_code"));
							ser_desc = checkForNull(rset.getString("short_desc"));
							
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ser_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ser_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
	}
					}	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pract_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pract_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(altid1no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(altid1expdate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(altid2no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(altid2expdate));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(altid3no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(altid3expdate));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(altid4no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(altid4expdate));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oth_alt_id_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(oth_alt_id_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs.getString("years")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs.getString("months")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rs.getString("days")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( birth_place_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bp_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);

		if(citizen_yn.equals("Y")) { 
            _bw.write(_wl_block44Bytes, _wl_block44);
	}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
	if(legal_yn.equals("Y")) { 
            _bw.write(_wl_block47Bytes, _wl_block47);
 }else { 
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( race_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);

			if((!race_code.equals(""))&&(eth_grp_code.equals("")))
			{
				
				String sql = "select ethnic_group_code, long_desc from mp_ethnic_group_lang_vw where race_code = '"+race_code+"' and language_id = '"+localeName+"' order by 2";
				pstmt1 = con.prepareStatement(sql) ;
				rs1      = pstmt1.executeQuery() ;
				
            _bw.write(_wl_block52Bytes, _wl_block52);
while(rs1.next())
				{
				
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rs1.getString(2)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rs1.getString(1)));
            _bw.write(_wl_block55Bytes, _wl_block55);
}

			}
			
            _bw.write(_wl_block56Bytes, _wl_block56);
if(!eth_grp_code.equals("")){
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( eth_grp_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( eth_grp_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
}else{
					
            _bw.write(_wl_block60Bytes, _wl_block60);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf( nationality_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(name_prefix));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(name_suffix));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(name_suffix));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rs.getString("SEX")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(first_name));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(second_name));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(third_name));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(family_name));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(locale_lang_name_prefix));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(locale_lang_name_suffix));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(locale_lang_first_name));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(locale_lang_second_name));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(locale_lang_third_name));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(locale_lang_family_name));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(referral_date));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( from_ref_type));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( from_ref_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( addr_line1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( addr_line2));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( addr_line3));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( addr_line4));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( res_town_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( res_town_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf( res_area_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf( res_area_desc));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( postalcode));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( postal_desc));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( res_region_code));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( res_region_desc));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf( countrycode));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( countryDesc));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf( mail_addr_line1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf( mail_addr_line2));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf( mail_addr_line3));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( mail_addr_line4));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf( mail_town_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( mail_town_desc));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf( mail_area_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( mail_area_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf( mail_postal_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf( mail_postal_desc));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( mail_region_code));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( mail_region_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf( mail_country_code));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf( mail_country_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf( contact1_no));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf( contact2_no));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( emailid));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(alt_addr_line1));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(alt_addr_line2));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(alt_addr_line3));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(alt_addr_line4));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(alt_town_code));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(alt_town_desc));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(alt_area_code));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(alt_area_desc));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(alt_postal_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(alt_postal_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(alt_region_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(alt_region_desc));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(alt_country_code));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(alt_country_desc));
            _bw.write(_wl_block126Bytes, _wl_block126);
	try{
			if(!pract_id.equals(""))
			{
				if(bookSql.length()>0) bookSql.delete(0,bookSql.length());
				bookSql.append("select a.short_desc short_desc, a.team_id team_id, b.practitioner_id from 	");
				bookSql.append(" am_medical_team_lang_Vw a, am_pract_for_team b where");
				bookSql.append(" a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id 		");
				bookSql.append(" and b.practitioner_id ='"+pract_id+"' and a.speciality_code = '"+specialty_code+"' and b.team_id=a.team_id and a.appl_for_ip_yn = 'Y' and language_id = '"+localeName+"' order by 1");
				String team_id = "";
				String team_desc=""; 
				
			
            _bw.write(_wl_block127Bytes, _wl_block127);
	if(rs1 != null) rs1.close();
				rs1=stmt.executeQuery(bookSql.toString());
				if( rs1 != null)
				if(rs1.next())
				{
					team_id = rs1.getString("team_id");
					team_desc = rs1.getString("short_desc");
				
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(team_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block130Bytes, _wl_block130);
}
            _bw.write(_wl_block131Bytes, _wl_block131);
}
		}catch(Exception z) {
			
			z.printStackTrace();
		}
			
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(patid));
            _bw.write(_wl_block133Bytes, _wl_block133);
	
		}
		else
		{	
            _bw.write(_wl_block134Bytes, _wl_block134);

		}
		if(rs!=null)    rs.close(); 
		if(stmt!=null)  stmt.close();
	}
	else if(function.equals("second"))
	{
	String national_id_no = request.getParameter("national_id_no");
	
	
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block136Bytes, _wl_block136);

	stmt=con.createStatement();
	String sql="select 1 from mp_patient where national_id_no ='"+national_id_no+"'";
	rs=stmt.executeQuery(sql);
	rs.next();
	String result = rs.getString(1);
	
	
	if (result.equals("1"))
	{
            _bw.write(_wl_block137Bytes, _wl_block137);
}
	else
	{	
            _bw.write(_wl_block138Bytes, _wl_block138);
	}
}
}catch(Exception e){e.printStackTrace();}
finally
{
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(rs1 != null) rs1.close();
	if (pstmt1 != null) pstmt1.close();
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block139Bytes, _wl_block139);
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
