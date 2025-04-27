package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __transferpatientin extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/TransferPatientIn.jsp", 1720165476457L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script>\t\n\t \n</head>\n<script>\n\tfunction reset()\n\t{\n\t\tparent.frames[2].frames[1].document.forms[0].reset();\n\t\tif (frames[1].document.forms[0].searchby != null)\n\t\t{\n\t\t\tif (frames[1].document.forms[0].soundex.value!=\'\')\n\t\t\t{\n\t\t\t\tframes[1].document.forms[0].searchby.value=\"\";\n\t\t\t\tframes[1].document.forms[0].searchby.disabled=true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tframes[1].document.forms[0].searchby.disabled=false;\n\t\t\t\tframes[1].document.forms[0].searchby.value=\"S\";\n\t\t\t}\n\t\t}\n\t\tparent.frames[2].frames[2].location.href = \"../../eCommon/html/blank.html\";\n\t}\n</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' \tsrc=\'../jsp/InpatientLookupCriteria.jsp?function_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&jsp_name=TransferPatientInFrames.jsp&win_height=32.5&win_width=49.6&call_function=TransferPatientIn&wherecondn=TRANSFER_IN_PATIENT_YN&oper_stn_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:36vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod1\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:42vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'desc_frame\' src=\'QuerySearchResultFrames.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:4vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' noresize style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:36vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod1\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:46vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t<iframe name=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' noresize style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'SETUP_BOOK_SRL_CTL\',\'IP\'))\n\t\t\t\t\t\t\tdocument.location.href =\'../../eCommon/jsp/dmenu.jsp\'\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</html>\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityId = (String)session.getValue("facility_id");
	String loginUser = (String)session.getValue("login_user");		
	String locncode = request.getParameter("location_code");
		if(locncode == null) locncode= "";
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";

	Connection con			= null;
	ResultSet rs 			= null; 
	Statement stmt 			= null;
	Statement stmt_opr		= null;
	Statement stmt_clinic	= null;
	ResultSet rset_opr 		= null;
	ResultSet rset_clinic	= null;
	String priotity_status  = "N";
	int srl_no				= 0;
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		rs = stmt.executeQuery("select PRIORITY_APPLICABLE_YN from ip_param where facility_id='"+facilityId+"' ") ;
		if(rs.next())
		{
			if(rs != null)
			{
				priotity_status=rs.getString("PRIORITY_APPLICABLE_YN");
				if(priotity_status == null) priotity_status="N";
			}

			stmt = con.createStatement();
			/*Tuesday, May 04, 2010 , modified for PE*/
			//rs = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','TRANSFER_IN_PATIENT_YN') FROM dual") ;
			rs = stmt.executeQuery("Select count(*) ,AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+loginUser+"','N','','TRANSFER_IN_PATIENT_YN') from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T'") ;
			rs.next();
			srl_no	=	rs.getInt(1);
			String OsVal=rs.getString(2);
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
					/*Tuesday, May 04, 2010 , commnted for PE*/
					/*
					String sql_srl_next="Select count(*) from IP_BED_BOOKING_SRL_CTRL where facility_id='"+facilityId+"' and booking_type='T' ";
					
					stmt1	=	con.createStatement();
					rs1		=	stmt1.executeQuery(sql_srl_next);	
					if(rs1 !=null && rs1.next())
					srl_no	=	rs1.getInt(1);

					if(rs1!=null) rs1.close();
					if(stmt1!=null) stmt1.close();
					*/
					if(srl_no != 0)
					{

	/*					String QUERY_PRIORITY_APPLICABLE=" select PRIORITY_APPLICABLE_YN from ip_param where facility_id='"+facilityId+"' ";

						stmt_pri=con.createStatement();
						rs_pri=stmt_pri.executeQuery(QUERY_PRIORITY_APPLICABLE);

						if(rs_pri != null && rs_pri.next())
						{
							priotity_status=rs_pri.getString("PRIORITY_APPLICABLE_YN");
							if(priotity_status == null) priotity_status="N";
						}
						if(rs_pri!=null) rs_pri.close();
						if(stmt_pri!=null) stmt_pri.close();
	*/
						if(priotity_status.equals("Y"))
						{	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
						else
						{	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block12Bytes, _wl_block12);
	}	
            _bw.write(_wl_block13Bytes, _wl_block13);
	}
					else
					{	
            _bw.write(_wl_block14Bytes, _wl_block14);
	}
				}
				
		
		}else
		{
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(rset_opr !=null )rset_opr.close();
		if(rset_clinic!=null) 	rset_clinic.close();
		if(stmt_opr!=null) 		stmt_opr.close();
		if(stmt_clinic!=null) 	stmt_clinic.close();
	
	}catch(Exception e){
		
		e.printStackTrace();
		}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
