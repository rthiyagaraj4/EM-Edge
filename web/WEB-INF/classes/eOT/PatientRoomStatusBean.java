/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import webbeans.eCommon.ConnectionManager;

import eOT.Common.OTAdapter;

//import com.debug.sql.*;

public class PatientRoomStatusBean extends OTAdapter implements Serializable 
{
	public int NO_OF_PATIENTS;
	public int totalPatients = 0;
	public int lisIterCount = 0;
	public int roomCountPagination = 0;
	public int roomCount = 0;
	public int bookingCntDisp = 0;
	public String fromTimeDisp = "";
	public String toTimeDisp = "";
	public int roomCheck = 0;
	
	private int currentPageNo = 0;
	private int noOfPages;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientRoomStatusBean() {
        try {
			doCommon();
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {
	
	}

	public void clear(){
		currentPageNo = 0;
		noOfPages = 0;
	}

	
	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public void populateInformation(int patientCount)
	{
		// set total no of pages
		this.roomCount = patientCount;
		this.noOfPages = patientCount/NO_OF_PATIENTS;
		if(patientCount%NO_OF_PATIENTS > 0)
		{
			this.noOfPages = this.noOfPages + 1;
		}
	}
	
	
	public Map<String, Integer> getCurrentPageInformation()
	{
		Map<String,Integer> pageInformation = new HashMap<String,Integer>();
		//First time
		if(this.currentPageNo == 0)
		{
			this.currentPageNo = 1;
		}
		//last page to be showed
		else if(this.currentPageNo == this.noOfPages)
		{
			this.currentPageNo = 1;
		}
		else
		{
			this.currentPageNo++;
		}
		
		
		int to = currentPageNo*(NO_OF_PATIENTS);
		int from = to - (NO_OF_PATIENTS - 1) ;
		pageInformation.put("FROM", from);
		pageInformation.put("TO", to);
		pageInformation.put("CURRENT_PAGE", currentPageNo);
		
		/**
		 * Logic for the Page nos shown below
		 * 
		 */
		if(currentPageNo % 3 == 1)
		{
			pageInformation.put("PAGE_NO_1", currentPageNo);
			pageInformation.put("PAGE_NO_2", (currentPageNo + 1));
			pageInformation.put("PAGE_NO_3", (currentPageNo + 2));
		}
		else if(currentPageNo % 3 == 2)
		{
			pageInformation.put("PAGE_NO_1", (currentPageNo - 1));
			pageInformation.put("PAGE_NO_2", (currentPageNo ));
			pageInformation.put("PAGE_NO_3", (currentPageNo + 1));
		}
		else  if(currentPageNo % 3 == 0)
		{
			pageInformation.put("PAGE_NO_1", (currentPageNo - 2));
			pageInformation.put("PAGE_NO_2", (currentPageNo - 1));
			pageInformation.put("PAGE_NO_3", (currentPageNo));
		}
		return pageInformation;
		
	}
	
	public static int getAutoRefreshTime(String facilityId)
	{

		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        StringBuffer sql = new StringBuffer();
		
		try{
			
			
			connection = ConnectionManager.getConnection() ;
			
			sql.append("SELECT REFRESH_INTERVAL, REFRESH_INTERVAL_TIME FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?");
			

			pstmt = connection.prepareStatement(sql.toString()) ;
			pstmt.setString(1, facilityId);
			resultSet = pstmt.executeQuery();
			
			while(resultSet!=null && resultSet.next())
			{
				String interval = resultSet.getString("REFRESH_INTERVAL");
				int time = resultSet.getInt("REFRESH_INTERVAL_TIME");
				if(interval.equals("M"))
				{
					time = time*60;
					return time;
				}
			}
		}
		catch ( Exception e ) 
		{
            e.printStackTrace() ;
		}
		finally 
		{
            try
            {
				resultSet.close();
				pstmt.close();
				ConnectionManager.returnConnection(connection);
             }
            catch(Exception es)
            {
            	es.printStackTrace();
            }
        }
		return 5;
	
	}
}
