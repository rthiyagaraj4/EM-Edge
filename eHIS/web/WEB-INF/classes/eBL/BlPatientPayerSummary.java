package eBL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import webbeans.eCommon.ConnectionManager;
import eBL.Common.BlRepository;
import eBL.reprintreport.request.ReprintRequest;
import eBL.reprintreport.response.ReprintResponse;

public class BlPatientPayerSummary {

public ReprintResponse getPatientPayerSummary(ReprintRequest req)
{
	ReprintResponse response = new ReprintResponse();

	Connection con = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection();
		response.setStatus(true);
		
		String insertSql = BlRepository.getBlKeyValue("INSERT_SY_PROG_PARAM");
		cstmt=con.prepareCall(insertSql);
		cstmt.setString(1, req.getFacilityId());
		cstmt.setString(2, req.getReportId());
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.registerOutParameter(4, Types.VARCHAR);
		cstmt.setString(5,  req.getParam1());
		cstmt.setString(6,  req.getParam2());
		cstmt.setString(7,  req.getParam3());
		cstmt.setString(8,  req.getParam4());
		cstmt.setString(9,  req.getParam5());
		cstmt.setString(10, req.getParam6());
		cstmt.setString(11, req.getParam7());
		cstmt.setString(12, req.getParam8());
		cstmt.setString(13, req.getParam9());
		cstmt.setString(14, req.getParam10());
		cstmt.setString(15, req.getParam11());
		cstmt.setString(16, req.getParam12());
		cstmt.setString(17, null);
		cstmt.setString(18, null);
		cstmt.setString(19, null);
		cstmt.setString(20, null);
		cstmt.setString(21, null);
		cstmt.setString(22, null);
		cstmt.setString(23, null);
		cstmt.setString(24, null);
		cstmt.setString(25, null);
		cstmt.setString(26, null);
		cstmt.setString(27, null);
		cstmt.setString(28, null);
		cstmt.setString(29, null);
		cstmt.setString(30, null);
		cstmt.setString(31, null);
		cstmt.setString(32, null);
		cstmt.setString(33, null);
		cstmt.setString(34, null);
		cstmt.execute();
		
		response.setSessionId(cstmt.getString(3));
		response.setPgmDate(cstmt.getString(4));		
		
		if(response.isStatus()){
			con.commit();
		}
		else{
			con.rollback();
		}
		
		/*
		patPayerDtls.put("sessionId", cstmt.getString(3));
		patPayerDtls.put("pgmDate",cstmt.getString(4));
	*/
	}catch(Exception e)
	{
		System.err.println("Exception in BLPatientPayerSummary"+e);
		e.printStackTrace();
		response.setError(e.toString());
	}
	finally{
		try{
				if(cstmt != null) cstmt.close(); //Added for checkstyle
				//cstmt = null;
				rst = null;
				ConnectionManager.returnConnection(con);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	return response;
	//return patPayerDtls;	
	}
}
