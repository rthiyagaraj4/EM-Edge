/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
18/11/2015    	IN057467		 	Ramesh G		      								Query template data should also allow date field to be included for query.	
------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.io.Serializable;
import java.util.Date;				//IN057467
import java.text.DateFormat;		//IN057467
import java.text.SimpleDateFormat;	//IN057467

import webbeans.eCommon.ConnectionManager;

public class QueryTemplateDataFunctionBean implements Serializable
{
	private Map<String, String> keyComponent;
	private List<String> qryResults;
	private ArrayList<String> dateChk; //IN057467

	public void setQueryResults(List<String> lst)
	{
		this.qryResults = lst;
	}

	public List<String> getQueryResults()
	{
		return this.qryResults;
	}

	public QueryTemplateDataFunctionBean()
	{
		keyComponent = new HashMap<String, String>();
		dateChk		=	new ArrayList<String>();  //IN057467
	}
	//IN057467 Start.
	public void setDateChk(String val){
		dateChk.add(val);
	}
	public void removeDateChk(String val){
		if (dateChk.contains(val)) {
			dateChk.remove(val);
		}
	}
	public ArrayList<String> getDateChk(){
		return this.dateChk;
	}
	public void clearDateChk()
	{
		dateChk.clear();		
	}
	//IN057467 end.
	public void setKeyComponent(String key , String val)
	{
		/*if (!keyComponent.containsKey(key))
		{*/
			keyComponent.put(key, val);
		//}
	}

	public void removeKeyComponent(String key)
	{
		if (keyComponent.containsKey(key))
		{
			keyComponent.remove(key);
		}
	}



	public Map<String, String> getKeyComponents()
	{
		return this.keyComponent;
	}

	public void clearKeyComponents()
	{
		keyComponent.clear();
		
	}
	public Map<String, String> getComponent(String queryRef)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String, String> component = new HashMap<String, String>();

		try
		{
			String sqlQry = "SELECT a.comp_id, a.srl_no, a.result_type, b.label_desc, d.std_comp_id,        c.std_comp_result_type, c.lookup_type, c.lookup_url FROM ca_temp_qry_dtl a, ca_template_label b, am_standard_comp c, am_discr_msr d WHERE a.prompt_id = b.label_id AND d.discr_msr_id = a.comp_id AND d.STD_COMP_ID = c.STD_COMP_ID(+) AND QUERY_REF =?";

			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sqlQry);
			pst.setString(1, queryRef);
			rs = pst.executeQuery();
			String std_comp_id ="",std_comp_result_type="", lookup_type="", lookup_url="",comp_id="",srl_no="",result_type=""; 

			while(rs.next())
			{			
				comp_id = rs.getString(1)==null?"":rs.getString(1);
				srl_no = rs.getString(2)==null?"":rs.getString(2);
				result_type = rs.getString(3)==null?"":rs.getString(3);
				std_comp_id = rs.getString(5)==null?" ":rs.getString(5);
				std_comp_result_type = rs.getString(6)==null?" ":rs.getString(6);
				lookup_type = rs.getString(7)==null?" ":rs.getString(7);
				lookup_url = rs.getString(8)==null?" ":rs.getString(8);				
					component.put(comp_id+"`~"+srl_no+"`~"+result_type+"`~"+std_comp_id+"`~"+std_comp_result_type+"`~"+lookup_type+"`~"+lookup_url, rs.getString(4)==null?"":rs.getString(4));
								
			}

			if (rs != null)
			{
				rs.close();
			}

			if (pst != null)
			{
				pst.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con != null)
				{
					con.close();
				}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		return component.keySet().size()>0?component:null;
	}

	public List<String> getRefRangeDesc(String resultType)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String> retObj = new ArrayList<String>();
		try
		{
			String sqlQry = "Select REF_RNG_DESC from AM_DISCR_MSR_REF_RNG_LIST where discr_msr_id = ?";
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement(sqlQry);
			pst.setString(1, resultType==null?"":resultType);
			rs = pst.executeQuery();
			retObj = new ArrayList<String>();
			while(rs.next())
			{
				retObj.add(rs.getString(1));
			}

			if (rs != null)
			{
				rs.close();
			}

			if (pst != null)
			{
				pst.close();
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con != null)
				{
					con.close();
				}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		return retObj.size()>0?retObj:null;
	}



	public List<String> getKeyComponentResults(String fromAge, String toAge, String fromDate, String toDate, String sex, String fromAgeUint, String toAgeUnit)
	{
		Set<String> compKey = null;
		Map<String, String> componentMap = null;
		componentMap = getKeyComponents();
		String compValue = "";
		String[] compKeyArr = null;
		String[] compValArr = null;
		String CompID = "";
		String srNo = "";
		String resultType = "";		
		String CompIDs = "";		
		String FrmcompValue =	"";	//IN057467
		String TocompValue	=	"";	//IN057467
		String dateCompChk	=	"N";	//IN057467
		boolean dateCompFlag = false; //IN057467
		String addMoreColumns = "";	 //IN057467
		String addMoreGroupColumns =""; //IN057467
		
		List<String> retObj = new ArrayList<String>();
		StringBuffer sqlQry = new StringBuffer();
			sqlQry.append("SELECT a.patient_id, a.patient_name, a.sex, get_age (date_of_birth, greatest(b.event_date,date_of_birth)) age, to_char(a.date_of_birth,'dd/mm/yyyy'),B.PATIENT_CLASS, b.ENCOUNTER_ID, #MORECOLUMNS COUNT (DISTINCT a.PATIENT_ID || b.ENCOUNTER_ID || to_char(event_date,'dd/mm/yyyy hh24:mi')) occurance  FROM mp_patient a, cr_encounter_detail b  WHERE a.patient_id = b.patient_id    AND event_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') + .9999");

		if(!sex.equals("") && !sex.equals("A"))
		{
			sqlQry.append(" AND a.sex= ? ");
		}

		if(!fromAge.equals("") || !toAge.equals(""))
		{
			sqlQry.append(" AND  b.event_date - A.DATE_OF_BIRTH BETWEEN nvl(?,0 )*(decode(?, 'M',30,'Y',365,1)) and nvl(?, 150) * (decode(?, 'M',30,'Y',365,1)) ");
		}

		if (componentMap != null && componentMap.size() > 0)
		{
			compKey = componentMap.keySet();
			if (compKey != null && compKey.size() > 0)
			{
				for (String key : compKey)
				{										
					compValue = componentMap.get(key);					
					compKeyArr = key.split("`~");					
					if (compKeyArr != null)
					{						
						if(compKeyArr.length>1){
							CompID = compKeyArr[0];
							srNo = compKeyArr[1];
							resultType = compKeyArr[2];
							if(!resultType.equals("D") && !resultType.equals("E")){
								if (CompIDs.equals(""))
								{
									CompIDs="'"+CompID+"'";
								}
								else
								{
									CompIDs=CompIDs+",'"+CompID+"'";
								}
							}
							if(resultType.equals("I") || resultType.equals("N") || resultType.equals("A"))
							{
							   sqlQry.append(" And exists (select 1 from cr_encounter_detail  Where EVENT_CODE ='"+CompID+"' And EVENT_DATE BETWEEN TO_DATE ('"+fromDate+"', 'dd/mm/yyyy') AND TO_DATE ('"+toDate+"', 'dd/mm/yyyy') + .9999 And patient_id=a.patient_id and hist_rec_type IN ('FDOC','PTCR') and facility_id=b.facility_id and nvl(encounter_id,0)=nvl(b.encounter_id,0) and EVENT_DATE=b.event_date ");
								if (compValue.indexOf("~#") > 0)
								{
									compValArr = compValue.split("~#");
									if (compValArr!= null)
									{
										if (compValArr[0].equals("BT"))
										{
											sqlQry.append(" And RESULT_NUM between '"+compValArr[1]+"' and '"+compValArr[2]+"' ) ");
										}else if (compValArr[0].equals("EQ")){
											sqlQry.append(" And RESULT_NUM = '"+compValArr[1]+"') ");
										}else if (compValArr[0].equals("LT")){
											sqlQry.append(" And RESULT_NUM < '"+compValArr[1]+"' ) ");
										}else if (compValArr[0].equals("GT")){
											sqlQry.append(" And RESULT_NUM > '"+compValArr[1]+"' ) ");
										}
									}

								}else{
									sqlQry.append(" ) ");
								}

							}else if(resultType.equals("L"))
							{
							   sqlQry.append(" And exists (select 1 from cr_encounter_detail  Where EVENT_CODE ='"+CompID+"' And EVENT_DATE BETWEEN TO_DATE ('"+fromDate+"', 'dd/mm/yyyy') AND TO_DATE ('"+toDate+"', 'dd/mm/yyyy') + .9999 And patient_id=a.patient_id and hist_rec_type IN ('FDOC','PTCR') and facility_id=b.facility_id and nvl(encounter_id,0)=nvl(b.encounter_id,0) And RESULT_STR='"+compValue+"'  and EVENT_DATE=b.event_date) ");
							}else if(resultType.equals("C"))
							{
							   sqlQry.append(" And exists (select 1 from cr_encounter_detail  Where EVENT_CODE ='"+CompID+"' And EVENT_DATE BETWEEN TO_DATE ('"+fromDate+"', 'dd/mm/yyyy') AND TO_DATE ('"+toDate+"', 'dd/mm/yyyy') + .9999 And patient_id=a.patient_id and hist_rec_type IN ('FDOC','PTCR') and facility_id=b.facility_id and nvl(encounter_id,0)=nvl(b.encounter_id,0) And SUBSTR(RESULT_STR,1,1)='"+compValue+"'  and EVENT_DATE=b.event_date) ");
							}
							//IN057467 Start.
							else if(resultType.equals("D")  || resultType.equals("E"))
							{
								FrmcompValue = componentMap.get(CompID+"DF")==null?"":componentMap.get(CompID+"DF");
								TocompValue	 = componentMap.get(CompID+"DT")==null?"":componentMap.get(CompID+"DT");								
								if("".equals(FrmcompValue) && !"".equals(TocompValue)){
									FrmcompValue = "01/01/1901";
								}
								if(!"".equals(FrmcompValue) && "".equals(TocompValue)){
									DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
									Date date = new Date();
									TocompValue = dateFormat.format(date);
								}
								if(!"".equals(FrmcompValue) && !"".equals(TocompValue)){
									sqlQry.append(" And exists (select 1 from cr_encounter_detail  Where EVENT_CODE ='"+CompID+"' And EVENT_DATE BETWEEN TO_DATE ('"+fromDate+"', 'dd/mm/yyyy') AND TO_DATE ('"+toDate+"', 'dd/mm/yyyy') + .9999 And patient_id=a.patient_id and hist_rec_type IN ('FDOC','PTCR') and facility_id=b.facility_id and nvl(encounter_id,0)=nvl(b.encounter_id,0) AND to_date(TO_CHAR(to_date(result_str,'DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY') ,'DD/MM/YYYY') BETWEEN to_date(TO_CHAR(to_date('"+FrmcompValue+"' ,'DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY'),'DD/MM/YYYY') AND to_date(TO_CHAR(to_date('"+TocompValue+"' ,'DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY') ,'DD/MM/YYYY') and EVENT_DATE=b.event_date) ");
									dateCompChk = componentMap.get(CompID+"CHK")==null?"N":componentMap.get(CompID+"CHK");
									dateCompFlag = true;
									if (CompIDs.equals(""))
									{
										CompIDs="'"+CompID+"'";
									}
									else
									{
										CompIDs=CompIDs+",'"+CompID+"'";
									}
								}else{
									removeDateChk(CompID);
								}
							}
							//IN057467 End.
						}

					}
				}
			}
		}
		if (!CompIDs.equals(""))
		{
			sqlQry.append(" AND B.EVENT_CODE in ("+CompIDs+")");
		}
		//IN057467 Start.
		if(dateCompFlag){
			addMoreColumns = "result_str,event_code,";
			addMoreGroupColumns=",result_str,event_code";
		}
		//IN057467 End.
		sqlQry.append("  group by a.patient_id, a.patient_name, a.sex, get_age (date_of_birth, greatest(b.event_date,date_of_birth)),  a.date_of_birth,b.patient_class, b.encounter_id "+addMoreGroupColumns);
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;		

		try
		{
			con = ConnectionManager.getConnection();
			pst = con.prepareStatement((sqlQry.toString()).replaceAll("#MORECOLUMNS",addMoreColumns));
			pst.setString(1, fromDate);
			pst.setString(2, toDate);
			
			if(!sex.equals("") && !sex.equals("A"))
			{
				pst.setString(3, sex);
			}

			if((!fromAge.equals("") || !toAge.equals(""))  && (!sex.equals("") && !sex.equals("A")))
			{
				pst.setString(4, fromAge);
				if (fromAgeUint.equals(""))
				{
					fromAgeUint = toAgeUnit;
				}
				pst.setString(5, fromAgeUint);
				pst.setString(6, toAge);
				if (toAgeUnit.equals(""))
				{
					toAgeUnit = fromAgeUint;
				}
				pst.setString(7, toAgeUnit);
			}
			else if((!fromAge.equals("") || !toAge.equals(""))  && (sex.equals("") || sex.equals("A")))
			{
				pst.setString(3, fromAge);
				if (fromAgeUint.equals(""))
				{
					fromAgeUint = toAgeUnit;
				}
				pst.setString(4, fromAgeUint);
				pst.setString(5, toAge);
				if (toAgeUnit.equals(""))
				{
					toAgeUnit = fromAgeUint;
				}
				pst.setString(6, toAgeUnit);
			}


			rs = pst.executeQuery();

			String patient_id = "";
			String patient_name = "";
			String gender = "";
			String age = "";
			String dob = "";
			String patient_class = "";
			String encounter_id = "";
			String occurance = "";
			String resultTxt = "";
			String compId = "";
			while(rs.next())
			{
				patient_id = rs.getString(1)==null?"":rs.getString(1);
				patient_name = rs.getString(2)==null?"":rs.getString(2);
				gender = rs.getString(3)==null?"":rs.getString(3);
				age = rs.getString(4)==null?"":rs.getString(4);
				dob = rs.getString(5)==null?"":rs.getString(5);
				patient_class = rs.getString(6)==null?"":rs.getString(6);
				encounter_id = rs.getString(7)==null?"":rs.getString(7);
				//IN057467 Start.
				if(dateCompFlag){
					resultTxt = rs.getString(8)==null?"":rs.getString(8);
					compId = rs.getString(9)==null?"":rs.getString(9);
					occurance = rs.getString(10)==null?"":rs.getString(10);
					retObj.add(patient_id+"`~"+patient_name+"`~"+gender+"`~"+age+"`~"+dob+"`~"+patient_class+"`~"+encounter_id+"`~"+occurance+"`~"+resultTxt+"`~"+compId);
				}else{
					occurance = rs.getString(8)==null?"":rs.getString(8);
					retObj.add(patient_id+"`~"+patient_name+"`~"+gender+"`~"+age+"`~"+dob+"`~"+patient_class+"`~"+encounter_id+"`~"+occurance);
				}
				//IN057467 End.
			}

			if (rs != null)
			{
				rs.close();
			}

			if (pst != null)
			{
				pst.close();
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con != null)
				{
					con.close();
				}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		
		setQueryResults(retObj);
		return retObj.size()>0?retObj:null;
	}
	//IN057467 Start
	public Map<String, String> getDateCompWithDesc()
	{
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String, String> dateComponent = new HashMap<String, String>();
		StringBuffer sb = new StringBuffer();
		try
		{
			ArrayList dateCompList =(ArrayList) getDateChk();
			
			if(dateCompList.size()>0){
				for(int i=0;i<dateCompList.size();i++){
					if(i==0)
						sb.append("'"+dateCompList.get(i)+"'");
					else
						sb.append(",'"+dateCompList.get(i)+"'");
				}
				String sqlQry = "SELECT DISCR_MSR_ID ,SHORT_DESC FROM AM_DISCR_MSR_LANG WHERE LANGUAGE_ID='en' AND DISCR_MSR_ID IN("+sb.toString()+")";
				
				con = ConnectionManager.getConnection();
				pst = con.prepareStatement(sqlQry);			
				rs = pst.executeQuery();
				while(rs.next())
				{			
					dateComponent.put((rs.getString(1)==null?"":rs.getString(1)),(rs.getString(2)==null?"":rs.getString(2)));								
				}
				if (rs != null)			
					rs.close();		
				if (pst != null)
					pst.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		return dateComponent.keySet().size()>0?dateComponent:null;
	}
	//IN057467 End.
}
