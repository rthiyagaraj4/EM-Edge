package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __emkycdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/EMKYCDetails.jsp", 1733051291087L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\t\n\t<head>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\n\t\t<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eXH/js/json2.js\'></script>\n\t\t<script type=\"text/javascript\">\n\t\t\t$(document).ready(function() {\n\t\t\t \n\t\t\t\tvar responseMsg=\"\";\n\t\t\t\tvar data1=true;\n\n\t\t\t\tvar l_request_id = document.forms[0].requestId.value;\n\t\t\t\tvar l_hashData = document.forms[0].hashData.value;\n\t\t\t\tvar l_uuid = document.forms[0].uuid.value;\n\t\t\t\tvar l_status = document.forms[0].status.value;\n\t\t\t\tvar l_transaction_id = document.forms[0].transactionId.value;\n\n\t\t\t\t/*\n\t\t\t\tvar authenticationCode = document.forms[0].authenticationCode.value;\n\t\t\t\tvar errorCode = document.forms[0].errorCode.value;\n\t\t\t\tvar errorMessage = document.forms[0].errorMessage.value;\n\t\t\t\t*/\n\n\t\t\t\tvar dataElements = \"<REQUESTID>\"+l_request_id+\"$!^<UUID>\"+l_uuid+\"$!^<HASHDATA>\"+l_hashData+\"$!^<STATUS>\"+l_status+\"$!^<TRANSACTION_ID>\"+l_transaction_id+\"$!^\";\n\n\t\t\t\t$.ajax({\n\t\t\t\t\turl: \'../../servlet/eXH.AadhaarResponse\',\n\t\t\t\t\ttype: \'POST\',\n\t\t\t\t\tcache: false,\n\t\t\t\t\tdata: {\n\t\t\t\t\t\t\tcallType:\t\'KYC\',\n\t\t\t\t\t\t\trequest_id:\tl_request_id,\n\t\t\t\t\t\t\tuuid:\tl_uuid,\n\t\t\t\t\t\t\thash_data:\tl_hashData,\n\t\t\t\t\t\t\tstatus:\t\tl_status,\n\t\t\t\t\t\t\ttransaction_id:\tl_transaction_id,\n\t\t\t\t\t\t\tparamString: dataElements\n\t\t\t\t\t}, \n\t\t\t\t\tsuccess: function (data1) {\n\t\t\t\t\t\tresponseMsg = data1;\n\t\t\t\t\t},\n\t\t\t\t\tdataType: \'text\',\n\t\t\t\t\tasync: false\n\t\t\t\t});  \n\t\t\t\twindow.open(\'\', \'_self\', \'\'); window.close();\n\t\t\t});\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t</head>\n\t<body>\t\n\t\t<form name=\"ekycform\" id=\"ekycform\">\n\t\t\t<p>\n\t\t\t\t\tRequest Details : Hash ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t</p>\n\t\t\t<p>\n\t\t\t\t\tRequest Details : UUID ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n\t\t\t</p>\n\t\t\t<p>\n\t\t\t\t\tRequest Details : Status ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</p>\n\t\t\t<p>\n\t\t\t\t\tRequest Details : requestId ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</p>\n\t\t\t<p>\n\t\t\t\t\tRequest Details : transactionId ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</p>\n\t\t\t<input type=\'hidden\' name=\'hashData\' id=\'hashData\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t<input type=\'hidden\' name=\'uuid\' id=\'uuid\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t\t<input type=\'hidden\' name=\'status\' id=\'status\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n\t\t\t<input type=\'hidden\' name=\'requestId\' id=\'requestId\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t\t<input type=\'hidden\' name=\'transactionId\' id=\'transactionId\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\t\t\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
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

		//http://localhost:8899/eHIS/eXH/jsp/EMKYCDetails.jsp?requestId=731418475004&uuid=3722398c-72fb-4bf1-a662-8611a1cb21b1&hash=f063f1205ec53b6f376f93057f5bd27011332db55385de5b05aefda1e3ccd430&status=success

			String hashData = "";
			String uuid = "";
			String requestId = "";
			String status = "";
			String transactionId = "",l_return_str="",l_param_string="",responseMsg="";
			
			request.setCharacterEncoding("UTF-8");
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			hashData = XHDBAdapter.checkNull(request.getParameter("hash"));
			uuid = XHDBAdapter.checkNull(request.getParameter("uuid"));
			requestId = XHDBAdapter.checkNull(request.getParameter("requestId"));
			status = XHDBAdapter.checkNull(request.getParameter("status"));
			transactionId = XHDBAdapter.checkNull(request.getParameter("transactionId"));

			boolean isDebugYN = false; 
			String l_app_msg = "";
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			//responseMsg= XHDBAdapter.checkNull(request.getParameter("responseMsg"));

			l_app_msg = " ::: HASHDATA ::: "+hashData+" ::: UUID  ::: "+uuid+" ::: REQUEST ID  ::: "+requestId+" ::: STATUS  ::: "+status+" ::: TRANSACTIONID  ::: "+transactionId;
			if (isDebugYN) System.out.println(l_app_msg);
			    
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(hashData ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(uuid ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(status ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(requestId ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(transactionId ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(hashData));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(uuid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(status));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(requestId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(transactionId));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
