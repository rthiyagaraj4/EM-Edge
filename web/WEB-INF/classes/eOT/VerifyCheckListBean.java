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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
import java.io.Serializable;
import java.util.Properties;
//MMS-ME-SCF0051 start
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
//MMS-ME-SCF0051 end


public class VerifyCheckListBean extends OTAdapter implements Serializable {
	HashMap		all_checklist_details		= null;
	ArrayList	arr_list_item_details		= null;
	ArrayList	arr_list_user_info			= null;
	HashMap		all_existing_chklist_dtls	= null;
	Properties	p = this.properties;
	String	locale	= "";

	public VerifyCheckListBean() {
        try {
			doCommon();
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {
	}
	public void clear(){
		all_checklist_details	= null;
		arr_list_item_details	= null;
		all_existing_chklist_dtls = null;
		arr_list_user_info			= null;
	}

	public String getSysDateTime(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String curr_date		= "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				curr_date = resultSet.getString("CURRENT_DATE");
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
		return curr_date;
	}
	public void loadCheckListDetails(ArrayList checklist_codes){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		HashMap checklist_details = null;
		StringBuffer append_str	= new StringBuffer();
		int index = 1;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			all_checklist_details = new HashMap();
			append_str = append_str.append("WHERE B.LANGUAGE_ID = ? AND A.CHECKLIST_CODE IN ('");
			append_str.append((String)checklist_codes.get(0)+"'");
			for(int i=1;i<checklist_codes.size();i++){ 
				append_str.append(",'");
				append_str.append((String)checklist_codes.get(i)+"'");
			}
			append_str = append_str.append(") AND A.CHECKLIST_ITEM_CODE = B.CHECKLIST_ITEM_CODE AND NVL(STATUS,'E')='E' ");
			connection			= getConnection() ;

			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT1")+append_str+" ORDER BY A.CHECKLIST_CODE, A.CHECKLIST_ITEM_SRL_NO") ;
//			System.out.println("pstmt::::::"+pstmt);//lakshmi
			pstmt.setString(1,locale);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				//checklist_details = null;
				checklist_details = new HashMap();				
				checklist_details.put("item_level",resultSet.getString("ITEM_LEVEL"));
				checklist_details.put("checklist_code",resultSet.getString("CHECKLIST_CODE"));				
				checklist_details.put("checklist_item_code",resultSet.getString("CHECKLIST_ITEM_CODE"));
				checklist_details.put("checklist_item_srl_no",resultSet.getString("CHECKLIST_ITEM_SRL_NO"));
				checklist_details.put("description",resultSet.getString("DESCRIPTION"));
				checklist_details.put("checklist_type",resultSet.getString("CHECKLIST_TYPE"));
				checklist_details.put("list_id",resultSet.getString("LIST_ID"));
				checklist_details.put("accept_remarks_yn",resultSet.getString("ACCEPT_REMARKS_YN"));
				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				//Start
				checklist_details.put("appl_for_intra_oper",resultSet.getString("APPL_FOR_INTRA_OPER"));
				//End
				all_checklist_details.put(index+"",checklist_details);
				++index ;
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				checklist_details = null;
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
	}

	public HashMap getVerifyCheckListDetails(){
		if(all_checklist_details==null)
			return new HashMap();
		return this.all_checklist_details;
	}

//
	public void loadExistingChkListDtls(String booking_num,String oper_num, String order_id,String pre_or_post){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		HashMap checklist_details = null;
		//StringBuffer append_str	= new StringBuffer();
		try{
			if(booking_num==null)			booking_num="";
			if(booking_num.equals("null"))	booking_num="";

			if(oper_num==null)			oper_num="";
			if(oper_num.equals("null")) oper_num="";

			if(order_id==null)			order_id="";
			if(order_id.equals("null")) order_id="";

		/*	if(!booking_num.equals("")){
				order_id = "";
				oper_num = "";
			}else if(!order_id.equals("")){
				booking_num = "";
				oper_num = "";
SELECT CHECKLIST_ITEM_SRL_NO, CHECKLIST_ITEM_CODE, CHECKLIST_STAGE, CHECKLIST_CODE, DECODE(CHECKLIST_VALUE,NULL,'Select',CHECKLIST_VALUE) CHECKLIST_VALUE, CHECKLIST_REMARKS, ADDED_BY_ID FROM OT_OPER_CHECKLIST_DTLS WHERE OPERATING_FACILITY_ID=? AND ORDER_ID = ? AND CHECKLIST_STAGE IN (?,?,?,?) ORDER BY CHECKLIST_CODE, CHECKLIST_ITEM_SRL_NO			}*/
			//Condition included nby rajesh instructed by Dilip on 26/03/2010
			String SQL="";
			if(!order_id.equals("")){
				SQL="SELECT CHECKLIST_ITEM_SRL_NO, CHECKLIST_ITEM_CODE, CHECKLIST_STAGE, CHECKLIST_CODE, DECODE(CHECKLIST_VALUE,NULL,'Select',CHECKLIST_VALUE) CHECKLIST_VALUE, CHECKLIST_REMARKS, ADDED_BY_ID FROM OT_OPER_CHECKLIST_DTLS WHERE OPERATING_FACILITY_ID=? AND ORDER_ID = ? AND CHECKLIST_STAGE IN (?,?,?,?) ORDER BY CHECKLIST_CODE, CHECKLIST_ITEM_SRL_NO";
/* Modified By Muthukumar against SKR-SCF-0160 on 11-10-2011 */
				if (!oper_num.equals("") && pre_or_post.equals("O")) // modified by Rajesh against SKR-SCF-0160 on 16-8-2012
				{
				SQL="SELECT CHECKLIST_ITEM_SRL_NO, CHECKLIST_ITEM_CODE, CHECKLIST_STAGE, CHECKLIST_CODE, DECODE(CHECKLIST_VALUE,NULL,'Select',CHECKLIST_VALUE) CHECKLIST_VALUE, CHECKLIST_REMARKS, ADDED_BY_ID FROM OT_OPER_CHECKLIST_DTLS WHERE OPERATING_FACILITY_ID=? AND OPER_NUM ='"+oper_num+"' AND ORDER_ID = ? AND CHECKLIST_STAGE IN (?,?,?,?) ORDER BY CHECKLIST_CODE, CHECKLIST_ITEM_SRL_NO";
				}
/* Modified By Muthukumar against SKR-SCF-0160 on 11-10-2011 */

			}else if(order_id.equals("") && !booking_num.equals("")){
				SQL="SELECT CHECKLIST_ITEM_SRL_NO, CHECKLIST_ITEM_CODE, CHECKLIST_STAGE, CHECKLIST_CODE, DECODE(CHECKLIST_VALUE,NULL,'Select',CHECKLIST_VALUE) CHECKLIST_VALUE, CHECKLIST_REMARKS, ADDED_BY_ID FROM OT_OPER_CHECKLIST_DTLS WHERE OPERATING_FACILITY_ID=? AND BOOKING_NUM = ? AND CHECKLIST_STAGE IN (?,?,?,?) ORDER BY CHECKLIST_CODE, CHECKLIST_ITEM_SRL_NO";
			}else if(order_id.equals("") && booking_num.equals("") && !oper_num.equals("")){
				SQL="SELECT CHECKLIST_ITEM_SRL_NO, CHECKLIST_ITEM_CODE, CHECKLIST_STAGE, CHECKLIST_CODE, DECODE(CHECKLIST_VALUE,NULL,'Select',CHECKLIST_VALUE) CHECKLIST_VALUE, CHECKLIST_REMARKS, ADDED_BY_ID FROM OT_OPER_CHECKLIST_DTLS WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = ? AND CHECKLIST_STAGE IN (?,?,?,?) ORDER BY CHECKLIST_CODE, CHECKLIST_ITEM_SRL_NO";
			}

			all_existing_chklist_dtls = new HashMap();
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(SQL) ;
			if(!order_id.equals("")){
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,order_id);

			}else if(order_id.equals("") && !booking_num.equals("")){
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,booking_num);
			}else if(order_id.equals("") && booking_num.equals("") && !oper_num.equals("")){
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,oper_num);
			}
			if(pre_or_post.equals("O")){
				pstmt.setString(3,"C50");
				pstmt.setString(4,"C60");
				pstmt.setString(5,"C70");
				pstmt.setString(6,"C80");
			}else{
				pstmt.setString(3,"C10");
				pstmt.setString(4,"C20");
				pstmt.setString(5,"C30");
				pstmt.setString(6,"C40");
			}
			resultSet = pstmt.executeQuery();
			String checklist_item_srl_no = "";
			String checklist_item_code	= "";
			String checklist_stage = "";
			int current_level = 0;
			while(resultSet!=null && resultSet.next()){
				checklist_details = new HashMap();				
				checklist_item_srl_no = resultSet.getString("CHECKLIST_ITEM_SRL_NO");
				checklist_details.put("checklist_item_srl_no",checklist_item_srl_no);
				checklist_item_code = resultSet.getString("CHECKLIST_ITEM_CODE");
				checklist_details.put("checklist_item_code",checklist_item_code);
				checklist_stage = resultSet.getString("CHECKLIST_STAGE");
				checklist_details.put("checklist_stage",checklist_stage);
				checklist_details.put("checklist_code",resultSet.getString("CHECKLIST_CODE"));		
				checklist_details.put("checklist_value",resultSet.getString("CHECKLIST_VALUE"));
				checklist_details.put("checklist_remarks",resultSet.getString("CHECKLIST_REMARKS"));
				checklist_details.put("added_by_id",resultSet.getString("ADDED_BY_ID"));
				if(checklist_stage.equals("C10") || checklist_stage.equals("C50"))
					current_level = 1;
				else if(checklist_stage.equals("C20") || checklist_stage.equals("C60"))
					current_level = 2;
				else if(checklist_stage.equals("C30") || checklist_stage.equals("C70"))
					current_level = 3;
				else if(checklist_stage.equals("C40") || checklist_stage.equals("C80"))
					current_level = 4;

				all_existing_chklist_dtls.put(checklist_item_code+"#"+current_level,checklist_details);
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				checklist_details = null;
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
	}

	public HashMap getExistingChkListDtls(){
		if(all_existing_chklist_dtls==null)
			return new HashMap();
		return this.all_existing_chklist_dtls;
	}
	
	public void loadListItemValues(String list_id){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList arr_list		= new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT2")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,list_id);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				arr_list.add(resultSet.getString("ITEM_VALUE"));
				arr_list.add(resultSet.getString("DEFAULT_VALUE_YN"));
				arr_list.add(resultSet.getString("ITEM_DESC"));
			}
			if(arr_list_item_details==null)
				arr_list_item_details = new ArrayList();
			arr_list_item_details=arr_list;
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
	}
	public ArrayList getListItemValues(){
		if(arr_list_item_details==null)
			return new ArrayList();
		return this.arr_list_item_details;
	}
	public HashMap getRoleDesc(ArrayList roles_arr){
		HashMap role_desc_map	= new HashMap();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		StringBuffer append_str	= new StringBuffer();
		String role_id = "";
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			append_str.append(" WHERE LANGUAGE_ID = ? AND ROLE_ID IN ('"+(String)roles_arr.get(0)+"'");
			for(int i=1;i<roles_arr.size();i++)
				append_str.append(",'"+(String)roles_arr.get(i)+"'");
			//commented by bala on 05/11/2007 as instructed by vishwa	
			//append_str.append(") AND NVL(STATUS,'E')='E' ORDER BY ROLE_ID");	
			append_str.append(") ORDER BY ROLE_ID");	
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT4")+append_str);

			pstmt.setString(1,locale);
			resultSet = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				role_id = resultSet.getString("ROLE_ID");
				for(int i=0;i<roles_arr.size();i++){
					if(((String)roles_arr.get(i)).equals(role_id)){
						role_desc_map.put(role_id,resultSet.getString("ROLE_DESC"));
					}
				}
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				append_str.setLength(0);
				closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return role_desc_map;
	}
	public String validateUserPIN(String user_id, String pin_no){
		String result			= "N";
		String db_pin_no		= "";
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
      //----------------------------------- MMS-ME-SCF-0051 start
      		String decrypted_pin="";
      			System.err.println(" Encrypt Pinnumber checker 732============="+pin_no);
      			try {
      			String initVector="5D9r9ZVzEYYgha93/aUK2w==";
      			byte[] IvkeyBytes = initVector.getBytes("UTF-8");
      			IvParameterSpec ivSpec = new IvParameterSpec(Base64.decodeBase64(IvkeyBytes));
      			String initVector1="u/Gu5posvwDsXUnV5Zaq4g==";
      			byte[] IvkeyBytes1 = initVector1.getBytes("UTF-8");
                  SecretKeySpec newKey = new SecretKeySpec(Base64.decodeBase64(IvkeyBytes1), "AES");
                  Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                  cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);		
                  decrypted_pin = new String(cipher.doFinal(Base64.decodeBase64(pin_no.getBytes("UTF-8"))), "UTF-8");
      												System.err.println("============"+decrypted_pin);
              } catch (Exception e ) {
      			System.err.println("Exception occured while Decryption the Password============"+e);
                  e.printStackTrace();
              }
      		finally {
      			System.err.println("85,decrypted_pin============"+decrypted_pin);
      		}	
      //----------------------------------- MMS-ME-SCF-0051 end        
        
        
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT5")) ;
			pstmt.setString(1,user_id);
			//pstmt.setString(2,pin_no);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				db_pin_no = resultSet.getString("PIN_NO");
			}
			db_pin_no=db_pin_no==null?"":db_pin_no;
			db_pin_no=db_pin_no.equalsIgnoreCase("null")?"":db_pin_no;
			if(db_pin_no.equalsIgnoreCase(decrypted_pin))  // MMS-ME-SCF-0051
				result="Y";
			else
				result="N";
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}
	public void loadUserInfo(String invoked_from, String appt_yn, String booking_num, String oper_num, String order_id){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		arr_list_user_info=new ArrayList();
		try{
			if(booking_num==null)			booking_num="";
			if(booking_num.equals("null"))	booking_num="";

			if(oper_num==null)			oper_num="";
			if(oper_num.equals("null")) oper_num="";

			if(order_id==null)			order_id="";
			if(order_id.equals("null")) order_id="";

			if(invoked_from==null)		invoked_from="";
			if(invoked_from.equals("null")) invoked_from="";

			if(appt_yn==null)			appt_yn="";
			if(appt_yn.equals("null")) appt_yn="";

			if(invoked_from.equals("CHKOUTFROMWARD")){
				if(appt_yn.equals("Y")) order_id="";
				if(appt_yn.equals("N")) booking_num="";
			}else{
				if(!booking_num.equals("")){
					order_id = "";
					oper_num = "";
				}else if(!order_id.equals("")){
					booking_num = "";
					oper_num = "";
				}
			}
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT6")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
			pstmt.setString(4,order_id);			
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				arr_list_user_info.add(resultSet.getString("PRE_OP_CHKLST_USR1_ID"));
				arr_list_user_info.add(resultSet.getString("PRE_OP_CHKLST_USR1_COMPL_YN"));
				arr_list_user_info.add(resultSet.getString("PRE_OP_CHKLST_USR2_ID"));
				arr_list_user_info.add(resultSet.getString("PRE_OP_CHKLST_USR2_COMPL_YN"));
				arr_list_user_info.add(resultSet.getString("PRE_OP_CHKLST_USR3_ID"));
				arr_list_user_info.add(resultSet.getString("PRE_OP_CHKLST_USR3_COMPL_YN"));
				arr_list_user_info.add(resultSet.getString("PRE_OP_CHKLST_USR4_ID"));
				arr_list_user_info.add(resultSet.getString("PRE_OP_CHKLST_USR4_COMPL_YN"));

				arr_list_user_info.add(resultSet.getString("POST_OP_CHKLST_USR1_ID"));
				arr_list_user_info.add(resultSet.getString("POST_OP_CHKLST_USR1_COMPL_YN"));
				arr_list_user_info.add(resultSet.getString("POST_OP_CHKLST_USR2_ID"));
				arr_list_user_info.add(resultSet.getString("POST_OP_CHKLST_USR2_COMPL_YN"));
				arr_list_user_info.add(resultSet.getString("POST_OP_CHKLST_USR3_ID"));
				arr_list_user_info.add(resultSet.getString("POST_OP_CHKLST_USR3_COMPL_YN"));
				arr_list_user_info.add(resultSet.getString("POST_OP_CHKLST_USR4_ID"));
				arr_list_user_info.add(resultSet.getString("POST_OP_CHKLST_USR4_COMPL_YN"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
	}
	
	public ArrayList getUserInfo(){
		if(arr_list_user_info==null)
			return new ArrayList();
		return this.arr_list_user_info;
	}
}
