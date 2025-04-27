/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
19/03/2020 	IN070345  		Ramesh Goli											MO-CRF-20147.1
-------------------------------------------------------------------------------------------------------------------------------------
*/  
package eCA;

import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public class CADocumentConfigBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	public List<FacilityDetailsBean> getFacilityDetails(FacilityDetailsBean facilityDetailsBean) throws Exception {
		List<FacilityDetailsBean> facilityDetailsList = new ArrayList<FacilityDetailsBean>() ;

		String facilityID = "";
		facilityID = facilityDetailsBean.getsFacilityId();

		Connection connection 		= null;
		PreparedStatement pstmt		= null;
		ResultSet rs 		= null;

		StringBuffer sqlStr = new StringBuffer("");
			
		sqlStr.append("SELECT FACILITY_ID, FACILITY_NAME,STATUS FROM SM_FACILITY_PARAM WHERE STATUS='E' ") ;
		
		
		if((facilityID != null) && (facilityID.length()>0))
		{			
			sqlStr.append(" AND FACILITY_ID =  ? ");
		}
				
		try {
			
			
			connection	= ConnectionManager.getConnection() ;
			pstmt = connection.prepareStatement(sqlStr.toString());
		
			if((facilityID != null) && (facilityID.length()>0))
			{
				pstmt.setString(1,facilityID);	
			}
			rs=pstmt.executeQuery();

			while ( rs != null && rs.next() ) {

				FacilityDetailsBean facilityDetails = new FacilityDetailsBean();

				facilityDetails.setsFacilityId(((rs.getString("facility_id") != null) ? rs.getString("facility_id") : "")) ;
				facilityDetails.setsFacilityName(((rs.getString("facility_name") != null) ? rs.getString("facility_name") : "")) ;
				facilityDetails.setsFacilityStatus(((rs.getString("status") != null) ? rs.getString("status") : "")) ;
				facilityDetailsList.add(facilityDetails);

			}	
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			 if ( rs != null ) rs.close() ;	
			 if ( pstmt != null ) pstmt.close() ;
			 ConnectionManager.returnConnection(connection);

		}
		return facilityDetailsList;
	}
	public HashMap<String,Object> getDocumentConfigDetails(String facilityID) throws Exception {
		ArrayList<CADocumentConfig> documentFuncitonList = new ArrayList<CADocumentConfig>() ;
		HashMap<String,ArrayList<CADocumentConfig>> documentMapDetails = new HashMap<String,ArrayList<CADocumentConfig>>();
		HashMap<String,Object> docConfigDetails = new HashMap<String,Object>();

		Connection connection 		= null;
		PreparedStatement pstmt		= null;
		ResultSet rs 		= null;
		
		String sqlStr = "SELECT DOC_FUNCTION_ID,DOC_FUNCTION_NAME,SEQ_NUMBER FROM CA_FUNCTION_DOC WHERE EFF_STATUS='E' ORDER BY SEQ_NUMBER " ;			
				
		try {		
			
			connection	= ConnectionManager.getConnection() ;
			pstmt = connection.prepareStatement(sqlStr.toString());			
			rs=pstmt.executeQuery();
			while ( rs != null && rs.next() ) {
				CADocumentConfig docConfig = new CADocumentConfig();
				docConfig.setDocFuncitonId(rs.getString("DOC_FUNCTION_ID") == null?"":(String)rs.getString("DOC_FUNCTION_ID"));
				docConfig.setDocFunctionName(rs.getString("DOC_FUNCTION_NAME") == null?"":(String)rs.getString("DOC_FUNCTION_NAME"));
				documentFuncitonList.add(docConfig);
				ArrayList<CADocumentConfig> docConfigList=new ArrayList<CADocumentConfig>();
				docConfigList =getConfigurationList(connection,(rs.getString("DOC_FUNCTION_ID") == null?"":(String)rs.getString("DOC_FUNCTION_ID")),facilityID);
				documentMapDetails.put((rs.getString("DOC_FUNCTION_ID") == null?"":(String)rs.getString("DOC_FUNCTION_ID")), docConfigList);
			}
			docConfigDetails.put("DOCFUNCTIONLIST", documentFuncitonList);
			docConfigDetails.put("DOCFUNCTIONLISTDETAILS", documentMapDetails);
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			 if ( rs != null ) rs.close() ;	
			 if ( pstmt != null ) pstmt.close() ;
			 ConnectionManager.returnConnection(connection);

		}
		return docConfigDetails;
	}
	public ArrayList<CADocumentConfig> getConfigurationList(Connection connection,String docFunctionId,String facilityID) throws Exception {
		ArrayList<CADocumentConfig> docConfigList = new ArrayList<CADocumentConfig>() ;
		PreparedStatement pstmt1		= null;
		ResultSet rs1 		= null;		
		String sqlStr = "SELECT A.DOC_FUNCTION_ID,A.DOC_SUB_FUNCTION_ID,A.DOC_SUB_FUNCTION_NAME,A.DOC_FOLDER_NAME,A.SEQ_NUMBER, NVL(B.DOC_STORED_TYPE,'D') DOC_STORED_TYPE,B.DOC_STORED_PATH  FROM  CA_FUNCTION_DOC_DTL A LEFT JOIN CA_FUNCITON_DOC_CONFIG_DTL B ON A.DOC_SUB_FUNCTION_ID=B.DOC_SUB_FUNCTION_ID AND B.FACILITY_ID=? WHERE A.DOC_FUNCTION_ID =? AND A.EFF_STATUS='E' ORDER BY A.SEQ_NUMBER " ;			
		
		try {
			pstmt1 = connection.prepareStatement(sqlStr.toString());	
			pstmt1.setString(1, facilityID);
			pstmt1.setString(2, docFunctionId);
			rs1=pstmt1.executeQuery();
			
			while ( rs1 != null && rs1.next() ) {

				CADocumentConfig docConfig = new CADocumentConfig();

				docConfig.setDocSubFuncitonId(rs1.getString("DOC_SUB_FUNCTION_ID") == null ? "":(String) rs1.getString("DOC_SUB_FUNCTION_ID")) ;
				docConfig.setDocSubFunctionName(rs1.getString("DOC_SUB_FUNCTION_NAME") == null ? "": (String)rs1.getString("DOC_SUB_FUNCTION_NAME") ) ;
				docConfig.setDocFolderName(rs1.getString("DOC_FOLDER_NAME") == null ? "": (String)rs1.getString("DOC_FOLDER_NAME") ) ;
				docConfig.setDocStoredType(rs1.getString("DOC_STORED_TYPE") == null ? "": (String)rs1.getString("DOC_STORED_TYPE")) ;
				docConfig.setDocStoredPath(rs1.getString("DOC_STORED_PATH") == null ? "": (String)rs1.getString("DOC_STORED_PATH") ) ;
				docConfig.setDocSeqNumber(rs1.getString("SEQ_NUMBER") == null ? "" : (String)rs1.getString("SEQ_NUMBER")) ;
				
				docConfigList.add(docConfig);

			}	

			
		}catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			 if ( rs1 != null ) rs1.close() ;	
			 if ( pstmt1 != null ) pstmt1.close() ;

		}
		return docConfigList;
	}

}	