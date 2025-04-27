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

public final class __protocollinkupdate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/Protocollinkupdate.jsp", 1709122378131L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\n<script Language=\"JavaScript\"  src=\"../../eXH/js/ProfiledervationRefrence.js\" ></script>\n<script Language=\"JavaScript\" >\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body bgcolor=#B2B6D7 class=\"Message\" >\n<form > \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t  </form>\n\t  </body>\n\t  </html>\n\n";
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
 
  String Action_type=request.getParameter("Mode");
//System.out.println("Action_type25"+Action_type);
	  
    Connection connection = null;
    CallableStatement ostmt = null;
    String message_text = "",status="0";
   
    String exceptions="";
   
	//String applicationid="";
	// String elementid="";
	 /*String derivation_type="";
	   String cond_exprsn="";
	   String expected_value="";
	    String execution_order="";
		  String expected_value2="";
		  String position_value="";*/

	MessageManager mm=new MessageManager();

		//req=request;
		 Properties p;
	
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");
    	request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
  
    
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {
		 //

 XHApplicationDerivationProfileSetupControllerBean xhBean=XHApplicationDerivationProfileSetupControllerBean.getBean(XHApplicationDerivationProfileSetupControllerBean.strBeanName,request,session); 
    xhBean.action(request,connection);

     String strData[][] = xhBean.getDatabaseData();
	  ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
     String  usr_added_by_id=(String)arrAudit.get(0);

     //ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
	// xhBean.action(request,connection);
    // MessageManager mm=new MessageManager();


 for(int i=0;i<strData.length;i++)
	 { 
 	  

/*applicationid=XHDBAdapter.checkNull(request.getParameter(i+"Profile_ID")); 
	        System.out.println("applicationid : "+applicationid);
     
       elementid=XHDBAdapter.checkNull(request.getParameter(i+"Element_ID"));
	        System.out.println("elementid : "+elementid);
	
      derivation_type=XHDBAdapter.checkNull(request.getParameter(i+"_Combo"));
	        System.out.println("derivation_type : "+derivation_type);

       cond_exprsn=XHDBAdapter.checkNull(request.getParameter(i+"_C/E"));
	        System.out.println("cond_exprsn : "+cond_exprsn);
		     
       expected_value=XHDBAdapter.checkNull(request.getParameter(i+"_EV"));
	  System.out.println("expected_value : "+expected_value);
	
       execution_order=XHDBAdapter.checkNull(request.getParameter(i+"_EO"));
	  System.out.println("execution_order : "+execution_order);

       expected_value2=XHDBAdapter.checkNull(request.getParameter(i+"_EV2"));
	  System.out.println("expected_value : "+expected_value2);
	
	   position_value=XHDBAdapter.checkNull(request.getParameter(i+"_PO"));
	  System.out.println("Position_value : "+position_value);*/

	 
      ostmt = connection.prepareCall("{ CALL XG_PRC.XH_PROTOCOL_LINK_RULES_IN_UP(?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
		//System.out.println("prepareCall XH_PROTOCOL_LINK_DERVN_RULES");
          ostmt.setString(1,Action_type);
		    ostmt.setString(2,strData[i][6]);
//ostmt.setString(1,Action_type);
		  ostmt.setString(3,strData[i][10]);
		  ostmt.setString(4,strData[i][1]);
		  ostmt.setString(5,strData[i][4]);
		  ostmt.setString(6,strData[i][7]);
		  ostmt.setString(7,strData[i][5]);
		 ostmt.setString(8,strData[i][9]);
		  ostmt.setString(9,usr_added_by_id);
		  ostmt.setString(10,strData[i][8]);
	     
		 
		//  ostmt.setString(11,usr_facility_by_id);
		  ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);

        ostmt.execute();
        status = ostmt.getString(11);
		//System.out.println("status"+status);
        message_text = ostmt.getString(12);
  if(ostmt!=null)ostmt.close();
        if (status.equals("0"))
        {
          connection.commit(); 
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		  status = ((String) mesg.get("message"));
         ///System.out.println("status12"+status);
        }
        else
        {
          
          connection.rollback();
		 // chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
		   //     System.out.println("status123"+status);
		  //if(chkStat)
		  //{
			//   final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
		      // status = ((String) mesg.get("message"));
		  //}
		  //else 
		  //{
               final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	           status = ((String) mesg.get("message"));
	
		  //}
        }
	 }
	 out.println(status);
	  
    }
	catch(Exception exp)
    {
       //System.out.println("Error in dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
	finally
	{
		 
		if(ostmt!=null)
	    	ostmt.close();
		ConnectionManager.returnConnection(connection);
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
