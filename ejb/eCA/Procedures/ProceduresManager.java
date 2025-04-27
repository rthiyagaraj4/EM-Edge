/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.Procedures;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;
import java.util.Properties;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
 
/**
*
* @ejb.bean
*	name="ProceduresManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ProceduresManager"
*	local-jndi-name="ProceduresManager"
*	impl-class-name="eCA.Procedures.ProceduresManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.Procedures.ProceduresManagerLocal"
*	remote-class="eCA.Procedures.ProceduresManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.Procedures.ProceduresManagerLocalHome"
*	remote-class="eCA.Procedures.ProceduresManagerHome"
*	generate= "local,remote"
*
*
*/

public class ProceduresManager implements SessionBean 
{
    public void ejbCreate() {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) {context=context;}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertProcedure(
                            java.util.Properties p,
                            String temp_encounter_id,
                            String practitioner_id,
                            String patient_id,
                            String proc_code,
                            String proc_date,
                            String record_type,
                            String cause_indicator,
                            String proc_code_scheme,
                            String proc_narration,
                            String hpi,
                            String proc_summary,
                            String findings,
                            String impression,
                            String disposition,
                            String added_at_ws_no,
                            String added_facility_id,
                            String patient_class,
                            String order_id,
                            String order_line_num,
							String	enddate,					
							String	practitioner1,			    
							String	anaesthetists1,		    
							String	anaesthetists2,		    
							String	anaesthetists3,		    
							String	scrubnurse,			    
							String	anaesthesia,			    
							String	anaesthesDet,		    
							String	indication,				    
							String	monitor,					    
							String	events	,					    
							String	postProcedure,		    
							String	specimen,				    
							String	locale,
							String  laterality,
							String  location,
							String  practitioner2,
							String  accession_number,
							String classifition_type // 36285
                         ) 
        {

	    Connection con			= null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt1=null;

		long encounter_id=Long.parseLong(temp_encounter_id);

        java.util.HashMap results = new java.util.HashMap() ;

        boolean result = false ;
        boolean insertable = true ;
        StringBuffer sb = new StringBuffer( "" ) ;
        int srl_no=0;
		//String sql = "insert into   pr_encounter_procedure(facility_id,encounter_id,srl_no, practitioner_id,patient_id, proc_code,proc_date, record_type,cause_indicator,proc_code_scheme, proc_narration,hpi, proc_summary,findings, impression,disposition,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,patient_class,order_id,order_line_num, start_datetime,end_datetime ,  ass_practitioner1,  ass_practitioner2, anaesthetist1, anaesthetist2,  anaesthetist3, anaesthesia_code, anaesthesia_detail, indication, monitoring, events,post_proc_std_orders, specimen_sent, scrub_nurse, LATERALITY_IND, PROC_PERF_LOCN_CODE, ASS_PRACTITIONER3, PROC_PERF_FACILITY,ORDER_CATEGORY,CONTR_MOD_ID,ACCESSION_NUM,CODE_EXTN_YN) values (?, ?, ?, ?, ?, ?, TO_DATE(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?,?,TO_DATE(?,'DD/MM/YYYY hh24:mi'),TO_DATE(?,'DD/MM/YYYY hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
		String sql = "insert into   pr_encounter_procedure(facility_id,encounter_id,srl_no, practitioner_id,patient_id, proc_code,proc_date, record_type,cause_indicator,proc_code_scheme, proc_narration,hpi, proc_summary,findings, impression,disposition,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,patient_class,order_id,order_line_num, start_datetime,end_datetime ,  ass_practitioner1,  ass_practitioner2, anaesthetist1, anaesthetist2,  anaesthetist3, anaesthesia_code, anaesthesia_detail, indication, monitoring, events,post_proc_std_orders, specimen_sent, scrub_nurse, LATERALITY_IND, PROC_PERF_LOCN_CODE, ASS_PRACTITIONER3, PROC_PERF_FACILITY,ORDER_CATEGORY,CONTR_MOD_ID,ACCESSION_NUM,CODE_EXTN_YN,CLASSIFITION_TYPE) values (?, ?, ?, ?, ?, ?, TO_DATE(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?,?,TO_DATE(?,'DD/MM/YYYY hh24:mi'),TO_DATE(?,'DD/MM/YYYY hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;

        String SrlnoGeneratorSql = "select NVL(max(srl_no),0)+1  from pr_encounter_procedure where facility_id=? and encounter_id=?" ;
        String InvalidCodeSql ="";

        proc_code_scheme = (proc_code_scheme==null)?"":proc_code_scheme ;
        order_id = (order_id==null)?"":order_id ;

        if(proc_code_scheme.equals("3")){
            InvalidCodeSql="Select short_desc from mr_cpt_code where cpt_code = ?";
        }else if(proc_code_scheme.equals("4") || proc_code_scheme.equals("6")){
                InvalidCodeSql ="Select short_desc,record_type,cause_indicator from mr_icd_code where record_type='O' and diag_code = ?";
		}

        String addedById = p.getProperty( "login_user" ) ;
        //String addedDate = dateFormat.format( new java.util.Date() ) ;
      //  Date added_date = Date.valueOf( addedDate ) ;

try
    {
		//PreparedStatement code_stmt = null;
		//ResultSet code_rs = null,rs = null;
		con=ConnectionManager.getConnection(p);
      /*  try
            {

                con=ConnectionManager.getConnection(p);

                code_stmt=con.prepareStatement(InvalidCodeSql);
				code_stmt.setString(1, proc_code);
                code_rs=code_stmt.executeQuery();
                boolean code_boolean=false;
                if(code_rs!=null)
                {
                    if(code_rs.next())
                    {
                        if(code_rs.getString(1).trim().equalsIgnoreCase(proc_narration))
                            code_boolean=true;
                    }

                }

                if(!code_boolean)
				{
                    insertable = false;
                    final java.util.Hashtable message = MessageManager.getMessage(con, "INVALID_PROC_CODE" ) ;
                    sb.append( (String) message.get("message") ) ;
                }
            }
            catch ( Exception e )
            {

                    sb.append(e.toString()) ;
                try
                {
                    con.rollback();
                }
                catch(Exception ce){ce.printStackTrace();}
                insertable = false ;

            }

			finally{
				try{
					if(code_rs!=null) code_rs.close();
					if(rs!=null) rs.close();
					if(code_stmt!=null) code_stmt.close();
					if(pstmt!=null) pstmt.close();
				}catch(Exception e){e.printStackTrace();}
			}
		*/
        if ( insertable )
        {
			ResultSet no_gen = null;
            try
            {
                /*code that generates srl_no starts here*/
                pstmt1=con.prepareStatement(SrlnoGeneratorSql );
				pstmt1.setString(1,added_facility_id);
                pstmt1.setLong (2,encounter_id);
                no_gen=pstmt1.executeQuery();
                no_gen.next();
                srl_no=no_gen.getInt(1);
								
            }
            catch(Exception e)
            {
                    sb.append(e.toString()) ;
                try
                {
                    con.rollback();
                }
                catch(Exception ce){
                        sb.append("Generator"+e);
                }
            }

			finally{
				try{
					if(no_gen!=null) no_gen.close();
					if(pstmt1!=null) pstmt1.close();
				}catch(Exception e){e.printStackTrace();}
			}

            try
            {
   
				/*code that inserts record/s starts here*/
                pstmt = con.prepareStatement( sql );
                pstmt.setString ( 1, added_facility_id ) ;
                pstmt.setLong   ( 2, encounter_id ) ;
                pstmt.setInt    ( 3, srl_no  ) ;
                pstmt.setString ( 4, practitioner_id ) ;
                pstmt.setString ( 5, patient_id ) ;
                pstmt.setString ( 6, proc_code ) ;
                pstmt.setString ( 7, proc_date ) ;
                pstmt.setString ( 8, record_type ) ;
                pstmt.setString ( 9, cause_indicator ) ;
                pstmt.setString ( 10, proc_code_scheme ) ;
                pstmt.setString ( 11, proc_narration ) ;
                pstmt.setString ( 12, hpi ) ;
                pstmt.setString ( 13, proc_summary ) ;
                pstmt.setString ( 14, findings ) ;
                pstmt.setString ( 15, impression ) ;
                pstmt.setString ( 16, disposition ) ;
                pstmt.setString ( 17, addedById ) ;
                pstmt.setTimestamp( 18,new  java.sql.Timestamp(System.currentTimeMillis())) ;
                pstmt.setString ( 19, added_at_ws_no ) ;
                pstmt.setString ( 20, added_facility_id ) ;
                pstmt.setString ( 21, addedById ) ;
                pstmt.setTimestamp( 22,new  java.sql.Timestamp(System.currentTimeMillis())) ;
                pstmt.setString ( 23, added_at_ws_no ) ;
                pstmt.setString ( 24, added_facility_id ) ;
                pstmt.setString ( 25, patient_class) ;
                pstmt.setString ( 26, order_id ) ;
                pstmt.setString ( 27, order_line_num) ;
                pstmt.setString ( 28, proc_date ) ;
                pstmt.setString ( 29, enddate ) ;
                pstmt.setString ( 30, practitioner_id) ;
                pstmt.setString ( 31, practitioner1 ) ;
                pstmt.setString ( 32, anaesthetists1) ;
                pstmt.setString ( 33, anaesthetists2 ) ;
                pstmt.setString ( 34, anaesthetists3 ) ;
                pstmt.setString ( 35, anaesthesia) ;
                pstmt.setString ( 36, anaesthesDet ) ;
                pstmt.setString ( 37, indication) ;
                pstmt.setString ( 38, monitor ) ;
                pstmt.setString ( 39, events ) ;
                pstmt.setString ( 40, postProcedure) ;
                pstmt.setString ( 41, specimen ) ;
                pstmt.setString ( 42, scrubnurse) ;
                pstmt.setString ( 43, laterality) ;
                pstmt.setString ( 44, location) ;
                pstmt.setString ( 45, practitioner2) ;
                pstmt.setString ( 46, added_facility_id) ;
				if(!order_id.equals(""))
				{
					pstmt.setString ( 47, order_id.substring(0,2)) ;
					pstmt.setString ( 48, "OR") ;
					pstmt.setString ( 49, order_line_num+"#"+order_id) ;
				}
				else
				{
					pstmt.setString ( 47, "") ;
					pstmt.setString ( 48, "") ;
					pstmt.setString ( 49, accession_number) ;
				}
				pstmt.setString ( 50, "N") ;
			    pstmt.setString (51, classifition_type);// 36285


                int res = pstmt.executeUpdate() ;
                if ( res >= 0 )
                {
                    result = true ;
                    con.commit() ;

                final java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
                sb.append( (String) message.get("message") ) ;
				message.clear();

                }
                else{
					con.rollback();
                    final java.util.Hashtable message = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
					//sb.append("sql Without insert:+"+sql) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
					}
            }
            catch ( Exception e ) {

            try
                {
                    con.rollback();
                }
                catch(Exception ce){ce.printStackTrace();}
                sb.append(e.getMessage() + "<br>" ) ;
                e.printStackTrace() ;
            }

			finally{
				try{
					if(pstmt!=null) pstmt.close();
				}catch(Exception e){e.printStackTrace();}
			}

            /* To build a string to insert into pr_encounter_detail*/

       }

        results.put( "status", new Boolean(result) ) ;
        results.put( "error", sb.toString() ) ;
		
        //return results ;

    }   //End of the try outer block
    catch(Exception ce)
    {
		ce.printStackTrace() ;
        sb.append(ce.toString()) ;
        results.put( "status", new Boolean(result) ) ;
        results.put( "error", sb.toString() ) ;
        //return results ;

    }
    finally
    {
              if (con != null)
              {
               try {
                    ConnectionManager.returnConnection(con, p);
                    }
                catch (Exception ee) {ee.printStackTrace();}
             }
    }
	return results;
}//End of the method

//for Update

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap updateProcedure(
							java.util.Properties p,
                            String encounter_id,
                            String practitioner_id,
                            String patient_id,
                            String proc_code,
                            String proc_date,
                            String proc_narration,
                            String hpi,
                            String proc_summary,
                            String findings,
                            String impression,
                            String disposition,
                            String modified_at_ws_no,
                            String modified_facility_id,
							String modified_by_id,
							String srl_no,
							String	enddate,					
							String	practitioner1,			    
							String	anaesthetists1,		    
							String	anaesthetists2,		    
							String	anaesthetists3,		    
							String	scrubnurse,			    
							String	anaesthesia,			    
							String	anaesthesDet,		    
							String	indication,				    
							String	monitor,					    
							String	events	,					    
							String	postProcedure,		    
							String	specimen,
							String	errorRemarks,
							String  locale,
							String  laterality,
							String  location,
							String  practitioner2 ,
							String  accession_number,
							String classifition_type// 36285

                            )
	{
	
	
	    Connection con			= null;
    PreparedStatement pstmt =null;

	java.util.HashMap results = new java.util.HashMap() ;
    boolean result = false ;
   // boolean insertable = true ;
    StringBuffer sb = new StringBuffer( "" ) ;
	//ss
	String ERROR_MARKED_BY_ID   ="";  
//	java.sql.Date  ERROR_MARKED_DATE      =null;
	String ERROR_REMARKS          ="";
	String ERROR_YN               ="N";
	String curr_status = "M";
    Statement stmt =null;
	ResultSet rs1=null;
	//se
	try{
				con		= ConnectionManager.getConnection(p);
		      /*  stmt=con.createStatement();
                rs1=stmt.executeQuery("select to_char(sysdate,'yyyy-mm-dd') d from dual ");
                rs1.next();
				
                java.sql.Date sys_date = rs1.getDate("d");*/
               				
					if(!errorRemarks.equals("")){
								 ERROR_MARKED_BY_ID   =modified_by_id;  
								// ERROR_MARKED_DATE      =sys_date;
								 ERROR_REMARKS          =errorRemarks;
								 ERROR_YN               ="Y";
								 
					}else{

					}
					

                 //String update_query = "update pr_encounter_procedure set proc_code = ?, proc_narration = ?, proc_date = to_date(?,'dd/mm/yyyy hh24:mi'), practitioner_id = ?, hpi = ?, proc_summary = ?, findings = ?, impression = ?, disposition = ?, modified_by_id = ?, modified_date = sysdate, modified_facility_id = ? , modified_at_ws_no = ? , start_datetime=to_date(?,'dd/mm/yyyy hh24:mi'), end_datetime=to_date(?,'dd/mm/yyyy hh24:mi') ,  ass_practitioner1=?,  ass_practitioner2=?, anaesthetist1=?, anaesthetist2=?,  anaesthetist3=?, anaesthesia_code=?, anaesthesia_detail=?, indication=?, monitoring=?, events=?, post_proc_std_orders=?, specimen_sent=?, scrub_nurse=?,  error_marked_by_id=?,  error_marked_date=sysdate,  error_remarks=?,  error_yn=?, LATERALITY_IND=?, PROC_PERF_LOCN_CODE=?, ASS_PRACTITIONER3=?, CURR_STATUS=?  where patient_id = ? and srl_no = ? and encounter_id = ? and facility_id = ?";
					String update_query = "update pr_encounter_procedure set proc_code = ?, proc_narration = ?, proc_date = to_date(?,'dd/mm/yyyy hh24:mi'), practitioner_id = ?, hpi = ?, proc_summary = ?, findings = ?, impression = ?, disposition = ?, modified_by_id = ?, modified_date = sysdate, modified_facility_id = ? , modified_at_ws_no = ? , start_datetime=to_date(?,'dd/mm/yyyy hh24:mi'), end_datetime=to_date(?,'dd/mm/yyyy hh24:mi') ,  ass_practitioner1=?,  ass_practitioner2=?, anaesthetist1=?, anaesthetist2=?,  anaesthetist3=?, anaesthesia_code=?, anaesthesia_detail=?, indication=?, monitoring=?, events=?, post_proc_std_orders=?, specimen_sent=?, scrub_nurse=?,  error_marked_by_id=?,  error_marked_date=sysdate,  error_remarks=?,  error_yn=?, LATERALITY_IND=?, PROC_PERF_LOCN_CODE=?, ASS_PRACTITIONER3=?, CURR_STATUS=? ,CLASSIFITION_TYPE = ? where patient_id = ? and srl_no = ? and encounter_id = ? and facility_id = ?";

					pstmt	=	con.prepareStatement(update_query);
					pstmt.setString(1,  proc_code);
					pstmt.setString(2,  proc_narration);
					pstmt.setString(3,  proc_date);
					pstmt.setString(4,  practitioner_id);
					pstmt.setString(5,  hpi);
					pstmt.setString(6,  proc_summary);
					pstmt.setString(7,  findings);
					pstmt.setString(8,  impression);
					pstmt.setString(9,  disposition);
					pstmt.setString(10, modified_by_id);
					pstmt.setString(11, modified_facility_id);
					pstmt.setString(12, modified_at_ws_no);
				//ss
					pstmt.setString ( 13, proc_date ) ;
					pstmt.setString ( 14, enddate ) ;
					pstmt.setString ( 15, practitioner_id) ;
					pstmt.setString ( 16, practitioner1 ) ;
					pstmt.setString ( 17, anaesthetists1) ;
					pstmt.setString ( 18, anaesthetists2 ) ;
					pstmt.setString ( 19, anaesthetists3 ) ;
					pstmt.setString ( 20, anaesthesia) ;
					pstmt.setString ( 21, anaesthesDet ) ;
					pstmt.setString ( 22, indication) ;
					pstmt.setString ( 23, monitor ) ;
					pstmt.setString ( 24, events ) ;
					pstmt.setString ( 25, postProcedure) ;
					pstmt.setString ( 26, specimen ) ;
					pstmt.setString ( 27, scrubnurse) ;
				    pstmt.setString ( 28, ERROR_MARKED_BY_ID ) ;
				    //pstmt.setDate   ( 29, ERROR_MARKED_DATE );
				    pstmt.setString ( 29, ERROR_REMARKS) ;
				    pstmt.setString ( 30, ERROR_YN );
				    pstmt.setString ( 31, laterality );
				    pstmt.setString ( 32, location );
				    pstmt.setString ( 33, practitioner2 );
				    pstmt.setString ( 34, curr_status );
				    pstmt.setString ( 35, classifition_type );// 36285
				//se	
					pstmt.setString(36, patient_id);
					pstmt.setString(37, srl_no);
					pstmt.setString(38, encounter_id);
					pstmt.setString(39, modified_facility_id);


					int upd_count = pstmt.executeUpdate();


					//pstmt.close();
					

					if (upd_count > 0){
						result = true ;
						con.commit() ;
						final java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}else{
						result = false ;
						con.rollback();
						final java.util.Hashtable message = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
						sb.append( (String) message.get("message") ) ;
						message.clear();
						//sb.append( "RECORD_NOT_UPDATED" ) ;
					}


					results.put( "status", new Boolean(result) ) ;
					results.put( "error", sb.toString() ) ;
				
					//return results ;

	}catch(Exception ce){


		sb.append(ce.toString()) ;
		ce.printStackTrace();
        results.put( "status", new Boolean(result) ) ;
        results.put( "error", sb.toString() ) ;
        //return results ;
	}
	finally{
		if (con != null){
			try{
						if(rs1!=null) rs1.close();
										 if(pstmt != null)pstmt.close();
										 if(stmt != null)stmt.close();
			     ConnectionManager.returnConnection(con, p);

			}
			catch (Exception ee) {ee.printStackTrace();}
       }
	}
	return results;
}

}    //End of the class
