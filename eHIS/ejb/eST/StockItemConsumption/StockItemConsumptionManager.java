/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.StockItemConsumption;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="StockItemConsumption"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="StockItemConsumption"
*	local-jndi-name="StockItemConsumption"
*	impl-class-name="eST.StockItemConsumption.StockItemConsumptionManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.StockItemConsumption.StockItemConsumptionLocal"
*	remote-class="eST.StockItemConsumption.StockItemConsumptionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.StockItemConsumption.StockItemConsumptionLocalHome"
*	remote-class="eST.StockItemConsumption.StockItemConsumptionHome"
*	generate= "local,remote"
*
*
*/


public class StockItemConsumptionManager extends StEJBSessionAdapter {
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQLValues) // throws RemoteException
		{
        Connection connection = null;
		Properties properties=null;
		eST.Common.StSales	stSales	=	new eST.Common.StSales();

		HashMap hmResult=new HashMap();
		HashMap	hmHeader=new HashMap();
		hmResult.put("result", FALSE);

		ArrayList alData		=	(ArrayList)hmData.get("DATA");

        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmHeader.put("facility_id", alData.get(0));  
			hmHeader.put("doc_type_code", alData.get(1));  
			hmHeader.put("doc_no", alData.get(2));  

			hmData.put("DATA",hmHeader);
			hmData.put("COMMON_DATA",hmData.get("COMMON_DATA"));

			hmResult=stSales.deleteSales(connection, hmData);
			throwExceptionWhenFailed(hmResult);
            connection.commit();
        }
        catch(Exception exception){
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
            hmResult.put(RESULT, FALSE);
            hmResult.put(MSGID, exception.getMessage());
            hmResult.put(MESSAGE, exception.toString());
        }
        finally{
            try{
				closeConnection(connection, properties);
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
        return hmResult;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public String setNumber(String stNumber, int decimalPlaces){
		String returnNumber	=	"0";
		try { 
		double number	=	Double.parseDouble(stNumber);

		double power	=	Math.pow(10, decimalPlaces);
		number	=	number*power;
		number	=	Math.round(number);
		number	=	number/Math.pow(10, decimalPlaces);;
		returnNumber	=	""+number;
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return returnNumber;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmData, HashMap hmSQLValues)  //throws RemoteException
		{

        System.out.println("StockItemConsumptionManager.java,129");
		Connection connection = null;
		Properties properties=null;
		eST.Common.StSales	stSales	=	new eST.Common.StSales();

		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		ArrayList alHdrData		=	(ArrayList)hmData.get("HDR_DATA");
		HashMap hmHeader		=	new HashMap();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alDtlRecords	=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alExpRecords	=	(ArrayList)hmData.get("DTL_EXP_DATA");
		ArrayList allanguageData	=	(ArrayList)hmData.get("LANGUAGE_DATA");

        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmHeader.put("facility_id",alHdrData.get(0));
			hmHeader.put("doc_type_code",alHdrData.get(1));
			hmHeader.put("doc_no",alHdrData.get(2));
			hmHeader.put("doc_date",alHdrData.get(3));
			hmHeader.put("doc_ref",alHdrData.get(4));
			hmHeader.put("store_code",alHdrData.get(5));
			hmHeader.put("authorized_by_id",alHdrData.get(6));
			hmHeader.put("cancelled_by_id",alHdrData.get(7));
			hmHeader.put("cancelled_remarks",alHdrData.get(8));
			hmHeader.put("finalized_yn",alHdrData.get(9));
			if (alHdrData.get(9).toString().equals("N")) {
				hmHeader.put("authorized_by_id","");
			}
			hmHeader.put("gl_interfaced_yn",alHdrData.get(10));
			hmHeader.put("trn_type",alHdrData.get(11));
			hmHeader.put("add_qty_sal_yn",alHdrData.get(12));
			hmHeader.put("patient_id",alHdrData.get(13));
			hmHeader.put("encounter_id",alHdrData.get(14));
			hmHeader.put("sal_trn_type",alHdrData.get(15));
			hmHeader.put("remarks",alHdrData.get(16));
			hmHeader.put("item_class_code",alHdrData.get(17));
			hmHeader.put("module_id","ST");
			  
			for (int i=0; i<alDtlRecords.size(); i++) {
				HashMap hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
				System.out.println("hmDtlRecord===>" +hmDtlRecord);
				HashMap hmDtlTemp	=	new HashMap();
					/* @Name - Priya
				* @Date - 19/05/2010
				* @Inc# - 
				* @Desc - As item_cost_value is calculated and passed from the validate jsp, the below code is not needed and so commented
				*/
				/*double	item_cost_value	=	Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))*Double.parseDouble((String)hmDtlRecord.get("item_qty"));
				String stitem_cost_value	=	setNumber(""+item_cost_value,3);*/

				hmDtlTemp.put("doc_srl_no", hmDtlRecord.get("doc_srl_no"));
				hmDtlTemp.put("item_code", hmDtlRecord.get("item_code"));
				hmDtlTemp.put("sal_category", "");
				hmDtlTemp.put("hcp_issue_factor", "");
				hmDtlTemp.put("item_qty", hmDtlRecord.get("item_qty"));
				hmDtlTemp.put("item_sal_value",hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("next_due_date", "");
				hmDtlTemp.put("stock_item_yn", hmDtlRecord.get("stock_item_yn"));
				hmDtlTemp.put("remarks", hmDtlRecord.get("remarks"));
				hmDtlTemp.put("item_unit_cost", hmDtlRecord.get("item_unit_cost"));
				hmDtlTemp.put("item_cost_value",hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("item_unit_price", hmDtlRecord.get("item_unit_cost"));
				hmDtlTemp.put("uom_code", hmDtlRecord.get("uom_code"));
				hmDtlTemp.put("usage_type", hmDtlRecord.get("usage_type")); //18/09/12
	
				alDtlData.add(hmDtlTemp);
				System.out.println("alDtlData=202==>" +alDtlData);
			}

			for (int i=0; i<alExpRecords.size(); i++) {
				HashMap hmExpRecord		=	(HashMap)alExpRecords.get(i);
//				ArrayList alExpTemp		=	new ArrayList();
				HashMap hmExpTemp	=	new HashMap();
				hmExpTemp.put("doc_srl_no", hmExpRecord.get("doc_srl_no"));
				hmExpTemp.put("store_code", hmExpRecord.get("STORE_CODE"));
				hmExpTemp.put("item_code", hmExpRecord.get("ITEM_CODE"));
				hmExpTemp.put("batch_id", hmExpRecord.get("BATCH_ID"));
				hmExpTemp.put("bin_location_code", hmExpRecord.get("BIN_LOCATION_CODE"));
				hmExpTemp.put("expiry_date_or_receipt_date", hmExpRecord.get("EXPIRY_DATE"));
				hmExpTemp.put("trade_id", hmExpRecord.get("TRADE_ID"));
				hmExpTemp.put("sal_item_qty", hmExpRecord.get("QTY"));
				hmExpTemp.put("ret_item_qty","");
				String stQty	=	(String)hmExpRecord.get("QTY");
				if (stQty==null||stQty.equals("")) {
					continue;
				}
				alExpData.add(hmExpTemp);
			}

			hmData.put("HDR_DATA",hmHeader);
			hmData.put("COMMON_DATA",hmData.get("COMMON_DATA"));
			hmData.put("DTL_DATA",alDtlData);
			hmData.put("DTL_EXP_DATA",alExpData);
			hmData.put("LANGUAGE_DATA",allanguageData);

			hmResult=stSales.insertSales(connection, hmData);
			throwExceptionWhenFailed(hmResult);
            connection.commit();
        }
        catch(Exception exception){
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
            hmResult.put(RESULT, FALSE);
            hmResult.put(MSGID, exception.getMessage());
            hmResult.put(MESSAGE, exception.toString());
        }
        finally{
            try{
				closeConnection(connection, properties);
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
        System.out.println("StockItemConsumptionManager.java,250");
        return hmResult;
    }
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmData, HashMap hmSQLValues)  //throws RemoteException
		{

        Connection connection = null;
		Properties properties=null;
		eST.Common.StSales	stSales	=	new eST.Common.StSales();

		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		HashMap hmHeader		=	new HashMap();
		ArrayList alHdrData		=	(ArrayList)hmData.get("HDR_DATA");
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alDtlRecords	=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alExpRecords	=	(ArrayList)hmData.get("DTL_EXP_DATA");

        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);
			  
			hmHeader.put("facility_id",alHdrData.get(0));
			hmHeader.put("doc_type_code",alHdrData.get(1));
			hmHeader.put("doc_no",alHdrData.get(2));
			hmHeader.put("doc_date",alHdrData.get(3));
			hmHeader.put("doc_ref",alHdrData.get(4));
			hmHeader.put("store_code",alHdrData.get(5));
			hmHeader.put("authorized_by_id",alHdrData.get(6));
			hmHeader.put("cancelled_by_id",alHdrData.get(7));
			hmHeader.put("cancelled_remarks",alHdrData.get(8));
			hmHeader.put("finalized_yn",alHdrData.get(9));

			if (alHdrData.get(9).toString().equals("N")) {
				hmHeader.put("authorized_by_id","");
			}
		
			hmHeader.put("gl_interfaced_yn",alHdrData.get(10));
			hmHeader.put("trn_type",alHdrData.get(11));
			hmHeader.put("add_qty_sal_yn",alHdrData.get(12));
			hmHeader.put("patient_id",alHdrData.get(13));
			hmHeader.put("encounter_id",alHdrData.get(14));
			hmHeader.put("sal_trn_type",alHdrData.get(15));
			hmHeader.put("remarks",alHdrData.get(16));
			hmHeader.put("item_class_code",alHdrData.get(17));

			for (int i=0; i<alDtlRecords.size(); i++) {
				HashMap hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
				HashMap hmDtlTemp	=	new HashMap();
				/* @Name - Priya
				* @Date - 19/05/2010
				* @Inc# - 
				* @Desc - As item_cost_value is calculated and passed from the validate jsp, the below code is not needed and so commented
				*/
				/*double	item_cost_value	=	Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))*Double.parseDouble((String)hmDtlRecord.get("item_qty"));
				String stitem_cost_value	=	setNumber(""+item_cost_value,3);  */

				hmDtlTemp.put("mode", hmDtlRecord.get("mode"));
				hmDtlTemp.put("doc_srl_no", hmDtlRecord.get("doc_srl_no"));
				hmDtlTemp.put("item_code", hmDtlRecord.get("item_code"));
				hmDtlTemp.put("sal_category", "");
				hmDtlTemp.put("hcp_issue_factor", "");
				hmDtlTemp.put("item_qty", hmDtlRecord.get("item_qty"));
				//hmDtlTemp.put("item_sal_value", stitem_cost_value);//hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("item_sal_value", hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("next_due_date", "");
				hmDtlTemp.put("stock_item_yn", hmDtlRecord.get("stock_item_yn"));
				hmDtlTemp.put("remarks", hmDtlRecord.get("remarks"));
				hmDtlTemp.put("item_unit_cost", hmDtlRecord.get("item_unit_cost"));
				//hmDtlTemp.put("item_cost_value",stitem_cost_value);// hmDtlRecord.get("item_unit_cost"));
				hmDtlTemp.put("item_cost_value", hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("item_unit_price", hmDtlRecord.get("item_unit_cost"));
				hmDtlTemp.put("uom_code", hmDtlRecord.get("uom_code"));
	
				alDtlData.add(hmDtlTemp);
			} 
 
			for (int i=0; i<alExpRecords.size(); i++) {
				HashMap hmExpRecord		=	(HashMap)alExpRecords.get(i);
				HashMap hmExpTemp	=	new HashMap();
				hmExpTemp.put("doc_srl_no", hmExpRecord.get("doc_srl_no"));
				hmExpTemp.put("store_code", hmExpRecord.get("STORE_CODE"));
				hmExpTemp.put("item_code", hmExpRecord.get("ITEM_CODE"));
				hmExpTemp.put("batch_id", hmExpRecord.get("BATCH_ID"));
				hmExpTemp.put("bin_location_code", hmExpRecord.get("BIN_LOCATION_CODE"));
				hmExpTemp.put("expiry_date_or_receipt_date", hmExpRecord.get("EXPIRY_DATE"));
				hmExpTemp.put("trade_id", hmExpRecord.get("TRADE_ID"));
				hmExpTemp.put("sal_item_qty", hmExpRecord.get("QTY"));
				hmExpTemp.put("ret_item_qty","");

				String stQty	=	(String)hmExpRecord.get("QTY");
				if (stQty==null||stQty.equals("")) {
					continue;
				}

				alExpData.add(hmExpTemp);
			} 

			hmData.put("HDR_DATA",hmHeader);
			hmData.put("DTL_DATA",alDtlData);
			hmData.put("DTL_EXP_DATA",alExpData);
			hmData.put("COMMON_DATA",hmData.get("COMMON_DATA"));

			hmResult=stSales.updateSales(connection, hmData);
			throwExceptionWhenFailed(hmResult);
            connection.commit();
        }
        catch(Exception exception){
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
            hmResult.put(RESULT, FALSE);
            hmResult.put(MSGID, exception.getMessage());
            hmResult.put(MESSAGE, exception.toString());
        }
        finally{
            try{
				closeConnection(connection, properties);
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
        return hmResult;
    }
}
