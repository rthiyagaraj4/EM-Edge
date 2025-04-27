<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action			=	(String) hash.get("action")==null?"":(String) hash.get("action");

	if (action.equals("validateFacility")){
		String gstin_facility	= (String) hash.get("gstin_facility");
		int GSTINFacCnt			= eSM.SMCommonBean.getGSTINFacilityCnt(conn,gstin_facility);	
		out.println(GSTINFacCnt);
	} 

	else if(action.equals("getLinkedADUserDetails")){
		PreparedStatement pstmt	= null;
		ResultSet  rs			= null;
		String loginID			= (String) hash.get("loginID");
		loginID					= java.net.URLDecoder.decode(loginID,"UTF-8");
		String active_dir_id	= "";
		String appl_user_id		= "";
		String appl_user_paswd	= "";
		String appl_user_pin	= "";
		String user_dtls		= "";

		try{
			
			String sql = " SELECT active_dir_id, appl_user_id, app_password.decrypt (appl_user_password) AS appl_user_password, app_password.decrypt (pin_no) AS appl_user_pin FROM sm_appl_user WHERE upper(active_dir_id) = upper('"+loginID+"') ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()){

				active_dir_id = rs.getString("active_dir_id")==null?"":rs.getString("active_dir_id");
				appl_user_id = rs.getString("appl_user_id")==null?"":rs.getString("appl_user_id");
				appl_user_paswd = rs.getString("appl_user_password")==null?"":rs.getString("appl_user_password");
				appl_user_pin = rs.getString("appl_user_pin")==null?"":rs.getString("appl_user_pin");
			}	
						
		}catch(Exception ex){
			System.err.println("Exception in getLinkedADUserDetails - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}

		user_dtls = active_dir_id+"~"+appl_user_id+"~"+appl_user_paswd;
		
		out.println(user_dtls);
	}

	else if(action.equals("getEMUserLinkedToADUserDetails")){
		PreparedStatement pstmt	= null;
		ResultSet  rs			= null;
		String loginID			= (String) hash.get("loginID");
		loginID					= java.net.URLDecoder.decode(loginID,"UTF-8");
		String lnkd_actv_dir_id	= "";
		
		try{
			
			String sql = " SELECT active_dir_id FROM sm_appl_user WHERE upper(appl_user_id) = upper('"+loginID+"') ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()){

				lnkd_actv_dir_id = rs.getString("active_dir_id")==null?"":rs.getString("active_dir_id");
			}	
						
		}catch(Exception ex){
			System.err.println("Exception in getEMUserLinkedToADUserDetails - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		
		out.println(lnkd_actv_dir_id);
	}

	else if(action.equals("getADAndEMUserYN")){
		PreparedStatement pstmt_ad	= null;
		ResultSet  rs_ad			= null;
		PreparedStatement pstmt_em	= null;
		ResultSet  rs_em			= null;
		String loginID				= (String) hash.get("loginID");
		loginID						= java.net.URLDecoder.decode(loginID,"UTF-8");
		String sql_ad				= "";
		String sql_em				= "";
		String active_dir_id		= "";
		String appl_user_id			= "";
		String ad_em_user_yn		= "N";

		try{
			
			sql_ad = " SELECT active_dir_id FROM sm_appl_user WHERE upper(active_dir_id) = upper('"+loginID+"') ";
			
			pstmt_ad = conn.prepareStatement(sql_ad);
			rs_ad = pstmt_ad.executeQuery();
			
			if(rs_ad != null && rs_ad.next()){
				active_dir_id = rs_ad.getString("active_dir_id")==null?"":rs_ad.getString("active_dir_id");
			}

			if(!active_dir_id.equals("")){
				sql_em = " SELECT appl_user_id FROM sm_appl_user WHERE upper(appl_user_id) = upper('"+loginID+"') and active_dir_id is null ";
			
				pstmt_em = conn.prepareStatement(sql_em);
				rs_em = pstmt_em.executeQuery();
				
				if(rs_em != null && rs_em.next()){
					appl_user_id = rs_em.getString("appl_user_id")==null?"":rs_em.getString("appl_user_id");
				}

				if(!appl_user_id.equals("")){
					ad_em_user_yn = "Y";
				}
			}
						
		}catch(Exception ex){
			System.err.println("Exception in getADAndEMUserYN - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt_ad !=null) pstmt_ad.close();
				if(pstmt_em !=null) pstmt_em.close();
				if(rs_ad !=null) rs_ad.close();
				if(rs_em !=null) rs_em.close();
			}
			catch(Exception fe){
			}
		}
				
		out.println(ad_em_user_yn);
	}
	
	
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            
