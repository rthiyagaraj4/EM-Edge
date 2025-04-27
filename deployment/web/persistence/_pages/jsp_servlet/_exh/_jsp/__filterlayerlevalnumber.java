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

public final class __filterlayerlevalnumber extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilterLayerLevalNumber.jsp", 1709122340898L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n<html>\n<head>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\'JavaScript\' src=\'../../eXH/js/Validate.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body BGCOLOR=\"#B2B6D7\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' CLASS=\"MESSAGE\">\n<form>\n<input type=hidden name=input_value value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'>\n<script>\nvar levelnumber;\nlevelnumber=document.forms[0].input_value.value;\n\nparent.frames[3].document.forms[0].Event_type.value=levelnumber;\nparent.frames[3].document.forms[0].Level_number.value=levelnumber;\n</script>\n</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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


	 ResultSet rset = null;
  
  Statement stmt=null;
 Connection connection = null;

 String status="";
String exceptions="";


String levelcount="";
MessageManager mm=new MessageManager();
int levelcount1=0;
	String filter_group = request.getParameter("filter_code");
	System.out.println("filter_group"+filter_group);

	Properties p;		
  		p = (Properties) session.getValue("jdbc");	
        String locale  = p.getProperty("LOCALE");
    try 
    {																		    
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayerLevalNumber.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
    try																		   
     { 
 stmt= connection.createStatement();
 rset = stmt.executeQuery("select max(LEVEL_NUMBER) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+filter_group+"'");
 rset.next();
 levelcount1 = rset.getInt("rowcount") ;
rset.close() ;  
stmt.close();

stmt= connection.createStatement();
String sq="select 'Y'  from xh_filter_group  where FILTER_group_code='"+filter_group+"' and total_levels>= '"+(levelcount1+1)+"' ";
rset = stmt.executeQuery(sq);
System.out.println(sq);

 
if(rset.next())
 {
String levalcount2="";
levelcount=levalcount2.valueOf(levelcount1+1);
 }
else
 {
final java.util.Hashtable mesg = mm.getMessage(locale,"XH1044", "XH") ;
  status = ((String) mesg.get("message"));
  status = status.replace("$","test");

  out.println("<script>alert('"+status+"'); parent.frames[3].document.forms[0].reset();</script>");
//RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("../../eXH/jsp/DisplaySleepParameterResult1.jsp?message="+status+"");
  //        reqDis.forward(request,response);
 }

rset.close() ; 
 stmt.close();
/*levelcount=levelcount1;
if(group_level_status.equals("Y"))
 {


 }
else
 {
  //    final java.util.Hashtable mesg = mm.getMessage(locale, "XH1034", "XH") ;
	//  		    status = ((String) mesg.get("message"));
//RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("../../eXH/jsp/DisplaySleepParameterResult1.jsp?message="+status+"");
  //          reqDis.forward(request,response);
 }*/

      }
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in FilterLayerLevalNumber.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
  
      }
      try{
      ConnectionManager.returnConnection(connection);					  
	  } catch(Exception exp)
    {
       System.out.println("Error in FilterLayerLevalNumber.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
	  finally{


              		
               
		}
		

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(levelcount+""));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
