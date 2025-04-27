package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
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

public final class __blinsackpymtreload extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLInsAckPymtReload.jsp", 1713248478500L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\r\n<head>\r\n<meta HTTP-EQUIV=\"content-type\" CONTENT=\"text/html; charset=UTF-8\">\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\r\n<script language=\"javascript\" src=\"../../eCommon/js/jquery.js\"></script>\r\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\r\n<script language=\"JavaScript\">\r\n$(document).ready(function(){\r\n\tvar frm = document.forms(0);\r\n\tvar message = frm.message.value;\r\n\tvar err_value = frm.err_value.value;\r\n\r\n\tif(err_value == \"1\"){\r\n\t\talert(getMessage(\"RECORD_MODIFIED\",\"SM\"));\r\n\t\treloadQueryCriteria();\r\n\t} else {\r\n\t\tparent.frames[2].location.href = \'../../eCommon/jsp/error.jsp?err_num=\'+message+\'&err_value=\'+err_value;\r\n\t\tparent.frames[1].frames[2].document.getElementById(\'insAckPymt\').disabled = false;\r\n\t}\r\n\t\r\n\t\r\n});\r\n\r\nfunction reloadQueryCriteria()\r\n{\t\r\n\tvar frm = document.forms(0);\r\n\tvar p_facility_id = frm.facility_id.value;\r\n\tvar locale = frm.locale.value;\r\n\tvar err_value = frm.err_value.value;\r\n\tvar message = frm.message.value;\r\n\tmessage = \"Exception from Servlet : \"+message;\r\n\t\r\n\r\n\tparent.frames[1].frames[0].location.href = \"../../eBL/jsp/BLInsAckPymtSearchCriteria.jsp?reloadFun=Y&facility_id=\"+p_facility_id+\"&locale=\"+locale+\"&qryPayerGrpCode=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"+\"&qryPayerGrpDesc=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"+\"&qryPayerCode=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"+\"&qryPayerDesc=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"+\"&qryPymtRefID=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"+\"&qryPymtRefFromDate=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"+\"&qryPymtRefToDate=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"+\"&qryPymtRefStatus=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\r\n\t\r\n\tparent.frames[1].frames[1].location.href = \"../../eCommon/html/blank.html\";\r\n\tparent.frames[1].frames[2].location.href = \"../../eCommon/html/blank.html\";\t\t\r\n\t\r\n\tif(err_value == \"0\"){\r\n\t\tparent.frames[2].location.href = \'../../eCommon/jsp/error.jsp?err_num=\'+message+\'&err_value=\'+err_value;\r\n\t}\r\n}\t\r\n\r\n</script>\r\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'>\r\n<form id=\'messageFrm\'>\r\n\t<input type=\"hidden\" name=\"facility_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\t\r\n\t<input type=\'hidden\' name=\'locale\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\r\n\t<input type=\'hidden\' name=\'message\' id=\'message\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\r\n\t<input type=\'hidden\' name = \'err_value\' id=\'err_value\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\r\n\t</form>\r\n</BODY>\r\n\r\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
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

 private String checkForNull	(String input){
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	try
	{
		System.err.println("Inside BLInsAckPymtReload.jsp:"+request.getQueryString());
		String facilityId =  (String) session.getValue( "facility_id" ) ;
		String locale = (String)session.getAttribute("LOCALE");
		String message=request.getParameter( "message" );
		String params=request.getQueryString();
		System.err.println("params"+params);
		String qryPayerGrpCode = checkForNull(request.getParameter("qryPayerGrpCode"));
		String qryPayerGrpDesc = checkForNull(request.getParameter("qryPayerGrpDesc"));
		String qryPayerCode = checkForNull(request.getParameter("qryPayerCode"));
		String qryPayerDesc = checkForNull(request.getParameter("qryPayerDesc"));
		String qryPymtRefID = checkForNull(request.getParameter("qryPymtRefID"));
		String qryPymtRefFromDate = checkForNull(request.getParameter("qryPymtRefFromDate"));
		String qryPymtRefToDate =checkForNull(request.getParameter("qryPymtRefToDate"));
		String qryPymtRefStatus = checkForNull(request.getParameter("qryPymtRefStatus"));
		String err_value = request.getParameter("err_value");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(qryPayerGrpCode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(qryPayerGrpDesc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(qryPayerCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qryPayerDesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(qryPymtRefID));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(qryPymtRefFromDate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(qryPymtRefToDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(qryPymtRefStatus));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(message ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(err_value));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}catch(Exception e){
			System.err.println("Exception in BLInsAckPymtReload.jsp: "+e);
		}finally{
				
		}

        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
