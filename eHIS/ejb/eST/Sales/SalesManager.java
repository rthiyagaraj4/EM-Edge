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
30/01/2020      		IN071972            	Haribabu                                AAKH-CRF-0117.2 
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eST.Sales;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
*
* @ejb.bean
*	name="Sales"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Sales"
*	local-jndi-name="Sales"
*	impl-class-name="eST.Sales.SalesManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.Sales.SalesLocal"
*	remote-class="eST.Sales.SalesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.Sales.SalesLocalHome"
*	remote-class="eST.Sales.SalesHome"
*	generate= "local,remote"
*
*
*/


public class SalesManager extends StEJBSessionAdapter {
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQLValues) //throws RemoteException
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
		eST.Common.StSales	stSales	=	new eST.Common.StSales();

		HashMap hmResult=new HashMap();
		hmResult.put("result", FALSE);

		ArrayList alHdrData		=	(ArrayList)hmData.get("HDR_DATA");
		HashMap hmHeader		=	new HashMap();
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
			hmHeader.put("module_id",checkForNull(alHdrData.get(23),"ST"));
			//code added for inserting take_home_yn and billable_trn_yn .. 18/5/2004
			hmHeader.put("billable_trn_yn",checkForNull(alHdrData.get(18),"N"));
			hmHeader.put("take_home_yn",checkForNull(alHdrData.get(19),"N"));
			 hmHeader.put("token_series_code",checkForNull(alHdrData.get(20),""));
			 hmHeader.put("token_serial_no",checkForNull(alHdrData.get(21),""));
			 hmHeader.put("patient_name",checkForNull(alHdrData.get(22),""));
			 hmHeader.put("ref_no",checkForNull(alHdrData.get(24),""));
			 hmHeader.put("sales_priority_type",checkForNull(alHdrData.get(25),"R"));
			 hmHeader.put("NU_Clinic_code",checkForNull(alHdrData.get(26)));

			 hmHeader.put("patient_age",checkForNull(alHdrData.get(27)));
			 hmHeader.put("patient_sex",checkForNull(alHdrData.get(28)));
			 hmHeader.put("patient_dob",checkForNull(alHdrData.get(29)));

			 
			for (int i=0; i<alDtlRecords.size(); i++) {
				HashMap hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
				//System.out.println("hmDtlRecord==184====>" +hmDtlRecord);
				HashMap hmDtlTemp	=	new HashMap();
				/* @Name - Priya
				* @Date - 18/05/2010
				* @Inc# - 
				* @Desc - As item_cost_value is calculated and passed from the validate jsp, the below code is not needed and so commented
				*/
				//The below calculation is uncommented by Ganga for KDAH huge sale value issue, on Thursday, February 28, 2013
				int     noOfDecimalsForCost   =  Integer.parseInt(getNoOfDecimalsCost(connection));
				double	item_cost_value	      =	 Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))*Double.parseDouble((String)hmDtlRecord.get("item_qty"));
				String  stitem_cost_value     =	 setNumber(""+item_cost_value,noOfDecimalsForCost); 

				hmDtlTemp.put("doc_srl_no", hmDtlRecord.get("doc_srl_no"));
				hmDtlTemp.put("item_code", hmDtlRecord.get("item_code"));
				hmDtlTemp.put("sal_category", "");
				hmDtlTemp.put("hcp_issue_factor", "");
				hmDtlTemp.put("item_qty", hmDtlRecord.get("item_qty"));
				//hmDtlTemp.put("item_sal_value","0"+hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("item_sal_value",stitem_cost_value);

				hmDtlTemp.put("next_due_date", "");
				hmDtlTemp.put("stock_item_yn", hmDtlRecord.get("stock_item_yn"));
				hmDtlTemp.put("remarks", hmDtlRecord.get("remarks_code"));
				hmDtlTemp.put("item_unit_cost", hmDtlRecord.get("item_unit_cost"));
				//hmDtlTemp.put("item_cost_value","0"+hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("item_cost_value",stitem_cost_value);

				hmDtlTemp.put("item_unit_price", hmDtlRecord.get("item_unit_cost"));
				hmDtlTemp.put("uom_code", hmDtlRecord.get("uom_code"));
				hmDtlTemp.put("pat_net_amt", hmDtlRecord.get("pat_net_amt"));
				hmDtlTemp.put("gross_charge_amt", hmDtlRecord.get("gross_charge_amt"));
				hmDtlTemp.put("batch_records", hmDtlRecord.get("batch_records"));
				hmDtlTemp.put("mm_trn_qty", hmDtlRecord.get("mm_trn_qty"));
				hmDtlTemp.put("p_overridden_excl_incl_ind", (checkForNull(hmDtlRecord.get("p_overridden_excl_incl_ind"))).equals("S")?"":checkForNull(hmDtlRecord.get("p_overridden_excl_incl_ind")));
				hmDtlTemp.put("p_overridden_action_reason", checkForNull(hmDtlRecord.get("p_overridden_action_reason")));
				hmDtlTemp.put("take_home_yn", checkForNull(alHdrData.get(19),"N"));
				hmDtlTemp.put("sale_req_qty", hmDtlRecord.get("item_qty"));
				hmDtlTemp.put("usage_type", checkForNull(hmDtlRecord.get("usage_type"))); //18/09/12
				hmDtlTemp.put("approval_no", checkForNull(hmDtlRecord.get("approval_no")));//Added for IN:071972
				
				alDtlData.add(hmDtlTemp);
				//System.out.println("alDtlData==184====>" +alDtlData);
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
				hmExpTemp.put("modified_date",hmExpRecord.get("modified_date"));
				//hmExpTemp.put("batch_srl_no",hmExpRecord.get("batch_srl_no"));
				hmExpTemp.put("batch_srl_no",checkForNull(hmExpRecord.get("batch_srl_no")));
				hmExpTemp.put("barcode_id",checkForNull(hmExpRecord.get("BARCODE_ID")));				
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
			//System.out.println("SalesManager.java,hmData = > "+hmData);
			hmResult=stSales.insertSales(connection, hmData);
			throwExceptionWhenFailed(hmResult);

			ArrayList l_doc_nos = (ArrayList)hmResult.get("doc_no");
			String l_doc_no = (String)l_doc_nos.get(0);

			ArrayList alRecord	= new ArrayList();
			alRecord.add(checkForNull((String)alHdrData.get(0)));
			alRecord.add(checkForNull((String)alHdrData.get(1)));
			alRecord.add(checkForNull(l_doc_no));

		

			int count = Integer.parseInt((String)fetchRecord(connection, "SELECT COUNT(*) COUNT FROM ST_SAL_DTL_EXP  WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ?  AND DOC_NO = ? ", alRecord).get("COUNT"));


			if(count <= 0){
				System.out.println("SalesManager.java, Insert Mode count 268= > "+count);
				System.out.println("SalesManager.java,Insert Mode alRecord 268= > "+alRecord);

				throw new Exception ("ST-MSG001 Error encountered while updating Exp Details. Pl retry the transaction");
			}

	          connection.commit();
        }
        catch(Exception exception){
//Added by Shaiju
			System.err.println("hmResult...in insert..in ejb..catch.1..."+hmResult);
			System.err.println("SalesManager.java,hmData = > "+hmData);
//End of addition
			try{
				connection.rollback();
				exception.printStackTrace();
            }
            catch(Exception subException){
                subException.printStackTrace();
            }
			
			hmResult.put(RESULT, FALSE);
            hmResult.put(MSGID, exception.getMessage());
            //hmResult.put(MESSAGE, exception.toString());
			hmResult.put(MESSAGE, exception.getMessage());
			
			String message = (String)hmResult.get("message");
			String msgid = (String)hmResult.get("msgid");
			
			System.err.println("SalesManager.java,260,message = > "+message+" msgid = > "+msgid);
			if(message.contains("RECORD_UPDATED_BY_OTH_USER"))
			{
				hmResult.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
			}
			else if(message.contains("NEGATIVE_STOCK"))
			{
				
				//String[] strTokens = message.split("!~");
				/*StringTokenizer stkTok = new StringTokenizer(message,"!~");
					
					int i=0;
					String param[] = new String[2];
					while(stkTok.hasMoreTokens())
					{				
						param[i] = stkTok.nextToken();
						
						i++;
					}  */
								
				hmResult.put(MSGID,"NEGATIVE_STOCK");
				hmResult.put(MESSAGE,"NEGATIVE_STOCK");
				//hmResult.put("itemDesc",)
			}
			else
			{
				
				if(msgid.contains("java.lang.Exception"))
				{
					hmResult.put(MSGID,null);
				}
			}
			System.out.println("SalesManager.java,292,hmResult = > "+hmResult);
			
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
		ArrayList doc_no		=	new ArrayList();
		ArrayList alDtlRecords	=	(ArrayList)hmData.get("DTL_DATA");
		ArrayList alExpRecords	=	(ArrayList)hmData.get("DTL_EXP_DATA");
		
		//System.out.println("Sales Manager Modify hmData------>"+hmData);
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
			//code added to update billable and takehome values...
			hmHeader.put("billable_trn_yn",alHdrData.get(20));
			hmHeader.put("take_home_yn",alHdrData.get(21));
			hmHeader.put("module_id",alHdrData.get(22));
			hmHeader.put("token_series_code ","");
			hmHeader.put("token_serial_no ","");

			hmHeader.put("patient_age",checkForNull(alHdrData.get(23)));
			hmHeader.put("patient_sex",checkForNull(alHdrData.get(24)));
			hmHeader.put("patient_dob",checkForNull(alHdrData.get(25)));

			for (int i=0; i<alDtlRecords.size(); i++) {
				HashMap hmDtlRecord		=	(HashMap)alDtlRecords.get(i);
				HashMap hmDtlTemp	=	new HashMap();
				/* @Name - Priya
				* @Date - 18/05/2010
				* @Inc# - 
				* @Desc - As item_cost_value is calculated and passed from the validate jsp, the below code is not needed and so commented
				*/
				int     noOfDecimalsForCost   =  Integer.parseInt(getNoOfDecimalsCost(connection));
				double	item_cost_value	      =	 Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))*Double.parseDouble((String)hmDtlRecord.get("item_qty"));
				String  stitem_cost_value	  =	 setNumber(""+item_cost_value,noOfDecimalsForCost); 


				hmDtlTemp.put("mode", hmDtlRecord.get("mode"));
				hmDtlTemp.put("doc_srl_no", hmDtlRecord.get("doc_srl_no"));
				hmDtlTemp.put("item_code", hmDtlRecord.get("item_code"));
				hmDtlTemp.put("sal_category", "");
				hmDtlTemp.put("hcp_issue_factor", "");
				hmDtlTemp.put("item_qty", hmDtlRecord.get("item_qty"));
				//hmDtlTemp.put("item_sal_value","0"+hmDtlRecord.get("item_cost_value"));
			//	hmDtlTemp.put("item_sal_value", hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("item_sal_value", stitem_cost_value);


				hmDtlTemp.put("next_due_date", "");
				hmDtlTemp.put("stock_item_yn", hmDtlRecord.get("stock_item_yn"));
				hmDtlTemp.put("remarks", hmDtlRecord.get("remarks_code"));
				hmDtlTemp.put("item_unit_cost", hmDtlRecord.get("item_unit_cost"));
				//hmDtlTemp.put("item_cost_value","0"+hmDtlRecord.get("item_cost_value"));
				hmDtlTemp.put("item_cost_value",stitem_cost_value);

				hmDtlTemp.put("item_unit_price", hmDtlRecord.get("item_unit_cost"));
				hmDtlTemp.put("uom_code", hmDtlRecord.get("uom_code"));
				hmDtlTemp.put("mm_trn_qty", hmDtlRecord.get("mm_trn_qty"));
				hmDtlTemp.put("pat_net_amt", hmDtlRecord.get("pat_net_amt"));
				hmDtlTemp.put("gross_charge_amt", hmDtlRecord.get("gross_charge_amt"));
				//hmDtlTemp.put("p_overridden_excl_incl_ind", checkForNull(hmDtlRecord.get("p_overridden_excl_incl_ind")));
				hmDtlTemp.put("p_overridden_excl_incl_ind", (checkForNull(hmDtlRecord.get("p_overridden_excl_incl_ind"))).equals("S")?"":checkForNull(hmDtlRecord.get("p_overridden_excl_incl_ind")));
				hmDtlTemp.put("p_overridden_action_reason", checkForNull(hmDtlRecord.get("p_overridden_action_reason")));
				hmDtlTemp.put("take_home_yn", checkForNull(alHdrData.get(21),"N"));
				hmDtlTemp.put("sale_req_qty", hmDtlRecord.get("sale_req_qty"));
				hmDtlTemp.put("usage_type", checkForNull(hmDtlRecord.get("usage_type")));
				hmDtlTemp.put("approval_no", checkForNull(hmDtlRecord.get("approval_no")));//Added for IN:071972
                // System.out.println("hmDtlTemp ===sal mng 422===>" +hmDtlTemp);

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
				hmExpTemp.put("modified_date",hmExpRecord.get("modified_date"));
				//hmExpTemp.put("batch_srl_no",hmExpRecord.get("batch_srl_no"));
				hmExpTemp.put("batch_srl_no",checkForNull(hmExpRecord.get("batch_srl_no")));
				hmExpTemp.put("barcode_id",checkForNull(hmExpRecord.get("BARCODE_ID")));
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

			String finalized	= checkForNull((String)alHdrData.get(9));

			if(finalized.equals("Y")){
				ArrayList alRecord	= new ArrayList();
				alRecord.add(checkForNull((String)alHdrData.get(0)));
				alRecord.add(checkForNull((String)alHdrData.get(1)));
				alRecord.add(checkForNull((String)alHdrData.get(2)));
				alRecord.add("SAL");


				int count = Integer.parseInt((String)fetchRecord(connection, "SELECT COUNT(*) COUNT FROM ST_ITEM_TRN_DTL  WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ?  AND DOC_NO = ? AND TRN_TYPE = ? ", alRecord).get("COUNT"));

				if(count <= 0){
					System.out.println("SalesManager.java, Update Mode  alRecord 495= > "+alRecord);
					System.out.println("SalesManager.java,count 495= > "+count);

					throw new Exception ("ST-MSG001 Error encountered while updating Stock. Pl retry the transaction");
				}
			}else{
				ArrayList alRecord	= new ArrayList();
				alRecord.add(checkForNull((String)alHdrData.get(0)));
				alRecord.add(checkForNull((String)alHdrData.get(1)));
				alRecord.add(checkForNull((String)alHdrData.get(2)));


				int count = Integer.parseInt((String)fetchRecord(connection, "SELECT COUNT(*) COUNT FROM ST_SAL_DTL_EXP  WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ?  AND DOC_NO = ? ", alRecord).get("COUNT"));


				if(count <= 0){
					System.out.println("SalesManager.java,Update Mode count 501= > "+count);
					System.out.println("SalesManager.java,Update Mode  alRecord 501= > "+alRecord);		

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
            hmResult.put(MSGID, exception.getMessage());
            hmResult.put(MESSAGE, exception.toString());
			String message = (String)hmResult.get("message");
			String msgid = (String)hmResult.get("msgid");
			
			if(message.contains("NO_RECORD_UPDATED"))
			{
				hmResult.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
			}
			else if(message.contains("RECORD_UPDATED_BY_OTH_USER"))
			{
				hmResult.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
			}
			else
			{
				if(msgid.contains("java.lang.Exception"))
				{
					hmResult.put(MSGID,null);
				}
			}
			System.out.println("SalesManager.java,hmData update= > "+hmData);
			System.out.println("hmResult...in update..in ejb..catch...."+hmResult);
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
}
