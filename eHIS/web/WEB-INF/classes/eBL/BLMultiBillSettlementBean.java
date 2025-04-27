package eBL; 

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import eBL.Common.BlAdapter;

public class BLMultiBillSettlementBean extends BlAdapter implements
		Serializable {

	public HashMap<String,String> getDrugPenaltyCharges(Connection con,String facilityId, ArrayList<String> docTypeCodeArray,ArrayList<String> docNumListArray) throws SQLException {
		CallableStatement call = null;
		HashMap<String,String> penaltyCharge=new HashMap<String,String>(); 
		Double strdrugpenaltyamt = 0.0;
		boolean drugPenaltyFlag=false;
		
		try {
			
			for(int count=0;count<docTypeCodeArray.size();count++){
			call = con.prepareCall("{ call bl_addl_charge_for_bill.check_for_addl_charge(?,?,?,?,?)}");
			call.setString(1, facilityId);
			call.setString(2, docTypeCodeArray.get(count));
			call.setString(3, docNumListArray.get(count));
			call.registerOutParameter(4, java.sql.Types.VARCHAR);
			call.registerOutParameter(5, java.sql.Types.INTEGER);
			call.execute();
			
			String drug_penalty_yn = call.getString(4);
			if (drug_penalty_yn == null) drug_penalty_yn = "N";	
			
				if(drug_penalty_yn.equalsIgnoreCase("Y")){					
					drugPenaltyFlag=true;
					strdrugpenaltyamt += call.getDouble(5);					
				}			

			}
			
			
			penaltyCharge.put("status", (drugPenaltyFlag==true)?"Y":"N"  );
			penaltyCharge.put("amount",strdrugpenaltyamt.toString());
			

			
			
		} catch (SQLException e) {
			System.out.println("Error in BLBillDetailsBean blopin.proc_ext_acc_serv_group_check");
		} finally {
			call.close();
		}

		return penaltyCharge;

	}
	
	public Double getDrugPenaltyChargesSingleBill(Connection con,String facilityId, String docTypeCode,String docNum) throws SQLException {
		CallableStatement call = null;
		HashMap<String,String> penaltyCharge=new HashMap<String,String>(); 
		Double strdrugpenaltyamt = 0.0;
		boolean drugPenaltyFlag=false;
		
		try {
			
			call = con.prepareCall("{ call bl_addl_charge_for_bill.check_for_addl_charge(?,?,?,?,?)}");
			call.setString(1, facilityId);
			call.setString(2, docTypeCode);
			call.setString(3, docNum);
			call.registerOutParameter(4, java.sql.Types.VARCHAR);
			call.registerOutParameter(5, java.sql.Types.INTEGER);
			call.execute();
			
			String drug_penalty_yn = call.getString(4);
			if (drug_penalty_yn == null) drug_penalty_yn = "N";	
			
			if(drug_penalty_yn.equalsIgnoreCase("Y")){					
				strdrugpenaltyamt = call.getDouble(5);					
			}			

			


			
			
		} catch (SQLException e) {
			System.out.println("Error in BLBillDetailsBean blopin.proc_ext_acc_serv_group_check");
		} finally {
			call.close();
		}

		return strdrugpenaltyamt;

	}

}
