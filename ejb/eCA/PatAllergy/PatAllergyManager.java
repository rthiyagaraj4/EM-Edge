/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.PatAllergy;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="PatAllergyManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PatAllergyManager"
*	local-jndi-name="PatAllergyManager"
*	impl-class-name="eCA.PatAllergy.PatAllergyManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.PatAllergy.PatAllergyManagerLocal"
*	remote-class="eCA.PatAllergy.PatAllergyManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.PatAllergy.PatAllergyManagerLocalHome"
*	remote-class="eCA.PatAllergy.PatAllergyManagerHome"
*	generate= "local,remote"
*
*
*/

public class PatAllergyManager implements SessionBean 
{
    Connection			con ;
    PreparedStatement	pstmt ;
    Statement			stmt ;

    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

    public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
    public final String RECORD_INSERTED		= "RECORD_INSERTED" ;
    public final String RECORD_MODIFIED		= "RECORD_MODIFIED" ;

    public void ejbCreate() {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}

	public void setSessionContext( SessionContext context ) 
	{
		context=context;
	}
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertPatAllergy(
                            java.util.Properties p,
                            String    patientid,
                            String    allergytypecode,
                            String    allergyclass,
                            String    allergicitem,
                            String    generic_id,
                            String    onsetdate ,
							String    remarks,
                            String    practid,
                            String    facilityid ,
                            String    locncode,
                            String    locntype ,
                            String    temp_encounterid ,
                            String    addedAtWorkstation,
                            String    addedFacilityId,
							String	  drug_code,
							String	  allergytypecode2,
							String	  allergytypecode3
                         ) 
        {

		String encounterid=temp_encounterid;

		java.util.HashMap results = new java.util.HashMap() ;

        boolean result			=	false,			insertable	=	true ;
       
		int       srlno=0;

        String allergicitem1=allergicitem.toUpperCase();

        StringBuffer sb		= new StringBuffer( "" ) ;
		StringBuffer sql	= new StringBuffer();

		String addedById				= p.getProperty( "login_user" ) ;
		String locale = (String) p.getProperty("LOCALE");
        String addedDate				= dateFormat.format( new java.util.Date() ) ;
        String modifiedById				= addedById ;
        String modifiedDate				= addedDate ;
        String modifiedFacilityId		= addedFacilityId ;
        String modifiedAtWorkstation	= addedAtWorkstation ;

        java.sql.Date added_date		= java.sql.Date.valueOf( addedDate ) ;
        java.sql.Date modified_date		= java.sql.Date.valueOf( modifiedDate ) ;

		ResultSet	rs	=	null,		rset	=	null;

		try
		{
			try
            {
                con = ConnectionManager.getConnection(p);

                String duplicateSql = "select count(*) as total from pr_allergy  where patient_id = ? " ;
                
				pstmt = con.prepareStatement( duplicateSql ) ;
                pstmt.setString( 1, patientid ) ;

                rs = pstmt.executeQuery() ;
                rs.next();

				int rs1=rs.getInt("total");

				if(rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
                
				if(rs1 >=1)
                {	
					String duplicatesql2 ="";
                    
					if (allergyclass.equals("D"))
					  duplicatesql2 = " select '1' from pr_allergy  where  patient_id = ?  and generic_id =? and close_date is null " ;
					else 
					  duplicatesql2 = " select '1' from pr_allergy  where  patient_id = ?  and upper(allergic_item) =? and allergy_class=?  and  close_date is null " ;

					pstmt = con.prepareStatement( duplicatesql2 ) ;
					
					if (allergyclass.equals("D"))
					{
						pstmt.setString( 1, patientid ) ;
						pstmt.setString( 2, generic_id ) ;		 
					}
					else
					{
						 pstmt.setString( 1, patientid ) ;
						 pstmt.setString( 2, allergicitem1 ) ;
						 pstmt.setString( 3, allergyclass ) ;
					}

                    rset = pstmt.executeQuery() ;

                    if ( rset.next()  )
                    {
                        insertable = false ;
						String mssg=getMessage(locale, "CODE_ALREADY_EXISTS","Common");
						sb.append( mssg ) ;
                    }
		
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
				}
            }
            catch ( Exception e )
            {
                insertable = false ;
                sb.append( "first catch"+e+ "<br>" ) ;
                e.printStackTrace() ;
			}

			if ( insertable ) 
			{
				try 
				{
					String Sql = "select to_number (nvl(max(srl_no),0)+1) num from pr_allergy where patient_id = ? " ;
					
					pstmt = con.prepareStatement( Sql ) ;
					pstmt.setString( 1, patientid) ;

					rs = pstmt.executeQuery() ;
					rs.next();
					
					srlno = rs.getInt("num");
					
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
				catch(Exception e)
				{
					 insertable = false ;
					 sb.append( "second catch"+e + "<br>" ) ;
					 e.printStackTrace() ;
				}
			}

			if ( insertable )
			{
				try
				{
					if(sql.length() > 0) 
						sql.delete(0,sql.length());

					sql.append(" insert into  pr_allergy( "   );
					sql.append( " PATIENT_ID,   SRL_NO , ALLERGY_TYPE_CODE,"); 
					sql.append( " ALLERGY_CLASS,ALLERGIC_ITEM,generic_id, ONSET_DATE, remarks, " );  
					sql.append(" ONSET_PRACTITIONER_ID, ONSET_FACILITY_ID, " );
					sql.append( " ONSET_LOCN_CODE, ONSET_LOCN_TYPE, "); 
					sql.append( " ONSET_ENCOUNTER_ID, ONSET_RECORDED_DATE, " );
					sql.append(" added_by_id,      added_date, "      );
					sql.append(" added_facility_id, added_at_ws_no, " );
					sql.append(  " modified_by_id,    modified_date, " );
					sql.append(" modified_facility_id, modified_at_ws_no, drug_code,ALLERGY_TYPE_CODE2,ALLERGY_TYPE_CODE3	 " );
					sql.append( " ) values ( ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'),?, ?, ?,?,?,?,? ,?, ?, ?, ?, ?,?,?,?,?,?,? )") ;

					pstmt = con.prepareStatement( sql.toString() );
					
					pstmt.setString ( 1,	patientid ) ;
					pstmt.setInt    ( 2,	srlno) ;
					pstmt.setString ( 3,	allergytypecode ) ;
					pstmt.setString ( 4,	allergyclass ) ;
					pstmt.setString ( 5,	allergicitem ) ;
					pstmt.setString ( 6,	generic_id ) ;
					pstmt.setString ( 7,	onsetdate ) ;
					pstmt.setString	( 8,	remarks);
					pstmt.setString ( 9,	practid ) ;
					pstmt.setString ( 10,	facilityid ) ;
					pstmt.setString ( 11,	locncode ) ;
					pstmt.setString ( 12,	locntype ) ;
					pstmt.setString ( 13,	encounterid ) ;
					pstmt.setDate   ( 14,	added_date ) ;
					pstmt.setString ( 15,	addedById);
					pstmt.setDate   ( 16,	added_date ) ;
					pstmt.setString ( 17,	addedFacilityId ) ;
					pstmt.setString ( 18,	addedAtWorkstation ) ;
					pstmt.setString ( 19,	modifiedById ) ;
					pstmt.setDate   ( 20,	modified_date ) ;
					pstmt.setString ( 21,	modifiedFacilityId ) ;
					pstmt.setString ( 22,	modifiedAtWorkstation ) ;
					pstmt.setString ( 23,	drug_code ) ;
					pstmt.setString ( 24,	allergytypecode2 ) ;
					pstmt.setString ( 25,	allergytypecode3 ) ;

					int res = pstmt.executeUpdate() ;

					if ( res >= 0 )
					{
						result = true ;
						String mssg1= getMessage(locale, "RECORD_INSERTED","CA");
						sb.append(mssg1 ) ;
						con.commit();
					}

	                if(pstmt!=null) pstmt.close();
            }
            catch ( Exception e )
			{
                sb.append( "Insert"+e.getMessage() + srlno+"<br> " ) ;
                e.printStackTrace() ;
                
				try 
				{ 
					con.rollback(); 
				} 
				catch (Exception ee) {ee.printStackTrace();}
            }
            finally 
			{
				if(con!=null) ConnectionManager.returnConnection(con,p);
				
			}
        }
		}
		catch(Exception ee)
		{
			ee.printStackTrace() ;
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
    }

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap updatePatAllergy(
                                    java.util.Properties p,
                                    String    patientid,
                                    String    temp_srlno,
                                    //String    allergyclass,
                                    String    allergicitem,
                                    //String    generic_id,
                                    //String    onsetdate ,
									String    remarks,
                                    String    closedate ,
                                    String    practid,
                                    String    facilityid ,
                                    String    locncode,
                                    String    locntype ,
                                    String     temp_encounterid ,
                                    String    addedAtWorkstation,
                                    String    addedFacilityId,
									//String	  drug_code,
									String	errorRemarks
                                    )
    {
		
		
		int srlno=Integer.parseInt(temp_srlno);
		//long encounterid=Long.parseLong(temp_encounterid);
		String encounterid=temp_encounterid;
        java.util.HashMap results = new java.util.HashMap() ;
        boolean result = false ;
        boolean updatable = true ;
        StringBuffer sb = new StringBuffer( "" ) ;
        StringBuffer sql = new StringBuffer();
		con = ConnectionManager.getConnection(p);

        String modifiedById = p.getProperty( "login_user" ) ;
		String locale = (String) p.getProperty("LOCALE");
        String modifiedDate = dateFormat.format( new java.util.Date() ) ;
        java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
        String modifiedFacilityId = addedFacilityId ;
        String modifiedAtWorkstation = addedAtWorkstation ;
		//ResultSet rs = null;
       // java.sql.Date onset_date = java.sql.Date.valueOf(onsetdate);
        //java.sql.Date close_date = java.sql.Date.valueOf(closedate);
		

String ERROR_MARKED_BY_ID   ="";  
//java.sql.Date  ERROR_MARKED_DATE      =null;
String ERROR_REMARKS          ="";
String ERROR_YN               ="N";
       /* try
        {
             

                stmt=con.createStatement();
                rs=stmt.executeQuery("select to_char(sysdate,'yyyy-mm-dd') d from dual ");
                rs.next();
                java.sql.Date sys_date = rs.getDate("d");

				if(!errorRemarks.equals("")){
							 ERROR_MARKED_BY_ID   =practid;  
							 ERROR_MARKED_DATE      =sys_date;
							 ERROR_REMARKS          =errorRemarks;
							 ERROR_YN               ="Y";
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
            }
            catch(Exception e)
            {
                    updatable = false ;
                    sb.append("ab"+ e + "<br>" ) ;
                    e.printStackTrace() ;
            }*/

			if(!errorRemarks.equals(""))
			{
				 ERROR_MARKED_BY_ID   =practid;  
				 ERROR_REMARKS        =errorRemarks;
				 ERROR_YN             ="Y";
			}

        if ( updatable ) {
            try 
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
                sql.append( " update pr_allergy set remarks=?,");
				sql.append(  " close_date = to_date(?,'dd/mm/yyyy'), close_practitioner_id = ?, ");
                sql.append( " close_facility_id = ?, close_locn_code = ?, ");
                sql.append( " close_locn_type = ?, close_encounter_id = ?,");
				
                sql.append( "close_recorded_date = ?, " );
                sql.append( " modified_by_id    = ?,  ");
                sql.append( " modified_date     = ?,  " );
                sql.append( " modified_facility_id  = ?, "); 
				sql.append( " modified_at_ws_no = ?, "  );
                sql.append( " ERROR_MARKED_BY_ID = ?, " );
				if(!errorRemarks.equals(""))
				{
		            sql.append(  " ERROR_MARKED_DATE = SYSDATE, " );
				}
                sql.append( " ERROR_REMARKS = ?, " );
	            sql.append(" ERROR_YN = ? "  );
				sql.append( " where PATIENT_ID  = ?  and srl_no=?  and allergic_item=? " );

                pstmt = con.prepareStatement( sql.toString() );
				pstmt.setString   ( 1, remarks);
                pstmt.setString   ( 2, closedate) ;
                pstmt.setString    (3, practid) ;
                pstmt.setString    (4, facilityid) ;
                pstmt.setString    ( 5, locncode) ;
                pstmt.setString    ( 6, locntype) ;
                pstmt.setString    ( 7, encounterid) ;
                pstmt.setDate    ( 8, modified_date) ;
                pstmt.setString    ( 9, modifiedById) ;
                pstmt.setDate   ( 10,  modified_date) ;
                pstmt.setString ( 11, modifiedFacilityId ) ;
                pstmt.setString ( 12, modifiedAtWorkstation ) ;
			   pstmt.setString ( 13, ERROR_MARKED_BY_ID ) ;
			//   pstmt.setDate   ( 14, ERROR_MARKED_DATE );
               pstmt.setString    ( 14, ERROR_REMARKS) ;
               pstmt.setString   ( 15, ERROR_YN );

				pstmt.setString   ( 16, patientid );
                pstmt.setInt    ( 17, srlno) ;
                pstmt.setString   ( 18, allergicitem );

			
                int res = pstmt.executeUpdate() ;
                //sb.append( "result = " + res ) ;

                if ( res != 0 ) {
                    result = true ;
					String msg2=getMessage(locale, "RECORD_INSERTED","CA");
                   // java.util.Hashtable message = MessageManager.getMessage(con, RECORD_MODIFIED ) ;
                    sb.append(msg2) ;
					//message.clear();
                    con.commit();
                    //sb.append( "Record Modified" ) ;
                }

               if(pstmt!=null) pstmt.close();
            } 
			catch ( Exception e )
			{
                sb.append( "ab"+e.getMessage() + "<br>" ) ;
                e.printStackTrace() ;
                try { con.rollback(); } catch (Exception ee) {}
            }
            finally 
			{
				if(con!=null) ConnectionManager.returnConnection(con,p);
				
			}
        } // end if updatable

       
		results.put( "status", new Boolean(result) ) ;
        results.put( "error", sb.toString() ) ;

        return results ;
    }
} // end session bean
