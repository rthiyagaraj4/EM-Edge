package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eOR.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __resultvieworderbtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ResultViewOrderBtn.jsp", 1738148794000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n-------------------------------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History    Name        \tDescription\n-------------------------------------------------------------------------------------------------------------------------------------\n?             \t100            \t?           \tcreated\n03/07/2013    IN039857\t\t Chowminya G    Print Button from result view page for LB order\n17/07/2013    IN041798\t Chowminya G    Print Button from result view page for LB order - Changes the function name\n---------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History    Name        \t\tRev.Date\t\tRev.Name \t\tDescription\n---------------------------------------------------------------------------------------------------------------\n11/11/2015\t\tIN057113\t\tKarthi L\t\t\t\t\t\t\t \t\t\t\tML-MMOH-CRF-0335 - IN057113\n18/07/2018\t\tIN061961\t\tsivabagyam M        18/07/2018\t\tRamesh G\t\tGHL-CRF-0433\n15/01/2021\t\t7632\t\t\tSivabagyam M\t\t15/01/2021\t\tRamesh G\t\tML-MMOH-CRF-1261.1\n24/02/2022\t \t25671\t\t\tRamesh G\t\t\t\t\t\t\t\t\t\t\tNMC-JD-CRF-0091.2 \n-------------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n<!-- ViewOrderBtn.jsp -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ResultOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/ViewOrder.js\"></script>\n \t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<form name=\'view_order_btn\' id=\'view_order_btn\' target=\'messageFrame\' >\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=center>\n\t<tr>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<td>\n\t\t<table cellpadding=3 cellspacing=0 width=\'100%\' border=\'0\' >\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td width=\'15%\' nowrap title=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t\t<font style=\'background:url(\"../../eCA/images/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\");size:1;width:16px;height:16px\' >&nbsp;&nbsp;</font><font size=1>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font>\n\t\t\t</td>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t<font style=\'background-color:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";size:1;width:16px;height:16px\'>&nbsp;&nbsp;</font><font size=1>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<td  width=\'15%\' nowrap>\n\t\t\t\t<font style=\'background:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px\' >&nbsp;&nbsp;</font><font size=1>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<td  width=\'15%\' nowrap>\n\t\t\t\t<font style=\'background-color:#32CD32;size:1;width:16px;height:16px\' >&nbsp;&nbsp;</font><font size=1>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<td  class=\'button\' align=\"right\">\n\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' class=\'button\' onClick=\'showHistory()\'>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<INPUT TYPE=\"button\" value=\'Print\' class=\'button\' onClick=\"run(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\"> <!-- IN041798 -->\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<INPUT TYPE=\"button\" value=\'Print\' class=\'button\' onClick=\"printLBValues();\"> <!-- IN041798 -->\t\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' class=\'button\' onClick=\'printing()\'>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' class=\'button\' onClick=\'toCloseTopShowModal()\'>\n\t\t</td>\n\t</tr>\n\n</table>\n\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\"hidden\" name=\"l_conf_pin_req_yn\" id=\"l_conf_pin_req_yn\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"> <!-- ML-MMOH-CRF-0335 - IN057113 -->\n<input type=\"hidden\" id=\"order_catalog_code\" name=\"order_catalog_code\" id=\"order_catalog_code\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"> <!--IN061961-->\n<input type=\"hidden\" id=\"order_line_num\" name=\"order_line_num\" id=\"order_line_num\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"> <!--IN061961-->\n<input type=\"hidden\" id=\"view_by\" name=\"view_by\" id=\"view_by\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"> <!--IN061961-->\n<input type=\"hidden\" id=\"ord_cat_code\" name=\"ord_cat\" id=\"ord_cat\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"> <!--IN061961-->\n<input type=\'hidden\' id=\'performing_facility_id\' name=\'performing_facility_id\' id=\'performing_facility_id\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' id=\'facilityid\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><!--7632-->\n<input type=\'hidden\' id=\'login_user\' name=\'login_user\' id=\'login_user\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'patient_id\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'session_id\' name=\'session_id\' id=\'session_id\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'machine_name\' name=\'machine_name\' id=\'machine_name\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'reqdate\' name=\'reqdate\' id=\'reqdate\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'report_Server\' name=\'report_Server\' id=\'report_Server\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'report\' name=\'report\' id=\'report\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'server\' name=\'server\' id=\'server\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'copies\' name=\'copies\' id=\'copies\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'queue_name\' name=\'queue_name\' id=\'queue_name\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'message\' name=\'message\' id=\'message\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'app_server_ip\' name=\'app_server_ip\' id=\'app_server_ip\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'rep_server_key\' name=\'rep_server_key\' id=\'rep_server_key\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'><!-- 7632 -->\t\n<input type=\'hidden\' id=\'self_submit\' name=\'self_submit\' id=\'self_submit\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'report_option\' name=\'report_option\' id=\'report_option\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'destype\' name=\'destype\' id=\'destype\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'desformat\' name=\'desformat\' id=\'desformat\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'userid\' name=\'userid\' id=\'userid\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'accession_num\' name=\'accession_num\' id=\'accession_num\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'><!-- 7632 -->\n<input type=\'hidden\' id=\'facilty\' name=\'facilty\' id=\'facilty\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'><!-- 7632 -->\n<input type=\"hidden\" name=\"eSignatureYN\" id=\"eSignatureYN\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" > <!-- 25671 -->\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	String legend_type = "";
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;
	//7632 STARTS
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");
	String locale = (String) p.getProperty("LOCALE");
	String clinician_id				= (String) session.getValue("ca_practitioner_id");
	String login_user = (String)session.getValue("login_user"); 
	String resp_id					= (String)session.getValue("responsibility_id");
	String userid		= (String) session.getValue( "report_connect_string" ) ;
	String self_submit	= "YES";
	String facility	= (String) session.getValue( "facility_id" ) ;
	String reportServer	= (String) session.getValue( "report_server" ) ;
	String ws_no		= (String) p.getProperty( "client_ip_address" )  ;
	String desformat="pdf";
	String destype="cache",report_option="V";
	String patient_id = request.getParameter("patient_id");
	String order_id = request.getParameter("orderId");
	String event_code = request.getParameter("event_code");
	//7632ENDS
	bean.setLanguageId(localeName);
	ArrayList DetailsColors=new ArrayList();
	ArrayList listDesc=new ArrayList();
	//IN039857 - Start
	String ord_cat = request.getParameter("ord_cat");
	String order_catalog_code = request.getParameter("order_catalog_code");//IN061961
	
	String order_line_num = request.getParameter("order_line_num");//IN061961
	String view_by = request.getParameter("view_by");//IN061961
	String LBInstallYN	= "N";
	//25671 Start.
	boolean isSiteSpecificESignature = bean.isSiteSpecific("ESIGNATURE_REQUIRED");
	String eSignatureYN ="N";
	if(isSiteSpecificESignature)
		eSignatureYN ="Y";
	//25671 End.
	if("LB".equals(ord_cat))
	{
		LBInstallYN = bean.getLBInstallYN();
	}
	//IN039857 - End
	String conf_pin_req_yn = ""; //ML-MMOH-CRF-0335 - IN057113
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
	HashMap mapDescColor=new HashMap();
	DetailsColors=bean.getDetailsColors();
	//7632 STARTS
	boolean ispdfprint=false;//7632
	ispdfprint =  bean.isSiteSpecific("RESULTSPRINTINGINPDF");//7632 
	ArrayList pdfEvents=new ArrayList();  
	ArrayList viewing=new ArrayList();  
	pdfEvents=	bean.getPdfPrintingEvents(patient_id);	
	viewing=bean.viewCall(facility,ws_no,reportServer,userid,report_option,order_id);
	String REQ_DATE="";
	String session_id="";
	String accession_num="";
	String performing_facility_id="",machine_name="",reqdate="",report="",server="",copies="",queue_name="";
	String message="",app_server_ip="",rep_server_key="",report_Server="",facilty="";
	
		if(pdfEvents.size() >= 3){
			session_id=(String)pdfEvents.get(0);
			reqdate=(String)pdfEvents.get(1);
			machine_name=(String)pdfEvents.get(2);
			performing_facility_id=(String)pdfEvents.get(3);
			facilty=(String)pdfEvents.get(4);
		}
		
		if(viewing.size() >= 9){
			report=(String)viewing.get(0);
			server=(String)viewing.get(1);
			copies=(String)viewing.get(2);
			queue_name=(String)viewing.get(3);
			message=(String)viewing.get(4);
			app_server_ip=(String)viewing.get(5);
			rep_server_key=(String)viewing.get(6);
			report_Server=(String)viewing.get(7);
			accession_num=(String)viewing.get(8);
		}//7632 ENDS
	if(DetailsColors.size()==3)
	{
		listDesc=(ArrayList)DetailsColors.get(0);
		mapDescColor=(HashMap)DetailsColors.get(1);
		legend_type=(String)DetailsColors.get(2);
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		String listValues = "";
		String mapValues = "";
		String listValuesdisp = "";
		String tooltip = "";
		int tdWidth = 0;
		if(listDesc.size() != 0)
			tdWidth = 100/listDesc.size();
		else
			tdWidth = 100;

		for(int i=0;i<listDesc.size();i++)
		{
			listValues = (String) listDesc.get(i);
			mapValues = (String) mapDescColor.get(listValues);

			if(listValues.length()>15)
			{
				listValuesdisp = listValues.substring(0,15);
				tooltip = listValues;
			}
			else
			{
				listValuesdisp = listValues;
				tooltip = "";
			}
			//out.println("<td width='"+tdWidth+"%' style='background-color:"+mapValues+"'>"+listValues+"</td>");

			if(legend_type.equals("S"))
			{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mapValues));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(listValuesdisp));
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
			else
			{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mapValues));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(listValuesdisp));
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
		}
		if(legend_type.equals("S"))
		{
	
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		else
		{
	
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
	
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewAuditTrail.label","or_labels")));
            _bw.write(_wl_block22Bytes, _wl_block22);
		 
			//IN039857 Start//7632	 STARTS	
			if("Y".equals(LBInstallYN) && ispdfprint)
			{
			
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block24Bytes, _wl_block24);

			}else if("Y".equals(LBInstallYN) && !ispdfprint){
            _bw.write(_wl_block25Bytes, _wl_block25);
 }//7632 ENDS
			else
			{//IN039857 End
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);

			}		
		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( locale ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( conf_pin_req_yn ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( order_catalog_code ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( order_line_num ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(performing_facility_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(machine_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(reqdate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(report_Server));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(report));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(server));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(copies));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(queue_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(message));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(app_server_ip));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rep_server_key));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(self_submit));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(report_option));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(destype));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(desformat));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facilty));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(eSignatureYN));
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
}
