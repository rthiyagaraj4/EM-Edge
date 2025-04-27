
<%@page import="eBL.Common.BlRepository"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Properties"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="java.sql.Date"%>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,  eCommon.Common.*, webbeans.eCommon.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection();	
	con.setAutoCommit(false);
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String func_id = request.getParameter("func_id") == null ? "" :request.getParameter("func_id") ;
	String mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
	String autoFillSearchList = request.getParameter("autoFillSearchList") == null ? "" :request.getParameter("autoFillSearchList") ;
	Properties p;
	String facilityId = "";
	String userId = "";
	String clienIpAddress="";
	String searchDispFields = "";
	int recordCount = 0;
	//HashMap<String,String> searchFieldMap = new HashMap<String,String> ();
	
try{

	facilityId	= (String) session.getValue( "facility_id" );
	p = (Properties) session.getValue( "jdbc" );
	clienIpAddress = p.getProperty("client_ip_address");
	userId = p.getProperty( "login_user" );

	String loadCriteriaQuery = 	BlRepository.getBlKeyValue("DFLT_SEARCH_LOAD_CRITERIA");
	String checkRecordCount = 	BlRepository.getBlKeyValue("DFLT_SEARCH_RECORD_COUNT");
	String insertNewCriteria = BlRepository.getBlKeyValue("DFLT_SEARCH_INSERT_NEW");
	String updateExistingCriteria = BlRepository.getBlKeyValue("DFLT_SEARCH_UPDATE_EXISTING");
									
	if("LoadCriteria".equals(mode)){
		pstmt = con.prepareStatement(loadCriteriaQuery);
		pstmt.setString(1, facilityId);
		pstmt.setString(2, userId);
		pstmt.setString(3, func_id);
		rst = pstmt.executeQuery();
		if(rst != null){
			while(rst.next()){
				searchDispFields = rst.getString("SEARCH_DISPL_FIELDS");
			}
		}
		
		if(searchDispFields == null){
			/*String searcfFieldsArr [] = searchDispFields.split(":::");
			for(int i=0;i<searcfFieldsArr.length;i++){
				String searcfIndFieldsArr[] = searcfFieldsArr[i].split("=");
				if(searcfIndFieldsArr.length == 2){
					searchFieldMap.put(searcfIndFieldsArr[0], searcfIndFieldsArr[1]);
				}				
			}*/
			searchDispFields = "";
		}
	}
	else if("SaveCriteria".equals(mode)){
		pstmt = con.prepareStatement(checkRecordCount);
		pstmt.setString(1, facilityId);
		pstmt.setString(2, userId);
		pstmt.setString(3, func_id);
		rst = pstmt.executeQuery();
		if(rst != null){
			while(rst.next()){
				recordCount = rst.getInt("Total");
			}
		}
		
		if(recordCount > 0){
			pstmt = con.prepareStatement(updateExistingCriteria);
			pstmt.setString(1, autoFillSearchList);
			pstmt.setString(2, userId);
			pstmt.setString(3, clienIpAddress);
			pstmt.setString(4, facilityId);
			pstmt.setString(5, facilityId);
			pstmt.setString(6, func_id);			
			pstmt.setString(7, userId);
			pstmt.execute();
		}
		else{
			pstmt = con.prepareStatement(insertNewCriteria);
			pstmt.setString(1, facilityId);
			pstmt.setString(2, func_id);
			pstmt.setString(3, userId);
			pstmt.setString(4, autoFillSearchList);
			pstmt.setString(5, userId);
			pstmt.setString(6, userId);
			pstmt.setString(7, clienIpAddress);
			pstmt.setString(8, clienIpAddress);
			pstmt.setString(9, facilityId);
			pstmt.setString(10, facilityId);
			pstmt.execute();
		}
		
		con.commit();
		searchDispFields = "Criteria Saved Successfully";
	}	
	out.println(searchDispFields);	
	}catch (Exception e) {
		e.printStackTrace() ;
		System.err.println("Exception from Auto Fill Search Criteria :"+e);
		con.rollback();
	}
	finally
		{	
			pstmt.close();//V210413
			rst.close();//V210413
			ConnectionManager.returnConnection(con, request);		
		}
%>
