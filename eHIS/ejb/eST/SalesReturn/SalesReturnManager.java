/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
07/05/2019				IN:070328			    B Haribabu         07/05/2019        B Haribabu        SKR-SCF-1202(Added no of decimals allowed)

--------------------------------------------------------------------------------------------------------------------------------------------
*/
//package eST.SalesReturn12;

package eST.SalesReturn;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="SalesReturn"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SalesReturn"
*	local-jndi-name="SalesReturn"
*	impl-class-name="eST.SalesReturn.SalesReturnManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.SalesReturn.SalesReturnLocal"
*	remote-class="eST.SalesReturn.SalesReturnRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.SalesReturn.SalesReturnLocalHome"
*	remote-class="eST.SalesReturn.SalesReturnHome"
*	generate= "local,remote"
*
*
*/


public class SalesReturnManager extends StEJBSessionAdapter {

	/*public String setNumber(String stNumber, int decimalPlaces){
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
	}*/

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmData, HashMap hmSQLValues)  //throws RemoteException
		{

        Connection connection = null;
		Properties properties=null;
		//eST.SalesReturnCommon.StSalesReturn	stSalesReturn	=	new eST.SalesReturnCommon.StSalesReturn();
		eST.Common.StSalesReturn	stSalesReturn	=	new eST.Common.StSalesReturn();

		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		ArrayList alHdrData		=	(ArrayList)hmData.get("HDR_DATA");
		HashMap hmHeader		=	new HashMap();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alDtlRecords	=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alExpRecords	=	(ArrayList)hmData.get("DTL_EXP_DATA");
		HashMap hmCommon		=	(HashMap)hmData.get("COMMON_DATA");

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
			hmHeader.put("finalized_yn",alHdrData.get(6));
			hmHeader.put("gl_interfaced_yn",alHdrData.get(7));
			hmHeader.put("trn_type",alHdrData.get(8));
			hmHeader.put("remarks",alHdrData.get(9));
			hmHeader.put("item_class_code",alHdrData.get(10));
			hmHeader.put("module_id","ST");
			hmHeader.put("patient_id",alHdrData.get(11));
			hmHeader.put("encounter_id",alHdrData.get(12));
			hmHeader.put("sal_trn_type",alHdrData.get(13));
			hmHeader.put("billable_trn_yn",alHdrData.get(14));
			hmHeader.put("sales_doc_no",alHdrData.get(15));
			hmHeader.put("NU_Clinic_code",checkForNull(alHdrData.get(16)));
			hmHeader.put("authorized_by_id",(String)hmCommon.get("login_by_id"));//handle for PH Dispense Return Medication Thursday, November 01, 2012 Ganga



			for (int i=0; i<alDtlRecords.size(); i++) {

				HashMap hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
				System.out.println("hmDtlRecord=ejb====" +hmDtlRecord);
				HashMap hmDtlTemp		=	new HashMap();

				hmDtlTemp.put("doc_srl_no", hmDtlRecord.get("doc_srl_no"));
				hmDtlTemp.put("item_code", hmDtlRecord.get("item_code"));
								
				hmDtlTemp.put("item_qty", hmDtlRecord.get("item_qty"));
							
				hmDtlTemp.put("stock_item_yn", hmDtlRecord.get("stock_item_yn"));
				//hmDtlTemp.put("remarks", hmDtlRecord.get("remarks"));
				hmDtlTemp.put("remarks", checkForNull(hmDtlRecord.get("remarks_code"))); //20/06/12
				/* @Name - Priya
				* @Date - 18/05/2010
				* @Inc# - 
				* @Desc - As item_cost_value is calculated in the SalesReturnBean, the below code is not needed and so commented
				*/
				/*double	item_unit_cost		=   Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"));
				String stitem_unit_cost    =	setNumber(""+item_unit_cost,6);
				hmDtlTemp.put("item_unit_cost", stitem_unit_cost);
                
				double	item_cost_value		=   Double.parseDouble((String)hmDtlRecord.get("item_cost_value"));
				String stitem_cost_value	=	setNumber(""+item_cost_value,3);
				hmDtlTemp.put("item_cost_value",stitem_cost_value);*/
				hmDtlTemp.put("item_unit_cost", hmDtlRecord.get("item_unit_cost"));
				hmDtlTemp.put("item_cost_value", hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("uom_code", hmDtlRecord.get("uom_code"));
				hmDtlTemp.put("pat_net_amt", hmDtlRecord.get("pat_net_amt"));
				hmDtlTemp.put("gross_charge_amt", hmDtlRecord.get("gross_charge_amt"));
				hmDtlTemp.put("batch_records", hmDtlRecord.get("batch_records"));
				hmDtlTemp.put("mm_trn_qty", hmDtlRecord.get("mm_trn_qty"));
				hmDtlTemp.put("sal_doc_srl_no", hmDtlRecord.get("sal_doc_srl_no"));
				hmDtlTemp.put("sales_doc_no", hmDtlRecord.get("sales_doc_no"));
				hmDtlTemp.put("sales_doc_type_code", hmDtlRecord.get("sales_doc_type_code"));
				hmDtlTemp.put("no_of_decimals", hmDtlRecord.get("no_of_decimals"));//Added for IN:070328 
				alDtlData.add(hmDtlTemp);
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
				hmExpTemp.put("expiry_date_or_receipt_date", hmExpRecord.get("EXPIRY_RECEIPT_DT"));
				hmExpTemp.put("trade_id", hmExpRecord.get("TRADE_ID"));

				hmExpTemp.put("sal_doc_type_code", hmExpRecord.get("SAL_DOC_TYPE_CODE"));
				hmExpTemp.put("sal_doc_no", hmExpRecord.get("SAL_DOC_NO"));

                hmExpTemp.put("sal_doc_srl_no", hmExpRecord.get("SAL_DOC_SRL_NO"));
				hmExpTemp.put("sal_doc_date", hmExpRecord.get("SAL_DOC_DATE"));

                hmExpTemp.put("new_bin_location_code", hmExpRecord.get("NEW_BIN_LOCATION_CODE"));
				hmExpTemp.put("modified_date",hmExpRecord.get("modified_date"));
				
								
				String stQty	=	(String)hmExpRecord.get("QTY");
				if (stQty==null||stQty.equals("")) {
					continue;
				}
				hmExpTemp.put("ret_item_qty", stQty);

				alExpData.add(hmExpTemp);
			
			}
        
 
			hmData.put("HDR_DATA",hmHeader);
			hmData.put("COMMON_DATA",hmData.get("COMMON_DATA"));
			hmData.put("DTL_DATA",alDtlData);
			hmData.put("DTL_EXP_DATA",alExpData);
 
			hmResult=stSalesReturn.insertSalesReturn(connection, hmData);
			throwExceptionWhenFailed(hmResult);  

			ArrayList l_doc_nos = (ArrayList)hmResult.get("doc_no");
			String l_doc_no = (String)l_doc_nos.get(0);

			ArrayList alRecord	= new ArrayList();
			alRecord.add(checkForNull((String)alHdrData.get(0)));
			alRecord.add(checkForNull((String)alHdrData.get(1)));
			alRecord.add(checkForNull(l_doc_no));


			int count = Integer.parseInt((String)fetchRecord(connection, "SELECT COUNT(*) COUNT FROM ST_SAL_RET_DTL_EXP  WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ?  AND DOC_NO = ? ", alRecord).get("COUNT"));


			if(count <= 0){
				System.out.println("SalesReturnManager.java, Insert Mode count 268= > "+count);
				System.out.println("SalesReturnManager.java,Insert Mode alRecord 268= > "+alRecord);

					throw new Exception ("ST-MSG001 Error encountered while updating Exp Details. Pl retry the transaction");
			}

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

	public HashMap modify(HashMap hmData, HashMap hmSQLValues) // throws RemoteException 
		{

        Connection connection = null;
		Properties properties=null;
//		eST.SalesReturnCommon.StSalesReturn	stSalesReturn	=	new eST.SalesReturnCommon.StSalesReturn();
		eST.Common.StSalesReturn	stSalesReturn	=	new eST.Common.StSalesReturn();

		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		HashMap hmHeader		=	new HashMap();
		ArrayList alHdrData		=	(ArrayList)hmData.get("HDR_DATA");
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList doc_no		=	new ArrayList();
		ArrayList alDtlRecords	=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alExpRecords	=	(ArrayList)hmData.get("DTL_EXP_DATA");
		HashMap hmCommon		=	(HashMap)hmData.get("COMMON_DATA");


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
			hmHeader.put("finalized_yn",alHdrData.get(6));
			hmHeader.put("gl_interfaced_yn",alHdrData.get(7));
			hmHeader.put("trn_type",alHdrData.get(8));
			hmHeader.put("remarks",alHdrData.get(9));
			hmHeader.put("item_class_code",alHdrData.get(10));
			hmHeader.put("module_id","ST");
			hmHeader.put("patient_id",alHdrData.get(11));
			hmHeader.put("encounter_id",alHdrData.get(12));
			hmHeader.put("sal_trn_type",alHdrData.get(13));
			hmHeader.put("billable_trn_yn",alHdrData.get(14));
			hmHeader.put("sales_doc_no",alHdrData.get(15));
			hmHeader.put("authorized_by_id",(String)hmCommon.get("login_by_id"));//handle for PH Dispense Return Medication Thursday, November 01, 2012 Ganga



			for (int i=0; i<alDtlRecords.size(); i++) {

				HashMap hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
				HashMap hmDtlTemp	    =	new HashMap();

                hmDtlTemp.put("mode", hmDtlRecord.get("mode"));
				hmDtlTemp.put("doc_srl_no", hmDtlRecord.get("doc_srl_no"));
				hmDtlTemp.put("item_code", hmDtlRecord.get("item_code"));
				hmDtlTemp.put("item_qty", hmDtlRecord.get("item_qty"));
				hmDtlTemp.put("stock_item_yn", hmDtlRecord.get("stock_item_yn"));
				//hmDtlTemp.put("remarks", hmDtlRecord.get("remarks"));
				hmDtlTemp.put("remarks", checkForNull(hmDtlRecord.get("remarks_code")));//20/06/12
				 /* @Name - Priya
				* @Date - 18/05/2010
				* @Inc# - 
				* @Desc - As item_cost_value is calculated in the SalesReturnBean, the below code is not needed and so commented
				*/
				/*double	item_unit_cost		=   Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"));
				String stitem_unit_cost    =	setNumber(""+item_unit_cost,6);
				hmDtlTemp.put("item_unit_cost", stitem_unit_cost);
                
				double	item_cost_value		=   Double.parseDouble((String)hmDtlRecord.get("item_cost_value"));
				String stitem_cost_value	=	setNumber(""+item_cost_value,3);
				hmDtlTemp.put("item_cost_value",stitem_cost_value);	*/
				hmDtlTemp.put("item_unit_cost", hmDtlRecord.get("item_unit_cost"));
				hmDtlTemp.put("item_cost_value", hmDtlRecord.get("item_cost_value"));  
				hmDtlTemp.put("uom_code", hmDtlRecord.get("uom_code"));
				hmDtlTemp.put("mm_trn_qty", hmDtlRecord.get("mm_trn_qty"));
				hmDtlTemp.put("sales_doc_no", hmDtlRecord.get("sales_doc_no"));
				hmDtlTemp.put("sal_doc_srl_no", hmDtlRecord.get("sal_doc_srl_no"));
				hmDtlTemp.put("sales_doc_type_code", hmDtlRecord.get("sales_doc_type_code"));
				hmDtlTemp.put("no_of_decimals", hmDtlRecord.get("no_of_decimals"));//Added for IN:070328
				alDtlData.add(hmDtlTemp);
			} 
 
			for (int i=0; i<alExpRecords.size(); i++) {

				HashMap hmExpRecord		=	(HashMap)alExpRecords.get(i);

//				ArrayList alExpTemp		=	new ArrayList();

				HashMap hmExpTemp	=	new HashMap();
				hmExpTemp.put("doc_srl_no", hmExpRecord.get("doc_srl_no"));
				hmExpTemp.put("store_code", alHdrData.get(5));
				hmExpTemp.put("item_code", hmExpRecord.get("ITEM_CODE"));
				hmExpTemp.put("batch_id", hmExpRecord.get("BATCH_ID"));
				hmExpTemp.put("bin_location_code", hmExpRecord.get("BIN_LOCATION_CODE"));
                hmExpTemp.put("new_bin_location_code", hmExpRecord.get("NEW_BIN_LOCATION_CODE"));
				hmExpTemp.put("expiry_date_or_receipt_date", hmExpRecord.get("EXPIRY_RECEIPT_DT"));
				hmExpTemp.put("trade_id", hmExpRecord.get("TRADE_ID"));
				hmExpTemp.put("DOC_TYPE_CODE", hmExpRecord.get("SAL_DOC_TYPE_CODE"));
				hmExpTemp.put("DOC_NO", hmExpRecord.get("SAL_DOC_NO"));
//  ADDED BY PANKAJ ON 08/07/2004
                hmExpTemp.put("SAL_DOC_DATE", hmExpRecord.get("SAL_DOC_DATE"));
				hmExpTemp.put("SAL_DOC_SRL_NO", hmExpRecord.get("SAL_DOC_SRL_NO"));
				hmExpTemp.put("modified_date",hmExpRecord.get("modified_date"));

												
				String stQty	=	(String)hmExpRecord.get("QTY");
				if (stQty==null||stQty.equals("")) {
					continue;
				}
				hmExpTemp.put("ret_item_qty", stQty);


				alExpData.add(hmExpTemp);
			
			} 
			hmData.put("HDR_DATA",hmHeader);
			hmData.put("DTL_DATA",alDtlData);
			hmData.put("DTL_EXP_DATA",alExpData);
			hmData.put("COMMON_DATA",hmData.get("COMMON_DATA"));

			hmResult=stSalesReturn.updateSalesReturn(connection, hmData);
			throwExceptionWhenFailed(hmResult);

			String finalized	= checkForNull((String)alHdrData.get(6));

			if(finalized.equals("Y")){
				ArrayList alRecord	= new ArrayList();
				alRecord.add(checkForNull((String)alHdrData.get(0)));
				alRecord.add(checkForNull((String)alHdrData.get(1)));
				alRecord.add(checkForNull((String)alHdrData.get(2)));
				alRecord.add("SRT");


				int count = Integer.parseInt((String)fetchRecord(connection, "SELECT COUNT(*) COUNT FROM ST_ITEM_TRN_DTL  WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ?  AND DOC_NO = ? AND TRN_TYPE = ? ", alRecord).get("COUNT"));
	

				if(count <= 0){
					System.out.println("SalesReturnManager.java,count 495= > "+count);
					System.out.println("SalesReturnManager.java, Update Mode  alRecord 495= > "+alRecord);

					throw new Exception ("ST-MSG001 Error encountered while updating Stock. Pl retry the transaction");
				}
			}else{
				ArrayList alRecord	= new ArrayList();
				alRecord.add(checkForNull((String)alHdrData.get(0)));
				alRecord.add(checkForNull((String)alHdrData.get(1)));
				alRecord.add(checkForNull((String)alHdrData.get(2)));

				int count = Integer.parseInt((String)fetchRecord(connection, "SELECT COUNT(*) COUNT FROM ST_SAL_RET_DTL_EXP  WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ?  AND DOC_NO = ? ", alRecord).get("COUNT"));

				if(count <= 0){
					System.out.println("SalesReturnManager.java,Update Mode count 501= > "+count);
					System.out.println("SalesReturnManager.java,Update Mode  alRecord 501= > "+alRecord);

					throw new Exception ("ST-MSG001 Error encountered while updating Exp Details. Pl retry the transaction");
				}			
			}

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
            //hmResult.put(MSGID, exception.getMessage());
			if((exception.getMessage()).contains("BL9146")){//Added for MMS-DM-CRF-192.2 in 03/03/2016
				hmResult.put(MSGID, exception.toString());
				hmResult.put(MESSAGE, exception.getMessage());
			}else{
				hmResult.put(MSGID, exception.toString());
				hmResult.put(MESSAGE, exception.toString());
			}
        }
        finally{
            try{
				closeConnection(connection, properties);
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
		doc_no.add((String)alHdrData.get(2));
		hmResult.put("doc_no",doc_no);
        return hmResult;
    }


	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQLValues) //throws RemoteException
		{

        Connection connection = null;
		Properties properties=null;

		eST.Common.StSalesReturn	stSalesReturn	=	new eST.Common.StSalesReturn();
		//eST.SalesReturnCommon.StSalesReturn	stSalesReturn	=	new eST.SalesReturnCommon.StSalesReturn();

		HashMap hmResult=new HashMap();
		HashMap	hmHeader=new HashMap();
		hmResult.put("result", FALSE);

		ArrayList alData		=	(ArrayList)hmData.get("DATA");

		HashMap hmDeleteData = new HashMap();

        try{
            properties = (Properties)hmData.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			hmHeader.put("facility_id", alData.get(0));  
			hmHeader.put("doc_type_code", alData.get(1));  
			hmHeader.put("doc_no", alData.get(2));  

			hmDeleteData.put("DATA",hmHeader);
			hmDeleteData.put("COMMON_DATA",hmData.get("COMMON_DATA"));

			hmResult=stSalesReturn.deleteSalesReturn(connection, hmDeleteData);
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
