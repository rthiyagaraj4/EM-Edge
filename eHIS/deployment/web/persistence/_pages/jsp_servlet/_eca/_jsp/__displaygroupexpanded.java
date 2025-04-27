package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __displaygroupexpanded extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/DisplayGroupExpanded.jsp", 1738424675286L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    <head>\n    <style>\n    .test\n    {\n    clear: both;\n    }\n\n.container {\n\toverflow: scroll;\n\theight: 200px;\n}\ntd.data  {\n\tfont-size:10px;\n\t\n}\n.gridTooltipData\n{\n\tbackground-color: #FEFFE5;\n\tfont-family: Verdana;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tpadding-top:10px;\n\tpadding-bottom:10px;\n\tvertical-align:middle;\n\tborder-bottom:1px;\n\tborder-top:1px;\n\tborder-left:1px;\n\tborder-right:1px;\n\tborder-style:solid;\n\tborder-color:#DCDCDC;\n} \n.gridDataSelect\n{\n\tbackground-color: #CDE5FF;\n\tfont-family: Verdana;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tvertical-align:middle;\n\tborder-bottom:1px;\n\tborder-top:1px;\n\tborder-left:1px;\n\tborder-right:1px;\n\tborder-style:solid;\n\tborder-color:#0460B5;\n} \n    </style>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n    <title>Untitled Document</title>\n\t<link rel=\"stylesheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" type=\"text/css\" />\n    <link href=\"../../eCA/html/GroupDisplayStyle.css\" rel=\"stylesheet\" type=\"text/css\" />\n    <link href=\"../../eCA/html/GroupDisplayWeb.css\" rel=\"stylesheet\" type=\"text/css\" />\n    <script type=\"text/javascript\" src=\"../../eCA/js/GroupDisplay.js\"></script>\n    <script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n    </head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n    <body>\n    <form name=\"grpdispdetail\" id=\"grpdispdetail\">\n    <table style=\"width:100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n      <tr>\n        <td align=\"left\" valign=\"middle\" class=\"HeaderMenu\">\n\t\t<table style=\"width:100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n            <tr>\n            ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n            <td width=\"4%\" align=\"left\" valign=\"top\" onclick=\"loadgroupdtl(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\" class=\"HeaderMenutxt HMselect\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n            ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\" class=\"HeaderMenutxt\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n           ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n             <td width=\"96%\" align=\"left\" valign=\"top\"  class=\"\">&nbsp;</td>\n          </tr>\n          </table></td>\n      </tr>\n      <tr>\n\t  <TD vAlign=middle align=left>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<table style=\"width:100%\"  border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n  \n\n    <tr>\n    <td style=\"width: 15%;height:28px\" nowrap class=\'CAFLOWSHEETLEVEL3\'  >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n    \t<td style=\'width=8%\'  nowrap class=\'CAFLOWSHEETLEVEL3\'  >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<td style=\'width=8%\'>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n    </tr>\n    ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n    <tr class=\'GridViewScrollItem\'>\n    <td class=\'data\' nowrap >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n    ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<td >\n\t\t\t\t\t<table>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n   \t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t   \t\t\t\t<td>&nbsp;</td>\n   \t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n   \t\t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td  style=\'width=8%\'> &nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n    </tr>\n\n    ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</table></td>\n</tr>\n</table>    \n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/>\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"/>\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"/>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"/>\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"/>\n<input type=\"hidden\" name=\"from_date\" id=\"from_date\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"/>\n<input type=\"hidden\" name=\"to_date\" id=\"to_date\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"/>\n<input type=\"hidden\" name=\"grphistory_type\" id=\"grphistory_type\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"/>\n<input type=\"hidden\" name=\"orderCatalogNature\" id=\"orderCatalogNature\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"/>\n<input type=\"hidden\" name=\"clinician_id\" id=\"clinician_id\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"/>\n<input type=\"hidden\" name=\"resp_id\" id=\"resp_id\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"/>\n<input type=\'hidden\' name=\'txtFlagComments\' id=\'txtFlagComments\' value=\"N\">\n<input type=\'hidden\' name=\'txtFlagQuickText\' id=\'txtFlagQuickText\' value=\"N\">\n<input type=\'hidden\' name=\'normalcy\' id=\'normalcy\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\'hidden\' name=\'queryStringForComments\' id=\'queryStringForComments\' value=\"\">\n<input type=\"hidden\" name=\"fac_id\" id=\"fac_id\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n</form>\n</body>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\'  style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'yellow\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' class=\'gridTooltipData\' id=\'t\' nowrap></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div>\n<script>\n//loadYearMonth(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');\n</script>\n<script>\n\t\t\tif(top.content!=null)\n\t\t\t{\n\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t}else\n\t\t\t{\n\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t}\n</script>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t<script>\n\t\t\t//parent.dataFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tif(top.content!=null)\n\t\t\t{\n\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\t\n\t\t\t}else\n\t\t\t{\n\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\t\n\t\t\t}\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n</html>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );
	
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


	String replaceSpecialChar(String resultStr)
	{		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~ ");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("\\")!=-1) 
			resultStr = resultStr.replaceAll("\\\\","&#92");
		if(resultStr.indexOf("|")!=-1) 
			resultStr = resultStr.replaceAll("\\|","&#124");
		if(resultStr.indexOf("`")!=-1) 
			resultStr = resultStr.replaceAll("`","&#96");			
		if(resultStr.indexOf("'")!=-1) 
			resultStr = resultStr.replaceAll("'","&#39");
		if(resultStr.indexOf("~")!=-1) 
			resultStr = resultStr.replaceAll("~","&#126");
		if(resultStr.indexOf("\"")!=-1) 
			resultStr = resultStr.replaceAll("\"","\\\"");		
		if(resultStr.indexOf("+")!=-1) 
			resultStr = resultStr.replaceAll("\\+","&#43");	
		return resultStr;
	}
	//IN071374 Start.
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class) 
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class, String html_image_upld_id) 
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class, String html_image_upld_id, String event_class, String moreValues) 
	//IN071374 End.
	HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class, String html_image_upld_id, String event_class, String moreValues,String lv_neonate_spec_yn,Boolean isSiteSpecificNeonatalMotherSpecimen)//31792 

	{
		int i = prevK;
		int j = columnNumber;

		String tempToolTip = toolTip.replace('\'',' ');

		String tempString = "";
		String classValue = "";
		String classValueGrn = "";
		String tempStrValue = "";
		String tempOnMouseOver = "";
		String displayStyle = "gridDataChart";
		
		HashMap returnMap = new HashMap();

		eCA.CAExternalLinkDataDTO externalDataDTO = null; 
		eCA.CAEncounterList oEncounterList = new eCA.CAEncounterList();  
		
		String ext_image_appli_id = "";
		String ext_image_obj_id = "";
		String ext_image_source = "";
		String ext_srce_doc_ref_no = "";
		String ext_srce_doc_ref_line_no = "";
		ArrayList externalList = null;

		String labResultModifiedNotifier = ""; 
		classValue = "CACHARTQRYEVEN";

		if(keyList.contains(enctr_id+"`"+histRecType+"`"+sysID+"`"+accessionNum+"`"+sysEventCode))
			displayStyle = "gridDataSelect";
		else
			displayStyle = "gridDataChart";

		if(histDataType.equals("NUM"))
		{
			tempValue =tempValue+"<input type='hidden' name='resultNum' id='resultNum' value='"+resultNum+"'>"; 
			if(!tempAdditional.equals(""))
			{
				tempAdditional=replaceSpecialChar(tempAdditional.trim());
				//IN070080 STARTS
				if(tempAdditional.length() > 11)
					tempValue =tempValue+ "&nbsp;" + "<a  href='javascript:ShowComments(\""+tempAdditional+"\")'><font size='1' color='black'><i>"+tempAdditional.substring(0,10)+"..</i></a>";
				else
						tempValue =tempValue+ "&nbsp;" + "<a  href='javascript:ShowComments(\""+tempAdditional+"\")'><font size='1' color='black'><i>"+tempAdditional+"</i></a>";
			}//IN070080 ENDS
			if(!textCount.equals("0"))
			{
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' src='../../eCA/images/flow_text.gif' style='display' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";
			}
		}
		else if(histDataType.equals("TXT") || histDataType.equals("HTM"))
		{
			if(!tempAdditional.equals("")) 
			{	
				tempAdditional=replaceSpecialChar(tempAdditional);
				
			}

			if(!textCount.equals("0"))
			{
				tempValue = tempValue+ "&nbsp;" +"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">"; 
			}
		}
		else if(histDataType.equals("STR"))
		{
			

				//IN070080 STARTS
				if(tempValue.length() > 11)
				{
				tempStrValue = tempValue.substring(0,10);
				}
				//IN072473 starts
				else
					tempStrValue = tempValue;
			if(tempValue.length() > 11)
			{
				tempValue = replaceSpecialChar(tempValue);
				tempValue=java.net.URLEncoder.encode(tempValue);
				tempValue = "<a  href=\"javaScript:ShowComments('"+tempValue+"')\"><font size='1' color='black'>"+tempStrValue+"..</a>";
			}//IN070080 ENDS
			else
				tempValue = "<a  href=\"javaScript:ShowComments('"+tempValue+"')\"><font size='1' color='black'>"+tempStrValue+"</a>";
			// IN072473 ends	
			if(!normalcy_str.equals(""))
			{
				tempValue = tempValue + " <font color=blue>( Normal Value : " + normalcy_str + " )</font>";
			}
			if(!textCount.equals("0"))
			{
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";
			}
		}

		if("LBIN".equalsIgnoreCase(histRecType) && "C".equalsIgnoreCase(strStatus)) {
			labResultModifiedNotifier = "<img id='modified_icon' style='display' src='../../eCA/images/modifiedresult.png' alt='Result Modified'>" + "&nbsp;";	
			tempValue = labResultModifiedNotifier + tempValue;
		}

		if(!tempValue.equals(""))
		{
			if(!called_from.equals("OR"))
			{
				if(quickTextCount.equals("0"))
				{
					tempValue =tempValue+ "&nbsp;"+"<img title='Click to view the comments' style='display:none' name='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/II_comment.gif' onClick=\" return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}
				else
				{
					tempValue =tempValue+ "&nbsp;"+"<img title='Click to view the comments' name='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/II_comment.gif' onClick=\" return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}
			}
			if(!called_from.equals("OR"))
			{
				if(strStatus.equals("E"))
				{
					 tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\" " ;
				}
				else if(strNormalcyInd.equals("I") && !strNormalcyInd.equals(""))
				{
					if(!colorCellInd.equals("NONE"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/"+colorCellInd+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					else if(normal_Yn.equals("Y"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;

					tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+eventCode+i+"ID' style='cursor:pointer;border:0px' align='center' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"') \" ";
				}
				else if(strNormalcyInd.equals("C") && !strNormalcyInd.equals(""))
				{
					if(!colorCellInd.equals("NONE"))
					{
						tempValue = "<font  style='background-color:"+colorCellInd+";size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					else if(normal_Yn.equals("Y"))
					{
						tempValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+eventCode+i+"ID' style='cursor:pointer;border:0px' align='center' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\" ";
				}
				else
				{
					tempString = tempString + "<TD class='gridDataSelect' background-color: #CDE5FF; style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID'  onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
				}
			}
			else
			{
				if(strStatus.equals("E"))
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
				}
				else if(legend_type.equals("S"))
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
					
					if(!colorCellInd.equals("NONE"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/"+colorCellInd+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					else if(normal_Yn.equals("Y"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
				}
				else if(legend_type.equals("C"))
				{
					if(!colorCellInd.equals("NONE"))
					{
						tempValue = "<font  style='background-color:"+colorCellInd+";size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					else if(normal_Yn.equals("Y"))
					{
						tempValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
				}
				else
				{
					tempString = tempString + "<TD class='"+displayStyle+"' background-color: #CDE5FF; style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
				}
			}
		}
		else
		{
			if(strStatus.equals("E"))
			{
				tempString = tempString + "<TD align='center' class='TD_BROWN' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
			}
			else
			{
				tempString = tempString + "<TD align='center' background-color: #CDE5FF; class='"+displayStyle+"' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";				
			}
		}

		if(!tempToolTip.equals("") || !toolTip_ind.equals(""))
		{
			tempOnMouseOver="onMouseOver=\"displayToolTip('"+tempToolTip+"','"+toolTip_ind+"',this)\" onMouseOut =hideToolTip('"+i+"','"+j+"')";
			 tempString = tempString + tempOnMouseOver;
		}

		
		if(tempValue.equals("")) 
		{
			tempValue = "&nbsp;";
		}

		
		if(!extApplID.equals(""))
		{
			if(!("DMS").equals(extApplID)) {
				if(!("DOCUL").equals(extApplID) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")))
				{
				
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+extImgID+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\">";
				}
				else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
				{
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\">";
				}
				else if (!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
					if(!recCountInt.equals(null) && !recCountInt.equals("")) {
						int recordcount = Integer.parseInt(recCountInt);
						if(recordcount > 0) 
						{	
							tempValue =tempValue+"&nbsp;"+"<a style='cursor:pointer;color:blue;border:0px' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>";
						}
					}		
				}
			}
		}
		
		
		if("Y".equals(dmsExternalLinkYN)){
			
			try {
				externalList = oEncounterList.getExternalLinkdata(histRecType, sysID, accessionNum, sysEventCode); 
				Iterator iter = externalList.iterator();
				while(iter.hasNext()){
					externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
					ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
					ext_image_obj_id = externalDataDTO.getExt_image_obj_id();
					ext_image_source = externalDataDTO.getExt_image_source();
					ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
					ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();
					
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCommon/images/ExternalDocument.PNG'  title='External Link' onClick=\"return getExtLink('"+strPatientId+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+patient_class+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"; 
				}	
			} catch(Exception ex ){
				System.out.println(" 1517,FlowSheetEventsData.jsp => " + ex.getMessage());
			}
		}
		if(strStatus.equals("P"))
			tempValue = tempValue+" <font color='red'>(Preliminary)</font>";

		if(!deltaFailInd.equals(""))
		{
			tempValue = tempValue+"<font color='red'>["+deltaFailInd+"]</font>";
		}
		if((strNormalcyInd.equals("I") || strNormalcyInd.equals("B") )&& !strNormalcyInd.equals("") && !colorCellInd.equals("NONE"))
		{
			//tempValue = tempValue+ "<font color='black'><b>["+descCellInd+"]</b></font>";
		}
		//IN071374 Start.
		if(!html_image_upld_id.equals(""))
		{
			tempValue = tempValue + "&nbsp;"+ "<img src='../../eCA/images/IniAss.png' onClick=\"return getFile_SH('"+java.net.URLEncoder.encode(accessionNum)+"')\">";
		}
		//IN071374 End.
		//31792 starts
		if(isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){
		tempString = tempString + ">" + tempValue + "&nbsp;<input type='image' src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails('"+order_id+"','"+accessionNum+"','"+histRecType+"','"+strPatientId+"')\"><br>" + strMoreDlt;
		}
		else{
		tempString = tempString + ">" + tempValue + "&nbsp;<br>" + strMoreDlt;
		}
		//31792 ends
		if ("Y".equals(moreValues))
			tempString = tempString + "<a href=\"javascript:callResults('"+ eventDateTime + "','" + eventDateTime
					+ "','" + eventDesc + "','" + histRecType + "','" + event_class + "','" + eventGroup + "','" + eventCode
					+ "')\" title='Click to view other recording of this event for the same time' >More Values...</a>";
		tempString = tempString + "</TD>";
		try {
			returnMap.put("tempString", tempString);
			returnMap.put("histRecType" + i, histRecType);
			returnMap.put("eventClass" + i, eventClass);
			returnMap.put("eventGroup" + i, eventGroup);
			returnMap.put("eventCode" + i, eventCode);
			returnMap.put("eventDateTime" + i + "Map" + j, eventDateTime);
			returnMap.put("resultNum" + i + "Map" + j, resultNum);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return returnMap;
	}// end of drawTD


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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/10/2018	IN068145		Raja S				22/10/2018		Ramesh G		ML-MMOH-CRF-1212
29/03/2019	IN070080		SIVABAGYAM M	    29/03/2019		Ramesh G		CA-ML-MMOH-CRF-1317-US004-01
06/01/2020	IN071374		Ramesh Goli			06/01/2020		Ramesh G		ML-MMOH-SCF-1367	
21/02/2020	IN072473	SIVABAGYAM M		21/02/2020		RAMESH G		ML-MMOH-SCF-1477
05/05/2020	IN072901	SIVABAGYAM M		05/05/2020		RAMESH G		ML-MMOH-SCF-1477.1
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block2Bytes, _wl_block2);

	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	ArrayList eventClassArr = new ArrayList() ;
	String bean_id					= "GroupCompDetailBean" ;
	String bean_name				= "eCA.GroupCompDetailBean";
	String patient_id				= request.getParameter("patient_id");
	String clinician_id			= (String) session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String strNormalcyInd = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
	String fromDate="",toDate="";
	String fac_id1 = (String)session.getValue("facility_id");
	fromDate = request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	toDate = request.getParameter("to_date")==null	?"":request.getParameter("to_date");
	String login_user = (String)session.getValue("login_user");
	boolean isSiteSpecificNeonatalMotherSpecimen=false;//31792
	

		String tempDisplayEventCode ="";
		String tempDisplayEventGroup = "";
		String tempDisplayHistRecType = "";
		String tempDisplayEventClass ="";
		String sortEventDateTime ="";



		String order_id = "";
			String login_at_ws_no ="";
			String order_typ_code = "";
			String admit_date ="";
			String locn_code ="";
			String locn_type="";
			String visit_id="";
			String loc_desc="";
			String physician_id="";
			String patient_class="";
			int tempNumOfCols= 1;
			int k=1;
			String called_from		= "";
			String event_class      = "";
			int prevK = 0;
	
	if (toDate.equals(""))
		toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	


	String grphistory_type			= request.getParameter("grphistory_type")==null	?"":request.getParameter("grphistory_type");
	String loadDefaultGrp			= request.getParameter("loadDefaultGrp")==null	?"":request.getParameter("loadDefaultGrp");
	String loadDefaultclass			= request.getParameter("loadDefaultclass")==null	?"":request.getParameter("loadDefaultclass");
	String loadDefaultYear			= request.getParameter("loadDefaultYear")==null	?"":request.getParameter("loadDefaultYear");
	String loadDefaultMonth			= request.getParameter("loadDefaultMonth")==null	?"":request.getParameter("loadDefaultMonth");
	String catalog_nature			= request.getParameter("orderCatalogNature")==null	?"":request.getParameter("orderCatalogNature");
	LinkedHashMap groupResultMap = null;
	ArrayList groupHeaderVal = new ArrayList() ;
	GroupCompDetailBean bean	= (GroupCompDetailBean)getBeanObject( bean_id, bean_name , request) ; 

try
{
	con = ConnectionManager.getConnection(request);
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounterId,"eCA.PatientBannerGroupLine",session);
	ArrayList keyList = manageEmailBean.returnList2();
	String dmsExternalLinkYN = manageEmailBean.getExternalDmsLinkYN(fac_id1);
	eventClassArr = bean.getEventClass(con,locale,patient_id,encounterId,clinician_id,resp_id,catalog_nature,grphistory_type,fromDate,toDate);
	isSiteSpecificNeonatalMotherSpecimen = eCommon.Common.CommonBean.isSiteSpecific(con,"OR","NEONATAL_MOTHER_SPECIMEN");//31792
	if(eventClassArr!=null && !(eventClassArr.isEmpty()) )
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);
for(int i=0;i<eventClassArr.size();i++) {
            	String[] eventClassStr =(String[])eventClassArr.get(i);
            
            if(loadDefaultclass.equals("")){
            	loadDefaultclass=(String)eventClassStr[0];
            }
            if(loadDefaultclass.equals(eventClassStr[0])){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(eventClassStr[0]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(eventClassStr[1]));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(eventClassStr[0]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(eventClassStr[1]));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            } 
            _bw.write(_wl_block15Bytes, _wl_block15);

				
groupResultMap=bean.getGroupExpDetails(pageContext,con,locale,login_user,grphistory_type,catalog_nature,loadDefaultclass,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate);
LinkedHashMap MaxColCount = (LinkedHashMap)groupResultMap.get("MaxColCount");
HashMap ColCount = (HashMap)MaxColCount.get("ColCount");
ArrayList colCountArr=(ArrayList)ColCount.get("tempColCount");
int maxColCount =(Integer)colCountArr.get(0);
System.out.println("raja "+maxColCount);

            _bw.write(_wl_block16Bytes, _wl_block16);

	for (Object key : groupResultMap.keySet()) {
	String event_group=(String)key;
	int tempColCount =maxColCount;
	LinkedHashMap dateValuesMap = (LinkedHashMap)groupResultMap.get(key);
	if(!event_group.equals("MaxColCount"))
	{
	groupHeaderVal=bean.getTestHeaderLevel(con,locale,grphistory_type,catalog_nature,loadDefaultclass,event_group,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate);
	String groupHeaderDesc[] =(String[])groupHeaderVal.get(0);

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(groupHeaderDesc[1]));
            _bw.write(_wl_block18Bytes, _wl_block18);
    
    for(int i=1;i<=groupHeaderVal.size()-1;i++)
    {
    	String groupHeader[] =(String[])groupHeaderVal.get(i);
    	tempColCount--;
    	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(groupHeader[1]));
            _bw.write(_wl_block20Bytes, _wl_block20);

    }

            _bw.write(_wl_block2Bytes, _wl_block2);
for(int j=1;j<=tempColCount;j++){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
} 
            _bw.write(_wl_block22Bytes, _wl_block22);
for (Object key_1 : dateValuesMap.keySet()) 
    {
    	String event_date=(String)key_1;
    	int tempColCount1 =maxColCount;
    	HashMap testValues = (HashMap)dateValuesMap.get(key_1);
    	if(!event_date.equals("ColCount"))
    	{
    
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
 for(int j=1;j<=groupHeaderVal.size()-1;j++)
    {
    	String groupHeader[] =(String[])groupHeaderVal.get(j);
    	
    	if(testValues.containsKey(groupHeader[0])){
				ArrayList<String> eventDetails = new ArrayList<String>();
				eventDetails=(ArrayList)testValues.get(groupHeader[0]);
					String reqNum = (String)eventDetails.get(31);
					//if(reqNum.equals(groupHeader[2])){//commented for IN072901
					String eventDateTime=(String)eventDetails.get(0);
					String histDataType=(String)eventDetails.get(5);
					String resultNum=(String)eventDetails.get(3);
					String resultStr=(String)eventDetails.get(4);
					String extApplID=(String)eventDetails.get(6);
					
					String sysID=(String)eventDetails.get(7);
					String accessionNum=(String)eventDetails.get(8);
					String sysEventCode=(String)eventDetails.get(9);
					String extImgID=(String)eventDetails.get(10);
					
					String toolTip=(String)eventDetails.get(11);
					String toolTip_ind=(String)eventDetails.get(12);
					String deltaFailInd=(String)eventDetails.get(13);
					String quickTextCount=(String)eventDetails.get(14);
					String strStatus=(String)eventDetails.get(15);
					String textCount=(String)eventDetails.get(16);
					
					String colorCellInd=(String)eventDetails.get(17);
					String descCellInd=(String)eventDetails.get(18);
					String normIndicator=(String)eventDetails.get(19);
					String eventCode=(String)eventDetails.get(20);
					String eventDesc=(String)eventDetails.get(21);
					String legend_type=(String)eventDetails.get(22);
					String normalcy_str=(String)eventDetails.get(23);
					String fac_id=(String)eventDetails.get(24);
					String ext_image_upld_id=(String)eventDetails.get(25);
					String event_code_type=(String)eventDetails.get(26);
					String recCountInt =(String)eventDetails.get(27);
					String ext_img_file_locn =(String)eventDetails.get(28);
					String normal_Yn	= (String)eventDetails.get(30);
					String html_image_upld_id = (String)eventDetails.get(32); //IN071374
					String eventClass = (String) eventDetails.get(33); //Ramesh
					String moreValues = (String) eventDetails.get(34); //Ramesh
					String lv_neonate_spec_yn = (String) eventDetails.get(35); //31792
				
					if(strNormalcyInd.equals("I"))
						colorCellInd = (String)eventDetails.get(29);
					
					String tempAdditional = resultStr;
					String tempValue = "";
					if(histDataType.equals("NUM")) 
						tempValue = resultNum;
					else if(histDataType.equals("STR")) 
						tempValue = resultStr;
					else if(histDataType.equals("TXT") || histDataType.equals("IMG") || histDataType.equals("HTM")) 
						tempValue = "";
					
					  
	
					//IN071374 Start.
					//HashMap tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, event_group, event_class, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounterId,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class );
					//HashMap tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, event_group, event_class, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounterId,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class ,html_image_upld_id);
					//HashMap tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, event_group, event_class, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounterId,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class ,html_image_upld_id,eventClass, moreValues);
					//IN071374 End.
					HashMap tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, event_group, event_class, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounterId,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class ,html_image_upld_id,eventClass, moreValues,lv_neonate_spec_yn,isSiteSpecificNeonatalMotherSpecimen);//31792
				
					prevK++;
					String tempReturnString = (String) tempTRMap.get("tempString");
					tempColCount1--;
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tempReturnString));
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{
   						tempColCount1--;
   					
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
for(int j=1;j<=tempColCount1-1;j++){ 
            _bw.write(_wl_block29Bytes, _wl_block29);
} 
            _bw.write(_wl_block30Bytes, _wl_block30);
	}
    } 
            _bw.write(_wl_block2Bytes, _wl_block2);

	}

}

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(grphistory_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(catalog_nature));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(clinician_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(fac_id1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(loadDefaultclass));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(loadDefaultGrp));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(loadDefaultYear));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(loadDefaultMonth));
            _bw.write(_wl_block46Bytes, _wl_block46);
	}
	else{
		
		
            _bw.write(_wl_block47Bytes, _wl_block47);

		}

}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
	

            _bw.write(_wl_block48Bytes, _wl_block48);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
