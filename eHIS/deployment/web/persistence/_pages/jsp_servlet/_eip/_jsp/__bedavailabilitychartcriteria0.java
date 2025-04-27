package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __bedavailabilitychartcriteria0 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BedAvailabilityChartCriteria0.jsp", 1733227873667L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'javascript\' ></script>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\nfunction setGroupBy(spclty)\n{\n\t\n\tif(spclty.value != \'\')\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder1.options[1].selected = true;\n\t\t\n\t\tvar val_id\t= new Array();\n\t\tval_id[0] = \"specialty_short_desc\";\n\t\tval_id[1] = \"bed_type_short_desc\";\n\t\tval_id[2] = \"room_long_desc\";\n\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\tval_id[3] = \"admission_type\";\n\t\tvar val\t\t= new Array();\n\t\tval[0] = getLabel(\"Common.speciality.label\",\"Common\");\n\t\tval[1] = getLabel(\"Common.bedtype.label\",\"Common\");\n\t\tval[2] = getLabel(\"Common.RoomCubicle.label\",\"Common\");\n\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\tval[3] = getLabel(\"Common.admissiontype.label\",\"Common\");\n\n\n\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder2 );\n\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder3 );\n\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );\n\t\t\n\t\t\tfor ( var i=0; i<val_id.length; i++ )\n\t\t\t{\n\t\t\t\tvar element\t\t  = document.createElement(\"option\");\n\t\t\t\t\telement.value = val_id[i];\n\t\t\t\t\telement.text  =\tval[i];\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.add(element)\n\t\t\t}\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.disabled = false;\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.disabled =\ttrue;\n\t\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled =\ttrue;\n\t\t\tif(document.forms[0].sm_cntl_assign_bed_count.value>0 ){\n\t\t\t\tdocument.forms[0].BedListinOrder1.options[3].selected = true;\n\t\t\t\tgetBedListinOrder(document.forms[0].BedListinOrder1);\n\t\t\t}\n\t}\t\n\telse\n\t{\n\t\tdocument.forms[0].BedListinOrder1.options[0].selected = true;\n\t\tdocument.forms[0].BedListinOrder2.options[0].selected = true;\n\t\tdocument.forms[0].BedListinOrder2.disabled = true;\n\t}\n}\n\nvar calledoption;\nfunction cancelAction()\n{\n\tif(parent.criteria0.document.forms[0].call_func.value == \'ADMIT\')\n\t{\n\t\tparent.location.href = \'../jsp/PaintAdmitPatient.jsp?P_call_func=ADMIT\';\n\t}\n\telse\n\t{\n\t\tparent.parent.document.getElementById(\"dialog_tag\").close(); \n\t}\n}\n\n// This function will clear all the criteria values except the Nusring Unit Value if that\'s Disabled.\nfunction clearCriteria()\n{\n\tparent.result.location.href =\'../../eCommon/html/blank.html\';\n\tvar bedClass_dis_yn = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\tvar patient_class = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tvar bed_yn=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\n\tif (\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"==\"NursingUnit\")\n\t{\n\t\tif(bed_yn==\"Y\")\n\t\t{\n\t\t\t\n\t\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&disable_field=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nursing_unit_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&patient_class=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&bedClass_dis_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&ipparam_bed_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&call_function=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&main_bed_no=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&oper_stn_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&P_call_func=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&med_service_grp=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&patient_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&reserve_bed_selectable=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\n\t\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\';\n\t\t}\n\t}/*Friday, February 12, 2010 IN000242(emergency release),Nursing unit list item getting enable from Bed for Nursing Unit function*/\n\telse if (\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"==\"Nursing\" )\n\t{\n\t\t\n\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?call_function=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\n\t}\n\telse if (\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"==\"NursingUnitSpecialty\" )\n\t{\n\t\t\n\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&speciality_code=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&exp_discharge_date=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&create_booking_admission_date_time=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\';\n\t}\n\telse if(\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"==\"specialty\")\n\t{\n\t\t\n\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t}\n\telse if (disable_field == \"NuBcBt\")\n\t{\n\t\t\n\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&bed_class_code=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&bed_type=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&room_no_code=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\n\t}\n\telse if (disable_field == \"NuSyBcBt\")\n\t{\n\t\t\n\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\n\t}\n\telse if (disable_field == \"SyBcBt\")\n\t{\n\t\t\n\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t}\n\telse if (disable_field == \"BcBt\")\n\t{\n\t\t\n\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\';\n\t}\n\telse if(bed_yn==\"Y\")\n\t{\n\t\t\n\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t}\n\telse\n\t{\n\t\tdocument.location.href =\'../jsp/BedAvailabilityChartCriteria0.jsp?wherecondn=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\';\n\t}\n}\n\n\nfunction specialChar(obj)\n{\n\tif(obj.value!=\'\')\n\t{\n\t\tvar fields1 = new Array(obj);\n\t\tvar names1 = new Array(obj.name.toUpperCase());\n\t\tvar messageFrame = \"\"; var error_page = \"\";\n\t\tif(SpecialCharCheck(fields1,names1,messageFrame,\"A\",error_page) )\n\t\t{\n\t\t\tif(CheckNum(obj))\n\t\t\t{\n\t\t\t\t return true;\n\t\t\t}\n\t\t\telse \n\t\t\t{\n\t\t\t\t obj.focus();\n\t\t\t\t return false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n}\n\n\t\t\t\nfunction getCheckValue(obj)\n{\n\tif (obj.checked)\n\t\t obj.value =  \"Y\";\n\telse obj.value =  \"N\";\n}\n\n\t\t\t\nfunction submitPage(frm,calledoption)\n{\n\t\n\tvar chk_string = \"\";\n\tvar nursing_unit = document.forms[0].nursing_unit.value;\n\tvar speciality = document.forms[0].Splcode.value;\n\tvar Practitioner =  document.forms[0].practid.value;\n\n\tvar bed_class = document.forms[0].Bedcode.value;\n\tvar bed_type = document.forms[0].bed_type_code.value;\n\tvar gender = document.forms[0].gender.value;\n\tvar age = document.forms[0].age_value.value;\n\n\tvar gender_type=\"\";\n\n\tif(document.forms[0].gender_type[0].checked==true)\n\t\tgender_type\t=\tdocument.forms[0].gender_type[0].value;\n\telse if(document.forms[0].gender_type[1].checked==true)\n\t\tgender_type\t=\tdocument.forms[0].gender_type[1].value;\n\t//\n\t\n\t\n/*\n\tif(nursing_unit != \"\")\n\t\tchk_string = chk_string + \'*\';\n\n\tif(speciality != \"\")\n\t\tchk_string = chk_string + \'*\';\n\n\tif(Practitioner != \"\")\n\t\tchk_string = chk_string + \'*\';\n\n\tif(bed_class != \"\")\n\t\tchk_string = chk_string + \'*\';\n\n\tif(bed_type != \"\")\n\t\tchk_string = chk_string + \'*\';\n\n\tif(gender != \"\")\n\t\tchk_string = chk_string + \'*\';\n\n\tif(age != \"\")\n\t\tchk_string = chk_string + \'*\';\n\n\tvar arr = chk_string.split(\"*\");\n*/\n\tif(nursing_unit == \"\" && speciality == \"\")\n\t{\n\t\tparent.frames[2].document.location.href = \"../../eCommon/html/blank.html\";\n\t\talert(getMessage(\'NU_OR_SPCLTY\',\"IP\"));\n\t}\n\telse if(document.forms[0].from_date.value == \"\" && document.forms[0].to_date.value != \"\")\n\t{\n\t\tvar error1 = getMessage(\'GENERAL_CNT_BE_BLANK\',\'IP\');\n\t\terror1 = error1.replace(\'$\',getLabel(\"Common.fromdate.label\",\"common\"));\n\t\talert(error1);\n\t}\n\telse if(document.forms[0].from_date.value != \"\" && document.forms[0].to_date.value == \"\")\n\t{\n\t\tvar error2 = getMessage(\'GENERAL_CNT_BE_BLANK\',\'IP\');\n\t\terror2 = error2.replace(\'$\',getLabel(\"Common.todate.label\",\"common\"));\n\t\talert(error2);\n\t}\n\telse\n\t{\n\t\tvar fields = new Array();\t\n\t\tfields[0] = document.forms[0].nursing_unit;\n\t\tvar names = new Array (getLabel(\'Common.nursingUnit.label\',\'common\'));\n\t\tvar params = \"\";\n\t\tfor( var i=0; i<frm.elements.length; i++ )\n\t\t{\n\t\t\tparams += frm.elements[i].name + \"=\" + escape(frm.elements[i].value) +\"&\";\n\t\t}\n\n\t\tvar avail_nursing_unit = document.forms[0].available_nursing_unit.value;\n\t\tif(document.forms[0].nursing_unit.value == \"\")\n\t\t\tavail_nursing_unit = \"\";\n\n\t\tvar obj = frm.available_nursing_unit\n\t\tvar len=obj.length;\n\t\tvar i=1;\n\t\tvar n_code\t=\tfrm.nursing_unit.value;\n\n\t\twhile(i<len)\n\t\t{\n\t\t\tlen=obj.length\n\t\t\tobj.remove(i)\n\t\t}\n\t\t// Added by Nanda 02/10/2002 \n\t\tvar wherecondn= document.forms[0].wherecondn.value;\n\t\tvar nursing_unit= document.forms[0].nursing_unit.value;\n\t\tvar bed_classification=document.forms[0].bed_classification.value;\n\t\tvar oper_stn_id=document.forms[0].oper_stn_id.value;\n\t\tparent.result.document.location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.processBar.document.location.href = \"../../eCommon/html/process.html\";\n\t\tdocument.forms[0].nursing_unit.disabled = true;\n\t\tdocument.forms[0].Splcode.disabled = true;\n\t\tdocument.forms[0].pract_id_search.disabled = true;\n\t\tdocument.forms[0].Bedcode.disabled = true;\n\t\tdocument.forms[0].bed_type_code.disabled = true;\n\t\tdocument.forms[0].bed_classification.disabled = true;\n\t\tdocument.forms[0].gender.disabled = true;\n\t\tdocument.forms[0].age_value.disabled = true;\n\t\tdocument.forms[0].age.disabled = true;\n\t\tdocument.forms[0].release_hrs.disabled = true;\n\t\tdocument.forms[0].search_by_beds.disabled = true;\n\t\tdocument.forms[0].search_butt.disabled = true;\n\t\tdocument.forms[0].clear_butt.disabled = true;\n\t\tif(document.forms[0].cancel_butt)\n\t\t\tdocument.forms[0].cancel_butt.disabled = true;\n\n\t\t\n\t\t//document.forms[0].BedListinOrder1.disabled = true;\n\t\t//document.forms[0].BedListinOrder2.disabled = true;\n\t\t//document.forms[0].BedListinOrder3.disabled = true;\n\t\t//document.forms[0].BedListinOrder4.disabled = true;\n\t\t\n\t\n\t\tdocument.forms[0].privacy_level.disabled = true;\n//\t\tdocument.forms[0].smoking.disabled = true;\n//\t\tdocument.forms[0].infectious_disease.disabled = true;\n\n\t\tvar patient_class = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\n\t\tif(document.forms[0].from_date.value != \"\" && document.forms[0].to_date.value != \"\")\n\t\t\tdocument.forms[0].bed_available_date_yn.value = \"Y\";\n\t\telse\n\t\t\tdocument.forms[0].bed_available_date_yn.value = \"N\";\n\n\t\tvar from_date = document.forms[0].from_date.value;\n\t\tvar to_date = document.forms[0].to_date.value;\n\t\tif(from_date!=null && from_date!=\'\')\n\t\t\tfrom_date = convertDate(from_date,\"DMYHM\",localeName,\"en\");\n\t\tif(to_date!=null && to_date!=\'\')\n\t\t\tto_date = convertDate(to_date,\"DMYHM\",localeName,\"en\");\n\n\t\tvar s = \'../jsp/BedAvailabilityChartCriteria1.jsp?bed_available_date_yn=\'+document.forms[0].bed_available_date_yn.value+\'&avail_nursing_unit=\'+avail_nursing_unit+\'&calledoption=\'+escape(calledoption)+\'&\'+params+\"&patient_class=\"+patient_class+\"&oper_stn_id=\"+oper_stn_id+\"&query_gender_type=\"+gender_type+\"&from_date_converted=\"+from_date+\"&to_date_converted=\"+to_date+\"&bed_booking_ref_no=\"+document.forms[0].bed_booking_ref_no.value;\n\t\t\n\t\tparent.dummy.location.href = s;\n\t}\n}\n\n\nfunction checkFields1( fields, names)\n{\n\tvar errors = \"\" ;\n\tfor( var i=0; i<fields.length; i++ ) \n\t{\n\t\tif(trimCheck1(fields[i].value)) \n\t\t{}\n\t\telse\t\n\t\t\terrors += getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(names[i])))+\"<br>\";\n\t}\n\tif ( errors.length != 0 ) \n\t{\n\t\talert(errors) ;\n\t\treturn false ;\n\t}\n\treturn true ;\n}\n\n\nfunction trimCheck1(inString)\n{\n\tvar startPos;\n\tvar ch;\n\tstartPos = 0;\n\tstrlength = inString.length;\n\n\tfor(var i=0;i<=strlength;i++) {\n\t\tch = inString.charAt(startPos);\n\t\tif((ch == \" \") || (ch == \"\\b\") || (ch == \"\\f\") || (ch == \"\\n\") || (ch == \"\\r\") || (ch == \"\\n\")) {\n\t\t\tstartPos++;\n\t\t}\n\t}\n\tif(startPos == inString.length) return false;\n\telse return true;\n}\n\n\nfunction submitBedListing(frm,calledoption)\n{\n\t\n\tvar params = \"\";\n\tfor( var i=0; i<frm.elements.length; i++ )\n\t\tparams += frm.elements[i]. name + \"=\" + escape(frm.elements[i].value) +\"&\";\n\n\tparent.result.location.href = \'../jsp/BedAvailabilityChartResult.jsp?calledoption=\'+escape(calledoption)+\'&\'+params;\n}\n\t\t\t\t\t\t\n\nfunction getBedListinOrder(obj)\n{\n\t\n\t\n\tvar val_id\t= new Array();\n\tval_id[0] = \"specialty_short_desc\";\n\tval_id[1] = \"bed_type_short_desc\";\n\tval_id[2] = \"room_long_desc\";\n\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\tval_id[3] = \"admission_type\";\n\tvar val\t\t= new Array();\n\tval[0] = getLabel(\"Common.speciality.label\",\"Common\");\n\tval[1] = getLabel(\"Common.bedtype.label\",\"Common\");\n\tval[2] = getLabel(\"Common.RoomCubicle.label\",\"Common\");\n\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\tval[3] = getLabel(\"Common.admissiontype.label\",\"Common\");\n\n\tif(obj.name == \"BedListinOrder1\")\n\t{\n\t\t\n\t\tif(obj.value == \"\")\n\t\t{\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.options[0].selected = true;\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.options[0].selected = true;\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true;\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.disabled = true;\n\n\t\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\t{\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.options[0].selected = true;\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true;\n\t\t\t}\n\t\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder2 );\n\t\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder3 );\n\t\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );\n\t\t\n\t\t\tfor ( var i=0; i<val_id.length; i++ )\n\t\t\t{\n\t\t\t\tvar element\t\t  = document.createElement(\"option\");\n\t\t\t\t\telement.value = val_id[i];\n\t\t\t\t\telement.text  =\tval[i];\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.add(element)\n\t\t\t}\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.disabled = false;\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.disabled =\ttrue;\n\t\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled =\ttrue;\n\n\t\t}\n\t}\n\telse\n\t{\n\t\t\n\t\tif(obj.name == \"BedListinOrder2\")\n\t\t{\n\t\t\t\n\t\t\tif(obj.value == \"\")\n\t\t\t{\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.options[0].selected = true\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true\n\t\t\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\t\t{\n\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.options[0].selected = true;\n\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true;\t\t\t\n\t\t\t\t}\n\t\n\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder3 );\n\t\t\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\t\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );\n\n\t\t\t\tfor ( var i=0; i<val_id.length; i++ )\n\t\t\t\t{\n\t\t\t\t\tvar element\t  = document.createElement(\"option\");\n\t\t\t\t\telement.value = val_id[i];\n\t\t\t\t\telement.text  =\tval[i];\n\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.add(element)\n\t\t\t\t}\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.remove(document.BedAvailabilityChart_Form0.BedListinOrder2.selectedIndex);\n\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.disabled = false ;\n\t\t\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled =\ttrue;\n\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(obj.name == \"BedListinOrder3\")\n\t\t\t{\n\t\t\t\tif(obj.value == \"\")\n\t\t\t\t{\n\t\t\t\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.options[0].selected = true;\n\t\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true\n\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t\telse if(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\t\t{\n\t\t\t\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );\n\n\t\t\t\t\tfor ( var i=0; i<val_id.length; i++ )\n\t\t\t\t\t{\n\t\t\t\t\t\tvar element\t  = document.createElement(\"option\");\n\t\t\t\t\t\telement.value = val_id[i];\n\t\t\t\t\t\telement.text  =\tval[i];\n\t\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.add(element)\n\t\t\t\t\t}\n\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);\n\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.remove(document.BedAvailabilityChart_Form0.BedListinOrder2.selectedIndex);\n\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.remove(document.BedAvailabilityChart_Form0.BedListinOrder3.selectedIndex);\n\t\t\t\n\t\t\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled = false ;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\n\t\t}\n\t}\n}\n\n\nfunction enableDisable(obj)\n{\n\t\n\t\n\tdocument.BedAvailabilityChart_Form0.from_date.value = \"\";\n\tdocument.BedAvailabilityChart_Form0.to_date.value = \"\";\n\n\tvar enable_bed_date = document.forms[0].enable_bed_date.value;\n\tif(obj.value == \'\' && enable_bed_date == \'Y\')\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.from_date.disabled = false;\n\t\tdocument.BedAvailabilityChart_Form0.to_date.disabled = false;\n\t\tdocument.getElementById(\"fromDtImg\").disabled = false;\n\t\tdocument.getElementById(\"toDtImg\").disabled = false;\n\t}\n\telse \n\t{\n\t\tdocument.BedAvailabilityChart_Form0.from_date.disabled = true;\n\t\tdocument.BedAvailabilityChart_Form0.to_date.disabled = true;\n\t\tdocument.getElementById(\"fromDtImg\").disabled = true;\n\t\tdocument.getElementById(\"toDtImg\").disabled = true;\n\t}\n\n\tif(document.BedAvailabilityChart_Form0.Splcode.value !=\"\")\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder1.options[1].selected = true;\n\t\t\n\t\tvar val_id\t= new Array();\n\t\tval_id[0] = \"specialty_short_desc\";\n\t\tval_id[1] = \"bed_type_short_desc\";\n\t\tval_id[2] = \"room_long_desc\";\n\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\tval_id[3] = \"admission_type\";\n\t\tvar val\t\t= new Array();\n\t\tval[0] = getLabel(\"Common.speciality.label\",\"Common\");\n\t\tval[1] = getLabel(\"Common.bedtype.label\",\"Common\");\n\t\tval[2] = getLabel(\"Common.RoomCubicle.label\",\"Common\");\n\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\tval[3] = getLabel(\"Common.admissiontype.label\",\"Common\");\n\n\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder2 );\n\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder3 );\n\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\tremoveitems( document.BedAvailabilityChart_Form0.BedListinOrder4 );\n\t\t\n\t\tfor ( var i=0; i<val_id.length; i++ )\n\t\t{\n\t\t\tvar element\t\t  = document.createElement(\"option\");\n\t\t\t\telement.value = val_id[i];\n\t\t\t\telement.text  =\tval[i];\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.add(element)\n\t\t}\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.disabled = false;\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.disabled =\ttrue;\n\t\tif(document.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility==\"visible\")\n\t\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled =\ttrue;\n\t}\n\n\t\n\tif(obj.value == \'\' && (\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" == \"CREATE_BOOKING_YN\" || \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" == \"CONFIRM_BOOKING_YN\") )\n\t{\n\t\t\n\t\tdocument.BedAvailabilityChart_Form0.from_date.value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" ;\n\t\tdocument.BedAvailabilityChart_Form0.from_date.disabled = true ;\n\t\tdocument.getElementById(\"fromDtImg\").disabled = true;\n\t\tdocument.BedAvailabilityChart_Form0.to_date.value = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" ;\n\t\tdocument.BedAvailabilityChart_Form0.to_date.disabled = false ;\n\t\tdocument.getElementById(\"toDtImg\").disabled = false;\n\t\t//document.BedAvailabilityChart_Form0.fromDtImg.disabled = true ;\n\t}\n\telse if(\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" == \"CONFIRM_BOOKING_YN\" )\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.from_date.value = \"\" ;\n\t\t//document.BedAvailabilityChart_Form0.from_date.disabled = false ;\n\t\t//document.BedAvailabilityChart_Form0.fromDtImg.disabled = false ;\n\t}\n\telse if(obj.value == \'\')\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.from_date.disabled = false ;\n\t\tdocument.getElementById(\"fromDtImg\").disabled = false;\n\t\tdocument.BedAvailabilityChart_Form0.to_date.disabled = false ;\n\t\tdocument.getElementById(\"toDtImg\").disabled = false;\n\t}\n\t\n\tif(document.forms[0].sm_cntl_assign_bed_count.value>0 ){\n\t\tdocument.forms[0].BedListinOrder1.options[3].selected = true;\n\t\tgetBedListinOrder(document.forms[0].BedListinOrder1);\n\t}\n\n}\n\nfunction displayBedOrder(obj)\n{\n\t\n\tif(!(obj.value==\'B\' || obj.value==\'V\'))\n\t{\n\t\taddOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder1);\n\t\taddOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder2);\n\t\taddOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder3);\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=\"visible\";\n\t\taddOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder4);\n\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.disabled = true ;\n\t\t//document.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true ;\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true ;\n\t\n\t}\n\telse\n\t{\n\t\t\n\t\taddOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder1);\n\t\taddOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder2);\n\t\taddOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder3);\n\t\taddOptionElement(document.BedAvailabilityChart_Form0.BedListinOrder4);\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=\"hidden\";\n\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.disabled = true ;\n\t\t//document.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true ;\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true ;\n\t}\n/*\n\tif(document.forms[0].Splcode.value != \'\')\n\t{\n\t\tdocument.forms[0].BedListinOrder1.options[1].selected = true;\t\t\n\t\tdocument.forms[0].BedListinOrder2.disabled = false;\t\t\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].BedListinOrder1.options[0].selected = true;\n\t}\n*/\n}\n\nfunction addOptionElement(bedlistorder)\n{\n\t\n\tremoveitems(bedlistorder);\n\n\tvar opt1 = document.createElement(\'Option\');\n\topt1.text = getLabel(\"Common.speciality.label\",\"Common\");\n\topt1.value = \"specialty_short_desc\";\n\tbedlistorder.add(opt1);\n\n\topt1 = document.createElement(\'Option\');\n\topt1.text = getLabel(\"Common.bedtype.label\",\"Common\");\n\topt1.value = \"bed_type_short_desc\";\n\tbedlistorder.add(opt1);\n\n\n\topt1 = document.createElement(\'Option\');\n\topt1.text = getLabel(\"Common.RoomCubicle.label\",\"Common\");\n\topt1.value = \"room_long_desc\";\n\tbedlistorder.add(opt1);\n\t\n\tif(!(document.BedAvailabilityChart_Form0.search_by_beds.value==\'B\' || document.BedAvailabilityChart_Form0.search_by_beds.value==\'V\'))\n\t{\n\t\topt1 = document.createElement(\'Option\');\n\t\topt1.text = getLabel(\"Common.admissiontype.label\",\"Common\");\n\t\topt1.value = \"admission_type\";\n\t\tbedlistorder.add(opt1);\n\t}\n\n}\n\n\nfunction removeitems(obj)\n{\n\tvar len=obj.length;\n\tvar i=1;\n\twhile(i<len)\n\t{\n\t\t\n\t\tlen=obj.length\n\t\tobj.remove(i)\n\t}\n}\n\n\t\t\t\nfunction popDynamicValues ( obj )\n{\t\t\n\tvar wherecondn= document.forms[0].wherecondn.value;\n}\n\n\nfunction popDynamicValues1 ( obj )\n{\t\t\t\t\n\tvar wherecondn= document.forms[0].wherecondn.value;\n}\n\nfunction disButtons()\n{\n\tvar callfunc =\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\tif(callfunc == \'ADMIT\')\n\t{\n\t\tparent.parent.frames[0].document.forms[0].create.disabled = true;\n\t\tparent.parent.frames[0].document.forms[0].apply.disabled = true;\n\t\tparent.parent.frames[0].document.forms[0].reset.disabled = true;\n\n\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t}\n}\n\t\t\t\n// added by chitra to default screen values \nfunction defaultValues()\n{\n\t\n\tdocument.BedAvailabilityChart_Form0.age_value.value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\tvar oper_stn_id=document.forms[0].oper_stn_id.value;\n\n\tvar p = document.BedAvailabilityChart_Form0.nursing_unit.options;\n\t\n\t\n\tfor (i=0; i<p.length; i++) \n\t{\n\t\tif(p[i].value == \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"){\n\t\t\t\tp[i].selected = true;\n\t\t}\n\t}\n\n\tp = document.BedAvailabilityChart_Form0.Splcode;\n\tfor (i=0; i<p.options.length; i++) \n\t{\n\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"&&p.options[i].value != \"\")\n\t\t{\n\t\t\t\n\t\t\tp.options[i].selected = true;\n\t\t}\n\t}\n\n\tp = document.BedAvailabilityChart_Form0.Bedcode;\n\tfor (i=0; i<p.options.length; i++) \n\t{\n\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"){\n\t\t\t\n\t\t\tp.options[i].selected = true;\n\t\t}\n\t}\n//document.BedAvailabilityChart_Form0.bed_type_code.disabled=true;\n\tp = document.BedAvailabilityChart_Form0.bed_type_code;\n\tfor (i=0; i<p.options.length; i++) \n\t{\n\t\t\n\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"){\n\t\t\t\n\t\t\tp.options[i].selected = true;\n\t\t}\n\t}\n\n\tp = document.BedAvailabilityChart_Form0.age;\n\tfor (i=0; i<p.options.length; i++) \n\t{\n\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\")\n\t\t\tp.options[i].selected = true;\n\t}\n\n\tvar params = \"\";\n\tfor( var i=0; i<document.BedAvailabilityChart_Form0.elements.length; i++ )\n\t{\n\t\tparams += document.BedAvailabilityChart_Form0.elements[i].name + \"=\" + document.BedAvailabilityChart_Form0.elements[i].value +\"&\";\n\t}\n\t\n\tvar patient_class = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\tvar oper_stn_id=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\n\tif(document.BedAvailabilityChart_Form0.Splcode.value!=\'\')\n\t{\n\t\t\n\t\tdocument.forms[0].BedListinOrder1.options[1].selected = true;\n\t\t//displayBedOrder(document.forms[0].search_by_beds);\n\t\t//enableDisable(document.forms[0].search_by_beds);\n\t\tgetBedListinOrder(document.forms[0].BedListinOrder1);\n\t\t\n\t}\n\telse\n\t{\n\t\t\n\t\tdocument.forms[0].BedListinOrder1.options[3].selected = true;\n\t\t//displayBedOrder(document.forms[0].search_by_beds);\n\t\t//enableDisable(document.forms[0].search_by_beds);\n\t\tgetBedListinOrder(document.forms[0].BedListinOrder1);\n\t\t\n\t}\n\n\t//BRU-CRF-196\n\tif(document.forms[0].wherecondn.value==\'CHG_NURS_UNIT_IN_ASSIGN_BED_YN\' && document.forms[0].sm_cntl_assign_bed_count.value>0 ){\n\t\tdocument.forms[0].BedListinOrder1.options[3].selected = true;\n\t\tgetBedListinOrder(document.forms[0].BedListinOrder1);\n\t}\n\t\n\t\t\n\t\t\n\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\talert(getMessage(\'NU_OR_SPCLTY\',\'IP\'));\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\tvar avail_nursing_unit = document.forms[0].available_nursing_unit.value;\n\t\n\t\tvar from_date = document.forms[0].from_date.value;\n\t\tvar to_date = document.forms[0].to_date.value;\n\t\tif(from_date!=null && from_date!=\'\')\n\t\t\tfrom_date = convertDate(from_date,\"DMYHM\",localeName,\"en\");\n\t\tif(to_date!=null && to_date!=\'\')\n\t\t\tto_date = convertDate(to_date,\"DMYHM\",localeName,\"en\");\n\n\t\tif(document.forms[0].from_date.value != \"\" && document.forms[0].to_date.value != \"\")\n\t\t\tdocument.forms[0].bed_available_date_yn.value = \"Y\";\n\t\telse\n\t\t\tdocument.forms[0].bed_available_date_yn.value = \"N\";\n\n\t\tvar s = \'../jsp/BedAvailabilityChartCriteria1.jsp?calledoption=C&\'+params+\"&ipparam_bed_yn=\"+bed_yn+\"&bed_available_date_yn=\"+document.forms[0].bed_available_date_yn.value+\"&avail_nursing_unit=\"+avail_nursing_unit+\"&patient_class=\"+patient_class+\"&oper_stn_id=\"+oper_stn_id+\"&from_date_converted=\"+from_date+\"&to_date_converted=\"+to_date+\"&bed_booking_ref_no=\"+document.forms[0].bed_booking_ref_no.value;\n\n\n//\t\tvar s = \'../jsp/BedAvailabilityChartCriteria1.jsp?calledoption=C&\'+params+\"&patient_class=\"+patient_class+\"&ipparam_bed_yn=\"+bed_yn+\"&oper_stn_id=\"+oper_stn_id ;\n\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\tparent.dummy.location.href = s;\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n}\t\n\t \n\nfunction fetchValForBedClass() {} \n\n\nfunction DateCompare(from,to) \n{\n\tvar flg1 = validDateObj(from,\"DMYHM\",localeName);\n\tvar flg2 = validDateObj(to,\"DMYHM\",localeName);\n\tvar func_name = document.forms[0].wherecondn.value;\n\t\n\tif(flg1 && !(func_name==\"CONFIRM_BOOKING_YN\" || func_name==\"CREATE_BOOKING_YN\" || func_name==\"REVISE_BOOKING_YN\"))\n\t{\n\t\tvar greg_frmdate = convertDate(from.value,\"DMYHM\",localeName,\"en\");\n\t    var greg_currdate = convertDate(document.forms[0].curdate.value,\"DMYHM\",\"en\",\"en\");\n\t\tif(!isBefore(greg_currdate,greg_frmdate,\"DMYHM\",\"en\"))\n\t\t{\n\t\t\talert(getMessage(\"FROM_DATE_LESS_SYSDATE\",\"SM\"));\n\t\t\tfrom.value = \"\";\n\t\t\tfrom.select();\n\t\t\tfrom.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n\t\n\tif(flg1 && flg2 )\n\t{\n\t\tvar greg_fromdate = convertDate(from.value,\"DMYHM\",localeName,\"en\");\n\t\tvar greg_todate = convertDate(to.value,\"DMYHM\",localeName,\"en\");\n\n\t\tif(!isBefore(greg_fromdate,greg_todate,\"DMYHM\",\'en\'))\n\t\t{\n\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\tto.value = \"\";\n\t\t\tto.focus();\n\t\t\tto.select();\n\t\t}\t\n\t}\n\treturn true;\n}\n</script>\n\n</head>\n<body onload=\"defaultValues();\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'BedAvailabilityChart_Form0\' id=\'BedAvailabilityChart_Form0\'  target=\'result\' >\n\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t<td class=\"COLUMNHEADER\" colspan=\'4\' >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</th>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t<tr>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\n\t\t<td width=\"18%\" class=\'label\' >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t<td class=\"fields\" width=\"20%\">";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t</td>\n\t\t<td width=\"12%\" class=\'label\' >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t<td  width=\"50%\" class=\"fields\" >\n\t\t\n\t\t\n\t\t<select name=\'Splcode\' id=\'Splcode\' onchange=\'setGroupBy(this)\' width=\"15\"><option value=\'\' selected>--- ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" ---\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t</select>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t<td  class=\"fields\"><input type=\'text\' name=\'release_hrs\' id=\'release_hrs\' maxlength=5 size=5  onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'specialChar(this)\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t<td class=\"fields\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t<td class=\"fields\" >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t<td class=\'fields\' >\n\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t<select name=\'bed_classification\' id=\'bed_classification\' disabled>\n\t\t\t\t<option value=\'P\' selected>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</option>\n\t\t\t</select>\n\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t<select name=\'bed_classification\' id=\'bed_classification\'>\n\t\t\t<option value=\'BB\' selected>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</option>\n\t\t\t<!-- modified on 19-05-08 -->\n\t\t\t<!--<option value=\'N\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</option>\n\t\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</option>\n\t\t\t<option value=\'B\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</option>\n\t\t\t-->\n\t\t<!-- -->\n\t\t\t</select>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t<select name=\'bed_classification\' id=\'bed_classification\'>\n\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t<option value=\'BB\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</option>\n\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\n\t\t\t<option value=\'N\' selected>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</option>\n\t\t\n\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</option>\n\t\t\t\t<option value=\'B\'>";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t</select>\n\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t</td>\t\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n\t\t<td class=\'fields\'><select name=\'search_by_beds\' id=\'search_by_beds\' onchange = \'displayBedOrder(this);enableDisable(this);\'><option value=\'\'>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</option><option value=\'B\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</option><option selected value=\'V\'>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</option><option value=\'O\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</option><option value=\'R\'>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</option></select></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t\t<td class=\'fields\'nowrap> ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" <input type=\'radio\' name=\'gender_type\' id=\'gender_type\' value=\'1\' checked> ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t<input type=\'radio\' name=\'gender_type\' id=\'gender_type\' value=\'2\' ></td>\t\n<!-- \t\t<td class=\'label\'>&nbsp;</td><td class=\'label\'>&nbsp;</td> -->\n\n<!-- \tif(call_func.equals(\"QUERY_BED_AVAIL\")) -->\n\n\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n\t<td class=\'fields\' ><input type=\'text\' name=\'from_date\' id=\'from_date\' size=\'16\' maxlength=\'16\'  disabled onblur=\"DateCompare(this,to_date);\"><input type=\"image\" id=\'fromDtImg\' disabled  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"from_date.focus();return showCalendar(\'from_date\',null,\'hh:mm\');\"> ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" <input type=\'text\' disabled name=\'to_date\' id=\'to_date\' size=\'16\' maxlength=\'16\'  onblur=\"DateCompare(from_date,this);\"><input  id=\'toDtImg\' type=\"image\" disabled  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"to_date.focus();return showCalendar(\'to_date\',null,\'hh:mm\');\"></td> \n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\t\t<td class=\'fields\'>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t<td class=\'fields\'><input type=\'text\' name=\'age_value\' id=\'age_value\' value=\'\' maxlength=\'5\' size=\'5\'  onKeyPress=\'return(ChkNumberInput(this,event,0))\'  onBlur=\'specialChar(this)\'><select name=\'age\' id=\'age\'>\n\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" ---</option>\n\t\t\t<option value=\'D\'>";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</option>\n\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</option>\n\t\t\t<option value=\'Y\'>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</option>\n\t\t</select></td>\n\t</tr>\n\t<!-- <tr>\n\t\t<td nowrap class=\'label\' >";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\t\t<td class=\'fields\'><input type=\"checkbox\" name=\"smoking\" id=\"smoking\" value=\"\" onClick=\"getCheckValue(this);\" ></td>\n\t\t<td class=\"LABEL\">";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t\t<td class=\'fields\'><input type=\"checkbox\" name=\"infectious_disease\" id=\"infectious_disease\" value=\"\" onClick=\"getCheckValue(this);\" ></td>\n\t</tr> -->\n\t<tr>\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t<td class=\'fields\' ><select name=\"privacy_level\" id=\"privacy_level\"><OPTION VALUE=\'\'>--- ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" ---</option>\n\t\t<option value=\'F\'>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</option>\n\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</option>\n\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</option>\n\t\t<option value=\'W\'>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</option>\n\t\t</select></td>\n\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</td>\n\t\t<td class=\'fields\'  >\n\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'label\' >&nbsp;</td>\n\t\t<td class=\'fields\' ><input type=\'button\' class=\'button\' name=\'search_butt\' id=\'search_butt\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' onclick=\"submitPage(this.form,\'search\')\"><input type=\'button\' name=\'clear_butt\' id=\'clear_butt\' class=\'button\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' onclick=\"clearCriteria();\">";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="<input type=\'button\' name=\'cancel_butt\' id=\'cancel_butt\' class=\'button\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' onclick=\'cancelAction();\'>";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t</td>\n\t</tr>\n</table>\n\t<input type=\"hidden\" name=\"available_nursing_unit\" id=\"available_nursing_unit\" value=\"\">\n\t<input type=\"hidden\" name=\"bed_available_date_yn\" id=\"bed_available_date_yn\" value=\"N\">\n\t<input type=\"hidden\" name=\"enable_bed_date\" id=\"enable_bed_date\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<input type=\"hidden\" name=\"reserve_bed_selectable\" id=\"reserve_bed_selectable\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t<input type=\"hidden\" name=\"bedClass_dis_yn\" id=\"bedClass_dis_yn\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t<input type=\"hidden\" name=\"call_func\" id=\"call_func\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<input type=\"hidden\" name=\"disable_field\" id=\"disable_field\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\"hidden\" name=\"ipparam_bed_yn\" id=\"ipparam_bed_yn\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t<input type=\"hidden\" name=\"main_bed_no\" id=\"main_bed_no\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<input type=\"hidden\" name=\"oper_stn_id\" id=\"oper_stn_id\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t<input type=\"hidden\" name=\"room_no_code\" id=\"room_no_code\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t<input type=\"hidden\" name=\"wherecondn\" id=\"wherecondn\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t<input type=\"hidden\" name=\"sm_cntl_assign_bed_count\" id=\"sm_cntl_assign_bed_count\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">  \n\t<input type=\'hidden\' name=\'curdate\' id=\'curdate\' value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">  \n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">  \n\t<input type=\'hidden\' name=\'bed_booking_ref_no\' id=\'bed_booking_ref_no\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">  \n\t<script>\n\t\tvar nurunit = \"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\"\n\t\tpopDynamicValues1(nurunit)\n\n\tif(\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" == \"CREATE_BOOKING_YN\")\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder1.options[1].selected = true;\t\t\n\t\tdocument.BedAvailabilityChart_Form0.Splcode.disabled = true;\t\n\t}\n\n\t\n\t\n\t</script>\t\n</form>\n<script>\n\tif(\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" == \"CREATE_BOOKING_YN\")\n\t{\t\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.disabled = false ;\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder2.remove(document.BedAvailabilityChart_Form0.BedListinOrder1.selectedIndex);\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder3.disabled = true ;\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.disabled = true ;\n\t\tdocument.BedAvailabilityChart_Form0.BedListinOrder4.style.visibility=\'hidden\';\t\n\t}\n\tdisButtons();\n\n\tvar wherecondn = \"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\";\n\t\n\tif (wherecondn==\'CREATE_BOOKING_YN\' || wherecondn==\'REVISE_BOOKING_YN\')\n\t{\n\t\tdocument.forms[0].bed_classification.value=\'N\';\n\t\tdocument.forms[0].search_by_beds.options[0].selected=true;\n\t\tdisplayBedOrder(document.forms[0].search_by_beds);\n\t\tenableDisable(document.forms[0].search_by_beds);\n\t}\t\n\telse if (wherecondn==\'CONFIRM_BOOKING_YN\' )\n\t{\n\t\tdocument.forms[0].search_by_beds.options[0].selected=true;\n\t\tdisplayBedOrder(document.forms[0].search_by_beds);\n\t\tenableDisable(document.forms[0].search_by_beds);\n\t}\n\telse\n\t{\t\t\n\t\tdisplayBedOrder(document.forms[0].search_by_beds);\n\t}\n\n\tvar disable_field\t=\t\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\";\n\tif (disable_field == \"NursingUnit\")\n\t{\t\t\n\t\t//document.BedAvailabilityChart_Form0.nursing_unit.disabled\t= true; 12/10/2008\n/*\n\t\tif(document.BedAvailabilityChart_Form0.ipparam_bed_yn.value==\'Y\')\n\t\t{\n\t\t\tdocument.BedAvailabilityChart_Form0.bed_type_code.disabled=true;\n\t\t\tdocument.BedAvailabilityChart_Form0.Bedcode.disabled=true;\n\t\t}*/\n\t}\n\telse if (disable_field == \"NursingUnitSpecialty\")\n\t{\n\t\t\n\t\t//document.BedAvailabilityChart_Form0.bed_type_code.disabled=true\n\t\tdocument.BedAvailabilityChart_Form0.nursing_unit.disabled\t= true;\n\t\tdocument.BedAvailabilityChart_Form0.Splcode.disabled\t\t= true;\n\t}\n\telse if (disable_field == \"specialty\")\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.Splcode.disabled\t\t= true;\n\t}\n\telse if (disable_field == \"NuBcBt\")\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.nursing_unit.disabled\t= true;\n\t}\n\telse if (disable_field == \"NuSyBcBt\")\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.nursing_unit.disabled\t= true;\n\t\tdocument.BedAvailabilityChart_Form0.Splcode.disabled\t\t= true;\n\t\tdocument.BedAvailabilityChart_Form0.bed_type_code.disabled=true;\n\t\tdocument.BedAvailabilityChart_Form0.Bedcode.disabled=true;\n\t}\n\telse if (disable_field == \"SyBcBt\")\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.Splcode.disabled\t\t= true;\n\t\tdocument.BedAvailabilityChart_Form0.bed_type_code.disabled=true;\n\t\tdocument.BedAvailabilityChart_Form0.Bedcode.disabled=true;\n\t}\n\telse if (disable_field == \"BcBt\")\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.bed_type_code.disabled=true;\n\t\tdocument.BedAvailabilityChart_Form0.Bedcode.disabled=true;\n\t}/*Friday, February 12, 2010 IN000242(emergency release),Nursing unit list item getting enable from Bed for Nursing Unit function*/\n\telse if (disable_field == \"Nursing\")\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.nursing_unit.disabled=true;\n\t}\n\n\n\t/// Added by Sridhar R on 13 JULY 2004\n\t/// This fuunction will default Bed Classification as \"Pseudo Bed\" & Disable the field, if the parameter bedClass_dis_yn value is \"Y\"...\n\tif(\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" == \'Y\')\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.bed_classification.value = \'P\';\n\t\tdocument.BedAvailabilityChart_Form0.bed_classification.disabled\t=true;\n\t}\n\telse\n\t{\n\t\tdocument.BedAvailabilityChart_Form0.bed_classification.disabled\t=false;\n\t}\n\t//document.forms[0].BedListinOrder1.options[3].selected = true;\n</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
	String age				= "";
	String call_function	= checkForNull(request.getParameter("call_function"));
	String main_bed_no		= checkForNull(request.getParameter("main_bed_no"));
	String call_func  		= checkForNull(request.getParameter("P_call_func"));
	String nursingunitcode	= checkForNull(request.getParameter("nursing_unit_code"));
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String enable_bed_date	= checkForNull(request.getParameter("enable_bed_date"),"N");
	String reserve_bed_selectable	= checkForNull(request.getParameter("reserve_bed_selectable"),"N");
	//String practitionerid	= checkForNull(request.getParameter("practitioner_id"));
	String ipparam_bed_yn	= checkForNull(request.getParameter("ipparam_bed_yn"));
	String practitioner_desc= checkForNull(request.getParameter("practitioner_desc"));
	String specialitycode	= checkForNull(request.getParameter("speciality_code"));
	String bedclasscode		= checkForNull(request.getParameter("bed_class_code"));
	String bed_type			= checkForNull(request.getParameter("bed_type"));
	String agevalue			= checkForNull(request.getParameter("age_value"));
	//String gender			= checkForNull(request.getParameter("gender"));
	String disable_field 	= checkForNull(request.getParameter("disable_field"));
	String patient_class 	= checkForNull(request.getParameter("patient_class"));
	String bedClass_dis_yn 	= checkForNull(request.getParameter("bedClass_dis_yn"));
	String room_no_code 	= checkForNull(request.getParameter("room_no_code"));
	String med_service_grp 	= checkForNull(request.getParameter("med_service_grp"));
	String create_booking_admission_date_time 	= checkForNull(request.getParameter("create_booking_admission_date_time"));
	String exp_discharge_date 	= checkForNull(request.getParameter("exp_discharge_date"));
	String bed_booking_ref_no 	= checkForNull(request.getParameter("bed_booking_ref_no"));


	String wherecondn 		= checkForNull(request.getParameter("wherecondn"));
	int sm_cntl_assign_bed_count=0;

	if(wherecondn.equals("")) 
		wherecondn = "ADMIT_PAT_YN";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String curdate = "";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" );
	java.util.Date dt=new java.util.Date();
	curdate = dateFormat.format( dt ) ;



            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bedClass_dis_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedClass_dis_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(main_bed_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(reserve_bed_selectable));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedClass_dis_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(main_bed_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(reserve_bed_selectable));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedClass_dis_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(exp_discharge_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(create_booking_admission_date_time));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedClass_dis_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(exp_discharge_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(create_booking_admission_date_time));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(room_no_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(room_no_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(room_no_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(room_no_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedClass_dis_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedClass_dis_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(room_no_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_service_grp));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(create_booking_admission_date_time));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(exp_discharge_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(age));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(agevalue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
 if (nursingunitcode.equals("") && specialitycode.equals("")	&& !call_func.equals("QUERY_BED_AVAIL")) {
            _bw.write(_wl_block60Bytes, _wl_block60);
} else {
            _bw.write(_wl_block61Bytes, _wl_block61);
     if (!call_func.equals("QUERY_BED_AVAIL")) {
            _bw.write(_wl_block62Bytes, _wl_block62);
}
			}
            _bw.write(_wl_block63Bytes, _wl_block63);
 if(call_func.equals("ADMIT")) 
	{	
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
	} 
            _bw.write(_wl_block66Bytes, _wl_block66);
	if(call_func.equals("QUERY_BED_AVAIL"))
	{
		wherecondn = "";
	}	
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            {java.lang.String __page ="NursingUnitComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("wherecondn"), weblogic.utils.StringUtils.valueOf(wherecondn
                        )},{ weblogic.utils.StringUtils.valueOf("patient_class"), weblogic.utils.StringUtils.valueOf(patient_class
                        )},{ weblogic.utils.StringUtils.valueOf("med_service_grp"), weblogic.utils.StringUtils.valueOf(med_service_grp
                        )},{ weblogic.utils.StringUtils.valueOf("specialitycode"), weblogic.utils.StringUtils.valueOf(specialitycode
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }/*if(call_func.equals("QUERY_BED_AVAIL")){out.println("<img src='../../eCommon/images/mandatory.gif'></img>");



		}	*/
_bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
  try
		{
			con = ConnectionManager.getConnection(request);		
			//String sql2=" Select Speciality_code, short_desc from AM_SPECIALITY_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ";
			/*Wednesday, May 05, 2010 , modified for PE*/
			String sql2=" Select Speciality_code, am_get_desc.am_speciality(speciality_code,?,2)short_desc  from AM_SPECIALITY where eff_status='E' order by short_desc ";
			String Splcode   = "";
			String Spldesc   = "";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,locale);
			rs = pstmt.executeQuery();
			if( rs != null )
			{
				while( rs.next() )
				{
					Splcode   = rs.getString(1);
					Spldesc   = rs.getString(2);
	
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(Splcode));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(Spldesc));
            _bw.write(_wl_block69Bytes, _wl_block69);
		}
			}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

			pstmt = con.prepareStatement("select count(*) sm_cntl_assign_bed_count from sm_function_control where FUNCTIONALITY_ID='ASSIGN_BED' and module_ID='IP' and SITE_ID= (select CUSTOMER_ID from SM_SITE_PARAM)");
			
			rs = pstmt.executeQuery();

			if (rs!=null && rs.next()){
				sm_cntl_assign_bed_count=rs.getInt("sm_cntl_assign_bed_count");
			}

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			}catch(Exception e) { 
				//out.println(e.getMessage()); 
				e.printStackTrace();}
			finally
			{		  
				ConnectionManager.returnConnection(con,request);
		  }
	
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
            {java.lang.String __page ="PractitionerComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("practitioner_desc"), weblogic.utils.StringUtils.valueOf(practitioner_desc
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
            {java.lang.String __page ="BedClassComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("ipparam_bed_yn"), weblogic.utils.StringUtils.valueOf(ipparam_bed_yn
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            {java.lang.String __page ="BedTypeComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("ipparam_bed_yn"), weblogic.utils.StringUtils.valueOf(ipparam_bed_yn
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
	if (bed_type.equals("pseudo"))
		{	
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
	}
		else if(bed_type.equals("baby"))
		{	
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
	}
		else
		{	
            _bw.write(_wl_block91Bytes, _wl_block91);
	if(!call_function.equals("Transfer_Patient"))
			{	
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
	}	
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
 if(!(wherecondn.equalsIgnoreCase("CREATE_BOOKING_YN") || wherecondn.equalsIgnoreCase("REVISE_BOOKING_YN"))) 
			{	
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
	}	
            _bw.write(_wl_block98Bytes, _wl_block98);
	}	
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            {java.lang.String __page ="GenderComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            {java.lang.String __page ="BedListinOrderComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("attribute"), weblogic.utils.StringUtils.valueOf("BedListinOrder1")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block69Bytes, _wl_block69);
            {java.lang.String __page ="BedListinOrderComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("attribute"), weblogic.utils.StringUtils.valueOf("BedListinOrder2")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block69Bytes, _wl_block69);
            {java.lang.String __page ="BedListinOrderComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("attribute"), weblogic.utils.StringUtils.valueOf("BedListinOrder3")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block69Bytes, _wl_block69);
            {java.lang.String __page ="BedListinOrderComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("attribute"), weblogic.utils.StringUtils.valueOf("BedListinOrder4")},{ weblogic.utils.StringUtils.valueOf("attribute"), weblogic.utils.StringUtils.valueOf("disabled")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block128Bytes, _wl_block128);
if(!call_func.equals("QUERY_BED_AVAIL")){
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block130Bytes, _wl_block130);
}
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(enable_bed_date));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(reserve_bed_selectable));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bedClass_dis_yn));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(main_bed_no));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(room_no_code));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(sm_cntl_assign_bed_count));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(curdate));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(bed_booking_ref_no));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(disable_field));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(bedClass_dis_yn));
            _bw.write(_wl_block154Bytes, _wl_block154);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedAvailabilityChart.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.IncludeBedtobereleasedin.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedClassification.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PseudoBed.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BabiesBeds.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NormalBeds.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PseudoBed.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BabiesBeds.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NormalBeds.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PseudoBed.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedstatus.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booked.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Vacant.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Occupied.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reserved.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.GenderType.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PatientGender.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedGender.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedAvailablibilityDate.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Years.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Smoking.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InfectiousDisease.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RoomCubicleStatus.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Isolation.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrivateRoom.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SemiPrivateRoom.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RoomCubicle.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.groupby.label", java.lang.String .class,"key"));
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
}
