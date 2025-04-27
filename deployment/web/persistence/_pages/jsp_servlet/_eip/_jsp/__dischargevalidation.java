package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __dischargevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeValidation.jsp", 1742378787080L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>            \n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eIP/js/AdmitPatient.js\' language=\'Javascript\'></script>\n<script src=\'../../eIP/js/AdmitPatient1.js\' language=\'Javascript\'></script>\n<script language=\"JavaScript\">\n\nvar continueFlag = \"Y\";\nvar temp2 = \"\";\n\nfunction makeDisabled(booleanFlag)\n{\n\tif(parent.frames.length>1)\t\t\n\t{\n\t\tif(parent.frames[1].frames.length>0)\n\t\t{\n\t\t\tif(parent.frames[1].frames[0].document.Select_form && parent.frames[1].frames[0].name==\"Select_frame\")\n\t\t\t{\n\t\t\t\tvar booking_ref_no\t\t=\tparent.frames[1].frames[0].document.Select_form.booking_ref_no;\n\t\t\t\tvar patient_id\t\t\t=\tparent.frames[1].frames[0].document.Select_form.patient_id;\n\t\t\t\tvar referral_id\t\t\t=\tparent.frames[1].frames[0].document.Select_form.referral_id;\n\t\t\t\tvar encounter_id\t\t=\tparent.frames[1].frames[0].document.Select_form.encounter_id;\n\t\t\t\tvar book_ref_no_search\t=\tparent.frames[1].frames[0].document.Select_form.book_ref_no_search;\n\t\t\t\tvar patient_id_search\t=\tparent.frames[1].frames[0].document.Select_form.patient_id_search;\n\t\t\t\tvar referral_id_search\t=\tparent.frames[1].frames[0].document.Select_form.referral_id_search;\n\t\t\t\t\n\t\t\t\tif( (trimCheck(booking_ref_no.value)) || (trimCheck(patient_id.value)) || (trimCheck(referral_id.value)) || (trimCheck(encounter_id.value)) )\n\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.referral_id.value != \"\")\n\t\t\t\t\t\tparent.frames[1].frames[3].document.getElementById(\"referal_details\").disabled = false\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.frames[1].frames[3].document.getElementById(\"referal_details\").disabled = true\n\n\t\t\t\t\tif(booleanFlag)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther = true;\n\t\t\t\t\t}\n\n\t\t\t\t\tbooking_ref_no.readOnly\t\t\t=\tbooleanFlag;\n\t\t\t\t\treferral_id.readOnly\t\t\t=\tbooleanFlag;\n\t\t\t\t\tencounter_id.readOnly\t\t\t=\tbooleanFlag;\n\t\t\t\t\tbook_ref_no_search.disabled\t\t=\tbooleanFlag;\n\t\t\t\t\treferral_id_search.disabled\t\t=\tbooleanFlag;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\tparent.frames[1].frames[0].proceedFurther = true;\n\t\t\t}\n\t\t}\n\t}\n}\t\n</script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body CLASS=\"MESSAGE\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"DischargeValidation_form\" id=\"DischargeValidation_form\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[2].document.forms[0].informed_name.value = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n   \t\t\t\t\tparent.frames[2].document.forms[0].informed_name.disabled=false;\n\t\t\t\t\tparent.frames[2].document.forms[0].informed_name.focus();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].document.forms[0].informed_name.value = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t   \t\t\t\tparent.frames[1].document.forms[0].informed_name.disabled=false;\n\t\t\t\t\tparent.frames[1].document.forms[0].informed_name.focus();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[0].document.forms[0].informed_name.value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n  \t\t\t\t\t\tparent.frames[0].document.forms[0].informed_name.disabled=false;\n\t\t\t\t\t\tparent.frames[0].document.forms[0].informed_name.focus();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<script>\n\t\tparent.frames[2].document.getElementById(\'deathlable\').innerText\t    =\t\"Death Date/Time \";\n\t\tparent.frames[2].document.getElementById(\'death_id\').style.visibility\t    =\t\"Visible\";\n\t\tparent.frames[2].document.getElementById(\'selcalimg\').style.visibility\t    =\t\"Visible\";\n\t\tparent.frames[2].document.getElementById(\'postmortlable\').innerText\t    =\t\"Post-mortem requested \";\n\t\tparent.frames[2].document.getElementById(\'post_check\').style.visibility\t    =\t\"Visible\";\n\t\tparent.frames[2].document.getElementById(\'deathimg\').style.visibility\t    =\t\"Visible\";\n\t\tparent.frames[2].document.dischargeadvice_form.death_date.disabled\t=\tfalse;\n\t\tparent.frames[2].document.dischargeadvice_form.deathimg.style.visibility\t=\t\'visible\'; \n\t\tparent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled = false;\n\t\tparent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=true;\n\t\tparent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.newmedicine.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.lab.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.lab.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.xray.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.xray.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.scan.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.scan.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.ultrasound.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.ultrasound.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.mri.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.mri.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.rt.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.rt.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.physio.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.physio.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.ecg.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.ecg.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.diet.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.diet.disabled=true;\n\t\tparent.frames[2].document.dischargeadvice_form.pharmacy.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.pharmacy.disabled=true;\n\t\t\n\t</script>\n\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\tparent.frames[2].document.getElementById(\'deathlable\').innerText\t    =\t\'\';\n\t\t\tparent.frames[2].document.getElementById(\'death_id\').style.visibility\t    =\t\"Hidden\";\n\t\t\tparent.frames[2].document.getElementById(\'selcalimg\').style.visibility\t    =\t\"Hidden\";\n\t\t\n\t\t\tparent.frames[2].document.getElementById(\'postmortlable\').innerText\t    =\t\'\';\n\t\t\tparent.frames[2].document.getElementById(\'post_check\').style.visibility\t    =\t\"Hidden\";\n\t\t\tparent.frames[2].document.getElementById(\'deathimg\').style.visibility\t    =\t\"Hidden\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script>\n\t\tparent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.newmedicine.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.lab.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.lab.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.xray.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.xray.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.scan.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.scan.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.ultrasound.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.ultrasound.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.mri.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.mri.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.rt.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.rt.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.physio.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.physio.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.ecg.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.ecg.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.diet.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.diet.disabled=false;\n\t\tparent.frames[2].document.dischargeadvice_form.pharmacy.checked=false;\n\t\tparent.frames[2].document.dischargeadvice_form.pharmacy.disabled=false;\n\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\tparent.frames[2].document.getElementById(\'deathlable\').innerText\t    =\t\'\';\n\t\t\tparent.frames[2].document.getElementById(\'death_id\').style.visibility\t    =\t\"Hidden\";\n\t\t\tparent.frames[2].document.getElementById(\'selcalimg\').style.visibility\t    =\t\"Hidden\";\n\t\t\n\t\t\tparent.frames[2].document.getElementById(\'postmortlable\').innerText\t    =\t\'\';\n\t\t\tparent.frames[2].document.getElementById(\'post_check\').style.visibility\t    =\t\"Hidden\";\n\t\t\tparent.frames[2].document.getElementById(\'deathimg\').style.visibility\t    =\t\"Hidden\";\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\t\t\t<script>\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.newmedicine.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.lab.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.lab.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.xray.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.xray.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.scan.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.scan.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.ultrasound.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.ultrasound.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.mri.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.mri.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.rt.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.rt.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.physio.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.physio.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.ecg.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.ecg.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.diet.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.diet.disabled=true;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.pharmacy.checked=false;\n\t\t\t\tparent.frames[2].document.dischargeadvice_form.pharmacy.disabled=true;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[1].frames[3].document.getElementById(\"contact_details\").disabled = false;\n\t\t\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<script>\n\t\t\tparent.frames[1].frames[3].document.getElementById(\"contact_details\").disabled = true;\n\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<script>\n\t\tif (continueFlag==\"Y\")\n\t\t{\n\t\t\tmakeDisabled(true);\n\t\t\tvar frame_ref = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\tif(frame_ref == \"\")\n\t\t\tframe_ref = \"parent.frames[1].frames[2]\";\n\n\t\t\tif(eval(frame_ref+\'.document.AdmitPatient_form.nursing_unit\'))\n\t\t\t{\n\t\t\t\tSplcode = eval(frame_ref+\'.document.AdmitPatient_form.Splcode.value\');\n\t\t\t\tif(Splcode==\"\")\tSplcode\t=\t\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t}\n\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<script>\n\t\t\tif (continueFlag==\"Y\")\n\t\t\tmakeDisabled(false);\n\t\t</script>\t\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<script>\n\t\t\t\tvar n = parent.frames[2].document.getElementById(\"dischargestatus\").options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{ \n\t\t\t\t\tparent.frames[2].document.getElementById(\"dischargestatus\").remove(0);\n\t\t\t\t}\n\t\t\t\tvar tp =\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\t\tvar opt=parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t\topt.text=tp;\n\t\t\t\topt.value=\"\";\n\t\t\t\tparent.frames[2].document.getElementById(\"dischargestatus\").add(opt);\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<script>\n\t\t\tvar n = parent.frames[2].document.getElementById(\'dischargestatus\').options.length;\n\t\t\tfor(var i=0;i<n;i++)\n\t\t\t{ \n\t\t\t\tparent.frames[2].document.getElementById(\'dischargestatus\').remove(0);\n\t\t\t}\n\t\t\tvar tp =\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\tvar opt=parent.frames[2].document.createElement(\"OPTION\");\n\t\t\topt.text=tp;\n\t\t\topt.value=\"\";\n\t\t\t\tparent.frames[2].document.getElementById(\'dischargestatus\').add(opt);\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar oOption = parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\toOption.text=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t\t\t\toOption.value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\t\t\t\t\tparent.frames[2].document.getElementById(\'dischargestatus\').add(oOption);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\t\t\t\tparent.frames[2].document.getElementById(\'dischargestatus\').add(oOption);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n<!-- Added on 28/04/2003-->\n\t<input type = \'hidden\' name = \'queryString\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type = \'hidden\' name = \'referralid\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type = \'hidden\' name = \'sStyle\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n</body>\n</form>\n</html>\n<!-- \nThe Following Method is to compare the date passesd as String argument with sysdate+offset Days.\nIt returns true if Argument Date is less than Sysdate\n-->\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	String locale			= (String)session.getAttribute("LOCALE");
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	Connection			con			=	null;
	Statement			stmt		=	null;
	ResultSet			rset		=	null;
	PreparedStatement	pstmt		=	null;

	String	facilityId				=	"",		value1					=	""; 
	String	value2					=	"",		value3					=	""; 
	String	from					=	"",		value5					=	"";
	String	patientid				=	"";
	String	bookingrefno			= "";
	String	referralid				= "";
	String	sql						= ""; 
	String	specialitycode			= "";
	String  queryString				= "";
//	String  financial_detail_ref_id = "";
//	String  org_type_data			= "";
	String  bed_block_period_normal = "";
	boolean	continueyn				=	true;

	try
	{
		con					   =	ConnectionManager.getConnection(request);
		stmt				   =	con.createStatement();
		value1				   =	checkForNull(request.getParameter("field1"));
		value2				   =	checkForNull(request.getParameter("field2"));
		value3				   =	checkForNull(request.getParameter("field3"));
		from				   =	checkForNull(request.getParameter("field4"));
		bed_block_period_normal=	checkForNull(request.getParameter("bed_block_period_normal"));
		facilityId			   =	(String)session.getValue("facility_id");
		patdata.setFacility_id(facilityId);
		value5				=	checkForNull(request.getParameter("field5"));
		queryString 		=	checkForNull(request.getParameter("queryString"));
		String frame_ref = checkForNull(request.getParameter("frame_ref"));
		//added on 3-7-2008 for SCR 3228
		String indicator		= checkForNull(request.getParameter("indicator"));
		String discharge_type	= checkForNull(request.getParameter("discharge_type"));
		String code             = "";
		String desc             = "";

	
		if ((from.equals("TransferOutForm")) && (!value2.equals("")) )
		{
			StringBuffer sqlBuffer	= new StringBuffer();
			String info_pat_name	= "";
			if (value3.equals("01"))
			{
				sqlBuffer.append(" select contact1_name info_pat_name from MP_PAT_REL_CONTACTS where patient_id = '");
				sqlBuffer.append(value2);
				sqlBuffer.append("' ");
			}
			else if (value3.equals("02"))
			{
				sqlBuffer.append(" select contact2_name info_pat_name from MP_PAT_REL_CONTACTS where patient_id = '");
				sqlBuffer.append(value2);
				sqlBuffer.append("' ");
			}
			
			pstmt	=	con.prepareStatement(sqlBuffer.toString());
			rset	=	pstmt.executeQuery();	
			if ((rset != null) && (rset.next()))
				info_pat_name = checkForNull(rset.getString("info_pat_name"));
 			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();

			
			
			if ((value5.equals("Discharge"))  && (info_pat_name.equals("")) )
			{
				out.println("<script>parent.frames[2].document.forms[0].informed_name.value = '';</script>");	
			}
			else if ((value5.equals("TransferIn")) && (info_pat_name.equals("")) )
			{
				out.println("<script>parent.frames[1].document.forms[0].informed_name.value = '';</script>");	
			}

			if ((value5.equals("Discharge")) &&  (!info_pat_name.equals("")))
			{
				
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(info_pat_name));
            _bw.write(_wl_block5Bytes, _wl_block5);

			}
			else if ((value5.equals("TransferIn")) &&  (!info_pat_name.equals("")))
			{
				
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(info_pat_name));
            _bw.write(_wl_block7Bytes, _wl_block7);

			}
			else if ((value5.equals("TransferOut")) && ((!info_pat_name.equals(""))))
			{
				out.println("<script>parent.frames[2].document.forms[0].info_pat_name.value = \""+info_pat_name+"\"; parent.frames[2].document.forms[0].info_pat_name.focus();</script>");
			}
			if ((value5.equals("Discharge")) && (info_pat_name.equals("")))
			{	

			out.println("<script>parent.frames[2].document.forms[0].informed_name.value = '';</script>");
			}
			return;
		}
		else if((from.equals("DischargeCheckList")) && (!value2.equals("")) )
		{
			StringBuffer sqlBuffers	= new StringBuffer();
			String info_pat_name	= "";
			if (value3.equals("01"))
			{
				sqlBuffers.append(" select contact1_name info_pat_name from MP_PAT_REL_CONTACTS where patient_id = '");
				sqlBuffers.append(value2);
				sqlBuffers.append("' ");
			}
			else if (value3.equals("02"))
			{
				sqlBuffers.append(" select contact2_name info_pat_name from MP_PAT_REL_CONTACTS where patient_id = '");
				sqlBuffers.append(value2);
				sqlBuffers.append("' ");
			}
			

			pstmt	=	con.prepareStatement(sqlBuffers.toString());
			rset	=	pstmt.executeQuery();	
			if ((rset != null) && (rset.next()))
				info_pat_name = checkForNull(rset.getString("info_pat_name"));
 			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();

			if ((value5.equals("Discharge"))  && (info_pat_name.equals("")) )
			{
				out.println("<script>parent.frames[0].document.forms[0].informed_name.value = '';</script>");	
			}

			if ((value5.equals("Discharge")) &&  (!info_pat_name.equals("")))
			{
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(info_pat_name));
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
					
			if ((value5.equals("Discharge")) && (info_pat_name.equals("")))
			{	
				out.println("<script>parent.frames[0].document.forms[0].informed_name.value = '';</script>");
			}
		}
		else if(from.equals("Discharge_form"))
		{
			String	dischargetypecode   =	value1;
			String	deceasedyn			=	"";
			//Added by kishore for Bed Block Details on 8/26/2004
			String dischage_type		=	value3;
			String blk_rs				= value5;
			String blocking_type="";
			int block_period=0;
			String blocked_until_date="";
			String blocking_code	= "";
			String str_block_period="";			
		
			if(!dischage_type.equals(""))
			{ 
				 String blocking_date="SELECT a.blocking_type_code, ip_get_desc.ip_blocking_type (a.blocking_type_code, '"+locale+"', '2' ) blocking_type_short_desc, CASE WHEN a.block_period IS NOT NULL THEN DECODE (a.block_units,  'D', a.block_period * 24,  'H', a.block_period  )  ELSE b.bed_block_period_normal  END block_period,  CASE  WHEN a.block_period IS NOT NULL THEN TO_CHAR (DECODE (a.block_units,  'D', SYSDATE + a.block_period,  'H', SYSDATE + a.block_period / 24  ),  'dd/mm/rrrr hh24:mi'  )  ELSE TO_CHAR (SYSDATE + b.bed_block_period_normal / 24,  'dd/mm/rrrr hh24:mi'  )  END blocked_until_date FROM ip_discharge_type_vw a, ip_param b  WHERE discharge_type_code = '"+dischage_type+"' AND facility_id = '"+facilityId+"' ";
				
				 rset = stmt.executeQuery(blocking_date);		
			    if (rset.next()) {
					blocking_code = checkForNull(rset.getString("blocking_type_code"));
					blocking_type = checkForNull(rset.getString("blocking_type_short_desc"));					
					blocked_until_date = checkForNull(rset.getString("blocked_until_date"));					
					block_period =rset.getInt("BLOCK_PERIOD");		
					if (rset!=null) rset.close();
				 }

				if(!blocking_code.equals("")) {									out.print("<script>parent.frames[2].document.forms[0].blocking_type.value=\""+blocking_type+"\";parent.frames[2].document.forms[0].bed_blocking_period.value=\""+block_period+"\";parent.frames[2].document.forms[0].bed_block_until.value=\""+blocked_until_date+"\";parent.frames[2].document.forms[0].blocking_type_code.value=\""+blocking_code+"\";</script>");
				}  else { 						out.print("<script>parent.frames[2].document.forms[0].blocking_type.value='';parent.frames[2].document.forms[0].blocking_type.disabled=true;parent.frames[2].document.forms[0].bed_blocking_period.value='';parent.frames[2].document.forms[0].bed_blocking_period.disabled=true;parent.frames[2].document.forms[0].bed_block_until.value='';parent.frames[2].document.forms[0].bed_block_remarks.value='';parent.frames[2].document.forms[0].bed_block_remarks.disabled=true;parent.frames[2].document.forms[0].auth_pract_desc.focus();</script>");
		      }				
		}
		else if(!blk_rs.equals(""))
		{
			block_period = Integer.parseInt(blk_rs);			
			if(block_period >0)
			{	
				
				str_block_period = " select to_char((sysdate+'"+block_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual";
				
				rset = stmt.executeQuery(str_block_period);
				if (rset != null && rset.next())
				{
					blocked_until_date = rset.getString("a");
					if(blocked_until_date==null) blocked_until_date="";
					if (rset!=null) rset.close();
					
				}
				String blocked_until_date_display = blocked_until_date; 

				blocked_until_date_display = DateUtils.convertDate(blocked_until_date,"DMYHM","en",locale);
				//out.println("<script>alert('"+blocked_until_date_display+"');</script>");
				out.print("<script>parent.frames[2].document.forms[0].bed_block_until.value='"+blocked_until_date_display+"';</script>");
				}
			else
			{
			out.print("<script>parent.frames[2].document.forms[0].bed_block_until.value='';</script>");
			}
		}
			//Ended Here on 8/26/2004
			else if(!dischargetypecode.equals(""))
			{
				sql			=	" select deceased_yn from IP_DISCHARGE_TYPE where discharge_type_code = '"+dischargetypecode+"' and eff_status = 'E'" ;		
				
				rset		=	stmt.executeQuery(sql);
				if(rset != null && rset.next())
					deceasedyn	=	rset.getString("deceased_yn");
					if (rset!=null) rset.close();
					
				if(deceasedyn.equals("Y"))
					out.print("<script>parent.frames[2].document.DischargePatient_form.deceased_yn.checked = true;parent.frames[2].document.DischargePatient_form.deceased_yn.disabled = true;parent.frames[2].document.DischargePatient_form.deceased_yn.value = 'Y';parent.frames[2].document.DischargePatient_form.post_mortem_request.disabled =  false;parent.frames[2].document.DischargePatient_form.post_mortem_request.checked=true;parent.frames[2].document.DischargePatient_form.DECEASED_DATE_TIME.disabled = false;parent.frames[2].document.getElementById('deceasedimg').style.visibility='visible';parent.frames[2].document.DischargePatient_form.new_medicine.value='N';parent.frames[2].document.DischargePatient_form.new_medicine.checked=false;parent.frames[2].document.DischargePatient_form.new_medicine.disabled=true;parent.frames[3].Medical_Certificate.disabled=true;<!-- parent.frames[2].document.DischargePatient_form.referred.checked=false;parent.frames[2].document.DischargePatient_form.referred.disabled=true;parent.frames[2].enable_referred(parent.frames[2].document.DischargePatient_form.referred);parent.frames[2].document.getElementById('calcomp').disabled = false; --></script>");
				else
					out.print("<script>parent.frames[2].document.DischargePatient_form.deceased_yn.checked = false;parent.frames[2].document.DischargePatient_form.deceased_yn.disabled = true;parent.frames[2].document.DischargePatient_form.deceased_yn.value = 'N';parent.frames[2].document.DischargePatient_form.post_mortem_request.checked = false;parent.frames[2].document.DischargePatient_form.post_mortem_request.disabled = true;parent.frames[2].document.DischargePatient_form.DECEASED_DATE_TIME.value='';parent.frames[2].document.DischargePatient_form.DECEASED_DATE_TIME.disabled = true;parent.frames[2].document.getElementById('deceasedimg').style.visibility='hidden';parent.frames[2].document.DischargePatient_form.new_medicine.disabled = false;parent.frames[3].document.getElementById('Medical_Certificate').disabled=false;<!-- parent.frames[2].document.DischargePatient_form.bookingappointment.disabled=false;parent.frames[2].document.DischargePatient_form.referred.disabled=false;parent.frames[2].document.getElementById('calcomp').disabled = true;parent.frames[2].document.DischargePatient_form.bookingappointment.disabled=false; --></script>"); 
			}
		}
		else if(from.equals("Prepare_Discharge_form"))
		{
			// Changed Frame reference from frames[1] to frames[2] as Prepare Discharge form Design Changed on 27 MAY 2004 by SRIDHAR ...
			String	dischargetypecode =	value1;
			String	pat_dtls_unknown_yn	=	value3;
			String	deceasedyn =	value2;
			String patient_status = request.getParameter("patient_status");
			
			if(patient_status == null)patient_status = "";

			if(dischargetypecode.equals(""))
			{
				out.print("<script>parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled=true;parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;</script>");
			}
			else if(!dischargetypecode.equals(""))
			{
				sql		=	"  select deceased_yn from IP_DISCHARGE_TYPE where discharge_type_code = '"+dischargetypecode+"' and eff_status = 'E' ";
				
				rset	=	stmt.executeQuery(sql);
				if(rset != null && rset.next())
					deceasedyn	=	rset.getString("deceased_yn");
				if (rset!=null) rset.close();
					
				out.println("<script>parent.frames[2].document.dischargeadvice_form.check_death_date.value = \""+deceasedyn+"\";</script>");
	if(deceasedyn.equals("Y"))
	{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

	  /// If the Discahrge Type is "Deceased" then the Absconding details must not be Entered...
		
	}		  
		else if ((pat_dtls_unknown_yn.equals("Y")) && (!deceasedyn.equals("Y")))
		{	out.print("<script>parent.frames[2].document.dischargeadvice_form.death_date.value='';parent.frames[2].document.dischargeadvice_form.death_date.disabled=true;parent.frames[2].document.dischargeadvice_form.deathimg.style.visibility='hidden';parent.frames[2].document.getElementById('death_id').style.visibility='hidden';parent.frames[2].document.getElementById('selcalimg').style.visibility='Hidden';parent.frames[2].document.getElementById('post_check').style.visibility='hidden';parent.frames[2].document.getElementById('deathimg').style.visibility='hidden';parent.frames[2].document.getElementById('calImage1').disabled=true;parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled =true;parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=false;parent.frames[2].document.dischargeadvice_form.referral_type.value='X';parent.frames[2].getval1(parent.frames[2].document.dischargeadvice_form.referral_type);parent.frames[2].document.dischargeadvice_form.referral_type.disabled=true;</script>");
		
		  			/// If the Discahrge Type is not "Deceased" then the Absconding details can be Entered...
					out.print("<script>parent.frames[2].document.dischargeadvice_form.absconding_yn.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_yn.checked=false;parent.frames[2].document.dischargeadvice_form.absconding_date.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_date.value='';parent.frames[2].document.getElementById('calImage').disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_rep_to.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_rep_to.value='';parent.frames[2].document.getElementById('AbsImg').style.visibility='Hidden'; </script>");

	}
	else 
	{
		if(!patient_status.equals("3"))
		{	out.print("<script>parent.frames[2].document.dischargeadvice_form.death_date.value='';parent.frames[2].document.dischargeadvice_form.death_date.disabled=true;parent.frames[2].document.dischargeadvice_form.deathimg.style.visibility='hidden';parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled =true;parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=false; </script>");
            _bw.write(_wl_block11Bytes, _wl_block11);
if(!patient_status.equals("4"))
			{
				out.print("<script>parent.frames[2].document.dischargeadvice_form.absconding_yn.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_yn.checked=false;parent.frames[2].document.dischargeadvice_form.absconding_date.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_date.value='';parent.frames[2].document.getElementById('calImage').disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_rep_to.disabled=false;parent.frames[2].document.dischargeadvice_form.absconding_rep_to.value='';parent.frames[2].document.getElementById('AbsImg').style.visibility='Hidden';</script>");
			}
			
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		else
		{
			out.print("<script>parent.frames[2].document.dischargeadvice_form.post_mortem_request.checked=false;parent.frames[2].document.dischargeadvice_form.post_mortem_request.disabled =true;parent.frames[2].document.dischargeadvice_form.newmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.newmedicine.disabled=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.checked=false;parent.frames[2].document.dischargeadvice_form.stockmedicine.disabled=false; <!-- parent.frames[2].document.dischargeadvice_form.referred.disabled=true; --></script>");
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
	 }
			}
		
	
			if(patient_status.equals("3") || patient_status.equals("4"))
			{
			
            _bw.write(_wl_block14Bytes, _wl_block14);
	
			}

		}				
		else if(value2.trim().length() > 0 && value5.trim().length() == 0 && continueyn)
		{
			/*
			stmt = con.createStatement();
			sql = " Select referral_id from PR_ENCOUNTER where facility_id = '" + facilityId + "' and patient_class not in ('OP', 'EM') and adt_status != '09' and patient_id = '" + value2 + "' Order by VISIT_ADM_DATE_TIME " ;
	
			rset = stmt.executeQuery(sql);
	
			if(rset.next()) //take value from last row
			{
				financial_detail_ref_id = checkForNull(rset.getString("referral_id"));
			}
			if (rset!=null) rset.close();
			if (stmt!=null) stmt.close();
			if(financial_detail_ref_id.trim().length() > 0)
			{
				out.print("<script>	if(parent.frames[1].frames[2].document.AdmitPatient_form.isBlInstalled.value=='true' && parent.frames[1].frames[2].document.AdmitPatient_form.financial_detail_ref_id.value == '')");
				out.print("parent.frames[1].frames[2].document.AdmitPatient_form.financial_detail_ref_id.value='" + financial_detail_ref_id + "'</script>");	
			}
	
			String orgTypeSQL =" select b.org_type from PR_REFERRAL_REGISTER a, AM_REFERRAL b where a.referral_id = '"+referralid+"' and a.from_ref_code = b.referral_code";
			stmt = con.createStatement();
			rset = stmt.executeQuery(orgTypeSQL) ;
			if(rset.next()) 
			{
				org_type_data = rset.getString("org_type");
				if(org_type_data == null) org_type_data = "";
				if(org_type_data.equals("P"))  		
					org_type_data="P";
				else
					org_type_data="G";
				if (rset!=null) rset.close();
				if (stmt!=null) stmt.close();
			}
			else
			{
				org_type_data="G";
			}
	
			if(org_type_data.trim().length() > 0)
			{
				out.print("<script>	if(parent.frames[1].frames[2].document.AdmitPatient_form && parent.frames[1].frames[2].document.AdmitPatient_form.isBlInstalled.value=='true' && parent.frames[1].frames[2].document.AdmitPatient_form.org_type_ind.value == '')");
				out.print("parent.frames[1].frames[2].document.AdmitPatient_form.org_type_ind.value='"+org_type_data+"'</script>");	
			}
			*/
		}
	
	if( from.equals("Select_form") && ((!(bookingrefno.equals(""))) || (!(patientid.equals("")))) && (continueyn) )
	{	
            _bw.write(_wl_block15Bytes, _wl_block15);
	}

	if( from.equals("Select_form") && (bookingrefno.equals("")&& patientid.equals("")) && (continueyn) )
	{
	
            _bw.write(_wl_block16Bytes, _wl_block16);

	}
	
	if( ( from.equals("Select_form")  || from.equals("Main_form") || from.equals("AdmitPatient_form")) && continueyn )
	{	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(frame_ref));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block19Bytes, _wl_block19);
	}
	else
	{	
            _bw.write(_wl_block20Bytes, _wl_block20);

	}
	/*//added on 3-7-2008 for SCR 3228*/
	
            _bw.write(_wl_block21Bytes, _wl_block21);

	if (from.equals("Prepare_Discharge_advice")) 
	{
		if(discharge_type.equals(""))	
		{	
	
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
		else
		{	
	
            _bw.write(_wl_block23Bytes, _wl_block23);

			if(indicator.equals("DS"))
			{
				String stat_sql = "select discharge_status_code , long_desc,short_desc, discharge_status_ind from IP_DISCHARGE_STATUS_LANG_VW where language_id='"+locale+"' and eff_status='E' and  discharge_status_ind = 'D' order by short_desc";
				
				rset = stmt.executeQuery(stat_sql);
				if( rset!=null )
				{
					while(rset.next())
					{
						code = rset.getString("discharge_status_code");
						desc = rset.getString("short_desc");
						
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(code));
            _bw.write(_wl_block26Bytes, _wl_block26);

					}
				}
			}
			else 
			{
				String stat_sql = "select discharge_status_code , long_desc,short_desc, discharge_status_ind from IP_DISCHARGE_STATUS_LANG_VW where language_id='"+locale+"' and eff_status='E' and  discharge_status_ind in ('C','P','S','W') order by short_desc";
				
				rset = stmt.executeQuery(stat_sql);
				if( rset!=null )
				{
					while(rset.next())
					{
						code = rset.getString("discharge_status_code");
						desc = rset.getString("short_desc");
						
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(code));
            _bw.write(_wl_block27Bytes, _wl_block27);

					}
				}
			}
	}
		
	}
            _bw.write(_wl_block28Bytes, _wl_block28);
/*3228*/
}
catch(Exception e)
{
	out.print(e.toString());
	e.printStackTrace();
}
finally
{
	if(stmt != null) stmt.close();
	if(rset != null ) rset.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(referralid));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
