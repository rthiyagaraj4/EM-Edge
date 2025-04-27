/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.SectionForNoteType;

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
*	name="SectionForNoteType"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SectionForNoteType"
*	local-jndi-name="SectionForNoteType"
*	impl-class-name="eCA.SectionForNoteType.SectionForNoteTypeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.SectionForNoteType.SectionForNoteTypeLocal"
*	remote-class="eCA.SectionForNoteType.SectionForNoteTypeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.SectionForNoteType.SectionForNoteTypeLocalHome"
*	remote-class="eCA.SectionForNoteType.SectionForNoteTypeHome"
*	generate= "local,remote"
*
*
*/

public class SectionForNoteTypeManager implements SessionBean
{
	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext context) {this.ctx=context;}
	
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

	public java.util.HashMap insertSecForNoteType(java.util.Properties p, java.util.HashMap valMap)
	{
		Connection			con		= null;
		PreparedStatement	pstmt	= null;

		String sec_hdg_code			= "";
		String note_seq_num			= "";
		String chief_comp			= "";

		String locale				= (String) valMap.get("locale");
		String note_type			= (String) valMap.get("note_type");
		String num_of_rows			= (String) valMap.get("countOfRows");
		String facility_id			= (String) valMap.get("facility_id");
		String client_ip_address	= (String) valMap.get("client_ip_address");
		String added_by_id			= (String) p.getProperty("login_user");
		int iNoofSections	= Integer.parseInt(num_of_rows);
		int j				= 0;

		StringBuffer sb = new StringBuffer();
		
		boolean bCommitFlag = true;

		java.util.HashMap results = new java.util.HashMap();

		String sql_note_type = "delete from ca_note_section where note_type = ?";

		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql_note_type);

			pstmt.setString(1,note_type);
			
			pstmt.executeUpdate();
			
			if(pstmt != null) 
				pstmt.close();

			sql_note_type = "INSERT INTO ca_note_section ( note_type , sec_hdg_code, note_sec_seq_num,BUILD_INTO_REF_LETTER_YN,added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,CHIEF_COMPLAINT_SEC_YN) VALUES (?,?,?,'N',?,sysdate ,?,?,?,SYSDATE,?,?,?)";

			if(iNoofSections > 0)
			{
				pstmt = con.prepareStatement(sql_note_type);

				for(j = 0;j < iNoofSections;j++)
				{
					sec_hdg_code	= (String)valMap.get("sec_hdg_code"+j);
					
					note_seq_num	= (String)valMap.get("note_seq_num"+j);
					chief_comp		= (String)valMap.get("chief_comp"+j);
					

					pstmt.setString(1,note_type);
					pstmt.setString(2,sec_hdg_code);
					pstmt.setString(3,note_seq_num);
					pstmt.setString(4,added_by_id);
					pstmt.setString(5,client_ip_address);
					pstmt.setString(6,facility_id);
					pstmt.setString(7,added_by_id);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,chief_comp);
					pstmt.addBatch();
				}				
				
				int [] nUpdCount = pstmt.executeBatch();
			

				if(pstmt != null) 
					pstmt.close();

				if(nUpdCount.length == -3 || nUpdCount.length < iNoofSections)
					bCommitFlag = false;

				if(bCommitFlag)
				{
					con.commit();
					sb.append( getMessage(locale, "RECORD_INSERTED","CA") ) ;
				}
				else
				{
					con.rollback();
					sb.append( getMessage(locale, "TRANSACTION_FAILED","CA") ) ;
				}
			}
		}
		catch(Exception e)
		{			
			bCommitFlag = false;
			sb.append("Exception in try of SectionForNoteTypeManager.java "+e.toString());			
			e.printStackTrace();
		}
		finally
		{
			 if(con != null) ConnectionManager.returnConnection(con,p);
		}
		
		results.put("status",new Boolean(bCommitFlag));
		results.put("error",sb.toString());
		return results;
	}
}
