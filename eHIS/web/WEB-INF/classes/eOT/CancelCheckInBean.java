/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;
/*import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import eOT.Common.* ;
import eCommon.Common.* ;*/


import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;

public class CancelCheckInBean extends OTAdapter implements Serializable {

	String	locale=null;
	Properties	p	=	null;
	public ArrayList getSysDateTime(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList result = new ArrayList(); 
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("DATE_TIME"));
				result.add(resultSet.getString("CURRENT_DATE"));
				result.add(resultSet.getString("HOURS_MTS"));
			}
		}catch ( Exception e ) {
			 e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return result;
	}

	public String getCancellerName(String slate_user_id){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String result = "";
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CANCEL_CHECK_IN_SELECT1")) ;
			pstmt.setString(1,slate_user_id);
			pstmt.setString(2,locale);
			resultSet = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result = resultSet.getString("APPL_USER_NAME");
			}
		}catch ( Exception e ) {
            e.printStackTrace();
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return result;
	}

	public String cancelCheckInDtls(HashMap map){
		Connection connection  = null;
		CallableStatement cstmt= null;
		String error_text = "";
		String status	  = "";
		try{
//OT_UPDATE_STATUS('20', <LOGGED IN FACILITY ID>, NULL, <OPER_NUM>, 
//NULL, NULL, NULL, <CANCEL_DATE_TIME>, <REASON_CODE>, NULL, NULL, NULL, NULL, 
//<USER ID>, <WORKSTATION NO>, <L_STATUS>, <L_ERROR_TEXT>);
//OT_UPDATE_STATUS(20,<LOGGED IN FACILITY ID>,null,oper_num,null,null,null,date,reason_code,null,null,null,null,?,?,?,?)
//OT_UPDATE_STATUS(20,'HC',null,'I050412007',null,null,null,'03/05/2005 09:00','SURGRQ',null,null,null,null,'ROGER','BALASUBRAMANIAN',?,?)
//{reason_code=SURGRQ, cancel_date=03/05/2005 09:00, slate_user_id=roger, oper_num=I050412007}
 


			connection	= getConnection() ;
			//cstmt=connection.prepareCall("{call OT_UPDATE_STATUS(?,?,null,?,null,null,null,?,?,null,null,null,null,?,?,?,?)}");
			cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,null,?,null,null,null,?,?,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,?,?,?,?,?)}");
			
			cstmt.setString(1,"20");	//Function ID
			cstmt.setString(2,login_facility_id);
			cstmt.setString(3,(String)map.get("oper_num"));
			cstmt.setString(4,(String)map.get("cancel_date"));
			cstmt.setString(5,(String)map.get("reason_code"));
			cstmt.setString(6,(String)map.get("slate_user_id"));
			cstmt.setString(7,login_at_ws_no);
			cstmt.registerOutParameter(8,Types.VARCHAR);
			cstmt.registerOutParameter(9,Types.VARCHAR);	
			cstmt.registerOutParameter(10,Types.VARCHAR);	
			cstmt.execute();
			connection.commit();
			status = cstmt.getString(8);
			if(status.equals("E")){
				error_text = cstmt.getString(9);
				error_text = cstmt.getString(10);
			}else{
				error_text = "RECORD_INSERTED";
			}
			cstmt.close();
		}
		catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                if(cstmt!=null) closeStatement( cstmt ) ;
                if(connection!=null) closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return error_text;
	}

}
