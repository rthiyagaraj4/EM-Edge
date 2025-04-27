package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eXH.*;
import eXH.XHDBAdapter;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import java.util.StringTokenizer;

public final class __filterlayercheckquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilterLayerCheckQuery.jsp", 1709122339804L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head>\n\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"JavaScript\" src=\'../../eCommon/js/common.js\'> </Script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"JavaScript\" src=\'../../eXH/js/Validate.js\'> </script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n\n\n//\n\n</script>\n</head>\n<body BGCOLOR=\"#B2B6D7\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' CLASS=\"MESSAGE\">\n<form>\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n\n</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

String Status="FALSH";
	 ResultSet rset = null;
  
  Statement stmt=null;
 Connection connection = null;

    // String status="";
     String exceptions="";


//    String levelcount="";
//    MessageManager mm=new MessageManager();
//    int levelcount1=0;
	String query = request.getParameter("Query");

	//System.out.println("query 42"+query);
	String fieldname=request.getParameter("fieldname");
	//System.out.println("query"+query);
    String replacestr="%";
	
    String reSecond = new String("'"+replacestr+"'");

    //System.out.println("reSecond :"+reSecond);
    if(query.indexOf(":1")!=-1)
	{ 
         query=query.replace(":1","null");
		 query=query.trim();
//replacestr
//rset.getString(3);
	} 
else
	{
		query=query.trim();
	}


     if(query.indexOf(":2")!=-1)
	{
         query=query.replace(":2","null");
		 query=query.trim();
	}
	else
	{
		query=query.trim();
	}





//System.out.println("query 67"+query);
	Properties p;		
  		p = (Properties) session.getValue("jdbc");	
       // String locale  = p.getProperty("LOCALE");
    try 
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of FilterLayerCheckQuery.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
    try
     { 
 stmt= connection.createStatement();
 rset = stmt.executeQuery(query);
 rset.next();


 
if(rset.next())
 {
 }

 Status="TRUE";
      }
      catch(Exception exp) 
      {
        
          if(fieldname.equals("Element_subtype"))
		  {
			  out.println("<script>alert(getMessage('XH1046','XH'));parent.frames[3].document.forms[0].Element_subtype.focus();</script>"); 
		  }
		  else if(fieldname.equals("Filter_Element_Query"))
		  {
           out.println("<script>alert(getMessage('XH1046','XH'));parent.frames[3].document.forms[0].Filter_Element_Query.focus();</script>"); 
		  }
		  else
		  {          out.println("<script>alert(getMessage('XH1046','XH'));parent.frames[3].document.forms[0].Element_query.focus();</script>"); 
		  }
					 
         System.out.println("Error in calling dbrealted statements in dooperate method of FilterLayerCheckQuery.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
		 
      }
      try{
      ConnectionManager.returnConnection(connection);
	  rset.close() ;  
      stmt.close();
	  } catch(Exception exp)
    {
		
       System.out.println("Error in populatexhcodedesc method of FilterLayerCheckQuery.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
	  finally{


              		
               
		}
		

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
