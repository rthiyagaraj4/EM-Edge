package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __patientvaluablesdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/PatientValuablesDtls.jsp", 1732179838138L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<script>\n\nfunction chkDateVal(obj)\n{\n\tif(obj.value != \'\' )\n\t{\n\t\tif(!doDateTimeChk(obj))\n\t\t{\n\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\'SM\'));\n\t\t\tobj.value = \"\";\n\t\t\tobj.focus();\n\t\t\treturn;\n\t\t}\n\t}\n}\nfunction checkFromDate(obj)\n{\n\tif(validDateObj(obj,\'DMYHM\',localeName))\n\t{\n\t\tvar next_exe_date = convertDate(obj.value,\'DMYHM\',localeName,\'en\');\n\t\tvar sysdate1 = convertDate(document.forms[0].recordedTime.value,\'DMYHM\',localeName,\'en\');\n\t\tif(!isAfter(next_exe_date,sysdate1,\'DMYHM\',\'en\'))\n\t\t{\n\t\t\tvar error=getMessage(\"MRDATE1_LT_DATE2\",\'MR\');\n\t\t\terror = error.replace(\'$\', getLabel(\"Common.returndatetime.label\",\"Common\"));\n\t\t\terror = error.replace(\'#\', getLabel(\"Common.recordeddatetime.label\",\"Common\"));\n\t\t\talert(error);\n\t\t\tobj.value = \'\';\n\t\t\tobj.focus();\n\t\t\tobj.select();\n\t\t\treturn false;\n\t\t}\n\t\telse if(!isBeforeNow(next_exe_date,\'DMYHM\',\'en\'))\n\t\t{\n\t\t\tvar error=getMessage(\"MRDATE1_GT_DATE2\",\'MR\');\n\t\t\terror = error.replace(\'$\', getLabel(\"Common.returndatetime.label\",\"Common\"));\n\t\t\terror = error.replace(\'#\', getLabel(\"Common.SystemDate.label\",\"Common\"));\n\t\t\talert(error);\n\t\t\tobj.value = \'\';\n\t\t\tobj.focus();\n\t\t\tobj.select();\n\t\t\treturn false;\n\t\t}\n\t}\n}\n\n\nfunction callReturned_chk(obj)\n{\n  if(obj.checked==true)\n\t{\n\t  obj.value=\"Y\";\n\t\t\tdocument.forms[0].returnedby_desc.disabled  =false;\n\t\t\tdocument.forms[0].button1.disabled\t\t\t=false;\n\t\t\tdocument.forms[0].returnedby.disabled\t\t=false;\n\n\t\t\tdocument.forms[0].witness_desc.disabled\t\t=false;\n\t\t\tdocument.forms[0].button2.disabled\t\t\t=false;\n\t\t\tdocument.forms[0].witnessid.disabled\t\t=false;\n\n\t\t\tdocument.forms[0].returned_datetime.disabled=false;\n\t\t\tdocument.getElementById(\"rel_img\").disabled\t\t\t\t\t=false;\n\t\t    document.getElementById(\"mand_gif1\").style.visibility  = \"visible\";\n\t\t    document.getElementById(\"mand_gif2\").style.visibility  = \"visible\";\n\t\t    document.getElementById(\"mand_gif3\").style.visibility  = \"visible\";\n\t}\n  else\n\t{\n\t  obj.value=\"N\";\n\t        document.forms[0].returnedby_desc.disabled  =true;\n\t\t\tdocument.forms[0].button1.disabled\t\t\t=true;\n\t\t\tdocument.forms[0].returnedby.disabled\t\t=true;\n\n\t\t\tdocument.forms[0].witness_desc.disabled\t\t=true;\n\t\t\tdocument.forms[0].button2.disabled\t\t\t=true;\n\t\t\tdocument.forms[0].witnessid.disabled\t\t=true;\n\n\t\t\tdocument.forms[0].returned_datetime.disabled=true;\n\t\t\tdocument.getElementById(\"rel_img\").disabled\t\t\t\t\t=true;\n\n\t\t\tdocument.forms[0].returnedby_desc.value=\'\';\n            document.forms[0].returnedby.value=\'\';\n\t\t\tif(document.forms[0].witness_id.value == \'\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].witness_desc.value=\'\';\n\t\t\t\tdocument.forms[0].witnessid.value=\'\';\n\t\t\t}\n\t\t\tdocument.forms[0].returned_datetime.value=\'\';\n\n\n\t    document.getElementById(\"mand_gif1\").style.visibility = \"hidden\";\n\t\tdocument.getElementById(\"mand_gif2\").style.visibility = \"hidden\";\n\t\tdocument.getElementById(\"mand_gif3\").style.visibility = \"hidden\";\n\t}\n}\n\nasync function callReturnby()\n{\n\t\n\tvar locale=document.forms[0].locale.value;\n\tvar val_txt=document.forms[0].returnedby_desc.value\n\tvar retVal =    new String();\n\tvar argumentArray  = new Array() ;\n\tvar dataNameArray  = new Array() ;\n\tvar dataValueArray = new Array() ;\n\tvar dataTypeArray  = new Array() ;\n\tvar tit=\"\";\t\t\t\t\n\ttit=getLabel(\"Common.returnedby.label\",\"Common\");\n\t//sql=\"select appl_user_id code,appl_user_name description  from sm_appl_user where upper(appl_user_name)  like upper(?) and upper(appl_user_id ) like upper(?)\";\n\tsql=\"select appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where upper(appl_user_id)  like upper(?) and upper(appl_user_name) like upper(?) and language_id=\'\"+locale+\"\' and eff_status=\'E\' \";\n\t\n\targumentArray[0] = sql;\n\targumentArray[1] = dataNameArray ;\n\targumentArray[2] = dataValueArray ;\n\targumentArray[3] = dataTypeArray ;\n\targumentArray[4] = \"1,2\";\n\targumentArray[5] = val_txt;\n\targumentArray[6] = DESC_LINK  ;\n\targumentArray[7] = DESC_CODE ;\n\tretVal = await CommonLookup( tit,argumentArray);\n\tif(retVal != null && retVal != \"\" )\n\t\t\t{\n\t\tvar ret1=unescape(retVal);\n\t\t\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].returnedby_desc.value=arr[1];\n\t\tdocument.forms[0].returnedby.value=arr[0];\n\t\t//alert(\"returnedby value in mr===\"+document.forms[0].returnedby.value);\n\t}\n}\n\n\nasync function callwitness()\n{\n\tvar locale=document.forms[0].locale.value;\n\tvar val_txt=document.forms[0].witness_desc.value\n\tvar retVal =    new String();\n\tvar argumentArray  = new Array() ;\n\tvar dataNameArray  = new Array() ;\n\tvar dataValueArray = new Array() ;\n\tvar dataTypeArray  = new Array() ;\n\tvar tit=getLabel(\"Common.returned.label\",\"Common\")+\" \"+getLabel(\"Common.Witness.label\",\"Common\");\n\n\tsql=\"select appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where UPPER(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and language_id=\'\"+locale+\"\' and eff_status=\'E\' \";\n\t\n\targumentArray[0] = sql;\n\targumentArray[1] = dataNameArray ;\n\targumentArray[2] = dataValueArray ;\n\targumentArray[3] = dataTypeArray ;\n\targumentArray[4] = \"1,2\";\n\targumentArray[5] = val_txt;\n\targumentArray[6] = DESC_LINK  ;\n\targumentArray[7] = DESC_CODE ;\n\tretVal = await CommonLookup( tit,argumentArray);\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\t\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].witness_desc.value=arr[1];\n\t\tdocument.forms[0].witnessid.value=arr[0];\n\t\n\t\t \n\t}\n}\n\n\nfunction getPractitionerId(obj,target)\n{\n\tvar practName_FName=\"\";\n\tvar practName_FValue=\"\";\n\tvar practId_FName=\"\";\n\n\tpractName_FName=target.name;\n\tpractName_FValue=target.value;\n\tpractId_FName\t= document.forms[0].witnessid.name;\n\n\tvar facility_id\t= document.forms[0].facilityId.value;\n\n\tgetPractitioner(obj, target,facility_id,\"Q2\");\n\n\t/*\n\tvar sql = \"Select a.practitioner_id practitioner_id,a.practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,\'M\',\'Male\',\'F\',\'Female\',\'U\',\'Unknown\') gender, DECODE(b.job_title,\'CC\',\'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr. Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\',\'Trainee\' ) job_title from am_pract_for_facility_vw a, am_practitioner b, am_pract_type d, am_speciality e  WHERE a.practitioner_id = b.practitioner_id and b.primary_speciality_code = e.speciality_code and  b.pract_type = d.pract_type and b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR   UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL) AND operating_facility_id= \'\"+facility_id+\"\'\";\n\tvar sql2 = \"Select a.practitioner_id practitioner_id,a.practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,\'M\',\'Male\',\'F\',\'Female\',\'U\',\'Unknown\') gender, DECODE(b.job_title,\'CC\',\'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr. Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\',\'Trainee\' ) job_title from am_pract_for_facility_vw a, am_practitioner b, am_pract_type d, am_speciality e  WHERE a.practitioner_id = b.practitioner_id and b.primary_speciality_code = e.speciality_code and  b.pract_type = d.pract_type and b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND   UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL) AND operating_facility_id= \'\"+facility_id+\"\'\";\n\n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\txmlStr\t=\"<root><SEARCH \" ;\n\txmlStr += \" practName_FName=\\\"\" +practName_FName + \"\\\"\";\n\txmlStr += \" practName_FValue=\\\"\" + encodeURIComponent(practName_FValue) + \"\\\"\";\n\txmlStr += \" sql=\\\"\" +escape(sql)+ \"\\\"\";\n\txmlStr += \" sqlSec=\\\"\" +escape(sql2)+ \"\\\"\";\n\txmlStr += \" practitioner_type=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" specialty_code=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" job_title=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" gender=\\\"\" + \"\" + \"\\\"\";\n\txmlStr +=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\txmlHttp.send(xmlDoc);\n\tresponseText=xmlHttp.responseText;\n\tresponseText = trimString(responseText);\n\teval(responseText);\t\n\n\t*/\n\n\n\n} // End of getPractitioner();\n\n// To set the values to Attending Practitioner when using  \n// GeneralPratitionerLookup. It\'ll be called by the GeneralPratitionerLookup.\nfunction PractLookupRetVal(retVal,objName)\n{\n\tvar arr;\n\t\tif (retVal != null)\n\t\t{\n\t\t\tarr=retVal.split(\"~\");\n\t\t\tdocument.forms[0].witnessid.value=arr[0];\n\t\t\tdocument.forms[0].witness_desc.value=arr[1];\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].witnessid.value=\"\";\n\t\t\tdocument.forms[0].witness_desc.value=\"\";\t\t\t\n\t\t\tdocument.forms[0].witness_desc.focus();\n\t\t}\n\t\t\n} // End of PractLookupRetVal().\n\nasync function receivedcallwitness()\n{\n\tvar locale=document.forms[0].locale.value;\n\tvar val_txt=document.forms[0].received_witness_desc.value\t\n\t\t\n\t\n\tvar retVal =    new String();\n\tvar argumentArray  = new Array() ;\n\tvar dataNameArray  = new Array() ;\n\tvar dataValueArray = new Array() ;\n\tvar dataTypeArray  = new Array() ;\n\tvar tit=getLabel(\"Common.received.label\",\"Common\")+\" \"+ getLabel(\"Common.Witness.label\",\"Common\");\n\n\tsql=\"select appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where UPPER(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) and language_id=\'\"+locale+\"\' and eff_status=\'E\' \";\n\t\n\targumentArray[0] = sql;\n\targumentArray[1] = dataNameArray ;\n\targumentArray[2] = dataValueArray ;\n\targumentArray[3] = dataTypeArray ;\n\targumentArray[4] = \"1,2\";\n\targumentArray[5] = val_txt;\n\targumentArray[6] = DESC_LINK  ;\n\targumentArray[7] = DESC_CODE ;\n\tretVal = await CommonLookup( tit,argumentArray);\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\t\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].received_witness_desc.value=arr[1];\n\t\tdocument.forms[0].received_witnessid.value=arr[0];\t\t\n\n\t}\n}\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n    <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eMR/js/PatientValuables.js\' language=\'javascript\'></script>  \n\t<script src=\'../../eMR/js/MRPractitionerComponent.js\' language=\'javascript\'></script>  \n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\n</head>\n<script>\n\nfunction checkForNull(inString)\n{\n\treturn (trimCheck(inString))\t?\tinString\t:\t\"\";\n}\n\nfunction CloseWin()\n{\n\tparent.parent.document.getElementById(\"dialog_tag\").close();\n\n}\n\n\n</script>\n\n<body onKeyDown=\"lockKey()\">\n\t<form name=\'PatientValuables\' id=\'PatientValuables\' method=\"POST\" action=\'../../servlet/eMR.PatientValuablesServlet\'> \n\t<table border=0 cellspacing=0 cellpadding=3 width=\'100%\'>\n\t<!--Below lines removed by  munisekhar  for IN35532 on Thursday, Oct 04, 2012  --->\n\t\t\n\t\t<tr>\n\t\t\t<td width=\"25%\" class=\'label\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t<td width=\"25%\" class=\'fields\'><input type=text name=\"recordedBy\" id=\"recordedBy\" size=\"20\" maxLength=\'20\' readonly value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></td>\n\t\t\t<td width=\"25%\" class=\'label\'  >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td width=\"25%\" class=\'fields\'><INPUT TYPE=\"text\" name=\"recordedTime\" id=\"recordedTime\" size=\"16\" maxlength=\"16\"  value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" readonly ></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' scope=\"session\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td class=\'fields\' colspan=3><textarea style=\"resize:none\" name=\"remarks\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" rows=10 cols=80 maxLength=\'2000\' \n\t\t\t>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</textarea><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t</tr>  \n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<tr>\n\t\t\t<td class=\'label\'  scope=\"session\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'text\' name=\'witness_desc\' id=\'witness_desc\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" size=\'25\' maxlength=\'30\' onChange=\"getPractitionerId(witnessid, this); \"><input type=\'hidden\' name=\'witnessid\' id=\'witnessid\' value=\"\"><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerId(witnessid, witness_desc);\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t   <!--Below line Added for this CRF HSA-CRF-0222 [IN:050567] -->\n\t   <tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\n\t\t\t<td class=\'fields\'>\n\t\t\t    <input \n\t\t\t        type=\"text\" \n\t\t\t        value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" \n\t\t\t        onBlur=\"if(this.value != \'\') receivedcallwitness();\" \n\t\t\t        maxlength=\"30\" \n\t\t\t        size=\"30\" \n\t\t\t        name=\"received_witness_desc\" \n\t\t\t        ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\t\t\t        ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t            style=\"background-color: #e0e0e0; color: #a0a0a0; cursor: not-allowed;\"\n\t\t\t        ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n\t\t\t    <input \n\t\t\t        type=\"button\" \n\t\t\t        onclick=\"receivedcallwitness();\"  \n\t\t\t        class=\"button\" \n\t\t\t        value=\"?\" \n\t\t\t        ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\n\t\t\t    <input \n\t\t\t        type=\"hidden\" \n\t\t\t        name=\"received_witnessid\" \n\t\t\t        id=\"received_witnessid\" \n\t\t\t        value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t    <img src=\'../../eMP/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t\t\n\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t\n\t   <!--End HSA-CRF-0222 [IN:050567] -->\n\t\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t<td class=\'fields\'><input type=\"checkbox\"  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"   ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" name=\"returned\" onclick=\"callReturned_chk(this);\"></td>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t<td class=\'fields\' >\n\t\t\t<!-- Below line is commented by Akhilesh because unnecessary function called. -->\n\t\t\t<!--<input type=\'text\' size=\"14\" disabled maxlength=\"17\" onBlur=\"checkFromDate(this);chkDateVal(this);\" name=\'returned_datetime\' id=\'returned_datetime\' id=\"startlater\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" >-->\n\t\t\t<input type=\'text\' size=\"14\" disabled maxlength=\"17\" onBlur=\"checkFromDate(this);\" name=\'returned_datetime\' id=\'returned_datetime\' id=\"startlater\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="><img id=\'rel_img\' name=\"date_picker\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" disabled  name=\"calendertime\"   src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"document.forms[0].returned_datetime.focus(); return showCalendar(\'returned_datetime\',null,\'hh:mm\');\"/><img src=\'../../eMP/images/mandatory.gif\' style=\"visibility:hidden\" id=\'mand_gif3\'></td>\n\t\t</tr>\n\t\t<tr> <!--Below line modified for this CRF HSA-CRF-0222 [IN:050567] --> \n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t<td class=\'fields\' ><INPUT TYPE=\"text\" onBlur=\"if(this.value !=\'\')callReturnby();\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" disabled NAME=\"returnedby_desc\" maxlength=\'30\' size=\"30\"><input type=\"button\" disabled class=button name=\"button1\" id=\"button1\" onclick=\"callReturnby();\" value=\"?\"><img src=\'../../eMP/images/mandatory.gif\'  style=\"visibility:hidden\" id=\'mand_gif1\'> <INPUT TYPE=\"hidden\" name=\"returnedby\" id=\"returnedby\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" </td>\n\t\t\t<td class=\'fields\' ><INPUT TYPE=\"text\" disabled value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="  onBlur=\"if(this.value !=\'\')callwitness();\" maxlength=\'30\' size=\"30\" NAME=\"witness_desc\" ><input type=\"button\" disabled onclick=\"callwitness();\" name=\"button2\" id=\"button2\" class=button value=\"?\"><INPUT TYPE=\"hidden\" name=\"witnessid\" id=\"witnessid\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"><img src=\'../../eMP/images/mandatory.gif\' style=\"visibility:hidden\" id=\'mand_gif2\'></td>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<tr><td colspan=\'4\' class=\"label\">&nbsp;</td></tr>\n\t\t<tr style=\"text-align: right;\">\n\t\t\t<td colspan = \'4\' class=\'button\' ><input type=\'button\' class=\'button\' name=\'record\' id=\'record\' ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" onClick=\'callRecord(this);\'><input type=\'button\' class=\'button\' name=\'close\' id=\'close\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" onclick=\'CloseWin();\'></td>\n\t\t</tr>\n\t\t<tr><td colspan=\'4\' class=\"label\">&nbsp;</td></tr>\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\'hidden\' name=\'functions\' id=\'functions\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\'hidden\' name=\'nursing_unit\' id=\'nursing_unit\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\'hidden\' name=\'splity_code\' id=\'splity_code\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\t\n\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\'hidden\' name=\'systemdate\' id=\'systemdate\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=\'hidden\' name=\'witness_id\' id=\'witness_id\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<!--below line added for this CRF HSA-CRF-0222 -->\n\t\t<input type=\'hidden\' name=\'witness_pass_validate_check\' id=\'witness_pass_validate_check\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t</form>\n </body>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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

/**
	@Function used to Record patient Valueables from MR/IP/AE/OP modules...
	@Author - Sridhar R 
*/

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_Id	= (String)session.getValue("facility_id");
	String loginUser	= (String)session.getValue("login_user");
	String locale       = (String)session.getAttribute("LOCALE"); 
	String patientId	= checkForNull(request.getParameter("patientId"));
	String locn_code	= checkForNull(request.getParameter("locn_code"));
	String splty_code	= checkForNull(request.getParameter("splty_code"));
	String encounterId	= checkForNull(request.getParameter("encounterId"));
	String call_function= checkForNull(request.getParameter("call_function"));
//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	Connection con			= null;
	ResultSet rset			= null;
	ResultSet rs			= null;
	PreparedStatement pstmt	= null;
	String recorded_By		= ""; 
	String recorded_Date	= "";
	String remarks			= "";
	String witness_id		= "";
	String sysdate			= "";
	String function			= "";
	String practitioner_name= "";
	String returned_yn		= ""; 
	String returned_date	= "";
	String returned_id		= "";
	String returned_user_name="";
	String chk_attribute     = "";
	String sysdate_display	 = "";
	String dualdate			= "";
	String returned_date_display ="";
	String chk_enable		="";
	String chk_value		= "";
	String sysdate12        = "";
	String chk_returned_yn  = "";
	String witness_name     = "";
	//Added for this CRF HSA-CRF-0222 [IN:050567]
	String received_witness_id="";
    String received_witness_name="";
    String received_pract_name="";
	String received_pract_diabled = "";
	String witness_pass_validate_yn="";
	
	//int countRec = 0; 
  
	try 
    {
		con = ConnectionManager.getConnection(request);
		
		/*Below line added for this CRF HSA-CRF-0222 [IN:050567]*/
		pstmt = con.prepareStatement("select witness_pass_validate_yn from MR_PARAMETER");
		rset = pstmt.executeQuery();
	    if(rset!=null && rset.next()) {
	    witness_pass_validate_yn=checkForNull(rset.getString("witness_pass_validate_yn"),"N");
		}
		if(rset!=null)rset.close();	
	    if(pstmt!=null)pstmt.close();
		/*End this CRF HSA-CRF-0222 [IN:050567]*/
		
		//StringBuffer sql = new StringBuffer("Select added_by_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate, returned_yn,to_char(returned_date,'dd/mm/yyyy hh24:mi') returned_date,RETURNED_BY_ID, to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, valuable_details, witness_id from PR_PATIENT_VALUABLES where encounter_id=? and patient_id=? and facility_id=? ");   
		/*Monday, May 03, 2010 , SRR20056-SCF-4436-IN021088 ,*/
		//Modified for this CRF CRF HSA-CRF-0222 [IN:050567]
		StringBuffer sql = new StringBuffer("Select added_by_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate, returned_yn,to_char(returned_date,'dd/mm/yyyy hh24:mi') returned_date,returned_by_id,sm_get_desc.sm_appl_user(returned_by_id,?,1) return_by_name , to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, valuable_details, witness_id , sm_get_desc.sm_appl_user(witness_id,?,1) witness_name ,am_get_desc.am_practitioner(witness_id,?,1) pract_name, received_witness_id, sm_get_desc.sm_appl_user(received_witness_id,?,1) received_witness_name, am_get_desc.am_practitioner(received_witness_id,?,1) received_pract_name  from PR_PATIENT_VALUABLES where encounter_id=? and patient_id=? and facility_id=? ");  
        
	 	//pstmt=con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 pstmt=con.prepareStatement(sql.toString());
         pstmt.setString(1,locale);
         pstmt.setString(2,locale);
         pstmt.setString(3,locale);
		 pstmt.setString(4,locale);
		 pstmt.setString(5,locale);
         pstmt.setString(6,encounterId);
		 pstmt.setString(7,patientId);
		 pstmt.setString(8,facility_Id);
		 rs	 = pstmt.executeQuery();
         /*if(rs != null){
			rs.last();
			countRec = rs.getRow();
            rs.beforeFirst();
		}*/
		/*if(countRec > 0) function = "modify";
		else function = "insert";*/
		
		if(rs.next()) 
		{
			sysdate12		= rs.getString("sdate");
			recorded_By		= checkForNull(rs.getString("ADDED_BY_ID"));
			recorded_Date	= checkForNull(rs.getString("ADDED_DATE"));
			remarks			= checkForNull(rs.getString("VALUABLE_DETAILS"));
			witness_id		= checkForNull(rs.getString("witness_id"));
			witness_name	= checkForNull(rs.getString("witness_name"));
			practitioner_name= checkForNull(rs.getString("pract_name"));
			//if(practitioner_name.equals(""))
			//	practitioner_name = witness_name;
			
			returned_yn		= checkForNull(rs.getString("returned_yn"));
			returned_date   = checkForNull(rs.getString("returned_date"));
			returned_id		= checkForNull(rs.getString("returned_by_id"));
			returned_user_name= checkForNull(rs.getString("return_by_name"));
			//Added for this CRF CRF HSA-CRF-0222 [IN:050567]
			received_witness_id= checkForNull(rs.getString("received_witness_id"));
            received_witness_name= checkForNull(rs.getString("received_witness_name"));
            //received_pract_name= checkForNull(rs.getString("received_pract_name"));
			//if(received_pract_name.equals(""))received_pract_name = received_witness_name;
			if(!received_witness_name.equals("")) received_pract_diabled="disabled";			
			
			//End CRF HSA-CRF-0222 [IN:050567]
			
			
			function		= "modify";
			
		} 
		else
		{
			function		= "insert";
		}

		
	if(pstmt!=null)pstmt.close();
	if(remarks.equals("") && returned_yn.equals(""))
	{
		chk_returned_yn="disabled";
	}

	else if(returned_yn.equals("Y"))
       chk_returned_yn="disabled";
	
	if(returned_yn.equals("Y"))
	{
		chk_attribute="checked";
		chk_enable="disabled";
		chk_value="Y";
	}
	else
	{
       chk_attribute= "";
	   chk_enable  = "";
	   chk_value="N";
	}
	
	SimpleDateFormat dateFormatTime = new SimpleDateFormat( "dd/MM/yyyy hh:mm" ) ;
	sysdate	= dateFormatTime.format(new java.util.Date()) ;  
	sysdate_display = DateUtils.convertDate(sysdate,"DMYHM","en",locale);
	if(returned_date.equals(""))
		returned_date_display = "";
	else
		returned_date_display = DateUtils.convertDate(returned_date,"DMYHM","en",locale);
	if(recorded_Date != null || recorded_Date != "")
	{
		sysdate_display = DateUtils.convertDate(recorded_Date,"DMYHM","en",locale);
	}
	 if(recorded_By != null && recorded_By != "")
       loginUser = recorded_By;
   	
	if(remarks == null) remarks="";
	//pstmt = con.prepareStatement("select appl_user_name from sm_appl_user where appl_user_id = '"+returned_id+"'");
	/*Monday, May 03, 2010 , SRR20056-SCF-4436-IN021088 ,*/
	/*
	if(!witness_id.equals("") && returned_id.equals(""))
	{
		pstmt = con.prepareStatement("select appl_user_name, to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from SM_APPL_USER_LANG_VW where appl_user_id = '"+witness_id+"' AND language_id='"+locale+"'");
		String str="select appl_user_name, to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from SM_APPL_USER_LANG_VW where appl_user_id = '"+witness_id+"' AND language_id='"+locale+"'";
	}else{

		pstmt = con.prepareStatement("select appl_user_name, to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from SM_APPL_USER_LANG_VW where appl_user_id = '"+returned_id+"' AND language_id='"+locale+"'");
		
		String str2="select appl_user_name, to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from SM_APPL_USER_LANG_VW where appl_user_id = '"+returned_id+"' AND language_id='"+locale+"'";
	}
	rset = pstmt.executeQuery();
	if(rset.next())
	{
		
		if(sysdate == null)
		{
			sysdate = "";
			sysdate_display = "";
		}
		else
			sysdate_display = DateUtils.convertDate(sysdate,"DMYHM","en",locale);

		if(!witness_id.equals("")){
			practitioner_name = rset.getString(1);
		out.println("practitioner_name====="+practitioner_name);
		}


		if(!returned_id.equals("")){
			returned_user_name = rset.getString(1);
	out.println("returned_user_name====="+returned_user_name);
		}
	}
	
	if(rset!=null)rset.close();	
	if(pstmt!=null)pstmt.close();
	

   
	
	
		if(recorded_Date == null || recorded_Date == "")
		{
			if(rset!=null)rset.close();	
			if(pstmt!=null)pstmt.close();
			pstmt = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from dual");
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				dualdate = rset.getString(1);
			}

			if(rset!=null)rset.close();	
			if(pstmt!=null)pstmt.close();

			sysdate_display = DateUtils.convertDate(dualdate,"DMYHM","en",locale);
		}
		else
		{
			sysdate_display = DateUtils.convertDate(recorded_Date,"DMYHM","en",locale);
		}
	*/
	}catch(Exception e) {/* out.println(e.toString()); */ e.printStackTrace();}
    finally
    {
		//if (rs != null) rset.close();
        ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( loginUser));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sysdate_display));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(chk_enable));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block15Bytes, _wl_block15);
	if(!call_function.equals("MR_REC_PAT_VAL"))
	{	
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(witness_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
	}
	else if(call_function.equals("MR_REC_PAT_VAL"))
	{	
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(received_witness_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(received_pract_diabled));
            _bw.write(_wl_block24Bytes, _wl_block24);
 if("disabled".equals(received_pract_diabled)) { 
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(received_pract_diabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(received_witness_id));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chk_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(chk_attribute));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(chk_returned_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(returned_date));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chk_enable));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(returned_date_display));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chk_enable));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(chk_enable));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(returned_user_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chk_enable));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(returned_id));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(witness_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chk_enable));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(witness_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
	}	
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(chk_enable));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_Id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(function));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(sysdate12));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(witness_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(witness_pass_validate_yn));
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.recordeddatetime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientValuables.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Witness.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.received.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Witness.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.returned.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.returndatetime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.returnedby.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.returned.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Witness.label", java.lang.String .class,"key"));
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
}
