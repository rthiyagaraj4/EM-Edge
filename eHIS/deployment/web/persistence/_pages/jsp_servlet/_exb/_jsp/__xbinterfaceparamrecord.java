package jsp_servlet._exb._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.lang.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;
import java.sql.Clob;;

public final class __xbinterfaceparamrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exb/jsp/XBInterfaceparamRecord.jsp", 1709122251790L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n <html> \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\" >\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body BGCOLOR=\"#B2B6D7\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' CLASS=\"MESSAGE\" >\n<form > \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<input type=hidden name=filter_code value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\n<script>\n</script>\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block4Bytes, _wl_block4);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 

MessageManager mm=new MessageManager();
Properties p;
p = (Properties) session.getValue("jdbc");	
String locale  = p.getProperty("LOCALE");
String msg="";
// Statement s=null;
 // ResultSet r = null;
Connection connection = null;
CallableStatement ostmt = null;
String message_text = "",status="";
String Filter_group="";

	p = (Properties) session.getValue("jdbc");	
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");

    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method  of XBInterfaceparamRecord.jsp.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
        // exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {

        String  mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
        String enable_interface=XHDBAdapter.checkNull(request.getParameter("enable_interface")).equals("")?"N":request.getParameter("enable_interface");
		String profile_id=request.getParameter("Profile_id");
		String dbf_table_name=request.getParameter("dbf_table_name"); 
		String dbf_source_directory=request.getParameter("dbf_source_directory"); 
		String dbf_dest_directory=request.getParameter("dbf_dest_directory");
		String log_directory=request.getParameter("log_directory");
        String dbf_table_create_stmt=request.getParameter("dbf_table_create_stmt"); 
		String dbf_column_hdng=request.getParameter("dbf_column_hdng");
        String dbf_trace_yn=XHDBAdapter.checkNull(request.getParameter("dbf_trace_yn")).equals("")?"N":request.getParameter("dbf_trace_yn");
		String exe_name=request.getParameter("exe_name");
		String drg_query=request.getParameter("drg_query");
		String dbf_column_dt=request.getParameter("dbf_column_dt");
        String sdx_diag_cnt=request.getParameter("sdx_diag_cnt"); 
		String proc_diag_cnt=request.getParameter("proc_diag_cnt");
		String user_def_str=request.getParameter("user_def_str");
        String cc_trace_yn=XHDBAdapter.checkNull(request.getParameter("cc_trace_yn")).equals("")?"N":request.getParameter("cc_trace_yn");
 	    ArrayList arrAudit = ArrayAuditInfo.getArrayAuditInfo(session);
  	    String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1); 
		String usr_added_by_date=(String)arrAudit.get(2);
		//String drgreplace=drg_query.replaceAll("'","''");			
		/*System.out.println("Xg_prc.XB_PARAM('"+mode+"'"+","+"'"+profile_id+"'"+","+"'"+enable_interface+"'"+","+"'"+dbf_table_name+"'"+","+"'"+dbf_source_directory+"'"+","+"'"+dbf_dest_directory+"'"+","+"'"+exe_name+"'"+","+"'"+dbf_table_create_stmt+"'"+","+"'"+dbf_column_hdng+"'"+","+"'"+dbf_column_dt+"'"+","+"'"+dbf_trace_yn+"'"+","+"'"+drgreplace+"'"+","+""+","+""+","+""+","+""+","+""+","+"'"+usr_added_by_id+"'"+","+"'"+usr_added_by_date+"'"+","+"'"+usr_added_by_id+"'"+","+"'"+usr_added_by_date+"'"+","+"'"+usr_added_at_ws_no+"'"+","+"'"+usr_added_at_ws_no+"'"+","+"'"+cc_trace_yn+"'"+","+"'"+log_directory+"')");*/

        ostmt = connection.prepareCall("{ CALL Xg_prc.XB_PARAM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
  
		ostmt.setString(1,mode);
		ostmt.setString(2,profile_id);
		ostmt.setString(3,enable_interface);
		ostmt.setString(4,dbf_table_name);
		ostmt.setString(5,dbf_source_directory);
		ostmt.setString(6,dbf_dest_directory);
		ostmt.setString(7,exe_name); 
		ostmt.setString(8,dbf_table_create_stmt);  
		ostmt.setString(9,dbf_column_hdng);
		ostmt.setString(10,dbf_column_dt);
		ostmt.setString(11,dbf_trace_yn);
		java.io.Reader reader = new java.io.StringReader(drg_query);
		ostmt.setCharacterStream(12,reader,drg_query.length());
		ostmt.setString(13,null);
		ostmt.setString(14,null);
		ostmt.setString(15,null);
		ostmt.setString(16,null);
		ostmt.setString(17,usr_added_by_id); 
		ostmt.setString(18,usr_added_by_date);
		ostmt.setString(19,usr_added_by_id);
		ostmt.setString(20,usr_added_by_date);
		ostmt.setString(21,usr_added_at_ws_no); 
		ostmt.setString(22,usr_added_at_ws_no); 
		ostmt.setString(23,cc_trace_yn);
		ostmt.setString(24,log_directory);
		ostmt.setString(25,sdx_diag_cnt);
		ostmt.setString(26,proc_diag_cnt);
		ostmt.setString(27,user_def_str);
		ostmt.registerOutParameter(28,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(29,java.sql.Types.VARCHAR);
		ostmt.execute();
		status = ostmt.getString(28); 
		message_text = ostmt.getString(29);		  	  
				 
        out.println("<html><head></head><body bgcolor=#B2B6D7 >"); 
//        System.out.println("status 126:"+status);
		
        out.println("</body></html>");     
	 
		if (status.equals("0"))  
        {
          connection.commit(); 
          final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001","XH") ;
          msg= ((String) mesg.get("message"));
		  out.println(msg);
          
		
		}
		else if (status.equals("2"))  
        {
          connection.commit(); 
		  //final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 // status = ((String) mesg.get("message")); 
          final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024","XH") ;
			    status = ((String) mesg.get("message"));
		  out.println(status);        
		
		}
		else
        {      
			connection.rollback();
			// chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000","XH") ;
		    msg = ((String) mesg.get("message"));
			out.println(msg);	   	   
        }	
      }
      catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in Xg_prc.XB_PARAM of  XBInterfaceparamRecord.jsp:"+e.toString());
	      e.printStackTrace(System.err);
	  }

	  finally
	  {
		try{
			if(ostmt!=null)
			{
			  ostmt.close();
			 }
			ConnectionManager.returnConnection(connection);
		}catch(Exception e)
		{
			System.out.println("Error in closing dbconnection in XBInterfaceparamRecord.jsp.jsp :"+e.toString());
			e.printStackTrace(System.err);
		}
	  }
	  
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Filter_group));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
