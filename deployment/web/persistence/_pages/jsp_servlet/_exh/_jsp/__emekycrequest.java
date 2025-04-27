package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import eXH.InterfaceUtil;
import eXH.XHUtil;
import eXH.*;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __emekycrequest extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/EMeKYCRequest.jsp", 1733051284270L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<meta charset=\"UTF-8\">\n\t\t<title> Aadhaar Validation</title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t\t<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eMP/js/PasInterface.js\'></script>\n\t\t<script type=\"text/javascript\">\n\n\t\t\t$(document).ready(function() {\n\t\t\t\twindow.document.KDAHEKYC.submit();\n\t\t\t\tafterSubmit();\n\n\t\t\t});\n\n\t\t\tfunction afterSubmit()\n\t\t\t{\n\t\t\t\tvar response;\n\t\t\t\tvar aadharno;\n\t\t\t\tvar response_json;\n\t\t\t\tvar request_id;\n\t\t\t\tvar status;\n\n\t\t\t\tvar waittime = document.getElementById(\"WAITTIME\").value;\n\n\t\t\t\tvar timeoutseconds = waittime * 1000;\n\n\t\t\t\tsetTimeout(function()\n\t\t\t\t{\n\t\t\t\t\tresponse = WaitingResponse();\n\n\t\t\t\t\tvar responseMsg=response.split(\"$!^\");\n\t\t\t\t\tif(responseMsg[0]==\"W\")\n\t\t\t\t\t{\n\t\t\t\t\t\tafterSubmit();\n\t\t\t\t\t}\n\t\t\t\t\telse if(responseMsg[0]==\"S\")\n\t\t\t\t\t{\n\t\t\t\t\t\t//alert(responseMsg[1]);\n\t\t\t\t\t\twindow.returnValue=\"true\";\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\talert(responseMsg[1]);\n\t\t\t\t\t\twindow.returnValue = \"false\";\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\n\t\t\t\t},timeoutseconds);\n\n\t\t\t}\n\n\t\t\tfunction WaitingResponse()\n\t\t\t{\n\t\t\t\tvar responseMsg=\"\";\n\t\t\t\tvar data1 = true;\n\t\t\t\tvar request_id = document.getElementById(\"REQUEST_ID\").value;\n\t\t\t\t$.ajax({\n\t\t\t\t\turl: \'../../servlet/eXH.AadhaarRequest\',\n\t\t\t\t\ttype: \'POST\',\n\t\t\t\t\tcache: false,\n\t\t\t\t\tdata: {\n\t\t\t\t\t\t\tCallType: \'VALIDATE\',\n\t\t\t\t\t\t\trequest_id:\trequest_id\n\t\t\t\t\t\t  \n\t\t\t\t\t}, \n\t\t\t\t\tsuccess: function (data1) {\n\t\t\t\t\t\tresponseMsg = data1;\n\t\t\t\t\t},\n\t\t\t\t\tdataType: \'text\',\n\t\t\t\t\tasync: false\n\t\t\t\t});\n\n\t\t\t   return responseMsg;\n\t\t\t}\n\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\n\t\t\t\t<script>\n\t\t\t\t\talert(\"APP-002415 Error in Inserting Aadhaar Details.\");\n\t\t\t\t</script>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</head>\n\t<body>\n\t\t<div align=\"center\" >\n\t\t\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t\t\t<tr><td align=\'center\'> <img id=\'spinner\' src=\'../images/ajax-loader.gif\' style=\'visibility:visible\'></img></td></tr>\n\t\t\t<tr>\n\t\t\t\t<td  align=\'center\' class=\"label\"><b>Aadhaar validation is currently being processed... Please wait...</b></br>\n\t\t\t\t\t\t\t\t\t\tDo not close this window...</br>\n\t\t\t\t\t\t\t\t\t\tThis window will close automatically after completion of the validation.</td>\n\t\t\t\t\n\t\t\t</tr>\t\n\t\t\t</table>\n\t\t\t\n\t\t\t\t\t\n\t\t\t<div align=\"center\" style=\"width: 0px;height:0px\">\n\t\t\t\t<!--<form name=\"KDAHEKYC\" id=\"KDAHEKYC\" action=\"http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc\" method=\"post\">!-->\n\t\t\t\t\t<form name=\"KDAHEKYC\" id=\"KDAHEKYC\" action=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" method=\"post\">\n\n\t\t\t\t\t<fieldset>\n\t\t\t\t\t<input type=\"hidden\" value=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" name=\"AADHAAR_NO\"  id=\"AADHAAR_NO\"></p>\n\t\t\t\t\t<input type=\"hidden\" value=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" name=\"REQUEST_ID\" id=\"REQUEST_ID\"></p>\n\t\t\t\t\t<input type=\"hidden\" value=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" name=\"\" id=\"EM_FACILITY_ID\"></p>\n\t\t\t\t\t<input type=\"hidden\" value=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" name=\"EM_USER_ID\" id=\"EM_USER_ID\"></p>\n\t\t\t\t\t<input type=\"hidden\" value=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" name=\"WAITTIME\" id=\"WAITTIME\"></p>\n\t\t\t\t\t</fieldset>\n\t\t\t\t</form>\n\t\t\t</div>\n\t\t</div>\n\t</body>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</html>\n\n";
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
String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

			String sql="";
			String facilityId = "", addedId = "", l_aadhaar_no = "", l_request_id = "",err_cd="",err_msg="";
			String uuid = "";
			String[] data=null;
			Properties p;			

			String l_param_string = "", l_return_str = "";
			int l_wait_time=60;		
			
			request.setCharacterEncoding("UTF-8");
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" );

			boolean isDebugYN = false; 
			String l_app_msg = "";
			
			String l_element_id = "REQUEST_URL";
			String l_segment_id = "AAG";
			String l_standard_code = "AADHAARSTD";
			String l_field_value = "http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc";	

			Connection dbConn = null;
			ResultSet rs = null;
			Statement stmt=null;
			PreparedStatement pstmt = null;

			String query = "";

			try
			{
				
				dbConn = ConnectionManager.getConnection(request); 
				

				query = "SELECT NVL(DEFAULT_VALUE,'') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
							+ " WHERE SEGMENT_ID = ? and  STANDARD_CODE = ? "
							+ " AND ELEMENT_ID = ?";
						
				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_segment_id);
				pstmt.setString(2, l_standard_code);
				pstmt.setString(3, l_element_id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				   l_field_value = rs.getString("DEFAULT_VALUE");
				}

			}
			catch(Exception e)
			{
				System.out.println("Error in "+ l_app_msg + " : " +  e.getMessage());
			}
			finally
			{			
				XHUtil.closeDBResources(rs, pstmt, dbConn);
			}	


			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			facilityId = (String) session.getValue("facility_id");			
			l_app_msg = " ::: facilityId ::: "+facilityId;
			if (isDebugYN) System.out.println(l_app_msg);

			addedId = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			l_app_msg = "::: addedId ::: "+addedId;
			if (isDebugYN) System.out.println(l_app_msg);

			l_aadhaar_no = request.getParameter("AADHAAR_NO");
			l_app_msg = "::: l_aadhaar_no ::: "+l_aadhaar_no;
			if (isDebugYN) System.out.println(l_app_msg);

			l_request_id = request.getParameter("REQUEST_ID");
			l_app_msg = "::: l_request_id ::: "+l_request_id;
			if (isDebugYN) System.out.println(l_app_msg);
			
			AadhaarRequest aadhaarReq = new AadhaarRequest();
			//l_request_id = aadhaarReq.eKYCGetRequestId();///Getting the sequence Id

			l_param_string = "<FACILITY_ID>"+facilityId+"$!^<ADDED_BY_ID>"+addedId+"$!^<AADHAAR_NO>"+l_aadhaar_no+"$!^<REQUEST_ID>"+l_request_id+"$!^";
			l_app_msg = " ::: l_param_string ::: "+l_param_string;
			//if (isDebugYN) System.out.println(l_app_msg);


			l_return_str = aadhaarReq.InsertAadhaarRequest(request, l_param_string);///inserting into the table

			l_app_msg = "::: l_return_str ::: "+l_return_str;
			if (isDebugYN) System.out.println(l_app_msg);
			
			int waittime = InterfaceUtil.getWaitTime("AADHAARPO");	
			l_app_msg = "::: AADHAAR Wait time ::: "+waittime;
			if (isDebugYN) System.out.println(l_app_msg);
			
			StringTokenizer token = new StringTokenizer(l_return_str, "$!^");
			String[] arr = new String[2];
			int i=0;
			while (token.hasMoreTokens()) {
				arr[i] = token.nextToken();
				i++;
			}
			err_cd = arr[0];
			err_msg = arr[1];

			l_app_msg = " ::: ERR_CD ::: "+err_cd+" ::: ERR_MSG ::: "+err_msg;
			if (isDebugYN) System.out.println(l_app_msg);
			
			if(err_cd.equals("E"))
			{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
 
			}
			else
			{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(l_field_value));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(l_aadhaar_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(l_request_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(addedId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(waittime));
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
		
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
