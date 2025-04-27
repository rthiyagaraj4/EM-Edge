package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eXH.InterfaceUtil;
import eXH.XHDBAdapter;
import java.text.*;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStream;
import java.io.DataOutputStream;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __emkycdetails_sethu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/EMKYCDetails_Sethu.jsp", 1733051297275L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\t\n\t<head>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\n\t\t<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eCommon/js/jquery-3.6.3.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t</head>\n\t\n\t<body>\t\n\t\t<form name=\"ekycform\" id=\"ekycform\">\n\n\t\t<p>\n\t\t\t\tRequest Details : Hash ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t</p>\n\t\t<p>\n\t\t\t\tRequest Details : UUID ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n\t\t</p>\n\t\t<p>\n\t\t\t\tRequest Details : Status ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</p>\n\t\t<p>\n\t\t\t\tRequest Details : requestId ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</p>\n\t\t<p>\n\t\t\t\tResponse Message :  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</p>\n\t\t<input type=\'hidden\' name=\'hashData\' id=\'hashData\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >\n\t\t<input type=\'hidden\' name=\'uuid\' id=\'uuid\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t<input type=\'hidden\' name=\'status\' id=\'status\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n\t\t<input type=\'hidden\' name=\'requestId\' id=\'requestId\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\n\t\t</form>\n\t</body>\n</html>\n\n";
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
            _bw.write(_wl_block6Bytes, _wl_block6);


		//http://localhost:8899/eHIS/eXH/jsp/EMKYCDetails.jsp?requestId=731418475004&uuid=3722398c-72fb-4bf1-a662-8611a1cb21b1&hash=f063f1205ec53b6f376f93057f5bd27011332db55385de5b05aefda1e3ccd430&status=success

			String hashData = "";
			String uuid = "";
			String status = "", requestId = "";
			
			request.setCharacterEncoding("UTF-8");
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			hashData = request.getParameter("hash");
			uuid = request.getParameter("uuid");
			status = request.getParameter("status");
			requestId = request.getParameter("requestId");
			System.out.println(" ::: hashData ::: "+hashData);
			System.out.println(" ::: uuid  ::: "+uuid);
			System.out.println(" ::: status ::: "+status);
			System.out.println(" ::: Request id  ::: "+requestId);

			String eKYCUrl = "http://ekyc.mobilewaretech.com:2080/Ekyc-web/api/users/1.0/fetchekyc";

			String message = "", l_return_resp = "", l_response_msg = "";

			HttpURLConnection conn = null;

			try
			{
				message = "{ "
						  +"  \"tenantCode\": \"mbwareKDAKYC\", "
						  +"  \"requestId\": \""+requestId+"\","
						  +"  \"hash\": \""+hashData+"\","
						  +"  \"uuid\": \""+uuid+"\","
						  +"  \"status\": \""+status+"\","
						  +"  \"dt\":\"43215001\" "
						  +"}";

				System.out.println(" ::: Message ::: "+message);

				URL url = new URL(eKYCUrl);

				System.out.println(" ::: URL Open Connection ::: ");	

				conn = (HttpURLConnection) url.openConnection();

				System.out.println(" ::: Set Request Method POST ::: ");	

				conn.setRequestMethod("POST");
				
				System.out.println(" ::: Set Content Header : Content Type Application/json ::: ");

				conn.setRequestProperty("Content-Type", "Application/json");

				System.out.println(" ::: Set Content Header : Access Token ::: ");
				
				conn.setRequestProperty("Access-Token", "41fa498922a60d020f882e4b349a14cc");

				System.out.println(" ::: Set Content Header : Accept ::: ");
				
				conn.setRequestProperty("Accept", "Application/json");

				System.out.println(" ::: Set setUseCaches(false) ::: ");

				conn.setUseCaches(false);

				System.out.println(" ::: Set setDoOutput(true) ::: ");
				
				conn.setDoOutput(true);

				System.out.println(" ::: Writing the request to the OutputStream...");

				OutputStream os = conn.getOutputStream();
				os.write(message.getBytes());
				os.flush();

				System.out.println(" ::: Reading the response from the OutputStream...");
				
				InputStream is;
				try{
					is = conn.getInputStream();
				}catch(Exception e){
					is = conn.getErrorStream();
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((is)));

				System.out.println(" ::: Output from Server .... \n");

				while ((l_response_msg = br.readLine()) != null) {
					l_return_resp = l_return_resp + l_response_msg;
					System.out.println(l_return_resp);
				}
				
				conn.disconnect();
				
			}
			catch (MalformedURLException e) 
			{
				System.out.println("Error in Malformed URL : " +  e.getMessage());
			} 
			catch (IOException e) 
			{
				System.out.println("Error in IO Exception : " +  e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println("Error in Exception : " +  e.getMessage());
			}			
			
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(hashData ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(uuid ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(status ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(requestId ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(l_return_resp ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(hashData));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(uuid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(status));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(requestId));
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
