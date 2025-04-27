   
package eFM.FMHoliday;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.StringTokenizer;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
/**
*
* @ejb.bean
*	name="FMHoliday"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMHoliday"
*	local-jndi-name="FMHoliday"
*	impl-class-name="eFM.FMHoliday.FMHolidayManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMHoliday.FMHolidayManagerLocal"
*	remote-class="eFM.FMHoliday.FMHolidayManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMHoliday.FMHolidayManagerLocalHome"
*	remote-class="eFM.FMHoliday.FMHolidayManagerHome"
*	generate= "local,remote"
*
*
*/
public class FMHolidayManager implements SessionBean {
	
	
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap insertFMHoliday(java.util.Properties p,java.util.HashMap passObjects){
      
    java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false,insertable = false  ;
	StringBuffer sb = new StringBuffer( "" ) ;	
	Connection con =null;
	PreparedStatement pmtst =null;
	
	CallableStatement cstmt = null;
	
	int totalCount=0;
	String holidayQuery="";
	
	String fmholiday_date="";
	String fs_loc_code="";
	String fsLocation="";	
	
	try{
	
	 String facilityId=(String) passObjects.get("facilityId");
	 String addedAtWorkstation=(String) passObjects.get("client_ip_address");          
     String addedById = p.getProperty( "login_user" ) ;                  
	 String locale = p.getProperty("LOCALE");	       
	
	
	Integer totCount=(Integer)passObjects.get("totalHolidayCount");
	totalCount=totCount.intValue();
	
	//String fmholiday_date[]=new String[totalCount];
	
	
	
	con = ConnectionManager.getConnection(p);
	con.setAutoCommit(false);
	holidayQuery="insert into fm_holiday(facility_id,fs_locn_code,holiday_date,reason_for_holiday,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values(?,?,to_date(?,'dd/mm/yyyy'),?,?,sysdate,?,?,?,sysdate,?,?)";
	pmtst=con.prepareStatement(holidayQuery);
	for(int k=0; k<totalCount; k++){
	   String tokenStr=(String)passObjects.get("selected_"+k); 
	   StringTokenizer token=new StringTokenizer(tokenStr,"|"); 
	   while(token.hasMoreTokens()){
	            fsLocation=token.nextToken();
				String holidayReasion=token.nextToken();
				String holidayDate=token.nextToken();  
                				
								
				pmtst.setString(1,facilityId);
				pmtst.setString(2,fsLocation);
				pmtst.setString(3,holidayDate);
				pmtst.setString(4,holidayReasion);
				pmtst.setString(5,addedById);
				pmtst.setString(6,addedAtWorkstation);
				pmtst.setString(7,facilityId);
				pmtst.setString(8,addedById);
				pmtst.setString(9,addedAtWorkstation);
				pmtst.setString(10,facilityId);			
				pmtst.addBatch(); 
								
     				
	   
	   }
	}         
            	int[] resultsholday=pmtst.executeBatch(); 
				con.commit();				
 
                 
				
                               				
			    String errmsg="";          	
				if(totalCount == resultsholday.length&&resultsholday.length>0){	
                 				
			    
				cstmt = con.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				cstmt.setString(1, fsLocation);
				cstmt.setString(2, facilityId);
				cstmt.setString(3, "FM_HOLIDAY");
				cstmt.setString(4, "");	
                cstmt.setString(5, "");	
                cstmt.setString(6, "");	
                cstmt.setString(7, "");	 				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.execute();					
				errmsg=cstmt.getString(8);
             
                
				 
                 }	

				 
				if(totalCount == resultsholday.length&&resultsholday.length>0)insertable=true;	
			 
			 
             if ( insertable ){
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}else
			{  
				con.rollback();
				
			}				
			   
				
		
  }catch(Exception ex){	
		sb.append( "Transaction failed " + ex ) ;
		ex.printStackTrace();
	 }finally{         
		try{
          		
		 if(pmtst!=null) pmtst.close(); 
		 if(cstmt != null)cstmt.close();
		 
       }catch(Exception pstmt){
	   pstmt.printStackTrace();
	   }		 
	if(con!=null) ConnectionManager.returnConnection(con,p);
	}
	
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	passObjects.clear();
    
	 
	return results;
	
} 


/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap updateFMHoliday(java.util.Properties p,
						java.util.HashMap passObjects
						) 
			{
			
			Connection con =null;
	        PreparedStatement pstmt =null;
			
			String	holidaydate=(String) passObjects.get("holidaydate");
			String reasonforholiday=(String) passObjects.get("reasonforholiday");
			String facilityId=(String) passObjects.get("facilityId");
			String	addedAtWorkstation=(String) passObjects.get("client_ip_address");
			String	holiday_fs_locn_code=(String) passObjects.get("holiday_fs_locn_code"); 

			String locale = p.getProperty("LOCALE");
			
			java.util.HashMap results = new java.util.HashMap() ;
			boolean result = false ;
			boolean updatable = true ;
			StringBuffer sb = new StringBuffer( "" ) ;
			String sql = "update fm_holiday set reason_for_holiday=?, modified_by_id=?, modified_date= sysdate, modified_at_ws_no= ?, MODIFIED_FACILITY_ID =? where holiday_date= to_date('"+holidaydate+"','dd/mm/yyyy') and facility_id = ?  and fs_locn_code=?";
			String modifiedById = p.getProperty( "login_user" ) ;
			
			String modifiedAtWorkstation = addedAtWorkstation ;
		
			try {
				con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);
				if ( updatable ) {
					pstmt = con.prepareStatement( sql );
					pstmt.setString ( 1, reasonforholiday ) ;
					pstmt.setString	( 2, modifiedById ) ;
					pstmt.setString	( 3, modifiedAtWorkstation ) ;
					pstmt.setString ( 4, facilityId);					
					pstmt.setString ( 5, facilityId);					
					pstmt.setString ( 6, holiday_fs_locn_code);
					int res = pstmt.executeUpdate() ;  
					
					if ( res != 0 ) {
						result = true ;
						java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
						sb.append( (String) message.get("message") ) ;
						con.commit();
						message.clear();
					}
					//pstmt.close() ;
				}
				
				if(pstmt!= null) pstmt.close() ;
				

			}catch ( Exception e ) {
				e.printStackTrace();
				try {
					con.rollback() ;
				} catch (Exception ce ) {

					ce.printStackTrace();
				}
				sb.append( e.getMessage() + "<br>" ) ;
			}finally{
			   	if(con!=null) ConnectionManager.returnConnection(con,p);
			 }
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
		passObjects.clear();
		return results ;
	}
	/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap deleteFMHoliday(java.util.Properties p, java.util.HashMap passObjects) {
	
	        Connection con =null;
	        PreparedStatement pstmt =null;
			CallableStatement cstmt = null;
			
			String	holidaydate=(String) passObjects.get("holidaydate");
			String reasonforholiday=(String) passObjects.get("reasonforholiday");
			String facilityId=(String) passObjects.get("facilityId");
			String	addedAtWorkstation=(String) passObjects.get("client_ip_address");
			String	holiday_fs_locn_code=(String) passObjects.get("holiday_fs_locn_code"); 
			
			String errmsg="";

			String locale = p.getProperty("LOCALE");
			
			java.util.HashMap results = new java.util.HashMap() ;
			boolean result = false ;
			boolean deldatable = true ;
			StringBuffer sb = new StringBuffer( "" ) ;
			String sql = "delete from fm_holiday  where holiday_date= to_date('"+holidaydate+"','dd/mm/yyyy') and facility_id = ?  and fs_locn_code=?";
			//String sql = "update fm_holiday set holiday_check_yn='D' where holiday_date= to_date('"+holidaydate+"','dd/mm/yyyy') and facility_id = ?  and fs_locn_code=?";
			String modifiedById = p.getProperty( "login_user" ) ;
			
			
			String modifiedAtWorkstation = addedAtWorkstation ;
		
			try {
				con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);
				if (deldatable) {
					pstmt = con.prepareStatement( sql );										
					pstmt.setString ( 1, facilityId);					
					pstmt.setString ( 2, holiday_fs_locn_code);
					int res = pstmt.executeUpdate() ;  
				    con.commit();
				
				if ( res != 0 )	{
				
				cstmt = con.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				cstmt.setString(1, holiday_fs_locn_code);
				cstmt.setString(2, facilityId);
				cstmt.setString(3, "FM_HOLIDAY");
				cstmt.setString(4, "");
                cstmt.setString(5, "");
                cstmt.setString(6, "");
                cstmt.setString(7, ""); 				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.execute();					
				errmsg=cstmt.getString(8); 
				 
								 
				 
				 }
				
					
					
					
					if ( res != 0 ) {
						result = true ;
						java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
						sb.append( (String) message.get("message") ) ;
						con.commit();
						message.clear();
					}
					//pstmt.close() ;
				}
				
				if(pstmt!= null) pstmt.close() ;
				if(cstmt!= null) cstmt.close() ;//Added for checkstyle
				

			}catch ( Exception e ) {
				e.printStackTrace();
				try {
					con.rollback() ;
				} catch (Exception ce ) {

					ce.printStackTrace();
				}
				sb.append( e.getMessage() + "<br>" ) ;
			}finally{
			   	if(con!=null) ConnectionManager.returnConnection(con,p);
			 }
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
		passObjects.clear();
		return results ;

} 


/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap deleteMultipleFMHolidays(java.util.Properties p,java.util.HashMap passObjects){
    
	String facilityId=(String) passObjects.get("facilityId"); 
	java.util.ArrayList selectedHolidays=(java.util.ArrayList) passObjects.get("selectedHolidays");
		
    int Listsize=selectedHolidays.size();
    	  
    java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false,insertable = false  ;
	StringBuffer sb = new StringBuffer( "" ) ;	
	Connection con =null;
	PreparedStatement pmtst =null;
	
	int totalCount=0;
	String deleteholidayQuery="";
	String multipleDeleteStr="";
	
	//String fmholiday_date="";
	String fs_loc_code="";
	CallableStatement cstmt = null;
		
	try{
	
	// String facilityId=(String) passObjects.get("facilityId");
	 String addedAtWorkstation=(String) passObjects.get("client_ip_address");
     String addedById = p.getProperty( "login_user" ) ;
	 String locale = p.getProperty("LOCALE");	 
	
	
	//Integer totCount=(Integer)passObjects.get("totalHolidayCount");
	//totalCount=totCount.intValue();
	
	
	
	con = ConnectionManager.getConnection(p);
	con.setAutoCommit(false);
	deleteholidayQuery="delete from fm_holiday where facility_id=? and fs_locn_code=? and holiday_date=to_date(?,'dd/mm/yyyy')";
	//deleteholidayQuery="update fm_holiday set holiday_check_yn='D' where facility_id=? and fs_locn_code=? and holiday_date=to_date(?,'dd/mm/yyyy')";
	pmtst=con.prepareStatement(deleteholidayQuery);
	
	String errmsg="";
	HashSet	selectedHolidaylocn = new HashSet();   
	for(int k=0; k<Listsize; k++){ 
	   multipleDeleteStr=(String)selectedHolidays.get(k);  
	   StringTokenizer multipleDeleteToken=new StringTokenizer(multipleDeleteStr,"|");  
	   while(multipleDeleteToken.hasMoreTokens()){ 
	            String multipledollerToken=multipleDeleteToken.nextToken();	   
	            StringTokenizer splitDollerToken=new StringTokenizer(multipledollerToken,"$");	              		
	            String fsLocation=splitDollerToken.nextToken();				
				String holidayDate=splitDollerToken.nextToken(); 
				
				
            
              //  fs_loc_code	=fsLocation;		
				
				pmtst.setString(1,facilityId);
				pmtst.setString(2,fsLocation);
				pmtst.setString(3,holidayDate);	
				//int res = pmtst.executeUpdate() ;
				//totalCount+=res;  

                pmtst.addBatch(); 				
				
				//Added 
			   			
				selectedHolidaylocn.add(fsLocation);
	   }
	} 
	int totalDeleteCount[]=pmtst.executeBatch();
	con.commit(); 
	
	
		  
	
    
	Iterator itr = selectedHolidaylocn.iterator();
	 while(itr.hasNext()){
	 fs_loc_code=(String) itr.next();
	                              
	 
	            cstmt = con.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				cstmt.setString(1, fs_loc_code);
				cstmt.setString(2, facilityId);
				cstmt.setString(3, "FM_HOLIDAY");
				cstmt.setString(4, "");
                cstmt.setString(5, "");
                cstmt.setString(6, "");
                cstmt.setString(7, "");  				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.execute();					
				errmsg=cstmt.getString(8); 
                				
                if(cstmt!= null) cstmt.close() ;//Added for checkstyle	
	 
             
        }
		
			
				//End				
				
             if (totalDeleteCount.length>0){	
                con.commit();			 
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
				sb.append( (String) message.get("message") ) ;				
				message.clear();
			}else
			{  
				con.rollback();
				
			}				
			   
				
		
  }catch(Exception ex){	
		
		ex.printStackTrace();
		try {
			con.rollback() ;
		} catch (Exception cexp ) {

					cexp.printStackTrace();
		 }
		sb.append( ex.getMessage() + "<br>" ) ;
		
	 }finally{         
		try{	
		 if(pmtst!=null) pmtst.close(); 
		 
       }catch(Exception pstmt){
	   pstmt.printStackTrace();
	   }		 
	if(con!=null) ConnectionManager.returnConnection(con,p);
	}
	
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	passObjects.clear();
   
	 
	return results;
	
} 
}
