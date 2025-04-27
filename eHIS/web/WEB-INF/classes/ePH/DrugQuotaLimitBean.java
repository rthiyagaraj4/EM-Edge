package ePH;

import java.io.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.text.SimpleDateFormat;

/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;

public class DrugQuotaLimitBean extends PhAdapter implements Serializable {

	protected String drug_code = "";
	protected String drug_name = "";
	protected String form_drug_code = "";
	protected String form_drug_desc = "";
	protected String speciality = "";
	protected String spl_code = "";
	protected String set_limit_by = "";
	protected String quota_limit = "";
	protected String additional_quota_limit = "";
	protected String reset = "";
	protected String row = "";
	protected ArrayList<Speciality> specialityList =new ArrayList();
	protected ArrayList<Speciality> formSpecialityList =new ArrayList();

	public ArrayList getSpecialityList() {
		return specialityList;
	}

	public String getDrugCode() {
		return this.drug_code;
	}

	public String getDrug_name() {
		return this.drug_name;
	}

	public String getspeciality() {
		return this.speciality;
	}

	public String getspl_code() {
		return this.spl_code;
	}

	public String getset_limit_by() {
		return this.set_limit_by;
	}

	public String getquota_limit() {
		return this.quota_limit;
	}

	public String getadditional_quota_limit() {
		return this.additional_quota_limit;
	}

	public String getreset() {
		return this.reset;
	}

	// set methods
	public void setDrugCode(String drug_code) {
		this.drug_code = drug_code;
	}

	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public void setSpl_code(String spl_code) {
		this.spl_code = spl_code;
	}

	public void setSet_Limit_By(String set_limit_by) {
		this.set_limit_by = set_limit_by;
	}

	public void setQuota_Limit(String quota_limit) {
		this.quota_limit = quota_limit;
	}

	public void setAdditional_Quota_Limit(String additional_quota_limit) {
		this.additional_quota_limit = additional_quota_limit;
	}

	public void setReset(String reset) {
		this.reset = reset;
	}

	public void clear() {
		super.clear();
		drug_code = "";
		drug_name = "";
		form_drug_code = "";
		form_drug_desc = "";
		speciality = "";
		spl_code = "";
		set_limit_by = "";
		quota_limit = "";
		additional_quota_limit = "";
		 specialityList .clear();
		formSpecialityList.clear();
		
	}

	public void setAll(Hashtable recordSet) {
		Enumeration<String> keys =recordSet.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = (String) recordSet.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
        formSpecialityList.clear();
		if (recordSet.containsKey("mode"))
			setMode((String) recordSet.get("mode"));
		if (recordSet.containsKey("drug_code"))
		{
			setDrugCode((String) recordSet.get("drug_code"));
			form_drug_code= (String) recordSet.get("drug_code");
		}
		if (recordSet.containsKey("drug_desc"))
		{
			setDrug_name((String) recordSet.get("drug_desc"));
			form_drug_desc=(String) recordSet.get("drug_desc");
		}
		
		if(recordSet.containsKey("row_no"))
		     row=(String)recordSet.get("row_no");
		int row_no=Integer.parseInt(row);
		for(int i=1;i<row_no;i++)
		{
			Speciality  s= new Speciality();
			s.setDrug_code(form_drug_code);
			if(recordSet.containsKey("splName"+i))
			     s.setSpeciality_desc((String)recordSet.get("splName"+i));
			if(recordSet.containsKey("splCode"+i))
			     s.setSpeciality_code((String)recordSet.get("splCode"+i));
			if(recordSet.containsKey("set_limit_by_"+i))
			     s.setSet_limit_by((String)recordSet.get("set_limit_by_"+i));
			if(recordSet.containsKey("quota_limit"+i))
			     s.setQuota_limit((String)recordSet.get("quota_limit"+i));
			if(recordSet.containsKey("additional_quota_limit"+i))
			     s.setAdditional_quota_limit((String)recordSet.get("additional_quota_limit"+i));
			if(recordSet.containsKey("resetClicked"+i))
				s.setResetClicked((String)recordSet.get("resetClicked"+i));
	
			formSpecialityList.add(s);
		}
	}

	// Get the Drug code related info
	public ArrayList getDrugCodeRelatedInfo(String drug_code) throws Exception {
        if(drug_code!=null &&  drug_code!=""){
		Connection connection = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		System.out.println("Inside Drug QuotaLimit");
		specialityList.clear();
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_QUOTA_LMT_SELECT"));
			pstmt.setString(1, drug_code);
			resultSet = pstmt.executeQuery();
		
			while (resultSet.next()) {
				Speciality record =new Speciality(); 
				record.setDrug_code(resultSet.getString("DRUG_CODE"));
				record.setSpeciality_code(resultSet.getString("SPECIALITY_CODE"));//1
                pstmt1= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SPECIALITY_DESC_SELECT"));
                pstmt1.setString(1, resultSet.getString("SPECIALITY_CODE"));
                resultSet1=pstmt1.executeQuery();
                if(resultSet1.next()){
                record.setSpeciality_desc( resultSet1.getString("SPECIALITY_DESC"));} //2
				record.setSet_limit_by(resultSet.getString("SET_LIMIT_BY"));//3
				record.setQuota_limit(resultSet.getString("QUOTA_LIMIT"));//4
				record.setAdditional_quota_limit(resultSet.getString("ADDITIONAL_QUOTA_LIMIT"));//5
				System.out.println( "record-------->0= "+record) ;
				specialityList.add(record);
			}
		} catch (Exception e) {
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		} finally {
			try {
				closeResultSet(resultSet);
				closeResultSet(resultSet1);
				closeStatement(pstmt);
				closeStatement(pstmt1);
				closeConnection(connection);
			} catch (Exception es) {
				System.out.println("Exception while closing the statements and resultsets" + es.toString());
			}
		}
		return specialityList;
	}
        return null;
	}
	public  HashMap  insert() {
		
		HashMap map = new HashMap();
		HashMap map1 = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		ArrayList<Speciality> insertList =new ArrayList();
		ArrayList<Speciality> updateList =new ArrayList();
		ArrayList<Speciality> updateResetList =new ArrayList();
		ArrayList<Speciality> deleteList =new ArrayList();
		for (Speciality formSpeciality : formSpecialityList) {
	            boolean found = false;

	            // Check if the formSpeciality exists in the specialityList
	            for (Speciality spec : specialityList) {
	                if ((spec.getSpeciality_code()).equals(formSpeciality.getSpeciality_code())) {  
	                    found = true;

	                    // Check if there is any change in the record
	                    if (!spec.equals(formSpeciality)) {
						if (formSpeciality.getResetClicked().equals("Yes")) {
							updateResetList.add(formSpeciality);
						} else {
							updateList.add(formSpeciality);
						}
	                    }
	                    break;
	                }
	            }

	            // If the formSpeciality doesn't exist in the specialityList, add it to the insertList
	             if (!found && formSpeciality.getSpeciality_code()!=null && formSpeciality.getSpeciality_code()!="") {
	                insertList.add(formSpeciality);
	            }
	        }
			//delete list
			for(Speciality spec : specialityList)
			{
				 // Check if the  specialityList exists in the formSpeciality
				boolean found =false;
				for (Speciality formSpeciality : formSpecialityList) 
				{
					 if ((spec.getSpeciality_code()).equals(formSpeciality.getSpeciality_code())) {  
						 found = true;
						 break;
					 }
				}
				 if (!found) {
		               deleteList.add(spec);
		           }
			}
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("insert records");
		System.out.println(insertList);
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("update records");
		System.out.println(updateList);
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("delete records");
		System.out.println(deleteList);
		if(insertList.size()==0 && updateList.size()==0 && deleteList.size()==0 && updateResetList.size()==0)
		{
			map.put("result", new Boolean(true));
			map.put("msgid", "RECORD_UNCHANGED");
			map.put("message", "RECORD_UNCHANGED");
			map.put("invalidCode", null);
			return map;
		}
		
		//Enter in db
		Connection connection = null;
		PreparedStatement pstmt_insert = null;
		PreparedStatement pstmt_update = null;
		PreparedStatement pstmt_delete = null;
		PreparedStatement pstmt_update_reset =null;
		try{
			connection = getConnection();
			pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SPECIALITY_CODE_INSERT"));
			pstmt_update= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SPECIALITY_CODE_UPDATE"));
			pstmt_delete= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SPECIALITY_CODE_DELETE"));
			pstmt_update_reset= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SPECIALITY_CODE_UPDATE_AND_RESET"));
			
			System.out.println("Records to insert:");
	        for (Speciality spec : insertList) {
	        	System.out.println(spec);
	        	int fld=0;
	        	pstmt_insert.setString( ++fld, form_drug_code);//drug code
	        	pstmt_insert.setString( ++fld, spec.getSpeciality_code() ) ;//Specialty code
	        	pstmt_insert.setString( ++fld, spec.getSet_limit_by() ) ;//Set_limit_by
				pstmt_insert.setString( ++fld, spec.getQuota_limit() ) ;//Quota Limit
				pstmt_insert.setString( ++fld, spec.getAdditional_quota_limit()) ;//Additional Quota Limit
				pstmt_insert.setString( ++fld, getLoginById() ) ;//LoginById
				pstmt_insert.setString( ++fld, getLoginAtWsNo() ) ;//LoginAtWsNo
				pstmt_insert.setString( ++fld, getLoginFacilityId() ) ;//Login facility id
				pstmt_insert.setString( ++fld, getLoginById() ) ;//LoginById
				pstmt_insert.setString( ++fld, getLoginAtWsNo() ) ;//LoginAtWsNo
				pstmt_insert.setString( ++fld, getLoginFacilityId() ) ;//Login facility id
				pstmt_insert.addBatch();
	        }
	        if(insertList.size()!=0){
	        int insertRows[]=pstmt_insert.executeBatch();
	        for (int k=0;k<insertRows.length ;k++ ){
				if(insertRows[k]<0 && insertRows[k]!=-2    ){
					pstmt_insert.cancel();
					throw new Exception("Insertion Failed");
				}
			}
	        }
	        
	        System.out.println("\nRecords to update:");
	        for (Speciality spec : updateList) {
	            System.out.println(spec);
	            int fld1=0;
	            pstmt_update.setString( ++fld1, spec.getSet_limit_by() ) ;//Set_limit_by
				pstmt_update.setString( ++fld1, spec.getQuota_limit()) ;//Quota Limit
				pstmt_update.setString( ++fld1, spec.getAdditional_quota_limit() ) ;//Additional Quota Limit
				pstmt_update.setString( ++fld1, getLoginFacilityId() ) ;//Login facility id
				pstmt_update.setString( ++fld1, getLoginAtWsNo() ) ;//LoginAtWsNo
				pstmt_update.setString( ++fld1, getLoginById() ) ;//LoginById
				pstmt_update.setString( ++fld1, getLoginFacilityId() ) ;//Login facility id
				pstmt_update.setString( ++fld1, getLoginAtWsNo() ) ;//LoginAtWsNo
				pstmt_update.setString( ++fld1, getLoginById() ) ;//LoginById
				pstmt_update.setString( ++fld1, spec.getSpeciality_code() ) ;//Specialty code
				pstmt_update.setString( ++fld1,form_drug_code ) ;//drug code
				pstmt_update.addBatch();
	           
	        } 
	        if(updateList.size()!=0){
	        int updateRows[]=pstmt_update.executeBatch();
	        for (int k=0;k<updateRows.length ;k++ ){
				if(updateRows[k]<0 && updateRows[k]!=-2  ){
					pstmt_update.cancel();
					throw new Exception("Updation Failed");
				}
			}
	        }
	        
	        System.out.println("\nRecords to update and reset:");
	        for (Speciality spec : updateResetList) {
	            System.out.println(spec);
	            int fld1=0;
	            pstmt_update_reset.setString( ++fld1, spec.getSet_limit_by() ) ;//Set_limit_by
				pstmt_update_reset.setString( ++fld1, spec.getQuota_limit()) ;//Quota Limit
				pstmt_update_reset.setString( ++fld1, spec.getAdditional_quota_limit() ) ;//Additional Quota Limit
				pstmt_update_reset.setString( ++fld1, getLoginFacilityId() ) ;//Login facility id
				pstmt_update_reset.setString( ++fld1, getLoginAtWsNo() ) ;//LoginAtWsNo
				pstmt_update_reset.setString( ++fld1, getLoginById() ) ;//LoginById
				pstmt_update_reset.setString( ++fld1, getLoginFacilityId() ) ;//Login facility id
				pstmt_update_reset.setString( ++fld1, getLoginAtWsNo() ) ;//LoginAtWsNo
				pstmt_update_reset.setString( ++fld1, getLoginById() ) ;//LoginById
				pstmt_update_reset.setString( ++fld1, spec.getSpeciality_code() ) ;//Specialty code
				pstmt_update_reset.setString( ++fld1,form_drug_code ) ;//drug code
				pstmt_update_reset.addBatch();
	        } 
	        if(updateResetList.size()!=0){
	        int updateRows[]=pstmt_update_reset.executeBatch();
	        for (int k=0;k<updateRows.length ;k++ ){
				if(updateRows[k]<0 && updateRows[k]!=-2  ){
					pstmt_update_reset.cancel();
					throw new Exception("Updation Failed");
				}
			}
	        }
	        
	        
	        System.out.println("\nRecords to delete:");
	        for (Speciality spec : deleteList){
	        System.out.println(spec);
		    int fld1=0;
		    pstmt_delete.setString( ++fld1,  spec.getSpeciality_code() ) ;//Specialty code
			pstmt_delete.setString( ++fld1, form_drug_code ) ;//drug code
			pstmt_delete.addBatch();
	        }
		     if(deleteList.size()!=0){
	        int deletedRows[]=pstmt_delete.executeBatch();
	        for (int k=0;k<deletedRows.length ;k++ ){
				if(deletedRows[k]<0  && deletedRows[k]!=-2 ){
					pstmt_delete.cancel();
					throw new Exception("Deletion Failed");
				}
			}
		     }
	        closeStatement(pstmt_insert);
			closeStatement(pstmt_update);
			closeStatement(pstmt_delete);
			closeStatement(pstmt_update_reset);
			pstmt_insert = null;
			pstmt_update = null;
			pstmt_delete = null;
			pstmt_update_reset = null;
			connection.commit();
			map.put("result", new Boolean(true));
			map.put("msgid", "RECORD_INSERTED");
			map.put("message", "RECORD_INSERTED");
			map.put("invalidCode", null);
		}
		catch(Exception e)
		{
			 try {
				closeStatement(pstmt_insert);
				closeStatement(pstmt_update);
				closeStatement(pstmt_delete);
				closeStatement(pstmt_update_reset);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				pstmt_insert = null;
				pstmt_update = null;
				pstmt_delete =null;
				pstmt_update_reset = null;
			System.out.println("Issue came for  Apply  "+e.getMessage());
			e.printStackTrace();
			map.put("result", new Boolean(false));
			map.put("msgid", "RECORD_NOT_INSERTED");
			
		}
		finally {
		    // Close the connection in the finally block
		    if (connection != null) {
		        try {
		            connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }}
		return map;
	}
	
			

	
	private HashMap CallDrugQuotaLimit(HashMap tabData, HashMap sqlMap) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean checkforORUpdate() {
		// TODO Auto-generated method stub
		return false;
	}



	public void setFormData(String drug_code2, String drug_desc, ArrayList<Speciality> specialityList2) {
		form_drug_code=drug_code2;
		form_drug_desc=drug_desc;
		formSpecialityList=specialityList2;
		System.out.println(formSpecialityList.toString());
		insert();
		clear();
	}

}
