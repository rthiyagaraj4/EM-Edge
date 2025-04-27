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
import java.sql.*;
import java.text.*;
import java.net.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __bookingreferencelookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BookingReferenceLookupResult.jsp", 1737983048165L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n    <head>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n        <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n        <script>\n\t\tasync function runReport1(enc, patid,nursing_unit_code)\n\t\t{\n\t\t\tvar retVal\t\t\t= \tnew String();\n\t\t\tvar dialogHeight\t= \"75vh\" ;\n\t\t\tvar dialogWidth\t\t= \"65vw\" ;\n\t\t\tvar dialogTop\t\t= \"58\";\n\t\t\tvar center\t\t\t= \"1\" ;\n\t\t\tvar status\t\t\t= \"no\";\n\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t\t= \"\" ;\n\t\t\tvar facility_id\t\t= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\t\t\t\n\t\t\tvar gen_file_no\t\t= \"\";\n\t\t\tvar location_type\t= \"N\";\n\t\t\tvar reportParamNames= \"P_BKG_LST_REF_NO,Patient_ID\";\n\t\t\tvar reportParamValues= \"\"+enc+\",\"+patid+\"\";\n\t\t\t//var pat_cat_val =  document.forms[0].pat_cat_val.value;\n\t\t\tvar xmlHttp\t\t\t= new XMLHttpRequest(); \n\t\t\txmlHttp.open(\"POST\",\"../../eIP/jsp/internalReportValidation.jsp?steps=1&patient_id=\"+patid,false);\n\t\t\txmlHttp.send(null);\n\t\t\tresponseText\t\t= xmlHttp.responseText;  \n\t\t\tresponseText\t\t= trimString(responseText);\n\t\t\tvar pat_cat_val\t\t= responseText;\n\n\t\t\tif(pat_cat_val != \"\")\n\t\t\t{\n\t\t\t\tvar sqlString\t= \"select distinct a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from IP_ONLINE_REPORT a, SM_REPORT_lang_vw b  where  a.module_id = \'IP\' and b.internal_request_yn=\'Y\' and a.facility_id=\'\"+facility_id+\"\' and print_on_booking_yn=\'Y\' and a.report_id = b.report_id and language_id = \'\"+localeName+\"\' and a.report_id NOT IN \'IPBBKSLP\' order by 2 \";\n\t\t\t}else\n\t\t\t{\n\t\t\t\tvar sqlString\t= \"select distinct a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from IP_ONLINE_REPORT a, SM_REPORT_lang_vw b  where  a.module_id = \'IP\' and b.internal_request_yn=\'Y\' and a.facility_id=\'\"+facility_id+\"\' and print_on_booking_yn=\'Y\' and a.report_id = b.report_id and language_id = \'\"+localeName+\"\' and a.report_id NOT IN  \'IPBKSVIP\' order by 2 \";\n\t\t\t}\n\t\t\t//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.\n\t\t\tretVal\t\t\t\t= \tawait top.window.showModalDialog(\"../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=BOOKINGREPORT&step=1&P_BKG_LST_REF_NO=\"+enc+\"&Patient_ID=\"+patid+\"&dest_locn_type=\"+location_type+\"&dest_locn_code=\"+nursing_unit_code+\"&sqlString=\"+escape(sqlString)+\"&reportParamNames=\"+reportParamNames+\"&reportParamValues=\"+reportParamValues,arguments,features);\n\t\t}\n\n/// Added by SRIDHAR R on 29 JUNE 2004 \n/// Function viewReferral() will call the Referral Details Page if the Functions are \n/// Admit Patient [AT] OR Revise/Cancel Booking [RCB] OR Active Booking [AB] ...\n\n\t\tasync function viewReferral(ref)\n\t\t{\n\t\t\tvar retVal\t\t\t= \tnew String();\n\t\t\tvar dialogHeight\t= \"700px\";\n\t\t\tvar dialogWidth\t\t= \"1200px\";\n\t\t\tvar dialogTop\t\t= \"72\";\n\n\t\t\tvar status\t\t\t= \"no\";\n\t\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ; dialogTop:\" + dialogTop + \" ; scroll=no; status:\" + status ;\n\n\t\t\tvar retVal\t\t\t= await window.showModalDialog(\"../../eMP/jsp/ViewPatReferral.jsp?referral_id=\"+ref,arguments,features);\n\t\t}\n\t\t\t\n\t\tfunction closeWin(val,val2,val3,val4,val5,val6,val7,val8,val9)\n\t\t{\n\t\t\t\n\t\t\tvar retVal\t\t\t= val+\",\"+val2+\",\"+val3+\",\"+val4+\",\"+val5+\",\"+val6+\",\"+val7+\",\"+val8;\n\t\t\twindow.returnValue\t= retVal\n\t\t\twindow.parent.close()\n\t\t}\n\n\t\tasync function showModal(valu)\n\t\t{\n\t\t\tif(document.forms[0].param.value != \'returnval\')\n\t\t\t{\n                \n\t\t\t\tvar retVal\t\t=    new String();\n\t\t\t\tvar calling_func= \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tvar param\t\t= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\tvar dialogHeight= \"90vh\";\n\t\t\t\tvar dialogWidth = \"95vw\";\n\t\t\t\tvar dialogTop\t= \"0vw\";\n\n\t\t\t\tvar center\t\t= \"1\" ;\n                var status\t\t= \"no\";\n\t\t\t\tvar alrtmsg\t\t= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\n                var features    = \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar condition\t= \"\" ;\n\t\t\t\tfor(var i=0; i<document.forms[0].elements.length; i++)\n\t\t\t\t{\n\t\t\t\t\t\tcondition+= document.forms[0].elements[i].name +\"=\"+ document.forms[0].elements[i].value+\"&\"\n\t\t\t\t\t\t\n\t\t\t\t}\n                var arguments   = \"\" ;\n                retVal\t\t\t= await top.window.showModalDialog(\"../../eIP/jsp/AmendBookingMain.jsp?function_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&bookingRefNo=\"+valu+\"&oper_stn_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&revise_booking_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&cancel_booking_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&confirm_booking_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&create_booking_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&create_booking_with_conf_yn=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&call_function=\"+calling_func+\"&\"+condition,arguments,features);\n\t\t\t\t\n\t\t\t\tif(calling_func == \'RCB\')\n\t\t\t\t\tparent.frames[1].document.location.reload();\n\t\t\t\telse if(calling_func == \'AB\')\n\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\telse\n\t\t\t\t\tparent.frames[1].document.location.href=\"../../eIP/jsp/BookingReferenceLookupCriteria.jsp?param=\"+param+\"&call_function=\"+calling_func;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t//parent.window.returnValue=valu ;\n\t\t\t\t//parent.window.close();\n\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\n    \t\t\tdialogBody.contentWindow.returnValue = valu;\n\n    \t\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\n    \t\t\tdialogTag.close();   \n\t\t\t}\n\t\t}\n\t\t\n\t\tasync function callCanRev(valu,cliniccode,apptdate)\n\t\t{\n      \t\t\t\n\t\t\t\tvar calling_func = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\tvar\tbooking_typ  = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\tvar dialogHeight = \"80vh\" ;\n                var dialogWidth  = \"75vw\" ;\n                var dialogTop    = \"71\" ;\n\t\t\t\t/*var dialogHeight= \"42\" ;\n\t\t\t\tvar dialogWidth = \"65\" ;\n\t\t\t\tvar dialogTop = \"87\" ;*/\n                var center       = \"1\" ;\n                var status\t\t = \"no\";\n\t\t\t\tvar value1\t\t = valu;\n\t\t\t\tvar value2       = cliniccode;\n\t\t\t\tvar value3       = \"\";\n\t\t\t\tvar value5       = apptdate;\n\t\t\t\tvar value6       = \"\";\n\t\t\t\tvar value7       = \"\";\n\t\t\t\tvar clinic_type  = \"\";\n\t\t\t\tif(booking_typ == \'D\')\n\t\t\t\t\tclinic_type  = \"D\";\n\t\t\t\telse\n\t\t\t\t\tclinic_type  = \"I\";\n\n\t\t\t\tvar res_type     = \"R\";\n                var features     = \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n                var arguments    = \"\" ;\n\t\t\t\tvar condition\t = \"\" ;\n\t\t\t\tfor(var i=0; i<document.forms[0].elements.length; i++)\n\t\t\t\t{\n\t\t\t\t\t\tcondition+= document.forms[0].elements[i].name +\"=\"+ document.forms[0].elements[i].value+\"&\"\n\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif(booking_typ==\'I\'|| calling_func == \'RCB\'|| calling_func == \'BookingReport\')\n\t\t\t\tretVal = await top.window.showModalDialog(\"../../eIP/jsp/AmendBookingMain.jsp?function_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&calling=AB&bookingRefNo=\"+escape(valu)+\"&oper_stn_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&call_function=\"+calling_func+\"&bkg_type=\"+booking_typ+\"&\"+condition,arguments,features);\n\t\t\t\telse\n\t\t\t\tretVal =await top.window.showModalDialog(\"../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no=\"+value1+\"&i_clinic_code=\"+value2+\"&i_practitioner_id=\"+value3+\"&i_appt_date=\"+value5+\"&i_from_time=\"+value6+\"&i_to_time=\"+value7+\"&clinic_type=\"+clinic_type+\"&res_type=\"+res_type+\"&call_function=admit\"+\"&\"+condition,arguments,features);\n          }\n\t\t\t\n\t\tasync function showRemarks(bookingRefNo)\n\t\t{\n\t\t\tvar retVal1;\n\t\t\tvar calling_from\t\t\t= \"BookingReferenceLookupResult\";\n\t\t\tvar arguments\t\t\t\t= \"\";\n\t\t\tvar facilityid\t\t\t\t= \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\n\t\t\tvar dialogHeight\t\t\t= \"12\" ;\n\t\t\tvar dialogWidth\t\t\t\t= \"23\" ;\n\t\t\tvar dialogTop\t\t\t\t= \"330\";\n\t\t\tvar dialogLeft\t\t\t\t= \"430\";\n\t\t\t\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\t\t\tretVal1\t\t\t\t\t\t= await window.showModalDialog(\"../../eIP/jsp/remarks.jsp?remarks=\"+calling_from+\"&facilityid=\"+facilityid+\"&bookingRefNo=\"+encodeURIComponent(bookingRefNo)+\" \",arguments,features);\n\t\t}\n\n\t\tfunction callMouseOverRemarks(obj,viewremarks)\n\t\t{\n\t\t\t\t\n\t\t\t\tvar Remarks\t\t\t\t= getLabel(\"Common.remarks.label\",\"Common\");\n\t\t\t\tvar tabdata\t\t\t\t= \"<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></head><body><table class=\'grid\' cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap>\"+Remarks+\"</td></tr><tr><td>\"+viewremarks+\"</td></tr></table></body></html>\";\n\n\t\t\t\tdocument.getElementById(\"details\").innerHTML = tabdata;\n\n\t\t\t\tvar wdth \t\t\t\t= obj.offsetWidth;\n\t\t\t\tvar hght1 \t\t\t\t= obj.offsetHeight;\n\n\t\t\t\tvar wdth1\t\t\t\t= getPos(obj).x - wdth;\n\t\t\t\tvar hght\t\t\t\t= getPos(obj).y + hght1;\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\"details\").style.posTop  = hght;\n\t\t\t\tdocument.getElementById(\"details\").style.posLeft  = wdth1;\n\t\t\t\tdocument.getElementById(\"details\").style.visibility = \'visible\' ;\n\t\t\t\t\t\n\n\t}\n\t\tfunction callOnMouseOutRemarks(obj)\n\t\t{\n\t\t\tdocument.getElementById(\"details\").style.visibility=\'hidden\' ;\n\t\t}\n\t\tfunction getPos(inputElement)\n\t\t{\n\t\tvar coords =  new Object();\n\t\tcoords.x = 0;\n\t\tcoords.y = 0;\n\t\ttry\n\t\t{\n\t\t\ttargetElement = inputElement;\n\t\t\tif(targetElement.x && targetElement.y)\n\t\t\t{\n\t\t\t\tcoords.x = targetElement.x;\n\t\t\t\tcoords.y = targetElement.y;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(targetElement.offsetParent)\n\t\t\t\t{\n\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\twhile(targetElement = targetElement.offsetParent)\n\t\t\t\t\t{\n\t\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//alert(\"Could not find any reference for coordinate positioning.\");\n\t\t\t\t}\n\t\t\t}\n\t\t\treturn coords;\n\t\t}\n\t\tcatch(error)\n\t\t{\n\t\t\treturn coords;\n\t\t}\n\t\t}\n     </script>\n\t\t\t\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n    </head>                         \n    <body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n    <form name = \'BookingReferenceLookupResult_form\'>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<!--<script> \n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\')); \n\t\t</script>-->\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<!--<script> \n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\')); \n\t\t\t\tif(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'==\'BOOKING\')\n\t\t\t{\n\t\t\t\t\tparent.window.close();\n\t\t\t}\n\t\t\t</script>-->\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t   <th>&nbsp;</th>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="<B></B>\n\t\t\t   <th nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;&nbsp;</th>\n\t\t   ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;&nbsp;</th>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<th nowrap>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="Appointment Date ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;&nbsp;</th>\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;</th>\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;</th>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp;</th>\n\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;</th>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t<!--/*modification for SRR20056-CRF-0506*/-->\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;</th>\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;&nbsp;</th>\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<!--//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 09/01/2013-->\n\t\t\t<!--End-->\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;</th>\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<!--END-->\n\t\t\t</tr>\n\t   \n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\'21\' class=\'CAGROUPHEADING\' align=\'left\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\'16\' class=\'CAGROUPHEADING\' align=\'left\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\'14\' class=\'CAGROUPHEADING\' align=\'left\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' nowrap>\n\t\t\t\t\t<a href=javascript:callCanRev(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\',\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\')>+</a></td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<a href=\"javascript:closeWin(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\', \'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\')\">  ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t</a>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&nbsp;</td>  \t\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t\t\t\t\t<a href=\"javascript:callCanRev(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\')\">+</a>\n\t\t\t\t\t\t</td> \t\t\t\t\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'><a href=javascript:showModal(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\')>         ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</a>&nbsp;</td> \n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t\t\t\t<a href=javascript:callCanRev(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\')>+</a\t> \n\t\t\t\t\t&nbsp;</td> \n\t\t\t\t\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</a>&nbsp;</td> \n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\n\t\t\t\t\t\n\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a>&nbsp;</td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'><a href=javascript:callCanRev(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\')>+</a>&nbsp;</td>\n\t\t\t\t\t\t\n\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'><a href=javascript:runReport1(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\')>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</a>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' nowrap>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<a href=javascript:viewReferral(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</a></td> \n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' nowrap>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t\t\t\t   <td class=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t   <td class=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t\t\t\t  <!--/*modification for SRR20056-CRF-0506*/-->\n\t\t\t\t  ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t\t\t   ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' nowrap style=\'COLOR:BLUE;cursor:pointer;\' onclick = \"showRemarks(\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\')\">";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" <td class=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' nowrap>&nbsp;</td>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t<!--//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 09/01/2013\n\t\t\t\t//Start-->\n\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t<!--End-->\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t\t\tdocument.getElementById(\"maxrec\").style.visibility=\'hidden\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t\t\t\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\')); \n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n</table>\n\n<center></center>\n\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\t\n\t\t\t<script>\n\t\t\t\t\n\t\t\tif(parent.frames[0].document.forms[0] != null)\n\t\t\t\tparent.frames[0].document.forms[0].search.disabled=false;\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t<script>\n\t\t\t\t\n\t\t\t\tparent.frames[1].document.forms[0].search.disabled=false \n\t\t\t</script>\t\t\n\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t<script>\n\t\t\t\t\t\t\t\n\t\t\tparent.frames[0].document.forms[0].search.disabled=false\n\t\t\tparent.frames[0].document.forms[0].search.focus();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t<script>\n\t\t\t\t\t\n\t\t\tparent.frames[0].document.forms[0].search.disabled=false\n\t\t\t\n\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t<script>\n\t\t\t\t\n\t\t\tparent.frames[0].document.forms[0].search.disabled=false\n\t\t\t\n\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\n\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" >\n\t<input type=\'hidden\' name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\' value =\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t<input type=\'hidden\' name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value =\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n    </form>\n\n    </body>\n\n</html>\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );
 
public String singleToDoubleQuotes(String strDB)
{
	/*
	StringBuffer stringbuffer	= new StringBuffer(strDB);
	String strModified			= "";
	int i						= 0;

	for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
	{
		i = strDB.indexOf('\'', i);
		stringbuffer.insert(i + j, "'");
		i++;
	}
	strModified=stringbuffer.toString();
	return strModified;
	*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}
	String priority_ind_scr		= "";
	


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

request.setCharacterEncoding("UTF-8");
String locale					= (String)session.getAttribute("LOCALE");

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String facility_id			= (String)session.getAttribute("facility_id");
	String param				= checkForNull(request.getParameter("param"));
	String function_id			= checkForNull(request.getParameter("function_id"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String loc_lang				= checkForNull(request.getParameter("loc_lang"));
	String booking_type			= "";
	String revise_booking_yn	= request.getParameter("revise_booking_yn");
		if(revise_booking_yn == null) revise_booking_yn="";
	String cancel_booking_yn	= request.getParameter("cancel_booking_yn");
		if(cancel_booking_yn == null) cancel_booking_yn="";
	String confirm_booking_yn	= request.getParameter("confirm_booking_yn");
		if(confirm_booking_yn == null) confirm_booking_yn="";
	String create_booking_with_conf_yn = request.getParameter("create_booking_with_conf_yn");
		if(create_booking_with_conf_yn == null) create_booking_with_conf_yn="";
	String create_booking_yn	= request.getParameter("create_booking_yn");
		if(create_booking_yn == null) create_booking_yn="";
	String booking_title		= checkForNull(request.getParameter("title"));


	booking_type				= checkForNull(request.getParameter("booking_type"));
	String bkg_grace_period		= checkForNull(request.getParameter("bkg_grace_period"));
	String capture_fin_dtls_yn  = checkForNull(request.getParameter("capture_fin_dtls_yn"));
	String bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"));
	String login_user			= (String)session.getAttribute("login_user");
	session.removeAttribute("ipPatInstructionsMap");//RUT-CRF-13.1
	
	//Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
    String noshow_bkng_period1   =  checkForNull(request.getParameter("noshow_bkng_period")); 
	int noshow_bkng_period = 0;
	if(!(noshow_bkng_period1.equals(""))){
		  noshow_bkng_period = Integer.parseInt(noshow_bkng_period1);
	}
	
	int diff_min   = 0;  
	String flag1 ="N" ;
	//end  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	
	//String pat_cat_val = "";
	//String bkg_ref_no = "";
	
	String fam_name_ind = checkForNull(request.getParameter("fam_name_ind"));
	/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(param));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(revise_booking_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cancel_booking_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(confirm_booking_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(create_booking_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(create_booking_with_conf_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(booking_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(revise_booking_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cancel_booking_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(confirm_booking_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(create_booking_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(create_booking_with_conf_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block24Bytes, _wl_block24);

		if(booking_title!=null && !booking_title.equals(""))
		{
			out.println("<title>"+booking_title+"</title>");
		}
		
		CallableStatement	Cs_book = null;
		Connection			con		= null;
		Statement			stmt	= null;
		Statement			ipstmt	= null;
		Statement			pat_cat_stmt	= null;
		ResultSet			rs		= null;
		ResultSet			iprs	= null;
		ResultSet			pat_cat_rs	= null;
		
		StringBuffer where_criteria	= new StringBuffer();
		StringBuffer ipsql	    	= new StringBuffer();
		//StringBuffer sql		 = new StringBuffer();
		String class_val		 = "QRYEVENSMALL";
		String priority_ind		 = ""; 
		String temp				 = ""; 
		String priority_ind_desc = "";
		String booking_stat		 = "";
		String whereClause		 = request.getParameter("whereclause");
		String from				 = request.getParameter("from") ;
		String to				 = request.getParameter("to");

		String soundex_type		 = checkForNull(request.getParameter("soundex"));
		String nursing_unit_code = checkForNull(request.getParameter("nursing_unit"));
		String daycare_code		 = checkForNull(request.getParameter("daycare_unit"));
		String speciality_code   = checkForNull(request.getParameter("Splcode"));
		String practitioner_id   = checkForNull(request.getParameter("practid"));
		String from_date		 = checkForNull(request.getParameter("from_date"));
		if(!from_date.equals(""))
			from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 

		String to_date			 = checkForNull(request.getParameter("to_date"));
		if(!to_date.equals(""))
			to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
		String patient_id		 = checkForNull(request.getParameter("patient_id"));

		//String ismult_bkg_yn_flag	 = checkForNull(request.getParameter("ismult_bkg_yn_flag"));
		String gender			 = checkForNull(request.getParameter("gender"));
		String name_prefix		 = checkForNull(request.getParameter("name_prefix"));
		String name_suffix		 = checkForNull(request.getParameter("name_suffix"));
		String first_name		 = checkForNull(request.getParameter("first_name"));
		String second_name		 = checkForNull(request.getParameter("second_name"));
		String third_name		 = checkForNull(request.getParameter("third_name"));
		String family_name		 = checkForNull(request.getParameter("family_name"));
		String national_id_no	 = checkForNull(request.getParameter("national_id_no"));
		String alt_id1_no		 = checkForNull(request.getParameter("alt_id1_no"));
		String alt_id2_no		 = checkForNull(request.getParameter("alt_id2_no"));
		String alt_id3_no		 = checkForNull(request.getParameter("alt_id3_no"));
		String alt_id4_no		 = checkForNull(request.getParameter("alt_id4_no"));
		String other_alt_type	 = checkForNull(request.getParameter("other_alt_type"));
		String other_alt_Id		 = checkForNull(request.getParameter("other_alt_Id"));
		String bed_class_code	 = checkForNull(request.getParameter("Bedcode"));
		String bed_type_code	 = checkForNull(request.getParameter("bed_type_code"));
		String med_service_grp	 = checkForNull(request.getParameter("med_service_grp"));
		/*modification for SRR20056-CRF-0506*/
		String ip_booking_type 	 = checkForNull(request.getParameter("ip_booking_type"));
		booking_stat = checkForNull(request.getParameter("booking_stat"));
		String searchby = checkForNull(request.getParameter("searchby"));
		if (searchby.equals("")) 
			searchby="S";

		String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
		String booking_ref_no		= checkForNull(request.getParameter("booking_ref_no"));
		String ref_type			 = "";
		String ref_source		 = "";
		String referral_id		 = "";
		String ref_pract_name	 = "";
		String ambulance_reqd_yn = "";
		String add_yn			 = "N";
		String past_booking		 = "";
		String booking_type_desc = "";
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
		//Start
		String surgery_date="";
		String surgery_order="";
		//End

		if(call_function.equals("AB"))
		{
			ambulance_reqd_yn = request.getParameter("ambulance_reqd_yn");	
			ref_type		  = request.getParameter("ref_type");
			//ref_source	      = request.getParameter("ref_source");
			ref_source	      = request.getParameter("referral_source1");
			referral_id	      = request.getParameter("referral_id");
			ref_pract_name	  = request.getParameter("ref_pract_name");
		}
		if(call_function.equals("AT"))
		{
			past_booking = checkForNull(request.getParameter("past_booking"));
		}

		if(ambulance_reqd_yn == null || ambulance_reqd_yn.equals("null")) ambulance_reqd_yn = "N";

		if(name_prefix != null)
			name_prefix=singleToDoubleQuotes(name_prefix);

		if(name_suffix != null)
			name_suffix=singleToDoubleQuotes(name_suffix);              

		if (booking_stat==null) 
			booking_stat="";

		String patient_name				= "";
		String bed_no					= "";
		String patient_id1				= "";
		String turndownreason			= "";
		String bookingStatus			= "";
		String link_referral_id			= "";
		String bed_type					= "";
		String bed_type_desc			= "";
		String bed_class				= "";
		String bed_class_desc			= "";
		String callwinPatientid			= "";
		String nursingunit_code			= "";
		String room_no					= "";	
		String speciality_desc			= "";
		String booking_reason			= "";
		String revision_reason			= "";
		String booking_remarks			= "";
		//String view						= "";
		int	p_max_rec_cnt=0;
		  
		
		  
		

	
            _bw.write(_wl_block25Bytes, _wl_block25);

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		ipstmt	= con.createStatement();
		pat_cat_stmt	= con.createStatement();
		if(whereClause==null)
		{
			where_criteria.append(" and a.facility_id='"+facility_id+"'");

			if(ambulance_reqd_yn.equals("Y"))
				where_criteria.append(" and a.amb_reqd_yn ='"+ambulance_reqd_yn+"' ");

			if(!call_function.equals("AB"))
			{	
				if(booking_type.equals("D")&& !daycare_code.equals(""))
				{
					where_criteria.append(" and (a.clinic_code='"+daycare_code+"') ");
				}
				else
				{
					if(booking_type.equals("D")&&!daycare_code.equals(""))
					{
						where_criteria.append(" and (a.clinic_code='"+daycare_code+"') ");
					}
					else if(booking_type.equals("I"))
					{
						if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
							where_criteria.append(" and (a.nursing_unit_code='"+nursing_unit_code+"') ");
						else
							where_criteria.append(" and (a.nursing_unit_code in (Select n.nursing_unit_code from IP_NURSING_UNIT n, AM_OS_USER_LOCN_ACCESS_VW b where n.facility_id='"+facility_id+"' and n.eff_status = 'E' and b.locn_type = 'N' and n.facility_id=b.facility_id and n.nursing_unit_code=b.locn_code and n.locn_type=b.locn_type and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"')  or a.nursing_unit_code is null)");
					}
				}
			}
			else
			{
				if(booking_type.equals("D"))
				{
					where_criteria.append(" and (a.clinic_code='"+daycare_code+"') ");
				}
				else
				{
					if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
						where_criteria.append(" and (a.nursing_unit_code='"+nursing_unit_code+"')");
				}
			}
			if(!booking_type.equals("D"))
			{

				if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
				where_criteria.append(" and (a.nursing_unit_code='"+nursing_unit_code+"')");

				if(speciality_code!=null && !speciality_code.equals(""))
				where_criteria.append(" and a.specialty_code='"+speciality_code+"' ");
			}
			if(practitioner_id!=null && !practitioner_id.equals(""))
				where_criteria.append( " and a.practitioner_id='"+practitioner_id+"' ");
			if(booking_type.equals("D"))
			{
				if(from_date!=null && !from_date.equals(""))
				where_criteria.append(" and trunc(a.appt_date) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
			}
			else
			{
				if(from_date!=null && !from_date.equals(""))
				where_criteria.append(" and trunc(a.preferred_date) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
			}
			
			if(to_date!=null && !to_date.equals(""))
			{
				if(booking_type.equals("D"))
				{
					if(past_booking.equals("Y"))
					where_criteria.append( " and trunc(a.appt_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					else
					where_criteria.append( " and trunc(a.appt_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
				}
				else
				{
					if(past_booking.equals("Y"))
					where_criteria.append( " and trunc(a.preferred_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					else
					where_criteria.append( " and trunc(a.preferred_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
				}
			}
			else if(past_booking.equals("Y"))
			{
				java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy " ) ;
				 java.util.Date dt=new java.util.Date();
				 String d = dateFormat.format( dt ) ;
				if(booking_type.equals("D"))
				{
					where_criteria.append( " and trunc(a.appt_date) < to_date('"+d+"' , 'dd/mm/rrrr') ");
				}
				else
				{
					where_criteria.append( " and trunc(a.preferred_date) < to_date('"+d+"' , 'dd/mm/rrrr') ");
				}
			}

			if( call_function.equals("AB") || call_function.equals("AT") || call_function.equals("RCB") ||  call_function.equals("BookingReport") || call_function.equals("Booking_Admission"))
			{
				if(!booking_type.equals("D"))
				{
					if(!bed_class_code.equals(""))
						where_criteria.append( " and BED_CLASS_CODE = '"+bed_class_code+"' ");

					if(!bed_type_code.equals(""))	
						where_criteria.append( " and BED_TYPE_CODE = '"+bed_type_code+"' ");
		
					if(!med_service_grp.equals(""))	
						where_criteria.append( " and MED_SER_GRP_CODE = '"+med_service_grp+"' ");

					/*modification for SRR20056-CRF-0506*/
				
					if(!ip_booking_type.equals(""))	
						where_criteria.append( " and BOOKING_TYPE_CODE = '"+ip_booking_type+"' ");
				}
			}

			if(booking_ref_no!=null && !booking_ref_no.equals(""))
				where_criteria.append( " and a.BKG_LST_REF_NO like '"+booking_ref_no+"%' ");

			//if(patient_id!=null && !patient_id.equals("") )
			//if(patient_id!=null && !patient_id.equals("") && ismult_bkg_yn_flag.equals("Y"))	
			if(patient_id!=null && !patient_id.equals("") )
				where_criteria.append( " and a.patient_id like '"+patient_id+"%' ");

			if(gender!=null && !gender.equals(""))
				where_criteria.append( " and a.gender = '"+gender+"' ");

			if(name_prefix!=null && !name_prefix.equals(""))
				where_criteria.append(" and a.name_prefix = '"+name_prefix+"' ");

			if(name_suffix!=null && !name_suffix.equals(""))
				where_criteria.append( " and a.name_suffix = '"+name_suffix+"' ");
			
			if(national_id_no!=null && !national_id_no.equals(""))
				where_criteria.append(" and a.national_id_no = '"+national_id_no+"'");
			
			if(alt_id1_no!=null && !alt_id1_no.equals(""))
				where_criteria.append( " and a.alt_id1_no = '"+alt_id1_no+"'");

			if(alt_id2_no!=null && !alt_id2_no.equals(""))
				where_criteria.append(" and a.alt_id2_no = '"+alt_id2_no+"'");

			if(alt_id3_no!=null && !alt_id3_no.equals(""))
				where_criteria.append(" and a.alt_id3_no = '"+alt_id3_no+"'");

			if(alt_id4_no!=null && !alt_id4_no.equals(""))
				where_criteria.append( " and a.alt_id4_no = '"+alt_id4_no+"'");

			if(other_alt_type!=null && !other_alt_type.equals(""))
				where_criteria.append( " and a.oth_alt_id_type = '"+other_alt_type+"'");

			if(other_alt_Id!=null && !other_alt_Id.equals(""))
				where_criteria.append( " and a.oth_alt_Id_no = '"+other_alt_Id+"'");
	
		if(soundex_type.equals("E"))
		{
			if(first_name!=null && !first_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(ethnic_soundex(a.first_name)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
				else
					where_criteria.append( " and upper(ethnic_soundex(a.first_name_loc_lang)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
			}

			if(second_name!=null && !second_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(ethnic_soundex(a.second_name)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
				else
					where_criteria.append( " and upper(ethnic_soundex(a.second_name_loc_lang)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
			}

			if(third_name!=null && !third_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(ethnic_soundex(a.third_name)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
				else
					where_criteria.append( " and upper(ethnic_soundex(a.third_name_loc_lang)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
			}

			if(family_name!=null && !family_name.equals(""))
			{
				String fam_name_search = "";
				if (pat_name_as_multipart_yn.equals("N"))
				{
					StringTokenizer stktok = new StringTokenizer(family_name, " ");
					if (stktok.hasMoreTokens())
						fam_name_search = stktok.nextToken();
					else
						fam_name_search = family_name;
				}
				else
					fam_name_search = family_name;

				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(ethnic_soundex(a.family_name)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");
				else
					where_criteria.append( " and upper(ethnic_soundex(a.family_name_loc_lang)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");
			}
		}
		else if(soundex_type.equals("G"))
		{
		
			if(first_name!=null && !first_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(soundex(a.first_name)) like upper(soundex('" +first_name +"')) || '%' ");
				else
					where_criteria.append( " and upper(soundex(a.first_name_loc_lang)) like upper(soundex('" +first_name +"')) || '%' ");
			}

			if(second_name!=null && !second_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(soundex(a.second_name)) like upper(soundex('" + second_name +"')) || '%' ");
				else
					where_criteria.append( " and upper(soundex(a.second_name_loc_lang)) like upper(soundex('" + second_name +"')) || '%' ");
			}

			if(third_name!=null && !third_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(soundex(a.third_name)) like upper(soundex('"+ third_name+"')) || '%' ");
				else
					where_criteria.append(" and upper(soundex(a.third_name_loc_lang)) like upper(soundex('"+ third_name+"')) || '%' ");
			}

			if(family_name!=null && !family_name.equals(""))
			{
				String fam_name_search = "";
				if (pat_name_as_multipart_yn.equals("N"))
				{
					StringTokenizer stktok = new StringTokenizer(family_name, " ");
					if (stktok.hasMoreTokens())
						fam_name_search = stktok.nextToken();
					else
						fam_name_search = family_name;
				}
				else
					fam_name_search = family_name;

				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(soundex(a.family_name)) like upper(soundex('" +fam_name_search+"')) || '%' ");
				else
					where_criteria.append(" and upper(soundex(a.family_name_loc_lang)) like upper(soundex('" +fam_name_search+"')) || '%' ");
			}
		}
		else
		{/*
out.println("pat_name_as_multipart_yn==>"+pat_name_as_multipart_yn);
out.println("loc_lang==>"+loc_lang);
out.println("first_name==>"+first_name);*/
/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299 -Start*/
		if (fam_name_ind.equals("Y"))
			{

				if (searchby.equals("C"))
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append( " and upper(a.family_name) like '%' || upper('" +family_name+"') || '%' ");
						else
							where_criteria.append( " and upper(a.family_name) like '%' || upper('" +family_name+"') || '%' ");
					}
				}
				else if (searchby.equals("E"))
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
						else
							where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
					}
				}
				else
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
						else
							where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
					}
				}
			
		}else
		  { /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299 - End*/
			if (pat_name_as_multipart_yn.equals("Y"))
			{
					
				if(first_name!=null && !first_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(a.first_name) like upper('" +first_name +"') || '%' ");
					else
						where_criteria.append(" and upper(a.first_name_loc_lang) like upper('" +first_name +"') || '%' ");
				}
				if(second_name!=null && !second_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(a.second_name) like upper('" + second_name +"') || '%' ");
					else
						where_criteria.append(" and upper(a.second_name_loc_lang) like upper('" + second_name +"') || '%' ");
				}

				if(third_name!=null && !third_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append( " and upper(a.third_name) like upper('"+ third_name+"') || '%' ");
					else
						where_criteria.append( " and upper(a.third_name_loc_lang) like upper('"+ third_name+"') || '%' ");
				}
					
				if(family_name!=null && !family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append( " and upper(a.family_name) like upper('" +family_name+"') || '%' ");
					else
						where_criteria.append( " and upper(a.family_name_loc_lang) like upper('" +family_name+"') || '%' ");
				}
			}
			else
			{						
				if (searchby.equals("C"))
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append( " and upper(a.family_name) like '%' || upper('" +family_name+"') || '%' ");
						else
							where_criteria.append( " and upper(a.family_name) like '%' || upper('" +family_name+"') || '%' ");
					}
				}
				else if (searchby.equals("E"))
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
						else
							where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
					}
				}
				else
				{
					if(!family_name.equals(""))
					{
						if(loc_lang.equals("en"))
							where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
						else
							where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
					}
				}
			}
		  }	
		}
			if(call_function.equals("AB") || call_function.equals("RCB") || call_function.equals("AT") || call_function.equals("Booking_Admission"))
			{
				priority_ind_scr  = checkForNull(request.getParameter("priority_ind"));
				
				/*if( (priority_ind_scr != null) && (!priority_ind_scr.equals("")))
				{
					where_criteria.append(" and upper(a.priority_ind) = upper('" +priority_ind_scr+"')");
				}*/
				if( (priority_ind_scr != null) && (!priority_ind_scr.equals("")) && (!booking_type.equals("D")))
				{
					where_criteria.append(" and upper(a.priority_ind) = upper('" +priority_ind_scr+"')");
				}
			}

			if(call_function.equals("AB"))
			{
				if( (ref_source != null) && (!ref_source.equals("")))
				{
					add_yn = "Y";

					if(ref_type.equals("X"))
						where_criteria.append(" and b.FROM_REF_CODE = '"+ref_source+"' ");
					else
						where_criteria.append(" and b.FROM_FACILITY_ID = '"+ref_source+"' ");
				}

				if( (referral_id != null) && (!referral_id.equals("")))
				{
					add_yn = "Y";
					//where_criteria.append( " and b.REFERRAL_ID = '"+referral_id+"' ");  
					where_criteria.append( " and upper(b.REFERRAL_ID) like  upper('"+referral_id+"') || '%' ");
				}

				if( (ref_pract_name != null) && (!ref_pract_name.equals("")))
				{
					add_yn = "Y";
					if(ref_type.equals("X"))
						where_criteria.append( " and b.FROM_PRACT_NAME = '"+ref_pract_name+"' ");
					else
						where_criteria.append( " and b.FROM_PRACT_ID = '"+ref_pract_name+"' ");
				}
			}
		}
		else
		{
			where_criteria.append(whereClause);
		}

		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		
		if ( to == null )
			end = 12;
		else
			end = Integer.parseInt( to ) ;

		// This query is used for getting the grace period from ip param
		int maxRecord = 0;
		/*Saturday, May 08, 2010 ,condition added since in loadrunner this value getting null for multiuser */
		
		if(bkg_grace_period.equals(""))
		{
			ipsql.append("Select bkg_grace_period from IP_PARAM where facility_id='"+facility_id+"' ");
			iprs = ipstmt.executeQuery(ipsql.toString());

			if(iprs!= null)
			{
				if(iprs.next())
				{
					bkg_grace_period = iprs.getString("bkg_grace_period");         
				}                   
			}
			if(iprs != null) iprs.close();
			if(ipstmt != null) ipstmt.close();
		}
		/*if(booking_type.equals("D"))
		{
		sql.append(" select  count(1) from OA_APPT a ");
		}
		else
		{
		 sql.append(" select  count(1) from IP_BOOKING_LIST a ");
		}
		if(call_function.equals("AB") && add_yn.equals("Y"))
		{
			sql.append(", pr_referral_register b ");
		}
		sql.append( " where ");

		if ( call_function.equals("CB") )
			sql.append(" ( ( a.booking_status ='1'  and trunc(a.preferred_date)<= trunc(sysdate))  or a.booking_status='9')  " +where_criteria.toString());       
		else
		{
			if(call_function.equals("AT"))
			{
				
				if(past_booking.equals("Y"))
				{
					if(booking_type.equals("D"))
					{
					sql.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)<= trunc(sysdate)" +where_criteria.toString() );
					}
					else
					{
					sql.append(" a.booking_status='1'" +where_criteria.toString());
					}
				}
				else
				{
					if(booking_type.equals("D"))
					{
						sql.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " +where_criteria.toString() );
					}
					else
					{
						sql.append( " a.booking_status='1' and trunc(a.preferred_date)>= trunc(sysdate) " +where_criteria.toString() );
					}
				}
			}
			else
			if(call_function.equals("AB"))
			{
				if(booking_type.equals("D"))
					sql.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " 	+where_criteria.toString() );
				else
					sql.append( " a.booking_status='1' and trunc(a.preferred_date)>=trunc(sysdate) " +where_criteria.toString() );
			}
			else
			{
				sql.append( " a.booking_status in ('0','1') and trunc(a.preferred_date)>= trunc(sysdate- "+maxperiodforrevbkg+") " +where_criteria.toString() );
			}
		}
   
		if(call_function.equals("AB") && add_yn.equals("Y"))
		{
			sql.append(" and a.REFERRAL_ID = b.REFERRAL_ID (+) ");
		}
		*/

			
		/*rs = stmt.executeQuery(sql.toString());
		rs.next();
		maxRecord = rs.getInt(1);
		if(rs!=null)rs.close();*/
	
	/*if(maxRecord == 0)
	{	*/
            _bw.write(_wl_block26Bytes, _wl_block26);
/*	} 
	else
	{*/
	
		StringBuffer sqlSb = new StringBuffer();

		if(booking_type.equals("D"))
		{
			sqlSb.append(" select a.APPT_REF_NO bkg_lst_ref_no, a.CLINIC_CODE clinic_code,a.APPT_DATE,a.referral_id, to_char(a.APPT_DATE, 'dd/mm/rrrr')  ");
			sqlSb.append( "  disp_preferred_date, a.patient_id, decode('"+locale+"','en',A.patient_name, nvl(A.patient_name_loc_lang, A.patient_name)) patient_name,");
			sqlSb.append( " a.gender , to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date, appt_STATUS from OA_APPT a ");  
		}
		else
		{
			/*sqlSb.append(" select a.bkg_lst_ref_no, a.preferred_date,a.referral_id, to_char(a.preferred_date, 'dd/mm/rrrr hh24:mi')  ");
			sqlSb.append( "  disp_preferred_date, a.patient_id,");
			sqlSb.append( " a.patient_name, a.gender, a.bed_no, a.bed_type_code, IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc, a.bed_class_code, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, a.priority_ind, a.turn_down_reason, to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date, SM_GET_DESC.SM_APPL_USER(modified_by_id,'"+locale+"','1') modified_user_name, booking_status from IP_BOOKING_LIST a ");    */
			
			sqlSb.append("select a.bkg_lst_ref_no, a.preferred_date,a.referral_id,");
			sqlSb.append("to_char(a.preferred_date, 'dd/mm/rrrr hh24:mi') disp_preferred_date, a.patient_id, ");
			sqlSb.append("decode('"+locale+"','en',A.patient_name, nvl(A.patient_name_loc_lang, A.patient_name)) patient_name, a.gender, a.bed_no, a.bed_type_code, IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') bed_type_short_desc,");
			sqlSb.append("a.bed_class_code, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2')");
			sqlSb.append("bed_class_short_desc, a.priority_ind, a.turn_down_reason,"); 
			sqlSb.append(" to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date,"); 
			sqlSb.append(" SM_GET_DESC.SM_APPL_USER(a.MODIFIED_BY_ID,'"+locale+"','1') modified_user_name, booking_status,"); 
			sqlSb.append(" a.NURSING_UNIT_CODE,ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc,a.ROOM_NO,"); 
			sqlSb.append(" a.SPECIALTY_CODE,AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"','2') speciality_desc ,"); 
			sqlSb.append(" am_get_desc.am_complaint (a.chief_complaint,'"+locale+"', '1'  ) booking_reason ,"); 
			sqlSb.append(" am_get_desc.am_contact_reason (a.reason_for_revision_code,'"+locale+"', '1'  ) revision_reason ,"); 
			sqlSb.append(" a.diagnosis_remarks booking_remarks "); 
			sqlSb.append(" ,ip_get_desc.ip_booking_type(a.booking_type_code,'"+locale+"','2') booking_type_desc ");
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
			//Start
			sqlSb.append(" ,a.OPER_SHORT_DESC surgery_order,to_char(a.pref_surg_date,'DD/MM/YYYY') surgery_date");
			//End
			sqlSb.append(" ,(SYSDATE - a.preferred_date ) * 1440    diff_min") ;//Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			
        	sqlSb.append(" from ip_booking_list a");
			
		}

		if(call_function.equals("AB") && add_yn.equals("Y"))
		{
			sqlSb.append( ", PR_REFERRAL_REGISTER b ");
		}
		/*
		if(!booking_type.equals("D"))
		{
			sqlSb.append( "  , ip_nursing_unit c , sm_appl_user d where  a.facility_id = c.facility_id (+) and a.nursing_unit_code = c.nursing_unit_code (+)  and  a.modified_by_id = d.appl_user_id and ");
		}
		*/
		if(!booking_type.equals("D"))
		{
			sqlSb.append( " where  ");
		}

		if ( call_function.equals("CB") )
		{
			if(booking_type.equals("D"))
			{
				sqlSb.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " +where_criteria.toString() );
			}
			else
			{
				sqlSb.append(" ( ( a.booking_status = '1' and trunc(a.preferred_date)<= trunc(sysdate))  or a.booking_status='9')  " +where_criteria.toString()) ;
			}
		}
		else if(call_function.equals("AT") || call_function.equals("Booking_Admission") )
		{
			if(past_booking.equals("Y"))
			{
				if(booking_type.equals("D"))
				{
					sqlSb.append( " where a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)<= trunc(sysdate)and a.clinic_code in (select clinic_code from IP_DC_UNIT_FOR_NURS_UNIT where facility_id ='"+facility_id+"' AND nursing_unit_code IN ");
					sqlSb.append( "(SELECT a.nursing_unit_code from IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id = b.facility_id and a.nursing_unit_code = b.locn_code and a.locn_type = b.locn_type and b.locn_type = 'N' and b.oper_stn_id = '"+oper_stn_id+"' and b.appl_user_id = '"+login_user+"')) "+where_criteria.toString());
				}
				else
				{
					sqlSb.append( " a.booking_status = '1' " +where_criteria.toString()) ;
				}
			}
			else
			{
				if(booking_type.equals("D"))
				{
					sqlSb.append( " where a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate)and a.clinic_code in (select clinic_code from IP_DC_UNIT_FOR_NURS_UNIT where facility_id ='"+facility_id+"' AND nursing_unit_code IN ");
					sqlSb.append( "(SELECT a.nursing_unit_code from IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id = b.facility_id and a.nursing_unit_code = b.locn_code and a.locn_type = b.locn_type and b.locn_type = 'N' and b.oper_stn_id = '"+oper_stn_id+"' and b.appl_user_id = '"+login_user+"')) "+where_criteria.toString() );
				}
				else
				{
					sqlSb.append(" a.booking_status = '1' and trunc(a.preferred_date)>= trunc(sysdate) " +where_criteria.toString()) ;
				}
			}
		 }
		else if(call_function.equals("AB"))
		{
			if(booking_type.equals("D"))
				sqlSb.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " +where_criteria.toString());
			else
				//sqlSb.append(" a.booking_status in ('0','1') " +where_criteria.toString()) ;
				/*Wednesday, July 29, 2009 IN013094*/
				sqlSb.append(" a.booking_status in ('0','1') and trunc(a.preferred_date)>=trunc(sysdate) " +where_criteria.toString()) ;

		}
		else
		{
			if(booking_type.equals("D"))
			{
				sqlSb.append( " a.appt_status='1' and care_locn_type_ind ='D' and trunc(a.appt_date)=trunc(sysdate) " +where_criteria.toString());
			}
			else
			{
				sqlSb.append(" a.booking_status in ('0','1') and trunc(a.preferred_date)>= trunc(sysdate- "+bkg_grace_period+") " +where_criteria.toString()) ;
			}
		}
	
		if(call_function.equals("AB") && add_yn.equals("Y"))
		{
			sqlSb.append( " and a.REFERRAL_ID = b.REFERRAL_ID (+) ");
		}
		if(booking_type.equals("D"))
			 sqlSb.append( " order by a.APPT_DATE");
		else
			sqlSb.append( " order by a.priority_ind desc, a.preferred_date");
		
		/*
		if(rs!=null && rs.next())
		{
			flag =1;
			rs      = stmt. executeQuery(sqlSb.toString());
			
		}
		if(flag == 0)
		{	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(param));
            _bw.write(_wl_block28Bytes, _wl_block28);
	/*} 
		else
		{*/
		int flag=0;
		//if(rs != null ) rs.close();
//out.println("sqlSB==>"+sqlSb.toString());

		rs      = stmt. executeQuery(sqlSb.toString());

		
		
				
		if(rs != null)	
		{	
			if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
			{
				rs.next() ;
			}
			
			//while ( rs!=null && rs.next() && i<=end )
			while ( i<=end && rs.next())
			{
						
			//if (( !(start <= 1) ) || ( !( (start+12) > maxRecord ) ))
			//{
				if(flag==0)
				{
				out.println("<p><table align='right' id ='maxrec'><tr>");
				if ( !(start <= 1) )
					 out.println("<td align='right' id='prev' style='visibility:visible'><A HREF='../jsp/BookingReferenceLookupResult.jsp?noshow_bkng_period="+URLEncoder.encode(noshow_bkng_period1,"UTF-8")+"&param="+param+"&from="+(start-12)+"&to="+(end-12)+"&oper_stn_id="+oper_stn_id+"&past_booking="+past_booking+"&revise_booking_yn="+revise_booking_yn+"&cancel_booking_yn="+cancel_booking_yn+"&confirm_booking_yn="+confirm_booking_yn+"&create_booking_yn="+create_booking_yn+"&create_booking_with_conf_yn="+create_booking_with_conf_yn+"&booking_type="+booking_type+"&daycare_code="+daycare_code+"&whereclause="+URLEncoder.encode(where_criteria.toString(),"UTF-8")+"&call_function="+URLEncoder.encode(call_function,"UTF-8")+"&bkg_grace_period="+URLEncoder.encode(bkg_grace_period,"UTF-8")+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>"); //modified  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
				
				 //if ( !( (start+12) > maxRecord ) )
					out.println("<td align='right' id='next' style='visibility:hidden'><A HREF='../jsp/BookingReferenceLookupResult.jsp?noshow_bkng_period="+URLEncoder.encode(noshow_bkng_period1,"UTF-8")+"&param="+param+"&from="+(start+12)+"&to="+(end+12)+"&revise_booking_yn="+revise_booking_yn+"&cancel_booking_yn="+cancel_booking_yn+"&confirm_booking_yn="+confirm_booking_yn+"&create_booking_yn="+create_booking_yn+"&create_booking_with_conf_yn="+create_booking_with_conf_yn+"&oper_stn_id="+oper_stn_id+"&past_booking="+past_booking+"&booking_type="+booking_type+"&daycare_code="+daycare_code+"&whereclause="+URLEncoder.encode(where_criteria.toString(),"UTF-8")+"&call_function="+URLEncoder.encode(call_function,"UTF-8")+"&bkg_grace_period="+URLEncoder.encode(bkg_grace_period,"UTF-8")+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");//modified  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
				out.println("</tr></table></p>");
				out.println("<br><br>");
			//}
	
            _bw.write(_wl_block29Bytes, _wl_block29);

			if(!call_function.equals("AB") && !param.equals("BOOKING"))
			{	
            _bw.write(_wl_block30Bytes, _wl_block30);
	}	
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

			  
			if(call_function.equals("AT") || call_function.equals("AB") || call_function.equals("RCB") || call_function.equals("Booking_Admission"))
			{	
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
	}	
            _bw.write(_wl_block35Bytes, _wl_block35);
   
				if(booking_type.equals("D")){
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

					if(param.equals("BOOKING") || call_function.equals("AB"))
			{
				
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

			}
					if(call_function.equals("AB"))
					{
						
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

					}
				
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
if(!booking_type.equals("D")){
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
	if(call_function.equals("AB"))
				{
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
	} 
            _bw.write(_wl_block50Bytes, _wl_block50);
if(!booking_type.equals("D")){
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
	
			
				}
				link_referral_id = rs.getString("REFERRAL_ID");
				if(link_referral_id == null) link_referral_id="&nbsp;";
			
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
				//Start
				if(!booking_type.equals("D")){
				surgery_order = rs.getString("surgery_order");
				if(surgery_order == null) surgery_order="&nbsp;";
				surgery_date = com.ehis.util.DateUtils.convertDate(rs.getString("surgery_date"),"DMY","en",locale);		
				if(surgery_date == null) surgery_date="&nbsp;";
				}
				//End
				patient_id1=rs.getString("patient_id");
				callwinPatientid=patient_id1;
				if(callwinPatientid == null) callwinPatientid="";
				if(patient_id1 == null) patient_id1="&nbsp;";
				
				patient_name=rs.getString("patient_name");
				if(patient_name == null) patient_name="&nbsp;";

				gender=rs.getString("gender");
				if(gender == null) 
					gender = "&nbsp;";
				else if (gender.equals("M"))
					gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
					gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else 
					gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

		
				if(!booking_type.equals("D"))
				{
					bed_no = rs.getString("bed_no");
					if( bed_no == null) bed_no="&nbsp;";
				}
				if(!booking_type.equals("D"))
				{
					priority_ind = rs.getString("priority_ind");
						if( priority_ind == null) priority_ind="";
					if(priority_ind.equals("U")) priority_ind_desc="Urgent";
						else if (priority_ind.equals("N")) priority_ind_desc="Non-Urgent";

					turndownreason = rs.getString("turn_down_reason");
					if(turndownreason == null || turndownreason.equals("null")) 
						turndownreason = "";
				}
				if(!booking_type.equals("D"))
				{
					bookingStatus= rs.getString("booking_status");
				}
				else
				{
					bookingStatus = rs.getString("appt_status");
				}

				if(bookingStatus == null || bookingStatus.equals("null"))
					bookingStatus = "0";
				if(!booking_type.equals("D"))
				{
					booking_remarks  = rs.getString("booking_remarks");
					//if(booking_remarks == null) booking_remarks = "&nbsp";
					//if(!booking_remarks.equals(""))
					//booking_remarks		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels");
					revision_reason  = rs.getString("revision_reason");
					if(revision_reason == null) revision_reason = "&nbsp";
					booking_reason  = rs.getString("booking_reason");
					if(booking_reason == null) booking_reason = "&nbsp";
				
					booking_type_desc  = rs.getString("booking_type_desc");
					if(booking_type_desc == null) booking_type_desc = "&nbsp";
				}
				if(!booking_type.equals("D"))
				{
					bed_type=checkForNull(rs.getString("BED_TYPE_CODE"));

					bed_type_desc=checkForNull(rs.getString("BED_TYPE_SHORT_DESC"));
					if(bed_type_desc == null || bed_type_desc.equals("null") || bed_type_desc.equals(""))
						bed_type_desc = "&nbsp;";
				
					bed_class=checkForNull(rs.getString("BED_CLASS_CODE"));

					bed_class_desc=checkForNull(rs.getString("BED_CLASS_SHORT_DESC"));
					if(bed_class_desc == null || bed_class_desc.equals("null") || bed_class_desc.equals(""))
						bed_class_desc = "&nbsp;";
		
					/*nursingunit_code=checkForNull(rs.getString("NURSING_UNIT_CODE")); 
					modified on 12-03-2008 in the refrence of CRF20056-0226 to display nursing unit description instead of mursing unit code.
					*/
					nursingunit_code=checkForNull(rs.getString("nursing_unit_short_desc"));  
					if(nursingunit_code == null || nursingunit_code.equals("null") || nursingunit_code.equals(""))
						nursingunit_code = "&nbsp;";
		
					room_no=checkForNull(rs.getString("ROOM_NO"));
					if(room_no == null || room_no.equals("null") || room_no.equals(""))
						room_no = "&nbsp;";

					speciality_desc=checkForNull(rs.getString("speciality_desc"));
					if(speciality_desc == null || speciality_desc.equals("null") || speciality_desc.equals(""))
						speciality_desc = "&nbsp;";
			
				}
				if(call_function.equals("AB"))
				{
					if ((!(priority_ind.equals(temp)))) 
					{
						
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(priority_ind_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);

					}
					temp=priority_ind;
				}
				else if(priority_ind_scr.equals("") || call_function.equals("RCB"))
				{
						if(param.equals("BOOKING") && !(priority_ind.equals(temp)))
						{
					
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(priority_ind_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);

						}
					else if ((!(priority_ind.equals(temp)))) 
					{
						
						
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(priority_ind_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);

					}
					temp=priority_ind;
				}
				
				if(class_val.equals("QRYEVENSMALL"))
					class_val = "QRYODDSMALL";
				else
					class_val = "QRYEVENSMALL";
				
            _bw.write(_wl_block59Bytes, _wl_block59);
String clin_code="";
				
				  if(param.equals("ADMIT") || param.equals("BOOK_ADMIT")) 
				  {

				  if(booking_type.equals("D"))
					 clin_code = rs.getString("clinic_code");
				  else
					clin_code = "";
				 
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(clin_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(java.net.URLEncoder.encode(rs.getString("disp_preferred_date"))));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block64Bytes, _wl_block64);
if((!past_booking.equals("Y") && booking_type.equals("D")) || booking_type.equals("I")){
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(booking_type));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(clin_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(link_referral_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(callwinPatientid));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bed_type_desc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bed_class));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bed_class_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block68Bytes, _wl_block68);
}else{
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
}
            _bw.write(_wl_block70Bytes, _wl_block70);

					}
					else if(param.equals("BOOKING")) // for create booking 
					{ 
						
						//out.println(" <td class='"+class_val+"'></td> ");
					
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block73Bytes, _wl_block73);
					}
					else if(call_function.equals("RCB"))
					{	
						
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(clin_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(java.net.URLEncoder.encode(rs.getString("disp_preferred_date"))));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block78Bytes, _wl_block78);
	}
					else if((call_function.equals("CB")||call_function.equals("RCB")))
					{	
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(clin_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(java.net.URLEncoder.encode(rs.getString("disp_preferred_date"))));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block82Bytes, _wl_block82);
}else if(call_function.equals("AB"))
					{
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block84Bytes, _wl_block84);
}
					else if(call_function.equals("BookingReport"))
					{	

						
						
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(clin_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(java.net.URLEncoder.encode(rs.getString("disp_preferred_date"))));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block90Bytes, _wl_block90);
	}
					
					/// This block will call the Referral Details Page if the Function is Admit Patient OR Revise/Cancel Booking OR Active Booking...

					if(param.equals("BOOKING")) 
						out.println(" <td class='"+class_val+"'>&nbsp;</td> ");
					else if(call_function.equals("AT") || call_function.equals("AB") || call_function.equals("RCB") || call_function.equals("Booking_Admission"))
					{	
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rs.getString("REFERRAL_ID")));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(link_referral_id));
            _bw.write(_wl_block92Bytes, _wl_block92);
  
					}
					
					  //Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
						if(!booking_type.equals("D")) // Condition Added Against Incident 35847 Dated on 23-10-2012
						{
							diff_min= rs.getInt("DIFF_MIN");
						
				     		if(diff_min > noshow_bkng_period)
							{  
								flag1 ="Y";
							}
							else{
								flag1 ="N";
								}
						} //  Incident 35847 ended  
					 //end   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
					
						String Booking_Status = "";
						if(bookingStatus.equals("0"))
						{	
							Booking_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotConfirmed.label","common_labels");
						}
						else
						{  
						//Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
						
						if(flag1.equals("Y") || flag1=="Y"){
						   Booking_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.noshow.label","common_labels");
						   }  //end  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
						else{
						   	Booking_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirmed.label","common_labels");
							}
						}
						String disp_preferred_date_DayCare_Inpatient = "";
						if(booking_type.equals("D"))
							disp_preferred_date_DayCare_Inpatient = DateUtils.convertDate(rs.getString("disp_preferred_date"),"DMY","en",locale);
						else
							disp_preferred_date_DayCare_Inpatient = DateUtils.convertDate(rs.getString("disp_preferred_date"),"DMYHM","en",locale);
					
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disp_preferred_date_DayCare_Inpatient));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block97Bytes, _wl_block97);

						if(param.equals("BOOKING") || call_function.equals("AB"))
						{
					
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(nursingunit_code));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bed_class_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bed_type_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block97Bytes, _wl_block97);

						}
						if(call_function.equals("AB"))
						{
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block97Bytes, _wl_block97);
}
					
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(Booking_Status));
            _bw.write(_wl_block101Bytes, _wl_block101);
if(!booking_type.equals("D")){
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(booking_type_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(booking_reason));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(revision_reason));
            _bw.write(_wl_block102Bytes, _wl_block102);
if(rs.getString("booking_remarks") != null) {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(rs.getString("bkg_lst_ref_no")));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
}else{
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block107Bytes, _wl_block107);
}
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block109Bytes, _wl_block109);
	if(call_function.equals("AB"))
					{	
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(DateUtils.convertDate(rs.getString("modified_date"),"DMYHM","en",locale)));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(checkForNull(rs.getString("modified_user_name"),"&nbsp;")));
            _bw.write(_wl_block111Bytes, _wl_block111);
	}	
            _bw.write(_wl_block112Bytes, _wl_block112);
if(!booking_type.equals("D"))	{
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(surgery_order));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block111Bytes, _wl_block111);
}
            _bw.write(_wl_block115Bytes, _wl_block115);
 i++;
				p_max_rec_cnt++;
				maxRecord++;
				flag++;
			} 

							
				if ( maxRecord < 12 || (!rs.next()) )
				{
					
            _bw.write(_wl_block116Bytes, _wl_block116);
 
				}
				else
				{
            _bw.write(_wl_block117Bytes, _wl_block117);

				}
					
				if(maxRecord == 0)
				{	
            _bw.write(_wl_block118Bytes, _wl_block118);
	} 
		}
            _bw.write(_wl_block119Bytes, _wl_block119);
//}
}catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();
	
	}
    finally
    {
		try{
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
		if (iprs != null) iprs.close();
		if (ipstmt != null) ipstmt.close();
		if (pat_cat_rs != null) pat_cat_rs.close();
		if (pat_cat_stmt != null) pat_cat_stmt.close();
       	if(Cs_book != null) Cs_book.close();
		}
		catch(Exception e)
		{
			//out.println(e.toString());
				e.printStackTrace();
		}
		 ConnectionManager.returnConnection(con,request);
		
		if(call_function.equals("RCB") && !param.equals("BOOKING"))
		{
            _bw.write(_wl_block120Bytes, _wl_block120);
}
		else if(call_function.equals("AB"))// Added by Sridhar to disable the search button in the criteria page when function is Active Booking
			{ 
            _bw.write(_wl_block121Bytes, _wl_block121);
	}
		else if(!call_function.equals("BookingReport") && !param.equals("BOOKING") && call_function.equals("ADMIT"))
		{ 
            _bw.write(_wl_block122Bytes, _wl_block122);
	}
		else if(call_function.equals("BookingReport"))
		{
			
            _bw.write(_wl_block123Bytes, _wl_block123);

		}
		else if(call_function.equals("AT"))
		{
				
            _bw.write(_wl_block124Bytes, _wl_block124);

		}

    }	
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(param));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block128Bytes, _wl_block128);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BookingRefNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PreferredDateTime.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BookingStatus.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingType.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Reasonforbooking.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Reasonforrevision.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.modifieddatetime.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.modifiedby.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryOrder.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryDate.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
}
