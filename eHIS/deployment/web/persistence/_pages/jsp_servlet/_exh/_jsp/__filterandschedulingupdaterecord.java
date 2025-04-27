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

public final class __filterandschedulingupdaterecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilterAndSchedulingUpdateRecord.jsp", 1709122334663L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n ";
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

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\" >\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\t\t\t\t\t\t\t  \n</head>\n<body BGCOLOR=\"#B2B6D7\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' CLASS=\"MESSAGE\" >\t    \n<form > \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<input type=hidden name=filter_code value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\n<script>\nparent.frames[3].location.href=\"../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?Filter_group_code=\"+document.forms[0].filter_code.value;\n</script>\n\n\t  </form>\n\t  </body>\n\t  </html>\n\t\t\t\t\t\t\t\t\t\t \t\t\t  \n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);
String sStyle ="IeStyle.css";
//(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
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
 String message_text = "",status="0";
 String Filter_group="";
 String	mode="";
 String exceptions="";
 int Transaction_number=1;
String applicationID=request.getParameter("applicationID");
String facilityID=request.getParameter("facilityID"); 
String event_type=request.getParameter("event_type");
String protocol_link_id=request.getParameter("protocol_link");
 p = (Properties) session.getValue("jdbc");	
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");

    try
    { 
 		mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
    } 
	catch(Exception exp)
    {
       System.out.println("Error in dooperate method of FilterAndSchedulingUpdateRecord.jsp.jsp :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterAndSchedulingupdateRecord.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {

Filter_group=request.getParameter("Filter_group_desc_id");
Transaction_number=Integer.parseInt(request.getParameter("Tranaction_number"));
ostmt = connection.prepareCall("{ CALL xhgenericfilter.XH_APPL_FILTER_RULE_DETAIL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
	      ostmt.setString(1,mode);
  		  ostmt.setInt(2,Transaction_number);
		  ostmt.setString(3,Filter_group);									  
		  ostmt.setString(4,applicationID);
		  ostmt.setString(5,facilityID);
		  ostmt.setString(6,event_type);
		  ostmt.setString(7,protocol_link_id);
		  ostmt.setString(8,XHDBAdapter.checkNull(request.getParameter("1Filter_element_desc"))); 
          ostmt.setString(9,XHDBAdapter.checkNull(request.getParameter("1Filter_subtype_desc_combo"))); 
          ostmt.setString(10,XHDBAdapter.checkNull(request.getParameter("Element_code_Query1"))); 
          ostmt.setString(11,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys1")));   
		  ostmt.setString(12,XHDBAdapter.checkNull(request.getParameter("2Filter_element_desc"))); 
          ostmt.setString(13,XHDBAdapter.checkNull(request.getParameter("2Filter_subtype_desc_combo"))); 
          ostmt.setString(14,XHDBAdapter.checkNull(request.getParameter("Element_code_Query2"))); 
          ostmt.setString(15,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys2")));  
		  ostmt.setString(16,XHDBAdapter.checkNull(request.getParameter("3Filter_element_desc"))); 
          ostmt.setString(17,XHDBAdapter.checkNull(request.getParameter("3Filter_subtype_desc_combo"))); 
          ostmt.setString(18,XHDBAdapter.checkNull(request.getParameter("Element_code_Query3"))); 
          ostmt.setString(19,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys3")));   
		  ostmt.setString(20,XHDBAdapter.checkNull(request.getParameter("4Filter_element_desc")));           ostmt.setString(21,XHDBAdapter.checkNull(request.getParameter("4Filter_subtype_desc_combo"))); 
          ostmt.setString(22,XHDBAdapter.checkNull(request.getParameter("Element_code_Query4"))); 
          ostmt.setString(23,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys4")));  
    	  ostmt.setString(24,XHDBAdapter.checkNull(request.getParameter("5Filter_element_desc"))); 
          ostmt.setString(25,XHDBAdapter.checkNull(request.getParameter("5Filter_subtype_desc_combo"))); 
          ostmt.setString(26,XHDBAdapter.checkNull(request.getParameter("Element_code_Query5"))); 
          ostmt.setString(27,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys5")));     
		  ostmt.setString(28,XHDBAdapter.checkNull(request.getParameter("6Filter_element_desc"))); 
          ostmt.setString(29,XHDBAdapter.checkNull(request.getParameter("6Filter_subtype_desc_combo"))); 
          ostmt.setString(30,XHDBAdapter.checkNull(request.getParameter("Element_code_Query6"))); 
          ostmt.setString(31,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys6")));  
		  ostmt.setString(32,XHDBAdapter.checkNull(request.getParameter("7Filter_element_desc"))); 
          ostmt.setString(33,XHDBAdapter.checkNull(request.getParameter("7Filter_subtype_desc_combo"))); 
          ostmt.setString(34,XHDBAdapter.checkNull(request.getParameter("Element_code_Query7"))); 
          ostmt.setString(35,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys7")));  
    	  ostmt.setString(36,XHDBAdapter.checkNull(request.getParameter("8Filter_element_desc"))); 
          ostmt.setString(37,XHDBAdapter.checkNull(request.getParameter("8Filter_subtype_desc_combo"))); 
          ostmt.setString(38,XHDBAdapter.checkNull(request.getParameter("Element_code_Query8"))); 
          ostmt.setString(39,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys8")));   
		  ostmt.setString(40,XHDBAdapter.checkNull(request.getParameter("9Filter_element_desc"))); 
          ostmt.setString(41,XHDBAdapter.checkNull(request.getParameter("9Filter_subtype_desc_combo"))); 
          ostmt.setString(42,XHDBAdapter.checkNull(request.getParameter("Element_code_Query9"))); 
          ostmt.setString(43,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys9")));  
    	  ostmt.registerOutParameter(44,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(45,java.sql.Types.VARCHAR);
		  ostmt.registerOutParameter(46,java.sql.Types.VARCHAR);
          ostmt.execute();
          status = ostmt.getString(45); 
          message_text = ostmt.getString(46);
		   if(ostmt!=null)
			 {
	    	ostmt.close();
	    	ostmt=null;
			 }
		
        out.println("<html><head></head><body bgcolor=#B2B6D7 >"); 
        out.println("</body></html>");
       
       if (status.equals("0"))  
        {
          connection.commit(); 
	      final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 msg = ((String) mesg.get("message")); 
		   out.println(msg);
           if(ostmt!=null)   ostmt.close();
           out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html';  </script>");
		}

		else if (status.equals("2"))  
        {
          connection.commit(); 
		  //final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 // status = ((String) mesg.get("message")); 
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
		 msg = ((String) mesg.get("message")); 
		  out.println(msg);
          out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html';  </script>");
		
		}
		else
        {
         
          connection.rollback();
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
		  msg = ((String) mesg.get("message"));
		  out.println(msg);
		  if(ostmt!=null)
		  ostmt.close();
		  
        }

 
      }
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in dooperate method of sqlexeception :"+exp);
	             
      }
finally
{
if(ostmt!=null)
			   	   ostmt.close();
ConnectionManager.returnConnection(connection);
}

      
	  
	  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Filter_group));
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
