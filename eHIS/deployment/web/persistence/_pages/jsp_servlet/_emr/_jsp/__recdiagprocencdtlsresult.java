package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import webbeans.eCommon.*;
import java.text.*;
import java.sql.Date;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recdiagprocencdtlsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/recDiagProcEncDtlsResult.jsp", 1743671088213L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<Script>\n\tfunction getNext(flagSelect)\n\t{\n\t   var patientid\t\t= document.forms[0].patientid.value ;\n\t   var from\t\t\t\t= document.forms[0].from.value ;\n\t   var to\t\t\t\t= document.forms[0].to.value ;\t   \n\t   var flag\t\t\t\t= flagSelect ;\n\t   var previousRecord\t= document.forms[0].previousRecord.value;\n\t   var nextRecord\t\t= document.forms[0].nextRecord.value ;\n       var facility\t\t\t= document.forms[0].facility.value ;\n\t   var encounType\t\t= document.forms[0].encounType.value ;\n\t   var encounterID\t\t= document.forms[0].encounterID.value;\t   \n\t   var order_by\t\t\t= document.forms[0].order_by.value;\n\t   \n\t   document.location.href=\'../../eMR/jsp/vwEncounterDetailResult.jsp?from=\' + from + \'&to=\' + to + \'&facility=\' + facility + \'&patientid=\' +  patientid +\'&flag=\' + flag + \'&nextRecord=\' + nextRecord+\'&previousRecord=\' + previousRecord +\n\t   \'&facility=\' +  facility + \'&encounType=\' + encounType +\'&encounterID=\' +encounterID+\'&order_by=\' + order_by ;\n\t}\n\n\n\tasync function viewReferral(ref)\n\t\t\t{\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= \"34vh\" ;\n\t\t\t\tvar dialogTop = \"57vw\" ;\n\t\t\t\tvar dialogWidth\t= \"50\" ;\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status  + \"; dialogTop :\" + dialogTop ;\n\t\t\t\tvar retVal = await window.showModalDialog(\"../../eOP/jsp/ViewPatReferral.jsp?referral_id=\"+ref,arguments,features);\n\t\t\t}\n\t\n\n\nasync function view_appt_dtl(ref_no){\n    \n    var retVal =    new String();\n    var dialogHeight= \"30vh\" ;\n    var dialogWidth = \"50vw\" ;\n    var dialogTop = \"100\" ;\n    var center = \"1\" ;\n    var status=\"no\";\n    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n    var arguments   = \"\" ;\n    retVal = await window.showModalDialog(\"../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no=\"+ref_no+\"&flag=Visit_Reg\",arguments,features);\n    }\n\n\n\n\n </Script>\n\n<head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t<script>\n\n\t\tasync function GetShowRemarks(name,remarksvalue,remarkstype)\n\t\t{\n\t\t\tvar comments;\n\t\t\tvar inputArr = document.getElementsByTagName(\"input\");\n\t\t\tfor (u=0;u<inputArr.length;u++)\n\t\t\t{\n\t\t\t\tif (inputArr[u].name == name)\n\t\t\t\t{\n\t\t\t\t\tcomments = inputArr[u].value;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tvar retVal;\n\t\t\tvar dialogHeight =\'9vh\' ;\n\t\t\tvar dialogWidth = \'30vw\' ;\n\t\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; scroll=no; status=no\';\n\t\t\tvar arguments;\n\n\t\t\t   if(comments==\'\' || comments == \"null\")\n\t\t\t\t  comments =\'\';\n\t\t\t\targuments = comments ;\n\n\t\t\tretVal =await  window.showModalDialog(\'../../eFM/jsp/GetShowRemarks.jsp?title=Return Remarks&RemarksValue=\'+escape(remarksvalue)+\'&RemarksType=\'+remarkstype,arguments,features);\n\n\t\t\t\tfor (u=0;u<inputArr.length;u++){\n\t\t\t\t\tif (inputArr[u].name == name){\n\t\t\t\t\t\tinputArr[u].value = \'\'+retVal+\'\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t}\n\n\t\tasync function Openrecordwin(functionid,episodeid,visitid,locncode,locntype,bednum,roomnum,dischgedate,visitadmdate,episodestatus,patientclass,seclevel,protectionind,ip_practitioner_id)\n\t\t{\n\t\t\t\n\t\t\tvar patientid=document.getElementById(\"patientid\").value;\t\t\t\t\n\t\t\tvar episodetype=\"\";\t\t\n\t\t\tvar gender=document.getElementById(\"patient_sex\").value;\t\t\t\n\t\t\tvar age=document.getElementById(\"patient_age\").value;\t\t\t\n\t\t\tvar dob=document.getElementById(\"dob\").value;\t\t\t\n\t\t\tif(patientclass == \"IP\")\n\t\t\t{\n\t\t\t\t\tepisodetype = \"I\";\n\n\t\t\t}\n\t\t\telse if(patientclass == \"OP\" )\n\t\t\t{\n\t\t\t\tepisodetype=\"O\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tepisodetype=\"O\";\n\t\t\t}\n\t\t\t\n\t\t\tvar relnreqyn=\"\";\n\t\t\tvar pq=\"\";\n\t\t\tvar ca=\"\";\n\t\t\tvar mode=\"\";\n\n\n\n\t\t\t\n\t\t\tvar dialogHeight =\'26vh\' ;\n\t\t\tvar dialogWidth = \'45vw\' ;\n\t\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; scroll=no; status=no\';\n\t\t\tvar arguments;\n\t\t\t\n\t\t\t\n\t\t\tif(functionid == \"RECORD_PROCEDURE\")\n\t\t\t{\n\t\t\t\tretVal =await window.showModalDialog(\'../../eCA/jsp/PatProcRecord.jsp?option_id=\'+functionid+\'&patient_id=\'+patientid+\'&visit_id=\'+visitid+\'&episode_id=\'+episodeid+\'&location_code=\'+locncode+\'&location_type=\'+locntype+\'&bed_num=\'+bednum+\'&room_num=\'+roomnum+\'&episode_type=\'+episodetype+\'&discharge_date=\'+dischgedate+\'&visit_adm_date=\'+visitadmdate+\'&episode_Status=\'+episodestatus+\'&Sex=\'+gender+\'&ip_practitioner_id=\'+ip_practitioner_id+\'&Age=\'+age+\'&Dob=\'+dob+\'&security_level=\'+seclevel+\'&protection_ind=\'+protectionind+\'&reln_req_yn=Y&IP_YN=Y&modal_yn=Y&patient_class=\'+patientclass+\'&PQ=Y&CA=N&mode=R\',arguments,features);\n\t\t\t}\n\t\t\telse if (functionid == \"DIAGNOSES\")\n\t\t\t{\n\t\t\t\tretVal = await window.showModalDialog(\'../../eCA/jsp/PatProblemMain.jsp?option_id=\'+functionid+\'&patient_id=\'+patientid+\'&visit_id=\'+visitid+\'&episode_id=\'+episodeid+\'&location_code\'+locncode+\'&location_type=\'+locntype+\'&bed_num=\'+bednum+\'&room_num=\'+roomnum+\'&episode_type=\'+episodetype+\'&discharge_date=\'+dischgedate+\'&visit_adm_date=\'+visitadmdate+\'&episode_Status=\'+episodestatus+\'&Sex=\'+gender+\'&ip_practitioner_id=\'+ip_practitioner_id+\'&Age=\'+age+\'&Dob=\'+dob+\'&security_level=\'+seclevel+\'&protection_ind=\'+protectionind+\'&reln_req_yn=Y&IP_YN=Y&patient_class=\'+patientclass+\'&PQ=Y&CA=N&mode=R\',arguments,features);\n\t\t\t}\n\t\t}\n\t</script>\n <head>\n\n <BODY onMouseDown=\"CodeArrest();\" onKeyDown=\'lockKey()\'>\n <form name=\"EncounterResultForm\" id=\"EncounterResultForm\" action=\"../../eMR/jsp/vwEncounterDetailResult.jsp\" method=\"post\" \t>\n\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t  \t<script>\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t//  parent.frames[1].document.forms[0].search[1].disabled=false;\n\n\t\tparent.frames[2]. location.href =\"../../eCommon/html/blank.html\" ;\n\t\t</script>\n\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n \n\n\t\t\t<table align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\n\n\t\t\t</td>\n\n\n\t\t</tr>\n\n\t</table>\n\t\t<br><br>\n\n\n\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\">\n\n\t<tr>\n\t\t<td >\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</td>\n\t</tr>\n\t<!-- <tr><td  class=\'BODYCOLORFILLED\' colspan=\'3\'>&nbsp;</td></tr> -->\n\t\t\n \t\t</table>\n\n\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\">\n\t\n\t<tr >\n\t\t<th rowspan=\"2\" height=\"15\" width=\'10%\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </th>\n\t\t<th rowspan=\"2\" height=\"15\" width=\'10%\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t<th rowspan=\"2\" height=\"15\" width=\'10%\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\t\t\n\t\t</tr>\t\t\n\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\n\t\t\t<tr></tr>\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<td  height=\"20\"  class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'><font size=1>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\n\t\t\t<td  height=\"20\" class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' ><font size=1> ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\n\t\t\t<td  height=\"20\" class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"><font size=1>\n\t\t \t<a href=\"javascript:Openrecordwin(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\t\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\" >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</a>\t\t\n\t\t\t</td>\n\n\t\t\t<td  height=\"20\" class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"><font size=1>\n\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t</td>\n\n\t\t\t<td  height=\"20\" class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" nowrap><font size=1>\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n\t\t\t<td  height=\"20\" class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t</td>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<td  height=\"20\" class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\n\t\t\t</td>\t\t\t\n\t\t\t</tr>\n       ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t</table>\n\n\n ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n  \n  <input type=\'hidden\' name=\'flag\' id=\'flag\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' > \n  <input type=\'hidden\' name=\'noOfRecords\' id=\'noOfRecords\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' >\n  <input type=\'hidden\' name=\'facility\' id=\'facility\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' >\n  <input type=\'hidden\' name=\'from\' id=\'from\' value=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" >\n  <input type=\'hidden\' name=\'to\' id=\'to\' value=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" >\n  <input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" >\n  <input type=\'hidden\' name=\'order_by\' id=\'order_by\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n  <input type=\'hidden\' name=\'encounterID\' id=\'encounterID\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n  <input type=\'hidden\' name=\'encounType\' id=\'encounType\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>  \n  <input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\' name=\'assgn_care_locn_code\' id=\'assgn_care_locn_code\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' >\n<input type=\'hidden\' name=\'assgn_care_locn_type\' id=\'assgn_care_locn_type\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >\n<input type=\'hidden\' name=\'bed_num\' id=\'bed_num\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' >\n<input type=\'hidden\' name=\'room_num\' id=\'room_num\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' >\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' >\n<input type=\'hidden\' name=\'discharge_date\' id=\'discharge_date\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' >\n<input type=\'hidden\' name=\'visit_adm_date_time\' id=\'visit_adm_date_time\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' >\n<input type=\'hidden\' name=\'episode_status\' id=\'episode_status\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' >\n<input type=\'hidden\' name=\'patient_age\' id=\'patient_age\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' >\n<input type=\'hidden\' name=\'patient_sex\' id=\'patient_sex\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' >\n<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' >\n<input type=\'hidden\' name=\'sec_level\' id=\'sec_level\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' >\n<input type=\'hidden\' name=\'protection_ind\' id=\'protection_ind\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' >\n<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' >\n\n </form>\n </body>\n </html>\n\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		String locale			= (String)session.getAttribute("LOCALE");
		Connection con = ConnectionManager.getConnection(request);
		
		ResultSet rset	= null ;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
	//	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy") ;

	//	String queryCriteria	= (request.getParameter("criteria")==null)?"":request.getParameter("criteria") ;
		String flag				=
		(request.getParameter("flag")==null)?"":request.getParameter("flag");
		String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility") ;		
		String from				= request.getParameter("from") ;
		String to				= request.getParameter("to");
		String fromdate=(request.getParameter("fromdate")==null)?"":request.getParameter("fromdate");
		String todate=(request.getParameter("todate")==null)?"":request.getParameter("todate");
		String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;		
		String encounType		= (request.getParameter("encounType")==null)?"":request.getParameter("encounType") ;
		String encounterID		= (request.getParameter("encounterID")==null)?"":request.getParameter("encounterID") ;
		String order_by		= (request.getParameter("order_by")==null)?"":request.getParameter("order_by") ;	

		String function_id= (request.getParameter("function_id")==null)?"":request.getParameter("function_id") ;	
		//String whereClause =(request.getParameter("whereclause")==null)?"":request.getParameter("whereclause") ;
			
		int noOfRecords			= 0  ;
		int start = 0 ;
		int end = 0 ;
		//String sqlCriteria		= "" ;
		String sql				= "" ;
		String classValue		="";//p_req_remarks="",p_iss_remarks="";
		String episodeid="";
		String assgncarelocncode="";
		String assgncarelocntype="";
		String bednum="";
		String roomnum="";
		//String episodetype="";
		String episodestatus="";
		String patientclass="";
		String dischargedate="";
		String visitadndatetime="";
		String gender="";
		String age="";
		String dob="";
		String valstr="";
		String seclevel="";
		String protectionind="";
		String visitid=""; 
		String ip_practitioner_id="";

		  if ( from == null )
	  {
        start = 1 ;
	  }
    else
	  {		
        start = Integer.parseInt( from ) ;
	  }

    if ( to == null )
	  {
        end = 12 ;
	  }
    else
	  {		
        end = Integer.parseInt( to ) ;
	  }
/*
	  if(fromdate != null)
			fromdate="'"+fromdate+"'";

	if(todate != null)
			todate="'"+todate+"'";
*/
	  try{		  

	  

sql="select count(*) as total FROM PR_ENCOUNTER A	,AM_CARE_LOCN_TYPE B ,OP_CLINIC C,IP_NURSING_UNIT D	,AM_PRACTITIONER E	,AM_PATIENT_CLASS F	,IP_DISCHARGE_TYPE G,AM_DISPOSITION_TYPE H  ,op_episode_for_service i WHERE A.FACILITY_ID= '" +facility + "' AND A.ENCOUNTER_ID = nvl('"+encounterID+"',A.ENCOUNTER_ID) AND A.PATIENT_ID= '" +patientid + "' AND A.ASSIGN_CARE_LOCN_TYPE	= B.LOCN_TYPE AND A.FACILITY_ID	= C.FACILITY_ID (+) AND A.ASSIGN_CARE_LOCN_CODE  = C.CLINIC_CODE (+) AND A.FACILITY_ID	= C.FACILITY_ID (+) AND A.ASSIGN_CARE_LOCN_CODE  = D.NURSING_UNIT_CODE (+) AND A.ATTEND_PRACTITIONER_ID = E.PRACTITIONER_ID (+) AND A.PATIENT_CLASS  = F.PATIENT_CLASS AND A.DISPOSITION_TYPE = G.DISCHARGE_TYPE_CODE (+) AND A.DISPOSITION_TYPE = H.DISP_TYPE (+) AND TRUNC( A.VISIT_ADM_DATE_TIME) BETWEEN    " +
"NVL( TO_DATE('"+  fromdate + "', 'dd/MM/yyyy'),TO_DATE('01/01/1900','dd/MM/yyyy')) AND " +
"NVL( TO_DATE('"+  todate + "', 'dd/MM/yyyy'),TO_DATE('31/12/5000','dd/MM/yyyy')) AND A.PATIENT_CLASS=decode('"+encounType + "','',A.PATIENT_CLASS,'"+encounType + "') and a.patient_id=i.patient_id and a.episode_id=i.episode_id and a.visit_status < '08' ";

pstmt=con.prepareStatement(sql);
rset=pstmt.executeQuery();
if(rset != null)
{
	if(rset.next())
	{
		noOfRecords=rset.getInt("total");
	}
}
 if(pstmt != null) pstmt.close();
	  if(rset != null) rset.close();
	 	

 sql="SELECT A.ENCOUNTER_ID ,to_char(A.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE_TIME, A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE,A.ASSIGN_CARE_LOCN_TYPE ASSIGN_CARE_LOCN_TYPE ,B.SHORT_DESC ASSIGN_CARE_LOCN_TYPE_DESC, A.ASSIGN_CARE_LOCN_CODE ASSIGN_CARE_LOCN_CODE ,DECODE(A.ASSIGN_CARE_LOCN_TYPE, 'C', C.SHORT_DESC, 'N', D.SHORT_DESC) ASSIGN_CARE_LOCN_DESC ,A.ASSIGN_ROOM_NUM, A.ASSIGN_BED_NUM,  A.ATTEND_PRACTITIONER_ID ,E.PRACTITIONER_NAME ,A.APPT_ID ,A.PATIENT_CLASS patient_class ,F.SHORT_DESC PATIENT_CLASS_DESC ,A.DISPOSITION_TYPE ,DECODE(A.PATIENT_CLASS, 'IP', G.SHORT_DESC, H.SHORT_DESC) DISPOSITION_TYPE_DESC ,to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME ,A.DISP_REFERRAL_ID,a.episode_id episode_id, i.episode_status episode_status,a.security_level security_level,a.protection_ind protection_ind,a.op_episode_visit_num op_episode_visit_num FROM PR_ENCOUNTER A	,AM_CARE_LOCN_TYPE B ,OP_CLINIC C,IP_NURSING_UNIT D	,AM_PRACTITIONER E	,AM_PATIENT_CLASS F	,IP_DISCHARGE_TYPE G,AM_DISPOSITION_TYPE H  ,op_episode_for_service i WHERE A.FACILITY_ID= '" +facility + "' AND A.ENCOUNTER_ID = nvl('"+encounterID+"',A.ENCOUNTER_ID) AND A.PATIENT_ID= '" +patientid + "' AND A.ASSIGN_CARE_LOCN_TYPE	= B.LOCN_TYPE AND A.FACILITY_ID	= C.FACILITY_ID (+) AND A.ASSIGN_CARE_LOCN_CODE  = C.CLINIC_CODE (+) AND A.FACILITY_ID	= C.FACILITY_ID (+) AND A.ASSIGN_CARE_LOCN_CODE  = D.NURSING_UNIT_CODE (+) AND A.ATTEND_PRACTITIONER_ID = E.PRACTITIONER_ID (+) AND A.PATIENT_CLASS  = F.PATIENT_CLASS AND A.DISPOSITION_TYPE = G.DISCHARGE_TYPE_CODE (+) AND A.DISPOSITION_TYPE = H.DISP_TYPE (+) AND TRUNC( A.VISIT_ADM_DATE_TIME) BETWEEN    " +
"NVL( TO_DATE('"+  fromdate + "', 'dd/MM/yyyy'),TO_DATE('01/01/1900','dd/MM/yyyy')) AND " +
"NVL( TO_DATE('"+  todate + "', 'dd/MM/yyyy'),TO_DATE('31/12/5000','dd/MM/yyyy')) AND A.PATIENT_CLASS=decode('"+encounType + "','',A.PATIENT_CLASS,'"+encounType + "') and a.patient_id=i.patient_id and a.episode_id=i.episode_id and a.visit_status < '08' ORDER BY " +order_by + " DESC, ENCOUNTER_DATE DESC";

pstmt= con.prepareStatement(sql);

rset = pstmt.executeQuery() ;

	  if (noOfRecords== 0)
	  {
	  
            _bw.write(_wl_block10Bytes, _wl_block10);

	  }
 	  else
	  {
	
            _bw.write(_wl_block11Bytes, _wl_block11);

				if ( !(start <= 1) )
		  {
	//out.println("<A HREF='../../eOP/jsp/ConcludeEpisodeResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	out.println("<A href='../../eMR/jsp/recDiagProcEncDtlsResult.jsp?from="+(start-12)+"&to="+(end-12)+"&fromdate=" + fromdate + "&todate=" + todate+"&patientid=" +  patientid +"&flag=next&encounType=" + encounType +"&facility=" + facility + "&order_by=" + order_by +"&encounterID=" + encounterID + "&function_id="+function_id+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	
		  }

if ( !( (start+14) > noOfRecords ) )
		  {
	//out.println("<A HREF='../../eOP/jsp/ConcludeEpisodeResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	out.println("<A href='../../eMR/jsp/recDiagProcEncDtlsResult.jsp?from="+(start+12)+"&to="+(end+12)+"&fromdate=" + fromdate + "&todate=" + todate+"&patientid=" +  patientid +"&flag=next&encounType=" + encounType +"&facility=" + facility + "&order_by=" + order_by +"&encounterID=" + encounterID + "&function_id="+function_id+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		  }
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(patientid
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		int i = 1;
		if(rset != null)
		  {
			 if ( start != 1 )
				{
					 for( int k=1; k<start; i++,k++ )
					 {
					  rset.next() ;
					 }
				}

		while(rset.next() && i <= end) 
		{
			
		//counter++ ;
		if ( i % 2 == 0 )
		  	classValue = "QRYODD" ;
		else
		  	classValue = "QRYEVEN" ;
		
            _bw.write(_wl_block19Bytes, _wl_block19);

			visitadndatetime=(rset.getString("VISIT_ADM_DATE_TIME"));
		episodeid=rset.getString("episode_id");	
		visitid=rset.getString("op_episode_visit_num");
		assgncarelocncode=rset.getString("ASSIGN_CARE_LOCN_CODE");
			assgncarelocntype=rset.getString("ASSIGN_CARE_LOCN_TYPE");
			dischargedate=rset.getString("DISCHARGE_DATE_TIME");
			episodestatus=rset.getString("episode_status");
			patientclass=rset.getString("patient_class");	
			seclevel=rset.getString("security_level");
			protectionind=rset.getString("protection_ind");
			roomnum=rset.getString("ASSIGN_ROOM_NUM");
			bednum=rset.getString("ASSIGN_BED_NUM");
			
			ip_practitioner_id=rset.getString("ATTEND_PRACTITIONER_ID");
			if(ip_practitioner_id==null) ip_practitioner_id="";

			
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((visitadndatetime==null)?"&nbsp;"
			:visitadndatetime));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((rset.getString("PATIENT_CLASS_DESC")==null)?"&nbsp;":rset.getString("PATIENT_CLASS_DESC")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(episodeid));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(visitid));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(assgncarelocncode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(assgncarelocntype));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bednum));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(roomnum));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dischargedate));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(visitadndatetime));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(episodestatus));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(seclevel));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(protectionind));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ip_practitioner_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((rset.getString("ENCOUNTER_ID")==null)?"&nbsp;":rset.getString("ENCOUNTER_ID")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((rset.getString("ASSIGN_CARE_LOCN_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_DESC")));
            _bw.write(_wl_block33Bytes, _wl_block33);

				
				
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((roomnum==null)?"&nbsp;":roomnum));
            _bw.write(_wl_block35Bytes, _wl_block35);

				

				
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((bednum==null)?"&nbsp;":bednum));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((rset.getString("PRACTITIONER_NAME")==null)?"&nbsp;":rset.getString("PRACTITIONER_NAME")
				));
            _bw.write(_wl_block37Bytes, _wl_block37);
		

			pstmt1=con.prepareStatement("select get_patient.get_line_detail(?,?) Pline FROM dual");
			pstmt1.setString(1,patientid);
			pstmt1.setString(2,locale);
			rs=pstmt1.executeQuery();
			rs.next();
			valstr=rs.getString(1);
			StringTokenizer strval=new StringTokenizer(valstr,"|");
			String nval=strval.nextToken();
			String ival="";
			ival=strval.nextToken();
			String noval="";
			String Patientname="";
			

			if(nval != null || !nval.equals(""))
			{
				strval=new StringTokenizer(nval,",");
				if(strval.countTokens() == 4)
				{
				noval=strval.nextToken();
				}
					Patientname=strval.nextToken();
				age=strval.nextToken();
				gender=strval.nextToken();

			}

			if(pstmt1 != null) pstmt1.close();
			if(rs != null) rs.close();

			pstmt1=con.prepareStatement("select to_char(date_of_birth,'dd/mm/yyyy') from mp_patient where patient_id='"+patientid+"'");
			rs=pstmt1.executeQuery();
			rs.next();
			dob=rs.getString(1);

			if(pstmt1 != null) pstmt1.close();
			if(rs != null) rs.close();			
 
  	i++;
  }
	  }
	  }
	  if ( pstmt != null )  pstmt.close();
	
            _bw.write(_wl_block38Bytes, _wl_block38);
}catch(Exception e)
	{
		//out.println("Exception while fetching connection :" + e) ;
		e.printStackTrace();
	}finally{
            _bw.write(_wl_block39Bytes, _wl_block39);

	if(rset!=null) rset.close();
	
	ConnectionManager.returnConnection(con, request);
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(noOfRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(from));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(to));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(encounType));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(episodeid));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(assgncarelocncode));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(assgncarelocntype));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bednum));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(roomnum));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(dischargedate));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(visitadndatetime));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(episodestatus));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(age));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(seclevel));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(protectionind));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(visitid));
            _bw.write(_wl_block65Bytes, _wl_block65);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdatetime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
}
