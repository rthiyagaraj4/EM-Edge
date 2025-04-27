package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __showmalaffiportal extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ShowMalaffiPortal.jsp", 1709122392428L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!DOCTYPE html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\n\t\t<title>Malaffi Portal</title>\t\t\n\t\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" type=\"text/css\" />\n\t\t<style>\t\t\t\n\t\t\t#panel {\n\t\t\t  display: none;\n\t\t\t}\n\t\t</style>\n\t\t\n\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t</head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body>\n\t\t<div id=\"panel\">\n            <p><b>Loading Details...</b></p>\n\t\t</div>\n\t\t<form name=\"malaffiForm\" id=\"malaffiForm\" id=\"malaffiForm\" method=\"POST\" action=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >\n\t\t\t<input type=\"hidden\" name=\"SAMLResponse\" id=\"SAMLResponse\" id=\"SAMLResponse\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"errorMsg\" id=\"errorMsg\" id=\"errorMsg\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n\n\t\t\t<table cellpadding=\'3\' cellspacing=\'0\' align=\'left\' width=\'350px\' border=\'1\' FRAME=BOX>\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'6\'><label nowrap style=\"font-size:9;font-weight:bold\">Practitioner and Patient Details</label></td>\n\t\t\t</tr>\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' style:bold >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\t\n\t\t\t\t<td><input class=\'textbox\' type=\'textbox\' id=\'practitionerid\' name=\'practitionerid\' id=\'practitionerid\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' DISABLED></td>\n\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<td><input class=\'textbox\' type=\'textbox\' size=\'50\' id=\'practitionername\' name=\'practitionername\' id=\'practitionername\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' DISABLED></td>\n\t\t\t\t<td  class=\'label\'>License Number</td>\n\t\t\t\t<td><input class=\'textbox\' type=\'textbox\' id=\'licenseno\' name=\'licenseno\' id=\'licenseno\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' DISABLED></td>\n\t\t\t</tr>\t\t\t\n\t\t\t<tr>\t\n\t\t\t   \t<td  class=\'label\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<td><input class=\'textbox\' type=\'textbox\' id=\'patientid\' name=\'patientid\' id=\'patientid\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td colspan=\'3\'><input class=\'textbox\' type=\'textbox\' size=\'50\' id=\'patientname\' name=\'patientname\' id=\'patientname\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' DISABLED></td>\n\t        </tr>\t\t\t\t\t\n\t\t\t<tr>\t\t\t\t\n\t\t\t\t<td align=\'right\' colspan=6>\n\t\t\t\t\t<input class=\'button\'  type=\"submit\" name=\"submit\" id=\"submit\" value=\"Send SAML response to Malaffi\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\t\n\t\t\t\t<td class=\'label\' colspan=2>Error</td>\n\t\t\t\t<td align=\'right\' colspan=4>\n\t\t\t\t\t<textarea id=\"error\" name=\"error\" rows=\"4\" cols=\"75\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</textarea> \n\t\t\t\t</td>\n\t\t\t</tr>\t\t\t\n\t   \t</table>\n\t\t</br>\n\n\t\t<!--\n\t<iframe id=\"malaffi_target\" name=\"malaffi_target\" style=\"width:800px;height:600px;border:0px solid #fff;\" onload=\"stopUpload()\">   \n    </iframe>\n\n\t-->\n\n\t</form>\n\t\t<!--<pre>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</pre>-->\n\t\n\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<script>\n\n\t\t/*\n\t\t\t$(document).ready(function(){\n\t\t\t\tif (!( $(\"#errorMsg\").val().length>0) && ($(\"#SAMLResponse\").val().length>0))\n\t\t\t\t{\n\t\t\t\t\tstartUpload();\n\t\t\t\t\t$(\"malaffiForm\").submit();\t\t\n\t\t\t\t}\n\t\t\t});\n\t\t*/\n\n\t\t\t\n\t\t\tfunction startUpload()\n\t\t\t{            \n\t\t\t\t//$(\"#panel\").dialog(\"open\");\n\t\t\t\t//$(\"panel\").show();\n\t\t\t\tdocument.getElementById(\"panel\").style.display = \"block\";\n\t\t\t\t\n\t\t\t} \n\n\t\t\tfunction stopUpload()\n\t\t\t{            \n\t\t\t\t//$(\"#panel\").dialog(\"close\");\n\t\t\t\t//$(\"#panel\").hide();\n\t\t\t\tdocument.getElementById(\"panel\").style.display = \"none\";\n\t\t\t}\n\t\t</script>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
	
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


		String getHTTPValues(String StandardCode, String SegmentID, String ElementID, HttpServletRequest request, boolean isDebugYN)
		{
			String httpSql = "", defaultValue = "", l_app_msg = "", l_errorMsg = "";
			Connection con = null;
			ResultSet rs = null;
			PreparedStatement stmt = null;
			
			try {

				con = ConnectionManager.getConnection(request);

				httpSql = "select DEFAULT_VALUE from XH_STANDARD_CONTROL_SEG where STANDARD_CODE = ? and SEGMENT_ID = ? and ELEMENT_ID = ? ";
				
				l_app_msg = "***Inside Show Malaffi Portal - Standard Control Segment Query  : " +httpSql+ " Standard Code : " +StandardCode+ " Segment ID : " +SegmentID+ " Element ID : "+ ElementID;
				if (isDebugYN) System.out.println(l_app_msg);

				stmt=con.prepareStatement(httpSql);
				stmt.setString(1,StandardCode);
				stmt.setString(2,SegmentID);
				stmt.setString(3,ElementID);
				rs=stmt.executeQuery();

				if (rs!=null){

					while (rs.next())
					{
						defaultValue = rs.getString("DEFAULT_VALUE")==null?"":rs.getString("DEFAULT_VALUE");
					}

					l_app_msg = "***HTTP Values  : " +defaultValue;
					if (isDebugYN) System.out.println(l_app_msg);
					
					
					rs = null;
				}
				stmt = null;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				l_errorMsg = "Exception in fetching the Default Values : "+ l_app_msg + " : " +  e.getMessage();
				return l_errorMsg;
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	

			return defaultValue;
		}

		String FetchSubjRoleMethod(String practType, HttpServletRequest request, boolean isDebugYN)
		{
			String practRoleSql = "", practRole = "", l_app_msg = "", l_errorMsg = "";
			Connection con = null;
			ResultSet rs = null;
			PreparedStatement stmt = null;
			
			try {

				con = ConnectionManager.getConnection(request);

				practRoleSql = "SELECT EXT_PK_ID FROM XH_OTH_APPL_DATA_SKEY WHERE TABLE_ID = 'AM_PRACT_TYPE' AND APPLICATION_ID = 'MALAFFI' AND " + "PK_VALUE = ?";
				
				l_app_msg = "***Inside Show Malaffi Portal - FetchSubjRoleMethod  : " +practRoleSql+ " Practitioner Type : " +practType;
				if (isDebugYN) System.out.println(l_app_msg);

				stmt=con.prepareStatement(practRoleSql);
				stmt.setString(1,practType);
				rs=stmt.executeQuery();

				if (rs!=null){

					while (rs.next())
					{
						practRole = rs.getString("EXT_PK_ID")==null?"":rs.getString("EXT_PK_ID");
					}

					l_app_msg = "***Practitioner Role : " +practRole;
					if (isDebugYN) System.out.println(l_app_msg);
					
					
					rs = null;
				}
				stmt = null;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				l_errorMsg = "Exception in fetching the User Role Type : "+ l_app_msg + " : " +  e.getMessage();
				return l_errorMsg;
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	

			return practRole;
		}

		String FieldValueFetchMethod(String message, String identifier, String fieldSep, boolean isDebugYN)
		{
			String l_app_msg = "", l_field_value = "";	

			try
			{
				
				l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
				if (isDebugYN)  System.out.println(l_app_msg);	

				l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier;
				if (isDebugYN)  System.out.println(l_app_msg);				
				
				if (message.indexOf(identifier) >= 0 )
				{
					if (message.indexOf(fieldSep) >= 0)
					{
						l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0)
						{						
							l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
						}
					}
				}
				
			}
			catch (Exception e)
			{
				l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
			}		

			l_app_msg = " ::: l_field_value ::: "+l_field_value;
			if (isDebugYN)  System.out.println(l_app_msg);

			return l_field_value;
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

		request.setCharacterEncoding("UTF-8");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


		StringBuffer samlData = new StringBuffer();		
		String httpSql = "", profileSql = "", practSql = "", paramString = "", protocolLinkID = "", l_app_msg = "", samlAssertion = "";
		String errorCode = "", errorMsg = "", responseTxt = "", l_return_resp = "", l_response_msg = "", strException = "Exception in";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null, pstmt = null;
		CallableStatement cstmt = null;	
		
		boolean isDebugYN = false;
		
		String l_url = "http://130.78.97.167:8080/EM/saml/s1/TransRequest";
		String l_http_content_type = "text/plain";
		String l_http_user_agent = "";
		String l_http_transfer_encoding = "";
		String l_http_soapaction = "", l_standard_code = "";
		int l_http_content_length_flag  = 0;

		String l_proxy_server="", l_proxy_port="", l_profile_url = "", l_profile_id = "", l_practitioner_id = "", l_patient_id = "";

		HttpURLConnection conn = null;


		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
		String facilityId	= (String)session.getValue("facility_id");	
		
		String SegmentID = "PWEB", ElementID = "", StandardCode = "MLFIHL725";

		String l_first_name="", l_last_name="", l_full_name="", l_email_address="", l_phone="", l_gender="", l_apc_no="",l_pract_type="", l_subject_role="";

		String l_pat_first_name="", l_pat_second_name="", l_pat_third_name="", l_pat_full_name="", l_user_id = "";

		String disabledFlag = "";


		try {

			isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN,'N') DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
			
			System.out.println("***Inside Invoke External Application - isDebugYN... " +isDebugYN);
			
			paramString = request.getParameter("dataElements")==null?"":request.getParameter("dataElements");
			l_app_msg = " Setting paramString... "+paramString;
			if (isDebugYN) System.out.println(l_app_msg);

			l_patient_id = FieldValueFetchMethod(paramString, "<PATIENT_ID>", "$!^", isDebugYN);
			l_app_msg = "Fetching Patient Details... "+l_patient_id;
			if (isDebugYN) System.out.println(l_app_msg);

			try {

				con = ConnectionManager.getConnection(request);

				practSql = "Select patient_id, NAME_PREFIX, FIRST_NAME, SECOND_NAME, THIRD_NAME, PATIENT_NAME from mp_patient where patient_id = ?";

				pstmt = con.prepareStatement(practSql);
				pstmt.setString(1, l_patient_id);			
				rs = pstmt.executeQuery();
				if (rs!=null){ 
					while(rs.next())
					{
					   l_pat_first_name = rs.getString("FIRST_NAME");
					   l_pat_second_name = rs.getString("SECOND_NAME");
					   l_pat_third_name = rs.getString("THIRD_NAME");
					   l_pat_full_name = rs.getString("PATIENT_NAME");
					  
					}

					rs = null;
				}

				l_app_msg = " ::: Patient First Name : "+ l_pat_first_name + " ::: Second Name : " + l_pat_second_name + " ::: Full Name : "+ l_pat_full_name;
				if (isDebugYN) System.out.println(l_app_msg);	

				pstmt = null;
			}
			catch(Exception e)
			{
				out.println("<h3> Exception in fetching the Patient Details : "+e.toString());
				errorMsg = "Exception in fetching the Patient Details : "+e.toString();
				e.printStackTrace();
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}

			l_practitioner_id = FieldValueFetchMethod(paramString, "<PRACTITIONER_ID>", "$!^", isDebugYN);

			l_app_msg = "Practitioner ID... "+l_practitioner_id;
			if (isDebugYN) System.out.println(l_app_msg);

			l_user_id = FieldValueFetchMethod(paramString, "<USER_NAME>", "$!^", isDebugYN);

			l_app_msg = "Fetching User ID... "+l_user_id;
			if (isDebugYN) System.out.println(l_app_msg);

			/*

			if (!(l_practitioner_id.length()>0))
				l_practitioner_id = l_user_id;

			*/

			l_app_msg = "Fetching User Details... "+l_user_id;
			if (isDebugYN) System.out.println(l_app_msg);

			try {

				con = ConnectionManager.getConnection(request);

				practSql = "Select PRACTITIONER_ID, PRACTITIONER_NAME, NVL(EMAIL_ID,'') EMAIL_ID, NVL(OFF_TEL_NUM,'') OFF_TEL_NUM, GENDER, NVL(APC_NO,'') APC_NO, PRACT_TYPE From XH_EM_USERS_VW Where PRACTITIONER_ID=?";

				pstmt = con.prepareStatement(practSql);
				pstmt.setString(1, l_user_id);			
				rs = pstmt.executeQuery();

				l_app_msg = "User Details RS... "+rs;
				if (isDebugYN) System.out.println(l_app_msg);

				if (rs!=null){ 
					while(rs.next())
					{
					   l_first_name = rs.getString("PRACTITIONER_NAME");
					   l_last_name = rs.getString("PRACTITIONER_NAME");
					   l_full_name = rs.getString("PRACTITIONER_NAME");
					   l_email_address = rs.getString("EMAIL_ID");
					   l_phone = rs.getString("OFF_TEL_NUM");
					   l_gender = rs.getString("GENDER");
					   l_apc_no = rs.getString("APC_NO");
					   l_pract_type=rs.getString("PRACT_TYPE");
					}

					rs = null;
				}

				if (!(l_first_name.length()>0))				
					errorMsg = "User Details not available for the user id : "+l_practitioner_id;
				
				l_app_msg = " ::: First Name : "+ l_first_name + " ::: Last Name : " + l_last_name + " ::: Full Name : "+ l_full_name + " ::: Email Address : "+l_email_address+ " ::: Phone Number : "+ l_phone + " ::: Gender : " + l_gender + " ::: License No : "+ l_apc_no + " ::: Practitioner Type : "+l_pract_type;
				if (isDebugYN) System.out.println(l_app_msg);	

				pstmt = null;
			}
			catch(Exception e)
			{
				out.println("<h3> Exception in fetching the Practitioner Details : "+e.toString());
				errorMsg = "Exception in fetching the Practitioner Details : "+e.toString();
				e.printStackTrace();
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}

			protocolLinkID = request.getParameter("protocolLinkId")==null?"":request.getParameter("protocolLinkId");
			l_app_msg = " Setting Protocol Link Id... "+protocolLinkID;
			if (isDebugYN) System.out.println(l_app_msg);

			if (l_pract_type.length()>0)
				l_subject_role = FetchSubjRoleMethod(l_pract_type, request, isDebugYN);			

			l_app_msg = "Error Message... "+errorMsg;
			if (isDebugYN) System.out.println(l_app_msg);

			if (l_subject_role.indexOf(strException) > 0)
				errorMsg = l_subject_role;	
			
			l_app_msg = " **************** User Name : "+ l_last_name + " *** Subject Role : "+l_subject_role+ " *** Subject Role Length : "+l_subject_role.length();
			if (isDebugYN) System.out.println(l_app_msg);	


			if (l_subject_role!=null && l_subject_role.length() > 0)
			{			
				disabledFlag = "";

				try
				{

					l_app_msg = " Fetching the EM Web Service URL... WEBURL... ";
					if (isDebugYN) System.out.println(l_app_msg);
					ElementID = "WEBURL";
					l_url = getHTTPValues(StandardCode, SegmentID, ElementID, request, isDebugYN);
					if (l_url.indexOf(strException) > 0)
						errorMsg = l_url;

					l_app_msg = " Fetching the EM Web Service URL... WEBURL... "+l_url;
					if (isDebugYN) System.out.println(l_app_msg);

					l_app_msg = " Fetching the EM Web Service Content Type... HTTP_CONTENT_TYPE... ";
					if (isDebugYN) System.out.println(l_app_msg);
					ElementID = "HTTP_CONTENT_TYPE";
					l_http_content_type = getHTTPValues(StandardCode, SegmentID, ElementID, request, isDebugYN);
					if (l_http_content_type.indexOf(strException) > 0)
						errorMsg = l_http_content_type;

					l_app_msg = " Fetching the EM Web Service URL... HTTP_CONTENT_TYPE... "+l_http_content_type;
					if (isDebugYN) System.out.println(l_app_msg);

					l_app_msg = " Fetching the EM Web Service Content Type... HTTP_PROXY_SERVER... ";
					if (isDebugYN) System.out.println(l_app_msg);
					ElementID = "HTTP_PROXY_SERVER";
					l_proxy_server = getHTTPValues(StandardCode, SegmentID, ElementID, request, isDebugYN);
					if (l_proxy_server.indexOf(strException) > 0)
						errorMsg = l_proxy_server;

					l_app_msg = " Fetching the EM Web Service URL... HTTP_PROXY_SERVER... "+l_proxy_server;
					if (isDebugYN) System.out.println(l_app_msg);

					l_app_msg = " Fetching the EM Web Service Content Type... HTTP_PROXY_PORT... ";
					if (isDebugYN) System.out.println(l_app_msg);
					ElementID = "HTTP_PROXY_PORT";
					l_proxy_port = getHTTPValues(StandardCode, SegmentID, ElementID, request, isDebugYN);
					if (l_proxy_port.indexOf(strException) > 0)
						errorMsg = l_proxy_port;

					l_app_msg = " Fetching the EM Web Service URL... HTTP_PROXY_PORT... "+l_proxy_port;
					if (isDebugYN) System.out.println(l_app_msg);
					
					l_app_msg = " Setting URL... "+l_url;
					if (isDebugYN) System.out.println(l_app_msg);

					URL url = new URL(l_url);			

					if (l_proxy_server.length()>0 && !l_proxy_server.equals("X"))
					{
						l_app_msg = " Setting http Proxy... "+l_proxy_server;
						if (isDebugYN) System.out.println(l_app_msg);

						System.setProperty("http.proxyHost", l_proxy_server);
						System.setProperty("https.proxyHost", l_proxy_server);
					}

					if (l_proxy_port.length()>0  && !l_proxy_server.equals("X"))
					{
						l_app_msg = " Setting http port... "+l_proxy_port;
						if (isDebugYN) System.out.println(l_app_msg);

						System.setProperty("http.proxyPort", l_proxy_port);       
						System.setProperty("https.proxyPort", l_proxy_port);

					}			 

					l_app_msg = " URL Open Connection...";
					if (isDebugYN) System.out.println(l_app_msg);	

					conn = (HttpURLConnection) url.openConnection();

					l_app_msg = " Connection Set Method... POST";
					if (isDebugYN) System.out.println(l_app_msg);	

					conn.setRequestMethod("POST");
					
					// Common Headers for Pancard Transactions
					
					if (l_http_content_type.length()>0  && !(l_http_content_type.equals("XXX")))
					{
						l_app_msg = " Set Property Content-Type... "+l_http_content_type;
						if (isDebugYN) System.out.println(l_app_msg);	
						conn.setRequestProperty("Content-Type", l_http_content_type);
					}			
					
					l_app_msg = " conn.setUseCaches(false)...";
					if (isDebugYN) System.out.println(l_app_msg);	
					
					conn.setUseCaches(false);
					
					//java certificate location
					//String certificatesTrustStorePath = "%JAVA_HOME%/jre/lib/security/cacerts";
					//System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);

					l_app_msg = " Set DoOutput(true)...";
					if (isDebugYN) System.out.println(l_app_msg);	
					conn.setDoOutput(true);

					l_app_msg = " Writing the request to the OutputStream...";
					if (isDebugYN) System.out.println(l_app_msg);	

					OutputStream os = conn.getOutputStream();
					os.write(paramString.getBytes());
					os.flush();

					l_app_msg = " Reading the response from the OutputStream...";
					if (isDebugYN) System.out.println(l_app_msg);	
					
					InputStream is;
					try{
						is = conn.getInputStream();
					}catch(Exception e){
						is = conn.getErrorStream();
					}

					BufferedReader br = new BufferedReader(new InputStreamReader((is)));

					l_app_msg = " Output from Server .... \n";
					if (isDebugYN) System.out.println(l_app_msg);	

					while ((l_response_msg = br.readLine()) != null) {
						l_return_resp = l_return_resp + l_response_msg;
						//l_app_msg = " Output Received from Server..."+l_return_resp;
						//if (isDebugYN) System.out.println(l_app_msg);
					}
					
					conn.disconnect();
					
				}
				catch (MalformedURLException e) 
				{
					e.printStackTrace();
					errorMsg = "MalformedURLException in accessing EM Web Service : "+  e.getMessage();
					System.out.println(" ::: MalformedURLException ::: " +errorMsg);
					
					l_return_resp = errorMsg;
					out.println("<h3>"+l_return_resp);
					
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
					errorMsg = "IOException in accessing the EM Web Service : " +  e.getMessage();
					System.out.println(" ::: IOException ::: " +errorMsg);
					
					l_return_resp = errorMsg;
					out.println("<h3>"+l_return_resp);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					errorMsg = "Exception in accessing EM Web Service : " +  e.getMessage();
					System.out.println(" ::: Exception ::: " +errorMsg);

					l_return_resp = errorMsg;
					out.println("<h3>"+l_return_resp);
					
				}		
			}
			l_app_msg = " Response Returned : \n "+l_return_resp;
			if (isDebugYN) System.out.println(l_app_msg);
			
			if (!(l_return_resp.length()>0) && !(errorMsg.length()>0))
				errorMsg = "Error in generating the SAML Response...";
			else
				errorMsg = errorMsg;


			l_app_msg = "Fetching Malaffi Portal URL... Protocol Link Id... "+protocolLinkID;
			if (isDebugYN) System.out.println(l_app_msg);	

			try {

				con = ConnectionManager.getConnection(request);

				profileSql = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
						+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
						+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
			            + " FROM    xh_protocol a, xh_protocol_link b "
						+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

				pstmt = con.prepareStatement(profileSql);
				pstmt.setString(1, protocolLinkID);			
				rs = pstmt.executeQuery();
				if (rs!=null){ 
					while(rs.next())
					{
					   l_profile_id = rs.getString("PROFILE_ID");
					   l_profile_url = rs.getString("XML_STYLE_SHEET_URL");
					   l_standard_code = rs.getString("STANDARD_CODE");
					   l_http_user_agent = rs.getString("HTTP_USER_AGENT");
					   l_http_content_type = rs.getString("HTTP_CONTENT_TYPE");
					   l_http_transfer_encoding = rs.getString("HTTP_TRANSFER_ENCODING");
					   l_http_soapaction = rs.getString("HTTP_SOAPACTION");
					   l_http_content_length_flag = rs.getInt("HTTP_CONTENT_LENGTH_FLAG");
					}

					rs = null;
				}

				l_app_msg = " ::: Profile ID : "+ l_profile_id + " ::: API URL : " + l_profile_url + " ::: Standard Code : "+ l_standard_code + " ::: HTTP User Agent : "+l_http_user_agent;
				if (isDebugYN) System.out.println(l_app_msg);	

				l_app_msg = " ::: HTTP Content Type : "+ l_http_content_type + " ::: HTTP Transfer Encoding : " + l_http_transfer_encoding + " ::: HTTP Soap Action : "+ l_http_soapaction + " ::: HTTP Content Length Flag : "+l_http_content_length_flag;
				if (isDebugYN) System.out.println(l_app_msg);	

				pstmt = null;
			}
			catch(Exception e)
			{
				out.println("<h3> Exception in fetching the Malaffi URL : "+e.toString());
				e.printStackTrace();
				errorMsg = "Exception in fetching the Malaffi URL : "+ l_app_msg + " : " +  e.getMessage();
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}

			/*

			con = ConnectionManager.getConnection(request);
			
			l_app_msg = "***Inside Show Malaffi Portal - Protocol Link ID : "+protocolLinkID;
			if (isDebugYN) System.out.println(l_app_msg);

			cstmt = con.prepareCall("{ CALL XHEMWEBSERVICE.EM_WEB_REQUEST(?,?,?,?,?) }" );
			cstmt.setString(1,protocolLinkID);
			cstmt.setString(2,paramString);
			cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			cstmt.execute();
			samlAssertion = cstmt.getString(3);
			errorCode = cstmt.getString(4);
			errorMsg = cstmt.getString(5);
			if(isDebugYN) 
				System.out.println(" Error Code : "+errorCode+" Error paramString : "+errorMsg+ " SAML Assertion ::: \n "+samlAssertion);

			if((errorMsg != null) && (errorMsg.trim().length()>0)) 
			{
				responseTxt=errorMsg;	
			}
			else
			{
				if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
				{
					 responseTxt=samlAssertion;
				}
				else
				{
					 responseTxt=samlAssertion;
				}
			}

			*/

		}
		catch(Exception e){
			errorMsg = "General Exception caught : "+ l_app_msg + " : " +  e.getMessage();
			out.println("<h3> General Exception caught : "+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}	

		/****
		1. Param string
		2. All code calls to EM web service , SAML will be generated
		3.

		4. Malaffi URL and HTTP Post
		*/
		
		l_app_msg = "Error Message... "+errorMsg;
		if (isDebugYN) System.out.println(l_app_msg);

		if (errorMsg.length() > 0)
		{
			disabledFlag = "DISABLED";
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(l_profile_url));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(l_return_resp));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(errorMsg));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(l_user_id));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(l_first_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(l_apc_no));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(l_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(l_pat_full_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disabledFlag));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disabledFlag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(errorMsg));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(l_return_resp));
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block25Bytes, _wl_block25);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionername.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
