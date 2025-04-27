/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------
?             100            ?          created
27/09/2012	IN029155		DineshT		Remarks link disappears when we perform the replace or error actions in the chart
22/02/2013	IN038118		Ramesh G	Not Able To Record Charts  
-------------------------------------------------------------------------------------------------------
*/
package eCA.ChartRecording;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="ChartRecording"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ChartRecording"
*	local-jndi-name="ChartRecording"
*	impl-class-name="eCA.ChartRecording.ChartRecordingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.ChartRecording.ChartRecordingLocal"
*	remote-class="eCA.ChartRecording.ChartRecordingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.ChartRecording.ChartRecordingLocalHome"
*	remote-class="eCA.ChartRecording.ChartRecordingHome"
*	generate= "local,remote"
*
*
*/

public class ChartRecordingManager implements SessionBean{
	    Connection con;
		//PreparedStatement stmt;
		PreparedStatement pslPrepStmt,pstmt,pstmt1;
		CallableStatement cs;
		ResultSet rs,rs1;
	   // SessionContext ctx;
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

		public HashMap insertChartRecords(Properties p,HashMap hashRecords,String locale)
		{	

			boolean bool = false;
			boolean bUpd_status = true;
			String disMsrId = "", disMsrResultType = "",  uom = "", normalLow = "",normalHigh = "",criticalLow = "",criticalHigh = "",normalAbnormalInd ="",chartGrpId = "",resultNum="",resultStr="", result_prefix = "", remarks="";
			String chartId =  (String)	hashRecords.get("chartId")==null ? "" :(String)	hashRecords.get("chartId") ;
			String contr_mod_accession_num =  (String)	hashRecords.get("contr_mod_accession_num")==null ? "" :(String)	hashRecords.get("contr_mod_accession_num") ;
			String module_id =  (String)	hashRecords.get("module_id")==null ? "" :(String)	hashRecords.get("module_id") ;
			
			String facilityId = (String)	hashRecords.get("facilityId")==null ? "" :(String)	hashRecords.get("facilityId") ;
			String function_from = (String)	hashRecords.get("function_from")==null ? "" :(String)	hashRecords.get("function_from") ;
			String taskCode = (String)	hashRecords.get("taskCode")==null ? "" :(String)	hashRecords.get("taskCode") ;
			String taskSrlNo = (String)	hashRecords.get("taskSrlNo")==null ? "" :(String)	hashRecords.get("taskSrlNo") ;
			String practitionerId = (String)	hashRecords.get("practitionerId")==null ? "" :(String)	hashRecords.get("practitionerId");
			
			String addedById   = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;
			
			String addedAtWSNo = p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
			
			String encounterId = (String)hashRecords.get("encounterId")==null ? "" :(String)hashRecords.get("encounterId");

			if(encounterId.equals("")) encounterId = "0";

			String patientId = hashRecords.get("patientId")==null ? "" :(String)hashRecords.get("patientId");
			
			String patientClass = hashRecords.get("patientClass")==null ? "" : (String)hashRecords.get("patientClass");
//			String locale =  (String)	hashRecords.get("locale");

			if(patientClass.equals("null"))
			{
				patientClass = "";
			}
			
		
			int counter = hashRecords.get("count") == null ? 0 : Integer.parseInt((String) hashRecords.get("count") );
			
			String recTime =  hashRecords.get("recTime") == null ?"": (String) hashRecords.get("recTime");

			
			int val =0;int i=0;
			
			con = ConnectionManager.getConnection(p);
			
			try
			{
				if(patientClass.equals(""))
				{
					String tempSql = "select patient_class from pr_encounter where facility_id=? and 	encounter_id=? ";
					pslPrepStmt = con.prepareStatement(tempSql);
					pslPrepStmt.setString(1,facilityId);
					pslPrepStmt.setString(2,encounterId);
					rs = pslPrepStmt.executeQuery();
					while( rs.next())
					{
						patientClass = rs.getString(1) == null ? "" :  rs.getString(1);
					}
					if(pslPrepStmt != null)pslPrepStmt.close();
					if(rs != null)rs.close();
				}
				//[IN038118] Start.
				String includeFacilityAccessioNum="N";
				String query_accession_num="";
				try
				{	
					String query_logic_accession_num = "select 'Y' from OR_PAT_APPLICABLE_FUNC where function_id = 'MULTI_FACILITY_ORDER_ID'";
					pstmt1	=	con.prepareStatement(query_logic_accession_num);
					rs1		=	pstmt1.executeQuery();
				
					if(rs1.next()){
						includeFacilityAccessioNum	=	rs1.getString(1);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(rs1!=null) rs1.close();
					if(pstmt1!=null)	pstmt1.close();
				}
					
				if("N".equals(includeFacilityAccessioNum))					
					query_accession_num =  "'DM$'||to_char(sysdate,'YYYY')||'$'||lpad(CA_DISCR_MSR_SEQ.nextval,16,'0')";
				else if("Y".equals(includeFacilityAccessioNum))
					query_accession_num =  "'DM$'||'"+facilityId+"'||to_char(sysdate,'YYYY')||'$'||lpad(CA_DISCR_MSR_SEQ.nextval,14,'0')";
			
				//String sql = "insert into CA_ENCNTR_DISCR_MSR(ACCESSION_NUM,FACILITY_ID,ENCOUNTER_ID,PATIENT_ID,PATIENT_CLASS,NORM_ABNORM_IND,TEST_OBSERV_DT_TM,PERFORMING_PRACT_ID,DISCR_MSR_ID,DISCR_MSR_PANEL_OR_FORM_ID,DISCR_MSR_RESULT_TYPE,DISCR_MSR_RESULT_NUM,DISCR_MSR_RESULT_NUM_UOM,DISCR_MSR_RESULT_STR,DISCR_MSR_RESULT_DATA,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW,CRITICAL_HIGH ,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,CHART_ID,RESULT_NUM_PREFIX,CONTR_MODULE_TRANS_REF,CONTR_MODULE_ID,REMARKS)	values('DM$'||to_char(sysdate,'YYYY')||'$'||lpad(CA_DISCR_MSR_SEQ.NEXTVAL,16,0),?,?,?,?,?, to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,empty_clob(),?,?,?,?,?,sysdate,?,?,?, sysdate,?,?,?,?,?,?,?)";
				String sql = "insert into CA_ENCNTR_DISCR_MSR(ACCESSION_NUM,FACILITY_ID,ENCOUNTER_ID,PATIENT_ID,PATIENT_CLASS,NORM_ABNORM_IND,TEST_OBSERV_DT_TM,PERFORMING_PRACT_ID,DISCR_MSR_ID,DISCR_MSR_PANEL_OR_FORM_ID,DISCR_MSR_RESULT_TYPE,DISCR_MSR_RESULT_NUM,DISCR_MSR_RESULT_NUM_UOM,DISCR_MSR_RESULT_STR,DISCR_MSR_RESULT_DATA,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW,CRITICAL_HIGH ,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,CHART_ID,RESULT_NUM_PREFIX,CONTR_MODULE_TRANS_REF,CONTR_MODULE_ID,REMARKS)	values("+query_accession_num+",?,?,?,?,?, to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,empty_clob(),?,?,?,?,?,sysdate,?,?,?, sysdate,?,?,?,?,?,?,?)";
				//[IN038118] End.
				
				pstmt = con.prepareStatement(sql);
				
				for(i=0;i<counter;i++)
				{
					disMsrResultType = hashRecords.get("dis_msr_type_"+i)==null ? "":(String)hashRecords.get("dis_msr_type_"+i);
					remarks = hashRecords.get("remarksField"+i)==null ? "":(String)hashRecords.get("remarksField"+i);
					resultStr="";
					resultNum="";
					
					if(disMsrResultType.equals("N")||disMsrResultType.equals("A")||disMsrResultType.equals("S")||disMsrResultType.equals("I"))
					{
						resultNum = hashRecords.get("comp_"+i)==null ? "":(String)hashRecords.get("comp_"+i);
						result_prefix = hashRecords.get("result_prefix"+i)==null ? "":(String)hashRecords.get("result_prefix"+i);
					}
					else if(disMsrResultType.equals("L"))	 
					{
						resultStr = hashRecords.get("listItemValue"+i)==null ? "":(String)hashRecords.get("listItemValue"+i);
						resultNum = hashRecords.get("comp_"+i)==null ? "": (String)hashRecords.get("comp_"+i);
					}
					else
						resultStr = hashRecords.get("comp_"+i)==null ? "":(String) hashRecords.get("comp_"+i);

					if ((!resultNum.equals(""))||(!resultStr.equals("")))
					{
						disMsrId = hashRecords.get("dis_msr_id_"+i)==null ? "":(String)hashRecords.get("dis_msr_id_"+i) ;
						uom = hashRecords.get("uom_"+i)==null ? "":(String)hashRecords.get("uom_"+i);
						normalLow = hashRecords.get("normal_low_"+i)==null ? "": (String)hashRecords.get("normal_low_"+i);
						normalHigh = hashRecords.get("normal_high_"+i)==null ? "":(String)hashRecords.get("normal_high_"+i);
						criticalLow = hashRecords.get("critical_low_"+i)==null ? "":(String)hashRecords.get("critical_low_"+i);
						criticalHigh = hashRecords.get("critical_high_"+i)==null ? "":(String)hashRecords.get("critical_high_"+i);
						normalAbnormalInd = hashRecords.get("normal_abnormal_ind_"+i)==null ? "":(String)hashRecords.get("normal_abnormal_ind_"+i);
						chartGrpId = hashRecords.get("chat_grp_id_"+i)==null ? "":(String)hashRecords.get("chat_grp_id_"+i);

						pstmt.setString(1,facilityId);
						pstmt.setString(2,encounterId);
						pstmt.setString(3,patientId);
						pstmt.setString(4,patientClass);
						pstmt.setString(5,normalAbnormalInd);
						pstmt.setString(6,recTime);
						pstmt.setString(7,practitionerId);
						pstmt.setString(8,disMsrId);
						
						pstmt.setString(9,chartGrpId);
						pstmt.setString(10,disMsrResultType);
						pstmt.setString(11,resultNum);
						pstmt.setString(12,uom);
						pstmt.setString(13,resultStr);
						pstmt.setString(14,normalLow);
						pstmt.setString(15,normalHigh);
						pstmt.setString(16,criticalLow);
						pstmt.setString(17,criticalHigh);
						pstmt.setString(18,addedById);
						pstmt.setString(19,addedAtWSNo);
						pstmt.setString(20,facilityId);
						pstmt.setString(21,addedById);
						pstmt.setString(22,addedAtWSNo);
						pstmt.setString(23,facilityId);
						pstmt.setString(24,chartId);
						pstmt.setString(25,result_prefix);
						pstmt.setString(26,contr_mod_accession_num);
						pstmt.setString(27,module_id);
						pstmt.setString(28,remarks);
						pstmt.addBatch();
					}
					
					val++;
					
//					pstmt.clearParameters();
				}				
				int [] rows = pstmt.executeBatch();		

				if(rows.length == -3)
					bUpd_status  = false;

				if(pstmt != null) pstmt.close();

				if(bUpd_status)
				{
					bool=false ;
					cs = con.prepareCall("{call CA_POST_SUM_CHART_ITEM(?,?,?,?)}");
					cs.setString(1,facilityId);
					cs.setString(2,encounterId);
					cs.setString(3,chartId);
					cs.setString(4,recTime);
					System.err.println("ChartRecordingManager.java------243------facilityId----->"+facilityId);
					System.err.println("ChartRecordingManager.java------244------encounterId----->"+encounterId);
					System.err.println("ChartRecordingManager.java------245------chartId----->"+chartId);
					System.err.println("ChartRecordingManager.java------246------recTime----->"+recTime);
					cs.execute();
					con.commit();
					if(function_from.equals("CP")&& !taskCode.equals(""))
					{
						int count = 0;
						String sql1 = " update ca_pat_task_list set  PERFORMED_DATE=sysdate ,STATUS= ?, STATUS_DATE=sysdate, PERFORMED_BY_ID=?, PERFORMED_BY_ROLE_TYPE='P',remarks=?,MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where PATIENT_ID =? and  TASK_CODE = ? and  TASK_SRL_NO = ? ";
						pstmt = con.prepareStatement(sql1);
						pstmt.setString(++count,"P");
						pstmt.setString(++count,practitionerId);
						pstmt.setString(++count,"");
						pstmt.setString(++count,addedById);
						pstmt.setString(++count,addedAtWSNo);
						pstmt.setString(++count,facilityId);
						pstmt.setString(++count,patientId);
						pstmt.setString(++count,taskCode);
						pstmt.setInt(++count,Integer.parseInt(taskSrlNo));	
						int insertSql= pstmt.executeUpdate();
						if(insertSql == 1)
						{
							con.commit();
						}
					}
					
				}
				else
				{
					bool=true;
					con.rollback();
				}
			}
			catch(Exception ee)
			{
				//con.rollback();
				bool=true;
				try
				{
					con.rollback();
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
				
				ee.printStackTrace();
				//hashRecords.clear();
				hashRecords.put("results",new Boolean(bool));
				return hashRecords;				
			}
			finally
			{
				try
				{
					if(pstmt != null) pstmt.close();
					if(cs != null) cs.close();
					if(con != null) ConnectionManager.returnConnection(con);
				}
				catch(Exception ee)
				{
				}
			}
				//hashRecords.clear();

				hashRecords.put("results",new Boolean(bool));
				return hashRecords;
		}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

		public HashMap amendErrorChartRecords(Properties p,HashMap hashRecords,String locale)
		{

			boolean bool = false;
			boolean boolError = false;
			String disMsrId = "", disMsrResultType = "",  uom = "", normalLow = "",normalHigh = "",criticalLow = "",criticalHigh = "",normalAbnormalInd ="",chartGrpId = "",resultNum="",resultStr="",result_prefix="";
			String l_error_remarks = "";//IN029155
			String errorOrReplace = "";
			String accessionNum = "";
			String errorRemarks = "";

			String chartId =  (String)	hashRecords.get("chartId")==null ? "" :(String)	hashRecords.get("chartId");
			String contr_mod_accession_num =  (String)	hashRecords.get("contr_mod_accession_num")==null ? "" :(String)	hashRecords.get("contr_mod_accession_num");
			String module_id =  (String)	hashRecords.get("module_id")==null ? "" :(String)	hashRecords.get("module_id");
			String facilityId =  (String)	hashRecords.get("facilityId")==null ? "" :(String)	hashRecords.get("facilityId");
			String encounterId =  (String)	hashRecords.get("encounterId")==null ? "" :(String)	hashRecords.get("encounterId");
			if(encounterId.equals("")) encounterId = "0";

			String patientId =  (String)	hashRecords.get("patientId")==null ? "" :(String)	hashRecords.get("patientId");
			String patientClass =  (String)	hashRecords.get("patientClass")==null ? "" :(String)	hashRecords.get("patientClass");
			String practitionerId =  (String)	hashRecords.get("practitionerId")==null ? "" :(String)	hashRecords.get("practitionerId");
			String errorMarkedByID = (String)	hashRecords.get("errorMarkedByID")==null ? "" :(String)	hashRecords.get("errorMarkedByID");
			String addedById =  (String)	hashRecords.get("addedById")==null ? "" :(String)	hashRecords.get("addedById");
			String addedAtWSNo =  (String)	hashRecords.get("addedAtWSNo")==null ? "" :(String)	hashRecords.get("addedAtWSNo");

			String count =  (String)	hashRecords.get("count")==null ? "0" :(String)	hashRecords.get("count");

			String recordedDatime =  (String)	hashRecords.get("recordedDatime")==null ? "" :(String)	hashRecords.get("recordedDatime");

//			String locale =  (String)	hashRecords.get("locale");
			boolean bUpd_status = true;
			
			int cnt = Integer.parseInt(count);
			int i = 0;
			int result = 0;
			int cntE = 0;
			int cntR = 0;

			String sql = "UPDATE CA_ENCNTR_DISCR_MSR SET ERROR_MARKED_BY_ID = ?, ERROR_MARKED_DATE = sysdate, ERROR_REMARKS = ?, ERROR_YN = 'Y' WHERE ACCESSION_NUM = ?";

			//String sqlInsert = "insert into CA_ENCNTR_DISCR_MSR(ACCESSION_NUM,FACILITY_ID,ENCOUNTER_ID,PATIENT_ID,PATIENT_CLASS,NORM_ABNORM_IND,TEST_OBSERV_DT_TM,PERFORMING_PRACT_ID,DISCR_MSR_ID,DISCR_MSR_PANEL_OR_FORM_ID,DISCR_MSR_RESULT_TYPE,DISCR_MSR_RESULT_NUM,DISCR_MSR_RESULT_NUM_UOM,DISCR_MSR_RESULT_STR,DISCR_MSR_RESULT_DATA,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW,CRITICAL_HIGH ,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,CHART_ID,RESULT_NUM_PREFIX,CONTR_MODULE_TRANS_REF,CONTR_MODULE_ID)	values('DM$'||to_char(sysdate,'YYYY')||'$'||lpad(CA_DISCR_MSR_SEQ.NEXTVAL,16,0),?,?,?,?,?, to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,empty_clob(),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?)";//IN029155
			String sqlInsert = "insert into CA_ENCNTR_DISCR_MSR(ACCESSION_NUM,FACILITY_ID,ENCOUNTER_ID,PATIENT_ID,PATIENT_CLASS,NORM_ABNORM_IND,TEST_OBSERV_DT_TM,PERFORMING_PRACT_ID,DISCR_MSR_ID,DISCR_MSR_PANEL_OR_FORM_ID,DISCR_MSR_RESULT_TYPE,DISCR_MSR_RESULT_NUM,DISCR_MSR_RESULT_NUM_UOM,DISCR_MSR_RESULT_STR,DISCR_MSR_RESULT_DATA,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW,CRITICAL_HIGH ,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO ,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,CHART_ID,RESULT_NUM_PREFIX,CONTR_MODULE_TRANS_REF,CONTR_MODULE_ID,remarks)	values('DM$'||to_char(sysdate,'YYYY')||'$'||lpad(CA_DISCR_MSR_SEQ.NEXTVAL,16,0),?,?,?,?,?, to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,empty_clob(),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?)";//IN029155

			try
			{
				try
				{
					con = ConnectionManager.getConnection(p);
					pstmt = con.prepareStatement(sql);


					if(patientClass.equals(""))
					{
						String tempSql = "select patient_class from pr_encounter where facility_id=? and 	encounter_id=? ";
						pslPrepStmt = con.prepareStatement(tempSql);
						pslPrepStmt.setString(1,facilityId);
						pslPrepStmt.setString(2,encounterId);
						rs = pslPrepStmt.executeQuery();
						while( rs.next())
						{
							patientClass = rs.getString(1) == null ? "" :  rs.getString(1);
						}
						if(pslPrepStmt != null)pslPrepStmt.close();
						if(rs != null)rs.close();
					}

					if(patientClass.equals(""))
						patientClass = "XT";

					for(i=0;i<cnt;i++)
					{					
						errorOrReplace = (String)	hashRecords.get("errorYN_"+i)==null ? "" :(String)	hashRecords.get("errorYN_"+i);

						accessionNum = (String)	hashRecords.get("accessionNum_"+i)==null ? "" :(String)	hashRecords.get("accessionNum_"+i);

						errorRemarks = (String)	hashRecords.get("error_remarks_"+i)==null ? "" :(String)	hashRecords.get("error_remarks_"+i);


						if(errorOrReplace.equals("E"))
						{
							cntE++;
						}
						else if(errorOrReplace.equals("R"))
						{
							cntR++;
						}
						
						if(errorOrReplace.equals("E") || errorOrReplace.equals("R"))
						{
							pstmt.setString(1,errorMarkedByID);
							pstmt.setString(2,errorRemarks);
							pstmt.setString(3,accessionNum);

							result = pstmt.executeUpdate();
						}
					}
					
					int k = 0;
					if(result > 0 && cntR > 0)
					{
						//practitionerId = addedById;
						boolError = true;
						
						pslPrepStmt = con.prepareStatement(sqlInsert);

						for(k=0; k<cnt; k++)
						{
							errorOrReplace = (String)	hashRecords.get("errorYN_"+k)==null ? "" :(String)	hashRecords.get("errorYN_"+k);
							disMsrId = (String)	hashRecords.get("discrMsrId_"+k)==null ? "" :(String)	hashRecords.get("discrMsrId_"+k);

							chartGrpId = (String)	hashRecords.get("discrMsrGrpId_"+k)==null ? "" :(String)	hashRecords.get("discrMsrGrpId_"+k);

							disMsrResultType = (String)	hashRecords.get("discrMsrType_"+k)==null ? "" :(String)	hashRecords.get("discrMsrType_"+k);

							resultNum = (String)	hashRecords.get("resultNum_"+k)==null ? "" :(String)	hashRecords.get("resultNum_"+k);

							resultStr = (String)	hashRecords.get("resultStr_"+k)==null ? "" :(String)	hashRecords.get("resultStr_"+k);

							uom = (String)	hashRecords.get("resultUOM_"+k)==null ? "" :(String)	hashRecords.get("resultUOM_"+k);
							normalLow = (String)	hashRecords.get("normalLow_"+k)==null ? "" :(String)	hashRecords.get("normalLow_"+k);
							normalHigh = (String)	hashRecords.get("normalHigh_"+k)==null ? "" :(String)	hashRecords.get("normalHigh_"+k);
							criticalLow = (String)	hashRecords.get("criticalLow_"+k)==null ? "" :(String)	hashRecords.get("criticalLow_"+k);
							criticalHigh = (String)	hashRecords.get("criticalHigh_"+k)==null ? "" :(String)	hashRecords.get("criticalHigh_"+k);
							normalAbnormalInd = (String)	hashRecords.get("normAbnomInd_"+k)==null ? "" :(String)	hashRecords.get("normAbnomInd_"+k);
							result_prefix = (String)	hashRecords.get("result_prefix"+k)==null ? "" :(String)	hashRecords.get("result_prefix"+k);
							l_error_remarks = (String)	hashRecords.get("error_remarks_"+k)==null ? "" :(String)	hashRecords.get("error_remarks_"+k);//IN029155

							if(errorOrReplace.equals("R"))
							{
								try
								{
									
									pslPrepStmt.setString(1,facilityId);
									pslPrepStmt.setString(2,encounterId);
									pslPrepStmt.setString(3,patientId);
									pslPrepStmt.setString(4,patientClass);
									pslPrepStmt.setString(5,normalAbnormalInd);
									pslPrepStmt.setString(6,recordedDatime);
									pslPrepStmt.setString(7,practitionerId);
									pslPrepStmt.setString(8,disMsrId);							
									pslPrepStmt.setString(9,chartGrpId);							
									pslPrepStmt.setString(10,disMsrResultType);
									pslPrepStmt.setString(11,resultNum);						
									pslPrepStmt.setString(12,uom);							
									pslPrepStmt.setString(13,resultStr);							
									pslPrepStmt.setString(14,normalLow);							
									pslPrepStmt.setString(15,normalHigh);							
									pslPrepStmt.setString(16,criticalLow);							
									pslPrepStmt.setString(17,criticalHigh);							
									pslPrepStmt.setString(18,addedById);
									pslPrepStmt.setString(19,addedAtWSNo);
									pslPrepStmt.setString(20,facilityId);
									pslPrepStmt.setString(21,addedById);
									pslPrepStmt.setString(22,addedAtWSNo);
									pslPrepStmt.setString(23,facilityId);
									pslPrepStmt.setString(24,chartId);
									pslPrepStmt.setString(25,result_prefix);
									pslPrepStmt.setString(26,contr_mod_accession_num);
									pslPrepStmt.setString(27,module_id);
									pslPrepStmt.setString(28,l_error_remarks);//IN029155
									pslPrepStmt.addBatch();
									
//									pslPrepStmt.clearParameters();
								}
								catch(Exception excep)
								{
									try
									{
										bUpd_status = false;
									}
									catch(Exception sm)
									{
									}
									
									excep.printStackTrace();
								}
							}
						}
						
						try
						{
							int nUpd [] = pslPrepStmt.executeBatch();

							if(nUpd.length == -3)
								bUpd_status = false;

							if(nUpd.length != cntR)
								bUpd_status = false;
						}
						catch (Exception eeUpd)
						{
							
							eeUpd.printStackTrace();
							bUpd_status = false;
						}
					}
					//}//end of for
				}
				catch(Exception e)
				{
					try
					{
						con.rollback();
					}
					catch(Exception ee)
					{
					}
					bool = false;
					
					e.printStackTrace();
				}

				if(bUpd_status)
				{
					try
					{
						bool=false ;
						cs = con.prepareCall("{call CA_POST_SUM_CHART_ITEM(?,?,?,?)}");
						cs.setString(1,facilityId);
						cs.setString(2,encounterId);
						cs.setString(3,chartId);
						cs.setString(4,recordedDatime);
						System.err.println("ChartRecordingManager.java------540------facilityId----->"+facilityId);
						System.err.println("ChartRecordingManager.java------541------encounterId----->"+encounterId);
						System.err.println("ChartRecordingManager.java------542------chartId----->"+chartId);
						System.err.println("ChartRecordingManager.java------543------recordedDatime----->"+recordedDatime);
						cs.execute();
						con.commit();
						bool = true;
						String error = getMessage(locale,"RECORD_INSERTED","CA");
						hashRecords.put("message", error);
					}
					catch(Exception eee)
					{
						bool = false;
						try
						{
							con.rollback();
						}
						catch(Exception c)
						{
						}
						finally
						{
							
							eee.printStackTrace();
							String error = getMessage(locale,"FAILED_TRANSACTION","CA");
							hashRecords.put("error", error);
						}
					}
				}
				if(pstmt != null) pstmt.close();
				if(cs != null) cs.close();
				if(pslPrepStmt != null) pslPrepStmt.close();
			}//end of main try
			catch(Exception except)
			{
				
				except.printStackTrace();
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,p);
			}
		hashRecords.put("results",new Boolean(bool));
		return hashRecords;
		}//end of amendErrorChartRecords

private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
} 
