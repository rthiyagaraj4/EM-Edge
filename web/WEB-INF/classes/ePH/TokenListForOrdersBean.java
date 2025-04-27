/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class TokenListForOrdersBean extends PhAdapter implements Serializable {	
	ArrayList result=new ArrayList();

	public ArrayList getPopupScreenValues(String trn_group_ref)	{
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		result=new ArrayList();
		Connection con=null;
		try{			
			con=getConnection();
			//String selectsql="Select b.long_desc disp_locn_desc, c.description token_series_desc, a. token_serial_no from or_order x, ph_ord_for_disp_queue a, ph_disp_locn_lang_vw b, ph_token_series_lang_vw c Where x.trn_group_ref  = ? And a.facility_id = b.facility_id And a.disp_locn_code = b.disp_locn_code AND a.queue_date = trunc(sysdate) and a.queue_shift = '*ALL' and a.order_id = x.order_id and a.facility_id = c.facility_id and a.disp_locn_code = c.disp_locn_code And a.token_series_code = c.token_series_code order by 1,2,3";
			//String selectsql="Select distinct  b.long_desc disp_locn_desc, c.description token_series_desc, a. token_serial_no, a.patient_id, a.DISP_LOCN_CODE, a.TOKEN_SERIES_CODE,  a.FACILITY_ID from or_order x, ph_ord_for_disp_queue a, ph_disp_locn_lang_vw b, ph_token_series_lang_vw c Where x.trn_group_ref  = ? And a.facility_id = b.facility_id And a.disp_locn_code = b.disp_locn_code AND a.queue_date = trunc(sysdate) and a.queue_shift = '*ALL' and a.order_id = x.order_id and a.facility_id = c.facility_id and a.disp_locn_code = c.disp_locn_code And a.token_series_code = c.token_series_code and b.language_id = ? and c.language_id = ? order by 2,4,5";
			pstmt=con.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TOKEN_LIST_SELECT"));
			//pstmt=con.prepareStatement(selectsql);
			pstmt.setString(1,trn_group_ref );
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			resultSet=pstmt.executeQuery();

			while( resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("DISP_LOCN_CODE")); //index 0
				result.add(resultSet.getString("disp_locn_desc")); //index 1
				result.add(resultSet.getString("TOKEN_SERIES_CODE")); //index 2
				result.add(resultSet.getString("token_series_desc")); //index 3
				result.add(resultSet.getString("token_serial_no")); //index 4
				result.add(resultSet.getString("patient_id")); //index 5
				result.add(resultSet.getString("FACILITY_ID")); //index 6
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( con );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	return result;
  }
  	public boolean printTokenList(Object request,Object response){
		if(result!=null){
		String module_id	= "PH" ;
		String report_id	= "PHBREGPR" ;
		String facility_id	= (String)result.get(6) ;
		//ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		String ReportOutput			=	"";	
			for(int i=0;i<result.size(); i+=7){
				ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report	= new ecis.utils.OnlineReport( facility_id, module_id,report_id) ;

				report.addParameter("p_patient_id",(String)result.get(i+5)) ;
				report.addParameter("p_token_series_code",(String)result.get(i+2));
				report.addParameter("p_disp_locn_code",(String)result.get(i));
				report.addParameter("p_facility_id",(String)result.get(i+6)) ;
				report.addParameter("p_language_id",getLanguageId()) ;
				report.addParameter("p_serial_no",(String)result.get(i+4)) ;
				onlineReports.add( report) ;		
				ReportOutput = onlineReports.execute((HttpServletRequest)request, (HttpServletResponse)response );
//System.err.println("@@@@@@@@@@@ReportOutput="+ReportOutput);
			}
		}
		return true;
	}
} 
