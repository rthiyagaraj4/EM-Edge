package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import eCommon.XSSRequestWrapper;

public final class __medrecrequest extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedRecRequest.jsp", 1730264572875L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<html>\n\t\t<head>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\t\t\n\t\t\t<script src=\'../js/MedRecRequest.js\' language=\'javascript\'>\n\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'NO_OPER_STN_FOR_USER\',\'Common\'));\n\t\t\t\t\t\t\t//location.href=\'../../eCommon/jsp/home.jsp\';\n\t\t\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<iframe scrolling=\"no\" name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eMR/jsp/DiagProcedureRecodingCriteria.jsp?jsp_name=PaintDischargePatient.jsp&win_height=33.4&win_width=49.6&call_function=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&oper_stn_id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&oper_stn_id1=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&function_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&increment_rec_count=Y\' noresize frameborder=0 style=\'height:35vh;width:100vw\'></iframe><iframe scrolling=\"auto\" name=\'content\' id=\'content\' src=\'../../eCommon/html/blank.html\'  noresize frameborder=0 style=\'height:50vh;width:100vw\'></iframe><iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar err_msg=getMessage(\"RECODE_PRIVILEGE_NOT_DEFINED\",\"MR\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\talert(err_msg);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:40%;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe scrolling=\"no\" name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eMR/jsp/MedRecRequestCriteria.jsp?jsp_name=PaintDischargePatient.jsp&win_height=33.4&win_width=49.6&call_function=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' noresize frameborder=0 style=\'height:175%;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe scrolling=\"auto\" name=\'content\' id=\'content\' src=\'../../eCommon/html/blank.html\'  noresize frameborder=0 style=\'height:100vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe scrolling=\"no\" name=\'f_select\' id=\'f_select\' src=\'../../eMR/jsp/MedRecRequestButton.jsp\'  noresize frameborder=0 style=\'height:20%;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:50%;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'errFrame\' id=\'errFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:0%;width:100vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t</html>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
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
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String call_function=request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String fac_id					= (String) session.getValue( "facility_id" );
		String userid					= (String) session.getValue("login_user");
		String stage_no				= "";
		Connection con	= null;
		Statement stmt	= null;
		PreparedStatement pstmt	= null;
		Statement stmt1	= null;
		ResultSet rs	= null;
		ResultSet rs1	= null;
		String ca_install_yn = "N";
		String oper_stn_id = "";
		String oper_stn_id1 = "";
		try{
			if(call_function.equals("DIAG_RECODE")){	
					try{
						con		= ConnectionManager.getConnection(request);
						stmt		= con.createStatement();
						stmt1	= con.createStatement();
						rs			= stmt.executeQuery("SELECT install_yn FROM SM_MODULE WHERE module_id = 'CA'");	
						if ((rs != null) && (rs.next())){
							ca_install_yn = checkForNull(rs.getString("install_yn"),"N");
						}
						if(rs	 != null)   rs.close();
						if(stmt !=null) stmt.close();
					}catch(Exception exp){
						//out.println("Exception in CA Install.jsp : "+exp.toString());
						exp.printStackTrace();
					}
					stmt	= con.createStatement();
					rs = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','DIAG_PROC_RECODE_FOR_IP_YN') FROM dual") ;
					if(rs !=null && rs.next()){
						oper_stn_id=rs.getString(1);
						//out.println("<script>alert(\""+oper_stn_id+"\");</script>");

					}
					if(rs	 != null)   rs.close();
					if(stmt !=null) stmt.close();


					rs1 = stmt1.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','DIAG_PROC_RECODE_FOR_OP_YN') FROM dual") ;

					if(rs1 !=null && rs1.next()){
						oper_stn_id1=rs1.getString(1);
						//out.println("<script>alert(\""+oper_stn_id1+"\");</script>");
					}
					if(rs1	 != null)   rs1.close();
					if(stmt1 !=null) stmt1.close();
					if(oper_stn_id.equals("1") && oper_stn_id1.equals("1")){
            _bw.write(_wl_block4Bytes, _wl_block4);
}else if(oper_stn_id.equals("2") && oper_stn_id1.equals("2")){
							out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");			
					}else if(oper_stn_id.equals("3") && oper_stn_id1.equals("3")){
							out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");		
					}else  if(oper_stn_id.equals("4") && oper_stn_id1.equals("4")){
							out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(oper_stn_id.equals("5") && oper_stn_id1.equals("5")){
							out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else	if(!oper_stn_id.equals("") && !oper_stn_id1.equals("")){
							if(ca_install_yn.equals("Y")){		
										String allow_diag="";
										String allow_proc="";
										stmt1	= con.createStatement();
										rs1 = stmt1.executeQuery("SELECT ALLOW_RECODE_DIAG_YN,ALLOW_RECODE_PROC_YN FROM mr_parameter") ;
										if(rs1 !=null && rs1.next()){
											allow_diag = rs1.getString("ALLOW_RECODE_DIAG_YN");
											allow_proc = rs1.getString("ALLOW_RECODE_PROC_YN");
										}
										if(allow_diag.equals("Y") || allow_proc.equals("Y")){
												String tmp_stg_no="";
												String sql20="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP_DTL WHERE APPL_USER_ID='"+userid+"' AND FACILITY_ID='"+fac_id+"'";
												pstmt = con.prepareStatement(sql20);
												rs = pstmt.executeQuery();	
												while(rs.next()){
													tmp_stg_no = checkForNull(rs.getString("STAGE_NO"));
												}
												if(pstmt != null) pstmt.close();
												if(rs != null) rs.close();
												if(tmp_stg_no.equals("")){
													String sql_st="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP WHERE SPECIFIC_IND='*ALL' ORDER BY  STAGE_NO DESC";
													pstmt = con.prepareStatement(sql_st);
													rs		  = pstmt.executeQuery();	
													while(rs.next()){
														stage_no =checkForNull(rs.getString("STAGE_NO"));
													}
													if(pstmt != null) pstmt.close();
													if(rs != null) rs.close();
												}else{
													stage_no=tmp_stg_no;
												}
												if(!stage_no.equals("")){
													/*String locn_codes="";
													String LOCN_CODE_SQL="SELECT  LOCN_CODE FROM AM_OS_USER_LOCN_ACCESS_VW WHERE FACILITY_ID = '"+fac_id+"'AND OPER_STN_ID =(SELECT OPER_STN_ID FROM AM_USER_FOR_OPER_STN WHERE APPL_USER_ID = 'SUPERUSER'AND FACILITY_ID = '"+fac_id+"' AND FACILITY_ID = '"+fac_id+"' AND TRUNC (SYSDATE) BETWEEN TRUNC(NVL (EFF_DATE_FROM,SYSDATE ) )AND TRUNC (NVL (EFF_DATE_TO,SYSDATE)))AND APPL_USER_ID = '"+userid+"' AND DIAG_PROC_RECODE_FOR_IP_YN = 'Y'";
													pstmt = con.prepareStatement(LOCN_CODE_SQL);
													rs = pstmt.executeQuery();	
													while(rs.next()){
														locn_codes = locn_codes+"'"+checkForNull(rs.getString("LOCN_CODE"))+"'"+",";
													}
														request.setAttribute("locn_codes",locn_codes)
													if(pstmt != null) pstmt.close();
													if(rs != null) rs.close();*/
													
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(source));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oper_stn_id1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
											}else{
												out.println("<script>alert(getMessage('DIAG_PROC_REC_NO','MR'));</script>");
												out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
											}
							}else{
									out.println("<script>alert(getMessage('CA_NOT_INSTALLED','Common'));</script>");
									out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
							}
					}	
			}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(source));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block14Bytes, _wl_block14);
}	
		}catch(Exception exp){
			//out.println("Exception : "+exp.toString());
			exp.printStackTrace();
		}
		finally{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
