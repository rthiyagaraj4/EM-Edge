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
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
18/01/2013		IN037372		Ramesh G		Oracle 11g Weblogic compilation.
--------------------------------------------------------------------------------------------------------------------
*/
 package eCA.RecMaternityCons;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="RecMaternityCons"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RecMaternityCons"
*	local-jndi-name="RecMaternityCons"
*	impl-class-name="eCA.RecMaternityCons.RecMaternityConsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.RecMaternityCons.RecMaternityConsLocal"
*	remote-class="eCA.RecMaternityCons.RecMaternityConsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.RecMaternityCons.RecMaternityConsLocalHome"
*	remote-class="eCA.RecMaternityCons.RecMaternityConsHome"
*	generate= "local,remote"
*
*
*/

public class RecMaternityConsManager implements SessionBean{
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext sessioncontext) 
	{
			sessioncontext = sessioncontext;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap insertMaternityConsRecs(Properties p,HashMap hashRecords,String locale, webbeans.eCA.XMLtoHTML converter, webbeans.eCA.RecClinicalNotesSectionBean matSectionBean)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmtUpdate=null;
		PreparedStatement pstmtQrySecDet=null;
		PreparedStatement pstmtAccNum=null;
		ResultSet res=null;
		ResultSet resQrySecDet=null;
		ResultSet resAccNum=null;
		String accessionNum = "";
		String accessionNumNew = "";
		String facilityId = "";
		String patientId = "";
		String patientClass = "";
		String encounterId = "";
		String securityLevel = "";
		String addedByUser = "";
		String loginAtWsNo = "";
		String secHdgCode = "";
		String sectionType = "";
		String subSecHdgCode = "";
		String moduleId = "";
		String sectionContentUpdatedXML = "";
		
		String cycleno="";
		String splty_event_code="";
		String splty_task_code="";
		//String     practitionerId="";
		String clinician_id="";
		String close_episode_yn="";
		String outcome_event_code="";
		String outcome_code="";
		String additional_event_yn = "";
		String birth_order = "";
		String finalize_yn = "";
		String modeValue = "";
		boolean bPostStatus = false;
		MessageManager mm = new MessageManager();
		java.util.Hashtable message = new Hashtable();
		java.util.HashMap results = new java.util.HashMap();
		StringBuffer sb = new StringBuffer();
		boolean result = false;
		int res1=0;
		int res2=0;
		
		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			facilityId = (String) hashRecords.get("facilityId") != null ? (String) hashRecords.get("facilityId") : "";
			clinician_id = (String) hashRecords.get("clinician_id") != null ? (String) hashRecords.get("clinician_id") : "";
			moduleId = (String) hashRecords.get("moduleId") != null ? (String) hashRecords.get("moduleId") : "";
			patientId = (String) hashRecords.get("patientId") != null ? (String) hashRecords.get("patientId") : "";
			patientClass = (String) hashRecords.get("patientClass") != null ? (String) hashRecords.get("patientClass") : "";
			encounterId = (String) hashRecords.get("encounterId") != null ? (String) hashRecords.get("encounterId") : "";
			securityLevel = (String) hashRecords.get("securityLevel") != null ? (String) hashRecords.get("securityLevel") : "";
			addedByUser = (String) hashRecords.get("addedByUser") != null ? (String) hashRecords.get("addedByUser") : "";
			loginAtWsNo = (String) hashRecords.get("loginAtWsNo") != null ? (String) hashRecords.get("loginAtWsNo") : "";
			secHdgCode = (String) hashRecords.get("secHdgCode") != null ? (String) hashRecords.get("secHdgCode") : "";
			sectionType = (String) hashRecords.get("sectionType") != null ? (String) hashRecords.get("sectionType") : "";
			cycleno = (String) hashRecords.get("cycle_no") != null ? (String) hashRecords.get("cycle_no") : "";
			splty_event_code = (String) hashRecords.get("splty_event_code") != null ? (String) hashRecords.get("splty_event_code") : "";
			splty_task_code = (String) hashRecords.get("splty_task_code") != null ? (String) hashRecords.get("splty_task_code") : "";

			subSecHdgCode = (String) hashRecords.get("subSecHdgCode") != null ? (String) hashRecords.get("subSecHdgCode") : "";
			accessionNum = (String) hashRecords.get("accessionNum") != null ? (String) hashRecords.get("accessionNum") : "";
			close_episode_yn = (String) hashRecords.get("close_episode_yn") != null ? (String) hashRecords.get("close_episode_yn") : "";
			outcome_event_code = (String) hashRecords.get("outcome_event_code") != null ? (String) hashRecords.get("outcome_event_code") : "";
			outcome_code = (String) hashRecords.get("outcome_code") != null ? (String) hashRecords.get("outcome_code") : "";
			sectionContentUpdatedXML = (String) hashRecords.get("sectionContentUpdatedXML") != null ? (String) hashRecords.get("sectionContentUpdatedXML") : "";

			birth_order = (String) hashRecords.get("birth_order") != null ? (String) hashRecords.get("birth_order") : "1";
			finalize_yn = (String) hashRecords.get("finalize_yn") != null ? (String) hashRecords.get("finalize_yn") : "Y";
			modeValue = (String) hashRecords.get("modeValue") != null ? (String) hashRecords.get("modeValue") : "";

			

			String insertCAPatSpltyTask = "insert into CA_PAT_SPLTY_TASK_DTL (ACCESSION_NUM, HDR_CODE, SUBHDR_CODE, XML_CONTENT, HTM_CONTENT, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) values (?,?,?,empty_clob(),empty_clob(),?,sysdate,?,?,?,sysdate,?,?) ";

			String updateCAPatSpltyTask = "update CA_PAT_SPLTY_TASK_DTL set  XML_CONTENT = empty_clob(), HTM_CONTENT = empty_clob(), ADDED_BY_ID = ?, ADDED_AT_WS_NO = ?, ADDED_FACILITY_ID = ?,  ADDED_DATE = SYSDATE, MODIFIED_BY_ID = ?, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, MODIFIED_DATE = SYSDATE where ACCESSION_NUM = ? and HDR_CODE = ? and SUBHDR_CODE = ?";

			String  insertCAPatSpltyEpisodeTask	="insert into CA_PAT_SPLTY_EPISODE_TASK(ACCESSION_NUM,PATIENT_ID, FACILITY_ID, MODULE_ID ,CYCLE_NO,SPLTY_EVENT_CODE, SPLTY_TASK_CODE, ENCOUNTER_ID, PATIENT_CLASS, PRACITIONER_ID, TRANS_DATE, DTL_REC_PRESENT_YN, SPLTY_EVENT_RESULT_TYPE,SPLTY_EVENT_RESULT_CODE , ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID  , MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,BIRTH_ORDER,FINALIZE_YN) values( ?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)";

			String updateCAPatSpltyEpisodeTask=" update CA_PAT_SPLTY_EPISODE_TASK set FINALIZE_YN =?,MODIFIED_BY_ID=?,MODIFIED_DATE = sysdate ,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? where ACCESSION_NUM = ? and BIRTH_ORDER = ? and PATIENT_ID = ? ";

			String UpdateCAPatSpltyEpisodeHdr ="UPDATE CA_PAT_SPLTY_EPISODE_HDR SET CYCLE_STATUS ='C' WHERE PATIENT_ID = ? AND MODULE_ID = ? AND CYCLE_NO = ? ";
	
			String UpdateCAPatSpltyEpisodeEvent  ="UPDATE CA_PAT_SPLTY_EPISODE_EVENT SET SPLTY_EVENT_STATUS ='C', SPLTY_EVENT_END_DATE=sysdate, OUTCOME_CODE =?,OUTCOME_EVENT_CODE=?,OUTCOME_ACCESSION_NUM= ? WHERE PATIENT_ID =? AND MODULE_ID =? AND CYCLE_NO =? AND SPLTY_EVENT_CODE= ? ";

			String insertCAPatSpltyEpisodeEvent ="INSERT INTO CA_PAT_SPLTY_EPISODE_EVENT (PATIENT_ID,MODULE_ID ,CYCLE_NO,SPLTY_EVENT_CODE,SPLTY_EVENT_START_DATE,SPLTY_EVENT_END_DATE, SPLTY_EVENT_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID ,MODIFIED_BY_ID , MODIFIED_DATE, MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID  )VALUES (?,?,?,?,sysdate,null,'O',?,sysdate,?,?,?,sysdate,?,?)";


			pstmtQrySecDet = con.prepareStatement("SELECT HEADER_SEC_HDG_CODE, CHILD_SEC_HDG_CODE FROM CA_SUBSECTION_LINK_VW WHERE HEADER_SEC_HDG_CODE = ?");
			pstmtQrySecDet.setString(1,secHdgCode);

			String strTemp = "";
			String strOpMode = "";
			String trans_date = "";
			 if(accessionNum.equals(""))
			 {

				pstmtAccNum = con.prepareStatement("select CA_SPLTY_EVENT_TRN.nextval accession_num from dual ");
				resAccNum = pstmtAccNum.executeQuery();
			
				if(resAccNum.next())
					accessionNumNew = resAccNum.getString("accession_num");

				strTemp		=	 moduleId+accessionNumNew;
				strOpMode	=	"Insert";

				if(resAccNum != null) resAccNum.close();
				if(pstmtAccNum != null) pstmtAccNum.close();
			 }//end of if accession number is ""
			 else
			 {
 				strTemp		=	 accessionNum;
				strOpMode	=	"Update";
			 }
			
			if (modeValue.equals("T")&&(!accessionNum.equals("")))
			{
				pstmt = con.prepareStatement(updateCAPatSpltyEpisodeTask);
				pstmt.setString(1,finalize_yn);
				pstmt.setString(2,addedByUser);
				pstmt.setString(3,loginAtWsNo);
				pstmt.setString(4,facilityId);
				pstmt.setString(5,accessionNum);
				pstmt.setInt(6,Integer.parseInt(birth_order));
				pstmt.setString(7,patientId);
				pstmt.executeUpdate();
				
			}
			else
			{

			pstmt = con.prepareStatement(insertCAPatSpltyEpisodeTask);
			if(accessionNum.equals(""))
				pstmt.setString(1,moduleId+accessionNumNew);
			else
				pstmt.setString(1,moduleId+accessionNum);
			pstmt.setString(2,patientId);
			pstmt.setString(3,facilityId);
			pstmt.setString(4,moduleId);
			pstmt.setString(5,cycleno);
			pstmt.setString(6,splty_event_code);
			pstmt.setString(7,splty_task_code);
			pstmt.setString(8,encounterId);
			pstmt.setString(9,patientClass);
			pstmt.setString(10,clinician_id);
			pstmt.setString(11,"N");
			pstmt.setString(12,sectionType);
			pstmt.setString(13,secHdgCode);
			pstmt.setString(14,addedByUser);
			pstmt.setString(15,loginAtWsNo);
			pstmt.setString(16,facilityId);
			pstmt.setString(17,addedByUser);
			pstmt.setString(18,loginAtWsNo);
			pstmt.setString(19,facilityId);
			pstmt.setInt(20,Integer.parseInt(birth_order));
			pstmt.setString(21,finalize_yn);

			pstmt.executeUpdate();
			}

			if(pstmt != null) pstmt.close();

			
			 if(sectionType.equals("TG"))
			 {
				 resQrySecDet = pstmtQrySecDet.executeQuery();
				
				 while(resQrySecDet.next())
				 {
					 subSecHdgCode = resQrySecDet.getString("CHILD_SEC_HDG_CODE") == null ? "" : resQrySecDet.getString("CHILD_SEC_HDG_CODE");

					 sectionContentUpdatedXML = (String) matSectionBean.getSectionContent(secHdgCode,subSecHdgCode);
					
					 if(accessionNum.equals(""))
					 {
						 if(sectionContentUpdatedXML != null && !sectionContentUpdatedXML.equals(""))
						 {
							 pstmtUpdate = con.prepareStatement(insertCAPatSpltyTask);
							 pstmtUpdate.setString(1,moduleId+accessionNumNew);
							 pstmtUpdate.setString(2,secHdgCode);
							 pstmtUpdate.setString(3,subSecHdgCode);
							 pstmtUpdate.setString(4,addedByUser);
							 pstmtUpdate.setString(5,loginAtWsNo);
							 pstmtUpdate.setString(6,facilityId);
							 pstmtUpdate.setString(7,addedByUser);
							 pstmtUpdate.setString(8,loginAtWsNo);
							 pstmtUpdate.setString(9,facilityId);			

							 pstmtUpdate.executeUpdate();

							 if(pstmtUpdate != null) pstmtUpdate.close();
						 }
					}
					else
					{
						pstmt = con.prepareStatement(updateCAPatSpltyTask);
						pstmt.setString(1,addedByUser);
						pstmt.setString(2,loginAtWsNo);
						pstmt.setString(3,facilityId);
						pstmt.setString(4,addedByUser);
						pstmt.setString(5,loginAtWsNo);
						pstmt.setString(6,facilityId);
						pstmt.setString(7,accessionNum);
						//pstmt.setString(7,moduleId+accessionNum);
						pstmt.setString(8,secHdgCode);
						pstmt.setString(9,subSecHdgCode);

						pstmt.executeUpdate();
					}

					sectionContentUpdatedXML = (String) matSectionBean.getSectionContent(secHdgCode,subSecHdgCode);
					String matSecContent = "select HTM_CONTENT from CA_PAT_SPLTY_TASK_DTL where ACCESSION_NUM = ? and SUBHDR_CODE = ? for update";
					
					//oracle.sql.CLOB clobMatSecContent = null;  //Web logic Conversion -- [IN037372]
					java.sql.Clob clobMatSecContent = null;
					//java.io.Writer matContentWriter = null;//Checkstyle
					java.io.BufferedWriter matContentBufferedWriter = null;
					StringBuffer noteContent = new StringBuffer();
					String matSectionContent = "";
					

					if(sectionContentUpdatedXML != null)
					{
						matSectionContent = converter.buildHTMLFromXML(sectionContentUpdatedXML,"eCA/html/RecClinicalNotesTemplateSentenceViewMC.xsl");

						try
						{
							pstmt = con.prepareStatement(matSecContent);
							if(accessionNum.equals(""))
								pstmt.setString(1,moduleId+accessionNumNew);
							else
								pstmt.setString(1,accessionNum);
								//pstmt.setString(1,moduleId+accessionNum);
					
							pstmt.setString(2,subSecHdgCode);
							res = pstmt.executeQuery();

							//noteContent.append("<html><head>");
							//noteContent.append("<title>Result</title></head>");
							noteContent.append("<title>Result</title>");
							//noteContent.append("<body class='MESSAGE'>");

							noteContent.append(matSectionContent);
							//noteContent.append("</BODY></HTML>");	

							if(res.next())
							{
							//Web logic Conversion -- [IN037372] Start.
								//clobMatSecContent = (oracle.sql.CLOB) res.getObject("HTM_CONTENT");
								//matContentWriter = ((oracle.sql.CLOB) clobMatSecContent).getCharacterOutputStream();				
								//matContentBufferedWriter = new java.io.BufferedWriter(matContentWriter);
								
								clobMatSecContent = (java.sql.Clob) res.getClob("HTM_CONTENT");
								matContentBufferedWriter = new java.io.BufferedWriter(clobMatSecContent.setCharacterStream(0));
							//Web logic Conversion -- [IN037372] End.	
								matContentBufferedWriter.write(noteContent.toString(),0,noteContent.length());
								matContentBufferedWriter.flush();
								matContentBufferedWriter.close();
							}
							
							if(res != null) res.close();
							if(pstmt != null) pstmt.close();
						}
						catch(Exception eee)
						{
							
							eee.printStackTrace();
						}
						
						try
						{
							
							pstmt = con.prepareStatement("select XML_CONTENT from CA_PAT_SPLTY_TASK_DTL where ACCESSION_NUM = ? and SUBHDR_CODE = ? for update");
							
							if(accessionNum.equals(""))
								pstmt.setString(1,moduleId+accessionNumNew);
							else
								pstmt.setString(1,accessionNum);				
								//pstmt.setString(1,moduleId+accessionNum);				
							pstmt.setString(2,subSecHdgCode);
							res = pstmt.executeQuery();

							if(res.next())
							{
							//Web logic Conversion -- [IN037372] Start.
								//clobMatSecContent = (oracle.sql.CLOB) res.getObject("XML_CONTENT");
								//matContentWriter = ((oracle.sql.CLOB) clobMatSecContent).getCharacterOutputStream();				
								//matContentBufferedWriter = new java.io.BufferedWriter(matContentWriter	);
								
								clobMatSecContent = (java.sql.Clob) res.getClob("XML_CONTENT");
								matContentBufferedWriter = new java.io.BufferedWriter(clobMatSecContent.setCharacterStream(0));
							//Web logic Conversion -- [IN037372] End.
								matContentBufferedWriter.write(sectionContentUpdatedXML,0,sectionContentUpdatedXML.length());
								matContentBufferedWriter.flush();
								matContentBufferedWriter.close();
							}
							

							if(res != null) res.close();
							if(pstmt != null) pstmt.close();

							// Getting sysdate to insert as TRANS_DATE into CA_SPLTY_DISCR_MSR table
							pstmt = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') from dual");
							res = pstmt.executeQuery();

							if(res.next())
								trans_date = res.getString(1);

							if(res != null) res.close();
							if(pstmt != null) pstmt.close();

							// To call the new bean for each section 
							
							webbeans.eCA.MaternityDataParser mdp	= new webbeans.eCA.MaternityDataParser();
						
							if(!sectionContentUpdatedXML.equals("") )
								bPostStatus = mdp.MatDataPost(con,sectionContentUpdatedXML,patientId,trans_date,strTemp,encounterId,facilityId,patientClass,converter,secHdgCode,subSecHdgCode,strOpMode,moduleId,cycleno,splty_event_code,splty_task_code,"eCA/html/RecClinicalNotesTemplateSentenceViewMC.xsl",loginAtWsNo,addedByUser);
	
							mdp = null;
							

						}
						catch(Exception htmlData)
						{
							
							htmlData.printStackTrace();
						}
					 }
				}//end of while

				if(resQrySecDet != null) resQrySecDet.close();
				if(pstmtQrySecDet != null) pstmtQrySecDet.close();
			}//end of if sectionType = TG
			else if(sectionType.equals("TM")||sectionType.equals("OC"))
			{
				if(accessionNum.equals(""))
				{
					pstmtUpdate = con.prepareStatement(insertCAPatSpltyTask);
					pstmtUpdate.setString(1,moduleId+accessionNumNew);
					pstmtUpdate.setString(2,secHdgCode);
					pstmtUpdate.setString(3,subSecHdgCode);
					pstmtUpdate.setString(4,addedByUser);
					pstmtUpdate.setString(5,loginAtWsNo);
					pstmtUpdate.setString(6,facilityId);
					pstmtUpdate.setString(7,addedByUser);
					pstmtUpdate.setString(8,loginAtWsNo);
					pstmtUpdate.setString(9,facilityId);			

					pstmtUpdate.executeUpdate();
				}
				else
				{
					pstmt = con.prepareStatement(updateCAPatSpltyTask);
					pstmt.setString(1,addedByUser);
					pstmt.setString(2,loginAtWsNo);
					pstmt.setString(3,facilityId);
					pstmt.setString(4,addedByUser);
					pstmt.setString(5,loginAtWsNo);
					pstmt.setString(6,facilityId);
					pstmt.setString(7,moduleId+accessionNum);
					pstmt.setString(8,secHdgCode);
					pstmt.setString(9,subSecHdgCode);

					pstmt.executeUpdate();
				}

				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(pstmtUpdate != null) pstmtUpdate.close();

				String matSecContent = "select HTM_CONTENT from CA_PAT_SPLTY_TASK_DTL where ACCESSION_NUM = ? for update";

				sectionContentUpdatedXML = (String) matSectionBean.getSectionContent(secHdgCode,subSecHdgCode);

				//oracle.sql.CLOB clobMatSecContent = null;  ////Web logic Conversion -- [IN037372].
				java.sql.Clob clobMatSecContent = null;
				//java.io.Writer matContentWriter = null;//Checkstyle
				java.io.BufferedWriter matContentBufferedWriter = null;
				StringBuffer noteContent = new StringBuffer();
				String matSectionContent = "";

				if(sectionContentUpdatedXML != null)
				{
					matSectionContent = converter.buildHTMLFromXML(sectionContentUpdatedXML,"eCA/html/RecClinicalNotesTemplateSentenceViewMC.xsl");

					try
					{
						pstmt = con.prepareStatement(matSecContent);
						if(accessionNum.equals(""))
							pstmt.setString(1,moduleId+accessionNumNew);
						else
							pstmt.setString(1,moduleId+accessionNum);				
						res = pstmt.executeQuery();

						noteContent.append("<html><head>");
						noteContent.append("<title>Result</title></head>");
						noteContent.append("<body class='MESSAGE'>");

						noteContent.append(matSectionContent);
						noteContent.append("</BODY></HTML>");	

						if(res.next())
						{
						//Web logic Conversion -- [IN037372] Start.	
							//clobMatSecContent = (oracle.sql.CLOB) res.getObject("HTM_CONTENT");
							//matContentWriter = ((oracle.sql.CLOB) clobMatSecContent).getCharacterOutputStream();			
							//matContentBufferedWriter = new java.io.BufferedWriter(matContentWriter	);
							
							clobMatSecContent = (java.sql.Clob) res.getClob("HTM_CONTENT");
							matContentBufferedWriter = new java.io.BufferedWriter(clobMatSecContent.setCharacterStream(0));
						//Web logic Conversion -- [IN037372] End.	
							matContentBufferedWriter.write(noteContent.toString(),0,noteContent.length());
							matContentBufferedWriter.flush();
							matContentBufferedWriter.close();
						}

						if(res != null) res.close();
						if(pstmt != null) pstmt.close();
					}
					catch(Exception eee)
					{
						
						eee.printStackTrace();
					}
					
					try
					{
						pstmt = con.prepareStatement("select XML_CONTENT from CA_PAT_SPLTY_TASK_DTL where ACCESSION_NUM = ? for update");
						if(accessionNum.equals(""))
							pstmt.setString(1,moduleId+accessionNumNew);
						else
							pstmt.setString(1,moduleId+accessionNum);	
						res = pstmt.executeQuery();

						if(res.next())
						{
						//Web logic Conversion -- [IN037372] Start.
							//clobMatSecContent = (oracle.sql.CLOB) res.getObject("XML_CONTENT");
							//matContentWriter = ((oracle.sql.CLOB) clobMatSecContent).getCharacterOutputStream();			
							//matContentBufferedWriter = new java.io.BufferedWriter(matContentWriter	);
							
							clobMatSecContent = (java.sql.Clob) res.getClob("XML_CONTENT");
							matContentBufferedWriter = new java.io.BufferedWriter(clobMatSecContent.setCharacterStream(0));
						//Web logic Conversion -- [IN037372] End.	
							matContentBufferedWriter.write(sectionContentUpdatedXML,0,sectionContentUpdatedXML.length());
							matContentBufferedWriter.flush();
							matContentBufferedWriter.close();
						}

						if(res != null) res.close();
						if(pstmt != null) pstmt.close();

						// Getting sysdate to insert as TRANS_DATE into CA_SPLTY_DISCR_MSR table
						pstmt = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') from dual");
						res = pstmt.executeQuery();

						if(res.next())
							trans_date = res.getString(1);

						if(res != null) res.close();
						if(pstmt != null) pstmt.close();

						// To invoke the new bean 
							webbeans.eCA.MaternityDataParser mdp	= new webbeans.eCA.MaternityDataParser();
							
							bPostStatus = mdp.MatDataPost(con,sectionContentUpdatedXML,patientId,trans_date,strTemp,encounterId,facilityId,patientClass,converter,secHdgCode,subSecHdgCode,strOpMode,moduleId,cycleno,splty_event_code,splty_task_code,"eCA/html/RecClinicalNotesTemplateSentenceViewMC.xsl",loginAtWsNo,addedByUser);
							mdp = null;

					}
					catch(Exception htmlData)
					{
						
						htmlData.printStackTrace();
					}
				}
				if(sectionType.equals("OC"))
				{
					String additional_event_query ="SELECT ADDITIONAL_EVENT_YN FROM CA_PAT_SPLTY_EPISODE_EVENT WHERE   PATIENT_ID = ? AND   MODULE_ID  =? AND CYCLE_NO =? AND SPLTY_EVENT_CODE =? ";
					pstmt =con.prepareStatement(additional_event_query);
					pstmt.setString(1,patientId);
					pstmt.setString(2,moduleId);
					pstmt.setString(3,cycleno);
					pstmt.setString(4,splty_event_code);
					res = pstmt.executeQuery();
					while(res.next())
					{
						additional_event_yn = res.getString("ADDITIONAL_EVENT_YN");
					}
					
					if(res != null) res.close();
					if(pstmt != null) pstmt.close();
					
					if (close_episode_yn.equals("Y")&&!additional_event_yn.equals("Y"))
					{
						try{
							pstmtUpdate = con.prepareStatement(UpdateCAPatSpltyEpisodeEvent);
							pstmtUpdate.setString(1,outcome_code);//out
							pstmtUpdate.setString(2,outcome_event_code);//out
							pstmtUpdate.setString(3,moduleId+accessionNumNew);//out
							pstmtUpdate.setString(4,patientId);
							pstmtUpdate.setString(5,moduleId);
							pstmtUpdate.setString(6,cycleno);
							pstmtUpdate.setString(7,splty_event_code);
							res1=pstmtUpdate.executeUpdate();
							
							if(pstmtUpdate != null) pstmtUpdate.close();
							
							pstmtUpdate = con.prepareStatement(UpdateCAPatSpltyEpisodeHdr);
							pstmtUpdate.setString(1,patientId);
							pstmtUpdate.setString(2,moduleId);
							pstmtUpdate.setString(3,cycleno);
							res2=pstmtUpdate.executeUpdate();
							
							if(pstmtUpdate != null) pstmtUpdate.close();
						}
						catch(Exception e){
							
							e.printStackTrace();
						}

						
					}
					else
					{
						try{
							pstmtUpdate = con.prepareStatement(UpdateCAPatSpltyEpisodeEvent);
							pstmtUpdate.setString(1,outcome_code);
							pstmtUpdate.setString(2,outcome_event_code);
							pstmtUpdate.setString(3,moduleId+accessionNumNew);
							pstmtUpdate.setString(4,patientId);
							pstmtUpdate.setString(5,moduleId);
							pstmtUpdate.setString(6,cycleno);
							pstmtUpdate.setString(7,splty_event_code);
							res1=pstmtUpdate.executeUpdate();
							

							if(pstmtUpdate != null) pstmtUpdate.close();
						// for additional events
						if(!additional_event_yn.equals("Y"))
						{
							pstmtUpdate = con.prepareStatement(insertCAPatSpltyEpisodeEvent);
							pstmtUpdate.setString(1,patientId);
							pstmtUpdate.setString(2,moduleId);
							pstmtUpdate.setString(3,cycleno);
							pstmtUpdate.setString(4,outcome_event_code);
							pstmtUpdate.setString(5,addedByUser);
							pstmtUpdate.setString(6,loginAtWsNo);
							pstmtUpdate.setString(7,facilityId);
							pstmtUpdate.setString(8,addedByUser);
							pstmtUpdate.setString(9,loginAtWsNo);
							pstmtUpdate.setString(10,facilityId);
							
							res2=pstmtUpdate.executeUpdate();
							
						}

						}
						catch(Exception e){
						
						e.printStackTrace();
						}
											
					}
				}
				
				if(pstmtUpdate != null) pstmtUpdate.close();
			}//end of if sectionType = TM/OC
			con.commit();
			result	=	true ;
			message	=	mm.getMessage( locale, "RECORD_INSERTED","CA");
			sb.append( (String) message.get("message"));

		}//end of try - main
		catch(Exception ex)
		{
			try
					{
						con.rollback();
					}
				catch(Exception e1)
					{
					}
			
			ex.printStackTrace();
			result = false;
			sb.append( (String) message.get("message") ) ;
		}
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con, p);
		}
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		results.put("accessionNum",moduleId+accessionNum);
		return results;
	}//end of method

/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap closeMaternityEvent(Properties p,HashMap hashRecords,String locale)

	{
		Connection		  con=null;
		PreparedStatement pstmtUpdate=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		
		String facilityId = "";
		String patientId = "";
		String addedByUser = "";
		String loginAtWsNo = "";
		String sectionType = "";
		String moduleId = "";
		String cycleno="";
		String splty_event_code="";
		String splty_task_code="";
		String close_episode_yn="";
		String outcome_event_code="";
		String outcome_code="";
		String accessionNum="";
		String additional_event_yn ="";

		MessageManager mm = new MessageManager();
		java.util.Hashtable message = new Hashtable();
		java.util.HashMap results = new java.util.HashMap();
		StringBuffer sb = new StringBuffer();
		boolean result = false;
		int res1=0;
		int res2=0;

		

			try{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			facilityId = (String) hashRecords.get("facilityId") != null ? (String) hashRecords.get("facilityId") : "";
			
			moduleId = (String) hashRecords.get("moduleId") != null ? (String) hashRecords.get("moduleId") : "";
			patientId = (String) hashRecords.get("patientId") != null ? (String) hashRecords.get("patientId") : "";
			
			addedByUser = (String) hashRecords.get("addedByUser") != null ? (String) hashRecords.get("addedByUser") : "";
			loginAtWsNo = (String) hashRecords.get("loginAtWsNo") != null ? (String) hashRecords.get("loginAtWsNo") : "";
			
			sectionType = (String) hashRecords.get("sectionType") != null ? (String) hashRecords.get("sectionType") : "";
			cycleno = (String) hashRecords.get("cycle_no") != null ? (String) hashRecords.get("cycle_no") : "";
			splty_event_code = (String) hashRecords.get("splty_event_code") != null ? (String) hashRecords.get("splty_event_code") : "";
			splty_task_code = (String) hashRecords.get("splty_task_code") != null ? (String) hashRecords.get("splty_task_code") : "";
			close_episode_yn = (String) hashRecords.get("close_episode_yn") != null ? (String) hashRecords.get("close_episode_yn") : "";
			outcome_event_code = (String) hashRecords.get("outcome_event_code") != null ? (String) hashRecords.get("outcome_event_code") : "";
			outcome_code = (String) hashRecords.get("outcome_code") != null ? (String) hashRecords.get("outcome_code") : "";
			accessionNum = (String) hashRecords.get("accessionNum") != null ? (String) hashRecords.get("accessionNum") : "";
			
			String UpdateCAPatSpltyEpisodeHdr ="UPDATE CA_PAT_SPLTY_EPISODE_HDR SET CYCLE_STATUS ='C' WHERE PATIENT_ID = ? AND MODULE_ID = ? AND CYCLE_NO = ? ";
	
			String UpdateCAPatSpltyEpisodeEvent  ="UPDATE CA_PAT_SPLTY_EPISODE_EVENT SET SPLTY_EVENT_STATUS ='C',  SPLTY_EVENT_END_DATE = sysdate,OUTCOME_CODE =?,OUTCOME_EVENT_CODE=?,OUTCOME_ACCESSION_NUM= ? WHERE PATIENT_ID =? AND MODULE_ID =? AND CYCLE_NO =? AND SPLTY_EVENT_CODE= ? ";

			String insertCAPatSpltyEpisodeEvent ="INSERT INTO CA_PAT_SPLTY_EPISODE_EVENT (PATIENT_ID,MODULE_ID ,CYCLE_NO,SPLTY_EVENT_CODE,SPLTY_EVENT_START_DATE,SPLTY_EVENT_END_DATE, SPLTY_EVENT_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID ,MODIFIED_BY_ID , MODIFIED_DATE, MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID )VALUES (?,?,?,?,sysdate,null,'O',?,sysdate,?,?,?,sysdate,?,?)";

			String updateCAPatSpltyEpisodeTask ="UPDATE CA_PAT_SPLTY_EPISODE_TASK SET DTL_REC_PRESENT_YN ='N' where patient_id =? and module_id =? and cycle_no = ? and SPLTY_EVENT_CODE = ?" ;
			
			if(sectionType.equals("OC"))
				{
					
					String additional_event_query ="SELECT ADDITIONAL_EVENT_YN FROM CA_PAT_SPLTY_EPISODE_EVENT WHERE   PATIENT_ID = ? AND   MODULE_ID  =? AND CYCLE_NO =? AND SPLTY_EVENT_CODE =? ";
					pstmt =con.prepareStatement(additional_event_query);
					pstmt.setString(1,patientId);
					pstmt.setString(2,moduleId);
					pstmt.setString(3,cycleno);
					pstmt.setString(4,splty_event_code);
					res = pstmt.executeQuery();
					while(res.next())
					{
						additional_event_yn = res.getString("ADDITIONAL_EVENT_YN");
					}

					if(res != null) res.close();
					if(pstmt != null) pstmt.close();
					//if (close_episode_yn.equals("Y")&&!additional_event_yn.equals("Y"))
					if (close_episode_yn.equals("Y"))
					{
						try{
							pstmtUpdate = con.prepareStatement(UpdateCAPatSpltyEpisodeEvent);
							pstmtUpdate.setString(1,outcome_code);
							pstmtUpdate.setString(2,outcome_event_code);
							pstmtUpdate.setString(3,"");
							pstmtUpdate.setString(4,patientId);
							pstmtUpdate.setString(5,moduleId);
							pstmtUpdate.setString(6,cycleno);
							pstmtUpdate.setString(7,splty_event_code);
							res1=pstmtUpdate.executeUpdate();
							
							if(pstmtUpdate != null) pstmtUpdate.close();
							
							pstmtUpdate = con.prepareStatement(UpdateCAPatSpltyEpisodeHdr);
							pstmtUpdate.setString(1,patientId);
							pstmtUpdate.setString(2,moduleId);
							pstmtUpdate.setString(3,cycleno);
							res2=pstmtUpdate.executeUpdate();
							
							if(pstmtUpdate != null) pstmtUpdate.close();
							
							pstmtUpdate = con.prepareStatement(updateCAPatSpltyEpisodeTask);
							pstmtUpdate.setString(1,patientId);
							pstmtUpdate.setString(2,moduleId);
							pstmtUpdate.setString(3,cycleno);
							pstmtUpdate.setString(4,splty_event_code);
							res2=pstmtUpdate.executeUpdate();
							
							if(pstmtUpdate != null) pstmtUpdate.close();
						}
						catch(Exception e){
							
							e.printStackTrace();
						}

						
					}
					else
					{
						try{
							pstmtUpdate = con.prepareStatement(UpdateCAPatSpltyEpisodeEvent);
							pstmtUpdate.setString(1,outcome_code);
							pstmtUpdate.setString(2,outcome_event_code);
							pstmtUpdate.setString(3,"");
							pstmtUpdate.setString(4,patientId);
							pstmtUpdate.setString(5,moduleId);
							pstmtUpdate.setString(6,cycleno);
							pstmtUpdate.setString(7,splty_event_code);
							res1=pstmtUpdate.executeUpdate();
							

							if(pstmtUpdate != null) pstmtUpdate.close();
							
							if(!additional_event_yn.equals("Y"))
							{
								pstmtUpdate = con.prepareStatement(insertCAPatSpltyEpisodeEvent);
								pstmtUpdate.setString(1,patientId);
								pstmtUpdate.setString(2,moduleId);
								pstmtUpdate.setString(3,cycleno);
								pstmtUpdate.setString(4,outcome_event_code);
								pstmtUpdate.setString(5,addedByUser);
								pstmtUpdate.setString(6,loginAtWsNo);
								pstmtUpdate.setString(7,facilityId);
								pstmtUpdate.setString(8,addedByUser);
								pstmtUpdate.setString(9,loginAtWsNo);
								pstmtUpdate.setString(10,facilityId);
								
								res2=pstmtUpdate.executeUpdate();
								
								if(pstmtUpdate != null) pstmtUpdate.close();
							}	
														
								pstmtUpdate = con.prepareStatement(updateCAPatSpltyEpisodeTask);
								pstmtUpdate.setString(1,patientId);
								pstmtUpdate.setString(2,moduleId);
								pstmtUpdate.setString(3,cycleno);
								pstmtUpdate.setString(4,splty_event_code);
								res2 = pstmtUpdate.executeUpdate();
								
							
						}
						catch(Exception e){
						
						e.printStackTrace();
						}
											
					}
				}// end of sectiontype='OC'
				if(pstmtUpdate != null) pstmtUpdate.close();

			con.commit();
			result	=	true ;
			message	=	mm.getMessage( locale, "RECORD_INSERTED","CA");
			sb.append( (String) message.get("message"));


	}//end of try

		catch(Exception ex)
		{
			
			ex.printStackTrace();
			result = false;
			sb.append( (String) message.get("message") ) ;
		}
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con, p);
		}
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;

	}
	
}//end of class
