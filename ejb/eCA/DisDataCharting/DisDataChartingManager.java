/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
18/01/2013		IN037372		Ramesh G		Oracle 11g Weblogic compilation.
11/12/2013      IN034536		Nijitha S		Bru-HIMS-CRF-133 
19/06/2019		IN009120		Ramesh G		CA-Record Vital Signs-Weight component data is not updated in CEH
--------------------------------------------------------------------------------------------------------------------
*/
package eCA.DisDataCharting;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import java.util.*;
import javax.naming.*;
import java.io.*;
import javax.rmi.*;
import webbeans.eCommon.*;
//import oracle.sql.*;

/**
*
* @ejb.bean
*	name="DisDataCharting"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DisDataCharting"
*	local-jndi-name="DisDataCharting"
*	impl-class-name="eCA.DisDataCharting.DisDataChartingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.DisDataCharting.DisDataChartingLocal"
*	remote-class="eCA.DisDataCharting.DisDataChartingRemote
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.DisDataCharting.DisDataChartingLocalHome"
*	remote-class="eCA.DisDataCharting.DisDataChartingHome"
*	generate= "local,remote"
*
*
*/

public class DisDataChartingManager implements SessionBean 
{
	 boolean transaction_success=true;

 	 Connection con ;

	 PreparedStatement stmt		=	null;
	 ResultSet rs				=	null;

	 String location_type				=			"",			locale			=		"";

	 StringBuffer sb	= new StringBuffer("");
	 /**
		modified by Deepa on 5/24/2010 for PE issue.
		data appended to sb1 StringBuffer was not used in the corresponding servlet, VitalSignRecordServlet.java.
		So, the StringBuffer has been commented.
	 **/
	 //StringBuffer sb1	= new StringBuffer("");
		
	 SessionContext ctx;

	 public void ejbCreate() {}
	 public void ejbRemove() {}
	 public void ejbActivate() {}
	 public void ejbPassivate() {}
	 public void setSessionContext( SessionContext context ) { this.ctx=context;}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap operateDisDataCharting(
							java.util.Properties p,
							String operatingfacilityid ,                                   
							String episodetype ,                    
							String episodeid ,                         
							String visitid ,                                
							String clinicianid ,                         
							String locncode ,                          
							String patientid,
							String batteryid,
							String Sdate,
							String finalvalues[][],
							String admdttime,
							String outrec_temp,
							String noofvals_temp,
							String added_at_ws_no,
							String location_type_param,
							String module_id,
							String inError,
							String inReplace,
							String isPatientEncMovement,
							String p_queue_date,
							String Sydate
						)	//Added p_queue_date and isPatientEncMovement for IN034536
	{
		java.util.HashMap results = new java.util.HashMap() ;
		String mes	= "";

//		try
//		{
		
			noofvals_temp=noofvals_temp;
			int outrec=Integer.parseInt(outrec_temp);
			boolean result = true ;
			transaction_success=true;
			location_type = location_type_param ;//defined as gobal variable so no need to pass to each function 
			episodetype	  =	(episodetype==null)?"":episodetype ;

			//sb1.setLength(0);

		try
		{
			locale		= (String) p.getProperty("LOCALE");

			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			String accessionnum			= null;
			String discrmsrid			= null;
			String discrmsrresulttype	= null;
			String discrmsrresultnum	= null;
			String discrmsrresultnumuom = null;
			String discrmsrresultstr	= null;
			String discrmsrresultdata	= null;
			String normallow			= null;
			String normalhigh			= null;
			String criticallow			= null;
			String criticalhigh			= null;
			String normabnormind		= null;
			String operation			= null;
			String value				= null;

			HashMap ret = null;
			PreparedStatement st = null;
			ResultSet rss = null;
			
			

			for(int i=1;i<outrec;i++)
			{
					int j =0;
					accessionnum = finalvalues[i][j++];                         
					discrmsrid = finalvalues[i][j++];                                
					discrmsrresulttype = finalvalues[i][j++];                 
					discrmsrresultnum = finalvalues[i][j++];                 
					discrmsrresultnumuom = finalvalues[i][j++];         
					discrmsrresultstr = finalvalues[i][j++];                    
					discrmsrresultdata = finalvalues[i][j++];                 
					normallow = finalvalues[i][j++];                                
					normalhigh = finalvalues[i][j++];                               
					criticallow = finalvalues[i][j++];                                 
					criticalhigh = finalvalues[i][j++];                               
					normabnormind = finalvalues[i][j++];                      
					operation = finalvalues[i][j++];    
					String errorRemarks = finalvalues[i][j++];

					value		=	discrmsrresultnum+discrmsrresultstr+discrmsrresultdata;
					value		 =	(value==null)?"":value ;
					operation	 =	(operation==null)?"":operation ;
					discrmsrresultdata	 =(discrmsrresultdata==null)?"":discrmsrresultdata ;					

					if(inReplace.equals("Y") && operation.equals("U"))	
					{
						 ret =  updateDisDataCharting (
															p,
															con,
															operatingfacilityid ,
															episodetype ,
															episodeid ,
															visitid ,
															accessionnum ,
															clinicianid ,
															discrmsrid ,
															discrmsrresulttype ,
															discrmsrresultnum ,
															discrmsrresultnumuom ,
															discrmsrresultstr ,
															discrmsrresultdata ,
															normabnormind,
															batteryid,   //IN009120
															Sdate,
															added_at_ws_no,
															inReplace,
															errorRemarks//added
															);
							boolean retval=((Boolean)ret.get("status")).booleanValue();
//							sb.append((String)ret.get("error"));
							ret.clear();
							if(retval) transaction_success = true;
							else transaction_success = false;

							String d="";
							StringBuffer s =new StringBuffer();
				
							s.append(" select to_char(TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi:ss') from ca_encntr_discr_msr ");
							s.append(" where FACILITY_ID = ? ");
							s.append(" and ACCESSION_NUM  = ? ");
							s.append(" and DISCR_MSR_ID = ? ");
				
							st=con.prepareStatement(s.toString());
							st.setString(1, operatingfacilityid);
							st.setString(2, accessionnum);
							st.setString(3, discrmsrid);
							
							rss=st.executeQuery();
							
							if( rss.next()) 
								 d=rss.getString(1);
							
							if(rss != null) rss.close();
							if(st != null) st.close();

							ret =  insertDisDataCharting(
															p,
															con,
															operatingfacilityid ,          	
															accessionnum ,                 
															episodetype ,                    
															episodeid ,                         
															visitid ,                                
															clinicianid ,                         
															discrmsrid ,                        
															discrmsrresulttype ,         
															discrmsrresultnum ,         
															discrmsrresultnumuom , 
															discrmsrresultstr ,            
															discrmsrresultdata ,         
															normallow ,                        
															normalhigh ,                      
															criticallow ,                        
															criticalhigh ,                       
															locncode ,                           
															patientid,                            
															normabnormind,               
															batteryid,                           
															d,
															added_at_ws_no,
															location_type
															);
							 retval=((Boolean)ret.get("status")).booleanValue();
//							 sb.append((String)ret.get("error"));
							 ret.clear();
							 if(retval) transaction_success = true;
							 else transaction_success = false;		

					}
					else if(inError.equals("Y"))
					{
							 //sb1.append("No. 0");
							 ret =  updateDisDataCharting (
															p,
															con,
															operatingfacilityid ,
															episodetype ,
															episodeid ,
															visitid ,
															accessionnum ,
															clinicianid ,
															discrmsrid ,
															discrmsrresulttype ,
															discrmsrresultnum ,
															discrmsrresultnumuom ,
															discrmsrresultstr ,
															discrmsrresultdata ,
															normabnormind,
															batteryid,		//IN009120
															Sdate,
															added_at_ws_no,
															inError,
															errorRemarks//added
															);
							boolean retval=((Boolean)ret.get("status")).booleanValue();
//							sb.append((String)ret.get("error"));
							ret.clear();
							if(retval) transaction_success = true;
							else transaction_success = false;
					}
					else if (!(value.equals("") || value.equals(" ")))
					{
							if ( operation.equals("I") ) 
							{
								//sb1.append("No. 1");
								ret =  insertDisDataCharting(
															p,
															con,
															operatingfacilityid ,          	
															accessionnum ,                 
															episodetype ,                    
															episodeid ,                         
															visitid ,                                
															clinicianid ,                         
															discrmsrid ,                        
															discrmsrresulttype ,         
															discrmsrresultnum ,         
															discrmsrresultnumuom , 
															discrmsrresultstr ,            
															discrmsrresultdata ,         
															normallow ,                        
															normalhigh ,                      
															criticallow ,                        
															criticalhigh ,                       
															locncode ,                           
															patientid,                            
															normabnormind,               
															batteryid,                           
															Sdate,
   								                            added_at_ws_no,
															location_type
															);
								boolean retval=((Boolean)ret.get("status")).booleanValue();
//								sb.append((String)ret.get("error"));
								ret.clear();
								if(retval) transaction_success = true;
								else transaction_success = false;
							}
							
							if ( operation.equals("U"))  
							{
								//sb1.append("No. 2");
							   ret =  updateDisDataCharting 
							   (
															p,
															con,
															operatingfacilityid ,             		
															episodetype ,                       
															episodeid ,                            
															visitid ,                                   
															accessionnum ,                    
															clinicianid ,                            
															discrmsrid ,                           
															discrmsrresulttype ,           
															discrmsrresultnum ,            
															discrmsrresultnumuom ,    
															discrmsrresultstr ,               
															discrmsrresultdata ,           
															normabnormind,
															batteryid,				//IN009120
															Sdate,
															added_at_ws_no,
														   	"",
															errorRemarks//added
															);
							boolean retval=((Boolean)ret.get("status")).booleanValue();
//							sb.append((String)ret.get("error"));
							ret.clear();
							if(retval) transaction_success = true;
							else transaction_success = false;
						}
					}else{
							
						/*
						if ( operation.equals("U"))  
						{
						   sb1.append("No. 3");
			   ret = deleteDisDataCharting (
														p,	
														con,
														operatingfacilityid , 
														accessionnum ,        
														clinicianid ,               
														discrmsrid                 
														);
			
							boolean retval=((Boolean)ret.get("status")).booleanValue();
							sb.append((String)ret.get("error"));
							if(retval) transaction_success = true;
							else transaction_success = false;
						} */
					}
			}

			//if(episodetype.equals("O"))
			if(module_id.equals("OP")){
					 //sb1.append("No. 4");
					ret =  modifyPatientQueue(
													p,
													con,
													patientid ,    
													episodeid ,   
													visitid ,         
													locncode,     
													clinicianid,   
													admdttime  ,
													operatingfacilityid	,//added
													isPatientEncMovement,
													p_queue_date,
													Sydate												
													);//Added for IN034536
					boolean retval=((Boolean)ret.get("status")).booleanValue();
					sb.append(String.valueOf(retval));
					sb.append((String)ret.get("error"));
					/*sb1.append(String.valueOf(retval));
					sb1.append((String)ret.get("error"));
					sb1.append((String)ret.get("query"));*/
					ret.clear();
					if(!retval) transaction_success = false;
			}
		}
		catch(Exception e)
		{
			sb.append(e.toString());
		}
		finally 
		{
			try 
			{
				if(transaction_success)
				{
					java.util.Hashtable message =  MessageManager.getMessage( locale, "RECORD_INSERTED" ,"CA") ;
					mes = (String) message.get("message");
					con.commit();
					result=true;
					message.clear();
				}	
				else	
				{
					java.util.Hashtable message = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
					mes = (String) message.get("message");
					con.rollback();
					result=false;
					message.clear();
				}
			}
			catch (Exception e) 
			{
				sb.append(e);
				try{	con.rollback();}catch(Exception ce){ce.printStackTrace();}
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,p); 
				results.put( "status", new Boolean(result) ) ;
				results.put( "error", mes) ;
				//results.put( "query", sb1.toString() ) ;
			}
		}
/*	
	}catch (Exception e) {
		sb.append(e);
		try{	con.rollback();}catch(Exception ce){ce.printStackTrace();}
		return null;
	}finally{
		try{
					 if(rs!=null)	 rs.close();
					 if(con!=null) { ConnectionManager.returnConnection(con,p); }
		}catch(Exception e){e.printStackTrace();}
	 }
	 */
	return results ;
   }

	public java.util.HashMap insertDisDataCharting(
											java.util.Properties p,
											Connection con,
											String operatingfacilityid ,         
											String accessionnum ,                  
											String episodetype ,                   
											String episodeid ,                     
											String visitid ,                       
											String clinicianid ,        
											String discrmsrid ,                   
											String discrmsrresulttype ,          
											String discrmsrresultnum ,           
											String discrmsrresultnumuom ,       
											String discrmsrresultstr ,           
											String discrmsrresultdata ,          
											String normallow ,                     
											String normalhigh ,                    
											String criticallow ,                   
											String criticalhigh ,   
											String locncode ,
											String patientid,
											String normabnormind,
											String batteryid,
											String Sdate,
											String added_at_ws_no	,
											String location_type
											) 
		{

		accessionnum	=	accessionnum;
		visitid			=	visitid;
		locncode		=	locncode;
		location_type	=	location_type;

		StringBuffer sbin=new StringBuffer("") ;
		
		java.util.HashMap results = new java.util.HashMap() ;
		
		boolean result = true ;
		
		transaction_success=true;
		
		String insertsql = "";

		try
		{
		
			String addedById		 = p.getProperty( "login_user" ) ;
			
			insertsql = " insert into ca_encntr_discr_msr(FACILITY_ID,ACCESSION_NUM,ENCOUNTER_ID, PATIENT_ID,PATIENT_CLASS,TEST_OBSERV_DT_TM,PERFORMING_PRACT_ID,DISCR_MSR_ID, DISCR_MSR_RESULT_TYPE,DISCR_MSR_RESULT_NUM,DISCR_MSR_RESULT_NUM_UOM, DISCR_MSR_RESULT_STR,DISCR_MSR_RESULT_DATA,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW, CRITICAL_HIGH,NORM_ABNORM_IND,DISCR_MSR_PANEL_OR_FORM_ID,ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) values(?, 'DM$'||to_char(sysdate,'YYYY')||'$'||lpad(CA_DISCR_MSR_SEQ.NEXTVAL,16,0),?,?,?, to_date( ? ,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,empty_clob(),?,?,?,?,?,?,?,sysdate,?,?,?, sysdate,?,?)";
		
			if(stmt != null) stmt.close();	
			stmt = con.prepareStatement(insertsql);

			stmt.setString(1, operatingfacilityid);
			stmt.setString(2, episodeid);
			stmt.setString(3, patientid);
			stmt.setString(4, episodetype);
			stmt.setString(5, Sdate);
			stmt.setString(6, clinicianid);
			stmt.setString(7, discrmsrid);
			stmt.setString(8, discrmsrresulttype);
			stmt.setString(9, discrmsrresultnum);
			stmt.setString(10,discrmsrresultnumuom);
			stmt.setString(11,discrmsrresultstr);
			stmt.setString(12,normallow);
			stmt.setString(13,normalhigh);
			stmt.setString(14,criticallow);
			stmt.setString(15,criticalhigh);
			stmt.setString(16,normabnormind);
			stmt.setString(17,batteryid);
			stmt.setString(18,addedById);
			stmt.setString(19,operatingfacilityid);
			stmt.setString(20,added_at_ws_no);
			stmt.setString(21,addedById);
			stmt.setString(22,operatingfacilityid);
			stmt.setString(23,added_at_ws_no);

			int  rsinsertsql = stmt.executeUpdate(); 
			
			if(rsinsertsql !=0)	
				transaction_success = true;
			else
				transaction_success = false;

			if(transaction_success)
			{
				if(!(discrmsrresultdata.equals("") || discrmsrresultdata.equals(" ") || discrmsrresultdata == null))
				{
					StringBuffer sql =new StringBuffer();
					int currseq_val = 0;
					
					try
					{
						stmt = con.prepareStatement("SELECT CA_DISCR_MSR_SEQ.CURRVAL FROM DUAL");
						rs = stmt.executeQuery() ;
					
						if(rs.next())	
						  currseq_val = rs.getInt(1);
		
						if(rs != null) rs.close();	
						if(stmt != null) stmt.close();	
			
						sql.append(" Select DISCR_MSR_RESULT_DATA from ca_encntr_discr_msr WHERE ACCESSION_NUM= 'DM$'||to_char(sysdate,'YYYY')||'$'||lpad('");
						sql.append(currseq_val);
						sql.append("',16,0) for update "); 

						stmt = con.prepareStatement(sql.toString());
						rs = stmt.executeQuery();
					}
					catch(Exception e)
					{
						
						e.printStackTrace();
					}
					
					Clob clb = null;

					if(rs.next())	
					  clb = rs.getClob(1);
					
					//Web logic Conversion -- [IN037372] Start.
					//BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());
					BufferedWriter w = new BufferedWriter(clb.setCharacterStream(0));
					//Web logic Conversion -- [IN037372] End.
					w.write(discrmsrresultdata,0,discrmsrresultdata.length());
					w.flush();
					w.close();
				
					transaction_success = true;
					sql.setLength(0);
				}
			}
		}
		catch(Exception e)
		{
			transaction_success = false;
			sbin.append("Insert failed "+e);
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		try
		{
			if(transaction_success)
				result=true;
			else
				result=false;
		}
		catch(Exception e)
		{
			sbin.append("Insert failed "+e);
		}
		finally 
		{
			try
			{
					 if(rs!=null)	 rs.close();
			}
			catch (Exception e) 
			{
				sbin.append("Close stmts"+e);
			}
		}//FINALLY
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sbin.toString() ) ;
		return results ;

} // end insertDisDataCharting



	public java.util.HashMap updateDisDataCharting(
											java.util.Properties p,
											Connection con,
											String operatingfacilityid ,      
											String episodetype ,                   
											String episodeid ,                     
											String visitid ,  
											String accessionnum ,                  
											String clinicianid ,        
											String discrmsrid ,                   
											String discrmsrresulttype ,          
											String discrmsrresultnum ,           
											String discrmsrresultnumuom ,       
											String discrmsrresultstr ,           
											String discrmsrresultdata ,
											String normabnormind,
											String batteryid,	//IN009120
											String Sdate,
											String added_at_ws_no,
											String inError,
											String errorRemarks
											) 
		{
			episodetype=episodetype;
			visitid=visitid;
			discrmsrresulttype=discrmsrresulttype;
		StringBuffer sbup=new StringBuffer("") ;
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = true ;
		transaction_success=true;
		StringBuffer updatesql =new StringBuffer();

		try
		{
			String addedById		 = p.getProperty( "login_user" ) ;
			String modifiedById		 = addedById ;
			/**********************************/
			String errorMarkedById	 = addedById;
			/**********************************/
			//con = ConnectionManager.getConnection(p);
			//con.setAutoCommit(false);
 if(inError.equals("Y"))
			{
//	sbup.append("in error yyyy");
				updatesql.append(" update ca_encntr_discr_msr ");
				updatesql.append(" set ERROR_MARKED_BY_ID  = ? ");
				updatesql.append(" ,ERROR_MARKED_DATE = sysdate ");
				updatesql.append(" ,ERROR_YN= ? ");
				updatesql.append(" ,ERROR_REMARKS  = ? ");
				updatesql.append(" where FACILITY_ID = ? ");
				updatesql.append(" and ACCESSION_NUM  = ? ");
				updatesql.append(" and DISCR_MSR_ID = ? ");
			} else 	{
//								sbup.append("in update");
								updatesql.append(" update ca_encntr_discr_msr ");
								updatesql.append("set TEST_OBSERV_DT_TM = to_date( ? ,'dd/mm/yyyy hh24:mi:ss') ");
								updatesql.append(", DISCR_MSR_ID = ? ");
								updatesql.append(", DISCR_MSR_RESULT_NUM = ? ");
								updatesql.append(", DISCR_MSR_RESULT_NUM_UOM = ? ");
								updatesql.append(", DISCR_MSR_RESULT_STR = ? ");
								updatesql.append(", DISCR_MSR_RESULT_DATA = empty_clob() ");
								updatesql.append(", NORM_ABNORM_IND = ? ");
								updatesql.append(", PERFORMING_PRACT_ID = ? ");
								updatesql.append(", MODIFIED_BY_ID = ? ");
								updatesql.append(", MODIFIED_DATE = sysdate ");
								updatesql.append(", MODIFIED_FACILITY_ID = ? ");
								updatesql.append(", MODIFIED_AT_WS_NO = ? ");
								updatesql.append(", DISCR_MSR_PANEL_OR_FORM_ID = ? "); //IN009120
								updatesql.append("where FACILITY_ID = ? ");
								updatesql.append("and ACCESSION_NUM  = ? ");
								updatesql.append("and DISCR_MSR_ID = ? ");
			}

			if(stmt != null)stmt = null;
			stmt = con.prepareStatement(updatesql.toString());

			if(inError.equals("Y")){
				stmt.setString(1, errorMarkedById);
				stmt.setString(2, inError);
				stmt.setString(3, errorRemarks);
				stmt.setString(4, operatingfacilityid);
				stmt.setString(5, accessionnum);
				stmt.setString(6, discrmsrid);
			}else{
				stmt.setString(1, Sdate);
				stmt.setString(2, discrmsrid);
				stmt.setString(3, discrmsrresultnum);
				stmt.setString(4, discrmsrresultnumuom);
				stmt.setString(5, discrmsrresultstr);
				stmt.setString(6, normabnormind);
				stmt.setString(7, clinicianid);
				stmt.setString(8, modifiedById);
				stmt.setString(9, operatingfacilityid);
				stmt.setString(10, added_at_ws_no);				
				//IN009120 Start.
				//stmt.setString(11, operatingfacilityid);
				//stmt.setString(12, accessionnum);
				//stmt.setString(13, discrmsrid);				
				stmt.setString(11, batteryid);
			    stmt.setString(12, operatingfacilityid);
				stmt.setString(13, accessionnum);
				stmt.setString(14, discrmsrid);				
				//IN009120 End.
			}

			int  rsupdatesql = stmt.executeUpdate();

			if(rsupdatesql !=0){
				transaction_success = true;
			}else{
				transaction_success = false;
			}

			updatesql.setLength(0);

			if(transaction_success)	{
				if(!discrmsrresultdata.equals(""))	{
					StringBuffer sql =new StringBuffer();
					sql.append(" Select DISCR_MSR_RESULT_DATA from ca_encntr_discr_msr ");
					sql.append(" where facility_id = ? ");
					sql.append(" and accession_num = ? ");
					sql.append(" and  DISCR_MSR_ID = ? ");
					sql.append(" AND ENCOUNTER_ID  = ? ");
					sql.append(" for update ");	 
					
					if(stmt != null) stmt.close();	
					stmt = con.prepareStatement(sql.toString());

					stmt.setString(1,operatingfacilityid);	
					stmt.setString(2,accessionnum);
					stmt.setString(3,discrmsrid);
					stmt.setString(4,episodeid);

					rs = stmt.executeQuery() ;
	
					//Clob clb = null;  //Web logic Conversion -- [IN037372]
					java.sql.Clob clb = null;
					if(rs.next())	{
						  clb = rs.getClob(1);
						 //Web logic Conversion -- [IN037372] Start. 
						  //BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());
						  BufferedWriter w = new BufferedWriter(clb.setCharacterStream(0));
						 //Web logic Conversion -- [IN037372] End. 
						  w.write(discrmsrresultdata,0,discrmsrresultdata.length());
						  w.flush();
						  w.close();
					}
					transaction_success = true;
					sql.setLength(0);
				}

				
			}
			}catch(Exception e){
				transaction_success=false;
				sbup.append("Update failed  @ 658"+e);
			}	

			finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}catch(Exception e){e.printStackTrace();}
			}

			try{
				if(transaction_success){
					result=true;
				}else{
					result=false;
				}
			}catch(Exception e){
				sbup.append("2 "+e);
			}finally {
					try{
						 if(rs!=null)	 rs.close();
					}catch (Exception e) {
						sbup.append("Close stmts"+e);
					}
			}//FINALLY
			results.put( "status", new Boolean(result) ) ;
//			results.put( "error", sbup.toString() ) ;
			return results ;

} // end updateDisDataCharting


	public java.util.HashMap deleteDisDataCharting(
											java.util.Properties p,
											Connection con,
											String operatingfacilityid ,         
											String accessionnum ,                  
											String clinicianid ,        
											String discrmsrid               
											) 
		{
		clinicianid=clinicianid;
		 p=p;
		StringBuffer sbdel =new StringBuffer("") ;
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = true ;
		transaction_success=true;
		StringBuffer deletesql =new StringBuffer();

		try
		{
			//String addedById		 = p.getProperty( "login_user" ) ;
			//String modifiedById		 = addedById ;

			deletesql.append(" delete from ca_encntr_discr_msr ");
			deletesql.append(" where facility_id = ? ");
			deletesql.append(" and accession_num = ? ");
			deletesql.append(" and  DISCR_MSR_ID = ? ");
			if(stmt != null) stmt.close();	
			stmt = con.prepareStatement(deletesql.toString());

			stmt.setString(1,operatingfacilityid);
			stmt.setString(2,accessionnum);
			stmt.setString(3,discrmsrid);

			int  rsdeletesql = stmt.executeUpdate(); 
			if(rsdeletesql !=0)
			{
				transaction_success = true;
				//con.commit();
			}
			else
			{
				transaction_success = false;
				//con.rollback();
			}

			deletesql.setLength(0);

		}catch(Exception e){
			transaction_success=false;
			sbdel.append("Delete failed "+e);
		}	

		finally{
			try{
				if(stmt!=null) stmt.close();
			}catch(Exception e){}
		}

		try{
			if(transaction_success){
				result=true;
			}	else	{
					result=false;
			}
		}catch(Exception e){
			sbdel.append("Transaction failed "+e);
		}finally {
				try{
					 if(rs!=null)	 rs.close();
				}catch (Exception e) {
					sbdel.append("Close stmts"+e);
				}
		}//FINALLY
			
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sbdel.toString() ) ;
			return results ;

		} // end deleteDisDataCharting


			public java.util.HashMap modifyPatientQueue(
											java.util.Properties p,
											Connection con,
											String patientid ,         
											String episodeid ,                  
											String visitid ,        
											String locncode,
											String clinicianid,
											String admdttime,
											String facilityID,
											String isPatientEncMovement,
											String p_queue_date,
											String Sydate)//Added for IN034536
											
		{
			visitid=visitid;
			admdttime=admdttime;
			p=p;
		StringBuffer sbpq =new StringBuffer("") ;
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = true ;
		transaction_success=true;
		StringBuffer sql =new StringBuffer();
		ResultSet rs1 =null;
		try{
		
			//String addedById		 = p.getProperty( "login_user" ) ;
			//String modifiedById		 = addedById ;
			
			String sql1 = " Select ASSIGN_CARE_LOCN_TYPE  ,ASSIGN_CARE_LOCN_CODE  ,ATTEND_PRACTITIONER_ID "+
						  " from pr_encounter where facility_id = ? and encounter_id = ? ";

			if(stmt != null) stmt.close();	
			stmt = con.prepareStatement(sql1);

			stmt.setString(1,facilityID);
			stmt.setString(2,episodeid);

			rs1 = stmt.executeQuery() ;	
			//sb1.append(sql1);
			while(rs1!=null && rs1.next())
			{
				locncode 		= rs1.getString("ASSIGN_CARE_LOCN_CODE");
				location_type 	= rs1.getString("ASSIGN_CARE_LOCN_TYPE");
				clinicianid 	= rs1.getString("ATTEND_PRACTITIONER_ID");			  
			}
			if(rs1!=null) rs1.close();
			
          /*  sql.append(" update  op_patient_queue_summ  ");
            sql.append(" set tot_vs_checked = tot_vs_checked+1  ");
            sql.append(" where facility_id = ? ");
            sql.append(" and locn_code = ? ");
            sql.append(" and locn_type = ? ");
            sql.append(" and practitioner_id = nvl( ? ,'*ALL')  ");
            sql.append(" and queue_shift = '*ALL'  ");
            sql.append(" and trunc(queue_date) = trunc(sysdate)  ");

			sb1.append(sql);

			if(stmt != null) stmt.close();	
			stmt = con.prepareStatement(sql.toString());

			stmt.setString(1 ,facilityID);	
			stmt.setString(2 ,locncode);	
			stmt.setString(3 ,location_type);	
			stmt.setString(4 ,clinicianid);	

			 stmt.executeUpdate(); */
		
		sql.setLength(0);

		sql.append(" Update  op_patient_queue ");
		sql.append(" set   queue_status =DECODE( queue_status, '00','03', '01','03','02','03',queue_status), ");
		sql.append(" vital_signs_date_time = sysdate ");
		sql.append(" where patient_id = ? ");
		sql.append(" and facility_id = ? ");
		sql.append(" and trunc(queue_date) = trunc(sysdate) ");
		sql.append(" and locn_type = ? ");
		sql.append(" and  locn_code = ? ");
		sql.append(" and practitioner_id = nvl( ?, '*ALL') ");
		sql.append(" and queue_shift='*ALL' and encounter_id = ? and vital_signs_date_time is null ");


			//sb1.append(sql);

			if(stmt != null) stmt.close();	
			stmt = con.prepareStatement(sql.toString());

			stmt.setString(1,patientid);
			stmt.setString(2,facilityID);
			stmt.setString(3,location_type);
			stmt.setString(4,locncode);
			stmt.setString(5,clinicianid);
			stmt.setLong(6,Long.parseLong(episodeid.trim()));

			 stmt.executeUpdate(); 
			
			sql.setLength(0);
			/*IN034536 Below line added for this CRF Bru-HIMS-CRF-133*/
			CallableStatement cstmt = null;	
			
			if(eOP.QMSInterface.isSiteSpecific(con,"OP","PATENC_MOVEMENT") && isPatientEncMovement.equals("true") && p_queue_date.equals(Sydate)){
			     
			    cstmt = con.prepareCall("{call PR_ENC_MVMNT(?,?,?,?,?)}");
			    cstmt.setString(1, facilityID);
			    cstmt.setString(2, patientid);
			    cstmt.setString(3, episodeid);
				cstmt.setString(4, "03");
				cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
				cstmt.execute();								
				
				
				if (cstmt != null){
					cstmt.close();
				}							 
			 }
			 //IN034536 End Bru-HIMS-CRF-133
		}catch(Exception e){
			transaction_success=false;
			sbpq.append("Update failed @863 "+e);
		}
		
		finally{
			try{
				if(rs1!=null) rs1.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){e.printStackTrace();}
		}

		try
		{
			if(transaction_success){
				result=true;
			}
			else	{
				result=false;
			}
		}catch(Exception e){
			sbpq.append("Transaction failed "+e);
		}
		
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sbpq.toString() ) ;
		//results.put( "query", sb1.toString() ) ;
		return results ;

		} // end modifyPatientQueue
	
		private String getMessage(String locale, String messageId, String moduleId)
		{
			MessageManager mm = new MessageManager();
			java.util.Hashtable message = mm.getMessage(locale,messageId,moduleId);
			String mesg = (String) message.get("message");
/*
			try
			{
				mesg = java.net.URLEncoder.encode(mesg,"UTF-8");				
			}
			catch (Exception eeee)
			{
			
			}
*/
			message.clear();
			return(mesg) ;
		}
}
