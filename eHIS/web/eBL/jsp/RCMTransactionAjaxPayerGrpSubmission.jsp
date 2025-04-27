
<%@page import="java.io.*"%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,eBL.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.util.*"%>

<%


System.out.println("Im here in persistence");


		
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String functionMode="";
	String payerGrpCode ="";
	
	String CLAIM_TRANS_ONLINE  = "N";
	String CLAIM_TRANS_OFFLINE = "N"; 
	
	String sql = null ; 
	
	functionMode = request.getParameter("func_mode");

	try{
	if(functionMode != null){
		if(functionMode.equals("submissionType")){
		    con = ConnectionManager.getConnection();
			payerGrpCode = request.getParameter("payer_grp_code");
			sql  = " select CLAIM_TRANS_ONLINE , CLAIM_TRANS_OFFLINE from AR_CUST_GROUP  where CUST_GROUP_CODE = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, payerGrpCode);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				    CLAIM_TRANS_ONLINE = (rs.getString("CLAIM_TRANS_ONLINE") != null) ? rs.getString("CLAIM_TRANS_ONLINE").trim() : "N";
	                CLAIM_TRANS_OFFLINE = (rs.getString("CLAIM_TRANS_OFFLINE") != null) ? rs.getString("CLAIM_TRANS_OFFLINE").trim() : "N";

                out.print(CLAIM_TRANS_ONLINE + "," + CLAIM_TRANS_OFFLINE); 
			}

		}
	}
	
	
	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception from RCMTransactionAjaxPayerGrpSubmission :" + e);
	} finally {
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
%>