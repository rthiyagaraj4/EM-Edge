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
import webbeans.eCommon.XMLStringParser;

public final class __communicationclientgetprotocol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/CommunicationClientGetProtocol.jsp", 1727357126589L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
 

		Connection con1	= null;
		Statement stmt1		= null;
		ResultSet rst1		= null;
	    StringBuffer evntList   = new StringBuffer();				    
		String appl_id = "";																					    
		String fac_id = ""; 
		//String comm_type = "";
		String mod_id = "";
		String appl_name = "";
		//String evnt_name = "";
		String mod_name = "";
		String fac_name = "";
		String ProtocolID="";


	//	int errFlag				= 0;
	//	String exceptions		= "";																				   
		try {
		con1	= ConnectionManager.getConnection(request);
		String func_mode			= request.getParameter("func_mode");
			
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
																	 
		if(func_mode!= null && func_mode.equals("getProtocol")) {
			String base_param1		 = (String) hash.get( "base_unit1" );
			String base_param2		 = (String) hash.get( "base_unit2" );
			String base_param3		 = (String) hash.get( "base_unit3" );
//					System.out.println("AdmOrEvntLst base_param1 : "+base_param1);
//					System.out.println("AdmOrEvntLst base_param2 : "+base_param2);
//			String prtcl_link_id		 = (String) hash.get( "base_unit" );
//			String process_id		 = (String) hash.get( "base_unit" );
			String sql1 = "";
				
          																						 


 /*        if(process_id.equals("XHGNCRTR") ||  process_id.equals("XHGENMESSAGEBUILDER" ) ){ 
				sql1 = "SELECT event_type  FROM xh_event_type WHERE communication_type in('O','*')  AND interface_yn='Y' ORDER BY 1 ";

		 }
		 else if( process_id.equals("XHGENMESSAGELOADER") ){
			 	sql1 = "SELECT event_type,event_name FROM xh_event_type WHERE communication_type in('I','*') AND event_type!='A19'  AND interface_yn='Y' ORDER BY 1 ";
		 } */
	
			 sql1 = "SELECT  PROTOCOL_ID From XH_PROTOCOL_LINK where APPLICATION_ID='"+base_param2+"' and PROTOCOL_LINK_ID='"+base_param1+"'   ";
		
		
		try{	 
		//System.out.println(" (CommunicationClientGetProtocol.jsp:sqlProtocolQuery) : "+sql1);
//			con1	= ConnectionManager.getConnection(request);
			stmt1	= con1.createStatement();
			rst1	= stmt1.executeQuery(sql1);
			int rwCnt = 0;
			
			while(rst1.next()){
			ProtocolID=rst1.getString(1);	
			}
	}catch(Exception e){
			System.err.println("Err Msg in CommunicationClientGetProtocol.jsp : "+e);
	}finally{
		
		//	out.println("setEvntList('"+evntList+"')");

		//out.println("setEvntList('"+evntList+"','"+mod_id+"','"+mod_name+"')");

			  out.println("setProtocolId('"+ProtocolID+"','"+base_param3+"')");	  		  	//out.println("setEvntList('"+appl_id+"','"+fac_id+"','"+evntList+"','"+comm_type+"','"+mod_id+"','"+appl_name+"','"+mod_name+"','"+evnt_name+"','"+fac_name+"')");

			if(rst1!=null)rst1.close();
			if(stmt1!=null)stmt1.close();			
//			ConnectionManager.returnConnection(con1);
	}
			
} // end of  evntlist

 // END OF getCommMode

	 

		

		}
		catch(Exception e){
					System.err.println("Err2 Msg in AdminOracleJobProcessAction.jsp : "+e);
		}finally{
					ConnectionManager.returnConnection(con1);
		}


            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
