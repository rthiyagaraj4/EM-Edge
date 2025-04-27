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
03/06/2016				60468					B.Badmavathi									  Batch auto allocation for Expiry batch
26/10/2016				62242					B.Badmavathi					Added new function to fetch Suspended and Expired batches 
06/04/2017				IN063878				Badmavathi B					        					 Unused variables
29/05/2017		        63673					Badmavathi B										GHL-SCF-1169  - 'Process Expired Batches'-> unchecked , 'Use After Expiry' -> checked 
2/7/2021				15757					Shazana														Common-ICN-0028
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eST.Common ;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.util.* ;
import java.util.regex.Pattern;//Added for MMS-DM-CRF-0174.5
import java.util.regex.Matcher;//Added for MMS-DM-CRF-0174.5
import java.text.SimpleDateFormat; //Added for MOHE-CRF-0167

public class StUtilities extends StAdapter implements Serializable {


	public StUtilities(Properties properties){
		setProperties(properties);
	}

	public StUtilities(){

	}

	public HashMap getBatches(HashMap hmParameters)throws Exception{
		
		/*  Modified on 1/22/2007 by RammohanC to include trade name for PH Module to display trade name along with drug name */
		StringTokenizer st = new StringTokenizer((String)hmParameters.get("ITEM_CODE"), "=");
		String stItem_code  ="";
		String stTrade_code ="";
		//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014  not to show batches based on below condition beg
		//HashMap alRecord	=	null;
		//String process_supend_batch_yn = "";
		//String process_expired_items_yn = "";
		//String use_after_expiry_yn = "";
		String IncludeExpired	= "N";
		String IncludeSuspended	= "N";
		String authorize_yn = "N";//Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016
		//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 end
		while (st.hasMoreTokens()) {
			 stItem_code = st.nextToken();
			 if (st.hasMoreTokens())
			 {
 			 stTrade_code = st.nextToken();
			 }		
		}

		
		String stStore_code				=	(String)hmParameters.get("STORE_CODE");
				
		authorize_yn				=	checkForNull(((String)hmParameters.get("AUTHORIZE_YN")),"N");
		String trn_type 			=	checkForNull(((String)hmParameters.get("TRN_TYPE")),"");//Added for GHL-SCF-1169 
		String user = getLoginById();
		System.out.println("user======"+user+"stItem_code======="+stItem_code);
		System.out.println("authorize_yn======"+authorize_yn);
		ArrayList alParameters1	=	new ArrayList(4);		
		alParameters1.add(stStore_code);
		alParameters1.add(user);
		String IncludeExpired1 =		checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_BATCH_EXPIRED_USER_ACCESS"),alParameters1).get("PROCESS_EXPIRED_ITEMS_YN"));
		String IncludeExpired2 =		checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_BATCH_EXPIRED_OR_NOT"),stItem_code).get("USE_AFTER_EXPIRY_YN"));
		System.out.println("IncludeExpired1======"+IncludeExpired1+"IncludeExpired2======="+IncludeExpired2);		
		//double iTxn_qty					=	(Double.parseDouble((String)hmParameters.get("TRN_QTY")));
		double iTxn_qty					=	0.0;
		//Remember for Bharat Mata		
		if(hmParameters.get("TRN_QTY")!=null)
			iTxn_qty					=	(Double.parseDouble((String)hmParameters.get("TRN_QTY"))); 
		
	//	boolean bIncludeSuspended		=	checkForNull(((String)hmParameters.get("INCLUDE_SUSPENDED")),"FALSE").equals("TRUE"); Commented for unused variables IN063878
	//	boolean bIncludeExpired			=	checkForNull(((String)hmParameters.get("INCLUDE_EXPIRED")),"FALSE").equals("TRUE"); Commented for unused variables IN063878
		String stCutOffDate				=	checkForNull((String)hmParameters.get("CUT_OFF_DATE"),"");
		boolean bVerifyInsufficientQty	=	checkForNull(((String)hmParameters.get("VERIFY_INSUFFICIENT_QTY")),"TRUE").equals("TRUE");


		System.out.println("iTxn_qty => "+iTxn_qty+" stStore_code = > "+stStore_code);
		
		 //added on 24/08
		 double iBalAlreadyUsedQty = Double.parseDouble(checkForNull((String)hmParameters.get("ALREADY_USED_QTY"),"0"));
		 String stMinExpDate = checkForNull((String)hmParameters.get("MIN_EXP_DATE"),stCutOffDate);
		/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications 
			
			**/
		int no_of_decimals=getNoOfDecimals();
		String allow_decimals_yn=getAllowDecimalsYN(stItem_code);

		String p_barcode_id =  checkForNull((String)hmParameters.get("BARCODE_ID"),"%");//added by Ganga for PH barcode Thursday, November 29, 2012

		double iCount		=	0;
		
		HashMap hmReturn	= new HashMap();
		HashMap hmRecord	=	null;
		ArrayList alReturn	= new ArrayList();
		try { 
			
		//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014  beg
		//Commented by Rabbani #49131(ML-BRU-SCF-1005.1) on 15-MAY-2014
		/*String []stparameters = {stItem_code,stStore_code,getLoginById()};
		alRecord = (HashMap)fetchRecord(getStRepositoryValue("SQL_ST_BATCH_SEARCH_PROCESS_YN"),stparameters);
		process_supend_batch_yn = checkForNull((String)alRecord.get("PROCESS_SUSPENDED_ITEMS_YN"));
		process_expired_items_yn = checkForNull((String)alRecord.get("PROCESS_EXPIRED_ITEMS_YN"));
		use_after_expiry_yn = checkForNull((String)alRecord.get("USE_AFTER_EXPIRY_YN"));
				
		if(process_expired_items_yn.equals("N") || use_after_expiry_yn.equals("N")){ 
			IncludeExpired = "N";
		}
		
		if(process_supend_batch_yn.equals("N")){
			IncludeSuspended = "N";
		} */
		//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 end
		
			ArrayList alParameters	=	new ArrayList(4);
			alParameters.add(stItem_code);
			alParameters.add(stStore_code);
			//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 beg
			/*alParameters.add((bIncludeSuspended)?"Y":"N");
			alParameters.add((bIncludeExpired)?"Y":"N");*/
			alParameters.add(IncludeSuspended);
			alParameters.add(IncludeExpired);
			//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 end
			alParameters.add(stMinExpDate);
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(stTrade_code);
			alParameters.add(p_barcode_id);//added by Ganga for PH barcode Thursday, November 29, 2012
			System.out.println("alParameters = > "+alParameters);
			ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_BATCH_SEARCH_VIEW_SELECT_BATCH"),alParameters);

			System.out.println("alRecords = > "+alRecords);
			//Added for GHL-SCF-1169 starts 
			if(alRecords.size()==0 && IncludeExpired1.equalsIgnoreCase("N") && trn_type.equals("CON")){
				throw new Exception("EXPIRED_BATCH");
			}
			//Added for GHL-SCF-1169 ends
			for (int i=0;i<alRecords.size();i++ ) {
				hmRecord	=	(HashMap)alRecords.get(i);
				double avail_qty		=	 Double.parseDouble((String)hmRecord.get("AVAIL_QTY"));
				/** @ 
					CRF_SRR20056-CRF-0537.1 
					For handle the Decimals in QOH, avail_Qty Modifications 
			
				**/
				System.out.println("iBalAlreadyUsedQty = > "+iBalAlreadyUsedQty+" avail_qty = > "+avail_qty);
				if(iBalAlreadyUsedQty >= avail_qty){
					iBalAlreadyUsedQty -= avail_qty;
					continue;
				}
				else{
					avail_qty -= iBalAlreadyUsedQty;
					iBalAlreadyUsedQty = 0;
					/** @ 
						CRF_SRR20056-CRF-0537.1 
						For handle the Decimals in QOH, avail_Qty Modifications 
			
					**/
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("AVAIL_QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("AVAIL_QTY",""+new Double(avail_qty).intValue());
					}
				}
				System.out.println("At 105 = >");
					hmRecord.put("ALLOW_DECIMALS_YN",allow_decimals_yn);

				if (iTxn_qty>(iCount+avail_qty)) {
					iCount+=avail_qty;
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("QTY",""+new Double(avail_qty).intValue());
					}
					System.out.println("At 115 = >");
					alReturn.add(hmRecord);
				}
				else{
					avail_qty=	iTxn_qty-iCount;
					iCount+=avail_qty;
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("QTY",""+new Double(avail_qty).intValue());
					}
					alReturn.add(hmRecord);
					 System.out.println("At 126 = >");
					break;
				}
				System.out.println("At 128 = >");
			}
			System.out.println("iTxn_qty!=i = > "+iTxn_qty+" "+iCount);
		if(((!IncludeExpired1.equalsIgnoreCase("Y"))&&(!IncludeExpired2.equalsIgnoreCase("Y"))) || (!authorize_yn.equalsIgnoreCase("Y"))){//Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016
			if(iTxn_qty!=iCount){
				hmReturn.put("EXCEPTION",new InsufficientBatchException(new Double(iCount).intValue()));
				if (bVerifyInsufficientQty) {
					throw new InsufficientBatchException(new Double(iCount).intValue());
				}//Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016
				}
			}
		}
		catch (Exception exception) {
			System.out.println("Exception thrown from InsufficientBatchException = >"+exception.getMessage());
			exception.printStackTrace();
			throw exception;
		}
		System.out.println("hmReturn = > "+hmReturn);
		hmReturn.put("BATCH_DATA",alReturn);
		return hmReturn;
	}

	public HashMap getBatches(HashMap hmParameters, ArrayList alBatchDetails)throws Exception{
		
		String stItem_code				=	(String)hmParameters.get("ITEM_CODE");
		String stStore_code				=	(String)hmParameters.get("STORE_CODE");
		//int iTxn_qty					=	Integer.parseInt((String)hmParameters.get("TRN_QTY"));
	//	boolean bIncludeSuspended		=	checkForNull(((String)hmParameters.get("INCLUDE_SUSPENDED")),"FALSE").equals("TRUE"); Commented for unused variables IN063878
	//	boolean bIncludeExpired			=	checkForNull(((String)hmParameters.get("INCLUDE_EXPIRED")),"FALSE").equals("TRUE");Commented for unused variables IN063878
		String stCutOffDate				=	checkForNull((String)hmParameters.get("CUT_OFF_DATE"),"");
	//	boolean bVerifyInsufficientQty	=	checkForNull(((String)hmParameters.get("VERIFY_INSUFFICIENT_QTY")),"TRUE").equals("TRUE");

	//	int iCount		=	0;
		int no_of_decimals=getNoOfDecimals();
		String allow_decimals_yn=getAllowDecimalsYN(stItem_code);

		String p_barcode_id =  checkForNull((String)hmParameters.get("BARCODE_ID"),"%");//added by Ganga for PH barcode Thursday, November 29, 2012
		//Added by suresh.r against ML-BRU-SCF-1005[IN:43173]  on 28-04-2014 not to show batches based on below condition beg
		//HashMap alRecord	=	null;
		//String process_supend_batch_yn = "";
		//String process_expired_items_yn = "";
		//String use_after_expiry_yn = "";
		String IncludeExpired	= "N";
		String IncludeSuspended	= "N";
		//Added by suresh.r against ML-BRU-SCF-1005[IN:43173]  on 28-04-2014 end
	
		HashMap hmReturn	= new HashMap();
		ArrayList alReturn	= new ArrayList();
		ArrayList alParameters	=	new ArrayList();		
		ArrayList alRecords	=null;
		HashMap hmRecord	=null;
		try {
			
			//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 beg
             //Commented by Rabbani #49131(ML-BRU-SCF-1005.1) on 15-MAY-2014
			/*String []stparameters = {stItem_code,stStore_code,getLoginById()};
		
			alRecord = (HashMap)fetchRecord(getStRepositoryValue("SQL_ST_BATCH_SEARCH_PROCESS_YN"),stparameters);
			process_supend_batch_yn = checkForNull((String)alRecord.get("PROCESS_SUSPENDED_ITEMS_YN"));
			process_expired_items_yn = checkForNull((String)alRecord.get("PROCESS_EXPIRED_ITEMS_YN"));
			use_after_expiry_yn = checkForNull((String)alRecord.get("USE_AFTER_EXPIRY_YN"));
					
			if(process_expired_items_yn.equals("N") || use_after_expiry_yn.equals("N")){ 
				IncludeExpired = "N";
			}
			
			if(process_supend_batch_yn.equals("N")){
				IncludeSuspended = "N";
			}*/
			//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 end
			
			for (int j=0; j<alBatchDetails.size(); j++) {
				alParameters.clear();
				alParameters.add(stItem_code);
				alParameters.add(stStore_code);
				//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 beg
				/*alParameters.add((bIncludeSuspended)?"Y":"N");
				alParameters.add((bIncludeExpired)?"Y":"N");*/
				alParameters.add(IncludeSuspended);
				alParameters.add(IncludeExpired);
				//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 end
				alParameters.add(stCutOffDate);
				alParameters.add(((ArrayList)alBatchDetails.get(j)).get(0));
				alParameters.add(((ArrayList)alBatchDetails.get(j)).get(1));
				alParameters.add(((ArrayList)alBatchDetails.get(j)).get(2));
				alParameters.add(getLanguageId());
				alParameters.add(getLanguageId());
				alParameters.add(getLanguageId());
				alParameters.add(p_barcode_id);

				alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_BATCH_SEARCH_VIEW_SELECT_BATCH_FOR_PH"),alParameters);

				for (int i=0;i<alRecords.size();i++ ) {
					hmRecord	=	(HashMap)alRecords.get(i);
					/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin

					**/
					double avail_qty		=	Double.parseDouble((String)hmRecord.get("AVAIL_QTY"));
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("QTY",""+new Double(avail_qty).intValue());
					}
					hmRecord.put("ALLOW_DECIMALS_YN",allow_decimals_yn);
					/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end

					**/

					/** @ before modification **/
				//	int avail_qty		=	Integer.parseInt((String)hmRecord.get("AVAIL_QTY"));
					
					
					alReturn.add(hmRecord);
				}
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
		hmReturn.put("BATCH_DATA",alReturn);
		return hmReturn;
	}



	public HashMap getBatchesforBarcode(HashMap hmParameters)throws Exception{
		
		StringTokenizer st = new StringTokenizer((String)hmParameters.get("ITEM_CODE"), "=");
		String stItem_code  ="";
		String stTrade_code ="";
		while (st.hasMoreTokens()) {
			 stItem_code = st.nextToken();
			 if (st.hasMoreTokens())
			 {
 			 stTrade_code = st.nextToken();
			 }
		}

		
		String stStore_code				=	(String)hmParameters.get("STORE_CODE");
		String stBatch_id				=	(String)hmParameters.get("BATCH_ID");
		String stExpiry_date			=	(String)hmParameters.get("EXPIRY_DATE");
		String barcode_2d_app_yn	    =	(String)hmParameters.get("BARCODE_2D_APPLICABLE_YN");//Added for MMS-DM-CRF-0174.6
		String item_2d_barcode			=	(String)hmParameters.get("BARCODE_2D");//Added for MMS-DM-CRF-0174.6
		//String stBin_location_code		=	(String)hmParameters.get("BIN_LOCATION_CODE");
		
		double iTxn_qty					=	0.0;
	
		if(hmParameters.get("TRN_QTY")!=null)
			iTxn_qty					=	(Double.parseDouble((String)hmParameters.get("TRN_QTY"))); 
		
	//	boolean bIncludeSuspended		=	checkForNull(((String)hmParameters.get("INCLUDE_SUSPENDED")),"FALSE").equals("TRUE"); Commented for unused variables IN063878
	//	boolean bIncludeExpired			=	checkForNull(((String)hmParameters.get("INCLUDE_EXPIRED")),"FALSE").equals("TRUE"); Commented for unused variables IN063878
		String stCutOffDate				=	checkForNull((String)hmParameters.get("CUT_OFF_DATE"),"");
		boolean bVerifyInsufficientQty	=	checkForNull(((String)hmParameters.get("VERIFY_INSUFFICIENT_QTY")),"TRUE").equals("TRUE");
		//Added by suresh.r against ML-BRU-SCF-1005[IN:43173]  on 28-04-2014 not to show batches based on below condition beg
		//HashMap alRecord	=	null;
		//String process_supend_batch_yn = "";
		//String process_expired_items_yn = "";
		//String use_after_expiry_yn = "";
		String IncludeExpired	= "N";
		String IncludeSuspended	= "N";
		//Added by suresh.r against ML-BRU-SCF-1005[IN:43173]  on 28-04-2014 end

		System.out.println("iTxn_qty => "+iTxn_qty+" stStore_code = > "+stStore_code);
		

		 double iBalAlreadyUsedQty = Double.parseDouble(checkForNull((String)hmParameters.get("ALREADY_USED_QTY"),"0"));
		 String stMinExpDate = checkForNull((String)hmParameters.get("MIN_EXP_DATE"),stCutOffDate);
 		
		int no_of_decimals=getNoOfDecimals();
		String allow_decimals_yn=getAllowDecimalsYN(stItem_code);
	
		double iCount		=	0;
		
		HashMap hmReturn	= new HashMap();
		HashMap hmRecord	=	null;
		ArrayList alReturn	= new ArrayList();
		try { 
			
			//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 beg
			//Commented by Rabbani #49131(ML-BRU-SCF-1005.1) on 15-MAY-2014
			/*String []stparameters = {stItem_code,stStore_code,getLoginById()};		
			alRecord = (HashMap)fetchRecord(getStRepositoryValue("SQL_ST_BATCH_SEARCH_PROCESS_YN"),stparameters);
			process_supend_batch_yn = checkForNull((String)alRecord.get("PROCESS_SUSPENDED_ITEMS_YN"));
			process_expired_items_yn = checkForNull((String)alRecord.get("PROCESS_EXPIRED_ITEMS_YN"));
			use_after_expiry_yn = checkForNull((String)alRecord.get("USE_AFTER_EXPIRY_YN"));
					
			if(process_expired_items_yn.equals("N") || use_after_expiry_yn.equals("N")){ 
				IncludeExpired = "N";
			}
			
			if(process_supend_batch_yn.equals("N")){
				IncludeSuspended = "N";
			}*/
			//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 end
			
			ArrayList alParameters	=	new ArrayList(4);
			alParameters.add(stItem_code);
			alParameters.add(stStore_code);
			//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 beg
			/*alParameters.add((bIncludeSuspended)?"Y":"Y");
			alParameters.add((bIncludeExpired)?"Y":"Y");*/
			alParameters.add(IncludeSuspended);
			alParameters.add(IncludeExpired);
			//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014 end
			alParameters.add(stMinExpDate);
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(stTrade_code);
			alParameters.add(stBatch_id);
			alParameters.add(stExpiry_date);

			System.out.println("alParameters = > "+alParameters);
			ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_BATCH_SEARCH_VIEW_SELECT_FOR_BARCODE"),alParameters);

			System.out.println("alRecords = > "+alRecords);
			for (int i=0;i<alRecords.size();i++ ) {
				hmRecord	=	(HashMap)alRecords.get(i);
				double avail_qty		=	 Double.parseDouble((String)hmRecord.get("AVAIL_QTY"));
               if(barcode_2d_app_yn.equals("Y"))//Added for MMS-DM-CRF-0174.6
				hmRecord.put("BARCODE_ID",item_2d_barcode);

				System.out.println("iBalAlreadyUsedQty = > "+iBalAlreadyUsedQty+" avail_qty = > "+avail_qty);
				if(iBalAlreadyUsedQty >= avail_qty){
					iBalAlreadyUsedQty -= avail_qty;
					continue;
				}
				else{
					avail_qty -= iBalAlreadyUsedQty;
					iBalAlreadyUsedQty = 0;

					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("AVAIL_QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("AVAIL_QTY",""+new Double(avail_qty).intValue());
					}
				}
				System.out.println("At 105 = >");
					hmRecord.put("ALLOW_DECIMALS_YN",allow_decimals_yn);

				if (iTxn_qty>(iCount+avail_qty)) {
					iCount+=avail_qty;
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("QTY",""+new Double(avail_qty).intValue());
					}
					System.out.println("At 115 = >");
					alReturn.add(hmRecord);
				}
				else{
					avail_qty=	iTxn_qty-iCount;
					iCount+=avail_qty;
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("QTY",""+new Double(avail_qty).intValue());
					}
					alReturn.add(hmRecord);
					 System.out.println("At 126 = >");
					break;
				}
				System.out.println("At 128 = >");
			}
			System.out.println("iTxn_qty!=i = > "+iTxn_qty+" "+iCount);
			if(iTxn_qty!=iCount){
				hmReturn.put("EXCEPTION",new InsufficientBatchException(new Double(iCount).intValue()));
				if (bVerifyInsufficientQty) {
					throw new InsufficientBatchException(new Double(iCount).intValue());
				}
			}
		}
		catch (Exception exception) {
			System.out.println("Exception thrown from InsufficientBatchException = >"+exception.getMessage());
			exception.printStackTrace();
			throw exception;
		}
		System.out.println("hmReturn = > "+hmReturn);
		hmReturn.put("BATCH_DATA",alReturn);
		System.out.println("hmReturn = > "+hmReturn);
		return hmReturn;
	}
	//Added against IN:062242 starts
	public HashMap getAllBatches(HashMap hmParameters) throws Exception{
		StringTokenizer st = new StringTokenizer((String)hmParameters.get("ITEM_CODE"), "=");
		String stItem_code  ="";
		String stTrade_code ="";
		String authorize_yn = "N";
		while (st.hasMoreTokens()) {
			 stItem_code = st.nextToken();
			 if (st.hasMoreTokens())
			 {
				 stTrade_code = st.nextToken();
			 }		
		}
		String stStore_code				=	(String)hmParameters.get("STORE_CODE");
		authorize_yn				=	checkForNull(((String)hmParameters.get("AUTHORIZE_YN")),"N");
		String user = getLoginById();
		ArrayList alParameters1	=	new ArrayList(4);		
		alParameters1.add(stStore_code);
		alParameters1.add(user);
		String IncludeExpired1 =		checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_BATCH_EXPIRED_USER_ACCESS"),alParameters1).get("PROCESS_EXPIRED_ITEMS_YN"));
		String IncludeExpired2 =		checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_BATCH_EXPIRED_OR_NOT"),stItem_code).get("USE_AFTER_EXPIRY_YN"));
		double iTxn_qty					=	0.0;
		if(hmParameters.get("TRN_QTY")!=null)
			iTxn_qty					=	(Double.parseDouble((String)hmParameters.get("TRN_QTY"))); 
	//	boolean bIncludeSuspended		=	checkForNull(((String)hmParameters.get("INCLUDE_SUSPENDED")),"FALSE").equals("TRUE"); Commented for unused variables IN063878
	//	boolean bIncludeExpired			=	checkForNull(((String)hmParameters.get("INCLUDE_EXPIRED")),"FALSE").equals("TRUE"); Commented for unused variables IN063878
	//	System.out.println("bIncludeExpired => "+bIncludeExpired); 
		//String stCutOffDate				=	checkForNull((String)hmParameters.get("CUT_OFF_DATE"),"");//commented for 15757
		boolean bVerifyInsufficientQty	=	checkForNull(((String)hmParameters.get("VERIFY_INSUFFICIENT_QTY")),"TRUE").equals("TRUE");
		 double iBalAlreadyUsedQty = Double.parseDouble(checkForNull((String)hmParameters.get("ALREADY_USED_QTY"),"0"));
	//	 String stMinExpDate = checkForNull((String)hmParameters.get("MIN_EXP_DATE"),stCutOffDate); Commented for unused variables IN063878
		/** @ 
			CRF_SRR20056-CRF-0537.1 
			For handle the Decimals in QOH, avail_Qty Modifications 
			
			**/
		int no_of_decimals=getNoOfDecimals();
		String allow_decimals_yn=getAllowDecimalsYN(stItem_code);
		String p_barcode_id =  checkForNull((String)hmParameters.get("BARCODE_ID"),"%");
		double iCount		=	0;
		HashMap hmReturn	= new HashMap();
		HashMap hmRecord	=	null;
		ArrayList alReturn	= new ArrayList();
		try { 
			ArrayList alParameters	=	new ArrayList(4);
			alParameters.add(stItem_code);
			alParameters.add(stStore_code);
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(stTrade_code);
			alParameters.add(p_barcode_id);
			System.out.println("alParameters = > "+alParameters);
			ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_BATCH_SEARCH_VIEW_ALL_BATCH"),alParameters);
			System.out.println("alRecords getAllBatches= > "+alRecords);
			for (int i=0;i<alRecords.size();i++ ) {
				hmRecord	=	(HashMap)alRecords.get(i);
				double avail_qty		=	 Double.parseDouble((String)hmRecord.get("AVAIL_QTY"));
				/** @ 
					CRF_SRR20056-CRF-0537.1 
					For handle the Decimals in QOH, avail_Qty Modifications 
			
				**/
				System.out.println("iBalAlreadyUsedQty = > "+iBalAlreadyUsedQty+" avail_qty = > "+avail_qty);
				if(iBalAlreadyUsedQty >= avail_qty){
					iBalAlreadyUsedQty -= avail_qty;
					continue;
				}
				else{
					avail_qty -= iBalAlreadyUsedQty;
					iBalAlreadyUsedQty = 0;
					/** @ 
						CRF_SRR20056-CRF-0537.1 
						For handle the Decimals in QOH, avail_Qty Modifications 
			
					**/
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("AVAIL_QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("AVAIL_QTY",""+new Double(avail_qty).intValue());
					}
				}
				System.out.println("At 105 = >");
					hmRecord.put("ALLOW_DECIMALS_YN",allow_decimals_yn);
				if (iTxn_qty>(iCount+avail_qty)) {
					iCount+=avail_qty;
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("QTY",""+new Double(avail_qty).intValue());
					}
					System.out.println("At 115 = >");
					alReturn.add(hmRecord);
				}
				else{
					avail_qty=	iTxn_qty-iCount;
					iCount+=avail_qty;
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("QTY",""+new Double(avail_qty).intValue());
					}
					alReturn.add(hmRecord);
					 System.out.println("At 126 = >");
					break;
				}
				System.out.println("At 128 = >");
			}
			System.out.println("iTxn_qty!=i = > "+iTxn_qty+" "+iCount);
		if(((!IncludeExpired1.equalsIgnoreCase("Y"))&&(!IncludeExpired2.equalsIgnoreCase("Y"))) || (!authorize_yn.equalsIgnoreCase("Y"))){
			if(iTxn_qty!=iCount){
				hmReturn.put("EXCEPTION",new InsufficientBatchException(new Double(iCount).intValue()));
				if (bVerifyInsufficientQty) {
					throw new InsufficientBatchException(new Double(iCount).intValue());
				}
			}
			}
		}
		catch (Exception exception) {
			System.out.println("Exception thrown from InsufficientBatchException = >"+exception.getMessage());
			exception.printStackTrace();
			throw exception;
		}
		System.out.println("hmReturn = > "+hmReturn);
		hmReturn.put("BATCH_DATA",alReturn);
		return hmReturn;
	}
		//Added against IN:062242 ends
		public HashMap get2DBarcodeDetails(HashMap hmParameters)throws Exception{//Added for MMS-DM-CRF-0174.5
		
		StringTokenizer st = new StringTokenizer((String)hmParameters.get("ITEM_CODE"), "=");
		String stItem_code  ="";
		String stTrade_code ="";
		String IncludeExpired	= "N";
		String IncludeSuspended	= "N";
		String authorize_yn = "N";
		String sql_str = "";//Added for MOHE-CRF-0167
		while (st.hasMoreTokens()) {
			 stItem_code = st.nextToken();
			 if (st.hasMoreTokens())
			 {
 			 stTrade_code = st.nextToken();
			 }		
		}

		
		String stStore_code				=	(String)hmParameters.get("STORE_CODE");
				
		authorize_yn				=	checkForNull(((String)hmParameters.get("AUTHORIZE_YN")),"N");
		String trn_type 			=	checkForNull(((String)hmParameters.get("TRN_TYPE")),"");
		String user = getLoginById();
		ArrayList alParameters1	=	new ArrayList(4);		
		alParameters1.add(stStore_code);
		alParameters1.add(user);
		String IncludeExpired1 =		checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_BATCH_EXPIRED_USER_ACCESS"),alParameters1).get("PROCESS_EXPIRED_ITEMS_YN"));
		String IncludeExpired2 =		checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_BATCH_EXPIRED_OR_NOT"),stItem_code).get("USE_AFTER_EXPIRY_YN"));
		double iTxn_qty					=	0.0;
		if(hmParameters.get("TRN_QTY")!=null)
			iTxn_qty					=	(Double.parseDouble((String)hmParameters.get("TRN_QTY"))); 
		
	
		String stCutOffDate				=	checkForNull((String)hmParameters.get("CUT_OFF_DATE"),"");
		boolean bVerifyInsufficientQty	=	checkForNull(((String)hmParameters.get("VERIFY_INSUFFICIENT_QTY")),"TRUE").equals("TRUE");


		System.out.println("iTxn_qty => "+iTxn_qty+" stStore_code = > "+stStore_code);
		
		 double iBalAlreadyUsedQty = Double.parseDouble(checkForNull((String)hmParameters.get("ALREADY_USED_QTY"),"0"));
		 String stMinExpDate = checkForNull((String)hmParameters.get("MIN_EXP_DATE"),stCutOffDate);
		
		int no_of_decimals=getNoOfDecimals();
		String allow_decimals_yn=getAllowDecimalsYN(stItem_code);

		String p_barcode_id =  checkForNull((String)hmParameters.get("BARCODE_ID"),"%");

		double iCount		=	0;
		
		HashMap hmReturn	= new HashMap();
		HashMap hmRecord	=	null;
		ArrayList alReturn	= new ArrayList();
		HashMap BatchDetails = new HashMap();
        
		try { 
			
			 // Regular expressions for extracting the GTIN, expiry date, and batch ID
       

        String gtin = null;
        String batchNumber = null;
        String expiryDate = null;
		String srlNo      =null;
		        BatchDetails =getBarcodedetails(p_barcode_id);
				gtin =(String)BatchDetails.get("GTIN");
				expiryDate =(String)BatchDetails.get("EXPIRY_DATE");
				batchNumber =(String)BatchDetails.get("BATCH_ID");
				srlNo =(String)BatchDetails.get("SRLNO");

        
          SimpleDateFormat inputFormat = new SimpleDateFormat("yymmdd");
		  SimpleDateFormat outputFormat = new SimpleDateFormat("dd/mm/yyyy");
		  java.util.Date inputDate = inputFormat.parse(expiryDate); 

		  String temp_exp_date = outputFormat.format(inputDate);

		  if(!getCustomerID().equals("ALMO"))
		      sql_str  = " AND EXPIRY_DATE=to_date(?,'dd/mm/yyyy') ";//Adding end for MOHE-CRF-0167


            System.out.println("new GTIN: " + gtin);
            //System.out.println("new Expiry Date: " + expiryDate+"temp_exp_date=="+temp_exp_date);
            System.out.println("new Batch ID: " + batchNumber);
		
			ArrayList alParameters	=	new ArrayList(4);
			alParameters.add(checkForNull(stItem_code));
			alParameters.add(checkForNull(stStore_code));
			alParameters.add(checkForNull(gtin));
			alParameters.add(checkForNull(batchNumber));
		if(!getCustomerID().equals("ALMO"))
            alParameters.add(checkForNull(temp_exp_date));
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(checkForNull(stTrade_code));

			ArrayList alRecords	=	fetchRecords("SELECT item_code,	item_desc, suspended_yn, store_code, store_desc, trade_id_applicable_yn,  batch_id,	TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date, bin_location_code, bin_desc,	trade_id, trade_name, qty_on_hand, nod,	 manufacturer_id, manufacturer_name, avail_qty,	expiry_yn, use_after_expiry_yn,BATCH_STATUS,BARCODE_ID FROM	ST_BATCH_SEARCH_LANG_VIEW ST_BATCH_SEARCH_LANG_VIEW WHERE	ITEM_CODE=?	AND	STORE_CODE=? AND MANUFACTURER_ID =? AND BATCH_ID = ? "+sql_str+" AND AVAIL_QTY>0 AND LANGUAGE_ID =? AND LANG1 =? AND LANG2 = ? AND TRADE_ID = NVL(?,TRADE_ID)  ORDER BY	 TO_DATE(EXPIRY_DATE,'DD/MM/YYYY'), BIN_LOCATION_CODE, BATCH_ID",alParameters);


		//	System.out.println("alRecords = > "+alRecords);
			if(alRecords.size()==0 && IncludeExpired1.equalsIgnoreCase("N") && trn_type.equals("CON")){
				throw new Exception("EXPIRED_BATCH");
			}
			for (int i=0;i<alRecords.size();i++ ) {
				hmRecord	=	(HashMap)alRecords.get(i);
				double avail_qty		=	 Double.parseDouble((String)hmRecord.get("AVAIL_QTY"));
				
				if(iBalAlreadyUsedQty >= avail_qty){
					iBalAlreadyUsedQty -= avail_qty;
					continue;
				}
				else{
					avail_qty -= iBalAlreadyUsedQty;
					iBalAlreadyUsedQty = 0;
					
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("AVAIL_QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("AVAIL_QTY",""+new Double(avail_qty).intValue());
					}
				}
				System.out.println("At 105 = >");
					hmRecord.put("ALLOW_DECIMALS_YN",allow_decimals_yn);
					 hmRecord.put("BARCODE_ID",p_barcode_id);

				if (iTxn_qty>(iCount+avail_qty)) {
					iCount+=avail_qty;
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("QTY",""+new Double(avail_qty).intValue());
					}
					System.out.println("At 115 = >");
					alReturn.add(hmRecord);
				}
				else{
					avail_qty=	iTxn_qty-iCount;
					iCount+=avail_qty;
					if(allow_decimals_yn.equals("Y")){
					hmRecord.put("QTY",setNumber(""+avail_qty,no_of_decimals));
					}else{
					hmRecord.put("QTY",""+new Double(avail_qty).intValue());
					}
                  
					alReturn.add(hmRecord);
					break;
				}
			}
		
			}
		catch (Exception exception) {
			System.out.println("Exception thrown from InsufficientBatchException = >"+exception.getMessage());
			exception.printStackTrace();
			throw exception;
		}
		System.out.println("hmReturn = @@ utills file ===> "+alReturn);
		hmReturn.put("BATCH_DATA",alReturn);
		return hmReturn;
	}
      
}
