package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import ecis.utils.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __mdrcertificate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MDRCertificate.jsp", 1709118943001L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<html>\n\t\t\t<body onKeyDown = \'lockKey()\'>\n\t\t\t<form name=\'test\' id=\'test\' method=\'post\' action=\'MDRCertificate.jsp\'>\n\t\t\t<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t\t<script language=\"JavaScript\" src=\"../../eMP/js/ViewPatDetails.js\"></script>\n\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'total\' id=\'total\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'rep_id\' id=\'rep_id\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'reportParamNames\' id=\'reportParamNames\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'reportParamValues\' id=\'reportParamValues\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'dest_locn_type\' id=\'dest_locn_type\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'dest_locn_code\' id=\'dest_locn_code\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\t\n\t\t\t\t<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\t\n\t\t\t\t<input type=\'hidden\' name=\'rep_server_key\' id=\'rep_server_key\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\t<!--changes for 37658-->\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 
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


request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

		String classValue="";
		Properties p						=	 (java.util.Properties) session.getValue( "jdbc" );
		String login_user					=	 p.getProperty( "login_user" ) ;
		String locale						=	 (String)session.getAttribute("LOCALE");
		String sys_date = "";
		String first_time_only = request.getParameter("first_time_only");
		if (first_time_only==null) first_time_only = "N";


		Connection con = ConnectionManager.getConnection(request);
		Statement stmt=null,langStmt=null;
		ResultSet rset=null,langrSet=null;
		String patient_id = request.getParameter("Patient_ID");
		String capture_photo_yn = request.getParameter("capture_photo_yn");
		String rep_id = request.getParameter("rep_id")==null?"":request.getParameter("rep_id");
		if (capture_photo_yn==null) capture_photo_yn = "";
		if (patient_id==null) patient_id = "";

		String sql = request.getParameter("sqlString");
		if (sql==null) sql="";		
		String prefLang=locale;		
		//String p_language_id = request.getParameter("p_language_id");		

		String encounterid = request.getParameter("p_encounter_id");
		if (encounterid==null) encounterid="";
		String p_module_id = request.getParameter("p_module_id");
		if (p_module_id==null) p_module_id= "";
		String enc_facilityId = request.getParameter("p_facility_id");
		if (enc_facilityId==null) enc_facilityId="";
	   String function_id  = request.getParameter("P_function_id");
	   if (function_id==null) function_id="";
		String reportParamNames = request.getParameter("reportParamNames");
		if (reportParamNames==null) reportParamNames = "";

		String reportParamValues = request.getParameter("reportParamValues");
		if (reportParamValues==null) reportParamValues = "";		
		String dest_locn_type = request.getParameter("dest_locn_type");
		if (dest_locn_type==null) dest_locn_type="";
		String dest_locn_code = request.getParameter("dest_locn_code");
		if (dest_locn_code==null) dest_locn_code="";
		String ws_no        = p.getProperty("client_ip_address");
		String report_option    = "P" ;
		String message ="";
		String P_copies="";
		String P_queue_name = "";
		CallableStatement cs  = null;
		CallableStatement cs1 = null;
		String facilityId = (String)session.getValue("facility_id");
		String disableChkbox = "";
		ArrayList arrayList=new ArrayList();
		String langCode="";
		String langDesc="";
		String p_out_status="";
		String p_out_error="";
		String rep_server_key="";//changes for 37658

	if(first_time_only.equals("Y")) {
		//Reports building.		
		try
		{
			stmt =  con.createStatement();
			rset = stmt.executeQuery("select TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') sys_date from dual");
			if(rset.next()){
				sys_date = rset.getString("sys_date");
			}
            if(rset != null)		rset.close();
            if(stmt != null)		stmt.close();

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rset = stmt.executeQuery(sql);	
				langStmt=con.createStatement();
				langrSet=langStmt.executeQuery("select LANGUAGE_ID,SHORT_NAME from sm_language where EFF_STATUS='E'");
				while(langrSet!=null && langrSet.next()){
					langCode=langrSet.getString("LANGUAGE_ID");
					langDesc=langrSet.getString("SHORT_NAME");
					arrayList.add(langCode+"|~"+langDesc);
				}

			if(langrSet != null)		langrSet.close();
            if(langStmt != null)		langStmt.close();

			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


				String myReportID = "",myReportName="", numofCopies="", moduleID="";
				int i =0;								
				if (rset.next())
				{					
					rset.beforeFirst();
					while (rset.next())
					{
						myReportID = rset.getString(1);
						myReportName = rset.getString(2);
						numofCopies = rset.getString(3);
						moduleID = rset.getString(4);					
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
						cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;//changes for 37658
						cs.setString( 1,    moduleID ) ;
						cs.setString( 2,    myReportID ) ;
						cs.setString( 3,    dest_locn_type ) ;
						cs.setString( 4,    dest_locn_code ) ;
						cs.setString( 5,    facilityId ) ;
	 					cs.setString( 6,    numofCopies ) ;
						cs.setString( 7,    report_option ) ;
						cs.registerOutParameter( 8,  Types.VARCHAR ) ;
						cs.registerOutParameter( 9,  Types.VARCHAR ) ;
						cs.registerOutParameter( 10, Types.VARCHAR ) ;
						cs.registerOutParameter( 11, Types.VARCHAR ) ;
						cs.registerOutParameter( 12, Types.VARCHAR ) ;
						cs.registerOutParameter( 13, Types.VARCHAR ) ;
						cs.registerOutParameter( 14, Types.VARCHAR ) ;
						cs.registerOutParameter( 15, Types.VARCHAR ) ;
						cs.registerOutParameter( 16, Types.VARCHAR ) ;
						cs.registerOutParameter( 17, Types.VARCHAR ) ;//changes for 37658
						cs.execute() ;
						
						P_copies		= cs.getString( 10 ) ;
						P_queue_name	= cs.getString( 12 ) ;
	                    message			= cs.getString( 15 ) ;
	                    rep_server_key			= cs.getString( 17 ) ;//changes for 37658

						if (message==null) message="";
						
						if (message.equals(""))
							disableChkbox = " checked ";
						else
							disableChkbox = " disabled ";	
										
						if(cs != null)		cs.close();

						if(message.equals("")) {
							if (myReportID.equals("MRDTHCER") ) 
							{
								cs1 = con.prepareCall( "{ call SM_PRINT_ROUTING_AUDIT_PROC( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }" ) ;				
								cs1.setString( 1,    enc_facilityId ) ;
								cs1.setString( 2,    encounterid ) ;
								cs1.setString( 3,    patient_id ) ;
								cs1.setString( 4,    moduleID ) ;
								cs1.setString( 5,    myReportID ) ;
								cs1.setString( 6,    function_id ) ;
								cs1.setString( 7,    P_copies ) ;
								cs1.setString( 8,    P_queue_name ) ;
								cs1.setString( 9,    login_user ) ;
								cs1.setString( 10,   sys_date ) ;
								cs1.setString( 11,   ws_no ) ;
								cs1.setString( 12,   facilityId ) ;
								cs1.registerOutParameter( 13, Types.VARCHAR ) ;
								cs1.registerOutParameter( 14, Types.VARCHAR ) ;
								cs1.execute() ;

								p_out_status		= cs1.getString( 13 ) ;
								p_out_error			= cs1.getString( 14 ) ;						

								if (p_out_status==null) p_out_status="";
								if (p_out_error==null) p_out_error="";

								if(cs1 != null)		cs1.close();

								if (p_out_status.equals("E"))
								{
									out.println("<script>alert('"+p_out_error+"');</script>");
								}
							}
						}
						else
						{
							out.println("<script>alert('"+message+"');parent.window.close();</script>");
						}
			
					}
				
						if(rset != null)	rset.close();
						//if(cs != null)		cs.close();
                        con.commit();
				}
				else
				{
					//out.println("<script>alert(getMessage('REPORT_RULE_NOT_DEFINED','Common'));parent.window.close();</script>");
					out.println("<script>parent.window.close();</script>");/*Commented and Added by Rameswar on 20-Oct-15  for HSA-CRF-0319*/
				}
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(i));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rep_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reportParamNames));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(reportParamValues));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dest_locn_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dest_locn_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rep_server_key));
            _bw.write(_wl_block16Bytes, _wl_block16);

				out.println("<script>document.forms[0].submit(); alert(getMessage('REPORT_SUBMIT_SERVER','Common'));parent.frames[5].location.href='../../eCommon/jsp/error.jsp' </script>");	
		}
		catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace();}
		finally {
     		  if(cs != null)		cs.close();
			  if (stmt != null)    stmt.close();
			  if(con!=null) ConnectionManager.returnConnection(con,request);  
		}
	}
	else {		
		//Reports Execution
		try
		{
			java.util.StringTokenizer paramNameTokens = new java.util.StringTokenizer(reportParamNames,",");
			java.util.StringTokenizer paramValueTokens = new java.util.StringTokenizer(reportParamValues,",");

			String repparamNames[] = new String[paramNameTokens.countTokens()];
			String repparamValues[] = new String[paramNameTokens.countTokens()];
			int i = 0;
			while (paramNameTokens.hasMoreTokens())
			{
				repparamNames[i] = paramNameTokens.nextToken();
				if (paramValueTokens.hasMoreTokens())
					repparamValues[i] = paramValueTokens.nextToken();
				else
					repparamValues[i] = "";
				i++;
			}
			String reportid = "MRDTHCER", moduleid="MR", nreqd="Y", ncopy="1";
			int totalCnt = 1;			
			if (totalCnt>0)
			{
				OnlineReports onlineReports = new OnlineReports();				
				for(int j=0;j<totalCnt;j++)
				{
					if (nreqd.equals("Y"))
					{
						OnlineReport report = new OnlineReport(facilityId,moduleid,reportid,dest_locn_type,dest_locn_code);
						report.addParameter( "p_facility_id", facilityId ) ;
						report.addParameter( "p_report_id",     reportid ) ;
						report.addParameter( "p_module_id",     moduleid ) ;
						report.addParameter( "copies",  ncopy ) ;
						report.addParameter( "p_language_id",  prefLang ) ;
						for (int x=0;x<repparamNames.length;x++)
						{						
							report.addParameter(repparamNames[x], repparamValues[x]);
						}
						onlineReports.add( report ) ;		                
					}
				}
				//String ReportOutput = 
					onlineReports.execute( request, response ) ;
			}
		}catch(Exception e){/* out.println(e); */e.printStackTrace();}
	}


            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
