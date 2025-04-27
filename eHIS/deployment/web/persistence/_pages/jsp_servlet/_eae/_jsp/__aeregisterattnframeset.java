package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aeregisterattnframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AERegisterAttnFrameset.jsp", 1726019937539L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script language=\'javascript\' src=\'../../eAE/js/AERegisterAttn.js\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t<iframe name=\'patientFrame\' id=\'patientFrame\' src=\'../../eAE/jsp/AERegisterAttnSearch.jsp?dflt_time_reg_auto_update=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&dflt_emer_follow_type_code=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&oper_stn_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:6vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'patientLine\' id=\'patientLine\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\' style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'patientDetailsFrame\' id=\'patientDetailsFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:86vh;width:100vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String params				= checkForNull(request.getQueryString()) ;
		String facilityId			= checkForNull((String)session.getValue("facility_id"));
		String user_id 	 			= checkForNull((String)session.getValue("login_user")) ;
        Connection	con             = null;
		java.sql.Statement stmt     = null;
        ResultSet rset              = null ;
		
		String dflt_emer_follow_type_code = checkForNull(request.getParameter("dflt_emer_follow_type_code")); // added by mujafar for KDAH-CRF-0526
		String dflt_time_reg_auto_update = checkForNull(request.getParameter("dflt_time_reg_auto_update"));
		
      try{
			con = ConnectionManager.getConnection(request);
	/*	String StartDate1           = "";
		String AllowedDate          = "";
		String bl_interface_yn      = "";
		String visit_back_yn		= "";
		String start_date			= "";
		String sys_date             = "";
		String reg_attendance_for_inpat_yn = "";
		StringBuffer sqlDate = new StringBuffer();
 
			 Thursday, April 22, 2010 venkat s PE_EXE
				 sqlDate.append("select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss')sys, ");
				   sqlDate.append("to_char((sysdate -(1/(24*60*60))*3600*MAX_HOURS_ALLOW_INSERT),'dd/mm/yyyy hh24:mi:ss')sys1, ");
				   sqlDate.append(" BILLING_INTERFACED_YN, ");
				   sqlDate.append(" VISIT_BACKDATING_ALLOWED_YN,  ");
				   sqlDate.append(" REG_ATTENDANCE_FOR_INPAT_YN,  ");
				   sqlDate.append(" TO_CHAR(SYSDATE-(DECODE(VISIT_BACKDATING_ALLOWED_YN,");
				   sqlDate.append(" 'Y',MAX_HOURS_ALLOW_INSERT,0)*60)/1440,'dd/mm/yyyy hh24:mi')  start_date,to_char(trunc(sysdate),'dd/mm/yyyy') sys_date  ");
				   sqlDate.append(" from ae_param  where operating_facility_id= ? ");
				   if (pstmt != null) pstmt.close();
				   pstmt  = con.prepareStatement(sqlDate.toString());
		   
				   pstmt.setString(1,facilityId);
				 
				   rs = pstmt.executeQuery();
				   if (rs != null)
				   {
					 if(rs.next()) 
					  {
						StartDate1          = checkForNull(rs.getString("sys"));
						params  = params+"&StartDate1="+StartDate1;
						AllowedDate         = checkForNull(rs.getString("sys1"));
						params  = params+"&AllowedDate="+AllowedDate;
						bl_interface_yn     = checkForNull(rs.getString("BILLING_INTERFACED_YN"));
						params  = params+"&bl_interface_yn="+bl_interface_yn;
						visit_back_yn		= checkForNull(rs.getString("VISIT_BACKDATING_ALLOWED_YN"));
						params  = params+"&visit_back_yn="+visit_back_yn;
						reg_attendance_for_inpat_yn		= checkForNull(rs.getString("REG_ATTENDANCE_FOR_INPAT_YN"));
						params  = params+"&attendance_for_inpat_yn="+reg_attendance_for_inpat_yn;
						start_date			= checkForNull(rs.getString("start_date"));
						params  = params+"&start_date="+start_date;
						sys_date            = checkForNull(rs.getString("sys_date")); 
						params  = params+"&sys_date="+sys_date;
					  }
				   }
				   if(rs != null)  rs.close();
				   if(pstmt != null) pstmt.close();  
				   */

					/**********   Added new for Check    ***********/
                   stmt	= con.createStatement();	
				   rset	= stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+user_id+"','C','','REGISTER_VISIT_YN') FROM dual") ;
				   rset.next();

				   String OsVal=rset.getString(1);

					if(OsVal.equals("1"))
						{
							out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else if(OsVal.equals("2"))
						{
							out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else  if(OsVal.equals("3"))
						{
							out.print(" <script>alert(getMessage('AE_REG_ATTN_NOT_ALL_OPERSTN','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else  if(OsVal.equals("4"))
						{
							out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else  if(OsVal.equals("5"))
						{
							out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}
						else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
						{				   
						
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(dflt_time_reg_auto_update));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dflt_emer_follow_type_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(OsVal));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);
			}
                   if(rset != null)  rset.close();
				   if(stmt != null) stmt.close();
				
				 /*  if(rs != null)  rs.close();
				   if(pstmt != null) pstmt.close(); 
				   if((sqlDate != null) && (sqlDate.length() > 0))
				   {
					 sqlDate.delete(0,sqlDate.length());
				   }
				   */
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
