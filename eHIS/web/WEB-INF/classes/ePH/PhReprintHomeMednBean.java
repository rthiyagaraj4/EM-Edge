/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//Saved on 10.12.2013
/*Author 	:	Arun M (157457)
Module name 	:	ePH
Function 	:	RePrint for Home Medication Summary*/
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class PhReprintHomeMednBean extends PhAdapter implements Serializable {
    
    private ArrayList duplicate_dtl_rec	= new ArrayList();
    private ArrayList duplicate_chk	= new ArrayList();
    private ArrayList<String> pres_id_list	= new ArrayList<String>();
	private ArrayList selected_checks	= new ArrayList();//Added for RUT-SCF-0383[Inc:46980]-AlphaReOpen
    private String patient_Id				=	"";//Added for RUT-SCF-0384[IN46988]
	public PhReprintHomeMednBean() {
		try {
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void doCommon() throws Exception {
	}

	public void clear() {
		patient_Id="";//Added for RUT-SCF-0384[IN46988]
	    duplicate_dtl_rec.clear();
	    duplicate_chk.clear();
	    pres_id_list.clear();
		selected_checks.clear();//Added for RUT-SCF-0383[Inc:46980]-AlphaReOpen
	}
	public void setPatientId(String patient_id){//Added for RUT-SCF-0384[IN46988] - Start
		this.patient_Id=patient_id;
	}
	public String getPatientId(){
		return this.patient_Id;
	}//Added for RUT-SCF-0384[IN46988] - End
	public ArrayList getDuplicateDtlRec(){
	    return duplicate_dtl_rec;
	}

	//Added for RUT-SCF-0383[Inc:46980]-AlphaReOpen Starts
	public ArrayList getselected_checks(){
	    return this.selected_checks;
	}

	public void setSelectedchecks(List selected_checks,String chk_yn){//Modified for RUT-SCF-0383[IN46980]
		if(selected_checks.size() > 0 && chk_yn.equals("Y")){
			if(!this.selected_checks.contains(selected_checks)){
				this.selected_checks.add(selected_checks);
			}
		}
		else if(selected_checks.size() > 0 && chk_yn.equals("N")){
			if(this.selected_checks.contains(selected_checks)){
				this.selected_checks.remove(selected_checks);
			}
		}
	}
	//Added for RUT-SCF-0383[Inc:46980]-AlphaReOpen Ends
	
	public void setPresidList(String presidlist,String uncheckData){
		String[] presid_list=null;//Modified for RUT-SCF-0384[IN46988] - Start
		String temp_pres_list="";
		String pat_id	=	getPatientId();
		ArrayList sub_dlt_check=new ArrayList();
		try{
			if(presidlist.indexOf(",")!=-1){
				presid_list=presidlist.split(",");
				//String patient_id="";  Removed for IN063877
				for(int k=0;k<presid_list.length;k++){
					if(!pres_id_list.contains(presid_list[k])){
						pres_id_list.add(presid_list[k].trim());
					}
				}
			}
			else{
				if(pat_id.equals("")){
					pres_id_list.add(presidlist);
				}else{
					pres_id_list.clear();
					pres_id_list.add(presidlist);	
				}
				/*if(!pres_id_list.contains(presidlist)){
					pres_id_list.add(presidlist);
				}*/
			}

		if(uncheckData.indexOf(",")!=-1){
			String[] c=uncheckData.split(",");
			for(int k=0;k<c.length;k++){
				if(pres_id_list.contains(c[k])){
					pres_id_list.remove(c[k].trim());
				}
			}
		}
		else{
			if(pres_id_list.contains(uncheckData)){
				pres_id_list.remove(uncheckData);
			}
		}
			sub_dlt_check=getHomeMednSubDtlData(pres_id_list);
			if(uncheckData.length()!=0){
				for(int n=0;n<sub_dlt_check.size();n++){
					presid_list=sub_dlt_check.get(n).toString().split("/");
					temp_pres_list=presid_list[5]+"/"+presid_list[9]+"/"+presid_list[6]+"/"+presid_list[7]+"/"+presid_list[8]+"/"+presid_list[1]+"/"+presid_list[4];
					temp_pres_list=temp_pres_list.replace(",","");
					setSelectedchecks(Arrays.asList(temp_pres_list),"N");
				}
			}	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}//Modified for RUT-SCF-0384[IN46988] - End
	}
	 public void setPresidListremove(String presidlist,String uncheckData){ 	//Added for RUT-SCF-0383[Inc:46980]
	    if(uncheckData.indexOf(",")!=-1){
			String[] c=uncheckData.split(",");
			for(int k=0;k<c.length;k++){
				if(pres_id_list.contains(c[k])){
					pres_id_list.remove(c[k].trim());
				}
			}
		}
		else{
			pres_id_list.remove(uncheckData);
		}	
	
   }
	public ArrayList getPresidList(){
	    return pres_id_list;
	}

	public ArrayList getDispLocation() {
		ArrayList displocation = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT3" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					displocation.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					displocation.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
			es.printStackTrace() ;
			}
		}
		return displocation;
	}

	// This method is used to retrieve the data depending on the query criteria
	public ArrayList getHomeMednDtlData(String patient_id,String disp_date_frm,String disp_date_to,String pres_id,String token_no,String encounter_id,String disp_locn_code,String drug_ord_type,String med_type_ind,String locn_type,String locn_code,String Orientation,String language_id,String from,String to)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
	//	String orderby="";  Removed for IN063877
		
		ArrayList records=new ArrayList();
		ArrayList dulicatechk=new ArrayList();
		
		String SQL="";
		int rec_count=1;
		
		try {
			connection = getConnection() ;
			SQL=PhRepository.getPhKeyValue("SQL_PH_REPRINT_MEDICATION_SUMMARY_QUERY");
			
			if(!patient_id.equals("")){
			    SQL= SQL +" AND C.PATIENT_ID=?";
			}
			if(!pres_id.equals("")){
			    SQL= SQL +" AND A.TRN_GROUP_REF=?";
			}
			if(!token_no.equals("")){
			    SQL= SQL +" AND G.TOKEN_SERIAL_NO=?";
			}
			if(!encounter_id.equals("")){
			    SQL= SQL +" AND G.ENCOUNTER_ID=?";
			}
			if(!locn_type.equals("")){
				SQL= SQL +" AND G.LOCN_TYPE=?";
			}
			if(!locn_code.equals("")){
				SQL= SQL +" AND G.LOCN_CODE=?";
			}
			
			if(drug_ord_type.equals("N"))
			    SQL= SQL +" AND A.IV_PREP_YN IS NULL ";
			else if(drug_ord_type.equals("T"))
			    SQL= SQL +" AND B.TAPERED_YN='Y' ";
			
			
			if(!med_type_ind.equals("")){
			    SQL= SQL +" AND H.MED_TYPE_IND=? ";
			}
			
			SQL= SQL +" ORDER BY C.PATIENT_ID,B.ORDER_ID ";//Modified for RUT-SCF-0383[IN46980]//Added C.PATIENT_ID for RUT-SCF-0384[IN46988] 
			
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(rec_count++,disp_date_frm.trim());
			pstmt.setString(rec_count++,disp_date_to.trim());
			pstmt.setString(rec_count++,disp_locn_code.trim());
			pstmt.setString(rec_count++,language_id.trim());
			pstmt.setString(rec_count++,language_id.trim());
			if(!patient_id.equals("")){
			    pstmt.setString(rec_count++,patient_id.trim());
			}
			if(!pres_id.equals("")){
			    pstmt.setString(rec_count++,pres_id.trim());
			}
			if(!token_no.equals("")){
			    pstmt.setString(rec_count++,token_no.trim());
			}
			if(!encounter_id.equals("")){
			    pstmt.setString(rec_count++,encounter_id.trim());
			}
			if(!locn_type.equals("")){
				pstmt.setString(rec_count++,locn_type.trim());
			}
			if(!locn_code.equals("")){
			    pstmt.setString(rec_count++,locn_code.trim());
			}
			if(!med_type_ind.equals("")){
			    pstmt.setString(rec_count++,med_type_ind.trim());
			}

			resultSet = pstmt.executeQuery() ;
			while ( resultSet.next()){
				
				ArrayList arr = new ArrayList();
				if(!dulicatechk.contains(resultSet.getString("PATIENT_ID"))){
				    dulicatechk.add(resultSet.getString("PATIENT_ID"));
				    arr.add(resultSet.getString("PATIENT_ID")+"/");
				    arr.add(resultSet.getString("PATIENT_NAME")+"/");
				}
				else{
				    arr.add(" "+"/");    
				    arr.add(" "+"/");
				}
				arr.add(resultSet.getString("TOKEN_SERIAL_NO")+"/");
				arr.add(resultSet.getString("PRACTIONER_ID")+"/");
				arr.add(resultSet.getString("DISPDATE")+"/");
				arr.add(resultSet.getString("PRACTITIONER_NAME")+"/");
				arr.add(resultSet.getString("ORDER_ID")+"/");//Added for RUT-SCF-0383[IN46980]
				records.add(arr);
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;
	}

	public ArrayList getHomeMednSubDtlData(ArrayList pres_list)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		ArrayList records=new ArrayList();
		String sql="";
		int rec_count=1;
		ArrayList arr = null;
		String[] pres_id = null;//Modified for RUT-SCF-0383[IN46980]
		try {
			connection = getConnection() ;
			//sql=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT");
			for(int m=0;m<pres_list.size();m++){
			    pres_id= pres_list.get(m).toString().trim().split("/");//Modified for RUT-SCF-0383[IN46980]
				if(pres_id!=null && !pres_id.equals("")){
				
				//	int j=1;  Removed for IN063877
					//sql="SELECT PH.DRUG_DESC,C.ACTION_TEXT_LABEL,BB.QTY_VALUE,A.DISP_QTY,A.ORDER_ID,A.DOC_NO,A.DOC_SRL_NO,A.ORDER_LINE_NUM,A.DISP_NO FROM (SELECT SUM(D.DISP_QTY)DISP_QTY,A.ORDER_ID,MAX(D.DOC_SRL_NO) DOC_SRL_NO,MAX(F.DOC_NO) DOC_NO,B.ORDER_LINE_NUM ORDER_LINE_NUM,F.DISP_NO FROM OR_ORDER A,OR_ORDER_LINE B,PH_DISP_DTL D,PH_DISP_HDR F WHERE A.ORDER_ID=B.ORDER_ID AND B.ORDER_ID=D.ORDER_ID AND B.ORDER_LINE_NUM=D.ORDER_LINE_NO  AND D.ORDER_ID=F.ORDER_ID AND F.FACILITY_ID=D.FACILITY_ID AND F.DISP_NO=D.DISP_NO AND B.ORDER_LINE_STATUS NOT IN ('DC','CN') AND A.TRN_GROUP_REF =? GROUP BY A.ORDER_ID,F.DISP_NO,B.ORDER_LINE_NUM)A, OR_ORDER_LINE BB, PH_DRUG_LANG_VW PH, PH_ROUTE_FOR_FORM C WHERE A.ORDER_ID=BB.ORDER_ID AND A.ORDER_LINE_NUM=BB.ORDER_LINE_NUM AND BB.ORDER_CATALOG_CODE=PH.DRUG_CODE AND BB.ORDER_ID=? AND PH.LANGUAGE_ID=? AND BB.ROUTE_CODE =C.ROUTE_CODE AND BB.FORM_CODE=C.FORM_CODE";//Added 'DISP_NO' for [IN:45916]//Added column 'bb.order_id' for RUT-SCF-0383[IN46980] AND MAX(B.ORDER_LINE_NUM) ORDER_LINE_NUM changed to B.ORDER_LINE_NUM ORDER_LINE_NUM AND In OrderBy B.ORDER_LINE_NUM added for RUT-SCF-0383[Inc:46980] AND Query Commented for RUT-SCF-0383[Inc:46980]-Alpha Reopen Issue 
					
					//Query Modified for RUT-SCF-0383[Inc:46980]-Alpha Reopen Issue 

					sql="SELECT PH.SHORT_DESC,C.ACTION_TEXT_LABEL,BB.QTY_VALUE,A.DISP_QTY,A.ORDER_ID,A.DOC_NO,A.DOC_SRL_NO,A.ORDER_LINE_NUM,A.DISP_NO FROM (SELECT SUM(D.DISP_QTY)DISP_QTY,A.ORDER_ID,MAX(D.DOC_SRL_NO) DOC_SRL_NO,MAX(F.DOC_NO) DOC_NO,B.ORDER_LINE_NUM ORDER_LINE_NUM,F.DISP_NO FROM OR_ORDER A,OR_ORDER_LINE B,PH_DISP_DTL D,PH_DISP_HDR F WHERE A.ORDER_ID=B.ORDER_ID AND B.ORDER_ID=D.ORDER_ID AND B.ORDER_LINE_NUM=D.ORDER_LINE_NO  AND D.ORDER_ID=F.ORDER_ID AND F.FACILITY_ID=D.FACILITY_ID AND F.DISP_NO=D.DISP_NO AND B.ORDER_LINE_STATUS NOT IN ('DC','CN') AND A.TRN_GROUP_REF =? GROUP BY A.ORDER_ID,F.DISP_NO,B.ORDER_LINE_NUM)A, OR_ORDER_LINE BB, MM_ITEM_LANG_VW PH, PH_ROUTE_FOR_FORM C WHERE A.ORDER_ID=BB.ORDER_ID AND A.ORDER_LINE_NUM=BB.ORDER_LINE_NUM AND BB.ORDER_CATALOG_CODE=PH.ITEM_CODE AND BB.ORDER_ID=? AND PH.LANGUAGE_ID=? AND BB.ROUTE_CODE =C.ROUTE_CODE AND BB.FORM_CODE=C.FORM_CODE ORDER BY A.DOC_SRL_NO";

					pstmt = connection.prepareStatement(sql);
					pstmt.setString(1,pres_id[1].trim());//Modified for RUT-SCF-0384[IN46988]
					pstmt.setString(2,pres_id[2].trim());//Added for RUT-SCF-0383[IN46980]//Modified for RUT-SCF-0384[IN46988]
					pstmt.setString(3,getLanguageId());
				
					resultSet = pstmt.executeQuery() ;
					while ( resultSet.next()){
						arr = new ArrayList();	
						arr.add(rec_count+"/");
						//arr.add(resultSet.getString("DRUG_DESC")+"/");Commented for RUT-SCF-0383[Inc:46980]-AlphaReOpen
						arr.add(resultSet.getString("SHORT_DESC")+"/");//Added for RUT-SCF-0383[Inc:46980]-AlphaReOpen
						arr.add(resultSet.getString("ACTION_TEXT_LABEL")+"/");
						arr.add(resultSet.getString("QTY_VALUE")+"/");
						arr.add(resultSet.getString("DISP_QTY")+"/");
						arr.add(resultSet.getString("DOC_NO")+"/");
						arr.add(resultSet.getString("DOC_SRL_NO")+"/");
						arr.add(resultSet.getString("ORDER_ID")+"/");
						arr.add(resultSet.getString("ORDER_LINE_NUM")+"/");
						arr.add(resultSet.getString("DISP_NO")+"/");//Added 'DISP_NO' for [IN:45916]
						records.add(arr);
						rec_count++;
					}
					closeResultSet( resultSet );//common-icn-0029
					closeStatement( pstmt ) ;//common-icn-0029
					
				}
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;
	}

	public ArrayList getIVLegends() throws Exception{
	   Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;
		ArrayList iv_legends			= new ArrayList();

        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT127") ) ;
		    pstmt.setString(1,getLanguageId());
					
		    resultSet = pstmt.executeQuery() ;
			while( resultSet.next() ) {
				iv_legends.add("1");
				iv_legends.add(resultSet.getString("iv_drug_fluid_continuous_dir"));
				iv_legends.add("2");
				iv_legends.add(resultSet.getString("iv_drug_fluid_continuous_adm"));
				iv_legends.add("3");
				iv_legends.add(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_dir"));
				iv_legends.add("4");
				iv_legends.add(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_adm"));
				iv_legends.add("5");
				iv_legends.add(resultSet.getString("IV_WITHOUT_ADDITIVES_LG")); 
			} 	
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
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
		return iv_legends;
	}

	public boolean chkDuplicate(String item_desc,String intruction,String qty_value){
	    boolean duplicatechk=true;
	    if(!duplicate_chk.contains(item_desc)){
		duplicate_chk.add(item_desc);
		duplicate_dtl_rec.add(item_desc+"/"+intruction+"/"+qty_value);
		duplicatechk=false;
	    }
	    return duplicatechk;
	}
	
	public boolean updateDuplicateRec(String item_desc,String intruction,String qty_value){
	    boolean udpateduplicate=false;
	    int j=0;
	    if(duplicate_chk.contains(item_desc)){
			Iterator i=duplicate_dtl_rec.iterator();
			String Keylist_value = null;
			String[] Keylist_delimit = null;
			while(i.hasNext()){
				Keylist_value=duplicate_dtl_rec.get(j).toString();
				Keylist_delimit=Keylist_value.split("/");
				if(Keylist_delimit[0].equals(item_desc)){
					duplicate_dtl_rec.remove(j);
					duplicate_dtl_rec.add(j,item_desc+"/"+intruction+"/"+qty_value);
					j++;
					udpateduplicate=true;
					break;
				}
				else{
					j++;
				}
			}
	    }
	    return udpateduplicate;
	}
	
	public HashMap	InsertPrintRecord(String addDatainsert) {//Modified for RUT-SCF-0383[IN46980]
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		PreparedStatement pstmt_insert		=	null;
		PreparedStatement pstmt_select		=	null;
		Connection connection 				=	null ;
		ResultSet rs						=	null;
		String order_id						=	"";//Added for RUT-SCF-0384[IN46988]
		String[] pres_order_id				=	null;//Added for RUT-SCF-0384[IN46988]
		ArrayList presid_list				=	new ArrayList();//Added for RUT-SCF-0384[IN46988]
		try{
			connection = getConnection();
			String select_stmt	=PhRepository.getPhKeyValue("SQL_PH_SELECT_TMP_OFFLINE_PRINT_SEQ_NO");
			String ph_hme_medn_sum_insert	="INSERT INTO PH_REPRINT_HOME_MED_SUMM (PRINT_SEQ_NO,DISP_NO,DISP_SRL_NO,ORDER_ID,ORDER_LINE_NUM,ITEM_DESC,INSTRUCTION,QUANTITY,PATIENT_ID,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			String printrecordinsert=getselected_checks().toString();//Added for RUT-SCF-0383[IN46980]
		//	int rec_count=1;  Removed for IN063877
			
			printrecordinsert=printrecordinsert.replace("[", "");//Added for RUT-SCF-0383[IN46980]
			printrecordinsert=printrecordinsert.replace("]", "");//Added for RUT-SCF-0383[IN46980]
				String[] query_selected=printrecordinsert.split(",");
				String[] add_modify=addDatainsert.split(",");
				pstmt_insert	= connection.prepareStatement( ph_hme_medn_sum_insert) ;
				pstmt_select	= connection.prepareStatement( select_stmt) ;
				String count="0";
				StringTokenizer st = null;
				rs=pstmt_select.executeQuery();
				if(rs.next()){
					count=rs.getString(1);
				}
				for(int i=0;i<query_selected.length;i++){
					st= new StringTokenizer(query_selected[i].toString(),"/");
					if (st.hasMoreTokens()){
						st.nextToken();//Added for [IN:45916]
						pstmt_insert.setString(1,count);
						pstmt_insert.setString(2,st.nextToken().toString().trim());
						pstmt_insert.setString(3,st.nextToken().toString().trim());
						order_id=st.nextToken().toString().trim();//Added for RUT-SCF-0384[IN46988] - Start
						pstmt_insert.setString(4,order_id);
						if(patient_Id.equals(""))
							QueryPatientId(order_id);// Added for RUT-SCF-0384[IN46988] - End
						pstmt_insert.setString(5,st.nextToken().toString().trim());
						pstmt_insert.setString(6,st.nextToken().toString().trim());
						pstmt_insert.setString(7,"");
						pstmt_insert.setString(8,st.nextToken().toString().trim());
						pstmt_insert.setString(9,getPatientId());//Modified for RUT-SCF-0384[IN46988] - Start
						pstmt_insert.setString(10,login_by_id);
						pstmt_insert.setString(11,login_at_ws_no);
						pstmt_insert.setString(12,login_facility_id);
						pstmt_insert.setString(13,login_by_id);
						pstmt_insert.setString(14,login_at_ws_no);
						pstmt_insert.setString(15,login_facility_id);//Modified for RUT-SCF-0384[IN46988] - End
						pstmt_insert.addBatch();
					}
					int[] result3	=pstmt_insert.executeBatch();
					for (int j=0;j<result3.length ;j++ ){
						if(result3[j]<0  && result3[j] != -2 ){
							try{
								pstmt_insert.cancel();
								connection.rollback();
								map.put( "result", new Boolean( false ) ) ;
								map.put( "message","PH_HOME_MED_SUM INSERTION FAILED");
								break;
							}
							catch (Exception ex){
								map.put( "message","Error Connection PH_HOME_MED_SUM INSERTION FAILED");
								ex.printStackTrace();
							}
						}
						else{
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message","Operation Completed Sucessfully");
							map.put( "print_seq_no",count);
						}
					}
				}
				int j=1;
				if(printrecordinsert.equals("")){//Added for RUT-SCF-0384[IN46988] - Start
					presid_list=getPresidList();
					if(presid_list.size()!=0)
						pres_order_id=presid_list.get(0).toString().split("/");
				
					order_id=pres_order_id[2].toString();
					QueryPatientId(order_id);
				}// Added for RUT-SCF-0384[IN46988] - End
				for(int n=0;n<add_modify.length;n++){
					st= new StringTokenizer(add_modify[n].toString(),"/");
					if (st.hasMoreTokens()){
						pstmt_insert.setString(1,count);
						pstmt_insert.setString(2,count);
						pstmt_insert.setString(3,j +"");
						pstmt_insert.setString(4,count);
						pstmt_insert.setString(5,j++ +"");
						pstmt_insert.setString(6,st.nextToken().toString().trim());
						pstmt_insert.setString(7,"");
						pstmt_insert.setString(8,st.nextToken().toString().trim());
						pstmt_insert.setString(9,getPatientId());//Modified for RUT-SCF-0384[IN46988] - Start
						pstmt_insert.setString(10,login_by_id);
						pstmt_insert.setString(11,login_at_ws_no);
						pstmt_insert.setString(12,login_facility_id);
						pstmt_insert.setString(13,login_by_id);
						pstmt_insert.setString(14,login_at_ws_no);
						pstmt_insert.setString(15,login_facility_id);//Modified for RUT-SCF-0384[IN46988] - End
						pstmt_insert.addBatch();
					}
					int[] result3	=pstmt_insert.executeBatch();
					for (int k=0;k<result3.length ;k++ ){
						if(result3[k]<0  && result3[k] != -2 ){
							try{
								pstmt_insert.cancel();
								connection.rollback();
								map.put( "result", new Boolean( false ) ) ;
								map.put( "message","PH_HOME_MED_SUM ADD INSERTION FAILED");
								break;
							}
							catch (Exception ex){
								map.put( "message","Error Connection PH_HOME_MED_SUM ADD INSERTION FAILED");
								ex.printStackTrace();
							}
						}
						else{
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message","Operation Completed Sucessfully");
							map.put( "print_seq_no",count);
						}
					}
				}
			//}
		} 
		catch(Exception e) {
			map.put( "message", "Exception in Table Insertion") ;
			e.printStackTrace() ;
		}
		finally{
			try {
				connection.commit();
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_select ) ;
				closeResultSet( rs ) ;
				pstmt_insert =null;
				pstmt_select=null;
				connection.close();
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return map ;
	}
	
	public void QueryPatientId(String order_id){// Added for RUT-SCF-0384[IN46988] - Start
		PreparedStatement pstmt_select		=	null;
		Connection connection = null ;
		ResultSet rs		=	null;
		try{
		connection = getConnection();
		String select_stmt	="SELECT PATIENT_ID FROM OR_ORDER WHERE ORDER_ID=?";
		pstmt_select	= connection.prepareStatement( select_stmt) ;
		pstmt_select.setString(1,order_id);
		rs=pstmt_select.executeQuery();
		if(rs!=null && rs.next()){
			setPatientId(rs.getString("PATIENT_ID"));
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{  //common-icn-0029
			try {
				closeStatement( pstmt_select ) ;
				closeResultSet( rs ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
	}// Added for RUT-SCF-0384[IN46988] - End
}
