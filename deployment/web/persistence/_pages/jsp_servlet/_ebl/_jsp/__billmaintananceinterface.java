package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.persist.PersistenceHelper;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __billmaintananceinterface extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillMaintananceInterface.jsp", 1743572563433L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--JSP Created Against AAKH-CRF-0113.3-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<script language=\'javascript\' src=\'../js/BLReprintReport.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<script language=\'javascript\' src=\'../js/json2.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<style>\n.div1 {\n\t display: block;\n\tmargin-left: auto;\n  margin-right: auto;\n  width: 100%;\n  height: 100%;\n border-style: double;\n  padding: 100px;  \n}\nTD.GREEN  \n\t\t{\t\t\t\n\t\t\tBACKGROUND-COLOR: D1FAC1 ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t\n\t\t.LocalGreen\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: D1FAC1 ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder: 1x;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\nSPAN.LABEL\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  TEXT-ALIGN: LEFT;\n  /*TEXT-ALIGN: RIGHT;*/\n  PADDING-LEFT:7px;\n  PADDING-RIGHT:7px\n}\nSPAN.SpanGreen\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: D1FAC1 ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\t/* PADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px */\n\t\t}\n\n</style>\n</HEAD>\n\n<script>\t\t\nfunction highlightRow1(obj,qryClass){\n\tvar frm =  document.resultForm;\n\tvar rowClicked = frm.rowClicked.value;\n\tif(rowClicked != obj){\n\t\tif(rowClicked.length>0){\n\t\t\t$(\'#row\'+rowClicked+\' td\' ).each(function(){\n\t\t\t\t$(this).attr(\'class\',\'label\');\n\t\t\t});\t\n\t\t\t\n\t\t\t$(\'#row\'+rowClicked+\' td span\' ).each(function(){\n\t\t\t\t$(this).attr(\'class\',\'LABEL\');\n\t\t\t});\t\n\t\t}\t\n\t\t\n\t\t$(\'#row\'+obj+\' td\' ).each(function(){\n\t\t\t$(this).attr(\'class\',\'LocalGreen\');\t\t\t\n\t\t});\n\t\t\n\t\t$(\'#row\'+obj+\' td span\' ).each(function(){\n\t\t\t$(this).attr(\'class\',\'SpanGreen\');\n\t\t});\t\n\t\t}\n\tfrm.rowClicked.value = obj;\n}\n\t\nfunction interfaceReports(indx)\n{\n\tvar docTypeCode  = document.getElementById(\"doc_typ_code\"+indx).value;\n\tvar docNum = document.getElementById(\"doc_num\"+indx).value;\n\tvar patientId = document.getElementById(\"patient_id\"+indx).value;\n\tvar episodeType = document.getElementById(\"episode_type\"+indx).value;\n\tvar episodeId = document.getElementById(\"episode_id\"+indx).value;\n\tvar facility_id = document.getElementById(\"facility_id\").value;\n\tvar visitId = document.getElementById(\"visit_id\"+indx).value;\n\tvar locale = document.getElementById(\"locale\").value;\n\tvar login_user =$(\'#login_user\').val();\n\t\n\tvar p_report_id=\"BLRBLPRT\";\n\tvar  p_module_id = \"BL\" ;\n\tvar detailed_yn =\'Y\';\n\t$.ajax({\n\t\ttype:\"GET\",\n\t\turl:\"../jsp/BLCommonReportValidation.jsp\",\n\t\tdata:\"func_mode=ReprintReport &p_report_id=\"+p_report_id+\n\t\t\t\"&param1=\"+docTypeCode+\n\t\t\t\"&param2=\"+docTypeCode+\n\t\t\t\"&param3=\"+docNum+\n\t\t\t\"&param4=\"+docNum+\n\t\t\t\"&param5=\"+\n\n\t\t\t\"&param6=\"+detailed_yn+\n\t\t\t\"&param7=\"+\"R\"+\n\t\t\t\"&param8=\"+locale+\n\t\t\t\"&param9=\"+\n\t\t\t\"&param10=\"+\n\t\t\t\n\t\t\t\"&param11=\"+\n\t\t\t\"&param12=\"+\n\t\t\t\"&param13=\"+\n\t\t\t\"&param14=\"+episodeType,\n\t\tdataType:\"text\",\n\t\tasync:false,\n\t\tsuccess: function(data){\n\t\t\tvar dummyDoc = parent.parent.dummyFrame.document;\n\t\t\tvar retVal = trimString(data).split(\":::\");\n\t\t\tvar session_id = \'\';\n\t\t\tvar pgm_date = \'\';\n\t\t\tif(retVal.length == 2){\n\t\t\t\tsession_id = retVal[0];\n\t\t\t\tpgm_date = retVal[1];\n\t\t\t}\n\t\t\tvar htmlVal = \"<html><body>\";\n\t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eBL/jsp/InterfaceReports.jsp\' >\";\n\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+facility_id+\"\'>\";\n\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'\"+locale+\"\'>\";\n\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+p_report_id+\"\'>\";\n\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_session_id\' id=\'p_session_id\' value=\'\"+session_id+\"\'>\";\n\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_date\' id=\'p_pgm_date\' value=\'\"+pgm_date+\"\'>\";\n\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+p_module_id+\"\'>\";\n\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_id\' id=\'p_pgm_id\' value=\'\"+p_report_id+\"\'>\";\n\t\t\t\n\t\t\thtmlVal += \"</form></body></html>\";\n\t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n\t\t\tdummyDoc.dummy_frm.submit();\n\t\t\t},\n\t\t\t error: function(data){\n\t\t  }\n\t});\n}\n</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body>\n\t<form name=\'resultForm\' id=\'resultForm\'> \n\t<div class=\"div1\">\t\n\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n  <tr>\n    <td rowspan=\"2\"><img src=\"../../eCommon/jsp/DisplayImages.jsp?param=facilityimage\" width=\"196\" height=\"47\" /></td>\t\n\t<td><b>Patient ID\t:</b>\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td><b>Patient Name\t:</b>\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</</td>\n\t<td><b>Encounter ID\t:</b>\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</</td>\n\n\t</tr><tr>\n\t<td><b>Gender\t:</b>\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td><b>Date of Birth\t:</b>\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td><b>Speciality\t:</b>\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n</tr>\n</table>\n</br>\n<TABLE id=\"myTable\" border=\'1px solid black;\' cellpadding=\'10\' cellspacing=\'0\' align=\'left\' width=\'30%\'>\n<tr>&nbsp;</tr>\n<tr>\n\t<td class=\'COLUMNHEADER\' width=\'5%\'style=\"white-space: nowrap;text-align:center;\" >Bill Document Number</td>\n\t<td class=\'COLUMNHEADER\' width=\'12%\' style=\"white-space: nowrap\">Document Date</td>\t\n\t<td class=\'COLUMNHEADER\' width=\'15%\' style=\"white-space: nowrap\">Bill Amount</td>\n</tr>\n<tbody>\t\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<!--tr id=row";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onclick=\'highLight(";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =",\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\'-->\n\t\t<tr id=row";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" onclick=\'highlightRow1(";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\")\'>\n\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="_col0\' class=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" width=\"50%\" class=\"fields\" style=\'cursor:pointer; white-space: nowrap\' onclick=\"interfaceReports(";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =");\" scrolling=\'yes\'>\n\t\t\t\t<a href class=\"LABEL\" name=\'doc_num/type";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'doc_num/type";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a>\n\t\t\t\t</td>\n\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="_col1\' class=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" width=\"30%\" class=\"fields\" style=\"white-space: nowrap\">\n\t\t\t\t\t<span class=\"LABEL\" name=\'doc_date";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'doc_date";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</span> \n\t\t\t\t</td>\n\n\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="_col2\' class=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" width=\"20%\" class=\"fields\"style=\"white-space: nowrap\">\n\t\t\t\t\t<span class=\"LABEL\" name=\'bill_tot_amt";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'bill_tot_amt";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</span> \n\t\t\t\t</td>\n\t\t\t<input type=\'hidden\'  name=\'file_path";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'file_path";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\t\n\t\t\t</tr>\n\t\t\t<input type=\'hidden\' id=\'doc_typ_code";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' name=\'doc_typ_code";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t<input type=\'hidden\' name=\'doc_num";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'doc_num";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'patient_id";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t<input type=\'hidden\' name=\'episode_type";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'episode_type";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=\'hidden\'  name=\'episode_id";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'episode_id";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\'hidden\'  name=\'visit_id";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'visit_id";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t<input type=\'hidden\'  name=\'facility_id\' id=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\t\n ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n<tbody>\t\n\t</table>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t<input type=\'hidden\' name=\'login_user\' id=\'login_user\' id=\'login_user\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\'hidden\' name=\'rowClicked\' id=\'rowClicked\' id=\'rowClicked\' value = \'\'>\n\t</div>\n\t</form>\n\t</body>\n</html>\n<!--JSP Created Against AAKH-CRF-0113.3-->\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );
	
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


	private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}

public String billingFormatConverter(Connection con, String amount) {	
	PreparedStatement pstmt_dec = null;
	ResultSet rs_dec = null;
	int noofdecimal = 2;
	try {	
		pstmt_dec = con.prepareStatement(" select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");
		rs_dec = pstmt_dec.executeQuery();
		if (rs_dec.next() && rs_dec != null)
			noofdecimal = rs_dec.getInt(1);
		if (rs_dec != null)
			rs_dec.close();
		if (pstmt_dec != null)
			pstmt_dec.close();
		if (amount == null || "".equals(amount)) {
			amount = "0.00";
		} else {
			CurrencyFormat cf = new CurrencyFormat();
			amount = cf.formatCurrency(amount, noofdecimal);
		}
	} catch (Exception e) {
		System.out.println("Exception Getting Number of Decimals. " + e.toString());
		e.printStackTrace();
	}
	return amount;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");		
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt5 = null; 
	PreparedStatement pstmt4 = null;
	PreparedStatement pstmt3 = null;
	
	ResultSet rs =null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs5 = null;
	ResultSet rs4 = null;
	ResultSet rs3 = null;
	
	String locale="";	
	String classval="";
	
	String interface_values = "";
	String speciality_desc = "";
	String facility_id = "";
	String patient_id = "";
	String patient_name = "";
	String encrypted_yn = "";
	String episode_type = "";
	String episode_id = "";
	String visit_id = "";
	String encounter_id = ""; 
	String doc_type_code = "";
	String doc_num = "";
//	String num_of_reports="";	//checklist
	String date_of_birth="";	
	String gender="";	
	String doc_date="";	
	String bill_amt="";	
	String file_path="";	 
	 
//	HttpSession httpSession = request.getSession(false);//checklist
	con =  ConnectionManager.getConnection(request);
	String jdbc_username="";
	String jdbc_password="";
	String jdbc_dns="";
	String jdbc_driver="";
	String login_app_user="";
	String login_id = System.getProperty("user.name");
	String client_ip_address = request.getRemoteAddr();
	//String locale=""	;
	try
	{	
		String paramString = request.getQueryString();		
		String interface_query = "SELECT PARAM_STRING FROM XH_EXTERNAL_CALL WHERE INT_SHORT_ID='"+paramString+"'";
		
		pstmt2 = con.prepareStatement(interface_query);		
		rs2 = pstmt2.executeQuery();		
		if(rs2 != null)
		{
			while(rs2.next()){
				interface_values = rs2.getString(1);
		}
		}
		//interface_values = "facility_id=AK&patient_id=0000008&encounter_id=100056190001&encrypted=Y";
		String[] interface_Arrvalues = interface_values.split("&");
		facility_id=interface_Arrvalues[0].substring(interface_Arrvalues[0].indexOf("=")+1);
		patient_id=interface_Arrvalues[1].substring(interface_Arrvalues[1].indexOf("=")+1);
		encounter_id=interface_Arrvalues[2].substring(interface_Arrvalues[2].indexOf("=")+1);
		encrypted_yn=interface_Arrvalues[3].substring(interface_Arrvalues[3].indexOf("=")+1);
		//con =  ConnectionManager.getConnection(request);	
		String sql = "select app_password.decrypt(appl_user_password),language_id from sm_appl_user where appl_user_id = ?";
		String sql1="select USER_ID,app_password.decrypt(password),CONNECT_STRING,DB_DRIVER  from sm_db_info" ;
			
		pstmt=con.prepareStatement(sql);
		pstmt1=con.prepareStatement(sql1);
		pstmt.setString(1,login_id);
		
		rs=	pstmt.executeQuery();
		rs1=pstmt1.executeQuery();
		while(rs.next()) 
		{
			login_app_user	=rs.getString(1);	
			locale	=rs.getString(2);	
		}
		while(rs1.next())
		{
			jdbc_username	=rs1.getString(1);	
			jdbc_password	=rs1.getString(2);
			jdbc_dns	=rs1.getString(3);
			jdbc_driver =rs1.getString(4);	
		}
		
		}
		catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				/* if (con != null) {
					ConnectionManager.returnConnection(con);
				} */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		//String jdbc_props = "";
		session.putValue("facility_id",facility_id);
		session.putValue("login_user",login_app_user);
		session.putValue("connection_pooling_yn","Y");
		session.putValue("LOCALE","en");
		session.putValue("PREFERRED_STYLE","IeStyle.css");
		
		Properties p = new Properties();
		
		p.setProperty( "login_user",login_app_user);
		//p.setProperty("login_pwd",strLogged_app_password);
		p.setProperty("connection_pooling_yn","Y") ;
		//p.setProperty("client_ip_address","CSCINDAE751724");
		p.setProperty("client_ip_address",client_ip_address);
		p.setProperty("strLogged_dns",jdbc_dns);
		p.setProperty("strLogged_driver",jdbc_driver) ;
		p.setProperty("ecis_jdbc_user",jdbc_username);
		p.setProperty("ecis_jdbc_password",jdbc_password);
		session.putValue( "jdbc",p );

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

 try
 { 
	String patient_details = "SELECT patient_name,TO_CHAR (date_of_birth, 'dd/mm/yyyy') date_of_birth,DECODE (sex, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender FROM mp_patient WHERE patient_id = '"+patient_id+"' and added_facility_id='"+facility_id+"'";
	pstmt3 = con.prepareStatement(patient_details);
	rs3 = pstmt3.executeQuery();
	if(rs3 != null)
	{
		while(rs3.next()){
			patient_name = rs3.getString(1);
			date_of_birth = rs3.getString(2);
			gender = rs3.getString(3);				
		} 
	}
				
	String speciality = "select distinct am_get_desc.am_speciality(b.specialty_code,'en','1') spec_desc from bl_bill_hdr a, pr_encounter b where b.ENCOUNTER_ID = '"+encounter_id+"'";
	pstmt4 = con.prepareStatement(speciality);
	rs4 = pstmt4.executeQuery();
	if(rs4 != null)
	{
		while(rs4.next()){
			speciality_desc = rs4.getString(1);
		}
	}			
	}catch(Exception eX)
	{	
		System.err.println("354,Exception==>"+eX);		
		out.println("Error= "+eX);
		eX.printStackTrace();
	}
	finally
	{
		if (rs3 != null)   rs3.close();
		if (rs2 != null)   rs2.close();
		if (rs4 != null)   rs4.close();
		if (pstmt3 != null) pstmt3.close();
		if (pstmt4 != null) pstmt4.close();
		if (pstmt2 != null) pstmt2.close();
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

int i=1;
try
{
	String query_interface = "select a.operating_facility_id, b.patient_id, c.patient_name, c.date_of_birth, c.sex gender,b.episode_type, b.episode_id, b.visit_id, a.encounter_id, d.visit_adm_date_time encounter_date, g.practitioner_name doctor_name, b.doc_type_code , b.doc_num bill_reference,to_char(b.doc_date,'dd/mm/yyyy hh24:mi'), b.bill_amt, a.file_name, a.shared_path||a.file_name FROM BL_SMS_BILL_PRINT A, BL_BILL_HDR B, MP_PATIENT C,PR_ENCOUNTER D, IP_WARD E, OP_CLINIC F, AM_PRACTITIONER G WHERE a.doc_type_code = b.doc_type_code AND a.doc_num   = b.doc_num AND   b.patient_id    = c.patient_id AND   b.operating_facility_id = d.facility_id AND   a.encounter_id  = d.encounter_id AND   b.physician_id = g.practitioner_id AND   d.assign_care_locn_code = e.ward_code AND   a.episode_type in ('I','D')  AND   d.facility_id = '"+facility_id+"' AND   d.encounter_id='"+encounter_id+"'  UNION SELECT a.operating_facility_id, b.patient_id, c.patient_name, c.date_of_birth, c.sex gender, b.episode_type, b.episode_id, b.visit_id, a.encounter_id, d.visit_adm_date_time encounter_date, g.practitioner_name doctor_name, b.doc_type_code, b.doc_num bill_reference,to_char(b.doc_date,'dd/mm/yyyy hh24:mi'), b.bill_amt, a.file_name, a.shared_path||a.file_name FROM BL_SMS_BILL_PRINT A, BL_BILL_HDR B, MP_PATIENT C,PR_ENCOUNTER D, OP_CLINIC F, AM_PRACTITIONER G WHERE a.doc_type_code = b.doc_type_code AND   a.doc_num       = b.doc_num AND   b.patient_id    = c.patient_id AND   b.operating_facility_id = d.facility_id AND   a.encounter_id  = d.encounter_id AND   b.physician_id = g.practitioner_id AND   d.assign_care_locn_code = f.clinic_code(+) AND   f.clinic_code IS NOT NULL AND   a.episode_type in ('O','E') AND   d.facility_id = '"+facility_id+"' AND   d.encounter_id= '"+encounter_id+"' ORDER BY 1,9,12";
	pstmt5 = con.prepareStatement(query_interface);		
	rs5 = pstmt5.executeQuery();		
	classval = "label";
	if(rs5 != null)
	{
		while(rs5.next()){
			doc_type_code = rs5.getString(12);
			doc_num = rs5.getString(13);
			doc_date = rs5.getString(14);
			bill_amt = rs5.getString(15);
			file_path = rs5.getString(16);
			bill_amt=billingFormatConverter(con,bill_amt);				

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(doc_num));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doc_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bill_amt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(file_path));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(doc_num));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block52Bytes, _wl_block52);

		i++;
		}
	}			

            _bw.write(_wl_block53Bytes, _wl_block53);
				
		}
		catch(Exception eX)
		{		
			out.println("Error= "+eX);		
		}
		finally
		{
			if (rs3 != null)   rs3.close();
			if (pstmt3 != null) pstmt3.close();
			if (rs5 != null)   rs5.close(); 
			if (pstmt5 != null) pstmt5.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf((String)session.getAttribute("login_user")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block56Bytes, _wl_block56);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
