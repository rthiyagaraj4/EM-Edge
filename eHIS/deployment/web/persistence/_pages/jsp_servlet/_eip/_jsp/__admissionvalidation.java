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
import javax.servlet.jsp.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import webbeans.op.CurrencyFormat;
import blopin.*;
import eOP.*;
import eCommon.Common.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;

public final class __admissionvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AdmissionValidation.jsp", 1742367089191L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/validateBed.jsp", 1709117946401L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n</head>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<body class=\"MESSAGE\" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eIP/js/AdmitPatient.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eIP/js/AdmitPatient1.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eIP/js/AdmitPatient2.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eBL/js/AddModifyPatFinDetails.js\' language=\'Javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<script> \n\tfunction ReloadFrames()\n\t{\n\t\t\n\t\tparent.frames[1].frames[0].location.reload();\n\t\tparent.frames[1].frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.frames[1].frames[2].location.reload();\n\t}\n /*Below line Added for this CRF Bru-HIMS-CRF-261*/ \t\n\n function ReloadAll()\n{ \n   /*Below line Added for this CRF Bru-HIMS-CRF-261*/ \n    //if((parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type&& parent.frames[1].frames[2]. //document.AdmitPatient_form.quick_admission_type.value==\"Y\") && (parent.frames[1].frames[2].document.AdmitPatient_form.quick_adm && parent.frames[1].frames//(2).document.AdmitPatient_form.quick_adm.value==\"Quick_admission\")){ \t\n\t//parent.window.close();\n\t//}else{\n\t      parent.frames[1].frames[0].location.reload();\n\t\t  parent.frames[1].frames[2].location.reload();\n\t//}\t  \n\t//End this CRF Bru-HIMS-CRF-261\n}\n\tfunction nursUnitEnb()\n\t{\n\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t{\n\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form.from_adv_bed_mgmt.value==\'N\'){\n\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit_desc.disabled = false;\n\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit_lookup.disabled = false;\n\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc.disabled = false;\t\n\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.specialty_search.disabled = false;\n\t\t\t}\n\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form.from_adv_bed_mgmt.value==\'Y\' && parent.frames[1].frames[2].document.AdmitPatient_form.Splcode.value==\'\'){\n\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc.disabled = false;\t\n\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.specialty_search.disabled = false;\n\t\t\t}\n\t\t\t\n\t\t}\n\t}\n\n\tfunction practitionerDetailEnb()\n\t{\n\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t{\n\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.practid_desc.disabled = false;\n\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.pract_id_search.disabled = false;\n\n\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.att_practid_desc.disabled = false;\t\n\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.att_pract_id_search.disabled = false;\n\t\t}\n\t}\nfunction removeitems(obj)\n{\n\tvar len=obj.length;\n\tvar i=1;\n\twhile(i<len)\n\t{\n\t\tlen=obj.length\n\t\tobj.remove(i)\n\t}\n}\n\t\n\tfunction validateNU(frame_ref, spcl_code)\n\t{\n\t\tif(eval(frame_ref+\'.document.AdmitPatient_form.nursing_unit\'))\n\t\t{\n\t\t\tSplcode = eval(frame_ref+\'.document.AdmitPatient_form.Splcode.value\');\n\t\t\tif(Splcode == \"\")\t\n\t\t\t\tSplcode\t= spcl_code;\n\t\t}\n\t}\n\n\tfunction DeleteNursingUnit(frame_ref)\n\t{\n\t\tif(frame_ref == \'\') \n\t\t\tframe_ref = \'parent.frames[1].frames[2]\';\n\t\tvar obj = eval(frame_ref+\".document.forms[0].sub_service\");\n\t\tvar\tlength = obj.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\t\tobj.remove(1);\n\t\t}\n\t}\n\n\tfunction DeleteSubService(frame_ref)\n\t{\n\t\tif(frame_ref == \'\') \n\t\t\tframe_ref = \'parent.frames[1].frames[2]\';\n\t\tvar obj =eval(frame_ref+\".document.forms[0].sub_service\");\n\t\tvar\tlength  = obj.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\t\tobj.remove(1);\n\t\t}\n\t}\n\n\t</script>\n</head>\n\n<body CLASS=\"MESSAGE\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"AdmissionValidation_form\" id=\"AdmissionValidation_form\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar BcOpt = parent.parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\tBcOpt.text\t= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\tBcOpt.value= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\tparent.parent.frames[1].document.assign_bed.Bedcode.add(BcOpt);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t//added by kishore on 5/12/2004\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.patient_class_id.value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit.value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit_desc.value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nurs_unit_desc_hid.value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.Splcode.value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc.value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc_hid.value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.to_speciality_code.value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.concat_address_hidden.value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.practid.value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.practid_desc.value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form.isAttendPractAppl.value == \"true\") // if-else added by mujafar for ML-MMOH-SCF-1316\n\t\t\t\t\t{}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.att_practid.value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.att_practid_desc.value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\n\n\t\t\t\t\t//parent.frames[1].frames[2].document.AdmitPatient_form.att_practid_desc.value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n//\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.bed_no.disabled = false;\n//\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.bed_no.readOnly = false;\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value = \"\";\n\t\t\t\t\t/*\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"!=\"\")\n\t\t\t\t\tFriday, March 05, 2010 for MZ-0017 to enable BAC button when admit_patient_with_bed_yn = \'Y\' in AM Operator Station or bed_mandatory_for_admn_yn = \'Y\' in IP Parameter..\n\t\t\t\t\t*/\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"!=\"\" && (parent.frames[1].frames[2].document.AdmitPatient_form.nurs_unt_auth_val.value == \"Y\" || parent.frames[1].frames[2].document.AdmitPatient_form.bed_mandatory_for_admn_yn.value == \"Y\"))\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.bed_avail_chart.disabled = false;\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.bed_avail_chart.disabled = true;\n\t\t\t\t\tcontactDetailsAssign();\n\n\t\t\t\t\t//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779\n\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc.onblur();\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar obj = parent.frames[1].frames[2].document.AdmitPatient_form.service;\n\t\t\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\t\t\tfor(i=0;i<length;i++) {obj.remove(1);}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar obj =parent.frames[1].frames[2].document.AdmitPatient_form.service;\n\t\t\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\t\t\tfor(i=0;i<length;i++) {obj.remove(0);}\n\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\tvar opt = parent.frames[1].frames[2].document.createElement(\'OPTION\'); opt.text = \'--- \'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\' ---\';\n\t\t\t\t\t\t\topt.value= \'\';obj.add(opt);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\'REF_NURSING_UNIT_NOT_APPL_PAT_CLASS\',\'IP\'));\n\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" == \"\")\n\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit.value=\"\";\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit_desc.value=\"\";\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit_desc.onblur();\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.Splcode.value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc.value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc_hid.value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.to_speciality_code.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\n\t\t\t\t\t\t//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc.onblur();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit.value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit_desc.value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.Splcode.value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\n\t\t\t\t\t\t//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc.onblur();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(confirm(getMessage(\'PAT_DISPOSED_REGISTER\',\'MP\'))){\t\n\t\t\t\t\t\t\t\t\t\tvar retVal =  new String();\n\t\t\t\t\t\t\t\t\t\tvar dialogTop   = \"65\";\n\t\t\t\t\t\t\t\t\t\tvar dialogHeight    = \"44\" ; //30.5\n\t\t\t\t\t\t\t\t\t\tvar dialogWidth = \"65\" ;\n\t\t\t\t\t\t\t\t\t\tvar features  = \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no; scroll=no\";\n\t\t\t\t\t\t\t\t\t\tvar arguments = \"\" ;\n\t\t\t\t\t\t\t\t\t\tvar function_id = \'VISIT_REGISTRATION\';\n\t\t\t\t\t\t\t\t\t\tvar url=\"../../eMP/jsp/PatientRegistrationMain.jsp?&module_id=MP&function_id=\"+function_id+\"&function_type=F&access=YYYNN&func_act=Visitreg\";\n\t\t\t\t\t\t\t\t\t\tretVal = window.showModalDialog(url,arguments,features);\n\t\t\t\t\t\t\t\t\t\tif(retVal){\n\t\t\t\t\t\t\t\t\t\t\tif( retVal != null || retVal.length != 0)\n\t\t\t\t\t\t\t\t\t\t\t\tparent.close();\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=retVal;\n\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.onblur();\n\t\t\t\t\t\t\t\t\t\t}   \n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500);\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(confirm(getMessage(\'PAT_ACTIVATE\',\'MP\'))){\t\n\t\t\t\t\t\t\t\t\t\tvar xmlDoc = \"\";\n\t\t\t\t\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\t\t\t\t\t\txmlStr =\'<root><SEARCH /></root>\';\n\t\t\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\t\t\txmlHttp.open(\'POST\',\'../../eMP/jsp/MPIntermediate.jsp?action=activate_pat&patientId=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',false);\n\t\t\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\t\t\tresponseText=xmlHttp.responseText;\n\t\t\t\t\t\t\t\t\t\tresponseText = trimString(responseText);\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.onblur();\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500);\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" \n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar error= getMessage( \"PATIENT_MERGED_VALID\",\"MP\");\n\t\t\t\t\t\t\t\terror = error.replace(\'#\',\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\");\n\t\t\t\t\t\t\t\talert(error);\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.select();\n\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t</script> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t <script>\n\t\t\t\t\t\t /*below lines was added by Venkatesh.S on 09-Nov-2012 against 36154*/\n\t\t\t\t\t\t var admission_for=parent.frames[1].frames[0].document.Select_form.admission_for.value;\n\t\t\t\t\t\t if(admission_for==\"I\")\n\t\t\t\t\t\t {\n\t\t\t\t\t\t var mess=getMessage(\'PATIENT_LASTADMISSION_IN_NURSINGUNIT\',\'IP\');\n\t\t\t\t\t\t alert(mess+\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"+\" on \"+\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"+\".\");\n\t\t\t\t\t\t }\n\t\t\t\t\t\t /*end 36154 */\n\t\t\t\t\t\t </script>  \n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" \n\t\t\t\t\t\t\t\t<script>alert(getMessage(\"VALIDATE_NATIONAL_ID\",\'MP\'));</script> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500);\n\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.call_func.value==\'ADMIT\')\n\t\t\t\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(confirm(getMessage(\'UHID_EXPIRED\',\'MP\')))\n\t\t\t\t\t\t\t\t\t{  \tvar check = blUHIDBillchk(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\',\'ADMISSION\',\'IP\',\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\');\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(check==\'Y\')\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value  = \'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\';\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.onblur();\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=\"\"; // added by mujafar for AMRI-CRF-0357\t\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500);\n\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.call_func.value==\'ADMIT\')\n\t\t\t\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=\"\"; // added by mujafar for AMRI-CRF-0357\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500);\n\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.call_func.value==\'ADMIT\')\n\t\t\t\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\tasync function toHoldShowModal(){\n\t\t\t\t\t\t\t\t\t\t\t\tvar message= getMessage(\'NATID_ALTID_NOT_AVAILABLE_UPDATE\',\'MP\'); \n\t\t\t\t\t\t\t\t\t\t\t\tmessage = message.replace(\'#\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');\n\t\t\t\t\t\t\t\t\t\t\t\tif(confirm(message)){\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar dialogTop   = \'65\';\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar dialogHeight    = \'90vh\' ; \n\t\t\t\t\t\t\t\t\t\t\t\t\tvar dialogWidth = \'90vw\' ;\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar features  = \'dialogTop:\' + dialogTop + \'; dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';status=no; scroll=no\';\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar arguments = \'\' ;\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar retVal = \'\';;\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar url=\'../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\t\tretVal = await   top.window.showModalDialog(url,arguments,features);\n\n\t\t\t\t\t\t\t\t\t\t\t\t\tif(retVal){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.booking_ref_no && parent.frames[1].frames[0].document.Select_form.booking_ref_no.value != \'\'){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value = \'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.onblur();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.onblur();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.called_from.value==\'NEWBORN_REG\' || parent.frames[1].frames[0].document.Select_form.called_from.value==\'Quick_admission\'){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.called_from.value==\'NEWBORN_REG\' || parent.frames[1].frames[0].document.Select_form.called_from.value==\'Quick_admission\'){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500); \n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t//toHoldShowModal();\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\t\t\t\t\t\tmessage = message.replace(\'#\',getLabel(\'Common.country.label\',\'Common\'));\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\t\t\t\t\t\tmessage = message.replace(\'#\',\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\');\n\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\tvar cr_prompt = getLabel(\'Common.country.label\',\'Common\')+\' \'+getLabel(\'Common.and.label\',\'Common\')+\' \'+\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\';\n\t\t\t\t\t\t\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\t\t\t\t\t\t\tmessage = message.replace(\'#\',cr_prompt);\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\t\t\t\t\t\t\tmessage = message.replace(\'#\',getLabel(\'Common.country.label\',\'Common\'));\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\tvar message = getMessage(\'MAND_VALIDATION_TRANS\',\'MP\'); \n\t\t\t\t\t\t\t\t\t\t\tmessage = message.replace(\'#\',\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\');\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tasync function toHoldShowModal(){\n\t\t\t\t\t\t\t\t\t\tif(confirm(message)){\n\t\t\t\t\t\t\t\t\t\t\tvar dialogTop   = \'65\';\n\t\t\t\t\t\t\t\t\t\t\tvar dialogHeight    = \'90vh\' ; \n\t\t\t\t\t\t\t\t\t\t\tvar dialogWidth = \'90vw\' ;\n\t\t\t\t\t\t\t\t\t\t\tvar features  = \'dialogTop:\' + dialogTop + \'; dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';status=no; scroll=no\';\n\t\t\t\t\t\t\t\t\t\t\tvar arguments = \'\' ;\n\t\t\t\t\t\t\t\t\t\t\tvar retVal = \'\';;\n\t\t\t\t\t\t\t\t\t\t\tvar url=\'../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&load_tab=CONTACT_ADDR_TAB&Patient_ID=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\';\n\t\t\t\t\t\t\t\t\t\t\tretVal = await top.window.showModalDialog(url,arguments,features);\n\n\t\t\t\t\t\t\t\t\t\t\tif(retVal){\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.booking_ref_no && parent.frames[1].frames[0].document.Select_form.booking_ref_no.value != \'\'){\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value = \'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.onblur();\n\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.onblur();\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.called_from.value==\'NEWBORN_REG\' || parent.frames[1].frames[0].document.Select_form.called_from.value==\'Quick_admission\'){\n\t\t\t\t\t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500);\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.called_from.value==\'NEWBORN_REG\' || parent.frames[1].frames[0].document.Select_form.called_from.value==\'Quick_admission\'){\n\t\t\t\t\t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500); \n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t//toHoldShowModal();\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" \n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar message=getMessage(\'NATID_ALTID_NOT_AVAILABLE\',\'MP\'); \n\t\t\t\t\t\t\t\t\tmessage = message.replace(\'#\',\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\');\n\t\t\t\t\t\t\t\t\talert(message);\n\t\t\t\t\t\t\t\t</script> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.focus();\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].proceedFurther=true;\n\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadAll()\',1500);\n\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.call_func.value==\'ADMIT\')\n\t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t<script> \n\t\t\t\t\t\t\t\t\tvar contyn = confirm(\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\");  \n\t\t\t\t\t\t\t\t\tif(contyn) \n\t\t\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\t\t\tif (parent.frames[1].frames[2].AdmitPatient_form.health_card_expired_yn){\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.health_card_expired_yn.value=\'Y\';\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.call_func.value==\'PATREG\')\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\telse\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t{ \n\t\t\t\t\t\t\t\t\t\t\tvar value1=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\t\t\t\t\t\t\t\t\t\t\tvar value2=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\n\t\t\t\t\t\t\t\t\t\t\tvar value3=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\";\n\t\t\t\t\t\t\t\t\t\t\tvar from=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\t\t\t\t\t\t\t\t\t\t\tvar value5=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t\t\t\t\t\t\t\t\t\t\tvar value6=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\";\n\t\t\t\t\t\t\t\t\t\t\tvar visit_adm_date_time=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\t\t\t\t\t\t\t\t\t\tvar HTMLVal = \"<html><body CLASS=\'MESSAGE\' onKeyDown=\'lockKey()\'><form name=\'dum_form\' id=\'dum_form\' method=\'post\' action=\'../../eIP/jsp/AdmissionValidation.jsp\'><input type=\'hidden\' name=\'field1\' id=\'field1\' value=\\\"\"+value1+\"\\\"> \"+\n\t\t\t\t\t\t\t\t\t\t\t\" <input type=\'hidden\' name=\'field2\' id=\'field2\' value=\\\"\"+value2+\"\\\"><input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\\\"\"+value6+\"\\\"><input type=\'hidden\' name=\'field3\' id=\'field3\' value=\\\"\"+value3+\"\\\">\"+\n\t\t\t\t\t\t\t\t\t\t\t\"<input type=\'hidden\' name=\'field4\' id=\'field4\' value=\'\"+from+\"\'>\"+\n\t\t\t\t\t\t\t\t\t\t\t\"<input type=\'hidden\' name=\'field5\' id=\'field5\' value=\\\"\"+value5+\"\\\"> \"+\n\t\t\t\t\t\t\t\t\t\t\t\"<input type=\'hidden\' name=\'visit_adm_date_time\' id=\'visit_adm_date_time\' value=\\\"\"+visit_adm_date_time+\"\\\"> \"+\n\t\t\t\t\t\t\t\t\t\t\t\"<input type=\'hidden\' name=\'continue_yn\' id=\'continue_yn\' value=\'Y\'><input type=\'hidden\' name=\'health_card_expired_yn_check\' id=\'health_card_expired_yn_check\' value=\'Y\'> \"+\n\t\t\t\t\t\t\t\t\t\t\t\"</form></body></html>\";\n\t\t\t\t\t\t\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\t\t\t\t\t\t\tparent.messageFrame.document.dum_form.submit();\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<script>\n\n\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form.call_func.value==\'PATREG\')\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\telse\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\talert(\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\");\n\t\t\t\t\t\t\t\t\t\t\tsetTimeout(\'ReloadFrames()\',2000);\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="          \n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parent.frames[1].frames[3].document.getElementById(\'PrevIPVisit\')!=null)\t\n\t\t\t\t\t\t\t\tparent.frames[1].frames[3].document.getElementById(\'PrevIPVisit\').disabled = false;   \n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="          \n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[3].document.getElementById(\'PrevIPVisit\')!=null)\t\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[3].document.getElementById(\'PrevIPVisit\').disabled = true;    \n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"!=\"\")\n\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.bkg_type.value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\t\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar obj = parent.frames[1].frames[2].document.AdmitPatient_form.service;\n\t\t\t\t\t\t\t\t\tvar length = obj.length;\n\t\t\t\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tobj.remove(1);\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar obj =parent.frames[1].frames[2].document.AdmitPatient_form.service;\n\t\t\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\t\t\tfor(i=0;i<length;i++) {obj.remove(0);} \n\t\t\t\t\t\t\t\tvar opt = parent.frames[1].frames[2].document.createElement(\'OPTION\'); \n\t\t\t\t\t\t\t\topt.text = \'--- \'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\' ---\';\n\t\t\t\t\t\t\t\topt.value= \'\';\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="                      \n\t\t\t\t\t\t<script language = \'javascript\'>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.clin_code.value = \"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.chief_complaint.value = \"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.complaintcode.value = \"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].makeValidString(parent.frames[1].frames[2].document.AdmitPatient_form.chief_complaint)\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.ot_date_time.value = \"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.room_no.value = \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value = \"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.booking_bed_no.value=parent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value;//Rameswar\n\t\t\t\t\t\t\t//Added for PMG2016-CRF-0002 IN061508  on 23rd Aug 16\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"!=\"\"){//Added for  IN061613 on 6th Sep 2016\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.temp_bed_class.value = \"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\";}\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"!=\"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar obj = parent.frames[1].frames[2].document.AdmitPatient_form.bed_type;\n\t\t\t\t\t\t\t\tfor(i=0;i<obj.length;i++)\n\t\t\t\t\t\t\t\t\tobj.remove(1);\n\t\t\t\t\t\t\t\tvar opt = parent.frames[1].frames[2].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.value = \"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n\t\t\t\t\t\t\t\topt.text  = \"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\";\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"!=\"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar obj = parent.frames[1].frames[2].document.AdmitPatient_form.Bedcode;\n\t\t\t\t\t\t\t\tfor(i=0;i<obj.length;i++)\n\t\t\t\t\t\t\t\t\tobj.remove(1);\n\t\t\t\t\t\t\t\tvar opt = parent.frames[1].frames[2].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.value = \"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\";\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.exp_days_stay.value = \"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.expecteddischargedate.value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.Splcode.value = \"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc.value = \"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc_hid.value = \"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.practid.value = \"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.practid_desc.value = \"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\";\n\t\t\t\t\t\t\t//Added by S.Sathish for IN021705 on Thursday, June 03, 2010\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.patient_class_id.value = \"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\";\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t/*Wednesday, April 07, 2010 , MO-CRF-0032-IN016866*/\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.admission_remarks.value = \"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\";\n\t\t\t\t\t\t\t/*\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.att_practid.value = \"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\";\n\t\t\t\t\t\t\t//parent.frames[1].frames[2].document.AdmitPatient_form.att_practid_desc.value = \"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.patient_class_id.value = \"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\";\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" ==\'DC\')\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.exp_days_stay.disabled = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" != \"\" && \"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" != \"\")\n\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form)\tparent.frames[1].frames[0].document.Select_form.teamid.value = \"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"!=\"\")\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[0].arrNursingUnitDetails[0] = \"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].arrNursingUnitDetails[1] = \"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].arrNursingUnitDetails[2] = \"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].arrNursingUnitDetails[3] = \"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].arrNursingUnitDetails[4] = \"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].arrNursingUnitDetails[5] = \"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\";\n\n\t\t\t\t\t\t//if(parent.frames[1].frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value==\"N\")\n//\t\t\t\t\t\t\tparent.frames[1].frames[2].document.getElementById(\'bed_no\').disabled= false;\n//\t\t\t\t\t\t\tparent.frames[1].frames[2].document.getElementById(\'bed_no\').readOnly= false;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t/*Friday, March 05, 2010 for MZ-0017 to enable BAC button when admit_patient_with_bed_yn = \'Y\' in AM Operator Station or bed_mandatory_for_admn_yn =\t\'Y\' in IP Parameter..\n\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"!=\"\" && (parent.frames[1].frames[2].document.AdmitPatient_form.nurs_unt_auth_val.value==\'Y\' || parent.frames[1].frames[2].document.AdmitPatient_form.bed_mandatory_for_admn_yn.value == \'Y\'))\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.getElementById(\'bed_avail_chart\').disabled= false;\n\t\t\t\t\t\t\telse\t\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.getElementById(\'bed_avail_chart\').disabled= true;\n\t\t\t\t\t\t\tparent.frames[1].frames[3].document.getElementById(\'valuables\').disabled= false;\n\n\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value==\'N\')\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.getElementById(\"attend_img\").style.visibility=\"visible\";\n\n\t\t\t\t\t\t\t//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.SplDesc.onblur();\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tp = parent.frames[1].frames[2].document.AdmitPatient_form.Bedcode.options;\n\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" < \"2\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tfor (i=0; i<p.options.length; i++) \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(p.options[i].value == \"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\")\n\t\t\t\t\t\t\t\t\t\tp.options[i].selected = true;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit.value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit_desc.value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.nurs_unit_desc_hid.value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(parent.frames[1].frames[0].document.Select_form)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif( \"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" != \"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.patient_id.value = \"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\";\n\t\t\t\t\t\t\t\tif (\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" != \"\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.booking_ref_no.value = \"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\";\n\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"!=\"\")\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.bkg_type.value = \"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\";\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.clin_code.value = \"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.Select_form.referral_id.value  = \"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tPopulateSubService(\'G\');\n\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t/**\t\tvar temp =\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\";\n\t\t\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\";\n\t\t\t\t\t\t\t\tvar opt=parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\t\t\tif(opt.value == \"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\")     \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\ttemp2 = \"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\";\n\t\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\t}*/\n\t\t\t\t\t\t\t</script>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\t\t<script>invokePatientRegRef(\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\');</script>\n\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t\t<script>invokePatientReg();</script>\n\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar arrival = parent.frames[1].frames[2].document.AdmitPatient_form.arrival_code;\n\t\t\t\t\twhile(arrival.options.length > 1)\n\t\t\t{\n\t\t\t\t\t//\tarrival.remove(arrival.options[1]);\n\t\t\tremoveitems(parent.frames[1].frames[2].document.AdmitPatient_form.arrival_code);\n\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\t\t<script>\n\t\t\t\t\t\t\tvar ArrivalOpt = parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\tArrivalOpt.text\t= \"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\";\n\t\t\t\t\t\t\tArrivalOpt.value= \"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.arrival_code.add(ArrivalOpt);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar ambulatory_status = parent.frames[1].frames[2].document.AdmitPatient_form.ambulatory_status;\n\t\t\t\t\twhile(ambulatory_status.options.length > 1)\n\t\t\t{\n\t\t\t\t//\tambulatory_status.remove(ambulatory_status.options[1]);\n\t\t\tremoveitems(parent.frames[1].frames[2].document.AdmitPatient_form.ambulatory_status);\t\n\t\t\t\n\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\t\t<script>\n\t\t\t\t\t\t\t\tvar ambulatoryOpt = parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\tambulatoryOpt.text\t= \"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\";\n\t\t\t\t\t\t\t\tambulatoryOpt.value= \"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.ambulatory_status.add(ambulatoryOpt);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar visit_adm_type = parent.frames[1].frames[2].document.AdmitPatient_form.visit_adm_type;\n\t\t\t\t\twhile(visit_adm_type.options.length > 1)\n\t\t\t       {\n\t\t\t\t\t//visit_adm_type.remove(visit_adm_type.options[i]);\n\t\t\t\tremoveitems(parent.frames[1].frames[2].document.AdmitPatient_form.visit_adm_type);\n\t\t\t\n\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\t\t<script>\n\t\t\t\t\t\t\t\tvar admTypeOpt = parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\tadmTypeOpt.text\t= \"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\";\n\t\t\t\t\t\t\t\tadmTypeOpt.value= \"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.visit_adm_type.add(admTypeOpt);\n\t\t\t\t\t\t\t\t    /*Below line Added for this CRF Bru-HIMS-CRF-261*/\n\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type && parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value!=\"\" && parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value==\"Y\"){\n\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" == \"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\"){\n\t\t\t\t\t\t\t\t\t\tadmTypeOpt.selected = true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}else{//Added by shanmukh on 1st-AUG-2018 for ML-MMOH-CRF-0618\n\t\t\t\t\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" && (\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\")){\n\t\t\t\t\t\t\t\t\t\tadmTypeOpt.selected = true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n                                   //End Bru-HIMS-CRF-261\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar Bedcode = parent.frames[1].frames[2].document.AdmitPatient_form.Bedcode;\n\t\t\t\t\tfor(i=0;i<Bedcode.length;i++) \n\t\t\t\t\t{\n\t\t\t\t\t\tBedcode.remove(1);\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\t<script>\n\t\t\t\t\t\t\t\t\t\tvar BedcodeOpt = parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\tBedcodeOpt.text\t= \"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\";\n\t\t\t\t\t\t\t\t\t\tBedcodeOpt.value= \"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.Bedcode.add(BedcodeOpt);\n\t\t\t\t\t\t\t\t\t\t//Added for IN061613 on 6th Sep 2016\n\t\t\t\t\t\t\t\t\t\tvar temp_bed_class=\"\";\n\t\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\"==\"\" && \"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"==\"\"){\n\t\t\t\t\t\t\t\t\t\ttemp_bed_class = parent.frames[1].frames[2].document.AdmitPatient_form.temp_bed_class.value\n\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\ttemp_bed_class = \"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" ;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" == temp_bed_class)\n\t\t\t\t\t\t\t\t\t\tBedcodeOpt.selected = true;\n\t\t\t\t\t\t\t\t\t\t/*Below line Added for this CRF Bru-HIMS-CRF-261*/\n\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type &&parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value!=\"\" && parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value==\"Y\"){\n\t\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\"){\n\t\t\t\t\t\t\t\t\t\tBedcodeOpt.selected = true;\n\t\t\t\t\t\t\t\t\t\t//populateBedType(\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\');\n\t\t\t\t\t\t\t\t\t\t }\n\t\t\t\t\t\t\t\t\t\t}\n                                       //End Bru-HIMS-CRF-261\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\t\n\t\t\t\t\t\tvar bedtypeOpt = parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\tbedtypeOpt.text\t= \"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\";\n\t\t\t\t\t\t\t\t\t\tbedtypeOpt.value= \"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.bed_type.add(bedtypeOpt);\n\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t/*Below line Added for this CRF Bru-HIMS-CRF-261*/\n\t\t\t\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type &&parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value!=\"\" && parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value==\"Y\"){\n\t\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\"){\n\t\t\t\t\t\t\t\t\t\tbedtypeOpt.selected = true;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar temp =\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\";\n\t\t\t\t\t\tvar opt=parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tif(opt.value == \"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\")     \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar comp=parent.frames[1].frames[2].document.forms[0].team_id;\n\t\t\t\t\t\tcomp.add(opt);\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\tif(parent.frames[1].frames[2].AdmitPatient_form)\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.billing_group.value=document.forms[0].billing_group.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.bl_future_admn_YN.value=document.forms[0].bl_future_admn_YN.value;\n/*\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.gl_holder_name.value=document.forms[0].gl_holder_name.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.gl_holder_reln.value=document.forms[0].gl_holder_reln.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cred_st_dt1.value=document.forms[0].cred_start_date.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cred_st_dt2.value=document.forms[0].cred_start_date.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cred_st_dt3.value=document.forms[0].cred_start_date.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.billing_class.value=document.forms[0].billing_class.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.employer_code.value=document.forms[0].employer_code.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cash_set_type1.value=document.forms[0].cash_set_type1.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cash_insmt_ref1.value=document.forms[0].cash_insmt_ref1.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cash_insmt_date1.value=document.forms[0].cash_insmt_date1.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cash_insmt_rmks1.value=document.forms[0].cash_insmt_rmks1.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cust_1.value=document.forms[0].cust_1.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.credit_doc_ref1.value=document.forms[0].credit_doc_ref1.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.credit_doc_date1.value=document.forms[0].credit_doc_date1.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cust_2.value=document.forms[0].cust_2.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.credit_doc_ref2.value=document.forms[0].credit_doc_ref2.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.credit_doc_date2.value=document.forms[0].credit_doc_date2.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cust_3.value=document.forms[0].cust_3.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.policy_type.value=document.forms[0].policy_type.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.policy_no.value=document.forms[0].policy_no.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.policy_expiry_date.value=document.forms[0].policy_expiry_date.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.non_insur_blng_grp.value=document.forms[0].non_insur_blng_grp.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cash_set_type2.value=document.forms[0].cash_set_type2.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cash_insmt_ref2.value=document.forms[0].cash_insmt_ref2.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cash_insmt_date2.value=document.forms[0].cash_insmt_date2.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cash_insmt_rmks2.value=document.forms[0].cash_insmt_rmks2.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.cust_4.value=document.forms[0].cust_4.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.credit_doc_ref3.value=document.forms[0].credit_doc_ref3.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.credit_doc_date3.value=document.forms[0].credit_doc_date3.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.setlmt_ind.value=document.forms[0].setlmt_ind.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.upd_fin_dtls.value=document.forms[0].upd_fin_dtls.value;\n*/\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.bl_operation.value=document.forms[0].bl_operation.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.billing_mode.value=document.forms[0].billing_mode.value;\n//\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.remarks.value=document.forms[0].remarks.value;\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.pkg_bill_type.value=\"\";\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.pkg_bill_no.value=\"\";\n/*\n\t\t\t\t\tif(document.forms[0].annual_income != null) \t\tparent.frames[1].frames[2].AdmitPatient_form.annual_income.value=document.forms[0].annual_income.value;\n\t\t\t\t\tif(document.forms[0].family_asset != null)\tparent.frames[1].frames[2].AdmitPatient_form.family_asset.value=document.forms[0].family_asset.value;\n\t\t\t\t\tif(document.forms[0].no_of_dependants != null)\tparent.frames[1].frames[2].AdmitPatient_form.no_of_dependants.value=document.forms[0].no_of_dependants.value;\n\t\t\t\t\tif(document.forms[0].resp_for_payment != null)\n\t\t\t\t\tparent.frames[1].frames[2].AdmitPatient_form.resp_for_payment.value=document.forms[0].resp_for_payment.value;\n\t\t\t\t\tvar policy_type = document.forms[0].policy_type.value;\n\t\t\t\t\tif (document.forms[0].policy_type.value !=\'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar HTMLVal = new String();\n\t\t\t\t\t\tvar value2=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\"\n\t\t\t\t\t\tHTMLVal = \"<HTML><head></head><BODY class=\'message\' onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eIP/jsp/ChkInsurance.jsp\'><input type=\'hidden\' name=\'value2\' id=\'value2\' value=\'\"+value2+\"\'>\"\n\t\t\t\t\t\tHTMLVal += \"</form></BODY></HTML>\";\n\t\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\t\tparent.messageFrame.document.form1.submit();\n\t\t\t\t\t}\n*/\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form) \n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.ancillary_yn.value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\";\n\t\t\t\t\t\t\t\tvar obj =parent.frames[1].frames[2].document.AdmitPatient_form.service;\n\t\t\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\t\t\tfor(i=0;i<length;i++) {obj.remove(1);}\n\t\t\t\t\t\t\t\tvar opt= parent.frames[1].frames[2].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\";\n\t\t\t\t\t\t\t\topt.value= \"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\";\n\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t/*if(parent.frames[2].document.AdmitPatient_form) \n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\tparent.frames[2].document.AdmitPatient_form.ancillary_yn.value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\";\n\t\t\t\t\t\t\t\tvar obj =parent.frames[2].document.AdmitPatient_form.service;\n\t\t\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\t\t\tfor(i=0;i<length;i++) {obj.remove(1);}\n\t\t\t\t\t\t\t\tvar opt= parent.frames[2].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\";\n\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t}*/\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="<script> \n\t\t\t\t\t\tif(parent.frames[1].frames[2].document.AdmitPatient_form)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar obj =parent.frames[1].frames[2].document.AdmitPatient_form.service;\n\t\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tobj.remove(1);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t/*if(parent.frames[2].document.AdmitPatient_form)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar obj =parent.frames[2].document.AdmitPatient_form.service;\n\t\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tobj.remove(1);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}*/\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\t\t<script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar opt = parent.frames[1].frames[2].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\";\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\";\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\t/*\n\t\t\t\t\t\t\t\tvar opt = parent.frames[2].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\";\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t\tparent.frames[2].document.createElement(\'Option\');*/\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t<script>funPatRegCharges(\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\');</script>\n\t\t\t";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t<script type =\"text/javascript\">\n\t\t\t\t\n\t\t\t\tparent.frames[1].frames[3].document.getElementById(\'contact_details\').disabled = false;\n\t\t\t\tnursUnitEnb();\n\t\t\t\tpractitionerDetailEnb();\t\n                ChangePatVisHid();// added by munisekhar for MMS-QH-CRF-0162\t\t\t\t\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t\t\t<script>parent.frames[1].frames[2].document.getElementById(\'out_amt\').innerText=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\";</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t\t<script>dispAuth(";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 =",\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\',\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[1].frames[3].document.getElementById(\'contact_details\').disabled = true;\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t<script>\n\t\t\t\n\t\t\tif (continueFlag==\"Y\" && babyfalgyn !=\'N\')\n\t\t\t{\n\t\t\t\tmakeDisabled(true);\n\t\t\t\tvar frame_ref = \"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\";\n\t\t\t\tif(frame_ref == \"\")\n\t\t\t\tframe_ref = \"parent.frames[1].frames[2]\";\n\t\t\t\tvar speciality_code=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\";\n\t\t\t\tsetTimeout(\'validateNU(\\\"\"+frame_ref+\"\\\",\\\"\"+speciality_code+\"\\\")\',1000);\n\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\t<script>\n\t\t\t\tif (continueFlag==\"Y\")\n\t\t\t\tmakeDisabled(false);\n\t\t\t</script>\t\t\n\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[1].document.forms[0].encounter_id.value =\'";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\';\n\t\t\t\t\t\tparent.frames[1].document.forms[0].encounter_id_but.disabled = false;\n\t\t\t\t\t\tvar sql = \"SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report_lang_vw WHERE module_id = \'IP\' AND report_id IN (\'IPBWBLBW\', \'IPBWBLBB\', \'IPBWBLBR\') AND language_id = \'en\' \";\n\t\t\t\t\t\tvar reportParamNames=\"p_facility_id,p_module_id,p_encounter_id,p_patient_id\";\n\t\t\t\t\t\tvar reportParamValues=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 =",IP,";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =",";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\";\n\t\t\t\t\t\tvar getUrl\t\t\t= \"../../eCommon/jsp/InternalReportsPrint.jsp?P_MODULE_ID=IP&P_function_id=ADMISSION&rep_id=IPBWBLBW&step=1&sqlString=\" + sql + \"&reportParamNames=\"+reportParamNames+\"&reportParamValues=\" + reportParamValues + \"&Patient_ID=";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="&encounter_id=";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="&dest_locn_type=";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="&dest_locn_code=";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\";\n\t\t\t\t\t\tparent.frames[2].location.href=getUrl;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t\t<Script>ReloadFrames();</script>\n\t\t";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n<input type = \'hidden\' name = \'queryString\' value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n<input type = \'hidden\' name = \'referralid\' value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n<input type = \'hidden\' name = \'quickadmchk\' value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">\n<script>\n/*Below line Added for this CRF Bru-HIMS-CRF-261*/ \t\t\t\t\t\nif(\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'!=\"\")\t\t\t\t\t\n\t\tparent.frames[1].frames[2].document.AdmitPatient_form.Bedcode.value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\";\t\nif(\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'!=\"\")\t\n        parent.frames[1].frames[2].document.AdmitPatient_form.bed_type.value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'!=\"\")\t\t\t\t\t\t\n\t\tparent.frames[1].frames[2].document.AdmitPatient_form.visit_adm_type.value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\"; \nif(\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\'!=\"\"){\n        if(parent.frames[1].frames[2].document.AdmitPatient_form)\t\n        parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type.value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\";\t\n\t\t}\n//End Bru-HIMS-CRF-261\n\n/*Below line added for this CRF GDOH-CRF-0129*/\n\nif(\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\'==\"true\" && \'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\'==\"Select_form\"){ \n//alert(parent.frames[1].frames[2].document.AdmitPatient_form.reason_reqd_Flag.value);\n parent.frames[1].frames[2].document.getElementById(\'chief_complaint_txt\').style.display=\'none\'; \n parent.frames[1].frames[2].document.getElementById(\'assigncare_location_txt\').style.visibility=\'visible\';\n if(parent.frames[1].frames[2].document.AdmitPatient_form.assigncare_location_desc) parent.frames[1].frames[2].document.AdmitPatient_form.assigncare_location_desc.value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\";\nif(parent.frames[1].frames[2].document.AdmitPatient_form.assigncare_loctype_ind) parent.frames[1].frames[2].document.AdmitPatient_form.assigncare_loctype_ind.value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\";\n if(parent.frames[1].frames[2].document.AdmitPatient_form.assigncare_locacode)parent.frames[1].frames[2].document.AdmitPatient_form.assigncare_locacode.value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\";\n if( parent.frames[1].frames[2].document.AdmitPatient_form.assigncare_location_desc)parent.frames[1].frames[2].document.AdmitPatient_form.assigncare_location_desc.disabled = true;\n if(parent.frames[1].frames[2].document.AdmitPatient_form.reason_reqd_Flag && parent.frames[1].frames[2].document.AdmitPatient_form.reason_reqd_Flag.value==\"Y\")parent.frames[1].frames[2].document.AdmitPatient_form.reason_reqd_Flag.value=\"N\";\n\n}\n\n//End GDOH-CRF-0129\n\n</script>\n</body>\n</form>\n</html>\n";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

   String isFutureBlock(String facility_id,String bed_no,String nursingunit,Connection con)
	{
		
		String sql = "Select booking_type,override_yn,PATIENT_ID from ip_bed_booking WHERE facility_id='"+facility_id+"' and req_nursing_unit_code='"+nursingunit+"' and req_bed_no='"+bed_no+"' and booking_status='0' and blocked_from_date_time > sysdate";
		String temp_flag = "";
		Statement stmt1 = null;
		ResultSet rset1 = null;
		try
		{
			
			stmt1 = con.createStatement();
			rset1 = stmt1.executeQuery(sql);
			if(rset1!=null && rset1.next())
			{
				temp_flag = "Y";
			}
			
							if (stmt1 != null) stmt1.close();
				if (rset1 != null) rset1.close();
			
			}catch(Exception e) {
				e.printStackTrace();
				}

			return temp_flag;
	}


	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


	// getContactDetails() more generalized
	public StringBuffer getContactDetails(String from,String P_fromValue,String book_ref_no,HttpServletRequest request,JspWriter out,Connection con,String facilityId,String booking_type, String locale) throws Exception 
	{
		PreparedStatement pstmt		= null ;
		ResultSet resultSet				= null ;
		StringBuffer sqlContact			= new StringBuffer();
		String fromValue					= P_fromValue;
		String a_res_addr_line1			= "";
		String a_res_addr_line2			= "";
		String a_res_addr_line3			= "";
		String a_res_addr_line4			= "";
		String a_country_code			= "";
		String a_country_desc			= "";
		String a_postal_code			= "";
		String a_postal_code_desc		= "";
		String a_res_area					= "";
		String a_res_area_code			= "";
		String a_res_town2_code		= "";
		String a_res_town2_desc		= "";
		String a_res_region_code		= "";
		String a_res_region_desc		= "";
		String m_res_addr_line1			= "";
		String m_res_addr_line2			= "";
		String m_res_addr_line3			= "";
		String m_res_addr_line4			= "";
		String m_postal_code			= "";
		String m_postal_code_desc		= "";
		String m_country_code			= "";
		String m_country_desc			= "";
		String m_res_area_code		= "";
		String m_res_area_desc			= "";
		String m_res_town2_code		= "";
		String m_res_town2_desc		= "";
		String m_res_region_code		= "";
		String m_res_region_desc		= "";
		String 	strPrimaryResNo		= "";
		String 	strOtherResNo			= "";
		String 	strEmail					= "";
		String 	sex					= "";
		String 	age					= "";
		String 	bed_assigned_for_nb_yn	= "";
		StringBuffer contactAddress	= new StringBuffer();
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
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
		if(!book_ref_no.equals("")) 
		{
			if(booking_type.equals("D")) 
			{
				if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
//thai 2 - OA_APPT_VW
				sqlContact.append("SELECT res_addr_line1 addr1_line1,");
				sqlContact.append("        res_addr_line2 addr1_line2,");
				sqlContact.append("        res_addr_line3 addr1_line3,");
				sqlContact.append("        res_addr_line4 addr1_line4,");
				sqlContact.append("        res_town_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(res_town_code,'"+locale+"','1') res_town,");
				sqlContact.append("        res_area_code,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(res_area_code,'"+locale+"','1') res_area,");
				sqlContact.append("        res_region_code region_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(res_region_code,'"+locale+"','1') region,");
				sqlContact.append("        country_code country1_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(country_code,'"+locale+"','1') country1_desc,");
				sqlContact.append("        postal_code postal1_code,mp_get_desc.MP_POSTAL_CODE(postal_code,'"+locale+"','2') postal1_code_desc,");
				sqlContact.append("        mail_addr_line1 addr2_line1,");
				sqlContact.append("        mail_addr_line2 addr2_line2,");
				sqlContact.append("        mail_addr_line3 addr2_line3,");
				sqlContact.append("        mail_addr_line4 addr2_line4,");
				sqlContact.append("        mail_town_code res_town2_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(mail_town_code,'"+locale+"','1') res_town2,");
				sqlContact.append("        mail_area_code res_area2_code,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(mail_area_code,'"+locale+"','1') res_area2,");
				sqlContact.append("        mail_region_code region2_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(mail_region_code,'"+locale+"','1') region2_desc,");
				sqlContact.append("        mail_country_code country2_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(mail_country_code,'"+locale+"','1') country2_desc,");
				sqlContact.append("        mail_postal_code postal2_code,mp_get_desc.MP_POSTAL_CODE(mail_postal_code,'"+locale+"','2') postal2_code_desc,");
				sqlContact.append("        res_tel_no contact1_no,");
				sqlContact.append("        oth_contact_no contact2_no,");
				sqlContact.append("        email_id,");
				sqlContact.append("        gender sex,");
				sqlContact.append("        get_age(date_of_birth) age");
				/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
				sqlContact.append("  , alt_addr_line1" );
				sqlContact.append("  , alt_addr_line2" );
				sqlContact.append("  , alt_addr_line3" );
				sqlContact.append("  , alt_addr_line4" );
				sqlContact.append("  , alt_town_code" );
				sqlContact.append("  , mp_get_desc.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc" );
				sqlContact.append("  , alt_area_code" );
				sqlContact.append("  , mp_get_desc.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc" );
				sqlContact.append("  , alt_region_code" );
				sqlContact.append("  , mp_get_desc.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc" );
				sqlContact.append("  , alt_postal_code" );
				sqlContact.append("  , mp_get_desc.MP_POSTAL_CODE(alt_postal_code,'"+locale+"',2) alt_postal_desc" );
				sqlContact.append("  , alt_country_code" );
				sqlContact.append("  , mp_get_desc.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc" );
				/*End*/
				sqlContact.append(" FROM   OA_APPT");
				sqlContact.append(" WHERE  appt_ref_no = ?");
				sqlContact.append("        AND facility_id = '"+facilityId+"'");
				fromValue=book_ref_no;
			} 
			else 
			{
				if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
				sqlContact.append("SELECT bed_class_code,");
				sqlContact.append("        res_addr_line1 addr1_line1,");
				sqlContact.append("        res_addr_line2 addr1_line2,");
				sqlContact.append("        res_addr_line3 addr1_line3,");
				sqlContact.append("        res_addr_line4 addr1_line4,");
				sqlContact.append("        res_town_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(res_town_code,'"+locale+"','1') res_town,");
				sqlContact.append("        res_area_code,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(res_area_code,'"+locale+"','1') res_area,");
				sqlContact.append("        res_region_code region_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(res_region_code,'"+locale+"','1') region,");
				sqlContact.append("        country_code country1_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(country_code,'"+locale+"','1') country1_desc,");
				sqlContact.append("        postal_code postal1_code,mp_get_desc.MP_POSTAL_CODE(postal_code,'"+locale+"','2') postal1_code_desc,");
				sqlContact.append("        mail_addr_line1 addr2_line1,");
				sqlContact.append("        mail_addr_line2 addr2_line2,");
				sqlContact.append("        mail_addr_line3 addr2_line3,");
				sqlContact.append("        mail_addr_line4 addr2_line4,");
				sqlContact.append("        mail_town_code res_town2_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(mail_town_code,'"+locale+"','1') res_town2,");
				sqlContact.append("        mail_area_code res_area2_code,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(mail_area_code,'"+locale+"','1') res_area2,");
				sqlContact.append("        mail_region_code region2_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(mail_region_code,'"+locale+"','1') region2_desc,");
				sqlContact.append("        mail_country_code country2_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(mail_country_code,'"+locale+"','1') country2_desc,");
				sqlContact.append("        mail_postal_code postal2_code,mp_get_desc.MP_POSTAL_CODE(mail_postal_code,'"+locale+"','2') postal2_code_desc,");
				sqlContact.append("        res_tel_no contact1_no,");
				sqlContact.append("        oth_contact_no contact2_no,");
				sqlContact.append("        email_id,");
				sqlContact.append("        gender sex,");
				sqlContact.append("        get_age(date_of_birth) age");
				/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
				sqlContact.append("  , alt_addr_line1" );
				sqlContact.append("  , alt_addr_line2" );
				sqlContact.append("  , alt_addr_line3" );
				sqlContact.append("  , alt_addr_line4" );
				sqlContact.append("  , alt_town_code" );
				sqlContact.append("  , mp_get_desc.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc" );
				sqlContact.append("  , alt_area_code" );
				sqlContact.append("  , mp_get_desc.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc" );
				sqlContact.append("  , alt_region_code" );
				sqlContact.append("  , mp_get_desc.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc" );
				sqlContact.append("  , alt_postal_code" );
				sqlContact.append("  , mp_get_desc.MP_POSTAL_CODE(alt_postal_code,'"+locale+"',2) alt_postal_desc" );
				sqlContact.append("  , alt_country_code" );
				sqlContact.append("  , mp_get_desc.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc" );
				/*End*/
				sqlContact.append(" FROM   IP_BOOKING_LIST");
				sqlContact.append(" WHERE  bkg_lst_ref_no =? ");
				sqlContact.append("        AND facility_id = '"+facilityId+"'");
				fromValue=book_ref_no;
			}
		}
		else
		{	
//thai - PR_REFERRAL_REGISTER
			if(from.equals("referral_id"))
			{
				if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
				sqlContact.append("SELECT addr_line1 addr1_line1,");
				sqlContact.append("        addr_line2 addr1_line2,");
				sqlContact.append("        addr_line3 addr1_line3,");
				sqlContact.append("        addr_line4 addr1_line4,");
				sqlContact.append("        res_town_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(res_town_code,'"+locale+"','1') res_town,");
				sqlContact.append("        res_area_code,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(res_area_code,'"+locale+"','1') res_area,");
				sqlContact.append("        region_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(region_code,'"+locale+"','2') region,");
				sqlContact.append("        country_code country1_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(country_code,'"+locale+"','1') country1_desc,");
				sqlContact.append("        postal_code postal1_code, mp_get_desc.MP_POSTAL_CODE(postal_code,'"+locale+"','2') postal1_code_desc,");
				sqlContact.append("        mail_addr_line1 addr2_line1,");
				sqlContact.append("        mail_addr_line2 addr2_line2,");
				sqlContact.append("        mail_addr_line3 addr2_line3,");
				sqlContact.append("        mail_addr_line4 addr2_line4,");
				sqlContact.append("        mail_res_town_code res_town2_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(mail_res_town_code,'"+locale+"','1') res_town2,");
				sqlContact.append("        mail_res_area_code res_area2_code,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(mail_res_area_code,'"+locale+"','1') res_area2,");
				sqlContact.append("        mail_region_code region2_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(mail_region_code,'"+locale+"','2') region2_desc,");
				sqlContact.append("        mail_country_code country2_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(mail_country_code,'"+locale+"','1') country2_desc,");
				sqlContact.append("        mail_postal_code postal2_code,mp_get_desc.MP_POSTAL_CODE(mail_postal_code,'"+locale+"','2') postal2_code_desc,");
				sqlContact.append("        contact1_no,");
				sqlContact.append("        contact2_no,");
				sqlContact.append("        email_id,");
				sqlContact.append("        sex,");
				sqlContact.append("        get_age(date_of_birth) age");
				/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
				sqlContact.append("  , alt_addr_line1" );
				sqlContact.append("  , alt_addr_line2" );
				sqlContact.append("  , alt_addr_line3" );
				sqlContact.append("  , alt_addr_line4" );
				sqlContact.append("  , alt_town_code" );
				sqlContact.append("  , mp_get_desc.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc" );
				sqlContact.append("  , alt_area_code" );
				sqlContact.append("  , mp_get_desc.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc" );
				sqlContact.append("  , alt_region_code" );
				sqlContact.append("  , mp_get_desc.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc" );
				sqlContact.append("  , alt_postal_code" );
				sqlContact.append("  , mp_get_desc.MP_POSTAL_CODE(alt_postal_code,'"+locale+"',2) alt_postal_desc" );
				sqlContact.append("  , alt_country_code" );
				sqlContact.append("  , mp_get_desc.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc" );
				/*End*/
				sqlContact.append(" FROM   PR_REFERRAL_REGISTER");
				sqlContact.append(" WHERE  referral_id = ?");
			}
			if(from.equals("patient_id"))
			{
				if(sqlContact.length() > 0) sqlContact.delete(0,sqlContact.length());
				/*sqlContact.append("SELECT a.addr1_type,");
				sqlContact.append("        a.addr1_line1,");
				sqlContact.append("        a.addr1_line2,");
				sqlContact.append("        a.addr1_line3,");
				sqlContact.append("        a.addr1_line4,");
				sqlContact.append("        a.postal1_code,");
				sqlContact.append("        a.country1_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(a.country1_code,'"+locale+"','1') country1_desc,");
				sqlContact.append("        a.contact1_name,");
				sqlContact.append("        a.invalid1_yn,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(b.res_area_code,'"+locale+"','1') res_area,");
				sqlContact.append("        b.res_area_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(b.res_town_code,'"+locale+"','1') res_town,");
				sqlContact.append("        b.res_town_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(b.region_code,'"+locale+"','1') region,");
				sqlContact.append("        b.region_code,");
				sqlContact.append("        a.addr2_type,");
				sqlContact.append("        a.addr2_line1,");
				sqlContact.append("        a.addr2_line2,");
				sqlContact.append("        a.addr2_line3,");
				sqlContact.append("        addr2_line4,");
				sqlContact.append("        postal2_code,");
				sqlContact.append("        country2_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(country2_code,'"+locale+"','1') country2_desc,");
				sqlContact.append("        contact2_name,");
				sqlContact.append("        a.invalid2_yn,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(a.res_area2_code,'"+locale+"','1') res_area2,");
				sqlContact.append("        a.res_area2_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(a.res_town2_code,'"+locale+"','1') res_town2,");
				sqlContact.append("        res_town2_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(a.region2_code,'"+locale+"','1') region2_desc,");
				sqlContact.append("        a.region2_code,");
				sqlContact.append("        b.contact1_no,");
				sqlContact.append("        b.contact2_no,");
				sqlContact.append("        b.email_id");
				sqlContact.append(" FROM   mp_pat_addresses a,");
				sqlContact.append("        mp_patient b");
				sqlContact.append(" WHERE  b.patient_id = a.patient_id");
				sqlContact.append("        AND b.patient_id =? ");*/

				sqlContact.append("SELECT a.addr1_type,");
				sqlContact.append("        a.addr1_line1,");
				sqlContact.append("        a.addr1_line2,");
				sqlContact.append("        a.addr1_line3,");
				sqlContact.append("        a.addr1_line4,");
				sqlContact.append("        a.postal1_code,mp_get_desc.MP_POSTAL_CODE(a.postal1_code,'"+locale+"','2') postal1_code_desc,");
				sqlContact.append("        a.country1_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(a.country1_code,'"+locale+"','1') country1_desc,");
				sqlContact.append("        a.contact1_name,");
				sqlContact.append("        a.invalid1_yn,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(b.res_area_code,'"+locale+"','1') res_area,");
				sqlContact.append("        b.res_area_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(b.res_town_code,'"+locale+"','1') res_town,");
				sqlContact.append("        b.res_town_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(b.region_code,'"+locale+"','1') region,");
				sqlContact.append("        b.region_code,");
				sqlContact.append("        a.addr2_type,");
				sqlContact.append("        a.addr2_line1,");
				sqlContact.append("        a.addr2_line2,");
				sqlContact.append("        a.addr2_line3,");
				sqlContact.append("        addr2_line4,");
				sqlContact.append("        postal2_code,mp_get_desc.MP_POSTAL_CODE(postal2_code,'"+locale+"','2') postal2_code_desc,");
				sqlContact.append("        country2_code,");
				sqlContact.append("        mp_get_desc.MP_COUNTRY(country2_code,'"+locale+"','1') country2_desc,");
				sqlContact.append("        contact2_name,");
				sqlContact.append("        a.invalid2_yn,");
				sqlContact.append("        mp_get_desc.MP_RES_AREA(a.res_area2_code,'"+locale+"','1') res_area2,");
				sqlContact.append("        a.res_area2_code,");
				sqlContact.append("        mp_get_desc.MP_RES_TOWN(a.res_town2_code,'"+locale+"','1') res_town2,");
				sqlContact.append("        res_town2_code,");
				sqlContact.append("        mp_get_desc.MP_REGION(a.region2_code,'"+locale+"','1') region2_desc,");
				sqlContact.append("        a.region2_code,");
				sqlContact.append("        b.contact1_no,");
				sqlContact.append("        b.contact2_no,");
				sqlContact.append("        b.email_id,");
				sqlContact.append("        b.sex,");
				sqlContact.append("        get_age(b.date_of_birth) age,");
				sqlContact.append("        b.bed_assigned_for_nb_yn");
				/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
				sqlContact.append("  , a.alt_addr_line1" );
				sqlContact.append("  , a.alt_addr_line2" );
				sqlContact.append("  , a.alt_addr_line3" );
				sqlContact.append("  , a.alt_addr_line4" );
				sqlContact.append("  , a.alt_town_code" );
				sqlContact.append("  , mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc" );
				sqlContact.append("  , a.alt_area_code" );
				sqlContact.append("  , mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc" );
				sqlContact.append("  , a.alt_region_code" );
				sqlContact.append("  , mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc" );
				sqlContact.append("  , a.alt_postal_code" );
				sqlContact.append("  , mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc" );
				sqlContact.append("  , a.alt_country_code" );
				sqlContact.append("  , mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc" );
				/*End*/
				sqlContact.append(" FROM   mp_pat_addresses a,");
				sqlContact.append("        mp_patient b");
				sqlContact.append(" WHERE  b.patient_id = a.patient_id");
				sqlContact.append("        AND b.patient_id =? ");
			}
		}
		try 
		{
			con  = ConnectionManager.getConnection(request);
			pstmt= con.prepareStatement(sqlContact.toString()) ;
			pstmt.setString( 1, fromValue);
			resultSet = pstmt.executeQuery() ;
			// adition to contact details pop starts here on 2/17/2004...
			if(resultSet != null) 
			{
				while(resultSet.next()) 
				{
					a_res_addr_line1		= checkForNull(resultSet.getString("addr1_line1"));
					a_res_addr_line2		= checkForNull(resultSet.getString("addr1_line2"));
					a_res_addr_line3		= checkForNull(resultSet.getString("addr1_line3"));
					a_res_addr_line4		= checkForNull(resultSet.getString("addr1_line4"));
					a_country_code		= checkForNull(resultSet.getString("country1_code"));
					a_country_desc		= checkForNull(resultSet.getString("country1_desc"));
					a_postal_code			= checkForNull(resultSet.getString("postal1_code"));
					a_postal_code_desc		= checkForNull(resultSet.getString("postal1_code_desc"));
					a_res_area_code		= checkForNull(resultSet.getString("res_area_code"));
					a_res_area				= checkForNull(resultSet.getString("res_area"));
					a_res_town2_code	= checkForNull(resultSet.getString("res_town_code"));
					a_res_town2_desc	= checkForNull(resultSet.getString("res_town"));
					a_res_region_code	= checkForNull(resultSet.getString("region_code"));
					a_res_region_desc	= checkForNull(resultSet.getString("region"));
					m_res_addr_line1		= checkForNull(resultSet.getString("addr2_line1"));
					m_res_addr_line2		= checkForNull(resultSet.getString("addr2_line2"));
					m_res_addr_line3		= checkForNull(resultSet.getString("addr2_line3"));
					m_res_addr_line4		= checkForNull(resultSet.getString("addr2_line4"));
					m_postal_code			= checkForNull(resultSet.getString("postal2_code"));
					m_postal_code_desc		= checkForNull(resultSet.getString("postal2_code_desc"));
					m_country_code		= checkForNull(resultSet.getString("country2_code"));
					m_country_desc		= checkForNull(resultSet.getString("country2_desc"));
					m_res_area_code		= checkForNull(resultSet.getString("res_area2_code"));
					m_res_area_desc		= checkForNull(resultSet.getString("res_area2"));
					m_res_town2_code	= checkForNull(resultSet.getString("res_town2_code"));
					m_res_town2_desc	= checkForNull(resultSet.getString("res_town2"));
					m_res_region_code	= checkForNull(resultSet.getString("region2_code"));
					m_res_region_desc	= checkForNull(resultSet.getString("region2_desc"));
					strPrimaryResNo		= checkForNull(resultSet.getString("CONTACT1_NO"));
					strOtherResNo			= checkForNull(resultSet.getString("CONTACT2_NO"));
					strEmail					= checkForNull(resultSet.getString("EMAIL_ID"));
					/*Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start*/
					alt_addr_line1		= checkForNull(resultSet.getString("alt_addr_line1"));
					alt_addr_line2		= checkForNull(resultSet.getString("alt_addr_line2"));
					alt_addr_line3		= checkForNull(resultSet.getString("alt_addr_line3"));
					alt_addr_line4		= checkForNull(resultSet.getString("alt_addr_line4"));
					alt_area_code		= checkForNull(resultSet.getString("alt_area_code"));
					alt_area_desc		= checkForNull(resultSet.getString("alt_area_desc"));
					alt_town_code		= checkForNull(resultSet.getString("alt_town_code"));
					alt_town_desc		= checkForNull(resultSet.getString("alt_town_desc"));
					alt_region_code		= checkForNull(resultSet.getString("alt_region_code"));
					alt_region_desc		= checkForNull(resultSet.getString("alt_region_desc"));
					alt_postal_code		= checkForNull(resultSet.getString("alt_postal_code"));
					alt_postal_desc		= checkForNull(resultSet.getString("alt_postal_desc"));
					alt_country_code	= checkForNull(resultSet.getString("alt_country_code"));
					alt_country_desc	= checkForNull(resultSet.getString("alt_country_desc"));
					/*End*/
					sex					= checkForNull(resultSet.getString("sex"));
					age					= checkForNull(resultSet.getString("age"));
					if(from.equals("patient_id") && book_ref_no.equals("")){
						bed_assigned_for_nb_yn=checkForNull(resultSet.getString("bed_assigned_for_nb_yn"));

					}
				}
			}
			contactAddress.append(""+"^^");
			contactAddress.append(a_res_addr_line1+"^^");
			contactAddress.append(a_res_addr_line2+"^^");
			contactAddress.append(a_res_addr_line3+"^^");
			contactAddress.append(a_res_addr_line4+"^^");
			contactAddress.append(a_res_town2_code+"^^");
			contactAddress.append(a_res_area_code+"^^");
			contactAddress.append(a_postal_code+"^^");
			contactAddress.append(a_res_region_code+"^^");
			contactAddress.append(a_country_code+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(m_res_addr_line1+"^^");
			contactAddress.append(m_res_addr_line2+"^^");
			contactAddress.append(m_res_addr_line3+"^^");
			contactAddress.append(m_res_addr_line4+"^^");
			contactAddress.append(m_res_town2_code+"^^");
			contactAddress.append(m_res_area_code+"^^");
			contactAddress.append(m_postal_code+"^^");
			contactAddress.append(m_res_region_code+"^^");
			contactAddress.append(m_country_code+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(strPrimaryResNo+"^^");
			contactAddress.append(strOtherResNo+"^^");
			contactAddress.append(strEmail+"^^");
			contactAddress.append(""+"^^");
			contactAddress.append(a_res_town2_desc+"^^");
			contactAddress.append(a_res_area+"^^");
			contactAddress.append(a_res_region_desc+"^^");
			contactAddress.append(m_res_town2_desc+"^^");
			contactAddress.append(m_res_area_desc+"^^");
			contactAddress.append(m_res_region_desc+"^^");
			contactAddress.append(a_country_desc+"^^");
			contactAddress.append(m_country_desc+"^^");
			//contactAddress.append(m_country_desc);
			contactAddress.append(a_postal_code_desc+"^^");
			contactAddress.append(m_postal_code_desc+"^^");
			/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
			contactAddress.append(alt_addr_line1+"^^");
			contactAddress.append(alt_addr_line2+"^^");
			contactAddress.append(alt_addr_line3+"^^");
			contactAddress.append(alt_addr_line4+"^^");
			contactAddress.append(alt_town_code+"^^");
			contactAddress.append(alt_town_desc+"^^");
			contactAddress.append(alt_area_code+"^^");
			contactAddress.append(alt_area_desc+"^^");
			contactAddress.append(alt_region_code+"^^");
			contactAddress.append(alt_region_desc+"^^");
			contactAddress.append(alt_postal_code+"^^");
			contactAddress.append(alt_postal_desc+"^^");
			contactAddress.append(alt_country_code+"^^");
			contactAddress.append(alt_country_desc+"~");
			/*End*/
			contactAddress.append(sex+"@");
			contactAddress.append(age);
			if(from.equals("patient_id") && book_ref_no.equals("")){
				contactAddress.append("@"+bed_assigned_for_nb_yn);
			}
			
			if(resultSet!=null)     resultSet.close();
			if(pstmt!=null)			pstmt.close();
		}
		catch ( Exception e ) 
		{
			//out.println("Second Exception in AdmissionValidation.jsp : "+e.toString());
			e.printStackTrace() ;
		} 
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
		return contactAddress;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);   
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale =	(String)session.getAttribute("LOCALE");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	//PreparedStatement	pstmt1		=	null;
	Statement			stmt		=	null;
	Statement			stmt_nu		=	null;
	ResultSet			rset		=	null;
	//ResultSet			rset1		=	null;

	Statement			SubSerStmt		=	null;
	ResultSet			SubSerRset		=	null;

	ResultSet			rset_nu		=	null;
	ResultSet			rsetBL		=	null;
	Statement			stmt1		=	null;
	ResultSet			rs			=	null;
	Statement			stmt1_p		=	null;
	ResultSet			rs_p		=	null;
	Statement			patstmt		=   null;
	ResultSet			patrs		=   null;
	String loginUser				= (String)session.getAttribute("login_user");
	java.util.Properties propertiesBill = (java.util.Properties) session.getValue( "jdbc" ) ;
	StringBuffer sql				= new StringBuffer(); 
	StringBuffer query_booking_ref_no= new StringBuffer(); 
	String maxperiodforrevbkg1		= checkForNull(request.getParameter("bkg_grace_period"));	
	String admission_for= checkForNull(request.getParameter("admission_for"));



	String facilityId				= "";
	String value1					= ""; 
	String value2					= "";
	String value3					= ""; 
	String from						= ""; 
	String value5					= "";
	String patientid				= "";
	String dissource                = "";
	String disspec					= "";	
	String attendpractitionerid		= "";
	String bookingrefno				= "";
	String patient					= "";
	String encounter				= "";
	String referralid				= "";
	String ID						= "";
	String dat						= ""; 
	String practitionerid			= "";
	String nursingunit				= "";
	String bookingstatus			= "";
	String blooddonation			= "";
	String specialitycode			= "";
	String chiefcomplaint			= "";
	String otdatetime				= "";	
	String chiefcomplaint_desc		= "";
	String bedclasscode				= "";	
	String bedClassDesc				= "";	
	String bedtypecode				= "";
	
	/*Below line Added for this CRF Bru-HIMS-CRF-261*/
	String assign_bed_type_code="";
	String assign_bed_class_code="";
	String visit_admtype="";
	String quickbedtypecode ="";
    String bedtypeshortdesc="";
	String quick_admin_yn="";
	String quickadmchk="";
	//End Bru-HIMS-CRF-261 
	
//Below line added for this CRF GDOH-CRF-0129    	
	String assigncare_location_code="",assigncare_location_desc="",assigncareloctype="";
	Boolean isReferral=false;
	Boolean isCurrentEncounter=false;
	ArrayList arrIPList=null;
	ArrayList arrOPList=null; 
	String referralforcurrentencounter="";
//End GDOH-CRF-0129
	String gen_remark ="";
	
	
	/*Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] */
	    long diff=0;
	/* end Bru-HIMS-CRF-155 [IN030274]  */
		 

	String bedtypedesc				= "";
	String nursingunitcode			= "",		roomno					=	"";
	String bedno					= "",		serviceshortdesc		=	"";	
	String referral_id				= "",		ancillaryyn				=	"";
	String servicecode				= "",		servicedesc				=	"";
	String Indicator				= "";
	String practtype				= "";
	String visitstatus				= "";
	String specialty_short_desc		= "";
	String exp_days_of_stay			= "",		exp_discharge_date		=	"";
	String visit_adm_date_time		= "",		practitioner_name		=	"";	
	String p_nursing_unit_desc		= "",		expDaysofStay = "";
	String continue_yn				= "";
	String to_service_code			= "";
	String to_speciality_code		= "";
	String to_speciality_desc		= "";
	String queryString				= "";
	String teamid					= "";
	String financial_detail_ref_id	= "";
	String org_type_data			= "";
	String practitioner				= "";
	String servcode					= "";
	String contactDetailFlag		= "";
	String patientclass				= "";
	String patient_nursingunit		= "";
	String patient_class_code		= "";
	String bed_class				= "";	
	String nursingunit_code			= "";	
	String assign_bed_yn			= "";	
	String checkpat					= "";	
	String deactivate_pseudo_bed_yn	= "N";	
	StringBuffer concat_address_hidden=new StringBuffer();
    String booking_type				= "";
	String operator_station			= "";
	String clinic_code				= "";
	int		flag					=	0;
	String bl_operational =	(String)session.getValue("bl_operational"); 
	boolean	result					=	true;
	boolean	continueyn				=	true;
	boolean	RELOAD					=	false;
	String module_id				= "";
	String calling_function_id		= "";
	String episode_type				= admission_for;
	//String infce_for_pvlg="N";
	//String SS_UC_CG_status="";
	int mult_bkg_cnt				=	0;
	float outst_amt					=	0;
	int reccnt						=	0;
	String record					= "";
	String outst_amt1				= "0";
	String	age						=	"";
	String	gender					=	"";	
	String	bed_assigned_for_nb_yn	=	"N";	
	String booking_remarks		    = "";
	String fVal						= "";
	Boolean restrictPseudoBed	    = false; //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151
	String isUHID_valid_appl = ""; // added by mujafar for AMRI-CRF-0357
	Boolean isNationalIdValidationAppl = false; //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	Boolean isPrevDiscgBillNotRaised = false; // Added by Lakshmanan on 26-05-2023 for AAKH-CRF-0162 US001
	try
	{
		con					=	ConnectionManager.getConnection(request);
		value1				=	checkForNull(request.getParameter("field1"));
				
		
		value2				=	checkForNull(request.getParameter("field2"));
		value3				=	checkForNull(request.getParameter("field3"));
		value5				=	checkForNull(request.getParameter("field5"));
		String pid = "";
		if(!value2.equals("")){
			pid = value2;
		}else if(!value5.equals("")){
		try{
			pstmt = con.prepareStatement("select patient_id from pr_referral_register where referral_id = ?");
			pstmt.setString(1, value5);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				pid = checkForNull(rs.getString("patient_id"));
			}
			if(pstmt != null) pstmt.close();
		    if(rs != null) rs.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		try{
		//Added for ML-MMOH-CRF-1802
	    pstmt   = con.prepareStatement("select patient_remarks from mp_patient_remarks where patient_id=?");
		    pstmt.setString(1,pid);
	    rs    = pstmt.executeQuery();
		if(rs!=null && rs.next())
			{
	    gen_remark = checkForNull(rs.getString("patient_remarks"));
			}
	    if(pstmt != null) pstmt.close();
	    if(rs != null) rs.close();
		}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		
		deactivate_pseudo_bed_yn	= request.getParameter("deactivate_pseudo_bed_yn");
		if(deactivate_pseudo_bed_yn == null) deactivate_pseudo_bed_yn= "N";
		from					=	checkForNull(request.getParameter("field4"));
		isUHID_valid_appl = checkForNull(request.getParameter("isUHID_valid_appl")); // added by mujafar for AMRI-CRF-0357

		isNationalIdValidationAppl = CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION"); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
		isPrevDiscgBillNotRaised =	CommonBean.isSiteSpecific(con, "IP","PREVIOUS_DISG_BILL_NOT_RAISED"); // Added by Lakshmanan on 26-05-2023 for AAKH-CRF-0162 US001
		
		nursingunitcode=checkForNull(request.getParameter("nursing_unit_code"));//Added for this line Bru-SCF-1477
		//bedclasscode=checkForNull(request.getParameter("bed_class_code"));//Added for this line Bru-SCF-1486
			
		
		Indicator				=	checkForNull(request.getParameter("Indicator"));
		facilityId				=	(String)session.getValue("facility_id");
		patdata.setFacility_id(facilityId);

		restrictPseudoBed	= CommonBean.isSiteSpecific(con,"IP","RESTRICT_PSEUDO_BED"); //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151
		boolean isInvokeChngPatDtls  = CommonBean.isSiteSpecific(con, "MP","MP_RESIDENCY_NAT_ALT1_ID_MAND"); // Added by Dharma on 25th Apr against MMS-DM-CRF-0152.1 [IN:070226]
		boolean isChkMPParamMandFlds = CommonBean.isSiteSpecific(con, "MP", "MP_CHK_MAND_FLDS"); /*Added by Dharma on 15th May 2020 against KDAH-CRF-0522.1*/
		boolean isNatIdAltIdMandVisaType = CommonBean.isSiteSpecific(con, "MP", "MP_VAL_VISA_TYPE");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
		boolean isCountryRegionValAppl = CommonBean.isSiteSpecific(con, "MP", "CHECK_COUNTRY_REGION");//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1

		//Below line added for this GDOH-CRF-0129
  isReferral=CommonBean.isSiteSpecific(con, "IP","REGISTER_REFERRAL");  
  if(isReferral && from.equals("Select_form")){
		arrIPList=(ArrayList)ReferralCurrentEncounterDetails.getIPCurrentEncounterDetails(con,value2,facilityId,propertiesBill);
			 for(int ip=0; ip<arrIPList.size(); ip++){
					ReferralCurrentEncounterDetailsBean ipEncounterDetails=(ReferralCurrentEncounterDetailsBean)arrIPList.get(ip); 
					assigncare_location_code=ipEncounterDetails.getAssigncareloccode();
					assigncare_location_desc=ipEncounterDetails.getAssigncarelocdesc();
					assigncareloctype=ipEncounterDetails.getAssigncareloctype();
					referralforcurrentencounter="disabled";
					isCurrentEncounter=true;
					
			 }
 if(arrIPList.size()==0){
		arrOPList=(ArrayList)ReferralCurrentEncounterDetails.getOPCurrentEncounterDetails(con,value2,facilityId,propertiesBill);
			 for(int op=0; op<arrOPList.size(); op++){
					ReferralCurrentEncounterDetailsBean opEncounterDetails=(ReferralCurrentEncounterDetailsBean)arrOPList.get(op); 
					assigncare_location_code=opEncounterDetails.getAssigncareloccode();
					assigncare_location_desc=opEncounterDetails.getAssigncarelocdesc();
					assigncareloctype=opEncounterDetails.getAssigncareloctype();
					referralforcurrentencounter="disabled";
					isCurrentEncounter=true;
			}
		  }
 }
 //End GDOH-CRF-0129
		
		
		//value5				=	checkForNull(request.getParameter("field5"));
		expDaysofStay		=	checkForNull(request.getParameter("expDaysofStay"));
		visit_adm_date_time	=	checkForNull(request.getParameter("visit_adm_date_time"));
		checkpat	=	checkForNull(request.getParameter("checkpat"));

		
		continue_yn		=	checkForNull(request.getParameter("continue_yn"));
		queryString 		=	checkForNull(request.getParameter("queryString"));

		servcode			=	checkForNull(request.getParameter("serviceCode"));
		bed_class			=	checkForNull(request.getParameter("bed_class"));
		nursingunit_code	=	checkForNull(request.getParameter("nursingunit_code"));
		assign_bed_yn		=	checkForNull(request.getParameter("assign_bed_yn"));

		String frame_ref = checkForNull(request.getParameter("frame_ref"));
		patient_nursingunit = checkForNull(request.getParameter("patient_nursingunit"));
		operator_station    = checkForNull(request.getParameter("operator_station"));
		String future_yn     = checkForNull(request.getParameter("future_yn"));
		String bl_interface_yn		= checkForNull(request.getParameter("bl_interface_yn"));
		String regfromquery			= checkForNull(request.getParameter("regfromquery"));
		String bl_install_yn		= checkForNull(request.getParameter("bl_install_yn"));
		String from_adv_bed_mgmt		= checkForNull(request.getParameter("from_adv_bed_mgmt"),"N"); 
			
		String health_card_expired_yn_check		= checkForNull(request.getParameter("health_card_expired_yn_check"),"N");
		String quick_admission_type		= checkForNull(request.getParameter("quick_admission_type"),"N");//modified for the incident - 40321
		String bed_type_code ="";
		String bed_type_desc ="";
		fVal					=	checkForNull(request.getParameter("fVal"));
		 
		
		//Billing----If patient check in = "Y" Eligibility check should be done irrespective of bed no. If patient check in = "N" Eligibility check will be done if bed no is not null
		if(health_card_expired_yn_check.equals("N")){
		if(future_yn.equals("Y"))
		{  
			patientid = checkForNull(request.getParameter("pat_id"));
			String f_flag2 = "";	

			if(sql.length() > 0) sql.delete(0,sql.length());

			sql.append(" Select booking_type, override_yn, patient_id from IP_BED_BOOKING WHERE facility_id = '"+facilityId+"' and req_nursing_unit_code = '"+patient_nursingunit+"' and req_bed_no = '"+value3+"' and booking_status = '0' and blocked_from_date_time > sysdate and ( patient_id is null or patient_id != '"+patientid+"') ");



			stmt	=	con.createStatement();
			rset	=	stmt.executeQuery(sql.toString());

			if(rset!=null && rset.next())
			{
				f_flag2 = "Y";
			}
			if(rset !=null) rset.close(); 
			if(stmt != null) stmt.close();
			
            _bw.write(_wl_block10Bytes, _wl_block10);
if(f_flag2.equals("Y"))
			{
	
				out.println("<script>var retval = confirm(getMessage('BED_BLCKD_FOR_FUT_DT','IP'));if(retval){parent.frames[1].frames[2].document.AdmitPatient_form.confirm_flag.value = 'Y';parent.frames[1].frames[2].document.AdmitPatient_form.r_bed_no.value=parent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value;if(parent.frames[1].frames[2].document.AdmitPatient_form.isBlInstalled.value == 'Y'){if(parent.frames[1].frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value=='N'){if(parent.frames[1].frames[2].document.AdmitPatient_form.r_bed_no.value!=''){parent.frames[1].frames[2].BLCheckElig(parent.frames[1].frames[1])}else{parent.frames[1].frames[2].document.AdmitPatient_form.r_bed_no.value=parent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value;parent.frames[1].frames[2].document.AdmitPatient_form.submit();}}else{parent.frames[1].frames[2].BLCheckElig(parent.frames[1].frames[1])}}else{parent.frames[1].frames[2].document.AdmitPatient_form.submit();}}else{parent.commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit Patient&function_type=F&access=NYNNN';parent.create();}</script>");
			}
			else
			{
				out.println("<script>parent.frames[1].frames[2].document.AdmitPatient_form.confirm_flag.value = 'N';parent.frames[1].frames[2].document.AdmitPatient_form.r_bed_no.value=parent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value;if(parent.frames[1].frames[2].document.AdmitPatient_form.isBlInstalled.value =='Y'){if(parent.frames[1].frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value=='N') {if(parent.frames[1].frames[2].document.AdmitPatient_form.r_bed_no.value!=''){parent.frames[1].frames[2].BLCheckElig(parent.frames[1].frames[1])}else{parent.frames[1].frames[2].document.AdmitPatient_form.submit();}}else{parent.frames[1].frames[2].BLCheckElig(parent.frames[1].frames[1])}}else{parent.frames[1].frames[2].document.AdmitPatient_form.submit();}</script>");
			}
		}
		
		if(!bed_class.equals(""))
		{

			if( deactivate_pseudo_bed_yn.equals("Y") && !nursingunit_code.equals("") )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b WHERE b.language_id = '"+locale+"' and a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunit_code+"' AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = '"+bed_class+"' AND a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc ");
			}
			else if( deactivate_pseudo_bed_yn.equals("N") && !nursingunit_code.equals("") )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b WHERE b.language_id = '"+locale+"' and a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunit_code+"' AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = '"+bed_class+"' AND a.eff_status='E' AND b.eff_status = 'E' ORDER BY b.short_desc ");
			}

			stmt	=	con.createStatement();
			rset	=	stmt.executeQuery(sql.toString());

			if(assign_bed_yn.equals("Y"))
				out.println("<script>var obj =parent.parent.frames[1].document.assign_bed.Bedtype;</script>");
			else
				out.println("<script>var obj =parent.parent.frames[1].frames[2].document.AdmitPatient_form.bed_type;</script>");
			out.println("<script>var length  = obj.length;");
			out.println("for(i=0;i<length;i++) {obj.remove(1);}");
			out.println("</script>");

			if(rset != null)
			{
				while(rset.next())
				{
					bed_type_code = checkForNull(rset.getString("bed_type_code"));
					bed_type_desc = checkForNull(rset.getString("bed_type_short_desc"));

					if(assign_bed_yn.equals("Y"))
					{
						out.println ("<script>var opt= parent.parent.frames[1].document.createElement('Option');\nopt.text=\""+bed_type_desc+"\"; opt.value=\""+bed_type_code+"\";obj.add(opt)");
						out.println("</script>");
					}
					else
					{
						out.println ("<script>var opt= parent.parent.frames[1].frames[2].document.createElement('Option');\nopt.text=\""+bed_type_desc+"\"; opt.value=\""+bed_type_code+"\";obj.add(opt);");
						out.println("</script>");
					}
				}//while loop
				if(rset !=null) rset.close(); 
				if(stmt != null) stmt.close();
			 }//if rset not null
		}

		if(from.equals("populateBedClass") && !nursingunit_code.equals(""))
		{
			String bc_short_desc= "";
			String bc_code		= "";
			// To populate the BED CLASS ...
			if(sql.length() > 0) sql.delete(0,sql.length());
			//sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunit_code+"' AND a.bed_class_code = b.bed_class_code and b.language_id = '"+locale+"' ORDER BY b.short_desc ");
			sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunit_code+"' ORDER BY short_desc ");

			stmt = con.createStatement();
			rset = stmt.executeQuery(sql.toString());
			if(rset!=null)
			{
				while(rset.next())
				{
					bc_short_desc	= rset.getString("short_desc");
					bc_code = rset.getString("bed_class_code");
					
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bc_short_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bc_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
	
				}// E.O While
			}// E.O if
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		}

		if(from.equals("patientcode_value"))
		{
			
			from = "";
			continueyn =false;
			String sql_nu = sql_nu = "SELECT APPL_PATIENT_CLASS Patient_Class FROM   IP_NURSING_UNIT WHERE  Facility_Id = '"+facilityId+"' AND eff_Status = 'E' AND nurSing_Unit_Code = '"+patient_nursingunit+"'";



			stmt_nu = con.createStatement();
			rset_nu = stmt_nu.executeQuery(sql_nu);								
			if((rset_nu != null) && (rset_nu.next()))
			{
				patient_class_code = rset_nu.getString("PATIENT_CLASS");
			}
			if(rset_nu !=null) rset_nu.close(); 
			if(stmt_nu != null) stmt_nu.close();
			out.println("<script>parent.frames[1].frames[2].document.AdmitPatient_form.patient_class_id.value=\""+patient_class_code+"\";</script>");
		}
		else if(from.equals("Select_form"))
		{  
			bookingrefno	=	value1;
			patient         =	value2;
			encounter       =	value3;
			referralid      =	value5;
         
			if( (!referralid.equals(""))  && (bookingrefno.equals("")) )
			{
				//referral id is given...
				concat_address_hidden=getContactDetails("referral_id",referralid,bookingrefno,request,out,con,facilityId,booking_type,locale);
				contactDetailFlag			=	"from_referral";
				String sexandage			=	"";
				String continue_as_mlc_yn	= "N";
				String referral_dtls		= "";
				String admit_ref_pat_yn		= "";

				StringTokenizer token=new StringTokenizer(concat_address_hidden.toString(),"~");
				while (token.hasMoreTokens()){
					concat_address_hidden	= new StringBuffer(token.nextToken());
					sexandage				= token.nextToken();
				}
				token						= new StringTokenizer(sexandage,"@");
				while (token.hasMoreTokens()){
					gender=token.nextToken();
					age=token.nextToken();
				}
				session.putValue("queryString", queryString);
				if(sql.length() > 0) sql.delete(0,sql.length());

				//sql.append("SELECT b.apPl_Patient_Class, a.Patient_Id, To_prAct_Id, Am_Get_desc.Am_practitioner(a.To_prAct_Id,'"+locale+"','1') To_fcy_prAct_Name, a.To_SpecialIty_Code, Am_Get_desc.Am_speciality(a.To_SpecialIty_Code,'"+locale+"','2') To_SpecialIty_desc, a.to_locn_code To_nurs_Unit_Code, ip_Get_desc.Ip_nursing_unit('"+facilityId+"', a.TO_LOCN_CODE,'"+locale+"', '2') To_nurs_Unit_desc, a.Continue_As_mlc_yn, a.To_Locn_Type, a.To_Service_Code, (case when a.from_ref_code is not null then (select org_type from am_referral where referral_code = a.from_ref_code) end) org_type, substr(get_referral_detail_line('"+referralid+"','FROM','"+locale+"'),3) referral_dtls, (select admit_pat_yn from AM_RESTRN_FOR_OPER_STN  where facility_id = '"+facilityId+"' and oper_stn_id = '"+operator_station+"' and APPL_USER_ID = '"+loginUser+"' and locn_type = 'N' and LOCN_CODE = a.TO_LOCN_CODE) admit_ref_pat_yn FROM PR_REFERRAL_REGISTER a, IP_NURSING_UNIT b WHERE  a.Referral_Id = '"+referralid+"' AND a.Status = 'O' AND a.To_Facility_Id = '"+facilityId+"' AND a.ReferRed_For_ip = 'A' AND a.To_Facility_Id =  b.Facility_Id (+) AND b.nurSing_Unit_Code (+)  = a.to_locn_code");
				
				/*Above query commented and Below query Added for thi CRF [Bru-HIMS-CRF-621]*/
				sql.append("SELECT b.apPl_Patient_Class, a.Patient_Id, To_prAct_Id, Am_Get_desc.Am_practitioner(a.To_prAct_Id,'"+locale+"','1') To_fcy_prAct_Name, a.To_SpecialIty_Code, Am_Get_desc.Am_speciality(a.To_SpecialIty_Code,'"+locale+"','2') To_SpecialIty_desc, a.to_locn_code To_nurs_Unit_Code, ip_Get_desc.Ip_nursing_unit('"+facilityId+"', a.TO_LOCN_CODE,'"+locale+"', '2') To_nurs_Unit_desc, a.Continue_As_mlc_yn, a.To_Locn_Type, a.To_Service_Code, (case when a.from_ref_code is not null then (select org_type from am_referral where referral_code = a.from_ref_code) end) org_type, substr(get_referral_detail_line('"+referralid+"','FROM','"+locale+"'),3) referral_dtls, (select admit_pat_yn from AM_RESTRN_FOR_OPER_STN  where facility_id = '"+facilityId+"' and oper_stn_id = '"+operator_station+"' and APPL_USER_ID = '"+loginUser+"' and locn_type = 'N' and LOCN_CODE = a.TO_LOCN_CODE) admit_ref_pat_yn,assign_bed_type_code,assign_bed_class_code,visit_adm_type,quick_admission_yn,AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','X','','QUICK_ADMISSION_YN') quickadmchk FROM PR_REFERRAL_REGISTER a, IP_NURSING_UNIT b WHERE  a.Referral_Id = '"+referralid+"' AND a.Status = 'O' AND a.To_Facility_Id = '"+facilityId+"' AND a.ReferRed_For_ip = 'A' AND a.To_Facility_Id =  b.Facility_Id (+) AND b.nurSing_Unit_Code (+)  = a.to_locn_code");


				/*sql.append("SELECT b.apPl_Patient_Class,");
				sql.append("        Patient_Id,");
				sql.append("        To_prAct_Id,");
				sql.append("        Am_Get_desc.Am_practitioner(To_prAct_Id,'"+locale+"','1') To_fcy_prAct_Name,");
				sql.append("        To_SpecialIty_Code,");
				sql.append("        Am_Get_desc.Am_speciality(To_SpecialIty_Code,'"+locale+"','2') To_SpecialIty_desc,");
				sql.append("        to_locn_code To_nurs_Unit_Code,");
				sql.append("        ip_Get_desc.Ip_nursing_unit('"+facilityId+"',TO_LOCN_CODE,'"+locale+"',");
				sql.append("                                    '2') To_nurs_Unit_desc,");
				sql.append("        Continue_As_mlc_yn,");
				sql.append("        To_Locn_Type,");
				sql.append("        To_Service_Code, ");
				sql.append(" FROM   PR_REFERRAL_REGISTER a,");
				sql.append("        IP_NURSING_UNIT b");
				sql.append(" WHERE  a.Referral_Id = '"+referralid+"'");
				sql.append("        AND a.Status = 'O'");
				sql.append("        AND a.To_Facility_Id = '"+facilityId+"' ");
				sql.append("        AND a.ReferRed_For_ip = 'A'");
				sql.append("        AND a.To_Facility_Id = b.Facility_Id (+) ");
				sql.append("        AND b.nurSing_Unit_Code (+)  = a.to_locn_code");*/

				stmt = con.createStatement();

				rset = stmt.executeQuery(sql.toString());

				if(rset.next())
				{
					patientid					=	checkForNull(rset.getString("PATIENT_ID"));	
					
					to_speciality_code			=   checkForNull(rset.getString("to_speciality_code"));
					to_speciality_desc			=   checkForNull(rset.getString("to_speciality_desc"));
					to_service_code				=   checkForNull(rset.getString("to_service_code"));
					practitionerid				=	checkForNull(rset.getString("TO_PRACT_ID"));
					practitioner				=   checkForNull(rset.getString("TO_FCY_PRACT_NAME"));
					nursingunit					=	checkForNull(rset.getString("TO_NURS_UNIT_CODE"));
					p_nursing_unit_desc			=   checkForNull(rset.getString("TO_NURS_UNIT_DESC"));
					patientclass				=	checkForNull(rset.getString("appl_patient_class"));
					continue_as_mlc_yn			=	checkForNull(rset.getString("CONTINUE_AS_MLC_YN"),"N");
					org_type_data				=	checkForNull(rset.getString("org_type"));
					referral_dtls				=	checkForNull(rset.getString("referral_dtls"));
					admit_ref_pat_yn			=	checkForNull(rset.getString("admit_ref_pat_yn"),"Y");
					
					/*Below line Added for this CRF Bru-HIMS-CRF-261*/
					assign_bed_type_code=	checkForNull(rset.getString("assign_bed_type_code"));
					assign_bed_class_code=	checkForNull(rset.getString("assign_bed_class_code"));
					visit_admtype=	checkForNull(rset.getString("visit_adm_type"));
					quick_admin_yn=	checkForNull(rset.getString("quick_admission_yn"));
					quickadmchk=checkForNull(rset.getString("quickadmchk"));
					
					
					//End Bru-HIMS-CRF-261

					if (rset!=null) rset.close();					
					if (stmt!=null) stmt.close();
					stmt = con.createStatement();

					/*if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select get_referral_detail_line('"+referralid+"','FROM','"+locale+"') from dual");
					rset = stmt.executeQuery(sql.toString());	
					if (rset.next())
					{
						out.println("<script>parent.frames[1].frames[2].document.forms[0].continue_as_mlc_yn.value='"+continue_as_mlc_yn+"';if (parent.frames[1].frames[2].document.getElementById('reftab').rows(0)) {parent.frames[1].frames[2].document.getElementById('reftab').deleteRow(0);parent.frames[1].frames[2].document.getElementById('reftab').deleteRow(0);}parent.frames[1].frames[2].document.getElementById('reftab').insertRow(0);parent.frames[1].frames[2].document.getElementById('reftab').insertRow(1);parent.frames[1].frames[2].document.getElementById('reftab').rows(0).insertCell();parent.frames[1].frames[2].document.getElementById('reftab').rows(0).cells(0).className='HEADFORREF';parent.frames[1].frames[2].document.getElementById('reftab').rows(0).cells(0).insertAdjacentHTML('afterbegin','Referral Details'); parent.frames[1].frames[2].document.getElementById('reftab').rows(1).insertCell();parent.frames[1].frames[2].document.getElementById('reftab').rows(1).cells(0).className='REFDATA';parent.frames[1].frames[2].document.getElementById('reftab').rows(1).cells(0).insertAdjacentHTML('AfterBegin',\"<b>"+referral_dtls+"\");</script>");*/
					/*}
					if (rset!=null) rset.close();					
					if (stmt!=null) stmt.close();

					String orgTypeSQL = "select b.org_type from PR_REFERRAL_REGISTER a, AM_REFERRAL b where a.referral_id = '"+referralid+"' and a.from_ref_code = b.referral_code ";						
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
					}
					else
					{
						org_type_data="G";
					}
					
					if(rset != null)rset.close(); if(stmt != null) stmt.close();*/	

					if(org_type_data.equals("P"))  		
						org_type_data="P";
					else
						org_type_data="G";

					if(org_type_data.trim().length() > 0)
					{
						out.print("<script>if(parent.frames[1].frames[2].document.AdmitPatient_form.org_type_ind){");
						out.print("parent.frames[1].frames[2].document.AdmitPatient_form.org_type_ind.value='" + org_type_data + "';}</script>");	
					}

					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(nursingunit));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_nursing_unit_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_nursing_unit_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(concat_address_hidden.toString()));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);

				}
				else
				{
					result		=	false;
					continueyn	=	false;
					if(bookingrefno.equals(""))
					{
						out.print("<script>alert(getMessage('INV_REF_ID','IP'));");
						out.print("parent.frames[1].frames[0].document.getElementById(\"validatePat_yn\").value = 'N';parent.frames[1].frames[0].document.getElementById(\"referral_id\").value=\"\";</script>");
						out.print("<script>	if(parent.frames[1].frames[2].document.AdmitPatient_form.isBlInstalled.value=='true')");
						out.print("parent.frames[1].frames[2].document.AdmitPatient_form.financial_detail_ref_id.value='';</script>");	
						out.println("<script>if(parent.frames[1].frames[0].document.Select_form.call_func.value=='PATREG') parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();</script>");
					}
				}
		 		if(continueyn)
				{
					/*String admit_ref_pat_yn = "";
					if(!nursingunit.equals(""))
					{
						StringBuffer sqlNurs1 = new StringBuffer();

						sqlNurs1.append("select admit_pat_yn from AM_RESTRN_FOR_OPER_STN  where facility_id = '"+facilityId+"' and oper_stn_id = '"+operator_station+"' and APPL_USER_ID = '"+loginUser+"' and locn_type = 'N' and LOCN_CODE = '"+nursingunit+"' ");
						stmt	=	con.createStatement();
						ResultSet rsNurs1 =	stmt.executeQuery(sqlNurs1.toString());
						if(rsNurs1 != null && rsNurs1.next())
							admit_ref_pat_yn = rsNurs1.getString(1);
						if(admit_ref_pat_yn == null)	admit_ref_pat_yn = "";
						if(rsNurs1 != null)	rsNurs1.close();
						if (stmt!=null) stmt.close();
					}*/
					if(admit_ref_pat_yn.equals("N")) 
					{
						result		=	false;
						continueyn	=	false;
						out.print("<script>alert(getMessage('ADMIT_PAT_NOT_ALLOWED_NURS','IP'));parent.create();</script>");
					}
					else
					{

						out.println("<script>parent.frames[1].frames[2].document.forms[0].continue_as_mlc_yn.value='"+continue_as_mlc_yn+"';if (parent.frames[1].frames[2].document.getElementById('reftab').rows(0)) {parent.frames[1].frames[2].document.getElementById('reftab').deleteRow(0);parent.frames[1].frames[2].document.getElementById('reftab').deleteRow(0);}parent.frames[1].frames[2].document.getElementById('reftab').insertRow(0);parent.frames[1].frames[2].document.getElementById('reftab').insertRow(1);parent.frames[1].frames[2].document.getElementById('reftab').rows(0).insertCell();parent.frames[1].frames[2].document.getElementById('reftab').rows(0).cells(0).className='HEADFORREF';parent.frames[1].frames[2].document.getElementById('reftab').rows(0).cells(0).insertAdjacentHTML('afterbegin','Referral Details'); parent.frames[1].frames[2].document.getElementById('reftab').rows(1).insertCell();parent.frames[1].frames[2].document.getElementById('reftab').rows(1).cells(0).className='REFDATA';parent.frames[1].frames[2].document.getElementById('reftab').rows(1).cells(0).insertAdjacentHTML('AfterBegin',\"<b>"+referral_dtls+"\");</script>");

						/*stmt = con.createStatement();
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("select substr(get_referral_detail_line('"+referralid+"','FROM','"+locale+"'),3) from dual");
						rset = stmt.executeQuery(sql.toString());	
						if (rset.next())
						{
							out.println("<script>if (parent.frames[1].frames[2].document.getElementById('reftab').rows(0)) {parent.frames[1].frames[2].document.getElementById('reftab').deleteRow(0);parent.frames[1].frames[2].document.getElementById('reftab').deleteRow(0);}parent.frames[1].frames[2].document.getElementById('reftab').insertRow(0);parent.frames[1].frames[2].document.getElementById('reftab').insertRow(1);parent.frames[1].frames[2].document.getElementById('reftab').rows(0).insertCell();parent.frames[1].frames[2].document.getElementById('reftab').rows(0).cells(0).className='HEADFORREF';parent.frames[1].frames[2].document.getElementById('reftab').rows(0).cells(0).insertAdjacentHTML('afterbegin','Referral Details'); parent.frames[1].frames[2].document.getElementById('reftab').rows(1).insertCell();parent.frames[1].frames[2].document.getElementById('reftab').rows(1).cells(0).className='REFDATA';parent.frames[1].frames[2].document.getElementById('reftab').rows(1).cells(0).insertAdjacentHTML('AfterBegin',\"<b>"+rset.getString(1)+"\");</script>");
						}
						if (rset!=null) rset.close();					
						if (stmt!=null) stmt.close();*/
						//Need to be make as Common Lookup by 7/21/2004
						if(!nursingunit.equals(""))
						{
							String addlservice = "";
							if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append("Select ancillary_yn from AM_SERVICE where service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingunit+"')");

							stmt	=	con.createStatement();
							rset	=	stmt.executeQuery(sql.toString());
							if(rset != null && rset.next())
							{
								ancillaryyn	=	checkForNull(rset.getString("ancillary_yn"),"N");
								out.println("<script>if(parent.frames[1].frames[2].document.AdmitPatient_form)parent.frames[1].frames[2].document.AdmitPatient_form.ancillary_yn.value=\""+ancillaryyn+"\";</script>");
							}
							if (rset!=null) rset.close();					
							if (stmt!=null) stmt.close();
							//Adding Services.	
						
            _bw.write(_wl_block32Bytes, _wl_block32);

							if(sql.length() > 0) sql.delete(0,sql.length());				
							sql.append(" select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE_VW where facility_id = '"+facilityId+"' and appl_patient_class = '"+patientclass+"' and nursing_unit_code = '"+nursingunit+"' union select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where facility_id = '"+facilityId+"' and EFF_STATUS = 'E' and nursing_unit_code = '"+nursingunit+"' order by 2 ");

							stmt = con.createStatement();
							rset = stmt.executeQuery(sql.toString());		
							if(rset != null)
							{
								while(rset.next())
								{
									addlservice			=	checkForNull(rset.getString("service_code"));
									servicedesc			=	checkForNull(rset.getString("service_short_desc"));
									out.println("<script>var opt=parent.frames[1].frames[2].document.createElement('Option');\nopt.text=\""+servicedesc+"\"; opt.value=\""+addlservice+"\";if('"+to_service_code+"'== '"+addlservice+"') opt.selected = true;\nobj.add(opt);parent.frames[1].frames[2].document.createElement('Option')</script>") ;
								}
							}
							if (rset!=null) rset.close();					
							if (stmt!=null) stmt.close();
							out.println("<script>PopulateSubService('G');</script>");
						}
						else
						{		 
							
            _bw.write(_wl_block33Bytes, _wl_block33);

						}
						
						String pat_class_dum = ""; // Added by mujafar for ML-MMOH-SCF-1293 and ML-BRU-SCF-1963
						if(admission_for.equals("I")) pat_class_dum="IP";
						else if (admission_for.equals("D")) pat_class_dum="DC";
						if(!pat_class_dum.equals(patientclass) && !nursingunit.equals(""))
						{
						
						
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block41Bytes, _wl_block41);

						}
						else{
						
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nursingunit));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_nursing_unit_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block46Bytes, _wl_block46);

						}
					}
				} // End of Continue yn
		
			}  // End of Referral ID
			// Included by arul for checking the active booking referrence.
			/*Friday, July 17, 2009 PMG20089-CRF-0669 IN012028 patient validation called before booking and referral check*/
			if(continueyn == true)
			{  
			  if((!patientid.equals("")) || (!patient.equals("")))
				{
					session.putValue("queryString", queryString);
					result = false;
					if(!patient.equals("")) patientid = patient;

					String In_patient_status =  patdata.CheckInPatient(con,patientid,facilityId);
					 
					 
					if (In_patient_status.equals("CURRENTLY_IN_PATIENT"))
					{
						continueyn	=	false;
						
						out.print("<script>alert(getMessage('CURRENTLY_IN_PATIENT','IP'));parent.frames[1].frames[0].proceedFurther=true;</script>");
						
						out.println("<script>if(parent.frames[1].frames[0].document.Select_form.call_func.value=='PATREG')parent.window.close();</script>");

						RELOAD = true;
					 
					  /*Below line Added for this CRF Bru-HIMS-CRF-261*/ 
					}else if((quick_admin_yn.equals("Y")&&quickadmchk.equals("1")) || (quick_admin_yn.equals("Y")&&quickadmchk.equals("2")) || (quick_admin_yn.equals("Y")&&quickadmchk.equals("3"))|| (quick_admin_yn.equals("Y")&&quickadmchk.equals("4"))|| (quick_admin_yn.equals("Y")&&quickadmchk.equals("5")))
					{ 			
						continueyn	=	false;
						
						out.print("<script>alert(getMessage('OPR_STATION_NOT_DEFINED','IP'));parent.frames[1].frames[0].proceedFurther=true;</script>");
						
						out.println("<script>if(parent.frames[1].frames[0].document.Select_form.call_func.value=='PATREG')parent.window.close();</script>");

						RELOAD = true;
					 	 
						 /*Above line Added for this CRF Bru-HIMS-CRF-261*/ 
						
					}else if (In_patient_status.equals("CURRENTLY_NOT_IN_PATIENT"))
					{
						String chkst=patdata.CheckStatus(con,patientid);
                          
						    
						if(chkst.equals("DECEASED")) 
						{
							continueyn = false;
							out.print("<script>alert(getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));parent.frames[1].frames[0].proceedFurther=true;</script>");
							out.println("<script>if(parent.frames[1].frames[0].document.Select_form.called_from.value=='NEWBORN_REG');parent.window.close();</script>");
							RELOAD = true;

						}
						else if(chkst.equals("SUSPENDED"))
						{
							continueyn = false;
							out.print("<script>alert(getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));parent.frames[1].frames[0].proceedFurther=true;</script>");
							RELOAD = true;
						}
						else if(chkst.equals("INACTIVE")) 
						{
							continueyn = false;
							out.print("<script>alert(getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));parent.frames[1].frames[0].proceedFurther=true;</script>");
							RELOAD = true;
						}
						else if(chkst.equals("INVALID_PATIENT")) 
						{
							/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] Start*/
							
							String chkPatDispArch=patdata.checkPatientDisposeArchive(con,patientid);
							if(chkPatDispArch.equals("D")){
							continueyn = false;
							
            _bw.write(_wl_block47Bytes, _wl_block47);
} else if(chkPatDispArch.equals("I")){
								continueyn = false;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
							/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] End*/
								continueyn = false;
							RELOAD = true;
								out.print("<script>alert(getMessage('INVALID_PATIENT','MP'));parent.frames[1].frames[0].proceedFurther=true;</script>");
							out.println("<script>if(parent.frames[1].frames[0].document.Select_form.call_func.value=='PATREG')parent.window.close();</script>");
							}//Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857]
						}
						else if(chkst.equals("BLACKLISTED_PATIENT")) 
						{
							
							continueyn = false;
							out.print("<script>alert(getMessage('BLACKLISTED_PATIENT','MP'));parent.frames[1].frames[0].proceedFurther=true;</script>");
							RELOAD = true;
						}
						else if (chkst.indexOf("PATIENT_MERGED_VALID")>=0 )
						{
							
							StringTokenizer token=new StringTokenizer(chkst,"$");
							String valid_patient_id = token.nextToken();
							valid_patient_id = token.nextToken();
							patientid=valid_patient_id;			 // - Modified by Shanthi on 6-3-2012 for the incident IN031529 SKR-SCF-0420		
							continueyn = true;
							
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
		
						}else if (chkst.equals("") || chkst.equals(null))
						{  
				/*Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] */
						String dischr_date_time="";
						String nursing_shor_desc="";
						String currentDate_time="";
						String last_admit_date="";
						String chk_for_readmission="";
						String pat_id="";
                        
						/*Below line(s) was added by venkatesh.S (4008) on 07/11/2012 against  Bru-HIMS-CRF-155 [IN36099]*/
					
						 if(!referralid.equals("")){ pat_id=patientid;}
						 else{ pat_id=patient;}
						
						/*end 36099 */
						 
						String query="SELECT TO_CHAR (discharge_date_time, 'DD/MM/YYYY HH24:MI:SS')discharge_date_time,TO_CHAR (VISIT_ADM_DATE_TIME, 'DD/MM/YYYY HH24:MI:SS')VISIT_ADM_DATE_TIME,TO_CHAR (sysdate,'DD/MM/YYYY HH24:MI:SS') crrent_date,ip_get_desc.ip_nursing_unit (facility_id, assign_care_locn_code, '"+locale+"', 2) nursing_unit,( SELECT MAX_HRS_FOR_RE_ADMN FROM IP_PARAM WHERE FACILITY_ID='"+facilityId+"')READMISSION FROM pr_encounter  WHERE discharge_date_time = (SELECT MAX (discharge_date_time) AS discharge_date_time  FROM pr_encounter  WHERE patient_id = '"+pat_id+"'  AND patient_class IN ('IP')  AND discharge_date_time IS NOT NULL AND facility_id = '"+facilityId+"' AND adt_status = '08')  AND patient_class IN ('IP') AND discharge_date_time IS NOT NULL  AND facility_id = '"+facilityId+"' AND adt_status = '08'";
						
						stmt	=	con.createStatement();
					    rset	=	stmt.executeQuery(query.toString());
						
					    if(rset.next()){
						     dischr_date_time=rset.getString("DISCHARGE_DATE_TIME");
							 last_admit_date =rset.getString("VISIT_ADM_DATE_TIME");
							 currentDate_time =rset.getString("CRRENT_DATE");
							 nursing_shor_desc= rset.getString("NURSING_UNIT");
							 chk_for_readmission=rset.getString("READMISSION");
							if(chk_for_readmission == null) 
			                  chk_for_readmission            ="";
							
							 }
							
							if (rset!=null) rset.close();					
							if (stmt!=null) stmt.close();
						
						
						 if( !dischr_date_time.equals("") && !chk_for_readmission.equals("")){
						 
						 /*Below line was added by venkatesh.S on 26/Nov/2012 against 36466*/
						 int chk_period_admit=Integer.parseInt(chk_for_readmission);
						 chk_period_admit=chk_period_admit*60;
					    java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyy HH:mm:ss"); 
						java.util.Date currentdate =new java.util.Date();
		                 java.util.Date dischargedate  =new java.util.Date();
						 currentdate = format.parse(currentDate_time);
		                 dischargedate =format.parse(dischr_date_time); 
						 diff=(currentdate.getTime()-dischargedate.getTime())/60000;
						 	 /* end 36466*/
						 if( chk_period_admit >= diff  && !chk_for_readmission.equals("")){ 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nursing_shor_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(last_admit_date));
            _bw.write(_wl_block55Bytes, _wl_block55);
}
						 
						 /* end Bru-HIMS-CRF-155 [IN030274]  */
						 }} 
						//else  // - Commented by Shanthi on 6-3-2012 for the incident IN031529 SKR-SCF-0420

						//{
						/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
						if(isNationalIdValidationAppl && continueyn)
						{
							JSONObject valJSONObj	= new JSONObject();
							valJSONObj				= eMP.MPCommonBean.getNationalIdValidationYN(con, patientid, facilityId, "IP");
							String validate_yn		= (String)valJSONObj.get("validate_yn");
							String national_id		= (String)valJSONObj.get("national_id");
							String chk_citizen_yn	= (String)valJSONObj.get("citizen_yn");

							if(validate_yn.equals("Y") && national_id.equals("") && chk_citizen_yn.equals("Y"))
							{
							
            _bw.write(_wl_block56Bytes, _wl_block56);

								continueyn = false;
							
            _bw.write(_wl_block57Bytes, _wl_block57);

							}else
							{
								continueyn = true;
							}
						}
						/*End MO-CRF-20148*/

						// added by mujafar for AMRI-CRF-0357 START
						if(isUHID_valid_appl.equals("true")  && continueyn && bl_install_yn.equals("Y"))
						{
							String UHIDValidCount = "0";
							String UHIDValidCount_tmp = "";
							String pat_ser_grp_code = "";
							
							try{	
						 UHIDValidCount_tmp	= eMP.MPCommonBean.getUHIDValidCount(con,patientid,facilityId);
						String arr_temp[] = UHIDValidCount_tmp.split("~~");
						UHIDValidCount = arr_temp[0];
						if(arr_temp.length>1)
							pat_ser_grp_code = arr_temp[1];
						if(UHIDValidCount.equals("0"))
						{
							
							
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(pat_ser_grp_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block61Bytes, _wl_block61);
continueyn = false;
            _bw.write(_wl_block62Bytes, _wl_block62);
continueyn = false;
            _bw.write(_wl_block63Bytes, _wl_block63);

						
						}
						else
						{
							
							continueyn = true;
						}
						
						
							
							}
							catch(Exception e1) {
										e1.printStackTrace();
								 } 
							
							
							
						}
						
							
						// added by mujafar for AMRI-CRF-0357 END

						/*Added by Dharma on 25th Apr against MMS-DM-CRF-0152.1 [IN:070226] Start*/ 
								String errMsg					= "";
								/*Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022  isNatIdAltIdMandVisaType*/
								if((isInvokeChngPatDtls || isNatIdAltIdMandVisaType ) && continueyn){

									JSONObject patDtlsObj	= new JSONObject();
									patDtlsObj						= eMP.MPCommonBean.chkNatIDAltIDAvail(con, patientid,locale);
									String natId					= (String)patDtlsObj.get("national_id_no");
									String natIddft				    = (String)patDtlsObj.get("national_id_no_dft");//Maheshwaran added AAKH-CRF-0168 as on 19-11-2022
									String altId1					= (String)patDtlsObj.get("alt_id1_no");
									String altId2					= (String)patDtlsObj.get("alt_id2_no");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
									String pat_dtls_unknown_yn		= (String)patDtlsObj.get("pat_dtls_unknown_yn");
									String citizen_yn				= (String)patDtlsObj.get("citizen_yn");
									String visa_type				= (String)patDtlsObj.get("visa_type");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
									String altId1Desc				= (String)patDtlsObj.get("alt_id1_type_desc");
									String altId2Desc				= (String)patDtlsObj.get("alt_id2_type_desc");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
									String natIdPrompt				= (String)patDtlsObj.get("nat_id_prompt");
									String showAlert				= (String)patDtlsObj.get("showAlert");
									//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
									JSONObject MPParamJSONObj1 = new JSONObject();
									MPParamJSONObj1 = eMP.MPCommonBean.getMPAuditTrailDetails(con);
									String dft_national_id = (String)MPParamJSONObj1.get("dft_national_id");//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
									if(visa_type.equals(""))
									visa_type="W";
									if(pat_dtls_unknown_yn.equals("N") && showAlert.equals("Y")){
									if(isInvokeChngPatDtls)
										{
										if(citizen_yn.equals("Y") && natId.equals("")){
											errMsg	= natIdPrompt;
										}else if(citizen_yn.equals("N") && altId1.equals("")  ){
											errMsg	= altId1Desc;
										}
										}
									//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022	
									if(isNatIdAltIdMandVisaType)	
										{
											if((citizen_yn.equals("Y") && !dft_national_id.equals("")) || (citizen_yn.equals("N") &&  !dft_national_id.equals("") && (visa_type.equals("") || visa_type.equals("W"))))
												{
												//National ID null	
												if(natId.equals("")  )
													{						
													if(!altId1.equals("") && !altId2.equals("") && !dft_national_id.equals(natIddft))		
														{
														errMsg	= natIdPrompt;									
														}
													if(altId1.equals("") && !altId2.equals("") && !dft_national_id.equals(natIddft))		
														{
														errMsg	= natIdPrompt+"/"+altId1Desc;								
														}	
													if(!altId1.equals("") && (altId2.equals("") && !dft_national_id.equals(natIddft)))	
														{
														errMsg	= natIdPrompt+"/"+altId2Desc;									
														}	
												
													}
												//Alt ID1 null		
												if(altId1.equals(""))
													{						
													if(!natId.equals("") && !altId2.equals(""))	
														{
														errMsg	= altId1Desc;									
														}
													if(natId.equals("") && !altId2.equals(""))	
														{
														errMsg	= natIdPrompt+"/"+altId1Desc;								
														}	
													if(!natId.equals("") && (altId2.equals("") && dft_national_id.equals(natId)))	
														{
														errMsg	= altId1Desc+"/"+altId2Desc;		
														}	
													}

												//Alt ID2 null		
												if(altId2.equals("") )
													{						
													if(!natId.equals("") && !altId1.equals("") && dft_national_id.equals(natIddft))	
														{
														errMsg	= altId2Desc;									
														}
													if(natId.equals("") && natIddft.equals("")  && !altId1.equals("") && dft_national_id.equals(natIddft))	
														{
														errMsg	= natIdPrompt+"/"+altId2Desc;								
														}	
													if(natId.equals("") && !natIddft.equals("")  && !altId1.equals("") && dft_national_id.equals(natIddft))	
														{
														errMsg	= altId2Desc;								
														}	
													if(natId.equals("") && !altId1.equals("") && !dft_national_id.equals(natIddft))	
														{
														errMsg	= natIdPrompt;								
														}	
													if(natId.equals("") && altId1.equals("") && !dft_national_id.equals(natIddft))	
														{
														errMsg	= natIdPrompt+"/"+altId1Desc;								
														}	
													if(!natId.equals("") && altId1.equals("") && dft_national_id.equals(natIddft))		
														{
														errMsg	= altId1Desc+"/"+altId2Desc;									
														}
													if(!natId.equals("") && altId1.equals("") && !dft_national_id.equals(natIddft))		
														{
														errMsg	= altId1Desc;									
														}
													if(natId.equals("")  && natIddft.equals("")   && altId1.equals("") && dft_national_id.equals(natIddft))	
														{
														errMsg	= natIdPrompt+"/"+altId1Desc+"/"+altId2Desc;									
														}	
													if(natId.equals("")  && !natIddft.equals("")   && altId1.equals("") && dft_national_id.equals(natIddft))	
														{
														errMsg	= altId1Desc+"/"+altId2Desc;									
														}		
													}

												}
											else if(citizen_yn.equals("N"))
												{
												if(visa_type.equals("V"))
													{
													if(altId1.equals("") && !altId2.equals(""))
														{
														errMsg	= altId1Desc;	
														}	
													if(!altId1.equals("") && altId2.equals(""))
														{
														errMsg	= altId2Desc;	
														}		
													if(altId1.equals("") && altId2.equals(""))
														{
														errMsg	= altId1Desc+"/"+altId2Desc;		
														}
																						
													}														
												} 	
											
											}

										if(!errMsg.equals("")){
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(errMsg));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block67Bytes, _wl_block67);

											continueyn = false;
										}
									}
								}

							/*Added by Dharma on 25th Apr against MMS-DM-CRF-0152.1 [IN:070226] End*/ 
							
							/*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
							if(isCountryRegionValAppl && continueyn){

								JSONObject SMSiteJSONObj = new JSONObject();
								SMSiteJSONObj = eSM.SMCommonBean.getSMSiteParamDetails(con);
								String region_prompt = (String)SMSiteJSONObj.get("region_prompt");

								JSONObject MPParamJSONObj = new JSONObject();
								MPParamJSONObj = eMP.MPCommonBean.getMPAuditTrailDetails(con);
								String country_reqd_yn = (String)MPParamJSONObj.get("country_reqd_yn");
								String region_reqd_yn = (String)MPParamJSONObj.get("region_reqd_yn");

								JSONObject PatAddrJSONObj = new JSONObject();
								PatAddrJSONObj = eMP.MPCommonBean.getMPPatContactDetails(con,patientid);
								String country_code = (String)PatAddrJSONObj.get("country_code");	
								String region_code = (String)PatAddrJSONObj.get("region_code");

								String dispMsg = "";

								if(country_code.equals("") || region_code.equals(""))
								{
									if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("N") && country_code.equals(""))
									{
										dispMsg = "Y";
            _bw.write(_wl_block68Bytes, _wl_block68);
}
									else if(country_reqd_yn.equals("N") && region_reqd_yn.equals("Y") && region_code.equals(""))
									{
										dispMsg = "Y";
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block70Bytes, _wl_block70);
}
									else if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("Y"))
									{
										if(country_code.equals("") && region_code.equals(""))
										{
											dispMsg = "Y";
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block72Bytes, _wl_block72);
}
										else if(country_code.equals("") && !region_code.equals(""))
										{
											dispMsg = "Y";
            _bw.write(_wl_block73Bytes, _wl_block73);
}
										else if(!country_code.equals("") && region_code.equals(""))
										{
											dispMsg = "Y";
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block75Bytes, _wl_block75);
}
									}else
									{
										dispMsg = "";
									}
								}

								if(!dispMsg.equals("")){
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block78Bytes, _wl_block78);

									continueyn = false;
								}
							}
							/*End AAKH-CRF-0128.1*/

							/*Added By Dharma on 15th May 2020 against KDAH-CRF-0522.1 End*/
							String strMPParamMandFlds	= "";
							if(isChkMPParamMandFlds && continueyn) {
							strMPParamMandFlds				= eMP.MPCommonBean.chkMPMandFieldsForEncCreation(con, patientid, locale);
							if(!strMPParamMandFlds.equals("Y")){
								errMsg	= strMPParamMandFlds;
							}
							
							if(!errMsg.equals("")) {
							
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(errMsg));
            _bw.write(_wl_block80Bytes, _wl_block80);

								continueyn = false;
							
            _bw.write(_wl_block81Bytes, _wl_block81);

							}else{
								continueyn = true;
							}
						}
						/*Added By Dharma on 15th May 2020 against KDAH-CRF-0522.1 End*/
						
						
							int count = 0;
							int enc_cnt = 0;
							/* Added By Dharma for Non-Citizen Validation on 27th Dec 2013 Start*/
							
							
							String chk_pr_enc_ref_man	= checkForNull(request.getParameter("chk_pr_enc_ref_man"));
							String chk_referralid		= (request.getParameter("field5")==null || request.getParameter("field5")=="")?"":request.getParameter("field5");
							String chk_booking_patient_id	= checkForNull(request.getParameter("field2"));
							if(chk_pr_enc_ref_man.equals("Y") && continueyn && chk_referralid.equals("") && !chk_booking_patient_id.equals("")){
								String chk_booking_ref_no	= checkForNull(request.getParameter("field1"));
															
								
								
								String chk_admission_for	= "";
								String result_pr_enc_ref_man	= "Y";
								
								if(admission_for.equals("I")){
									chk_admission_for	= "IP";
								}else if(admission_for.equals("D")){
									chk_admission_for	= "DC";
								}
								
								if(pstmt != null) pstmt.close();
								if(rs  != null) rs.close();
								
								String PrEncRefManSql =  "select  PR_ENC_REF_MAN(?,?,?,?) from dual";
								pstmt = con.prepareStatement(PrEncRefManSql);
								pstmt.setString(1,facilityId);
								pstmt.setString(2,chk_booking_patient_id);
								pstmt.setString(3,chk_booking_ref_no);
								pstmt.setString(4,chk_admission_for);
								rs = pstmt.executeQuery();
								 try{
									 
									 if(rs!=null && rs.next()){
										 result_pr_enc_ref_man	= rs.getString(1);
									 }
									
									 
								 } catch(Exception e1) {
										e1.printStackTrace();
								 } finally{
									 if(pstmt != null) pstmt.close();
									 if(rs  != null) rs.close();
									}
								
								
								if(result_pr_enc_ref_man.equals("N")){
									continueyn = false;
									out.print("<script>alert(getMessage('PATIENT_IS_NOT_A_CITIZEN','COMMON'));parent.frames[1].frames[0].proceedFurther=true;if(parent.frames[1].frames[0].document.Select_form.called_from.value=='NEWBORN_REG');window.close();</script>");
									RELOAD = true;
								}
							}
							
							/*Added By Dharma for Non-Citizen Validation on 27th Dec 2013 End*/
							
							
						if(continueyn)
						{
							String alt_status = patdata.CheckAlternateId(con,patientid,locale);
							if(!alt_status.equals(""))
							{
							

								char val = alt_status.charAt(0);
								if(val == 'W')
								{
									String msg = alt_status.substring(2,alt_status.length());
								
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(value1));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(value2));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(value3));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(from));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(value5));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block90Bytes, _wl_block90);
	}
								else if(val =='C')
								{			
									String msg = alt_status.substring(1,alt_status.length());
								
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block92Bytes, _wl_block92);
	}
								else 
								{	
									//String msg = alt_status.substring(2,alt_status.length());
								}
							}
						}

					if(continueyn) 						
					{
						//Onblur of patient id will populate all the details from admitpatient.
						if(!contactDetailFlag.equals("from_referral"))
						{
							booking_type = checkForNull(request.getParameter("booking_type"));

							concat_address_hidden=getContactDetails("patient_id",patientid,bookingrefno,request,out,con,facilityId,booking_type,locale);
							String sexandage="";
							StringTokenizer token=new StringTokenizer(concat_address_hidden.toString(),"~");
							while (token.hasMoreTokens()){
								concat_address_hidden=new StringBuffer(token.nextToken());
								sexandage=token.nextToken();
							}
							token=new StringTokenizer(sexandage,"@");
							while (token.hasMoreTokens()){
								gender=token.nextToken();
								age=token.nextToken();
								if(token.hasMoreTokens()){
									bed_assigned_for_nb_yn=token.nextToken();
								}
							}
						}
						out.println("<script>parent.frames[1].frames[2].document.AdmitPatient_form.concat_address_hidden.value=\""+concat_address_hidden.toString()+"\";</script>");
						out.println("<script>parent.frames[1].frames[2].document.AdmitPatient_form.bed_assigned_for_nb_yn.value=\""+bed_assigned_for_nb_yn+"\";</script>");

						out.println("<script>contactDetailsAssign();</script>");					



							if(sql.length() > 0) sql.delete(0,sql.length());

							sql.append("select (select count(*) from IP_NURSING_UNIT_BED where facility_id = '"+facilityId+"' and occupying_patient_id = '"+patientid+"'  and mothers_encounter_id is not null and mothers_patient_id is not null) count, (select count(*) from PR_ENCOUNTER where facility_id = '"+facilityId+"' and patient_id='"+patientid+"') enc_cnt from dual");

							patstmt = con.createStatement();
							patrs	= patstmt.executeQuery(sql.toString());
							if(patrs.next())
							{
								count = patrs.getInt(1);
								enc_cnt = patrs.getInt(2);
							}
							if(patrs != null)patrs.close(); if(patstmt != null) patstmt.close();
							if(count > 0)
							{
								out.print("<script>parent.frames[1].frames[2].document.AdmitPatient_form.baby_flag.value='';</script>");	out.print("<script>if(confirm(getMessage('DELINK_BABY_YN','IP'))){/*parent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit_desc.focus();*/parent.frames[1].frames[2].document.AdmitPatient_form.baby_flag.value='Y';var babyfalgyn='Y';}else{parent.create();parent.frames[1].frames[2].document.AdmitPatient_form.baby_flag.value='N';var babyfalgyn='N';}</script>");	
							}
							else
							{
								out.print("<script>babyfalgyn='';</script>");
							}
						}
							
						if(!continueyn){
							//out.print("<script>if(parent.frames[1].frames[0].document.getElementById("patient_id")!=null)parent.frames[1].frames[0].document.getElementById("patient_id").focus();</script>");
							out.print("<script>async  function finalHold(){ try{ await toHoldShowModal();}catch(err){} if(parent.frames[1].frames[0].document.getElementById(\"patient_id\")!=null){if(parent.frames[1].frames[0].document.getElementById(\"patient_id\").disabled == false){parent.frames[1].frames[0].document.getElementById(\"patient_id\").focus();}}}finalHold();</script>");//Modified By Dharma for Non-Citizen Validation on 27th Dec 2013
						}
						//IP Previous visit validation by Rajan

						if(continueyn)
						{

							if(enc_cnt > 0)
							{
						
            _bw.write(_wl_block93Bytes, _wl_block93);
   
								              
							}
							else
							{
						
            _bw.write(_wl_block94Bytes, _wl_block94);

							}
						}
					}
						
//					} // - Commented by Shanthi on 6-3-2012 for the incident IN031529 SKR-SCF-0420
						String disc_blg_stage = "";
						String p_bill_not_exists = "";
						module_id = "IP";
						calling_function_id = "ADMISSION";
						episode_type = "I";
						String bl_show_remarks_yn = "N";
						long episode_id = 0;
						long visit_id = 0;

						// Below code modifed for PE By Sudhakar & Naren
						if(bl_operational.equals("Y") && continueyn)
						{
							
							pstmt = con.prepareStatement( "SELECT BL_IP_DETAILS.GET_DISCHARGE_BILLING_STAGE(?) discharge_billing_stage, blcommon.BL_SHOW_BLNG_REMARKS_YN(?,?,?,?,?,?,?) bl_show_remarks_yn FROM dual" );

							pstmt.setString(1,facilityId);
							pstmt.setString(2,facilityId);
							pstmt.setString(3,module_id);
							pstmt.setString(4,calling_function_id);
							pstmt.setString(5,patientid);
							pstmt.setString(6,episode_type);
							pstmt.setLong(7,episode_id);
							pstmt.setLong(8,visit_id);

							rsetBL = pstmt.executeQuery();
							
							while(rsetBL.next())
							{
								disc_blg_stage = rsetBL.getString("discharge_billing_stage");
								bl_show_remarks_yn = rsetBL.getString("bl_show_remarks_yn");

								if(disc_blg_stage == null) disc_blg_stage = "";
							}
							if(rsetBL != null)rsetBL.close(); 
							if(pstmt != null) pstmt.close();

							if(disc_blg_stage.equals("2"))
							{									
								 pstmt = con.prepareStatement( "select bl_ip_details.GET_PREV_DISCHARGE_NOT_BILLED(?,?) from dual" );
								 pstmt.setString(1,facilityId);
								 pstmt.setString(2,patientid);
								 rsetBL = pstmt.executeQuery();
								while(rsetBL.next())
								{
									p_bill_not_exists = rsetBL.getString(1);
									if(p_bill_not_exists == null) p_bill_not_exists = "";
								}
								if(rsetBL != null)rsetBL.close(); 
								if(pstmt != null) pstmt.close();

								 if(p_bill_not_exists.equals("Y") && continueyn==true)
								 {
									 if (isPrevDiscgBillNotRaised) { // Added by Lakshmanan on 26-05-2023 for AAKH-CRF-0162 US001
										 continueyn=true;
									 } else {
									out.print("<script>alert(getMessage('BL9313','BL'));parent.frames[1].frames[2].AdmitPatient_form.reset();parent.frames[1].frames[0].proceedFurther=true;parent.frames[1].frames[0].location.reload();parent.frames[1].frames[2].location.reload();parent.frames[1].frames[0].document.forms[0].reset();parent.frames[1].frames[0].document.getElementById('patient_id').value='';if(parent.frames[1].frames[0].document.getElementById('patient_id').enabled == true)parent.frames[1].frames[0].document.getElementById('patient_id').focus();parent.frames[1].frames[3].location.reload();if(parent.frames[1].frames[0].document.Select_form.call_func){if(parent.frames[1].frames[0].document.Select_form.call_func.value=='PATREG')window.close();}</script>");

									continueyn=false;
									 }
								 }
							}//disc_blg_stage
							//Added on 25/10/2004 for billing
							//PreparedStatement pstmt2 = null;
							//ResultSet rs2 = null;
							//String module_id = "IP";
							//String calling_function_id = "ADMISSION";
							//String episode_type = "I";

							if(continueyn){
								/*pstmt2 = con.prepareStatement("Select blcommon.BL_SHOW_BLNG_REMARKS_YN(?,?,?,?,?,?,?) from dual");
								pstmt2.setString(1,facilityId);
								pstmt2.setString(2,module_id);
								pstmt2.setString(3,calling_function_id);
								pstmt2.setString(4,patientid);
								pstmt2.setString(5,episode_type);
								pstmt2.setLong(6,episode_id);
								pstmt2.setLong(7,visit_id);
								rs2 = pstmt2.executeQuery();
								while(rs2.next())
								{
									bl_show_remarks_yn = rs2.getString(1);
								}
								if(rs2 != null)rs2.close(); if(pstmt2 != null) pstmt2.close();*/
								out.println("<input type='hidden' name='module_id' id='module_id' value=\""+module_id+"\">");
								out.println("<input type='hidden' name='calling_function_id' id='calling_function_id' value=\""+calling_function_id+"\">");
								out.println("<input type='hidden' name='episode_type' id='episode_type' value=\""+episode_type+"\" >");
								out.println("<input type='hidden' name='bl_show_remarks_yn' id='bl_show_remarks_yn' value=\""+bl_show_remarks_yn+"\">");
								out.println("<input type='hidden' name='episode_id' id='episode_id' value=\""+episode_id+"\">");
								out.println("<input type='hidden' name='visit_id' id='visit_id' value=\""+visit_id+"\">");
								out.println("<input type='hidden' name='patId' id='patId' value=\""+patientid+"\">");
								if (bl_show_remarks_yn.equalsIgnoreCase("Y") && continueyn == true)
								{
									out.println("<script>showBillingRemarks();</script>");			
								}
							}
							//addition on 25/10/2004 ended here
						}//boolBLInstall
				} // Validate Patient ID ends
			}
			/*Friday, July 17, 2009 PMG20089-CRF-0669 IN012028 continueyn added*/

		if(continueyn)
		{
			booking_type = "";
			if((!(patient.equals("")) && bookingrefno.equals("")) )
			{
				

				if(admission_for.equals("I"))
				{

					
					if(query_booking_ref_no.length() > 0) query_booking_ref_no.delete(0,query_booking_ref_no.length());
					/*6/2/2009 SRR20056-SCF-3054 IN011001*/
					//query_booking_ref_no.append(" select bkg_lst_ref_no from IP_BOOKING_LIST where facility_id = ? and patient_id = ? and booking_status='1' and trunc(preferred_date)>= trunc(sysdate- ?) ");
					query_booking_ref_no.append(" select bkg_lst_ref_no from IP_BOOKING_LIST where facility_id = ? and patient_id = ? and booking_status='1' and trunc(preferred_date)>= trunc(sysdate) ");


                 
					pstmt		=	con.prepareStatement(query_booking_ref_no.toString());
					pstmt.setString	(	1,	facilityId	);
					pstmt.setString	(	2,	patient		);
					//pstmt.setString	(	3,	maxperiodforrevbkg1);
					rset		=	pstmt.executeQuery();
					//if(rset.next())
					while(rset.next())
					{
						bookingrefno	=	rset.getString("bkg_lst_ref_no");
						booking_type	=	"I";
						mult_bkg_cnt++;
					}
					if (rset!=null) rset.close();					
					if (pstmt!=null) pstmt.close();
				}
				else if(admission_for.equals("D"))
				{
					if(query_booking_ref_no.length() > 0) query_booking_ref_no.delete(0,query_booking_ref_no.length());
					query_booking_ref_no.append(" select appt_ref_no from OA_APPT where facility_id = ? and patient_id = ? and  appt_status='1' and appt_date = trunc(sysdate) and care_locn_type_ind = 'D' ");

                   
					pstmt		=	con.prepareStatement(query_booking_ref_no.toString());
					pstmt.setString	(	1,	facilityId	);
					pstmt.setString	(	2,	patient		);
					rset	=	pstmt.executeQuery();
					//if(rset.next())
					while(rset.next())
					{
						bookingrefno	=	rset.getString("appt_ref_no");
						booking_type	=	"D";
						mult_bkg_cnt++;
					}
					if (rset!=null) rset.close();					
					if (pstmt!=null) pstmt.close();
				}

				/*if(mult_bkg_cnt>1)
				{
					out.println("<script>alert(getMessage('MULTI_BOOKING','IP'));callSearchScreenForMultBkgRefNo();</script>");
					return;
				}*//*Thursday, July 14, 2009PMG20089-CRF-0669 IN012028*/
				
			 	//Modified by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
				if(mult_bkg_cnt>0)
				{
					out.println("<script>if(parent.frames[1].frames[0].document.Select_form.booking_ref_no.value == ''){ callSearchScreenForMultBkgRefNo();}</script>");
					return;
				}

					
				
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(booking_type));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(booking_type));
            _bw.write(_wl_block97Bytes, _wl_block97);

			}
			if(!bookingrefno.equals(""))
			{
					
				value1 = bookingrefno;
				if(booking_type.equals(""))
				booking_type=checkForNull(request.getParameter("booking_type"));
				if(booking_type.equals("I"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("SELECT Patient_Id,");
					sql.append("        Specialty_Code,");
					sql.append("        AM_GET_DESC.Am_speciality(Specialty_Code,'"+locale+"','2') Specialty_Short_desc,");
					sql.append("        Practitioner_Id,");
					sql.append("        Chief_Complaint,");
					sql.append("        AM_GET_DESC.Am_complaint(CHIEF_COMPLAINT,'"+locale+"','1') Complaint_desc,");
					sql.append("        To_char(ot_Date_Time,'dd/mm/rrrr hh24:mi') ot_Date_Time,");
					sql.append("        Patient_Type_Code,");
					sql.append("        Bed_Class_Code,");
					sql.append("        IP_GET_DESC.Ip_bed_class(Bed_Class_Code,'"+locale+"','2') Bed_Class_Short_desc,");
					sql.append("        Bed_Type_Code,");
					sql.append("        IP_GET_DESC.Ip_bed_type(Bed_Type_Code,'"+locale+"','2') Bed_Type_Short_desc,");
					sql.append("        nurSing_Unit_Code,");
					sql.append("        IP_GET_DESC.Ip_nursing_unit(FACILITY_ID,NURSING_UNIT_CODE,'"+locale+"',");
					sql.append("                                    '2') nurSing_Unit_Short_desc,");
					sql.append("        Room_No,");
					sql.append("        Bed_No,");
					sql.append("        BookIng_Status,");
					sql.append("        NULL dly_Charge,");
					sql.append("        AM_GET_DESC.Am_service(Service_Code,'"+locale+"','2') Service_Short_desc,");
					sql.append("        Referral_Id,");
					sql.append("        exp_Days_Of_Stay,");
					sql.append("        To_char((To_date('"+visit_adm_date_time+"','dd/mm/rrrr hh24:mi') + exp_Days_Of_Stay),");
					sql.append("                'dd/mm/rrrr hh24:mi') exp_Discharge_Date,");
					sql.append("        AM_GET_DESC.Am_practitioner(PRACTITIONER_ID,'"+locale+"','1') Practitioner_Name,");
					sql.append("        Service_Code,");
					sql.append("        Team_Id,");
					sql.append("        Patient_Class_Code");
					sql.append("        ,translate(diagnosis_remarks,' '||chr(10)||chr(13),' ') diagnosis_remarks");//Added by Kamatchi S for ML-MMOH-SCF-2002 ON 25 MAR 2022
					sql.append(" FROM   IP_BOOKING_LIST");
					sql.append(" WHERE  ");
					sql.append("        Facility_Id = '"+facilityId+"'");
					sql.append("        AND bkg_lst_ref_No = '" +bookingrefno+"'");
					sql.append("        AND Trunc(PreferRed_Date) >= Trunc(SYSDATE - '"+maxperiodforrevbkg1+"' )");
					sql.append("        AND BookIng_Status = 1 ");
				}
				else 
				{
					if(sql.length() > 0) sql.delete(0,sql.length());					
					//user id and operator station 
					/*sql.append("SELECT Patient_Id,");
					sql.append("        Clinic_Code,");
					sql.append("        SpecialIty_Code,");
					sql.append("        AM_GET_DESC.Am_speciality(Specialty_Code,'"+locale+"','2') Specialty_Short_desc,");
					sql.append("        Practitioner_Id,");
					sql.append("        appt_Status,");
					sql.append("        NULL dly_Charge,");
					sql.append("        AM_GET_DESC.Am_service(Service_Code,'"+locale+"','2') Service_Short_desc,");
					sql.append("        Referral_Id,");
					sql.append("        AM_GET_DESC.Am_practitioner(PRACTITIONER_ID,'"+locale+"','1') Practitioner_Name,");
					sql.append("        Service_Code,");
					sql.append("        Team_Id");
					sql.append(" FROM   OA_APPT a");
					sql.append(" WHERE  Facility_Id = '"+facilityId+"'");
					sql.append("        AND appt_ref_No = '" +bookingrefno+"'");
					sql.append("        AND Trunc(appt_Date) = Trunc(SYSDATE)");
					sql.append("        AND Care_Locn_Type_Ind = 'D'");
					sql.append("        AND a.Clinic_Code IN (SELECT Clinic_Code");
					sql.append("                              FROM   IP_DC_UNIT_FOR_NURS_UNIT");
					sql.append("                              WHERE  Facility_Id = '"+facilityId+"'");
					sql.append("                                     AND EXISTS (SELECT b.Locn_Code");
					sql.append("                                                 FROM   AM_OS_USER_LOCN_ACCESS_VW b");
					sql.append("                                                 WHERE  	a.Facility_Id=b.Facility_Id");
					sql.append("										AND a.nurSing_Unit_Code = b.Locn_Code");
					sql.append("										AND a.Locn_Type = b.Locn_Type");
					sql.append("										AND b.Locn_Type = 'N'");
					sql.append("										AND b.Oper_stn_Id = '"+operator_station+"'");
					sql.append("										AND b.apPl_User_Id = '"+loginUser+"'))");
					sql.append("										AND a.Facility_Id = '"+facilityId+"'");*/

					sql.append("SELECT Patient_Id,");
					sql.append("        a.Clinic_Code,");
					sql.append("        SpecialIty_Code,");
					sql.append("        AM_GET_DESC.Am_speciality(SPECIALITY_CODE,'"+locale+"','2') Specialty_Short_desc,");
					sql.append("        Practitioner_Id,");
					sql.append("        appt_Status,");
					sql.append("        NULL dly_Charge,");
					sql.append("        AM_GET_DESC.Am_service(a.Service_Code,'"+locale+"','2') Service_Short_desc,");
					sql.append("        Referral_Id,");
					sql.append("        AM_GET_DESC.Am_practitioner(PRACTITIONER_ID,'"+locale+"','1') Practitioner_Name,");
					sql.append("        a.Service_Code,");
					sql.append("        Team_Id");					
					sql.append(" FROM   OA_APPT a, IP_DC_UNIT_FOR_NURS_UNIT c");
					sql.append(" WHERE  a.Facility_Id = '"+facilityId+"'");
					sql.append("        AND a.appt_ref_No = '" +bookingrefno+"'");
					sql.append("        AND a.Facility_Id= c.Facility_Id AND a.clinic_code=c.clinic_code ");
					sql.append("        AND a.appt_Date = Trunc(SYSDATE)");
					sql.append("        AND a.Care_Locn_Type_Ind = 'D'");
/*					sql.append("        AND a.Clinic_Code IN (SELECT Clinic_Code");
					sql.append("        FROM   IP_DC_UNIT_FOR_NURS_UNIT");
					sql.append("        WHERE  Facility_Id = '"+facilityId+"'");
*/					sql.append("        AND EXISTS (SELECT b.Locn_Code");
					sql.append("		FROM AM_OS_USER_LOCN_ACCESS_VW b");
					sql.append("        WHERE a.Facility_Id=b.Facility_Id");
					//sql.append("		AND a.clinic_Code = b.Locn_Code");    // 22183 commented on 17th jun 
					sql.append("		AND c.nursing_unit_Code = b.Locn_Code");
					//sql.append("		AND a.care_locn_type_ind = b.Locn_Type"); //22183  commented on 17th jun
					sql.append("		AND b.Locn_Type = 'N'"); //22183  un commented on 17th jun
					sql.append("		AND b.Oper_stn_Id = '"+operator_station+"'");
					sql.append("		AND b.apPl_User_Id = '"+loginUser+"')");

				}
				String admit_patient_yn = "";
				stmt	=	con.createStatement();

				rset	=	stmt.executeQuery(sql.toString());
				
				if(rset.next())
				{
					
					if(booking_type.equals("D"))
					{
						bookingstatus	=	checkForNull(rset.getString("appt_status"));
						clinic_code     =   checkForNull(rset.getString("clinic_code"));
						//nursingunitcode	=	checkForNull(rset.getString("nursing_unit_code"));
					}
					else
					{
						bookingstatus	=	checkForNull(rset.getString("booking_status"));
						nursingunitcode	=	checkForNull(rset.getString("nursing_unit_code"));
					}
				 	if(!nursingunitcode.equals(""))
					{
						StringBuffer sqlNurs = new StringBuffer();
						sqlNurs.append("select admit_pat_yn from AM_OS_USER_LOCN_ACCESS_VW where facility_id = '"+facilityId+"' and oper_stn_id ='"+operator_station+"' and APPL_USER_ID = '"+loginUser+"' and locn_type = 'N' and LOCN_CODE = '"+nursingunitcode+"' ");



						stmt	=	con.createStatement();
						ResultSet rsNurs =	stmt.executeQuery(sqlNurs.toString());
						if(rsNurs!= null && rsNurs.next())
							admit_patient_yn = rsNurs.getString(1);
						else
						{
							result		=	false;
							continueyn	=	false;
							out.print("<script>alert(getMessage('USER_RIGHTS_DENIED_FOR_NURS','IP'));parent.create()</script>");
						}
						if(admit_patient_yn == null)	admit_patient_yn = "";
						if(rsNurs != null)	rsNurs.close();
					}	
					 // Ended on 28/04/2003
 					if(bookingstatus.equals("9"))
					{
						result		=	false;
						continueyn	=	false;
						out.print("<script>alert(getMessage('CANCELLED_BOOKING','IP'));</script>");
					}
					else if(bookingstatus.equals("2") || bookingstatus.equals("3")) 
					{
						result		=	false;
						continueyn	=	false;
						out.print("<script>alert(getMessage('ALREAD_USED_FOR_ADM','IP'));</script>");
					}
					else if(admit_patient_yn.equals("N")) 
					{
						result		=	false;
						continueyn	=	false;
						out.print("<script>alert(getMessage('ADMIT_PAT_NOT_ALLOWED_NURS ','IP'));parent.create();</script>");
					}
					else
					{						
						patientid				=	checkForNull(rset.getString("patient_id"));
						if(booking_type.equals("D"))
						specialitycode			=	checkForNull(rset.getString("speciality_code"));
						else
						specialitycode			=	checkForNull(rset.getString("specialty_code"));
						practitionerid			=	checkForNull(rset.getString("practitioner_id"));
						if(!booking_type.equals("D"))
						{
							chiefcomplaint			=	checkForNull(rset.getString("chief_complaint"));
							chiefcomplaint_desc		=	checkForNull(rset.getString("COMPLAINT_DESC"));
							otdatetime				=	checkForNull(rset.getString("ot_date_time"));
							if(!(otdatetime==null || otdatetime.equals("")))
								otdatetime = DateUtils.convertDate(otdatetime,"DMYHM","en",locale); 
							bedclasscode			=	checkForNull(rset.getString("bed_class_code"));
							bedClassDesc			=   checkForNull(rset.getString("bed_class_short_desc"));
							bedtypecode				=   checkForNull(rset.getString("bed_type_code"));
							bedtypedesc				=	checkForNull(rset.getString("bed_type_short_desc"));
							nursingunitcode			=	checkForNull(rset.getString("nursing_unit_code"));
							p_nursing_unit_desc		=	checkForNull(rset.getString("nursing_unit_short_desc"));
							roomno					=	checkForNull(rset.getString("room_no"));
							bedno					=	checkForNull(rset.getString("bed_no"));
							booking_remarks			=	checkForNull(rset.getString("diagnosis_remarks"));
						}

//						nursingunitcode			=	checkForNull(rset.getString("nursing_unit_code"));
//						p_nursing_unit_desc		=	checkForNull(rset.getString("nursing_unit_short_desc"));
						servicecode = checkForNull(rset.getString("service_code"));
						serviceshortdesc		=	checkForNull(rset.getString("service_short_desc"));
						referral_id				=	checkForNull(rset.getString("REFERRAL_ID"));
						if(!booking_type.equals("D"))
						{
							exp_days_of_stay		=	checkForNull(rset.getString("exp_days_of_stay"));
							exp_discharge_date		=	checkForNull(rset.getString("exp_discharge_date"));
							if(!(exp_discharge_date==null || exp_discharge_date.equals("")))
								exp_discharge_date = DateUtils.convertDate(exp_discharge_date,"DMYHM","en",locale); 
						
							patientclass			=	checkForNull(rset.getString("PATIENT_CLASS_CODE"));
						}
						else if(booking_type.equals("D"))
							exp_days_of_stay		= "1";
						practitioner_name		=	checkForNull(rset.getString("practitioner_name"));

						if(booking_type.equals("D"))
						{
							roomno = practitionerid;
							practitioner_name="";
							practitionerid="";
						}

						specialty_short_desc    =   checkForNull(rset.getString("specialty_short_desc"));
						teamid					=	checkForNull(rset.getString("team_id"));
							
						int moreThanOneDayCareUnitFound=1;
						if(rset!=null && rset.next())
						{
							moreThanOneDayCareUnitFound=2;
						}
						if(rset !=null) rset.close(); 
						if(stmt != null) stmt.close();

						if(!patientid.equals("")) 
							disspec = "Y";

						if(blooddonation.equals("Y")) 
						{
							out.println("<script>alert(getMessage('BLOOD_DONATION','IP'))</script>");
						}
						if(!nursingunitcode.equals(""))
						{
							
							String addlservice = "";
							if (servicecode.equals(""))
							{
								if(sql.length() > 0) sql.delete(0,sql.length());
								sql.append("select service_code, short_desc, ancillary_yn from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingunitcode+"')");
							}
							else
							{
								if(sql.length() > 0) sql.delete(0,sql.length());
								sql.append(" Select service_code, short_desc, ancillary_yn  from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and Service_code = '"+servicecode+"'");
							}



							stmt	=	con.createStatement();
							rset	=	stmt.executeQuery(sql.toString());
							if(rset != null && rset.next())
							{
								servicecode		=	checkForNull(rset.getString("service_code"));
								servicedesc		=	checkForNull(rset.getString("short_desc"));
								ancillaryyn		=	checkForNull(rset.getString("ancillary_yn"),"N");
								out.println("<script>if(parent.frames[1].frames[2].document.AdmitPatient_form) parent.frames[1].frames[2].document.AdmitPatient_form.ancillary_yn.value=\""+ancillaryyn+"\";</script>");
							}
							if(rset !=null) rset.close(); 
							if(stmt != null) stmt.close();
							//Adding Services.	
							
            _bw.write(_wl_block98Bytes, _wl_block98);

							if(moreThanOneDayCareUnitFound<2)
							{
								
								if(sql.length() > 0) sql.delete(0,sql.length());
								sql.append("SELECT Service_Code,");
								sql.append("        AM_GET_DESC.Am_service(Service_Code,'"+locale+"','2') Service_Short_desc");
								sql.append(" FROM   IP_NURS_UNIT_FOR_SERVICE_VW");
								sql.append(" WHERE  Facility_Id = '"+facilityId+"'");
								sql.append("        AND apPl_Patient_Class = '"+patientclass+"'");
								sql.append("        AND nurSing_Unit_Code = '"+nursingunitcode+"'");
								sql.append(" UNION ");
								sql.append(" SELECT Service_Code,");
								sql.append("        AM_GET_DESC.Am_service(Service_Code,'"+locale+"','2') Service_Short_desc");
								sql.append(" FROM   IP_NURSING_UNIT");
								sql.append(" WHERE  Facility_Id = '"+facilityId+"'");
								sql.append("        AND nurSing_Unit_Code = '"+nursingunitcode+"'");
								sql.append("        AND EFF_STATUS = 'E'");
								sql.append(" ORDER BY 2");



								stmt = con.createStatement();
								rset = stmt.executeQuery(sql.toString());	
								while (rset.next())
								{
									addlservice			=	checkForNull(rset.getString("service_code"));
									servicedesc			=	checkForNull(rset.getString("service_short_desc"));
									out.println("<script>");
									out.println("var opt=parent.frames[1].frames[2].document.createElement('Option');\nopt.text=\""+servicedesc+"\"; opt.value=\""+addlservice+"\";if(\""+servicecode+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
									out.println("parent.frames[1].frames[2].document.createElement('Option');") ;
									out.println("</script>");
								}

								if(rset !=null) rset.close(); 
								if(stmt != null) stmt.close();
								//out.println("<script>PopulateSubService('G');</script>");
							}
							
						}
						else
						{
							
            _bw.write(_wl_block99Bytes, _wl_block99);

						}

						
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(chiefcomplaint_desc));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(chiefcomplaint));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(otdatetime));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bedno));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(bedtypecode));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(bedtypecode));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bedtypedesc));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bedClassDesc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(exp_days_of_stay));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(exp_discharge_date));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(booking_remarks));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(teamid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bedno));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(ancillaryyn));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(serviceshortdesc));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bedno));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(moreThanOneDayCareUnitFound));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(p_nursing_unit_desc));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(p_nursing_unit_desc));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(bookingrefno));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(bookingrefno));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(booking_type));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(booking_type));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block149Bytes, _wl_block149);

					}
				}
				else if(booking_type.equals("D") || booking_type.equals("I"))
				{
					result		=	false;
					continueyn	=	false;
					out.print("<script>alert(getMessage('INVALID_BOOKING_REF_NO','IP'));</script>");
					out.print("<script>parent.frames[1].frames[0].document.getElementById('validatePat_yn').value='N';parent.frames[1].frames[0].document.getElementById('booking_ref_no').value=\"\";parent.frames[1].frames[0].document.getElementById('patient_id').value=\"\";parent.frames[1].frames[0].document.getElementById('referral_id').value=\"\";parent.frames[1].frames[0].document.getElementById('booking_ref_no').focus();</script>");
				}
			} // Validate Booking ref ends
			if(!encounter.equals(""))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT a.assign_care_locn_code, a.attend_practitioner_id , a.visit_status, a.patient_id ,sign(a.visit_adm_date_time+b.VISIT_REV_CANCEL_DAYS-trunc(sysdate)) eligible_flag FROM pr_encounter A, op_param b WHERE a.facility_id='"+facilityId+"' and a.encounter_id='"+encounter+"' and b.operating_facility_id=a.facility_id ");

				stmt    =	con.createStatement();
				rset    =	stmt.executeQuery(sql.toString());
				if(rset.next())
				{
					visitstatus		=	checkForNull(rset.getString(3));
					flag			=	rset.getInt(5);
					if(visitstatus.equals("99")) 
					{
						continueyn	=	false;
						result		=	false;
						out.print("<script>alert(getMessage('CANCELLED_BOOKING','IP'));</script>");
					}
					else if(flag < 0) 
					{
						continueyn	=	false;
						result		=	false;
						out.print("<script>alert(getMessage('PAST_ENCOUNTER','IP'));");
						out.print("parent.frames[1].frames[0].document.getElementById('encounter_id').value=\"\";parent.frames[1].frames[0].document.getElementById('encounter_id').focus();</script>");
					}
					else
					{
						dissource				=	"Y";

						attendpractitionerid	=	checkForNull(rset.getString(2));    
						patientid				=	checkForNull(rset.getString(4));
						if(patient.equals(""))
						{
						out.print("<script>parent.frames[1].frames[0].document.Select_form.patient_id.value = \""+patientid+"\" ;  </script>");
						}
						else if(!patient.equals(patientid)) 
						{
							continueyn			=	false;
							out.print("<script>alert(getMessage('PAT_ID_ENC_NOT_MATCH','IP'));</script>");
						}
						/*
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" Select short_desc, clinic_code from OP_CLINIC_LANG_VW where facility_id='"+facilityId+"' and clinic_type = 'C' and language_id='"+locale+"' order by 1 ");
				
						stmt	=	con.createStatement();
						rset	=	stmt.executeQuery(sql.toString());
						while(rset.next())
						{
							dat		=	rset.getString("short_desc");
							ID		=	rset.getString("clinic_code");
						}   
							if(rset !=null) rset.close(); 
							if(stmt != null) stmt.close();
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" Select AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name, practitioner_id, AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+locale+"','1') pract_type_desc from AM_PRACT_FOR_FACILITY_VW where operating_facility_id='"+facilityId+"' and eff_status ='E' order by 1 ");
						stmt	=	con.createStatement();
						rset	=	stmt.executeQuery(sql.toString());

						while(rset.next())
						{
							dat			=	rset.getString("practitioner_name");
							ID			=	rset.getString("practitioner_id");
							practtype	=	rset.getString("pract_type_desc");
						*/	
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(attendpractitionerid));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(practtype));
            _bw.write(_wl_block154Bytes, _wl_block154);

					/*	}  
						if(rset !=null) rset.close(); 
						if(stmt != null) stmt.close(); */
					}
				}
				else
				{
					result		=	false;
					continueyn	=	false;
					out.print("<script>alert(getMessage('INVALID_ENCOUNTER_ID','IP'));");
					out.print("parent.frames[1].frames[0].document.getElementById('encounter_id').value=\"\";</script>");
				}
			}	
		}// Validate encounter ID ends
				// Validate patient ID
			/*Friday, July 17, 2009*/

			/*Friday, July 17, 2009*/
			
			out.print("<input type='hidden' name='enablesourceyn' id='enablesourceyn' value=\""+dissource+"\"><input type='hidden' name='enablespeciality' id='enablespeciality' value=\""+disspec+"\">");
			
			
			if(patientid.equals("") && result == true )
			{ 
            _bw.write(_wl_block155Bytes, _wl_block155);
  if(referralid.length()>1)
					{
				
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(referralid));
            _bw.write(_wl_block157Bytes, _wl_block157);
	}
					else
					{	
						
            _bw.write(_wl_block158Bytes, _wl_block158);
	}
			}
			else if(continueyn ==true) 
			{
				/*String	age				=	"";
				String	gender			=	"";	
				StringBuffer sqlGenderAge = new StringBuffer();
				sqlGenderAge.append("select sex, get_age(date_of_birth) age from MP_PATIENT where patient_id = '"+patientid+"' ");
				stmt			=	con.createStatement();
				rset			=	stmt.executeQuery(sqlGenderAge.toString());
				if(rset.next())
				{
					gender		=	checkForNull(rset.getString("sex"));
					age         =	checkForNull(rset.getString("age"));
				}*/
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
				out.print("<script>if(babyfalgyn !='N' ){parent.frames[1].frames[2].document.AdmitPatient_form.gender.value='"+gender+"';parent.frames[1].frames[2].document.AdmitPatient_form.age.value='"+age+"';}</script>");
				out.print("<script>if(babyfalgyn !='N' ){parent.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patientid+"'}</script>");
				out.print("<script>if(babyfalgyn !='N' ){enableDisable();}</script>");
				//out.println("<script>if(babyfalgyn !='N' ){parent.frames[1].frames[0].document.forms[0].patient_id.readOnly='true';}</script>");
				/*Above line comeneted and belwo line added for this SCF MMS-SCF-0105 [IN:043502]*/				
				out.println("<script>if(babyfalgyn !='N' ){parent.frames[1].frames[0].document.forms[0].patient_id.disabled='true';}</script>"); 
				out.println("<script>if(babyfalgyn !='N' ){parent.frames[1].frames[0].document.forms[0].patient_id_search.disabled='true';}</script>");
				out.println("<script>//parent.frames[1].frames[2].document.forms[0].nursing_unit_desc.focus();</script>");
				out.println("<script>//parent.frames[1].frames[2].document.forms[0].bed_no.disabled = false;</script>");
				out.println("<script>if(parent.frames[1].frames[2].document.forms[0].SplDesc.value!='')	parent.frames[1].frames[2].document.forms[0].bed_avail_chart.disabled = false;</script>");				
				//out.println("<script>parent.frames[1].frames[2].document.forms[0].bed_avail_chart.disabled = false;</script>");

				/**********************************************************************************
				* Added by Sridhar R on 3/16/2005
				* The foll code will populate ...
				* MODE OF ARRIVALS && AMBULATORY STATUS && ADMISSION TYPE && BED CLASS Details
				* These are populated only if the patientID or Booking Ref No or Referral ID is valid...
				***********************************************************************************/
				
            _bw.write(_wl_block159Bytes, _wl_block159);
			
				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
				String arrival_short_desc	= "";
				String arrival_code = "";
				//To populate MODE OF ARRIVALS ...
				if(sql.length() > 0) sql.delete(0,sql.length());
				//sql.append(" select arrival_code, short_desc from AM_ARRIVAL_LANG_VW where language_id = '"+locale+"' and eff_status = 'E' and facility_id ='"+facilityId+"' order by short_desc ");
				
				sql.append(" select arrival_code, am_get_desc.AM_ARRIVAL('"+facilityId+"',arrival_code,'"+locale+"',2) short_desc from AM_ARRIVAL where eff_status = 'E' and facility_id ='"+facilityId+"' order by short_desc ");
				stmt = con.createStatement();
				rset = stmt.executeQuery(sql.toString());
				if(rset!=null)
				{
					while(rset.next())
					{
						arrival_short_desc	= rset.getString("short_desc");
						arrival_code = rset.getString("arrival_code");
						
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(arrival_short_desc));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(arrival_code));
            _bw.write(_wl_block162Bytes, _wl_block162);
	
					}// E.O While
				}// E.O if
				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
				
            _bw.write(_wl_block163Bytes, _wl_block163);
			
					String ambulatory_short_desc= "";
					String ambulatory_code		= "";

					// To populate the AMBULATORY STATUS ...
					if(sql.length() > 0) sql.delete(0,sql.length());
					//sql.append(" select ambulatory_status, short_desc from AM_AMBULATORY_STATUS_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ");
					
					sql.append(" select ambulatory_status, am_get_desc.am_ambulatory_status(ambulatory_status,'"+locale+"',2) short_desc from AM_AMBULATORY_STATUS where eff_status='E' order by short_desc ");

					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());

					if(rset!=null)
					{
						while(rset.next())
						{
							ambulatory_short_desc	= rset.getString("short_desc");
							ambulatory_code = rset.getString("ambulatory_status");
					
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(ambulatory_short_desc));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(ambulatory_code));
            _bw.write(_wl_block166Bytes, _wl_block166);
	}// E.O While
					}// E.O if

					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
				
            _bw.write(_wl_block167Bytes, _wl_block167);
			
				    Boolean isAdmissionTypeAppl = CommonBean.isSiteSpecific(con,"IP","ADMISSION_TYPE_APPL");//Added by Shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
					String admission_type	= eIP.IPCommonBean.getAdmissionType(con,facilityId);//Added by shanmukh on 1st-AUG-2018 for ML-MMOH-CRF-0618

					String admission_type_short_desc= "";
					String admission_type_code		= "";
					
					//To populate the ADMISSION TYPE ...
					if(sql.length() > 0) sql.delete(0,sql.length());
					//sql.append(" select admission_type_code, short_desc from IP_ADMISSION_TYPE_LANG_VW where language_id = '"+locale+"' and  eff_status='E' order by short_desc ");
					
					sql.append(" select admission_type_code,ip_get_desc.IP_ADMISSION_TYPE(admission_type_code,'"+locale+"',2) short_desc from IP_ADMISSION_TYPE where  eff_status='E' order by short_desc ");

					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());

					if(rset!=null)
					{
						while(rset.next())
						{
							admission_type_short_desc	= rset.getString("short_desc");
							admission_type_code = rset.getString("admission_type_code");
					
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(admission_type_short_desc));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(admission_type_code));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(admission_type_code));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(visit_admtype));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(isAdmissionTypeAppl));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(admission_type_code));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(admission_type));
            _bw.write(_wl_block174Bytes, _wl_block174);
	}// E.O While
					}// E.O if
					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
				
            _bw.write(_wl_block175Bytes, _wl_block175);
			
					String bed_class_short_desc	= "";
					String bed_class_code		= "";
					// To populate the BED CLASS ...
					if(sql.length() > 0) sql.delete(0,sql.length());
					if(!nursingunitcode.equals(""))
					{
						//sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunitcode+"' AND a.bed_class_code = b.bed_class_code and b.language_id = '"+locale+"' ORDER BY b.short_desc ");
						sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.BED_CLASS_CODE,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E'  and a.nursing_unit_code = '"+nursingunitcode+"'  ORDER BY short_desc ");
					}
					else if(!nursingunit.equals(""))
					{
						//sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunit+"' AND a.bed_class_code = b.bed_class_code and b.language_id = '"+locale+"' ORDER BY b.short_desc ");
						sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.BED_CLASS_CODE,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E'  and a.nursing_unit_code = '"+nursingunit+"'  ORDER BY short_desc");
					}
					//Commented as part of PE By Sudhakar
					/*else
					{
						sql.append(" Select bed_class_code, short_desc from IP_BED_CLASS_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ");
					}*/
					if(!nursingunitcode.equals("") || !nursingunit.equals("")){// This line is added as part of PE By Sudhakar
						stmt = con.createStatement();
						rset = stmt.executeQuery(sql.toString());

						if(rset!=null)
						{
							while(rset.next())
							{
								bed_class_short_desc	= rset.getString("short_desc");
								bed_class_code = rset.getString("bed_class_code");
								
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(bed_class_short_desc));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(booking_type));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(bedclasscode));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(assign_bed_type_code));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(assign_bed_type_code));
            _bw.write(_wl_block184Bytes, _wl_block184);
	
							}// E.O While
						}// E.O if

						if(rset != null) rset.close();
						if(stmt != null) stmt.close();
					}
/*Below code  for the popolate the bedtyp*/

if(!assign_bed_type_code.equals("")&&!nursingunit.equals("")){

String sql1="SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b WHERE b.language_id = '"+locale+"' and a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunit+"' AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = '"+assign_bed_type_code+"' AND a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc";


	stmt = con.createStatement();
	rset = stmt.executeQuery(sql1.toString());

		


		if(rset != null)
		{
			while(rset.next())
			{
				quickbedtypecode = rset.getString("bed_type_code");
				bedtypeshortdesc	= rset.getString("bed_type_short_desc");
              			
				
				
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(bedtypeshortdesc));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(quickbedtypecode));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(quickbedtypecode));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(assign_bed_class_code));
            _bw.write(_wl_block188Bytes, _wl_block188);

			}
	if(rset != null ) rset.close();
	if(stmt != null) stmt.close();
		}
	
   
	}
	
 //End  Bru-HIMS-CRF-261	
 

				
				/********************************************************
				*	End of addition by Sridhar R on 3/16/2005
				********************************************************/
			}
			if(continueyn && !(practitionerid.equals("") || specialitycode.equals(""))){// Code is added for PE By Sudhakar Starts
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select a.short_desc short_desc , a.team_id, b.practitioner_id from 	AM_MEDICAL_TEAM_LANG_VW a, AM_PRACT_FOR_TEAM b where a.language_id='"+locale+"' and  a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id and b.practitioner_id ='"+practitionerid+"' and a.speciality_code = '"+specialitycode+"' and b.team_id=a.team_id and a.appl_for_ip_yn = 'Y' order by 1 ");

	

				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql.toString());
				while(rset.next())
				{
					dat			=	rset.getString("short_desc");
					ID			=	rset.getString("team_id");
					
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(teamid));
            _bw.write(_wl_block192Bytes, _wl_block192);

				}
			}
			if(rset != null)rset.close(); if(stmt != null) stmt.close();
			if(bl_operational.equals("Y")) 
			{	
				String pat	=	(value2.equals(""))? patientid:value2;

				 if(from!=null && from.equals("Select_form") && value1!=null && !value1.equals("")) {



					 
            _bw.write(_wl_block193Bytes, _wl_block193);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(pat
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf(module_id
                        )},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(calling_function_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf(episode_type
                        )},{ weblogic.utils.StringUtils.valueOf("bookingrefno"), weblogic.utils.StringUtils.valueOf(value1
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block155Bytes, _wl_block155);
}	else{

	

								
            _bw.write(_wl_block196Bytes, _wl_block196);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(pat
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf(module_id
                        )},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(calling_function_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf(episode_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block194Bytes, _wl_block194);
}
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(value2));
            _bw.write(_wl_block198Bytes, _wl_block198);

			}
			//End of Billing Interfacing
		}
		else if(from.equals("Main_form"))
		{
			
			String admtype      =	value1;
			String admdate      =	value2;
			String nursingcode  =	value3;
			bedno				=	value5;
			fVal				=	fVal;

			if(!admtype.equals(""))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select patient_class, adm_type_ind, decode(adm_type_ind,'A','Accident','U','Emergency','M','Labor and Delivery','N','Routine','O','Observation','D','Day Surgery') adm_type_ind_desc from IP_ADMISSION_TYPE_LANG_VW where language_id = '"+locale+"' and admission_type_code = '"+admtype+"' and EFF_STATUS = 'E' ");



				stmt		=	con.createStatement();
				rset		=	stmt.executeQuery(sql.toString());
				if(rset != null && rset.next())
				{
					String admtypeind       =	rset.getString("adm_type_ind") == null ? "" : rset.getString("adm_type_ind") ;
					String patclass         =	rset.getString("patient_class") == null ? "" : rset.getString("patient_class");
					out.print("<script>parent.frames[1].frames[2].document.AdmitPatient_form.patient_class.value=\""+patclass+"\";parent.frames[1].frames[2].document.AdmitPatient_form.adm_type_ind.value=\""+admtypeind+"\";</script>");
					//out.print("<script>parent.frames[2].document.AdmitPatient_form.patient_class.value=\""+patclass+"\";parent.frames[2].document.AdmitPatient_form.adm_type_ind.value=\""+admtypeind+"\";</script>");
				}
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
			}

			
			if(!admdate.equals(""))
			{
				String admission_date = admdate;
				admdate		=	admdate.substring(0,admdate.indexOf(" "));
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				if (!expDaysofStay.equals(""))
				{
					sql.append("Select sign((trunc(to_date('"+admdate+"','dd/mm/rrrr')))+ adm_date_chk_days -trunc(sysdate)) valid_flag, to_char(to_date('"+admission_date+"', 'dd/mm/rrrr hh24:mi')+('"+expDaysofStay+"'),'dd/mm/rrrr hh24:mi') exp_dis_charge_date from IP_PARAM where facility_id='"+facilityId+"' ");
				}
				else
					sql.append("Select sign((trunc(to_date('"+admdate+"','dd/mm/rrrr')))+ adm_date_chk_days -trunc(sysdate)) valid_flag from IP_PARAM where facility_id='"+facilityId+"' ");



				String exp_dis_charge_date = "";
				stmt		=	con.createStatement();
				rset		=	stmt.executeQuery(sql.toString());

				if(rset != null && rset.next())
				{
					flag	=	rset.getInt("valid_flag");
					if (!expDaysofStay.equals(""))
					{
						exp_dis_charge_date = rset.getString("exp_dis_charge_date");

											
						if(!(exp_dis_charge_date==null || exp_dis_charge_date.equals("")))
						{
							exp_dis_charge_date = DateUtils.convertDate(exp_dis_charge_date,"DMYHM","en",locale); 
						}
						/*if(!(admdate==null || admdate.equals("")))
						{
							admdate = admdate.trim();
							admdate = DateUtils.convertDate(admdate,"DMY","en",locale); 
						}
						
						exp_dis_charge_date = admdate + " 23:59";*/
						
					}

					if(flag < 0 ) 
					{	
						out.println("<script>alert(getMessage('ADM_DATE_LT_EXCEEDED','IP'));parent.frames[1].frames[2].document.AdmitPatient_form.visit_adm_date_time.focus();parent.frames[1].frames[2].document.AdmitPatient_form.visit_adm_date_time.value='';</script>");
						//out.println("<script>alert(getMessage('ADM_DATE_LT_EXCEEDED','IP'));parent.frames[2].document.AdmitPatient_form.visit_adm_date_time.focus();parent.frames[2].document.AdmitPatient_form.visit_adm_date_time.value='';</script>");
					}
					else												
					{
						
						out.print("<script>parent.frames[1].frames[2].document.AdmitPatient_form.expecteddischargedate.value=\""+exp_dis_charge_date+"\";</script>");
						//out.print("<script>parent.frames[2].document.AdmitPatient_form.expecteddischargedate.value=\""+exp_dis_charge_date+"\";</script>");
					}
				}
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
			}
			
			if(!nursingcode.equals(""))
			{

				String addlservice = "";
				if(sql.length() > 0) sql.delete(0,sql.length());
				//sql.append(" Select service_code, short_desc, ancillary_yn from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and Service_code in (select service_code from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingcode+"') order by short_desc ");
				/*Modified for query tuning*/
				sql.append(" Select service_code, am_get_desc.am_service(service_code, '"+locale+"',2)short_desc, ancillary_yn from AM_SERVICE where Service_code in (select service_code from ip_nursing_unit where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingcode+"') order by short_desc ");



				String service_add = checkForNull(request.getParameter("service_add"),"N");
				stmt = con.createStatement();
				rset = stmt.executeQuery(sql.toString());
				if(!service_add.equals("N"))
				{
					if(rset != null && rset.next())
					{
						servicecode			=	checkForNull(rset.getString("service_code"));
						servicedesc			=	checkForNull(rset.getString("short_desc"));
						ancillaryyn			=	checkForNull(rset.getString("ancillary_yn"));
						
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(ancillaryyn));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(ancillaryyn));
            _bw.write(_wl_block203Bytes, _wl_block203);
            _bw.write(_wl_block201Bytes, _wl_block201);
            _bw.write(_wl_block204Bytes, _wl_block204);

					}
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
					//Adding Services.	
					
            _bw.write(_wl_block205Bytes, _wl_block205);

					//patient class is not used.
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursingcode+"' union select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where facility_id = '"+facilityId+"' and EFF_STATUS = 'E' and nursing_unit_code = '"+nursingcode+"' order by 2 ");



					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());	
					if(rset!=null )
					{
						while (rset.next())
						{
							addlservice			=	checkForNull(rset.getString("service_code"));
							servicedesc			=	checkForNull(rset.getString("service_short_desc"));
					
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(addlservice));
            _bw.write(_wl_block208Bytes, _wl_block208);
            _bw.write(_wl_block207Bytes, _wl_block207);
            _bw.write(_wl_block209Bytes, _wl_block209);
	}
					}

					out.println("<script>");
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
					out.println("var frame_ref = \""+frame_ref+"\" ");
					out.println("if(frame_ref == '') frame_ref = 'parent.frames[1].frames[2]';");
					//out.println("if(frame_ref == '') frame_ref = 'parent.frames[2]';");
					out.println("var obj =eval(frame_ref+'.document.forms[0].sub_service');");
					out.println("var length  = obj.length;");
					out.println("for(i=0;i<length;i++) {obj.remove(1);}");
					
					String subservice_code = "", subservice_desc = "";
					StringBuffer sersql = new StringBuffer();
					sersql.append(" Select subservice_code, AM_GET_DESC.AM_SUBSERVICE(service_code,subservice_code,'"+locale+"','2') subservice_short_desc from AM_FACILITY_SUBSRVC where service_code = '"+servicecode+"' and operating_facility_id = '"+facilityId+"' and eff_status = 'E' order by subservice_short_desc ");
					stmt = con.createStatement();
					rset = stmt.executeQuery(sersql.toString());



					if(rset!=null )
					{
						while(rset.next())
						{
							subservice_code  = checkForNull(rset.getString("SUBSERVICE_CODE"));
							subservice_desc = checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
							out.println ("var opt= eval(frame_ref+'.document').createElement('Option');\nopt.text=\""+subservice_desc+"\"; opt.value=\""+subservice_code+"\"; \nobj.add(opt)");
							out.println ("eval(frame_ref+'.document').createElement('Option')") ;
						}
					}
					out.println("</script>");
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}
				String bedcode = "";
				String beddesc = ""; 
				StringBuffer bedcodeSql = new StringBuffer();
				
				
				if(from_adv_bed_mgmt.equals("N")){  				
				
					if(deactivate_pseudo_bed_yn.equals("Y"))
					{
						//bedcodeSql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+nursingcode+"' AND a.bed_class_code = b.bed_class_code AND a.psuedo_bed_status = 'N' and b.language_id = '"+locale+"' ORDER BY b.short_desc ");

						bedcodeSql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.IP_BED_CLASS(a.BED_CLASS_CODE,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+nursingcode+"' AND a.psuedo_bed_status = 'N'  ORDER BY short_desc ");
					}
					else
					{
						//bedcodeSql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+nursingcode+"' AND a.bed_class_code = b.bed_class_code and b.language_id = '"+locale+"' ORDER BY b.short_desc ");

						bedcodeSql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.IP_BED_CLASS(a.BED_CLASS_CODE,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+nursingcode+"' ORDER BY short_desc ");
					}



					stmt = con.createStatement();
					rset = stmt.executeQuery(bedcodeSql.toString());
					if(rset != null)
					{  
					   	out.println("<script>");
						out.println("var frame_ref = \""+frame_ref+"\" ");
						out.println("if(frame_ref == '') frame_ref = 'parent.frames[1].frames[2]';");
						//out.println("if(frame_ref == '') frame_ref = 'parent.frames[2]';");
						out.println("var bedCode = '' ;");
						out.println("var fVal = \""+fVal+"\" ;");
						out.println("if(fVal == 'G') bedCode = parent.frames[2].document.forms[0].Bedcode.value ;");
						out.println("else bedCode = parent.frames[1].frames[2].document.forms[0].Bedcode.value ;");
						out.println("var obj =eval(frame_ref+'.document.forms[0].Bedcode');");
						out.println("var length  = obj.length;");
						out.println("for(i=0;i<length;i++) {obj.remove(1);}");
						while(rset.next())
						{
							bedcode			=	checkForNull(rset.getString("bed_class_code"));
							beddesc			=	checkForNull(rset.getString("short_desc"));
							out.println ("var opt= eval(frame_ref+'.document').createElement('Option');\nopt.text=\""+beddesc+"\"; opt.value=\""+bedcode+"\";if(bedCode == \""+bedcode+"\")\nopt.selected = true; \nobj.add(opt)");
							out.println ("eval(frame_ref+'.document').createElement('Option')") ;
						}
						out.println("</script>");
					}
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}
			}

			if(nursingcode.equals("")&&(Indicator.equals("Blnk_Nursing_Unit")))
			{
				String bedcode = "";
				String beddesc = ""; 
				//String bedcodeSql=" Select bed_class_code, short_desc from IP_BED_CLASS_LANG_VW where eff_status='E' and language_id = '"+locale+"' order by short_desc ";
				
				String bedcodeSql=" Select bed_class_code,ip_get_desc.IP_BED_CLASS(bed_class_code,'"+locale+"',2) short_desc from IP_BED_CLASS where eff_status='E' order by short_desc ";


				
				

				stmt = con.createStatement();
				rset = stmt.executeQuery(bedcodeSql);
				if(rset != null)
				{
					out.println("<script>");
					out.println("var frame_ref = \""+frame_ref+"\" ");
					out.println("if(frame_ref == '') frame_ref = 'parent.frames[1].frames[2]';");
					//out.println("if(frame_ref == '') frame_ref = 'parent.frames[2]';");
					out.println("var obj =eval(frame_ref+'.document.forms[0].Bedcode');");
					out.println("var length  = obj.length;");
					out.println("for(i=0;i<length;i++) {obj.remove(1);}");
					while(rset.next())
					{
						bedcode			=	checkForNull(rset.getString("bed_class_code"));
						beddesc			=	checkForNull(rset.getString("short_desc"));
						out.println ("var opt= eval(frame_ref+'.document').createElement('Option');\nopt.text=\""+beddesc+"\"; opt.value=\""+bedcode+"\"; \nobj.add(opt)");
						out.println ("eval(frame_ref+'.document').createElement('Option')") ;
					}
					out.println("</script>");
				}
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
			}

			if(!bedno.equals("")  && from_adv_bed_mgmt.equals("N"))
			{ 
				if(sql.length()>0) sql.delete(0,sql.length());
				sql.append(" select room_no, bed_type_code, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, bed_class_code, current_status, specialty_code, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') short_desc from IP_NURSING_UNIT_BED where nursing_unit_code = '"+nursingcode+"' and bed_no='"+bedno+"' and facility_id = '"+facilityId+"' and eff_status = 'E'  and main_bed_no is null ");

				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql.toString());
				if(rset != null && rset.next())
				{
					bedtypecode		=	"";
					String bed_class_code	=	"";
					String curr_status		=	"";
					String bed_type_short_desc = "";

					bedtypecode				=	checkForNull(rset.getString("bed_type_code"));
					roomno						=	checkForNull(rset.getString("room_no"));
					bed_class_code			=	checkForNull(rset.getString("bed_class_code"));
					curr_status					=	checkForNull(rset.getString("current_status"));
					bed_type_short_desc	=   checkForNull(rset.getString("bed_type_short_desc"));
					
					if(curr_status.equals("O"))	
					{
					
						out.print("<script>alert(getMessage('OCCUPIED_BED','IP'));var frame_ref = \""+frame_ref+"\";eval(frame_ref+'.document.AdmitPatient_form.bed_no').value='';eval(frame_ref+'.document.AdmitPatient_form.room_no').value='';eval(frame_ref+'.document.AdmitPatient_form.attend_img').style.visibility='hidden';</script>");
						//out.print("<script>alert(getMessage('OCCUPIED_BED','IP'));parent.frames[2].document.AdmitPatient_form.bed_no.value='';</script>");
					}
					else
					{	
						//out.print("<script>  parent.frames[2].document.AdmitPatient_form.Bedcode.value=\""+bed_class_code+"\";parent.frames[2].document.AdmitPatient_form.room_no.value=\""+roomno+"\" ;var obj = parent.frames[2].document.forms[0].bed_type;for(i=0;i<obj.length;i++){obj.remove(1);}var opt=parent.frames[2].document.createElement('Option');opt.text=\""+bed_type_short_desc+"\";opt.value=\""+bedtypecode+"\";opt.selected=true;obj.add(opt);if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value=='Y')parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility='hidden';if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn=='Y')parent.frames[3].document.getElementById('valuables').disabled = false;</script>"); 

						//Modified by Sangeetha on 25/05/17 for GDOH-CRF-0151
						out.print("<script>var fVal = \""+fVal+"\" ; if (fVal =='G' ){ parent.frames[2].document.AdmitPatient_form.Bedcode.value=\""+bed_class_code+"\";if(restrictPseudoBed && parent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value!='')parent.frames[2].document.AdmitPatient_form.room_no.value=\""+roomno+"\" ;var obj = parent.frames[2].document.forms[0].bed_type;for(i=0;i<obj.length;i++){obj.remove(1);}var opt=parent.frames[2].document.createElement('Option');opt.text=\""+bed_type_short_desc+"\";opt.value=\""+bedtypecode+"\";opt.selected=true;obj.add(opt);if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value=='Y')parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility='hidden';if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn=='Y')parent.frames[3].document.getElementById('valuables').disabled = false;}else{  parent.frames[1].frames[2].document.AdmitPatient_form.Bedcode.value=\""+bed_class_code+"\";if(parent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value!='')parent.frames[1].frames[2].document.AdmitPatient_form.room_no.value=\""+roomno+"\"; var obj = parent.frames[1].frames[2].document.forms[0].bed_type;for(i=0;i<obj.length;i++){obj.remove(1);}var opt=parent.frames[1].frames[2].document.createElement('Option');opt.text=\""+bed_type_short_desc+"\";opt.value=\""+bedtypecode+"\";opt.selected=true;obj.add(opt);if(parent.frames[1].frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value=='Y')parent.frames[1].frames[2].document.AdmitPatient_form.attend_img.style.visibility='hidden';if(parent.frames[1].frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn=='Y')parent.frames[3].document.getElementById('valuables').disabled = false;}</script>"); 
					}
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}
				else
				{ 
					String bkg_type = checkForNull(request.getParameter("bkg_type"));
					out.print("<script>alert(getMessage('INVALID_BED','IP'));/*parent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value='';*/parent.frames[2].document.AdmitPatient_form.bed_no.value='';</script>");
				
					if(!bkg_type.equals("D"))
						out.print("<script>/*parent.frames[1].frames[2].document.AdmitPatient_form.room_no.value='';*/parent.frames[2].document.AdmitPatient_form.room_no.value='';</script>");

					out.print("<script>/*if(parent.frames[1].frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn=='Y'){parent.frames[1].frames[3].document.getElementById('valuables').disabled = true;parent.frames[1].frames[2].document.AdmitPatient_form.attend_img.style.visibility='hidden';}*/if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value=='N'){parent.frames[3].document.getElementById('valuables').disabled = true;parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility='hidden';}</script>");
				}
			}

			if (!servcode.equals("") ||servcode.equals(""))
			{
				if(!servcode.equals(""))
				{
					out.println("<script>");
					out.println("var frame_ref = \""+frame_ref+"\" ");
					out.println("if(frame_ref == '') frame_ref = 'parent.frames[1].frames[2]';");
					//out.println("if(frame_ref == '') frame_ref = 'parent.frames[2]';");
					out.println("var obj =eval(frame_ref+'.document.forms[0].sub_service');");
					out.println("var length  = obj.length;");
					out.println("for(i=0;i<length;i++) {obj.remove(1);}");
				}

				String subservice_code = "", subservice_desc = "";
				StringBuffer serSql = new StringBuffer();

				serSql.append(" select subservice_code, AM_GET_DESC.AM_SUBSERVICE(service_code,subservice_code,'"+locale+"','2') subservice_short_desc from AM_FACILITY_SUBSRVC where service_code = '"+servcode+"' and operating_facility_id = '"+facilityId+"' and eff_status = 'E' order by subservice_short_desc ");



				SubSerStmt = con.createStatement();
				try
				{
				SubSerRset = SubSerStmt.executeQuery(serSql.toString());

				if(SubSerRset != null )
				{
					while(SubSerRset.next())
					{
						subservice_code  = checkForNull(SubSerRset.getString("SUBSERVICE_CODE"));
						subservice_desc = checkForNull(SubSerRset.getString("SUBSERVICE_SHORT_DESC"));

						out.println("var opt= eval(frame_ref+'.document').createElement('Option');");
						out.println("opt.text=\""+subservice_desc+"\";");
						out.println("opt.value=\""+subservice_code+"\"; ");
						out.println("obj.add(opt)");
						out.println ("eval(frame_ref+'.document').createElement('Option')") ;
					}
				}
				out.println("</script>");
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}catch (Exception EXp)
				{
					EXp.printStackTrace();
				}
			}
		}
		else if(from.equals("Service_form"))
		{
						
			// Added by SRIDHAR R On 15 MAY 2004 for Populating Service Values
			// Block called only For Assign Bed Function..
			String nursingcode = value3;
			if(!nursingcode.equals(""))
			{
				String addlservice = "";
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" Select service_code, short_desc, ancillary_yn from AM_SERVICE_LANG_VW where language_id = '"+locale+"' and Service_code in (select service_code from IP_NURSING_UNIT_LANG_VW where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingcode+"' AND language_id = '"+locale+"') ");



				stmt = con.createStatement();
				rset = stmt.executeQuery(sql.toString());

				if(rset != null && rset.next())
				{
					servicecode			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("short_desc"));
					ancillaryyn			=	checkForNull(rset.getString("ancillary_yn"));
					out.print("<script>if(parent.frames[1].document.assign_bed) { parent.frames[1].document.assign_bed.service.value=\""+servicecode+"\";}</script>");					
				}
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
				//Adding Services.	
				out.println("<script>if(parent.frames[1].document.assign_bed){");
				out.println("var obj =parent.frames[1].document.assign_bed.service;");
				out.println("var length  = obj.length;");
				out.println("for(i=0;i<length;i++) {obj.remove(1);}");
				if(sql.length() > 0) sql.delete(0,sql.length());				

				sql.append(" select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursingcode+"' union select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursingcode+"' order by 2 ");



				stmt = con.createStatement();
				rset = stmt.executeQuery(sql.toString());								
				while (rset.next())
				{
					addlservice			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("service_short_desc"));
					out.println (" var opt = parent.frames[1].document.createElement('Option');\nopt.text=\""+servicedesc+"\";opt.value=\""+addlservice+"\";if('"+servicecode+"'== '"+addlservice+"');obj.add(opt);");
					out.println ("parent.frames[1].document.createElement('Option')");
				}
				out.println("}</script>");	
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
			//	END OF ADDITION OF SERVICE
			}
		}			
		else if(value2.trim().length() > 0 && value5.trim().length() == 0 && continueyn)
		{
			
			stmt = con.createStatement();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" Select referral_id from pr_encounter where facility_id = '" + facilityId + "' and patient_class not in ('OP', 'EM') and adt_status != '09' and patient_id = '" + value2 + "' Order by VISIT_ADM_DATE_TIME " );
		
			rset = stmt.executeQuery(sql.toString());
			if(rset.next()) //take value from last row
			{
				financial_detail_ref_id = checkForNull(rset.getString("referral_id"));
				
			}
			if(rset != null)rset.close(); if(stmt != null) stmt.close();
			if(financial_detail_ref_id.trim().length() > 0)
			{
				out.print("<script>	if(parent.frames[1].frames[2].document.AdmitPatient_form.isBlInstalled.value=='true' && parent.frames[1].frames[2].document.AdmitPatient_form.financial_detail_ref_id.value == '')");
				out.print("parent.frames[1].frames[2].document.AdmitPatient_form.financial_detail_ref_id.value=''</script>");	
			}
			
			if(!referralid.equals(""))
			{
				StringBuffer orgTypeSQL = new StringBuffer();
				orgTypeSQL.append(" select b.org_type from PR_REFERRAL_REGISTER a, AM_REFERRAL b where a.referral_id = '"+referralid+"' and a.from_ref_code = b.referral_code ");
		
				stmt = con.createStatement();	 
				rset = stmt.executeQuery(orgTypeSQL.toString()) ;
				if(rset.next()) 
				{
					org_type_data = rset.getString("org_type");
					if(org_type_data == null) org_type_data = "";

					if(org_type_data.equals("P"))  		
						org_type_data="P";
					else
						org_type_data="G";
				}
				else
				{
					org_type_data="G";
				}

				
				if(rset != null)rset.close(); if(stmt != null) stmt.close();	
				if(org_type_data.trim().length() > 0)
				{
				out.print("<script>	if(parent.frames[1].frames[2].document.AdmitPatient_form && parent.frames[1].frames[2].document.AdmitPatient_form.isBlInstalled.value=='true' && parent.frames[1].frames[2].document.AdmitPatient_form.org_type_ind.value == '')");
					out.print("parent.frames[1].frames[2].document.AdmitPatient_form.org_type_ind.value='" + org_type_data + "'</script>");	
				}
			}
		}
		// code added for scrum 2010  10638
		if(!patientid.equals("")&& from.equals("Select_form")&&(continueyn)&&bl_install_yn.equals("Y"))
		{
			
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block211Bytes, _wl_block211);


		}
		// code end  for scrum 2010
          
	  
	   
		if( from.equals("Select_form") && ((!(bookingrefno.equals(""))) || (!(patientid.equals("")))) && (continueyn) )
		{   
			
            _bw.write(_wl_block212Bytes, _wl_block212);

				try{
				if (bl_interface_yn.equals("Y") && bl_install_yn.equals("Y") && regfromquery.equals("Y"))
				  {
					
					BLFunctionalValidation blFunction  = new BLFunctionalValidation();
					Hashtable blData = new Hashtable();
					blData.put("patient",patientid);
					blData.put("facilityid",facilityId);
					blData.put("bl_install_yn",bl_install_yn);
					blData.put("bl_interface_yn",bl_interface_yn);
					Hashtable blResult = blFunction.billPatientService(propertiesBill,con,blData); 
					
					if (blResult != null)
						outst_amt = ((Float)blResult.get("outst_amt")).floatValue();
					else
						outst_amt =0;
				    		
					blFunction = null;
					blData.clear();
					blResult.clear();
					// End of Billing
					outst_amt1 = ""+outst_amt;
					CurrencyFormat cf1 = new CurrencyFormat();
					outst_amt1 = cf1.formatCurrency(outst_amt1, 2);
					reccnt = 1;
					record="Y";	
					String is_auth_win_req="N";
					
					/*
					pstmt = con.prepareStatement("Select blcommon.IS_AUTH_WINDOW_REQUIRED(?,?,?) from dual");
					pstmt.setString(1,facilityId);
					pstmt.setString(2,patientid);
					pstmt.setString(3,admission_for);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						is_auth_win_req = rs.getString(1);
					}
							if(rs != null)rs.close(); if(pstmt != null) pstmt.close();
					*/
					/*5/5/2009 SRR-CRF-0122*/
					
					
						
						
					CallableStatement call = con.prepareCall("{ ? = call  BLCOMMON.IS_AUTH_WINDOW_REQUIRED('"+facilityId+"', '"+patientid+"','"+admission_for+"',?)}");



					call.registerOutParameter(1, java.sql.Types.VARCHAR);
					call.registerOutParameter(2, java.sql.Types.VARCHAR); 
			
					call.execute(); 
					
					is_auth_win_req = call.getString(1);
					 
					if(call!=null)
						call.close();
					/**/
					//if(outst_amt > 0)
					//{


					//Added by Kamatchi S for ML-MMOH-CRF-1609
					if (bl_install_yn.equals("Y")&&(outst_amt > 0)) 
					{
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(outst_amt1));
            _bw.write(_wl_block214Bytes, _wl_block214);
 }

					if(is_auth_win_req.equals("Y") || !gen_remark.equals(""))
					  {
						
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(+outst_amt));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(admission_for));
            _bw.write(_wl_block157Bytes, _wl_block157);
	
					  }
					//}
			   }
				}catch(Exception e){
					e.printStackTrace();
				}
		}
		if( from.equals("Select_form") && (bookingrefno.equals("")&& patientid.equals("")) && (continueyn) )
		{
		
            _bw.write(_wl_block218Bytes, _wl_block218);

		}
		if( ( from.equals("Select_form")  || from.equals("Main_form") || from.equals("AdmitPatient_form") ) && continueyn )
		{
			
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(frame_ref));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(specialitycode));
            _bw.write(_wl_block221Bytes, _wl_block221);

		}
		else
		{
			
            _bw.write(_wl_block222Bytes, _wl_block222);

		}
        if(checkpat.equals("wristband"))
		{
			patientid = checkForNull(request.getParameter("patient_id"));			
			String chkstr=patdata.CheckStatus(con,patientid);
			if(chkstr.equals("INVALID_PATIENT")){
				out.print("<script>alert(getMessage('INVALID_PATIENT','MP'));parent.frames[1].document.forms[0].patient_id.value='';parent.frames[1].document.forms[0].patient_id.focus();parent.frames[1].document.forms[0].encounter_id_but.disabled = true;</script>");	
			}else{
				stmt = con.createStatement();	 
				rset = stmt.executeQuery("SELECT encounter_id,assign_care_locn_type,assign_care_locn_code FROM pr_encounter WHERE facility_id = '"+facilityId+"' AND patient_id = '"+patientid+"'");
				int recCount=0;
				String encounter_id="";
				String locn_type="";
				String locn_code="";
				while(rset!=null && rset.next()){
					encounter_id=rset.getString("encounter_id")==null?"":rset.getString("encounter_id");
					locn_type=rset.getString("assign_care_locn_type")==null?"":rset.getString("assign_care_locn_type");
					locn_code=rset.getString("assign_care_locn_code")==null?"":rset.getString("assign_care_locn_code");
					recCount++;
					if(recCount==2)
						break;
				}
				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();
				if(recCount==1){
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block231Bytes, _wl_block231);
}else{
					out.print("<script>parent.frames[1].document.forms[0].encounter_id.value = '';parent.frames[1].document.forms[0].encounter_id_but.disabled = false;</script>");
				}
			}

        }


		if(rset_nu!=null)		rset_nu.close();
		if(stmt_nu != null)		stmt_nu.close();
		
		if(patrs!=null)			patrs.close();
		if(patstmt!=null)		patstmt.close();

		if(rs!=null)			rs.close();
		if(stmt!=null)			stmt.close();
		if(pstmt!=null)			pstmt.close();

		if(rs_p!=null)			rs_p.close();
		if(stmt1_p!=null)		stmt1_p.close();

		if(rset!=null)			rset.close();
		if(rsetBL!=null)		rsetBL.close();
		if(stmt1!=null)			stmt1.close();

	if(RELOAD)
	{  /*Below line Added for this CRF Bru-HIMS-CRF-261*/
	    out.println("<script> if((parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type&& parent.frames[1].frames[2]. document.AdmitPatient_form.quick_admission_type.value=='Y') && (parent.frames[1].frames[2].document.AdmitPatient_form.quick_adm && parent.frames[1].frames[2].document.AdmitPatient_form.quick_adm.value=='Quick_admission'))window.close();</script>");
	
		out.println("<script>setTimeout('ReloadAll()',1500);</script>");
		//out.println("<script>setTimeout('ReloadAll()',800);</script>");
	}
	if(!RELOAD && quick_admission_type.equals("Y")){/*This condtion Added for this CRF Bru-HIMS-CRF-261*/ // condition modified for 40321
	 out.println("<script> if( (parent.parent.frames[1].frames[2].document.AdmitPatient_form.quick_admission_type&& parent.parent.frames[1].frames[2]. document.AdmitPatient_form.quick_admission_type.value=='Y') && (parent.parent.frames[1].frames[2].document.AdmitPatient_form.quick_adm && parent.parent.frames[1].frames[2].document.AdmitPatient_form.quick_adm.value=='Quick_admission')){if(parent.parent.commontoolbarFrame.document.forms[0].reset){parent.parent.commontoolbarFrame.document.forms[0].reset.disabled = true}if(parent.parent.commontoolbarFrame.document.forms[0].home){parent.parent.commontoolbarFrame.document.forms[0].home.disabled = true}}</script>");
	}
		}else{
            _bw.write(_wl_block232Bytes, _wl_block232);
}

	}catch(Exception e)
	{
		//out.println("First Exception in AdmissionValidation.jsp : "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(referralid));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(quickadmchk));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(assign_bed_type_code));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(assign_bed_type_code));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(assign_bed_class_code));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(assign_bed_class_code));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(visit_admtype));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(visit_admtype));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(quick_admin_yn));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(quick_admin_yn));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(isReferral));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(isCurrentEncounter));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(from));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(assigncare_location_desc));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(assigncareloctype));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(assigncare_location_code));
            _bw.write(_wl_block248Bytes, _wl_block248);
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
