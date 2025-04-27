/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*Developed by    :Arun Kumar M (10/12/2013)
Module/Function : Home Medication Sheet Type
Modified Name	SCF No  		Incident No		Reason
-------------------------------------------------------
ArunKumar M		RUT-SCF-0358	IN46714			If dosage form are more than one pages, once apply all list of dosage form in the same screen will recorded without 
												value from other page or if goes to next screen by 'Next' button system also not record the value.
*/

package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;
import java.text.DecimalFormat;
import ePH.Common.* ;
import eCommon.Common.* ; 
import eCommon.SingleTableHandler.*;

public class HomeMednSheetBean extends PhAdapter implements Serializable {
    
	private String select_option			=	"";
	private ArrayList  form_code_list		=	new ArrayList();
	private ArrayList uncheck_formcode_list	=	new ArrayList();
	private ArrayList allRecords	=	new ArrayList();
	private ArrayList allRecord		=	new ArrayList();			
	private String med_type_ind				=	"";
	
	public void setSelectedOption(String select_option){
		this.select_option=select_option;
	}

	public String getSelectedOption(){
		return select_option;
	}

	public void setMeTypeInd(String med_ind){
		med_type_ind=med_ind;
	}
	
	public ArrayList getAllRecordsStatus(){
		return allRecords;
	}
	//Modified for RUT-SCF-0358[IN46714] - Start
	public void setFormCodeList(List form_code,List uncheck_code){
		Iterator i=form_code.iterator();
		String[] set_form_code=null;
		String form_code_list_val = "";
		Iterator m=uncheck_code.iterator();
		String[] set_unchedform_code=null;
		String uncheckform_code_list_val = "";
		while(m.hasNext()){
			uncheckform_code_list_val=m.next().toString();
			set_unchedform_code=uncheckform_code_list_val.split(",");
			for(int k=0;k<set_unchedform_code.length;k++){
				if(form_code_list.contains(set_unchedform_code[k]))
					form_code_list.remove(set_unchedform_code[k]);
			}
		}
		while(i.hasNext()){//Added for RUT-CRF-0061 [IN:45785]
			form_code_list_val=i.next().toString();
			set_form_code=form_code_list_val.split(",");
			for(int j=0;j<set_form_code.length;j++){
				if(!form_code_list.contains(set_form_code[j]))
					form_code_list.add(set_form_code[j]); 
			}
		}
	}

	public ArrayList getFormCodeList(){
		return form_code_list;
	}

	public void setUncheckedData(List uncheck_code,List check_code){
		Iterator i=uncheck_code.iterator();
		String[] set_form_code=null;
		String uncheck_form_code_list_val = "";
		Iterator m=check_code.iterator();
		String[] set_checkform_code=null;
		String check_form_code_list_val = "";
		while(m.hasNext()){
			check_form_code_list_val=m.next().toString();
			set_checkform_code=check_form_code_list_val.split(",");
			for(int k=0;k<set_checkform_code.length;k++){
				if(uncheck_formcode_list.contains(set_checkform_code[k]))
					uncheck_formcode_list.remove(set_checkform_code[k]);
			}
		}
		while(i.hasNext()){//Added for RUT-CRF-0061 [IN:45785] 
			uncheck_form_code_list_val=i.next().toString();
			set_form_code=uncheck_form_code_list_val.split(","); 
			for(int j=0;j<set_form_code.length;j++){
				if(!uncheck_formcode_list.contains(set_form_code[j]))
					uncheck_formcode_list.add(set_form_code[j]);
			}
		}
	}

	public ArrayList getUncheckedData(){
		return uncheck_formcode_list;
	}

	public void setAll( Hashtable recordSet ){
	}

	public void clear() {
		select_option="";
		allRecords.clear();
	}
	 
	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		PreparedStatement pstmt_insert		=	null;
		PreparedStatement pstmt_select		=	null;
		PreparedStatement pstmt_delete_uncheck		=	null;//Added for RUT-CRF-0061[IN46193] 
		String MednSheetOption=getSelectedOption();
		Connection connection = null ;
		ResultSet rs		=	null;
		StringTokenizer st = null;
		String formcode = "";
		try{
			connection = getConnection();
			Iterator i=getFormCodeList().iterator();
			Iterator K=getUncheckedData().iterator();//Added for RUT-CRF-0061[IN46193]
			pstmt_insert	=connection.prepareStatement(PhRepository.getPhKeyValue( "SQL_PH_HOME_MEDN_SHEET_TYPE_INSERT"));
			pstmt_select	=connection.prepareStatement(PhRepository.getPhKeyValue( "SQL_PH_HOME_MEDN_SHEET_TYPE_SELECT"));
			pstmt_delete_uncheck	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_HOME_MEDN_SHEET_TYPE_DELETE")) ;
			int count=0;
			while(i.hasNext()){
				st= new StringTokenizer(i.next().toString(),",");
				while (st.hasMoreTokens()){
					count=0;
					formcode=st.nextToken();
					pstmt_select.setString(1,MednSheetOption );
					pstmt_select.setString(2,formcode );
					rs=pstmt_select.executeQuery();
					if(rs.next()){
						count=rs.getInt(1);
					}
					closeResultSet( rs ) ;
					if(count==0){
						pstmt_insert.setString(1,MednSheetOption);
						pstmt_insert.setString(2,formcode);
						pstmt_insert.setString(3,login_by_id);
						pstmt_insert.setString(4,login_at_ws_no);
						pstmt_insert.setString(5,login_facility_id);
						pstmt_insert.setString(6,login_by_id);
						pstmt_insert.setString(7,login_at_ws_no);
						pstmt_insert.setString(8,login_facility_id);
						pstmt_insert.addBatch();
						map.put( "record",count);//Added for RUT-CRF-0061[IN:45573]
					}
				}
				if(map.containsKey("record")){//Added for RUT-CRF-0061[IN:45573]
					int[] result3	=pstmt_insert.executeBatch();
					for (int j=0;j<result3.length ;j++ ){
						if(result3[j]<0  && result3[j] != -2 ){
							try{
								pstmt_insert.cancel();
								connection.rollback();
								map.put( "result", new Boolean( false ) ) ;
								map.put( "message","PH_HOME_MED_TYPE INSERTION FAILED");
								break;
							}
							catch (Exception ex){
								map.put( "message","Error Connection PH_HOME_MED_TYPE INSERTION FAILED");
								ex.printStackTrace();
							}
						}
						else{
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message","Success");
						}
					}
				}
				else{
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message","Success");
				}
			}
			while(K.hasNext()){//Added for RUT-CRF-0061[IN46193] - Start
				st= new StringTokenizer(K.next().toString(),",");
				while (st.hasMoreTokens()){
					count=0;
					formcode=st.nextToken();
					pstmt_select.setString(1,MednSheetOption );
					pstmt_select.setString(2,formcode );
					rs=pstmt_select.executeQuery();
					if(rs.next()){
						count=rs.getInt(1);
					}
					closeResultSet( rs ) ;
					if(count!=0){
					pstmt_delete_uncheck.setString(1,MednSheetOption);
					pstmt_delete_uncheck.setString(2,formcode);
					pstmt_delete_uncheck.addBatch();
					map.put( "record",count);
					}
				}
				if(map.containsKey("record")){
					int[] result3	=pstmt_delete_uncheck.executeBatch();
					for (int j=0;j<result3.length ;j++ ){
						if(result3[j]<0  && result3[j] != -2 ){
							try{
								pstmt_delete_uncheck.cancel();
								connection.rollback();
								map.put( "result", new Boolean( false ) ) ;
								map.put( "message","PH_HOME_MED_TYPE DELETION FAILED");
								break;
							}
							catch (Exception ex){
								map.put( "message","Error Connection PH_HOME_MED_TYPE DELETION FAILED");
								ex.printStackTrace();
							}
						}
						else{
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message","Success");
						}
					}
				}else{
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message","Success");
				}
			}//Added for RUT-CRF-0061[IN46193] - End
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
				closeStatement( pstmt_delete_uncheck ) ;//Added for RUT-CRF-0061[IN46193]
				connection.close();
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return map ;
	}
	
	public HashMap modify(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		String MednSheetOption=getSelectedOption();
		String formcode = "";
		PreparedStatement pstmt_insert		=	null;
		PreparedStatement pstmt_select		=	null;
		PreparedStatement pstmt_update		=	null;
		ResultSet rs		=	null;
		ArrayList associate_list_rec=new ArrayList();
		PreparedStatement pstmt_delete_uncheck		=	null;
		Connection connection = null ;	
		StringTokenizer st = null;
		try {
			connection = getConnection();
			pstmt_insert	=connection.prepareStatement(PhRepository.getPhKeyValue( "SQL_PH_HOME_MEDN_SHEET_TYPE_INSERT"));
			pstmt_update	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_HOME_MEDN_SHEET_TYPE_UPDATE")) ;
			pstmt_select	=connection.prepareStatement(PhRepository.getPhKeyValue( "SQL_PH_HOME_MEDN_SHEET_TYPE_SELECT"));
			associate_list_rec=getFormCodeList();
			if(getFormCodeList().size() > 0){
				Iterator i=associate_list_rec.iterator();
				int count=0;
				while(i.hasNext()){
					st= new StringTokenizer(i.next().toString(),",");
					while (st.hasMoreTokens()){
						formcode=st.nextToken();
						pstmt_update.setString(1,login_by_id);
						pstmt_update.setString(2,login_at_ws_no);
						pstmt_update.setString(3,login_facility_id);
						pstmt_update.setString(4,MednSheetOption);
						pstmt_update.setString(5,formcode);
						pstmt_update.addBatch();
					}
				}
				int[] result3	=pstmt_update.executeBatch();
				for (int j=0;j<result3.length ;j++ ){
					if(result3[j]<0  && result3[j] != -2 ){
						try{
							pstmt_update.cancel();
							connection.rollback();
							map.put( "result", new Boolean( false ) ) ;
							map.put( "message","PH_HOME_MED_TYPE FAILED");
							break;
						}
						catch (Exception ex){
							map.put( "message","Connection Issue PH_HOME_MED_TYPE FAILED");
							ex.printStackTrace();
						}
					}
					else{
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message","Success");
					}
				}
				i=associate_list_rec.iterator();
			while(i.hasNext()){
				st= new StringTokenizer(i.next().toString(),",");
				while (st.hasMoreTokens()){
					formcode=st.nextToken();
					pstmt_select.setString(1,MednSheetOption );
					pstmt_select.setString(2,formcode );
					rs=pstmt_select.executeQuery();
					if(rs.next()){
						count=rs.getInt(1);
					}
					closeResultSet( rs ) ;
					if(count==0){
						pstmt_insert.setString(1,MednSheetOption);
						pstmt_insert.setString(2,formcode);
						pstmt_insert.setString(3,login_by_id);
						pstmt_insert.setString(4,login_at_ws_no);
						pstmt_insert.setString(5,login_facility_id);
						pstmt_insert.setString(6,login_by_id);
						pstmt_insert.setString(7,login_at_ws_no);
						pstmt_insert.setString(8,login_facility_id);
						pstmt_insert.addBatch();
						map.put( "record",count);
					}
				}
			}
				if(map.containsKey("record")){
					 result3	=pstmt_insert.executeBatch();
					for (int j=0;j<result3.length ;j++ ){
						if(result3[j]<0  && result3[j] != -2 ){
							try{
								pstmt_insert.cancel();
								connection.rollback();
								map.put( "result", new Boolean( false ) ) ;
								map.put( "message","PH_HOME_MED_TYPE INSERTION FAILED");
								break;
							}
							catch (Exception ex){
								map.put( "message","Error Connection PH_HOME_MED_TYPE INSERTION FAILED");
								ex.printStackTrace();
							}
						}
						else{
							map.put( "result", new Boolean( true ) ) ;
							map.put( "message","Success");
						}
					}
				}
				else{
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message","Success");
				}
			}
			if(getUncheckedData().size() > 0){
				pstmt_delete_uncheck	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_HOME_MEDN_SHEET_TYPE_DELETE")) ;
				Iterator i=getUncheckedData().iterator();
				ArrayList records=new ArrayList();
				while(i.hasNext()){
					st= new StringTokenizer(i.next().toString(),",");
					while (st.hasMoreTokens()){
						formcode=st.nextToken();
						for(int k=0;k<allRecord.size();k++){
							records=(ArrayList) allRecord.get( k );
								if(records.get(0).equals(formcode)){
									allRecord.remove(k);
								}
						}
						pstmt_delete_uncheck.setString(1,MednSheetOption);
						pstmt_delete_uncheck.setString(2,formcode);
						pstmt_delete_uncheck.addBatch();
					}
				}
				int[] result3	=pstmt_delete_uncheck.executeBatch();
				for (int j=0;j<result3.length ;j++ ){
					if(result3[j]<0  && result3[j] != -2 ){
						try{
							pstmt_delete_uncheck.cancel();
							connection.rollback();
							map.put( "result", new Boolean( false ) ) ;
							map.put( "message","PH_HOME_MED_TYPE FAILED ON UNCHECK UPDATION");
							break;
						}
						catch (Exception ex){
							map.put( "message","Connection Issue PH_HOME_MED_TYPE FAILED ON UNCHECK DATA");
							ex.printStackTrace();
						}
					}
					else{
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message","Success");
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			try{
				connection.rollback();
				map.put( "message","UPDATE PH_HOME_MED_TYPE FAILED");
			}
			catch (Exception ex1){
				map.put( "message","Error Connection UPDATE PH_HOME_MED_TYPE FAILED");
				ex1.printStackTrace();
			}
		}
		finally{	
			try {
				connection.commit();
				closeStatement( pstmt_insert ) ; //common-icn-0029
				closeStatement( pstmt_select );//common-icn-0029
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_delete_uncheck ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return map;
	}
	
	public ArrayList getFormAllRecords(){

		Connection connection   = null;
		PreparedStatement pstmt   = null;       
		ResultSet resultSet    = null;
		ArrayList record	 = null;
	//	int i=0;  Removed for IN063877
		try {
			connection = getConnection() ;
			allRecords	=	new ArrayList();
			List<String> formcode_List 			=	new ArrayList<String>();
			List<String> unchecked_formcode_List	=	new ArrayList<String>();
			StringBuffer	code_checked=new StringBuffer();
			StringBuffer	code_unchecked=new StringBuffer();
			String effstatus	="";
			String formcode		="";
			String formdesc		="";
			pstmt  = connection.prepareStatement(PhRepository.getPhKeyValue( "SQL_PH_HOME_MEDN_SHEET_TYPE"));
			pstmt.setString(1, med_type_ind);//Added for RUT-CRF-0061[IN:045872]
			pstmt.setString(2, getLanguageId());//Added for RUT-CRF-0061[IN:045872]
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null){
				while(resultSet.next() ) {
					record	=	new ArrayList();
					formcode=resultSet.getString("form_code").toString();
					formdesc=resultSet.getString("form_desc").toString();
					effstatus=resultSet.getString("eff_status").toString();
					if(effstatus.equals("D")){
							code_checked.append(formcode).append(",");
					}else{
							code_unchecked.append(formcode).append(",");
					}
					formdesc=formdesc.replace(",","");
					record.add(formcode);
					record.add(formdesc);
					record.add(effstatus);
					allRecords.add(record);
				}
				
				if(code_checked.length()!=0)
						formcode_List			=	Arrays.asList(code_checked.substring(0, code_checked.length()-1).toString());
				
				if(code_unchecked.length()!=0)
					unchecked_formcode_List	=	Arrays.asList(code_unchecked.substring(0, code_unchecked.length()-1).toString());
				
				setFormCodeList(formcode_List,unchecked_formcode_List);
				setUncheckedData(formcode_List,unchecked_formcode_List);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;  
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;  
				closeConnection( connection );
			}
			catch(Exception ex){
				ex.printStackTrace() ;  
			}
		}
		return allRecords;
	}

	public void setFormAssociatedRecords(List check_associate_data,List uncheck_associate_data){
		ArrayList record 	=	new ArrayList();
		ArrayList associate_record=new ArrayList();
		ArrayList associate_tmp_record=new ArrayList();
		String check_associate_list="";
		String[] check_associate_list_val = null;
		String[] list_val = null;
		String uncheck_associate_list="";
		String[] uncheck_associate_list_val = null;
		boolean empty_record=true;
		Iterator i=check_associate_data.iterator();
		Iterator j=uncheck_associate_data.iterator();
		while(i.hasNext()){
			empty_record=false;
			check_associate_list=i.next().toString();
			check_associate_list_val=check_associate_list.split(",");
			for(int k=0;k<check_associate_list_val.length;k++){
				record		=	new ArrayList();
				list_val=check_associate_list_val[k].split("/");	
				record.add(list_val[0].toString());
				record.add(list_val[1].toString());
				record.add(list_val[2].toString());
				if(!allRecord.contains(record))
					allRecord.add(record);
			}
		}
		while(j.hasNext()){ 
			empty_record=false;
			uncheck_associate_list=j.next().toString();
			uncheck_associate_list_val=uncheck_associate_list.split(",");
			String associate_list="";
			String[] associate_list_val=null;
			Iterator k=allRecord.iterator();
			while(k.hasNext()){
				associate_list=k.next().toString();
				associate_list=associate_list.replace("[", "");
				associate_list=associate_list.replace("]", "");
				associate_record=new ArrayList();
				associate_list_val=associate_list.split(",");
				associate_record.add(associate_list_val[0].toString().trim());
				associate_record.add(associate_list_val[1].toString().trim());
				associate_record.add(associate_list_val[2].toString().trim());
				associate_tmp_record.add(associate_record);
			}
			Iterator m=associate_tmp_record.iterator();
			while(m.hasNext()){
				record=(ArrayList)m.next();
				for(int n=0;n<uncheck_associate_list_val.length;n++){
					associate_record		=	new ArrayList();
					list_val=uncheck_associate_list_val[n].split("/");	
					associate_record.add(list_val[0].toString());
					associate_record.add(list_val[1].toString());
					associate_record.add(list_val[2].toString());
				if(record.equals(associate_record)){
					allRecord.remove(record);
				}
			  }
			}
		}
		
		if(empty_record)
			allRecord.clear();
	}
	public ArrayList getFormAssociatedRecords(){
		return allRecord;
	}
}
