package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;

public final class __swappatientbeds extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/SwapPatientBeds.jsp", 1720005718329L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t\n\t<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\n\t<script language =\'javascript\' src=\'../../eIP/js/SwapPatientBeds.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n    \t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\' noresize style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t\tsrc=\'../jsp/SwapPatientBedsCriteria.jsp?jsp_name=PaintDischargePatient.jsp&win_height=33.4&win_width=49.6&call_function=SWAP_PAT_BED&wherecondn=SWAP_BED_YN&oper_stn_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:15vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'f_query_add_mod1\' id=\'f_query_add_mod1\' \t\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:49vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'f_query_add_mod2\' id=\'f_query_add_mod2\' \t\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize style=\'height:20vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' noresize style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>alert(getMessage(\'SETUP_BOOK_SRL_CTL\',\'IP\'))\n\t\t\t\tdocument.location.href =\'../../eCommon/jsp/dmenu.jsp\'</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\talert(getMessage(\'IP_PARAM_NOT_FOUND\',\'IP\'));\n\t\t\tdocument.location.href= \'../../eCommon/jsp/dmenu.jsp\'\n\t\t</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n</html>\n\n";
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	String url				= "../../eCommon/jsp/commonToolbar.jsp?";
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String facilityId		= (String)session.getValue("facility_id");
	String facility = (String) session.getValue( "facility_id" ) ;
	String loginUser		= (String)session.getValue("login_user");
	Connection con			= null;
	//ResultSet rset 			= null; 
	ResultSet rs1 			= null; 
	//Statement stmt 			= null;
	Statement stmt1			= null;
	String OsVal			="";
	//StringBuffer sqlSb		= new StringBuffer();
	int srl_no				= 0;
try
{
	con		= ConnectionManager.getConnection(request);	
	stmt1	= con.createStatement();		
	//rs1		= stmt1.executeQuery("select 1 from IP_PARAM where facility_id='"+facilityId+"' ") ;
	/*Wednesday, June 02, 2010 , modified for PE*/
	rs1		= stmt1.executeQuery("select 1,(Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T')cnt,(AM_OPER_STN_ACCESS_CHECK('"+facility+"','"+loginUser+"','N','','SWAP_BED_YN')) OsVal from IP_PARAM where facility_id='"+facilityId+"' ") ;
	if(rs1.next())
	{	
		
		srl_no	=	rs1.getInt("cnt");
		OsVal	=	rs1.getString("OsVal");
		/* stmt	= con.createStatement();	
		rset	= stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facility+"','"+loginUser+"','N','','SWAP_BED_YN') FROM dual") ;
		rset.next();
	    OsVal=rset.getString(1); Friday, June 11, 2010 PE_EXE venkat S*/

            if(OsVal.equals("1"))
			{
			out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else if(OsVal.equals("2"))
			{
			out.print(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("3"))
			{
			out.print(" <script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
            else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
	        {
	        /*Wednesday, June 02, 2010 , commented for PE*/
			 /*if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
			sqlSb.append("Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ");
			int srl_no=0;
			stmt		=	con.createStatement();
			rset		=	stmt.executeQuery(sqlSb.toString());	
			if(rset != null)
			if(rset.next())
			srl_no	=	rset.getInt(1);*/
			if(srl_no != 0)
			{	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block6Bytes, _wl_block6);

			}
			else
			{
            _bw.write(_wl_block7Bytes, _wl_block7);
	}
		}
	}else {
            _bw.write(_wl_block8Bytes, _wl_block8);
	}
	//if(rset!=null)rset.close();
	//if(stmt!=null)stmt.close();

}catch(Exception e)
{
	out.println("Exception in tryCatch : "+ e.toString());
}

finally
{
	try
	{
		ConnectionManager.returnConnection(con,request);
		if(rs1!=null)  rs1.close();
	//	if(rset!=null) rset.close();
	//	if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
		
	}catch(Exception e)
	{
		out.println("Error while closing the connections:"+ e.toString());
	}
}

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
