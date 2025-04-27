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
Date       Edit History      	Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            	?           created
18/01/2013		IN037372		Ramesh G	Oracle 11g Weblogic compilation.
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
04/07/2016	IN059630		Krishna	Gowtham								   		GHL-CRF-0401	
31/03/2017	IN061907		Krishna Gowtham J	26/02/2017		Ramesh G		ML-MMOH-CRF-0559		
--------------------------------------------------------------------------------------------------------------------
*/
package eCA.SectionTemplate;

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
*	name="SectionTemplate"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SectionTemplate"
*	local-jndi-name="SectionTemplate"
*	impl-class-name="eCA.SectionTemplate.SectionTemplateManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.SectionTemplate.SectionTemplateLocal"
*	remote-class="eCA.SectionTemplate.SectionTemplateRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.SectionTemplate.SectionTemplateLocalHome"
*	remote-class="eCA.SectionTemplate.SectionTemplateHome"
*	generate= "local,remote"
*
*
*/

public class SectionTemplateManager implements SessionBean 
{
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext sessionContext) 
	{
		sessionContext=sessionContext;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertSectionTemplate(java.util.Properties	jdbc_props, java.util.HashMap htSectionTemplate)	
	{
		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;
		ResultSet			rs1		=	null;
		
		PreparedStatement pstmt_clb = null;
		ResultSet rs_clb = null;
		
		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;
		String		section						=	"",	component					=	"";
		String		item_type					=	"",	title_text					=	"";
		String		row_position				=	"",	column_position			=	"";
		String		column_span				=	"",	disp_position				=	"";
		String		login_user_id				=	"",	srl_no							=	""; 
		String		prev_row_pos_no			=	"",	prev_column_pos_no		=	"";
		String		prev_no_of_col_span	=	"",	client_ip_address			=	"";
		String		component_type			=	"",	formula_definition			=	"";
		String		age_group_code			=	"",	hist_rec_type				=	"";
		String		acceptOption				=	"",	added_facility_id			=	"";
		String		presentationSelect		=	"",	selectionSelect			=	"";
		String		prefixRequired				=	"",	hintMessage				=	"";
		String		formulaResultType		=	"";
		String		includeDates				=	"",		formulaResultUnits		=	"";
        String      includeyn = "" ,component_prompt ="";  
		String      old_hist_time_frame_unit = "", old_hist_time_frame_val = "";
		String      event_code = "",event_code_type="", dflt_from_hist_appl_yn="";
		String		locale ="" ;
		String 		comp_disp_next_yn=""; /*IN059630_GHL-CRF-0401*/
		String		auto_result_yn="";//IN061907

		boolean	result							=	false;
		boolean	commit_flag					=	true;
		
		int     unique_chk1					=	0,		unique_chk2					=	0;
		int		insert_chk						=	0;
		int		total_col_span					=	0;
		
		//oracle.sql.CLOB    formula_def_clob = null; //Web logic Conversion -- [IN037372] Start.
		java.sql.Clob    formula_def_clob = null;
		//java.io.Writer     definition_content_writer = null;
		java.io.BufferedWriter	bf_definition_content_writer		=	null;

		try
		{
			added_facility_id			=	(String) htSectionTemplate.get ("added_facility_id" ) ;
			section						=	(String) htSectionTemplate.get ("section");
			item_type					=	(String) htSectionTemplate.get ("item_type");
			title_text					=	(String) htSectionTemplate.get ("title_text_code");
			login_user_id				=	(String) htSectionTemplate.get ("login_user_id");
			component					=	(String) htSectionTemplate.get ("component");
			row_position				=	(String) htSectionTemplate.get ("row_position");     
			column_position			=	(String) htSectionTemplate.get ("column_position");     
			column_span				=	(String) htSectionTemplate.get ("column_span");
			disp_position				=	(String) htSectionTemplate.get ("disp_position");			
			prev_row_pos_no			=	(String) htSectionTemplate.get ("prev_row_pos_no");
			prev_column_pos_no		=	(String) htSectionTemplate.get ("prev_column_pos_no");
			prev_no_of_col_span	=	(String) htSectionTemplate.get ("prev_no_of_col_span");
			client_ip_address			=	(String) htSectionTemplate.get ("client_ip_address");
			component_type			=	(String) htSectionTemplate.get ("component_type");
			formula_definition			=	(String) htSectionTemplate.get ("formula_definition");
			age_group_code			=	(String) htSectionTemplate.get ("age_group_code");
			hist_rec_type				=	(String) htSectionTemplate.get ("hist_rec_type");
			acceptOption				=	(String) htSectionTemplate.get ("acceptOption");
			presentationSelect		=	(String) htSectionTemplate.get ("presentationSelect");
			selectionSelect			=	(String) htSectionTemplate.get ("selectionSelect");
			prefixRequired				=	(String) htSectionTemplate.get ("prefixRequired");
			hintMessage				=	(String) htSectionTemplate.get ("hintMessage");
			formulaResultType		=	(String) htSectionTemplate.get ("formulaResultType");
			includeDates				=	(String) htSectionTemplate.get ("includeDates");
			formulaResultUnits		=	(String) htSectionTemplate.get ("formulaResultUnits");
			includeyn		=	(String) htSectionTemplate.get ("includeyn");
			component_prompt		=	(String) htSectionTemplate.get("component_prompt");
			old_hist_time_frame_unit		=	(String) htSectionTemplate.get("old_hist_time_frame_unit");
			old_hist_time_frame_val		=	(String) htSectionTemplate.get("old_hist_time_frame_val");
			event_code		=	(String) htSectionTemplate.get("event_code");
			event_code_type		=	(String) htSectionTemplate.get("event_code_type");
			dflt_from_hist_appl_yn		=	(String) htSectionTemplate.get("dflt_from_hist_appl_yn");
			locale						= (String) htSectionTemplate.get("LOCALE");
			comp_disp_next_yn	=	(String) htSectionTemplate.get ("comp_disp_next_yn");/*IN059630_GHL-CRF-0401*/
			auto_result_yn	=	(String) htSectionTemplate.get ("auto_result_yn"); //IN061907
			con		=	ConnectionManager.getConnection(jdbc_props);
			con.setAutoCommit(false);
			try
			{
				if( (!( prev_no_of_col_span.equals(column_span)) ) && (prev_row_pos_no.equals(row_position)) && (prev_column_pos_no.equals(column_position)) )
				{
					String query_unique_chk3 =  " select sum(no_of_col_span) total_col_span from ca_section_template where sec_hdg_code=? and row_pos_no=?";
					pstmt	=	con.prepareStatement(query_unique_chk3);
					pstmt.setString(1,section);
					pstmt.setString(2,row_position);
					rs		=	pstmt.executeQuery();
					if(rs.next())
					{
						total_col_span	=	rs.getInt(1);
						total_col_span	=	total_col_span - Integer.parseInt(prev_no_of_col_span) + Integer.parseInt(column_span);
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
				else
				{
					if( ! (prev_row_pos_no.equals(row_position) && prev_column_pos_no.equals(column_position) && prev_no_of_col_span.equals(column_span) ) )
					{
						String query_unique_chk =  " select count(*) from ca_section_template where (sec_hdg_code=? and comp_id=? and row_pos_no=? and column_pos_no=?) or (sec_hdg_code=? and row_pos_no=? and column_pos_no=?)";
						pstmt	=	con.prepareStatement(query_unique_chk);
						pstmt.setString(1,section);
						pstmt.setString(2,component);
						pstmt.setString(3,row_position);
						pstmt.setString(4,column_position);
						pstmt.setString(5,section);
						pstmt.setString(6,row_position);
						pstmt.setString(7,column_position);
						rs		=	pstmt.executeQuery();
						if(rs.next())
							unique_chk1	=	rs.getInt(1);
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						//for checking the cases like row is already filled with 3 colspan
						if(unique_chk1<=0)
						{
							query_unique_chk =  " select sum(NO_OF_COL_SPAN) from ca_section_template where sec_hdg_code=? and row_pos_no=? ";
							pstmt	=	con.prepareStatement(query_unique_chk);
							pstmt.setString(1,section);
							pstmt.setString(2,row_position);							
							rs		=	pstmt.executeQuery();
							if(rs.next())
							{
								int colSpanSum	=	rs.getInt(1);
								if(colSpanSum>=3)
									unique_chk1 = 1;
							}
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
							
						}
					} // end of if
				}
				boolean overlap_flag = false;
				if(column_position == null)
					column_position = "0";
				if(column_span == null)
					column_span = "0";
				int	col_pos_no		=	Integer.parseInt(column_position);
				int	no_of_col_span	=	Integer.parseInt(column_span);
				if(total_col_span<=3)
				{

					if(col_pos_no==1 && no_of_col_span > 3)  overlap_flag = true;
					if(col_pos_no==2 && no_of_col_span > 2)  overlap_flag = true;
					if(col_pos_no==3 && no_of_col_span > 1)  overlap_flag = true;
				}
				
				try
				{
					if( ((!(prev_no_of_col_span.equals(column_span)) ) && (prev_row_pos_no.equals(row_position))) ||  (prev_no_of_col_span.equals(column_span) && (!(prev_column_pos_no.equals(column_position)))) )
					{						
						String query_unique_chk =  " select column_pos_no, no_of_col_span from ca_section_template where sec_hdg_code=? and row_pos_no=? ";
						pstmt	=	con.prepareStatement(query_unique_chk);
						pstmt.setString(1,section);
						pstmt.setString(2,row_position);
						rs		=	pstmt.executeQuery();
						int	tmp_col_pos_no		=	0;
						int	tmp_no_of_col_span	=	0;
						Properties propMaxLimit = new Properties();

						while(rs.next())
						{
							tmp_col_pos_no		=	rs.getInt(1);
							tmp_no_of_col_span	=	rs.getInt(2);

							if(tmp_col_pos_no==1)
							{	
								if(tmp_no_of_col_span==1)
								{
									propMaxLimit.put	(new Integer(2), new Integer(2));
									propMaxLimit.put	(new Integer(3), new Integer(1));
								}
								if(tmp_no_of_col_span==2)
								{
									propMaxLimit.put	(new Integer(2), new Integer(0));
									propMaxLimit.put	(new Integer(3), new Integer(1));
								}
								if(tmp_no_of_col_span==3)
								{
									propMaxLimit.put	(new Integer(2), new Integer(0));
									propMaxLimit.put	(new Integer(3), new Integer(0));
								}
							}
							if(tmp_col_pos_no==2)
							{	
								if(tmp_no_of_col_span==1)
								{
									propMaxLimit.put	(new Integer(1), new Integer(1));
									propMaxLimit.put	(new Integer(2), new Integer(2));
									propMaxLimit.put	(new Integer(3), new Integer(1));
								}
								if(tmp_no_of_col_span==2)
								{
									propMaxLimit.put	(new Integer(1), new Integer(1));
									propMaxLimit.put	(new Integer(2), new Integer(2));
									propMaxLimit.put	(new Integer(3), new Integer(0));
								}
							}
							if(tmp_col_pos_no==3)
							{	
								if(tmp_no_of_col_span==1)
								{
									propMaxLimit.put	(new Integer(1), new Integer(2));
									propMaxLimit.put	(new Integer(3), new Integer(1));
								}
							}
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();

						//sb.append("propMaxLimit : "+propMaxLimit);

						int	max_col_span	=	0;
						Integer obj_max_limit	=	(Integer) propMaxLimit.get(new Integer(col_pos_no));
						if(obj_max_limit!=null)
							max_col_span	=	(obj_max_limit).intValue();
						else 
							max_col_span	=	3;

						if(no_of_col_span>max_col_span)
						{
							overlap_flag = true;
						}
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					sb.append("Exception@7 : "+e);
				}
				if(unique_chk1>0 || unique_chk2>0 || total_col_span > 3 || overlap_flag )
				{
					commit_flag = false;
					results.put( "status", new Boolean(result) ) ;
					results.put( "error",getMessage(locale,"EXIST_COMP_OVERLAP","CA")  ) ;
					//results.put( "error", "APP-CA0024 Overlaps with existing Component" ) ;
					return results;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@recordCN-5: "+e);
				sb.append("<br>values "+section+" "+component+" "+row_position+" "+column_position);
			}
			//

			try
			{
				if(component_type.equals("R") || component_type.equals("X"))
				{
					String query_grid_matrix = "select count(*) from ca_section_template where sec_hdg_code = ? and comp_id = ? and item_type <> 'T'";
					pstmt = con.prepareStatement(query_grid_matrix);
					pstmt.setString(1, section);
					pstmt.setString(2, component);
					rs = pstmt.executeQuery();
					int count_grid_matrix = 0;
					if(rs.next())
						count_grid_matrix = rs.getInt(1);

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					if(count_grid_matrix != 0)
					{
						commit_flag = false;
						results.put( "status", new Boolean(result) ) ;
						results.put( "error",getMessage(locale,"EXIST_GROUP_COMP","CA")  ) ;
						//results.put( "error", "APP-CA0054 This Grid/Matrix component has already been added to this section..." ) ;
						return results;
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@recordCN-5.5: "+e);
				sb.append("<br>values "+section+" "+component+" "+row_position+" "+column_position);
			}
			try
			{
				String query_srl_no = " select nvl(max(srl_no),0)+1 from ca_section_template where sec_hdg_code=? "; 
				
				pstmt	=	con.prepareStatement(query_srl_no);
				pstmt.setString	(1,section);		
				rs1 = pstmt.executeQuery();
				if(rs1.next())
				{
					srl_no	=	rs1.getString(1);
				}
				if(rs1!=null) rs1.close();
				if(pstmt!=null) pstmt.close();
			 /*  String insert_ca_section = "INSERT INTO CA_SECTION_TEMPLATE (SEC_HDG_CODE,SRL_NO,ITEM_TYPE,COMP_ID,TITLE_ID,ROW_POS_NO,COLUMN_POS_NO,NO_OF_COL_SPAN,PROMPT_DISPLAY_LOC,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE, ADDED_AT_WS_NO, MODIFIED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_FACILITY_ID,DEP_DEFINITION,AGE_GROUP_CODE,HIST_REC_TYPE, ACCEPT_OPTION, LIST_SELECTION, LIST_PRESENTATION, HINT_ID, NUM_PREFIX_REQUIRED_YN, FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,INCLUDE_FOR_ANAL_YN,PROMPT_ID,OLD_HIST_TIME_FRAME_UNIT,OLD_HIST_TIME_FRAME_VAL,EVENT_CODE,EVENT_CODE_TYPE,DFLT_FROM_HIST_APPL_YN)  VALUES (?,?,?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,?,empty_clob(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/ /*IN059630_GHL-CRF-0401*/
			   //IN061907 start
			   //String insert_ca_section = "INSERT INTO CA_SECTION_TEMPLATE (SEC_HDG_CODE,SRL_NO,ITEM_TYPE,COMP_ID,TITLE_ID,ROW_POS_NO,COLUMN_POS_NO,NO_OF_COL_SPAN,PROMPT_DISPLAY_LOC,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE, ADDED_AT_WS_NO, MODIFIED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_FACILITY_ID,DEP_DEFINITION,AGE_GROUP_CODE,HIST_REC_TYPE, ACCEPT_OPTION, LIST_SELECTION, LIST_PRESENTATION, HINT_ID, NUM_PREFIX_REQUIRED_YN, FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,INCLUDE_FOR_ANAL_YN,PROMPT_ID,OLD_HIST_TIME_FRAME_UNIT,OLD_HIST_TIME_FRAME_VAL,EVENT_CODE,EVENT_CODE_TYPE,DFLT_FROM_HIST_APPL_YN,TEXT_ALLIGN_YN)  VALUES (?,?,?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,?,empty_clob(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; /*IN059630_GHL-CRF-0401*/
			   
			   String insert_ca_section = "INSERT INTO CA_SECTION_TEMPLATE (SEC_HDG_CODE,SRL_NO,ITEM_TYPE,COMP_ID,TITLE_ID,ROW_POS_NO,COLUMN_POS_NO,NO_OF_COL_SPAN,PROMPT_DISPLAY_LOC,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE, ADDED_AT_WS_NO, MODIFIED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_FACILITY_ID,DEP_DEFINITION,AGE_GROUP_CODE,HIST_REC_TYPE, ACCEPT_OPTION, LIST_SELECTION, LIST_PRESENTATION, HINT_ID, NUM_PREFIX_REQUIRED_YN, FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,INCLUDE_FOR_ANAL_YN,PROMPT_ID,OLD_HIST_TIME_FRAME_UNIT,OLD_HIST_TIME_FRAME_VAL,EVENT_CODE,EVENT_CODE_TYPE,DFLT_FROM_HIST_APPL_YN,TEXT_ALLIGN_YN,AUTO_RESULT_YN)  VALUES (?,?,?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,?,empty_clob(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			   //IN061907 ends

			   pstmt	=	con.prepareStatement(insert_ca_section);
			   pstmt.setString	(1,section);
			   pstmt.setString	(2,srl_no);
			   pstmt.setString	(3,item_type);
			   pstmt.setString	(4,component);
			   pstmt.setString	(5,title_text);
			   pstmt.setString	(6,row_position); 
			   pstmt.setString	(7,column_position);
			   pstmt.setString	(8,column_span);
			   pstmt.setString	(9,disp_position);
			   pstmt.setString	(10,login_user_id);
			   pstmt.setString	(11,login_user_id);
			   pstmt.setString	(12,client_ip_address);
			   pstmt.setString	(13,client_ip_address);
			   pstmt.setString	(14,added_facility_id);
			   pstmt.setString	(15,added_facility_id);
			//   pstmt.setString	(16,formula_definition);
			   pstmt.setString	(16,age_group_code);
			   pstmt.setString	(17,hist_rec_type);			   
			   pstmt.setString	(18,acceptOption);			   
			   pstmt.setString	(19,selectionSelect);			   
			   pstmt.setString	(20,presentationSelect);			   
			   pstmt.setString	(21,hintMessage);			   
			   pstmt.setString	(22,prefixRequired);			   
			   pstmt.setString	(23,formulaResultType);			   
			   pstmt.setString	(24,includeDates);			   
			   pstmt.setString	(25,formulaResultUnits);			   
			   pstmt.setString	(26,includeyn);			   
			   pstmt.setString	(27,component_prompt);			   
			   pstmt.setString	(28,old_hist_time_frame_unit);			   
			   pstmt.setString	(29,old_hist_time_frame_val);			   
			   pstmt.setString	(30,event_code);			   
			   pstmt.setString	(31,event_code_type);			   
			   pstmt.setString	(32,dflt_from_hist_appl_yn);	
			   pstmt.setString	(33,comp_disp_next_yn);/*IN059630_GHL-CRF-0401*/
			   pstmt.setString	(34,auto_result_yn); //IN061907

			   insert_chk= pstmt.executeUpdate();
			   if(pstmt!=null) pstmt.close();
			   
			   if(insert_chk==0)
			   {
					commit_flag=false;
			   }

			   if(insert_chk > 0 && formula_definition!=null)
				{
				   try
					{
					   String query_clob_object = "select DEP_DEFINITION from ca_section_template where SEC_HDG_CODE=? and SRL_NO=? for update";
						pstmt_clb = con.prepareStatement(query_clob_object);
						pstmt_clb.setString(1,section);
						pstmt_clb.setString(2,srl_no);
						//pstmt_clb.setString(3,component);


						rs_clb = pstmt_clb.executeQuery();

						if(rs_clb.next())
						{
						//Web logic Conversion -- [IN037372] Start.
								//formula_def_clob = (oracle.sql.CLOB) rs_clb.getObject("DEP_DEFINITION");
								//definition_content_writer	= ((oracle.sql.CLOB)	formula_def_clob).getCharacterOutputStream();
								//bf_definition_content_writer = new java.io.BufferedWriter(definition_content_writer);
								
								formula_def_clob = (java.sql.Clob) rs_clb.getClob("DEP_DEFINITION");
								bf_definition_content_writer = new java.io.BufferedWriter(formula_def_clob.setCharacterStream(0));
						//Web logic Conversion -- [IN037372] End.		
								bf_definition_content_writer.write(formula_definition,0,formula_definition.length());
								bf_definition_content_writer.flush();
								bf_definition_content_writer.close();
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						commit_flag = false;
						sb.append("<br>Exception@writingCLOB-recordCN-2.0: "+ex);
					}
					finally
					{
						if(rs_clb!=null)
							rs_clb.close();

						if(pstmt_clb!=null)
							pstmt_clb.close();
					}
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@recordCN-2: "+e);
			}
		} // end of try
		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@recordCN-3 : "+e);
		}
		finally
		{
			try
			{
				htSectionTemplate.clear();
				if(commit_flag)
				{
					result = true ;
					MessageManager mm = new MessageManager();
					final java.util.Hashtable message = mm.getMessage( locale,"RECORD_INSERTED","CA") ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				} // if(commit_flag)
				else
				{
					con.rollback();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@recordCN-4 : "+e);
				try
				{
					con.rollback();
				}
				catch(Exception e1) {}
			}
			finally
			{
					
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				
			} // end of finally
		} // end of finally
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		
		return results ;
	} // end of method insertSectionTemplate
	
	
		/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap updateSectionTemplate(java.util.Properties	jdbc_props,java.util.HashMap htSectionTemplate)	
	{
		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;
		PreparedStatement pstmt_clb = null;
		ResultSet rs_clb = null;

		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;
		String		section						=	"",	title_text					=	"";
		String		component					=	"",	formula_definition			=	"";
		String		row_position				=	"",	column_position			=	"";
		String		column_span				=	"",	disp_position				=	"";
		String		login_user_id				=	"",	srl_no							=	"";
		String		prev_row_pos_no			=	"",	prev_column_pos_no		=	"";
		String		prev_no_of_col_span	=	"",	client_ip_address			=	"";
		String		age_group_code			=	"",	hist_rec_type				=	""; 
		String		acceptOption				=	"",	added_facility_id			=	"";
		String		presentationSelect		=	"",	selectionSelect			=	"";
		String		prefixRequired				=	"",	hintMessage				=	"";
		String		formulaResultType		=	"";
		String		includeDates				=	"",		formulaResultUnits		=	"";
		String      includeyn ="" ,component_prompt ="";  
		String       old_hist_time_frame_unit = "", old_hist_time_frame_val = "";
		String       event_code = "",event_code_type="",dflt_from_hist_appl_yn="";
		String		 locale = "";	
		String 		comp_disp_next_yn=""; /*IN059630_GHL-CRF-0401*/
		String 		auto_result_yn=""; //IN061907
		boolean	result							=	false,	commit_flag					=	true;

		//oracle.sql.CLOB    formula_def_clob = null;  ////Web logic Conversion -- [IN037372]
		java.sql.Clob    formula_def_clob = null;
		//java.io.Writer     definition_content_writer = null;
		java.io.BufferedWriter	bf_definition_content_writer		=	null;

		int     unique_chk1					=	0,		unique_chk2					=	0;
		int		update_chk					=	0; 
		int		total_col_span				=	0;

		try
		{
			added_facility_id				=	(String) htSectionTemplate.get ("added_facility_id" ) ;
			section								=	(String) htSectionTemplate.get ("section");
			title_text							=	(String) htSectionTemplate.get ("title_text_code");
			login_user_id						=	(String) htSectionTemplate.get ("login_user_id");
			component						=	(String) htSectionTemplate.get ("component");
			row_position						=	(String) htSectionTemplate.get ("row_position");  
			column_position				=	(String) htSectionTemplate.get ("column_position");     
			column_span						=	(String) htSectionTemplate.get ("column_span");
			disp_position						=	(String) htSectionTemplate.get ("disp_position");
			srl_no								=	(String) htSectionTemplate.get ("srl_no");
			prev_row_pos_no				=	(String) htSectionTemplate.get ("prev_row_pos_no");
			prev_column_pos_no		=	(String) htSectionTemplate.get ("prev_column_pos_no");
			prev_no_of_col_span		=	(String) htSectionTemplate.get ("prev_no_of_col_span");
			client_ip_address				=	(String) htSectionTemplate.get ("client_ip_address");
			formula_definition				=	(String) htSectionTemplate.get ("formula_definition");
			age_group_code				=	(String) htSectionTemplate.get ("age_group_code");
			hist_rec_type					=	(String) htSectionTemplate.get ("hist_rec_type");
			acceptOption						=	(String) htSectionTemplate.get ("acceptOption");
			presentationSelect				=	(String) htSectionTemplate.get ("presentationSelect");
			selectionSelect					=	(String) htSectionTemplate.get ("selectionSelect");
			prefixRequired					=	(String) htSectionTemplate.get ("prefixRequired");
			hintMessage						=	(String) htSectionTemplate.get ("hintMessage");
			formulaResultType				=	(String) htSectionTemplate.get ("formulaResultType");
			includeDates						=	(String) htSectionTemplate.get ("includeDates");
			formulaResultUnits				=	(String) htSectionTemplate.get ("formulaResultUnits");
			includeyn							=	(String) htSectionTemplate.get ("includeyn");
			component_prompt			=	(String) htSectionTemplate.get ("component_prompt");
			old_hist_time_frame_unit	=	(String) htSectionTemplate.get("old_hist_time_frame_unit");
			old_hist_time_frame_val	=	(String) htSectionTemplate.get("old_hist_time_frame_val");
			event_code	=	(String) htSectionTemplate.get("event_code");
			event_code_type	=	(String) htSectionTemplate.get("event_code_type");
			dflt_from_hist_appl_yn	=	(String) htSectionTemplate.get("dflt_from_hist_appl_yn");
			locale	=	(String) htSectionTemplate.get("LOCALE");
			comp_disp_next_yn	=	(String) htSectionTemplate.get ("comp_disp_next_yn");/*IN059630_GHL-CRF-0401*/
			auto_result_yn	=	(String) htSectionTemplate.get ("auto_result_yn"); //IN061907

			con		=	ConnectionManager.getConnection(jdbc_props);

			con.setAutoCommit(false);
			try
			{
				if( (!( prev_no_of_col_span.equals(column_span)) ) && (prev_row_pos_no.equals(row_position)) && (prev_column_pos_no.equals(column_position)) )
				{
					String query_unique_chk3 =  " select sum(no_of_col_span) total_col_span from ca_section_template where sec_hdg_code=? and row_pos_no=? and srl_no!= ?";
					if(pstmt!=null) pstmt=null;
					pstmt	=	con.prepareStatement(query_unique_chk3);
					pstmt.setString(1,section);
					pstmt.setString(2,row_position);
					pstmt.setString(3,srl_no);

					rs		=	pstmt.executeQuery();

					if(rs.next())
					{
						total_col_span	=	rs.getInt(1);
						total_col_span	=	total_col_span - Integer.parseInt(prev_no_of_col_span) + Integer.parseInt(column_span);
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
				else
				{
					if( ! (prev_row_pos_no.equals(row_position) && prev_column_pos_no.equals(column_position) && prev_no_of_col_span.equals(column_span) ) )
					{
						String query_unique_chk =  " select count(*) from ca_section_template where ((sec_hdg_code=? and comp_id=? and row_pos_no=? and column_pos_no=?) or (sec_hdg_code=? and row_pos_no=? and column_pos_no=?)) and srl_no!= ?";
						pstmt	=	con.prepareStatement(query_unique_chk);
						//sb.append("<br><br>query_accession_num : "+query_accession_num);
						pstmt.setString(1,section);
						pstmt.setString(2,component);
						pstmt.setString(3,row_position);
						pstmt.setString(4,column_position);
						pstmt.setString(5,section);
						pstmt.setString(6,row_position);
						pstmt.setString(7,column_position);
						pstmt.setString(8,srl_no);

						rs		=	pstmt.executeQuery();

						if(rs.next())
						{
							unique_chk1	=	rs.getInt(1);
						}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					} // end of if
				}
				boolean overlap_flag = false;
				int	col_pos_no		=	Integer.parseInt(column_position);
				int	no_of_col_span	=	Integer.parseInt(column_span);

				if(total_col_span<=3)
				{
					if(col_pos_no==1 && no_of_col_span > 3)  overlap_flag = true;
					if(col_pos_no==2 && no_of_col_span > 2)  overlap_flag = true;
					if(col_pos_no==3 && no_of_col_span > 1)  overlap_flag = true;
				}

				try
				{
					if( ((!(prev_no_of_col_span.equals(column_span)) ) && (prev_row_pos_no.equals(row_position))) ||  (prev_no_of_col_span.equals(column_span) && (!(prev_column_pos_no.equals(column_position)))) )
					{
						String query_unique_chk =  " select column_pos_no, no_of_col_span from ca_section_template where sec_hdg_code=? and row_pos_no=? and srl_no!= ? ";
						pstmt	=	con.prepareStatement(query_unique_chk);
						//sb.append("<br><br>query_unique_chk-test : "+query_unique_chk);
						pstmt.setString(1,section);
						pstmt.setString(2,row_position);
						pstmt.setString(3,srl_no);

						rs		=	pstmt.executeQuery();

						int	tmp_col_pos_no		=	0;
						int	tmp_no_of_col_span	=	0;
						Properties propMaxLimit = new Properties();

						while(rs.next())
						{
							tmp_col_pos_no		=	rs.getInt(1);
							tmp_no_of_col_span	=	rs.getInt(2);

							if(tmp_col_pos_no==1)
							{	
								if(tmp_no_of_col_span==1)
								{
									propMaxLimit.put	(new Integer(2), new Integer(2));
									propMaxLimit.put	(new Integer(3), new Integer(1));
								}
								if(tmp_no_of_col_span==2)
								{
									propMaxLimit.put	(new Integer(2), new Integer(0));
									propMaxLimit.put	(new Integer(3), new Integer(1));
								}
								if(tmp_no_of_col_span==3)
								{
									propMaxLimit.put	(new Integer(2), new Integer(0));
									propMaxLimit.put	(new Integer(3), new Integer(0));
								}
							}
							if(tmp_col_pos_no==2)
							{	
								if(tmp_no_of_col_span==1)
								{
									propMaxLimit.put	(new Integer(1), new Integer(1));
									propMaxLimit.put	(new Integer(2), new Integer(2));
									propMaxLimit.put	(new Integer(3), new Integer(1));
								}
								if(tmp_no_of_col_span==2)
								{
									propMaxLimit.put	(new Integer(1), new Integer(1));
									propMaxLimit.put	(new Integer(2), new Integer(2));
									propMaxLimit.put	(new Integer(3), new Integer(0));
								}
							}
							if(tmp_col_pos_no==3)
							{	
								if(tmp_no_of_col_span==1)
								{
									propMaxLimit.put	(new Integer(1), new Integer(2));
									propMaxLimit.put	(new Integer(3), new Integer(1));
								}
							}
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();

						//sb.append("propMaxLimit : "+propMaxLimit);

						int	max_col_span		=	0;
						Integer obj_max_limit	=	(Integer) propMaxLimit.get(new Integer(col_pos_no));
						if(obj_max_limit!=null)
							max_col_span	=	(obj_max_limit).intValue();
						else 
							max_col_span	=	3;
						if(no_of_col_span>max_col_span)
						{
							overlap_flag = true;
						}
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					sb.append("Exception@7 : "+e);
				}
				if(unique_chk1>0 || unique_chk2>0 || total_col_span > 3 || overlap_flag )
				{
					commit_flag = false;
					results.put( "status", new Boolean(result) ) ;
					results.put( "error",getMessage(locale,"EXIST_COMP_OVERLAP","CA")  ) ;
					//results.put( "error", "APP-CA0024 Overlaps with existing Component" ) ;
					return results;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@recordCN-5: "+e);
				sb.append("<br>values "+section+" "+component+" "+row_position+" "+column_position);
			}
			
			try
			{
				
			   /*String insert_ca_section = "UPDATE CA_SECTION_TEMPLATE SET COMP_ID=?,TITLE_ID=?,ROW_POS_NO=?,COLUMN_POS_NO=?,NO_OF_COL_SPAN=?,PROMPT_DISPLAY_LOC=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, DEP_DEFINITION= empty_clob() ,AGE_GROUP_CODE=?,HIST_REC_TYPE=?,ACCEPT_OPTION=?, LIST_SELECTION=?, LIST_PRESENTATION=?, HINT_ID=?, NUM_PREFIX_REQUIRED_YN=?, FORMULA_RESULT_TYPE=?, FORMULA_INCLUDES_DATE_YN=?, FORMULA_RESULT_UNIT=? ,INCLUDE_FOR_ANAL_YN=?,PROMPT_ID=?,OLD_HIST_TIME_FRAME_UNIT = ? ,OLD_HIST_TIME_FRAME_VAL = ?,EVENT_CODE = ?,EVENT_CODE_TYPE=?,DFLT_FROM_HIST_APPL_YN = ? WHERE SEC_HDG_CODE=? AND SRL_NO=? "; */ /*IN059630_GHL-CRF-0401*/
			   //IN061907 start
			   //String insert_ca_section = "UPDATE CA_SECTION_TEMPLATE SET COMP_ID=?,TITLE_ID=?,ROW_POS_NO=?,COLUMN_POS_NO=?,NO_OF_COL_SPAN=?,PROMPT_DISPLAY_LOC=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, DEP_DEFINITION= empty_clob() ,AGE_GROUP_CODE=?,HIST_REC_TYPE=?,ACCEPT_OPTION=?, LIST_SELECTION=?, LIST_PRESENTATION=?, HINT_ID=?, NUM_PREFIX_REQUIRED_YN=?, FORMULA_RESULT_TYPE=?, FORMULA_INCLUDES_DATE_YN=?, FORMULA_RESULT_UNIT=? ,INCLUDE_FOR_ANAL_YN=?,PROMPT_ID=?,OLD_HIST_TIME_FRAME_UNIT = ? ,OLD_HIST_TIME_FRAME_VAL = ?,EVENT_CODE = ?,EVENT_CODE_TYPE=?,DFLT_FROM_HIST_APPL_YN = ?,TEXT_ALLIGN_YN = ? WHERE SEC_HDG_CODE=? AND SRL_NO=? "; /*IN059630_GHL-CRF-0401*/
			   String insert_ca_section = "UPDATE CA_SECTION_TEMPLATE SET COMP_ID=?,TITLE_ID=?,ROW_POS_NO=?,COLUMN_POS_NO=?,NO_OF_COL_SPAN=?,PROMPT_DISPLAY_LOC=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, DEP_DEFINITION= empty_clob() ,AGE_GROUP_CODE=?,HIST_REC_TYPE=?,ACCEPT_OPTION=?, LIST_SELECTION=?, LIST_PRESENTATION=?, HINT_ID=?, NUM_PREFIX_REQUIRED_YN=?, FORMULA_RESULT_TYPE=?, FORMULA_INCLUDES_DATE_YN=?, FORMULA_RESULT_UNIT=? ,INCLUDE_FOR_ANAL_YN=?,PROMPT_ID=?,OLD_HIST_TIME_FRAME_UNIT = ? ,OLD_HIST_TIME_FRAME_VAL = ?,EVENT_CODE = ?,EVENT_CODE_TYPE=?,DFLT_FROM_HIST_APPL_YN = ?,TEXT_ALLIGN_YN = ?,AUTO_RESULT_YN = ? WHERE SEC_HDG_CODE=? AND SRL_NO=? ";
			   
			   //IN061907 ends

			   pstmt	=	con.prepareStatement(insert_ca_section);

			   pstmt.setString	(1,component);
			   pstmt.setString	(2,title_text);
			   pstmt.setString	(3,row_position);
			   pstmt.setString	(4,column_position);
			   pstmt.setString	(5,column_span);
			   pstmt.setString	(6,disp_position);
			   pstmt.setString	(7,login_user_id);
			   pstmt.setString	(8,client_ip_address);	
			   pstmt.setString	(9,added_facility_id);
			   //pstmt.setString	(10,formula_definition);
			   pstmt.setString	(10,age_group_code);
			   pstmt.setString	(11,hist_rec_type);
			   pstmt.setString	(12,acceptOption);
			   pstmt.setString	(13,selectionSelect);
			   pstmt.setString	(14,presentationSelect);
			   pstmt.setString	(15,hintMessage);
			   pstmt.setString	(16,prefixRequired);
			   pstmt.setString	(17,formulaResultType);			   
			   pstmt.setString	(18,includeDates);			   
			   pstmt.setString	(19,formulaResultUnits);			   
			   pstmt.setString	(20,includeyn);			   
			   pstmt.setString	(21,component_prompt);			   
               pstmt.setString	(22,old_hist_time_frame_unit);
			   pstmt.setString	(23,old_hist_time_frame_val);
			   pstmt.setString	(24,event_code);
			   pstmt.setString	(25,event_code_type);
			   pstmt.setString	(26,dflt_from_hist_appl_yn);
			   pstmt.setString	(27,comp_disp_next_yn); /*IN059630_GHL-CRF-0401*/
			   pstmt.setString	(28,auto_result_yn); //IN061907
			   pstmt.setString	(29,section);
			   pstmt.setString	(30,srl_no);
			  
			  
			   update_chk= pstmt.executeUpdate();
			  
					if(pstmt!=null) pstmt.close();
			    if(update_chk==0)
				{
					commit_flag=false;
				}               
				
				if(update_chk >0 && formula_definition!=null)
				{
					try
					{
					   String query_clob_object_updt = "select DEP_DEFINITION from ca_section_template where SEC_HDG_CODE=? and SRL_NO=?  for update";
						pstmt_clb = con.prepareStatement(query_clob_object_updt);
						pstmt_clb.setString(1,section);
						pstmt_clb.setString(2,srl_no);
						//pstmt_clb.setString(3,component);

						rs_clb = pstmt_clb.executeQuery();

						if(rs_clb.next())
						{
						//Web logic Conversion -- [IN037372] Start.
							//formula_def_clob = (oracle.sql.CLOB) rs_clb.getObject("DEP_DEFINITION");
							//definition_content_writer	= ((oracle.sql.CLOB)	formula_def_clob).getCharacterOutputStream();
							//bf_definition_content_writer = new java.io.BufferedWriter(definition_content_writer);
							
							formula_def_clob = (java.sql.Clob) rs_clb.getClob("DEP_DEFINITION");
							bf_definition_content_writer = new java.io.BufferedWriter(formula_def_clob.setCharacterStream(0));
						//Web logic Conversion -- [IN037372] End.
							bf_definition_content_writer.write(formula_definition,0,formula_definition.length());
							bf_definition_content_writer.flush();
							bf_definition_content_writer.close();

						}
					}
					catch(Exception ei)
					{
						ei.printStackTrace();
						commit_flag = false;
						sb.append("<br>Exception@UpdateClob: "+ei);
					}
					finally
					{
						if(rs_clb!=null)
							rs_clb.close();
						if(pstmt_clb!=null)
							pstmt_clb.close();
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@recordCN-6: "+e);
			}
		} // end of try
		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@recordCN-7 : "+e);
		}
		finally
		{
			try
			{
				htSectionTemplate.clear();
				if(commit_flag)
				{
					result = true ;
					MessageManager mm = new MessageManager();
					final java.util.Hashtable message = mm.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				} // if(commit_flag)
				else
				{
					con.rollback();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@recordCN-8 : "+e);
				try
				{
					con.rollback();
				}
				catch(Exception e1) {}
			}
			finally
			{
				try
				{
					
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				}catch(Exception e){}
			} // end of finally
		} // end of finally
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		
		return results ; 
	} // end of updateSectionTemplate

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap deleteSectionTemplate(java.util.Properties jdbc_props,java.util.HashMap htSectionTemplate)	
	{
		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		//ResultSet			rs		=	null;

		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;

		String	section						=	"",		srl_no						=	"";
		String locale ="";

		boolean result						=	false,	commit_flag					=	true;

		int		delete_result				=	0;

		try
		{
			section				=	(String) htSectionTemplate.get ("section");
			srl_no       	    =	(String) htSectionTemplate.get ("srl_no");
			locale				=	(String) htSectionTemplate.get ("LOCALE");
			con					=	ConnectionManager.getConnection(jdbc_props);

			con.setAutoCommit(false);

			try
			{
				String delete_ca_section_template = "delete ca_section_template where sec_hdg_code = ? and srl_no = ? ";

				pstmt	=	con.prepareStatement(delete_ca_section_template);
			   
				pstmt.setString	(	1,	section		);
				pstmt.setString	(	2,	srl_no		);
			  
				delete_result	=	pstmt.executeUpdate();
				if(delete_result==0)	commit_flag	=	false;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@deleteSTPL-1: "+e);
			}
		} // end of try
		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@deleteSTPL-2 : "+e);
		}
		finally
		{
			try
			{
				htSectionTemplate.clear();
				if(commit_flag)
				{
					result = true ;
					MessageManager mm = new MessageManager();
					final java.util.Hashtable message = mm.getMessage( locale, "RECORD_DELETED" ,"CA" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				} // if(commit_flag)
				else
				{
					con.rollback();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@deleteSTPL-3 : "+e);
				try
				{
					con.rollback();
				}
				catch(Exception e1) {}
			}
			finally
			{
				try
				{
					if(pstmt!=null) pstmt.close();
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
					}catch(Exception e){}
			} // end of finally
		} // end of finally

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		
		return results ;
	} // end of deleteSectionTemplate
	private String getMessage(String locale, String messageId, String moduleId)
	{
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }
} // end of class SectionTemplateManager 
