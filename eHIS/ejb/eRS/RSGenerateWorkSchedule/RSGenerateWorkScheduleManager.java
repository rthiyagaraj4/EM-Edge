/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSGenerateWorkSchedule ;

import java.rmi.* ;
import java.sql.* ;
import java.util.* ;
import javax.ejb.* ;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RSGenerateWorkSchedule"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSGenerateWorkSchedule"
*	local-jndi-name="RSGenerateWorkSchedule"
*	impl-class-name="eRS.RSGenerateWorkSchedule.RSGenerateWorkScheduleManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSGenerateWorkSchedule.RSGenerateWorkScheduleLocal"
*	remote-class="eRS.RSGenerateWorkSchedule.RSGenerateWorkScheduleRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSGenerateWorkSchedule.RSGenerateWorkScheduleLocalHome"
*	remote-class="eRS.RSGenerateWorkSchedule.RSGenerateWorkScheduleHome"
*	generate= "local,remote"
*
*
*/

public class RSGenerateWorkScheduleManager implements SessionBean {
	Connection connection = null;
	CallableStatement clblstmt_gen_sched=null;
	CallableStatement clblstmt_summ=null;
	String locale	 ="";

	public RSGenerateWorkScheduleManager(){}

	public void ejbCreate() throws CreateException{}

	public void ejbRemove(){}

	public void ejbActivate(){}

	public void ejbPassivate(){}

    public void setSessionContext(SessionContext sessioncontext){
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap tabData){
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		String mess="";
		String result="N";
		//String locale	 ="";
		Properties prop =	(Properties) tabData.get("properties");

		try
		{
			String facility_id			= (String) tabData.get( "facility_id" ) ;
			String wrkPlace_code	= (String) tabData.get( "workplace_code" ) ;
			String frm_dt			= (String) tabData.get( "frm_dt" ) ;
			String to_dt			= (String) tabData.get( "to_dt" ) ;
			String locn_type		= (String) tabData.get( "locn_type" ) ;
			String user_id			= (String) tabData.get( "user_id" ) ;
			String ws_no			= (String) tabData.get( "ws_no" ) ;
			String added_date	= (String)tabData.get("added_date");
			locale= (String )tabData.get("locale");
			int totalRecords=Integer.parseInt((String)tabData.get("totalRecords")==null?"0":(String)tabData.get("totalRecords"));
			/*System.out.println("tabData 82---->"+tabData);
			System.out.println("locale in ejb:----->"+locale);*/

//			connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);

			clblstmt_summ=connection.prepareCall("{call RS_GEN_WORK_SCHEDULE_SUMM(?,?,?,?,?,?,?,?,?,?,?,?)}");

			clblstmt_summ.setString( 1, facility_id);
			clblstmt_summ.setString( 2, wrkPlace_code);
			clblstmt_summ.setString( 3, frm_dt);
			clblstmt_summ.setString( 4, to_dt);
			clblstmt_summ.setString( 5, user_id);
			clblstmt_summ.setString( 6, added_date);
			clblstmt_summ.setString( 7, ws_no);
			clblstmt_summ.setString( 8, facility_id);
			clblstmt_summ.setString( 9, user_id);
			clblstmt_summ.setString( 10, added_date);
			clblstmt_summ.setString( 11, ws_no);
			clblstmt_summ.setString( 12, facility_id);

			clblstmt_summ.execute();

				if(clblstmt_summ != null)
					clblstmt_summ.close();
				for(int i=0;i<totalRecords;i++){

				HashMap TabDataTemp		= (HashMap )tabData.get("InsertData"+i);

					String role_type		= (String) TabDataTemp.get( "role_type" ) ;
					String staff_id			= (String) TabDataTemp.get( "staff_id" ) ;
					String staff_eff_dt_frm	= (String) TabDataTemp.get( "staff_eff_dt_frm" ) ;
					String staff_eff_dt_to	= (String) TabDataTemp.get( "staff_eff_dt_to" ) ;
					String staff_type		= (String) TabDataTemp.get( "staff_type" ) ;
					String position_code			= (String) TabDataTemp.get( "position_code" ) ;
					
					//locale= (String )tabDataTemp.get("locale");

					/*System.out.println("role_type in ejb 116--->"+role_type);
					System.out.println("staff_id	 in ejb 117--->"+staff_id	);
					System.out.println("staff_eff_dt_frm in ejb 118--->"+staff_eff_dt_frm);
					System.out.println("staff_eff_dt_to in ejb 119--->"+staff_eff_dt_to);
					System.out.println("position_code in ejb 120--->"+position_code);
					//System.out.println("locale in ejb:----->"+locale);*/


					clblstmt_gen_sched=connection.prepareCall("{call RS_GENERATE_WORK_SCHEDULE( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					clblstmt_gen_sched.setString( 1, facility_id);
					clblstmt_gen_sched.setString( 2, wrkPlace_code);
					clblstmt_gen_sched.setString( 3, frm_dt);
					clblstmt_gen_sched.setString( 4, to_dt);
					clblstmt_gen_sched.setString( 5, locn_type);
					clblstmt_gen_sched.setString( 6, role_type);
					clblstmt_gen_sched.setString( 7, staff_id);
					clblstmt_gen_sched.setString( 8, staff_eff_dt_frm);
					clblstmt_gen_sched.setString( 9, staff_eff_dt_to);
					clblstmt_gen_sched.setString( 10, staff_type);
					clblstmt_gen_sched.setString( 11, position_code);
					clblstmt_gen_sched.setString( 12, user_id);
					clblstmt_gen_sched.setString( 13, ws_no);

					clblstmt_gen_sched.registerOutParameter(14, Types.VARCHAR );
					clblstmt_gen_sched.registerOutParameter(15, Types.VARCHAR );
					clblstmt_gen_sched.execute();

					result=clblstmt_gen_sched.getString(14)==null?"N":clblstmt_gen_sched.getString(14);
					mess=clblstmt_gen_sched.getString(15)==null?"":clblstmt_gen_sched.getString(15);
					System.out.println("result in ejb:----->"+result);
					System.out.println("mess in ejb:----->"+mess);

					if (result.equals("N")) {
						break;
					}
				}

			if (result.equals("N")) {
				connection.rollback();
				messages.append(mess);
			} else if (result.equals("Y")) {
				connection.commit() ;
				retMap.put( "result", new Boolean( true ) ) ;

            //Hashtable massageMap = MessageManager.getMessage(connection,"RECORD_INSERTED");
			Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_INSERTED","RS");
		   messages.append((String)massageMap.get("message"));
			//System.out.println("result----->"+result);
			}


			}catch( Exception e ) {
				messages.append( e.getMessage() ) ;
				Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
				messages.append((String)massageMap.get("message"));
				e.printStackTrace() ;
			}finally {
					try {
						if ( clblstmt_gen_sched != null ) {
							clblstmt_gen_sched.close() ;
						}if(connection != null) {
							//closeConnection(connection,(Properties)tabData.get( "properties" ));
							ConnectionManager.returnConnection(connection,prop);

						}
					}catch ( Exception fe ) {
						fe.printStackTrace() ;
					}
			}
		retMap.put( "message", messages.toString());
		return retMap;

	}// end of insert
}
