/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History     Name           Rev.Date		  Rev.Name		Description
-------------------------------------------------------------------------------------------------------
07/08/2019	IN070957		Ramya Maddena	07/08/2019   Ramesh G
-------------------------------------------------------------------------------------------------------
*/
package eAM.DiscrMeasure ;
import java.rmi.* ;
import javax.ejb.* ;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="DiscrMeasure"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DiscrMeasure"
*	local-jndi-name="DiscrMeasure"
*	impl-class-name="eAM.DiscrMeasure.DiscrMeasureManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.DiscrMeasure.DiscrMeasureLocal"
*	remote-class="eAM.DiscrMeasure.DiscrMeasureRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.DiscrMeasure.DiscrMeasureLocalHome"
*	remote-class="eAM.DiscrMeasure.DiscrMeasureHome"
*	generate= "local,remote"
*
*
*/



public class DiscrMeasureManager implements SessionBean {

	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt1;
	ResultSet rset;

	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {
	context=context;//for avoiding PMD violation
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap insertDiscrMeasure(HashMap hashmap)
	{
						java.util.HashMap results = new java.util.HashMap() ;
						try{

						java.util.Properties p =(Properties) hashmap.get("p");
						
						String 	discrmsrid = (String) hashmap.get("discrmsrid");
						String 	longdesc  = (String) hashmap.get("longdesc");
						String 	shortdesc = (String) hashmap.get("shortdesc");
						String 	servicecode = (String) hashmap.get("servicecode");
						String 	resulttype = (String) hashmap.get("resulttype"); 
						int numdigitsmax =((Integer)hashmap.get("numdigitsmax")).intValue();
						int numdigitsmin= ((Integer)hashmap.get("numdigitsmin")).intValue();

						String locale="";
		locale= p.getProperty("LOCALE");
						 int numdigitsdec =((Integer)hashmap.get("numdigitsdec")).intValue();
						String 	refrangetype= (String) hashmap.get("refrangetype");
						String resulttemplateid = (String) hashmap.get("resulttemplateid");    
						String effstatus = (String) hashmap.get("effstatus");  
						double numreflow  =((Double)hashmap.get("numreflow")).doubleValue();
						double numrefhigh= ((Double)hashmap.get("numrefhigh")).doubleValue() ;
						double numcritlow =  ((Double)hashmap.get("numcritlow")).doubleValue(); 
						double numcrithigh   = ((Double)hashmap.get("numcrithigh")).doubleValue();
						double numdfltresult =((Double)hashmap.get("numdfltresult")).doubleValue();
							
						String 	numuom = (String) hashmap.get("numuom");
						String numericdetailsvalues = (String) hashmap.get("numericdetailsvalues");
						String alphainfovalues = (String) hashmap.get("alphainfovalues");
						String addedFacilityId = (String) hashmap.get("addedFacilityId");
						String 	addedAtWorkstation = (String) hashmap.get("addedAtWorkstation");	

		
			boolean result = false ;
			boolean insertable = true ;		
			StringBuffer sb = new StringBuffer("") ;
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String modifiedFacilityId = addedFacilityId ;
			String modifiedAtWorkstation = addedAtWorkstation ;
			ResultSet rs = null;

			java.sql.Timestamp added_date	= new  java.sql.Timestamp(System.currentTimeMillis());
			java.sql.Timestamp modified_date	= new  java.sql.Timestamp(System.currentTimeMillis());

			hashmap.clear();

			try 
			{
				con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);
				final String duplicateSql = "select 1 from  am_discr_msr where DISCR_MSR_ID = ? " ;
				pstmt = con.prepareStatement( duplicateSql ) ;
				pstmt.setString( 1, discrmsrid ) ;
				rs = pstmt.executeQuery() ;

				if ( rs!=null && rs.next() ) 
				{
					insertable = false ;
					java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS,"Common" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}

					if(rs != null) rs.close();
					if(pstmt!=null)pstmt.close();
					
			} catch ( Exception e ) 
			{
				insertable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
			

			if ( insertable ) 
			{
				try 
				{
					String sql = " insert into am_discr_msr "+
					" ( "+
					" DISCR_MSR_ID , "+
					" LONG_DESC ,    "+
					" SHORT_DESC ,   "+
					" SERVICE_CODE , "+
					" RESULT_TYPE ,  "+
					" ACTIVITY_TYPE ,"+
					" NUM_DIGITS_MAX , "+
					" NUM_DIGITS_MIN , "+
					" NUM_DIGITS_DEC , "+
					" REF_RANGE_TYPE , "+
					" RESULT_TEMPLATE_ID ,      "+
					" SECURITY_LEVEL , "+
					" EFF_STATUS ,   "+
					" ADDED_BY_ID ,  "+
					" ADDED_DATE ,   "+
					" ADDED_AT_WS_NO ,"+ 
					" ADDED_FACILITY_ID ,  "+
					" MODIFIED_BY_ID , "+
					" MODIFIED_DATE ,"+
					" MODIFIED_AT_WS_NO , "+ 
					" MODIFIED_FACILITY_ID  "+
					" ) "+
					" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  "; 

					pstmt = con.prepareStatement(sql);
					pstmt.setString( 1,discrmsrid) ;
					pstmt.setString( 2,longdesc) ;
					pstmt.setString( 3,shortdesc) ;
					pstmt.setString( 4,servicecode) ;
					pstmt.setString( 5,resulttype ) ;
					pstmt.setString( 6,"");
					pstmt.setInt(7,numdigitsmax);
					pstmt.setInt(8,numdigitsmin);
					pstmt.setInt(9,numdigitsdec);
					pstmt.setString(10,refrangetype);
					pstmt.setString(11,resulttemplateid);
					pstmt.setString(12,"");
					pstmt.setString(13,effstatus);
					pstmt.setString(14,addedById) ;
					pstmt.setTimestamp(15,added_date) ;
					pstmt.setString(16,addedAtWorkstation) ;
					pstmt.setString(17,addedFacilityId) ;
					pstmt.setString(18,modifiedById) ;
					pstmt.setTimestamp(19,modified_date) ;
					pstmt.setString(20,modifiedAtWorkstation) ;
					pstmt.setString(21,modifiedFacilityId) ;

					int res = pstmt.executeUpdate() ;
					if(pstmt!=null)pstmt.close();

					if ( res != 0 ) 
					result = true ;
					else
					result = false;

					if(result==true && resulttype.equals("L"))
					{
						int refno = 1;
						java.util.StringTokenizer st = new java.util.StringTokenizer(alphainfovalues,"`");

						//	String refrangeseq		= "";
							String refrngdesc			= "";
							String resultvalue		= "";
							String sortorder			= "";
							String dfltyn					= "";
							String numericvalues="";

						while (st.hasMoreTokens())
						{
							String temp = st.nextToken();
							
							if(!temp.equals(""))
							{
								java.util.StringTokenizer st1 = new java.util.StringTokenizer(temp,"~");

								while(st1.hasMoreTokens())
								{
								//	refrangeseq		= st1.nextToken();
									refrngdesc			= st1.nextToken();
									resultvalue		= st1.nextToken();
									numericvalues	 = st1.nextToken();
									sortorder			= st1.nextToken();
									dfltyn					= st1.nextToken();
								}

								sql =" INSERT INTO AM_DISCR_MSR_REF_RNG_LIST "+
								" ( "+
								" DISCR_MSR_ID , "+
								" REF_RANGE_SEQ , "+
								" SORT_ORDER , "+
								" REF_RNG_DESC , "+
								" RESULT_VALUE , "+
								" DFLT_YN , "+
								" ADDED_BY_ID ,  "+
								" ADDED_DATE ,   "+
								" ADDED_AT_WS_NO ,"+
								" ADDED_FACILITY_ID ,  "+
								" MODIFIED_BY_ID , "+
								" MODIFIED_DATE ,"+
								" MODIFIED_AT_WS_NO , "+
								" MODIFIED_FACILITY_ID , "+
								" NUMERIC_VALUE  "+
								" ) "+
								" VALUES "+
								" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";


								pstmt = con.prepareStatement(sql);
								pstmt.setString	( 1,discrmsrid) ;
								pstmt.setInt	( 2,refno) ;
								pstmt.setString	( 3,sortorder) ;
								pstmt.setString	( 4,refrngdesc) ;
								pstmt.setString	( 5,resultvalue) ;
								pstmt.setString	( 6,dfltyn);
								pstmt.setString ( 7,addedById) ;
								pstmt.setTimestamp( 8,added_date) ;
								pstmt.setString	( 9,addedAtWorkstation) ;
								pstmt.setString	( 10,addedFacilityId) ;
								pstmt.setString	( 11,modifiedById) ;
								pstmt.setTimestamp( 12,modified_date) ;
								pstmt.setString	( 13,modifiedAtWorkstation) ;
								pstmt.setString	( 14,modifiedFacilityId) ;
								pstmt.setInt( 15,Integer.parseInt(numericvalues)) ;

								int res1 = pstmt.executeUpdate() ;
								if(pstmt!=null) pstmt.close();    
								if ( res1 == 0 ) result = false;
								refno++;
							}
						}
					}

					if(result==true && resulttype.equals("N"))
					{
						int refno = 1;
						sql =" insert into AM_DISCR_MSR_REF_RNG_NUM "+
						" ( "+
						" DISCR_MSR_ID ,"+
						" REF_RANGE_SEQ ,"+
						" PATIENT_SEX ,"+
						" GESTATON_AGE_YN ,"+
						" START_AGE ,"+
						" START_AGE_UNITS ,"+
						" END_AGE ,"+
						" END_AGE_UNITS ,"+
						" START_AGE_DAYS ,"+
						" END_AGE_DAYS ,"+
						" NUM_REF_LOW ,"+
						" NUM_REF_HIGH ,"+
						" NUM_CRIT_LOW ,"+
						" NUM_CRIT_HIGH ,"+
						" NUM_DFLT_RESULT ,"+
						" NUM_UOM ,"+
						" ADDED_BY_ID ,"+
						" ADDED_DATE ,"+
						" ADDED_AT_WS_NO ,"+
						" ADDED_FACILITY_ID ,"+
						" MODIFIED_BY_ID ,"+
						" MODIFIED_DATE ,"+
						" MODIFIED_AT_WS_NO ,"+
						" MODIFIED_FACILITY_ID "+
						" ) "+
						" values "+
						" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

						if(refrangetype.equals("S"))
						{
							pstmt = con.prepareStatement(sql);
							pstmt.setString	(1,discrmsrid) ;
							pstmt.setInt	(2,refno) ;
							pstmt.setString	( 3,"A") ;
							pstmt.setString	( 4,"N") ;
							pstmt.setInt	( 5,0) ;
							pstmt.setString	( 6,"D");
							pstmt.setInt ( 7,150) ;
							pstmt.setString( 8,"Y") ;
							pstmt.setInt( 9,0) ;
							pstmt.setInt( 10,54750) ;
							pstmt.setDouble( 11,numreflow) ;
							pstmt.setDouble( 12,numrefhigh) ;
							pstmt.setDouble( 13,numcritlow) ;
							pstmt.setDouble( 14,numcrithigh) ;
							pstmt.setDouble( 15,numdfltresult) ;
							pstmt.setString( 16,numuom) ;
							pstmt.setString( 17,addedById) ;
							pstmt.setTimestamp( 18,added_date) ;
							pstmt.setString	( 19,addedAtWorkstation) ;
							pstmt.setString	( 20,addedFacilityId) ;
							pstmt.setString	( 21,modifiedById) ;
							pstmt.setTimestamp( 22,modified_date) ;
							pstmt.setString	( 23,modifiedAtWorkstation) ;
							pstmt.setString	( 24,modifiedFacilityId) ;

							int res2 = pstmt.executeUpdate() ;
							if(pstmt!=null)pstmt.close();
							if ( res2 == 0 ) result = false;
						}
						else
						{
							java.util.StringTokenizer st = new java.util.StringTokenizer(numericdetailsvalues,"`");
							while (st.hasMoreTokens())
							{
								String temp = st.nextToken();
								String sex = "";
								String startage = "";
								String startunits = "";
								String endage = "";
								String endunits = "";
								String seqno = "";
								String reflow = "";
								String refhigh = "";
								String criticallow = "";
								String criticalhigh = "";
								String uom = "";
								String def = "";

								if(!temp.equals(""))
								{
									java.util.StringTokenizer st1 = new java.util.StringTokenizer(temp,"~");
									while(st1.hasMoreTokens())
									{
										sex = st1.nextToken().substring(0,1);               
										startage = st1.nextToken();      
										startunits = st1.nextToken().substring(0,1);    
										endage = st1.nextToken();        
										endunits = st1.nextToken().substring(0,1);      
										seqno = st1.nextToken();          
										reflow = st1.nextToken();          
										refhigh = st1.nextToken();         
										criticallow = st1.nextToken();   
										criticalhigh = st1.nextToken(); 
										uom = st1.nextToken();             
										def = st1.nextToken(); 
										if("".equals(def.trim()))//added for IN070957
											def = null;
										st1.nextToken();
									}

									int startdays = 0;
									int enddays = 0;

									if(startunits.equals("M")) 
										startdays = (Integer.parseInt(startage) *30)+1;
									else if(startunits.equals("Y"))
										startdays = (Integer.parseInt(startage)*365)+1;
									else
										startdays = Integer.parseInt(startage);

									if(endunits.equals("M")) 
										enddays = (Integer.parseInt(endage) *30)-1;
									else if(endunits.equals("Y"))
										enddays = (Integer.parseInt(endage)*365)-1;
									else
										enddays = Integer.parseInt(endage);

									pstmt = con.prepareStatement(sql);
									pstmt.setString	( 1,discrmsrid) ;
									pstmt.setInt	( 2,Integer.parseInt(seqno)) ;
									pstmt.setString	( 3,sex) ;
									pstmt.setString	( 4,"N") ;
									pstmt.setInt	( 5,Integer.parseInt(startage)) ;
									pstmt.setString	( 6,startunits);
									pstmt.setInt ( 7,Integer.parseInt(endage)) ;
									pstmt.setString	( 8,endunits) ;
									pstmt.setInt ( 9,startdays) ;
									pstmt.setInt( 10,enddays) ;
									pstmt.setDouble	( 11,Double.parseDouble(reflow)) ;
									pstmt.setDouble	  ( 12,Double.parseDouble(refhigh)) ;
									pstmt.setDouble	  ( 13,Double.parseDouble(criticallow)) ;
									pstmt.setDouble	  ( 14,Double.parseDouble(criticalhigh)) ;
									//pstmt.setDouble	  ( 15,Double.parseDouble(def)) ;//commented for IN070957
									pstmt.setString	  ( 15,def) ;//added for IN070957
									pstmt.setString	  ( 16,uom) ;
									pstmt.setString ( 17,addedById) ;
									pstmt.setTimestamp( 18,added_date) ;
									pstmt.setString	( 19,addedAtWorkstation) ;
									pstmt.setString	( 20,addedFacilityId) ;
									pstmt.setString	( 21,modifiedById) ;
									pstmt.setTimestamp	( 22,modified_date) ;
									pstmt.setString	( 23,modifiedAtWorkstation) ;
									pstmt.setString	( 24,modifiedFacilityId) ;
									int res2 = pstmt.executeUpdate() ;
									if ( res2 == 0 ) result = false;
									refno++;
								}
							}
						}
					}

				} 
				catch (Exception e)
				{
					result = false;
					try
					{
						con.rollback();
					}
					catch(Exception e1){}
					
					sb.append( e.toString() + " in insert <br>" ) ;
					e.printStackTrace() ;
				}

				try
				{
					if(result)
					{
						con.commit();
						java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}
					else
						con.rollback();
						if(pstmt!=null) pstmt.close();
				}catch(Exception fe){}
				finally	
				{
						if (con != null) ConnectionManager.returnConnection(con,p);
						
				}
			}

			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			}catch(Exception e){
				
				e.printStackTrace();
			}
	
			return results ;
		}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap modifyDiscrMeasure(HashMap hashmap)
	{
				java.util.HashMap results = new java.util.HashMap() ;
						try
						{

						java.util.Properties p =(Properties) hashmap.get("p");
						
						String 	discrmsrid = (String) hashmap.get("discrmsrid");
					
						String 	longdesc  = (String) hashmap.get("longdesc");
						String 	shortdesc = (String) hashmap.get("shortdesc");
						String 	servicecode = (String) hashmap.get("servicecode");
						String 	resulttype = (String) hashmap.get("resulttype"); 
						String locale="";
						locale= p.getProperty("LOCALE");
						int numdigitsmax =((Integer)hashmap.get("numdigitsmax")).intValue();
						int numdigitsmin= ((Integer)hashmap.get("numdigitsmin")).intValue();
					    int numdigitsdec =((Integer)hashmap.get("numdigitsdec")).intValue();
						String 	refrangetype= (String) hashmap.get("refrangetype");
						String resulttemplateid = (String) hashmap.get("resulttemplateid");    
						String effstatus = (String) hashmap.get("effstatus");  
						double numreflow  =((Double)hashmap.get("numreflow")).doubleValue();
						double numrefhigh= ((Double)hashmap.get("numrefhigh")).doubleValue() ;
						
						double numcritlow =  ((Double)hashmap.get("numcritlow")).doubleValue(); 
						double numcrithigh   = ((Double)hashmap.get("numcrithigh")).doubleValue();
						double numdfltresult =((Double)hashmap.get("numdfltresult")).doubleValue();
						String 	numuom = (String) hashmap.get("numuom");
						String numericdetailsvalues = (String) hashmap.get("numericdetailsvalues");
						String alphainfovalues = (String) hashmap.get("alphainfovalues");
						String addedFacilityId =(String)hashmap.get("facilityId");
						String 	addedAtWorkstation = (String)hashmap.get("addedAtWorkstation");						
			
		
			

			boolean result = false ;
			StringBuffer sb = new StringBuffer("") ;
			
			String addedById =p.getProperty("login_user") ;
			String modifiedById =addedById ;
			String modifiedFacilityId =addedFacilityId ;
			String modifiedAtWorkstation =addedAtWorkstation ;
			java.sql.Timestamp added_date	=new  java.sql.Timestamp(System.currentTimeMillis());
			java.sql.Timestamp modified_date	=new  java.sql.Timestamp(System.currentTimeMillis());

			hashmap.clear();

			try 
			{
				con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);

				String sql =" UPDATE AM_DISCR_MSR "+
				" SET LONG_DESC = ?,"+
				" SHORT_DESC = ? ,   "+
				" SERVICE_CODE = ? , "+
				" RESULT_TYPE = ? ,  "+
				" NUM_DIGITS_MAX = ? , "+
				" NUM_DIGITS_MIN = ? , "+
				" NUM_DIGITS_DEC = ? , "+
				" REF_RANGE_TYPE = ? , "+
				" RESULT_TEMPLATE_ID = ? , "+
				" EFF_STATUS = ? ,   "+
				" MODIFIED_BY_ID = ? , "+
				" MODIFIED_DATE = ? ,"+
				" MODIFIED_AT_WS_NO = ?,"+ 
				" MODIFIED_FACILITY_ID =?"+
				" where DISCR_MSR_ID =?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString	( 1,longdesc) ;
				pstmt.setString	( 2,shortdesc) ;
				pstmt.setString	( 3,servicecode) ;
				pstmt.setString	( 4,resulttype) ;
				pstmt.setInt( 5,numdigitsmax);
				pstmt.setInt( 6,numdigitsmin);
				pstmt.setInt( 7,numdigitsdec);
				pstmt.setString( 8,refrangetype);
				pstmt.setString( 9,resulttemplateid);
				pstmt.setString( 10,effstatus);
				pstmt.setString( 11,modifiedById) ;
				pstmt.setTimestamp( 12,modified_date) ;
				pstmt.setString	( 13,modifiedAtWorkstation) ;
				pstmt.setString	( 14,modifiedFacilityId) ;
				pstmt.setString	( 15,discrmsrid) ;

				int res = pstmt.executeUpdate() ;

				if ( res != 0 ) 
					result = true ;
				else
					result = false;

				if(pstmt!=null)pstmt.close();
				if(result==true && resulttype.equals("L"))
				{
					java.util.StringTokenizer st = new java.util.StringTokenizer(alphainfovalues,"`");
					while (st.hasMoreTokens())
					{
						String temp = st.nextToken();
						int refrangeseq		= 0;
						String refrngdesc			= "";
						String resultvalue		= "";
						String sortorder			= "";
						String numericvalues		= "";
						String dfltyn					= "";
						String insertyn				= "N";
						int refno							= 0;
						if(!temp.equals(""))
						{
							java.util.StringTokenizer st1 = new java.util.StringTokenizer(temp,"~");
							while(st1.hasMoreTokens())
							{
								String ref			= st1.nextToken();
		
								if(ref.equals("$")) 
									insertyn = "Y";
								else
								{
									refrangeseq		= Integer.parseInt(ref);
									insertyn				= "N";
								}
								refrngdesc			= st1.nextToken();

								resultvalue		= st1.nextToken();
								numericvalues=st1.nextToken();
								sortorder			= st1.nextToken();
								dfltyn					= st1.nextToken();
							}


							if(insertyn.equals("N"))
							{
								sql =" update AM_DISCR_MSR_REF_RNG_LIST  set "+

								" SORT_ORDER =?,"+
								" REF_RNG_DESC =?,"+
								" RESULT_VALUE =?,"+
								" DFLT_YN = ?,"+
								" NUMERIC_VALUE =?,"+
								" MODIFIED_BY_ID =?,"+
								" MODIFIED_DATE =?,"+
								" MODIFIED_AT_WS_NO =?,"+
								" MODIFIED_FACILITY_ID =?"+
								" where  DISCR_MSR_ID =? and  REF_RANGE_SEQ= ?";

								pstmt = con.prepareStatement(sql);
								pstmt.setString	( 1,sortorder);
								pstmt.setString	( 2,refrngdesc);
								pstmt.setString	( 3,resultvalue);
								pstmt.setString	( 4,dfltyn);
								pstmt.setInt	( 5,Integer.parseInt(numericvalues));
								pstmt.setString	( 6,modifiedById) ;
								pstmt.setTimestamp	( 7,modified_date);
								pstmt.setString	( 8,modifiedAtWorkstation);
								pstmt.setString	( 9,modifiedFacilityId);
								pstmt.setString	( 10,discrmsrid);
								pstmt.setInt	( 11,refrangeseq);

								int res1 = pstmt.executeUpdate() ;
								if(pstmt!=null)pstmt.close(); 
								if ( res1 == 0 ) result = false;
							}
							else
							{
								String sqlrefno = " SELECT NVL((MAX(ref_range_seq)),0)+1 from am_discr_msr_ref_rng_list where Discr_msr_id = ? ";
								pstmt1 = con.prepareStatement( sqlrefno );
								pstmt1.setString	( 1,discrmsrid) ;
								rset = pstmt1.executeQuery() ;
								if(rset.next())
								{
									refno = rset.getInt(1);
								}
								if(pstmt1!=null)pstmt.close();
								if(rset!=null)rset.close();
								sql =" INSERT INTO AM_DISCR_MSR_REF_RNG_LIST "+
								" ( "+
								" DISCR_MSR_ID , "+
								" REF_RANGE_SEQ , "+
								" SORT_ORDER , "+
								" REF_RNG_DESC , "+
								" RESULT_VALUE , "+
								" DFLT_YN , "+
								" ADDED_BY_ID ,  "+
								" ADDED_DATE ,   "+
								" ADDED_AT_WS_NO ,"+
								" ADDED_FACILITY_ID ,  "+
								" MODIFIED_BY_ID , "+
								" MODIFIED_DATE ,"+
								" MODIFIED_AT_WS_NO , "+
								" MODIFIED_FACILITY_ID , "+
								" NUMERIC_VALUE  "+
								" ) "+
								" VALUES "+
								" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

								pstmt = con.prepareStatement(sql);
								pstmt.setString	( 1,discrmsrid) ;
								pstmt.setInt	( 2,refno) ;
								pstmt.setString	( 3,sortorder) ;
								pstmt.setString	( 4,refrngdesc) ;
								pstmt.setString	( 5,resultvalue) ;
								pstmt.setString	( 6,dfltyn);
								pstmt.setString ( 7,addedById) ;
								pstmt.setTimestamp( 8,added_date);
								pstmt.setString	( 9,addedAtWorkstation) ;
								pstmt.setString	( 10,addedFacilityId) ;
								pstmt.setString	( 11,modifiedById) ;
								pstmt.setTimestamp( 12,modified_date) ;
								pstmt.setString	( 13,modifiedAtWorkstation) ;
								pstmt.setString	( 14,modifiedFacilityId) ;
								pstmt.setInt	( 15,Integer.parseInt(numericvalues)) ;

								int res1 = pstmt.executeUpdate() ;
								if(pstmt!=null) pstmt.close();
								if ( res1 == 0 ) result = false;
							}
						}
					}
				}

				if(result==true && resulttype.equals("N"))
				{
					if(refrangetype.equals("S"))
					{
						sql ="  update AM_DISCR_MSR_REF_RNG_NUM set "+
						" PATIENT_SEX = ? ,"+
						" GESTATON_AGE_YN = ? ,"+
						" START_AGE = ? ,"+
						" START_AGE_UNITS = ? ,"+
						" END_AGE = ? ,"+
						" END_AGE_UNITS = ? ,"+
						" START_AGE_DAYS = ? ,"+
						" END_AGE_DAYS = ? ,"+
						" NUM_REF_LOW = ? ,"+
						" NUM_REF_HIGH = ? ,"+
						" NUM_CRIT_LOW = ? ,"+
						" NUM_CRIT_HIGH = ? ,"+
						" NUM_DFLT_RESULT = ? ,"+
						" NUM_UOM = ? ,"+
						" MODIFIED_BY_ID = ? ,"+
						" MODIFIED_DATE = ? ,"+
						" MODIFIED_AT_WS_NO = ? ,"+
						" MODIFIED_FACILITY_ID = ? "+
						" where DISCR_MSR_ID = ?  and REF_RANGE_SEQ = ? ";

						pstmt = con.prepareStatement(sql);
						pstmt.setString( 1,"A") ;
						pstmt.setString( 2,"N") ;
						pstmt.setInt( 3,0) ;
						pstmt.setString( 4,"D");
						pstmt.setInt ( 5,150) ;
						pstmt.setString( 6,"Y") ;
						pstmt.setInt ( 7,0) ;
						pstmt.setInt	  ( 8,54750) ;
						pstmt.setDouble	  ( 9,numreflow) ;
						pstmt.setDouble	  ( 10,numrefhigh) ;
						pstmt.setDouble	  ( 11,numcritlow) ;
						pstmt.setDouble	  ( 12,numcrithigh) ;
						pstmt.setDouble	  ( 13,numdfltresult) ;
						pstmt.setString	  ( 14,numuom) ;
						pstmt.setString	( 15,modifiedById) ;
						pstmt.setTimestamp( 16,modified_date) ;
						pstmt.setString	( 17,modifiedAtWorkstation) ;
						pstmt.setString	( 18,modifiedFacilityId) ;
						pstmt.setString	( 19,discrmsrid) ;
						pstmt.setInt	( 20,1) ;

						int res2 = pstmt.executeUpdate() ;

						if ( res2 == 0 ) result = false;
						if(pstmt!=null) pstmt.close(); 
					}
					else
					{
						sql = " delete from AM_DISCR_MSR_REF_RNG_NUM where DISCR_MSR_ID = ? ";
						pstmt = con.prepareStatement(sql);
						pstmt.setString	( 1,discrmsrid) ;

						pstmt.executeUpdate() ;

						if(pstmt!=null) pstmt.close(); 

						java.util.StringTokenizer st = new java.util.StringTokenizer(numericdetailsvalues,"`");
						while (st.hasMoreTokens())
						{
							String temp = st.nextToken();
							String sex = "";
							String startage = "";
							String startunits = "";
							String endage = "";
							String endunits = "";
							String seqno = "";
							String reflow = "";
							String refhigh = "";
							String criticallow = "";
							String criticalhigh = "";
							String uom = "";
							String def = "";

							if(!temp.equals(""))
							{
								java.util.StringTokenizer st1 = new java.util.StringTokenizer(temp,"~");
								while(st1.hasMoreTokens())
								{
									sex = st1.nextToken().substring(0,1);               
									startage = st1.nextToken();      
									startunits = st1.nextToken().substring(0,1);    
									endage = st1.nextToken();        
									endunits = st1.nextToken().substring(0,1);      
									seqno = st1.nextToken();          
									reflow = st1.nextToken();          
									refhigh = st1.nextToken();         
									criticallow = st1.nextToken();   
									criticalhigh = st1.nextToken(); 
									uom = st1.nextToken();             
									def = st1.nextToken(); 
									if("".equals(def.trim()))//added for IN070957
											def = null;									
									st1.nextToken();
								}

								int startdays = 0;
								int enddays = 0;

								if(startunits.equals("M")) 
								startdays = (Integer.parseInt(startage) *30)+1;
								else if(startunits.equals("Y"))
								startdays = (Integer.parseInt(startage)*365)+1;
								else
								startdays = Integer.parseInt(startage);

								if(endunits.equals("M")) 
								enddays = (Integer.parseInt(endage) *30)-1;
								else if(endunits.equals("Y"))
								enddays = (Integer.parseInt(endage)*365)-1;
								else
								enddays = Integer.parseInt(endage);

								sql =" insert into AM_DISCR_MSR_REF_RNG_NUM "+
								" ( "+
								" DISCR_MSR_ID ,"+
								" REF_RANGE_SEQ ,"+
								" PATIENT_SEX ,"+
								" GESTATON_AGE_YN ,"+
								" START_AGE ,"+
								" START_AGE_UNITS ,"+
								" END_AGE ,"+
								" END_AGE_UNITS ,"+
								" START_AGE_DAYS ,"+
								" END_AGE_DAYS ,"+
								" NUM_REF_LOW ,"+
								" NUM_REF_HIGH ,"+
								" NUM_CRIT_LOW ,"+
								" NUM_CRIT_HIGH ,"+
								" NUM_DFLT_RESULT ,"+
								" NUM_UOM ,"+
								" ADDED_BY_ID ,"+
								" ADDED_DATE ,"+
								" ADDED_AT_WS_NO ,"+
								" ADDED_FACILITY_ID ,"+
								" MODIFIED_BY_ID ,"+
								" MODIFIED_DATE ,"+
								" MODIFIED_AT_WS_NO ,"+
								" MODIFIED_FACILITY_ID "+
								" ) "+
								" values "+
								" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

								pstmt = con.prepareStatement(sql);
								pstmt.setString	( 1,discrmsrid) ;
								pstmt.setInt	( 2,Integer.parseInt(seqno)) ;
								pstmt.setString	( 3,sex) ;
								pstmt.setString	( 4,"N") ;
								pstmt.setInt	( 5,Integer.parseInt(startage)) ;
								pstmt.setString	( 6,startunits);
								pstmt.setInt ( 7,Integer.parseInt(endage)) ;
								pstmt.setString( 8,endunits) ;
								pstmt.setInt ( 9,startdays) ;
								pstmt.setInt( 10,enddays) ;
								pstmt.setDouble( 11,Double.parseDouble(reflow)) ;
								pstmt.setDouble( 12,Double.parseDouble(refhigh)) ;
								pstmt.setDouble( 13,Double.parseDouble(criticallow)) ;
								pstmt.setDouble( 14,Double.parseDouble(criticalhigh)) ;
								//pstmt.setDouble( 15,Double.parseDouble(def)) ;//commented for IN070957
								pstmt.setString( 15,def) ;//added for IN070957
								pstmt.setString(16,uom) ;
								pstmt.setString( 17,addedById) ;
								pstmt.setTimestamp	  ( 18,added_date) ;
								pstmt.setString	( 19,addedAtWorkstation) ;
								pstmt.setString	( 20,addedFacilityId) ;
								pstmt.setString	( 21,modifiedById) ;
								pstmt.setTimestamp( 22,modified_date);
								pstmt.setString	( 23,modifiedAtWorkstation) ;
								pstmt.setString	( 24,modifiedFacilityId) ;

								int res3 = pstmt.executeUpdate() ;

								if ( res3 == 0 ) result = false;
							}if(pstmt!=null) pstmt.close();
						}
					}
				}
			} catch (Exception e)
			{
				try
				{
					con.rollback();
				}catch(Exception e1){result = false;}
				
				result = false;
				sb.append( e.toString() + " in modify <br>" ) ;
				e.printStackTrace() ;
			}

			try
			{
				if(result)
				{
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
					sb.append( (String) message.get("message") ) ;
                     message.clear();
				}
				else
					con.rollback();
					if(rset!=null) rset.close();
					
					if(pstmt1!=null) pstmt1.close();
					
			}
			catch(Exception fe){}
			finally	
			{
			
					if (con != null) ConnectionManager.returnConnection(con,p);
				
			
			}

			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return results ;
		}
}
