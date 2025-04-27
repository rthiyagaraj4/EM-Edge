/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
-------------------------------------------------------------------------------------------------------------------------------
14/12/2013	  IN042552		 Karthi L	 To maintain Patient's event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)
27/12/2013	  IN046060		Karthi L	System does not list the Events for Monitoring History type & CA Event Type	
28/2/2022                   Pranay    Common-ICN-0092
-------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import eCommon.Common.*;
import webbeans.eCommon.*; 


public class CAConfidentialitySetUpBean extends CommonAdapter implements java.io.Serializable  {

	String confidntType;
	String result_data_code;
	String view_list_data;
	String view_by_data;
	String based_on_data;
	String ctnChkBox;
	HashMap confidentialityMapData ;	
	ArrayList keyConfidentDataArrayList;
	
	public ArrayList getKeyConfidentDataArrayList() {
		return keyConfidentDataArrayList;
	}

	public void setKeyConfidentDataArrayList(ArrayList keyConfidentDataArrayList) {
		this.keyConfidentDataArrayList = keyConfidentDataArrayList;
	}

	public HashMap getConfidentialityMapData() {
		return confidentialityMapData;
	}

	public void setConfidentialityMapData(HashMap confidentialityMapData) {
		this.confidentialityMapData = confidentialityMapData;
	}

	public ArrayList getEventCodes(String histType, String eventType, String locale) throws Exception {
		Connection connection 		= null;	
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList allEventCode =  new ArrayList();

		String histTypeQuery = "";

		if(histType.equalsIgnoreCase("PTCR")){
			histTypeQuery = "SELECT distinct B.SHORT_DESC, B.DISCR_MSR_ID FROM OR_ORDER_CATALOG A, AM_DISCR_MSR_LANG_VW B WHERE CHART_RESULT_TYPE = 'D' AND A.DISCR_MSR_PANEL_ID = B.DISCR_MSR_ID AND ORDER_CATEGORY = 'PC' AND ORDER_CATALOG_NATURE = 'A' AND B.RESULT_TYPE IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') AND LANGUAGE_ID = ? ORDER BY B.SHORT_DESC";
		}
		else if(histType.equalsIgnoreCase("TRET")){
			histTypeQuery = "SELECT distinct B.SHORT_DESC, B.DISCR_MSR_ID FROM OR_ORDER_CATALOG A, AM_DISCR_MSR_LANG_VW B WHERE CHART_RESULT_TYPE = 'D' AND A.DISCR_MSR_PANEL_ID = B.DISCR_MSR_ID AND ORDER_CATEGORY = 'TR' AND ORDER_CATALOG_NATURE = 'A' AND B.RESULT_TYPE IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') AND LANGUAGE_ID = ? ORDER BY B.SHORT_DESC";
		}
		else if(histType.equalsIgnoreCase("RDIN")){
			histTypeQuery = "SELECT distinct A.SHORT_DESC, A.CONTR_MSR_PANEL_ID FROM OR_ORDER_CATALOG_LANG_VW A WHERE ORDER_CATEGORY = 'RD' AND ORDER_CATALOG_NATURE = 'A' AND CONTR_MSR_PANEL_ID IS NOT NULL AND LANGUAGE_ID = ? ORDER BY A.SHORT_DESC";
		}
		else if(histType.equalsIgnoreCase("LBIN")){
			histTypeQuery = "SELECT distinct B.SHORT_DESC, B.DISCR_MSR_ID FROM OR_ORDER_CATALOG A, AM_DISCR_MSR_LANG_VW B WHERE CHART_RESULT_TYPE = 'D' AND A.DISCR_MSR_PANEL_ID = B.DISCR_MSR_ID AND ORDER_CATEGORY = 'LB' AND ORDER_CATALOG_NATURE = 'A' AND CONTR_MSR_PANEL_ID IS NULL AND B.RESULT_TYPE IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') AND LANGUAGE_ID = ? UNION SELECT A.SHORT_DESC, A.CONTR_MSR_PANEL_ID FROM OR_ORDER_CATALOG_LANG_VW A WHERE ORDER_CATEGORY = 'LB' AND ORDER_CATALOG_NATURE = 'A' AND CONTR_MSR_PANEL_ID IS NOT NULL AND CONTR_MOD_ID = 'RL' AND LANGUAGE_ID = ? ORDER BY SHORT_DESC";
		}
		else if(histType.equalsIgnoreCase("BLTF")){
			histTypeQuery = "SELECT distinct A.SHORT_DESC, A.CONTR_MSR_PANEL_ID FROM OR_ORDER_CATALOG_LANG_VW A WHERE ORDER_CATEGORY = 'LB' AND ORDER_CATALOG_NATURE = 'A' AND CONTR_MSR_PANEL_ID IS NOT NULL AND CONTR_MOD_ID = 'BT' AND LANGUAGE_ID = ? ORDER BY A.SHORT_DESC";
		}
		else if(histType.equalsIgnoreCase("CLNT")){
			histTypeQuery = "SELECT a.NOTE_TYPE_DESC, A.NOTE_TYPE from CA_NOTE_TYPE A WHERE A.NOTE_GROUP_ID IN ( SELECT B.NOTE_GROUP FROM CA_NOTE_GROUP B WHERE B.APPL_TASK_ID='CLINICAL_NOTES') AND A.EFF_STATUS='E' order by a.NOTE_TYPE_DESC";
		}
		else if(histType.equalsIgnoreCase("NCIN")){
			histTypeQuery = "SELECT distinct b.short_desc, b.discr_msr_id   FROM or_order_catalog a, am_discr_msr_lang_vw b WHERE chart_result_type = 'D'      AND a.discr_msr_panel_id = b.discr_msr_id AND order_category = 'NC' AND order_catalog_nature IN ('A', 'P') AND b.result_type IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') AND LANGUAGE_ID = ? order by b.short_desc";
		}
		else if(histType.equalsIgnoreCase("RXIN")){
			histTypeQuery = "SELECT distinct  b.short_desc , b.discr_msr_id  FROM or_order_catalog a, am_discr_msr_lang_vw b WHERE chart_result_type = 'D' AND a.discr_msr_panel_id = b.discr_msr_id AND order_category = 'RX' AND order_catalog_nature IN ('A', 'P') AND b.result_type IN ('I', 'N', 'E', 'D', 'L', 'C', 'T', 'H') AND LANGUAGE_ID= ? order by b.short_desc";
		}
		else if(histType.equalsIgnoreCase("SUNT")){
			histTypeQuery = "SELECT distinct a.short_desc,  a.contr_msr_panel_id   FROM or_order_catalog_lang_vw a WHERE order_category = 'OT' AND order_catalog_nature = 'A'  AND contr_msr_panel_id IS NOT NULL AND contr_mod_id = 'OT' AND LANGUAGE_ID= ? order by a.short_desc";
		}		

		try {
			String[] record = null;
			connection =  ConnectionManager.getConnection();
			pstmt = connection.prepareStatement(histTypeQuery);
			if(!histType.equals("CLNT")) {
				pstmt.setString(1, locale);

				if(histType.equalsIgnoreCase("LBIN")){
					pstmt.setString(2, locale);
				}
			}
			resultSet = pstmt.executeQuery();
			while( resultSet != null && resultSet.next()){
				record = new String[2];
				record[0] = resultSet.getString(1);
				record[1] = resultSet.getString(2);
				allEventCode.add(record);	
			}
		}
		catch(Exception ex){
			System.err.println( "Error loading values from database" ) ;
			ex.getMessage();
			throw ex;
		}
		finally {
			if( resultSet != null) resultSet.close();
			if(pstmt !=null) pstmt.close();
			if(connection != null) connection.close();
		}
	return allEventCode;
	}
	/*
	 * Get contr system event codes
	 */
	public ArrayList getContSysCode(String histType) throws Exception {
		Connection connection 		= null;	
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		PreparedStatement selectExtImgStmt 	= null;
		ResultSet selectExtImgRset 		= null;
		
		String contSysQuery = null;
		String selectExtImgQuy = null;
		String[] record 			= null;
		ArrayList contSysCodes =  new ArrayList();
		
		try {
			contSysQuery = "SELECT MODULE_ID, EVENT_TYPE_DESC FROM CR_EVENT_TYPE_PARAM WHERE EVENT_TYPE = ? AND BUILD_CR_YN = 'Y' ORDER BY MODULE_ID ASC";
			selectExtImgQuy = "SELECT * FROM CA_EXT_APPL_DETAIL WHERE EXT_IMAGE_APPL_ID = 'IBARL'";
			
			connection =  ConnectionManager.getConnection();
			pstmt = connection.prepareStatement(contSysQuery);
			pstmt.setString(1, histType);
			
			selectExtImgStmt = connection.prepareStatement(selectExtImgQuy);
			selectExtImgRset = selectExtImgStmt.executeQuery();
			
			resultSet = pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next()){
				record = new String[2];
				record[0] = resultSet.getString(1);
				record[1] = resultSet.getString(2);
				contSysCodes.add(record);	
			}
			if(histType.equals("SUNT")) {
				if(record == null ) {
					record = new String[2];
					record[0] = "OT";
					record[1] = "Surgery & Procedure";
					contSysCodes.add(record);
				}
			}
			if(histType.equals("PTCR")) {
				if(record != null ) {
					if(!contSysCodes.contains("OR")) {
						record = new String[2];
						record[0] = "OR";
						record[1] = "Patient Care";
						contSysCodes.add(record);
					}	
				}
			}
			/*	Commented for IN046060
			if(histType.equals("NCIN")) {
				if(record != null ) {
					if(!contSysCodes.contains("CA")) {
						record = new String[2];
						record[0] = "CA";
						record[1] = "Monitoring";
						contSysCodes.add(record);
					}	
				}
			}
			*/
			if(histType.equals("LBIN")) {
				if(record != null) {
					if(!contSysCodes.contains("LB")) {
						if(selectExtImgRset.next()){
							record = new String[2];
							record[0] = "LB";
							record[1] = "Labaratory";
							contSysCodes.add(record);
						}
				
					}
				}	
			}
		}
		catch(Exception ex){
			System.err.println( "Error loading values from database" ) ;
			ex.getMessage();
			throw ex;
		}
		finally {
			if(resultSet !=null) resultSet.close();//Common-ICN-0092  
			if( selectExtImgRset != null) selectExtImgRset.close();
			if(pstmt !=null) pstmt.close();
			if( selectExtImgStmt != null) selectExtImgStmt.close();
			if(pstmt !=null) pstmt.close();
			if(connection != null) connection.close();
		}
		return contSysCodes;
	}
	public ArrayList getQueryResultPage (PageContext pageContext,HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup, int query_result_size ) throws Exception {
	        Connection connection       = null;
			req.setCharacterEncoding("UTF-8");
	        String[] orderbycolumns     = req.getParameterValues("orderbycolumns") ;

	        if(orderbycolumns == null)  
				orderbycolumns = new String[0] ;

	        if( !lookup && orderbycolumns.length>0 ) 
				setOrderby(orderbycolumns);

	        String from                 = req.getParameter( "from" ) ;
	        String to                   = req.getParameter( "to" ) ;
	        ArrayList displayFields     = (ArrayList)funcMap.get( "displayFields" ) ;
	        ArrayList chkFields         = (ArrayList)funcMap.get( "chkFields" ) ;
	        //String searchCriteria       = checkForNull( (String)funcMap.get( "searchCriteria" )) ;//Checkstyle
	        String sqlData              = (String)sqlMap.get( "sqlData" );
	        ArrayList error             = new ArrayList();
	        String prevnextlink         = "";
	       
	        StringBuilder msgsb = new StringBuilder();
	        int start = 0 ;
	        int end = 0 ;

	        if ( from == null )
	            start = 1 ;
	        else
	            start = Integer.parseInt( from  ) ;

	        if ( to == null )
	            end =query_result_size;
	        else
	            end = Integer.parseInt( to ) ;

	        PreparedStatement pstmtCount  =null;
	        PreparedStatement pstmtData = null;
	        ResultSet rs=null;
	       
	        ArrayList result = new ArrayList();
	        result.clear();
	        result.add("total");
	        result.add("prevnext");
	        try {
	            HttpSession session = req.getSession(false) ;
	            setProperties((java.util.Properties)session.getValue("jdbc")) ;

	            connection = ConnectionManager.getConnection();
	            int fldkey=1;
	            try {
	                msgsb.append( " SQL : "+sqlData );
	                msgsb.append( " Connection : " + connection );
	                if( !lookup && orderbycolumns.length>0 )
	                    pstmtData = connection.prepareStatement( sqlData + orderBy );
	                else
	                    pstmtData = connection.prepareStatement( sqlData );
						msgsb.append( " PreparedStatement : " + pstmtData);
	                for(int fldcount=0; fldcount<chkFields.size(); fldcount++) {
	                    Object fldValue = chkFields.get(fldcount) ;
					    if( fldValue instanceof String ) {
	                        if( !lookup )
	                          pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))) ;
	                        else {
	                           pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))) ;
	                        }
	                    }
	                    else if ( fldValue instanceof Integer )
	                        pstmtData.setInt( fldkey, ((Integer)fldValue).intValue() ) ;
	                    else if ( fldValue instanceof Long )
	                        pstmtData.setLong( fldkey, ((Long)fldValue).longValue() ) ;
	                    else if ( fldValue instanceof Float )
	                        pstmtData.setFloat( fldkey, ((Float)fldValue).floatValue() ) ;
	                    else if ( fldValue instanceof Double )
	                        pstmtData.setDouble( fldkey, ((Double)fldValue).doubleValue() ) ;
	                    fldkey++;
	                }//for
	                rs = null;
	                rs = pstmtData.executeQuery();
	                msgsb.append( "ResultSet : " + rs);
	                long count = 0;
	                long i = 0;

	                if( rs != null ) {
	                    while( rs.next() && i <= end+1 ) {
	                        if( start != 1 && (i+1) < start ) {
	                            i++;
	                            continue;
	                        }
	                        else i++;
	                        count++ ;
	                        if(i <= end ) {
	                            ArrayList records=new ArrayList();
	                            records.clear();
	                            for( int dispfldCount=0;  dispfldCount<displayFields.size();  dispfldCount++ )
	                                records.add(rs.getString((String)displayFields.get( dispfldCount )));
	                            result.add(records);
	                        }
	                    }
	                    result.set( 0, String.valueOf( count ) ) ;
	                    if( start != 1 )
	                        prevnextlink += "<td align=\"right\" nowrap><a href=\"javascript:SubmitLink("+(start-query_result_size)+","+(end-query_result_size)+");\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>" ;
	                    if( count > query_result_size )
	                        prevnextlink += "&nbsp;&nbsp;<td align=\"right\" nowrap><a href=\"javascript:SubmitLink("+(start+query_result_size)+","+(end+query_result_size)+");\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>" ;
	                    result.set( 1, prevnextlink ) ;
	                }

	            }catch(Exception ed) {
	                error.add("Exception from sqlData :" +ed.getMessage()+msgsb.toString() );
					System.err.println("CAConfidentialitySetUpBean.java,258 " + ed.getMessage());
					ed.printStackTrace();
	                result.add(error);
	            }
	        } catch(Exception ex) {
	                error.add(ex.getMessage());
	                result.add(error);
					System.err.println("CAConfidentialitySetUpBean.java,265 " +ex.getMessage());
					ex.printStackTrace();
	        } finally {
	            try{
	                if( rs != null ) rs.close() ;
	                if( pstmtData != null )  pstmtData.close();  ;
	                if( pstmtCount != null ) pstmtCount.close();  ;
	                if ( connection != null ) connection.close();  ;
	            } catch(Exception e) {
	                error.add(e.getMessage());
	                result.add(error);
					System.err.println("CAConfidentialitySetUpBean.java,258" + e.getMessage());
					e.printStackTrace();
	            }
	        }
	        return result;
	    }

	 /**
	 *
	 * @param ord
	 */
	  	private void setOrderby(String ord[]) {
	        if ( !(ord == null || ord .equals("")) ) {
	            orderBy=" order by ";
	            for ( int i=0;i < ord.length;i++ ) {
	                if ( i == ord.length - 1 ) {
	                    orderBy += ord[i];
	                } else {
	                    orderBy += ord[i]+",";
	                }
	            }//for
	        }//outer if
	    }//method end
	    /**
	    *
	    * @return
	    */
	  	private String getOrderby() {
	           return this.orderBy ;
	    }
	  	
	  	/**
	  	 *
	  	 * @param req               HttpServletRequest
	  	 * @param nextprevLink  Link text
	  	 * @param searched      Indicates whether search is executed ot not
	  	 * @return                  Constructed HTML String
	  	 */
	  	 public String setForm (HttpServletRequest req, String nextprevLink, boolean searched) throws Exception{

	  	        String queryform="<form name=\"confidentiality_search_result\" method=\"post\" action=\""+nextprevLink+"\" >"; // QueryForm
	  			req.setCharacterEncoding("UTF-8");
	  	        Enumeration paramnames =  req.getParameterNames();
	  	        while(paramnames.hasMoreElements()){
	  	            String str=(String)paramnames.nextElement();
	  	            if( !str.equals( "orderbycolumns" ) ) {
	  	                queryform+="<input type=\"hidden\" value=\""+req.getParameter(str)+"\" name=\""+str+"\">" ;
	  	            }
	  	        }
	  	        String[] orderbycolumns = req.getParameterValues("orderbycolumns") ;
	  	        if( orderbycolumns != null )
	  	            for(int i=0 ; i<orderbycolumns.length ; i++) {
	  	                queryform+="<input type=\"hidden\" value=\""+orderbycolumns[i]+"\" name=\"orderbycolumns\">" ;
	  	            }
	  	        if( !searched ) {
	  	            queryform += "<input type=\"hidden\" value=\"\" name=\"from\">" ;
	  	            queryform += "<input type=\"hidden\" value=\"\" name=\"to\">" ;
	  	            queryform += "<input type=\"hidden\" value=\"\" name=\"searched\">" ;
	  	        }
	  	        queryform += "</form>";
	  	        return queryform;
	  	}
	  	
	  	public HashMap setPaginateData(String a_ctnChkBox, String a_confidntType, String a_result_data_code, String a_view_list_data, String a_view_by_data, String a_based_on_data) throws Exception {
	  		confidntType 		= a_confidntType;
	  		result_data_code 	= a_result_data_code;
	  		view_list_data 		= a_view_list_data;
	  		view_by_data 		= a_view_by_data;
	  		based_on_data 		= a_based_on_data;
	  		ctnChkBox 			= a_ctnChkBox;
	  		if(confidentialityMapData == null){
	  			confidentialityMapData = new HashMap();
	  		}
			if(keyConfidentDataArrayList == null) {
				keyConfidentDataArrayList = new ArrayList();
			}
	  		ArrayList listData = new ArrayList();
	  		if(view_list_data != null && !"".equals(view_list_data) ){
	  			listData.add(view_list_data);
	  			
	  		}
	  		if(view_by_data != null && !"".equals(view_by_data) ){
	  			listData.add(view_by_data);
	  			
	  		}
	  		if(based_on_data != null && !"".equals(based_on_data) ){
	  			listData.add(based_on_data);
	  			
	  		}
	  		if(a_ctnChkBox.equals("Y")) {
	  			if(confidentialityMapData.containsKey(result_data_code)) {
	  				confidentialityMapData.remove(result_data_code);
	  			}
	  			confidentialityMapData.put(result_data_code, listData);
	  			keyConfidentDataArrayList.add(result_data_code);
	  		}
	  		else if(a_ctnChkBox.equals("N")){
	  			if(confidentialityMapData.containsKey(result_data_code)) {
	  				confidentialityMapData.remove(result_data_code);
	  			}
	  		}
	  		return confidentialityMapData;
	  	}
	  	
	  	public HashMap loadStoredEventData(String a_hist_rec_type, String a_event_type, String a_confdnt_id, String a_search_code, String a_view_list_data, String a_view_by_data, String a_based_on_data, String a_header_filter_based_on) throws Exception {
	  		
	  		String result_data_code		= null; 	
	  		String view_list_data 		= null;
	  		String view_by_data 		= null;
	  		//String based_on_data 		= null;//Checkstyle
	  		String privilege_type		= null;
	  		
	  		Connection connection       = null;
	  		PreparedStatement statement = null;
	  		ResultSet resultSet			= null;
	  		ArrayList listData 			= null;
	  		String selectSQL			= "";
	  		if(a_search_code.equals("E")) {
				//selectSQL = " SELECT CONFDNT_ID, CONFDNT_TYPE, CONFDNT_OPT_IND, CONFDNT_VW_BY_IND FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE = ? ";
				if(a_header_filter_based_on.equals("P") || a_header_filter_based_on.equals("R")) {
						selectSQL = " SELECT EVENT_CODE, CONFDNT_TYPE, CONFDNT_OPT_IND, CONFDNT_VW_BY_IND FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND CONFDNT_ID = ? AND CONFDNT_OPT_IND = ? AND CONFDNT_TYPE = ?";
				}
				else if(a_header_filter_based_on.equals("S")) {
					selectSQL = " SELECT EVENT_CODE, CONFDNT_TYPE, CONFDNT_OPT_IND, CONFDNT_VW_BY_IND FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND CONFDNT_ID = ? AND CONFDNT_OPT_IND = ? AND CONFDNT_VW_BY_IND = ? AND CONFDNT_TYPE = ?" ;
				}
			} else { 
				selectSQL = " SELECT CONFDNT_ID, CONFDNT_TYPE, CONFDNT_OPT_IND, CONFDNT_VW_BY_IND FROM CA_EVENT_CONFDNT_DTL WHERE HIST_REC_TYPE = ? AND EVENT_CODE_TYPE = ? AND EVENT_CODE = ? AND CONFDNT_TYPE = ?";
	  		}
			if(confidentialityMapData == null)
			confidentialityMapData = new HashMap();

	  		try {
	  			connection = ConnectionManager.getConnection();
	  			statement = connection.prepareStatement(selectSQL);
	  			statement.setString(1, a_hist_rec_type);
	  			statement.setString(2, a_event_type);
	  			statement.setString(3, a_confdnt_id);
				if(!a_search_code.equals("E")) {
					statement.setString(4, a_search_code);
				}
				if(a_search_code.equals("E")) {
					if(a_header_filter_based_on.equals("P") || a_header_filter_based_on.equals("R")) {
						statement.setString(4, a_view_list_data);
						statement.setString(5, a_header_filter_based_on);
						
					}
					else if(a_header_filter_based_on.equals("S")) {
						statement.setString(4, a_based_on_data);
						statement.setString(5, a_view_by_data);
						statement.setString(6, a_header_filter_based_on);
					}
				}
	  			resultSet = statement.executeQuery();
	  			while(resultSet.next()){
	  				listData = new ArrayList();
	  				result_data_code = resultSet.getString(1);
	  				privilege_type   = resultSet.getString(2);
	  				view_list_data	 = resultSet.getString(3);
	  				view_by_data	 = resultSet.getString(4);
	  				
	  				if(view_by_data != null && view_by_data != ""){
	  					if(view_by_data.equalsIgnoreCase("B")){
	  						view_by_data = "BB";
	  					}	
	  					listData.add(view_by_data);
	  				}
	  				if(view_list_data != null && view_list_data != ""){
	  					if(view_list_data.equalsIgnoreCase("B")){
	  						view_list_data = "LB";
	  					}	
	  					listData.add(view_list_data);
	  				}
	  				confidentialityMapData.put(result_data_code, listData);
	  			}
	  		}
	  		catch(Exception ex){
	  			ex.getMessage();
				ex.printStackTrace();
	  		}
			finally {
				if(resultSet != null) resultSet.close();		
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			}
	  		return confidentialityMapData;
	  	}
	       
}
