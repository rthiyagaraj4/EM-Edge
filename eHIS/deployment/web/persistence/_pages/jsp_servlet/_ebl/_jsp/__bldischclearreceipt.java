package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __bldischclearreceipt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLDischClearReceipt.jsp", 1737916066177L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n<meta HTTP-EQUIV=\"content-type\" CONTENT=\"text/html; charset=UTF-8\">\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script language=\"JavaScript\">\n$(document).ready(function(){\n\tvar frm = document.forms[0];\n\tvar err = frm.err_value.value;\n\tvar message = frm.message.value;\n\tif(err == \'1\'){\n\t\tgenerateDischClear();\n\t}else if(err == \'0\'){\n\t\talert(message);\n\t\treturn false;\n\t}\n});\n\nfunction generateDischClear()\n{\n\t\n\tvar frm = document.forms[0];\n\tvar docType = frm.docType.value;\n\tvar docNumber = frm.docNumber.value;\n\tvar p_facility_id = frm.facility_id.value;\n\tvar locale = frm.locale.value;\n\tvar login_user = \'\';\n\tvar episodeId = frm.episodeId.value;\n\tvar episodeType = frm.episodeType.value;\n\tvar detailed_yn = \"Y\";\n\tvar reportId = \"BLRDISCL\";\n\tvar module_id = \"BL\";\n\tvar session_id = \'\';\n\tvar pgm_date = \'\';\t\n\tvar app_server_ip =\'\'; \n\tvar copies = \'\';\n\tvar rep_server_key = \'\';\n\tvar url = \"\" ;\n\tvar reportserver = \'\';\n\tvar userid = \'\';\n\tvar report_option = \"P\";\n\tvar message = \"\";\n\t\n\tvar temp_jsp = \"../jsp/BLCommonAjax.jsp?functionMode=ReprintReport&p_report_id=\"+reportId+\"&param1=\"+docType+\"&param2=\"+docNumber+\n\t\t\t\t\"&param3=\"+docNumber+\"&param4=\"+docNumber+\"&param5=\"+\"&param6=\"+detailed_yn+\"&param7=\"+\"R\"+\"&param8=\"+locale+\n\t\t\t\t\"&param9=\"+\n\t\t\t\t\"&param10=\"+\t\t\t\t\n\t\t\t\t\"&param11=\"+\n\t\t\t\t\"&param12=\"+\n\t\t\t\t\"&param13=\"+episodeId+\n\t\t\t\t\"&param14=\"+episodeType;\n\t\t\n\tvar xmlHttp = new XMLHttpRequest();\n\txmlHttp.open(\"POST\", temp_jsp, false);\n\txmlHttp.send();\n\tvar retVal = trimString(xmlHttp.responseText);\n\t\n\tvar arr=new Array();\n\tarr = retVal.split(\":::\");\n\tsession_id = trimString(arr[0]);\n\tpgm_date = trimString(arr[1]);\n\t\n\tvar temp_jsp = \"../jsp/BLCommonAjax.jsp?functionMode=ReprintReportValue&p_report_id=\"+reportId+\"&reportOption=\"+report_option+\"&module_id=\"+module_id;\n\tvar xmlHttp = new XMLHttpRequest();\n\txmlHttp.open(\"POST\", temp_jsp, false);\n\txmlHttp.send();\n\tvar retVal = trimString(xmlHttp.responseText);\t\t\n\tvar arr=new Array();\n\tarr = retVal.split(\":::\");\n\treport = trimString(arr[0]);\n\tserver = trimString(arr[1]);\n\tcopies = trimString(arr[2]);\n\tapp_server_ip = trimString(arr[3]);\n    rep_server_key = trimString(arr[4]);\n    reportserver = trimString(arr[5]);\n    login_user = trimString(arr[6]);\n    message = trimString(arr[7]);\n   \n    if(message != \"\"){\n    \talert(message);\n    \treturn false;\n    }\n    userid = \"userid\"+\"=\"+login_user;\n    login_user = encodeURIComponent(userid); \n\t\n\tvar params\t\t= \"&P_PGM_ID=\"+reportId+\"&P_PGM_DATE=\"+pgm_date+\"&P_OPERATING_FACILITY_ID=\"+p_facility_id+\"&P_SESSION_ID=\"+session_id+\"&P_DOC_TYPE_CODE=\"+docType+\"&P_DOC_NUM=\"+docNumber;\n\tvar regExp = /&/g ;\n\tparams = params.replace( regExp, \"+\" ) ; \n\t\t\t\n\tvar myRegExp = /\\\\/g ;\n\tvar desformat = \"PDF\";\n\tvar destype\t= \"CACHE\";\n\t\n\tparams=params.toUpperCase();\n\tvar report = reportId;\n\turl = reportserver+\"?server=\"+server+\"+report=\"+reportId+\"+\"+ login_user+\"+p_language_id=\"+locale+\"+DESTYPE=\"+destype+\"+PARAMFORM=NO\"+\"+P_FACILITY_ID=\"+p_facility_id+\"+DESFORMAT=\"+desformat+\"+RECURSIVE_LOAD=NO\"+\"+MAXIMIZE=YES\"\t;\n\turl=url+params;\t\n\tvar myBars \t\t= \'directories=no,location=no,menubar=no\' ;\n\tvar myOptions \t= \'width=1500px !important, height=750px !important, resizable=yes\' ; \n\tvar myFeatures \t= myBars + \', \' + myOptions ;\n\tvar reportWindow \t= open( url, \'_blank\', myFeatures ) ;\n\t\n\talert(\"Discharge Clearance Document Number is \"+docType+\"/\"+docNumber+\"\\nAPP-SM0070 Operation Completed Successfully ....\");\n\tparent.frames[0].location.reload();\n\tparent.frames[1].location.reload();\n\n}\t\n\n</script>\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'>\n<form id=\'messageFrm\'>\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t<input type=\'hidden\' name=\'err_value\' id=\'err_value\' id=\'err_value\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t<input type=\'hidden\' name=\'message\' id=\'message\' id=\'message\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t<input type=\'hidden\' name=\'docType\' id=\'docType\' id=\'docType\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t<input type=\'hidden\' name=\'docNumber\' id=\'docNumber\' id=\'docNumber\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t<input type=\'hidden\' name=\'episodeId\' id=\'episodeId\' id=\'episodeId\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' id=\'episodeType\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n</form>\n</BODY>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String facilityId =  (String) session.getValue( "facility_id" ) ;
String locale = (String)session.getAttribute("LOCALE");
String docType = checkForNull(request.getParameter("docType"));
String docNumber = checkForNull(request.getParameter("docNumber")); 
String episodeId = checkForNull(request.getParameter("episodeId"));
String episodeType = checkForNull(request.getParameter("episodeType"));   
String err_value=request.getParameter( "err_value" );
String message = request.getParameter( "message" );

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(err_value ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(message ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(docType ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(docNumber ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(episodeType ));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
