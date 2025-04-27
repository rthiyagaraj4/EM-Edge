/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.BuildLibrary;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="BuildLibrary"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="BuildLibrary"
*	local-jndi-name="BuildLibrary"
*	impl-class-name="eCP.BuildLibrary.BuildLibraryManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.BuildLibrary.BuildLibraryLocal"
*	remote-class="eCP.BuildLibrary.BuildLibraryRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.BuildLibrary.BuildLibraryLocalHome"
*	remote-class="eCP.BuildLibrary.BuildLibraryHome"
*	generate= "local,remote"
*
*
*/
public class BuildLibraryManager
    implements SessionBean
{

	Connection con;
    PreparedStatement pstmtTermcode;
	PreparedStatement deletepstmtTermcode;	
	PreparedStatement pstmtGoal;
	PreparedStatement deletepstmtGoal;
	PreparedStatement updatepstmtGoal;
	PreparedStatement pstmtIntervention;
	PreparedStatement deletepstmtIntervention;
	PreparedStatement updatepstmtIntervention;
	PreparedStatement pstmtOutcome;
	PreparedStatement deletepstmtOutcome;
	PreparedStatement updatepstmtOutcome;
	ResultSet rs;
	StringBuffer stringbuffer = new StringBuffer();

    public BuildLibraryManager()
    {
       
    }

    public void ejbCreate()
        throws  CreateException
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
    public HashMap AddModify(Properties properties, HashMap hashtable)
    {
		HashMap map=new HashMap();
		stringbuffer = new StringBuffer();
		String  msg="";
		int Status=0;

		String termSet="";
		String termCode="";
		
		//System.err.println("Hashtable"+hashtable);
		HashMap HeaderValue    					 =		null;
		ArrayList TermCodeList					 =		null;
		ArrayList result						 =		new ArrayList();
		String termcodeStatus					 =		"";
		String termcodeFlag						 =		"";
		int termcodeinsertresult				 =		0;
		int termcodecount						 =		0;
		ArrayList Goal							 =		null;
		String goalCode							 =		"";
		String goalStatus						 =		"";
		String goalFlag							 =		"";
		int goalTargetPeriod					 =      0;
		int goalResult							 =		0;
		int goalcount							 =		0;
		HashMap InterventionOutcome				 =		null;
		ArrayList Intervention					 =		null;
		String interventionCode					 =		"";
		String interventionStatus				 =		"";
		String interventionFlag					 =		"";
		int interventionSeqno					 =		0;
		int interventionGrpno					 =		0;
		int interventionrelStart				 =		0;
		int interventionduration				 =		0;
		int interventiondependency				 =      1;
		int interventionResult					 =		0;
		int interventiondeleteresult			 =		0;
		int interventioncount					 =		0;
		ArrayList Outcome						 =		null;	
		String outcomeCode						 =		"";
		String outcomeStatus					 =		"";
		String outcomeFlag						 =		"";
		int outcomeResult						 =		0;
		int outcomedeleteresult					 =		0;
		int outcomecount						 =		0;


		HeaderValue								=	(HashMap)hashtable.get("HV");
		TermCodeList							=	(ArrayList)hashtable.get("TC");
		String libraryid						=	(String)HeaderValue.get("LIBRARYID");
		String versionno1						=	(String)HeaderValue.get("VERSIONNO");
		int versionno							=	Integer.parseInt(versionno1);
		String added_by_id						=	(String)HeaderValue.get("ADDED_BY_ID");
		String added_facility_id				=	(String)HeaderValue.get("ADDED_FCY_ID");
		String added_at_ws_no					=	(String)HeaderValue.get("ADDED_AT_WS_NO");
		String locale=(String)HeaderValue.get("locale")==null?"en":(String)HeaderValue.get("locale");
		String InsertTermCodeQuery="INSERT INTO CP_LIBRARY_TERM_CODE(LIBRARY_ID,VERSION_NO,TERM_SET_ID,TERM_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		String DeleteTermCodeQuery="DELETE FROM CP_LIBRARY_TERM_CODE WHERE LIBRARY_ID=? AND VERSION_NO=? AND TERM_SET_ID=? AND TERM_CODE=?";
		//String UpdateTermCodeQuery="UPDATE CP_LIBRARY_TERM_CODE SET ";
		String InsertGoalQuery="INSERT INTO CP_LIBRARY_GOAL(LIBRARY_ID,VERSION_NO,TERM_SET_ID,TERM_CODE,GOAL_CODE,GOAL_TARGET_DURN,GOAL_TARGET_DURN_UNIT,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,PRACT_TYPE) VALUES (?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
		String	DeleteGoalQuery="DELETE FROM CP_LIBRARY_GOAL WHERE LIBRARY_ID=? AND VERSION_NO=? AND TERM_SET_ID=? AND TERM_CODE=? AND GOAL_CODE=?";
		String UpdateGoalQuery="UPDATE CP_LIBRARY_GOAL SET GOAL_TARGET_DURN =?,GOAL_TARGET_DURN_UNIT=?,PRACT_TYPE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE LIBRARY_ID=? AND VERSION_NO=? AND TERM_SET_ID=? AND TERM_CODE=? AND GOAL_CODE=?";
		String InsertInterventionQuery="INSERT INTO CP_LIBRARY_INTERVENTION(LIBRARY_ID,VERSION_NO,TERM_SET_ID,TERM_CODE,GOAL_CODE,INTERVENTION_CODE,ACCURACY_INDICATOR,INTERVENTION_TYPE,SEQ_NO,GROUP_ID,REL_START_PERIOD,REL_START_PERIOD_UNIT,FREQ_CODE,FREQ_DURN,FREQ_DURN_UNIT,DEPENDENCY_LEVEL,ALT_INTERVENTION_CODE,STAGE_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		String DeleteInterventionQuery="DELETE FROM CP_LIBRARY_INTERVENTION WHERE LIBRARY_ID=? AND VERSION_NO=? AND TERM_SET_ID=? AND TERM_CODE=? AND GOAL_CODE=? AND INTERVENTION_CODE=?";
		String UpdateInterventionQuery="UPDATE CP_LIBRARY_INTERVENTION SET  ACCURACY_INDICATOR=?,INTERVENTION_TYPE=?,SEQ_NO=?,GROUP_ID=?,REL_START_PERIOD=?,REL_START_PERIOD_UNIT=?,FREQ_CODE=?,FREQ_DURN=?,FREQ_DURN_UNIT=?,DEPENDENCY_LEVEL=?,ALT_INTERVENTION_CODE=?,STAGE_CODE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE LIBRARY_ID=? AND VERSION_NO=? AND TERM_SET_ID=? AND TERM_CODE=? AND GOAL_CODE=? AND INTERVENTION_CODE=?";
		String InsertOutcomeQuery="INSERT INTO CP_LIBRARY_OUTCOME(LIBRARY_ID,VERSION_NO,TERM_SET_ID,TERM_CODE,GOAL_CODE,OUTCOME_CODE,GROUP_ID,OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		String DeleteOutcomeQuery="DELETE FROM CP_LIBRARY_OUTCOME WHERE LIBRARY_ID=? AND VERSION_NO=? AND TERM_SET_ID=? AND TERM_CODE=? AND GOAL_CODE=? AND OUTCOME_CODE=?";
		String UpdateOutcomeQuery="UPDATE CP_LIBRARY_OUTCOME SET GROUP_ID=?,OUTCOME_TARGET_DURN=?,OUTCOME_TARGET_DURN_UNIT=?,APPL_NATURE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE LIBRARY_ID=? AND VERSION_NO=? AND TERM_SET_ID=? AND TERM_CODE=? AND GOAL_CODE=? AND OUTCOME_CODE=? ";
		try
        {
			
			con = ConnectionManager.getConnection(properties);
			con.setAutoCommit(false);

			pstmtTermcode			=	con.prepareStatement(InsertTermCodeQuery);
			pstmtGoal				=	con.prepareStatement(InsertGoalQuery);
			pstmtIntervention		=	con.prepareStatement(InsertInterventionQuery);
			pstmtOutcome			=	con.prepareStatement(InsertOutcomeQuery);
			deletepstmtIntervention	=	con.prepareStatement(DeleteInterventionQuery);
			deletepstmtOutcome		=	con.prepareStatement(DeleteOutcomeQuery);
			deletepstmtGoal			=	con.prepareStatement(DeleteGoalQuery);
			deletepstmtTermcode		=	con.prepareStatement(DeleteTermCodeQuery);
			updatepstmtIntervention =	con.prepareStatement(UpdateInterventionQuery);
			updatepstmtOutcome		=	con.prepareStatement(UpdateOutcomeQuery);

					
			for(int i=0;i<TermCodeList.size();i=i+7){
				termSet=(String)TermCodeList.get(i);
				termCode=(String)TermCodeList.get(i+1);
				Goal=(ArrayList)TermCodeList.get(i+2);
				termcodeStatus=(String)TermCodeList.get(i+3);
				termcodeFlag=(String)TermCodeList.get(i+4);

				if(termcodeStatus.equals("Y") && termcodeFlag.equals("I")){
					//pstmtTermcode = con.prepareStatement(InsertTermCodeQuery);
					pstmtTermcode.setString(1,libraryid);
					pstmtTermcode.setInt(2,versionno);
					pstmtTermcode.setString(3,(String)TermCodeList.get(i));
					pstmtTermcode.setString(4,(String)TermCodeList.get(i+1));
					pstmtTermcode.setString(5,added_by_id);
					pstmtTermcode.setString(6,added_at_ws_no);
					pstmtTermcode.setString(7,added_facility_id);
					pstmtTermcode.setString(8,added_by_id);
					pstmtTermcode.setString(9,added_at_ws_no);
					pstmtTermcode.setString(10,added_facility_id);
					termcodeinsertresult=pstmtTermcode.executeUpdate();
				/*	if(pstmtTermcode != null){
						pstmtTermcode.close();
						pstmtTermcode=null;
					}*/
					if(termcodeinsertresult==1){
						for(int j=0;j<Goal.size();j=j+9){
							goalStatus=(String)Goal.get(j+4);
							goalFlag=(String)Goal.get(j+5);
							goalCode=(String)Goal.get(j);
							if(goalStatus.equals("Y") && goalFlag.equals("I")){	
								//pstmtGoal = con.prepareStatement(InsertGoalQuery);
								if(!((String)Goal.get(j+1)).equals(""))
									goalTargetPeriod=Integer.parseInt((String)Goal.get(j+1));
								pstmtGoal.setString(1,libraryid);
								pstmtGoal.setInt(2,versionno);
								pstmtGoal.setString(3,termSet);
								pstmtGoal.setString(4,termCode);
								pstmtGoal.setString(5,goalCode);
								pstmtGoal.setInt(6,goalTargetPeriod);
								pstmtGoal.setString(7,(String)Goal.get(j+2));
								pstmtGoal.setString(8,added_by_id);
								pstmtGoal.setString(9,added_at_ws_no);
								pstmtGoal.setString(10,added_facility_id);
								pstmtGoal.setString(11,added_by_id);
								pstmtGoal.setString(12,added_at_ws_no);
								pstmtGoal.setString(13,added_facility_id);
								pstmtGoal.setString(14,(String)Goal.get(j+8));
								goalcount=pstmtGoal.executeUpdate();
								/*if(pstmtGoal != null)
								pstmtGoal.close();*/
								if(goalcount==1){
									result.add("1");
									goalResult=1;
								}else{
									result.add("0");
									//pstmtGoal.cancel();
									con.rollback();
									throw new EJBException("Goal table insertion failed");
								}
							}
							goalTargetPeriod=0;
						}

                   /*    if(pstmtGoal != null){
						if(pstmtTermcode != null){
							pstmtTermcode.close();
						}
						pstmtGoal=null;
					   }*/
					}			
					if(goalResult==1){
						for(int j=0;j<Goal.size();j=j+9){
							InterventionOutcome=(HashMap)Goal.get(j+3);
							Intervention=(ArrayList)InterventionOutcome.get("I");
							Outcome=(ArrayList)InterventionOutcome.get("O");
							for(int k=0;k<Intervention.size();k=k+13){
								interventionStatus=(String)Intervention.get(k+10);
								interventionFlag=(String)Intervention.get(k+11);
								if(!((String)Intervention.get(k+1)).equals(""))
									interventionGrpno		 =	Integer.parseInt((String)Intervention.get(k+1));	
								else
									interventionGrpno		 =  1;
								if(interventionStatus.equals("Y") && interventionFlag.equals("I")){
									//pstmtIntervention = con.prepareStatement(InsertInterventionQuery);
									interventionSeqno		 =	0;
									if(!((String)Intervention.get(k+3)).equals(""))
										interventionrelStart	 =	Integer.parseInt((String)Intervention.get(k+3));	
									if(!((String)Intervention.get(k+6)).equals(""))
										interventionduration	 =	Integer.parseInt((String)Intervention.get(k+6));	
									if(!((String)Intervention.get(k+8)).equals(""))
										interventiondependency	 =  Integer.parseInt((String)Intervention.get(k+8));  
									else
										interventiondependency   =  1;
									pstmtIntervention.setString(1,libraryid);
									pstmtIntervention.setInt(2,versionno);
									pstmtIntervention.setString(3,termSet);
									pstmtIntervention.setString(4,termCode);
									pstmtIntervention.setString(5,(String)Goal.get(j));
									pstmtIntervention.setString(6,(String)Intervention.get(k));
									pstmtIntervention.setString(7,"C");
									pstmtIntervention.setString(8,"I");
									pstmtIntervention.setInt(9,interventionSeqno);
									pstmtIntervention.setInt(10,interventionGrpno);
									pstmtIntervention.setInt(11,interventionrelStart);
									pstmtIntervention.setString(12,(String)Intervention.get(k+4));
									pstmtIntervention.setString(13,(String)Intervention.get(k+5));
									pstmtIntervention.setInt(14,interventionduration);
									pstmtIntervention.setString(15,(String)Intervention.get(k+7));
									pstmtIntervention.setInt(16,interventiondependency);
									pstmtIntervention.setString(17,(String)Intervention.get(k+2));
									pstmtIntervention.setString(18,(String)Intervention.get(k+9));
									pstmtIntervention.setString(19,added_by_id);
									pstmtIntervention.setString(20,added_at_ws_no);
									pstmtIntervention.setString(21,added_facility_id);
									pstmtIntervention.setString(22,added_by_id);
									pstmtIntervention.setString(23,added_at_ws_no);
									pstmtIntervention.setString(24,added_facility_id);
									interventioncount=pstmtIntervention.executeUpdate();
									if(interventioncount==1)
										result.add("1");
									else{ 
										result.add("0");
										//pstmtIntervention.cancel();
										con.rollback();
										throw new EJBException("Intervention table insertion failed");											
									}
								}
								interventionrelStart=0;
								interventionduration=0;
								interventiondependency=1;

							/* if(pstmtIntervention != null){
								pstmtIntervention.close();
								pstmtIntervention=null;
							  }	*/
							}
							for(int k=0;k<Outcome.size();k=k+8){
								outcomeStatus=(String)Outcome.get(k+5);
								outcomeFlag=(String)Outcome.get(k+6);
								if(outcomeStatus.equals("Y") && outcomeFlag.equals("I")){
									//pstmtOutcome = con.prepareStatement(InsertOutcomeQuery);
									pstmtOutcome.setString(1,libraryid);
									pstmtOutcome.setInt(2,versionno);
									pstmtOutcome.setString(3,termSet);
									pstmtOutcome.setString(4,termCode);
									pstmtOutcome.setString(5,(String)Goal.get(j));
									pstmtOutcome.setString(6,(String)Outcome.get(k));
									pstmtOutcome.setString(7,(String)Outcome.get(k+1));
									pstmtOutcome.setString(8,(String)Outcome.get(k+3));
									pstmtOutcome.setString(9,(String)Outcome.get(k+4));
									pstmtOutcome.setString(10,(String)Outcome.get(k+2));
									pstmtOutcome.setString(11,added_by_id);
									pstmtOutcome.setString(12,added_at_ws_no);
									pstmtOutcome.setString(13,added_facility_id);
									pstmtOutcome.setString(14,added_by_id);
									pstmtOutcome.setString(15,added_at_ws_no);
									pstmtOutcome.setString(16,added_facility_id);
									outcomecount=pstmtOutcome.executeUpdate();
									/*if(pstmtOutcome != null)
										pstmtOutcome.close();*/
									if(outcomecount==1)
										result.add("1");
									else{
										result.add("0");
										//pstmtOutcome.cancel();
										con.rollback();
										throw new EJBException("Outcome table insertion failed");
									}
								}
								/*if(pstmtOutcome != null){
									pstmtOutcome.close();
									pstmtOutcome=null;
							    }	*/
							}
						}
					}
				}else if(termcodeStatus.equals("N") && termcodeFlag.equals("U")){
					if(Goal.size()>0){
						for(int j=0;j<Goal.size();j=j+9){
							goalCode=(String)Goal.get(j);
							InterventionOutcome=(HashMap)Goal.get(j+3);
							Intervention=(ArrayList)InterventionOutcome.get("I");
							Outcome=(ArrayList)InterventionOutcome.get("O");
							if(Intervention.size()>0){
								for(int k=0;k<Intervention.size();k=k+13){
									//deletepstmtIntervention=con.prepareStatement(DeleteInterventionQuery);
									interventionCode=(String)Intervention.get(k);
									deletepstmtIntervention.setString(1,libraryid);
									deletepstmtIntervention.setInt(2,versionno);
									deletepstmtIntervention.setString(3,(String)TermCodeList.get(i));
									deletepstmtIntervention.setString(4,(String)TermCodeList.get(i+1));
									deletepstmtIntervention.setString(5,goalCode);
									deletepstmtIntervention.setString(6,interventionCode);
									interventioncount=deletepstmtIntervention.executeUpdate();
									/*if(deletepstmtIntervention != null)
										deletepstmtIntervention.close();*/
									if(interventioncount >=1){
										result.add("1");
										interventionResult=1;
									}else{
										result.add("0");
										//deletepstmtIntervention.cancel();
										con.rollback();
										throw new EJBException("Intervention table deletion failed");		
									}
								}
								/*if(deletepstmtIntervention != null){
									deletepstmtIntervention.close();
									deletepstmtIntervention=null;
							    }	*/

							}
							if(Outcome.size()>0){
								for(int k=0;k<Outcome.size();k=k+8){							
									//deletepstmtOutcome=con.prepareStatement(DeleteOutcomeQuery);
									outcomeCode=(String)Outcome.get(k);								
									deletepstmtOutcome.setString(1,libraryid);
									deletepstmtOutcome.setInt(2,versionno);
									deletepstmtOutcome.setString(3,(String)TermCodeList.get(i));
									deletepstmtOutcome.setString(4,(String)TermCodeList.get(i+1));
									deletepstmtOutcome.setString(5,goalCode);
									deletepstmtOutcome.setString(6,outcomeCode);
									outcomecount=deletepstmtOutcome.executeUpdate();
								//	if(deletepstmtOutcome != null) deletepstmtOutcome.close();
									if(outcomecount >=1){
										result.add("1");
										outcomeResult=1;
									}else{
										result.add("0");
										//deletepstmtOutcome.cancel();
										con.rollback();
										throw new EJBException("Outcome table deletion failed");
									}
								}

								/*if(deletepstmtOutcome != null){
									deletepstmtOutcome.close();
									deletepstmtOutcome=null;
							    }	*/
							}
							if(interventionResult==1 && outcomeResult==1){
								//deletepstmtGoal=con.prepareStatement(DeleteGoalQuery);
								deletepstmtGoal.setString(1,libraryid);
								deletepstmtGoal.setInt(2,versionno);
								deletepstmtGoal.setString(3,(String)TermCodeList.get(i));
								deletepstmtGoal.setString(4,(String)TermCodeList.get(i+1));
								deletepstmtGoal.setString(5,goalCode);
								goalcount=deletepstmtGoal.executeUpdate();
							/*	if(deletepstmtGoal != null){
								  deletepstmtGoal.close();
								}*/
								if(goalcount ==1){
									result.add("1");
									goalResult=1;
								}else{
									result.add("0");
								//	deletepstmtGoal.cancel();
									con.rollback();
									throw new EJBException("Goal table deletion failed");
								}
							}
						}
					}
					if(goalResult==1){
						//deletepstmtTermcode=con.prepareStatement(DeleteTermCodeQuery);
						deletepstmtTermcode.setString(1,libraryid);
						deletepstmtTermcode.setInt(2,versionno);
						deletepstmtTermcode.setString(3,(String)TermCodeList.get(i));
						deletepstmtTermcode.setString(4,(String)TermCodeList.get(i+1));
						termcodecount=deletepstmtTermcode.executeUpdate();
					/*	if(deletepstmtTermcode != null){
							deletepstmtTermcode.close();
							deletepstmtTermcode=null;
						}*/
						if(termcodecount==1){
							result.add("1");
						}else{
							result.add("0");
							//deletepstmtTermcode.cancel();
							con.rollback();
							throw new EJBException("Termcode table deletion failed");
						}
					}

				}else if(termcodeStatus.equals("Y") && termcodeFlag.equals("U")){
					for(int j=0;j<Goal.size();j=j+9){
						goalCode=(String)Goal.get(j);
						goalStatus=(String)Goal.get(j+4);
						goalFlag=(String)Goal.get(j+5);
						if(goalStatus.equals("Y") && goalFlag.equals("I")){
							//pstmtGoal = con.prepareStatement(InsertGoalQuery);
							if(!((String)Goal.get(j+1)).equals(""))
								goalTargetPeriod=Integer.parseInt((String)Goal.get(j+1));
							pstmtGoal.setString(1,libraryid);
							pstmtGoal.setInt(2,versionno);
							pstmtGoal.setString(3,termSet);
							pstmtGoal.setString(4,termCode);
							pstmtGoal.setString(5,goalCode);
							pstmtGoal.setInt(6,goalTargetPeriod);
							pstmtGoal.setString(7,(String)Goal.get(j+2));
							pstmtGoal.setString(8,added_by_id);
							pstmtGoal.setString(9,added_at_ws_no);
							pstmtGoal.setString(10,added_facility_id);
							pstmtGoal.setString(11,added_by_id);
							pstmtGoal.setString(12,added_at_ws_no);
							pstmtGoal.setString(13,added_facility_id);
							pstmtGoal.setString(14,(String)Goal.get(j+8));
							goalcount=pstmtGoal.executeUpdate();
							if(goalcount==1){
								result.add("1");
							}else{
								result.add("0");
								//pstmtGoal.cancel();
								con.rollback();
								throw new EJBException("Goal table Insertion failed");
							}


						/*	if(pstmtGoal != null){
									pstmtGoal.close();
							}*/
							InterventionOutcome=(HashMap)Goal.get(j+3);
							Intervention=(ArrayList)InterventionOutcome.get("I");
							Outcome=(ArrayList)InterventionOutcome.get("O");

							for(int k=0;k<Intervention.size();k=k+13){
									interventionStatus=(String)Intervention.get(k+10);
									interventionFlag=(String)Intervention.get(k+11);
									if(interventionStatus.equals("Y") && interventionFlag.equals("I")){
										//pstmtIntervention = con.prepareStatement(InsertInterventionQuery);
										interventionSeqno		 =	0;
										if(!((String)Intervention.get(k+1)).equals("") )
											interventionGrpno		 =	Integer.parseInt((String)Intervention.get(k+1));	
										else
											interventionGrpno		 =	1;
										if(!((String)Intervention.get(k+3)).equals("") )
											interventionrelStart	 =	Integer.parseInt((String)Intervention.get(k+3));	
										if(!((String)Intervention.get(k+6)).equals("") )
											interventionduration	 =	Integer.parseInt((String)Intervention.get(k+6));	
										if(!((String)Intervention.get(k+8)).equals("") )
											interventiondependency	 =  Integer.parseInt((String)Intervention.get(k+8));      
										else
											interventiondependency	 =   1;
										pstmtIntervention.setString(1,libraryid);
										pstmtIntervention.setInt(2,versionno);
										pstmtIntervention.setString(3,termSet);
										pstmtIntervention.setString(4,termCode);
										pstmtIntervention.setString(5,(String)Goal.get(j));
										pstmtIntervention.setString(6,(String)Intervention.get(k));
										pstmtIntervention.setString(7,"C");
										pstmtIntervention.setString(8,"I");
										pstmtIntervention.setInt(9,interventionSeqno);
										pstmtIntervention.setInt(10,interventionGrpno);
										pstmtIntervention.setInt(11,interventionrelStart);
										pstmtIntervention.setString(12,(String)Intervention.get(k+4));
										pstmtIntervention.setString(13,(String)Intervention.get(k+5));
										pstmtIntervention.setInt(14,interventionduration);
										pstmtIntervention.setString(15,(String)Intervention.get(k+7));
										pstmtIntervention.setInt(16,interventiondependency);
										pstmtIntervention.setString(17,(String)Intervention.get(k+2));
										pstmtIntervention.setString(18,(String)Intervention.get(k+9));
										pstmtIntervention.setString(19,added_by_id);
										pstmtIntervention.setString(20,added_at_ws_no);
										pstmtIntervention.setString(21,added_facility_id);
										pstmtIntervention.setString(22,added_by_id);
										pstmtIntervention.setString(23,added_at_ws_no);
										pstmtIntervention.setString(24,added_facility_id);
										interventioncount=pstmtIntervention.executeUpdate();
										if(interventioncount==1)
											result.add("1");
										else {
											result.add("0");
											result.add("0");
											//pstmtIntervention.cancel();
											con.rollback();
											throw new EJBException("Intervention table Insertion failed");
										}
									}
									interventionrelStart=0;
									interventionduration=0;
									interventiondependency=1;
								}

							/*	if(pstmtIntervention != null){
									pstmtIntervention.close();
									pstmtIntervention=null;
							    }*/


								for(int k=0;k<Outcome.size();k=k+8){
									outcomeStatus=(String)Outcome.get(k+5);
									outcomeFlag=(String)Outcome.get(k+6);
									if(outcomeStatus.equals("Y") && outcomeFlag.equals("I")){
										//pstmtOutcome = con.prepareStatement(InsertOutcomeQuery);
										pstmtOutcome.setString(1,libraryid);
										pstmtOutcome.setInt(2,versionno);
										pstmtOutcome.setString(3,termSet);
										pstmtOutcome.setString(4,termCode);
										pstmtOutcome.setString(5,(String)Goal.get(j));
										pstmtOutcome.setString(6,(String)Outcome.get(k));
										pstmtOutcome.setString(7,(String)Outcome.get(k+1));
										pstmtOutcome.setString(8,(String)Outcome.get(k+3));
										pstmtOutcome.setString(9,(String)Outcome.get(k+4));
										pstmtOutcome.setString(10,(String)Outcome.get(k+2));
										pstmtOutcome.setString(11,added_by_id);
										pstmtOutcome.setString(12,added_at_ws_no);
										pstmtOutcome.setString(13,added_facility_id);
										pstmtOutcome.setString(14,added_by_id);
										pstmtOutcome.setString(15,added_at_ws_no);
										pstmtOutcome.setString(16,added_facility_id);
										outcomecount=pstmtOutcome.executeUpdate();
										if(outcomecount==1)
											result.add("1");
										else{
											result.add("0");
											//pstmtOutcome.cancel();
											con.rollback();
											throw new EJBException("Outcome table Insertion failed");
										}
									}
								}

								/*if(pstmtOutcome != null){
									pstmtOutcome.close();
									pstmtOutcome=null;
							    }*/
								goalTargetPeriod=0;





						}else if(goalStatus.equals("N") && goalFlag.equals("U")){
							InterventionOutcome=(HashMap)Goal.get(j+3);
							Intervention=(ArrayList)InterventionOutcome.get("I");
							Outcome=(ArrayList)InterventionOutcome.get("O");
							if(Intervention.size()>0){
								for(int k=0;k<Intervention.size();k=k+13){
									//deletepstmtIntervention=con.prepareStatement(DeleteInterventionQuery);
									interventionCode=(String)Intervention.get(k);
									deletepstmtIntervention.setString(1,libraryid);
									deletepstmtIntervention.setInt(2,versionno);
									deletepstmtIntervention.setString(3,(String)TermCodeList.get(i));
									deletepstmtIntervention.setString(4,(String)TermCodeList.get(i+1));
									deletepstmtIntervention.setString(5,goalCode);
									deletepstmtIntervention.setString(6,interventionCode);
									interventioncount=deletepstmtIntervention.executeUpdate();
									if(interventioncount >=1){
										result.add("1");
										interventiondeleteresult=1;
									}else{
										result.add("0");
										//deletepstmtIntervention.cancel();
										con.rollback();
										throw new EJBException("Intervention table deletion failed");
									}
								}

                             /* if(deletepstmtIntervention != null){
									deletepstmtIntervention.close();
									deletepstmtIntervention=null;
							    }*/
							}
							if(Outcome.size()>0){
								for(int k=0;k<Outcome.size();k=k+8){							
									//deletepstmtOutcome=con.prepareStatement(DeleteOutcomeQuery);
									outcomeCode=(String)Outcome.get(k);								
									deletepstmtOutcome.setString(1,libraryid);
									deletepstmtOutcome.setInt(2,versionno);
									deletepstmtOutcome.setString(3,(String)TermCodeList.get(i));
									deletepstmtOutcome.setString(4,(String)TermCodeList.get(i+1));
									deletepstmtOutcome.setString(5,goalCode);
									deletepstmtOutcome.setString(6,outcomeCode);
									outcomecount=deletepstmtOutcome.executeUpdate();
									if(outcomecount >=1){
										result.add("1");
										outcomedeleteresult=1;
									}else{
										result.add("0");
										//deletepstmtOutcome.cancel();
										con.rollback();
										throw new EJBException("Outcome table deletion failed");
									}
								}
							/*	 if(deletepstmtOutcome != null){
									deletepstmtOutcome.close();
									deletepstmtOutcome=null;
							    }*/
							}
							if(interventiondeleteresult==1 && outcomedeleteresult==1){
								//deletepstmtGoal=con.prepareStatement(DeleteGoalQuery);
								deletepstmtGoal.setString(1,libraryid);
								deletepstmtGoal.setInt(2,versionno);
								deletepstmtGoal.setString(3,(String)TermCodeList.get(i));
								deletepstmtGoal.setString(4,(String)TermCodeList.get(i+1));
								deletepstmtGoal.setString(5,goalCode);
								goalcount=deletepstmtGoal.executeUpdate();
								if(goalcount ==1){
									result.add("1");
								}else{
									result.add("0");
									//deletepstmtGoal.cancel();
									con.rollback();
									throw new EJBException("Goal table deletion failed");
								}
							}
							/* if(deletepstmtGoal != null){
									deletepstmtGoal.close();
									deletepstmtGoal=null;
							  }*/
						}else if(goalStatus.equals("Y") && goalFlag.equals("U")){
							//update goal
							if(!((String)Goal.get(j+1)).equals(""))
								goalTargetPeriod=Integer.parseInt((String)Goal.get(j+1));
							updatepstmtGoal = con.prepareStatement(UpdateGoalQuery);
							updatepstmtGoal.setInt(1,goalTargetPeriod);
							updatepstmtGoal.setString(2,(String)Goal.get(j+2));
							updatepstmtGoal.setString(3,(String)Goal.get(j+8));
							updatepstmtGoal.setString(4,added_by_id);
							updatepstmtGoal.setString(5,added_at_ws_no);
							updatepstmtGoal.setString(6,added_facility_id);
							updatepstmtGoal.setString(7,libraryid);
							updatepstmtGoal.setInt(8,versionno);
							updatepstmtGoal.setString(9,termSet);
							updatepstmtGoal.setString(10,termCode);
							updatepstmtGoal.setString(11,goalCode);
							goalcount=updatepstmtGoal.executeUpdate();
							if(updatepstmtGoal != null){
								updatepstmtGoal.close();
								updatepstmtGoal=null;
							}
							if(goalcount>=1)
								result.add("1");
							else{
								result.add("0");
								//updatepstmtGoal.cancel();
								con.rollback();
								throw new EJBException("Goal table updation failed");
							}
							InterventionOutcome=(HashMap)Goal.get(j+3);
							Intervention=(ArrayList)InterventionOutcome.get("I");
							Outcome=(ArrayList)InterventionOutcome.get("O");
							if(Intervention.size()>0){
								for(int k=0;k<Intervention.size();k=k+13){
									interventionCode=(String)Intervention.get(k);
									interventionStatus=(String)Intervention.get(k+10);
									interventionFlag=(String)Intervention.get(k+11);
									interventionSeqno		 =	0;
									if(!((String)Intervention.get(k+1)).equals(""))
										interventionGrpno		 =	Integer.parseInt((String)Intervention.get(k+1));	
									else
										interventionGrpno		 =	1;
									if(!((String)Intervention.get(k+3)).equals(""))
										interventionrelStart	 =	Integer.parseInt((String)Intervention.get(k+3));	
									else
										interventionrelStart	 = 0;
									
									if(!((String)Intervention.get(k+6)).equals(""))
										interventionduration	 =	Integer.parseInt((String)Intervention.get(k+6));	
									else
										interventionduration=0;
									if(!((String)Intervention.get(k+8)).equals(""))
										interventiondependency	 =  Integer.parseInt((String)Intervention.get(k+8));   
									else
										interventiondependency	 =	1;
									if(interventionStatus.equals("Y") && interventionFlag.equals("I")){
										//insert intervention
									//	pstmtIntervention = con.prepareStatement(InsertInterventionQuery);
										pstmtIntervention.setString(1,libraryid);
										pstmtIntervention.setInt(2,versionno);
										pstmtIntervention.setString(3,termSet);
										pstmtIntervention.setString(4,termCode);
										pstmtIntervention.setString(5,goalCode);
										pstmtIntervention.setString(6,interventionCode);
										pstmtIntervention.setString(7,"C");
										pstmtIntervention.setString(8,"I");
										pstmtIntervention.setInt(9,interventionSeqno);
										pstmtIntervention.setInt(10,interventionGrpno);
										pstmtIntervention.setInt(11,interventionrelStart);
										pstmtIntervention.setString(12,(String)Intervention.get(k+4));
										pstmtIntervention.setString(13,(String)Intervention.get(k+5));
										pstmtIntervention.setInt(14,interventionduration);
										pstmtIntervention.setString(15,(String)Intervention.get(k+7));
										pstmtIntervention.setInt(16,interventiondependency);
										pstmtIntervention.setString(17,(String)Intervention.get(k+2));
										pstmtIntervention.setString(18,(String)Intervention.get(k+9));
										pstmtIntervention.setString(19,added_by_id);
										pstmtIntervention.setString(20,added_at_ws_no);
										pstmtIntervention.setString(21,added_facility_id);
										pstmtIntervention.setString(22,added_by_id);
										pstmtIntervention.setString(23,added_at_ws_no);
										pstmtIntervention.setString(24,added_facility_id);
										interventioncount=pstmtIntervention.executeUpdate();
										/*if(pstmtIntervention != null)
										pstmtIntervention.close();*/
										if(interventioncount==1)
											result.add("1");
										else{ 
											result.add("0");
											//pstmtIntervention.cancel();
											con.rollback();
											throw new EJBException("Intervention table insertion failed");
										}
									}else if(interventionStatus.equals("N") && interventionFlag.equals("U")){
										//delete intervention
									//	deletepstmtIntervention=con.prepareStatement(DeleteInterventionQuery);
										interventionCode=(String)Intervention.get(k);
										deletepstmtIntervention.setString(1,libraryid);
										deletepstmtIntervention.setInt(2,versionno);
										deletepstmtIntervention.setString(3,termSet);
										deletepstmtIntervention.setString(4,termCode);
										deletepstmtIntervention.setString(5,goalCode);
										deletepstmtIntervention.setString(6,interventionCode);
										interventioncount=deletepstmtIntervention.executeUpdate();
										if(interventioncount >=1)
											result.add("1");
										else{
											result.add("0");
											//deletepstmtIntervention.cancel();
											con.rollback();
											throw new EJBException("Intervention table deletion failed");
											}
									
									}else if(interventionStatus.equals("Y") && interventionFlag.equals("U")){
										//updatepstmtIntervention = con.prepareStatement(UpdateInterventionQuery);
										updatepstmtIntervention.setString(1,"C");
										updatepstmtIntervention.setString(2,"I");
										updatepstmtIntervention.setInt(3,interventionSeqno);
										updatepstmtIntervention.setInt(4,interventionGrpno);
										updatepstmtIntervention.setInt(5,interventionrelStart);
										updatepstmtIntervention.setString(6,(String)Intervention.get(k+4));
										updatepstmtIntervention.setString(7,(String)Intervention.get(k+5));
										updatepstmtIntervention.setInt(8,interventionduration);
										updatepstmtIntervention.setString(9,(String)Intervention.get(k+7));
										updatepstmtIntervention.setInt(10,interventiondependency);
										updatepstmtIntervention.setString(11,(String)Intervention.get(k+2));
										updatepstmtIntervention.setString(12,(String)Intervention.get(k+9));
										updatepstmtIntervention.setString(13,added_by_id);
										updatepstmtIntervention.setString(14,added_at_ws_no);
										updatepstmtIntervention.setString(15,added_facility_id);
										updatepstmtIntervention.setString(16,libraryid);
										updatepstmtIntervention.setInt(17,versionno);
										updatepstmtIntervention.setString(18,termSet);
										updatepstmtIntervention.setString(19,termCode);
										updatepstmtIntervention.setString(20,goalCode);
										updatepstmtIntervention.setString(21,interventionCode);
										interventioncount=updatepstmtIntervention.executeUpdate();
									/*	if(updatepstmtIntervention != null)
										updatepstmtIntervention.close();*/
										if(interventioncount>=0)
											result.add("1");
										else{
											result.add("0");
											//updatepstmtIntervention.cancel();
											con.rollback();
											throw new EJBException("Intervention table updation failed");
										}

									}
									interventionrelStart=0;
									interventionduration=0;
									interventiondependency=1;

								/*	if(pstmtIntervention != null){
										pstmtIntervention.close();
										pstmtIntervention=null;
							        }
									if(deletepstmtIntervention != null){
										deletepstmtIntervention.close();
										deletepstmtIntervention=null;
							        }
								   if(updatepstmtIntervention != null){
										updatepstmtIntervention.close();
										updatepstmtIntervention=null;
							        }*/
								}
							}
							if(Outcome.size()>0){
								for(int k=0;k<Outcome.size();k=k+8){
									outcomeCode=(String)Outcome.get(k);
									outcomeStatus=(String)Outcome.get(k+5);
									outcomeFlag=(String)Outcome.get(k+6);
									if(outcomeStatus.equals("Y") && outcomeFlag.equals("I")){
										//insert outcome
										//pstmtOutcome = con.prepareStatement(InsertOutcomeQuery);
										pstmtOutcome.setString(1,libraryid);
										pstmtOutcome.setInt(2,versionno);
										pstmtOutcome.setString(3,termSet);
										pstmtOutcome.setString(4,termCode);
										pstmtOutcome.setString(5,goalCode);
										pstmtOutcome.setString(6,outcomeCode);
										pstmtOutcome.setString(7,(String)Outcome.get(k+1));
										pstmtOutcome.setString(8,(String)Outcome.get(k+3));
										pstmtOutcome.setString(9,(String)Outcome.get(k+4));
										pstmtOutcome.setString(10,(String)Outcome.get(k+2));
										pstmtOutcome.setString(11,added_by_id);
										pstmtOutcome.setString(12,added_at_ws_no);
										pstmtOutcome.setString(13,added_facility_id);
										pstmtOutcome.setString(14,added_by_id);
										pstmtOutcome.setString(15,added_at_ws_no);
										pstmtOutcome.setString(16,added_facility_id);
										outcomecount=pstmtOutcome.executeUpdate();
										if(outcomecount==1)
											result.add("1");
										else{
											result.add("0");
											//pstmtOutcome.cancel();
											con.rollback();
											throw new EJBException("Outcome table insertion failed");
										}
									}else if(outcomeStatus.equals("N") && outcomeFlag.equals("U")){
										//delete outcome
										//deletepstmtOutcome=con.prepareStatement(DeleteOutcomeQuery);
										outcomeCode=(String)Outcome.get(k);								
										deletepstmtOutcome.setString(1,libraryid);
										deletepstmtOutcome.setInt(2,versionno);
										deletepstmtOutcome.setString(3,(String)TermCodeList.get(i));
										deletepstmtOutcome.setString(4,(String)TermCodeList.get(i+1));
										deletepstmtOutcome.setString(5,goalCode);
										deletepstmtOutcome.setString(6,outcomeCode);
										outcomecount=deletepstmtOutcome.executeUpdate();
										if(outcomecount >=1){
											result.add("1");
										}else{
											result.add("0");
											//deletepstmtOutcome.cancel();
											con.rollback();
											throw new EJBException("Outcome table deletion failed");
										}
									}else if(outcomeStatus.equals("Y") && outcomeFlag.equals("U")){
										//update outcome
										//updatepstmtOutcome = con.prepareStatement(UpdateOutcomeQuery);
										updatepstmtOutcome.setString(1,(String)Outcome.get(k+1));
										updatepstmtOutcome.setString(2,(String)Outcome.get(k+3));
										updatepstmtOutcome.setString(3,(String)Outcome.get(k+4));
										updatepstmtOutcome.setString(4,(String)Outcome.get(k+2));
										updatepstmtOutcome.setString(5,added_by_id);
										updatepstmtOutcome.setString(6,added_at_ws_no);
										updatepstmtOutcome.setString(7,added_facility_id);
										updatepstmtOutcome.setString(8,libraryid);
										updatepstmtOutcome.setInt(9,versionno);
										updatepstmtOutcome.setString(10,termSet);
										updatepstmtOutcome.setString(11,termCode);
										updatepstmtOutcome.setString(12,goalCode);
										updatepstmtOutcome.setString(13,outcomeCode);
										outcomecount=updatepstmtOutcome.executeUpdate();
										//if(updatepstmtOutcome != null) updatepstmtOutcome.close();
										if(outcomecount >=1){
											result.add("1");
										}else{
											result.add("0");
											//updatepstmtOutcome.cancel();
											con.rollback();
											throw new EJBException("Outcome table updation failed");
										}
									}
								}

							/*   if(pstmtOutcome != null){
									pstmtOutcome.close();
									pstmtOutcome=null;
								}
								if(deletepstmtOutcome != null){
									deletepstmtOutcome.close();
									deletepstmtOutcome=null;
								}
							   if(updatepstmtOutcome != null){
									updatepstmtOutcome.close();
									updatepstmtOutcome=null;
								}*/

							}
						}
					}
				}
			}

		for(int index=0;index<result.size();index++){
			if(((String)result.get(index)).equals("1")){
				Status=1;
			}else{
				Status=0;
				break;
			}
		}
		if(Status==1){
			map.clear();
			msg="RECORD_INSERTED";
			map.put( "status", new Boolean( true) ) ;
			Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"CP");
		    stringbuffer.append((String)hashtable2.get("message"));
			map.put("error",stringbuffer.toString());
			con.commit();
			hashtable.clear();
		}else{
			map.clear();
			map.put( "status", new Boolean( false) ) ;
			stringbuffer.append("INSERTION FAILED");
			map.put("error",stringbuffer.toString());
			hashtable.clear();
			con.rollback();
			throw new Exception("Error : CP_BUILDLIBRARY");
		}
		 if(con != null)
		{
					
					if(deletepstmtTermcode!=null){
						deletepstmtTermcode.close();
					}
					if(pstmtTermcode != null){
						pstmtTermcode.close();
					}

					if(deletepstmtGoal!=null){
						deletepstmtGoal.close();
					}
					if(updatepstmtGoal!=null){
						updatepstmtGoal.close();
					}
					if(pstmtGoal !=null){
						pstmtGoal.close();
					}

					if(pstmtIntervention !=null){
						pstmtIntervention.close();
					}
					if(deletepstmtIntervention!=null){
						deletepstmtIntervention.close();
					}
					if(updatepstmtIntervention!=null){
						updatepstmtIntervention.close();
					}

					if(pstmtOutcome !=null){
						pstmtOutcome.close();
					}
					if(deletepstmtOutcome!=null){
						deletepstmtOutcome.close();
					}
					if(updatepstmtOutcome!=null){
						updatepstmtOutcome.close();
					}

			         if(con != null)
				            ConnectionManager.returnConnection(con, properties);
					}
	
	}catch(Exception exception){
				stringbuffer.append("Error in main try " + exception.getMessage());
				System.err.println(exception.toString());
				exception.printStackTrace();
		}
	    finally{
		    if(con != null)
			    try{
					if(rs!=null){
						rs.close();
						rs=null;

					}

					if(deletepstmtTermcode!=null){
						deletepstmtTermcode.close();
					}
					if(pstmtTermcode != null){
						pstmtTermcode.close();
					}

					if(deletepstmtGoal!=null){
						deletepstmtGoal.close();
					}
					if(updatepstmtGoal!=null){
						updatepstmtGoal.close();
					}
					if(pstmtGoal !=null){
						pstmtGoal.close();
					}

					if(pstmtIntervention !=null){
						pstmtIntervention.close();
					}
					if(deletepstmtIntervention!=null){
						deletepstmtIntervention.close();
					}
					if(updatepstmtIntervention!=null){
						updatepstmtIntervention.close();
					}

					if(pstmtOutcome !=null){
						pstmtOutcome.close();
					}
					if(deletepstmtOutcome!=null){
						deletepstmtOutcome.close();
					}
					if(updatepstmtOutcome!=null){
						updatepstmtOutcome.close();
					}

			         if(con != null)
				            ConnectionManager.returnConnection(con, properties);
					}catch(Exception exception2) {
						System.err.println(exception2.toString());
					}
        }
		return map;
	}
}
