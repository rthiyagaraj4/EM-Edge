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

public final class __transferpatient extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/TransferPatient.jsp", 1720178772271L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script>\t\n\t \n\t<script language =\"javascript\" src=\"../js/EmergencyTransfer.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>//alert(\"opening TransferPatient.jsp\");</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\'  style=\'height:10vh;width:100vw\'></iframe>\n\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\'../jsp/InpatientLookupCriteria.jsp?function_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&jsp_name=PaintEmergencyTransfer.jsp&win_height=33.4&win_width=49.6&function_name=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&call_function=TransferPatient&wherecondn=EMERGENCY_TFR_YN&bl_install_yn=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&bedBlock_normal=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&bed_block_period_max=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&max_blk_type=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&oper_stn_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' frameborder=0 scrolling=\'no\'  style=\'height:22vh;width:100vw\'></iframe>\n\t\t<iframe name=\'f_query_add_mod1\' id=\'f_query_add_mod1\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\'  style=\'height:50vh;width:100vw\'></iframe>\n\t\t<iframe name=\'desc_frame\' id=\'desc_frame\' \tsrc=\'QuerySearchResultFrames.jsp?step=bedbook\' frameborder=0 scrolling=\'auto\'  style=\'height:5vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\'  style=\'height:12vh;width:100vw\'></iframe>\n\t\t\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>alert(getMessage(\'SETUP_BOOK_SRL_CTL\',\"IP\"))\n\t\t\tdocument.location.href =\'../../eCommon/jsp/dmenu.jsp\'</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</html>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue  
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String function_name 	= request.getParameter( "function_name" ) ;
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String facilityId		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");	
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";


	Connection con  = null;
	ResultSet rset	= null; 
	ResultSet rset1	= null; 
	Statement stmt 	= null;
	Statement stmt1	= null;
	StringBuffer sqlQuery	= new StringBuffer();
	int bed_block_period_max= 0;
	String max_blk_type		= "";
	String bedBlock_normal  = "";
	String bl_install_yn	= "";
	String bed_blk_period_max = "";
	int srl_no=0;
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt1	= con.createStatement();
		rset1	= stmt1.executeQuery("select nvl(bl_interfaced_yn,'N') bl_interfaced_yn,BED_BLOCK_PERIOD_MAX,BED_BLOCK_PERIOD_MAX_TYPE,bed_block_period_normal from ip_param where facility_id='"+facilityId+"' ") ;
		if(rset1.next())
		{
			bl_install_yn			= rset1.getString("bl_interfaced_yn");
			bedBlock_normal			= rset1.getString("bed_block_period_normal");
			bed_block_period_max	= rset1.getInt("BED_BLOCK_PERIOD_MAX");
			max_blk_type			= rset1.getString("BED_BLOCK_PERIOD_MAX_TYPE");

			if(max_blk_type.equals("D"))
				bed_block_period_max=(bed_block_period_max)*24;
			bed_blk_period_max = ""+bed_block_period_max;
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());

            stmt = con.createStatement();
			//rset1 = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','EMERGENCY_TFR_YN') FROM dual") ;
			
			rset1 = stmt.executeQuery("Select count(*) , AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','EMERGENCY_TFR_YN') from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ") ;
			rset1.next();
	     	srl_no	=	rset1.getInt(1);
			String OsVal=rset1.getString(2);
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
			}else	if(!OsVal.equals(""))
	{
	/*
	if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
	sqlQuery.append("Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ");
	stmt	=	con.createStatement();
	rset	=	stmt.executeQuery(sqlQuery.toString());	
	if(rset !=null && rset.next())
	srl_no	=	rset.getInt(1);
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	*/
	if(srl_no != 0)
			{

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bedBlock_normal));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bed_blk_period_max));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(max_blk_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
		else
		{
            _bw.write(_wl_block13Bytes, _wl_block13);
	}
       }
	}
	else
            out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}catch(Exception e){/* out.println("Exception in tryCatch TransferPatient: "+ e.toString()); */ e.printStackTrace();}
	
	finally{
		try
		{
			if(rset!=null) rset.close();
			if(rset1!=null) rset1.close();
			if(stmt!=null) stmt.close();
			if(stmt1!=null) stmt1.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception ee)
		{/* out.println("Error while closing the connections : " + ee.toString()); */ ee.printStackTrace();}
	}

            _bw.write(_wl_block14Bytes, _wl_block14);
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
