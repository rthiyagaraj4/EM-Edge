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

public final class __xhtranslationexportdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/XHTranslationExportData.jsp", 1709122421240L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <html> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\" >\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\t\t\t\t\t\t\t  \n</head>\n<body BGCOLOR=\"#B2B6D7\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'  >\n<form >\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n\t  </form>\n\t  </body>\n\t  </html>\n\t\t\t\t\t\t\t\t\t\t \n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
String sStyle ="IeStyle.css";
//(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 		
 Connection connection = null;					   
 MessageManager mm=new MessageManager();
 Properties p;
 p = (Properties) session.getValue("jdbc");	
 String msg="";
 CallableStatement ostmt = null;
 String exceptions="";
 String status="";	    
 String module_id=XHDBAdapter.checkNull(request.getParameter("module_id"));	
 String masterName=XHDBAdapter.checkNull(request.getParameter("master_name")); 
 String applicationID=XHDBAdapter.checkNull(request.getParameter("application"));
 String display=XHDBAdapter.checkNull(request.getParameter("display"));
 String searchText=XHDBAdapter.checkNull(request.getParameter("searchtext"));
 String mod_id= XHDBAdapter.checkNull(request.getParameter("mod_id")); 
 String func_id=XHDBAdapter.checkNull(request.getParameter("func_id"));
 String outbound_yn="X";		  
 String searchpk2=XHDBAdapter.checkNull(request.getParameter("searchpk2")); 	 
 String searchpk3=XHDBAdapter.checkNull(request.getParameter("searchpk3"));
 String start_ends_contains=XHDBAdapter.checkNull(request.getParameter("start_ends_contains")); 
 p = (Properties) session.getValue("jdbc");	


    try					  
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection  XHTranslationExportData.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    																	    
     try			 			  
     {																							    
		ostmt = connection.prepareCall("{ CALL xhdevapi.xh_manage_appl_trigger(?,?,?,?) }" ); 
		ostmt.setString(1,module_id);
  		ostmt.setString(2,masterName);
		ostmt.setString(3,applicationID);
		ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
	    ostmt.execute();
		status = ostmt.getString(3);
		 if(status.equals("0"))
		 {
			connection.commit(); 
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			msg= ((String) mesg.get("message"));
			mesg.clear();
		 }
		 else
		 {
			connection.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
			msg = ((String) mesg.get("message"));
			mesg.clear();
		 }					   
														   
			if(ostmt!=null)
				{
					ostmt.close();
					ostmt=null;							  					  
				}		 				    
				RequestDispatcher reqDis =	session.getServletContext().getRequestDispatcher("/eXH/jsp/XHTranslationDisplayResult.jsp?message="+msg+"&module_id="+module_id+"&masterName="+masterName+"&application="+applicationID+"&display="+display+"&searchText="+searchText+"&Searchbymod="+mod_id+"&SearchbyFunct="+func_id+"&start_ends_contains="+start_ends_contains+"&outbound_yn="+outbound_yn+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3);  reqDis.forward(request,response);	 			   
																	 	 	  					   
      }															  				   
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in XHTranslationExportData.jsp sqlexeception :"+exp);
	             
      }
	  finally
	 {
		if(ostmt!=null)
		ostmt.close();
		ConnectionManager.returnConnection(connection);
	 }
			  													    
	  
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
