package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __validatereports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ValidateReports.jsp", 1742366801945L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<HTML>  \n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\"JavaScript\">\n\tfunction SubmitReport() \n\t\t{\n\t\tvar errmessage = validate_report_server_form.message.value ;\n\t\tvar params\t\t= validate_report_server_form.params.value ;\n\t\tif (errmessage==\'\')\n\t\t{\n\t\t\tvar self_submit \t= validate_report_server_form.self_submit.value ;\n\t\t\tvar report_option\t= parent.parent.report_options.report_options_form.destype.value ;\n\t\t\tvar url \t\t= \"\" ;\n\t\t\tvar regExp = /&/g ;\n\t\t\tparams = params.replace( regExp, \"+\" ) ;\n\n\t\t\tif ( report_option  == \"V\" ) {\n\t\t\t\tvalidate_report_server_form.destype.value\t= \"cache\" ;\n\t\t\t\tvalidate_report_server_form.desformat.value\t= \"pdf\" ;\n\n\t\t\t\turl = validate_report_server_form.reportserver.value \t\t\t\t+\n\t\t\t\t\t\"?server=\"\t\t+ validate_report_server_form.server.value\t\t+\n\t\t\t\t\t\"+report=\" \t\t+ validate_report_server_form.report.value \t\t+\n\t\t\t\t\t\"+desformat=\"\t+ validate_report_server_form.desformat.value\t+\n\t\t\t\t\t\"+destype=\"\t\t+ validate_report_server_form.destype.value\t\t+\n\t\t\t\t\t\"+userid=\" \t\t+ validate_report_server_form.userid.value\t\t+\n\t\t\t\t\t\"+recursive_load=no\" \t\t+ \n\t\t\t\t\t\"+\" + params.toUpperCase() ;\n\t\t\t}\n\n\t\t\tif ( report_option == \"P\" ) {\n\t// By sbchand start on 20th June, 2001\n\t\t\t\tvar myRegExp = /\\\\/g ;\n\t\t\t\tvar printerName = validate_report_server_form.queue_name.value ;\n\t\t\t\tprinterName = printerName.replace( myRegExp, \"\\\\\\\\\" ) ;\n\t\t\t\tvalidate_report_server_form.queue_name.value = printerName ;\n\t// By sbchand end on 20th June, 2001\n\n\t\t\t\tvalidate_report_server_form.destype.value\t\t= \"printer\" ;\n\t\t\t\tvalidate_report_server_form.desname.value \t\t= validate_report_server_form.queue_name.value ;\n\n\t\t\t\turl = validate_report_server_form.reportserver.value \t\t\t\t+\n\t\t\t\t\t\"?report=\" \t\t+ validate_report_server_form.report.value \t\t+\n\t\t\t\t\t\"+userid=\" \t\t+ validate_report_server_form.userid.value\t\t+\n\t\t\t\t\t\"+server=\"\t\t+ validate_report_server_form.server.value\t\t+\n\t\t\t\t\t\"+destype=\"\t\t+ validate_report_server_form.destype.value\t\t+\n\t\t\t\t\t\"+desname=\"\t\t+ validate_report_server_form.desname.value\t\t+\n\t\t\t\t\t\"+recursive_load=no\" \t\t+ \n\t\t\t\t\t\"+background=yes\"\t+\n\t\t\t\t\t\"+\" + params.toUpperCase() ;\n\t\t\t}\n\n\t\t\tif ( report_option == \"F\" ) {\n\t\t\t\tvar desformat = parent.report_options.report_options_form.file_format.value ;\n\t\t\t\tvar extension = \"\" ;\n\n\t\t\t\tif ( desformat == \"pdf\" )\textension = \".pdf\" ;\n\t\t\t\tif ( desformat == \"htmlcss\" ) extension = \".html\" ;\n\t\t\t\tif ( desformat == \"rtf\" )\textension = \".rtf\" ;\n\t\t\t\tif ( desformat == \"xml\" )\textension = \".xml\" ;\n\n\t\t\t\tvalidate_report_server_form.destype.value\t= \t\"file\" ;\n\t\t\t\tvalidate_report_server_form.desformat.value\t= \tparent.report_options.report_options_form.file_format.value ;\n\t\t\t\tvalidate_report_server_form.desname.value\t= \tparent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;\n\n\t\t\t\turl = validate_report_server_form.reportserver.value \t\t\t\t+\n\t\t\t\t\t\"?report=\" \t\t+ validate_report_server_form.report.value \t\t+\n\t\t\t\t\t\"+userid=\" \t\t+ validate_report_server_form.userid.value\t\t+\n\t\t\t\t\t\"+server=\"\t\t+ validate_report_server_form.server.value\t\t+\n\t\t\t\t\t\"+desformat=\"\t+ validate_report_server_form.desformat.value\t+\n\t\t\t\t\t\"+destype=\"\t\t+ validate_report_server_form.destype.value\t\t+\n\t\t\t\t\t\"+desname=\"\t\t+ validate_report_server_form.desname.value\t\t+\n\t\t\t\t\t\"+background=yes\"\t+\n\t\t\t\t\t\"+recursive_load=no\" \t\t+ \t\t\t\t\n\t\t\t\t\t\"+\" + params.toUpperCase() ;\n\t\t\t}\n\t\t\tif ( report_option == \"F\" || report_option == \"P\" )\n\t\t\turl = url + \"&closeWindow=true\" ;\n\t\t\tparent.returnValue = url ;\n\t\t\t}\n\t\telse\n\t\t\t{\n\t\t\talert(getMessage(\"PRINT_ROUTING_NOT_DEFINED\"));\n\t\t\t}\t\t\n\t\tparent.close() ;\n\t\treturn true ;\n\t}\n\t/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/\n\tfunction excelreport()\n\t{\n\t\tvar errmessage = validate_report_server_form.message.value ;\n\t\tvar params\t\t= validate_report_server_form.params.value ;\n\t\tif (errmessage==\'\')\n\t\t{\n\t\t\t\tdocument.validate_report_server_form.action=\"../../servlet/eSM.exportExcelServlet?\"+params;\n\t\t\t\tdocument.validate_report_server_form.submit();\n\t\t        setTimeout(\'window.close();\',3000);\t\n\t\t}\n\t\treturn true ;\n\t}\n\t/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END*/\n </script>\n <body>\n <form name=\"validate_report_server_form\" id=\"validate_report_server_form\" method=\"Post\">\n\t\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t<input type=\"hidden\"\tname=\"reportserver\" id=\"reportserver\"\tvalue=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n\t\t<input type=\"hidden\" \tname=\"report\" id=\"report\"\t\tvalue=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n\t\t<input type=\"hidden\" \tname=\"userid\" id=\"userid\"\t\tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t\t<input type=\"hidden\"\tname=\"server\" id=\"server\"\t\tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t\t<input type=\"hidden\"\tname=\"params\" id=\"params\"\t\tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t\t<input type=\"hidden\"\tname=\"queue_name\" id=\"queue_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t\t<input type=\"hidden\"\tname=\"message\" id=\"message\"\t\tvalue=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t<input type=\"hidden\"\tname=\"desformat\" id=\"desformat\"\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"destype\" id=\"destype\"\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"desname\" id=\"desname\"\t\tvalue=\"\">\n\t\t<input type=\"hidden\"\tname=\"self_submit\" id=\"self_submit\"\tvalue=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t<input type=\"hidden\"\tname=\"p_module_id\" id=\"p_module_id\"\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<input type=\"hidden\"\tname=\"p_report_id\" id=\"p_report_id\"\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t<input type=\"hidden\"\tname=\"dest_locn_type\" id=\"dest_locn_type\"\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t<input type=\"hidden\"\tname=\"dest_locn_code\" id=\"dest_locn_code\"\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<script>\n\t\t\t\tSubmitReport();\t\n\t\t\t\t</script>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<script>\n\t\t\t\texcelreport();\t\n\t\t\t\t</script>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\texcelreport();\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</form>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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

		request.setCharacterEncoding("UTF-8");	
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String userid		= (String) session.getValue( "report_connect_string" ) ;
		String params=request.getQueryString();
		String p_frm_date=request.getParameter("p_fm_Date");
		//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
		String report_id=request.getParameter("p_report_id");
		String p_report_type = "";
				
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
		String p_facility_id = "";
		String p_fm_Date = "";
		String p_to_Date = "";
		String report_type = "";
		String p_language_id = "";
		String appl_type = "";
		String p_from_date_cn = "";
		String p_to_date_cn = "";
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END*/
		String p_year	= "";
		String p_year_cn	= "";
		
		if (report_id.equals("MRIPCSMB"))
		{
			p_report_type=request.getParameter("p_type");
		}
		else if (report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS"))
		{
			p_report_type=request.getParameter("report_type");
		}
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
		//MRNIAREPY Added By Dharma on 29th Jan 2021 against ML-MMOH-CRF-1593
		else if (report_id.equals("MRNIAREP") || report_id.equals("MRNIAREPY"))
		{
			 p_facility_id		= checkForNull(request.getParameter( "p_facility_id" )) ;
			 p_fm_Date			= checkForNull(request.getParameter( "p_fm_Date" )) ;
			 p_to_Date			= checkForNull(request.getParameter( "p_to_Date" )) ;
			 p_from_date_cn		= checkForNull(request.getParameter( "p_from_date_cn" )) ;
			 p_to_date_cn		= checkForNull(request.getParameter( "p_to_date_cn" )) ;
			
			 report_type		= checkForNull(request.getParameter( "report_type" )) ;
			 p_language_id		= request.getParameter( "p_language_id" )==null?"en": request.getParameter( "p_language_id" );
			 appl_type			= checkForNull(request.getParameter( "appl_type" )) ;
			 p_year			= checkForNull(request.getParameter( "p_year" )) ;
			 p_year_cn			= checkForNull(request.getParameter( "p_year_cn" )) ;
		}
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END*/
		String reportServer=request.getParameter("reportserver");
		String report=request.getParameter("report");
		String server=request.getParameter("server");
		String queue_name=request.getParameter("queue_name");
		String message=request.getParameter("message");
		String self_submit=request.getParameter("self_submit");
		String module_id=request.getParameter("p_module_id");
		String dest_locn_type=request.getParameter("dest_locn_type");
		String dest_locn_code=request.getParameter("dest_locn_code");
		if ( reportServer		== null ) reportServer	= "" ;
		if ( userid			== null ) userid		= "" ;
		if ( params 		== null ) params 		= "" ;
		if ( self_submit		== null ) self_submit	= "" ;
		if ( module_id		== null ) module_id 	= "" ;
		if ( report_id		== null ) report_id 	= "" ;
		if ( dest_locn_type 	== null ) dest_locn_type= "" ;
		if ( dest_locn_code	== null ) dest_locn_code= "" ;
		
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf( reportServer ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( report ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( userid ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( server ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( queue_name ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( message ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( self_submit ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( module_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( report_id ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( dest_locn_type ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( dest_locn_code ));
            _bw.write(_wl_block14Bytes, _wl_block14);

		Connection con			= ConnectionManager.getConnection(request);
		CallableStatement diag_cs = null;
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
		CallableStatement callStmt1 = null;
		CallableStatement callStmt2 = null;
		PreparedStatement pstmt1		= null;
		PreparedStatement pstmt2		= null;
		String psql="";
		String psql1="";
		String dsql="";
		String dsql1="";
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
		try
			{
			
			//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
			if (report_id.equals("MRIPCSMB"))
			{
				diag_cs = con.prepareCall("{call MR_IP_MORB_MORT_SUMMARY_PD206(?,?)}");
			}
			else if (report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS"))
			{
				diag_cs = con.prepareCall("{call MR_OP_MORB_MORT_SUMMARY_PL206(?,?)}");
			}
			
			if(report_id.equals("MRIPCSMB")||report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS"))
			{
			diag_cs.setString( 1 ,p_report_type );
			diag_cs.setString( 2 ,p_frm_date);
		
			boolean return_value=diag_cs.execute();
			if(return_value==false)
				{
				
            _bw.write(_wl_block15Bytes, _wl_block15);

				}
			}
			/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
			else if(report_id.equals("MRNIAREP"))
			{
			dsql="DELETE FROM nia_report_temp_table";
			dsql1="DELETE FROM nia_rep_pre_cmt_temp_tbl";
				
			pstmt1 = con.prepareStatement(dsql);
			pstmt2 = con.prepareStatement(dsql1);
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
				
			con.commit();
				
			psql="{call MR_DATA_INSERT_FOR_PRE_NIA_REP(?,?,?,?,?,?)}";
			psql1="{call MR_DATA_INSERT_FOR_NIA_REP(?,?,?,?,?,?)}";


				
			callStmt1 = con.prepareCall( psql ) ;
			callStmt1.setString( 1,	p_facility_id  ) ;
			callStmt1.setString( 2,	p_from_date_cn ) ;
			callStmt1.setString( 3,	p_to_date_cn  ) ;
			callStmt1.setString( 4,  report_type ) ;
			callStmt1.setString( 5,  p_language_id ) ;
			callStmt1.setString( 6,	appl_type ) ;
			
			boolean value1=callStmt1.execute() ;
			
			callStmt2 = con.prepareCall( psql1 ) ;
			callStmt2.setString( 1,	p_facility_id  ) ;
			callStmt2.setString( 2,	p_fm_Date ) ;
			callStmt2.setString( 3,	p_to_Date  ) ;
			callStmt2.setString( 4,  report_type ) ;
			callStmt2.setString( 5,  p_language_id ) ;
			callStmt2.setString( 6,	appl_type ) ;
			
			boolean value2=callStmt2.execute() ;
			
			if(value1==false && value2==false)
			{
				
            _bw.write(_wl_block16Bytes, _wl_block16);

	
			}
		
			}/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END*/
			else if(report_id.equals("MRNIAREPY")){
			psql="{call mr_data_insert_for_nia_yer(?,?,?,?,?,?)}";
			psql1="{call mr_data_insert_for_pre_nia_yer(?,?,?,?,?,?)}";


				
			callStmt1 = con.prepareCall( psql ) ;
			callStmt1.setString( 1,	p_facility_id  ) ;
			callStmt1.setString( 2,	p_year ) ;
			callStmt1.setString( 3,	p_year_cn  ) ;
			callStmt1.setString( 4,  report_type ) ;
			callStmt1.setString( 5,  p_language_id ) ;
			callStmt1.setString( 6,	appl_type ) ;
			
			boolean value1=callStmt1.execute() ;
			
			callStmt2 = con.prepareCall( psql1 ) ;
			callStmt2.setString( 1,	p_facility_id  ) ;
			callStmt2.setString( 2,	p_year ) ;
			callStmt2.setString( 3,	p_year_cn  ) ;
			callStmt2.setString( 4,  report_type ) ;
			callStmt2.setString( 5,  p_language_id ) ;
			callStmt2.setString( 6,	appl_type ) ;
			
			boolean value2=callStmt2.execute() ;
			
			if(value1==false && value2==false)
			{
				
            _bw.write(_wl_block16Bytes, _wl_block16);

	
			}

			}
			else if(report_id.equals("AETOTVSR")){
				int j=1;
				psql="{call TOTAL_AE_VISIT_REG_REP_PRC(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				callStmt1 = con.prepareCall( psql ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("p_language_id")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("p_facility_id")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_PRIORITY_ZONE")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("report_type")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("p_fm_Date")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("p_to_Date")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_FM_TREAT_CODE")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_TO_TREAT_CODE")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_TERM_SET_ID")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_Free_Text")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("start_ends_contains")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_FM_TERM_CODE")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_TO_TERM_CODE")) ) ;

				boolean value=callStmt1.execute() ;
			
				if(value==false) {
            _bw.write(_wl_block17Bytes, _wl_block17);
}

			}
			
		
			}
		catch(SQLException e)
			{
			e.printStackTrace();
			System.out.println("Exception occurred while calling the MR_IP_MORB_MORT_SUMMARY_PD206 Procedure "+e);
			}
		finally	
			{
			try
				{
				if(diag_cs!=null)
				diag_cs.close();
				if(callStmt1!=null)
				callStmt1.close();
				if(callStmt2!=null)
				callStmt2.close();
				}
			catch(Exception e)	
				{}
			try
				{
				ConnectionManager.returnConnection(con,request);
				}
			catch(Exception e)	
				{
				}
			}				
		
		
            _bw.write(_wl_block18Bytes, _wl_block18);

if ( self_submit.equals( "yes" ) )
		out.println( "<script language='JavaScript'>SubmitReport();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>" ) ;

            _bw.write(_wl_block19Bytes, _wl_block19);
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
