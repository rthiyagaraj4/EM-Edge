/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/04/2018	IN061884		Raja S			18/04/2018		Ramesh G		ML-MMOH-CRF-0536
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7
21/07/2020  	IN072759	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.8
21/09/2020  	IN072760	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.9
26/11/2020	6450		SIVABAGYAM M	26/11/2020		RAMESH G	MO-CRF-20101.10
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
25/10/2021	24460			Ramesh G		25/10/2021		Ramesh G		ML-MMOH-SCF-1911
21/12/2021	25408			Ramesh Goli		21/04/2021		RAMESH G		ML-BRU-CRF-0629.4
21/07/2022 	32036			Ramesh Goli		22/07/2023		RAMESH G 		PMG2022-Common-CRF-0001
20/07/2023	  24094	   Ranjith P R		21/07/2023		RAMESH G		ML-MMOH-CRF-1804
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

import javax.servlet.jsp.PageContext;

import webbeans.eCommon.*;
import java.math.*;

import eCA.Common.CaAdapter;
public class NewClinicalEventHistBean extends CaAdapter implements Serializable {
	HashMap<String,String> records =new HashMap<String,String>();//IN071596 starts
	
	
	public HashMap<String,String> getRecords() {
		return records;
	}

	public void setRecords(HashMap<String,String> records) {
		this.records = records;
	}
//IN071596 ends
//6450 starts
	ArrayList Event_date = new ArrayList();	
	
	public ArrayList getEvent_date() {
		return Event_date;
	}

	public void setEvent_date(ArrayList event_date) {
		Event_date = event_date;
	}//6450 ends

	public ArrayList getHistRecType(Connection con,String locale) throws Exception {
		
		ArrayList eventHist = new ArrayList() ;
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		StringBuffer sbQryCriteria	= new StringBuffer();

		sbQryCriteria.append("select A.HIST_REC_TYPE,A.SHORT_DESC FROM CR_HIS_RECTYP_LNG_VW A, CR_HIST_APPLICABILITY B WHERE A.HIST_REC_TYPE=B.HIST_REC_TYPE AND B.HIST_REC_TYPE_APPL_YN = 'Y' AND LANGUAGE_ID = ? ORDER BY B.SEQ_NUMBER"); //Ramesh
		try{
			pStatment = con.prepareStatement(sbQryCriteria.toString());
			pStatment.setString(1, locale);
			resultSet = pStatment.executeQuery(); 
		 
			if ( resultSet != null ){
				while(resultSet.next()){
					String[] eventHistList  = new String[2];
					eventHistList[0] =(String)resultSet.getString("hist_rec_type");
					eventHistList[1] =(String)resultSet.getString("short_desc");
					eventHist.add(eventHistList); 
				}
			}		
		}catch(Exception e){
			e.printStackTrace();		
		}finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
		}
		return eventHist;
	}
	
	public ArrayList getEventDates(Connection con,String locale,String hist_type,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt,String catalog_nature,String selTab,String fac_id,String abnormal,String eventCls,String eventGrp,String eventItem,String reln_id,String date_Ordr,String patient_class,String facility) throws Exception {//IN069654
	
		ArrayList eventDate = new ArrayList() ;
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		int i=1;
		String modified_date 			=	"";//24094
		String modified_date_YN 			=	"";//24094
		String event_date 			=	"";//24094
		StringBuffer sbQryCriteria	= new StringBuffer(); 
		if(selTab.equals("S"))
			selTab="self_tab";
		if(selTab.equals("M"))
			selTab="my_tab";
		if("CLNT".equals(hist_type) || "RDIN".equals(hist_type)||"SUNT".equals(hist_type)){//IN072760
			sbQryCriteria.append("Select  TO_CHAR (a.event_date, 'dd/mm/rrrr hh24:mi') event_dt, ");
		}else{
			sbQryCriteria.append("Select distinct TO_CHAR (a.event_date, 'dd/mm/rrrr hh24:mi') event_dt, ");
		}
		sbQryCriteria.append("to_char(event_date,'YYYYMMDDHH24MI')  sort_event_date_time,TO_CHAR (a.modified_date, 'dd/mm/rrrr hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? AND a.patient_class = NVL(?,patient_class) ");//24094
		if("LBIN".equals(hist_type)){
			//sbQryCriteria.append(" and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) ");//common-icn-0180
			sbQryCriteria.append(" and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?)='A')) ");//common-icn-0180
		}
		//IN072760 STARTS
		if("SUNT".equals(hist_type))
		{
			sbQryCriteria.append(" and nvl(PROTECTION_IND,'N')!='Z'");
		}
		//IN072760 ENDS
		//sbQryCriteria.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' ");//common-icn-0180
		//IN072760 STARTS
		sbQryCriteria.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' ");//common-icn-0180
		
		if("SUNT".equals(hist_type))
		{
			sbQryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')");
		}
		//IN072760 ENDS
		if(!"RDIN".equals(hist_type) && !"SUNT".equals(hist_type)) //IN072760
			sbQryCriteria.append("and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");
	//IN072759 ENDS
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
	
		sbQryCriteria.append(" and a.hist_rec_type=?");
		if(!fac_id.equals(""))
			sbQryCriteria.append("and a.FACILITY_ID = ?");
	
		if("self_tab".equals(selTab)){
			if("LBIN".equals(hist_type) ||"RDIN".equals(hist_type)){ //IN072759//IN072760
				sbQryCriteria.append(" and a.PRACTITIONER_ID=? ");
			}else if("SUNT".equals(hist_type))
			{
				sbQryCriteria.append(" and a.PERFORMED_BY_ID=? ");
			}
			else{
				sbQryCriteria.append(" and  a.AUTHORIZED_BY_ID=? ");
			}
		}
		if("my_tab".equals(selTab)){
			if("LBIN".equals(hist_type) ||"RDIN".equals(hist_type)){//IN072760
			sbQryCriteria.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id) ");
			}
			else if("SUNT".equals(hist_type))
			{	
				sbQryCriteria.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PERFORMED_BY_ID,?,a.facility_id) ");
			}
			else
			{
				sbQryCriteria.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.AUTHORIZED_BY_ID,?,a.facility_id) ");
			}
		}
		if("Y".equals(abnormal))
			sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
	
		if(!eventCls.equals(""))
			sbQryCriteria.append(" and a.event_class = ? ");
	
		if(!eventGrp.equals(""))
			sbQryCriteria.append(" and a.event_group = ? ");
	
		if(!eventItem.equals(""))
			sbQryCriteria.append(" and a.event_code = ? ");	
	
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group )");
	
		if(!"".equals(from_dt))
			sbQryCriteria.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");

		if(!"".equals(to_Dt))
			sbQryCriteria.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 ");
		//IN069654 starts
		if(date_Ordr.equals("D"))
			sbQryCriteria.append(" order by sort_event_date_time desc");
		else
			sbQryCriteria.append(" order by sort_event_date_time asc");
		//IN069654 ends
		
		
		try{
			pStatment = con.prepareStatement(sbQryCriteria.toString());
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, patient_id);
			pStatment.setString(i++, patient_class);		
			//common-icn-0180 starts
			if("LBIN".equals(hist_type)){
				pStatment.setString(i++, resp_id);		
				pStatment.setString(i++, reln_id);		
			}
			//common-icn-0180 end
			pStatment.setString(i++, clinician_id);//common-icn-0180
			pStatment.setString(i++, resp_id);//common-icn-0180	
			if(!encounter_id.equals("")){
				pStatment.setString(i++, encounter_id);
			}
			pStatment.setString(i++, hist_type);
			if(!fac_id.equals("")){
				pStatment.setString(i++, fac_id);
			}
			if("self_tab".equals(selTab)){
				pStatment.setString(i++, clinician_id);
			} 
			if("my_tab".equals(selTab)){
				pStatment.setString(i++, clinician_id);		
			}
		 
			if(!eventCls.equals("")){
				pStatment.setString(i++, eventCls);
			}	
			if(!eventGrp.equals("")){
				pStatment.setString(i++, eventGrp);
			}	
			if(!eventItem.equals("")){
				pStatment.setString(i++, eventItem);
			}
			if("LBIN".equals(hist_type)){
				 pStatment.setString(i++, catalog_nature);
			}
			if(!"".equals(from_dt)){
				pStatment.setString(i++, from_dt);
			}
			if(!"".equals(to_Dt)){
				 pStatment.setString(i++, to_Dt);
			}
			resultSet = pStatment.executeQuery(); 
		 
			if ( resultSet != null ){
				 //24094 starts
				HashMap<String,String>  resultMap=null;//24094
				while(resultSet.next()){
					resultMap= new HashMap<String,String>();//24094
					modified_date  		=	resultSet.getString("modified_date")==null?"":resultSet.getString("modified_date");
					modified_date_YN  		=	resultSet.getString("modifiedyn")==null?"":resultSet.getString("modifiedyn");
					event_date     =    resultSet.getString("event_dt")==null?"":resultSet.getString("event_dt");
					//eventDate.add(resultSet.getString("event_dt")==null?"":resultSet.getString("event_dt"));
					resultMap.put("Modified_Date",modified_date);
					resultMap.put("Event_Date",event_date);
					resultMap.put("Modified_Date_YN",modified_date_YN);
					eventDate.add(resultMap);
					//24094 ends
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
		}

		return eventDate;
	}

	public ArrayList getEventTree(Connection con,String locale,String hist_type,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt,String catalog_nature,String selTab,String fac_id,String abnormal,String eventCls,String eventGrp,String eventItem,String reln_id,String patient_class,String facility) throws Exception {
	
		ArrayList eventTreeVal = new ArrayList() ;
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		int i=1;
		StringBuffer sbQryCriteria	= new StringBuffer();

		if(selTab.equals("S"))
			selTab="self_tab";
		if(selTab.equals("M"))
			selTab="my_tab";
			
		//sbQryCriteria.append("Select a.event_date dummydate,TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') event_date_time,a.hist_rec_type hist_type, a.event_class event_class, c.long_desc event_class_desc,NVL (a.event_group, '*ALL') event_group,NVL (e.long_desc, d.long_desc) event_group_desc,a.event_code eve_code, d.long_desc event_desc, a.HIST_DATA_TYPE,a.result_num_uom  From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? AND a.patient_class = NVL(?,patient_class) and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) and nvl(ca_view_confidnt_event(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");//common-icn-0180
	
		sbQryCriteria.append("Select a.event_date dummydate,TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') event_date_time,a.hist_rec_type hist_type, a.event_class event_class, c.long_desc event_class_desc,NVL (a.event_group, '*ALL') event_group,NVL (e.long_desc, d.long_desc) event_group_desc,a.event_code eve_code, d.long_desc event_desc, a.HIST_DATA_TYPE,a.result_num_uom  From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? AND a.patient_class = NVL(?,patient_class) and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?)='A')) and nvl(ca_view_confidnt_event(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");//common-icn-0180
		
	
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
	
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group ) ");
		
		sbQryCriteria.append("and a.hist_rec_type=?");
	
		if(!fac_id.equals(""))
			sbQryCriteria.append(" and a.FACILITY_ID = ?");

		if("self_tab".equals(selTab)){
			if("LBIN".equals(hist_type)){
				sbQryCriteria.append(" and a.PRACTITIONER_ID=? ");
			}else{
				sbQryCriteria.append(" and a.PERFORMED_BY_ID=? ");
			}
		}
		
		if("my_tab".equals(selTab))
			sbQryCriteria.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id) ");
	
		if("Y".equals(abnormal))
			sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		
		if(!eventCls.equals(""))
			sbQryCriteria.append(" and a.event_class = ? ");
		
		if(!eventGrp.equals(""))
			sbQryCriteria.append(" and a.event_group = ? ");
		
		if(!eventItem.equals(""))
			sbQryCriteria.append(" and a.event_code = ? ");	
		
		if(!"".equals(from_dt))
			sbQryCriteria.append("and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi' ) ");
			
		if(!"".equals(to_Dt))
			sbQryCriteria.append("and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 "); 
	
		sbQryCriteria.append("order by event_class_desc,event_group_desc asc,nvl(a.request_num_seq,'0')"); 

		try{
			pStatment = con.prepareStatement(sbQryCriteria.toString());
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, patient_id);
			pStatment.setString(i++, patient_class);
		    pStatment.setString(i++, resp_id);//common-icn-0180
		    pStatment.setString(i++, reln_id);//common-icn-0180
		    pStatment.setString(i++, clinician_id);//common-icn-0180
		    pStatment.setString(i++, resp_id);//common-icn-0180
			if(!encounter_id.equals(""))
				pStatment.setString(i++, encounter_id);
			
			if("LBIN".equals(hist_type))
				pStatment.setString(i++, catalog_nature);
			
			pStatment.setString(i++, hist_type);
			
			if(!fac_id.equals(""))
				pStatment.setString(i++, fac_id);

			if("self_tab".equals(selTab))
				pStatment.setString(i++, clinician_id);

			if("my_tab".equals(selTab)){
				pStatment.setString(i++, clinician_id);
			}
	 
			if(!eventCls.equals(""))
				pStatment.setString(i++, eventCls);

			if(!eventGrp.equals(""))
				pStatment.setString(i++, eventGrp);

			if(!eventItem.equals(""))
				pStatment.setString(i++, eventItem);	

			if(!"".equals(from_dt))
				pStatment.setString(i++, from_dt);
			
			if(!"".equals(to_Dt))
				pStatment.setString(i++, to_Dt);
			
			resultSet = pStatment.executeQuery(); 
	 
			if ( resultSet != null ){
				while(resultSet.next()){
					String[] event_list  = new String[8];
					event_list[0]=resultSet.getString("event_group")==null?"":resultSet.getString("event_group");
					event_list[1]=resultSet.getString("event_group_desc")==null?"":resultSet.getString("event_group_desc");
					event_list[2]=resultSet.getString("eve_code")==null?"":resultSet.getString("eve_code");
					event_list[3]=resultSet.getString("event_desc")==null?"":resultSet.getString("event_desc");
					event_list[4]=resultSet.getString("event_class_desc")==null?"":resultSet.getString("event_class_desc");
					event_list[5]=resultSet.getString("event_class")==null?"":resultSet.getString("event_class");
					event_list[6]=resultSet.getString("HIST_DATA_TYPE")==null?"":resultSet.getString("HIST_DATA_TYPE");
					event_list[7]=resultSet.getString("result_num_uom")==null?"":resultSet.getString("result_num_uom");
					eventTreeVal.add(event_list); 
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
		}
		return eventTreeVal;
	}

	public LinkedHashMap getEventDetails(PageContext pageContext,Connection con,String locale,String login_user,String hist_type,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt,String catalog_nature,String selTab,String fac_id,String abnormal,String eventCls,String eventGrp,String eventItem,String reln_id,String patient_class,String facility) throws Exception {
	
		PreparedStatement pStatment = null; 
		ResultSet resultSet = null;
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		int i=1;
		StringBuffer sbQryCriteria	= new StringBuffer();
	
		HashMap<String,ArrayList> clinicalHistoryDate= new HashMap<String,ArrayList>();
		LinkedHashMap<String,HashMap> clinicalHistoryValues= new LinkedHashMap<String,HashMap>();
		LinkedHashMap<String,HashMap> tempClinicalHistValues= new LinkedHashMap<String,HashMap>();
		LinkedHashMap<String,LinkedHashMap> clinicalHistGrpValues= new LinkedHashMap<String,LinkedHashMap>();
	

		String tempDateTime  ="";
		String tempEventCode ="";
		String tempEventGroup = "";
		ArrayList tempEventDetails=new ArrayList();
		int recCount = 0;
		boolean isPracSiteSpecific = false;
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER");
		boolean isDisToolTipStr = false;
		isDisToolTipStr = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","DIS_STR_TOOLTIP"); 

		String event_dtime = "";
		String toolTip_ind = "";
	
		StringBuffer tempNormCritStr = new StringBuffer();
		String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
		String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
	
	
		if(selTab.equals("S"))
			selTab="self_tab";
		if(selTab.equals("M"))
			selTab="my_tab";

		//6484 Start.
		//sbQryCriteria.append("Select substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) accession_num,CATEGORY_NUMBER,facility_id,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(A.EVENT_DATE,'DD/MM/YYYY') evedate,nvl(a.request_num_seq,'0') req_num ,to_char(A.EVENT_DATE,'HH24:mi') evetime,a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC    ,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?) GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL(( SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code, 'NONE') FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE') FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR, LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1,RESULT_NUM_DEC, a.event_code_type,(select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type From cr_encounter_detail a WHERE a.patient_id = ? AND a.patient_class = NVL(?,patient_class)");//IN071263
		sbQryCriteria.append("Select substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) accession_num,CATEGORY_NUMBER,facility_id,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(A.EVENT_DATE,'DD/MM/YYYY') evedate,nvl(a.request_num_seq,'0') req_num ,to_char(A.EVENT_DATE,'HH24:mi') evetime,a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC    ,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?) GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL(( SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code, 'NONE') FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE') FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR, LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,NVL(a.PERFORMING_FACILITY_ID,a.FACILITY_ID) PERFORMING_FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1,RESULT_NUM_DEC, a.event_code_type,(select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type From cr_encounter_detail a WHERE a.patient_id = ? AND a.patient_class = NVL(?,patient_class)");//IN071263 // ADD PERFORMING_FACILITY_ID  for 32036
		//6484 End.
		if(!"".equals(from_dt))
			sbQryCriteria.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI') ");

		if(!"".equals(to_Dt))
			sbQryCriteria.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287 ");
	
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
	
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group )");
		
		if("self_tab".equals(selTab)){
			if("LBIN".equals(hist_type)){
				sbQryCriteria.append(" and a.PRACTITIONER_ID=? ");
			}else{
				sbQryCriteria.append(" and a.PERFORMED_BY_ID=? ");
			}
		}
	
		if("my_tab".equals(selTab))
			sbQryCriteria.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id) ");
		
		if("Y".equals(abnormal))
			sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		
		if(!eventCls.equals(""))
			sbQryCriteria.append(" and a.event_class = ? ");
		
		if(!eventGrp.equals(""))
			sbQryCriteria.append(" and a.event_group = ? ");
		
		if(!eventItem.equals(""))
			sbQryCriteria.append(" and a.event_code = ? ");	
	
		sbQryCriteria.append("and a.hist_rec_type=? ");
	
		if(!fac_id.equals(""))
			sbQryCriteria.append(" and a.FACILITY_ID = ?");
	
		//sbQryCriteria.append(" and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and nvl(a.STATUS,'`') not in('S','E') ORDER BY event_class_desc,event_group_desc asc, NVL (a.request_num_seq, '0')");//common-icn-0180
	
		sbQryCriteria.append(" and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?)='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and nvl(a.STATUS,'`') not in('S','E') ORDER BY event_class_desc,event_group_desc asc, NVL (a.request_num_seq, '0')");//common-icn-0180
		
	
		try{
			pStatment = con.prepareStatement(sbQryCriteria.toString());
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, patient_id);
			pStatment.setString(i++, patient_class);
			
			if(!"".equals(from_dt))
				pStatment.setString(i++, from_dt);
			
			if(!"".equals(to_Dt))
				pStatment.setString(i++, to_Dt);
			
			if(!encounter_id.equals(""))
				pStatment.setString(i++, encounter_id);

			if("LBIN".equals(hist_type))
				pStatment.setString(i++, catalog_nature);

			if("self_tab".equals(selTab))
				pStatment.setString(i++, clinician_id);

			if("my_tab".equals(selTab)){
				pStatment.setString(i++, clinician_id);
			}
			
			if(!eventCls.equals(""))
				pStatment.setString(i++, eventCls);

			if(!eventGrp.equals(""))
				pStatment.setString(i++, eventGrp);

			if(!eventItem.equals(""))
				pStatment.setString(i++, eventItem);

			pStatment.setString(i++, hist_type);
			
			if(!fac_id.equals(""))
				pStatment.setString(i++, fac_id);

			pStatment.setString(i++, resp_id);//common-icn-0180
			pStatment.setString(i++, reln_id);//common-icn-0180
			pStatment.setString(i++, clinician_id);//common-icn-0180
			pStatment.setString(i++, resp_id);//common-icn-0180
			resultSet = pStatment.executeQuery(); 
			if ( resultSet != null ){
				while(resultSet.next()){
					tempNormCritStr.setLength(0);				
					String normalrange 		= "";
					String resultNum  		= "";
					String normalLow 		= "";
					String normalHigh 		= "";
					String criticalrange 	= "";
					String resulted_practitioner = resultSet.getString("resulted_practitioner")==null?"":resultSet.getString("resulted_practitioner");
					String performed_by = resultSet.getString("performed_by")==null?"":resultSet.getString("performed_by");
					BigDecimal nl =resultSet.getBigDecimal("normal_low");
				
					if(nl!=null)
						normalLow =nl.toString();
					else
						normalLow ="";
					
					BigDecimal nh =resultSet.getBigDecimal("normal_high");
					
					if(nh!=null)
						normalHigh=nh.toString();
					else
						normalHigh="";
				
				
					String resultNumUOM = resultSet.getString("uom")==null?"":resultSet.getString("uom");
					String criticalHigh = resultSet.getString("critical_high")==null?"":resultSet.getString("critical_high");
					String criticalLow = resultSet.getString("critical_low")==null?"":resultSet.getString("critical_low");
					String accession_num=resultSet.getString("accession_num") == null ? "" : resultSet.getString("accession_num");//IN070032
					String category_number=resultSet.getString("CATEGORY_NUMBER") == null ? "" : resultSet.getString("CATEGORY_NUMBER");//IN070032
					String specimen_type=resultSet.getString("specimen_type") == null ? "" : resultSet.getString("specimen_type");//7632
					
					if(!normalLow.equals("") && !normalHigh.equals(""))
						normalrange = Normal_Range + " : " + normalLow + " - " + normalHigh + " " + resultNumUOM;
					else if(!normalLow.equals("") && normalHigh.equals(""))
						normalrange = Normal_Range + " : (>=" + normalLow + " " + resultNumUOM + ")";
					else if(normalLow.equals("") && !normalHigh.equals(""))
						normalrange = Normal_Range + " : (<=" + normalHigh + " " + resultNumUOM + ")";
					else
						normalrange = "";
			
					if(!criticalLow.equals("") && !criticalHigh.equals("")){
						criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
					}else if(!criticalLow.equals("") && criticalHigh.equals("")){
						criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+")" ;
					}else if(criticalLow.equals("") && !criticalHigh.equals("")){
						criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
					}else
						criticalrange = "";
				
					if(!normalrange.equals("") && !criticalrange.equals(""))
						tempNormCritStr.append(normalrange+"<br> "+criticalrange);
					else if(!normalrange.equals(""))
						tempNormCritStr.append(normalrange);
					else if(!criticalrange.equals(""))
						tempNormCritStr.append(criticalrange);
					else
						tempNormCritStr.append("");
				
					if(isPracSiteSpecific && "LBIN".equals(hist_type))
					{
						if(!resulted_practitioner.equals(""))
						{
							if(!(tempNormCritStr.toString()).equals("")){
								tempNormCritStr.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + resulted_practitioner );//IN070032//7632 removed performed by
								tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Specimen.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+":"+accession_num);//IN070032
								tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+":"+category_number);//IN070032
								tempNormCritStr.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenType.label","or_labels")+" : " + specimen_type);//7632

							}
						}
					}else{
						if(!performed_by.equals(""))
						{
							if(!(tempNormCritStr.toString()).equals("")){
								tempNormCritStr.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + performed_by );//IN070032//7632 removed performed by
								tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Specimen.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+":"+accession_num);//IN070032
								tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+":"+category_number);//IN070032
								tempNormCritStr.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenType.label","or_labels")+" : " + specimen_type);//7632
							}
						}
					}
				
					String histDataType = resultSet.getString("HIST_DATA_TYPE")==null?"":resultSet.getString("HIST_DATA_TYPE");
					String tempVal = "";
					String resultStr = resultSet.getString("res_str") == null ? "" : resultSet.getString("res_str");
				
					if(resultStr.length()>200){
						tempVal=resultStr.substring(0,200);
					}else{
						tempVal=resultStr; 
					}
					
					if(histDataType.equals("STR") && isDisToolTipStr){
						toolTip_ind=tempVal;
					}else
						toolTip_ind = tempNormCritStr.toString();

					event_dtime =resultSet.getString("event_date_time")==null?"":resultSet.getString("event_date_time");
			
					ArrayList<String> eventDetails = new ArrayList<String>() ;
					String event_code = resultSet.getString("eve_code")==null?"":resultSet.getString("eve_code");

					eventDetails.add(resultSet.getString("event_date_time")==null?"":resultSet.getString("event_date_time"));
					eventDetails.add(resultSet.getString("evedate")==null?"":resultSet.getString("evedate"));
					eventDetails.add(resultSet.getString("evetime")==null?"":resultSet.getString("evetime"));
				
					BigDecimal rn =resultSet.getBigDecimal("result_num");
					if(rn!=null)
						resultNum=rn.toString();
					else
						resultNum="";
				
					String colorCellInd = resultSet.getString("COLOR_CELL_IND")==null?"":resultSet.getString("COLOR_CELL_IND");
					String normIndicator = resultSet.getString("norm_ind") == null ? "" : resultSet.getString("norm_ind");
					String normal_Yn = "N";
					String event_group = resultSet.getString("event_group") == null ? "" : resultSet.getString("event_group");
					
					if(histDataType.equals("NUM")){
						if(!resultNum.equals("")){
							if(colorCellInd.equals("NONE")){
								if(normIndicator.equals("."))
									normal_Yn = "Y";
								else if(!normalLow.equals("") && !normalHigh.equals("")){
									if(Float.parseFloat(resultNum) > 0)
									{
										if ((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)) )
										{
											normal_Yn = "Y";
										}
										else
											normal_Yn = "N";
									}else
										normal_Yn = "N";
								}else if(!normalLow.equals("") && normalHigh.equals("")){
									if(Float.parseFloat(resultNum) > 0)
									{
										if (Float.parseFloat(resultNum) >= Float.parseFloat(normalLow))
										{
											normal_Yn = "Y";
										}
										else
											normal_Yn = "N";
									}else
										normal_Yn = "N";
								}else if(normalLow.equals("") && !normalHigh.equals("")){
									if(Float.parseFloat(resultNum) > 0)
									{
										if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
										{
											normal_Yn = "Y";
										}
										else
											normal_Yn = "N";
									}else
										normal_Yn = "N";
								}else
									normal_Yn = "N";
							}else
								normal_Yn = "N";
						}
					}else if(normIndicator.equals("."))
						normal_Yn = "Y";
					else
						normal_Yn = "N";

					if(resultSet.getString("RESULT_NUM_PREFIX") != null && !(resultSet.getString("RESULT_NUM_PREFIX")).equals(""))
						resultNum = resultSet.getString("RESULT_NUM_PREFIX") + resultNum;

					eventDetails.add(resultNum);
					eventDetails.add(resultSet.getString("RES_STR")==null?"":resultSet.getString("RES_STR"));
					eventDetails.add(resultSet.getString("HIST_DATA_TYPE")==null?"":resultSet.getString("HIST_DATA_TYPE"));
					eventDetails.add(resultSet.getString("ext_appl_id")==null?"":resultSet.getString("ext_appl_id"));
					
					eventDetails.add(resultSet.getString("sys_id")==null?"":resultSet.getString("sys_id"));
					eventDetails.add(resultSet.getString("acc_num")==null?"":resultSet.getString("acc_num"));
					eventDetails.add(resultSet.getString("sys_eve_code")==null?"":resultSet.getString("sys_eve_code"));
					eventDetails.add(resultSet.getString("ext_img_id")==null?"":resultSet.getString("ext_img_id"));
					String extImgID=resultSet.getString("ext_img_id")==null?"":resultSet.getString("ext_img_id");
					String ext_image_upld_id = resultSet.getString("EXT_IMAGE_UPLD_ID") == null ? "" : resultSet.getString("EXT_IMAGE_UPLD_ID");
					String ext_img_file_locn ="";
					String recCountInt ="";
				
					if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {					
						pstmt = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
						pstmt.setString(1,ext_image_upld_id);
						rset = pstmt.executeQuery();
						while(rset.next())
						{
							ext_img_file_locn = rset.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : rset.getString("EXT_IMAGE_FILE_LOCN_PARAM");
						}
						
						if(rset != null) rset.close();
						
						String perfFacilityId = "";
						pstmt = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
						pstmt.setString(1,extImgID);
						rset = pstmt.executeQuery();
						if(rset.next()){
							perfFacilityId = rset.getString("PERFORMING_FACILITY_ID") == null ? "":  rset.getString("PERFORMING_FACILITY_ID");
						}
						
						if(rset != null) rset.close();
						
						if(perfFacilityId.equals("") || perfFacilityId == null){
							perfFacilityId = getOrderIdFromSpecimen(extImgID,con);
						}
						
						pstmt = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?");
						pstmt.setString(1,perfFacilityId);
						pstmt.setString(2,extImgID); 
						pstmt.setString(3,event_group);
						rset = pstmt.executeQuery();
						if(rset.next()) 
						{
							recCount = rset.getInt(1);
						}
						
						if(rset != null) rset.close();
				
						recCountInt = String.valueOf(recCount);
				
						ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // modified for IN040416
					}
				
					eventDetails.add(resultSet.getString("GetTooltip")==null?"":resultSet.getString("GetTooltip"));
					eventDetails.add(toolTip_ind);
					eventDetails.add(resultSet.getString("delta_fail_ind")==null?"":resultSet.getString("delta_fail_ind"));
					eventDetails.add(resultSet.getString("QUICK_TEXT_COUNT")==null?"":resultSet.getString("QUICK_TEXT_COUNT"));
					eventDetails.add(resultSet.getString("stat")==null?"":resultSet.getString("stat"));
					eventDetails.add(resultSet.getString("text_count")==null?"":resultSet.getString("text_count"));
					eventDetails.add(resultSet.getString("COLOR_CELL_IND")==null?"":resultSet.getString("COLOR_CELL_IND"));
					eventDetails.add(resultSet.getString("DESC_CELL_IND")==null?"":resultSet.getString("DESC_CELL_IND"));
					eventDetails.add(resultSet.getString("norm_ind")==null?"":resultSet.getString("norm_ind"));
					eventDetails.add(resultSet.getString("eve_code")==null?"":resultSet.getString("eve_code"));
					eventDetails.add(resultSet.getString("event_desc")==null?"":resultSet.getString("event_desc"));
					eventDetails.add(resultSet.getString("LEGEND_TYPE")==null?"S":resultSet.getString("LEGEND_TYPE"));
					eventDetails.add(resultSet.getString("normalcy_str")==null?"":resultSet.getString("normalcy_str"));
					eventDetails.add(resultSet.getString("FACILITY_ID")==null?"":resultSet.getString("FACILITY_ID"));
					eventDetails.add(resultSet.getString("EXT_IMAGE_UPLD_ID")==null?"":resultSet.getString("EXT_IMAGE_UPLD_ID"));
					eventDetails.add(resultSet.getString("EVENT_CODE_TYPE")==null?"":resultSet.getString("EVENT_CODE_TYPE"));
					eventDetails.add(recCountInt);
					eventDetails.add(ext_img_file_locn);
					eventDetails.add(resultSet.getString("SYMBOL_LEGEND_IND")==null?"":resultSet.getString("SYMBOL_LEGEND_IND"));
					eventDetails.add(normal_Yn);
					eventDetails.add(resultSet.getString("event_group")==null?"":resultSet.getString("event_group"));
					eventDetails.add(resultSet.getString("eve_class")==null?"":resultSet.getString("eve_class"));
					eventDetails.add(resultSet.getString("req_num")==null?"":resultSet.getString("req_num"));
					eventDetails.add(resultSet.getString("accession_num")==null?"":resultSet.getString("accession_num"));//IN070032
					eventDetails.add(resultSet.getString("eve_code")==null?"":resultSet.getString("eve_code"));//IN070032
					eventDetails.add(resultSet.getString("PERFORMING_FACILITY_ID")==null?"":resultSet.getString("PERFORMING_FACILITY_ID"));//IN032036
					String req_num=resultSet.getString("req_num")==null?"":resultSet.getString("req_num");
					
					if(tempEventCode.equals("")){
						clinicalHistoryDate.put(event_dtime,eventDetails);
					}else{
						if(event_code.equals(tempEventCode)){
							clinicalHistoryDate.put(event_dtime,eventDetails);
						}else{
							clinicalHistoryValues.put(tempEventCode, clinicalHistoryDate);
							clinicalHistoryDate= new HashMap<String,ArrayList>();
							clinicalHistoryDate.put(event_dtime,eventDetails);
						}
						
						if(tempEventGroup.equals("") || tempEventGroup.equals(event_group)){
							
						}else{
							clinicalHistGrpValues.put(tempEventGroup, tempClinicalHistValues);
							clinicalHistoryValues= new LinkedHashMap<String,HashMap>();
						}
						
					}
					tempClinicalHistValues=clinicalHistoryValues;
					tempEventDetails=eventDetails;
					tempDateTime=event_dtime;
					tempEventCode=event_code;
					tempEventGroup =event_group+"|"+req_num;
				
				}
				
				clinicalHistoryValues.put(tempEventCode, clinicalHistoryDate);
				clinicalHistGrpValues.put(tempEventGroup, clinicalHistoryValues);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
		}

		return clinicalHistGrpValues;
	}
	public String getOrderIdFromSpecimen(String specimen_no,Connection con) throws Exception{
		String order_id = "";
		String perf_facility_id = "";
		String fetchQuery = "";

		PreparedStatement prepStat = null;
		ResultSet resultSet =  null;
	
		try {
			fetchQuery =  "SELECT ORDER_ID FROM RL_INTERVAL_TEST_SPECIMENS WHERE SPECIMEN_NO = ?";
			prepStat = con.prepareStatement(fetchQuery);
			prepStat.setString(1, specimen_no);
			resultSet = prepStat.executeQuery();
			if(resultSet.next()){
				order_id = resultSet.getString("ORDER_ID");
			}
			if(resultSet != null) resultSet.close();
			if(order_id != null && !order_id.equals("")) {
				fetchQuery = "SELECT PERFORMING_FACILITY_ID FROM OR_ORDER WHERE ORDER_ID = ?";
				prepStat = con.prepareStatement(fetchQuery);
				prepStat.setString(1, order_id);
				resultSet = prepStat.executeQuery();
				if(resultSet.next()){
					perf_facility_id = resultSet.getString("PERFORMING_FACILITY_ID");
				}
			}
		}
		catch(Exception ex){
			System.out.println("231. Error in PatientBannerGroupLine.java ==> " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(prepStat != null) prepStat.close();
		}
		return perf_facility_id;
	}
	public String replaceSpecialChar(String resultStr){		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~ ");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		/*if(resultStr.indexOf("'")!=-1) //ML-BRU-SCF-1642 - IN057138 - Start
			resultStr = resultStr.replaceAll("'","`"); 
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","|"); */
		if(resultStr.indexOf("\\")!=-1) 
			resultStr = resultStr.replaceAll("\\\\","&#92");
		if(resultStr.indexOf("|")!=-1) 
			resultStr = resultStr.replaceAll("\\|","&#124");
		if(resultStr.indexOf("`")!=-1) 
			resultStr = resultStr.replaceAll("`","&#96");			
		if(resultStr.indexOf("'")!=-1) 
			resultStr = resultStr.replaceAll("'","&#39");
		if(resultStr.indexOf("~")!=-1) 
			resultStr = resultStr.replaceAll("~","&#126");
		if(resultStr.indexOf("\"")!=-1) 
			resultStr = resultStr.replaceAll("\"","\\\"");		
		if(resultStr.indexOf("+")!=-1) 
			resultStr = resultStr.replaceAll("\\+","&#43");	//ML-BRU-SCF-1642 - IN057138 - End
		return resultStr;
	}
	public String callOnlinePrint(String locale,String hist_type,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt,String catalog_nature,String selTab,String fac_id,String abnormal,String eventCls,String eventGrp,String eventItem,String p_user_name,String reln_id,String facility) throws SQLException{

		Connection connection 		= null;
		PreparedStatement pstmt1 	= null;
		CallableStatement pstmt2 	= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet1 		= null;
		ResultSet resultSet 		= null;
		String orderCatalogCode		= "";
	
		connection = ConnectionManager.getConnection() ;
		pstmt1 = connection.prepareStatement( "SELECT EXT_IMAGE_APPL_ID FROM CA_EXT_IMAGE_APPL WHERE EXT_IMAGE_APPL_ID='IBARL'") ;
		resultSet1 = pstmt1.executeQuery() ;
		String checkIbarl_ = "";
		PreparedStatement pStatment = null;
		ResultSet rs = null;
		
		if(resultSet1.next()){ checkIbarl_ = resultSet1.getString("EXT_IMAGE_APPL_ID");}
		pstmt = connection.prepareStatement( "SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE CONTR_MSR_PANEL_ID = ?") ;
		pstmt.setString(1, eventGrp);
		rs = pstmt.executeQuery() ;
		if(rs.next()){ orderCatalogCode = rs.getString("ORDER_CATALOG_CODE")==null?"":rs.getString("ORDER_CATALOG_CODE");}
		
		if("IBARL".equals(checkIbarl_)){
			pstmt2 = connection.prepareCall("{ call RL_RES_REPORT_FOR_CA.ins_report_details(?,?,?,?,?,?,?,?,?) }");//IN061961
			try
			{

				int i=1;
				StringBuffer sbQryCriteria	= new StringBuffer(); 

				//sbQryCriteria.append("Select distinct substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) accession_num,facility_id From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E') ");//common-icn-0180
				
				sbQryCriteria.append("Select distinct substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) accession_num,facility_id From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?)='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E') ");//common-icn-0180
				
				if(!encounter_id.equals(""))
					sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
				
				sbQryCriteria.append(" and a.hist_rec_type=? ");
				
				if(!fac_id.equals(""))
					sbQryCriteria.append("and a.FACILITY_ID = ?");
				
				if("self_tab".equals(selTab))
					sbQryCriteria.append(" and a.PRACTITIONER_ID=? ");
					
				if("my_tab".equals(selTab))
					sbQryCriteria.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id) ");
				
				if("Y".equals(abnormal))
					sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
				
				if(!eventCls.equals(""))
					sbQryCriteria.append(" and a.event_class = ? ");
				
				if(!eventGrp.equals(""))
					sbQryCriteria.append(" and a.event_group = ? ");
				
				if(!eventItem.equals(""))
					sbQryCriteria.append(" and a.event_code = ? ");	
				
				if("LBIN".equals(hist_type))
					sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group )");
				
				if(!"".equals(from_dt))
					sbQryCriteria.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");

				if(!"".equals(to_Dt))
					sbQryCriteria.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 ");

				 pStatment = connection.prepareStatement(sbQryCriteria.toString());
				 pStatment.setString(i++, locale);
				 pStatment.setString(i++, locale);
				 pStatment.setString(i++, locale);
				 pStatment.setString(i++, locale);
				 pStatment.setString(i++, patient_id);
				 pStatment.setString(i++, resp_id);//common-icn-0180
				 pStatment.setString(i++, reln_id);//common-icn-0180
				 pStatment.setString(i++, clinician_id);//common-icn-0180
				 pStatment.setString(i++, resp_id);//common-icn-0180
				 if(!encounter_id.equals(""))
					 pStatment.setString(i++, encounter_id);
				 pStatment.setString(i++, hist_type);
				 if(!fac_id.equals(""))
				 pStatment.setString(i++, fac_id);
				 
				 if("self_tab".equals(selTab))
					 pStatment.setString(i++, clinician_id);
				 
				 if("my_tab".equals(selTab)){
					 pStatment.setString(i++, clinician_id);
				 }
				 
				if(!eventCls.equals(""))
					pStatment.setString(i++, eventCls);
						
				if(!eventGrp.equals(""))
					pStatment.setString(i++, eventGrp);
						
				if(!eventItem.equals(""))
					pStatment.setString(i++, eventItem);
					
				 if("LBIN".equals(hist_type))
					 pStatment.setString(i++, catalog_nature);
				 
				 if(!"".equals(from_dt))
					pStatment.setString(i++, from_dt);
				 if(!"".equals(to_Dt))
					 pStatment.setString(i++, to_Dt);
				 resultSet = pStatment.executeQuery(); 
				 if ( resultSet != null )
				 {
						while(resultSet.next())
						{
							String l_specimen_no = resultSet.getString("accession_num")==null?"":resultSet.getString("accession_num");
							String facility_id =resultSet.getString("facility_id")==null?"":resultSet.getString("facility_id");
							pstmt2.setString(1, facility_id);
							pstmt2.setString(2, "RLRRSENQ");
							pstmt2.setString(3, "");
							pstmt2.setString(4, p_user_name);
							pstmt2.setString(5, (String)login_at_ws_no);
							pstmt2.setString(6, null);
							pstmt2.setString(7, l_specimen_no); 							
							pstmt2.registerOutParameter( 8,  Types.VARCHAR ) ; 
							pstmt2.setString(9, orderCatalogCode);
							pstmt2.execute() ;
						}
				}
				connection.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				if(resultSet != null) resultSet.close();
				if(pStatment != null) pStatment.close();
				if(resultSet1 != null) resultSet1.close();
				if(pstmt1 != null) pstmt1.close();
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(pstmt2 != null) pstmt2.close();
				if(connection!=null)connection.close();
			}
				
				
		}
		return "Success";
	}
	public String onLinePrintingEvent(String locale,String hist_type,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt,String catalog_nature,String selTab,String fac_id,String abnormal,String eventCls,String eventGrp,String eventItem,String p_user_name,String reln_id,String facility) throws SQLException{

		Connection connection 		= null;
		PreparedStatement pstmt1 	= null;
	//	PreparedStatement pstmt_chldorderlst	= null;//46480
		CallableStatement pstmt2 	= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet1 		= null;
		ResultSet resultSet 		= null;
	//	ResultSet rschildor_lst 	= null;//46480
		String orderCatalogCode		= "";
		
		connection = ConnectionManager.getConnection() ;
		pstmt1 = connection.prepareStatement( "SELECT EXT_IMAGE_APPL_ID FROM CA_EXT_IMAGE_APPL WHERE EXT_IMAGE_APPL_ID='IBARL'") ;
		resultSet1 = pstmt1.executeQuery() ;
		String checkIbarl_ = "";
	//	String error_code = "";//46480
	//	String child_order_id 					= "";//46480
		PreparedStatement pStatment = null;
		ResultSet rs = null;
		
		if(resultSet1.next()){ checkIbarl_ = resultSet1.getString("EXT_IMAGE_APPL_ID");}
		pstmt = connection.prepareStatement( "SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE CONTR_MSR_PANEL_ID = ?") ;
		pstmt.setString(1, eventGrp);
		rs = pstmt.executeQuery() ;
		if(rs.next()){ orderCatalogCode = rs.getString("ORDER_CATALOG_CODE")==null?"":rs.getString("ORDER_CATALOG_CODE");}
		
		if("IBARL".equals(checkIbarl_)){
			pstmt2 = connection.prepareCall("{ call RL_RES_REPORT_FOR_CA.ins_report_details(?,?,?,?,?,?,?,?,?) }");//IN061961
			try
			{

				int i=1;
				StringBuffer sbQryCriteria	= new StringBuffer(); 

				//sbQryCriteria.append("Select distinct substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) accession_num,facility_id From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E') ");//common-icn-0180
				
				sbQryCriteria.append("Select distinct substr(REQUEST_NUM,instr(REQUEST_NUM,'#')+1,15) accession_num,facility_id From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?)='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E') ");//common-icn-0180
				
				if(!encounter_id.equals(""))
					sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
				
				sbQryCriteria.append(" and a.hist_rec_type=? ");
				
				if(!fac_id.equals(""))
					sbQryCriteria.append("and a.FACILITY_ID = ?");
				
				if("self_tab".equals(selTab))
					sbQryCriteria.append(" and a.PRACTITIONER_ID=? ");
					
				if("my_tab".equals(selTab))
					sbQryCriteria.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id) ");
				
				if(!"N".equals(abnormal))
					sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
				
				if(!eventCls.equals(""))
					sbQryCriteria.append(" and a.event_class = ? ");
				
				if(!eventGrp.equals(""))
					sbQryCriteria.append(" and a.event_group = ? ");
				
				if(!eventItem.equals(""))
					sbQryCriteria.append(" and a.event_code = ? ");	
				
				if("LBIN".equals(hist_type))
					sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group )");
				
				if(!"".equals(from_dt))
					sbQryCriteria.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");

				if(!"".equals(to_Dt))
					sbQryCriteria.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 ");

				 pStatment = connection.prepareStatement(sbQryCriteria.toString());
				 pStatment.setString(i++, locale);
				 pStatment.setString(i++, locale);
				 pStatment.setString(i++, locale);
				 pStatment.setString(i++, locale);
				 pStatment.setString(i++, patient_id);
				 pStatment.setString(i++, resp_id);//common-icn-0180
				 pStatment.setString(i++, reln_id);//common-icn-0180
				 pStatment.setString(i++, clinician_id);//common-icn-0180
				 pStatment.setString(i++, resp_id);//common-icn-0180
				 if(!encounter_id.equals(""))
					 pStatment.setString(i++, encounter_id);
				 pStatment.setString(i++, hist_type);
				 if(!fac_id.equals(""))
				 pStatment.setString(i++, fac_id);
				 
				 if("self_tab".equals(selTab))
					 pStatment.setString(i++, clinician_id);
				 
				 if("my_tab".equals(selTab)){
					 pStatment.setString(i++, clinician_id);
					 
				 }
				 
				if(!eventCls.equals(""))
					pStatment.setString(i++, eventCls);
						
				if(!eventGrp.equals(""))
					pStatment.setString(i++, eventGrp);
						
				if(!eventItem.equals(""))
					pStatment.setString(i++, eventItem);
					
				 if("LBIN".equals(hist_type))
					 pStatment.setString(i++, catalog_nature);
				 
				 if(!"".equals(from_dt))
					pStatment.setString(i++, from_dt);
				 if(!"".equals(to_Dt))
					 pStatment.setString(i++, to_Dt);
				 resultSet = pStatment.executeQuery(); 
				 if ( resultSet != null )
				 {
						while(resultSet.next())
						{
							String l_specimen_no = resultSet.getString("accession_num")==null?"":resultSet.getString("accession_num");
							String facility_id =resultSet.getString("facility_id")==null?"":resultSet.getString("facility_id");
							pstmt2.setString(1, facility_id);
							pstmt2.setString(2, "RLRRSENQ");
							pstmt2.setString(3, "");
							pstmt2.setString(4, p_user_name);
							pstmt2.setString(5, (String)login_at_ws_no);
							pstmt2.setString(6, null);
							pstmt2.setString(7, l_specimen_no); 							
							pstmt2.registerOutParameter( 8,  Types.VARCHAR ) ; 
							pstmt2.setString(9, null);
							pstmt2.execute() ;
						}
				}
				connection.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				if(resultSet != null) resultSet.close();
				if(pStatment != null) pStatment.close();
				if(connection!=null)connection.close();
			}
				
				
		}
		return "Success";
	}
	// IN070032 starts
	public ArrayList getPdfPrintingEvents(String patient_id)throws Exception,SQLException {
		Connection connection = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ArrayList array = new ArrayList();
		try {
			connection = ConnectionManager.getConnection();
			pstmt1 = connection
					.prepareStatement("SELECT USERENV('SESSIONID')l_session_id,to_char(SYSDATE,'DDMMYYHH24MISS') curr_date,SYS_CONTEXT('USERENV','IP_ADDRESS')machine_name FROM DUAL");

			rs = pstmt1.executeQuery();
			pstmt2 = connection
					.prepareStatement("SELECT distinct PERFORMING_FACILITY_ID FROM OR_ORDER WHERE patient_id = ?");
			pstmt2.setString(1, patient_id);
			rs1 = pstmt2.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					array.add(rs.getString("l_session_id") == null ? "" : rs
							.getString("l_session_id"));
					array.add((String) rs.getString("curr_date") == null ? ""
							: rs.getString("curr_date"));
					array.add((String) rs.getString("machine_name") == null ? ""
							: rs.getString("machine_name"));

				}
			}
			if (rs1 != null) {
				while (rs1.next()) {
					array.add(rs1.getString("PERFORMING_FACILITY_ID") == null ? ""
							: rs1.getString("PERFORMING_FACILITY_ID"));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(pstmt1);
			closeResultSet(rs1);
			closeStatement(pstmt2);
			closeResultSet(rs);
			if(connection!=null)connection.close();
		}

		return array;
	}

	public String viewInsert(String locale, String login_user,String facilityid, String login_at_ws_no, String accession_num,String req_date, String resp_id, String operating_facility_id,String report_id, String session_id, String p_module_id,String eventCode, String patient_id, String machine_name)throws Exception,SQLException {
		Connection connection1 = null;
		PreparedStatement pstatmt = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		PreparedStatement pstment = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		String section_code = "", urgent_indicator = "";
		String print_type = "";
	//	Hashtable htResMesg = new Hashtable();//46480
		//String error_value = "";//46480
		String catalog_code = "", test_code = "";
	//	boolean result = false;//46480
	//	boolean result1 = false;//46480
		connection1 = ConnectionManager.getConnection();
		pstmt3 = connection1
				.prepareStatement("SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE CONTR_MSR_PANEL_ID = ?");
		pstmt3.setString(1, eventCode);
		resultSet1 = pstmt3.executeQuery();

		if (resultSet1.next()) {
			catalog_code = resultSet1.getString("ORDER_CATALOG_CODE");
		}
		pstmt4 = connection1
				.prepareStatement("SELECT patient_id, specimen_no, section_code, episode_type, source_code, source_type, urgent_indicator FROM RL_REQUEST_HEADER WHERE specimen_no = ?");
		pstmt4.setString(1, accession_num);
		resultSet3 = pstmt4.executeQuery();
		if (resultSet3.next()) {
			section_code = resultSet3.getString("section_code");
			urgent_indicator = resultSet3.getString("urgent_indicator");
		}
		pstment = connection1
				.prepareStatement("SELECT NVL(GROUP_TEST_YN,'N') group_test,TEST_CODE FROM RL_TEST_CODE WHERE  ORDER_CATALOG_CODE=?");
		pstment.setString(1, catalog_code);
		resultSet = pstment.executeQuery();
		if (resultSet.next()) {
			test_code = resultSet.getString("TEST_CODE");
		}
		pstmt6 = connection1
				.prepareStatement("select SPECIMEN_WISE from ca_param");
		resultSet5 = pstmt6.executeQuery();
		if (resultSet5.next()) {
			print_type = resultSet5.getString("SPECIMEN_WISE");
		}
		try {
			if ("S".equals(print_type)) {
				pstatmt = connection1
						.prepareStatement("INSERT INTO SY_PROG_PARAM (operating_facility_Id, PGM_ID, SESSION_ID, PGM_DATE,PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6, PARAM7, PARAM8,PARAM9,PARAM10,PARAM18,PARAM25) VALUES(?, ?, ?, ?, ?,?, null, ?,?, 'Y', 'Z', 'P', 'REPRINT', 'Y', ?,'V')");
				pstatmt.setString(1, operating_facility_id);
				pstatmt.setString(2, report_id);
				pstatmt.setInt(3, Integer.parseInt(session_id));
				pstatmt.setString(4, req_date);
				pstatmt.setString(5, patient_id);
				pstatmt.setString(6, accession_num);
				pstatmt.setString(7, login_user);
				pstatmt.setString(8, section_code);
				pstatmt.setString(9, "");
			} else {
				pstatmt = connection1
						.prepareStatement("INSERT INTO SY_PROG_PARAM (operating_facility_Id, PGM_ID, SESSION_ID, PGM_DATE,PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6, PARAM7, PARAM8,PARAM9,PARAM10,PARAM18,PARAM25) VALUES(?, ?, ?, ?, ?,?, null, ?,?, 'Y', 'Z', 'P', 'REPRINT', 'Y', ?,'V')");
				pstatmt.setString(1, operating_facility_id);
				pstatmt.setString(2, report_id);
				pstatmt.setInt(3, Integer.parseInt(session_id));
				pstatmt.setString(4, req_date);
				pstatmt.setString(5, patient_id);
				pstatmt.setString(6, accession_num);
				pstatmt.setString(7, login_user);
				pstatmt.setString(8, section_code);
				pstatmt.setString(9, test_code);
			}
			pstatmt.executeUpdate();
			pstmt5 = connection1
					.prepareStatement("INSERT INTO SY_REPORT_GENERATE_REQUEST(operating_facility_id,USER_ID,MACHINE_NAME,WS_NO,PGM_ID,SESSION_ID,REQUEST_DATE,REGENERATE_REQUEST_DATE,PGM_TYPE,CMD_LINE_ARG,REQUEST_STATUS,URGENT_INDICATOR)VALUES(?, ?, ?, ?, ?, ?, sysdate, NULL, 'C',?,NULL,?)");
			pstmt5.setString(1, operating_facility_id);
			pstmt5.setString(2, login_user);
			pstmt5.setString(3, machine_name);
			pstmt5.setString(4, login_at_ws_no);
			pstmt5.setString(5, report_id);
			pstmt5.setInt(6, Integer.parseInt(session_id));
			pstmt5.setString(7, accession_num);
			pstmt5.setString(8, urgent_indicator);
			pstmt5.executeUpdate();
			connection1.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			closeStatement(pstment);
			closeStatement(pstatmt);
			closeStatement(pstmt3);
			closeStatement(pstmt4);
			closeStatement(pstmt5);
			closeStatement(pstmt6);
			closeResultSet(resultSet);
			closeResultSet(resultSet1);
			closeResultSet(resultSet2);
			closeResultSet(resultSet3);
			closeResultSet(resultSet4);
			closeResultSet(resultSet5);
			closeConnection(connection1);
			
		}
		return "Success";
	}
	public HashMap getPrintIconDetails(PageContext pageContext,Connection con,String locale,String login_user,String hist_type,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt,String catalog_nature,String selTab,String fac_id,String abnormal,String eventCls,String eventGrp,String eventItem,String reln_id,String patient_class,String facility) throws Exception {
	
		PreparedStatement pStatment = null; 
		ResultSet resultSet = null;
		int i=1;
		StringBuffer sbQryCriteria	= new StringBuffer();
		HashMap<String,Integer> printDetailsMap=new HashMap<String,Integer>();

		if(selTab.equals("S"))
			selTab="self_tab";
		if(selTab.equals("M"))
			selTab="my_tab";

		sbQryCriteria.append("Select distinct TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi')||'|'||NVL (a.event_group, '*ALL') event_print_details From cr_encounter_detail a WHERE a.patient_id = ? AND a.patient_class = NVL(?,patient_class)");//IN070032
			
		if(!"".equals(from_dt))
			sbQryCriteria.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI') ");

		if(!"".equals(to_Dt))
			sbQryCriteria.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287 ");
		
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
		
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group )");
		
		if("self_tab".equals(selTab))
			sbQryCriteria.append(" and a.PRACTITIONER_ID=? ");
		
		if("my_tab".equals(selTab))
			sbQryCriteria.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id) ");
		
		if("Y".equals(abnormal))
			sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		
		if(!eventCls.equals(""))
			sbQryCriteria.append(" and a.event_class = ? ");
		
		if(!eventGrp.equals(""))
			sbQryCriteria.append(" and a.event_group = ? ");
		
		if(!eventItem.equals(""))
			sbQryCriteria.append(" and a.event_code = ? ");	
		
		sbQryCriteria.append(" and a.hist_rec_type=? ");
		
		if(!fac_id.equals(""))
		sbQryCriteria.append(" and a.FACILITY_ID = ? ");
		
		//sbQryCriteria.append(" and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'"+resp_id+"','"+reln_id+"')='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and nvl(a.STATUS,'`') not in('S','E') ");//common-icn-0180
		
		sbQryCriteria.append(" and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?)='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and nvl(a.STATUS,'`') not in('S','E') ");//common-icn-0180
		
		
		try{
			 pStatment = con.prepareStatement(sbQryCriteria.toString());
			 pStatment.setString(i++, patient_id);
			 pStatment.setString(i++, patient_class);
			 if(!"".equals(from_dt))
				 pStatment.setString(i++, from_dt);
			 if(!"".equals(to_Dt))
			 pStatment.setString(i++, to_Dt);
			 if(!encounter_id.equals(""))
				 pStatment.setString(i++, encounter_id);
			 
			 if("LBIN".equals(hist_type))
				 pStatment.setString(i++, catalog_nature);
			 
			 if("self_tab".equals(selTab))
				 pStatment.setString(i++, clinician_id);
			 
			 if("my_tab".equals(selTab)){
				 pStatment.setString(i++, clinician_id);
			 }
			if(!eventCls.equals(""))
				pStatment.setString(i++, eventCls);
					
			if(!eventGrp.equals(""))
				pStatment.setString(i++, eventGrp);
					
			if(!eventItem.equals(""))
				pStatment.setString(i++, eventItem);
			
			pStatment.setString(i++, hist_type);
			if(!fac_id.equals("")) 
				pStatment.setString(i++, fac_id);

			
			 pStatment.setString(i++, resp_id);//common-icn-0180
			 pStatment.setString(i++, reln_id);//common-icn-0180
			 pStatment.setString(i++, clinician_id);//common-icn-0180
			 pStatment.setString(i++, resp_id);//common-icn-0180
			 resultSet = pStatment.executeQuery(); 
			 if ( resultSet != null )
			 {
					while(resultSet.next())
					{
						printDetailsMap.put((String)resultSet.getString("event_print_details"),1);
					}
					
				}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
		}

		return printDetailsMap;
	}
	public ArrayList viewCall(String facility_id,String ws_no,String reportServer,String userid,String report_option)	throws Exception,SQLException {
		Connection connection = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ArrayList array = new ArrayList();
		try {
			connection = ConnectionManager.getConnection();
			CallableStatement cs = connection.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
			cs.setString( 1,	"RL" ) ;
			cs.setString( 2,	"RLRRSENQ" ) ;
			cs.setString( 3,	"" ) ;
			cs.setString( 4,	"" ) ;
			cs.setString( 5,	facility_id ) ;
			cs.setString( 6,	ws_no ) ;
			cs.setString( 7,	report_option ) ;
			cs.registerOutParameter( 8,  Types.VARCHAR ) ;
			cs.registerOutParameter( 9,  Types.VARCHAR ) ;
			cs.registerOutParameter( 10, Types.VARCHAR ) ;
			cs.registerOutParameter( 11, Types.VARCHAR ) ;
			cs.registerOutParameter( 12, Types.VARCHAR ) ;
			cs.registerOutParameter( 13, Types.VARCHAR ) ;
			cs.registerOutParameter( 14, Types.VARCHAR ) ;
			cs.registerOutParameter( 15, Types.VARCHAR ) ;
			cs.registerOutParameter( 16, Types.VARCHAR ) ;
			cs.registerOutParameter( 17, Types.VARCHAR ) ;
			cs.execute() ;

			String report	= cs.getString( 8 ) ;
			String server	= cs.getString( 9 ) ;
			String copies	= cs.getString( 10 ) ;
			if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
			String queue_name	= cs.getString( 12 ) ;
			String message	= cs.getString( 15 ) ;
			if (message==null) message="";
			String app_server_ip = cs.getString( 16 ) ;
			String rep_server_key= cs.getString( 17 ) ;
			array.add(report);
			array.add(server);
			array.add(copies);
			array.add(queue_name);
			array.add(message);
			array.add(app_server_ip);
			array.add(rep_server_key);
					
			if (rep_server_key==null) rep_server_key="";
		 
			reportServer = "http://" + app_server_ip + reportServer ;
			array.add(reportServer);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(pstmt1);
			closeResultSet(rs1);
			closeStatement(pstmt2);
			closeResultSet(rs);
			if(connection!=null)connection.close();
		}
		return array;
	}// IN070032 ends	
	//IN071596 starts
	public ArrayList getSelectedClinicalNotesDetails(String locale,String patient_id,String facility_id,String clinician_id,String resp_id,String fromDate,String toDate,String login_user_id,String url,String selTab,String encounter_id,String date_Ordr,String eventCls,String eventGrp,String eventItem,String selHistType,String patient_class )	throws Exception,SQLException {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
	//	PreparedStatement pstmt1 = null;//46480
		ResultSet rs = null;
	//	ResultSet rs1 = null;//46480
		StringBuffer sqlQuery = new StringBuffer();		
		ArrayList searchData = new ArrayList();	
	//	String default_pat_name="";//46480
		String event_date_time 			=	"";
		String modified_date               = "";//24094
		String modified_date_YN              = "";//24094
		String event_group_desc			=	"";
		String event_desc				=	"";
		String contr_sys_event_code		=	"";
		String hist_data_type				=	"";	
	//	String deceased_yn				=	"";//46480
//		String deceased_date			=	"";//46480
		String accessionNum				=	"";
		String performed_by_id 			=	"";
		String reFacilityId 			= 	"";
		String reEncounterId 			= 	"";
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    
		int i=1;
		try{
			connection = ConnectionManager.getConnection();
			
			if(selTab.equals("S"))
				selTab="self_tab";
			if(selTab.equals("M"))
				selTab="my_tab";
				
			
			
			sqlQuery.append("SELECT  NVL (TO_CHAR (f.visit_adm_date_time, 'YYYYMMDDHH24MI'),'EXTERNAL') group2,cr_get_desc.cr_hist_rec_type (a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,cr_get_desc.cr_event_class (a.hist_rec_type,a.event_class,?,'1') event_class_desc,a.event_group,cr_get_desc.cr_clin_event_group(a.hist_rec_type,a.event_group,a.event_group_type,?,'1') event_group_desc,a.event_code,cr_get_desc.cr_clin_event_mast (a.hist_rec_type,RTRIM (a.event_code),a.event_code_type,?,'1') event_desc, ");
			sqlQuery.append(" a.accession_num, a.contr_sys_id, a.contr_sys_event_code,TO_CHAR (event_date, 'dd/mm/yyyy hh24:mi') event_date_time,TO_CHAR (event_date, 'YYYYMMDDHH24MISS') sort_event_date,a.hist_data_type, a.hist_rec_type, a.performed_by_id,am_get_desc.am_practitioner (a.performed_by_id,?,'1') clinician_short_name,am_get_desc.am_practitioner(DECODE (a.authorized_by_id,'', a.performed_by_id,a.authorized_by_id),?,'1') resulted_practitioner, ");
			sqlQuery.append(" ca_get_visit_hdr_new (a.facility_id,a.patient_class,a.encounter_id,a.patient_id,a.performed_by_id,?) encline,a.ext_image_appl_id, a.ext_image_obj_id, a.ext_image_upld_id,a.status,a.encounter_id, ");
			//sqlQuery.append(" a.normalcy_str, a.facility_id, TO_CHAR (result_num) result_num1,result_num_dec, a.event_code_type, a.html_image_upld_id,ca_get_restricting_ceh (a.hist_rec_type,a.event_class) restricting_print");
			sqlQuery.append(" a.normalcy_str, a.facility_id, TO_CHAR (result_num) result_num1,result_num_dec, a.event_code_type, a.html_image_upld_id,ca_get_restricting_ceh (a.hist_rec_type,a.event_class) restricting_print,TO_CHAR (a.modified_date, 'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn");//24094
			sqlQuery.append(" FROM cr_encounter_detail a, pr_encounter f WHERE a.patient_id = ? AND a.patient_class = NVL(?,a.patient_class)  AND f.facility_id(+) = a.facility_id AND f.encounter_id(+) = a.encounter_id ");
			if(!"".equals(facility_id))
				sqlQuery.append(" AND a.facility_id = ? ");
			sqlQuery.append(" AND NVL (ca_view_confidnt_event (a.facility_id,a.encounter_id,a.patient_id,a.accession_num,a.contr_sys_id,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.authorized_by_id,DECODE (a.hist_rec_type,'CLNT', NULL,a.event_group)),'N') = 'Y' ");
			sqlQuery.append(" AND NVL (a.status, '`') NOT IN ('S', 'E') AND a.hist_rec_type = ? ");//IN072759
			if(!encounter_id.equals(""))
				sqlQuery.append(" and a.ENCOUNTER_ID = ? ");	
				//IN072759 STARTS
			if("self_tab".equals(selTab)){
			if(!"RDIN".equals(selHistType) && !"SUNT".equals(selHistType))//IN072760
			{
			
				sqlQuery.append(" and a.AUTHORIZED_BY_ID=? ");
			}
			else if("SUNT".equals(selHistType))
			{
				sqlQuery.append(" and a.PERFORMED_BY_ID=? ");
			}
			else{
				
					sqlQuery.append(" and a.PRACTITIONER_ID=? ");
				}//IN072759 ENDS
			}
			if("my_tab".equals(selTab))
			{
				if(!"RDIN".equals(selHistType) && !"SUNT".equals(selHistType))//IN072760
				{
				sqlQuery.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.AUTHORIZED_BY_ID,?,a.facility_id) ");
				}
				else if("SUNT".equals(selHistType))
				{
					sqlQuery.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PERFORMED_BY_ID,?,a.facility_id) ");
				}
				else
				{
					sqlQuery.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id) ");
				}
			}
			if(!"".equals(fromDate))
				sqlQuery.append(" AND  A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi')  ");
			if(!"".equals(toDate))
				sqlQuery.append(" AND a.event_date <=TO_DATE (NVL (?, '01/01/9999'), 'dd/mm/yyyy hh24:mi')+ .00068287 ");
			if(!eventCls.equals(""))
				sqlQuery.append(" and a.event_class = ? ");
			
			if(!eventGrp.equals(""))
				sqlQuery.append(" and a.event_group = ? ");
			
			if(!eventItem.equals(""))
				sqlQuery.append(" and a.event_code = ? ");	
			
			if(date_Ordr.equals("D"))
				sqlQuery.append(" order by sort_event_date desc");
			else
				sqlQuery.append(" order by sort_event_date asc");	
				
			//System.out.println("sqlQuery----------->"+sqlQuery.toString());
			pstmt= connection.prepareStatement(sqlQuery.toString());
			
			pstmt.setString(i++,locale);
			pstmt.setString(i++,locale);
			pstmt.setString(i++,locale);
			pstmt.setString(i++,locale);
			pstmt.setString(i++,locale);
			pstmt.setString(i++,locale);
			pstmt.setString(i++,locale);
			
			pstmt.setString(i++,patient_id);
			pstmt.setString(i++,patient_class);
			if(!"".equals(facility_id))
				pstmt.setString(i++,facility_id);
			pstmt.setString(i++,clinician_id);
			pstmt.setString(i++,resp_id);
			pstmt.setString(i++,selHistType);//IN072759
			if(!encounter_id.equals(""))
				pstmt.setString(i++,encounter_id);
			if("self_tab".equals(selTab)){
				pstmt.setString(i++,clinician_id);
			}
			if("my_tab".equals(selTab)){
				pstmt.setString(i++,clinician_id);
			}
			if(!"".equals(fromDate))
				pstmt.setString(i++,fromDate);
			if(!"".equals(toDate))
				pstmt.setString(i++,toDate);
			if(!eventCls.equals(""))
				pstmt.setString(i++,eventCls);
			
			if(!eventGrp.equals(""))
				pstmt.setString(i++,eventGrp);
			if(!eventItem.equals(""))
				pstmt.setString(i++,eventItem);
			
			//System.out.println("locale----------->"+locale);
			//System.out.println("patient_id----------->"+patient_id);
			//System.out.println("clinician_id----------->"+clinician_id);
			//System.out.println("resp_id----------->"+resp_id);
			//System.out.println("fromDate----------->"+fromDate);
			//System.out.println("toDate----------->"+toDate);
			
			rs = pstmt.executeQuery(); 
			if( rs != null ){
			
				HashMap<String,String>  resultMap=null;
				
				  
				while(rs.next())
				{
					  
					resultMap= new HashMap<String,String>();					
					event_date_time  		=	rs.getString("event_date_time")==null?"":rs.getString("event_date_time");
					modified_date  		=	rs.getString("modified_date")==null?"":rs.getString("modified_date");//24094
					modified_date_YN  		=	rs.getString("modifiedyn")==null?"":rs.getString("modifiedyn");//24094
					event_group_desc	 	=	rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");
					event_desc				=	rs.getString("event_desc")==null?"":rs.getString("event_desc");
					contr_sys_event_code	=	rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code");
					hist_data_type			=	rs.getString("hist_data_type")==null?"":rs.getString("hist_data_type");					
					accessionNum		=	rs.getString("accession_num")==null?"":rs.getString("accession_num");
					performed_by_id 	=	rs.getString("performed_by_id")==null?"":rs.getString("performed_by_id");
					reFacilityId 		= 	rs.getString("facility_id")==null?"":rs.getString("facility_id");
					reEncounterId 		= 	rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
					
					resultMap.put("Event_Date_Time",event_date_time);
					resultMap.put("Modified_Date",modified_date);//24094
					resultMap.put("Modified_Date_YN",modified_date_YN);//24094
					resultMap.put("Note_Group_Desc",event_group_desc);
					resultMap.put("Note_Type_Desc",event_desc);
					resultMap.put("accessionNum",accessionNum);
					resultMap.put("hist_data_type",hist_data_type);
					resultMap.put("reEncounterId",reEncounterId);
					resultMap.put("contr_sys_event_code",contr_sys_event_code);
					resultMap.put("reFacilityId",reFacilityId);
					searchData.add(resultMap);
				}					
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(connection!=null)connection.close();
		}
		
		return searchData;	
	}
	public void getNoteContent(String facility_id,String event_date_time,String contr_sys_event_code,String accessionNum,String hist_data_type,String locale,String reEncounterId,String patient_id,String url,String clinician_id,String login_user_id,String indicator_type,String selHistType) 	throws Exception,SQLException 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String cal_eventdate			=	"";
		StringBuffer noteContedBuffer = new StringBuffer();	
		StringBuffer noteConted = new StringBuffer();
		java.io.BufferedReader noteContentReader;
		Clob noteContent = null;
		String doc_ref_id 				= 	"";
		String last_amended_by			=	"";
		String authorized_by			=	"";
		String authorized_by_id			=	"";
		String contr_mod_acc_num 		=	"";
		String authorized_sign			=   "N";
		String patient_class			=	"";
		String facility_name			=	"";
		String visit_adm_date			=	"";
		String med_service				=	"";
		String discharge_date			=	"";
		String discharge_date_only		=	"";
		String attending_practitioner	=	"";
		String attending_practitioner_list	=	"";
		String admitting_practitioner	=	"";
		String bed_number				=	"";
		String performing_phy_name		=	"";
		String age						=	"";
		String gender					=	"";
		String location_code			=	"";
		String patient_name				=	"";
		String speciality_name			=	"";
		String printDateTime			=	"";
		String site_name				=	"";
		String sex						=	"";
		String default_pat_name			=	"";
		HashMap<String,String> paramMap = null;
		String contr_mod_accession_num 	= 	"";
		String pract_sign				=	"";
		String patientId 				=	"";
		String histRecType				=	"";
		String contrSysId				=	"";
		String contrSysEventCode		=	"";
		String extImageObjId			=	"";
		String extImageApplId			=	"";
		String extImageUploadId			=	"";
		String htmlImageUploadId		=	"";
		String deceased_date="",deceased_yn="";
		String color_cell_indicator="",normalcy_ind="",normalcy_str="";
		String data = "",resultNum="",normalrange1="",normalrange2="";//normalrange=""//46480
	//	String Normal_Range = "";//46480
		String result_uom="",criticalrange1="",criticalrange2="";//	Critical_Range = "",criticalrange="",//46480
		HashMap<String, String> resultMap= new HashMap<String,String>();	
		try{
			eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
			webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
		
			connection=ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("select patient_name patient_name,deceased_yn,to_Char(deceased_date,'dd/mm/yyyy hh24:mi') deceased_date from mp_patient where patient_id = ?");
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery(); 
			while(rs.next()){
				default_pat_name	= rs.getString("patient_name") == null ? "" : rs.getString("patient_name");			
				deceased_yn			= rs.getString("deceased_yn") == null ? "" : rs.getString("deceased_yn");
				deceased_date		= rs.getString("deceased_date") == null ? "" : rs.getString("deceased_date");
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			//6484 Start.
			//pstmt=connection.prepareStatement("SELECT a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.RESULT_NUM_PREFIX,a.RESULT_NUM_UOM,a.RESULT_NUM,a.NORMAL_LOW,a.NORMAL_HIGH,a.CRITICAL_LOW,a.CRITICAL_HIGH,a.contr_sys_event_code contr_sys_event_code,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.ext_image_upld_id ext_image_upld_id,a.html_image_upld_id html_image_upld_id,b.hist_data hist_data ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,a.normalcy_ind,a.normalcy_str FROM cr_encounter_detail a,cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num and b.accession_num=? AND b.contr_sys_event_code = a.contr_sys_event_code");
			  //25408 Start.
			 // pstmt=connection.prepareStatement("SELECT a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.RESULT_NUM_PREFIX,a.RESULT_NUM_UOM,a.RESULT_NUM,a.NORMAL_LOW,a.NORMAL_HIGH,a.CRITICAL_LOW,a.CRITICAL_HIGH,a.contr_sys_event_code contr_sys_event_code,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.ext_image_upld_id ext_image_upld_id,a.html_image_upld_id html_image_upld_id,b.hist_data hist_data ,b.compress_hist_data_yn,b.comments,b.compress_hist_data,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,a.normalcy_ind,a.normalcy_str FROM cr_encounter_detail a,cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num and b.accession_num=? AND b.contr_sys_event_code = a.contr_sys_event_code");
			  pstmt=connection.prepareStatement("SELECT a.hist_rec_type hist_rec_type,a.contr_sys_id contr_sys_id,a.RESULT_NUM_PREFIX,a.RESULT_NUM_UOM,a.RESULT_NUM,a.NORMAL_LOW,a.NORMAL_HIGH,a.CRITICAL_LOW,a.CRITICAL_HIGH,a.contr_sys_event_code contr_sys_event_code,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.ext_image_upld_id ext_image_upld_id,a.html_image_upld_id html_image_upld_id,b.hist_data hist_data ,b.compress_hist_data_yn,b.comments,b.compress_hist_data,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,a.normalcy_ind,a.normalcy_str FROM cr_encounter_detail a,cr_encounter_detail_txt b WHERE a.accession_num=? and b.hist_rec_type(+) = a.hist_rec_type AND b.contr_sys_id(+) = a.contr_sys_id AND b.accession_num(+) = a.accession_num AND b.contr_sys_event_code(+) = a.contr_sys_event_code");
			// 25408 End.
			pstmt.setString(1, accessionNum);
			rs=pstmt.executeQuery();
			if(rs.next()){
				noteContent			= 	rs.getClob("hist_data");
				histRecType			=	rs.getString("hist_rec_type")==null?"":rs.getString("hist_rec_type");
				contrSysId			=	rs.getString("contr_sys_id")==null?"":rs.getString("contr_sys_id");
				contrSysEventCode	=	rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code");
				extImageObjId		=	rs.getString("ext_image_obj_id")==null?"":rs.getString("ext_image_obj_id");
				extImageApplId		=	rs.getString("ext_image_appl_id")==null?"":rs.getString("ext_image_appl_id");
				extImageUploadId	=	rs.getString("ext_image_upld_id")==null?"":rs.getString("ext_image_upld_id");
				htmlImageUploadId	=	rs.getString("html_image_upld_id")==null?"":rs.getString("html_image_upld_id");
				if(histRecType.equals("RDIN")){
					if(indicator_type.equals("I"))
				color_cell_indicator = rs.getString("SYMBOL_LEGEND_IND") == null ? "" : rs.getString("SYMBOL_LEGEND_IND");
					else
						color_cell_indicator = rs.getString("COLOR_CELL_IND") == null ? "" : rs.getString("COLOR_CELL_IND");
					
				normalcy_ind = rs.getString("normalcy_ind") == null ? "" : rs.getString("normalcy_ind");
				normalcy_str = rs.getString("normalcy_str") == null ? "" : rs.getString("normalcy_str");
				BigDecimal rn1 =rs.getBigDecimal("RESULT_NUM");
				if(rn1!=null)
					resultNum=rn1.toString();
				else
					resultNum="";
				BigDecimal nl =rs.getBigDecimal("NORMAL_LOW");
				if(nl!=null)
					normalrange1=nl.toString();
				else
					normalrange1="";
				BigDecimal nh =rs.getBigDecimal("NORMAL_HIGH");
				if(nh!=null)
					normalrange2=nh.toString();
				else
					normalrange2="";
				
				criticalrange1 = rs.getString("CRITICAL_LOW");
				if (criticalrange1 == null) criticalrange1 = "";

				criticalrange2 = rs.getString("CRITICAL_HIGH");
				if (criticalrange2 == null) criticalrange2 = "";
	
					String numFormat = "&nbsp;&nbsp;&nbsp;&nbsp;";
					if(rs.getString("RESULT_NUM_PREFIX") != null && !(rs.getString("RESULT_NUM_PREFIX")).equals(""))
					{
						numFormat= numFormat +  rs.getString("RESULT_NUM_PREFIX");
					}
					numFormat= numFormat +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ resultNum +"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));

					result_uom = rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
					
				
				}
			
			//6484 Start.
			if("Y".equals(rs.getString("compress_hist_data_yn")==null?"N":(String)rs.getString("compress_hist_data_yn"))){				
				java.sql.Blob note_blob =  (java.sql.Blob)rs.getBlob("compress_hist_data");
				if(note_blob!=null && note_blob.length()>0){
					InputStream ins1 = note_blob.getBinaryStream();
					ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
					int i;
					while((i = ins1.read()) != -1) 
						bytearrayoutputstream.write(i);
					
					byte[] compressed	=bytearrayoutputstream.toByteArray();
					if(compressed.length > 0){
						if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
							GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
							BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

								String line;
								while ((line = bufferedReader.readLine()) != null) {							
									noteContedBuffer.append(line+"\n");
								}
							}					
						}
					}
					
				}else{ //6484 End.
					if(noteContent!=null){
						noteContentReader = new java.io.BufferedReader(noteContent.getCharacterStream());
						String line = null;	
						while((line=noteContentReader.readLine()) != null) noteContedBuffer.append(line+"\n");
					}
				} //6484.
				noteContedBuffer.append((rs.getString("comments")==null?"":(String)rs.getString("comments"))); //6484.
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
			cal_eventdate 		= 	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);
		
			String footer_code 			= 	null;
			String report_header_code 	= 	null;	
			String sectionContentHeader = 	"";
			String sectionContentFooter	=	""; 	
			try
			{
				String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
				pstmt1	= connection.prepareStatement(head_foot_qry);
				pstmt1.setString(1,contr_sys_event_code);
				rs1 = pstmt1.executeQuery();
				
				while(rs1.next()){
					footer_code = rs1.getString("FOOTER_CODE")==null?"":rs1.getString("FOOTER_CODE");
					report_header_code = rs1.getString("REPORT_HEADER_CODE")==null?"":rs1.getString("REPORT_HEADER_CODE");
				}

			}catch(Exception ee){
				ee.printStackTrace();
			}finally{
				if(rs1 != null) rs1.close();
				if(pstmt1 != null) pstmt1.close();
			}
		
			if(footer_code!=null || report_header_code!=null){
				pstmt1	=	connection.prepareStatement("select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_NAME,a.AUTHORIZED_BY_ID AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name,CONTR_MOD_ACCESSION_NUM from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? ");
				pstmt1.setString	(	1,	locale	);
				pstmt1.setString	(	2,	locale	);
				pstmt1.setString	(	3,	locale	);
				pstmt1.setString	(	4,	locale	);
				pstmt1.setString	(	5,	accessionNum);
				pstmt1.setString	(	6,	patient_id	);
				rs1 = pstmt1.executeQuery();
				while(rs1.next()){
					authorized_by		=	rs1.getString("AUTHORIZED_BY_NAME")==null?"":rs1.getString("AUTHORIZED_BY_NAME") ;
					authorized_by_id	=	rs1.getString("AUTHORIZED_BY_ID")==null?"":rs1.getString("AUTHORIZED_BY_ID") ;
					last_amended_by		=	rs1.getString("LAST_AMENDED_BY_ID")==null?"":rs1.getString("LAST_AMENDED_BY_ID");
					doc_ref_id			=	 rs1.getString("DOC_REF_ID")==null?"":rs1.getString("DOC_REF_ID") ;
					contr_mod_acc_num	=	 rs1.getString("CONTR_MOD_ACCESSION_NUM")==null?"":rs1.getString("CONTR_MOD_ACCESSION_NUM") ;
				}
				if(rs1 != null) rs1.close();
				if(pstmt1 != null) pstmt1.close();
			
				if(!"".equals(authorized_by_id)){
					
					try{
						pstmt1	= connection.prepareStatement("SELECT PRACTITIONER_SIGN FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?");
						pstmt1.setString(1,authorized_by_id);
						rs1 = pstmt1.executeQuery();
						while(rs1 !=null && rs1.next()){						
							java.sql.Blob img_blob  =  (java.sql.Blob)rs1.getBlob("PRACTITIONER_SIGN");
							if(img_blob!=null){
								byte[] bytes = img_blob.getBytes(1, (int)img_blob.length()); 						
								authorized_sign = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes), "UTF-8");
							}
						}
					}catch(Exception se){
						se.printStackTrace();
					}finally
					{
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
					}
				}
			
			
				String query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list (a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number,b.patient_id patientid FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";//IN066807
				pstmt1	=	connection.prepareStatement(query_privilege_type);
				pstmt1.setString	(	1,	locale	);
				pstmt1.setString	(	2,	locale	);
				pstmt1.setString	(	3,	locale	);
				pstmt1.setString	(	4,	locale	);
				pstmt1.setString	(	5,	clinician_id	);
				pstmt1.setString	(	6,	locale	);
				pstmt1.setString	(	7,	locale	);			
				pstmt1.setString	(	8,	locale	);			
				pstmt1.setString	(	9,	locale	);			
				pstmt1.setString	(	10,	locale	);	
				pstmt1.setString	(	11,	facility_id);
				pstmt1.setString	(	12,	reEncounterId);
				
				rs1		=	pstmt1.executeQuery();
	
				if(rs1.next())
				{
					patient_class			=	rs1.getString("patient_class") == null ? "" : rs1.getString("patient_class");
					facility_name			=	rs1.getString("facility_name") == null ? "" : rs1.getString("facility_name");
					visit_adm_date			=	rs1.getString("visit_adm_date")==null?"":rs1.getString("visit_adm_date");
					med_service				=	rs1.getString("service_name")==null?"":rs1.getString("service_name");
					discharge_date			=	rs1.getString("DISCHARGE_DATE_TIME")==null?"":rs1.getString("DISCHARGE_DATE_TIME");
					discharge_date_only		=	rs1.getString("DISCHARGE_DATE_TIME_1")==null?"":rs1.getString("DISCHARGE_DATE_TIME_1");//IN067016
					attending_practitioner	=	rs1.getString("attending_practitioner")==null?"":rs1.getString("attending_practitioner");
					attending_practitioner_list	=	rs1.getString("attending_pract_list")==null?"":rs1.getString("attending_pract_list");//IN066807
					admitting_practitioner	=	rs1.getString("admitting_practitioner")==null?"":rs1.getString("admitting_practitioner");
					bed_number				=	rs1.getString("bed_number")==null?"":rs1.getString("bed_number");	  //--[IN:029839]--
					performing_phy_name		=	rs1.getString("performed_by_name")==null?"":rs1.getString("performed_by_name");
					age						=	rs1.getString("AGE")==null?"":rs1.getString("AGE");
					gender					=	rs1.getString("gender")==null?"":rs1.getString("gender");
					location_code			=	rs1.getString("location_code")==null?"":rs1.getString("location_code");
					patient_name			=	rs1.getString("patient_name")==null?"":rs1.getString("patient_name");
					speciality_name			=	rs1.getString("specialty_name")==null?"":rs1.getString("specialty_name");
					printDateTime			=	rs1.getString("print_date_time")==null?"":rs1.getString("print_date_time");
					site_name				=	rs1.getString("site_name")==null?"":rs1.getString("site_name");
					patientId				=	rs1.getString("patientid")==null?"":rs1.getString("patientid");
				}
				
				if(rs1 != null) rs1.close();
				if(pstmt1 != null) pstmt1.close();
				
				if("0".equals(reEncounterId)){
					try{
						query_privilege_type	=	"SELECT  get_age (b.date_of_birth) age, DECODE (?,'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name)) patient_name, sex gender FROM mp_patient b WHERE  PATIENT_ID=? "; 
						
				
						pstmt1	=	connection.prepareStatement(query_privilege_type);						
						pstmt1.setString	(	1,	locale	);
						pstmt1.setString	(	2,	patient_id	);
						rs1		=	pstmt1.executeQuery();
				
						if(rs1.next())
						{							
							age				=	rs1.getString("AGE")==null?"":rs1.getString("AGE");
							gender					=	rs1.getString("gender")==null?"":rs1.getString("gender");							
							patient_name			=	rs1.getString("patient_name")==null?"":rs1.getString("patient_name");
						}

						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						if(rs1!=null)	rs1.close();
						if(pstmt1!=null)	pstmt1.close();
					}
				}
				
							
				if(gender.equals("M"))
						sex =MessageManager.getLabel(locale,"Common.male.label","Common");
				else if (gender.equals("F"))
						sex =MessageManager.getLabel(locale,"Common.female.label","Common");
				else 
						sex =MessageManager.getLabel(locale,"Common.unknown.label","Common");

				if(discharge_date==null)
				{
					discharge_date="";
				}
				
				if(discharge_date_only==null){
					discharge_date_only="";
				}
				
				if(patient_class.equals("OP"))
					patient_class =		MessageManager.getLabel(locale,"Common.Outpatient.label","Common");
				else if(patient_class.equals("IP"))
					patient_class =		MessageManager.getLabel(locale,"Common.inpatient.label","Common");
				else if(patient_class.equals("EM"))
					patient_class =		MessageManager.getLabel(locale,"Common.emergency.label","Common");
				else if(patient_class.equals("DC"))
					patient_class =		MessageManager.getLabel(locale,"Common.daycare.label","Common");	
					
				boolean sitespecific=false;
				try{
					eCommon.Common.CommonBean bean = new eCommon.Common.CommonBean();
					sitespecific=bean.isSiteSpecific(connection, "CA", "BURMESE_LANGUAGE_FONT");
				}catch(Exception e){
					e.printStackTrace();
				}
				
				String displayview="";
				if(sitespecific)
				{	
					
					displayview=url+"html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
				}	
				else
				{	
					displayview=url+"html/RecClinicalNotesTemplateDispayView.xsl";
				}
						
				if(report_header_code!=null){
					try{
						String  reportHeaderTemplateQuery = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
						pstmt1	= connection.prepareStatement(reportHeaderTemplateQuery);
						pstmt1.setString(1,report_header_code);
						rs1 = pstmt1.executeQuery();
						if(rs1.next()){
							java.sql.Clob headerTemplateFormat			=	(java.sql.Clob) rs1.getObject("TEMPLATE_FORMAT");
							
							if(headerTemplateFormat!=null)
							{
								Hashtable<String,String> htParameter=new Hashtable<String,String>();
								htParameter.put("V$ATT_PRACT", attending_practitioner);
								htParameter.put("V$ATT_PRACT_LT", attending_practitioner_list);
								htParameter.put("V$ADM_PRACT", admitting_practitioner);
								htParameter.put("V$BED_NUM", bed_number);	
								htParameter.put("V$PT_SPLTY", speciality_name);
							
								if(patient_name.trim().equals(""))
									htParameter.put("V$PT_NAME", default_pat_name);  
								else
									htParameter.put("V$PT_NAME", patient_name);
							
								htParameter.put("V$PT_ID", patient_id);  
								htParameter.put("V$SEX", sex);   
								htParameter.put("V$AGE", age);
							
								if(reEncounterId.equals("0"))
									htParameter.put("V$ENC_ID", "");
								else
									htParameter.put("V$ENC_ID", reEncounterId);
							
								htParameter.put("V$ADM_DT", visit_adm_date); 
								htParameter.put("V$DIS_DT", discharge_date); 
								htParameter.put("V$DIS_DATE", discharge_date_only); 
								htParameter.put("V$MED_SERV", med_service);
								htParameter.put("V$DOC_REF_H", doc_ref_id);  
								htParameter.put("V$PT_LOCN", location_code); 
								htParameter.put("V$PT_CLASS", patient_class);
								String headerTemplateContent 			= headerTemplateFormat.getSubString(1, (int) headerTemplateFormat.length());
								StringBuffer headerTemplateContentUpdatedXML 	= new StringBuffer();
								
								if(!"".equals(headerTemplateContent)){
								
									StringBuffer headerTemplateBufferContent = new StringBuffer(headerTemplateContent);
									if (! locale.equals("en") ){
										if(!headerTemplateBufferContent.toString().equals(""))
										{
											paramMap = new HashMap<String,String>();
											paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
											paramMap.put("LOCALE",locale);						
											paramMap.put("RANGE_PASER_YN","N");
											eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(connection,paramMap,headerTemplateBufferContent);
											headerTemplateBufferContent = tempLangParse.getLangReplacedXML();
											tempLangParse = null;
										}

									}
									
									if(!headerTemplateBufferContent.toString().equals(""))
									{												
										
										eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
										Hashtable<String,String> tempParameter=new Hashtable<String,String>();	
										HashMap<String,String> paramHash=new HashMap<String,String>();
										paramHash.put("#p_patient_id#",patient_id);
										paramHash.put("#p_encounter_id#",reEncounterId);
										paramHash.put("#p_accNum#",accessionNum);
										paramHash.put("#p_locale#",locale);
										paramHash.put("#p_eventDate#",cal_eventdate); 
										paramHash.put("#p_facility_id#",facility_id);
										paramHash.put("#p_pract_id#",clinician_id);
										if(contr_mod_accession_num.equals(""))					
											paramHash.put("#p_contr_mod_accession_num#",contr_mod_acc_num);
										else
											paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num);
										tempParameter = dynamicCompDetails.getDynamicCompDetails(headerTemplateBufferContent,paramHash);
										if(tempParameter.size()>0){					
										htParameter.putAll(tempParameter);
										}
										headerTemplateContentUpdatedXML = parser.updateXMLContentValues(headerTemplateBufferContent,htParameter,locale);
									}
									if(!(headerTemplateContentUpdatedXML.toString().equals(""))){								
										sectionContentHeader=converter.buildHTMLFromXML(headerTemplateContentUpdatedXML.toString(),displayview);
										
									}										
								}
							}
						}
					}catch(Exception eee){
						eee.printStackTrace();
					}finally{
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
						
					}
				}
						
				if(footer_code!=null){
					try{
						String  reportFooterTemplateQuery = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
						pstmt1	= connection.prepareStatement(reportFooterTemplateQuery);
						pstmt1.setString(1,footer_code);
						rs1 = pstmt1.executeQuery();
						if(rs1.next()){
							java.sql.Clob footerTemplateFormat			=	(java.sql.Clob) rs1.getObject("TEMPLATE_FORMAT");										
							if(footerTemplateFormat!=null)
							{
								Hashtable<String,String> htParameter=new Hashtable<String,String>();
								if(!printDateTime.equals("")){
									printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
								}
								htParameter.put("V$CUR_USR", login_user_id); 
								htParameter.put("V$AT_PRACT", authorized_by);
								htParameter.put("V$AT_PRACT_SIGN", authorized_sign); 
								htParameter.put("V$LT_MODI_USR", last_amended_by);
								htParameter.put("V$PRN_DTTIME", printDateTime);
								htParameter.put("V$DOC_REF_F", doc_ref_id);
								htParameter.put("V$LT_PT_P_C_D", pract_sign);
								String footerTemplateContent 			= footerTemplateFormat.getSubString(1, (int) footerTemplateFormat.length());
								StringBuffer footerTemplateContentUpdatedXML 	= new StringBuffer();										
								if(!"".equals(footerTemplateContent)){
								
									StringBuffer footerTemplateBufferContent = new StringBuffer(footerTemplateContent);
									
									if (! locale.equals("en") ){
										if(!footerTemplateBufferContent.toString().equals(""))
										{
											paramMap = new HashMap<String,String>();
											paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
											paramMap.put("LOCALE",locale);						
											paramMap.put("RANGE_PASER_YN","N");
											eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(connection,paramMap,footerTemplateBufferContent);
											footerTemplateBufferContent = tempLangParse.getLangReplacedXML();
											tempLangParse = null;
										}

									}
									if(!footerTemplateBufferContent.toString().equals(""))
									{
										eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
										Hashtable<String,String> tempParameter=new Hashtable<String,String>();
										HashMap<String,String> paramHash=new HashMap<String,String>();
										paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
										paramHash.put("#p_accNum#",accessionNum);
										paramHash.put("#p_locale#",locale);
										paramHash.put("#p_pract_id#",clinician_id);
										tempParameter = dynamicCompDetails.getDynamicCompDetails(footerTemplateBufferContent,paramHash);
										if(tempParameter.size()>0){					
										htParameter.putAll(tempParameter);
										}												
										footerTemplateContentUpdatedXML = parser.updateXMLContentValues(footerTemplateBufferContent,htParameter,locale);
									}
									
									if(!(footerTemplateContentUpdatedXML.toString().equals(""))){								
										sectionContentFooter=converter.buildHTMLFromXML(footerTemplateContentUpdatedXML.toString(),displayview);
										
									}										
								}
							}
						}
					}catch(Exception eee){								
						eee.printStackTrace();
					}finally{
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();								
					}
				}	
						
			}
		if("RDIN".equals(histRecType)){
			if(indicator_type.equals("I") && !indicator_type.equals(""))
			{
				if(!color_cell_indicator.equals("NONE"))
					data = "<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
				else if(normalcy_ind.equals("."))
				{
					data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
				}
				else if(!normalrange1.equals("") && !normalrange2.equals(""))					
				{
					if(Float.parseFloat(resultNum)>0)
					{
						if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2)))
						{
							data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}
				else if(!normalrange1.equals("") && normalrange2.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310		
				{
					if(Float.parseFloat(resultNum)>0)
					{
						if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) 
						{
							data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}
				else if(normalrange1.equals("") && !normalrange2.equals(""))					
				{
					if(Float.parseFloat(resultNum)>0)
					{
						if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2))
						{
							data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}//END
			}
			else if(indicator_type.equals("C") && !indicator_type.equals(""))
			{
				if(!color_cell_indicator.equals("NONE"))
					data = "<font style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
				else if(normalcy_ind.equals("."))
				{
					data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
				}
				else if(!normalrange1.equals("") && !normalrange2.equals(""))
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2)))
						{
							data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}
				else if(!normalrange1.equals("") && normalrange2.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1))
						{
							data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}
				else if(normalrange1.equals("") && !normalrange2.equals(""))
				{
					if(Float.parseFloat(resultNum)>0)
					{
						if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2))
						{
							data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}//END
			}
			else
				data = "<font size=1>"+data+"</font>";
			
			noteConted.append(data);
		}
			if( hist_data_type.equals("HTM") || hist_data_type.equals("HTML") ){
				if(!"".equals(sectionContentHeader));
				noteConted.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+sectionContentHeader+"</td></tr></table><BR>");
				
				String displaydataTemp = ((String)(noteContedBuffer.toString()).replaceAll("<DIV align=left> <ADDRESS><FONT size=3></FONT>&nbsp;</ADDRESS></DIV>","").replaceAll("line-height: 100%"," ")).trim();
				noteConted.append("<PRE style='word-wrap:break-word;'>");
				noteConted.append(displaydataTemp);
				
				if(htmlImageUploadId.equals("") && histRecType.equals("CLNT"))
					noteConted.append("<br><a style='cursor:hand;color:blue' onClick=\"showNotesAuditFlow('"+accessionNum+"')\"><u>Audit Link</u></a>");
				if(!extImageApplId.equals("")){
					if(!("DMS").equals(extImageApplId)) {
						if(!("DOCUL").equals(extImageApplId) && (extImageUploadId.equals(null) || extImageUploadId.equals(""))) 
						{
							noteConted.append("&nbsp;"+ "<img src='../../eCA/images/"+extImageApplId+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+extImageObjId+"','"+contrSysEventCode+"','"+extImageApplId+"','"+patientId+"')\">");	
						}
						else  if (extImageUploadId.equals(null) || extImageUploadId.equals(""))
						{
							noteConted.append("&nbsp;"+ "<img src='../../eCA/images/"+extImageApplId+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+extImageApplId+"','"+patientId+"')\">");	
						}						
					}
				}				
				if(!htmlImageUploadId.equals(""))
				{					
					noteConted.append("&nbsp;"+ "<img src='../../eCA/images/IniAss.png' onClick=\"return getFile_SH('"+java.net.URLEncoder.encode(accessionNum)+"')\">");
				}
				noteConted.append("</PRE>");
				if(!"".equals(sectionContentFooter));
				noteConted.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+sectionContentFooter+"</td></tr></table><BR>");
				
				
			}
				
			resultMap.put(accessionNum,noteConted.toString());
			setRecords(resultMap);
		}catch(Exception eee){								
			eee.printStackTrace();
		}finally{
			if(rs != null) rs.close(); 
			if(pstmt != null) pstmt.close();
			if(connection!=null)connection.close();
		}
		
	}//IN071596 ends
	public void getRadiologyContent(String facility_id,String event_date_time,String contr_sys_event_code,String accessionNum,String hist_data_type,String locale,String reEncounterId,String patient_id,String url,String clinician_id,String login_user_id,String indicator_type) 	throws Exception,SQLException 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		//PreparedStatement pstmt1 = null;//46480
		ResultSet rs = null;
	//	ResultSet rs1 = null;//46480
	//	String cal_eventdate			=	"";//46480
		StringBuffer noteContedBuffer = new StringBuffer();	
		StringBuffer noteConted = new StringBuffer();
		java.io.BufferedReader noteContentReader;
		Clob noteContent = null;
		String histRecType				=	"";
		String contrSysId				=	"";
		String contrSysEventCode		=	"";
		String extImageObjId			=	"";
		String extImageApplId			=	"";
		String extImageUploadId			=	"";
		String htmlImageUploadId		=	"";
	//	String deceased_date="",deceased_yn="";//46480
		String color_cell_indicator="",normalcy_ind="",normalcy_str="";
		String data = "",resultNum="",normalrange1="",normalrange2="";//normalrange=""//46480
	//	String Normal_Range = "";//46480
		String result_uom="",criticalrange1="",criticalrange2=" ";//Critical_Range = "",criticalrange="";//46480
		HashMap<String, String> resultMap= new HashMap<String,String>();	
		try{
		//	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();//46480
		//	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();//46480
			connection=ConnectionManager.getConnection();
			//6484 Start.
			//pstmt=connection.prepareStatement("SELECT a.hist_rec_type hist_rec_type,a.RESULT_NUM_PREFIX,a.RESULT_NUM_UOM,a.RESULT_NUM,a.NORMAL_LOW,a.NORMAL_HIGH,a.CRITICAL_LOW,a.CRITICAL_HIGH,a.contr_sys_id contr_sys_id,a.contr_sys_event_code contr_sys_event_code,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.ext_image_upld_id ext_image_upld_id,a.html_image_upld_id html_image_upld_id,b.hist_data hist_data,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,a.normalcy_ind,a.normalcy_str FROM cr_encounter_detail a,cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num and b.accession_num=? AND b.contr_sys_event_code = a.contr_sys_event_code");
			//25408 Start.
			//pstmt=connection.prepareStatement("SELECT a.hist_rec_type hist_rec_type,a.RESULT_NUM_PREFIX,a.RESULT_NUM_UOM,a.RESULT_NUM,a.NORMAL_LOW,a.NORMAL_HIGH,a.CRITICAL_LOW,a.CRITICAL_HIGH,a.contr_sys_id contr_sys_id,a.contr_sys_event_code contr_sys_event_code,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.ext_image_upld_id ext_image_upld_id,a.html_image_upld_id html_image_upld_id,b.hist_data hist_data,b.compress_hist_data_yn, b.compress_hist_data,b.comments,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,a.normalcy_ind,a.normalcy_str FROM cr_encounter_detail a,cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num and b.accession_num=? AND b.contr_sys_event_code = a.contr_sys_event_code");
			pstmt=connection.prepareStatement("SELECT a.hist_rec_type hist_rec_type,a.RESULT_NUM_PREFIX,a.RESULT_NUM_UOM,a.RESULT_NUM,a.NORMAL_LOW,a.NORMAL_HIGH,a.CRITICAL_LOW,a.CRITICAL_HIGH,a.contr_sys_id contr_sys_id,a.contr_sys_event_code contr_sys_event_code,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.ext_image_upld_id ext_image_upld_id,a.html_image_upld_id html_image_upld_id,b.hist_data hist_data,b.compress_hist_data_yn, b.compress_hist_data,b.comments,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,a.normalcy_ind,a.normalcy_str FROM cr_encounter_detail a,cr_encounter_detail_txt b WHERE a.accession_num=? and b.hist_rec_type(+) = a.hist_rec_type AND b.contr_sys_id(+) = a.contr_sys_id AND b.accession_num(+) = a.accession_num  AND b.contr_sys_event_code(+) = a.contr_sys_event_code");			
			//25408 End.
			//6484 End.
			pstmt.setString(1, accessionNum);
			rs=pstmt.executeQuery();
			if(rs.next()){
				noteContent			= 	rs.getClob("hist_data");
				histRecType			=	rs.getString("hist_rec_type")==null?"":rs.getString("hist_rec_type");
				contrSysId			=	rs.getString("contr_sys_id")==null?"":rs.getString("contr_sys_id");
				contrSysEventCode	=	rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code");
				extImageObjId		=	rs.getString("ext_image_obj_id")==null?"":rs.getString("ext_image_obj_id");
				extImageApplId		=	rs.getString("ext_image_appl_id")==null?"":rs.getString("ext_image_appl_id");
				extImageUploadId	=	rs.getString("ext_image_upld_id")==null?"":rs.getString("ext_image_upld_id");
				htmlImageUploadId	=	rs.getString("html_image_upld_id")==null?"":rs.getString("html_image_upld_id");
				if(histRecType.equals("RDIN")){
					if(indicator_type.equals("I"))
						color_cell_indicator = rs.getString("SYMBOL_LEGEND_IND") == null ? "" : rs.getString("SYMBOL_LEGEND_IND");
							else
								color_cell_indicator = rs.getString("COLOR_CELL_IND") == null ? "" : rs.getString("COLOR_CELL_IND");	
					
					normalcy_ind = rs.getString("normalcy_ind") == null ? "" : rs.getString("normalcy_ind");
					normalcy_str = rs.getString("normalcy_str") == null ? "" : rs.getString("normalcy_str");
					BigDecimal rn1 =rs.getBigDecimal("RESULT_NUM");
					if(rn1!=null)
						resultNum=rn1.toString();
					else
						resultNum="";
					BigDecimal nl =rs.getBigDecimal("NORMAL_LOW");
					if(nl!=null)
						normalrange1=nl.toString();
					else
						normalrange1="";
					BigDecimal nh =rs.getBigDecimal("NORMAL_HIGH");
					if(nh!=null)
						normalrange2=nh.toString();
					else
						normalrange2="";
					
					criticalrange1 = rs.getString("CRITICAL_LOW");
					if (criticalrange1 == null) criticalrange1 = "";

					criticalrange2 = rs.getString("CRITICAL_HIGH");
					if (criticalrange2 == null) criticalrange2 = "";
		
						String numFormat = "&nbsp;&nbsp;&nbsp;&nbsp;";
						if(rs.getString("RESULT_NUM_PREFIX") != null && !(rs.getString("RESULT_NUM_PREFIX")).equals(""))
						{
							numFormat= numFormat +  rs.getString("RESULT_NUM_PREFIX");
						}
						numFormat= numFormat +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ resultNum +"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));

						result_uom = rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
					
				}
			//}
			//6484 Start.
				if("Y".equals(rs.getString("compress_hist_data_yn")==null?"N":(String)rs.getString("compress_hist_data_yn"))){				
					
					java.sql.Blob note_blob =  (java.sql.Blob)rs.getBlob("compress_hist_data");
					if(note_blob!=null && note_blob.length()>0){
						InputStream ins1 = note_blob.getBinaryStream();
						ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
						int i;
						while((i = ins1.read()) != -1) 
							bytearrayoutputstream.write(i);
						
						byte[] compressed	=bytearrayoutputstream.toByteArray();
						if(compressed.length > 0){
							if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
								GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
								BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

								String line;
								while ((line = bufferedReader.readLine()) != null) {							
									noteContedBuffer.append(line+"\n");
								}
							}					
						}
					} 
				}else{ //6484 End.
					if(noteContent!=null){
						noteContentReader = new java.io.BufferedReader(noteContent.getCharacterStream());
						String line = null;	
						while((line=noteContentReader.readLine()) != null) noteContedBuffer.append(line+"\n");
					}
				} //6484.
				noteContedBuffer.append((rs.getString("comments")==null?"":(String)rs.getString("comments"))); //6484.
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
			if(indicator_type.equals("I") && !indicator_type.equals(""))
			{
				if(!color_cell_indicator.equals("NONE"))
					data = "<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
				else if(normalcy_ind.equals("."))
				{
					data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
				}
				else if(!normalrange1.equals("") && !normalrange2.equals(""))					
				{
					if(Float.parseFloat(resultNum)>0)
					{
						if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2)))
						{
							data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}
				else if(!normalrange1.equals("") && normalrange2.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310		
				{
					if(Float.parseFloat(resultNum)>0)
					{
						if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) 
						{
							data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}
				else if(normalrange1.equals("") && !normalrange2.equals(""))					
				{
					if(Float.parseFloat(resultNum)>0)
					{
						if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2))
						{
							data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}//END
			}
			else if(indicator_type.equals("C") && !indicator_type.equals(""))
			{
				if(!color_cell_indicator.equals("NONE"))
					data = "<font style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
				else if(normalcy_ind.equals("."))
				{
					data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
				}
				else if(!normalrange1.equals("") && !normalrange2.equals(""))
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2)))
						{
							data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}
				else if(!normalrange1.equals("") && normalrange2.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1))
						{
							data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}
				else if(normalrange1.equals("") && !normalrange2.equals(""))
				{
					if(Float.parseFloat(resultNum)>0)
					{
						if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2))
						{
							data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
						}
					}
				}//END
			}
			else
				data = "<font size=1>"+data+"</font>";
			
			
			noteConted.append(data);
		
			if( hist_data_type.equals("STR") || hist_data_type.equals("NUM")|| hist_data_type.equals("TXT") ){
				
				String displaydataTemp = ((String)(noteContedBuffer.toString()).replaceAll("<DIV align=left> <ADDRESS><FONT size=3></FONT>&nbsp;</ADDRESS></DIV>","").replaceAll("line-height: 100%"," ")).trim();
				noteConted.append("<PRE style='word-wrap:break-word;'>");
				noteConted.append(displaydataTemp);
				
					noteConted.append("<br>");
				if(!extImageApplId.equals("")){
					if(!("DMS").equals(extImageApplId)) {
						if(!("DOCUL").equals(extImageApplId) && (extImageUploadId.equals(null) || extImageUploadId.equals(""))) 
						{
							noteConted.append("&nbsp;"+ "<img src='../../eCA/images/"+extImageApplId+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+extImageObjId+"','"+contrSysEventCode+"','"+extImageApplId+"','"+patient_id+"')\">");	
						}
						else  if (extImageUploadId.equals(null) || extImageUploadId.equals(""))
						{
							noteConted.append("&nbsp;"+ "<img src='../../eCA/images/"+extImageApplId+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+extImageApplId+"','"+patient_id+"')\">");	
						}						
					}
				}				
				if(!htmlImageUploadId.equals(""))
				{					
					noteConted.append("&nbsp;"+ "<img src='../../eCA/images/IniAss.png' onClick=\"return getFile_SH('"+java.net.URLEncoder.encode(accessionNum)+"')\">");
				}
				noteConted.append("</PRE>");
				
			}
				
			resultMap.put(accessionNum,noteConted.toString());
			setRecords(resultMap);
		}catch(Exception eee){								
			eee.printStackTrace();
		}finally{
			if(rs != null) rs.close(); 
			if(pstmt != null) pstmt.close();
			if(connection!=null)connection.close();
		}
		
	}//IN072759 ends
	//6450 starts
	public ArrayList getMedicalReports(String patient_id,String facility_id,String clinician_id,String fromDate,String toDate,String selTab,String encounter_id,String date_Ordr,String patient_class ) throws SQLException
	{
		Connection con = null;
		PreparedStatement noteStmt = null;
		ResultSet noteRs = null;
		ArrayList searchData = new ArrayList();			
	//	String default_pat_name="";//46480
		String event_date_time 			=	"";
		String accessionNum				=	"";
		String performed_by_id 			=	"";
		String reFacilityId 			= 	"";
		String reEncounterId 			= 	"";
		String note_type_desc			="";
		Event_date.clear();
		if(selTab.equals("S"))
			selTab="self_tab";
		if(selTab.equals("M"))
			selTab="my_tab";
		try
		{
			con=ConnectionManager.getConnection();
			int i=1;
			StringBuffer query_notes_detail =new StringBuffer();
			query_notes_detail.append("SELECT b.note_type_desc note_type_desc,TO_CHAR (a.event_date_time, 'dd/mm/rrrr hh24:mi') event_date_time,a.accession_num,a.performed_by_id,a.encounter_id,a.facility_id  from ca_encntr_note a, ca_note_type b ,MR_REPORT_REQUEST_HDR_VW c where a.note_type = b.note_type and a.facility_id=c.facility_id  and a.accession_num=c.accession_num and a.patient_id=c.patient_id AND c.request_status in('4','5','6') and a.patient_id=? AND a.patient_class = NVL(?,patient_class) and contr_mod_accession_num like 'MR%' ");
			if(!facility_id.equals(""))
					query_notes_detail.append(" AND a.facility_id = ? ");
			if(!encounter_id.equals(""))
				query_notes_detail.append(" and a.ENCOUNTER_ID = ? ");	
				
			if("self_tab".equals(selTab)){
			
				query_notes_detail.append(" and a.PERFORMED_BY_ID=? ");
			}
			if("my_tab".equals(selTab))
			{
				query_notes_detail.append(" and 'Y' = CA_PRACT_SPECILITY_YN(a.PERFORMED_BY_ID,?,a.facility_id) ");
			}
			if(!"".equals(fromDate))
				query_notes_detail.append(" AND  A.event_date_time >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi')  ");
			if(!"".equals(toDate))
				query_notes_detail.append(" AND a.event_date_time <=TO_DATE (NVL (?, '01/01/9999'), 'dd/mm/yyyy hh24:mi')+ .00068287 ");
			if(date_Ordr.equals("D"))
				query_notes_detail.append(" order by EVENT_DATE_TIME desc");
			else
				query_notes_detail.append(" order by EVENT_DATE_TIME asc");	
			
			noteStmt= con.prepareStatement(query_notes_detail.toString());
			
			noteStmt.setString(i++,patient_id);
			noteStmt.setString(i++,patient_class);
			if(!"".equals(facility_id))
				noteStmt.setString(i++,facility_id);
			if(!encounter_id.equals(""))
				noteStmt.setString(i++,encounter_id);
			if("self_tab".equals(selTab)){
				noteStmt.setString(i++,clinician_id);
			}
			if("my_tab".equals(selTab)){
				noteStmt.setString(i++,clinician_id);
			}
			if(!"".equals(fromDate))
				noteStmt.setString(i++,fromDate);
			if(!"".equals(toDate))
				noteStmt.setString(i++,toDate);			
			noteRs	 = noteStmt.executeQuery();

			if(noteRs!=null)
			{
				HashMap<String,String>  resultMap=null;
				while(noteRs.next()){
					resultMap= new HashMap<String,String>();					
					event_date_time  		=	noteRs.getString("event_date_time")==null?"":noteRs.getString("event_date_time");
					Event_date.add(event_date_time);
					accessionNum		=	noteRs.getString("accession_num")==null?"":noteRs.getString("accession_num");
					performed_by_id 	=	noteRs.getString("performed_by_id")==null?"":noteRs.getString("performed_by_id");
					reFacilityId 		= 	noteRs.getString("facility_id")==null?"":noteRs.getString("facility_id");
					reEncounterId 		= 	noteRs.getString("encounter_id")==null?"":noteRs.getString("encounter_id");
					note_type_desc		=	noteRs.getString("note_type_desc")==null?"":noteRs.getString("note_type_desc");
					resultMap.put("Event_Date_Time",event_date_time);
					resultMap.put("accessionNum",accessionNum);
					resultMap.put("reEncounterId",reEncounterId);
					resultMap.put("reFacilityId",reFacilityId);
					resultMap.put("Note_Type_Desc",note_type_desc);
					searchData.add(resultMap);

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(noteRs != null) noteRs.close(); 
			if(noteStmt != null) noteStmt.close();
			if(con!=null)con.close();
		}
		return searchData;
	}
	public void getMedicalReportContent(String facility_id,String event_date_time,String accessionNum,String reEncounterId,String patient_id,String clinician_id) 	throws Exception,SQLException{
		Connection con = null;
		PreparedStatement noteStmt = null;
		ResultSet noteRs = null;
		String notes_content		= "";
		Clob			clob_notes_content	= null;
		con=ConnectionManager.getConnection();
		java.io.Reader			content_reader		= null;
		java.io.BufferedReader	bf_content_reader	= null;
		StringBuffer query_notes_detail =new StringBuffer();
		HashMap<String,String> resultMap =new HashMap<String,String>();
		int i=1;
		try{
			query_notes_detail.append("SELECT a.note_content note_content,a.compress_note_content_yn,a.compress_note_content from ca_encntr_note a, ca_note_type b,MR_REPORT_REQUEST_HDR_VW c  where a.note_type = b.note_type and a.facility_id=c.facility_id  and a.accession_num=c.accession_num and a.patient_id=c.patient_id AND c.request_status in('4','5','6') and a.patient_id=? and a.accession_num=? and contr_mod_accession_num like 'MR%' ");
			noteStmt= con.prepareStatement(query_notes_detail.toString());
			noteStmt.setString(i++,patient_id);
			noteStmt.setString(i++,accessionNum);
			noteRs	 = noteStmt.executeQuery();
			while(noteRs.next()){
				//6484 Start.
				if("Y".equals(noteRs.getString("compress_note_content_yn")==null?"":(String)noteRs.getString("compress_note_content_yn"))){
					
					java.sql.Blob note_blob =  (java.sql.Blob)noteRs.getBlob("compress_note_content");
					if(note_blob!=null && note_blob.length()>0){
						InputStream ins1 = note_blob.getBinaryStream();
						ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
						int g;
						while((g = ins1.read()) != -1) 
							bytearrayoutputstream.write(g);
						
						byte[] compressed	=bytearrayoutputstream.toByteArray();
						if(compressed.length > 0){
							if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
								GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
								BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

								String line;
								while ((line = bufferedReader.readLine()) != null) {
									notes_content += line;
								}
							}					
						}
					}				
				}else{//6484 end.
					clob_notes_content=(Clob)noteRs.getObject("note_content");
					if(clob_notes_content!=null)
					{
						try
						{
							content_reader	= clob_notes_content.getCharacterStream();
							bf_content_reader = new java.io.BufferedReader(content_reader);

							char[] arr_notes_content = new char[(int)clob_notes_content.length()];
							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());

							notes_content = new String(arr_notes_content);
							bf_content_reader.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
				}
				resultMap.put(accessionNum,notes_content.toString());
				setRecords(resultMap);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(noteRs != null) noteRs.close(); 
			if(noteStmt != null) noteStmt.close();
			if(con!=null)con.close();
		}
	}
}//6450 ends
