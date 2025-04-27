/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005
package ePH.TPNStandardRegimen ;

import java.rmi.* ;
//import java.util.HashMap ;
//import java.util.ArrayList;
//import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
//import ePH.Common.PhEJBSessionAdapter ;
import oracle.sql.*;
import java.io.*;
//import java.io.Serializable ;
import java.util.* ;
import eOR.* ;
import ePH.Common.* ;

/**
*
* @ejb.bean
*	name="TPNStandardRegimen"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TPNStandardRegimen"
*	local-jndi-name="TPNStandardRegimen"
*	impl-class-name="ePH.TPNStandardRegimen.TPNStandardRegimenManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TPNStandardRegimen.TPNStandardRegimenLocal"
*	remote-class="ePH.TPNStandardRegimen.TPNStandardRegimenRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TPNStandardRegimen.TPNStandardRegimenLocalHome"
*	remote-class="ePH.TPNStandardRegimen.TPNStandardRegimenHome"
*	generate= "local,remote"
*
*
*/
public class TPNStandardRegimenManager extends PhEJBSessionAdapter {
	
//	Properties prop=null;

	
	// insert method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
	
		//System.err.println("Inside local insert ");


		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside local Insert" ) ;

		String debug="0";

		Connection connection					= null ;
		PreparedStatement pstmt_insert1	= null ;
		PreparedStatement pstmt_insert2	= null ;
		PreparedStatement pstmt_insert3	= null ;
		PreparedStatement pstmt_insert4	= null ;
		PreparedStatement pstmt_insert5	= null ;
		PreparedStatement pstmt_insert6	= null ;
		PreparedStatement pstmt_clob=null;
		ResultSet	rset_clob=null;
		//Retrieve tabData and sql data

		String order_id					=(String)tabData.get("order_id");
		String orderstatus				=(String)tabData.get("orderstatus");
		String patient_id					=(String)tabData.get("patient_id");
		String encounter_id			=(String)tabData.get("encounter_id");
		String location_type			=(String)tabData.get("location_type");
		String location_code			=(String)tabData.get("location_code");
		String pract_id					=(String)tabData.get("pract_id");
		String patient_class			=(String)tabData.get("patient_class");
		String order_date				=(String)tabData.get("order_date");
//		String weight						=(String)tabData.get("weight");
//		String height						=(String)tabData.get("height");
		String priority						=(String)tabData.get("priority");
		String Regimen_Code			=(String)tabData.get("Regimen_Code");
		String tradecode					=(String)tabData.get("tradecode");
		String stdregimen				=(String)tabData.get("stdregimen");
		String ordertype					=(String)tabData.get("ordertype");
		String startdate					=(String)tabData.get("startdate");
		String enddate					=(String)tabData.get("enddate");
		String duration					=(String)tabData.get("duration");
		String frequency					=(String)tabData.get("frequency");
		String quantity					=(String)tabData.get("quantity");
		String infuseover				=(String)tabData.get("infuseover");
		String infuseoverdrn			=(String)tabData.get("infuseoverdrn");
//		String volume					=(String)tabData.get("volume");
		String unitofvolume			=(String)tabData.get("unitofvolume");
		String authreqdYN				=(String)tabData.get("authreqdYN");
		String cosignreqdYN			=(String)tabData.get("cosignreqdYN");
		String splappreqdYN			=(String)tabData.get("splappreqdYN");
		String consentreqdYN			=(String)tabData.get("consentreqdYN");
		String authorizedYN			=(String)tabData.get("authorizedYN");
		String cosignedYN				=(String)tabData.get("cosignedYN");
		String splappedYN				=(String)tabData.get("splappedYN");
		String dispcode					=(String)tabData.get("dispcode");
		String user							=(String)tabData.get("user");
		String facility						=(String)tabData.get("facility");
		String wsno						=(String)tabData.get("wsno");
		HashMap	regimenRemarks=(HashMap)tabData.get("regimenRemarks");
		HashMap	scheduleFrequency=(HashMap)tabData.get("scheduleFrequency");
//		ResultSet resultSet = null ;
		int tmpcount			=0;

		try {

			connection	= getConnection( (Properties)tabData.get( "PROPERTIES" )) ;
			pstmt_insert1=connection.prepareStatement((String) sqlMap.get( "SQLORDER"));

			pstmt_insert1.setString(1,order_id);
			pstmt_insert1.setString(2,ordertype);
			pstmt_insert1.setString(3,patient_id);
			pstmt_insert1.setString(4,patient_class.trim());
			pstmt_insert1.setString(5,facility);
			pstmt_insert1.setString(6,encounter_id);
			pstmt_insert1.setString(7,encounter_id);
			pstmt_insert1.setString(8,location_type);
			pstmt_insert1.setString(9,location_code);
			pstmt_insert1.setString(10,order_date);
			pstmt_insert1.setString(11,pract_id);
			pstmt_insert1.setString(12,priority.trim());
			pstmt_insert1.setString(13,authreqdYN);
			if (authorizedYN.equals("Y"))
			{
				pstmt_insert1.setString(14,pract_id);
				pstmt_insert1.setString(15,order_date);
			}
			else
			{
				pstmt_insert1.setString(14,"");
				pstmt_insert1.setString(15,"");
			}
			pstmt_insert1.setString(16,splappreqdYN);
			if (splappedYN.equals("Y"))
			{
				pstmt_insert1.setString(17,pract_id);
				pstmt_insert1.setString(18,order_date);

			}
			else
			{
				pstmt_insert1.setString(17,"");
				pstmt_insert1.setString(18,"");
			}
			pstmt_insert1.setString(19,cosignreqdYN);
			if (cosignedYN.equals("Y"))
			{
				pstmt_insert1.setString(20,pract_id);
				pstmt_insert1.setString(21,order_date);
			}
			else
			{
				pstmt_insert1.setString(20,"");
				pstmt_insert1.setString(21,"");
			}
			pstmt_insert1.setString(22,facility);
			pstmt_insert1.setString(23,"P");
			pstmt_insert1.setString(24,dispcode);/*dispcode to be inserted*/
			pstmt_insert1.setString(25,pract_id);
			pstmt_insert1.setString(26,"S");/* IV_PREP_YN*/
			pstmt_insert1.setString(27,orderstatus);
			pstmt_insert1.setString(28,user);
			pstmt_insert1.setString(29,wsno);
			pstmt_insert1.setString(30,facility);
			pstmt_insert1.setString(31,user);
			pstmt_insert1.setString(32,wsno);
			pstmt_insert1.setString(33,facility);
			pstmt_insert1.setString(34,consentreqdYN);
			pstmt_insert1.setString(35,"");
			pstmt_insert1.setString(36,"");

			tmpcount = pstmt_insert1.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into OR_ORDER") ;
				connection.rollback();
				return map;
			}

			/* OR_ORDER  OVER*/
			//System.err.println("or order over");
			pstmt_insert2=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINE"));

			pstmt_insert2.setString(1,order_id);
			pstmt_insert2.setString(2,"1");
			pstmt_insert2.setString(3,Regimen_Code);
			pstmt_insert2.setString(4,stdregimen);
			pstmt_insert2.setString(5,stdregimen);
			pstmt_insert2.setString(6,ordertype);
			pstmt_insert2.setString(7,order_date);
			pstmt_insert2.setString(8,priority);
			pstmt_insert2.setString(9,authreqdYN);
			pstmt_insert2.setString(10,splappreqdYN);
			pstmt_insert2.setString(11,cosignreqdYN);
			pstmt_insert2.setString(12,startdate);
			pstmt_insert2.setString(13,"");
			pstmt_insert2.setString(14,quantity);
			pstmt_insert2.setString(15,unitofvolume);
			pstmt_insert2.setString(16,frequency);
			pstmt_insert2.setString(17,duration);
			pstmt_insert2.setString(18,"D");
			if (!regimenRemarks.isEmpty())
			{
				pstmt_insert2.setString(19,(String)regimenRemarks.get("order_format_values"))/*LINE_FIELDS_DISPLAY_TEXT*/;
			}
			else
			{
				pstmt_insert2.setString(19,"")/*LINE_FIELDS_DISPLAY_TEXT*/;
			}
			pstmt_insert2.setString(20,enddate);
			pstmt_insert2.setString(21,quantity);
			pstmt_insert2.setString(22,unitofvolume);
			pstmt_insert2.setString(23,pract_id);
			pstmt_insert2.setString(24,orderstatus);
			pstmt_insert2.setString(25,user);
			pstmt_insert2.setString(26,wsno);
			pstmt_insert2.setString(27,facility);
			pstmt_insert2.setString(28,user);
			pstmt_insert2.setString(29,wsno);
			pstmt_insert2.setString(30,facility);
			pstmt_insert2.setString(31,consentreqdYN);
			pstmt_insert2.setString(32,stdregimen);
			pstmt_insert2.setString(33,stdregimen);

			tmpcount = pstmt_insert2.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into OR_ORDER_LINE") ;
				connection.rollback();
				return map;

			}
		//System.err.println("or order line over");
			/* OR_ORDER_LINE  OVER*/

			pstmt_insert3=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEPH"));

			pstmt_insert3.setString(1,order_id);
			pstmt_insert3.setString(2,"1");
			pstmt_insert3.setString(3,tradecode);
			pstmt_insert3.setString(4,"");
			pstmt_insert3.setString(5,"");
			pstmt_insert3.setString(6,"");
			pstmt_insert3.setString(7,infuseover);
			pstmt_insert3.setString(8,infuseoverdrn);
			pstmt_insert3.setString(9,"");
			pstmt_insert3.setString(10,"");
			pstmt_insert3.setString(11,"");
			pstmt_insert3.setString(12,"P");
			pstmt_insert3.setString(13,"");/*dispcode to be inserted*/
			pstmt_insert3.setString(14,quantity);
			pstmt_insert3.setString(15,"");
			pstmt_insert3.setString(16,user);
			pstmt_insert3.setString(17,wsno);
			pstmt_insert3.setString(18,facility);
			pstmt_insert3.setString(19,user);
			pstmt_insert3.setString(20,wsno);
			pstmt_insert3.setString(21,facility);
			pstmt_insert3.setString(22,"");
			pstmt_insert3.setString(23,"");
			pstmt_insert3.setString(24,quantity);
			pstmt_insert3.setString(25,unitofvolume);

			tmpcount = pstmt_insert3.executeUpdate();
			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into OR_ORDER_LINE_PH") ;
				connection.rollback();
				return map;

			}
				//System.err.println("or order line ph over");
			/* OR_ORDER_LINE_PH OVER*/


			// Header Level Comments
			String header_comments = (String)tabData.get("header_comments");
			//System.err.println("header comments is"+header_comments);

			if ( (header_comments!=null) && (header_comments.length() > 0) && (!header_comments.equals(""))   )
			{
				pstmt_insert4 = connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS"));
				pstmt_insert4.setString(1, order_id);
				pstmt_insert4.setString(2, "1"); // For Insert it will be "1"
				pstmt_insert4.setString(3, user);
				pstmt_insert4.setString(4, wsno);
				pstmt_insert4.setString(5, facility);
				pstmt_insert4.setString(6, user);
				pstmt_insert4.setString(7, wsno);
				pstmt_insert4.setString(8, facility);
				tmpcount = pstmt_insert4.executeUpdate();
				if(tmpcount > 0 )
				{
//					PreparedStatement pstmt_clob=null;
//					ResultSet	rset_clob=null;
					pstmt_clob		= connection.prepareStatement((String) sqlMap.get( "SQLORDERCOMMENTS1"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,"1");
					rset_clob=pstmt_clob.executeQuery();
					if(rset_clob!=null)
					{
						while(rset_clob.next())
						{
							Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write(header_comments,0,header_comments.length());
							bw.flush();
							bw.close();
						}

					}
				}
				else
				{
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion into OR_ORDER_COMMENTS") ;
					connection.rollback();
					return map;
				}
	  		}
			/* OR_ORDER_COMMENTS OVER*/
			//{admin_time=10:00, admin_qty=56, start_time_assign=, admin_day_or_time=H, repeat=3, row_value=1, duration_type=D}, {admin_time=12:00, admin_qty=56, start_time_assign=, admin_day_or_time=H, repeat=3, row_value=1, duration_type=D}, {admin_time=17:00, admin_qty=56, start_time_assign=, admin_day_or_time=H, repeat=3, row_value=1, duration_type=D}]
			//System.err.println("before Schedule Frequency");
			int seqNo=0;
			if (!scheduleFrequency.isEmpty())
			{
				pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEFIELDVALUES"));
				ArrayList fieldvalues=(ArrayList)scheduleFrequency.get(Regimen_Code);
				for(int n=0;n<fieldvalues.size();n++)
				{
					HashMap data=new HashMap();
					data=(HashMap)fieldvalues.get(n);
  					String admin_time=(String)data.get("admin_time");
  					String admin_qty=(String)data.get("admin_qty");
					pstmt_insert5.setString(1,order_id);
  					pstmt_insert5.setString(2,"1");
  					pstmt_insert5.setString(3,"S");
  					pstmt_insert5.setString(4,""+(seqNo++));
  					pstmt_insert5.setString(5, "SCHED_ADMIN_TIME");
  					pstmt_insert5.setString(6,"C");
  					pstmt_insert5.setString(7,"D");
  					pstmt_insert5.setString(8,admin_time);
  					pstmt_insert5.setString(9,admin_qty);
  					pstmt_insert5.setString(10,unitofvolume);
  					pstmt_insert5.setString(11,"O");
  					pstmt_insert5.setString(12,user);
  					pstmt_insert5.setString(13,wsno);
  					pstmt_insert5.setString(14,facility);
  					pstmt_insert5.setString(15,user);
  					pstmt_insert5.setString(16,wsno);
  					pstmt_insert5.setString(17,facility);
  					pstmt_insert5.addBatch();
				}


				//Execute the batch
				int[] batch_result = pstmt_insert5.executeBatch();
										closeStatement(pstmt_insert5);

				for (int i=0;i<batch_result.length ;i++ )
					{
						if(batch_result[i]<0  && batch_result[i] != -2 ){
							tmpcount=0;
							break;
						}
						else
						{
							tmpcount = 1;
						}
  					}

				if (tmpcount==0)
				{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion of Frequency into Order Line Field Values table") ;
				connection.rollback();
				return map;

				}
			}
			//System.err.println("regimenRemarks is"+regimenRemarks);
			if (!regimenRemarks.isEmpty())
			{
					pstmt_insert5=connection.prepareStatement((String) sqlMap.get( "SQLORDERLINEFIELDVALUES"));
					String  total_seq=(String)regimenRemarks.get("order_format_count") ;
 					int order_format_count=Integer.parseInt(total_seq);
  					for(int k=0;k<order_format_count;k++)
					{
 		  					pstmt_insert5.setString(1,order_id);
 							pstmt_insert5.setString(2,"1"); // order_line_num
 							pstmt_insert5.setString(3,"S");
		 					pstmt_insert5.setString(4,""+(seqNo++));
 							pstmt_insert5.setString(5,(String)regimenRemarks.get("field_mnemonic"+k));
 							pstmt_insert5.setString(6,(String)regimenRemarks.get("field_type"+k));
 							pstmt_insert5.setString(7,(String)regimenRemarks.get("label_text"+k));
 							pstmt_insert5.setString(8,(String)regimenRemarks.get("field_values"+k));
 							pstmt_insert5.setString(9,"");
 							pstmt_insert5.setString(10,"");
 							pstmt_insert5.setString(11,(String)regimenRemarks.get("accept_option"+k));
 							pstmt_insert5.setString(12,user);
							pstmt_insert5.setString(13,wsno);
							pstmt_insert5.setString(14,facility);
							pstmt_insert5.setString(15,user);
							pstmt_insert5.setString(16,wsno);
							pstmt_insert5.setString(17,facility);
							pstmt_insert5.addBatch();
						}
						//Execute the batch
						int[] batch_result = pstmt_insert5.executeBatch();
						for (int i=0;i<batch_result.length ;i++ )
						{
							if(batch_result[i]<0  && batch_result[i] != -2 ){
								tmpcount=0;
								break;
							}
							else
							{
								tmpcount = 1;
							}
  						}
						if (tmpcount==0)
						{
						//failure and so
						map.put( "result", new Boolean( false) ) ;
						map.put( "msgid", "Error During Insertion of Remarks into Order Line Field Values table") ;
						connection.rollback();
						return map;

						}


				}



			/* OR_ORDER_LINE_FIELD_VALUES OVER*/

			//INSERT INTO PH_MEDN_ADMIN
			int j;
			PreparedStatement pstmt_select	=null;
			ResultSet temprs						=null;

			//Check ph_facility_param
			PreparedStatement pstmttmp=connection.prepareStatement((String) sqlMap.get( "SQLFACILITYPARAMSELECT"));
			pstmttmp.setString(1,facility);
			ResultSet rstmp=pstmttmp.executeQuery();
			String verify			="N";
			String medadmin	="N";
			if (rstmp.next())
			{
				verify		=rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN")==null?"N":rstmp.getString("VERF_REQD_BEF_MED_ADMIN_YN");
				medadmin	=rstmp.getString("MED_ADMIN_REQD_YN")==null?"N":rstmp.getString("MED_ADMIN_REQD_YN");
			}
						closeStatement(pstmttmp);
						closeResultSet(rstmp);

			if (	(medadmin.equals("Y"))&&(!scheduleFrequency.isEmpty())&&(patient_class.equals("IP"))  )
			{
				pstmt_insert6=connection.prepareStatement((String) sqlMap.get( "SQLMEDNADMIN"));
				for (int i=0;i<Integer.parseInt(duration) ;i++ )
				{
					j=1;
					ArrayList fieldvalues=(ArrayList)scheduleFrequency.get(Regimen_Code);
					for(int n=0;n<fieldvalues.size();n++)
					{

						HashMap data=new HashMap();
						data=(HashMap)fieldvalues.get(n);

  						String admin_time	=(String)data.get("admin_time");
//  						String admin_qty	=(String)data.get("admin_qty");
						String schdatetime	="";

						//System.err.println("Inside MEDN ADMIN LOOP");
						//System.err.println(fieldvalues.size());
						//System.err.println(admin_time);


						pstmt_select=connection.prepareStatement((String) sqlMap.get( "SQLDATESELECT"));
						pstmt_select.setString(1,startdate);
						pstmt_select.setString(2,""+i);
						pstmt_select.setString(3,admin_time);
						temprs=pstmt_select.executeQuery();
						if (temprs.next())
						{
							schdatetime=temprs.getString("SCHDATE");
						}
						closeResultSet(temprs);
						closeStatement(pstmt_select);
						pstmt_insert6.setString(1,facility);
						pstmt_insert6.setString(2,encounter_id);
						pstmt_insert6.setString(3,schdatetime);
						pstmt_insert6.setString(4,Regimen_Code);
						pstmt_insert6.setString(5,""+(j++));
						pstmt_insert6.setString(6,order_id);
						pstmt_insert6.setString(7,"1");
						pstmt_insert6.setString(8,patient_id);
						pstmt_insert6.setString(9,pract_id);
						pstmt_insert6.setString(10,quantity);
						pstmt_insert6.setString(11,unitofvolume);
						pstmt_insert6.setString(12,"")/*SCH_ROUTE_CODE*/;
						pstmt_insert6.setString(13,user);
						pstmt_insert6.setString(14,wsno);
						pstmt_insert6.setString(15,facility);
						pstmt_insert6.setString(16,user);
						pstmt_insert6.setString(17,wsno);
						pstmt_insert6.setString(18,facility);
						pstmt_insert6.setString(19,verify)/*VERIFY_REQD_YN*/;
						pstmt_insert6.addBatch();

					}

				}
				//Execute Batch for PH_MEDN_ADMIN

				int[] batch_result = pstmt_insert6.executeBatch();
				for (int i=0;i<batch_result.length ;i++ )
				{
						if(batch_result[i]<0  && batch_result[i] != -2 ){
							tmpcount=0;
							break;
						}
						else
						{
							tmpcount = 1;
						}
				}
				if (tmpcount==0)
				{
					//failure and so
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Error During Insertion into PH MEDN ADMIN table") ;
					connection.rollback();
					return map;
				}



			}

			/* PH_MEDN_ADMIN OVER */
			//Now call workload procedure

			CallableStatement cstmt_insert=null;
			cstmt_insert=connection.prepareCall("{call PH_CREATE_WORKLOAD_STATS(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt_insert.setString( 1, pract_id);
			cstmt_insert.setString( 2, order_date);
			cstmt_insert.setString( 3, facility);
			cstmt_insert.setString( 4, patient_class);
			cstmt_insert.setString( 5, location_type);
			cstmt_insert.setString( 6, location_code);
			cstmt_insert.setString( 7,"1");
			cstmt_insert.setString( 8,"1");
			cstmt_insert.setString( 9, wsno);
			cstmt_insert.setString( 10, user);
			cstmt_insert.registerOutParameter(11, Types.VARCHAR );
			cstmt_insert.registerOutParameter(12, Types.VARCHAR );
			cstmt_insert.execute() ;
			String insert_yn	= cstmt_insert.getString( 11 );
//			String error_msg	= cstmt_insert.getString( 12 );
			closeStatement(cstmt_insert);
			if(insert_yn.equals("Y"))
						tmpcount = 1;
			else
						tmpcount = 0;

			if (tmpcount==0)
			{
				//failure and so
				map.put( "result", new Boolean( false) ) ;
				map.put( "msgid", "Error During Insertion into Workload Statistics Table") ;
				connection.rollback();
				return map;

			}
			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_INSERTED") ;
			connection.commit();





		}//end of try
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception has occured: " +e+debug) ;
			e.printStackTrace();
					}
		finally {
			try {
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeStatement( pstmt_insert3 ) ;
				closeStatement( pstmt_insert4 ) ;
				closeStatement( pstmt_insert5 ) ;
				closeStatement( pstmt_insert6 ) ;
//				closeConnection( connection );
				closeStatement( pstmt_clob );
				closeResultSet( rset_clob );
				closeConnection( connection, (Properties)tabData.get( "properties" ) );

			}
			catch ( Exception fe ) {
				//System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;

			}
		}

		return map ;

	}

// insert method ends here

//  modify method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
			
				return new HashMap() ;
	}

				  
	/* Function specific methods end */

	
	

	// delete method starts here
public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}
	// delete method ends here
}
