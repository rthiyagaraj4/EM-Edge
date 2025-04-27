/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
import java.util.Properties;

public class TransferToOTBean extends OTAdapter implements Serializable {
	Properties	p = this.properties;
	String	 locale	= "";
	public TransferToOTBean() {
        try {
			doCommon();
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
		}catch(Exception e) {}
	}
	public void doCommon() throws Exception {
	}
	public ArrayList getTheatreType(){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		ArrayList theatre_type=new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_TRANFER_TO_OT_SELECT1")) ;
			pstmt.setString(1,locale);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		        theatre_type.add(resultSet.getString(1));//location_type
				theatre_type.add(resultSet.getString(2));//short_description
			}
		}catch (Exception e){
	        e.printStackTrace() ;
		}
		finally{
		  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		  }catch(Exception e){}
		}
		return theatre_type;
	}

	public ArrayList getTheatreDesc(String locn_type,String multi_check_in_yn){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		ArrayList theatre_desc=new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			//Added For PMG2016-KDAH-CRF-0001 starts
			String Transfer_to_Ot_Query="";
			if(multi_check_in_yn.equals("Y")){
				Transfer_to_Ot_Query=OTRepository.getOTKeyValue("SQL_OT_TRANFER_TO_OT_SELECT2");				
			}else if(multi_check_in_yn.equals("N")){
				Transfer_to_Ot_Query=OTRepository.getOTKeyValue("SQL_OT_TRANFER_TO_OT_SELECT4");
			}
			
			pstmt	   = connection.prepareStatement(Transfer_to_Ot_Query) ;
			//Added For PMG2016-KDAH-CRF-0001 ends
			pstmt.setString(1,locale);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,locn_type);
			//Added For PMG2016-KDAH-CRF-0001 starts
			if(multi_check_in_yn.equals("N")){
				pstmt.setString(4,login_facility_id);
			}
			//Added For PMG2016-KDAH-CRF-0001 ends
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		        theatre_desc.add(resultSet.getString(1));//oper_room_code
				theatre_desc.add(resultSet.getString(2));//short_description
			}
		}catch (Exception e){
	        e.printStackTrace() ;
		}
		finally{
		  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		  }catch(Exception e){}
		}
		return theatre_desc;
	}

	public ArrayList getStatus(){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		ArrayList status_desc=new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			pstmt  = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_TRANFER_TO_OT_SELECT3")) ;
			pstmt.setString(1,locale);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
		        status_desc.add(resultSet.getString(1));//status_code
				status_desc.add(resultSet.getString(2));//status_description
			}
		}catch (Exception e){
	        e.printStackTrace() ;
		}
		finally{
		  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		  }catch(Exception e){}
		}
		return status_desc;
	}

	public String tranferToOTFromRecovery(HashMap map){
	Connection connection  = null;
	CallableStatement cstmt= null;
	String error_text = "";
	String status	  = "";
	String lang_error_text = "";
	try{
			connection	= getConnection();
			cstmt=connection.prepareCall("{call OT_TRFR_TO_OT_FROM_RECOVERY(?,?,?,?,?,null,null,null,?,?,?,?,?,?)}");
			cstmt.setString(1,login_facility_id);	//Function ID
			cstmt.setString(2,(String)map.get("oper_num"));
			cstmt.setString(3,(String)map.get("theatre"));
			cstmt.setString(4,(String)map.get("reason_code"));
			cstmt.setString(5,(String)map.get("status_code"));
			cstmt.setString(6,(String)map.get("slate_user_id"));
			cstmt.setString(7,login_at_ws_no);
			cstmt.registerOutParameter(8,Types.VARCHAR);
			cstmt.registerOutParameter(9,Types.VARCHAR);
			cstmt.registerOutParameter(10,Types.VARCHAR);
			cstmt.setString(11,(String)map.get("remarks_desc"));
			cstmt.execute();
			status = cstmt.getString(8);
			lang_error_text=cstmt.getString(10);
			//if(status!=null && !status.equals("null") && !status.equals("")){
				if(status.equals("E")) {
					error_text = cstmt.getString(9); // USED BEFORE tHAI CONVERSION
						//out.println(lang_error_text);
						error_text = lang_error_text;
						connection.rollback();
				} else {
					error_text = "RECORD_INSERTED";
					connection.commit();
				}
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                closeStatement( cstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }

		return error_text;
	}

			
}
		



