package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

public final class __vwencounterdetailsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/vwEncounterDetailSearch.jsp", 1743672001415L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <Script language=\'javaScript\' src=\"../../eCommon/js/CommonCalendar.js\"></Script>  \n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>  \n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n  <script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>  \n  <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n  <script language=\'javascript\' src=\"../js/MedRecRequestCriteria.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<script>\nfunction clearResult()\n{\t\n\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\tparent.frames[3].document.location.href=\"../../eCommon/html/blank.html\";\n}\nfunction clearPatinent(obj){\n\t\n\t\n\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\tparent.frames[3].document.location.href=\"../../eCommon/html/blank.html\";\n\t\n}\n\nasync function callSearchScreen(){\n\t\tvar patientid= await PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'\',\'\',\'OTHER\');;\n\t\tif(patientid !=null)\n\t\tdocument.forms[0].PatientId.value = patientid;\n\t\t document.forms[0].PatientId.focus();\t\t \n\t}\nfunction CheckNumVal(obj)\n{\n\tif (parseInt(obj.value) <= 0)\n\t{\n\t\talert(getMessage(\'IP_VAL_NOT_LESS_ZERO\',\'IP\'));\n\t\tobj.select();\n\t}\n\telse\n\t{\n\t\tCheckNum(obj);\n\t}\n}\n/*function Callencon()\n{\n\tif (document.forms[0].PatientId.value!=\"\")\n\t\t\t\tdocument.forms[0].encounter_id.disabled=false;\n\t\t else\n\t\t\t\tdocument.forms[0].encounter_id.disabled=true;\n\n}\n*/\nasync function searchCode(obj,target)\n{\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"10vh\" ;\n\t\tvar dialogWidth\t= \"43\" ;\n\t\tvar dialogTop\t= \"95vw\" ;\n\n\t\tvar features\t=\"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal =await window.showModalDialog(\"../jsp/EncounterDisplayFrame.jsp?patient_id=\"+document.forms[0].PatientId.value+\"&enc_type=\"+document.forms[0].p_enc_type.value,arguments,features);\n\t\tif(retVal !=null)\n\t\t\ttarget.value = retVal;\n\t\t\ttarget.focus();\n}\n\nfunction searchResult()\n{\n\t\n\tvar from\t\t\t\t= document.forms[0].p_fm_encoun_date.value ;\n\tvar to\t\t\t\t\t= document.forms[0].p_to_encoun_date.value ;\n\tvar patientid\t\t    = document.forms[0].PatientId.value;\n\tvar facility\t\t\t= document.forms[0].facility.value;\n\tvar encounType\t\t\t= document.forms[0].p_enc_type.value;\n\tvar encounterID\t\t\t= document.forms[0].p_encounter_id.value;\n\tvar order_by\t\t\t= document.forms[0].p_order_by.value;\n\tvar p_all_facility_id\t= document.forms[0].p_all_facility_id.value;//added for Bru-HIMS-CRF-380 Start\n\t\n\n\tvar\tnextRecord\t\t\t= \'\';\n\tvar\tpreviousRecord\t\t= \'\';\n\tvar\tvalidFile\t\t\t= \"true\";\n\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\tparent.frames[3].document.location.href=\"../../eCommon/html/blank.html\";\n\t\n\tif(patientid == \"\")\n\t{\n\t\terror  = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\terror = error.replace(\'$\', getLabel(\"Common.patientId.label\",\"Common\"));\t\t\n\t\talert(error);\t\n\t\t\n\t\t\n\t}\n\telse\n\t{\n\t\n\t\tvar\tfields\t\t\t\t= new Array(document.forms[0].PatientId);\n\t\tvar\tnames\t\t\t\t= new Array(getLabel(\"Common.patientId.label\",\"Common\"));\n\n\t\tif( (checkFields(fields, names, parent.messageFrame)) && doDateCheck(document.forms[0].p_fm_encoun_date, document.forms[0].p_to_encoun_date,parent.messageFrame))\n\t\t{\t\n\t\t\t//\tparent.frames[1].document.forms[0].search[1].disabled=true;\n\t\t\t\n\t\t\tparent.frames[3].document.location.href=\'../../eMR/jsp/vwEncounterDetailResult.jsp?from=\'+from+\'&to=\'+to+\'&patientid=\'+patientid+\'&flag=next\'+\'&nextRecord=\'+nextRecord+\'&previousRecord=\'+previousRecord+\'&encounType=\'+encounType+\'&facility=\'+facility+\'&order_by=\'+order_by+\'&encounterID=\'+encounterID+\'&p_all_facility_id=\'+p_all_facility_id;\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\n\t\t\t parent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\tparent.frames[3].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t parent.frames[4].document.location.href= \"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t}\t\t\t\t\t\t\t\t\n}\n\nfunction doDcsdDateCheck(from,to) {\n    var fromarray; var toarray;\n    var fromdate = from.value ;\n    var todate = to.value ;\n    if(fromdate.length > 0 && todate.length > 0 ) {\n            fromarray = fromdate.split(\"/\");\n            toarray = todate.split(\"/\");\n            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);\n            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);\n            if(Date.parse(todt) <= Date.parse(fromdt)) {\n                return false;\n            }\n            else if(Date.parse(todt) > Date.parse(fromdt)) return true;\n    }\nreturn true;\n}\nfunction DscdPeriodChk(Dt)\n{\t\t\n\tif  (Dt.value!=\"\" &&  doDcsdDateCheck( document.forms[0].SystemDate,Dt) )\t\n\t{\n\t\t//alert(\"Deceased period cannot be greater than current date\");\n\t\terror=getMessage(\"MRDATE1_GT_DATE2\",\"MR\");\n\t\terror = error.replace(\'$\', getLabel(\"eMR.DeceasedPeriod.label\",\"MR\"));\t\t\n\t\terror = error.replace(\'#\', getLabel(\"Common.CurrentDate.label\",\"Common\"));\t\n\t\talert(error);\n\t\tDt.value=\'\';\n\t\tDt.focus();\n\t}\n\treturn;\n}\n//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] \n//Func will return an alert message if TO DATE is Less than FROM DATE\nfunction ComparePeriodFromToTime(from,to)\n{\n\tvar frdt = from.value;\n\tvar tdt = to.value;\n\tvar greg_tdt = \"\";\n\tvar greg_frdt = \"\";\n\n\tif(frdt !=\"\" && validDate(frdt,\"DMY\",\"en\"))\n\t{\n\t\tgreg_frdt = convertDate(frdt,\"DMY\",localeName,\"en\");\n\t}\n\n\tif(to !=\"\" && validDate(tdt,\"DMY\",\"en\"))\n\t{\n\t\tgreg_tdt = convertDate(tdt,\"DMY\",localeName,\"en\");\n\t}\n\t\n\tif(greg_frdt != \"\" && greg_tdt !=\"\")\n\t{\n\t\tif(!isBefore(greg_frdt,greg_tdt,\"DMY\",\"en\"))\n\t\t{\n\t\t\talert( getMessage(\"TO_DT_GR_EQ_FM_DT\",\'SM\') );\n\t\t\tdocument.forms[0].p_to_encoun_date.focus();\n\t\t\tdocument.forms[0].p_to_encoun_date.select();\n\t\t}\n\t}\n}\nfunction PatValidations(obj)\n{\n\t\n\tif(document.forms[0].PatientId.value!=\'\')\n\t{\n\t    var fields = new Array (document.forms[0].PatientId); \n        var names = new Array (getLabel(\"Common.patientId.label\",\"Common\"));\n\t\tvar patient_id = document.forms[0].PatientId.value;\n\t\tvar error_jsp=\"\";\n\t\tvar messageFrame=\"\";\n\t\t\t\n\t    var HTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'valid_form\' id=\'valid_form\' method=\'post\' action=\'../../eMR/jsp/MRPatientIDValidations.jsp\'><input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'\"+patient_id+\"\'><input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\'VIEW_ENCOUNTER_DTLS\' /></form></BODY></HTML>\";\n\t\t//call_function added by Dharma on 20th Feb 2018 against for ML-MMOH-SCF-0919 [IN:066388]\n\t    parent.messageFrame.document.write(HTMLVal);\n\t    parent.messageFrame.valid_form.submit();\n\t}\n}\n\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body onLoad=\"FocusFirstElement()\"  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t   <form name = \'encounter_detail_form\' method=\'post\' target=\'messageFrame\' action=\'../../eMR/jsp/vwEncounterDetailResult.jsp\'>\t\n\t\t\t<table cellpadding=\'2\' cellspacing=\'0\' width=\'95%\' align=\'center\' > \n\t\t\t <tr><td colspan=\'4\' class=\'BLANKROW1\'></td></tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'10%\' class=\"label\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </td>\n\t\t\t\t\t<td class=\"fields\" width=\'18%\'>\n\t\t\t\t\t<input type=text  name=\'PatientId\' id=\'PatientId\'  onBlur=\"makeValidString(this);ChangeUpperCase(this);PatValidations(this);clearPatinent(this);\" onKeypress=\'return CheckForSpecChars(event);\' align=\"center\" size=\"\" maxlength=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="><input type=\'button\' name=\'patient_id\' id=\'patient_id\' value=\'?\' class=\'button\' onclick=\'callSearchScreen()\'><img src=\"../../eCommon/images/mandatory.gif\"></img></td>\t\n\t\t\t\t\t<!--onKeypress= \'makeValidString(this)\'; Condition removed Against Incident 34858-->\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<!--Modified for Bru-HIMS-CRF-380 Start -->  \n\t\t\t\t\t<td width=\'10%\' class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\n\t\t\t\t\t<td width=\'15%\' class=\"fields\"><select name=\'p_all_facility_id\' id=\'p_all_facility_id\' >\n\t\t\t\t\t\t<option value=\'\' selected>-------";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="-------\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" selected>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </option> \n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<!--Modified for Bru-HIMS-CRF-380 End -->\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td   class=\'label\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t<td class=\"fields\"><input \'text\' id=\'birthfrom\' name=\'p_fm_encoun_date\' id=\'p_fm_encoun_date\' value=\'\' size=\'10\' maxlength=\'10\' title=\'From proc Date\' onblur=\"validDateObj(this,\'DMY\',\'en\');ComparePeriodFromToTime(this,p_to_encoun_date);\" onkeypress=\"return Valid_DT(event)\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'birthfrom\');\"></img> - <input \'text\' id=\'birthto\' name=\'p_to_encoun_date\' id=\'p_to_encoun_date\' value=\'\' size=\'10\' maxlength=\'10\' title=\'To proc Date\' onblur=\"validDateObj(this,\'DMY\',\'en\');ComparePeriodFromToTime(p_fm_encoun_date,this);\" onkeypress=\"return Valid_DT(event)\" ><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'birthto\');\"></img></td>\n\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t<td class=\"fields\"><select name=\'p_enc_type\' id=\'p_enc_type\' >\n\t\t\t\t\t<option value=\'\'>-- ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" --</option> \n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t</select>\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t<td  class=\'fields\'>\t<input type=text  name=\'p_encounter_id\' id=\'p_encounter_id\' size=\"12\" maxlength=\"12\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNumVal(this)\" align=\"center\"></td>\n\t\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t<td><select name=\'p_order_by\' id=\'p_order_by\' >\n\t\t\t\t\t<option value=\'PATIENT_CLASS\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" \n\t\t\t\t\t<option value=\'ENCOUNTER_DATE desc\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td><!-- The order by fields arehard coded according to the positions of the fields in vwEncounterDetailResult.jsp file and hasto be changed if changes are done in the resukt file -->\n\t\t\t\t</tr>\n\t\t\t\t<tr> \n\t\t\t\t\t<td colspan=\'3\' class=\'label\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'button\'><input type=\'button\' class=\'button\' name=\'search\' id=\'search\'   value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onClick=\'searchResult();\'><input type=\'button\' class=\'button\' name=\'clear\' id=\'clear\'   value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onClick=\'clearResult();\'></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t <input type=\'hidden\' name=\'facility\' id=\'facility\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t  </form>\n\t</body>\n\t</html>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
String p_facility_id		= (String) session.getValue( "facility_id" ) ;
Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
Statement stmt1=null;
ResultSet rs=null;

/*Declaration for Bru-HIMS-CRF-380 Start*/

PreparedStatement pstmt = null ;
ResultSet rset1 		= null ;
/*Declaration for Bru-HIMS-CRF-380 End*/

try
{
	conn = ConnectionManager.getConnection(request);
	
	stmt1 = conn.createStatement();
	String pat_length="";

	rs=stmt1.executeQuery("select patient_id_length from mp_param");
	if (rs!=null && rs.next())
		pat_length = checkForNull(rs.getString(1));

	if(rs!=null)	rs.close();
	if(stmt1!=null)	stmt1.close();

	if(pat_length == null || pat_length.equals("null")) pat_length = "10";

	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pat_length));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

							try
							{
								String sql_facility="select facility_id,facility_name from SM_FACILITY_PARAM_LANG_VW where language_id='"+localeName+"' order by 2";
								//System.err.println("fac qury=>"+sql_facility);
								
								pstmt=conn.prepareStatement(sql_facility);
								rset1=pstmt.executeQuery();
								if(rset1!=null)
								{
									while(rset1.next())
									  {
										String id=rset1.getString(1);
										String name = rset1.getString(2);
										if(id.equals(p_facility_id))
										  {
										
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(name));
            _bw.write(_wl_block15Bytes, _wl_block15);

										  }
										  else
										  {
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(name));
            _bw.write(_wl_block17Bytes, _wl_block17);
	}
											}
								}
									if(rset1 != null)rset1.close();
									if(pstmt != null)pstmt.close();
								}catch(Exception e)
								{
									/* out.println(e);
									out.println("Exception @tryCatch : "+e.getMessage()); */
									e.printStackTrace();
								}
							
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					stmt = conn.createStatement();
					rset = stmt.executeQuery("select patient_class,short_desc from am_patient_class order by short_desc");
					if(rset != null)
					{
						while(rset.next())
						{
							String desc	= checkForNull(rset.getString("SHORT_DESC"));
							String ID	= checkForNull(rset.getString("patient_class"));
							if(desc == null || desc.equals("null")) desc = "";
							if(ID == null || ID.equals("null")) ID = "";
							out.println("<option value='"+ID+"'>"+desc+"</option>");
						}
					}
					
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block29Bytes, _wl_block29);

}catch(Exception e)
{
	//out.print(e.toString());
	e.printStackTrace();
}
finally   
{
	if(rset!=null)	rset.close();
	if(rset1!=null)	rset1.close();
	if(stmt!=null)	stmt.close();
	if(conn != null)
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
}
