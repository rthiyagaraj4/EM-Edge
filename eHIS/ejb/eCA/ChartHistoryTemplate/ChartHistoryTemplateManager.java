/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.ChartHistoryTemplate;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="ChartHistoryTemplate"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ChartHistoryTemplate"
*	local-jndi-name="ChartHistoryTemplate"
*	impl-class-name="eCA.ChartHistoryTemplate.ChartHistoryTemplateManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.ChartHistoryTemplate.ChartHistoryTemplateLocal"
*	remote-class="eCA.ChartHistoryTemplate.ChartHistoryTemplateRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.ChartHistoryTemplate.ChartHistoryTemplateLocalHome"
*	remote-class="eCA.ChartHistoryTemplate.ChartHistoryTemplateHome"
*	generate= "local,remote"
*
*
*/

public class ChartHistoryTemplateManager implements SessionBean
{
	    public void ejbCreate() {}
		public void ejbRemove() {}
	    public void ejbActivate() {}
		public void ejbPassivate() {}
	    
		public void setSessionContext(SessionContext sessioncontext) 
		{
			   sessioncontext = sessioncontext;
	    }

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

		public HashMap manageChartHistory(Properties properties, ArrayList htRecord_atl, HashMap user_id_info,String updateflag)
		{
    	    Connection con		= null;
			PreparedStatement stmt = null;
			PreparedStatement pslPrepStmt,pstmt;
			PreparedStatement validate_pstmt = null;
			pslPrepStmt = null;
			pstmt = null;
			ResultSet validate_rs = null;

			HashMap hashtable1		= new HashMap();
			HashMap hashtable4		= null;

			Hashtable hashtable2	= new Hashtable();
				
			boolean bCommitFlag = true;
									
			try 
			{
	            con = ConnectionManager.getConnection(properties);

				String addedById			= (String)user_id_info.get("addedById")==null?"":(String)user_id_info.get("addedById");
				String operatingfacilityid  = (String)user_id_info.get("facility_id");
				String  added_at_ws_no		= (String)user_id_info.get("client_ip_address");
				String rows					= (String)user_id_info.get("rows");
				String cols					= (String)user_id_info.get("cols");
				String summaryid            = (String)user_id_info.get("summaryid")==null?"":(String)user_id_info.get("summaryid");
				String summarydesc			= (String)user_id_info.get("summarydesc")==null?"":(String)user_id_info.get("summarydesc");
				String enadis               = (String) user_id_info.get("enadis")==null?"":(String) user_id_info.get("enadis");
				String locale				= (String) user_id_info.get("locale");

				int row_int					= (Integer.parseInt(rows));
				int col_int					= (Integer.parseInt(cols));
				
				try 
				{
					StringBuffer sblQry		=  new StringBuffer();
					StringBuffer sblQry_sec =  new StringBuffer();

					int counter = 0;
						
					String validate_sql = "select 1 from  CA_CHART_SUMM_HEADER where SUMMARY_ID=?";
					
					validate_pstmt = con.prepareStatement(validate_sql);
						
					validate_pstmt.setString(1,summaryid);
					validate_rs = validate_pstmt.executeQuery();

					if(validate_rs.next())
						counter++;
						
					if(validate_rs!=null)
						validate_rs.close();
					
					if(validate_pstmt!=null)
						validate_pstmt.close();

					if(counter == 0)
					{
						sblQry_sec.append("INSERT INTO CA_CHART_SUMM_HEADER ");
						sblQry_sec.append("(SUMMARY_ID,NO_OF_ROWS, NO_OF_COLS,SUMMARY_DESC,ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO,EFF_STATUS)");
						sblQry_sec.append("VALUES ");
						sblQry_sec.append("(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");
						pstmt = con.prepareStatement(sblQry_sec.toString());
						pstmt.setString(1,summaryid);
						pstmt.setInt(2,row_int);
						pstmt.setInt(3,col_int);
						pstmt.setString(4,summarydesc);
						pstmt.setString(5,addedById);
						pstmt.setString(6,operatingfacilityid);
						pstmt.setString(7,added_at_ws_no);				
						pstmt.setString(8,addedById);
						pstmt.setString(9,operatingfacilityid);
						pstmt.setString(10,added_at_ws_no);
						pstmt.setString(11,enadis);

						int count = pstmt.executeUpdate();

						if(count > 0)
						{
							sblQry.append("INSERT INTO CA_CHART_SUMM_DETAIL(SUMMARY_ID,COL_POS, ROW_POS,COL_SPAN, ROW_SPAN,CONTENT_ID,ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO,MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO)  VALUES (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");

							pslPrepStmt = con.prepareStatement(sblQry.toString());
							hashtable4 = new HashMap();

							int row_pos_return, cols_pos_h_return, row_span_h_return, col_span_h_return, prev_cont_id_sec;
							
							for (int i=0;i<htRecord_atl.size();i++)
							{
								hashtable4			= (java.util.HashMap) htRecord_atl.get(i);
								row_pos_return		= ((Integer)hashtable4.get("prev_cols_pos_h")).intValue();
								cols_pos_h_return   = ((Integer)hashtable4.get("prev_row_pos_h")).intValue();  
								row_span_h_return	= ((Integer)hashtable4.get("prev_col_span_h")).intValue();
								col_span_h_return	= ((Integer)hashtable4.get("prev_row_span_h")).intValue();
								prev_cont_id_sec    = ((Integer)hashtable4.get("prev_cont_id_sec")).intValue();

								pslPrepStmt.setString(1,summaryid);
								pslPrepStmt.setInt(2,row_pos_return);
								pslPrepStmt.setInt(3,cols_pos_h_return);
								pslPrepStmt.setInt(4,row_span_h_return);
								pslPrepStmt.setInt(5,col_span_h_return);
								pslPrepStmt.setInt(6,prev_cont_id_sec);
								pslPrepStmt.setString(7,addedById);
								pslPrepStmt.setString(8,operatingfacilityid);
								pslPrepStmt.setString(9,added_at_ws_no);				
								pslPrepStmt.setString(10,addedById);
								pslPrepStmt.setString(11,operatingfacilityid);
								pslPrepStmt.setString(12,added_at_ws_no);
								pslPrepStmt.addBatch();
							}

							int [] nInsCount = pslPrepStmt.executeBatch();

							if(nInsCount.length == -3 || nInsCount.length < htRecord_atl.size())
								bCommitFlag = false;
						}
						else
							bCommitFlag = false;
						
						if(pstmt!=null) pstmt.close();
						if(pslPrepStmt !=null) pslPrepStmt.close();
					}
					else
					{ 
						String sql="delete from CA_CHART_SUMM_DETAIL where summary_id=?";
						stmt = con.prepareStatement(sql);
						stmt.setString(1,summaryid);
						stmt.executeUpdate();

						if (stmt!=null) stmt.close();

						sblQry_sec.append("update CA_CHART_SUMM_HEADER set NO_OF_ROWS =? ,SUMMARY_DESC = ?, NO_OF_COLS = ? , MODIFIED_BY_ID = ?,MODIFIED_DATE = sysdate ,MODIFIED_AT_WS_NO =?, EFF_STATUS = ? where SUMMARY_ID = ?");
								
						pstmt = con.prepareStatement(sblQry_sec.toString());
						pstmt.setInt(1,row_int);
						pstmt.setString(2,summarydesc);
						pstmt.setInt(3,col_int);
						pstmt.setString(4,addedById);
						pstmt.setString(5,added_at_ws_no);
						pstmt.setString(6,enadis);
						pstmt.setString(7,summaryid);
					
						pstmt.executeUpdate();

						pslPrepStmt=null;
						sblQry.append("INSERT INTO CA_CHART_SUMM_DETAIL ");
						sblQry.append("(SUMMARY_ID,COL_POS, ROW_POS,COL_SPAN, ");
						sblQry.append("ROW_SPAN,CONTENT_ID,ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO,MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) ");
						sblQry.append("VALUES ");
						sblQry.append("(?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
						pslPrepStmt = con.prepareStatement(sblQry.toString());
				
						int row_pos_return, cols_pos_h_return, row_span_h_return, col_span_h_return, prev_cont_id_sec;

						for (int i=0;i<htRecord_atl.size();i++)
						{
							hashtable4 = new HashMap();
							hashtable4 =(java.util.HashMap) htRecord_atl.get(i);

							row_pos_return		    = ((Integer)hashtable4.get("prev_cols_pos_h")).intValue();
							cols_pos_h_return		= ((Integer)hashtable4.get("prev_row_pos_h")).intValue();  
							row_span_h_return		= ((Integer)hashtable4.get("prev_col_span_h")).intValue();
							col_span_h_return		= ((Integer)hashtable4.get("prev_row_span_h")).intValue();
							prev_cont_id_sec		= ((Integer)hashtable4.get("prev_cont_id_sec")).intValue();

							pslPrepStmt.setString(1,summaryid);
							pslPrepStmt.setInt(2,row_pos_return);
							pslPrepStmt.setInt(3,cols_pos_h_return);
							pslPrepStmt.setInt(4,row_span_h_return);
							pslPrepStmt.setInt(5,col_span_h_return);
							pslPrepStmt.setInt(6,prev_cont_id_sec);
							pslPrepStmt.setString(7,addedById);
							pslPrepStmt.setString(8,operatingfacilityid);
							pslPrepStmt.setString(9,added_at_ws_no);				
							pslPrepStmt.setString(10,addedById);
							pslPrepStmt.setString(11,operatingfacilityid);
							pslPrepStmt.setString(12,added_at_ws_no);
							
							pslPrepStmt.addBatch();
						}
						
						int [] nUpdCount = pslPrepStmt.executeBatch();
						
						if(nUpdCount.length == -3 || nUpdCount.length < htRecord_atl.size())
							bCommitFlag = false;							
					}
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
					hashtable1.put("message", "Transaction failed 6 : "+e);
				}
				
				if(bCommitFlag) 
				{
					con.commit();
					hashtable2 = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
					hashtable1.put("message", (String)hashtable2.get("message"));
				}
				else
					con.rollback();

				if (pstmt!=null) pstmt.close();
				if(pslPrepStmt != null) pslPrepStmt.close();
		}
		catch(Exception exception2)
		{
			hashtable1.put("message", exception2);
			exception2.printStackTrace() ;
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con, properties);
		}	
		
		hashtable1.put("status", new Boolean(bCommitFlag));
	    return hashtable1;
	}
} 
