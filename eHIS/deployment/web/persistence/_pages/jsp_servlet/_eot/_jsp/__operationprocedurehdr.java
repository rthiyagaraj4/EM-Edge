package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Clob;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eOT.OperationDtlBean;
import eOT.Common.OTRepository;
import java.util.ArrayList;
import eOR.OrderEntryBillingQueryBean;
import eOT.Common.*;
import eCommon.Common.CommonBean;
import eOT.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __operationprocedurehdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperationProcedureHdr.jsp", 1739951096000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n<TITLE>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</TITLE>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"/>\n<Script Language=\"JavaScript\"  src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/Booking.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/BookingPatientSearch.js\'></script>\n<script type=\"text/javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/OTPatientSearch.js\'></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<!-- Added by MuthuN against CRF - 011  on 2/7/2013 -->\n<script > var lblPreOperDiag=getLabel(\"eOT.PreOperativeDiagnosis.Label\",\"OT\");</script>\n<!-- Added by MuthuN against CRF - 011  on 2/7/2013 -->\n<script language=\'javascript\'>\nvar preOperativeDiag_value= getLabel(\"eOT.PreOperativeDiagnosis.Label\",\"OT\");\nvar remarks_value=getLabel(\"Common.remarks.label\",\"common\");\nvar preOperDiagArray = [\"surgeonType\" , \"episode_type\" , \"patient_id\" , \"SPECIALITY_DESC\" , \"Source_code\" ];\n\t//Checking Discharge Advice - Rajesh V 10/11/2012\n\tfunction callDischargeChk(){\n\t\tvar dis_encounter_id = document.getElementById(\"encounter_id\").value;\n\t\tvar dis_pat_class = document.getElementById(\"episode_type\").value;\n\t\tvar facilityid = document.PreOperHdr.facility_id.value;\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\tvar param=\"func_mode=discharge_check&dis_encounter_id=\"+dis_encounter_id+\"&dis_patient_class=\"+dis_pat_class+\"&dis_facility_id=\"+facilityid;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"../../eOT/jsp/OTCommonValidation.jsp?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = localTrimString(xmlHttp.responseText);\t\n\t\tif(retVal>0){\n\t\t\talert(getMessage(\"DIS_ADVICE_ALREAD_EXISIT\",\"IP\"));\n\t\t\tvar formObj = document.PreOperHdr;\n\t\t\tformObj.patient_id.value=\"\";\n\t\t\tformObj.patient_name.value=\"\";\n\t\t\tformObj.sex.value=\"\";\n\t\t\tformObj.date_of_birth.value=\"\";\n\t\t\tformObj.encounter_id.value=\"\";\n\t\t\tformObj.episode_id.value=\"\";\n\t\t\tformObj.visitid.value=\"\";\n\t\t\tclearSource();\n\t\t}\n\t}\n\t//Checking Discharge Advice - Rajesh V 10/11/2012\n\tfunction clearSource(){\n\t\tvar frmObj=document.forms[0];\n\t\tfrmObj.Source_code.value=\'\';\n\t\tfrmObj.sourceDesc.value=\'\';\n\t\tfrmObj.changed_sourceType.value=\'\';\n\t}\t\n\n\t//Modified by lakshmi against jordan migration issue\n\tfunction changeSourceType(){\n\t\tclearSource();\n\t\tpatient_class_code=document.forms[0].patient_class_code.value;\n\t\tvar val=\tdocument.getElementById(\"episode_type\").value;\n\t\tvar patient_class_code1=patient_class_code.split(\"$$\");\n\t\tif(val==\"\"){\n\t\t\tdocument.getElementById(\"sourceType\").value=\"\";\n\t\t\t//document.getElementById(\"sourceTypeDesc\").value=getLabel(\"Common.defaultSelect.label\",\"Common\");\n\t\t\tdocument.getElementById(\"sourceTypeDesc\").value =\"\"; //Rameez changed against 39540 on 26-04-2013\n\t\t\tdocument.getElementById(\"sourceType\").disabled=true;\n\t\t\tdocument.getElementById(\"more_img\").style.visibility= \'hidden\';\n\t   }\n\t\t\n\tif(val==\'DC\'||val==\'IP\'){\n\t\tdocument.getElementById(\"sourceType\").value=\"W\";\n\t\tdocument.getElementById(\"sourceTypeDesc\").value=getLabel(\"Common.nursingUnit.label\",\"Common\");\n\t\tdocument.getElementById(\"sourceType\").disabled=true;\n\t\tdocument.getElementById(\"more_img\").style.visibility= \'visible\';//GHL-CRF-0356\n\t\t}\n\t\t\n\tif(val==\'EM\'||val==\'OP\'){\n\t\tdocument.getElementById(\"sourceType\").value=\"C\";\n\t\tdocument.getElementById(\"sourceTypeDesc\").value=getLabel(\"Common.clinic.label\",\"Common\");\n\t\tdocument.getElementById(\"sourceType\").disabled=true;\n\t\tdocument.getElementById(\"more_img\").style.visibility= \'visible\';//GHL-CRF-0356\n\t\t}\n\n\tif(val==\'XT\'){\n\t\t\tdocument.getElementById(\"sourceType\").value=\"E\";\n\t\t\tdocument.getElementById(\"sourceTypeDesc\").value=getLabel(\"Common.referral.label\",\"Common\");\n\t\t\tdocument.getElementById(\"sourceType\").disabled=true;\n\t\t\tdocument.getElementById(\"more_img\").style.visibility= \'hidden\';\n\t\t}\n\t\tdocument.getElementById(\"changed_sourceType\").value=document.getElementById(\"sourceType\").value;\n\t\tdocument.getElementById(\"changed_sourceTypeDesc\").value=document.getElementById(\"sourceTypeDesc\").value;\n\t}\n\n\tfunction clearDesc(){\n\t\tvar formObj = document.forms[0];\n\t\tvar pat_id=formObj.patient_id.value;\n\t\tif(pat_id==\"\" || pat_id==null || pat_id==\"null\" || pat_id==\"undefined\")\n\n\t\tformObj.patient_name.value=\"\";\n\t\tformObj.sex.value=\"\";\t\n\t\tformObj.date_of_birth.value=\"\";\n\t\t//Modified by DhanasekarV against CRF_0859 2/12/2010\n\t\tformObj.encounter_id.value=\"\";\n\t\tformObj.episode_id.value=\"\";\n\t\tformObj.visitid.value=\"\";\n\t\tclearSource();\n\t}\n\tfunction callLongRefName(){\n\n\t}\n</script>\n</head>\n\n<body onLoad=\'setInitialValue();\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n<form name=\'PreOperHdr\' id=\'PreOperHdr\' method=\'POST\' action=\'../../eOT/jsp/OperationProcedureHdr.jsp\'>\n  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n  <table border=\'0\' cellpadding=1  cellspacing=\'0\' width=\'100%\'>\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'PerformingLocation\' id=\'PerformingLocation\' size=\'35\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' disabled></td>\n      <td class=\'label\' width=\'25%\' >&nbsp;</td>\n      <td class=\'fields\' width=\'25%\' >&nbsp;</td>\n    </tr>\n    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'BOOKING_DATE\' id=\'BOOKING_DATE\' size=\'35\' readonly value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'booking_no\' id=\'booking_no\' size=\'5\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' readonly></td>\n    </tr>\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'surgeonType\' id=\'surgeonType\' size=\'35\'  align=\'left\' \n\t\t\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onBlur=\"if(this.value!=\'\')callSurgeryTypeAndValidateCutOffTime(\'SurgeryType\');\" >\n        <input type=\'button\' class=\'button\' name=\'quest1\' id=\'quest1\' value=\'?\' onClick=\"callSurgeryTypeAndValidateCutOffTime(\'SurgeryType\')\">\n        <img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n    ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \n\t <td class=\'fields\' width=\'25%\' ><select name=\'episode_type\' id=\'episode_type\' DB_VALUE=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onChange=\'clearPatientDetails();changeSourceType();checkEncId(this); showPreOperDiagLink(); enableProcedudureDtlFields();\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" ><!--Added Against ML-MMOH-CRF-1939-US2-->\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<td class=\'fields\' width=\'25%\' ><select name=\'episode_type\' id=\'episode_type\' DB_VALUE=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onChange=\'clearPatientDetails();changeSourceType();checkEncId(this); showPreOperDiagLink();\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n        <option value=\"\" selected>\n          ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n          </option>\n        ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n        <option value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\n        ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n      </select>\n        <img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n    </tr>\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n      <td class=\'fields\' width=\'25%\' ><!-- Checking Discharge Advice - Rajesh V 10/11/2012 --> \n        <!-- Commented the below function calls after fixing the issue--> \n        <!--<input type=\'text\' name=\'patient_id\' id=\'patient_id\'maxlength=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' size=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' onkeypress=\"return CheckForSpecChars(event)\"  align=\'right\'  value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" onBlur=\"if(this.value!=\'\'){callPatSearch(); callDischargeChk();} else{clearDesc();} \" >\n\t\t\t<input type=\'button\' class=\'Button\'  name=\'quest2\' id=\'quest2\' value=\'?\' onClick=\'callPatSearch();callDischargeChk();\'>-->\n        ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \n\t   <input type=\'text\' name=\'patient_id\' id=\'patient_id\'maxlength=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' onKeyPress=\"return CheckForSpecChars(event)\"  align=\'right\'  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" onBlur=\"if(this.value!=\'\'){callPatSearch();} else{clearDesc();} enableProcedudureDtlFields();\" ><!--Added Against ML-MMOH-CRF-1939-US2-->\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n        <input type=\'text\' name=\'patient_id\' id=\'patient_id\'maxlength=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onBlur=\"if(this.value!=\'\'){callPatSearch();} else{clearDesc();}\" >\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n        <input type=\'button\' class=\'Button\'  name=\'quest2\' id=\'quest2\' value=\'?\' onClick=\'callPatSearch();\'>\n        \n        <!-- Checking Discharge Advice - Rajesh V 10/11/2012 --> \n        <img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'patient_name\' id=\'patient_name\' size=\'35\'  align=\'right\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' readonly></td>\n    </tr>\n    <tr>\n      <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n      <td class=\'label\' width=\'25%\'><input type=\'text\' name=\'sex\' id=\'sex\' size=\'35\'  align=\'right\' DB_VALUE=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" value=\'\' readonly></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'date_of_birth\' id=\'date_of_birth\' size=\'35\'  align=\'right\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' readonly></td>\n    </tr>\n    <tr>\n      <td class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n      <td class=\"fields\" width=\'25%\' ><input type=\'text\' class=\"fields\" name=\'encounter_id\' id=\'encounter_id\' size=\'35\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' disabled>\n        \n        <!-- Checking Discharge Advice - Rajesh V 11/16/2012 --> \n        <!-- Commented the below function calls after fixing the issue--> \n        <!-- <input type=\'button\' class=\'button\' name=\'encounterLookUp\' id=\'encounterLookUp\' value=\'?\' onClick=\'callBookingEncounterSearch(); callDischargeChk();\' > -->\n        \n        <input type=\'button\' class=\'button\' name=\'encounterLookUp\' id=\'encounterLookUp\' value=\'?\' onClick=\'callBookingEncounterSearch();enableProcedudureDtlFields()\' ><!--Modified Against ML-MMOH-CRF-1939-US2-->\n        \n        <!-- Checking Discharge Advice - Rajesh V 11/16/2012 --> \n        <img id=\"enc_check\" src=\'../../eCommon/images/mandatory.gif\' style=\'position:absolute;visibility:visible\'></img></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'waitlist_no\' id=\'waitlist_no\' size=\'35\'  align=\'left\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"\n\t\t\treadonly ></td>\n    </tr>\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n      <td class=\'fields\' width=\'25%\' ><!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->\n        \n        <input type=\'text\' name=\'SPECIALITY_DESC\' id=\'SPECIALITY_DESC\' size=\'35\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" onBlur=\"if(this.value!=\'\')searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value=\'\'; clearSpeciality_Code(this); anesthesiaRequiredYN(); \" >\n        <input type=\'button\' class=\'button\'  value=\'?\' onClick=\"searchSpeciality(SPECIALITY_DESC);anesthesiaRequiredYN(SPECIALITY_DESC);\" >\n        \n        <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> \n        <img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'Position_desc\' id=\'Position_desc\' size=\'35\'  align=\'right\' value =\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' onBlur=\"if(this.value!=\'\')searchposition(Position_desc);\">\n        <!--name=\'Source Type\'-->\n        <input type=\'button\' class=\'Button\'  name=\'quest5\' id=\'quest5\' value=\'?\' onClick=\"searchposition(Position_desc)\">\n        <input type=\'hidden\' name=\'Patient_position\' id=\'Patient_position\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'></td>\n    </tr>\n    <tr>\n      <td class=\'label\' >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n      <td class=\'fields\' ><input type=\'text\' name=\'order_id\' id=\'order_id\' size=\'35\'  align=\'left\'\tvalue=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"\n\t\t\treadonly ></td>\n      <td class=\'label\' >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n      <td class=\'fields\' ><input type=\'text\' name=\'asst_surgeon_name\' id=\'asst_surgeon_name\' maxlength=\'20\' size=\'35\' value= \"\" onBlur=\"if(this.value!=\'\')searchAsstSurgeon(asst_surgeon_name,asst_surgeon_code);else asst_surgeon_code.value=\'\' \">\n        <input type=\'hidden\' name=\'asst_surgeon_code\' id=\'asst_surgeon_code\' maxlength=\'20\' size=\'20\' value= \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n        <input type=\'button\' class=\'button\' value=\'?\' name=\'AssSurButton\' id=\'AssSurButton\' onClick=\"searchAsstSurgeon(asst_surgeon_name,asst_surgeon_code);\"></td>\n    </tr>\n    <tr>\n      <td class=\'label\' >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n      <td colspan=\"3\" class=\'fields\'>\n        <input type=\'hidden\' name=\'sourceType\' id=\'sourceType\'  DB_VALUE=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'  >\n        <input type=\'text\' name=\'sourceTypeDesc\' id=\'sourceTypeDesc\' size=\'35\'  value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" disabled>\n        \n        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n<input type=\'text\' name=\'Source_code\' id=\'Source_code\' size=\'45\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' onBlur=\"if(this.value!=\'\') searchSourceTypeSelect(Source_code);else callchangeMoreIcon();\">\n        <input type=\'button\' class=\'button\' name=\'quest6\' id=\'quest6\' value=\'?\' onClick=\"searchSourceTypeSelect(Source_code)\">\n        <!--GHL-CRF-0356-->\n        <!-- <div id=\'more_img\' style=\'position:absolute;visibility:hidden;\'> --> <img id=\'more_img\' src=\'../../eCommon/images/mandatory.gif\'></img><!-- </div> --></td>\n    </tr>\n    <!-- Below SourceType from Direct OT Booking function -->\n    <!--tr>\n      <td class=\'label\' width=\'25%\' >&nbsp;</td>\n      <td class=\'fields\' width=\'25%\'>&nbsp;</td>\n      \n      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->\n     \n      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> \n      \n    <!--/tr-->\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n      <td class=\'label\' width=\'25%\' ><input type=\'text\' name=\'Anaesthetia1_code\' id=\'Anaesthetia1_code\' size=\'20\'  value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" onBlur=\"if(this.value!=\'\')searchanaesthesia(Anaesthetia1_code)\">\n        <input type=\'button\' class=\'button\' name=\'quest4\' id=\'quest4\' value=\'?\' onClick=\"searchanaesthesia(Anaesthetia1_code)\">\n        \n        <!-- Sanjay for showing mandatory symbol when Anesthesia Review Checkbox is Checked against IN032063 --> \n        <img id=\"anes_check\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'></img></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'Anaesthetiest2_code\' id=\'Anaesthetiest2_code\' size=\'20\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" onBlur=\"if(this.value!=\'\')searchAnaesthetist(Anaesthetiest2_code)\" >\n        <input type=\'button\' class=\'button\' name=\'quest3\' id=\'quest3\' value=\'?\' onClick=\"searchAnaesthetist(Anaesthetiest2_code)\"></td>\n    </tr>\n    <!-- Added for PMG2014-CRF-0002 [IN:046043]  -->\n    \n    <tr>\n     ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n      <td   class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n      <td class=\'fields\' width=\'25%\'><!-- <input type=\'checkbox\' name=\'anaes_review\' id=\'anaes_review\' value=\'\' onClick=\"checkAnesReq();\"> -->\n        \n        <input type=\'checkbox\' name=\'anaes_review\' id=\'anaes_review\' value=\'\' checked></td>\n      ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n      <td class=\'fields\' width=\'25%\'><input type=\'checkbox\' name=\'anaes_review\' id=\'anaes_review\' value=\'\' disabled></td>\n      ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n      <td class=\'fields\'>&nbsp;</td>\n      <td class=\'fields\' >&nbsp;</td>\n        \n    </tr>\n    <tr> \n      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here\t-->\n      <td class=\'fields\' width=\'25%\'><input type=\'hidden\' name=\'REMARKS\' id=\'REMARKS\' value=\"\">\n        <input type=\'hidden\' name=\"pre_oper_diag\" id=\"pre_oper_diag\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n        <a  href=\"javascript:showRemarks(document.forms[0].REMARKS,\'1\',remarks_value,1300);\">&nbsp;\n        ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n        </a></td>\n      <td class=\'fields\' width=\'25%\' >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n        <a  href=\"javascript:showRemarks1(document.forms[0].pre_oper_diag,\'2\',preOperativeDiag_value,500);\">\n        ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n        </a></td>\n      <td class=\'fields\' width=\'25%\' ><!-- Added for PMG2014-CRF-0002 [IN:046043]  -->\n        \n        ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n        <a  href=\"javascript:showRemarks1(document.forms[0].pre_oper_diag,\'1\',preOperativeDiag_value,500);\">\n        ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n        </a></td>\n      <!-- Added by MuthuN against CRF - 011  on 2/7/2013 -->\n      <td class=\'fields\' width=\'25%\' ><!-- Added for PMG2014-CRF-0002 [IN:046043]  -->\n        \n        <div id=\'showPreOperDiagDivAnch\' style=\'display:none\'> <a class=\'gridLink\' href=\"javascript:callPreOPDiagnosis_2();\">\n          ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n          </a> </div>\n        <div id=\'showPreOperDiagDivLabel\' style=\'display:none\'>\n          ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n        </div>\n        \n        <!-- Added by MuthuN against CRF - 011 on 2/7/2013  -->\n        \n        ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> \n    </tr>\n    ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n    <input type=\'hidden\' name=\'BOOKING_DATE\' id=\'BOOKING_DATE\' size=\'10\'   value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' >\n    <input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' DB_VALUE=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" value=\"\" >\n    <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'   value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n    <!-- Modified by Muthukumar on 1/8/2011 for checking null values in gender  -->\n    <input type=\'hidden\' name=\'sex\' id=\'sex\' DB_VALUE=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" value=\'\' >\n    <!--<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\'  value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' >\n\t\t<input type=\'hidden\' name=\'sex\' id=\'sex\' DB_VALUE=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" value=\'\' >\n\t\t--> \n    <!-- Modified by Muthukumar on 1/8/2011 for checking null values in gender -->\n    <input type=\'hidden\' name=\'date_of_birth\' id=\'date_of_birth\'  value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' >\n    <input type=\'hidden\' name=\'order_id\' id=\'order_id\' \tvalue=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"  >\n    <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n    <input type=\'hidden\' name=\'patient_name\' id=\'patient_name\'  value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" >\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' readonly></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'surgeonType\' id=\'surgeonType\' size=\'20\' \n\t\t\tvalue=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" readonly >\n        <input type=\'button\' class=\'button\' name=\'quest1\' id=\'quest1\' value=\'?\' onClick=\"callSurgeryTypeAndValidateCutOffTime(\'SurgeryType\')\">\n        <img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n    </tr>\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'waitlist_no\' id=\'waitlist_no\' size=\'20\'  value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"\n\t\t\treadonly ></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n      <td class=\'fields\' width=\'25%\' ><!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->\n        \n        <input type=\'text\' name=\'SPECIALITY_DESC\' id=\'SPECIALITY_DESC\' size=\'20\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" onBlur=\"if(this.value!=\'\')searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value=\'\'; anesthesiaRequiredYN(SPECIALITY_DESC); \" disabled>\n        <input type=\'button\' class=\'button\'  value=\'?\' onClick=\"searchSpeciality(SPECIALITY_DESC); anesthesiaRequiredYN(SPECIALITY_DESC);\" disabled>\n        \n        <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> \n        <img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n    </tr>\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" disabled>\n        <input type=\'button\' class=\'button\' name=\'quest3\' id=\'quest3\' value=\'?\' onClick=\"searchAnaesthetist(Anaesthetiest2_code)\"></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'Anaesthetia1_code\' id=\'Anaesthetia1_code\' size=\'20\'   value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"  disabled>\n        <input type=\'button\' class=\'button\' name=\'quest4\' id=\'quest4\' value=\'?\' onClick=\"searchanaesthesia(Anaesthetia1_code)\"></td>\n    </tr>\n    <!-- Below SourceType is from CA/OR function -->\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n      <td class=\'fields\' width=\'25%\' nowrap><select name=\'sourceType\' id=\'sourceType\' DB_VALUE=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' onChange=\'clearSources()\' >\n          <option value=\'\'>\n          ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n          </option>\n          <option value=\'W\'>\n          ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n          </option>\n          <option value=\'C\'>\n          ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n          </option>\n          <option value=\'E\'>\n          ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n          </option>\n        </select>\n        \n        <!--GHL-CRF-0356-->\n        \n        ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n        <input type=\'text\' name=\'Source_code\' id=\'Source_code\' size=\'75\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" >\n        <input type=\'button\' class=\'button\' name=\'quest6\' id=\'quest6\' value=\'?\' onClick=\"searchsourcetype(Source_code)\" ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =">\n        <div id=\'more_img\' style=\'position:absolute;visibility:hidden;\'><img src=\'../../eOT/images/more.gif\' onMouseOver=\"Tip(getLongNameRefSrcBkAppt(),CENTERMOUSE,true)\" onMouseOut=\"UnTip()\"></img> <img src=\'../../eCommon/images/mandatory.gif\'></img></div>\n        ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n        <img src=\'../../eCommon/images/mandatory.gif\'></img>\n        ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n        \n        <!--GHL-CRF-0356--></td>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'hidden\' name=\'asst_surgeon_code\' id=\'asst_surgeon_code\' maxlength=\'15\' size=\'15\' value= \"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"  >\n        <input type=\'text\' name=\'asst_surgeon_name\' id=\'asst_surgeon_name\' maxlength=\'20\' size=\'20\' value= \"\" onBlur=\"if(this.value!=\'\')searchAsstSurgeon(asst_surgeon_name,asst_surgeon_code); else asst_surgeon_code.value=\'\'\">\n        <input type=\'button\' class=\'button\' value=\'?\' name=\'AssSurButton\' id=\'AssSurButton\' onClick=\"searchAsstSurgeon(asst_surgeon_name,asst_surgeon_code);\"></td>\n    </tr>\n    <tr>\n      <td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n      <td class=\'fields\' width=\'25%\' ><input type=\'text\' name=\'Position_desc\' id=\'Position_desc\' size=\'20\'  value =\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' disabled>\n        \n        <!--name=\'Source Type\'-->\n        \n        <input type=\'button\' class=\'Button\'  name=\'quest5\' id=\'quest5\' value=\'?\' onClick=\"searchposition(Position_desc)\">\n        <input type=\'hidden\' name=\'Patient_position\' id=\'Patient_position\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'></td>\n      <!-- <td class=\'fields\' width=\'25%\' ></td> --> <!-- Commented by Sanjay for Anaesthesia Required Checkbox CRF against IN032063--> \n      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->\n      ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n      <td class=\'fields\' width=\'25%\'><input type=\'checkbox\' name=\'anaes_review\' id=\'anaes_review\' value=\'\' disabled checked></td>\n      ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> \n    </tr>\n    <!-- Added for PMG2014-CRF-0002 [IN:046043]-->\n    <tr>\n      <td class=\'fields\' width=\'25%\'>&nbsp;</td>\n    </tr>\n    <tr> \n      <!-- <td class=\'fields\' width=\'25%\' ></td> --> <!-- Commented by Sanjay for Anaesthesia Required Checkbox CRF against IN032063-->\n      <td class=\'fields\' width=\'25%\'><input type=\'hidden\' name=\'REMARKS\' id=\'REMARKS\' value=\"\">\n        <input type=\'hidden\' name=\"pre_oper_diag\" id=\"pre_oper_diag\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n        <a  href=\"javascript:showRemarks(document.forms[0].REMARKS,\'1\',remarks_value,1300);\">\n        ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n        </a> \n        <!-- Added by MuthuN against CRF - 011  on 2/7/2013 --></td>\n      <td class=\'fields\' width=\'25%\' ><!-- Added for PMG2014-CRF-0002 [IN:046043]--> \n        <a class=\'gridLink\' href=\"javascript:callPreOPDiagnosis_2();\">\n        ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n        </a> \n        <!-- Added by MuthuN against CRF - 011 on 2/7/2013  -->\n        \n        ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n        <a  href=\"javascript:showRemarks(document.forms[0].pre_oper_diag,\'1\',preOperativeDiag_value,500);\">\n        ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n        </a>\n        ";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n      <td class=\'fields\' width=\'25%\' >&nbsp;</td>\n      <td class=\'fields\' width=\'25%\'><!--<input type=\'button\' name=\'\' id=\'\' class=\'button\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' onClick=\'closeWindow()\'>--> <!-- commented for PMG2014-CRF-0002 [IN:046043]--></td>\n    </tr>\n    <tr>\n      <td class=\'fields\' width=\'25%\' colspan=\"4\">\n    </tr>\n    ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n  </table>\n  <input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n  <input type=\'hidden\' name=\'waitlistno\' id=\'waitlistno\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n  <input type=\'hidden\' name=\'booking_date\' id=\'booking_date\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n  <input type=\'hidden\' name=\'roomCode\' id=\'roomCode\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n  <input type=\'hidden\' name=\'roomDesc\' id=\'roomDesc\' value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n  <input type=\'hidden\' name=\'surgeonName\' id=\'surgeonName\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n  <input type=\'hidden\' name=\'surgeonCode\' id=\'surgeonCode\' value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n  <input type=\'hidden\' name=\'selSurgeonCode\' id=\'selSurgeonCode\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n  <!-- 051911 -->\n  <input type=\'hidden\' name=\'SPECIALITY_CODE\' id=\'SPECIALITY_CODE\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n  <input type=\'hidden\' name=\'start_time\' id=\'start_time\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n  <input type=\'hidden\' name=\'hidden_time\' id=\'hidden_time\' value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n  <input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n  <input type=\'hidden\' name=\'encounter_id1\' id=\'encounter_id1\' value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n  <input type=\'hidden\' name=\'natureCode\' id=\'natureCode\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n  <input type=\'hidden\' name=\'natureType\' id=\'natureType\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n  <input type=\'hidden\' name=\'nursingUnitCode\' id=\'nursingUnitCode\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n  <input type=\'hidden\' name=\'sourceDesc\' id=\'sourceDesc\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n  <input type=\'hidden\' name=\'Anaesthetiest1_code\' id=\'Anaesthetiest1_code\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n  <input type=\'hidden\' name=\'Anaesthetia_code\' id=\'Anaesthetia_code\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n  <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n  <input type=\'hidden\' name=\'duration\' id=\'duration\' value=\'\'>\n  <input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'\'>\n  <input type=\'hidden\' name=\'orderid\' id=\'orderid\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n  <input type=\'hidden\' name=\'selOrderIds\' id=\'selOrderIds\' id=\'selOrderIds\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n  ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n  <input type=\'hidden\' name=\'ammendFlag\' id=\'ammendFlag\' id=\'ammendFlag\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n  <input type=\'hidden\' name=\'selBookingNumber\' id=\'selBookingNumber\' id=\'selBookingNumber\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n  <input type=\'hidden\' name=\'visitid\' id=\'visitid\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n  <input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'>\n  <input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" >\n  <input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n  <input type=\'hidden\' name=\'pref_date\' id=\'pref_date\' value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n  <input type=\'hidden\' name=\'waitlistyn\' id=\'waitlistyn\' value=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'>\n  <input type=\'hidden\' name=\'specilaity_collect\' id=\'specilaity_collect\' value=\'\'>\n  <input type=\'hidden\' name=\'ip_booking_yn\' id=\'ip_booking_yn\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' >\n  <input type=\'hidden\' name=\'over_booking_case_yn\' id=\'over_booking_case_yn\' value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' >\n  <input type=\'hidden\' name=\'patient_class_code\' id=\'patient_class_code\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\' >\n  <input type=\'hidden\' name=\'end_time\' id=\'end_time\' value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n  <input type=\'hidden\' name=\'HLongRefSrcId\' id=\'HLongRefSrcId\' value=\"\">\n  <!--GHL-CRF-0356-->\n  ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n  <!--GHL-CRF-0356-->\n  <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n  <input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n  <input type=\'hidden\' name=\'changed_sourceType\' id=\'changed_sourceType\'  value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'  >\n  <input type=\'hidden\' name=\'changed_sourceTypeDesc\' id=\'changed_sourceTypeDesc\'  value=\'\'  >\n  <input type=\'hidden\' name=\'called_from\' id=\'called_from\'  value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'  >\n  <input type=\"hidden\" name=\"or_bean_id\" id=\"or_bean_id\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n  <input type=\"hidden\" name=\"or_bean_name\" id=\"or_bean_name\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n  <input type=\"hidden\" name=\"ammendBooking\" id=\"ammendBooking\" id=\"ammendBooking\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n  ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n  <input type=\"hidden\" name=\"PreOpPreparationDays\" id=\"PreOpPreparationDays\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n  <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 -->\n  <input type=\"hidden\" name=\"anaes_review1\" id=\"anaes_review1\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n  <input type=\'hidden\' name=\'isIncludeFpp\' id=\'isIncludeFpp\' value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" ><!--Added Against ML-MMOH-CRF-1939-US2-->\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}

	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
    String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8"); 
	String or_bean_id 				    = "orderentrybean";
    String or_bean_name 			    = "eOR.OrderEntryBean";

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
 
	String end_time=checkForNull(request.getParameter("end_time"));
	request.setCharacterEncoding("UTF-8");
	//String surgeryType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SurgeryType.label","common_labels")+",";
	String male =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+",";
	String female =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+",";
	String unknown =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+",";
	String bean_id = "OperationDtlBean";
	String bean_name = "eOT.OperationDtlBean";
	OperationDtlBean chk_bean = (OperationDtlBean)mh.getBeanObject( bean_id, request, bean_name);
	chk_bean.clear();
	String mode=CommonRepository.getCommonKeyValue("MODE_INSERT");
	String strBookingDate="",strSurgeonName="",strSurgeonCode="",strStartTime="",strSurgeryType="",strRoomDesc="",strNatureType="",strRoomCode="",strNatureCode="",strSpecialityDesc="",strPrefDate="",strSpecialityCode="",strWaitListNo="",strName="",strWaitListYN="",strAge="",strSex="",strIpBookingYN="",strPatientId="",strFacilityId="",strNursingUnit="",strEncounterId="",strBookingNum="",strHiddenTime="",strEpisodeType="",strOrderId="",strOrderTypeCode="",strEpisodeId="",strPatientClass="",strVisitId="",strReferalSource="",strRefSourceCode="",strAnesthesiaCode="",strPatientPosition="",strPositionCode="",strReferalDesc="", strSpecialityYN="",strPreOperDiag="",strAsstSurgeonCode="", patient_class_code="",PatIDLen="",sourceTypeDesc="";  
String ammendBooking = ""; //ChAiTu
String chkBookingExistDays = ""; //ChAiTu
	String PreOpPreparationDays = "";
	String selSurgeonCode = ""; // 051911
	String anaes_review1 = "A";//Added by sanjay for Anaesthesia Required Checkbox against IN032063
	String performingLocation = "";//Added for CRF 298
	// Added for CRF-21 OverBooking Cases

	String over_booking_case_yn=checkForNull(request.getParameter("over_booking_case_yn"));
	over_booking_case_yn=over_booking_case_yn==null?"N":over_booking_case_yn;
	over_booking_case_yn=over_booking_case_yn.equals("null")?"N":over_booking_case_yn;
	over_booking_case_yn=over_booking_case_yn.equals("")?"N":over_booking_case_yn;
	// CRF-21 Added till here
	strSpecialityYN=checkForNull(request.getParameter("speciality_access"));
	strOrderId=checkForNull(request.getParameter("orderid"));
String selOrderIds = checkForNull(request.getParameter("selOrderIds")); // ChAiTu - 186
String ammendFlag = checkForNull(request.getParameter("ammendFlag")); // ChAiTu - 186
String selBookingNumber = checkForNull(request.getParameter("selBookingNumber")); // ChAiTu - 186
System.out.println("=======selOrderIds===OperationProcedureHdr.jsp====="+selOrderIds);
System.out.println("=======ammendFlag===OperationProcedureHdr.jsp====="+ammendFlag);
System.out.println("=======selBookingNumber===OperationProcedureHdr.jsp====="+selBookingNumber);
	strBookingNum=checkForNull(request.getParameter("booking_num"));
System.out.println("=======strBookingNum===OperationProcedureHdr.jsp====="+strBookingNum);
	String called_from=checkForNull(request.getParameter("called_from"));
	strBookingDate=checkForNull(request.getParameter("booking_date"));
	strStartTime=checkForNull(request.getParameter("start_time"));
	strHiddenTime=checkForNull(request.getParameter("hidden_time"));
	String disable_flag = (!strOrderId.equals("") )?"disabled":"";
	strRoomDesc=checkForNull(request.getParameter("roomDesc"));
	strRoomCode=checkForNull(request.getParameter("roomCode"));
	strSpecialityDesc=checkForNull(request.getParameter("speciality_desc"));
	strSpecialityCode=checkForNull(request.getParameter("speciality_code"));
	strPatientClass=checkForNull(request.getParameter("episode_type"));
	strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));
	selSurgeonCode=checkForNull(request.getParameter("selSurgeonCode"));// 051911
	System.err.println("191 selSurgeonCode=================>"+selSurgeonCode);
	//selSurgeonCode=selSurgeonCode.equals("null")?"":strSurgeonCode; //ML-BRU-SCF-1640 [IN056671]//186
	
	if(selSurgeonCode.equals("null")) selSurgeonCode=strSurgeonCode;
	
	
	strSurgeonCode=strSurgeonCode==null?"":strSurgeonCode;
	strSurgeonCode=strSurgeonCode.equals("null")?"":strSurgeonCode;
	//strSurgeonCode=strSurgeonCode.equals("*ALL")?"":strSurgeonCode; //050456 
	strSurgeonName=checkForNull(request.getParameter("surgeonName"));
	strSurgeonName=strSurgeonName==null?"":strSurgeonName;
	strSurgeonName=strSurgeonName.equals("null")?"":strSurgeonName;
	strSurgeonName=strSurgeonName.equalsIgnoreCase("ALL")?"":strSurgeonName;//186
	strSurgeonName=strSurgeonName.equalsIgnoreCase("ALL")?selSurgeonCode:strSurgeonName;//186
	
	strPatientId=checkForNull(request.getParameter("patient_id"));
	strSurgeryType=checkForNull(request.getParameter("surgeonType"));
	strNatureCode=checkForNull(request.getParameter("natureCode"));
	strNatureType=checkForNull(request.getParameter("natureType"));
	strVisitId=checkForNull(request.getParameter("visitid"));
	strAsstSurgeonCode=checkForNull(request.getParameter("asst_surgeon_code")); //add for asst surgeon
	/*Added by Sanjay for Anaesthesia Required Checkbox agaisnt IN032063*/
	String strAnesReqYN = "";
	String chkReferalDisable = "";//GHL-CRF-0356
	int strAnesReqYNPending = 0;
	String strSpeciality_temp="",strAnesthetit_temp="",strAnesthesia_temp="",strAnaesthetistCode="",strAnesthetit_temp1="",strAnesthesia_temp1="";
	String strOrderPract= "";
	//Added Against ML-MMOH-CRF-1939-US2...starts
	//String Include_Fpp_yn = "";
	boolean isIncludeFpp = false;
	boolean bill_flag = false;
	//Integer count =0;
    //Added Against ML-MMOH-CRF-1939-US2...ends
System.out.println("228,strSpeciality_temp===="+strSpeciality_temp);
strSpeciality_temp=checkForNull(request.getParameter("SPECIALITY_DESC"));
System.out.println("230,strSpeciality_temp===="+strSpeciality_temp);
if(strSpecialityDesc.length()>0)
	strSpeciality_temp=strSpecialityDesc;
if(strSpecialityCode.length()==0)
{
	strSpecialityCode=checkForNull(request.getParameter("SPECIALITY_CODE"));
}

	strAnesthetit_temp1=checkForNull(request.getParameter("Anaesthetiest2_code"));
	strAnesthetit_temp=checkForNull(request.getParameter("Anaesthetiest1_code"));
	strAnesthesia_temp1=checkForNull(request.getParameter("Anaesthetia1_code"));
	strAnesthesia_temp=checkForNull(request.getParameter("Anaesthetia_code"));
	HttpSession httpSession = request.getSession(false);		
	strFacilityId=""+httpSession.getValue("facility_id"); 	
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs=null;
	ResultSet rs1=null;
	String sql="";
try{	
	 con = ConnectionManager.getConnection(request);
	 String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
	 pstmt=con.prepareStatement(sqlLen);
	 rs=pstmt.executeQuery();
	 while(rs.next() && rs!=null)
		{
			PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
		}
	 if(rs!=null) rs.close();
	 if(pstmt!=null) pstmt.close();
	
	//for getting facilityName
	if(strFacilityId.length()>0){
		// To check if Anesthesia is Enabled at Speciality level
		 String sqlFacilityName="SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE FACILITY_ID = ?";		 
		 pstmt = con.prepareStatement(sqlFacilityName);
		 pstmt.setString(1,strFacilityId);		 
		 rs=pstmt.executeQuery();		 
		 if(rs.next()==true){			 
			 performingLocation=rs.getString(1);			 
		  }
		 if(rs!=null)	rs.close();
		 pstmt.close();
	}
	if(strSpecialityCode.length()>0){
		/*Added by Sanjay for Anaesthesia Required Checkbox agaisnt IN032063 STARTS here*/
		// To check if Anesthesia is Enabled at Speciality level
		 String sqlAnesReq="SELECT NVL(ANAESTHESIA_REVIEW_REQD_YN,'N') FROM OT_SPECIALITIES WHERE SPECIALITY_CODE = ?";		 
		 pstmt = con.prepareStatement(sqlAnesReq);
		 pstmt.setString(1,strSpecialityCode);		 
		 rs=pstmt.executeQuery();		 
		 if(rs.next()==true){			 
			 strAnesReqYN=rs.getString(1);			 
		  }
		 if(rs!=null)	rs.close();
		 pstmt.close();
	}
	
	if (strOrderId.length() > 0){
		// To check whether Anesthesia Review is checked when it was ordered in CA. For Pending Orders screen
		String sqlAnesReq1="SELECT COUNT(*) FROM AT_PENDING_ORDERS WHERE SOURCE_ORDER_ID = ?";		 
		pstmt = con.prepareStatement(sqlAnesReq1);
		pstmt.setString(1,strOrderId);		 
		rs=pstmt.executeQuery();		 
		if(rs.next()==true){
			strAnesReqYNPending=rs.getInt(1);			 
		}
		if(rs!=null)	rs.close();
		pstmt.close();		 
	}
		sql = "select NVL(IPBOOKING_WITH_THEATRE_YN,'N') BOOKING_YN,nvl(ammend_bookings, 'N') ammend_bookings, chk_bookings_exist_days from ot_param_for_facility where OPERATING_FACILITY_ID=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strFacilityId);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			 strIpBookingYN=checkForNull(rs.getString("BOOKING_YN"));		 
			 ammendBooking = checkForNull(rs.getString("ammend_bookings"));
			 chkBookingExistDays = checkForNull(rs.getString("chk_bookings_exist_days"));
		}
		System.out.println("===ammendBooking===OperationProcedureHdr.jsp=="+ammendBooking);
		System.out.println("===chkBookingExistDays==OperationProcedureHdr.jsp==="+chkBookingExistDays);
		if(rs!=null)   rs.close();	  
		pstmt.close();

if(strOrderId.length()>0)
{
	sql=OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT1");

    pstmt1 = con.prepareStatement(sql);
	pstmt1.setString(1,strOrderId);
	rs=pstmt1.executeQuery();
	if(rs.next()){
		strFacilityId=checkForNull(rs.getString("PERFORMING_FACILITY_ID1"));
		strOrderTypeCode=checkForNull(rs.getString("ORDER_TYPE_CODE1"));
		if(strSurgeonCode.length()==0)
		{
			strSurgeonCode=checkForNull(rs.getString("PERFORMING_TEAM_SURGEON1"));
		    strSpecialityCode=checkForNull(rs.getString("SPECIALITY_CODE1"));
			/*Added by Suma on march 3 2010 for hadling defaulting of specialty in booking screen when called from CA*/
		    strSpeciality_temp=checkForNull(rs.getString("SPECIALITY_DESC"));	
			/*Added by Suma ends here*/
	    }

		
		if(strSpecialityCode.length()==0) {
			sql="SELECT A.SPECIALITY_CODE SPECIALITY_CODE1 ,B.SHORT_DESC SPECIALITY_DESC1 FROM OT_SPECIALITY_ORDER_TYPES A,AM_SPECIALITY B WHERE ORDER_TYPE_CODE = ? and A.SPECIALITY_CODE=B.SPECIALITY_CODE";
			 pstmt = con.prepareStatement(sql);

			 pstmt.setString(1,strOrderTypeCode);
			 rs1=pstmt.executeQuery();
			 if(rs1.next()==true){
				 strSpecialityCode=rs1.getString("SPECIALITY_CODE1");
				 strSpeciality_temp=rs1.getString("SPECIALITY_DESC1");
			  }
			 if(rs1!=null)	rs1.close();
			 pstmt.close();					 
		}
		
		strWaitListNo=checkForNull(rs.getString("WAITLIST_NUM1"));
		strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
		strNatureType=checkForNull(rs.getString("NATURE_TYPE1"));	
		strEpisodeId=checkForNull(rs.getString("EPISODE_ID1"));
		strPatientClass=checkForNull(rs.getString("PATIENT_CLASS1"));
		strEncounterId=checkForNull(rs.getString("ENCOUNTER_ID1")); 
		strEpisodeType=checkForNull(rs.getString("EPISODE_TYPE1")); 
		strVisitId=checkForNull(rs.getString("VISIT_ID1"));
		strNatureCode= checkForNull(rs.getString("SURGERY_NATURE1"));
		strReferalSource=checkForNull(rs.getString("REF_SOURCE_TYPE1"));
		if(strReferalSource != null && strReferalSource.equals("R"))//GHL-CRF356
		strReferalSource = "E"; //GHL-CRF 356
		strRefSourceCode=checkForNull(rs.getString("REF_SOURCE_CODE1"));
		strAnesthesiaCode=checkForNull(rs.getString("ANAESTHESIA_CODE1")); 
		strAnaesthetistCode=checkForNull(rs.getString("ANAESTHETIST_CODE1")); 
		strPositionCode=checkForNull(rs.getString("PATIENT_POSITION1"));
		strPrefDate=checkForNull(rs.getString("PREF_SURG_DATE1"));
		rs.close();
		pstmt1.close();
	
	//pre-operative Diagnosis
	if(strOrderId.length()>0){
		sql="SELECT ORDER_COMMENT FROM OR_ORDER_COMMENT WHERE ORDER_ID = ? AND ACTION_SEQ_NUM=(SELECT MAX(ACTION_SEQ_NUM) FROM OR_ORDER_COMMENT WHERE ORDER_ID = ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strOrderId);
		pstmt.setString(2,strOrderId);
		rs1=pstmt.executeQuery();
		Clob clob= null;
		while(rs1.next()){
			clob = rs1.getClob("ORDER_COMMENT");
			strPreOperDiag = clob.getSubString(1,(int)clob.length());
		}
		rs1.close();
 		pstmt.close();
	
	}
		if(strPreOperDiag.length()>500)
	    strPreOperDiag=strPreOperDiag.substring(0,500);
//Anesthesia Desc

	if(strAnesthesiaCode.length()>0){
		strAnesthesia_temp=strAnesthesiaCode;
		sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT2");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strAnesthesiaCode);
		rs1=pstmt.executeQuery();
		if(rs1.next()==true)
  			strAnesthesia_temp1=checkForNull(rs1.getString("short_desc1"));
			rs1.close();
 			pstmt.close();
		}

		//Aneasthetist code
		if(strAnaesthetistCode.length()>0){
			strAnesthetit_temp=strAnaesthetistCode;
			sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT3");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,strFacilityId);
			pstmt.setString(2,strAnaesthetistCode);
			rs1=pstmt.executeQuery();
			if(rs1.next()==true)
			strAnesthetit_temp1=checkForNull(rs1.getString("short_name1"));
			rs1.close();
			pstmt.close();
		}
		sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT4");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strSurgeonCode);
		rs1=pstmt.executeQuery();
		if(rs1.next()==true)
		  strSurgeonName=checkForNull(rs1.getString("SHORT_NAME1"));
		rs1.close();
		pstmt.close();

	if(strNatureCode.length()>0){
		 sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT5");
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,locale);
		 pstmt.setString(2,strNatureCode);
		 rs1=pstmt.executeQuery();
		 if(rs1.next()==true)
		  strSurgeryType=rs1.getString("SHORT_DESC1");
		  rs1.close();
		  pstmt.close();
	 }

	if(strPositionCode.length()>0){
		String sql_position="SELECT SHORT_DESC SHORT_DESC1   FROM OT_POSITION_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(STATUS,'E') = 'E' and POSITION_CODE=?";
		sql=""+sql_position;
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,locale);
		 pstmt.setString(2,strPositionCode);
		 rs1=pstmt.executeQuery();
		 if(rs1.next()==true)
		 strPatientPosition=rs1.getString("SHORT_DESC1");
		 rs1.close();
		 pstmt.close();
	 }
	}          
  rs.close();
  pstmt1.close();
}

	//Added by Anitha on 12/6/2010 start
	String PreOpQuery = "select nvl(ORDER_FIELD_VALUE,0) PreOpPrepDays from or_order_field_values where order_id = '"+strOrderId+"' and ORDER_FIELD_MNEMONIC ='PRE_OP_DAYS'";
	pstmt=con.prepareStatement(PreOpQuery);
		 rs=pstmt.executeQuery();
		 while(rs.next() && rs!=null)
		{
		 PreOpPreparationDays   = (rs.getString("PreOpPrepDays")==null)?"":rs.getString("PreOpPrepDays");
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	//end
	//try{

		if(strPatientId!=null && !strPatientId.equals("")){
			if(strOrderId.length()==0){ // When called from Direct Booking, get the defaulted sourceType
				sourceTypeDesc=checkForNull(request.getParameter("changed_sourceTypeDesc"));
				strReferalSource=checkForNull(request.getParameter("changed_sourceType"));

			}

		if("IP".equals(strPatientClass) || "DC".equals(strPatientClass) ){
			sql="SELECT 'W',NVL(TO_NURSING_UNIT,  FR_NURSING_UNIT_CODE)   FROM IP_ADT_TRN WHERE PATIENT_ID 	= ? AND   FACILITY_ID = ? AND  TRN_TYPE IN ('A', 'D', 'T') AND   TRN_DATE_TIME = (SELECT MAX(TRN_DATE_TIME) FROM IP_ADT_TRN  WHERE PATIENT_ID = ? AND  FACILITY_ID = ?   AND TRN_TYPE IN ('A', 'D', 'T'))";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,strPatientId);
			pstmt.setString(2,strFacilityId);
			pstmt.setString(3,strPatientId);
			pstmt.setString(4,strFacilityId);
			rs=pstmt.executeQuery();
			if(rs.next())  {

				strReferalSource=checkForNull(rs.getString(1));
				strRefSourceCode=checkForNull(rs.getString(2));
			}
			if(rs!=null)	rs.close();	  
			pstmt.close();
		}
		/* start SKR-SCF-1095 [IN056871]*/
		if("OP".equals(strPatientClass) || "EM".equals(strPatientClass) ){
			sql="SELECT 'C', LOCN_CODE FROM op_patient_queue WHERE patient_id = ? AND facility_id = ? AND queue_status IN ('01', '02', '03','04','07','09','99') AND QUEUE_DATE = (SELECT MAX (QUEUE_DATE) FROM op_patient_queue WHERE patient_id = ? AND facility_id = ? AND queue_status IN ('01', '02', '03','04','07','09','99'))";
			//System.err.println("458,sql==="+sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,strPatientId);
			pstmt.setString(2,strFacilityId);
			pstmt.setString(3,strPatientId);
			pstmt.setString(4,strFacilityId);
			rs=pstmt.executeQuery();
			if(rs.next())  {
				strReferalSource=checkForNull(rs.getString(1));
				strRefSourceCode=checkForNull(rs.getString(2));
				//System.err.println("490,strReferalSource==="+strReferalSource);
				//System.err.println("491,strRefSourceCode==="+strRefSourceCode);
			}
			if(rs!=null)	rs.close();	  
			pstmt.close();
		}
		/* End SKR-SCF-1095 [IN056871]*/
	if( !strReferalSource.equals("") && !strRefSourceCode.equals("") )
	{
		if(strReferalSource.equals("W"))
			sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT7");
		else if(strReferalSource.equals("C")==true)
			sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT8");
		//else if(strReferalSource.equals("R")==true)////CRF- GHL356
		else if(strReferalSource.equals("E")==true)//CRF- GHL356
			//sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT9");
		sql="SELECT LONG_DESC  SHORT_DESC1 FROM AM_REFERRAL_LANG_VW  WHERE  LINKED_FACILITY_ID = ? and NVL(EFF_STATUS,'D') = 'E' AND  REFERRAL_CODE =? AND LANGUAGE_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strRefSourceCode);
		pstmt.setString(3,locale);
		rs=pstmt.executeQuery();
		if( rs.next() )
			strReferalDesc=rs.getString("SHORT_DESC1");
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
	}
	
	strName=checkForNull(request.getParameter("patient_name"));
	strAge=checkForNull(request.getParameter("date_of_birth"));
	strSex=checkForNull(request.getParameter("sex"));
	//strEncounterId=checkForNull(request.getParameter("encounter_id"));
	//strEpisodeId=checkForNull(request.getParameter("episode_id"));  commented by Sathish.K on 03-03-3009 for placing out patient order  From CA  properly(while placing Visiti Financial Details Could not found is coming..encounterid going as null)
	if(strName.length()==0){
		sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT10");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strPatientId);
		rs=pstmt.executeQuery();
		if(rs.next()){
		 strName=checkForNull(rs.getString("SHORT_NAME1"));
		 strAge=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));
		 strSex=checkForNull(rs.getString("SEX1"));
		}
		 if(strSex.equals("M")) 
			strSex=male;
		 else if(strSex.equals("F")) 
			strSex=female;
		 else   
			strSex=unknown;
		if(rs!=null)   rs.close();	  
		pstmt.close();
	if(strOrderId.length()>0){
		sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT11");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strPatientId);
		pstmt.setString(2,strFacilityId);	
		pstmt.setString(3,strPatientId);
		pstmt.setString(4,strFacilityId);	
		rs=pstmt.executeQuery();
		if(rs.next()==true){
			strEncounterId=checkForNull(rs.getString("ENCOUNTER_ID1"));
		}
		if(rs!=null) rs.close();
		pstmt.close();
   }
   /* selvin  */
	System.err.println("before,selSurgeonCode===="+selSurgeonCode);
   	if( selSurgeonCode.equals("*ALL") || selSurgeonCode.equals("") ) //selSurgeonCode
	{
		
		sql=" select ORD_PRACT_ID from or_order where order_id= ? ";
		System.err.println("sql 569===="+sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strOrderId);
		rs=pstmt.executeQuery();
		if( rs.next() ) {
		strOrderPract=rs.getString("ORD_PRACT_ID");
		selSurgeonCode = strOrderPract;
		}
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
	}
	
	System.err.println("After,selSurgeonCode===="+selSurgeonCode);
   

 }
 }  
	//Added Against ML-MMOH-CRF-1939-US2...starts
		
	String bean_id1 = "OTCommonBean";
	String bean_name1 = "eOT.OTCommonBean";
	OTCommonBean ot_bean = (OTCommonBean)mh.getBeanObject( bean_id1, request, bean_name1 );
	
	con = ConnectionManager.getConnection(request);
			
	//Include_Fpp_yn = bean.getIncludeFpp(facility_id);
	//System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
	isIncludeFpp = CommonBean.isSiteSpecific(con,"OT","OT_FPP");
	//isIncludeFpp=false;
	System.err.println("isIncludeFpp --->"+isIncludeFpp);
			
	//count = bean.getFppIcon();
	bill_flag = ot_bean.getBillFlag(strFacilityId);
	
    //Added Against ML-MMOH-CRF-1939-US2...ends
   }
   catch(Exception ee){  
	   ee.printStackTrace();
	   System.err.println("exception 2 in OperationProcedureHdr.jsp "+ee);
 }finally{
	if(rs!=null) rs.close();
	if(pstmt !=null) pstmt.close();
	   ConnectionManager.returnConnection(con, request);
}
   if(strEpisodeId.length()==0) strEpisodeId=strEncounterId;
   if(strEncounterId.length()==0)strEncounterId=strEpisodeId;
   if(strWaitListNo.length()==0)  
	strWaitListYN="N";
   else	
	strWaitListYN="";

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(performingLocation)));
            _bw.write(_wl_block14Bytes, _wl_block14);

	if(strOrderId.length()==0){

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(request.getParameter("start_time"))));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strSurgeryType));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
if(isIncludeFpp && bill_flag){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 
				sql = "SELECT PATIENT_CLASS,SHORT_DESC FROM AM_PATIENT_CLASS_LANG_VW WHERE LANGUAGE_ID= ? ORDER BY 1";
				try{
					con = ConnectionManager.getConnection(request);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					rs = pstmt.executeQuery();
					while(rs.next()){
			             patient_class_code=patient_class_code+rs.getString(1)+"$$";
			
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
				}catch(Exception e){e.printStackTrace();}
				finally{
					try{
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null)  ConnectionManager.returnConnection(con, request);
					}catch(Exception e){e.printStackTrace();}
				}
			
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(isIncludeFpp && bill_flag){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strName));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strAge));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strRoomDesc));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strSpeciality_temp));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strPatientPosition));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strPositionCode));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strAsstSurgeonCode));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strReferalSource));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(strReferalSource));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(sourceTypeDesc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(strReferalDesc));
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(strAnesthesia_temp1));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(strAnesthetit_temp1));
            _bw.write(_wl_block72Bytes, _wl_block72);
 if (strAnesReqYN.equals("Y")) { 
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
} else { 
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
 } 
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(strPreOperDiag));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
  if(strOrderId.length()>0){ 	
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
 }else{
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block85Bytes, _wl_block85);

	}else{ // Patient Line fields to be hidden 
		   // this part is for CA

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strName));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(strAge));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(strName));
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(request.getParameter("start_time"))));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strSurgeryType));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(strRoomDesc));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(strSpeciality_temp));
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(strAnesthetit_temp1));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(strAnesthesia_temp1));
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(strReferalSource));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

			if(strReferalSource.equals("E"))
				chkReferalDisable = "";
			else
				chkReferalDisable = "disabled";

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(strReferalDesc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(chkReferalDisable));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(chkReferalDisable));
            _bw.write(_wl_block116Bytes, _wl_block116);

			if(!strReferalSource.equals("E"))
			{

            _bw.write(_wl_block117Bytes, _wl_block117);

			}	

            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(strAsstSurgeonCode));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(strPatientPosition));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(strPositionCode));
            _bw.write(_wl_block123Bytes, _wl_block123);
 if (strAnesReqYNPending > 0) { 
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
} else { 
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
 } 
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(strPreOperDiag));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
  if(strOrderId.length()>0){ 	
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
 }else{
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
}
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);

	} // End of else for Patient Line Changes

            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(strWaitListNo));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(strRoomCode));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(strRoomDesc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(strSurgeonCode));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(selSurgeonCode));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(strSpecialityCode));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(strStartTime));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(strHiddenTime));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(strNatureCode));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(strNatureType));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(strNursingUnit));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(strRefSourceCode));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(strAnesthetit_temp));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(strAnesthesia_temp));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(selOrderIds));
            _bw.write(_wl_block155Bytes, _wl_block155);
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(ammendFlag));
            _bw.write(_wl_block155Bytes, _wl_block155);
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(selBookingNumber));
            _bw.write(_wl_block155Bytes, _wl_block155);
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(strPrefDate));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(strWaitListYN));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(strIpBookingYN));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(over_booking_case_yn));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(patient_class_code));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block168Bytes, _wl_block168);
 
		if(strOrderId.length()>0){
			out.println("<script language='javascript'>disableButton('"+chkReferalDisable+"');</script><Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>");
		}

            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(strReferalSource));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(or_bean_id));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(or_bean_name));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(ammendBooking));
            _bw.write(_wl_block176Bytes, _wl_block176);
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(PreOpPreparationDays));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(anaes_review1));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(isIncludeFpp));
            _bw.write(_wl_block180Bytes, _wl_block180);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PerformingLocation.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BookingDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SurgeryType.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateofBirth.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OperatingRoom.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPosition.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AsstSurgeon.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SourceType.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthesia.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthetist.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaReviewRequired.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaReviewRequired.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosisNew.Label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosisNew.Label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SurgeryType.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OperatingRoom.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthetist.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthesia.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SourceType.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referral.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AsstSurgeon.Label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPosition.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaReviewRequired.Label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaReviewRequired.Label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosisNew.Label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
