package jsp_servlet._eca._jsp;

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
import java.math.*;
import eCA.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __clinicaleventhistoryresultdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventHistoryResultData.jsp", 1738424653485L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="<!--IN064688 Added  math.*-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<HEAD>\n\t<TITLE> New Document </TITLE>\n\t<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n\t<META NAME=\"Author\" CONTENT=\"\">\n\t<META NAME=\"Keywords\" CONTENT=\"\">\n\t<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t<script language=\'javascript\' src=\'../../eCA/js/ClinicalEventHistoryNew.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\t//IN070032 starts\n\tfunction onLinePrinting_date(event_grp,fdate){\n\t\tvar queryStr    = document.forms[0].queryString.value\n\t\tvar xmlDoc=\"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t   \txmlHttp.open(\"POST\", \"../../eCA/jsp/NewCEHIntermediate.jsp?\"+queryStr+\"&group=\"+event_grp+\"&fdate=\"+fdate+\"&Mode=printResult\", true);\n\t   \txmlHttp.send(xmlDoc);\n\t\talert(getMessage(\'RPT_SUBMIT_TO_PRINTER\',\'OR\'));\n\t}\n\t//IN070032 ends\n\t</script>\n<style>\t\n\t\n.gridEventData\n{\n\tbackground-color: #FFFFFF;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tvertical-align:middle;\n\tborder-style:solid;\n\tborder-color:#EEEEEE;\n} \n</style>\n\n</HEAD>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollFrame()\'>\n\n\n<form name=\'eventDataForm\' id=\'eventDataForm\'>\n\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t\t<table  width=\'100%\' id=\'dataTitleTable\' class=\'grid\' border=\"1\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\' >\n\t\t\t<TR>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<TH nowrap id=\'rowId";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' width=\"150px\"  class=\"gridHeader\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TH> <!-- 53137 -->\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</TR>\t\t\t\n\t\t</table>\n\t</div>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t<table width=\'100%\' id=\'dataTable\'  class=\'grid\' border=\"1\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\' height=\'parent.offsetHeight\'>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<tr id=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td nowrap class =\'gridEventData\' style=\"width:150px;\">\n\t\t\t\t\t<table style=\'background-color:#FFFFFF\'>\n\t\t\t\t\t\t<tr>\n       \t \t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t<input type=\'hidden\' name=\'hidden";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="Values";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'hidden";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="^%";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'/>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<td nowrap class = \'gridEventData\' style=\"width:150px;\">&nbsp;</td>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n\t</table>\n<input type=\'hidden\' name=\'txtFlagComments\' id=\'txtFlagComments\' value=\"N\">\n<input type=\'hidden\' name=\'txtFlagQuickText\' id=\'txtFlagQuickText\' value=\"N\">\t\n<input type=\'hidden\' name=\'finalTotCols\' id=\'finalTotCols\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\'hidden\' name=\'graphValuesOnChk\' id=\'graphValuesOnChk\' value=\'\'>\n<input type=\'hidden\' name=\'noOfGroups\' id=\'noOfGroups\' value=\'\'>\n<input type=\'hidden\' name=\'enc_id\' id=\'enc_id\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\'id=\'grphistory_type\' name=\'grphistory_type\' id=\'grphistory_type\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\'id=\'performing_facility_id\' name=\'performing_facility_id\' id=\'performing_facility_id\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' id=\'facilityid\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'><!--IN070032-->\n<input type=\'hidden\' id=\'login_user\' name=\'login_user\' id=\'login_user\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'REQ_DATE\' name=\'REQ_DATE\' id=\'REQ_DATE\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'patient_id\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'session_id\' name=\'session_id\' id=\'session_id\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'machine_name\' name=\'machine_name\' id=\'machine_name\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'reqdate\' name=\'reqdate\' id=\'reqdate\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'locale\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'report_Server\' name=\'report_Server\' id=\'report_Server\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'report\' name=\'report\' id=\'report\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'server\' name=\'server\' id=\'server\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'copies\' name=\'copies\' id=\'copies\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'queue_name\' name=\'queue_name\' id=\'queue_name\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'message\' name=\'message\' id=\'message\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'app_server_ip\' name=\'app_server_ip\' id=\'app_server_ip\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'rep_server_key\' name=\'rep_server_key\' id=\'rep_server_key\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'><!-- IN070032 -->\t\n<input type=\'hidden\' id=\'self_submit\' name=\'self_submit\' id=\'self_submit\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'report_option\' name=\'report_option\' id=\'report_option\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'destype\' name=\'destype\' id=\'destype\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'desformat\' name=\'desformat\' id=\'desformat\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'><!-- IN070032 -->\n<input type=\'hidden\' id=\'userid\' name=\'userid\' id=\'userid\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'><!-- IN070032 -->\n<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" name=\"queryString\" /><!-- IN070032 -->\n<input type=\'hidden\' name=\'allDatesForGraph\' id=\'allDatesForGraph\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<script>\nsetTimeout(\"alignHeight()\",300);\n</script>\n</form>\n</body>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\'  style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'yellow\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' class=\'gridTooltipData\' id=\'t\' nowrap></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n</html>\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );
	
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
		/*if(resultStr.indexOf("'")!=-1) //ML-BRU-SCF-1642 - IN057138 - Start
			resultStr = resultStr.replaceAll("'","`"); 
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","|"); */
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
			resultStr = resultStr.replaceAll("\\+","&#43");	//ML-BRU-SCF-1642 - IN057138 - End
		return resultStr;
	}
String replaceSpecialCharStr(String resultStr)
	{		
		
		if(resultStr.indexOf("~")!=-1) 
			resultStr = resultStr.replaceAll("~","#126");
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~ ");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("\\")!=-1) 
			resultStr = resultStr.replaceAll("\\\\","&#92");
		if(resultStr.indexOf("|")!=-1) 
			resultStr = resultStr.replaceAll("\\|","&#124");
		if(resultStr.indexOf("`")!=-1) 
			resultStr = resultStr.replaceAll("`","#96");			
		if(resultStr.indexOf("'")!=-1) 
			resultStr = resultStr.replaceAll("'","#39");
	
		if(resultStr.indexOf("\"")!=-1) 
			resultStr = resultStr.replaceAll("\"","#34");		
		if(resultStr.indexOf("+")!=-1) 
			resultStr = resultStr.replaceAll("\\+","&#43");	//ML-BRU-SCF-1642 - IN057138 - End
		return resultStr;
	}

//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String resulted_facilty, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class )
//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String resulted_facilty, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class,String accession_num,String facilty )//IN070032

//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String resulted_facilty, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class,String accession_num )//IN071263
HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String resulted_facilty, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class,String accession_num,String performing_facilty )//32036
	{
		int i = prevK;
		int j = 1;

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
		String tempStrValue1="";
		ArrayList externalList = null;

		String labResultModifiedNotifier = ""; 
		classValue = "CACHARTQRYEVEN";

		if(keyList.contains(enctr_id+"`"+histRecType+"`"+sysID+"`"+accessionNum+"`"+sysEventCode))
			displayStyle = "gridDataChart";
		else
			displayStyle = "gridDataChart";

		if(histDataType.equals("NUM"))
		{
			tempValue =tempValue+"<input type='hidden' name='resultNum' id='resultNum' value='"+resultNum+"'>"; 
			if(!tempAdditional.equals(""))
			{
				tempAdditional=tempAdditional.trim();
				tempAdditional=replaceSpecialChar(tempAdditional);
				if(tempAdditional.length() > 4){
					if(tempAdditional.length() > 10)
						tempStrValue1 = tempAdditional.substring(0,10);
					else 
						tempStrValue1 = tempAdditional.substring(0,5);
				
					tempValue =tempValue+ "&nbsp;" + "<a  href='javascript:ShowComments(\""+tempAdditional+"\")'><font size='1' color='black'><i>"+tempStrValue1+"..</i></a>";
				}
				else
					tempValue =tempValue+"&nbsp;<i>" +tempAdditional+"</i>";
			}
			if(!textCount.equals("0"))
			{
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' src='../../eCA/images/flow_text.gif' style='display' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+resulted_facilty+"')\">";
			}
			tempValue =tempValue+"&nbsp;"+"<img  src='../../eCA/images/ViewReport.png' onClick=\"run('"+accession_num+"','"+eventCode+"','"+resulted_facilty+"','"+performing_facilty+"')\" alt='Print Result'>";//IN070032//IN071263 //32036
		}
		else if(histDataType.equals("TXT") || histDataType.equals("HTM"))
		{
			if(!tempAdditional.equals("")) 
			{	
				tempAdditional=replaceSpecialChar(tempAdditional);
				
			}

			if(!textCount.equals("0"))
			{
				tempValue = tempValue+ "&nbsp;" +"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+resulted_facilty+"')\">";
				tempValue =tempValue+"&nbsp;"+"<img  src='../../eCA/images/ViewReport.png' onClick=\"run('"+accession_num+"','"+eventCode+"','"+resulted_facilty+"','"+performing_facilty+"')\" alt='Print Result'>";//IN070032//IN071263,32036
			}
		}
		else if(histDataType.equals("STR"))
		{
			tempValue=tempValue.trim();
			if(tempValue.length() > 4)
			{
				if(tempValue.length() > 10)
					tempStrValue = tempValue.substring(0,10);
				else 
					tempStrValue = tempValue.substring(0,5);
			
				tempValue = replaceSpecialChar(tempValue);
				tempValue=java.net.URLEncoder.encode(tempValue);
				tempValue = "<a  href=\"javaScript:ShowComments('"+tempValue+"')\"><font size='1' color='black'>"+tempStrValue+"..</a>";
				tempValue=tempValue+"&nbsp;"+"<img  src='../../eCA/images/ViewReport.png' onClick=\"run('"+accession_num+"','"+eventCode+"','"+resulted_facilty+"','"+performing_facilty+"')\" alt='Print Result'>";//IN072541 //32036
			}
			if(!normalcy_str.equals(""))
			{
				tempValue = tempValue + " <font color=blue>( Normal Value : " + normalcy_str + " )</font>";
			}
			if(!textCount.equals("0"))
			{
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+resulted_facilty+"')\">";
				tempValue =tempValue+"&nbsp;"+"<img  src='../../eCA/images/ViewReport.png' onClick=\"run('"+accession_num+"','"+eventCode+"','"+resulted_facilty+"','"+performing_facilty+"')\" alt='Print Result'>";//IN070032//IN071263 //32036
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
					tempString = tempString + "<TD class='"+displayStyle+"' background-color: #CDE5FF; style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID'  onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
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
	if(histDataType.equals("NUM")){//7632
		if(!tempToolTip.equals("") || !toolTip_ind.equals(""))
		{
			toolTip_ind=replaceSpecialCharStr(toolTip_ind);
			tempOnMouseOver="onMouseOver=\"displayToolTip('"+tempToolTip+"','"+toolTip_ind+"',this)\" onMouseOut =hideToolTip('"+i+"','"+j+"')";
			 tempString = tempString + tempOnMouseOver;
		}
	}//7632
		
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
					tempValue =tempValue+"&nbsp;"+"<img  src='../../eCA/images/ViewReport.png' onClick=\"run('"+accession_num+"','"+eventCode+"','"+resulted_facilty+"','"+performing_facilty+"')\" alt='Print Result'>";//IN070032//IN071263 //32036
				}
				else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
				{
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\">";
					tempValue =tempValue+"&nbsp;"+"<img  src='../../eCA/images/ViewReport.png' onClick=\"run('"+accession_num+"','"+eventCode+"','"+resulted_facilty+"','"+performing_facilty+"')\" alt='Print Result'>";//IN070032//IN071263 //32036
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
					
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCommon/images/ExternalDocument.PNG'  title='External Link' onClick=\"return getExtLink('"+strPatientId+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+resulted_facilty+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+patient_class+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"; 
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

		tempString = tempString + ">"+tempValue+"&nbsp;<br>"+strMoreDlt+"</TD>";

		try
		{
			returnMap.put("tempString",tempString);
			returnMap.put("histRecType"+i,histRecType);
			returnMap.put("eventClass"+i,eventClass);
			returnMap.put("eventGroup"+i,eventGroup);
			returnMap.put("eventCode"+i,eventCode);
			returnMap.put("eventDateTime"+i+"Map"+j,eventDateTime);
			returnMap.put("resultNum"+i+"Map"+j,resultNum);
		}
		catch(Exception ee)
		{
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
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
28/08/2019	IN071263	sivabagyam M 	07/04/2019		Ramesh G		CA-MO-CRF-20101.6/03-Select-drop down
28/02/2020	IN072541	SIVABAGYAM M		28/02/2020		RAMESH G		MO-GN-5554
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
22/07/2022	32036		Ramesh G		22/07/2022		Ramesh G		PMG2022-Common-CRF-0001
30/11/2023	53137		Twinkle shah	30/11/2022		Ramesh G		CA-Common-NEW Clinical Event History
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	ArrayList eventDates = new ArrayList() ;
	String bean_id					= "NewClinicalEventHistBean" ;
	String bean_name				= "eCA.NewClinicalEventHistBean";
	String patient_id				= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String clinician_id				= (String) session.getValue("ca_practitioner_id");
	String resp_id					= (String)session.getValue("responsibility_id");
	//IN070032 starts
	String userid		= (String) session.getValue( "report_connect_string" ) ;
	String self_submit	= "YES";
	String facility	= (String) session.getValue( "facility_id" ) ;
	String reportServer	= (String) session.getValue( "report_server" ) ;
	String ws_no		= (String) p.getProperty( "client_ip_address" )  ;
	String desformat="pdf";
	String destype="cache",report_option="V";
	//IN070032 ends
	String orderCatalogNature				=  request.getParameter("orderCatalogNature")==null?"":request.getParameter("orderCatalogNature");
	String selTab				=  request.getParameter("selTab")==null?"":request.getParameter("selTab");
	LinkedHashMap groupResultMap = null;
	HashMap<String,Integer> printIconDetailsMap=new HashMap<String,Integer>();//IN070032
	String called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
	String facility_id  = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	//IN069654 starts
	String strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String abnormal				=  request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
	String eventCls				=  request.getParameter("eventCls")==null?"":request.getParameter("eventCls");
	String eventGrp				=  request.getParameter("eventGrp")==null?"":request.getParameter("eventGrp");
	String eventItem				=  request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String date_Ordr			=  request.getParameter("date_Ordr")==null?"":request.getParameter("date_Ordr");
	String patient_class = request.getParameter("ql_patClass")==null?"":request.getParameter("ql_patClass");
	//IN069654 ends
	if(date_Ordr.equals(""))
		date_Ordr="D";
	String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String strNormalcyInd = request.getParameter("normalcy")==null?"I":request.getParameter("normalcy");
	//IN069654 starts
	String ql_ref= request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
	if(!ql_ref.equals(""))
		strNormalcyInd	= request.getParameter("ql_nlcyInd")==null?"I":request.getParameter("ql_nlcyInd");
	//IN069654 ends
	String fromDate="",toDate="";
	fromDate = request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	toDate = request.getParameter("to_date")==null	?"":request.getParameter("to_date");

	
	String grphistory_type			= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");
	String login_user = (String)session.getValue("login_user"); //IN070032
	String facilityid = (String)session.getValue("facility_id");//IN070032
	StringBuffer allDatesForGraph = new StringBuffer();

	int row=0;
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounterId,"eCA.PatientBannerGroupLine",session);

	NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
	ArrayList pdfEvents=new ArrayList();  //IN070032
	ArrayList viewing=new ArrayList();  //IN070032

	try{
		con = ConnectionManager.getConnection(request);	

		ArrayList keyList = manageEmailBean.returnList2();
		String dmsExternalLinkYN = manageEmailBean.getExternalDmsLinkYN(facility_id);

		eventDates = bean.getEventDates(con,locale,grphistory_type,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate,orderCatalogNature,selTab,facility_id,abnormal,eventCls,eventGrp,eventItem,reln_id,date_Ordr,patient_class,facility);//IN069654
		HashMap hMapEvent		= null; //53137
		String event_Date="";//53137
		
		pdfEvents=	bean.getPdfPrintingEvents(patient_id);//IN070032	
				viewing=bean.viewCall(facility,ws_no,reportServer,userid,report_option);//IN070032

            _bw.write(_wl_block10Bytes, _wl_block10);
for(int i=0;i<eventDates.size();i++){
				hMapEvent 	= (java.util.HashMap)eventDates.get(i); //53137
				event_Date	=	(String)hMapEvent.get("Event_Date"); //53137
				//allDatesForGraph.append(com.ehis.util.DateUtils.convertDate((String)eventDates.get(i),"DMYHM","en",locale)+"$$"); //53137
				allDatesForGraph.append(com.ehis.util.DateUtils.convertDate(event_Date,"DMYHM","en",locale)+"$$");//53137
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(event_Date));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

	
		groupResultMap=bean.getEventDetails(pageContext,con,locale,login_user,grphistory_type,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate, orderCatalogNature,selTab,facility_id,abnormal,eventCls,eventGrp,eventItem,reln_id,patient_class,facility);
		printIconDetailsMap = bean.getPrintIconDetails(pageContext,con,locale,login_user,grphistory_type,patient_id,encounterId,clinician_id,resp_id,fromDate,toDate, orderCatalogNature,selTab,facility_id,abnormal,eventCls,eventGrp,eventItem,reln_id,patient_class,facility);//IN070032
	
            _bw.write(_wl_block16Bytes, _wl_block16);
 
		String tempGroup = "";
		String tempEvent = "";
		String tempClass = "";
		int prevK = 0;
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
	String REQ_DATE="";//IN070032
	String session_id="";//IN070032
	String accession_num="";//IN070032
	String performing_facility_id="",machine_name="",reqdate="",report="",server="",copies="",queue_name="";//IN070032
	String message="",app_server_ip="",rep_server_key="",report_Server="";
		StringBuffer tdClassDesign = new StringBuffer();
		
		//IN070032 starts
		if(pdfEvents.size() >= 3){
			session_id=(String)pdfEvents.get(0);
			REQ_DATE=(String)pdfEvents.get(1);
			machine_name=(String)pdfEvents.get(2);
			
		}
		else if(pdfEvents.size() > 3){
			performing_facility_id=(String)pdfEvents.get(3);
		}
		if(viewing.size() >= 8){
			report=(String)viewing.get(0);
			server=(String)viewing.get(1);
			copies=(String)viewing.get(2);
			queue_name=(String)viewing.get(3);
			message=(String)viewing.get(4);
			app_server_ip=(String)viewing.get(5);
			rep_server_key=(String)viewing.get(6);
			report_Server=(String)viewing.get(7);
		}
		//IN070032 ends
		
		for(int i=0;i<eventDates.size();i++){
			tdClassDesign.append("<td nowrap class = 'CAFLOWSHEETLEVEL1' style='width:150px;'>&nbsp;</td>");
		}
		for (Object key : groupResultMap.keySet()) 
		{
			//String eventGrpVal=(String)key;
			LinkedHashMap eventGrpValues= (LinkedHashMap)groupResultMap.get(key);

			for (Object key1 : eventGrpValues.keySet()) 
			{
		 		//String eventCodeVal=(String)key1;
				HashMap dateValuesMap = (HashMap)eventGrpValues.get(key1);
				String anyDate =(String)dateValuesMap.keySet().iterator().next();
				ArrayList<String> eventDet =(ArrayList)dateValuesMap.get(anyDate);
				String eventCode=(String)eventDet.get(20);
				String eventGroup=(String)eventDet.get(31);
				String eventClass=(String)eventDet.get(32);
				 accession_num=(String)eventDet.get(34);//IN070032

				StringBuffer tdGrpDesign = new StringBuffer(); 
				//IN070032starts
				if(tempClass.equals("") && tempGroup.equals("") && tempEvent.equals("")){
					for(int i=0;i<eventDates.size();i++){
						if(printIconDetailsMap.get(eventDates.get(i)+"|"+eventGroup)==null) 
						//tdGrpDesign.append("<td nowrap class = 'CAFLOWSHEETLEVEL3' style='width:150px;'>&nbsp;</td>"); //53137
						tdGrpDesign.append("<td nowrap class = 'CAFLOWSHEETLEVEL3' style='width:150px;'>&nbsp;<img  src='../../eCA/images/Print.png' onClick=\"onLinePrinting_date('"+eventGroup+"','"+event_Date+"')\" alt='Print Result' /></td>"); //53137				
						else if(printIconDetailsMap.get(eventDates.get(i)+"|"+eventGroup)==1)
						  //tdGrpDesign.append("<td nowrap class = 'CAFLOWSHEETLEVEL3' style='width:150px;'><img  src='../../eCA/images/Print.png' onClick=\"onLinePrinting_date('"+eventGroup+"','"+eventDates.get(i)+"')\" alt='Print Result' /></td>");//53137
						  tdGrpDesign.append("<td nowrap class = 'CAFLOWSHEETLEVEL3' style='width:150px;'><img  src='../../eCA/images/Print.png' onClick=\"onLinePrinting_date('"+eventGroup+"','"+event_Date+"')\" alt='Print Result' /></td>");//53137
					}
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(row++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tdClassDesign.toString()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(row++));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tdGrpDesign.toString()));
            _bw.write(_wl_block20Bytes, _wl_block20);
			}else{
					if(!tempClass.equals(eventClass)){
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row++));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tdClassDesign.toString()));
            _bw.write(_wl_block23Bytes, _wl_block23);
			}
					if(!tempGroup.equals(eventGroup)){
						for(int i=0;i<eventDates.size();i++){
							if(printIconDetailsMap.get(eventDates.get(i)+"|"+eventGroup)==null)
							//tdGrpDesign.append("<td nowrap class = 'CAFLOWSHEETLEVEL3' style='width:150px;'>&nbsp;</td>"); //53137
							tdGrpDesign.append("<td nowrap class = 'CAFLOWSHEETLEVEL3' style='width:150px;'>&nbsp;<img  src='../../eCA/images/Print.png' onClick=\"onLinePrinting_date('"+eventGroup+"','"+event_Date+"')\" alt='Print Result' /></td>");	/* 53137 */						
							else if(printIconDetailsMap.get(eventDates.get(i)+"|"+eventGroup)==1)
								//tdGrpDesign.append("<td nowrap class = 'CAFLOWSHEETLEVEL3' style='width:150px;'><img  src='../../eCA/images/Print.png' onClick=\"onLinePrinting_date('"+eventGroup+"','"+eventDates.get(i)+"')\" alt='Print Result' /></td>"); /* 53137 */
								tdGrpDesign.append("<td nowrap class = 'CAFLOWSHEETLEVEL3' style='width:150px;'><img  src='../../eCA/images/Print.png' onClick=\"onLinePrinting_date('"+eventGroup+"','"+event_Date+"')\" alt='Print Result' /></td>");	/* 53137 */
						}//IN070032 ends
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row++));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tdGrpDesign.toString()));
            _bw.write(_wl_block23Bytes, _wl_block23);
			}
				}

	
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(row++));
            _bw.write(_wl_block26Bytes, _wl_block26);
 		
			for(int i=0;i<eventDates.size();i++){				
			      hMapEvent 	= (java.util.HashMap)eventDates.get(i);  // 53137			      
				  String event_Date1	=	(String)hMapEvent.get("Event_Date");  // 53137
				  //if(dateValuesMap.containsKey(eventDates.get(i))){  //53137
				  if(dateValuesMap.containsKey(event_Date1)){  // 53137
				  //ArrayList<String> eventDetails =(ArrayList)dateValuesMap.get(eventDates.get(i)); //53137
				  ArrayList<String> eventDetails =(ArrayList)dateValuesMap.get(event_Date1);   //53137
				  
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
						String eventDesc=(String)eventDetails.get(21);
						String legend_type=(String)eventDetails.get(22);
						String normalcy_str=(String)eventDetails.get(23);

						String ext_image_upld_id=(String)eventDetails.get(25);
						String event_code_type=(String)eventDetails.get(26);
						String recCountInt =(String)eventDetails.get(27);
						String ext_img_file_locn =(String)eventDetails.get(28);
						String normal_Yn	= (String)eventDetails.get(30);
						 accession_num	= (String)eventDetails.get(34);//IN070032
						String resulted_facilty =(String)eventDetails.get(24);//IN070032
						String performing_facilty =(String)eventDetails.get(36); //32036
						
						
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
						
						  
						if(toolTip.indexOf("Performed By")!=-1){//IN070032
							toolTip=toolTip.replaceAll("Performed By","Verified By");//7632 removed performed by
						}//IN070032  
						//HashMap tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounterId,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class);
						//HashMap tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounterId,normalcy_str,resulted_facilty, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,accession_num,string facilty);//IN070032
						//32036 Start.
						//HashMap tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounterId,normalcy_str,resulted_facilty, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,accession_num);//IN070032 //IN071263
						HashMap tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounterId,normalcy_str,resulted_facilty, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,accession_num,performing_facilty);
						//32036 End.
						prevK++;

						String tempReturnString = (String) tempTRMap.get("tempString");



	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tempReturnString));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(row));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(eventDates.get(i)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(resultNum));
            _bw.write(_wl_block33Bytes, _wl_block33);
			

				}
				else{
	
            _bw.write(_wl_block34Bytes, _wl_block34);
			
				}

			}
	
            _bw.write(_wl_block35Bytes, _wl_block35);

			tempGroup=eventGroup;
			tempEvent=eventCode;
			tempClass=eventClass;
		}
	}
	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(eventDates.size()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strEncId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(grphistory_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(REQ_DATE));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(machine_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(reqdate));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(report_Server));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(report));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(server));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(copies));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(queue_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(message));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(app_server_ip));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rep_server_key));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(self_submit));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(report_option));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(destype));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(desformat));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(allDatesForGraph.toString()));
            _bw.write(_wl_block63Bytes, _wl_block63);

}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block64Bytes, _wl_block64);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
