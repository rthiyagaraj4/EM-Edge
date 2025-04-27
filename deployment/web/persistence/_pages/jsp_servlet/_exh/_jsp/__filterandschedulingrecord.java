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

public final class __filterandschedulingrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilterAndSchedulingRecord.jsp", 1742465975169L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<head> \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\" >\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body BGCOLOR=\"#B2B6D7\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' CLASS=\"MESSAGE\" >\n<form > \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<input type=hidden name=filter_code id=filter_code value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\n<script>\nparent.frames[3].location.href=\"../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?Filter_group_code=\"+document.forms[0].filter_code.value;\n</script>\n\n\t  </form>\n\t  </body>\n\t  </html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block9Bytes, _wl_block9);
 
//int count_field=Integer.parseInt(request.getParameter("count_fields"));
MessageManager mm=new MessageManager();
Properties p;
p = (Properties) session.getValue("jdbc");										   
//String locale  = p.getProperty("LOCALE");					 
String msg="";
Statement s=null;
ResultSet r = null;
Statement stmt=null;
ResultSet reset = null;
Connection connection = null;
CallableStatement ostmt = null;
String message_text = "",status="0";
String Filter_group="";
//int Levelnumber=0;
//String FilterElement_Type="";
//String Filtersubtype_desc="";
//String FilterElement_Code="";
String	mode="";
String exceptions="";
//String FilterElement_Query="";
int Transaction_number=1;
String applicationID=request.getParameter("applicationID");
String facilityID=request.getParameter("facilityID"); 
String event_type=request.getParameter("event_type");
String protocol_link_id=request.getParameter("protocol_link");
int levelcount=0;
	p = (Properties) session.getValue("jdbc");	
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");

    try
    { 
 	
 mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
//System.out.println("ApplicationId"+ApplicationId+"FacilityId"+FacilityId+"Messagetype"+Messagetype+"EventType"+EventType+"Protocollink"+Protocollink+"FilterGroupcode"+FilterGroupcode+"totallevel"+totallevel+"filterGroupdesc"+filterGroupdesc);

    } 
	catch(Exception exp)
    {
       System.out.println("(FilterAndSchedulingRecord.jsp:Exc-1) :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {																		 
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println(" (FilterAndSchedulingRecord.jsp:Exc-2) :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }     
    	
     try
     {

//XH_APPL_FILTER_RULE_DETAIL(	p_mode			      VARCHAR2,P_trx_no                      NUMBER,p_filter_level_no			NUMBER,							p_filter_group_code           VARCHAR2,							p_filter_level_type          VARCHAR2,							p_filter_level_subtype       VARCHAR2,							p_filter_level_code          VARCHAR2,							p_filter_level_value         VARCHAR2,p_errcd			OUT	VARCHAR2,p_errmsg		OUT	VARCHAR2)


Filter_group=request.getParameter("Filter_group_desc_id");
 s= connection.createStatement();
 r = s.executeQuery("select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+Filter_group+"'");
 r.next();
  levelcount= r.getInt("rowcount") ;
  /*if(levelcount==0)
		 {
	  mode="I";
		 }
		 else
		 {
			 mode="U";			  
		 }*/
r.close() ;
 s.close();
stmt= connection.createStatement();
 reset = stmt.executeQuery("select max(TRX_NO)  AS rowcount from XH_APPL_FILTER_RULE_DETAIL where filter_group_code='"+Filter_group+"'");
 
if(reset.next())
{
	 Transaction_number= reset.getInt("rowcount")+1 ;
}
else
{
	Transaction_number= 1 ;
} 
reset.close() ;
stmt.close();



		  //System.out.println("applicationID : "+applicationID);
  		  //System.out.println("facilityID : "+facilityID);
		  //System.out.println("event_type : "+event_type);
  		 // System.out.println("protocol_link_id : "+protocol_link_id);

 
//for(int j=1;j<count_field;j++)
 //{
       //   Levelnumber=Integer.parseInt(request.getParameter(j+"leval_number")); 		    
/*          FilterElement_Type=request.getParameter(j+"Filter_element_desc");
          Filtersubtype_desc=request.getParameter(j+"Filter_subtype_desc_combo");
          FilterElement_Code=request.getParameter("Element_code_Query"+j);
          FilterElement_Query=request.getParameter("Element_code_Querys"+j+j);*/

ostmt = connection.prepareCall("{ CALL xhgenericfilter.XH_APPL_FILTER_RULE_DETAIL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
	      ostmt.setString(1,mode);
  		  ostmt.setInt(2,Transaction_number);
		  ostmt.setString(3,Filter_group);
		  ostmt.setString(4,applicationID);
		  ostmt.setString(5,facilityID);
		  ostmt.setString(6,event_type);
		  ostmt.setString(7,protocol_link_id);
		  ostmt.setString(8,XHDBAdapter.checkNull(request.getParameter("1Filter_element_desc"))); 
				  //System.out.println("p_filter_level1_type : "+XHDBAdapter.checkNull(request.getParameter("1Filter_element_desc")));
          ostmt.setString(9,XHDBAdapter.checkNull(request.getParameter("1Filter_subtype_desc_combo"))); 
		  		//  System.out.println("p_filter_level1_subtype : "+XHDBAdapter.checkNull(request.getParameter("1Filter_subtype_desc_combo")));
//          ostmt.setString(10,XHDBAdapter.checkNull(request.getParameter("Element_code_Query1"))); 
		  ostmt.setString(10,request.getParameter("Element_code_Query1")==null?"*":request.getParameter("Element_code_Query1"));
		  		//  System.out.println("p_filter_level1_code : "+XHDBAdapter.checkNull(request.getParameter("Element_code_Query1")));
//          ostmt.setString(11,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys1")));   
		  ostmt.setString(11,request.getParameter("Element_code_Querys1")==null?"*":request.getParameter("Element_code_Querys1"));
//		  ostmt.setString(12,XHDBAdapter.checkNull(request.getParameter("2Filter_element_desc"))); 
		  ostmt.setString(12,request.getParameter("2Filter_element_desc")==null?"*":request.getParameter("2Filter_element_desc"));
//          ostmt.setString(13,XHDBAdapter.checkNull(request.getParameter("2Filter_subtype_desc_combo"))); 
		  ostmt.setString(13,request.getParameter("2Filter_subtype_desc_combo")==null?"*":request.getParameter("2Filter_subtype_desc_combo"));
//          ostmt.setString(14,XHDBAdapter.checkNull(request.getParameter("Element_code_Query2"))); 
		  ostmt.setString(14,request.getParameter("Element_code_Query2")==null?"*":request.getParameter("Element_code_Query2"));
//          ostmt.setString(15,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys2")));  
		  ostmt.setString(15,request.getParameter("Element_code_Querys2")==null?"*":request.getParameter("Element_code_Querys2"));
//		  ostmt.setString(16,XHDBAdapter.checkNull(request.getParameter("3Filter_element_desc"))); 
		  ostmt.setString(16,request.getParameter("3Filter_element_desc")==null?"*":request.getParameter("3Filter_element_desc"));
//          ostmt.setString(17,XHDBAdapter.checkNull(request.getParameter("3Filter_subtype_desc_combo"))); 
		  ostmt.setString(17,request.getParameter("3Filter_subtype_desc_combo")==null?"*":request.getParameter("3Filter_subtype_desc_combo"));
//          ostmt.setString(18,XHDBAdapter.checkNull(request.getParameter("Element_code_Query3"))); 
		  ostmt.setString(18,request.getParameter("Element_code_Query3")==null?"*":request.getParameter("Element_code_Query3"));
//          ostmt.setString(19,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys3")));   
		  ostmt.setString(19,request.getParameter("Element_code_Querys3")==null?"*":request.getParameter("Element_code_Querys3"));
//		  ostmt.setString(20,XHDBAdapter.checkNull(request.getParameter("4Filter_element_desc")));           
		  ostmt.setString(20,request.getParameter("4Filter_element_desc")==null?"*":request.getParameter("4Filter_element_desc"));
//ostmt.setString(21,XHDBAdapter.checkNull(request.getParameter("4Filter_subtype_desc_combo"))); 
		  ostmt.setString(21,request.getParameter("4Filter_subtype_desc_combo")==null?"*":request.getParameter("4Filter_subtype_desc_combo"));
//          ostmt.setString(22,XHDBAdapter.checkNull(request.getParameter("Element_code_Query4"))); 
		  ostmt.setString(22,request.getParameter("Element_code_Query4")==null?"*":request.getParameter("Element_code_Query4"));
//          ostmt.setString(23,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys4")));  
		  ostmt.setString(23,request.getParameter("Element_code_Querys4")==null?"*":request.getParameter("Element_code_Querys4"));
//    	  ostmt.setString(24,XHDBAdapter.checkNull(request.getParameter("5Filter_element_desc"))); 
		  ostmt.setString(24,request.getParameter("5Filter_element_desc")==null?"*":request.getParameter("5Filter_element_desc"));
//          ostmt.setString(25,XHDBAdapter.checkNull(request.getParameter("5Filter_subtype_desc_combo"))); 
		  ostmt.setString(25,XHDBAdapter.checkNull(request.getParameter("5Filter_subtype_desc_combo")==null?"*":request.getParameter("5Filter_subtype_desc_combo")));
//          ostmt.setString(26,XHDBAdapter.checkNull(request.getParameter("Element_code_Query5"))); 
		  ostmt.setString(26,XHDBAdapter.checkNull(request.getParameter("Element_code_Query5")==null?"*":request.getParameter("Element_code_Query5")));
//          ostmt.setString(27,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys5")));   
		  ostmt.setString(27,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys5")==null?"*":request.getParameter("Element_code_Querys5")));
//		  ostmt.setString(28,XHDBAdapter.checkNull(request.getParameter("6Filter_element_desc"))); 
		  ostmt.setString(28,XHDBAdapter.checkNull(request.getParameter("6Filter_element_desc")==null?"*":request.getParameter("6Filter_element_desc")));
//          ostmt.setString(29,XHDBAdapter.checkNull(request.getParameter("6Filter_subtype_desc_combo"))); 
		  ostmt.setString(29,XHDBAdapter.checkNull(request.getParameter("6Filter_subtype_desc_combo")==null?"*":request.getParameter("6Filter_subtype_desc_combo")));
//          ostmt.setString(30,XHDBAdapter.checkNull(request.getParameter("Element_code_Query6"))); 
		  ostmt.setString(30,XHDBAdapter.checkNull(request.getParameter("Element_code_Query6")==null?"*":request.getParameter("Element_code_Query6")));
//          ostmt.setString(31,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys6")));  
		  ostmt.setString(31,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys6")==null?"*":request.getParameter("Element_code_Querys6")));
//		  ostmt.setString(32,XHDBAdapter.checkNull(request.getParameter("7Filter_element_desc"))); 
		  ostmt.setString(32,XHDBAdapter.checkNull(request.getParameter("7Filter_element_desc")==null?"*":request.getParameter("7Filter_element_desc")));
//          ostmt.setString(33,XHDBAdapter.checkNull(request.getParameter("7Filter_subtype_desc_combo"))); 
		  ostmt.setString(33,XHDBAdapter.checkNull(request.getParameter("7Filter_subtype_desc_combo")==null?"*":request.getParameter("7Filter_subtype_desc_combo")));
//          ostmt.setString(34,XHDBAdapter.checkNull(request.getParameter("Element_code_Query7"))); 
		  ostmt.setString(34,XHDBAdapter.checkNull(request.getParameter("Element_code_Query7")==null?"*":request.getParameter("Element_code_Query7")));
//          ostmt.setString(35,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys7")));  
		  ostmt.setString(35,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys7")==null?"*":request.getParameter("Element_code_Querys7")));
//    	  ostmt.setString(36,XHDBAdapter.checkNull(request.getParameter("8Filter_element_desc"))); 
		  ostmt.setString(36,XHDBAdapter.checkNull(request.getParameter("8Filter_element_desc")==null?"*":request.getParameter("8Filter_element_desc")));
//          ostmt.setString(37,XHDBAdapter.checkNull(request.getParameter("8Filter_subtype_desc_combo"))); 
		  ostmt.setString(37,XHDBAdapter.checkNull(request.getParameter("8Filter_subtype_desc_combo")==null?"*":request.getParameter("8Filter_subtype_desc_combo")));
//          ostmt.setString(38,XHDBAdapter.checkNull(request.getParameter("Element_code_Query8"))); 
		  ostmt.setString(38,XHDBAdapter.checkNull(request.getParameter("Element_code_Query8")==null?"*":request.getParameter("Element_code_Query8")));
//          ostmt.setString(39,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys8")));   
		  ostmt.setString(39,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys8")==null?"*":request.getParameter("Element_code_Querys8")));
//		  ostmt.setString(40,XHDBAdapter.checkNull(request.getParameter("9Filter_element_desc"))); 
		  ostmt.setString(40,XHDBAdapter.checkNull(request.getParameter("9Filter_element_desc")==null?"*":request.getParameter("9Filter_element_desc")));
//          ostmt.setString(41,XHDBAdapter.checkNull(request.getParameter("9Filter_subtype_desc_combo"))); 
		  ostmt.setString(41,XHDBAdapter.checkNull(request.getParameter("9Filter_subtype_desc_combo")==null?"*":request.getParameter("9Filter_subtype_desc_combo")));
//          ostmt.setString(42,XHDBAdapter.checkNull(request.getParameter("Element_code_Query9"))); 
		  ostmt.setString(42,XHDBAdapter.checkNull(request.getParameter("Element_code_Query9")==null?"*":request.getParameter("Element_code_Query9")));
//          ostmt.setString(43,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys9")));  
		ostmt.setString(43,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys9")==null?"*":request.getParameter("Element_code_Querys9")));
    	  ostmt.registerOutParameter(44,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(45,java.sql.Types.VARCHAR);
		  ostmt.registerOutParameter(46,java.sql.Types.VARCHAR);
          ostmt.execute();
          status = ostmt.getString(45); 
		  //System.out.println("FilterAndSchedulingRecord.jsp status : "+status);
          message_text = ostmt.getString(46);
          out.println("<html><head></head><body bgcolor=#B2B6D7 >"); 
          out.println("</body></html>");
          if(ostmt!=null)ostmt.close();
 //}
	 
		if (status.equals("0"))  
        {
			connection.commit(); 
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			// status = ((String) mesg.get("message")); 
			// final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
			msg= ((String) mesg.get("message"));
			out.println(msg);
			out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html';  </script>");
			mesg.clear();
		}
		else if (status.equals("2"))  
        {
			connection.commit(); 
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
			// status = ((String) mesg.get("message")); 
			// final java.util.Hashtable mesg = mm.getMessage(connection, "XH1024") ;
			msg = ((String) mesg.get("message"));
			out.println(msg);
			out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html';  </script>");	
			mesg.clear();
		}
		else														  
        {
      
			connection.rollback();
			// chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
			//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
			msg = ((String) mesg.get("message"));
			out.println(msg);
			mesg.clear();
		 }


      }
      catch(Exception e)
		 {
	      System.out.println("(Error in FilterAndSchedulingRecord.jsp:sqlExceptrion) :"+e.toString());
	      e.printStackTrace(System.err);
	  }
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in dooperate method of FilterAndSchedulingRecord.jsp :"+e.toString());
	      e.printStackTrace(System.err);
	  }
	  
	  
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Filter_group));
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
