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
import java.io.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __dataelementcrossrefelementsetupjsp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DataElementCrossRefElementSetupJSP.jsp", 1709122317117L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script src=\'../../eXH/js/filterlayerrefrence.js\' language=\'javascript\'></script>\n<script Language=\"JavaScript\" >\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body BGCOLOR=\"#B2B6D7\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' CLASS=\"MESSAGE\" >\n<form > \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n\n  </form>\n\t  </body>\n\t  </html>\n \n\n";
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

Properties p;		
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");

	request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");

//	PrintWriter out=res.getWriter();
	CallableStatement oraclecallablestatement = null;
	Connection con = null;
	MessageManager mm=new MessageManager();
	
	String status="";   

    try
    {
     
      out.println("<head>");
      sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
      out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
      out.println("</head>");
      out.println("<body class='MESSAGE'>");      
   
	}
    catch(Exception exception)
    {
         System.out.println("Error in dopost method od dataelementcrossrefapplicationusageservlet:"+exception.toString());
		exception.printStackTrace(System.err); 
		
    }
	
	try
    {
        con = ConnectionManager.getConnection();
        XHApplicationElementControllerBean xhBean=XHApplicationElementControllerBean.getBean(XHApplicationElementControllerBean.strBeanName,request,session);
        xhBean.action(request,con);

		String strData[][]= xhBean.getDatabaseData();
		ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
		xhBean.action(request,con);
		

		for(int i=0;i<strData.length;i++) 
		 {
     
     
	    oraclecallablestatement = con.prepareCall("{call XHMAST.element_code_usage_for_appl(?,?,?,?,?,?,?,?,?)}");
       
		String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1);
	    oraclecallablestatement.setString(1,strData[i][0]);

/*System.out.println("strData[i][0]"+strData[i][0]);
System.out.println("strData[i][1]"+strData[i][1]);
System.out.println("strData[i][2]"+strData[i][2]);
System.out.println("strData[i][3]"+strData[i][3]);
System.out.println("strData[i][4]"+strData[i][4]);	*/

		oraclecallablestatement.setString(2,strData[i][1]);
		oraclecallablestatement.setString(3,strData[i][2]);
		oraclecallablestatement.setString(4,strData[i][3]);
		oraclecallablestatement.setString(5,strData[i][4]);
		 

	    oraclecallablestatement.setString(6,usr_added_by_id);
		oraclecallablestatement.setString(7,usr_added_at_ws_no);

		oraclecallablestatement.registerOutParameter(8,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(9,java.sql.Types.VARCHAR);
		
        oraclecallablestatement.execute();
		
        
		status = oraclecallablestatement.getString(8);
		if(oraclecallablestatement!=null) oraclecallablestatement.close();
        if("0".equals(status))
		{
                con.commit();
			    final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			    status = ((String) mesg.get("message"));
        }
		else
		{
			  con.rollback();
              final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
 			  status = ((String) mesg.get("message"));
		}

	  }
        out.println("");
        out.println(status);
        out.println("");
        out.println("</body>");  
		
		}catch(Exception exception)
		{
			 System.out.println("Error in calling db realted statements in dopost method of DataElementCrossRefElementSetupJSP.jsp :"+exception.toString());
		    exception.printStackTrace(System.err); 
		
		}finally{
			try
			{
		      
			   ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			   System.out.println("Eroor in closing dbconnection dopost method of DataElementCrossRefElementSetupJSP.jsp :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}
			//if(con!=null) 

		}

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
