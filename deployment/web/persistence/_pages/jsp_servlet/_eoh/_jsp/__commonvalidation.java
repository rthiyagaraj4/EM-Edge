package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public final class __commonvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/CommonValidation.jsp", 1723530454673L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst = null;
	ResultSet rst1 = null;

	String facility_id      = (String) session.getAttribute("facility_id");
	String login_user      = (String) session.getAttribute("login_user");
	
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;

	String client_ip_address = prop.getProperty( "client_ip_address" );
	StringBuffer cond_type_Buff = new StringBuffer();	
	String int_tooth_no = "";

	try{
		con = ConnectionManager.getConnection();
		
		if(func_mode.equalsIgnoreCase("populateToothNo")){	
			String tooth_numbering_system	= checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String sql				= "";		
			String tooth_no_val = "";
			String tooth_num_val = "";
			StringBuffer tooth_no_desc = new StringBuffer();
			sql = "SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY TOOTH_NO ASC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,tooth_numbering_system);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				tooth_no_val = checkForNull(rst.getString("TOOTH_NO"));
				tooth_num_val = checkForNull(rst.getString("TOOTH_NUM"));
				tooth_no_desc.append(tooth_no_val+"##"+tooth_num_val);
				tooth_no_desc.append("~");
			}
			out.println(tooth_no_desc);
		}else if(func_mode.equalsIgnoreCase("populateTreatments")){	
			String category_val = checkForNull(request.getParameter( "category_val" )) ;
			String sql				= "";		
			String condition_code = "";
			String condition_desc = "";
			StringBuffer condition_type_desc = new StringBuffer();
			sql = "SELECT TRMT_CODE,TRMT_DESC FROM OH_TREATMENT_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(EFF_STATUS,'E') = 'E' AND TRMT_CATEGORY_CODE IN (SELECT TRMT_CATEGORY_CODE FROM OH_TREATMENT_CATEGORY WHERE TRMT_CATEGORY_TYPE=?) ORDER BY 2";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,category_val);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_code = checkForNull(rst.getString("TRMT_CODE"));
				condition_desc = checkForNull(rst.getString("TRMT_DESC"));
				condition_type_desc.append(condition_code+"##"+condition_desc);
				condition_type_desc.append("~");
			}
			out.println(condition_type_desc);
		}else if(func_mode.equalsIgnoreCase("populateSiteOptions")){	
			String trmt_condition_type_val = checkForNull(request.getParameter( "trmt_condition_type_val" )) ;
			String tab_name = checkForNull(request.getParameter( "tab_name" )) ;
			String sql			= "";		
			String site_type	= "";
			String site_desc	= "";
			StringBuffer site_type_desc = new StringBuffer();
			
			if(tab_name.equals("ET") || tab_name.equals("T")){
				sql = "SELECT SITE_TYPE,SITE_DESC FROM OH_SITE_TYPE_LANG_VW WHERE LANGUAGE_ID=? AND SITE_TYPE IN (SELECT SITE_TYPE FROM OH_TREATMENT_APPL_SITE_TYPE WHERE TREATMENT_CATEGORY_TYPE = ?) ORDER BY 2";
			}
			else if(tab_name.equals("DC")){
				sql = "SELECT SITE_TYPE,SITE_DESC FROM OH_SITE_TYPE_LANG_VW WHERE LANGUAGE_ID=? AND SITE_TYPE IN (SELECT SITE_TYPE FROM OH_CONDITION_APPL_SITE_TYPE WHERE CONDITION_TYPE = ?) ORDER BY 2";
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,trmt_condition_type_val);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				site_type = checkForNull(rst.getString("SITE_TYPE"));
				site_desc = checkForNull(rst.getString("SITE_DESC"));
				site_type_desc.append(site_type+"##"+site_desc);
				site_type_desc.append("~");
			}
			out.println(site_type_desc);
		}else if(func_mode.equalsIgnoreCase("populateDentalcondition")){	
			String condition_type_val = checkForNull(request.getParameter( "condition_type_val" )) ;
			String sql				= "";		
			String condition_code	= "";
			String condition_desc	= "";
			StringBuffer condition_type_desc = new StringBuffer();
			
			sql = "SELECT CONDITION_CODE, CONDITION_DESC FROM OH_CONDITION_LANG_VW WHERE LANGUAGE_ID = ? AND CONDITION_TYPE=? AND NVL(EFF_STATUS,'E') = 'E' ORDER BY 2";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,condition_type_val);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_code = checkForNull(rst.getString("CONDITION_CODE"));
				condition_desc = checkForNull(rst.getString("CONDITION_DESC"));
				condition_type_desc.append(condition_code+"##"+condition_desc);
				condition_type_desc.append("~");
			}
			out.println(condition_type_desc);
		}else if(func_mode.equalsIgnoreCase("populateSurfaces")){	
			String site_type_val = checkForNull(request.getParameter( "site_type_val" )) ;
			String tooth_no_val = checkForNull(request.getParameter( "tooth_no_val" )) ;	
			
			String sql			= "";		
			String surface_code = "";
			String surface_name = "";
			StringBuffer surface_code_name = new StringBuffer();
			if(site_type_val.equals("ROOT") || site_type_val.equals("CROWN")){ // Added bcoz surfaces are applicable only for ROOT and Crown
				sql = "SELECT SURFACE_CODE, SURFACE_NAME FROM OH_SURFACE_LANG_VW WHERE LANGUAGE_ID=? AND SURFACE_CODE IN (SELECT SURFACE_CODE FROM OH_TOOTH_SURFACE WHERE TOOTH_NO=? AND SITE_TYPE=?) ORDER BY 2";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,tooth_no_val);
				pstmt.setString(3,site_type_val);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					surface_code = checkForNull(rst.getString("SURFACE_CODE"));
					surface_name = checkForNull(rst.getString("SURFACE_NAME"));
					surface_code_name.append(surface_code+"##"+surface_name);
					surface_code_name.append("~");
				}
			}else if (site_type_val.equals("MAXFS")){//added by parul for CRF 701 on 23/09/2009
				sql = "SELECT ORGAN_CODE,ORGAN_DESC FROM OH_ORGAN WHERE INTRAORAL_EXTRAORAL=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,tooth_no_val);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					surface_code = checkForNull(rst.getString("ORGAN_CODE"));
					surface_name = checkForNull(rst.getString("ORGAN_DESC"));
					surface_code_name.append(surface_code+"##"+surface_name);
					surface_code_name.append("~");
				}
			}
			out.println(surface_code_name);
		}else if(func_mode.equalsIgnoreCase("populateArea")){	
			String site_type_val = checkForNull(request.getParameter( "site_type_val" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN = checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String sql = "";		
			String code = "";
			String value = "";
			String mixed_dent_tooth_no = "";
			StringBuffer area_code_value = new StringBuffer();
			if(site_type_val!=null && !site_type_val.equals("null") && !site_type_val.equals("")){
				if(site_type_val.equals("CROWN") || site_type_val.equals("ROOT") || site_type_val.equals("TOOTH") || site_type_val.equals("THRNG")){
					sql = "SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO, B.MIXED_DENT_TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND PERMANENT_DECIDUOUS = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,permanent_deciduous_flag);
				}
				else if(site_type_val.equals("QUAD")){
					/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT_LANG_VW */
					//	sql = "SELECT QUADRANT_DESC, QUADRANT_SNO FROM OH_QUADRANT_LANG_VW WHERE LANGUAGE_ID =? AND NUMBERING_SYSTEM = ? AND PERMANENT_DECIDUOUS = ? ORDER BY 1";
					sql = "SELECT QUADRANT_DESC, QUADRANT_SNO FROM OH_QUADRANT_LANG_VW WHERE LANGUAGE_ID =? AND NUMBERING_SYSTEM = ? ORDER BY 1";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,tooth_numbering_system);
					//pstmt.setString(3,permanent_deciduous_flag);
				}
				else if(site_type_val.equals("ARCH")){
					sql = "SELECT ARCH_DESC, ARCH_ID FROM OH_ARCH_LANG_VW WHERE LANGUAGE_ID=? AND NUMBERING_SYSTEM = ? ORDER BY 1";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,tooth_numbering_system);
				}

				rst = pstmt.executeQuery();

				while(rst!= null && rst.next()){
					code = checkForNull(rst.getString(2));
					value = checkForNull(rst.getString(1));
					if(mixed_dentition_YN.equals("Y") && (site_type_val.equals("TOOTH") || site_type_val.equals("THRNG"))){
						mixed_dent_tooth_no = checkForNull(rst.getString(3));
						area_code_value.append(code+"##"+value+"##"+mixed_dent_tooth_no);
						area_code_value.append("~");
					}else{
						area_code_value.append(code+"##"+value);
						area_code_value.append("~");
					}
				}
				out.println(area_code_value);
			}
		}else if(func_mode.equalsIgnoreCase("populateCuspTip")){	
			String surface_code_val = checkForNull(request.getParameter("surface_code_val")) ;
			String tooth_no = checkForNull(request.getParameter("tooth_no_hid")) ;
			String sql				= "";		
			String cusp_tip_code = "";
			String cusp_tip_name = "";
			StringBuffer cusp_tip_code_name = new StringBuffer();

			String[] cusp_tip_code_arr = null;
            String str="";
			//commented  by parul for CRF#0483 on 21/08/2009
			/*sql = "SELECT A.CUSP_TIP_CODE, A.CUSP_TIP_NAME FROM OH_CUSP_TIP_LANG_VW A, OH_SURFACE_APPL_CUSP_TIP B WHERE A.LANGUAGE_ID=? AND A.CUSP_TIP_CODE = B.CUSP_TIP_CODE and B.TOOTH_NO=? and B.SURFACE_CODE = ? ORDER BY 2";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,tooth_no);
			pstmt.setString(3,surface_code_val);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				cusp_tip_code = checkForNull(rst.getString("CUSP_TIP_CODE"));
				cusp_tip_name = checkForNull(rst.getString("CUSP_TIP_NAME"));
				cusp_tip_code_name.append(cusp_tip_code+"##"+cusp_tip_name);
				cusp_tip_code_name.append("~");
			}
			out.println(cusp_tip_code_name);*/
			if(surface_code_val.indexOf(",") != -1){
			 cusp_tip_code_arr=surface_code_val.split(",");
			 	for(int i=0;i<cusp_tip_code_arr.length;i++){
				str=cusp_tip_code_arr[i];
				 pstmt= con.prepareStatement("SELECT A.CUSP_TIP_CODE, A.CUSP_TIP_NAME FROM OH_CUSP_TIP_LANG_VW A, OH_SURFACE_APPL_CUSP_TIP B WHERE A.LANGUAGE_ID=? AND A.CUSP_TIP_CODE = B.CUSP_TIP_CODE and B.TOOTH_NO=? and B.SURFACE_CODE = ? ORDER BY 2");
					pstmt.setString(1,locale);
					pstmt.setString(2,tooth_no);
					pstmt.setString(3,str);
					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
						cusp_tip_code = checkForNull(rst.getString("CUSP_TIP_CODE"));
						cusp_tip_name = checkForNull(rst.getString("CUSP_TIP_NAME"));
						cusp_tip_code_name.append(cusp_tip_code+"##"+cusp_tip_name);
						cusp_tip_code_name.append("~");
					}
				}
			}else{
				if(surface_code_val.equals("*A")){
				  sql = "SELECT A.CUSP_TIP_CODE, A.CUSP_TIP_NAME FROM OH_CUSP_TIP_LANG_VW A, OH_SURFACE_APPL_CUSP_TIP B WHERE A.LANGUAGE_ID=? AND A.CUSP_TIP_CODE = B.CUSP_TIP_CODE and B.TOOTH_NO=? ORDER BY 2";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,tooth_no);
					//pstmt.setString(3,surface_code_val);
					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
						cusp_tip_code = checkForNull(rst.getString("CUSP_TIP_CODE"));
						cusp_tip_name = checkForNull(rst.getString("CUSP_TIP_NAME"));
						cusp_tip_code_name.append(cusp_tip_code+"##"+cusp_tip_name);
						cusp_tip_code_name.append("~");
					}
				
				}else{
					sql = "SELECT A.CUSP_TIP_CODE, A.CUSP_TIP_NAME FROM OH_CUSP_TIP_LANG_VW A, OH_SURFACE_APPL_CUSP_TIP B WHERE A.LANGUAGE_ID=? AND A.CUSP_TIP_CODE = B.CUSP_TIP_CODE and B.TOOTH_NO=? and B.SURFACE_CODE = ? ORDER BY 2";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					pstmt.setString(2,tooth_no);
					pstmt.setString(3,surface_code_val);
					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
						cusp_tip_code = checkForNull(rst.getString("CUSP_TIP_CODE"));
						cusp_tip_name = checkForNull(rst.getString("CUSP_TIP_NAME"));
						cusp_tip_code_name.append(cusp_tip_code+"##"+cusp_tip_name);
						cusp_tip_code_name.append("~");
					}
				}
			}
			out.println(cusp_tip_code_name);
		}
		else if(func_mode.equalsIgnoreCase("displayCuspTip")){	
			String cusp_tip_code = checkForNull(request.getParameter("cusp_tip_code"));
			String[] cusp_tip_code_arr = null;
            String str="";
			String cusp_tip_name = "";
			String cusp_tip_code_val = "";
			StringBuffer cusp_tip_code_name = new StringBuffer();
			if(cusp_tip_code.indexOf(",") != -1){
			 cusp_tip_code_arr=cusp_tip_code.split(",");
			 	for(int i=0;i<cusp_tip_code_arr.length;i++){
				str=cusp_tip_code_arr[i];
				 pstmt= con.prepareStatement("SELECT CUSP_TIP_NAME,CUSP_TIP_CODE FROM OH_CUSP_TIP_LANG_VW WHERE LANGUAGE_ID=? AND CUSP_TIP_CODE=?");
					pstmt.setString(1,locale);
					pstmt.setString(2,str);
					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
						cusp_tip_name = checkForNull(rst.getString("CUSP_TIP_NAME"));
						cusp_tip_code_val = checkForNull(rst.getString("CUSP_TIP_CODE"));
						//cusp_tip_code_name.append(cusp_tip_code_val+"##"+cusp_tip_name);
						cusp_tip_code_name.append(cusp_tip_name);
						cusp_tip_code_name.append("~");
						
					}
				}
			}else{
				 pstmt= con.prepareStatement("SELECT CUSP_TIP_NAME,cusp_tip_code FROM OH_CUSP_TIP_LANG_VW WHERE LANGUAGE_ID=? AND CUSP_TIP_CODE=?");
					pstmt.setString(1,locale);
					pstmt.setString(2,cusp_tip_code);
					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
						cusp_tip_name = checkForNull(rst.getString("CUSP_TIP_NAME"));
						cusp_tip_code_val = checkForNull(rst.getString("cusp_tip_code"));
						cusp_tip_code_name.append(cusp_tip_name);
			       }
			
			}
			out.println(cusp_tip_code_name);

		}else if(func_mode.equalsIgnoreCase("displayCuspTipName")){	
			String tooth_no = checkForNull(request.getParameter("tooth_no")) ;
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String sql				= "";		
			String cusp_tip_code = "";
			
			sql = "SELECT CUSP_TIP_CODE FROM OH_RESTORATIVE_CHART_DTL WHERE TOOTH_NO=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,tooth_no);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				cusp_tip_code = checkForNull(rst.getString("CUSP_TIP_CODE"));
			}
			out.println(cusp_tip_code);

		}else if(func_mode.equalsIgnoreCase("displaySurfacesDescription")){	//added by parul for CRF#0483 on 21/08/2009
			String surface_code = checkForNull(request.getParameter("surface_code"));
			String[] surface_arr = null;
            String str="";
			String surface_name = "";
			String surface_val = "";

			StringBuffer surface_code_name = new StringBuffer();

			if(surface_code.indexOf(",") != -1){
			 surface_arr=surface_code.split(",");
			 	for(int p=0;p<surface_arr.length;p++){
					str=surface_arr[p];
					pstmt= con.prepareStatement("SELECT SURFACE_CODE, SURFACE_NAME FROM OH_SURFACE_LANG_VW WHERE LANGUAGE_ID=? AND SURFACE_CODE=?");
					pstmt.setString(1,locale);
					pstmt.setString(2,str);
					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
						surface_name = checkForNull(rst.getString("SURFACE_CODE"));
						surface_val = checkForNull(rst.getString("SURFACE_NAME"));
						surface_code_name.append(surface_val);
						surface_code_name.append("~");
					}
				
				}
			}else{
				 pstmt= con.prepareStatement("SELECT SURFACE_CODE, SURFACE_NAME FROM OH_SURFACE_LANG_VW WHERE LANGUAGE_ID=? AND SURFACE_CODE=?");
					pstmt.setString(1,locale);
					pstmt.setString(2,surface_code);
					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
						surface_name = checkForNull(rst.getString("SURFACE_NAME"));
						surface_val = checkForNull(rst.getString("SURFACE_CODE"));
						surface_code_name.append(surface_name);
			       }
			}
			out.println(surface_code_name);

		}else if(func_mode.equalsIgnoreCase("getDataFromDB")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String sql				= "";		
			String site_type = "";
			StringBuffer site_type_code_name = new StringBuffer();
			
			sql = "SELECT CONDITION_TREATMENT_TYPE FROM OH_PATIENT_TOOTH_CHART_DTLS WHERE PATIENT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				site_type = checkForNull(rst.getString("CONDITION_TREATMENT_TYPE"));
				site_type_code_name.append(site_type);
				site_type_code_name.append("~");
			}
			out.println(site_type_code_name);
		}else if(func_mode.equalsIgnoreCase("checkForActiveChart")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			String active_chart_yn = "N";
			String chart_type = "";
			int rest_chrt_validity_days = 0;
			int chart_days = 0;
			String sql				= "";
			String dflt_mixed_dentition_chart="";
			StringBuffer chartSerialBuff = new StringBuffer();	
			if(oh_chart_level.equals("E")){
				//Commented and added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
				//sql = "SELECT CHART_NUM,CHART_DATE,CHART_TYPE, (TRUNC(SYSDATE)-TRUNC(CHART_DATE)) CHART_DAYS, CLINICAL_GROUP_CODE, B.REST_CHRT_VALIDITY_DAYS FROM OH_RESTORATIVE_CHART_HDR, OH_PARAM_FOR_FACILITY B WHERE FACILITY_ID=OPERATING_FACILITY_ID AND PATIENT_ID = ? AND CHART_STATUS = 'A'";
				//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
				//sql = "SELECT CHART_NUM,CHART_DATE,CHART_TYPE, (TRUNC(SYSDATE)-TRUNC(CHART_DATE)) CHART_DAYS, CLINICAL_GROUP_CODE, B.REST_CHRT_VALIDITY_DAYS, B.DFLT_MIXED_DENTITION_CHART FROM OH_RESTORATIVE_CHART_HDR, OH_PARAM_FOR_FACILITY B WHERE FACILITY_ID=OPERATING_FACILITY_ID AND PATIENT_ID = ? AND CHART_STATUS = 'A'";
				sql = "SELECT CHART_NUM,CHART_DATE,CHART_TYPE, (TRUNC(SYSDATE)-TRUNC(CHART_DATE)) CHART_DAYS, CLINICAL_GROUP_CODE, B.REST_CHRT_VALIDITY_DAYS, B.DFLT_MIXED_DENTITION_CHART FROM OH_RESTORATIVE_CHART_HDR, OH_PARAM B WHERE PATIENT_ID = ? AND CHART_STATUS = 'A'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				rst = pstmt.executeQuery();
			}
			else{
				//Commented and added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
				//sql = "SELECT CHART_NUM,CHART_DATE,CHART_TYPE, (TRUNC(SYSDATE)-TRUNC(CHART_DATE)) CHART_DAYS, CLINICAL_GROUP_CODE, B.REST_CHRT_VALIDITY_DAYS FROM OH_RESTORATIVE_CHART_HDR, OH_PARAM_FOR_FACILITY B WHERE FACILITY_ID=OPERATING_FACILITY_ID AND OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A'";
				sql = "SELECT CHART_NUM,CHART_DATE,CHART_TYPE, (TRUNC(SYSDATE)-TRUNC(CHART_DATE)) CHART_DAYS, CLINICAL_GROUP_CODE, B.REST_CHRT_VALIDITY_DAYS,	B.DFLT_MIXED_DENTITION_CHART FROM OH_RESTORATIVE_CHART_HDR, OH_PARAM_FOR_FACILITY B WHERE FACILITY_ID=OPERATING_FACILITY_ID AND OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A'";
				pstmt = con.prepareStatement(sql);
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				rst = pstmt.executeQuery();
			}
			while(rst!= null && rst.next()){
				chart_days = Integer.parseInt(rst.getString("CHART_DAYS"));
				chart_type = rst.getString("CHART_TYPE");
				rest_chrt_validity_days = Integer.parseInt(checkForNull(rst.getString("REST_CHRT_VALIDITY_DAYS"),"0"));
				//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
				dflt_mixed_dentition_chart = rst.getString("DFLT_MIXED_DENTITION_CHART");
				active_chart_yn = "Y";

			  //Commented and added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782	//chartSerialBuff.append(chart_days+"##"+rest_chrt_validity_days+"##"+active_chart_yn+"##"+chart_type);
				chartSerialBuff.append(chart_days+"##"+rest_chrt_validity_days+"##"+active_chart_yn+"##"+chart_type+"##"+dflt_mixed_dentition_chart);
			}
			chartSerialBuff.append("~");
			out.println(chartSerialBuff);
		}else if(func_mode.equalsIgnoreCase("checkForPerioChartValidity")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_code = checkForNull(request.getParameter( "chart_code" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;

			StringBuffer chartSerialBuff = new StringBuffer();	

			int peri_chrt_validity_days = 0;
			int chart_days = 0;

			//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT (TRUNC(SYSDATE)-TRUNC(CHART_DATE)) CHART_DAYS, B.PERI_CHRT_VALIDITY_DAYS FROM OH_PERIODONTAL_CHART_HDR, OH_PARAM B WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_STATUS != 'CD'");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_code);
				pstmt.setString(4,chart_num);
			}//
			else{
				pstmt = con.prepareStatement("SELECT (TRUNC(SYSDATE)-TRUNC(CHART_DATE)) CHART_DAYS, B.PERI_CHRT_VALIDITY_DAYS FROM OH_PERIODONTAL_CHART_HDR, OH_PARAM_FOR_FACILITY B WHERE FACILITY_ID=OPERATING_FACILITY_ID AND OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND CHART_STATUS != 'CD'");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_code);
				pstmt.setString(4,chart_num);			
			
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_days = Integer.parseInt(checkForNull(rst.getString("CHART_DAYS"),"0"));
				peri_chrt_validity_days = Integer.parseInt(checkForNull(rst.getString("PERI_CHRT_VALIDITY_DAYS"),"0"));
				chartSerialBuff.append(chart_days+"##"+peri_chrt_validity_days);
			}
			chartSerialBuff.append("~");
			out.println(chartSerialBuff);
		}else if(func_mode.equalsIgnoreCase("populateQuadArchDesc")){	
			String site_type = checkForNull(request.getParameter( "site_type" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String sql				= "";	
			String desc = "";
			if(site_type.equals("QUAD")){
				sql = "SELECT QUADRANT_ID, QUADRANT_DESC FROM OH_QUADRANT_LANG_VW WHERE LANGUAGE_ID =? AND QUADRANT_SNO = ? AND NUMBERING_SYSTEM = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,tooth_no);
				pstmt.setString(3,tooth_numbering_system);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					desc = checkForNull(rst.getString("QUADRANT_DESC"));
				}
			}
			else if(site_type.equals("ARCH")){
				sql = "SELECT ARCH_ID, ARCH_DESC FROM OH_ARCH_LANG_VW WHERE LANGUAGE_ID=? AND ARCH_ID = ? AND NUMBERING_SYSTEM = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,tooth_no);
				pstmt.setString(3,tooth_numbering_system);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					desc = checkForNull(rst.getString("ARCH_DESC"));
				}
			}
			out.println(desc);
		}else if(func_mode.equalsIgnoreCase("populateConditionForTooth")){	
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String super_tooth_ref = checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			
			String sql = "";	
			String alert_yn = "N";
			String status = "";
			String condition_type = "";
			String super_tooth_count = "";
			String super_tooth_no = "";

			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}
			
			sql = "SELECT CONDITION_TYPE, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			pstmt.setString(5,super_tooth_no);
			pstmt.setString(6,retained_tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				status = checkForNull(rst.getString("STATUS"));;
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				if((!condition_type.equals("")) && condition_type.equals("PULPINV")){
					alert_yn = "Y";
					break;
				}
				else{
					alert_yn = "N";
				}
			}
			out.println(alert_yn+"##"+status);
		}else if(func_mode.equalsIgnoreCase("populateConditionCode")){	
			String condition_type = checkForNull(request.getParameter( "condition_type" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;//Added by Sridevi Joshi on 2/10/2010 for IN010871(SRR20056-CRF-0478)
			String sql				= "";	
			String condition_code = "";
			//sql = "SELECT TRMT_CATEGORY_CODE FROM OH_TREATMENT_CATEGORY WHERE TRMT_CATEGORY_TYPE = ?";
			sql = "SELECT A.TRMT_CATEGORY_CODE FROM OH_TREATMENT_CATEGORY A, OH_TREATMENT B WHERE A.TRMT_CATEGORY_TYPE = ? AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND B.TRMT_CODE = ?";//Added by Sridevi Joshi on 2/10/2010 for IN010871(SRR20056-CRF-0478)
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,condition_type);
			pstmt.setString(2,trmt_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_code = checkForNull(rst.getString("TRMT_CATEGORY_CODE"));
			}
			out.println(condition_code);
		}else if(func_mode.equalsIgnoreCase("populateNSToothNo")){	
			String PD_flag = "";
			String sql = "";	
			String dec_ns_tooth_no = "";

			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String numbering_system = checkForNull(request.getParameter( "numbering_system" )) ;
			String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN = checkForNull(request.getParameter( "mixed_dentition_YN" )) ;

			if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
				PD_flag = "P";
			}
			else{
				PD_flag = "D";
			}

			sql = "SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,numbering_system);
			pstmt.setString(2,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				dec_ns_tooth_no = checkForNull(rst.getString("NS_TOOTH_NO"));
				int_tooth_no = checkForNull(rst.getString("TOOTH_NO"));
			}
			out.println(dec_ns_tooth_no+"##"+int_tooth_no);
		}else if(func_mode.equalsIgnoreCase("populateNSToothNoForJS")){	
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String numbering_system = checkForNull(request.getParameter( "numbering_system" )) ;
			String sql				= "";	
			String dec_ns_tooth_no = "";

			sql = "SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,numbering_system);
			pstmt.setString(2,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				dec_ns_tooth_no = checkForNull(rst.getString("NS_TOOTH_NO"));
				
			}
			out.println(dec_ns_tooth_no);
		}
		else if(func_mode.equalsIgnoreCase("populateMixedDentToothNo")){	
			String numbering_system = checkForNull(request.getParameter( "numbering_system" )) ;
			String sql				= "";	
			String mixed_dent_tooth_no = "";
			String display_tooth_no = "";

			StringBuffer mixed_dent_Buff = new StringBuffer();
			sql = "SELECT TOOTH_NO, MIXED_DENT_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NS_TOOTH_NO = MIXED_DENT_TOOTH_NO AND NUMBERING_SYSTEM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,numbering_system);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				mixed_dent_tooth_no = checkForNull(rst.getString("MIXED_DENT_TOOTH_NO"));
				display_tooth_no = checkForNull(rst.getString("TOOTH_NO"));
				mixed_dent_Buff.append(display_tooth_no+"##"+mixed_dent_tooth_no);
				mixed_dent_Buff.append("~");
			}
			out.println(mixed_dent_Buff);
		}
		else if(func_mode.equalsIgnoreCase("getDecithYN")){	
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String site_type = checkForNull(request.getParameter( "site_type" )) ;
			String sql				= "";	
			String condition_type = "";
			String trmt_category_type = "";
			
			if(site_type.equals("ARCH")){
				sql = "SELECT CONDITION_TYPE, TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND ARCH_SNO = ? AND NVL(STATUS,'X')!='E'  AND CHART_NUM = ? AND OPERATING_FACILITY_ID =? AND NVL(COND_CLOSED_YN,'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,tooth_no);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,facility_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
					trmt_category_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
					cond_type_Buff.append(condition_type+"##"+trmt_category_type);
					cond_type_Buff.append("~");
				}
			}
			else if(site_type.equals("QUAD")){
				sql = "SELECT CONDITION_TYPE, TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND QUADRANT_SNO = ? AND NVL(STATUS,'X')!='E'  AND CHART_NUM = ? AND OPERATING_FACILITY_ID =? AND NVL(COND_CLOSED_YN,'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,tooth_no);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,facility_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
					trmt_category_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
					cond_type_Buff.append(condition_type+"##"+trmt_category_type);
					cond_type_Buff.append("~");
				}
			}
			else{
				sql = "SELECT CONDITION_TYPE, TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND TOOTH_NO = ? AND NVL(STATUS,'X')!='E'  AND CHART_NUM = ? AND OPERATING_FACILITY_ID =? AND NVL(COND_CLOSED_YN,'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,tooth_no);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,facility_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
					trmt_category_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
					cond_type_Buff.append(condition_type+"##"+trmt_category_type);
					cond_type_Buff.append("~");
				}

			}
			out.println(cond_type_Buff);
		}
		else if(func_mode.equalsIgnoreCase("getStausAfterOrderCreation")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String status = "";
			pstmt = con.prepareStatement("SELECT STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			rst=pstmt.executeQuery();
			while(rst.next()){
				status = checkForNull(rst.getString("STATUS"));
			}
		    out.println(status);
		}
		else if(func_mode.equalsIgnoreCase("populateDisplayToothNoAndName")){	
			String numbering_system = checkForNull(request.getParameter( "numbering_system" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN = checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			
			String sql				= "";	
			String display_tooth_no = "";
			String tooth_name = "";
			String mapped_tooth_no = "";
			String mixed_dent_tooth_no = "";
			if(tooth_no.indexOf(",") == -1){ //If tooth no is in the form of (12,14) system will throw an exception saying that "Invalid Number".Changed ON 05MAR2008
				if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
					sql = "SELECT B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.MIXED_DENT_TOOTH_NO FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) AND TOOTH_NO = ?";
				}else{
					sql = "SELECT B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.MIXED_DENT_TOOTH_NO FROM OH_TOOTH_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? AND TOOTH_NO = ?";
				}
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,numbering_system);
				pstmt.setString(3,permanent_deciduous_flag);
				pstmt.setString(4,tooth_no);
				rst=pstmt.executeQuery();
				while(rst.next()){
					display_tooth_no = checkForNull(rst.getString("TOOTH_NUM"));
					tooth_name = checkForNull(rst.getString("TOOTH_NAME"));
					mapped_tooth_no = checkForNull(rst.getString("MAPPED_TOOTH_NO"));
					mixed_dent_tooth_no = checkForNull(rst.getString("MIXED_DENT_TOOTH_NO"));
				}
			}
		    out.println(display_tooth_no+"##"+tooth_name+"##"+mapped_tooth_no+"##"+mixed_dent_tooth_no);
		}
		else if(func_mode.equalsIgnoreCase("allConditionsRecorded")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String site = checkForNull(request.getParameter( "site" )) ;//Added by Sridevi Joshi on 4/21/2010 for IN020809
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			StringBuffer allRecords = new StringBuffer();
			StringBuffer sqlBuffer = new StringBuffer();

			
			if(oh_chart_level.equals("E")){
				//pstmt = con.prepareStatement("SELECT SUPER_KEY_NUM, CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E'  AND NVL (HIDE_IMAGE_YN, 'X') != 'Y'  AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' UNION ALL SELECT SUPER_KEY_NUM, 'MISSTH' CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I') AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('25', '52','54','55','60','70','75','85','90')) ");

				sqlBuffer.append("SELECT SUPER_KEY_NUM, CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ?");

				if(site.equals("QUAD")){
					sqlBuffer.append(" AND QUADRANT_SNO   = ?");//Added by Sridevi Joshi on 4/21/2010 for IN020809
				}
				else{
					sqlBuffer.append(" AND TOOTH_NO   = ?");
				}

				sqlBuffer.append(" AND NVL (STATUS, 'X') != 'E'  AND NVL (HIDE_IMAGE_YN, 'X') != 'Y'  AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' UNION ALL SELECT SUPER_KEY_NUM, 'MISSTH' CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I') AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('25', '52','54','55','60','70','75','85','90'))");

				pstmt = con.prepareStatement(sqlBuffer.toString());
				
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,patient_id);
				pstmt.setString(5,chart_num);
				pstmt.setString(6,tooth_no);
				rst=pstmt.executeQuery();
			}
			else{
				// removed  NVL (HIDE_IMAGE_YN, 'X') != 'Y'   from query in case of impaction if u exfoliate super tooth ,retVal was not retuning super becoz for super HIDE_IMAGE_YNis Y
				//pstmt = con.prepareStatement("SELECT SUPER_KEY_NUM, CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E'  AND NVL (HIDE_IMAGE_YN, 'X') != 'Y'  AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' UNION ALL SELECT SUPER_KEY_NUM, 'MISSTH' CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I') AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('25', '52','54','55','60','70','75','85','90')) ");

				sqlBuffer.append("SELECT SUPER_KEY_NUM, CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ?");

				if(site.equals("QUAD")){
					sqlBuffer.append(" AND QUADRANT_SNO   = ?");//Added by Sridevi Joshi on 4/21/2010 for IN020809
				}
				else{
					sqlBuffer.append(" AND TOOTH_NO   = ?");
				}

				sqlBuffer.append("AND NVL (STATUS, 'X') != 'E'  AND NVL (HIDE_IMAGE_YN, 'X') != 'Y'  AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' UNION ALL SELECT SUPER_KEY_NUM, 'MISSTH' CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I') AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('25', '52','54','55','60','70','75','85','90'))");

				pstmt = con.prepareStatement(sqlBuffer.toString());
			
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,other_chart_facility_id);
				pstmt.setString(6,patient_id);
				pstmt.setString(7,chart_num);
				pstmt.setString(8,tooth_no);   
				
				rst=pstmt.executeQuery();
			}

			while(rst.next()){
				allRecords.append(checkForNull(rst.getString("CONDITION_TYPE"))+"##"+checkForNull(rst.getString("CONDITION_CODE"))+"##"+checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"))+"##"+checkForNull(rst.getString("SUPERNUMERARY_YN"))+"##"+checkForNull(rst.getString("HIDE_IMAGE_YN"))+"##"+checkForNull(rst.getString("STATUS"))+"##"+checkForNull(rst.getString("SUPER_KEY_NUM")));
				allRecords.append("~");
			}

			out.println(allRecords);		 
			

		}
		else if(func_mode.equalsIgnoreCase("allTrmtsRecorded")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;

			StringBuffer allRecords = new StringBuffer();

			pstmt = con.prepareStatement("SELECT TREATMENT_CATEGORY_TYPE,TRMT_CODE,HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND TREATMENT_CONDITION = 'C' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst=pstmt.executeQuery();
			while(rst.next()){
				allRecords.append(checkForNull(rst.getString("TREATMENT_CATEGORY_TYPE"))+"##"+checkForNull(rst.getString("TRMT_CODE")));
				allRecords.append("~");
			}
		    out.println(allRecords);
		}
		else if(func_mode.equalsIgnoreCase("getDiffDate")){	
			String asOnDate = checkForNull(request.getParameter( "asOnDate" )) ;
			String status = "";
			String date_diff = "";
			pstmt = con.prepareStatement("SELECT TO_DATE('"+asOnDate+"','DD/MM/YYYY') - TRUNC(SYSDATE) DATE_DIFF FROM DUAL");
			rst=pstmt.executeQuery();
			while(rst.next()){
				date_diff = checkForNull(rst.getString("DATE_DIFF"));
				if(!date_diff.equals("")){
					if(Integer.parseInt(date_diff) < 0){
						status = "disable";
					}
					else if(Integer.parseInt(date_diff) > 0){
						status = "alert_msg";
					}
					else if(Integer.parseInt(date_diff) == 0){
						status = "enable";
					}
				}
			}
		    out.println(status);
		}
		else if(func_mode.equalsIgnoreCase("getClosedCharNum")){//Added by Sridevi Joshi on 6/1/2010 for IN021668.. to get the chart num if  as on date is changed to the date less then sysdate
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String asOnDate = checkForNull(request.getParameter( "asOnDate" )) ;
			String chart_num = "";
			pstmt = con.prepareStatement("SELECT CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (CHART_DATE)  AND TRUNC (NVL(CHART_CLOSE_DATE, SYSDATE )) ORDER BY CHART_CLOSE_DATE ASC");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,asOnDate);
			rst=pstmt.executeQuery();
			while(rst.next()){
				chart_num = checkForNull(rst.getString("CHART_NUM"));
			}
		    out.println(chart_num);
		}
		else if(func_mode.equalsIgnoreCase("populateSuperYN")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type = "";
			String super_yn = "";
			String RD_yn = "";
			String exfolth_yn = "N";
			String other_super_yn = "";
			String other_RD_yn = "";

			pstmt = con.prepareStatement("SELECT CONDITION_TYPE, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst=pstmt.executeQuery();

			while(rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				
				if(condition_type.equals("EXFOLTH")){
				  	super_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
					RD_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
					exfolth_yn = "Y";
				}/*else{
					other_super_yn = checkForNull(rst.getString("SUPERNUMERARY_YN")); //Added by Sridevi Joshi on 12/14/2009 while SUPRTH new Changes
					other_RD_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));//Added by Sridevi Joshi on 12/14/2009 while SUPRTH new Changes
				}*/
			}
			
		    out.println(super_yn+"##"+RD_yn+"##"+exfolth_yn+"##"+other_super_yn+"##"+other_RD_yn);
		}
		else if(func_mode.equalsIgnoreCase("onLoadClinicalCode")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String sql				= "";	
			String clinical_group_code = "";

			sql = "SELECT CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				clinical_group_code = checkForNull(rst.getString("CLINICAL_GROUP_CODE"));
			}
			out.println(clinical_group_code);
		}
		else if(func_mode.equalsIgnoreCase("selectUserPrefferences")){	
			String sql				= "";	
			String user_tooth_numbering_system = "";
			String tooth_numbering_system = "";

			StringBuffer numbering_system_buffer = new StringBuffer();	

			//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;

			if(oh_chart_level.equals("E")){
				sql = "SELECT (SELECT PREF_NUMBERING_SYSTEM FROM OH_USER_PREFERENCES  WHERE APPL_USER_ID = ?) USER_TOOTH_NUMBERING_SYSTEM, B.TOOTH_NUMBERING_SYSTEM FROM OH_PARAM B";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,login_user);
				//pstmt.setString(2,facility_id);
			//End
			}else{
				sql = "SELECT (SELECT PREF_NUMBERING_SYSTEM FROM OH_USER_PREFERENCES  WHERE APPL_USER_ID = ?) USER_TOOTH_NUMBERING_SYSTEM, B.TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY B WHERE B.FACILITY_ID=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,login_user);
				pstmt.setString(2,facility_id);		
			
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){ 
				user_tooth_numbering_system = checkForNull(rst.getString("USER_TOOTH_NUMBERING_SYSTEM"));
				tooth_numbering_system = checkForNull(rst.getString("TOOTH_NUMBERING_SYSTEM"));
				numbering_system_buffer.append(user_tooth_numbering_system+"##"+tooth_numbering_system);
			}
			
			out.println(numbering_system_buffer);
		}
		
		else if(func_mode.equalsIgnoreCase("updateUserPrefferences")){	
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;

			String sql = "";	
			String mode = "insert";	

			int max_count = 0;
			int flag = 0;

			pstmt = con.prepareStatement("SELECT COUNT(*) AS MAX_COUNT FROM OH_USER_PREFERENCES WHERE APPL_USER_ID = ?");
			pstmt.setString(1,login_user);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){ 
				max_count = Integer.parseInt(checkForNull(rst.getString("MAX_COUNT")));
				if(max_count > 0){
					mode = "update";
				}
				else{
					mode = "insert";
				}
			}

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(mode.equals("insert")){
				sql = "INSERT INTO OH_USER_PREFERENCES (APPL_USER_ID, PREF_NUMBERING_SYSTEM, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,login_user);
				pstmt.setString(2,tooth_numbering_system);
				pstmt.setString(3,login_user);
				pstmt.setString(4,client_ip_address);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,login_user);
				pstmt.setString(7,client_ip_address);
				pstmt.setString(8,facility_id);
				flag = pstmt.executeUpdate();
			}
			else if(mode.equals("update")){
				sql = "UPDATE OH_USER_PREFERENCES SET PREF_NUMBERING_SYSTEM = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO  = ?, MODIFIED_FACILITY_ID  = ? WHERE APPL_USER_ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,login_user);
				flag = pstmt.executeUpdate();
			}

			if(flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}

			out.println(flag);
		}
		else if(func_mode.equalsIgnoreCase("populateConditionTypeDesc")){	
			String condition_type	= checkForNull(request.getParameter( "condition_type" )) ;
			String condition_type_desc = "";
			
			pstmt = con.prepareStatement("SELECT CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW WHERE LANGUAGE_ID=? AND CONDITION_TYPE = ? AND SPLTY_MODULE_ID = 'OH'");
			pstmt.setString(1,locale);
			pstmt.setString(2,condition_type);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_type_desc = checkForNull(rst.getString("CONDITION_TYPE_DESC"));
			}
			out.println(condition_type_desc);
		}
		else if(func_mode.equalsIgnoreCase("SuperRDyn")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String SuperRDyn = "N";
			String mixed_dent_deciduous_yn = "";
			String cnt = "";
			
			//String supernumerary_yn = "";
			//commented by parul on 031108 for SCR#6303
			//pstmt = con.prepareStatement(" SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('RTDESTH','SUPRTH') AND NVL(COND_CLOSED_YN,'N') = 'N'");

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT COUNT(*) CNT, CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('RTDESTH','SUPRTH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E' GROUP BY CONDITION_TYPE");
			//pstmt = con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('RTDESTH','SUPRTH','DECITH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				mixed_dent_deciduous_yn = checkForNull(rst.getString("CONDITION_TYPE"));
				cnt = checkForNull(rst.getString("CNT"));
				SuperRDyn = "Y";
			}
			out.println(SuperRDyn+"##"+mixed_dent_deciduous_yn+"##"+cnt);
		//}else if(func_mode.equalsIgnoreCase("populateMixedDent")){	
		}
		else if(func_mode.equalsIgnoreCase("checkSuperCount")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String SuperRDyn = "N";
			String mixed_dent_deciduous_yn = "";
			String cnt = "";
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
		
			if(!RD_Normal_yn.equals("D") && !RD_Normal_yn.equals("MR") && !RD_Normal_yn.equals("M") && !RD_Normal_yn.equals("MRP")){
				pstmt = con.prepareStatement("SELECT COUNT(*) CNT, CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E' AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'D' AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'M' GROUP BY CONDITION_TYPE");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					mixed_dent_deciduous_yn = checkForNull(rst.getString("CONDITION_TYPE"));
					cnt = checkForNull(rst.getString("CNT"));
					SuperRDyn = "Y";
				}
			}
			else{
				pstmt = con.prepareStatement("SELECT COUNT(*) CNT, CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E' GROUP BY CONDITION_TYPE");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					mixed_dent_deciduous_yn = checkForNull(rst.getString("CONDITION_TYPE"));
					cnt = checkForNull(rst.getString("CNT"));
					SuperRDyn = "Y";
				}
			}

			out.println(SuperRDyn+"##"+mixed_dent_deciduous_yn+"##"+cnt);
		}
		else if(func_mode.equalsIgnoreCase("checkCondRecorded")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type = "";

			StringBuffer cond_buff = new StringBuffer();

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				cond_buff.append(condition_type);
				cond_buff.append("##");
			}
			out.println(cond_buff);
		}
		else if(func_mode.equalsIgnoreCase("populateSupernum")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String supernumerary_yn = "";
			//commented by parul on 031108 for SCR#6303
			//pstmt = con.prepareStatement(" SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('RTDESTH','SUPRTH') AND NVL(COND_CLOSED_YN,'N') = 'N'");

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			//pstmt = con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE IN ('EXTRACT') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
			pstmt = con.prepareStatement("SELECT SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
			}

			out.println(supernumerary_yn);
		}else if(func_mode.equalsIgnoreCase("populateErupted")){	//added by parul on 24/11/2009 for IN016381

			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String record_count = "";

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('ERUPTH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst = pstmt.executeQuery();
				while(rst.next()){
					record_count = checkForNull(rst.getString("RECORD_COUNT"));
				}
		
			out.println(record_count);
		}
		else if(func_mode.equalsIgnoreCase("checkForImpactionCond")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;

			String condition_type = "";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			
			pstmt = con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM > ? AND TOOTH_NO = ? AND CONDITION_TYPE = 'IMPACTN' AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,chart_line_num);
			pstmt.setString(5,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
			}
			out.println(condition_type);
		}
		else if(func_mode.equalsIgnoreCase("getTaskStatus")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String order_id	= checkForNull(request.getParameter( "order_id" )) ;
			String status_task = "";
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			
			pstmt = con.prepareStatement("SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ORDER_ID = (SELECT ORDER_SET_ID FROM OR_ORDER WHERE ORDER_ID = ?) AND NVL(A.STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,order_id);
			rst = pstmt.executeQuery();
			while(rst.next()){
				status_task = checkForNull(rst.getString("STATUS"));
			}
			out.println(status_task);
		}
		else if(func_mode.equalsIgnoreCase("checkForDuplicateRecord")){
			StringBuffer sqlBuffer = new StringBuffer();

			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String condition_type	= checkForNull(request.getParameter( "condition_type" )) ;
			String dental_condition	= checkForNull(request.getParameter( "dental_condition" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String surface_code	= checkForNull(request.getParameter( "surface_code" )) ;
			String site_type	= checkForNull(request.getParameter( "site_type" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String chart_line_num_Rtdesth	= checkForNull(request.getParameter( "chart_line_num_Rtdesth" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String record_count = "";	
			String super_tooth_count = "";	
			String super_tooth_no = "";	
			String retained_tooth_no = "";	
			int chart_line_num=0;
            // super_tooth_ref,super_tooth_no,super_tooth_count added by parul on 14/12/2009 for super changes

			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			
			if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
				if(!super_tooth_ref.equals("RD")){
					retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
				}
			}else{
		        if(super_tooth_ref.equals("RD")){
					retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
				}
			}
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
				pstmt = con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=?");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				rst = pstmt.executeQuery();
			
				while(rst.next()){
				
					chart_line_num= Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
				
				}	

			if(site_type.equals("ARCH")){
				pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ARCH_SNO = ? AND CONDITION_TYPE = ? AND CONDITION_CODE= ? AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,condition_type);
				pstmt.setString(6,dental_condition);
				rst = pstmt.executeQuery();
				while(rst.next()){
					record_count = checkForNull(rst.getString("RECORD_COUNT"));
				}
			}
			else if(site_type.equals("QUAD")){
				pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND QUADRANT_SNO = ? AND CONDITION_TYPE = ? AND CONDITION_CODE= ? AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,condition_type);
				pstmt.setString(6,dental_condition);
				rst = pstmt.executeQuery();
				while(rst.next()){
					record_count = checkForNull(rst.getString("RECORD_COUNT"));
				}
			}
			else{
				if(!RD_Normal_yn.equals("D") && !RD_Normal_yn.equals("MR") && !RD_Normal_yn.equals("M") && !RD_Normal_yn.equals("MRP")){
					//commented by parul for IN13473 on 11/09/2009(should be able to record duplicate condition on both of super num tooth)
					sqlBuffer.append("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ? AND CONDITION_CODE= ?  AND NVL(SURFACE_CODE,'K') = NVL(?,NVL(SURFACE_CODE,'K')) AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'  AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') ) AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'D' AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'M'");
					 if(condition_type.equals("CARIES") || condition_type.equals("ROOTINV") || condition_type.equals("PERIINV")){
						if (!chart_line_num_Rtdesth.equals("0")){//root inv-->retained->erupted-->same root condition should be able to record
								if (Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!condition_type.equals("CARIES") && mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
									sqlBuffer.append(" AND A.CHART_LINE_NUM > ?");
									sqlBuffer.append(" AND HIDE_IMAGE_YN IN ('D','N','R')");
								}else if(Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
									sqlBuffer.append(" AND A.CHART_LINE_NUM > ?");
							 }
						}
					}
					pstmt=con.prepareStatement(sqlBuffer.toString());
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,tooth_no);
					pstmt.setString(4,condition_type);
					pstmt.setString(5,dental_condition);
					pstmt.setString(6,surface_code);
					pstmt.setString(7,super_tooth_no);
					pstmt.setString(8,retained_tooth_no);

					 if(condition_type.equals("CARIES") || condition_type.equals("ROOTINV") || condition_type.equals("PERIINV")){
						if (!chart_line_num_Rtdesth.equals("0")){
							if (Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!condition_type.equals("CARIES") && mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
								pstmt.setString(9,chart_line_num_Rtdesth);
							}else if(Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
								pstmt.setString(9,chart_line_num_Rtdesth);
							}
						}
					 }
					
					rst = pstmt.executeQuery();
					while(rst.next()){
						record_count = checkForNull(rst.getString("RECORD_COUNT"));
					}				
				}
				else{
					//commented by parul for IN13473 on 11/09/2009(should be able to record duplicate condition on both of super num tooth)
					sqlBuffer.append("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ? AND CONDITION_CODE= ?  AND NVL(SURFACE_CODE,'K') = NVL(?,NVL(SURFACE_CODE,'K')) AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'  AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )");
					 if(condition_type.equals("CARIES") || condition_type.equals("ROOTINV") || condition_type.equals("PERIINV")){
						if (!chart_line_num_Rtdesth.equals("0")){//root inv-->retained->erupted-->same root condition should be able to record
								if (Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!condition_type.equals("CARIES") && mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
									sqlBuffer.append(" AND A.CHART_LINE_NUM > ?");
									sqlBuffer.append(" AND HIDE_IMAGE_YN IN ('D','N','R')");
								}else if(Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
									sqlBuffer.append(" AND A.CHART_LINE_NUM > ?");
							 }
						}
					}
					pstmt=con.prepareStatement(sqlBuffer.toString());
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,tooth_no);
					pstmt.setString(4,condition_type);
					pstmt.setString(5,dental_condition);
					pstmt.setString(6,surface_code);
					pstmt.setString(7,super_tooth_no);
					pstmt.setString(8,retained_tooth_no);

					 if(condition_type.equals("CARIES") || condition_type.equals("ROOTINV") || condition_type.equals("PERIINV")){
						if (!chart_line_num_Rtdesth.equals("0")){
							if (Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!condition_type.equals("CARIES") && mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
								pstmt.setString(9,chart_line_num_Rtdesth);
							}else if(Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
								pstmt.setString(9,chart_line_num_Rtdesth);
							}
						}
					 }
					
					rst = pstmt.executeQuery();
					while(rst.next()){
						record_count = checkForNull(rst.getString("RECORD_COUNT"));
					}				
				}
			}

			out.println(record_count);

		}else if(func_mode.equalsIgnoreCase("getConditionsOnSuprth")){
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String condition_type	= checkForNull(request.getParameter( "condition_type" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String exfolth_count	= checkForNull(request.getParameter( "exfolth_count" )) ;
			String super_tooth_count = "";	
			String super_tooth_no = "";	
			String condition_type1 = "";	
			String retained_tooth_no = "";	
			String  retained_condition_type = "";	


			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('RTDESTH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst = pstmt.executeQuery();
			while(rst.next()){
				retained_condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
			}	
			
			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
		      if(!super_tooth_ref.equals("RD") && (super_tooth_ref.equals("") || super_tooth_ref.equals("undefined"))){
				  if(retained_condition_type.equals("RTDESTH")){
						retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" ));
				  }
				}
		
			}else{
				if(super_tooth_ref.equals("RD")){
					retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
				}
			}
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();	
			
			sqlBuffer.append("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )");
			if(exfolth_count.equals("2")){
				sqlBuffer.append(" AND NVL(A.MIXED_DENT_DECIDUOUS_YN,'X')!='D' AND NVL(A.MIXED_DENT_DECIDUOUS_YN,'X')!='M'");
			}
			pstmt=con.prepareStatement(sqlBuffer.toString());
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);
			pstmt.setString(4,condition_type);
			pstmt.setString(5,super_tooth_no);
			pstmt.setString(6,retained_tooth_no);			
			rst = pstmt.executeQuery();
			while(rst.next()){
				condition_type1 = checkForNull(rst.getString("CONDITION_TYPE"));
			}	
			out.println(condition_type1);

		}
		else if(func_mode.equalsIgnoreCase("checkForDuplicateTrmtRecord")){
			//commented by parul for IN13473 on 11/09/2009(should be able to record duplicate condition on both of super num tooth)
			StringBuffer sqlBuffer = new StringBuffer();

			String numbering_system	= checkForNull(request.getParameter( "numbering_system" )) ;
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String trmt_category_type	= checkForNull(request.getParameter( "trmt_category_type" )) ;
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String surface_code	= checkForNull(request.getParameter( "surface_code" )) ;
			String site_type	= checkForNull(request.getParameter( "site_type" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String chart_line_num_Rtdesth	= checkForNull(request.getParameter( "chart_line_num_Rtdesth" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;//added by parul on 
			String intraoral_extraoral	= checkForNull(request.getParameter( "intraoral_extraoral" )) ;//added by Sharon on 3/8/2010 for IN019556 
			String organ_code	= checkForNull(request.getParameter( "organ_code" )) ;//added by Sharon on 3/8/2010 for IN019556 
			String sub_organ_code	= checkForNull(request.getParameter( "sub_organ_code" )) ;//added by Sharon on 3/8/2010 for IN019556  
			String retained_tooth_no = "";	
			String record_count = "";
			int chart_line_num = 0;	
			String super_tooth_count = "";	
			String super_tooth_no = "";	
			
			 // super_tooth_ref,super_tooth_no,super_tooth_count added by parul on 14/12/2009 for super changes
			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
		      if(!super_tooth_ref.equals("RD") && (super_tooth_ref.equals("") || super_tooth_ref.equals("undefined"))){
						retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" ));
				}
		
			}else{
				if(super_tooth_ref.equals("RD")){
					retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
				}
			}
						
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=?");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			rst = pstmt.executeQuery();

			while(rst.next()){
				chart_line_num= Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
			}

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if(site_type.equals("ARCH")){
				pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ARCH_SNO = ? AND TRMT_CATEGORY_TYPE = ? AND TRMT_CODE = ? AND NVL(STATUS,'X') != 'E' AND NVL(TREATMENTS_OUTCOME,'X') != 'F' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,trmt_category_type);
				pstmt.setString(6,trmt_code);
				
				rst = pstmt.executeQuery();
				while(rst.next()){
					record_count = checkForNull(rst.getString("RECORD_COUNT"));
				}
			}
			else if(site_type.equals("QUAD")){
				pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND QUADRANT_SNO = ? AND TRMT_CATEGORY_TYPE = ? AND TRMT_CODE = ? AND NVL(STATUS,'X') != 'E' AND NVL(TREATMENTS_OUTCOME,'X') != 'F' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,trmt_category_type);
				pstmt.setString(6,trmt_code);
				
				rst = pstmt.executeQuery();
				while(rst.next()){
					record_count = checkForNull(rst.getString("RECORD_COUNT"));
				}
			}
			//Added by Sharon Crasta on 3/8/2010 for IN019607
			//Added to record the same Trmt in Either External Trmt or Trmt.
			else if(site_type.equals("MAXFS")){
			  String[] tooth_no_arr = null;
			  String record_count_temp = "";
			  String recorded_tooth_no = "";
			  String dec_ns_tooth_no="";
			  String sql1="";
			  if(tooth_no.indexOf(",") != -1){
				tooth_no_arr=tooth_no.split(",");
			    record_count = "";
			    
			    for(int i=0;i<tooth_no_arr.length;i++){
					pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND TRMT_CODE = ? AND INTRAORAL_EXTRAORAL = ? AND ORGAN_CODE = ? AND NVL(STATUS,'X') != 'E' AND NVL(TREATMENTS_OUTCOME,'X') != 'F' AND NVL(COND_CLOSED_YN,'N') = 'N'");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,tooth_no_arr[i]);
					pstmt.setString(5,trmt_category_type);
					pstmt.setString(6,trmt_code);
					pstmt.setString(7,intraoral_extraoral);
					pstmt.setString(8,organ_code);
					//pstmt.setString(9,sub_organ_code);
				
					rst = pstmt.executeQuery();
					while(rst.next()){
						record_count = checkForNull(rst.getString("RECORD_COUNT"));
					}

					if(Integer.parseInt(record_count)>0){
						dec_ns_tooth_no="";
						record_count_temp=record_count;
						sql1 = "SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?";
						pstmt1 = con.prepareStatement(sql1);
						pstmt1.setString(1,numbering_system);
						pstmt1.setString(2,tooth_no_arr[i]);
						rst1 = pstmt1.executeQuery();
						while(rst1!= null && rst1.next()){
							dec_ns_tooth_no = checkForNull(rst1.getString("NS_TOOTH_NO"));
						}
						
						//recorded_tooth_no+="$$"+tooth_no_arr[i];
						//recorded_tooth_no+="$$"+dec_ns_tooth_no;
						recorded_tooth_no=recorded_tooth_no+"$$"+dec_ns_tooth_no;
						//break;
					}
				}
				record_count=record_count_temp+recorded_tooth_no;
				
			  }else{
                if(!("").equals(tooth_no)){
					//	pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND TRMT_CODE = ? AND INTRAORAL_EXTRAORAL = ? AND ORGAN_CODE = ? AND SUB_ORGAN_CODE = ? AND NVL(STATUS,'X') != 'E' AND NVL(TREATMENTS_OUTCOME,'X') != 'F' AND NVL(COND_CLOSED_YN,'N') = 'N'");
					pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND TRMT_CODE = ? AND INTRAORAL_EXTRAORAL = ? AND ORGAN_CODE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(TREATMENTS_OUTCOME,'X') != 'F' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,tooth_no);
					pstmt.setString(5,trmt_category_type);
					pstmt.setString(6,trmt_code);
					pstmt.setString(7,intraoral_extraoral);
					pstmt.setString(8,organ_code);
					//pstmt.setString(9,sub_organ_code);
					pstmt.setString(9,super_tooth_no);
					pstmt.setString(10,retained_tooth_no);
				}else{
					pstmt = con.prepareStatement("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=?  AND TRMT_CATEGORY_TYPE = ? AND TRMT_CODE = ? AND INTRAORAL_EXTRAORAL = ? AND ORGAN_CODE = ? AND SUB_ORGAN_CODE = ? AND NVL(STATUS,'X') != 'E' AND NVL(TREATMENTS_OUTCOME,'X') != 'F' AND NVL(COND_CLOSED_YN,'N') = 'N'");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,trmt_category_type);
					pstmt.setString(5,trmt_code);
					pstmt.setString(6,intraoral_extraoral);
					pstmt.setString(7,organ_code);
					pstmt.setString(8,sub_organ_code);
				}
				
				rst = pstmt.executeQuery();
				while(rst.next()){
					record_count = checkForNull(rst.getString("RECORD_COUNT"));
				}
			  }
			}
			/* commmented by Sridevi joshi...This has to be written for both tooth and tooth range separated*/
			else{
                 // TREATMENTS_OUTCOME commented and add by parul on 11/02/2010 for CRF-477 & 496
				//sqlBuffer.append("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND TRMT_CODE = ? AND NVL(SURFACE_CODE,'K') = NVL(?,NVL(SURFACE_CODE,'K')) AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N' AND treatment_int_ext=? AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )");
				//sqlBuffer.append("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND TRMT_CODE = ? AND NVL(SURFACE_CODE,'K') = NVL(?,NVL(SURFACE_CODE,'K')) AND NVL(STATUS,'X') != 'E' AND NVL(TREATMENTS_OUTCOME,'X') != 'F' AND NVL(COND_CLOSED_YN,'N') = 'N' AND treatment_int_ext=? AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )");

				//Removed treatment_int_ext from query to make check common for Treatments and Ext Treatments by Sridevi Joshi on 3/9/2010 for IN019607
				sqlBuffer.append("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND TRMT_CODE = ? AND (NVL(SURFACE_CODE,'X') = NVL(?,'X') ) AND NVL(STATUS,'X') != 'E' AND NVL(TREATMENTS_OUTCOME,'X') != 'F' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )");

				
				
				if(trmt_category_type.equals("ROOTTMT") || trmt_category_type.equals("CROWN") ){
					if (!chart_line_num_Rtdesth.equals("0")){
						if (Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!trmt_category_type.equals("CARIES") && mixed_dentition_YN.equals("Y")  && permanent_deciduous_flag.equals("P"))){
							sqlBuffer.append(" AND A.CHART_LINE_NUM> ?");
							sqlBuffer.append(" AND HIDE_IMAGE_YN IN ('D','N','R')");
						}
						else if(Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
							sqlBuffer.append(" AND A.CHART_LINE_NUM> ?");								
						}
					}
				}
							  

				pstmt=con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,trmt_category_type);
				pstmt.setString(5,trmt_code);
				pstmt.setString(6,surface_code);
				pstmt.setString(7,super_tooth_no);
				pstmt.setString(8,retained_tooth_no);
		
				/*if (!chart_line_num_Rtdesth.equals("0")){
						if (Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!trmt_category_type.equals("CARIES") && mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P"))){
							pstmt.setString(10,chart_line_num_Rtdesth);
						}else if(Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
							pstmt.setString(10,chart_line_num_Rtdesth);
					}
				}*/
                	if(trmt_category_type.equals("ROOTTMT") || trmt_category_type.equals("CROWN") ){
					if (!chart_line_num_Rtdesth.equals("0")){
						if (Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!trmt_category_type.equals("CARIES") && mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P"))){
							pstmt.setString(9,chart_line_num_Rtdesth);
						}
						else if(Integer.parseInt(chart_line_num_Rtdesth) < chart_line_num && (!mixed_dentition_YN.equals("Y") && (permanent_deciduous_flag.equals("P") || permanent_deciduous_flag.equals("D")))){
							pstmt.setString(9,chart_line_num_Rtdesth);							
						}
					}
				}

				rst = pstmt.executeQuery();
				while(rst.next()){
					record_count = checkForNull(rst.getString("RECORD_COUNT"));
				}
			}
			out.println(record_count);
		}
		else if(func_mode.equalsIgnoreCase("getArchSno")){	
			String arch_tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String arch_sno = "";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if(!arch_tooth_no.equals("") && !arch_tooth_no.equals("undefined")){
				pstmt = con.prepareStatement("SELECT ARCH_SNO FROM OH_TOOTH WHERE TOOTH_NO = ?");
				pstmt.setString(1,arch_tooth_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					arch_sno = checkForNull(rst.getString("ARCH_SNO"));
				}
			}
			out.println(arch_sno);
		}
		else if(func_mode.equalsIgnoreCase("countExfTooth")){//added by parul on 251108 for SCR#6103
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type	= checkForNull(request.getParameter( "condition_type" )) ;
			String trmt_category_type	= checkForNull(request.getParameter( "trmt_category_type" )) ;

			String sql = "";		
			String record_count = "";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if(trmt_category_type.equals("IMPLANT")){
				sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ? AND NVL(STATUS,'X') != 'E'";
            }else{
				sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ? AND NVL(STATUS,'X') != 'E'";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			if(trmt_category_type.equals("IMPLANT")){
				pstmt.setString(5,trmt_category_type);
			}else{
				pstmt.setString(5,condition_type);

			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				record_count = checkForNull(rst.getString("RECORD_COUNT"));
				
			}
			out.println(record_count);
         }
		 else if(func_mode.equalsIgnoreCase("countExfToothForSUPRTH")){//added by parul on 251108 for SCR#6103
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type	= checkForNull(request.getParameter( "condition_type" )) ;
			String trmt_category_type	= checkForNull(request.getParameter( "trmt_category_type" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;

			String sql = "";		
			String record_count = "";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if(!RD_Normal_yn.equals("D") && !RD_Normal_yn.equals("MR") && !RD_Normal_yn.equals("M") && !RD_Normal_yn.equals("MRP")){
				sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ? AND NVL(STATUS,'X') != 'E' AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'D' AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'M'";
            }else{
				sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = ? AND NVL(STATUS,'X') != 'E'";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			if(trmt_category_type.equals("IMPLANT")){
				pstmt.setString(5,trmt_category_type);
			}else{
				pstmt.setString(5,condition_type);

			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				record_count = checkForNull(rst.getString("RECORD_COUNT"));
				
			}
			out.println(record_count);
         }
		 else if(func_mode.equalsIgnoreCase("allTypeConditionsRecorded")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String site = checkForNull(request.getParameter( "site" )) ; //Added by Sridevi Joshi on 4/21/2010 for IN020809
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			StringBuffer allRecords = new StringBuffer();
			StringBuffer recBuff = new StringBuffer();//Added by Sridevi Joshi on 4/21/2010 for IN020809
			if(oh_chart_level.equals("E")){
				//pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E'  AND NVL (HIDE_IMAGE_YN, 'X') != 'Y'  AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' UNION ALL SELECT 'MISSTH' CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I') AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('60','70','75','85','90'))"); 
				recBuff.append("SELECT CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ?");

				if(site.equals("QUAD")){
					recBuff.append(" AND QUADRANT_SNO   = ?");//Added by Sridevi Joshi on 4/21/2010 for IN020809
				}
				else{
					recBuff.append(" AND TOOTH_NO   = ?");
				}

				recBuff.append(" AND NVL (STATUS, 'X') != 'E'  AND NVL (HIDE_IMAGE_YN, 'X') != 'Y'  AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' UNION ALL SELECT 'MISSTH' CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I') AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('60','70','75','85','90'))");

				pstmt = con.prepareStatement(recBuff.toString());

				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,patient_id);
				pstmt.setString(5,chart_num);
				pstmt.setString(6,tooth_no);
				rst=pstmt.executeQuery();
			}
			else{ 
				//pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E'  AND NVL (HIDE_IMAGE_YN, 'X') != 'Y'  AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' UNION ALL SELECT 'MISSTH' CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I') AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('60','70','75','85','90')) ");

				recBuff.append("SELECT CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ?");

				if(site.equals("QUAD")){
					recBuff.append(" AND QUADRANT_SNO   = ?");//Added by Sridevi Joshi on 4/21/2010 for IN020809
				}
				else{
					recBuff.append(" AND TOOTH_NO   = ?");
				}

				recBuff.append(" AND NVL (STATUS, 'X') != 'E'  AND NVL (HIDE_IMAGE_YN, 'X') != 'Y'  AND TREATMENT_CONDITION = 'C' AND NVL (COND_CLOSED_YN, 'N') = 'N' UNION ALL SELECT 'MISSTH' CONDITION_TYPE, CONDITION_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO   = ? AND NVL (STATUS, 'X') != 'E' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT = 'I') AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND STATUS IN (SELECT E.ORDER_STATUS_CODE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_TYPE IN ('60','70','75','85','90')))");

				pstmt = con.prepareStatement(recBuff.toString());

				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,other_chart_facility_id);
				pstmt.setString(6,patient_id);
				pstmt.setString(7,chart_num);
				pstmt.setString(8,tooth_no);
				rst=pstmt.executeQuery();
					
			}
			while(rst.next()){
				allRecords.append(checkForNull(rst.getString("CONDITION_TYPE"))+"##"+checkForNull(rst.getString("CONDITION_CODE"))+"##"+checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"))+"##"+checkForNull(rst.getString("SUPERNUMERARY_YN"))+"##"+checkForNull(rst.getString("HIDE_IMAGE_YN"))+"##"+checkForNull(rst.getString("STATUS")));
				allRecords.append("~");
			}
		    out.println(allRecords);
		}else if(func_mode.equalsIgnoreCase("checkForRecordedData")){
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String super_tooth_ref = checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN = checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String retained_tooth_no ="" ;
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
           //added by parul on 11/01/2010 for super /retained changes
			/*if(super_tooth_ref.equals("RD")){
				retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			}*/
	      //end

		  if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){//Added by Sridevi Joshi on 4/8/2010 while attending IN020464
				if(!super_tooth_ref.equals("RD")){
					retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
				}
			}else{
		        if(super_tooth_ref.equals("RD")){
					retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
				}
			}
			StringBuffer CondRecorded = new StringBuffer();
			if(oh_chart_level.equals("E")){
				//pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND TREATMENT_CONDITION = 'C' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND TREATMENT_CONDITION = 'C' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'Z' AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,retained_tooth_no);
				rst=pstmt.executeQuery();
			}
			else{ 
			//	pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? and NVL(STATUS,'X') != 'E' AND TREATMENT_CONDITION = 'C' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND NVL(COND_CLOSED_YN,'N') = 'N'AND NVL(STATUS,'X') != 'Z'");


				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? and NVL(STATUS,'X') != 'E' AND TREATMENT_CONDITION = 'C' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND NVL(COND_CLOSED_YN,'N') = 'N'AND NVL(STATUS,'X') != 'Z'  AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,retained_tooth_no);
				rst=pstmt.executeQuery();
			}
			while(rst.next()){
				CondRecorded.append(checkForNull(rst.getString("CONDITION_TYPE"))+"##"+checkForNull(rst.getString("CHART_LINE_NUM")));
				CondRecorded.append("~");
			}
			out.println(CondRecorded);
         }else if(func_mode.equalsIgnoreCase("populateDeciduousToothNo")){	
			String tooth_numbering_system	= checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String sql				= "";		
			String tooth_no_val = "";
			String tooth_num_val = "";
			StringBuffer tooth_no_desc = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			sql = "SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'D' ORDER BY A.TOOTH_NO ASC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,tooth_numbering_system);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				tooth_no_val = checkForNull(rst.getString("TOOTH_NO"));
				tooth_num_val = checkForNull(rst.getString("TOOTH_NUM"));
				tooth_no_desc.append(tooth_no_val+"##"+tooth_num_val);
				tooth_no_desc.append("~");
			}
			out.println(tooth_no_desc);
		}else if(func_mode.equalsIgnoreCase("populateMDToothNo")){	
			String tooth_numbering_system	= checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String dflt_mixed_dentition_chart	= checkForNull(request.getParameter( "dflt_mixed_dentition_chart" )) ;
			String sql				= "";		
			String tooth_no_val = "";
			String tooth_num_val = "";
			StringBuffer tooth_no_desc = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if (dflt_mixed_dentition_chart.equals("P")){

				sql = "SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,tooth_numbering_system);

			}else if(dflt_mixed_dentition_chart.equals("D")){
			
				sql = "SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM =? AND (A.PERMANENT_DECIDUOUS = 'D' OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER ASC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,tooth_numbering_system);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				tooth_no_val = checkForNull(rst.getString("TOOTH_NO"));
				tooth_num_val = checkForNull(rst.getString("TOOTH_NUM"));
				tooth_no_desc.append(tooth_no_val+"##"+tooth_num_val);
				tooth_no_desc.append("~");
			}
			out.println(tooth_no_desc);
		//}else if(func_mode.equalsIgnoreCase("checkForRTDTH")){
		/* By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 06/08/09... To retrieve the chart_line_num of ERUPTH.If this value is less than the conditions/Treatments recorded on ROOT then 'drawLineForRootImage' fumction will not be called which will hide representation of all previous records on ROOT in MD-D chart.*/
		}else if(func_mode.equalsIgnoreCase("checkForERUPTH")){	
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String called_from = checkForNull(request.getParameter( "called_from" )) ;
			String super_retained_flag = checkForNull(request.getParameter( "super_retained_flag" )) ;
			String condition_type = "";
			int chart_line_num = 0;

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			
			if(called_from.equals("populateArea")){
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (SUPERNUMERARY_YN = 'N' OR SUPERNUMERARY_YN IS NULL) AND CONDITION_TYPE IN ('ERUPTH','EXFOLTH') ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst=pstmt.executeQuery();

				while(rst.next()){
					chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
				}
			}else{
				//pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND CONDITION_TYPE = 'ERUPTH' ORDER BY CHART_NUM, CHART_LINE_NUM");
				sqlBuffer.append("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND CONDITION_TYPE = 'ERUPTH'");
				if(super_retained_flag.equals("RD")){//added by parul on 18/12/2009 for super changes /retained changes.retained-->root invol on decoduos-->erupted-->root involv was not coming on deciduous
					sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
				}else{
					sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
				}
				sqlBuffer.append("  ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt=con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst=pstmt.executeQuery();

				while(rst.next()){
					condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
					
					if(condition_type.equals("ERUPTH")){
						chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
					}
				}
			}
		    out.println(chart_line_num);
		}else if(func_mode.equalsIgnoreCase("checkForPartially")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			int chart_line_num = 0;

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (SUPERNUMERARY_YN = 'N' OR SUPERNUMERARY_YN IS NULL) AND CONDITION_TYPE IN ('PARERTH') ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst=pstmt.executeQuery();

				while(rst.next()){
					chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
				}
		    out.println(chart_line_num);
		}
		else if(func_mode.equalsIgnoreCase("checkForEXFOLTH")){	//Added by Sridevi Joshi on 16/11/09 for IN016322
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type = "";
			int chart_line_num = 0;
			String isSuperCondYN = "";
			String isRetndCondYN = "";

			StringBuffer sqlBuffer = new StringBuffer();
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND CONDITION_TYPE IN ('RTDESTH','SUPRTH')");

			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst=pstmt.executeQuery();
			while(rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				
				if(condition_type.equals("SUPRTH")){
					isSuperCondYN = "Y";
				}else if(condition_type.equals("RTDESTH")){
					isRetndCondYN = "Y";
				}
			}


			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			//pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND CONDITION_TYPE = 'EXFOLTH' ORDER BY CHART_NUM, CHART_LINE_NUM");
			sqlBuffer.append("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND CONDITION_TYPE = 'EXFOLTH'");

			if(isSuperCondYN.equals("Y")){
				sqlBuffer.append(" AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N')");
			}else if(isRetndCondYN.equals("Y")){
				sqlBuffer.append(" AND (MIXED_DENT_DECIDUOUS_YN IS NULL OR MIXED_DENT_DECIDUOUS_YN = 'N')");
			}
			
			sqlBuffer.append(" ORDER BY CHART_NUM, CHART_LINE_NUM");

			pstmt = con.prepareStatement(sqlBuffer.toString());

			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst=pstmt.executeQuery();

			while(rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				
				if(condition_type.equals("EXFOLTH")){
					chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
				}
			}

		    out.println(chart_line_num);
		}else if(func_mode.equalsIgnoreCase("checkROOTINVOnDecth")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type = "";
			//String super_yn = "";
			//String DEC_yn = "";
			//String RD_recorded_flag = "N";
			String Replace_Image = "N";

			//StringBuffer RD_cond_type = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT CONDITION_TYPE, MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' ");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst=pstmt.executeQuery();

			while(rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				
				if(condition_type.equals("ERUPTH")){
					Replace_Image = "Y";
				}
			}
		    out.println(Replace_Image);
		}else if(func_mode.equalsIgnoreCase("getMultipleTasksFlag")){
			String multiple_task_yn = "";
			String treatment_code = checkForNull(request.getParameter( "treatment_code" )) ;
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT MULTIPLE_TASK_YN FROM OH_TREATMENT WHERE TRMT_CODE = ? ");
			pstmt.setString(1,treatment_code);
			rst=pstmt.executeQuery();

			while(rst.next()){
				multiple_task_yn = checkForNull(rst.getString("MULTIPLE_TASK_YN"));
			}
		    out.println(multiple_task_yn);
		}else if(func_mode.equalsIgnoreCase("getCountForTrmtTasks")){
			String trmt_tasks_count = "";
			String treatment_code = checkForNull(request.getParameter( "treatment_code" )) ;
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT COUNT(*) TASKS_COUNT FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ? ");
			pstmt.setString(1,treatment_code);
			rst=pstmt.executeQuery();

			while(rst.next()){
				trmt_tasks_count = checkForNull(rst.getString("TASKS_COUNT"));
			}
		    out.println(trmt_tasks_count);
		}else if(func_mode.equalsIgnoreCase("populateCompositionDetails")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code = checkForNull(request.getParameter( "task_code" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String seq_no = checkForNull(request.getParameter( "seq_no" )) ;
			/*String composition_class_code = "";
			String composition_code = "";
			String composition_class_desc = "";
			String composition_desc = "";*/
			int count = 1;

			

			//StringBuffer composition_buff = new StringBuffer();

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			}

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT B.COMPOSITION_CLASS_CODE, B.COMPOSITION_CLASS_DESC, C.COMPOSITION_CODE, C.COMPOSITION_DESC FROM OH_RESTORATIVE_CHART_MATRL A, OH_COMPOSITION_CLASS B, OH_COMPOSITION C, OH_TASKS_LANG D WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.TASK_SEQ = ? AND A.COMPOSITION_CLASS_CODE = B.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CLASS_CODE = C.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CODE = C.COMPOSITION_CODE AND B.COMPOSITION_CLASS_CODE	= C.COMPOSITION_CLASS_CODE AND A.TASK_CODE=D.TASK_CODE AND D.LANGUAGE_ID = ?");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,task_code);
				pstmt.setString(6,seq_no);
				pstmt.setString(7,locale);
				rst=pstmt.executeQuery();
			}
			else{
				pstmt = con.prepareStatement("SELECT B.COMPOSITION_CLASS_CODE, B.COMPOSITION_CLASS_DESC, C.COMPOSITION_CODE, C.COMPOSITION_DESC FROM OH_RESTORATIVE_CHART_MATRL A, OH_COMPOSITION_CLASS B, OH_COMPOSITION C, OH_TASKS_LANG D WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND  A.TASK_CODE = ? AND A.TASK_SEQ = ? AND A.COMPOSITION_CLASS_CODE = B.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CLASS_CODE = C.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CODE = C.COMPOSITION_CODE AND B.COMPOSITION_CLASS_CODE	= C.COMPOSITION_CLASS_CODE AND A.TASK_CODE=D.TASK_CODE AND D.LANGUAGE_ID = ?");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				pstmt.setString(6,task_code);
				pstmt.setString(7,seq_no);
				pstmt.setString(8,locale);
				rst=pstmt.executeQuery();
			}

			while(rst.next()){
				count++;
			}
		    out.println(count);
		}
		else if(func_mode.equalsIgnoreCase("populateCheckMobility")){//added by parul on 08/09/2009 for CRF#699
		
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String site_type	= checkForNull(request.getParameter( "site_type" )) ;
			//String record_count = "";
			String moblty_flag = "N";
			String[] tooth_no_arr = null;
			int max_count = 0;
			int z = 0;
			String sql = "";		
			String str = "";
			String super_tooth_count = "";
			String super_tooth_no = "";
			String retained_tooth_no = "";

			StringBuffer sb = new StringBuffer();
			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			if(super_tooth_ref.equals("RD")){
				retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			}
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
		
			if(tooth_no.indexOf(",") != -1){
				 tooth_no_arr=tooth_no.split(",");
					for(int i=0;i<tooth_no_arr.length;i++){
					str=tooth_no_arr[i];
					
					//sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'MOBLTY' AND NVL(STATUS,'X') != 'E'";

					sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'MOBLTY' AND NVL(STATUS,'X') != 'E' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,str);
					pstmt.setString(5,super_tooth_no);
					pstmt.setString(6,retained_tooth_no);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
						if(z==0){
							max_count = Integer.parseInt(checkForNull(rst.getString("RECORD_COUNT")));						
							if(max_count>0){
								moblty_flag="Y";
								z++;
							}else{
								moblty_flag="N";
							}
						}
					}

				}
			}else{

				//sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'MOBLTY' AND NVL(STATUS,'X') != 'E'";
				sb.append("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND ");
				//This block is added by Sridevi Joshi on 7/23/2010 to take the tooth_no diffrently for diffrent site types.
				if(site_type.equals("ARCH")){
					sb.append("ARCH_SNO = ? ");
				}
				else if(site_type.equals("QUAD")){
					sb.append("QUADRANT_SNO = ? ");
				}
				else{
					sb.append("TOOTH_NO = ? ");
				}

				sb.append("AND CONDITION_TYPE = 'MOBLTY' AND NVL(STATUS,'X') != 'E' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )");

				//sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'MOBLTY' AND NVL(STATUS,'X') != 'E' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') )";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					max_count = Integer.parseInt(checkForNull(rst.getString("RECORD_COUNT")));
				}
				if(max_count>0){
					moblty_flag="Y";
				}else{
					moblty_flag="N";
				}
			
			}
			out.println(moblty_flag);

		}
			else if(func_mode.equalsIgnoreCase("populateDisplayCondition")){//added by parul on 08/09/2009 for CRF#483
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			
			String sql = "";		
			String condition_type = "";
			StringBuffer condition_type_desc = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			//sql = "SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? AND NVL(STATUS,'X') != 'E'";
			sql = "SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? AND CONDITION_TYPE IN ('ERUPTH','EXFOLTH','DECITH','PARERTH','UNERTH','RTDESTH','SUPRTH') and NVL(STATUS,'X') != 'E' order by CONDITION_TYPE";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				condition_type_desc.append(condition_type);
				condition_type_desc.append("~");

			}
			out.println(condition_type_desc);
         }else if(func_mode.equalsIgnoreCase("populateDisplayRetainedCondition")){//added by parul on 08/09/2009 for CRF#483
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;

			String sql = "";		
			String retained_tooth_no = "";
			StringBuffer condition_type_desc = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			//sql = "SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? AND NVL(STATUS,'X') != 'E'";
			sql = "SELECT RETAINED_TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? AND CONDITION_TYPE IN ('ERUPTH','EXFOLTH','DECITH','PARERTH','UNERTH','RTDESTH','SUPRTH') and NVL(STATUS,'X') != 'E' order by CONDITION_TYPE";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				retained_tooth_no = checkForNull(rst.getString("RETAINED_TOOTH_NO"));
				condition_type_desc.append(retained_tooth_no);
				condition_type_desc.append("~");

			}
			out.println(condition_type_desc);
         }
		 else if(func_mode.equalsIgnoreCase("getDecithCondition")){//added by parul on 08/09/2009 for CRF#483
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			StringBuffer sqlBuffer = new StringBuffer();
			String condition_type = "";
			StringBuffer condition_type_desc = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			//sql = "SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? AND NVL(STATUS,'X') != 'E'";
			sqlBuffer.append("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND TOOTH_NO=? ");

			if (permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
				sqlBuffer.append("AND CONDITION_TYPE IN ('DECITH','PARERTH') and NVL(STATUS,'X') != 'E' order by CONDITION_TYPE");
			}else{
				sqlBuffer.append("AND CONDITION_TYPE IN ('DECITH') and NVL(STATUS,'X') != 'E' order by CONDITION_TYPE");

			}
			pstmt = con.prepareStatement(sqlBuffer.toString());
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				condition_type_desc.append(condition_type);
				condition_type_desc.append("~");

			}
			out.println(condition_type_desc);
         }
		 else if(func_mode.equalsIgnoreCase("populateMaxilaSurfaces")){	//added by parul for CRF 701 on 23/09/2009

			String area_val = checkForNull(request.getParameter( "area_val" ));
			String organ_code = "";
			String organ_desc = "";
			StringBuffer organ_code_name = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement("SELECT ORGAN_CODE,ORGAN_DESC FROM OH_ORGAN WHERE INTRAORAL_EXTRAORAL=?");
			pstmt.setString(1,area_val);
			rst=pstmt.executeQuery();
			while(rst!= null && rst.next()){
				organ_code = checkForNull(rst.getString("ORGAN_CODE"));
				organ_desc = checkForNull(rst.getString("ORGAN_DESC"));
				organ_code_name.append(organ_code+"##"+organ_desc);
				organ_code_name.append("~");
			}
		    out.println(organ_code_name);
		}else if(func_mode.equalsIgnoreCase("populateSubParts")){	//added by parul for CRF 701 on 23/09/2009

			String parts = checkForNull(request.getParameter( "parts" ));
			String sub_organ_code = "";
			String sub_organ_desc = "";
			StringBuffer sub_organ_code_name = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement("SELECT SUB_ORGAN_CODE,SUB_ORGAN_DESC FROM OH_SUB_ORGAN WHERE ORGAN_CODE=?");
			pstmt.setString(1,parts);
			rst=pstmt.executeQuery();
			while(rst!= null && rst.next()){
				sub_organ_code = checkForNull(rst.getString("SUB_ORGAN_CODE"));
				sub_organ_desc = checkForNull(rst.getString("SUB_ORGAN_DESC"));
				sub_organ_code_name.append(sub_organ_code+"##"+sub_organ_desc);
				sub_organ_code_name.append("~");
			}
		    out.println(sub_organ_code_name);
		}else if(func_mode.equalsIgnoreCase("populateMaxilaSurfacesDesc")){	//added by parul for CRF 701 on 23/09/2009

			String tooth_no_val = checkForNull(request.getParameter( "tooth_no_val" ));
			//String organ_code = "";
			String organ_desc = "";
			//StringBuffer organ_code_name = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement("SELECT ORGAN_DESC FROM OH_ORGAN WHERE ORGAN_CODE=?");
			pstmt.setString(1,tooth_no_val);
			rst=pstmt.executeQuery();
			while(rst!= null && rst.next()){
				organ_desc = checkForNull(rst.getString("ORGAN_DESC"));
			}
		    out.println(organ_desc);
		}else if(func_mode.equalsIgnoreCase("populateMaxilaSubPartsDesc")){	//added by parul for CRF 701 on 23/09/2009

			String tooth_no_val = checkForNull(request.getParameter( "tooth_no_val" ));
			String sub_organ_desc = "";
		//	StringBuffer organ_code_name = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement("SELECT SUB_ORGAN_DESC FROM OH_SUB_ORGAN WHERE SUB_ORGAN_CODE=?");
			pstmt.setString(1,tooth_no_val);
			rst=pstmt.executeQuery();
			while(rst!= null && rst.next()){
				sub_organ_desc = checkForNull(rst.getString("SUB_ORGAN_DESC"));
			}
		    out.println(sub_organ_desc);
		}
		else if(func_mode.equalsIgnoreCase("populateCANoteType")){	
			String note_type = "";
			String note_type_desc = "";
			StringBuffer note_type_buff = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement("SELECT NOTE_TYPE, NOTE_TYPE_DESC FROM CA_NOTE_TYPE A, CA_NOTE_GROUP B WHERE A.NOTE_GROUP_ID = B.NOTE_GROUP AND B.APPL_TASK_ID = 'OH'");
			rst=pstmt.executeQuery();
			while(rst!= null && rst.next()){
				note_type = checkForNull(rst.getString("NOTE_TYPE"));
				note_type_desc = checkForNull(rst.getString("NOTE_TYPE_DESC"));
				note_type_buff.append(note_type+"##"+note_type_desc);
				note_type_buff.append("~");
			}
		    out.println(note_type_buff);
		}
		else if(func_mode.equalsIgnoreCase("populateTrmtCatType")){	
			String trmt_category_type = "";
			StringBuffer note_type_buff = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE FROM OH_TREATMENT_CATEGORY_TYPE WHERE SPLTY_MODULE_ID = 'OH'");
			//pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE FROM OH_TREATMENT_CATEGORY_TYPE WHERE SPLTY_MODULE_ID = 'OH' AND NVL(HIDE_IMAGE_YN,'X') != 'Y'");
			rst=pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
				note_type_buff.append(trmt_category_type);
				note_type_buff.append("~");
			}
		    out.println(note_type_buff);
		}
		else if(func_mode.equalsIgnoreCase("populateMobilityDisplayCondition")){//added by parul on 08/09/2009 for CRF#483
				String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			StringBuffer sqlBuffer = new StringBuffer();
			//String record_count = "";
			String ext_flag = "N";
			String[] tooth_no_arr = null;
			int max_count = 0;
			int z = 0;
			String sql = "";		
			String str = "";
			//String mixed_dent_deciduous_yn = "";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if(tooth_no.indexOf(",") != -1){
				 tooth_no_arr=tooth_no.split(",");
					for(int i=0;i<tooth_no_arr.length;i++){
					str=tooth_no_arr[i];
					
					sql = "SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'EXFOLTH' AND NVL(STATUS,'X') != 'E'";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,str);
					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
						if(z==0){
							max_count = Integer.parseInt(checkForNull(rst.getString("RECORD_COUNT")));						
							if(max_count>0){
								ext_flag="Y";
								z++;
							}else{
								ext_flag="N";
							}
						}
					}

				}
			}else{

				sqlBuffer.append("SELECT COUNT(*) RECORD_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'EXFOLTH' AND NVL(STATUS,'X') != 'E'");

					if(RD_Normal_yn.equals("RD")){
						sqlBuffer.append("AND MIXED_DENT_DECIDUOUS_YN='R'");
					}else if (RD_Normal_yn.equals("N") || RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("undefined")){
						sqlBuffer.append("AND MIXED_DENT_DECIDUOUS_YN IS NULL AND SUPERNUMERARY_YN IS NULL");
					}else if (RD_Normal_yn.equals("S") || RD_Normal_yn.equals("MRS")){
					sqlBuffer.append("AND SUPERNUMERARY_YN ='Y'");
					}else if (RD_Normal_yn.equals("MR")){
					sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
					}

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					max_count = Integer.parseInt(checkForNull(rst.getString("RECORD_COUNT")));
				}
				if(max_count>0){
					ext_flag="Y";
				}else{
					ext_flag="N";
				}
			
			}
			out.println(ext_flag);
	}else if(func_mode.equalsIgnoreCase("populateToothNoForMobility")){	
			String tooth_numbering_system	= checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;	
			String sql				= "";		
			String tooth_no_val = "";
			String tooth_num_val = "";
			StringBuffer tooth_no_desc = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if(mixed_dentition_YN.equals("N")){
				sql = "SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = ? ORDER BY TOOTH_NO ASC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,permanent_deciduous_flag);
			}else{
				sql = "SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = ? ORDER BY TOOTH_NO ASC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,permanent_deciduous_flag);
			
			}

			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				tooth_no_val = checkForNull(rst.getString("TOOTH_NO"));
				tooth_num_val = checkForNull(rst.getString("TOOTH_NUM"));
				tooth_no_desc.append(tooth_no_val+"##"+tooth_num_val);
				tooth_no_desc.append("~");
			}
			out.println(tooth_no_desc);
		}
		else if(func_mode.equalsIgnoreCase("checkCondTrmtRecorded")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String site = checkForNull(request.getParameter( "site" )) ;
			String super_tooth_ref = checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String ret_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;

			String super_tooth_count = "";
			String super_tooth_no = "";
			String retained_tooth_no = "";

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			if(super_tooth_ref.equals("RD")){
				retained_tooth_no = ret_tooth_no;
			}

			StringBuffer sqlBuffer = new StringBuffer();
			StringBuffer allRecords = new StringBuffer();
			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT SITE_TYPE, TRMT_CATEGORY_TYPE, TRMT_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=?");

				/* These conditions added by Sridevi Joshi on 3/10/2010 for IN019942 */
				if(site.equals("ARCH")){
					sqlBuffer.append(" AND ARCH_SNO = ?");
				}
				else if(site.equals("QUAD")){
					sqlBuffer.append(" AND QUADRANT_SNO = ?");
				}
				else{
					sqlBuffer.append(" AND TOOTH_NO = ?");
				}

				/* End by Sridevi Joshi on 3/10/2010 for IN019942*/

				sqlBuffer.append(" AND NVL(STATUS,'X') != 'E' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND TREATMENT_CONDITION = 'T' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X')");
				//sqlBuffer.append(" AND NVL(STATUS,'X') != 'E' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND TREATMENT_CONDITION = 'T' AND NVL(COND_CLOSED_YN,'N') = 'N' ");

				pstmt = con.prepareStatement(sqlBuffer.toString());

				//pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE, TRMT_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND TREATMENT_CONDITION = 'T' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,super_tooth_no);
				pstmt.setString(5,retained_tooth_no);
				rst=pstmt.executeQuery();
			}
			else{ 

				sqlBuffer.append("SELECT SITE_TYPE, TRMT_CATEGORY_TYPE, TRMT_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=?");

				/* These conditions added by Sridevi Joshi on 3/10/2010 for IN019942 */
				if(site.equals("ARCH")){
					sqlBuffer.append(" AND ARCH_SNO = ?");
				}
				else if(site.equals("QUAD")){
					sqlBuffer.append(" AND QUADRANT_SNO = ?");
				}
				else{
					sqlBuffer.append(" AND TOOTH_NO = ?");
				}
				/* End by Sridevi Joshi on 3/10/2010 for IN019942*/

				sqlBuffer.append(" AND NVL(STATUS,'X') != 'E' AND TREATMENT_CONDITION = 'T' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X')");

				pstmt = con.prepareStatement(sqlBuffer.toString());

				//pstmt = con.prepareStatement("SELECT TRMT_CATEGORY_TYPE, TRMT_CODE, HIDE_IMAGE_YN, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND TREATMENT_CONDITION = 'T' AND NVL(HIDE_IMAGE_YN,'X') != 'Y' AND NVL(COND_CLOSED_YN,'N') = 'N'");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
				rst=pstmt.executeQuery();
			}
			while(rst.next()){
				allRecords.append(checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"))+"##"+checkForNull(rst.getString("SUPERNUMERARY_YN"))+"##"+checkForNull(rst.getString("HIDE_IMAGE_YN"))+"##"+checkForNull(rst.getString("STATUS"))+"##"+checkForNull(rst.getString("TRMT_CATEGORY_TYPE"))+"##"+checkForNull(rst.getString("TRMT_CODE"))+"##"+checkForNull(rst.getString("SITE_TYPE")));
				allRecords.append("~");
			}
			out.println(allRecords);		   
		}
		else if(func_mode.equalsIgnoreCase("getTrmtOnSuprth")){
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			//String surface_code	= checkForNull(request.getParameter( "surface_code" )) ;
		//	String site_type	= checkForNull(request.getParameter( "site_type" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String isRetndCondYN	= checkForNull(request.getParameter( "isRetndCondYN" )) ;
			String isSuperCondYN	= checkForNull(request.getParameter( "isSuperCondYN" )) ;
			String header_tab	= checkForNull(request.getParameter( "header_tab" )) ;
			
			StringBuffer allRecords_trmt = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			String condition_type1 = "";	
			String supernumerary_yn = "";
			//String Retnd_dec_yn = "";
			if(isSuperCondYN.equals("Y")){
				if(mixed_dentition_YN.equals("Y")){
					if(permanent_deciduous_flag.equals("P")){
						if(RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("DR")){
							supernumerary_yn="";
						}else {
							supernumerary_yn="Y";
						}
					}else{
						if(RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRP")){
								supernumerary_yn="";
							}else {
								supernumerary_yn="Y";
							}	
					}
				}else{
				  if(permanent_deciduous_flag.equals("D")){
					  if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}
					  }else if(permanent_deciduous_flag.equals("P")){
						   if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}

					  }
				}
			}
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
		
			//sqlBuffer.append("SELECT TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			sqlBuffer.append("SELECT TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N' AND TREATMENT_CONDITION = 'T'" );

			if(header_tab.equals("T")){
				sqlBuffer.append("AND TREATMENT_INT_EXT='I'");
			}
			else{
				sqlBuffer.append("AND TREATMENT_INT_EXT='E'");
			}

			if(isSuperCondYN.equals("Y")){
				if(supernumerary_yn.equals("Y")){
					sqlBuffer.append("AND SUPERNUMERARY_YN='Y'");
				}else{
					sqlBuffer.append("AND SUPERNUMERARY_YN IS NULL");
				}
			}
			
			if(isRetndCondYN.equals("Y")){
				if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
					if(RD_Normal_yn.equals("RD")){
						sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
					}else{
						sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
					}
				}else if(mixed_dentition_YN.equals("Y")){	
					if(permanent_deciduous_flag.equals("P")){
						if(RD_Normal_yn.equals("NR") || RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
						   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(permanent_deciduous_flag.equals("D")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}
				}
			}

			pstmt=con.prepareStatement(sqlBuffer.toString());
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);
			//pstmt.setString(4,condition_type);
	
			rst = pstmt.executeQuery();
			while(rst.next()){
				condition_type1 = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
				allRecords_trmt.append(condition_type1);
				allRecords_trmt.append("~");
			}				

			out.println(condition_type1);

		}
		else if(func_mode.equalsIgnoreCase("getExtractRecorded")){
			StringBuffer sqlBuffer = new StringBuffer();
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String isRetndCondYN	= checkForNull(request.getParameter( "isRetndCondYN" )) ;
			String isSuperCondYN	= checkForNull(request.getParameter( "isSuperCondYN" )) ;
			String header_tab	= checkForNull(request.getParameter( "header_tab" )) ;
			String cond_trmt_type	= checkForNull(request.getParameter( "cond_trmt_type" )) ;
			String for_missth_flag	= checkForNull(request.getParameter( "for_missth_flag" )) ;
			
			StringBuffer allRecords_trmt = new StringBuffer();
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			String condition_type1 = "";	
			String supernumerary_yn = "";
			//String Retnd_dec_yn = "";
			if(isSuperCondYN.equals("Y")){
				if(mixed_dentition_YN.equals("Y")){
					if(permanent_deciduous_flag.equals("P")){
						if(RD_Normal_yn.equals("NS") || RD_Normal_yn.equals("DR")){
							supernumerary_yn="";
						}else {
							supernumerary_yn="Y";
						}
					}else{
						if(RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRP") || RD_Normal_yn.equals("NS")){
								supernumerary_yn="";
							}else {
								supernumerary_yn="Y";
							}	
					}
				}else{
				  if(permanent_deciduous_flag.equals("D")){
					  if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}
					  }else if(permanent_deciduous_flag.equals("P")){
						   if(RD_Normal_yn.equals("S")){
							supernumerary_yn="Y";
						}else {
							supernumerary_yn="";
						}

					  }
				}
			}
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
		
			//sqlBuffer.append("SELECT TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = ?  AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			sqlBuffer.append("SELECT TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N' AND TREATMENT_CONDITION = 'T' AND TRMT_CATEGORY_TYPE = ?" );
			
			if(for_missth_flag.equals("Y")){
				sqlBuffer.append(" AND TREATMENT_INT_EXT='I'");
			}
			else if(header_tab.equals("T")){
				sqlBuffer.append(" AND TREATMENT_INT_EXT='I'");
			}
			else{
				sqlBuffer.append(" AND TREATMENT_INT_EXT='E'");
			}

			if(isSuperCondYN.equals("Y")){
				if(supernumerary_yn.equals("Y")){
					sqlBuffer.append(" AND SUPERNUMERARY_YN='Y'");
				}else{
					sqlBuffer.append(" AND SUPERNUMERARY_YN IS NULL");
				}
			}
			
			if(isRetndCondYN.equals("Y")){
				if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
					if(RD_Normal_yn.equals("RD")){
						sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
					}else{
						sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
					}
				}else if(mixed_dentition_YN.equals("Y")){	
					if(permanent_deciduous_flag.equals("P")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else{
						   sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}else if(permanent_deciduous_flag.equals("D")){
						if(RD_Normal_yn.equals("RD")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='R'");
						}else if (RD_Normal_yn.equals("MR") || RD_Normal_yn.equals("MRS")){
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN='M'");
						}else{
							sqlBuffer.append(" AND MIXED_DENT_DECIDUOUS_YN IS NULL");
						}
					}
				}
			}

			pstmt=con.prepareStatement(sqlBuffer.toString());
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);
			pstmt.setString(4,cond_trmt_type);
			//pstmt.setString(4,condition_type);
	
			rst = pstmt.executeQuery();
			while(rst.next()){
				condition_type1 = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
				allRecords_trmt.append(condition_type1);
				allRecords_trmt.append("~");
			}				

			out.println(condition_type1);

		}else if(func_mode.equalsIgnoreCase("checkForRTDESTH")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type = "";
			int chart_line_num = 0;
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
		
				//pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E'  AND NVL(COND_CLOSED_YN,'N') = 'N' AND CONDITION_TYPE = 'RTDESTH' ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E'  AND NVL(COND_CLOSED_YN,'N') = 'N' AND CONDITION_TYPE IN ('RTDESTH','DECITH') ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst=pstmt.executeQuery();

				while(rst.next()){
					condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
					
					if(condition_type.equals("RTDESTH") || condition_type.equals("DECITH")){
						chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
					}
				}
		    out.println(chart_line_num);
		}
		else if(func_mode.equalsIgnoreCase("getDecithChrtLineNum")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type	= checkForNull(request.getParameter( "condition_type" )) ;
			String chart_line_num = "";

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE = ? AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			pstmt.setString(5,condition_type);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				//condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				chart_line_num = checkForNull(rst.getString("CHART_LINE_NUM"));
			}
			out.println(chart_line_num);
		}
		else if(func_mode.equalsIgnoreCase("getMappedToothNo")){	
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;

			String retained_tooth_no = "";

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT MAPPED_TOOTH_NO FROM OH_TOOTH_LANG_VW WHERE TOOTH_NO = ?");
			pstmt.setString(1,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				retained_tooth_no = checkForNull(rst.getString("MAPPED_TOOTH_NO"));
			}
			out.println(retained_tooth_no);
		}
		else if(func_mode.equalsIgnoreCase("checkForExtract")){//Added by Sridevi Joshi on 12/23/2009 for IN017540 to get the status of Extraction treatment 
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			String sql = "";		
			String status = "";		
			
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				sql = "SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = 'EXTRACT' AND A.TREATMENT_INT_EXT ='I' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				sql = "SELECT (SELECT B.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE B WHERE B.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = 'EXTRACT' AND A.TREATMENT_INT_EXT ='I' AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				status = checkForNull(rst.getString("STATUS"));								
			}

			out.println(status);
        }else if(func_mode.equalsIgnoreCase("checkCrownApplicable")){	
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String crown_applicable	="" ;

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT CROWN_APPLICABLE FROM OH_TREATMENT WHERE TRMT_CODE=?");
			pstmt.setString(1,trmt_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				crown_applicable = checkForNull(rst.getString("CROWN_APPLICABLE"));
			}
			out.println(crown_applicable);
		}
		else if(func_mode.equalsIgnoreCase("checkSuperKey")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String RD_Normal_yn	= checkForNull(request.getParameter( "RD_Normal_yn" )) ;
			String super_key_val = "" ;

			StringBuffer super_key_val_buff = new StringBuffer();

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(!RD_Normal_yn.equals("D") && !RD_Normal_yn.equals("MR") && !RD_Normal_yn.equals("M") && !RD_Normal_yn.equals("MRP") && !RD_Normal_yn.equals("RD")){
				pstmt = con.prepareStatement("SELECT SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E' AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'D' AND NVL(MIXED_DENT_DECIDUOUS_YN,'Z') != 'M' ORDER BY SUPER_KEY_NUM");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					super_key_val = checkForNull(rst.getString("SUPER_KEY_NUM"));
					super_key_val_buff.append(super_key_val);
					super_key_val_buff.append("~");
				}
			}
			else{
				pstmt = con.prepareStatement("SELECT SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E' ORDER BY SUPER_KEY_NUM");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					super_key_val = checkForNull(rst.getString("SUPER_KEY_NUM"));
					super_key_val_buff.append(super_key_val);
					super_key_val_buff.append("~");
				}
			}
			/*
			pstmt = con.prepareStatement("SELECT SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH' AND NVL(STATUS,'X') != 'E' ORDER BY SUPER_KEY_NUM");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				super_key_val = checkForNull(rst.getString("SUPER_KEY_NUM"));
				super_key_val_buff.append(super_key_val);
				super_key_val_buff.append("~");
			}*/
			out.println(super_key_val_buff);
		}else if(func_mode.equalsIgnoreCase("ChkAllsurfacePopulation")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String super_tooth_no	= checkForNull(request.getParameter( "super_tooth_no" )) ;
			String retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			String treatment_int_ext	= checkForNull(request.getParameter( "treatment_int_ext" )) ;


			String surface_code	="" ;
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if(super_tooth_no.equals("undefined")){
			  super_tooth_no="";
			}

			//pstmt = con.prepareStatement("SELECT SURFACE_CODE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND TRMT_CATEGORY_TYPE='CROWN' AND TOOTH_NO=? AND CHART_NUM=? AND SUPER_KEY_NUM=? AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25','52','55','60','65','70','75','80', '85','90'))");
			pstmt = con.prepareStatement("SELECT SURFACE_CODE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND TRMT_CATEGORY_TYPE='CROWN' AND TOOTH_NO=? AND CHART_NUM=? AND NVL(STATUS,'X') != 'E' AND TREATMENT_INT_EXT=? AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') ) AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25','52','55','60','65','70','75','80', '85','90'))");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,tooth_no);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,treatment_int_ext);
			pstmt.setString(5,super_tooth_no);
			pstmt.setString(6,retained_tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				surface_code = checkForNull(rst.getString("SURFACE_CODE"));
			}
			out.println(surface_code);
		
		}else if(func_mode.equalsIgnoreCase("ChkAllsurface")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String surface_code	="" ;
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			pstmt = con.prepareStatement("SELECT SURFACE_CODE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND TRMT_CATEGORY_TYPE='CROWN' AND TOOTH_NO=? AND CHART_NUM=? ");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,tooth_no);
			pstmt.setString(3,chart_num);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				surface_code = checkForNull(rst.getString("SURFACE_CODE"));

			}

			out.println(surface_code);
		
		}else if(func_mode.equalsIgnoreCase("ChkAllsurfaceOnsuper")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String super_tooth_no	= checkForNull(request.getParameter( "super_tooth_no" )) ;
			String retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			String surface_code	="" ;
			String treatments_outcome	="" ;
			StringBuffer allRecords_trmt = new StringBuffer();

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			//pstmt = con.prepareStatement("SELECT SURFACE_CODE,TREATMENTS_OUTCOME FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND TRMT_CATEGORY_TYPE='CROWN' AND TOOTH_NO=? AND CHART_NUM=? AND TREATMENT_INT_EXT=? AND NVL(STATUS,'X') != 'E' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') ) ");
			pstmt = con.prepareStatement("SELECT SURFACE_CODE,TREATMENTS_OUTCOME FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND TRMT_CATEGORY_TYPE='CROWN' AND TOOTH_NO=? AND CHART_NUM=? AND NVL(STATUS,'X') != 'E' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') ) ");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,tooth_no);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,super_tooth_no);
			pstmt.setString(5,retained_tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				surface_code = checkForNull(rst.getString("SURFACE_CODE"));
				treatments_outcome = checkForNull(rst.getString("TREATMENTS_OUTCOME"));
                allRecords_trmt.append(surface_code+"##"+treatments_outcome);
                allRecords_trmt.append("~");

			}
			out.println(allRecords_trmt);
		
		}
		else if(func_mode.equalsIgnoreCase("checkForExtractionConditions")){
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String retained_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			StringBuffer sqlBuffer = new StringBuffer();
			String super_tooth_count = "";
			String super_tooth_no = "";

			int trmt_category_type_count = 0;

			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25','52','55','60','65','70','75','80', '85','90')) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X'))");
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,super_tooth_no);
				pstmt.setString(5,retained_tooth_no);
			}else{
				sqlBuffer.append("SELECT COUNT(*) TRMT_CATEGORY_TYPE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('25','52','55','60','65','70','75','80', '85','90')) AND NVL (HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X')) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X'))");	
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_category_type_count = Integer.parseInt(rst.getString("TRMT_CATEGORY_TYPE_COUNT"));								
			}
			out.println(trmt_category_type_count);
         }

		 else if(func_mode.equalsIgnoreCase("checkForTreatments")){ //Added by Sridevi Joshi for IN010871(SRR20056-CRF-0478)
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String trmt_category_type	= checkForNull(request.getParameter( "trmt_category_type" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String arch_quad	= checkForNull(request.getParameter( "arch_quad" )) ;
			String site	= checkForNull(request.getParameter( "site" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String ret_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String trmt_code = "";
			String denture_removable = "";
			String treatments_outcome = "";
			String trmt_category_code = "";
			String tooth_range = "";
			String status = "";
			String treatment_condition = "";
			String treatment_int_ext = "";
			String retained_tooth_no = "";
			String super_tooth_count = "";
			String super_tooth_no = "";

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			/*if(super_tooth_ref.equals("RD")){
				retained_tooth_no = ret_tooth_no;
			}*/

			if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){ //Added by Sridevi Joshi on 4/8/2010 for IN020464
				if(!super_tooth_ref.equals("RD")){
					retained_tooth_no = ret_tooth_no;
				}
			}else{
		        if(super_tooth_ref.equals("RD")){
					retained_tooth_no = ret_tooth_no;
				}
			}

			if(site.equals("ARCH") || site.equals("QUAD")){
				tooth_no = arch_quad;
			}
			
			StringBuffer sqlBuffer = new StringBuffer();
			StringBuffer trmt_buffer = new StringBuffer();
		
		   
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();

			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT A.TRMT_CODE, A.TREATMENTS_OUTCOME, A.TRMT_CATEGORY_CODE, A.TOOTH_RANGE, A.TREATMENT_CONDITION, A.TREATMENT_INT_EXT, (SELECT E.ORDER_STATUS_TYPE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, B.DENTURE_REMOVABLE FROM OH_RESTORATIVE_CHART_DTL A,OH_TREATMENT_CATEGORY B WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ?");
				
				if(site.equals("ARCH")){
					sqlBuffer.append(" AND A.ARCH_SNO = ?");
				}
				else if(site.equals("QUAD")){
					sqlBuffer.append(" AND A.QUADRANT_SNO = ?");
				}
				else{
					sqlBuffer.append(" AND A.TOOTH_NO = ?");
				}
					
				sqlBuffer.append(" AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = ? AND NVL (A.HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE AND NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X')");
				
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,trmt_category_type);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
			}else{
				sqlBuffer.append("SELECT A.TRMT_CODE, A.TREATMENTS_OUTCOME, A.TRMT_CATEGORY_CODE, A.TOOTH_RANGE, A.TREATMENT_CONDITION, A.TREATMENT_INT_EXT, (SELECT E.ORDER_STATUS_TYPE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, B.DENTURE_REMOVABLE FROM OH_RESTORATIVE_CHART_DTL A,OH_TREATMENT_CATEGORY B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ?");
				
				if(site.equals("ARCH")){
					sqlBuffer.append(" AND A.ARCH_SNO = ?");
				}
				else if(site.equals("QUAD")){
					sqlBuffer.append(" AND A.QUADRANT_SNO = ?");
				}
				else{
					sqlBuffer.append(" AND A.TOOTH_NO = ?");
				}
					
				sqlBuffer.append(" AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = ? AND NVL (A.HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE AND NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X')");

				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,trmt_category_type);
				pstmt.setString(6,super_tooth_no);
				pstmt.setString(7,retained_tooth_no);
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_code = checkForNull(rst.getString("TRMT_CODE"));	
				denture_removable = checkForNull(rst.getString("DENTURE_REMOVABLE"));	
				treatments_outcome = checkForNull(rst.getString("TREATMENTS_OUTCOME"));	
				trmt_category_code = checkForNull(rst.getString("TRMT_CATEGORY_CODE"));	
				tooth_range = checkForNull(rst.getString("TOOTH_RANGE"));	
				status = checkForNull(rst.getString("STATUS"));	
				treatment_condition = checkForNull(rst.getString("TREATMENT_CONDITION"));	
				treatment_int_ext = checkForNull(rst.getString("TREATMENT_INT_EXT"));	 
				trmt_buffer.append(trmt_code+"##"+denture_removable+"##"+treatments_outcome+"##"+trmt_category_code+"##"+tooth_range+"##"+status+"##"+treatment_condition+"##"+treatment_int_ext);
				//trmt_buffer.append(trmt_code+"##"+denture_removable+"##"+treatments_outcome);
				trmt_buffer.append("~");
				
			}
			
			//sqlBuffer1.append(trmt_buffer);

			out.println(trmt_buffer);
		}else if(func_mode.equalsIgnoreCase("checkForTreatmentsOnCrown")){ //Added by Sridevi Joshi for IN010871(SRR20056-CRF-0478)
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String trmt_category_type	= checkForNull(request.getParameter( "trmt_category_type" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String surface_code	= checkForNull(request.getParameter( "surface_code" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String ret_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String trmt_code = "";
			String treatments_outcome = "";
			String trmt_category_code = "";
			String tooth_range = "";
			String status = "";
			String treatment_condition = "";
			String treatment_int_ext = "";
			String super_tooth_count = "";
			String retained_tooth_no = "";
			String super_tooth_no = "";

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}
			if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
				retained_tooth_no = ret_tooth_no;
			}


			if(super_tooth_ref.equals("RD")){
				retained_tooth_no = ret_tooth_no;
			}


			StringBuffer sqlBuffer1 = new StringBuffer();
			StringBuffer ext_trmt_buffer = new StringBuffer();
		
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
				
			if(oh_chart_level.equals("E")){
				
				sqlBuffer1.append("SELECT A.TRMT_CODE, A.TREATMENTS_OUTCOME, A.TRMT_CATEGORY_CODE, A.TOOTH_RANGE, A.TREATMENT_CONDITION, A.TREATMENT_INT_EXT, (SELECT E.ORDER_STATUS_TYPE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A,OH_TREATMENT_CATEGORY B WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND NVL(A.SUPER_TOOTH_NO,'X') = NVL(?,'X') AND NVL(A.RETAINED_TOOTH_NO,'X') = NVL(?,'X')");	
				
			
				sqlBuffer1.append(" AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = ? AND NVL (A.HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE");
				if(surface_code.equals("*A")){
				 sqlBuffer1.append(" AND SURFACE_CODE='*A'");
				}else{
				   sqlBuffer1.append(" AND DECODE(INSTR(A.SURFACE_CODE,?),0,0,1) =1");
				}
                
				pstmt = con.prepareStatement(sqlBuffer1.toString());

				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				//pstmt.setString(3,surface_code);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,super_tooth_no);
				pstmt.setString(5,retained_tooth_no);
				pstmt.setString(6,trmt_category_type);
				if(!surface_code.equals("*A")){
					pstmt.setString(7,surface_code);
				}
				
			}else{
			      	sqlBuffer1.append("SELECT A.TRMT_CODE, A.TREATMENTS_OUTCOME, A.TRMT_CATEGORY_CODE, A.TOOTH_RANGE, A.TREATMENT_CONDITION, A.TREATMENT_INT_EXT, (SELECT E.ORDER_STATUS_TYPE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A,OH_TREATMENT_CATEGORY B WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND NVL(A.SUPER_TOOTH_NO,'X') = NVL(?,'X') AND NVL(A.RETAINED_TOOTH_NO,'X') = NVL(?,'X')");	
				
			
					sqlBuffer1.append(" AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = ? AND NVL (A.HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE");
					if(surface_code.equals("*A")){
					 sqlBuffer1.append(" AND SURFACE_CODE='*A'");
					}else{
					   sqlBuffer1.append(" AND DECODE(INSTR(A.SURFACE_CODE,?),0,0,1) =1");
					}

			
					pstmt = con.prepareStatement(sqlBuffer1.toString());
					pstmt.setString(1,other_chart_facility_id);
					pstmt.setString(2,chart_num);
					//pstmt.setString(3,surface_code);
					pstmt.setString(3,tooth_no);
					pstmt.setString(4,super_tooth_no);
					pstmt.setString(5,retained_tooth_no);
					pstmt.setString(6,trmt_category_type);
					if(!surface_code.equals("*A")){
						pstmt.setString(7,surface_code);
					}
			
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				trmt_code = checkForNull(rst.getString("TRMT_CODE"));	
				treatments_outcome = checkForNull(rst.getString("TREATMENTS_OUTCOME"));	
				trmt_category_code = checkForNull(rst.getString("TRMT_CATEGORY_CODE"));	
				tooth_range = checkForNull(rst.getString("TOOTH_RANGE"));	
				status = checkForNull(rst.getString("STATUS"));	
				treatment_condition = checkForNull(rst.getString("TREATMENT_CONDITION"));	
				treatment_int_ext = checkForNull(rst.getString("TREATMENT_INT_EXT"));	 
				ext_trmt_buffer.append(trmt_code+"##"+treatments_outcome+"##"+trmt_category_code+"##"+tooth_range+"##"+status+"##"+treatment_condition+"##"+treatment_int_ext);
				ext_trmt_buffer.append("~");

			}

		/*	if(pstmt1 != null) pstmt1.close();
			if(rst1 != null) rst1.close();*/

			//sql = "SELECT A.TRMT_CODE, A.TREATMENTS_OUTCOME, A.TRMT_CATEGORY_CODE, A.TOOTH_RANGE, A.TREATMENT_CONDITION, A.TREATMENT_INT_EXT, (SELECT E.ORDER_STATUS_TYPE  FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A,OH_TREATMENT_CATEGORY B WHERE A.PATIENT_ID = 'HC00001172' AND A.CHART_NUM = '8' AND A.SURFACE_CODE='2' AND A.TOOTH_NO ='13'  AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = 'CROWN' AND NVL (A.HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE";


			//sql = "SELECT count(*) max_count FROM OH_RESTORATIVE_CHART_DTL A,OH_TREATMENT_CATEGORY B WHERE A.PATIENT_ID = 'HC00001172' AND A.CHART_NUM = '8' AND A.SURFACE_CODE='2' AND A.TOOTH_NO ='3'  AND NVL (A.STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_TYPE = 'CROWN' AND NVL (A.HIDE_IMAGE_YN, 'X') != 'Y' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE";
			/*pstmt1 = con.prepareStatement("SELECT count(*) max_count FROM OH_RESTORATIVE_CHART_DTL A,OH_TREATMENT_CATEGORY B WHERE A.PATIENT_ID = 'HC00001172' AND A.CHART_NUM = '8' AND decode(instr(a.surface_code,''),0,0,1) =1 AND A.TOOTH_NO ='3'  AND A.TRMT_CATEGORY_TYPE = 'CROWN' AND NVL (A.STATUS, 'X') != 'E'  AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE");

			
			pstmt1.setString(1,patient_id);
			pstmt1.setString(2,chart_num);
			pstmt1.setString(3,surface_code);
			pstmt1.setString(4,tooth_no);
			//pstmt.setString(5,trmt_category_type);
			//pstmt1 = con.prepareStatement(sql);
			rst1 = pstmt1.executeQuery();
			//while(rst1!= null && rst1.next()){
			while(rst1.next()){
				trmt_code = checkForNull(rst1.getString("max_count"));	
				trmt_code = checkForNull(rst1.getString("TRMT_CODE"));	
				treatments_outcome = checkForNull(rst1.getString("TREATMENTS_OUTCOME"));	
				trmt_category_code = checkForNull(rst1.getString("TRMT_CATEGORY_CODE"));	
				tooth_range = checkForNull(rst1.getString("TOOTH_RANGE"));	
				status = checkForNull(rst1.getString("STATUS"));	
				treatment_condition = checkForNull(rst1.getString("TREATMENT_CONDITION"));	
				treatment_int_ext = checkForNull(rst1.getString("TREATMENT_INT_EXT"));	*/
	
			out.println(ext_trmt_buffer);
		}
		else if(func_mode.equalsIgnoreCase("ChkOutComeTreatments")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String ret_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;

			String trmt_category_type	="" ;
			String trmt_outcome	="" ;
			String denture_removable	="" ;
			String sql="" ;
			String super_tooth_no="" ;
			String super_tooth_count="" ;
			String retained_tooth_no="" ;

			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			/*if(super_tooth_ref.equals("RD")){
				retained_tooth_no = ret_tooth_no;
			}*/

			if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){//Added by Sridevi Joshi on 4/8/2010 for IN020464
				if(!super_tooth_ref.equals("RD")){
					retained_tooth_no = ret_tooth_no;
				}
			}else{
		        if(super_tooth_ref.equals("RD")){
					retained_tooth_no = ret_tooth_no;
				}
			}

			StringBuffer outcome_buff = new StringBuffer();
			//sql = "SELECT A.TRMT_CATEGORY_TYPE,A.TREATMENTS_OUTCOME,B.DENTURE_REMOVABLE  FROM OH_RESTORATIVE_CHART_DTL A,OH_TREATMENT_CATEGORY B WHERE A.PATIENT_ID=? AND A.CHART_NUM=? AND A.TOOTH_NO=? AND NVL (STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X'))";
			sql = "SELECT A.TRMT_CATEGORY_TYPE,A.TREATMENTS_OUTCOME,B.DENTURE_REMOVABLE  FROM OH_RESTORATIVE_CHART_DTL A,OH_TREATMENT_CATEGORY B WHERE A.PATIENT_ID=? AND A.CHART_NUM=? AND A.TOOTH_NO=? AND NVL (STATUS, 'X') != 'E' AND A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND NVL (COND_CLOSED_YN, 'N') = 'N' AND (NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') ) AND (NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X'))  AND SITE_TYPE IN ('TOOTH','THRNG','ARCH','QUAD')";
			
            if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,tooth_no);
			pstmt.setString(4,super_tooth_no);
			pstmt.setString(5,retained_tooth_no);
			rst = pstmt.executeQuery();
			while(rst.next()){
				trmt_category_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
				trmt_outcome = checkForNull(rst.getString("TREATMENTS_OUTCOME"));
				denture_removable = checkForNull(rst.getString("DENTURE_REMOVABLE"));
				outcome_buff.append(trmt_category_type+"##"+trmt_outcome+"##"+denture_removable);
				outcome_buff.append("~");
			}
			out.println(outcome_buff);
		}
		else if(func_mode.equalsIgnoreCase("populateCondTrmtsRecorded")){//Added by Sridevi Joshi on 2/21/2010 for IN019472
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			String tab_code	= checkForNull(request.getParameter( "tab_code" )) ;
			String super_tooth_ref	= checkForNull(request.getParameter( "super_tooth_ref" )) ;
			String ret_tooth_no	= checkForNull(request.getParameter( "retained_tooth_no" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String condition_type	="" ;
			String trmt_category_type	="" ;
			String retained_tooth_no	="" ;
			String super_tooth_count	="" ;
			String super_tooth_no	="" ;

			if 	(other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}

			StringBuffer cond_trmt_buff = new StringBuffer();
			StringBuffer sqlBuffer = new StringBuffer();

			if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_count = super_tooth_ref.substring(1);
			}

			if(!super_tooth_count.equals("")){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
				super_tooth_no = tooth_no+super_tooth_count;
			}

			/*if(super_tooth_ref.equals("RD")){
				retained_tooth_no = ret_tooth_no;
			}*/

			if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){//Added by Sridevi Joshi on 4/8/2010 while attending IN020464
				if(!super_tooth_ref.equals("RD")){
					retained_tooth_no = ret_tooth_no;
				}
			}else{
		        if(super_tooth_ref.equals("RD")){
					retained_tooth_no = ret_tooth_no;
				}
			}

            if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			if(oh_chart_level.equals("E")){
				sqlBuffer.append("SELECT CONDITION_TYPE,TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM= ? AND TOOTH_NO  = ? AND NVL (STATUS, 'X') != 'E' AND NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') AND NVL (COND_CLOSED_YN, 'N') = 'N'");
				
				if(tab_code.equals("ET") || tab_code.equals("DC")){
					sqlBuffer.append(" AND (TREATMENT_CONDITION = 'C' OR (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT='E'))");
				}
				else if(tab_code.equals("T")){
					sqlBuffer.append(" AND (TREATMENT_CONDITION = 'C' OR (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT='I'))");
				}
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,super_tooth_no);
				pstmt.setString(5,retained_tooth_no);
				rst = pstmt.executeQuery();
				
			}
			else{
				sqlBuffer.append("SELECT CONDITION_TYPE,TRMT_CATEGORY_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID  = ? AND PATIENT_ID = ? AND CHART_NUM= ? AND TOOTH_NO  = ? AND NVL (STATUS, 'X') != 'E' AND NVL(SUPER_TOOTH_NO,'X') = NVL(?,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(?,'X') AND NVL (COND_CLOSED_YN, 'N') = 'N'");

				if(tab_code.equals("ET") || tab_code.equals("DC")){
					sqlBuffer.append(" AND (TREATMENT_CONDITION = 'C' OR (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT='E'))");
				}
				else if(tab_code.equals("T")){
					sqlBuffer.append(" AND (TREATMENT_CONDITION = 'C' OR (TREATMENT_CONDITION = 'T' AND TREATMENT_INT_EXT='I'))");
				}
				pstmt = con.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,super_tooth_no);
				pstmt.setString(6,retained_tooth_no);
				rst = pstmt.executeQuery();
			}
			while(rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				trmt_category_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
				cond_trmt_buff.append(condition_type+"##"+trmt_category_type);
				cond_trmt_buff.append("~");
			}
			out.println(cond_trmt_buff);
		}else if(func_mode.equalsIgnoreCase("chkDupReasonCode")){	//Aded by rajesh for dup check Readon Code master 26/02/81
			String reason_code	= checkForNull(request.getParameter( "reason_code" )) ;
			String status	="" ;
			String sql="" ;
			sql = "SELECT 'X' STATUS FROM OH_REASONS WHERE REASON_CODE='"+reason_code+"' ";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				status = checkForNull(rst.getString("STATUS"));
			}
			out.println(status);
		}else if(func_mode.equalsIgnoreCase("updateOROrderCatalog")){	//added by parul on 25/05/2010 for IN021288
			String order_catalog_code	= checkForNull(request.getParameter( "order_catalog_code" )) ;
			String eff_status	= checkForNull(request.getParameter( "eff_status" )) ;
			int flag	= 0 ;
			String sql="" ;

			sql = "UPDATE OR_ORDER_CATALOG SET EFF_STATUS = ? WHERE ORDER_CATALOG_CODE=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,eff_status);
				pstmt.setString(2,order_catalog_code);
				flag = pstmt.executeUpdate();
			if(flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			out.println(flag);
		}else if(func_mode.equalsIgnoreCase("chkEffStatusForTask")){		//added by parul on 25/05/2010 for IN021288
			String task_code	= checkForNull(request.getParameter( "task_code" )) ;
			String status	="" ;
			String eff_status	="" ;
			String sql="" ;
			sql = "SELECT EFF_STATUS FROM OH_TASKS WHERE TASK_CODE=?";
			if(pstmt != null) pstmt.close();
			if(rst != null) rst.close();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,task_code);
			rst = pstmt.executeQuery();
			while(rst.next()){
				status = checkForNull(rst.getString("EFF_STATUS"));
			}
			out.println(status);
		}
		
		
	}catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from CommonValidation.jsp "+e);
		System.err.println("func_mode== "+func_mode);
	}
	finally{
		if(rst!=null) rst.close();
		if(rst1!=null) rst1.close();
		if(pstmt!=null)pstmt.close();
		if(pstmt1!=null)pstmt1.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

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
