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

public final class __filterlayargroupfilterrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilterLayarGroupFilterRecord.jsp", 1709122339398L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 =" \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\" >\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body BGCOLOR=\"#B2B6D7\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' CLASS=\"MESSAGE\" >\n<form > \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script>\n\nparent.frames[2].location.href=\'../../eXH/jsp/FilterLayerGroupFilterLevalSearch.jsp\';\nparent.frames[3].document.forms[0].reset();\n</script>\n\n\n\n\t  </form>\n\t  </body>\n\t  </html>\n\n";
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
 
    Connection connection = null;
    CallableStatement ostmt = null;
    String message_text = "",status="0";
   
    String Filter_group="";
String Levelnumber="";
String FilterElement_Type="";
String FilterElement_desc="";
String Elementquery="";
String  Filtersubtype_Type="";
String Filtersubtype_desc="";
String Elementsubtype=""; 
String FilterElement_Code="";
String	mode="";
String exceptions="";

MessageManager mm=new MessageManager();
		String FilterElement_Query="";
	Properties p;
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");
    
    try
    { 
 	 mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
     //System.out.println("mode : "+mode);
 Filter_group=request.getParameter("Filter_group_desc_id");
 Levelnumber=request.getParameter("Level_number");

FilterElement_Type=request.getParameter("Filter_Element_Type");
FilterElement_desc=request.getParameter("Filter_Element_desc");
Elementquery=request.getParameter("Element_query");
 Filtersubtype_Type=request.getParameter("Filter_subtype_Type");
Filtersubtype_desc=request.getParameter("Filter_subtype_desc");
Elementsubtype=request.getParameter("Element_subtype");
FilterElement_Code=request.getParameter("Filter_Element_Code");
FilterElement_Query=request.getParameter("Filter_Element_Query");
	  //System.out.println("ApplicationId"+ApplicationId+"FacilityId"+FacilityId+"Messagetype"+Messagetype+"EventType"+EventType+"Protocollink"+Protocollink+"FilterGroupcode"+FilterGroupcode+"totallevel"+totallevel+"filterGroupdesc"+filterGroupdesc);

    } 
	catch(Exception exp)
    {
       System.out.println("Error in dooperate method of FilterLayarGroupFilterRecord.jsp :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try 
     {


      ostmt = connection.prepareCall("{ CALL xhgenericfilter.XH_FILTER_LEVEL_CONFIG(?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
	
/*
      arrFilterInfo.add(mode);
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("rowid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("applicationid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("elementid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("derivation_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("cond_exprsn")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("expected_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("execution_order")));
*/
    		 

//System.out.println("usr_added_by_id"+usr_added_by_id+"usr_added_at_ws_no"+usr_added_at_ws_no+"usr_added_by_date"+usr_added_by_date);

		  ostmt.setString(1,mode);
		  ostmt.setString(2,Filter_group);
		  ostmt.setString(3,Levelnumber);
		  ostmt.setString(4,FilterElement_Type);
		  ostmt.setString(5,FilterElement_desc);
		  ostmt.setString(6,Elementquery);
		  ostmt.setString(7,Filtersubtype_Type);
	      ostmt.setString(8,Filtersubtype_desc);
		  ostmt.setString(9,Elementsubtype); 
		  ostmt.setString(10,FilterElement_Code); 
          ostmt.setString(11,FilterElement_Query); 
    	  ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
          ostmt.execute();
          status = ostmt.getString(12); 
	      //System.out.println("status"+status); 
          message_text = ostmt.getString(13);
                if (status.equals("0"))   
        { 
          connection.commit(); 
		  if(mode.equals("D"))
				 {
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1036", "XH") ;
	  		    status = ((String) mesg.get("message"));
out.println(status);
				 }
				 else
				 {
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
				out.println(status);
				 }


             }
        else
        {
        
          connection.rollback();
		 // chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
		
		 out.println("AP-0001 operation failed");
		   
		  
        }


		
   
      
       if(ostmt!=null)ostmt.close();
                   
      }
     catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
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
