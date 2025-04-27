package jsp_servlet._exh._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __interfacesantdardsctrlrecordquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/InterfaceSantdardsCtrlrecordquery.jsp", 1709122347069L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\" >\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body BGCOLOR=\"#B2B6D7\"  CLASS=\"MESSAGE\" >\n<form > \n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</form>\n\t  </body>\n\t  </html>\n\n";
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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	String status="";
		Connection connection = null;
    	CallableStatement ostmt = null;
	    String message_text2 = "";
	   	MessageManager mm=new MessageManager();
	    String exceptions="";
	  
		
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		 String locale  = p.getProperty("LOCALE");
		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
		String p_mode=request.getParameter("act_mode");	
		String segment_type_id=XHDBAdapter.checkNull(request.getParameter("segment_type_id"));
		String standard_desc=XHDBAdapter.checkNull(request.getParameter("element_seq"));

		if(standard_desc.equals("")||standard_desc.equals(null))
		{
standard_desc="1";
		}
		

		String ele_val_id=XHDBAdapter.checkNull(request.getParameter("ele_val_id"));
		String standard_code1=XHDBAdapter.checkNull(request.getParameter("standard_code"));
		String Control_id=XHDBAdapter.checkNull(request.getParameter("element_controlID"));
//System.out.println("standard_code1"+standard_code1);
		//System.out.println("Control_id"+Control_id);
		String msg_start=request.getParameter("def_val_id");	
    	ArrayList array_audit=null;
		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);		
try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of InterfaceStandardAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

	 ostmt = connection.prepareCall("{ call xg_prc.xh_standard_control_seg(?,?,?,?,?,?,?,?,?,?,?) }" ); 
  
		  String  usr_added_by_id=(String)array_audit.get(0);
		  String  usr_added_at_ws_no=(String)array_audit.get(1);
		 
		 
		 ostmt.setString(1,p_mode);

	   //System.out.println("Call EJB p_mode : "+p_mode);

         ostmt.setString(2,segment_type_id);
		 	   //System.out.println("Call standard_code : "+segment_type_id);
		 ostmt.setString(3,ele_val_id);
	   //System.out.println("Call standard_type : "+ele_val_id);
         ostmt.setInt(4,Integer.parseInt(standard_desc));
	   ////System.out.println("Call standard_desc : "+standard_desc);
         ostmt.setString(5,msg_start);
		 	   //System.out.println("Call msg_start : "+msg_start);
         ostmt.setString(6,usr_added_by_id);
         ostmt.setString(7,usr_added_at_ws_no);
        ostmt.setString(8,standard_code1);
		ostmt.setString(9,Control_id);
        ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	    ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);

       ostmt.execute();
	   String status2= ostmt.getString(10);
			 //System.out.println("Call EJB status2 : "+status2);
	     message_text2 = ostmt.getString(11);

	     ostmt.close();
	    
//	     if(message_text2.equals("0"))
	     if(status2.equals("0"))
		{
		connection.commit();
final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
				out.println(status);
       // RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+status);
        //reqDis.forward(request,response);	

		}
		else if(status2.equals("2"))
		{
		
final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "common") ;
	  		    status = ((String) mesg.get("message"));
				out.println(status);
       // RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+status);
        //reqDis.forward(request,response);	

		}
	 else
		{
		 connection.rollback();


		 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	  		    status = ((String) mesg.get("message"));
				out.println(status);
		  //RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+status);
      //  reqDis.forward(request,response);	
		}
	 XHDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of InterfaceSantdardsCtrlrecordquery :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in  InterfaceSantdardsCtrlrecordquery.jsp :"+ex.toString());
		   ex.printStackTrace(System.err); }

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
