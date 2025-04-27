package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __ae_code_setup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AE_Code_Setup.jsp", 1709113866053L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\"JavaScript\">\n\t\tvar count = 0;\n\t\tvar prev=0;\n\t\tvar prevcol=\'MENUSUBLEVELCOLOR\';\n\t\tvar sec_hdg_cd=new Array();\n\t\tvar logic_seq_no=new Array(); \n\n\t\tfunction goHomePage(){\n\t\t\t\tparent.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t} \n\t\t\n\t\tfunction chcol(ro)\n\t\t{\n\t\t\t\tdocument.getElementById(\"t\").rows(prev).cells(0).className=prevcol;\n\t\t\t\tprevcol=ro.cells(0).className;\n\t\t\t\tro.cells(0).className=\"MENUSELECTEDCOLOR\"\n\t\t\t\tprev=ro.rowIndex;\n\t\t\t\n\t\t}\n\n\t\tfunction callJSPs(val)\n\t\t{\n\t\t\t/*\n\t\t\t\t\tAccess is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess\n\t\t\t*/\n\t\t\t\n\n\t\t\tif(val == \'TreatmentAreaforClinic\'){\n     var funtitle=encodeURIComponent(getLabel(\"eAE.TreatmentAreaforLocation.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/TreatmentAreaforClinic.jsp?module_id=AE&function_id=AE_TMT_AREA_FOR_CLINIC&function_name=\'+funtitle+\'&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'BayType\'){\n\t\t\t\t var funtitle=encodeURIComponent(getLabel(\"eAE.BedBayType.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/AEBayType.jsp?module_id=AE&function_id=AE_BAY_TYPE&function_name=\'+funtitle+\'&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\t\n\t\t\tif(val == \'SpareBays\'){\n               var funtitle=encodeURIComponent(getLabel(\"eAE.BedBay.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/SpareBays.jsp?module_id=AE&function_id=AE_BED_FOR_TRMT_AREA&function_name=\'+funtitle+\'&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\t \n\t\t\t\t//------------------\t\n\t\t\t\n\t/*\t\t if(val == \'BedforTreatmentArea\'){\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/BedforTreatmentArea.jsp?module_id=AE&function_id=AE_BED_FOR_TRMT_AREA&function_name=Bays For Treatment Area&function_type=F&access=YYYNN\';\n\t\t\t}\n \n*/\n\t\t\tif(val == \'AssignSpareBaysforTreatmentArea\'){\n                var funtitle=encodeURIComponent(getLabel(\"eAE.AssignBedBaysForTreatmentArea.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/AssignSpareBaysToTreatmentArea.jsp?module_id=AE&function_id=AE_BED_FOR_TRMT_AREA&function_name=\'+funtitle+\'&function_type=F&access=YYYNN\';\n\t\t\t}\n\n\n\n\t\t//------------------\n\t\t\t\n\t\t\t\n\t\t\tif(val == \'PractitionerforTreatmentArea\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.Practitionerfor.label\",\'AE\'));\n                  funtitle=funtitle+\' \'+encodeURIComponent(getLabel(\"Common.treatmentarea.label\",\'Common\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/PractforTreatmentArea.jsp?module_id=AE&function_id=AE_PRACT_FOR_TMT_AREA&function_name=\'+funtitle+\'&function_type=F&access=YYYYN\';\n\t\t\t}\n\n\n/*\t\t\tif(val == \'AccidentType\'){\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/AccidentType.jsp?module_id=AE&function_id=AE_ACCIDENT_TYPE&function_name=Accident Type&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'RTA\'){\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/RTA.jsp?module_id=AE&function_id=AE_RTA_CODE&function_name=Road Traffic Accident&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'AccidentCause\'){\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/AccidentCause.jsp?module_id=AE&function_id=AE_ACCIDENT_CAUSE&function_name=Accident Cause&function_type=F&access=YYYNN\';\n\t\t\t}\n*/\n\t\t\tif(val == \'PatientPosition\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"Common.PatientPosition.label\",\'Common\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/PatientPosition.jsp?module_id=AE&function_id=AE_PAT_POSITION&function_name=\'+funtitle+\'&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'ProtectiveDevice\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/ProtectiveDevice.jsp?module_id=AE&function_id=AE_PROTECTIVE_DEVICE&function_name=\'+funtitle+\'&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\t/*if(val == \'PatientSymptom\'){\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/PatientSymptom.jsp?module_id=AE&function_id=AE_PATIENT_SYMPTOM&function_name=Patient Symptom&function_type=F&access=YYYNN\';\n\t\t\t} */\n\t/*\t\tif(val == \'SuddenOnset\'){\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/SuddenOnset.jsp?module_id=AE&function_id=AE_SUDDEN_ONSET&function_name=Sudden Onset&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\t*/\n\n\t\n\t\t\tif(val == \'Question\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/Responsibility.jsp?module_id=AE&function_id=AE_RESP&function_name=Responsibility&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'Questionnaire\'){ \n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/FacilityforResponsibility.jsp?module_id=AE&function_id=AE_RESP_FCY&function_name=Responsibility for Facility&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'QuestionforQuestionnaire\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/AddModifyMenuRstrnForResp.jsp?module_id=AE&function_id=MENU_RSTRN_FOR_RESP&function_name=Menu Restriction for Responsibility&function_type=F&access=YYNNY\';\n\t\t\t} \n\t\t\tif(val == \'PatientCondition\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/User.jsp?module_id=AE&function_id=AE_USER&function_name=User&function_type=F&access=YYYNN\';\n\t\t\t}\n\n\n\t\t\tif(val == \'InjuryCategory\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.InjuryCategory.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/InjuryCategory.jsp?module_id=AE&function_id=AE_INJ_CATEGORY&function_name=\'+funtitle+\' &function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'InjurySubCategory\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.InjurySubcategory.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/InjurySubCategory.jsp?module_id=AE&function_id=AE_INJURY_SUBCATEGORY&function_name=\'+funtitle+\' &function_type=F&access=YYYNN\';\n\t\t\t}\n\n\n\n\n\n\t\t\t/* \n\t\t\t\tif(val == \'ComplaintDuration\'){\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/ComplaintDuration.jsp?module_id=AE&function_id=AE_COMPLAINT_DURATION&function_name=Complaint Duration&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\t*/\n\t\t\tif(val == \'PatientPriority\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.PatientPriority.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/PatientPriority.jsp?module_id=AE&function_id=AE_PATIENT_PRIORITY&function_name=\'+funtitle+\'&function_type=F&access=YYYNN\';\n\t\t\t}\n\n\n\t/*\t\tif(val == \'AnotomicalSite\'){\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/AnatomicalSite.jsp?module_id=AE&function_id=AE_ANATOMICAL_SITE&function_name=Anatomical Site&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'Responsiveness\'){\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/Responsiveness.jsp?module_id=AE&function_id=AE_RESPONSIVENESS&function_name=Responsiveness&function_type=F&access=YYYNN\';\n\t\t\t}\n*/\n\t\t\t\n\t\t\tif(val == \'InjuryType\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../servlet/eAE.PrinterServlet?module_id=AE&function_id=SM_PRINTER&function_name=Printer&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'InjurySeverityScore\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../servlet/eAE.ReportServiceServlet?module_id=AE&function_id=SM_REPORT_SERVICE&function_name=Report Service&function_type=F&access=YYYNN\';\n\t\t\t}\n\n\n\t\t\tif(val == \'GCSResponse\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/GCSResponse.jsp?module_id=AE&function_id=AE_GCS_RESPONSE&function_name=GCS Category&function_type=F&access=NNNNN\';\n\t\t\t}\n\t\t\tif(val == \'GCSforResponse\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.GCSforResponse.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/GCSforResponse.jsp?module_id=AE&function_id=AE_GCS_FOR_RESPONSE&function_name=\'+funtitle+\'&function_type=F&access=NYYNN\';\n\t\t\t}\n\t\t\tif(val == \'GCSScore\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.GCSScore.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/GCSScore.jsp?module_id=AE&function_id=AE_GCS_SCORE&function_name=\'+funtitle+\'&function_type=F&access=NYNNN\';\n\t\t\t}\n\n \n\t\t\tif(val == \'RevisedTraumaScore\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/PrintRoutingMain.jsp?module_id=AE&function_id=SM_PRINT_ROUTING&function_name=Print Routing&function_type=F&access=YYYYN\';\n\t\t\t}\n\n\t\t\t\n\t\t\tif(val == \'TraumaInjurySeverityScore\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.ProtectiveDevice.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/FreqAccessFunc.jsp?module_id=AE&function_id=FREQ_ACCESS_FUNC&function_name=Frequently Accessed Functions&function_type=F&access=NNNNN\';\n\t\t\t}\n\t\t\tif(val == \'Immobilization\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.Immobilization.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/Immobilization.jsp?module_id=AE&function_id=AE_IMMOBILIZATION&function_name=\'+funtitle+\'&function_type=F&access=YYYNN\';\n\t\t\t}\n// ********* Disaster Type ***********\n\t\t\tif(val == \'DisasterType\'){\n\t\t\t\tvar funtitle=encodeURIComponent(getLabel(\"eAE.DisasterType.label\",\'AE\'));\n\t\t\t\tparent.frames[1].location.href = \'../../eAE/jsp/AEDisasterType.jsp?module_id=AE&function_id=AE_DISASTER_TYPE&function_name=\'+funtitle+\'&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t}\n\t\t \n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body style=\"background-color:dimgray;\" onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t<form name=\"SMMasterMenu_form\" id=\"SMMasterMenu_form\">\n\t<table cellspacing=1 cellpadding=2 width=\'100%\' border=0 id=\'t\'>\n\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'TreatmentAreaforClinic\')\" >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</a></td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'BayType\')\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</a></td>\n\t\t</tr>\n\t\t<!-- -------------------- -->\n\t<!-- \t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'BedforTreatmentArea\')\" >Bays For Treatment Area</a></td>\n\t\t</tr>  -->\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'SpareBays\')\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a></td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'AssignSpareBaysforTreatmentArea\')\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</a></td>\n\t\t</tr>\n\n<!-- -------------------- -->\n\t\t\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'PractitionerforTreatmentArea\')\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<br>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n\t\t</tr>\n\n\t\t<tr><td class=\"BLANK_ROW\">&nbsp;</td></tr>\n\t\t\n\t\t<!-- <tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'AccidentType\')\" >Accident Type</a></td>\n\t\t</tr>\t\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"AccidentCause\")\' >Accident Cause</a></td>\n\t\t</tr>\t\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"RTA\")\' >Road Traffic Accident</a></td>\n\t\t</tr>\t -->\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"PatientPosition\")\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a></td>\n\t\t</tr>\t\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"ProtectiveDevice\")\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a></td>\n\t\t</tr>\t\t\t\n\t\t<!-- <tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"PatientSymptom\")\' >Patient Symptom</a></td>\n\t\t</tr>\t -->\n<!-- \t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"SuddenOnset\")\' >Sudden Onset</a></td>\n\t\t</tr> -->\t\n\t\n\t\t<tr><td class=\"BLANK_ROW\">&nbsp;</td></tr>\n\n<!-- \t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"Question\")\' >Question</a></td>\n\t\t</tr>\t\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"Questionnaire\")\' >Questionnaire</a></td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"QuestionforQuestionnaire\")\' >Question for Questionnaire</a></td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"PatientCondition\")\' >Patient Condition</a></td>\n\t\t</tr>\n -->\t\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"InjuryCategory\")\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"InjurySubCategory\")\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a></td>\n\t\t</tr>\n\t\t\n\t\t<tr><td class=\"BLANK_ROW\">&nbsp;</td></tr>\n\t\t\n\t<!-- \t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"ComplaintDuration\")\' >Complaint Duration</a></td>\n\t\t</tr> -->\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"PatientPriority\")\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></td>\n\t\t</tr>\n\n\t\t<tr><td class=\"BLANK_ROW\">&nbsp;</td></tr>\n\t\t\n\t<!-- \t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"AnotomicalSite\")\' >Anatomical Site</a></td>\n\t\t</tr>\t\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"Responsiveness\")\'>Responsiveness</a></td>\n\t\t</tr> -->\t\t\n\t\t\n<!-- \t\t<tr><td class=\"BLANK_ROW\">&nbsp;</td></tr>\n\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"InjuryType\")\' >Injury Type </a></td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"InjurySeverityScore\")\' >Injury Severity Score</a></td>\n\t\t</tr>\n\n -->\t\t<tr><td class=\"BLANK_ROW\">&nbsp;</td></tr>\n\n<!-- \t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"GCSResponse\")\' >GCS Category</a></td>\n\t\t</tr> -->\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"GCSforResponse\")\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a></td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"GCSScore\")\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></td>\n\t\t</tr>\n\t\t<tr><td class=\"BLANK_ROW\">&nbsp;</td></tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"Immobilization\")\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a></td>\n\t\t</tr>\n\t\t<!-- **************** Disaster Type ******************** -->\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"DisasterType\")\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a></td>\n\t\t</tr>\n\t<!-- \t<tr><td class=\"BLANK_ROW\">&nbsp;</td></tr>\n\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"RevisedTraumaScore\")\' >Revised Trauma Score</a></td>\n\t\t</tr>\n\t\t\n\t\t<tr><td class=\"BLANK_ROW\">&nbsp;</td></tr>\n\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td class=\'MENUSUBLEVELCOLOR\' onClick=\'javascript:callJSPs(\"TraumaInjurySeverityScore\")\' >Trauma Injury Severity<br>Score</a></td>\n\t\t</tr>\n\t\t -->\n\t\t<tr>\n\t\t\t<td class=\'MENUHIGHERLEVELCOLOR\'><a href=javascript:goHomePage() style=\'color:white;\'><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</b></a></td> \n<!-- \t\t\t<td class=\'MENUHIGHERLEVELCOLOR\' onClick=javascript:goHomePage() class=\'MENUHIGHERLEVELLINK\'><b>HOME</b></td>\n -->\t\t</tr>\n\t\t</table>\n\n\t</body>\n\t\n\t</form>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.TreatmentAreaforLocation.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBay.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AssignBedBaysForTreatmentArea.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Practitionerfor.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPosition.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ProtectiveDevice.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.InjuryCategory.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.InjurySubcategory.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PatientPriority.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.GCSforResponse.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.GCSScore.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Immobilization.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DisasterType.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.menu.label", java.lang.String .class,"key"));
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
}
