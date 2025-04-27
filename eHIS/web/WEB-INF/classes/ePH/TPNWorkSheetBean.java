/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;

import java.io.Serializable;
import java.util.*;
import java.sql.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.DecimalFormat;
//import ePH.TPNWorkSheetBean.*;
//saved on 22/10/2005
public class TPNWorkSheetBean extends PhAdapter implements Serializable {
	
	private  ArrayList ElGroupRecs=new ArrayList();
	private  ArrayList OthrerPrescQty=new ArrayList();
	
	protected String OverageVolume		= "";
	protected String OverageVolumeUom	= "";
	protected ArrayList mol_code_p_ca	= new ArrayList(4);
	protected HashMap moleculeCodes		= new HashMap();
	public 	HashMap	const_generics_precipt_info	= new HashMap();

	public ArrayList gemol_code_p_ca(){
		return (this.mol_code_p_ca);
	}
	
	public HashMap getmoleculeCodes(){
		return (this.moleculeCodes);
	}

	public void setOthrerPrescQty(ArrayList OthrerPrescQty){
		this.OthrerPrescQty=OthrerPrescQty;
	}
	
	public ArrayList getOthrerPrescQty(){
		return (this.OthrerPrescQty);
	}

	public void setElGroupRecs(ArrayList ElGroupRecs){
		this.ElGroupRecs=ElGroupRecs;
	}
	
	public ArrayList getElGroupRecs(){
		return (this.ElGroupRecs);
	}

	public String getOverageVolume(){
		return this.OverageVolume;
	}

	public String getOverageVolumeUom(){
		return this.OverageVolumeUom;
	}

	public ArrayList getConstPreciptInfo(String constGenericCode){
		if(const_generics_precipt_info.containsKey(constGenericCode)){
			return (ArrayList)const_generics_precipt_info.get(constGenericCode);
		}else{
			return null;
		}
	}
	
	public HashMap getConstGenericsPreciptMsgs(){
		return const_generics_precipt_info;
	}

	public TPNWorkSheetBean() {
		try {
			doCommon();
			mol_code_p_ca.add("PO4");
			mol_code_p_ca.add("");
			mol_code_p_ca.add("Ca");
			mol_code_p_ca.add("");
		}
		catch(Exception e) {	
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear();
		moleculeCodes = new HashMap();
	}

	public void setAll(Hashtable recordSet) {
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put("result", new Boolean(true));
		map.put("message", "success..");
		return map ;
	}
	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public ArrayList getInitalDetails(String order_id,String patient_id,String tpn_non_std_regimen_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList TPN_details	= new ArrayList();
		ArrayList tempELGroupRecs= new ArrayList();
		int i=0;
		

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT1"));
			pstmt.setString(1, tpn_non_std_regimen_code);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, patient_id);
			pstmt.setString(4, patient_id);
			pstmt.setString(5, tpn_non_std_regimen_code);
			pstmt.setString(6, order_id);
			pstmt.setString(7, tpn_non_std_regimen_code);
			pstmt.setString(8, patient_id);
			pstmt.setString(9, patient_id);
			pstmt.setString(10, patient_id);
			pstmt.setString(11, tpn_non_std_regimen_code);
			pstmt.setString(12, tpn_non_std_regimen_code);
			pstmt.setString(13, patient_id);
			pstmt.setString(14, patient_id);
			pstmt.setString(15, patient_id);
			pstmt.setString(16, tpn_non_std_regimen_code);
			pstmt.setString(17, patient_id);
			pstmt.setString(18, order_id);
			pstmt.setString(19, tpn_non_std_regimen_code);
			pstmt.setString(20, patient_id);
			pstmt.setString(21, patient_id);
			pstmt.setString(22, patient_id);
			pstmt.setString(23, tpn_non_std_regimen_code);
			pstmt.setString(24, order_id);

			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				TPN_details.add(checkForNull(resultSet.getString("CONST_GROUP_NAME")));
				TPN_details.add(checkForNull(resultSet.getString("CONST_GROUP_CODE")));
				TPN_details.add(checkForNull(resultSet.getString("CONST_GENERIC_CODE")));
				TPN_details.add(checkForNull(resultSet.getString("CONST_GENERIC_NAME")));
				TPN_details.add(checkForNull(resultSet.getString("CONST_QTY")));
				TPN_details.add(checkForNull(resultSet.getString("CONST_QTY_UNIT")));
				TPN_details.add(checkForNull(resultSet.getString("DFLT_ORD_UNIT_IND")));
				TPN_details.add(checkForNull(resultSet.getString("PRES_ITEM_CODE")).trim());
				TPN_details.add(checkForNull(resultSet.getString("CONST_REMARKS")));
				TPN_details.add(checkForNull(resultSet.getString("TPN_LIMIT_OVERRIDE_REASON")));
				TPN_details.add(checkForNull(resultSet.getString("NOT_TO_BE_ORDERED")));

				if (resultSet.getString("CONST_GROUP_CODE").toUpperCase().equals("EL")){
				tempELGroupRecs.add(resultSet.getString("CONST_GENERIC_CODE"));
				tempELGroupRecs.add(resultSet.getString("CONST_QTY"));
				tempELGroupRecs.add(resultSet.getString("CONST_QTY_UNIT"));
				tempELGroupRecs.add(new Integer(i));

					}
			i+=1;
			}
		setElGroupRecs(tempELGroupRecs);
			
			if(resultSet != null){ closeResultSet(resultSet); }
			if(pstmt != null){ closeStatement(pstmt); }

			pstmt		= connection.prepareStatement("SELECT CONST_GENERIC_CODE,CONST_GENERIC_NAME,B.CONST_GROUP_CODE,CONST_GROUP_NAME FROM PH_TPN_CONST_GENERIC_NAME B, PH_TPN_CONSTITUENT_GROUP C WHERE B.CONST_GROUP_CODE=C.CONST_GROUP_CODE AND B.CONST_GENERIC_CODE= 'FLUID' ORDER BY C.DISP_SRL_NO");
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()) {
				TPN_details.add((resultSet.getString("CONST_GROUP_NAME") ==  null)?"":resultSet.getString("CONST_GROUP_NAME"));
				TPN_details.add((resultSet.getString("CONST_GROUP_CODE") == null)?"":resultSet.getString("CONST_GROUP_CODE"));
				TPN_details.add((resultSet.getString("CONST_GENERIC_CODE")== null)?"":resultSet.getString("CONST_GENERIC_CODE"));
				TPN_details.add((resultSet.getString("CONST_GENERIC_NAME")== null)?"":resultSet.getString("CONST_GENERIC_NAME"));
				TPN_details.add("");
				TPN_details.add("");
				TPN_details.add("");
				TPN_details.add("");
				TPN_details.add("");
				TPN_details.add("");
				TPN_details.add("N");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}

		return TPN_details;
	}

	public ArrayList getItemList(String generic_code, String order_id, String locn_code,boolean tpn_change_mmoh,String patient_id) {// tpn_change_mmoh,patient_id added for ML-MMOH-CRF-1201
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String curr_item		= "";
		String curr_item_desc	= "";
		String prev_item		= "";
		ArrayList item_list		= new ArrayList();

		try {
			connection	= getConnection();
//			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT2"));
//SELECT A.ITEM_CODE ITEM_CODE, D.SHORT_DESC ITEM_DESC FROM PH_INV_ITEM_FOR_NS_REGIMEN A, OR_ORDER_LINE_PH_TPN B,MM_ITEM D WHERE A.CONST_GENERIC_CODE=B.CONST_GENERIC_CODE AND A.ITEM_CODE = D.ITEM_CODE AND B.CONST_GENERIC_CODE=? AND EXISTS (SELECT C.ITEM_CODE FROM ST_ITEM_BATCH C WHERE C.QTY_ON_HAND>=C.COMMITTED_QTY AND C.ITEM_CODE=A.ITEM_CODE AND STORE_CODE=?) AND B.ORDER_ID=?
			if(generic_code.equals("FLUID")){
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT10"));
//				pstmt		= connection.prepareStatement("SELECT DISTINCT A.ITEM_CODE ITEM_CODE, D.SHORT_DESC ITEM_DESC FROM PH_INV_ITEM_FOR_NS_REGIMEN A, PH_TPN_CONST_FOR_NS_REGIMEN B, MM_ITEM D WHERE A.ITEM_CODE = D.ITEM_CODE AND A.ITEM_CODE = B.ITEM_CODE AND B.CONST_GENERIC_CODE = 'FLUID'");
			}else if (tpn_change_mmoh)
			{
                 pstmt		= connection.prepareStatement("SELECT  a.item_code item_code, d.short_desc item_desc,e.age_group_code,e.appl_status FROM    ph_inv_item_for_ns_regimen a, (SELECT order_id, const_generic_code FROM or_order_line_ph_tpn UNION	SELECT ? order_id, const_generic_code FROM ph_tpn_const_generic_name) b, mm_item d,ph_tpn_const_appl_setting  e, am_age_group f WHERE    a.const_generic_code = b.const_generic_code AND    a.item_code = d.item_code AND    b.const_generic_code = ? AND    EXISTS (SELECT    c.item_code FROM    st_item_batch c WHERE    c.qty_on_hand >= c.committed_qty AND    c.item_code = a.item_code AND    store_code = ?) AND    EXISTS ( SELECT 'X' FROM    ph_tpn_const_for_ns_regimen x WHERE    x.item_code = a.item_code AND    x.const_generic_code = ? AND    x.eff_status = 'E') AND    b.order_id = ? AND    e.item_code = a.item_code  AND    e.const_generic_code = a.const_generic_code AND (e.age_group_code = f.age_group_code OR e.age_group_code ='*A') AND e.appl_status ='A' AND    NVL(f.gender,(select sex from mp_patient where patient_id =?)) = (select sex from mp_patient where patient_id =?) group by a.item_code , d.short_desc ,e.age_group_code,e.appl_status");

						pstmt.setString(1, order_id);
						pstmt.setString(2, generic_code);
						pstmt.setString(3, locn_code);
						pstmt.setString(4, generic_code);
						pstmt.setString(5, order_id);
						pstmt.setString(6, patient_id);
						pstmt.setString(7, patient_id);

			}else{
//				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT2"));
//				pstmt		= connection.prepareStatement("SELECT A.ITEM_CODE ITEM_CODE, D.SHORT_DESC ITEM_DESC FROM PH_INV_ITEM_FOR_NS_REGIMEN A, OR_ORDER_LINE_PH_TPN B,MM_ITEM D WHERE A.CONST_GENERIC_CODE=B.CONST_GENERIC_CODE AND A.ITEM_CODE = D.ITEM_CODE AND B.CONST_GENERIC_CODE=? AND EXISTS (SELECT C.ITEM_CODE FROM ST_ITEM_BATCH C WHERE C.QTY_ON_HAND>=C.COMMITTED_QTY AND C.ITEM_CODE=A.ITEM_CODE AND STORE_CODE=?) AND B.ORDER_ID=?");
// new one to control the disabled items in TPN NSR master..
				pstmt		= connection.prepareStatement("SELECT a.item_code item_code, d.short_desc item_desc FROM ph_inv_item_for_ns_regimen a, (SELECT order_id, const_generic_code FROM or_order_line_ph_tpn UNION SELECT ? order_id, const_generic_code FROM ph_tpn_const_generic_name) b, mm_item d WHERE a.const_generic_code = b.const_generic_code  AND a.item_code = d.item_code AND b.const_generic_code = ? AND EXISTS ( SELECT c.item_code FROM st_item_batch c WHERE c.qty_on_hand >= c.committed_qty AND c.item_code = a.item_code AND store_code = ?) AND EXISTS ( SELECT 'X' FROM ph_tpn_const_for_ns_regimen x WHERE x.item_code = a.item_code  AND x.const_generic_code = ? AND x.eff_status = 'E') AND b.order_id = ?");

				pstmt.setString(1, order_id);
				pstmt.setString(2, generic_code);
				pstmt.setString(3, locn_code);
				pstmt.setString(4, generic_code);
				pstmt.setString(5, order_id);
			}
			
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				curr_item		= resultSet.getString("ITEM_CODE");
				curr_item_desc	= resultSet.getString("ITEM_DESC");
				if (!curr_item.equals(prev_item)){
					item_list.add(curr_item);
					item_list.add(curr_item_desc);
				}
				prev_item = curr_item;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) { 			
				es.printStackTrace();
			}
		}
		return item_list;
	}
	public ArrayList getConcentrationPercentage (String generic_code, String item_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		float concentrationPer	= 0.0f;
		float manufactureVarPer= 0.0f;
		ArrayList returnValues = new ArrayList();
		if(generic_code == null) generic_code = "";
		if(item_code == null) item_code = "";
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT5"));
			pstmt.setString(1, generic_code);
			pstmt.setString(2, item_code);
			
			resultSet	= pstmt.executeQuery();
			String stock_uom="";
			if  (resultSet.next()){
				concentrationPer = resultSet.getFloat("CONCENTRATION_PERCENT");
				manufactureVarPer = resultSet.getFloat("MANUFACTURER_VAR_PERCENTAGE");
				stock_uom=resultSet.getString("SALE_UOM_CODE");
				returnValues.add(new Float(concentrationPer));
				returnValues.add(new Float(manufactureVarPer));
				returnValues.add(stock_uom);
			}
          }
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return returnValues;
	}

	public ArrayList getBatchDetail(String generic_code, String order_id, String locn_code, String batch_id, String group_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList returnVals	= new ArrayList();

		try {
			connection	= getConnection();
			if(group_code.equals("EL")) {
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT4"));
			}
			else {
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT3"));
			}
			pstmt.setString(1, generic_code);
			pstmt.setString(2, order_id);
			pstmt.setString(3, locn_code);
			pstmt.setString(4, batch_id);
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				returnVals.add(resultSet.getString("STOCK_UOM"));
				returnVals.add(resultSet.getString("ISSUEQTY"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return returnVals;
	}

	
	public String getIssueQty(String order_id, String item_code,String CONST_GENERIC_CODE,String ALLOC_QTY_UOM,String concentration_percent,String ORDER_QTY,String Issue_Qty,String calculate_for)
	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet1	= null;
		String molecule_code		="";
		String MEQ_VALUE_AN_ION		="";
		String MEQ_VALUE_CAT_ION	="";
		String MMOL_VALUE_AN_ION	="";
		String MMOL_VALUE_CAT_ION	="";
		String PHY_WEIGHT_VALUE		="";
//		String PHY_WEIGHT_UNIT		="";
		String AN_ION				="";
		String CAT_ION				="";
		String ion_value			="";
		String ion_value1			="";
		String resultValue			="";
		String stock_uom			="";
		float tmp_disp_qty1=0.0f;
		float disp_qty1=0.0f;
		float tmp_disp_qty=0.0f;
		ArrayList ElGroupRecs=new ArrayList();
		ArrayList OthrerPrescribeQty=new ArrayList();

		try {
	
		connection	= getConnection();
		pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT6"));
			pstmt.setString(1, item_code);
			pstmt.setString(2,CONST_GENERIC_CODE);
			pstmt.setString(3,item_code);
			pstmt.setString(4,CONST_GENERIC_CODE);
			resultSet	= pstmt.executeQuery();
			if (resultSet.next()) {
			molecule_code=resultSet.getString("MOLECULE_CODE");
			stock_uom =resultSet.getString("STOCK_UOM");
			}
			if(CONST_GENERIC_CODE.equals("PO4")){
				mol_code_p_ca.set(1,molecule_code);			
			}else if(CONST_GENERIC_CODE.equals("Ca")){
				mol_code_p_ca.set(3,molecule_code);			
			}
			moleculeCodes.put(CONST_GENERIC_CODE,molecule_code);
			//System.err.println("molecule_code ::"+molecule_code);
			//System.err.println("stock_uom ::"+stock_uom);
			

			pstmt1	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT7"));
			pstmt1.setString(1, molecule_code);
			resultSet1	= pstmt1.executeQuery();
			while (resultSet1.next()) {
			MEQ_VALUE_AN_ION=resultSet1.getString("MEQ_VALUE_AN_ION");
			MEQ_VALUE_CAT_ION=resultSet1.getString("MEQ_VALUE_CAT_ION");
			MMOL_VALUE_AN_ION=resultSet1.getString("MMOL_VALUE_AN_ION");
			MMOL_VALUE_CAT_ION=resultSet1.getString("MMOL_VALUE_CAT_ION");
			PHY_WEIGHT_VALUE=resultSet1.getString("PHY_WEIGHT_VALUE");
		//	PHY_WEIGHT_UNIT=resultSet1.getString("PHY_WEIGHT_UNIT");
			AN_ION=resultSet1.getString("AN_ION");
			CAT_ION=resultSet1.getString("CAT_ION");
			
			}
		/*	System.err.println("MEQ_VALUE_AN_ION ::"+MEQ_VALUE_AN_ION);
			System.err.println("MEQ_VALUE_CAT_ION ::"+MEQ_VALUE_CAT_ION);
			System.err.println("MMOL_VALUE_AN_ION ::"+MMOL_VALUE_AN_ION);
			System.err.println("MMOL_VALUE_CAT_ION ::"+MMOL_VALUE_CAT_ION);
			System.err.println("PHY_WEIGHT_VALUE ::"+PHY_WEIGHT_VALUE);
			//System.err.println("PHY_WEIGHT_UNIT ::"+PHY_WEIGHT_UNIT);
			System.err.println("AN_ION ::"+AN_ION);
			System.err.println("CAT_ION ::"+CAT_ION); */
		String OtherMoleCode=CONST_GENERIC_CODE.toUpperCase().equals(AN_ION.toUpperCase())?CAT_ION.toUpperCase():AN_ION.toUpperCase();
		
		if(ALLOC_QTY_UOM.toUpperCase().equals("MMOL") && CONST_GENERIC_CODE.equals(CAT_ION))
		ion_value=	MMOL_VALUE_CAT_ION;
		 else if(ALLOC_QTY_UOM.toUpperCase().equals("MMOL") && CONST_GENERIC_CODE.equals(AN_ION))
		ion_value=	MMOL_VALUE_AN_ION;
		else if(ALLOC_QTY_UOM.toUpperCase().equals("MEQT") && CONST_GENERIC_CODE.equals(AN_ION))
		ion_value=	MEQ_VALUE_AN_ION;
		else if(ALLOC_QTY_UOM.toUpperCase().equals("MEQT") && CONST_GENERIC_CODE.equals(CAT_ION))
		ion_value=	MEQ_VALUE_CAT_ION;
//		System.err.println("ion_value ::"+ion_value);

		if(calculate_for.equals("")){
		if(!PHY_WEIGHT_VALUE.equals("") && !ion_value.equals("")){
			tmp_disp_qty=(Float.parseFloat(PHY_WEIGHT_VALUE)* Float.parseFloat(ORDER_QTY)) /(Float.parseFloat(ion_value));
			float disp_qty=(tmp_disp_qty)*(100/(Float.parseFloat(concentration_percent)));
			resultValue	=	roundTwoDigits(disp_qty+"")+"$"+stock_uom;
		}
			
		}else if(calculate_for.equals("PrescribeQty")){


			float 
			tmp_pres_qty=(Float.parseFloat(concentration_percent) * Float.parseFloat(Issue_Qty)) /100;

			float pres_qty=(float)Math.ceil((tmp_pres_qty) * (Float.parseFloat(ion_value)/Float.parseFloat(PHY_WEIGHT_VALUE)));
			resultValue	=	String.valueOf(pres_qty);
			
			ElGroupRecs=getElGroupRecs();
//		    String OtherOrderQty="";
//			String OtherGenericCode="";
			String uom="";
			for (int i=0;i<ElGroupRecs.size();i+=4){
				if (((String)ElGroupRecs.get(i)).toUpperCase().equals(OtherMoleCode)){
//			OtherOrderQty = (String)ElGroupRecs.get(i);
//			OtherGenericCode =(String)ElGroupRecs.get(i+1);
			uom=(String)ElGroupRecs.get(i+2);
			
			if(uom.toUpperCase().equals("MMOL") && CONST_GENERIC_CODE.equals(CAT_ION))
				ion_value1=	MMOL_VALUE_CAT_ION;
	     	else if(uom.toUpperCase().equals("MMOL") && CONST_GENERIC_CODE.equals(AN_ION))
				ion_value1=	MMOL_VALUE_AN_ION;
			else if(uom.toUpperCase().equals("MEQT") && CONST_GENERIC_CODE.equals(AN_ION))
				ion_value1=	MEQ_VALUE_AN_ION;
			else if(uom.toUpperCase().equals("MEQT") && CONST_GENERIC_CODE.equals(CAT_ION))
				ion_value1=	MEQ_VALUE_CAT_ION;

 	
			tmp_disp_qty1=(Float.parseFloat(concentration_percent) * Float.parseFloat(Issue_Qty)) / 100 ;

			disp_qty1=(float)Math.ceil((tmp_disp_qty1) * (Float.parseFloat(ion_value1)/Float.parseFloat(PHY_WEIGHT_VALUE)));
			OthrerPrescribeQty.add((Integer)(ElGroupRecs.get(i+3)));
			OthrerPrescribeQty.add(new Float(disp_qty1));
				}
			}
			setOthrerPrescQty(OthrerPrescribeQty);
	
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeResultSet(resultSet1);
				closeStatement(pstmt1);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return resultValue;
		
	}

public String getAllocQty(String issueUOM, String allocUOM){

		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String Eqvl_value		="";
//		float disp_qty			=0.0f;
		
	
	try {
		connection	= getConnection();
		
		if(issueUOM.equals(allocUOM)){
			Eqvl_value	=	"1";
		}else{	
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_AM_UOM_EQVL_SELECT"));
			pstmt.setString(1,issueUOM);
			pstmt.setString(2,allocUOM);
			pstmt.setString(3,allocUOM);
			pstmt.setString(4,issueUOM);
			resultSet	= pstmt.executeQuery();

			if(resultSet.next()) {
				Eqvl_value=resultSet.getString("EQVL_VALUE");

				if(Eqvl_value==null) Eqvl_value="";
			}
		  }	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return Eqvl_value;
		
	}
	/* Function to get the Dispensed TPN Constituents details. */
	public ArrayList getDispensedTPNDetails(String order_id) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList TPN_Dispensed_Details	= new ArrayList();
		int i=0;
		

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_DISPENSED_DETAILS"));
			pstmt.setString(1, order_id);
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				TPN_Dispensed_Details.add(resultSet.getString("CONST_GROUP_NAME"));
				TPN_Dispensed_Details.add(resultSet.getString("CONST_GROUP_CODE"));
				TPN_Dispensed_Details.add(resultSet.getString("CONST_GENERIC_CODE"));
				TPN_Dispensed_Details.add(resultSet.getString("CONST_GENERIC_NAME"));
				TPN_Dispensed_Details.add(resultSet.getString("DISP_QTY"));
				TPN_Dispensed_Details.add(resultSet.getString("STOCK_UNIT"));
				TPN_Dispensed_Details.add(resultSet.getString("DFLT_ORD_UNIT_IND"));
			i+=1;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}

		return TPN_Dispensed_Details;
	}

 public String roundTwoDigits(String a){
	String bb			= "";
	double dbOne		= 0;
	
	try{
		DecimalFormat dfTest = new DecimalFormat("##.0000");
		dbOne = Double.parseDouble(a);
		//Added below condition for ICN:35043
		if (Double.isNaN(dbOne)) {
			 dbOne = 0.0;
		}
		bb = dfTest.format(dbOne);
	}catch (Exception e){
		e.printStackTrace();
	}
	return bb;
}

	public ArrayList getTPNWrkSheetDetails(String order_id) {
		Connection connection			= null;
		PreparedStatement pstmt			= null;
		ResultSet resultSet				= null;
		ArrayList tpn_wrk_sht_details	= new ArrayList();
		ArrayList cp_mvp				= new ArrayList();
		String scp						= "";
		String svp						= "";
		float cp						= 0.0f;
		float vp						= 0.0f;
		String stock_unit				= "";
		String disp_qty_uom				= "";
		String const_generic_code		= "";
		String disp_item_code			= "";
		
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT9"));
//			pstmt		= connection.prepareStatement("SELECT CONST_GENERIC_CODE,CONST_QTY_UNIT,DISP_ITEM_CODE,CONST_QTY,BATCH_ID1,TO_CHAR(EXPIRY_DATE1,'DD/MM/YYYY') EXPIRY_DATE1,DISP_QTY,TRADE_ID1,BIN_LOCATION_CODE1,STOCK_UNIT,DISP_QTY_UOM FROM ph_tpn_worksheet_dtl WHERE ORDER_ID=?");
			pstmt.setString(1, order_id);
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
					const_generic_code = resultSet.getString("CONST_GENERIC_CODE") == null ? "":resultSet.getString("CONST_GENERIC_CODE"); 
					disp_item_code	= resultSet.getString("DISP_ITEM_CODE") == null ? "":resultSet.getString("DISP_ITEM_CODE");

				tpn_wrk_sht_details.add(const_generic_code);
				tpn_wrk_sht_details.add(resultSet.getString("CONST_QTY_UNIT") == null ? "":resultSet.getString("CONST_QTY_UNIT"));
				tpn_wrk_sht_details.add(disp_item_code);
				tpn_wrk_sht_details.add(resultSet.getString("CONST_QTY") == null ? "":resultSet.getString("CONST_QTY"));
				tpn_wrk_sht_details.add(resultSet.getString("BATCH_ID1") == null ? "":resultSet.getString("BATCH_ID1"));
				tpn_wrk_sht_details.add(resultSet.getString("EXPIRY_DATE1") == null ?"":resultSet.getString("EXPIRY_DATE1"));
				tpn_wrk_sht_details.add(resultSet.getString("DISP_QTY") == null ?"":resultSet.getString("DISP_QTY"));
				tpn_wrk_sht_details.add(resultSet.getString("TRADE_ID1") == null ?"":resultSet.getString("TRADE_ID1"));
				tpn_wrk_sht_details.add(resultSet.getString("BIN_LOCATION_CODE1") == null ?"":resultSet.getString("BIN_LOCATION_CODE1"));
				stock_unit		= resultSet.getString("STOCK_UNIT") == null ?"":resultSet.getString("STOCK_UNIT");
				disp_qty_uom	= resultSet.getString("DISP_QTY_UOM") == null ?"":resultSet.getString("DISP_QTY_UOM");	
				tpn_wrk_sht_details.add(stock_unit);
				tpn_wrk_sht_details.add(disp_qty_uom);
				tpn_wrk_sht_details.add(getAllocQty(stock_unit,disp_qty_uom));
				if((resultSet.getString("CONST_GENERIC_CODE") != null)&&(resultSet.getString("DISP_ITEM_CODE") != null)){
					cp_mvp = getConcentrationPercentage(resultSet.getString("CONST_GENERIC_CODE"),resultSet.getString("DISP_ITEM_CODE"));
					if((cp_mvp != null)&&(cp_mvp.size()>0)){
						cp = ((Float)cp_mvp.get(0)).floatValue();
						scp = cp+"";
						vp = ((Float)cp_mvp.get(1)).floatValue();
						svp = vp+"";
						if(cp <= 0){
							scp = "";
							svp = "";
						}
					}
				}
					tpn_wrk_sht_details.add(scp);
					tpn_wrk_sht_details.add(svp);
					tpn_wrk_sht_details.add(getOsmolarityValue(const_generic_code, disp_item_code));
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}

		return tpn_wrk_sht_details;
	}
	

 public  String getOrderVolume(String order_id){
	String ordered_volume	= "";
	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;

	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_STD_REGIMEN_SELECT26"));
			pstmt.setString(1, order_id);
			pstmt.setString(2, login_facility_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				ordered_volume = resultSet.getString("QTY_VALUE");
			}
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);

		
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
				es.printStackTrace();
			}
		}
		return ordered_volume;
	}

 public  String getPrescBaseUnit(){
	String presc_base_unit	= "";
	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;

	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_PARAMETERS_SELECT5"));
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				presc_base_unit = resultSet.getString("REGIMEN_PRESC_BASE_UNIT");
			}
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);

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
				es.printStackTrace();
			}
		}
		return presc_base_unit;
	}

 public void setOverageVolume(String order_id){
	String OverageVolume	= "";
	String OverageVolumeUom	= "";
	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;

	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_HDR_SELECT5"));
//			pstmt		= connection.prepareStatement("SELECT OVERAGE_VOLUME,OVERAGE_VOLUME_UOM FROM PH_TPN_WORKSHEET_HDR WHERE order_id = ?");
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				OverageVolume	= resultSet.getString("OVERAGE_VOLUME");
				OverageVolumeUom = resultSet.getString("OVERAGE_VOLUME_UOM");
			}
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);

			this.OverageVolume		= OverageVolume;
			this.OverageVolumeUom	= OverageVolumeUom;

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
				es.printStackTrace();
			}
		}
	}

	public  String getInfuseOver(String order_id){
	String infuse_over		= "";
	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;

	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT11"));
//			pstmt		= connection.prepareStatement("SELECT INFUSE_OVER FROM OR_ORDER_LINE_PH WHERE ORDER_ID = ?");
			pstmt.setString(1,order_id);

			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				infuse_over = resultSet.getString("INFUSE_OVER");
			}
			    if(infuse_over ==  null) {infuse_over = "";}
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);

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
				es.printStackTrace();
			}
		}
		return infuse_over;
	}

public  String getOsmolarityValue(String generic_code, String item_code){

	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;
	String osmolar_value		= "";

	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT12"));
			pstmt.setString(1,generic_code);
			pstmt.setString(2,item_code);

			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				osmolar_value = resultSet.getString("OSMOLAR_VALUE");
			}
			    if(osmolar_value ==  null) {osmolar_value = "";}
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);

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
				es.printStackTrace();
			}
		}
		return osmolar_value;
	}

	public ArrayList getOrdDispTPNDetails(String order_id) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList TPN_Ord_Dispensed_Details	= new ArrayList();
	
		

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_ORD_DISPENSED_DETAILS"));
			pstmt.setString(1, order_id);
			pstmt.setString(2, order_id);
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("ORDERED")));
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("CONST_GENERIC_CODE")));
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("CONST_GENERIC_NAME")));
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("CONST_GROUP_NAME")));
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("ORDERED_QTY")));
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("ORDERED_UNIT")));
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("DISP_ITEM_DESC")));
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("DISP_QTY")));
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("DISP_QTY_UOM")));
				TPN_Ord_Dispensed_Details.add(checkForNull(resultSet.getString("CONST_GROUP_CODE")));
			}
			//setOverageVolume(order_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}

		return TPN_Ord_Dispensed_Details;
	}
	
	public  String getPhCaMessage(String phsph_alc_qty,String calci_alc_qty){

	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;
	String phsp_calc_message		= "";

	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT13"));
			pstmt.setString(1,(String)mol_code_p_ca.get(1));
			pstmt.setString(2,(String)mol_code_p_ca.get(3));
			pstmt.setString(3,phsph_alc_qty);
			pstmt.setString(4,calci_alc_qty);

			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				phsp_calc_message = resultSet.getString("MESSAGE_DESCR");
			}
			    if(phsp_calc_message ==  null) {phsp_calc_message = "";}
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);

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
				es.printStackTrace();
			}
		}
		return phsp_calc_message;
	}

	public  String getTPNExpDate(){

	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;
	String tpn_exp_dt		= "";

	try {
			connection	= getConnection();

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT_EXP_DATE"));

			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				tpn_exp_dt = resultSet.getString("TPN_EXP_DATE");
			}
			    if(tpn_exp_dt ==  null) {tpn_exp_dt = "";}
				if(resultSet!=null) closeResultSet(resultSet);
				if(pstmt!=null) closeStatement(pstmt);

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
				es.printStackTrace();
			}
		}
		return tpn_exp_dt;
	}

	public ArrayList getAllVolumes(String order_id) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList vol_osmol_volume	= new ArrayList();
	
		

		try {
			connection	= getConnection();
			String strrr = "SELECT QTY_VOLUME, QTY_UOM, OSMOLAR_VALUE FROM PH_TPN_WORKSHEET_HDR WHERE ORDER_ID = ?";
//			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_ORD_DISPENSED_DETAILS"));
			pstmt		= connection.prepareStatement(strrr);
			pstmt.setString(1, order_id);
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				vol_osmol_volume.add(checkForNull(resultSet.getString("QTY_VOLUME")));
				vol_osmol_volume.add(checkForNull(resultSet.getString("QTY_UOM")));
				vol_osmol_volume.add(checkForNull(resultSet.getString("OSMOLAR_VALUE")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}

		return vol_osmol_volume;
	}

	public void getConstPrecepInfo() {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet1	= null;
		HashMap	const_generics	= new HashMap();
		const_generics_precipt_info	= new HashMap();
		ArrayList const_generic_codes = new ArrayList();
		ArrayList constPrecepInfo	= new ArrayList();
	
		

		try {
			connection	= getConnection();
			String const_generic_desc = "SELECT CONST_GENERIC_CODE, CONST_GENERIC_NAME FROM PH_TPN_CONST_GENERIC_NAME";
			pstmt		= connection.prepareStatement(const_generic_desc);

			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				const_generics.put(resultSet.getString("CONST_GENERIC_CODE"),resultSet.getString("CONST_GENERIC_NAME"));
				const_generic_codes.add(resultSet.getString("CONST_GENERIC_CODE"));
			}

			String const_precept_info = "SELECT CONSTR_GENERIC_FRM_CODE, CONSTR_GENERIC_TO_CODE,MOLECULE_FRM_CODE,MOLECULE_TO_CODE,CONST1_RANGE_FRM,CONST1_RANGE_TO,CONST2_RANGE_FRM,CONST2_RANGE_TO,CONST_GENERIC_UOM,CONST_GENERIC_PER_VOL,CONST_PREC_IND,CONST_PREC_MESSAGE FROM PH_TPN_CONS_PREC_MOL WHERE EFF_STATUS = 'E' AND (CONSTR_GENERIC_FRM_CODE = ? OR CONSTR_GENERIC_TO_CODE = ?)";
			pstmt1		= connection.prepareStatement(const_precept_info);

			if(const_generic_codes != null && const_generic_codes.size()>0){
				for(int i=0;i<const_generic_codes.size();i++){
					constPrecepInfo = new ArrayList();
					pstmt1.setString(1,(String)const_generic_codes.get(i));
					pstmt1.setString(2,(String)const_generic_codes.get(i));

					resultSet1	= pstmt1.executeQuery();
				
					while (resultSet1.next()) {
						constPrecepInfo.add(resultSet1.getString("CONSTR_GENERIC_FRM_CODE"));
						constPrecepInfo.add(const_generics.get(resultSet1.getString("CONSTR_GENERIC_FRM_CODE")));
						constPrecepInfo.add(resultSet1.getString("CONSTR_GENERIC_TO_CODE"));
						constPrecepInfo.add(const_generics.get(resultSet1.getString("CONSTR_GENERIC_TO_CODE")));
						constPrecepInfo.add(resultSet1.getString("MOLECULE_FRM_CODE"));
						constPrecepInfo.add(resultSet1.getString("MOLECULE_TO_CODE"));
						constPrecepInfo.add(resultSet1.getString("CONST1_RANGE_FRM"));
						constPrecepInfo.add(resultSet1.getString("CONST1_RANGE_TO"));
						constPrecepInfo.add(resultSet1.getString("CONST2_RANGE_FRM"));
						constPrecepInfo.add(resultSet1.getString("CONST2_RANGE_TO"));
						constPrecepInfo.add(resultSet1.getString("CONST_GENERIC_UOM"));
						constPrecepInfo.add(resultSet1.getString("CONST_GENERIC_PER_VOL"));
						constPrecepInfo.add(resultSet1.getString("CONST_PREC_IND"));
						constPrecepInfo.add(resultSet1.getString("CONST_PREC_MESSAGE"));
					}
					if(constPrecepInfo.size()>0){
						const_generics_precipt_info.put(const_generic_codes.get(i),constPrecepInfo);
					}
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeResultSet(resultSet1);
				closeStatement(pstmt);
				closeStatement(pstmt1);
				closeConnection(connection);
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}

	//	return constPrecepInfo;
	}
	//Adding start for ML-MMOH-CRF-1201
	public  ArrayList getItemValues(String generic_code, String item_code){
System.err.println("generic_code@@@==="+generic_code+"item_code==="+item_code);
	Connection connection	= null;
    PreparedStatement pstmt	= null;
    ResultSet resultSet		= null;
	ArrayList itemvalues =new ArrayList();

	try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_WORKSHEET_SELECT14"));
			pstmt.setString(1,generic_code);
			pstmt.setString(2,item_code);

			resultSet	= pstmt.executeQuery();
			if(resultSet != null && resultSet.next()) {
				itemvalues.add(resultSet.getString("ITEM_CONCENTRATION_PERCENT"));
				itemvalues.add(resultSet.getString("VOLUME"));
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
				es.printStackTrace();
			}
		}
		System.err.println("itemvalues@@@==="+itemvalues);
		return itemvalues;
	}
	//Addign end for ML-MMOH-CRF-1201
	/* Function specific methods end */
}
