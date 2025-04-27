/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/

/*
Sr No        Version           Incident			SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V210413			17021        Common-ICN-0009-TF         MuthukumarN
-----------------------------------------------------------------------------------
*/

package eBL.PkgAdhocDiscount;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import java.io.* ;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;


/**
*
* @ejb.bean
*	name="PkgAdhocDiscount"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"f
*	jndi-name="PkgAdhocDiscount"
*	local-jndi-name="PkgAdhocDiscount"
*	impl-class-name="eBL.PkgAdhocDiscount.PkgAdhocDiscountManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eBL.PkgAdhocDiscount.PkgAdhocDiscountLocal"
*	remote-class="eBL.PkgAdhocDiscount.PkgAdhocDiscountRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.PkgAdhocDiscount.PkgAdhocDiscountLocalHome"
*	remote-class="eBL.PkgAdhocDiscount.PkgAdhocDiscountHome"
*	generate= "local,remote"
*
*
*/


public class PkgAdhocDiscountManager implements SessionBean
{
	
	String locale = "";	
	SessionContext ctx;
	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
		this.ctx = context;
	}

	
/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap modify(java.util.Properties p,java.util.HashMap tabdata) 
	{		
		//Removed the usage of below variable which was declared as Global and added as a Local varaiable
		//By Rajesh V for MMS-ICN-008
		StringBuffer sys_err = new StringBuffer("") ;
		Connection con;
		CallableStatement cstmt = null;
		
		boolean insertable = false;

		con = ConnectionManager.getConnection(p);
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;//muthu
		String err_level="",sys_message_id="",err_text="";//muthu

		HashMap return_mess = new HashMap();		
		int result = 0;
		//String locale = "";//V210413
		String client_ip_address=(String)tabdata.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";
		
		String user_id=(String)tabdata.get("login_user");
		if(user_id==null) user_id="";
		//locale = (String) tabdata.get("locale");
		if(locale==null) locale="en";
		String facility_id = (String) tabdata.get("FACILITY_ID");
		facility_id = facility_id==null?"": facility_id;
		String patientId = (String) tabdata.get("patientId");
		patientId = patientId==null?"": patientId;
		String called_from = (String) tabdata.get("called_from");
		called_from = called_from==null?"": called_from;
	//Added V171219-Gayathri/65499/Starts

		String episode_type=(String)tabdata.get("episode_type");
		if(episode_type==null) episode_type="";	
		String episode_id=(String)tabdata.get("episode_id");
		if(episode_id==null) episode_id="";	
		String visit_id=(String)tabdata.get("visit_id");
		if(visit_id==null) visit_id="";	
			//Added V171219-Gayathri/65499/Ends
		String blnggrp=(String)tabdata.get("blnggrp");
		if(blnggrp==null) blnggrp="";

		String billdoctype=(String)tabdata.get("billdoctype");
		if(billdoctype==null) billdoctype="";
		String billdocnum=(String)tabdata.get("billdocnum");
		if(billdocnum==null) billdocnum="";

		String packageSeqNo = "";
		String cust_group_code	=	"";
		String cust_code	=	"";
		String discount_as_per_setup	=	"";
		String type	=	"";
		String adhocDiscount	=	"";								
		String to_update	=	"";								
		String packageCode	=	"";								
		//int episodeId = 0;
		//int accSeqNo = 0;
		//String custCode = "";
		//String encounterId = "";
		String reason_code="";//muthu
		String reason_desc="";//muthu
		int totRec = 0;
		String del_rec_YN="N";
		HashMap adhocDiscountDtls	= (HashMap) tabdata.get("adhocDiscountDtls");
		ArrayList packageSeqNoList	= (ArrayList) tabdata.get("packageSeqNoList");
		if(packageSeqNoList!=null && packageSeqNoList.size()>0)
			totRec = packageSeqNoList.size();
		/*System.out.println("totRec from bean :"+totRec);
		System.out.println("packageSeqNoList from bean :"+packageSeqNoList);
		System.out.println("adhocDiscountDtls from bean :"+adhocDiscountDtls);*/

		ArrayList enconterDtls		= new ArrayList();
		ArrayList dtls				= new ArrayList();
		//String sqlInsert			="insert into bl_package_adhoc_discount values(?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?)";
		String sqlInsert			=	"insert into bl_package_adhoc_discount(OPERATING_FACILITY_ID,PACKAGE_CODE,PACKAGE_SEQ_NO,PATIENT_ID,CUST_GROUP_CODE,CUST_CODE,DISCOUNT,DISCOUNT_TYPE,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DISC_REASON_DESC,DISC_REASON_CODE) values(?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?)";
		String sqlUpdate			=   "update bl_package_adhoc_discount set discount_type=? , discount=?,modified_by_id=? , modified_at_ws_no=? , modified_date=sysdate  , modified_facility_id=?, disc_reason_desc=? ,disc_reason_code=? where operating_facility_id=? and patient_id=? and package_seq_no=? and package_code=? and nvl(cust_group_code,'$')= nvl(?,'$')and nvl(cust_code,'$')=nvl(?,'$')  ";

	//  String sqlUpdate1		=     "update bl_package_adhoc_discount set disc_reason_desc=? ,disc_reason_code=?,discount_type=? , discount=?,modified_by_id=? , modified_at_ws_no=? , modified_date=sysdate  , modified_facility_id=?  where operating_facility_id=? and patient_id=? and package_seq_no=? and package_code=? and nvl(cust_group_code,'$')= nvl(?,'$')and nvl(cust_code,'$')=nvl(?,'$')  ";
	//	String sqlUpdate		="update bl_package_adhoc_discount set discount_type=? , discount=?,modified_by_id=? , modified_at_ws_no=? , modified_date=sysdate  , modified_facility_id=? ,DISC_REASON_CODE = ?  where operating_facility_id=? and patient_id=? and package_seq_no=? and package_code=? and nvl(cust_group_code,'#')= nvl(?,'#')and nvl(cust_code,'#')=nvl(?,'#')  ";

		String sqlDelete        ="delete from bl_package_adhoc_discount where operating_facility_id=? and patient_id=? and package_seq_no=? and package_code=? and nvl(cust_group_code,'#')= nvl(?,'#')and nvl(cust_code,'#')=nvl(?,'#')";//muthu
	//	String sqlHdrUpdate			="";
		boolean insertFlag			= false;
	//	boolean updateHdrFlag			= false;
		boolean updateFlag= false;
		boolean deleteFlag = false;//muthu

		try
		{
			con.setAutoCommit( false ) ;			
			insertable = true;
			if(insertable && totRec>0)
			{
				//sqlUpdate="update bl_encounter_payer_for_pkg set ADHOC_DISCOUNT=?, ADHOC_DISCOUNT_TYPE=?,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_DATE=sysdate where OPERATING_FACILITY_ID = ? and PACKAGE_SEQ_NO=? and PACKAGE_CODE=? and EPISODE_TYPE = ? and nvl(EPISODE_ID,0)=nvl(?,0) and	   nvl(VISIT_ID,0)=nvl(?,0) and	   nvl(APPT_BOOK_REF_NUM,'X')=nvl(?,'X') and ACCT_SEQ_NO = ? and PATIENT_ID=? and ENCOUNTER_ID =? and BLNG_GRP_ID=? and CUST_GROUP_CODE=? and  CUST_CODE=?";
				//sqlHdrUpdate="update bl_package_sub_hdr set ADHOC_DISC_TO_PATIENT=?, ADHOC_DISC_TYPE_TO_PATIENT=?,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_DATE=sysdate where OPERATING_FACILITY_ID = ? and PACKAGE_SEQ_NO=? and PACKAGE_CODE=? and PATIENT_ID=?";
				pstmt	= con.prepareStatement(sqlInsert);
				pstmt1	= con.prepareStatement(sqlUpdate);
				pstmt2	= con.prepareStatement(sqlDelete);//muthu

				for(int k=0;k<totRec;k++)
				{
					packageSeqNo = (String)packageSeqNoList.get(k);
					//System.out.println("packageSeqNo from bean :"+packageSeqNo);

					if(insertable && adhocDiscountDtls!=null && adhocDiscountDtls.containsKey(packageSeqNo))
					{
						enconterDtls = (ArrayList) adhocDiscountDtls.get(packageSeqNo);
						if(enconterDtls!=null && enconterDtls.size()>0)
						{
							for(int i=0;i<enconterDtls.size(); i++)
							{
								dtls	= (ArrayList)enconterDtls.get(i);
							//	adhocDiscount = (String)dtls.get(16); 
							
	
								cust_group_code=(String)dtls.get(0);
								cust_code=(String)dtls.get(2);
								if(dtls.get( 3)==null || (((String)dtls.get( 3)).equals("")) )
									cust_code="";		
								discount_as_per_setup=(String)dtls.get(4);
								type=(String)dtls.get(5);
								adhocDiscount = (String)dtls.get(6); 
								to_update = (String)dtls.get(7); 
								packageCode = (String)dtls.get(8);
								//muthu
								reason_desc = (String)dtls.get(10); 
								reason_code = (String)dtls.get(9); 

								del_rec_YN = (String)dtls.get(11); 

								if(del_rec_YN.equals("Y"))
								{
									to_update = "D";
								}
								//muthu
								if(cust_group_code==null || cust_group_code.equals(""))	cust_group_code=null;
								if(cust_code==null ||  cust_code.equals(""))	cust_code=null;
								//custCode = (String)dtls.get(4);			
								/*System.out.println(" cust_group_code:"+cust_group_code);								
								System.out.println(" cust_group_desc:"+(String)dtls.get(1));								
								System.out.println(" cust_code:"+cust_code);								
								System.out.println(" cust_desc:"+(String)dtls.get(3));								
								System.out.println(" discount_as_per_setup:"+discount_as_per_setup);								
								System.out.println(" type:"+type);								
								System.out.println(" adhocDiscount:"+adhocDiscount);								
								System.out.println(" to_update:"+to_update);								
								System.out.println(" packageCode:"+packageCode);	*/						
								if(adhocDiscount!=null && !(adhocDiscount.equals("")))
								{	
									//try
									//{
									if(to_update.equals("I")){
										//System.out.println("Insert Operation");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,packageCode);
										pstmt.setString(3,packageSeqNo);
										pstmt.setString(4,patientId);
										pstmt.setString(5,cust_group_code);
										pstmt.setString(6,cust_code);
										pstmt.setDouble(7,Double.parseDouble(adhocDiscount));
										pstmt.setString(8,type);										
										pstmt.setString(9,user_id);
										pstmt.setString(10,user_id);
										pstmt.setString(11,client_ip_address);
										pstmt.setString(12,facility_id);
										pstmt.setString(13,client_ip_address);
										pstmt.setString(14,facility_id);
										pstmt.setString(15,reason_desc);
										pstmt.setString(16,reason_code);

										pstmt.addBatch();



										insertFlag = true;
									}
									else if(to_update.equals("U")){								
									
										//System.out.println("Update Operation");
								
									
										pstmt1.setString(1,type);
										pstmt1.setDouble(2,Double.parseDouble(adhocDiscount));
										pstmt1.setString(3,user_id);										
										pstmt1.setString(4,client_ip_address);
										pstmt1.setString(5,facility_id);		
										pstmt1.setString(6,reason_desc);
										pstmt1.setString(7,reason_code);
										pstmt1.setString(8,facility_id);
										pstmt1.setString(9,patientId);										
										pstmt1.setString(10,packageSeqNo);
										pstmt1.setString(11,packageCode);										
										pstmt1.setString(12,cust_group_code);
										pstmt1.setString(13,cust_code);		

										pstmt1.addBatch();

										updateFlag = true;
									}										
								}
								if(to_update.equals("D"))
								{
//									System.err.println("Inside Delete Batch Loop");
									pstmt2.setString(1,facility_id);
									pstmt2.setString(2,patientId);										
									pstmt2.setString(3,packageSeqNo);
									pstmt2.setString(4,packageCode);										
									pstmt2.setString(5,cust_group_code);
									pstmt2.setString(6,cust_code);	
														
									pstmt2.addBatch();
									deleteFlag = true;
								}
							}
													
						}
					}	
				}
				//System.out.println("insertFlag="+insertFlag);
				//System.out.println("updateFlag="+updateFlag);
				if(insertFlag)
				{
					try
					{
						//System.out.println("pstmt :"+pstmt);
						
						int[] updatebatchResult = pstmt.executeBatch();
						
						for (int j=0;j<updatebatchResult.length ;j++ )
						{
							//System.out.println("updatebatchResult[j] :"+updatebatchResult[j]);
							if(updatebatchResult[j] !=-2 && updatebatchResult[j] < 0) 
							{
								result=updatebatchResult[j];
								insertable = false;
								con.rollback();
								break;
							}
							else
							{
								insertable=true;
								result=1;
							}
						}
					}
					catch(BatchUpdateException e)
					{
						System.err.println("PkgAdhocDiscountManager Exception from batch update pstmt:"+e);
						System.err.println("PkgAdhocDiscountManager SQLState:  " + e.getSQLState());
						System.err.println("PkgAdhocDiscountManager Message:  " + e.getMessage());
			            System.err.println("PkgAdhocDiscountManager Vendor:  " + e.getErrorCode());	
						e.printStackTrace();
						insertable = false;
						con.rollback();	
						
            		}
				catch(Exception  e)
					{
						System.err.println("PkgAdhocDiscountManager Message:2  " + e.getMessage());
						insertable = false;
						con.rollback();
						e.printStackTrace();					
            		}
					finally
					{
						if (pstmt!=null)   pstmt.close();
					}
				}

				if(updateFlag && insertable)
				{
					try
					{						
						int[] updatebatchResult = pstmt1.executeBatch();
						
						for (int j=0;j<updatebatchResult.length ;j++ )
						{
							//System.out.println("updatebatchResult[j] :"+updatebatchResult[j]);
							if(updatebatchResult[j] !=-2 && updatebatchResult[j] < 0) 
							{
								result=updatebatchResult[j];
								insertable = false;
								con.rollback();
								break;
							}
							else
							{
								insertable=true;
								result=1;
							}
						}
					}
					catch(BatchUpdateException e)
					{
						/*System.out.println("Exception from batch update pstmt1 :"+e);
						System.out.println("SQLState:  " + e.getSQLState());
						System.out.println("Message:  " + e.getMessage());
						System.out.println("Vendor:  " + e.getErrorCode());*/
						insertable = false;						
						con.rollback();
						e.printStackTrace();						
					}
					finally
					{
						if (pstmt1!=null)   pstmt1.close();
					}
				}
				if(deleteFlag && insertable)
				{
					try
					{
						int[] updatebatchResult = pstmt2.executeBatch();
						//System.out.println("updatebatchResult :"+updatebatchResult);
						for (int j=0;j<updatebatchResult.length ;j++ )
						{
//							System.err.println("updatebatchResult[j]-delete:"+updatebatchResult[j]);
							if(updatebatchResult[j] !=-2 && updatebatchResult[j] < 0) 
							{
								result=updatebatchResult[j];
								insertable = false;
								con.rollback();
								break;
							}
							else
							{
								insertable=true;
								result=1;
							}
						}
					}
					catch(BatchUpdateException e)
					{
						/*System.out.println("Exception from batch update pstmt1 :"+e);
						System.out.println("SQLState:  " + e.getSQLState());
						System.out.println("Message:  " + e.getMessage());
						System.out.println("Vendor:  " + e.getErrorCode());*/
						insertable = false;						
						con.rollback();
						e.printStackTrace();
						
					}
					finally
					{
						if (pstmt2!=null)   pstmt2.close();
					}
				}

				// V230725
				if(insertable){
					System.out.println("patientId =>"+patientId);
					System.out.println("totRec =>"+totRec);
					for(int u=0;u<totRec;u++)
					{
						packageSeqNo = (String)packageSeqNoList.get(u);
						String pkgAdhocUpd   ="{ call BL_PACKAGE_ADHOC_DISCOUNT_UPD(?,?)}";
							cstmt = con.prepareCall(pkgAdhocUpd);	
							System.out.println("packageSeqNo"+packageSeqNo);
							System.out.println("facility_id"+facility_id);
							cstmt.setString(1,facility_id);
							cstmt.setString(2,packageSeqNo);
							cstmt.execute();	
					}
					System.out.println("BL_PACKAGE_ADHOC_DISCOUNT_UPD done");
					insertable=true;
				}
				
				if(insertable)
				{
					for(int k=0;k<totRec;k++)
					{
						packageSeqNo = (String)packageSeqNoList.get(k);
						// Added Recalculation proc as per instructions from karupps on 11/20/2010
					//	System.err.println("Calling RECALCULATEPACKAGE Procedure:"+facility_id+"/"+patientId+"/"+packageSeqNo+"/"+user_id+"/"+client_ip_address);
						//Added new parameters V171219-Gayathri/65499
						String qryrecalcpkg   ="{ call   BLPACKAGE.RECALCULATEPACKAGE(?,?,?,?,?,?,?,?,?,?,?,?)}";
						cstmt = con.prepareCall(qryrecalcpkg);	
						cstmt.setString(1,facility_id);
						cstmt.setString(2,patientId);
						cstmt.setString(3,"BL_TRAN_PACKAGE_ADHOC_DISC");
						cstmt.setString(4,packageSeqNo);
						cstmt.setString(5,user_id);
						cstmt.setString(6,client_ip_address);
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						//Added new parameters V171219-Gayathri/65499/Starts	
						cstmt.setString(10,episode_type);
						cstmt.setString(11,episode_id);
						if(("").equals(visit_id)) visit_id=null;
						cstmt.setString(12,visit_id);
						//Added new parameters V171219-Gayathri/65499/Ends
						cstmt.execute();	

						err_text=cstmt.getString(7)==null?"":cstmt.getString(7);
						err_level=cstmt.getString(8)==null?"":cstmt.getString(8);
						sys_message_id=cstmt.getString(9)==null?"":cstmt.getString(9);

						//System.err.println("Called RECALCULATEPACKAGE Procedure:"+err_level+"/"+sys_message_id+"/"+err_text);
						//Added By Gayathri for 65499
						Locale loc = new Locale(locale);
						ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);

						if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
						{
							if(!("").equals(sys_message_id)){ 
								try{
									sys_message_id = rb.getString(sys_message_id);
								}
								catch(Exception rbException){
									sys_message_id = getMessageString(sys_message_id,con);
									rbException.printStackTrace();
								}
								sys_err.append(sys_message_id);	
							}
							if((sys_message_id.equals(""))  && !err_text.equals("")){
							sys_err.append(err_text);
							}
							insertable = false;
							cstmt.close();
							con.rollback();
							break;
						}
						else
						{
							insertable=true;
							result=1;
						}
						sys_message_id="";
						err_level="";
						err_text="";
						if (cstmt!=null)   cstmt.close();	
					}
				}
			}

			
			if(insertable && called_from.equals("VISITREG"))
			{		
				String mpi_id="";

				try{
				 for(int k=0;k<totRec;k++)
				 {					
					packageSeqNo = (String)packageSeqNoList.get(k);
					if(insertable && adhocDiscountDtls!=null && adhocDiscountDtls.containsKey(packageSeqNo))
					{
						enconterDtls = (ArrayList) adhocDiscountDtls.get(packageSeqNo);
						if(enconterDtls!=null && enconterDtls.size()>0)
						{
							for(int i=0;i<enconterDtls.size(); i++)
							{
								dtls	= (ArrayList)enconterDtls.get(i);	
								packageCode = (String)dtls.get(8);
								//System.out.println("packageCode EJB ADHOC DISC1" +packageCode);
								String qrycalcbill   ="{ call   blpackage.calc_package_bill_discount(?,?,?,?,?,?,?,?,?,?)}";
								cstmt = con.prepareCall(qrycalcbill);	
								cstmt.setString(1,facility_id);
								cstmt.setString(2,packageCode);
								cstmt.setString(3,packageSeqNo);
								cstmt.setString(4,patientId);
								cstmt.setString(5,"O");
								cstmt.setString(6,episode_id);
								cstmt.setString(7,visit_id);
								cstmt.setString(8,blnggrp);
								cstmt.setString(9,user_id);
								cstmt.setString(10,client_ip_address);
								cstmt.execute();	
								if (cstmt!=null)   cstmt.close();
							}
						}
					}
				 }
					//System.out.println("called_from ejb end of calc_package_bill_discount:");
					String qrympiid="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID='"+facility_id+"' and DOC_TYPE_CODE='"+billdoctype+"' and DOC_NUM='"+billdocnum+"'";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(qrympiid) ;
					if( rs != null ) 
					{
						while( rs.next() )
						{  
							mpi_id  =  rs.getString(1);	
						}
					}
					st.close();
					if(rs!=null) rs.close();
					//System.out.println("called_from ejb end of mpi_id:" +mpi_id);
					CallableStatement cstmt1 = null;
					for(int k=0;k<totRec;k++)
					{					
						packageSeqNo = (String)packageSeqNoList.get(k);
						//System.out.println("packageSeqNo EJB ADHOC DISC1" +packageSeqNo);
						String qryupdbill   ="{ call   blpackage.proc_updt_bill_for_disc(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
						cstmt1 = con.prepareCall(qryupdbill);	
						cstmt1.setString(1,mpi_id);
						cstmt1.setString(2,billdoctype); //from bill doctype
						cstmt1.setString(3,null);		//to bill doctype	
						cstmt1.setString(4,billdocnum); //from bill billnum
						cstmt1.setString(5,null);		//to bill billnum
						cstmt1.setString(6,packageSeqNo);
						cstmt1.setString(7,facility_id);
						cstmt1.setString(8,patientId);
						cstmt1.setString(9,episode_id);
						cstmt1.setString(10,"O");
						cstmt1.setString(11,visit_id);		
						cstmt1.setString(12,user_id);
						cstmt1.setString(13,client_ip_address);
						cstmt1.execute();	
						if (cstmt1!=null)   cstmt1.close();
					//System.out.println("called_from ejb end of proc_updt_bill_for_disc:");
					}					
				}catch(Exception e1)
					{
						System.out.println("Exception proc_updt_bill_for_disc :"+e1);
						//Added by Rajesh MMS-ICN-008
						sys_err.append("Main Exception:"+e1);
						insertable = false;
						con.rollback();
						e1.printStackTrace();
					}
					finally
					{
						if (cstmt!=null)   cstmt.close();		
					}

			}
			
			if(insertable)	con.commit();
		}
		catch (Exception e)
		{
			insertable=false;

			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			sys_err.append("Main Exception:"+e);
			System.out.println("Main Exception modify:"+e);
			e.printStackTrace();
		}
		finally
		{  
			//V210413 Starts
			adhocDiscountDtls=null;
			packageSeqNoList=null;
			packageSeqNoList=null;
			dtls=null;
			//V210413 Ends
			if (con != null) ConnectionManager.returnConnection(con, p);
		}
		return_mess.put("status",new Boolean(insertable));
		//Modified below. Instead of passing result passing sys_err Rajesh v ICN-008
		return_mess.put("error",sys_err.toString());
		return return_mess;	
	}//modify()
		//Added By Gayathri for 65499
	public String getMessageString(String messageId, Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String output = "";
		String messageQuery = "select message_text_sysdef from sm_message where message_id = ?";
		try{
			pstmt = con.prepareStatement(messageQuery);
			pstmt.setString(1, messageId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				output = messageId+"-"+rst.getString("message_text_sysdef");
			}						
		}
		catch(Exception e){
			System.err.println("Exception in getting Message String ->"+e);
			e.printStackTrace();
			output = messageId;
			e.printStackTrace();
		}
		finally{
			//V210413 Starts
			try
			{
				if(pstmt != null)
				{
					pstmt.close();
				}         
				if(rst != null)
				{
					rst.close();
				}      
			}
			catch(Exception e)
			{
				System.err.println("Errorin getMessageString::"+e);
				e.printStackTrace();
			}
			//pstmt = null;
			//rst = null;
			//V210413 Ends
		}
		return output;
	}	
}