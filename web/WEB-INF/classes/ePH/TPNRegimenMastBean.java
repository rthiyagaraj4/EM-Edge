/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 *****************************************************************************
 Date       		Edit History     Name      			Rev.Date		Rev.Name		                   Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?				 ?				 ?				    ?			    ?								   ?
29/01/2019		    IN068728		 Devindra				 		                                       ML-MMOH-CRF-1266 [IN:068728]
---------------------------------------------------------------------------------------------------------------------------------------------------------
 */
package ePH ;

import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.TPNRegimenMast.*;
//saved on 25/10/2005
public class TPNRegimenMastBean extends PhAdapter implements Serializable {
	/* Variable Declarations start */
	ArrayList constituents			= new ArrayList();
	HashMap masterform			= new HashMap();
	HashMap record1			= new HashMap();
	HashMap ordering_dispensing		= new HashMap();
	HashMap header					= new HashMap();
	String external_drug			= "";
	private String total_energy		= "";
	private String lipid_emulsion_type		= "";
	private String npc_ratio		= "";
	private String drug_item_code_ind = "";
	protected String or_yn			= "";
	protected String total_volume	=	"";
	String	item_code="";
	String	standard_regimen_yn="";

	/* Variable Declarations end */
	
	public void setTotalEnergy(String total_energy){
		this.total_energy = total_energy;
	}

	public String getTtlEnrgy(){
		return total_energy;
	}

	public void setLipidEmulsion(String lipid_emulsion_type){
		this.lipid_emulsion_type = lipid_emulsion_type;
	}

	public String getLipidEmulsion(){
		return lipid_emulsion_type;
	}

	public void setDrugItemCodeInd(String drug_item_code_ind){
		this.drug_item_code_ind = drug_item_code_ind;
	}

	public String getDrugItemCodeInd(){
		return drug_item_code_ind;
	}

	public void setNpcRatio(String npc_ratio){
		this.npc_ratio = npc_ratio;
	}

	public String getNpcRatio(){
		return npc_ratio;
	}

	public TPNRegimenMastBean() {
		try {
			doCommon();
		}
		catch(Exception e) {System.err.println("error in start:"+e);
		}
	}

	/* Set and get methods */
	public void setConstituents(ArrayList constituents) {
		this.constituents = constituents;
	}
	
	public void setMasterform(HashMap masterform) {
		this.masterform = masterform;
	}

	public void setHeader(HashMap header) {
		this.header = header;
	}

	public void setTempVal(HashMap	record1){
		this.record1=record1;
	}

	public void setOrdDispensing(HashMap ordering_dispensing) {
		this.ordering_dispensing = ordering_dispensing;
	}

	public void setExternalDrug(String external_drug) {
		this.external_drug = external_drug;
	}

	public void setORModuleYN(String or_yn)	{
		this.or_yn = or_yn;
	}

	public void setTotalVolume(String total_volume) {
		this.total_volume	=	total_volume;
	}
	
	public String getTotalVolume() {
		return this.total_volume;
	}

	
	public String getExternalDrug() {
		return this.external_drug;
	}

	public ArrayList getConstituents() {
		return this.constituents;
	}

	public HashMap getMasterform() {
		return this.masterform;
	}


	public HashMap getOrdDispensing() {
		return this.ordering_dispensing;
	}

	public HashMap getHeader()	{
		return this.header;
	}

	public String getValue(String generic_code) {
		String value = "";

		for(int i=0; i<constituents.size(); i++) {
			HashMap	record = (HashMap)constituents.get(i);
			if(((String)record.get("const_generic_code")).equals(generic_code)) {
				value = (String)record.get("const_weight");
				break;
			}
		}
		return value;
	}
	public String getTempVal(String generic_code){
		
		String temp="";


		for (int i=0;i< record1.size();i++ )
		{
			temp=(String)record1.get("const_generic_code");
			if(temp.equals(generic_code)){
			temp=(String)record1.get("const_weight");

			break;
			}
		}
		
	return temp;
	}

	public String getPerc(String generic_code) {
		String value = "";

		for(int i=0; i<constituents.size(); i++) {
			HashMap	record = (HashMap)constituents.get(i);
			if(((String)record.get("const_generic_code")).equals(generic_code)) {
					value = (String)record.get("const_perc");
				break;
			}
		}
		return value;
	}

	public String getVolume(String generic_code) {
		String value = "";

		for(int i=0; i<constituents.size(); i++) {
			HashMap	record = (HashMap)constituents.get(i);
			if(((String)record.get("const_generic_code")).equals(generic_code)) {
				value = (String)record.get("const_vol");
				break;
			}
		}
		return value;
	}
	/* Set and get methods */

    /* Over-ridden Adapter methods start here */
	public void clear() {
		super.clear() ;
		constituents		= new ArrayList();
		ordering_dispensing	= new HashMap();
		header				= new HashMap();
		external_drug		= "";
		or_yn				= "";
		total_volume		=	"";
		total_energy		= "";
		lipid_emulsion_type		= "";
		npc_ratio			= "";
		drug_item_code_ind  = "";
    }

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
        map.put("result", new Boolean(false));
        map.put("message", "before validating..");

		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;

		try {
			if (mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				connection	= getConnection();
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT3"));
				pstmt.setString(1,(String)header.get("tpn_regimen_code"));
				resultSet	= pstmt.executeQuery();

				if (resultSet != null && resultSet.next()) {
					if(!((String)resultSet.getString("COUNT")).equals("0")) {
						map.put("result", new Boolean(false));
						map.put("message", getMessage(getLanguageId(),"CODE_ALREADY_EXISTS", "Common"));
					}
					else {
						map.put("result", new Boolean(true));
					}
				}
				else {
					map.put("result", new Boolean(true));
				}
			}
			else {
				map.put("result", new Boolean(true));
			}
		}
		catch(Exception e) {
			System.err.println("error in validate:"+e);
		}
		finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return map;
	}

	public HashMap insert() {
		HashMap tabData = new HashMap() ;

		tabData.put("PROPERTIES", getProperties());
		tabData.put("header", header);
		tabData.put("constituents", getConstituents());
//		tabData.put( "masterform", getMasterform());
		tabData.put("ord_disp", getOrdDispensing());
		tabData.put("external_drug", getExternalDrug());
		tabData.put("total_energy", getTtlEnrgy());
		tabData.put("npc_ratio", getNpcRatio());
		tabData.put("drug_item_code_ind", getDrugItemCodeInd());
		tabData.put("lipid_emulsion", getLipidEmulsion());
		tabData.put("login_facility_id", login_facility_id.trim() );
		tabData.put("login_at_ws_no", login_at_ws_no.trim());
		tabData.put("login_by_id", login_by_id.trim());

		HashMap sqlMap = new HashMap() ;
		try {
			
			String SQL_PH_TPN_REGIMEN_MAST_INSERT1="INSERT INTO PH_TPN_REGIMEN(TPN_REGIMEN_CODE, STANDARD_REGIMEN_YN, SYSTEM_CREATED_YN, SHORT_NAME, LONG_NAME, ITEM_CODE, DFLT_TPN_ROUTE, TOTAL_VOLUME, PRES_BASE_UNIT, CONTENT_IN_BASE_UNIT, TOT_CAL, DRUG_CLASS, SCHEDULE_ID, PRES_CATG_CODE, INFUSE_OVER_VALUE, INFUSE_OVERDURN_TYPE, DISP_AUTH_REQD_YN, DISP_VIA_PRES_ONLY_YN, DISP_AGAINST_DAMAGE_YN, ORDER_TYPE_CODE, CAUTION_LABEL_TEXT_ID_1, CAUTION_LABEL_TEXT_ID_2, SPL_INSTR_LABEL_TEXT_ID, HOW_TO_TAKE_TEXT, EXTERNAL_PRODUCT_ID, DISCONTINUED_YN, DISCONTINUED_REASON, DISCONTINUED_DATE, DISCONTINUED_BY_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,SINGLE_EMULSION_YN,PPN_YN,NPC_VALUE,PEAD_TPN_REGIMEN_YN,OVERAGE_VOLUME) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?,?,?,?)";
			
			
			sqlMap.put("SQL_PH_TPN_REGIMEN_MAST_SELECT10", PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT10"));
			sqlMap.put("SQL_PH_TPN_REGIMEN_MAST_SELECT12", PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT12"));
			
			//sqlMap.put("SQL_PH_TPN_REGIMEN_MAST_INSERT1", PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_INSERT1"));
			sqlMap.put("SQL_PH_TPN_REGIMEN_MAST_INSERT1",SQL_PH_TPN_REGIMEN_MAST_INSERT1);
			
			sqlMap.put("SQL_PH_TPN_REGIMEN_MAST_INSERT2", PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_INSERT2"));

			sqlMap.put("SQL_PH_TPN_REGIMEN_MAST_INSERT3", PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_INSERT3"));
			

			sqlMap.put("SQL_AM_UOM_EQVL_SELECT", PhRepository.getPhKeyValue("SQL_AM_UOM_EQVL_SELECT"));
			
		}
		catch (Exception e) {
			System.err.println("Error loading queries from Repository");
			e.printStackTrace();
		}
//System.err.println("tabData ---- "+tabData);
 		return callFunctionEJB( tabData,sqlMap );
	}

	public HashMap modify() {
		HashMap tabData = new HashMap() ;
		tabData.put( "PROPERTIES", getProperties() );
		tabData.put( "header", header);
		tabData.put( "constituents", getConstituents());
//		tabData.put( "masterform", getMasterform());
		tabData.put( "ord_disp", getOrdDispensing());
		tabData.put( "external_drug", getExternalDrug());
		tabData.put("total_energy", getTtlEnrgy());
		tabData.put("npc_ratio", getNpcRatio());
		tabData.put("drug_item_code_ind", getDrugItemCodeInd());
		tabData.put("lipid_emulsion", getLipidEmulsion());
		tabData.put( "login_facility_id", login_facility_id.trim() );
		tabData.put( "login_at_ws_no", login_at_ws_no.trim());
		tabData.put( "login_by_id", login_by_id.trim());

		HashMap sqlMap = new HashMap() ;
		try{

			String SQL_PH_TPN_REGIMEN_MAST_UPDATE1="UPDATE PH_TPN_REGIMEN SET STANDARD_REGIMEN_YN=?, SYSTEM_CREATED_YN=?, SHORT_NAME=?, LONG_NAME=?, ITEM_CODE=?, DFLT_TPN_ROUTE=?, TOTAL_VOLUME=?, PRES_BASE_UNIT=?, CONTENT_IN_BASE_UNIT=?, TOT_CAL=?, DRUG_CLASS=?, SCHEDULE_ID=?, PRES_CATG_CODE=?, INFUSE_OVER_VALUE=?, INFUSE_OVERDURN_TYPE=?, DISP_AUTH_REQD_YN=?, DISP_VIA_PRES_ONLY_YN=?, DISP_AGAINST_DAMAGE_YN=?, ORDER_TYPE_CODE=?, CAUTION_LABEL_TEXT_ID_1=?, CAUTION_LABEL_TEXT_ID_2=?, SPL_INSTR_LABEL_TEXT_ID=?, HOW_TO_TAKE_TEXT=?, EXTERNAL_PRODUCT_ID=?, DISCONTINUED_YN=?, DISCONTINUED_REASON=?, DISCONTINUED_DATE=?, DISCONTINUED_BY_ID=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,SINGLE_EMULSION_YN=?, PPN_YN=?, NPC_VALUE=?, PEAD_TPN_REGIMEN_YN=?, OVERAGE_VOLUME=? WHERE TPN_REGIMEN_CODE=?";
			sqlMap.put("SQL_PH_TPN_REGIMEN_MAST_UPDATE1",SQL_PH_TPN_REGIMEN_MAST_UPDATE1);
			sqlMap.put("SQL_PH_TPN_REGIMEN_MAST_DELETE1",PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_DELETE1"));
			sqlMap.put("SQL_PH_TPN_REGIMEN_MAST_INSERT2",PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_INSERT2"));
		}
		catch (Exception e) {
			System.err.println("Error loading queries from Repository");
			e.printStackTrace();
		}
		return callFunctionEJB( tabData,sqlMap );
	}

	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode"));

		if(recordSet.containsKey("standard_regimen_yn")) {

			if( ((String)recordSet.get("standard_regimen_yn")).equals("")) {
				header.put("standard_regimen_yn","N");
		}
	
		if(((String)recordSet.get("standard_regimen_yn")).equals("Y")) {
			header.put("standard_regimen_yn",(String)recordSet.get("standard_regimen_yn"));
		}
		}
		if(recordSet.containsKey("tpn_regimen_code"))
			header.put("tpn_regimen_code",(String)recordSet.get("tpn_regimen_code"));

		if(recordSet.containsKey("short_name"))
			header.put("short_name",(String)recordSet.get("short_name"));

		if(recordSet.containsKey("long_name"))
			header.put("long_name",(String)recordSet.get("long_name"));

		if(recordSet.containsKey("overage_volume"))
		header.put("overage_volume",(String)recordSet.get("overage_volume"));

/*
		if(recordSet.containsKey("pediatric_regimen"))
			if(((String)recordSet.get("pediatric_regimen")).equals(""))
				header.put("pediatric_regimen","N");
			else
				header.put("pediatric_regimen",(String)recordSet.get("pediatric_regimen"));

*/

		if(recordSet.containsKey("pead_tpn_regimen_yn")) {

			if( ((String)recordSet.get("pead_tpn_regimen_yn")).equals("")) {
				header.put("pead_tpn_regimen_yn","N");
		}
	
		if(((String)recordSet.get("pead_tpn_regimen_yn")).equals("Y")) {
			header.put("pead_tpn_regimen_yn",(String)recordSet.get("pead_tpn_regimen_yn"));
		}
		}


		if(recordSet.containsKey("dflt_tpn_route"))
			header.put("dflt_tpn_route",(String)recordSet.get("dflt_tpn_route"));


		if(recordSet.containsKey("item_code")){
			header.put("item_code",(String)recordSet.get("item_code"));
		}

/*			if(recordSet.containsKey("item_code"))
			header.put("item_code",item_code);
*/
		if(recordSet.containsKey("single_emulsion"))
			if(((String)recordSet.get("single_emulsion")).equals(""))
				header.put("single_emulsion","N");
			else
				header.put("single_emulsion",(String)recordSet.get("single_emulsion"));

		if(recordSet.containsKey("ppn"))
			if(((String)recordSet.get("ppn")).equals(""))
				header.put("ppn","N");
			else
				header.put("ppn",(String)recordSet.get("ppn"));


		

		if(recordSet.containsKey("pres_base_uom"))
			header.put("pres_base_uom",(String)recordSet.get("pres_base_uom"));

		
			header.put("total_volume",getTotalVolume());


	}

	private void doCommon() throws Exception {
	}
	/* Over-ridden Adapter methods end here */

	/* Function specific methods starts */
	public ArrayList loadSchedule(String locale )	{
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		ArrayList schedule		= new ArrayList();

		try {
			connection	= getConnection() ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT7") ) ;
			pstmt		= connection.prepareStatement("SELECT SCHEDULE_ID,SCHEDULE_DESC,DISP_AUTH_REQD_YN FROM PH_DRUG_SCHEDULE_LANG_VW PH_DRUG_SCHEDULE WHERE EFF_STATUS='E' AND LANGUAGE_ID = ? ORDER BY 2") ;
			pstmt.setString(1,locale);
			resultSet	= pstmt.executeQuery();
			while (resultSet != null && resultSet.next()) {
				schedule.add(checkForNull(resultSet.getString("SCHEDULE_ID")));
				schedule.add(checkForNull(resultSet.getString("SCHEDULE_DESC")));
			}
		}
		catch(Exception e) {
			System.err.println("Exception while loading schedule:"+e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){System.err.println("Exception while loading schedule:"+es);}
		}
		return schedule;
	}

	public ArrayList loadCategory(String locale) {
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		ArrayList category		= new ArrayList();

		try {
			connection	= getConnection();
		//	pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT6"));
		    pstmt		= connection.prepareStatement("SELECT DRUG_CATG_CODE, SHORT_DESC FROM PH_DRUG_CATG_LANG_VW PH_DRUG_CATG WHERE EFF_STATUS='E' AND LANGUAGE_ID = ? ORDER BY 2");
			pstmt.setString(1,locale);
			resultSet	= pstmt.executeQuery();
			while (resultSet != null && resultSet.next()) {
				category.add(checkForNull(resultSet.getString("DRUG_CATG_CODE")));
				category.add(checkForNull(resultSet.getString("SHORT_DESC")));
			}
		}
		catch(Exception e) {
			System.err.println("Exception while loading category:"+e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Exception while loading category:"+es);}
		}
		return category;
	}

	public HashMap loadLabels(String locale) {
		HashMap labels				= new HashMap();
		ArrayList caution_label_1	= new ArrayList();
		ArrayList caution_label_2	= new ArrayList();
		ArrayList spl_instruction	= new ArrayList();

		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;

		try {
			connection	= getConnection() ;
		/*********** Initialize the values for Caution***************/
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT8") ) ;
			pstmt		= connection.prepareStatement("SELECT LABEL_TEXT_ID, LABEL_TEXT_1,LABEL_TEXT_2 FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_TYPE='C' AND EFF_STATUS='E' AND LANGUAGE_ID= ? ORDER BY 2,3") ;
			pstmt.setString(1,locale);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				caution_label_1.add(checkForNull(resultSet.getString( "label_text_id" )));
				caution_label_1.add(checkForNull(resultSet.getString( "label_text_1" )));
				caution_label_2.add(checkForNull(resultSet.getString( "label_text_id" )));
				caution_label_2.add(checkForNull(resultSet.getString( "label_text_2" )));
			}

		/*********** Initialize the values for Special Instruction***************/
			if(resultSet!=null)		closeResultSet(resultSet);
			if(pstmt!=null)			closeStatement(pstmt);
			
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT9") ) ;
			pstmt.setString(1,locale);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				spl_instruction.add(checkForNull(resultSet.getString( "label_text_id" )));
				spl_instruction.add(checkForNull(resultSet.getString( "label_text_1" )));
			}
		}
		catch(Exception e) {
			System.err.println( "Error loading Caution Labels :"+e );
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){System.err.println( "Error loading Caution Labels :"+es );}
		}
		labels.put("caution_label_1", caution_label_1);
		labels.put("caution_label_2", caution_label_2);
		labels.put("spl_instruction", spl_instruction);
		return labels;
	}

	public ArrayList displayConsGroup() {
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		ArrayList cons_group	= new ArrayList();

		try {
			connection	= getConnection() ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT2") ) ;
			pstmt		= connection.prepareStatement("SELECT A.CONST_GROUP_CODE,A.CONST_GROUP_NAME, A.DISP_SRL_NO  FROM PH_TPN_CONST_GRP_LANG_VW A    WHERE EFF_STATUS='E' AND a.const_group_code IN (SELECT CONST_GROUP_CODE FROM PH_TPN_PARAM_FOR_CONST WHERE GROUP_OR_INDIVIDUAL_IND = 'G')   AND A.LANGUAGE_ID = ? ORDER BY DISP_SRL_NO") ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while (resultSet != null && resultSet.next()) {
				cons_group.add(checkForNull(resultSet.getString( "CONST_GROUP_CODE" ))) ;
				cons_group.add(checkForNull(resultSet.getString( "CONST_GROUP_NAME" ))) ;
			}
		}
		catch(Exception e) {
			System.err.println("Exception while getting group name:"+e);
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Exception while getting group name:"+es);}
		}
		return cons_group;
	}

	public String checkStandardRegimen(String tpn_regimen_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String standard_yn		=	"";

		try {
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT7"));
			pstmt.setString(1, tpn_regimen_code.trim());
			resultSet	= pstmt.executeQuery();
			if (resultSet.next()) {
				standard_yn	= resultSet.getString("STANDARD_REGIMEN_YN");
			}


		}
		catch(Exception e) {
			System.err.println("Exception while checking standard regimen:" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Exception while checking standard regimen:" + es);}
		}
		return standard_yn;
	}

	public boolean checkValidItem(String base_unit, String item_code) {
//System.err.println("base_unit ---- "+base_unit);
//System.err.println("item_code ---- "+item_code);
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		boolean item_exists		= false;
		String sale_code		=	"";
		String code				=	"";

		try {
			connection	= getConnection() ;
			
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT9"));
			pstmt.setString(1, item_code.trim());
			resultSet	= pstmt.executeQuery();
			if (resultSet.next()) {
				sale_code	=resultSet.getString("SALE_UOM_CODE");
			}
			
//System.err.println("sale_code ---- "+sale_code);
			if(resultSet!=null)		closeResultSet(resultSet);
			if(pstmt!=null)			closeStatement(pstmt);

			if(sale_code.equals(base_unit.trim())){
				item_exists	= true;
			}else{
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_AM_UOM_EQVL_SELECT"));
				pstmt.setString(1, base_unit.trim());
				pstmt.setString(2, sale_code.trim());
				pstmt.setString(3, sale_code.trim());
				pstmt.setString(4, base_unit.trim());
				resultSet	= pstmt.executeQuery();
				while (resultSet!=null && resultSet.next()) {
				code	=resultSet.getString("EQVL_VALUE");
//System.err.println("code at 621 --- "+code);
					if(!code.equals("")) {
					item_exists	= true;
					break;
					}
				}
			}
		}
		catch(Exception e) {
			System.err.println("Exception while comparing item:" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Exception while comparing item:" + es);}
		}
//System.err.println("item_exists  -- "+item_exists);
		return item_exists;

	}

	public boolean getDrugStatusInOR(String drug_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		boolean drug_exists		= false;

		try {
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT4"));
			pstmt.setString(1, drug_code.trim());
			resultSet	= pstmt.executeQuery();
			if (resultSet.next()) {
				drug_exists	= true;
			}
		}
		catch(Exception e) {
			System.err.println("Exception while getting drug status:" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Exception while getting drug status:" + es);}
		}
		return drug_exists;
	}

	public ArrayList getLegends(String group_code) {
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		ArrayList legends		= new ArrayList();
		boolean micro_nut_enterable_yn  = false; // Added for ML-MMOH-CRF-1266 [IN:068728]
// System.err.println("group_code------------>"+group_code);
		try {
			connection	= getConnection() ;
			micro_nut_enterable_yn = CommonBean.isSiteSpecific(connection, "PH", "MACRO_ENTERABLE_YN"); // Added for ML-MMOH-CRF-1266 [IN:068728]
			if(group_code.equals("OT") || group_code.equals("TR"))
				
			//	pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT11") ) ;
				pstmt		= connection.prepareStatement("SELECT C.CONST_GENERIC_CODE, C.CONST_GENERIC_NAME, UOM_SETUP_LEVEL_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW AM_UOM WHERE UOM_CODE = b.REGIMEN_SETUP_UNIT AND EFF_STATUS='E' AND LANGUAGE_ID = ?)unit_desc, regimen_setup_unit FROM PH_TPN_CONST_GEN_NAME_LANG_VW C, PH_TPN_PARAM_FOR_CONST B WHERE C.CONST_GROUP_CODE=?  AND c.const_Group_code=b.const_group_code AND c.UOM_SETUP_LEVEL_IND=b.GROUP_OR_INDIVIDUAL_IND AND disp_srl_no = srl_no AND C.EFF_STATUS = 'E' AND C.LANGUAGE_ID = ? ORDER BY C.CONST_GENERIC_NAME") ; // C.EFF_STATUS Added for ML-MMOH-CRF-1266 [IN:068728]
			else if(group_code.equals("MN") && micro_nut_enterable_yn) // else if Added for ML-MMOH-CRF-1266 [IN:068728] - Start
				pstmt       = connection.prepareStatement("/* Formatted on 2019/01/28 12:20 (Formatter Plus v4.8.8) */ SELECT c.const_generic_code, c.const_generic_name, uom_setup_level_ind, (SELECT short_desc FROM am_uom_lang_vw am_uom WHERE uom_code = b.regimen_setup_unit AND eff_status = 'E' AND language_id = ?) unit_desc, regimen_setup_unit FROM ph_tpn_const_gen_name_lang_vw c, ph_tpn_param_for_const b,ph_tpn_energy_for_const a WHERE c.const_group_code = ? AND c.const_group_code = b.const_group_code AND c.uom_setup_level_ind = b.group_or_individual_ind AND c.eff_status = 'E' AND c.const_generic_code = a.constituent_code AND c.language_id = ? ORDER BY c.const_generic_name"); // else if Added for ML-MMOH-CRF-1266 [IN:068728] - End
			else
				//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT1") ) ;
				pstmt		= connection.prepareStatement("SELECT C.CONST_GENERIC_CODE, C.CONST_GENERIC_NAME, UOM_SETUP_LEVEL_IND,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW AM_UOM WHERE UOM_CODE = b.REGIMEN_SETUP_UNIT AND EFF_STATUS='E' AND LANGUAGE_ID = ? )unit_desc, regimen_setup_unit FROM PH_TPN_CONST_GEN_NAME_LANG_VW C, PH_TPN_PARAM_FOR_CONST B WHERE C.CONST_GROUP_CODE=?  AND c.const_Group_code=b.const_group_code AND c.UOM_SETUP_LEVEL_IND=b.GROUP_OR_INDIVIDUAL_IND and C.EFF_STATUS = 'E' AND C.LANGUAGE_ID = ? ORDER BY C.CONST_GENERIC_NAME") ; // C.EFF_STATUS Added for ML-MMOH-CRF-1266 [IN:068728]
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,group_code);
			pstmt.setString(3,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while (resultSet != null && resultSet.next()) {
				if(!legends.contains(resultSet.getString( "CONST_GENERIC_CODE" ))) {
					legends.add(checkForNull(resultSet.getString( "CONST_GENERIC_CODE" ))) ;
					legends.add(checkForNull(resultSet.getString( "CONST_GENERIC_NAME" ))) ;
					legends.add(checkForNull(resultSet.getString( "REGIMEN_SETUP_UNIT" ))) ;
					legends.add(checkForNull(resultSet.getString( "UNIT_desc" ))) ;
				}
			}
		}
		catch(Exception e) {
			System.err.println("Exception while getting legends:"+e);
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Exception while getting legends:"+es);}
		}
		return legends;
	}

	public String getPrescBaseUOM()	{
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String pres_base_uom	= "";

		try {
//System.err.println("getLanguageId() at 723 --- "+getLanguageId());
			connection  = getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT5"));
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				pres_base_uom = resultSet.getString("SHORT_DESC");
				pres_base_uom += "|" + resultSet.getString("UOM_CODE");
			}
		}
		catch(Exception e) {

			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				System.out.println("Error while getting PRES_BASE_UOM:" + es);
				es.printStackTrace();
			}
		}
//System.err.println("pres_base_uom at 748 --- "+pres_base_uom);
		return pres_base_uom;
	}

	public String getORModuleYN() {
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String module_id		= "";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT11"));
			resultSet	= pstmt.executeQuery();

			while(resultSet.next()) {
				module_id = resultSet.getString("MODULE_ID");

				if ((module_id.trim().equals("OR"))) {
					setORModuleYN("Y");
				}
			}
		}
		catch(Exception e) {
			System.err.println("Error while checking OR installation :" + e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error while checking OR installation :" + es);}
		}
		return this.or_yn;
	}

	public void loadRegimenValues(String tpn_regimen_code) {
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
//System.err.println("tpn_regimen_code ---|"+tpn_regimen_code+"|--");
		try {
			String sql = "SELECT SHORT_NAME, LONG_NAME, ITEM_CODE, DFLT_TPN_ROUTE, TOTAL_VOLUME, PRES_BASE_UNIT, SCHEDULE_ID, PRES_CATG_CODE, INFUSE_OVER_VALUE, INFUSE_OVERDURN_TYPE,   DISP_AUTH_REQD_YN, DISP_VIA_PRES_ONLY_YN, DISP_AGAINST_DAMAGE_YN, CAUTION_LABEL_TEXT_ID_1, CAUTION_LABEL_TEXT_ID_2, SPL_INSTR_LABEL_TEXT_ID, HOW_TO_TAKE_TEXT, EXTERNAL_PRODUCT_ID, SINGLE_EMULSION_YN, PPN_YN,PEAD_TPN_REGIMEN_YN,OVERAGE_VOLUME FROM PH_TPN_REGIMEN_LANG_VW PH_TPN_REGIMEN WHERE TPN_REGIMEN_CODE = ? AND LANGUAGE_ID = ?";
			connection	= getConnection();
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT5"));
			pstmt		= connection.prepareStatement( sql);
			pstmt.setString(1, tpn_regimen_code);
			pstmt.setString(2, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet != null && resultSet.next()) {

				header.put("short_name",checkForNull(resultSet.getString( "SHORT_NAME" ))) ;
				header.put("long_name",checkForNull(resultSet.getString( "LONG_NAME" ))) ;
				header.put("item_code",checkForNull(resultSet.getString( "ITEM_CODE" ))) ;
				header.put("dflt_tpn_route",checkForNull(resultSet.getString( "DFLT_TPN_ROUTE" ))) ;
				header.put("long_name",checkForNull(resultSet.getString( "LONG_NAME" ))) ;
				header.put("item_code",checkForNull(resultSet.getString( "ITEM_CODE" ))) ;
				header.put("single_emulsion",checkForNull(resultSet.getString( "SINGLE_EMULSION_YN" ))) ;
				header.put("total_volume",checkForNull(resultSet.getString( "TOTAL_VOLUME" ))) ;
				header.put("ppn",checkForNull(resultSet.getString( "PPN_YN" ))) ;

				header.put("pead_tpn_regimen_yn",checkForNull(resultSet.getString( "PEAD_TPN_REGIMEN_YN" ))) ;
				header.put("overage_volume",checkForNull(resultSet.getString( "OVERAGE_VOLUME" ))) ;


				ordering_dispensing.put("schedule_id",checkForNull(resultSet.getString( "SCHEDULE_ID" )));
				ordering_dispensing.put("prescribing_catg",checkForNull(resultSet.getString( "PRES_CATG_CODE" )));
				ordering_dispensing.put("infuse_over",checkForNull(resultSet.getString( "INFUSE_OVER_VALUE" )));
				ordering_dispensing.put("infuse_over_list",checkForNull(resultSet.getString( "INFUSE_OVERDURN_TYPE" )));
				ordering_dispensing.put("authorize_yn",checkForNull(resultSet.getString( "DISP_AUTH_REQD_YN" )));
				ordering_dispensing.put("disp_via_pres",checkForNull(resultSet.getString( "DISP_VIA_PRES_ONLY_YN" )));
				ordering_dispensing.put("disp_against_damage",checkForNull(resultSet.getString( "DISP_AGAINST_DAMAGE_YN" )));
				ordering_dispensing.put("caution_label_1",checkForNull(resultSet.getString( "CAUTION_LABEL_TEXT_ID_1" )));
				ordering_dispensing.put("caution_label_2",checkForNull(resultSet.getString( "CAUTION_LABEL_TEXT_ID_2" )));
				ordering_dispensing.put("spl_instruction",checkForNull(resultSet.getString( "SPL_INSTR_LABEL_TEXT_ID" )));
				ordering_dispensing.put("patient_direction",checkForNull(resultSet.getString( "HOW_TO_TAKE_TEXT" )));
				setExternalDrug(checkForNull(resultSet.getString( "EXTERNAL_PRODUCT_ID" )));
			}
//System.err.println("header   --- "+header);
//System.err.println("ordering_dispensing   --- "+ordering_dispensing);
			if(resultSet!=null)		closeResultSet(resultSet);
			if(pstmt!=null)			closeStatement(pstmt);
//			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_MAST_SELECT6") ) ;
			pstmt.setString(1,tpn_regimen_code);
			resultSet	= pstmt.executeQuery();
			while (resultSet != null && resultSet.next()) {
				HashMap	record	=	new HashMap();
				record.put("const_generic_code",checkForNull(resultSet.getString( "CONST_GENERIC_CODE" )));
				record.put("const_weight",checkForNull(resultSet.getString( "CONST_WEIGHT" )));
				record.put("const_weight_unit",checkForNull(resultSet.getString( "CONST_WEIGHT_UNIT" )));
				record.put("const_perc",checkForNull(resultSet.getString( "CONST_CONCENTRATION_PERC" )));
				record.put("const_vol",checkForNull(resultSet.getString( "CONST_VOLUME" )));
				constituents.add(record);
			}
//System.err.println("constituents --- "+constituents);
		}
		catch(Exception e) {
			System.err.println("Exception while loading standard regimen:"+e);
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Exception while loading standard regimen:"+es);}
		}
	}
	/* Function specific methods end */

	private  HashMap callFunctionEJB(HashMap tabData, HashMap sqlMap) {
		
		HashMap map = new HashMap() ;
		map.put("result", new Boolean(false));

	//	TPNRegimenMastHome home = null;
	//	TPNRegimenMastRemote remote = null;

		try {
/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_TPN_REGIMEN_MAST"));
			home  = (TPNRegimenMastHome) PortableRemoteObject.narrow( object, TPNRegimenMastHome.class ) ;
			remote = home.create() ;
				
			System.err.println("mode is"+mode); 
			if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
				map = remote.insert(tabData, sqlMap);

			
			} else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			System.err.println("tabData from bean in modify :"+tabData);
				map = remote.modify(tabData, sqlMap); 
			}*/




 Object home =  com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TPN_REGIMEN_MAST" ),TPNRegimenMastHome.class,getLocalEJB());

 Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);

 Object argArray[] =new Object[2];
 argArray[0]= tabData;
 argArray[1]=sqlMap;

 Class  paramArray[] = new Class[2];
 paramArray[0]= tabData.getClass();
 paramArray[1] = sqlMap.getClass();
		

if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
         map  = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
}
else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
     map  = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
}



		if (((Boolean) map.get("result")).booleanValue())
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
		}
		catch(Exception e) {
			System.err.println("Error Calling EJB classcast : "+e);
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
/*		finally {
			try {
				if( remote != null )
					remote.remove() ; 
			}
			catch( Exception ee ) {
				System.err.println(ee.getMessage());
				map.put("message", ee.getMessage());
			}
		}*/
		return map;
	}

// Function getTotalEnergy() is to calculate the total energy of Carbohydrates, Proteins etc
public void getTotalEnergy(String tpn_regimen_code)	{
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String total_energy	= "";

		try {
			connection  = getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT10"));
			pstmt.setString(1,tpn_regimen_code);
			resultSet	= pstmt.executeQuery();

			if(resultSet.next()){
					total_energy = resultSet.getString("TOT_CAL");
			}
			if(total_energy == null) total_energy = "";
		}
		catch(Exception e) {
			System.out.println("Error while getting Total energy from table:" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.out.println("Error while getting Total energy from table:" + es);}
		}
		setTotalEnergy(total_energy);
}

// function getEnergyUnit() fetches the total energy unit of measurement from the PH_TPN_PARAM table
public String getEnergyUnit() {
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String energy_uom	= "";
		
		try {
			connection  = getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT9"));
			resultSet	= pstmt.executeQuery();


			if(resultSet.next()){
				energy_uom = resultSet.getString("ENERGY_UNIT");
			}
			
		}
		catch(Exception e) {
			System.out.println("Error while getting energy unit of measurement:" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.out.println("Error while getting energy unit of measurement:" + es);}
		}
		return energy_uom;
	}

// Function getEnergyValues() takes the corresponding ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST table
public HashMap getEnergyValues()	{
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		HashMap energy_rel_values = new HashMap();
		try {
			connection  = getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT8"));
			resultSet	= pstmt.executeQuery();

			while(resultSet.next()){
				energy_rel_values.put(resultSet.getString("CONSTITUENT_CODE"),resultSet.getString("CONSTITUENT_CODE"));
				energy_rel_values.put(resultSet.getString("CONSTITUENT_CODE"),resultSet.getString("ENERGY_REL_VALUE"));
				//System.err.println("loop :"+energy_rel_values);
			}

		}
		catch(Exception e) {
			System.out.println("Error while getting energy rel values:" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.out.println("Error while getting energy rel values:" + es);}
		}
		return energy_rel_values;
	}
 
public void setLipidEmlBean(String tpn_regimen_code)	{
		Connection connection	    = null;
		PreparedStatement pstmt	    = null;
		ResultSet resultSet		    = null;
		String lipid_emulsion_type	= "";

		try {
			connection  = getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT11"));
			pstmt.setString(1,tpn_regimen_code);
			resultSet	= pstmt.executeQuery();

			if(resultSet.next()){
					lipid_emulsion_type = resultSet.getString("EMULSION_TYPE");
			}
			if(lipid_emulsion_type == null) lipid_emulsion_type = "";

		}
		catch(Exception e) {
			System.out.println("Error while getting LIPID EMULSION TYPE from table:" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {	System.out.println("Error while getting LIPID EMULSION TYPE from table:" + es);}
		}
		setLipidEmulsion(lipid_emulsion_type);
}

public void setNpcRatioBean(String tpn_regimen_code)	{
		Connection connection	    = null;
		PreparedStatement pstmt	    = null;
		ResultSet resultSet		    = null;
		String npc_ratio			= "";

		try {
			connection  = getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT12"));
			pstmt.setString(1,tpn_regimen_code);
			resultSet	= pstmt.executeQuery();

			if(resultSet.next()){
					npc_ratio = resultSet.getString("NPC_VALUE");
			}
			if(npc_ratio == null) npc_ratio = "";

		}
		catch(Exception e) {
			System.out.println("Error while getting LIPID EMULSION TYPE from table:" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.out.println("Error while getting LIPID EMULSION TYPE from table:" + es);}
		}
		setNpcRatio(npc_ratio);
}

// Function getDrugItemCodeIndicator() fetches the value of DRUG_AND_ITEM_CODE_SAME_IND from PH_PARAMETER.
public String getDrugItemCodeIndicator() {
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		String drug_item_code_ind	= "";
		
		try {
			connection  = getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT12"));
			resultSet	= pstmt.executeQuery();


			if(resultSet.next()){
				drug_item_code_ind = resultSet.getString("DRUG_AND_ITEM_CODE_SAME_IND");
			}
			
		}
		catch(Exception e) {
			System.out.println("Error while getting DRUG_AND_ITEM_CODE_SAME_IND from PH_PARAMETER :" + e);
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.out.println("Error while getting DRUG_AND_ITEM_CODE_SAME_IND from PH_PARAMETER :" + es);}
		}
		setDrugItemCodeInd(drug_item_code_ind);
		return drug_item_code_ind;
	}
// function validateRegimenCode(String regimen_code) checks for the duplicate regimen codes 
public boolean validateRegimenCode(String regimen_code)	{
		
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;
		int    count				=	0;
//		boolean result				=	false;
		try{

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT13") ) ;
			pstmt.setString(1,regimen_code.trim());
			resultSet	= pstmt.executeQuery(); 
				if ( resultSet != null && resultSet.next() ) {
				count	=	Integer.parseInt(resultSet.getString("TOT_COUNT"));
				}
		
		}catch(Exception e){
		System.err.println("Exception in Validating Drug Code:"+e);
		 return false;	
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){System.err.println("Exception in Validating Drug Code:"+es);
			}
		}

		if(count > 0)
			return false;	
		else
			return true;

}
}
