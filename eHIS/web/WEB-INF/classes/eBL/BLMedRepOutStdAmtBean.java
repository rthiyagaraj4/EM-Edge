package eBL;


import java.sql.CallableStatement;
import java.sql.Connection;

import webbeans.eCommon.ConnectionManager;

public class BLMedRepOutStdAmtBean {	
	
private Double patOutstdAmt=0.0;

public Double getPatOutstdAmt() {
	return patOutstdAmt;
}


public void setPatOutstdAmt(Double patOutstdAmt) {
	this.patOutstdAmt = patOutstdAmt;
}

public Double fetchPatOutStdAmt(String facilityId,String patientId){
	Connection con = null;
	CallableStatement cstmt = null;		
	
	try{
		con = ConnectionManager.getConnection();
		Double outstandingAmt=0.0;
		
		cstmt = con.prepareCall("{call  bl_get_bill_gen_dtls .GET_PREV_OUTSTANDING(?,?,?,?)}");
		cstmt.setString( 1, patientId); 
		cstmt.registerOutParameter(2,java.sql.Types.NUMERIC);	
		cstmt.registerOutParameter(3,java.sql.Types.NUMERIC);
		cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
		cstmt.execute();
		outstandingAmt=cstmt.getDouble(2);
		System.err.println("outstandingAmt "+outstandingAmt);
		setPatOutstdAmt(outstandingAmt);
		
	}
	catch(Exception e){
		System.err.println("Exception in fetchPatOutStdAmt -> "+e); 
		e.printStackTrace();
	}
	finally
	{
		try{
			//cstmt = null;
			if(cstmt != null) cstmt.close(); //Added for checkstyle
			ConnectionManager.returnConnection(con);	
		}catch(Exception e){
			System.err.println("exception in blmedrepoutstdamtbean:"+e);
			e.printStackTrace();
		}			
	}
	return patOutstdAmt;		
}
}
