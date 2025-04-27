/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMFileTypeforFSLocn;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="FMFileTypeforFSLocn"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMFileTypeforFSLocn"
*	local-jndi-name="FMFileTypeforFSLocn"
*	impl-class-name="eFM.FMFileTypeforFSLocn.FMFileTypeforFSLocnManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMFileTypeforFSLocn.FMFileTypeforFSLocnManagerLocal"
*	remote-class="eFM.FMFileTypeforFSLocn.FMFileTypeforFSLocnManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMFileTypeforFSLocn.FMFileTypeforFSLocnManagerLocalHome"
*	remote-class="eFM.FMFileTypeforFSLocn.FMFileTypeforFSLocnManagerHome"
*	generate= "local,remote"
*
*
*/



public class FMFileTypeforFSLocnManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt1 ;
	Statement stmt ;
	
	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}

	/* Get the details from the HashMap and insert into the table
	   FM_FILE_TYPE_FOR_FSL.
	*/
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap SpecialityAddModify(Properties properties, HashMap hashmap) 
	{
        HashMap hashmap1 = new HashMap();
        String s	= (String)hashmap.get("modified_by_id");
        //String s1	= (String)hashmap.get("modified_facility_id");
        String s2	= (String)hashmap.get("modified_at_ws_no");
        String locale	= (String)hashmap.get("locale");

        Integer integer = (Integer)hashmap.get("totCount");
        int i			= integer.intValue();
		Integer integer1 = (Integer)hashmap.get("dflt_index");
        int dflt_index			= integer1.intValue();
       
		StringBuffer sb = new StringBuffer();
        String s3		= "";
     
		String s4		= (String)hashmap.get("facilityId");
		s3				= (String)hashmap.get("fs_locn_code"); 
			
		String sql		= "";
		  
        boolean flag1 = true;
        try
        {
            con = ConnectionManager.getConnection(properties);
            con.setAutoCommit(false);
             String s5 = "";
			
			s5 = s5 + "update  FM_FILE_TYPE_FOR_FSL set eff_status ='D' where facility_id='" + s4 + "' and fs_locn_code='" + s3 + "' ";
			stmt = con.createStatement();
            stmt.executeUpdate(s5);
			
			String s7 = "update FM_FILE_TYPE_FOR_FSL set eff_status =?,DEFAULT_YN=? where facility_id = ? and fs_locn_code = ? and FILE_TYPE_CODE = ? ";
            pstmt1 = con.prepareStatement(s7);

			sql = "Insert into FM_FILE_TYPE_FOR_FSL (FACILITY_ID,FILE_TYPE_CODE,FS_LOCN_CODE, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EFF_STATUS,DEFAULT_YN) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

            for(int k = 0; k < i; k++)
            {
                String s6 = (String)hashmap.get("chk" + k);

		/////////////////////////////////////////////////////
			    
		 		pstmt1.setString(1,"E");
		 		if(dflt_index==k)
				{
                pstmt1.setString(2,"Y");
					}else{
                  pstmt1.setString(2,"N");
					}
				pstmt1.setString(3,s4);
		 		pstmt1.setString(4,s3);
		 		pstmt1.setString(5,s6);
		        int l = pstmt1.executeUpdate();
     		/////////////////////////////////////////////////////

                if(l == 0)
                {

		/////////////////////////////////////////////////////

					pstmt.setString(1, s4);
                    pstmt.setString(2, s6);
                    pstmt.setString(3, s3);
                    pstmt.setString(4, s);
                    pstmt.setString(5, s2);
                    pstmt.setString(6, s4);
                    pstmt.setString(7, s);
                    pstmt.setString(8, s2);
                    pstmt.setString(9, s4);
          			pstmt.setString(10, "E");
                   if(dflt_index==k)
				   {
                  pstmt.setString(11,"Y");
					   }else{
                  pstmt.setString(11,"N");
					   }
                    int i1 = pstmt.executeUpdate();
					/////////////////////////////////////////////////////

					if(i1 > 0) flag1 = true;
                    else flag1 = false;
                } 
                flag1 = true;
            }
			hashmap.clear();

            if(flag1) con.commit();
            else con.rollback();

            Hashtable hashtable2 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
            sb.append((String)hashtable2.get("message"));

			hashtable2.clear();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(pstmt1 != null) pstmt1.close();
		}
        catch(Exception exception)
        {
            sb.append("Error in main try " + exception.getMessage());
        }
        finally
        {
           if(con != null) ConnectionManager.returnConnection(con, properties);
        }
        hashmap1.put("status", new Boolean(flag1));
        hashmap1.put("error", sb.toString());
        return hashmap1;
    }
} // end session bean
