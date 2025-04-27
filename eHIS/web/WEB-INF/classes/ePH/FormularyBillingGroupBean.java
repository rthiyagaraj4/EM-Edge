package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import oracle.sql.*;
import eOR.*;
import java.text.DecimalFormat;

public class FormularyBillingGroupBean extends PhAdapter implements Serializable { 


private HashMap selectedGenericID = new HashMap();
private HashMap selectedItemList = new HashMap();
private ArrayList genericNameForDrug = new ArrayList();
private ArrayList genericNameForMedicalItem = new ArrayList();
private ArrayList itemGenericType = new ArrayList();
private ArrayList selectedBlgGrpID = new ArrayList();
private ArrayList allBlngGrpId     = new ArrayList();
private String billing_type   = "";
private String formulary_code = "";
private String formulary_desc = "";
private String enable_status  = ""; 
private int no_of_decimals	  = 0; //GHL-CRF-0618


public FormularyBillingGroupBean(){
        try {
            doCommon();
        }
		catch(Exception e){
			e.printStackTrace();	
		}
	}

	private void doCommon() throws Exception {
	}


public void setSelectedGenericID(String generic_id,ArrayList selectedItemList){
	this.selectedGenericID.put(generic_id,selectedItemList);
}
public HashMap getSelectedGenericID(){
	return selectedGenericID;
}

public void setGenericNameForDrug(String generic_name){
	this.genericNameForDrug.add(generic_name);
}

public ArrayList getGenericNameForDrug(){
	return genericNameForDrug;
}

public void setGenericNameForMedicalItem(String generic_name){
	this.genericNameForMedicalItem.add(generic_name);
}

public ArrayList getGenericNameForMedicalItem(){
	return genericNameForMedicalItem;
}

public void setItemGenericType(String item_type){
  this.itemGenericType.add(item_type);
}

public ArrayList getItemGenericType(){
 return this.itemGenericType;
}

//GHL-CRF-0618 - start
public void setNoOfDecimals(int no_of_decimals){
 this.no_of_decimals = no_of_decimals;
}

public int getNoOfDecimals(){
	return this.no_of_decimals;
}
//GHL-CRF-0618 - end

public HashMap validate() throws Exception {// validate method starts here..
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
}


public void setSelectedItemList(String key,ArrayList arr){
	this.selectedItemList.put(key,arr);
}
public HashMap getSelectedItemList(){
	return  selectedItemList;
}

 
public void setFormularyCode(String formulary_code){
this.formulary_code=formulary_code;
}
public String getFormularyCode(){
return  formulary_code;
}
public void setFormularyDesc(String formulary_desc){
this.formulary_desc=formulary_desc;
}
public String getFormularyDesc(){
	return  formulary_desc;
}

public void setBillingType(String billing_type){
	this.billing_type=billing_type;
}

public String getBillingType(){
	return  billing_type;
}

public void setEffectStatus(String enable_status){
	this.enable_status=enable_status;
}

public String getEffectStatus(){
	return  enable_status;
}

public void setselectedFormularyBLGId(String blg_group_id,String checked_yn){
	if(checked_yn.equals("Y"))
		 this.selectedBlgGrpID.add(blg_group_id);
	else
		 this.selectedBlgGrpID.remove(blg_group_id);
}

public ArrayList getselectedFormularyBLGId(){
 return this.selectedBlgGrpID;
}

	
public void setFormularyBlngId(ArrayList arr){
	this.allBlngGrpId = arr;
}

public ArrayList getFormularyBlngId(){
 return this.allBlngGrpId;
}
	
public void setAll( Hashtable recordSet ) {
		
//System.err.println("inside set All=recordSet==>"+recordSet);
		if(recordSet.containsKey("formulary_code"))
			setFormularyCode((String)recordSet.get("formulary_code")) ;
		if(recordSet.containsKey("formulary_desc"))
			setFormularyDesc((String)recordSet.get("formulary_desc")) ;

		if(recordSet.containsKey("billing_type"))
			setBillingType((String)recordSet.get("billing_type")) ;

		if(recordSet.containsKey("enable_status"))
			setEffectStatus((String)recordSet.get("enable_status")) ;


	}


public void clear(){
	super.clear() ;
	if(allBlngGrpId!=null)
		allBlngGrpId.clear();
 	if(genericNameForDrug!=null)
		genericNameForDrug.clear();
	if(genericNameForMedicalItem!=null)
		genericNameForMedicalItem.clear();
	if(itemGenericType!=null)
		itemGenericType.clear();
	if(selectedGenericID!=null)
		selectedGenericID.clear();
	if(selectedBlgGrpID!=null)
		selectedBlgGrpID.clear();

		billing_type="";
		formulary_code="";
		formulary_desc= "";
		enable_status  = ""; 
		no_of_decimals = 0;
}

public ArrayList getItemListForGenericName(String item_type,String generic_id,String generic_name,String form_code,String str_value,String strength_uom,ArrayList itemList){
	
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmt1 = null ;
		ResultSet resultSet		= null ;	
		ResultSet resultSet1		= null ;
		//ArrayList record1        =new ArrayList(); //Commented for common-icn-0048
		String drug_code="";
		String item_code = "";
		String unit_cost = "";
		boolean item_add_flag = true;
		ArrayList record        =new ArrayList();

		
	
	try{
			connection			= getConnection() ;
			
			

			if(item_type.equals("M")){
				pstmt  = connection.prepareStatement("SELECT ord_cat.order_catalog_code item_code, ord_cat.short_desc long_desc,mm.UNIT_COST FROM or_order_catalog ord_cat,st_item st,mm_item mm WHERE    st.item_code = mm.item_code and ord_cat.order_catalog_code = st.item_code  AND ord_cat.order_catalog_code = mm.item_code AND medical_item_yn = 'Y' AND drug_item_yn = 'N' AND    ord_cat.order_category = 'PH' AND item_tech_code = ? ORDER BY long_desc ");
				pstmt.setString(1,generic_id); // item_tech_code
				resultSet = pstmt.executeQuery() ;
		 
				while(resultSet!= null && resultSet.next())
				{

		/*			record.add((String)resultSet.getString("long_desc"));
					record.add("");
					record.add("");
					record.add((String)resultSet.getString("item_code"));
					record.add((String)resultSet.getString("UNIT_COST"));
					record.add("");
					record.add("");
					record.add(generic_id);
					record.add("");
					record.add(""); */
					unit_cost = (String)resultSet.getString("UNIT_COST");
				if(unit_cost==null || unit_cost.equals(""))
					unit_cost = "0";

	
					 unit_cost = setNumber(""+unit_cost, getNoOfDecimals());
					 item_add_flag = true;
				if(itemList!=null && itemList.size()>0){
					for(int i=0;i<itemList.size();i=i+14){
						item_code = (String)itemList.get(i+3);				
						if(((String)resultSet.getString("item_code")).equals(item_code)){
							item_add_flag = false;
							break;
						}
					}
				}
				if(item_add_flag){
					record.add(generic_id);
					record.add(generic_name);
					record.add(item_type);
					record.add((String)resultSet.getString("item_code"));
					record.add((String)resultSet.getString("long_desc"));
					record.add("");
					record.add("");
					record.add("");
					record.add("");
					record.add("");
					record.add("");
					record.add(unit_cost);
					record.add("");
					record.add("");
				}

				}
				if(itemList!=null && itemList.size()>0){
					record.addAll(itemList);
				}
			}else{
				pstmt   = connection.prepareStatement("SELECT a.drug_code,a.drug_desc, b.form_desc, c.route_desc,a.route_code,(select short_desc from am_uom where uom_code=a.STRENGTH_UOM )uom_desc  FROM ph_drug a, ph_form b, ph_route c WHERE DRUG_YN = 'Y' AND DISCONTINUED_YN = 'N' AND a.form_code = b.form_code AND a.route_code = c.route_code AND a.generic_id = ? and a.form_code=? AND a.strength_value = ? AND a.STRENGTH_UOM = ?  order by drug_desc ");

				pstmt1   = connection.prepareStatement("select UNIT_COST from mm_item where item_code=?");
				
				pstmt.setString(1,generic_id.trim()); // generic_id
				pstmt.setString(2,form_code.trim()); 
				pstmt.setString(3,str_value.trim()); 
				pstmt.setString(4,strength_uom.trim()); 

				resultSet = pstmt.executeQuery() ;
				
				while(resultSet!= null && resultSet.next())
				{	
					unit_cost = "";
					drug_code =(String)resultSet.getString("drug_code"); 
					/*
					record.add((String)resultSet.getString("drug_desc"));	
					record.add((String)resultSet.getString("form_desc"));	
					record.add((String)resultSet.getString("route_desc"));
					record.add(drug_code);
					*/
					pstmt1.setString(1,drug_code);
					
					resultSet1		= pstmt1.executeQuery();
					
					if(resultSet1!=null && resultSet1.next()) {
						unit_cost= (String)resultSet1.getString("UNIT_COST");
					}
								
					if(unit_cost==null || unit_cost.equals(""))
					unit_cost = "0";

		
					 unit_cost = setNumber(""+unit_cost, getNoOfDecimals());
					 item_add_flag = true;
					if(itemList!=null && itemList.size()>0){
						for(int i=0;i<itemList.size();i=i+14){
							item_code = (String)itemList.get(i+3);				
							if(drug_code.equals(item_code)){
								item_add_flag = false;
								break;
							}
						}
					}
				if(item_add_flag){	
					record.add(generic_id);
					record.add(generic_name);
					record.add(item_type);
					record.add(drug_code);
					record.add((String)resultSet.getString("drug_desc"));
					record.add(form_code);
					record.add((String)resultSet.getString("form_desc"));
					record.add(str_value+" "+(String)resultSet.getString("uom_desc"));
					record.add((String)resultSet.getString("route_code"));
					record.add((String)resultSet.getString("route_desc"));
					record.add("");
					record.add(unit_cost);
					record.add(str_value);
					record.add(strength_uom);
				}
					closeResultSet( resultSet1 ) ;
					
//System.err.println("record==220====>"+record);
				}
				if(itemList!=null && itemList.size()>0){
					record.addAll(itemList);
				}

				//System.err.println("record==222====>"+record);
			
			}
		}	
		catch(Exception e)
		{
		e.printStackTrace();
	    }
	finally {
			try {
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es) { es.printStackTrace();}
		}
		return record; 
}

public ArrayList getBillingGroup(){
	ArrayList  billing_group= new ArrayList(); 
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;
	String sqlQuery = "";
	try{  
		boolean formulary_facility_appl = isSiteSpecific("PH","FORMULARY_FACILITY_APPL"); //AMRI-CRF-0464
		connection	= getConnection() ;

		if(formulary_facility_appl){
		sqlQuery="select BLNG_GRP_ID,short_desc from bl_blng_grp order by short_desc ASC";
		}else{
		sqlQuery="select a.BLNG_GRP_ID,short_desc from bl_blng_grp a,BL_BLNG_GRP_FACILITY b where a.BLNG_GRP_ID=b.BLNG_GRP_ID and b.facility_id=? order by short_desc ASC";
		}
		pstmt		= connection.prepareStatement(sqlQuery) ;
		
		if(!formulary_facility_appl) //added for AMRI-CRF-0464
		pstmt.setString(1,login_facility_id);
	
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			billing_group.add(checkForNull(resultSet.getString("BLNG_GRP_ID")));
			billing_group.add(checkForNull(resultSet.getString("short_desc")));
			
		}
	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception es){ 
			es.printStackTrace() ;
		}
	}
	return billing_group;
}

public ArrayList getFormNames(String generic_id){
	ArrayList  form_names= new ArrayList(); 
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;
	
	try{
		connection	= getConnection() ;
		String sqlQuery="select distinct a.form_code,form_desc from ph_drug a, ph_form b where a.form_code=b.form_code and generic_id=?";
		pstmt		= connection.prepareStatement(sqlQuery) ;
		pstmt.setString(1,generic_id);
	
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			form_names.add(checkForNull(resultSet.getString("form_code")));
			form_names.add(checkForNull(resultSet.getString("form_desc")));
			
		}
	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception es){ 
			es.printStackTrace() ;
		}
	}
	return form_names;
}
public ArrayList getOtherFormularyBlngGrpId()
{
	ArrayList  blgGrpIds= new ArrayList(); 
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;
	
	try{
		connection	= getConnection() ;

		String sqlQuery="SELECT distinct BLNG_GRP_ID from PH_FORMULARY_BLNG_GRP ";
//			System.err.println("sqlQuery==389==>"+sqlQuery);
		pstmt		= connection.prepareStatement(sqlQuery) ;

//	System.err.println("sqlQuery====>"+sqlQuery);
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			blgGrpIds.add(checkForNull(resultSet.getString("BLNG_GRP_ID")));
		}
	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception es){ 
			es.printStackTrace() ;
		}
	}
	return blgGrpIds;

}
public ArrayList getStrengthValues(String generic_id,String form_code){
	ArrayList  strengthValues= new ArrayList(); 
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;
	String strength_value	= "";
	try{
		connection	= getConnection() ;
		String sqlQuery="select  distinct STRENGTH_VALUE,STRENGTH_UOM,SHORT_DESC from ph_drug,am_uom where uom_code=strength_uom  and generic_id=? and form_code=?";
		pstmt		= connection.prepareStatement(sqlQuery) ;
		pstmt.setString(1,generic_id);
		pstmt.setString(2,form_code);
	
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			strength_value = resultSet.getString("STRENGTH_VALUE")==null?"":resultSet.getString("STRENGTH_VALUE");
			if(!strength_value.equals("") && !strength_value.equals("0")){
				strengthValues.add(strength_value);
				strengthValues.add(resultSet.getString("STRENGTH_UOM"));
				strengthValues.add(resultSet.getString("SHORT_DESC"));
				
			}
			
		}
	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception es){ 
			es.printStackTrace() ;
		}
	}
	return strengthValues;
}

public void clearBlgGrpID(){
	 this.selectedBlgGrpID.clear();
}

public HashMap insert(){

					
			HashMap map = new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;		
			System.err.println("inside insert method==>");
		 
			Connection connection				  = null;
			//PreparedStatement pstmt             = null ; //Commented for common-icn-0048
			ResultSet resultSet				      = null ;
			PreparedStatement pstmt_modify1       = null ;
			PreparedStatement pstmt_modify2       = null ;
			PreparedStatement pstmt_insert1       = null ;
			PreparedStatement pstmt_insert2       = null ;

			ArrayList blg_grp_list = null;


			String locale = getLanguageId()==null?"en":getLanguageId();
			 // int count=0; //Commented for common-icn-0048
			try{
				connection				= getConnection() ;
				String sql_insert1="INSERT INTO PH_FORMULARY_BLNG_GRP (FORMULARY_CODE,FORMULARY_DESC,FACILITY_ID,BLNG_GRP_TYPE,BLNG_GRP_ID,EFF_STATUS,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
				String sql_insert2="INSERT INTO PH_FORMULARY_BLNG_GRP_DTL (FORMULARY_CODE,FACILITY_ID,BLNG_GRP_TYPE,ITEM_TYPE,GENERIC_ID,ITEM_CODE,FORM_CODE,ROUTE_CODE, STRENGTH_VALUE,STRENGTH_UOM,PREFERENCE,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
				String sql_delete1="delete from PH_FORMULARY_BLNG_GRP Where FORMULARY_CODE = ? ";
				String sql_delete2="delete from PH_FORMULARY_BLNG_GRP_DTL Where FORMULARY_CODE = ? ";
				
				pstmt_modify1	= connection.prepareStatement(sql_delete1) ;
				pstmt_modify2	= connection.prepareStatement(sql_delete2) ;
				pstmt_insert1	= connection.prepareStatement(sql_insert1) ;
				pstmt_insert2	= connection.prepareStatement(sql_insert2) ;
				
				pstmt_modify1.setString(1,formulary_code);
				pstmt_modify1.executeUpdate();
				closeStatement(pstmt_modify1) ;

				pstmt_modify2.setString(1,formulary_code);
				pstmt_modify2.executeUpdate();
				closeStatement(pstmt_modify2) ;

				blg_grp_list = selectedBlgGrpID;
				System.err.println("blg_grp_list==>"+blg_grp_list);
				if(blg_grp_list!=null && blg_grp_list.size()>0){
					if(enable_status==null || enable_status.equals(""))
						enable_status = "D";
					for(int i=0;i<blg_grp_list.size();i++){
							if(((String)blg_grp_list.get(i))!=null && !((String)blg_grp_list.get(i)).equals("")){
							pstmt_insert1.setString(1,formulary_code);     
							pstmt_insert1.setString(2,formulary_desc);
							pstmt_insert1.setString(3,login_facility_id);
							pstmt_insert1.setString(4,billing_type);
							pstmt_insert1.setString(5,(String)blg_grp_list.get(i));     
							pstmt_insert1.setString(6,enable_status);
							pstmt_insert1.setString(7,login_by_id);     
							pstmt_insert1.setString(8,login_at_ws_no);
							pstmt_insert1.setString(9,login_facility_id);
							pstmt_insert1.setString(10,login_by_id);     
							pstmt_insert1.setString(11,login_at_ws_no);
							pstmt_insert1.setString(12,login_facility_id);
							pstmt_insert1.addBatch();
							}else{
							if(enable_status.equals("D") && blg_grp_list.size()==1){
								if(((String)blg_grp_list.get(0))==null){
									pstmt_insert1.setString(1,formulary_code);     
									pstmt_insert1.setString(2,formulary_desc);
									pstmt_insert1.setString(3,login_facility_id);
									pstmt_insert1.setString(4,billing_type);
									pstmt_insert1.setString(5,"");     
									pstmt_insert1.setString(6,enable_status);
									pstmt_insert1.setString(7,login_by_id);     
									pstmt_insert1.setString(8,login_at_ws_no);
									pstmt_insert1.setString(9,login_facility_id);
									pstmt_insert1.setString(10,login_by_id);     
									pstmt_insert1.setString(11,login_at_ws_no);
									pstmt_insert1.setString(12,login_facility_id);
									pstmt_insert1.addBatch();
	
								}
							}
							}
					
					}
				}else{
					if(enable_status==null || enable_status.equals(""))
						enable_status = "D";
						pstmt_insert1.setString(1,formulary_code);     
							pstmt_insert1.setString(2,formulary_desc);
							pstmt_insert1.setString(3,login_facility_id);
							pstmt_insert1.setString(4,billing_type);
							pstmt_insert1.setString(5,"");     
							pstmt_insert1.setString(6,enable_status);
							pstmt_insert1.setString(7,login_by_id);     
							pstmt_insert1.setString(8,login_at_ws_no);
							pstmt_insert1.setString(9,login_facility_id);
							pstmt_insert1.setString(10,login_by_id);     
							pstmt_insert1.setString(11,login_at_ws_no);
							pstmt_insert1.setString(12,login_facility_id);
							pstmt_insert1.addBatch();

				
				}
				int[] rowsInserted			= pstmt_insert1.executeBatch();
				boolean formulary_insert1_staus = true;
				for (int iC=0; iC<rowsInserted.length; iC++) {
					if ( rowsInserted[iC] < 0 && rowsInserted[iC] != -2) {
						connection.rollback();
						formulary_insert1_staus = false;
						break;
					}
				} 
				
				 if(formulary_insert1_staus){
			HashMap itemList =  getSelectedGenericID();
			ArrayList genericItemType =  getItemGenericType();
			//System.err.println("genericItemType=======>"+genericItemType+"==itemList==>"+itemList);
				if(genericItemType!=null && genericItemType.size()>0){

					for(int i=0;i<genericItemType.size();i++){
						String item_type = (String)genericItemType.get(i);
						ArrayList genericNameList = null;
						if(item_type.equals("D")){
							genericNameList =  getGenericNameForDrug();
						}else{
							genericNameList = getGenericNameForMedicalItem();
						}
						Collections.sort(genericNameList);

						//System.err.println("genericNameList======425==>"+genericNameList+"==itemList===>"+itemList);
					 
						for(int j=0;j<genericNameList.size();j++){
							ArrayList arr = (ArrayList)itemList.get((String)genericNameList.get(j));
							for(int k=0;k<arr.size();k=k+14){
								
								pstmt_insert2.setString(1,formulary_code);     
								pstmt_insert2.setString(2,login_facility_id);
								pstmt_insert2.setString(3,billing_type);
								pstmt_insert2.setString(4,item_type);
								pstmt_insert2.setString(5,(String)arr.get(k));     
								pstmt_insert2.setString(6,(String)arr.get(k+3));
								pstmt_insert2.setString(7,(String)arr.get(k+5)); 
								pstmt_insert2.setString(8,(String)arr.get(k+8)); 
								pstmt_insert2.setString(9,(String)arr.get(k+12));
								pstmt_insert2.setString(10,(String)arr.get(k+13));
								pstmt_insert2.setString(11,(String)arr.get(k+10));
								pstmt_insert2.setString(12,login_by_id);     
								pstmt_insert2.setString(13,login_at_ws_no);
								pstmt_insert2.setString(14,login_facility_id);
								pstmt_insert2.setString(15,login_by_id);     
								pstmt_insert2.setString(16,login_at_ws_no);
								pstmt_insert2.setString(17,login_facility_id);

								pstmt_insert2.addBatch();
																						
							}
						}
					}
					int[] rowsInserted1			= pstmt_insert2.executeBatch();
						boolean formulary_insert2_staus = true;
						for (int iC=0; iC<rowsInserted1.length; iC++) {
							if ( rowsInserted1[iC] < 0 && rowsInserted1[iC] != -2) {
								connection.rollback();
								formulary_insert2_staus = false;
								break;
							}
						}
				
				}
				
 			}
			if(formulary_insert1_staus && formulary_insert1_staus){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(locale,"RECORD_INSERTED","PH") ) ;
			}
			else{
				map.put( "message",  getMessage(locale,"TRANSACTION_FAILED","PH") );
				try{
					map.put( "result", new Boolean( false ) ) ;
					connection.rollback();
				}
				catch(Exception es){
					es.printStackTrace();
				}
			}
						
 			}
			catch(Exception e){
				map.put( "message", "exp :"+e.getMessage()) ;

				e.printStackTrace() ;
			}
			finally {
				try {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt_insert1 ) ;
					closeStatement( pstmt_modify1 ) ;
					closeStatement( pstmt_insert2 ) ;
					closeStatement( pstmt_modify2 ) ;					
					closeConnection( connection );
				}
				catch(Exception es) { 
					es.printStackTrace() ;
				}
			}
			

			return map ;		
		}

public void getFormularyDetail(String formulary_code){

	//ArrayList record = new ArrayList(); //Commented for common-icn-0048
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;
	PreparedStatement pstmt1 = null ;
	ResultSet resultSet1	 = null ;

	String strength_value	= "";
	String item_type		= "";
	String generic_name		= "";
	String form_name		= "";
	String uom_desc			= "";
	String generic_name_key = "";
	String strength_txt	    = "";


	try{
		connection	= getConnection() ;

		String selectQry = "SELECT distinct item_type, generic_id, DECODE (item_type, 'D', (SELECT generic_name  FROM ph_generic_name  WHERE generic_id = a.generic_id), (SELECT short_desc  FROM mm_item_tech_name WHERE item_tech_name_code = a.generic_id) ) generic_name,  item_code, DECODE (item_type, 'D', (SELECT drug_desc FROM ph_drug WHERE drug_code = a.item_code), (SELECT short_desc  FROM mm_item WHERE item_code = a.item_code)  ) item_desc, form_code, (SELECT form_desc FROM ph_form WHERE form_code = a.form_code) form_name, route_code,  (SELECT route_desc  FROM ph_route  WHERE route_code = a.route_code) route_desc, strength_value, strength_uom, (SELECT short_desc FROM am_uom  WHERE uom_code = strength_uom) uom_desc, preference, (SELECT unit_cost	FROM mm_item  WHERE item_code = a.item_code) unit_price  FROM ph_formulary_blng_grp_dtl a WHERE formulary_code = ? ORDER BY item_type, generic_name ";
		pstmt		= connection.prepareStatement(selectQry) ;
		pstmt.setString(1,formulary_code);

	
		resultSet	= pstmt.executeQuery();
		ArrayList preferece_item = new ArrayList();
		String unit_price = "";

		while ( resultSet != null && resultSet.next() ) {
			
			item_type		= resultSet.getString("item_type");
 			strength_value  = resultSet.getString("strength_value");
			uom_desc		= resultSet.getString("uom_desc");
			form_name		= resultSet.getString("form_name");
			generic_name	= resultSet.getString("generic_name");

			if(item_type.equals("D")){
			  generic_name_key = generic_name+"-"+form_name+"-"+strength_value+" "+uom_desc;
			  strength_txt	   = strength_value+" "+uom_desc ;
			}else{
			  generic_name_key = generic_name;
			  strength_txt	   = "";
			 }
			preferece_item.add(resultSet.getString("generic_id"));
			preferece_item.add(resultSet.getString("generic_name"));
			preferece_item.add(item_type);
			preferece_item.add(resultSet.getString("item_code"));
			preferece_item.add(resultSet.getString("item_desc"));				
			if(item_type.equals("D")){
				preferece_item.add(resultSet.getString("form_code"));
				preferece_item.add(resultSet.getString("form_name"));
				preferece_item.add(strength_txt);
				preferece_item.add(resultSet.getString("route_code"));
				preferece_item.add(resultSet.getString("route_desc"));
			}else{
				preferece_item.add("");
				preferece_item.add("");
				preferece_item.add("");
				preferece_item.add("");
				preferece_item.add("");
			}
			preferece_item.add(resultSet.getString("preference"));
			
			unit_price = resultSet.getString("unit_price");
			if(unit_price==null || unit_price.equals(""))
				unit_price = "0";


			 unit_price = setNumber(""+unit_price, getNoOfDecimals());
			preferece_item.add(unit_price);
			if(item_type.equals("D")){
				preferece_item.add(strength_value);
				preferece_item.add(resultSet.getString("strength_uom"));
			}else{
				preferece_item.add("");
				preferece_item.add("");
			}

 		
		}
//System.err.println("preferece_item===============>"+preferece_item+"==getItemGenericType()=>"+getItemGenericType()+"==setSelectedGenericID===>"+getSelectedGenericID());
					
			if(preferece_item!=null && preferece_item.size()>0){
			
				ArrayList arr = null;
				ArrayList arr1 = null;
				
				for(int i=0;i<preferece_item.size();i=i+14){
					arr = new ArrayList();
					arr1 = new ArrayList();
					item_type = (String)preferece_item.get(i+2);
					form_name = (String)preferece_item.get(i+6);
					strength_txt = (String)preferece_item.get(i+7);
					generic_name = (String)preferece_item.get(i+1);
					
					for(int k=i;k<i+14;k++){
						arr1.add((String)preferece_item.get(k));
					}
					if(item_type.equals("D")){
					  generic_name_key = generic_name+"-"+form_name+"-"+strength_txt;
					}else{
						generic_name_key = generic_name;
					}

					if(item_type!=null && item_type.equals("D")){
						genericNameForDrug =  getGenericNameForDrug();
						if(genericNameForDrug!=null && genericNameForDrug.size()>0)
						{
							if(!genericNameForDrug.contains(generic_name_key)){
								setGenericNameForDrug(generic_name_key);
							}
						}else{
							setGenericNameForDrug(generic_name_key);
						}
					}
					else{
						genericNameForMedicalItem = getGenericNameForMedicalItem();
					
						if(genericNameForMedicalItem!=null && genericNameForMedicalItem.size()>0)
						{
							if(!genericNameForMedicalItem.contains(generic_name_key)){
								setGenericNameForMedicalItem(generic_name_key);
							}
						}else{
							setGenericNameForMedicalItem(generic_name_key); 
						}
 					}
					arr.add(preferece_item.get(i+4));
					arr.add(preferece_item.get(i+6));
					arr.add(preferece_item.get(i+9));
					arr.add(preferece_item.get(i+3));
					arr.add(preferece_item.get(i+8));
					arr.add(preferece_item.get(i+11));
					arr.add(preferece_item.get(i+5));
					arr.add(preferece_item.get(i));
					HashMap item_list = getSelectedItemList();
					ArrayList arr2 = (ArrayList)item_list.get(generic_name_key);

					if(arr2!=null && arr2.size()>0){
						arr2.addAll(arr);
						setSelectedItemList(generic_name_key,arr2);
					}else{
						setSelectedItemList(generic_name_key,arr);
					}
			//System.err.println("==generic_name_key===>"+generic_name_key);


			ArrayList arr3 = (ArrayList)getSelectedGenericID().get(generic_name_key);
			if(arr3!=null && arr3.size()>0){
				arr3.addAll(arr1);
				setSelectedGenericID(generic_name_key,arr3);
			}else{
				setSelectedGenericID(generic_name_key,arr1);
			}

				if(getItemGenericType()!=null && getItemGenericType().size()>0){
					if(!getItemGenericType().contains(item_type))
						setItemGenericType(item_type);
				}else{
						setItemGenericType(item_type);
				}	
					
			}
			pstmt1 = connection.prepareStatement("select blng_grp_id from ph_formulary_blng_grp where formulary_code=?");
			pstmt1.setString(1,formulary_code);

			resultSet1	= pstmt1.executeQuery();

			while ( resultSet1 != null && resultSet1.next()) 
			{
//System.err.println("blng_grp_id====714===>"+resultSet1.getString("blng_grp_id"));
				setselectedFormularyBLGId(resultSet1.getString("blng_grp_id"),"Y");
			}

		//System.err.println("setSelectedGenericID=======699===========>"+getSelectedGenericID()+"getselectedFormularyBLGId==>"+getselectedFormularyBLGId()+"==formulary_code==>"+formulary_code);
		}

	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeResultSet( resultSet1 ) ;
			closeStatement( pstmt1 ) ;

			closeConnection( connection );
		}
		catch(Exception es){ 
			es.printStackTrace() ;
		}
	}
		
  }
	public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		try{
			connection				= getConnection() ;
			//String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			String str_qry			= "SELECT to_char(SYSDATE,'dd/mm/yyyy') SYS_DATE from dual";
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
						sys_date	=	resultSet.getString("SYS_DATE");
				}
		}catch ( Exception e ) {
				sys_date+=e.toString();
                e.printStackTrace() ;

		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
        }
		return sys_date;
	}
	public String getselectedFormularyBLGIdDesc(String blng_grp_id){
	String  billing_group_desc= ""; 
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;
	String sqlQuery = "";
	try{
		connection	= getConnection() ;
		boolean formulary_facility_appl = isSiteSpecific("PH","FORMULARY_FACILITY_APPL"); //AMRI-CRF-0464
		if(formulary_facility_appl){
		sqlQuery="select short_desc from bl_blng_grp where BLNG_GRP_ID =?";
		}else{
		sqlQuery="select short_desc from bl_blng_grp a,BL_BLNG_GRP_FACILITY b where a.BLNG_GRP_ID=b.BLNG_GRP_ID and b.facility_id=? and b.BLNG_GRP_ID =? ";
		}
		pstmt		= connection.prepareStatement(sqlQuery) ;
		if(formulary_facility_appl){ //added for AMRI-CRF-0464
		pstmt.setString(1,blng_grp_id);
		}else{
		pstmt.setString(1,login_facility_id);
		pstmt.setString(2,blng_grp_id);
		}
		resultSet	= pstmt.executeQuery();
		if(resultSet != null && resultSet.next() ) {
			
			billing_group_desc = checkForNull(resultSet.getString("short_desc"));
			
		}
		//System.err.println("billing_group_desc--->"+billing_group_desc);
	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception es){ 
			es.printStackTrace() ;
		}
	}
	return billing_group_desc;
	}
	//added for GHL-SCF-1533 - start
public ArrayList getFormularyQueryResult(String formulary_code_value,String formulary_desc_value,String formulary_type_value,String blg_grp_code_value,String nature_value,String facility_id){
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet		= null ;
	int count				= 1;
	ArrayList formularyArr = null;
	ArrayList formularyList = new ArrayList();
	try{
		connection	= getConnection() ;
		String str_append="";
		String sqlQuery = "";

		boolean formulary_facility_appl = isSiteSpecific("PH","FORMULARY_FACILITY_APPL"); //AMRI-CRF-0464
		if(!blg_grp_code_value.trim().equals(""))
			str_append =" AND a.BLNG_GRP_ID=?";

		if(formulary_facility_appl){ //added for AMRI-CRF-0464
		 sqlQuery="SELECT FORMULARY_CODE, FORMULARY_DESC, BLNG_GRP_TYPE, a.BLNG_GRP_ID,EFF_STATUS, (select b.short_desc from bl_blng_grp b where a.BLNG_GRP_ID=b.BLNG_GRP_ID ) short_desc FROM  PH_FORMULARY_BLNG_GRP a WHERE  FORMULARY_CODE LIKE UPPER(?) AND UPPER(FORMULARY_DESC) LIKE UPPER(?) AND a.BLNG_GRP_TYPE LIKE UPPER(?)  "+str_append+" AND UPPER(a.EFF_STATUS) LIKE UPPER(?)";
		}else{	
		 sqlQuery="SELECT FORMULARY_CODE, FORMULARY_DESC, BLNG_GRP_TYPE, a.BLNG_GRP_ID,EFF_STATUS, (select b.short_desc from bl_blng_grp b,BL_BLNG_GRP_FACILITY c where a.BLNG_GRP_ID=b.BLNG_GRP_ID and a.BLNG_GRP_ID=c.BLNG_GRP_ID and b.BLNG_GRP_ID=c.BLNG_GRP_ID and a.FACILITY_ID =c.FACILITY_ID ) short_desc FROM  PH_FORMULARY_BLNG_GRP a WHERE  FORMULARY_CODE LIKE UPPER(?) AND UPPER(FORMULARY_DESC) LIKE UPPER(?) AND a.BLNG_GRP_TYPE LIKE UPPER(?)  "+str_append+" AND a.FACILITY_ID=?  AND UPPER(a.EFF_STATUS) LIKE UPPER(?)";
		}
		pstmt		= connection.prepareStatement(sqlQuery) ;
		
		pstmt.setString(count++,formulary_code_value);
		pstmt.setString(count++,formulary_desc_value);
		pstmt.setString(count++,formulary_type_value);
		if(!blg_grp_code_value.trim().equals(""))
			pstmt.setString(count++,blg_grp_code_value);
		if(!formulary_facility_appl)   //added for AMRI-CRF-0464
		pstmt.setString(count++,facility_id);
		pstmt.setString(count++,nature_value);
		
		resultSet	= pstmt.executeQuery();


		while(resultSet != null && resultSet.next() ) {
			formularyArr = new ArrayList();

			formularyArr.add(resultSet.getString("FORMULARY_CODE"));
			formularyArr.add(resultSet.getString("FORMULARY_DESC"));
			formularyArr.add(resultSet.getString("BLNG_GRP_TYPE"));
			formularyArr.add(resultSet.getString("BLNG_GRP_ID"));
			formularyArr.add(resultSet.getString("EFF_STATUS"));
			formularyArr.add(resultSet.getString("short_desc"));
			
			formularyList.add(formularyArr);
		}
	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception es){ 
			es.printStackTrace() ;
		}
	}
	return formularyList;
	}
	//added for GHL-SCF-1533 - end

	public boolean checkDuplicate(String formulary_code){
	 boolean  fomulary_code_flag= false; 
	 Connection connection	= null ;
	 PreparedStatement pstmt = null ;
	 ResultSet resultSet		= null ;
	 int count = 0;
	
	 try{
		connection	= getConnection() ;
		String sqlQuery="select count(*) cunt from PH_FORMULARY_BLNG_GRP where formulary_code=?";
		pstmt		= connection.prepareStatement(sqlQuery) ;
		pstmt.setString(1,formulary_code);

	
		resultSet	= pstmt.executeQuery();
		if(resultSet != null && resultSet.next() ) {
			count = resultSet.getInt("cunt");
		}
		if(count>0)
			fomulary_code_flag = true;
		else
			fomulary_code_flag = false;

		//System.err.println("billing_group_desc--->"+billing_group_desc);
	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception es){ 
			es.printStackTrace() ;
		}
	}
	return fomulary_code_flag;
	
	}
	public void getNoOfDecimalsCost(){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		int  st_no_of_decimals	= 0;
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement("SELECT NVL(NO_OF_DECIMALS_FOR_COST,0) NO_OF_DECIMALS_FOR_COST FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = 'ZZ'");
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
					st_no_of_decimals = Integer.parseInt(checkForNull(resultSet.getString("NO_OF_DECIMALS_FOR_COST"),"0"));		

			}
			setNoOfDecimals(st_no_of_decimals);
		}catch(Exception e){
		
			e.printStackTrace();
		}	
		finally { //common-icn-0029
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception es){ 
			es.printStackTrace() ;
		}
	}

		
	}


	public String setNumber(String stNumber, int decimalPlaces){
		String returnNumber	=	"0";
		try { 
		String fmt = "0";
		for(int i=0;i<decimalPlaces;i++){
			if(i==0)
				fmt=fmt+".";
			fmt=fmt+"0";
		}

		java.text.DecimalFormat df = new java.text.DecimalFormat(fmt);
		returnNumber = df.format(Double.parseDouble(stNumber));
				}
		catch (Exception exception) {
		//	exception.printStackTrace();
		}
		return returnNumber;
	}

		public boolean isSiteSpecific(String moduleId, String functionalityId){ //AMRI-CRF-0464
		boolean site=false;
	    Connection con	= null;  
        try{
        	con =			getConnection();		
        	site = eCommon.Common.CommonBean.isSiteSpecific(con,moduleId,functionalityId);	
		}
        catch(Exception e){
            e.printStackTrace();
        }
		finally{
			try{
			closeConnection(con);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return site;
   }

}


	