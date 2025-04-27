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

public final class __blrcmtransactionsreload extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLRCMTransactionsReload.jsp", 1737916652558L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block8 ="\n\n<script language=\"JavaScript\">\n$(document).ready(function(){\n\tvar frm = document.forms[0];\n\tvar message = frm.message.value;\n\tvar err_value = frm.err_value.value;\n\t\n\tif(err_value == \"1\"){\n\t\talert(message);\n\t}\n\t\treloadQueryCriteria();\n\t\n});\n\nfunction reloadQueryCriteria()\n{\n\t\n\tvar frm = document.forms[0];\n\tvar p_facility_id = frm.facility_id.value;\n\tvar locale = frm.locale.value;\n\tvar func_id = \"EBL_RCM_TRX\";\n\tvar called_from_dashboard_YN = frm.called_from_dashboard_YN.value;\n\tvar err_value = frm.err_value.value;\n\tvar message = frm.message.value;\n\tmessage = \"Exception from Servlet : \"+message;\n\t\n\tif(called_from_dashboard_YN == \"N\"){\n\t\tparent.frames[0].location.reload();\n\t\tparent.frames[1].frames[0].location.href = \"../../eBL/jsp/BLEClaimQueryCriteria.jsp?function_id=\"+func_id;\n\t\tparent.frames[1].frames[0].document.getElementById(\"search_button\").click();\n\t}else{\n\t\t\n\t\tparent.frames[0].location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.frames[1].location.href = \"../../eBL/jsp/BLRCMTransGenerateBillResult.jsp?called_from_dashboard_YN=\"+called_from_dashboard_YN+\"&facility_id=\"+p_facility_id+\"&locale=\"+locale+\"&visitId=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&patientId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&episodeType=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&payer_grp_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&payer_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&policy_type_code=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&apprDocRefNum=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&claimId=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&State_dur_from=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&State_dur_to=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&insurance_Status=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&claims_services_level=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&function_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\tparent.frames[2].location.href = \"../../eCommon/html/blank.html\";\t\t\n\t}\n\t\n\tif(err_value == \"0\"){\n\t\tif(called_from_dashboard_YN == \"N\"){\n\t\t\tparent.frames[2].location.href = \'../../eCommon/jsp/error.jsp?err_num=\'+message+\'&err_value=\'+err_value;\n\t\t}else{\n\t\t\tparent.frames[4].location.href = \'../../eCommon/jsp/error.jsp?err_num=\'+message+\'&err_value=\'+err_value;\n\t\t}\n\t}\n\n}\t\n\n</script>\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'>\n<form id=\'messageFrm\'>\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<input type=\'hidden\' name=\'message\' id=\'message\' id=\'message\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<input type=\'hidden\' name=\'called_from_dashboard_YN\' id=\'called_from_dashboard_YN\' id=\'called_from_dashboard_YN\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t<input type=\'hidden\' name = \'err_value\' id=\'err_value\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t</form>\n</BODY>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
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
			String message=request.getParameter( "message" );
			String called_from_dashboard_YN=request.getParameter( "called_from_dashboard_YN" );
			String params=request.getQueryString();
			System.err.println("params"+params);
			String visitId = checkForNull(request.getParameter("visitId"));
			String patientId =checkForNull(request.getParameter("patientId"));
			String episodeType = checkForNull(request.getParameter("episodeType"));
			String payerGrpCode = checkForNull(request.getParameter("payer_grp_code"));
			String payerCode = checkForNull(request.getParameter("payer_code"));
			String policyTypeCode =checkForNull(request.getParameter("policy_type_code"));
			String apprDocRefNum = checkForNull(request.getParameter("apprDocRefNum"));
			String claimId = checkForNull(request.getParameter("claimId"));
			String StateDurFrom = checkForNull(request.getParameter("State_dur_from"));
			String StateDurTo =checkForNull(request.getParameter("State_dur_to"));
			String insuranceStatus = checkForNull(request.getParameter("insurance_Status"));
			String claims_services_level = checkForNull(request.getParameter("claims_services_level"));
			String function_id =  checkForNull(request.getParameter("function_id")) ;
			String err_value = request.getParameter("err_value");



            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(payerGrpCode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(payerCode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(policyTypeCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(apprDocRefNum));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(claimId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(StateDurFrom));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(StateDurTo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(insuranceStatus));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(claims_services_level));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(message ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(called_from_dashboard_YN ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(err_value));
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
