package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;

public final class __assigntreatpractpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AssignTreatPractPopulate.jsp", 1709117711801L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\t <script>\n\tvar len=parent.document.frames[1].document.frames[1].document.forms[0].speciality_code.length;\n\tvar i=1;\n\twhile(i<len)\n\t{\n\t\tlen=parent.document.frames[1].document.frames[1].document.forms[0].speciality_code.length;\n\t\tparent.document.frames[1].document.frames[1].document.forms[0].speciality_code.remove(i)\n\t}\t\t\n\t  \t\n\t\tvar ps=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\';\t\t\n\t</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\t \n\t\t<script>\n\t\t\tvar str2=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"; \n\t\t\tvar str1=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n     \t\t\tvar element =parent.document.frames[1].document.frames[1].document.createElement(\'OPTION\');          \n\t\t\telement.text = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"; \n\t\t\telement.value= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t                \n\t\t\tif(ps==str1)\n\t\t\telement.selected=true\t\n    \t\t</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String practitionerid = request.getParameter("practitioner_id");
	String opfacilityid=(String)session.getValue("facility_id");

	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	try{
		   con = ConnectionManager.getConnection(request);
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
	stmt= con.createStatement();	
	String ps ="";	
	String sql1="Select primary_speciality_code from AM_PRACTITIONER where practitioner_id='"+practitionerid+"' ";
	rs = stmt.executeQuery(sql1) ;
	
	while (rs.next())
	{			
		ps = rs.getString(1);	//gets the value of primary_speciality_code
	} 
	
	 if(stmt != null) stmt.close();
	 if(rs != null) rs.close();

	 stmt 	= con.createStatement() ;
	 String sql2="Select speciality_code,speciality_short_desc  from AM_PRACT_FOR_SPECIALITY_VW where facility_id ='"+opfacilityid+"' and practitioner_id='"+practitionerid+"' union  Select a.primary_speciality_code speciality_code, b.short_desc speciality_short_desc from AM_PRACT_FOR_FACILITY_VW a, am_speciality b where b.speciality_code = a.primary_speciality_code and a.operating_facility_id ='"+opfacilityid+"' and a.practitioner_id='"+practitionerid+"' order by 2 ";
	 rs = stmt.executeQuery(sql2) ;	
	 	 
	 if( rs != null ) 
  	 {

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(ps));
            _bw.write(_wl_block3Bytes, _wl_block3);
		
		
		String str1 = "";
		String str2 = "";
			
		while( rs.next() ) 
		{		  
		 	str1 = rs.getString( "speciality_code" ) ;
		 	str2 = rs.getString( "speciality_short_desc" );

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block8Bytes, _wl_block8);
   
			out.println("<script>parent.document.frames[1].document.frames[1].document.forms[0].speciality_code.add(element);</script>");

	     }	   		
	   }
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		ConnectionManager.returnConnection(con,request); 
		
		
	}
		out.println("</script></head><body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'></body></html>");		
	

            _bw.write(_wl_block9Bytes, _wl_block9);
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
