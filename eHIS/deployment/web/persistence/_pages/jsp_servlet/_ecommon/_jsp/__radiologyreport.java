package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eOR.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __radiologyreport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/RadiologyReport.jsp", 1709116511123L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<HTML>\n<HEAD>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</HEAD>\n<script>\nfunction goHomePage()\n{\n\tif (document.forms[0].report_server_3f.value==\'N\'){\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t}else{\n\t\tif (document.forms[0].p_radiologist_id.value == \"\")\n\t\t{\n\t\t\talert(\'Login User is not a Radiologist\');\n\t\t}\n\t\telse\n\t\t{\n\t\t//alert(\"appl_url_3tf====>\"+document.forms[0].appl_url_3tf.value);\n\t\twindow.open(document.forms[0].appl_url_3tf.value,\'eHIS\',\'location=0,height=700,width=1050,top=0,left=0,resizable=yes\');\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t}\n\t}\n}\n\nfunction closePage()\n{\n\tparent.window.close();\n}\n</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<BODY onKeyDown = \'lockKey()\'>\n</BODY>\n<form name=\"dumy\" id=\"dumy\">\n<input type=\"hidden\" name=\"report_server_3f\" id=\"report_server_3f\" value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'>\n<input type=\"hidden\" name=\"appl_url_3tf\" id=\"appl_url_3tf\" value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n<input type=\"hidden\" name=\"p_radiologist_id\" id=\"p_radiologist_id\" value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n\n</form>\n</HTML>\n<script language=\"VBScript\">\n\t\tDim WSHShell\n\t\tSet WSHShell = CreateObject(\"WScript.Shell\")\n\t\tWSHShell.Run \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\t\t\n</script> \n<script>\n\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script >\n\tgoHomePage();\n\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<script >\n\tclosePage();\n\t</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

Connection con=null ;
Statement stmt=null;
ResultSet rs=null;
con = ConnectionManager.getConnection(request);

//Properties properties		= (Properties) session.getValue( "jdbc" );
//String user_id				= (String) session.getAttribute( "login_user" ) ;
String user_id = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");

//String 	user_password		= "";
String 	patient_id			= "";
String 	encounter_id		= "";
String 	function_id			= "";
String 	form_id				= "";
String 	call_func			= "";
String database_name		= "";
String new_url	="";
String report_server_3f = "N";
String appl_url_3tf="";

String 	p_performing_facility_id		= "";
String 	p_req_num			= "";
String 	p_req_line_num		= "";
String 	p_wing_code			= "";
String 	p_frwd_status				= "";
String 	p_act_radiologist_id			= "";
String p_radiologist_id		= "";
String p_forwarded_seq_no		= "";


	patient_id=request.getParameter("patient_id");
	if (patient_id==null) patient_id = "";
	encounter_id=request.getParameter("encounter_id");
	if (encounter_id==null) encounter_id = "";
	function_id=request.getParameter("function_id");
	if (function_id==null) function_id = "";
	call_func=request.getParameter("call_func");
	if (call_func==null) call_func = "";
 String build_form_string		= "";
try{
	stmt = con.createStatement();
	/*String query="select app_password.decrypt(appl_user_password) from sm_appl_user where appl_user_id ='"+user_id+"'";
	rs = stmt.executeQuery(query);
	while(rs.next())
	{
		user_password=rs.getString(1);
	}
	if(rs!=null) rs.close();*/

	//String query1="select function_parameters from sm_function where function_id ='"+function_id+"'";
	String query1="select executable_name from sm_function where function_id ='"+function_id+"'";
	rs = stmt.executeQuery(query1);
	while(rs.next())
	{
		//form_id=rs.getString("function_parameters");
		form_id=rs.getString("executable_name");
		if (form_id==null) form_id = "";
	}
	if(rs!=null) rs.close();	

	
	String query2="select report_connect_string ,NVL(REPORT_SERVER_3F,'N') REPORT_SERVER_3F from sm_Db_info";
	rs = stmt.executeQuery(query2);
	while(rs.next())
	{
		database_name=rs.getString(1);
		if (database_name==null) database_name = "";

		report_server_3f=rs.getString("REPORT_SERVER_3F");
		if (report_server_3f==null) report_server_3f = "N";
	}
	
	if(rs!=null) rs.close();

		// Query and take the database user_id and password

//String facility_id			= (String)session.getValue("facility_id");
//String ws_no				= properties.getProperty( "client_ip_address");
//String responsibility_id	= (String)session.getValue("responsibility_id");

	String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
	String responsibility_id = request.getParameter("responsibility_id") == null ? "" : request.getParameter("responsibility_id");
	String ext_appl_accession_num = request.getParameter("ext_appl_accession_num") == null ? "" : request.getParameter("ext_appl_accession_num");
		
	String ws_no = "";
	ws_no = request.getRemoteAddr();

/*String jdbc_dns				= properties.getProperty( "ecis_jdbc_dns" );
	if(jdbc_dns!=null)
	database_name		= jdbc_dns.substring(jdbc_dns.lastIndexOf(":")+1,jdbc_dns.length());*/


//String user_details				= (user_id)+"/"+(user_password)+"@"+(database_name);

	//{  //Open the Forms window.

	
	/*if(report_server_3f.equals("N")){
		if ( function_id.equals("BL_IP_TR_CS_RCPTREF_ENT_J")) {

 			 build_form_string = "IFRUN60.exe "+form_id+" P_USER_ID="+user_id+" P_PWD="+user_password+" P_HOSTSTRING="+database_name+" P_LANGUAGE_ID="+locale+" P_FACILITY_ID="+facility_id+" P_WS_NO="+ws_no+" P_RESP_ID="+responsibility_id+" P_ACCESS_RIGHTS=YYYNN P_FUNCTION_ID="+function_id+" P_invoke=IBAEHIS P_PATIENT_ID="+patient_id+" P_RECPT_NATURE_CODE=AD P_EPISODE_ID="+encounter_id+" P_EPISODE_TYPE=I";
	}
	else if ( function_id.equals("INVOKE_FORMS_NAVIG"))
	{
		build_form_string = "IFRUN60.exe "+form_id+" P_USERID='"+user_id+"' P_PASSWORD='"+user_password+"' P_DOMAIN='"+database_name+"'";

		}
		else
		{
			 build_form_string = "IFRUN60.exe "+form_id+" P_USER_ID="+user_id+" P_PWD="+user_password+" P_HOSTSTRING="+database_name+" P_LANGUAGE_ID="+locale+" P_FACILITY_ID="+facility_id+" P_WS_NO="+ws_no+" P_RESP_ID="+responsibility_id+" P_ACCESS_RIGHTS=YYYNN P_FUNCTION_ID="+function_id+" P_invoke=IBAEHIS ";	
		}
	}else{*/
		query2="select APPL_URL_3TF from SM_FACILITY_PARAM where FACILITY_ID='"+facility_id+"'";

		rs = stmt.executeQuery(query2);
		while(rs.next())
		{
			appl_url_3tf=rs.getString("APPL_URL_3TF");
			if (appl_url_3tf==null) appl_url_3tf = "";
			
		}
		

		String query3="select OPERATING_FACILITY_ID,REQUEST_NUM,REQUEST_LINE_NUM from rd_exam_view_requested where EXT_APPL_ACCESSION_NUM = '"+ext_appl_accession_num+"'";

		rs = stmt.executeQuery(query3);
		while(rs.next())
		{
			p_performing_facility_id=rs.getString("OPERATING_FACILITY_ID");
			if (p_performing_facility_id==null) p_performing_facility_id = "";

			p_req_num=rs.getString("REQUEST_NUM");
			if (p_req_num==null) p_req_num = "";

			p_req_line_num=rs.getString("REQUEST_LINE_NUM");
			if (p_req_line_num==null) p_req_line_num = "";
			
		}

		
		String query5="SELECT RADIOLOGIST_ID FROM RD_RADIOLOGIST WHERE OPERATIONAL_FACILITY_ID = '"+p_performing_facility_id+"' AND USER_ID = '"+user_id+"' AND LANGUAGE_ID = '"+locale+"'";

		rs = stmt.executeQuery(query5);
		while(rs.next())
		{

			p_radiologist_id=rs.getString("RADIOLOGIST_ID");
			if (p_radiologist_id==null) p_radiologist_id = "";

		}
		

		String query4="SELECT WING_CODE,FORWARDED_STATUS,FORWARDED_FROM_RAD_ID ACT_RADIOLOGIST_ID,FORWARDED_SEQ_NO FROM RD_REQUEST_AUTH_VIEW WHERE OPERATING_FACILITY_ID = '"+p_performing_facility_id+"' AND REQUEST_NUM = '"+p_req_num+"' AND REQUEST_LINE_NUM = '"+p_req_line_num+"' AND LANGUAGE_ID = '"+locale+"'";

		rs = stmt.executeQuery(query4);
		while(rs.next())
		{
			p_wing_code=rs.getString("WING_CODE");
			if (p_wing_code==null) p_wing_code = "";

			p_frwd_status=rs.getString("FORWARDED_STATUS");
			if (p_frwd_status==null) p_frwd_status = "";

			p_act_radiologist_id=rs.getString("ACT_RADIOLOGIST_ID");
			if (p_act_radiologist_id==null) p_act_radiologist_id = p_radiologist_id;
			
			p_forwarded_seq_no=rs.getString("FORWARDED_SEQ_NO");
			if (p_forwarded_seq_no==null) p_forwarded_seq_no = "";

		}

		
		user_id=user_id+"@"+database_name;

		//build_form_string="&form="+form_id+"&otherparams=+P_USER_ID="+user_id+"+P_LANGUAGE_ID="+locale+"+P_FACILITY_ID="+facility_id+"+P_WS_NO="+ws_no+"+P_RESP_ID="+responsibility_id+"+P_ACCESS_RIGHTS=YYYNN+P_FUNCTION_ID="+function_id+"+P_RGQUERY=IBAEHIS ";

		build_form_string="&form="+form_id+"&otherparams=+P_USER_ID="+user_id+"+P_LANGUAGE_ID="+locale+"+P_FACILITY_ID="+facility_id+"+P_WS_NO="+ws_no+"+P_RESP_ID="+responsibility_id+"+P_ACCESS_RIGHTS=YYYYN+P_FUNCTION_ID="+function_id+"+P_PERFORMING_FACILITY_ID="+p_performing_facility_id+"+P_WING_CODE="+p_wing_code+"+P_REQ_NUM="+p_req_num+"+P_REQ_LINE_NUM="+p_req_line_num+"+P_ACT_RADIOLOGIST_ID="+p_act_radiologist_id+"+P_RADIOLOGIST_ID="+p_radiologist_id+"+P_SEL_RADIOLOGIST="+p_radiologist_id+"+P_RGQUERY=IBAEHIS ";

		appl_url_3tf=appl_url_3tf+build_form_string;
		build_form_string="";

		//out.println(appl_url_3tf);
		
		if(rs!=null) rs.close();	

			//new_url="http://cscappche644:9005/forms/frmservlet?config=TEST_DUMMY&form=SMAFMRAD&otherparams=P_RESP_ID=SM_MANAGER+P_USER_ID=NAREN+P_PWD=NAREN+P_HOSTSTRING=SRDV+P_FACILITY_ID=HS+p_language_id=en+P_ACCESS_RIGHTS=YYYNN+P_WS_NO=INDCHN-NB409+P_INVOKE=iba+P_FUNCTION_ID=SM_ADMIN_FAX_MAIL";


	//}

	
	if(stmt!=null) stmt.close();

}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();	
}
 finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(report_server_3f));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(appl_url_3tf));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(p_radiologist_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(build_form_string));
            _bw.write(_wl_block8Bytes, _wl_block8);

if (!call_func.equals("ADMIT"))
{
            _bw.write(_wl_block9Bytes, _wl_block9);

}else{

            _bw.write(_wl_block10Bytes, _wl_block10);

}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
