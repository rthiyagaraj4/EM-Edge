package eXH;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreditCardDAO
{
	public String getSettleBillResponse(Map<String, String> reqParams) {
		String response = "";
		String procStr = "{ CALL BL_CREDIT_CARD.CONSTRUCT_IN_MESSAGE(?,?,?,?,?,?,?) }";
		
		Map<String, String> procParams = new LinkedHashMap<String, String>();
		try
		{
			procParams.put("IN_p_slmt_type", reqParams.get("P_settlement_type"));
			procParams.put("IN_in_message", reqParams.get("INPUT_STRING"));
			procParams.put("IN_p_language_id", "en");
			procParams.put("OUT_p_field_separator", "");
			procParams.put("IN_p_type", "J");
			procParams.put("OUT_p_piped_op", "");
			procParams.put("OUT_p_errtext", "");
			
			DAOUtil daoUtil = new DAOUtil();
			
			List<String> outParams = daoUtil.executeProcedure(procStr, procParams, null);
			String error = outParams.get(2);
			if(error != null && !error.equals("")) {
				System.out.println("(CreditCardDAO:getSettleBillResponse) Error: " + error);
			}
			else {
				response = outParams.get(1);
			}

			System.out.println(" ::: CreditCardDAO.getSettleBillResponse :: response ::: "+response);
		}
		catch (Exception e)
		{
			System.out.println(" Exception in CreditCardDAO.getSettleBillResponse::: "+e);
			e.printStackTrace();
		}

		return response;
		
	}
	
	public String getSettleBillResponsePlutus(Map<String, String> reqParams) {
		String response = "";
		String procStr = "{ CALL BL_CREDIT_CARD.CONSTRUCT_IN_MESSAGE(?,?,?,?,?,?,?) }";
		
		Map<String, String> procParams = new LinkedHashMap<String, String>();
		try
		{
			System.out.println(" ::: CreditCardDAO.getSettleBillResponsePlutus :: inside ::: ");
			procParams.put("IN_p_slmt_type", reqParams.get("P_settlement_type"));
			procParams.put("IN_in_message", reqParams.get("RESPONSE_TEXT"));
			procParams.put("IN_p_language_id", "en");
			procParams.put("OUT_p_field_separator", "");
			procParams.put("IN_p_type", "J");
			procParams.put("OUT_p_piped_op", "");
			procParams.put("OUT_p_errtext", "");
			
			DAOUtil daoUtil = new DAOUtil();
			
			List<String> outParams = daoUtil.executeProcedure(procStr, procParams, null);
			String error = outParams.get(2);
			if(error != null && !error.equals("")) {
				System.out.println("(CreditCardDAO:getSettleBillResponsePlutus) Error: " + error);
			}
			else {
				response = outParams.get(1);
			}
			
			System.out.println(" ::: CreditCardDAO.getSettleBillResponsePlutus :: response ::: "+response);
		}
		catch (Exception e)
		{
			System.out.println(" Exception in CreditCardDAO.getSettleBillResponsePlutus::: "+e);
			e.printStackTrace();
		}
		return response;
		
	}
}