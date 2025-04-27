/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package blopin;
import java.io.* ;
import java.sql.* ;
import javax.rmi.*;
import java.util.*;
import java.sql.* ;
import java.net.*;

import webbeans.eCommon.*;

public class BLOPCancelVisit
{
	public java.util.Hashtable billPatientService( Properties p,Connection con, Hashtable tabdata)
	{

//		PreparedStatement stmt ;

		CallableStatement statement;
		Statement stmt3=null ;
		ResultSet rs  =null;

//		String err_out="";
//		String strVisitMessage = "";
		String strBillGenYN = "";
		String strBillDocNumber ="";
		String strBillDocTypeCode="";
		String strBillMessage = "";
		String strFinalMessage ="";

		String locale="";

		String error_level="";
		String sys_message_id  ="";
		String error_text  = "";

		String strEpisodeType = "";
//		String strPatientId="";
//		String strFacilityId="";
//		String encounterid="";
		boolean insertable = true;
		StringBuffer sb = new StringBuffer( "" ) ;
		java.util.Hashtable results = new java.util.Hashtable() ;
		Hashtable messageHashtable=new Hashtable();

//		boolean result=false;
		String  strBLInterface ="N";
		String 	strUser = p.getProperty("login_user");
		String 	strWsNo = p.getProperty("client_ip_address");
		String strBLInstalledYN = "N";
		String strHospChrgCncl = "Y";
		String strMedChrgCncl = "Y";
		String strAddlChrgCncl = "Y";
//		String policy_type_code = "";
		

		int intVisitNum = 0;
		long intEpisodeNum = 0;
		long intEncounterId=0;
		String strAccSeqNo="";
		int intAcctSeqNo=0;

		strBLInstalledYN  = (String)tabdata.get("bl_installed_yn");
		if (strBLInstalledYN == null)
		{
			strBLInstalledYN ="Y";
		}

		if (strBLInstalledYN.equals(""))
		{
			strBLInstalledYN ="N";
		}

		strBLInterface = (String)tabdata.get("bl_interfaced_yn");

		strEpisodeType = (String) tabdata.get("episode_type");

		if (strEpisodeType == null)
		{
			strEpisodeType="O";
		}

		if (strEpisodeType.equals(""))
		{
			strEpisodeType="O";
		}

		locale=(String) tabdata.get("locale");
		if(locale==null) locale="en";

		insertable = true;
	//	if(p_count <= 0)

		try
		{

			if (strBLInstalledYN.equals("Y"))
			{
			
				intVisitNum = Integer.parseInt((String) tabdata.get("visit_id"));
				intEpisodeNum = Long.parseLong((String) tabdata.get("episode_id"));		
				intEncounterId=Long.parseLong((String) tabdata.get("encounter_id"));		

				try
				{						
					CallableStatement callablestatement = con.prepareCall("{call BL_UPD_FIN_DTLS_ON_CANCEL( ?,?,?,?,?,?,?,?,?,?,?)}");
					//callablestatement.setString(1, (String)tabdata.get("I"));
					//callablestatement.setString(2, (String)tabdata.get("CANCEL_VISIT"));
					callablestatement.setString(1, (String)tabdata.get("patient_id"));
					callablestatement.setLong(2,intEpisodeNum);
					callablestatement.setInt(3, intVisitNum);
					//callablestatement.setString(4, "O");
					callablestatement.setString(4, strEpisodeType);
					callablestatement.setLong(5, intEncounterId);
					callablestatement.setString(6, strUser);
					callablestatement.setString(7, (String)tabdata.get("facility_id"));
					callablestatement.setString(8, strWsNo);
					callablestatement.registerOutParameter(9, java.sql.Types.VARCHAR);
					callablestatement.registerOutParameter(10, java.sql.Types.VARCHAR);
					callablestatement.registerOutParameter(11, java.sql.Types.VARCHAR);

					callablestatement.execute();


					error_level=callablestatement.getString(9);
					sys_message_id  = callablestatement.getString(10);
					error_text  = callablestatement.getString(11);
					
					if(error_level==null || error_level.equals("")) error_level="";
					if(sys_message_id==null || sys_message_id.equals("")) sys_message_id="";
					if(error_text==null || error_text.equals("")) error_text="";

					callablestatement.close();
				}
				catch(Exception exception8)
				{
					sb.append(" Error : while calling UPD_BL_FIN_DTLS_ON_CANCEL"+exception8.getMessage());
					insertable = false;
				}

				try
				{
					String acc_seq_no_sql="select NVL(CUR_ACCT_SEQ_NO,0)  from bl_visit_fin_Dtls where OPERATING_FACILITY_ID='"+(String)tabdata.get("facility_id")+"' AND EPISODE_TYPE ='"+strEpisodeType+"' AND EPISODE_ID="+intEpisodeNum+" AND VISIT_ID ="+intVisitNum+" AND PATIENT_ID  ='"+(String)tabdata.get("patient_id")+"'";

					stmt3 = con.createStatement();
					rs = stmt3.executeQuery(acc_seq_no_sql) ;
					if( rs != null ) 
					{
						while( rs.next() )
						{  
							strAccSeqNo= rs.getString(1);
						}
					}
					stmt3.close();
					if(rs != null) rs.close();
						
					if(strAccSeqNo==null || strAccSeqNo.equals("")) strAccSeqNo="0";

					intAcctSeqNo=Integer.parseInt(strAccSeqNo);

//					System.out.println("intAcctSeqNo:"+intAcctSeqNo);
				}
				catch(Exception e)
				{
					System.out.println("Exception in Acc Seq No:"+e);
				}
/*
				policy_type_code = (String)tabdata.get("policy_type_code");
                if((insertable == true) && (policy_type_code != null))
                {
                    policy_type_code = (String)tabdata.get("policy_type_code");
                    if(policy_type_code != null)

					try
					{
						try
                        {
							CallableStatement callablestatement1 = con.prepareCall("{call INS_UPD_BL_INS_PREAPP( ?,?,?,?,?,?,?,?,?,?,?)}");
                            callablestatement1.setString(1, "D");
                            callablestatement1.setString(2, (String)tabdata.get("patient_id"));
                            //   callablestatement1.setString(3, "O");
							callablestatement1.setString(3,strEpisodeType);
                            callablestatement1.setInt(4, intEpisodeNum);
                            callablestatement1.setInt(5, intVisitNum);
                            callablestatement1.setString(6, (String)tabdata.get("policy_type_code"));
                            callablestatement1.setString(7, (String)tabdata.get("cust_code"));
                            callablestatement1.setString(8, strUser);
                            callablestatement1.setString(9, (String)tabdata.get("facility_id"));
                            callablestatement1.setString(10, strWsNo);
                            callablestatement1.registerOutParameter(11, java.sql.Types.VARCHAR);
                            callablestatement1.execute();
            
							err_out = callablestatement1.getString(11);
							callablestatement1.close();
						}
                        catch(Exception exception9)
                        {
							insertable = false;
                            sb.append(exception9.getMessage() + "here1");
                        }
                        if((insertable == true) && ((String)tabdata.get("policy_type_code") != null))
                        {
                            try
                            {
								try
                                {
									CallableStatement callablestatement2 = con.prepareCall("{call INS_UPD_BL_INS_POLICY_ADDL( ?,?,?,?,?,?,?,?,?,?,?)}");
                                    callablestatement2.setString(1, "D");
                                    callablestatement2.setString(2, (String)tabdata.get("patient_id"));
                                    //callablestatement2.setString(3, "O");
									callablestatement2.setString(3, strEpisodeType);
                                    callablestatement2.setInt(4, intEpisodeNum);
                                    callablestatement2.setInt(5, intVisitNum);
                                    callablestatement2.setString(6, (String)tabdata.get("policy_type_code"));
                                    callablestatement2.setString(7, (String)tabdata.get("cust_code"));
                                    callablestatement2.setString(8, strUser);
                                    callablestatement2.setString(9, (String)tabdata.get("facility_id"));
									callablestatement2.setString(10, strWsNo);
                                    callablestatement2.registerOutParameter(11, java.sql.Types.VARCHAR);
                                    callablestatement2.execute();

                                    err_out = callablestatement2.getString(11);
									callablestatement2.close();
                                }
                                catch(Exception exception10)
                                {
									insertable = false;
                                    sb.append(" INS_UPD_BL_INS_POLICY_ADDL ="+exception10.getMessage());
								}
                                if(err_out.equals("0"))
                                {
                                    insertable = true;
                                }
								else
                                {
                                    insertable = false;
                                    sb.append("Err is " + err_out);
                                }
                            }
                            catch(Exception exception11)
                            {
                                sb.append("Exception @ Callable Statement" + exception11);
                            }
						} 
					}
					catch(Exception exception12)
                    {
						sb.append("Exception @ Callable Statement" + exception12);
                    }
				}
*/
			}// If BL is installed
		}
        catch(Exception exception13)
        {
			sb.append("Exception @ Callable Statement" + exception13);
		}

		try
		{
			if ((insertable==true)&& strBLInterface.equals("Y"))
			{
				// Added for WS by IP Address/Name

				String str_ws_by_ip_name = "";
				String str_facility_id = ((String) tabdata.get("facility_id"));
				String sqlst1="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+str_facility_id+"'";
				PreparedStatement pst1=con.prepareStatement(sqlst1);
				ResultSet rst1 = pst1.executeQuery();
				if (rst1!=null)
				{
					if (rst1.next())
				    {
						str_ws_by_ip_name = rst1.getString("ws_by_ip_name");
				    }
				}
				pst1.close();
				if(rst1 != null) rst1.close();
				if ( str_ws_by_ip_name == null ) str_ws_by_ip_name ="";

					// End for WS by IP Adress/Name
				String p_machine_name = "";

				if (str_ws_by_ip_name.equals("I"))
				{				
					p_machine_name = InetAddress.getByName((String) strWsNo).getHostName() ;
				}
				else
				{
					p_machine_name = ((String) strWsNo );
				}


				String sql_cancel_visit="{call blvisitcancel.proc_cancel_main('D','CANCEL_VISIT','"+(String)tabdata.get("facility_id")+"','"+(String) tabdata.get("patient_id")+"',"+intEpisodeNum+","+intVisitNum+",'"+strEpisodeType+"',"+intEncounterId+","+intAcctSeqNo+",'"+strUser+"','"+strWsNo+"','"+p_machine_name+"','"+strHospChrgCncl+"','"+strMedChrgCncl+"','"+strAddlChrgCncl+"',?,?,?,?,?,?,?)}";

//				System.out.println("sql_cancel_visit:"+sql_cancel_visit);
					
				statement=con.prepareCall(sql_cancel_visit);
	/*
				statement=con.prepareCall("{call bl_op_cancel.proc_cancel_main(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				statement.setString( 1,"D");
				statement.setString( 2,"CANCEL_VISIT");
				statement.setString( 3,(String)tabdata.get("facility_id"));
				statement.setString( 4, (String) tabdata.get("patient_id"));
				statement.setInt( 5, intEpisodeNum);
				statement.setInt( 6, intVisitNum);
				statement.setString( 7, strEpisodeType);
				statement.setString( 8, intEncounterId);//newly added
				statement.setString( 9, intAcctSeqNo);//newly added
				statement.setString( 10, strUser);	
				statement.setString( 11, strWsNo);
				statement.setString( 12,p_machine_name);				
	*/
				statement.registerOutParameter( 1, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 2, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 3, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 4, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 5, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 6, java.sql.Types.VARCHAR);
				statement.registerOutParameter( 7, java.sql.Types.VARCHAR);

				statement.execute();

				strBillGenYN = statement.getString(1);
				if(strBillGenYN==null) strBillGenYN="";
				strBillDocTypeCode = statement.getString(2);
				if(strBillDocTypeCode==null) strBillDocTypeCode="";
				strBillDocNumber = statement.getString(3);
				if(strBillDocNumber==null) strBillDocNumber="";
				strBillMessage =  statement.getString(4);
				if(strBillMessage==null) strBillMessage="";
					
				error_level=statement.getString(5);
				sys_message_id  = statement.getString(6);
				error_text  = statement.getString(7);
					
				if(error_level==null || error_level.equals("")) error_level="";
				if(sys_message_id==null || sys_message_id.equals("")) sys_message_id="";
				if(error_text==null || error_text.equals("")) error_text="";

//				System.out.println("strBillGenYN:"+strBillGenYN);
//				System.out.println("strBillDocTypeCode:"+strBillDocTypeCode);
//				System.out.println("strBillDocNumber:"+strBillDocNumber);
//				System.out.println("strBillMessage:"+strBillMessage);
//				System.out.println("error_level:"+error_level);
//				System.out.println("sys_message_id:"+sys_message_id);
//				System.out.println("error_text:"+error_text);
	/*				
				if (strErrMsg != null )
				{
					if (!strErrMsg.equals(""))
					{
						insertable=false;
						sb.append("BLOPCancelVisit: Error Code "+strErrMsg);
						con.rollback();
						con.setAutoCommit(true);
						}
				}
				if (strErrText != null )
				{
					if (!strErrText.equals(""))
					{
						insertable=false;
						sb.append("BLOPCancelVisit: Error Text "+strErrText);
						con.rollback();
						con.setAutoCommit(true);
					}
				}
	*/
				if(  (!sys_message_id.equals(""))  || (error_level.equals("10") && !error_text.equals("") ) )
				{	
					insertable=false;
	
					if((error_level.equals("10") && !error_text.equals("") ))
					{
						sb.append("<br>"+error_text+"<br> ") ;
//						System.out.println("sb mesage in Error is:"+sb);
						con.rollback();
						con.setAutoCommit(true);
					}
					else
					{
						messageHashtable=MessageManager.getMessage(locale,sys_message_id,"BL");
						sb.append((String)messageHashtable.get("message"));
//						System.out.println("sb mesage in sys_message is:"+sb);
						con.rollback();
						con.setAutoCommit(true);
					}
					statement.close();
				}
			
				if (strBillGenYN == null || strBillGenYN.equals(""))
				{
					strBillGenYN = "N";
				}
				if (strBillGenYN.equals("Y"))
				{
					strFinalMessage = strBillMessage;
				}
				else
				{
					strFinalMessage = "";
				}		
				try
				{
					if (statement != null)
					{
						statement.close();
					}
				}
				catch(Exception stmtclose)
				{
				}
			}	// End if for the 'BL' install interface check	
		} // End of Try Block in Calculation of VisitCharge
		catch(Exception except)
		{
			insertable=false;
			sb.append("BLOPCancelVisit: Exception Error Text  "+except);
		}
//ENDS HERE
		if(  ( strFinalMessage == null) || (strFinalMessage.equals(""))  )
		{
			strFinalMessage = " ";
		}
        results.put( "status", new Boolean(insertable) ) ;
        results.put( "error", sb.toString() ) ;
        results.put( "message",strFinalMessage);
        return results ;
    }

	private PreparedStatement setData(PreparedStatement stmt,Object[] obj)
    {
		try
        {
			for(int i=0;i<obj.length;i++)
            {
				if(obj[i] instanceof java.sql.Date)
                {
					if (obj[i] instanceof java.sql.Date  )
						stmt.setDate((i+1),(java.sql.Date)obj[i]);
                }

				if(obj[i] instanceof String)
                {
                    if(((String)obj[i]).equalsIgnoreCase("null"))
                        stmt.setString((i+1),null);
                    else if((String)obj[i] == null)
                        stmt.setString((i+1),null);
                    else
                        stmt.setString((i+1),(String)obj[i]);
                }

                if(obj[i] instanceof Integer)
                {
                    stmt.setInt((i+1),(((Integer)obj[i]).intValue()));
                }

                if(obj[i] instanceof Long)
                {
                    stmt.setLong((i+1),(  ((Long)obj[i]).longValue() ));
                }

                if(obj[i] instanceof Double)
                {
                    stmt.setDouble((i+1),( ((Double)obj[i]).doubleValue()) );
                }

				if(obj[i] instanceof Float)
                {
                    stmt.setFloat((i+1),(((Float)obj[i]).floatValue()));
                }
			}
		}
        catch(Exception e)
		{
			e.printStackTrace();
		}
        return(stmt);
	}
}
	
	
