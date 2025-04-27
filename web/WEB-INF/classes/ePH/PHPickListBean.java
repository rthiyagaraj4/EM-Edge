package ePH;
import java.io.Serializable ;
import java.util.* ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.* ;
import ePH.Common.* ;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.* ;
public class PHPickListBean extends PhAdapter implements Serializable{
	
	private String disp_locn_code	= "";
	private Hashtable recordSet		= new Hashtable();
	private ArrayList ipFillList	= new ArrayList();
	private HashMap	fillListDtl		= new HashMap();
	private ArrayList Records       = new ArrayList();
	private HashMap dispuoms		= new HashMap();
	
	
	public String getLoggedInFacility(){
		return login_facility_id;
	}
	
	public PHPickListBean(){
		try{
			doCommon() ;
		}
		catch(Exception e) {	e.printStackTrace() ;
		}
	}
	
	public String getDisp_locn_code() {
		return disp_locn_code;
	}
	public void setDisp_locn_code(String disp_locn_code) {
		this.disp_locn_code = disp_locn_code;
	}
	public ArrayList getIpFillList() {
		return ipFillList;
	}
	public void setIpFillList(ArrayList ipFillList) {
		this.ipFillList = ipFillList;
	}
	public HashMap getFillListDtl() {
		return fillListDtl;
	}
	public void setFillListDtl(HashMap fillListDtl) {
		this.fillListDtl = fillListDtl;
	}
	public HashMap getDispuoms() {
		return dispuoms;
	}
	public void setDispuoms(HashMap dispuoms) {
		this.dispuoms = dispuoms;
	}
	private void doCommon() throws Exception{
	}
	public void clear(){
		super.clear() ;
		this.disp_locn_code	= "";
		this.fillListDtl	= new HashMap();
		this.ipFillList		= new ArrayList();
		this.dispuoms		= new HashMap();
	}
	
	  public ArrayList getBuildingList() {
			Connection connection   = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet     = null ;
			ArrayList facilities    = new ArrayList();
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TRANS_BUILDING_SELECT" )) ;
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,this.disp_locn_code);
				pstmt.setString(3,getLanguageId());
				resultSet = pstmt.executeQuery() ;
				while (resultSet.next()) {
					facilities.add(resultSet.getString("BLDNG_CODE"));
					facilities.add(resultSet.getString("SHORT_DESC"));
				}
			}catch ( Exception e ) {
				facilities.add(e.toString());
			}finally {
				try {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es) {
					facilities.add(es.toString());
				}
			}
			return facilities;
		}
	  
	  public ArrayList getFillPeriods() {
			Connection connection	= null ;
			PreparedStatement pstmt	= null ;
			PreparedStatement pstmt1= null ;
			ResultSet resultSet		= null ;
			ResultSet resultSet1	= null ;
			ArrayList facilities	= new ArrayList();
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_FILLPERIOD_SELECT" )) ;
				pstmt.setString(1,login_facility_id);
				pstmt.setString(2,this.disp_locn_code);
				resultSet = pstmt.executeQuery() ;
				while (resultSet.next()) {
					facilities.add(resultSet.getString("IP_FILL_PRD_AHEAD"));
					facilities.add(resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
					facilities.add(resultSet.getString("SCHEDULE_START_TIME"));
					facilities.add(resultSet.getString("CDATE"));
					facilities.add(resultSet.getString("CMONTH"));
					facilities.add(resultSet.getString("CYEAR"));
					facilities.add(resultSet.getString("CHOURS"));
					facilities.add(resultSet.getString("CMINUTES"));
					facilities.add(resultSet.getString("IP_FILL_PRD_UNIT"));
					facilities.add(resultSet.getString("IP_FILL_ALLOCATE_BATHCES_YN"));
					facilities.add(resultSet.getString("ROUTINE_START_DATE"));
					facilities.add(resultSet.getString("ROUTINE_END_DATE"));
					pstmt1		= connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_FILLPERIOD_SELECT1" )) ;
					pstmt1.setString(1,login_facility_id);
					pstmt1.setString(2,this.disp_locn_code);
					pstmt1.setString(3,resultSet.getString("SCHEDULE_START_TIME"));
					resultSet1 = pstmt1.executeQuery() ;
					if (resultSet1.next()){
						facilities.add(resultSet1.getString("INC_START_DATE"));
						facilities.add(resultSet.getString("ROUTINE_END_DATE"));
						facilities.add("Y");
					} else {
						facilities.add(resultSet.getString("INC_START_DATE"));
						facilities.add(resultSet.getString("ROUTINE_END_DATE"));
						facilities.add("N");
					}
					closeResultSet( resultSet1 ) ;
					closeStatement( pstmt1 ) ;

				}
			}catch ( Exception e ) {
				facilities.add(e.toString());
				e.printStackTrace() ;
			}
			finally {
				try {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeResultSet( resultSet1 ) ;
					closeStatement( pstmt1 ) ;
					closeConnection( connection );
				}catch(Exception es) {
					es.printStackTrace() ;
				}
			}
			return facilities;
		}
	  
	  public void setCheckdRecords(ArrayList selectedRecords){
			this.Records		= selectedRecords;
			
		}
	  
	  
	  public HashMap updatepicklistFlag(String patient_id, ArrayList arr_of_orders,String facility_id) throws SQLException
	  {
		  HashMap map=new HashMap(); 
		  Connection con = null;
		  PreparedStatement pstmt=null; 
		  try{
			  con 	 =	  ConnectionManager.getConnection() ;
			  con.setAutoCommit(false);
			  
			  String update_picklist_flag="update or_order_line_ph set PICKLIST_PRINTED_YN='Y',PICKLIST_DATE=sysdate where  Order_id=? and order_line_num='1'  ";//IP only 1 record will come against 1 order_ID
			  //  patient_id=? and and Patient_class='IP'
			   pstmt			 =	  con.prepareStatement(update_picklist_flag);
			   System.out.println("arr_of_orders.size()====> "+arr_of_orders.size());
			  for (int i = 0; i < arr_of_orders.size(); i++) {
	                //pstmt.setString(1, patient_id);
				  System.out.println("arr_of_orders.size()====> "+(String) arr_of_orders.get(i));
	                pstmt.setString(1, (String) arr_of_orders.get(i));
	               // pstmt.setString(2, facility_id);
	                pstmt.addBatch();
	            }
			  System.out.println("arr_of_orders.size()====> "+arr_of_orders.size());
			  int[] updateCounts  =  pstmt.executeBatch();
			 boolean flag=false;
			 System.out.println("updateCounts.length====> "+updateCounts.length);
			  if(updateCounts.length > 0){	
				  con.commit();
				  flag=true;
			  }
			  System.out.println("flag.size()====>flag "+flag);
			  if(flag){  
				  map.put( "message","Successfull saved") ;
				  	map.put( "result",true) ;
			  }
			  }catch(Exception e){
			  
				con.rollback();
				e.printStackTrace();
				map.put( "message","failed") ;
				map.put( "result",false) ;
				  
			  }finally{
				  try
					{
						if(pstmt!=null)pstmt.close();
						if(con!=null)
							ConnectionManager.returnConnection(con);
					}
					catch(Exception e)
					{
						
					}
				
			  } 
		  return map;
	  }
	
	  public boolean doPrinting(Object request,Object response,String patient_id,String orderid,String P_PROC_DATE,String P_PROC_DATE_to,String P_LOCNCODE,String P_NURS_UNIT_CODE) {	
	        Connection connection       = null ;
	        PreparedStatement pstmt     = null ;
	        ResultSet resultSet         = null ;
	        String datefrm[]={};
			
			try{
				System.out.println("PHPickListBean.java<======> Online Report method name==> doPrinting() 222");
						connection = getConnection() ;
						ecis.utils.OnlineReports onlineReports 	= null;
						ecis.utils.OnlineReport report2 = null;
				System.out.println("PHPickListBean.java<======> Online Report method name==> doPrinting() 226");
						onlineReports 	= new ecis.utils.OnlineReports() ;
						report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHPICKLIST") ;
						report2.addParameter("p_facility_id",login_facility_id) ;
						report2.addParameter("p_language_id",getLanguageId());
						report2.addParameter("p_module_id","PH");
						report2.addParameter("p_report_id","PHPICKLIST");
						datefrm=P_PROC_DATE.split(" ");
						System.out.println("P_PROC_DATE==>=======>==========> "+datefrm[0]);
						P_PROC_DATE=datefrm[0];
						report2.addParameter("p_proc_date",P_PROC_DATE);
						report2.addParameter("p_locncode",P_LOCNCODE.toString()) ;
						report2.addParameter("p_nurs_unit_code",P_NURS_UNIT_CODE);
						report2.addParameter("p_patient_id",patient_id); 
						report2.addParameter("p_pick_list_yn", "N");
						report2.addParameter("p_order_id", orderid);
						
						
						System.out.println("PHPickListBean.java<======> Online Report method name==> doPrinting() 239");
						System.out.println("patient_id==> "+patient_id);
						System.out.println("orderid==> "+orderid);
						System.out.println("P_PROC_DATE==> "+P_PROC_DATE);
						System.out.println("P_PROC_DATE_to==> "+P_PROC_DATE_to);
						System.out.println("P_LOCNCODE==> "+P_LOCNCODE);
						System.out.println("p_nurs_unit_code==> "+P_NURS_UNIT_CODE);
						System.out.println("PHPickListBean.java<======> Online Report method name==> doPrinting() 246");
						onlineReports.add( report2) ;
						System.out.println("PHPickListBean.java<======> Online Report method name==> doPrinting() 248");
						onlineReports.execute((HttpServletRequest)request, (HttpServletResponse)response );
						System.out.println("PHPickListBean.java<======> Online Report method name==> doPrinting() 250");
				}catch ( Exception e ) {
				System.err.println("252 PHPickListBean.java<======> Online Report method name==> doPrinting() "+e.getMessage());
				e.printStackTrace() ;
			}
			finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}
				catch(Exception es){
					System.err.println("262 PHPickListBean.java<======> Online Report method name==> doPrinting() finally block "+es.getMessage());
					es.printStackTrace() ;
				}
			}
			return true;
		}
	  
	public ArrayList getIpPickList(String fill_int_start_date_time,String fill_int_end_date_time,String Proc_Type,String intermittent,String disp_locn_code,String nursing_unit_or_locn,String compound_drug_ind,String Building_Code,String Floor_Code,String Nursing_Unit_From, String Nursing_Unit_To, String order_by_for_list,String locale,String OrderingFacility_code,String ip_fill_excl_prd_behind,String patient_id) throws Exception{
	
		Connection connection	    = null;
         PreparedStatement pstmt	    = null;
         ResultSet resultSet		    = null;
 		ArrayList ip_fill_list		= new ArrayList();
 		HashMap	  ip_fill_order		= new HashMap();
 		
 		
 		try {
 			StringBuffer sbSQL = new StringBuffer();
             connection	= getConnection() ;
             
             sbSQL.append("SELECT SUBSTR(disp_qty, 1, INSTR(disp_qty, '|') - 1)  disp_qty_prefix,iv_prep_yn,tot_disp_qty,disp_qty,patient_name,date_of_birth,sex,patient_id,bed_num,patient_details,order_catalog_code,drug_name,order_qty,order_uom,order_id,source_code, ordering_facility_id,ord_date_time,encounter_id,ord_pract_id,order_line_status,start_date_time,end_date_time,durn_value,durn_type,nursing_unit_desc,order_line_num,patient_class,source_type,room_num,bed_class_code,bed_type_code ,specialty_code ,attend_practitioner_id ,performing_facility_id ,disp_alt_symbol,picklist_flag from (SELECT iv_prep_yn,( e.ORDER_QTY - e.BMS_QTY) || ' ' ||PH_GET_UOM_DISPLAY(e.PERFORMING_FACILITY_ID,e.ORDER_UOM, ?) Tot_Disp_Qty, ph_display_stock_unit_all(e.PERFORMING_FACILITY_ID, ?, e.Order_id, e.ordeR_line_num, e.order_Catalog_code,?,?,?, NUll, e.start_Date_time, e.end_Date_Time, e.durn_type, e.durn_value, e.order_line_Status, e.order_qty, e.ORDER_UOM,(SELECT freq_nature FROM am_frequency WHERE freq_code = e.freq_code) , ?,?,?,?,?,?,?,?,?,e.iv_prep_yn,?,?,?,e.next_fill_date, e.fill_proc_id, e.bms_qty, e.sliding_scale_yn) Disp_qty, nvl(decode(?,'en',Mp_patient.patient_Name,Mp_patient.PATIENT_NAME_LOC_LANG),Mp_patient.patient_Name) patient_Name ,Get_Age(Mp_patient.date_of_birth) date_of_birth ,Mp_patient.sex,Mp_patient.patient_id, ip_open_encounter.BED_NUM Patient_Details, e.order_Catalog_code order_Catalog_code,g.DRUG_DESC Drug_Name , e.ORDER_QTY, ph_get_uom_display (e.performing_facility_id, e.order_uom, '"+locale+"') order_uom, e.ORDER_ID, IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE SOURCE_CODE, ORDERING_FACILITY_ID, TO_CHAR(e.ORD_DATE_TIME, 'DD/MM/YYYY HH24:MI') ORD_DATE_TIME, e.ENCOUNTER_ID, e.ORD_PRACT_ID, e.order_line_status, e.start_Date_Time, TO_CHAR(e.end_date_Time, 'DD/MM/YYYY HH24:MI') end_date_Time, e.DURN_VALUE, e.DURN_TYPE, IP_NURSING_UNIT.SHORT_DESC NURSING_UNIT_DESC, e.ordeR_line_num ORDER_LINE_NUM, e.PATIENT_CLASS PATIENT_CLASS, e.SOURCE_TYPE SOURCE_TYPE, IP_OPEN_ENCOUNTER.ROOM_NUM ROOM_NUM, IP_OPEN_ENCOUNTER.BED_NUM BED_NUM,IP_OPEN_ENCOUNTER.BED_CLASS_CODE BED_CLASS_CODE, IP_OPEN_ENCOUNTER.BED_TYPE_CODE BED_TYPE_CODE, IP_OPEN_ENCOUNTER.SPECIALTY_CODE SPECIALTY_CODE,IP_OPEN_ENCOUNTER.ATTEND_PRACTITIONER_ID ATTEND_PRACTITIONER_ID,PERFORMING_FACILITY_ID,(case when (STRENGTH_VALUE>0 and disp_alt_form_yn='Y'  and npb_drug_yn='N') then 'Y' else 'N' end) disp_alt_symbol, PH_GET_PICKLIST_FLAG(e.order_id,e.order_line_num,?,?) picklist_flag  FROM mp_patient, IP_OPEN_ENCOUNTER, ph_order_work_list E ,IP_NURSING_UNIT_lang_vw IP_NURSING_UNIT ,ph_drug_lang_vw g,ph_disp_locn h WHERE ph_disp_locn_appl_yn (e.orig_performing_deptloc_code,?, e.source_type, e.source_code, e.added_facility_id, e.performing_facility_id, e.performing_deptloc_code, g.drug_class, g.drug_code, e.order_type_code, e.patient_class, e.priority, e.discharge_ind, DECODE (g.drug_yn, 'Y', 'D', 'N', 'M'),e.iv_prep_yn,e.ORIG_PERFORMING_DEPTLOC_CODE, e.order_id, NULL, e.patient_id, e.encounter_id) = 'Y' AND h.disp_locn_code = performing_deptloc_code AND h.facility_id = e.PERFORMING_FACILITY_ID AND e.PATIENT_CLASS = 'IP' and e.Iv_prep_yn is null AND TRUNC(E.END_DATE_TIME) >=TRUNC(SYSDATE) AND IP_OPEN_ENCOUNTER.FACILITY_ID = IP_NURSING_UNIT.FACILITY_ID AND IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE = IP_NURSING_UNIT.NURSING_UNIT_CODE AND (E.START_DATE_TIME BETWEEN To_date(? ,'DD/MM/YYYY HH24:MI') AND To_date(?,'DD/MM/YYYY HH24:MI') OR E.END_DATE_TIME BETWEEN To_date(? ,'DD/MM/YYYY HH24:MI') AND To_date(?,'DD/MM/YYYY HH24:MI') OR To_date(? ,'DD/MM/YYYY HH24:MI') BETWEEN E.START_DATE_TIME AND E.END_DATE_TIME OR To_date(?,'DD/MM/YYYY HH24:MI') BETWEEN E.START_DATE_TIME AND E.END_DATE_TIME ) AND e.ENCOUNTER_ID=IP_OPEN_ENCOUNTER.ENCOUNTER_ID AND e.ORDERING_FACILITY_ID=IP_OPEN_ENCOUNTER.FACILITY_ID AND e.ORDERING_FACILITY_ID=? AND e.PATIENT_ID=MP_PATIENT.PATIENT_ID AND MP_PATIENT.DECEASED_YN='N' AND e.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS WHERE DRUG_CLASS <> 'N') AND e.PRIORITY= 'R'   AND ((((Select NVL(PICKLIST_PRINTED_YN, 'N') from or_order_line_ph where order_id = e.order_id and order_line_num = e.order_line_num ) != 'Y'  OR (Select CASE WHEN PICKLIST_DATE IS NULL OR PICKLIST_DATE < TRUNC(SYSDATE) THEN 'Y' ELSE 'N' END AS RESULT FROM or_order_line_ph where order_id = e.order_id and order_line_num = e.order_line_num )='Y')))  ");
             if(!patient_id.equals("")){
            	 sbSQL.append(" and mp_patient.patient_id=	?");
             }
             sbSQL.append(" AND ((? = 'N' AND IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE =? ) OR (? = 'L' AND IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE IN (SELECT NURSING_UNIT_CODE FROM IP_NURSING_UNIT_LOCATION WHERE FACILITY_ID = ? AND BLDNG_CODE between NVL(?,'!') AND NVL(?,'~') AND FLOOR_CODE = nvl(?,FLOOR_CODE )))) AND ( ( ? ='B' AND (IV_PREP_YN IN ('1','3','5','9') OR IV_PREP_YN IS NULL)) OR (? ='Y' AND IV_PREP_YN IN ('1','3','5','9')) OR(? ='N' AND IV_PREP_YN IS NULL)) AND e.ord_date_time between sysdate-100 and sysdate AND EXISTS (SELECT 'Y' FROM am_frequency WHERE freq_code = e.freq_code AND freq_nature IN ('F','I',?,?,'C')) AND g.drug_yn = DECODE(?,'M','N','D','Y',g.drug_yn) /*AND EXISTS (Select 'Y' from or_order_line_ph where order_id = e.order_id and order_line_num = e.order_line_num AND ( (TRUNC(NEXT_FILL_DATE)>=TRUNC(To_Date(?,'DD/MM/YYYY HH24:MI'))) OR (NEXT_FILL_DATE IS NULL)))*/ and e.order_Catalog_code = g.drug_code AND 'Y' = DECODE(g.drug_yn,'N','Y',DECODE(?,'Y',calc_dosg_by_freq_durn_yn,'Y')) and g.language_id =? and IP_NURSING_UNIT.language_id=? and g.IN_FORMULARY_YN !='N' and (e.next_fill_date is null or e.next_fill_date <= to_date (?,'DD/MM/YYYY HH24:MI')) AND 1=ph_check_order_qualify_ipfill(e.ORDER_ID, e.ORDER_LINE_NUM, E.FREQ_CODE, e.DURN_TYPE, e.DURN_VALUE,?,?,iv_prep_yn,g.drug_yn) AND ph_ipfill_zero_qty_yn(e.order_id, e.order_line_num,e.FREQ_CODE, e.iv_prep_yn, g.drug_yn, g.drug_code, ?,?    )='Y' Order By IP_NURSING_UNIT.SHORT_DESC, decode(?,'B',NVL(IP_OPEN_ENCOUNTER.bed_NUM,e.patient_id),e.patient_id),nvl(iv_prep_yn,'-1'),e.order_id,e.order_line_num) aliasv where SUBSTR(disp_qty, 1, INSTR(disp_qty, '|') - 1) > 0  and picklist_flag ='Y' ");
             pstmt   =connection.prepareStatement(sbSQL.toString() );
             System.err.println("updated==> "+sbSQL.toString());
 				int i=1	;
 		    pstmt.setString(i++,locale);
			pstmt.setString(i++,disp_locn_code);		    		         //16 
			pstmt.setString(i++,fill_int_start_date_time);          		 //1    	 
			pstmt.setString(i++,fill_int_end_date_time);            		 //2    	 
			pstmt.setString(i++,Proc_Type);				    		 		 //3    	 
			pstmt.setString(i++,"N");					    		 		 //4    	 
			pstmt.setString(i++,nursing_unit_or_locn);						 //5    	 
			pstmt.setString(i++,Nursing_Unit_From);							 //6    	 
			pstmt.setString(i++,"");							 //7    	 
			pstmt.setString(i++,Building_Code);								 //8    	 
			pstmt.setString(i++,"");							 //9    	 
			pstmt.setString(i++,Floor_Code);								 //10    	 
			pstmt.setString(i++,checkForNull(ip_fill_excl_prd_behind));	     //11        
			pstmt.setString(i++,compound_drug_ind);					         //12        
			pstmt.setString(i++,"");					         //13         
			pstmt.setString(i++,"");					 //14  
			pstmt.setString(i++,"");					             //15  
			pstmt.setString(i++,locale);
			pstmt.setString(i++,fill_int_start_date_time);
			pstmt.setString(i++,fill_int_end_date_time);
			pstmt.setString(i++,disp_locn_code);		    		         //16        
			pstmt.setString(i++,fill_int_start_date_time);  				 //17   	 
			pstmt.setString(i++,fill_int_end_date_time);    				 //18   	 
			pstmt.setString(i++,fill_int_start_date_time);  		 		 //19   	 
			pstmt.setString(i++,fill_int_end_date_time);    		 		 //20   	 
			pstmt.setString(i++,fill_int_start_date_time);					 //21   	 
			pstmt.setString(i++,fill_int_end_date_time);					 //22   	 
			pstmt.setString(i++,OrderingFacility_code);	    				 //23  
			 if(!patient_id.equals("")){
				 pstmt.setString(i++,patient_id);	
			 }
			pstmt.setString(i++,nursing_unit_or_locn);						 //24   	 
			pstmt.setString(i++,Nursing_Unit_From);							 //25   	 
			//pstmt.setString(i++,Nursing_Unit_To);							 //26   	 
			pstmt.setString(i++,nursing_unit_or_locn);						 //27   	 
			pstmt.setString(i++,OrderingFacility_code);						 //28   	 
			pstmt.setString(i++,Building_Code);								 //29   	 
			pstmt.setString(i++,"");							 //30   	 
			pstmt.setString(i++,Floor_Code);								 //31   	 
			pstmt.setString(i++,compound_drug_ind);							 //32   	 
			pstmt.setString(i++,compound_drug_ind);							 //33   	 
			pstmt.setString(i++,compound_drug_ind);							 //34   	 
			pstmt.setString(i++,"");			     	             //39
			pstmt.setString(i++,"");			     	         //40
			pstmt.setString(i++,"");			     	         //41
			pstmt.setString(i++,"");					 //42 
			pstmt.setString(i++,locale);							     	 //43   	 
		    pstmt.setString(i++,locale);							     	 //44   	 
			pstmt.setString(i++,fill_int_start_date_time);			     	 //45   
			pstmt.setString(i++,fill_int_start_date_time);					 //46 start date time added by bshankar
			pstmt.setString(i++,fill_int_end_date_time);					 //47 fill end date time added by bshankar
			pstmt.setString(i++,fill_int_start_date_time);  				 //48 - MMS shedule time between effective_start and 
			pstmt.setString(i++,fill_int_end_date_time);    				 //49 -MMS  shedule time between effective_start and 
			pstmt.setString(i++,order_by_for_list);					   		 //50
 		    
 		    
 	   	resultSet	= pstmt.executeQuery() ;
 			if (resultSet!=null){
 				while(resultSet.next()){
 					ip_fill_order	= new HashMap();
 					ip_fill_order.put("Tot_Disp_Qty",checkForNull(resultSet.getString("Tot_Disp_Qty")));
 					ip_fill_order.put("Disp_qty",checkForNull(resultSet.getString("Disp_qty")));
 					ip_fill_order.put("Patient_Details",checkForNull(resultSet.getString("Patient_Details")));
 					ip_fill_order.put("patient_Name",checkForNull(resultSet.getString("patient_Name")));
 					ip_fill_order.put("date_of_birth",checkForNull(resultSet.getString("date_of_birth")));
 					ip_fill_order.put("sex",checkForNull(resultSet.getString("sex")));
 					ip_fill_order.put("patient_id",checkForNull(resultSet.getString("patient_id")));
 				   	ip_fill_order.put("Drug_Code",checkForNull(resultSet.getString("order_Catalog_code")));
 					ip_fill_order.put("Drug_Name",checkForNull(resultSet.getString("Drug_Name")));
 					ip_fill_order.put("ORDER_QTY",checkForNull(resultSet.getString("ORDER_QTY")));
 					ip_fill_order.put("ORDER_UOM",checkForNull(resultSet.getString("ORDER_UOM")));
 					ip_fill_order.put("ORDER_ID",checkForNull(resultSet.getString("ORDER_ID")));
 					ip_fill_order.put("SOURCE_CODE",checkForNull(resultSet.getString("SOURCE_CODE")));
 					ip_fill_order.put("ORDERING_FACILITY_ID",checkForNull(resultSet.getString("ORDERING_FACILITY_ID")));
 					ip_fill_order.put("ORD_DATE_TIME",checkForNull(resultSet.getString("ORD_DATE_TIME")));
 					ip_fill_order.put("PATIENT_ID",checkForNull(resultSet.getString("PATIENT_ID")));
 					ip_fill_order.put("ENCOUNTER_ID",checkForNull(resultSet.getString("ENCOUNTER_ID")));
 					ip_fill_order.put("ORD_PRACT_ID",checkForNull(resultSet.getString("ORD_PRACT_ID")));
 					ip_fill_order.put("order_line_status",checkForNull(resultSet.getString("order_line_status")));
 					ip_fill_order.put("start_Date_Time",checkForNull(resultSet.getString("start_Date_Time")));
 					ip_fill_order.put("end_date_Time",checkForNull(resultSet.getString("end_date_Time")));
 					ip_fill_order.put("DURN_VALUE",checkForNull(resultSet.getString("DURN_VALUE")));
 					ip_fill_order.put("DURN_TYPE",checkForNull(resultSet.getString("DURN_TYPE")));
 					ip_fill_order.put("NURSING_UNIT_DESC",checkForNull(resultSet.getString("NURSING_UNIT_DESC")));
 					ip_fill_order.put("ORDER_LINE_NUM",checkForNull(resultSet.getString("ORDER_LINE_NUM")));
 					ip_fill_order.put("PATIENT_CLASS",checkForNull(resultSet.getString("PATIENT_CLASS")));
 					ip_fill_order.put("SOURCE_TYPE",checkForNull(resultSet.getString("SOURCE_TYPE")));
 					ip_fill_order.put("ROOM_NUM",checkForNull(resultSet.getString("ROOM_NUM")));
 					ip_fill_order.put("BED_NUM",checkForNull(resultSet.getString("BED_NUM")));
 					ip_fill_order.put("BED_CLASS_CODE",checkForNull(resultSet.getString("BED_CLASS_CODE")));
 					ip_fill_order.put("BED_TYPE_CODE",checkForNull(resultSet.getString("BED_TYPE_CODE")));
 					ip_fill_order.put("SPECIALTY_CODE",checkForNull(resultSet.getString("SPECIALTY_CODE")));
 					ip_fill_order.put("ATTEND_PRACTITIONER_ID",checkForNull(resultSet.getString("ATTEND_PRACTITIONER_ID")));
 					ip_fill_order.put("PERFORMING_FACILITY_ID",checkForNull(resultSet.getString("PERFORMING_FACILITY_ID")));
 					ip_fill_list.add(ip_fill_order);

 				  // System.err.println("ip_fill_list---from bean---->"+ip_fill_list);
 				}
 			}
 		}catch ( Exception e ) {												
 			e.printStackTrace() ;
 		}
 		finally {
 				closeResultSet( resultSet ) ;
 				closeStatement( pstmt ) ;
 				closeConnection( connection ); 
 		}
 		this.ipFillList = ip_fill_list;
 		//System.err.println("ip_fill_list----------->"+ip_fill_list);
 		return ip_fill_list;
 	
	}
	
	public ArrayList getDispLocns(String locale) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList dispLocns = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT_DISP_LOCN" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2,locale);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				dispLocns.add(resultSet.getString("DISP_LOCN_CODE"));
				dispLocns.add(resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {		
				es.printStackTrace();
			}
		}
		return dispLocns;
	}
	public HashMap getIpPickListOnlineReport(String facility_id,String disp_locn_code)throws Exception{
		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		HashMap onlineReport		= new HashMap();
		try {
            connection	= getConnection() ;
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT37"));
			pstmt		= connection.prepareStatement("SELECT REPORT_ID, PRINT_STATUS FROM PH_DISP_LOCN_PRN_OPTION WHERE FACILITY_ID = ? AND DISP_LOCN_CODE = ? AND DISP_STAGE = 'FP' AND PATIENT_CLASS = 'IP' AND EFF_STATUS = 'E' AND PRINT_STATUS <> 'NR' ");
			
            pstmt.setString(1,facility_id);
            pstmt.setString(2,disp_locn_code);

			resultSet	= pstmt.executeQuery() ;

			while(resultSet!=null && resultSet.next()){
				onlineReport.put(resultSet.getString("REPORT_ID"),resultSet.getString("PRINT_STATUS"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		 
		return onlineReport;		
	}
}
