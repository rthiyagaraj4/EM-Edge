/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import webbeans.eCommon.*;
import oracle.sql.*;

public class DisDataChartingBean extends PhAdapter implements Serializable {
	public boolean transaction_success=true;
 	//public Connection con ;

	public String location_type			 =	"";
	public String locale				 =	"";

	public StringBuffer sb	= new StringBuffer("");
	public StringBuffer sb1	= new StringBuffer("");

    public DisDataChartingBean() {
        try {
            doCommon();
        }
        catch(Exception e){
			e.printStackTrace();
		}
    }

    public void clear() {
        super.clear() ;
    }

    private void doCommon() throws Exception {
    }

	public String Test() { 
		return "Tested OK"; 
	}

	public HashMap operateDisDataCharting( Properties p, String operatingfacilityid , String episodetype , String episodeid , String visitid , String clinicianid , String locncode ,  String patientid, String batteryid, String Sdate, String finalvalues[][], String admdttime, String outrec_temp, String noofvals_temp, String added_at_ws_no, String location_type_param, String module_id, String inError, String inReplace )  {
		HashMap results = new HashMap() ;
		String mes	= "";

		noofvals_temp=noofvals_temp;
		int outrec=Integer.parseInt(outrec_temp);
		boolean result = true ;
		transaction_success=true;
		location_type = location_type_param ;//defined as gobal variable so no need to pass to each function 
		episodetype	  =	(episodetype==null)?"":episodetype ;
		Connection con =null;
		try{
			locale		= (String) p.getProperty("LOCALE");
			con = getConnection() ;
			con.setAutoCommit(false);

			String accessionnum			= null;
			String discrmsrid			= null;
			String discrmsrresulttype	= null;
			String discrmsrresultnum	= null;
			String discrmsrresultnumuom = null;
			String discrmsrresultstr	= null;
			String discrmsrresultdata	= null;
			String normallow			= null;
			String normalhigh			= null;
			String criticallow			= null;
			String criticalhigh			= null;
			String normabnormind		= null;
			String operation			= null;
			String value				= null;

			HashMap ret = null;
			//PreparedStatement st = null;
			//ResultSet rss = null;

			if(sb1.length() > 0) 
				sb1.delete(0,sb1.length());
			
			for(int i=1;i<outrec;i++){
				int j =0;
				accessionnum = finalvalues[i][j++];                         
				discrmsrid = finalvalues[i][j++];                                
				discrmsrresulttype = finalvalues[i][j++];                 
				discrmsrresultnum = finalvalues[i][j++];                 
				discrmsrresultnumuom = finalvalues[i][j++];         
				discrmsrresultstr = finalvalues[i][j++];                    
				discrmsrresultdata = finalvalues[i][j++];                 
				normallow = finalvalues[i][j++];                                
				normalhigh = finalvalues[i][j++];                               
				criticallow = finalvalues[i][j++];                                 
				criticalhigh = finalvalues[i][j++];                               
				normabnormind = finalvalues[i][j++];                      
				operation = finalvalues[i][j++];    
				String errorRemarks = finalvalues[i][j++];

				value		=	discrmsrresultnum+discrmsrresultstr+discrmsrresultdata;
				value		 =	(value==null)?"":value ;
				operation	 =	(operation==null)?"":operation ;
				discrmsrresultdata	 =(discrmsrresultdata==null)?"":discrmsrresultdata ;					
				
				if ( operation.equals("I") ){
					ret =  insertDisDataCharting(p,
												con,
												operatingfacilityid ,          	
												accessionnum ,                 
												episodetype ,                    
												episodeid ,                         
												visitid ,                                
												clinicianid ,                         
												discrmsrid ,                        
												discrmsrresulttype ,         
												discrmsrresultnum ,         
												discrmsrresultnumuom , 
												discrmsrresultstr ,            
												discrmsrresultdata ,         
												normallow ,                        
												normalhigh ,                      
												criticallow ,                        
												criticalhigh ,                       
												locncode ,                           
												patientid,                            
												normabnormind,               
												batteryid,                           
												Sdate,
												added_at_ws_no,
												location_type
												);
					boolean retval=((Boolean)ret.get("status")).booleanValue();
					ret.clear();
					if(retval) 
						transaction_success = true;
					else 
						transaction_success = false;
				}
						
				if ( operation.equals("U")){
					ret =  updateDisDataCharting(p,
												con,
												operatingfacilityid ,             		
												episodetype ,                       
												episodeid ,                            
												visitid ,                                   
												accessionnum ,                    
												clinicianid ,                            
												discrmsrid ,                           
												discrmsrresulttype ,           
												discrmsrresultnum ,            
												discrmsrresultnumuom ,    
												discrmsrresultstr ,               
												discrmsrresultdata ,           
												normabnormind,                  
												Sdate,
												added_at_ws_no,
												"",
												errorRemarks//added
												);
					boolean retval=((Boolean)ret.get("status")).booleanValue();
					ret.clear();
					if(retval) 
						transaction_success = true;
					else 
						transaction_success = false;
				}
			}
			if(transaction_success){
				Hashtable message =  MessageManager.getMessage( locale, "RECORD_INSERTED" ,"PH") ;
				mes = (String) message.get("message");
				con.commit();
				result=true;
				message.clear();
			}	
			else{
				Hashtable message = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
				mes = (String) message.get("message");
				con.rollback();
				result=false;
				message.clear();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			try{	
				con.rollback();
			}
			catch(Exception ce){
				ce.printStackTrace();
			}
		}
		finally {
			try{
				closeConnection( con );
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", mes) ;
		}
		return results ;
   }

	public HashMap insertDisDataCharting(
										Properties p,
										Connection con,
										String operatingfacilityid ,         
										String accessionnum ,                  
										String episodetype ,                   
										String episodeid ,                     
										String visitid ,                       
										String clinicianid ,        
										String discrmsrid ,                   
										String discrmsrresulttype ,          
										String discrmsrresultnum ,           
										String discrmsrresultnumuom ,       
										String discrmsrresultstr ,           
										String discrmsrresultdata ,          
										String normallow ,                     
										String normalhigh ,                    
										String criticallow ,                   
										String criticalhigh ,   
										String locncode ,
										String patientid,
										String normabnormind,
										String batteryid,
										String Sdate,
										String added_at_ws_no	,
										String location_type
									){

		accessionnum	=	accessionnum;
		visitid			=	visitid;
		locncode		=	locncode;
		location_type	=	location_type;

		StringBuffer sbin=new StringBuffer("") ;
		HashMap results = new HashMap() ;
		boolean result = true ;
		transaction_success=true;
		String insertsql = "";
		PreparedStatement stmt		 =	null;
		ResultSet rs				     =	null;
		try{
		
			String addedById		 = p.getProperty( "login_user" ) ;
			
			insertsql = " insert into ca_encntr_discr_msr(FACILITY_ID,ACCESSION_NUM,ENCOUNTER_ID, PATIENT_ID,PATIENT_CLASS,TEST_OBSERV_DT_TM,PERFORMING_PRACT_ID,DISCR_MSR_ID, DISCR_MSR_RESULT_TYPE,DISCR_MSR_RESULT_NUM,DISCR_MSR_RESULT_NUM_UOM, DISCR_MSR_RESULT_STR,DISCR_MSR_RESULT_DATA,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW, CRITICAL_HIGH,NORM_ABNORM_IND,DISCR_MSR_PANEL_OR_FORM_ID,ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO,CONTR_MODULE_ID) values(?, 'DM$'||to_char(sysdate,'YYYY')||'$'||lpad(CA_DISCR_MSR_SEQ.NEXTVAL,16,0),?,?,?, to_date( ? ,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,empty_clob(),?,?,?,?,?,?,?,sysdate,?,?,?, sysdate,?,?,'PH')";
		
			stmt = con.prepareStatement(insertsql);

			stmt.setString(1, operatingfacilityid);
			stmt.setString(2, episodeid);
			stmt.setString(3, patientid);
			stmt.setString(4, episodetype);
			stmt.setString(5, Sdate);
			stmt.setString(6, clinicianid);
			stmt.setString(7, discrmsrid);
			stmt.setString(8, discrmsrresulttype);
			stmt.setString(9, discrmsrresultnum);
			stmt.setString(10,discrmsrresultnumuom);
			stmt.setString(11,discrmsrresultstr);
			stmt.setString(12,normallow);
			stmt.setString(13,normalhigh);
			stmt.setString(14,criticallow);
			stmt.setString(15,criticalhigh);
			stmt.setString(16,normabnormind);
			stmt.setString(17,batteryid);
			stmt.setString(18,addedById);
			stmt.setString(19,operatingfacilityid);
			stmt.setString(20,added_at_ws_no);
			stmt.setString(21,addedById);
			stmt.setString(22,operatingfacilityid);
			stmt.setString(23,added_at_ws_no);

			int  rsinsertsql = stmt.executeUpdate(); 
			if(rsinsertsql !=0)	
				transaction_success = true;
			else
				transaction_success = false;
			
			closeStatement(stmt); //Common-icn-0029

			if(transaction_success){
				if(!(discrmsrresultdata.equals("") || discrmsrresultdata.equals(" ") || discrmsrresultdata == null)){
					StringBuffer sql =new StringBuffer();
					int currseq_val = 0;
					
					try{
						stmt = con.prepareStatement("SELECT CA_DISCR_MSR_SEQ.CURRVAL FROM DUAL");
						rs = stmt.executeQuery() ;
					
						if(rs.next())	
						  currseq_val = rs.getInt(1);
		
						closeResultSet(rs);	
						closeStatement(stmt);	
			
						sql.append(" Select DISCR_MSR_RESULT_DATA from ca_encntr_discr_msr WHERE ACCESSION_NUM= 'DM$'||to_char(sysdate,'YYYY')||'$'||lpad('");
						sql.append(currseq_val);
						sql.append("',16,0) for update "); 

						stmt = con.prepareStatement(sql.toString());
						rs = stmt.executeQuery();
					}
					catch(Exception e){
						System.out.println("Exceptoin "+e.toString());
						e.printStackTrace(System.err);
					}
					
					Clob clb = null;
					if(rs.next())	
						clb = rs.getClob(1);
					
					BufferedWriter w = new BufferedWriter(((Clob)clb).setCharacterStream(0));
					w.write(discrmsrresultdata,0,discrmsrresultdata.length());
					w.flush();
					w.close();
					transaction_success = true;
					sql.setLength(0);
				}
			}
		}
		catch(Exception e){
			transaction_success = false;
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet(rs);
				closeStatement(stmt);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		if(transaction_success)
			result=true;
		else
			result=false;

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sbin.toString() ) ;
		return results ;
	} // end insertDisDataCharting

	public HashMap updateDisDataCharting(
										Properties p,
										Connection con,
										String operatingfacilityid ,      
										String episodetype ,                   
										String episodeid ,                     
										String visitid ,  
										String accessionnum ,                  
										String clinicianid ,        
										String discrmsrid ,                   
										String discrmsrresulttype ,          
										String discrmsrresultnum ,           
										String discrmsrresultnumuom ,       
										String discrmsrresultstr ,           
										String discrmsrresultdata ,
										String normabnormind,
										String Sdate,
										String added_at_ws_no,
										String inError,
										String errorRemarks
									) {
		episodetype=episodetype;
		visitid=visitid;
		discrmsrresulttype=discrmsrresulttype;
		//StringBuffer sbup=new StringBuffer("") ;  Removed for IN063877
		HashMap results = new HashMap() ;
		boolean result = true ;
		transaction_success=true;
		StringBuffer updatesql =new StringBuffer();
		PreparedStatement stmt		 =	null;
		ResultSet rs				     =	null;

		try{
			String addedById		 = p.getProperty( "login_user" ) ;
			String modifiedById		 = addedById ;
			String errorMarkedById	 = addedById;
			updatesql.append(" update ca_encntr_discr_msr ");
			updatesql.append("set TEST_OBSERV_DT_TM = to_date( ? ,'dd/mm/yyyy hh24:mi:ss') ");
			updatesql.append(", DISCR_MSR_ID = ? ");
			updatesql.append(", DISCR_MSR_RESULT_NUM = ? ");
			updatesql.append(", DISCR_MSR_RESULT_NUM_UOM = ? ");
			updatesql.append(", DISCR_MSR_RESULT_STR = ? ");
			updatesql.append(", DISCR_MSR_RESULT_DATA = empty_clob() ");
			updatesql.append(", NORM_ABNORM_IND = ? ");
			updatesql.append(", PERFORMING_PRACT_ID = ? ");
			updatesql.append(", MODIFIED_BY_ID = ? ");
			updatesql.append(", MODIFIED_DATE = sysdate ");
			updatesql.append(", MODIFIED_FACILITY_ID = ? ");
			updatesql.append(", MODIFIED_AT_WS_NO = ? ");
			updatesql.append("where FACILITY_ID = ? ");
			updatesql.append("and ACCESSION_NUM  = ? ");
			updatesql.append("and DISCR_MSR_ID = ? ");

			stmt = con.prepareStatement(updatesql.toString());

			if(inError.equals("Y")){
				stmt.setString(1, errorMarkedById);
				stmt.setString(2, inError);
				stmt.setString(3, errorRemarks);
				stmt.setString(4, operatingfacilityid);
				stmt.setString(5, accessionnum);
				stmt.setString(6, discrmsrid);
			}
			else{
				stmt.setString(1, Sdate);
				stmt.setString(2, discrmsrid);
				stmt.setString(3, discrmsrresultnum);
				stmt.setString(4, discrmsrresultnumuom);
				stmt.setString(5, discrmsrresultstr);
				stmt.setString(6, normabnormind);
				stmt.setString(7, clinicianid);
				stmt.setString(8, modifiedById);
				stmt.setString(9, operatingfacilityid);
				stmt.setString(10,added_at_ws_no);
				stmt.setString(11,operatingfacilityid);
				stmt.setString(12, accessionnum);
				stmt.setString(13, discrmsrid);
			}

			int  rsupdatesql = stmt.executeUpdate();

			if(rsupdatesql !=0){
				transaction_success = true;
			}
			else{
				transaction_success = false;
			}

			updatesql.setLength(0);

			if(transaction_success)	{
				if(!discrmsrresultdata.equals(""))	{
					StringBuffer sql =new StringBuffer();
					sql.append(" Select DISCR_MSR_RESULT_DATA from ca_encntr_discr_msr ");
					sql.append(" where facility_id = ? ");
					sql.append(" and accession_num = ? ");
					sql.append(" and  DISCR_MSR_ID = ? ");
					sql.append(" AND ENCOUNTER_ID  = ? ");
					sql.append(" for update ");	 
					
					closeStatement(stmt);	
					stmt = con.prepareStatement(sql.toString());

					stmt.setString(1,operatingfacilityid);	
					stmt.setString(2,accessionnum);
					stmt.setString(3,discrmsrid);
					stmt.setString(4,episodeid);

					rs = stmt.executeQuery() ;

					Clob clb = null;
					if(rs.next())	{
						  clb = rs.getClob(1);
						  BufferedWriter w = new BufferedWriter(((Clob)clb).setCharacterStream(0));
						  //BufferedWriter w = new BufferedWriter(Writer());
						  w.write(discrmsrresultdata,0,discrmsrresultdata.length());
						  w.flush();
						  w.close();
					}
					transaction_success = true;
					sql.setLength(0);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			transaction_success=false;
		}	
		finally{
			try{
				closeResultSet(rs);
				closeStatement(stmt);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}

		if(transaction_success){
			result=true;
		}
		else{
			result=false;
		}
		results.put( "status", new Boolean(result) ) ;
		//results.put( "error", sbup.toString() ) ;
		return results ;
	} // end updateDisDataCharting
}
