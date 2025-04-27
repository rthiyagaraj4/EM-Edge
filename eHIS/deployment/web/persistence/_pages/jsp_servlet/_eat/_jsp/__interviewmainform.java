package jsp_servlet._eat._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.CommonBean;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;

public final class __interviewmainform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eat/jsp/InterviewMainForm.jsp", 1709114067741L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\t\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n<html>\n  <head>\n    <title></title>\n    \n    <meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n    <meta http-equiv=\"description\" content=\"this is my page\">\n    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n    \n    <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"./styles.css\">-->\n    \n  </head>\n  \n  <body>\n\t<FORM name=\"interviewForm\" id=\"interviewForm\" action=\"Interview.jsp\" method=\"GET\">\t \n\t<br>\n  <TABLE align=\"left\" border=\"1\" cellspacing=\"10\" width=\"200px\" height=\"\">\n\t\t\t\n\t\n\t\t\t<TR>\n\t\t\t\t<TD width=\"300\">First Name</TD>\n\t\t\t\t<TD>\n\t\t\t\t\t<INPUT type=\"text\" name=\"firstName\" id=\"firstName\" size=\"20\" />\n\t\t\t\t</TD></TR>\n\t\t\t<TR>\n\t\t\t\t<TD width=\"300\"><P></P><P>ShortName</P><P></P></TD>\n\t\t\t\t<TD>\n\t\t\t\t\t<INPUT type=\"text\" name =\"shortName\" maxlength=\"20\"></TD></TR>\n\t\t\t<TR>\n\t\t\t\t<TD>\n\t\t\t\t\t &nbsp;Date of Birth\n\t\t\t\t</TD><TD>\n\t\t\t\t\t<INPUT type=\"text\"  name =\"dob\"  \"maxlength=\"20\" value=\"dob\"></TD></TR>\n\t\t\t<TR>\n\t\t\t\t<TD width=\"300\" name=\"sex\">\n\t\t\t\t\t &nbsp;Sex\n\t\t\t\t</TD>\n\t\t\t\t<TD>\n\t\t\t\t\t\t<SELECT name=\"gender\" id=\"gender\">\n\t\t\t\t\t\t\t<OPTION value=\"male\">\n\t\t\t\t\t\t\t\tmale\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t<OPTION value=\"female\" selected>\n\t\t\t\t\t\t\t\tfemale\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t</SELECT>\n\n\n\t\t\t\t\t</TD>\n</TR>\n\t\t\t<TR>\n\t\t\t\t<TD width=\"300\">Location</TD>\n\t\t\t\t<TD width=\"200\">\n\t\n<select>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\n<option value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</option>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</select>\n\t</td>\n\n\t\t\t\t\t</td>\t\t\t\t\t\n\t</TR>\n\t\t\t<TR>\n\t\t\t\t<TD width=\"300\">Technology</TD>\n\t\t\t\t<TD>\n\n\t<select>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t<option value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</option>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</select>\n\t\t</TD>\n\t\t\t\t\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t\t<TD width=\"300\">Interview Date</TD>\n\t\t\t\t<TD>\n\t\t\t\t\t<INPUT type=\"text\" name=\"interviewdate\" id=\"interviewdate\" size=\"20\" />\n\t\t\t\t</TD></TR>\n\t\t\t<TR>\n\t\t\t\t<TD width=\"300\">Interviewed By</TD>\n\t\t\t\t<TD>\n\t\t\t\t\t<INPUT type=\"text\" name=\"interviewedBy\" id=\"interviewedBy\" size=\"20\" />\n\t\t\t\t</TD></TR></TABLE>\n\t\t\n\t\t<INPUT type=\"submit\" name=\"apply\" id=\"apply\" value=\"Apply\" />\n\t\t<P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P><P></P></body>\n</FORM>\n</html>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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

	
	Connection connection   = null ;
	PreparedStatement stmt = null ;
	Statement st =null ;
	ResultSet rs = null ;
	ResultSet location = null ;
	ResultSet technology = null ;

try{
			
			String sql1 ="select CITY_ID , CITY_NAME  from  INTERVIEW_CITY_LIST" ;
			String sql2 ="SELECT TECH_ID,TECH_NAME FROM TECH_LIST ORDER BY 2" ;
			String sql3 ="insert into INTERVIEW_CITY_LIST values(?,'?')";
	   		connection	= ConnectionManager.getConnection(request);
			st= connection.createStatement();
			location = st.executeQuery(sql1);
			technology = stmt.executeQuery(sql2);
			




            _bw.write(_wl_block2Bytes, _wl_block2);
	
	while(location.next())
	{

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(location.getString(1)));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(location.getString(2)));
            _bw.write(_wl_block5Bytes, _wl_block5);
	
	} 
	

            _bw.write(_wl_block6Bytes, _wl_block6);
	
		while(location.next())
		{
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(technology.getString(1)));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(technology.getString(2)));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
		} 
		
	
            _bw.write(_wl_block10Bytes, _wl_block10);

}catch ( Exception e ) {
System.err.println("Caught Exception error : "+e);
e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(st!=null) st.close();
		if(stmt!=null) stmt.close();
		if(connection!=null) ConnectionManager.returnConnection(connection,request);
	}catch(Exception es){es.printStackTrace();}
}


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
