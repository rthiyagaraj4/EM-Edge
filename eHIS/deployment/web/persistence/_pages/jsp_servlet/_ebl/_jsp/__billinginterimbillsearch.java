package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import eBL.RecordApprovalPatientDataBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __billinginterimbillsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillingInterimBillSearch.jsp", 1742469222420L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!-- \nSr No           Version             Incident\t\t\tSCF/CRF                      Developer Name\n1               V201218             IN73702        MMS-DM-CRF-0100.1         \t\tPalani Narayanan\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/BillingInterimBillScript.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n <script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tvar ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL\t\t=\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\tvar PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL\t\t=\t\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\n\tvar PAYER_LOOKUP_RECORD_PREAPPROVAL\t\t\t\t=\t\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\t\n\tvar POLICY_LOOKUP_RECORD_PREAPPROVAL\t\t\t=\t\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\t\n\tvar RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP\t=\t\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\tvar headTop = -1;\n\tvar FloatHead1;\n/*function onloadRequestStatus()\n{\t\n\tdocument.forms[0].request_status.value=\'*\';\n\tif(document.forms[0].calledForm.value == \"serviceApprStatus\") {\n\t\tdocument.forms[0].order_status.value=\'*\';\n\t}\n}*/\n\nfunction processScroll()\n{\n\tif (headTop < 0)\n\t{\n\t\tsaveHeadPos();\t\t\t\n\t}\n\tif (headTop>0)\n\t{\n\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\ttheTop = document.documentElement.scrollTop;\n\t\telse if (document.body)\n\t\t\ttheTop = document.body.scrollTop;\n\n\t\tif (theTop>headTop)\n\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\telse\n\t\t\tFloatHead1.style.top = \'0px\';\n\t}\n}\n\nfunction saveHeadPos()\n{\n\tparTable = document.getElementById(\"divHeadSep\");\n\tif (parTable != null)\n\t{\n\t\theadTop = parTable.offsetTop + 3;\n\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\tFloatHead1.style.position = \"relative\";\n\t}\n}\n\nfunction lockbackSpace()\n{\n\tvar mode = document.mode.value;\n\tif(mode==\'modify\' && window.event.keyCode==8)\n\t{\n\t//return false;\n\t}\n}\n\nfunction primaryPatValidation(obj)\n{\n\tvar patient_id=obj.value;\t\n\tif(patient_id!=\"\"){\n\t\tvar function_id = \"PAT_CHK\";\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr+= \"patient_id=\\\"\" + patient_id + \"\\\" \" ;\t\t\t\t\t\n\t\txmlStr +=\" /></root>\";\n\t\tvar temp_jsp=\"PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id=\"+function_id;\t\t\t\t\t\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\"); \n\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar responseText=trimString(xmlHttp.responseText);\t\t\n\t\tif(responseText==\"N\")\n\t\t{\n\t\t\talert(getMessage(\"INVALID_PATIENT\",\"MP\"));\n\t\t\tobj.select();\n\t\t}else if(responseText==\"Y\"){\n\t\t\tLoadPatientName(patient_id);\n\t\t}\n\t}\n}     \n\nasync function PatientIdLookup()\n{\t\n\n\tvar pat_id=await PatientSearch();\t\t\n\tif( pat_id != null )\t\t\t\t\t\t\n\tdocument.getElementById(\'patient_id\').value = pat_id ;\n\tif(pat_id!=undefined && pat_id!=\'\')\n\t{\n\t\tLoadPatientName(pat_id);\n\t\tChangeUpperCase(document.getElementById(\'patient_name\'));\n\t}\n}\t\n\nfunction LoadPatientName(pat_id)\n{\n\tvar out;\n\tvar response;\n\tvar xmlhttp;    \n\tif (window.XMLHttpRequest) \n\t{// code for IE7+, Firefox, Chrome, Opera, Safari\n\t\txmlhttp=new XMLHttpRequest();\n\t}\n\telse\n\t{// code for IE6, IE5\n\t\txmlhttp=new XMLHttpRequest();\n\t}\n\t\txmlhttp.onreadystatechange=function()\n\t{\n\tif (xmlhttp.readyState==4 && xmlhttp.status==200)\n\t{\n\t\tout = xmlhttp.responseText;\n\t\tvar showdata = out.substring(out.indexOf(\"!\")+1,out.length);\n\t\tresponse=showdata.split(\":\");\n\t\tvar actual;\n\tfor(var i=0;i<response.length;i++)\n\t{\n\t\tdocument.getElementById(\"patient_name\").value = response[i];\n\t}\n\t\tChangeUpperCase(document.getElementById(\'patient_name\'));\n\t}\n\t}\n\t\txmlhttp.open(\"POST\",\"../../eBL/jsp/BillingRecordApprovalGetPatienName.jsp?patientId=\"+pat_id,true);\n\t\txmlhttp.send(null);\n}\t\t\nfunction validateMenuIntrem()\n\t{\t\n\t\tvar facilityId= document.getElementById(\"facilityId\").value;\n\t\tvar temp_jsp = \"../jsp/BLCommonAjax.jsp?functionMode=validateBlIntreamBillMenuDisableOrEnable&facilityId=\"+facilityId ;\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\txmlHttp.open(\"POST\", temp_jsp, false);\n\t\txmlHttp.send();\n\t\tvar responseText = trimString(xmlHttp.responseText);\n\t\tif(responseText==\'N\')\n\t\t{ \t\n\t\t\talert(\"APP-BL0929 Interim Bill Authorization Cannot Be Applicable\"); \n\t\t\tparent.parent.frames[2].commontoolbarFrame.document.location.reload();\n\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\n\t\t}\n\n\t}\n</script>\n</head>\n<style>\n\t\tthead td, thead td.locked\t{ \n\t\tbackground-color: navy;\n\t\tcolor: white;\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-4); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative; \n\t\tz-index: 10;}\n</style>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<body   onMouseDown=\"CodeArrest();\" onKeyDown= \"lockKey();\"    onLoad=\"validateMenuIntrem();\"  onSelect=\"codeArrestThruSelect();\">\n\t<form id=\"interimBill\" name=\"interimBill\" id=\"interimBill\" >\t\n\t\n\t\t<table cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\" border=0>\n\t\t<tr>\n\t\t\t \t<td class=\"label\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<input type=\"text\" name=\"patient_id\" id=\"patient_id\" id=\"patient_id\" \t\tmaxlength=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onBlur=\"ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == \'\'){ patient_name.value=\'\'; return PatientIdLookup(); }\"    onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" >\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"patientidbut\" id=\"patientidbut\" value=\'?\' onClick=\"return PatientIdLookup()\"     tabindex=\'2\' />\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td class=\"fields\" colspan=\"2\">\n\t\t\t\t\t<input type=\"text\" name=\"patient_name\" id=\"patient_name\" id=\"patient_name\"    maxlength=\"100\"  onBlur=\"ChangeUpperCase( this );\"     onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" onfocus=\"ChangeUpperCase( this );\" >\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" colspan=\'3\'></td>\t\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t \t<td class=\"label\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<select id=\"episode_type\" name=\"episode_type\" id=\"episode_type\"  style=\"width: 130px;\">\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" selected>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t<td class=\"fields\" colspan=\"2\">\n\t\t\t\t\t<input type=\"text\" name=\"encounter_id\" id=\"encounter_id\" id=\"encounter_id\"   maxlength=\"100\"  onBlur=\"ChangeUpperCase( this );if(this.value!=\'\'){enCounterIdLookup();}\"    onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" >\t\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"patientidbut\" id=\"patientidbut\" value=\'?\' onClick=\"return enCounterIdLookup()\"  tabindex=\'2\'>\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" colspan=\'2\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\" name=\"speciality\" id=\"speciality\" id=\"speciality\"    maxlength=\"100\"  onBlur=\"ChangeUpperCase( this );return specialityLookup();\"    onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" >\t\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"patientidbut\" id=\"patientidbut\" value=\'?\' onClick=\"return specialityLookup()\"  tabindex=\'2\'/>\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t<td class=\"label\" colspan=\'3\'>\t\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t \t<td class=\"label\" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td class=\'fields\' >\n\t\t\t\t\t<input type=\"text\" name=\"payer_group\" id=\"payer_group\" id=\"payer_group\" \t\t maxlength=\"30\"  onBlur=\"ChangeUpperCase( this );if(this.value!=\'\'){ payerGroupLookup();}\"    onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" >\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"patientidbut\" id=\"patientidbut\" value=\'?\' onClick=\"return payerGroupLookup()\"  tabindex=\'2\' /><img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t\t\t\t</td>\t\t\t\t\n\t\t\t\t \t<td class=\"label\" colspan=\"2\" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<input type=\"text\" name=\"payer\" id=\"payer\" id=\"payer\" \t\t maxlength=\"30\"  onBlur=\"ChangeUpperCase( this );if(this.value!=\'\'){ payerLookup();}\"    onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" >\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"patientidbut\" id=\"patientidbut\" value=\'?\' onClick=\"return payerLookup()\"  tabindex=\'2\' />\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td class=\"fields\" colspan=\"2\">\n\t\t\t\t\t<input type=\"text\" name=\"policy\" id=\"policy\" id=\"policy\"    maxlength=\"100\"  onBlur=\"ChangeUpperCase( this );if(this.value!=\'\'){ policyLookup();}\"    onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" >\t\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"patientidbut\" id=\"patientidbut\" value=\'?\' onClick=\"return policyLookup()\"  tabindex=\'2\'/>\t\t\t\t\t\n\t\t\t\t</td>\n\t\t</tr>\n\t\t\t<td class=\"fields\" colspan=\"2\">\n\t\t\t</td>\n\t\t\t<td class=\"fields\" colspan=\"2\">\n\t\t\t</td>\n\t\t\t<td class=\"fields\" colspan=\"2\">\n\t\t\t</td>\n\t\t\t<td class=\"label\" colspan=\'3\'>\n\t\t\t\t<input type=\"button\" class=\'button\' name=\"add_mod\" id=\"add_mod\"\tid=\"add_mod\"   value=\"Search\" onclick=\"showRecordApprovalPatientDeatils();\"  />\n\t\t\t</td>\t\n\t\t</tr>\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' id=\'facilityId\'  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t\t<input type=\'hidden\' name=\'selectAllFlag\' id=\'selectAllFlag\' id=\'selectAllFlag\' value=\"N\" >\n\t\t<input type=\'hidden\' name=\'selectArrFlag\' id=\'selectArrFlag\' id=\'selectArrFlag\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'selectArrUnSlectFlag\' id=\'selectArrUnSlectFlag\' id=\'selectArrUnSlectFlag\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'selectJsonArrFlag\' id=\'selectJsonArrFlag\' id=\'selectJsonArrFlag\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'authorizedUserId\' id=\'authorizedUserId\' id=\"authorizedUserId\" value=\"N\">\n\t\t<input type=\'hidden\' name=\'authorizedUserName\' id=\'authorizedUserName\' id=\"authorizedUserName\" value=\"\">\n\t\t<input type=\'hidden\' name=\'mainAuth\' id=\'mainAuth\' id=\"mainAuth\" value=\"\">\n\t\t<input type=\'hidden\' name=\'privilegeYN\' id=\'privilegeYN\' id=\"privilegeYN\" value=\"\">\n\t\t<input type=\'hidden\' name=\'selectAllPrevFlag\' id=\'selectAllPrevFlag\' id=\"selectAllPrevFlag\" value=\"\">\n\t\t<input type=\'hidden\' name=\'facilityIdnew\' id=\'facilityIdnew\' id=\'facilityId\'  value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\t\n\t\t</body>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</form>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
	
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

	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	String calledForm = (String) request.getParameter("calledForm");
	if(calledForm == null) {
		calledForm = "";
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(BlRepository.getBlKeyValue("RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP")));
            _bw.write(_wl_block12Bytes, _wl_block12);

	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String locale		=	"";
	String facilityId	=	"";
	String mode			=	"";
	mode				=	"";
	String isUserCanAcess =	"";
	String bean_id		=	"";
	String bean_name	=	"";
	ArrayList episodeTypeList	=	null;
	int defaultDate = 1;
	String restrictDate = "";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String sql="";
	int pat_id_len = 0;

	try
	{
		con = ConnectionManager.getConnection();
		sql ="select patient_id_length from mp_param";

		pstmt = con.prepareStatement(sql);
		rst = pstmt.executeQuery();

		if (rst != null && rst.next())
		{
			pat_id_len = rst.getInt("patient_id_length");
		}
		} catch(Exception e) {
			pat_id_len = 15;
			out.println(e.toString());
			e.printStackTrace();
		}
	finally 
	{
		try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(rst != null) {
					rst.close();
				}
				ConnectionManager.returnConnection(con);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

try  
{	 
	sStyle 					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 					= 	(String)session.getAttribute("LOCALE");
	facilityId				=    (String) session.getValue( "facility_id" ) ;
	String auth 			=	checkForNull((String)session.getAttribute("auth2"));
	bean_id					= 	"RecordApprovalPatientDataBean" ;
	bean_name				= 	"eBL.RecordApprovalPatientDataBean";
	RecordApprovalPatientDataBean recordApprovalPatientDataBean								= 	(RecordApprovalPatientDataBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess				= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	episodeTypeList				=	recordApprovalPatientDataBean.populateEpisodeTypeList(facilityId, locale);
	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pat_id_len ));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

					for(int index=0;index<episodeTypeList.size();index++)
					{
					if(episodeTypeList.get(index).equals("IP"))
					{
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" ));
            _bw.write(_wl_block20Bytes, _wl_block20);
} else if(episodeTypeList.get(index).equals("DC")){ 
					
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" ));
            _bw.write(_wl_block20Bytes, _wl_block20);

					}
					}
					
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block31Bytes, _wl_block31);

	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in BillingRecordApprovalSearch.jsp::"+e);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
