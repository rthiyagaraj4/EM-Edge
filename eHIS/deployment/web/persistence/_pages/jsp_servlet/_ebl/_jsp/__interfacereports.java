package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __interfacereports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/InterfaceReports.jsp", 1709114663647L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- JSP Created Against AAKH-CRF-0113.3 -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<form name=\"report_server_form\" id=\"report_server_form\" method=\"Post\">\n\t<input type=\"hidden\" name=\"report_server\" id=\"report_server\" id=\"report_server\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\" id=\"user_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\n\t<input type=\"hidden\"\tname=\"reportserver\" id=\"reportserver\"\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\"hidden\" \tname=\"report\" id=\"report\"\t\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" \tname=\"userid\" id=\"userid\"\t\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\"\tname=\"server\" id=\"server\"\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\"hidden\"\tname=\"desformat\" id=\"desformat\"\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"destype\" id=\"destype\"\t\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"desname\" id=\"desname\"\t\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"copies\" id=\"copies\"\t\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\"hidden\"\tname=\"params\" id=\"params\"\t\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\"\tname=\"queue_name\" id=\"queue_name\"\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\"hidden\"\tname=\"message\" id=\"message\"\t\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\n\t<input type=\"hidden\"\tname=\"self_submit\" id=\"self_submit\"\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\"\tname=\"p_module_id\" id=\"p_module_id\"\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\"\tname=\"p_report_id\" id=\"p_report_id\"\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\"\tname=\"dest_locn_type\" id=\"dest_locn_type\"\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\"\tname=\"dest_locn_code\" id=\"dest_locn_code\"\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\"\tname=\"languageID\" id=\"languageID\"\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\"\tname=\"rep_server_key\" id=\"rep_server_key\"\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n</form>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n<script language=\"JavaScript\">\nfunction callReportOptionsFrameset( params ) {\n\tvar reportserver = document.getElementById(\"reportserver\").value;\n\tvar report_server = document.getElementById(\"report_server\").value;\n\treportserver = reportserver+report_server;\n\tvar params = document.getElementById(\"params\").value;\n\tvar user_id = document.getElementById(\"user_id\").value;\n\tvar server = document.getElementById(\"server\").value;\n\tvar report = document.getElementById(\"report\").value;\n\tvar languageID = document.getElementById(\"languageID\").value;\n\tvar self_submit = document.getElementById(\"self_submit\").value;\n\tvar regExp = /&/g ;\n\tparams = params.replace( regExp, \"+\" ) ;\n\tparams=params.toUpperCase();\n\tvar locale=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\tif(languageID!=\"\"){\n\t\tlocale=languageID;\n\t}\n\tparams=params+\"+P_LANGUAGE_ID=\"+locale;\n\tvar url = reportserver+\n\t\t\t\"?server=\"\t\t+ server+\n\t\t\t\"+report=\" \t\t+ report+\n\t\t\t\"+desformat=pdf+destype=cache+recursive_load=no+userid=\"+user_id+\n\t\t\t\"+SELF_SUBMIT=YES+REPORT_OPTION=V+\"+params;\n\tif ( url != null ) {  \n\tvar reportURL\t\t= \"../../eCommon/jsp/report_process.jsp?\" + url ;\n\tvar myBars \t\t= \'directories=no,location=no,menubar=no\' ;\n\tvar myOptions \t= \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=yes\' ;\n\tvar myFeatures \t= myBars + \', \' + myOptions ;\n\tvar reportWindow \t= open(reportURL, \'_blank\', myFeatures);\n\n\treportWindow.title= \"Medicom Report Viewer\";\n\treportWindow.resizeTo(screen.availWidth, screen.availHeight);\n\treportWindow.moveTo( 0,0 );\n\treportWindow.focus();\n\t}\n}\t\n</script>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n<!--JSP Created Against AAKH-CRF-0113.3-->\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale=(String)session.getAttribute("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" );
	String reportServer	= (String) session.getValue( "report_server" );
	String userid		= (String) session.getValue( "report_connect_string" );
	String params		= request.getQueryString();
	String self_submit	= request.getParameter( "self_submit" );
	PreparedStatement pstmt1 = null ;
	ResultSet rs1 =null;
	String jdbc_username="";
	String jdbc_password="";
	String report_server="";
	String reoprt_connect_string="";
	String user_id="";
	
	String report		= "";
	String server		= "";
	String copies		= "";
	String queue_name	= "";
	String message		= "";

	String module_id		= request.getParameter( "p_module_id" );
	String report_id		= request.getParameter( "p_report_id" );
	String dest_locn_type	= request.getParameter( "dest_locn_type" );
	String dest_locn_code	= request.getParameter( "dest_locn_code" );

	String facility_id	= (String) session.getValue( "facility_id" );
	String ws_no		= (String) p.getProperty( "client_ip_address" );
	String report_option = request.getParameter( "report_option" );
	String languageID	= request.getParameter( "p_language_id" )==null?"": request.getParameter( "p_language_id" );

	String app_server_ip	= "";
	String rep_server_key	= "";
	if ( reportServer		== null ) reportServer	= "";
	if ( userid			== null ) userid		= "";
	if ( params 		== null ) params 		= "";
	if ( self_submit		== null ) self_submit	= "";

	if ( module_id		== null ) module_id 	= "";
	if ( report_id		== null ) report_id 	= "";
	if ( dest_locn_type 	== null ) dest_locn_type= "";
	if ( dest_locn_code	== null ) dest_locn_code= "";
	if ( facility_id		== null ) facility_id	= "";
	if ( ws_no			== null ) ws_no		= "";
	if ( report_option	== null ) report_option = "V";
	
	Connection con=null;
	try{
		con = ConnectionManager.getConnection(request);
		CallableStatement cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" );
		cs.setString( 1,	module_id );
		cs.setString( 2,	report_id );
		cs.setString( 3,	dest_locn_type );
		cs.setString( 4,	dest_locn_code );
		cs.setString( 5,	facility_id );
		cs.setString( 6,	ws_no );
		cs.setString( 7,	report_option );
		cs.registerOutParameter( 8,  Types.VARCHAR );
		cs.registerOutParameter( 9,  Types.VARCHAR );
		cs.registerOutParameter( 10, Types.VARCHAR );
		cs.registerOutParameter( 11, Types.VARCHAR );
		cs.registerOutParameter( 12, Types.VARCHAR );
		cs.registerOutParameter( 13, Types.VARCHAR );
		cs.registerOutParameter( 14, Types.VARCHAR );
		cs.registerOutParameter( 15, Types.VARCHAR );
		cs.registerOutParameter( 16, Types.VARCHAR );
		cs.registerOutParameter( 17, Types.VARCHAR );
		cs.execute() ;

		report	= cs.getString( 8 );
		server	= cs.getString( 9 );
		copies	= cs.getString( 10 );
		if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
		queue_name	= cs.getString( 12 );
		message	= cs.getString( 15 );
		if (message==null) message="";
		app_server_ip = cs.getString( 16 );
		rep_server_key= cs.getString( 17 );
		if (rep_server_key==null) rep_server_key="";
     
		reportServer = "http://" + app_server_ip + reportServer;

		if(cs !=null)cs.close();
		
	String sql1="select USER_ID,app_password.decrypt(password),REPORT_SERVER,REPORT_CONNECT_STRING  from sm_db_info";
		
	pstmt1=con.prepareStatement(sql1);
	rs1=pstmt1.executeQuery();
	
	while(rs1.next())
	{
		jdbc_username	=rs1.getString(1);	
		jdbc_password	=rs1.getString(2);
		report_server =rs1.getString(3);
		reoprt_connect_string =rs1.getString(4);	
	}
	user_id = jdbc_username+"/"+jdbc_password+"@"+reoprt_connect_string;		

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(report_server));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reportServer));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(report));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(server));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(copies));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(queue_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(message));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(self_submit));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dest_locn_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dest_locn_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(languageID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rep_server_key));
            _bw.write(_wl_block25Bytes, _wl_block25);
	
	}catch(Exception e){out.println(e);e.printStackTrace();}
	finally { 
	ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);

if ( params == null ) params = "" ;
	out.println( "<script language=\"JavaScript\">callReportOptionsFrameset(\"" + java.net.URLDecoder.decode(params) + "\")</script>" ) ;

            _bw.write(_wl_block28Bytes, _wl_block28);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
