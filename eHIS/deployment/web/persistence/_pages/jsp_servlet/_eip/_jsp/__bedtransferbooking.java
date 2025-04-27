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
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __bedtransferbooking extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BedTransferBooking.jsp", 1725272150509L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n    \n</head>\n<script>\n\tfunction reset()\n\t{\n\t\tparent.frames[2].frames[1].document.forms[0].reset();\n\t\tif (frames[1].document.forms[0].searchby != null)\n\t\t\t{\n\t\t\t\tif (frames[1].document.forms[0].soundex.value!=\'\')\n\t\t\t\t{\n\t\t\t\t\tframes[1].document.forms[0].searchby.value=\"\";\n\t\t\t\t\tframes[1].document.forms[0].searchby.disabled=true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tframes[1].document.forms[0].searchby.disabled=false;\n\t\t\t\t\tframes[1].document.forms[0].searchby.value=\"S\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tparent.frames[2].frames[1].document.forms[0].search.disabled = false;\n\t\tparent.frames[2].frames[2].location.href = \"../../eCommon/html/blank.html\";\n\t}\n</script>\n\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t        <iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\'../jsp/InpatientLookupCriteria.jsp?function_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&jsp_name=PaintBedBookingTransfer.jsp&win_height=33.4&win_width=49.6&call_function=RequestforTransfer&wherecondn=ROUTINE_TFR_YN&oper_stn_id=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:22vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod1\' id=\'f_query_add_mod1\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:55vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'desc_frame\' id=\'desc_frame\' \tsrc=\'QuerySearchResultFrames.jsp?step=bedbook\' frameborder=0 scrolling=\'auto\' noresize style=\'height:5vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' noresize style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</html>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		request.setCharacterEncoding("UTF-8");
		//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String facilityId	= (String)session.getValue("facility_id");
        String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		String loginUser = (String)session.getValue("login_user");		
		String locncode = request.getParameter("location_code");
			if(locncode == null) locncode= "";

		Connection con  = null;
		ResultSet rs 	= null; 
		Statement stmt 	= null;
		PreparedStatement pstmt = null;
        ResultSet rset     = null;

		String oper_stn_id = "";
		Statement stmt_opr		= null;
		Statement stmt_clinic	= null;
		Statement stmt_srl_no	= null;	
		ResultSet rset_opr 		= null;
		ResultSet rset_clinic	= null;
		ResultSet rs_srl_no     = null; 
		String retVal           = "";

		try{
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facilityId+"' ") ;
			if(rs.next())
			{
			pstmt = con.prepareStatement("SELECT AM_OPER_STN_ACCESS_CHECK(?,?,'N','','ROUTINE_TFR_YN') from dual");
			pstmt.setString(1,facilityId);
		    pstmt.setString(2,loginUser);
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				retVal = rset.getString(1);
			}
			
            if(retVal.equals("1")){
				out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			else if(retVal.equals("2")){
				out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
            }
			else if(retVal.equals("3")){
					out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
	                out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
            }else  if(retVal.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(retVal.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
            else if((!retVal.equals("1")) && (!retVal.equals("2")) && (!retVal.equals("3")) && (!retVal.equals("4")) && (!retVal.equals("5")))
			{		
				StringBuffer sql_srl_next = new StringBuffer();
				sql_srl_next.append("Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ");
				int srl_no=0;
				stmt_srl_no	=	con.createStatement();
				rs_srl_no	=	stmt_srl_no.executeQuery(sql_srl_next.toString());	
				if(rs_srl_no != null)
				if(rs_srl_no.next())
					srl_no	=	rs_srl_no.getInt(1);
				if(srl_no != 0)
				{
					
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(source));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
				}
				else
				{
				    out.println("<script>alert(getMessage('BED_BKG_SRL_CTRL_NOT_DEFINED','IP'))</script>");
					out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
				}
			  }
	}
	else
	{
		out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
}catch(Exception e){
	//out.println("Exception in tryCatch : "+ e.toString());
	e.printStackTrace();
	}
finally{
		try
	{

		if(rs!=null)			rs.close();
		if(rs_srl_no!=null)     rs_srl_no.close();
		if(rset_opr!=null)      rset_opr.close();
		if(rset_clinic!=null)     rset_clinic.close();
		if(stmt!=null)			stmt.close();
		if(stmt_opr!=null) 		stmt_opr.close();
		if(stmt_clinic!=null) 	stmt_clinic.close();
		if(stmt_srl_no!=null)   stmt_srl_no.close();	
	}
	catch(Exception e)
	{
		//out.println("Exception in tryCatch : "+ e.toString());
		e.printStackTrace();
		}
			ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
