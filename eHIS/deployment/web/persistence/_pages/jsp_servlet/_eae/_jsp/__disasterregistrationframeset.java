package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __disasterregistrationframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/DisasterRegistrationFrameSet.jsp", 1709716133539L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n<Script language=\'javascript\' src=\'../../eCommon/js/common.js\'></Script>\n<Script language=\'javascript\' src=\'../../eAE/js/DisasterPatient.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t</head>\n\t\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'DisasterRegistrationMain.jsp?params=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0  scrolling=\'auto\' style=\'height:83vh;width:100vw\'></iframe><iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
    String source = url + params ;
	
	String module_id				= request.getParameter("module_id");
	
	String fac_id    	= (String) session.getValue( "facility_id" ) ;
	String user_id 	 	= (String)session.getValue("login_user") ;
	
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	Connection con                  =   null;
	// Thursday, May 20, 2010 PE_EXE venkat s
	String OsVal				="";
	String billing_interfaced_yn = "";
	String clinic_code			= "";
	String service_code			= "";
	String visit_type			= "";
	String pry_zone_for_dis_regn			= "";
	String un_adult_age_for_dis_regn		= "";
	String Site								= "";
	String emer_val_sr					    = "";
	String five_level_triage_appl_yn		= "N";
	int max_pat_in_disaster_regn			= 0;
	
	String dist_pat_ser_grp=""; //Added for this CRF ML-MMOH-CRF-0466


	try{
            con=ConnectionManager.getConnection(request);
			//Below query modified for this CRF ML-MMOH-CRF-0466
			String sql = " select  billing_interfaced_yn billing_interfaced_yn, dflt_locn_code_for_dis_regn, dflt_srvc_code_for_dis_regn, dflt_pry_zone_for_dis_regn, dflt_un_adult_age_for_dis_regn, dflt_vis_typ_cde_for_dis_regn, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+user_id+"','C','','REGISTER_VISIT_YN') OsVal, (SELECT site_id FROM sm_site_param) site_id, (SELECT emeg_pat_ser_grp FROM mp_param WHERE module_id = 'MP') emer_val ,five_level_triage_appl_yn,max_pat_in_disaster_regn,dist_pat_ser_grp from ae_param  where OPERATING_FACILITY_ID=?"; // Thursday, May 20, 2010 PE_EXE venkat s

			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1,fac_id);
			rs = pstmt.executeQuery();
			if (rs ==null || !rs.next()) 
			{
               out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
			}
			else{
					five_level_triage_appl_yn	= (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");	
					max_pat_in_disaster_regn	= rs.getInt("max_pat_in_disaster_regn");
					
					//Added for this CRF ML-MMOH-CRF-0466
					dist_pat_ser_grp=rs.getString("dist_pat_ser_grp");
					if(dist_pat_ser_grp == null)   dist_pat_ser_grp="";
					
					OsVal=rs.getString("OsVal");
					params  = params+"&operstn="+OsVal;
					billing_interfaced_yn=rs.getString("billing_interfaced_yn");
					params  = params+"&billing_interfaced_yn="+billing_interfaced_yn;
					clinic_code=rs.getString("dflt_locn_code_for_dis_regn");
					if(clinic_code == null)   clinic_code="";
					params  = params+"&clinic_code="+clinic_code;
					service_code=rs.getString("dflt_srvc_code_for_dis_regn");
					if(service_code == null)   service_code="";
					params  = params+"&service_code="+service_code;
					visit_type=rs.getString("dflt_vis_typ_cde_for_dis_regn");
					if(visit_type == null)   visit_type="";
					params  = params+"&visit_type="+visit_type;
					pry_zone_for_dis_regn=rs.getString("dflt_pry_zone_for_dis_regn");
					if(pry_zone_for_dis_regn == null)   pry_zone_for_dis_regn="";
					params  = params+"&pry_zone_for_dis_regn="+pry_zone_for_dis_regn;
					un_adult_age_for_dis_regn=rs.getString("DFLT_UN_ADULT_AGE_FOR_DIS_REGN");
					if(un_adult_age_for_dis_regn == null)   un_adult_age_for_dis_regn="";
					params  = params+"&un_adult_age_for_dis_regn="+un_adult_age_for_dis_regn;
					Site =rs.getString("site_id");
					if(Site == null)   Site="DS";
					params  = params+"&Site="+Site;	
					emer_val_sr=rs.getString("emer_val");
					params  = params+"&emer_val_sr="+emer_val_sr;
					//Below line modified for this CRF ML-MMOH-CRF-0466
					params  = params+"&module_id="+module_id+"&five_level_triage_appl_yn="+five_level_triage_appl_yn+"&max_pat_in_disaster_regn="+max_pat_in_disaster_regn+"&dist_pat_ser_grp="+dist_pat_ser_grp;	
									  

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

							 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(source));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(params));
            _bw.write(_wl_block8Bytes, _wl_block8);
			
					   }
					}
                if(rs != null)  rs.close();
		        if(pstmt != null) pstmt.close(); 
			   }catch(Exception e) {e.printStackTrace();}
			   finally
					{
						ConnectionManager.returnConnection(con,request);
					}
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
