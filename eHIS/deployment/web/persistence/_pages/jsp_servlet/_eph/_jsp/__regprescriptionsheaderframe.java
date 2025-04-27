package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __regprescriptionsheaderframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/RegPrescriptionsHeaderFrame.jsp", 1724223659530L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t\n\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n\t<!-- <SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../eCommon/js/MstCodeCommon.js\"></SCRIPT> -->\n\t<SCRIPT LANGUAGE=\"Javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../js/PhCommon.js\"></SCRIPT>\n<!-- \t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/PhMessages.js\"></script> -->\t\n <script language=\"JavaScript\" src=\"../../ePH/js/RegPrescriptions.js\"></script>\n  <style>\n        body {\n        \tgrid-gap: 15px;\n            margin: 0;\n            height: 100vh;\n            display: grid;\n            grid-template-columns: 24% 74%;\n   \n        }\n\n        #left-sidebar {\n            grid-row: span 2;\n            background-color: #f0f0f0;\n        }\n\n        #content {\n            display: grid;\n            /* grid-template-rows: 7% 93%; */\n        }\n\n        #header {\n            display: grid;\n            /* grid-template-rows: 17% 83%; */\n        }\n        \n        #header-patient-id-locator\n        {\n        \t height: 6vh;\n        }\n        \n        #header-patient-id\n        {\n        \t height: 93vh;\n        }\n\n        #main {\n            display: grid;\n            /* grid-template-rows: 10% 38% 51%; */\n        }\n\n        #reg_prescriptions_header_patient_line {\n            height: 10vh;\n        }\n\n        #reg_prescriptions_header_details {\n            height: 38vh;\n        }\n\n        #footer {\n            display: grid;\n           /*  grid-template-rows: 87% 12%; */\n        }\n\n        #reg_prescriptions_footer_details {\n            height: 43vh;\n        }\n\n        #reg_prescriptions_status {\n            height: 5vh;\n        }\n\n        iframe {\n            width: 100%;\n            border: 0;\n        }\n    </style>\n</head>\n\n<body>\n    <div id=\"left-sidebar\">\n      <div id=\"header\">\n            <iframe id=\"header-patient-id-locator\" name=\"reg_prescriptions_header_patient_id_locator\" src=\"../../eCommon/html/blank.html\"></iframe>\n            <iframe id=\"header-patient-id\" name=\"reg_prescriptions_header_patient_id\" src=\"../../eCommon/html/blank.html\"></iframe>\n        </div>\n    </div>\n\n    <div id=\"content\">\n        \n\n        <div id=\"main\">\n            <iframe id=\"reg_prescriptions_header_patient_line\" name=\"reg_prescriptions_header_patient_line\" src=\"../../eCommon/html/blank.html\"></iframe>\n            <iframe id=\"reg_prescriptions_header_details\" name=\"reg_prescriptions_header_details\" src=\"../../eCommon/html/blank.html\"></iframe>\n\n            <div id=\"footer\">\n                <iframe id=\"reg_prescriptions_footer_details\" name=\"reg_prescriptions_footer_details\" src=\"../../ePH/jsp/RegPrescriptionsDetailFrame.jsp\"></iframe>\n                <iframe id=\"reg_prescriptions_status\" name=\"reg_prescriptions_status\" src=\"../../eCommon/html/blank.html\"></iframe>\n            </div>\n        </div>\n    </div>\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8 ");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
