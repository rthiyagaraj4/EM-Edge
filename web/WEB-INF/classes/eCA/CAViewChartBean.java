/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
23/11/2017	IN061897		Raja S			23/11/2017		Ramesh G		ML-MMOH-CRF-0549
10/02/2021	6777			Nijitha S		10/02/2021		Nijitha S		SKR-SCF-1458
--------------------------------------------------------------------------------------------------------------
*/
package eCA;
 
import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import java.text.SimpleDateFormat;
import webbeans.eCommon.*;
import eCommon.Common.*;

public class CAViewChartBean  implements Serializable
{
	public CAViewChartBean()
	{
	}
	/*public HashMap getChartData(String pid,String fid,String eid,String fdate,String tDate,String chartId,String cformat){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;		
		int rowcount = 0;
		String chartComp="";
		String rDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList firstArray = null;
		ArrayList<HashMap<String,String>> secondArray = null;
		HashMap<String,ArrayList<HashMap<String,String>>> subMap =null;
		HashMap mainMap = new HashMap();
		  
		try{
			StringBuffer sb = new StringBuffer();		  
			sb.append("SELECT d.discr_msr_id,d.format_type,d.disp_ord_seq_num,TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy hh24:mi') dt,a.discr_msr_result_num");
			sb.append(" FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b,ca_view_chart_config d");
			sb.append(" WHERE b.chart_id = ?");
			sb.append(" AND NVL (a.error_yn, 'N') != 'Y'");
			sb.append(" AND a.chart_id = b.chart_id");
			sb.append(" AND a.chart_id = d.chart_id");
			sb.append(" AND b.chart_id = d.chart_id");
			sb.append(" AND a.discr_msr_panel_or_form_id = b.panel_id");
			sb.append(" AND a.discr_msr_id = b.discr_msr_id");						   
			sb.append(" AND a.discr_msr_id = d.discr_msr_id");
			sb.append(" AND b.discr_msr_id = d.discr_msr_id");	
			sb.append(" AND a.patient_id = ?");
			sb.append(" AND a.facility_id = ?");
			//sb.append(" AND b.encounter_id = ?");
			if(!"".equals(eid)){
				sb.append(" AND b.encounter_id = ?");
			}
			sb.append(" AND b.facility_id = ?");
			sb.append(" AND d.format_type = ?");
			sb.append(" AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi')");
			sb.append(" AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi')");
										   
			sb.append(" AND a.discr_msr_result_type IN ");
			sb.append("('N', 'I') ");
			//sb.append("('C', 'D', 'E', 'N', 'A', 'I', 'L', 'F', 'H', 'T') ");
			
			sb.append("ORDER BY d.format_type asc,d.disp_ord_seq_num asc, dt ASC");			
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sb.toString(),rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			pst.setString(1,chartId);
			pst.setString(2,pid);
			pst.setString(3,fid);
			//pst.setString(4,eid);
			if(!"".equals(eid)){
				pst.setString(4,eid);
			}
			pst.setString(5,fid);
			pst.setString(6,cformat);
			pst.setString(7,fdate);
			pst.setString(8,tDate);
			rs = pst.executeQuery();
					
			if (rs.last()) {
				rowcount = rs.getRow();
				rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
			}
			while(rs.next()){
				if(!chartComp.equals(rs.getString(1))||"".equals(chartComp)){
					if(!chartComp.equals(rs.getString(1))&&!"".equals(chartComp)){
						subMap = new HashMap();
						subMap.put(rDate, secondArray);	
						firstArray.add(subMap);
						mainMap.put(chartComp, firstArray);
						rDate="";
						chartComp="";
					}
					chartComp=rs.getString(1);
					firstArray = new ArrayList();
					if(!rDate.equals(sdf.format(sdf.parse((String)rs.getString(4))))||"".equals(rDate)){
						if(!rDate.equals(sdf.format(sdf.parse((String)rs.getString(4))))&& !"".equals(rDate)){
							subMap = new HashMap();
							subMap.put(rDate, secondArray);	
							firstArray.add(subMap);
						}					  
						rDate=sdf.format(sdf.parse((String)rs.getString(4)));
						secondArray = new ArrayList<HashMap<String,String>>();
						HashMap<String,String> resMap= new HashMap<String,String>();                                                                                                                                 
						resMap.put((String)rs.getString(4), (String)rs.getString(5)==null?"":(String)rs.getString(5));
						secondArray.add(resMap);
					}else{
						HashMap<String,String> resMap= new HashMap<String,String>();                                                                                                                                 
						resMap.put((String)rs.getString(4), (String)rs.getString(5)==null?"":(String)rs.getString(5));
						secondArray.add(resMap);
					}
				}else{
					if(!rDate.equals(sdf.format(sdf.parse((String)rs.getString(4))))||"".equals(rDate)){
						if(!rDate.equals(sdf.format(sdf.parse((String)rs.getString(4))))&& !"".equals(rDate)){
							subMap = new HashMap();
							subMap.put(rDate, secondArray);	
							firstArray.add(subMap);
						}					  
						rDate=sdf.format(sdf.parse((String)rs.getString(4)));
						secondArray = new ArrayList<HashMap<String,String>>();
						HashMap<String,String> resMap= new HashMap<String,String>();                                                                                                                                 
						resMap.put((String)rs.getString(4), (String)rs.getString(5)==null?"":(String)rs.getString(5));
						secondArray.add(resMap);
					}else{
						HashMap<String,String> resMap= new HashMap<String,String>();                                                                                                                                 
						resMap.put((String)rs.getString(4), (String)rs.getString(5)==null?"":(String)rs.getString(5));
						secondArray.add(resMap);
					}
				}					
				if(rowcount==rs.getRow()){
					subMap = new HashMap();
					subMap.put(rDate, secondArray);	
					firstArray.add(subMap);
					mainMap.put(chartComp, firstArray);					 
				}				  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pst.close();
				con.close();
			}catch(Exception ex){
			
			}
		}		
		return mainMap;
	}*/
	public HashMap getChartData(String pid,String fid,String eid,String fdate,String tDate,String chartId,String cformat){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;		
		int rowcount = 0;
		String chartComp="";
		String rDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList firstArray = null;
		ArrayList<HashMap<String,String>> secondArray = null;
		HashMap<String,ArrayList<HashMap<String,String>>> subMap =null;
		HashMap mainMap = new HashMap();
		  
		try{
			StringBuffer sb = new StringBuffer();		  
			sb.append("SELECT DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy hh24:mi') dt,d.discr_msr_id,d.format_type,d.disp_ord_seq_num,a.discr_msr_result_num");
			sb.append(" FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b,ca_view_chart_config d");
			sb.append(" WHERE b.chart_id = ?");
			sb.append(" AND b.encounter_id = a.ENCOUNTER_ID ");//6777
			sb.append(" AND NVL (a.error_yn, 'N') != 'Y'");
			sb.append(" AND a.chart_id = b.chart_id");
			sb.append(" AND a.chart_id = d.chart_id");
			sb.append(" AND b.chart_id = d.chart_id");
			sb.append(" AND a.discr_msr_panel_or_form_id = b.panel_id");
			sb.append(" AND a.discr_msr_id = b.discr_msr_id");						   
			sb.append(" AND a.discr_msr_id = d.discr_msr_id");
			sb.append(" AND b.discr_msr_id = d.discr_msr_id");	
			sb.append(" AND a.patient_id = ?");
			sb.append(" AND a.facility_id = ?");
			if(!"0".equals(eid)){
				sb.append(" AND b.encounter_id = ?");
			}
			sb.append(" AND b.facility_id = ?");
			sb.append(" AND d.format_type = ?");
			sb.append(" AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi')");
			sb.append(" AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi')");
										   
			sb.append(" AND a.discr_msr_result_type IN ");
			sb.append("('N', 'I') ");
			//sb.append("('C', 'D', 'E', 'N', 'A', 'I', 'L', 'F', 'H', 'T') ");
			
			//sb.append("ORDER BY d.format_type asc,d.disp_ord_seq_num asc, TO_DATE(dt,'dd/mm/yyyy hh24:mi') ASC");
			sb.append("ORDER BY d.disp_ord_seq_num asc,d.discr_msr_id ASC, TO_DATE(dt,'dd/mm/yyyy hh24:mi') ASC");
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sb.toString(),rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			pst.setString(1,chartId);
			pst.setString(2,pid);
			pst.setString(3,fid);
			//pst.setString(4,eid);
			if(!"0".equals(eid)){
				pst.setString(4,eid);
				pst.setString(5,fid);
				pst.setString(6,cformat);
				pst.setString(7,fdate);
				pst.setString(8,tDate);
			}else{
				pst.setString(4,fid);
				pst.setString(5,cformat);
				pst.setString(6,fdate);
				pst.setString(7,tDate);
			}
			rs = pst.executeQuery();
					
			if (rs.last()) {
				rowcount = rs.getRow();
				rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
			}
			while(rs.next()){
				if(!chartComp.equals(rs.getString(2))||"".equals(chartComp)){
					if(!chartComp.equals(rs.getString(2))&&!"".equals(chartComp)){
						subMap = new HashMap();
						subMap.put(rDate, secondArray);	
						firstArray.add(subMap);
						mainMap.put(chartComp, firstArray);
						rDate="";
						chartComp="";
					}
					chartComp=rs.getString(2);
					firstArray = new ArrayList();
					if(!rDate.equals(sdf.format(sdf.parse((String)rs.getString(1))))||"".equals(rDate)){
						if(!rDate.equals(sdf.format(sdf.parse((String)rs.getString(1))))&& !"".equals(rDate)){
							subMap = new HashMap();
							subMap.put(rDate, secondArray);	
							firstArray.add(subMap);
						}					  
						rDate=sdf.format(sdf.parse((String)rs.getString(1)));
						secondArray = new ArrayList<HashMap<String,String>>();
						HashMap<String,String> resMap= new HashMap<String,String>();                                                                                                                                 
						resMap.put((String)rs.getString(1), (String)rs.getString(5)==null?"":(String)rs.getString(5));
						secondArray.add(resMap);
					}else{
						HashMap<String,String> resMap= new HashMap<String,String>();                                                                                                                                 
						resMap.put((String)rs.getString(1), (String)rs.getString(5)==null?"":(String)rs.getString(5));
						secondArray.add(resMap);
					}
				}else{
					if(!rDate.equals(sdf.format(sdf.parse((String)rs.getString(1))))||"".equals(rDate)){
						if(!rDate.equals(sdf.format(sdf.parse((String)rs.getString(1))))&& !"".equals(rDate)){
							subMap = new HashMap();
							subMap.put(rDate, secondArray);	
							firstArray.add(subMap);
						}					  
						rDate=sdf.format(sdf.parse((String)rs.getString(1)));
						secondArray = new ArrayList<HashMap<String,String>>();
						HashMap<String,String> resMap= new HashMap<String,String>();                                                                                                                                 
						resMap.put((String)rs.getString(1), (String)rs.getString(5)==null?"":(String)rs.getString(5));
						secondArray.add(resMap);
					}else{
						HashMap<String,String> resMap= new HashMap<String,String>();                                                                                                                                 
						resMap.put((String)rs.getString(1), (String)rs.getString(5)==null?"":(String)rs.getString(5));
						secondArray.add(resMap);
					}
				}					
				if(rowcount==rs.getRow()){
					subMap = new HashMap();
					subMap.put(rDate, secondArray);	
					firstArray.add(subMap);
					mainMap.put(chartComp, firstArray);					 
				}				  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pst.close();
				con.close();
			}catch(Exception ex){
			
			}
		}		
		return mainMap;
	}
	/*public Hashtable getTableData(String pid,String fid,String eid,String fdate,String tDate,String chartId,String cformat){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int rowcount = 0;
		String chartComp="";
		Hashtable mainTable=new Hashtable();
		Hashtable secondTable = null;
		try{
			StringBuffer query3 = new StringBuffer();			
			query3.append("SELECT a.discr_msr_id,TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy hh24:mi') dt,nvl(a.discr_msr_result_num,0) ");
			query3.append("FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b,ca_view_chart_config d ");
			query3.append("WHERE b.chart_id = ? ");
			query3.append("AND NVL (a.error_yn, 'N') != 'Y' AND a.chart_id = b.chart_id AND a.chart_id = d.chart_id AND b.chart_id = d.chart_id AND a.discr_msr_panel_or_form_id = b.panel_id ");
			query3.append("AND a.discr_msr_id = b.discr_msr_id   AND a.discr_msr_id = d.discr_msr_id  AND b.discr_msr_id = d.discr_msr_id ");
			query3.append("AND a.patient_id = ? ");
			query3.append("AND a.facility_id = ? ");
			query3.append("AND b.encounter_id = ? ");
			query3.append("AND b.facility_id = ? ");
			query3.append("AND d.format_type =? ");
			query3.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");
			query3.append("AND a.discr_msr_result_type IN ('N', 'I') ORDER BY d.format_type asc,d.disp_ord_seq_num asc, dt asc ");
			System.out.println(query3.toString());
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(query3.toString(),rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			pst.setString(1,chartId);
			pst.setString(2,pid);
			pst.setString(3,fid);
			pst.setString(4,eid);
			pst.setString(5,fid);
			pst.setString(6,cformat);
			pst.setString(7,fdate);
			pst.setString(8,tDate);
			
			rs = pst.executeQuery();
			if (rs.last()) {
				rowcount = rs.getRow();
				rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
			}
			System.out.println("---------------------->"+mainTable.size());
			while(rs.next()){
				if(!chartComp.equals(rs.getString(1))||"".equals(chartComp)){
					if(!chartComp.equals(rs.getString(1))&&!"".equals(chartComp)){
						System.out.println("rs.getRow()---------------------->"+rs.getRow());
						mainTable.put(chartComp, secondTable);
						secondTable = new Hashtable();
						chartComp=(String)rs.getString(1);
						secondTable.put(((String)rs.getString(2)), ((String)rs.getString(3)));
					}else{
						secondTable = new Hashtable();
						chartComp=(String)rs.getString(1);
						secondTable.put(((String)rs.getString(2)), ((String)rs.getString(3)));
					}
				}else{
					secondTable.put(((String)rs.getString(2)), ((String)rs.getString(3)));
				}
				if(rowcount==rs.getRow()){
					System.out.println("rs.getRow()---------------------->"+rs.getRow());
					mainTable.put(chartComp, secondTable);
				}
			}
			
			System.out.println("---------------------->"+mainTable.size());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pst.close();
				con.close();
			}catch(Exception ex){
			
			}
		}
		return mainTable;
		
	}*/
	public Hashtable getTableData(String pid,String fid,String eid,String fdate,String tDate,String chartId,String cformat){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int rowcount = 0;
		String chartComp="";
		Hashtable mainTable=new Hashtable();
		Hashtable secondTable = null;
		try{
			StringBuffer query3 = new StringBuffer();			
			query3.append("SELECT DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy hh24:mi') dt,a.discr_msr_id,nvl(a.discr_msr_result_num,0) ,d.format_type,d.disp_ord_seq_num ");
			query3.append("FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b,ca_view_chart_config d ");
			query3.append("WHERE b.chart_id = ? ");
			query3.append("AND NVL (a.error_yn, 'N') != 'Y' AND a.chart_id = b.chart_id AND a.chart_id = d.chart_id AND b.chart_id = d.chart_id AND a.discr_msr_panel_or_form_id = b.panel_id ");
			query3.append("AND a.discr_msr_id = b.discr_msr_id   AND a.discr_msr_id = d.discr_msr_id  AND b.discr_msr_id = d.discr_msr_id ");
			query3.append("AND a.patient_id = ? ");
			query3.append("AND a.facility_id = ? ");
			//query3.append("AND b.encounter_id = ? ");
			if(!"0".equals(eid)){
				query3.append(" AND b.encounter_id = ?");
			}
			query3.append("AND b.facility_id = ? ");
			query3.append("AND d.format_type =? ");
			query3.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");
			//query3.append("AND a.discr_msr_result_type IN ('N', 'I') ORDER BY d.format_type asc,d.disp_ord_seq_num asc, TO_DATE (dt, 'dd/mm/yyyy hh24:mi') asc ");
			query3.append("AND a.discr_msr_result_type IN ('N', 'I') ORDER BY d.disp_ord_seq_num ASC,a.discr_msr_id ASC, TO_DATE (dt, 'dd/mm/yyyy hh24:mi') asc ");
			System.out.println(query3.toString());
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(query3.toString(),rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
			pst.setString(1,chartId);
			pst.setString(2,pid);
			pst.setString(3,fid);			
			if(!"0".equals(eid)){
				pst.setString(4,eid);
				pst.setString(5,fid);
				pst.setString(6,cformat);
				pst.setString(7,fdate);
				pst.setString(8,tDate);
			}else{
				pst.setString(4,fid);
				pst.setString(5,cformat);
				pst.setString(6,fdate);
				pst.setString(7,tDate);
			}
			
			
			rs = pst.executeQuery();
			if (rs.last()) {
				rowcount = rs.getRow();
				rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
			}
			while(rs.next()){
				if(!chartComp.equals(rs.getString(2))||"".equals(chartComp)){
					if(!chartComp.equals(rs.getString(2))&&!"".equals(chartComp)){
						mainTable.put(chartComp, secondTable);
						secondTable = new Hashtable();
						chartComp=(String)rs.getString(2);
						secondTable.put(((String)rs.getString(1)), ((String)rs.getString(3)));
					}else{
						secondTable = new Hashtable();
						chartComp=(String)rs.getString(2);
						secondTable.put(((String)rs.getString(1)), ((String)rs.getString(3)));
					}
				}else{
					secondTable.put(((String)rs.getString(1)), ((String)rs.getString(3)));
				}
				if(rowcount==rs.getRow()){
					mainTable.put(chartComp, secondTable);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pst.close();
				con.close();
			}catch(Exception ex){
			
			}
		}
		return mainTable;
		
	}
//IN061897 changes starts
	public String setPracDefaultChart(String def_chartId,String practitionerId,String facilityId,String clientIpAddress){
		Connection con = null;
		String result ="";
		PreparedStatement psmt = null;

		try{
			con = ConnectionManager.getConnection(); 
				psmt = con.prepareStatement("UPDATE CA_PRAC_DEFAULT_CHART SET CHART_ID= ?,MODIFIED_DATE=SYSDATE,MODIFIED_BY_ID = ?,MODIFIED_AT_WS_NO=? WHERE PRACTITIONER_ID=? AND FACILITY_ID=? ");
				psmt.setString(1,def_chartId);
				psmt.setString(2,practitionerId);
				psmt.setString(3,clientIpAddress);
				psmt.setString(4,practitionerId);
				psmt.setString(5,facilityId);
				int cnt = psmt.executeUpdate();
				if(psmt!=null)psmt.close();
				if(cnt<=0)
				{
					psmt = con.prepareStatement("INSERT INTO CA_PRAC_DEFAULT_CHART (PRACTITIONER_ID,FACILITY_ID,CHART_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_BY_ID,MODIFIED_AT_WS_NO,ADDED_AT_WS_NO,MODIFIED_FACILITY_ID,ADDED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,SYSDATE,?,?,?,?,?)");
					psmt.setString(1,practitionerId); 
					psmt.setString(2,facilityId);
					psmt.setString(3,def_chartId);
					psmt.setString(4,practitionerId);
					psmt.setString(5,practitionerId);
					psmt.setString(6,clientIpAddress);
					psmt.setString(7,clientIpAddress);
					psmt.setString(8,facilityId);
					psmt.setString(9,facilityId);
					psmt.executeUpdate();				
				}
				result = "Success";
				con.commit();			
		}catch(Exception e){					
				System.out.println(e);
				result=e.getMessage();
				try {
					con.rollback();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}finally{ 
					try {
						if(psmt!=null)psmt.close();
						if(con!=null) con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}			
			}
		return result;
		
	}
//IN061897 changes ends
}
