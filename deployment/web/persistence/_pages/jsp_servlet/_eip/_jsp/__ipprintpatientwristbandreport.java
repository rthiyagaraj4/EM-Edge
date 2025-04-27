package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import ecis.utils.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __ipprintpatientwristbandreport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPPrintPatientWristbandReport.jsp", 1709117791025L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<input type=\'hidden\' name=\'rep_server_key1\' id=\'rep_server_key1\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\t<!--IN037658-->\n<input type=\'hidden\' name=\'rep_server_key2\' id=\'rep_server_key2\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\t<!--IN037658-->\n<input type=\'hidden\' name=\'rep_server_key3\' id=\'rep_server_key3\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\t<!--IN037658-->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<Script>\n\t\tvar msg=getMessage(\'REPORT_SUBMIT_SERVER\',\'Common\');\n\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;\n\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t<script>\n\t\tvar msg=getMessage(\'REPORT_RULE_NOT_DEFINED\',\'Common\');\n\t\t//alert(msg)\n\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;\n\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

	
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	//String p_user_name		= (String) session.getValue( "login_user" );
	String p_language_id		= (String) session.getValue( "LOCALE" );
	String p_module_id=checkForNull(request.getParameter("p_module_id"));
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String encounter_id=checkForNull(request.getParameter("encounter_id"));
	//String location_desc=checkForNull(request.getParameter("location_desc"));
	String White=request.getParameter("White")==null?"N":request.getParameter("White");
	String Blue=request.getParameter("Blue")==null?"N":request.getParameter("Blue");
	String Red=request.getParameter("Red")==null?"N":request.getParameter("Red");
	String noofcopies=checkForNull(request.getParameter("copies"));
	//String req_yn=checkForNull(request.getParameter("req_yn"));	
	String result="";
	Connection con = null;
	ResultSet rSet=null;
	CallableStatement cs  = null;
	PreparedStatement pstmt=null;
	String message1 ="";
	String message2 ="";
	String message3 ="";
	String care_locn_type="";
	String care_locn_code="";
	/*Changes for 37658 - Begin*/
	String rep_server_key1="";
	String rep_server_key2="";
	String rep_server_key3="";
	/*Changes for 37658 - End*/

            _bw.write(_wl_block1Bytes, _wl_block1);

try{
OnlineReport report1=null;
OnlineReport report2=null;
OnlineReport report3=null;
OnlineReports onlinereports=new OnlineReports();
con = ConnectionManager.getConnection(request);
Boolean flag=true;
String pr_encounter_SQL="select facility_id,assign_care_locn_type,assign_care_locn_code from pr_encounter where facility_id=? and encounter_id=?";
	pstmt=con.prepareStatement(pr_encounter_SQL);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,encounter_id);
	rSet=pstmt.executeQuery();
	if(rSet!=null && rSet.next()){
		p_facility_id=rSet.getString("facility_id");
		care_locn_type=rSet.getString("assign_care_locn_type");
		care_locn_code=rSet.getString("assign_care_locn_code");
	}
if(White.equals("Y")){
	/*report=new OnlineReport(p_facility_id,p_module_id,"IPBWBLBW","N","CICU");
	report.addParameter("p_facility_id",p_facility_id);
	report.addParameter("p_module_id",p_module_id);
	report.addParameter("p_language_id",p_language_id);
	report.addParameter("p_report_id","IPBWBLBW");
	report.addParameter("copies",noofcopies);
	report.addParameter("p_patient_id",patient_id);
	report.addParameter("p_encounter_id",encounter_id);
	onlinereports.add(report);*/
	cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;//changes for 37658
	cs.setString( 1,    "IP" ) ;
	cs.setString( 2,    "IPBWBLBW" ) ;
	cs.setString( 3,    care_locn_type ) ;
	cs.setString( 4,    care_locn_code ) ;
	cs.setString( 5,    p_facility_id ) ;
	cs.setString( 6,    noofcopies ) ;
	cs.setString( 7,    "P" ) ;
	cs.registerOutParameter( 8,  Types.VARCHAR ) ;
	cs.registerOutParameter( 9,  Types.VARCHAR ) ;
	cs.registerOutParameter( 10, Types.VARCHAR ) ;
	cs.registerOutParameter( 11, Types.VARCHAR ) ;
	cs.registerOutParameter( 12, Types.VARCHAR ) ;
	cs.registerOutParameter( 13, Types.VARCHAR ) ;
	cs.registerOutParameter( 14, Types.VARCHAR ) ;
	cs.registerOutParameter( 15, Types.VARCHAR ) ;
	cs.registerOutParameter( 16, Types.VARCHAR ) ;
	cs.registerOutParameter( 17, Types.VARCHAR ) ;
	cs.execute() ;
	message1=cs.getString( 15 ) ;
	rep_server_key1=cs.getString( 17 ) ;//changes for 37658
	if(message1==null){
		report1 = new OnlineReport(p_facility_id,"IP","IPBWBLBW",care_locn_type,care_locn_code);
		report1.addParameter("p_facility_id",p_facility_id);
		report1.addParameter("p_report_id","IPBWBLBW");
		report1.addParameter("p_module_id",p_module_id);
		report1.addParameter("copies",noofcopies);
		report1.addParameter("p_language_id",p_language_id);
		report1.addParameter("p_encounter_id",encounter_id);
		report1.addParameter("p_facility_id",p_facility_id);
		report1.addParameter("p_patient_id",patient_id);
		onlinereports.add(report1);
	}else if(!message1.equals("")){

		

	}
}

if(Blue.equals("Y")){
	System.err.println("Calling report_routing in IPPrintPatientWristbandReport.jsp in line 113");
	cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;//changes for 37658
	cs.setString( 1,    "IP" ) ;
	cs.setString( 2,    "IPBWBLBB" ) ;
	cs.setString( 3,    care_locn_type ) ;
	cs.setString( 4,    care_locn_code ) ;
	cs.setString( 5,    p_facility_id ) ;
	cs.setString( 6,    noofcopies ) ;
	cs.setString( 7,    "P" ) ;
	cs.registerOutParameter( 8,  Types.VARCHAR ) ;
	cs.registerOutParameter( 9,  Types.VARCHAR ) ;
	cs.registerOutParameter( 10, Types.VARCHAR ) ;
	cs.registerOutParameter( 11, Types.VARCHAR ) ;
	cs.registerOutParameter( 12, Types.VARCHAR ) ;
	cs.registerOutParameter( 13, Types.VARCHAR ) ;
	cs.registerOutParameter( 14, Types.VARCHAR ) ;
	cs.registerOutParameter( 15, Types.VARCHAR ) ;
	cs.registerOutParameter( 16, Types.VARCHAR ) ;
	cs.registerOutParameter( 17, Types.VARCHAR ) ;
	cs.execute() ;
	message2=cs.getString( 15 ) ;
	rep_server_key2=cs.getString( 17 ) ;//changes for 37658
	if(message2==null){
		report2 = new OnlineReport(p_facility_id,"IP","IPBWBLBB",care_locn_type,care_locn_code);
		report2.addParameter("p_facility_id",p_facility_id);
		report2.addParameter("p_report_id","IPBWBLBB");
		report2.addParameter("p_module_id",p_module_id);
		report2.addParameter("copies",noofcopies);
		report2.addParameter("p_language_id",p_language_id);
		report2.addParameter("p_encounter_id",encounter_id);
		report2.addParameter("p_facility_id",p_facility_id);
		report2.addParameter("p_patient_id",patient_id);
		onlinereports.add(report2);
	}else if(!message2.equals("")){

		

	}
}
if(Red.equals("Y")){
	cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;//changes for 37658
	cs.setString( 1,    "IP" ) ;
	cs.setString( 2,    "IPBWBLBR" ) ;
	cs.setString( 3,    care_locn_type) ;
	cs.setString( 4,    care_locn_code ) ;
	cs.setString( 5,    p_facility_id ) ;
	cs.setString( 6,    noofcopies ) ;
	cs.setString( 7,    "P" ) ;
	cs.registerOutParameter( 8,  Types.VARCHAR ) ;
	cs.registerOutParameter( 9,  Types.VARCHAR ) ;
	cs.registerOutParameter( 10, Types.VARCHAR ) ;
	cs.registerOutParameter( 11, Types.VARCHAR ) ;
	cs.registerOutParameter( 12, Types.VARCHAR ) ;
	cs.registerOutParameter( 13, Types.VARCHAR ) ;
	cs.registerOutParameter( 14, Types.VARCHAR ) ;
	cs.registerOutParameter( 15, Types.VARCHAR ) ;
	cs.registerOutParameter( 16, Types.VARCHAR ) ;
	cs.registerOutParameter( 17, Types.VARCHAR ) ;
	cs.execute() ;
	message3=cs.getString( 15 ) ;
	rep_server_key3=cs.getString( 17 ) ;//changes for 37658
	if(message3==null){
		report3 = new OnlineReport(p_facility_id,"IP","IPBWBLBR",care_locn_type,care_locn_code);
		report3.addParameter("p_facility_id",p_facility_id);
		report3.addParameter("p_report_id","IPBWBLBR");
		report3.addParameter("p_module_id",p_module_id);
		report3.addParameter("copies",noofcopies);
		report3.addParameter("p_language_id",p_language_id);
		report3.addParameter("p_encounter_id",encounter_id);
		report3.addParameter("p_facility_id",p_facility_id);
		report3.addParameter("p_patient_id",patient_id);
		onlinereports.add(report3);
	}else if(!message3.equals("")){

		

	}
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rep_server_key1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rep_server_key2));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rep_server_key3));
            _bw.write(_wl_block11Bytes, _wl_block11);

if(White.equals("Y") && flag){
	if(message1!=null){
		flag=false;
	}
}
if(Blue.equals("Y") && flag){
	if(message2!=null){
		flag=false;
	}
}
if(Red.equals("Y") && flag){
	if(message3!=null){
		flag=false;
	}
}
if(flag){
	result=onlinereports.execute(request,response);
	
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
	
            _bw.write(_wl_block13Bytes, _wl_block13);
}
}catch(Exception e){
	out.println(e);
	e.printStackTrace();
}finally{
	if(rSet!=null)rSet.close();
	if(pstmt!=null)pstmt.close();
	if(cs!=null)cs.close();
	if(con!=null) ConnectionManager.returnConnection(con,request); 
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
