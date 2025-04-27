/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/04/2018	IN061884		Raja S			18/04/2018		Ramesh G		ML-MMOH-CRF-0536
16/10/2018 	IN068145		Raja S			16/10/2018   	Ramesh G		ML-MMOH-CRF-1212
26/02/2019	IN069290		Raja S			26/02/2019		Ramehs G		ML-MMOH-CRF-1317
06/01/2020	IN071374		Ramesh Goli		06/01/2020		Ramesh G		ML-MMOH-SCF-1367	
21/02/2020	IN072473	SIVABAGYAM M		21/02/2020		RAMESH G		ML-MMOH-SCF-1477
05/05/2020	IN072901	SIVABAGYAM M		05/05/2020		RAMESH G		ML-MMOH-SCF-1477.1
04/05/2021	17012		Ramesh Goli										ML-MMOH-SCF-1779
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
14/07/2023	47838			Krishna Pranay	17/07/2023		RAMESH G		ML-MMOH-SCF-2479
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.servlet.jsp.PageContext;

import webbeans.eCommon.ConnectionManager;
import java.math.*;

import eCA.Common.CaAdapter;
public class GroupCompDetailBean extends CaAdapter implements Serializable {

	public ArrayList getEventClass(Connection con,String locale, String patient_id,String encounter_id,String clinician_id,String resp_id,String catalog_nature,String hist_type,String from_dt,String to_Dt) throws Exception {
		
		ArrayList eventClass = new ArrayList() ; 
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		int i=1;
		StringBuffer sbQryCriteria	= new StringBuffer();

		sbQryCriteria.append("Select distinct a.event_class Event_class,c.long_desc Event_class_desc From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type  and   e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E') ");
		
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");
		
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group )");
		
		sbQryCriteria.append("and a.hist_rec_type=? ");

		if(!"".equals(from_dt))
			sbQryCriteria.append("and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi')");

		if(!"".equals(to_Dt))
			 sbQryCriteria.append("and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 ");

		 sbQryCriteria.append("order by 2");


		try{
			pStatment = con.prepareStatement(sbQryCriteria.toString());
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, patient_id);

			if(!encounter_id.equals(""))
				pStatment.setString(i++, encounter_id);

			if("LBIN".equals(hist_type))
				pStatment.setString(i++, catalog_nature);

			pStatment.setString(i++, hist_type);

			if(!"".equals(from_dt))
				pStatment.setString(i++, from_dt);

			if(!"".equals(to_Dt))
				pStatment.setString(i++, to_Dt);

			resultSet = pStatment.executeQuery(); 
		 
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					String[] event_class_list  = new String[2];
					event_class_list[0] =(String)resultSet.getString("Event_class");
					event_class_list[1] =(String)resultSet.getString("Event_class_desc");
					eventClass.add(event_class_list); 
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

		return eventClass;
	}
	public ArrayList getGroupTree(Connection con,String locale,String hist_type,String catalog_nature,String event_class,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt) throws Exception {
		
		ArrayList eventGroup = new ArrayList() ;
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		int i=1;
		StringBuffer sbQryCriteria	= new StringBuffer();

		sbQryCriteria.append("Select nvl(a.event_group,'*ALL') EVENT_GROUP, nvl(e.long_desc,d.long_desc) event_group_desc,to_char(A.EVENT_DATE,'YYYY') Year,RTRIM(to_char(A.EVENT_DATE,'Month')) Month,count(*) Rec_count From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E') ");
		
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
		
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group )");
		
		sbQryCriteria.append("and a.event_class=? and a.hist_rec_type=? ");
		
		if(!"".equals(from_dt))
			sbQryCriteria.append("and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");

		if(!"".equals(to_Dt))
			sbQryCriteria.append("and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 ");

		sbQryCriteria.append("group by nvl(a.event_group,'*ALL'), nvl(e.long_desc,d.long_desc),to_char(A.EVENT_DATE,'YYYY'),RTRIM(to_char(A.EVENT_DATE,'Month')) order by 2,3 desc,4 asc");

		try{
			pStatment = con.prepareStatement(sbQryCriteria.toString());
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, patient_id);
			if(!encounter_id.equals(""))
				pStatment.setString(i++, encounter_id);
			if("LBIN".equals(hist_type))
				pStatment.setString(i++, catalog_nature);
			pStatment.setString(i++, event_class);
			pStatment.setString(i++, hist_type);
			if(!"".equals(from_dt))
				pStatment.setString(i++, from_dt);
			if(!"".equals(to_Dt))
				pStatment.setString(i++, to_Dt);
			resultSet = pStatment.executeQuery(); 
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					String[] event_class_list  = new String[4];
					event_class_list[0]=resultSet.getString("EVENT_GROUP")==null?"":resultSet.getString("EVENT_GROUP");
					event_class_list[1]=resultSet.getString("event_group_desc")==null?"":resultSet.getString("event_group_desc");
					event_class_list[2]=resultSet.getString("Year")==null?"":resultSet.getString("Year");
					event_class_list[3]=resultSet.getString("Month")==null?"":resultSet.getString("Month");
					eventGroup.add(event_class_list); 
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
		return eventGroup;
	}
	public ArrayList getTestHeader(Connection con,String locale,String hist_type,String catalog_nature,String event_class,String event_group,String event_year,String event_month,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt) throws Exception {
		
		ArrayList eventGroup = new ArrayList() ;
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		int i=1;
		StringBuffer sbQryCriteria	= new StringBuffer();

		//sbQryCriteria.append("Select distinct a.event_code event_code,d.long_desc event_desc From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) and nvl(ca_view_confidnt_event(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");//Commented for Sorting
		//sbQryCriteria.append("Select distinct a.event_code event_code,d.long_desc event_desc,nvl(a.request_num_seq,'0') req_num From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) and nvl(ca_view_confidnt_event(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");//Modified for Sorting//IN072901
		//sbQryCriteria.append("Select distinct a.event_code event_code,d.long_desc event_desc,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) and nvl(ca_view_confidnt_event(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");//Modified for Sorting//IN072901 //common-icn-0180
		sbQryCriteria.append("Select distinct a.event_code event_code,d.long_desc event_desc,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) and nvl(ca_view_confidnt_event(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");//Modified for Sorting//IN072901//common-icn-0180
		
		
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
		
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group ) ");
		
		sbQryCriteria.append("and a.hist_rec_type=? and a.event_class=? and a.event_group=? and to_char(A.EVENT_DATE,'YYYY')=? and RTRIM(to_char(EVENT_DATE,'Month'))=? ");

		if(!"".equals(from_dt))
			sbQryCriteria.append("and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi' ) ");
			
		if(!"".equals(to_Dt))
			sbQryCriteria.append("and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 "); 
			
		//sbQryCriteria.append("order by 2");//Commented for Sorting 
		//sbQryCriteria.append("order by nvl(a.request_num_seq,'0')");//Modified for Sorting//IN072473
		sbQryCriteria.append("order by NVL (sequence_no,0)");//Modified for Sorting//IN072473

		try{
			pStatment = con.prepareStatement(sbQryCriteria.toString());
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, patient_id);
			pStatment.setString(i++, clinician_id);//common-icn-0180
			pStatment.setString(i++, resp_id);//common-icn-0180
			if(!encounter_id.equals(""))
				pStatment.setString(i++, encounter_id);
			if("LBIN".equals(hist_type))
				pStatment.setString(i++, catalog_nature);
			pStatment.setString(i++, hist_type);
			pStatment.setString(i++, event_class);
			pStatment.setString(i++, event_group);
			pStatment.setString(i++, event_year);
			pStatment.setString(i++, event_month);
			if(!"".equals(from_dt))
			pStatment.setString(i++, from_dt);
			if(!"".equals(to_Dt))
				pStatment.setString(i++, to_Dt);
			resultSet = pStatment.executeQuery(); 
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					//String[] event_class_list  = new String[3];// commented for IN072901
					String[] event_class_list  = new String[2];//IN072901
					event_class_list[0]=resultSet.getString("event_code")==null?"":resultSet.getString("event_code");
					event_class_list[1]=resultSet.getString("event_desc")==null?"":resultSet.getString("event_desc");
					//event_class_list[2]=resultSet.getString("req_num")==null?"":resultSet.getString("req_num");//commented for IN072901
					eventGroup.add(event_class_list); 
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

		return eventGroup;
	}
	public LinkedHashMap getGroupDetails(PageContext pageContext,Connection con,String locale,String login_user,String hist_type,String catalog_nature,String event_class,String event_group,String event_year,String event_month,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt) throws Exception {
		
		PreparedStatement pStatment = null; 
		ResultSet resultSet = null;
		PreparedStatement pstmt = null; 
		CallableStatement cs=null; //17012
		ResultSet rset = null;
		int i=1;
		StringBuffer sbQryCriteria	= new StringBuffer();
		
		LinkedHashMap<String,ArrayList> clinicalHistoryDate= new LinkedHashMap<String,ArrayList>();//IN072473 changed from hashmap to linked hashmap
		LinkedHashMap<String,HashMap> clinicalHistoryValues= new LinkedHashMap<String,HashMap>();
		

		String tempDateTime  ="";
		String tempEvenCode="";
		String temp_eventgroup="";
		int recCount = 0;
		boolean isPracSiteSpecific = false;
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER");
		boolean isVerifiedSiteSpec = false;//IN069290
		isVerifiedSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VERIFIEDBY_PRACTITIONER"); //Added for IN069290
		String event_dtime = "";
		String toolTip_ind = "";
		String out_event_code=""; //17012
		String fac_id = "";//17012
		StringBuffer tempNormCritStr = new StringBuffer();
		String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
		String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
		
		//int j = 0;
		//6484 Start.
		//sbQryCriteria.append("Select to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(A.EVENT_DATE,'DD/MM/YYYY') evedate,nvl(a.request_num_seq,'0') req_num,to_char(A.EVENT_DATE,'HH24:mi') evetime,a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC    ,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?) GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL(( SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code, 'NONE') FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE') FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR, LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1,RESULT_NUM_DEC, a.event_code_type,(select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no From cr_encounter_detail a WHERE a.patient_id = ? ");
	//	sbQryCriteria.append("Select to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(A.EVENT_DATE,'DD/MM/YYYY') evedate,nvl(a.request_num_seq,'0') req_num,to_char(A.EVENT_DATE,'HH24:mi') evetime,a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC    ,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?) GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL(( SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code, 'NONE') FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE') FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR, LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1,RESULT_NUM_DEC, a.event_code_type,(select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no From cr_encounter_detail a WHERE a.patient_id = ? ");
		//6484 End.
		sbQryCriteria.append("Select to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(A.EVENT_DATE,'DD/MM/YYYY') evedate,nvl(a.request_num_seq,'0') req_num,to_char(A.EVENT_DATE,'HH24:mi') evetime,a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC    ,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?) GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL(( SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code, 'NONE') FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE') FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR, LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1,RESULT_NUM_DEC, a.event_code_type,(select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn  From cr_encounter_detail a WHERE a.patient_id = ? ");//31792
		
		
		if(!"".equals(from_dt))
			sbQryCriteria.append("and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI') ");

		if(!"".equals(to_Dt))
			sbQryCriteria.append("and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287");
		
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
		
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group )");
		
		
			//sbQryCriteria.append("and a.hist_rec_type=? and a.event_class=? and a.event_group=? and to_char(A.EVENT_DATE,'YYYY')=? and RTRIM(to_char(EVENT_DATE,'Month'))=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and nvl(a.STATUS,'`') not in('S','E') order by 1 desc,10 asc");//IN072473
		sbQryCriteria.append(" and a.hist_rec_type=? and a.event_class=? and a.event_group=? and to_char(A.EVENT_DATE,'YYYY')=? and RTRIM(to_char(EVENT_DATE,'Month'))=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and nvl(a.STATUS,'`') not in('S','E') ORDER BY event_group_desc, 1 DESC,NVL (sequence_no,0),event_desc");//IN072473
		
		
				
		try{
				pStatment = con.prepareStatement(sbQryCriteria.toString());
				pStatment.setString(i++, locale);
				pStatment.setString(i++, locale);
				pStatment.setString(i++, locale);
				pStatment.setString(i++, locale);
				pStatment.setString(i++, locale);
				pStatment.setString(i++, patient_id);
				if(!"".equals(from_dt))
					pStatment.setString(i++, from_dt);
				if(!"".equals(to_Dt))
					pStatment.setString(i++, to_Dt);
				if(!encounter_id.equals(""))
					pStatment.setString(i++, encounter_id);
				
				if("LBIN".equals(hist_type))
						pStatment.setString(i++, catalog_nature);
				 
				pStatment.setString(i++, hist_type);
				pStatment.setString(i++, event_class);
				pStatment.setString(i++, event_group);
				pStatment.setString(i++, event_year);
				pStatment.setString(i++, event_month);

				resultSet = pStatment.executeQuery(); 
				if ( resultSet != null ){
					while(resultSet.next()){
						tempNormCritStr.setLength(0);
					
						String normalrange = "";
						String resultNum  = "";
						String normalLow = "";
						String normalHigh ="";
						String criticalrange = "";
					
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
						if(!normalLow.equals("") && !normalHigh.equals(""))
							normalrange = Normal_Range + " : " + normalLow + " - " + normalHigh + " " + resultNumUOM;
						else if(!normalLow.equals("") && normalHigh.equals(""))
							normalrange = Normal_Range + " : (>=" + normalLow + " " + resultNumUOM + ")";
						else if(normalLow.equals("") && !normalHigh.equals(""))
							normalrange = Normal_Range + " : (<=" + normalHigh + " " + resultNumUOM + ")";
						else
							normalrange = "";
				
						if(!criticalLow.equals("") && !criticalHigh.equals(""))
						{
							criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
						}
						else if(!criticalLow.equals("") && criticalHigh.equals(""))
						{
							criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+")" ;
						}
						else if(criticalLow.equals("") && !criticalHigh.equals(""))
						{
							criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
						}
						else
							criticalrange = "";
					
						if(!normalrange.equals("") && !criticalrange.equals(""))
							tempNormCritStr.append(normalrange+"<br> "+criticalrange);
						else if(!normalrange.equals(""))
							tempNormCritStr.append(normalrange);
						else if(!criticalrange.equals(""))
							tempNormCritStr.append(criticalrange);
						else
							tempNormCritStr.append("");
					
						if(isPracSiteSpecific && "LBIN".equals(hist_type)){
							if(!resulted_practitioner.equals("")){
								if(!(tempNormCritStr.toString()).equals("")){
									if(isVerifiedSiteSpec)//IN069290 added Verified By
										tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + resulted_practitioner ); 
									else
										tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + resulted_practitioner );
	
								}
							}
						}else{
							if(!performed_by.equals("")){
								if(!(tempNormCritStr.toString()).equals("")){
									if(isVerifiedSiteSpec)//IN069290 added Verified By
										tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + performed_by );
									else
										tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + performed_by );
								}
							}
						}
					
						toolTip_ind = tempNormCritStr.toString(); 
						event_dtime =resultSet.getString("event_date_time")==null?"":resultSet.getString("event_date_time"); 
						String event_code = resultSet.getString("eve_code")==null?"":resultSet.getString("eve_code");				
					
						ArrayList<String> eventDetails = new ArrayList<String>() ;					

						eventDetails.add(resultSet.getString("event_date_time")==null?"":resultSet.getString("event_date_time"));
						eventDetails.add(resultSet.getString("evedate")==null?"":resultSet.getString("evedate"));
						eventDetails.add(resultSet.getString("evetime")==null?"":resultSet.getString("evetime"));
						fac_id = resultSet.getString("FACILITY_ID") == null ? "0" : resultSet.getString("FACILITY_ID");
					
						BigDecimal rn =resultSet.getBigDecimal("result_num");
						if(rn!=null)
							resultNum=rn.toString();
						else
							resultNum="";
						String histDataType = resultSet.getString("HIST_DATA_TYPE")==null?"":resultSet.getString("HIST_DATA_TYPE");
						//String decival = resultSet.getString("RESULT_NUM_DEC") == null ? "0" : resultSet.getString("RESULT_NUM_DEC");
						String colorCellInd = resultSet.getString("COLOR_CELL_IND")==null?"":resultSet.getString("COLOR_CELL_IND");
						String normIndicator = resultSet.getString("norm_ind") == null ? "" : resultSet.getString("norm_ind");
						String normal_Yn = "N";
						if(histDataType.equals("NUM")){					
							if(!resultNum.equals("")){
								if(colorCellInd.equals("NONE")){
									if(normIndicator.equals("."))
										normal_Yn = "Y";
									else if(!normalLow.equals("") && !normalHigh.equals("")){
										if(Float.parseFloat(resultNum) > 0)	{
											if ((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)) )
											{
												normal_Yn = "Y";
											}
											else
												normal_Yn = "N";
										}else
											normal_Yn = "N";
									}else if(!normalLow.equals("") && normalHigh.equals("")){
										if(Float.parseFloat(resultNum) > 0){
											if (Float.parseFloat(resultNum) >= Float.parseFloat(normalLow))
											{
												normal_Yn = "Y";
											}
											else
												normal_Yn = "N";
										}
										else
											normal_Yn = "N";
									}else if(normalLow.equals("") && !normalHigh.equals("")){
										if(Float.parseFloat(resultNum) > 0){
											if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
											{
												normal_Yn = "Y";
											}
											else
												normal_Yn = "N";
										}
										else
											normal_Yn = "N";
									}else
										normal_Yn = "N";
								}
								else
									normal_Yn = "N";
							}
						}
						else if(normIndicator.equals("."))
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
						
							cs = con.prepareCall( "{ call rl_image_count(?,?,?,?,?,?)}" );
							cs.setString(1,(resultSet.getString("sys_eve_code")==null?"":resultSet.getString("sys_eve_code")));
							cs.setString(2,(resultSet.getString("acc_num")==null?"":resultSet.getString("acc_num")));
							cs.setString(3,event_code);
							cs.setString(4,patient_id);
							cs.registerOutParameter( 5,  java.sql.Types.VARCHAR ) ;
							cs.registerOutParameter( 6,  java.sql.Types.INTEGER ) ;
							cs.execute() ;
							out_event_code	= cs.getString( 5 ) ;
							recCount	= cs.getInt( 6 ) ;
							//17012 End.
							
							recCountInt = String.valueOf(recCount);
						
							//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // modified for IN040416//commented for IN068650
							//17012 Start.
							//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // IN068650
							ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",out_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale); // IN071127
							//17012 End.
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
						eventDetails.add(resultSet.getString("req_num")==null?"":resultSet.getString("req_num"));
						// 1606 changes begin
						eventDetails.add(resultSet.getString("eve_class")==null?"":resultSet.getString("eve_class"));  			
					
						if(!event_dtime.equals(tempDateTime) && !tempDateTime.equals("") ){
							clinicalHistoryValues.put(tempDateTime, clinicalHistoryDate);
							clinicalHistoryValues.put(temp_eventgroup, clinicalHistoryDate);
							clinicalHistoryValues.put(tempEvenCode, clinicalHistoryDate);
							clinicalHistoryDate= new LinkedHashMap<String,ArrayList>();//IN072473 changed from hashmap to linked hashmap
							i=0;
						}else{
							if(event_dtime.equals(tempDateTime) && !tempDateTime.equals("") && temp_eventgroup.equals(event_group) && tempEvenCode.equals(event_code)){
								i=1;
							}else{
								i=0;
							}
							
						}
					//if(clinicalHistoryDate.size()>0){
					if(i>0){
						//System.out.println("--------------------->Y");
						eventDetails.add("Y");
					}else{
						//System.out.println("--------------------->N");
						eventDetails.add("N");
					}
					//1606 changes end
					eventDetails.add(resultSet.getString("lv_neonate_spec_yn")==null?"":resultSet.getString("lv_neonate_spec_yn")); //31792
					
					clinicalHistoryDate.put(event_code,eventDetails);
					tempDateTime=event_dtime;
					tempEvenCode=event_code;
					temp_eventgroup=event_group;
				}
				clinicalHistoryValues.put(tempDateTime, clinicalHistoryDate);
				clinicalHistoryDate= new LinkedHashMap<String,ArrayList>();//IN072473 changed from hashmap to linked hashmap
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
		}
		return clinicalHistoryValues;
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
			if(order_id != null && !order_id.equals("")) {
				fetchQuery = "SELECT PERFORMING_FACILITY_ID FROM OR_ORDER WHERE ORDER_ID = ?";
				prepStat = con.prepareStatement(fetchQuery);
				prepStat.setString(1, order_id);
				resultSet = prepStat.executeQuery();
				if(resultSet.next()){
					perf_facility_id = resultSet.getString("PERFORMING_FACILITY_ID");
				}
				if(resultSet != null) resultSet.close();
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
//IN068145 starts
	public LinkedHashMap getGroupExpDetails(PageContext pageContext,Connection con,String locale,String login_user,String hist_type,String catalog_nature,String event_class,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt) throws Exception {
		
		PreparedStatement pStatment = null; 
		ResultSet resultSet = null;
		PreparedStatement pstmt = null; 
		CallableStatement cs=null; //17012
		ResultSet rset = null;
		int i=1;
		StringBuffer sbQryCriteria	= new StringBuffer();
		
		HashMap<String,ArrayList> clinicalHistoryEvent= new HashMap<String,ArrayList>();
		LinkedHashMap<String,HashMap> clinicalHistoryValues= new LinkedHashMap<String,HashMap>();
		LinkedHashMap<String,HashMap> clinicalHistoryDate= new LinkedHashMap<String,HashMap>();
		
		String tempDateTime  ="";
		int recCount = 0;
		boolean isPracSiteSpecific = false;
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER");
		boolean isVerifiedSiteSpec = false;//IN069290
		isVerifiedSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VERIFIEDBY_PRACTITIONER"); //Added for IN069290
		String event_dtime = "";
		String toolTip_ind = "";
		String temp_eventgroup = "";
		String tempEvenCode="";//47838
		String out_event_code=""; //17012
		String fac_id = "";//17012
		StringBuffer tempNormCritStr = new StringBuffer();
		String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
		String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
		
		//int j = 0;
		//6484 Start.
		//sbQryCriteria.append("Select to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,nvl(a.request_num_seq,'0') req_num,to_char(A.EVENT_DATE,'DD/MM/YYYY') evedate ,to_char(A.EVENT_DATE,'HH24:mi') evetime,a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC    ,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?) GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL(( SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code, 'NONE') FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE') FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR, LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1,RESULT_NUM_DEC, a.event_code_type,(select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.HTML_IMAGE_UPLD_ID,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no From cr_encounter_detail a WHERE a.patient_id = ? "); //a.HTML_IMAGE_UPLD_ID added for IN071374
		sbQryCriteria.append("Select to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,nvl(a.request_num_seq,'0') req_num,to_char(A.EVENT_DATE,'DD/MM/YYYY') evedate ,to_char(A.EVENT_DATE,'HH24:mi') evetime,a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC    ,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?) GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) text_count, RESULT_NUM_PREFIX,NVL(( SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code, 'NONE') FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE') FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR, LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1,RESULT_NUM_DEC, a.event_code_type,(select LEGEND_TYPE from CR_CLIN_EVENT_PARAM) LEGEND_TYPE,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.HTML_IMAGE_UPLD_ID,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn From cr_encounter_detail a WHERE a.patient_id = ? "); //a.HTML_IMAGE_UPLD_ID added for IN071374//31792
		//6484 End.	
		if(!"".equals(from_dt))
			sbQryCriteria.append("and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI') ");

		if(!"".equals(to_Dt))
			sbQryCriteria.append("and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287 ");
		
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
		
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group )");
		
		//sbQryCriteria.append(" and a.hist_rec_type=? and a.event_class=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and nvl(a.STATUS,'`') not in('S','E') order by event_group_desc asc, event_date desc, nvl(a.request_num_seq,'0')");//IN072473
		sbQryCriteria.append(" and a.hist_rec_type=? and a.event_class=? and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and nvl(a.STATUS,'`') not in('S','E') order by event_group_desc,event_date DESC,NVL (sequence_no,0),event_desc");//IN072473
		
		
		try{
			pStatment = con.prepareStatement(sbQryCriteria.toString());
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, patient_id);
			if(!"".equals(from_dt))
				pStatment.setString(i++, from_dt);
			if(!"".equals(to_Dt))
				pStatment.setString(i++, to_Dt);
			if(!encounter_id.equals(""))
				pStatment.setString(i++, encounter_id);

			if("LBIN".equals(hist_type))
				pStatment.setString(i++, catalog_nature);

			pStatment.setString(i++, hist_type);
			pStatment.setString(i++, event_class);

			resultSet = pStatment.executeQuery(); 
			int colCount = 0;
			int tempColCount = 0;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					tempNormCritStr.setLength(0);
					
					String normalrange = "";
					String resultNum  = "";
					String normalLow = "";
					String normalHigh ="";
					String criticalrange = "";
					String event_group = "";
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
					event_group = resultSet.getString("event_group")==null?"":resultSet.getString("event_group");
					String criticalHigh = resultSet.getString("critical_high")==null?"":resultSet.getString("critical_high");
					String criticalLow = resultSet.getString("critical_low")==null?"":resultSet.getString("critical_low");
					
					if(!normalLow.equals("") && !normalHigh.equals(""))
						normalrange = Normal_Range + " : " + normalLow + " - " + normalHigh + " " + resultNumUOM;
					else if(!normalLow.equals("") && normalHigh.equals(""))
						normalrange = Normal_Range + " : (>=" + normalLow + " " + resultNumUOM + ")";
					else if(normalLow.equals("") && !normalHigh.equals(""))
						normalrange = Normal_Range + " : (<=" + normalHigh + " " + resultNumUOM + ")";
					else
						normalrange = "";
				
					if(!criticalLow.equals("") && !criticalHigh.equals(""))
					{
						criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
					}
					else if(!criticalLow.equals("") && criticalHigh.equals(""))
					{
						criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+")" ;
					}
					else if(criticalLow.equals("") && !criticalHigh.equals(""))
					{
						criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
					}
					else
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
								if(isVerifiedSiteSpec)//IN069290 added Verified By
									tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + resulted_practitioner );
								else
									tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + resulted_practitioner );
							}
						}
					}else
					{
						if(!performed_by.equals(""))
						{
							if(!(tempNormCritStr.toString()).equals("")){
								if(isVerifiedSiteSpec)//IN069290 added Verified By
									tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + performed_by );
								else
									tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + performed_by );
							}
						}
					}
					
					toolTip_ind = tempNormCritStr.toString(); 
					event_dtime =resultSet.getString("event_date_time")==null?"":resultSet.getString("event_date_time");
					ArrayList<String> eventDetails = new ArrayList<String>() ;
					String event_code = resultSet.getString("eve_code")==null?"":resultSet.getString("eve_code");

					eventDetails.add(resultSet.getString("event_date_time")==null?"":resultSet.getString("event_date_time"));
					eventDetails.add(resultSet.getString("evedate")==null?"":resultSet.getString("evedate"));
					eventDetails.add(resultSet.getString("evetime")==null?"":resultSet.getString("evetime"));
					fac_id = resultSet.getString("FACILITY_ID") == null ? "0" : resultSet.getString("FACILITY_ID");
					BigDecimal rn =resultSet.getBigDecimal("result_num");
					if(rn!=null)
						resultNum=rn.toString();
					else
						resultNum="";
					String histDataType = resultSet.getString("HIST_DATA_TYPE")==null?"":resultSet.getString("HIST_DATA_TYPE");
					//String decival = resultSet.getString("RESULT_NUM_DEC") == null ? "0" : resultSet.getString("RESULT_NUM_DEC");
					String colorCellInd = resultSet.getString("COLOR_CELL_IND")==null?"":resultSet.getString("COLOR_CELL_IND");
					String normIndicator = resultSet.getString("norm_ind") == null ? "" : resultSet.getString("norm_ind");
					String normal_Yn = "N";
					if(histDataType.equals("NUM"))
					{
					
						if(!resultNum.equals(""))
						{
							if(colorCellInd.equals("NONE"))
							{
								if(normIndicator.equals("."))
									normal_Yn = "Y";
								else if(!normalLow.equals("") && !normalHigh.equals(""))
								{
									if(Float.parseFloat(resultNum) > 0)
									{
										if ((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)) )
										{
											normal_Yn = "Y";
										}
										else
											normal_Yn = "N";
									}
									else
										normal_Yn = "N";
								}
								else if(!normalLow.equals("") && normalHigh.equals(""))
								{
									if(Float.parseFloat(resultNum) > 0)
									{
										if (Float.parseFloat(resultNum) >= Float.parseFloat(normalLow))
										{
											normal_Yn = "Y";
										}
										else
											normal_Yn = "N";
									}
									else
										normal_Yn = "N";
								}
								else if(normalLow.equals("") && !normalHigh.equals(""))
								{
									if(Float.parseFloat(resultNum) > 0)
									{
										if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
										{
											normal_Yn = "Y";
										}
										else
											normal_Yn = "N";
									}
									else
										normal_Yn = "N";
								}//END
								else
									normal_Yn = "N";
							}
							else
								normal_Yn = "N";
						}
					}
					else if(normIndicator.equals("."))
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
						//17012 Start.
						/*
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
						//pstmt.setString(3,event_group);commented for IN068650
						pstmt.setString(3,event_code);//IN068650
						rset = pstmt.executeQuery();
						if(rset.next()) 
						{
							recCount = rset.getInt(1);
						}	
						if(rset != null) rset.close();
						*/
						cs = con.prepareCall( "{ call rl_image_count(?,?,?,?,?,?)}" );
						cs.setString(1,(resultSet.getString("sys_eve_code")==null?"":resultSet.getString("sys_eve_code")));
						cs.setString(2,(resultSet.getString("acc_num")==null?"":resultSet.getString("acc_num")));
						cs.setString(3,event_code);
						cs.setString(4,patient_id);
						cs.registerOutParameter( 5,  java.sql.Types.VARCHAR ) ;
						cs.registerOutParameter( 6,  java.sql.Types.INTEGER ) ;
						cs.execute() ;
						out_event_code	= cs.getString( 5 ) ;
						recCount	= cs.getInt( 6 ) ;
						//17012 End.
						recCountInt = String.valueOf(recCount);
					
						//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // modified for IN040416//commented for IN068650
						//17012 Start.
						//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // IN068650
						ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",out_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale); // IN071127
						//17012 End.
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
					eventDetails.add(resultSet.getString("req_num")==null?"":resultSet.getString("req_num"));
					eventDetails.add(resultSet.getString("HTML_IMAGE_UPLD_ID")==null?"":resultSet.getString("HTML_IMAGE_UPLD_ID"));  //IN071374
					// 1606 changes begin
					eventDetails.add(resultSet.getString("eve_class")==null?"":resultSet.getString("eve_class"));  //Ramesh
					// 1606 changes end
					
					if(!tempDateTime.equals("")){
					//	if(!(tempDateTime.equals(event_dtime) && temp_eventgroup.equals(event_group))){//47838
					if(!(tempDateTime.equals(event_dtime) && temp_eventgroup.equals(event_group) && tempEvenCode.equals(event_code))){ //47838
							clinicalHistoryDate.put(tempDateTime,clinicalHistoryEvent); 
							clinicalHistoryDate.put(tempEvenCode,clinicalHistoryEvent); //47838
							clinicalHistoryEvent= new HashMap<String,ArrayList>();  
							if(tempColCount !=0){
								if(tempColCount<colCount){
									tempColCount=colCount;
									colCount=0;
								}
								else
									colCount=0;
							}
							else{
								tempColCount=colCount;
								colCount=0;
							}
							
						}
					}
					colCount++;
					//1606 changes begin
					if(clinicalHistoryEvent.size()>0){
						System.out.println("--------------------->Y");
						eventDetails.add("Y");
					}else{
						System.out.println("--------------------->N");
						eventDetails.add("N");
					}
					//1606 changes end
					eventDetails.add(resultSet.getString("lv_neonate_spec_yn")==null?"":resultSet.getString("lv_neonate_spec_yn"));  //31792
					
					clinicalHistoryEvent.put(event_code,eventDetails);
					
					if(!temp_eventgroup.equals("")){
						if(!temp_eventgroup.equals(event_group)) {
							clinicalHistoryValues.put(temp_eventgroup, clinicalHistoryDate);
							clinicalHistoryDate= new LinkedHashMap<String,HashMap>();
						}
					}

					tempDateTime =event_dtime;
					temp_eventgroup=event_group;
					tempEvenCode=event_code;//47838
				}

			}
			clinicalHistoryDate.put(tempDateTime,clinicalHistoryEvent);
			clinicalHistoryEvent= new HashMap<String,ArrayList>();
			clinicalHistoryValues.put(temp_eventgroup, clinicalHistoryDate);
			clinicalHistoryDate= new LinkedHashMap<String,HashMap>();
			
			ArrayList<Integer> eventDetails1 = new ArrayList<Integer>() ;
			if(tempColCount==0)
				tempColCount=1;
			eventDetails1.add(tempColCount);
			clinicalHistoryEvent.put("tempColCount", eventDetails1);
			clinicalHistoryDate.put("ColCount", clinicalHistoryEvent);
			clinicalHistoryValues.put("MaxColCount",clinicalHistoryDate);
			clinicalHistoryDate= new LinkedHashMap<String,HashMap>();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
		}
		return clinicalHistoryValues;
	}
	public ArrayList getTestHeaderLevel(Connection con,String locale,String hist_type,String catalog_nature,String event_class,String event_group,String patient_id,String encounter_id,String clinician_id,String resp_id,String from_dt,String to_Dt) throws Exception {
		
		ArrayList eventGroup = new ArrayList() ;
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		int i=1;
		StringBuffer sbQryCriteria	= new StringBuffer();

		//sbQryCriteria.append("Select distinct a.event_code event_code,d.long_desc event_desc From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) and nvl(ca_view_confidnt_event(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");//Commented for Sorting
		//sbQryCriteria.append("Select distinct NVL((SELECT long_desc FROM cr_clin_event_group WHERE hist_rec_type(+) = a.hist_rec_type AND event_group(+) = a.event_group AND event_group_type(+) = a.event_group_type),cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code,a.event_code_type,?,'1')) event_group_desc,a.event_code event_code,d.long_desc event_desc,nvl(a.request_num_seq,'0') req_num From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) and nvl(ca_view_confidnt_event(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");//Modified for Sorting//IN072901
		sbQryCriteria.append("Select distinct NVL((SELECT long_desc FROM cr_clin_event_group WHERE hist_rec_type(+) = a.hist_rec_type AND event_group(+) = a.event_group AND event_group_type(+) = a.event_group_type),cr_get_desc.cr_clin_event_mast (a.hist_rec_type,a.event_code,a.event_code_type,?,'1')) event_group_desc,a.event_code event_code,d.long_desc event_desc,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no From cr_encounter_detail a,CR_HIS_RECTYP_LNG_VW b,CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e where b.language_id = ? and c.language_id = ? and d.language_id = ? and e.language_id(+) = ? and b.hist_rec_type=a.hist_rec_type and  c.hist_rec_type= a.hist_rec_type and  c.event_class= a.event_class and  d.hist_rec_type=a.hist_rec_type and  d.event_code=rtrim(a.event_code) and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and  e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR    (nvl(PROTECTION_IND,'N')='Z' and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,'CA','')='A')) and nvl(ca_view_confidnt_event(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' and a.event_group is not null and nvl(a.STATUS,'`') not in('S','E')");//Modified for Sorting//IN072901
		
		
		if(!encounter_id.equals(""))
			sbQryCriteria.append(" and a.ENCOUNTER_ID = ? ");	
		
		if("LBIN".equals(hist_type))
			sbQryCriteria.append("and 'Y' = (select 'Y' from or_order_catalog where ORDER_CATALOG_NATURE=? and CONTR_MSR_PANEL_ID=a.event_group ) ");
		
		sbQryCriteria.append("and a.hist_rec_type=? and a.event_class=? and a.event_group=?");

		if(!"".equals(from_dt))
			sbQryCriteria.append("and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi' ) ");
			
		if(!"".equals(to_Dt))
			sbQryCriteria.append("and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+0.00068287 "); 
			
		sbQryCriteria.append("order by 1, NVL (sequence_no,0),EVENT_DESC");//changed for IN072473 
		//sbQryCriteria.append("order by nvl(a.request_num_seq,'0')");//Modified for Sorting// IN072473

		
		try{
			pStatment = con.prepareStatement(sbQryCriteria.toString());
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, locale);
			pStatment.setString(i++, patient_id);
			if(!encounter_id.equals(""))
			 pStatment.setString(i++, encounter_id);
			if("LBIN".equals(hist_type))
			 pStatment.setString(i++, catalog_nature);
			pStatment.setString(i++, hist_type);
			pStatment.setString(i++, event_class);
			pStatment.setString(i++, event_group);
			if(!"".equals(from_dt))
			pStatment.setString(i++, from_dt);
			if(!"".equals(to_Dt))
			 pStatment.setString(i++, to_Dt);
			resultSet = pStatment.executeQuery(); 
			int count = 0;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
				
				//String[] event_class_list  = new String[3];//commented forIN072901
					
					if(count==0){
						String[] event_class_list1  = new String[2];//IN072901
						event_class_list1[0]=event_group;
						event_class_list1[1]=resultSet.getString("event_group_desc")==null?"":resultSet.getString("event_group_desc");
						//event_class_list1[2]=resultSet.getString("req_num")==null?"":resultSet.getString("req_num");//commented for IN072901
						eventGroup.add(event_class_list1);
						//event_class_list  = new String[3];//commented for IN072901
						count++;
					}
					String[] event_class_list  = new String[2];//IN072901
					event_class_list[0]=resultSet.getString("event_code")==null?"":resultSet.getString("event_code");
					event_class_list[1]=resultSet.getString("event_desc")==null?"":resultSet.getString("event_desc");
					//event_class_list[2]=resultSet.getString("req_num")==null?"":resultSet.getString("req_num");//commented for IN072901
					eventGroup.add(event_class_list); 
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

		return eventGroup;
	}
//IN068145 ends
}
