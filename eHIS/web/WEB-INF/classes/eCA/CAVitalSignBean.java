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
Date       	Edit History     Name      	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/01/2019	IN69244		Ramya Maddena	25/01/2019		Ramesh Goli	   MMS-KH-CRF-0005.1
13/04/2020	IN072674	Ramesh Goli		13/04/2020		Ramesh G		MMS-KH-CRF-0032
28/06/2020	IN072777	Ramesh Goli		01/07/2020		Ramesh G		AAKH-CRF-0097.2
31/05/2021  IN017999    Chandrashekar a                                AAKH-CRF-0132.1
02/12/2023              Srinivasa N T                    Ramesh G      AAKH-crf-0165
--------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.* ;
import java.sql.* ;
import java.util.*;

import javax.servlet.http.* ;
import org.json.simple.*;

import eCA.Common.CaAdapter;

import webbeans.eCommon.*;
public class  CAVitalSignBean extends CaAdapter implements Serializable
{
	
	private Map<String,Double> selectedRecords = new TreeMap<String,Double>(); 
	private Integer minValue = 0;
	private Integer maxValue = 0;
	private String disMsrDesc=null;
	
	public String getDisMsrDesc() {
		return disMsrDesc;
	}
	public void setDisMsrDesc(String disMsrDesc) {
		this.disMsrDesc = disMsrDesc;
	}
	
	public Map<String, Double> getSelectedRecords() {
		return selectedRecords;
	}
	public void setSelectedRecords(Map<String, Double> selectedRecords) {
		this.selectedRecords = selectedRecords;
	}
	public void clearMap(){
		selectedRecords.clear();
	}
	
	
	public Integer getMinValue() {
		return minValue;
	}
	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}
	public Integer getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}
	public void getMaxAndMinValues(String disMsrId){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer disMsrMinValue = 0;
		Integer disMsrMaxValue = 0;
		String disMsrDesc = "";
		try{
			String strQuery = "SELECT MIN_VALUE,MAX_VALUE,SHORT_DESC FROM AM_DISCR_MSR WHERE DISCR_MSR_ID=?";
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,disMsrId);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				disMsrMinValue= rs.getString("MIN_VALUE")==null?0:Integer.parseInt((String)rs.getString("MIN_VALUE"));
				disMsrMaxValue= rs.getString("MAX_VALUE")==null?0:Integer.parseInt((String)rs.getString("MAX_VALUE"));
				disMsrDesc = rs.getString("SHORT_DESC")==null?"":(String)rs.getString("SHORT_DESC");
			}			
			setMinValue(disMsrMinValue);
			setMaxValue(disMsrMaxValue);
			setDisMsrDesc(disMsrDesc);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
				if(con != null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	//aakh-crf-0165----start
	public List<String[]> getDiscreteCompResultForDT(String date_from,String date_to,String patient_id,String encounter_id,String bed_no, String interval){//Added bed_no for IN017999
		Connection con 		= null;
		ResultSet rs=null,rs1 	= null;
		PreparedStatement pstmt=null, 	pstmt1= null;
		LinkedHashMap<String,ArrayList<String[]>> returnData = null;
		ArrayList<String[]> returnValue = null;
		int i = 1;
		String maxDate= "", minDate="", intval="";
		try 
		{
			con	= getConnection();
			if(!interval.equals("0") && !interval.equals("")){
				if(interval.equals("5")){
					intval="12";
				}else if (interval.equals("10")){
					intval="6";
				}else if (interval.equals("15")){
					intval="4";
				}else if(interval.equals("30")){
					intval="2";
				}else if(interval.equals("60")){
					intval="1";
				}
				String dateQuery="select    to_char(min(test_observ_dt_tm) ,'dd/mm/yyyy hh24:mi:ss') as minDate,  to_char(max(test_observ_dt_tm) ,'dd/mm/yyyy hh24:mi:ss') as maxDate  from  xh_encntr_discr_msr_tmp where patient_id='"+patient_id +"' and encounter_id='"+encounter_id+"'";
				pstmt1   = con.prepareStatement(dateQuery.toString());
				rs1    = pstmt1.executeQuery();
				while(rs1!=null && rs1.next()){
					maxDate=rs1.getString("maxDate");
					minDate=rs1.getString("minDate");
				}
			}
			boolean isVitalSearchByBedNo = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VITAL_SEARCH_BY_BED");//Adding end for IN017999
			
			StringBuffer SearchQuery	  = new StringBuffer();		
			//SearchQuery.append("Select distinct to_char(a.test_observ_dt_tm ,'dd/mm/yyyy hh24:mi:ss')Recorded_date,a.test_observ_dt_tm, a.discr_msr_id, b.short_desc short_desc,a.DISCR_MSR_RESULT_NUM value_dtl,a.patient_class,VITALS_IND_STATUS (a.DISCR_MSR_RESULT_NUM, a.CRITICAL_LOW,a.NORMAL_LOW,a.NORMAL_HIGH,a.CRITICAL_HIGH) indictor , a.DISCR_MSR_RESULT_NUM_UOM as units from XH_ENCNTR_DISCR_MSR_TMP a,AM_DISCR_MSR b where a.discr_msr_id = b.discr_msr_id and a.added_facility_id =b.added_facility_id ");//Table name changed from ca_encntr_discr_msr_tmp to xh_encntr_discr_msr_tmp for IN017999
			SearchQuery.append("Select distinct to_char(a.test_observ_dt_tm ,'dd/mm/yyyy hh24:mi:ss')Recorded_date,a.test_observ_dt_tm, a.discr_msr_id, b.short_desc short_desc, a.DISCR_MSR_RESULT_NUM value_dtl,a.patient_class,VITALS_IND_STATUS (a.DISCR_MSR_RESULT_NUM, a.CRITICAL_LOW,a.NORMAL_LOW,a.NORMAL_HIGH,a.CRITICAL_HIGH) indictor , a.DISCR_MSR_RESULT_NUM_UOM as units, case when b.short_desc like 'Systolic%' then 1 when b.short_desc like 'Diastolic%' then 2 else 3 end as score from XH_ENCNTR_DISCR_MSR_TMP a,AM_DISCR_MSR b where a.discr_msr_id = b.discr_msr_id and a.added_facility_id =b.added_facility_id ");
           if(isVitalSearchByBedNo){//Adding start for IN017999
				if(!"".equals(bed_no))
					SearchQuery.append(" and a.bed_no = ? ");
				else{
					if(!patient_id.equals(""))
					 SearchQuery.append(" and a.patient_id = ? ");	
					if(!encounter_id.equals(""))
					 SearchQuery.append(" and a.encounter_id = ? ");
				}
			}else{//Adding end for IN017999
				    if(!patient_id.equals(""))
					 SearchQuery.append(" and a.patient_id = ? ");	
					if(!encounter_id.equals(""))
					 SearchQuery.append(" and a.encounter_id = ? ");
			}
			if(!"".equals(date_from))
			 SearchQuery.append(" and a.test_observ_dt_tm >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
			if(!"".equals(date_to)){
				//IN072674 Start.
				//SearchQuery.append(" and a.test_observ_dt_tm <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.9999 ");
				SearchQuery.append(" and a.test_observ_dt_tm <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')");
				//IN072674 End.
			}
			if(!interval.equals("0") && !interval.equals("")){
				SearchQuery.append(" AND a.test_observ_dt_tm in ");
				SearchQuery.append("(select test_observ_dt_tm  from  xh_encntr_discr_msr_tmp where test_observ_dt_tm in ( WITH DATA AS ( ");
				SearchQuery.append(" SELECT TO_DATE('"+minDate+"', 'DD/MM/YYYY HH24:MI:SS') AS date_start,TO_DATE('"+maxDate+"', 'DD/MM/YYYY HH24:MI:SS') AS date_end FROM dual )");
				SearchQuery.append(" SELECT To_Date(TO_CHAR(date_start + (LEVEL - 1) / (24*"+intval+"), 'DD/MM/YYYY HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS') AS the_date FROM DATA CONNECT BY LEVEL <= (date_end - date_start) * (24*"+intval+")+1))");
			}
			
			SearchQuery.append(" AND NVL(a.ack_status,' ') NOT IN('A','D')");
			SearchQuery.append(" ORDER BY  a.test_observ_dt_tm DESC,score");
		
			
			 pstmt   = con.prepareStatement(SearchQuery.toString());
				    
		    if(isVitalSearchByBedNo){//Adding start for IN017999
			  if(!"".equals(bed_no)){
				  pstmt.setString(i++, bed_no);
			  }else{
				if(!patient_id.equals(""))
					pstmt.setString(i++, patient_id);
				if(!encounter_id.equals(""))
					pstmt.setString(i++, encounter_id);
			}
		  }else{//Adding end for IN017999
			  if(!patient_id.equals(""))
					pstmt.setString(i++, patient_id);
			  if(!encounter_id.equals(""))
					pstmt.setString(i++, encounter_id);
		  }
			if(!"".equals(date_from))
				pstmt.setString(i++, date_from);
            if(!"".equals(date_to))
				pstmt.setString(i++, date_to);
			rs    = pstmt.executeQuery();
				
			returnData = new LinkedHashMap<String, ArrayList<String[]>>();
			ArrayList<String[]> mapValue = null;
			returnValue = new ArrayList<String[]>();
			while(rs!=null && rs.next())
			{
						
				String discMsrId = rs.getString("discr_msr_id")==null?"":rs.getString("discr_msr_id");
				String short_desc = rs.getString("short_desc")==null?"":rs.getString("short_desc");
				String Recorded_date = rs.getString("recorded_date")==null?"":rs.getString("recorded_date");
				String value_dtl = rs.getString("value_dtl")==null?" ":rs.getString("value_dtl");
				String indictor = rs.getString("indictor")==null?" ":rs.getString("indictor");
				String units = rs.getString("units")==null?" ":rs.getString("units");
				String[] dateAndVal  = new String[3];
				
				dateAndVal[0] = Recorded_date+"#"+value_dtl+"#"+indictor+"#"+units;
				dateAndVal[1] = short_desc;
				dateAndVal[2] = discMsrId;
				
				/*if(returnData.containsKey(discMsrId)){
					mapValue.add(dateAndVal);
				}else{
					mapValue = new ArrayList<String[]>();
					mapValue.add(dateAndVal);
				}
				returnData.put(discMsrId,mapValue);*/
				returnValue.add(dateAndVal);
			}
		
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			try {
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
				if(pstmt1 != null)pstmt1.close();
				if(rs1 != null)rs1.close();
				if(con != null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnValue;
	}
	//aakh-crf-0165-----end
	public LinkedHashMap<String, ArrayList<String[]>> getDiscreteCompResult(String date_from,String date_to,String patient_id,String encounter_id,String bed_no){//Added bed_no for IN017999
		Connection con 		= null;
		ResultSet rs 	= null;
		PreparedStatement pstmt 	= null;
		LinkedHashMap<String,ArrayList<String[]>> returnData = null;
		ArrayList<String[]> returnValue = null;
		int i = 1;
		try 
		{
			con	= getConnection();
			boolean isVitalSearchByBedNo = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VITAL_SEARCH_BY_BED");//Adding end for IN017999
			
			StringBuffer SearchQuery	  = new StringBuffer();		
			SearchQuery.append("Select distinct to_char(a.test_observ_dt_tm ,'dd/mm/yyyy hh24:mi:ss')Recorded_date,a.test_observ_dt_tm, a.discr_msr_id, b.short_desc short_desc,a.DISCR_MSR_RESULT_NUM value_dtl,a.patient_class,VITALS_IND_STATUS (a.DISCR_MSR_RESULT_NUM, a.CRITICAL_LOW,a.NORMAL_LOW,a.NORMAL_HIGH,a.CRITICAL_HIGH) indictor , a.DISCR_MSR_RESULT_NUM_UOM as units from XH_ENCNTR_DISCR_MSR_TMP a,AM_DISCR_MSR b where a.discr_msr_id = b.discr_msr_id and a.added_facility_id =b.added_facility_id ");//Table name changed from ca_encntr_discr_msr_tmp to xh_encntr_discr_msr_tmp for IN017999
			
           if(isVitalSearchByBedNo){//Adding start for IN017999
				if(!"".equals(bed_no))
					SearchQuery.append(" and a.bed_no = ? ");
				else{
					if(!patient_id.equals(""))
					 SearchQuery.append(" and a.patient_id = ? ");	
					if(!encounter_id.equals(""))
					 SearchQuery.append(" and a.encounter_id = ? ");
				}
			}else{//Adding end for IN017999
				    if(!patient_id.equals(""))
					 SearchQuery.append(" and a.patient_id = ? ");	
					if(!encounter_id.equals(""))
					 SearchQuery.append(" and a.encounter_id = ? ");
			}
			if(!"".equals(date_from))
			 SearchQuery.append(" and a.test_observ_dt_tm >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
			if(!"".equals(date_to)){
				//IN072674 Start.
				//SearchQuery.append(" and a.test_observ_dt_tm <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.9999 ");
				SearchQuery.append(" and a.test_observ_dt_tm <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')");
				//IN072674 End.
			}
			
			SearchQuery.append(" AND NVL(a.ack_status,' ') NOT IN('A','D')");
			SearchQuery.append(" ORDER BY b.short_desc, a.test_observ_dt_tm DESC");
			//SearchQuery.append("ORDER BY a.test_observ_dt_tm DESC");
			//SearchQuery.append(" ORDER BY b.short_desc DESC");
			
			 pstmt   = con.prepareStatement(SearchQuery.toString());
				    
		    if(isVitalSearchByBedNo){//Adding start for IN017999
			  if(!"".equals(bed_no)){
				  pstmt.setString(i++, bed_no);
			  }else{
				if(!patient_id.equals(""))
					pstmt.setString(i++, patient_id);
				if(!encounter_id.equals(""))
					pstmt.setString(i++, encounter_id);
			}
		  }else{//Adding end for IN017999
			  if(!patient_id.equals(""))
					pstmt.setString(i++, patient_id);
			  if(!encounter_id.equals(""))
					pstmt.setString(i++, encounter_id);
		  }
			if(!"".equals(date_from))
				pstmt.setString(i++, date_from);
            if(!"".equals(date_to))
				pstmt.setString(i++, date_to);
			rs    = pstmt.executeQuery();
				
			returnData = new LinkedHashMap<String, ArrayList<String[]>>();
			ArrayList<String[]> mapValue = null;
			returnValue = new ArrayList<String[]>();
			while(rs!=null && rs.next())
			{
						
				String discMsrId = rs.getString("discr_msr_id")==null?"":rs.getString("discr_msr_id");
				String short_desc = rs.getString("short_desc")==null?"":rs.getString("short_desc");
				String Recorded_date = rs.getString("recorded_date")==null?"":rs.getString("recorded_date");
				String value_dtl = rs.getString("value_dtl")==null?" ":rs.getString("value_dtl");
				String indictor = rs.getString("indictor")==null?" ":rs.getString("indictor");
				String units = rs.getString("units")==null?" ":rs.getString("units");
				String[] dateAndVal  = new String[3];
				
				dateAndVal[0] = Recorded_date+"#"+value_dtl+"#"+indictor+"#"+units;
				dateAndVal[1] = short_desc;
				dateAndVal[2] = discMsrId;
				
				if(returnData.containsKey(discMsrId)){
					mapValue.add(dateAndVal);
				}else{
					mapValue = new ArrayList<String[]>();
					mapValue.add(dateAndVal);
				}
				returnData.put(discMsrId,mapValue);
			}
		
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			try {
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
				if(con != null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnData;
	}
	public HashMap<String, String> getValueIndication(){
		Connection con 		= null;
		ResultSet rs 	= null;
		PreparedStatement pstmt 	= null;
		HashMap<String,String> indicator = null;
		try 
		{
			con	= getConnection();
			indicator = new HashMap<String,String>();
			
			String srt ="SELECT HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,'N' NORMAL_STR,'NI_Normal.gif' NORMAL_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON FROM CR_CLIN_EVENT_PARAM";
			
			pstmt   = con.prepareStatement(srt);
			rs    = pstmt.executeQuery();
			
			if(rs.next())
			{
				if((rs.getString("HIGH_STR")!=null)&&(rs.getString("HIGH_SYMBOL_ICON")!=null))
					indicator.put((String)rs.getString("HIGH_STR"),(String)rs.getString("HIGH_SYMBOL_ICON"));
				
				if((rs.getString("LOW_STR")!=null)&&(rs.getString("LOW_SYMBOL_ICON")!=null))
					indicator.put((String)rs.getString("LOW_STR"),(String)rs.getString("LOW_SYMBOL_ICON"));
				
				if((rs.getString("NORMAL_STR")!=null)&&(rs.getString("NORMAL_SYMBOL_ICON")!=null))
					indicator.put((String)rs.getString("NORMAL_STR"),(String)rs.getString("NORMAL_SYMBOL_ICON"));
				
				if((rs.getString("CRIT_STR")!=null)&&(rs.getString("CRIT_SYMBOL_ICON")!=null))
					indicator.put((String)rs.getString("CRIT_STR"),(String)rs.getString("CRIT_SYMBOL_ICON"));
				
				if((rs.getString("CRIT_HIGH_STR")!=null)&&(rs.getString("CRIT_HIGH_SYMBOL_ICON")!=null))
					indicator.put((String)rs.getString("CRIT_HIGH_STR"),(String)rs.getString("CRIT_HIGH_SYMBOL_ICON"));
					
				if((rs.getString("CRIT_LOW_STR")!=null)&&(rs.getString("CRIT_LOW_SYMBOL_ICON")!=null))
					indicator.put((String)rs.getString("CRIT_LOW_STR"),(String)rs.getString("CRIT_LOW_SYMBOL_ICON"));
			}
					
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			try {
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
				if(con != null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return indicator;
	}
	////IN072777 Strt.
	public ArrayList getAppChartDetails(String selectedDiscret){
		Connection con 		= null;
		ResultSet rs 	= null;
		PreparedStatement pstmt 	= null;
		ResultSet rs1 	= null;
		PreparedStatement pstmt1 	= null;
		ArrayList<String[]> chartDetails = new ArrayList<String[]>();
		try 
		{
			con	= getConnection();
			String sqlQuery ="";
			String thirdPartyVitalSignChart = "";
			if("".equals(selectedDiscret)){
				sqlQuery ="SELECT CHART_ID,SHORT_DESC,'Y' CHECKBOX  FROM CA_CHART  WHERE CHART_ID IN (SELECT THIRDPARTY_VITALS_CHART_ID FROM CA_PARAM WHERE MODULE_ID='CA')";
				pstmt   = con.prepareStatement(sqlQuery);
			}else{
				pstmt1   = con.prepareStatement("SELECT THIRDPARTY_VITALS_CHART_ID FROM CA_PARAM WHERE MODULE_ID='CA'");
				rs1    = pstmt1.executeQuery();
				if(rs1.next()){
					thirdPartyVitalSignChart = rs1.getString("THIRDPARTY_VITALS_CHART_ID")==null?"":rs1.getString("THIRDPARTY_VITALS_CHART_ID");
				}
				if(pstmt1 != null)pstmt1.close();
				if(rs1 != null)rs1.close();
				
				String[] discretMsr = selectedDiscret.split(",");
				StringBuffer selectDiscretBuffer = new StringBuffer();
				int j=0;
				for(int i=0;i<discretMsr.length;i++){
					if(i==0)
						selectDiscretBuffer.append("'"+discretMsr[i]+"'");
					else
						selectDiscretBuffer.append(",'"+discretMsr[i]+"'");
					j++;
				}
				//sqlQuery ="SELECT A.CHART_ID,A.SHORT_DESC,A.CHECKBOX  FROM  (SELECT CHART_ID,SHORT_DESC,'Y' CHECKBOX FROM CA_CHART  WHERE CHART_ID =? UNION ALL SELECT CHART_ID,SHORT_DESC,'N' CHECKBOX  FROM CA_CHART WHERE THIRDPARTY_VITALS_APPL_YN='Y' AND CHART_ID !=? ) A, (SELECT CHART_ID FROM CA_CHART_SECTION_COMP WHERE DISCR_MSR_ID IN ("+selectDiscretBuffer.toString()+") HAVING COUNT(DISCR_MSR_ID)= "+j+" GROUP BY CHART_ID) B WHERE A.CHART_ID=B.CHART_ID ORDER BY A.SHORT_DESC";
				sqlQuery ="SELECT A.CHART_ID,A.SHORT_DESC,A.CHECKBOX  FROM  (SELECT CHART_ID,SHORT_DESC,'Y' CHECKBOX FROM CA_CHART  WHERE CHART_ID =? UNION ALL SELECT CHART_ID,SHORT_DESC,'N' CHECKBOX  FROM CA_CHART WHERE THIRDPARTY_VITALS_APPL_YN='Y' AND CHART_ID !=? ) A, (SELECT CHART_ID FROM CA_CHART_SECTION_COMP WHERE DISCR_MSR_ID IN ("+selectDiscretBuffer.toString()+")  GROUP BY CHART_ID) B WHERE A.CHART_ID=B.CHART_ID ORDER BY A.SHORT_DESC";//aakh-crf-0165
			
				pstmt   = con.prepareStatement(sqlQuery);
				pstmt.setString(1,thirdPartyVitalSignChart);
				pstmt.setString(2,thirdPartyVitalSignChart);
			}
			
			rs    = pstmt.executeQuery();
			
			while(rs!=null && rs.next())
			{
				
				String charId = rs.getString("CHART_ID")==null?"":rs.getString("CHART_ID");
				String chartName = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
				String chartChecked = rs.getString("CHECKBOX")==null?"N":rs.getString("CHECKBOX");
				String[] chartIdVal  = new String[3];
				chartIdVal[0] = charId;
				chartIdVal[1] = chartName;
				chartIdVal[2] = chartChecked;
				chartDetails.add(chartIdVal);
			}
					
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			try {
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
				if(con != null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return chartDetails;
	}
	////IN072777 End.
}