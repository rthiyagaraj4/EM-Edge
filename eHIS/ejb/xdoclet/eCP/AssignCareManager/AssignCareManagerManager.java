/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Venkatasubbu PR
*	Created On		:	21 Feb 2005
*/

package eCP.AssignCareManager;

import java.sql.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="AssignCareManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AssignCareManager"
*	local-jndi-name="AssignCareManager"
*	impl-class-name="eCP.AssignCareManager.AssignCareManagerManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.AssignCareManager.AssignCareManagerLocal"
*	remote-class="eCP.AssignCareManager.AssignCareManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.AssignCareManager.AssignCareManagerLocalHome"
*	remote-class="eCP.AssignCareManager.AssignCareManagerHome"
*	generate= "local,remote"
*
*
*/
public class AssignCareManagerManager implements SessionBean
{
	Connection cnACM			= null;

	PreparedStatement pst_InsertRec	=	null;
	PreparedStatement pst_UpdOldRec =	null;
	PreparedStatement pst_GetNxtNo	=	null;
	PreparedStatement pst_UpdCurMgrinCP = null;

	ResultSet	rs_GetNxtNo			=	null;

	String m_strMDCPId		= "";
	String m_strCPId		= "";
	String m_strPatientId	= "";
	String m_strCPMgrId		= "";
	String m_strFacilityId	= "";
	String m_strAddedById	= "";
	String m_strAddedAtWsNo = "";

	public AssignCareManagerManager(){}

	public void ejbCreate() throws  CreateException{}

	public void ejbRemove(){}

	public void ejbActivate(){}

	public void ejbPassivate(){}

    public void setSessionContext(SessionContext sessioncontext)
	{
	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
	public HashMap AddModify(HashMap tabData) 
	{
		Properties propACM	= null;
		HashMap mpResult	= new HashMap();

		String strInsertQuery = "";
		String strUpdateQuery = "";
		String strNxtSlNoQuery = "";
		String strUpdCurMgrIdInCp = "";
		String locale="";
		int nNextSlNo= 0;
		int nLastNo  = 0;
		int nRecUpd = 0;

		boolean bInsertFlag = true;
		mpResult.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;

		propACM			=	(Properties)tabData.get("properties");
		m_strMDCPId		=	(String) tabData.get("MD_CARE_PLAN_ID");
		m_strCPId		=	(String) tabData.get("CARE_PLAN_ID");
		m_strPatientId	=	(String) tabData.get("PATIENT_ID");
		m_strCPMgrId	=	(String) tabData.get("CARE_MANAGER_ID");
		m_strFacilityId	=	(String) tabData.get("ADDED_FACILITY_ID");
		m_strAddedById	=	(String) tabData.get("ADDED_BY_ID");
		m_strAddedAtWsNo=	(String) tabData.get("ADDED_AT_WS_NO");
		locale=(String) tabData.get("locale");
		try
		{
			cnACM = ConnectionManager.getConnection(propACM);
			cnACM.setAutoCommit(false);

			//rNxtSlNoQuery		= "SELECT NVL(MAX(SRL_NO),0) NEXTNO FROM CP_PAT_CARE_PLAN_MANAGER WHERE "+ "MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ? AND CARE_MANAGER_ID = ? AND " + "PATIENT_ID = ? ";
			strNxtSlNoQuery		= "SELECT NVL(MAX(SRL_NO),0) NEXTNO FROM CP_PAT_CARE_PLAN_MANAGER WHERE MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ? AND PATIENT_ID = ? ";
			
			//strUpdateQuery		= "UPDATE CP_PAT_CARE_PLAN_MANAGER SET EFF_DATE_TO = sysdate WHERE "+ "MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ? AND CARE_MANAGER_ID = ? AND "+ "PATIENT_ID = ? AND SRL_NO = ?";
			strUpdateQuery		= "UPDATE CP_PAT_CARE_PLAN_MANAGER SET EFF_DATE_TO = sysdate WHERE MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ? AND PATIENT_ID = ? AND SRL_NO = ?";


			strInsertQuery		= "INSERT INTO CP_PAT_CARE_PLAN_MANAGER (MD_CARE_PLAN_ID,CARE_PLAN_ID,CARE_MANAGER_ID,"
								+ "EFF_DATE_FROM,PATIENT_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,"
								+ "MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SRL_NO) VALUES "
								+ "(?,?,?,sysdate,?,?,sysdate,?,?,?,sysdate,?,?,?)";

			strUpdCurMgrIdInCp  = "UPDATE CP_PAT_CARE_PLAN SET MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, "
							    + "MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ?,CURRENT_CARE_MANAGER_ID = ? "
								+ "WHERE MD_CARE_PLAN_ID = ? AND CARE_PLAN_ID = ? ";


			pst_GetNxtNo		= cnACM.prepareStatement(strNxtSlNoQuery);
			pst_UpdOldRec		= cnACM.prepareStatement(strUpdateQuery);
			pst_InsertRec		= cnACM.prepareStatement(strInsertQuery);
			pst_UpdCurMgrinCP	= cnACM.prepareStatement(strUpdCurMgrIdInCp);

			pst_GetNxtNo.setString(1,m_strMDCPId);
			pst_GetNxtNo.setString(2,m_strCPId);
			//pst_GetNxtNo.setString(3,m_strCPMgrId);
			pst_GetNxtNo.setString(3,m_strPatientId);

			try
			{
				rs_GetNxtNo = pst_GetNxtNo.executeQuery();
			}
			catch (Exception e1)
			{

				System.err.println(e1);
				e1.printStackTrace();
			}


			if(rs_GetNxtNo.next() )
				nLastNo	= rs_GetNxtNo.getInt(1);
			if(rs_GetNxtNo!=null) rs_GetNxtNo.close();
			nNextSlNo = nLastNo + 1;

			if(nLastNo > 0)
			{
				pst_UpdOldRec.setString(1,m_strMDCPId);
				pst_UpdOldRec.setString(2,m_strCPId);
				//pst_UpdOldRec.setString(3,m_strCPMgrId);
				pst_UpdOldRec.setString(3,m_strPatientId);
				pst_UpdOldRec.setInt(4,nLastNo);

				nRecUpd = pst_UpdOldRec.executeUpdate();
				
			}

			pst_InsertRec.setString(1,m_strMDCPId);
			pst_InsertRec.setString(2,m_strCPId);
			pst_InsertRec.setString(3,m_strCPMgrId);
			pst_InsertRec.setString(4,m_strPatientId);
			pst_InsertRec.setString(5,m_strAddedById);
			pst_InsertRec.setString(6,m_strAddedAtWsNo);
			pst_InsertRec.setString(7,m_strFacilityId);
			pst_InsertRec.setString(8,m_strAddedById);
			pst_InsertRec.setString(9,m_strAddedAtWsNo);
			pst_InsertRec.setString(10,m_strFacilityId);
			pst_InsertRec.setInt(11,nNextSlNo);

			try
			{
				nRecUpd = pst_InsertRec.executeUpdate();

				if(nRecUpd > 0) 
				{
					pst_UpdCurMgrinCP.setString(1,m_strAddedById);
					pst_UpdCurMgrinCP.setString(2,m_strAddedAtWsNo);
					pst_UpdCurMgrinCP.setString(3,m_strFacilityId);
					pst_UpdCurMgrinCP.setString(4,m_strCPMgrId);
					pst_UpdCurMgrinCP.setString(5,m_strMDCPId);
					pst_UpdCurMgrinCP.setString(6,m_strCPId);
	
					try
					{
						nRecUpd = pst_UpdCurMgrinCP.executeUpdate();
					}
					catch (Exception e3)
					{
						System.err.println("Exception @ e3 " + e3);
						e3.printStackTrace();
					}
				}
			}
			catch (Exception e2)
			{
				System.err.println(e2);
				e2.printStackTrace();

			}

			if( nRecUpd > 0)
				bInsertFlag = true;
			else
				bInsertFlag = false;

			if(bInsertFlag)
			{
				cnACM.commit();
 				mpResult.put( "result", new Boolean( true ) ) ;
				mpResult.put( "flag" , "" );
				Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_INSERTED","CP");
				messages.append((String)massageMap.get("message"));
			}
			else
			{
				cnACM.rollback();
				mpResult.put( "result", new Boolean( false ) ) ;
				mpResult.put( "flag" , "" );
				Hashtable massageMap = MessageManager.getMessage(locale, "ERROR_IN_INSERTING_INTO","CP");
				messages.append((String)massageMap.get("message"));
			}
		}
		catch (Exception e)
		{
			try
			{
				cnACM.rollback();
				mpResult.put( "result", new Boolean( false ) ) ;
				mpResult.put( "flag" , "" );
				Hashtable massageMap = MessageManager.getMessage(locale, "ERROR_IN_INSERTING_INTO","CP");
				messages.append((String)massageMap.get("message"));
			}
			catch(Exception ex)	
			{
				ex.printStackTrace();
			}
		}

		finally
		{
			try
			{
				if(pst_UpdOldRec != null) 
				{
					pst_UpdOldRec.close();
					pst_UpdOldRec = null;
				}
				if(pst_GetNxtNo != null)
				{
					pst_GetNxtNo.close();
					pst_GetNxtNo = null;
				}
				if(pst_InsertRec != null)
				{
					pst_InsertRec.close();
					pst_InsertRec = null;
				}
				if(pst_UpdCurMgrinCP != null)
				{
					pst_UpdCurMgrinCP.close();
					pst_UpdCurMgrinCP = null;
				}
				if(cnACM != null)
					ConnectionManager.returnConnection(cnACM,propACM);
			}
			catch(Exception ey)
			{
				ey.printStackTrace();
			}
		}

		mpResult.put( "message", messages.toString() ) ;
		mpResult.put( "invalidCode" , "");

		return mpResult;
	}
}
