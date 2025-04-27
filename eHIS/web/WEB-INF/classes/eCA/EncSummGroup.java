/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
18/07/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import webbeans.eCommon.ConnectionManager;

public class EncSummGroup implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	/*
	 * Gets the list of Summary Groups 
	 */	
	public List<EncSummGroupBean> getSummaryGroupDetails(EncSummGroupBean sGroupBean) throws Exception {
		List<EncSummGroupBean> sSummGrpList = new ArrayList<EncSummGroupBean>() ;
		int summGrpFlag = 0;
		String summGrpType = "";
		String summGrpCode = "";
		
		if(summGrpType != null && summGrpCode != null )
		{
			Connection connection 		= null;
			Statement stmt				= null;
			ResultSet resultSet 		= null;

			StringBuffer sqlStr = new StringBuffer("");
			
			HttpServletRequest request = sGroupBean.request;
			summGrpFlag = sGroupBean.getiGroupFlag();
			summGrpType = sGroupBean.getsGroupType();
			summGrpCode = sGroupBean.getsGroupCode();
			
			sqlStr.append(" select es_group_flag, es_group_type, es_group_type, es_group_code, es_group_desc, es_group_remarks, es_group_image_url, es_group_status ");
			sqlStr.append(" from cr_es_group_header ");
			sqlStr.append(" where es_group_flag = "+summGrpFlag+" and es_group_type = '"+summGrpType+"' and es_group_code = '"+summGrpCode+"' ");
				
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}				
					
					System.out.println(" - - - Summary Groups: "+sqlStr.toString());
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {

						EncSummGroupBean sSummGroup = new EncSummGroupBean();
						sSummGroup.setiGroupFlag(summGrpFlag) ;
						sSummGroup.setsGroupType(summGrpType) ;
						sSummGroup.setsGroupCode(summGrpCode);
						sSummGroup.setsGroupDesc(((resultSet.getString("es_group_desc") != null) ?resultSet.getString("es_group_desc") : "")) ;
						sSummGroup.setsGroupRemarks(((resultSet.getString("es_group_remarks") != null) ?resultSet.getString("es_group_remarks") : "")) ;
						sSummGroup.setsImageURL(((resultSet.getString("es_group_image_url") != null) ?resultSet.getString("es_group_image_url") : "")) ;
						sSummGroup.setsGroupStatus(resultSet.getString("es_group_status")) ;

						sSummGrpList.add(sSummGroup);

				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);

			}

		}
		return sSummGrpList;
	}
	
	/*
	 * Gets the list of Summary Group Types - History Record Types
	 */
	public List<EncSummHistTypeBean> getSummaryGroupType (EncSummHistTypeBean sTypeBean) throws Exception {
		List<EncSummHistTypeBean> sSummGrpTypeList = new ArrayList<EncSummHistTypeBean>() ;	
		
		Connection connection 		= null;
		Statement stmt				= null;
		ResultSet resultSet 		= null;

		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = sTypeBean.request;	
		
		String sGroupType = "";
		
		sqlStr.append(" select hist_rec_type, long_desc, short_desc from cr_hist_rec_type where HIST_REC_TYPE not in ('MGCL', 'DIET','MEDN','FEVT','NBDT' ,'MHD') ");//Added MHD for ML-MMOH-CRF-1759
		
		sGroupType = sTypeBean.getsHistTypeRec();
		
		if (!(sGroupType =="") & !(sGroupType == null))
		{
			sqlStr.append(" and hist_rec_type = '"+sGroupType+"'");
		}			
			
		sqlStr.append(" order by short_desc ");
		
		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{
					stmt = connection.createStatement();
				}				
				
				System.out.println(" - - - History record Types: "+sqlStr.toString());
				if(stmt != null)
					resultSet = stmt.executeQuery(sqlStr.toString());
				while ( resultSet != null && resultSet.next() ) {
					EncSummHistTypeBean sHistTypeBean = new EncSummHistTypeBean();						
					sHistTypeBean.setsHistTypeRec(((resultSet.getString("hist_rec_type") != null) ?resultSet.getString("hist_rec_type") : "")) ;
					sHistTypeBean.setsLongDesc(((resultSet.getString("long_desc") != null) ?resultSet.getString("long_desc") : "")) ;
					sHistTypeBean.setsShortDesc(((resultSet.getString("short_desc") != null) ?resultSet.getString("short_desc") : "")) ;
					
					sSummGrpTypeList.add(sHistTypeBean);

			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				 if ( resultSet != null ) resultSet.close() ;	
				 if ( stmt != null ) stmt.close() ;
				 ConnectionManager.returnConnection(connection,request);

		}		
		return sSummGrpTypeList;
	}
	
	/*
	 * Gets the list of Template Types 
	 */
	public List<EncSummTemplateTypeBean> getTemplateType (EncSummTemplateTypeBean sTypeBean) throws Exception {
		List<EncSummTemplateTypeBean> sTemplateTypeList = new ArrayList<EncSummTemplateTypeBean>() ;	
		
		Connection connection 		= null;
		Statement stmt				= null;
		ResultSet resultSet 		= null;

		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = sTypeBean.request;		
		
		sqlStr.append(" select es_template_type, es_template_desc from cr_es_template_master ");		
			
		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{
					stmt = connection.createStatement();
				}				
				
				System.out.println(" - - - Template Type SQL: "+sqlStr.toString());
				if(stmt != null)
					resultSet = stmt.executeQuery(sqlStr.toString());
				while ( resultSet != null && resultSet.next() ) {
					EncSummTemplateTypeBean sTemplateTypeBean = new EncSummTemplateTypeBean();						
					sTemplateTypeBean.setsTemplateType(((resultSet.getString("es_template_type") != null) ?resultSet.getString("es_template_type") : ""));
					sTemplateTypeBean.setsTemplateDesc(((resultSet.getString("es_template_desc") != null) ?resultSet.getString("es_template_desc") : ""));					
					sTemplateTypeList.add(sTemplateTypeBean);
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				 if ( resultSet != null ) resultSet.close() ;	
				 if ( stmt != null ) stmt.close() ;
				 ConnectionManager.returnConnection(connection,request);

		}		
		return sTemplateTypeList;
	}
	
	/*
	 * Gets the list of Summary Groups - Components Details 
	 */
	public List<EncSummGroupBean> getSummaryGroupCompDetails(EncSummGroupBean sGroupBean, String language) throws Exception {
		List<EncSummGroupBean> sSummGrpList = new ArrayList<EncSummGroupBean>() ;
		int summGrpFlag = 0;
		String summGrpType = "";
		String summGrpCode = "";
		
		if(summGrpType != null && summGrpCode != null )
		{
			Connection connection 		= null;
			Statement stmt				= null;
			ResultSet resultSet 		= null;
			
			Statement stmtLbin			= null;
			ResultSet rsLbin			= null;

			String sqlLbin = "";
			StringBuffer sqlStr = new StringBuffer("");
			
			HttpServletRequest request = sGroupBean.request;
			summGrpFlag = sGroupBean.getiGroupFlag();
			summGrpType = sGroupBean.getsGroupType();
			summGrpCode = sGroupBean.getsGroupCode();
			
			sqlStr.append(" Select es_sub_group, es_sub_group_desc, es_sub_group_type, es_comp_flag, es_comp_type,  es_comp_code, es_comp_template, es_comp_columns, es_comp_status, es_comp_desc, es_template_desc, es_column_type ");
			sqlStr.append(" from vw_es_group_comp ");
			sqlStr.append(" where es_group_flag = "+summGrpFlag+" and es_group_type = '"+summGrpType+"' and es_group_code = '"+summGrpCode+"' ");
			sqlStr.append(" order by es_sub_group desc, es_comp_template ");
			
			
			try {				
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
						stmtLbin = connection.createStatement();
					}					
					
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					
					System.out.println(" - - - Group components SQL: "+sqlStr.toString());
					
					while ( resultSet != null && resultSet.next() ) {
						
						EncSummGroupBean sSummGroup = new EncSummGroupBean();
						sSummGroup.setiGroupFlag(summGrpFlag) ;
						sSummGroup.setsGroupType(summGrpType) ;
						sSummGroup.setsGroupCode(summGrpCode);
						sSummGroup.setsSubCompSubGroup(((resultSet.getString("es_sub_group") != null) ?resultSet.getString("es_sub_group") : ""));		
						sSummGroup.setsSubCompSubGroupDesc(((resultSet.getString("es_sub_group_desc") != null) ?resultSet.getString("es_sub_group_desc") : ""));		
						sSummGroup.setsSubGroupType(((resultSet.getString("es_sub_group_type") != null) ?resultSet.getString("es_sub_group_type") : ""));
						sSummGroup.setiSubCompFlag(resultSet.getInt("es_comp_flag"));
						sSummGroup.setsSubCompType(((resultSet.getString("es_comp_type") != null) ?resultSet.getString("es_comp_type") : ""));
						/*
						if (resultSet.getString("es_comp_type").equalsIgnoreCase("lbin"))
						{
							sqlLbin = " SELECT rowId row_id, test_code code, Long_desc description FROM rl_test_code where test_code = '"+resultSet.getString("es_comp_code")+"'";
							rsLbin = stmtLbin.executeQuery(sqlLbin);
							if (rsLbin.next())
							{
								sSummGroup.setsSubCompDesc(rsLbin.getString("description"));
							}
						}
						*/
						
						//System.out.println(" - - - components TYpe: "+resultSet.getString("es_comp_type")+" language_id: "+language+ " Component Code: "+resultSet.getString("es_comp_code"));
						
						sqlLbin="select  event_code code, short_desc description from cr_event_hist_rec_vw where hist_rec_type = '"+resultSet.getString("es_comp_type")+"' and language_id = '"+language+"' and upper(event_code) = upper('"+resultSet.getString("es_comp_code")+"') ";
						rsLbin = stmtLbin.executeQuery(sqlLbin);
						if (rsLbin.next())
						{
							sSummGroup.setsSubCompDesc(rsLbin.getString("description"));
						}
						
						sSummGroup.setsSubCompCode(((resultSet.getString("es_comp_code") != null) ?resultSet.getString("es_comp_code") : ""));						
						sSummGroup.setiSubCompTemplate(resultSet.getInt("es_comp_template"));
						sSummGroup.setiSubCompColumns(resultSet.getInt("es_comp_columns"));						
						sSummGroup.setsSubCompTempDesc(resultSet.getString("es_comp_desc"));						
						sSummGroup.setsSubCompStatus(resultSet.getString("es_comp_status"));
						
						sSummGroup.setsSubCompTemplate(((resultSet.getString("es_template_desc") != null) ?resultSet.getString("es_template_desc") : "")) ;	
						sSummGroup.setsSubCompColumnType(resultSet.getString("es_column_type"));
						sSummGrpList.add(sSummGroup);
					}
				} catch ( Exception e )	{
					e.printStackTrace() ;
					throw e ;
				} finally {
						 if ( resultSet != null ) resultSet.close() ;	
						 if ( stmt != null ) stmt.close() ;
						 ConnectionManager.returnConnection(connection,request);
	
				}

		}
		return sSummGrpList;
	}
	
	/*
	 * Gets the list of Summary Group Components to be added 
	 */	
	public List<EncSummCompBean> getSummaryComps (EncSummCompBean sCompBean, String language, int pageCount) throws Exception {
		List<EncSummCompBean> sSummCompList = new ArrayList<EncSummCompBean>() ;	
		
		Connection connection = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;

		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = sCompBean.request;	
		
		String sGroupType = "";	
		String sSubGroupType = "";	
		String sGroupCode = "";	
		String sRowId = "";
		String searchText = "";
		
		int iGFlag = sCompBean.getiGFlag();
		
		sGroupType = sCompBean.getsHistTypeRec();
		sSubGroupType = sCompBean.getsSubGroupType();
		sGroupCode = sCompBean.getsGroupCode();
		sRowId = sCompBean.getsRowId();
		searchText = sCompBean.getsSearchText();
		
		int rowCount = 5;
		int absoluteCount = 0;
		
		String sql = "";		
		int count =0;		
		
		if (iGFlag == 0){			
			sql = "Select es_group_code, es_group_desc from cr_es_group_header where es_group_flag = 1 and upper(es_group_type) = upper(?)";
		}
		else
		{
			/*
			if (sSubGroupType.equalsIgnoreCase("lbin"))
			{				
				sql = "SELECT test_code code, long_desc description FROM rl_test_code where group_test_yn  = 'Y' ";
				if (!(sGroupType.equalsIgnoreCase("ug")))
				{
					sql = sql + " and upper(test_code) like upper(?) ";
				}				
			}
			if (sSubGroupType.equalsIgnoreCase("rdin"))
			{			
				sql = "SELECT exam_code code, long_desc description FROM rd_exams where group_exam_yn  = 'Y' ";
				if (!(sGroupType.equalsIgnoreCase("ug")))
				{
					sql = sql + " and upper(exam_code) like upper(?) ";
				}
			}
			*/
			sql = "select event_code code, short_desc description from cr_event_hist_rec_vw where hist_rec_type = '"+sSubGroupType+"' and language_id = '"+language+"' " ;
			if (!(sGroupType.equalsIgnoreCase("ug")))
			{
				sql = sql + " and ( upper(event_code) like upper('"+searchText+"%') or upper(short_desc) like upper('"+searchText+"%') ) ";
			}	
			
			sql = sql + " ORDER BY short_desc ";
		}
		
		System.out.println(" - - - Group components to be added SQL: "+sql);
		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{
					ps = connection.prepareStatement(sql);
					stmt = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
				}				
				
				if (iGFlag == 1)
				{
					if (!(sGroupType.equalsIgnoreCase("ug")))
					{
						System.out.println(" - - - sGroupCode: "+sGroupCode);
						//ps.setString(1,sGroupCode);
						//ps.setString(2,sGroupCode);
					}
				}
				else
					ps.setString(1,sSubGroupType);
								
				rs = ps.executeQuery();
				
				while (rs.next())
				{
					count++;
				}							
				
				System.out.println(" - - - count: "+count);
				
				if (count>0){
					
					if (iGFlag == 0){
						sqlStr.append(" Select rowId row_id, es_group_code code, es_group_desc description from cr_es_group_header where es_group_flag = 1 and upper(es_group_type) = upper('"+sSubGroupType+"')");
						if (!searchText.equals("")){
							sqlStr.append(" and upper(es_group_desc) like upper('"+searchText+"%') and");
						}						
					}
					else
					{
						sqlStr.append("select rownum row_id, event_code code, short_desc description from cr_event_hist_rec_vw where hist_rec_type = '"+sSubGroupType+"' and language_id = '"+language+"' ");												
						if (!searchText.equals("")){
							sqlStr.append(" and ( upper(event_code) like upper('"+searchText+"%') or upper(short_desc) like upper('"+searchText+"%') ) and");
						}							
						/*
						if (sSubGroupType.equalsIgnoreCase("lbin"))
						{				
							sqlStr.append(" SELECT rowId row_id, test_code code, Long_desc description FROM rl_test_code");
							if ((!searchText.equals("")) || (!(sGroupType.equalsIgnoreCase("ug"))) || (!sRowId.equals(""))){
								sqlStr.append(" where ");
							}							
							if (!searchText.equals("")){
								sqlStr.append(" upper(Long_desc) like upper('"+searchText+"%') and");
							}							
							if (!(sGroupType.equalsIgnoreCase("ug")))
							{
								sqlStr.append(" test_code in (Select test_code from RL_GROUP_TEST_DETAIL where group_test_code = '"+sGroupCode+"') and");
							}							
						}
						if (sSubGroupType.equalsIgnoreCase("rdin"))
						{
							
						}
						*/
					}	
					/*
					if (!sRowId.equals("")){
						sqlStr.append(" rownum in("+sRowId+") ");
					}
					*/
					String sqlString = sqlStr.toString();
					
					if (sqlString.endsWith("and"))
					{
						sqlString = sqlString.substring(0,sqlString.lastIndexOf("and"));
						
					}
					
					System.out.println(" - - - Group Comp sql- - - "+sqlString);
					
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlString);
					
					if (pageCount > 1) {
						absoluteCount = (pageCount - 1) * rowCount;
						resultSet.absolute(absoluteCount);
						System.out.println(" - - - absoluteCount- - - "+absoluteCount);
					}
					
					while ( resultSet != null && resultSet.next() ) {
						EncSummCompBean sCompsBean = new EncSummCompBean();						
						sCompsBean.setsSubGroupType(sGroupType);
						sCompsBean.setsRowId(((resultSet.getString("row_id") != null) ?resultSet.getString("row_id") : ""));
						sCompsBean.setsCompCode(((resultSet.getString("code") != null) ?resultSet.getString("code") : "")) ;
						sCompsBean.setsLongDesc(((resultSet.getString("description") != null) ?resultSet.getString("description") : "")) ;
						
						sSummCompList.add(sCompsBean);
	
					}
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;	
				if ( ps != null ) ps.close() ;
				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);

		}		
		return sSummCompList;
	}
	
	/*
	 * Get the list of Summary details available
	 */
	public List<EncSummGroupSummBean> getSummaryDetails(EncSummGroupSummBean sGroupSummBean) throws Exception {
		List<EncSummGroupSummBean> sSummGrpSummList = new ArrayList<EncSummGroupSummBean>() ;
		
		String sSummCode = "";
		
		sSummCode = sGroupSummBean.getsSummCode();
		
		if(sSummCode != null )
		{
			Connection connection 		= null;
			Statement stmt				= null;
			ResultSet resultSet 		= null;

			StringBuffer sqlStr = new StringBuffer("");
			
			HttpServletRequest request = sGroupSummBean.request;			
			
			sqlStr.append(" select es_summ_code, es_summ_desc, es_summ_title, es_summ_status, es_summ_type  ");
			sqlStr.append(" from cr_es_summ_hdr ");
			sqlStr.append(" where es_summ_code = '"+sSummCode+"'");
				
			try {
				    connection	= ConnectionManager.getConnection(request) ;
					if(connection != null)
					{
						stmt = connection.createStatement();
					}				
					
					System.out.println(" - - - Summary Details available: "+sqlStr.toString());
					if(stmt != null)
						resultSet = stmt.executeQuery(sqlStr.toString());
					while ( resultSet != null && resultSet.next() ) {

						EncSummGroupSummBean sSummGroupSumm = new EncSummGroupSummBean();
						sSummGroupSumm.setsSummCode(sSummCode);
						
						sSummGroupSumm.setsSummDesc(((resultSet.getString("es_summ_desc") != null) ? resultSet.getString("es_summ_desc") : "")) ;
						sSummGroupSumm.setsSummTitle(((resultSet.getString("es_summ_title") != null) ? resultSet.getString("es_summ_title") : "")) ;
						sSummGroupSumm.setsSummStatus(resultSet.getString("es_summ_status")) ;
						sSummGroupSumm.setsSummType(((resultSet.getString("es_summ_type") != null) ? resultSet.getString("es_summ_type") : "")) ;

						sSummGrpSummList.add(sSummGroupSumm);

				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( stmt != null ) stmt.close() ;
					 ConnectionManager.returnConnection(connection,request);

			}

		}
		return sSummGrpSummList;
	}
	
	/*
	 * Get the list of Groups to be added for the Summary
	 */
	public List<EncSummConfigGroupBean> getSummaryConfigAddGroups (EncSummConfigGroupBean sConfigGroupBean) throws Exception {
		List<EncSummConfigGroupBean> sSummConfigGroupList = new ArrayList<EncSummConfigGroupBean>() ;	
		
		Connection connection = null;		
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;

		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = sConfigGroupBean.request;	
		
		String sGroupType = "";			
		String sRowId = "";
		String searchText = "", sSummaryCode = "";
		
		int iGFlag = sConfigGroupBean.getiGroupFlag();		
		sGroupType = sConfigGroupBean.getsGroupType();		
		sRowId = sConfigGroupBean.getsRowId();
		searchText = sConfigGroupBean.getsSearchText();
		sSummaryCode = sConfigGroupBean.getsSummaryCode();
		
		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{					
					stmt = connection.createStatement();
				}							
				
				sqlStr.append(" Select rowId row_id, es_group_flag, es_group_type, es_group_code code, es_group_desc description, 'N' valid from cr_es_group_header " +
						"where es_group_flag = 0 and upper(es_group_type) = upper('"+sGroupType+"') and ");				
				sqlStr.append("es_group_code not in (Select es_group_code from cr_es_summ_dtl where ES_SUMM_CODE = '"+sSummaryCode+"' and es_group_flag = 0 and upper(es_group_type) = upper('"+sGroupType+"')) ");
				
				if (!searchText.equals("")){
					sqlStr.append(" and ( upper(es_group_code) like upper('"+searchText+"%') or upper(es_group_desc) like upper('"+searchText+"%') )");
				}									
				if (!sRowId.equals("")){
					sqlStr.append(" and rowId in("+sRowId+") ");
				}
				
				sqlStr.append(" union Select rowId row_id, es_group_flag, es_group_type, es_group_code code, es_group_desc description, 'Y' valid  from cr_es_group_header " +
						"where es_group_flag = 0 and upper(es_group_type) = upper('"+sGroupType+"') and ");				
				sqlStr.append("es_group_code in (Select es_group_code from cr_es_summ_dtl where ES_SUMM_CODE = '"+sSummaryCode+"' and es_group_flag = 0 and upper(es_group_type) = upper('"+sGroupType+"')) ");
				
				if (!searchText.equals("")){
					sqlStr.append(" and ( upper(es_group_code) like upper('"+searchText+"%') or upper(es_group_desc) like upper('"+searchText+"%') )");
				}									
				if (!sRowId.equals("")){
					sqlStr.append(" and rowId in("+sRowId+") ");
				}				
				
				String sqlString = sqlStr.toString();
				
				if (sqlString.endsWith("and"))
				{
					sqlString = sqlString.substring(0,sqlString.lastIndexOf("and"));					
				}
				
				System.out.println(" - - - Summary - Groups to be added SQL: "+sqlString);
				
				if(stmt != null)
					resultSet = stmt.executeQuery(sqlString);
				while ( resultSet != null && resultSet.next() ) {
					EncSummConfigGroupBean sConfigGroupsBean = new EncSummConfigGroupBean();
					sConfigGroupsBean.setsRowId(((resultSet.getString("row_id") != null) ?resultSet.getString("row_id") : ""));
					sConfigGroupsBean.setiGroupFlag(iGFlag);
					sConfigGroupsBean.setsGroupType(((resultSet.getString("es_group_type") != null) ?resultSet.getString("es_group_type") : ""));					
					sConfigGroupsBean.setsGroupCode(((resultSet.getString("code") != null) ?resultSet.getString("code") : "")) ;
					sConfigGroupsBean.setsGroupDesc(((resultSet.getString("description") != null) ?resultSet.getString("description") : "")) ;
					sConfigGroupsBean.setsValid(((resultSet.getString("valid") != null) ?resultSet.getString("valid") : "")) ;
					sSummConfigGroupList.add(sConfigGroupsBean);	
				}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);
		}		
		return sSummConfigGroupList;
	}
	
	/*
	 * Get the list of Summary - Groups added for the Summary
	 */
	public List<EncSummConfigGroupBean> getSummaryConfigAddedGroups (EncSummConfigGroupBean sConfigGroupBean) throws Exception {
		List<EncSummConfigGroupBean> sSummConfigGroupList = new ArrayList<EncSummConfigGroupBean>() ;	
		
		Connection connection = null;		
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;
		
		boolean whereFlag = false;

		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = sConfigGroupBean.request;	
		
		String sSummaryCode = "", sSummaryDesc = "", sGroupCode = "", sGroupDesc = "";	
		int iGflag = 0;
		
		sSummaryCode = ((sConfigGroupBean.getsSummaryCode() != null) ? sConfigGroupBean.getsSummaryCode() : ""); 
		sSummaryDesc = ((sConfigGroupBean.getsSummaryDesc() != null) ? sConfigGroupBean.getsSummaryDesc() : "");
		sGroupCode = ((sConfigGroupBean.getsGroupCode() != null) ? sConfigGroupBean.getsGroupCode() : "");
		sGroupDesc = ((sConfigGroupBean.getsGroupDesc() != null) ? sConfigGroupBean.getsGroupDesc() : "");		
		
		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{					
					stmt = connection.createStatement();
				}							
				
				sqlStr.append(" select es_summ_code, es_group_flag, es_group_type, es_group_code, es_group_seq, es_group_desc, es_summ_desc from vw_es_summ_group ");
				
				if (!sSummaryCode.equals("")){
					sqlStr.append(" where ");
					sqlStr.append("  upper(es_summ_code) like upper('"+sSummaryCode+"%') and");
					whereFlag = true;
				}
				
				if (!sSummaryDesc.equals("")){
					if (!whereFlag)
						sqlStr.append(" where ");
					
					sqlStr.append("  upper(es_summ_desc) like upper('"+sSummaryDesc+"%') and");
				}
				
				if (!sGroupCode.equals("")){
					if (!whereFlag)
						sqlStr.append(" where ");
					
					sqlStr.append("  upper(es_group_code) like upper('"+sGroupCode+"%') and");
				}
				
				if (!sGroupDesc.equals("")){
					if (!whereFlag)
						sqlStr.append(" where ");
					
					sqlStr.append("  upper(es_group_desc) like upper('"+sGroupDesc+"%') ");
				}				
				
				String sqlString = sqlStr.toString();
				
				if (sqlString.endsWith("and"))
				{
					sqlString = sqlString.substring(0,sqlString.lastIndexOf("and"));					
				}
				
				System.out.println(" - - - Summary - Groups Added SQL: "+sqlString);
				
				if(stmt != null)
					resultSet = stmt.executeQuery(sqlString);
				while ( resultSet != null && resultSet.next() ) {
					EncSummConfigGroupBean sConfigGroupsBean = new EncSummConfigGroupBean();
					iGflag = resultSet.getInt("es_group_flag");
					sConfigGroupsBean.setsSummaryCode(((resultSet.getString("es_summ_code") != null) ?resultSet.getString("es_summ_code") : ""));
					sConfigGroupsBean.setiGroupFlag(iGflag);
					sConfigGroupsBean.setsGroupType(((resultSet.getString("es_group_type") != null) ?resultSet.getString("es_group_type") : ""));					
					sConfigGroupsBean.setsGroupCode(((resultSet.getString("es_group_code") != null) ?resultSet.getString("es_group_code") : ""));
					sConfigGroupsBean.setsGroupDesc(((resultSet.getString("es_group_desc") != null) ?resultSet.getString("es_group_desc") : ""));
					sConfigGroupsBean.setiSequence(resultSet.getInt("es_group_seq")) ;
					sConfigGroupsBean.setsSummaryDesc(((resultSet.getString("es_summ_desc") != null) ?resultSet.getString("es_summ_desc") : ""));
					sSummConfigGroupList.add(sConfigGroupsBean);	
				}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);
		}		
		return sSummConfigGroupList;
	}
	
	/*
	 * Get the list of Patient Class Details required for Summary Applicability
	 */
	public List<PatientClassBean> getPatientClass (PatientClassBean patientClassBean) throws Exception {
		List<PatientClassBean> sPatientClassList = new ArrayList<PatientClassBean>() ;	
		
		Connection connection = null;		
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;
		
		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = patientClassBean.request;	
		
		int iPrefix = 0;
		
		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{					
					stmt = connection.createStatement();
				}							
				
				sqlStr.append(" select patient_class, long_desc, short_desc, prefix_no from am_patient_class order by short_desc ");
				
				
				String sqlString = sqlStr.toString();
				
				System.out.println(" - - - Patient Class SQL: "+sqlString);
				
				if(stmt != null)
					resultSet = stmt.executeQuery(sqlString);
				while ( resultSet != null && resultSet.next() ) {
					PatientClassBean sPatientClassBean = new PatientClassBean();					
					sPatientClassBean.setsPatientClass(((resultSet.getString("patient_class") != null) ?resultSet.getString("patient_class") : ""));					
					sPatientClassBean.setsLongDesc(((resultSet.getString("long_desc") != null) ?resultSet.getString("long_desc") : ""));					
					sPatientClassBean.setsShortDesc(((resultSet.getString("short_desc") != null) ?resultSet.getString("short_desc") : ""));		
					iPrefix = resultSet.getInt("prefix_no");
					sPatientClassBean.setiPrefix(iPrefix);
					sPatientClassList.add(sPatientClassBean);	
				}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);
		}		
		return sPatientClassList;
	}	
	
	/*
	 * Get the list of Patient Encounter Details 
	 */
	public List<PatientEncounterBean> getPatientEncounter (PatientEncounterBean patientEncBean) throws Exception {
		List<PatientEncounterBean> sPatientEncList = new ArrayList<PatientEncounterBean>() ;	
		
		Connection connection = null;		
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;
		
		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = patientEncBean.request;	
		
		String sPatientId = "", sEncounterId = "", sSpecialty = "", sLocationType = "", sLocation = "", sPractitionerId = "", sGender = "", sVisitDate = "";		
		
		sPatientId = ((patientEncBean.getsPatientID() != null) ? patientEncBean.getsPatientID() : ""); 
		sEncounterId = ((patientEncBean.getsEncounterID() != null) ? patientEncBean.getsEncounterID() : ""); 
		sSpecialty = 	((patientEncBean.getsSpecialtyCode() != null) ? patientEncBean.getsSpecialtyCode() : ""); 	
		sLocationType = ((patientEncBean.getsCareLocnType() != null) ? patientEncBean.getsCareLocnType() : ""); 
		sLocation = ((patientEncBean.getsCareLocnCode() != null) ? patientEncBean.getsCareLocnCode() : ""); 
		sVisitDate = ((patientEncBean.getsVisitDateTime() != null) ? patientEncBean.getsVisitDateTime() : "");
		sPractitionerId = ((patientEncBean.getsPractID() != null) ? patientEncBean.getsPractID() : ""); 
		sGender = ((patientEncBean.getsGender() != null) ? patientEncBean.getsGender() : ""); 
		
		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{					
					stmt = connection.createStatement();
				}							
				
				sqlStr.append(" select patient_id,episode_type, episode_id, to_char(adm_visit_date,'dd/mm/yyyy') adm_visit_date, splty_code, splty_name, locn_type, locn_code, locn_name, sex, physician_id, physician_name, patient_name, chief_complaint from ca_patient_encounter_vw ");
				sqlStr.append(" where episode_type in ('I','O') ");
				
				if (!sPatientId.equals("")){
					sqlStr.append(" and patient_id = '"+sPatientId+"' ");
				}	
				if (!sEncounterId.equals("")){
					sqlStr.append(" and episode_id = '"+sEncounterId+"' ");
				}	
				if (!sSpecialty.equals("")){
					sqlStr.append(" and upper(splty_code) = upper('"+sSpecialty+"') ");
				}	
				if (!sLocationType.equals("")){
					sqlStr.append(" and upper(locn_type) = upper('"+sLocationType+"') ");
				}	
				if (!sLocation.equals("")){
					sqlStr.append(" and upper(locn_code) = upper('"+sLocation+"') ");
				}
				if (!sVisitDate.equals("")){
					sqlStr.append(" and trunc(adm_visit_date) = to_date('"+sVisitDate+"','dd/mm/yyyy' ) ");
					//sqlStr.append(" and trunc(adm_visit_date) = to_date('04/09/2011','dd/mm/yyyy' ) ");
				}
				if (!sPractitionerId.equals("")){
					sqlStr.append(" and upper(physician_id) = upper('"+sPractitionerId+"') ");
				}	
				if (!sGender.equals("")){
					sqlStr.append(" and upper(sex) = upper('"+sGender+"') ");
				}	
				
				sqlStr.append(" order by splty_code, locn_code, adm_visit_date desc ");
				
				String sqlString = sqlStr.toString();				
				
				System.out.println(" - - - Patient Encounter SQL: "+sqlString);
				
				if(stmt != null)
					resultSet = stmt.executeQuery(sqlString);
				while ( resultSet != null && resultSet.next() ) {
					PatientEncounterBean sPatientEncBean = new PatientEncounterBean();					
					sPatientEncBean.setsPatientID(((resultSet.getString("patient_id") != null) ?resultSet.getString("patient_id") : ""));					
					sPatientEncBean.setsEncounterID(((resultSet.getString("episode_id") != null) ?resultSet.getString("episode_id") : ""));					
					sPatientEncBean.setsPatientClass(((resultSet.getString("episode_type") != null) ?resultSet.getString("episode_type") : ""));	
					sPatientEncBean.setsVisitDateTime(((resultSet.getString("adm_visit_date") != null) ?resultSet.getString("adm_visit_date") : ""));					
					sPatientEncBean.setsSpecialtyCode(((resultSet.getString("splty_code") != null) ?resultSet.getString("splty_code") : ""));					
					sPatientEncBean.setsSpecialtyDesc(((resultSet.getString("splty_name") != null) ?resultSet.getString("splty_name") : ""));
					sPatientEncBean.setsCareLocnType(((resultSet.getString("locn_type") != null) ?resultSet.getString("locn_type") : ""));					
					sPatientEncBean.setsCareLocnCode(((resultSet.getString("locn_code") != null) ?resultSet.getString("locn_code") : ""));					
					sPatientEncBean.setsCareLocnDesc(((resultSet.getString("locn_name") != null) ?resultSet.getString("locn_name") : ""));
					sPatientEncBean.setsGender(((resultSet.getString("sex") != null) ?resultSet.getString("sex") : ""));					
					sPatientEncBean.setsPractID(((resultSet.getString("physician_id") != null) ?resultSet.getString("physician_id") : ""));					
					sPatientEncBean.setsPractName(((resultSet.getString("physician_name") != null) ?resultSet.getString("physician_name") : ""));
					sPatientEncBean.setsPatientName(((resultSet.getString("patient_name") != null) ?resultSet.getString("patient_name") : ""));
					sPatientEncList.add(sPatientEncBean);	
				}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);
		}		
		return sPatientEncList;
	}	
	
	/*
	 * Get the list of Specialty Masters
	 */
	public List<SpecialityMasterBean> getSpecialtyMaster (SpecialityMasterBean specialtyMasterBean) throws Exception {
		List<SpecialityMasterBean> sSpecialtyMasterList = new ArrayList<SpecialityMasterBean>() ;	
		
		Connection connection = null;		
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;
		
		String sLocale = "", sFacilityId = "", sLoginUser = "", sOperStnId = "";
		
		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = specialtyMasterBean.request;	
		sLocale = specialtyMasterBean.getsLocale();
		sFacilityId = specialtyMasterBean.getsFacilityId();
		sLoginUser = specialtyMasterBean.getsLoginId();
		sOperStnId = specialtyMasterBean.getsOperStnId();
		
		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{					
					stmt = connection.createStatement();
				}							
				
				sqlStr.append(" SELECT a.service_code  speciality_code, a.short_desc short_desc FROM am_service_lang_vw a  WHERE a.eff_status = 'E' and language_id = '"+sLocale+"'   " +
						" AND a.service_code IN (SELECT b.service_code FROM op_clinic b, am_os_user_locn_access_vw c  WHERE b.facility_id = '"+sFacilityId+"' " +
													" AND b.facility_id = c.facility_id  AND b.clinic_code = c.locn_code and b.CLINIC_TYPE=c.locn_type AND " +
													" a.service_code = b.service_code	 and c.appl_user_id = '"+sLoginUser+"' and c.oper_stn_id = '"+sOperStnId+"') " +
						" order by 2 ");
				
				
				String sqlString = sqlStr.toString();
				
				System.out.println(" - - - Specialty Master SQL: "+sqlString);
				
				if(stmt != null)
					resultSet = stmt.executeQuery(sqlString);
				while ( resultSet != null && resultSet.next() ) {
					SpecialityMasterBean sSpecialtyMasterBean = new SpecialityMasterBean();					
					sSpecialtyMasterBean.setsSpecialtyCode(((resultSet.getString("speciality_code") != null) ?resultSet.getString("speciality_code") : ""));					
					sSpecialtyMasterBean.setsSpecialtyShortDesc(((resultSet.getString("short_desc") != null) ?resultSet.getString("short_desc") : ""));		
					sSpecialtyMasterBean.setsFacilityId(sFacilityId);
					sSpecialtyMasterBean.setsLocale(sLocale);
					sSpecialtyMasterBean.setsLoginId(sLoginUser);
					sSpecialtyMasterBean.setsOperStnId(sOperStnId);
					sSpecialtyMasterList.add(sSpecialtyMasterBean);	
				}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);
		}		
		return sSpecialtyMasterList;
	}	
	
	/*
	 * Get the list of Location Type Masters
	 */
	public List<LocationTypeMasterBean> getLocationTypeMaster (LocationTypeMasterBean locationTypeBean) throws Exception {
		List<LocationTypeMasterBean> sLocationTypeList = new ArrayList<LocationTypeMasterBean>() ;	
		
		Connection connection = null;		
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;
		
		String sLocale = "";
		
		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = locationTypeBean.request;	
		sLocale = locationTypeBean.getsLocale();

		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{					
					stmt = connection.createStatement();
				}							
				
				sqlStr.append(" select locn_type, short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E','N') and SYS_USER_DEF_IND='S' and language_id='"+sLocale+"' order by short_desc "); 

				String sqlString = sqlStr.toString();
				
				System.out.println(" - - - Location Type Master SQL: "+sqlString);
				
				if(stmt != null)
					resultSet = stmt.executeQuery(sqlString);
				while ( resultSet != null && resultSet.next() ) {
					LocationTypeMasterBean sLocationTypeBean = new LocationTypeMasterBean();					
					sLocationTypeBean.setsLocationType(((resultSet.getString("locn_type") != null) ?resultSet.getString("locn_type") : ""));					
					sLocationTypeBean.setsLocationShortDesc(((resultSet.getString("short_desc") != null) ?resultSet.getString("short_desc") : ""));		
					sLocationTypeBean.setsLocale(sLocale);
					sLocationTypeList.add(sLocationTypeBean);	
				}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);
		}		
		return sLocationTypeList;
	}	
	/*
	 * Get the list of Location Type Masters
	 */
	public List<LoginUserBean> getLoginOperID (LoginUserBean loginUsereBean) throws Exception {
		List<LoginUserBean> sloginUserList = new ArrayList<LoginUserBean>() ;	
		
		Connection connection = null;		
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;
		
		String sFacilityID = "", sLoginID = "";
		
		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = loginUsereBean.request;	
		sFacilityID = loginUsereBean.getsFacilityID();
		sLoginID = loginUsereBean.getsLoginUserId();

		try {
			    connection	= ConnectionManager.getConnection(request) ;
				if(connection != null)
				{					
					stmt = connection.createStatement();
				}							
				
				sqlStr.append(" select AM_OPER_STN_ACCESS_CHECK('"+sFacilityID+"','"+sLoginID+"','X','','MANAGE_QUEUE_YN') OperId, (Select patient_id_length from mp_param where module_id = 'MP') pat_id_length "); 
				sqlStr.append(" from op_param where operating_facility_id='"+sFacilityID+"' ");

				String sqlString = sqlStr.toString();
				
				System.out.println(" - - - Login User Operator Station SQL: "+sqlString);
				
				if(stmt != null)
					resultSet = stmt.executeQuery(sqlString);
				while ( resultSet != null && resultSet.next() ) {
					LoginUserBean sLoginUserBean = new LoginUserBean();					
					sLoginUserBean.setsOperStnID(((resultSet.getString("OperId") != null) ?resultSet.getString("OperId") : ""));					
					sLoginUserBean.setsFacilityID(sFacilityID);		
					sLoginUserBean.setsLoginUserId(sLoginID);
					sloginUserList.add(sLoginUserBean);	
				}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);
		}		
		return sloginUserList;
	}
	
	/*
	 * Get the Encounter Summary Layout Header
	 */
	public List<EncSummLayoutHdrBean> getLayoutHeader (EncSummLayoutHdrBean layoutHdrBean) throws Exception {
		List<EncSummLayoutHdrBean> sLayoutHdrList = new ArrayList<EncSummLayoutHdrBean>() ;	
		
		Connection connection = null;		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;
		
		String sqlString = "";
		String summaryCode = "";
		
		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = layoutHdrBean.request;	

		try {
				summaryCode = layoutHdrBean.getsSummaryCode();
				
			    connection	= ConnectionManager.getConnection(request) ;
				
				sqlStr.append("Select a.es_summ_code, es_summ_title, es_header_orient, es_colors_indicate, es_tbl_cell_color_fill, es_tbl_cell_bborder_fill, es_footer_sign_flag, "); 
				sqlStr.append("es_footer_sign_posn, es_footer_sign_1_flag, es_footer_sign_1_label, es_footer_sign_1_practid, es_footer_sign_1_splty, ");
				sqlStr.append("es_footer_sign_2_flag, es_footer_sign_2_label, es_footer_sign_2_practid, es_footer_sign_2_splty, ");
				sqlStr.append("es_footer_sign_3_flag, es_footer_sign_3_label, es_footer_sign_3_practid, es_footer_sign_3_splty, ");
				sqlStr.append("es_footer_digital_sig, es_header_code, es_footer_code ");
				sqlStr.append("from cr_es_summ_hdr a, cr_es_summ_layout_hdr b ");				
				sqlStr.append("where a.es_summ_code = b.es_summ_code ");
				sqlStr.append(" and a.es_summ_code = ? ");
		        
				sqlString = sqlStr.toString();
				
				if(connection != null)
				{	
					stmt = connection.prepareStatement(sqlString);					
				}
				
				System.out.println(" - - - Encounter Summary Layout Header SQL: "+sqlString+" ::: "+summaryCode);
				
				if(stmt != null)
				{
					stmt.setString( 1, summaryCode );
					resultSet = stmt.executeQuery();
				}
				
				while ( resultSet != null && resultSet.next() ) {
					EncSummLayoutHdrBean sLayoutHdrBean = new EncSummLayoutHdrBean();	
					sLayoutHdrBean.setsSummaryCode(((resultSet.getString("es_summ_code") != null) ? resultSet.getString("es_summ_code") : ""));
					sLayoutHdrBean.setsSummaryDesc(((resultSet.getString("es_summ_title") != null) ? resultSet.getString("es_summ_title") : ""));
					sLayoutHdrBean.setiHeaderOrient(resultSet.getInt("es_header_orient"));
					
					sLayoutHdrBean.setiColorsIndicate(resultSet.getInt("es_colors_indicate"));
					sLayoutHdrBean.setiTabcellColFill(resultSet.getInt("es_tbl_cell_color_fill"));
					sLayoutHdrBean.setiTabCellBorFill(resultSet.getInt("es_tbl_cell_bborder_fill"));
					sLayoutHdrBean.setiFooterSignFlag(resultSet.getInt("es_footer_sign_flag"));
					sLayoutHdrBean.setiFooterSignPosn(resultSet.getInt("es_footer_sign_posn"));
					sLayoutHdrBean.setiFooterSign1Flag(resultSet.getInt("es_footer_sign_1_flag"));
					sLayoutHdrBean.setsFooterSign1Lbl(((resultSet.getString("es_footer_sign_1_label") != null) ? resultSet.getString("es_footer_sign_1_label") : ""));
					sLayoutHdrBean.setiFooterSign1PractID(resultSet.getInt("es_footer_sign_1_practid"));
					sLayoutHdrBean.setiFooterSign1Splty(resultSet.getInt("es_footer_sign_1_splty"));
					sLayoutHdrBean.setiFooterSign2Flag(resultSet.getInt("es_footer_sign_2_flag"));
					sLayoutHdrBean.setsFooterSign2Lbl(((resultSet.getString("es_footer_sign_2_label") != null) ? resultSet.getString("es_footer_sign_2_label") : ""));
					sLayoutHdrBean.setiFooterSign2PractID(resultSet.getInt("es_footer_sign_2_practid"));
					sLayoutHdrBean.setiFooterSign2Splty(resultSet.getInt("es_footer_sign_2_splty"));
					sLayoutHdrBean.setiFooterSign3Flag(resultSet.getInt("es_footer_sign_3_flag"));
					sLayoutHdrBean.setsFooterSign3Lbl(((resultSet.getString("es_footer_sign_3_label") != null) ? resultSet.getString("es_footer_sign_3_label") : ""));
					sLayoutHdrBean.setiFooterSign3PractID(resultSet.getInt("es_footer_sign_3_practid"));
					sLayoutHdrBean.setiFooterSign3Splty(resultSet.getInt("es_footer_sign_3_splty"));
					sLayoutHdrBean.setiFooterDigitSign(resultSet.getInt("es_footer_digital_sig"));
					sLayoutHdrBean.setsHeaderCode(((resultSet.getString("es_header_code") != null) ? resultSet.getString("es_header_code") : ""));
					sLayoutHdrBean.setsFooterCode(((resultSet.getString("es_footer_code") != null) ? resultSet.getString("es_footer_code") : ""));
					sLayoutHdrList.add(sLayoutHdrBean);	
				}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);
		}		
		return sLayoutHdrList;
	}	
	
	/*
	 * Get the Encounter Summary Layout Fields
	 */
	public List<EncSummLayoutFieldsBean> getLayoutDetails (EncSummLayoutFieldsBean layoutFieldsBean) throws Exception {
		List<EncSummLayoutFieldsBean> sLayoutFieldsList = new ArrayList<EncSummLayoutFieldsBean>() ;	
		
		Connection connection = null;		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ResultSet resultSet = null;
		
		String sqlString = "";
		String summaryCode = "";
		
		StringBuffer sqlStr = new StringBuffer("");
		
		HttpServletRequest request = layoutFieldsBean.request;	

		try {
				summaryCode = layoutFieldsBean.getsSummaryCode();
				
			    connection	= ConnectionManager.getConnection(request) ;
			    
			    System.out.println(" - - - Summary Code: "+summaryCode);
				
				sqlStr.append("Select nvl(c.es_field_id, b.es_field_id) es_field_id , es_field_name, nvl(c.es_field_flag,b.es_field_flag) es_field_flag, "); 
				sqlStr.append("nvl(c.es_field_orient, b.es_field_orient) es_field_orient , nvl(c.es_field_lbl, b.es_field_lbl) es_field_lbl, ");
				sqlStr.append("nvl(c.es_field_format, b.es_field_format) es_field_format, es_field_type ");
				sqlStr.append("from cr_es_summ_fields  b,  cr_es_summ_layout_fields c ");
				sqlStr.append("where ");
				sqlStr.append(" b.es_field_id = c.es_field_id(+) ");				
				sqlStr.append(" and c.es_summ_code(+) = ? ");  
		        sqlStr.append(" order by  ES_FIELD_NUM ");

				sqlString = sqlStr.toString();
				
				if(connection != null)
				{	
					stmt = connection.prepareStatement(sqlString);					
				}
				
				System.out.println(" - - - Encounter Summary Layout Fields SQL: "+sqlString);
				
				if(stmt != null)
				{
					stmt.setString( 1, summaryCode ) ;
					resultSet = stmt.executeQuery();
				}
				
				while ( resultSet != null && resultSet.next() ) {
					EncSummLayoutFieldsBean sLayoutFieldsBean = new EncSummLayoutFieldsBean();	
					sLayoutFieldsBean.setsSummaryCode(summaryCode);
					sLayoutFieldsBean.setsFieldId(((resultSet.getString("es_field_id") != null) ? resultSet.getString("es_field_id") : ""));					
					sLayoutFieldsBean.setsFieldName(((resultSet.getString("es_field_name") != null) ? resultSet.getString("es_field_name") : ""));
					sLayoutFieldsBean.setiFieldFlag(resultSet.getInt("es_field_flag"));
					sLayoutFieldsBean.setiFieldOrient(resultSet.getInt("es_field_orient"));
					sLayoutFieldsBean.setsFieldLabel(((resultSet.getString("es_field_lbl") != null) ? resultSet.getString("es_field_lbl") : ""));
					sLayoutFieldsBean.setsFieldFormat(((resultSet.getString("es_field_format") != null) ? resultSet.getString("es_field_format") : ""));
					sLayoutFieldsBean.setsFieldType(((resultSet.getString("es_field_type") != null) ? resultSet.getString("es_field_type") : ""));
					
					sLayoutFieldsList.add(sLayoutFieldsBean);	
				}
				
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				if ( rs != null ) rs.close() ;				
				if ( resultSet != null ) resultSet.close() ;	
				if ( stmt != null ) stmt.close() ;
				
				ConnectionManager.returnConnection(connection,request);
		}		
		return sLayoutFieldsList;
	}	
	
	
}
