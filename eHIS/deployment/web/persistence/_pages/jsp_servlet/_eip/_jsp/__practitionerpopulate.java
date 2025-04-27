package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;

public final class __practitionerpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PractitionerPopulate.jsp", 1709117844696L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get("SEARCH") ;
	
	String practid = request.getParameter("ippractid");
	
	String facilityId	= (String) session.getValue("facility_id");
	String dateVal = request.getParameter("dateVal");
		if(dateVal == null) dateVal= "";
	String booking = request.getParameter("booking");
		if(booking == null) booking ="";
	String expdate = request.getParameter("expdate");
		if(expdate == null) expdate ="";		
  
		
		
	
	Connection con= null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	PreparedStatement pstmt1 =null;
	ResultSet rs1 = null;

try{	
	con = ConnectionManager.getConnection(request);	
	out.println("<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	String selectsql = "select distinct(a.short_desc) short_desc ,a.team_id,b.practitioner_id from 	"+
					" am_medical_team a,am_pract_for_team b   where  				"+
					" a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id 		"+
					" and b.practitioner_id ='"+practid+"' and b.team_id=a.team_id";
	pstmt 	= con.prepareStatement( selectsql ) ;
	rs = pstmt.executeQuery() ;
	String str1 = "";
	String str2 = "";
	if( rs != null ) 
	{
	    if(booking.equals("booking"))
	    { 
	    while( rs.next() ) 
		{
			str1 = rs.getString( "team_id" ) ;
			str2 = rs.getString( "short_desc" );
			out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
				"element.text = \""+str2+"\";"+ 
				"element.value= \""+str1+"\";"+
				"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
		}		
	    }
	    else if(booking.equals("admit"))
	    {
		while( rs.next() ) 
		{
			str1 = rs.getString( "team_id" ) ;
			str2 = rs.getString( "short_desc" );
			out.println(	"<script> var element = parent.f_query_add_mod.document.frames[2].document.createElement('OPTION');"+
				"element.text = \""+str2+"\";"+ 
				"element.value= \""+str1+"\";"+
				"parent.f_query_add_mod.document.frames[2].document.forms[0].team_id.add(element);</script>");
		}
	     }

	   if(booking.equals("transfer"))
	  {
	   while( rs.next() ) 
		{
			str1 = rs.getString( "team_id" ) ;
			str2 = rs.getString( "short_desc" );
			out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
				"element.text = \""+str2+"\";"+ 
				"element.value= \""+str1+"\";"+
				"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
		}		     
	  }
	}
	pstmt.close() ;      		

		out.println("</script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'></body></html>");
	
	

   if(expdate.equals("expdate"))
    {				
	if(!dateVal.equals(""))
	{	
		pstmt1 	= con.prepareStatement( "select to_char(sysdate+'"+dateVal+"','dd/mm/rrrr hh24:mi') disdate from dual");
		rs1 = pstmt1.executeQuery();
		if(rs1.next())
		{
			String Expdate = rs1.getString("disdate");
			out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].expecteddischargedate.value = '"+Expdate+"';parent.f_query_add_mod.document.frames[2].document.forms[0].circumstance_of_injury.focus();</script>");				
		}
	}
	else
	{
			out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].expecteddischargedate.value = ''</script>");				
	
	}
    }
	
		
	
}catch(Exception e){/* out.println("Exception in tryCatch : "+ e.toString()); */ e.printStackTrace();}

	finally{
	 	ConnectionManager.returnConnection(con,request);	

		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		if(pstmt1!=null) pstmt1.close();
		if(rs1!=null) rs1.close();
	}
  

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
