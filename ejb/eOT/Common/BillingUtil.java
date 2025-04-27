/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.Common ;
import webbeans.eCommon.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.HashMap;

//helper classes getEpisodeType,getMessage,getBillingEpisodeType,nullSafe
/*
   @method getEpiosdeType(Patient_Class)  
   @returns EpisodeType
   @param  Patient_Class

   @method getBillingEpisodeType(patient_class,episode_type)  
   @returns BillingEpisode
   @param  patient_class & episode_type

   @method getMessage(messageId)  
   @returns Message for that particular Id
   @param  MessageId

   @method nullSafe(String)  
   @returns empty string when passing string is null or "null" otherwise returns normal string
   @param  String

*/

public class BillingUtil
{
	public static String getEpisodeType(String patient_class){
        PreparedStatement pstmt = null;
        ResultSet resultSet     = null;
		Connection con = null;
		String result	 = "";
		
		try{
			con			= ConnectionManager.getConnection();
			pstmt			= con.prepareStatement("SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = ?");
			pstmt.setString(1,patient_class);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result  = resultSet.getString("EPISODE_TYPE1");
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				  if(resultSet!=null)resultSet.close();
				  if(pstmt!=null) pstmt.close();
				  if(con!=null)
				  ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
				 // if(con!=null)con.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return result;
}


public static String getMessage(String mesg_id){
	Connection con = null;
	StringBuilder sbr = new StringBuilder();
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String err_desc = "";
	String err_mesg = "";
	String SQL="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = ?";
	try{
		con = ConnectionManager.getConnection();
		pstmt=con.prepareStatement(SQL);
		pstmt.setString(1,mesg_id);
		rst = pstmt.executeQuery();
		//int count=0; //Commented Against AAKH-ICN-0008
		 while(rst.next()){
			 err_desc=rst.getString(1);
		 }
	}catch(Exception e){
		System.err.println("Billing Util Err Mesg in getMessage Function"+e);
	}finally{
		try{
			sbr.setLength(0);
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
			//con.close();
		}catch(Exception e){e.printStackTrace();}
	}
	return err_mesg;
}

 public static String getBillingEpisodeType(String patient_class,String episode_type){
		Connection con  = null;
		PreparedStatement pstmt=null;
		ResultSet rst  = null;
		String bl_episode_type = "";
		String SQL="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE  PATIENT_CLASS=? AND EPISODE_TYPE =?";
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(SQL) ;
			pstmt.setString(1,patient_class);
			pstmt.setString(2,episode_type);
			rst= pstmt.executeQuery();
				while(rst.next()){
					bl_episode_type=rst.getString(1);
			}			
		}catch (Exception e){
	          System.err.println("Billing Util Err Msg in getBillingEpisodeType(OTCommonBean) "+e.getMessage());
		}
		finally{
		  try{
                if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null)
			    ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
				//con.close();
		  }catch(Exception e){e.printStackTrace();}
		}
		return bl_episode_type;
 }

public static String getBillingEpisodeType(String patient_class){
		Connection con  = null;
		PreparedStatement pstmt=null;
		ResultSet rst  = null;
		String bl_episode_type = "";
		String SQL="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE  PATIENT_CLASS=? ";
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(SQL) ;
			pstmt.setString(1,patient_class);
			rst= pstmt.executeQuery();
				while(rst.next()){
					bl_episode_type=rst.getString(1);
			}			
		}catch (Exception e){
	          System.err.println("Billing Util Err Msg in getBillingEpisodeType(OTCommonBean) "+e.getMessage());
		}
		finally{
		  try{
                if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null)
			ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
				//con.close();
		  }catch(Exception e){e.printStackTrace();}
		}
		return bl_episode_type;
 }


public static String getOrderLineNumber(String facility_id,String oper_num,String oper_code){
		PreparedStatement pstmt = null;
        ResultSet resultSet     = null;
		Connection con = null;
		String result	 = "";
		try{
			con			= ConnectionManager.getConnection();
			pstmt			= con.prepareStatement("SELECT ORDER_LINE_NUM FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID=? AND  OPER_NUM=? AND OPER_CODE=?");
			pstmt.setString(1,facility_id ); //facility_id
			pstmt.setString(2,oper_num);
			pstmt.setString(3,oper_code);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result  = resultSet.getString(1);
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				  if(resultSet!=null)resultSet.close();
				  if(pstmt!=null) pstmt.close();
				  if(con!=null)
			ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
				  //if(con!=null)con.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return result;

}


public static HashMap getCommonHdr(String facility_id,String oper_num){
		 PreparedStatement pstmt = null;
		 ResultSet resultSet     = null;
		Connection con = null;
		HashMap map	= new HashMap(17);

		String SQL = "SELECT PATIENT_ID,EPISODE_ID,ENCOUNTER_ID,PATIENT_CLASS,EPISODE_TYPE,TO_CHAR(OPER_DATE,'DD/MM/YYYY'),SURGEON_CODE,NVL(VISIT_ID,1),ORDER_ID FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID=? AND  OPER_NUM=?";
		
		try{
			con			= ConnectionManager.getConnection();
			pstmt			= con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				map.put("patient_id",resultSet.getString(1)) ;
				map.put("episode_id",resultSet.getString(2)) ;
				map.put("encounter_id",resultSet.getString(3)) ;
				map.put("patient_class",resultSet.getString(4)) ;
				map.put("episode_type",resultSet.getString(5)) ;
				map.put("surgery_date",resultSet.getString(6)) ;
				map.put("surgeon_code",resultSet.getString(7)) ;
				map.put("visit_id",resultSet.getString(8)) ;
				map.put("order_id",resultSet.getString(9)) ;
				map.put("order_id",resultSet.getString(9)) ;
				map.put("oper_num",oper_num) ;
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				  if(resultSet!=null)resultSet.close();
				  if(pstmt!=null) pstmt.close();
				  if(con!=null)
			ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
				  //if(con!=null)con.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return map;
   }

   public static String getOrderTypeCode(String speciality_code){
		PreparedStatement pstmt = null;
        ResultSet resultSet     = null;
		Connection con = null;
		String result	 = "";
		try{
			//Modified By DhanasekarV against issue Connection closed exception on 01/02/2011
			//con = ConnectionDispenser.getConnection();//Connection Issue
			con=ConnectionManager.getConnection();//Changed on 03/07/13 against UAT5 - Connectio
			pstmt			= con.prepareStatement("SELECT ORDER_TYPE_CODE FROM OT_SPECIALITY_ORDER_TYPES WHERE SPECIALITY_CODE=?");
			pstmt.setString(1,speciality_code); //facility_id
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result  = resultSet.getString(1);
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				  if(resultSet!=null)resultSet.close();
				  if(pstmt!=null) pstmt.close();
				  if(con!=null)
			ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
			//	  if(con!=null)con.close();
             }catch(Exception es){es.printStackTrace();}
        }
		return result;
}
};
