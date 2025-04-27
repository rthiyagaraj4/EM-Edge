/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.ClinicEventParam;

import java.sql.*;
import java.util.*;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="ClinicEventParamManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ClinicEventParamManager"
*	local-jndi-name="ClinicEventParamManager"
*	impl-class-name="eCA.ClinicEventParam.ClinicEventParamManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.ClinicEventParam.ClinicEventParamLocal"
*	remote-class="eCA.ClinicEventParam.ClinicEventParamRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.ClinicEventParam.ClinicEventParamLocalHome"
*	remote-class="eCA.ClinicEventParam.ClinicEventParamHome"
*	generate= "local,remote"
*
*
*/

public class ClinicEventParamManager implements SessionBean
{
	public void ejbCreate()
	{
	}
	public void ejbRemove() 
	{
	}
	public void ejbActivate() 
	{
	}
	public void ejbPassivate()
	{
	}
	public void setSessionContext(SessionContext sessioncontext)
	{
		sessioncontext = sessioncontext;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	private int insertUpdate(Connection con, String strOrdPhysYn, String strAtnPhysYn, String strModifiedId, String strModifiedFacilityId, String strModifiedClientId, String strHistRecType)
	{
		PreparedStatement pslPrepStmt = null;
		StringBuffer sblQry				=  new StringBuffer();
		
		int	update_count				=	0;
		
		try
		{
			sblQry = new StringBuffer();

			sblQry.append("UPDATE cr_clin_event_mast ");
			sblQry.append("SET create_review_ord_phys_yn = ? " );
			sblQry.append(" , create_review_atn_phys_yn = ?");
			sblQry.append(" , modified_by_id =?");
			sblQry.append(" , modified_facility_id =?");
			sblQry.append(" , modified_at_ws_no =?");
			sblQry.append(" , modified_date = sysdate ");
			sblQry.append(" WHERE  hist_rec_type = ? ");

			pslPrepStmt = con.prepareStatement(sblQry.toString());
			
			pslPrepStmt.setString(1, strOrdPhysYn);
			pslPrepStmt.setString(2, strAtnPhysYn);
			pslPrepStmt.setString(3, strModifiedId);
			pslPrepStmt.setString(4, strModifiedFacilityId);
			pslPrepStmt.setString(5, strModifiedClientId);
			pslPrepStmt.setString(6, strHistRecType);
			
			update_count = pslPrepStmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pslPrepStmt!=null) pslPrepStmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		return update_count;
	}
    
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap manageClinicEventParam(Properties properties, HashMap hashtable)
    {
       	Connection con					= null;
		PreparedStatement pslPrepStmt	= null;

		StringBuffer sblQry				=  new StringBuffer();
	   
		boolean	commit_flag	=	true;
		
		String high_value 				=  		"";
		String low_value 				= 		"";
		String abnml_value 				= 		"";
		String crtcl_value 				= 		"";
		String crtcl_low_value 			= 		"";
		String crtcl_high_value		 	= 		"";
        
	    String high_value_desc		 	= 		"";
		String high_value_color		 	= 		"";
		String low_value_desc		 	= 		"";
		String low_value_color		 	= 		"";
		String abnml_value_desc		 	= 		"";
	    String abnml_value_color		= 		"";
		String crtcl_value_desc		 	= 		"";
		String crtcl_value_color		= 		"";
		String crtcl_low_value_desc		= 		"";
	    String crtcl_low_value_color	= 		"";
		String crtcl_high_value_desc    = 		"";
		String crtcl_high_value_color	= 		"";

		String high_value_symbol		= 		"";
		String low_value_symbol			= 		"";
		String abnormal_value_symbol	= 		"";
		String critical_value_symbol	= 		"";
		String crtcl_high_value_symbol	= 		"";
		String crtcl_low_value_symbol	= 		"";
		String legend_value				= 		"";






		
		String module_id				= 		"";
		String sqlQuery					=		"";
		String mode						=		"";
		String default_value			=		"";
		
		String ord_phys_yn_value		=	"",					atn_phys_yn_value		= "";
		String modifiedId				=	"",					modifiedFacilityId		= "";
		String modifiedClientId			=	"",					hist_rec_type			= "";

		String locale					=		"";
		String error					=		"";

		Integer totalChecked			= 		new Integer(1);

		int	ilCheckedCount				=	0,					insert_count			= 0;
		int update_count				=	0;
		
		HashMap hashTable				= new HashMap();
        
		try
		{
        
            modifiedId			= (String)hashtable.get("modified_by_id");
            modifiedFacilityId	= (String)hashtable.get("modified_facility_id");
            modifiedClientId	= (String)hashtable.get("modified_at_ws_no");
	        
			try
			{
				con					= ConnectionManager.getConnection(properties);

               	high_value			=  	(String)	hashtable.get("high_value");
				low_value			= 	(String)	hashtable.get("low_value");
				abnml_value			= 	(String)	hashtable.get("abnml_value");
				crtcl_value			= 	(String)	hashtable.get("crtcl_value");
				crtcl_low_value		= 	(String)	hashtable.get("crtcl_low_value");
				crtcl_high_value	= 	(String)	hashtable.get("crtcl_high_value");

                high_value_desc		=  	(String)	hashtable.get("high_value_desc");
				high_value_color	= 	(String)	hashtable.get("high_value_color");
				low_value_desc		=  	(String)	hashtable.get("low_value_desc");
				low_value_color	    = 	(String)	hashtable.get("low_value_color");
			   abnml_value_desc		=  	(String)	hashtable.get("abnml_value_desc");
			   abnml_value_color    = 	(String)	hashtable.get("abnml_value_color");
				crtcl_value_desc	=  	(String)	hashtable.get("crtcl_value_desc");
				crtcl_value_color   = 	(String)	hashtable.get("crtcl_value_color");
			crtcl_low_value_desc	=  	(String)	hashtable.get("crtcl_low_value_desc");
			crtcl_low_value_color	= 	(String)	hashtable.get("crtcl_low_value_color");
            crtcl_high_value_desc	=  	(String)	hashtable.get("crtcl_high_value_desc");
			crtcl_high_value_color	= 	(String)	hashtable.get("crtcl_high_value_color");

				default_value		= 	(String)	hashtable.get("delta_value");
				module_id			= 	(String)	hashtable.get("module_id");
				mode				= 	(String)	hashtable.get("mode");
				locale				=   (String)	hashtable.get("locale");
				totalChecked		= 	(Integer)	hashtable.get("ilCheckedCount");
				ilCheckedCount		=	totalChecked.intValue();


				high_value_symbol	=	(String)	hashtable.get("highvalue_symbol");
				low_value_symbol	=	(String)	hashtable.get("lowvalue_symbol");
			abnormal_value_symbol	=	(String)	hashtable.get("abnormalvalue_symbol");
			critical_value_symbol	=	(String)	hashtable.get("criticalvalue_symbol");
			crtcl_high_value_symbol	=	(String)	hashtable.get("criticalhigh_symbol");
			crtcl_low_value_symbol	=	(String)	hashtable.get("criticallow_symbol");
					legend_value	=	(String)	hashtable.get("symbol_colour");

				try
				{
					update_count = 0;

					if(mode.equals("insert"))
					{
						sblQry = new StringBuffer();
						
						sqlQuery = ("INSERT INTO cr_clin_event_param (module_id,  high_str, low_str,abn_str,crit_str, crit_high_str, crit_low_str,high_str_desc,high_color_code,low_str_desc,low_color_code,abn_str_desc,abn_color_code,crit_str_desc,crit_color_code,crit_high_str_desc,crit_high_color_code,crit_low_str_desc,crit_low_color_code,added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,modified_at_ws_no,modified_facility_id,DELTA_FAIL_STR,HIGH_SYMBOL_ICON,LOW_SYMBOL_ICON,ABN_SYMBOL_ICON,CRIT_SYMBOL_ICON,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_SYMBOL_ICON,LEGEND_TYPE ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?)");
						

						pslPrepStmt = con.prepareStatement(sqlQuery);

						pslPrepStmt.setString(1, module_id);
						pslPrepStmt.setString(2, high_value);
						pslPrepStmt.setString(3, low_value);
						pslPrepStmt.setString(4, abnml_value);
						pslPrepStmt.setString(5, crtcl_value);
						pslPrepStmt.setString(6, crtcl_high_value);
						pslPrepStmt.setString(7, crtcl_low_value);
                    pslPrepStmt.setString(8, high_value_desc);
					pslPrepStmt.setString(9, high_value_color);
					pslPrepStmt.setString(10, low_value_desc);
                    pslPrepStmt.setString(11, low_value_color);
		            pslPrepStmt.setString(12, abnml_value_desc);
		            pslPrepStmt.setString(13, abnml_value_color);
		            pslPrepStmt.setString(14, crtcl_value_desc);
		            pslPrepStmt.setString(15, crtcl_value_color);
					pslPrepStmt.setString(16, crtcl_high_value_desc);
		            pslPrepStmt.setString(17, crtcl_high_value_color);
		            pslPrepStmt.setString(18, crtcl_low_value_desc);
                    pslPrepStmt.setString(19, crtcl_low_value_color);
					pslPrepStmt.setString(20, modifiedId);
					pslPrepStmt.setString(21, modifiedClientId);
					pslPrepStmt.setString(22, modifiedFacilityId);
					pslPrepStmt.setString(23, modifiedId);
					pslPrepStmt.setString(24, modifiedClientId);
					pslPrepStmt.setString(25, modifiedFacilityId);
					pslPrepStmt.setString(26, default_value);

					pslPrepStmt.setString(27, high_value_symbol);
					pslPrepStmt.setString(28, low_value_symbol);
					pslPrepStmt.setString(29, abnormal_value_symbol);
					pslPrepStmt.setString(30, critical_value_symbol);
					pslPrepStmt.setString(31, crtcl_high_value_symbol);
					pslPrepStmt.setString(32, crtcl_low_value_symbol);
					pslPrepStmt.setString(33, legend_value);
						
						insert_count = pslPrepStmt.executeUpdate();

						if(pslPrepStmt != null) pslPrepStmt.close();
					}
					else
					{
						sqlQuery = "update cr_clin_event_param set DELTA_FAIL_STR = ?,added_by_id = ?, added_date = sysdate, added_at_ws_no = ?, added_facility_id = ?, modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? ,high_str_desc = ? , high_color_code = ? , low_str_desc = ?,low_color_code = ?,abn_str_desc = ?,abn_color_code = ?,crit_str_desc = ?,crit_color_code = ?,crit_high_str_desc = ?,crit_high_color_code = ?,crit_low_str_desc = ?,crit_low_color_code = ?, high_str = ?, low_str = ?, abn_str = ?, crit_str = ?,crit_high_str = ?, crit_low_str = ?, HIGH_SYMBOL_ICON=?, LOW_SYMBOL_ICON =?,ABN_SYMBOL_ICON=?,CRIT_SYMBOL_ICON=?,CRIT_HIGH_SYMBOL_ICON=?,CRIT_LOW_SYMBOL_ICON=?,LEGEND_TYPE=? where module_id = ?" ;


						pslPrepStmt = con.prepareStatement(sqlQuery);

						pslPrepStmt.setString(1, default_value);
						pslPrepStmt.setString(2, modifiedId);
						pslPrepStmt.setString(3, modifiedClientId);
						pslPrepStmt.setString(4, modifiedFacilityId);
						pslPrepStmt.setString(5, modifiedId);
						pslPrepStmt.setString(6, modifiedClientId);
						pslPrepStmt.setString(7, modifiedFacilityId);

                    pslPrepStmt.setString(8, high_value_desc);
					pslPrepStmt.setString(9, high_value_color);
					pslPrepStmt.setString(10, low_value_desc);
                    pslPrepStmt.setString(11, low_value_color);
                    pslPrepStmt.setString(12, abnml_value_desc);
		            pslPrepStmt.setString(13, abnml_value_color);
		            pslPrepStmt.setString(14, crtcl_value_desc);
		            pslPrepStmt.setString(15, crtcl_value_color);
					pslPrepStmt.setString(16, crtcl_high_value_desc);
		            pslPrepStmt.setString(17, crtcl_high_value_color);
		            pslPrepStmt.setString(18, crtcl_low_value_desc);
                    pslPrepStmt.setString(19, crtcl_low_value_color);

					
					pslPrepStmt.setString(20, high_value);
					pslPrepStmt.setString(21, low_value);
					pslPrepStmt.setString(22, abnml_value);
					pslPrepStmt.setString(23, crtcl_value);
					pslPrepStmt.setString(24, crtcl_high_value);
					pslPrepStmt.setString(25, crtcl_low_value);

					pslPrepStmt.setString(26, high_value_symbol);
					pslPrepStmt.setString(27, low_value_symbol);
					pslPrepStmt.setString(28, abnormal_value_symbol);
					pslPrepStmt.setString(29, critical_value_symbol);
					pslPrepStmt.setString(30, crtcl_high_value_symbol);
					pslPrepStmt.setString(31, crtcl_low_value_symbol);
					pslPrepStmt.setString(32, legend_value);
					pslPrepStmt.setString(33, module_id);
						
						update_count = pslPrepStmt.executeUpdate();
						
						if(pslPrepStmt != null) pslPrepStmt.close();
					}
					
					sblQry = new StringBuffer();
					
					if(insert_count > 0 || update_count > 0)
					{
						sblQry.append("UPDATE cr_hist_rec_type ");
						sblQry.append("SET create_review_ord_phys_yn = ?, create_review_atn_phys_yn = ?");

						pslPrepStmt = con.prepareStatement(sblQry.toString());
					
						pslPrepStmt.setString(1,"N");
						pslPrepStmt.setString(2,"N");
					
						update_count = pslPrepStmt.executeUpdate();

						if(pslPrepStmt != null) pslPrepStmt.close();
					
						update_count = 0;

						for(int i=0; i<ilCheckedCount; i++)
						{
							if(hashtable.containsKey("Ord_phys_yn"+i) || hashtable.containsKey("Atn_phys_yn"+i))
							{
								sblQry = new StringBuffer();
								sblQry.append("UPDATE cr_hist_rec_type ");
								sblQry.append(" SET create_review_ord_phys_yn = ?, create_review_atn_phys_yn = ? ");
								sblQry.append(" , modified_by_id =?");
								sblQry.append(" , modified_facility_id =?");
								sblQry.append(" , modified_at_ws_no =?");
								sblQry.append(" , modified_date = sysdate ");
								sblQry.append(" WHERE hist_rec_type = ? ");
							}
							
							ord_phys_yn_value 	= 	hashtable.containsKey("Ord_phys_yn"+i)?"Y":"N";
							atn_phys_yn_value 	= 	hashtable.containsKey("Atn_phys_yn"+i)?"Y":"N";
							hist_rec_type 		= 	(String)hashtable.get("hist_rec_type"+i);

							pslPrepStmt			=	con.prepareStatement(sblQry.toString());

							pslPrepStmt.setString(1, ord_phys_yn_value);
							pslPrepStmt.setString(2, atn_phys_yn_value);
							pslPrepStmt.setString(3, modifiedId);
							pslPrepStmt.setString(4, modifiedFacilityId);
							pslPrepStmt.setString(5, modifiedClientId);
							pslPrepStmt.setString(6, hist_rec_type);

							update_count = pslPrepStmt.executeUpdate();

							if(update_count == 0)
							{
								insert_count = insertUpdate(con,ord_phys_yn_value,atn_phys_yn_value,modifiedId,modifiedFacilityId,modifiedClientId,hist_rec_type);
							
								if(insert_count < 1) 
								{
									commit_flag	=false;
									break;
								}
							}

							if(pslPrepStmt != null) pslPrepStmt.close();

						}
					}
				}
				catch(Exception e)
				{
					hashTable.put("Exception in manageClinicEventParam Function", "Transaction failed: "+e);
				}
				finally
				{
					try
					{
						if(pslPrepStmt!=null) pslPrepStmt.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				if(commit_flag)
				{
                    error = getMessage(locale,"RECORD_INSERTED","CA");
                    hashTable.put("error", error);
                    con.commit();
                }
				else
				{
                    error = getMessage(locale,"FAILED_TRANSACTION","CA");
	                hashTable.put("error", error);
                    con.rollback();
                }
            }catch(Exception exception2) 
			{
                hashTable.put("er2", exception2);
            } 
			finally 
			{
               
                if(con != null)
                    ConnectionManager.returnConnection(con, properties);
            }
        } catch(Exception exception) {
            hashTable.put("er3", exception);
        }
		finally
		{
			hashtable.clear();
		}
        hashTable.put("status", new Boolean(commit_flag));
        return hashTable;
    }

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
}
