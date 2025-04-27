/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.ReviseCarePlan;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="ReviseCarePlan"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReviseCarePlan"
*	local-jndi-name="ReviseCarePlan"
*	impl-class-name="eCP.ReviseCarePlan.ReviseCarePlanManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.ReviseCarePlan.ReviseCarePlanLocal"
*	remote-class="eCP.ReviseCarePlan.ReviseCarePlanRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.ReviseCarePlan.ReviseCarePlanLocalHome"
*	remote-class="eCP.ReviseCarePlan.ReviseCarePlanHome"
*	generate= "local,remote"
*
*
*/
public class ReviseCarePlanManager implements SessionBean
{
	Connection con;
	CallableStatement clblstmt_gen_taskList =null;
	Statement stmt;
	Statement stmtrevise_insert;
	PreparedStatement pstmtdiagUpdate;
	PreparedStatement pstmtgoalUpdate;
	PreparedStatement pstmtgoalUpdate1;
	PreparedStatement pstmtoutcomeUpdate;
	PreparedStatement pstmtoutcomeUpdate1;
	PreparedStatement pstmtIntvnUpdate;
	PreparedStatement pstmtIntvnUpdate1;
	PreparedStatement pstmtIntvnUpdate2;
	PreparedStatement pstmtIntvnUpdate3;
	PreparedStatement pstmtIntvnrecCount;
	PreparedStatement pstmtIntvnrecCount1;
	PreparedStatement pstmtIntvnInsert;
	PreparedStatement pstmtIntvnInsert1;
	PreparedStatement pstmtIntvnmainInsert;
	PreparedStatement pstmtIntvnselect;
	PreparedStatement pstmtTaskUpdate;
	PreparedStatement pstmtTaskUpdate1;
	ResultSet rs;


	 public ReviseCarePlanManager()
    {
    }
    public void ejbCreate() throws  CreateException
    {
    }
    public void ejbRemove()
    {
    }
    public void ejbActivate()
    {
    }
    public void ejbPassivate()
    {
    }
    public void setSessionContext(SessionContext sessioncontext)
    {
    }
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public HashMap AddModify(Properties properties, HashMap hashmap)
    {
		HashMap map=new HashMap();
		ArrayList Diagnosis		 =		null;
		HashMap Intvn			 =		null;
		HashMap HeaderValue    	 =		null;
		ArrayList result=new ArrayList();
		long encounter_id		= 0;
		Long encount_id		= 		new Long(1);
		Diagnosis=(ArrayList)hashmap.get("DIAGNOSIS");
		Intvn=(HashMap)hashmap.get("INTVN");
		HeaderValue=(HashMap)hashmap.get("HV");
		ArrayList Goal=null;
		HashMap IOGroup=null;
		HashMap InterventionOutcome=null;
		ArrayList Intervention=null;
		ArrayList Outcome=null;
		ArrayList IntvnList=null;
		String md_care_plan_id1=(String)HeaderValue.get("MD_CARE_PLAN_ID");
		int md_care_plan_id=Integer.parseInt(md_care_plan_id1);
		String care_plan_id1=(String)HeaderValue.get("CARE_PLAN_ID");
		int care_plan_id=Integer.parseInt(care_plan_id1);
		String patient_id=(String)HeaderValue.get("PATIENT_ID");
			encount_id				= 	(Long)	HeaderValue.get("ENCOUNTER_ID");
		encounter_id			=	encount_id.longValue();
		String care_mgr_id=(String)HeaderValue.get("CARE_MGR_ID");
		String added_by_id=(String)HeaderValue.get("ADDED_BY_ID");
		String added_facility_id=(String)HeaderValue.get("ADDED_FCY_ID");
		String added_at_ws_no=(String)HeaderValue.get("ADDED_AT_WS_NO");
		String locale=(String)HeaderValue.get("locale");
		String errorMsg			   ="";
		String diag_old_appl_yn="";
		String diag_new_appl_yn="";
		String termSet="";
		String termCode="";
		String goal_old_appln_yn="";
		String goal_new_appln_yn="";
		String goalCode="";
		String grpid="";
		int grpid1=0;
		String outcomeCode="";
		String outcome_old_appln_yn="";
		String outcome_new_appln_yn="";
		String IntvnCode="";
		String Intvn_old_appln_yn="";
		String Intvn_new_appln_yn="";
		String Intvn_old_new_status="";
		String Intvn_status="";
		String Intvn_type="";
		int Intvnreccount=0;
		int duration=0;
		int Intvnsrlno=0;
		String revise_id1="";
		String reviseidQuery="SELECT CP_CARE_PLAN_REVISION_SEQ.NEXTVAL REVISE_ID FROM DUAL";
		String sqlReviseInsert="";
		String sqlupdateCareplan="";
		String sqldiagnosisUpdate="UPDATE CP_PAT_CARE_PLAN_TERM_CODE  SET APPL_YN = 'N', STATUS = 'D',  REVISION_YN = 'Y', REVISION_ID = ?	WHERE MD_CARE_PLAN_ID = ?  AND CARE_PLAN_ID = ?  AND TERM_SET_ID = ?   AND TERM_CODE = ?";
		String sqlgoalUpdate="UPDATE CP_PAT_CARE_PLAN_GOAL SET APPL_YN = 'N', STATUS = 'D',REVISION_YN = 'Y', REVISION_ID = ?	 WHERE MD_CARE_PLAN_ID = ?  AND CARE_PLAN_ID = ?  AND TERM_SET_ID = ?  AND TERM_CODE = ?  AND GOAL_CODE = ? ";
		String sqlgoalUpdate1="UPDATE CP_PAT_CARE_PLAN_GOAL SET APPL_YN = 'Y', STATUS = 'O',REVISION_YN = 'Y', REVISION_ID = ?   WHERE MD_CARE_PLAN_ID = ?  AND CARE_PLAN_ID = ?  AND TERM_SET_ID = ? AND TERM_CODE = ?  AND GOAL_CODE = ?";
		String sqloutcomeUpdate="UPDATE CP_PAT_CARE_PLAN_OUTCOME  SET APPL_YN = 'N', STATUS = 'D', REVISION_YN = 'Y', REVISION_ID = ? WHERE MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ?  AND TERM_SET_ID = ? AND TERM_CODE = ?  AND  GOAL_CODE = ?   AND GROUP_ID = ?  AND OUTCOME_CODE = ?";
		String sqloutcomeUpdate1="UPDATE CP_PAT_CARE_PLAN_OUTCOME  SET APPL_YN = 'Y', STATUS = 'O',REVISION_YN = 'Y', REVISION_ID = ? WHERE MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ?  AND TERM_SET_ID = ? AND TERM_CODE = ?  AND GOAL_CODE = ? AND GROUP_ID = ?  AND OUTCOME_CODE = ?";
		String sqlIntvnUpdate="UPDATE CP_PAT_CARE_PLAN_INTVN SET APPL_YN = 'N', STATUS = 'D',REVISION_YN = 'Y', REVISION_ID = ? WHERE MD_CARE_PLAN_ID = ?  AND CARE_PLAN_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND GOAL_CODE = ? AND GROUP_ID = ? AND INTERVENTION_CODE = ?";
		String sqlIntvnreccount="SELECT COUNT(*) records FROM CP_PAT_CARE_PLAN_INTVN WHERE MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ? AND INTERVENTION_CODE=?";
		String sqlIntvnreccount1="SELECT COUNT(*)+1 SRL_NO FROM CP_PAT_CARE_PLAN_INTVN_DTL WHERE MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ? AND INTERVENTION_CODE = ?";
		String sqlIntvnUpdate1="UPDATE CP_PAT_CARE_PLAN_INTVN SET APPL_YN = 'Y', STATUS = 'O',REVISION_YN = 'Y', REVISION_ID = ? WHERE MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND GOAL_CODE = ?   AND GROUP_ID = ?  AND INTERVENTION_CODE = ?";
		String sqlIntvnUpdate2="UPDATE CP_PAT_CARE_PLAN_INTVN_DTL SET STATUS = 'V', STATUS_DATE = SYSDATE, REVISION_ID = ? WHERE MD_CARE_PLAN_ID = ?  AND CARE_PLAN_ID = ? AND INTERVENTION_CODE = ?  ";
		String sqlIntvnUpdate3="UPDATE CP_PAT_CARE_PLAN_INTVN_DTL SET STATUS = 'D' WHERE MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ? AND INTERVENTION_CODE = ? AND STATUS IN ('O','P')";

		String sqlIntvnInsert="INSERT INTO CP_PAT_CARE_PLAN_INTVN_DTL(MD_CARE_PLAN_ID, CARE_PLAN_ID, INTERVENTION_CODE, INTERVENTION_SRL_NO, PATIENT_ID, INTERVENTION_TYPE, FREQ_CODE, DURATION, DURN_TYPE, START_DATE, END_DATE, STATUS, STATUS_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,  REVISION_ID, POSITION_CODE, PRIORITY, STAGE_CODE) VALUES( ?,?,?,1,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),'O',SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?)";

		String sqlIntvnInsert1="INSERT INTO CP_PAT_CARE_PLAN_INTVN_DTL(MD_CARE_PLAN_ID, CARE_PLAN_ID, INTERVENTION_CODE, INTERVENTION_SRL_NO, PATIENT_ID, INTERVENTION_TYPE, FREQ_CODE, DURATION, DURN_TYPE, START_DATE, END_DATE, STATUS, STATUS_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,  REVISION_ID, POSITION_CODE, PRIORITY, STAGE_CODE) VALUES( ?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),'O',SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?)";
		String sqlIntvnmainInsert="INSERT INTO  CP_PAT_CARE_PLAN_INTVN(MD_CARE_PLAN_ID, CARE_PLAN_ID, TERM_SET_ID, TERM_CODE, TERM_CODE_SRL_NO, GOAL_CODE, INTERVENTION_CODE, PATIENT_ID, INTERVENTION_TYPE, REVISION_YN, REVISION_ID, STATUS, STATUS_DATE, REASON_CODE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, GOAL_SRL_NO, INTERVENTION_SRL_NO, GROUP_ID, APPL_YN) VALUES(?,?,?,?,1,?,?,?,?,'Y',?,'O',SYSDATE,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,1,1,?,'Y')";
		String sqlIntvnselect="Select Intervention_type from CA_INTERVENTION where INTERVENTION_CODE=?";
		String sqlTaskUpdate1="UPDATE CA_PAT_TASK_LIST SET STATUS = 'D',  STATUS_DATE = SYSDATE WHERE PATIENT_ID = ?  AND MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ?  AND TASK_CODE = ? AND STATUS IN ('O') ";
		String sqlTaskUpdate="UPDATE CA_PAT_TASK_LIST SET STATUS = 'D', STATUS_DATE = SYSDATE WHERE PATIENT_ID = ? AND MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ?  AND TASK_CODE = ? AND STATUS IN ('O') ";
		try
        {
			con = ConnectionManager.getConnection(properties);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			pstmtdiagUpdate = con.prepareStatement(sqldiagnosisUpdate);
			pstmtgoalUpdate = con.prepareStatement(sqlgoalUpdate);
			pstmtgoalUpdate1 = con.prepareStatement(sqlgoalUpdate1);
			pstmtoutcomeUpdate = con.prepareStatement(sqloutcomeUpdate);
			pstmtoutcomeUpdate1 = con.prepareStatement(sqloutcomeUpdate1);
			pstmtIntvnUpdate=con.prepareStatement(sqlIntvnUpdate);
			pstmtIntvnUpdate1=con.prepareStatement(sqlIntvnUpdate1);
			pstmtIntvnUpdate2=con.prepareStatement(sqlIntvnUpdate2);
			pstmtIntvnUpdate3=con.prepareStatement(sqlIntvnUpdate3);
			pstmtIntvnrecCount1=con.prepareStatement(sqlIntvnreccount1);
			pstmtIntvnrecCount=con.prepareStatement(sqlIntvnreccount);
			pstmtIntvnInsert=con.prepareStatement(sqlIntvnInsert);
			pstmtIntvnInsert1=con.prepareStatement(sqlIntvnInsert1);
			pstmtIntvnmainInsert=con.prepareStatement(sqlIntvnmainInsert);
			pstmtTaskUpdate=con.prepareStatement(sqlTaskUpdate);
			pstmtTaskUpdate1=con.prepareStatement(sqlTaskUpdate1);
			pstmtIntvnselect=con.prepareStatement(sqlIntvnselect);
			rs=stmt.executeQuery(reviseidQuery);
			if(rs!=null){
				rs.next();
				revise_id1=rs.getString("revise_id");
			}else
				result.add("revise_id -------");
			if(rs!=null) rs.close();
			int revise_id=Integer.parseInt(revise_id1);
			sqlReviseInsert="INSERT INTO CP_PAT_CARE_PLAN_REVISION(MD_CARE_PLAN_ID, CARE_PLAN_ID, REVISION_ID, REVISION_DATE,REVISION_FACILITY_ID, REVISION_ENCOUNTER_ID, PATIENT_ID, REVISION_PRACT_ID,REVISION_TYPE, REVISION_LEVEL, REVISION_REASON, REVISION_REMARKS,	ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values('"+md_care_plan_id+"','"+care_plan_id+"','"+revise_id1+"',SYSDATE,'"+added_facility_id+"','"+encounter_id+"','"+patient_id+"','"+care_mgr_id+"','R','PL','REVN',NULL,'"+added_by_id+"',SYSDATE,'"+added_at_ws_no+"','"+added_facility_id+"','"+added_by_id+"',SYSDATE,'"+added_at_ws_no+"','"+added_facility_id+"')";

			sqlupdateCareplan="UPDATE CP_PAT_CARE_PLAN SET LAST_REVISION_DATE_TIME = SYSDATE, LAST_REVISION_PRACT_ID = '"+care_mgr_id+"' WHERE MD_CARE_PLAN_ID ='"+md_care_plan_id+"'  AND CARE_PLAN_ID = '"+care_plan_id+"'";

			stmtrevise_insert = con.createStatement();

			int count=stmtrevise_insert.executeUpdate(sqlReviseInsert);
			if(count<=0)
				result.add("count:::::");
			int count1=stmtrevise_insert.executeUpdate(sqlupdateCareplan);
			if(count1<=0)
				result.add("count1::");
			for(int i=0;i<Diagnosis.size();i=i+11){
				termSet=(String)Diagnosis.get(i);
				termCode=(String)Diagnosis.get(i+1);
				diag_old_appl_yn=(String)Diagnosis.get(i+7);
				diag_new_appl_yn=(String)Diagnosis.get(i+8);
				if(diag_old_appl_yn.equals("Y")){
					if (diag_new_appl_yn.equals("N")){
						pstmtdiagUpdate.setInt(1,revise_id);
						pstmtdiagUpdate.setInt(2,md_care_plan_id);
						pstmtdiagUpdate.setInt(3,care_plan_id);
						pstmtdiagUpdate.setString(4,termSet);
						pstmtdiagUpdate.setString(5,termCode);
						pstmtdiagUpdate.executeUpdate();
						
					}
				}
			}

            if(pstmtdiagUpdate!=null)
				pstmtdiagUpdate.close();


			for(int i=0;i<Diagnosis.size();i=i+11){
				termSet=(String)Diagnosis.get(i);
				termCode=(String)Diagnosis.get(i+1);
				Goal=(ArrayList)Diagnosis.get(i+5);
				for(int j=0;j<Goal.size();j=j+6){
					goalCode=(String)Goal.get(j);
					goal_old_appln_yn=(String)Goal.get(j+4);
					goal_new_appln_yn=(String)Goal.get(j+5);
					if(goal_old_appln_yn.equals("Y")){
						if(goal_new_appln_yn.equals("N")){
							pstmtgoalUpdate.setInt(1,revise_id);
							pstmtgoalUpdate.setInt(2,md_care_plan_id);
							pstmtgoalUpdate.setInt(3,care_plan_id);
							pstmtgoalUpdate.setString(4,termSet);
							pstmtgoalUpdate.setString(5,termCode);
							pstmtgoalUpdate.setString(6,goalCode);
							pstmtgoalUpdate.executeUpdate();
							//if(pstmtgoalUpdate!=null) pstmtgoalUpdate.close();
						}
					}else{
						if(goal_new_appln_yn.equals("Y")){
							pstmtgoalUpdate1.setInt(1,revise_id);
							pstmtgoalUpdate1.setInt(2,md_care_plan_id);
							pstmtgoalUpdate1.setInt(3,care_plan_id);
							pstmtgoalUpdate1.setString(4,termSet);
							pstmtgoalUpdate1.setString(5,termCode);
							pstmtgoalUpdate1.setString(6,goalCode);
							pstmtgoalUpdate1.executeUpdate();
						}
					}
				}
			}

           if(pstmtgoalUpdate!=null){ 
			   pstmtgoalUpdate.close();
			   pstmtgoalUpdate=null;

		   }
		   if(pstmtgoalUpdate1!=null){ 
			   pstmtgoalUpdate1.close();
			   pstmtgoalUpdate1=null;
		   }




			for(int i=0;i<Diagnosis.size();i=i+11){
				termSet=(String)Diagnosis.get(i);
				termCode=(String)Diagnosis.get(i+1);
				Goal=(ArrayList)Diagnosis.get(i+5);
				for(int j=0;j<Goal.size();j=j+6){
					goalCode=(String)Goal.get(j);
					InterventionOutcome=(HashMap)Goal.get(j+2);
					Set itr_set			=	InterventionOutcome.keySet();
					Iterator recordItr		=	itr_set.iterator();
					while(recordItr.hasNext()){
						grpid="";
						grpid=(String)recordItr.next();
						grpid1=Integer.parseInt(grpid);
						IOGroup=(HashMap)InterventionOutcome.get(grpid);
						Intervention=(ArrayList)IOGroup.get("I");
						
						if(IOGroup.containsKey("O")){
							Outcome=(ArrayList)IOGroup.get("O");
							for(int k=0;k<Outcome.size();k=k+5){
								outcomeCode=(String)Outcome.get(k);
								outcome_old_appln_yn=(String)Outcome.get(k+3);
								outcome_new_appln_yn=(String)Outcome.get(k+4);
								if(outcome_old_appln_yn.equals("Y"))
								{
									if(outcome_new_appln_yn.equals("N")){
										pstmtoutcomeUpdate.setInt(1,revise_id);
										pstmtoutcomeUpdate.setInt(2,md_care_plan_id);
										pstmtoutcomeUpdate.setInt(3,care_plan_id);
										pstmtoutcomeUpdate.setString(4,termSet);
										pstmtoutcomeUpdate.setString(5,termCode);
										pstmtoutcomeUpdate.setString(6,goalCode);
										pstmtoutcomeUpdate.setInt(7,grpid1);
										pstmtoutcomeUpdate.setString(8,outcomeCode);
										pstmtoutcomeUpdate.executeUpdate();
									}
								}else{
									if(outcome_new_appln_yn.equals("Y")){
										pstmtoutcomeUpdate1.setInt(1,revise_id);
										pstmtoutcomeUpdate1.setInt(2,md_care_plan_id);
										pstmtoutcomeUpdate1.setInt(3,care_plan_id);
										pstmtoutcomeUpdate1.setString(4,termSet);
										pstmtoutcomeUpdate1.setString(5,termCode);
										pstmtoutcomeUpdate1.setString(6,goalCode);
										pstmtoutcomeUpdate1.setInt(7,grpid1);
										pstmtoutcomeUpdate1.setString(8,outcomeCode);
										pstmtoutcomeUpdate1.executeUpdate();
									}
								}
							}
						}




						for(int k=0;k<Intervention.size();k=k+6){
							IntvnCode=(String)Intervention.get(k);
							Intvn_old_appln_yn=(String)Intervention.get(k+3);
							Intvn_new_appln_yn=(String)Intervention.get(k+4);
							if(Intvn_old_appln_yn.equals("Y")){
								if(Intvn_new_appln_yn.equals("N")){
									pstmtIntvnUpdate.setInt(1,revise_id);
									pstmtIntvnUpdate.setInt(2,md_care_plan_id);
									pstmtIntvnUpdate.setInt(3,care_plan_id);
									pstmtIntvnUpdate.setString(4,termSet);
									pstmtIntvnUpdate.setString(5,termCode);
									pstmtIntvnUpdate.setString(6,goalCode);
									pstmtIntvnUpdate.setInt(7,grpid1);
									pstmtIntvnUpdate.setString(8,IntvnCode);
									pstmtIntvnUpdate.executeUpdate();
									pstmtIntvnrecCount.setInt(1,md_care_plan_id);
									pstmtIntvnrecCount.setInt(2,care_plan_id);
									pstmtIntvnrecCount.setString(3,IntvnCode);
									rs=pstmtIntvnrecCount.executeQuery();
									if(rs!=null){
										rs.next();
										Intvnreccount=rs.getInt("records");
										rs.close();
									}
									if(Intvnreccount>0){
										pstmtIntvnUpdate3.setInt(1,md_care_plan_id);
										pstmtIntvnUpdate3.setInt(2,care_plan_id);
										pstmtIntvnUpdate3.setString(3,IntvnCode);
										pstmtIntvnUpdate3.executeUpdate();
										pstmtTaskUpdate.setString(1,patient_id);
										pstmtTaskUpdate.setInt(2,md_care_plan_id);
										pstmtTaskUpdate.setInt(3,care_plan_id);
										pstmtTaskUpdate.setString(4,IntvnCode);
										pstmtTaskUpdate.executeUpdate();
									}
								}
							}else if(Intvn_old_appln_yn.equals("W")){
								if(Intvn_new_appln_yn.equals("Y")){
										pstmtIntvnselect.setString(1,IntvnCode);
										rs=pstmtIntvnselect.executeQuery();
										if(rs!=null){
											rs.next();
											Intvn_type=rs.getString("Intervention_type");
											rs.close();
										}
									pstmtIntvnmainInsert.setInt(1,md_care_plan_id);
									pstmtIntvnmainInsert.setInt(2,care_plan_id);
									pstmtIntvnmainInsert.setString(3,termSet);
									pstmtIntvnmainInsert.setString(4,termCode);
									pstmtIntvnmainInsert.setString(5,goalCode);
									pstmtIntvnmainInsert.setString(6,IntvnCode);
									pstmtIntvnmainInsert.setString(7,patient_id);
									pstmtIntvnmainInsert.setString(8,Intvn_type);
									pstmtIntvnmainInsert.setInt(9,revise_id);
									pstmtIntvnmainInsert.setString(10,"");
									pstmtIntvnmainInsert.setString(11,"");
									pstmtIntvnmainInsert.setString(12,added_by_id);
									pstmtIntvnmainInsert.setString(13,added_at_ws_no);
									pstmtIntvnmainInsert.setString(14,added_facility_id);
									pstmtIntvnmainInsert.setString(15,added_by_id);
									pstmtIntvnmainInsert.setString(16,added_at_ws_no);
									pstmtIntvnmainInsert.setString(17,added_facility_id);
									pstmtIntvnmainInsert.setInt(18,grpid1);	
									pstmtIntvnmainInsert.executeUpdate();
								}
							}else
								{
								if(Intvn_new_appln_yn.equals("Y")){
									pstmtIntvnUpdate1.setInt(1,revise_id);
									pstmtIntvnUpdate1.setInt(2,md_care_plan_id);
									pstmtIntvnUpdate1.setInt(3,care_plan_id);
									pstmtIntvnUpdate1.setString(4,termSet);
									pstmtIntvnUpdate1.setString(5,termCode);
									pstmtIntvnUpdate1.setString(6,goalCode);
									pstmtIntvnUpdate1.setInt(7,grpid1);
									pstmtIntvnUpdate1.setString(8,IntvnCode);
									pstmtIntvnUpdate1.executeUpdate();
								}
							}
						}
					}
				}
			}
//=========================================================================================
			Set itr_set1			=	Intvn.keySet();
			Iterator recordItr1		=	itr_set1.iterator();
			String revise_yn		=   "";
			while(recordItr1.hasNext()){
				IntvnCode="";
				IntvnCode=(String)recordItr1.next();
				IntvnList=(ArrayList)Intvn.get(IntvnCode);
				Intvn_old_new_status=(String)IntvnList.get(1);
				Intvn_status=(String)IntvnList.get(3);
				duration=Integer.parseInt((String)IntvnList.get(6));
				revise_yn			=(String)IntvnList.get(13);


              if(revise_yn.equals("Y")){ 
				if(Intvn_status.equals("Y")){
					if(Intvn_old_new_status.equals("N")){
						pstmtIntvnInsert.setInt(1,md_care_plan_id);
						pstmtIntvnInsert.setInt(2,care_plan_id);
						pstmtIntvnInsert.setString(3,IntvnCode);
						pstmtIntvnInsert.setString(4,patient_id);
						pstmtIntvnInsert.setString(5,(String)IntvnList.get(12));
						pstmtIntvnInsert.setString(6,(String)IntvnList.get(5));
						pstmtIntvnInsert.setInt(7,duration);
						pstmtIntvnInsert.setString(8,(String)IntvnList.get(7));
						pstmtIntvnInsert.setString(9,(String)IntvnList.get(4));
						pstmtIntvnInsert.setString(10,(String)IntvnList.get(8));
						pstmtIntvnInsert.setString(11,added_by_id);
						pstmtIntvnInsert.setString(12,added_at_ws_no);
						pstmtIntvnInsert.setString(13,added_facility_id);
						pstmtIntvnInsert.setString(14,added_by_id);
						pstmtIntvnInsert.setString(15,added_at_ws_no);
						pstmtIntvnInsert.setString(16,added_facility_id);
						pstmtIntvnInsert.setInt(17,revise_id);
						pstmtIntvnInsert.setString(18,(String)IntvnList.get(11));
						pstmtIntvnInsert.setString(19,(String)IntvnList.get(10));
						pstmtIntvnInsert.setString(20,(String)IntvnList.get(9));
						pstmtIntvnInsert.executeUpdate();
					}else{
						pstmtIntvnUpdate2.setInt(1,revise_id);
						pstmtIntvnUpdate2.setInt(2,md_care_plan_id);
						pstmtIntvnUpdate2.setInt(3,care_plan_id);
						pstmtIntvnUpdate2.setString(4,IntvnCode);
						pstmtIntvnUpdate2.executeUpdate();
						pstmtTaskUpdate1.setString(1,patient_id);
						pstmtTaskUpdate1.setInt(2,md_care_plan_id);
						pstmtTaskUpdate1.setInt(3,care_plan_id);
						pstmtTaskUpdate1.setString(4,IntvnCode);
						try{
						pstmtTaskUpdate1.executeUpdate();
						}catch(Exception e){
							System.err.println("taskcount 3:::"+e.toString());
							e.printStackTrace();
						}
						pstmtIntvnrecCount1.setInt(1,md_care_plan_id);
						pstmtIntvnrecCount1.setInt(2,care_plan_id);
						pstmtIntvnrecCount1.setString(3,IntvnCode);
						rs=pstmtIntvnrecCount1.executeQuery();
						if(rs!=null){
							rs.next();
							Intvnsrlno=rs.getInt("SRL_NO");
							rs.close();
						}
						pstmtIntvnInsert1.setInt(1,md_care_plan_id);
						pstmtIntvnInsert1.setInt(2,care_plan_id);
						pstmtIntvnInsert1.setString(3,IntvnCode);
						pstmtIntvnInsert1.setInt(4,Intvnsrlno);
						pstmtIntvnInsert1.setString(5,patient_id);
						pstmtIntvnInsert1.setString(6,(String)IntvnList.get(12));
						pstmtIntvnInsert1.setString(7,(String)IntvnList.get(5));
						pstmtIntvnInsert1.setInt(8,duration);
						pstmtIntvnInsert1.setString(9,(String)IntvnList.get(7));
						pstmtIntvnInsert1.setString(10,(String)IntvnList.get(4));
						pstmtIntvnInsert1.setString(11,(String)IntvnList.get(8));
						pstmtIntvnInsert1.setString(12,added_by_id);
						pstmtIntvnInsert1.setString(13,added_at_ws_no);
						pstmtIntvnInsert1.setString(14,added_facility_id);
						pstmtIntvnInsert1.setString(15,added_by_id);
						pstmtIntvnInsert1.setString(16,added_at_ws_no);
						pstmtIntvnInsert1.setString(17,added_facility_id);
						pstmtIntvnInsert1.setInt(18,revise_id);
						pstmtIntvnInsert1.setString(19,(String)IntvnList.get(11));
						pstmtIntvnInsert1.setString(20,(String)IntvnList.get(10));
						pstmtIntvnInsert1.setString(21,(String)IntvnList.get(9));
						try{
						pstmtIntvnInsert1.executeUpdate();
						}catch(Exception e){
							System.err.println("IntvnCount in insert failed---"+e.toString());
							e.printStackTrace();

						}
					}
				}
			} 

			}

			clblstmt_gen_taskList=con.prepareCall("{call CP_POST_TASK_LIST  ( ?,?,?,?,?,?,?)}");
			clblstmt_gen_taskList.setString( 1,added_facility_id);
			clblstmt_gen_taskList.setLong( 2,encounter_id);
			clblstmt_gen_taskList.setString(3,patient_id);
			clblstmt_gen_taskList.setInt(4,md_care_plan_id);
			clblstmt_gen_taskList.setInt(5,care_plan_id);
			clblstmt_gen_taskList.registerOutParameter(6, Types.VARCHAR );
			clblstmt_gen_taskList.setInt(7,revise_id);
			try{
			clblstmt_gen_taskList.execute();
			if(clblstmt_gen_taskList!=null) clblstmt_gen_taskList.close();
			}catch(Exception e){
				if(clblstmt_gen_taskList!=null) clblstmt_gen_taskList.close();
				System.err.println("Exception in procedure::"+e.toString());
				e.printStackTrace();
			}

			if(result.size()>0){
				con.rollback();
				errorMsg= "Operation failure ...";
				map.put( "status", new Boolean( false) ) ;
				map.put("error",errorMsg);
			}else{

				Hashtable errdata		 = MessageManager.getMessage(locale,"RECORD_INSERTED","CP");
				errorMsg	 = (String) errdata.get("message");
				map.put( "status", new Boolean( true) ) ;
				map.put("error",errorMsg);
				con.commit();
			}
			if(stmtrevise_insert != null){
						stmtrevise_insert.close();
					}
					if(pstmtdiagUpdate != null){
						pstmtdiagUpdate.close();
					}
					if(pstmtgoalUpdate != null){
						pstmtgoalUpdate.close();
					}
					if(pstmtgoalUpdate1 != null){
						pstmtgoalUpdate1.close();
					}
					if(pstmtoutcomeUpdate != null){
						pstmtoutcomeUpdate.close();

					}
					if(pstmtoutcomeUpdate1 != null){
						pstmtoutcomeUpdate1.close();
					}
					if(pstmtIntvnUpdate != null){
						pstmtIntvnUpdate.close();
					}
					if(pstmtIntvnUpdate1 != null){
						pstmtIntvnUpdate1.close();
					}
					if(pstmtIntvnUpdate2 != null){
						pstmtIntvnUpdate2.close();
					}
					if(pstmtIntvnUpdate3 != null){
						pstmtIntvnUpdate3.close();
					}
					if(pstmtIntvnrecCount != null){
						pstmtIntvnrecCount.close();
					}
					if(pstmtIntvnrecCount1 != null){
						pstmtIntvnrecCount1.close();
					}
					if(pstmtIntvnInsert != null){
						pstmtIntvnInsert.close();
					}
					if(pstmtIntvnInsert1 != null){
						pstmtIntvnInsert1.close();
					}
					if(pstmtTaskUpdate != null){
						pstmtTaskUpdate.close();
					}
					if(pstmtTaskUpdate1 != null){
						pstmtTaskUpdate1.close();
					}
					if(pstmtIntvnmainInsert != null){
						pstmtIntvnmainInsert.close();
					}
					if(pstmtIntvnselect != null){
						pstmtIntvnselect.close();
					}
					if(stmt !=null){
						stmt.close();
					}
			 if(con != null)
			            ConnectionManager.returnConnection(con, properties);
		}
		catch(Exception exception){
			try{
				con.rollback();
			}catch(Exception e){
				System.err.println(e.toString());
			}
			System.err.println(exception.toString());
			exception.printStackTrace();
		}
	    finally{
		    if(con != null)
			    try{
					if(stmtrevise_insert != null){
						stmtrevise_insert.close();
						//stmtrevise_insert=null;
					}
					if(pstmtdiagUpdate != null){
						pstmtdiagUpdate.close();
						//pstmtdiagUpdate=null;
					}
					if(pstmtgoalUpdate != null){
						pstmtgoalUpdate.close();
						//pstmtgoalUpdate=null;
					}
					if(pstmtgoalUpdate1 != null){
						pstmtgoalUpdate1.close();
						//pstmtgoalUpdate1=null;
					}
					if(pstmtoutcomeUpdate != null){
						pstmtoutcomeUpdate.close();
						//pstmtoutcomeUpdate=null;

					}
					if(pstmtoutcomeUpdate1 != null){
						pstmtoutcomeUpdate1.close();
						//pstmtoutcomeUpdate1=null;
					}
					if(pstmtIntvnUpdate != null){
						pstmtIntvnUpdate.close();
						//pstmtIntvnUpdate=null;
					}
					if(pstmtIntvnUpdate1 != null){
						pstmtIntvnUpdate1.close();
						//pstmtIntvnUpdate1=null;
					}
					if(pstmtIntvnUpdate2 != null){
						pstmtIntvnUpdate2.close();
						//pstmtIntvnUpdate2=null;
					}
					if(pstmtIntvnUpdate3 != null){
						pstmtIntvnUpdate3.close();
						//pstmtIntvnUpdate3=null;
					}
					if(pstmtIntvnrecCount != null){
						pstmtIntvnrecCount.close();
						//pstmtIntvnrecCount=null;
					}
					if(pstmtIntvnrecCount1 != null){
						pstmtIntvnrecCount1.close();
						//pstmtIntvnrecCount1=null;
					}
					if(pstmtIntvnInsert != null){
						pstmtIntvnInsert.close();
						//pstmtIntvnInsert=null;
					}
					if(pstmtIntvnInsert1 != null){
						pstmtIntvnInsert1.close();
						//pstmtIntvnInsert1=null;
					}
					if(pstmtTaskUpdate != null){
						pstmtTaskUpdate.close();
						//pstmtTaskUpdate=null;
					}
					if(pstmtTaskUpdate1 != null){
						pstmtTaskUpdate1.close();
						//pstmtTaskUpdate1=null;
					}
					if(stmt !=null){
						stmt.close();
						//stmt=null;
					}

			         if(con != null)
			            ConnectionManager.returnConnection(con, properties);
					}catch(Exception exception2) {
						exception2.printStackTrace();
					}
        }
		return map;
	}
}
