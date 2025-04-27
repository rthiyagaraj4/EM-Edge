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

public final class __interfacesatndaredqueryrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/Interfacesatndaredqueryrecord.jsp", 1732885020706L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block8 ="\n\n</form>\n\t  </body>\n\t  </html>\n\n";
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

String Application_Specific_txt="";
Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");
    	request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
 Connection connection = null;
	    CallableStatement  oraclecallablestatement = null;
		MessageManager mm=new MessageManager();
	    String p_mode=request.getParameter("act_mode");	
		String standard_code=XHDBAdapter.checkNull(request.getParameter("standard_code"));
		String ProfileId=XHDBAdapter.checkNull(request.getParameter("profile_id"));
		String Short_desc=XHDBAdapter.checkNull(request.getParameter("short_desc"));
		String Long_desc=request.getParameter("Long_desc");	
		String version_spcific=XHDBAdapter.checkNull(request.getParameter("Version_Specific"));
		String Geography_specific=XHDBAdapter.checkNull(request.getParameter("Geography_Specific"));
		String Site_Specific=XHDBAdapter.checkNull(request.getParameter("Site_Specific"));
		String Application_specific=XHDBAdapter.checkNull(request.getParameter("Application_Specific"));
		String Version_Specific_txt=XHDBAdapter.checkNull(request.getParameter("Version_Specific_txt"));	
        String Geography_Specific_txt=XHDBAdapter.checkNull(request.getParameter("Geography_Specific_txt"));

		
		 Application_Specific_txt=XHDBAdapter.checkNull(request.getParameter("application_id1"));
				
        String Site_Specific_txt=XHDBAdapter.checkNull(request.getParameter("Site_Specific_txt"));



		ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
		String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1);
        
try
	{
	out.println("<head>");
      sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
     out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
      out.println("</head>");
     out.println("<body class='MESSAGE'>"); 
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of Interfacesatndaredqueryrecord.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }

	  try
		{
		  //System.out.println(p_mode+"ProfileId"+ProfileId+"Short_desc"+Short_desc+"LONG"+Long_desc+"S_code"+standard_code+"Specific_txt_v"+version_spcific+"TXT"+Version_Specific_txt+"Specific_txt1_g"+Geography_specific+"TXT"+Geography_Specific_txt+"Specific_txt_A"+Application_specific+"TXT"+Application_Specific_txt+"Site_Specific_txt"+Site_Specific+"TXT"+Site_Specific_txt+""+usr_added_by_id+""+usr_added_at_ws_no);
        oraclecallablestatement = connection.prepareCall("{ call Xg_prc.xh_standard_profile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
        //System.out.println("p_mode"+p_mode);
		
		oraclecallablestatement.setString(1,p_mode);

   //System.out.println("ProfileId"+ProfileId);
		oraclecallablestatement.setString(2,ProfileId);
 //System.out.println("Short_desc"+Short_desc);
		oraclecallablestatement.setString(3,Short_desc);

		//System.out.println("LONG"+Long_desc);
	    oraclecallablestatement.setString(4,Long_desc);
//System.out.println("standard_code"+standard_code);
        oraclecallablestatement.setString(5,standard_code);
//System.out.println("version_spcific"+version_spcific);
        oraclecallablestatement.setString(6,version_spcific);
//System.out.println("Version_Specific_txt"+Version_Specific_txt);
	    oraclecallablestatement.setString(7,Version_Specific_txt);
//System.out.println("Geography_specific"+Geography_specific);
		oraclecallablestatement.setString(8,Geography_specific);
////System.out.println("Geography_Specific_txt"+Geography_Specific_txt);
		oraclecallablestatement.setString(9,Geography_Specific_txt);
		//System.out.println("Application_specific"+Application_specific);
        oraclecallablestatement.setString(10,Application_specific);
		//System.out.println("Application_Specific_txt"+Application_Specific_txt);
        oraclecallablestatement.setString(11,Application_Specific_txt);
		//System.out.println("Site_Specific"+Site_Specific);
		oraclecallablestatement.setString(12,Site_Specific);
		//System.out.println("Site_Specific_txt"+Site_Specific_txt);
	    oraclecallablestatement.setString(13,Site_Specific_txt);
	
        oraclecallablestatement.setString(14,usr_added_by_id);	
		
        oraclecallablestatement.setString(15,usr_added_at_ws_no);	
	
	    oraclecallablestatement.registerOutParameter(16,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(17,java.sql.Types.VARCHAR);
	    oraclecallablestatement.execute();
        String status2 = oraclecallablestatement.getString(16);
		String status="";
        //System.out.println("Status2"+status2);

	if(oraclecallablestatement!=null) oraclecallablestatement.close();
	  
	   	if(status2.equals("0"))
		{
			connection.commit();

			out.println("<script>parent.frames[1].document.forms[0].Refresh.disabled=false;</script>");
			if(p_mode.equals("D"))
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1036", "XH") ;
				status = ((String) mesg.get("message"));

			}
			else
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				status = ((String) mesg.get("message"));
			}
		}
		else if(status2.equals("2"))
		{
		 	connection.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
			status = ((String) mesg.get("message"));
			
		}
	    else
		{
		 	connection.rollback();
		 	final java.util.Hashtable mesg = mm.getMessage(locale, "XH1042", "XH") ;
 		 	status = ((String) mesg.get("message"));
		 	out.println("<script>parent.frames[1].document.forms[0].Refresh.disabled=true;</script>");

		}
       	out.println("");
       	out.println(status);
       	out.println("");

       	out.println("</body>");  

		out.println("<script> </script>");
	}
	catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in Interfacesatndaredqueryrecord.jsp  :"+ex.toString());
		//exceptions=exceptions+"3"+"*"+ex.toString();
		//ex.printStackTrace(System.err);

	}
	try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ 
		System.out.println("Error in closing dbrealted statements in Interfacesatndaredqueryrecord.jsp :"+ex.toString());
		ex.printStackTrace(System.err); 
	}
	 //System.out.println("status "+status2);  
	 

//RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
       // reqDis.forward(request,response);
		
		

	/*	arrColumn.add(p_mode);
		arrColumn.add(standard_code);
		arrColumn.add(standard_desc);
		arrColumn.add(standard_type);
		arrColumn.add(msg_start);		
		arrColumn.add(msg_end);
		arrColumn.add(seg_start);
		arrColumn.add(seg_end);
		arrColumn.add(fld_separator);
		arrColumn.add(elmnt_separator);
  //	arrColumn.add(lang_id);*/
		   
				
        //RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
        //reqDis.forward(request,response);		


	

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
