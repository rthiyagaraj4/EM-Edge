package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __populateteam extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/PopulateTeam.jsp", 1710914274648L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t\n\t\tvar element =parent.frames[0].document.createElement(\'OPTION\');\n\t\telement.text = \'   ----- Select -----  \';\n\t\telement.value= \'\';\n\t\tdocument.forms[0].team.add(element);\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\tvar element = parent.frames[0].document.createElement(\'OPTION\');\n\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\t\telement.value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="$";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\tdocument.forms[0].team.add(element);\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
    	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
    	 hash = (Hashtable)hash.get("SEARCH") ;
    	 
	String facilityID =(String) hash.get("facilityID");
	//String sql="";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		con = ConnectionManager.getConnection(request);
	
	
            _bw.write(_wl_block1Bytes, _wl_block1);
					
	pstmt 	= con.prepareStatement( "Select Team_Id, Short_Desc, Speciality_code, Speciality_Desc from am_medical_team_vw where Facility_Id ='"+facilityID+"' and eff_Status = 'E' order by Short_Desc " ) ;
	rs = pstmt.executeQuery() ;
	String str1 = "";
	String str2 = "";
	String speciality_code="",speciality_desc="";
	if( rs != null ) 
	{
		while( rs.next() ) 
		{
			str1 = rs.getString( "Short_Desc" ) ;
			str2 = rs.getString( "Team_Id" );
			speciality_code= rs.getString("speciality_code");
			speciality_desc= rs.getString("speciality_desc");
			
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);
	}
	}

    hash.clear();
	}catch(Exception e){}
	finally
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
