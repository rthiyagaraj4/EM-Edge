package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;

public final class __facilityselect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/FacilitySelect.jsp", 1719665427452L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n   ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

    request.setCharacterEncoding("UTF-8");


/////////////////////////////////////////////////////////////
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get("SEARCH") ;
	String  user_ID = (String) session.getValue( "login_user" ) ;
	String  responsibility_id = (String) hash.get("resp_ID")==null?"":(String) hash.get("resp_ID") ;
	String  from = (String) hash.get("from")==null?"":(String) hash.get("from") ;
	if(from==null)
		from="";
	String locale	= (String)session.getValue("LOCALE");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int fc_count=0;
	String fc_value=null;
	int facility_count = 0;
	//String bl_install_yn = "";
	//String mp_bl_count_str = "";
	//int mp_bl_count = 0;
	//String operational_yn = "";
	//String bl_operational = "N";
	String facSql ="";
	String restrict_facility_by_db="N";
	try{
		con = ConnectionManager.getConnection(request);
	/* get number of facilities start*/
	if(from.equals("onloadswitchresp")){
		session.putValue("Login","N");
	}else if(from.equals("changeresp")){
		//Commented for PE By Sudhakar Starts
		//try {	
			//pstmt = con.prepareStatement( "select count(*) as count from sm_facility_param where (facility_id,facility_name) in ( select sm_facility_for_user.facility_id, facility_name from sm_facility_for_user, sm_facility_param where appl_user_id = ? and 	sm_facility_for_user.facility_id = sm_facility_param.facility_id and ( sysdate between nvl(sm_facility_for_user.access_eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(sm_facility_for_user.access_eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param where resp_id = ? and sm_facility_for_resp.facility_id = sm_facility_param.facility_id )" ) ;
			/*pstmt = con.prepareStatement( "SELECT COUNT (*) AS COUNT  FROM sm_facility_param WHERE facility_id IN (SELECT facility_id FROM sm_facility_for_user WHERE appl_user_id = ?  AND (SYSDATE BETWEEN NVL (sm_facility_for_user.access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (sm_facility_for_user.access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT facility_id FROM sm_facility_for_resp WHERE resp_id = ? and sm_facility_for_resp.facility_id = sm_facility_param.facility_id)" ) ;
			pstmt.setString( 1, user_ID) ;
			pstmt.setString( 2, responsibility_id ) ;
			rs = pstmt.executeQuery() ;
			if ( rs != null && rs.next() )
			facility_count = rs.getInt( "count" ) ;
			if ( rs != null ) rs.close() ;
			if ( pstmt != null ) pstmt.close() ;
			} catch ( Exception e ) {
			}
			if ( facility_count == 0 ) {//no facility
				out.write(""+"^"+facility_count);
			}else if(facility_count == 1 ){//only one facility
				String curr_user="";
				String ins_facility_id="";
				String ins_facility_name="";
				ResultSet rs_test=null;
				Statement stmt_test=null;
				java.util.Properties pr = new java.util.Properties() ;
				pr=(java.util.Properties)session.getValue("jdbc") ;
				curr_user=pr.getProperty("login_user");
				try{
					//String facility_str="select facility_id,facility_name from sm_facility_param_lang_vw where language_id = '"+locale+"' and (facility_id,facility_name) in ( select sm_facility_for_user.facility_id, facility_name from sm_facility_for_user, sm_facility_param_lang_vw where appl_user_id = '"+curr_user+"' and sm_facility_for_user.facility_id = sm_facility_param_lang_vw.facility_id and ( trunc(sysdate) between nvl(sm_facility_for_user.access_eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(sm_facility_for_user.access_eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param_lang_vw where resp_id ='"+responsibility_id+"' and sm_facility_for_resp.facility_id = sm_facility_param_lang_vw.facility_id and language_id = '"+locale+"')";
					//String facility_str="select facility_id,facility_name from sm_facility_param_lang_vw where language_id = ? and (facility_id,facility_name) in ( select sm_facility_for_user.facility_id, facility_name from sm_facility_for_user, sm_facility_param_lang_vw where appl_user_id = ? and sm_facility_for_user.facility_id = sm_facility_param_lang_vw.facility_id and ( trunc(sysdate) between nvl(sm_facility_for_user.access_eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(sm_facility_for_user.access_eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param_lang_vw where resp_id =? and sm_facility_for_resp.facility_id = sm_facility_param_lang_vw.facility_id and language_id = ?)";
					String facility_str="SELECT facility_id, facility_name  FROM sm_facility_param_lang_vw WHERE language_id = ?   AND facility_id IN (SELECT facility_id FROM sm_facility_for_user WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (sm_facility_for_user.access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (sm_facility_for_user.access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT facility_id FROM sm_facility_for_resp WHERE resp_id = ?)";//Fine Tuned Above Query
					//stmt_test=con.createStatement();
					//rs_test = stmt_test.executeQuery(facility_str);
					pstmt = con.prepareStatement(facility_str);
					pstmt.setString(1,locale);
					pstmt.setString(2,curr_user);
					pstmt.setString(3,responsibility_id);
					//pstmt.setString(4,locale);
					rs_test=pstmt.executeQuery();
					if(rs_test !=null){
						while (rs_test.next()){
							ins_facility_id= rs_test.getString("facility_id");
							ins_facility_name= rs_test.getString("facility_name");
						}
					}
					fc_value=ins_facility_id+"~"+ins_facility_name;
					out.write(fc_value+"^"+facility_count);
					if(stmt_test!=null) stmt_test.close();
					if(rs_test!=null) rs_test.close();
				}catch ( Exception e ) {
					
					e.printStackTrace();
				}
		}else{//more than one facility*///Commented for PE By Sudhakar Ends
			try{
				//pstmt = con.prepareStatement( "select sm_facility_for_user.facility_id, facility_name from sm_facility_for_user, sm_facility_param_lang_vw sm_facility_param where appl_user_id = ? and language_id = '"+locale+"' and sm_facility_for_user.facility_id = sm_facility_param.facility_id and ( trunc(sysdate) between nvl(sm_facility_for_user.access_eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(sm_facility_for_user.access_eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param_lang_vw sm_facility_param where resp_id = ? and sm_facility_for_resp.facility_id = sm_facility_param.facility_id and language_id = '"+locale+"' order by 2" ) ;


				/* change starts for cross facility validation 17/Jul/2012*/
				
				try{
					pstmt = con.prepareStatement( "SELECT nvl(RESTRICT_FCY_BY_CURR_DB_YN,'N') RESTRICT_FCY_BY_CURR_DB_YN FROM SM_SITE_PARAM" ) ;
					rs = pstmt.executeQuery() ;					
					while(rs!=null && rs.next()){
						restrict_facility_by_db=rs.getString("RESTRICT_FCY_BY_CURR_DB_YN");
					}
				}catch ( Exception ex){
					restrict_facility_by_db="N";
				}finally{
					if (pstmt != null)pstmt.close();
					if (rs != null)rs.close();
				}

				if(restrict_facility_by_db.equals("Y")) {
					facSql = "SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = ?)  AND UPPER(CURR_DB)= 	(select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)-LENGTH(CURR_DB)+1, LENGTH(CURR_DB))) from sm_db_info) ORDER BY 2";
				}else{
					facSql = "SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = ?) ORDER BY 2";
				}
				/* change ends for cross facility validation*/	

				pstmt = con.prepareStatement( facSql ) ;//Fine Tuned Above Query
				pstmt.setString( 1, locale ) ;
				pstmt.setString( 2, user_ID ) ;
				pstmt.setString( 3, responsibility_id ) ;
				//pstmt.setString( 4, locale ) ;
				rs = pstmt.executeQuery() ;
				while(rs!=null && rs.next()){
					fc_count++;
					if(fc_count==1){
						fc_value=rs.getString( "facility_id" )+"~"+rs.getString( "facility_name" );
					}else{
					fc_value=fc_value+"$"+rs.getString( "facility_id" )+"~"+rs.getString( "facility_name" );
					}
				}
				out.write(fc_value+"^"+fc_count);
			}catch(Exception e){
				e.printStackTrace();
			}		
		//}//facility select during change resp		
	}else{//facility selection at login
		//int result = 0;
		facility_count=0;
		// Commented for PE Changes By Sudhakar
		/*try{			
			pstmt = con.prepareStatement("select count(*) as count from sm_facility_param where (facility_id) in ( select sm_facility_for_user.facility_id from sm_facility_for_user where appl_user_id = ? and ( trunc(sysdate) between nvl(sm_facility_for_user.access_eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(sm_facility_for_user.access_eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) intersect select sm_facility_for_resp.facility_id from sm_facility_for_resp where resp_id = ? )");
			pstmt.setString(1, user_ID);
			pstmt.setString(2, responsibility_id);   
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				result = rs.getInt("count");
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
				
		}catch (Exception e) {
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		facility_count=result;*/
		/* end of getting number of facilities */
		//String roleid = "";
		//String orarolepassword = "";
		try{
			/*try{
				pstmt = con.prepareStatement(" select install_yn from sm_module where module_id='BL' ");
				rs = pstmt.executeQuery();
				if (rs != null && rs.next()) {
					bl_install_yn = rs.getString("install_yn") == null ? "N" : rs.getString("install_yn");
				}
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			}catch (Exception e) {
			}
			if (bl_install_yn.equals("Y")) {
				try {
					pstmt = con.prepareStatement(" select count(*) from sm_modules_facility where module_id = 'BL' ");
					rs = pstmt.executeQuery();
					if (rs != null && rs.next()) {
						mp_bl_count_str = rs.getString(1) == null ? "0" : rs.getString(1);
					}
					mp_bl_count = Integer.parseInt(mp_bl_count_str);
					if (pstmt != null)
						pstmt.close();
					if (rs != null)
						rs.close();
				} catch (Exception e) {
				}
			}else{
				mp_bl_count = 0;
			}*/
			// Commented for PE Changes By Sudhakar Starts
			/*if (facility_count == 0) {              
				responsibility_id = (String) session.getValue("responsibility_id");
				try {                    
					pstmt = con.prepareStatement(" select ORA_ROLE_ID from sm_resp where RESP_ID = ? ");
					pstmt.setString(1, responsibility_id);                    
					rs = pstmt.executeQuery();                    
					if (rs!=null && rs.next()) {
						roleid = rs.getString("ORA_ROLE_ID") == null ? "" : rs.getString("ORA_ROLE_ID");
						if (roleid.equals("MEDADMIN")) {
							if (rs != null)
								rs.close();
							if (pstmt != null)
								pstmt.close();                            
							session.putValue("facility_id", "DF");
							session.putValue("facility_name", "Default Facility");                        
							pstmt = con.prepareStatement("select app_password.decrypt(ORA_ROLE_PASSWORD) ORA_ROLE_PASSWORD from sm_ora_role  where ORA_ROLE_ID = ? ");
							pstmt.setString(1, roleid);
							rs = pstmt.executeQuery();
							if (rs != null && rs.next())
								orarolepassword = rs.getString("ORA_ROLE_PASSWORD");
							String dbsql = " set role " + roleid+ " identified by " + orarolepassword + "  ";
							if (rs != null) rs.close();
							if (pstmt != null) pstmt.close();                            
							pstmt = con.prepareStatement(dbsql);              
							int r = pstmt.executeUpdate();
							r = r;
							if (pstmt != null) pstmt.close();                            
							if (bl_install_yn.equals("Y")) {
								try {                                 
									if(pstmt!=null) pstmt.close();
									pstmt = con.prepareStatement(" select operational_yn from sm_modules_facility where facility_id = 'DF' and module_id = 'BL' ");
									rs = pstmt.executeQuery();                                    
									if (rs != null && rs.next()) {
										operational_yn = rs.getString("operational_yn") == null ? "N" : rs.getString("operational_yn");
									}
									if (operational_yn.equals("Y")) {
										bl_operational = "Y";
									} else {
										bl_operational = "N";
									}
									session.putValue("bl_operational",bl_operational);
									if (rs != null) rs.close();
									if (pstmt != null) pstmt.close(); 
								} catch (Exception e) {out.println("Exception in acessing Billing Information:"+ e);
								}
							} else {
								bl_operational = "N";
								session.putValue("bl_operational", bl_operational);
							}
							if (mp_bl_count > 0)
								session.putValue("mp_bl_oper_yn", "Y");
							else
								session.putValue("mp_bl_oper_yn", "N");
							try {   
								out.write(""+"^"+facility_count);
							} catch (Exception e) {
								e.printStackTrace();
							}						
						} else {
							out.write(""+"^"+facility_count);

						}
					} else {
						out.write(""+"^"+facility_count);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				}else *//*if (facility_count == 1) {
					String curr_user = "";
					String ins_facility_id = "";
					String ins_facility_name = "";
					ResultSet rs_test = null;
					Statement stmt_test = null;
					java.util.Properties pr = new java.util.Properties();
					pr = (java.util.Properties) session.getValue("jdbc");
					curr_user = pr.getProperty("login_user");
					try{
					String facil_str = "select facility_id,NVL ((SELECT desc1_value FROM sm_oth_lang_data_skey WHERE table_id = 'SM_FACILITY_PARAM' AND pk_value = sm_facility_param.facility_id AND language_id = '"+locale+"'), sm_facility_param.facility_name ) facility_name from sm_facility_param where (facility_id) in ( select sm_facility_for_user.facility_id from sm_facility_for_user, sm_facility_param where appl_user_id = '"               + curr_user + "' and 	sm_facility_for_user.facility_id = sm_facility_param.facility_id and ( trunc(sysdate) between nvl(sm_facility_for_user.access_eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(sm_facility_for_user.access_eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) intersect select sm_facility_for_resp.facility_id from sm_facility_for_resp, sm_facility_param where resp_id ='"  + responsibility_id + "' and sm_facility_for_resp.facility_id = sm_facility_param.facility_id )";
					stmt_test = con.createStatement();
					rs_test = stmt_test.executeQuery(facil_str);
					if (rs_test != null) {
						while (rs_test.next()) {
							ins_facility_id = rs_test.getString("facility_id");
							ins_facility_name = rs_test.getString("facility_name");
						}                        
					}
					if (rs_test != null) rs_test.close();
					if (stmt_test != null) stmt_test.close();
					session.putValue("responsibility_id", responsibility_id);
					session.putValue("jdbc",pr);
					fc_value=ins_facility_id+"~"+ins_facility_name;
					out.write(fc_value+"^"+facility_count);
					}catch(Exception e){
					}
				}else{*/// Commented for PE Changes By Sudhakar Ends
					try{
					//String facsql = "select sm_facility_for_user.facility_id, facility_name from sm_facility_for_user, sm_facility_param_lang_vw sm_facility_param where appl_user_id =? and language_id = '"+locale+"' and sm_facility_for_user.facility_id = sm_facility_param.facility_id and ( (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) ) or (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO is null ) or (sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_FROM is null) or (sm_facility_for_user.ACCESS_EFF_DATE_FROM is null and sm_facility_for_user.ACCESS_EFF_DATE_TO is null ) ) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param_lang_vw sm_facility_param where resp_id = ?  and sm_facility_for_resp.facility_id = sm_facility_param.facility_id and language_id = '"+locale+"' order by 2";	
					
					/* change starts for cross facility validation 17/Jul/2012*/
					
					try{
						pstmt = con.prepareStatement( "SELECT nvl(RESTRICT_FCY_BY_CURR_DB_YN,'N') RESTRICT_FCY_BY_CURR_DB_YN FROM SM_SITE_PARAM" ) ;
						rs = pstmt.executeQuery() ;					
						while(rs!=null && rs.next()){
							restrict_facility_by_db=rs.getString("RESTRICT_FCY_BY_CURR_DB_YN");
						}
					}catch ( Exception ex){
						restrict_facility_by_db="N";
					}finally{
						if (pstmt != null)pstmt.close();
						if (rs != null)rs.close();
					}

					
					if(restrict_facility_by_db.equals("Y")) {
						facSql = "SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = ?)  AND UPPER(CURR_DB)= 	(select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)-LENGTH(CURR_DB)+1, LENGTH(CURR_DB))) from sm_db_info) ORDER BY 2";
					}else{
						facSql = "SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = ?) ORDER BY 2";
					}
					/* change ends for cross facility validation*/	


									
					pstmt = con.prepareStatement( facSql ) ;
					pstmt.setString( 1, locale ) ;
					pstmt.setString( 2, user_ID ) ;
					pstmt.setString( 3, responsibility_id ) ;
					rs = pstmt.executeQuery() ;
					while(rs!=null && rs.next()){
						fc_count++;
						if(fc_count==1){
							fc_value=rs.getString( "facility_id" )+"~"+rs.getString( "facility_name" );
						}else{
						fc_value=fc_value+"$"+rs.getString( "facility_id" )+"~"+rs.getString( "facility_name" );
						}
					}
					out.write(fc_value+"^"+fc_count);
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close(); // Thursday, May 13, 2010 venkat s
					}catch(Exception e){
						e.printStackTrace();
					}
				//} 

			}catch (Exception finalexe ) {
					finalexe.printStackTrace();
			}
	}
	hash.clear();
	}catch(Exception conex){
		conex.printStackTrace();
	}finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
